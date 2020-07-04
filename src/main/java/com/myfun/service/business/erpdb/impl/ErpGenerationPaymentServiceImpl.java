package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminGenerationTaskMsgMapper;
import com.myfun.repository.admindb.po.AdminGenerationTaskMsg;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunGenerationPaymentService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpGenerationPaymentServiceImpl extends AbstractService<ErpFunGenerationPayment, ErpFunGenerationPayment> implements ErpFunGenerationPaymentService {

	@Autowired
	ErpFunGenerationPaymentMapper erpFunGenerationPaymentMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunTaskService erpFunTaskService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ErpFunGenerationPaymentClassMapper erpFunGenerationPaymentClassMapper;
	@Autowired
	AdminGenerationTaskMsgMapper adminGenerationTaskMsgMapper;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunWageLogMapper erpFunWageLogMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunGenerationPaymentMapper;
	}

	@Transactional
	@Override
	public Integer addGenerationPayment(Integer cityId, Integer compId, Integer userId, String userName, ErpFunGenerationPaymentParam param) {
		// 一级一级的判断
		if(null == param.getCompAmount()) {
			param.setCompAmount(new BigDecimal(0));
		}
		if(null == param.getPersonAmount()) {
			param.setPersonAmount(new BigDecimal(0));
		}

		// 写任务
        Set<Integer> userList = new HashSet<>();
        // 查询员工List
        List<ErpFunUsers> userListByUserIds = new ArrayList<>();
        if(StringUtils.isNotBlank(param.getUserIds())) {
            List<String> userIdStrList = Arrays.asList(param.getUserIds().split(","));
            userList = userIdStrList.stream().map(Integer::valueOf).collect(Collectors.toSet());
            userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userList);
            param.setUserIdList(userList);
            if(userList.size() == 0) {
                return 1;
            }
        } else {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			ErpFunUsersExample.Criteria criteria = erpFunUsersExample.createCriteria();

			if(null != param.getDeptId()) {
				criteria.andDeptIdEqualTo(param.getDeptId());
			}
			if (null != param.getGrId()) {
				criteria.andGrIdEqualTo(param.getGrId());
			}
			if (StringUtil.isNotBlank(param.getUserPosition())) {
				criteria.andUserPositionEqualTo(param.getUserPosition());
			}
			if (null != param.getUserId()) {
				criteria.andUserIdEqualTo(param.getUserId());
			}
			if (null != param.getOrganizationId() && param.getOrganizationId() > 0) {
				criteria.andTissueLineLike("%:" + param.getOrganizationId() + ":%");
			}
			criteria.andCompIdEqualTo(compId);
			userListByUserIds = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		}

		if(param.getNewOrganization()) {
			erpFunGenerationPaymentMapper.insertBatchNewOrg(cityId, compId, userId, param);
		} else {
			erpFunGenerationPaymentMapper.insertBatch(cityId, compId, userId, param);
		}
		final  ErpFunGenerationPaymentClass  erpFunGenerationPaymentClass = erpFunGenerationPaymentClassMapper.getClassById(cityId, param.getGenerationPaymentClass());
		if(null == erpFunGenerationPaymentClass) {
			return 1;
		}

		// 处理门店ID
		Map<Integer, List<ErpFunUsers>> userListByDeptId = userListByUserIds.stream().collect(Collectors.groupingBy(ErpFunUsers::getDeptId));
		// 查询门店数据
		Set<Integer> deptIdSet = userListByDeptId.keySet();
		List<ErpFunDepts> deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdSet);
		// 门店Map
		Map<Integer, ErpFunDepts> deptsMap = deptListByDeptIds.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));
		// 查询管理范围的人
		ErpFunUserManageRangeExample example = new ErpFunUserManageRangeExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andRangeTypeEqualTo(4).andRangeIdIn(new ArrayList<>(deptIdSet));
		List<ErpFunUserManageRange> erpFunUserManageRanges = erpFunUserManageRangeMapper.selectByExample(example);
		// 需要通知的人的数据
		Map<Integer, List<ErpFunUserManageRange>> manageRangeByRangeId = erpFunUserManageRanges.stream().collect(Collectors.groupingBy(ErpFunUserManageRange::getRangeId));

		deptIdSet.stream().forEach(deptId-> {
			// 代扣门店
			ErpFunDepts erpFunDepts = deptsMap.get(deptId);
			// 代扣金额
			BigDecimal totalAmount = param.getCompAmount().multiply(new BigDecimal(userListByDeptId.get(deptId).size()));
			// 提醒目标
			List<ErpFunUserManageRange> erpFunUserManageRangesList = manageRangeByRangeId.get(deptId);
			if(null != erpFunUserManageRangesList && erpFunUserManageRangesList.size() > 0) {
				Set<Integer> warmUserList = erpFunUserManageRangesList.stream().collect(Collectors.mapping(ErpFunUserManageRange::getUserId, Collectors.toSet()));
				createGenerationTask(cityId, compId, erpFunDepts.getDeptName(), totalAmount, erpFunGenerationPaymentClass.getClassName(), warmUserList);
			}
		});

		List<Integer> userIdList = userListByUserIds.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
		if(userIdList.size() > 0) {
			// 写薪资日志

			Map<Integer, ErpFunUsers> usersMap = userListByUserIds.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));
			
	        List<ErpFunWage> erpFunWageList = new ArrayList<>();
	        //数据量太大，循环查询
	        int step = 1000;
	        if (userIdList.size() > 0) {
				for (int i = 0; i < userIdList.size(); i += step) {
					List<Integer> erpUserIdFloors = userIdList.stream().skip(i).limit(step).collect(Collectors.toList());
					if (erpUserIdFloors.size() > 0) {
						ErpFunWageExample erpFunWageExample = new ErpFunWageExample();
				        erpFunWageExample.setShardCityId(cityId);
				        erpFunWageExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(erpUserIdFloors).andAssessmentMonthEqualTo(param.getAssessmentMonth());
						List<ErpFunWage> erpFunWages = erpFunWageMapper.selectByExample(erpFunWageExample);
						if (erpFunWages.size() > 0) {
							erpFunWageList.addAll(erpFunWages);
						}
					}
				}
			}
			
			/*ErpFunWageExample erpFunWageExample = new ErpFunWageExample();
			erpFunWageExample.setShardCityId(cityId);
			erpFunWageExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIdList).andAssessmentMonthEqualTo(param.getAssessmentMonth());
			List<ErpFunWage> erpFunWages = erpFunWageMapper.selectByExample(erpFunWageExample);
			Map<Integer, ErpFunWage> wageMap = erpFunWages.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));*/
			
			Map<Integer, ErpFunWage> wageMap = erpFunWageList.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));
			userIdList.stream().forEach(uId-> {
				ErpFunWageLog erpFunWageLog = new ErpFunWageLog();
				Integer logType = 2;
				String content = erpFunGenerationPaymentClass.getClassName() +" "+ param.getPersonAmount() +"元";
				erpFunWageLog.setReduceWage(param.getPersonAmount());
				erpFunWageLog.setLogType(logType);
				if(StringUtils.isNotBlank(param.getRemarks())) {
					content += " 备注：" + param.getRemarks();
				}
				erpFunWageLog.setExplain(content);
				erpFunWageLog.setCompId(compId);
				erpFunWageLog.setShardCityId(cityId);
				ErpFunWage erpFunWage = wageMap.get(uId);
				if(null != erpFunWage) {
					erpFunWageLog.setWageId(erpFunWage.getWageId());
				}
				erpFunWageLog.setWageUserId(uId);
				erpFunWageLog.setUserId(userId);
				erpFunWageLog.setUpdateTime(new Date());
				erpFunWageLog.setIsDel((byte) 0);
				erpFunWageLog.setUserName(userName);

				ErpFunUsers erpFunUsers = usersMap.get(userId);
				if(null != erpFunUsers) {
					erpFunWageLog.setAreaId(erpFunUsers.getAreaId());
					erpFunWageLog.setRegId(erpFunUsers.getRegId());
					erpFunWageLog.setDeptId(erpFunUsers.getDeptId());
					erpFunWageLog.setGrId(erpFunUsers.getGrId());
				}
				erpFunWageLogMapper.insertSelective(erpFunWageLog);
			});
		}

		return 1;
	}

	/**
	 * 批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@Transactional
	@Override
	public Integer importGenerationPayment(Integer cityId, Integer compId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		String generationPaymentListJson=erpFunGenerationPaymentParam.getGenerationPaymentListJson();
		Integer index = 0;
		Set<Integer> userList = new HashSet<>();
		List<ErpFunUsers> userListByUserIds = new ArrayList<>();

		Set<Integer> generationPaymentClassList = new HashSet<>();
		List<ErpFunGenerationPaymentClass> erpFunGenerationPaymentClassList = new ArrayList<>();

		if (generationPaymentListJson!=null){
			List<ErpFunGenerationPayment> list = JSON.parseArray(generationPaymentListJson, ErpFunGenerationPayment.class);
			userList=list.stream().collect(Collectors.mapping(ErpFunGenerationPayment::getUserId,Collectors.toSet()));
			userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userList);
			if (userListByUserIds.size()==0){
				return index;
			}
			Map<Integer,ErpFunUsers> erpFunUsersMap=userListByUserIds.stream().collect(Collectors.toMap(ErpFunUsers::getUserId,val->val));
			// 处理门店ID
			Map<Integer, List<ErpFunUsers>> userListByDeptId = userListByUserIds.stream().collect(Collectors.groupingBy(ErpFunUsers::getDeptId));
			// 查询门店数据
			Set<Integer> deptIdSet = userListByDeptId.keySet();
			List<ErpFunDepts> deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdSet);
			// 门店Map
			Map<Integer, ErpFunDepts> deptsMap = deptListByDeptIds.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));
			//代缴代扣的类别
			generationPaymentClassList=list.stream().collect(Collectors.mapping(ErpFunGenerationPayment::getGenerationPaymentClass,Collectors.toSet()));
			erpFunGenerationPaymentClassList=erpFunGenerationPaymentClassMapper.getClassByIds(cityId,generationPaymentClassList);
			Map<Integer,ErpFunGenerationPaymentClass> erpFunGenerationPaymentClassMap=erpFunGenerationPaymentClassList.stream().collect(Collectors.toMap(ErpFunGenerationPaymentClass::getId,val->val));

			for (ErpFunGenerationPayment erpFunGenerationPayment:list){
				ErpFunUsers erpFunUsers=erpFunUsersMap.get(erpFunGenerationPayment.getUserId());
				ErpFunGenerationPaymentClass erpFunGenerationPaymentClass=erpFunGenerationPaymentClassMap.get(erpFunGenerationPayment.getGenerationPaymentClass());
				if (erpFunUsers==null){
					continue;
				}
				//非本公司不导入
				if (!erpFunUsers.getCompId().equals(compId)){
					continue;
				}
				if (erpFunGenerationPaymentClass==null){
					throw new BusinessException("代扣代缴类别不存在");
				}

				erpFunGenerationPayment.setCreateUid(userId);
				erpFunGenerationPayment.setCreateTime(new Date());
				erpFunGenerationPayment.setShardCityId(cityId);
				erpFunGenerationPayment.setCompId(compId);
				erpFunGenerationPayment.setAreaId(erpFunUsers.getAreaId());
				erpFunGenerationPayment.setRegId(erpFunUsers.getRegId());
				erpFunGenerationPayment.setDeptId(erpFunUsers.getDeptId());
				erpFunGenerationPayment.setGrId(erpFunUsers.getGrId());
				erpFunGenerationPayment.setIsDel((byte)0);
				erpFunGenerationPaymentMapper.insertSelective(erpFunGenerationPayment);

				BigDecimal totalAmount = erpFunGenerationPayment.getCompAmount().multiply(new BigDecimal(userListByDeptId.get(erpFunUsers.getDeptId()).size()));
				// 代扣门店
				ErpFunDepts erpFunDepts = deptsMap.get(erpFunUsers.getDeptId());

				createGenerationTask(cityId, compId, erpFunDepts.getDeptName(), totalAmount, erpFunGenerationPaymentClass.getClassName(), userList);
				index++;
			}
		}
		return index;
	}

	private void createGenerationTask(Integer cityId, Integer compId,String deptName, BigDecimal totalAmount, String feeName, Set<Integer> warmUserList) {
		// 装修客户专用
		final  String taskSubject = Const.DIC_TASK_TYPE_GENERATION_REMIND_STR+ " " +deptName+"店 昨日支出"+ feeName +" "+totalAmount+"元";
		// 第二天9点
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, warmUserList);
		userListByUserIds.stream().forEach(erpFunUsers -> {
			AdminGenerationTaskMsg adminGenerationTaskMsg = new AdminGenerationTaskMsg();
			adminGenerationTaskMsg.setArchiveId(erpFunUsers.getArchiveId());
			adminGenerationTaskMsg.setCityId(cityId);
			adminGenerationTaskMsg.setCompId(compId);
			adminGenerationTaskMsg.setCreateTime(calendar.getTime());
			adminGenerationTaskMsg.setDeptId(erpFunUsers.getDeptId());
			adminGenerationTaskMsg.setMsgContent(taskSubject);
			adminGenerationTaskMsg.setUserId(erpFunUsers.getUserId());
			adminGenerationTaskMsgMapper.insertSelective(adminGenerationTaskMsg);
		});


	}

	/**
	 * @Title
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer addEditGenerationPayment(Integer cityId, Integer compId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		Integer res = 0;
		erpFunGenerationPaymentParam.setShardCityId(cityId);

		// 这个数据不处理
		erpFunGenerationPaymentParam.setAuditStatus(null);
		erpFunGenerationPaymentParam.setAuditTime(null);

		// 判断新增还是编辑
		if(null != erpFunGenerationPaymentParam.getId()) {
			erpFunGenerationPaymentParam.setUpdateTime(new Date());
			res = erpFunGenerationPaymentMapper.updateByPrimaryKeySelective(erpFunGenerationPaymentParam);
		}else {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunGenerationPaymentParam.getUserId());
			erpFunGenerationPaymentParam.setCompId(compId);
			erpFunGenerationPaymentParam.setAreaId(erpFunUsers.getAreaId());
			erpFunGenerationPaymentParam.setRegId(erpFunUsers.getRegId());
			erpFunGenerationPaymentParam.setDeptId(erpFunUsers.getDeptId());
			erpFunGenerationPaymentParam.setGrId(erpFunUsers.getGrId());
			erpFunGenerationPaymentParam.setCreateTime(new Date());
			erpFunGenerationPaymentParam.setCreateUid(userId);
			erpFunGenerationPaymentMapper.insertSelective(erpFunGenerationPaymentParam);
			res = erpFunGenerationPaymentParam.getId();
		}
		return res;
	}

	/**
	 * @Title 删除奖罚数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public Integer delGenerationPaymentInfo(Integer cityId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {

		String[] split = erpFunGenerationPaymentParam.getIds().split(",");
		List<Integer> idsList = new ArrayList<>();

		for (String s : split) {
			idsList.add(Integer.valueOf(s));
		}

		if(idsList.size() > 0) {
			ErpFunGenerationPayment erpFunGenerationPayment = new ErpFunGenerationPayment();

			erpFunGenerationPayment.setIsDel((byte) 1);
			erpFunGenerationPayment.setDelTime(new Date());
			erpFunGenerationPayment.setDelUid(userId);
			erpFunGenerationPayment.setUpdateTime(new Date());
			erpFunGenerationPayment.setUpdateUid(userId);
			ErpFunGenerationPaymentExample erpFunGenerationPaymentExample = new ErpFunGenerationPaymentExample();

			erpFunGenerationPaymentExample.setShardCityId(cityId);
			erpFunGenerationPaymentExample.createCriteria().andIdIn(idsList);

			return erpFunGenerationPaymentMapper.updateByExampleSelective(erpFunGenerationPayment, erpFunGenerationPaymentExample);

		}
		return 0;

	}

	/**
	 * @Title 审核
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public Integer auditGenerationPaymentInfo(Integer cityId, Integer userId, ErpFunGenerationPaymentParam erpFunGenerationPaymentParam) {
		String[] split = erpFunGenerationPaymentParam.getIds().split(",");
		List<Integer> idsList = new ArrayList<>();

		for (String s : split) {
			idsList.add(Integer.valueOf(s));
		}

		if (idsList.size() > 0) {
			ErpFunGenerationPayment funGenerationPayment = new ErpFunGenerationPayment();
			funGenerationPayment.setId(erpFunGenerationPaymentParam.getId());
			Byte auditStatus = erpFunGenerationPaymentParam.getAuditStatus();
			funGenerationPayment.setAuditTime(new Date());
			funGenerationPayment.setAuditUid(userId);
			funGenerationPayment.setAuditStatus(auditStatus);
			funGenerationPayment.setShardCityId(cityId);
			funGenerationPayment.setUpdateTime(new Date());

			ErpFunGenerationPaymentExample erpFunGenerationPaymentExample = new ErpFunGenerationPaymentExample();
			erpFunGenerationPaymentExample.setShardCityId(cityId);
			erpFunGenerationPaymentExample.createCriteria().andIdIn(idsList);
			return erpFunGenerationPaymentMapper.updateByExampleSelective(funGenerationPayment, erpFunGenerationPaymentExample);
		}
		return 0;
	}

	public static void main(String[] args) {
		List<ErpFunUsers> reslList = new ArrayList<>();
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setDeptId(1);
		erpFunUsers.setUserName("xxx");

		reslList.add(erpFunUsers);
		ErpFunUsers erpFunUsers2 = new ErpFunUsers();
		erpFunUsers2.setDeptId(2);
		erpFunUsers2.setUserName("yyy");
		reslList.add(erpFunUsers2);

		ErpFunUsers erpFunUsers3 = new ErpFunUsers();
		erpFunUsers3.setUserName("zzz");
		reslList.add(erpFunUsers3);

		// 处理门店ID
		Map<Integer, List<ErpFunUsers>> userListByDeptId = reslList.stream().collect(Collectors.groupingBy(ErpFunUsers::getDeptId));
		Set<Integer> integers = userListByDeptId.keySet();
		for (Integer deptId : integers) {
			List<ErpFunUsers> erpFunUsers1 = userListByDeptId.get(deptId);
			System.out.println(erpFunUsers1.get(0).getUserName());
			System.out.println("deptId//"+deptId);
			System.out.println("///");
		}
	}
}

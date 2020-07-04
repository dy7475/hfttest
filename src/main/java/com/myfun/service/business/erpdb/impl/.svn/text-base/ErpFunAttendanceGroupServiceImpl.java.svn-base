package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminServerErrorLogMapper;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.admindb.po.AdminServerErrorLog;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceGroupParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceGroupService;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunAttendanceGroupServiceImpl extends AbstractService<ErpFunAttendanceGroup, ErpFunAttendanceGroup> implements ErpFunAttendanceGroupService {

	@Autowired
	ErpFunAttendanceGroupMapper 			erpFunAttendanceGroupMapper;
	@Autowired
	ErpFunAttendanceGroupBizMapper 			erpFunAttendanceGroupBizMapper;
	@Autowired
	ErpFunAttendanceGroupBizPersonMapper 	erpFunAttendanceGroupBizPersonMapper;
	@Autowired
	ErpFunAttendanceFestivalMapper 			erpFunAttendanceFestivalMapper;
	@Autowired
	ErpFunUsersMapper 						erpFunUsersMapper;
	@Autowired
	ErpFunAttendanceUserClassDetailMapper 	erpFunAttendanceUserClassDetailMapper;
	@Autowired
	AdminServerErrorLogMapper adminServerErrorLogMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceGroupMapper;
	}


	/**
	 * @Title 删除考勤组
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	@Override
	public Integer delAttendanceGroupList(Integer cityId, Integer compId, Integer id) {

		// 判断是否有人应用
		ErpFunAttendanceGroupBizPersonExample erpFunAttendanceGroupBizPersonExample = new ErpFunAttendanceGroupBizPersonExample();

		erpFunAttendanceGroupBizPersonExample.setShardCityId(cityId);
		erpFunAttendanceGroupBizPersonExample.createCriteria().andAttGroupIdEqualTo(id).andIsDelEqualTo((byte) 0);
		List<ErpFunAttendanceGroupBizPerson> erpFunAttendanceGroupBizPeople = erpFunAttendanceGroupBizPersonMapper.selectByExample(erpFunAttendanceGroupBizPersonExample);

		if(erpFunAttendanceGroupBizPeople.size() > 0) {
			throw new BusinessException("当前考勤组正在使用中,无法删除");
		}

//		Set<Integer> collect = erpFunAttendanceGroupBizPeople.stream().collect(Collectors.mapping(ErpFunAttendanceGroupBizPerson::getId, Collectors.toSet()));
//		// 删除这些数据
//		ErpFunAttendanceGroupBizPersonExample example = new ErpFunAttendanceGroupBizPersonExample();
//		example.setShardCityId(cityId);
//		example.createCriteria().andIdIn(new ArrayList<>(collect));
//		ErpFunAttendanceGroupBizPerson person = new ErpFunAttendanceGroupBizPerson();
//		person.setIsDel((byte) 1);
//		person.setDelTime(new Date());
//		erpFunAttendanceGroupBizPersonMapper.updateByExampleSelective(person, example);
//
//		// 删除这些数据
//		ErpFunAttendanceGroupBizExample bizExample = new ErpFunAttendanceGroupBizExample();
//		bizExample.setShardCityId(cityId);
//		bizExample.createCriteria().andAttGroupIdEqualTo(id);
//		ErpFunAttendanceGroupBiz biz = new ErpFunAttendanceGroupBiz();
//		person.setIsDel((byte) 1);
//		person.setDelTime(new Date());
//		erpFunAttendanceGroupBizMapper.updateByExampleSelective(biz, bizExample);

		ErpFunAttendanceGroup erpFunAttendanceGroup = new ErpFunAttendanceGroup();
		erpFunAttendanceGroup.setIsDel((byte)1);
		erpFunAttendanceGroup.setId(id);
		erpFunAttendanceGroup.setShardCityId(cityId);
		erpFunAttendanceGroup.setDelTime(new Date());
		return erpFunAttendanceGroupMapper.updateByPrimaryKeySelective(erpFunAttendanceGroup);
	}

	/**
	 * @Title 新增编辑固定排版考勤组
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	@Override
	public Integer addEditAttendanceGroup(Integer cityId, Integer compId, Integer deptId, ErpFunAttendanceGroupParam param) {
		// 判断名字重复
		ErpFunAttendanceGroupExample erpFunAttendanceGroupExample = new ErpFunAttendanceGroupExample();
		ErpFunAttendanceGroupExample.Criteria criteria = erpFunAttendanceGroupExample.createCriteria();
		criteria.andGroupNameEqualTo(param.getGroupName()).andIsDelEqualTo((byte )0).andDeptIdEqualTo(deptId);
		erpFunAttendanceGroupExample.setShardCityId(cityId);

		if(null != param.getId()) {
			criteria.andIdNotEqualTo(param.getId());
		}
		int i = erpFunAttendanceGroupMapper.countByExample(erpFunAttendanceGroupExample);
		if(i > 0) {
			throw new BusinessException("考勤组名称不能重复");
		}
		// 1:更新考勤对象
		Integer groupId = updateAttendanceGroup(cityId, compId, deptId, param);
		if (groupId == null) {
			groupId = 0;
		}

		// 3：判断是否更新人员，如果更新了就更新吧
		if((null != param.getIsUpdateUser() && 1 == param.getIsUpdateUser().intValue())) {
			// 处理人员关联关系
			addEditAttendanceGroupBizAndPerson(cityId, compId, groupId, param);
		}

		// 排班制
		if(2 == param.getClassType().intValue()) {
			addEditAttendanceScheduleGroupDetail(cityId,compId, groupId,param);
		}else {

			// 2：更新特殊考勤日
			addEditAttendanceFestival(cityId, compId, groupId, param);
		}
		return groupId;
	}

	/**
	 * @Title 编辑新增考勤组关系
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	private void addEditAttendanceGroupBizAndPerson(Integer cityId, Integer compId, Integer groupId, ErpFunAttendanceGroupParam param) {

		// 判断需不需要删除以前的关系
		if(null != param.getId()) {
			ErpFunAttendanceGroupBizExample erpFunAttendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
			erpFunAttendanceGroupBizExample.setShardCityId(cityId);

			erpFunAttendanceGroupBizExample.createCriteria().andAttGroupIdEqualTo(param.getId()).andCompIdEqualTo(compId);

			ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz = new ErpFunAttendanceGroupBiz();
			erpFunAttendanceGroupBiz.setIsDel((byte)1);
			erpFunAttendanceGroupBiz.setDelTime(new Date());
			erpFunAttendanceGroupBizMapper.updateByExampleSelective(erpFunAttendanceGroupBiz, erpFunAttendanceGroupBizExample);

			ErpFunAttendanceGroupBizPersonExample erpFunAttendanceGroupBizPersonExample = new ErpFunAttendanceGroupBizPersonExample();
			erpFunAttendanceGroupBizPersonExample.setShardCityId(cityId);
			erpFunAttendanceGroupBizPersonExample.createCriteria().andAttGroupIdEqualTo(param.getId());
			ErpFunAttendanceGroupBizPerson erpFunAttendanceGroupBizPerson = new ErpFunAttendanceGroupBizPerson();
			erpFunAttendanceGroupBizPerson.setIsDel((byte)1);
			erpFunAttendanceGroupBizPerson.setDelTime(new Date());
			erpFunAttendanceGroupBizPersonMapper.updateByExampleSelective(erpFunAttendanceGroupBizPerson, erpFunAttendanceGroupBizPersonExample);
		}

		// 写入新关系
		addBizAndBizPerson(cityId, compId, groupId, param);

	}

	/**
	 * @Title 编辑新增排班制考勤组
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	private void addEditAttendanceScheduleGroupDetail(Integer cityId, Integer compId,Integer groupId, ErpFunAttendanceGroupParam param) {
		// 处理详细排班员工数据
		List<ErpFunAttendanceUserClassDetail> erpFunAttendanceGroupBizList = JSON.parseObject(param.getAttendanceScheduleList(), new TypeReference<List<ErpFunAttendanceUserClassDetail>>() {});
		//判断是新增还是编辑
 		String userIds = erpFunAttendanceGroupBizList.stream().map(val -> String.valueOf(val.getUserId())).collect(Collectors.joining(","));
		Set<String> userAttTimeSet =null;
		if (StringUtils.isNotBlank(userIds)){
			List<ErpFunAttendanceUserClassDetail> userClassListByUsers = erpFunAttendanceUserClassDetailMapper.getUserClassListByUsers(cityId, compId, userIds);
			userAttTimeSet = userClassListByUsers.stream().map(val -> val.getUserId() + "#" + val.getAttTime()).collect(Collectors.toSet());
		}
		for (ErpFunAttendanceUserClassDetail erpFunAttendanceUserClassDetail : erpFunAttendanceGroupBizList) {
			erpFunAttendanceUserClassDetail.setShardCityId(cityId);
			if(null != erpFunAttendanceUserClassDetail.getClassDetailId()) {
				erpFunAttendanceUserClassDetailMapper.updateByPrimaryKeySelective(erpFunAttendanceUserClassDetail);
			}else {
				if (!CollectionUtils.isEmpty(userAttTimeSet)){
					System.out.println(erpFunAttendanceUserClassDetail.getUserId()+"#"+erpFunAttendanceUserClassDetail.getAttTime());
					if (userAttTimeSet.contains(erpFunAttendanceUserClassDetail.getUserId()+"#"+erpFunAttendanceUserClassDetail.getAttTime())){
						ErpFunAttendanceUserClassDetailExample userClassDetailExample = new ErpFunAttendanceUserClassDetailExample();
						userClassDetailExample.setShardCityId(cityId);
						userClassDetailExample.createCriteria().andCompIdEqualTo(compId)
								.andUserIdEqualTo(erpFunAttendanceUserClassDetail.getUserId()).andAttTimeEqualTo(erpFunAttendanceUserClassDetail.getAttTime());
						erpFunAttendanceUserClassDetailMapper.updateByExampleSelective(erpFunAttendanceUserClassDetail,userClassDetailExample);
						this.insetServerErrLog(cityId,compId,param);
						continue;
					}
				}
				erpFunAttendanceUserClassDetail.setAttGrId(groupId);
				erpFunAttendanceUserClassDetail.setCreateTime(new Date());
				if (erpFunAttendanceUserClassDetail.getGrId() == null) {
					erpFunAttendanceUserClassDetail.setGrId(0);
				}
				if (erpFunAttendanceUserClassDetail.getAreaId() == null) {
					erpFunAttendanceUserClassDetail.setAreaId(0);
				}
				if (erpFunAttendanceUserClassDetail.getRegId() == null) {
					erpFunAttendanceUserClassDetail.setRegId(0);
				}
				if (erpFunAttendanceUserClassDetail.getDeptId() == null) {
					erpFunAttendanceUserClassDetail.setDeptId(0);
				}
				erpFunAttendanceUserClassDetailMapper.insertSelective(erpFunAttendanceUserClassDetail);
			}
		}
	}

	private void insetServerErrLog(Integer cityId, Integer compId, ErpFunAttendanceGroupParam param) {
		try {
			AdminServerErrorLog record = new AdminServerErrorLog();
			record.setCityId(cityId);
			record.setServerType(2);
			record.setErrorCode(200);
			record.setErrorMsg("考勤修改错误");
			record.setExceptionText("考勤编辑异常："+JSON.toJSONString(param));
			record.setCreationTime(new Date());
			adminServerErrorLogMapper.insertSelective(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void addBizAndBizPerson(Integer cityId, Integer compId, Integer groupId, ErpFunAttendanceGroupParam param) {

		// 写关联关系
		List<ErpFunAttendanceGroupBiz> erpFunAttendanceGroupBizList = JSON.parseObject(param.getGroupBizList(), new TypeReference<List<ErpFunAttendanceGroupBiz>>() {});

		List<Integer> userIdSet = new ArrayList<>();
		List<Integer> deptSet = new ArrayList<>();
		for (ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz : erpFunAttendanceGroupBizList) {
			// 写入关联组织机构关系
			erpFunAttendanceGroupBiz.setAttGroupId(groupId);
			erpFunAttendanceGroupBiz.setCompId(compId);
			erpFunAttendanceGroupBiz.setShardCityId(cityId);
			erpFunAttendanceGroupBizMapper.insertSelective(erpFunAttendanceGroupBiz);

			// 判断关联类型来组装个人详细数据
			Integer chooseType = erpFunAttendanceGroupBiz.getChooseType();
			List<ErpFunUsers> erpFunUsersList = new ArrayList<>();
			if(3 == chooseType) {
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunAttendanceGroupBiz.getBizId());
				erpFunUsersList.add(erpFunUsers);
			}else {
				OrganizationDefinitionVO organizationManagerVO = erpFunOrganizationDefinitionMapper.selectOrganizationDefVO(cityId, erpFunAttendanceGroupBiz.getBizId());
				erpFunUsersList = erpFunUsersMapper.getUserListByScopeType(cityId, compId, organizationManagerVO.getMappingDbField(), erpFunAttendanceGroupBiz.getBizId());
			}

			if (erpFunUsersList.size() == 0) {
				continue;

			}
			userIdSet.addAll(erpFunUsersList.stream().collect(Collectors.mapping(user -> user.getUserId(), Collectors.toSet())));

			if(2 == erpFunAttendanceGroupBiz.getChooseType().intValue()) {

			}else if(1 == erpFunAttendanceGroupBiz.getChooseType().intValue()) {
				deptSet.add(erpFunAttendanceGroupBiz.getBizId());
			}

			// 批量添加关联详细人
			erpFunAttendanceGroupBizPersonMapper.insertBatch(cityId, erpFunUsersList, groupId, erpFunAttendanceGroupBiz.getId());
		}

		// 处理重复数据
		if(userIdSet.size() == 0) {
			return;
		}

		clearUserClassDetailData(cityId, groupId, userIdSet, param.getNeedDelUserIds());

		// 处理重复数据
		if(deptSet.size() == 0) {
			return;
		}

		clearDeptClassDetailData(cityId, groupId, deptSet);
	}

	/**
	 * 清除员工单位
	 * @author 李成兵
	 * @since 2018/6/1
	 * @param
	 * @return
	 */
	private void clearDeptClassDetailData(Integer cityId, Integer grId, List<Integer> deptSet) {
		ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz = new ErpFunAttendanceGroupBiz();
		erpFunAttendanceGroupBiz.setIsDel((byte)1);
		erpFunAttendanceGroupBiz.setDelTime(new Date());
		ErpFunAttendanceGroupBizExample erpFunAttendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
		erpFunAttendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
		erpFunAttendanceGroupBizExample.setShardCityId(cityId);
		erpFunAttendanceGroupBizExample.createCriteria().andBizIdIn(deptSet).andChooseTypeEqualTo(1).andAttGroupIdNotEqualTo(grId);
		erpFunAttendanceGroupBizMapper.updateByExampleSelective(erpFunAttendanceGroupBiz, erpFunAttendanceGroupBizExample);
	}

	/**
	  * 清除员工单位
	  * @author 李成兵
	  * @since 2018/6/1
	  * @param
	  * @return
	  */
	private void clearUserClassDetailData(Integer cityId, Integer grId, List<Integer> userIds, String needDelUserIds) {
		ErpFunAttendanceGroupBizPersonExample erpFunAttendanceGroupBizPersonExample = new ErpFunAttendanceGroupBizPersonExample();
		erpFunAttendanceGroupBizPersonExample.setShardCityId(cityId);
		erpFunAttendanceGroupBizPersonExample.createCriteria().andUserIdIn(userIds).andAttGroupIdNotEqualTo(grId);
		ErpFunAttendanceGroupBizPerson erpFunAttendanceGroupBizPerson = new ErpFunAttendanceGroupBizPerson();
		erpFunAttendanceGroupBizPerson.setIsDel((byte)1);
		erpFunAttendanceGroupBizPerson.setDelTime(new Date());
		erpFunAttendanceGroupBizPersonMapper.updateByExampleSelective(erpFunAttendanceGroupBizPerson, erpFunAttendanceGroupBizPersonExample);

		ErpFunAttendanceGroupBizExample erpFunAttendanceGroupBizExample = new ErpFunAttendanceGroupBizExample();
		erpFunAttendanceGroupBizExample.setShardCityId(cityId);
		erpFunAttendanceGroupBizExample.createCriteria().andBizIdIn(new ArrayList<>(userIds)).andChooseTypeEqualTo(3).andAttGroupIdNotEqualTo(grId);
		ErpFunAttendanceGroupBiz erpFunAttendanceGroupBiz = new ErpFunAttendanceGroupBiz();
		erpFunAttendanceGroupBiz.setIsDel((byte)1);
		erpFunAttendanceGroupBiz.setDelTime(new Date());
		erpFunAttendanceGroupBizMapper.updateByExampleSelective(erpFunAttendanceGroupBiz, erpFunAttendanceGroupBizExample);

		ErpFunAttendanceUserClassDetailExample example = new ErpFunAttendanceUserClassDetailExample();
		example.setShardCityId(cityId);
		example.createCriteria().andUserIdIn(userIds).andAttGrIdNotEqualTo(grId);

		ErpFunAttendanceUserClassDetail detail = new ErpFunAttendanceUserClassDetail();
		detail.setIsDel((byte) 1);
		erpFunAttendanceUserClassDetailMapper.updateByExampleSelective(detail, example);



		if(StringUtils.isNotBlank(needDelUserIds)) {
			List<String> strings = Arrays.asList(needDelUserIds.split(","));
			List<Integer> collect = strings.stream().map(Integer::valueOf).collect(Collectors.toList());
			// 删除过往的记录
			example = new ErpFunAttendanceUserClassDetailExample();
			example.setShardCityId(cityId);
			example.createCriteria().andUserIdIn(collect);

			erpFunAttendanceUserClassDetailMapper.updateByExampleSelective(detail, example);
		}
	}

	/**
	 * @Title 新增编辑
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	private Integer updateAttendanceGroup(Integer cityId, Integer compId, Integer deptId, ErpFunAttendanceGroupParam param) {
		param.setShardCityId(cityId);
		if(null != param.getId()) {
			erpFunAttendanceGroupMapper.updateByPrimaryKeySelective(param);
		}else {
			param.setCompId(compId);
			param.setDeptId(deptId);
			param.setCreateTime(new Date());
			erpFunAttendanceGroupMapper.insertSelective(param);
		}
		return param.getId();
	}

	/**
	 * @Title 特殊考勤日
	 * @Author lcb
	 * @Date 2017/11/24
	 * @Param
	 **/
	private void addEditAttendanceFestival(Integer cityId, Integer compId,Integer groupId, ErpFunAttendanceGroupParam param) {

		// 如果是编辑，直接作废以前的，新增特殊考勤列表
		List<ErpFunAttendanceFestival> festivalList = JSON.parseObject(param.getAttendanceFestivalList(), new TypeReference<List<ErpFunAttendanceFestival>>() {});
		if(null != param.getId()) {
			ErpFunAttendanceFestivalExample erpFunAttendanceFestivalExample = new ErpFunAttendanceFestivalExample();
			erpFunAttendanceFestivalExample.setShardCityId(cityId);
			erpFunAttendanceFestivalExample.createCriteria().andCompIdEqualTo(compId).andAttGrIdEqualTo(param.getId());

			ErpFunAttendanceFestival erpFunAttendanceFestival = new ErpFunAttendanceFestival();
			erpFunAttendanceFestival.setIsDel((byte)1);
			erpFunAttendanceFestival.setDelTime(new Date());
			erpFunAttendanceFestivalMapper.updateByExampleSelective(erpFunAttendanceFestival, erpFunAttendanceFestivalExample);
		}

		if(null != festivalList && festivalList.size() > 0) {
			erpFunAttendanceFestivalMapper.insertBatch(cityId, festivalList, groupId, compId);
		}
	}
}

package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.businesstools.vo.BorrowKeyDetailVO;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.house.vo.FunKeyDetailDto;
import com.myfun.erpWeb.house.vo.FunKeyLogDto;
import com.myfun.erpWeb.house.vo.FunKeyRemarkDto;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunKeyLogService;
import com.myfun.service.business.erpdb.ErpFunKeyService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.bean.param.BorrowOrReturnKeyParam;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunKeyServiceImpl extends AbstractService<ErpFunKey, ErpFunKey> implements ErpFunKeyService {
	@Autowired
	private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	private ErpYouShareHouseStatusMapper erpYouShareHouseStatusMapper;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;
	@Autowired
	private ErpFunKeyLogService erpFunKeyLogService;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	@Autowired
	private ErpFunTrackService erpFunTrackService;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunKeyLogMapper erpFunKeyLogMapper;
	@Autowired
	ErpFunKeyRemarkMapper erpFunKeyRemarkMapper;
	@Autowired
	ErpFunKeyOperationLogMapper erpFunKeyOperationLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunPropertyKeyLogMapper erpFunPropertyKeyLogMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired
	ErpLeasePeopleRelativeMapper erpLeasePeopleRelativeMapper;
	
	
	
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunKeyMapper;
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param param
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void createHouseKeyTrack(Integer cityId, Integer compId, CreateHouseKeyParam param) throws Exception {
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setCompId(compId);
		conditionModel.setCaseId(param.getCaseId());
		conditionModel.setCaseType(param.getCaseType());
		Integer count = erpFunKeyMapper.countFunKey(cityId, compId, conditionModel);
		if (count > 0) {
			throw new BusinessException("当前房源已经存在钥匙不需要提交!");
		}
		// 检测是否已经提交钥匙
		erpFunTaskService.checkApplyForCommitHouseKeyTaskStatus(cityId, compId, param);
		BorrowOrReturnKeyParam keyParam = new BorrowOrReturnKeyParam();
		BeanUtils.copyProperties(param, keyParam);
		// 写跟进
		ErpFunTrack funTrackPO = erpFunTrackService.writeTrackByHouseKeyTrack(cityId, compId, keyParam, "1");// 提交钥匙
		// 写任务
		erpFunTaskService.createHouseKeyTask(cityId, compId, funTrackPO);
	}
	
	/**
	 * 判断钥匙是否已经存在
	 * @author 张宏利
	 * @since 2017年10月25日
	 */
	@Override
	public void detectKeyNum(Integer cityId, Integer compId, Integer deptId, String keyNum) {
		if(StringUtils.isBlank(keyNum)) {
			return;
		}
		ErpFunKey erpFunKey = new ErpFunKey();
		erpFunKey.setCompId(compId);
		erpFunKey.setKeyDeptId(deptId);
		erpFunKey.setKeyNum(keyNum);
		Integer count = erpFunKeyMapper.countFunKey(cityId, compId, erpFunKey);
		if (count > 0) {
			throw new BusinessException("钥匙编号：" + keyNum + " 在本门店已经存在，请修改钥匙编号！");
		}
	}
	
	/**
	 * 判断钥匙是否已经提交
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 */
	@Override
	public void detectHouseKey(Integer cityId, Integer compId, Integer caseId, Byte caseType) {
		ErpFunKey erpFunKey = new ErpFunKey();
		erpFunKey.setCompId(compId);
		erpFunKey.setCaseId(caseId);
		erpFunKey.setCaseType(caseType);
		Integer count = erpFunKeyMapper.countFunKey(cityId, compId, erpFunKey);
		if (count > 0) {
			throw new BusinessException("当前房源已经存在钥匙不需要提交!");
		}
	}
	
	/**
	 * 判断是否可以归还钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 */
	@Override
	public void judgeDestroyHouseKey(Integer cityId, Integer compId, Integer caseId, Byte caseType, Integer saleLeaseId) {
		ErpFunKey erpFunKey = new ErpFunKey();
		erpFunKey.setCompId(compId);
		erpFunKey.setCaseType(caseType);
		erpFunKey.setCaseId(caseId);
		ErpFunKey funKeyPo = erpFunKeyMapper.selectKey(cityId, erpFunKey);
		if (funKeyPo == null) {
			if (null != saleLeaseId) {
				Integer otherType =  (caseType == 1) ? 2 : 1;
				erpFunKey.setCaseId(saleLeaseId);
				erpFunKey.setCaseType(otherType.byteValue());
				funKeyPo = erpFunKeyMapper.selectKey(cityId, erpFunKey);
			}
		}
		if (funKeyPo == null) {
			throw new BusinessException("当前房源没有钥匙，请先提交钥匙！");
		}
		if(null != funKeyPo && Const.DIC_KEY_STATUS_LEND.equals(funKeyPo.getKeyStatus().intValue())){
			throw new BusinessException("钥匙已经借出，请先归还钥匙！");
		}
	}
	
	
	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param erpFunKey
	 */
	@Override
	public void createNoKeyTrack(Integer cityId, Integer compId, CreateHouseKeyParam param) {

		ErpFunTrack trackPo = new ErpFunTrack();
		trackPo.setTrackClassic("[ 业务跟进 ]");
		trackPo.setCaseId(param.getCaseId());
		trackPo.setCaseType(param.getCaseType());
		trackPo.setTrackType(Const.DIC_TRACK_TYPE_OTHER);
		trackPo.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		trackPo.setCreatorUid(param.getCurrentUserId());
		trackPo.setDelUserName(param.getUserName());
		trackPo.setCaseNo(param.getCaseNo());
		trackPo.setTrackWarm(false);
		trackPo.setCompId(compId);
		trackPo.setDeptId(param.getCurrentDeptId());
		String trackContent = param.getCurrentUserName() + " 对该房源添加了钥匙说明\n";
		trackContent = trackContent + "钥匙说明: " + param.getKeyNote();
		trackPo.setTrackContent(trackContent);
		trackPo.setShardCityId(cityId);
		erpFunTrackService.insertFunTrack(trackPo);
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void returnHouseKey(Integer cityId, Integer compId, BorrowOrReturnKeyParam param) throws Exception {
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setCompId(compId);
		conditionModel.setCaseId(param.getCaseId());
		conditionModel.setCaseType(param.getCaseType());
		ErpFunKey funKeyPo = erpFunKeyMapper.selectKey(cityId, conditionModel);
		if (funKeyPo == null) {
			throw new BusinessException("当前房源没有钥匙，请先提交钥匙！");
		} else {
			if (Constants_DIC.DIC_KEY_STATUS_LEND.equals(funKeyPo.getKeyStatus().toString())) {
				throw new BusinessException("钥匙已经借出，请先归还钥匙！");
			}
		}
		// 写跟进
		ErpFunTrack funTrackPO = erpFunTrackService.writeTrackByHouseKeyTrack(cityId, compId, param, "0");// 退还钥匙
		// 写任务
		erpFunTaskService.createHouseKeyTask(cityId, compId, funTrackPO);
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @throws Exception 
	 */
	@Transactional
	@Override
	public void destroyKey(DestroyKeyParam param) throws Exception {
		ErpFunKey queryCondition = new ErpFunKey();
		queryCondition.setKeyId(param.getKeyId());
		queryCondition.setCompId(param.getCompId());
		ErpFunKey funKeyPO = erpFunKeyMapper.selectKey(param.getCityId(), queryCondition);
		if (Constants_DIC.DIC_KEY_STATUS_LEND.equals(funKeyPO.getKeyStatus().toString())) {
			throw new BusinessException("钥匙已经借出，请先归还钥匙！");
		}
		// 更新房源对像
		this.updateCaseKey(param,funKeyPO);
		// 写跟进
		this.createKeyTrack(param);
		// 删除钥匙
		ErpFunKey condition = new ErpFunKey();
		condition.setCaseId(funKeyPO.getCaseId());
		condition.setCaseType(funKeyPO.getCaseType());
		condition.setCompId(param.getCompId());
		List<Integer> keyList = erpFunKeyMapper.getKeyIdsByCondition(param.getCityId(),condition);
		if(!keyList.isEmpty()){
			erpFunKeyMapper.deleteFunKey(param.getCityId(), keyList.toArray());
			erpFunKeyLogService.deleteFunKeyLogByKeyIds(param.getCityId(),param.getCompId(), keyList.toArray());
			erpFunTaskService.updateKeyTask(param.getCityId(), param.getCompId(), keyList.toArray());
		}
	/*	// 更改原审核任务的ID为空
		ErpFunTask updateModel = new ErpFunTask();
		ErpFunTask conditionModel = new ErpFunTask();
		conditionModel.setCompId(param.getCompId());
		conditionModel.setKeyId(param.getKeyId());
		updateModel.setKeyId(null);
		erpFunTaskService.updateKeyTask(param.getCityId(), updateModel, conditionModel);*/
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 * @throws Exception 
	 */

	private void createKeyTrack(DestroyKeyParam param) throws Exception {
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setKeyId(param.getKeyId());
		conditionModel.setCompId(param.getCompId());
		ErpFunKey funKeyPO = erpFunKeyMapper.selectKey(param.getCityId(), conditionModel);
		String postDeptName = Constants_DIC.DIC_IS_HONGJI_COMP_MODEL.equals(param.getHongJICompModel()) ? param.getCurrentDeptName() + " " : "";
		String trackContent = "注销人：" + postDeptName + param.getUserName();
		Map<String,Integer> returnMap = erpFunTrackService.getCaseInfo(param.getCityId(), funKeyPO.getCaseId(), funKeyPO.getCaseType().intValue());
		ErpFunTrack funTrackPO = new ErpFunTrack();
		funTrackPO.setShardCityId(param.getCityId());
		funTrackPO.setCaseId(funKeyPO.getCaseId());
		funTrackPO.setCaseNo(funKeyPO.getCaseNo());
		funTrackPO.setCaseType(funKeyPO.getCaseType());
		funTrackPO.setTrackType(Const.DIC_TRACK_TYPE_KEY);
		funTrackPO.setCreatorUid(param.getCurrentUserId());
		funTrackPO.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		funTrackPO.setTrackContent(trackContent);
		funTrackPO.setTrackClassic("[ 注销钥匙 ]");
		funTrackPO.setCompId(param.getCompId());
		funTrackPO.setDeptId(param.getCurrentDeptId());
		funTrackPO.setCaseUserId(returnMap.get("userId"));
		funTrackPO.setCaseDeptId(returnMap.get("deptId"));
		funTrackPO.setTrackWarm(false);
		erpFunTrackService.insertFunTrack(funTrackPO);

	}

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 */

	private void updateCaseKey(DestroyKeyParam param,ErpFunKey funKeyPO) {
		if (funKeyPO.getCaseType().toString().equals(Const.DIC_CASE_TYPE_SALE_FUN.toString())) {
			updateFunSaleKeyNumById(param.getCityId(), funKeyPO.getCaseId());
		} else if (funKeyPO.getCaseType().toString().equals(Const.DIC_CASE_TYPE_LEASE_FUN.toString())) {
			updateFunLeaseKeyNumById(param.getCityId(), funKeyPO.getCaseId());
		}
		updateFunTaskMap(funKeyPO, param);
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param funKeyPO
	 * @param param
	 */
	private void updateFunTaskMap(ErpFunKey funKeyPO, DestroyKeyParam param) {
		// 更新其他钥匙任务
		ErpFunTask updateModel = new ErpFunTask();
		updateModel.setTaskStatus(Const.DIC_TASK_STATUS_CANCEL);
		updateModel.setTaskSolute("钥匙申请已被注销，此任务自动关闭！");
		//updateModel.setTaskResult(Const.DIC_EXAMIN_RESULT_DISAGREEN);
		updateModel.setUpdateTime(new Date());
		updateModel.setCompId(param.getCompId());
		updateModel.setDeptId(param.getCurrentDeptId());
		updateModel.setTaskOwner(param.getCurrentUserId());
		updateModel.setIsRead(true);
		ErpFunTask conditionModel = new ErpFunTask();
		conditionModel.setCaseId(funKeyPO.getCaseId());
		conditionModel.setCaseType(funKeyPO.getCaseType());
		conditionModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		Object[] trackTypes = new Object[] { 
				Const.DIC_TRACK_TYPE_KEY, 
				Const.DIC_TRACK_TYPE_KEY_BORROW,
				Const.DIC_TRACK_TYPE_KEY_RETURN 
			};
		erpFunTaskService.updateFunTask(param.getCityId(), updateModel, conditionModel, trackTypes);
	}

	private void updateFunSaleKeyNumById(Integer cityId, Integer saleId) {
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setSaleKey(false);
		updateModel.setSaleKeyNum(null);
		updateModel.setKeyTime(null);
		updateModel.setSaleId(saleId);
		erpFunSaleMapper.updateFunSaleKeyNumById(cityId, updateModel);
	}

	private void updateFunLeaseKeyNumById(Integer cityId, Integer leaseId) {
		ErpFunLease updateModel = new ErpFunLease();
		updateModel.setLeaseKey(false);
		updateModel.setLeaseKeyNum(null);
		updateModel.setKeyTime(null);
		updateModel.setLeaseId(leaseId);
		erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, updateModel);
	}

	/**
	 * @author 方李骥
	 * @since 2016年9月6日
	 * @param param
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void borrowKey(BorrowOrReturnKeyParam param) throws Exception {
		ErpFunTask erpFunTask = new ErpFunTask();
		Integer keyId = param.getKeyId();
		String actionType = param.getKeyAction();
		String taskSubject = null;
		// funTaskPO.setKEY_ID(keyId);
		ErpFunKeyLog keyLog = new ErpFunKeyLog();
		// FunKeyLogPO keyLog = new FunKeyLogPO();
		keyLog.setKeyId(keyId);
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setKeyId(keyId);
		conditionModel.setCompId(param.getCompId());
		ErpFunKey funKeyPO = erpFunKeyMapper.selectKey(param.getCityId(), conditionModel);
		if (funKeyPO.getKeyStatus().equals(Const.KEY_STATUS_BORROWOUT) && "borrow".equals(actionType)) {
			Integer keyLogId = funKeyPO.getKeyLogId();
			ErpFunKeyLog funKeyLogPO = erpFunKeyLogService.getErpFunKeyLogById(param.getCityId(), keyLogId);
			ErpFunUsers erpFunUsers = erpFunUsersService.getUserInfoByUserId(param.getCityId(), funKeyLogPO.getBorrowUser());
			throw new BusinessException("该钥匙已被" + erpFunUsersService.getCurrUserName(param.getCityId(),erpFunUsers.getUserId(),erpFunUsers.getDeptId()) + "借出");
		}
		if (actionType.equals("borrow")) {
			taskSubject = Constants_DIC.DIC_TASK_SUBJECT_HEAD_7 + " " + param.getCurrentUserName() + "借用该房源钥匙，申请审核";
		} else {
			taskSubject = Constants_DIC.DIC_TASK_SUBJECT_HEAD_8 + " " + param.getCurrentUserName() + "归还该房源钥匙，申请审核";
		}
		Byte trackType = actionType.equals("borrow") ? Const.DIC_TRACK_TYPE_KEY_BORROW : Const.DIC_TRACK_TYPE_KEY_RETURN;
		Byte taskType = actionType.equals("borrow") ? Const.DIC_TASK_TYPE_KEY_BORROW : Const.DIC_TASK_TYPE_KEY_RETURN;
		erpFunTask.setCaseId(funKeyPO.getCaseId());
		erpFunTask.setShardCityId(param.getCityId());
		erpFunTask.setCaseNo(funKeyPO.getCaseNo());
		erpFunTask.setCaseType(funKeyPO.getCaseType());
		erpFunTask.setTrackType(trackType);
		erpFunTask.setKeyId(keyId);
		erpFunTask.setTaskType(taskType);
		erpFunTask.setTaskSubject(taskSubject);
		erpFunTask.setTaskDesc(param.getContent());
		erpFunTask.setCompId(param.getCompId());
		erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_1);
		erpFunTask.setIsRead(false);
		erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		erpFunTask.setCreatorUid(param.getCurrentUserId());
		erpFunTask.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		// 检查是否已经提交了申请
		this.checkApply4KeyActionTask(funKeyPO, param, taskType);
		Byte caseType = funKeyPO.getCaseType();
		Integer caseInfoDeptId = 0;
		if (caseType.toString().equals(Const.DIC_CASE_TYPE_SALE_FUN.toString())) {
			ErpFunSale housePO = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), funKeyPO.getCaseId());
			caseInfoDeptId = housePO.getDeptId();
		} else if (caseType.toString().equals(Const.DIC_CASE_TYPE_LEASE_FUN.toString())) {
			ErpFunLease housePO = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), funKeyPO.getCaseId());
			caseInfoDeptId = housePO.getDeptId();
		} else if (caseType.toString().equals(Const.DIC_CASE_TYPE_RENT_CUST.toString())) {
			ErpFunRentCustomerKey rentKey = new ErpFunRentCustomerKey();
			rentKey.setCompId(param.getCompId());
			rentKey.setRentCustId(funKeyPO.getCaseId());
			ErpFunRentCustomer housePO = erpFunRentCustomerMapper.getFunRentCustomer(param.getCityId(), rentKey);
			caseInfoDeptId = housePO.getDeptId();
		} else if (caseType.toString().equals(Const.DIC_CASE_TYPE_BUY_CUST.toString())) {
			ErpFunBuyCustomer housePO = erpFunBuyCustomerMapper.getFunBuyCustomer(param.getCityId(), funKeyPO.getCaseId());
			caseInfoDeptId = housePO.getDeptId();
		}
		// 钥匙审核类型，0=房源所属门店 1=钥匙所属门店
		String keyExamineType = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "KEY_EXAMINE_TYPE");
		if ("1".equals(keyExamineType)) {
			caseInfoDeptId = funKeyPO.getKeyDeptId();
		}
		erpFunTask.setDeptId(caseInfoDeptId);// 读FUN_KEY 上面的DEPT_ID，不是房源上面的DEPT_ID
		erpFunTaskService.insertSelective(erpFunTask);

	}

	/**
	 * @author 方李骥
	 * @since 2016年9月6日
	 * @param funKeyPO
	 * @param param
	 * @throws BusinessException
	 */

	private void checkApply4KeyActionTask(ErpFunKey funKeyPO, BorrowOrReturnKeyParam param, Byte taskType)
			throws BusinessException {
		ErpFunTask conditionModel = new ErpFunTask();
		conditionModel.setCaseId(funKeyPO.getCaseId());
		conditionModel.setCaseType(funKeyPO.getCaseType());
		conditionModel.setTaskType(taskType);
		conditionModel.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		conditionModel.setCreatorUid(param.getCurrentUserId());
		conditionModel.setCompId(param.getCompId());
		Integer count = erpFunTaskService.countFunTask(param.getCityId(), conditionModel);
		String taskMemo = param.getKeyAction().equals("borrow") ? "借用" : "归还";
		if (count > 0) {
			throw new BusinessException("您之前已经提交过该钥匙的" + taskMemo + "申请，请等待审核！");
		}
	}
	/**
	 * 精英版有钥匙提交跟进
	 */
	@Transactional
	@Override
	public void createHouseKeyTrackPer(Integer cityId, Integer compId,
			CreateHouseKeyParam param) throws Exception {
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setCompId(compId);
		conditionModel.setCaseId(param.getCaseId());
		conditionModel.setCaseType(param.getCaseType());
		Integer count = erpFunKeyMapper.countFunKey(cityId, compId, conditionModel);
		if (count > 0) {
			throw new BusinessException("当前房源已经存在钥匙不需要提交!");
		}
		if (param.getCaseType().toString().equals(Const.DIC_CASE_TYPE_SALE_FUN.toString())) {
			ErpFunSale updateModel = new ErpFunSale();
			updateModel.setSaleKey(true);
			updateModel.setKeyTime(new Date());
			updateModel.setSaleId(param.getCaseId());
			erpFunSaleMapper.updateFunSaleKeyNumById(cityId, updateModel);
		} else if (param.getCaseType().toString().equals(Const.DIC_CASE_TYPE_LEASE_FUN.toString())) {
			ErpFunLease updateModel = new ErpFunLease();
			updateModel.setLeaseKey(true);
			updateModel.setKeyTime(new Date());
			updateModel.setLeaseId(param.getCaseId());
			erpFunLeaseMapper.updateFunLeaseKeyNumById(cityId, updateModel);
		}
		String currentUserName = null;//TODO:这里获取名称，看一下应该怎么样去做我的建议是放在ThreadLocal里面
		//写钥匙提交跟进
		ErpFunTrack funTrackPO = new ErpFunTrack();
		funTrackPO.setShardCityId(cityId);
		funTrackPO.setCaseId(param.getCaseId());
		funTrackPO.setCaseNo(param.getCaseNo());
		funTrackPO.setCaseType(param.getCaseType());
		funTrackPO.setTrackType(Const.DIC_TRACK_TYPE_KEY);
		funTrackPO.setIncludeTrack(Const.DIC_TRACK_INCLUDE_TRACK_UPLOADKEY);
		funTrackPO.setTrackClassic(Constants_DIC.DIC_TRACKCLASSIC_13);
		funTrackPO.setCreatorUid(param.getCurrentUserId());
		funTrackPO.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		funTrackPO.setTrackContent(param.getCurrentUserName()+ " 提交该房源钥匙\n钥匙说明："+param.getKeyNote());
		funTrackPO.setTrackWarm(false);
		funTrackPO.setCompId(compId);
		funTrackPO.setDeptId(param.getCurrentDeptId());
		funTrackPO.setTrackWarm(false);
		funTrackPO.setTargetType(Byte.valueOf("1"));
		funTrackPO.setExaminTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunTrackService.insertFunTrack(funTrackPO);
		//写钥匙跟进
		ErpFunKey funKey = new ErpFunKey();
		funKey.setShardCityId(cityId);
		funKey.setCaseId(param.getCaseId());
		funKey.setCaseType(param.getCaseType());
		funKey.setCaseNo(param.getCaseNo());
		funKey.setTrackId(funTrackPO.getTrackId());
		funKey.setDeptId(param.getCurrentDeptId());
		funKey.setUserId(param.getCurrentUserId());
		funKey.setKeyDeptId(param.getCurrentDeptId());
		funKey.setKeyNum("0");
		funKey.setKeyStatus(Const.DIC_KEY_STATUS_ARCHIVE.byteValue());
		funKey.setCompId(compId);
		funKey.setCreatorTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunKeyMapper.insertSelective(funKey);
		

	}
	/**
	 * 精英版有钥匙提交跟进
	 */
	@Override
	public void createNoKeyTrackPer(Integer cityId, Integer compId,
			CreateHouseKeyParam param) {
		/*String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		String trackContent = "注销人：" + param.getCurrentUserName();
		ErpFunTrack funTrackPO = new ErpFunTrack();
		funTrackPO.setShardCityId(cityId);
		funTrackPO.setCaseId(param.getCaseId());
		funTrackPO.setCaseType(param.getCaseType());
		funTrackPO.setCaseNo(param.getCaseNo());
		funTrackPO.setTrackType(Const.DIC_TRACK_TYPE_KEY);
		funTrackPO.setCreatorUid(param.getCurrentUserId());
		funTrackPO.setCreationTime(nowTime);
		funTrackPO.setTrackContent(trackContent);
		funTrackPO.setTrackClassic("[ 注销钥匙 ]");
		funTrackPO.setCompId(compId);
		funTrackPO.setDeptId(param.getCurrentDeptId());
		funTrackPO.setTrackWarm(false);
		erpFunTrackService.insertFunTrack(funTrackPO);*/
	}
	/**
	 * 精英版注销钥匙写跟进
	 */
	@Transactional
	@Override
	public void destroyKeyPer(BorrowOrReturnKeyParam param) throws Exception {
		//这里使用有两个地方：1.房源信息上退还钥匙调用 2.业务工具中调用的注销钥匙调用 调用的是同一个接口
		ErpFunKey erpFunKey = null;
		Integer keyId = param.getKeyId();
		if(keyId!=null){
			ErpFunKey id = new ErpFunKey();
			id.setShardCityId(param.getCityId());
			id.setKeyId(keyId);
			erpFunKey = erpFunKeyMapper.selectByPrimaryKey(id);
		}
		ErpFunKey conditionModel = new ErpFunKey();
		conditionModel.setCaseId(param.getCaseId());
		conditionModel.setCaseType(param.getCaseType());
		conditionModel.setCompId(param.getCompId());
		erpFunKey = erpFunKeyMapper.selectKey(param.getCityId(), conditionModel);
		if(erpFunKey==null){
			throw new BusinessException( "当前房源没有钥匙，请先提交钥匙！");
		}else {
			if(Constants_DIC.DIC_KEY_STATUS_LEND.equals(erpFunKey.getKeyStatus().toString())){
				throw new BusinessException( "钥匙已经借出，请先归还钥匙！");
			}
		}
		Integer caseId = param.getCaseId();//funKeyPO.getCASE_ID();
		String caseNo = param.getCaseNo();//funKeyPO.getCASE_NO();
		Byte caseType = param.getCaseType();//funKeyPO.getCASE_TYPE();
		ErpFunTrack funTrackPO = new ErpFunTrack();
		funTrackPO.setShardCityId(param.getCityId());
		funTrackPO.setCaseId(caseId);
		funTrackPO.setCaseType(caseType);
		funTrackPO.setCaseNo(caseNo);
		funTrackPO.setTrackType(Const.DIC_TRACK_TYPE_KEY);
		funTrackPO.setTrackWarm(false);
		funTrackPO.setCreatorUid(param.getCurrentUserId());
		funTrackPO.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		funTrackPO.setDeptId(param.getCurrentDeptId());
		funTrackPO.setCompId(param.getCompId());
		// 写跟进 业务工具条用的
		if(keyId == null){
			//写提交钥匙跟进
			funTrackPO.setTrackClassic(Const.DIC_TRACKCLASSIC_14);
			funTrackPO.setTrackContent(param.getCurrentUserName()+ " 退还该房源钥匙");
			funTrackPO.setTargetType(Byte.valueOf("1"));
			funTrackPO.setExaminTime(DateTimeHelper.formatDateTimetoString(new Date()));
		}else{
			funTrackPO.setTrackContent("注销人："+param.getCurrentUserName());
			funTrackPO.setTrackClassic("[ 注销钥匙 ]");
		}
		erpFunTrackService.insertFunTrack(funTrackPO);
		if (param.getCaseType().toString().equals(Const.DIC_CASE_TYPE_SALE_FUN.toString())) {
			ErpFunSale updateModel = new ErpFunSale();
			updateModel.setSaleKey(false);
			updateModel.setKeyTime(null);
			updateModel.setSaleId(param.getCaseId());
			erpFunSaleMapper.updateFunSaleKeyNumById(param.getCityId(), updateModel);
		} else if (param.getCaseType().toString().equals(Const.DIC_CASE_TYPE_LEASE_FUN.toString())) {
			ErpFunLease updateModel = new ErpFunLease();
			updateModel.setLeaseKey(false);
			updateModel.setKeyTime(null);
			updateModel.setLeaseId(param.getCaseId());
			erpFunLeaseMapper.updateFunLeaseKeyNumById(param.getCityId(), updateModel);
		}
		// 删除钥匙
		ErpFunKey condition = new ErpFunKey();
		condition.setCaseId(param.getCaseId());
		condition.setCaseType(param.getCaseType());
		condition.setCompId(param.getCompId());
		List<Integer> keyList = erpFunKeyMapper.getKeyIdsByCondition(param.getCityId(),condition);
		if(!keyList.isEmpty()){
			erpFunKeyMapper.deleteFunKey(param.getCityId(), keyList.toArray());
			erpFunKeyLogService.deleteFunKeyLogByKeyIds(param.getCityId(),param.getCompId(), keyList.toArray());
			erpFunTaskService.updateKeyTask(param.getCityId(), param.getCompId(), keyList.toArray());
		}
	}

	/**
	 * 查询钥匙编号
	 * @author 臧铁
	 * @since 2017年7月13日
	 * @param caseId
	 * @param caseType
	 * @param trackKey 0=查询已有钥匙编号 1=查询新钥匙编号
	 * @param curCompId 经纪人公司ID
	 * @param keyDeptId 以提交钥匙申请人的DEPTID和USERID为主  钥匙的所在门店
	 * @return
	 */
	@Override
	public String getKeyNum(Integer caseId, Byte caseType, Integer trackKey,Integer curCompId, Integer keyDeptId,Integer cityId) {
		if (0 == trackKey) {//收回钥匙
			// 获得已有的钥匙编号
			return erpFunKeyMapper.getExistNum(caseId, caseType,curCompId,cityId);
		} else {
			ErpFunDepts erpFunDept=erpFunDeptsMapper.getByDeptId(cityId, keyDeptId);
			return this.getNewKeyNum(cityId,curCompId,keyDeptId,erpFunDept.getDeptNo(),null);
		}	
	}
	
	/**
	 * 获得新的钥匙编号
	 *
	 * @return
	 * @author 张宏利
	 * @since 2017年12月22日
	 */
	@Override
	public String getNewKeyNum(Integer cityId, Integer compId, Integer deptId, String deptNo,Integer userId) {
		//查询编号
		String keyNum = erpFunKeyMapper.getKeyNum(cityId, compId, deptId, deptNo,userId);
		if (deptNo==null){
			return keyNum;
		}
		return deptNo + keyNum;

//		List<ErpFunKey> dataInfoList = erpFunKeyMapper.getNewNum(keyDeptId, curCompId, cityId);
//		if (dataInfoList.size() <= 0) {
//			return "001";
//		}
//		// 获取小于1000的钥匙编号
//		Set<Integer> nowKeys = dataInfoList.stream().collect(Collectors.mapping(val -> {
//			int temp = StringUtil.parseInteger(val.getKeyNum());
//			return temp < 1000 ? temp : 0;
//		}, Collectors.toSet()));
//		int keyNum = 0;
//		// 按由小到大顺序来取一个最小的编号
//		for (Integer tempKey : nowKeys) {
//			if (++keyNum < tempKey) {
//				break;
//			}
//			if (keyNum == nowKeys.size()) {
//				keyNum++;
//			}
//		}
//		String tempNum = String.valueOf(keyNum);
//		if (tempNum.length() == 1) {
//			return ("00" + tempNum);
//		} else if (tempNum.length() == 2) {
//			return ("0" + tempNum);
//		} else if (tempNum.length() == 3) {
//			return tempNum;
//		}
//		return "001";
	}

	/**
	 * @author 邓永洪
	 * @tag 获取钥匙详情
	 * @since 2018/4/26
	 */
	@Override
	public FunKeyDetailDto getKeyDetail(ErpCreateTrackInfoParam param,Integer cityId,Integer currentUserId,Integer currentDeptId) {
		Integer caseType = param.getCaseType();
		Integer saleLeaseId = null, saleLeaseType = null;
		boolean haveKey = false;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {//出售
			ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getCaseId());
			haveKey = funSale.getSaleKey();
			saleLeaseId = funSale.getSaleLeaseId();
			saleLeaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {//出租
			ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getCaseId());
			haveKey = funLease.getLeaseKey();
			saleLeaseId = funLease.getSaleLeaseId();
			saleLeaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		FunKeyDetailDto funKeyDetailDto;
		if (param.getNewOrganization()) {
			funKeyDetailDto = erpFunKeyMapper.getKeyDetailDtoNewOrg(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType(), saleLeaseId, saleLeaseType.byteValue());
		}else {
			funKeyDetailDto = erpFunKeyMapper.getKeyDetailDto(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType(), saleLeaseId, saleLeaseType.byteValue());
		}
		if (null == funKeyDetailDto) {
			funKeyDetailDto = new FunKeyDetailDto();
		}
		//有钥匙
		if (haveKey) {
			FunKeyRemarkDto funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), param.getCaseId(), param.getCaseType());
			if(funKeyRemarkDto == null && saleLeaseId != null){
				if(Integer.valueOf("1").equals(caseType)){
					funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), saleLeaseId, 2);
				}else{
					funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), saleLeaseId, 1);
				}
			}
			if (funKeyRemarkDto != null) {
				funKeyDetailDto.setKeyNote(funKeyRemarkDto.getRemark());
			}
			Integer keyStatus = Optional.ofNullable(funKeyDetailDto.getKeyStatus()).orElse(0);
			//钥匙借出
			if (keyStatus == 1) {
				if (Const.OUT_BORROW.equals(funKeyDetailDto.getLogType())){
					Integer keyLogId = funKeyDetailDto.getKeyLogId();
					String roleDesc = erpFunUsersMapper.selectByUserId(cityId,currentUserId).getUserPosition().trim();
					ErpFunPropertyKeyLog erpFunPropertyKeyLog = erpFunPropertyKeyLogMapper.selectByPrimaryKey(new ErpFunPropertyKeyLog(cityId,keyLogId));
					if (erpFunPropertyKeyLog != null){
						funKeyDetailDto = getFunKeyDetailDto(erpFunPropertyKeyLog,funKeyDetailDto,roleDesc,currentDeptId,currentUserId,cityId);
					}
				}else {
					ErpFunKeyOperationLog funKeyOperationLogByKeyId = erpFunKeyOperationLogMapper.getFunKeyOperationLogByKeyId(param.getCityId(), funKeyDetailDto.getKeyId());
					if(null != funKeyOperationLogByKeyId && null != funKeyOperationLogByKeyId.getOperationUser()){
						ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(param.getCityId(), funKeyOperationLogByKeyId.getOperationUser());
						funKeyDetailDto.setBorrowUserMobile(erpFunUsers.getUserMobile());
						funKeyDetailDto.setBorrowUserName(erpFunUsers.getUserName());
						funKeyDetailDto.setBorrowUserDept(erpFunUsers.getDeptId());
						funKeyDetailDto.setBorrowUserOrganizationId(erpFunUsers.getOrganizationId());
					}
				}
			}
		} else {//无钥匙
			FunKeyRemarkDto funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), param.getCaseId(), param.getCaseType());
			if(funKeyRemarkDto == null && saleLeaseId != null){
				if(Integer.valueOf("1").equals(caseType)){
					funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), saleLeaseId, 2);
				}else{
					funKeyRemarkDto = erpFunKeyRemarkMapper.getFunKeyRemarkDto(param.getCityId(), saleLeaseId, 1);
				}
			}
			if (funKeyRemarkDto != null) {
				funKeyDetailDto.setKeyNote(funKeyRemarkDto.getRemark());
				funKeyDetailDto.setTrackUserName(funKeyRemarkDto.getTrackUserName());
				funKeyDetailDto.setTrackUserMobile(funKeyRemarkDto.getTrackUserMobile());
			}
		}
		if (!this.judgeCanViewKeyVoucher(param.getCityId(), currentUserId, caseType, param.getCaseId())) {
			funKeyDetailDto.setKeyVoucher(null);
		}
		return funKeyDetailDto;
	}
	
	/**
	 * 精英版钥匙判重
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/4
	 * @return
	 *
	 */
	@Override
	public void delectPersonlVersionKeyNum(Integer cityId, Integer compId, Integer userId, String keyNum) {
		if(StringUtils.isBlank(keyNum)) {
			return;
		}
		ErpFunKey erpFunKey = new ErpFunKey();
		erpFunKey.setCompId(compId);
		erpFunKey.setUserId(userId);
		erpFunKey.setKeyNum(keyNum);
		Integer count = erpFunKeyMapper.countFunKey(cityId, compId, erpFunKey);
		if (count > 0) {
			throw new BusinessException("钥匙编号：" + keyNum + " 已经存在，请修改钥匙编号！");
		}
	}
	/**
	 * 获取BorrowKeyDetailVO
	 * @param erpFunPropertyKeyLog
	 * @param
	 * @return
	 */
	private FunKeyDetailDto getFunKeyDetailDto(ErpFunPropertyKeyLog erpFunPropertyKeyLog, FunKeyDetailDto funKeyDetailDto,
												   String roleDesc, Integer currentDeptId, Integer currentUserId, Integer cityId) {
		funKeyDetailDto.setBorrowUserName(erpFunPropertyKeyLog.getBorrowName());
		//总经理
		String phoneNum = erpFunPropertyKeyLog.getBorrowPhone()
				.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
		if (Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleDesc)){
			phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
		}
		//如果是门店经理判断门店Id
		if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleDesc)){
			//获取登记人门店ID
			Integer deptId = erpFunPropertyKeyLog.getDeptId();
			if (deptId.intValue() == currentDeptId){
				phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
			}
		}
		//如果是经纪人判断登记人再返不返
//		if (Const.DIC_ROLE_NAME_COMMON_BIZ.equals(roleDesc)){
//			Integer userId = erpFunPropertyKeyLog.getUserId();
//			if (userId.intValue() == currentUserId.intValue()){
//				phoneNum = erpFunPropertyKeyLog.getBorrowPhone();
//			}
//		}
		funKeyDetailDto.setCurrentDepositStatus(erpFunPropertyKeyLog.getDepositStatus());
		funKeyDetailDto.setBorrowUserMobile(phoneNum);
		funKeyDetailDto.setCurrentDeposit(erpFunPropertyKeyLog.getCurrentDeposit());
		funKeyDetailDto.setKeyStatus(erpFunPropertyKeyLog.getKeyStatus());
		funKeyDetailDto.setReviewName(erpFunPropertyKeyLog.getUserName());
		funKeyDetailDto.setBorrowUserName(erpFunPropertyKeyLog.getBorrowName());
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId,erpFunPropertyKeyLog.getDeptId());
		funKeyDetailDto.setDeptName(erpFunDepts.getDeptName());
		return funKeyDetailDto;
	}
	
	@Override
	public boolean judgeCanViewKeyVoucher(Integer cityId, Integer currenUserId, Integer caseType, Integer caseId) {
		if (null == cityId || null == currenUserId || null == caseType) {
			return false;
		}
		
		// 查询当前登录人是否存在房源文件查看权限
		Set<String> viewHouseFileOper = erpUserOpersMapper.getUsersOpersByUserId(cityId, currenUserId, new String[]{"VIEW_HOUSE_FILE"});
		if (!viewHouseFileOper.isEmpty()) {
			return true;
		}
		if (null != caseId) {
			// 查询是否是钥匙提交人
			if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				ErpSalePeopleRelative erpSalePeopleRelative = erpSalePeopleRelativeMapper.getErpSalePeopleRelativeByCaseIdAndHouseType(cityId, caseId, Const.HOUSE_RELATIVE_PEOPLE_TYPE_3);
				if (null != erpSalePeopleRelative && currenUserId.equals(erpSalePeopleRelative.getUserId())) {
					return true;
				}
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				ErpLeasePeopleRelative erpLeasePeopleRelative = erpLeasePeopleRelativeMapper.getErpLeasePeopleRelativeByCaseIdAndHouseType(cityId, caseId, Const.HOUSE_RELATIVE_PEOPLE_TYPE_3);
				if (null != erpLeasePeopleRelative && currenUserId.equals(erpLeasePeopleRelative.getUserId())) {
					return true;
				}
			}
		}
		return false;
	}
}

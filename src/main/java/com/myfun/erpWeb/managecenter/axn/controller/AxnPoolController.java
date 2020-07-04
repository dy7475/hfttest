package com.myfun.erpWeb.managecenter.axn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.axn.api.AxnPoolApi;
import com.myfun.erpWeb.managecenter.axn.param.*;
import com.myfun.erpWeb.managecenter.axn.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.util.DateTimeHelper;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.AliyunNumberPoolDto;
import com.myfun.repository.erpdb.dto.AliyunPhoneDto;
import com.myfun.repository.erpdb.dto.UserOpOrgInfoDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpAliyunNumberPoolService;
import com.myfun.service.business.erpdb.ErpAliyunPhoneService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class AxnPoolController extends BaseController implements AxnPoolApi {

	@Autowired
	private ErpAliyunNumberPoolService erpAliyunNumberPoolService;
	@Autowired
	private ErpAliyunNumberPoolMapper erpAliyunNumberPoolMapper;
	@Autowired
	private ErpAliyunPhoneService erpAliyunPhoneService;
	@Autowired
	private ErpAliyunPhoneMapper erpAliyunPhoneMapper;
	@Autowired
	private ErpAliyunPhoneBindHistoryMapper erpAliyunPhoneBindHistoryMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private AdminIpCallLogMapper adminIpCallLogMapper;
	@Autowired
	private ErpAliyunTelephoneBillMapper erpAliyunTelephoneBillMapper;
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	
	@Override
	public ResponseJson createNumberPool(@RequestBody CreateNumberPoolParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		erpAliyunNumberPoolService.createNumberPool(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson getNumberPoolList(@RequestBody NumberPoolListParam param) throws Exception {
		Operator operator = getOperator();
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<AliyunNumberPoolDto> list = erpAliyunNumberPoolMapper.getNumberPoolList(operator.getCityId(), operator.getCompId());
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		PageInfo<AliyunNumberPoolDto> pageInfo = new PageInfo<>(list);
		List<NumberPoolVO> numberPoolList = new ArrayList<NumberPoolVO>();
		for (AliyunNumberPoolDto aliyunNumberPoolDto : list) {
			NumberPoolVO numberPoolVO = new NumberPoolVO();
			BeanUtils.copyProperties(aliyunNumberPoolDto, numberPoolVO);
			if (numberPoolVO.getPhoneNum() != 0) {
				numberPoolVO.setUnRate(numberPoolVO.getIsBind() * 100 / numberPoolVO.getPhoneNum());
			} else {
				numberPoolVO.setUnRate(0);
			}
			numberPoolList.add(numberPoolVO);
		}
		NumberPoolListVO numberPoolListVO = new NumberPoolListVO();
		numberPoolListVO.setNumberPoolList(numberPoolList);
		ErpResponseJson responseJson = ErpResponseJson.ok(numberPoolListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson importNumber(@RequestBody ImportNumberParam param) throws Exception {
		// 验证该号码是否存在
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		List<String> phoneList = param.getPhones().stream().map(ImportNumber::getBindX).collect(Collectors.toList());
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(operator.getCityId());
		erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsreleaseEqualTo(Byte.valueOf("0")).andBindXIn(phoneList);
		List<ErpAliyunPhone> aliyunPhoneList = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if (!aliyunPhoneList.isEmpty()) {
			List<ImportNumber> newPhones = new ArrayList<>();
			Set<String> bindXSet = aliyunPhoneList.stream().map(ErpAliyunPhone::getBindX).collect(Collectors.toSet());
			List<ImportNumber> phones = param.getPhones();
			for (int i = 0; i < phones.size(); i++) {
				ImportNumber importNumber = phones.get(i);
				// 过滤已有号码
				if (!bindXSet.contains(importNumber.getBindX())) {
					newPhones.add(importNumber);
				}
			}
			if (newPhones.isEmpty()) {
				ImportNumberVO importNumberVO = new ImportNumberVO();
				importNumberVO.setImportCount(0);
				return ErpResponseJson.ok(importNumberVO);
			} else {
				param.setPhones(newPhones);
			}
		}
		int count = erpAliyunPhoneService.importNumber(param);
		ImportNumberVO importNumberVO = new ImportNumberVO();
		importNumberVO.setImportCount(count);
		return ErpResponseJson.ok(importNumberVO);
	}

	@Override
	public ResponseJson getNumberManageList(@RequestBody NumberManageListParam param) throws Exception {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		String numberPoolName = param.getNumberPoolName();
		String numerPoolKey = null;
		if (numberPoolName != null) { 
			ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
			erpAliyunNumberPoolExample.setShardCityId(operator.getCityId());
			erpAliyunNumberPoolExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andNumberPoolNameEqualTo(numberPoolName);
			List<ErpAliyunNumberPool> numberPoolList = erpAliyunNumberPoolMapper.selectByExample(erpAliyunNumberPoolExample);
			if (!numberPoolList.isEmpty()) {
				numerPoolKey = numberPoolList.get(0).getNumberPoolKey();
			}
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpAliyunPhone> list = erpAliyunPhoneMapper.getNumberManageList(operator.getCityId(),operator.getCompId(),numerPoolKey,param.getKeys());
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		// 查询号池名称
		Set<String> numberPoolKeySet = list.stream().map(ErpAliyunPhone::getNumberPoolKey).collect(Collectors.toSet());
		ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
		erpAliyunNumberPoolExample.setShardCityId(operator.getCityId());
		erpAliyunNumberPoolExample.createCriteria().andNumberPoolKeyIn(new ArrayList<>(numberPoolKeySet));
		List<ErpAliyunNumberPool> numberPoolList = erpAliyunNumberPoolMapper.selectByExample(erpAliyunNumberPoolExample);
		Map<String, String> numberPoolMap = numberPoolList.stream().collect(Collectors.toMap(ErpAliyunNumberPool::getNumberPoolKey, ErpAliyunNumberPool::getNumberPoolName));
		
		PageInfo<ErpAliyunPhone> pageInfo = new PageInfo<>(list);
		List<NumberManageVO> numberManageList = new ArrayList<>();
		for (ErpAliyunPhone erpAliyunPhone : list) {
			NumberManageVO numberManageVO = new NumberManageVO();
			BeanUtils.copyProperties(erpAliyunPhone, numberManageVO);
			numberManageVO.setNumberPoolName(numberPoolMap.get(erpAliyunPhone.getNumberPoolKey()));
			numberManageList.add(numberManageVO);
		}
		NumberManageListVO numberManageListVO = new NumberManageListVO();
		numberManageListVO.setNumberManageList(numberManageList);
		ErpResponseJson responseJson = ErpResponseJson.ok(numberManageListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson getBindHistoryList(@RequestBody BindHistoryListParam param) throws Exception {
		Operator operator = getOperator();
		ErpAliyunPhoneBindHistoryExample erpAliyunPhoneBindHistoryExample = new ErpAliyunPhoneBindHistoryExample();
		erpAliyunPhoneBindHistoryExample.setShardCityId(operator.getCityId());
		erpAliyunPhoneBindHistoryExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andBindXEqualTo(param.getBindX());
		List<ErpAliyunPhoneBindHistory> list = erpAliyunPhoneBindHistoryMapper.selectByExample(erpAliyunPhoneBindHistoryExample);
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<BindHistoryVO> bindHistoryList = new ArrayList<>();
		for (ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory : list) {
			BindHistoryVO bindHistoryVO = new BindHistoryVO();
			bindHistoryVO.setBindUserName(erpAliyunPhoneBindHistory.getBindUserName());
			if (erpAliyunPhoneBindHistory.getBindATime() != null) {
				bindHistoryVO.setBindATime(DateTimeHelper.formatDateTimetoString(erpAliyunPhoneBindHistory.getBindATime(), DateTimeHelper.FMT_yyyyMMddHHmmss));
			}
			if (erpAliyunPhoneBindHistory.getUnbindTime() != null) {
				bindHistoryVO.setUnbindTime(DateTimeHelper.formatDateTimetoString(erpAliyunPhoneBindHistory.getUnbindTime(), DateTimeHelper.FMT_yyyyMMddHHmmss));
			}
			bindHistoryList.add(bindHistoryVO);
		}
		BindHistoryListVO bindHistoryListVO = new BindHistoryListVO();
		bindHistoryListVO.setBindHistoryList(bindHistoryList);
		return ErpResponseJson.ok(bindHistoryListVO);
	}

	@Override
	public ResponseJson unBindNumber(@RequestBody UnBindNumberParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setOperateUserId(operator.getUserId());
		erpAliyunPhoneService.unBindNumber(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson releaseNumber(@RequestBody ReleaseNumberParam param) throws Exception {
//		if (true) {
//			throw new BusinessException("释放接口暂时不提，不然就没号码了");
//		}
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		erpAliyunPhoneService.releaseNumber(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson bindNumber(@RequestBody BindNumberParam param) throws Exception {
		// 判断该号码已经绑定了
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setOperateUserId(operator.getUserId());
		String bindX = param.getBindX();
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(operator.getCityId());
		erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andBindXEqualTo(bindX).andNumberStateEqualTo(Byte.valueOf("1"));
		int count = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
		if (count > 0) {
			throw new BusinessException("该小号已被绑定");
		}
		erpAliyunPhoneService.bindNumber(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson getUnBindNumberList(@RequestBody UnBindNumberListParam param) throws Exception {
		Operator operator = getOperator();
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setOrderByClause("ID asc");
		erpAliyunPhoneExample.setShardCityId(operator.getCityId());
		Criteria criteria = erpAliyunPhoneExample.createCriteria();
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(operator.getCityId(), operator.getCompId(), param.getOrganizationId());
		String[] organizationPathArr = erpFunOrganization.getOrganizationPath().split(":");
		List<Integer> orgIdList = new ArrayList<>();
		for (int i = 0; i < organizationPathArr.length; i++) {
			String orgId = organizationPathArr[i];
			if (StringUtil.isNotEmpty(orgId)) {
				orgIdList.add(Integer.parseInt(orgId));
			}
		}
		
		criteria.andCompIdEqualTo(operator.getCompId()).andIsreleaseEqualTo(Byte.valueOf("0")).andNumberStateEqualTo(Byte.valueOf("0")).andOrgIdIn(orgIdList);
		
		if (StringUtil.isNotEmpty(param.getKeys())) {
			criteria.andBindXLike("%" + param.getKeys() + "%");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpAliyunPhone> list = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		PageInfo<ErpAliyunPhone> pageInfo = new PageInfo<>(list);
		List<UnBindNumberVO> UnBindNumberList = new ArrayList<>();
		for (ErpAliyunPhone erpAliyunPhone : list) {
			UnBindNumberVO unBindNumberVO = new UnBindNumberVO();
			unBindNumberVO.setBindX(erpAliyunPhone.getBindX());
			UnBindNumberList.add(unBindNumberVO);
		}
		UnBindNumberListVO unBindNumberListVO = new UnBindNumberListVO();
		unBindNumberListVO.setBindXList(UnBindNumberList);
		ErpResponseJson responseJson = ErpResponseJson.ok(unBindNumberListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson getBindLogList(@RequestBody BindLogListParam param) throws Exception {
		Operator operator = getOperator();
		Byte bindFlag = param.getBindFlag();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		String numberPoolName = param.getNumberPoolName();
		if (StringUtil.isNotBlank(param.getEndTime())) {
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		if (numberPoolName != null) { 
			ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
			erpAliyunNumberPoolExample.setShardCityId(operator.getCityId());
			erpAliyunNumberPoolExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andNumberPoolNameEqualTo(numberPoolName);
			List<ErpAliyunNumberPool> numberPoolList = erpAliyunNumberPoolMapper.selectByExample(erpAliyunNumberPoolExample);
			if (!numberPoolList.isEmpty()) {
				String numerPoolKey = numberPoolList.get(0).getNumberPoolKey();
				param.setNumberPoolKey(numerPoolKey);
			}
		}
		if (!Byte.valueOf("1").equals(param.getIsExport())) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		}
		List<ErpAliyunPhoneBindHistory> list = erpAliyunPhoneBindHistoryMapper.getAliyunPhoneBindHistory(cityId, param);
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		PageInfo<ErpAliyunPhoneBindHistory> pageInfo = new PageInfo<>(list);
		Set<Integer> userIdSet = list.stream().map(ErpAliyunPhoneBindHistory::getBindUserId).collect(Collectors.toSet());
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andUserIdIn(new ArrayList<>(userIdSet));
		List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		Map<Integer, ErpFunUsers> usersMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
		
		Set<String> numberPoolKeySet = list.stream().map(ErpAliyunPhoneBindHistory::getNumberPoolKey).collect(Collectors.toSet());
		ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
		erpAliyunNumberPoolExample.setShardCityId(cityId);
		erpAliyunNumberPoolExample.createCriteria().andNumberPoolKeyIn(new ArrayList<>(numberPoolKeySet));
		List<ErpAliyunNumberPool> numberPoolList = erpAliyunNumberPoolMapper.selectByExample(erpAliyunNumberPoolExample);
		Map<String, String> numberPoolMap = numberPoolList.stream().collect(Collectors.toMap(ErpAliyunNumberPool::getNumberPoolKey, ErpAliyunNumberPool::getNumberPoolName));
		List<BindLogVO> bindLogList = new ArrayList<>();
		for (ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory : list) {
			BindLogVO bindLogVO = new BindLogVO();
			bindLogVO.setBindA(erpAliyunPhoneBindHistory.getBindA());
			bindLogVO.setBindUserId(erpAliyunPhoneBindHistory.getBindUserId());
			bindLogVO.setBindX(erpAliyunPhoneBindHistory.getBindX());
			bindLogVO.setNumberPoolName(numberPoolMap.get(erpAliyunPhoneBindHistory.getNumberPoolKey()));
			if (Byte.valueOf("0").equals(bindFlag)) {
				bindLogVO.setOperateUserId(erpAliyunPhoneBindHistory.getBindOperateUserId());
				bindLogVO.setTime(DateTimeHelper.formatDateTimetoString(erpAliyunPhoneBindHistory.getBindATime(),DateTimeHelper.FMT_yyyyMMddHHmmss));
			} else {
				bindLogVO.setTime(DateTimeHelper.formatDateTimetoString(erpAliyunPhoneBindHistory.getUnbindTime(),DateTimeHelper.FMT_yyyyMMddHHmmss));
				bindLogVO.setOperateUserId(erpAliyunPhoneBindHistory.getUnbindOperateUserId());
			}
			bindLogVO.setOrgId(erpAliyunPhoneBindHistory.getBindAOrgId());
			ErpFunUsers erpFunUsers = usersMap.get(erpAliyunPhoneBindHistory.getBindUserId());
			if (erpFunUsers != null) {
				bindLogVO.setUserPosition(erpFunUsers.getUserPosition());
			}
			bindLogList.add(bindLogVO);
		}
		BindLogListVO bindLogListVO = new BindLogListVO();
		bindLogListVO.setBindLogList(bindLogList);
		ErpResponseJson responseJson = ErpResponseJson.ok(bindLogList);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson batchBindNumber(@RequestBody BatchBindNumberParam param) throws Exception {
		Operator operator = getOperator();
		// 判断号码余量是否充足
		String[] userIdArr = param.getUserIds().split(",");
		// 需要绑定的人
		List<Integer> userIdList = new ArrayList<>();
		for (int i = 0; i < userIdArr.length; i++) {
			userIdList.add(Integer.parseInt(userIdArr[i]));
		}
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(operator.getCityId());
		erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andBindUserIdIn(userIdList).andIsreleaseEqualTo(Byte.valueOf("0")).andNumberStateEqualTo(Byte.valueOf("1"));
		List<ErpAliyunPhone> list = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if (!list.isEmpty()) {
			// 排除已绑定
			List<Integer> bindUserIdList = list.stream().map(ErpAliyunPhone::getBindUserId).collect(Collectors.toList());
			userIdList.removeAll(bindUserIdList);
		}
		if (userIdList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		String result = erpAliyunPhoneService.batchBindNumber(operator.getCityId(), operator.getCompId(), operator.getUserId(), userIdList);
		if (StringUtil.isNotEmpty(result)) {
			throw new BusinessException("当前号码余量不足");
		}
		return ErpResponseJson.ok();
	}
	
	@Override
	public ResponseJson batchUnBindNumber(@RequestBody BatchUnBindNumberParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setOperateUserId(operator.getUserId());
		erpAliyunPhoneService.batchUnBindNumber(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson getAxnManageList(@RequestBody AxnManageListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		
		List<Integer> orgIdList = null;
		if (param.getOrganizationId() != null) {
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(cityId);
			erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationPathLike("%"+ param.getOrganizationId() +"%");
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		}
		
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(cityId);
		if (orgIdList == null) {
			erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(compId).andIsreleaseEqualTo(Byte.valueOf("0"));
		} else {
			erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(compId).andIsreleaseEqualTo(Byte.valueOf("0")).andOrgIdIn(orgIdList);
		}
		
		// 号码总数
		int totalNumber = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
		// 已绑定数
		erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(cityId);
		if (orgIdList == null) {
			erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(compId).andIsreleaseEqualTo(Byte.valueOf("0")).andNumberStateEqualTo(Byte.valueOf("1"));
		} else {
			erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(compId).andIsreleaseEqualTo(Byte.valueOf("0")).andNumberStateEqualTo(Byte.valueOf("1")).andOrgIdIn(orgIdList);
		}
		int bindNumber = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
		// 未绑定数
		int unbindNumber = totalNumber - bindNumber;
		AxnManageListVO axnManageListVO = new AxnManageListVO();
		axnManageListVO.setTotalNumber(totalNumber);
		axnManageListVO.setBindNumber(bindNumber);
		axnManageListVO.setUnbindNumber(unbindNumber);
		
		List<AxnManageVO> axnManageList = new ArrayList<>();
		if (!Byte.valueOf("1").equals(param.getIsExport())) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		}
		List<AliyunPhoneDto> list = erpAliyunPhoneMapper.getAxnManageList(operator.getCityId(), param);
		PageInfo<AliyunPhoneDto> pageInfo = new PageInfo<>(list);
		for (AliyunPhoneDto aliyunPhoneDto : list) {
			AxnManageVO axnManageVO = new AxnManageVO();
			BeanUtils.copyProperties(aliyunPhoneDto, axnManageVO);
			if (StringUtil.isNotEmpty(aliyunPhoneDto.getBindA())) {
				axnManageVO.setUserMobile(aliyunPhoneDto.getBindA());
			}
			axnManageList.add(axnManageVO);
		}
		axnManageListVO.setAxnManageList(axnManageList);
		ErpResponseJson responseJson = ErpResponseJson.ok(axnManageListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson getCallRecordList(@RequestBody CallRecordListParam param) throws Exception {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		if (StringUtil.isNotBlank(param.getEndTime())) {
			param.setEndTime(param.getEndTime() + " 23:59:59");
		}
		if (!Byte.valueOf("1").equals(param.getIsExport())) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		}
		List<AdminIpCallLog> list = adminIpCallLogMapper.getCallRecordList(param);
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		Integer queryOrgId = param.getOrganizationId();
		if (queryOrgId == null) {
			queryOrgId = 0;
		}
		// 是否有语音全号查看权
		boolean viewAxbCallRecordCoreOrganization = erpUserOpersService.judgePermission(operator.getCityId(), operator.getUserId(), "VIEW_AXB_CALL_RECORD_CORE_ORGANIZATION");
		// 是否有语音查看权
		boolean axbRecordingOrganization = erpUserOpersService.judgePermission(operator.getCityId(), operator.getUserId(), "AXB_RECORDING_ORGANIZATION");
		
		PageInfo<AdminIpCallLog> pageInfo = new PageInfo<>(list);
		List<CallRecordVO> callRecordList = new ArrayList<>();
		for (AdminIpCallLog adminIpCallLog : list) {
			CallRecordVO callRecordVO = new CallRecordVO();
			BeanUtils.copyProperties(adminIpCallLog, callRecordVO);
			callRecordVO.setStartTime(DateTimeHelper.formatDateTimetoString(adminIpCallLog.getStartTime(),DateTimeHelper.FMT_yyyyMMddHHmmss));
			callRecordVO.setEndTime(DateTimeHelper.formatDateTimetoString(adminIpCallLog.getEndTime(),DateTimeHelper.FMT_yyyyMMddHHmmss));
			if (StringUtil.isNotEmpty(adminIpCallLog.getCallRecordUrl())) {
				callRecordVO.setCallRecordUrl(AppConfig.getPicDomainUrl() + adminIpCallLog.getCallRecordUrl());
			}
			callRecordVO.setCalledPhone(adminIpCallLog.getCalledPhone());
			callRecordVO.setCallSource(this.getLogSource(StringUtil.toString(adminIpCallLog.getLogSource())));
			callRecordVO.setCallType(this.getCallType(StringUtil.toString(adminIpCallLog.getCallType())));
			callRecordList.add(callRecordVO);
			if (!viewAxbCallRecordCoreOrganization) {
				callRecordVO.setCalledPhone(callRecordVO.getCalledPhone().substring(0, 3) + "****" + callRecordVO.getCalledPhone().substring(8, callRecordVO.getCalledPhone().length()));
			}
			if (!axbRecordingOrganization) {
				callRecordVO.setCallRecordUrl("");
			}
		}
		CallRecordListVO callRecordListVO = new CallRecordListVO();
		callRecordListVO.setCallRecordList(callRecordList);
		ErpResponseJson responseJson = ErpResponseJson.ok(callRecordListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}

	@Override
	public ResponseJson getPhoneBillList(@RequestBody PhoneBillListParam param) throws Exception {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		if (StringUtil.isNotEmpty(param.getSuffix())) {
			String time = DateUtil.DateToString(DateUtil.StringToDate(param.getSuffix() + "-01 00:00:00"));
			param.setSuffixEnd(DateUtil.getLastDay(time));
			param.setSuffixStart(DateUtil.getFirstDay(time));
		}
		// 有组织对应号池的就用号池的组织
		if (null != param.getOrganizationId()) {
			if (param.getOrganizationId() == 0) {
				param.setOrganizationId(null);
			} else {
				ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
				erpAliyunNumberPoolExample.setShardCityId(operator.getCityId());
				erpAliyunNumberPoolExample.createCriteria().andOrgIdEqualTo(param.getOrganizationId());
				int count = erpAliyunNumberPoolMapper.countByExample(erpAliyunNumberPoolExample);
				if (count > 0) {
					param.setPoolOrganizationId(param.getOrganizationId());
					param.setOrganizationId(null);
				}
			}
		}
		if(!Integer.valueOf(1).equals(param.getIsExport())) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		}
		List<PhoneBillVO> phoneBillList = erpAliyunTelephoneBillMapper.getPhoneBillList(operator.getAdminCompId(), param);
		PageInfo<PhoneBillVO> pageInfo = new PageInfo<>(phoneBillList);
		PhoneBillListVO phoneBillListVO = new PhoneBillListVO();
		if (phoneBillList.size() > 0) {
			phoneBillListVO = erpAliyunTelephoneBillMapper.getPhoneBillTotal(operator.getAdminCompId(), param);
			for (PhoneBillVO phoneBillVO : phoneBillList) {
				if (StringUtil.isNotBlank(phoneBillVO.getBindATime())) {
					phoneBillVO.setBindATime(DateTimeHelper.formatDateTimetoString(phoneBillVO.getBindATime(),DateTimeHelper.FMT_yyyyMMddHHmmss));
				}
			}
		}
		phoneBillListVO.setPhoneBillList(phoneBillList);
		ErpResponseJson responseJson = ErpResponseJson.ok(phoneBillListVO);
		responseJson.setTotal(pageInfo.getTotal());
		return responseJson;
	}
	
	private String getLogSource(String logSource) {
		if ("1".equals(logSource)) {
			return "去电";
		} else if ("2".equals(logSource)) {
			return "来电";
		}
		return "";
	}
	
	private String getCallType(String callType) {
		if ("1".equals(callType)) {
			return "出售";
		} else if ("2".equals(callType)) {
			return "出租";
		} else if ("3".equals(callType)) {
			return "求购";
		} else if ("4".equals(callType)) {
			return "求租";
		}
		return "其他";
	}

	@Override
	public ResponseJson getPoolNameList(@RequestBody PoolNameListParam param) throws Exception {
		Operator operator = getOperator();
		ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
		erpAliyunNumberPoolExample.setShardCityId(operator.getCityId());
		erpAliyunNumberPoolExample.createCriteria().andCompIdEqualTo(operator.getCompId());
		List<ErpAliyunNumberPool> list = erpAliyunNumberPoolMapper.selectByExample(erpAliyunNumberPoolExample);
		if (list.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<PoolNameVO> poolNameList = new ArrayList<>();
		for (ErpAliyunNumberPool erpAliyunNumberPool : list) {
			PoolNameVO poolNameVO = new PoolNameVO();
			poolNameVO.setNumberPoolKey(erpAliyunNumberPool.getNumberPoolKey());
			poolNameVO.setNumberPoolName(erpAliyunNumberPool.getNumberPoolName());
			poolNameList.add(poolNameVO);
		}
		PoolNameListVO poolNameListVO = new PoolNameListVO();
		poolNameListVO.setPoolNameList(poolNameList);
		return ErpResponseJson.ok(poolNameList);
	}
	
}

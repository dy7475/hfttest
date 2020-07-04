package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunViewLogMapper;
import com.myfun.repository.erpdb.dao.ErpIpCallLogRecordMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunViewLog;
import com.myfun.repository.erpdb.po.ErpFunViewLogExample;
import com.myfun.repository.erpdb.po.ErpIpCallLogRecordExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpFunViewLogService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
@Service
public class ErpFunViewLogServiceImpl extends AbstractService<ErpFunViewLog, ErpFunViewLog> implements ErpFunViewLogService{
	@Autowired ErpFunViewLogMapper erpFunViewLogMapper;
	@Autowired ErpFunTrackService erpFunTrackService;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpIpCallLogRecordMapper erpIpCallLogRecordMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Override
	public void setBaseMapper() {
		
	}
	/**
	 * 当天是否已查看某条记录
	 */
	@Transactional
	@Override
	public Map<String,Object> detectViewLog(Integer cityId, Integer viewUserId, Integer infoUserId,
			Integer caseId, Integer caseType, Integer saleLeaseId, boolean isGeneralManager,
			Integer compId, Integer deptId,  Integer ownerId, String caseNo, Byte plateType,
			Integer targetDept, String pcname, Byte caseStatus, String currUserName, Integer caseDeptId ,
			Integer trackFromType, Integer selfUserId, String trackContent, Integer isMobileApi) {

		Map<String, Object> viewCountMap = new HashMap<>();
		viewCountMap.put("viewCount", 0);
		viewCountMap.put("isWorkAddCount", false);
		String viewById = getCacheViewById(cityId, viewUserId, caseId, caseType, saleLeaseId);
		if (isGeneralManager && !viewUserId.equals(infoUserId)) {
			if (viewById != null) {
				viewCountMap.put("viewCount", 1);
				return viewCountMap;
			}
			ErpFunViewLog erpFunViewLog = this.createViewLog(cityId, compId, deptId, viewUserId, ownerId, caseId,
					caseType.byteValue(), caseNo, plateType, targetDept, pcname, Const.DIC_VIEW_STATUS_AVAILABLE,
					isMobileApi);
			Integer trackId = erpFunTrackService.writeTrackByGeneralViewLog(erpFunViewLog, caseStatus, currUserName, caseDeptId, selfUserId, trackContent);
			viewCountMap.put("viewCount", 1);
			viewCountMap.put("trackId", trackId);
			viewCountMap.put("isWorkAddCount", true);
			return viewCountMap;
		}
		// 精英版不存在核心信息的查看，所以当trackFromType等于1时，肯定是营销版写跟进
		if (1 == trackFromType) {
			if (!isGeneralManager) {
				// 赢销版下查看他人核心数据,不支持跨门店查询其他店核心数据
				if (!viewUserId.equals(ownerId) && Const.DIC_PLATE_TYPE_PRIVATE.equals(plateType)) {
					// 不是本人的数据,并且查看的是私盘数据
					throw new ConfirmException("对不起，你没有权限查看该信息");
				}
			}
			viewCountMap.put("viewCount", 1);
			return viewCountMap;
		}
		if (viewById == null) {
			// 检查是否达到上限
			this.checkHouseCustViewCountMax(cityId, compId, caseId, caseType);
			viewCountMap.put("viewCount", 0);
			return viewCountMap;
		} else {
			viewCountMap.put("viewCount", 1);
			return viewCountMap;
		}
	}
	
	/**
	 * 检查房客源当天查看条数是否已到上限
	 * @author 方李骥
	 * @since 2017年11月01日
	 * @param caseId
	 * @param caseType
	 * @throws Exception
	 */
	private void checkHouseCustViewCountMax(Integer cityId, Integer compId, Integer caseId, Integer caseType) {
		String coreInfoViewCount = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_VIEW_COUNT");
		Integer countInt = StringUtil.paseInteger(coreInfoViewCount, 0);
		if (countInt <= 0) {
			return;// 没有控制直接返回
		}
		// 添加当天查看量是否大于10条,大于10条,不能查看
		String dateNowStr = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		Date dateNow = DateTimeHelper.parseToDate(dateNowStr);
		ErpFunViewLogExample example = new ErpFunViewLogExample();
		example.setShardCityId(cityId);
		example.createCriteria().andTargetTypeEqualTo(caseType.byteValue())
			.andTargetIdEqualTo(caseId).andViewTimeGreaterThanOrEqualTo(dateNowStr);
		int viewCount = erpFunViewLogMapper.countByExample(example);
		ErpIpCallLogRecordExample ipCallLogExample = new ErpIpCallLogRecordExample();
		ipCallLogExample.setShardCityId(cityId);
		ipCallLogExample.createCriteria().andCaseTypeEqualTo(caseType).andCaseIdEqualTo(caseId)
			.andCreateDateGreaterThanOrEqualTo(dateNow);
		int ipCount = erpIpCallLogRecordMapper.countByExample(ipCallLogExample);
		int totalCount = viewCount + ipCount;
		if (totalCount > countInt) {
			throw new ConfirmException("该房源被查看次数已达上限！");
		}
	}
	
	/**
	 * 查询是否查看过电话，包含租售房源
	 * @author 张宏利
	 * @since 2017年10月31日
	 * @param cityId 城市ID
	 * @param viewUserId 查看人
	 * @param caseId 房源ID
	 * @param caseType 房源类型
	 * @param saleLeaseId 可租售ID
	 * @return
	 */
	private String getCacheViewById(Integer cityId, Integer viewUserId, Integer caseId, Integer caseType, Integer saleLeaseId) {
		String cacheView = getCacheView(cityId, viewUserId, caseId, caseType);
		if(cacheView == null && saleLeaseId != null) {
			caseType = (caseType == 1) ? 2 : 1;
			cacheView = getCacheView(cityId, viewUserId, saleLeaseId, caseType);
		}
		return cacheView;
	}

	/**
	 * 查询是否查看过电话
	 * @author 张宏利
	 * @since 2017年10月31日
	 * @param cityId 城市ID
	 * @param viewUserId 查看人
	 * @param caseId 房源ID
	 * @param caseType 房源类型
	 * @return
	 */
	private String getCacheView(Integer cityId, Integer viewUserId, Integer caseId, Integer caseType) {
		String key = Const.CacheStructure.BS_hfterpdb_funViewLogCache_By_USER_ID + viewUserId + "_TARGET_ID_" + caseId + "_TARGET_TYPE_" + caseType;
		String viewCache = (String)cacheUtil.get(key);
		if(viewCache == null) {
			String dateNow = DateTimeHelper.formatDatetoString(new Date());
			ErpFunViewLog erpFunViewLog = erpFunViewLogMapper.getViewLog(cityId, viewUserId, caseId, caseType, dateNow);
			if(erpFunViewLog != null) {
			    cacheUtil.put(key, "true");
				return "true";
			}
		}
		return viewCache;
	} 

	@Transactional
	@Override
	public ErpFunViewLog createViewLog(Integer cityId, Integer compId, Integer deptId, Integer viewUserId, 
			Integer ownerId, Integer caseId, Byte caseType, String caseNo, Byte plateType,
			Integer targetDept, String pcname, Byte viewStatus, Integer isMobileApi) {
		isMobileApi = Optional.ofNullable(isMobileApi).orElse(0);
		ErpFunViewLog erpFunViewLog = new ErpFunViewLog();
		erpFunViewLog.setCompId(compId);
		erpFunViewLog.setDeptId(deptId);
		erpFunViewLog.setOwnerId(ownerId);
		if(StringUtils.isNotBlank(pcname) && "null".equals(pcname.trim())) {
			pcname = null;
		}
		erpFunViewLog.setPcname(pcname);
		erpFunViewLog.setPlateType(plateType);
		erpFunViewLog.setShardCityId(cityId);
		erpFunViewLog.setTargetId(caseId);
		erpFunViewLog.setTargetType(caseType);
		erpFunViewLog.setTargetNo(caseNo);
		erpFunViewLog.setTargetDept(targetDept);
		erpFunViewLog.setViewUser(viewUserId);
		erpFunViewLog.setViewTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunViewLog.setViewSource((byte) ((isMobileApi == 1) ? 1 : 0));
		erpFunViewLog.setViewStatus(viewStatus);

		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType+"")) {
			ErpFunSale funSaleBySaleId = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(funSaleBySaleId != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(funSaleBySaleId.getSaleStatus()+"")) || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(funSaleBySaleId.getSaleStatus()+"")) {
				erpFunViewLog.setViewCaseStatus(funSaleBySaleId.getSaleStatus());
			}
		} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType+"")) {
			ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(funLeaseByLeaseId != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(funLeaseByLeaseId.getLeaseStatus()+"")) || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(funLeaseByLeaseId.getLeaseStatus()+"")) {
				erpFunViewLog.setViewCaseStatus(funLeaseByLeaseId.getLeaseStatus().byteValue());
			}
		}

		erpFunViewLogMapper.insertSelective(erpFunViewLog);
		String key = Const.CacheStructure.BS_hfterpdb_funViewLogCache_By_USER_ID + viewUserId + "_TARGET_ID_" + caseId + "_TARGET_TYPE_" + caseType;
		cacheUtil.put(key, "true");
		return erpFunViewLog;
	}
}

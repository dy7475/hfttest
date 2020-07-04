package com.myfun.service.business.report.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerKey;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.reportdb.dao.ReportFunStatisticDetail1Mapper;
import com.myfun.repository.reportdb.po.ReportFunStatisticDetail1;
import com.myfun.repository.reportdb.po.ReportFunStatisticTotle;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminIpCallLogService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.report.ReportFunStatisticDetail1Service;
import com.myfun.service.business.report.ReportFunStatisticTotleService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.DateUtil.DateStyle;
import com.myfun.utils.StringUtil;

@Service
public class ReportFunStatisticDetail1ServiceImpl extends AbstractService<ReportFunStatisticDetail1, Long>implements ReportFunStatisticDetail1Service {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportFunStatisticDetail1ServiceImpl.class);
	@Autowired private ReportFunStatisticDetail1Mapper reportFunStatisticDetail1Mapper;
	@Autowired private ReportFunStatisticTotleService reportFunStatisticTotleService;
	@Autowired private AdminIpCallLogService adminIpCallLogService;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	
	// 统计次的放到这里面
	private static final Set<String> countFiled;
	static{
		countFiled = new HashSet<String>();
		countFiled.add(StatisticDetailType.GJ_COUNT.name());
		countFiled.add(StatisticDetailType.YJ_COUNT.name());
		countFiled.add(StatisticDetailType.IPCALL_COUNT.name());
	}
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = reportFunStatisticDetail1Mapper;
	}

	@Override
	public void addWorkCount(ReportFunStatisticDetail1 detail, Integer jmsMsgId, int index) {
		// 如果不是以次数来统计的（统计量）
		if(!countFiled.contains(detail.getCountFieldName())){
			String trackId = null;
			if(!detail.getStatisticType().equals(StatisticDetailType.DK_COUNT.getIndex())
				&& !detail.getStatisticType().equals(StatisticDetailType.SPDK_COUNT.getIndex())
					){
				trackId = detail.getTrackId();
				detail.setTrackId(null);// 现在只有带看才会把trackId加入判重逻辑
			}
			// 则一天、一人、一类型、一ID只能算一个量
			// 有量时直接返回，不加量
			if(0 < reportFunStatisticDetail1Mapper.count(detail)){
				return;
			}
			if(trackId != null){
				detail.setTrackId(trackId);
			}
		}
		if(detail.getCaseStatus() == null || detail.getCaseCreateTime() == null) {
			Map<String, Object> houseCustInfo = getHouseCustInfo(detail.getCityId(), detail.getCaseId(), detail.getCaseType());
			detail.setCaseStatus(StringUtil.parseInteger(houseCustInfo.get("caseStatus"), 1));
			detail.setCaseCreateTime((Date)houseCustInfo.get("creationTime"));
		}
		reportFunStatisticDetail1Mapper.insertToDetail(detail);
		ReportFunStatisticTotle erpFunStatisticTotle = new ReportFunStatisticTotle();
		erpFunStatisticTotle.setDkdownCount(0);// 必须要个初始值
		erpFunStatisticTotle.setCompId(detail.getCompId());
		erpFunStatisticTotle.setAreaId(detail.getAreaId());
		erpFunStatisticTotle.setRegId(detail.getRegId());
		erpFunStatisticTotle.setDeptId(detail.getDeptId());
		erpFunStatisticTotle.setGrId(detail.getGrId());
		erpFunStatisticTotle.setUserId(detail.getUserId());
		erpFunStatisticTotle.setArchiveId(detail.getArchiveId());
		erpFunStatisticTotle.setCityId(detail.getCityId());
		erpFunStatisticTotle.setCaseType(detail.getCaseType());
		erpFunStatisticTotle.setCreateTime(detail.getCreateTime());
		erpFunStatisticTotle.setCountFieldName(detail.getCountFieldName());
		// 这里的顺序不能改，不然要重新生成所有库的MERGE_KEY
		String mergeKey = getMergeKey(detail.getCaseType(), detail);
		//'${caseType}_${cityId}_${compId}_${areaId}_${regId}_${deptId}_${grId}_${userId}_'+CONVERT(VARCHAR(10),#{createTime},120)
		erpFunStatisticTotle.setMergeKey(mergeKey);
		reportFunStatisticTotleService.addWorkCount(erpFunStatisticTotle);
	}
	
	/**
	 * 获取房客源信息
	 * @author 张宏利
	 * @since 2017年8月7日
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	private Map<String, Object> getHouseCustInfo(Integer cityId, Integer caseId, Integer caseType) {
		Map<String, Object> result = new HashMap<>();
		if(Const.HouseCustType.SALE == caseType) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(erpFunSale != null) {
				result.put("caseStatus", erpFunSale.getSaleStatus());
				result.put("creationTime", erpFunSale.getCreationTime());
			}
		} else if(Const.HouseCustType.LEASE == caseType) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(erpFunLease != null) {
				result.put("caseStatus", erpFunLease.getLeaseStatus());
				result.put("creationTime", erpFunLease.getCreationTime());
			}
		} else if(Const.HouseCustType.BUY_CUST == caseType) {
			ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			if(erpFunBuyCustomer != null) {
				result.put("caseStatus", erpFunBuyCustomer.getBuyCustStatus());
				result.put("creationTime", erpFunBuyCustomer.getCreationTime());
			}
		} else if(Const.HouseCustType.RENT_CUST == caseType) {
			ErpFunRentCustomerKey id = new ErpFunRentCustomerKey();
			id.setRentCustId(caseId);
			id.setShardCityId(cityId);
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(id);
			if(erpFunRentCustomer != null) {
				result.put("caseStatus", erpFunRentCustomer.getRentCustStatus());
				result.put("creationTime", erpFunRentCustomer.getCreationTime());
			}
		}
		return result;
	}
	
	private String getMergeKey(Integer caseType, ReportFunStatisticDetail1 detail) {
		return new StringBuilder()
				.append(caseType)
				.append("_").append(detail.getCityId())
				.append("_").append(detail.getCompId())
				.append("_").append(detail.getAreaId())
				.append("_").append(detail.getRegId())
				.append("_").append(detail.getDeptId())
				.append("_").append(detail.getGrId())
				.append("_").append(detail.getUserId())
				.append("_").append(DateTimeHelper.formatDatetoString(detail.getCreateTime()))
				.toString();
	}
	
	@Override
	public void adminAddWorkCount(String sessionId) {
		// 还是try一下，不要影响前面的逻辑
		try {
			AdminIpCallLog adminIpCallLog = adminIpCallLogService.selectByPrimaryKey(sessionId);
			// 通话时长大于1秒才算一个量，小于等于0就返回，不增加量
			if(adminIpCallLog.getCallLength() <= 0){
				return;
			}
			ErpFunUsers erpFunUsers = erpFunUsersService.selectByArchiveId(adminIpCallLog.getCallCityId().shortValue(), adminIpCallLog.getCallArchiveId());
			ReportFunStatisticDetail1 countInfo = new ReportFunStatisticDetail1();
			countInfo.setAreaId(erpFunUsers.getAreaId());
			countInfo.setCaseType(adminIpCallLog.getTargetType().intValue());
			countInfo.setStatisticType(StatisticDetailType.IPCALL_COUNT.getIndex());
			countInfo.setDeptId(erpFunUsers.getDeptId());
			countInfo.setCityId(erpFunUsers.getCityId().intValue());
			countInfo.setCompId(erpFunUsers.getCompId());
			countInfo.setGrId(erpFunUsers.getGrId());
			countInfo.setRegId(erpFunUsers.getRegId());
			countInfo.setUserId(erpFunUsers.getUserId());
			countInfo.setCountFieldName(StatisticDetailType.IPCALL_COUNT.name());
			countInfo.setCreateTime(DateUtil.StringToDate(DateUtil.getDate(new Date()),DateStyle.YYYY_MM_DD));
			countInfo.setCaseId(adminIpCallLog.getTargetId());
			countInfo.setTrackId(adminIpCallLog.getLogId());
			this.addWorkCount(countInfo, 0, 0);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}

}

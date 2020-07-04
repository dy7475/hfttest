package com.myfun.service.business.searchdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminWfBrokerCommentMapper;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.agencydb.dao.*;
import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.agencydb.dto.AgencyVipBuyDto;
import com.myfun.repository.agencydb.dto.AgencyVipRentDto;
import com.myfun.repository.agencydb.po.AgencyPurchaseBorker;
import com.myfun.repository.agencydb.po.AgencyWebClient;
import com.myfun.repository.searchdb.dao.SearchSosoViewCountMapper;
import com.myfun.repository.searchdb.dao.SearchSosoViewMapper;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.repository.searchdb.po.SearchSosoViewCount;
import com.myfun.repository.searchdb.po.SearchSosoViewCountExample;
import com.myfun.repository.searchdb.po.SearchSosoViewKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyDataParam;
import com.myfun.service.business.searchdb.SearchSosoViewService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class SearchSosoViewServiceImpl extends AbstractService<SearchSosoView, SearchSosoViewKey> implements SearchSosoViewService {
	@Autowired
	private SearchSosoViewMapper searchSosoViewMapper;
	@Autowired
	private SearchSosoViewCountMapper searchSosoViewCountMapper;
	@Autowired
	private AdminSysParaService adminSysParaService;
	@Autowired
	private AdminFunUserAccountService adminFunUserAccountService;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AgencyVipSaleMapper agencyVipSaleMapper;
	@Autowired
	private AgencyVipBuyMapper agencyVipBuyMapper;
	@Autowired
	private AgencyVipRentMapper agencyVipRentMapper;
	@Autowired
	private AgencyWebClientMapper agencyWebClientMapper;
	@Autowired
	private AgencyPurchaseBorkerMapper agencyPurchaseBorkerMapper;
	@Autowired
	private AdminWfBrokerCommentMapper adminWfBrokerCommentMapper;
	@Autowired
	private AdminFunPaidMapper adminFunPaidMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;


	public static Map<String, String> VIP_TABLE_MAP = new HashMap<String, String>();
	public static Map<String, String> VIP_FIELD_MAP = new HashMap<String, String>();
	public static Map<String, String> VIP_CASETYPE_MAP = new HashMap<String, String>();
	private static final int GIFT_PRICE = 5; // 首次购买赠送5元花费
	private static final int CALL_NUM = 5; // 购买一次的拨打次数

	static {
		VIP_TABLE_MAP.put("1", "VIP_SALE");
		VIP_TABLE_MAP.put("2", "VIP_LEASE");
		VIP_TABLE_MAP.put("3", "VIP_BUY");
		VIP_TABLE_MAP.put("4", "VIP_RENT");
		VIP_CASETYPE_MAP.put("1", "SALE_FUN");
		VIP_CASETYPE_MAP.put("2", "LEASE_FUN");
		VIP_CASETYPE_MAP.put("3", "BUY_CUST");
		VIP_CASETYPE_MAP.put("4", "RENT_CUST");
		VIP_FIELD_MAP.put("1", "SALE_ID");
		VIP_FIELD_MAP.put("2", "LEASE_ID");
		VIP_FIELD_MAP.put("3", "BUY_ID");
		VIP_FIELD_MAP.put("4", "RENT_ID");

	}
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = searchSosoViewMapper;
	}

	@Transactional
	@Override
	public int decodeSosoPhone(String sosoType, Integer caseId, int uaId, int archiveId) throws Exception {
		double sosoPrice = StringUtil.parseDouble(adminSysParaService.getSysParamToString("DECODE_SOSO_PHONE_PRICE"), 10.0);
		// 判断是否账户余额是否足够支付
		AdminFunUserAccount funUserAccountPO = adminFunUserAccountService.selectByPrimaryKey(uaId);
		if (funUserAccountPO == null) {
			throw new BusinessException("请绑定资金账户");
		}
		if (StringUtil.parseDouble(funUserAccountPO.getHaofangBuy().toString(), 0.0) < sosoPrice) {
			throw new BusinessException("账户余额不足");
		}
		// 更新资金账户
		int count = adminFunUserAccountMapper.subtractMoney(sosoPrice, uaId);
		if(count <= 0){
			throw new BusinessException("账户余额不足");
		}
		//修改搜搜查看记录
		searchSosoViewMapper.updatePerpetualFlag(caseId, sosoType, archiveId);
		return 0;
	}
	
	@Transactional
	@Override
	public List<Map<String, String>> decodeNotSosoPhone(String caseType, Integer caseId, Integer uaId, int cityId, Integer archiveId, String userName, String userMobile, Integer adminDeptId) throws Exception {
		// 如果casetype是数字则转换为字母
		Map<String, String> resultMap = new HashMap<String, String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String vipStartTimeStr = null;
		AdminSysPara adminSysParaVipStartTime = adminSysParaMapper.selectByPrimaryKey("VIP_START_TIME");
		if (adminSysParaVipStartTime != null) {
			vipStartTimeStr =  adminSysParaVipStartTime.getParamValue();
		}
		String vipEndTimeStr = "";
		AdminSysPara adminSysParaVipEndTimeStr = adminSysParaMapper.selectByPrimaryKey("VIP_END_TIME");
		if (adminSysParaVipEndTimeStr != null) {
			vipEndTimeStr =  adminSysParaVipEndTimeStr.getParamValue();
		}
		String now = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		String nowTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm:ss");
		String vipStartTime = now + " " + vipStartTimeStr;
		String vipEndTime = now + " " + vipEndTimeStr;
		int start = DateTimeHelper.compareTwoDate(DateTimeHelper.parseToDate(vipStartTime), DateTimeHelper.parseToDate(nowTime));
		int end = DateTimeHelper.compareTwoDate(DateTimeHelper.parseToDate(nowTime), DateTimeHelper.parseToDate(vipEndTime));
		if (start <= 0 || end <= 0) {
			throw new BusinessException("请在" + vipStartTimeStr + "-" + vipEndTimeStr + "之间拨打电话");
		}
		// 查询信息
		AgencyCommentDto vipEl = getVipData(caseType, caseId, cityId, archiveId);
		// 判断是否被投诉
		if (StringUtil.isNotEmpty(vipEl.getWxId())) {
			if (adminWfBrokerCommentMapper.isComplaint(vipEl.getWxId(), archiveId) > 0) {
				throw new BusinessException("你已被该客户投诉，不能拨打电话");
			}
		}
		// 如果有次数默认直接拨打ip电话
		if (StringUtil.parseInteger(vipEl.getCallCount(), 0) > 0) {
			resultMap.put("callCount", vipEl.getCallCount());
			resultMap.put("clientName", vipEl.getClientName());
		} else {
			buySign(caseType, caseId, uaId, vipEl.getTradePrice(), cityId, archiveId, userName, userMobile, adminDeptId);
			//添加积分获取  陈文超添加--暂时不要
			//adminRptImScoresService.createScoresData(Constants_DIC.DIC_INTEGRAL_BIZ_MAP_SCORE_SOSO_DUJIAZHUANGONG, caseId, caseType);
			resultMap.put("callCount", String.valueOf(GIFT_PRICE));
			if (StringUtil.isEmpty(vipEl.getClientName())) {
				AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
				vipEl.setClientName(webClientPO.getClientName());
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			if((vipEl.getClientMobile()!= null) && (vipEl.getClientMobile().contains("*"))){
				AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			resultMap.put("clientName", vipEl.getClientName());
			resultMap.put("clientMobile", vipEl.getClientMobile());
			// 如果查看成功则搜搜查看记录
			String sosoId = vipEl.getSosoId();
			if (StringUtil.isNotEmpty(sosoId)) {
				String sosoType = Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ? "0" : "1";
				SearchSosoView inSosoViewMap = new SearchSosoView();
				inSosoViewMap.setArchiveId(archiveId);
				inSosoViewMap.setSosoId(Integer.valueOf(sosoId));
				inSosoViewMap.setSosoType(Integer.valueOf(sosoType));
				inSosoViewMap.setSosoProperty(0);
				inSosoViewMap.setViewTime(new Date());
				searchSosoViewMapper.insertSelective(inSosoViewMap);
			}
		}
		list.add(resultMap);
		return list;
	}
	

	/***
	 * 购买活动客户
	 * 
	 * @see SearchFunModule#deductCost
	 * @throws Exception
	 */
	private void buySign(String caseType, Integer caseId, int uaId, String tradePrice, int cityId, int archiveId, String userName, String userMobile, Integer adminDeptId) throws Exception {
		// 判断是否账户余额是否足够支付
		AdminFunUserAccount funUserAccountPO = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
		if (funUserAccountPO == null) {
			throw new BusinessException("请绑定资金账户");
		}
		if (StringUtil.parseDouble(funUserAccountPO.getHaofangBuy().toString(), 0.0) < StringUtil.parseDouble(tradePrice, 0.0)) {
			throw new BusinessException("账户余额不足");
		}
		// 扣钱
		procPurchaseVipinfo1(caseType, caseId, cityId, uaId, archiveId, userName, userMobile, adminDeptId);
	}
	
	private boolean procPurchaseVipinfo1(String caseType, Integer caseId, int cityId, int uaId, int archiveId, String userName, String userMobile, Integer adminDeptId) throws Exception {
		boolean firstBuy = false;// 是否为首次购买，如果首次购买则赠送5元花费
		AgencyCommentDto vipDo = getVipDataObject(caseType, caseId, cityId);
		if (vipDo == null) {
			throw new BusinessException("查询信息出错");
		}
		Integer buyPrice = StringUtil.parseInteger(vipDo.getTradePrice(), 5);
		String clientId = vipDo.getClientId();
		
		// 更新资金账户
		adminFunUserAccountMapper.subtractMoney(buyPrice, uaId);
		AgencyPurchaseBorker purchaseBorker = agencyPurchaseBorkerMapper.getPurchaseBorker(cityId, caseId, caseType, archiveId);
		
		if (purchaseBorker == null) {
			AgencyPurchaseBorker record = new AgencyPurchaseBorker();
			record.setCaseId(caseId.intValue());
			record.setCaseType(caseType);
			record.setClientId(Integer.valueOf(clientId));
			record.setCityId(cityId);
			record.setArchiveId(archiveId);
			record.setUaId(uaId);
			record.setUserName(userName);
			record.setUserMobile(userMobile);
			record.setPbMoney(buyPrice);
			record.setPbTime(new Date());
			record.setRefundFlag((byte) 0);
			record.setGiftCion(0);
			record.setPbCompMoney(0);
			record.setBuyCount(1);
			record.setCallCount(CALL_NUM);
			record.setPerpetualFlag((byte) 1);
			agencyPurchaseBorkerMapper.insertSelective(record);
			firstBuy = true;
		} else {
			Integer buyCount = purchaseBorker.getBuyCount();
			if (buyCount == 0) {
				firstBuy = true;
			}
			AgencyPurchaseBorker borker = new AgencyPurchaseBorker();
			borker.setCallCount(CALL_NUM);
			borker.setPbMoney(buyPrice);
			borker.setCaseId(caseId.intValue());
			borker.setCaseType(caseType);
			borker.setCityId(cityId);
			borker.setArchiveId(archiveId);
			agencyPurchaseBorkerMapper.procPurchaseVipinfo(borker);
		}
		
		// 购买次数
		String tableName = getTableByType(caseType);
		String fieldName = getFieldByType(caseType);
		agencyVipSaleMapper.addPurchaseCount(tableName, cityId, fieldName, caseId);
		
		// 写入消费记录
		AdminFunPaid record = new AdminFunPaid();
		record.setUaId(uaId);
		record.setArchiveId(archiveId);
		record.setCityId((short) cityId);
		record.setPaidCatigory("PAY");
		record.setPaidType("BIN_BUY_INFO");
		record.setAmount(Double.valueOf(buyPrice));
		record.setAmountCoin(Double.valueOf(buyPrice));
		record.setPadiTime(new Date());
		record.setDeptId(adminDeptId);
		record.setDesc("购买直供信息消费：" + buyPrice + "好房豆");
		adminFunPaidMapper.insertSelective(record );
		return firstBuy;
	}

	@Override
	public AgencyVipBuyDto getVipBuyData(SoSoBuyDataParam param) {
		// 获取详细信息
		AgencyVipBuyDto vipEl = null;
		try {
			vipEl = agencyVipBuyMapper.getVipBuyById(param.getCaseId(), param.getCityId());
		} catch (Exception e) {
			return null;
		}
		vipEl.setCallNum(CALL_NUM);
		vipEl.setGiftPrice(GIFT_PRICE);
		// 获取当前用户对当前数据的查看情况
		AgencyPurchaseBorker purchaseBorker = agencyPurchaseBorkerMapper.getPurchaseBorker(param.getCityId(), param.getCaseId(), param.getCaseType(), param.getArchiveId());
		AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
		if(webClientPO != null){
			vipEl.setClientMobile(StringUtil.encodeMobile(webClientPO.getClientMobile()));
			vipEl.setClientName(webClientPO.getClientName());
		}
		if (purchaseBorker != null) {
			// 如果已经查看
			vipEl.setCallCount(1);
			vipEl.setBuyCount(1);
			if (purchaseBorker.getCallCount() > 0) {
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			// 返回用户姓名
			vipEl.setPerpetualFlag(1);
			vipEl.setPbTime(purchaseBorker.getPbTime());
		}
		return vipEl;
	}
	
	public AgencyCommentDto getVipData(String caseType, Integer caseId, int cityId, int archiveId) throws Exception {
		// 获取详细信息
		AgencyCommentDto vipEl = getVipDataObject(caseType, caseId, cityId);
		if(vipEl == null){
			throw new BusinessException("获取数据失败");
		}
		vipEl.setCallNum(String.valueOf(CALL_NUM));
		vipEl.setGiftPrice(String.valueOf(GIFT_PRICE));
		// 获取当前用户对当前数据的查看情况
		AgencyPurchaseBorker purchaseBorkerPO = agencyPurchaseBorkerMapper.getPurchaseBorker(cityId, caseId, caseType, archiveId);
		AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
		if(webClientPO != null){
			vipEl.setClientMobile(StringUtil.encodeMobile(webClientPO.getClientMobile()));
			vipEl.setClientName(webClientPO.getClientName());
		}
		if (purchaseBorkerPO != null) {
			// 如果已经查看
			vipEl.setCallCount("1");
			vipEl.setBuyCount("1");
			if (purchaseBorkerPO.getCallCount() > 0) {
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			// 返回用户姓名
			vipEl.setPerpetualFlag("1");
			vipEl.setPbTime(purchaseBorkerPO.getPbTime());
		}
		return vipEl;
	}
	
	public AgencyCommentDto getVipDataObject(String caseType, Integer caseId, int cityId) throws Exception {
		String tableName = getTableByType(caseType);
		String fieldName = getFieldByType(caseType);
		if(tableName == null || fieldName == null){
			throw new Exception("类型错误");
		}
		AgencyCommentDto agencyCommentDto = agencyVipSaleMapper.getCaseInfo(tableName, fieldName, String.valueOf(cityId), caseId);
		return agencyCommentDto;
	}
	
	public static String getTableByType(String caseType) {
		return VIP_TABLE_MAP.get(caseType) == null ? caseType : VIP_TABLE_MAP.get(caseType);
	}

	public static String getFieldByType(String caseType) {
		return VIP_FIELD_MAP.get(caseType) == null ? caseType : VIP_FIELD_MAP.get(caseType);
	}

	public static String getEnCaseTypeByType(String caseType) {
		return VIP_CASETYPE_MAP.get(caseType) == null ? caseType : VIP_CASETYPE_MAP.get(caseType);
	}

	@Override
	public AgencyVipRentDto getVipRentData(SoSoBuyDataParam param) {
		// 获取详细信息
		AgencyVipRentDto vipEl = null;
		try {
			vipEl = agencyVipRentMapper.getVipRentById(param.getCaseId(), param.getCityId());
		} catch (Exception e) {
			return null;
		}
		vipEl.setCallNum(CALL_NUM);
		vipEl.setGiftPrice(GIFT_PRICE);
		// 获取当前用户对当前数据的查看情况
		AgencyPurchaseBorker purchaseBorker = agencyPurchaseBorkerMapper.getPurchaseBorker(param.getCityId(), param.getCaseId(), param.getCaseType(), param.getArchiveId());
		AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
		if(webClientPO != null){
			vipEl.setClientMobile(StringUtil.encodeMobile(webClientPO.getClientMobile()));
			vipEl.setClientName(webClientPO.getClientName());
		}
		if (purchaseBorker != null) {
			// 如果已经查看
			vipEl.setCallCount(1);
			vipEl.setBuyCount(1);
			if (purchaseBorker.getCallCount() > 0) {
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			// 返回用户姓名
			vipEl.setPerpetualFlag(1);
			vipEl.setPbTime(purchaseBorker.getPbTime());
		}
		return vipEl;
	}

	@Transactional
	@Override
	public void updateViewCount(SearchSosoView viewPO) {
		String dateNowStr = DateTimeHelper.formatDatetoString(new Date());
		Date dateNow = DateTimeHelper.parseToDate(dateNowStr);
		// 依据：人-门店-时间-类型 去找记录，有就查看条数+1，没有则插入
		SearchSosoViewCountExample example = new SearchSosoViewCountExample();
		example.createCriteria()
			.andArchiveIdEqualTo(viewPO.getArchiveId())
			.andDeptIdEqualTo(viewPO.getDeptId())
			.andCreationTimeEqualTo(dateNow)
			.andDataTypeEqualTo(viewPO.getDataType());
		List<SearchSosoViewCount> viewCountList = searchSosoViewCountMapper.selectByExample(example);
		if (viewCountList != null && viewCountList.size() > 0) {
			SearchSosoViewCount searchSosoViewCount = viewCountList.get(0);
			SearchSosoViewCount upRecord = new SearchSosoViewCount();
			upRecord.setId(searchSosoViewCount.getId());
			upRecord.setViewCount(searchSosoViewCount.getViewCount() + 1);
			searchSosoViewCountMapper.updateByPrimaryKeySelective(upRecord);
		} else {
			SearchSosoViewCount insertRecord = new SearchSosoViewCount();
			insertRecord.setViewCount(1);
			insertRecord.setArchiveId(viewPO.getArchiveId());
			insertRecord.setDeptId(viewPO.getDeptId());
			insertRecord.setCreationTime(dateNow);
			insertRecord.setDataType(viewPO.getDataType());
			searchSosoViewCountMapper.insertSelective(insertRecord);
		}
	}
}




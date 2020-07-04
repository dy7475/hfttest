package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.myfun.erpWeb.houseBidding.ReqHouseBiddPageParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminArchiveTodayRecordMapper;
import com.myfun.repository.admindb.dao.AdminFunBuildingBiddingMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecord;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecordExample;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunHouseBiddingDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.service.business.erpdb.ErpBuildInfoService;
import com.myfun.service.business.erpdb.ErpFunHouseBiddingService;

@Service
public class ErpFunHouseBiddingServiceImpl extends AbstractService<ErpFunHouseBidding, ErpFunHouseBidding> implements ErpFunHouseBiddingService {
	@Autowired
	ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	AdminFunUserAccountService adminFunUserAccountService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpBuildInfoService erpBuildInfoService;
	@Autowired
	AdminFunBuildingBiddingMapper adminFunBuildingBiddingMapper;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunHouseBiddingService erpFunHouseBiddingService;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	AdminArchiveTodayRecordMapper adminArchiveTodayRecordMapper;
	@Autowired
	AdminFunArchiveService adminFunArchiveService;

	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunHouseBiddingMapper;
	}

	@Override
	public Map<String, Object> getUserAccountInfo(Map<String, Object> param) {
		// 查询资金账户
		Integer cityId = Integer.valueOf(param.get("cityId")+"");
		Integer compId = Integer.valueOf(param.get("compId")+"");
		AdminFunUserAccount amountByArchiveId = adminFunUserAccountMapper.selectByPrimaryKey(Integer.valueOf(param.get("uaId") + ""));
		// 查询公司可用金额
		Date avadate = amountByArchiveId.getAvailableDate();
		String compLimitPrice = "0";
		String compUaId = param.get("compUaId")+"";
		if(StringUtils.isNotBlank(compUaId) && !"0".equals(compUaId)){//这里判断是否是精英版，用于代码统一
			compLimitPrice = erpSysParaMapper.getParamValue(cityId, compId, "HF_AMOUNT_CANUSE");//每天可用公司多好优惠券和好房币
		}else{
			compUaId = "0";//即不存在COMPUAID，用户可能为纯精英版
		}

		compLimitPrice = StringUtils.isBlank(compLimitPrice)?"0":compLimitPrice;
		// 当天已经使用公司多少好房币
		BigDecimal canUseComp = amountByArchiveId.getUsedCompHf();
		if(null == canUseComp){
			canUseComp = new BigDecimal("0");
		}
		//当天还可用的公司资金额度
		BigDecimal compAmount = new BigDecimal(compLimitPrice);
		if(avadate != null && !"".equals(avadate) && compAmount.intValue()>0){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date nowDate = calendar.getTime();
			Calendar avaDateCanleder = Calendar.getInstance();
			avaDateCanleder.setTime(avadate);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Integer res = DateUtil.dateCompare(calendar.getTime(), nowDate);

			//有效时间大于当前系统时间说明是当天
			if(res == 1){
				//当天还可用的公司资金额度 .setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				compAmount = compAmount.subtract(canUseComp);
			}
		}else{
			compAmount = new BigDecimal(compLimitPrice);
		}

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!"0".equals(compUaId)){
			//查询公司的额度

			AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(Integer.valueOf(compUaId));
			//用户就算还有公司好房币可用，但是一旦公司好房币没有了，用户也不能再使用公司好房币了
			BigDecimal comHaofangAmount = compAccount.getHaofangAmount();
			if(comHaofangAmount.doubleValue() <= 0){
				compAmount = new BigDecimal(0);
			}
			map.put("compHaoFangAmount", comHaofangAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());//优惠券加好房币 或者只有好房币
			map.put("compHaoFangBuy", null == compAccount.getHaofangBuy()?"0": compAccount.getHaofangBuy().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			//map.put("COMP_UA_ID", compUaId);//等于0则没有 公司资金账户，该用户是纯精英版
			map.put("canUseCompAmout",compAmount.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			map.put("compUaExist", "1");
		}else{
			map.put("compUaExist", "0");
		}
		double perHaofangQuan = amountByArchiveId.getHaofangAmount().subtract(amountByArchiveId.getHaofangBuy()).doubleValue();
		map.put("perHaofangAmount", null == amountByArchiveId.getHaofangAmount()?"0":NumberHelper.formatNumber(amountByArchiveId.getHaofangAmount().doubleValue(), NumberHelper.NUMBER_IN_1));//优惠券加好房币 或者只有好房币
		map.put("perHaofangBuy", null == amountByArchiveId.getHaofangBuy()?"0":NumberHelper.formatNumber(amountByArchiveId.getHaofangBuy().doubleValue(), NumberHelper.NUMBER_IN_1));
		map.put("perHaofangQuan", perHaofangQuan <= 0?"0":NumberHelper.formatNumber(perHaofangQuan, NumberHelper.NUMBER_IN_1));
		return map;
	}

	@Override
	public Map<String, Object> getHistoryBiddPrice(Map<String, Object> pMap) throws Exception{
		Integer cityId = Integer.valueOf(pMap.get("cityId")+"");
		Integer saleLease = Integer.valueOf(pMap.get("saleLease")+"");
		Integer houseId = Integer.valueOf(pMap.get("houseId")+"");
		Map<String, Object> historyPriceData = getHistoryBiddPrice(cityId, saleLease, houseId);
		Integer remainsdaySTmp = 0;//还剩余的天数
		Double history_biddPrice = 0.0d;//历史的出价
		Double remainsBiddPrice = 0.0d;//剩余的金额

		if(null != historyPriceData){// 这里要同步 getNewBiddPrice接口的查询天数逻辑
			//竞价的数据起始时间
			String biddstartTime = historyPriceData.get("biddingSuccTime") + "";
			//还剩余的天数
			remainsdaySTmp = Integer.parseInt(historyPriceData.get("remainsDays") + "");
			//历史的竞价天数
			int history_daySTmp = Integer.parseInt(historyPriceData.get("biddingDays")+"");
			int tmpHour  =DateUtil.getIntervalHour(biddstartTime, DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"), (history_daySTmp - remainsdaySTmp));
			if(tmpHour > 0 && tmpHour >= 12){
				remainsdaySTmp = remainsdaySTmp - 1;
			}
			history_biddPrice = Double.parseDouble(historyPriceData.get("biddingPrice")+"");
			remainsBiddPrice = history_biddPrice*remainsdaySTmp;
		}else {
			historyPriceData = new HashMap<>();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("residualAmount", String.valueOf(remainsBiddPrice));
		map.put("historyBiddprice", String.valueOf(history_biddPrice));
		AdminFunCity cityPo =	adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		Double maxPrice = cityPo.getHouseBiddingMaxPrice().doubleValue();//最高出价
		Double minPrice = cityPo.getHouseBiddingMinPrice().doubleValue();//最低出价
		map.put("maxPrice", String.valueOf(maxPrice));
		map.put("minPrice", String.valueOf(minPrice));
		return map;
	}

	/** 获取历史出价 **/
	private Map<String, Object> getHistoryBiddPrice(Integer cityId, Integer saleLease, Integer houseId) {
		Map<String, Object> resMap = erpFunHouseBiddingMapper.getHistoryPrice(cityId, saleLease, houseId);
		if(null != resMap) {
			Integer minute = StringUtil.paseInteger(resMap.get("remainsMinus")+"", 0);
			// 没超过当天的也要计算
			minute = minute / 60 / 24 + 1;
			Integer houseBiddingDays = StringUtil.paseInteger(adminSysParaMapper.selectByPrimaryKey("HOUSE_BIDDING_DAYS").getParamValue(), 7);
			minute = minute > houseBiddingDays ? houseBiddingDays : minute;
			resMap.put("remainsDays", String.valueOf(minute));
		}
		return resMap;
	}

	/**
	 * 提交竞价查看排名
	 * **/
	@Override
	public Map<String, Object> getHouseInfoSEQ(Map<String, Object> pMap) throws Exception{
		Integer cityId = Integer.valueOf(pMap.get("cityId")+"");
		Integer saleLease = Integer.valueOf(pMap.get("saleLease")+"");
		Integer houseId = Integer.valueOf(pMap.get("houseId")+"");
		Integer buildId = Integer.valueOf(pMap.get("buildId")+"");
		Double biddMoney = Double.parseDouble(pMap.get("biddPrice")+"");
		Integer houseRoom = Integer.valueOf(pMap.get("houseRoom")+"");
		Integer compId = Integer.valueOf(pMap.get("compId")+"");
		String userRight = pMap.get("userRight")+"";
		String uaId = pMap.get("uaId")+"";
		String compUaId = pMap.get("compUaId")+"";
		Boolean isPerLogin = (Boolean)pMap.get("isPerLogin");
		Map<String, Object> compareMap = erpFunHouseBiddingMapper.compareBiddPrice(cityId, saleLease, buildId, biddMoney, houseRoom);
		if("1".equals(userRight) &&  StringUtils.isNotBlank(uaId)){
			getNewBiddPrice(cityId, compId, uaId, compUaId, saleLease, houseId, biddMoney, isPerLogin, compareMap);
		}
		return compareMap;
	}

	public Map<String, Object> getNewBiddPrice(Integer cityId, Integer compId, String uaId, String compUaId, Integer saleLease ,Integer houseId,Double biddPrice, Boolean isPerLogin, Map<String, Object> pMap) throws Exception{
		Integer biddDays = StringUtil.paseInteger(adminSysParaMapper.selectByPrimaryKey("HOUSE_BIDDING_DAYS").getParamValue(), 7);
		// // 判断当前房源是否出价
		Map<String, Object> historyPriceParam = new HashMap<>();
		historyPriceParam.put("cityId", cityId);
		historyPriceParam.put("saleLease", saleLease);
		historyPriceParam.put("houseId", houseId);
		Map<String, Object> priceResMapdataObject = getHistoryBiddPrice(cityId, saleLease, houseId);
		double currMoney = 0.0d;//计算需要扣除的费用.
		double biddPrice_new = biddPrice;//本次的竞价金额
		int history_daySTmp = 0;
		int remainsdaySTmp = 0;//还剩余的天数
		double history_biddPrice = 0.0d;
		//数据的起始时间
		String biddstartTime = "";
		String sys_date = DateUtil.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss");
		String createNew = "0";
		Map<String,String> priceInfo = null;
		if(priceResMapdataObject != null){
			createNew = "1";//代表只是续期
			//竞价的数据起始时间
			biddstartTime = priceResMapdataObject.get("biddingSuccTime")+"";
			//历史的竞价天数
			history_daySTmp = Integer.parseInt(priceResMapdataObject.get("biddingDays")+"");
			//还剩余的天数
			remainsdaySTmp = Integer.parseInt(priceResMapdataObject.get("remainsDays")+"");
			//历史的出价,主要用于计算新竞价后 减去以前的竞价 差额！
			history_biddPrice = Double.parseDouble(priceResMapdataObject.get("biddingPrice")+"");

			//判断是否超越了自己历史出价
			if(biddPrice_new <= history_biddPrice){
				throw new BusinessException(Constants_DIC.TEXT_BIDD_SELF.replaceAll("#PRICE#", NumberHelper.formatNumber(biddPrice_new, NumberHelper.NUMBER_IN_1)));//新出的价格没有大于自己历史出价，不能执行
			}

			//计算系统时间和数据的起始时间是否相差12个小时了
			//前大后小 如果小于0 则说明还没有达到计算时间既没有超过12个小时，然后超过12个小时则说明以当前时间结束，然后从当前时间才竞价7(系统参数：biddDays)天
			int tmpHour  =DateUtil.getIntervalHour(biddstartTime, DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"), (history_daySTmp - remainsdaySTmp));
			/************扣费和写日志代码块 开始************/
			//如果价格不一样需要重新计算 多出来的部分
			//新的时间应该扣的费用,计算此次需要扣除的新费用
			//代表需要重新创建一条记录，并结束掉超过12时的数据,这里需要计算7（biddDays）天的价格
			if(tmpHour > 0 && tmpHour >= 12){
				remainsdaySTmp = remainsdaySTmp - 1;
				createNew = "2";//代表只是续期，但是已经超过12小时，当天的数据记录成已经使用
			}
			//新提交的竞价价格
			//计算已经扣除的费用
			double historySum = NumberHelper.mul(history_biddPrice, remainsdaySTmp);//上期剩余余额
			double newSum = NumberHelper.mul(biddPrice_new, biddDays);
			//如果竞价时间已经大于了 设置的时间那么就需更新以往的数据，并按新的竞价条件生成一条数据
			//更新日志
			currMoney = NumberHelper.sub(newSum, historySum);//计算需要扣除的费用.
			pMap.put("biddPriceSum", NumberHelper.formatNumber(newSum,NumberHelper.NUMBER_IN_1));
			pMap.put("historyremainsPrice", NumberHelper.formatNumber(historySum,NumberHelper.NUMBER_IN_1));
			pMap.put("realPrice", NumberHelper.formatNumber(currMoney,NumberHelper.NUMBER_IN_1));
			pMap.put("createnew", createNew);
			priceInfo = adminFunUserAccountService.getBiddPrice(uaId, compUaId, isPerLogin, cityId, compId, currMoney);
		}else{
			currMoney = NumberHelper.mul(biddPrice_new, biddDays);
			pMap.put("historyremainsPrice", "0");
			pMap.put("biddPriceSum", NumberHelper.formatNumber(currMoney,NumberHelper.NUMBER_IN_1));
			pMap.put("createnew", createNew);
			priceInfo = adminFunUserAccountService.getBiddPrice(uaId, compUaId, isPerLogin, cityId, compId, currMoney);
		}
		//实际使用的好房币
		double haofangbi = NumberHelper.add(Double.parseDouble(priceInfo.get("PERSONAL_COIN")), Double.parseDouble(priceInfo.get("COMP_COIN")));
		if(StringUtil.isEmpty(priceInfo.get("UA_TYPE"))){
//			newbiddMoney
			//本次竞价使用了多少好房币
			pMap.put("useQuan", String.valueOf(NumberHelper.formatNumber(haofangbi,NumberHelper.NUMBER_IN_1)));
			//本次竞价使用了多少优惠券
			pMap.put("useCoin", String.valueOf(NumberHelper.formatNumber(NumberHelper.sub(currMoney, haofangbi),NumberHelper.NUMBER_IN_1)));
		}else{
//			newbiddMoney
			//本次竞价使用了多少好房币
			pMap.put("useQuan", String.valueOf(NumberHelper.formatNumber(haofangbi,NumberHelper.NUMBER_IN_1)));
			//本次竞价使用了多少优惠券
			pMap.put("useCoin", String.valueOf(NumberHelper.formatNumber(NumberHelper.sub(currMoney, haofangbi),NumberHelper.NUMBER_IN_1)));
		}

		//个人使用的好房币部分
		pMap.put("perUseCoin", priceInfo.get("PERSONAL_COIN"));
		//使用公司的好房币部分
		pMap.put("compUseCoin", priceInfo.get("COMP_COIN"));
		//个人使用的优惠券部分
		pMap.put("perUsePrice", priceInfo.get("PERSONAL_PRICE"));
		//使用公司的优惠券部分
		pMap.put("compUsePrice", priceInfo.get("COMP_PRICE"));

		if(priceResMapdataObject == null){
			priceResMapdataObject = new HashMap<>();
		}
		priceResMapdataObject.put("compPrice", priceInfo.get("COMP_PRICE"));
		priceResMapdataObject.put("compCoin", priceInfo.get("COMP_COIN"));
		priceResMapdataObject.put("personalPrice", priceInfo.get("PERSONAL_PRICE"));
		priceResMapdataObject.put("personalCoin", priceInfo.get("PERSONAL_COIN"));
		return priceResMapdataObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<ErpFunHouseBiddingDto> getHouseBiddingList(ReqHouseBiddPageParam param) {
		Integer pageOffset = param.getPageOffset();
		Integer pageRows = param.getPageRows();
		Integer cityId = param.getCityId();
		PageHelper.startPage(pageOffset, pageRows, true);
		List<ErpFunHouseBiddingDto> resList = erpFunHouseBiddingMapper.getHouseBiddingList(cityId,param);
		PageInfo<ErpFunHouseBiddingDto> pageInfo = new PageInfo<ErpFunHouseBiddingDto>(resList);
		return pageInfo;
		
	}
	
	@Override
	public Map<String, Object> getBuildHouseCount(Integer cityId, Integer userId, Integer buildId, Integer archiveId) throws BusinessException{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Integer> saleCountMap = erpFunSaleMapper.getBuildHouseCount(cityId, userId, buildId);
		Map<String, Integer> leaseCountMap = erpFunLeaseMapper.getBuildHouseCount(cityId, userId, buildId);
		Integer saleCount = saleCountMap.get("totalCount");
		Integer leaseCount = leaseCountMap.get("totalCount");
		Integer saleCanPublishCount = saleCountMap.get("canPublishCount");
		Integer leaseCanPublishCount = leaseCountMap.get("canPublishCount");
		saleCount = (saleCount == null) ? 0:saleCount;
		leaseCount = (leaseCount == null) ? 0:leaseCount;
		saleCanPublishCount = (saleCanPublishCount == null) ? 0:saleCanPublishCount;
		leaseCanPublishCount = (leaseCanPublishCount == null) ? 0:leaseCanPublishCount;
		map.put("saleCount", saleCount);
		map.put("leaseCount", leaseCount);
		map.put("count", saleCount+leaseCount);
		map.put("canPublishCount", saleCanPublishCount+leaseCanPublishCount);
		ErpBuildingInfoDto erpBuildInfo = erpBuildInfoService.getErpBuildInfoByid(String.valueOf(cityId), String.valueOf(buildId));
		if(erpBuildInfo != null) {
			map.put("buildRegion", erpBuildInfo.getBuildRegion());
			map.put("regName", erpBuildInfo.getRegName());
			map.put("buildRound", erpBuildInfo.getBuildRound());
			map.put("sectionId", erpBuildInfo.getSectionId());
			map.put("sectionName", erpBuildInfo.getSectionName());
		}
		// 查询小区专家数量
		Integer count = adminFunBuildingBiddingMapper.getBuildBiddingCount(archiveId);
		if(count != null && count > 6) {
			throw new BusinessException("您最多可入驻成为6个楼盘的小区专家");
		}
		return map;
	}

	/**
	 * 优优竞价  下架逻辑并 写房源跟进
	 * @author 臧铁
	 * @param downType  1:熄灭优优 2:熄灭真房源 3:加密 4:封盘  5:内成家 6:外成交 7:注销 8:删除视频 9:删除图片 10:数据移交
	 * @since 2017年5月19日
	 * @return
	 */
	@Override
	public void downBiddingYY(Integer cityId,Integer caseId, Integer caseType, String caseNo, Integer downType){
		Integer count = erpFunHouseBiddingMapper.count(cityId, caseId, caseType);
		if (count > 0) {
			ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
			String yyStatus = Constants_DIC.HOUSE_BIDDING_YY_STATUS_2;
			if(1 == downType || 2 == downType) {
				yyStatus = Constants_DIC.HOUSE_BIDDING_YY_STATUS_0;
			}
			erpFunHouseBidding.setYyStatus(Byte.valueOf(yyStatus));
			erpFunHouseBidding.setShardCityId(cityId);
			erpFunHouseBiddingMapper.updateByPrimaryKeySelective(erpFunHouseBidding);
		}
	}

	/**
	 * 获取小区竞价列表
	 * @author 熊刚
	 * @since 2017年7月6日
	 * @param pMap
	 * @return
	 */
	@Override
	public List<ErpFunHouseBiddingDto> getBuildBiddInfo(Map<String, Object> pMap) {
		String nowTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate());
		Integer cityId = (Integer) pMap.get("cityId");
		Integer archiveId = (Integer) pMap.get("archiveId");
		List<ErpFunHouseBiddingDto> erpFunHouseBiddingDtoList = erpFunHouseBiddingMapper.getHouseBiddingListByArchiveId(cityId, archiveId,nowTime);
		return erpFunHouseBiddingDtoList;
	}

	/**
	 * @tag 移交数据时，更新竞价数据的所属人
	 * @author 邓永洪
	 * @since 2018/4/28
	 */
	@Transactional
	@Override
	public void updateHouse4TransDataArchiveId(Integer saleLease, List<Integer> houseIds, DataTranslateParam param) {
		Integer cityId = param.getCityId();
		List<Integer> ids = new ArrayList<>();
		Map<Integer, ErpFunSale> funSaleMap = new HashMap<>();
		Map<Integer, ErpFunLease> funLeaseMap = new HashMap<>();
		if (Const.DIC_CASE_TYPE_SALE_FUN .equals(saleLease) ) {
			ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
			funSaleExample.setShardCityId(cityId);
			funSaleExample.createCriteria().andSaleIdIn(houseIds);
			List<ErpFunSale> funSaleList = erpFunSaleMapper.selectByExample(funSaleExample);
			funSaleMap =funSaleList.stream().collect(Collectors.toMap(ErpFunSale::getSaleId,val ->val));
			//funSaleMap = BeanUtil.listObjToMapObj(erpFunSaleMapper.selectByExample(funSaleExample), "saleId");
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN .equals(saleLease)) {
			ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
			funLeaseExample.setShardCityId(cityId);
			funLeaseExample.createCriteria().andLeaseIdIn(houseIds);
			List<ErpFunLease> funLeaseList = erpFunLeaseMapper.selectByExample(funLeaseExample);
			funLeaseMap=funLeaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId,val ->val));
			//funLeaseMap = BeanUtil.listObjToMapObj(erpFunLeaseMapper.selectByExample(funLeaseExample), "leaseId");
		}
		for (Integer houseId : houseIds) {
			ids.add(Integer.valueOf(houseId));
			Boolean publish = false;
			String caseNo = "";
			if (Const.DIC_CASE_TYPE_SALE_FUN .equals(saleLease)) {
				ErpFunSale funSale = funSaleMap.get(houseId);
				if (funSale != null) {
					publish = funSale.getSalePublish();
					caseNo = funSale.getSaleNo();
				}
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN .equals(saleLease)) {
				ErpFunLease funLease = funLeaseMap.get(houseId);
				if (funLease != null) {
					caseNo = funLease.getLeaseNo();
					publish = funLease.getLeasePublish();
				}
			}
			if (publish) { // 发布到优优
				/*if (Const.DIC_CASE_TYPE_SALE_FUN .equals(saleLease)) {
					//根据主键  异步腾讯同步
					ErpFunSale funSale = new ErpFunSale();
					ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
					funSaleExample.setShardCityId(cityId);
					funSaleExample.createCriteria().andSaleIdEqualTo(houseId);
					erpFunSaleMapper.updateByExampleSelective(funSale, funSaleExample);
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN .equals(saleLease)) {
					ErpFunLease funLease = new ErpFunLease();
					ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
					funLeaseExample.setShardCityId(cityId);
					funLeaseExample.createCriteria().andLeaseIdEqualTo(houseId);
					erpFunLeaseMapper.updateByExampleSelective(funLease, funLeaseExample);
				}*/
			}
			ErpFunUsers currentUser = new ErpFunUsers();
			currentUser.setUserId(param.getCurrentUserId());
			currentUser.setDeptId(param.getAcceptDeptId());
			currentUser.setCompId(param.getCompId());
			ErpCreateTrackInfoParam trackInfoparam = new ErpCreateTrackInfoParam();
			trackInfoparam.setCreateAuditUser(currentUser);
			trackInfoparam.setCaseType(saleLease);
			trackInfoparam.setCaseNo(caseNo);
			trackInfoparam.setCityId(param.getCityId());
			trackInfoparam.setCaseId(houseId);
			erpFunTrackService.writeFunTrackForPublish(trackInfoparam, publish, null);
		}
		List<ErpFunHouseBidding> listByCaseIds = erpFunHouseBiddingService.getBiddingListByCaseIds(ids, cityId, saleLease, Const.HOUSE_BIDDING_YY_STATUS_1);
		for (ErpFunHouseBidding funHouseBidding : listByCaseIds) {
			String caseNo = "";
			Boolean publish = false;
			Integer caseId = null;
			if (Const.DIC_CASE_TYPE_SALE_FUN .equals(saleLease)) {
				ErpFunSale funSale = funSaleMap.get(funHouseBidding.getHouseId());
				if (funSale != null) {
					caseNo = funSale.getSaleNo();
					publish = funSale.getSalePublish();
					caseId = funSale.getSaleId();
				}
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN .equals(saleLease)) {
				ErpFunLease funLease = funLeaseMap.get(funHouseBidding.getHouseId());
				if (funLease != null) {
					caseNo = funLease.getLeaseNo();
					publish = funLease.getLeasePublish();
					caseId = funLease.getLeaseId();
				}
			}
			if (publish) { // 发布到优优
				// 判断是否进行可推广,如果推广就下架
				// 读取推广表
				erpFunHouseBiddingService.downBiddingYY(cityId, caseId,saleLease, caseNo, 10);
				ErpFunTrack trackPO = new ErpFunTrack();
				String trackContent = param.getCurrentUserNamme() + " 移交该房源 ,同时房源自动从优优好房下架。";
				trackPO.setCaseId(caseId);
				trackPO.setCaseNo(caseNo);
				trackPO.setCaseType(saleLease.byteValue());
				trackPO.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
				trackPO.setTrackContent(trackContent);
				trackPO.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
				trackPO.setCreatorUid(param.getCurrentUserId());
				trackPO.setCreationTime(DateTimeHelper.getTimeNow());
				trackPO.setDeptId(param.getDeptId());
				trackPO.setCompId(param.getCompId());
				trackPO.setTrackWarm(false);
				trackPO.setUseage(null);
				erpFunTrackMapper.insertFunTrack(trackPO);
			}
		}
	}

	@Override
	public List<ErpFunHouseBidding> getBiddingListByCaseIds(List<Integer> ids, Integer cityId, Integer caseType, Integer yyStatus) {
		if (ids != null && ids.size() > 0) {
			return erpFunHouseBiddingMapper.getFunHouseBiddingList(cityId, yyStatus, caseType, ids);
		} else {
			return new ArrayList<>();
		}
	}

	@Transactional
	@Override
	public Map<String, String> updateHouseBidding(Integer cityId,Boolean personalVersion,Map<String, Object> pMap) throws Exception {
		Map<String, String> resMap = new HashMap<>();
		Integer archiveId = Integer.valueOf(pMap.get("archiveId")+"");
		String archiveTodayData = "0";
		if (personalVersion) {
			AdminArchiveTodayRecordExample adminArchiveTodayRecordExample = new AdminArchiveTodayRecordExample();
			adminArchiveTodayRecordExample.createCriteria().andArchiveIdEqualTo(archiveId).andBiddingTypeEqualTo(Integer.valueOf(Constants_DIC.DIC_BIDDING_TYPE_HOUSE_EXPERT))
			.andCreationTimeGreaterThanOrEqualTo(new Date());
			int countByExample = adminArchiveTodayRecordMapper.countByExample(adminArchiveTodayRecordExample);
			if (countByExample==0) {
				AdminArchiveTodayRecord adminArchiveTodayRecord = new AdminArchiveTodayRecord();	
				adminArchiveTodayRecord.setArchiveId(archiveId);
				adminArchiveTodayRecord.setBiddingType(Integer.valueOf(Constants_DIC.DIC_BIDDING_TYPE_HOUSE_EXPERT));
				adminArchiveTodayRecord.setCreationTime(new Date());
				adminArchiveTodayRecordMapper.insertSelective(adminArchiveTodayRecord);
				archiveTodayData = "1";
			}
		}
		resMap.put("archiveTodayFirst", archiveTodayData);
		if ("1".equals(archiveTodayData)) {
			return resMap;
		}
		// 判断出价是否在限制范围内
		AdminFunCity cityPo = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		
		double biddMoney = Double.parseDouble(pMap.get("biddPrice")+"");
		double maxPrice = cityPo.getHouseBiddingMaxPrice().doubleValue();// 最高出价
		double minPrice = cityPo.getHouseBiddingMinPrice().doubleValue();//最低出价
		String vipBiddPrice = null;
		if("1".equals(pMap.get("superUser")+"")){
			BigDecimal temp = new BigDecimal(Math.ceil(Double.parseDouble(pMap.get("biddPrice")+"")/2));
			vipBiddPrice = temp.stripTrailingZeros().toPlainString();
		}
		
		if(biddMoney < minPrice){
			throw new Exception(Constants_DIC.TEXT_BIDD_LIMIT_MIN.replaceAll("#PRICE#", NumberHelper.formatNumber(minPrice,NumberHelper.NUMBER_IN_1)));
		}else if(biddMoney > maxPrice){
			throw new Exception(Constants_DIC.TEXT_BIDD_LIMIT_MAX.replaceAll("#PRICE#", NumberHelper.formatNumber(maxPrice,NumberHelper.NUMBER_IN_1)));
		}
		String selectParamVlue = adminSysParaMapper.selectParamVlue("HOUSE_BIDDING_DAYS");
		if (StringUtil.isEmpty(selectParamVlue)) {
			throw new Exception("系统参数HOUSE_BIDDING_DAYS值为空");
		}
		int biddDays = StringUtil.paseInteger(selectParamVlue, 7);
		Date sys_date = DateTimeHelper.getSystemDate();
		
		Integer compId = Integer.valueOf(pMap.get("compId")+"");
		Integer uaId = Integer.valueOf(pMap.get("uaId")+"");
		Integer compUaId = Integer.valueOf(pMap.get("compUaId")+"");
		Integer houseId = Integer.valueOf(pMap.get("houseId")+"");
		Integer saleLease = Integer.valueOf(pMap.get("saleLease")+"");
		Integer buildId = Integer.valueOf(pMap.get("buildId")+"");
		Integer useage = Integer.valueOf(pMap.get("useage")+"");
		String biddPrice = pMap.get("biddPrice").toString();
		String superUser = pMap.get("superUser").toString();
		
		String e_date = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(sys_date,biddDays),"yyyy-MM-dd HH:mm:ss");
		Map<String, Object> element = this.getNewBiddPrice(cityId, compId, uaId.toString(), compUaId.toString(), saleLease, houseId, Double.valueOf(pMap.get("saleLease")+""), personalVersion, pMap);
		
		
		double compPrice = Double.parseDouble(element.get("compPrice")+"");
		double perPrice = Double.parseDouble(element.get("personalPrice")+"");
		double compCoin = Double.parseDouble(element.get("compCoin")+"");
		double perCoin = Double.parseDouble(element.get("personalCoin")+"");
		
		String newFlag = pMap.get("createnew").toString();
		String fBiddId = "";
		if("0".equals(newFlag)){
			fBiddId = this.insertBidding(archiveId,superUser,cityId,houseId, buildId, saleLease.byteValue(), useage.byteValue(), sys_date, e_date, biddDays, biddPrice, compPrice, perPrice, compCoin, perCoin, vipBiddPrice);
			// 添加积分获取 陈文超添加 只有第一次竞价才记录分数
		}else{
			Integer oldBiddId = Integer.valueOf(element.get("biddId")+"");
			/*续期竞价开始*/
			//无论超过12个小时或者没超过只要重新竞价就新生成一条记录
			//更新老的竞价数据出价
			ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
			erpFunHouseBidding.setHaofangStatus((byte)0);
			erpFunHouseBidding.setQqStatus((byte)0);
			erpFunHouseBidding.setYyStatus(Byte.valueOf(Constants_DIC.HOUSE_BIDDING_YY_STATUS_2));
			erpFunHouseBidding.setBiddId(oldBiddId);
			erpFunHouseBiddingMapper.updateByPrimaryKeySelective(erpFunHouseBidding);
			
			sys_date = DateUtil.StringToDate(getDateNow(),"yyyy-MM-dd 00:00:00");// 续期为最后时间加上新时间
			//重新续期后，需要修改之前没有推广过的记录。
			
			/*续期竞价结束*/
			int history_daySTmp = 0;
			int remainsdaySTmp = 0;//还剩余的天数
			//数据的起始时间
			String biddstartTime = "";
			//新生成逻辑开始
			if("2".equals(newFlag)){//说明没超过12个小时,起始的时间随着起始时间变化
				//历史的持续天数
				history_daySTmp = Integer.parseInt(element.get("biddingDays")+"");
				//还剩余的天数
				remainsdaySTmp = Integer.parseInt(element.get("remainsDays")+"");
				//竞价的数据新起始时间
				biddstartTime = element.get("biddingSuccTime").toString();
				biddstartTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(DateTimeHelper.parseToDate(biddstartTime,"yyyy-MM-dd HH:mm:ss"), (history_daySTmp - remainsdaySTmp)),"yyyy-MM-dd HH:mm:ss");
				sys_date = DateUtil.StringToDate(biddstartTime,"yyyy-MM-dd HH:mm:ss");
			}
			e_date = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(sys_date,biddDays),"yyyy-MM-dd HH:mm:ss");
			//写入新的竞价数据
			fBiddId = this.insertBidding(archiveId,superUser,cityId,houseId,buildId, saleLease.byteValue(), useage.byteValue(), DateUtil.StringToDate(getTimeNow(),"yyyy-MM-dd HH:mm:ss"), e_date, biddDays, biddPrice,compPrice, perPrice, compCoin, perCoin, vipBiddPrice);
		}

		//开始扣费l流程
		// 这里调整到admin执行扣费逻辑2018-03-17
		String dealAccountUrl = AppConfig.getAdminWebUrl();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("archiveId", archiveId);
		//计算money
		BigDecimal moneyDeciimal  = null;
		if("1".equals(superUser)){
			moneyDeciimal = new BigDecimal(vipBiddPrice);
		} else {
			moneyDeciimal = new BigDecimal(biddPrice);
		}
		if(pMap.get("historyremainsPrice")!=null && StringUtil.isNotEmpty(pMap.get("historyremainsPrice")+"")) {
			moneyDeciimal = moneyDeciimal.subtract(new BigDecimal(pMap.get("historyremainsPrice")+""));
		}
		paramMap.put("money", moneyDeciimal);
		paramMap.put("paidType", "HOUSE_BIDDING");
		String post = HttpUtil.post(dealAccountUrl+"/pay/deductTelecastMoney", paramMap);
        Map<String, Object> stringObjectMap = JSON.parseObject(post, new TypeReference<Map<String, Object>>() {});
        if(null != stringObjectMap || !"200".equalsIgnoreCase(stringObjectMap.get("errCode") + "")) {
            resMap = JSON.parseObject(stringObjectMap.get("data") + "", new TypeReference<Map<String, String>>() {});
			if(null == resMap || !"1".equalsIgnoreCase(resMap.get("status") + "")){
				throw new Exception("房源在推广竞价时出错！");
			}
            // 更新已经过期的竞价数据状态
            ErpFunHouseBiddingExample erpFunHouseBiddingExample = new ErpFunHouseBiddingExample();
            erpFunHouseBiddingExample.setShardCityId(cityId);
            erpFunHouseBiddingExample.createCriteria().andArchiveIdEqualTo(archiveId).andCityIdEqualTo(cityId).andBiddingEndTimeLessThan(new Date());
            
            ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
            erpFunHouseBidding.setHaofangStatus((byte)0);
            erpFunHouseBidding.setQqStatus((byte)0);
            erpFunHouseBiddingMapper.updateByExampleSelective(erpFunHouseBidding, erpFunHouseBiddingExample);
            
            
            // 竞价才加积分，续期不加，这个操作必须放到所有流程走完之后
            Map<String,String> resultMap = new HashMap<String,String>();
            resultMap.put("BIDD_ID", fBiddId);
            if("0".equals(newFlag)){
            	// 积分这个功能没用了，不用发消息了
                // 增加夺宝币
            	Integer userId = Integer.valueOf(pMap.get("userId")+"");
            	String otoFlag = pMap.get("otoFlag").toString();
            	String deptFlag = pMap.get("deptFlag").toString();
            	String userRight = pMap.get("userRight").toString();
                String addTreasureCoin = adminFunArchiveService.addTreasureCoin(archiveId, Constants_DIC.DIC_TREASURE_COIN_SOURCE_2, houseId, saleLease, "1",userId,otoFlag,deptFlag,cityId,superUser,userRight,personalVersion);
                resultMap.put("addTreasureCoin", addTreasureCoin);
            }
        }
		return resMap;
	}
	
	/**
	 * 新增一条竞价信息
	 * @author HeWei
	 * @since 2018年7月23日 下午3:03:11
	 * @param archiveId
	 * @param superUser
	 * @param cityId
	 * @param houseId
	 * @param buildId
	 * @param saleLease
	 * @param useage
	 * @param s_date
	 * @param e_date
	 * @param biddDayS
	 * @param biddPrice
	 * @param compPrice
	 * @param perPrice
	 * @param compCoin
	 * @param perCoin
	 * @param vipBiddPrice
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月23日
	 */
	private String insertBidding(Integer archiveId,String superUser,Integer cityId,Integer houseId,Integer buildId, Byte saleLease, Byte useage, Date s_date, String e_date, 
			Integer biddDayS,String biddPrice,double compPrice, double perPrice, double compCoin, double perCoin, String vipBiddPrice) throws Exception{
		String updateTime =DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(),"yyyy-MM-dd HH:mm:ss");
		//在erpdb库插入一条相同的记录,后期数据表合并会取消掉center数据库,erpdb的BIDDID与admin的一样
		ErpFunHouseBidding erpFunHouseBidding = new ErpFunHouseBidding();
		erpFunHouseBidding.setShardCityId(cityId);
		erpFunHouseBidding.setCityId(cityId);
		erpFunHouseBidding.setHouseId(houseId);
		erpFunHouseBidding.setBuildId(buildId);
		erpFunHouseBidding.setSaleLease(saleLease);
		erpFunHouseBidding.setHouseUseage(useage);
		erpFunHouseBidding.setBiddingSuccTime(s_date);
		erpFunHouseBidding.setBiddingEndTime(DateUtil.StringToDate(e_date,"yyyy-MM-dd HH:mm:ss"));
		erpFunHouseBidding.setBiddingDays(biddDayS);
		erpFunHouseBidding.setHaofangStatus((byte)1);
		erpFunHouseBidding.setQqStatus((byte)1);
		erpFunHouseBidding.setYyStatus((byte)1);
		
		if(compPrice > 0 && perPrice > 0){//两者都有
			erpFunHouseBidding.setUaType(Byte.valueOf(Constants_DIC.DIC_BIDD_ALL_UA_TYPE));
		}else if(perPrice > 0){
			erpFunHouseBidding.setUaType(Byte.valueOf(Constants_DIC.DIC_BIDD_PER_UA_TYPE));
		}else if(compPrice > 0){
			erpFunHouseBidding.setUaType(Byte.valueOf(Constants_DIC.DIC_BIDD_COMP_UA_TYPE));
		}
		// 会员减半
		if("1".equals(superUser)){
			//更新账户的花费情况
			erpFunHouseBidding.setBiddingPrice(new BigDecimal(vipBiddPrice));
			erpFunHouseBidding.setCompPrice(new BigDecimal(Math.ceil(compPrice/2)));
			erpFunHouseBidding.setCompCoin(new BigDecimal(Math.ceil(compCoin/2)));
			erpFunHouseBidding.setPersonalPrice(new BigDecimal(Math.ceil(perPrice/2)));
			erpFunHouseBidding.setPersonalCoin(new BigDecimal(Math.ceil(perCoin/2)));
		}else{
		//更新账户的花费情况
		erpFunHouseBidding.setBiddingPrice(new BigDecimal(vipBiddPrice));
		erpFunHouseBidding.setCompPrice(new BigDecimal(Math.ceil(compPrice)));
		erpFunHouseBidding.setCompCoin(new BigDecimal(Math.ceil(compCoin)));
		erpFunHouseBidding.setPersonalPrice(new BigDecimal(Math.ceil(perPrice)));
		erpFunHouseBidding.setPersonalCoin(new BigDecimal(Math.ceil(perCoin)));
		}
		erpFunHouseBidding.setArchiveId(archiveId);
		erpFunHouseBidding.setUpdateTime(DateUtil.StringToDate(updateTime,"yyyy-MM-dd HH:mm:ss"));
		erpFunHouseBidding.setBiddSource(Byte.valueOf(Constants_DIC.DIC_BIDDING_SOURCE_1));
		erpFunHouseBidding.setSortPrice(new BigDecimal(biddPrice));
		Integer insert = erpFunHouseBiddingMapper.insertSelective(erpFunHouseBidding);
		
		// 修改房源上冗余的竞价字段信息
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(saleLease)){
			ErpFunSale erpFunSale =new ErpFunSale();
			erpFunSale.setCompetePrice(new BigDecimal(biddPrice));
			erpFunSale.setCompeteEndTime(DateUtil.StringToDate(e_date,"yyyy-MM-dd HH:mm:ss"));
			erpFunSale.setSaleId(houseId);
			erpFunSale.setShardCityId(cityId);
			erpFunSale.setCityId(cityId);
			erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
		} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(saleLease)){
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setCompetePrice(new BigDecimal(biddPrice));
			erpFunLease.setCompeteEndTime(DateUtil.StringToDate(e_date,"yyyy-MM-dd HH:mm:ss"));
			erpFunLease.setLeaseId(houseId);
			erpFunLease.setShardCityId(cityId);
			erpFunLease.setCityId(cityId);
			erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
		}
		return insert.toString();
	}
	
	public String getDateNow() {
		return DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 00:00:00");
	}
	
	public String getTimeNow() {
		return DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm:ss.S");
	}
}

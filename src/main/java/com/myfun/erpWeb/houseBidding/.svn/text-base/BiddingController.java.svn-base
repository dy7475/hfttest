package com.myfun.erpWeb.houseBidding;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.erpWeb.houseBidding.param.BuildHouseCountParam;
import com.myfun.erpWeb.houseBidding.param.UserInfoAndAccountInfoParam;
import com.myfun.erpWeb.houseBidding.vo.BuildHouseCountVo;
import com.myfun.erpWeb.houseBidding.vo.HousePubFlagAllDto;
import com.myfun.erpWeb.houseBidding.vo.UserInfoAndAccountInfoDto;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunBuildAttentionMapper;
import com.myfun.repository.admindb.dao.AdminFunBuildingBiddingMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunHouseBiddingMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dto.AdminFunBuildBiddDto;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunBuildAttention;
import com.myfun.repository.admindb.po.AdminFunBuildingBidding;
import com.myfun.repository.admindb.po.AdminFunBuildingBiddingExample;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunHouseBidding;
import com.myfun.repository.admindb.po.AdminFunHouseBiddingExample;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.erpdb.dao.ErpBuildRoadsRelationMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunHouseBiddingMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunMsgMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunSectionMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunHouseBiddingDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminArchiveTodayRecordService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunBuildAttentionService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.ErpFunHouseBiddingService;
import com.myfun.service.business.erpdb.ErpFunHousePublishStatusService;
import com.myfun.utils.jms.UserScoreTypeConfig;

/**
 * Created by lcb on 2017-02-06.
 */
@Api(tags ="好房推广模块")
@Controller
@RequestMapping("/houseBidding")
public class BiddingController extends BaseController{

	@Autowired
	ErpFunHouseBiddingService erpFunHouseBiddingService;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	ErpFunRegMapper erpFunRegMapper;
	@Autowired
	ErpBuildRoadsRelationMapper erpBuildRoadsRelationMapper;
	@Autowired
	AdminFunBuildingBiddingMapper adminFunBuildingBiddingMapper;
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	AdminFunBuildAttentionMapper adminFunBuildAttentionMapper;
	@Autowired
	AdminFunBuildAttentionService adminFunBuildAttentionService;
	@Autowired
	ErpFunHousePublishStatusService erpFunHousePublishStatusService;
	@Autowired
	private AdminJmsMessageService adminJmsMessageService;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunUserAccountService adminFunUserAccountService;
	@Autowired
	private AdminArchiveTodayRecordService adminArchiveTodayRecordService;
	@Autowired
	private AdminFunHouseBiddingMapper adminFunHouseBiddingMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	private AdminFunArchiveService adminFunArchiveService;
	@Autowired
	private ErpDicDefdinitionsService erpDicDefdinitionsService;
	
	private static final Logger logger = LoggerFactory.getLogger(BiddingController.class);
	
	/**
	 * 获取本人楼盘房源数量
	 * @author 张宏利
	 * @since 2017年3月9日
	 * @param buildId 楼盘ID
	 * @return
	 */
	@ApiOperation("获取本人楼盘房源数量")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BuildHouseCountVo.class, message = "成功")
	})
	@ResponseBody
	@NotBlank("buildId")
	@PostMapping("/getBuildHouseCount")
	public ErpResponseJson getBuildHouseCount(@Valid @RequestBody BuildHouseCountParam param) throws BusinessException{
		Operator operator = getOperator();
		Integer buildId = param.getBuildId();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		BuildHouseCountVo buildHouseCountVo = new BuildHouseCountVo();
		Map<String, Integer> saleCountMap = erpFunSaleMapper.getBuildHouseCount(cityId, userId, buildId);
		Map<String, Integer> leaseCountMap = erpFunLeaseMapper.getBuildHouseCount(cityId, userId, buildId);
		Integer saleCount = saleCountMap.get("totalCount");
		Integer leaseCount = leaseCountMap.get("totalCount");
		Integer saleCanPublishCount = saleCountMap.get("canPublishCount");
		Integer leaseCanPublishCount = leaseCountMap.get("canPublishCount");
		// 去掉判断有房源才能竞价的逻辑
		saleCount = (saleCount == 0 || saleCount == null) ? 1:saleCount;
		leaseCount = (leaseCount == 0 || saleCount == null) ? 1:leaseCount;
		saleCanPublishCount = (saleCanPublishCount == null) ? 1:saleCanPublishCount;
		leaseCanPublishCount = (leaseCanPublishCount == null) ? 1:leaseCanPublishCount;
		buildHouseCountVo.setSaleCount(saleCount);
		buildHouseCountVo.setLeaseCount(leaseCount);
		buildHouseCountVo.setCount(saleCount+leaseCount);
		buildHouseCountVo.setCanPublishCount(saleCanPublishCount+leaseCanPublishCount);
		ErpBuildingInfoDto erpBuildInfo = erpBuildingInfoMapper.getErpBuildInfoByid(Integer.valueOf(cityId), Integer.valueOf(buildId));
		if (null != erpBuildInfo) {
			ErpFunSection erpFunSection = new ErpFunSection();
			erpFunSection.setShardCityId(Integer.valueOf(cityId));
			erpFunSection.setSectionId(erpBuildInfo.getSectionId());
			erpFunSection.setVertifyFlag((byte)1);
			ErpFunSection funSection = erpFunSectionMapper.selectByPrimaryKey(erpFunSection);
			if (null != funSection) {
				erpBuildInfo.setSectionName(funSection.getSectionName());
			}
			ErpFunReg erpFunReg = new ErpFunReg();
			erpFunReg.setShardCityId(Integer.valueOf(cityId));
			erpFunReg.setRegId(erpBuildInfo.getBuildRegion());
			erpFunReg.setVertifyFlag((byte)1);
			ErpFunReg funReg = erpFunRegMapper.selectByPrimaryKey(erpFunReg);
			if (null != funReg) {
				erpBuildInfo.setRegName(funReg.getRegName());
			}
			ErpBuildRoadsRelation erpBuildRoadsRelation = new ErpBuildRoadsRelation();
			erpBuildRoadsRelation.setShardCityId(Integer.valueOf(cityId));
			erpBuildRoadsRelation.setBuildId(erpBuildInfo.getBuildId());
			List<ErpBuildRoadsRelation> list =  erpBuildRoadsRelationMapper.getListByBuildId(erpBuildRoadsRelation);
			if (list.size() > 0) {
				StringBuilder sbTemp = new StringBuilder();
				for (ErpBuildRoadsRelation relation : list) {
					if(sbTemp.length() > 0) {
						sbTemp.append("、");
					}
					sbTemp.append(relation.getRoadsName());
				}
				erpBuildInfo.setRoadsName(sbTemp.toString());
			}
		}
		if(erpBuildInfo != null) {
			buildHouseCountVo.setBuildRegion(erpBuildInfo.getBuildRegion());
			buildHouseCountVo.setRegName(erpBuildInfo.getRegName());
			buildHouseCountVo.setBuildRound(erpBuildInfo.getBuildRound());
			buildHouseCountVo.setSectionId(erpBuildInfo.getSectionId());
			buildHouseCountVo.setSectionName(erpBuildInfo.getSectionName());
		}
		// 查询小区专家数量
		Integer count = adminFunBuildingBiddingMapper.getBuildBiddingCount(getOperator().getArchiveId());
		if(count != null && count > 6) {
			throw new BusinessException("您最多可入驻成为6个楼盘的小区专家");
		}
		List<BuildHouseCountVo> resultList = new LinkedList<>();
		resultList.add(buildHouseCountVo);
		return ErpResponseJson.ok(resultList);
	}

	/**
	 * 查询好房币信息
	 * **/
	@ApiOperation("查询好房币信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = UserInfoAndAccountInfoDto.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getUserInfoAndAccountInfo")
	public ErpResponseJson getUserInfoAndAccountInfo(@Valid @RequestBody UserInfoAndAccountInfoParam param) {
		Operator operator = getOperator();
		Integer uaId = operator.getUaId();
		Integer compUaId = operator.getCompUaId();
		Integer cityId = operator.getCityId();
		Integer  compId = operator.getCompId();
		if(null != uaId) {
			param.setUaId(uaId);
			param.setCompUaId(compUaId);
			param.setCityId(cityId);
			param.setCompId(compId);
			// 查询资金账户
			AdminFunUserAccount amountByArchiveId = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
			// 查询公司可用金额
			Date avadate = amountByArchiveId.getAvailableDate();
			String compLimitPrice = "0";
			if(compUaId!=null && compUaId!=0){//这里判断是否是精英版，用于代码统一
				compLimitPrice = erpSysParaMapper.getParamValue(cityId, compId, "HF_AMOUNT_CANUSE");//每天可用公司多好优惠券和好房币
			}else{
				compUaId = 0;//即不存在COMPUAID，用户可能为纯精英版
			}
			compLimitPrice = StringUtils.isBlank(compLimitPrice)?"0":compLimitPrice;
			// 当天已经使用公司多少好房币
			BigDecimal canUseComp = amountByArchiveId.getUsedCompHf();
			if(null == canUseComp){
				canUseComp = new BigDecimal(0);
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
			UserInfoAndAccountInfoDto accountInfoDto = new UserInfoAndAccountInfoDto();
			if(compUaId!=0){
				//查询公司的额度
				AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);
				//用户就算还有公司好房币可用，但是一旦公司好房币没有了，用户也不能再使用公司好房币了
				BigDecimal comHaofangAmount = compAccount.getHaofangAmount();
				if(comHaofangAmount.doubleValue() <= 0){
					compAmount = new BigDecimal(0);
				}
				accountInfoDto.setCompHaoFangAmount(comHaofangAmount.setScale(2, BigDecimal.ROUND_HALF_UP));//优惠券加好房币 或者只有好房币
				accountInfoDto.setCompHaoFangBuy( null == compAccount.getHaofangBuy()?new BigDecimal(0): compAccount.getHaofangBuy().setScale(2, BigDecimal.ROUND_HALF_UP));
				accountInfoDto.setCanUseCompAmout(compAmount.setScale(2, BigDecimal.ROUND_HALF_UP));
				accountInfoDto.setCompUaExist(1);
			}else{
				accountInfoDto.setCompUaExist(0);
			}
			double perHaofangQuan = amountByArchiveId.getHaofangAmount().subtract(amountByArchiveId.getHaofangBuy()).doubleValue();
			accountInfoDto.setPerHaofangAmount(null == amountByArchiveId.getHaofangAmount()?"0":NumberHelper.formatNumber(amountByArchiveId.getHaofangAmount().doubleValue(), NumberHelper.NUMBER_IN_1));//优惠券加好房币 或者只有好房币
			accountInfoDto.setPerHaofangBuy(null == amountByArchiveId.getHaofangBuy()?"0":NumberHelper.formatNumber(amountByArchiveId.getHaofangBuy().doubleValue(), NumberHelper.NUMBER_IN_1));
			accountInfoDto.setPerHaofangQuan(perHaofangQuan <= 0?"0":NumberHelper.formatNumber(perHaofangQuan, NumberHelper.NUMBER_IN_1));
			return ErpResponseJson.ok(accountInfoDto);
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 查询历史价格
	 * **/
	@ResponseBody
	@RequestMapping("/getHistoryBiddPrice")
	public ErpResponseJson getHistoryBiddPrice(@Valid @RequestBody BaseMapParam param) throws Exception{
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", getOperator().getCityId());
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
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("residualAmount", String.valueOf(remainsBiddPrice));
		resMap.put("historyBiddprice", String.valueOf(history_biddPrice));
		AdminFunCity cityPo =	adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		Double maxPrice = cityPo.getHouseBiddingMaxPrice().doubleValue();//最高出价
		Double minPrice = cityPo.getHouseBiddingMinPrice().doubleValue();//最低出价
		resMap.put("maxPrice", String.valueOf(maxPrice));
		resMap.put("minPrice", String.valueOf(minPrice));
		return ErpResponseJson.ok(resMap);
	}

	/**
	 * 比较新出的价格排名情况
	 * @param SALE_LEASE  类型
	 * @param BUILD_ID  小区id
	 * @param HOUSE_ID  房源id
	 * @param ROOM  户型室
	 * @param PRICE  价格
	 * @return
	 * String STATUS;状态0 出现错误 1成功
	 *	String HOUSE_SEQ;房源排名
	 *	String BUILD_SEQ;小区排名
	 *	String BUILD_EXIST;
	 *	String HOUSE_EXIST;
	 * **/
	@ResponseBody
	@RequestMapping("/getHouseInfoSEQ")
	public ErpResponseJson getHouseInfoSEQ(@Valid @RequestBody BaseMapParam param) throws Exception{
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", getOperator().getCityId());
		pMap.put("compId", getOperator().getCompId());
		pMap.put("uaId", getOperator().getUaId());
		pMap.put("compUaId", getOperator().getCompUaId());
		pMap.put("userRight", getOperator().getUserRight());
		pMap.put("isPerLogin", getOperator().isPerLogin());
		Map<String, Object> resMap = erpFunHouseBiddingService.getHouseInfoSEQ(pMap);
		ErpResponseJson responseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resMap);
		return responseJson;
	}

	/**
	 * 获取推广房源列表
	 * @author 熊刚
	 * @since 
	 * @param saleLease 出售=1 出租=2  buildId 	楼盘ID  buildName 楼盘名称   orderby 排序
	 * @param trueFlag	排除未点亮的真房源，传了就是查点亮的传1，没有传就是空
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获取推广房源列表")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = ErpFunHouseBiddingDto.class)})
	@ResponseBody
	@RequestMapping("/getHouseBiddingList")
	public ErpResponseJson getHouseBiddingList(@Valid @RequestBody ReqHouseBiddPageParam param) throws Exception{
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setArchiveId(operator.getArchiveId());
		Integer cityId =getOperator().getCityId();
		String orderbyStr = param.getOrderby();
		String orderBy="";
		if (StringUtils.isNotBlank(orderbyStr)){
			orderBy+=" C.YY_STATUS DESC,";
			if ("0".equals(orderbyStr)){
				orderBy=" C.YY_STATUS ASC,";
			}
		}
		param.setOrderby(orderBy);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunHouseBiddingDto> resList = erpFunHouseBiddingMapper.getHouseBiddingList(cityId,param);
		if (resList==null|| resList.isEmpty()){
			return ErpResponseJson.ok(new ArrayList<>());
		}
		this.getConversionCount(resList);
		// 查询已经竞价的数据
		List<Integer> biddHouseIds = new ArrayList<>();
		// 所有id查询发布情况
		List<Integer> biddAllHouseIds = new ArrayList<>();
		for (ErpFunHouseBiddingDto tmp : resList) {
			Integer houseId = tmp.getHouseId();
			String endTimeS = tmp.getBiddEndTime();
			if (StringUtil.isNotEmpty(endTimeS)) {
				String sysTimeS = tmp.getBiddDbSystime();
				Date endTimeD = DateTimeHelper.parseToDate(endTimeS,"yyyy-MM-dd HH:mm:ss");
				Date sysTimeD = DateTimeHelper.parseToDate(sysTimeS,"yyyy-MM-dd HH:mm:ss");
				if (endTimeD.getTime() > sysTimeD.getTime()) {
					biddHouseIds.add(houseId);// 准备需要竞价排序的字段
				}
			}
			biddAllHouseIds.add(houseId);
		}
		Map<String, Map<String,Object>> countMap = new HashMap<>();
		if (biddHouseIds.size()>0){
			countMap = this.biddSeqData(cityId,param.getSaleLease(), biddHouseIds.toString().replaceAll("\\[|\\]", ""));
			this.buildBiddData(resList, countMap, param);
		}
		PageInfo<ErpFunHouseBiddingDto> pageInfo = new PageInfo<ErpFunHouseBiddingDto>(resList);
		return ErpResponseJson.ok(pageInfo);
	}

	private void buildBiddData(List<ErpFunHouseBiddingDto> houseList, Map<String, Map<String, Object>> countMap, ReqHouseBiddPageParam param) throws ParseException {
		// dataKey 的格式：HOUSEID_SALELEASE_HOUSEUSEAGE
		for (ErpFunHouseBiddingDto houseBiddingDto : houseList) {
			String endTimeS = houseBiddingDto.getBiddEndTime();
			String sysTimeS = houseBiddingDto.getBiddDbSystime();
			if (!"".equals(endTimeS)) {
				Date endTimeD = DateTimeHelper.parseToDate(endTimeS, "yyyy-MM-dd HH:mm:ss");
				Date sysTimeD = DateTimeHelper.parseToDate(sysTimeS, "yyyy-MM-dd HH:mm:ss");
				if (endTimeD.getTime() < sysTimeD.getTime()) {// 竞价的最后时间如果小于了当前系统时间说明过期
					continue;
				}
			}
			// 合并排名和房源数据
			Integer houseId = houseBiddingDto.getHouseId();
			Byte houseUseage = houseBiddingDto.getHouseUseage();
			String key = houseId + "_" + param.getSaleLease() + "_"
					+ houseUseage;
			if (countMap != null && !countMap.isEmpty()) {
				Map<String, Object> map = countMap.get(key);
				if (map == null) {
					continue;
				}
				String buildSeq = (String) map.get("BUILD_SEQ");
				String houseSeq = (String) map.get("HOUSE_SEQ");
				houseBiddingDto.setBuildSeq(buildSeq);
				houseBiddingDto.setHouseSeq(houseSeq);
			}
		}
	}

	private Map<String, Map<String, Object>> biddSeqData(Integer cityId, Integer caseType, String houseIds) {
		List<Map<String, Object>> seqData = erpFunHouseBiddingMapper.biddSeqData(cityId, caseType, houseIds);
		Map<String, Map<String, Object>> biddCount = seqData.stream().collect
				(Collectors.toMap(val -> "" + val.get("HOUSE_ID") + caseType + val.get("HOUSE_USEAGE"), val -> val));
		return biddCount;
	}

	private void getConversionCount(List<ErpFunHouseBiddingDto> resList) {
		Integer cityId = getOperator().getCityId();
		resList.forEach(houseBiddingDto -> {
			String houseFitment = houseBiddingDto.getHouseFitment();
			if (StringUtils.isNotBlank(houseFitment)) {
				ErpDicDefinitions dic = erpDicDefdinitionsService.getDicValue("HOUSE_FITMENT", houseFitment, cityId);
				if (dic != null) {
					houseBiddingDto.setHouseFitmentText(dic.getDicCnMsg());
				}
			}
			Byte houseUseage = houseBiddingDto.getHouseUseage();
			if (houseUseage != null) {
				ErpDicDefinitions dic = erpDicDefdinitionsService.getDicValue("HOUSE_USEAGE", houseFitment, cityId);
				if (dic != null) {
					houseBiddingDto.setHouseUseageText(dic.getDicCnMsg());
				}
			}
			String thumbUrl = houseBiddingDto.getThumbUrl();
			houseBiddingDto.setThumbUrl(CommonUtil.getHousePhoto(thumbUrl));

			String remainsDays = houseBiddingDto.getRemainsDays();
			String remainsHours = houseBiddingDto.getRemainsHours();
			String remainsMinus = houseBiddingDto.getRemainsMinus();
			String timeTip = "";
			String timeTipUnit = "";
			remainsDays = (StringUtils.isNotBlank(remainsDays) && !"0".equals(remainsDays)) ? (Integer.parseInt(remainsDays) - 1) + "" : "0";
			if (!"".equals(remainsDays) && !"0".equals(remainsDays)) {//-1的情况不可能发生
				timeTip = remainsDays;
				timeTipUnit = "天";
			}
			if (StringUtils.isNotBlank(remainsHours) && "0".equals(remainsDays) && !"0".equals(remainsHours)) {
				if (StringUtils.isNotBlank(remainsHours) && Integer.parseInt(remainsHours) - 24 > 0) {
					timeTip = "1";
					timeTipUnit = "天";
				} else {
					timeTip = remainsHours;
					timeTipUnit = "小时";
				}
			}
			if (!"".equals(remainsMinus) && "0".equals(remainsHours) && !"0".equals(remainsMinus)) {
				timeTip = remainsMinus;
				timeTipUnit = "分钟";
			} else if ("0".equals(remainsDays) && "0".equals(remainsHours)) {
				timeTip = "1";
				timeTipUnit = "分钟";
			}
			houseBiddingDto.setRemainsDays(timeTip);
			houseBiddingDto.setRemainsDaysUnit(timeTipUnit);
			houseBiddingDto.setHouseArea(NumberHelper.formatNumber(houseBiddingDto.getHouseArea(), NumberHelper.NUMBER_IN_2));
			houseBiddingDto.setHouseTotalPrice(NumberHelper.formatNumber(houseBiddingDto.getHouseTotalPrice(), NumberHelper.NUMBER_IN_2));
			if (houseBiddingDto.getBiddSource() != null) {
				houseBiddingDto.setBiddingPrice(new BigDecimal(NumberHelper.formatNumber(houseBiddingDto.getBiddSource(), NumberHelper.NUMBER_IN_2)));
			}
			AdminFunCity city = adminFunCityMapper.getDataByCityId(houseBiddingDto.getCityId());
			if (city != null) {
				String url = "http://%s.haofang.net/%s/%s_1";
				String caseStr = "sale";
				String citystr = city.getPyCode();
				if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(houseBiddingDto.getSaleLease().intValue())) {
					caseStr = "lease";
				}
				houseBiddingDto.setYySite(String.format(url, citystr, caseStr, houseBiddingDto.getHouseId()));
			}
		});
	}

	/**
	 * 获取小区专家列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/23
	 */
	@ResponseBody
	@RequestMapping("/getBuildBiddInfo")
	public ErpResponseJson getBuildBiddInfo(@Valid @RequestBody BaseMapParam param){
		Integer archiveId = param.getInteger("archiveId")!=null?param.getInteger("archiveId"):getOperator().getArchiveId();
		String isCanExtension = StringUtil.isNotBlank(param.getString("isCanExtension"))?param.getString("isCanExtension"):"0";// 只查询可以推广的，1=是
		Integer cityId=getOperator().getCityId();
		Integer userId=getOperator().getUserId();
		//获取楼盘竞价信息--有自己的楼盘竞价信息  FunBuildingBiddingService
		List<AdminFunBuildingBidding> biddPos = this.getBuildBiddingByArchiveId(cityId,archiveId);
		Map<String, AdminFunBuildBiddDto> resultBiddMap = new HashMap<>();
		Set<Integer> archiveIds = new HashSet<>();
		if(biddPos != null && !biddPos.isEmpty()){
			//BIDDFLAG 1:我要续期 2:立即抢驻 3:预约下期 4:预约被超出 5:等待下期 6:加关注(该情况不需要标记)
			//预约下一期的数据是否存在 -- 判断IS_TOP是否为1， 不为1说明已被超过
			List<AdminFunBuildingBidding> willBiddPos =  adminFunBuildingBiddingMapper.getFutureBuildBiddList(cityId,archiveId,null);
			//JSON格式：[{BUILD_ID:'',BUILD_NAME:'',BIDDFLAG:'',S_DATE:'',E_DATE:''}]
			Set<Integer> buildIdSet = new HashSet<>();//判断该数据是否含有预约下期的竞价
			if(willBiddPos != null && !willBiddPos.isEmpty()){//有预约下一期的数据
				for(AdminFunBuildingBidding willBiddBuild : willBiddPos){
					buildIdSet.add(willBiddBuild.getBuildId());
				}
			}
			for(AdminFunBuildingBidding tmp : biddPos){//查询这一批竞价的经纪人信息
				Integer archiveIdTmp = tmp.getArchiveId();
				archiveIds.add(archiveIdTmp);
			}
			for (AdminFunBuildingBidding tmp : biddPos) {// 这里查询出来的肯定是已经上架的小区，只不过是包含有自己的或者别人竞价成功的
				Integer buildId = tmp.getBuildId();
				Integer archiveIdTmp = tmp.getArchiveId();
				boolean isSelf = archiveIdTmp.equals(archiveId);// 是自己的竞价楼盘
				AdminFunBuildBiddDto buildBiddVo = new AdminFunBuildBiddDto();
				buildBiddVo.setBuildId(buildId);
				buildBiddVo.setBuildName(tmp.getBuildName());
				buildBiddVo.setBeginTime(tmp.getBeginTime());
				Date endTime = tmp.getEndTime();
				buildBiddVo.setEndTime(endTime);

				double seconds = DateTimeHelper.getSecondsOfTwoDate(endTime, DateTimeHelper.getSystemDate());
				double rsMinutes = Math.floor(seconds);
				long days = Math.round(Math.floor(NumberHelper.div(rsMinutes, 60 * 60 * 24)));
				long hours = Math.round(Math.floor(NumberHelper.div(seconds,60*60) % 24));
				long minutes = Math.round(Math.floor(NumberHelper.div(seconds,60) % 60));
				buildBiddVo.setShowTime(days + "_" + hours + "_" + minutes);
				if(!buildIdSet.isEmpty()){//有预约下一期的数据
					//1、遍历哪些是自己关注的 但是暂时有别人竞价成功 ，自己有预约了下一期的数据
					//2、自己竞价成功 ，自己有预约了下一期的数据
					for(AdminFunBuildingBidding willBiddBuild : willBiddPos){
						Byte isTop = willBiddBuild.getIsTop();//预约下一期，是否是第一。
						if(isTop==1 && willBiddBuild.getBuildId().equals(buildId)
								&& archiveId.equals(willBiddBuild.getArchiveId())){//表示是自己关注的已预约的楼盘
							buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_5));
						}else if(isTop==0 && willBiddBuild.getBuildId().equals(buildId)
								&& archiveId.equals(willBiddBuild.getArchiveId())){//表示是自己关注的已预约的楼盘
							buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_4));
						}else if(isTop==1 //不是自己的但是他人也做了下期预约竞价并且是第一名
								&& StringUtil.isBlank(buildBiddVo.getBiddFlag())
								&& willBiddBuild.getBuildId().equals(buildId)
								&& !archiveId.equals(willBiddBuild.getArchiveId())){//表示不是自己关注的已预约的楼盘
							buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_3));
						}
					}
				}
				if(buildIdSet.isEmpty() || !buildIdSet.contains(buildId)){
					//没有预约的情况
					if(isSelf){//是自己的提示我要续期
						buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_1));
					}else{
						buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_3));
					}
				}
				buildBiddVo.setArchiveId(archiveIdTmp);
				resultBiddMap.put(StringUtil.toString(buildId), buildBiddVo);
			}
		}

		//现在存在三种情况，1、用户没有关注任何楼盘， 2、关注了部分楼盘也竞价了这部分楼盘，3、关注了楼盘但是竞价并没有全部参与竞价。
		//获取用户已关注的楼盘
		List<AdminFunBuildAttention> funBuildAttentionPos = adminFunBuildAttentionMapper.getBuildAttentionByArchiveIdAndCityId(cityId,archiveId);
		// 不足6个时补充
		if(funBuildAttentionPos.size() < 6) {
			List<Integer> buildIds = funBuildAttentionPos.stream().collect(Collectors.mapping(AdminFunBuildAttention::getBuildId,Collectors.toList()));
			AdminFunArchive funArchivePO = adminFunArchiveMapper.getArchiveById(archiveId);
			String[] buildRegion=funArchivePO.getServiceReg().trim().split(" ");
			String[] sectionId=funArchivePO.getServiceZoneIds().trim().split(" ");

			List<ErpBuildingInfo> modelDataList = erpBuildingInfoMapper.getBuildInfoByByParam(cityId,funBuildAttentionPos.size(),buildIds,buildRegion,sectionId);
			if (!modelDataList.isEmpty()) {
				for (ErpBuildingInfo buildingInfoPO : modelDataList) {
					AdminFunBuildAttention funBuildAttentionPO = new AdminFunBuildAttention();
					funBuildAttentionPO.setArchiveId(archiveId);
					funBuildAttentionPO.setCityId(getOperator().getCityId());
					funBuildAttentionPO.setBuildName(buildingInfoPO.getBuildName());
					funBuildAttentionPO.setBuildId(buildingInfoPO.getBuildId());
					funBuildAttentionPO.setAutoAttention((byte)1);
					adminFunBuildAttentionMapper.insertSelective(funBuildAttentionPO);
					funBuildAttentionPos.add(funBuildAttentionPO);
				}
			}
		}
		if (isCanExtension.equals("1")){
			Set<Integer> buildIds = new HashSet<>();
			for (AdminFunBuildAttention attentionBuild : funBuildAttentionPos) {
				Integer buildId = attentionBuild.getBuildId();
				buildIds.add(buildId);
			}
			List<ErpFunSale> saleList =erpFunSaleMapper.getFunSaleListByParam(cityId,userId,buildIds);
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getFunLeaseListByParam(cityId,userId,buildIds);
			// 移除掉房源里面没有的楼盘
			AdminFunBuildAttention tempAttentionBuild = funBuildAttentionPos.get(0);
			for (int i = funBuildAttentionPos.size()-1; i >= 0; i--) {
				AdminFunBuildAttention funBuildAttentionPO = funBuildAttentionPos.get(i);
				Integer buildId = funBuildAttentionPO.getBuildId();
				boolean have = false;
				for (ErpFunSale funSalePO : saleList) {
					if(buildId.equals(funSalePO.getBuildId())) {
						have = true;break;
					}
				}
				if(!have) {
					for (ErpFunLease funLeasePO : leaseList) {
						if(buildId.equals(funLeasePO.getBuildId())) {
							have = true;break;
						}
					}
				}
				// 没有竞价的
				if(!resultBiddMap.containsKey(funBuildAttentionPO.getBuildId())) {
					tempAttentionBuild = funBuildAttentionPO;
				}
				if(!have) {
					funBuildAttentionPos.remove(i);
				}
			}
			if(funBuildAttentionPos.isEmpty()) {
				funBuildAttentionPos.add(tempAttentionBuild);
			}
		}
		//查询出小区竞价的经纪人信息
		Map<Integer,AdminFunArchive> archiveIdMap = new HashMap<>(archiveIds.size());
		if (!archiveIds.isEmpty()) {
			List<AdminFunArchive> tmpPos =adminFunArchiveMapper.getListByArchiveIds(new ArrayList<>(archiveIds));
			for (AdminFunArchive archivePo : tmpPos) {
				archiveIdMap.put(archivePo.getArchiveId(), archivePo);
			}
		}

		// 拼装数据
		for(AdminFunBuildAttention attentionBuild : funBuildAttentionPos){
			Integer buildId = attentionBuild.getBuildId();
			AdminFunBuildBiddDto buildBiddVo = resultBiddMap.get(buildId);
			if(buildBiddVo == null){//这里是已关注的楼盘但是没有预约下期的和自己竞价的 -- 立即入驻的情况
				buildBiddVo = new AdminFunBuildBiddDto();
				buildBiddVo.setBuildId(buildId);
				buildBiddVo.setBuildName(attentionBuild.getBuildName());
				buildBiddVo.setBiddFlag(StringUtil.toString(Const.DIC_BUILD_BIDD_FLAG_2));
				resultBiddMap.put(StringUtil.toString(buildId), buildBiddVo);
			}
			// 当前竞价经纪人信息
			AdminFunArchive archivePo = archiveIdMap.get(buildBiddVo.getArchiveId());
			if(archivePo != null) {
				buildBiddVo.setUserName(archivePo.getUserName());
				buildBiddVo.setUserPhoto(StringUtil.getBbsPhoto(archivePo.getUserPhoto()));
			}
		}
		List<AdminFunBuildBiddDto> resultBidd = BeanUtil.MapObjTolistObj(resultBiddMap);
		ErpResponseJson responseJson = ErpResponseJson.ok(resultBidd);
		responseJson.setTotal(Long.valueOf(resultBidd.size()));
		return responseJson;
	}

	/**
	 * 获取楼盘竞价信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/23
	 */
	private List<AdminFunBuildingBidding> getBuildBiddingByArchiveId(Integer cityId,Integer srcArchiveId) {
		//这个集合可以为空集合
		List<AdminFunBuildingBidding> buildbiddList = new ArrayList<>();
		String nowTime= DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss.S");
		//查询出自己竞价的楼盘
		List<AdminFunBuildingBidding> buildbiddListSelfs = adminFunBuildingBiddingMapper.getSelfBiddList(cityId,srcArchiveId,nowTime);
		String buildIds = null;
		if(buildbiddListSelfs!= null && !buildbiddListSelfs.isEmpty()){
			StringBuilder sb = new StringBuilder();
			for(AdminFunBuildingBidding tmp : buildbiddListSelfs){
				sb.append(tmp.getBuildId()).append(",");
			}
			sb.deleteCharAt(sb.length() - 1);
			buildIds = StringUtil.toString(sb);
		}
		//查询出竞价成功的楼盘，并且不是自己的。
		List<AdminFunBuildingBidding> buildbiddListNoSelf =adminFunBuildingBiddingMapper.getBiddSuccList(cityId,buildIds,srcArchiveId,nowTime);
		//排列的顺序，优先显示自己竞价成功的，然后是已关注的但还没有他人竞价的，然后已关注但已被他人竞价的你可以续期的。
		if(buildbiddListSelfs != null){
			buildbiddList.addAll(buildbiddListSelfs);
		}
		if(buildbiddListNoSelf != null){
			buildbiddList.addAll(buildbiddListNoSelf);
		}
		return buildbiddList;
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
	 * 关注一个楼盘
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/11
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/addBuildAttentionInfo")
	public ErpResponseJson addBuildAttentionInfo(@Valid @RequestBody BaseMapParam param){
		String buildId = param.getString("buildId");
		String buildName = param.getString("buildName");
		Integer cityId=getOperator().getCityId();
		Integer archiveId=getOperator().getArchiveId();
		int buildCounr = adminFunBuildAttentionMapper.count(cityId,archiveId,null);
		if(buildCounr >=Const.MAX_BIDDING_NUM){
			throw new BusinessException("每个人最多只能关注" + Const.MAX_BIDDING_NUM + "个小区！");
		}
		buildCounr = adminFunBuildAttentionMapper.count(cityId,archiveId,buildId);
		AdminFunBuildAttention adminFunBuildAttention=new AdminFunBuildAttention();
		adminFunBuildAttention.setArchiveId(archiveId);
		adminFunBuildAttention.setCityId(cityId);
		adminFunBuildAttention.setBuildName(buildName);
		adminFunBuildAttention.setBuildId(Integer.valueOf(buildId));
		if(buildCounr == 0){
			adminFunBuildAttentionMapper.insertSelective(adminFunBuildAttention);
		}
		if(buildCounr > 0){
			throw new BusinessException("该小区您已经关注，请更换！");
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 更换关注小区
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/11
	 */
	@ResponseBody
	@RequestMapping("/deleteBuildAttentionInfo")
	public ErpResponseJson deleteBuildAttentionInfo(@Valid @RequestBody BaseMapParam param) {
		String newBuildId = param.getString("newBuildId");
		Integer cityId = getOperator().getCityId();
		Integer archiveId = getOperator().getArchiveId();
		int buildCounr = adminFunBuildAttentionService.countData(newBuildId, cityId, archiveId);
		if (buildCounr > 0) {
			throw new BusinessException("该小区您已经关注，请更换！");
		}
		String oldBuildId = param.getString("oldBuildId");
		String newBuildName = param.getString("buildName");
		adminFunBuildAttentionService.createBuildAttention(cityId,archiveId,oldBuildId,newBuildId,newBuildName);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取房源库存
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/12
	 */
	@ApiOperation("获取房源库存")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = HousePubFlagAllDto.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getHousePubFlagAll")
	public ErpResponseJson getHousePubFlagAll(@Valid @RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		Integer archiveId = getOperator().getArchiveId();
		Integer userId = getOperator().getUserId();
		Integer compId = getOperator().getCompId();
		Integer qqPublish = getOperator().getQQPublish();
		List<HousePubFlagAllDto> list = new ArrayList<>();
		list.add(erpFunHousePublishStatusService.getHousePubFlagAll(cityId, archiveId, userId, compId, qqPublish));
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 创建房源竞价数据
	 * @author HeWei
	 * @since 2018年7月23日 上午10:28:41
	 * @param param
	 * @return
	 * Modified XXX HeWei 2018年7月23日
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/updateHouseBidding")
	public ErpResponseJson updateHouseBidding(@Valid @RequestBody BaseMapParam param) throws Exception{
		
		Byte saleLease = param.getByte("saleLease");
		Integer houseId = param.getInteger("houseId");
		Integer buildId = param.getInteger("buildId");
		String biddPrice = param.getString("biddPrice");
		Byte useage = param.getByte("houseUseage");
		Integer cityId = getOperator().getCityId();
		Integer archiveId = getOperator().getArchiveId();
		boolean personalVersion = getOperator().isPersonalVersion();
		String superUser = getOperator().getAttribute("SUPER_USER").toString();
		Integer compId = getOperator().getCompId();
		Integer uaId = getOperator().getUaId();
		Integer compUaId = getOperator().getCompUaId();
		String otoFlag = getOperator().getAttribute("O2O_FLAG").toString();
		Integer userId = getOperator().getUserId();
		String userRight = getOperator().getUserRight();
		String deptFlag = getOperator().getAttribute("DEPT_FLAG").toString();
		
		
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("saleLease", saleLease);
		pMap.put("houseId", houseId);
		pMap.put("buildId", buildId);
		pMap.put("biddPrice", biddPrice);
		pMap.put("useage", useage);
		pMap.put("archiveId", archiveId);
		pMap.put("superUser", superUser);
		pMap.put("compId", compId);
		pMap.put("uaId", uaId);
		pMap.put("compUaId", compUaId);
		pMap.put("otoFlag", otoFlag);
		pMap.put("userId", userId);
		pMap.put("userRight", userRight);
		pMap.put("deptFlag", deptFlag);
		
		Map<String, String> updateHouseBidding = erpFunHouseBiddingService.updateHouseBidding(cityId,personalVersion,pMap);
		
		if(checkHouseIsPub(saleLease.toString(), houseId,cityId)){
			adminJmsMessageService.createCountScoreData(cityId, userId, UserScoreTypeConfig.UserScoreType.FYTG_SCORE.getScoreType().toString(),saleLease.intValue(),houseId);
		}
		return ErpResponseJson.ok(updateHouseBidding);
	}
	private boolean checkHouseIsPub(String caseType,Integer caseId,Integer cityId) throws Exception{
		if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			ErpFunLease dataObject = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if("1".equals(dataObject.getLeasePublish())){
				return true;
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			ErpFunSale dataObject = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if("1".equals(dataObject.getSalePublish())){
				return true;
			}
		}
		return false;
	}
	/**
	 * 小区竞价预扣费
	 * @author ZangTie
	 * @since 2018年7月19日 下午5:01:42
	 * @param param buildId=主键ID buildName=楼盘名  biddPrice=竞价金额
	 * @return
	 * Modified XXX ZangTie 2018年7月19日
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/getBuildInfoSEQ")
	public ResponseJson getBuildInfoSEQ(@RequestBody BaseMapParam param) throws Exception{
		Integer buildId = param.getInteger("buildId");
		String buildName = param.getString("buildName");
		String biddPrice = param.getString("biddPrice");
		Integer cityId = getOperator().getCityId();
		// 获取小区排名和扣费情况
		if (CommonUtil.isnull(getOperator().getUserRight()) || !"1".equals(getOperator().getUserRight())) {
			return null;
		}
		if (CommonUtil.isnull(getOperator().getUaId())) {
			return null;
		}
		//竞价的金额
		double biddMoney = Double.parseDouble(biddPrice);
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId.toString()));
		double maxPrice = adminFunCity.getBuildBiddingMaxPrice().doubleValue();// 最高出价
		double minPrice = adminFunCity.getBuildBiddingMinPrice().doubleValue();// 最低出价
		if (biddMoney < minPrice) {
			throw new BusinessException(Constants_DIC.TEXT_BIDD_LIMIT_MIN.replaceAll("#PRICE#",
					NumberHelper.formatNumber(minPrice, NumberHelper.NUMBER_IN_1)));
		} else if (biddMoney > maxPrice) {
			throw new BusinessException(Constants_DIC.TEXT_BIDD_LIMIT_MAX.replaceAll("#PRICE#",
					NumberHelper.formatNumber(maxPrice, NumberHelper.NUMBER_IN_1)));
		}
		//这里的操作涉及到相互竞争第一名，超过的需要重新替换 第一名的小区专家 -- 历史预约出价
		AdminFunBuildingBiddingExample adminFunBuildingBiddingExample = new AdminFunBuildingBiddingExample();
		adminFunBuildingBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId)
				.andBeginTimeGreaterThanOrEqualTo(new Date()).andQqStatusEqualTo((byte)0).andHaofangStatusEqualTo((byte)0);
		adminFunBuildingBiddingExample.setOrderByClause(" IS_TOP DESC,PRICE DESC ");
		List<AdminFunBuildingBidding> list = adminFunBuildingBiddingMapper.selectByExample(adminFunBuildingBiddingExample);
		double newbiddMoney = Double.parseDouble(biddPrice);//新的出价合计
		double historyBiddMoneySelf = 0.0d;//本人的历史出价合计
		int biddSeq = 0;
		boolean isFutureBidd = false;//是否是预约下期竞价
		if (list.size() > 0) {// 有历史预约出价的情况
			AdminFunBuildingBidding adminFunBuildingBidding = list.get(0);
			// 判断用户是否大于预约出价是第一的价格
			if (!adminFunBuildingBidding.getArchiveId().equals(getOperator().getArchiveId())) {// 不是本人
				double historyBiddMoney = adminFunBuildingBidding.getSortPrice().doubleValue();
				if (newbiddMoney <= historyBiddMoney) {
					// 出价没有超过前一个
					Map<String, String> returnMap = new HashMap<String, String>();
					returnMap.put("bidLittle", Constants_DIC.DIC_CAPITAL_OFFER_NO);
					return ErpResponseJson.ok(returnMap);
				}
			}
			for (AdminFunBuildingBidding tmpBidding : list) {// 检查当前用户是否参与了竞价，只不过现在已经不是第一名了。
				if (tmpBidding.getArchiveId().equals(getOperator().getArchiveId())) {
					historyBiddMoneySelf = tmpBidding.getPrice().doubleValue();
				}
				if (biddMoney < tmpBidding.getPrice().doubleValue()) {
					biddSeq++;
				}
			}
			isFutureBidd = true;
		}
		if (newbiddMoney <= historyBiddMoneySelf) {
			throw new BusinessException(Constants_DIC.TEXT_BIDD_SELF.replaceAll("#PRICE#",
					NumberHelper.formatNumber(historyBiddMoneySelf, NumberHelper.NUMBER_IN_1)));// 新出的价格没有大于自己历史出价，不能执行
		}
		// 本次要扣的费用
		double cutmoney = NumberHelper.sub(newbiddMoney, historyBiddMoneySelf);
		// 会员价格减半
		if ("1".equals(getOperator().getSUPER_USER())) {
			cutmoney = Math.ceil(cutmoney / 2);
		}
		Map<String, String> priceInfo = adminFunUserAccountService.getBiddPrice(getOperator().getUaId().toString(), getOperator().getCompUaId().toString(), getOperator().isPersonalVersion(), cityId, getOperator().getCompId(), cutmoney);
		priceInfo.put("buildSurplus", String.valueOf(NumberHelper.formatNumber(cutmoney, NumberHelper.NUMBER_IN_1)));// 支付的余额
		priceInfo.put("buildMust",NumberHelper.formatNumber(NumberHelper.formatNumber(newbiddMoney), NumberHelper.NUMBER_IN_1));// 应付金额
		
		AdminFunBuildingBiddingExample succExample = new AdminFunBuildingBiddingExample();
		succExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId)
				.andEndTimeGreaterThanOrEqualTo(new Date()).andQqStatusEqualTo((byte)1).andHaofangStatusEqualTo((byte)1);
		List<AdminFunBuildingBidding> succlist = adminFunBuildingBiddingMapper.selectByExample(succExample);
		if(succlist.size() > 1){//小区竞价 同一个小区在竞价成功后的推广时间内只有一个能在网上存在
			throw new BusinessException(buildName + " 楼盘在推广竞价时出错！");
		}
		if (succlist.size() > 0) {
			AdminFunBuildingBidding tmpSucc = succlist.get(0);
			isFutureBidd = true;
			double seconds = DateTimeHelper.getSecondsOfTwoDate(tmpSucc.getEndTime(), DateTimeHelper.getSystemDate());
			double rsMinutes = Math.floor(seconds);
			long sdays = Math.round(Math.floor(NumberHelper.div(rsMinutes, 60 * 60 * 24)));
			long shours = Math.round(Math.floor(NumberHelper.div(seconds, 60 * 60) % 24));
			long sminutes = Math.round(Math.floor(NumberHelper.div(seconds, 60) % 60));
			String showTime = sdays + "_" + shours + "_" + sminutes;
			priceInfo.put("showTime", showTime);// 上一期竞价还没结束的数据时间
		}
		//"USE_COIN":"9221","USE_QUAN":"-9200"
		//实际使用的好房豆
		double haofangbi = NumberHelper.add(Double.parseDouble(priceInfo.get("PERSONAL_COIN")), Double.parseDouble(priceInfo.get("COMP_COIN")));
		if(StringUtil.isEmpty(priceInfo.get("UA_TYPE"))){
			//本次竞价使用了多少优惠券
			priceInfo.put("useQuan", String.valueOf(NumberHelper.formatNumber(NumberHelper.sub(cutmoney, haofangbi),NumberHelper.NUMBER_IN_1)));
			//本次竞价使用了多少好房币
			priceInfo.put("useCoin", String.valueOf(NumberHelper.formatNumber(haofangbi,NumberHelper.NUMBER_IN_1)));
		}else{
			//本次竞价使用了多少优惠券
			priceInfo.put("useQuan", String.valueOf(NumberHelper.formatNumber(NumberHelper.sub(cutmoney, haofangbi),NumberHelper.NUMBER_IN_1)));
			//本次竞价使用了多少好房币
			priceInfo.put("useCoin", String.valueOf(NumberHelper.formatNumber(haofangbi,NumberHelper.NUMBER_IN_1)));
		}
		priceInfo.put("perUseCoin", String.valueOf(NumberHelper.formatNumber(priceInfo.get("PERSONAL_COIN"),NumberHelper.NUMBER_IN_1)));//个人使用的好房币部分
		priceInfo.put("compUseCoin", String.valueOf(NumberHelper.formatNumber(priceInfo.get("COMP_COIN"),NumberHelper.NUMBER_IN_1)));//公司使用的好房币部分
		priceInfo.put("perUsePrice", String.valueOf(NumberHelper.formatNumber(priceInfo.get("PERSONAL_PRICE"),NumberHelper.NUMBER_IN_1)));//个人使用的优惠券部分
		priceInfo.put("compUsePrice", String.valueOf(NumberHelper.formatNumber(priceInfo.get("COMP_PRICE"),NumberHelper.NUMBER_IN_1)));//公司使用的优惠券部分
		priceInfo.put("buildSeq", String.valueOf((biddSeq+1)));//本次排名
		priceInfo.put("historyremainsPrice", String.valueOf(historyBiddMoneySelf));//本次排名
		priceInfo.put("compCoin", priceInfo.get("COMP_COIN"));
		priceInfo.put("compPrice", priceInfo.get("COMP_PRICE"));
		priceInfo.put("personalPrice", priceInfo.get("PERSONAL_PRICE"));
		priceInfo.put("personalCoin", priceInfo.get("PERSONAL_COIN"));
		priceInfo.put("uaType", priceInfo.get("UA_TYPE"));
		if(isFutureBidd){
			priceInfo.put("biddFuture", "1");//有预约竞价的记录
		}else{
			priceInfo.put("biddFuture", "0");//还没有预约竞价记录
		}
		//这里默认为0，即出价正确 --李勇
		priceInfo.put("bidLittle", Constants_DIC.DIC_CAPITAL_OFFER_YES);
		return ErpResponseJson.ok(priceInfo);
	}
	
	/**
	 * 查询楼盘的当前最高出价
	 * @author ZangTie
	 * @since 2018年7月20日 上午9:36:15
	 * @param param  buildId=楼盘ID
	 * @return
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月20日
	 */
	@ResponseBody
	@RequestMapping("/getBidPrice")
	public ResponseJson getBidPrice(@RequestBody BaseMapParam param) throws Exception{
		Integer buildId = param.getInteger("buildId");
		Integer archiveId = getOperator().getArchiveId();
		Integer cityId = getOperator().getCityId();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		// 查询该楼盘的预约下期数据
		AdminFunBuildingBiddingExample adminFunBuildingBiddingExample = new AdminFunBuildingBiddingExample();
		adminFunBuildingBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId).andIsTopEqualTo((byte)1)
				.andBeginTimeEqualTo(new Date()).andEndTimeEqualTo(new Date()).andPayFlagEqualTo((byte)0)
				.andQqStatusEqualTo((byte)0).andHaofangStatusEqualTo((byte)0);
		adminFunBuildingBiddingExample.setOrderByClause(" END_TIME DESC ");
		AdminFunBuildingBidding buildBidding = adminFunBuildingBiddingMapper.selectOneByExample(adminFunBuildingBiddingExample);
		if (buildBidding != null) {
			// 查询自己预约该楼盘的数据
			AdminFunBuildingBiddingExample ownBiddingExample = new AdminFunBuildingBiddingExample();
			ownBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId).andArchiveIdEqualTo(archiveId)
					.andBeginTimeEqualTo(new Date()).andEndTimeEqualTo(new Date()).andPayFlagEqualTo((byte)0)
					.andQqStatusEqualTo((byte)0).andHaofangStatusEqualTo((byte)0);
			adminFunBuildingBiddingExample.setOrderByClause(" END_TIME DESC ");
			AdminFunBuildingBidding ownBidding = adminFunBuildingBiddingMapper.selectOneByExample(adminFunBuildingBiddingExample);
			boolean isSelf = archiveId.equals(buildBidding.getArchiveId());//是自己的竞价楼盘
			Byte isTopOwn = null;
			if (ownBidding != null) {
				isTopOwn = ownBidding.getIsTop();// 自己的预约情况
			}
			Byte isTop = buildBidding.getIsTop();//预约下一期，是否是第一。
			if (isTop == 1 && isSelf) {// 表示是自己关注的已预约的楼盘 //等待下期
				map.put("biddflag", Constants_DIC.DIC_BUILD_BIDD_FLAG_5);
			} else if (isTopOwn != null && isTopOwn == 0) {// 表示是自己关注的已预约的楼盘 被超出
				map.put("biddflag", Constants_DIC.DIC_BUILD_BIDD_FLAG_4);
			} else if (ownBidding == null) {// 表示自己没有预约该楼盘
				map.put("biddflag", Constants_DIC.DIC_BUILD_BIDD_FLAG_3);
			}
			map.put("price", String.valueOf(buildBidding.getPrice().doubleValue()));
			map.put("sortPrice", String.valueOf(buildBidding.getSortPrice().doubleValue()));
		}else {
			// 没有预约的情况
			AdminFunBuildingBiddingExample ownBiddingExample = new AdminFunBuildingBiddingExample();
			ownBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId).andIsTopEqualTo((byte)1)
					.andEndTimeEqualTo(new Date()).andQqStatusEqualTo((byte)1).andHaofangStatusEqualTo((byte)1);
			adminFunBuildingBiddingExample.setOrderByClause(" UPDATE_TIME DESC ");
			AdminFunBuildingBidding allBidding = adminFunBuildingBiddingMapper.selectOneByExample(adminFunBuildingBiddingExample);
			if (allBidding != null) {// 说明已经有人入驻了，状态改为预约下期
				map.put("biddflag", Constants_DIC.DIC_BUILD_BIDD_FLAG_3);
			} else {// 说明此楼盘还没有人入驻，状态改为我要入驻
				map.put("biddflag", Constants_DIC.DIC_BUILD_BIDD_FLAG_2);
			}
			map.put("price", "0");
			map.put("sortPrice", "0");
		}
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId.toString()));
		double maxPrice = adminFunCity.getBuildBiddingMaxPrice().doubleValue();// 最高出价
		double minPrice = adminFunCity.getBuildBiddingMinPrice().doubleValue();// 最低出价
		map.put("maxPrice", String.valueOf(maxPrice));
		map.put("minPrice", String.valueOf(minPrice));
		list.add(map);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 创建一个楼盘竞价信息
	 * @author ZangTie
	 * @since 2018年7月20日 上午11:29:42
	 * @param param
	 * @return
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月20日
	 */
	@ResponseBody
	@RequestMapping("/createBuildBiddInfo")
	public ResponseJson createBuildBiddInfo(@RequestBody BaseMapParam param) throws Exception{
		Integer buildId = param.getInteger("buildId");
		String buildName = param.getString("buildName");
		String biddPrice = param.getString("biddPrice");
		Integer cityId = getOperator().getCityId();
		
		if(CommonUtil.isnull(getOperator().getUaId())) {
			throw new BusinessException("请先到个人中心绑定资金账户！");
		}
		if(!"1".equals(getOperator().getUserRight())) {
			throw new BusinessException("尚未实名认证，不能参与竞价！");
		}
		// 创建一个楼盘竞价信息，或者预约竞价数据
		Map<String, String> resultMap = new HashMap<>();
		String archiveTodayData = adminArchiveTodayRecordService.getArchiveTodayData(getOperator(), Constants_DIC.DIC_BIDDING_TYPE_HOUSE_TOP);
		resultMap.put("archiveTodayFirst", archiveTodayData);
		if ("1".equals(archiveTodayData)) {
			return ErpResponseJson.ok(resultMap);
		}
		String biddingDay = adminSysParaMapper.selectParamVlue("BUILD_BIDDING_DAYS");//竞价天数
		String endMinites = adminSysParaMapper.selectParamVlue("BUILD_BIDDING_LOCK_TIME");//提前多久进入结算时间(单位：分钟)
		int days = Integer.parseInt(biddingDay);
		Date sDate = DateTimeHelper.getSystemDate();//起始时间
		Date eDate = DateTimeHelper.addDays(sDate, days);//结束时间
		String vipBiddPrice = null;
		//竞价的金额
		try{
			double biddMoney = Double.parseDouble(biddPrice);
			AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId.toString()));
			double maxPrice = adminFunCity.getBuildBiddingMaxPrice().doubleValue();// 最高出价
			double minPrice = adminFunCity.getBuildBiddingMinPrice().doubleValue();// 最低出价
			if("1".equals(getOperator().getSUPER_USER())){
				BigDecimal temp = new BigDecimal(Math.ceil(Double.parseDouble(biddPrice)/2));
				vipBiddPrice = temp.stripTrailingZeros().toPlainString();
			}
			if(biddMoney < minPrice){
				throw new BusinessException(Constants_DIC.TEXT_BIDD_LIMIT_MIN.replaceAll("#PRICE#", NumberHelper.formatNumber(minPrice,NumberHelper.NUMBER_IN_1)));
			}else if(biddMoney > maxPrice){
				throw new BusinessException(Constants_DIC.TEXT_BIDD_LIMIT_MAX.replaceAll("#PRICE#", NumberHelper.formatNumber(maxPrice,NumberHelper.NUMBER_IN_1)));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("请输入正确的竞价价格！");
		}
		// 不是第一次竞价的，需要进行预约下期竞价操作
		String noBodyBiddBuild = this.createNoBodyBiddBuild(buildId, buildName, biddPrice, sDate, eDate, resultMap, vipBiddPrice);
		if(StringUtils.isBlank(noBodyBiddBuild)){
			
			if(DateTimeHelper.addMinutes(eDate, - Integer.parseInt(endMinites)).getTime() - DateTimeHelper.getSystemDate().getTime() <= 0){//临近小区推广结束前提前多久停止竞价，等待推广结束
				throw new BusinessException(String.format("小区[ %s ]在推广结束[%s]前%s分钟为系统结算时间，不能竞价，请等待竞价结束！", buildName, DateTimeHelper.formatDateTimetoString(eDate,"yyyy-MM-dd HH:mm"), endMinites));
			}
			//预约下一期或者续费下一期
			noBodyBiddBuild = this.createBiddBuild(buildId, buildName, biddPrice,days, vipBiddPrice);
		}
		//返回当前小区竞价的ID，目前移动端在使用-陈文超-2017-10-17
		resultMap.put("currNewBiddId", noBodyBiddBuild);
		// 用户当天第一次点击
		// 修改为手动关注
		adminFunBuildAttentionMapper.updateAutoAttention(0,getOperator().getArchiveId(),buildId,cityId);
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 创建一个已竞价的楼盘信息,预约下一期
	 * @author ZangTie
	 * @since 2018年7月20日 下午9:06:18
	 * @param buildId
	 * @param buildName
	 * @param biddPrice
	 * @param days
	 * @param vipBiddPrice
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 */
	private String createBiddBuild(Integer buildId, String buildName, String biddPrice, int days, String vipBiddPrice) throws Exception {
		Map<String, String> operatorMap = new HashMap<>();
		operatorMap.put("uaId", getOperator().getUaId().toString());
		operatorMap.put("compUaId", getOperator().getCompUaId().toString());
		operatorMap.put("cityId", getOperator().getCityId().toString());
		operatorMap.put("compId", getOperator().getCompId().toString());
		operatorMap.put("superUser", getOperator().getSUPER_USER().toString());
		operatorMap.put("archiveId", getOperator().getArchiveId().toString());
		Integer cityId = getOperator().getCityId();
		AdminFunBuildingBiddingExample succBiddingExample = new AdminFunBuildingBiddingExample();
		succBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId)
				.andEndTimeGreaterThanOrEqualTo(new Date()).andQqStatusEqualTo((byte)1).andHaofangStatusEqualTo((byte)1);
		succBiddingExample.setOrderByClause(" SORT_PRICE DESC ");
		List<AdminFunBuildingBidding> succlist = adminFunBuildingBiddingMapper.selectByExample(succBiddingExample);
		
		
		//这里必须并且有且只有一条数据 已经竞价成功的数据
		if(succlist.size() < 1 || succlist.size() > 1){//小区竞价 同一个小区在竞价成功后的推广时间内只有一个能在网上存在
			throw new BusinessException(buildName + "楼盘在推广竞价时出错！NO.1");
		}
		
		Date startDate = succlist.get(0).getEndTime();//下一期是从上一期的结束时间做为起始时间
		Date endDate = DateTimeHelper.addDays(startDate, days);//下一期的结束时间
		
		//这里的操作涉及到相互竞争第一名，超过的需要重新替换 第一名的小区专家 -- 历史预约出价
		AdminFunBuildingBiddingExample biddingExample = new AdminFunBuildingBiddingExample();
		biddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId)
				.andBeginTimeGreaterThanOrEqualTo(new Date()).andQqStatusEqualTo((byte)0).andHaofangStatusEqualTo((byte)0);
		succBiddingExample.setOrderByClause(" IS_TOP DESC,PRICE DESC ");
		List<AdminFunBuildingBidding> list = adminFunBuildingBiddingMapper.selectByExample(biddingExample);
		
		double newbiddMoney = Double.parseDouble(biddPrice);//新的出价合计
		String selfBiddId = "";
		if(list.size() > 0 ){//有历史预约出价的情况
			AdminFunBuildingBidding historybiddPo = list.get(0);
			String archiveId = historybiddPo.getArchiveId().toString();
			double historySortPrice = historybiddPo.getSortPrice().doubleValue();//老的排序价格
			//如果新的出价大于了历史出价--本人的情况下支付余额，挤掉其他人的情况下需要将费用退还给以前的用户
			if(newbiddMoney > historySortPrice){
				boolean selfExitse = false;
				double historyBiddMoneySelf = 0.0d;//本人的历史出价合计
				double historyBiddMoneyCompCoin = 0.0d;//本人的历史公司好房币
				double historyBiddMoneyCompPrice = 0.0d;//本人的历史公司优惠券
				double historyBiddMoneyPersonalPrice = 0.0d;//本人的历史个人好房币
				double historyBiddMoneyPersonalCoin = 0.0d;//本人的历史个人优惠券
				for(AdminFunBuildingBidding tmpBiddPo : list){//检查当前用户是否参与了竞价，只不过现在已经不是第一名了。
					if(tmpBiddPo.getArchiveId().equals(getOperator().getArchiveId())){
						selfExitse = true;
						selfBiddId = tmpBiddPo.getBiddingId().toString();
						historyBiddMoneySelf = null == tmpBiddPo.getSortPrice() ? 0.0d : tmpBiddPo.getSortPrice().doubleValue();
						historyBiddMoneyCompCoin = null == tmpBiddPo.getCompCoin() ? 0.0d : tmpBiddPo.getCompCoin().doubleValue();
						historyBiddMoneyCompPrice = null == tmpBiddPo.getCompPrice() ? 0.0d : tmpBiddPo.getCompPrice().doubleValue();
						historyBiddMoneyPersonalPrice = null == tmpBiddPo.getPersonalPrice()? 0.0d : tmpBiddPo.getPersonalPrice().doubleValue();
						historyBiddMoneyPersonalCoin = null == tmpBiddPo.getPersonalCoin() ? 0.0d : tmpBiddPo.getPersonalCoin().doubleValue();
						break;
					}
				}
				
				if(newbiddMoney <= historyBiddMoneySelf){
					throw new BusinessException(Constants_DIC.TEXT_BIDD_SELF.replaceAll("#PRICE#", NumberHelper.formatNumber(historySortPrice,NumberHelper.NUMBER_IN_1)));//新出的价格没有大于历史出价，不能执行
				}
				//扣费计算
				Map<String, String> priceInfo = adminFunUserAccountService.updateBuildBiddPrice(operatorMap, getOperator().isPersonalVersion(), newbiddMoney,historyBiddMoneySelf,"BUILD");
				// 更新已经过期的竞价数据状态
				AdminFunHouseBiddingExample updateExample = new AdminFunHouseBiddingExample();
				updateExample.createCriteria().andArchiveIdEqualTo(getOperator().getArchiveId()).andCityIdEqualTo(cityId)
						.andBiddingEndTimeLessThan(new Date());
				AdminFunHouseBidding updateHouseBidding = new AdminFunHouseBidding();
				updateHouseBidding.setHaofangStatus((byte)0);
				updateHouseBidding.setQqStatus((byte)0);
				adminFunHouseBiddingMapper.updateByExampleSelective(updateHouseBidding, updateExample);
				
				AdminFunBuildingBidding adminFunBuildingBidding = new AdminFunBuildingBidding();
				adminFunBuildingBidding.setUaType(Byte.valueOf(priceInfo.get("UA_TYPE")));
				adminFunBuildingBidding.setCompPrice(new BigDecimal(NumberHelper.add(historyBiddMoneyCompPrice, Double.parseDouble(priceInfo.get("COMP_PRICE")))));
				adminFunBuildingBidding.setCompCoin(new BigDecimal(NumberHelper.add(historyBiddMoneyCompCoin, Double.parseDouble(priceInfo.get("COMP_COIN")))));
				adminFunBuildingBidding.setPersonalPrice(new BigDecimal(NumberHelper.add(historyBiddMoneyPersonalPrice, Double.parseDouble(priceInfo.get("PERSONAL_PRICE")))));
				adminFunBuildingBidding.setPersonalCoin(new BigDecimal(NumberHelper.add(historyBiddMoneyPersonalCoin, Double.parseDouble(priceInfo.get("PERSONAL_COIN")))));
				adminFunBuildingBidding.setQqStatus((byte)0);
				adminFunBuildingBidding.setHaofangStatus((byte)0);
				if("1".equals(getOperator().getSUPER_USER())){
					BigDecimal nowPrice = new BigDecimal(Math.ceil((newbiddMoney - historySortPrice)/2));
					adminFunBuildingBidding.setPrice(nowPrice.stripTrailingZeros());
				}else{
					adminFunBuildingBidding.setPrice(new BigDecimal(biddPrice));
				}
				adminFunBuildingBidding.setSortPrice(new BigDecimal(biddPrice));
				if(!selfExitse){//当前用户没有参与过续期
					adminFunBuildingBidding.setBeginTime(startDate);
					adminFunBuildingBidding.setEndTime(endDate);
					adminFunBuildingBidding.setBuildId(buildId);
					adminFunBuildingBidding.setBuildName(buildName);
					this.publicPoValue(adminFunBuildingBidding);
					//否则提交操作
					adminFunBuildingBiddingMapper.insertSelective(adminFunBuildingBidding);
				}else{
					//存在则更0新
					AdminFunBuildingBiddingExample updateBiddingExample = new AdminFunBuildingBiddingExample();
					updateBiddingExample.createCriteria().andBiddingIdEqualTo(Integer.valueOf(selfBiddId)).andCityIdEqualTo(cityId);
					AdminFunBuildingBidding updateBidding = new AdminFunBuildingBidding();
					updateBidding.setIsTop((byte)1);//是第一名
					updateBidding.setPayFlag((byte)0);// 默认设置没有扣费 -- 这个值需要注意
					updateBidding.setUpdateTime(new Date());
//					updateBidding.setExtCode400("null");
					adminFunBuildingBiddingMapper.updateByExampleSelective(updateBidding, updateBiddingExample);
					
				}
				
				//不是本人预约的下一期--需要返还之前人的余额
				//***********没有移植完成**************
				if(!archiveId.equals(getOperator().getArchiveId().toString())){
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByArchiveId(cityId, Integer.valueOf(archiveId));//不是本人的话需要告知对方你的小区竞价已被超越
					String msgContent = "[ 竞价提示 ]尊敬的经纪人，您在" + DateTimeHelper.formatDateTimetoString(startDate,"yyyy-MM-dd") + "竞价的楼盘/小区[ " + buildName + " ]已在" + DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm")  + "被超越。";
					if (erpFunUsers != null) {
						erpFunMsgMapper.createSystemMsg(getOperator().getCityId(), erpFunUsers.getUserId(), msgContent);
					} else {
						 logger.error("buildBidding-archiveId:"+archiveId + "在楼盘竞价被超越是发送通知信息时，获取USER_ID为空，请检查！");
					}
					//具体参考hft400Srv项目下BuildDBProcesser 类中的getBiddingFailList方法 和 updateBuildBiddReturnPrice方法 -- 可以问谢总
					//预约竞价退费 -- 取消ERP中的扣费退还，统一由服务程序退费
					//funUserAccountService.updateBuildBiddReturnPrice(historybiddPo);这里取消通过ERP来扣费 陈文超写
					//更新被挤掉的用户竞价数据的排名
					AdminFunBuildingBiddingExample updateBiddingExample2 = new AdminFunBuildingBiddingExample();
					updateBiddingExample2.createCriteria().andBiddingIdEqualTo(historybiddPo.getBiddingId()).andCityIdEqualTo(cityId);
					AdminFunBuildingBidding updateBidding2 = new AdminFunBuildingBidding();
					updateBidding2.setIsTop((byte)0);
					updateBidding2.setPayFlag((byte)0);
					updateBidding2.setUpdateTime(new Date());
					adminFunBuildingBiddingMapper.updateByExampleSelective(updateBidding2, updateBiddingExample2);
				}
			} else {
				throw new BusinessException(Constants_DIC.TEXT_BIDD_BEYOND_OLD_PRICE.replaceAll("#PRICE#",NumberHelper.formatNumber(historySortPrice, NumberHelper.NUMBER_IN_1)));// 新出的价格没有大于历史出价，不能执行
			}
		} else {
			Map<String,String> priceInfo = adminFunUserAccountService.updateBuildBiddPrice(operatorMap,getOperator().isPersonalVersion(),newbiddMoney,0,"BUILD");
			// 更新已经过期的竞价数据状态
			AdminFunHouseBiddingExample updateExample = new AdminFunHouseBiddingExample();
			updateExample.createCriteria().andArchiveIdEqualTo(getOperator().getArchiveId()).andCityIdEqualTo(cityId)
					.andBiddingEndTimeLessThan(new Date());
			AdminFunHouseBidding updateHouseBidding = new AdminFunHouseBidding();
			updateHouseBidding.setHaofangStatus((byte)0);
			updateHouseBidding.setQqStatus((byte)0);
			adminFunHouseBiddingMapper.updateByExampleSelective(updateHouseBidding, updateExample);
			
			AdminFunBuildingBidding adminFunBuildingBidding = new AdminFunBuildingBidding();
			adminFunBuildingBidding.setUaType(Byte.valueOf(priceInfo.get("UA_TYPE")));
			adminFunBuildingBidding.setCompPrice(new BigDecimal(priceInfo.get("COMP_PRICE")));
			adminFunBuildingBidding.setCompCoin(new BigDecimal(priceInfo.get("COMP_COIN")));
			adminFunBuildingBidding.setPersonalPrice(new BigDecimal(priceInfo.get("PERSONAL_PRICE")));
			adminFunBuildingBidding.setPersonalCoin(new BigDecimal(priceInfo.get("PERSONAL_COIN")));
			adminFunBuildingBidding.setQqStatus((byte)0);
			adminFunBuildingBidding.setHaofangStatus((byte)0);
			adminFunBuildingBidding.setBeginTime(startDate);
			adminFunBuildingBidding.setEndTime(endDate);
			adminFunBuildingBidding.setBuildId(buildId);
			adminFunBuildingBidding.setBuildName(buildName);
			if("1".equals(getOperator().getSUPER_USER())){
				BigDecimal nowPrice = new BigDecimal(Math.ceil((newbiddMoney)/2));
				adminFunBuildingBidding.setPrice(nowPrice.stripTrailingZeros());
			}else{
				adminFunBuildingBidding.setPrice(new BigDecimal(biddPrice));
			}
			adminFunBuildingBidding.setSortPrice(new BigDecimal(biddPrice));
			//否则提交操作
			this.publicPoValue(adminFunBuildingBidding);
			adminFunBuildingBiddingMapper.insertSelective(adminFunBuildingBidding);
		}
		return selfBiddId;
	}

	/**
	 * 楼盘没有人参与竞价,直接竞价成功 
	 * 当前楼盘没有人参与竞价，用户可以直接竞价并直接成为小区专家--扣费统一通过服务来扣
	 * true:是第一次小区没有人竞价的直接竞价成功
	 * false:就是预约下一期，存在两种情况：1、自己续期，2、等待别人竞价时间结束，预约下期的
	 * @author ZangTie
	 * @since 2018年7月20日 下午2:19:48
	 * @param buildId=楼盘ID
	 * @param buildName=楼盘名称
	 * @param biddPrice=竞价金额
	 * @param sDate=开始时间
	 * @param eDate=结束时间
	 * @param resultMap key=archiveTodayFirst 1=纯精英版 0=其他版本
	 * @param vipBiddPrice=会员竞价金额
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private String createNoBodyBiddBuild(Integer buildId, String buildName, String biddPrice, Date sDate, Date eDate,
			Map<String, String> resultMap, String vipBiddPrice) throws Exception {
		Map<String, String> operatorMap = new HashMap<>();
		operatorMap.put("uaId", getOperator().getUaId().toString());
		operatorMap.put("compUaId", getOperator().getCompUaId().toString());
		operatorMap.put("cityId", getOperator().getCityId().toString());
		operatorMap.put("compId", getOperator().getCompId().toString());
		operatorMap.put("superUser", getOperator().getSUPER_USER().toString());
		operatorMap.put("archiveId", getOperator().getArchiveId().toString());
		Integer cityId = getOperator().getCityId();
		AdminFunBuildingBiddingExample adminFunBuildingBiddingExample = new AdminFunBuildingBiddingExample();
		adminFunBuildingBiddingExample.createCriteria().andBuildIdEqualTo(buildId).andCityIdEqualTo(cityId).andEndTimeGreaterThanOrEqualTo(new Date());
		int count = adminFunBuildingBiddingMapper.countByExample(adminFunBuildingBiddingExample);
		String biddId = "";
		if(count == 0){//当前时间，当前小区还没有推广
			Map<String, String> priceInfo = adminFunUserAccountService.updateBuildBiddPrice(operatorMap, getOperator().isPersonalVersion(), Double.parseDouble(biddPrice),Double.parseDouble("0"),"BUILD");
			// 更新已经过期的竞价数据状态
			AdminFunHouseBiddingExample adminFunHouseBiddingExample = new AdminFunHouseBiddingExample();
			adminFunHouseBiddingExample.createCriteria().andArchiveIdEqualTo(getOperator().getArchiveId())
				.andCityIdEqualTo(cityId).andBiddingEndTimeLessThan(new Date());
			AdminFunHouseBidding adminFunHouseBidding = new AdminFunHouseBidding();
			adminFunHouseBidding.setHaofangStatus((byte)0);
			adminFunHouseBidding.setQqStatus((byte)0);
			adminFunHouseBiddingMapper.updateByExampleSelective(adminFunHouseBidding, adminFunHouseBiddingExample);
			
			AdminFunBuildingBidding adminFunBuildingBidding = new AdminFunBuildingBidding();
			adminFunBuildingBidding.setUaType(Byte.valueOf(priceInfo.get("UA_TYPE")));
			adminFunBuildingBidding.setCompPrice(new BigDecimal(priceInfo.get("COMP_PRICE")));//公司的总共花费 优惠券加好房币
			adminFunBuildingBidding.setCompCoin(new BigDecimal(priceInfo.get("COMP_COIN")));//使用公司的好房币
			adminFunBuildingBidding.setPersonalPrice(new BigDecimal(priceInfo.get("PERSONAL_PRICE")));//个人的总共花费 优惠券加好房币
			adminFunBuildingBidding.setPersonalCoin(new BigDecimal(priceInfo.get("PERSONAL_COIN")));//个人使用的好房币
			adminFunBuildingBidding.setBeginTime(sDate);
			adminFunBuildingBidding.setEndTime(eDate);
			adminFunBuildingBidding.setBuildId(buildId);
			adminFunBuildingBidding.setBuildName(buildName);
			if("1".equals(getOperator().getSUPER_USER())){
				adminFunBuildingBidding.setPrice(new BigDecimal(vipBiddPrice));
			}else{
				adminFunBuildingBidding.setPrice(new BigDecimal(biddPrice));
			}
			adminFunBuildingBidding.setSortPrice(new BigDecimal(biddPrice));
			adminFunBuildingBidding.setQqStatus((byte)1);
			adminFunBuildingBidding.setHaofangStatus((byte)1);//默认为1,因为400服务还没扣费，但是不能不让第一个竞价的人以为没有入驻成功
			this.publicPoValue(adminFunBuildingBidding);
			adminFunBuildingBiddingMapper.insertSelective(adminFunBuildingBidding);
			biddId = adminFunBuildingBidding.getBiddingId().toString();
			// 增加夺宝币
			String addTreasureCoin = adminFunArchiveService.addTreasureCoin(getOperator().getArchiveId(), Constants_DIC.DIC_TREASURE_COIN_SOURCE_3, buildId, null, "1",getOperator().getUserId(),getOperator().getOTO_Flag()+"",getOperator().getAttribute("DEPT_FLAG").toString(), cityId,getOperator().getSUPER_USER(),getOperator().getUserRight(),getOperator().isPersonalVersion());
			resultMap.put("addTreasureCoin", addTreasureCoin);
		}
		return biddId;
	}
	
	/**
	 * 竞价信息通用值
	 * @author 陈文超
	 * @date May 5, 2015 3:16:12 PM
	 */
	private void publicPoValue(AdminFunBuildingBidding adminFunBuildingBidding){
		adminFunBuildingBidding.setUaId(getOperator().getUaId());
		adminFunBuildingBidding.setCompUaId(getOperator().getCompUaId());
		adminFunBuildingBidding.setArchiveId(getOperator().getArchiveId());
		adminFunBuildingBidding.setCityId(getOperator().getCityId());
		adminFunBuildingBidding.setIsTop((byte)1);//是第一名
		adminFunBuildingBidding.setPayFlag((byte)0);// 默认设置没有扣费 -- 这个值需要注意 统一由400服务来扣费
		adminFunBuildingBidding.setUpdateTime(new Date());
//		adminFunBuildingBidding.setExtCode400("null");
		adminFunBuildingBidding.setCreationTime(new Date());
		adminFunBuildingBidding.setBiddSource(Byte.valueOf(Constants_DIC.DIC_BIDDING_SOURCE_1));//1代表来源是ERP
	}
	
	
}

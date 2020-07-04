package com.myfun.service.business.erpdb.impl;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.extension.framework.mq.context.MqUtil;
import com.extension.framework.web.ExceptionResolver.exception.BusinessException;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.constract.vo.UserPositionAndLevelDto;
import com.myfun.erpWeb.managecenter.transaction.param.ChangeProfitInMobileParam;
import com.myfun.erpWeb.managecenter.transaction.param.DelDealProfitParam;
import com.myfun.erpWeb.managecenter.transaction.param.changeProfitParam;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunRecalculateWageInfoMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.erpdb.dto.ContractPerFormanceTypeDto;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.param.CreateOrUpdateByHandProfitParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.jms.bean.CountProfitScoreMessage;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.MapUtil;
import com.myfun.utils.StringUtil;

@Service
public class ErpFunProfitServiceImpl extends AbstractService<ErpFunProfit, ErpFunProfit> implements ErpFunProfitService {

	@Autowired
	private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	private ErpFunDealMapper erpFunDealMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunProcessAssessmentMapper erpFunProcessAssessmentMapper;
	@Autowired
	private ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
	private ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired
	private ErpLeasePeopleRelativeMapper erpLeasePeopleRelativeMapper;
	@Autowired
	private ErpFunDealRecordService erpFunDealRecordService;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	@Autowired
	private ErpFunProfitDetailMapper erpFunProfitDetailMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private AdminFunRecalculateWageInfoMapper adminFunRecalculateWageInfoMapper;
	@Autowired
	private ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpProcessFinanceService erpProcessFinanceService;
	@Autowired
	ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
	@Autowired
	ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	MqUtil mqUtil;
	@Autowired
	ErpFunProfitShareDetailMapper erpFunProfitShareDetailMapper;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunProfitMapper;
	}

	/**
	 * 获取查询
	 *
	 * @param groupby
	 * @return
	 */
	public static String getRangeQueryStr(String groupby, String areaFlag) {
		String resultStr = "";
		if ("COMP".equals(groupby)) {
			resultStr = "b.COMP_ID";
		} else if ("AREA".equals(groupby)) {
			resultStr = "b.COMP_ID,b.AREA_ID,CONCAT(b.AREA_ID,'') AS RANGE";
		} else if ("REG".equals(groupby)) {
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'') AS RANGE";
		} else if ("DEPT".equals(groupby)) {
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID) AS RANGE";
		} else if ("GROUP".equals(groupby)) {
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID) AS RANGE";
		} else if ("USER".equals(groupby)) {
			resultStr = "b.COMP_ID,b.AREA_ID,b.REG_ID,b.DEPT_ID,b.GR_ID,b.USER_ID,CONCAT(b.AREA_ID,'_',b.REG_ID,'_',b.DEPT_ID,'_',b.GR_ID,'_',b.USER_ID) AS RANGE";
		}
		if (!"1".equals(areaFlag)) {
			resultStr = resultStr.replaceAll("b.AREA_ID,'_',", "").replaceAll("b.AREA_ID,", "");
		}
		return resultStr;
	}

	/**
	 * 根据查询范围转换成对应的字段名
	 *
	 * @param groupby
	 * @return
	 */
	public static String getRange(String groupby) {
		if ("COMP".equals(groupby)) {
			return "COMP_ID";
		} else if ("AREA".equals(groupby)) {
			return "AREA_ID";
		} else if ("REG".equals(groupby)) {
			return "REG_ID";
		} else if ("DEPT".equals(groupby)) {
			return "DEPT_ID";
		} else if ("GROUP".equals(groupby)) {
			return "GR_ID";
		} else if ("USER".equals(groupby)) {
			return "USER_ID";
		}
		return "COMP_ID";
	}


	/**
	 * @Title 扣除异常量
	 * @Author lcb
	 * @Date 2018/2/2
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updatevalidProfit(Integer cityId, Integer compId, ErpProfitMessageFormParam param) {
		String ids = param.getIds();
		String[] split = ids.split(",");
		List<Integer> processAssessmentIds = new ArrayList<>();
		for (String id : split) {
			processAssessmentIds.add(StringUtil.parseInteger(id));
		}
		// 查询出关联表
		ErpFunProcessAssessmentExample erpFunProcessAssessmentExample = new ErpFunProcessAssessmentExample();
		erpFunProcessAssessmentExample.setShardCityId(cityId);
		erpFunProcessAssessmentExample.createCriteria().andIdIn(processAssessmentIds).andProcessStatusEqualTo((byte) 1).andUserIdEqualTo(param.getUserId());
		List<ErpFunProcessAssessment> erpFunProcessAssessments = erpFunProcessAssessmentMapper.selectByExample(erpFunProcessAssessmentExample);

		BigDecimal totalAmount = new BigDecimal(0);
		String profitds = "";
		for (ErpFunProcessAssessment erpFunProcessAssessment : erpFunProcessAssessments) {
			totalAmount = totalAmount.add(erpFunProcessAssessment.getWageProfitAmount());
			profitds += erpFunProcessAssessment.getProfitId() + ",";
		}
		String s = StringUtils.substringBeforeLast(profitds, ",");
		param.setProfitIds(s);
		// 先标记
		Integer resItem = erpFunProfitMapper.updateProfitValidFlag(cityId, compId, param);
		erpFunAssessmentStatisticsMapper.updateAmountById(cityId, totalAmount, param);

		return resItem;
	}

	/**
	 * @author dyh
	 * @tag 获取当年应收业绩排名
	 * @since 2018/4/10
	 */
	@Override
	public List<Map<String, Object>> getThisYearProfitTrend(Integer cityId, Integer compId, String serchRangeReal, Integer serchRangeId, String realRange, String dimension) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, 0);
		String dateTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		List<Map<String, Object>> list = erpFunProfitMapper.getThisYearProfitTrend(cityId, compId, realRange, serchRangeReal, serchRangeId, dateTime, dimension);
		return list;
	}

	/**
	 * @author 邓永洪
	 * @tag 获取最近半年业绩走势
	 * @since 2018/4/11
	 */
	@Override
	public List<Map<String, Object>> getHalfProfitTrend(Integer cityId, Integer compId, String serchRangeId, String realRange) {
		int mothOfQuery = 5;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.add(Calendar.MONTH, -mothOfQuery);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String dateTimeStr = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		List<Map<String, Object>> dataList = erpFunProfitMapper.getHalfProfitTrend(cityId, compId, serchRangeId, realRange, dateTimeStr);
		for (int i = 0; i <= mothOfQuery; i++) {
			String dateTimeTemp = DateTimeHelper.formatDateTimetoString(calendar.getTime(), "yyyy-MM");
			Map<String, Object> map = null;
			if (dataList.size() > i) {
				map = dataList.get(i);
			}
			if (map == null || !dateTimeTemp.equals(map.get("dateTime"))) {
				Map<String, Object> voInsert = new HashMap<>();
				voInsert.put("dateTime", dateTimeTemp);
				voInsert.put("profitMoney", "0");
				dataList.add(i, voInsert);
			}
			calendar.add(Calendar.MONTH, 1);
		}

		return dataList;
	}

	/**
	 * @tag 根据合同成交金额和佣金计算比例生成默认的业绩分配
	 * @author 邓永洪
	 * @since 2018/5/31
	 */
	@Transactional
	@Override
	public void createDefaultProfitForDeal(ErpFunDeal funDeal, InsertDealInfoParam param) {
		//清除合同的业绩数据
		ErpFunProfitExample profitExample = new ErpFunProfitExample();
		profitExample.setShardCityId(param.getCityId());
		profitExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andDealIdEqualTo(funDeal.getDealId());
		erpFunProfitMapper.deleteByExample(profitExample);
		//分配默认业绩
		Integer houseUserId = funDeal.getHouseUserUid();
		Integer custUserId = funDeal.getCustUserUid();
		String[] performanceTypeArr = null;
		String houseEnMsg = "";
		String custEnMsg = "";
		Integer dealType = funDeal.getDealType().intValue();
		/***判断是否玛雅房基地定制***/
		byte maYaModel = 0;
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(param.getCityId(), param.getSelfCompId());
		if(null != erpFunComp){
			if(null != erpFunComp.getCompNo()){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(null != adminFunComp){
					if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){
						maYaModel = 1;
					}
				}
			}
		}
		if(maYaModel == 1){
			this.createCustomizedProfit(param, funDeal);
		}else{
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
				houseEnMsg = "HOUSE_SALE";
				custEnMsg = "CUST_SALE";
				performanceTypeArr = new String[]{"KEY", "FANKAN", "WEITUO", "HOUSE_SALE", "CUST_SALE", "HOUSE_GUARDIAN", "HOUSE_CREATE", "YIJIA"};
			} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
				houseEnMsg = "HOUSE_LEASE";
				custEnMsg = "CUST_LEASE";
				performanceTypeArr = new String[]{"KEY", "FANKAN", "WEITUO", "HOUSE_LEASE", "CUST_LEASE", "HOUSE_GUARDIAN", "HOUSE_CREATE", "YIJIA"};
			}
			ErpFunPerformanceTypeExample performanceTypeExample = new ErpFunPerformanceTypeExample();
			performanceTypeExample.setShardCityId(param.getCityId());
			performanceTypeExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andCanDelEqualTo(0).andIsDelEqualTo((byte) 0)
			.andEnMsgIn(Arrays.asList(performanceTypeArr)).andPerformanceProportionGreaterThan(new BigDecimal(0));
			List<ErpFunPerformanceType> performanceTypeList = erpFunPerformanceTypeMapper.selectByExample(performanceTypeExample);
			
			if (!performanceTypeList.isEmpty()) {
				//是否有维护人或者登记人标记
				boolean houseFlag = false;
				List<Integer> userTypeList = new ArrayList<>();
				// 业绩类别
				Map<String, ErpFunPerformanceType> userPerformanceMap = new HashMap<>();
				// 业绩比例
				Map<String, BigDecimal> userPerformanceTypeMap = new HashMap<>();
				for (ErpFunPerformanceType performanceType : performanceTypeList) {
					String enMsg = performanceType.getEnMsg();
					//判断是有维护人或者登记人
					if ("HOUSE_GUARDIAN".equals(enMsg) || "HOUSE_CREATE".equals(enMsg)) {
						houseFlag = true;
					}
					// 不是房客源所属才去才房源相关人表
					if (!"HOUSE_SALE".equals(enMsg) && !"HOUSE_LEASE".equals(enMsg) && !"CUST_SALE".equals(enMsg) && !"CUST_LEASE".equals(enMsg)) {
						userTypeList.add(Const.PERFORMANCE_USER_RELATIVE.get(enMsg));
					}
					userPerformanceTypeMap.put(enMsg, performanceType.getPerformanceProportion());
					userPerformanceMap.put(enMsg, performanceType);
				}
				List<Map<String, Object>> performanceUserTypeList = new ArrayList<>();
				if (!userTypeList.isEmpty()) {
					if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
						ErpSalePeopleRelativeExample salePeopleRelativeExample = new ErpSalePeopleRelativeExample();
						salePeopleRelativeExample.setOrderByClause("PEOPLE_TYPE, CREATION_TIME");
						salePeopleRelativeExample.setShardCityId(param.getCityId());
						ErpSalePeopleRelativeExample.Criteria criteria = salePeopleRelativeExample.createCriteria();
						criteria.andDelFlagEqualTo(0).andPeopleTypeIn(userTypeList);
						if (funDeal.getDealHouseId() != null) {
							criteria.andSaleIdEqualTo(funDeal.getDealHouseId());
						} else {
							criteria.andSaleIdIsNull();
						}
						
						List<ErpSalePeopleRelative> erpSalePeopleRelatives = erpSalePeopleRelativeMapper.selectByExample(salePeopleRelativeExample);
						Map<Integer, List<ErpSalePeopleRelative>> salePeopleTypeMap = erpSalePeopleRelatives.stream().collect(Collectors.groupingBy(ErpSalePeopleRelative :: getPeopleType));
						Set<Entry<Integer,List<ErpSalePeopleRelative>>> entrySet = salePeopleTypeMap.entrySet();
						Iterator<Entry<Integer, List<ErpSalePeopleRelative>>> iterator = entrySet.iterator();
						Map<Integer, ErpSalePeopleRelative> resultMap = new HashMap<>();
						while(iterator.hasNext()) {
							Entry<Integer, List<ErpSalePeopleRelative>> next = iterator.next();
							Integer key = next.getKey();
							List<ErpSalePeopleRelative> value = next.getValue();
							if (value.size() > 0 && !resultMap.containsKey(key)) {
								resultMap.put(key, value.get(0));
							}
						}
						List<ErpSalePeopleRelative> resultMapList = resultMap.values().stream().collect(Collectors.toList());
						
						performanceUserTypeList = MapUtil.listObjTolistMap(resultMapList);
					} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
						ErpLeasePeopleRelativeExample leasePeopleRelativeExample = new ErpLeasePeopleRelativeExample();
						leasePeopleRelativeExample.setOrderByClause("PEOPLE_TYPE, CREATION_TIME");
						leasePeopleRelativeExample.setShardCityId(param.getCityId());
						ErpLeasePeopleRelativeExample.Criteria criteria = leasePeopleRelativeExample.createCriteria();
						criteria.andDelFlagEqualTo(0).andPeopleTypeIn(userTypeList);
						if (funDeal.getDealHouseId() != null) {
							criteria.andLeaseIdEqualTo(funDeal.getDealHouseId());
						} else {
							criteria.andLeaseIdIsNull();
						}
						
						List<ErpLeasePeopleRelative> erpLeasePeopleRelatives = erpLeasePeopleRelativeMapper.selectByExample(leasePeopleRelativeExample);
						Map<Integer, List<ErpLeasePeopleRelative>> leasePeopleTypeMap = erpLeasePeopleRelatives.stream().collect(Collectors.groupingBy(ErpLeasePeopleRelative :: getPeopleType));
						Set<Entry<Integer,List<ErpLeasePeopleRelative>>> entrySet = leasePeopleTypeMap.entrySet();
						Iterator<Entry<Integer, List<ErpLeasePeopleRelative>>> iterator = entrySet.iterator();
						Map<Integer, ErpLeasePeopleRelative> resultMap = new HashMap<>();
						while(iterator.hasNext()) {
							Entry<Integer, List<ErpLeasePeopleRelative>> next = iterator.next();
							Integer key = next.getKey();
							List<ErpLeasePeopleRelative> value = next.getValue();
							if (value.size() > 0 && !resultMap.containsKey(key)) {
								resultMap.put(key, value.get(0));
							}
						}
						List<ErpLeasePeopleRelative> resultMapList = resultMap.values().stream().collect(Collectors.toList());
						
						performanceUserTypeList = MapUtil.listObjTolistMap(resultMapList);
					}
				}
				BigDecimal ratetotalProportion = new BigDecimal(100);//总比例
				BigDecimal totalHouseProportion = new BigDecimal(0);//剩下就是客源的比例
				boolean removeHouseOwnereflag = false;
				if (!performanceUserTypeList.isEmpty()) {
					for (Map<String, Object> data : performanceUserTypeList) {
						Integer relativeUserId = (Integer) data.get("userId");
						Integer peopleType = (Integer) data.get("peopleType");
						String performanceTypeEnMsg = Const.USER_PERFORMANCE_RELATIVE.get(peopleType);
						BigDecimal proportion = userPerformanceTypeMap.get(performanceTypeEnMsg);
						// 判断是否有房源登记人或者房源录入人，且 对应的比例>0才会分配业绩，且把不分配房源所属人标志改为true
						if (houseFlag && 1 == peopleType || 2 == peopleType) {
							removeHouseOwnereflag = true;
						}
						//创建相关人业绩
						ErpFunPerformanceType performanceType = userPerformanceMap.get(performanceTypeEnMsg);
						if (performanceType != null) {
							createProfit(relativeUserId, param.getCityId(), param.getSelfCompId(), funDeal, performanceType, proportion,param.getDeptType());
							totalHouseProportion = totalHouseProportion.add(proportion);
						}
					}
					//判断是否需要为房源方分配业绩
					if (!removeHouseOwnereflag && null != houseUserId) {
						ErpFunPerformanceType performanceType = userPerformanceMap.get(houseEnMsg);
						if (performanceType != null) {
							BigDecimal proportion = userPerformanceTypeMap.get(houseEnMsg);
							createProfit(funDeal.getHouseUserUid(), param.getCityId(), param.getSelfCompId(), funDeal, performanceType, proportion,param.getDeptType());
							totalHouseProportion = totalHouseProportion.add(proportion);
						}
					}
					//剩下的比例就是客源比例
					if (!CommonUtil.isnull(custUserId)) {
						ratetotalProportion = ratetotalProportion.subtract(totalHouseProportion);
						ErpFunPerformanceType performanceType = userPerformanceMap.get(custEnMsg);
						if (performanceType != null) {
							createProfit(funDeal.getCustUserUid(), param.getCityId(), param.getSelfCompId(), funDeal, performanceType, ratetotalProportion,param.getDeptType());
						}
					}
				} else {
					//没有房客源相关人的情况下，分配房源方业绩和客源方业绩
					BigDecimal houseRateDecimal = null;
					BigDecimal custRateDecimal = null;
					if (null == houseUserId) {// 没有房源经纪人的情况
						custRateDecimal = custUserId == null ? null : new BigDecimal(100);
					} else {// 有房源经纪人的情况
						if (null == custUserId) {
							houseRateDecimal = new BigDecimal(100);
						} else {
							if (houseUserId.equals(custUserId)) {// 房客源双方都是同一个人,则给该经纪人分配100%
								custRateDecimal = new BigDecimal(100);
							} else {
								// 两边都有的情况下，先获取房源方的比例，剩下就是客源方的比例
								ErpFunPerformanceType performanceType = userPerformanceMap.get(houseEnMsg);
								if (performanceType != null) {
									houseRateDecimal = userPerformanceTypeMap.get(houseEnMsg);
								}
								BigDecimal totalBigDecimal = new BigDecimal(100);
								if (houseRateDecimal == null) {
									custRateDecimal = totalBigDecimal;
								} else {
									custRateDecimal = totalBigDecimal.subtract(houseRateDecimal);
								}
							}
						}
					}
					//判断是否为房源方分佣
					if (null != houseUserId && houseRateDecimal != null) {
						ErpFunPerformanceType performanceType = userPerformanceMap.get(houseEnMsg);
						if (performanceType != null) {
							createProfit(houseUserId, param.getCityId(), param.getSelfCompId(), funDeal, performanceType, houseRateDecimal,param.getDeptType());
						}
					}
					//判断是否为客源方分佣
					if (null != custUserId && custRateDecimal != null) {
						ErpFunPerformanceType performanceType = userPerformanceMap.get(custEnMsg);
						if (performanceType != null) {
							createProfit(custUserId, param.getCityId(), param.getSelfCompId(), funDeal, performanceType, custRateDecimal,param.getDeptType());
						}
					}
				}
			}
		}
	}

	/***
	 * 定制公司合同业绩分配
	 * @author XIONG CAI
	 * @since 2019年8月28日 下午5:07:04
	 * @param param
	 * @param funDeal
	 * Modified XXX XIONG CAI 2019年8月28日
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	private void createCustomizedProfit(InsertDealInfoParam param, ErpFunDeal funDeal){
		//分配默认业绩
		Integer dealType = funDeal.getDealType().intValue();
		Integer cityId = param.getCityId();
		Integer compId = param.getSelfCompId();
		Date nowDate = new Date();
		List<ContractPerFormanceTypeDto> perFormanceTypeDtos = new ArrayList<>();
		
		//查询公司所有业绩类别，不区分系统业绩类别，返回到VO中，VO包含业绩类别，业绩比列
		ErpFunPerformanceTypeExample performanceTypeExample = new ErpFunPerformanceTypeExample();
		ErpFunPerformanceTypeExample.Criteria criteria = performanceTypeExample.createCriteria();
		performanceTypeExample.setShardCityId(cityId);
		criteria.andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0).andPerformanceProportionGreaterThan(new BigDecimal(0)).andConfigAbleEqualTo((byte) 1);
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
			criteria.andCollectionTypeEqualTo((byte) 2);
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
			criteria.andCollectionTypeEqualTo((byte) 4);
		}
		List<ErpFunPerformanceType> performanceTypeList = erpFunPerformanceTypeMapper.selectByExample(performanceTypeExample);
		for (ErpFunPerformanceType erpFunPerformanceType : performanceTypeList) {
			ContractPerFormanceTypeDto contractPerFormanceTypeDto = new ContractPerFormanceTypeDto();
			contractPerFormanceTypeDto.setPerformanceId(erpFunPerformanceType.getPerformanceId());
			contractPerFormanceTypeDto.setPerformanceName(erpFunPerformanceType.getAlias());
			contractPerFormanceTypeDto.setSysPerformanceName(erpFunPerformanceType.getPerformanceName());
			contractPerFormanceTypeDto.setPerformanceProportion(erpFunPerformanceType.getPerformanceProportion());
			contractPerFormanceTypeDto.setEnMsg(erpFunPerformanceType.getEnMsg());
			contractPerFormanceTypeDto.setCollectionType(erpFunPerformanceType.getCollectionType());
			contractPerFormanceTypeDto.setCommissionType(erpFunPerformanceType.getCommissionType());
			perFormanceTypeDtos.add(contractPerFormanceTypeDto);
		}
		//查询出该房源的所有房源相关人员
		List<ContractPerFormanceTypeDto> addPerFormanceTypeDtos = new ArrayList<>();
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
			ErpSalePeopleRelativeExample salePeopleRelativeExample = new ErpSalePeopleRelativeExample();
			salePeopleRelativeExample.setOrderByClause("PEOPLE_TYPE, CREATION_TIME");
			salePeopleRelativeExample.setShardCityId(cityId);
			ErpSalePeopleRelativeExample.Criteria salePeopleCriteria = salePeopleRelativeExample.createCriteria();
			salePeopleCriteria.andDelFlagEqualTo(0);
			if (funDeal.getDealHouseId() != null) {
				salePeopleCriteria.andSaleIdEqualTo(funDeal.getDealHouseId());
			} else {
				salePeopleCriteria.andSaleIdIsNull();
			}
			List<ErpSalePeopleRelative> erpSalePeopleRelatives = erpSalePeopleRelativeMapper.selectByExample(salePeopleRelativeExample);
			//peopleRelativesMap = erpSalePeopleRelatives.stream().collect(Collectors.toMap(ErpFunPerformanceType::getPerformanceId, ErpFunPerformanceType->ErpFunPerformanceType));
			for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
				if("客源登记人".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getCustUserUid()) {
						formanceTypeDto.setUserId(funDeal.getCustUserUid());
					}else {
						if(null != funDeal.getDealCustomerId()) {
							ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustByCustId(cityId, funDeal.getDealCustomerId());
							if(null != erpFunBuyCustomer) {
								if(null != erpFunBuyCustomer.getUserId()) {
									formanceTypeDto.setUserId(erpFunBuyCustomer.getUserId());
								}
							}
						}
					}
				}else if("销售转介".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getIntroducerId()) {
						formanceTypeDto.setUserId(funDeal.getIntroducerId());
					}
				}else if("销售助攻".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getAdultPromotionId()) {
						formanceTypeDto.setUserId(funDeal.getAdultPromotionId());
					}
				}else {
					for (ErpSalePeopleRelative erpSalePeopleRelative : erpSalePeopleRelatives) {
						if(null != formanceTypeDto.getEnMsg()) {
							if(null != Const.PERFORMANCE_USER_RELATIVE.get(formanceTypeDto.getEnMsg()) && Const.PERFORMANCE_USER_RELATIVE.get(formanceTypeDto.getEnMsg()).equals(erpSalePeopleRelative.getPeopleType())){
								if(erpSalePeopleRelative.getPeopleType() == 5) {//判断委托的类型
									if(erpSalePeopleRelative.getEntrustType() == 0) {
										if(!"独家委托".equals(formanceTypeDto.getSysPerformanceName())) {
											continue;
										}else {
											if(null != erpSalePeopleRelative.getDueTime() && DateUtil.dateCompare(DateUtil.DateToString(erpSalePeopleRelative.getDueTime(), "yyyy-MM-dd HH:mm:ss"), DateUtil.DateToString(nowDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss") < 0) {
												continue;
											}
										}
									}
									if(erpSalePeopleRelative.getEntrustType() == 3) {
										if(!"普通委托".equals(formanceTypeDto.getSysPerformanceName())) {
											continue;
										}else {
											if(null != erpSalePeopleRelative.getDueTime() && DateUtil.dateCompare(DateUtil.DateToString(erpSalePeopleRelative.getDueTime(), "yyyy-MM-dd HH:mm:ss"), DateUtil.DateToString(nowDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss") < 0) {
												continue;
											}
										}
									}
								}
								if(formanceTypeDto.getUserId() !=null){
									ContractPerFormanceTypeDto newFormanceTypeDto = new ContractPerFormanceTypeDto();
									ConvertUtils.register(new DateConverter(null), java.util.Date.class);
									try {
										BeanUtils.copyProperties(newFormanceTypeDto, formanceTypeDto);	//PO复制
									} catch (IllegalAccessException | InvocationTargetException e) {
										throw new RuntimeException("保存合同失败");
									}    
									newFormanceTypeDto.setUserId(erpSalePeopleRelative.getUserId());
									addPerFormanceTypeDtos.add(newFormanceTypeDto);
								}else{
									formanceTypeDto.setUserId(erpSalePeopleRelative.getUserId());
								}
							}
						}
					}
				}
			}
			
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
			ErpLeasePeopleRelativeExample leasePeopleRelativeExample = new ErpLeasePeopleRelativeExample();
			leasePeopleRelativeExample.setOrderByClause("PEOPLE_TYPE, CREATION_TIME");
			leasePeopleRelativeExample.setShardCityId(cityId);
			ErpLeasePeopleRelativeExample.Criteria leasePeopleCriteria = leasePeopleRelativeExample.createCriteria();
			leasePeopleCriteria.andDelFlagEqualTo(0);
			if (funDeal.getDealHouseId() != null) {
				leasePeopleCriteria.andLeaseIdEqualTo(funDeal.getDealHouseId());
			} else {
				leasePeopleCriteria.andLeaseIdIsNull();
			}
			List<ErpLeasePeopleRelative> erpLeasePeopleRelatives = erpLeasePeopleRelativeMapper.selectByExample(leasePeopleRelativeExample);
			for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
				if("客源登记人".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getCustUserUid()) {
						formanceTypeDto.setUserId(funDeal.getCustUserUid());
					}else {
						if(null != funDeal.getDealCustomerId()) {
							ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getFunRentCustByRentId(cityId, funDeal.getDealCustomerId());
							if(null != erpFunRentCustomer) {
								if(null != erpFunRentCustomer.getUserId()) {
									formanceTypeDto.setUserId(erpFunRentCustomer.getUserId());
								}
							}
						}
					}
				}else if("销售转介".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getIntroducerId()) {
						formanceTypeDto.setUserId(funDeal.getIntroducerId());
					}
				}else if("销售助攻".equals(formanceTypeDto.getSysPerformanceName())) {
					if(null != funDeal.getAdultPromotionId()) {
						formanceTypeDto.setUserId(funDeal.getAdultPromotionId());
					}
				}else {
					for (ErpLeasePeopleRelative erpLeasePeopleRelative : erpLeasePeopleRelatives) {
						if(null != Const.PERFORMANCE_USER_RELATIVE.get(formanceTypeDto.getEnMsg()) && Const.PERFORMANCE_USER_RELATIVE.get(formanceTypeDto.getEnMsg()).equals(erpLeasePeopleRelative.getPeopleType())){
							if(erpLeasePeopleRelative.getPeopleType() == 5) {//判断委托的类型
								if(erpLeasePeopleRelative.getEntrustType() == 0) {
									if(!"独家委托".equals(formanceTypeDto.getSysPerformanceName())) {
										continue;
									}else {
										if(null != erpLeasePeopleRelative.getDueTime() && DateUtil.dateCompare(DateUtil.DateToString(erpLeasePeopleRelative.getDueTime(), "yyyy-MM-dd HH:mm:ss"), DateUtil.DateToString(nowDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss") < 0) {
											continue;
										}
									}
								}
								if(erpLeasePeopleRelative.getEntrustType() == 3) {
									if(!"普通委托".equals(formanceTypeDto.getSysPerformanceName())) {
										continue;
									}else {
										if(null != erpLeasePeopleRelative.getDueTime() && DateUtil.dateCompare(DateUtil.DateToString(erpLeasePeopleRelative.getDueTime(), "yyyy-MM-dd HH:mm:ss"), DateUtil.DateToString(nowDate, "yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss") < 0) {
											continue;
										}
									}
								}
							}
							if(formanceTypeDto.getUserId() !=null){
								ContractPerFormanceTypeDto newFormanceTypeDto = new ContractPerFormanceTypeDto();
								ConvertUtils.register(new DateConverter(null), java.util.Date.class);
								try {
									BeanUtils.copyProperties(newFormanceTypeDto, formanceTypeDto);	//PO复制，把前面的复制给后面
								} catch (IllegalAccessException | InvocationTargetException e) {
									throw new RuntimeException("保存合同失败");
								}
								newFormanceTypeDto.setUserId(erpLeasePeopleRelative.getUserId());
								addPerFormanceTypeDtos.add(newFormanceTypeDto);
							}else{
								formanceTypeDto.setUserId(erpLeasePeopleRelative.getUserId());
							}
						}
					}
				}
			}
			
		}
		/****将有相同业绩列表的房源相关人员加入VO列表****/
		for (ContractPerFormanceTypeDto addPormanceTypeDto : addPerFormanceTypeDtos) {
			perFormanceTypeDtos.add(addPormanceTypeDto);
		}
		
		//遍历循环业绩类别，同时交叉对比是否拥有对应类型的房源相关人，有则加入到VO中，没有则继续循环，直到循环完毕
		//再次遍历业绩类别列表，如果当前业绩没有业绩所属人，则查询业绩类别扩展属性表，查询是否有扩展属性（扩展属性分为两种，一种为无业绩所属时业绩转移其他人，另一种是针对委托的特殊操作）
		ErpFunPerformanceTypeExtExample erpFunPerformanceTypeExtExample = new ErpFunPerformanceTypeExtExample();
		erpFunPerformanceTypeExtExample.createCriteria().andIdDelEqualTo((byte) 0).andCompIdEqualTo(compId).andTargetPerformanceIdIsNotNull();
		erpFunPerformanceTypeExtExample.setShardCityId(cityId);
		List<ErpFunPerformanceTypeExt> erpFunPerformanceTypeExtsList = erpFunPerformanceTypeExtMapper.selectByExample(erpFunPerformanceTypeExtExample);
		byte hasSimpleWeiTuo = 0;
		byte hasDujiaWeiTuo = 0;
		if(!erpFunPerformanceTypeExtsList.isEmpty()){
			byte custCaseType = (byte) 3;
			custCaseType = Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)4 : (byte)3;
			ErpFunTrackExample erpFunTrackExample = new ErpFunTrackExample();
			erpFunTrackExample.setShardCityId(cityId);
			ErpFunTrackExample.Criteria trackCriteria = erpFunTrackExample.createCriteria();
			trackCriteria.andCompIdEqualTo(compId);
			trackCriteria.andTrackTypeEqualTo((byte) 4);
			trackCriteria.andCaseTypeEqualTo(custCaseType);
			//陈文超-添加了以下的判断，外部合作时房客源有一方的数据ID会为null
			if(funDeal.getDealCustomerId() != null){
				trackCriteria.andCaseIdEqualTo(funDeal.getDealCustomerId());
			}
			if(funDeal.getDealHouseId() != null){
				trackCriteria.andTargetIdEqualTo(funDeal.getDealHouseId());
			}
			if(funDeal.getDealHouseId() == null && funDeal.getDealCustomerId() == null){
				throw new BusinessException("房客源ID不能都为null");
			}
			trackCriteria.andTargetFlagEqualTo(true);
			erpFunTrackExample.setOrderByClause(" TRACK_ID ASC");
			/******查询首次带看跟进记录******/
			ErpFunTrack erpFunTrack = erpFunTrackMapper.selectByOneExample(erpFunTrackExample);
			for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
				if(funDeal.getDealBuyStyle() == 0 && funDeal.getDealSellStyle() == 0) {//内成交
					/***************如果房源客源均为内部成交逻辑-start*****************/
					List<String> typeList = new ArrayList<String>();
					List<String> typeNameList = new ArrayList<String>();
					typeList.add("FANKAN");
					typeList.add("KEY");
					typeList.add("WEITUO");
					typeList.add("DUJIAWEITUO");
					typeNameList.add("销售转介");
					typeNameList.add("销售助攻");
					if(typeList.contains(formanceTypeDto.getEnMsg()) || typeNameList.contains(formanceTypeDto.getPerformanceName())) {
						if(null == formanceTypeDto.getUserId()) {//没有相关人员，查询是否有带看
							if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
								for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
									if("独家委托".equals(custDto.getSysPerformanceName())){
										custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
										formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
										break;
									}
								}
							}else {
								if(null != erpFunTrack) {
									for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
										if("客源登记人".equals(custDto.getSysPerformanceName())){
											custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
											formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
											break;
										}
									}
								}else {
									formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
								}
							}
						}else {//有房源相关人员，判断是否有带看，且首次带看时间小于当前动作时间
							if(null != erpFunTrack && typeList.contains(formanceTypeDto.getEnMsg())) {
								ErpFunTrackExample funTrackExample = new ErpFunTrackExample();
								funTrackExample.setShardCityId(cityId);
								ErpFunTrackExample.Criteria trackCriteriaQuery = funTrackExample.createCriteria();
								trackCriteriaQuery.andCompIdEqualTo(compId);
								trackCriteriaQuery.andCaseTypeEqualTo(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)2 : (byte)1);
								trackCriteriaQuery.andCaseIdEqualTo(funDeal.getDealHouseId());
								trackCriteriaQuery.andTargetFlagEqualTo(true);
								trackCriteriaQuery.andCreatorUidEqualTo(formanceTypeDto.getUserId());
								funTrackExample.setOrderByClause(" TRACK_ID DESC");
								//分别查询房堪，钥匙，委托的跟进时间
								if("FANKAN".equals(formanceTypeDto.getEnMsg())) {
									trackCriteriaQuery.andTrackTypeEqualTo((byte) 3);
								}else if("KEY".equals(formanceTypeDto.getEnMsg())) {
									trackCriteriaQuery.andTrackTypeEqualTo((byte) 32);
								}else if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
									trackCriteriaQuery.andTrackTypeEqualTo((byte) 19);
									hasSimpleWeiTuo = 1;
								}else if("DUJIAWEITUO".equals(formanceTypeDto.getEnMsg())) {
									trackCriteriaQuery.andTrackTypeEqualTo((byte) 7);
									hasDujiaWeiTuo = 1;
								}else {
									continue;
								}
								ErpFunTrack actionTrack = erpFunTrackMapper.selectByOneExample(funTrackExample);
								if(null != actionTrack) {
									if(DateUtil.dateCompare(actionTrack.getExaminTime(), erpFunTrack.getExaminTime(), "yyyy-MM-dd HH:mm:ss") > 0) {
										for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
											if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
												for (ContractPerFormanceTypeDto dujiaPerformance : perFormanceTypeDtos) {
													if("DUJIAWEITUO".equals(dujiaPerformance.getEnMsg()) && null != dujiaPerformance.getUserId()) {
														byte caseType = Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)2 : (byte)1;
														boolean bool = this.compareWeiTuoTime(caseType,compId,funDeal.getDealHouseId(),cityId);
														if(bool) {
															BigDecimal weituoProportion = BigDecimal.ZERO;
															for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
																if("WEITUO".equals(weituoPerformance.getEnMsg())) {
																	weituoProportion = weituoPerformance.getPerformanceProportion();
																	weituoPerformance.setPerformanceProportion(BigDecimal.ZERO);
																	break;
																}
															}
															for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
																if("DUJIAWEITUO".equals(weituoPerformance.getEnMsg())) {
																	weituoPerformance.setPerformanceProportion(weituoPerformance.getPerformanceProportion().add(weituoProportion));
																	break;
																}
															}
														}
														break;
													}
												}
											}else {
												if("客源登记人".equals(custDto.getSysPerformanceName())){
													custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
													formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
													break;
												}
											}
										}
									}
								}
							}else {
								if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
									for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
										if("DUJIAWEITUO".equals(custDto.getEnMsg()) && null != custDto.getUserId()) {
											byte caseType = Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)2 : (byte)1;
											boolean bool = this.compareWeiTuoTime(caseType,compId,funDeal.getDealHouseId(),cityId);
											if(bool) {
												BigDecimal weituoProportion = BigDecimal.ZERO;
												for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
													if("WEITUO".equals(weituoPerformance.getEnMsg())) {
														weituoProportion = weituoPerformance.getPerformanceProportion();
														weituoPerformance.setPerformanceProportion(BigDecimal.ZERO);
													}
												}
												for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
													if("DUJIAWEITUO".equals(weituoPerformance.getEnMsg())) {
														weituoPerformance.setPerformanceProportion(weituoPerformance.getPerformanceProportion().add(weituoProportion));
													}
												}
											}
											break;
										}
									}
								}
							}
						}
					}else {
						for (ErpFunPerformanceTypeExt erpFunPerformanceTypeExt : erpFunPerformanceTypeExtsList) {
							//1.无归属人时归属其他人
							if(erpFunPerformanceTypeExt.getExtType() == 1){
								if(null == formanceTypeDto.getUserId() &&  erpFunPerformanceTypeExt.getPerformanceId().equals(formanceTypeDto.getPerformanceId())){
									if(null != erpFunPerformanceTypeExt && null != erpFunPerformanceTypeExt.getExtType() && null != erpFunPerformanceTypeExt.getTargetPerformanceId()){
										for (ContractPerFormanceTypeDto formanceTypeDto2 : perFormanceTypeDtos) {
											if(erpFunPerformanceTypeExt.getTargetPerformanceId().equals(formanceTypeDto2.getPerformanceId())){
												formanceTypeDto2.setPerformanceProportion(formanceTypeDto2.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
												formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
											}
										}
									}
								}
							}
						}
					}
					/***************如果房源客源均为内部成交逻辑-end*****************/
				}else {
					/***************如果房源或客源为外部成交逻辑-start*****************/
					if(formanceTypeDto.getCollectionType() == 2 || formanceTypeDto.getCollectionType() == 4) {
						if(funDeal.getDealBuyStyle() == 1 && funDeal.getDealSellStyle() == 0) {//外成交(房源内部，客源外部)
							List<String> performanceName = new ArrayList<String>();
							performanceName.add("房源房勘人");
							performanceName.add("钥匙提交人");
							performanceName.add("普通委托");
							performanceName.add("独家委托");
							if(formanceTypeDto.getCommissionType() == 1) {
								if(null == formanceTypeDto.getUserId() && performanceName.contains(formanceTypeDto.getSysPerformanceName())) {//没有相关人员，查询是否有带看
									if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
										for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
											if("独家委托".equals(custDto.getSysPerformanceName())){
												custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
												formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
												break;
											}
										}
									}else {
										for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
											if("房源维护人".equals(custDto.getSysPerformanceName())){
												custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
												formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
												break;
											}
										}
									}
								}else{
									if("WEITUO".equals(formanceTypeDto.getEnMsg())) {
										for (ContractPerFormanceTypeDto dujiaPerformance : perFormanceTypeDtos) {
											if("DUJIAWEITUO".equals(dujiaPerformance.getEnMsg()) && null != dujiaPerformance.getUserId()) {
												byte caseType = Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)2 : (byte)1;
												boolean bool = this.compareWeiTuoTime(caseType,compId,funDeal.getDealHouseId(),cityId);
												if(bool) {
													BigDecimal weituoProportion = BigDecimal.ZERO;
													for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
														if("WEITUO".equals(weituoPerformance.getEnMsg())) {
															weituoProportion = weituoPerformance.getPerformanceProportion();
															weituoPerformance.setPerformanceProportion(BigDecimal.ZERO);
															break;
														}
													}
													for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
														if("DUJIAWEITUO".equals(weituoPerformance.getEnMsg())) {
															weituoPerformance.setPerformanceProportion(weituoPerformance.getPerformanceProportion().add(weituoProportion));
															break;
														}
													}
												}
												break;
											}
										}
									}
								}
							}else {
								formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
							}
						}
						if(funDeal.getDealBuyStyle() == 0 && funDeal.getDealSellStyle() == 1) {//外成交(客源内部，房源外部)
							List<String> performanceName = new ArrayList<String>();
							performanceName.add("销售转介");
							performanceName.add("销售助攻");
							if(formanceTypeDto.getCommissionType() == 2) {
								if(null == formanceTypeDto.getUserId() && performanceName.contains(formanceTypeDto.getSysPerformanceName())) {//没有相关人员，查询是否有带看
									ErpFunTrackExample outTrackExample = new ErpFunTrackExample();
									outTrackExample.setShardCityId(cityId);
									ErpFunTrackExample.Criteria outTrackCriteria = outTrackExample.createCriteria();
									outTrackCriteria.andCompIdEqualTo(compId);
									outTrackCriteria.andTrackTypeEqualTo((byte) 4);
									outTrackCriteria.andCaseTypeEqualTo(custCaseType);
									trackCriteria.andCaseIdEqualTo(funDeal.getDealCustomerId());
									trackCriteria.andTargetIdIsNull();
									trackCriteria.andTargetFlagEqualTo(true);
									outTrackExample.setOrderByClause(" TRACK_ID ASC");
									/******查询成交客户是否有外部带看记录******/
									ErpFunTrack outTrack = erpFunTrackMapper.selectByOneExample(erpFunTrackExample);
									
									if(null != outTrack) {
										for (ContractPerFormanceTypeDto custDto : perFormanceTypeDtos) {
											if("客源登记人".equals(custDto.getSysPerformanceName())){
												custDto.setPerformanceProportion(custDto.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
												formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
												break;
											}
										}
									}else{
										formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
									}
								}
							}else {
								formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
							}
						}
					}else {
						for (ErpFunPerformanceTypeExt erpFunPerformanceTypeExt : erpFunPerformanceTypeExtsList) {
							//1.无归属人时归属其他人
							if(erpFunPerformanceTypeExt.getExtType() == 1){
								if(null == formanceTypeDto.getUserId() &&  erpFunPerformanceTypeExt.getPerformanceId().equals(formanceTypeDto.getPerformanceId())){
									if(null != erpFunPerformanceTypeExt && null != erpFunPerformanceTypeExt.getExtType() && null != erpFunPerformanceTypeExt.getTargetPerformanceId()){
										for (ContractPerFormanceTypeDto formanceTypeDto2 : perFormanceTypeDtos) {
											if(erpFunPerformanceTypeExt.getTargetPerformanceId().equals(formanceTypeDto2.getPerformanceId())){
												formanceTypeDto2.setPerformanceProportion(formanceTypeDto2.getPerformanceProportion().add(formanceTypeDto.getPerformanceProportion()));
												formanceTypeDto.setPerformanceProportion(new BigDecimal(0));
											}
										}
									}
								}
							}
						}
					}
					/***************如果房源或客源为外部成交逻辑-end*****************/
				}
			}
			
			if(hasSimpleWeiTuo == 1 && hasDujiaWeiTuo == 1) {
				byte caseType = Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType) ? (byte)2 : (byte)1;
				boolean bool = this.compareWeiTuoTime(caseType,compId,funDeal.getDealHouseId(),cityId);
				if(bool) {
					BigDecimal weituoProportion = BigDecimal.ZERO;
					for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
						if("WEITUO".equals(weituoPerformance.getEnMsg())) {
							weituoProportion = weituoPerformance.getPerformanceProportion();
							weituoPerformance.setPerformanceProportion(BigDecimal.ZERO);
							break;
						}
					}
					for (ContractPerFormanceTypeDto weituoPerformance : perFormanceTypeDtos) {
						if("DUJIAWEITUO".equals(weituoPerformance.getEnMsg())) {
							weituoPerformance.setPerformanceProportion(weituoPerformance.getPerformanceProportion().add(weituoProportion));
							break;
						}
					}
				}
			}
		}
		
		//将相同人员业绩类型的数据的拆佣比列进行平分
		List<Integer> processedList = new ArrayList<>();
		for (ContractPerFormanceTypeDto contractPerFormanceTypeDto : perFormanceTypeDtos) {
			int repeat = 0;
			/***计算有多少个相同业绩类别的人员***/
			for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
				if(contractPerFormanceTypeDto.getPerformanceId().equals(formanceTypeDto.getPerformanceId())){
					repeat ++;
				}
			}
			/****将相同人员业绩类型的数据的拆佣比列进行平分****/
			if(repeat > 1 && !processedList.contains(contractPerFormanceTypeDto.getPerformanceId())){
				processedList.add(contractPerFormanceTypeDto.getPerformanceId());
				BigDecimal newProportion = contractPerFormanceTypeDto.getPerformanceProportion().divide(new BigDecimal(repeat), 2, BigDecimal.ROUND_UNNECESSARY);
				for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
					if(contractPerFormanceTypeDto.getPerformanceId().equals(formanceTypeDto.getPerformanceId())){
						formanceTypeDto.setPerformanceProportion(newProportion);
					}
				}
			}
		}
		//循环遍历完成，并将所有业绩比列计算完成之后，循环VO列表，逐一插入业绩表，此时可能存在没有业绩归属人的业绩记录
		for (ContractPerFormanceTypeDto formanceTypeDto : perFormanceTypeDtos) {
			//@BY XIONG CAI 2019-11-12 应甲方爸爸要求，如果房客源为外成交，则将相关人员的分成比例翻倍，如果比例超出100%，一切后果由甲方爸爸负责
			if(funDeal.getDealBuyStyle() != 0 || funDeal.getDealSellStyle() != 0) {
				formanceTypeDto.setPerformanceProportion(formanceTypeDto.getPerformanceProportion().multiply(new BigDecimal(2)));
			}
			this.addCustomizedProfit(formanceTypeDto.getUserId(), cityId, compId, funDeal, formanceTypeDto, formanceTypeDto.getPerformanceProportion(),param.getDeptType());
		}
		
		/*String compPerformanceProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
		compPerformanceProportion = StringUtil.isEmpty(compPerformanceProportion) ? "0" : compPerformanceProportion;*/
		/*String compPerformanceProportion = "0";
		BigDecimal compReceivableMoney = new BigDecimal(new DecimalFormat("0.##").format(funDeal.getTotalNeedPerformance().doubleValue() * (StringUtil.parseDouble(compPerformanceProportion) / 100)));
		ErpFunProfit insertModel = new ErpFunProfit();
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
			insertModel.setPerformanceType((byte) 2);//二手佣金
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
			insertModel.setPerformanceType((byte) 4);//租赁佣金
		}
		insertModel.setCompId(compId);
		insertModel.setDiscount(new BigDecimal(100));//默认折扣比例100%
		insertModel.setDealId(funDeal.getDealId());
		insertModel.setAgreementNo(funDeal.getAgreementNo());
		insertModel.setProfitProportion(new BigDecimal(compPerformanceProportion));
		insertModel.setReceivableMoney(compReceivableMoney);
		//单门店，应收 =  实收
		if (param.getDeptType() == 6) {
			insertModel.setProfitMoney(compReceivableMoney);
		} else {
			insertModel.setProfitMoney(new BigDecimal(0));
		}
		insertModel.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
		insertModel.setDealType(funDeal.getDealType());
		insertModel.setCreateDate(new Date());
		insertModel.setPerformanceName("公司平台收费");
		insertModel.setShardCityId(param.getCityId());
		insertModel.setProfitType((byte) 1);
		erpFunProfitMapper.insertSelective(insertModel);*/
	}

	/***
	 * 判断独家委托时间是否在普通委托时间之前
	 * @author XIONG CAI
	 * @since 2019年9月28日 下午3:24:55
	 * @param caseType
	 * @param compId
	 * @param dealHouseId
	 * @param cityId
	 * @return
	 * Modified XXX XIONG CAI 2019年9月28日
	 */
	private boolean compareWeiTuoTime(byte caseType, Integer compId, Integer dealHouseId, Integer cityId) {
		ErpFunTrackExample simpleWeiTuoExample = new ErpFunTrackExample();
		simpleWeiTuoExample.setShardCityId(cityId);
		simpleWeiTuoExample.createCriteria().andCompIdEqualTo(compId).andCaseTypeEqualTo(caseType).andCaseIdEqualTo(dealHouseId).andTargetFlagEqualTo(true).andTrackTypeEqualTo((byte) 19);
		simpleWeiTuoExample.setOrderByClause(" TRACK_ID DESC");
		ErpFunTrack simpleWeiTuoTrack = erpFunTrackMapper.selectByOneExample(simpleWeiTuoExample);
		ErpFunTrackExample djWeiTuoExample = new ErpFunTrackExample();
		djWeiTuoExample.setShardCityId(cityId);
		djWeiTuoExample.createCriteria().andCompIdEqualTo(compId).andCaseTypeEqualTo(caseType).andCaseIdEqualTo(dealHouseId).andTargetFlagEqualTo(true).andTrackTypeEqualTo((byte) 7);
		djWeiTuoExample.setOrderByClause(" TRACK_ID DESC");
		ErpFunTrack djWeiTuoTrack = erpFunTrackMapper.selectByOneExample(djWeiTuoExample);
		if(null != djWeiTuoTrack && null != simpleWeiTuoTrack) {
			if(DateUtil.dateCompare(djWeiTuoTrack.getExaminTime(), simpleWeiTuoTrack.getExaminTime(), "yyyy-MM-dd HH:mm:ss") < 0) {
				return true;
			}
		}
		return false;
	}

	/****
	 * 房基地定制创建业绩
	 * @author XIONG CAI
	 * @since 2019年8月29日 下午4:40:33
	 * @param relativeUserId
	 * @param cityId
	 * @param compId
	 * @param funDeal
	 * @param formanceTypeDto
	 * @param performanceProportion
	 * @param deptType
	 * Modified XXX XIONG CAI 2019年8月29日
	 */
	private void addCustomizedProfit(Integer relativeUserId, Integer cityId, Integer compId, ErpFunDeal funDeal,
			ContractPerFormanceTypeDto formanceTypeDto, BigDecimal performanceProportion, Byte deptType) {
		/*String compPerformanceProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
		compPerformanceProportion = StringUtil.isEmpty(compPerformanceProportion) ? "0" : compPerformanceProportion;*/
		String compPerformanceProportion = "0";
		BigDecimal compReceivableMoney = new BigDecimal(new DecimalFormat("0.##").format(funDeal.getTotalNeedPerformance().doubleValue() * (StringUtil.parseDouble(compPerformanceProportion) / 100)));
		Integer dealType = funDeal.getDealType().intValue();
		ErpFunProfit insertModel = new ErpFunProfit();
		UserPositionAndLevelDto userPositionAndLevelDto = erpFunUsersMapper.getUserPositionAndLevelDtoByUserId(cityId, relativeUserId);
		insertModel.setCompId(compId);
		if (userPositionAndLevelDto != null) {
			insertModel.setArchiveId(userPositionAndLevelDto.getArchiveId());
			insertModel.setDeptId(userPositionAndLevelDto.getDeptId());
			insertModel.setAreaId(userPositionAndLevelDto.getAreaId());
			insertModel.setRegId(userPositionAndLevelDto.getRegId());
			insertModel.setGrId(userPositionAndLevelDto.getGrId());
			insertModel.setLevelsId(userPositionAndLevelDto.getLevelsId());
			insertModel.setLevelsName(userPositionAndLevelDto.getLevelsName());
			insertModel.setRoleId(userPositionAndLevelDto.getRoleId());
			insertModel.setRoleName(userPositionAndLevelDto.getRoleName());
		}else {
			insertModel.setProfitType((byte) 2);
		}
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
			insertModel.setPerformanceType((byte) 2);//二手佣金
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
			insertModel.setPerformanceType((byte) 4);//租赁佣金
		}
		insertModel.setDiscount(new BigDecimal(100));//默认折扣比例100%
		insertModel.setUserId(relativeUserId);
		insertModel.setDealId(funDeal.getDealId());
		insertModel.setAgreementNo(funDeal.getAgreementNo());
		insertModel.setProfitProportion(performanceProportion);
		BigDecimal receivableMoney = new BigDecimal(new DecimalFormat("0.##").format(funDeal.getTotalNeedPerformance().subtract(compReceivableMoney).doubleValue() * (performanceProportion.doubleValue() / 100)));
		insertModel.setReceivableMoney(receivableMoney);
		//单门店，应收 =  实收
		if (deptType == 6) {
			insertModel.setProfitMoney(receivableMoney);
		} else {
			insertModel.setProfitMoney(new BigDecimal(0));
		}
		insertModel.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
		insertModel.setDealType(funDeal.getDealType());
		insertModel.setCreateDate(new Date());
		insertModel.setPerformanceId(formanceTypeDto.getPerformanceId());
		insertModel.setPerformanceName(formanceTypeDto.getPerformanceName());
		insertModel.setShardCityId(cityId);
		erpFunProfitMapper.insertSelective(insertModel);//房基地不用埋点组织架构
	}

	@Override
	public void countProfitStandard(Integer cityId, Integer compId, String archiveIds) {
		try {
			if (StringUtils.isBlank(archiveIds)) {
				return;
			}
//			Map<String, Object> content = new HashMap<>();
//			content.put("cityId", cityId);
//			content.put("compId", compId);
//			content.put("archiveIds", archiveIds);
//			AdminJmsMessage jmsMessage = endJmsMsg(JmsMsgAction.COUNT_PROFIT_SCORE, cityId, Constants_DIC.DIC_JMS_SEND_PRODUCER_5, content, 10);
//			// 发送消息给JMS服务器，发送失败不回滚插入的数据
//			JmsPublisher.sendMessage(jmsMessage);
			CountProfitScoreMessage message = new CountProfitScoreMessage();
			message.setCityId(cityId);
			message.setCompId(compId);
			message.setArchiveIds(archiveIds);
			message.setQueneName(JmsMsgAction.COUNT_PROFIT_SCORE);
			mqUtil.sendMessage(message);
		} catch (Exception e) {
			ThreadLocalHelper.addErrorInfoLocal("\nJMS错误：业务逻辑未出错，输出方便调试\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	private void createProfit(Integer relativeUserId, Integer cityId, Integer compId, ErpFunDeal funDeal, ErpFunPerformanceType performanceType, BigDecimal proportion,Byte deptType) {
		Integer dealType = funDeal.getDealType().intValue();
		UserPositionAndLevelDto userPositionAndLevelDto = erpFunUsersMapper.getUserPositionAndLevelDtoByUserId(cityId, relativeUserId);
		//没有应收的时候就不创建了
		if (userPositionAndLevelDto != null && funDeal.getTotalNeedPerformance() != null) {
			ErpFunProfit insertModel = new ErpFunProfit();
			insertModel.setCompId(compId);
			insertModel.setArchiveId(userPositionAndLevelDto.getArchiveId());
			insertModel.setDeptId(userPositionAndLevelDto.getDeptId());
			insertModel.setAreaId(userPositionAndLevelDto.getAreaId());
			insertModel.setRegId(userPositionAndLevelDto.getRegId());
			insertModel.setGrId(userPositionAndLevelDto.getGrId());
			insertModel.setLevelsId(userPositionAndLevelDto.getLevelsId());
			insertModel.setLevelsName(userPositionAndLevelDto.getLevelsName());
			insertModel.setRoleId(userPositionAndLevelDto.getRoleId());
			insertModel.setRoleName(userPositionAndLevelDto.getRoleName());
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)) {
				insertModel.setPerformanceType((byte) 2);//二手佣金
			} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)) {
				insertModel.setPerformanceType((byte) 4);//租赁佣金
			}
			insertModel.setDiscount(new BigDecimal(100));//默认折扣比例100%
			insertModel.setUserId(relativeUserId);
			insertModel.setDealId(funDeal.getDealId());
			insertModel.setAgreementNo(funDeal.getAgreementNo());
			insertModel.setProfitProportion(proportion);
			BigDecimal receivableMoney = new BigDecimal(new DecimalFormat("0.##").format(funDeal.getTotalNeedPerformance().doubleValue() * (proportion.doubleValue() / 100)));
			insertModel.setReceivableMoney(receivableMoney);
			//单门店，应收 =  实收
			if (deptType == 6) {
				insertModel.setProfitMoney(receivableMoney);
			} else {
				insertModel.setProfitMoney(new BigDecimal(0));
			}
			insertModel.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
			insertModel.setDealType(funDeal.getDealType());
			insertModel.setCreateDate(new Date());
			insertModel.setPerformanceId(performanceType.getPerformanceId());
			insertModel.setPerformanceName(performanceType.getPerformanceName());
			insertModel.setShardCityId(cityId);
			//***********************组织架构改版****************************
			String inviteSharePercent = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");
			if("1".equals(inviteSharePercent) && relativeUserId != null){//新组织
				ErpFunUsers funUsers = erpFunUsersMapper.selectByUserId(cityId, relativeUserId);
				if(null != funUsers){
					insertModel.setOrganizationPath(funUsers.getTissueLine());
					insertModel.setOrg1(funUsers.getOrg1());
					insertModel.setOrg2(funUsers.getOrg2());
					insertModel.setOrg3(funUsers.getOrg3());
					insertModel.setOrg4(funUsers.getOrg4());
					insertModel.setOrg5(funUsers.getOrg5());
					insertModel.setOrg6(funUsers.getOrg6());
					insertModel.setOrg7(funUsers.getOrg7());
					insertModel.setOrg8(funUsers.getOrg8());
					insertModel.setOrg9(funUsers.getOrg9());
					insertModel.setOrg10(funUsers.getOrg10());
					insertModel.setOrg11(funUsers.getOrg11());
					insertModel.setOrg12(funUsers.getOrg12());
					insertModel.setOrg13(funUsers.getOrg13());
					insertModel.setOrg14(funUsers.getOrg14());
				}
			} else {
				erpFunProfitMapper.insertSelective(insertModel);
			}
		}
	}

	/**
	 * @tag 反结算时更新实收分配比例
	 * @author 邓永洪
	 * @since 2018/6/30
	 */
	@Transactional
	@Override
	public void updateProfitProportion(Integer cityId, Integer compId, Integer profitPercentRule, Integer dealId) {
		erpFunProfitMapper.updateProfitProportion(cityId, compId, dealId, profitPercentRule, "TRANSFER_NEED_PERFORMANCE", 1);
		erpFunProfitMapper.updateProfitProportion(cityId, compId, dealId, profitPercentRule, "SECONDHAND_NEED_PERFORMANCE", 2);
		erpFunProfitMapper.updateProfitProportion(cityId, compId, dealId, profitPercentRule, "NEWHOUSE_NEED_PERFORMANCE", 3);
		erpFunProfitMapper.updateProfitProportion(cityId, compId, dealId, profitPercentRule, "LEASE_NEED_PERFORMANCE", 4);
		erpFunProfitMapper.updateProfitProportion(cityId, compId, dealId, profitPercentRule, "FINANCE_NEED_PERFORMANCE", 5);

	}

	/**
	 * @tag 更新手动录入的业绩
	 * @author 邓永洪
	 * @since 2018/7/20
	 */
	@Transactional
	@Override
	public void updateByHandProfit(GeneralParam generalParam, CreateOrUpdateByHandProfitParam param) {
		Integer cityId = generalParam.getCityId();
		ErpFunDeal model = param;
		BigDecimal zero = new BigDecimal(0);
		if (model.getTransferNeedPerformance() == null) {
			model.setTransferNeedPerformance(zero);
		}
		if (model.getTransferRealPerformance() == null) {
			model.setTransferRealPerformance(zero);
		}
		if (model.getSecondhandNeedPerformance() == null) {
			model.setSecondhandNeedPerformance(zero);
		}
		if (model.getSecondhandRealPerformance() == null) {
			model.setSecondhandRealPerformance(zero);
		}
		if (model.getNewhouseNeedPerformance() == null) {
			model.setNewhouseNeedPerformance(zero);
		}
		if (model.getNewhouseRealPerformance() == null) {
			model.setNewhouseRealPerformance(zero);
		}
		if (model.getLeaseNeedPerformance() == null) {
			model.setLeaseNeedPerformance(zero);
		}
		if (model.getLeaseRealPerformance() == null) {
			model.setLeaseRealPerformance(zero);
		}
		if (model.getFinanceNeedPerformance() == null) {
			model.setFinanceNeedPerformance(zero);
		}
		if (model.getFinanceRealPerformance() == null) {
			model.setFinanceRealPerformance(zero);
		}
		ErpFunDeal oldModel = erpFunDealMapper.getBaseDealInfo(cityId, model.getDealId());
		model.setShardCityId(cityId);
		erpFunDealMapper.updateByPrimaryKeySelective(model);
		//清空不需要对比的值
		model.setTransferNeedPerformance(null);
		model.setTransferRealPerformance(null);
		model.setSecondhandNeedPerformance(null);
		model.setSecondhandRealPerformance(null);
		model.setNewhouseNeedPerformance(null);
		model.setNewhouseRealPerformance(null);
		model.setLeaseNeedPerformance(null);
		model.setLeaseRealPerformance(null);
		model.setFinanceNeedPerformance(null);
		model.setFinanceRealPerformance(null);
		String updateContent = model.getUpdateContent(oldModel);
		if (StringUtils.isNotBlank(updateContent)) {
			//合同更新日志
			String deptUserName = generalParam.getCurrDeptUserName();
			String trackContent = deptUserName + " 修改了非权证流程合同的信息";
			erpFunDealRecordService.writeDealRecord(generalParam, model.getDealId(), null, Const.DIC_DEAL_UPDATE_CLASSIC_DEALEDIT, (byte) 0, trackContent, 1, null, true, null);
		}
		//2.更新业绩
		changeProfitParam profitParam = new changeProfitParam();
		profitParam.setDealId(model.getDealId());
		profitParam.setProfitJson(param.getProfitJson());
		profitParam.setRemoveProfitIds(param.getRemoveProfitIds());
		this.changeProfit(generalParam, profitParam, 1);
		ErpFunProfitExample profitExample = new ErpFunProfitExample();
		profitExample.setShardCityId(cityId);
		profitExample.createCriteria().andCompIdEqualTo(generalParam.getCompId()).andDealIdEqualTo(model.getDealId());
		List<ErpFunProfit> funProfits = erpFunProfitMapper.selectByExample(profitExample);
		if (funProfits == null || funProfits.isEmpty()) {
			return;
		}
		String archiveIds = funProfits.stream().filter(val->(null != val.getArchiveId())).map(val -> val.getArchiveId() + "").collect(Collectors.joining(","));
		this.countProfitStandard(cityId, generalParam.getCompId(), archiveIds);
	}

	/**
	 * 手动录入业绩,并产生虚拟合同
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/24
	 */
	@Transactional
	@Override
	public Map<String,Object> insertMgrProfit(GeneralParam generalParam, InsertDealInfoParam param) throws Exception {
		Integer compId = generalParam.getCompId();
		Integer cityId = generalParam.getCityId();
		Integer userId = generalParam.getUserId();
		Integer compType = generalParam.getCompType();
		String userName = generalParam.getUserName();
		String deptName = generalParam.getDeptName();
		Boolean isPersonalVersion = generalParam.isPersonalVersion();
		String rentOverDate = param.getRentOverDate();

		ErpFunDeal dealPO = param;
		dealPO.setArea(null);
		Integer houseUserId = param.getHouseUserUid();
		Integer customerUserId = param.getCustUserUid();
		// 插入业绩记录
		dealPO.setDealVerifyTime(param.getDealVerifyTime());
		dealPO.setHouseUserUid(houseUserId);
		dealPO.setCustUserUid(customerUserId);
		dealPO.setCreatorUid(userId);
		dealPO.setSystemRecordTime(getTimeNow());
		dealPO.setDealAuditStatus(Const.DIC_DEAL_FIRSTCOMPLETE_OK);// 直接审核该合同
		dealPO.setCompId(compId);
		dealPO.setDealStatus(Const.DIC_DEAL_STATUS_DEALOVER);
		dealPO.setCreatorDate(getTimeNow());
		dealPO.setIsbyhand((byte) 1);// 是否手动输入业绩生成的合同
		dealPO.setDealInfoType((byte) 0);
//		dealPO.setSellAddress("手动录入业绩生成(无)");
		dealPO.setTotalNeedIncome(dealPO.getTotalNeedPerformance());
		dealPO.setTotalRealIncome(dealPO.getTotalRealPerformance());

		if (dealPO.getDealHouseId() != null) {
			String ownerName = "";
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
				ErpFunSale funSalePO = erpFunSaleMapper.getFunSaleBySaleId(cityId, dealPO.getDealHouseId());
				if (funSalePO != null) {
					dealPO.setSectionId(funSalePO.getSectionId());
					ownerName = funSalePO.getSaleOwner();
				}
			} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
				ErpFunLease funLeasePO = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, dealPO.getDealHouseId());
				if (funLeasePO != null) {
					dealPO.setSectionId(funLeasePO.getSectionId());
					ownerName = funLeasePO.getLeaseOwner();
				}
			}
			dealPO.setSellOwnerName(ownerName);
		} else if (dealPO.getBuildId() != null) {
			ErpBuildingInfo erpBuildingInfoPO = erpBuildingInfoMapper.getBuildInfoById(cityId, StringUtil.toString(dealPO.getBuildId()));
			dealPO.setSectionId(erpBuildingInfoPO.getSectionId());
		}

		if(null != dealPO.getDealCustomerId()) {
			String customerName = "";
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
				ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, dealPO.getDealCustomerId());
				if (null != buyCustomer) {
					customerName = buyCustomer.getBuyCustName();
				}
			} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
				ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.getFunRentCustByRentId(cityId, dealPO.getDealCustomerId());
				if (null != rentCustomer) {
					customerName = rentCustomer.getRentCustName();
				}
			}
			dealPO.setBuyOwnerName(customerName);
		}
//		Integer dealId = erpFunDealMapper.generateSEQID(cityId);
//		dealPO.setDealId(dealId);
		String dealTypeTmp = "S";
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
			dealTypeTmp = "S";
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
			dealTypeTmp = "R";
		}
		String houseAddress = dealPO.getHouseaddress();

		if (StringUtil.isBlank(houseAddress)) {
			houseAddress = "房源方为外部合作";
		}
		dealPO.setHouseaddress(houseAddress + "(非权证合同)");
		dealPO.setShardCityId(cityId);
		erpFunDealMapper.insertSelective(dealPO);
		Integer dealId = dealPO.getDealId();

		//合同的编号
		String dealNo = dealTypeTmp + dealId + DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyMMdd");
		erpFunDealMapper.updateAgreementNoByDealId(cityId, dealNo, dealId);

		// 创建跟进
		erpFunTrackService.writeTrackInfoToMgrProfit(cityId, param, dealPO);
		this.houseCustStatuChange(generalParam, rentOverDate, dealPO, Const.DIC_HOUSE_STATUS_INNERDEAL);
		changeProfitParam profitParam = new changeProfitParam();
		profitParam.setDealId(dealId);
		profitParam.setProfitJson(param.getProfitJson());
		this.changeProfit(generalParam, profitParam, 1);
		erpFunProfitMapper.updateByDealIdAndCompId(cityId, compId, dealId, dealPO.getDealVerifyTime(), Const.SETTLE_FLAG_CHECKED);
		List<ErpFunProfit> profitList = erpFunProfitMapper.getProfitListByDealIdAndCompId(cityId, compId, dealId, null);
		if (profitList == null || profitList.isEmpty()) {
			return null;
		}
		/***判断是否玛雅房基地定制***/
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		if(null != erpFunComp){
			if(null != erpFunComp.getCompNo()){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(null != adminFunComp){
					if(adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1){
						//ErpFunDeal erpFunDeal = erpFunDealMapper.getFunDealById(cityId, compId, dealId);
						ErpFunProfit insertModel = new ErpFunProfit();
						if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealPO.getDealType().intValue())) {
							insertModel.setPerformanceType((byte) 2);//二手佣金
						} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealPO.getDealType().intValue())) {
							insertModel.setPerformanceType((byte) 4);//租赁佣金
						}
						String compPerformanceProportion = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
			    		compPerformanceProportion = StringUtil.isEmpty(compPerformanceProportion) ? "0" : compPerformanceProportion;
						insertModel.setCompId(compId);
						insertModel.setDiscount(new BigDecimal(100));//默认折扣比例100%
						insertModel.setDealId(dealId);
						insertModel.setAgreementNo(dealPO.getAgreementNo());
						insertModel.setProfitProportion(new BigDecimal(compPerformanceProportion));
						insertModel.setReceivableMoney(dealPO.getTotalNeedPerformance().multiply(new BigDecimal(compPerformanceProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
						insertModel.setProfitMoney(dealPO.getTotalRealPerformance().multiply(new BigDecimal(compPerformanceProportion)).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP));
						insertModel.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
						insertModel.setDealType(dealPO.getDealType());
						insertModel.setCreateDate(new Date());
						insertModel.setPerformanceName("公司平台收费");
						insertModel.setShardCityId(cityId);
						insertModel.setProfitType((byte) 1);
						erpFunProfitMapper.insertSelective(insertModel);//房基地不用埋点组织架构
					}
				}
			}
		}

		String archiveIds = profitList.stream().filter(val->(null != val.getArchiveId())).map(val -> val.getArchiveId() + "").collect(Collectors.joining(","));
		countProfitStandard(cityId, compId, archiveIds);
		String dealContent = this.getCurrUserName(compType, userName, deptName, isPersonalVersion) + " 创建了该非权证流程的合同";
		erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, Const.DIC_DEAL_UPDATE_CLASSIC_DEALCREATE, (byte) 0, dealContent, 1, null, false, null);

		/**
		 * 1.判断是不是内部成交房、客源(只有内部成交房或客源才会生成财务数据)
		 * 2.创建财务数据（2条,总应收、总实收)
		 * 3.自动审核应收、实收财务数据，向jms推送消息，计算薪资(只有审核实收的时候，才会创建业绩合同流水
		 * (fun_profit_detail)和创建计算薪资的线程任务)
		 * 3.1.创建总实收的时候需要更新财务款项配置表
		 */
		Map<String,Object> result = new HashMap<>();
		List<ErpProcessFinanc> financList = new ArrayList<>();
		if ((null != dealPO.getDealSellStyle() && 0 == dealPO.getDealSellStyle()) || (null != dealPO.getDealBuyStyle() && 0 == dealPO.getDealBuyStyle())) {
			//总应收 -- 财务数据
			ErpProcessFinanc totalNeedFinanc = createNeedProcessFinanc(generalParam, dealPO, profitList, param.getPfTime());
			erpProcessFinancMapper.insertSelective(totalNeedFinanc);
			financList.add(totalNeedFinanc);

			//总实收 -- 财务数据
			ErpProcessFinanc totalRealFinanc = createRealProcessFinanc(generalParam, dealPO, profitList, param.getPfTime());
			erpProcessFinancMapper.insertSelective(totalRealFinanc);

			//更新财务款项配置
			Integer paymentId = totalRealFinanc.getPaymentId();
			ErpFunFinancPayment erpFunFinancPayment = new ErpFunFinancPayment();
			erpFunFinancPayment.setShardCityId(cityId);
			erpFunFinancPayment.setPerformanceType(totalRealFinanc.getPerformanceType());
			erpFunFinancPayment.setPaymentId(paymentId);
			erpFunFinancPaymentMapper.updateByPrimaryKeySelective(erpFunFinancPayment);
			financList.add(totalRealFinanc);

		}
		result.put("list",financList);
		result.put("dealId",dealPO.getDealId());
		return result;
	}

	/**
	 * 创建财务数据(总应收)
	 * @param generalParam 当前登陆人的一些信息
	 * @param dealPO 已生成的合同
	 * @param profitList 已插入的业绩集合
	 * @throws ParseException
	 */
	private ErpProcessFinanc  createNeedProcessFinanc(GeneralParam generalParam, ErpFunDeal dealPO, List<ErpFunProfit> profitList, String pfTime) throws Exception {
		ErpProcessFinanc totalNeesFinanc = new ErpProcessFinanc();
		totalNeesFinanc.setShardCityId(generalParam.getCityId());
		totalNeesFinanc.setCompId(generalParam.getCompId());
		totalNeesFinanc.setDealId(dealPO.getDealId());
		totalNeesFinanc.setPfName("佣金");
		//是否实付，0=应付1=实付
		totalNeesFinanc.setPfActual((byte)0);
		//付款方，1:客户2:业主
		totalNeesFinanc.setPfPayer("1");
		totalNeesFinanc.setPfGeter(Const.DIC_PFMAN_BROKER);
		//付款金额
		totalNeesFinanc.setPayAmount(dealPO.getTotalNeedPerformance() == null ? new BigDecimal("0.00") : (dealPO.getTotalNeedPerformance()));
		totalNeesFinanc.setPfDesc("手动录入业绩系统生成总应收财务");
		totalNeesFinanc.setPfTime(DateTimeHelper.parseToDate(pfTime, "yyyy-MM-dd"));
		//财务款项ID
		Integer paymentId = getDefaultProcessFinanc("佣金",generalParam.getCityId(),generalParam.getCompId());
		totalNeesFinanc.setPaymentId(paymentId);
		totalNeesFinanc.setPerformanceType(profitList.get(0).getPerformanceType());
		//折扣比例，理论上来讲这个比例应该是佣金项来计算
		totalNeesFinanc.setDiscount(new BigDecimal("100.00"));
		//审核状态
		totalNeesFinanc.setAuditStatus("1");
		//审核时间
		totalNeesFinanc.setAuditTime(new Date());
		//审核人
		totalNeesFinanc.setAuditUserName(generalParam.getUserName());
		totalNeesFinanc.setAuditUser(generalParam.getUserId() + "");
		totalNeesFinanc.setIsPrint((byte)0);
		return totalNeesFinanc;
	}
	/**
	 * 创建财务数据(总实收)
	 * @param generalParam 当前登陆人的一些信息
	 * @param dealPO 已生成的合同
	 * @param profitList 已插入的业绩集合
	 * @throws ParseException
	 */
	private ErpProcessFinanc  createRealProcessFinanc(GeneralParam generalParam, ErpFunDeal dealPO, List<ErpFunProfit> profitList, String pfTime) throws Exception {
		ErpProcessFinanc totalRealFinanc = new ErpProcessFinanc();
		totalRealFinanc.setShardCityId(generalParam.getCityId());
		totalRealFinanc.setCompId(generalParam.getCompId());
		totalRealFinanc.setDealId(dealPO.getDealId());
		totalRealFinanc.setPfName("佣金");
		//是否实付，0=应付1=实付
		totalRealFinanc.setPfActual((byte)1);
		//付款方，1:客户2:业主
		totalRealFinanc.setPfPayer("1");
		totalRealFinanc.setPfGeter(Const.DIC_PFMAN_BROKER);
		//付款金额
		//付款金额
		totalRealFinanc.setPayAmount(dealPO.getTotalRealPerformance() == null ? new BigDecimal("0.00") : (dealPO.getTotalRealPerformance()));
		totalRealFinanc.setPfDesc("手动录入业绩系统生成总实收财务");
		totalRealFinanc.setPfTime(DateTimeHelper.parseToDate(pfTime, "yyyy-MM-dd"));
		//财务款项ID
		Integer paymentId = getDefaultProcessFinanc("佣金",generalParam.getCityId(),generalParam.getCompId());
		totalRealFinanc.setPaymentId(paymentId);
		totalRealFinanc.setPerformanceType(profitList.get(0).getPerformanceType());
		//折扣比例，理论上来讲这个比例应该是佣金项来计算
		totalRealFinanc.setDiscount(new BigDecimal("100.00"));
		//审核状态
		totalRealFinanc.setAuditStatus("1");
		//审核时间
		totalRealFinanc.setAuditTime(new Date());
		//审核人
		totalRealFinanc.setAuditUserName(generalParam.getUserName());
		totalRealFinanc.setAuditUser(generalParam.getUserId() + "");
		totalRealFinanc.setIsPrint((byte)0);
		return totalRealFinanc;
	}
	/**
	 * 创建财务数据(总应收)
	 * @param generalParam 当前登陆人的一些信息
	 * @param dealPO 已生成的合同
	 * @param profitList 已插入的业绩集合
	 * @throws ParseException
	 */
	private ErpProcessFinanc  createProcessFinanc(GeneralParam generalParam,  ErpFunDeal dealPO,  List<ErpFunProfit> profitList) throws Exception {
		ErpProcessFinanc totalNeesFinanc = new ErpProcessFinanc();
		totalNeesFinanc.setShardCityId(generalParam.getCityId());
		totalNeesFinanc.setCompId(generalParam.getCompId());
		totalNeesFinanc.setDealId(dealPO.getDealId());
		totalNeesFinanc.setPfName("佣金");
		//是否实付，0=应付1=实付
		totalNeesFinanc.setPfActual((byte)0);
		//付款方，1:客户2:业主
		totalNeesFinanc.setPfPayer("1");
		//付款金额
		totalNeesFinanc.setPayAccount(dealPO.getTotalNeedPerformance() == null ? "0.00" : (dealPO.getTotalNeedPerformance() + ""));
		totalNeesFinanc.setPfDesc("手动录入业绩系统生成总应收财务");
		totalNeesFinanc.setPfTime(DateTimeHelper.parseToDate(dealPO.getDealVerifyTime(),"yyyy-MM-dd"));
		//财务款项ID
		Integer paymentId = getDefaultProcessFinanc("佣金",generalParam.getCityId(),generalParam.getCompId());
		totalNeesFinanc.setPaymentId(paymentId);
		totalNeesFinanc.setPerformanceType(profitList.get(0).getPerformanceType());
		//折扣比例，理论上来讲这个比例应该是佣金项来计算
		totalNeesFinanc.setDiscount(new BigDecimal("100.00"));
		//审核状态
		totalNeesFinanc.setAuditStatus("1");
		//审核时间
		totalNeesFinanc.setAuditTime(new Date());
		//审核人
		totalNeesFinanc.setAuditUserName(generalParam.getUserName());
		totalNeesFinanc.setAuditUser(generalParam.getUserId() + "");
		totalNeesFinanc.setIsPrint((byte)0);
		return totalNeesFinanc;
	}

	@Transactional
	@Override
	public void checkedProfitByUserId(Integer cityId, Integer compId, Integer userId,String createDate, String[] profitIds) {
		ErpFunUsers erpFunUsers=erpFunUsersMapper.getFunUserByUserId(cityId,userId);
		erpFunProfitMapper.updateByArchiveIdAndCompId(cityId,compId,erpFunUsers.getArchiveId());
		if (profitIds!=null && profitIds.length>0){
			erpFunProfitMapper.updateProfitSettleFlag(cityId,compId,erpFunUsers.getArchiveId(),createDate,profitIds);
		}
	}

	@Transactional
	@Override
	public void changeProfit(GeneralParam generalParam, changeProfitParam param, Integer type) {
		//修改业绩的方法注意房基地和标准版业绩功能的区别，目前这两种情况调用的是同一个方法-陈文超
		Integer dealId=param.getDealId();
		String profitJson=param.getProfitJson();
		Integer compId = generalParam.getCompId();
		Integer cityId = generalParam.getCityId();
		Integer compType=generalParam.getCompType();
		String userName=generalParam.getUserName();
		String deptName = generalParam.getOrganizationName();
		//被移除的业绩ID
		String removeProfitIds = param.getRemoveProfitIds();
		Boolean isPersonalVersion=generalParam.isPersonalVersion();
		Set<Integer> profitIds = new HashSet<>();
		List<Integer> deleteProfitIds = new ArrayList<>();
		if(StringUtil.isNotBlank(removeProfitIds)){
			for(String tmp : removeProfitIds.split(",")){
				//前端有分隔的问题，这里做一个后端兼容控制，错误格式例如：,188231,123219  或者 ,188231,123219, 或者188231,123219,
				if(StringUtil.isNotBlank(tmp)){
					deleteProfitIds.add(Integer.parseInt(tmp));
				}
			}
		}
		boolean isInsertProfitFlag = true;
		List<ErpFunProfit> list = JSON.parseArray(profitJson,ErpFunProfit.class);
		ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getFunDealById(cityId,compId,dealId);
		String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;
		boolean isFangJidi = adminFunCompService.judgerIsFangjidi(generalParam.getAdminCompId());
		// 要影响哪些人的薪资
		Set<Integer> influnenceUserList = new HashSet<>();
		if (type == 0){
			List<ErpFunProfit> erpFunProfitList = erpFunProfitMapper.getProfitListByDealIdAndCompId(cityId, compId, dealId, type);
			for (ErpFunProfit funProfitPO : erpFunProfitList) {
				influnenceUserList.add(funProfitPO.getUserId());
			}
		}
//		ErpSysParaKey paraKey = new ErpSysParaKey();
//		paraKey.setCompId(compId);
//		paraKey.setParamId("ORGANIZATION_TYPE");
//		paraKey.setShardCityId(cityId);
//		ErpSysPara erpSysPara =  erpSysParaMapper.selectByPrimaryKey(paraKey);

		ErpSysPara erpSysPara = erpSysParaMapper.getValueById(cityId, compId, "ORGANIZATION_TYPE");

		for (ErpFunProfit funProfitPO : list) {
			Integer userId = funProfitPO.getUserId();
			Integer profitId = funProfitPO.getProfitId();
			if(userId != null) {
				influnenceUserList.add(userId);
				//有userId的情况下标记为个人业绩，前端上传的数据，如果从没有指派人更改为有指派人时profitType没有更新为0，具体见fun_profit表说明
				funProfitPO.setProfitType(Byte.valueOf("0"));
			}else if(Optional.ofNullable(userId).orElse(0) == 0 
					&& profitId != null){
				//如果没有业绩分配人，但是有业绩ID，那么说明是业绩模板或者业绩分配人被移除的情况，需要将原有业绩数据人员置空-房基地模式
				profitIds.add(profitId);
			}
			funProfitPO.setCompId(compId);
			funProfitPO.setDealId(dealId);
			funProfitPO.setDealType(funBaseInfoDealPo.getDealType());
			funProfitPO.setShardCityId(cityId);
			if (userId != null) {
				ErpFunUsers user = erpFunUsersMapper.getFunUserByUserId(cityId,userId);
				funProfitPO.setRoleId(user.getUserPosition());
				funProfitPO.setArchiveId(user.getArchiveId());
				funProfitPO.setDeptId(user.getDeptId());
				funProfitPO.setAreaId(user.getAreaId());
				funProfitPO.setRegId(user.getRegId());
				funProfitPO.setGrId(user.getGrId());
				if (user.getOrganizationId() != null) {	//判断用户organizationId是否为空，如果不为空则为新组织架构人员
					funProfitPO.setOrganizationPath(user.getTissueLine());
					funProfitPO.setOrg1(user.getOrg1());
					funProfitPO.setOrg2(user.getOrg2());
					funProfitPO.setOrg3(user.getOrg3());
					funProfitPO.setOrg4(user.getOrg4());
					funProfitPO.setOrg5(user.getOrg5());
					funProfitPO.setOrg6(user.getOrg6());
					funProfitPO.setOrg7(user.getOrg7());
					funProfitPO.setOrg8(user.getOrg8());
					funProfitPO.setOrg9(user.getOrg9());
					funProfitPO.setOrg10(user.getOrg10());
					funProfitPO.setOrg11(user.getOrg11());
					funProfitPO.setOrg12(user.getOrg12());
					funProfitPO.setOrg13(user.getOrg13());
					funProfitPO.setOrg14(user.getOrg14());
				}
			} else if (funProfitPO.getDeptId() != null){
				ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, funProfitPO.getDeptId());
				if (erpFunOrganization != null) {
					funProfitPO.setOrganizationPath(erpFunOrganization.getOrganizationPath());
				}
				funProfitPO.setAreaId(null);
				funProfitPO.setRegId(null);
				funProfitPO.setDeptId(null);
				funProfitPO.setGrId(null);
				funProfitPO.setUserId(null);
			} else {
				funProfitPO.setAreaId(null);
				funProfitPO.setRegId(null);
				funProfitPO.setDeptId(null);
				funProfitPO.setGrId(null);
				funProfitPO.setUserId(null);
			}
			if (profitId == null) {
				funProfitPO.setCreateDate(new Date());
				if(type == 1){
					funProfitPO.setDealVerifyTime(DateTimeHelper.parseToDate(funBaseInfoDealPo.getDealVerifyTime()));
				}
				if(null == funProfitPO.getProfitMoney()) {
					funProfitPO.setProfitMoney(BigDecimal.ZERO);
				}
				if(null == funProfitPO.getReceivableMoney()) {
					funProfitPO.setReceivableMoney(BigDecimal.ZERO);
				}
				if(null == funProfitPO.getProfitProportion()) {
					funProfitPO.setProfitProportion(BigDecimal.ZERO);
				}

				// 判断performanceId 为空的情况  手机端Bug
				String performanceName = funProfitPO.getPerformanceName();
				Byte performanceType = funProfitPO.getPerformanceType();
				if(null == funProfitPO.getPerformanceId() && StringUtils.isNotBlank(performanceName)) {
					ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
					erpFunPerformanceTypeExample.setShardCityId(cityId);
					erpFunPerformanceTypeExample.setOrderByClause(" CREATE_TIME DESC ");
					erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andPerformanceNameEqualTo(performanceName).
							andCollectionTypeEqualTo(performanceType).andIsDelEqualTo((byte)0);
					ErpFunPerformanceType erpFunPerformanceType = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
					if(null != erpFunPerformanceType) {
						funProfitPO.setPerformanceId(erpFunPerformanceType.getPerformanceId());
					}
				}
				erpFunProfitMapper.insertSelective(funProfitPO);
			} else {
				isInsertProfitFlag = false;
				if(type == 1){
					funProfitPO.setDealVerifyTime(DateTimeHelper.parseToDate(funBaseInfoDealPo.getDealVerifyTime()));
				}
				if(isFangJidi){
					erpFunProfitMapper.updateByPrimaryKeySelective(funProfitPO);
				}else{
					erpFunProfitMapper.updateByPrimaryKey(funProfitPO);
				}
			}
			
			if (type == 0) {
				ErpFunProfitDetailExample profitDetailExample = new ErpFunProfitDetailExample();
				profitDetailExample.setShardCityId(cityId);
				profitDetailExample.createCriteria().andDealIdEqualTo(dealId);
				ErpFunProfitDetail erpFunProfitDetail = new ErpFunProfitDetail();
				erpFunProfitDetail.setShardCityId(cityId);
				erpFunProfitDetail.setDelFlag((byte) 1);
				erpFunProfitDetail.setDelData(DateTimeHelper.getSystemDate());
				erpFunProfitDetailMapper.updateByExampleSelective(erpFunProfitDetail, profitDetailExample);
				if (isFangJidi) {
					erpFunProfitShareDetailMapper.deleteProfitDetail(cityId, compId, dealId);
				}
			}
		}
		
		if(isFangJidi){//房基地模式特有
			if(!profitIds.isEmpty()){
				//这个方法必须在上面执行
				erpFunProfitMapper.updateProfitUserToNull(cityId, compId, dealId, profitIds);
			}
		}
		
		if(!deleteProfitIds.isEmpty()){
			ErpFunProfitExample exampleUpdate = new ErpFunProfitExample();
			exampleUpdate.setShardCityId(cityId);
			exampleUpdate.createCriteria().andCompIdEqualTo(compId).andProfitIdIn(deleteProfitIds);
			ErpFunProfit record = new ErpFunProfit();
			record.setProfitType((byte) 3);
			erpFunProfitMapper.updateByExampleSelective(record, exampleUpdate);
		}
		
		if(isFangJidi){//房基地模式特有
			//将业绩模板没有分配人的业绩数据置空
			erpFunProfitMapper.updateProfitTypeWithNoUser(cityId, compId, dealId);
		}

		String currentDeptUserName = this.getCurrUserName(compType,userName,deptName,isPersonalVersion);
		String taskSubJect = taskType + " " + currentDeptUserName+" 修改了编号"+funBaseInfoDealPo.getContractNo()+"的合同的业绩分配";
		String taskContent = currentDeptUserName+" 修改了编号"+funBaseInfoDealPo.getContractNo()+"的合同的业绩分配";
		List<ErpFunUsers> userList = null;
		if (list.size() > 0) {
			if (type == 1 && isInsertProfitFlag) {
				String processContent = this.getCurrUserName(compType,userName,deptName,isPersonalVersion) + " 创建了该业绩";
				erpFunDealRecordService.writeDealRecord(generalParam,dealId,null,Const.DIC_DEAL_UPDATE_CLASSIC_PROFITCREATE,
						(byte)2,processContent,1,null,false,null);
				return;
			}
			String trackContent = this.getCurrUserName(compType,userName,deptName,isPersonalVersion)+" 更新了业绩列表信息";
			erpFunDealRecordService.writeDealRecord(generalParam,dealId,null,Const.DIC_DEAL_UPDATE_CLASSIC_PROFITUPDATE,(byte)2,trackContent,1,null,true,null);
			if (type==0) {
				userList = erpFunUsersService.getTaskUserList(cityId,dealId, 2, compId, generalParam.getUserId());
				erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(),dealId,funBaseInfoDealPo.getContractNo(), userList, taskSubJect,  Const.DIC_TASK_TYPE_CONTRACT_REMIND, taskContent, generalParam.getUserId(), cityId, generalParam.getDeptId(),compId);
			}
		}
		
		if(type==0) {
			// 作废所有实收产生的流水信息
			//erpFunProfitDetailMapper.updateDelFagByDealId(cityId,dealId,1);
			// 写入重新计算薪资的任务
			if(influnenceUserList.size() > 0) {
				List<ErpFunUsers> usersPoList = erpFunUsersMapper.getUserListByUserIds(cityId, influnenceUserList);
				String wageAccountingDay = erpSysParaMapper.getParamValue(cityId,compId,"WAGE_ACCOUNTING_DAY");
				String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);
				for (ErpFunUsers funUsersPO : usersPoList) {
					AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
					adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
					adminFunRecalculateWageInfo.setCityId(cityId);
					adminFunRecalculateWageInfo.setCompId(compId);
					adminFunRecalculateWageInfo.setCreationTime(new Date());
					adminFunRecalculateWageInfo.setRoleId(funUsersPO.getUserPosition());
					adminFunRecalculateWageInfo.setUserId(funUsersPO.getUserId());
					if(isFangJidi){//房基地模式特有
						adminFunRecalculateWageInfo.setCustomizedType(1);
					}
					try {
						adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
						// 这里加了数据库唯一锁  所以try一下
					}catch (Exception e) {

					}
				}
			}
		}
	}

	/**
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/24
	 */
	private void houseCustStatuChange(GeneralParam generalParam,String rentOverDate,ErpFunDeal dealPO, Byte stauts) {
		Map<String,Object> fieldsHMhouse = new HashMap<>();
		Map<String,Object> fieldsHMCust = new HashMap<>();
		Integer cityId=generalParam.getCityId();
		Integer compId=generalParam.getCompId();
		Byte dealType = dealPO.getDealType();
		if(Const.DIC_HOUSE_STATUS_AVAILABLE.equals(stauts)){
			fieldsHMhouse.put("dealTime", null);
			fieldsHMCust.put("dealTime", null);
			if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealType))){
				fieldsHMhouse.put("dueTime", null);
				fieldsHMCust.put("dueTime", null);
			}
		}else if(Const.DIC_HOUSE_STATUS_INNERDEAL.equals(stauts)){
			fieldsHMhouse.put("dealTime", getTimeNow());
			fieldsHMhouse.put("updateTime", getTimeNow());
			fieldsHMCust.put("dealTime", getTimeNow());
			fieldsHMCust.put("updateTime", getTimeNow());

			Integer houseId = dealPO.getDealHouseId();
			Integer custId = dealPO.getDealCustomerId();
			Byte plateTypeHouse = null;
			Byte plateTypeCust = null;
			if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealType))){
				if(houseId!=null){
					ErpFunLease funLeasePO = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId,houseId);
					plateTypeHouse = funLeasePO.getPlateType();
					if(Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(funLeasePO.getTrueFlag())){
						fieldsHMhouse.put("trueFlag", Const.DIC_INFO_TRUE_INFO_FLAG_0);
					}
				}
				if(custId!=null){
					ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId,custId);
					if (erpFunRentCustomer!=null){
						plateTypeCust=erpFunRentCustomer.getPlateType();
					}
				}
			} else {
				if(houseId!=null){
					ErpFunSale funSalePO = erpFunSaleMapper.getFunSaleBySaleId(generalParam.getCityId(),houseId);
					plateTypeHouse = funSalePO.getPlateType();
					if(Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(funSalePO.getTrueFlag())){
						fieldsHMhouse.put("trueFlag", Const.DIC_INFO_TRUE_INFO_FLAG_0);
					}
				}
				if(custId!=null){
					ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId,custId);
					if (erpFunBuyCustomer!=null){
						plateTypeCust=erpFunBuyCustomer.getPlateType();
					}
				}
			}

			//如果是私盘制下的公盘信息转为预订、封盘、成交、等涉及到改变状态的逻辑时则将其转为该申请人的私盘 陈文超
			if(houseId!=null){
				boolean isPrivateModelCust = this.getSysRunModelIsPrivate(cityId,compId,Const.DIC_CASE_TYPE_SALE_FUN);//房源私盘制
				if(isPrivateModelCust){//注意这里的隐藏逻辑 私盘下的公盘房源信息被修改状态后信息要变成修改人的信息
					if(Const.DIC_PLATE_TYPE_SHARE.equals(StringUtil.parseInteger(plateTypeHouse))){// SHARE 表示公盘数据，PUBLIC表示抢盘数据 这里注意区分
						fieldsHMhouse.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
						fieldsHMhouse.put("grId", generalParam.getGrId());
						fieldsHMhouse.put("deptId", generalParam.getDeptId());
						fieldsHMhouse.put("regId", generalParam.getRegId());
						fieldsHMhouse.put("areaId", generalParam.getAreaId());
						fieldsHMhouse.put("userId", generalParam.getUserId());
						fieldsHMhouse.put("archiveId", generalParam.getArchiveId());
					}
				}
			}

			//如果是私盘制下的公盘信息转为预订、封盘、成交、等涉及到改变状态的逻辑时则将其转为该申请人的私盘 陈文超
			if(custId!=null){//注意这里的隐藏逻辑 私盘下的公盘客源信息被修改状态后信息要变成修改人的信息
				boolean isPrivateModelCust = this.getSysRunModelIsPrivate(cityId,compId,Const.DIC_CASE_TYPE_BUY_CUST);//客源私盘制
				if(isPrivateModelCust){//注意这里的隐藏逻辑
					if(Const.DIC_PLATE_TYPE_SHARE.equals(StringUtil.parseInteger(plateTypeCust))){// SHARE 表示公盘数据，PUBLIC表示抢盘数据 这里注意区分
						fieldsHMhouse.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
						fieldsHMhouse.put("grId", generalParam.getGrId());
						fieldsHMhouse.put("deptId", generalParam.getDeptId());
						fieldsHMhouse.put("regId", generalParam.getRegId());
						fieldsHMhouse.put("areaId", generalParam.getAreaId());
						fieldsHMhouse.put("userId", generalParam.getUserId());
						fieldsHMhouse.put("archiveId", generalParam.getArchiveId());
					}
				}
			}

			if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealType))){//租方的数据需要填写到期时间,并写入租期到期提醒
				fieldsHMhouse.put("dueTime", rentOverDate);
				fieldsHMCust.put("dueTime", rentOverDate);
			}
		}
		if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(StringUtil.parseInteger(dealType))){
			Integer houseId = dealPO.getDealHouseId();
			if(houseId!=null){
				fieldsHMhouse.put("saleStatus", stauts);
				ErpFunSale erpFunSale=BeanUtil.parseMap2Object(fieldsHMhouse,ErpFunSale.class);
				erpFunSale.setShardCityId(cityId);
				erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
			}
			Integer custId = dealPO.getDealCustomerId();
			if(custId!=null){
				fieldsHMCust.put("buyCustStatus", stauts);
				ErpFunBuyCustomer erpFunBuyCustomer=BeanUtil.parseMap2Object(fieldsHMhouse,ErpFunBuyCustomer.class);
				erpFunBuyCustomer.setShardCityId(cityId);
				erpFunBuyCustomerMapper.updateByPrimaryKeySelective(erpFunBuyCustomer);
			}
		}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealType))){
			Integer houseId = dealPO.getDealHouseId();
			if(houseId!=null){
				fieldsHMhouse.put("leaseStatus", stauts);
				ErpFunLease erpFunLease = BeanUtil.parseMap2Object(fieldsHMhouse,ErpFunLease.class);
				erpFunLease.setShardCityId(cityId);
				erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
			}
			Integer custId = dealPO.getDealCustomerId();
			if(custId!=null){
				fieldsHMCust.put("rentCustStatus", stauts);
				ErpFunRentCustomer erpFunRentCustomer=BeanUtil.parseMap2Object(fieldsHMhouse,ErpFunRentCustomer.class);
				erpFunRentCustomer.setShardCityId(cityId);
				erpFunRentCustomerMapper.updateByPrimaryKeySelective(erpFunRentCustomer);
			}
		}
	}

	/**
	 * 根据信息的租售求租求购类型判断当前系统该类型下是否是私盘运行模式,目前用于写跟进功能中
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/24
	 */
	private boolean getSysRunModelIsPrivate(Integer cityId,Integer compId,Integer caseType) {
		String sysRunModel = erpSysParaMapper.getParamValue(cityId,compId,"SYSTEM_RUN_MODEL");
		//是否是私盘模式
		boolean isPrivateModel = sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)
				|| ((caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN))
				&& sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST))//仅公客制--房源为私盘
				|| ((caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST) || caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST))
				&& sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN));//仅公房制--客源为私盘
		//如果不是私盘那么继续判断是否是公盘
		return isPrivateModel;
	}

	/**
	 * 通用的获取部门加用户名的方法
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/11
	 */
	private String getCurrUserName(Integer compType, String userName, String deptName, Boolean personalVersion) {
		// 不是纯精英版也不是专业版 才写门店名称
		if (!Constants_DIC.DIC_COMP_TYPE_2.equals(compType) && !personalVersion) {
			userName = deptName + " " + userName;
		}
		return userName;
	}

	@Override
	@Transactional
	public void m4ChangeProfit(GeneralParam generalParam, changeProfitParam param, Integer type, Integer cityId, Integer dealId) {
		this.changeProfit(generalParam,param,0);
		Map<String,Object> map=new HashMap<>();
		map.put("dealStatus",1);
		erpFunDealMapper.updateDealStatusByDealId(cityId,dealId,map);
	}

	@Transactional
	@Override
	public void delDealProfit(ErpFunProfit erpFunProfit, ErpFunProfit funProfitPO, GeneralParam generalParam, Integer dealId, String currentDeptUserName,String trackContent) {
		erpFunProfitMapper.deleteByPrimaryKey(erpFunProfit);
		if (funProfitPO == null){
			erpFunDealRecordService.writeDealRecord(generalParam,dealId, null, Const.DIC_DEAL_UPDATE_CLASSIC_PROFITDELETE, (byte)2, trackContent, 1, null, false,null);
		}
	}

	/**
	 * 获取财务款项配置的ID
	 * @param name
	 * @param cityId
	 * @param compId
	 * @return
	 */
	private Integer getDefaultProcessFinanc(String name, Integer cityId, Integer compId) {
		ErpFunFinancPaymentExample funFinancPaymentExample = new ErpFunFinancPaymentExample();
		funFinancPaymentExample.setShardCityId(cityId);
		funFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameEqualTo(name);
		ErpFunFinancPayment funFinancePayment = erpFunFinancPaymentMapper.selectByExample(funFinancPaymentExample).get(0);
		if (funFinancePayment!=null){
			return funFinancePayment.getPaymentId();
		}
		return null;
	}

	/**
	 * 重新计算员工业绩比例和公司业绩分配比例
	 */
	@Override
	public List<ErpFunProfit> generateNewProfitList(GeneralParam generalParam, ChangeProfitInMobileParam param) {
		Integer dealId = param.getDealId();
		// 前端分配业绩修改,只会传上来一条业绩数据
		List<ErpFunProfit> list = param.getProfitJson();
		if (list == null || list.size() == 0) {
			return null;
		}
		ErpFunProfit profit = list.get(0);
		Byte performanceType = profit.getPerformanceType();
		BigDecimal newAddProfitProportion = profit.getProfitProportion();

		// 员工业绩分佣比例显示规则 0 = 按照总业绩计算显示比例 1 = 按照扣除公司业绩的部分计算显示比例
		String profitPercentRule = erpSysParaMapper.getParamValue(generalParam.getCityId(), generalParam.getCompId(), "PROFIT_PERCENT_RULE");

		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(generalParam.getCityId());
		example.createCriteria().andDealIdEqualTo(dealId);
		// 合同下所有的业绩列表
		List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(example);
		// 合同下该业绩类别的业绩列表
		List<ErpFunProfit> typeProfitList = profitList.stream().filter(it -> it.getPerformanceType().equals(performanceType) && it.getProfitProportion() != null).collect(Collectors.toList());

		// 按照总业绩计算显示比例,员工和公司业绩是一个整体,员工业绩比例和公司业绩比例,在当前业绩类别下,总比例不超过100%
		if ("0".equals(profitPercentRule)) {
			BigDecimal totalProfitProportion = BigDecimal.ZERO;

			if (typeProfitList.size() > 0) {
				for (ErpFunProfit erpFunProfit : typeProfitList) {
					totalProfitProportion = totalProfitProportion.add(erpFunProfit.getProfitProportion());
				}
			}

			if (profit.getProfitId() == null) {
				// 添加业绩分配
				// 该业绩类别已有的分配比例 + 新的需要增加的业绩类别比例 > 100%
				if (totalProfitProportion.add(newAddProfitProportion).compareTo(BigDecimal.valueOf(100)) > 0) {
					throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
				}
			} else {
				// 编辑业绩类别
				// 该条业绩修改后的比例 + 除它之外的业绩类别比例 > 100%
				List<ErpFunProfit> alreadyProfitList = typeProfitList.stream()
						.filter(it -> it.getProfitId().equals(profit.getProfitId())).collect(Collectors.toList());
				if (alreadyProfitList.size() > 0) {
					ErpFunProfit alreadyProfit = alreadyProfitList.get(0);
					BigDecimal newTotalProfitProportion = totalProfitProportion.subtract(alreadyProfit.getProfitProportion()).add(newAddProfitProportion);
					if (newTotalProfitProportion.compareTo(BigDecimal.valueOf(100)) > 0) {
						throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
					}
				}

				// 移除原有那一条数据
				for (int i = 0; i < profitList.size(); i++) {
					if (profitList.get(i).getProfitId().equals(profit.getProfitId())) {
						profitList.remove(profitList.get(i));
					}
				}
			}
			// 返回业绩类别列表,调用以前的接口处理
			profitList.add(profit);
			return profitList;
		} else {
			// 按照扣除公司业绩的部分计算员工业绩比例, 在员工业绩中,该业绩类型所有比例加起来不大于100%,在公司业绩中,该业绩类型所有比例加起来不大于100%
			// 计算方式: 该业绩类型下,先扣除公司业绩比例的应收实收,剩下的应收实收再计算员工业绩

			// 员工总业绩比例
			BigDecimal userProfitProportion = BigDecimal.ZERO;
			// 公司总业绩比例
			BigDecimal compProfitProportion = BigDecimal.ZERO;
			// 应收总金额
			BigDecimal receivableMoney = BigDecimal.ZERO;
			// 实收总金额
			BigDecimal actualMoney = BigDecimal.ZERO;

			// 获取该业绩类别员工业绩总比例
			List<ErpFunProfit> userProfitList = typeProfitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 0).collect(Collectors.toList());
			// 获取该业绩类别公司业绩总比例
			List<ErpFunProfit> compProfitList = typeProfitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 1).collect(Collectors.toList());

			if (userProfitList.size() > 0) {
				for (ErpFunProfit erpFunProfit : userProfitList) {
					userProfitProportion = userProfitProportion.add(erpFunProfit.getProfitProportion());
				}
			}
			if (compProfitList.size() > 0) {
				for (ErpFunProfit erpFunProfit : compProfitList) {
					compProfitProportion = compProfitProportion.add(erpFunProfit.getProfitProportion());
				}
			}

			List<ErpProcessFinancDto> financeList = erpProcessFinancMapper.getList(generalParam.getCityId(), generalParam.getCompId(), dealId);
			List<ErpProcessFinancDto> dtoList = financeList.stream().filter(it -> it.getPerformanceType().equals(performanceType)).collect(Collectors.toList());

			if (dtoList.size() > 0) {
				// 应收总金额
				List<ErpProcessFinancDto> receivableList = dtoList.stream().filter(it -> it.getPfActual() == 0 && it.getPayAmount() != null).collect(Collectors.toList());
				// 实收总金额
				List<ErpProcessFinancDto> actualList = dtoList.stream().filter(it -> it.getPfActual() == 1 && it.getPayAmount() != null).collect(Collectors.toList());

				for (ErpProcessFinancDto erpProcessFinancDto : receivableList) {
					receivableMoney = receivableMoney.add(erpProcessFinancDto.getPayAmount());
				}
				for (ErpProcessFinancDto erpProcessFinancDto : actualList) {
					actualMoney = actualMoney.add(erpProcessFinancDto.getPayAmount());
				}
			}

			// 0=员工业绩，1=公司业绩
			Byte profitType = profit.getProfitType();

			if (profitType == 0) {
				// 添加员工业绩分配
				// 在员工业绩中,该业绩类型所有比例加起来不大于100%
				if (profit.getProfitId() == null) {
					if (userProfitProportion.add(newAddProfitProportion).compareTo(BigDecimal.valueOf(100)) > 0) {
						throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
					}
				} else {
					// 编辑员工业绩
					// 该条业绩修改后的比例 + 除它之外的业绩类别比例 > 100%
					List<ErpFunProfit> alreadyProfitList = typeProfitList.stream()
							.filter(it -> it.getProfitId().equals(profit.getProfitId())).collect(Collectors.toList());
					if (alreadyProfitList.size() > 0) {
						ErpFunProfit alreadyProfit = alreadyProfitList.get(0);
						BigDecimal newTotalProfitProportion = userProfitProportion.subtract(alreadyProfit.getProfitProportion()).add(newAddProfitProportion);
						if (newTotalProfitProportion.compareTo(BigDecimal.valueOf(100)) > 0) {
							throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
						}
					}

					// 移除原有那一条数据
					for (int i = 0; i < profitList.size(); i++) {
						if (profitList.get(i).getProfitId().equals(profit.getProfitId())) {
							profitList.remove(profitList.get(i));
						}
					}
				}

				profitList.add(profit);
				return profitList;
			} else {
				// 添加公司业绩分配
				// 在公司业绩中,该业绩类型所有比例加起来不大于100%
				if (profit.getProfitId() == null) {
					if (compProfitProportion.add(newAddProfitProportion).compareTo(BigDecimal.valueOf(100)) > 0) {
						throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
					}
					// 新的公司总业绩比例
					compProfitProportion = compProfitProportion.add(newAddProfitProportion);
				} else {
					// 编辑公司业绩分配
					// 该条业绩修改后的比例 + 除它之外的业绩类别比例 > 100%
					List<ErpFunProfit> alreadyProfitList = typeProfitList.stream()
							.filter(it -> it.getProfitId().equals(profit.getProfitId())).collect(Collectors.toList());
					if (alreadyProfitList.size() > 0) {
						ErpFunProfit alreadyProfit = alreadyProfitList.get(0);
						BigDecimal newTotalProfitProportion = compProfitProportion.subtract(alreadyProfit.getProfitProportion()).add(newAddProfitProportion);
						if (newTotalProfitProportion.compareTo(BigDecimal.valueOf(100)) > 0) {
							throw new BusinessException(getNameByPerformanceType(performanceType) + "比例不能大于100%!");
						}

						// 新的公司总业绩比例
						compProfitProportion = newTotalProfitProportion;
					}

					// 移除原有那一条数据
					for (int i = 0; i < profitList.size(); i++) {
						if (profitList.get(i).getProfitId().equals(profit.getProfitId())) {
							profitList.remove(profitList.get(i));
						}
					}
				}

				// 重新计算所有该业绩类别的应收实收
				// 公司业绩总应收
				BigDecimal compReceivableMoney = compProfitProportion.divide(BigDecimal.valueOf(100)).multiply(receivableMoney);
				// 公司业绩总实收
				BigDecimal compActualMoney = compProfitProportion.divide(BigDecimal.valueOf(100)).multiply(actualMoney);

				profitList.removeAll(userProfitList);

				for (ErpFunProfit typeProfit : userProfitList) {
					BigDecimal profitProportion = typeProfit.getProfitProportion();
					// 重新计算出该条业绩应收金额
					BigDecimal newReceivableMoney = receivableMoney.subtract(compReceivableMoney).multiply(profitProportion).divide(BigDecimal.valueOf(100));
					// 重新计算出该条业绩实收金额
					BigDecimal newActualMoney = actualMoney.subtract(compActualMoney).multiply(profitProportion).divide(BigDecimal.valueOf(100));

					typeProfit.setProfitMoney(newActualMoney);
					typeProfit.setReceivableMoney(newReceivableMoney);

					profitList.add(typeProfit);
				}
				profitList.add(profit);
				return profitList;
			}
		}
	}

	/**
	 * 删除业绩时重新计算员工业绩比例和公司业绩分配比例
	 */
	@Override
	public List<ErpFunProfit> generateNewProfitListWhenDelete(GeneralParam generalParam, DelDealProfitParam param) {
		Integer dealId = param.getDealId();
		Integer profitId = param.getProfitId();

		// 员工业绩分佣比例显示规则 0 = 按照总业绩计算显示比例 1 = 按照扣除公司业绩的部分计算显示比例
		String profitPercentRule = erpSysParaMapper.getParamValue(generalParam.getCityId(), generalParam.getCompId(), "PROFIT_PERCENT_RULE");

		ErpFunProfit erpFunProfit = new ErpFunProfit();
		erpFunProfit.setShardCityId(generalParam.getCityId());
		erpFunProfit.setProfitId(profitId);
		// 合同下需要删除的该条业绩
		ErpFunProfit profit = erpFunProfitMapper.selectByPrimaryKey(erpFunProfit);

		// 删除的那条业绩的业绩类别
		Byte performanceType = profit.getPerformanceType();

		ErpFunProfitExample example = new ErpFunProfitExample();
		example.setShardCityId(generalParam.getCityId());
		example.createCriteria().andDealIdEqualTo(dealId);
		// 合同下所有的业绩列表
		List<ErpFunProfit> profitList = erpFunProfitMapper.selectByExample(example);

		// 合同下该业绩类别的业绩列表
		List<ErpFunProfit> typeProfitList = profitList.stream()
				.filter(it -> it.getPerformanceType().equals(performanceType) && it.getProfitProportion() != null).collect(Collectors.toList());

		// 公司总业绩比例
		BigDecimal compProfitProportion = BigDecimal.ZERO;
		// 应收总金额
		BigDecimal receivableMoney = BigDecimal.ZERO;
		// 实收总金额
		BigDecimal actualMoney = BigDecimal.ZERO;

		// 该合同下员工业绩列表
		List<ErpFunProfit> userProfitList = typeProfitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 0).collect(Collectors.toList());
		// 获取该业绩类别公司业绩总比例
		List<ErpFunProfit> compProfitList = typeProfitList.stream().filter(it -> it.getProfitProportion() != null && it.getProfitType() == 1).collect(Collectors.toList());

		if (compProfitList.size() > 0) {
			for (ErpFunProfit funProfit : compProfitList) {
				compProfitProportion = compProfitProportion.add(funProfit.getProfitProportion());
			}
		}

		List<ErpProcessFinancDto> financeList = erpProcessFinancMapper.getList(generalParam.getCityId(), generalParam.getCompId(), dealId);
		List<ErpProcessFinancDto> dtoList = financeList.stream().filter(it -> it.getPerformanceType().equals(performanceType)).collect(Collectors.toList());

		if (dtoList.size() > 0) {
			// 应收总金额
			List<ErpProcessFinancDto> receivableList = dtoList.stream().filter(it -> it.getPfActual() == 0 && it.getPayAmount() != null).collect(Collectors.toList());
			// 实收总金额
			List<ErpProcessFinancDto> actualList = dtoList.stream().filter(it -> it.getPfActual() == 1 && it.getPayAmount() != null).collect(Collectors.toList());

			for (ErpProcessFinancDto erpProcessFinancDto : receivableList) {
				receivableMoney = receivableMoney.add(erpProcessFinancDto.getPayAmount());
			}
			for (ErpProcessFinancDto erpProcessFinancDto : actualList) {
				actualMoney = actualMoney.add(erpProcessFinancDto.getPayAmount());
			}
		}

		// 只有按照为扣除公司业绩的部分计算员工业绩比例的设置 + 删除公司业绩 = 才会重新计算员工业绩
		if ("1".equals(profitPercentRule)) {
			if (profit.getProfitType() == 1) {
				// 新的公司业绩总比例 = 以前的总比例 - 删除的该条的业绩的比例
				compProfitProportion = compProfitProportion.subtract(profit.getProfitProportion());
				// 新的公司业绩总实收
				BigDecimal compActualMoney = compProfitProportion.divide(BigDecimal.valueOf(100)).multiply(actualMoney);
				// 新的公司业绩总应收
				BigDecimal compReceivableMoney = compProfitProportion.divide(BigDecimal.valueOf(100)).multiply(receivableMoney);

				profitList.removeAll(userProfitList);

				for (ErpFunProfit funProfit : userProfitList) {
					BigDecimal profitProportion = funProfit.getProfitProportion();

					// 重新计算出该条业绩应收金额
					BigDecimal newReceivableMoney = receivableMoney.subtract(compReceivableMoney).multiply(profitProportion).divide(BigDecimal.valueOf(100));
					// 重新计算出该条业绩实收金额
					BigDecimal newActualMoney = actualMoney.subtract(compActualMoney).multiply(profitProportion).divide(BigDecimal.valueOf(100));

					funProfit.setProfitMoney(newActualMoney);
					funProfit.setReceivableMoney(newReceivableMoney);

					profitList.add(funProfit);
				}

				return profitList;
			}
		}

		return profitList;
	}

	private String getNameByPerformanceType(Byte performanceType) {
		String name = "";

		switch (performanceType) {
			case 1: {
				name = "过户业绩";
				break;
			}
			case 2: {
				name = "二手房佣金";
				break;
			}
			case 3: {
				name = "新房佣金";
				break;
			}
			case 4: {
				name = "租赁租金";
				break;
			}
			case 5: {
				name = "金融业绩";
				break;
			}
			case 6: {
				name = "总业绩";
				break;
			}
			case 7: {
				name = "总业绩";
				break;
			}
			default:
				break;
		}
		return name;
	}
}

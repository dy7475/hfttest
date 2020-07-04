
package com.myfun.erpWeb.managecenter.profit;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.profit.param.PerformanceAssessmentCountListParam;
import com.myfun.erpWeb.managecenter.profit.vo.PerformanceAssessmentCountListVo;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.erpdb.dto.ErpFunStatisticRateDto;
import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.reportdb.dao.ReportFunWageDetail1Mapper;
import com.myfun.repository.reportdb.po.ReportFunWageDetail1;
import com.myfun.service.business.erpdb.ErpFunProfitService;
import com.myfun.service.business.erpdb.ReportFunWageDetail1Service;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@RestController
@RequestMapping(value="/managecenter/profit")
public class SalaryAssessmentController extends BaseController{
	@Autowired ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired ErpFunProfitMapper erpFunProfitMapper;
	@Autowired ErpFunBasewageMapper erpFunBasewageMapper;
	@Autowired ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpFunRoleWageWorkcountMapper erpFunRoleWageWorkcountMapper;
	@Autowired
	ErpFunRoleWageProfitMapper erpFunRoleWageProfitMapper;
	@Autowired
	ReportFunWageDetail1Mapper reportFunWageDetail1Mapper;
	@Autowired
	ReportFunWageDetail1Service reportFunWageDetail1Service;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunProfitService erpFunProfitService;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpFunWageConfigMapper erpFunWageConfigMapper;

	/**
	 * 薪资考核统计列表
	 * @author 熊刚
	 * @since 2017年8月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getSalarySchemeList")
	public ErpResponseJson getSalarySchemeList(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		String time = param.getString("time");
		String startTime = DateUtil.getFirstDay(time);  
		String endTime = DateUtil.getLastDay(time);
		param.setString("startTime",startTime);
		param.setString("endTime",endTime);
		//查询当月有配考核薪资方案的人员信息
		List<Map<String,Object>> userSalaryTypeList = erpSalaryTypeRelativeMapper.getUserSalaryTypeList(getOperator().getCityId(),param.getMap());
		List<String> roleList = erpSalaryTypeRelativeMapper.getUserSalaryTypeRoleList(getOperator().getCityId(),param.getMap());
		Map<Integer, Map<String, Object>> userSalaryTypeMap = userSalaryTypeList.stream().collect(Collectors.toMap(map -> Integer.valueOf(String.valueOf(map.get("userId"))), val -> val));
		Map<Integer, List<Integer>> userManageMap = null;
		if (!roleList.isEmpty()) {
			ErpFunUserManageRangeExample example = new ErpFunUserManageRangeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andRoleIdIn(roleList);
			List<ErpFunUserManageRange> roleManageRangeList = erpFunUserManageRangeMapper.selectByExample(example);
			userManageMap = roleManageRangeList.stream().collect(Collectors.groupingBy(ErpFunUserManageRange::getUserId, Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toList())));
		}
		List<Integer> manageUserList = new ArrayList<Integer>();
		List<Integer> commonUserList = new ArrayList<Integer>();
		for (Map<String,Object> salaryTypeMap:userSalaryTypeList){
			Object userIdObject = salaryTypeMap.get("userId");
			if(userIdObject!=null){
				Integer userId = StringUtil.parseInteger(userIdObject, 0);
				Integer manageLevel = (Integer) salaryTypeMap.get("manageLevel");
				if (Integer.valueOf("0").equals(manageLevel)) {
					commonUserList.add(userId);
				} else if (manageLevel!=null) {
					manageUserList.add(userId);
				}
			}
		}
		Map<Integer,Map<String,Object>> userProfitMoneyMap = null;
		Map<Integer,Map<String,Object>> statisticTotleMap = null;
		if (!commonUserList.isEmpty()) {
			List<Map<String,Object>> userProfitMoneyList = erpSalaryTypeRelativeMapper.getUserProfitMoney(cityId,param.getMap(),commonUserList);
			if (!userProfitMoneyList.isEmpty()) {
				userProfitMoneyMap = userProfitMoneyList.stream().collect(Collectors.toMap(map -> Integer.valueOf(map.get("userId").toString()), val -> val));
			}
			List<Map<String,Object>> statisticTotleList = reportFunStatisticTotleMapper.getStatisticTotle(cityId, param.getMap(), commonUserList);
			if (!statisticTotleList.isEmpty()){
				statisticTotleMap = statisticTotleList.stream().collect(Collectors.toMap(map -> Integer.valueOf(map.get("userId").toString()), val -> val));
			}
			boolean emptyDataFlag = true;
			if (userProfitMoneyMap!=null)  {
				emptyDataFlag = false ;
			} 
			if (statisticTotleMap!=null) {
				emptyDataFlag = false ;
			} 
			if (!emptyDataFlag) {
				for (Integer userId : commonUserList) {
					Map<String,Object> userSalaryInfoMap = userSalaryTypeMap.get(userId);
					if (userProfitMoneyMap != null) {
						Map<String, Object> profitMap = userProfitMoneyMap.get(userId);
						if (profitMap != null) {
							userSalaryInfoMap.put("profitMoney", profitMap.get("profitMoney"));
						}
					}
					if (statisticTotleMap != null) {
						Map<String, Object> workCountMap = statisticTotleMap.get(userId);
						if (workCountMap != null) {
							userSalaryInfoMap.put("houseDjCountTotal", workCountMap.get("houseDjCount"));
							userSalaryInfoMap.put("custDjCountTotal", workCountMap.get("custDjCount"));
							userSalaryInfoMap.put("fkCountTotal", workCountMap.get("fkCount"));
							userSalaryInfoMap.put("dkCountTotal", workCountMap.get("dkCount"));
						}
					}
				}
			}
		}
		if (!manageUserList.isEmpty()) {
			DecimalFormat df =new DecimalFormat("#.00");  
			for (Integer userId : manageUserList) {
				Map<String,Object> map = new HashMap<String,Object>();
				Map<String,Object> userSalaryMap = userSalaryTypeMap.get(userId);
				if (userSalaryMap != null) {
					Object manageLevelObj = userSalaryMap.get("manageLevel");
					Object countTypeObj = userSalaryMap.get("countType");
					Object profitCountTypeObj = userSalaryMap.get("profitCountType");
					String manageLevelStr = manageLevelObj.toString(); 
					String countTypeStr = countTypeObj.toString(); 
					String profitCountTypeObjStr = profitCountTypeObj.toString(); 
					if (!"0".equals(manageLevelStr)) { 
						String rangeColumn = transManageLevelToColumn(manageLevelStr);
						List<Integer> rangeList = null;
						if (StringUtil.isBlank(rangeColumn)) {
							continue;
						}
						if (userManageMap != null) {
							rangeList = userManageMap.get(userId);
							if (rangeList == null || rangeList.isEmpty()) {
								continue;
							}
						}
						if (rangeList!=null) {
							if ("0".equals(profitCountTypeObjStr)) {
								String totalProfitMoneyStr = erpFunProfitMapper.getProfitTotalOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
								map.put("profitMoney", totalProfitMoneyStr);
							} else {
								String perCapitaProfitMoneyStr = erpFunProfitMapper.getProfitPerCapitaOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
								map.put("profitMoney", perCapitaProfitMoneyStr);
							}
							if ("0".equals(countTypeStr)) {
								Map<String,Integer> workCountMap = reportFunStatisticTotleMapper.getProfitPerCapitaWorkCountOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
								if (workCountMap != null) {
									map.put("houseDjCountTotal", workCountMap.get("houseDjCount"));
									map.put("custDjCountTotal", workCountMap.get("custDjCount"));
									map.put("fkCountTotal", workCountMap.get("fkCount"));
									map.put("dkCountTotal", workCountMap.get("dkCount"));
								}
							} else {
								Map<String,Integer> workCountMap = reportFunStatisticTotleMapper.getProfitPerCapitaWorkCountOffRangeList(param.getInteger("cityId"), compId, rangeColumn, rangeList, startTime, endTime);
								if (workCountMap != null) {
									int userCount = erpFunUsersMapper.getTotalUserCountOffRangeList(param.getInteger("cityId"), compId, rangeColumn, rangeList, startTime, endTime);
									if(userCount==0){
										userCount = 1;
									}
									Integer houseDjCount = workCountMap.get("houseDjCount");
									Integer custDjCount = workCountMap.get("custDjCount");
									Integer fkCount = workCountMap.get("fkCount");
									Integer dkCount = workCountMap.get("dkCount");
									if (houseDjCount != null) {
										map.put("houseDjCountTotal", df.format(houseDjCount/(userCount+0.0)));
									}
									
									if (custDjCount != null) {
										map.put("custDjCountTotal", df.format(custDjCount/(userCount+0.0)));
									}
									
									if (fkCount != null) {
										map.put("fkCountTotal", df.format(fkCount/(userCount+0.0)));
									}
									
									if (dkCount != null) {
										map.put("dkCountTotal", df.format(dkCount/(userCount+0.0)));
									}
								}
							}
							
						}
						userSalaryMap.putAll(map);
					}
				}
			}
		}
		//查询对应时间内的员工,获取对应时间段内存在过的员工
		List<Map<String,Object>> userList = erpFunUsersMapper.getUserListNotWriteOffOnTime(getOperator().getCityId(),param.getMap());
		Map<String,Map<String,Object>> userMap = BeanUtil.listMapObjecttoMap(userList, "userId");
		userSalaryTypeList.forEach( data ->{
			Object keyObject = data.get("userId");
			if (keyObject != null) {
				userMap.put(keyObject.toString(), data);
			}
		});
		List<Map<String,Object>> returnList = new ArrayList<>(userMap.values());			
		return ErpResponseJson.ok(returnList);
	}

	/**
	 * 当前经济人的信息
	 * @author 熊刚
	 * @since 2017年8月26日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getSalarySchemeByArchiveId")
	public ErpResponseJson getSalarySchemeByArchiveId(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		param.setInteger("compId", compId);
		param.setInteger("userId", userId);
		param.setInteger("cityId", cityId);
		param.setInteger("archiveId", getOperator().getArchiveId());
		String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
		String startTime = timeArr[0];
		String endTime = timeArr[1];
		param.setString("startTime",startTime);
		param.setString("endTime",endTime);
		String userProfit = null;
		Map<String,Object> returnDataMap = new HashMap<String,Object>();
		// 目标业绩
		ErpFunSalaryType erpFunSalaryType = erpFunSalaryTypeMapper.getSalaryTypeInfoByUserId(getOperator().getCityId(),getOperator().getUserId(),getOperator().getCompId(),param.getMap());
		if (erpFunSalaryType == null) {
			return ErpResponseJson.ok();
		}
		Byte mangeLevel = erpFunSalaryType.getManageLevel();
		Byte countType = erpFunSalaryType.getCountType();
		Byte profitCountType = erpFunSalaryType.getProfitCountType();
		if (Byte.valueOf("0").equals(mangeLevel)) {
			// 当前业绩
			userProfit = erpFunProfitMapper.getSalaryTotal(getOperator().getCityId(), param.getMap());
			// 查询带看，房勘，客源新增，房源新增
			ErpFunStatisticRateDto erpFunStatisticRateDto = reportFunStatisticTotleMapper.getStatistic(getOperator().getCityId(),param.getMap());
			if (null != erpFunStatisticRateDto) {
				returnDataMap.put("houseDjCountTotal", erpFunStatisticRateDto.getHouseDjCountTotal());
				returnDataMap.put("custDjCountTotal", erpFunStatisticRateDto.getCustDjCountTotal());
				returnDataMap.put("fkCountTotal", erpFunStatisticRateDto.getFkCountTotal());
				returnDataMap.put("dkCountTotal", erpFunStatisticRateDto.getDkCountTotal());
			}
		} else if (mangeLevel!=null) {
			DecimalFormat df =new DecimalFormat("#.00");
			String rangeColumn = transManageLevelToColumn(mangeLevel.toString());
			List<Integer> rangeList = null;
			Map<Integer, List<Integer>> userManageMap = null;
			ErpFunUserManageRangeExample example = new ErpFunUserManageRangeExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId);
			List<ErpFunUserManageRange> roleManageRangeList = erpFunUserManageRangeMapper.selectByExample(example);
			userManageMap = roleManageRangeList.stream().collect(Collectors.groupingBy(ErpFunUserManageRange::getUserId, Collectors.mapping(ErpFunUserManageRange::getRangeId, Collectors.toList())));
			if (userManageMap != null) {
				rangeList = userManageMap.get(userId);
			}
			if (rangeList!=null) {
				if ("0".equals(profitCountType.toString())) {
					userProfit = erpFunProfitMapper.getProfitTotalOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
				} else {
					userProfit = erpFunProfitMapper.getProfitPerCapitaOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
				}
				if ("0".equals(countType.toString())) {
					Map<String,Integer> workCountMap = reportFunStatisticTotleMapper.getProfitPerCapitaWorkCountOffRangeList(cityId, compId, rangeColumn, rangeList, startTime, endTime);
					if (workCountMap != null) {
						returnDataMap.put("houseDjCountTotal", workCountMap.get("houseDjCount"));
						returnDataMap.put("custDjCountTotal", workCountMap.get("custDjCount"));
						returnDataMap.put("fkCountTotal", workCountMap.get("fkCount"));
						returnDataMap.put("dkCountTotal", workCountMap.get("dkCount"));
					}
				} else {
					Map<String,Integer> workCountMap = reportFunStatisticTotleMapper.getProfitPerCapitaWorkCountOffRangeList(param.getInteger("cityId"), compId, rangeColumn, rangeList, startTime, endTime);
					if (workCountMap != null) {
						int userCount = erpFunUsersMapper.getTotalUserCountOffRangeList(param.getInteger("cityId"), compId, rangeColumn, rangeList, startTime, endTime);
						if(userCount==0){
							userCount = 1;
						}
						Integer houseDjCount = workCountMap.get("houseDjCount");
						Integer custDjCount = workCountMap.get("custDjCount");
						Integer fkCount = workCountMap.get("fkCount");
						Integer dkCount = workCountMap.get("dkCount");
						if (houseDjCount != null) {
							returnDataMap.put("houseDjCountTotal", df.format(houseDjCount/(userCount+0.0)));
						}
						
						if (custDjCount != null) {
							returnDataMap.put("custDjCountTotal", df.format(custDjCount/(userCount+0.0)));
						}
						
						if (fkCount != null) {
							returnDataMap.put("fkCountTotal", df.format(fkCount/(userCount+0.0)));
						}
						
						if (dkCount != null) {
							returnDataMap.put("dkCountTotal", df.format(dkCount/(userCount+0.0)));
						}
					}
				}
				
			}
		}
		/*	// 薪资方案id
		String salaryTypeId = erpFunSalaryTypeMapper.getSalaryTypeId(getOperator().getCityId(),getOperator().getUserId(),getOperator().getCompId(), param.getMap());
*/		// 数据拼接
		returnDataMap.put("deptId", String.valueOf(getOperator().getDeptId()));
		if(erpFunSalaryType!=null){
			returnDataMap.put("salaryMoney", erpFunSalaryType.getSalaryMoney());
			returnDataMap.put("taskMoney", erpFunSalaryType.getTaskMoney());
			returnDataMap.put("tragetProfit", erpFunSalaryType.getTragetProfit());
			returnDataMap.put("houseAssessmentCount", erpFunSalaryType.getHouseAddCount());
			returnDataMap.put("perHouseMoney", erpFunSalaryType.getPerHouseMoney());
			returnDataMap.put("custAssessmentCount", erpFunSalaryType.getCustAddCount());
			returnDataMap.put("perCustMoney", erpFunSalaryType.getPerCustMoney());
			returnDataMap.put("fankanAssessmentCount", erpFunSalaryType.getFankanCount());
			returnDataMap.put("perFankanMoney", erpFunSalaryType.getPerFankanMoney());
			returnDataMap.put("daikanAssessmentCount", erpFunSalaryType.getDaikanCount());
			returnDataMap.put("perDaikanMoney", erpFunSalaryType.getPerDaikanMoney());
		}
		returnDataMap.put("userProfit",userProfit);
		
		return ErpResponseJson.ok(returnDataMap);
	}
	
	/**
	 * 排名信息
	 * @author 熊刚
	 * @since 2017年8月27日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getRankInformation")
	public ErpResponseJson getRankInformation(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("deptId", getOperator().getDeptId());
		param.setInteger("archiveId",getOperator().getArchiveId());
		String[] timeArr = DateUtil.getCurrentMonthByTodayTimeArr();
		param.setString("startTime",timeArr[0]);
		param.setString("endTime",timeArr[1]);
		//本经纪人头像姓名
		AdminFunArchiveDto adminFunArchiveDto = adminFunArchiveMapper.getDtoByArchiveId(getOperator().getArchiveId());
		if(adminFunArchiveDto != null && adminFunArchiveDto.getBbsPhoto() != null){
			String userPhoto = CommonUtil.getBbsPhoto(adminFunArchiveDto.getBbsPhoto());
			adminFunArchiveDto.setUserPhoto(userPhoto);
		}
		adminFunArchiveDto.setDeptId(getOperator().getDeptId());
		//取出前10排名
		List<Map<String,Object>> rankInformationList = erpFunProfitMapper.getRankInformation(getOperator().getCityId(),param.getMap());
		List<String> archiveIdList = rankInformationList.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("archiveId")), Collectors.toList()));
		//查询出对应的AdminFunArchiveDto
		if (null!=archiveIdList && !archiveIdList.isEmpty()) {
			List<AdminFunArchiveDto> adminFunArchiveDtoList = adminFunArchiveMapper.getAdminFunArchiveDtoList(archiveIdList);
			Map<Integer, AdminFunArchiveDto> AdminFunArchiveDtoMap = adminFunArchiveDtoList.stream().collect(Collectors.toMap(AdminFunArchiveDto::getArchiveId, val -> val));
			//拼装头像
			rankInformationList.stream().forEach((Map<String,Object> dataMap) -> {
				String archiveId = dataMap.get("archiveId").toString();
				AdminFunArchiveDto adminFunArchive = AdminFunArchiveDtoMap.get(Integer.valueOf(archiveId));
				if(adminFunArchive !=null){
					dataMap.put("userPhoto", CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
				}
			});
		}
		//求出当前经纪人排名信息
		Map<String,Object> rankMap = erpFunProfitMapper.getRankByArchiveId(getOperator().getCityId(),param.getMap());
		String targetProfit = erpFunSalaryTypeMapper.getSalaryTypeTargetProfitByUserId(getOperator().getCityId(), getOperator().getUserId(), getOperator().getCompId());
		if(rankMap !=null){
			rankMap.put("targetProfit", targetProfit);
			rankMap.put("userPhoto", CommonUtil.getBbsPhoto(adminFunArchiveDto.getBbsPhoto()));
		}
		//求出当前经纪人排名的上一位信息
		Map<String,Object> rankBeforeMap = null;
		if (null != rankMap && Integer.valueOf(rankMap.get("rankNum").toString()) > 1
				&& Double.valueOf(rankMap.get("salaryTotal").toString()) >= 0.0) {
			Integer rankNumBefore = Integer.valueOf(rankMap.get("rankNum").toString()) - 1;
			param.setInteger("rankNumBefore", rankNumBefore);
			param.setObject("profit", rankMap.get("salaryTotal"));
			rankBeforeMap = erpFunProfitMapper.getRankBeforeByArchiveId(getOperator().getCityId(), param.getMap());
		}
		//取出上个月前10排名
		timeArr = DateUtil.getLastMonthByTodayTimeArr();
		param.setString("startTime",timeArr[0]);
		param.setString("endTime",timeArr[1]);
		List<Map<String,Object>> lastMonthRankInformationList = erpFunProfitMapper.getRankInformation(getOperator().getCityId(),param.getMap());
		List<String> lastRankArchiveIdList = lastMonthRankInformationList.stream().collect(Collectors.mapping(map -> String.valueOf(map.get("archiveId")), Collectors.toList()));
		//查询出对应的AdminFunArchiveDto
		if(null!=lastRankArchiveIdList && !lastRankArchiveIdList.isEmpty()){
			List<AdminFunArchiveDto> adminFunArchiveDtoList = adminFunArchiveMapper.getAdminFunArchiveDtoList(lastRankArchiveIdList);
			Map<Integer, AdminFunArchiveDto> AdminFunArchiveDtoMap = adminFunArchiveDtoList.stream().collect(Collectors.toMap(AdminFunArchiveDto::getArchiveId, val -> val));
			//拼装头像
			rankInformationList.stream().forEach((Map<String, Object> dataMap) -> {
				String archiveId = dataMap.get("archiveId").toString();
				AdminFunArchiveDto adminFunArchive = AdminFunArchiveDtoMap.get(Integer.valueOf(archiveId));
				if (adminFunArchive != null) {
					dataMap.put("userPhoto", CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
				}
			});
		}
		
		Map<String,Object> returnMap = new HashMap<String, Object>();
		returnMap.put("rankList", rankInformationList);
		returnMap.put("rankLastList", lastMonthRankInformationList);
		returnMap.put("rankMap", rankMap);
		returnMap.put("rankBeforeMap", rankBeforeMap);
		return ErpResponseJson.ok(returnMap);	
	}
	
	/**
	 * 
	 * @param manageLevel
	 * @return
	 */
	private String transManageLevelToColumn(String manageLevel){
		//1=公司 2=大区 3=片区 4=门店 5=分组
		if (StringUtil.isBlank(manageLevel)) {
			return null;
		}
		String result = null;
		switch (manageLevel) {
			case "1":
				result = "COMP_ID";
			break;
			case "2":
				result = "AREA_ID";
				break;
			case "3":
				result = "REG_ID";
				break;
			case "4":
				result = "DEPT_ID";
				break;
			case "5":
				result = "GR_ID";
				break;
		}
		return result;
	}

	/**
	 * @Title 展开基本工资下拉列表
	 * @Author lcb
	 * @Date 2018/1/8
	 * @Param
	 **/
	@ApiOperation(value = "考核统计列表",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200, response = PerformanceAssessmentCountListVo.class, message = "success")})
	@RequestMapping("/getPerformanceAssessmentCountList")
	public ResponseJson getPerformanceAssessmentCountList( @RequestBody PerformanceAssessmentCountListParam param) {
		// 先以人单位查询出列表形态，在取处理人的数据
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);

		// 默认取当月
		if(StringUtils.isBlank(param.getAssessmentMonth())) {
			String wageAccountingDay = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "WAGE_ACCOUNTING_DAY");
			String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);
			param.setAssessmentMonth(assessMentMonth);
		}
		param.setNewOrganization(operator.newOrganizationType());
		List<ErpFunAssessmentStatistics> funUserLsit = erpFunUsersMapper.getWageCountUserList(cityId, compId, param);
		List<ErpFunAssessmentStatistics> dataList = new ArrayList<>();
		List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList = new ArrayList<>();
		List<ErpFunRoleWageProfit> erpFunRoleWageProfitList = new ArrayList<>();

		if(funUserLsit.size() > 0) {
			Set<Integer> userIdSet = funUserLsit.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));

			ErpFunAssessmentStatisticsExample erpFunAssessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
			erpFunAssessmentStatisticsExample.setShardCityId(cityId);
			ErpFunAssessmentStatisticsExample.Criteria criteria = erpFunAssessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(new ArrayList<>(userIdSet)).
					andAssessmentMonthEqualTo(param.getAssessmentMonth()).andDealFlagEqualTo((byte) 0);
			erpFunAssessmentStatisticsExample.setOrderByClause("USER_ID ");

			// 这个是所有的数据了
			if(null != param.getCheckType()) {
				criteria.andCheckTypeEqualTo(param.getCheckType().byteValue());
			}

//			dataList = erpFunAssessmentStatisticsMapper.selectByExample(erpFunAssessmentStatisticsExample);
			// 这里是统计了,算是这bug
			if (!CollectionUtils.isEmpty(userIdSet)) {
				for (int i = 0,baseCount = 200,lengh = userIdSet.size(); i < lengh; i += baseCount) {
					Set<Integer> current = userIdSet.stream().skip(i).limit(baseCount).collect(Collectors.toSet());
					if (current.size() > 0) {
						List<ErpFunAssessmentStatistics> list = erpFunAssessmentStatisticsMapper.getStatisticsSum(cityId, compId, param.getAssessmentMonth(), current, param.getCheckType());
						dataList.addAll(list);
					}
				}
			}

			Set<Integer> roleWageConfigId = dataList.stream().collect(Collectors.mapping(val -> val.getRoleWageConfigId(), Collectors.toSet()));
			if (roleWageConfigId != null && roleWageConfigId.size() > 0) {
				ErpFunRoleWageWorkcountExample erpFunRoleWageWorkcountExample = new ErpFunRoleWageWorkcountExample();
				erpFunRoleWageWorkcountExample.setShardCityId(cityId);
				erpFunRoleWageWorkcountExample.createCriteria().andIsCheckEqualTo((byte) 1).andCompIdEqualTo(compId).andRoleWageConfigIdIn(new ArrayList<>(roleWageConfigId));
				// 所选择列表人的角色上所有的工作量配置
				erpFunRoleWageWorkcountList = erpFunRoleWageWorkcountMapper.selectByExample(erpFunRoleWageWorkcountExample);
				
				// 查询业绩配置列表
				ErpFunRoleWageProfitExample erpFunRoleWageProfitExample = new ErpFunRoleWageProfitExample();
				erpFunRoleWageProfitExample.setShardCityId(cityId);
				erpFunRoleWageProfitExample.createCriteria().andIsCheckEqualTo((byte) 1).andCompIdEqualTo(compId).andRoleWageConfigIdIn(new ArrayList<>(roleWageConfigId));
				erpFunRoleWageProfitList = erpFunRoleWageProfitMapper.selectByExample(erpFunRoleWageProfitExample);
			}
		}
		//只需要funUserLsit的分页数据
		ErpResponseJson ok = ErpResponseJson.ok(funUserLsit);
		// 设置返回值
		PerformanceAssessmentCountListVo vo = new PerformanceAssessmentCountListVo();
		vo.setDataList(dataList);
		vo.setProfitConfigList(erpFunRoleWageProfitList);
		vo.setWorkCountConfigList(erpFunRoleWageWorkcountList);

		return ErpResponseJson.ok(vo);
	}

	/**
	 * @Title 考核统计详情
	 * @Author lcb
	 * @Date 2018/1/8
	 * @Param
	 **/
	@RequestMapping("/getPerformanceAssessmentCountDetail")
	public ErpResponseJson getPerformanceAssessmentCountDetail(@Valid @RequestBody ErpPerformanceAssessmentCountParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer caseType = param.getCaseType();
		Integer checkType = param.getCheckType();
		String roleId = param.getRoleId();
		String assessmentMonth = param.getAssessmentMonth();
		param.setCompId(compId);
		// 初始化数据
		ErpPerformanceAssessmentCountParam dataParam = new ErpPerformanceAssessmentCountParam();
		dataParam.setCaseType(caseType);
		dataParam.setCheckType(checkType);
		dataParam.setCityId(cityId);
		dataParam.setCompId(compId);
		dataParam.setCountType(param.getCountType());
		dataParam.setRoleId(roleId);
		dataParam.setAssessmentMonth(assessmentMonth);
		dataParam.setValidFlag(param.getValidFlag());
		// 根据列表组装查询出租、出售详情列表
		if (param.getCheckType() == 1) { // 个人考核
//			dataParam.getAreaIds().add(param.getAreaId());
//			dataParam.getRegIds().add(param.getRegId());
//			dataParam.getGrIds().add(param.getGrId());
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			dataParam.setArchiveId(erpFunUsers.getArchiveId());
		} else if (param.getCheckType() == 2) { // 管理
			List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, param.getUserId());
			if (userManageRange.size() > 0) {
				ErpFunUserManageRange erpFunUserManageRange = userManageRange.get(0);
				List<Integer> rangeIds = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toList()));
				Integer rangeType = erpFunUserManageRange.getRangeType(); // 范围类型，1=公司  2=大区 3=片区 4=门店 5=分组
				// 管理范围是公司的直接略过，因为肯定会加公司条件的
				if (rangeType == 2) {
					dataParam.getAreaIds().addAll(rangeIds);
				} else if (rangeType == 3) {
					dataParam.getRegIds().addAll(rangeIds);
				} else if (rangeType == 4) {
					dataParam.getDeptIds().addAll(rangeIds);
				} else if (rangeType == 5) {
					dataParam.getGrIds().addAll(rangeIds);
				}
			}
		}
		// 查询考核范围
		ErpFunRoleWageWorkcount erpFunRoleWageWorkcount = erpFunRoleWageWorkcountMapper.selectConfigByRoleId(cityId, compId, checkType, roleId, assessmentMonth);
		// 空或者0 全部 1：买卖 2租赁
		Byte checkBusiness = erpFunRoleWageWorkcount.getCheckBusiness();
		dataParam.setCheckBusiness(checkBusiness);

		ErpFunWageConfig erpFunWageConfig = erpFunWageConfigMapper.selectThisMonthConfig(cityId, compId);
		if(null == erpFunWageConfig) {
			erpFunWageConfig = new ErpFunWageConfig();
			// 默认只有房增
			erpFunWageConfig.setHouseAdd((byte)1);
		}

		// 判断统计范围
		Set<Integer> sourceFrom = new HashSet<>();

		Integer countType = dataParam.getCountType();
		if(1== countType || 8==countType) { // 房
			dataParam.setSaleCaseType(1);
			dataParam.setLeaseCaseType(2);

			if(1==countType) {
				sourceFrom.add(1);
				Byte houseBuildInfo = erpFunWageConfig.getHouseBuildInfo();
				if(null != houseBuildInfo && 1 == houseBuildInfo.intValue()) {
					sourceFrom.add(2);
				}

				Byte houseSoso = erpFunWageConfig.getHouseSoso();
				if(null != houseSoso && 1 == houseSoso.intValue()) {
					sourceFrom.add(3);
				}
				Byte housePubPri = erpFunWageConfig.getHousePubPri();
				if(null != housePubPri && 1 == housePubPri.intValue()) {
					sourceFrom.add(4);
				}
				Byte houseSharePri = erpFunWageConfig.getHouseSharePri();
				if(null != houseSharePri && 1 == houseSharePri.intValue()) {
					sourceFrom.add(5);
				}
				Byte houseToEffective = erpFunWageConfig.getHouseToEffective();
				if(null != houseToEffective && 1 == houseToEffective.intValue()) {
					sourceFrom.add(6);
				}
				Byte houseCancelRespite = erpFunWageConfig.getHouseCancelRespite(); //取消暂缓只有房源
				if(null != houseCancelRespite && 1 == houseCancelRespite.intValue()) {
					sourceFrom.add(7);
				}
			}

		}else if(2== countType || 15==countType) { // 客
			dataParam.setSaleCaseType(3);
			dataParam.setLeaseCaseType(4);
			if(2==countType) {
				Byte customerAdd = erpFunWageConfig.getCustomerAdd();
				sourceFrom.add(1);

				Byte customerPubPri = erpFunWageConfig.getCustomerPubPri();
				if(null != customerPubPri && 1 == customerPubPri.intValue()) {
					sourceFrom.add(4);
				}

				Byte customerSharePri = erpFunWageConfig.getCustomerSharePri();
				if(null != customerSharePri && 1 == customerSharePri.intValue()) {
					sourceFrom.add(5);
				}

				Byte customerToEffective = erpFunWageConfig.getCustomerToEffective();
				if(null != customerToEffective && 1 == customerToEffective.intValue()) {
					sourceFrom.add(6);
				}

				// 客源没有配置

				if(sourceFrom.size() == 0) {
					return ErpResponseJson.ok();
				}
			}

		}
		dataParam.setSourceFrom(sourceFrom);

		// 1=房源新增,2客源新增,7房源实勘,14客源带看
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());

		List<ReportFunWageDetail1> dataList = reportFunWageDetail1Mapper.selectBuyData(cityId, dataParam);

		List<Map<String, Object>> detailCaseList = new ArrayList<>();
		if(dataList.size() > 0) {

			// 客源
			Map<String, Object> paramMap = new HashMap<>();
			if(7 == param.getCountType()) {
				List<Integer> trackIds = dataList.stream().collect(Collectors.mapping(val -> val.getTrackId(), Collectors.toList()));
				ErpFunTrackExample erpFunTrackExample = new ErpFunTrackExample();
				erpFunTrackExample.setShardCityId(cityId);
				erpFunTrackExample.createCriteria().andTrackIdIn(trackIds);
				List<ErpFunTrack> erpFunTrackList = erpFunTrackMapper.selectByExample(erpFunTrackExample);

				for (ErpFunTrack erpFunTrack : erpFunTrackList) {
					Map<String, Object> trackMap = new HashMap<>();
					trackMap.put("trackClassic", erpFunTrack.getTrackClassic());
					trackMap.put("trackContent", erpFunTrack.getTrackContent());
					trackMap.put("trackId", erpFunTrack.getTrackId());
					trackMap.put("caseNo", erpFunTrack.getCaseNo());
					trackMap.put("caseType", erpFunTrack.getCaseType());
					trackMap.put("creationTime", erpFunTrack.getCreationTime());
					trackMap.put("creatorUid", erpFunTrack.getCreatorUid());
					trackMap.put("caseId", erpFunTrack.getCaseId());
					for (ReportFunWageDetail1 reportFunWageDetail1 : dataList) {
						if(reportFunWageDetail1.getTrackId().equals(erpFunTrack.getTrackId())) {
							trackMap.put("detailId", reportFunWageDetail1.getId());
							break;
						}
					}
					detailCaseList.add(trackMap);
				}
			}else {
				List<Integer> caseIds = dataList.stream().collect(Collectors.mapping(val -> val.getCaseId(), Collectors.toList()));
				paramMap.put("caseIdList", caseIds);
				paramMap.put("caseType", caseType);
				detailCaseList = erpFunSaleMapper.getCaseList(cityId, paramMap);

				for (Map<String, Object> resMap : detailCaseList) {
					for (ReportFunWageDetail1 reportFunWageDetail1 : dataList) {
						Integer caseId = Integer.valueOf(resMap.get("caseId")+"");
						Integer caseId1 = reportFunWageDetail1.getCaseId();
						if(caseId.equals(caseId1)) {
							resMap.put("detailId", reportFunWageDetail1.getId());
							break;
						}
					}
				}
			}

		}
		Integer funWageIsGrant = getFunWageIsGrant(cityId, compId, param.getUserId(), param.getAssessmentMonth());

		ErpResponseJson ok = ErpResponseJson.ok(new PageInfo<>(dataList));
		// 设置返回值
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("dataList", detailCaseList);
		paramMap.put("funWageIsGrant", funWageIsGrant);
		ok.setData(paramMap);

		return ok;
	}

	/**
	 * @Title 扣除异常工作
	 * @Author zhuke
	 * @Date 2018/1/20
	 * @Param
	 **/
	@RequestMapping("/getAbnormalWorkAmount")
	public ErpResponseJson getAbnormalWorkAmount(@Valid @RequestBody ErpPerformanceAssessmentCountParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer resCode = reportFunWageDetail1Service.updateWorkCount(cityId, compId, param);
		return ErpResponseJson.ok(resCode);
	}

	/**
	 * @Title 查询业绩列表
	 * @Author zhuke
	 * @Date 2018/1/22
	 * @Param
	 **/
	@RequestMapping("/getProfitMessageFormList")
	public ErpResponseJson getProfitMessageFormList(@Valid @RequestBody ErpPerformanceAssessmentCountParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = getOperator().getCompId();
		// 根据列表组装查询出租、出售详情列表
		if (param.getCheckType() == 1) { // 个人考核
			param.getAreaIds().add(param.getAreaId());
			param.getRegIds().add(param.getRegId());
			param.getGrIds().add(param.getGrId());
			param.setUserId(param.getUserId());
		} else if (param.getCheckType() == 2) { // 管理
			param.setUserId(null);
			List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, param.getUserId());
			if (userManageRange.size() > 0) {
				ErpFunUserManageRange erpFunUserManageRange = userManageRange.get(0);
				List<Integer> rangeIds = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toList()));
				Integer rangeType = erpFunUserManageRange.getRangeType(); // 范围类型，1=公司  2=大区 3=片区 4=门店 5=分组
				// 管理范围是公司的直接略过，因为肯定会加公司条件的
				if (rangeType == 2) {
					param.getAreaIds().addAll(rangeIds);
				} else if (rangeType == 3) {
					param.getRegIds().addAll(rangeIds);
				} else if (rangeType == 4) {
					param.getDeptIds().addAll(rangeIds);
				} else if (rangeType == 5) {
					param.getGrIds().addAll(rangeIds);
				}
			}
		}
		Long totalCount = null;
		if(param.getPageOffset() == 1) {
			totalCount = erpFunProfitMapper.selectProFitCount(cityId, compId, param);
		}
		// 查询total

		// 查询系统参数，考核统计方式
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<Map<String, Object>> detailList = erpFunProfitMapper.selectProFitList(cityId, compId, param);
		ErpResponseJson ok = ErpResponseJson.ok(new PageInfo<>(detailList));
		if(totalCount != null) {
			ok.setTotal(totalCount);
		}
		// 设置返回值，是否已发放
		Integer funWageIsGrant = 0;
		if(null != param.getUserId()) {
			funWageIsGrant = getFunWageIsGrant(cityId, compId, param.getUserId(), param.getAssessmentMonth());
		}
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("dataList", detailList);
		paramMap.put("funWageIsGrant", funWageIsGrant);
		ok.setData(paramMap);
		return ErpResponseJson.ok(detailList);
	}

	/**
	 * @Title 扣除异常业绩量
	 * @Author zhuke
	 * @Date 2018/1/22
	 * @Param
	 **/
	@RequestMapping("/getAbnormalProfitMessage")
	public ErpResponseJson getAbnormalProfitMessage(@Valid @RequestBody ErpProfitMessageFormParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer resCount = erpFunProfitService.updatevalidProfit(cityId, compId, param);
		return ErpResponseJson.ok(resCount);
	}

	private Integer getFunWageIsGrant(Integer cityId, Integer compId, Integer userId, String assessmentMonth) {
		ErpFunWageExample erpFunWageExample = new ErpFunWageExample();
		erpFunWageExample.setShardCityId(cityId);
		erpFunWageExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andAssessmentMonthEqualTo(assessmentMonth).andCheckStatusEqualTo((byte)1);

		Integer count = erpFunWageMapper.countByExample(erpFunWageExample);
		return count;
	}

	@RequestMapping("/getAssessmentDetailCount")
	public ErpResponseJson getAbnormalProfitMessage(@Valid @RequestBody ErpPerformanceAssessmentCountParam param){

		Operator operator = getOperator();
		String assessmentMonth = param.getAssessmentMonth();
		String roleId = param.getRoleId();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer caseType = param.getCaseType();
		Integer checkType = param.getCheckType();
		param.setCompId(compId);
		// 初始化数据
		ErpPerformanceAssessmentCountParam dataParam = new ErpPerformanceAssessmentCountParam();
		dataParam.setCaseType(caseType);
		dataParam.setCheckType(checkType);
		dataParam.setCityId(cityId);
		dataParam.setCompId(compId);
		dataParam.setCountType(param.getCountType());
		dataParam.setRoleId(roleId);
		dataParam.setAssessmentMonth(assessmentMonth);
		dataParam.setValidFlag(param.getValidFlag());
		// 根据列表组装查询出租、出售详情列表
		if (param.getCheckType() == 1) { // 个人考核
//			dataParam.getAreaIds().add(param.getAreaId());
//			dataParam.getRegIds().add(param.getRegId());
//			dataParam.getGrIds().add(param.getGrId());
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			dataParam.setArchiveId(erpFunUsers.getArchiveId());
		} else if (param.getCheckType() == 2) { // 管理
			List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, param.getUserId());
			if (userManageRange.size() > 0) {
				ErpFunUserManageRange erpFunUserManageRange = userManageRange.get(0);
				List<Integer> rangeIds = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toList()));
				Integer rangeType = erpFunUserManageRange.getRangeType(); // 范围类型，1=公司  2=大区 3=片区 4=门店 5=分组
				// 管理范围是公司的直接略过，因为肯定会加公司条件的
				if (rangeType == 2) {
					dataParam.getAreaIds().addAll(rangeIds);
				} else if (rangeType == 3) {
					dataParam.getRegIds().addAll(rangeIds);
				} else if (rangeType == 4) {
					dataParam.getDeptIds().addAll(rangeIds);
				} else if (rangeType == 5) {
					dataParam.getGrIds().addAll(rangeIds);
				}
			}
		}

		ErpFunWageConfig erpFunWageConfig = erpFunWageConfigMapper.selectThisMonthConfig(cityId, compId);
		if(null == erpFunWageConfig) {
			erpFunWageConfig = new ErpFunWageConfig();
			// 默认只有房增
			erpFunWageConfig.setHouseAdd((byte)1);
			erpFunWageConfig.setCustomerAdd((byte)1);
		}

		// 判断统计范围
		Set<Integer> sourceFrom = new HashSet<>();

		Integer countType = dataParam.getCountType();
		if(1== countType || 8==countType) { // 房
			dataParam.setSaleCaseType(1);
			dataParam.setLeaseCaseType(2);

			if(1==countType) {
				sourceFrom.add(1);
				Byte houseBuildInfo = erpFunWageConfig.getHouseBuildInfo();
				if(null != houseBuildInfo && 1 == houseBuildInfo.intValue()) {
					sourceFrom.add(2);
				}

				Byte houseSoso = erpFunWageConfig.getHouseSoso();
				if(null != houseSoso && 1 == houseSoso.intValue()) {
					sourceFrom.add(3);
				}
				Byte housePubPri = erpFunWageConfig.getHousePubPri();
				if(null != housePubPri && 1 == housePubPri.intValue()) {
					sourceFrom.add(4);
				}
				Byte houseSharePri = erpFunWageConfig.getHouseSharePri();
				if(null != houseSharePri && 1 == houseSharePri.intValue()) {
					sourceFrom.add(5);
				}
				Byte houseToEffective = erpFunWageConfig.getHouseToEffective();
				if(null != houseToEffective && 1 == houseToEffective.intValue()) {
					sourceFrom.add(6);
				}
				Byte houseCancelRespite = erpFunWageConfig.getHouseCancelRespite();
				if(null != houseCancelRespite && 1 == houseCancelRespite.intValue()) {
					sourceFrom.add(7);
				}
			}
		}else if(2== countType || 15==countType) { // 客
			dataParam.setSaleCaseType(3);
			dataParam.setLeaseCaseType(4);
			// 客源没有配置
			if(2==countType) {
				Byte customerAdd = erpFunWageConfig.getCustomerAdd();
				sourceFrom.add(1);

				Byte customerPubPri = erpFunWageConfig.getCustomerPubPri();
				if(null != customerPubPri && 1 == customerPubPri.intValue()) {
					sourceFrom.add(4);
				}

				Byte customerSharePri = erpFunWageConfig.getCustomerSharePri();
				if(null != customerSharePri && 1 == customerSharePri.intValue()) {
					sourceFrom.add(5);
				}

				Byte customerToEffective = erpFunWageConfig.getCustomerToEffective();
				if(null != customerToEffective && 1 == customerToEffective.intValue()) {
					sourceFrom.add(6);
				}

				if(sourceFrom.size() == 0) {
					return ErpResponseJson.ok();
				}
			}

		}

		// 查询考核范围
		ErpFunRoleWageWorkcount erpFunRoleWageWorkcount = erpFunRoleWageWorkcountMapper.selectConfigByRoleId(cityId, compId, checkType, roleId, assessmentMonth);
		// 空或者0 全部 1：买卖 2租赁
		Byte checkBusiness = erpFunRoleWageWorkcount.getCheckBusiness();
		dataParam.setCheckBusiness(checkBusiness);
		// 1=房源新增,2客源新增,7房源实勘,14客源带看
		dataParam.setSourceFrom(sourceFrom);
		Map<String, Object> resMap = reportFunWageDetail1Mapper.selectBuyDataCount(cityId, dataParam);

		return ErpResponseJson.ok(resMap);
	}
}

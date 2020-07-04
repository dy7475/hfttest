package com.myfun.erpWeb.homepage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.repository.erpdb.dao.ErpFunUserManageRangeMapper;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.homepage.param.GetStaffScoreDetailParam;
import com.myfun.erpWeb.homepage.param.UserScoreParam;
import com.myfun.erpWeb.homepage.vo.AppScoreCountDto;
import com.myfun.erpWeb.homepage.vo.ScoreCountRankDto;
import com.myfun.erpWeb.homepage.vo.ScoreCountRankListDto;
import com.myfun.erpWeb.homepage.vo.ScoreDynamicOfHalfAYearVo;
import com.myfun.erpWeb.homepage.vo.StaffScoreDetailVo;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.reportdb.dao.ReportFunUserMonthScoreMapper;
import com.myfun.repository.reportdb.dao.ReportFunUserScoreRecordMapper;
import com.myfun.repository.reportdb.po.ReportFunUserMonthScore;
import com.myfun.repository.reportdb.po.ReportFunUserMonthScoreExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "用户积分")
@Controller
@RequestMapping("/userScore")
public class UserScoreRecordController extends BaseController {
	@Autowired
	ReportFunUserScoreRecordMapper reportFunUserScoreRecordMapper;
	@Autowired
	ReportFunUserMonthScoreMapper reportFunUserMonthScoreMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;

	@ApiOperation("积分月均和日均统计,需求=8536，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppScoreCountDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getScoreCountAvg")
	public ResponseJson getScoreCountAvg(@RequestBody UserScoreParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		if (operator.isSwitchCompLogin()) {
			cityId = operator.getSelfCityId();
			compId = operator.getSelfCompId();
		}
		Integer archiveId = operator.getArchiveId();
		if (operator.newOrganizationType()) {
			AppScoreCountDto result = new AppScoreCountDto();

			//先查询个人的
			Date startTime = this.getBeforeDateByDay(7);
			double userDayCount = reportFunUserScoreRecordMapper.countScoreByDate(cityId, compId, archiveId, startTime, null);
			result.setCurrentUserScoreAvgCount(NumberHelper.formatNumber(userDayCount / 7, NumberHelper.NUMBER_IN_1));

			List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, operator.getUserId());
			if (userManageRange.size() == 0) {
				return ErpResponseJson.ok(result);
			}
			Set<Integer> rangeIdSet = new HashSet<>();
			List<ErpOrganizationVO> erpOrganizationVOs = new ArrayList<>();
			//统计范围内人数
			Integer userCount = 0;
			if(Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(operator.getUserPosition())) {
				userCount = erpFunUsersMapper.getAgentOnlineCount(cityId,compId, null);
			}else {
				rangeIdSet = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toSet()));
				userCount = erpFunUsersMapper.getUserCountByRangeIdAndColumnNewOrg(cityId,compId, rangeIdSet);
				erpOrganizationVOs = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, rangeIdSet);
			}

			if (userCount == null || userCount <= 0) {
				result.setDayScoreAvgCount("0");
				result.setMonthScoreAvgCount("0");
				return ErpResponseJson.ok(result);
			}

			//organizationIds.add(Integer.parseInt(rangeIds));
			double compdayCount = reportFunUserScoreRecordMapper.countScoreByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			result.setDayScoreAvgCount(NumberHelper.formatNumber(compdayCount / (7 * userCount), NumberHelper.NUMBER_IN_1));
			//先查询前11个月的
			startTime = this.getBeforeDateByMonth(11);
			double compMonthCount = reportFunUserMonthScoreMapper.countScoreBycCompDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			//查询本月
			startTime = getBeforeDateByMonth(0);
			double currentMonthCount = reportFunUserScoreRecordMapper.countScoreByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			result.setMonthScoreAvgCount(NumberHelper.formatNumber((compMonthCount + currentMonthCount) / (12 * userCount), NumberHelper.NUMBER_IN_1));
			
			return ErpResponseJson.ok(result);
		} else {
			
			AppScoreCountDto result = new AppScoreCountDto();
			
//			Integer cityId = operator.getCityId();
//			Integer compId = operator.getCompId();
//			Integer archiveId = operator.getArchiveId();
			Integer rangeType = param.getRangeType();
			String rangeIds = param.getRangeIds();
			if (rangeType != null && rangeType == 1) {
				rangeIds = compId.toString();
			}
			
			//先查询个人的
			Date startTime = this.getBeforeDateByDay(7);
			double userDayCount = reportFunUserScoreRecordMapper.countScoreByDate(cityId, compId, archiveId, startTime, null);
			result.setCurrentUserScoreAvgCount(NumberHelper.formatNumber(userDayCount / 7, NumberHelper.NUMBER_IN_1));
			if (StringUtils.isBlank(rangeIds) || rangeType == null || rangeType == 6) {
				return ErpResponseJson.ok(result);
			}
			String rangeColumn = getRangeColumnByRangeType(rangeType);
			//统计范围内人数
			Integer userCount=erpFunUsersMapper.getUserCountByRangeIdAndColumn(cityId,compId,rangeColumn,rangeIds);
			if (userCount == null || userCount <= 0) {
				result.setDayScoreAvgCount("0");
				result.setMonthScoreAvgCount("0");
				return ErpResponseJson.ok(result);
			}
			if (rangeType == 1) {//公司
				double compdayCount = reportFunUserScoreRecordMapper.countScoreByDate(cityId, compId, null, startTime, null);
				result.setDayScoreAvgCount(NumberHelper.formatNumber(compdayCount / (7 * userCount), NumberHelper.NUMBER_IN_1));
				//先查询前11个月的
				startTime = this.getBeforeDateByMonth(11);
				double compMonthCount = reportFunUserMonthScoreMapper.countScoreBycCompDate(cityId, compId, startTime, null);
				//查询本月
				startTime = getBeforeDateByMonth(0);
				double currentMonthCount = reportFunUserScoreRecordMapper.countScoreByDate(cityId, compId, null, startTime, null);
				result.setMonthScoreAvgCount(NumberHelper.formatNumber((compMonthCount + currentMonthCount) / (12 * userCount), NumberHelper.NUMBER_IN_1));
			} else {
				double compdayCount = reportFunUserScoreRecordMapper.countScoreByDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
				result.setDayScoreAvgCount(NumberHelper.formatNumber(compdayCount / (7 * userCount), NumberHelper.NUMBER_IN_1));
				//先查询前11个月的
				startTime = this.getBeforeDateByMonth(11);
				double compMonthCount = reportFunUserMonthScoreMapper.countScoreBycCompDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
				//查询本月
				startTime = getBeforeDateByMonth(0);
				double currentMonthCount = reportFunUserScoreRecordMapper.countScoreByDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
				result.setMonthScoreAvgCount(NumberHelper.formatNumber((compMonthCount + currentMonthCount) / (12 * userCount), NumberHelper.NUMBER_IN_1));
			}
			return ErpResponseJson.ok(result);
		}
		
	}

	@ApiOperation("员工积分排行,需求=8536，作者=邓永洪")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ScoreCountRankListDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getScoreCountRank")
	public ResponseJson getScoreCountRank(@RequestBody UserScoreParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ScoreCountRankListDto scoreCountRankListDto=new ScoreCountRankListDto();
		
		Boolean newOrganizationType = operator.newOrganizationType();
		if(newOrganizationType) {
			List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, operator.getUserId());
			if (userManageRange.size() == 0) {
				return ErpResponseJson.ok(scoreCountRankListDto);
			}
			Set<Integer> rangeIdSet = new HashSet<>();
			List<ErpOrganizationVO> erpOrganizationVOs = new ArrayList<>();
			//统计范围内人数
			//Integer userCount = 0;
			List<ErpFunUsers> funUsersList;
			if(Const.DIC_ROLE_NAME_GENERAL_MANAGER.equals(operator.getUserPosition())) {
				//userCount = erpFunUsersMapper.getAgentOnlineCount(cityId,compId, null);
				funUsersList = erpFunUsersMapper.getUserListByRangeColumnNewOrg(cityId, compId, null);
			}else {
				rangeIdSet = userManageRange.stream().collect(Collectors.mapping(val -> val.getRangeId(), Collectors.toSet()));
				//userCount = erpFunUsersMapper.getUserCountByRangeIdAndColumnNewOrg(cityId,compId, rangeIdSet);
				funUsersList = erpFunUsersMapper.getUserListByRangeColumnNewOrg(cityId, compId, rangeIdSet);
				erpOrganizationVOs = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, rangeIdSet);
			}

//			if (userCount == null || userCount <= 0) {
//				return ErpResponseJson.ok(scoreCountRankListDto);
//			}

			//List<ErpFunUsers> funUsersList = erpFunUsersMapper.getUserListByRangeColumnNewOrg(cityId, compId, erpOrganizationVOs, param.getRangeIds());
			if (CollectionUtils.isEmpty(funUsersList)) {
				scoreCountRankListDto.setScoreCountRankDtoList(new ArrayList<>());
				ErpResponseJson.ok(scoreCountRankListDto);
			}
			//查询7天总积分
			Date startTime = this.getBeforeDateByDay(7);
			List<Map<String, Object>> dayCountMapList = reportFunUserScoreRecordMapper.countCompUserScoreListByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			Map<Integer, Map<String, Object>> dayCountMap = dayCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询前11个月
			startTime = getBeforeDateByMonth(11);
			List<Map<String, Object>> monthCountMapList = reportFunUserMonthScoreMapper.countCompUserScoreListByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			Map<Integer, Map<String, Object>> monthCountMap = monthCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询当前月
			startTime = getBeforeDateByMonth(0);
			List<Map<String, Object>> currentMonthCountMapList = reportFunUserScoreRecordMapper.countCompUserScoreListByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, startTime);
			Map<Integer, Map<String, Object>> currentMonthCountMap = currentMonthCountMapList.stream().
					collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询总积分,无时间限制
			List<Map<String, Object>> totalCountList = reportFunUserMonthScoreMapper.countCompUserScoreListByDateRangeNewOrg(cityId, compId, erpOrganizationVOs, null);
			Map<Integer, Map<String, Object>> totalCountMap = totalCountList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			List<ScoreCountRankDto> resultList = new ArrayList<>();
			for (ErpFunUsers funUsers : funUsersList) {
				ScoreCountRankDto scoreCountRankDto = new ScoreCountRankDto();
				scoreCountRankDto.setUserName(funUsers.getUserName());
				scoreCountRankDto.setArchiveId(funUsers.getArchiveId());
				scoreCountRankDto.setUserId(funUsers.getUserId());
				Integer usersArchiveId = funUsers.getArchiveId();
				Map<String, Object> dayMap = dayCountMap.get(usersArchiveId);
				//日均分
				if (dayMap != null) {
					BigDecimal scoreCount = (BigDecimal) dayMap.get("scoreCount");
					scoreCountRankDto.setDayScoreAvgCount(NumberHelper.formatNumber(scoreCount.doubleValue() / 7, NumberHelper.NUMBER_IN_1));
				} else {
					scoreCountRankDto.setDayScoreAvgCount("0");
				}
				//月均分
				double monthScoreTotal = 0d;
				Map<String, Object> monthMap = monthCountMap.get(usersArchiveId);
				Map<String, Object> currentMonthMap = currentMonthCountMap.get(usersArchiveId);
				if (monthMap != null) {
					monthScoreTotal += ((BigDecimal) monthMap.get("scoreCount")).doubleValue();
				}
				scoreCountRankDto.setCurrentMonthScoreCount("0");
				if (currentMonthMap != null) {
					monthScoreTotal += ((BigDecimal) currentMonthMap.get("scoreCount")).doubleValue();
					//本月积分
					scoreCountRankDto.setCurrentMonthScoreCount((currentMonthMap.get("scoreCount")).toString());
				}
				scoreCountRankDto.setMonthScoreAvgCount(NumberHelper.formatNumber(monthScoreTotal / 12, NumberHelper.NUMBER_IN_1));
				//总积分-以前所有月份+当前月
				Map<String, Object> totalMap = totalCountMap.get(usersArchiveId);
				double totalScore = 0d;
				if (totalMap != null) {
					totalScore += ((BigDecimal) totalMap.get("scoreCount")).doubleValue();
				}
				if (currentMonthMap != null) {
					totalScore += ((BigDecimal) currentMonthMap.get("scoreCount")).doubleValue();
				}
				scoreCountRankDto.setTotalScoreCount(NumberHelper.formatNumber(totalScore, NumberHelper.NUMBER_IN_1));
				resultList.add(scoreCountRankDto);
			}
			scoreCountRankListDto.setScoreCountRankDtoList(resultList);
			
		} else {
			String rangeIds = param.getRangeIds();
			String rangeColumn = getRangeColumnByRangeType(param.getRangeType());
			
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.getUserListByRangeColumn(cityId, compId, rangeColumn, param.getRangeIds());
			if (CollectionUtils.isEmpty(funUsersList)) {
				scoreCountRankListDto.setScoreCountRankDtoList(new ArrayList<>());
				ErpResponseJson.ok(scoreCountRankListDto);
			}
			//查询7天总积分
			Date startTime = this.getBeforeDateByDay(7);
			List<Map<String, Object>> dayCountMapList = reportFunUserScoreRecordMapper.countCompUserScoreListByDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
			Map<Integer, Map<String, Object>> dayCountMap = dayCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询前11个月
			startTime = getBeforeDateByMonth(11);
			List<Map<String, Object>> monthCountMapList = reportFunUserMonthScoreMapper.
					countCompUserScoreListByDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
			Map<Integer, Map<String, Object>> monthCountMap = monthCountMapList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询当前月
			startTime = getBeforeDateByMonth(0);
			List<Map<String, Object>> currentMonthCountMapList = reportFunUserScoreRecordMapper
					.countCompUserScoreListByDateRange(cityId, compId, rangeColumn, rangeIds, startTime);
			Map<Integer, Map<String, Object>> currentMonthCountMap = currentMonthCountMapList.stream().
					collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			//查询总积分,无时间限制
			List<Map<String, Object>> totalCountList = reportFunUserMonthScoreMapper
					.countCompUserScoreListByDateRange(cityId, compId, rangeColumn, rangeIds, null);
			Map<Integer, Map<String, Object>> totalCountMap = totalCountList.stream().collect(Collectors.toMap(map -> (Integer) map.get("archiveId"), val -> val));
			List<ScoreCountRankDto> resultList = new ArrayList<>();
			for (ErpFunUsers funUsers : funUsersList) {
				ScoreCountRankDto scoreCountRankDto = new ScoreCountRankDto();
				scoreCountRankDto.setUserName(funUsers.getUserName());
				scoreCountRankDto.setArchiveId(funUsers.getArchiveId());
				scoreCountRankDto.setUserId(funUsers.getUserId());
				Integer usersArchiveId = funUsers.getArchiveId();
				Map<String, Object> dayMap = dayCountMap.get(usersArchiveId);
				//日均分
				if (dayMap != null) {
					BigDecimal scoreCount = (BigDecimal) dayMap.get("scoreCount");
					scoreCountRankDto.setDayScoreAvgCount(NumberHelper.formatNumber(scoreCount.doubleValue() / 7, NumberHelper.NUMBER_IN_1));
				} else {
					scoreCountRankDto.setDayScoreAvgCount("0");
				}
				//月均分
				double monthScoreTotal = 0d;
				Map<String, Object> monthMap = monthCountMap.get(usersArchiveId);
				Map<String, Object> currentMonthMap = currentMonthCountMap.get(usersArchiveId);
				if (monthMap != null) {
					monthScoreTotal += ((BigDecimal) monthMap.get("scoreCount")).doubleValue();
				}
				scoreCountRankDto.setCurrentMonthScoreCount("0");
				if (currentMonthMap != null) {
					monthScoreTotal += ((BigDecimal) currentMonthMap.get("scoreCount")).doubleValue();
					//本月积分
					scoreCountRankDto.setCurrentMonthScoreCount((currentMonthMap.get("scoreCount")).toString());
				}
				scoreCountRankDto.setMonthScoreAvgCount(NumberHelper.formatNumber(monthScoreTotal / 12, NumberHelper.NUMBER_IN_1));
				//总积分-以前所有月份+当前月
				Map<String, Object> totalMap = totalCountMap.get(usersArchiveId);
				double totalScore = 0d;
				if (totalMap != null) {
					totalScore += ((BigDecimal) totalMap.get("scoreCount")).doubleValue();
				}
				if (currentMonthMap != null) {
					totalScore += ((BigDecimal) currentMonthMap.get("scoreCount")).doubleValue();
				}
				scoreCountRankDto.setTotalScoreCount(NumberHelper.formatNumber(totalScore, NumberHelper.NUMBER_IN_1));
				resultList.add(scoreCountRankDto);
			}
			scoreCountRankListDto.setScoreCountRankDtoList(resultList);
		}
		return ErpResponseJson.ok(scoreCountRankListDto);
	}
	
	@ApiOperation(value = "员工工作积分详情,需求:8535,作者:陈峰")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = StaffScoreDetailVo.class)})
	@ResponseBody
	@PostMapping(value = "/getStaffScoreDetail")
	public ResponseJson getStaffScoreDetail(@RequestBody @Valid GetStaffScoreDetailParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer archiveId = param.getArchiveId();
		StaffScoreDetailVo staffScoreDetailVo = new StaffScoreDetailVo();
		//工作积分总额
		Double staffAllScore = reportFunUserScoreRecordMapper.selectStaffAllOrMeanScore(compId, cityId, archiveId, this.getBeforeDateByMonth(0), null);
		staffScoreDetailVo.setStaffAllScore(NumberHelper.formatNumber((staffAllScore != null ? staffAllScore : 0), NumberHelper.NUMBER_IN_1));
		//本月的12个月月均分
		Double currentMonthAndElevenMonthScore = reportFunUserScoreRecordMapper.selectStaffAllOrMeanScore(compId, cityId, archiveId, this.getBeforeDateByMonth(0), this.getBeforeDateByMonth(11));
		staffScoreDetailVo.setCurrentMonthScore(NumberHelper.formatNumber((currentMonthAndElevenMonthScore != null ? currentMonthAndElevenMonthScore / 12 : 0), NumberHelper.NUMBER_IN_1));
		//上月的12个月月均分
		ReportFunUserMonthScoreExample example = new ReportFunUserMonthScoreExample();
		example.setOrderByClause("CREATE_TIME ASC");
		example.createCriteria().andCompIdEqualTo(compId).andCityIdEqualTo(cityId).andArchiveIdEqualTo(archiveId).andCreateTimeGreaterThanOrEqualTo(this.getBeforeDateByMonth(12));
		List<ReportFunUserMonthScore> reportFunUserMonthScoreList = reportFunUserMonthScoreMapper.selectByExample(example);
		List<ScoreDynamicOfHalfAYearVo> list = new ArrayList<ScoreDynamicOfHalfAYearVo>();
		double twelveMonthlongMeanScore = 0;
		if (reportFunUserMonthScoreList.size() > 0) {
			for (ReportFunUserMonthScore score : reportFunUserMonthScoreList) {
				double monthTotalAmount = score.getMonthTotalAmount() != null ? score.getMonthTotalAmount().doubleValue() : 0;
				twelveMonthlongMeanScore += monthTotalAmount;
				ScoreDynamicOfHalfAYearVo scoreDynamicOfHalfAYearVo = new ScoreDynamicOfHalfAYearVo();
				scoreDynamicOfHalfAYearVo.setMonth(this.getMonthByDate(score.getCreateTime()));
				scoreDynamicOfHalfAYearVo.setScore(NumberHelper.formatNumber(monthTotalAmount, NumberHelper.NUMBER_IN_1));
				list.add(scoreDynamicOfHalfAYearVo);
			}
			Collections.sort(list, (a, b) -> a.getMonth().compareTo(b.getMonth()));
		}
		staffScoreDetailVo.setPastMonthScore(NumberHelper.formatNumber(twelveMonthlongMeanScore / 12, NumberHelper.NUMBER_IN_1));
		//加入当前月的积分信息
		ScoreDynamicOfHalfAYearVo scoreDynamicOfHalfAYearVo = new ScoreDynamicOfHalfAYearVo();
		scoreDynamicOfHalfAYearVo.setMonth(this.getMonthByDate(DateTimeHelper.getSystemDate()));
		Double score = reportFunUserScoreRecordMapper.selectCurrentMonthScore(compId, cityId, archiveId, this.getBeforeDateByMonth(0));
		scoreDynamicOfHalfAYearVo.setScore(NumberHelper.formatNumber((score != null ? score : 0), NumberHelper.NUMBER_IN_1));
		list.add(scoreDynamicOfHalfAYearVo);
		if (list.size() >= 6) {
			staffScoreDetailVo.setList(new ArrayList<ScoreDynamicOfHalfAYearVo>(list.subList(list.size() - 6, list.size())));
		} else {
			for (int i = 0; i <= 6; i++) {
				ScoreDynamicOfHalfAYearVo newScoreDynamicOfHalfAYearVo = new ScoreDynamicOfHalfAYearVo();
				newScoreDynamicOfHalfAYearVo.setScore("0");
				ScoreDynamicOfHalfAYearVo firstScoreDynamicOfHalfAYearVo = list.get(0);
				Integer month = firstScoreDynamicOfHalfAYearVo.getMonth();
				if (Objects.equals(month, 1)) {
					newScoreDynamicOfHalfAYearVo.setMonth(12);
				} else {
					newScoreDynamicOfHalfAYearVo.setMonth(month - 1);
				}
				list.add(0, newScoreDynamicOfHalfAYearVo);
				if (list.size() >= 6) {
					break;
				}
			}
			staffScoreDetailVo.setList(list);
		}
		return ErpResponseJson.ok(staffScoreDetailVo);
	}

	private Date getBeforeDateByDay(Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -day);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		return date;
	}
	private Date getBeforeDateByMonth(Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH,-month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		return date;
	}

	private String getRangeColumnByRangeType(Integer rangeType) {
		String column = "";
		if (rangeType == 1) {
			column = "COMP_ID";
		} else if (rangeType == 2) {
			column = "AREA_ID";
		} else if (rangeType == 3) {
			column = "REG_ID";
		} else if (rangeType == 4) {
			column = "DEPT_ID";
		} else if (rangeType == 5) {
			column = "GR_ID";
		}else if (rangeType == 6) {
			column = "ARCHIVE_ID";
		}
		return column;
	}
	private int getMonthByDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}


	public static void main(String[] args) {
//		System.out.println(DateTimeHelper.formatDateTimetoString(getBeforeDateByDay(7)));
	}
}
package com.myfun.erpWeb.usercenter;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDemandCenterDepositMapper;
import com.myfun.repository.admindb.dao.AdminFunScoreRecoredMapper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

/**
 * 个人中心跑分相关接口
 * @author 张宏利
 * @since 2017年3月21日
 */
@Api(tags ="个人中心跑分模块")
@Controller
@RequestMapping("/usercenter/userScore")
public class UserRunScoreController extends BaseController{
	
	@Autowired
	AdminFunScoreRecoredMapper adminFunScoreRecoredMapper;
	@Autowired
	AdminFunDemandCenterDepositMapper adminFunDemandCenterDepositMapper;

	/**
	 * 获取个人跑分数据
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @return
	 */
	@ApiOperation("获取个人跑分数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getScoreForSelf")
	public ErpResponseJson getScoreForSelf(@Valid @RequestBody BaseMapParam param) {
		String[] months = DateTimeHelper.getBetweenMonth(new Date());
		Map<String, Object> scoreMap = adminFunScoreRecoredMapper.getSelfScore(getOperator().getCityId(), getOperator().getArchiveId(), months[0], months[1]);
		if(scoreMap == null) {
			scoreMap = new HashMap<>();
		}
		Integer totalScore = StringUtil.parseInteger(scoreMap.get("totalScore"), 0);
		Map<String, Object> rankingMap = adminFunScoreRecoredMapper.getSelfRanking(getOperator().getCityId(), totalScore, months[0], months[1]);
		scoreMap.putAll(rankingMap);
		List<Map<String, Object>> resultList = new LinkedList<>();
		resultList.add(scoreMap);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 总排行榜 
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @return
	 */
	@ApiOperation("总排行榜 ")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getScoreTotalRanking")
	public ErpResponseJson getScoreTotalRanking(@Valid @RequestBody BaseMapParam param) {
		String[] months = DateTimeHelper.getBetweenMonth(new Date());
		List<Map<String, Object>> resultList = adminFunScoreRecoredMapper.getScoreTotalRanking(
				getOperator().getCityId(), months[0], months[1], null, null);
		for (Map<String, Object> map : resultList) {
			if(map.get("bbsPhoto") != null) {
				map.put("userPhoto", CommonUtil.getBbsPhoto(String.valueOf(map.get("bbsPhoto"))));
			}
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 新用户排行榜
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @return
	 */
	@ApiOperation("新用户排行榜")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getScoreNewUserRanking")
	public ErpResponseJson getScoreNewUserRanking(@Valid @RequestBody BaseMapParam param) {
		// 用户创建时间在一个月以内的
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -3);
		String[] months = DateTimeHelper.getBetweenMonth(new Date());
		List<Map<String, Object>> resultList = adminFunScoreRecoredMapper.getScoreTotalRanking(
				getOperator().getCityId(), months[0], months[1], calendar.getTime(), null);
		for (Map<String, Object> map : resultList) {
			if(map.get("bbsPhoto") != null) {
				map.put("userPhoto", CommonUtil.getBbsPhoto(String.valueOf(map.get("bbsPhoto"))));
			}
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 本公司排行榜
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @return
	 */
	@ApiOperation("本公司排行榜")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getScoreCompRanking")
	public ErpResponseJson getScoreCompRanking(@Valid @RequestBody BaseMapParam param) {
		String[] months = DateTimeHelper.getBetweenMonth(new Date());
		List<Map<String, Object>> resultList = adminFunScoreRecoredMapper.getScoreTotalRanking(
				getOperator().getCityId(), months[0], months[1], null, getOperator().getCompNo());
		for (Map<String, Object> map : resultList) {
			if(map.get("bbsPhoto") != null) {
				// 前端用的还是userPhoto
				map.put("userPhoto", CommonUtil.getBbsPhoto(String.valueOf(map.get("bbsPhoto"))));
			}
		}
		return ErpResponseJson.ok(resultList);
	}
}


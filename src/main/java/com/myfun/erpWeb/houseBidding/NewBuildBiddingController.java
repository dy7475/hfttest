package com.myfun.erpWeb.houseBidding;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.CharEncoding;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.utils.HttpUtil;

@Controller
@RequestMapping("/newBuildBidding")
public class NewBuildBiddingController extends BaseController{
	@Override
	public Map<String, String> getParameterMap(HttpServletRequest request) {
		return super.getParameterMap(request);
	}

	/**
	 * 获取新盘顾问列表
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getNewBuildBiddingList")
	public Map<String, Object> getNewBuildBiddingList(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String,Object> newBuildBiddingList = HttpUtil.postHftMobileUrlBody(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getNewBuildList", getOperator().getArchiveId(), clientKey, param.getMap());
		return newBuildBiddingList;
	}

	/**
	 * 获取竞价详情
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getBuildBidDetail")
	public Map<String,Object> getBuildBidDetail(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String,Object> buildBidDetailMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getBuildBidDetail", getOperator().getArchiveId(), clientKey, param.getMap());
		return buildBidDetailMap;
	}

	/**
	 * 增加或修改关注楼盘
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/addBuildAttention")
	public Map<String, Object> addBuildAttention(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/addBuildAttention", getOperator().getArchiveId(), clientKey,param.getMap());
		return dataMap;
	}

	/**
	 * 提交竞价
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/createBidding")
	public Map<String,Object> createBidding(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap= HttpUtil.postHftMobileUrlBody(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/createNewSiteBuildBidding", getOperator().getArchiveId(), clientKey, param.getMap());
		return dataMap;
	}

	/**
	 * 关键字搜索
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/buildSearch")
	public Map<String,Object> buildSearch(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> map = param.getMap();
		map.put("buildKey", map.get("buildKey"));
		Map<String, Object> dataMap= HttpUtil.postHftMobileUrlBody(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getNewBuildList", getOperator().getArchiveId(), clientKey, map);
		return dataMap;
	}

	/**
	 * 排名
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getRanking")
	public Map<String, Object> getRanking(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getRanking", getOperator().getArchiveId(), clientKey,param.getMap());
		return dataMap;
	}

	/**
	 * 扣费方式
	 * @author 熊刚
	 * @since 2017年9月14日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getUseBiddingPrice")
	public Map<String, Object> getUseBiddingPrice(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getUseBiddingPrice", getOperator().getArchiveId(), clientKey, param.getMap());
		return dataMap;
	}

	/**
	 * 新房顾问增加推广介绍
	 * @author 熊刚
	 * @since 2017年9月27日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateSelfDesc")
	public Map<String, Object> updateSelfDesc(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/updateSelfDesc", getOperator().getArchiveId(), clientKey,param.getMap());
		return dataMap;
	}

	/**getBulletinList
	 * 获取关注楼盘列表
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getBuildAttention")
	public Map<String, Object> getBuildAttention(@Valid @RequestBody BaseMapParam param) throws Exception {
		String clientKey = getOperator().getClientKey();
		Map<String, Object> dataMap = HttpUtil.postHftMobileUrl(AppConfig.getHftHouseUrl() + "app/newSiteBuildBidding/getBuildAttention", getOperator().getArchiveId(), clientKey,param.getMap());
		return dataMap;
	}

	public static void main(String[] args) {
		try{
			Map<String, Object> pMap = new HashMap();
			pMap.put("buildKey","成");
			Map<String,Object> newBuildBiddingList = HttpUtil.postHftMobileUrlBody("http://172.16.140.101:8080/houseWeb/app/newSiteBuildBidding/getNewBuildList", 6700087, "a57d4ded7d47b9680d43c20da5587f59", pMap);
			System.out.println(newBuildBiddingList);
		}catch (Exception e) {

		}
	}
}

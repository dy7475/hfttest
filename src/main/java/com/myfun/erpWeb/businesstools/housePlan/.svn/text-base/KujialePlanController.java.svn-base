package com.myfun.erpWeb.businesstools.housePlan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminKjlNewCityRelaMapper;
import com.myfun.repository.admindb.po.AdminKjlNewCityRela;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 酷家乐户型图相关接口
 * @author 张宏利
 * @since 2018年3月15日
 */
@RestController
@RequestMapping(value = "/businesstools/kujialePlan", method = RequestMethod.POST)
public class KujialePlanController extends BaseController {
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	AdminKjlNewCityRelaMapper adminKjlNewCityRelaMapper;

	/**
	 * 搜索户型图
	 * @author 张宏利
	 * @since 2018年3月15日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "搜索户型图",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code =200,message = "success"))
	@RequestMapping("/getKjlFloorplanList")
	public ResponseJson getKjlFloorplanList(@RequestBody BaseMapParam param) {
		List<Map<String, String>> list = new ArrayList<>();
		String url = "http://www.kujiale.com/p/openapi/floorplan";
		String query = param.getString("queryStr");
		String areaParam =  param.getString("area");
		String roomCount =  param.getString("roomCount");
		Double areaMin = null;
		Double areaMax = null;
		Double area = StringUtil.paseDouble(areaParam, 0.0);
		if(area > 10) {
			// 最大和最小，暂定+-10平米
			areaMin = area - 10;
			areaMax = area + 10;
		}
		long timestamp = System.currentTimeMillis();
		AdminKjlNewCityRela kjlNewCityRelaPO =adminKjlNewCityRelaMapper.getKjlNewCityRelaByCityId(getOperator().getCityId());
		long cityId = 0;// 默认全国
		if(kjlNewCityRelaPO != null) {
			cityId = kjlNewCityRelaPO.getKjlCityId().longValue();
		}
		try {
			Map<String, String> map = new HashMap<>();
			map.put("appkey", AppConfig.getKjlAppKey());
			map.put("timestamp", String.valueOf(timestamp));
			map.put("sign", CommonUtil.KJL_MD5(AppConfig.getKjlAppSecret() + AppConfig.getKjlAppKey() + timestamp));
			map.put("q", query);
			// 面积参数
			if(areaMin != null && areaMax != null) {
				map.put("areaMin", String.valueOf(areaMin));
				map.put("areaMax", String.valueOf(areaMax));
			}
			if(StringUtils.isNotBlank(roomCount)) {
				map.put("roomCount", roomCount);
			}
			map.put("start", String.valueOf(param.getInteger("pageOffset") * 20));
			map.put("num", "20");
			map.put("cityid", String.valueOf(cityId));
			String resultStr = HttpUtil.get(url, param);
			list = JSON.parseObject(resultStr, new TypeReference<List<Map<String, String>>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ErpResponseJson.ok(list);
	}

}

package com.myfun.erpWeb.businesstools.pageDispatch;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.ThreeZhiyeDesUtil;


/**
 * 美联页面跳转
 * @author Administrator
 *
 */
@RequestMapping(value="/pageDispatch")
@Controller
public class PageDispatchController extends BaseController{
	@Autowired
	private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	//跳转类型
	private static final Map<String, String> dispathMap;
	static{
		dispathMap = new HashMap<String, String>();
		//楼盘导入规则资料模板下载页面,说明一下,如果希望返回取得文件使用该名字,参考该写法
		dispathMap.put("importBuildTemplate", "forward:/statics/images/youjiaImage/buildTemplate.xlsx#fileName=楼盘资料模板.xlsx");
		// 酷家乐编辑和修改页面
		dispathMap.put("getKjlPage", "/statics/kujiale/kujiale.jsp");
	}
	
	/**
	 * 获取转发页面
	 * @detail [2020-03-11]	陈峰	返回vr展示地址	bugid#0  问题来自测试何银
	 * @param request
	 * @param response
	 * @param dispatchType 需要调转的类型
	 * @return
	 * /dispatch.jsp?dispatchType=drawHouseImage&CLIENTKEY=
	 */
    @RequestMapping("/dispatch")
    public String doDispatch (HttpServletRequest request, HttpServletResponse response, String dispatchType, Model model) throws Exception {
		String url = dispathMap.get(dispatchType);
    	if(url != null){
			// forward不用拼装参数，再拼装一次会造成两个参数的情况
			String[] urls = url.split("#");
			if (urls.length>1) {
				if (urls[1].startsWith("fileName")) {
					url = urls[0];
					String[] fileNameArr = urls[1].split("=");
					if(fileNameArr.length>1&&StringUtils.isNotBlank(fileNameArr[1])){
						response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileNameArr[1].getBytes("utf-8"),"iso-8859-1"));
					}
				} 
			}
			if (url.startsWith("forward:")) {
				return url;
			}
			if ("getKjlPage".equals(dispatchType)) {
				Map<String, String> kjlEditFloorplanUrl = getKjlEditFloorplanUrl(request.getParameter("PLANID"));
				model.addAttribute("KJL_URL", kjlEditFloorplanUrl.get("URL"));
				model.addAttribute("IS_CHOISE", request.getParameter("IS_CHOISE"));
				return "forward:"+url;
			}
		} else if ("buildMap".equals(dispatchType)) {
    		return getBuildMapUrl(request);
    	} else if ("zhiyeLogin".equals(dispatchType)) {
    		return getZhiyeLoginUrl(request);
    	} else if("attendanceScopePositioning".equals(dispatchType)){
    		return getAttendanceScopePositioningUrl(request);
    	} else if("onLineMap".equals(dispatchType)){
    		return getOnlineMapUrl();
    	} else if ("showPanorama720".equals(dispatchType)) {
    		return getshowPanorama720Url(request);
    	}
    	return dispatchType;
    }

    /**
     * 返回vr展示地址
     * @detail [2020-03-11]	陈峰	返回vr展示地址	bugid#0  问题来自测试何银
     * @param request
     * @return
     */
	private String getshowPanorama720Url(HttpServletRequest request) {
		Operator operator = getOperator();
		String cityId = request.getParameter("CITY_ID");
		String caseType = request.getParameter("CASE_TYPE");
		String caseId = request.getParameter("CASE_ID");
		String archiveId = request.getParameter("ARCHIVE_ID");
		String url = AppConfig.getVrShowPhpDomainUrlMl() + "vr/index/indexNew?SOURCE=WEB&CITY_ID=" + cityId 
				+ "&CASE_TYPE=" + caseType + "&CASE_ID=" + caseId + "&SOURCE=ERP&ARCHIVE_ID=" + archiveId;
		return "redirect:" + url;
	}

	private String getOnlineMapUrl() throws Exception {
		Operator operator = getOperator();
		AdminFunCity cacheableModelDataById = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
		String cityName = cacheableModelDataById.getcCityName();
		if(StringUtils.isNotBlank(cityName)) {
			cityName = URLEncoder.encode(cityName);
		}
		Object lng = null;
		Object lat = null;
		Integer status = 0;
		if(null != cacheableModelDataById ) {
			if(StringUtils.isNotBlank(cacheableModelDataById.getPositionX()) && StringUtils.isNotBlank(cacheableModelDataById.getPositionY())) {
				Double latDouble = Double.valueOf(cacheableModelDataById.getPositionX());
				Double lngDouble = Double.valueOf(cacheableModelDataById.getPositionY());
				Object[] objects = map_tx2bd(latDouble, lngDouble);
				if(null != objects && objects.length == 2) {
					lng = objects[0];
					lat = objects[1];
					status = 1;
				}
			}else {
				String baiduLanLat = getBaiduLanLat(cacheableModelDataById.getCityId().toString(), cacheableModelDataById.getCityName(),cacheableModelDataById.getCityName());
				JSONObject jsonObject = JSONObject.parseObject(baiduLanLat);
				status = jsonObject.getInteger("status");
				// 有错误的
				if(null == status || 0 != status) {
					// 调北京地图
					baiduLanLat = getBaiduLanLat(cacheableModelDataById.getCityId().toString(), null,cacheableModelDataById.getCityName());
					jsonObject = JSONObject.parseObject(baiduLanLat);
				}
				String geocodes = jsonObject.getString("result");
				jsonObject = JSONObject.parseObject(geocodes);
				Map<String, Object> resMap = (Map)jsonObject.get("location");
				lng = resMap.get("lng");
				lat = resMap.get("lat");
			}
		}
		return "redirect:/statics/map/qqBigMap.jsp?lng="+lng+"&lat="+lat+"&dragAble=1&status=" + status+"&cityName="+cityName;
	}

	private String getAttendanceScopePositioningUrl(HttpServletRequest request) {
		Operator operator = getOperator();
		String lat = request.getParameter("attScopeY");
		String lng = request.getParameter("attScopeX");
		String attDistance = request.getParameter("attDistance");
		attDistance = StringUtils.isNotBlank(attDistance) ? attDistance : "100";
		if (StringUtils.isBlank(lat) || StringUtils.isBlank(lng)) {
			AdminFunCity cacheableModelDataById = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
			// 定位
			String mapUrl = "http://restapi.amap.com/v3/geocode/geo";
			Map<String, String> pMap = new HashMap<>();
			pMap.put("key", "9e1443b7945384041f23a7f7a5009188");
			pMap.put("city", cacheableModelDataById.getCityName());
			pMap.put("address", cacheableModelDataById.getCityName());
			String post = HttpUtil.post(mapUrl, pMap);
			JSONObject jsonObject = JSONObject.parseObject(post);
			String geocodes = jsonObject.getString("geocodes");
			JSONArray objects = JSONObject.parseArray(geocodes);
			Object o = objects.get(0);
			jsonObject = JSONObject.parseObject(o + "");
			String location = jsonObject.getString("location");
			String[] split = location.split(",");
			lng = split[0];
			lat = split[1];
		}
		return "redirect:/statics/attendanceScope/positioning.jsp?attScopeY="+lat+"&attScopeX="+lng+"&attDistance="+attDistance;
	}

	private String getZhiyeLoginUrl(HttpServletRequest request) throws Exception {
		Operator operator = getOperator();
		Integer archiveId = operator.getArchiveId();
		String pid = "288";
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("uid", archiveId);
		paramMap.put("pid", pid);
		String encrypt = ThreeZhiyeDesUtil.aesEncrypt(JSON.toJSONString(paramMap), ThreeZhiyeDesUtil.priKey);
		encrypt = ThreeZhiyeDesUtil.bytesToHexString(StringUtil.getUtf8Byte(encrypt));
		String pkgId = request.getParameter("PKG_ID");
		if(StringUtil.isNotEmpty(pkgId)){
			return "redirect:" + AppConfig.getZyloginPage() + encrypt + "&url=package_detail.html?pkgId~" + pkgId;
		} else {
			return "redirect:" + AppConfig.getZyloginPage() + encrypt;
		}
	}

	private String getBuildMapUrl(HttpServletRequest request) throws Exception {
		// 房源详情的地图
		Operator operator = getOperator();
		String buildId = request.getParameter("BUILD_ID");
		ErpBuildingInfo modelDataByPrimaryId = erpBuildingInfoMapper.getBaseInfoByBuildId(operator.getCityId(), Integer.valueOf(buildId));
		Object lng = null;
		Object lat = null;
		AdminFunCity cacheableModelDataById = adminFunCityMapper.selectByPrimaryKey(operator.getCityId().shortValue());
		String cityName = cacheableModelDataById.getCityName();
		if(StringUtils.isNotBlank(cityName)) {
			cityName = URLEncoder.encode(cityName);
		}
		Integer status = 0;
		if(null != modelDataByPrimaryId) {
			if(StringUtils.isNotBlank(modelDataByPrimaryId.getPositionX()) && StringUtils.isNotBlank(modelDataByPrimaryId.getPositionY())) {
				Double latDouble = Double.valueOf(modelDataByPrimaryId.getPositionX());
				Double lngDouble = Double.valueOf(modelDataByPrimaryId.getPositionY());
				Object[] objects = map_tx2bd(latDouble, lngDouble);
				if(null != objects && objects.length == 2) {
					lng = objects[0];
					lat = objects[1];
					status = 1;
				}
			}else {
				String baiduLanLat = getBaiduLanLat(modelDataByPrimaryId.getCityId().toString(), modelDataByPrimaryId.getBuildAddr(),cacheableModelDataById.getCityName());
				JSONObject jsonObject = JSONObject.parseObject(baiduLanLat);
				status = jsonObject.getInteger("status");
				// 有错误的
				if(null == status || 0 != status) {
					baiduLanLat = getBaiduLanLat(modelDataByPrimaryId.getCityId().toString(), null,cacheableModelDataById.getCityName());
					jsonObject = JSONObject.parseObject(baiduLanLat);
				}
				String geocodes = jsonObject.getString("result");
				jsonObject = JSONObject.parseObject(geocodes);
				Map<String, Object> resMap = (Map)jsonObject.get("location");
				lng = resMap.get("lng");
				lat = resMap.get("lat");
			}
		}
		return "redirect:/statics/map/qqBigMap.jsp?lng="+lng+"&lat="+lat+"&dragAble=0&status="+status+"&cityName="+cityName;
	}
    
    public Map<String, String> getKjlEditFloorplanUrl(String planid){
		long timestamp = System.currentTimeMillis();
		try {
			String url = "http://www.kujiale.com/p/openapi/floorplan/"+planid+"/copy";
			Integer userId = getOperator().getArchiveId();//"5";// 
			String userName = getOperator().getUserName();//"邓丽娟";//
			String phone = getOperator().getUserMobile();//"15114014553";//
			String dest = "4";// 默认是新建户型图
			String email = "";//"123456@qq.com";//
			String ssn = "";
			String address = "";
			String avatar = "";
			Map<String, Object> param = new HashMap<>();
			if(StringUtils.isNotBlank(planid)) {
				Map<String, Object> paramGet = new HashMap<>();
				paramGet.put("appuid", userId);
				paramGet.put("appkey", AppConfig.getKjlAppKey());
				paramGet.put("timestamp", String.valueOf(timestamp));
				paramGet.put("sign", CommonUtil.KJL_MD5(AppConfig.getKjlAppSecret() + AppConfig.getKjlAppKey() + userId + timestamp));
				String myPlanid = HttpUtil.get(url, paramGet);
				dest = "2";// 编辑户型图
				param.put("planid", myPlanid);
			}
			// 登录||获取户型图编辑地址
			url = "http://www.kujiale.com/p/openapi/login";
			param.put("appkey", AppConfig.getKjlAppKey());
			param.put("timestamp", String.valueOf(timestamp));
			param.put("sign", CommonUtil.KJL_MD5(AppConfig.getKjlAppSecret() + AppConfig.getKjlAppKey() + userId + timestamp));
			param.put("appuid", userId);
			param.put("appuname", userName);
			param.put("appuphone", phone);
			param.put("appuemail", email);
			param.put("apputype", "1");// 商家的C类用户，只需要普通的体验流程
			param.put("appussn", ssn);
			param.put("appuaddr", address);
			param.put("appuavatar", avatar);
			param.put("dest", dest);
			String resultStr = HttpUtil.post(url, param);
			Map<String, String> resultMap = JSON.parseObject(resultStr, new TypeReference<Map<String, String>>() {});
			resultMap.put("URL", resultMap.get("errorMsg"));
			resultMap.put("errorCode", null);
			resultMap.put("errorMsg", null);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
	  * @Title  : 百度系
	  * @author : lcb
	  * @Time   ： 2018/8/2
	  *
	  **/
	public String getBaiduLanLat(String cityId, String address, String cityName) throws Exception {
		// 定位
		String mapUrl = "http://api.map.baidu.com/geocoder/v2/";
		Map<String, String> pMap = new HashMap<>();
		pMap.put("ak", "WGktd7uvWTFZhPlsivZAi1FwFZF0f3M2");
		pMap.put("city", cityName);
		pMap.put("address", StringUtils.isNotBlank(address) ? address : cityName);
		pMap.put("output", "json");
		String post = HttpUtil.post(mapUrl, pMap);
		return post;
	}

	public Object[] map_tx2bd(double lat, double lon){
		double bd_lat;
		double bd_lon;
		double x_pi=3.14159265358979324;
		double x = lon, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		bd_lon = z * Math.cos(theta) + 0.0065;
		bd_lat = z * Math.sin(theta) + 0.006;
		return new Object[]{bd_lon, bd_lat};
	}
}

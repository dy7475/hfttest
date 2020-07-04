package com.myfun.erpWeb.managecenter.attendance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.repository.erpdb.dao.ErpCheckInRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.cos;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.atan2;
import static java.lang.StrictMath.sin;

@Controller
@RequestMapping("/attendance")
public class AttendanceCheckMapController extends BaseController {

	@Autowired
	ErpCheckInRecordMapper erpCheckInRecordMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	@RequestMapping("/checkMap")
	public String bulletinInfo(HttpServletRequest request, Map<String, Object> paramMap, Integer checkId, Integer outId) throws Exception {
		String clientKey = getOperator().getClientKey();
		JSONArray array = new JSONArray();
		Map<String, Object> param = new HashMap<>();
		if (checkId != null) {
			param.put("queryId", checkId);
			Map<String, Object> map = HttpUtil.postHftMobileUrlBody(AppConfig.getHftMoblieUrl()+"app/checkIn/getCheckInDetail", null, clientKey, param);
			//Map<String, Object> map = HttpUtil.postHftMobileUrlBody("http://192.168.5.251:8088/mobileWeb/app/checkIn/getCheckInDetail", null, clientKey, param);
			Object errorCode = map.get("errCode");
			if (null != errorCode && !(Const.ResponseCode.SUCCESS == StringUtil.paseInteger(errorCode.toString()))) {
				throw new BusinessException(map.get("errMsg").toString());
			} else {
				array.add(map.get("data"));
			}
		} else if (outId != null) {
			param.put("queryId", outId);
			Map<String, Object> map = HttpUtil.postHftMobileUrlBody(AppConfig.getHftMoblieUrl()+"app/checkIn/getCheckInListByOutId", null, clientKey, param);
			//Map<String, Object> map = HttpUtil.postHftMobileUrlBody("http://172.16.140.108:8080/houseWeb/app/checkIn/getCheckInListByOutId", null, clientKey, param);
			Object errorCode = map.get("errCode");
			if (null != errorCode && !(Const.ResponseCode.SUCCESS == StringUtil.paseInteger(errorCode.toString()))) {
				throw new BusinessException(map.get("errMsg").toString());
			} else {
				Object data = map.get("data");
				if (data instanceof JSONArray) array = (JSONArray) data;
			}
		} else {
			throw new BusinessException("数据异常！");
		}
		// 坐标转换，百度转高德
		/*for (Object obj:array){
			JSONObject jsonObj= (JSONObject) obj;
			Double longi = jsonObj.getDouble("longi");
			Double lati = jsonObj.getDouble("lati");
			Map<String, Object> map = bd_decrypt(longi, lati);
			jsonObj.putAll(map);
		}*/
		paramMap.put("checkInRecords", array);
		return "attendance/checkMap";
	}

	/**
	 * @tag 坐标转换
	 * @author 邓永洪
	 * @since 2018/7/26
	 */
	private Map<String,Object> bd_decrypt(Double longi, Double lati) {
		double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
		double x = longi - 0.0065, y = lati - 0.006;
		double z = sqrt(x * x + y * y) - 0.00002 * sin(y * x_pi);
		double theta = atan2(y, x) - 0.000003 * cos(x * x_pi);
		//return new LngLat( dataDigit(6,z * cos(theta)),dataDigit(6,z * sin(theta)));
		longi = dataDigit(6, z * cos(theta));
		lati = dataDigit(6, z * sin(theta));
		Map<String,Object> retMap=new HashMap<>();
		retMap.put("longi",longi);
		retMap.put("lati",lati);
		return retMap;
	}

	private double dataDigit(int digit, double in) {
		return new BigDecimal(in).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}

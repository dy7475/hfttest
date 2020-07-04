package com.myfun.erpWeb.managecenter.aliReservation;

import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ChangeAttendanceResultParam;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceGroupParam;
import com.myfun.repository.erpdb.po.*;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class AliReservationControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.175:8080/erpWeb",
				"http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "17180493881");
	}

	/**
	 * @Title 班次列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param keyWords 关键字查询
	 **/
	@Test
	public void getAttendanceClassList() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("pageOffset", "1");
		param.put("pageRows", "50");
		param.put("deptId", "892130");
		param.put("startTime", "2018-06-06 18:30:00.000");
		param.put("endTime", "2018-06-06 18:30:00.000");
		param.put("userId", "20321144");
		param.put("grId", "1");
		System.out.println(postNewErp(param,"/manageCenter/aliReservation/getReservationList"));
	}


}

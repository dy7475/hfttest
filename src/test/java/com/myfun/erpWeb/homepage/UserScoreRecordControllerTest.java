package com.myfun.erpWeb.homepage;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.homepage.param.GetStaffScoreDetailParam;
import com.myfun.erpWeb.homepage.param.UserScoreParam;
import org.junit.Before;
import org.junit.Test;

public class UserScoreRecordControllerTest extends BaseTestController {
	@Before
	public void init(){

		//init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "670483", "13562854326");
		//init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "8", "17800000009");
//		init("http://192.168.5.145:8080/erpWeb", "http://172.16.140.108:8080/hftWebService/web/api/authentication/per.do", "8", "17800000009");
		init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281168", "18802889999");
	}

	@Test
	public void getScoreCountAvg() throws Exception {
		UserScoreParam param=new UserScoreParam();
		param.setRangeIds("18396");//204923,204924,204925
		param.setRangeType(2);//7
		System.out.println(postNewErp(param, "/userScore/getScoreCountAvg"));
	}

	@Test
	public void getScoreCountRank() throws Exception {
		UserScoreParam param=new UserScoreParam();
		param.setRangeIds("18396");//670483
		param.setRangeType(6);
		System.out.println(postNewErp(param, "/userScore/getScoreCountRank"));
	}

	/**
	 * 员工工作积分详情测试
	 * @throws Exception
	 */
	@Test
	public void getStaffScoreDetailTest() throws Exception {
		GetStaffScoreDetailParam param = new GetStaffScoreDetailParam();
		param.setArchiveId(670452);
		System.out.println(postNewErp(param, "/userScore/getStaffScoreDetail"));
	}
}

package com.myfun.erpWeb.businesstools.zhiye;

import com.myfun.utils.PhoneUtil;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.AdminZhiYeViewLogParam;

public class ZhiYeControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}
	
	/**
	 * 视频播放OTO和VIP判断测试
	 * @author 何传强
	 * @since 2017年6月20日
	 * @throws Exception
	 */
	@Test
	public void mediaPlay() throws Exception{
		AdminZhiYeViewLogParam param = new AdminZhiYeViewLogParam();
		param.setMediaId("32432234");
		System.err.println(postNewErp(param, "/businesstools/zhiye/validateUser"));
	}
	public void paymentForPlay() throws Exception {
		AdminZhiYeViewLogParam param = new AdminZhiYeViewLogParam();
		param.setMediaId("32432234");
		System.err.println(postNewErp(param, "/businesstools/zhiye/paymentForPlay"));
	}
}

package com.myfun.erpWeb.noticeInfogoodNews;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class DealBulletControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "123456", "17799887766");
	}

	/**
	 * 发布
	 * @author 熊刚
	 * @since 2017年6月27日
	 * @throws Exception
	 */
	@Test
	public void updateReleaseStatus() throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("releaseStatus", "1");
		paramMap.put("bulletId", "1515328,1515327");
		System.out.println(postNewErp(paramMap,"noticeInfo/goodNews/updateReleaseStatus"));
	}
	
	/**
	 * 获取列表
	 * @author 熊刚
	 * @since 2017年6月27日
	 * @throws Exception
	 */
	@Test
	public void getDealBulletList() throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userType", "SIGN_USER_ID");
		paramMap.put("startTime", "2015-06-05");
		paramMap.put("endTime", "2015-06-30");
		paramMap.put("contractNo", "");
		System.out.println(postNewErp(paramMap,"noticeInfo/goodNews/getDealBulletList"));
	}
	
	/**
	 * 获取详情 
	 * @author 熊刚
	 * @since 2017年6月29日
	 * @throws Exception
	 */
	@Test
	public void getGoodNewsHtmlContent() throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bulletId","1515328");
		System.out.println(postNewErp(paramMap,"noticeInfo/goodNews/getGoodNewsHtmlContent"));
	}
	
	/**
	 * 保存喜报
	 * @author 熊刚
	 * @since 2017年6月29日
	 * @throws Exception
	 */
	@Test
	public void updateGoodNewsHtmlContent() throws Exception{
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("bulletId","1515328");
		paramMap.put("bulletContent","<p style='font-size:25px;line-height: 40px;color:#910000;font-family:'微软雅黑''>恭喜<br/>2017年6月5日 高新区中和镇签单报喜<br/><br/>签约人员：<br/> 城北1片区 小宏利 圆圆<br/></p>");
		paramMap.put("newsBackUrl","images/goodNews/02.png");
		System.out.println(postNewErp(paramMap,"noticeInfo/goodNews/updateGoodNewsHtmlContent"));
	}
	
}

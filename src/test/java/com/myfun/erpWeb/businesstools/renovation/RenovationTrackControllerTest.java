package com.myfun.erpWeb.businesstools.renovation;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.utils.DateTimeHelper;

public class RenovationTrackControllerTest extends BaseTestController{

	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}

	/**
	 * 删除装修客户附件资料
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void createTrack() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("id", 3);
		param.setInteger("trackType", 2);
		param.setString("lastTrackContent", "兰雪松专用跟进");
		param.setInteger("isImmediate", 1);
		param.setString("warmTime", DateTimeHelper.formatDateTimetoString(new Date()));
		param.setInteger("warmedUsers", 20322065);
		param.setString("warmContent", "兰雪松测试");
		System.out.println(postNewErp(param,"renovation/createTrack"));
	}
	
	/**
	 * 删除装修客户附件资料
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void getTrackList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("id", 3);
		System.out.println(postNewErp(param,"renovation/getTrackList"));
	}
	/**
	 * 获取装修客户提醒列表
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月27日
	 */
	@Test
	public void getWarnList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("id", 3);
		System.out.println(postNewErp(param,"renovation/getWarnList"));
	}
}

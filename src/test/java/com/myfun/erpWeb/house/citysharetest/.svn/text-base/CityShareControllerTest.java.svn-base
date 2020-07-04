package com.myfun.erpWeb.house.citysharetest;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.service.business.admindb.bean.param.CityshareBorkerComplaintParam;

public class CityShareControllerTest extends BaseTestController{

	@Before
	public void init(){
		init("http://192.168.5.173:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
	}
	
	/**
	 * 城市公盘写投诉
	 * @author 朱科
	 * @since 2018年4月9日
	 * @return
	 */
	@Test
	public void createCityshareBorkerComplain() throws Exception{
		CityshareBorkerComplaintParam param = new CityshareBorkerComplaintParam();
		System.out.println(postNewErp(param,"cityShare/createCityshareBorkerComplain"));
	}
	
	/**
	 * 大公盘获取投诉列表
	 * @author 朱科
	 * @since 2018年4月10日
	 * @return
	 */
	@Test
	public void getCityshareHomeComplaintList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("shareHouseId", 903);
		System.out.println(postNewErp(param,"cityShare/getCityshareHomeComplaintList"));
	}
	
	/**
	 * 获取经纪人电话
	 * @author 朱科
	 * @since 2018年4月10日
	 * @return
	 */
	@Test
	public void getHouseShareMobile() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("shareHouseId", 3909);
		System.out.println(postNewErp(param,"cityShare/getHouseShareMobile"));
	}
}

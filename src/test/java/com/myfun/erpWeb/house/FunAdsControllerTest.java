package com.myfun.erpWeb.house;
import org.junit.Before;
import org.junit.Test;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.FunAdsParam;

public class FunAdsControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.179:8080/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
	}
	/**
	 * 点亮广告房源
	 * @author 熊刚
	 * @throws Exception 
	 * @since 2017年6月17日
	 */
	@Test
	public void creatFunAds() throws Exception{
		FunAdsParam param = new FunAdsParam();
		param.setAdsContent("11111");
		param.setAdsStatus(1);
		param.setCaseType(1);
		param.setUserId(20321078);
		param.setCompId(12001);
		param.setCaseId(6635637);
		param.setCaseNo("CSCD1706161837677");
		param.setRecommendPrice("1234566");
		System.out.println(postNewErp(param,"house/addFunAds"));
	}

	/**
	 * 撤销广告房源
	 * @author 熊刚
	 * @throws Exception 
	 * @since 2017年6月17日
	 */
	@Test
	public void cancelFunAds() throws Exception{
		FunAdsParam param = new FunAdsParam();
		//测试单个
		//param.setCaseId(6635441);
		param.setCaseNo("CSCD1706161837677");
		param.setRecommendPrice("1234566");
		//测试选择性
		//param.setAdsContentIds("1460,1452");
		param.setCompId(12001);
		param.setDate1("2017-06-01");
		param.setDate2("2017-06-22");
		param.setCaseType(1);
		param.setOperateType("BELONG_USER");
		System.out.println(postNewErp(param,"house/cancelFunAds"));
	}
}

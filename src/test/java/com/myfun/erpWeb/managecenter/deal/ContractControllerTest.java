package com.myfun.erpWeb.managecenter.deal;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.managecenter.constract.param.ProcessCompareLogParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class ContractControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.137:8080/erpWeb", "http://192.168.0.137:8090/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		//init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.5.186:8080/erpWeb", "http://192.168.5.186:8081/hftWebService/web/api/authentication/per.do", "506504", "18566547985");
//		init("http://192.168.5.245:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "671995", "18121913023");
		initOnlyAddr("http://192.168.5.145:8088/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1279576", "13700000137");
		
		super.setClientKey("8e0bc722dd0759f645b96a123d772a63");
	}
	/**
	 * 合同号段列表查询测试
	 * @author 何传强
	 * @since 2017年7月5日
	 * @throws Exception
	 */
	@Test
	public void getDealFunDealCodeList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("compId", "12001");
		param.put("deptID", "12001");
		param.put("userId", "20289880");
		param.put("startTime", "2017-05-01");
		param.put("endTime", "2017-07-06");
		param.put("codeNo", "dopa");
		System.err.println(postNewErp(param, "/managecenter/deal/getDealFunDealCodeList"));
	}
	/**
	 * 合同号启用和停用
	 * @author 何传强
	 * @since 2017年7月6日
	 * @throws Exception
	 */
	@Test
	public void updateDealFunDealCode() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("compId", "12001");
		param.put("deptId", "12001");
		param.put("codeId", "2137");
		param.put("status", "1");
		System.err.println(postNewErp(param, "/managecenter/deal/updateDealFunDealCode"));
	}
	/**
	 * 合同号段添加
	 * @author 何传强
	 * @since 2017年7月11日
	 * @throws Exception
	 */
	@Test
	public void createDealFunDealCode() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("compId", "12001");
		param.put("deptId", "12001");
		param.put("codeStart", "10");
		param.put("codeEnd", "20");
		param.put("codePrefix", "cp");
		param.put("dealType", "1");
		param.put("sourceDeptId", "12001");
		//param.put("len(CODE_NO)", "3");
		param.put("zeroStr", "");
		System.err.println(postNewErp(param, "/managecenter/deal/createDealFunDealCode"));
	}
	/**
	 * 合同号段详情查询
	 * @author 何传强
	 * @since 2017年7月12日
	 * @throws Exception
	 */
	@Test
	public void getDealFunDealCodeInfo() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("compId", "12001");
		param.put("deptId", "12001");
		param.put("codeId", "2133");
		System.err.println(postNewErp(param, "/managecenter/deal/getDealFunDealCodeInfo"));
	}
	
	@Test
	public void getMgrDealProcessCompareLogList() throws Exception {
		ProcessCompareLogParam param = new ProcessCompareLogParam();
		param.setRecordId(3649);
		param.setDealId(9046);
		System.err.println(postNewErp(param, "/managecenter/deal/getMgrDealProcessCompareLogList"));
	}

	/**
	 * title ：查询合同应收实付
	 * athor：lcb
	 * date  : 2017/10/26
	 */
	@Test
	public void getDealFianacList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("dealId", "6243");
		System.err.println(postNewErp(param, "/managecenter/transaction/deal/getDealFianacList"));
	}
	
	/**
	 * 成交统计-获取成交统计列表
	 * @auther 胡坤
	 * @since 2018/4/17
	 *
	 */
	@Test
	public void getMgrDealStatictisList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("dataRange", "2018-02~2018-04");
		param.put("pageRowTotal", "0");
		param.put("dateType", "SIGN_DATE");
		param.put("pageRows", "40");
		param.put("pageOffset", "1");
		System.err.println(postNewErp(param, "/managecenter/deal/getMgrDealStatictisList"));
	}
	
	/**
	 * 获取合同列表
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/8
	 * @return
	 *
	 */
	@Test
	public void getDealList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("compId", "12001");
		param.put("date", "13");
		param.put("orderBy", "SIGN_DATE DESC");
		param.put("dateType", "SIGN_DATE");
		param.put("dealType", "101");
		System.err.println(postNewErp(param, "/managerCenter/transaction/deal/getDealList"));
	}

	/**
	 * 设置合同号使用规则
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/19
	 */
	@Test
	public void updateContracNoUseRule() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("saleRentDealRepeat", "0");
		param.put("allowUnuseDealnoIsbyhand", "0");
		param.put("invalidDealnoCanUseAgain", "0");
		System.err.println(postNewErp(param, "/managecenter/deal/updateContracNoUseRule"));
	}

	/**
	 * 删除合同号段
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/19
	 */
	@Test
	public void deleteDealFunDealCode() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("codeId", "0");
		System.err.println(postNewErp(param, "/managecenter/deal/deleteDealFunDealCode"));
	}

	/**
	 * 获取单条合同信息单元测试
	 * @throws Exception
	 */
	@Test
	public void getMgrDealListOne() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("dealId", "10038");
		param.put("dealType", "101");
		param.put("isWideList", "1");
		System.err.println(postNewErp(param, "managerCenter/contract/getMgrDealListOne"));
	}

	/**
	 * @tag 合同附件删除
	 * @author 邓永洪
	 * @since 2018/6/23
	 */
	@Test
	public void updateFunDealPhotoList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("photoIdList", new Integer[]{7939,7940});

		System.err.println(postNewErp(param, "/managecenter/contract/updateFunDealPhotoList"));
	}
	
	/**
	 * 查询外成交列表
	 * @author ZangTie
	 * @since 2018年7月28日 下午2:11:23
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月28日
	 */
	@Test
	public void getMgrOutDealList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("cityId","1" );
		param.put("date","4" );
		param.put("compId","12001" );
//		param.put("regId","40143" );
		param.put("dealStatus","1" );
		param.put("dealType","101" );
//		param.put("userId","10095135" );
		System.err.println(postNewErp(param, "/managecenter/deal/getMgrOutDealList"));
	}
}

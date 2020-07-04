package com.myfun.erpWeb.managecenter.vstore;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.businesstools.builddic.param.GenerateBuildRuleByExcelParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class VStoreControlllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.200.163:8087/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do","1279618", "13408553494");
		init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281168", "18802889999");
	}
	
	/**
	 * 微店委托列表
	 * @author 何传强
	 * @since 2017年8月17日
	 * @throws Exception
	 */
	@Test
	public void getVStoreEntrustList() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("cityId", "1");
		param.put("compId", "12001");
//		param.put("serchRange", "DEPT");
		param.put("pageOffset", "1");
		param.put("pageRows", "20");
//		param.put("serchRangeId", "12001");
		param.put("caseType", "1");//委托类型
//		param.put("wtStatus", "2");//委托状态
		param.put("startTime", "2017-05-01");
		param.put("endTime", "2019-08-17");
//		param.put("isVip", "1");
		System.err.println(postNewErp(param, "/openApi/vStore/getVStoreEntrustList"));
	}
	
	/**
	 * 出租出售详情
	 * @author 何传强
	 * @since 2017年8月21日
	 * @throws Exception
	 */
	@Test
	public void getSaleOrLeaseDetaile() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("caseId", "335");//出售用105测试 出租用265测试  
		param.put("caseType", "1");//委托类型
		System.err.println(postNewErp(param, "/manageCenter/vStore/getSaleOrLeaseDetaile"));
	}
	/**
	 * 求租求购详情
	 * @author 何传强
	 * @since 2017年8月21日
	 * @throws Exception
	 */
	@Test
	public void getBuyOrRentDetaile() throws Exception {
		Map<String, Object> param=new HashMap<>();
		param.put("caseId", "638");//求购用638测试 求租用406测试  
		param.put("caseType", "3");//委托类型
		System.err.println(postNewErp(param, "/manageCenter/vStore/getBuyOrRentDetaile"));
	}
	
	public static void main(String[] args) {
		//1分别用String，StringBuilder ,把String[] arr ={"1","2","3","4","5","6","7","8","9","10"};拼接出来
		String str1 = "";
		StringBuilder str2 = new StringBuilder("");
		String[] arr ={"1","2","3","4","5","6","7","8","9","10"};
		for (int i = 0; i < arr.length; i++) {
			str1 += arr[i] ;
			str2.append(arr[i]);
		}
		System.err.println(str1);
		System.err.println(str2);
		//分别用if 和switch 实现 变量 a 的值在"1","2","3","4","5","6","7","8"打印一句话
		Integer a = Integer.valueOf("1");
		if (a == 1) {
			System.err.println("我是111");
		}
		switch (a) {
		case 1:
			System.err.println("我是2222");
			break;

		default:
			break;
		}
	}
	
	/**
	 * 设置红包
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void changeRedPacketNumber() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("archiveid", "123456");
		param.put("buyMoney", "120");
		param.put("rentMoney", "20");
		System.out.println(postNewErp(param,"manageCenter/vStore/changeRedPacketNumber"));
	}
	
	/**
	 * 进入微店红包页面
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getRedPacketPage() throws Exception{
		Map<String, Object> param =new HashMap<>();
		System.out.println(postNewErp(param,"manageCenter/vStore/getRedPacketPage"));
	}
	
	/**
	 * 设置红包开启或者关闭
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void changeSwitchState() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("switchFlag", 1);
		System.out.println(postNewErp(param,"manageCenter/vStore/changeSwitchState"));
	}
	
	/**
	 * 查询员工列表
	 * @throws Exception
	 */
	@Test
	public void getEmployeeDynamicsList() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("deptId", 12001);
		param.put("userId", 20321302);
		param.put("startTime", "2016-01-12");
		param.put("endTime", "2017-07-12");
		System.out.println(postNewErp(param,"manageCenter/vStore/getEmployeeDynamicsList"));
	}
	
	/**
	 * 查询员工评价
	 * @throws Exception
	 */
	@Test
	public void getEvaluationDetailsByArchiveId() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("archiveId", 506873);
		System.out.println(postNewErp(param,"manageCenter/vStore/getEvaluationDetailsByArchiveId"));
	}

	@Test
	public void generateBuildRuleByExcel() throws Exception {
		GenerateBuildRuleByExcelParam param = new GenerateBuildRuleByExcelParam();
		param.setCompNo("AA01");
		System.out.println(postNewErp(param, "openApi/buildRule/generateBuildRuleByExcel"));
	}

}

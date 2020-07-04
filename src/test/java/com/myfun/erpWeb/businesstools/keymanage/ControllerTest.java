/**
 * @author 方李骥
 * @since 2016年9月5日
 */
package com.myfun.erpWeb.businesstools.keymanage;

import java.util.HashMap;
import java.util.Map;

import com.myfun.repository.erpdb.param.BorrowKeyParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;
import com.myfun.service.business.erpdb.bean.param.ErpFunKeyParam;

/**
 * @author 方李骥
 * @since 2016年9月5日
 */
public class ControllerTest extends BaseTestController{
	@Before
	public void init(){
		//init("http://192.168.0.183:8081/erpWeb", "http://192.168.0.183:8080/hftWebService/web/api/authentication/per.do", "507436", "18348451854");
		init("http://192.168.5.174:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		/*init("http://192.168.5.182:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");*/
	}
	/**
	 * 获取出售钥匙管理列表
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getSaleKeyManageList() throws Exception{
		ErpFunKeyParam	param = new ErpFunKeyParam();
		param.setOperateType("byKey");
		param.setPageOffset(1);
		param.setPageRows(50);
		System.out.println(postNewErp(param,"keyManage/getSaleKeyManageList"));
	}
	/**
	 * 获取出租钥匙管理列表
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getLeaseKeyManageList() throws Exception{
		ErpFunKeyParam	param = new ErpFunKeyParam();
		param.setOperateType("byInfo");
		param.setPageOffset(1);
		param.setPageRows(50);
		System.out.println(postNewErp(param,"keyManage/getLeaseKeyManageList"));
	}
	/**
	 * 获取钥匙日志列表
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getKeyLogList() throws Exception{
		Map<String,String>	param = new HashMap<String,String>();
		param.put("keyId","2003");
		param.put("pageOffset","1");
		param.put("pageRows","50");
		System.out.println(postNewErp(param,"keyManage/getKeyLogList"));
	}
	/**
	 * 提交钥匙跟进
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void createHouseKeyTrack() throws Exception{
		CreateHouseKeyParam	param = new CreateHouseKeyParam();
		param.setCaseId(6629686);
		param.setCaseNo("CSCD1609011423882");
		param.setCaseType(Byte.valueOf("1"));
		param.setKey("0");
		param.setKeyDeptId(891368);
		param.setKeyNote("吻吻吻吻吻你的太,bitchanddog");
		param.setUseAge(Byte.valueOf("1"));
		System.out.println(postNewErp(param,"keyManage/createHouseKeyTrack"));
	}
	/**
	 * 退换钥匙
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	//{"CASE_ID":"6629665","CASE_NO":"CSCD1609011117834","CASE_TYPE":"1","USEAGE":"1"}
	@Test
	public void returnHouseKey() throws Exception{
		CreateHouseKeyParam	param = new CreateHouseKeyParam();
		param.setCaseId(6629665);
		param.setCaseNo("CSCD1609011117834");
		param.setCaseType(Byte.valueOf("1"));
		param.setUseAge(Byte.valueOf("1"));
		System.out.println(postNewErp(param,"keyManage/returnHouseKey"));
	}
	/**
	 * 注销钥匙
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void destroyKey() throws Exception{
		DestroyKeyParam	param = new DestroyKeyParam();
		param.setKeyId(459871);
		System.out.println(postNewErp(param,"keyManage/destroyKey"));
	}
	/**
	 * 钥匙借用
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void borrowKey() throws Exception{
		BorrowKeyParam	param = new BorrowKeyParam();
		param.setKeyId(459879);
		param.setContent("年轻人要有梦想");
		param.setKeyAction("BORROW");
		System.out.println(postNewErp(param,"keyManage/borrowKey"));
	}
	/**
	 * 钥匙添加判重
	 * @author 何传强
	 * @since 2017年8月16日
	 * @throws Exception
	 */
	@Test
	public void judgeKeyRepet() throws Exception{
		Map<String, String> param = new HashMap<>();
		param.put("keyNum", "00000");
		System.err.println(postNewErp(param,"keyManage/borrowKey"));
	}
	
	
	/**
	 * 获取钥匙默认编号
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/19
	 */
	@Test
	public void getKeyDefaultNum() throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("deptId", "12001");
		System.err.println(postNewErp(param, "/businesstools/keyManage/getKeyDefaultNum"));
	}


	/**
	 * @author 邓永洪
	 * @since 2018/4/16
	 * @tag 获取用户头像地址
	 */
	@Test
	public void getUserHeadPic() throws Exception {
		Map<String, String> param = new HashMap<>();
		param.put("userIds", "20319440");
		System.err.println(postNewErp(param,"businesstools/keyManage/getUserHeadPic"));
	}




}

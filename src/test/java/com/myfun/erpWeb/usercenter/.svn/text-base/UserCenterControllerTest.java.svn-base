package com.myfun.erpWeb.usercenter;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.usercenter.param.ModifyPasswordParam;
import com.myfun.erpWeb.usercenter.param.UserHeadPicParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.usercenter.param.CashRecordParam;
import com.myfun.erpWeb.usercenter.param.ErpFunPaidConfigParam;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import scala.annotation.meta.param;

public class UserCenterControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		initNew("http://192.168.200.163:8070/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "13988880001", "123456");
	}

	@Test
	public void modifyPassword() throws Exception {
		ModifyPasswordParam param = new ModifyPasswordParam();
		param.setNeedModifyUserId(20333889);
		System.err.println(postNewErp(param, "usercenter/modifyPassword"));
	}
	
	/**
	 * 查询真房源保证金流水记录
	 * @author 张宏利
	 * @since 2018年3月19日
	 * @throws Exception
	 */
	@Test
	public void getTrueHousePiadList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/getTrueHousePiadList"));
	}
	
	/**
	 * 查询真房源保证金可提现记录
	 * @author 张宏利
	 * @since 2018年3月19日
	 * @throws Exception
	 */
	@Test
	public void getTrueHouseBondList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/getTrueHouseBondList"));
	}
	
	/**
	 * 查询提交信息
	 * @author 何传强
	 * @since 2017年8月25日
	 * @throws Exception
	 */
	@Test
	public void getAuditInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/getAuditInfo"));
	}
	
	/**
	 * 解除绑定
	 * @author 何传强
	 * @since 2017年8月25日
	 * @throws Exception
	 */
	@Test
	public void removeBinding() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("smsCode", "4545");
		pMap.put("mobile", "13551254025");
		pMap.put("ecardAddr", "2222222333");
		System.err.println(postNewErp(pMap,"usercenter/removeBinding"));
	}
	
	/**
	 * 今天不再提示打卡时间
	 * @author 臧铁
	 * @since 2017年9月7日
	 * @param param
	 * @throws Exception 
	 */
	@Test
	public void updatePromptTimeByUserId() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("userId", "20059104");
		System.err.println(postNewErp(pMap,"usercenter/updatePromptTimeByUserId"));
	}
	
	/**
	 * 隐号(IP)拨打统计报表
	 * @author 臧铁
	 * @since 2017年9月11日
	 * @param param dimension:组织机构维度  startTime：开始时间  endTime：结束时间
	 * 				serchRange：范围  serchRangeId：范围Id
	 * @throws Exception
	 */
	@Test
	public void getIpCallLogReport() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("serchRange", "COMP");//COMP AREA REG DEPT GROUP USER
//		pMap.put("serchRangeId", "12001");
		pMap.put("startTime", "2017-09-01");
		pMap.put("endTime", "2017-09-13");
		pMap.put("defId", "-2");
		pMap.put("organizationId", "894653");
		pMap.put("userId", "20333570");
//		pMap.put("userId", "10086823");
//		pMap.put("dimension", "USER");//AREA REG DEPT GROUP USER
		System.err.println(postNewErp(pMap,"usercenter/getIpCallLogReport"));
	}
	
	/**
	 * 查询需要开发票的消费记录
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
	@Test
	public void getInvoiceNotWritedList() throws Exception {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("PageOffset", 1);
		System.err.println(postNewErp(pMap,"usercenter/getInvoiceNotWritedList"));
	}
	
	/**
	 * 查询历史发票的消费记录
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
//	@Test
//	public void getInvoiceHasWritedList() throws Exception {
//		Map<String, Object> pMap = new HashMap<>();
//		pMap.put("PageOffset", 1);
//		System.err.println(postNewErp(pMap,"usercenter/getInvoiceHasWritedList"));
//	}

	/**
	 * 更新
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
	@Test
	public void updateInvoice() throws Exception {
		AddOrUpdateIssueInvoiceParam param = new AddOrUpdateIssueInvoiceParam();
		param.setInvoiceId(417);
		param.setAccountBank("中行");
		param.setPaidId("2351442");
		param.setInvoiceType((byte)1);
		param.setInvoiceHeader("123456");
		param.setIdentificationNumber("123589756");
		param.setBusinessPhone("13518667861");
		param.setBusinessAddr("天府四街");
		param.setAccountName("123654987");
		param.setRecipientUname("zhangdan");
		param.setRecipientPhone("13596855786");
		param.setInvoiceContent("内容");
		param.setMonthFlag("1");
		System.err.println(postNewErp(param,"usercenter/updateInvoice"));
	}
	
	/**
	 * 删除附件
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
	@Test
	public void delFunInvoiceEnclosure() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("esId","46");
		System.err.println(postNewErp(pMap,"usercenter/delFunInvoiceEnclosure"));
	}
	
	/**
	 * 获取发票详情
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
	@Test
	public void getInvoiceDetail() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("invoiceId","417");
		System.err.println(postNewErp(pMap,"usercenter/getInvoiceDetail"));
	}

	/**
	 *  查询收据详情
	 * @author 胡坤
	 * @since 2018年4月8日
	 * @throws Exception
	 */
	@Test
	public void getReceiptDetail() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("invoiceId","417");
		System.err.println(postNewErp(pMap,"usercenter/getReceiptDetail"));
	}
	
	/**
	 * 获取附件列表
	 * @author 熊刚
	 * @since 2017年10月9日
	 * @throws Exception
	 */
	@Test
	public void getInvoiceEnclosureList() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("invoiceId","439");
		System.out.println("getInvoiceEnclosureList");
		System.err.println(postNewErp(pMap,"usercenter/getInvoiceEnclosureList"));
	}
	
	/**
	 * 检查发票的数量
	 * @author 熊刚
	 * @since 2017年10月11日
	 * @throws Exception
	 */
	@Test
	public void checkInvoiceCount() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/checkInvoiceCount"));
	}
	
	/**
	 * 申请发票信息
	 * @author 熊刚
	 * @since 2017年10月11日
	 * @throws Exception
	 */
	@Test
	public void applyIssueInvoice() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("invoiceId","439");
		System.err.println(postNewErp(pMap,"usercenter/applyIssueInvoice"));
	}
	
	/**
	 *  查询发票消费详情
	 * @author 熊刚
	 * @since 2017年10月11日
	 * @throws Exception
	 */
	@Test
	public void getDetailPaidList() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("invoiceId","448");
		System.err.println(postNewErp(pMap,"usercenter/getDetailPaidList"));
	}
	/**
	 * 分享、查看费记录
	 * @auther 胡坤
	 * @since 2018/4/10
	 * @throws Exception
	 * 
	 */
	@Test
	public void getShareMoneyPaidList() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		//pMap.put("invoiceId","417");
		System.err.println(postNewErp(pMap,"usercenter/getShareMoneyPaidList"));
	}
	
	/**
	 * 获取可提现分享费金额
	 * @auther 胡坤
	 * @since 2018/4/10
	 * @throws Exception
	 *
	 */
	@Test
	public void getYouShareMoney() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/getYouShareMoney"));
	}
	
	/**
	 * 获取个人基本信息
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @throws Exception
	 *
	 */
	@Test
	public void getPersonalInfo() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		System.err.println(postNewErp(pMap,"usercenter/getPersonalInfo"));
	}
	
	/**
	 * IP电话拨打记录
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @throws Exception
	 *
	 */
	@Test
	public void getUcenterVoiceList() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("dateRange","2018-01-01~2018-06-30");
		//pMap.put("date","2018-4-11");
		pMap.put("paidAccount","1");
		System.err.println(postNewErp(pMap,"usercenter/getUcenterVoiceList"));
	}
	/**
	 * @author 胡坤
	 * @tag 修改密码
	 * @since 2018/4/16
	 */
	@Test
	public void modifyPwd() throws Exception {
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("oldLoginPassword","123456");
		pMap.put("loginPassword","hk123456");
		System.err.println(postNewErp(pMap,"usercenter/modifyPwd"));
	}


	/**
	 * @author 邓永洪
	 * @tag 个人中心更新档案信息
	 * @since 2018/4/12
	 */
	@Test
	public void updatePersonalInfo() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("nickName","小白兔");
		param.put("professionSub","白又白");
		param.put("serviceReg","20");
		param.put("serviceZone","中国 成都 上海");
		param.put("serviceZoneIds","35772 35633");
		param.put("userEmail","邮件123");
		param.put("userQq","qq1");
		System.out.println(postNewErp(param,"/usercenter/updatePersonalInfo"));
	}
	
	/**
	 * 用户登录
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return
	 *
	 */
	@Test
	public void login() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("userMobile","15982820924");
		param.put("loginPassword","hk123456");
		param.put("cityId","1");
		param.put("userId","20322773");
		param.put("macAddr","00,00,00,00,00,16");
		
		param.put("cityId","1");
		param.put("pcName","IP2SW96ZI8KPV2J");
		param.put("verson","17, 0, 1, 19342");
		param.put("adminCompId","10001");
		param.put("routemac","00,00,00,00,33,16");
		
		System.out.println(postNewErp(param,"/usercenter/session/login"));
	}
	
	/**
	 * 用户登出
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
	@Test
	public void logout() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("verson","17, 0, 1, 19342");
		System.out.println(postNewErp(param,"/usercenter/session/logout"));
	}

	/**
	 * 现金收支记录列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/23
	 */
	@Test
	public void getIncomePayRecordList() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("accountType",1);
		param.put("balanceType",5);
		param.put("isExtract","");
		param.put("incomePay","pay");
		param.put("pageOffset",1);
		param.put("pageRows",20);
		param.put("pageRowTotal",1);
		param.put("timeRange","2018-01-01~2018-06-30");
		System.out.println(postNewErp(param,"/usercenter/getIncomePayRecordList"));
	}

	/**
	 * @tag 获取资金账户信息
	 * @author 邓永洪
	 * @since 2018/5/23
	 */
	@Test
	public void getAllUaInfo() throws Exception {
		Map<String,Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/usercenter/getAllUaInfo"));
	}

	/**
	 * 验证手机号
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/8
	 */
	@Test
	public void isRegister() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("mobile","18111111111");
		param.put("isFlag",1);
		System.out.println(postNewErp(param,"/usercenter/isRegister"));
	}

	/**
	 * 发送验证码次数统计
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/8
	 */
	@Test
	public void sendValid() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("userMobile","15982820924");
		param.put("type","modifyua");
		System.out.println(postNewErp(param,"/usercenter/sendValid"));
	}

	/**
	 * 好房通使用评分
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	@Test
	public void createCppUseOperation() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("scoreType",11);
		System.out.println(postNewErp(param,"/common/createCppUseOperation"));
	}

	@Test
	public void getDDinfoList() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("updateTime","2017-09-05");
		System.out.println(postNewErp(param,"/common/getDDinfoList"));
	}
	
	/**
	 * 查看发票记录
	 * @author 朱科
	 * @since 2018年7月13日
	 * @return
	 */
	@Test
	public void getInvoiceHasWritedList() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("invoiceType","2");
		System.out.println(postNewErp(param,"usercenter/getInvoiceHasWritedList"));
	}

	@Test
	public void getUserListInfo() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("areaId",12001);
		param.put("regId",40143);
		param.put("deptId",12001);
		param.put("grId",0);
		param.put("userIds","2021,20322814,1454312");

		System.out.println(postNewErp(param,"usercenter/getUserListInfo"));
	}

	@Test
	public void getPaidConfig() throws Exception {
		ErpFunPaidConfigParam param = new  ErpFunPaidConfigParam();
		System.out.println(param);
		System.out.println(postNewErp(param,"usercenter/getPaidConfig"));
	}

	@Test
	public void savePaidConfig() throws Exception {
		//新增一条默认
		ErpFunPaidConfigParam param = new  ErpFunPaidConfigParam();
		param.setId(2);
		param.setHouseAdd(3);
		param.setCustAdd(3);
		param.setFkCount(2);
		param.setDkCount(2);
		param.setDkCount(2);
		param.setKeyCount(2);
		param.setTrueHouse(5);
		param.setSaleDeal(50);
		param.setRentDeal(10);
		param.setNewHouse(10);
		param.setBuildBidding(5);
		param.setHouseBidding(5);
		param.setIsExec(0);
		System.out.println(postNewErp(param,"usercenter/savePaidConfig"));
	}

	@Test
	public void revertPaidConfig() throws Exception {
		ErpFunPaidConfigParam param = new  ErpFunPaidConfigParam();
		System.out.println(postNewErp(param,"usercenter/revertPaidConfig"));
	}
	
	@Test
	public void getRentDeptsList() throws Exception {
		Map<String,Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"usercenter/getRentDeptsList"));
	}

	@Test
	public void getDeptListForContract() throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("deptId", 882711);
		System.out.println(postNewErp(param,"usercenter/getDeptListForContract"));
	}
	
		
	@Test
	public void getHfCoinRecordListTest() throws Exception {
		CashRecordParam param = new CashRecordParam();
		param.setDateType("5");
		param.setUaType(1);
		param.setPageOffset(1);
		param.setPageRows(20);
		System.out.println(postNewErp(param, "usercenter/getHfCoinRecordList"));
	}
	@Test
	public void getUserHeadPic() throws Exception {
		UserHeadPicParam param = new UserHeadPicParam();
		param.setUserIds("20322125,20330190,20330196,20330200,20331199,20331569,20332865,20332868,20332870,20329921,20330089,20330186,20330188,20330192,20330194,20330198,20330725,20330727,20330737,20330740,20331544,20331546,20331567,20331724,20330735");
		System.out.println(postNewErp(param, "usercenter/getUserHeadPic"));
	}
}

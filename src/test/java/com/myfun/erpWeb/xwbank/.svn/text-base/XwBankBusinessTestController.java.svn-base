package com.myfun.erpWeb.xwbank;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.onlinepay.param.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XwBankBusinessTestController extends BaseTestController{
	
	@Before
	public void init(){
		init("http://dev.51vfang.cn/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do",
				"123456", "18782920347");
//		init("http://192.168.200.175:9001/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do",
//				"123456", "18782920347");
	}
	
	// 请求楼盘列表
	@Test
	public void checkAccountStatus() throws Exception{
		CheckAccountStatusParam param = new CheckAccountStatusParam();
		param.setAccountType((byte) 2);
		param.setCityId(1);
		param.setCompId(46470);

		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/checkAccountStatus"));
	}
	// 请求楼盘列表
	@Test
	public void applyAccount() throws Exception{
		ApplyAccountParam param = new ApplyAccountParam();
		param.setAccountType((byte) 2);
		param.setCustomerFullName("成都沁芥兰餐饮管理有限公司天府软件园分店");
		param.setEnterpriseLegalName("袁光秀");
		param.setEnterpriseLegalIdCardType("B01");
		param.setEnterpriseLegalIdCardNo("511112199203079058");
		param.setEnterpriseContactName("马化腾");
		param.setEnterpriseContactPhone("18782920347");
		param.setEnterpriseBankCardNo("6228480010594620212");
		param.setEnterpriseUnifiedCode("915101005849827804");
		param.setEnterpriseCreditCode("915101005849827804");
		param.setEnterpriseBankName("招商银行股份有限公司北京上地支行");
		param.setEnterpriseBankCode("308100005416");
		param.setEnterpriseLegalFileUrl1("oss/online/nihao/2019/09/06/256eb6245b7649d89e5c5f6664ea8555.jpg");
		param.setEnterpriseLegalFileUrl2("oss/online/nihao/2019/09/06/80322274a30f455f9cddec9a32a7777d.jpg");
		param.setEnterpriseUnifiedFileUrl("oss/online/nihao/2019/09/06/0a9066d2c445491c8654c698f62b8d02.jpg");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/applyAccount"));
	}

	// 请求楼盘列表
	@Test
	public void createOrder() throws Exception{
		PaymentOrderParam param = new PaymentOrderParam();
		param.setOrderPaymentType((byte) 2);
//		// 1合作 2合同
		param.setBusinessId(11033);
		param.setBusinessType((byte) 2);
		// 付款方, 1:客户2:业主
		param.setPfPayer((byte) 1);
		param.setPfId(13101);
		param.setOrderAmount(new BigDecimal(2).divide(new BigDecimal(100)));

		List<PaymentPayeeParam> payeeList = new ArrayList<>();
		PaymentPayeeParam paymentPayeeParam = new PaymentPayeeParam();
		paymentPayeeParam.setAmountReceived(new BigDecimal(2).divide(new BigDecimal(100)));
		paymentPayeeParam.setCityId(1);
		paymentPayeeParam.setCompId(46470);
		paymentPayeeParam.setAccountId(10001);
//
		payeeList.add(paymentPayeeParam);
		param.setOrderPayeeList(payeeList);

		param.setOrderNo("CD201909191111081823");

		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/createOrder"));
	}

	// 请求楼盘列表
	@Test
	public void updateNotifyStatus() throws Exception{
		UpdateNotifyStatusParam param = new UpdateNotifyStatusParam();
		param.setNotifyStatus("1");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/updateNotifyStatus"));
	}

	// 请求楼盘列表
	@Test
	public void requireValidate() throws Exception{
		UpdateNotifyStatusParam param = new UpdateNotifyStatusParam();
//		param.setNotifyStatus("0");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/requireValidate"));
	}

	// 请求楼盘列表
	@Test
	public void sendOnlineCollectValidateMsg() throws Exception{
		UpdateNotifyStatusParam param = new UpdateNotifyStatusParam();
		param.setNotifyStatus("0");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/sendOnlineCollectValidateMsg"));
	}

	// 请求楼盘列表
	@Test
	public void updateXwBankAccountPassword() throws Exception{
		XwAccountPasswordParam param = new XwAccountPasswordParam();
		param.setOpType((byte) 1);
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/updateXwBankAccountPassword"));
	}

	// 请求楼盘列表
	@Test
	public void queryAccountBankInfo() throws Exception{
		AccountBankInfoParam param = new AccountBankInfoParam();
		param.setAccountId(10004);
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/queryAccountBankInfo"));
	}
	// 请求楼盘列表
	@Test
	public void dealRecordCount() throws Exception{
		DealRecordCountParam param = new DealRecordCountParam();
		param.setTimeStart("2019-01-01");
		param.setTimeEnd("2019-09-30");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/dealRecordCount"));
	}	// 请求楼盘列表
	@Test
	public void dealRecordList() throws Exception{
//		{"accountId":"10001","timeStart":"2017-01-01","timeEnd":"2019-01-01","timeType":"0"}
		DealRecordListParam param = new DealRecordListParam();
		param.setTimeType(2);
		param.setTimeStart("2019-09-01");
		param.setTimeEnd("2019-09-30");
		param.setAccountId(10001);
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/dealRecordList"));
	}

	@Test
	public void withDraw() throws Exception{
		WithDrawParam param = new WithDrawParam();
		param.setAccountId(10001);
		param.setPayeeAccountNo("8111001012500506692");
		param.setWithdrawAmount(new BigDecimal(1).divide(new BigDecimal(100)));
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/withDraw"));
	}

	@Test
	public void queryCollectAmountFlag() throws Exception{
		CollectAmountFlagParam param = new CollectAmountFlagParam();
		param.setCooperateId(1025);
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/queryCollectAmountFlag"));
	}

	@Test
	public void queryNeedCollectAmount() throws Exception{
		NeedCollectAmountParam param = new NeedCollectAmountParam();
//		param.setPfId(12887);
		param.setBusinessId(1232);
		param.setBusinessType((byte) 1);
		param.setPayer((byte) 2);
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/business/queryNeedCollectAmount"));
	}
	@Test
	public void updateAccountBankInfo() throws Exception{
		UpdateAccountBankInfoParam param = new UpdateAccountBankInfoParam();
		param.setAccountId(10004);
		param.setOpType(2);
		param.setPhone("18782920347");
		param.setBindingAccountBankName("腾讯云计算（北京）有限责任公司");
		param.setBindingAccountNo("110907316810601");
		param.setBindingAccountBankCode("308100005416");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/updateAccountBankInfo"));
	}
	@Test
	public void validateMessage() throws Exception{
		ValidateMessageParam param = new ValidateMessageParam();
		param.setPhone("18782920347");
		param.setMessageKey("959946");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/account/validateMessage"));
	}

	@Test
	public void queryPreCollectOrderInfo() throws Exception{
		OrderInfoParam param = new OrderInfoParam();
		param.setOrderNo("CD201909041524384678");
		param.setCityId(1);
		System.out.println(postNewErp(param,"/openApi/onlineCollect/queryOrderInfo"));
	}

	@Test
	public void pretieCard() throws Exception{
		PretieCardParam param = new PretieCardParam();
		param.setAccountId(10001);
		param.setPhone("18782920347");
		param.setTxnNo("9904190919115013387002677");
		param.setType("QUICKPAY");

		param.setAccountId(10001);
		param.setAccountName("个人账户");
		param.setAccountNo("6228480010200900214");
		param.setCerNo("511112199104014013");
		param.setCerType("B01");
		param.setOrderNo("CD201909191111081823");
		param.setAccountType("DEBIT");



		System.out.println(postNewErp(param,"/openApi/onlineCollect/pretieCard"));
	}

	@Test
	public void cardBinQuery() throws Exception{
		BankTypeInfoParam param = new BankTypeInfoParam();
		param.setCardNo("571905493610901");
		System.out.println(postNewErp(param,"/openApi/onlineCollect/cardBinQuery"));
	}
	@Test
	public void quickCollect() throws Exception{
		QuickPayParam param = new QuickPayParam();
		param.setAccountId(10001);
		param.setTxnNo("9904190919115013387002677");
		param.setPayerAccountNo("6228480010200900214");
		param.setPayerAccountName("中国农业银行");
		param.setPayerAccountType("DEBIT");
		param.setPayerPhone("18782920347");
		param.setPayerCerNo("511112199104014013");
		param.setPayerCerType("B01");
		param.setMessageCaptcha("749545");
		System.out.println(postNewErp(param,"/openApi/onlineCollect/quickCollect"));
	}

	@Test
	public void queryBankCode() throws Exception{
		QueryBankCodeParam param = new QueryBankCodeParam();
		param.setOpenBankName("电子联行转换中心");
		System.out.println(postNewErp(param,"/onlineCollection/xwBankModule/bank/queryBankCode"));
	}
}

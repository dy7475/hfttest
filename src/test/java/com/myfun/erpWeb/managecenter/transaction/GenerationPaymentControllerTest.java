package com.myfun.erpWeb.managecenter.transaction;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentClassParam;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunGenerationPaymentClass;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class GenerationPaymentControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "15824205070");
		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");

	}

	/**
	 * @Title 奖罚列表
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void getDetailList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("timeType", "3");
		param.put("startTime", "2018-01-01");
		param.put("endTime", "2018-01-12");
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/getDetailList"));
	}

	/**
	 * @Title 奖罚新增
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void addGenerationPayment() throws Exception {
		ErpFunGenerationPaymentParam param = new ErpFunGenerationPaymentParam();
		param.setCompAmount(new BigDecimal(115123));
		param.setPersonAmount(new BigDecimal(115123));
//		param.setOccurrenceTime(new Date());
		param.setRemarks("这是一个备注");
		param.setCompId(46470);
//		param.setGrId(252993);
//		param.setDeptId(892130);
		param.setAssessmentMonth("2018-05");
		param.setGenerationPaymentClass(10);
//		param.setUserPosition("GENERAL_MANAGER");
//		param.setUserIds("20322125,20322859,20322858");
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/addGenerationPayment"));
	}

	/**
	 * 批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@Test
	public void importGenerationPayment() throws Exception {
		/*
		* [{"assessmentMonth":"2018-07","compAmount":"90","deptId":"2001","generationPaymentClass":"12","personAmount":"90","remarks":"测试AA","userId":"10090611"}]
		 * */
		ErpFunGenerationPaymentParam param = new ErpFunGenerationPaymentParam();
		param.setGenerationPaymentListJson("[{\"assessmentMonth\":\"2018-07\",\"compAmount\":\"90\",\"deptId\":\"2001\",\"generationPaymentClass\":\"1045\",\"personAmount\":\"90\",\"remarks\":\"测试AA\",\"userId\":\"10090611\"}]");
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/importGenerationPayment"));

	}

	/**
	 * @Title 奖罚新增
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void editRewardPunishment() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		List<ErpFunRewardPunishment> paramList = new ArrayList<>();

		ErpFunRewardPunishment erpFunRewardPunishment = new ErpFunRewardPunishment();
		erpFunRewardPunishment.setId(2001);
		erpFunRewardPunishment.setAmount(new BigDecimal(5555));
		erpFunRewardPunishment.setOccurrenceTime(new Date());
		erpFunRewardPunishment.setRemarks("XXXXXX");
		erpFunRewardPunishment.setRewardPunishmentClass(2);
		erpFunRewardPunishment.setRewardPunishmentType((byte)2);
		erpFunRewardPunishment.setCompId(12001);
		paramList.add(erpFunRewardPunishment);

		ErpFunRewardPunishment erpFunRewardPunishment2 = new ErpFunRewardPunishment();
		erpFunRewardPunishment2.setId(2002);
		erpFunRewardPunishment2.setAmount(new BigDecimal(666666));
		erpFunRewardPunishment2.setOccurrenceTime(new Date());
		erpFunRewardPunishment2.setRemarks("YYYYYY");
		erpFunRewardPunishment2.setRewardPunishmentClass(1);
		erpFunRewardPunishment2.setRewardPunishmentType((byte)1);
		erpFunRewardPunishment2.setCompId(12001);
		paramList.add(erpFunRewardPunishment2);


		param.setRewardPunishmentList(JSON.toJSONString(paramList));
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/editRewardPunishment"));
	}

	/**
	 * @Title 删除奖罚记录
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void delRewardPunishmentInfo() throws Exception {
		ErpFunGenerationPaymentParam param = new ErpFunGenerationPaymentParam();
		param.setIds("1001,1002");
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/delRewardPunishmentInfo"));
	}

	/**
	 * @Title 删除奖罚记录
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void auditRewardPunishmentInfo() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setId(1);
		param.setAuditStatus((byte) 0);
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/auditRewardPunishmentInfo"));
	}
	/**
	 * @Title 删除奖罚记录
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void delGenerationPaymentClass() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setId(1);
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/delGenerationPaymentClass"));
	}

	/**
	 * @Title 添加编辑类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void addEditGenerationPaymentClass() throws Exception {
		ErpFunGenerationPaymentClassParam param = new ErpFunGenerationPaymentClassParam();
		List<ErpFunGenerationPaymentClass> paramList = new ArrayList<>();

		ErpFunGenerationPaymentClass erpFunGenerationPaymentClass = new ErpFunGenerationPaymentClass();
		erpFunGenerationPaymentClass.setId(1);
		erpFunGenerationPaymentClass.setClassName("123123");
		erpFunGenerationPaymentClass.setClassSeq(1);
		erpFunGenerationPaymentClass.setPersonAmount(new BigDecimal("20"));
		erpFunGenerationPaymentClass.setCompAmount(new BigDecimal("20"));
		erpFunGenerationPaymentClass.setCompId(12001);
		paramList.add(erpFunGenerationPaymentClass);

		ErpFunGenerationPaymentClass erpFunGenerationPaymentClass2 = new ErpFunGenerationPaymentClass();
		erpFunGenerationPaymentClass2.setClassName("罚款222");
		erpFunGenerationPaymentClass2.setClassSeq(1);
		erpFunGenerationPaymentClass2.setPersonAmount(new BigDecimal("20"));
		erpFunGenerationPaymentClass2.setCompAmount(new BigDecimal("20"));
		erpFunGenerationPaymentClass2.setCompId(12001);
		paramList.add(erpFunGenerationPaymentClass2);

		param.setGenerationPaymentClassList(JSON.toJSONString(paramList));

		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/addEditGenerationPaymentClass"));
	}

	/**
	 * @Title 列表
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void getGenerationPaymentClassList() throws Exception {
		ErpFunGenerationPaymentClassParam param = new ErpFunGenerationPaymentClassParam();

		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/getGenerationPaymentClassList"));
	}

	/**
	 * @Title 列表
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void summaryGenerationPaymentList() throws Exception {
		ErpFunGenerationPaymentParam param = new ErpFunGenerationPaymentParam();
		param.setPageOffset(2);
		param.setPageRows(50);
		param.setIsExport(1);
		param.setDimension("DEPT");
		System.out.println(postNewErp(param,"/managerCenter/transaction/generationPaymentModule/summaryGenerationPaymentList"));
	}

}

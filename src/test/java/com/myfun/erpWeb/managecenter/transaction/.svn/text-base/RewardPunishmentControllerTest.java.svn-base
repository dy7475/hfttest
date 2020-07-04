package com.myfun.erpWeb.managecenter.transaction;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.utils.HttpUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class RewardPunishmentControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "15824205070");
		//init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281168", "18802889999");
	}

	//奖罚列表（营销）
	@Test
	public void getRewardPunishmentDetailList() throws Exception{
		
		Map<String, Object> param = new HashMap<String, Object>();
		//isExport 0	occMonth 2019-11	pageOffset 1	pageRows 50
		param.put("isExport", 0);
		param.put("occMonth", "2019-12");
		param.put("pageOffset", 1);
		param.put("pageRows", 50);
		param.put("organizationId", "204924");
		
		System.out.println(postNewErp(param, "/managerCenter/transaction/rewardPunishmentModule/getRewardPunishmentDetailList"));
	}
	
	
	/**
	 * @Title 奖罚列表(link)
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void getDetailList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/getDetailList"));
	}

	/**
	 * @Title 奖罚新增
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void addRewardPunishment() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setAmount(new BigDecimal(100));
		param.setOccurrenceTime(new Date());
		param.setRemarks("这是一个备注2");
		param.setRewardPunishmentClass(33);
		param.setRewardPunishmentType((byte)2);
		param.setCompId(46470);
//		param.setDeptId(12001);
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/addRewardPunishment"));
	}

	@Test
	public void importRewardPunishment() throws Exception {
		/*
		 * [{"amount":"300","occurrenceTime":"2018-07-17","remarks":"测试","rewardPunishmentClass":"1063","rewardPunishmentType":"1","userId":"10090611"},{"amount":"300","occurrenceTime":"2018-07-17","remarks":"测试","rewardPunishmentClass":"1063","rewardPunishmentType":"1","userId":"10090611"}]
		 * {"CLIENTKEY":"acca7bc0241428477cf8cd160fbd8415","rewardPunishmentListJson":"[{\"amount\":\"100\",\"occurrenceTime\":\"2018-07-18\",\"occurrenceTime \":\"\",\"remarks\":\"\",\"rewardPunishmentClass\":\"34\",\"userId\":\"20059006\",\"userName\":\"圆点点\"},{\"amount\":\"100\",\"occurrenceTime\":\"2018-07-18\",\"occurrenceTime \":\"\",\"remarks\":\"11\",\"rewardPunishmentClass\":\"1051\",\"userId\":\"20059064\",\"userName\":\"A蒲熠星\"}]"}"
		 * */
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setRewardPunishmentListJson("[{\"amount\":\"100\",\"occurrenceTime\":\"2018-07-17\",\"occurrenceTime \":\"\",\"remarks\":\"\",\"rewardPunishmentClass\":\"34\",\"userId\":\"20059006\",\"userName\":\"圆点点\"},{\"amount\":\"100\",\"occurrenceTime\":\"2018-07-17\",\"occurrenceTime \":\"\",\"remarks\":\"11\",\"rewardPunishmentClass\":\"1051\",\"userId\":\"20059064\",\"userName\":\"A蒲熠星\"}]");
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/importRewardPunishment"));

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
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setIds("1001,1002");
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/delRewardPunishmentInfo"));
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
	public void delRewardPunishmentClass() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setId(1);
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/delRewardPunishmentClass"));
	}

	/**
	 * @Title 添加编辑类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void addEditRewardPunishmentClass() throws Exception {
		ErpFunRewardPunishmentClassParam param = new ErpFunRewardPunishmentClassParam();
		List<ErpFunRewardPunishmentClass> paramList = new ArrayList<>();

		ErpFunRewardPunishmentClass erpFunRewardPunishmentClass = new ErpFunRewardPunishmentClass();
		erpFunRewardPunishmentClass.setClassName("罚款1111");
		erpFunRewardPunishmentClass.setClassSeq(1);
		erpFunRewardPunishmentClass.setRewardPunishmentType((byte) 2);
		erpFunRewardPunishmentClass.setAmount(new BigDecimal("20"));
		paramList.add(erpFunRewardPunishmentClass);

		ErpFunRewardPunishmentClass erpFunRewardPunishmentClass2 = new ErpFunRewardPunishmentClass();
		erpFunRewardPunishmentClass2.setClassName("罚款2");
		erpFunRewardPunishmentClass2.setClassSeq(2);
		erpFunRewardPunishmentClass2.setRewardPunishmentType((byte) 2);
		erpFunRewardPunishmentClass2.setAmount(new BigDecimal("60"));
		paramList.add(erpFunRewardPunishmentClass2);


		param.setRewardPunishmentClassList(JSON.toJSONString(paramList));

		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/addEditRewardPunishmentClass"));
	}

	/**
	 * @Title 列表
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void getRewardPunishmentClassList() throws Exception {
		ErpFunRewardPunishmentClassParam param = new ErpFunRewardPunishmentClassParam();
		param.setRewardPunishmentType((byte) 2);

		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/getRewardPunishmentClassList"));
	}

	/**
	 * @Title 汇总列表
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Test
	public void summaryRewardPunishmentList() throws Exception {
		ErpFunRewardPunishmentParam param = new ErpFunRewardPunishmentParam();
		param.setPageOffset(1);
		param.setPageRows(50);
		//param.setDimension("REG");
		param.setOccMonth("2019-12");
		param.setDefId(2);
		System.out.println(postNewErp(param,"/managerCenter/transaction/rewardPunishmentModule/summaryRewardPunishmentList"));
	}

}

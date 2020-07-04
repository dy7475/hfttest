package com.myfun.erpWeb.house;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;

public class HouseCustControllerTest  extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	//	init("http://192.168.0.249:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
		init("http://192.168.5.8087:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}
	
	/**
	 * 获取房客源和分销数据数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @throws Exception
	 */
	@Test
	public void getHouseCustCount() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("userId", 20319440);
		System.out.println(postNewErp(param,"/houseCust/getHouseCustCount"));
	}
	
	/**
	 * 议价
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636695);
		param.setCaseType(1);
		param.setTrackType((byte)15);
		param.setTrackContent("议价内容");
		param.setWarmContent("提醒内容");
		param.setWarmTime(new Date());
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 * 级别跟进    17=加密 18=推荐
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo2() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636695);
		param.setCaseType(1);
		param.setTrackType((byte)17);//18推荐
		param.setTrackContent("级别跟进 内容");
		param.setWarmContent("提醒内容");
		param.setWarmTime(new Date());
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 * setTrackTypeNew 4带看
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo3() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(2270552);
		param.setCaseType(3);
		param.setTrackType((byte)4);
		param.setTrackContent("带看跟进内容");
		param.setTargetType(1);
//		param.setDkPhotoUrls("ihldas,asjadps,asdds");
//		param.setTargetIds("6636473,6636000,6636639");
//		param.setTargetNo("CSCD1710101621392,CSCD1708171454463,CSCD1710261731788");
//		param.setUserIds("10089643,10095135,10090611");
//		param.setUserNames("罗浩,文洋,圆圆");
//		param.setDeptNames("好房通测试A店,好房通测试A店,好房通测试A店");
		param.setPhotoUrls("ihldas");
		param.setTargetIds("6636473");
		param.setTargetNo("CSCD1710101621392");
		param.setUserIds("10089643");
		param.setUserNames("罗浩");
		param.setDeptNames("好房通测试A店");
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 *房堪
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo4() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636744);
		param.setCaseType(1);
		param.setTrackType((byte)3);
		param.setTrackContent("这是房堪内容");
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 *委托
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo5() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636695);
		param.setCaseType(1);
		param.setTrackType((byte)19);//6=限时,7=独家,19=普通
		param.setTrackContent("委托 内容");
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 * 转有效
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo6() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636640);
		param.setCaseType(1);
		param.setTrackType((byte)21);
		param.setTrackContent("转有效内容");
		param.setStatus((byte)1);
		param.setOldStatus(3);
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 * 转私盘
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo7() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636609);
		param.setCaseType(1);
		param.setTrackType((byte)22);
		param.setTrackContent("转私盘内容");
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/**
	 * 提交钥匙
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void submitKey() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636609);
		param.setCaseType(1);
		param.setTrackContent("提交钥匙内容");
		param.setTargetNo("6636642");
		System.out.println(postNewErp(param,"/house/submitKey"));
	}
	
	/**
	 * 归还钥匙
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void returnKey() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636640);
		param.setCaseType(1);
		param.setTrackContent("归还钥匙内容");
		System.out.println(postNewErp(param,"/house/returnKey"));
	}
	
	/**
	 * 借用钥匙
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void borrowKey() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636609);
		param.setCaseType(1);
		param.setTrackContent("借用钥匙内容");
		param.setTargetId(6636642);// 钥匙ID
		System.out.println(postNewErp(param,"/house/borrowKey"));
	}
	
	/**
	 * 注销钥匙
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void destroyKey() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636640);
		param.setCaseType(1);
		param.setTrackContent("注销钥匙内容");
		System.out.println(postNewErp(param,"/house/destroyKey"));
	}
	
	/**
	 * 状态变跟
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo16() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636640);
		param.setCaseType(1);
		param.setTrackType((byte)26);//25,26,27,28,29,30
		param.setTrackContent("状态变跟");
		param.setStatus((byte)7);//targetTime
		param.setTargetTime(new Date());
		param.setCasePlateType(2);
		param.setTotalPrice(new BigDecimal(123.2));
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	/**
	 * 修改楼盘
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void updateHouseBuild() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636640);
		param.setCaseType(1);
		param.setTrackType((byte)20);
		param.setTrackContent("修改楼盘");//
		param.setTargetId(2069);
		System.out.println(postNewErp(param,"/house/updateHouseBuild"));
	}
	
	/**
	 * 普通跟进
	 * @author 熊刚
	 * @since 2017年10月26日
	 * @throws Exception
	 */
	@Test
	public void createTrackInfo99() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6636744);
		param.setCaseType(1);
		param.setTrackType((byte)11);
		param.setTrackContent("普通跟进");//
		param.setWarmTime(new Date());
		param.setWarmContent("跟进提醒内容");
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}
	
	/***
	 * 获取提醒列表
	 * @author 熊刚
	 * @since 2017年11月8日
	 * @return
	 */
	@Test
	public void getTrackWarmTaskList() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("time", 1);
		param.setInteger("caseType", 1);
		param.setInteger("taskOwner", 6636744);
		System.out.println(postNewErp(param,"/houseCust/getTrackWarmTaskList"));
	}

	/**
	 * title ：仅售
	 * athor：lcb
	 * date  : 2017/11/10
	 */
	@Test
	public void createTrackInfoOnlySale() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(6626691);
		param.setCaseType(1);
		param.setTrackType((byte)50);
		param.setTrackContent("仅售跟进");//
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}

	/**
	 * title ：转租24 转兽23
	 * athor：lcb
	 * date  : 2017/11/10
	 */
	@Test
	public void createTrackInfo24() throws Exception{
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		param.setCaseId(3335858);
		param.setCaseType(2);
		param.setTrackType((byte)23);
		param.setTrackContent("测试转售");
		param.setPriceUnit(1);
		param.setLowestPrice(new BigDecimal(3.2));
		param.setTotalPrice(new BigDecimal(3.2));
		System.out.println(postNewErp(param,"/houseCust/createTrackInfo"));
	}

	/***
	 * 获取提醒列表
	 * @author 熊刚
	 * @since 2017年11月8日
	 * @return
	 */
	@Test
	public void getTaskDetailInfo() throws Exception{
		BaseMapParam param = new BaseMapParam();
		param.setInteger("taskI", 6636744);
		System.out.println(postNewErp(param,"/houseCust/getTaskDetailInfo"));
	}
}

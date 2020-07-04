package com.myfun.erpWeb.house;

import com.myfun.erpWeb.house.param.ProxyTemplateParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

public class HouseControllerTest extends BaseTestController {

    @Before
    public void init(){
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
       // init("http://192.168.5.174:8080/erpWeb", "http://192.168.5.174:9090/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//        init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
        //init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");
//		init("http://192.168.5.186:8080/erpWeb", "http://192.168.5.186:8081/hftWebService/web/api/authentication/per.do", "506504", "18566547985");
		init("http://192.168.5.178:8080/erpWeb", "http://192.168.5.178:8090/hftWebService/web/api/authentication/per.do", "671967", "15465656597");

    }


    /**
    * @author 邓永洪
    * @since 2018/4/20
    * @tag f房源详情->获取钥匙详情
    */
    @Test
    public void getHouseKeyInfo() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("caseId", 3336389);
        param.setInteger("caseType",2);
        System.out.println(postNewErp(param,"/house/getHouseKeyInfo"));
    }
    
    /**
     *  获取房源出售数据
     * @param
     * @auther 胡坤
     * @since 2018/5/7
     * @return
     *
     */
    @Test
    public void getHouseSaleData() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("caseId", 6629496);
        param.setInteger("caseType",1);
        System.out.println(postNewErp(param,"/house/getHouseSaleData"));
    }
    
    /**
     *  获取房源出售数据
     * @param
     * @auther 胡坤
     * @since 2018/5/7
     * @return
     *
     */
    @Test
    public void getHouseLeaseData() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("caseId", 3336506);
        param.setInteger("caseType",2);
        System.out.println(postNewErp(param,"/house/getHouseLeaseData"));
    }

    @Test
    public void getBuildingInfoList() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setString("searchKey", "测试");
        param.setInteger("buildingFlag",0);
        System.out.println(postNewErp(param,"/house/getBuildingInfoList"));
    }

    /**
     * 获取加密和推荐条数，提出来，都可以调用
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/23
     */
    @Test
    public void getPwdCount() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("caseType", 2);
        param.setInteger("infoOwnerUserId",2001);
        System.out.println(postNewErp(param,"/house/getPwdCount"));
    }

    /**
     * 根据出租房源ID获得与之匹配的客户
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/3
     */
    @Test
    public void getHouseLeaseMateCliList() throws Exception {
        /*
{"BOUND":"0","CASE_ID":"3336796","CLIENTKEY":"92656b2b1c55617f6e18272b637326c0","DATE":"5","DEPT_ID":"12001","MATCH_ITEM":"ROOM,FLOOR,AREA,PRICE","MATCH_TYPE":"EXACT_MATCH","ORDER_BY":"","REGION_IDS":"","SOURCE_DEPT_ID":"12001"}        * */
        BaseMapParam param = new BaseMapParam();
        param.setInteger("bound", 0);
        param.setInteger("caseId",3336796);
        param.setString("date","5");
        param.setInteger("deptId",12001);
        param.setString("matchItem","ROOM,FLOOR,AREA,PRICE");
        param.setString("matchType","EXACT_MATCH");
        System.out.println(postNewErp(param,"/house/getHouseLeaseMateCliList"));
    }

    /**
     * 驱动手机播放对应的720图片
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/14
     */
	@Test
	public void letAppShowVR() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("caseType", 2);
		param.setInteger("caseId",3336506);
		System.out.println(postNewErp(param,"/house/letAppShowVR"));
	}

	/**
	 * 房勘跟进时删除图片
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	@Test
	public void deleteFangKanPhoto() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("picIds", 21489754);
		System.out.println(postNewErp(param,"/house/deleteFangKanPhoto"));
	}

	/**
	 * 插入或更新或者删除公司自定义模板数据
	 * @author ZangTie
	 * @since 2018年7月23日 下午5:21:44
	 * @throws Exception
	 * Modified XXX ZangTie 2018年7月23日
	 */
	@Test
	public void updateOrCreateTmp() throws Exception {
		BaseMapParam param = new BaseMapParam();
		// 新增
		param.setInteger("caseType", 1);
		param.setInteger("queryType", 0);
		param.setInteger("type", 0);
		param.setString("richText", "xxxxxxxxx1");
		param.setString("oper", "0");
		// 更新
//		param.setInteger("caseType", 1);
//		param.setInteger("queryType", 0);
//		param.setInteger("type", 0);
//		param.setString("richText", "xxxxxxxxx1");
//		param.setString("oper", "1");
//		param.setInteger("tempid", 598796);
		// 删除
//		param.setInteger("tid", 598794);// 删除
		System.out.println(postNewErp(param,"/house/updateOrCreateTmp"));
	}

	/**
	 * 查看委托书模版
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@Test
	public void getProxyTemplate() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("templateType",2);
		System.out.println(postNewErp(param,"/house/getProxyTemplate"));
	}

	/**
	 * 委托书保存
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@Test
	public void saveProxyTemplate() throws Exception {
		BaseMapParam param = new BaseMapParam();
		param.setInteger("templateType",2);
		param.setInteger("id",3);

		param.setString("templateContent","委托书内容");
		System.out.println(postNewErp(param,"/house/saveProxyTemplate"));
	}
	@Test
	public void restProxyTemplate() throws Exception {
		ProxyTemplateParam param = new ProxyTemplateParam();
		param.setTemplateType((byte)1);
		param.setCaseType((byte)101);

		System.out.println(postNewErp(param,"/house/restProxyTemplate"));
	}
}

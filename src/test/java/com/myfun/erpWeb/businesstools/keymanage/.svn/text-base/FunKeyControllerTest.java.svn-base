package com.myfun.erpWeb.businesstools.keymanage;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.businesstools.param.BorrowKeyDetailParam;
import com.myfun.service.business.erpdb.bean.param.ErpFunKeyParam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Map;

public class FunKeyControllerTest extends BaseTestController {



    @Before
    public void init(){
       /* init("http://192.168.5.183:8080/erpWeb",
                "http://172.16.13.2:8080/hftWebService/web/api/authentication/openLogin",
                "123456", "17778888888");*/
    	initOnlyAddr("http://192.168.200.163:8068/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/openLogin",
                "201344", "18202855728");
    	// 201344   18202855728
		
		super.setClientKey("a47e724f29d0dce61e9af12a2d23454b");
    }
    @Test
    public void getBorrowKeyDetail() throws Exception{
        BorrowKeyDetailParam borrowKeyDetailParam = new BorrowKeyDetailParam();
        borrowKeyDetailParam.setKeyId(461333);
        System.out.println(postNewErp(borrowKeyDetailParam,"/businesstools/keyManage/getBorrowKeyDetail"));

    }
    
    
    /**
     * 钥匙管理出售-房源编号单元测试
     * @throws Exception
     */
    @Test
    public void getSaleKeyManageListTest() throws Exception{
        String jsonStr = "{\"areaId\":\"\",\"caseType\":\"1\",\"dept\":\"\",\"deptId\":\"\",\"grId\":\"\",\"houseNo\":\"2\",\"keyNo\":\"\",\"operateType\":\"BY_INFO\",\"pageOffset\":\"1\",\"pageRows\":\"50\",\"regId\":\"\"}";
		Map<String, String> pMap = JSON.parseObject(jsonStr, Map.class);
        System.out.println(postNewErp(pMap,"businesstools/keyManage/getSaleKeyManageList"));

    }
    
    /**
     * 钥匙管理出租-房源编号单元测试
     * @throws Exception
     */
    @Test
    public void getLeaseKeyManageListTest() throws Exception{
        String jsonStr = "{\"areaId\":\"\",\"caseType\":\"2\",\"dept\":\"\",\"deptId\":\"\",\"grId\":\"\",\"houseNo\":\"51\",\"keyNo\":\"\",\"operateType\":\"BY_INFO\",\"pageOffset\":\"1\",\"pageRows\":\"50\",\"regId\":\"\"}";
		Map<String, String> pMap = JSON.parseObject(jsonStr, Map.class);
        System.out.println(postNewErp(pMap,"businesstools/keyManage/getLeaseKeyManageList"));

    }
}
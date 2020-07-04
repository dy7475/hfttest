package com.myfun.erpWeb.managecenter.houseComplain;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.houseComplain.param.GetHouseComplainListParam;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class HouseComplainManagerTest extends BaseTestController {
    @Before
    public void init() {
        init("http://127.0.0.1:9001/erpWeb/",
                "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do",
                "123456", "17777788888");//321891
    }


    @Test
    public void houseComplainList() throws Exception {
        GetHouseComplainListParam param = new GetHouseComplainListParam();
        param.setAuditType(2);
        param.setCreateUserId(20329977);
//        param.setAuditStatus((byte)2);
//        param.setDealUserId(20331479);
        param.setStartTime("2019-09-01");
        param.setEndTime("2019-09-06");
        System.out.println(postNewErp(param,"/manageCenter/houseComplain/houseComplainList"));
    }


}
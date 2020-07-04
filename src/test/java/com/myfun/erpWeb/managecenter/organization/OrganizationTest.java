package com.myfun.erpWeb.managecenter.organization;

import com.myfun.erpWeb.BaseTestController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @since 2019/8/14
 */
public class OrganizationTest extends BaseTestController {
    @Before
    public void init(){
        init("http://192.168.200.163:8087/erpWeb", "http://172.16.13.4:8080/hftWebService/web/api/authentication/per.do",
                "1279953", "13212345673");
    }

    @Test
    public void getDeptDetailInfo() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("deptId", 894040);
        System.out.println(postNewErp(param,"/managerCenter/organization/getDeptDetailInfo"));
    }

}
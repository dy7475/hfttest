package com.myfun.erpWeb.managecenter.sysmanager;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.sysmanager.param.AddPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DelPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.QueryPartnerDeptParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SearchPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdatePartnerConfigParam;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Date: 2019/11/11 11:58
 * @Description:
 */
public class PartnerControllerTest extends BaseTestController {

    private static String urlPrefix = "/managerCenter/organization/partner/";

    @Before
    public void init() {
        init("http://localhost:8069/erpWeb",
                "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do",
                "123456",
                "17612858227");
    }


    @Test
    public void updatePartnerDept() throws Exception {
        PartnerDeptsParam param = new PartnerDeptsParam();
        param.setDeptId(894410);
        param.setPartnerId(4);
        param.setPartnerType((byte)0);
        System.out.println(postNewErp(param, urlPrefix + "updatePartnerDept"));
    }

  @Test
    public void deletePartner() throws Exception {
        DelPartnerParam param = new DelPartnerParam();
        param.setId(3);
        System.out.println(postNewErp(param, urlPrefix + "deletePartner"));
    }

    @Test
    public void updatePartner() throws Exception {
        AddPartnerParam param = new AddPartnerParam();
        param.setId(3);
        param.setEnterpriseCreditCode("222222222222");
        param.setManagerUserId(1234);
        param.setUserId(123);
        param.setJoinTime(new Date());
        param.setPartnerName("第一1111个加盟圈");
        System.out.println(postNewErp(param, urlPrefix + "updatePartner"));
    }
    @Test
    public void addPartner() throws Exception {
        AddPartnerParam param = new AddPartnerParam();
        param.setEnterpriseCreditCode("111111111111ss1111111");
        param.setManagerUserId(12345);
        param.setUserId(20332486);
        param.setJoinTime(new Date());
        param.setPartnerName("第二个加盟圈");
        System.out.println(postNewErp(param, urlPrefix + "addPartner"));
    }
    @Test
    public void allPartnerList() throws Exception {
        AddPartnerParam param = new AddPartnerParam();
        param.setEnterpriseCreditCode("1111111111111111111");
        param.setManagerUserId(123);
        param.setUserId(123);
        param.setJoinTime(new Date());
        param.setPartnerName("第一个加盟圈");
        System.out.println(postNewErp(param, urlPrefix + "allPartnerList"));
    }

    @Test
    public void partnerDeptList() throws Exception {
        QueryPartnerDeptParam param = new QueryPartnerDeptParam();
//        param.setPartnerType(1);
//        param.setDueDate("2099-01-01");
        System.out.println(postNewErp(param, urlPrefix + "partnerDeptList"));
    }

    @Test
    public void updateConfig() throws Exception {
        UpdatePartnerConfigParam param = new UpdatePartnerConfigParam();
        param.setHouseDataApart((byte)1);
        param.setBusinessDataApart((byte)1);
        param.setCustDataApart((byte)1);
        System.out.println(postNewErp(param, urlPrefix + "updateConfig"));
    }

    @Test
    public void getConfig() throws Exception {
        SearchPartnerParam searchPartnerParam = new SearchPartnerParam();
        searchPartnerParam.setStartTime("2019-10-01");
        searchPartnerParam.setEndTime("2019-10-02");
        searchPartnerParam.setDeptId(1);
        System.out.println(postNewErp(searchPartnerParam, urlPrefix + "getConfig"));
    }

    @Test
    public void partnerList() throws Exception {
        SearchPartnerParam searchPartnerParam = new SearchPartnerParam();
        System.out.println(postNewErp(searchPartnerParam, urlPrefix + "partnerList"));
    }


    public static void main(String[] args) {
        int monthValue = LocalDate.now().plusDays(30).getMonthValue();
        System.out.println(monthValue);
    }


}

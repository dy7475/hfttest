package com.myfun.erpWeb.deal;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.deal.param.*;
import com.myfun.erpWeb.managecenter.constract.param.UpdateDealAuditStatusParam;
import com.myfun.erpWeb.managecenter.userOpers.param.UpdatePermissionTemplateParam;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.rijindael.AESHelper;

import org.junit.Before;
import org.junit.Test;

public class OnlineSignControllerTest extends BaseTestController {
    @Before
    public void init() {
    	init("http://192.168.200.168:8081/erpWeb/", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281028", "15812345600");

    }

    /**
     * 返回是否开通的在线签约
     */
    
    
    
    @Test
    public void updatePermissionTemplate() throws Exception {
        UpdatePermissionTemplateParam param = new UpdatePermissionTemplateParam();
        param.setPermissionTemplateId(5);
        param.setAddOpers("VIEW_GROUP_HOUSE,VIEW_DEPT_HOUSE,VIEW_REG_HOUSE,VIEW_COMP_HOUSE,AUTO_EXAM_VIEW_GROUP_HOUSE,AUTO_EXAM_VIEW_DEPT_HOUSE,AUTO_EXAM_VIEW_REG_HOUSE,AUTO_EXAM_VIEW_COMP_HOUSE,HOUSE_VOIP_SHOW_PHONE,EDIT_GROUP_HOUSE,EDIT_DEPT_HOUSE,EDIT_REG_HOUSE,EDIT_COMP_HOUSE,KEY_MANAGE_GROUP,KEY_MANAGE_DEPT,KEY_MANAGE_REG,KEY_MANAGE_COMP,GROUP_HOUSE_DATA_EXCHANGE,DEPT_HOUSE_DATA_EXCHANGE,REG_HOUSE_DATA_EXCHANGE,COMP_HOUSE_DATA_EXCHANGE,MANAGE_RELATION_PEOPLE,HOUSE_CANCEL_FUNCAN,VIEW_HOUSE_FILE");
        param.setDelOpers("VIEW_DEPT_CUST,VIEW_REG_CUST,VIEW_COMP_CUST");
        param.setIsNewSetOper(1);
        System.err.println(postNewErp(param, "/manageCenter/userOpersModule/updatePermissionTemplate"));
    }

    @Test
    public void getCompOpenOlineContract() throws Exception {
        CompParam param = new CompParam();
//        param.setCompId(285094);
        System.err.println(postNewErp(param, "/onlineSign/getCompOpenOlineContract"));
    }

    /**
     * 开通在线签约
     */


    @Test
    public void openOnlineContract() throws Exception {
        AccountInfoParam param = new AccountInfoParam();
        param.setContactMobile("13408505238");
        param.setIdentityCode("510105198504141776");
        param.setLegalPerson("李默");
        param.setName("好房通研发公司");
        param.setOrgCode("889988");
        param.setRegCode("889988");
        param.setTaxCode("889988");
        param.setUserType(2);
        System.err.println(postNewErp(param, "/onlineSign/openOnlineContract"));
    }

    /**
     * 合同详情
     * @throws Exception
     */
    @Test
    public void getContractDetails() throws Exception {
        ContractDetailsParam param = new ContractDetailsParam();
        param.setDealId(49929);
        System.err.println(postNewErp(param, "/onlineSign/getContractDetails"));
    }
    
    /***
     * 刷脸
     * @throws Exception
     */
    @Test
    public void faceVerify() throws Exception {
    	FaceVerifyParam param = new FaceVerifyParam();
        param.setDealId(10575);
        param.setOwnerType(0);
        System.err.println(postNewErp(param, "/onlineSign/faceVerify"));
    }
    
    public void faceVerifyResult() throws Exception {
    	FaceVerifyResultParam param = new FaceVerifyResultParam();
        param.setDealId(10575);
        param.setOwnerType(0);
        param.setOrderNo("");
        System.err.println(postNewErp(param, "/onlineSign/faceVerifyResult"));
    }
    
    
    /**
     * 小程序合同详情接口
     * @throws Exception
     */
    @Test
    public void getAppletContractDetails() throws Exception {
        AppletContractDetailsParam param = new AppletContractDetailsParam();
        param.setCityId(1);
        param.setDealId(10913);
        param.setUserId(20329991);
        System.err.println(postNewErp(param, "/onlineSign/getAppletContractDetails"));
    }
    /**
     * 小程序合同流程接口
     * @throws Exception
     */
    @Test
    public void getAppletWarrantStepList() throws Exception {
        AppletWarrantStepParam param = new AppletWarrantStepParam();
        param.setCityId(1);
        param.setCompId(47362);
        param.setDealId(52128);
        param.setUserId(20331815);
        System.err.println(postNewErp(param, "/onlineSign/getAppletWarrantStepList"));
    }
    /**
     * 是否可以查看合同
     * @throws Exception
     */
    @Test
    public void verifyTelphoneNum() throws Exception {
        VerifyTelphoneNumParam param = new VerifyTelphoneNumParam();
        param.setCityId(1);
        param.setDealId(12036);
        param.setTelPhoneNum("15528168107");
        System.err.println(postNewErp(param, "/onlineSign/verifyTelphoneNum"));
    }
    /**
     * 发送邮件
     * @throws Exception
     */
    @Test
    public void sendEmail() throws Exception {
        SendEmailParam param = new SendEmailParam();
        param.setCityId(1);
        param.setDealId(10956);
        param.setEmailAddress("280970838@qq.com");
        param.setTelNum("13655688559");
        System.err.println(postNewErp(param, "/onlineSign/sendEmail"));
    }
    
    
    @Test
    public void notifySignResult() throws Exception {
    	 HttpUtil.get("http://192.168.200.156:9001/erpWeb/openApi/onlineSign/notifySignResult?cityId=1&dealId=10877&ownerType=1&token=" + AESHelper.encode("10877"), null);
    }

    @Test
    public void updateMgrDealAduitStatusByCounter() throws Exception {
        //{"contractNo":"AD107","dealAuditStatus":5,"dealId":10913,"dealType":101,"dealVerifyCon":"","personalVersion":false}
        UpdateDealAuditStatusParam param = new UpdateDealAuditStatusParam();
        param.setDealId(10913);
        param.setDealType((byte) 101);
        param.setDealAuditStatus(5);
        param.setContractNo("AD107");
        param.setPersonalVersion(false);
        System.err.println(postNewErp(param, "/managerCenter/contract/updateMgrDealAduitStatusByCounter"));
    }
    /**
     * 计算并保存pdf签名位置
     */
    @Test
    public void savePdfPosition() throws Exception {
        PdfInfoParam param = new PdfInfoParam();
        param.setCityId(1);
        param.setDealId(10959);
        param.setPdfPath("http://img01-uat.m1200.com.cn/oss/online/tmp/2019/09/06/bd844b0576af488197ee469e7f8d3180.pdf");
        param.setSignAdress("联系地址：");
        param.setSignPartyA("甲方（卖方）：");
        param.setSignPartyADate("签约时间：");
        param.setSignPartyB("乙方（卖方）：");
        param.setSignPartyBDate("签约时间：");
        param.setPdfOssPath("http://img01-uat.m1200.com.cn/oss/online/tmp/2019/09/06/bd844b0576af488197ee469e7f8d3180.pdf");
        System.err.println(postNewErp(param, "/onlineSign/savePdfPosition"));
    }
}

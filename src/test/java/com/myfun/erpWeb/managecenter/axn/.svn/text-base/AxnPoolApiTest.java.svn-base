package com.myfun.erpWeb.managecenter.axn;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.axn.param.PhoneBillListParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HuangJiang
 * @since 2019年12月24日 15:01:49
 * Modified XXX HuangJiang 2019年12月24日
 */
public class AxnPoolApiTest extends BaseTestController {
    
    @Before
    public void init(){
        //initNew("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "15124242424", "123456");
        initNew("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "15124240001", "a123456");
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281563", "15124240001");
    }
    
    /**
     * 话费管理列表
     * @author HuangJiang
     * @since 2019年12月24日 15:03
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年12月24日
     */
    @Test
    public void getPhoneBillListTest() throws Exception {
        PhoneBillListParam param = new PhoneBillListParam();
        param.setSuffix("2019-12");
        //param.setOrganizationId(894699);
        param.setUserId(20333915);
        param.setQueryWord("西南");
        String result = postNewErp(param, "/axnPool/getPhoneBillList");
        System.out.println(result);
    }
}

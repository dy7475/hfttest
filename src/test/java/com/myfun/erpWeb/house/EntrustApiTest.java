package com.myfun.erpWeb.house;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import org.junit.Before;
import org.junit.Test;

/**
 * @author HuangJiang
 * @since 2019年11月26日 15:22:15
 * Modified XXX HuangJiang 2019年11月26日
 */
public class EntrustApiTest extends BaseTestController {
    
    @Before
    public void init(){
        init("http://192.168.200.155:8068/erpWeb", "http://testapp.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280436", "15182729709");
    }
    
    /**
     * 房源委托信息发送签约短信
     * @author HuangJiang
     * @since 2019年11月26日 15:23
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月26日
     */
    @Test
    public void sendMsgToHouseOwner() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("ownerId", 485);
        String result = postNewErp(param, "/entrustApi/sendMsgToHouseOwner");
        System.out.println(result);
    }
    
    /**
     * 针对单个业主生成邀请签约二维码
     * @author HuangJiang
     * @since 2019年11月26日 15:35
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月26日
     */
    @Test
    public void getQrcodeWithOwnerId() throws Exception {
        BaseMapParam param = new BaseMapParam();
        param.setInteger("entrustId", 4);
        param.setInteger("ownerId", 4);
        String result = postNewErp(param, "/entrustApi/getQrcodeWithOwnerId");
        System.out.println(result);
    }
    
}

package com.myfun.erpWeb.house.controller;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.house.param.GetHistoryEntrustParam;
import com.myfun.erpWeb.house.param.GetHouseEntrustSituationParam;
import org.junit.Before;
import org.junit.Test;

public class MlEntrustApiControllerTest extends BaseTestController {
    @Before
    public void init(){
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281543", "15124242424");
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281569", "15124240002");
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281563", "15124240001");
        initNew("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "15124240001", "a123456");
    }
    @Test
    public void getHouseEntrustSituation() {
    }

    @Test
    public void getHouseBaseInfo() throws Exception {
        GetHouseEntrustSituationParam param = new GetHouseEntrustSituationParam();
        param.setCaseId(6732428);
        param.setCaseType(1);
        System.out.println(postNewErp(param, "/mlEntrustApi/getHouseBaseInfo"));
    }

    @Test
    public void saveEntrustInfo() {
    }

    @Test
    public void getHistoryEntrust() throws Exception {
        GetHistoryEntrustParam param = new GetHistoryEntrustParam();
        param.setCaseId(6643686);
        param.setCaseType((byte) 1);
        System.out.println(postNewErp(param,"/mlEntrustApi/getHistoryEntrust"));
    }

    @Test
    public void getHouseEffectiveEntrustInfo() throws Exception {
        GetHistoryEntrustParam param = new GetHistoryEntrustParam();
        param.setCaseId(6733012);
        param.setCaseType((byte) 1);
        System.out.println(postNewErp(param,"/mlEntrustApi/getHouseEffectiveEntrustInfo"));
    }
}
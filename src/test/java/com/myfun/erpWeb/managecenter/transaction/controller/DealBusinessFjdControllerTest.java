package com.myfun.erpWeb.managecenter.transaction.controller;

import com.myfun.erpWeb.BaseTestController;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DealBusinessFjdControllerTest extends BaseTestController {
    @Before
    public void init(){
//		init("http://dev.51vfang.cn/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18584060805");
        init("http://192.168.200.199:9001/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18584060805");

    }

    @Test
    public void getFjdFunPerformanceTypeList() throws Exception {
        Map<String, Object> param = new HashMap<>();
        //param.put("contractNo","");
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/getFjdFunPerformanceTypeList"));
    }

    @Test
    public void updateCommissioningRulesList() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("performanceJson","[{\"list\":[{\"extId\":\"187\",\"isWtPerformanceName\":false,\"targetPerformanceId\":\"48672\",\"isAdd\":false,\"isHidden\":false,\"performanceId\":\"48891\",\"alias\":\"权证\",\"commissionType\":\"3\",\"compId\":\"47605\",\"unionStr\":\"交易服务-权证\",\"enMsg\":\"2,3,权证\",\"commissionStr\":\"交易服务\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"seqNo\":\"1\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"1\",\"performanceName\":\"自定义\",\"isHidden\":false,\"performanceId\":\"48891\",\"alias\":\"金融机构\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-09-03 18:18:33\",\"performanceProportion\":\"7\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"185\",\"isHidden\":false,\"isAdd\":false,\"performanceProportion\":\"12\",\"isWtPerformanceName\":false,\"performanceId\":\"48889\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"seqNo\":\"2\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"1\",\"performanceName\":\"自定义\",\"isHidden\":false,\"performanceId\":\"48889\",\"alias\":\"11\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-09-03 18:13:46\"}},{\"list\":[{\"extId\":\"4\",\"extType\":\"1\",\"targetPerformanceId\":\"48665\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"performanceId\":\"48663\",\"alias\":\"委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"unionStr\":\"房源方-委托\",\"commissionStr\":\"房源方\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"3\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"0\",\"performanceName\":\"钥匙提交人\",\"isHidden\":false,\"performanceId\":\"48663\",\"alias\":\"钥匙\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"10\"}},{\"list\":[{\"extId\":\"137\",\"extType\":\"1\",\"targetPerformanceId\":\"48719\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"performanceId\":\"48664\",\"alias\":\"测试哈哈1\",\"commissionType\":\"1\",\"compId\":\"47605\",\"unionStr\":\"房源方-测试哈哈1\",\"commissionStr\":\"房源方\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"4\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"0\",\"performanceName\":\"房源维护人\",\"isHidden\":false,\"performanceId\":\"48664\",\"alias\":\"维护\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"10\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"182\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48665\",\"idDel\":\"0\",\"commissionStr\":\"\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"5\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"2\",\"performanceName\":\"普通委托\",\"isHidden\":false,\"performanceId\":\"48665\",\"alias\":\"委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"5\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"183\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48666\",\"idDel\":\"0\",\"commissionStr\":\"\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":true,\"isAuto\":\"1\",\"seqNo\":\"6\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"2\",\"performanceName\":\"独家委托\",\"isHidden\":false,\"performanceId\":\"48666\",\"alias\":\"独家委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"10\"}},{\"list\":[{\"extId\":\"179\",\"extType\":\"2\",\"targetPerformanceId\":\"48663\",\"performanceProportion\":\"5\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"commissionType\":\"1\",\"alias\":\"钥匙\",\"performanceId\":\"48667\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"unionStr\":\"房源方-钥匙\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":true,\"isAuto\":\"1\",\"seqNo\":\"7\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"2\",\"performanceName\":\"限时委托\",\"isHidden\":false,\"performanceId\":\"48667\",\"alias\":\"限时委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"10\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"141\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48668\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"8\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"0\",\"performanceName\":\"客源登记人\",\"isHidden\":false,\"performanceId\":\"48668\",\"alias\":\"开发\",\"commissionType\":\"2\",\"compId\":\"47605\",\"commissionStr\":\"客源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"25\"}},{\"list\":[{\"extId\":\"5\",\"extType\":\"1\",\"targetPerformanceId\":\"48668\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"performanceId\":\"48670\",\"alias\":\"开发\",\"commissionType\":\"2\",\"compId\":\"47605\",\"unionStr\":\"客源方-开发\",\"commissionStr\":\"客源方\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"9\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"2\",\"performanceName\":\"房源议价人\",\"isHidden\":false,\"performanceId\":\"48670\",\"alias\":\"销售助攻\",\"commissionType\":\"2\",\"compId\":\"47605\",\"commissionStr\":\"客源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"15\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"140\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48672\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"10\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"2\",\"canDel\":\"2\",\"performanceName\":\"权证\",\"isHidden\":false,\"performanceId\":\"48672\",\"alias\":\"权证\",\"commissionType\":\"3\",\"compId\":\"47605\",\"commissionStr\":\"交易服务\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"0\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"147\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48673\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"11\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"0\",\"performanceName\":\"房源登记人\",\"isHidden\":false,\"performanceId\":\"48673\",\"alias\":\"开发\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"5\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"164\",\"isHidden\":false,\"isAdd\":false,\"performanceProportion\":\"10\",\"isWtPerformanceName\":false,\"performanceId\":\"48677\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"12\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"2\",\"performanceName\":\"普通委托\",\"isHidden\":false,\"performanceId\":\"48677\",\"alias\":\"委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"10\"}},{\"list\":[{\"extId\":\"165\",\"extType\":\"2\",\"targetPerformanceId\":\"48676\",\"performanceProportion\":\"5\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"commissionType\":\"1\",\"alias\":\"维护\",\"performanceId\":\"48678\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"unionStr\":\"房源方-维护\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":true,\"isAuto\":\"1\",\"seqNo\":\"13\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"2\",\"performanceName\":\"独家委托\",\"isHidden\":false,\"performanceId\":\"48678\",\"alias\":\"独家委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"15\"}},{\"list\":[{\"extId\":\"167\",\"extType\":\"2\",\"targetPerformanceId\":\"48715\",\"performanceProportion\":\"10\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"commissionType\":\"1\",\"alias\":\"测试数据2\",\"performanceId\":\"48679\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"unionStr\":\"房源方-测试数据2\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":true,\"isAuto\":\"1\",\"seqNo\":\"14\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"2\",\"performanceName\":\"限时委托\",\"isHidden\":false,\"performanceId\":\"48679\",\"alias\":\"限时委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"20\"}},{\"list\":[{\"extId\":\"168\",\"extType\":\"2\",\"targetPerformanceId\":\"48717\",\"performanceProportion\":\"10\",\"isWtPerformanceName\":false,\"isAdd\":false,\"isHidden\":false,\"commissionType\":\"1\",\"alias\":\"测试数据3\",\"performanceId\":\"48680\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"unionStr\":\"房源方-测试数据3\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":true,\"isAuto\":\"1\",\"seqNo\":\"15\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"2\",\"performanceName\":\"包租委托\",\"isHidden\":false,\"performanceId\":\"48680\",\"alias\":\"包租委托\",\"commissionType\":\"1\",\"compId\":\"47605\",\"commissionStr\":\"房源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"20\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"150\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48681\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"16\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"0\",\"performanceName\":\"客源登记人\",\"isHidden\":false,\"performanceId\":\"48681\",\"alias\":\"开发\",\"commissionType\":\"2\",\"compId\":\"47605\",\"commissionStr\":\"客源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"25\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"151\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48682\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"17\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"4\",\"canDel\":\"2\",\"performanceName\":\"销售转介\",\"isHidden\":false,\"performanceId\":\"48682\",\"alias\":\"销售转介\",\"commissionType\":\"2\",\"compId\":\"47605\",\"commissionStr\":\"客源方\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"0\"}},{\"list\":[],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"commissionType\":\"2\",\"isAdd\":false,\"isHidden\":false,\"commissionStr\":\"客源方\"}},{\"list\":[{\"compId\":\"47605\",\"extId\":\"158\",\"extType\":\"1\",\"isHidden\":false,\"isAdd\":false,\"isWtPerformanceName\":false,\"performanceId\":\"48686\",\"commissionStr\":\"\",\"idDel\":\"0\"}],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isWtPerformanceName\":false,\"isAuto\":\"1\",\"seqNo\":\"19\",\"isAdd\":false,\"isDel\":\"0\",\"collectionType\":\"1\",\"canDel\":\"2\",\"performanceName\":\"权证\",\"isHidden\":false,\"performanceId\":\"48686\",\"alias\":\"权证\",\"commissionType\":\"3\",\"compId\":\"47605\",\"commissionStr\":\"交易服务\",\"createTime\":\"2019-08-31 14:59:44\",\"performanceProportion\":\"50\"}},{\"list\":[],\"commissionStr\":\"\",\"erpFunPerformanceType\":{\"isHidden\":false,\"alias\":\"Type\",\"isAdd\":false,\"performanceProportion\":\"10\",\"isWtPerformanceName\":false,\"commissionType\":\"4\",\"commissionStr\":\"金融服务\"}}]");
        param.put("paramValue",10);
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/updateCommissioningRulesList"));
    }

    @Test
    public void getDisablePerformanceTypeList() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("collectionType",2);
        param.put("commissionType",1);
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/getDisablePerformanceTypeList"));
    }

    @Test
    public void disablePerformanceTypeJudgment() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("collectionType",4);
        param.put("commissionType",1);
        param.put("alias","委托");
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/disablePerformanceTypeJudgment"));
    }

    @Test
    public void deletePerformanceCategory() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("performanceIdStr","50201");
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/deletePerformanceCategory"));
    }

    @Test
    public void determineIfThePerformanceCategoryIsUsed() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("performanceIdStr","48662");
        System.out.println(postNewErp(param,"/fjd/managerCenter/transaction/deal/determineIfThePerformanceCategoryIsUsed"));
    }
}
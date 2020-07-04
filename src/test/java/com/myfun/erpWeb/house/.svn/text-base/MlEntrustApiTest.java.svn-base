package com.myfun.erpWeb.house;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.house.param.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.utils.DateUtil;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangJiang
 * @since 2019年11月25日 13:48:18
 * Modified XXX HuangJiang 2019年11月25日
 */
public class MlEntrustApiTest extends BaseTestController {
    
    @Before
    public void init(){
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281543", "15124242424");
        //init("http://192.168.200.155:8068/erpWeb", "http://mldev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281563", "15124240001");
        initNew("http://192.168.200.155:8068/erpWeb", "http://192.168.200.155:8068/erpWeb/usercenter/session/openLogin", "15124240003", "a123456");
    }
    
    /**
     * 查询房源有无历史委托，有无当前委托以及是否能够新增委托
     * @author HuangJiang
     * @since 2019年11月25日 13:49
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月25日
     */
    @Test
    public void getHouseEntrustSituation() throws Exception {
        BaseMapParam param = new BaseMapParam();
//        param.setInteger("caseId", 6643758);
//        param.setInteger("caseType", 1);
        param.setInteger("caseId", 6733131);
        param.setInteger("caseType", 1);
//        param.setInteger("caseId", 3340165);
//        param.setInteger("caseType", 2);
//        param.setInteger("caseId", 3338924);
//        param.setInteger("caseType", 2);
        String result = postNewErp(param, "/mlEntrustApi/getHouseEntrustSituation");
        System.out.println(result);
    }
    
    /**
     * 发起委托时获取房源基础信息
     * @author HuangJiang
     * @since 2019年11月25日 15:29
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月25日
     */
    @Test
    public void getHouseBaseInfo() throws Exception {
        BaseMapParam param = new BaseMapParam();
//        param.setInteger("caseId", 6643758);
//        param.setInteger("caseType", 1);
        param.setInteger("caseId", 6733131);
        param.setInteger("caseType", 1);
        String result = postNewErp(param, "/mlEntrustApi/getHouseBaseInfo");
        System.out.println(result);
    }
    
    /**
     * 委托信息保存
     * @author HuangJiang
     * @since 2019年11月26日 10:08
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月26日
     */
    @Test
    public void saveEntrustInfo() throws Exception {
        SaveEntrustInfoParam param = new SaveEntrustInfoParam();
        param.setCaseId(6733131);
        param.setCaseType((byte) 1); // 房源类型（1=出售；2=出租）
        param.setEntrustBusiness((byte) 1); // 委托业务（1=出售委托；2出租委托）
        param.setHouseAddr("奥克斯广场3栋3单元3楼303"); // 产权地址
        param.setEntrustType((byte) 1); // 委托类型（1=普通；2=独家）
        param.setElectronicEntrust((byte) 0); // 是否电子委托（0=否；1=是）
        param.setHouseStatus((byte) 1); // 产权状态（1=完整产权；2=有抵押）
        param.setEntrustNo("纸质委托0022"); // 委托编号
        param.setEntrustStart("2019-12-23"); // 委托开始日期
        param.setEntrustEnd("2019-12-30"); // 委托截止期限
//        param.setElectronicEntrustType((byte) 2); // 电子委托书类型（1=标准；2=简易）
//        param.setDepositFileForCustom("房地产复印件,产权人身份资料复印件"); // 代业主保管文件（多选,英文逗号隔开）：房地产复印件,产权人身份资料复印件,房地产买卖合同复印件,购买发票复印件,付清房款证明复印件,产权人委托书
//        param.setDepositFileForCustomOther("身份证复印件"); // 代业主保管文件（其他）
//        param.setInspectionType((byte) 1); // 看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）
//        param.setSaleCommission(new BigDecimal("6000")); // 出售佣金
//        param.setHasLeaseContract((byte) 0); // 是否有租约 0=否 1=是
//        param.setLeaseEndTime(DateUtil.StringToDate("2019-11-27 12:00:00", "yyyy-MM-dd HH:mm:ss")); // 租约到期时间
//        param.setOldRentMoney(new BigDecimal("1500")); // 原租约金
        
        // 业主
        List<EntrustOwnersInfoParam> ownersList = new ArrayList<>();
        EntrustOwnersInfoParam entrustOwnersInfoParam1 = new EntrustOwnersInfoParam();
        entrustOwnersInfoParam1.setOwnerName("蔡春林");
        entrustOwnersInfoParam1.setNativePlace((byte) 1);
        entrustOwnersInfoParam1.setIdType((byte) 1);
        entrustOwnersInfoParam1.setCardNo("511324199210164951");
        entrustOwnersInfoParam1.setOwnerPhone("17512535239");
        entrustOwnersInfoParam1.setAddress("四川成都软件园D5");
        ownersList.add(entrustOwnersInfoParam1);
    
//        EntrustOwnersInfoParam entrustOwnersInfoParam2 = new EntrustOwnersInfoParam();
//        entrustOwnersInfoParam2.setOwnerName("李晓桐");
//        entrustOwnersInfoParam2.setNativePlace((byte) 1);
//        entrustOwnersInfoParam2.setIdType((byte) 1);
//        entrustOwnersInfoParam2.setCardNo("511527199705280639");
//        entrustOwnersInfoParam2.setOwnerPhone("15928665526");
//        entrustOwnersInfoParam2.setAddress("四川成都软件园D7");
//        ownersList.add(entrustOwnersInfoParam2);
    
        param.setOwnersList(ownersList);
        
        // 产权号
        List<EntrustCertificateInfoParam> certificateList = new ArrayList<>();
        EntrustCertificateInfoParam entrustCertificateInfoParam1 = new EntrustCertificateInfoParam();
        entrustCertificateInfoParam1.setCertificateType((byte) 1);
        entrustCertificateInfoParam1.setCertificateNo("201911261048");
        certificateList.add(entrustCertificateInfoParam1);
        param.setCertificateList(certificateList);
        
        // 附件
        List<EntrustFileInfoParam> fileList = new ArrayList<>();
        EntrustFileInfoParam entrustFileInfoParam1 = new EntrustFileInfoParam();
        entrustFileInfoParam1.setFilePath("oss/dev/tmp/2019/07/31/0369a25daebf449993cc9c114e954f7a.png");
        entrustFileInfoParam1.setFileSizeCn("110KB");
        entrustFileInfoParam1.setFileName("业主身份证明文件1");
        entrustFileInfoParam1.setFileExt("png");
        entrustFileInfoParam1.setFileType((byte) 3); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam1);
    
        EntrustFileInfoParam entrustFileInfoParam2 = new EntrustFileInfoParam();
        entrustFileInfoParam2.setFilePath("oss/online/tmp/2019/07/31/0c256b45fc4d456dbeab0d62afd13283.jpeg");
        entrustFileInfoParam2.setFileSizeCn("1.5MB");
        entrustFileInfoParam2.setFileName("产权证明1");
        entrustFileInfoParam2.setFileExt("jpeg");
        entrustFileInfoParam2.setFileType((byte) 2); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam2);
    
        EntrustFileInfoParam entrustFileInfoParam3 = new EntrustFileInfoParam();
        entrustFileInfoParam3.setFilePath("oss/online/tmp/2019/07/31/0c256b45fc4d456dbeab0d62afd13283.jpeg");
        entrustFileInfoParam3.setFileSizeCn("1.5MB");
        entrustFileInfoParam3.setFileName("委托书1");
        entrustFileInfoParam3.setFileExt("jpeg");
        entrustFileInfoParam3.setFileType((byte) 1); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam3);
        
        param.setFileList(fileList);
        String result = postNewErp(param, "/mlEntrustApi/saveEntrustInfo");
        System.out.println(result);
    }
    
    /**
     * 撤销委托
     * @author HuangJiang
     * @since 2019年11月27日 19:54
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    @Test
    public void cancelEntrust() throws Exception {
        CancelEntrustParam param = new CancelEntrustParam();
        param.setEntrustId(422);
        String result = postNewErp(param, "/mlEntrustApi/cancelEntrust");
        System.out.println(result);
    }
    
    /**
     * 删除委托
     * @author HuangJiang
     * @since 2019年11月27日 19:56
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    @Test
    public void deleteEntrust() throws Exception {
        CancelEntrustParam param = new CancelEntrustParam();
        param.setEntrustId(429);
        String result = postNewErp(param, "/mlEntrustApi/deleteEntrust");
        System.out.println(result);
    }
    
    /**
     * 修改委托
     * @author HuangJiang
     * @since 2019年11月27日 21:31
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    @Test
    public void updateEntrustInfo() throws Exception {
        SaveEntrustInfoParam param = new SaveEntrustInfoParam();
        param.setEntrustId(9);
        param.setCaseId(6732209);
        param.setCaseType((byte) 1); // 房源类型（1=出售；2=出租）
        param.setEntrustBusiness((byte) 1); // 委托业务（1=出售委托；2出租委托）
        param.setHouseAddr("盛世嘉苑21栋3单元205"); // 产权地址
        param.setEntrustType((byte) 1); // 委托类型（1=普通；2=独家）
        param.setHouseStatus((byte) 1); // 产权状态（1=完整产权；2=有抵押）
        param.setEntrustNo("ABC123456"); // 委托编号
        param.setEntrustStart("2019-11-27"); // 委托开始日期
        param.setEntrustEnd("2019-11-30"); // 委托截止期限
    
        // 业主
        List<EntrustOwnersInfoParam> ownersList = new ArrayList<>();
        EntrustOwnersInfoParam entrustOwnersInfoParam1 = new EntrustOwnersInfoParam();
        entrustOwnersInfoParam1.setOwnerId(11);
        entrustOwnersInfoParam1.setOwnerName("库里2");
        entrustOwnersInfoParam1.setNativePlace((byte) 1);
        entrustOwnersInfoParam1.setIdType((byte) 1);
        entrustOwnersInfoParam1.setCardNo("511025199999999930");
        entrustOwnersInfoParam1.setOwnerPhone("15182729707");
        entrustOwnersInfoParam1.setAddress("四川成都软件园D5");
        ownersList.add(entrustOwnersInfoParam1);
    
        EntrustOwnersInfoParam entrustOwnersInfoParam2 = new EntrustOwnersInfoParam();
        entrustOwnersInfoParam2.setOwnerId(12);
        entrustOwnersInfoParam2.setOwnerName("詹姆斯2");
        entrustOwnersInfoParam2.setNativePlace((byte) 1);
        entrustOwnersInfoParam2.setIdType((byte) 1);
        entrustOwnersInfoParam2.setCardNo("511025199999999988");
        entrustOwnersInfoParam2.setOwnerPhone("15182729708");
        entrustOwnersInfoParam2.setAddress("四川成都软件园D7");
        ownersList.add(entrustOwnersInfoParam2);
    
        EntrustOwnersInfoParam entrustOwnersInfoParam3 = new EntrustOwnersInfoParam();
        entrustOwnersInfoParam3.setOwnerId(13);
        entrustOwnersInfoParam3.setOwnerName("莱昂纳德2");
        entrustOwnersInfoParam3.setNativePlace((byte) 1);
        entrustOwnersInfoParam3.setIdType((byte) 1);
        entrustOwnersInfoParam3.setCardNo("511025199999999902");
        entrustOwnersInfoParam3.setOwnerPhone("15182729702");
        entrustOwnersInfoParam3.setAddress("四川成都软件园D2");
        ownersList.add(entrustOwnersInfoParam3);
    
        param.setOwnersList(ownersList);
    
        // 产权号
        List<EntrustCertificateInfoParam> certificateList = new ArrayList<>();
        EntrustCertificateInfoParam entrustCertificateInfoParam1 = new EntrustCertificateInfoParam();
        entrustCertificateInfoParam1.setCertificateId(9);
        entrustCertificateInfoParam1.setCertificateType((byte) 1);
        entrustCertificateInfoParam1.setCertificateNo("20191127213458222");
        certificateList.add(entrustCertificateInfoParam1);
    
        EntrustCertificateInfoParam entrustCertificateInfoParam2 = new EntrustCertificateInfoParam();
        entrustCertificateInfoParam2.setCertificateType((byte) 1);
        entrustCertificateInfoParam2.setCertificateNo("20191128000000222");
        certificateList.add(entrustCertificateInfoParam2);
        
        param.setCertificateList(certificateList);
    
        // 附件
        List<EntrustFileInfoParam> fileList = new ArrayList<>();
        EntrustFileInfoParam entrustFileInfoParam1 = new EntrustFileInfoParam();
        entrustFileInfoParam1.setFileId(18);
        entrustFileInfoParam1.setFilePath("oss/dev/tmp/2019/07/31/0369a25daebf449993cc9c114e954f7a.png");
        entrustFileInfoParam1.setFileSizeCn("110KB");
        entrustFileInfoParam1.setFileName("业主身份证明文件2");
        entrustFileInfoParam1.setFileExt("png");
        entrustFileInfoParam1.setFileType((byte) 3); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam1);
    
        EntrustFileInfoParam entrustFileInfoParam2 = new EntrustFileInfoParam();
        entrustFileInfoParam2.setFileId(19);
        entrustFileInfoParam2.setFilePath("oss/online/tmp/2019/07/31/0c256b45fc4d456dbeab0d62afd13283.jpeg");
        entrustFileInfoParam2.setFileSizeCn("1.5MB");
        entrustFileInfoParam2.setFileName("产权证明2");
        entrustFileInfoParam2.setFileExt("jpeg");
        entrustFileInfoParam2.setFileType((byte) 2); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam2);
    
        EntrustFileInfoParam entrustFileInfoParam3 = new EntrustFileInfoParam();
        entrustFileInfoParam3.setFileId(20);
        entrustFileInfoParam3.setFilePath("oss/online/tmp/2019/07/31/0c256b45fc4d456dbeab0d62afd13283.jpeg");
        entrustFileInfoParam3.setFileSizeCn("1.5MB");
        entrustFileInfoParam3.setFileName("委托书2");
        entrustFileInfoParam3.setFileExt("jpeg");
        entrustFileInfoParam3.setFileType((byte) 1); // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
        fileList.add(entrustFileInfoParam3);
    
        param.setFileList(fileList);
        String result = postNewErp(param, "/mlEntrustApi/updateEntrustInfo");
        System.out.println(result);
    }
    
    @Test
    public void saveEntrustProtocol() throws Exception {
        SaveEntrustProtocolParam param = new SaveEntrustProtocolParam();
        param.setEntrustId(243);
        param.setCityId(1);
        param.setCurrentOwerId(481);
        param.setSignaturePic("oss/dev/tmp/2019/07/31/0369a25daebf449993cc9c114e954f7a.png");
        String result = postNewErp(param, "/openApi/houseEntrust/saveEntrustProtocol");
        System.out.println(result);
    }
}

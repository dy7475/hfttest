package com.myfun.erpWeb.businesstools.builddic;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.house.param.GetHousePeopleRelativeListParam;
import com.myfun.repository.erpdb.param.BuildingSetRoomParam;
import com.myfun.repository.erpdb.param.CreatOrEditManagerParam;
import com.myfun.repository.erpdb.param.GetManageInfoParam;
import com.myfun.repository.erpdb.param.QueryBuildingListParam;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @since 2018/12/19
 */
public class FunBuildDicControllerNewTest extends BaseTestController {
    @Before
    public void init(){
        /*init("http://localhost:8080/erpWeb","http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "673369", "18782920347");*/
        //号室 公司测试号
//        init("http://localhost:8080/erpWeb", "http://172.16.13.2:8080/hftWebService/web/api/authentication/per.do", "673474", "18161228699");
        //正常公司测试
        init("http://127.0.0.1:8087/erpWeb",
                "http://testapp.51vfang.cn/hftWebService/web/api/authentication/openLogin",
                "11", "13408553494");
    }

    @Test
    public void getBuildRoofListTest() throws Exception {
        BuildIdParam param = new BuildIdParam();
        param.setBuildId(2069);
        param.setNeedCount(1);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildRoofList"));
    }

    @Test
    public void getBuildRoofRuleTest() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(1);
        param.setBuildingSetRoofId(14);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildRoofRule"));
    }

    @Test
    public void getTempBuildRoofListTest() throws Exception {
        BuildIdParam param = new BuildIdParam();
        param.setBuildId(2029098);
        System.out.println(postNewErp(param,"businesstools/buildDic/getTempBuildRoofList"));
    }

    @Test
    public void getBuildUnitListTest() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(2069);
        param.setBuildingSetRoofId(308);
        param.setNeedCount(0);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildUnitList"));
    }

    @Test
    public void getTempBuildUnitListTest() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(2029098);
        param.setBuildingSetRoofId(243);
        System.out.println(postNewErp(param,"businesstools/buildDic/getTempBuildUnitList"));
    }

    @Test
    public void getBuildUnitRuleTest() throws Exception {
        GetBuildUnitRuleParam param = new GetBuildUnitRuleParam();
        param.setBuildId(4);
        param.setBuildingSetUnitId(139);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildUnitRule"));
    }

    @Test
    public void getRoomInfoListTest() throws Exception {
        ErpBuildingGetRoomInfoListIdParam param = new ErpBuildingGetRoomInfoListIdParam();
        param.setBuildId(2005273);
        param.setBuildingSetRoofId(228);
        param.setBuildingSetUnitId(1625);
        System.out.println(postNewErp(param,"businesstools/buildDic/getRoomInfoList"));
    }

    @Test
    public void getTempRoomInfoListTest() throws Exception {
        ErpBuildingGetRoomInfoListIdParam param = new ErpBuildingGetRoomInfoListIdParam();
        param.setBuildId(2005273);
        param.setBuildingSetRoofId(228);
        param.setBuildingSetUnitId(1625);
        System.out.println(postNewErp(param,"businesstools/buildDic/getTempRoomInfoList"));
    }

    @Test
    public void getBuildRoomDetailsTest() throws Exception {
        ErpBuildingSetRoomIdParam param = new ErpBuildingSetRoomIdParam();
        param.setBuildId(1);
        param.setBuildingSetRoomId(10410);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildRoomDetails"));
    }

    //{
    //  "CLIENTKEY": "d02f3cc4669851aa92a4335a33960b92",
    //  "buildDoors": "6",
    //  "buildId": "2013747",
    //  "buildLadder": "2",
    //  "buildLandAge": "",
    //  "buildLandNature": "",
    //  "buildRightNature": "",
    //  "buildRoofName": "栋",
    //  "buildUnitName": "单元",
    //  "compriseRule": "2",
    //  "floorEnd": "6",
    //  "floorStart": "1",
    //  "houseStruct": "",
    //  "houseType": "",
    //  "houseUseage": "1",
    //  "houseYear": "2017",
    //  "inunitSuffixType": "1",
    //  "numberRule": "1",
    //  "numberType": "1",
    //  "roofPreFix": "x",
    //  "roofSuffixEnd": "12",
    //  "roofSuffixStart": "1",
    //  "roofSuffixType": "1",
    //  "unitPreFix": "x",
    //  "unitSuffixEnd": "12",
    //  "unitSuffixStart": "1"
    //}
    @Test
    public void addBuildRoofTest() throws Exception {
        ErpBuildingSetRoofAddParam param = new ErpBuildingSetRoofAddParam();
        param.setBuildId(2013748);
        param.setBuildRoof("1");
//        param.setHouseStruct(1);
        param.setHouseYear(2017);
        param.setHouseType(1);
        param.setHouseUseage(1);
//        param.setBuildLandAge(1);
        param.setBuildLandNature(1);
        param.setBuildRoofName("栋");
        param.setUnitPreFix("z");
        param.setUnitSuffixStart("1");
        param.setUnitSuffixEnd("12");
        param.setInunitSuffixType((byte) 1);
        param.setFloorStart(1);
        param.setFloorEnd(6);
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setCompriseRule((byte) 2);
        param.setAddedByAllUnits((byte) 1);
        param.setNumberRule((byte) 1);
        param.setBuildUnitName("单元");
//        param.setBuildRightNature(1);
        param.setRoofSuffixType(1);
        param.setNumberType((byte) 1);
        param.setRoofPreFix("z");
        param.setRoofSuffixStart("1");
        param.setRoofSuffixEnd("12");
        System.out.println(postNewErp(param,"businesstools/buildDic/addBuildRoof"));
    }

    @Test
    public void updateBuildRoofTest() throws Exception {
        ErpBuildingSetRoofUpdateParam param = new ErpBuildingSetRoofUpdateParam();
        param.setBuildId(1);
        param.setBuildingSetRoofId(14);
        param.setBuildRoof("测试栋座2");
        param.setHouseStruct(2);
        param.setHouseYear(2017);
        param.setHouseType(2);
        param.setHouseUseage(2);
        param.setBuildLandAge(2);
        param.setBuildLandNature(2);
        param.setBuildRoofName("栋别名2");
        System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildRoof"));
    }

    @Test
    public void addBuildUnitTest() throws Exception {
        ErpBuildingSetUnitAddParam param = new ErpBuildingSetUnitAddParam();
        param.setBuildId(1);
        param.setBuildingSetRoofId(14);
        param.setUnitPreFix("e");
        param.setUnitSuffixStart("1");
        param.setUnitSuffixEnd("3");
        param.setInunitSuffixType((byte) 1);
        param.setFloorStart(1);
        param.setFloorEnd(10);
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setCompriseRule((byte) 2);
        param.setNumberRule((byte) 1);
        param.setBuildUnitName("单元别名");
        param.setDoorStart(1);
        param.setNumberType((byte) 1);
        param.setBuildRoof("测试栋座2");
        System.out.println(postNewErp(param,"businesstools/buildDic/addBuildUnit"));
    }

    //{"CLIENTKEY":"79aad9050c9916df7fd280601b09e382","buildDoors":"6","buildId":"2013747","buildLadder":"2",
    // "buildRoof":"","buildUnit":"31","buildUnitName":"单元","buildingSetRoofId":"21","floorEnd":"15","floorStart":"1"}
    @Test
    public void addBuildUnitTest2() throws Exception {
        ErpBuildingSetUnitAddParam param = new ErpBuildingSetUnitAddParam();
        param.setBuildId(2013747);
        param.setFloorStart(1);
        param.setFloorEnd(15);
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setBuildUnit("32");
        param.setBuildUnitName("单元");
        param.setBuildingSetRoofId(21);
        System.out.println(postNewErp(param,"businesstools/buildDic/addBuildUnit"));
    }

    @Test
    public void delBuildUnitByIdTest() throws Exception {
        ErpBuildingSetUnitIdParam param = new ErpBuildingSetUnitIdParam();
        param.setBuildId(1);
        param.setBuildingSetRoofId(14);
        param.setBuildingSetUnitId(94);
        System.out.println(postNewErp(param,"businesstools/buildDic/delBuildUnitById"));
    }

    //{"CLIENTKEY":"79aad9050c9916df7fd280601b09e382","buildDoors":"6","buildId":"2013747","buildLadder":"2",
    // "buildRoof":"","buildUnit":"31","buildUnitName":"单元","buildingSetRoofId":"21","floorEnd":"15","floorStart":"1"}
    @Test
    public void updateBuildUnitTest() throws Exception {
        ErpBuildingSetUnitParam param = new ErpBuildingSetUnitParam();
        param.setBuildId(2013747);
        param.setBuildingSetUnitId(247);
        param.setFloorStart(2);
        param.setFloorEnd(13);
        param.setBuildLadder("1");
        param.setBuildDoors("3");
        param.setBuildUnit("30");
        param.setBuildingSetRoofId(21);
        System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildUnit"));
    }

    @Test
    public void delBuildRoofByIdTest() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(1);
        param.setBuildingSetRoofId(14);
        System.out.println(postNewErp(param,"businesstools/buildDic/delBuildRoofById"));
    }

    @Test
    public void addBuildRoomTest() throws Exception {
        BuildingSetRoomParam param = new BuildingSetRoomParam();
        param.setBuildId(1111199);
        param.setBuildingSetRoofId(70);
        param.setBuildingSetUnitId(512);
        param.setBuildingSetFloorId(2184);
        param.setRoomId("102");
        param.setHouseRoom((byte) 1);
        param.setHouseHall((byte) 1);
        param.setHouseWei((byte) 1);
        param.setHouseYang((byte) 1);
        param.setHouseDirect((byte) 1);
        param.setHouseArea(new BigDecimal("80.20"));
        param.setHouseInnerarea(new BigDecimal("60.20"));
        param.setPhotoUrls("http://1.jpg,http://2.jpg,http://3.jpg");
        System.out.println(postNewErp(param,"businesstools/buildDic/addBuildRoom"));
    }

    @Test
    public void copyTempBuildRuleTest() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(2000075);
        System.out.println(postNewErp(param,"businesstools/buildDic/copyTempBuildRule"));
    }

    @Test
    public void getNewBuildingList() throws Exception{
        QueryBuildingListParam param = new QueryBuildingListParam();
        param.setPageOffset(1);
        param.setPageRows(20);
        param.setRegionId(1);
        System.out.println(postNewErp(param,"/businesstools/buildDic/getNewBuildingList"));
    }

    @Test
    public void getBuildDicInfo() throws Exception{
        GetBuildDicInfoParam param = new GetBuildDicInfoParam();
        param.setBuildId(2013747);
        System.out.println(postNewErp(param,"/businesstools/buildDic/getBuildDicInfo"));
    }

    @Test
    public void updateBuildDicInfo() throws Exception{
        BuildingInfoTmpParam param = new BuildingInfoTmpParam();
        param.setBuildId(2013747);
        param.setBuildDevloper("浪浪浪公司");
        System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildDicInfo"));
    }

    @Test
    public void getBuildBaseInfo() throws Exception{
        GetManageInfoParam param = new GetManageInfoParam();
        param.setBuildId(2002454);
        System.out.println(postNewErp(param,"businesstools/buildDic/getBuildBaseInfo"));
    }

    @Test
    public void getRoofInfo() throws Exception{
        GetRoofInfoParam param = new GetRoofInfoParam();
        param.setBuildId(2015907);
        param.setBuildingSetRoof("1");
//        param.setBuildingSetUnit("A1");
        param.setIsTmp(1);
        System.out.println(postNewErp(param,"businesstools/buildDic/getRoofInfo"));
    }

    @Test
    public void getHousePeopleRelativeList() throws Exception{
        GetHousePeopleRelativeListParam param = new GetHousePeopleRelativeListParam();
        param.setCaseId(19800268);
        param.setCaseType(1);
        System.out.println(postNewErp(param,"house/getHousePeopleRelativeList"));
    }

    @Test
    public void getRoomConInfo() throws Exception{
        GetRoomConInfoParam param = new GetRoomConInfoParam();
        param.setBuildId(2013747);
        System.out.println(postNewErp(param,"businesstools/buildDic/getRoomConInfo"));

    }

    @Test
    public void getManagerInfo() throws Exception{
        GetManageInfoParam param = new GetManageInfoParam();
        param.setBuildId(2013747);
        System.out.println(postNewErp(param,"businesstools/buildDic"));
    }

    @Test
    public void creatOrEditManager() throws Exception{
        CreatOrEditManagerParam param = new CreatOrEditManagerParam();
        param.setBuildId(1113309);
        param.setBuildingSetRoofId("306");
        param.setUserId(10095135);
        System.out.println(postNewErp(param,"businesstools/buildDic/creatOrEditManager"));
    }

    @Test
    public void insertComBuild() throws Exception{
        InsertComBuildParam param = new InsertComBuildParam();
        param.setBuildName("啊哈哈啊哈哈");
        param.setCityId((short)1);
//        param.setBuildRound("2");
        param.setSectionId(36716);
        param.setBuildRegion(3210);
        param.setPostionY("30.5396951857113");
        param.setBuildAddr("天府软件园D区内,天府软件园-D6座附近21米");
        System.out.println(postNewErp(param,"/businesstools/buildDic/insertComBuild"));
    }



    @Test
    public void updateLockBuildRule() throws Exception{
        ErpBuildingSetSettingParam param = new ErpBuildingSetSettingParam();
        param.setBuildId(2022541);
        param.setLockFlag(1);
        System.out.println(postNewErp(param,"businesstools/buildDic/updateLockBuildRule"));
    }

    @Test
    public void updateRoomInfo() throws Exception{
        UpdateRoomInfoParam param = new UpdateRoomInfoParam();
        param.setBuildId(2046803);
        param.setBuildingSetRoomId(325615);
        param.setBuildingSetRoofId(7842);
        param.setBuildingSetUnitId(8572);
        param.setBuildingSetFloorId(70789);
        param.setPhotoUrls("http://pic.myfun15.com/oss/dev/tmp/2019/01/08/48253a488e3c47d4ada7bbc79740742d.jpg," +
                "http://pic.myfun16.com/oss/dev/tmp/2019/01/08/b021d33de37e4692be556388a4fa1e6b.jpg");
        param.setBuildingSetRoomIds("325611,325607,325603,325599,325595,325591,325587,325583,325579,325575,325571,325567,325563,325559,325555,325551,325547");
        param.setSync(1);
        param.setRoomId("1801");
        param.setHouseRoom((byte)3);
        param.setHouseHall((byte)2);
        param.setHouseWei((byte)2);
        param.setHouseYang((byte)3);
        param.setHouseDirect((byte)3);
        param.setHouseArea(new BigDecimal(80));
        param.setHouseInnerarea(new BigDecimal(115.5));
        param.setNearStreet((byte)1);
        param.setReplacePhotos((byte)0);
        System.out.println(postNewErp(param,"businesstools/buildDic/updateRoomInfo"));
    }

    @Test
    public void mergeRoomInfo() throws Exception{
        RoomIdsParam param = new RoomIdsParam();
        param.setBuildId(2022541);
        param.setBuildingSetRoofId(22);
        param.setBuildingSetUnitId(150);
        param.setBuildingSetRoomIds("10744,10745,10747");
        System.out.println(postNewErp(param,"businesstools/buildDic/mergeRoomInfo"));
    }

    @Test
    public void cancelMergeRoomInfo() throws Exception{
        CancelMergeRoomInfoParam param = new CancelMergeRoomInfoParam();
        param.setBuildId(2022541);
        param.setBuildingSetUnitId(150);
        param.setMergeRoom(2);
        System.out.println(postNewErp(param,"businesstools/buildDic/cancelMergeRoomInfo"));
    }

    @Test
    public void delBuildRuleByIdTest() throws Exception {
        BuildIdParam param = new BuildIdParam();
        param.setBuildId(1113115);
        System.out.println(postNewErp(param,"businesstools/buildDic/delBuildRuleById"));
    }

    @Test
    public void updateBuildFloorTest() throws Exception {
        BuildingSetFloorParam param = new BuildingSetFloorParam();
        param.setBuildId(1113251);
        param.setBuildingSetRoofId(271);
        param.setBuildingSetUnitId(1741);
        param.setBuildingSetFloorId(37996);
        param.setBuildFloor("2222");
        System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildFloor"));
    }

    @Test
    public void updateRoomInfo2() throws Exception{
        UpdateRoomInfoParam param = new UpdateRoomInfoParam();
        param.setBuildId(1963);
        param.setBuildingSetRoomId(13265895);
        param.setBuildingSetRoofId(18205);
        param.setBuildingSetUnitId(114272);
        param.setBuildingSetFloorId(1434106);
        param.setPhotoUrls("http://pic.myfun15.com/oss/dev/tmp/2019/01/08/48253a488e3c47d4ada7bbc79740742d.jpg," +
                "http://pic.myfun16.com/oss/dev/tmp/2019/01/08/b021d33de37e4692be556388a4fa1e6b.jpg");
        param.setBuildingSetRoomIds("325611,325607,325603,325599,325595,325591,325587,325583,325579,325575,325571,325567,325563,325559,325555,325551,325547");
        param.setSync(1);
        param.setRoomId("18-01");
        param.setHouseRoom((byte)3);
        param.setHouseHall((byte)2);
        param.setHouseWei((byte)2);
        param.setHouseYang((byte)3);
        param.setHouseDirect((byte)3);
        param.setHouseArea(new BigDecimal(80));
        param.setHouseInnerarea(new BigDecimal(115.5));
        param.setNearStreet((byte)1);
        param.setReplacePhotos((byte)0);
        System.out.println(postNewErp(param,"businesstools/buildDic/updateRoomInfo"));
    }

}
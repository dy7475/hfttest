package com.myfun.erpWeb.businesstools.builddic;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.repository.erpdb.param.QueryBuildingListParam;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author czq
 * @since 2019/3/27
 */
public class FunBuildDicControllerV2Test extends BaseTestController {
    @Before
    public void init() {
        init("http://127.0.0.1:8087/erpWeb", "http://172.16.13.4:8080/hftWebService/web/api/authentication/per.do",
                "1261689", "13408553494");
    }

    // 首次创建,正常添加规则
    @Test
    public void addBuildRuleTest() throws Exception {
        BuildRuleAddParam param = new BuildRuleAddParam();
        param.setBuildId(2031714);
        param.setBuildRoofName("-roof");
        param.setBuildingManagerId(20328042);

        List<RoofAddParam> roofs = new ArrayList<>();
        RoofAddParam roof = new RoofAddParam();
        roof.setBuildRoof("PPP");
        roof.setHouseUseage(1);
        roof.setBuildLandAge(40);
        roof.setHouseType(1);
        roof.setBuildLandNature(1);
        roof.setBuildRightNature(1);
        roof.setHouseYear(2020);
        roof.setBuildUnitName("-unit");
        roof.setUnitPreFix("U");
        roof.setInunitSuffixType((byte) 1);

        RoofAddParam roof2 = new RoofAddParam();
        roof2.setBuildRoof("PPK");
        roof2.setHouseUseage(1);
        roof2.setBuildLandAge(40);
        roof2.setHouseType(1);
        roof2.setBuildLandNature(1);
        roof2.setBuildRightNature(1);
        roof2.setHouseYear(2020);
        roof2.setBuildUnitName("-unit");
        roof2.setUnitPreFix("U2");
        roof2.setInunitSuffixType((byte) 2);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3C");
        unit.setFloorStart(-2);
        unit.setFloorEnd(5);
        unit.setRoomSortRule((byte) 4);
        unit.setRoomCompositionRule((byte) 3);
        unit.setBuildLadder("2");
        unit.setBuildDoors("2");
        unit.setDoorStart("3");

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("4d");
        unit2.setFloorStart(-2);
        unit2.setFloorEnd(5);
        unit2.setRoomSortRule((byte) 4);
        unit2.setRoomCompositionRule((byte) 3);
        unit2.setBuildLadder("2");
        unit2.setBuildDoors("3");
        unit2.setDoorStart("3");

        UnitAddParam unit3 = new UnitAddParam();
        unit3.setBuildUnit("4e");
        unit3.setFloorStart(-2);
        unit3.setFloorEnd(5);
        unit3.setRoomSortRule((byte) 4);
        unit3.setRoomCompositionRule((byte) 3);
        unit3.setBuildLadder("2");
        unit3.setBuildDoors("4");
        unit3.setDoorStart("3");

        units.add(unit);
        units.add(unit2);
        units.add(unit3);
        roof.setUnits(units);
        roof2.setUnits(units);

        roofs.add(roof);
        roofs.add(roof2);
        param.setRoofs(roofs);
        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRule"));
    }

    // 首次创建,添加没有单元的规则
    @Test
    public void addBuildRule2Test() throws Exception {
        BuildRuleAddParam param = new BuildRuleAddParam();
        param.setBuildId(1111294);
        param.setBuildRoofName("-roof");

        List<RoofAddParam> roofs = new ArrayList<>();
        RoofAddParam roof = new RoofAddParam();
        roof.setBuildRoof("bbkLL");
        roof.setHouseUseage(1);
        roof.setBuildLandAge(40);
        roof.setHouseType(1);
        roof.setBuildLandNature(1);
        roof.setBuildRightNature(1);
        roof.setHouseYear(2020);
        roof.setBuildUnitName("-unit");
//        roof.setBuildLadder("2");
//        roof.setBuildDoors("5");
        roof.setUnitPreFix("U");
        roof.setInunitSuffixType((byte) 1);

        RoofAddParam roof2 = new RoofAddParam();
        roof2.setBuildRoof("bbk2");
        roof2.setHouseUseage(1);
        roof2.setBuildLandAge(40);
        roof2.setHouseType(1);
        roof2.setBuildLandNature(1);
        roof2.setBuildRightNature(1);
        roof2.setHouseYear(2020);
        roof2.setBuildUnitName("-unit");
//        roof2.setBuildLadder("2");
//        roof2.setBuildDoors("5");
        roof2.setUnitPreFix("U2");
        roof2.setInunitSuffixType((byte) 2);

        List<UnitAddParam> units = new ArrayList<>();
        roof.setUnits(units);
        roof2.setUnits(units);

        roofs.add(roof);
        roofs.add(roof2);
        param.setRoofs(roofs);
        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRule"));
    }

    // 添加栋座,添加了单元规则
    @Test
    public void addBuildRoofV2Test() throws Exception {
        RoofSingleAddParam param = new RoofSingleAddParam();
        param.setBuildId(1111294);
        param.setBuildRoofName("-ROOF");
        param.setBuildRoof("ck");
        param.setHouseUseage(1);
        param.setBuildLandAge(40);
        param.setHouseType(1);
        param.setBuildLandNature(1);
        param.setBuildRightNature(1);
        param.setHouseYear(2020);
        param.setBuildUnitName("-d");
//        param.setBuildLadder("2");
//        param.setBuildDoors("5");
        param.setUnitPreFix("OO");
        param.setInunitSuffixType((byte) 2);
        param.setBuildingManagerId(20322911);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3C");
        unit.setFloorStart(-2);
        unit.setFloorEnd(5);
        unit.setRoomSortRule((byte) 4);
        unit.setRoomCompositionRule((byte) 3);
        units.add(unit);

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("3D");
        unit2.setFloorStart(-2);
        unit2.setFloorEnd(5);
        unit2.setRoomSortRule((byte) 4);
        unit2.setRoomCompositionRule((byte) 3);
        units.add(unit2);

        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRoofV2"));
    }

    // 添加栋座,没有添加单元规则
    @Test
    public void addBuildRoofV22Test() throws Exception {
        RoofSingleAddParam param = new RoofSingleAddParam();
        param.setBuildId(1111294);
        param.setBuildRoofName("-ROOF");
        param.setBuildRoof("ck");
        param.setHouseUseage(1);
        param.setBuildLandAge(40);
        param.setHouseType(1);
        param.setBuildLandNature(1);
        param.setBuildRightNature(1);
        param.setHouseYear(2020);
        param.setBuildUnitName("-d");
//        param.setBuildLadder("2");
//        param.setBuildDoors("5");
        param.setUnitPreFix("OO");
        param.setInunitSuffixType((byte) 2);
        param.setBuildingManagerId(20322911);

        List<UnitAddParam> units = new ArrayList<>();
        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRoofV2"));
    }

    // 添加普通单元
    @Test
    public void addBuildUnitV2Test() throws Exception {
        UnitSingleAddParam param = new UnitSingleAddParam();
        param.setBuildId(2031714);
        param.setBuildingSetRoofId(94727);
        param.setBuildUnit("3ER");
        param.setBuildUnitName("-unit");
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setFloorStart(-3);
        param.setFloorEnd(3);
        param.setRoomSortRule((byte) 4);
        param.setRoomCompositionRule((byte) 3);
        param.setDoorStart("3");

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildUnitV2"));
    }

    // 复制单元
    @Test
    public void copyBuildUnitTest() throws Exception {
        UnitSingleAddParam param = new UnitSingleAddParam();
        param.setBuildId(2031714);
        param.setBuildingSetRoofId(94727);
        param.setBuildUnit("3O");
        param.setBuildUnitName("-HAO");
        param.setBuildLadder("2");
        param.setBuildDoors("23");
        param.setFloorStart(-3);
        param.setFloorEnd(3);
        param.setRoomSortRule((byte) 1);
        param.setRoomCompositionRule((byte) 5);
        param.setDoorStart("2");

        System.out.println(postNewErp(param, "businesstools/buildDic/copyBuildUnit"));
    }

    // 添加号位
    @Test
    public void addBuildUnitV22Test() throws Exception {
        UnitSingleAddParam param = new UnitSingleAddParam();
        param.setBuildId(2031714);
        param.setBuildUnit("3EY");
        param.setBuildUnitName("-HAO");
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setFloorStart(-3);
        param.setFloorEnd(3);
        param.setRoomSortRule((byte) 1);
        param.setRoomCompositionRule((byte) 4);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildUnitV2"));
    }

    @Test
    public void addBuildFloorTest() throws Exception {
        BuildFloorAddParam param = new BuildFloorAddParam();
        param.setBuildId(2002454);
        param.setBuildingSetRoofId(17759);
        param.setBuildingSetUnitId(112513);
        param.setBuildRoof("3F");
        param.setBuildUnit("3C");
        param.setSysBuildFloor("14");
        param.setBuildFloor("14CF");
//        param.setFloorUseage(2);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildFloor"));
    }

    // 修改栋座时修改了规则
    @Test
    public void updateBuildRoofV2Test() throws Exception {
        RoofEditParam param = new RoofEditParam();
        param.setBuildId(2031714);
        param.setBuildingSetRoofId(94727);
        param.setBuildRoof("3TQ");
        param.setHouseUseage(2);
        param.setBuildLandAge(50);
        param.setHouseType(2);
        param.setBuildLandNature(2);
        param.setBuildRightNature(2);
        param.setHouseYear(2022);
        param.setBuildUnitName("danYq");
        param.setBuildRoofName("-ROOT");
        param.setUnitPreFix("U");
        param.setInunitSuffixType((byte) 1);
        param.setBuildingManagerId(20325467);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3D");
        unit.setFloorStart(-3);
        unit.setFloorEnd(7);
        unit.setRoomSortRule((byte) 1);
        unit.setRoomCompositionRule((byte) 3);
        unit.setBuildLadder("3");
        unit.setBuildDoors("7");
        unit.setDoorStart("5");
        units.add(unit);

        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/updateBuildRoofV2"));
    }

    // 只修改了基础信息
    @Test
    public void updateBuildRoofV22Test() throws Exception {
        RoofEditParam param = new RoofEditParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(17608);
        param.setBuildRoof("QQQ");
        param.setHouseUseage(1);
        param.setBuildLandAge(40);
        param.setHouseType(1);
        param.setBuildLandNature(1);
        param.setBuildRightNature(1);
        param.setHouseYear(2012);
        param.setBuildUnitName("DY");
        param.setBuildingManagerId(20321302);
        param.setOnlyUpdateBase((byte) 1);

        System.out.println(postNewErp(param, "businesstools/buildDic/updateBuildRoofV2"));
    }

    // 编辑到了单元的规则
    @Test
    public void updateBuildUnitV2Test() throws Exception {
        UnitEditParam param = new UnitEditParam();
        param.setBuildId(2031714);
        param.setBuildingSetRoofId(94727);
        param.setBuildingSetUnitId(118354);
        param.setBuildUnit("3KL");
        param.setBuildUnitName("-UN");
        param.setBuildLadder("2");
        param.setBuildDoors("6");
        param.setFloorStart(-2);
        param.setFloorEnd(5);
        param.setRoomSortRule((byte) 4);
        param.setRoomCompositionRule((byte) 3);
        param.setDoorStart("7");

        System.out.println(postNewErp(param, "businesstools/buildDic/updateBuildUnitV2"));
    }

    // 只编辑了名字,没有编辑规则
    @Test
    public void updateBuildUnitV22Test() throws Exception {
        UnitEditParam param = new UnitEditParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(17448);
        param.setBuildingSetUnitId(110990);
        param.setBuildUnit("3ol");
        param.setOnlyUpdateBase((byte) 1);

        System.out.println(postNewErp(param, "businesstools/buildDic/updateBuildUnitV2"));
    }

    @Test
    public void getBuildRoofRuleV2Test() throws Exception {
        ErpBuildingSetRoofIdParam param = new ErpBuildingSetRoofIdParam();
        param.setBuildId(2031714);
        param.setBuildingSetRoofId(94749);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildRoofRuleV2"));
    }

    @Test
    public void getBuildUnitRuleV2Test() throws Exception {
        GetBuildUnitRuleParam param = new GetBuildUnitRuleParam();
        param.setBuildId(2031714);
        param.setBuildingSetUnitId(118361);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildUnitRuleV2"));
    }

    // 出售的房源列表
    @Test
    public void getRoomConInfoByCaseTest() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2015907);
        param.setCaseType((byte) 2);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoByCase"));
    }

    // 出租的房源列表
    @Test
    public void getRoomConInfoByCase2Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);
        param.setCaseType((byte) 2);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoByCase"));
    }

    // 租售的房源列表
    @Test
    public void getRoomConInfoByCase3Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2031907);
        param.setCaseType((byte) 1);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoByCase"));
    }

    // 栋以及单元的时候
    @Test
    public void getRoomConInfoCountTest() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(17448);
        param.setBuildingSetUnitId(110990);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoCount"));
    }

    // 只有栋的时候
    @Test
    public void getRoomConInfoCount2Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(17448);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoCount"));
    }

    // 只有楼盘的时候
    @Test
    public void getRoomConInfoCount3Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoCount"));
    }

    // 栋信息错误的时候
    @Test
    public void getRoomConInfoCount4Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(-1);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoCount"));
    }

    // 单元信息错误的时候
    @Test
    public void getRoomConInfoCount5Test() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2261);
        param.setBuildingSetRoofId(17448);
        param.setBuildingSetUnitId(-1);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoCount"));
    }

    /**
     *     房间规则测试  roomSortRule = 1 roomCompositionRule = 2 (roomSortRule=2,3,4 不与 roomCompositionRule=2,4 同时出现)
     *             "1=按楼层排号(相当于一期:numberRule=1, addedByAllUnits=0) " +
     *             "2=按单元排号(相当于一期:numberRule=2,addedByAllUnits=0) " +
     *             "3=按楼层多单元通排(相当于一期:numberRule=1,addedByAllUnits=1) " +
     *             "4=按单元多单元通排(相当于一期:numberRule=2,addedByAllUnits=1)")
     *     private Byte roomSortRule;
     *
     *             "1=数字(相当于一期:numberType=1, compriseRule=1, 房号: 1 2 3) " +
     *             "2=字母(相当于一期:numberType=2,compriseRule=1, 房号: A B C) " +
     *             "3=楼层加数字组合(相当于一期:numberType=1,compriseRule=2,房号:101 102 103) " +
     *             "4=楼层加字母组合(相当于一期:numberType=2,compriseRule=2,房号:1A 1B 1C)" +
     *             "5=楼层补0加字母组合(numberType=2,compriseRule=3(楼层补0),房号:10A 10B 10C)")
     *     private Byte roomCompositionRule;
     *
     *
     * */
    @Test
    public void addBuildRoofV12Test() throws Exception {
        RoofSingleAddParam param = new RoofSingleAddParam();
        param.setBuildId(2020675);
        param.setBuildRoofName("-ROOF");
        param.setBuildRoof("43-");
        param.setHouseUseage(1);
        param.setBuildLandAge(40);
        param.setHouseType(1);
        param.setBuildLandNature(1);
        param.setBuildRightNature(1);
        param.setHouseYear(2020);
        param.setBuildUnitName("-d");
//        param.setBuildLadder("2");
//        param.setBuildDoors("26");
        param.setUnitPreFix("OO");
        param.setInunitSuffixType((byte) 2);
        param.setBuildingManagerId(20322911);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3C");
        unit.setFloorStart(-2);
        unit.setFloorEnd(5);
        unit.setRoomSortRule((byte) 4);
        unit.setRoomCompositionRule((byte) 3);
        units.add(unit);

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("3D");
        unit2.setFloorStart(-2);
        unit2.setFloorEnd(5);
        unit2.setRoomSortRule((byte) 4);
        unit2.setRoomCompositionRule((byte) 3);
        units.add(unit2);

        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRoofV2"));
    }

    // 首次添加号位
    @Test
    public void addBuildUnitRuleV2Test() throws Exception {
        BuildUnitRuleAddParam param = new BuildUnitRuleAddParam();
        param.setBuildId(2051070);
        param.setBuildingManagerId(20322911);
        param.setBuildUnitName("-unit");

        List<UnitAddParam> units = new ArrayList<>();

        UnitAddParam unitAddParam = new UnitAddParam();
        unitAddParam.setBuildUnit("3E");
        unitAddParam.setFloorStart(-3);
        unitAddParam.setFloorEnd(3);
        unitAddParam.setRoomSortRule((byte) 1);
        unitAddParam.setRoomCompositionRule((byte) 4);
        unitAddParam.setBuildLadder("2");
        unitAddParam.setBuildDoors("4");

        UnitAddParam unitAddParam2 = new UnitAddParam();
        unitAddParam2.setBuildUnit("3EK");
        unitAddParam2.setFloorStart(-3);
        unitAddParam2.setFloorEnd(3);
        unitAddParam2.setRoomSortRule((byte) 1);
        unitAddParam2.setRoomCompositionRule((byte) 4);
        unitAddParam2.setBuildLadder("2");
        unitAddParam2.setBuildDoors("4");

        units.add(unitAddParam);
        units.add(unitAddParam2);

        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildUnitRule"));
    }

    // 楼盘是否有系统模板,楼盘规则,楼盘维护人以及锁定状态
    @Test
    public void checkBuildTemplateTest() throws Exception {
        BuildIdInMobileParam param = new BuildIdInMobileParam();
        param.setBuildId(2036949);

        System.out.println(postNewErp(param, "businesstools/buildDic/checkBuildTemplate"));
    }

    @Test
    public void getBuildRoofListInMobile() throws Exception {
        BuildIdInMobileParam param = new BuildIdInMobileParam();
        param.setBuildId(2069);
        param.setBuildTemplate(0);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildRoofListInMobile"));
    }

    @Test
    public void getRoomConInfoByCaseInMobileTest() throws Exception {
        RoomConInfoByCaseInMobileParam param = new RoomConInfoByCaseInMobileParam();
        param.setBuildId(2069);
//        param.setBuildingSetRoofId(19141);
        param.setBuildTemplate(0);
//        param.setCaseType((byte) 1);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfoByCaseInMobile"));
    }

    @Test
    public void getRoomInfoListInMobileTest() throws Exception {
        ErpBuildingGetRoomInfoListIdParam param = new ErpBuildingGetRoomInfoListIdParam();
        param.setBuildId(2029899);
        param.setBuildTemplate(0);
//        param.setBuildingSetRoofId(17618);
        param.setBuildingSetUnitId(36813);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomInfoListInMobile"));
    }

    @Test
    public void delBuildFloorByIdTest() throws Exception {
        BuildFloorIdParam param = new BuildFloorIdParam();
        param.setBuildId(2038543);
        param.setBuildingSetFloorId(1387606);

        System.out.println(postNewErp(param, "businesstools/buildDic/delBuildFloorById"));
    }

    @Test
    public void getRoomConInfoTest() throws Exception {
        RoomConInfoByCaseParam param = new RoomConInfoByCaseParam();
        param.setBuildId(2035576);
        param.setCaseType((byte) 3);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomConInfo"));
    }

    @Test
    public void getBuildUnitListInMobileTest() throws Exception {
        BuildIdInMobileParam param = new BuildIdInMobileParam();
        param.setBuildId(2022437);
        param.setBuildTemplate(0);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildUnitListInMobile"));
    }

    @Test
    public void getBuildUnitDetailsInMobileTest() throws Exception {
        BuildUnitIdParam param = new BuildUnitIdParam();
        param.setBuildId(2022437);
        param.setBuildingSetUnitId(36811);
        param.setBuildTemplate(0);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildUnitDetailsInMobile"));
    }

    @Test
    public void getBuildingListInMobileTest() throws Exception {
        QueryBuildingListParam param = new QueryBuildingListParam();
//        param.setBuildIds("1111294,2017241,2045058");
//        param.setBuildName("long");
        param.setBuildIds("1111199");
//        param.setBuildStatus((byte) 1);
//        param.setUserId(20328042);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildingListInMobile"));
    }

    @Test
    public void getRoomInfoListTest() throws Exception {
        ErpBuildingGetRoomInfoListIdParam param = new ErpBuildingGetRoomInfoListIdParam();
        param.setBuildId(2029899);
//        param.setBuildingSetRoofId(17683);
        param.setBuildingSetUnitId(113220);
        param.setBuildTemplate(0);

        System.out.println(postNewErp(param, "businesstools/buildDic/getRoomInfoList"));
    }

    @Test
    public void getBuildRoofDetailsInMobileTest() throws Exception {
        BuildRoofIdParam param = new BuildRoofIdParam();
        param.setBuildId(2069);
        param.setBuildingSetRoofId(19054);
        param.setBuildTemplate(0);

        System.out.println(postNewErp(param, "businesstools/buildDic/getBuildRoofDetailsInMobile"));
    }

    // 添加栋座,添加了单元规则
    @Test
    public void copyBuildRoof() throws Exception {
        RoofSingleAddParam param = new RoofSingleAddParam();
        param.setBuildId(2031714);
        param.setBuildRoofName("-ROOF");
        param.setBuildRoof("ckk");
        param.setHouseUseage(1);
        param.setBuildLandAge(40);
        param.setHouseType(1);
        param.setBuildLandNature(1);
        param.setBuildRightNature(1);
        param.setHouseYear(2020);
        param.setBuildUnitName("-d");
        param.setUnitPreFix("OO");
        param.setInunitSuffixType((byte) 2);
        param.setBuildingManagerId(20322911);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3C");
        unit.setFloorStart(-2);
        unit.setFloorEnd(5);
        unit.setRoomSortRule((byte) 4);
        unit.setRoomCompositionRule((byte) 3);
        unit.setBuildDoors("4");
        unit.setBuildLadder("2");
        unit.setDoorStart("3");
        units.add(unit);

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("3D");
        unit2.setFloorStart(-2);
        unit2.setFloorEnd(5);
        unit2.setRoomSortRule((byte) 4);
        unit2.setRoomCompositionRule((byte) 3);
        unit2.setBuildDoors("4");
        unit2.setBuildLadder("2");
        unit2.setDoorStart("3");
        units.add(unit2);

        param.setUnits(units);

        System.out.println(postNewErp(param, "businesstools/buildDic/copyBuildRoof"));
    }

    @Test
    public void getFunListByCaseIdsInMobile() throws Exception {
        CaseIdsParam param = new CaseIdsParam();
//        param.setCaseType(1);
//        param.setCaseIds("6642472,6642470,6642469");

        param.setCaseType(2);
        param.setCaseIds("3338248,3338247,3338246");

        System.out.println(postNewErp(param, "businesstools/buildDic/getFunListByCaseIdsInMobile"));
    }

    @Test
    public void addBuildRule3Test() throws Exception {
        BuildRuleAddParam param = new BuildRuleAddParam();
        param.setBuildId(2051070);
        param.setBuildRoofName("栋");
        param.setBuildingManagerId(null);

        List<RoofAddParam> roofs = new ArrayList<>();
        RoofAddParam roof = new RoofAddParam();
        roof.setBuildRoof("这是一个前缀前缀1");
        roof.setHouseUseage(null);
        roof.setBuildLandAge(null);
        roof.setHouseType(null);
        roof.setBuildLandNature(null);
        roof.setBuildRightNature(null);
        roof.setHouseYear(null);
        roof.setBuildUnitName("单元");
//        roof.setBuildLadder("3");
//        roof.setBuildDoors("6");
        roof.setUnitPreFix("单元前缀单元前缀");
        roof.setInunitSuffixType((byte) 1);

        RoofAddParam roof2 = new RoofAddParam();
        roof2.setBuildRoof("这是一个前缀前缀2");
        roof2.setHouseUseage(null);
        roof2.setBuildLandAge(null);
        roof2.setHouseType(null);
        roof2.setBuildLandNature(null);
        roof2.setBuildRightNature(null);
        roof2.setHouseYear(null);
        roof2.setBuildUnitName("单元");
//        roof2.setBuildLadder("3");
//        roof2.setBuildDoors("6");
        roof2.setUnitPreFix("单元前缀单元前缀");
        roof2.setInunitSuffixType((byte) 1);

        RoofAddParam roof3 = new RoofAddParam();
        roof3.setBuildRoof("这是一个前缀前缀3");
        roof3.setHouseUseage(null);
        roof3.setBuildLandAge(null);
        roof3.setHouseType(null);
        roof3.setBuildLandNature(null);
        roof3.setBuildRightNature(null);
        roof3.setHouseYear(null);
        roof3.setBuildUnitName("单元");
//        roof3.setBuildLadder("3");
//        roof3.setBuildDoors("6");
        roof3.setUnitPreFix("单元前缀单元前缀");
        roof3.setInunitSuffixType((byte) 1);

        RoofAddParam roof4 = new RoofAddParam();
        roof4.setBuildRoof("这是一个前缀前缀4");
        roof4.setHouseUseage(null);
        roof4.setBuildLandAge(null);
        roof4.setHouseType(null);
        roof4.setBuildLandNature(null);
        roof4.setBuildRightNature(null);
        roof4.setHouseYear(null);
        roof4.setBuildUnitName("单元");
//        roof4.setBuildLadder("3");
//        roof4.setBuildDoors("6");
        roof4.setUnitPreFix("单元前缀单元前缀");
        roof4.setInunitSuffixType((byte) 1);

        RoofAddParam roof5 = new RoofAddParam();
        roof5.setBuildRoof("这是一个前缀前缀5");
        roof5.setHouseUseage(null);
        roof5.setBuildLandAge(null);
        roof5.setHouseType(null);
        roof5.setBuildLandNature(null);
        roof5.setBuildRightNature(null);
        roof5.setHouseYear(null);
        roof5.setBuildUnitName("单元");
//        roof5.setBuildLadder("3");
//        roof5.setBuildDoors("6");
        roof5.setUnitPreFix("单元前缀单元前缀");
        roof5.setInunitSuffixType((byte) 1);

        RoofAddParam roof6 = new RoofAddParam();
        roof6.setBuildRoof("这是一个前缀前缀6");
        roof6.setHouseUseage(null);
        roof6.setBuildLandAge(null);
        roof6.setHouseType(null);
        roof6.setBuildLandNature(null);
        roof6.setBuildRightNature(null);
        roof6.setHouseYear(null);
        roof6.setBuildUnitName("单元");
//        roof6.setBuildLadder("3");
//        roof6.setBuildDoors("6");
        roof6.setUnitPreFix("单元前缀单元前缀");
        roof6.setInunitSuffixType((byte) 1);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("单元前缀单元前缀1");
        unit.setFloorStart(0);
        unit.setFloorEnd(18);
        unit.setRoomSortRule((byte) 1);
        unit.setRoomCompositionRule((byte) 3);

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("单元前缀单元前缀2");
        unit2.setFloorStart(0);
        unit2.setFloorEnd(18);
        unit2.setRoomSortRule((byte) 1);
        unit2.setRoomCompositionRule((byte) 3);

        UnitAddParam unit3 = new UnitAddParam();
        unit3.setBuildUnit("单元前缀单元前缀3");
        unit3.setFloorStart(0);
        unit3.setFloorEnd(18);
        unit3.setRoomSortRule((byte) 1);
        unit3.setRoomCompositionRule((byte) 3);

        units.add(unit);
        units.add(unit2);
        units.add(unit3);

        roof.setUnits(units);
        roof2.setUnits(units);
        roof3.setUnits(units);
        roof4.setUnits(units);
        roof5.setUnits(units);
        roof6.setUnits(units);

        roofs.add(roof);
        roofs.add(roof2);
        roofs.add(roof3);
        roofs.add(roof4);
        roofs.add(roof5);
        roofs.add(roof6);

        param.setRoofs(roofs);
        System.out.println(postNewErp(param, "businesstools/buildDic/addBuildRule"));
    }

    @Test
    public void getCustomersByCaseIds() throws Exception {
        CaseIdsParam param = new CaseIdsParam();
//        param.setCaseType(3);
//        param.setCaseIds("2928109,2928108,2928107,2928106,2928105,2928104,2928103,2928102,2928101,2928100");

        param.setCaseType(4);
        param.setCaseIds("2407758,2407757,2407756,2407748,2407744,2407743,2407742,2407741,2407740,2407739");

        System.out.println(postNewErp(param, "businesstools/buildDic/getCustomersByCaseIds"));
    }

    @Test
    public void batchAddBuildRoofTest() throws Exception {
        BuildRuleAddParam param = new BuildRuleAddParam();
        param.setBuildId(2031714);
        param.setBuildRoofName("-roof");
        param.setBuildingManagerId(20328042);

        List<RoofAddParam> roofs = new ArrayList<>();
        RoofAddParam roof = new RoofAddParam();
        roof.setBuildRoof("TTT");
        roof.setHouseUseage(1);
        roof.setBuildLandAge(40);
        roof.setHouseType(1);
        roof.setBuildLandNature(1);
        roof.setBuildRightNature(1);
        roof.setHouseYear(2020);
        roof.setBuildUnitName("-unit");
        roof.setUnitPreFix("U");
        roof.setInunitSuffixType((byte) 1);

        RoofAddParam roof2 = new RoofAddParam();
        roof2.setBuildRoof("UUU");
        roof2.setHouseUseage(1);
        roof2.setBuildLandAge(40);
        roof2.setHouseType(1);
        roof2.setBuildLandNature(1);
        roof2.setBuildRightNature(1);
        roof2.setHouseYear(2020);
        roof2.setBuildUnitName("-unit");
        roof2.setUnitPreFix("U2");
        roof2.setInunitSuffixType((byte) 2);

        List<UnitAddParam> units = new ArrayList<>();
        UnitAddParam unit = new UnitAddParam();
        unit.setBuildUnit("3C");
        unit.setFloorStart(-2);
        unit.setFloorEnd(5);
        unit.setRoomSortRule((byte) 4);
        unit.setRoomCompositionRule((byte) 3);
        unit.setBuildLadder("2");
        unit.setBuildDoors("2");
        unit.setDoorStart("3");

        UnitAddParam unit2 = new UnitAddParam();
        unit2.setBuildUnit("4d");
        unit2.setFloorStart(-2);
        unit2.setFloorEnd(5);
        unit2.setRoomSortRule((byte) 4);
        unit2.setRoomCompositionRule((byte) 3);
        unit2.setBuildLadder("2");
        unit2.setBuildDoors("3");
        unit2.setDoorStart("3");

        UnitAddParam unit3 = new UnitAddParam();
        unit3.setBuildUnit("4e");
        unit3.setFloorStart(-2);
        unit3.setFloorEnd(5);
        unit3.setRoomSortRule((byte) 4);
        unit3.setRoomCompositionRule((byte) 3);
        unit3.setBuildLadder("2");
        unit3.setBuildDoors("4");
        unit3.setDoorStart("3");

        units.add(unit);
        units.add(unit2);
        units.add(unit3);
        roof.setUnits(units);
        roof2.setUnits(units);

        roofs.add(roof);
        roofs.add(roof2);
        param.setRoofs(roofs);
        System.out.println(postNewErp(param, "businesstools/buildDic/batchAddBuildRoof"));
    }



}
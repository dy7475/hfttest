package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.RoomWithBuildFloorDto;
import com.myfun.repository.erpdb.param.CreatOrEditManagerParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.HeavenlyStem;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author czq
 * @since 2018/12/17
 */
@Service
public class ErpBuildingSetUnitServiceImpl extends AbstractService<ErpBuildingSetUnit, ErpBuildingSetUnit> implements ErpBuildingSetUnitService {

    @Resource
    private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
    @Resource
    private ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
    @Resource
    private ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
    @Resource
    private ErpBuildingSetLogMapper erpBuildingSetLogMapper;
    @Resource
    private ErpBuildingSetRoomLayoutMapper erpBuildingSetRoomLayoutMapper;
    @Resource
    private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Resource
    private ErpSysParaMapper erpSysParaMapper;
    @Resource
    private ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
    @Resource
    private ErpBuildingSetRoomService erpBuildingSetRoomService;
    @Resource
    private ErpUserOpersService erpUserOpersService;
    @Resource
    private ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
    @Resource
    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;
    @Resource
    private ErpBuildingSetRoofService erpBuildingSetRoofService;
    @Resource
    private ErpBuildingManagerService erpBuildingManagerService;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildingSetUnitMapper;
    }

    @Transactional
    @Override
    public void delBuildUnit(ErpBuildingSetUnitIdParam param, Integer cityId, Integer compId, Integer userId) {
        DeleteIdParam deleteIdParam = new DeleteIdParam();
        deleteIdParam.setBuildId(param.getBuildId());
        deleteIdParam.setBuildingSetUnitId(param.getBuildingSetUnitId());

        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId());
        int rooms = erpBuildingSetRoomMapper.countByExample(roomExample);

        if (rooms > 0) {
            // 单元下存在房间则删除
            erpBuildingSetRoomMapper.delBuildRoom(cityId, deleteIdParam, 0);
            erpBuildingSetRoomLayoutMapper.delBuildRoomLayout(cityId, deleteIdParam, 0);
        }

        // 普通栋座:如果删除的是栋座下的最后一个单元,则删除栋座
        // 号位:直接删除号位
        if (param.getBuildingSetRoofId() != null) {
            ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();

            unitExample.setShardCityId(cityId);
            unitExample.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());

            int isLastUnitInRoof = erpBuildingSetUnitMapper.countByExample(unitExample);

            if (isLastUnitInRoof == 1) {
                ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
                roofExample.setShardCityId(cityId);
                roofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId()).andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
                erpBuildingSetRoofMapper.deleteByExample(roofExample);
            }
        }

        erpBuildingSetUnitMapper.delBuildUnit(cityId, deleteIdParam, 0);
        erpBuildingSetFloorMapper.delBuildFloor(cityId, deleteIdParam, 0);

        // 修改单元表中的户数
        erpBuildingSetUnitMapper.updateRoomCountInUnit(cityId, 0, param.getBuildId(), param.getBuildingSetUnitId());
        if (param.getBuildingSetRoofId() != null) {
            // 修改栋表中的户数单元数
            erpBuildingSetRoofMapper.updateRoomAndUnitCountInRoof(cityId, 0, param.getBuildId(), param.getBuildingSetRoofId());
        }
        // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数
        erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, 0, param.getBuildId());

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0,
                param.getBuildId(), null, param.getBuildingSetUnitId().toString(), "删除单元");
    }

    @Transactional
    @Override
    public String updateBuildUnit(ErpBuildingSetUnitParam param, Integer cityId, Integer compId, Integer userId) {
        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
        example.setShardCityId(cityId);
        // 栋座里面单元名不重复
        if (param.getBuildingSetRoofId() != null) {
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId())
                        .andBuildUnitEqualTo(param.getBuildUnit())
                        .andIdNotEqualTo(param.getBuildingSetUnitId());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) throw new BusinessException("该单元名已经存在！");
            }
        } else {
            // 号位里面号位不重复
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andIdNotEqualTo(param.getBuildingSetUnitId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) throw new BusinessException("该单元名已经存在！");
            }
        }

        // 注意：楼层为负十楼往上,没有0层
        Integer floorStart = param.getFloorStart();
        Integer floorEnd = param.getFloorEnd();
        String buildDoors = param.getBuildDoors();
        String newBuildUnit = param.getBuildUnit();

        GetBuildUnitRuleParam unitRuleParam = new GetBuildUnitRuleParam();
        unitRuleParam.setBuildId(param.getBuildId());
        unitRuleParam.setBuildingSetUnitId(param.getBuildingSetUnitId());
        ErpBuildingSetUnit unitDetails = erpBuildingSetUnitMapper.getBuildUnitDetailsWhenSingleAdd(cityId, compId, unitRuleParam);

        // 房号规则 1=按楼层排号，2=按单元排号
        Byte numberRule = unitDetails.getNumberRule();
        // 组成规则 1(无)=户号，2(楼层)=楼层+户号
        Byte compriseRule = unitDetails.getCompriseRule();
        // 排号类型 1=数字0~100，2=字母A~Z
        Byte numberType = unitDetails.getNumberType();
        // 房号起始
        String doorStart1 = unitDetails.getDoorStart();
        Integer doorStart = 1;
        if(StringUtil.isNotEmpty(doorStart1)){
            doorStart = StringUtil.paseInteger(doorStart1);
        }
//        int doorStart = doorStart1 == null ? 1 : doorStart1;
        // 排号类型为字母的时候,每层楼户数不能大于26个(A~Z的个数)
        if (numberType == (byte) 2 && Integer.valueOf(buildDoors) > 26) throw new BusinessException("户数大于字母个数！");
        // 栋座名称(号位的时候没有)
        String buildRoof = unitDetails.getBuildRoof();
        // 栋座ID(号位的时候没有)
        Integer buildingSetRoofId = unitDetails.getBuildingSetRoofId();
        // 每层楼从 doorStart到doorEnd：everyDoorsInFloor
        int everyDoorsInFloor = Integer.valueOf(buildDoors) + doorStart;
        // 单元名没有修改之前的名字
        String oldBuildUnit = unitDetails.getBuildUnit();

        // 修改单元信息,单元名称,梯户,楼层
        ErpBuildingSetUnit unitRecord = new ErpBuildingSetUnit();
        unitRecord.setBuildUnit(newBuildUnit);
        unitRecord.setBuildLadder(param.getBuildLadder());
        unitRecord.setBuildDoors(buildDoors);
        unitRecord.setFloorStart(floorStart);
        unitRecord.setFloorEnd(floorEnd);
        unitRecord.setRoomGenerated((byte) 1);
        unitRecord.setBuildUnitName(param.getBuildUnitName());
        unitRecord.setUpdateTime(new Date());

        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andIdEqualTo(param.getBuildingSetUnitId());
        erpBuildingSetUnitMapper.updateByExampleSelective(unitRecord, unitExample);

        List<Integer> sysBuildFloorList = new ArrayList<>();

        // 1到2层,2梯3户,生成 1,2的sysBuildFloor(楼层表)
        // 楼层排号: 1单元 1-1 1-2 1-3  2单元 1-1 1-2 1-3   单元排号： 1单元 1-1 1-2 1-3   2单元 1-1 1-2 1-3
        //                2-1 2-2 2-3       2-1 2-2 2-3                  2-4 2-5 2-6         2-4 2-5 2-6
        // 楼层排号：少了的补上,多余的删除
        // 单元排号: 清空以前的规则重新生成
        if (numberRule == (byte) 2) {
            // 将该公司该楼盘该栋该单元所有楼层规则软删除
//            ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
//            floorExample.setShardCityId(cityId);
//            floorExample.createCriteria()
//                    .andCompIdEqualTo(compId)
//                    .andBuildIdEqualTo(param.getBuildId())
//                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
//                    .andDelFlagEqualTo((byte) 0);
//            ErpBuildingSetFloor floorRecord = new ErpBuildingSetFloor();
//            floorRecord.setDelFlag((byte) 1);
//            floorRecord.setUpdateTime(new Date());
//            erpBuildingSetFloorMapper.updateByExampleSelective(floorRecord, floorExample);

            ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
            floorExample.setShardCityId(cityId);
            floorExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId()).andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId());
            erpBuildingSetFloorMapper.deleteByExample(floorExample);

            // 将该公司该楼盘该栋该单元所有房间规则软删除
//            ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
//            roomExample.setShardCityId(cityId);
//            roomExample.createCriteria()
//                    .andCompIdEqualTo(compId)
//                    .andBuildIdEqualTo(param.getBuildId())
//                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
//                    .andDelFlagEqualTo((byte) 0);
//            ErpBuildingSetRoom roomRecord = new ErpBuildingSetRoom();
//            roomRecord.setDelFlag((byte) 1);
//            roomRecord.setUpdateTime(new Date());
//            erpBuildingSetRoomMapper.updateByExampleSelective(roomRecord, roomExample);

            ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
            roomExample.setShardCityId(cityId);
            roomExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId()).andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId());
            erpBuildingSetRoomMapper.deleteByExample(roomExample);

            return param.getBuildingSetUnitId().toString();
        }

        // 获取单元下房间列表
        List<RoomWithBuildFloorDto> rooms = erpBuildingSetRoomMapper.selectRoomWithBuildFloor(cityId,
                compId, param.getBuildId(), buildingSetRoofId, param.getBuildingSetUnitId());

        // 有老数据sysRoomId是从doorStart开始的,比如应该是1-1,实际上是从1-4开始
        // 兼容这一部分sysRoomId的数据,判断房间是否从"xx-1"开始,是的话,doorStart为1,不是的话,doorStart为数据库中的数据
        boolean b = rooms.stream().anyMatch(it -> it.getSysRoomId().split("-")[1].equals("1"));
        if (b) {
            doorStart = 1;
            everyDoorsInFloor = Integer.valueOf(buildDoors) + doorStart;
        }

        List<String> sysRoomIdList = new ArrayList<>();
        String sysRoomId;
        for (int i = floorStart; i <= floorEnd; i++) {
            // 0层排除掉
            if (i == 0) continue;
            Integer sysBuildFloor = i;
            sysBuildFloorList.add(sysBuildFloor);
            for (int j = doorStart; j < everyDoorsInFloor; j++) {
                sysRoomId = i + "-" + j;
                sysRoomIdList.add(sysRoomId);
            }
        }

//        System.out.println("sysRoomIdList: " + JSON.toJSONString(sysRoomIdList));

        BuildingSetFloorParam floorParam = new BuildingSetFloorParam();
        floorParam.setBuildId(param.getBuildId());
        floorParam.setBuildingSetUnitId(param.getBuildingSetUnitId());
        List<ErpBuildingSetFloor> floors = erpBuildingSetFloorMapper.selectBuildFloor(cityId, floorParam, compId);
        // 该单元已经存在的楼层sysBuildFloor
        List<Integer> alreadySysBuildFloors = floors.stream().map(it -> Integer.valueOf(it.getSysBuildFloor())).collect(Collectors.toList());

        // 该单元已经存在的房间sysRoomIds
        List<String> alreadySysRoomIds = rooms.stream().map(RoomWithBuildFloorDto::getSysRoomId).collect(Collectors.toList());

        // 已有的房间和新的要添加的房间的重合部分
        List<String> bothSysRoomIds = new ArrayList<>();
        for (String aSysRoomIdList : sysRoomIdList) {
            for (String alreadySysRoomId : alreadySysRoomIds) {
                if (aSysRoomIdList.equals(alreadySysRoomId)) {
                    bothSysRoomIds.add(aSysRoomIdList);
                }
            }
        }

//        System.out.println("bothSysRoomIds: " + JSON.toJSONString(bothSysRoomIds));

        // 注: 房间数量减少的时候,不删除原有房间,故注释掉删除房间的代码
//        List<String> needDelRooms = alreadySysRoomIds.stream().filter(it -> !bothSysRoomIds.contains(it)).collect(Collectors.toList());

//        System.out.println("needDelRooms: " + JSON.toJSONString(bothSysRoomIds));

        // 批量删除房间,每次最多两百条
//        int delBaseCount = 200;
//        if (needDelRooms.size() > 0) {
//            for (int i = 0; i < needDelRooms.size(); i += delBaseCount) {
//                List<String> current = needDelRooms.stream().skip(i).limit(delBaseCount).collect(Collectors.toList());
//                if (current.size() > 0)
//                    // 重合部分不删除
//                    erpBuildingSetRoomMapper.delBuildRoomBySysRoomId(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId(), current);
//            }
//        }

        // 号位规则, 房间MD5不带楼层
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        // 如果单元名修改,则修改重合部分房间的Md5,修改楼层表中单元名称信息,修改房间表中单元名称信息
        if (!newBuildUnit.equals(oldBuildUnit)) {
            List<RoomWithBuildFloorDto> needUpdateMd5Rooms = rooms.stream().filter(it -> bothSysRoomIds.contains(it.getSysRoomId())).collect(Collectors.toList());

            List<BatchUpdateRoomMd5> batchUpdateRoomMd5s = new ArrayList<>();
            for (RoomWithBuildFloorDto room : needUpdateMd5Rooms) {

                String buildFloor = room.getBuildFloor();
                String roomId = room.getRoomId();
                Integer buildingSetRoomId = room.getBuildingSetRoomId();

                // 需要更新的MD5
                String addMd5;
                if ("2".equals(paramValue)) {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), newBuildUnit, roomId);
                } else {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, newBuildUnit, buildFloor, roomId);
                }

                // 老MD5
                String oldAddMd5;
                if ("2".equals(paramValue)) {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), oldBuildUnit, roomId);
                } else {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, oldBuildUnit, buildFloor, roomId);
                }

                BatchUpdateRoomMd5 batchUpdateRoomMd5 = new BatchUpdateRoomMd5();
                batchUpdateRoomMd5.setBuildId(param.getBuildId());
                batchUpdateRoomMd5.setBuildingSetRoomId(buildingSetRoomId);
                batchUpdateRoomMd5.setAddMd5(addMd5);
                batchUpdateRoomMd5.setOldAddMd5(oldAddMd5);
                batchUpdateRoomMd5.setBuildUnit(newBuildUnit);
                batchUpdateRoomMd5s.add(batchUpdateRoomMd5);
            }

            // 批量添加房间,每次最多一百条
            int addBaseCount = 100;

            if (batchUpdateRoomMd5s.size() > 0) {
                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += addBaseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(addBaseCount).collect(Collectors.toList());
                    if (current.size() > 0)
                        erpBuildingSetRoomMapper.batchUpdateRoomMd5(cityId, compId, param.getBuildId(), current);
                }

                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += addBaseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(addBaseCount).collect(Collectors.toList());
                    if (current.size() > 0)
                        erpBuildingMarketingControlMapper.batchUpdateRoomMd5(cityId, compId, param.getBuildId(), current);
                }
            }

            // 修改楼层表中单元名称信息
            ErpBuildingSetFloor floorRecord = new ErpBuildingSetFloor();
            floorRecord.setBuildUnit(param.getBuildUnit());
            floorRecord.setUpdateTime(new Date());

            ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
            floorExample.setShardCityId(cityId);
            floorExample.createCriteria()
                    .andCompIdEqualTo(compId)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId());
            erpBuildingSetFloorMapper.updateByExampleSelective(floorRecord, floorExample);

            // 修改房间表中单元名称信息
            ErpBuildingSetRoom roomRecord = new ErpBuildingSetRoom();
            roomRecord.setBuildUnit(param.getBuildUnit());
            roomRecord.setUpdateTime(new Date());

            ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
            roomExample.setShardCityId(cityId);
            roomExample.createCriteria()
                    .andCompIdEqualTo(compId)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andIdEqualTo(param.getBuildingSetUnitId());
            erpBuildingSetRoomMapper.updateByExampleSelective(roomRecord, roomExample);
        }

        List<BatchAddRoom> batchAddRooms = new ArrayList<>();

        // 去除重合部分,添加新设置的房间(2梯4户,1到2层,重合部分如果为1-1则不添加1楼1号房)
        Integer roomFloor;
        String sysRoomIdInAdd;
        String roomId;
        for (int i = floorStart; i <= floorEnd; i++) {
            // 排除0层
            if (i == 0) continue;
            roomFloor = i;
            for (int j = doorStart; j < everyDoorsInFloor; j++) {
                sysRoomIdInAdd = i + "-" + j;

                /*
                 * floorStart: -1
                 * doorStart:1                                                                       -201 -202 -203                        -2A -2B -2C
                 * 组成规则为1,排号类型为1  1 2 3   组成规则为1,排号类型为2  A B C  组成规则为2,排号类型为1  -101 -102 -103  组成规则为2,排号类型为2 -1A -1B -1C
                 *                       1 2 3                          A B C                         101 102 103                           1A 1B 1C
                 * floorStart: 1
                 * doorStart:1
                 * 组成规则为1,排号类型为1  1 2 3   组成规则为1,排号类型为2  A B C  组成规则为2,排号类型为1  101 102 103  组成规则为2,排号类型为2 1A 1B 1C
                 *                       1 2 3                          A B C                        201 202 203                        2A 2B 2C
                 * floorStart: 1
                 * doorStart:2
                 * 组成规则为1,排号类型为1  2 3 4   组成规则为1,排号类型为2  B C D  组成规则为2,排号类型为1  102 103 104  组成规则为2,排号类型为2 1B 1C 1D
                 *                       2 3 4                          B C D                        202 203 204                        2B 2C 2D
                 *
                 *  A的char值为65
                 * */
                // 组成规则 1(无)=户号，2(楼层)=楼层+户号

                int roomDoorStart = j;
                // 有老数据sysRoomId是从doorStart开始的,比如应该是1-1,实际上是从1-4开始
                // 兼容这一部分sysRoomId的数据,判断房间是否从"xx-1"开始,是的话,doorStart为1,不是的话,doorStart为数据库中的数据
                // 此时roomId重新计算
                if (doorStart == 1) {
                    roomDoorStart = 1;
                    if(StringUtil.isNotEmpty(doorStart1)){
                        roomDoorStart = StringUtil.paseInteger(doorStart1);
                    }
//                    roomDoorStart = doorStart1 == null ? 1 : doorStart1;
                    roomDoorStart = roomDoorStart + j - 1;
                }

                if (compriseRule == (byte) 1) {
                    // 排号类型 1=数字0~100，2=字母A~Z
                    if (numberType == (byte) 2) {
                        roomId = String.valueOf((char) (roomDoorStart + 64));
                    } else {
                        roomId = roomDoorStart + "";
                    }
                } else {
                    if (numberType == (byte) 2) {
                        roomId = i + String.valueOf((char) (roomDoorStart + 64));
                    } else {
                        if (i < 0) {
                            roomId = i * 100 - roomDoorStart + "";
                        } else {
                            roomId = i * 100 + roomDoorStart + "";
                        }
                    }
                }

//                System.out.println("roomId: " + roomId);
//                System.out.println("contains: " + !bothSysRoomIds.contains(sysRoomIdInAdd));

                if (!bothSysRoomIds.contains(sysRoomIdInAdd)) {
                    BatchAddRoom batchAddRoom = new BatchAddRoom();

                    batchAddRoom.setSysRoomIdInAdd(sysRoomIdInAdd);
                    batchAddRoom.setRoomFloor(roomFloor);
                    batchAddRoom.setRoomId(roomId);

                    // 需要更新的MD5
                    String addMd5;
                    if ("2".equals(paramValue)) {
                        addMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), newBuildUnit, roomId);
                    } else {
                        addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, newBuildUnit, roomFloor.toString(), roomId);
                    }

                    // 房间md5
//                    String addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, newBuildUnit, roomFloor.toString(), roomId);
                    batchAddRoom.setAddMd5(addMd5);
                    batchAddRooms.add(batchAddRoom);
                }
            }
        }
//        System.out.println("batchAddRooms: " + JSON.toJSONString(batchAddRooms));

        List<ErpBuildingSetRoom> list = new ArrayList<>();

        for (BatchAddRoom batchAddRoom : batchAddRooms) {
            ErpBuildingSetRoom erpBuildingSetRoom = new ErpBuildingSetRoom();

            erpBuildingSetRoom.setCityId(cityId);
            erpBuildingSetRoom.setCompId(compId);
            erpBuildingSetRoom.setBuildId(param.getBuildId());
            if (buildRoof != null) erpBuildingSetRoom.setBuildRoof(buildRoof);
            erpBuildingSetRoom.setBuildUnit(newBuildUnit);
            erpBuildingSetRoom.setBuildingSetRoofId(buildingSetRoofId);
            erpBuildingSetRoom.setBuildingSetUnitId(param.getBuildingSetUnitId());

            erpBuildingSetRoom.setSysRoomId(batchAddRoom.getSysRoomIdInAdd());
            erpBuildingSetRoom.setRoomId(batchAddRoom.getRoomId());
            erpBuildingSetRoom.setRoomFloor(batchAddRoom.getRoomFloor() == null ? "" : batchAddRoom.getRoomFloor().toString());
            erpBuildingSetRoom.setAddrMd5(batchAddRoom.getAddMd5());

            list.add(erpBuildingSetRoom);
        }

        if (batchAddRooms.size() > 5000) throw new BusinessException("每个单元一次性生成房间数不超过5000个！");

        // 批量添加房间,每次最多一百条
        int baseCount = 100;

        if (batchAddRooms.size() > 0) {
            for (int i = 0; i < list.size(); i += baseCount) {
                List<ErpBuildingSetRoom> current = list.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) erpBuildingSetRoomMapper.batchAddRooms(cityId, current);
            }
        }

        // 新的要修改的楼层,排除已经存在的楼层 = 需要添加的楼层
        List<Integer> needAddFloors = sysBuildFloorList.stream().filter(it -> !alreadySysBuildFloors.contains(it)).collect(Collectors.toList());
        // 添加需要添加的楼层
        if (needAddFloors.size() > 0) {
//            System.out.println("needAddFloors: " + JSON.toJSONString(needAddFloors));
            // 批量添加
            erpBuildingSetFloorMapper.batchAddBuildFloor(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId(), needAddFloors);
        }

        // 注: 房间数量减少的时候,不删除原有房间以及所在楼层,故注释掉删除楼层的代码
        // 已经存在的楼层,排除新的要修改的楼层 = 要删除的楼层
//        List<Integer> needDelFloors = alreadySysBuildFloors.stream().filter(it -> !sysBuildFloorList.contains(it)).collect(Collectors.toList());
//        // 删除要删除的楼层
//        if (needDelFloors.size() > 0) {
////            System.out.println("needDelFloors: " + JSON.toJSONString(needDelFloors));
//            erpBuildingSetFloorMapper.delBuildFloorBySysBuildFloor(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId(), needDelFloors);
//        }

        // 新添加的房间关联楼层(更改room表的楼层id)
        erpBuildingSetRoomMapper.updateFloorIdInRoom(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId());

        // 修改单元表中的户数
        erpBuildingSetUnitMapper.updateRoomCountInUnit(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId());
        if (buildingSetRoofId != null) {
            // 修改栋表中的户数单元数
            erpBuildingSetRoofMapper.updateRoomAndUnitCountInRoof(cityId, compId, param.getBuildId(), buildingSetRoofId);
        }
        // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数
        erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());

        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, param.getBuildId(), "", param.getBuildingSetUnitId().toString(), "编辑单元或者号位");

        return "";
    }

    @Override
    public ErpbuildingSetUnitByRoofIdListVO getBuildSetUnitByRoofId(ErpbuildingSetUnitByRoofIdParam param, Integer compId, Integer cityId) {
        ErpbuildingSetUnitByRoofIdListVO erpbuildingSetUnitByRoofIdListVO = new ErpbuildingSetUnitByRoofIdListVO();
        List<ErpbuildingSetUnitByRoofIdVO> erpbuildingSetUnitByRoofIdVOList = new ArrayList<>();
        ErpBuildingSetUnitExample erpBuildingSetUnitExample = new ErpBuildingSetUnitExample();
        erpBuildingSetUnitExample.createCriteria().andCompIdEqualTo(0).andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId()).andDelFlagNotEqualTo((byte) 1);
        erpBuildingSetUnitExample.setShardCityId(cityId);
        List<ErpBuildingSetUnit> erpBuildingSetUnitList = erpBuildingSetUnitMapper.selectByExample(erpBuildingSetUnitExample);
        if (erpBuildingSetUnitList.size() <= 0) {
            return null;
        }
        for (ErpBuildingSetUnit erpBuildingSetUnit : erpBuildingSetUnitList) {
            ErpbuildingSetUnitByRoofIdVO erpbuildingSetUnitByRoofIdVO = new ErpbuildingSetUnitByRoofIdVO();
            BeanUtils.copyProperties(erpBuildingSetUnit, erpbuildingSetUnitByRoofIdVO);
            erpbuildingSetUnitByRoofIdVOList.add(erpbuildingSetUnitByRoofIdVO);
        }
        erpbuildingSetUnitByRoofIdListVO.setErpbuildingSetUnitByRoofIdVOList(erpbuildingSetUnitByRoofIdVOList);
        return erpbuildingSetUnitByRoofIdListVO;
    }

    @Transactional
    @Override
    public String addBuildUnit(ErpBuildingSetUnitAddParam param, Integer cityId, Integer compId, Integer userId, Integer provinceId, String compNo) {
        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
        example.setShardCityId(cityId);
        // 栋座里面单元名不重复
        if (param.getBuildingSetRoofId() != null) {
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该单元名已经存在！");
                }
            }
        } else {
            // 号位里面号位不重复
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该单元名已经存在！");
                }
            }
        }

        boolean isOnlyOneUnit = StringUtils.isNotBlank(param.getBuildUnit());
        Integer floorStart = param.getFloorStart() == null ? 0 : param.getFloorStart();
        Integer floorEnd = param.getFloorEnd() == null ? 0 : param.getFloorEnd();
        String buildDoors = param.getBuildDoors() == null ? "0" : param.getBuildDoors();

        // -2楼到-1楼是2层,-1楼到1楼是2层,1楼到2楼是2层
        int floorCount;
        if (floorEnd > 0 && floorStart > 0) {
            floorCount = floorEnd - floorStart + 1;
        } else if (floorEnd < 0 && floorStart < 0) {
            floorCount = floorEnd - floorStart + 1;
        } else {
            floorCount = floorEnd - floorStart;
        }
        // 每个单元需要生成的房间数
        int everyRoomCountInUnit = floorCount * Integer.valueOf(buildDoors);
        if (everyRoomCountInUnit > 5000) {
            throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
        }

        if (isOnlyOneUnit) {
            this.checkUnitNameRepeat(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildUnit());

            ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
            BeanUtils.copyProperties(param, unit);
            unit.setShardCityId(cityId);
            unit.setProvinceId(provinceId);
            unit.setCityId(cityId);
            unit.setCompId(compId);
            unit.setCompNo(compNo);
            unit.setCreateTime(new Date());
            unit.setRoomGenerated((byte) 0);
            unit.setDoors(everyRoomCountInUnit);

            erpBuildingSetUnitMapper.insertSelective(unit);
            return unit.getId().toString();
        }

        List<String> unitNameList = this.unitAnalysis(param, cityId, compId, param.getBuildId());
        if (unitNameList.size() > 255) {
            throw new BusinessException("一次性生成单元数不超过255个！");
        }

        // 所有需要添加的单元
        List<ErpBuildingSetUnit> insertUnitList = new ArrayList<>();
        // 是否通排
        Byte addedByAllUnits = param.getAddedByAllUnits() == null ? (byte) 0 : param.getAddedByAllUnits();
        // 原本的doorStart
        int doorStart = param.getDoorStart() == null ? 1 : param.getDoorStart();
        Integer doorStartInUnit;

        for(int i = 0; i < unitNameList.size(); i++) {
            ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
            BeanUtils.copyProperties(param, unit);
            unit.setShardCityId(cityId);
            unit.setProvinceId(provinceId);
            unit.setCityId(cityId);
            unit.setCompId(compId);
            unit.setCompNo(compNo);
            unit.setCreateTime(new Date());
            unit.setRoomGenerated((byte) 0);
            unit.setDoors(everyRoomCountInUnit);
            unit.setBuildUnit(unitNameList.get(i));

            // 每个单元的房间起始通过是否通排计算出来,在原本的doorStart基础上增加
            // 通排:  1单元 doorStartInUnit:1  2单元 doorStartInUnit:101 3单元 doorStartInUnit:201
            // 非通排 1单元 doorStartInUnit:1  2单元 doorStartInUnit:1 3单元 doorStartInUnit:1
            if (addedByAllUnits.equals((byte) 1)) {
                doorStartInUnit = doorStart + Integer.valueOf(buildDoors) * i;
                unit.setDoorStart(doorStartInUnit.toString());
            }
            insertUnitList.add(unit);
        }

        // 添加单元前的单元ID
        List<Integer> before = erpBuildingSetUnitMapper.getUnitIds(cityId, compId, param.getBuildId());

        int baseCount = 50;
        if (insertUnitList.size() > 0) {
            for (int i = 0; i < insertUnitList.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = insertUnitList.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加单元
                    erpBuildingSetUnitMapper.batchAddUnit(cityId, compId, param.getBuildId(), current);
                }
            }
        }

        // 添加单元后的单元ID
        List<Integer> after = erpBuildingSetUnitMapper.getUnitIds(cityId, compId, param.getBuildId());

        List<Integer> addUnitIds;

        if (before == null || before.size() == 0) {
            addUnitIds = after;
        } else {
            // 添加单元后的单元ID - 添加单元前的单元ID = 新添加的单元ID
            addUnitIds = after.stream().filter(it -> !before.contains(it)).collect(Collectors.toList());
        }

        List<String> unitList = addUnitIds.stream().distinct().map(Object::toString).collect(Collectors.toList());
        String unitIds = String.join(",", unitList);

        ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
        roofUnitDoorsExample.setShardCityId(cityId);
        roofUnitDoorsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId());
        int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

        int totalRoomCount = unitList.size() * everyRoomCountInUnit;

        if (roofUnitDoorsCount == 0) {
            ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
            record.setShardCityId(cityId);
            record.setCityId(cityId);
            record.setCompId(compId);
            record.setBuildId(param.getBuildId());
            record.setUnits(unitList.size());
            record.setDoors(totalRoomCount);
            erpFunBuildRoofunitdoorsMapper.insertSelective(record);
        } else {
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数
//            erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
            erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, compId, param.getBuildId(), totalRoomCount, unitList.size(), null);
        }

        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, param.getBuildId(), "", "", "新增单元");
        return unitIds;
    }

    /*
     *
     * 解析单元时判重
     * 返回值: ["1单元", "2单元", "3单元"]
     * */
    public List<String> unitAnalysis(ErpBuildingSetUnitAddParam param, Integer cityId, Integer compId, Integer buildId) {
        int startUnit, endUnit;
        List<String> unitNameList = new ArrayList<>();

        // 单元后缀类型，1=数字，2=字母
        switch (param.getInunitSuffixType()) {
            case 1:
                startUnit = StringUtil.parseInteger(param.getUnitSuffixStart(), 1);
                endUnit = StringUtil.parseInteger(param.getUnitSuffixEnd(), 1);
                break;
            case 2:
                startUnit = param.getUnitSuffixStart().charAt(0);
                endUnit = param.getUnitSuffixEnd().charAt(0);
                break;
            default:
                startUnit = HeavenlyStem.heavenlyStemMap.get(param.getUnitSuffixStart());
                endUnit = HeavenlyStem.heavenlyStemMap.get(param.getUnitSuffixEnd());
        }

        for (int unit = startUnit; unit <= endUnit; unit++) {
            String unitStr = param.getUnitPreFix();

            switch (param.getInunitSuffixType()) {
                case 1:
                    unitStr += unit;
                    break;
                case 2:
                    unitStr += String.valueOf((char) unit);
                    break;
                default:
                    unitStr += HeavenlyStem.heavenlyStem[unit];
            }

            this.checkUnitNameRepeat(cityId, compId, buildId, param.getBuildingSetRoofId(), unitStr);
            unitNameList.add(unitStr);
        }

        return unitNameList;
    }

    private void checkUnitNameRepeat(Integer cityId, Integer compId, Integer buildId, Integer buildingSetRoofId, String buildUnit) {
        // 该楼盘,该栋座,该单元是否有重复
        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
        example.setShardCityId(cityId);
        // 号室没有 buildingSetRoofId
        if (buildingSetRoofId == null) {
            example.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId)
                    .andBuildUnitEqualTo(buildUnit);
        } else {
            example.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId)
                    .andBuildingSetRoofIdEqualTo(buildingSetRoofId).andBuildUnitEqualTo(buildUnit);
        }

        int repeatCount = erpBuildingSetUnitMapper.countByExample(example);

        if (repeatCount > 0) {
            // 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
            String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
            if ("2".equals(paramVal)) {
                throw new BusinessException("号位与已有号位重复，请重新填写");
            } else if (StringUtils.isNotBlank(buildUnit)) {
                throw new BusinessException("单元名称与已有单元名称重复，请重新填写");
            }
        }
    }

    @Transactional
    @Override
    public void updateLockBuildRule(Integer cityId, Integer compId,String compNo,Integer provinceId , Integer buildId ,Integer buildLock, Integer userId, Integer deptId) {
        boolean lockBuilding = erpUserOpersService.judgePermission(cityId, userId, "LOCK_BUILDING");
        if (!lockBuilding) {
            // 没锁定权限
            throw new BusinessException("没锁定权限！！");
        }

/*        if (buildLock == 1) {
            // 锁定时判断有没有comp_id=0的，没有则新增
            Integer count = erpBuildingSetUnitMapper.checkHasRule(cityId,buildId);
            if (count < 1) {
                // 不存在时创建模板
                List<String> compNoTmp = Arrays.asList(
                        "AA01", "A23Y", "BK72", "BK90", "BW70", "AEKQ", "B673", "BGS3", "BAF5",
                        "BP58", "BJ08", "BZB2", "BLY8", "ARR3", "ATWE", "BEF4", "BX41", "BKY8",
                        "BZ74", "B472", "BFM8", "BMP8", "BWB6", "BHT9", "BDH8", "BPJ1", "BZE2");
                if(!compNoTmp.contains(compNo)) {
                    erpBuildingSetUnitMapper.createTemp(cityId,compId,compNo,provinceId, buildId);
                }
            }
        }*/
        // 修改锁定状态
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(cityId, 0, buildId);
        if(erpBuildingSetSetting == null) {
            erpBuildingSetSetting = new ErpBuildingSetSetting();
            erpBuildingSetSetting.setCompId(0);
            erpBuildingSetSetting.setShardCityId(cityId);
            erpBuildingSetSetting.setCreationTime(new Date());
            erpBuildingSetSetting.setBuildId(buildId);
            erpBuildingSetSetting.setBuildLock(buildLock.byteValue());
            erpBuildingSetSetting.setDeptId(deptId);
            erpBuildingSetSettingMapper.insertSelective(erpBuildingSetSetting);
        } else {
            erpBuildingSetSettingMapper.updateLockBuildRule(cityId, 0, deptId, buildId, buildLock);
        }

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0,buildId, null,null,(buildLock == 0) ? "解锁规则" : "锁定规则");
    }

    @Override
    public String addBuildUnitV2(UnitSingleAddParam param, GeneralParam generalParam, boolean isCopy) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer provinceId = generalParam.getProvinceId();
        String compNo = generalParam.getCompNo();
        Integer userId = generalParam.getUserId();

        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
        example.setShardCityId(cityId);
        // 栋座里面单元名不重复
        if (param.getBuildingSetRoofId() != null) {
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该单元名已经存在！");
                }
            }
        } else {
            // 号位里面号位不重复
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该号位已经存在！");
                }
            }
        }

        Integer floorStart = param.getFloorStart() == null ? 0 : param.getFloorStart();
        Integer floorEnd = param.getFloorEnd() == null ? 0 : param.getFloorEnd();
        String buildDoors = param.getBuildDoors() == null ? "0" : param.getBuildDoors();
        Integer doorStart = 1 ;
        if(StringUtil.isNotEmpty(param.getDoorStart())){
            doorStart=StringUtil.paseInteger(param.getDoorStart());
        }
//        int doorStart = param.getDoorStart() == null ? 1 : param.getDoorStart();

        // 字母排的情况下, 不能超过26个字母
        boolean letter = (param.getRoomCompositionRule() == (byte) 2 ||
                param.getRoomCompositionRule() == (byte) 4 ||
                param.getRoomCompositionRule() == (byte) 5)
                && Integer.valueOf(buildDoors) + doorStart - 1 > 26;

        if (letter) {
            throw new BusinessException("户数大于字母个数！");
        }

        // -2楼到-1楼是2层,-1楼到1楼是2层,1楼到2楼是2层
        int floorCount;
        if (floorEnd > 0 && floorStart > 0) {
            floorCount = floorEnd - floorStart + 1;
        } else if (floorEnd < 0 && floorStart < 0) {
            floorCount = floorEnd - floorStart + 1;
        } else {
            floorCount = floorEnd - floorStart;
        }
        // 每个单元需要生成的房间数
        int totalRoomCount = floorCount * Integer.valueOf(buildDoors);
        if (totalRoomCount > 5000) {
            throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
        }

        this.checkUnitNameRepeat(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildUnit());

        ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
        BeanUtils.copyProperties(param, unit);
        unit.setShardCityId(cityId);
        unit.setProvinceId(provinceId);
        unit.setCityId(cityId);
        unit.setCompId(0);
        unit.setCompNo("");
        unit.setCreateTime(new Date());
        unit.setRoomGenerated((byte) 0);
        unit.setDoors(totalRoomCount);

        UnitAddParam unitAddParam = new UnitAddParam();
        unitAddParam.setRoomSortRule(param.getRoomSortRule());
        unitAddParam.setRoomCompositionRule(param.getRoomCompositionRule());
        RoomRuleDto roomRuleDto = erpBuildingSetRoofService.generateRoomRule(param.getRoomSortRule(), param.getRoomCompositionRule());
        unit.setNumberRule(roomRuleDto.getNumberRule());
        unit.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
        unit.setNumberType(roomRuleDto.getNumberType());
        unit.setCompriseRule(roomRuleDto.getCompriseRule());
        unit.setDoorStartInPage(param.getDoorStart());

        if (param.getBuildingSetRoofId() != null) {
            ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
            roof.setShardCityId(cityId);
            roof.setCompId(0);
            roof.setBuildId(param.getBuildId());
            roof.setBuildingSetRoofId(param.getBuildingSetRoofId());
            ErpBuildingSetRoof erpBuildingSetRoof = erpBuildingSetRoofMapper.selectByPrimaryKey(roof);

            if (erpBuildingSetRoof != null && erpBuildingSetRoof.getBuildRoof() != null) {
                unit.setBuildRoof(erpBuildingSetRoof.getBuildRoof());
            }
        }

        erpBuildingSetUnitMapper.insertSelective(unit);

        ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
        roofUnitDoorsExample.setShardCityId(cityId);
        roofUnitDoorsExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

        if (roofUnitDoorsCount == 0) {
            ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
            record.setShardCityId(cityId);
            record.setCityId(cityId);
            record.setCompId(0);
            record.setBuildId(param.getBuildId());
            record.setUnits(1);
            record.setDoors(totalRoomCount);
            erpFunBuildRoofunitdoorsMapper.insertSelective(record);
        } else {
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
            erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, compId, param.getBuildId(), totalRoomCount, 1, null);
        }

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), "", param.getBuildUnit(), isCopy ? "复制单元" : "新增单元");

        return unit.getId().toString();
    }

    @Override
    public String updateBuildUnitV2(UnitEditParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer provinceId = generalParam.getProvinceId();
        Integer userId = generalParam.getUserId();
        String compNo = generalParam.getCompNo();
        Integer buildId = param.getBuildId();
        Integer buildingSetUnitId = param.getBuildingSetUnitId();

        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
        example.setShardCityId(cityId);
        // 栋座里面单元名不重复
        if (param.getBuildingSetRoofId() != null) {
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId())
                        .andBuildUnitEqualTo(param.getBuildUnit())
                        .andIdNotEqualTo(param.getBuildingSetUnitId());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该单元名已经存在！");
                }
            }
        } else {
            // 号位里面号位不重复
            if (param.getBuildUnit() != null) {
                example.createCriteria()
                        .andCompIdEqualTo(0)
                        .andBuildIdEqualTo(param.getBuildId())
                        .andIdNotEqualTo(param.getBuildingSetUnitId())
                        .andBuildUnitEqualTo(param.getBuildUnit());
                int count = erpBuildingSetUnitMapper.countByExample(example);
                if (count > 0) {
                    throw new BusinessException("该号位已经存在！");
                }
            }
        }

        // 号位规则, 房间MD5不带楼层
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        // 只是修改了单元或者号位名字
        if (param.getOnlyUpdateBase() != null && param.getOnlyUpdateBase() == 1) {
            String newBuildUnit = param.getBuildUnit();

            ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();
            erpBuildingSetUnit.setBuildUnit(param.getBuildUnit());
            erpBuildingSetUnit.setBuildLadder(param.getBuildLadder());
            ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
            unitExample.setShardCityId(cityId);
            unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andIdEqualTo(buildingSetUnitId);
            erpBuildingSetUnitMapper.updateByExampleSelective(erpBuildingSetUnit, unitExample);

            // 获取单元下房间列表
            List<RoomWithBuildFloorDto> rooms = erpBuildingSetRoomMapper.selectRoomWithBuildFloor(cityId,
                    0, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildingSetUnitId());

            List<BatchUpdateRoomMd5> batchUpdateRoomMd5s = new ArrayList<>();
            for (RoomWithBuildFloorDto room : rooms) {
                String buildRoof = room.getBuildRoof();
                String oldBuildUnit = room.getBuildUnit();
                String buildFloor = room.getBuildFloor();
                String roomId = room.getRoomId();
                // 主键ID
                Integer buildingSetRoomId = room.getBuildingSetRoomId();

                // 需要更新的MD5
                String addMd5;
                if ("2".equals(paramValue)) {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), newBuildUnit, roomId);
                } else {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, newBuildUnit, buildFloor, roomId);
                }

                // 老MD5
                String oldAddMd5;
                if ("2".equals(paramValue)) {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), oldBuildUnit, roomId);
                } else {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, oldBuildUnit, buildFloor, roomId);
                }

                BatchUpdateRoomMd5 batchUpdateRoomMd5 = new BatchUpdateRoomMd5();
                batchUpdateRoomMd5.setBuildId(param.getBuildId());
                batchUpdateRoomMd5.setBuildingSetRoomId(buildingSetRoomId);
                batchUpdateRoomMd5.setAddMd5(addMd5);
                batchUpdateRoomMd5.setOldAddMd5(oldAddMd5);
                batchUpdateRoomMd5.setBuildUnit(newBuildUnit);
                batchUpdateRoomMd5s.add(batchUpdateRoomMd5);
            }

            // 批量编辑房间信息(包含MD5)
            int baseCount = 100;

            if (batchUpdateRoomMd5s.size() > 0) {
                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += baseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        erpBuildingSetRoomMapper.batchUpdateRoomMd5(cityId, 0, param.getBuildId(), current);
                    }
                }

                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += baseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        erpBuildingMarketingControlMapper.batchUpdateRoomMd5(cityId, 0, param.getBuildId(), current);
                    }
                }
            }

            // 修改楼层表中单元名称信息
            ErpBuildingSetFloor floorRecord = new ErpBuildingSetFloor();
            floorRecord.setBuildUnit(param.getBuildUnit());
            floorRecord.setUpdateTime(new Date());

            ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
            floorExample.setShardCityId(cityId);
            floorExample.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId());
            erpBuildingSetFloorMapper.updateByExampleSelective(floorRecord, floorExample);

            erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), "", param.getBuildUnit(), "2".equals(paramValue) ? "编辑号位" : "编辑单元");
            return "";
        }

        // 将该公司该楼盘该栋所有楼层规则删除
        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetUnitIdEqualTo(buildingSetUnitId);
        erpBuildingSetFloorMapper.deleteByExample(floorExample);

        // 将该公司该楼盘该栋所有房间规则删除
        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetUnitIdEqualTo(buildingSetUnitId);
        erpBuildingSetRoomMapper.deleteByExample(roomExample);

        Integer floorStart = param.getFloorStart() == null ? 0 : param.getFloorStart();
        Integer floorEnd = param.getFloorEnd() == null ? 0 : param.getFloorEnd();
        String buildDoors = param.getBuildDoors() == null ? "0" : param.getBuildDoors();

        // -2楼到-1楼是2层,-1楼到1楼是2层,1楼到2楼是2层
        int floorCount;
        if (floorEnd > 0 && floorStart > 0) {
            floorCount = floorEnd - floorStart + 1;
        } else if (floorEnd < 0 && floorStart < 0) {
            floorCount = floorEnd - floorStart + 1;
        } else {
            floorCount = floorEnd - floorStart;
        }

        // 该单元生成的房间数量
        int totalRoomCountInUnit = floorCount * Integer.valueOf(buildDoors);
        if (totalRoomCountInUnit > 5000) {
            throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
        }

        ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();
        BeanUtils.copyProperties(param, erpBuildingSetUnit);
        erpBuildingSetUnit.setProvinceId(provinceId);
        erpBuildingSetUnit.setCityId(cityId);
        erpBuildingSetUnit.setCompId(0);
        erpBuildingSetUnit.setCompNo(compNo);
        erpBuildingSetUnit.setBuildId(buildId);
        erpBuildingSetUnit.setBuildUnit(param.getBuildUnit());
        erpBuildingSetUnit.setRoomGenerated((byte) 0);
        erpBuildingSetUnit.setDoors(totalRoomCountInUnit);
        erpBuildingSetUnit.setCreateTime(new Date());
        erpBuildingSetUnit.setUpdateTime(new Date());
        erpBuildingSetUnit.setBuildLadder(param.getBuildLadder());
        erpBuildingSetUnit.setBuildDoors(param.getBuildDoors());

        UnitAddParam unitAddParam = new UnitAddParam();
        unitAddParam.setRoomCompositionRule(param.getRoomCompositionRule());
        unitAddParam.setRoomSortRule(param.getRoomSortRule());

        RoomRuleDto roomRuleDto = erpBuildingSetRoofService.generateRoomRule(param.getRoomSortRule(), param.getRoomCompositionRule());
        erpBuildingSetUnit.setNumberRule(roomRuleDto.getNumberRule());
        erpBuildingSetUnit.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
        erpBuildingSetUnit.setNumberType(roomRuleDto.getNumberType());
        erpBuildingSetUnit.setCompriseRule(roomRuleDto.getCompriseRule());
        erpBuildingSetUnit.setDoorStartInPage(param.getDoorStart());

        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andIdEqualTo(buildingSetUnitId);
        erpBuildingSetUnitMapper.updateByExampleSelective(erpBuildingSetUnit, unitExample);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), "", param.getBuildUnit(), "2".equals(paramValue) ? "编辑号位" : "编辑单元");

        return buildingSetUnitId.toString();
    }

    @Override
    public UnitDetailsVo getBuildUnitRuleV2(GetBuildUnitRuleParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();

        ErpBuildingSetUnitDetailsVO detailsVO = erpBuildingSetUnitMapper.getBuildUnitRule(cityId, 0, param);
        UnitDetailsVo unitDetails = new UnitDetailsVo();
        BeanUtils.copyProperties(detailsVO, unitDetails);

        RoomRuleDto dto = erpBuildingSetRoofService.generateRoomRuleWhenShow(detailsVO.getNumberRule(),
                detailsVO.getAddedByAllUnits(), detailsVO.getNumberType(), detailsVO.getCompriseRule());
        unitDetails.setRoomSortRule(dto.getRoomSortRule());
        unitDetails.setRoomCompositionRule(dto.getRoomCompositionRule());
        unitDetails.setDoorStart(detailsVO.getDoorStartInPage());

        return unitDetails;
    }

    @Override
    public String addBuildUnitRule(BuildUnitRuleAddParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer provinceId = generalParam.getProvinceId();
        String compNo = generalParam.getCompNo();
        Integer userId = generalParam.getUserId();
        Integer buildId = param.getBuildId();

        ErpBuildingSetUnitExample erpBuildingSetUnitExample = new ErpBuildingSetUnitExample();
        erpBuildingSetUnitExample.setShardCityId(cityId);
        erpBuildingSetUnitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        int unitCount = erpBuildingSetUnitMapper.countByExample(erpBuildingSetUnitExample);

        if (unitCount > 0) {
            throw new BusinessException("当前公司当前楼盘已有号位规则，请不要重复首次创建！");
        }

        // 添加楼盘管理员
        if (param.getBuildingManagerId() != null) {
            CreatOrEditManagerParam managerParam = new CreatOrEditManagerParam();
            managerParam.setCityId(cityId);
            managerParam.setCompId(compId);
            managerParam.setBuildId(param.getBuildId());

            // 备注:前端传的 buildingManagerId 为用户ID, 后端存的 buildingManagerId 为 BUILDING_MANAGER 主键ID, 在此更新
            // 栋座详情中用 buildingManagerId JOIN BUILDING_MANAGER 表,返回用户ID
            managerParam.setUserId(param.getBuildingManagerId());
            erpBuildingManagerService.creatOrEditManager(managerParam);
        }

        List<UnitAddParam> units = param.getUnits();
        List<ErpBuildingSetUnit> insertUnitList = new ArrayList<>();

        // 计算每个单元的起始房号(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
        Integer doorStartInUnit;
        // 计算每个单元的起始房号次数(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
        int addedByAllUnitsCount = 0;
        int totalRoomCount = 0;

        for (UnitAddParam unitAddParam : units) {
            Integer floorStart = unitAddParam.getFloorStart() == null ? 0 : unitAddParam.getFloorStart();
            Integer floorEnd = unitAddParam.getFloorEnd() == null ? 0 : unitAddParam.getFloorEnd();
            String buildDoors = unitAddParam.getBuildDoors() == null ? "0" : unitAddParam.getBuildDoors();

            // -2楼到-1楼是2层,-1楼到1楼是2层,1楼到2楼是2层
            int floorCount;
            if (floorEnd > 0 && floorStart > 0) {
                floorCount = floorEnd - floorStart + 1;
            } else if (floorEnd < 0 && floorStart < 0) {
                floorCount = floorEnd - floorStart + 1;
            } else {
                floorCount = floorEnd - floorStart;
            }

            // 每个号位生成的房间数
            int roomCountInUnit = floorCount * Integer.valueOf(buildDoors);

            if (roomCountInUnit > 5000) {
                throw new BusinessException("每个号位一次性生成房间数不超过5000个！");
            }

            totalRoomCount += roomCountInUnit;

            this.checkUnitNameRepeat(cityId, compId, buildId, null, unitAddParam.getBuildUnit());

            ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
            BeanUtils.copyProperties(unitAddParam, unit);
            unit.setBuildId(param.getBuildId());
            unit.setShardCityId(cityId);
            unit.setProvinceId(provinceId);
            unit.setCityId(cityId);
            unit.setCompId(compId);
            unit.setCompNo(compNo);
            unit.setCreateTime(new Date());
            unit.setRoomGenerated((byte) 0);
            unit.setDoors(roomCountInUnit);
            unit.setBuildUnitName(param.getBuildUnitName());
            unit.setBuildLadder(unitAddParam.getBuildLadder());
            unit.setBuildDoors(unitAddParam.getBuildDoors());

            UnitAddParam unitAdd = new UnitAddParam();
            unitAdd.setRoomSortRule(unitAddParam.getRoomSortRule());
            unitAdd.setRoomCompositionRule(unitAddParam.getRoomCompositionRule());
            RoomRuleDto roomRuleDto = erpBuildingSetRoofService.generateRoomRule(unitAddParam.getRoomSortRule(), unitAddParam.getRoomCompositionRule());
            unit.setNumberRule(roomRuleDto.getNumberRule());
            unit.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
            unit.setNumberType(roomRuleDto.getNumberType());
            unit.setCompriseRule(roomRuleDto.getCompriseRule());
            unit.setDoorStartInPage(unitAddParam.getDoorStart());

            // 是否通排
            Byte addedByAllUnits = unit.getAddedByAllUnits() == null ? (byte) 0 : unit.getAddedByAllUnits();

            // 每个单元的房间起始通过是否通排计算出来
            if (addedByAllUnits.equals((byte) 1)) {
                // 按单元排号和多单元通排
                if (unit.getNumberRule() == 2) {
                    if (unit.getCompriseRule() == 1) {
                        doorStartInUnit = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
                        addedByAllUnitsCount++;
                        unit.setDoorStart(doorStartInUnit.toString());
                    } else {
                        Integer max = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
                        unit.setDoorStart(max.toString());
                        addedByAllUnitsCount++;
                    }
                } else {
                    // 按照楼层排号和多单元通排： 1栋1单元 doorStartInUnit:1  1栋2单元 doorStartInUnit:101 1栋3单元 doorStartInUnit:201
                    doorStartInUnit = Integer.valueOf(buildDoors) * addedByAllUnitsCount + 1;
                    addedByAllUnitsCount++;
                    unit.setDoorStart(doorStartInUnit.toString());
                }
            }

            insertUnitList.add(unit);
        }

        int baseCount = 50;
        // 批量添加单元
        if (insertUnitList.size() > 0) {
            for (int i = 0; i < insertUnitList.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = insertUnitList.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    erpBuildingSetUnitMapper.batchAddUnit(cityId, compId, buildId, current);
                }
            }
        }

        ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
        roofUnitDoorsExample.setShardCityId(cityId);
        roofUnitDoorsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId());
        int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

        if (roofUnitDoorsCount == 0) {
            ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
            record.setShardCityId(cityId);
            record.setCityId(cityId);
            record.setCompId(compId);
            record.setBuildId(buildId);
            record.setUnits(units.size());
            record.setDoors(totalRoomCount);
            erpFunBuildRoofunitdoorsMapper.insertSelective(record);
        } else {
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
            erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, compId, buildId, totalRoomCount, units.size(), null);
        }

        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, buildId, "", "", "首次创建号位");

        List<Integer> unitIdsInBuild = erpBuildingSetUnitMapper.getUnitIds(cityId, compId, buildId);
        List<String> unitList = unitIdsInBuild.stream().distinct().map(Object::toString).collect(Collectors.toList());

        return String.join(",", unitList);
    }

    @Override
    public BuildUnitRuleInMobileVo getBuildUnitListInMobile(BuildIdInMobileParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer buildId = param.getBuildId();

        BuildUnitRuleInMobileVo buildUnitRuleInMobileVo = new BuildUnitRuleInMobileVo();

        ErpFunBuildRoofunitdoors buildRoofUnitDoors = erpFunBuildRoofunitdoorsMapper.geterpFunBuildRoofunitdoorsByBuild(cityId, compId, buildId);
        Integer units = buildRoofUnitDoors.getUnits();
        Integer doors = buildRoofUnitDoors.getDoors();
        buildUnitRuleInMobileVo.setUnitCount(units);
        buildUnitRuleInMobileVo.setRoomCount(doors);

        RoomConInfoCountParam roomConInfoCountParam = new RoomConInfoCountParam();
        roomConInfoCountParam.setBuildId(param.getBuildId());
        RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(roomConInfoCountParam, generalParam);

        buildUnitRuleInMobileVo.setSaleCount(conInfoCount.getSaleCount());
        buildUnitRuleInMobileVo.setLeaseCount(conInfoCount.getLeaseCount());
        buildUnitRuleInMobileVo.setSaleAndLeaseCount(conInfoCount.getSaleAndLeaseCount());

        List<BuildUnitNameInMobileVo> unitNameInMobileVos = erpBuildingSetUnitMapper.getBuildUnitNames(cityId, compId, buildId, null);
        buildUnitRuleInMobileVo.setBuildUnitNames(unitNameInMobileVos);

        return buildUnitRuleInMobileVo;
    }

    @Override
    public BuildUnitDetailsInMobileVo getBuildUnitDetailsInMobile(BuildUnitIdParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer buildId = param.getBuildId();
        Integer buildingSetUnitId = param.getBuildingSetUnitId();

        BuildUnitDetailsInMobileVo buildUnitDetailsInMobileVo = new BuildUnitDetailsInMobileVo();

        ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
        unit.setShardCityId(cityId);
        unit.setCompId(compId);
        unit.setBuildId(buildId);
        unit.setId(buildingSetUnitId);
        unit = erpBuildingSetUnitMapper.selectByPrimaryKey(unit);

        if (unit == null || unit.getBuildUnit() == null) {
            throw new BusinessException("该单元或者号位不存在！");
        }

        RoomConInfoCountParam roomConInfoCountParam = new RoomConInfoCountParam();
        roomConInfoCountParam.setBuildId(param.getBuildId());
        roomConInfoCountParam.setBuildingSetUnitId(buildingSetUnitId);
        RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(roomConInfoCountParam, generalParam);

        buildUnitDetailsInMobileVo.setBuildingSetUnitId(buildingSetUnitId);
        buildUnitDetailsInMobileVo.setBuildUnit(unit.getBuildUnit());
        buildUnitDetailsInMobileVo.setBuildUnitName(unit.getBuildUnitName());
        buildUnitDetailsInMobileVo.setSaleCount(conInfoCount.getSaleCount());
        buildUnitDetailsInMobileVo.setLeaseCount(conInfoCount.getLeaseCount());
        buildUnitDetailsInMobileVo.setSaleAndLeaseCount(conInfoCount.getSaleAndLeaseCount());

        return buildUnitDetailsInMobileVo;
    }

}
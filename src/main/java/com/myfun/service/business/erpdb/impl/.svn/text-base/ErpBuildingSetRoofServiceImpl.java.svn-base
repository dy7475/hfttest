package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.RoomWithBuildFloorDto;
import com.myfun.repository.erpdb.param.CreatOrEditManagerParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.HeavenlyStem;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingManagerService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoofService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomService;
import com.myfun.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author czq
 * @since 2018/12/11
 */
@Service
public class ErpBuildingSetRoofServiceImpl extends AbstractService<ErpBuildingSetRoof, ErpBuildingSetRoof> implements ErpBuildingSetRoofService {

    @Resource
    private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Resource
    private ErpBuildingSetLogMapper erpBuildingSetLogMapper;
    @Resource
    private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
    @Resource
    private ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
    @Resource
    private ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
    @Resource
    private ErpBuildingSetRoomLayoutMapper erpBuildingSetRoomLayoutMapper;
    @Resource
    private ErpSysParaMapper erpSysParaMapper;
    @Resource
    private ErpBuildingManagerMapper erpBuildingManagerMapper;
    @Resource
    private ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
    @Resource
    private ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
    @Resource
    private ErpBuildingManagerService erpBuildingManagerService;
    @Resource
    private ErpBuildingSetRoomService erpBuildingSetRoomService;
    @Resource
    private ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Resource
    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;
    @Resource
    ErpBuildingMarketingControlMinMapper erpBuildingMarketingControlMinMapper;
    @Resource
    ErpBuildingSetRoofService erpBuildingSetRoofService;
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildingSetRoofMapper;
    }

    @Transactional
    @Override
    public void updateBuildingSetRoof(ErpBuildingSetRoofUpdateParam param, Integer cityId, Integer compId, Integer userId) {
        Integer repeatCount = erpBuildingSetRoofMapper.getRoofUnitNameRepeatCount(cityId, 0, param.getBuildId(), param.getBuildRoof(), param.getBuildingSetRoofId());
        if (repeatCount != null && repeatCount > 0) {
            throw new BusinessException("栋名与已有栋重复，请重新填写");
        }

        ErpBuildingSetRoofRuleVo buildingSetRoofRule = erpBuildingSetRoofMapper.getBuildingSetRoofRuleVo(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId());

        // 修改栋座信息
        erpBuildingSetRoofMapper.updateBuildingSetRoof(cityId, param, 0);

        // 修改维护人信息
        if (param.getBuildingManagerId() != null) {
            CreatOrEditManagerParam managerParam = new CreatOrEditManagerParam();
            managerParam.setCityId(cityId);
            managerParam.setCompId(compId);
            managerParam.setBuildId(param.getBuildId());
            managerParam.setBuildingSetRoofId(param.getBuildingSetRoofId().toString());
            managerParam.setUserId(param.getBuildingManagerId());
            erpBuildingManagerService.creatOrEditManager(managerParam);
        }

        // 号位规则, 房间MD5不带楼层
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        // 栋座名修改,则更新下面的房间的md5, 单元表的栋名称,楼层表的栋名称,房间表的栋名称
        if (buildingSetRoofRule != null && buildingSetRoofRule.getBuildRoof() != null && !buildingSetRoofRule.getBuildRoof().equals(param.getBuildRoof())) {
            // 获取栋座下房间列表
            List<RoomWithBuildFloorDto> needUpdateMd5Rooms = erpBuildingSetRoomMapper.selectRoomWithBuildFloor(cityId,
                    0, param.getBuildId(), param.getBuildingSetRoofId(), null);

            List<BatchUpdateRoomMd5> batchUpdateRoomMd5s = new ArrayList<>();

            for (RoomWithBuildFloorDto room : needUpdateMd5Rooms) {
                String buildFloor = room.getBuildFloor();
                String roomId = room.getRoomId();
                Integer buildingSetRoomId = room.getBuildingSetRoomId();
                String buildUnit = room.getBuildUnit();

                // 需要更新的MD5
                String addMd5;
                if ("2".equals(paramValue)) {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), buildUnit, roomId);
                } else {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), param.getBuildRoof(), buildUnit, buildFloor, roomId);
                }

                // 老MD5
                String oldAddMd5;
                if ("2".equals(paramValue)) {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), buildUnit, roomId);
                } else {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildingSetRoofRule.getBuildRoof(), buildUnit, buildFloor, roomId);
                }

                BatchUpdateRoomMd5 batchUpdateRoomMd5 = new BatchUpdateRoomMd5();
                batchUpdateRoomMd5.setBuildId(param.getBuildId());
                batchUpdateRoomMd5.setBuildingSetRoomId(buildingSetRoomId);
                batchUpdateRoomMd5.setAddMd5(addMd5);
                batchUpdateRoomMd5.setOldAddMd5(oldAddMd5);
                batchUpdateRoomMd5.setBuildRoof(param.getBuildRoof());
                batchUpdateRoomMd5s.add(batchUpdateRoomMd5);
            }

            // 批量房间,每次最多一百条
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
                        erpBuildingMarketingControlMapper.batchUpdateRoomMd5(cityId, compId, param.getBuildId(), current);
                    }
                }
            }

            // 修改单元表中该栋座的楼栋名
            ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
            unitExample.setShardCityId(cityId);
            unitExample.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
            ErpBuildingSetUnit unitRecord = new ErpBuildingSetUnit();
            unitRecord.setBuildRoof(param.getBuildRoof());
            unitRecord.setUpdateTime(new Date());
            erpBuildingSetUnitMapper.updateByExampleSelective(unitRecord, unitExample);

            // 修改房间中栋座名称
            ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
            roomExample.setShardCityId(cityId);
            roomExample.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
            ErpBuildingSetRoom roomRecord = new ErpBuildingSetRoom();
            roomRecord.setBuildRoof(param.getBuildRoof());
            roomRecord.setUpdateTime(new Date());
            erpBuildingSetRoomMapper.updateByExampleSelective(roomRecord, roomExample);
        }

        // 修改楼层表中该栋座的楼栋名,用途
        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
        ErpBuildingSetFloor floorRecord = new ErpBuildingSetFloor();
        floorRecord.setBuildRoof(param.getBuildRoof());
        floorRecord.setUpdateTime(new Date());
        if (param.getHouseUseage() != null) {
            floorRecord.setFloorUseage(param.getHouseUseage());
        }
        erpBuildingSetFloorMapper.updateByExampleSelective(floorRecord, floorExample);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0,
                param.getBuildId(), param.getBuildRoof(), null, "修改栋信息 " + param.getBuildRoof());
    }

    @Transactional
    @Override
    public void delBuildRoofById(ErpBuildingSetRoofIdParam param, Integer cityId, Integer compId, Integer userId) {
        if (param.getBuildingSetRoofId() == null) {
            throw new BusinessException("请先选择栋座再删除");
        }
        DeleteIdParam deleteIdParam = new DeleteIdParam();
        deleteIdParam.setBuildId(param.getBuildId());
        deleteIdParam.setBuildingSetRoofId(param.getBuildingSetRoofId());

        erpBuildingSetRoofMapper.delBuildRoof(cityId, deleteIdParam, 0);
        erpBuildingSetUnitMapper.delBuildUnit(cityId, deleteIdParam, 0);
        erpBuildingSetFloorMapper.delBuildFloor(cityId, deleteIdParam, 0);
        erpBuildingSetRoomMapper.delBuildRoom(cityId, deleteIdParam, 0);
        erpBuildingSetRoomLayoutMapper.delBuildRoomLayout(cityId, deleteIdParam, 0);

        // 修改 FUN_BUILD_ROOFUNITDOORS 表户数
        erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, 0, param.getBuildId());

        ErpBuildingSetRoomExample example = new ErpBuildingSetRoomExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        int count = erpBuildingSetRoomMapper.countByExample(example);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0,
                param.getBuildId(), param.getBuildingSetRoofId().toString(), null, "删除栋座");
    }

    @Override
    public List<ErpBuildingSetRoofNameVo> getBuildRoofList(BuildIdParam param, Integer cityId, Integer compId) {
        return erpBuildingSetRoofMapper.getBuildRoofNameVo(cityId, compId, param.getBuildId());
    }

    @Override
    public ErpBuildingSetRoofRuleVo getBuildRoofById(ErpBuildingSetRoofIdParam param, Integer cityId, Integer compId) {
        return erpBuildingSetRoofMapper.getBuildingSetRoofRuleVo(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId());
    }

    /**
     * 分为楼盘-栋-单元-楼层-房间 以及 楼盘-号位-楼层-房间, 区别为没有栋的ID
     */
    @Override
    public ErpBuildingSetRoomListVo getRoomInfoList(ErpBuildingGetRoomInfoListIdParam param, Integer cityId, Integer compId) {
        ErpBuildingSetRoomListVo roomListVo = new ErpBuildingSetRoomListVo();

        List<ErpBuildingSetFloorVo> floorVos = erpBuildingSetFloorMapper.selectFloorVos(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        roomListVo.setFloorList(floorVos);

        List<ErpBuildingSetRoomShowInTableVo> roomShowInTableVos = erpBuildingSetRoomMapper.selectRoomShowInTableVos(cityId,
                compId, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        roomListVo.setRoomList(roomShowInTableVos);

        return roomListVo;
    }

    /**
     * 添加楼盘栋座信息(解析是单个添加还是批量添加, 在栋座表中插入相应条数的数据, 将添加的栋座id异步处理)
     * <p>
     * 1.解析出批量或者单个添加的栋座,以及栋座下的单元
     * 1.1 已有1栋1到3单元,新添规则1栋2到4单元,存在2单元和3单元的重复,抛出重复异常
     * 2.检查栋是否已存在
     * 2.1 栋在此楼盘已经存在
     * 2.1.1 已有1栋1到3单元,新添规则1栋4到6单元,不存在重复,更新栋表中单元相关的规则,并发送给task那边处理
     * 2.2 栋在此楼盘不存在
     * 2.2.1 直接写入栋表信息,并发送给task那边处理
     * 3.写入添加栋座的日志
     */
    @Transactional
    @Override
    public String addBuildRoof(ErpBuildingSetRoofAddParam param, Integer cityId, Integer compId, Integer userId, Integer provinceId, String compNo) {
        // 解析出批量或者单个添加的栋座,以及栋座下的单元
        List<Map<String, String>> unitInRoofList = this.unitInRoofAnalysis(param, cityId, compId, param.getBuildId());

        if (unitInRoofList.size() > 255) {
            throw new BusinessException("一次性生成单元数不超过255个！");
        }

        List<String> roofList = new ArrayList<>();
        unitInRoofList.forEach(map -> map.forEach((k, v) -> roofList.add(k)));
        // 解析出的所有的栋座名称
        List<String> distinctBuildRoofList = roofList.stream().distinct().collect(Collectors.toList());

        Integer floorStart = param.getFloorStart() == null ? 0 : param.getFloorStart();
        Integer floorEnd = param.getFloorEnd() == null ? 0 : param.getFloorEnd();
        String buildDoors = param.getBuildDoors() == null ? "0" : param.getBuildDoors();

        if (distinctBuildRoofList.size() == 0) {
            return "";
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
        int everyRoomCountInUnit = floorCount * Integer.valueOf(buildDoors);
        if (everyRoomCountInUnit > 5000) {
            throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
        }
        // 总房间数
        int totalRoomCount = unitInRoofList.size() * everyRoomCountInUnit;
        // 所有需要处理的栋座
        List<ErpBuildingSetRoof> allRoofs = new ArrayList<>();
        // 所有需要添加的单元
        List<ErpBuildingSetUnit> insertUnitList = new ArrayList<>();
        // 是否通排
        Byte addedByAllUnits = param.getAddedByAllUnits() == null ? (byte) 0 : param.getAddedByAllUnits();

        for (String distinctBuildRoof : distinctBuildRoofList) {
            ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
            BeanUtils.copyProperties(param, roof);
            roof.setProvinceId(provinceId);
            roof.setCityId(cityId);
            roof.setCompNo(compNo);
            roof.setCompId(compId);
            roof.setBuildRoof(distinctBuildRoof);

            List<String> unitList = new ArrayList<>();
            unitInRoofList.forEach(map -> map.forEach((k, v) -> {
                if (distinctBuildRoof.equals(k)) {
                    unitList.add(v);
                }
            }));

            // 异步处理的时候单元数以及户数还会更新一次
            roof.setUnits(unitList.size());
            Integer doors = unitList.size() * everyRoomCountInUnit;
            roof.setDoors(doors);
            allRoofs.add(roof);

            // 计算每个单元的起始房号(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
            Integer doorStartInUnit;
            // 计算每个单元的起始房号次数(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
            int addedByAllUnitsCount = 0;

            for (String anUnitList : unitList) {
                ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();
                BeanUtils.copyProperties(param, erpBuildingSetUnit);
                erpBuildingSetUnit.setProvinceId(provinceId);
                erpBuildingSetUnit.setCityId(cityId);
                erpBuildingSetUnit.setCompId(compId);
                erpBuildingSetUnit.setCompNo(compNo);
                erpBuildingSetUnit.setBuildUnit(anUnitList);
                erpBuildingSetUnit.setRoomGenerated((byte) 0);
                erpBuildingSetUnit.setDoors(everyRoomCountInUnit);
                erpBuildingSetUnit.setCreateTime(new Date());
                erpBuildingSetUnit.setUpdateTime(new Date());
                erpBuildingSetUnit.setBuildRoof(distinctBuildRoof);

                // 每个单元的房间起始通过是否通排计算出来
                if (addedByAllUnits.equals((byte) 1)) {
                    // 按单元排号和多单元通排
                    if (erpBuildingSetUnit.getNumberRule() == 2) {
                        /*
                         *  只按照户号排
                         *
                         *   9 10 11 12         21  22  23  24
                         *  -5 -6 -7 -8        -17 -18 -19 -20
                         *  -1 -2 -3 -4        -13 -14 -15 -16
                         **/
                        if (erpBuildingSetUnit.getCompriseRule() == 1) {
                            /*
                             * 4 * 3 * 0 + 1 = 1
                             * 4 * 3 * 1 + 1 = 13
                             * 4 * 3 * 2 + 1 = 25
                             **/
                            doorStartInUnit = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
                            addedByAllUnitsCount++;
                            erpBuildingSetUnit.setDoorStart(doorStartInUnit.toString());
                        } else {
                            /*
                             * 按照单元排号和多单元通排
                             *
                             * 1单元:                       2单元:                        3单元:
                             *        107  108  109                116  117  118                  125  126  127
                             *       -104 -105 -106               -113 -114 -115                 -122 -123 -124
                             *       -201 -202 -203               -210 -211 -212                 -219 -220 -221
                             *
                             * max值为: 1, 10, 19
                             *
                             * 1单元:                       2单元:                        3单元:
                             *        1201 ...  1300               1501 ...  1600                  1801  ... 1900
                             *       -1101 ... -1200              -1401 ... -1500                 -1701 ... -1800
                             *       -201  ... -2100              -2301 ... -2400                 -2601 ... -2700
                             *
                             * max值为: 1, 301, 601
                             *
                             * 1单元:                       2单元:                        3单元:
                             *        1199 ...  1297               1496 ...  1594                  1793  ... 1891
                             *       -1100 ... -1198              -1397 ... -1495                 -1694 ... -1792
                             *       -201  ... -299               -2298 ... -2396                 -2595 ... -2693
                             *
                             * max值为: 1, 300, 600
                             *
                             **/
                            Integer max = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
                            erpBuildingSetUnit.setDoorStart(max.toString());
                            addedByAllUnitsCount++;
                        }
                    } else {
                        // 按照楼层排号和多单元通排： 1栋1单元 doorStartInUnit:1  1栋2单元 doorStartInUnit:101 1栋3单元 doorStartInUnit:201
                        doorStartInUnit = Integer.valueOf(buildDoors) * addedByAllUnitsCount + 1;
                        addedByAllUnitsCount++;
                        erpBuildingSetUnit.setDoorStart(doorStartInUnit.toString());
                    }
                }

                insertUnitList.add(erpBuildingSetUnit);
            }
        }

        // 筛选出已有的栋座(BUILDING_SET_ROOF_ID, BUILD_ROOF),这些就只更新,不添加
        List<ErpBuildingSetRoof> needUpdateRoofs = erpBuildingSetRoofMapper.getBuildingSetRoofs(cityId, compId, param.getBuildId(), distinctBuildRoofList);
        // 已有的栋座的名称
        List<String> needUpdateBuildRoofs = needUpdateRoofs.stream().map(ErpBuildingSetRoof::getBuildRoof).collect(Collectors.toList());
        // 所有的栋座 - 已有的栋座 = 需要添加的栋座
        List<ErpBuildingSetRoof> needAddRoofs = allRoofs.stream().filter(it -> !needUpdateBuildRoofs.contains(it.getBuildRoof())).collect(Collectors.toList());

        int baseCount = 50;

        // 批量编辑栋座(编辑它们的基础信息,基础信息相同)
        ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
        BeanUtils.copyProperties(param, roof);
        roof.setUpdateTime(new Date());

        if (needUpdateRoofs.size() > 0) {
            for (int i = 0; i < needUpdateRoofs.size(); i += baseCount) {
                List<ErpBuildingSetRoof> current = needUpdateRoofs.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量编辑栋座(编辑它们的基础信息,基础信息相同)
                    erpBuildingSetRoofMapper.batchUpdateRoof(cityId, compId, param.getBuildId(), roof, needUpdateBuildRoofs);
                }
            }
        }

        // 批量添加栋座
        if (needAddRoofs.size() > 0) {
            // 需要添加的栋座去重
            needAddRoofs = needAddRoofs.stream().distinct().collect(Collectors.toList());
            for (ErpBuildingSetRoof needAddRoof : needAddRoofs) {
                needAddRoof.setCreateTime(new Date());
                needAddRoof.setUpdateTime(new Date());
            }
            for (int i = 0; i < needAddRoofs.size(); i += baseCount) {
                List<ErpBuildingSetRoof> current = needAddRoofs.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加栋座
                    erpBuildingSetRoofMapper.batchAddRoof(cityId, current);
                }
            }
        }
        // 添加单元前的单元ID
        List<Integer> before = erpBuildingSetUnitMapper.getUnitIds(cityId, compId, param.getBuildId());

        // 批量添加单元
        if (insertUnitList.size() > 0) {
            for (int i = 0; i < insertUnitList.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = insertUnitList.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加单元(此时roofId还没有更新上去)
                    erpBuildingSetUnitMapper.batchAddUnit(cityId, compId, param.getBuildId(), current);
                }
            }
        }

        // 添加单元后的单元ID
        List<Integer> after = erpBuildingSetUnitMapper.getUnitIds(cityId, compId, param.getBuildId());

        // 更新这一楼盘中单元的roofId
        erpBuildingSetUnitMapper.updateRoofIdInUnit(cityId, compId, param.getBuildId());

        List<Integer> addUnitIds;

        if (before == null || before.size() == 0) {
            addUnitIds = after;
        } else {
            // 添加单元后的单元ID - 添加单元前的单元ID = 新添加的单元ID
            addUnitIds = after.stream().filter(it -> !before.contains(it)).collect(Collectors.toList());
        }

        // 此时就是所有的栋座,包含更新的以及新添加的
        List<ErpBuildingSetRoof> allBuildRoofs = erpBuildingSetRoofMapper.getBuildingSetRoofs(cityId, compId, param.getBuildId(), distinctBuildRoofList);
        // 编辑栋座管理员
        if (param.getBuildingManagerId() != null) {
            for (ErpBuildingSetRoof allBuildRoof : allBuildRoofs) {
                CreatOrEditManagerParam managerParam = new CreatOrEditManagerParam();
                managerParam.setCityId(cityId);
                managerParam.setCompId(compId);
                managerParam.setBuildId(param.getBuildId());
                managerParam.setBuildingSetRoofId(allBuildRoof.getBuildingSetRoofId().toString());

                // 备注:前端传的 buildingManagerId 为用户ID, 后端存的 buildingManagerId 为 BUILDING_MANAGER 主键ID, 在此更新
                // 栋座详情中用 buildingManagerId JOIN BUILDING_MANAGER 表,返回用户ID
                managerParam.setUserId(param.getBuildingManagerId());
                erpBuildingManagerService.creatOrEditManager(managerParam);
            }
        }

        List<String> unitList = addUnitIds.stream().distinct().map(Object::toString).collect(Collectors.toList());

        ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
        roofUnitDoorsExample.setShardCityId(cityId);
        roofUnitDoorsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId());
        int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

        if (roofUnitDoorsCount == 0) {
            ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
            record.setShardCityId(cityId);
            record.setBuildId(param.getBuildId());
            record.setCityId(cityId);
            record.setCompId(compId);
            record.setRoofs(distinctBuildRoofList.size());
            record.setUnits(unitList.size());
            record.setDoors(totalRoomCount);
            erpFunBuildRoofunitdoorsMapper.insertSelective(record);
        } else {
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数
//            erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
            erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, compId, param.getBuildId(), totalRoomCount, unitList.size(), distinctBuildRoofList.size());
        }

        String unitIds = String.join(",", unitList);
        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, param.getBuildId(), "", "", "新增栋座");

        return unitIds;
    }

    @Override
    public Integer getBuildingLockDate(Integer cityId, Integer compId, ErpBuildingLockDataParam param) {
        int success = 1;
        int fail = 2;
        // 商铺、车库、厂房、仓库都不管锁没锁定楼盘，都能够录入，并且不判断是否符合锁定的规则
        if (Const.DIC_HOUSE_USEAGE_GARAGE.equals(param.getHouseUseage())
                || Const.DIC_HOUSE_USEAGE_STORE.equals(param.getHouseUseage())
                || Const.DIC_HOUSE_USEAGE_MANUFACT.equals(param.getHouseUseage())
                || Const.DIC_HOUSE_USEAGE_TRADE.equals(param.getHouseUseage())
                || param.getBuildId() == -1// 自建房
        ) {
            return success;
        }

        Integer buildId = param.getBuildId();
        String buildRoof = param.getBuildRoof();
        String buildUnit = param.getBuildUnit();
        String buildFloor = param.getBuildFloor();
        String buildRoom = param.getBuildRoom();
        String[] room = null;
        //可能是合并房间的
        if (buildRoom != null) {
            room = buildRoom.split(",");
        }
        //判断是不是号位
        if (buildRoof != null) {
            //查询出栋座信息
            ErpBuildingSetRoofExample erpBuildingSetRoofExample = new ErpBuildingSetRoofExample();
            erpBuildingSetRoofExample.createCriteria().andBuildIdEqualTo(buildId).andBuildRoofEqualTo(buildRoof).andCompIdEqualTo(0).andDelFlagNotEqualTo((byte) 1);
            erpBuildingSetRoofExample.setShardCityId(cityId);
            List<ErpBuildingSetRoof> erpBuildingSetRoofList = erpBuildingSetRoofMapper.selectByExample(erpBuildingSetRoofExample);
            //该楼盘下什么规则都没有，直接返回true，先登记再见规则
            if (erpBuildingSetRoofList.size() <= 0) {
                ErpBuildingSetRoofExample erpBuildingSetRoofExample1 = new ErpBuildingSetRoofExample();
                erpBuildingSetRoofExample1.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(0);
                erpBuildingSetRoofExample1.setShardCityId(cityId);
                int count = erpBuildingSetRoofMapper.countByExample(erpBuildingSetRoofExample1);
                if (count <= 0) {
                    return success;
                }
                return fail;
            }
            ErpBuildingSetRoof erpBuildingSetRoof = erpBuildingSetRoofList.get(0);

            //查询单元
            ErpBuildingSetUnit erpBuildingSetUnit = erpBuildingSetUnitMapper.selectByRoofIdAndBuildUnit(cityId, compId, buildId, erpBuildingSetRoof.getBuildingSetRoofId(), buildUnit);
            if (erpBuildingSetUnit == null) {
                return fail;
            }
            //根据栋座和单元查询楼层id
            ErpBuildingSetFloor erpBuildingSetFloor = erpBuildingSetFloorMapper.selectByUnitIdandBuildFloor(cityId, compId, erpBuildingSetUnit.getId(), buildFloor);
            if (erpBuildingSetFloor == null) {
                return fail;
            }
            //根据栋座id和楼层id查询房间
            ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.selectByRoofIdAndFloorIdAndBuildRoom(cityId, compId, erpBuildingSetRoof.getBuildingSetRoofId(), erpBuildingSetFloor.getId(), room);
            if (erpBuildingSetRoom == null) {
                return fail;
            }
            return success;
        } else {
            //查询单元
            ErpBuildingSetUnit erpBuildingSetUnit = erpBuildingSetUnitMapper.selectByBuildAndBuildUnit(cityId, compId, buildId, buildUnit);
            //该楼盘下什么规则都没有，直接返回true，先登记再见规则
            if (erpBuildingSetUnit == null) {
                ErpBuildingSetUnitExample erpBuildingSetUnitExample = new ErpBuildingSetUnitExample();
                erpBuildingSetUnitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
                erpBuildingSetUnitExample.setShardCityId(cityId);
                int count = erpBuildingSetUnitMapper.countByExample(erpBuildingSetUnitExample);
                if (count <= 0) {
                    return success;
                }
                return fail;
            }
            //查询房间 有可能是号室情况下别墅只有叠拼别墅才会传室，别的别墅都不会传室，前端已经验证了要传的都会传
            if (room != null) {
                ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.selectByUnitIdAndBuildRoom(cityId, compId, erpBuildingSetUnit.getId(), room);
                if (erpBuildingSetRoom == null) {
                    return fail;
                }
            }
            return success;
        }
    }

    /*
     *
     * 解析单元时判重
     * 返回值: [{"1栋":"1单元"}, {"2栋":"1单元"}, {"2栋":"2单元"}, {"3栋":"1单元"}, {"3栋":"2单元"}, {"3栋":"3单元"}]
     * */
    private List<Map<String, String>> unitInRoofAnalysis(ErpBuildingSetRoofAddParam param, Integer cityId, Integer compId, Integer buildId) {
        int startRoof, endRoof;                                                 // 默认只有一栋
        int startUnit, endUnit;                                                 // 默认只有一单元
        boolean isOnlyOneRoof = StringUtils.isNotBlank(param.getBuildRoof());   // 栋座名称为空表示批量添加栋座, 即isOnlyOneRoof为true表示单个添加
        List<String> roofList = new ArrayList<>();                              // 解析出的新添加的栋座名称列表

        // 解析出批量或者单个添加的栋座, 以及栋座下的单元
        if (!isOnlyOneRoof) {
            // 栋座后缀类型，1=数字，2=字母
            switch (param.getRoofSuffixType()) {
                case 1:
                    startRoof = StringUtil.parseInteger(param.getRoofSuffixStart(), 1);
                    endRoof = StringUtil.parseInteger(param.getRoofSuffixEnd(), 1);
                    break;
                case 2:
                    startRoof = param.getRoofSuffixStart().charAt(0);
                    endRoof = param.getRoofSuffixEnd().charAt(0);
                    break;
                default:
                    // 甲乙丙丁
                    startRoof = HeavenlyStem.heavenlyStemMap.get(param.getRoofSuffixStart());
                    endRoof = HeavenlyStem.heavenlyStemMap.get(param.getRoofSuffixEnd());
            }

            for (int roof = startRoof; roof <= endRoof; roof++) {
                // 栋座前缀
                String roofStr = param.getRoofPreFix();
                switch (param.getRoofSuffixType()) {
                    case 1:
                        roofStr += roof;
                        break;
                    case 2:
                        roofStr += String.valueOf((char) roof);
                        break;
                    default:
                        roofStr += HeavenlyStem.heavenlyStem[roof];
                }
                roofList.add(roofStr);
            }
        } else {
            // 单个添加
            roofList.add(param.getBuildRoof());
        }

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

        List<Map<String, String>> unitInRoofList = new ArrayList<>();
        List<ErpBuildingSetUnit> list = new ArrayList<>();

        for (String aRoofList : roofList) {
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

                // 组装的时候就检查该楼盘,该栋座,该单元是否有重复
//                this.checkUnitNameRepeat(cityId, compId, buildId, aRoofList, unitStr);
                ErpBuildingSetUnit checkUnit = new ErpBuildingSetUnit();
                checkUnit.setBuildRoof(aRoofList);
                checkUnit.setBuildUnit(unitStr);
                list.add(checkUnit);

                Map<String, String> map = new HashMap<>();
                map.put(aRoofList, unitStr);
                unitInRoofList.add(map);
            }
        }
        this.checkRoofNameRepeat(cityId, compId, buildId, list);

        return unitInRoofList;
    }

//    private void checkUnitNameRepeat(Integer cityId, Integer compId, Integer buildId, String buildRoof, String buildUnit) {
//        // 该楼盘,该栋座,该单元是否有重复
//        ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
//        example.setShardCityId(cityId);
//        example.createCriteria()
//                .andCompIdEqualTo(compId)
//                .andBuildIdEqualTo(buildId)
//                .andBuildRoofEqualTo(buildRoof)
//                .andBuildUnitEqualTo(buildUnit)
//                .andDelFlagEqualTo((byte) 0);
//        int repeatCount = erpBuildingSetUnitMapper.countByExample(example);
//
//        if (repeatCount > 0) {
//            // 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
//            String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
//            if ("2".equals(paramVal)) {
//                throw new BusinessException("号位与已有号位重复，请重新填写");
//            } else if (StringUtils.isNotBlank(buildUnit)) {
//                throw new BusinessException("单元名称与已有单元名称重复，请重新填写");
//            } else {
//                throw new BusinessException("栋座名称与已有栋座名称重复，请重新填写");
//            }
//        }
//    }

//    private void checkUnitNameRepeat(Integer cityId, Integer compId, Integer buildId, List<ErpBuildingSetUnit> list) {
//        int baseCount = 100;
//
//        if (list.size() > 0) {
//            for (int i = 0; i < list.size(); i += baseCount) {
//                List<ErpBuildingSetUnit> current = list.stream().skip(i).limit(baseCount).collect(Collectors.toList());
//                StringBuilder condition = new StringBuilder();
//
//                if (current.size() > 0) {
//                    for (ErpBuildingSetUnit roofAndUnit : current) {
//                        String buildRoof = roofAndUnit.getBuildRoof();
//                        String buildUnit = roofAndUnit.getBuildUnit();
//
//                        if (buildRoof != null && buildUnit != null) {
//                            condition.append("(BUILD_ROOF = ").append("\'").append(buildRoof).append("\'")
//                                    .append(" AND ").append("BUILD_UNIT = ").append("\'").append(buildUnit).append("\'").append(") OR ");
//                        }
//                    }
//
//                    String conditionString = condition.toString();
//                    if (conditionString.endsWith(") OR ")) {
//                        conditionString = conditionString.substring(0, conditionString.length() - 3);
//                    }
//                    conditionString = "(" + conditionString + ")";
//                    System.out.println("conditionString " + conditionString);
//                    ErpBuildingSetUnit unit = erpBuildingSetUnitMapper.getRepeatUnit(cityId, compId, buildId, conditionString);
//
//                    if (unit != null) {
//                        // 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
//                        String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
//                        if ("2".equals(paramVal)) {
//                            throw new BusinessException("号位与已有号位重复，请重新填写");
//                        } else if (StringUtils.isNotBlank(unit.getBuildUnit())) {
//                            throw new BusinessException("单元名称与已有单元名称重复，请重新填写");
//                        } else {
//                            throw new BusinessException("栋座名称与已有栋座名称重复，请重新填写");
//                        }
//                    }
//                }
//            }
//        }
//    }

    private void checkRoofNameRepeat(Integer cityId, Integer compId, Integer buildId, List<ErpBuildingSetUnit> list) {
        int baseCount = 100;

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = list.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                StringBuilder condition = new StringBuilder();

                if (current.size() > 0) {
                    for (ErpBuildingSetUnit roofAndUnit : current) {
                        String buildRoof = roofAndUnit.getBuildRoof();


                        if (buildRoof != null) {
                            condition.append("(BUILD_ROOF = ").append("\'").append(buildRoof).append("\'").append(") OR ");
                        }
                    }

                    String conditionString = condition.toString();
                    if (conditionString.endsWith(") OR ")) {
                        conditionString = conditionString.substring(0, conditionString.length() - 3);
                    }
                    conditionString = "(" + conditionString + ")";
                    System.out.println("conditionString " + conditionString);
                    ErpBuildingSetRoof roof = erpBuildingSetRoofMapper.getRepeatRoof(cityId, compId, buildId, conditionString);

                    if (roof != null) {
                        throw new BusinessException("栋座名称与已有栋座名称重复，请重新填写!");
                    }
                }
            }
        }
    }

    @Transactional
    @Override
    public void delBuildRuleById(Integer cityId, Integer compId, Integer buildId, Integer userId) {
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(cityId, 0, buildId);
        if (erpBuildingSetSetting != null && erpBuildingSetSetting.getBuildLock() != null && erpBuildingSetSetting.getBuildLock() == (byte) 1) {
            throw new BusinessException("当前楼盘已被锁定！");
        }

        // 将该公司该楼盘所有栋规则删除
        ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
        roofExample.setShardCityId(cityId);
        roofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        erpBuildingSetRoofMapper.deleteByExample(roofExample);

        // 将该公司该楼盘所有单元规则删除
        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        erpBuildingSetUnitMapper.deleteByExample(unitExample);

        // 将该公司该楼盘所有楼层规则删除
        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        erpBuildingSetFloorMapper.deleteByExample(floorExample);

        // 将该公司该楼盘所有房间规则删除
        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        erpBuildingSetRoomMapper.deleteByExample(roomExample);

        ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
        record.setRoofs(0);
        record.setUnits(0);
        record.setDoors(0);
        ErpFunBuildRoofunitdoorsExample example = new ErpFunBuildRoofunitdoorsExample();
        example.setShardCityId(cityId);
        example.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
        // 将该栋楼的栋数,单元数,户数清零
        erpFunBuildRoofunitdoorsMapper.updateByExampleSelective(record, example);
        // 清除销控表数据
//        erpBuildingMarketingControlMapper.deleteById(cityId, compId, buildId);
//        // 清除销控MIN表数据
//        erpBuildingMarketingControlMinMapper.deleteById(cityId, compId, buildId);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, buildId, null, null, "清空楼盘规则");
    }

    @Override
    public String addBuildRule(BuildRuleAddParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();

        ErpBuildingSetRoofExample erpBuildingSetRoofExample = new ErpBuildingSetRoofExample();
        erpBuildingSetRoofExample.setShardCityId(cityId);
        erpBuildingSetRoofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        int roofCount = erpBuildingSetRoofMapper.countByExample(erpBuildingSetRoofExample);

        if (roofCount > 0) {
            throw new BusinessException("当前公司当前楼盘已有栋座规则，请不要重复首次创建！");
        }

        List<RoofAddParam> roofs = param.getRoofs();
        Integer buildId = param.getBuildId();

        // 将 BuildRuleAddParam 中的参数带入到roof列表中
        roofs.forEach(it -> {
            it.setBuildRoofName(param.getBuildRoofName());
            it.setBuildId(param.getBuildId());
        });

        AddBuildRoofCommonDto addBuildRoofCommonDto = this.addBuildRoofCommon(roofs, generalParam, buildId);
        // 解析出的所有的栋座名称
        List<String> distinctBuildRoofList = roofs.stream().map(RoofAddParam::getBuildRoof).collect(Collectors.toList());

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

        // 首次添加规则,才会调用此接口,此时的单元全都是楼盘的新增单元
        List<Integer> addUnitIds = erpBuildingSetUnitMapper.getUnitIds(cityId, 0, buildId);
        List<String> unitList = addUnitIds.stream().distinct().map(Object::toString).collect(Collectors.toList());

        ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
        roofUnitDoorsExample.setShardCityId(cityId);
        roofUnitDoorsExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

        if (roofUnitDoorsCount == 0) {
            ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
            record.setShardCityId(cityId);
            record.setBuildId(param.getBuildId());
            record.setCityId(cityId);
            record.setCompId(0);
            record.setRoofs(distinctBuildRoofList.size());
            record.setUnits(unitList.size());
            record.setDoors(addBuildRoofCommonDto.getTotalRoomCount());
            erpFunBuildRoofunitdoorsMapper.insertSelective(record);
        } else {
            // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
            erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, 0, param.getBuildId(),
                    addBuildRoofCommonDto.getTotalRoomCount(), unitList.size(), distinctBuildRoofList.size());
        }

        String unitIds = String.join(",", unitList);
        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), "", "", "首次创建栋座规则");

        return unitIds;
    }

    /**
     * 精耕二期根据前端传上来数据,解析栋座单元
     */
    private void unitInRoofAnalysisV2(List<RoofAddParam> roofs, GeneralParam generalParam, Integer buildId) {
        List<ErpBuildingSetUnit> unitList = new ArrayList<>();
        List<String> checkBuildUnitRepeat = new ArrayList<>();

        for (RoofAddParam roofAddParam : roofs) {
            List<UnitAddParam> units = roofAddParam.getUnits();

            // 存在不添加单元的情况(空单元)
            if (units == null || units.size() == 0) {
                ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
                unit.setBuildRoof(roofAddParam.getBuildRoof());
                unitList.add(unit);
            } else {
                for (UnitAddParam unitAddParam : units) {
                    ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
                    unit.setBuildRoof(roofAddParam.getBuildRoof());
                    unit.setBuildUnit(unitAddParam.getBuildUnit());
                    unitList.add(unit);
                    checkBuildUnitRepeat.add(roofAddParam.getBuildRoof() + "," + unitAddParam.getBuildUnit());
                }
            }

            if (checkBuildUnitRepeat.size() > 0) {
                if (new HashSet<>(checkBuildUnitRepeat).size() < checkBuildUnitRepeat.size()) {
                    throw new BusinessException("单元名称重复，请重新填写!");
                }
            }
        }
        this.checkRoofNameRepeat(generalParam.getCityId(), generalParam.getCompId(), buildId, unitList);
    }

    @Override
    public String batchAddBuildRoofV2(BuildRuleAddParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();

        List<RoofAddParam> roofs = param.getRoofs();
        Integer buildId = param.getBuildId();

        // 将 BuildRuleAddParam 中的参数带入到roof列表中
        roofs.forEach(it -> {
            it.setBuildRoofName(param.getBuildRoofName());
            it.setBuildId(param.getBuildId());
        });

        this.addBuildRoofCommon(roofs, generalParam, buildId);
        // 解析出的所有的栋座名称
        List<String> distinctBuildRoofList = roofs.stream().map(RoofAddParam::getBuildRoof).collect(Collectors.toList());

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

        // 查询新增单元(数据的更新统计在threadWeb完成)
        List<Integer> addUnitIds = erpBuildingSetUnitMapper.getUnitIdsByBuildRoofs(cityId, compId, buildId, distinctBuildRoofList);
        List<String> unitList = addUnitIds.stream().distinct().map(Object::toString).collect(Collectors.toList());

        String unitIds = String.join(",", unitList);
        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, param.getBuildId(), "", "", "批量添加栋座");

        return unitIds;
    }

    @Override
    public String addBuildRoofV2(RoofSingleAddParam param, GeneralParam generalParam, boolean isCopy) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();
        Integer buildId = param.getBuildId();

        List<RoofAddParam> roofs = new ArrayList<>();
        RoofAddParam roofAddParam = new RoofAddParam();
        BeanUtils.copyProperties(param, roofAddParam);
        roofAddParam.setUnits(param.getUnits());
        roofs.add(roofAddParam);

        // 解析出的所有的栋座名称
        List<String> distinctBuildRoofList = roofs.stream().map(RoofAddParam::getBuildRoof).collect(Collectors.toList());

        AddBuildRoofCommonDto addBuildRoofCommonDto = this.addBuildRoofCommon(roofs, generalParam, buildId);

        // 添加单元后的单元ID
        List<Integer> addUnitIds = erpBuildingSetUnitMapper.getUnitIdsByBuildRoofs(cityId, compId, buildId, distinctBuildRoofList);
        // 更新这一楼盘中单元的roofId
        erpBuildingSetUnitMapper.updateRoofIdInUnit(cityId, compId, buildId);

        // 此时就是新添加的栋座
        List<ErpBuildingSetRoof> allBuildRoofs = erpBuildingSetRoofMapper.getBuildingSetRoofs(cityId, compId, param.getBuildId(), distinctBuildRoofList);
        // 编辑栋座管理员
        if (param.getBuildingManagerId() != null) {
            for (ErpBuildingSetRoof allBuildRoof : allBuildRoofs) {
                CreatOrEditManagerParam managerParam = new CreatOrEditManagerParam();
                managerParam.setCityId(cityId);
                managerParam.setCompId(compId);
                managerParam.setBuildId(buildId);
                managerParam.setBuildingSetRoofId(allBuildRoof.getBuildingSetRoofId().toString());

                // 备注:前端传的 buildingManagerId 为用户ID, 后端存的 buildingManagerId 为 BUILDING_MANAGER 主键ID, 在此更新
                // 栋座详情中用 buildingManagerId JOIN BUILDING_MANAGER 表,返回用户ID
                managerParam.setUserId(param.getBuildingManagerId());
                erpBuildingManagerService.creatOrEditManager(managerParam);
            }
        }

        List<String> unitList = addUnitIds.stream().distinct().map(Object::toString).collect(Collectors.toList());

        // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数,生成房间后会再更新一次
        erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId, compId, buildId,
                addBuildRoofCommonDto.getTotalRoomCount(), unitList.size(), distinctBuildRoofList.size());

        String unitIds = String.join(",", unitList);
        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, param.getBuildId(), param.getBuildRoof(), "", isCopy ? "复制栋座" : "增加栋座");

        return unitIds;
    }

    private AddBuildRoofCommonDto addBuildRoofCommon(List<RoofAddParam> roofs, GeneralParam generalParam, Integer buildId) {
        Integer provinceId = generalParam.getProvinceId();
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        String compNo = generalParam.getCompNo();

        // 前端传上来3 4 5栋数据, 数据库实际上有1 2 3栋数据, 那么需要跳过3栋, 生成4 5栋数据
        List<String> roofName = roofs.stream().map(RoofAddParam::getBuildRoof).collect(Collectors.toList());
        List<ErpBuildingSetRoof> roofNameList = erpBuildingSetRoofMapper.getBuildingSetRoofs(cityId, 0, buildId, roofName);
        List<String> roofNames = roofNameList.stream().map(ErpBuildingSetRoof::getBuildRoof).collect(Collectors.toList());
        roofs = roofs.stream().filter(it -> !roofNames.contains(it.getBuildRoof())).collect(Collectors.toList());

        // 传上来的栋, 在数据库里面全都有
        if (CollectionUtils.isEmpty(roofs)) {
            throw new BusinessException("栋座重复，请重新填写!");
        }

        // 判断栋座名和单元名重复(最新一版改为了有重复的就跳过, 就不判重了)
//        this.unitInRoofAnalysisV2(roofs, generalParam, buildId);

        // 总单元数
        int totalUnitCount = 0;
        // 总房间数
        int totalRoomCount = 0;
        // 所有需要处理的栋座
        List<ErpBuildingSetRoof> allRoofs = new ArrayList<>();
        // 所有需要添加的单元
        List<ErpBuildingSetUnit> insertUnitList = new ArrayList<>();

        for (RoofAddParam roofAddParam : roofs) {
            ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
            BeanUtils.copyProperties(roofAddParam, roof);
            roof.setProvinceId(provinceId);
            roof.setCityId(cityId);
            roof.setCompNo("");
            roof.setCompId(0);
            roof.setBuildId(buildId);

            if (roofAddParam.getHouseUseage() == null) {
                roof.setHouseUseage(-1);
            }

            List<UnitAddParam> units = roofAddParam.getUnits();

            // 异步处理的时候单元数以及户数还会更新一次
            roof.setUnits(units.size());
            // 该栋座的总房间数
            int totalRoomCountInRoof = 0;
            totalUnitCount += units.size();

            // 计算每个单元的起始房号(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
            Integer doorStartInUnit;
            // 计算每个单元的起始房号次数(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
            int addedByAllUnitsCount = 0;

            for (UnitAddParam unitAddParam : units) {
                ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();
                String doorStart = unitAddParam.getDoorStart();
                if(StringUtil.isEmpty(doorStart)){
                    doorStart = "1";
                }
                Integer floorStart = unitAddParam.getFloorStart() == null ? 0 : unitAddParam.getFloorStart();
                Integer floorEnd = unitAddParam.getFloorEnd() == null ? 0 : unitAddParam.getFloorEnd();
                String buildDoors = unitAddParam.getBuildDoors() == null ? "0" : unitAddParam.getBuildDoors();

                // 房号生成规则:字母或者楼层加字母组合,字母数量不能大于26个
                boolean letter = (unitAddParam.getRoomCompositionRule() == 2 ||
                        unitAddParam.getRoomCompositionRule() == 4 ||
                        unitAddParam.getRoomCompositionRule() == 5)
                        && (Integer.valueOf(buildDoors) + Integer.valueOf(doorStart) - 1 > 26);

                if (letter) {
                    throw new BusinessException("字母规则生成房间，字母不能大于26个！");
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

                // 该单元生成的房间数量
                int totalRoomCountInUnit = floorCount * Integer.valueOf(buildDoors);
                if (totalRoomCountInUnit > 5000) {
                    throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
                }

                totalRoomCountInRoof += totalRoomCountInUnit;
                totalRoomCount += totalRoomCountInUnit;

                BeanUtils.copyProperties(unitAddParam, erpBuildingSetUnit);
                erpBuildingSetUnit.setProvinceId(provinceId);
                erpBuildingSetUnit.setCityId(cityId);
                erpBuildingSetUnit.setCompId(0);
                erpBuildingSetUnit.setCompNo("");
                erpBuildingSetUnit.setBuildId(buildId);
                erpBuildingSetUnit.setBuildRoof(roofAddParam.getBuildRoof());
                erpBuildingSetUnit.setBuildUnit(unitAddParam.getBuildUnit());
                erpBuildingSetUnit.setBuildUnitName(roofAddParam.getBuildUnitName());
                erpBuildingSetUnit.setRoomGenerated((byte) 0);
                erpBuildingSetUnit.setDoors(totalRoomCountInUnit);
                erpBuildingSetUnit.setCreateTime(new Date());
                erpBuildingSetUnit.setUpdateTime(new Date());
                erpBuildingSetUnit.setBuildLadder(unitAddParam.getBuildLadder());
                erpBuildingSetUnit.setBuildDoors(unitAddParam.getBuildDoors());
                // 保存前端需要显示的房号起始
                erpBuildingSetUnit.setDoorStartInPage(doorStart);

                RoomRuleDto roomRuleDto = this.generateRoomRule(unitAddParam.getRoomSortRule(), unitAddParam.getRoomCompositionRule());
                erpBuildingSetUnit.setNumberRule(roomRuleDto.getNumberRule());
                erpBuildingSetUnit.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
                erpBuildingSetUnit.setNumberType(roomRuleDto.getNumberType());
                erpBuildingSetUnit.setCompriseRule(roomRuleDto.getCompriseRule());

                // 是否通排
                Byte addedByAllUnits = erpBuildingSetUnit.getAddedByAllUnits() == null ? (byte) 0 : erpBuildingSetUnit.getAddedByAllUnits();

                // 每个单元的房间起始通过是否通排计算出来
                if (addedByAllUnits.equals((byte) 1)) {
                    // 按单元排号和多单元通排(单元多单元通排)
                    if (erpBuildingSetUnit.getNumberRule() == 2) {
                        /*
                         * 按单元多单元通排 + 楼层加户(numberRule=2, addedByAllUnits=1, numberType=1, compriseRule=1, 房号: 1 2 3)
                         *
                         *    1单元              2单元             3单元
                         *  19  20  21        22  23  24        25   26  17
                         *  10  11  12        13  14  15        16   17  18
                         *  1   2   3         4   5   6         7    8    9
                         *
                         * 在有房号起始的情况下,例如起始为2, 只是第一个单元的起始值有用
                         *
                         *    1单元              2单元             3单元
                         *  18  19  20        21  22          23   24  25
                         *  10  11  12        13  14          15   16  17
                         *  2   3   4          5   6           7    8   9
                         **/
                        if (erpBuildingSetUnit.getCompriseRule() == 1) {
                            /*
                             *
                             * 0(初始偏移量) + 2 = 2(1单元doorStartInUnit)   3(1单元偏移量 addedByAllUnitsCount)
                             * 3(1单元偏移量) + 2 = 5(2单元doorStartInUnit)   5(2单元偏移量 addedByAllUnitsCount)
                             * 5(2单元偏移量) + 2 = 7(2单元doorStartInUnit)   7(3单元偏移量 addedByAllUnitsCount)
                             *
                             **/
                            doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                            addedByAllUnitsCount += Integer.valueOf(buildDoors);
                            String zeroNum = StringUtil.judgeZeroQuantity(doorStart);
                            erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                        } else {
                            /*
                             * 按单元多单元通排 + 楼层加户(numberRule=2, addedByAllUnits=1, numberType=1, compriseRule=2, 房号:101 102 103)
                             *
                             *  1单元                 2单元             3单元
                             *
                             *  319  320  321     322  323  324     325  326  327
                             *  210  211  212     213  214  215     216  217  218
                             *  101  102  103     104  105  106     107  108  109
                             *
                             * 在有房号起始的情况下,例如起始为2, 只是第一个单元的起始值有用
                             *
                             *    1单元              2单元             3单元
                             *  320  321  322     323  324  325     326  327  328
                             *  211  212  213     214  215  216     217  218  219
                             *  102  103  104     105  106  107     108  109  110
                             *
                             **/
                            doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                            addedByAllUnitsCount += Integer.valueOf(buildDoors);
                            String zeroNum = StringUtil.judgeZeroQuantity(doorStart);
                            erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                        }
                    } else {
                        // 按照楼层排号和多单元通排： 1栋1单元 doorStartInUnit:1  1栋2单元 doorStartInUnit:101 1栋3单元 doorStartInUnit:201
                        /*
                         * 按照楼层排号和多单元通排
                         *
                         *  1单元                 2单元             3单元
                         *
                         *  301  302  303     304  305  306     307  308  309
                         *  201  202  203     204  205  206     207  208  209
                         *  101  102  103     104  105  106     107  108  109
                         *
                         * 在有房号起始的情况下,例如起始为2, 只是第一个单元的起始值有用
                         *
                         *    1单元              2单元             3单元
                         *  302  303  304     305  306  307     308  309  310
                         *  202  203  204     205  206  207     208  209  210
                         *  102  103  104     105  106  107     108  109  110
                         *
                         **/
                        doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                        addedByAllUnitsCount += Integer.valueOf(buildDoors);
                        String zeroNum = StringUtil.judgeZeroQuantity(doorStart);
                        erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                    }
                }

                insertUnitList.add(erpBuildingSetUnit);
            }

            roof.setDoors(totalRoomCountInRoof);
            allRoofs.add(roof);
        }

        Optional<RoofAddParam> roofAddParam = roofs.stream().filter(it -> it.getHouseUseage() != null).findFirst();

        Integer houseUseage = 0;
        if (roofAddParam.isPresent()) {
            RoofAddParam roofAddParam1 = roofAddParam.get();
            houseUseage = roofAddParam1.getHouseUseage();
        }
        // 别墅的话,可能会出现非常多的栋,按照2000来限制单元,其余的还是走以前的255限制
        if (houseUseage == 2) {
            if (totalUnitCount > 2000) {
                throw new BusinessException("一次性生成单元数不超过2000个！");
            }
        } else {
            if (totalUnitCount > 255) {
                throw new BusinessException("一次性生成单元数不超过255个！");
            }
        }

        int baseCount = 50;
        // 批量添加栋座
        if (allRoofs.size() > 0) {
            // 需要添加的栋座去重
            allRoofs = allRoofs.stream().distinct().collect(Collectors.toList());
            for (ErpBuildingSetRoof needAddRoof : allRoofs) {
                needAddRoof.setCreateTime(new Date());
                needAddRoof.setUpdateTime(new Date());
            }
            for (int i = 0; i < allRoofs.size(); i += baseCount) {
                List<ErpBuildingSetRoof> current = allRoofs.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加栋座
                    erpBuildingSetRoofMapper.batchAddRoof(cityId, current);
                }
            }
        }
        // 批量添加单元
        if (insertUnitList.size() > 0) {
            for (int i = 0; i < insertUnitList.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = insertUnitList.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加单元(此时roofId还没有更新上去)
                    erpBuildingSetUnitMapper.batchAddUnit(cityId, compId, buildId, current);
                }
            }
        }

        // 更新这一楼盘中单元的roofId
        erpBuildingSetUnitMapper.updateRoofIdInUnit(cityId, 0, buildId);

        AddBuildRoofCommonDto dto = new AddBuildRoofCommonDto();
        dto.setTotalRoomCount(totalRoomCount);

        return dto;
    }

    /**
     * 解析房号规则,存数据库 roomSortRule, roomCompositionRule 生成 numberRule, addedByAllUnits, numberType, compriseRule
     */
    @Override
    public RoomRuleDto generateRoomRule(Byte roomSortRule, Byte roomCompositionRule) {
        RoomRuleDto dto = new RoomRuleDto();

        switch (roomSortRule) {
            case 1: {
                dto.setNumberRule((byte) 1);
                dto.setAddedByAllUnits((byte) 0);
                break;
            }
            case 2: {
                dto.setNumberRule((byte) 2);
                dto.setAddedByAllUnits((byte) 0);
                break;
            }
            case 3: {
                dto.setNumberRule((byte) 1);
                dto.setAddedByAllUnits((byte) 1);
                break;
            }
            case 4: {
                dto.setNumberRule((byte) 2);
                dto.setAddedByAllUnits((byte) 1);
                break;
            }
            default:
                break;
        }

        switch (roomCompositionRule) {
            case 1: {
                dto.setNumberType((byte) 1);
                dto.setCompriseRule((byte) 1);
                break;
            }
            case 2: {
                dto.setNumberType((byte) 2);
                dto.setCompriseRule((byte) 1);
                break;
            }
            case 3: {
                dto.setNumberType((byte) 1);
                dto.setCompriseRule((byte) 2);
                break;
            }
            case 4: {
                dto.setNumberType((byte) 2);
                dto.setCompriseRule((byte) 2);
                break;
            }
            case 5: {
                dto.setNumberType((byte) 2);
                dto.setCompriseRule((byte) 3);
                break;
            }
            case 6: {
                dto.setNumberType((byte) 1);
                dto.setCompriseRule((byte) 4);
                break;
            }
            default:
                break;
        }

        return dto;
    }

    /**
     * 解析房号规则,前端展示 numberRule, addedByAllUnits, numberType, compriseRule 生成 roomSortRule, roomCompositionRule
     */
    @Override
    public RoomRuleDto generateRoomRuleWhenShow(Byte numberRule, Byte addedByAllUnits, Byte numberType, Byte compriseRule) {
        RoomRuleDto dto = new RoomRuleDto();

        // 以前有的规则 addedByAllUnits 没有填写
        if (addedByAllUnits == null) {
            addedByAllUnits = (byte) 0;
        }

        if (numberRule == 1 && addedByAllUnits == 0) {
            dto.setRoomSortRule((byte) 1);
        } else if (numberRule == 2 && addedByAllUnits == 0) {
            dto.setRoomSortRule((byte) 2);
        } else if (numberRule == 1 && addedByAllUnits == 1) {
            dto.setRoomSortRule((byte) 3);
        } else if (numberRule == 2 && addedByAllUnits == 1) {
            dto.setRoomSortRule((byte) 4);
        }

        if (numberType == 1 && compriseRule == 1) {
            dto.setRoomCompositionRule((byte) 1);
        } else if (numberType == 2 && compriseRule == 1) {
            dto.setRoomCompositionRule((byte) 2);
        } else if (numberType == 1 && compriseRule == 2) {
            dto.setRoomCompositionRule((byte) 3);
        } else if (numberType == 2 && compriseRule == 2) {
            dto.setRoomCompositionRule((byte) 4);
        } else if (numberType == 2 && compriseRule == 3) {
            dto.setRoomCompositionRule((byte) 5);
        }else if (numberType == 1 && compriseRule == 4) {
            dto.setRoomCompositionRule((byte) 6);
        }

        return dto;
    }

    @Override
    public String updateBuildRoofV2(RoofEditParam editParam, GeneralParam generalParam) {
        Integer provinceId = generalParam.getProvinceId();
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();
        Integer buildId = editParam.getBuildId();
        Integer buildingSetRoofId = editParam.getBuildingSetRoofId();

        Integer repeatCount = erpBuildingSetRoofMapper.getRoofUnitNameRepeatCount(cityId, 0,
                editParam.getBuildId(), editParam.getBuildRoof(), editParam.getBuildingSetRoofId());
        if (repeatCount != null && repeatCount > 0) {
            throw new BusinessException("栋名与已有栋重复，请重新填写");
        }

        // 是否只修改了基础信息(栋座名称,责任人,单元名称,其他属性),没有修改规则(0=否 1=是)
        if (editParam.getOnlyUpdateBase() != null && editParam.getOnlyUpdateBase() == 1) {
            ErpBuildingSetRoofUpdateParam param = new ErpBuildingSetRoofUpdateParam();
            BeanUtils.copyProperties(editParam, param);
            this.updateBuildingSetRoof(param, cityId, compId, userId);

            ErpBuildingSetUnit buildingSetUnit = new ErpBuildingSetUnit();
            buildingSetUnit.setBuildUnitName(editParam.getBuildUnitName());
            ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
            unitExample.setShardCityId(cityId);
            unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
            erpBuildingSetUnitMapper.updateByExampleSelective(buildingSetUnit, unitExample);

            return "";
        }

        // 将该公司该楼盘该栋所有单元规则删除
        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
        erpBuildingSetUnitMapper.deleteByExample(unitExample);

        // 将该公司该楼盘该栋所有楼层规则删除
        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
        erpBuildingSetFloorMapper.deleteByExample(floorExample);

        // 将该公司该楼盘该栋所有房间规则删除
        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
        erpBuildingSetRoomMapper.deleteByExample(roomExample);

        // 所有需要添加的单元
        List<ErpBuildingSetUnit> insertUnitList = new ArrayList<>();

        ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
        BeanUtils.copyProperties(editParam, roof);
        roof.setProvinceId(provinceId);
        roof.setCityId(cityId);
        roof.setCompNo("");
        roof.setCompId(0);
        roof.setBuildId(buildId);

        List<UnitAddParam> units = editParam.getUnits();

        if (units.size() > 255) {
            throw new BusinessException("一次性生成单元数不超过255个！");
        }

        // 异步处理的时候单元数以及户数还会更新一次
        roof.setUnits(units.size());
        // 计算每个单元的起始房号(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
        Integer doorStartInUnit;
        // 计算每个单元的起始房号次数(和通排有关,单元只在同一栋通排,这时候还没有doorStart)
        int addedByAllUnitsCount = 0;
        // 该栋座的总房间数
        int totalRoomCountInRoof = 0;

        for (UnitAddParam unitAddParam : units) {
            ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();

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

            // 该单元生成的房间数量
            int totalRoomCountInUnit = floorCount * Integer.valueOf(buildDoors);
            if (totalRoomCountInUnit > 5000) {
                throw new BusinessException("每个单元一次性生成房间数不超过5000个！");
            }

            totalRoomCountInRoof += totalRoomCountInUnit;

            BeanUtils.copyProperties(unitAddParam, erpBuildingSetUnit);
            erpBuildingSetUnit.setProvinceId(provinceId);
            erpBuildingSetUnit.setCityId(cityId);
            erpBuildingSetUnit.setCompId(0);
            erpBuildingSetUnit.setCompNo("");
            erpBuildingSetUnit.setBuildId(buildId);
            erpBuildingSetUnit.setBuildRoof(editParam.getBuildRoof());
            erpBuildingSetUnit.setBuildUnit(unitAddParam.getBuildUnit());
            erpBuildingSetUnit.setBuildUnitName(editParam.getBuildUnitName());
            erpBuildingSetUnit.setRoomGenerated((byte) 0);
            erpBuildingSetUnit.setDoors(totalRoomCountInUnit);
            erpBuildingSetUnit.setUpdateTime(new Date());
            erpBuildingSetUnit.setBuildLadder(unitAddParam.getBuildLadder());
            erpBuildingSetUnit.setBuildDoors(unitAddParam.getBuildDoors());

            RoomRuleDto roomRuleDto = this.generateRoomRule(unitAddParam.getRoomSortRule(), unitAddParam.getRoomCompositionRule());
            erpBuildingSetUnit.setNumberRule(roomRuleDto.getNumberRule());
            erpBuildingSetUnit.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
            erpBuildingSetUnit.setNumberType(roomRuleDto.getNumberType());
            erpBuildingSetUnit.setCompriseRule(roomRuleDto.getCompriseRule());
            erpBuildingSetUnit.setDoorStartInPage(unitAddParam.getDoorStart());
            String doorStart = unitAddParam.getDoorStart();
            String zeroNum = StringUtil.judgeZeroQuantity(doorStart);
            // 是否通排
            Byte addedByAllUnits = erpBuildingSetUnit.getAddedByAllUnits() == null ? (byte) 0 : erpBuildingSetUnit.getAddedByAllUnits();

            // 每个单元的房间起始通过是否通排计算出来
            if (addedByAllUnits.equals((byte) 1)) {
                // 按单元排号和多单元通排
                if (erpBuildingSetUnit.getNumberRule() == 2) {
                    /*
                     *  只按照户号排
                     *
                     *   9 10 11 12         21  22  23  24
                     *  -5 -6 -7 -8        -17 -18 -19 -20
                     *  -1 -2 -3 -4        -13 -14 -15 -16
                     **/
                    if (erpBuildingSetUnit.getCompriseRule() == 1) {
                        /*
                         * 4 * 3 * 0 + 1 = 1
                         * 4 * 3 * 1 + 1 = 13
                         * 4 * 3 * 2 + 1 = 25
                         **/
//                        doorStartInUnit = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
//                        addedByAllUnitsCount++;
//                        erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());

                        doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                        addedByAllUnitsCount += Integer.valueOf(buildDoors);
                        erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                    } else {
                        /*
                         * 按照单元排号和多单元通排
                         *
                         * 1单元:                       2单元:                        3单元:
                         *        107  108  109                116  117  118                  125  126  127
                         *       -104 -105 -106               -113 -114 -115                 -122 -123 -124
                         *       -201 -202 -203               -210 -211 -212                 -219 -220 -221
                         *
                         * max值为: 1, 10, 19
                         *
                         * 1单元:                       2单元:                        3单元:
                         *        1201 ...  1300               1501 ...  1600                  1801  ... 1900
                         *       -1101 ... -1200              -1401 ... -1500                 -1701 ... -1800
                         *       -201  ... -2100              -2301 ... -2400                 -2601 ... -2700
                         *
                         * max值为: 1, 301, 601
                         *
                         * 1单元:                       2单元:                        3单元:
                         *        1199 ...  1297               1496 ...  1594                  1793  ... 1891
                         *       -1100 ... -1198              -1397 ... -1495                 -1694 ... -1792
                         *       -201  ... -299               -2298 ... -2396                 -2595 ... -2693
                         *
                         * max值为: 1, 300, 600
                         *
                         **/
//                        Integer max = Integer.valueOf(buildDoors) * floorCount * addedByAllUnitsCount + 1;
//                        erpBuildingSetUnit.setDoorStart(zeroNum+max.toString());
//                        addedByAllUnitsCount++;

                        doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                        addedByAllUnitsCount += Integer.valueOf(buildDoors);
                        erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                    }
                } else {
                    // 按照楼层排号和多单元通排： 1栋1单元 doorStartInUnit:1  1栋2单元 doorStartInUnit:101 1栋3单元 doorStartInUnit:201
//                    doorStartInUnit = Integer.valueOf(buildDoors) * addedByAllUnitsCount + 1;
//                    addedByAllUnitsCount++;
//                    erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());

                    doorStartInUnit = addedByAllUnitsCount + Integer.valueOf(doorStart);
                    addedByAllUnitsCount += Integer.valueOf(buildDoors);
                    erpBuildingSetUnit.setDoorStart(zeroNum+doorStartInUnit.toString());
                }
            }

            insertUnitList.add(erpBuildingSetUnit);
        }

        roof.setDoors(totalRoomCountInRoof);

        ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
        roofExample.setShardCityId(cityId);
        roofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(editParam.getBuildingSetRoofId());
        roof.setBuildingSetRoofId(null);
        erpBuildingSetRoofMapper.updateByExampleSelective(roof, roofExample);

        int baseCount = 50;
        // 批量添加单元
        if (insertUnitList.size() > 0) {
            for (int i = 0; i < insertUnitList.size(); i += baseCount) {
                List<ErpBuildingSetUnit> current = insertUnitList.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    // 批量添加单元(此时roofId还没有更新上去)
                    erpBuildingSetUnitMapper.batchAddUnit(cityId, 0, buildId, current);
                }
            }
        }

        // 更新这一楼盘中单元的roofId
        erpBuildingSetUnitMapper.updateRoofIdInUnit(cityId, 0, buildId);

        unitExample.clear();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
        // 以前的单元都删除了,这是新的单元列表
        List<ErpBuildingSetUnit> newUnits = erpBuildingSetUnitMapper.selectByExample(unitExample);

        // 添加单元后的单元ID
        List<String> unitList = newUnits.stream().map(it -> it.getId().toString()).collect(Collectors.toList());
        String unitIds = String.join(",", unitList);

        // 编辑栋座管理员
        if (editParam.getBuildingManagerId() != null) {
            CreatOrEditManagerParam managerParam = new CreatOrEditManagerParam();
            managerParam.setCityId(cityId);
            managerParam.setCompId(compId);
            managerParam.setBuildId(buildId);
            managerParam.setBuildingSetRoofId(editParam.getBuildingSetRoofId().toString());

            // 备注:前端传的 buildingManagerId 为用户ID, 后端存的 buildingManagerId 为 BUILDING_MANAGER 主键ID, 在此更新
            // 栋座详情中用 buildingManagerId JOIN BUILDING_MANAGER 表,返回用户ID
            managerParam.setUserId(editParam.getBuildingManagerId());
            erpBuildingManagerService.creatOrEditManager(managerParam);
        }

        // 修改FUN_BUILD_ROOFUNITDOORS表户数,这个地方更新单元数和栋座数,房间数在taskWeb会修改
        erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, 0, editParam.getBuildId());
        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, editParam.getBuildId(), editParam.getBuildRoof(), "", "编辑栋座");

        return unitIds;
    }

    @Override
    public RoofDetailsVo getBuildRoofRuleV2(ErpBuildingSetRoofIdParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer buildId = param.getBuildId();
        Integer buildingSetRoofId = param.getBuildingSetRoofId();

        RoofDetailsVo roofDetailsVo = new RoofDetailsVo();

        ErpBuildingSetRoofRuleVo roofRuleVo = erpBuildingSetRoofMapper.getBuildingSetRoofRuleVo(cityId, generalParam.getCompId(), param.getBuildId(), param.getBuildingSetRoofId());

        roofDetailsVo.setBuildId(roofRuleVo.getBuildId());
        roofDetailsVo.setBuildRoof(roofRuleVo.getBuildRoof());
        roofDetailsVo.setBuildRoofName(roofRuleVo.getBuildRoofName());
        roofDetailsVo.setBuildingManagerId(roofRuleVo.getBuildingManagerId());
        roofDetailsVo.setBuildUnitName(roofRuleVo.getBuildUnitName());
        roofDetailsVo.setUnitPreFix(roofRuleVo.getUnitPreFix());
        roofDetailsVo.setInunitSuffixType(roofRuleVo.getInunitSuffixType());
        roofDetailsVo.setHouseType(roofRuleVo.getHouseType());
        roofDetailsVo.setHouseUseage(roofRuleVo.getHouseUseage());
        roofDetailsVo.setHouseYear(roofRuleVo.getHouseYear());
        roofDetailsVo.setBuildLandNature(roofRuleVo.getBuildLandNature());
        roofDetailsVo.setBuildRightNature(roofRuleVo.getBuildRightNature());
        roofDetailsVo.setBuildLandAge(roofRuleVo.getBuildLandAge());

        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildingSetRoofIdEqualTo(buildingSetRoofId);
        List<ErpBuildingSetUnit> buildingSetUnits = erpBuildingSetUnitMapper.selectByExample(unitExample);

        List<UnitDetailsVo> unitDetailsVos = new ArrayList<>();

        for (ErpBuildingSetUnit erpBuildingSetUnit : buildingSetUnits) {
            UnitDetailsVo unitDetails = new UnitDetailsVo();
            BeanUtils.copyProperties(erpBuildingSetUnit, unitDetails);

            RoomRuleDto dto = generateRoomRuleWhenShow(erpBuildingSetUnit.getNumberRule(), erpBuildingSetUnit.getAddedByAllUnits(),
                    erpBuildingSetUnit.getNumberType(), erpBuildingSetUnit.getCompriseRule());
            unitDetails.setRoomSortRule(dto.getRoomSortRule());
            unitDetails.setRoomCompositionRule(dto.getRoomCompositionRule());
            unitDetails.setDoorStart(erpBuildingSetUnit.getDoorStartInPage());
            unitDetailsVos.add(unitDetails);
        }

        roofDetailsVo.setUnits(unitDetailsVos);

        return roofDetailsVo;
    }

    @Override
    public BuildRoofRuleInMobileVo getBuildRoofListInMobile(BuildIdInMobileParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer buildId = param.getBuildId();
        BuildRoofRuleInMobileVo buildRoofRuleInMobileVo = new BuildRoofRuleInMobileVo();

        ErpFunBuildRoofunitdoors buildRoofUnitDoors = erpFunBuildRoofunitdoorsMapper.geterpFunBuildRoofunitdoorsByBuild(cityId, 0, buildId);
       
        if (buildRoofUnitDoors != null) {
            Integer roofs = buildRoofUnitDoors.getRoofs();
            Integer doors = buildRoofUnitDoors.getDoors();
            buildRoofRuleInMobileVo.setRoofCount(roofs);
            buildRoofRuleInMobileVo.setRoomCount(doors);
        }

        RoomConInfoCountParam roomConInfoCountParam = new RoomConInfoCountParam();
        roomConInfoCountParam.setBuildId(param.getBuildId());
        RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(roomConInfoCountParam, generalParam);

        buildRoofRuleInMobileVo.setSaleCount(conInfoCount.getSaleCount());
        buildRoofRuleInMobileVo.setLeaseCount(conInfoCount.getLeaseCount());
        buildRoofRuleInMobileVo.setSaleAndLeaseCount(conInfoCount.getSaleAndLeaseCount());

        List<BuildRoofNameInMobileVo> buildRoofNames = erpBuildingSetRoofMapper.getBuildRoofNames(cityId, 0, buildId);
        buildRoofRuleInMobileVo.setBuildRoofNames(buildRoofNames);

        return buildRoofRuleInMobileVo;
    }

    @Override
    public BuildRoofDetailsInMobileVo getBuildRoofDetailsInMobile(BuildRoofIdParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer buildId = param.getBuildId();
        Integer buildingSetRoofId = param.getBuildingSetRoofId();

        BuildRoofDetailsInMobileVo buildRoofDetailsInMobileVo = new BuildRoofDetailsInMobileVo();

        ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
        roof.setShardCityId(cityId);
        roof.setCompId(0);
        roof.setBuildId(buildId);
        roof.setBuildingSetRoofId(buildingSetRoofId);
        roof = erpBuildingSetRoofMapper.selectByPrimaryKey(roof);

        if (roof == null || roof.getBuildRoof() == null) {
            throw new BusinessException("该栋座不存在！");
        }

        RoomConInfoCountParam roomConInfoCountParam = new RoomConInfoCountParam();
        roomConInfoCountParam.setBuildId(param.getBuildId());
        roomConInfoCountParam.setBuildingSetRoofId(param.getBuildingSetRoofId());
        RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(roomConInfoCountParam, generalParam);

        buildRoofDetailsInMobileVo.setBuildingSetRoofId(buildingSetRoofId);
        buildRoofDetailsInMobileVo.setBuildRoof(roof.getBuildRoof());
        buildRoofDetailsInMobileVo.setBuildRoofName(roof.getBuildRoofName());
        buildRoofDetailsInMobileVo.setSaleCount(conInfoCount.getSaleCount());
        buildRoofDetailsInMobileVo.setLeaseCount(conInfoCount.getLeaseCount());
        buildRoofDetailsInMobileVo.setSaleAndLeaseCount(conInfoCount.getSaleAndLeaseCount());

        if (roof.getBuildingManagerId() != null) {
            ErpBuildingManager erpBuildingManager = new ErpBuildingManager();
            erpBuildingManager.setShardCityId(cityId);
            erpBuildingManager.setCompId(compId);
            erpBuildingManager.setBuildingManagerId(roof.getBuildingManagerId());
            erpBuildingManager = erpBuildingManagerMapper.selectByPrimaryKey(erpBuildingManager);
            if (erpBuildingManager != null && erpBuildingManager.getUserId() != null) {
                buildRoofDetailsInMobileVo.setBuildingManagerId(erpBuildingManager.getUserId());
            }
        }

        List<BuildUnitNameInMobileVo> units = erpBuildingSetUnitMapper.getBuildUnitNames(cityId, compId, buildId, buildingSetRoofId);
        buildRoofDetailsInMobileVo.setUnits(units);

        if (units != null && units.size() > 0) {
            for (BuildUnitNameInMobileVo unit : units) {
                RoomRuleDto dto = generateRoomRuleWhenShow(unit.getNumberRule(), unit.getAddedByAllUnits(), unit.getNumberType(), unit.getCompriseRule());
                unit.setRoomSortRule(dto.getRoomSortRule());
                unit.setRoomCompositionRule(dto.getRoomCompositionRule());
            }
        }

        return buildRoofDetailsInMobileVo;
    }
    @Transactional
    @Override
    public void deleteBuildingInfo(Integer cityId, Integer compId, Integer buildId, Integer userId) {
        ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
        erpBuildingInfo.setBuildId(buildId);
        erpBuildingInfo.setShardCityId(cityId);
        erpBuildingInfo.setVertifyFlag((short)0);
        erpBuildingInfoMapper.updateByPrimaryKeySelective(erpBuildingInfo);
        this.delBuildRuleById(cityId,compId,buildId,userId);
    }
}
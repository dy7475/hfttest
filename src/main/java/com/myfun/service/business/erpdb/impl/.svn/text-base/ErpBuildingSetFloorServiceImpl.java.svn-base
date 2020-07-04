package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.businesstools.builddic.param.BatchUpdateRoomMd5;
import com.myfun.erpWeb.businesstools.builddic.param.BuildFloorAddParam;
import com.myfun.erpWeb.businesstools.builddic.param.BuildFloorIdParam;
import com.myfun.erpWeb.businesstools.builddic.param.BuildingSetFloorParam;
import com.myfun.erpWeb.businesstools.builddic.vo.RoomRuleDto;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingSetFloorService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoofService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomService;
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
import java.util.stream.Collectors;

/**
 * @author czq
 * @since 2018/12/18
 */
@Service
public class ErpBuildingSetFloorServiceImpl extends AbstractService<ErpBuildingSetFloor, ErpBuildingSetFloor> implements ErpBuildingSetFloorService {

    @Resource
    private ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
    @Resource
    private ErpBuildingSetLogMapper erpBuildingSetLogMapper;
    @Resource
    private ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
    @Resource
    private ErpBuildingSetRoomService erpBuildingSetRoomService;
    @Resource
    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;
    @Resource
    private ErpSysParaMapper erpSysParaMapper;
    @Resource
    private ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
    @Resource
    private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
    @Resource
    private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Resource
    private ErpBuildingSetRoofService erpBuildingSetRoofService;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildingSetFloorMapper;
    }

    @Transactional
    @Override
    public void updateBuildFloor(BuildingSetFloorParam param, Integer cityId, Integer compId, Integer userId) {
        Integer buildingSetFloorId = param.getBuildingSetFloorId();
        if (param.getBuildingSetUnitId() == null) {
            throw new BusinessException("缺少单元或者号位信息！");
        }

        // 要修改的楼层名以及用途,和当前的一致,则直接返回
        ErpBuildingSetFloorExample example = new ErpBuildingSetFloorExample();

        if (param.getFloorUseage() == null) {
            example.setShardCityId(cityId);
            example.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                    .andIdEqualTo(buildingSetFloorId)
                    .andBuildFloorEqualTo(param.getBuildFloor())
                    .andFloorUseageIsNull();
            int count = erpBuildingSetFloorMapper.countByExample(example);
            if (count > 0) {
                return;
            }
        } else {
            example.setShardCityId(cityId);
            example.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                    .andIdEqualTo(buildingSetFloorId)
                    .andBuildFloorEqualTo(param.getBuildFloor())
                    .andFloorUseageEqualTo(param.getFloorUseage().intValue());
            int count = erpBuildingSetFloorMapper.countByExample(example);
            if (count > 0) {
                return;
            }
        }

        // 当前单元中是否已经存在该楼层名
        example.clear();
        example.setShardCityId(cityId);
        example.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                .andBuildFloorEqualTo(param.getBuildFloor())
                .andIdNotEqualTo(buildingSetFloorId);
        int nameCount = erpBuildingSetFloorMapper.countByExample(example);
        if (nameCount > 0) {
            throw new BusinessException("楼层名重复，请修改后重新保存！");
        }

        int currentNameCount = erpBuildingSetFloorMapper.selectCountInFloor(cityId, 0,
                param.getBuildId(), param.getBuildingSetUnitId(), buildingSetFloorId, param.getBuildFloor());

        // 号位规则, 房间MD5不带楼层
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        // 楼层名字已经修改(修改楼层下的房间的MD5)
        if (currentNameCount == 0) {
            ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
            roomExample.setShardCityId(cityId);
            roomExample.createCriteria()
                    .andCompIdEqualTo(0)
                    .andBuildIdEqualTo(param.getBuildId())
                    .andBuildingSetFloorIdEqualTo(buildingSetFloorId);
            List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.selectByExample(roomExample);

            List<BatchUpdateRoomMd5> batchUpdateRoomMd5s = new ArrayList<>();
            for (ErpBuildingSetRoom room : rooms) {
                String buildRoof = room.getBuildRoof();
                String buildUnit = room.getBuildUnit();
                String buildFloor = param.getBuildFloor();
                String roomId = room.getRoomId();
                Integer buildingSetRoomId = room.getId();

                // 需要更新的MD5
                String addMd5;
                if ("2".equals(paramValue)) {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), buildUnit, roomId);
                } else {
                    addMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, buildUnit, buildFloor, roomId);
                }

                // 老MD5
                String oldAddMd5;
                if ("2".equals(paramValue)) {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), buildUnit, roomId);
                } else {
                    oldAddMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), buildRoof, buildUnit, room.getRoomFloor(), roomId);
                }

                BatchUpdateRoomMd5 batchUpdateRoomMd5 = new BatchUpdateRoomMd5();
                batchUpdateRoomMd5.setBuildId(param.getBuildId());
                batchUpdateRoomMd5.setBuildingSetRoomId(buildingSetRoomId);
                batchUpdateRoomMd5.setBuildFloor(buildFloor);
                batchUpdateRoomMd5.setAddMd5(addMd5);
                batchUpdateRoomMd5.setOldAddMd5(oldAddMd5);
                batchUpdateRoomMd5s.add(batchUpdateRoomMd5);
            }

            // 批量添加房间,每次最多五十条
            int baseCount = 50;

            if (batchUpdateRoomMd5s.size() > 0) {
                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += baseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) erpBuildingSetRoomMapper.batchUpdateRoomMd5(cityId, 0, param.getBuildId(), current);
                }
                for (int i = 0; i < batchUpdateRoomMd5s.size(); i += baseCount) {
                    List<BatchUpdateRoomMd5> current = batchUpdateRoomMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        erpBuildingMarketingControlMapper.batchUpdateRoomMd5(cityId, compId, param.getBuildId(), current);
                    }
                }
            }
        }

        ErpBuildingSetFloor record = new ErpBuildingSetFloor();
        record.setBuildFloor(param.getBuildFloor());
        if (param.getFloorUseage() != null) {
            record.setFloorUseage(param.getFloorUseage().intValue());
        }
        record.setUpdateTime(new Date());

        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                .andIdEqualTo(buildingSetFloorId);
        erpBuildingSetFloorMapper.updateByExampleSelective(record, floorExample);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), "",
                param.getBuildingSetUnitId().toString(), "修改楼层名 " + param.getBuildFloor() + ", 修改用途 " + param.getFloorUseage());
    }

    @Override
    public void addBuildFloor(BuildFloorAddParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();

        ErpBuildingSetFloorExample example = new ErpBuildingSetFloorExample();
        example.setShardCityId(cityId);
        example.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                .andBuildFloorEqualTo(param.getBuildFloor());
        int buildFloorCount = erpBuildingSetFloorMapper.countByExample(example);
        if (buildFloorCount > 0) {
            throw new BusinessException("楼层别名重复，请修改后重新保存！");
        }

        example.clear();
        example.setShardCityId(cityId);
        example.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(param.getBuildId())
                .andBuildingSetUnitIdEqualTo(param.getBuildingSetUnitId())
                .andSysBuildFloorEqualTo(param.getSysBuildFloor());
        int sysBuildFloorCount = erpBuildingSetFloorMapper.countByExample(example);
        if (sysBuildFloorCount > 0) {
            throw new BusinessException("所属楼层重复，请修改后重新保存！");
        }

        ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
        if (param.getBuildingSetRoofId() != null) {
            roof.setShardCityId(cityId);
            roof.setCompId(0);
            roof.setBuildId(param.getBuildId());
            roof.setBuildingSetRoofId(param.getBuildingSetRoofId());
            roof = erpBuildingSetRoofMapper.selectByPrimaryKey(roof);
        }
        ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
        if (param.getBuildingSetUnitId() != null) {
            unit.setShardCityId(cityId);
            unit.setCompId(0);
            unit.setBuildId(param.getBuildId());
            unit.setId(param.getBuildingSetUnitId());
            unit = erpBuildingSetUnitMapper.selectByPrimaryKey(unit);
        }

        ErpBuildingSetFloor floor = new ErpBuildingSetFloor();
        floor.setShardCityId(cityId);
        BeanUtils.copyProperties(param, floor);
        floor.setUpdateTime(new Date());
        floor.setCreationTime(new Date());
        floor.setCityId(cityId);
        floor.setCompId(0);

        if (roof != null && roof.getHouseUseage() != null && param.getFloorUseage() == null) {
            floor.setFloorUseage(roof.getHouseUseage());
        }
        if (unit != null && StringUtils.isNotBlank(unit.getBuildUnit())) {
            floor.setBuildUnit(unit.getBuildUnit());
        }
        if (unit != null && StringUtils.isNotBlank(unit.getBuildRoof())) {
            floor.setBuildRoof(unit.getBuildRoof());
        }

        erpBuildingSetFloorMapper.insertSelective(floor);

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "添加楼层: " + floor.getId());
    }

    @Override
    public void delBuildFloorById(BuildFloorIdParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer userId = generalParam.getUserId();
        Integer buildId = param.getBuildId();
        Integer buildingSetFloorId = param.getBuildingSetFloorId();

        ErpBuildingSetFloor floor = new ErpBuildingSetFloor();
        floor.setShardCityId(cityId);
        floor.setBuildId(buildId);
        floor.setId(buildingSetFloorId);
        ErpBuildingSetFloor erpBuildingSetFloor = erpBuildingSetFloorMapper.selectByPrimaryKey(floor);

        if (erpBuildingSetFloor == null) {
            throw new BusinessException("该楼层不存在！");
        }

        erpBuildingSetFloorMapper.deleteByPrimaryKey(floor);

        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria()
                .andCompIdEqualTo(0)
                .andBuildIdEqualTo(buildId)
                .andBuildingSetFloorIdEqualTo(buildingSetFloorId);
        erpBuildingSetRoomMapper.deleteByExample(roomExample);

        Integer buildingSetRoofId = erpBuildingSetFloor.getBuildingSetRoofId();
        Integer buildingSetUnitId = erpBuildingSetFloor.getBuildingSetUnitId();

        // 修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数
        erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, 0, buildId);
        // 修改单元表中的户数
        erpBuildingSetUnitMapper.updateRoomCountInUnit(cityId, 0, param.getBuildId(), buildingSetUnitId);
        if (buildingSetRoofId != null) {
            // 修改栋表中的户数单元数
            erpBuildingSetRoofMapper.updateRoomAndUnitCountInRoof(cityId, 0, param.getBuildId(), buildingSetRoofId);
        }

        erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(), buildingSetRoofId == null ? "" : buildingSetRoofId.toString(),
                buildingSetUnitId == null ? "" : buildingSetUnitId.toString(), "删除楼层: " + erpBuildingSetFloor.getBuildFloor());
    }

}
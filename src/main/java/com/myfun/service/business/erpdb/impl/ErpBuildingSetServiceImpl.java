package com.myfun.service.business.erpdb.impl;

import java.util.*;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.businesstools.builddic.param.CopyTempParam;
import com.myfun.erpWeb.businesstools.builddic.param.UpdateBuildRoofUnitsAndDoorsParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.HeavenlyStem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomService;
import com.myfun.service.business.erpdb.ErpBuildingSetService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.StringUtil;

/**
 * @author 方李骥
 * @since 2016年9月2日
 */
@Service
public class ErpBuildingSetServiceImpl extends AbstractService<ErpBuildingSet,ErpBuildingSet>implements ErpBuildingSetService {
	@Autowired private ErpBuildingSetMapper erpBuildingSetMapper;
	@Autowired private ErpUserOpersService erpUserOpersService;
	@Autowired private ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
	@Autowired private ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
	@Autowired private ErpBuildingSetRoomService erpBuildingSetRoomService;
	@Autowired private ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired private ErpBuildingSetLogMapper erpBuildingSetLogMapper;
	@Autowired private ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
	@Autowired private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
	@Autowired private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Autowired private ErpBuildingInfoMapper erpBuildingInfoMapper;

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 */
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBuildingSetMapper;
		
	}

	/**
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	@Override
	public void updateLockBuildRule(ErpBuildingSet erpBuildingSet, Integer buildLock, Integer userId, Integer deptId) {
		boolean lockBuilding = erpUserOpersService.judgePermission(erpBuildingSet.getCityId(), userId, "LOCK_BUILDING");
		if (!lockBuilding) {
			new BusinessException("没锁定权限！！");// 没锁定权限
		}
		ErpBuildingSet buildingTmp = new ErpBuildingSet();
		if (buildLock == 1) {
			// 锁定时判断有没有comp_id=0的，没有则新增
			buildingTmp = erpBuildingSetMapper.getErpBuildingSet(erpBuildingSet.getCityId(), 0, erpBuildingSet.getBuildId(), null);
		}
		// 修改锁定状态
		ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(erpBuildingSet.getCityId(), erpBuildingSet.getCompId(), erpBuildingSet.getBuildId());
		if(erpBuildingSetSetting == null) {
			erpBuildingSetSetting = new ErpBuildingSetSetting();
			erpBuildingSetSetting.setCompId(erpBuildingSet.getCompId());
			erpBuildingSetSetting.setDeptId(deptId);
			erpBuildingSetSetting.setShardCityId(erpBuildingSet.getCityId());
			erpBuildingSetSetting.setCreationTime(new Date());
			erpBuildingSetSetting.setBuildId(erpBuildingSet.getBuildId());
			erpBuildingSetSetting.setBuildLock(buildLock.byteValue());
			erpBuildingSetSettingMapper.insertSelective(erpBuildingSetSetting);
		} else {
			erpBuildingSetSettingMapper.updateLockBuildRule(erpBuildingSet.getCityId(), erpBuildingSet.getCompId(), deptId, erpBuildingSet.getBuildId(), buildLock);
		}
		// 不存在时创建模板，公司ID等于0的是模板
		if (buildingTmp == null) {
			// 排除测试公司，排不完，先把已知的排除下
			List<String> compNoTmp = Arrays.asList(
					"AA01", "A23Y", "BK72", "BK90", "BW70", "AEKQ", "B673", "BGS3", "BAF5",
					"BP58", "BJ08", "BZB2", "BLY8", "ARR3", "ATWE", "BEF4", "BX41", "BKY8",
					"BZ74", "B472", "BFM8", "BMP8", "BWB6", "BHT9", "BDH8", "BPJ1", "BZE2","DZ70");
			if(!compNoTmp.contains(erpBuildingSet.getCompNo())) {
				erpBuildingSetMapper.createTempBuildingSet(erpBuildingSet.getCityId(), erpBuildingSet.getCompId(), erpBuildingSet.getBuildId(), 0, "0");
			}
		}
		erpBuildingSetLogMapper.insertLog(erpBuildingSet.getCityId(), userId, erpBuildingSet.getCompId(),
				erpBuildingSet.getBuildId(), erpBuildingSet.getBuildRoof(), erpBuildingSet.getBuildUnit(),
				(buildLock == 0) ? "解锁规则" : "锁定规则");
	}
	
	/**
	 * 批量添加栋座规则
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 */
	@Transactional
	@Override
	public void batchImporFunBuildRules(ErpBuildingSetParam param) {
		// 单元名称不为空说明是添加单个单元
		if(StringUtils.isNotBlank(param.getBuildUnit())) {
			this.judgeRoofUnitNameRepeat(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), null);
			if(param.getAddedByAllUnits() != null && param.getAddedByAllUnits() == 1 && param.getDoorStart() == null) {
				Integer startNum = erpBuildingSetMapper.getDoorStartNum(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getNumberRule());
				if(startNum == null) {
					startNum = 0;
				}
				param.setDoorStart(startNum + 1);
			}
			erpBuildingSetMapper.insertSelective(param);
			erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
					param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "新增规则日志02");
		} else {
			
			int startRoof = 1, endRoof = 1;// 默认只有一栋
			int startUnit = 1, endUnit = 1;// 默认只有一单元
			// 栋座名称为空表示批量添加栋座
			boolean isOlnyOneRoof = StringUtils.isNotBlank(param.getBuildRoof());
			
			if(!isOlnyOneRoof) {
				if(param.getRoofSuffixType() == 1) {
					startRoof = StringUtil.parseInteger(param.getRoofSuffixStart(), 1);
					endRoof = StringUtil.parseInteger(param.getRoofSuffixEnd(), 1);
				} else if (param.getRoofSuffixType() == 2){
					startRoof = param.getRoofSuffixStart().charAt(0);
					endRoof = param.getRoofSuffixEnd().charAt(0);
				}else {
					startRoof=HeavenlyStem.heavenlyStemMap.get(param.getRoofSuffixStart());
					endRoof=HeavenlyStem.heavenlyStemMap.get(param.getRoofSuffixEnd());
				}
			}
			if(param.getUnitSuffixType() == 1) {
				startUnit = StringUtil.parseInteger(param.getUnitSuffixStart(), 1);
				endUnit = StringUtil.parseInteger(param.getUnitSuffixEnd(), 1);
			} else if (param.getUnitSuffixType() == 2){
				startUnit = param.getUnitSuffixStart().charAt(0);
				endUnit = param.getUnitSuffixEnd().charAt(0);
			}else {
				startUnit=HeavenlyStem.heavenlyStemMap.get(param.getUnitSuffixStart());
				endUnit =HeavenlyStem.heavenlyStemMap.get(param.getUnitSuffixEnd());
			}
			// 批量插入单元，一次只有一个单元
			for (int roof = startRoof; roof <= endRoof; roof++) {
				if (!isOlnyOneRoof) {
					String roofStr = param.getRoofPrefix();
					if(param.getRoofSuffixType() == 1){
						roofStr +=roof;
					}else if (param.getRoofSuffixType() == 2){
						roofStr +=String.valueOf((char) roof);
					}else {
						roofStr +=HeavenlyStem.heavenlyStem[roof];
					}
					param.setBuildRoof(roofStr);
				}
				
				int roomStart = 1;
				for (int unit = startUnit; unit <= endUnit; unit++) {
					param.setDoorStart(roomStart);
					String unitStr = param.getUnitPrefix();
					if(param.getUnitSuffixType() == 1){
						unitStr +=unit;
					}else if (param.getUnitSuffixType() == 2){
						unitStr +=String.valueOf((char) unit);
					}else {
						unitStr +=HeavenlyStem.heavenlyStem[unit];
					}
					param.setBuildUnit(unitStr);
					this.judgeRoofUnitNameRepeat(param.getCityId(), param.getCompId(), param.getBuildId(),
							param.getBuildRoof(),  param.getBuildUnit(), null);
					// 单元的楼层排号，每一栋的起始号等于加之前的房间数
					if (param.getAddedByAllUnits() != null && param.getAddedByAllUnits() == 1) {
						if (param.getNumberRule() == 2) {
							// 按户号，楼层*一层的房间数
							roomStart += StringUtil.parseInteger(param.getBuildDoors()) * StringUtil.parseInteger(param.getBuildFloors());
						} else {
							roomStart += StringUtil.parseInteger(param.getBuildDoors());
						}
					}
					erpBuildingSetMapper.insertSelective(param);
					erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
							param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "新增规则日志03");
				}
			}
		}
		this.createBuildRoofunitdoors(param);
	}
	
	/**
	 * 判断单元是否重复，重复时抛异常
	 * @author 张宏利
	 * @since 2017年9月4日
	 * @param cityId
	 * @param compId
	 */
	private void judgeRoofUnitNameRepeat(Integer cityId, Integer compId, Integer buildId, String buildRoof, String unit, Integer bsId) {
		Integer repeatCount = erpBuildingSetMapper.getRoofUnitNameRepeatCount(cityId, compId, buildId, buildRoof, unit, bsId);
		if (repeatCount != null && repeatCount > 0) {
			String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
			if ("2".equals(paramVal)) {
				throw new BusinessException("号位与已有号位重复，请重新填写");
			} else if(StringUtils.isNotBlank(unit)){
				throw new BusinessException("单元名称与已有单元名称重复，请重新填写");
			} else {
				throw new BusinessException("栋座名称与已有栋座名称重复，请重新填写");
			}
		}
	}
	
	/**
	 * 删除栋座
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座 
	 * @return
	 */
	@Transactional
	@Override
	public void delBuildRoofById(ErpBuildingSetParam param) {
		erpBuildingSetMapper.delBuildRoofById(param);
		erpBuildingSetRoomMapper.delBuildRoofById(param);
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "删除栋座");
		this.createBuildRoofunitdoors(param);
	}

	/**
	 * 删除单元
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元
	 * @return
	 */
	@Transactional
	@Override
	public void delBuildUnitById(ErpBuildingSetParam param) {
		erpBuildingSetMapper.delBuildUnitById(param);
		erpBuildingSetRoomMapper.delBuildUnitById(param);
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "删除单元");
		this.createBuildRoofunitdoors(param);
	}

	@Override
	public void createBuildRoofunitdoors(ErpBuildingSetParam param) {
		// 查询栋座、单元、房间数信息
		List<Map<String, Object>> doorCountList = erpBuildingSetMapper.getRoofDoorCount(param.getCityId(), param.getCompId(), param.getBuildId());
		int doorCount = doorCountList.stream().mapToInt(map -> StringUtil.parseInteger(map.get("doorCount"))).sum();
		int unitCount = doorCountList.stream().mapToInt(map -> StringUtil.parseInteger(map.get("unitCount"))).sum();
		Map<String, Object> doors = erpBuildingSetRoomMapper.getDoorAllCount(param.getCityId(), param.getCompId(), param.getBuildId());
		if(doors != null) {
			int delCount = StringUtil.parseInteger(doors.get("delCount"));
			int outCount = StringUtil.parseInteger(doors.get("outCount"));
			doorCount = doorCount - delCount + outCount;// 总房间数=规则房间数-规则内的被删除的+规则外的没删除的
		}
		ErpFunBuildRoofunitdoors insertRecord = new ErpFunBuildRoofunitdoors();
		insertRecord.setShardCityId(param.getCityId());
		insertRecord.setCityId(param.getCityId());
		insertRecord.setCompId(param.getCompId());
		insertRecord.setAreaId(param.getAreaId());
		insertRecord.setRegId(param.getRegId());
		insertRecord.setDeptId(param.getDeptId());
		insertRecord.setBuildId(param.getBuildId());
		insertRecord.setRoofs(doorCountList.size());
		insertRecord.setDoors(doorCount);
		insertRecord.setUnits(unitCount);
		// 修改之前的单元栋数信息
		int upCount = erpFunBuildRoofunitdoorsMapper.updateByBuildId(insertRecord);
		if(upCount <= 0) {// 新增新的的单元栋数信息
			erpFunBuildRoofunitdoorsMapper.insertSelective(insertRecord);
		}
	}

	@Transactional
	@Override
	public void updateBuildRule(ErpBuildingSetParam param) {
		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectByPrimaryKey(param);
		if(erpBuildingSet == null) {
			return;
		}
		param.setBuildId(erpBuildingSet.getBuildId());
		this.judgeRoofUnitNameRepeat(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), erpBuildingSet.getBsId());
		// 修改之前的户数大于修改之后的户数，生成被删除的房间
		Integer newDoors = StringUtil.parseInteger(param.getBuildDoors());
		Integer oldDoors = StringUtil.parseInteger(erpBuildingSet.getBuildDoors());
		if(oldDoors > newDoors) {
			// 1-1,1-2,1-3
			// 2-1,2-2,2-3，从3室改到2室，要把1-3,2-3找出来
			Byte numberRule = erpBuildingSet.getNumberRule();
			Byte compriseRule = erpBuildingSet.getCompriseRule();
			Byte numberType = erpBuildingSet.getNumberType();
			int roomTemp = 0;
			int doorStart = 1;
			// 这两个不能为空
			compriseRule = (compriseRule == null) ? 0 : compriseRule;
			numberType = (numberType == null) ? 0 : numberType;
			if (erpBuildingSet.getDoorStart() != null) {
				doorStart = erpBuildingSet.getDoorStart();
			}
			List<String> sysRoomIdList = new LinkedList<>();
			List<String> userRoomIdList = new LinkedList<>();
			List<Integer> userFloorList = new LinkedList<>();
			for (int floor = erpBuildingSet.getFloorStart(); floor <= erpBuildingSet.getFloorEnd(); floor++) {
				for (int door = newDoors; door < oldDoors; door++) {
					String doorNum = erpBuildingSetRoomService.createBuildRuleNumber(floor, door, numberRule,
							compriseRule, numberType, doorStart, roomTemp);
					roomTemp++;// 必须要自增一个
					userFloorList.add(floor);
					userRoomIdList.add(doorNum);
					sysRoomIdList.add(floor + "-" + (door + 1));
				}
			}
			// 把已有的找出来排除掉
			List<String> allSysIdList = erpBuildingSetRoomMapper.getContainSysIdList(param.getCityId(),
					param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), sysRoomIdList);
			List<ErpBuildingSetRoom> roomList = new LinkedList<>();
			for (int i = 0; i < sysRoomIdList.size(); i++) {
				String sysRoomId = sysRoomIdList.get(i);
				// 数据库里面有了则跳过
				if (allSysIdList.contains(sysRoomId)) {
					continue;
				}
				ErpBuildingSetRoom buildingSetRoom = new ErpBuildingSetRoom();
				buildingSetRoom.setSysRoomId(sysRoomId);
				buildingSetRoom.setCityId(param.getCityId());
				buildingSetRoom.setCompId(param.getCompId());
				buildingSetRoom.setCreationTime(new Date());
				buildingSetRoom.setUpdateTime(new Date());
				buildingSetRoom.setBuildId(param.getBuildId());
				buildingSetRoom.setBuildRoof(param.getBuildRoof());
				buildingSetRoom.setBuildUnit(param.getBuildUnit());
				buildingSetRoom.setRoomId(userRoomIdList.get(i));
				buildingSetRoom.setRoomFloor(userFloorList.get(i) == null ? "0" : userFloorList.get(i).toString());
				buildingSetRoom.setDelFlag((byte) 0);
				roomList.add(buildingSetRoom);
				if(roomList.size() == 180){
					erpBuildingSetRoomMapper.insertList(param.getCityId(), roomList);
					roomList.clear();
				}
			}
			if (!roomList.isEmpty()) {
				erpBuildingSetRoomMapper.insertList(param.getCityId(), roomList);
			}
		}
		erpBuildingSetMapper.updateByPrimaryKeySelective(param);
		// 把房间上的单元信息修改成最新的
		param.setOldBuildUnit(erpBuildingSet.getBuildUnit());
		erpBuildingSetRoomMapper.updateRoomUnit(param);
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "修改栋座规则");
		this.createBuildRoofunitdoors(param);
	}
	
	@Transactional
	@Override
	public void updateBuildRoof(ErpBuildingSetParam param) {
		Integer repeatCount = erpBuildingSetMapper.getRoofUnitNameRepeatCount(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), null, null);
		if(repeatCount != null && repeatCount > 0) {
			throw new BusinessException("栋座名与已有栋座重复，请重新填写");
		}
		erpBuildingSetMapper.updateRoofByOldRoof(param);
		erpBuildingSetRoomMapper.updateRoofByOldRoof(param);
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "修改栋名称");
	}

//	@Override
//	public void copyTempBuildRule(Integer cityId, Integer buildId, Integer compId, String compNo, Integer userId) {
//		// 删除公司之前的规则
//		erpBuildingSetMapper.deleteCompBuildingSet(cityId, buildId, compId);
//		// 拷贝模板
//		erpBuildingSetMapper.createTempBuildingSet(cityId, 0, buildId, compId, compNo);
//		// 写日志
//		erpBuildingSetLogMapper.insertLog(cityId, userId, compId, buildId, null, null, "模板拷贝到公司");
//		ErpBuildingSetParam param=new ErpBuildingSetParam();
//		param.setCityId(cityId);
//		param.setBuildId(buildId);
//		param.setCompId(compId);
//		param.setCompNo(compNo);
//		param.setSelfUserId(userId);
//		this.createBuildRoofunitdoors(param);
//
//	}

	/**
	 * 清空楼盘规则
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/7
	 */
	@Transactional
	@Override
	public void delBuildById(ErpBuildingSetParam param) {
		erpBuildingSetMapper.delBuildById(param);
		erpBuildingSetRoomMapper.delBuildById(param);
		erpBuildingSetFloorMapper.delBuildById(param);
		erpBuildingSetSettingMapper.delBuildById(param);
		erpFunBuildRoofunitdoorsMapper.deleteByBuildId(param.getCityId(),param.getCompId(),param.getBuildId());
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "清除规则");
//		this.createBuildRoofunitdoors(param);
	}

	@Transactional
    @Override
    public void copyTempBuildRule(CopyTempParam param, Integer cityId, Integer compId, Integer userId, String copyToCompNo, Integer provenceId) {
        Integer buildId = param.getBuildId();

        // 将该公司该楼盘所有栋规则删除
        ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
        roofExample.setShardCityId(cityId);
        roofExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
        erpBuildingSetRoofMapper.deleteByExample(roofExample);

        // 将该公司该楼盘所有单元规则删除
        ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
        erpBuildingSetUnitMapper.deleteByExample(unitExample);

        // 将该公司该楼盘所有楼层规则删除
        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
        erpBuildingSetFloorMapper.deleteByExample(floorExample);

        // 将该公司该楼盘所有房间规则删除
        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
        erpBuildingSetRoomMapper.deleteByExample(roomExample);

        // 查看是否有模板
        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(cityId, compId, param.getBuildId());
        if(info == null || null == info.getTemplateCompId()) {
			return;
		}

        roofExample.clear();
        roofExample.setShardCityId(cityId);
        roofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        // 查看楼盘是否有栋模板
        int roofCount = erpBuildingSetRoofMapper.countByExample(roofExample);

        unitExample.clear();
        unitExample.setShardCityId(cityId);
        unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(param.getBuildId());
        // 查看楼盘是否有单元模板
        int unitCount = erpBuildingSetUnitMapper.countByExample(unitExample);

        // 是不是号位 true 是, false 不是
        // 栋模板数量等于0,单元模板数量大于0即为号位
        boolean number = roofCount == 0 && unitCount > 0;

        // 拷贝栋,单元,楼层,房间的规则(栋包含的单元数,户数以及单元里面包含的户数这些数据,是会一起拷贝过去的)
        erpBuildingSetRoofMapper.copyTempBuildRule(cityId, info.getTemplateCompId(), buildId, compId, copyToCompNo, provenceId);

        if (number) {
            // 更新单元,楼层,房间里面的各种关联ID (号位修改)
            erpBuildingSetRoofMapper.updateIdAfterCopyTempBuildRuleByNumber(cityId, info.getTemplateCompId(), buildId, compId, copyToCompNo, provenceId);
        } else {
            // 更新单元,楼层,房间里面的各种关联ID (正常楼栋)
            erpBuildingSetRoofMapper.updateIdAfterCopyTempBuildRule(cityId, info.getTemplateCompId(), buildId, compId, copyToCompNo, provenceId);
        }

		ErpFunBuildRoofunitdoorsExample roofUnitDoorsExample = new ErpFunBuildRoofunitdoorsExample();
		roofUnitDoorsExample.setShardCityId(cityId);
		roofUnitDoorsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
		int roofUnitDoorsCount = erpFunBuildRoofunitdoorsMapper.countByExample(roofUnitDoorsExample);

		if (roofUnitDoorsCount == 0) {
			// 将模板公司对应的该楼盘的房间数量更新上去
			roomExample.clear();
			roomExample.setShardCityId(cityId);
			roomExample.createCriteria().andCompIdEqualTo(info.getTemplateCompId()).andBuildIdEqualTo(buildId);
			int roomCount = erpBuildingSetRoomMapper.countByExample(roomExample);

			ErpFunBuildRoofunitdoors record = new ErpFunBuildRoofunitdoors();
			record.setShardCityId(cityId);
			record.setBuildId(param.getBuildId());
			record.setCityId(cityId);
			record.setCompId(compId);
			record.setRoofs(roofCount);
			record.setUnits(unitCount);
			record.setDoors(roomCount);
			erpFunBuildRoofunitdoorsMapper.insertSelective(record);
		} else {
			// 修改 FUN_BUILD_ROOFUNITDOORS 表户数
			erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());
		}

		// 修改 FUN_BUILD_ROOFUNITDOORS 表户数
//		erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());

        erpBuildingSetLogMapper.insertLog(cityId, userId, compId, buildId, null, null, "模板拷贝到公司");
    }

}



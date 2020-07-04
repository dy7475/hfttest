package com.myfun.service.business.erpdb.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.github.pagehelper.PageHelper;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminHouseLayoutSyncMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminHouseLayoutSync;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.BuildingSetRoomParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetRoomParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpBuildingSetRoofService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetFloorParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomService;
import com.myfun.service.business.erpdb.ErpBuildingSetService;

@Service
public class ErpBuildingSetRoomServiceImpl extends AbstractService<ErpBuildingSetRoom,ErpBuildingSetRoom> implements ErpBuildingSetRoomService {
	@Autowired
	private ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
	@Autowired
	private ErpBuildingSetService erpBuildingSetService;
	@Autowired
	private ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
	@Autowired
	private ErpBuildingSetMapper erpBuildingSetMapper;
	@Autowired
	private ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private ErpSysParaService erpSysParaService;
	@Autowired
	private ErpBuildingSetLogMapper erpBuildingSetLogMapper;
	@Resource
	private ErpBuildingSetRoomLayoutMapper erpBuildingSetRoomLayoutMapper;
	@Resource
	private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
	@Resource
	private ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
	@Resource
	private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
	@Autowired
	private AdminHouseLayoutSyncMapper adminHouseLayoutSyncMapper;
	@Autowired
	private ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;
	@Resource
	private ErpFunSaleMapper erpFunSaleMapper;
	@Resource
	private ErpFunLeaseMapper erpFunLeaseMapper;
    @Resource
    private ErpFunCoreInfoMapper erpFunCoreInfoMapper;
	@Resource
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Resource
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunVideoMapper erpFunVideoMapper;
	@Autowired
	private ErpBuildRuleBatchTempMapper erpBuildRuleBatchTempMapper;
	@Autowired
	private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	private ErpBuildingSetRoofService erpBuildingSetRoofService;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Resource
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBuildingSetRoomMapper;
	}

/*	@Override
	public void cancelMergeRoomInfo(ErpBuildingSetRoomParam param) {
		erpBuildingSetRoomMapper.cancelMergeRoomInfo(param);
		erpBuildingSetRoomMapper.cancelMergeReduceMergeRoom(param);
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "取消合并" + param.getMergeRoom());
	}*/

	@Transactional
	@Override
	public void cancelMergeRoomInfo(CancelMergeRoomInfoParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer buildId = param.getBuildId();
		Integer count = erpBuildingSetRoomMapper.getCountByMerRoom(cityId,compId,buildId,param.getBuildingSetUnitId(),param.getMergeRoom());
		erpBuildingSetRoomMapper.cancelMergeRoomInfo(param.getCityId(),param);
		erpBuildingSetRoomMapper.cancelMergeReduceMergeRoom(param.getCityId(),param);
		// 更新栋单元表户数信息
		erpFunBuildRoofunitdoorsMapper.addRoomCountInBuildRoofUnitDoors(cityId,compId,buildId,count-1, null, null);
		if (param.getBuildingSetRoofId() != null) {
			erpBuildingSetRoofMapper.addRoomCountInRoof(cityId,compId,buildId,param.getBuildingSetRoofId(),count-1);
		}
		erpBuildingSetUnitMapper.addRoomCountInUnit(cityId,compId,buildId,param.getBuildingSetUnitId(),count-1);

		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getUserId(), param.getCompId(),
				param.getBuildId(),param.getBuildingSetRoofId() == null ? "" : param.getBuildingSetRoofId().toString(),
				param.getBuildingSetUnitId().toString(), "取消合并" + param.getMergeRoom());
	}


/*
	@Override
	public void mergeRoomInfo(BaseMapParam param) {
		ErpBuildingSetRoomParam roomParam = BeanUtil.populate(param.getMap(), ErpBuildingSetRoomParam.class);
		String[] roomIds = roomParam.getRoomIds().split(",");
		String[] sysRoomIds = roomParam.getSysRoomIds().split(",");
		String[] roomFloors = roomParam.getRoomFloors().split(",");
		Integer mergeRoom = erpBuildingSetRoomMapper.getUnitMergeRoom(roomParam);
		for (int i = 0; i < sysRoomIds.length; i++) {
			roomParam.setRoomId(roomIds[i]);
			roomParam.setUpdateTime(new Date());
			roomParam.setSysRoomId(sysRoomIds[i]);
			roomParam.setRoomFloor(StringUtil.parseInteger(roomFloors[i], 0));
			ErpBuildingSetRoom userNumRoom = erpBuildingSetRoomMapper.selectByUserRoomId(roomParam);
			if(userNumRoom != null && userNumRoom.getDelFlag() != 1
					&& !userNumRoom.getSysRoomId().equals(roomParam.getSysRoomId())) {
				throw new ConfirmException("该房号与已有房号重复，请重试");
			}
			ErpBuildingSetRoom erpBuildingSetRoom = userNumRoom;
			if(erpBuildingSetRoom == null) {// 通过房号查询不到再通过系统房号查询，必须查，有可能房间号改了，但系统房号是不变的
				erpBuildingSetRoom = erpBuildingSetRoomMapper.selectBySysRoomId(roomParam);
			}
			roomParam.setMergeRoom(mergeRoom);
			// 存在时修改，不存在时插入
			if(erpBuildingSetRoom != null) {
				roomParam.setId(erpBuildingSetRoom.getId());
				roomParam.setDelFlag((byte) 0);
				roomParam.setUpdateTime(new Date());
				roomParam.setShardCityId(erpBuildingSetRoom.getCityId());
				erpBuildingSetRoomMapper.updateByPrimaryKeySelective(roomParam);
			} else {
				roomParam.setCreationTime(new Date());
				erpBuildingSetRoomMapper.insertSelective(roomParam);
			}
		}
		erpBuildingSetLogMapper.insertLog(roomParam.getCityId(), param.getInteger("selfUserId"), roomParam.getCompId(),
				roomParam.getBuildId(), roomParam.getBuildRoof(), roomParam.getBuildUnit(),
				"合并房间" + roomParam.getSysRoomIds());
		ErpBuildingSetParam setParam = BeanUtil.populate(param.getMap(), ErpBuildingSetParam.class);
		erpBuildingSetService.createBuildRoofunitdoors(setParam);
	}
*/

	/**
	 * 合并房间
	 * @author wangchun
	 * @param param RoomIdsParam
	 */
	@Transactional
	@Override
	public void  mergeRoomInfo(RoomIdsParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer buildId = param.getBuildId();
		String ids = new String();
		if (StringUtils.isNotBlank(param.getBuildingSetRoomIds())) {
			ids = "("+param.getBuildingSetRoomIds()+")";
		}
		List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getAimRooms(cityId,0,ids,param.getBuildingSetRoofId(),param.getBuildingSetUnitId());
		if (rooms == null || rooms.isEmpty()) {
			throw new ConfirmException("所选房间不存在！");
		}
		for (ErpBuildingSetRoom r : rooms){
			if (r.getDelFlag() == 1) {
				throw new ConfirmException("房间已经被删除，请重试");
			}
			if (r.getMergeRoom() != null) {
				throw new ConfirmException("房间已经处于合并状态，请重试");
			}
		}
		Integer mergeRoom = erpBuildingSetRoomMapper.getMergeRoom(cityId,param);
		erpBuildingSetRoomMapper.updateMergeRomms(cityId,0,ids,mergeRoom);

		// 更新栋单元表户数信息
		int count = ids.split(",").length - 1;
		erpFunBuildRoofunitdoorsMapper.delRoomCountInBuildRoofUnitDoors(cityId,0,buildId,count);
		if (param.getBuildingSetRoofId() != null) {
			erpBuildingSetRoofMapper.delRoomCountInRoof(cityId,0,buildId,param.getBuildingSetRoofId(),count);
		}
		erpBuildingSetUnitMapper.delRoomCountInUnit(cityId,0,buildId,param.getBuildingSetUnitId(),count);

		erpBuildingSetLogMapper.insertLog(cityId, param.getSelfUserId(), 0,
				param.getBuildId(), param.getBuildingSetRoofId() == null ? "" : param.getBuildingSetRoofId().toString(),
				param.getBuildingSetUnitId().toString(),"合并房间" + param.getBuildingSetRoomIds());

	}
	
	@Transactional
	@Override
	public void updateOrCreateRoom(BaseMapParam param) {
		Integer cityId = param.getInteger("cityId");

		ErpBuildingSetRoomParam roomParam = BeanUtil.populate(param.getMap(), ErpBuildingSetRoomParam.class);
		roomParam.setUpdateTime(new Date());
		roomParam.setShardCityId(cityId);

		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectByBuildUnit(cityId, roomParam.getCompId(),
				roomParam.getBuildId(), roomParam.getBuildRoof(), roomParam.getBuildUnit());
		Map<String, String> houseNumsByRule = new HashMap<>();
		if (erpBuildingSet != null) {
			houseNumsByRule = this.getHouseNumsByRule(cityId, roomParam.getCompId(), roomParam.getBuildId(),
					roomParam.getBuildRoof(), roomParam.getBuildUnit(), Integer.valueOf(roomParam.getRoomFloor()), erpBuildingSet);
		}
		ErpBuildingSetRoom userNumRoom = erpBuildingSetRoomMapper.selectByUserRoomId(roomParam);
		if(houseNumsByRule.containsValue(roomParam.getRoomId())) {
			String roomIdTemp = houseNumsByRule.get(roomParam.getSysRoomId());
			if((userNumRoom != null && userNumRoom.getDelFlag() == 0 && !userNumRoom.getSysRoomId().equals(roomParam.getSysRoomId()))
				|| (userNumRoom == null && !roomParam.getRoomId().equals(roomIdTemp))) {
				throw new ConfirmException("该房号与已有房号重复，请重新录入");
			}
		}
		ErpBuildingSetRoom erpBuildingSetRoom = userNumRoom;
		if (erpBuildingSetRoom == null) {// 通过房号查询不到再通过系统房号查询，必须查，有可能房间号改了，但系统房号是不变的
			erpBuildingSetRoom = erpBuildingSetRoomMapper.selectBySysRoomId(roomParam);
		}
		// 存在时修改，不存在时插入
		if (erpBuildingSetRoom != null) {
			erpBuildingSetRoom.setShardCityId(erpBuildingSetRoom.getCityId());
//			erpBuildingSetRoom.setDelFlag((byte) 0);
			erpBuildingSetRoom.setUpdateTime(new Date());
			erpBuildingSetRoom.setRoomId(roomParam.getRoomId());// 房号
			erpBuildingSetRoom.setHouseRoom(roomParam.getHouseRoom());// 室
			erpBuildingSetRoom.setHouseHall(roomParam.getHouseHall());// 厅
			erpBuildingSetRoom.setHouseWei(roomParam.getHouseWei());// 卫
			erpBuildingSetRoom.setHouseYang(roomParam.getHouseYang());// 阳
			erpBuildingSetRoom.setHouseArea(roomParam.getHouseArea());// 建筑面积
			erpBuildingSetRoom.setHouseInnerarea(roomParam.getHouseInnerarea());// 套内面积
			erpBuildingSetRoom.setHouseDirect(roomParam.getHouseDirect());// 朝向
			erpBuildingSetRoomMapper.updateByPrimaryKey(erpBuildingSetRoom);
		} else {
			roomParam.setCreationTime(new Date());
			erpBuildingSetRoomMapper.insertSelective(roomParam);
		}
		ErpBuildingSetParam setParam = BeanUtil.populate(param.getMap(), ErpBuildingSetParam.class);
		setParam.setCityId(param.getInteger("cityId"));
		setParam.setShardCityId(param.getInteger("cityId"));
		erpBuildingSetService.createBuildRoofunitdoors(setParam);
		erpBuildingSetLogMapper.insertLog(roomParam.getCityId(), param.getInteger("selfUserId"), roomParam.getCompId(),
				roomParam.getBuildId(), roomParam.getBuildRoof(), roomParam.getBuildUnit(),
				"修改或新增房间" + roomParam.getSysRoomId());

	}


	/**
	 * 编辑房间
	 * @author wangchun
	 * @param param
	 */
	@Transactional
	@Override
	public void updateRoomInfo(UpdateRoomInfoParam param,String addrMd5,Integer cityId,Integer compId,String oldMd5) {

        erpBuildingSetRoomMapper.updateRoomInfo(cityId,0,param,addrMd5);

		if (addrMd5 != null) {
			List<BatchUpdateRoomMd5> BatchUpdateRoomMd5s= new ArrayList<>();
			BatchUpdateRoomMd5 roomMd5 = new BatchUpdateRoomMd5();
			roomMd5.setAddMd5(addrMd5);
			roomMd5.setOldAddMd5(oldMd5);
			roomMd5.setRoomId(param.getRoomId());
			BatchUpdateRoomMd5s.add(roomMd5);
			erpBuildingMarketingControlMapper.batchUpdateRoomMd5(cityId,compId,param.getBuildId(),BatchUpdateRoomMd5s);
		}

        List<Integer> buildingSetRoomIds = new ArrayList<>();
        buildingSetRoomIds.add(param.getBuildingSetRoomId());

        List<Integer> ids = new ArrayList<>();

        if (StringUtils.isNotBlank(param.getBuildingSetRoomIds())) {
            String[] roomIds = param.getBuildingSetRoomIds().split(",");
            ids = Arrays.stream(roomIds).map(Integer::valueOf).collect(Collectors.toList());
        }
        buildingSetRoomIds.addAll(ids);

        erpBuildingSetRoomLayoutMapper.updateLayoutFlag(cityId, 0, buildingSetRoomIds);

		List<ErpBuildingSetRoomLayout> layouts = new ArrayList<>();
		if (param.getPhotoUrls() != null) {
            if (!"".equals(param.getPhotoUrls())) {
                String[] urls = param.getPhotoUrls().split(",");
                for (String url : urls){
					ErpBuildingSetRoomLayout layout = new ErpBuildingSetRoomLayout();
					layout.setBuildId(param.getBuildId());
					layout.setBuildingSetRoomId(param.getBuildingSetRoomId());
					layout.setCityId(cityId);
					layout.setCompId(0);
					layout.setCreatedTime(new Date());
					layout.setUpdatedTime(new Date());
//					layout.setDelFlag((byte)0);
                    layout.setLayoutUrl(url);
                    layouts.add(layout);
                }
                erpBuildingSetRoomLayoutMapper.insertLayoutUrl(cityId,layouts);
            }
		}

        layouts.clear();
        // 户型图应用到本栋本单元同房号
        if (param.getSync() != null && param.getSync() == 1 && CollectionUtils.isNotEmpty(ids)) {
            erpBuildingSetRoomMapper.syncRoomInfo(cityId,0,param,ids);
			if (param.getPhotoUrls() != null) {
            	// 批量添加户型图
            	for (Integer needAddLayoutRoomId : ids) {
                    String[] urls = param.getPhotoUrls().split(",");
                    for (String url : urls){
                        ErpBuildingSetRoomLayout layout = new ErpBuildingSetRoomLayout();
                        layout.setCreatedTime(new Date());
                        layout.setUpdatedTime(new Date());
                        layout.setBuildingSetRoomId(needAddLayoutRoomId);
//                        layout.setDelFlag((byte) 0);
                        layout.setLayoutUrl(url);
                        layout.setCompId(compId);
                        layout.setCityId(cityId);
                        layout.setBuildId(param.getBuildId());
                        layouts.add(layout);
                    }
                }
				erpBuildingSetRoomLayoutMapper.insertLayoutUrl(cityId,layouts);
            }
        }

		erpBuildingSetLogMapper.insertLog(cityId, param.getSelfUserId(), 0,
				param.getBuildId(), param.getBuildingSetRoofId()==null?"":param.getBuildingSetRoofId().toString(),
                param.getBuildingSetUnitId().toString(),"修改了房间" + param.getBuildingSetRoomId());
	}

    /**
     * 替换已登记房户型图
     * @author wangchun
     * @param param
     */
	@Transactional
    @Override
    public void insertHouseLayoutSync(UpdateRoomInfoParam param,String addrMd5,Integer cityId,Integer compId) {

		AdminHouseLayoutSync layout = new AdminHouseLayoutSync();
		layout.setCityId(cityId);
		layout.setCompId(compId);
		layout.setRoomId(param.getBuildingSetRoomId());
		layout.setAddrMd5(addrMd5);
		layout.setIsSync((byte)0);
		layout.setUserId(param.getSelfUserId());
		layout.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		adminHouseLayoutSyncMapper.insertSelective(layout);
		if (param.getSync() != null && StringUtil.isNotEmpty(param.getBuildingSetRoomIds())) {
			String[] roomIds = param.getBuildingSetRoomIds().split(",");
			List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListById(cityId,compId,"("+param.getBuildingSetRoomIds().trim()+")");
			Map<Integer,ErpBuildingSetRoom> roomsMap = rooms.stream().collect(Collectors.toMap(ErpBuildingSetRoom::getId,val -> val));
			for (String id : roomIds){
				Integer roomId = Integer.valueOf(id);
                if (roomsMap.get(roomId) != null) {
                    layout.setAddrMd5(roomsMap.get(roomId).getAddrMd5());
					layout.setRoomId(roomId);
					adminHouseLayoutSyncMapper.insertSelective(layout);
                }
			}
		}
    }

    /**
	 * 删除房间
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元  sysRoomId前端计算出的房间号
	 * @return
	 */
	@Transactional
	@Override
	public void delBuildRoomById(BaseMapParam param) {
		ErpBuildingSetRoomParam roomParam = BeanUtil.populate(param.getMap(), ErpBuildingSetRoomParam.class);
		String sysRoomIds = roomParam.getSysRoomIds();
		if(StringUtils.isBlank(sysRoomIds)) {
			return;
		}
		String[] sysRoomIdArr = sysRoomIds.split(",");
		String[] roomFloorsArr = roomParam.getRoomFloors().split(",");
		String[] roomIds = roomParam.getRoomIds().split(",");
		for (int i = 0; i < sysRoomIdArr.length; i++) {
			roomParam.setRoomId(roomIds[i]);
			roomParam.setSysRoomId(sysRoomIdArr[i]);
			roomParam.setRoomFloor(roomFloorsArr[i]);
			ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.selectBySysRoomId(roomParam);
			if (erpBuildingSetRoom != null) {
				Byte beyondRule = erpBuildingSetRoom.getBeyondRule();
				erpBuildingSetRoom.setShardCityId(roomParam.getCityId());
				if (beyondRule == (byte)1) {//是否是规则以外的房间，1=是
					erpBuildingSetRoomMapper.deleteByPrimaryKey(erpBuildingSetRoom);//物理删除
				} else {
					erpBuildingSetRoom.setDelFlag((byte)1);
					erpBuildingSetRoomMapper.updateByPrimaryKeySelective(erpBuildingSetRoom);//逻辑删除
				}
			} else {
				roomParam.setCreationTime(new Date());
				roomParam.setUpdateTime(new Date());
				roomParam.setDelFlag((byte)1);
				erpBuildingSetRoomMapper.insertSelective(roomParam);//逻辑删除
			}
		}
		// 用于统计
		ErpBuildingSetParam setParam = BeanUtil.populate(param.getMap(), ErpBuildingSetParam.class);
		erpBuildingSetService.createBuildRoofunitdoors(setParam);
		erpBuildingSetLogMapper.insertLog(roomParam.getCityId(), param.getInteger("selfUserId"), roomParam.getCompId(),
				roomParam.getBuildId(), roomParam.getBuildRoof(), roomParam.getBuildUnit(), "删除房间" + sysRoomIds);
	}

	@Transactional
	@Override
	public void updateRoomInfoToLine(Integer cityId, ErpBuildingSetRoomParam param, String[] sysRoomIdsArr) {
		String[] roomIdsarr = param.getRoomIds().split(",");
		String[] roomFloorsarr = param.getRoomFloors().split(",");
		List<ErpBuildingSetRoom> erpBuildingSetRoomParamList = erpBuildingSetRoomMapper.getRoomInfoListBySysRoomIds(cityId,param,sysRoomIdsArr);
		Map<String, ErpBuildingSetRoom> erpBuildingSetRoomMap = new HashMap<>();
		if(!erpBuildingSetRoomParamList.isEmpty()){
			erpBuildingSetRoomMap = erpBuildingSetRoomParamList.stream().collect(Collectors.toMap(ErpBuildingSetRoom::getSysRoomId, val -> val));
		}
		for (int i = 0; i < sysRoomIdsArr.length; i++) {
			param.setId(null);// 初始化成空
			param.setSysRoomId(sysRoomIdsArr[i]);
			param.setRoomId(roomIdsarr[i]);
			param.setRoomFloor(roomFloorsarr[i]);
			ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMap.get(sysRoomIdsArr[i]);
			if(erpBuildingSetRoom != null){
				param.setId(erpBuildingSetRoom.getId());
				erpBuildingSetRoomMapper.updateByPrimaryKeySelective(param);
			}else{
				erpBuildingSetRoomMapper.insertSelective(param);
			}
		}
		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "拷贝规则到整行" + param.getRoomIds());
	}

//	@Override
//	public void updateBuildFloor(ErpBuildingSetFloorParam param) {
//		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectByBuildUnit(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getBuildUnit());
//		if(erpBuildingSet == null) {
//			return;
//		}
//		Integer floorId = null;
//		String sysBuildFloor = param.getSysBuildFloor();
//		param.setSysBuildFloor(null);// 查询此单元所有设置的楼层
//		List<ErpBuildingSetFloor> buildingSetFloorList = erpBuildingSetFloorMapper.selectByBuildFloor(param);
//		if(buildingSetFloorList != null && buildingSetFloorList.size() > 0) {
//			Map<String, ErpBuildingSetFloor> floorMap = buildingSetFloorList.stream().collect(Collectors.toMap(ErpBuildingSetFloor::getBuildFloor, val -> val));
//			Map<String, ErpBuildingSetFloor> sysFloorMap = buildingSetFloorList.stream().collect(Collectors.toMap(ErpBuildingSetFloor::getSysBuildFloor, val -> val));
//			ErpBuildingSetFloor buildingSetFloor = floorMap.get(param.getBuildFloor());
//			// 之前有录入过这个楼层名
//			if(buildingSetFloor != null) {
//				// 而且和编辑的是同一个则表示没有修改
//				if(buildingSetFloor.getSysBuildFloor().equals(sysBuildFloor)) {
//					return;
//				}
//				throw new ConfirmException("楼层名重复，请修改后重新保存！");
//			} else {
//				for (int floor = erpBuildingSet.getFloorStart(); floor <= erpBuildingSet.getFloorEnd(); floor++) {
//					String floorStr = String.valueOf(floor);
//					if(floorStr.equals(param.getBuildFloor())) {
//						if(sysFloorMap.containsKey(floorStr)) {// 已经被配置成其他的了，可以配置成这个
//							break;
//						}
//						if(floorStr.equals(sysBuildFloor)) {// 当前楼层和真实楼层一致则可以修改
//							break;
//						}
//						throw new ConfirmException("楼层名重复，请修改后重新保存！");
//					}
//				}
//			}
//			ErpBuildingSetFloor erpBuildingSetFloor = sysFloorMap.get(sysBuildFloor);
//			if(erpBuildingSetFloor != null) {
//				floorId = erpBuildingSetFloor.getId();
//			}
//		} else {
//			for (int floor = erpBuildingSet.getFloorStart(); floor <= erpBuildingSet.getFloorEnd(); floor++) {
//				String floorStr = String.valueOf(floor);
//				if(floorStr.equals(param.getBuildFloor())) {
//					if(floorStr.equals(sysBuildFloor)) {// 当前楼层和真实楼层一致则可以修改
//						break;
//					}
//					throw new ConfirmException("楼层名重复，请修改后重新保存！");
//				}
//			}
//		}
//		param.setSysBuildFloor(sysBuildFloor);// 设置回来
//		if(floorId == null) {
//			param.setCreationTime(new Date());
//			erpBuildingSetFloorMapper.insertSelective(param);
//		} else {
//			param.setId(floorId);
//			param.setUpdateTime(new Date());
//			erpBuildingSetFloorMapper.updateByPrimaryKeySelective(param);
//		}
//		erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
//				param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "修改楼层名" + sysBuildFloor);
//	}

    /**
     * 修改楼层信息
     *
     * @author czq
     * @since 2017年12月12日
     * @param param ErpBuildingSetFloorParam
     */
	@Transactional
    @Override
    public void updateBuildFloor(ErpBuildingSetFloorParam param) {
        ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectByBuildUnit(param.getCityId(), param.getCompId(), param.getBuildId(), param.getBuildRoof(), param.getBuildUnit());
        if(erpBuildingSet == null) {
            return;
        }
        Integer floorId = null;
        String sysBuildFloor = param.getSysBuildFloor();
        param.setSysBuildFloor(null);
        // 查询此单元所有设置的楼层
        List<ErpBuildingSetFloor> buildingSetFloorList = erpBuildingSetFloorMapper.selectByBuildFloor(param);
        if(buildingSetFloorList != null && buildingSetFloorList.size() > 0) {
            Map<String, ErpBuildingSetFloor> floorMap = buildingSetFloorList.stream().collect(Collectors.toMap(ErpBuildingSetFloor::getBuildFloor, val -> val));
            Map<String, ErpBuildingSetFloor> sysFloorMap = buildingSetFloorList.stream().collect(Collectors.toMap(ErpBuildingSetFloor::getSysBuildFloor, val -> val));
            ErpBuildingSetFloor buildingSetFloor = floorMap.get(param.getBuildFloor());
            // 之前有录入过这个楼层名
            if(buildingSetFloor != null) {
                // 而且和编辑的是同一个则表示没有修改
                if(buildingSetFloor.getSysBuildFloor().equals(sysBuildFloor)) {
                    return;
                }
                throw new ConfirmException("楼层名重复，请修改后重新保存！");
            } else {
                for (int floor = erpBuildingSet.getFloorStart(); floor <= erpBuildingSet.getFloorEnd(); floor++) {
                    String floorStr = String.valueOf(floor);
                    if(floorStr.equals(param.getBuildFloor())) {
                        if(sysFloorMap.containsKey(floorStr)) {// 已经被配置成其他的了，可以配置成这个
                            break;
                        }
                        if(floorStr.equals(sysBuildFloor)) {// 当前楼层和真实楼层一致则可以修改
                            break;
                        }
                        throw new ConfirmException("楼层名重复，请修改后重新保存！");
                    }
                }
            }
            ErpBuildingSetFloor erpBuildingSetFloor = sysFloorMap.get(sysBuildFloor);
            if(erpBuildingSetFloor != null) {
                floorId = erpBuildingSetFloor.getId();
            }
        } else {
            for (int floor = erpBuildingSet.getFloorStart(); floor <= erpBuildingSet.getFloorEnd(); floor++) {
                String floorStr = String.valueOf(floor);
                if(floorStr.equals(param.getBuildFloor())) {
                    if(floorStr.equals(sysBuildFloor)) {// 当前楼层和真实楼层一致则可以修改
                        break;
                    }
                    throw new ConfirmException("楼层名重复，请修改后重新保存！");
                }
            }
        }
        param.setSysBuildFloor(sysBuildFloor);// 设置回来
        if(floorId == null) {
            param.setCreationTime(new Date());
            erpBuildingSetFloorMapper.insertSelective(param);
        } else {
            param.setId(floorId);
            param.setUpdateTime(new Date());
            erpBuildingSetFloorMapper.updateByPrimaryKeySelective(param);
        }
        erpBuildingSetLogMapper.insertLog(param.getCityId(), param.getSelfUserId(), param.getCompId(),
                param.getBuildId(), param.getBuildRoof(), param.getBuildUnit(), "修改楼层名" + sysBuildFloor);
    }


    @Override
	public void judgeHouseRuleAndThrow(Integer cityId,Integer compId,Integer currUserId, Integer buildId, String houseRoof, String houseUnit, String houseNum,
			String houseFloor, Integer caseType, Byte useage) {
		int ruleToValid = judgeHouseRuleToValid(cityId, compId, currUserId, buildId, houseRoof, houseUnit, houseNum, houseFloor, caseType, useage);
		// 0=可以录入，1=没有锁定，2=不符合规则
		if (ruleToValid == 1) {
			throw new ConfirmException("该楼盘没有锁定规则，请联系管理员添加锁定！");
		} else if (ruleToValid == 2) {
			throw new ConfirmException("该房源地址与楼盘栋座规则不符，请重新登记！");
		}
	}

	/**
	 * 依据单元、栋、楼层生成所有房号
	 * @author 张宏利
	 * @since 2017年12月18日
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @param houseRoof
	 * @param houseUnit
	 * @param
	 * @param houseFloor
	 * @return
	 */
	public Map<String, String> getHouseNumsByRule(Integer cityId, Integer compId, Integer buildId, String houseRoof,
			String houseUnit, Integer houseFloor, ErpBuildingSet erpBuildingSet){
		houseRoof = (StringUtils.isBlank(houseRoof)) ? "0" : houseRoof;
		houseUnit = (StringUtils.isBlank(houseUnit)) ? "0" : houseUnit;
		Map<String, String> houseNumMap = new HashMap<>();

		if(erpBuildingSet.getFloorStart() > houseFloor || erpBuildingSet.getFloorEnd() < houseFloor) {
			return houseNumMap;
		}
		Byte numberRule = erpBuildingSet.getNumberRule();
		Byte compriseRule = erpBuildingSet.getCompriseRule();
		Byte numberType = erpBuildingSet.getNumberType();
		int floorStart = erpBuildingSet.getFloorStart();
		int floorEnd = erpBuildingSet.getFloorEnd();
		// 没有房号规则
		if(numberRule == null) {
			return houseNumMap;
		}
		// 这两个不能为空
		compriseRule = (compriseRule == null) ? 0 : compriseRule;
		numberType = (numberType == null) ? 0 : numberType;
		int roomTemp = 0;
		int doorStart = 1;
		if(erpBuildingSet.getDoorStart() != null) {
			doorStart = erpBuildingSet.getDoorStart();
		}
		int buildDoors = StringUtil.parseInteger(erpBuildingSet.getBuildDoors(), 0);
		for (int floor = floorStart; floor <= floorEnd; floor++) {
			if(floor > houseFloor) {
				break;// 层数大于需要的层数
			}
			for (int door = 0; door < buildDoors; door++) {
				String sysDoorNum = floor + "-" + (door + 1);
				String doorNum = this.createBuildRuleNumber(floor, door, numberRule, compriseRule, numberType,
						doorStart, roomTemp);
				roomTemp++;// 必须要自增一个
				if (doorNum != null && houseFloor == floor) {
					houseNumMap.put(sysDoorNum, doorNum);
				}
			}
		}
		List<ErpBuildingSetRoom> roomList = erpBuildingSetRoomMapper.getRoomList(cityId, compId, buildId, houseRoof, houseUnit, String.valueOf(houseFloor), null, null);
		for (ErpBuildingSetRoom erpBuildingSetRoom : roomList) {
			if(erpBuildingSetRoom.getDelFlag() == 1) {
				houseNumMap.remove(erpBuildingSetRoom.getSysRoomId());
			} else {
				houseNumMap.put(erpBuildingSetRoom.getSysRoomId(), erpBuildingSetRoom.getRoomId());
			}
		}
		return houseNumMap;
	}

	/**
	 * 依据规则生成编号
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param floor
	 * @param door
	 * @param numberRule
	 * @param compriseRule
	 * @param numberType
	 * @param doorStart
	 * @param roomTemp
	 * @return
	 */
	@Override
	public String createBuildRuleNumber(int floor, int door, Byte numberRule, Byte compriseRule, Byte numberType,
			int doorStart, int roomTemp) {
		String doorNum = null;
		if (numberRule == 1) {
			// 户号
			if (compriseRule == 1) {
				if (numberType == 2) {
					doorNum = String.valueOf((char) (doorStart + door + 64));
				} else {
					doorNum = String.valueOf(doorStart + door);
				}
			} else {// 楼层+户号
				if (numberType == 2) {
					doorNum = floor + String.valueOf((char) (doorStart + door + 64));
				} else {
					if (doorStart + door >= 10) {
						doorNum = floor + String.valueOf(doorStart + door);
					} else {
						doorNum = floor + "0" + String.valueOf(doorStart + door);
					}
				}
			}
		// 按单元
		} else if (numberRule == 2) {
			if (compriseRule == 1) {
				doorNum = String.valueOf(doorStart + roomTemp);
			} else {
				if (doorStart + roomTemp >= 10) {
					doorNum = floor + String.valueOf(doorStart + roomTemp);
				} else {
					doorNum = floor + "0" + String.valueOf(doorStart + roomTemp);
				}
			}
		}
		return doorNum;
	}

	/**
	 * 测试线上规则
	 * @author 张宏利
	 * @since 2017年12月25日
	 * @param args
	 */
	public static void main(String[] args) {
		// 这两个不能为空
		Byte numberRule = 2;
		Byte compriseRule = 2;
		Byte numberType = 0;
		int roomTemp = 0;
		int doorStart = 1;
		int houseFloor = 3;
		int floorStart = 1;
		int floorEnd = 4;
		int buildDoors = StringUtil.parseInteger(2, 0);
		Map<String, String> houseNumMap = new HashMap<>();
		for (int floor = floorStart; floor <= floorEnd; floor++) {
			if(floor > houseFloor) {
				break;// 层数大于需要的层数
			}
			for (int door = 0; door < buildDoors; door++) {
				String doorNum = null;
				String sysDoorNum = floor + "-" + (door + 1);
				if (numberRule == 1) {
					// 户号
					if (compriseRule == 1) {
						if (numberType == 2) {
							doorNum = String.valueOf((char) (doorStart + door + 64));
						} else {
							doorNum = String.valueOf(doorStart + door);
						}
					} else {// 楼层+户号
						if (numberType == 2) {
							doorNum = floor + String.valueOf((char) (doorStart + door + 64));
						} else {
							if (doorStart + door >= 10) {
								doorNum = floor + String.valueOf(doorStart + door);
							} else {
								doorNum = floor + "0" + String.valueOf(doorStart + door);
							}
						}
					}
					roomTemp++;
				// 按单元
				} else if (numberRule == 2) {
					if (compriseRule == 1) {
						doorNum = String.valueOf(doorStart + roomTemp);
					} else {
						if (doorStart + roomTemp >= 10) {
							doorNum = houseFloor + String.valueOf(doorStart + roomTemp);
						} else {
							doorNum = houseFloor + "0" + String.valueOf(doorStart + roomTemp);
						}
					}
					roomTemp++;
				}
				if (doorNum != null && houseFloor == floor) {
					houseNumMap.put(sysDoorNum, doorNum);
				}
			}
		}
		System.out.println(JSON.toJSONString(houseNumMap));
	}

	/**
	 * 判断楼盘信息是否符合
	 * @author 熊刚
	 * @since 2017年10月19日
	 * @param buildId
	 * @param houseRoof
	 * @param houseUnit
	 * @param houseNum
	 * @param houseFloor
	 * @param caseType
	 * @return 0=可以录入，1=没有锁定，2=不符合规则
	 * @throws Exception
	 */
	public int judgeHouseRuleToValid(Integer cityId,Integer compId,Integer currUserId,Integer buildId, String houseRoof, String houseUnit, String houseNum,
			String houseFloor, Integer caseType, Byte useage){
		if (StringUtils.isBlank(houseRoof) && StringUtils.isBlank(houseUnit)
				&& StringUtils.isBlank(houseFloor) && StringUtils.isBlank(houseNum)) {
			return 0;
		}
		// 商铺、车库、厂房、仓库都不管锁没锁定楼盘，都能够录入，并且不判断是否符合锁定的规则
		if(Const.DIC_HOUSE_USEAGE_GARAGE.equals(useage)
				|| Const.DIC_HOUSE_USEAGE_STORE.equals(useage)
				|| Const.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
				|| Const.DIC_HOUSE_USEAGE_TRADE.equals(useage)
				|| buildId == -1// 自建房
				) {
			return 0;
		}
		String onlyInputLockBuildRoom = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, currUserId,"ONLY_INPUT_LOCK_BUILD_ROOM");
		if (!"1".equals(onlyInputLockBuildRoom)) {
			return 0;
		}
		ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(cityId, compId, buildId);
		// 未锁定不能录入
		int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
		if (buildLock != 1) {
			return 1;
		}
		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectByBuildUnit(cityId, compId, buildId, houseRoof, houseUnit);
		if (erpBuildingSet == null) {
			// 随便查询一个楼盘，如果一个都查不到，说明没有规则，没有规则的时候可以随便录入
			erpBuildingSet = erpBuildingSetMapper.getErpBuildingSet(cityId, compId, buildId, null);
			if (erpBuildingSet == null) {
				return 0;
			}
			return 2;
		}
		Integer houseFloorInt = StringUtil.paseInteger(houseFloor, 0);
		Map<String, String> houseNumsByRule = this.getHouseNumsByRule(cityId, compId, buildId, houseRoof, houseUnit,
				houseFloorInt, erpBuildingSet);
		boolean result = houseNumsByRule.containsValue(houseNum);
		return result ? 0 : 2;
//		houseNum = (StringUtils.isBlank(houseNum)) ? "0" : houseNum;
//		houseRoof = (StringUtils.isBlank(houseRoof)) ? "0" : houseRoof;
//		houseUnit = (StringUtils.isBlank(houseUnit)) ? "0" : houseUnit;
//		// 1.楼盘id到BUILDING_SET表中查询信息
//		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.getErpBuildingSet(cityId, compId, buildId);
//		if (erpBuildingSet == null) {
//			return false;
//		}
//		erpBuildingSet = erpBuildingSetMapper.getErpBuildingSetByRoofAndUnit(cityId, compId, buildId, houseRoof, houseUnit);
//		if (erpBuildingSet == null) {
//			return false;
//		}
//		Integer nowFloor = StringUtil.paseInteger(houseFloor, 0);
//		Integer floorStart = StringUtil.parseInteger(erpBuildingSet.getFloorStart(), 0);
//		Integer floorEnd = StringUtil.parseInteger(erpBuildingSet.getFloorEnd(), 0);
//		Integer nowNum = StringUtil.parseInteger(houseNum, 0);
//		Integer totalDoors = StringUtil.parseInteger(erpBuildingSet.getBuildDoors(), 0);
//		Integer doorStart = StringUtil.parseInteger(erpBuildingSet.getDoorStart(), 0);
//		Byte numberRule = erpBuildingSet.getNumberRule();
//		// 排号规则未设置，直接返回可以录入
//		if (numberRule == null || 0 == numberRule) {
//			return true;
//		}
//		// 排号规则 1=按楼层排号，2=按单元排号
//		if (2 == numberRule) {
//			totalDoors = totalDoors * (floorEnd - floorStart + 1);
//		}
//		totalDoors += doorStart;
//		// 组成规则 1=户号，2=楼层+户号
//		if (2 == erpBuildingSet.getCompriseRule()) {
//			// 1101 11
//			if (houseNum.length() <= houseFloor.length()) {
//				return false;
//			}
//			// 前几位是楼层，后两位是号
//			String realNum = houseNum.substring(houseFloor.length());
//			nowNum = StringUtil.paseInteger(realNum, 0);
//		}
//		// 楼层在规则外(当前楼层小于开始或大于结束，当前号小于开始或大于总号数)
//		if (nowFloor < floorStart || nowFloor > floorEnd || nowNum < doorStart || nowNum > totalDoors) {
//			ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.getErpBuildingSetRoom(cityId, compId,
//					buildId, houseRoof, houseUnit, houseFloor, houseNum, 0);
//			return erpBuildingSetRoom != null;
//		}
//		ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.getErpBuildingSetRoom(cityId, compId, buildId,
//				houseRoof, houseUnit, houseFloor, houseNum, 1);
//		if (erpBuildingSetRoom != null) {
//			// 如果已经被删除
//			return false;
//		}
//		return true;
	}

	@Transactional
	@Override
	public void delBuildRoom(DeleteIdParam param, Integer cityId, Integer compId, Integer userId) {
		erpBuildingSetRoomMapper.delBuildRoom(cityId, param, compId);
		erpBuildingSetRoomLayoutMapper.delBuildRoomLayout(cityId, param, compId);
		erpBuildingSetLogMapper.insertLog(cityId, userId, compId,
				param.getBuildId(), null, null, "删除房间");

		UpdateBuildRoofUnitsAndDoorsParam roofUnitsAndDoorsParam = new UpdateBuildRoofUnitsAndDoorsParam();
		roofUnitsAndDoorsParam.setBuildId(param.getBuildId());
		roofUnitsAndDoorsParam.setBuildingSetRoofId(param.getBuildingSetRoofId());
		// 户数减少1户
		roofUnitsAndDoorsParam.setDoors(1);
		roofUnitsAndDoorsParam.setDoorsChange(0);

		ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
		roofExample.setShardCityId(cityId);
		roofExample.createCriteria()
				.andCompIdEqualTo(compId)
				.andBuildIdEqualTo(param.getBuildId())
				.andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
		erpBuildingSetRoofMapper.updateBuildRoofUnitsAndDoors(cityId, roofUnitsAndDoorsParam, compId);
	}

	@Override
	public void deleteRoomInColumn(RoomIdsParam param, Integer cityId, Integer compId, Integer userId) {
		batchDeleteRoom(param, cityId, compId, userId, "删除本列房间");
	}

	@Override
	public void deleteRoom(RoomIdsParam param, Integer cityId, Integer compId, Integer userId) {
		batchDeleteRoom(param, cityId, compId, userId, "删除房间");
	}

	// 批量删除房间(删除行和删除列)
	private void batchDeleteRoom(RoomIdsParam param, Integer cityId, Integer compId, Integer userId, String logInfo) {
		String[] roomIds = param.getBuildingSetRoomIds().split(",");
		DeleteIdParam deleteIdParam = new DeleteIdParam();
		deleteIdParam.setBuildId(param.getBuildId());
		List<Integer> roomIdList = Arrays.stream(roomIds).map(Integer::valueOf).distinct().collect(Collectors.toList());
		deleteIdParam.setBuildingSetRoomIds(roomIdList);

		erpBuildingSetRoomMapper.delBuildRoom(cityId, deleteIdParam, 0);
		erpBuildingSetRoomLayoutMapper.delBuildRoomLayout(cityId, deleteIdParam, 0);

		// 修改单元表中的户数
		erpBuildingSetUnitMapper.updateRoomCountInUnit(cityId, 0, param.getBuildId(), param.getBuildingSetUnitId());
		if (param.getBuildingSetRoofId() != null) {
			// 修改栋表中的户数
			erpBuildingSetRoofMapper.updateRoomAndUnitCountInRoof(cityId, 0, param.getBuildId(), param.getBuildingSetRoofId());
		}
		// 修改 FUN_BUILD_ROOFUNITDOORS 表户数
		erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, 0, param.getBuildId());

		erpBuildingSetLogMapper.insertLog(cityId, userId, 0,
				param.getBuildId(), null, null, logInfo);
	}

	@Transactional
	@Override
	public void addBuildRoom(BuildingSetRoomParam param, Integer cityId, Integer compId, Integer userId) {

		ErpBuildingSetFloor name = erpBuildingSetFloorMapper.selectRoofAndUnitNameInFloor(cityId, 0, param.getBuildId(), param.getBuildingSetFloorId());
		ErpBuildingSetUnit erpBuildingSetUnit = erpBuildingSetUnitMapper.selectByBuildAndBuildUnit(cityId, 0, param.getBuildId(), name.getBuildUnit());
		Byte compriseRule = erpBuildingSetUnit.getCompriseRule();
		// 获取需要添加的该楼层的 sysBuildFloor, 比如10楼,返回10
		String sysBuildFloor = name.getSysBuildFloor();
		//12370 5.30上线-PC&APP新增房间时，房间号取消自动补楼层 #2
//		String roomId = param.getRoomId();
//		if(StringUtil.parseInteger(sysBuildFloor)<10 && compriseRule==4){
//			if(roomId.length()==1){
//				param.setRoomId("0"+sysBuildFloor+"0"+roomId);
//			}else {
//				param.setRoomId("0"+sysBuildFloor+roomId);
//			}
//		}else {
//			if(roomId.length()==1){
//				param.setRoomId(sysBuildFloor+"0"+roomId);
//			}else {
//				param.setRoomId(sysBuildFloor+roomId);
//			}
//		}
		ErpBuildingSetRoom erpBuildingSetRoom = erpBuildingSetRoomMapper.selectByfloorIdAndBuildRoom(cityId, 0, param.getBuildId(), param.getBuildingSetFloorId(), param.getRoomId());
		if (erpBuildingSetRoom != null) {
			throw new BusinessException("该房号已被占用!");
		}

		Integer sync = param.getSync();

		ErpBuildingSetRoom room = new ErpBuildingSetRoom();
		BeanUtils.copyProperties(param, room);
		room.setShardCityId(cityId);
		room.setCityId(cityId);
		room.setCompId(0);
//		room.setDelFlag((byte) 0);
		room.setCreationTime(new Date());
		room.setUpdateTime(new Date());

		// 将房间户型,建筑面积,套内面积,朝向应用到本栋本单元同房号
		if (sync != null && sync == 1 && param.getRoomIds() != null && param.getRoomIds().length() > 0) {
			String[] roomIds = param.getRoomIds().split(",");
			List<Integer> buildingSetRoomIds = Arrays.stream(roomIds).map(Integer::valueOf).collect(Collectors.toList());
			erpBuildingSetRoomMapper.batchUpdateRoom(cityId, 0, param.getBuildId(), param, buildingSetRoomIds);
		}

		// 该层楼最大的 SYS_ROOM_ID, 如果为空,则返回例如每层楼计算的最大SYS_ROOM_ID例如 1-1,2-1
		String maxSysRoomId = erpBuildingSetFloorMapper.selectMaxSysRoomIdInFloor(cityId, 0,
				param.getBuildId(), param.getBuildingSetRoofId(),  param.getBuildingSetUnitId(), param.getBuildingSetFloorId());

		// 计算该房间的 sysRoomId, 可能为负数, -1-1
		if (maxSysRoomId != null) {
			if (maxSysRoomId.startsWith("-")) {
				String[] arr = maxSysRoomId.split("-");
				if (arr.length >= 3) {
					room.setSysRoomId("-" + arr[1] + "-" + (Integer.valueOf(arr[2]) + 1));
				}
			} else {
				String[] arr = maxSysRoomId.split("-");
				room.setSysRoomId(arr[0] + "-" + (Integer.valueOf(arr[1]) + 1));
			}
		} else {
			room.setSysRoomId(sysBuildFloor + "-1");
		}

		String buildRoof = name.getBuildRoof();
		String buildUnit = name.getBuildUnit();
		// 用户填写的楼层名,用来md5加密
		String md5BuildFloor = name.getBuildFloor() == null ? "" : name.getBuildFloor();
		room.setBuildRoof(buildRoof);
		room.setBuildUnit(buildUnit);
		// 楼层表的 SysBuildFloor 对应房间表的 RoomFloor
		room.setRoomFloor(sysBuildFloor == null ? "0" : sysBuildFloor);

		// 号位规则, 房间MD5不带楼层
		String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

		String md5;
		if ("2".equals(paramValue)) {
			md5 = this.encodeToMD5ByUnit(param.getBuildId(), buildUnit, param.getRoomId());
		} else {
			md5 = this.encodeToMD5(param.getBuildId(), buildRoof, buildUnit, md5BuildFloor, param.getRoomId());
		}

//		String md5 = this.encodeToMD5(param.getBuildId(), buildRoof, buildUnit, md5BuildFloor, param.getRoomId());

		room.setAddrMd5(md5);

		erpBuildingSetRoomMapper.insertSelective(room);
		Integer buildingSetRoomId = room.getId();

        String photoUrls = param.getPhotoUrls();
        if (photoUrls != null) {
            String[] urls = photoUrls.split(",");
            List<String> urlList = Arrays.stream(urls).distinct().collect(Collectors.toList());

            for (String anUrlList : urlList) {
                ErpBuildingSetRoomLayout roomLayout = new ErpBuildingSetRoomLayout();
				roomLayout.setShardCityId(cityId);
                roomLayout.setCityId(cityId);
                roomLayout.setCompId(0);
                roomLayout.setBuildId(param.getBuildId());
                roomLayout.setBuildingSetRoomId(buildingSetRoomId);
                roomLayout.setCreatedTime(new Date());
                roomLayout.setLayoutUrl(anUrlList);
                roomLayout.setUpdatedTime(new Date());
//                roomLayout.setDelFlag((byte) 0);
                // 添加户型图
                erpBuildingSetRoomLayoutMapper.insertSelective(roomLayout);
            }
        }

		// 户型图应用到本栋本单元同房号
		if (sync != null && sync == 1) {
			DeleteIdParam deleteIdParam = new DeleteIdParam();
			deleteIdParam.setBuildId(param.getBuildId());
			deleteIdParam.setBuildingSetRoomId(buildingSetRoomId);
			if (param.getRoomIds() != null) {
				String[] roomIds = param.getRoomIds().split(",");
				List<Integer> buildingSetRoomIds = Arrays.stream(roomIds).map(Integer::valueOf).collect(Collectors.toList());
				if (buildingSetRoomIds.size() > 0) {
					deleteIdParam.setBuildingSetRoomIds(buildingSetRoomIds);
					// 删除这些房间的户型图
					erpBuildingSetRoomLayoutMapper.delBuildRoomLayout(cityId, deleteIdParam, 0);
					// 批量添加户型图
					for (Integer needAddLayoutRoomId : buildingSetRoomIds) {
						erpBuildingSetRoomLayoutMapper.batchAddLayoutUrl(cityId, param.getBuildId(), buildingSetRoomId, needAddLayoutRoomId, compId);
					}
				}
			}
		}

		// 修改单元表中的户数
		erpBuildingSetUnitMapper.updateRoomCountInUnit(cityId, compId, param.getBuildId(), param.getBuildingSetUnitId());
		// 修改栋表中的户数
		erpBuildingSetRoofMapper.updateRoomAndUnitCountInRoof(cityId, compId, param.getBuildId(), param.getBuildingSetRoofId());
		// 修改 FUN_BUILD_ROOFUNITDOORS 表户数
		erpFunBuildRoofunitdoorsMapper.updateRoomAndUnitCountInRoofUnitDoors(cityId, compId, param.getBuildId());

		Map<String, Object> map = new HashMap<>();
        map.put("buildingSetRoomId", buildingSetRoomId);
        map.put("buildId", param.getBuildId());

		if (param.getReplacePhotos() != null && param.getReplacePhotos() == 1) {
			//替换房源户型图
			String url = AppConfig.getHftHouseUrl() + "erp/funHouse/updateFloorPlan";
			HttpUtil.postJson(url, map);
		}

		erpBuildingSetLogMapper.insertLog(cityId, userId, 0, param.getBuildId(),
				param.getBuildingSetRoofId() == null ? "" : param.getBuildingSetRoofId().toString(),
				param.getBuildingSetUnitId().toString(), "添加房间 " + param.getRoomId());
	}

	@Override
	public ErpBuildingSetRoomDetailsVo getBuildRoomDetails(ErpBuildingSetRoomIdParam param, Integer cityId, Integer compId) {
		ErpBuildingSetRoomDetailsVo roomDetailsVo = erpBuildingSetRoomMapper.getBuildRoomDetailsVo(cityId,
				param.getBuildId(), param.getBuildingSetRoomId(), compId);

		List<ErpBuildingSetRoomLayoutVo> roomLayoutVos = erpBuildingSetRoomLayoutMapper.selectRoomLayoutListVo(cityId,
				param.getBuildId(), param.getBuildingSetRoomId(), compId);

		if (roomLayoutVos != null && roomLayoutVos.size() > 0) {
			String photoUrls = String.join(",", roomLayoutVos.stream().map(it -> AppConfig.getPicDomainUrl() + it.getLayoutUrl()).collect(Collectors.toList()));
			roomDetailsVo.setPhotoUrls(photoUrls);
		}

		return roomDetailsVo;
	}

//	@Override
//	public String encodeToMD5(Integer buildId, String roof, String unit, String floor, String num) {
//		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
//		String enCodeStr;
//
//		if (buildId == null) throw new BusinessException("MD5加密,楼盘不能为空");
////		if (unit == null) throw new BusinessException("MD5加密,单元不能为空");
////		if (floor == null) throw new BusinessException("MD5加密,楼层不能为空");
//		if (num == null) throw new BusinessException("MD5加密,房号不能为空");
//
//		unit = EnCodeHelper.encode(unit.toUpperCase());
//
//		if (floor != null) {
//			floor = EnCodeHelper.encode(floor.toUpperCase());
//		}
//		num = EnCodeHelper.encode(num.toUpperCase());
//
//		if (roof != null) {
//			roof = EnCodeHelper.encode(roof.toUpperCase());
//			if (floor != null) {
//				enCodeStr = EnCodeHelper.ecodeByMD5(buildId + roof + "_" + unit + "_" + floor + "_" + num);
//			} else {
//				enCodeStr = EnCodeHelper.ecodeByMD5(buildId + roof + "_" + unit  + "_" + num);
//			}
//		} else {
//			if (floor != null) {
//				enCodeStr = EnCodeHelper.ecodeByMD5(buildId + unit + "_" + floor + "_" + num);
//			} else {
//				enCodeStr = EnCodeHelper.ecodeByMD5(buildId + unit + "_" + num);
//			}
//		}
//
//		return enCodeStr;
//	}


	/**
	 * 普通栋座加密
	 * */
	@Override
	public String encodeToMD5(Integer buildId, String roof, String unit, String floor, String num) {
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		String enCodeStr;
		roof = null == roof ? "" : roof;
		unit = null == unit ? "" : unit;
		floor = null == floor ? "" : floor;
		num = null == num ? "" : num;

		unit = EnCodeHelper.encode(unit.toUpperCase());
		floor = EnCodeHelper.encode(floor.toUpperCase());
		num = EnCodeHelper.encode(num.toUpperCase());
		roof = EnCodeHelper.encode(roof.toUpperCase());

		enCodeStr = EnCodeHelper.ecodeByMD5(buildId + roof + "_" + unit + "_" + floor + "_" + num);
		return enCodeStr;
	}


	/**
	 * 号位加密
	 * */
	@Override
	public String encodeToMD5ByUnit(Integer buildId, String unit, String num) {
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		String enCodeStr;
		unit = null == unit ? "" : unit;
		num = null == num ? "" : num;

		unit = EnCodeHelper.encode(unit.toUpperCase());
		num = EnCodeHelper.encode(num.toUpperCase());

		enCodeStr = EnCodeHelper.ecodeByMD5(buildId + unit + "_" + num);
		return enCodeStr;
	}

	@Override
	public List<RoomConInfoVo> getRoomConInfoByCase(RoomConInfoByCaseParam param, GeneralParam generalParam) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		Integer buildId = param.getBuildId();
		Integer buildingSetRoofId = param.getBuildingSetRoofId();
		Integer buildingSetUnitId = param.getBuildingSetUnitId();
		Byte caseType = param.getCaseType();
		String buildingSetRoof = null;
		String buildingSetUnit = null;

		ErpBuildingMarketingControl erpBuildingMarketingControl = new ErpBuildingMarketingControl();
		erpBuildingMarketingControl.setBuildId(param.getBuildId());

		if (buildingSetRoofId != null) {
			ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
			roof.setShardCityId(cityId);
			roof.setBuildId(buildId);
			roof.setBuildingSetRoofId(buildingSetRoofId);
			roof = erpBuildingSetRoofMapper.selectByPrimaryKey(roof);

			if (roof != null && roof.getBuildRoof() != null) {
				buildingSetRoof = roof.getBuildRoof();
			} else {
				throw new BusinessException("没有获取到该栋座信息！");
			}
		}
		if (buildingSetUnitId != null) {
			ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
			unit.setShardCityId(cityId);
			unit.setBuildId(buildId);
			unit.setId(buildingSetUnitId);
			unit = erpBuildingSetUnitMapper.selectByPrimaryKey(unit);

			if (unit != null && unit.getBuildUnit() != null) {
				buildingSetUnit = unit.getBuildUnit();
			} else {
				throw new BusinessException("没有获取到该单元信息！");
			}
		}

		// 获取销控表列表
		List<ErpBuildingMarketingControlDto> controls = erpBuildingMarketingControlMapper.getRoomConInfo(cityId, compId, buildId, buildingSetRoof, buildingSetUnit);

		List<RoomConInfoVo> allRoomConInfo = new ArrayList<>();

		if (caseType == null) {
			// caseType == null 全部查询出来

			// 组装出售销控信息
			List<RoomConInfoVo> saleConInfos = generateRoomConInfoByCase((byte) 1, buildId, controls, generalParam, false);
			// 组装出租销控信息
			List<RoomConInfoVo> leaseConInfos = generateRoomConInfoByCase((byte) 2, buildId, controls, generalParam, false);
			// 组装租售销控信息
			List<RoomConInfoVo> saleAndLeaseConInfos = generateRoomConInfoByCase((byte) 3, buildId, controls, generalParam, false);
			// 租售销控信息中的所有租售ID
			Set<Integer> saleIds = saleAndLeaseConInfos.stream().map(RoomConInfoVo::getSaleId).collect(Collectors.toSet());
			Set<Integer> leaseIds = saleAndLeaseConInfos.stream().map(RoomConInfoVo::getLeaseId).collect(Collectors.toSet());
			// 去除掉租售信息中的出租信息和出售信息, 这下 saleConInfos, leaseConInfos, saleAndLeaseConInfos 就全部是不重复的数据
			saleConInfos = saleConInfos.stream().filter(it -> !saleIds.contains(it.getSaleId())).collect(Collectors.toList());
			leaseConInfos = leaseConInfos.stream().filter(it -> !leaseIds.contains(it.getLeaseId())).collect(Collectors.toList());

			allRoomConInfo.addAll(saleConInfos);
			allRoomConInfo.addAll(leaseConInfos);
			allRoomConInfo.addAll(saleAndLeaseConInfos);
		} else {
			allRoomConInfo = generateRoomConInfoByCase(caseType, buildId, controls, generalParam, false);
		}

		String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

		if (allRoomConInfo.size() > 0) {
			// 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
			if ("2".equals(paramVal)) {
				allRoomConInfo.forEach(it -> it.setBuildUnitName("号"));
			} else {
				List<ErpBuildingSetRoofNameVo> roofNameVos = erpBuildingSetRoofMapper.getBuildRoofNameVo(cityId, compId, buildId);

				for (RoomConInfoVo roomConInfoVo : allRoomConInfo) {
					for (ErpBuildingSetRoofNameVo roofNameVo : roofNameVos) {
						if (roomConInfoVo.getBuildingSetRoof() != null && roomConInfoVo.getBuildingSetRoof().equalsIgnoreCase(roofNameVo.getBuildRoof())) {
							roomConInfoVo.setBuildRoofName(roofNameVo.getBuildRoofName());
							roomConInfoVo.setBuildUnitName(roofNameVo.getBuildUnitName());
						}
					}
				}
			}
		}

		if (!"2".equals(paramVal) && buildingSetRoofId != null) {
			String need = buildingSetRoof;
			allRoomConInfo = allRoomConInfo.stream().filter(it -> it.getBuildingSetRoof() != null && it.getBuildingSetRoof().equals(need)).collect(Collectors.toList());
		}

		// 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
		if ("2".equals(paramVal) && buildingSetUnitId != null) {
			String need = buildingSetUnit;
			allRoomConInfo = allRoomConInfo.stream().filter(it -> it.getBuildingSetUnit() != null && it.getBuildingSetUnit().equals(need)).collect(Collectors.toList());
		}

		return allRoomConInfo;
	}

	private List<RoomConInfoVo> generateRoomConInfoByCase2(Byte caseType, Integer buildId, List<ErpBuildingMarketingControlDto> controls, GeneralParam generalParam) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();

		List<ErpBuildingMarketingControlDto> saleControls = controls.stream().filter(it -> it.getCaseType() == 1).collect(Collectors.toList());
		List<ErpBuildingMarketingControlDto> leaseControls = controls.stream().filter(it -> it.getCaseType() == 2).collect(Collectors.toList());
		int baseCount = 100;

		List<RoomConInfoVo> roomConInfoVos = new ArrayList<>();
		List<ErpFunSale> allSale = new ArrayList<>();
		List<ErpBuildingSetRoom> allRooms = new ArrayList<>();
		List<ErpFunLease> allLease = new ArrayList<>();

		if (caseType == 1) {
			// 出售类型
			if (saleControls.size() > 0) {
				for (int i = 0; i < saleControls.size(); i += baseCount) {
					List<ErpBuildingMarketingControlDto> current = saleControls.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						Set<Integer> caseIds = current.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toSet());
						List<ErpFunSale> sales = erpFunSaleMapper.getFunSaleListByCaseIds(cityId, compId, buildId, caseIds);
						allSale.addAll(sales);

						Set<String> md5s = current.stream().map(ErpBuildingMarketingControlDto::getMarketingControlMd5).collect(Collectors.toSet());
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);
						allRooms.addAll(rooms);
					}
				}

				for (ErpBuildingMarketingControlDto controlDto : saleControls) {
					RoomConInfoVo roomConInfo = new RoomConInfoVo();
					roomConInfo.setBuildId(buildId);
					roomConInfo.setCaseType((byte) 1);
					roomConInfo.setSaleStatus(controlDto.getCaseStatus());

					Optional<ErpFunSale> funSale = allSale.stream().filter(it -> it.getSaleId().equals(controlDto.getCaseId())).findFirst();
					if (funSale.isPresent()) {
						ErpFunSale sale = funSale.get();
						roomConInfo.setSalePrice(sale.getSaleTotalPrice());
						roomConInfo.setSaleId(sale.getSaleId());
						roomConInfo.setSaleNo(sale.getSaleNo());
					}

					Optional<ErpBuildingSetRoom> buildingSetRoom = allRooms.stream().filter(it -> it.getAddrMd5().equals(controlDto.getMarketingControlMd5())).findFirst();
					if (buildingSetRoom.isPresent()) {
						ErpBuildingSetRoom room = buildingSetRoom.get();
						roomConInfo.setBuildingSetRoof(room.getBuildRoof());
						roomConInfo.setBuildingSetUnit(room.getBuildUnit());
						roomConInfo.setBuildingSetFloor(room.getRoomFloor());
						roomConInfo.setRoomId(room.getRoomId());
						roomConInfo.setHouseRoom(room.getHouseRoom());
						roomConInfo.setHouseArea(room.getHouseArea());
						roomConInfo.setHouseDirect(room.getHouseDirect());
						roomConInfo.setAddrMd5(room.getAddrMd5());
					}
					roomConInfoVos.add(roomConInfo);
				}
			}
		} else if (caseType == 2) {
			// 出租类型
			if (leaseControls.size() > 0) {
				for (int i = 0; i < leaseControls.size(); i += baseCount) {
					List<ErpBuildingMarketingControlDto> current = leaseControls.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						Set<Integer> caseIds = current.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toSet());
						List<ErpFunLease> leases = erpFunLeaseMapper.getFunLeaseListByCaseIds(cityId, compId, buildId, caseIds);
						allLease.addAll(leases);

						Set<String> md5s = current.stream().map(ErpBuildingMarketingControlDto::getMarketingControlMd5).collect(Collectors.toSet());
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);
						allRooms.addAll(rooms);
					}
				}

				for (ErpBuildingMarketingControlDto controlDto : leaseControls) {
					RoomConInfoVo roomConInfo = new RoomConInfoVo();
					roomConInfo.setBuildId(buildId);
					roomConInfo.setCaseType((byte) 2);
					roomConInfo.setLeaseStatus(controlDto.getCaseStatus());

					Optional<ErpFunLease> funLease = allLease.stream().filter(it -> it.getLeaseId().equals(controlDto.getCaseId())).findFirst();
					if (funLease.isPresent()) {
						ErpFunLease lease = funLease.get();
						roomConInfo.setLeasePrice(lease.getLeaseTotalPrice());
						roomConInfo.setLeaseId(lease.getLeaseId());
						roomConInfo.setLeaseNo(lease.getLeaseNo());
						roomConInfo.setLeasePriceUnit(lease.getPriceUnit());
					}

					Optional<ErpBuildingSetRoom> buildingSetRoom = allRooms.stream().filter(it -> it.getAddrMd5().equals(controlDto.getMarketingControlMd5())).findFirst();
					if (buildingSetRoom.isPresent()) {
						ErpBuildingSetRoom room = buildingSetRoom.get();
						roomConInfo.setBuildingSetRoof(room.getBuildRoof());
						roomConInfo.setBuildingSetUnit(room.getBuildUnit());
						roomConInfo.setBuildingSetFloor(room.getRoomFloor());
						roomConInfo.setRoomId(room.getRoomId());
						roomConInfo.setHouseRoom(room.getHouseRoom());
						roomConInfo.setHouseArea(room.getHouseArea());
						roomConInfo.setHouseDirect(room.getHouseDirect());
						roomConInfo.setAddrMd5(room.getAddrMd5());
					}
					roomConInfoVos.add(roomConInfo);
				}
			}
		} else if (caseType == 3) {
			Set<String> saleMd5s = saleControls.stream().map(ErpBuildingMarketingControlDto::getMarketingControlMd5).collect(Collectors.toSet());
			Set<String> leaseMd5s = leaseControls.stream().map(ErpBuildingMarketingControlDto::getMarketingControlMd5).collect(Collectors.toSet());

			// 租售类型MD5
			Set<String> saleAndLeaseMd5s = saleMd5s.stream().filter(leaseMd5s::contains).collect(Collectors.toSet());

			if (saleAndLeaseMd5s.size() > 0) {
				for (int i = 0; i < saleAndLeaseMd5s.size(); i += baseCount) {
					List<String> current = saleAndLeaseMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());
					if (current.size() > 0) {
						List<ErpBuildingMarketingControlDto> currentSaleControls = saleControls.stream()
								.filter(it -> current.contains(it.getMarketingControlMd5())).collect(Collectors.toList());
						List<ErpBuildingMarketingControlDto> currentLeaseControls = leaseControls.stream()
								.filter(it -> current.contains(it.getMarketingControlMd5())).collect(Collectors.toList());

						Set<Integer> saleCaseIds = currentSaleControls.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toSet());
						List<ErpFunSale> sales = erpFunSaleMapper.getFunSaleListByCaseIds(cityId, compId, buildId, saleCaseIds);
						allSale.addAll(sales);

						Set<Integer> leaseCaseIds = currentLeaseControls.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toSet());
						List<ErpFunLease> leases = erpFunLeaseMapper.getFunLeaseListByCaseIds(cityId, compId, buildId, leaseCaseIds);
						allLease.addAll(leases);

						// 因为是租售,所以取出租的或者取出售的房间字典是一样的
						Set<String> md5s = currentSaleControls.stream().map(ErpBuildingMarketingControlDto::getMarketingControlMd5).collect(Collectors.toSet());
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);
						allRooms.addAll(rooms);
					}
				}

				for (String saleAndLeaseMd5 : saleAndLeaseMd5s) {
					RoomConInfoVo roomConInfo = new RoomConInfoVo();
					roomConInfo.setBuildId(buildId);
					roomConInfo.setCaseType((byte) 3);

					Optional<ErpBuildingMarketingControlDto> leaseControl = leaseControls.stream()
							.filter(it -> it.getMarketingControlMd5().equals(saleAndLeaseMd5)).findFirst();

					if (leaseControl.isPresent()) {
						ErpBuildingMarketingControlDto controlDto = leaseControl.get();
						roomConInfo.setLeaseStatus(controlDto.getCaseStatus());

						Optional<ErpFunLease> funLease = allLease.stream().filter(it -> it.getLeaseId().equals(controlDto.getCaseId())).findFirst();
						if (funLease.isPresent()) {
							ErpFunLease lease = funLease.get();
							roomConInfo.setLeasePrice(lease.getLeaseTotalPrice());
							roomConInfo.setLeaseId(lease.getLeaseId());
							roomConInfo.setLeaseNo(lease.getLeaseNo());
							roomConInfo.setLeasePriceUnit(lease.getPriceUnit());
						}

						// 因为是租售,所以取出租的或者取出售的房间字典是一样的
						Optional<ErpBuildingSetRoom> buildingSetRoom = allRooms.stream().filter(it -> it.getAddrMd5().equals(controlDto.getMarketingControlMd5())).findFirst();
						if (buildingSetRoom.isPresent()) {
							ErpBuildingSetRoom room = buildingSetRoom.get();
							roomConInfo.setBuildingSetRoof(room.getBuildRoof());
							roomConInfo.setBuildingSetUnit(room.getBuildUnit());
							roomConInfo.setBuildingSetFloor(room.getRoomFloor());
							roomConInfo.setRoomId(room.getRoomId());
							roomConInfo.setHouseRoom(room.getHouseRoom());
							roomConInfo.setHouseArea(room.getHouseArea());
							roomConInfo.setHouseDirect(room.getHouseDirect());
							roomConInfo.setAddrMd5(room.getAddrMd5());
						}
					}

					Optional<ErpBuildingMarketingControlDto> saleControl = saleControls.stream()
							.filter(it -> it.getMarketingControlMd5().equals(saleAndLeaseMd5)).findFirst();
					if (saleControl.isPresent()) {
						ErpBuildingMarketingControlDto controlDto = saleControl.get();

						Optional<ErpFunSale> funSale = allSale.stream().filter(it -> it.getSaleId().equals(controlDto.getCaseId())).findFirst();
						if (funSale.isPresent()) {
							ErpFunSale sale = funSale.get();
							roomConInfo.setSalePrice(sale.getSaleTotalPrice());
							roomConInfo.setSaleId(sale.getSaleId());
							roomConInfo.setSaleNo(sale.getSaleNo());
							roomConInfo.setSaleStatus(controlDto.getCaseStatus());
						}
					}

					roomConInfoVos.add(roomConInfo);
				}
			}
		}

		return roomConInfoVos;
	}

	@Override
	public RoomConInfoCountVo getRoomConInfoCount(RoomConInfoCountParam param, GeneralParam generalParam) {
		Integer cityId = generalParam.getCityId();
		Integer buildId = param.getBuildId();
		Integer buildingSetRoofId = param.getBuildingSetRoofId();
		Integer buildingSetUnitId = param.getBuildingSetUnitId();

		ErpBuildingMarketingControl erpBuildingMarketingControl = new ErpBuildingMarketingControl();
		erpBuildingMarketingControl.setBuildId(param.getBuildId());

		ErpBuildingSetRoof erpBuildingSetRoof = new ErpBuildingSetRoof();
		ErpBuildingSetUnit erpBuildingSetUnit = new ErpBuildingSetUnit();

		String buildingSetRoof = null;
		String buildingSetUnit = null;

		if (buildingSetRoofId != null) {
			ErpBuildingSetRoof roof = new ErpBuildingSetRoof();
			roof.setShardCityId(cityId);
			roof.setBuildId(buildId);
			roof.setBuildingSetRoofId(buildingSetRoofId);
			erpBuildingSetRoof = erpBuildingSetRoofMapper.selectByPrimaryKey(roof);

			if (erpBuildingSetRoof == null || erpBuildingSetRoof.getBuildRoof() == null) {
				throw new BusinessException("没有获取到该栋座信息！");
			} else {
				buildingSetRoof = erpBuildingSetRoof.getBuildRoof();
			}
		}

		if (buildingSetUnitId != null) {
			ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
			unit.setShardCityId(cityId);
			unit.setBuildId(buildId);
			unit.setId(buildingSetUnitId);
			erpBuildingSetUnit = erpBuildingSetUnitMapper.selectByPrimaryKey(unit);

			if (erpBuildingSetUnit == null || erpBuildingSetUnit.getBuildUnit() == null) {
				throw new BusinessException("没有获取到该单元信息！");
			} else {
				buildingSetUnit = erpBuildingSetUnit.getBuildUnit();
			}
		}

		List<ErpBuildingMarketingControlDto> controls = erpBuildingMarketingControlMapper.getRoomConInfo(cityId, generalParam.getCompId(), buildId, buildingSetRoof, buildingSetUnit);

		RoomConInfoCountVo countVo = new RoomConInfoCountVo();

		List<RoomConInfoVo> sale = generateRoomConInfoByCase((byte) 1, buildId, controls, generalParam, false);
		List<RoomConInfoVo> lease = generateRoomConInfoByCase((byte) 2, buildId, controls, generalParam, false);
		List<RoomConInfoVo> saleAndLease = generateRoomConInfoByCase((byte) 3, buildId, controls, generalParam, false);

		// 筛选栋座的出租出售数量
		if (buildingSetRoofId != null) {
			String buildRoof = erpBuildingSetRoof.getBuildRoof();
			sale = sale.stream().filter(it -> it.getBuildingSetRoof() != null && it.getBuildingSetRoof().equals(buildRoof)).collect(Collectors.toList());
			lease = lease.stream().filter(it -> it.getBuildingSetRoof() != null && it.getBuildingSetRoof().equals(buildRoof)).collect(Collectors.toList());
			saleAndLease = saleAndLease.stream().filter(it -> it.getBuildingSetRoof() != null && it.getBuildingSetRoof().equals(buildRoof)).collect(Collectors.toList());
		}

		// 号位模式号位的出租出售数量
		if (buildingSetRoofId == null && buildingSetUnitId != null) {
			String buildUnit = erpBuildingSetUnit.getBuildUnit();
			sale = sale.stream().filter(it -> it.getBuildingSetUnit() != null && it.getBuildingSetUnit().equals(buildUnit)).collect(Collectors.toList());
			lease = lease.stream().filter(it -> it.getBuildingSetUnit() != null && it.getBuildingSetUnit().equals(buildUnit)).collect(Collectors.toList());
			saleAndLease = saleAndLease.stream().filter(it -> it.getBuildingSetUnit() != null && it.getBuildingSetUnit().equals(buildUnit)).collect(Collectors.toList());
		}

//		Set<String> saleMd5s = sale.stream().map(RoomConInfoVo::getAddrMd5).collect(Collectors.toSet());
//		Set<String> leaseMd5s = lease.stream().map(RoomConInfoVo::getAddrMd5).collect(Collectors.toSet());
		Set<String> saleAndLeaseMd5s = saleAndLease.stream().map(RoomConInfoVo::getAddrMd5).collect(Collectors.toSet());

		countVo.setSaleCount(sale.size());
		countVo.setLeaseCount(lease.size());
		countVo.setSaleAndLeaseCount(saleAndLeaseMd5s.size());

		return countVo;
	}

    @Override
    public FloorListVo getRoomInfoListInMobile(ErpBuildingGetRoomInfoListIdParam param, GeneralParam generalParam) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();
        Integer userId = generalParam.getUserId();
        Integer buildId = param.getBuildId();
        Integer buildingSetUnitId = param.getBuildingSetUnitId();

        FloorListVo floorListVo = new FloorListVo();
        List<FloorInfoVo> floorInfoVos = new ArrayList<>();

        String buildingSetUnit;
        String buildingSetRoof;

        ErpBuildingSetUnit unit = new ErpBuildingSetUnit();
        unit.setShardCityId(cityId);
        unit.setBuildId(buildId);
        unit.setId(buildingSetUnitId);
        unit = erpBuildingSetUnitMapper.selectByPrimaryKey(unit);

        // 号位的时候buildingSetRoof值为空
        if (unit != null && unit.getBuildUnit() != null) {
            if (unit.getRoomGenerated() != null && unit.getRoomGenerated() == 0) {
                floorListVo.setRoomGenerated((byte) 0);
                floorListVo.setFloors(floorInfoVos);
                return floorListVo;
            }

            buildingSetUnit = unit.getBuildUnit();
            buildingSetRoof = unit.getBuildRoof();
        } else {
            throw new BusinessException("没有获取到该单元信息！");
        }

        ErpBuildingSetFloorExample floorExample = new ErpBuildingSetFloorExample();
        floorExample.setShardCityId(cityId);
        floorExample.createCriteria().andCompIdEqualTo(0)
                .andBuildIdEqualTo(buildId).andBuildingSetUnitIdEqualTo(buildingSetUnitId);
        List<ErpBuildingSetFloor> buildingSetFloors = erpBuildingSetFloorMapper.selectByExample(floorExample);

        // 获取销控表列表
        List<ErpBuildingMarketingControlDto> controls = erpBuildingMarketingControlMapper.getRoomConInfo(cityId, compId, buildId, buildingSetRoof, buildingSetUnit);
        // 组装出售销控信息
        List<RoomConInfoVo> saleConInfos = generateRoomConInfoByCase((byte) 1, buildId, controls, generalParam, true);
        // 组装出租销控信息
        List<RoomConInfoVo> leaseConInfos = generateRoomConInfoByCase((byte) 2, buildId, controls, generalParam, true);

        List<RoomConInfoVo> allRoomConInfo = new ArrayList<>();
        allRoomConInfo.addAll(saleConInfos);
        allRoomConInfo.addAll(leaseConInfos);

        Set<String> allRoomConInfoMd5s = allRoomConInfo.stream().map(RoomConInfoVo::getAddrMd5).collect(Collectors.toSet());

        ErpBuildingSetRoomExample roomExample = new ErpBuildingSetRoomExample();
        roomExample.setShardCityId(cityId);
        roomExample.createCriteria().andCompIdEqualTo(0)
                .andBuildIdEqualTo(buildId).andBuildingSetUnitIdEqualTo(buildingSetUnitId);
        List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.selectByExample(roomExample);

        // 权限判断
		// 销控查看权 BUILD_SELL_CONTROL_TABLE
		ErpUserOpers sellControlTableOper = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "BUILD_SELL_CONTROL_TABLE");
		boolean sellControlTable = null == sellControlTableOper ? false : true;
		
		// 住宅销控查看权 VIEW_MARKETING_CONTROL_HOUSE
		ErpUserOpers viewMarketingControlHouseOper = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "VIEW_MARKETING_CONTROL_HOUSE");
		boolean viewMarketingControlHouse = null == viewMarketingControlHouseOper ? false : true;
		
		// 工商铺销控查看权 VIEW_MARKETING_CONTROL_INDUSTRY
		ErpUserOpers viewMarketingControlIndustryOper = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "VIEW_MARKETING_CONTROL_INDUSTRY");
		boolean viewMarketingControlIndustry = null == viewMarketingControlIndustryOper ? false : true;
		
		// 组装最后数据
        for (ErpBuildingSetFloor buildingSetFloor : buildingSetFloors) {
            FloorInfoVo floorInfoVo = new FloorInfoVo();
            BeanUtils.copyProperties(buildingSetFloor, floorInfoVo);
            floorInfoVo.setBuildingSetFloorId(buildingSetFloor.getId());
            floorInfoVo.setFloorCount(buildingSetFloors.size());

            List<ErpBuildingSetRoom> roomsInFloor = rooms.stream().filter(it -> it.getBuildingSetFloorId().equals(buildingSetFloor.getId())).collect(Collectors.toList());

            List<RoomConInfoInMobileVo> roomConInfos = new ArrayList<>();

            for (ErpBuildingSetRoom room : roomsInFloor) {
                String addrMd5 = room.getAddrMd5();

                RoomConInfoInMobileVo roomConInfoInMobileVo = new RoomConInfoInMobileVo();
                roomConInfoInMobileVo.setBuildId(buildId);
                roomConInfoInMobileVo.setBuildingSetRoof(room.getBuildRoof());
                roomConInfoInMobileVo.setBuildingSetUnit(room.getBuildUnit());
                roomConInfoInMobileVo.setBuildingSetFloor(room.getRoomFloor());
                roomConInfoInMobileVo.setRoomId(room.getRoomId());
				roomConInfoInMobileVo.setSysRoomId(room.getSysRoomId());
				roomConInfoInMobileVo.setBuildingSetRoomId(room.getId());
				roomConInfoInMobileVo.setHouseArea(room.getHouseArea());
				roomConInfoInMobileVo.setHouseDirect(room.getHouseDirect());
				roomConInfoInMobileVo.setHouseRoom(room.getHouseRoom());

                List<RoomConInfoInMobileDetailsVo> funList = new ArrayList<>();

                if (allRoomConInfoMd5s.contains(addrMd5)) {
                    List<RoomConInfoVo> roomConInfoVos = allRoomConInfo.stream().filter(it -> it.getAddrMd5() != null && it.getAddrMd5().equals(addrMd5)).collect(Collectors.toList());

                    if (roomConInfoVos.size() > 0) {
                        for (RoomConInfoVo roomConInfoVo : roomConInfoVos) {
                            RoomConInfoInMobileDetailsVo roomConInfoInMobileDetailsVo = new RoomConInfoInMobileDetailsVo();
							Byte organizationBusinessType = roomConInfoVo.getOrganizationBussinessType();
                            BeanUtils.copyProperties(roomConInfoVo, roomConInfoInMobileDetailsVo);
							
							if (roomConInfoInMobileDetailsVo.getCaseType() != null) {
								// 增加权限判断 销控查看权 工商铺销控查看权 住宅销控查看权 
								// 销控查看权 BUILD_SELL_CONTROL_TABLE：可以查看所有数据，只要有这个权限，相当于不动之前的逻辑
								// 住宅销控查看权 VIEW_MARKETING_CONTROL_HOUSE：没有销控权限时，只能看住宅类型的
								// 工商铺销控查看权 VIEW_MARKETING_CONTROL_INDUSTRY：没有销控查看权时，只能看工商铺类型的
								// 如果三个权限都没有，就返回给前端一个空的list
								if (sellControlTable) { // 有销控查看权
									funList.add(roomConInfoInMobileDetailsVo);
								} else {
									// 组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门
									// 没有销控查看权，有住宅销控查看权，只能看住宅类型的数据
									// 如果同时有住宅销控查看权工商铺销控查看权，则可以看这两种类型的数据
									if (viewMarketingControlHouse && viewMarketingControlIndustry) {
										if (null != organizationBusinessType && (organizationBusinessType == 1 || organizationBusinessType == 2)) {
											funList.add(roomConInfoInMobileDetailsVo);
										}
									} else if (viewMarketingControlHouse && !viewMarketingControlIndustry) {
										if (null != organizationBusinessType && organizationBusinessType == 1) {
											funList.add(roomConInfoInMobileDetailsVo);
										}
									} else if (!viewMarketingControlHouse && viewMarketingControlIndustry) {
										if (null != organizationBusinessType && organizationBusinessType == 2) {
											funList.add(roomConInfoInMobileDetailsVo);
										}
									}
								}
							}
                        }
                    }
                    roomConInfoInMobileVo.setFunList(funList);

                    long saleCount = funList.stream().filter(it -> it.getCaseType() == 1).count();
                    long leaseCount = funList.stream().filter(it -> it.getCaseType() == 2).count();

                    if (saleCount > 0 && leaseCount == 0) {
                        roomConInfoInMobileVo.setShowCaseType((byte) 1);
                    } else if (saleCount == 0 && leaseCount > 0) {
                        roomConInfoInMobileVo.setShowCaseType((byte) 2);
                    } else if (saleCount > 0 && leaseCount > 0) {
                        roomConInfoInMobileVo.setShowCaseType((byte) 3);
                    }

                    roomConInfos.add(roomConInfoInMobileVo);
                } else {
                    RoomConInfoInMobileDetailsVo roomConInfoInMobileDetailsVo = new RoomConInfoInMobileDetailsVo();
                    BeanUtils.copyProperties(room, roomConInfoInMobileDetailsVo);

                    if (roomConInfoInMobileDetailsVo.getCaseType() != null) {
						funList.add(roomConInfoInMobileDetailsVo);
					}
                    roomConInfoInMobileVo.setFunList(funList);

                    roomConInfos.add(roomConInfoInMobileVo);
                }
            }

            floorInfoVo.setRoomConInfos(roomConInfos);
            floorInfoVos.add(floorInfoVo);
        }

        floorListVo.setRoomGenerated((byte) 1);
        floorListVo.setFloors(floorInfoVos);
        return floorListVo;
    }

	/**
	 * exclude: true:去除(房间规则页面) false:不去除(房态表页面)
	 * 在楼盘字典中,更新了房间信息(栋座,单元,楼层,房号名),则在房间规则页面上不显示,但是在房态表中要显示
	 * 判断方式:销控表里面该房源的栋座,单元,楼层,房号名和核心信息中的不一样
	 */
    private List<RoomConInfoVo> generateRoomConInfoByCase(Byte caseType, Integer buildId, List<ErpBuildingMarketingControlDto> controls,
														  GeneralParam generalParam, boolean exclude) {
        Integer cityId = generalParam.getCityId();
        Integer compId = generalParam.getCompId();

        ErpFunCoreInfoExample funCoreInfoExample = new ErpFunCoreInfoExample();
        funCoreInfoExample.setShardCityId(cityId);
        funCoreInfoExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
        List<ErpFunCoreInfo> coreInfos = erpFunCoreInfoMapper.selectByExample(funCoreInfoExample);

        // 出售和出租的核心信息(如果销控表里面有该条数据,栋座单元楼层房号,取销控表的数据显示)
        List<ErpFunCoreInfo> saleCoreInfos = coreInfos.stream().filter(it -> it.getCaseType() == 1).collect(Collectors.toList());
        List<ErpFunCoreInfo> leaseCoreInfos = coreInfos.stream().filter(it -> it.getCaseType() == 2).collect(Collectors.toList());

        // 销控表里面的出售出租信息
        List<ErpBuildingMarketingControlDto> saleControls = controls.stream().filter(it -> it.getCaseType() == 1).collect(Collectors.toList());
        List<ErpBuildingMarketingControlDto> leaseControls = controls.stream().filter(it -> it.getCaseType() == 2).collect(Collectors.toList());

        List<RoomConInfoVo> roomConInfoVos = new ArrayList<>();
        List<ErpFunSale> allSale = new ArrayList<>();
        List<ErpFunLease> allLease = new ArrayList<>();

        int baseCount = 100;

        if (caseType == 1) {
            // 出售类型
            if (saleCoreInfos.size() > 0) {
                for (int i = 0; i < saleCoreInfos.size(); i += baseCount) {
                    List<ErpFunCoreInfo> current = saleCoreInfos.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        Set<Integer> caseIds = current.stream().map(ErpFunCoreInfo::getCaseId).collect(Collectors.toSet());
                        List<ErpFunSale> sales = erpFunSaleMapper.getFunSaleListByCaseIds(cityId, compId, buildId, caseIds);
                        allSale.addAll(sales);
                    }
                }

				Set<Integer> organizationIdList = allSale.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toSet()));
                Map<Integer, ErpFunOrganization> erpFunOrganizationMap = new HashMap<>(organizationIdList.size());
                if(organizationIdList.size() > 0) {
					List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, new ArrayList<>(organizationIdList));
					erpFunOrganizationMap = erpFunOrganizations.stream().collect(Collectors.toMap(val->val.getOrganizationId(), val->val));
				}

				for (ErpFunCoreInfo funCoreInfo : saleCoreInfos) {
                    Optional<ErpFunSale> funSale = allSale.stream().filter(it -> it.getSaleId().equals(funCoreInfo.getCaseId())).findFirst();
                    Optional<ErpBuildingMarketingControlDto> marketingControl = saleControls.stream().filter(it -> it.getCaseId().equals(funCoreInfo.getCaseId())).findFirst();

                    // 房间规则页面, 销控表里面该房源的栋座,单元,楼层,房号名和核心信息中的不一样,则剔除
					if (exclude && marketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = marketingControl.get();
						String buildingSetRoof = dto.getBuildingSetRoof();
						String buildingSetUnit = dto.getBuildingSetUnit();
						String buildingSetFloor = dto.getBuildingSetFloor();
						String roomId = dto.getRoomId();

						if ((funCoreInfo.getHouseRoof() != null && !funCoreInfo.getHouseRoof().equals(buildingSetRoof)) ||
                                (funCoreInfo.getHouseUnit() != null && !funCoreInfo.getHouseUnit().equals(buildingSetUnit)) ||
                                (funCoreInfo.getHouseFloor() != null && !funCoreInfo.getHouseFloor().equals(buildingSetFloor)) ||
                                (funCoreInfo.getRoomId() != null && !funCoreInfo.getRoomId().equals(roomId))) {
							continue;
						}
					}

					RoomConInfoVo roomConInfo = new RoomConInfoVo();
					roomConInfo.setBuildId(buildId);
					roomConInfo.setCaseType((byte) 1);
					roomConInfo.setBuildingSetRoof(funCoreInfo.getHouseRoof());
					roomConInfo.setBuildingSetUnit(funCoreInfo.getHouseUnit());
					roomConInfo.setBuildingSetFloor(funCoreInfo.getHouseFloor());
					roomConInfo.setRoomId(funCoreInfo.getRoomId());
					roomConInfo.setAddrMd5(funCoreInfo.getAddrMd5());
					roomConInfo.setSaleId(funCoreInfo.getCaseId());

                    if (funSale.isPresent()) {
                        ErpFunSale sale = funSale.get();
                        roomConInfo.setSalePrice(sale.getSaleTotalPrice());
                        roomConInfo.setSaleId(sale.getSaleId());
                        roomConInfo.setSaleNo(sale.getSaleNo());
                        roomConInfo.setSaleStatus(sale.getSaleStatus());
                        
                        // 查询房源上的组织的业务类型 用于前端筛选
						if (null != sale.getOrganizationId()) {
							ErpFunOrganization erpFunOrganization = erpFunOrganizationMap.get(sale.getOrganizationId());
							if (null != erpFunOrganization) {
								roomConInfo.setOrganizationBussinessType(erpFunOrganization.getOrganizationBussinessType());
							}
						}
                    }

                    // 如果销控表里面有该条数据,栋座单元楼层房号,取销控表的数据显示
                    if (marketingControl.isPresent()) {
                        ErpBuildingMarketingControlDto dto = marketingControl.get();
                        roomConInfo.setAddrMd5(dto.getMarketingControlMd5());

                        Set<String> md5s = new HashSet<>();
						md5s.add(dto.getMarketingControlMd5());
						// 只会有一条
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);

						if (rooms != null && rooms.size() > 0) {
							ErpBuildingSetRoom room = rooms.get(0);
							roomConInfo.setHouseRoom(room.getHouseRoom());
							roomConInfo.setHouseArea(room.getHouseArea());
							roomConInfo.setHouseDirect(room.getHouseDirect());
						}
                    }

                    roomConInfoVos.add(roomConInfo);
                }
            }
        } else if (caseType == 2) {
            // 出租类型
            if (leaseCoreInfos.size() > 0) {
                for (int i = 0; i < leaseCoreInfos.size(); i += baseCount) {
                    List<ErpFunCoreInfo> current = leaseCoreInfos.stream().skip(i).limit(baseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        Set<Integer> caseIds = current.stream().map(ErpFunCoreInfo::getCaseId).collect(Collectors.toSet());
                        List<ErpFunLease> leases = erpFunLeaseMapper.getFunLeaseListByCaseIds(cityId, compId, buildId, caseIds);
                        allLease.addAll(leases);
                    }
                }

				Set<Integer> organizationIdList = allSale.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toSet()));
				Map<Integer, ErpFunOrganization> erpFunOrganizationMap = new HashMap<>(organizationIdList.size());
				if(organizationIdList.size() > 0) {
					List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, new ArrayList<>(organizationIdList));
					erpFunOrganizationMap = erpFunOrganizations.stream().collect(Collectors.toMap(val->val.getOrganizationId(), val->val));
				}

                for (ErpFunCoreInfo funCoreInfo : leaseCoreInfos) {
                    Optional<ErpFunLease> funLease = allLease.stream().filter(it -> it.getLeaseId().equals(funCoreInfo.getCaseId())).findFirst();
                    Optional<ErpBuildingMarketingControlDto> marketingControl = leaseControls.stream().filter(it -> it.getCaseId().equals(funCoreInfo.getCaseId())).findFirst();

					// 房间规则页面, 销控表里面该房源的栋座,单元,楼层,房号名和核心信息中的不一样,则剔除
					if (exclude && marketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = marketingControl.get();
						String buildingSetRoof = dto.getBuildingSetRoof();
						String buildingSetUnit = dto.getBuildingSetUnit();
						String buildingSetFloor = dto.getBuildingSetFloor();
						String roomId = dto.getRoomId();

                        if ((funCoreInfo.getHouseRoof() != null && !funCoreInfo.getHouseRoof().equals(buildingSetRoof)) ||
                                (funCoreInfo.getHouseUnit() != null && !funCoreInfo.getHouseUnit().equals(buildingSetUnit)) ||
                                (funCoreInfo.getHouseFloor() != null && !funCoreInfo.getHouseFloor().equals(buildingSetFloor)) ||
                                (funCoreInfo.getRoomId() != null && !funCoreInfo.getRoomId().equals(roomId))) {
                            continue;
                        }
					}

					RoomConInfoVo roomConInfo = new RoomConInfoVo();
					roomConInfo.setBuildId(buildId);
					roomConInfo.setCaseType((byte) 2);
					roomConInfo.setBuildingSetRoof(funCoreInfo.getHouseRoof());
					roomConInfo.setBuildingSetUnit(funCoreInfo.getHouseUnit());
					roomConInfo.setBuildingSetFloor(funCoreInfo.getHouseFloor());
					roomConInfo.setRoomId(funCoreInfo.getRoomId());
					roomConInfo.setAddrMd5(funCoreInfo.getAddrMd5());
					roomConInfo.setLeaseId(funCoreInfo.getCaseId());

                    if (funLease.isPresent()) {
                        ErpFunLease lease = funLease.get();
                        roomConInfo.setLeasePrice(lease.getLeaseTotalPrice());
                        roomConInfo.setLeaseId(lease.getLeaseId());
                        roomConInfo.setLeaseNo(lease.getLeaseNo());
                        roomConInfo.setLeasePriceUnit(lease.getPriceUnit());
                        roomConInfo.setLeaseStatus(lease.getLeaseStatus().byteValue());
						roomConInfo.setLessor(lease.getLessor());
	
						// 查询房源上的组织的业务类型 用于前端筛选
						if (null != lease.getOrganizationId()) {
							ErpFunOrganization erpFunOrganization = erpFunOrganizationMap.get(lease.getOrganizationId());
							if (null != erpFunOrganization) {
								roomConInfo.setOrganizationBussinessType(erpFunOrganization.getOrganizationBussinessType());
							}
						}
                    }

                    // 如果销控表里面有该条数据,栋座单元楼层房号,取销控表的数据显示
                    if (marketingControl.isPresent()) {
                        ErpBuildingMarketingControlDto dto = marketingControl.get();
                        roomConInfo.setAddrMd5(dto.getMarketingControlMd5());

						Set<String> md5s = new HashSet<>();
						md5s.add(dto.getMarketingControlMd5());
						// 只会有一条
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);

						if (rooms != null && rooms.size() > 0) {
							ErpBuildingSetRoom room = rooms.get(0);
							roomConInfo.setHouseRoom(room.getHouseRoom());
							roomConInfo.setHouseArea(room.getHouseArea());
							roomConInfo.setHouseDirect(room.getHouseDirect());
						}
                    }

                    roomConInfoVos.add(roomConInfo);
                }
            }
        } else if (caseType == 3) {
            // 同一个房间登记了两个出售房源,三个出租房源,在房态表统计租售房源时,数量为:1,点进去房间列表显示5条

            // 出售房源MD5: 1条
            Set<String> saleMd5s = saleCoreInfos.stream().map(ErpFunCoreInfo::getAddrMd5).collect(Collectors.toSet());
            // 出售房源MD5: 1条
            Set<String> leaseMd5s = leaseCoreInfos.stream().map(ErpFunCoreInfo::getAddrMd5).collect(Collectors.toSet());
            // 租售类型MD5: 1条
            Set<String> saleAndLeaseMd5s = saleMd5s.stream().filter(leaseMd5s::contains).collect(Collectors.toSet());

            // 租售房源的所有的核心信息列表 5条
            List<ErpFunCoreInfo> allSaleAndLeaseFunCoreInfos = new ArrayList<>();

            if (saleAndLeaseMd5s.size() > 0) {
                for (int i = 0; i < saleAndLeaseMd5s.size(); i += baseCount) {
                    List<String> current = saleAndLeaseMd5s.stream().skip(i).limit(baseCount).collect(Collectors.toList());

                    // 2条
                    List<ErpFunCoreInfo> currentSaleCoreInfos = saleCoreInfos.stream()
                            .filter(it -> current.contains(it.getAddrMd5())).collect(Collectors.toList());
                    // 3条
                    List<ErpFunCoreInfo> currentLeaseCoreInfos = leaseCoreInfos.stream()
                            .filter(it -> current.contains(it.getAddrMd5())).collect(Collectors.toList());

                    allSaleAndLeaseFunCoreInfos.addAll(currentSaleCoreInfos);
                    allSaleAndLeaseFunCoreInfos.addAll(currentLeaseCoreInfos);

                    Set<Integer> saleCaseIds = currentSaleCoreInfos.stream().map(ErpFunCoreInfo::getCaseId).collect(Collectors.toSet());
                    List<ErpFunSale> sales = erpFunSaleMapper.getFunSaleListByCaseIds(cityId, compId, buildId, saleCaseIds);
                    allSale.addAll(sales);

                    Set<Integer> leaseCaseIds = currentLeaseCoreInfos.stream().map(ErpFunCoreInfo::getCaseId).collect(Collectors.toSet());
                    List<ErpFunLease> leases = erpFunLeaseMapper.getFunLeaseListByCaseIds(cityId, compId, buildId, leaseCaseIds);
                    allLease.addAll(leases);
                }
            }

            // 5条遍历
            for (ErpFunCoreInfo funCoreInfo : allSaleAndLeaseFunCoreInfos) {
                RoomConInfoVo roomConInfo = new RoomConInfoVo();
                roomConInfo.setBuildId(buildId);
                roomConInfo.setBuildingSetRoof(funCoreInfo.getHouseRoof());
                roomConInfo.setBuildingSetUnit(funCoreInfo.getHouseUnit());
                roomConInfo.setBuildingSetFloor(funCoreInfo.getHouseFloor());
                roomConInfo.setRoomId(funCoreInfo.getRoomId());
                roomConInfo.setAddrMd5(funCoreInfo.getAddrMd5());
                if (funCoreInfo.getCaseType() == 1) {
					roomConInfo.setSaleId(funCoreInfo.getCaseId());
				} else {
					roomConInfo.setLeaseId(funCoreInfo.getCaseId());
				}

                // 看是出租的还是出售的
                Optional<ErpFunSale> funSale = allSale.stream().filter(it -> it.getSaleId().equals(funCoreInfo.getCaseId())).findFirst();
                Optional<ErpFunLease> funLease = allLease.stream().filter(it -> it.getLeaseId().equals(funCoreInfo.getCaseId())).findFirst();

                Integer organizationId = null;
                if (funSale.isPresent()) {
					roomConInfo.setCaseType((byte) 1);
                    ErpFunSale sale = funSale.get();
                    roomConInfo.setSalePrice(sale.getSaleTotalPrice());
                    roomConInfo.setSaleId(sale.getSaleId());
                    roomConInfo.setSaleNo(sale.getSaleNo());
                    roomConInfo.setSaleStatus(sale.getSaleStatus());
					organizationId = sale.getOrganizationId();
                } else if (funLease.isPresent()) {
					roomConInfo.setCaseType((byte) 2);
                    ErpFunLease lease = funLease.get();
                    roomConInfo.setLeasePrice(lease.getLeaseTotalPrice());
                    roomConInfo.setLeaseId(lease.getLeaseId());
                    roomConInfo.setLeaseNo(lease.getLeaseNo());
                    roomConInfo.setLeasePriceUnit(lease.getPriceUnit());
                    roomConInfo.setLeaseStatus(lease.getLeaseStatus().byteValue());
					organizationId = lease.getOrganizationId();
                }
	
				// 查询房源上的组织的业务类型 用于前端筛选
				if (null != organizationId) {
					ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
					if (null != erpFunOrganization) {
						roomConInfo.setOrganizationBussinessType(erpFunOrganization.getOrganizationBussinessType());
					}
				}

                Optional<ErpBuildingMarketingControlDto> saleMarketingControl = saleControls.stream().filter(it -> it.getCaseId().equals(funCoreInfo.getCaseId())).findFirst();
				Optional<ErpBuildingMarketingControlDto> leaseMarketingControl = leaseControls.stream().filter(it -> it.getCaseId().equals(funCoreInfo.getCaseId())).findFirst();

                // 如果销控表里面有该条数据,栋座单元楼层房号,取销控表的数据显示
				if (funSale.isPresent()) {
					// 房间规则页面, 销控表里面该房源的栋座,单元,楼层,房号名和核心信息中的不一样,则剔除
					if (exclude && saleMarketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = saleMarketingControl.get();
						String buildingSetRoof = dto.getBuildingSetRoof();
						String buildingSetUnit = dto.getBuildingSetUnit();
						String buildingSetFloor = dto.getBuildingSetFloor();
						String roomId = dto.getRoomId();

                        if ((funCoreInfo.getHouseRoof() != null && !funCoreInfo.getHouseRoof().equals(buildingSetRoof)) ||
                                (funCoreInfo.getHouseUnit() != null && !funCoreInfo.getHouseUnit().equals(buildingSetUnit)) ||
                                (funCoreInfo.getHouseFloor() != null && !funCoreInfo.getHouseFloor().equals(buildingSetFloor)) ||
                                (funCoreInfo.getRoomId() != null && !funCoreInfo.getRoomId().equals(roomId))) {
                            continue;
                        }
					}

					if (saleMarketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = saleMarketingControl.get();
						roomConInfo.setAddrMd5(dto.getMarketingControlMd5());

						Set<String> md5s = new HashSet<>();
						md5s.add(dto.getMarketingControlMd5());
						// 只会有一条
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);

						if (rooms != null && rooms.size() > 0) {
							ErpBuildingSetRoom room = rooms.get(0);
							roomConInfo.setHouseRoom(room.getHouseRoom());
							roomConInfo.setHouseArea(room.getHouseArea());
							roomConInfo.setHouseDirect(room.getHouseDirect());
						}
					}
				} else if (funLease.isPresent()) {
					// 房间规则页面, 销控表里面该房源的栋座,单元,楼层,房号名和核心信息中的不一样,则剔除
					if (exclude && leaseMarketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = leaseMarketingControl.get();
						String buildingSetRoof = dto.getBuildingSetRoof();
						String buildingSetUnit = dto.getBuildingSetUnit();
						String buildingSetFloor = dto.getBuildingSetFloor();
						String roomId = dto.getRoomId();

                        if ((funCoreInfo.getHouseRoof() != null && !funCoreInfo.getHouseRoof().equals(buildingSetRoof)) ||
                                (funCoreInfo.getHouseUnit() != null && !funCoreInfo.getHouseUnit().equals(buildingSetUnit)) ||
                                (funCoreInfo.getHouseFloor() != null && !funCoreInfo.getHouseFloor().equals(buildingSetFloor)) ||
                                (funCoreInfo.getRoomId() != null && !funCoreInfo.getRoomId().equals(roomId))) {
                            continue;
                        }
					}

					if (leaseMarketingControl.isPresent()) {
						ErpBuildingMarketingControlDto dto = leaseMarketingControl.get();
						roomConInfo.setAddrMd5(dto.getMarketingControlMd5());

						Set<String> md5s = new HashSet<>();
						md5s.add(dto.getMarketingControlMd5());
						// 只会有一条
						List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getRoomListByMd5s(cityId, compId, buildId, md5s);

						if (rooms != null && rooms.size() > 0) {
							ErpBuildingSetRoom room = rooms.get(0);
							roomConInfo.setHouseRoom(room.getHouseRoom());
							roomConInfo.setHouseArea(room.getHouseArea());
							roomConInfo.setHouseDirect(room.getHouseDirect());
						}
					}
				}

                roomConInfoVos.add(roomConInfo);
            }
        }

        // 出租出售房源(删除状态)不返回
		List<RoomConInfoVo> deleteInfos = roomConInfoVos.stream()
				.filter(it -> (it.getSaleStatus() != null && it.getSaleStatus() == 7) || (it.getLeaseStatus() != null && it.getLeaseStatus() == 7))
				.collect(Collectors.toList());
		roomConInfoVos.removeAll(deleteInfos);

        // 租售房源显示判断:在以上的删除状态不返回的基础上 1.如果租售中可售有但是可租没有,则清除可租 2.如果租售中可租有但是可收没有,则清除可售
		if (caseType == 3) {
			roomConInfoVos = roomConInfoVos.stream().filter(it -> it.getAddrMd5() != null).collect(Collectors.toList());
			Set<String> md5s = roomConInfoVos.stream().map(RoomConInfoVo::getAddrMd5).collect(Collectors.toSet());

			for (String md5 : md5s) {
				List<RoomConInfoVo> infoVos = roomConInfoVos.stream().filter(it -> it.getAddrMd5().equals(md5)).collect(Collectors.toList());
				List<RoomConInfoVo> sale =  infoVos.stream().filter(it -> it.getSaleId() != null).collect(Collectors.toList());
				List<RoomConInfoVo> lease =  infoVos.stream().filter(it -> it.getLeaseId() != null).collect(Collectors.toList());

				if (sale.size() == 0 || lease.size() == 0) {
					roomConInfoVos.removeAll(infoVos);
				}
			}
		}

        return roomConInfoVos;
    }

	@Override
	public FunListByCaseIdsVo getFunListByCaseIdsInMobile(CaseIdsParam param, GeneralParam generalParam) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		Integer caseType = param.getCaseType();
		String caseIds = param.getCaseIds();

		if (StringUtils.isBlank(caseIds)) {
			return new FunListByCaseIdsVo();
		}

		String[] ids = caseIds.split(",");

		FunListByCaseIdsVo funListByCaseIdsVo = new FunListByCaseIdsVo();
		List<FunByCaseIdVo> list = new ArrayList<>();

		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunSale> saleList = erpFunSaleMapper.getFunListByCaseIds(cityId, compId, ids);
			for (ErpFunSale erpFunSale : saleList) {
				FunByCaseIdVo funByCaseIdVo = (FunByCaseIdVo) this.assembleDetailMap(erpFunSale);
				list.add(funByCaseIdVo);
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunLease> leaseList = erpFunLeaseMapper.getFunListByCaseIds(cityId, compId, ids);
			for (ErpFunLease erpFunLease : leaseList) {
				FunByCaseIdVo funByCaseIdVo = (FunByCaseIdVo) this.assembleDetailMap(erpFunLease);
				list.add(funByCaseIdVo);
			}
		}
		funListByCaseIdsVo.setList(list);
		return funListByCaseIdsVo;
	}

	private <T> Object assembleDetailMap(T object) {
		if (object instanceof ErpFunSale) {
			FunByCaseIdVo resultData = new FunByCaseIdVo();
			ErpFunSale erpFunSale = (ErpFunSale) object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
			resultData.setBuildId(erpFunSale.getBuildId());
			resultData.setBuildName(erpFunSale.getBuildName());
			resultData.setCaseId(erpFunSale.getSaleId());
			resultData.setHouseArea(erpFunSale.getSaleArea());
			resultData.setRegionName(erpFunSale.getRegionName());
			resultData.setSectionName(erpFunSale.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunSale.getCreationTime()));
			resultData.setHouseUseage(erpFunSale.getSaleUseage());
			resultData.setHouseRoom(erpFunSale.getSaleRoom());
			resultData.setHouseWei(erpFunSale.getSaleWei());
			resultData.setHouseYang(erpFunSale.getSaleYang());
			resultData.setHouseHall(erpFunSale.getSaleHall());
			resultData.setHouseTotalPrice(erpFunSale.getSaleTotalPrice());
			resultData.setHouseLowestPrice(erpFunSale.getSaleLowestPrice());
			// 这里subject是标题，charact是描述。后面产品改成的标题
			resultData.setHouseCharact(erpFunSale.getSaleSubject());
			resultData.setHouseFloor(erpFunSale.getSaleFloor());
			resultData.setHouseFloors(erpFunSale.getSaleFloors());
			resultData.setThumbUrl(StringUtil.getBbsPhoto(erpFunSale.getThumbUrl()));
			resultData.setVideoNum(erpFunSale.getVideoNum());
			resultData.setHasPanorama(erpFunSale.getHasPanorama());
			return resultData;
		} else if (object instanceof ErpFunLease) {
			FunByCaseIdVo resultData = new FunByCaseIdVo();
			ErpFunLease erpFunLease = (ErpFunLease) object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
			resultData.setBuildId(erpFunLease.getBuildId());
			resultData.setBuildName(erpFunLease.getBuildName());
			resultData.setCaseId(erpFunLease.getLeaseId());
			resultData.setHouseArea(erpFunLease.getLeaseArea());
			resultData.setRegionName(erpFunLease.getRegionName());
			resultData.setSectionName(erpFunLease.getSectionName());
			resultData.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunLease.getCreationTime()));
			resultData.setHouseUseage(erpFunLease.getLeaseUseage());
			resultData.setHouseRoom(erpFunLease.getLeaseRoom());
			resultData.setHouseHall(erpFunLease.getLeaseHall());
			resultData.setHouseWei(erpFunLease.getLeaseWei());
			resultData.setHouseYang(erpFunLease.getLeaseYang());
			resultData.setHouseTotalPrice(erpFunLease.getLeaseTotalPrice());
			resultData.setHouseLowestPrice(erpFunLease.getLeaseLowestPrice());
			resultData.setPriceUnit(erpFunLease.getPriceUnit());
			// 这里subject是标题，charact是描述。后面产品改成的标题
			resultData.setHouseCharact(erpFunLease.getLeaseSubject());
			resultData.setHouseFloor(erpFunLease.getLeaseFloor());
			resultData.setHouseFloors(erpFunLease.getLeaseFloors());
			resultData.setVideoNum(erpFunLease.getVideoNum() == null ? 0 : erpFunLease.getVideoNum().byteValue());
			resultData.setHasPanorama(erpFunLease.getHasPanorama());
			resultData.setThumbUrl(StringUtil.getBbsPhoto(erpFunLease.getThumbUrl()));
			return resultData;
		} else if (object instanceof ErpFunBuyCustomer) {
			CustomerByCaseIdVo resultData = new CustomerByCaseIdVo();
			ErpFunBuyCustomer erpFunBuyCustomer = (ErpFunBuyCustomer) object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_BUY_CUST);
			resultData.setCustId(erpFunBuyCustomer.getBuyCustId());
			resultData.setRegionName(erpFunBuyCustomer.getRegionName());
			resultData.setSectionName(erpFunBuyCustomer.getSectionName());
			resultData.setCustName(erpFunBuyCustomer.getBuyCustName());
			resultData.setCustSex(erpFunBuyCustomer.getBuyCustSex() ? (byte) 1 : (byte) 0);
			resultData.setHouseRoom(erpFunBuyCustomer.getHouseRoom());
			resultData.setHouseRoom1(erpFunBuyCustomer.getHouseRoom1());
			resultData.setHouseAreaLow(erpFunBuyCustomer.getHouseAreaLow());
			resultData.setHouseAreaHigh(erpFunBuyCustomer.getHouseAreaHigh());
			resultData.setHousePriceLow(erpFunBuyCustomer.getHousePriceLow());
			resultData.setHousePriceHigh(erpFunBuyCustomer.getHousePriceHigh());
            resultData.setHouseUseage(erpFunBuyCustomer.getHouseUseage());
			return resultData;
		} else if (object instanceof ErpFunRentCustomer) {
			CustomerByCaseIdVo resultData = new CustomerByCaseIdVo();
			ErpFunRentCustomer erpFunRentCustomer = (ErpFunRentCustomer) object;
			resultData.setCaseType(Const.DIC_CASE_TYPE_RENT_CUST);
			resultData.setCustId(erpFunRentCustomer.getRentCustId());
			resultData.setRegionName(erpFunRentCustomer.getRegionName());
			resultData.setSectionName(erpFunRentCustomer.getSectionName());
			resultData.setCustName(erpFunRentCustomer.getRentCustName());
			resultData.setCustSex(erpFunRentCustomer.getRentCustSex() ? (byte) 1 : (byte) 0);
			resultData.setHouseRoom(erpFunRentCustomer.getHouseRoom());
			resultData.setHouseRoom1(erpFunRentCustomer.getHouseRoom1());
			resultData.setHouseAreaLow(erpFunRentCustomer.getHouseAreaLow());
			resultData.setHouseAreaHigh(erpFunRentCustomer.getHouseAreaHigh());
			resultData.setHousePriceLow(erpFunRentCustomer.getHousePriceLow());
			resultData.setHousePriceHigh(erpFunRentCustomer.getHousePriceHigh());
            resultData.setHouseUseage(erpFunRentCustomer.getHouseUseage());
			return resultData;
		}
		return null;
	}

	@Override
	public CustomersByCaseIdsVo getCustomersByCaseIds(CaseIdsParam param, GeneralParam generalParam) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		Integer caseType = param.getCaseType();
		String caseIds = param.getCaseIds();

		if (StringUtils.isBlank(caseIds)) {
			return new CustomersByCaseIdsVo();
		}

		String[] ids = caseIds.split(",");

		CustomersByCaseIdsVo customersByCaseIdsVo = new CustomersByCaseIdsVo();
		List<CustomerByCaseIdVo> list = new ArrayList<>();

		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunBuyCustomer> customers = erpFunBuyCustomerMapper.getCustomersByCaseIds(cityId, compId, ids);
			for (ErpFunBuyCustomer customer : customers) {
				CustomerByCaseIdVo customerByCaseIdVo = (CustomerByCaseIdVo) this.assembleDetailMap(customer);
				list.add(customerByCaseIdVo);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
			List<ErpFunRentCustomer> customers = erpFunRentCustomerMapper.getCustomersByCaseIds(cityId, compId, ids);
			for (ErpFunRentCustomer customer : customers) {
				CustomerByCaseIdVo customerByCaseIdVo = (CustomerByCaseIdVo) this.assembleDetailMap(customer);
				list.add(customerByCaseIdVo);
			}
		}
		customersByCaseIdsVo.setList(list);
		return customersByCaseIdsVo;
	}

	@Override
	public void generateBuildRuleByExcel(GenerateBuildRuleByExcelParam param) {
		String compNo = param.getCompNo();
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		Integer cityId = adminFunComp.getCityId();
		Integer provinceId = adminFunComp.getProvinceId();

		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoEqualTo(compNo);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Integer compId = 0;
		ErpFunComp erpFunComp = new ErpFunComp();
		if (CollectionUtils.isNotEmpty(erpFunComps)) {
			erpFunComp = erpFunComps.get(0);
			compId = erpFunComp.getCompId();
		}

		GeneralParam generalParam = new GeneralParam();
		generalParam.setCityId(cityId);
		generalParam.setCompId(compId);
		generalParam.setCompNo(erpFunComp.getCompNo());
		generalParam.setUserId(Const.DIC_SYSTEM_USERID_999);
		generalParam.setProvinceId(provinceId);

		ErpBuildRuleBatchTempExample erpBuildRuleBatchTempExample = new ErpBuildRuleBatchTempExample();
		erpBuildRuleBatchTempExample.setShardCityId(cityId);
		erpBuildRuleBatchTempExample.createCriteria().andCompIdEqualTo(compId).andRoomGeneratedEqualTo((byte) 0).andBuildNameIsNotNull();
		List<ErpBuildRuleBatchTemp> batchTemps = erpBuildRuleBatchTempMapper.selectByExample(erpBuildRuleBatchTempExample);

		List<String> buildNames = batchTemps.stream()
				.filter(it -> StringUtils.isNotEmpty(it.getBuildName()))
				.map(ErpBuildRuleBatchTemp::getBuildName)
				.distinct()
				.collect(Collectors.toList());

		for (String buildName : buildNames) {
			// 需要导入楼盘规则的数据
			List<ErpBuildRuleBatchTemp> thisBuildTemps = batchTemps.stream().filter(it -> it.getBuildName().equals(buildName)).collect(Collectors.toList());
			if (CollectionUtils.isNotEmpty(thisBuildTemps)) {
				// 查询楼盘信息
				ErpBuildingInfo buildingInfo = erpBuildingInfoMapper.getBuildingInfoByBuildName(cityId, buildName);
				// 没有找到楼盘就继续
				if (buildingInfo == null) {
                    ErpBuildRuleBatchTemp record = new ErpBuildRuleBatchTemp();
                    record.setShardCityId(cityId);
                    // 2表示该楼盘名在BUILDING_INFO表中没有找到
                    record.setRoomGenerated((byte) 2);
                    ErpBuildRuleBatchTempExample example = new ErpBuildRuleBatchTempExample();
                    example.setShardCityId(cityId);
                    example.createCriteria().andCompIdEqualTo(compId).andBuildNameEqualTo(buildName);
                    erpBuildRuleBatchTempMapper.updateByExampleSelective(record, example);
                    continue;
				}
				// 将该公司该楼盘规则锁定
				Integer buildId = buildingInfo.getBuildId();
				BuildRuleAddParam buildRuleAddParam = this.generateRuleParam(thisBuildTemps, buildId);
				try {
                    ErpBuildingSetRoofExample erpBuildingSetRoofExample = new ErpBuildingSetRoofExample();
                    erpBuildingSetRoofExample.setShardCityId(cityId);
                    erpBuildingSetRoofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
                    int roofCount = erpBuildingSetRoofMapper.countByExample(erpBuildingSetRoofExample);
                    if (roofCount > 0) {
						ErpBuildRuleBatchTemp record = new ErpBuildRuleBatchTemp();
						record.setShardCityId(cityId);
						// 3表示楼盘已经有规则
						record.setRoomGenerated((byte) 3);
						ErpBuildRuleBatchTempExample example = new ErpBuildRuleBatchTempExample();
						example.setShardCityId(cityId);
						example.createCriteria().andCompIdEqualTo(compId).andBuildNameEqualTo(buildName);
						erpBuildRuleBatchTempMapper.updateByExampleSelective(record, example);
						continue;
                    }

					String unitIds = erpBuildingSetRoofService.addBuildRule(buildRuleAddParam, generalParam);

					// 将生成的单元id放入 kafka
					if (unitIds.length() > 0) {
						KafkaBizUtils.syncGenerateRoom(cityId, 0, buildId, 2, unitIds, (byte) 1);

						ErpBuildRuleBatchTemp record = new ErpBuildRuleBatchTemp();
						record.setShardCityId(cityId);
						record.setRoomGenerated((byte) 1);
						ErpBuildRuleBatchTempExample example = new ErpBuildRuleBatchTempExample();
						example.setShardCityId(cityId);
						example.createCriteria().andCompIdEqualTo(0).andBuildNameEqualTo(buildName);
						erpBuildRuleBatchTempMapper.updateByExampleSelective(record, example);

						ErpBuildingSetSetting setSetting = erpBuildingSetSettingMapper.selectByBuildId(cityId, 0, buildId);
						if (setSetting == null) {
							ErpBuildingSetSetting condition = new ErpBuildingSetSetting();
							condition.setShardCityId(cityId);
							condition.setCompId(0);
							condition.setBuildId(buildId);
							condition.setCreationTime(new Date());
							condition.setBuildLock((byte) 1);
							erpBuildingSetSettingMapper.insertSelective(condition);
						} else {
							erpBuildingSetSettingMapper.updateBuildLock(cityId, 0, buildId, 1);
						}
					}
				} catch (BusinessException e) {
					ErpBuildRuleBatchTemp record = new ErpBuildRuleBatchTemp();
					record.setShardCityId(cityId);
					// 4表示生成的时候发生错误
					record.setRoomGenerated((byte) 4);
					ErpBuildRuleBatchTempExample example = new ErpBuildRuleBatchTempExample();
					example.setShardCityId(cityId);
					example.createCriteria().andCompIdEqualTo(compId).andBuildNameEqualTo(buildName);
					erpBuildRuleBatchTempMapper.updateByExampleSelective(record, example);

					e.printStackTrace();
				}
			}
		}
	}

	private BuildRuleAddParam generateRuleParam(List<ErpBuildRuleBatchTemp> thisBuildTemps, Integer buildId) {
		BuildRuleAddParam buildRuleAddParam = new BuildRuleAddParam();
		buildRuleAddParam.setBuildId(buildId);

		List<String> buildRoofs = thisBuildTemps.stream()
				.filter(it -> StringUtils.isNotEmpty(it.getBuildRoof()))
				.map(ErpBuildRuleBatchTemp::getBuildRoof)
				.distinct()
				.collect(Collectors.toList());

		List<RoofAddParam> roofs = new ArrayList<>();

		// 每一个栋
		for (String buildRoof : buildRoofs) {
			List<ErpBuildRuleBatchTemp> thisBuildRoofs = thisBuildTemps.stream().filter(it -> it.getBuildRoof().equals(buildRoof)).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(thisBuildRoofs)) {
				continue;
			}
			// 相同的取第一条就行, 公共信息都存里面的
			ErpBuildRuleBatchTemp thisBuildRoof = thisBuildRoofs.get(0);
			// 栋下面对应的单元
			List<ErpBuildRuleBatchTemp> thisUnits = thisBuildTemps.stream()
					.filter(it -> it.getBuildRoof().equals(thisBuildRoof.getBuildRoof()))
					.collect(Collectors.toList());
			buildRuleAddParam.setBuildRoofName(thisBuildRoof.getBuildRoofName());

			List<UnitAddParam> units = new ArrayList<>();
			RoofAddParam roofAddParam = new RoofAddParam();
			roofAddParam.setBuildId(buildId);
			roofAddParam.setBuildRoof(thisBuildRoof.getBuildRoof());
			roofAddParam.setBuildRoofName(thisBuildRoof.getBuildRoofName());
			roofAddParam.setBuildUnitName(thisBuildRoof.getBuildUnitName());
			roofAddParam.setHouseUseage(thisBuildRoof.getHouseUsage());

			// 每个单元
			for (ErpBuildRuleBatchTemp thisUnit : thisUnits) {
				UnitAddParam unitAddParam = new UnitAddParam();
				unitAddParam.setBuildId(buildId);
				unitAddParam.setBuildUnit(thisUnit.getBuildUnit());
				unitAddParam.setBuildUnitName(thisUnit.getBuildUnitName());
				unitAddParam.setFloorStart(thisUnit.getFloorStart());
				unitAddParam.setFloorEnd(thisUnit.getFloorEnd());
				unitAddParam.setBuildLadder(thisUnit.getBuildLadder());
				unitAddParam.setBuildDoors(thisUnit.getBuildDoors());
				unitAddParam.setDoorStart(thisUnit.getDoorStart());
				unitAddParam.setRoomSortRule(thisUnit.getRoomSortRule());
				unitAddParam.setRoomCompositionRule(thisUnit.getRoomCompositionRule());

				Byte roomSortRule = thisUnit.getRoomSortRule();
				Byte roomCompositionRule = thisUnit.getRoomCompositionRule();
				RoomRuleDto roomRuleDto = erpBuildingSetRoofService.generateRoomRule(roomSortRule, roomCompositionRule);
				unitAddParam.setNumberRule(roomRuleDto.getNumberRule());
				unitAddParam.setAddedByAllUnits(roomRuleDto.getAddedByAllUnits());
				unitAddParam.setNumberType(roomRuleDto.getNumberType());
				unitAddParam.setCompriseRule(roomRuleDto.getCompriseRule());
				units.add(unitAddParam);
			}
			roofAddParam.setUnits(units);
			roofs.add(roofAddParam);
		}
		buildRuleAddParam.setRoofs(roofs);

		return buildRuleAddParam;
	}

	@Override
	public void buildRuleAddZero(GenerateBuildRuleByExcelParam param) {
		String compNo = param.getCompNo();
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		Integer cityId = adminFunComp.getCityId();

		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoEqualTo(compNo);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Integer compId = 0;
		ErpFunComp erpFunComp = new ErpFunComp();
		if (CollectionUtils.isNotEmpty(erpFunComps)) {
			erpFunComp = erpFunComps.get(0);
			compId = erpFunComp.getCompId();
		}

		List<ErpBuildingSetRoom> builds = erpBuildingSetRoomMapper.getDistinctBuildId(cityId, compId);

		if (CollectionUtils.isNotEmpty(builds)) {
			for (ErpBuildingSetRoom erpBuildingSetRoom : builds) {
				try {
					Integer buildId = erpBuildingSetRoom.getBuildId();
					List<ErpBuildingSetRoom> rooms = erpBuildingSetRoomMapper.getDistinctBuildIdLessTenFloor(cityId, compId, buildId);

					// 批量添加房间,每次最多一百条
					int batchCount = 100;

					if (rooms.size() > 0) {
						for (int i = 0; i < rooms.size(); i += batchCount) {
							List<ErpBuildingSetRoom> current = rooms.stream().skip(i).limit(batchCount).collect(Collectors.toList());
							if (current.size() > 0) {
								for (ErpBuildingSetRoom currentRoom : current) {
									String roomId = currentRoom.getRoomId();

									if (StringUtils.isNotEmpty(roomId)) {
										// 负楼层 且不是 -0101 这样 -0开头的
										if (roomId.startsWith("-") && !roomId.startsWith("-0")) {
											roomId = "-0" + roomId.substring(1);
										} else if (!roomId.startsWith("-") && !roomId.startsWith("0")) {
											// 正楼层 且不是 0101 这样-0和0开头的
											roomId = "0" + roomId;
										} else {
											continue;
										}
									}

									String newAddMd5 = this.encodeToMD5(buildId, currentRoom.getBuildRoof(), currentRoom.getBuildUnit(), currentRoom.getRoomFloor(), roomId);
									currentRoom.setRoomId(roomId);
									currentRoom.setAddrMd5(newAddMd5);
								}
							}
							erpBuildingSetRoomMapper.batchUpdateRoomMd5InAddZero(cityId, compId, buildId, current);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delBuildRule(GenerateBuildRuleByExcelParam param) {
		String compNo = param.getCompNo();
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		Integer cityId = adminFunComp.getCityId();

		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoEqualTo(compNo);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Integer compId = 0;
		ErpFunComp erpFunComp;
		if (CollectionUtils.isNotEmpty(erpFunComps)) {
			erpFunComp = erpFunComps.get(0);
			compId = erpFunComp.getCompId();
		}

		// 只有栋座单元,没有房号的删除掉重新导入
		List<ErpBuildingSetRoom> builds = erpBuildingSetRoomMapper.getBuildWithoutRoom(cityId, compId);
		// 规则中包含中文括号的
		List<ErpBuildingSetRoom> build1s = erpBuildingSetRoomMapper.getBuildWithBrackets1(cityId, compId);
		List<ErpBuildingSetRoom> build2s = erpBuildingSetRoomMapper.getBuildWithBrackets2(cityId, compId);
		List<ErpBuildingSetRoom> build3s = erpBuildingSetRoomMapper.getBuildWithBrackets3(cityId, compId);
		List<ErpBuildingSetRoom> build4s = erpBuildingSetRoomMapper.getBuildWithBrackets4(cityId, compId);
		builds.addAll(build1s);
		builds.addAll(build2s);
		builds.addAll(build3s);
		builds.addAll(build4s);
		Set<Integer> buildIdSet = builds.stream().map(ErpBuildingSetRoom::getBuildId).collect(Collectors.toSet());

		if (CollectionUtils.isNotEmpty(buildIdSet)) {
			for (Integer buildId : buildIdSet) {
				try {
					erpBuildingSetRoofService.delBuildRuleById(cityId, compId, buildId, Const.DIC_SYSTEM_USERID_999);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}



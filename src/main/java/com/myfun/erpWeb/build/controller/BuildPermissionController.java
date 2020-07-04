package com.myfun.erpWeb.build.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.myfun.erpWeb.build.api.BuildPermissionApi;
import com.myfun.erpWeb.build.param.BuildPermissionListParam;
import com.myfun.erpWeb.build.param.CopyPermissionParam;
import com.myfun.erpWeb.build.param.CreatePermissionParam;
import com.myfun.erpWeb.build.param.DeletePermissionParam;
import com.myfun.erpWeb.build.param.OrganizePermissionListParam;
import com.myfun.erpWeb.build.param.PermissionTrackListParam;
import com.myfun.erpWeb.build.param.ReceiverListParam;
import com.myfun.erpWeb.build.param.UpdatePermissionParam;
import com.myfun.erpWeb.build.vo.BuildPermissionListVO;
import com.myfun.erpWeb.build.vo.BuildPermissionVO;
import com.myfun.erpWeb.build.vo.PermissionTrackListVO;
import com.myfun.erpWeb.build.vo.ReceiverListVO;
import com.myfun.erpWeb.build.vo.ReceiverVO;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpBuildPermissionsMapper;
import com.myfun.repository.erpdb.dao.ErpBuildPermissionsTrackMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserManageRangeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpBuildPermissions;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsExample;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsTrack;
import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationExample;
import com.myfun.repository.erpdb.po.ErpFunReg;
import com.myfun.repository.erpdb.po.ErpFunRegExample;
import com.myfun.repository.erpdb.po.ErpFunUserManageRange;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.service.business.erpdb.ErpBuildPermissionsService;
import com.myfun.utils.DateUtil;

@RestController
public class BuildPermissionController extends BaseController implements BuildPermissionApi {

	@Autowired
	private ErpBuildPermissionsService erpBuildPermissionsService;
	@Autowired
	private ErpBuildPermissionsMapper erpBuildPermissionsMapper;
	@Autowired
	private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	private ErpBuildPermissionsTrackMapper erpBuildPermissionsTrackMapper;
	
	@Override
	public ResponseJson getBuildPermissionList(@RequestBody BuildPermissionListParam param) throws Exception {
		Integer organizationId = param.getOrganizationId();
		Integer buildId = param.getBuildId();
		if (buildId == null) {
			return ErpResponseJson.ok();
		}
//		if (Integer.valueOf(0).equals(organizationId)) {
//			return ErpResponseJson.ok();
//		}
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(cityId, compId.toString(), null, organizationId);
		List<Integer> orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		List<BuildPermissionVO> buildPermissionList = new ArrayList<>();
		// 按楼盘查询
		ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, buildId);
		String buildName = erpBuildingInfo.getBuildName();
		String promotionName = erpBuildingInfo.getPromotionName();
		String buildingUseage = erpBuildingInfo.getBuildingUseage();
		// 查询区域
		ErpFunReg erpFunReg = erpFunRegMapper.selectByPrimaryKey(new ErpFunReg(cityId, erpBuildingInfo.getBuildRegion()));
		String regName = "";
		if (erpFunReg != null) {
			regName = erpFunReg.getRegName();
		}
		// 查询有权限的
		ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
		erpBuildPermissionsExample.setShardCityId(cityId);
		erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andOrganizationIdIn(orgIdList).andIsDelEqualTo(Byte.valueOf("0"));
		List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
		if (!buildPermissionsList.isEmpty()) {
			for (ErpBuildPermissions erpBuildPermissions : buildPermissionsList) {
				BuildPermissionVO buildPermissionVO = new BuildPermissionVO();
				BeanUtils.copyProperties(erpBuildPermissions, buildPermissionVO);
				buildPermissionVO.setPromotionName(promotionName);
				buildPermissionVO.setBuildName(buildName);
				buildPermissionVO.setBuildingUseage(buildingUseage);
				buildPermissionVO.setRegName(regName);
				buildPermissionList.add(buildPermissionVO);
			}
		}
		// 移除有权限的就是没权限的了
		if (!buildPermissionsList.isEmpty()) {
			List<Integer> idList = buildPermissionsList.stream().map(ErpBuildPermissions::getOrganizationId).collect(Collectors.toList());
			orgIdList.removeAll(idList);
		}
		if (!orgIdList.isEmpty()) {
			for (int i = 0;i < orgList.size(); i++) {
				ErpFunOrganization erpFunOrganization = orgList.get(i);
				if (orgIdList.contains(erpFunOrganization.getOrganizationId())) {
					BuildPermissionVO buildPermissionVO = new BuildPermissionVO();
					buildPermissionVO.setBuildId(buildId);
					buildPermissionVO.setPromotionName(promotionName);
					buildPermissionVO.setBuildName(buildName);
					buildPermissionVO.setBuildingUseage(buildingUseage);
					buildPermissionVO.setOrganizationId(erpFunOrganization.getOrganizationId());
					buildPermissionVO.setRegName(regName);
					buildPermissionList.add(buildPermissionVO);
				}
			}
		}
		List<BuildPermissionVO> returnBuildPermissionList = new ArrayList<>();
		for (int i = param.getOffsetNow(); i < buildPermissionList.size(); i++) {
			if (i >= param.getOffsetNow() && i < param.getPageOffset() * param.getPageRows()) {
				returnBuildPermissionList.add(buildPermissionList.get(i));
			}
			if (i == buildPermissionList.size() - 1) {
				break;
			}
		}
		BuildPermissionListVO buildPermissionListVO = new BuildPermissionListVO();
		buildPermissionListVO.setBuildPermissionList(returnBuildPermissionList);
		ErpResponseJson responseJson = ErpResponseJson.ok(buildPermissionListVO);
		responseJson.setTotal(Long.valueOf("" + buildPermissionList.size()));
		return responseJson;
	}
	
	@Override
	public ResponseJson getOrganizePermissionList(@RequestBody OrganizePermissionListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer organizationId = param.getOrganizationId();
		Integer buildId = param.getBuildId();
		Integer buildRegion = param.getBuildRegion();
		Integer houseUseage = param.getHouseUseage();
		Integer hasPermission = param.getHasPermission();
//		if (Integer.valueOf(0).equals(organizationId)) {
//			return ErpResponseJson.ok();
//		}
		List<BuildPermissionVO> buildPermissionList = new ArrayList<>();
		// 查询区域
		Map<Integer, ErpFunReg> regMap = getRegList();
		// 查询有权限的
		List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.getBuildPermissionsList(cityId, compId, organizationId, buildId, buildRegion, houseUseage);
		if (Integer.valueOf("1").equals(hasPermission)) {
			if (!buildPermissionsList.isEmpty()) {
				List<Integer> idList = buildPermissionsList.stream().map(ErpBuildPermissions::getBuildId).collect(Collectors.toList());
				Map<Integer, ErpBuildingInfo> buildMap = this.getBuildInfoByBuildId(idList);
				for (ErpBuildPermissions erpBuildPermissions : buildPermissionsList) {
					BuildPermissionVO buildPermissionVO = new BuildPermissionVO();
					BeanUtils.copyProperties(erpBuildPermissions, buildPermissionVO);
					ErpBuildingInfo erpBuildingInfo = buildMap.get(erpBuildPermissions.getBuildId());
					if (erpBuildingInfo != null) {
						buildPermissionVO.setBuildName(erpBuildingInfo.getBuildName());
						buildPermissionVO.setPromotionName(erpBuildingInfo.getPromotionName());
						ErpFunReg erpFunReg = regMap.get(erpBuildingInfo.getBuildRegion());
						if (erpFunReg != null) {
							buildPermissionVO.setRegName(erpFunReg.getRegName());
						}
						buildPermissionVO.setBuildingUseage(erpBuildingInfo.getBuildingUseage());
					}
					buildPermissionList.add(buildPermissionVO);
				}
			}
		} else {
			List<ErpBuildingInfo> buildList = erpBuildingInfoMapper.getAllBuild(cityId, buildId, buildRegion, houseUseage);
			List<Integer> buildIdList = buildList.stream().map(ErpBuildingInfo::getBuildId).collect(Collectors.toList());
			if (!buildPermissionsList.isEmpty()) {
				List<Integer> idList = buildPermissionsList.stream().map(ErpBuildPermissions::getBuildId).collect(Collectors.toList());
				buildIdList.removeAll(idList);
			}
			if (!buildIdList.isEmpty()) {
				Map<Integer, ErpBuildingInfo> buildMap = buildList.stream().collect(HashMap::new,
						(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
				for (Integer id : buildIdList) {
					ErpBuildingInfo erpBuildingInfo = buildMap.get(id);
					BuildPermissionVO buildPermissionVO = new BuildPermissionVO();
					buildPermissionVO.setBuildId(id);
					buildPermissionVO.setBuildingUseage(erpBuildingInfo.getBuildingUseage());
					buildPermissionVO.setBuildName(erpBuildingInfo.getBuildName());
					buildPermissionVO.setPromotionName(erpBuildingInfo.getPromotionName());
					buildPermissionVO.setOrganizationId(organizationId);
					buildPermissionList.add(buildPermissionVO);
					ErpFunReg erpFunReg = regMap.get(erpBuildingInfo.getBuildRegion());
					if (erpFunReg != null) {
						buildPermissionVO.setRegName(erpFunReg.getRegName());
					}
				}
			}
		}
		List<BuildPermissionVO> returnBuildPermissionList = new ArrayList<>();
		for (int i = param.getOffsetNow(); i < buildPermissionList.size(); i++) {
			if (i >= param.getOffsetNow() && i < param.getPageOffset() * param.getPageRows()) {
				returnBuildPermissionList.add(buildPermissionList.get(i));
			}
			if (i == buildPermissionList.size() - 1) {
				break;
			}
		}
		BuildPermissionListVO buildPermissionListVO = new BuildPermissionListVO();
		buildPermissionListVO.setBuildPermissionList(returnBuildPermissionList);
		ErpResponseJson responseJson = ErpResponseJson.ok(buildPermissionListVO);
		responseJson.setTotal(Long.valueOf("" + buildPermissionList.size()));
		return responseJson;
	}
	
	/**
	 * 查询楼盘
	 * @param buildIdList
	 * @return
	 */
	private Map<Integer, ErpBuildingInfo> getBuildInfoByBuildId(List<Integer> buildIdList) {
		Map<Integer, ErpBuildingInfo> buildMap = new HashMap<>();
		if (buildIdList == null || buildIdList.isEmpty()) {
			return buildMap;
		}
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		List<List<Integer>> buildIdListList = new ArrayList<>();
		Integer buildIdSize = buildIdList.size();
		List<Integer> newBuildIdList = new ArrayList<>();
		for (int i = 0; i < buildIdSize; i++) {
			newBuildIdList.add(buildIdList.get(i));
			if ((i != 0 && i % 1000 == 0) || i == buildIdSize - 1) {
				buildIdListList.add(newBuildIdList);
				newBuildIdList = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < buildIdListList.size(); i++) {
			List<Integer> newidList = buildIdListList.get(i);
			List<ErpBuildingInfo> buildList = erpBuildingInfoMapper.getBuildListByIdList(cityId, newidList);
			Map<Integer, ErpBuildingInfo> map = buildList.stream().collect(HashMap::new,
					(m,b) -> m.put(b.getBuildId(), b), HashMap::putAll);
			buildMap.putAll(map);
		}
		return buildMap;
	}
	

	@Override
	public ResponseJson createPermission(@RequestBody CreatePermissionParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		erpBuildPermissionsService.createPermission(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson updatePermission(@RequestBody UpdatePermissionParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setCompId(operator.getCompId());
		erpBuildPermissionsService.updatePermission(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson deletePermission(@RequestBody DeletePermissionParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setCompId(operator.getCompId());
		erpBuildPermissionsService.deletePermission(param);
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson getReceiverList(@RequestBody ReceiverListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer buildId = param.getBuildId();
		String houseUseage = param.getHouseUseage();
		ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
		erpBuildPermissionsExample.setShardCityId(cityId);
		erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andAddPermissionEqualTo(Byte.valueOf("1")).andBuildIdEqualTo(buildId).andIsDelEqualTo(Byte.valueOf("0")).andHouseUseageLike("%" + houseUseage + "%");
		List<ErpBuildPermissions> buildPermissionsList = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
		if (buildPermissionsList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		List<Integer> orgIdList = buildPermissionsList.stream().map(ErpBuildPermissions::getOrganizationId).collect(Collectors.toList());
		
		// 去掉后勤部门
		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(cityId);
		erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo(Byte.valueOf("0")).andOrganizationIdIn(orgIdList).andOrganizationBussinessTypeNotEqualTo(Byte.valueOf("3"));
		List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
		if (!orgList.isEmpty()) {
			orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		}
		
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andOrganizationIdIn(orgIdList);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		List<ReceiverVO> receiverList = new ArrayList<>();
        ErpUserOpers offereeChoose = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, operator.getUserId(), "ORGANIZATION_OFFEREE_CHOOSE");
        if(offereeChoose == null){//本人
            for (ErpFunUsers erpFunUsers : userList) {
                if(operator.getUserId().equals(erpFunUsers.getUserId())){
                    ReceiverVO receiverVO = new ReceiverVO();
                    BeanUtils.copyProperties(erpFunUsers, receiverVO);
                    receiverList.add(receiverVO);
                }
            }
        }else if(Integer.valueOf("0").equals(offereeChoose.getOrganizationDefinitionId())){//全公司
            for (ErpFunUsers erpFunUsers : userList) {
                ReceiverVO receiverVO = new ReceiverVO();
                BeanUtils.copyProperties(erpFunUsers, receiverVO);
                receiverList.add(receiverVO);
            }
        }else{//自己权限范围内
        	if(offereeChoose.getOrganizationDefinitionId() != null){
				ErpFunOrganizationExample organizationExample = new ErpFunOrganizationExample();
				organizationExample.setShardCityId(cityId);
				organizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationDefinitionIdEqualTo(offereeChoose.getOrganizationDefinitionId());
				List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(organizationExample);
				List<ErpFunUserManageRange> currentUserManageRanges = erpFunUserManageRangeMapper.selectByCompIdAndUserId(cityId, compId, operator.getUserId());
				userList.stream().filter(o->{
					Map<String, Boolean> filterFlag = new HashMap<>();
					filterFlag.put("filterFlag",false);
					erpFunOrganizations.stream().forEach(obj->{
						if(operator.getOrganizationPath().indexOf(obj.getOrganizationId().toString()) != -1
								&& operator.getOrganizationPath().indexOf(obj.getOrganizationId().toString()) <= o.getTissueLine().indexOf(obj.getOrganizationId().toString())){//同个组织下，并且操作者的可选组织层级高于接盘人的
							filterFlag.put("filterFlag",true);
						}
					});
					//当不为只看本人的时候，管理范围内的数据可以查看
					if(!currentUserManageRanges.isEmpty()){
						String tissueLine = o.getTissueLine();
						for (ErpFunUserManageRange currentUserManageRange : currentUserManageRanges) {
							if(tissueLine.contains(currentUserManageRange.getRangeId().toString())){
								filterFlag.put("filterFlag",true);
							}
						}
					}
					return filterFlag.get("filterFlag") || operator.getUserId().equals(o.getUserId());//本人默认允许
				}).forEach(o->{
					ReceiverVO receiverVO = new ReceiverVO();
					BeanUtils.copyProperties(o, receiverVO);
					receiverList.add(receiverVO);
				});
			}else{
				for (ErpFunUsers erpFunUsers : userList) {
					if(operator.getUserId().equals(erpFunUsers.getUserId())){
						ReceiverVO receiverVO = new ReceiverVO();
						BeanUtils.copyProperties(erpFunUsers, receiverVO);
						receiverList.add(receiverVO);
					}
				}
			}
        }
		ReceiverListVO receiverListVO = new ReceiverListVO();
		receiverListVO.setReceiverListVO(receiverList);
		boolean myFlag = false; //本人是否在里面
		for (ReceiverVO receiverVO : receiverList) {
			if (receiverVO.getUserId().equals(operator.getUserId())) {
				myFlag = true;
				break;
			}
		}
		if (!myFlag) {
			ReceiverVO myReceiverVO = new ReceiverVO();
			myReceiverVO.setArchiveId(operator.getArchiveId());
			myReceiverVO.setAreaId(operator.getAreaId());
			myReceiverVO.setDeptId(operator.getDeptId());
			myReceiverVO.setGrId(operator.getGrId());
			myReceiverVO.setOrganizationId(operator.getOrganizationId());
			myReceiverVO.setRegId(operator.getRegId());
			myReceiverVO.setUserId(operator.getUserId());
			myReceiverVO.setUserName(operator.getUserName());
			receiverList.add(myReceiverVO);
		}
		return ErpResponseJson.ok(receiverListVO);
	}
	
	/**
	 * 查询区域列表
	 * @return
	 */
	private Map<Integer, ErpFunReg> getRegList() {
		Operator operator = getOperator();
		ErpFunRegExample erpFunRegExample = new ErpFunRegExample();
		erpFunRegExample.setShardCityId(operator.getCityId());
		erpFunRegExample.createCriteria().andCityIdEqualTo(operator.getCityId().shortValue()).andVertifyFlagEqualTo(Byte.valueOf("1"));
		List<ErpFunReg> list = erpFunRegMapper.selectByExample(erpFunRegExample);
		Map<Integer, ErpFunReg> map = list.stream().collect(HashMap::new,
				(m,r) -> m.put(r.getRegId(), r), HashMap::putAll);
		return map;
	}

	@Override
	public ResponseJson copyPermission(@RequestBody CopyPermissionParam param) throws Exception {
		Operator operator = getOperator();
		String isAll = param.getIsAll();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setCompId(operator.getCompId());
		if ("1".equals(isAll)) {
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(operator.getCityId());
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andIsDelEqualTo(Byte.valueOf("0")).andOrganizationIdEqualTo(param.getOrganizationId());
			List<ErpBuildPermissions> list = erpBuildPermissionsMapper.selectByExample(erpBuildPermissionsExample);
			if (list.isEmpty()) {
				return ErpResponseJson.ok();
			}
			new Thread(new Runnable() {
				@Override
				public void run() {
					StringBuilder buildIds = new StringBuilder();
                    Map<Integer, ErpBuildPermissionsTrack> infoMap = new HashMap<>();//跟进信息map
					for (int i = 0; i < list.size(); i++) {
						ErpBuildPermissions erpBuildPermissions = list.get(i);
						buildIds.append(erpBuildPermissions.getBuildId() + ",");
						if ((i != 0 && i % 500 == 0) || i == list.size() - 1) {
							param.setBuildIds(buildIds.substring(0, buildIds.length() - 1));
							try {
								Map<Integer, ErpBuildPermissionsTrack> trackMap = erpBuildPermissionsService.copyPermission(param);
								infoMap.putAll(trackMap);
							} catch (Exception e) {
								e.printStackTrace();
							}
							buildIds = new StringBuilder();
						}
					}
					for (Integer key : infoMap.keySet()) {
						//新增日志
						ErpBuildPermissionsTrack track = infoMap.get(key);
						track.setCompId(operator.getCompId());
						track.setShardCityId(operator.getCityId());
						track.setTrackType(4);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
						track.setTargetOrganizationId(param.getOrganizationId());//来源组织
						track.setCreationUid(param.getUserId());
						track.setCreationTime(new Date());
						erpBuildPermissionsTrackMapper.insertSelective(track);
					}
				}
			}).start();
		} else {
			erpBuildPermissionsService.copyPermission(param);
		}
		return ErpResponseJson.ok();
	}

	@Override
	public ResponseJson permissionTrackList(@RequestBody PermissionTrackListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setCompId(compId);
		if(!StringUtil.isEmpty(param.getCreationTimeEnd())){
			param.setCreationTimeEnd(DateUtil.addDay(param.getCreationTimeEnd(), 1));
			param.setCreationTimeStrD(DateUtil.StringToDate(param.getCreationTimeStr()));
			param.setCreationTimeEndD(DateUtil.StringToDate(param.getCreationTimeEnd()));
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpBuildPermissionsTrack> trackList = erpBuildPermissionsTrackMapper.selectPermissionTrackList(cityId,param);
		if(trackList.size() == 0){
			return ErpResponseJson.ok();
		}
		//把组织ID和楼盘ID全部拿出来，然后一起查询出名称
		List<PermissionTrackListVO> resList = new ArrayList<>();
		Set<Integer> orgIds = new HashSet<>();
		String buildIds = "";
		for (ErpBuildPermissionsTrack track : trackList) {
			String add = StringUtil.isEmpty(track.getBuildIdsAdd()) ? "" : track.getBuildIdsAdd();
			String edit = StringUtil.isEmpty(track.getBuildIdsEdit()) ? "" : "," + track.getBuildIdsEdit();
			String view = StringUtil.isEmpty(track.getBuildIdsView()) ? "" : "," + track.getBuildIdsView();
			if(!StringUtil.isEmpty(buildIds)){
				buildIds += "," + add + edit + view;
			} else {
				buildIds = add + edit + view;
			}
			orgIds.add(track.getOrganizationId());
			if(null != track.getTargetOrganizationId()){
				orgIds.add(track.getTargetOrganizationId());
			}
		}
		String[] split = buildIds.split(",");
		List<ErpBuildingInfo> erpBuildingInfos =  erpBuildingInfoMapper.selectByBuildIds(cityId,split);
		List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, new ArrayList<>(orgIds));
		Map<Integer,String> permissionsMap = erpBuildingInfos.stream().collect(Collectors.toMap(ErpBuildingInfo :: getBuildId, val -> val.getBuildName()));
		Map<Integer,String> orgMap = erpFunOrganizations.stream().collect(Collectors.toMap(ErpFunOrganization :: getOrganizationId, val -> val.getOrganizationName()));
		for (ErpBuildPermissionsTrack track : trackList) {
			PermissionTrackListVO trackListVO = new PermissionTrackListVO();
			String content = "";
			//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			if(track.getTrackType() == -1 || track.getTrackType() == 0){// -1=修改删除，0=修改新增
				content = this.translateANegative(track,orgMap,permissionsMap);
			} else if(track.getTrackType() == 1){ //1=授权，2=删除
				content = this.translateOne(track,orgMap,permissionsMap);
			} else if(track.getTrackType() == 2){
				content = this.translateTwo(track,orgMap,permissionsMap);
			} else if(track.getTrackType() == 3 || track.getTrackType() == 4){//3=复制，4=全部复制
				content = this.translateThree(track,orgMap,permissionsMap);
			}
			BeanUtils.copyProperties(track,trackListVO);
			trackListVO.setContent(content);
			resList.add(trackListVO);
		}

		ErpResponseJson erpResponseJson = new ErpResponseJson();
		erpResponseJson.setTotal(new PageInfo<>(trackList).getTotal());
		erpResponseJson.setData(resList);
		erpResponseJson.setPageNum(param.getPageOffset());
		erpResponseJson.setPageSize(param.getPageRows());
		return erpResponseJson;
	}

	private String translateANegative(ErpBuildPermissionsTrack track,Map<Integer,String> orgMap,Map<Integer,String> permissionsMap){
		//类型为-1 修改删除	删除该组织某楼盘核心信息查看权、编辑权、登记权
		//类型为0 修改新增	授予该组织某楼盘核心信息查看权、编辑权、登记权
		String content = "授予该组织";
		if(track.getTrackType() == -1){
			content = "删除该组织";
		}
		String buildNameView = "";
		String buildNameEdit = "";
		String buildNameAdd = "";
		if(!StringUtil.isEmpty(track.getBuildIdsView())){//查看权
			String[] buildIds = track.getBuildIdsView().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameView += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameView = StringUtil.isEmpty(buildNameView) ? "" : buildNameView.substring(1,buildNameView.length()) + "核心信息查看权";
		}
		if(!StringUtil.isEmpty(track.getBuildIdsEdit())){//编辑权
			String[] buildIds = track.getBuildIdsEdit().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameEdit += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameEdit = StringUtil.isEmpty(buildNameEdit) ? "" : buildNameEdit.substring(1,buildNameEdit.length()) + "编辑权";
		}
		if(!StringUtil.isEmpty(track.getBuildIdsAdd())){//登记权
			String[] buildIds = track.getBuildIdsAdd().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameAdd += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameAdd = StringUtil.isEmpty(buildNameAdd) ? "" : buildNameAdd.substring(1,buildNameAdd.length()) + "登记权";
		}
		if(StringUtil.isNotEmpty(buildNameEdit) || StringUtil.isNotEmpty(buildNameAdd)){
			buildNameView += "、";
		}
		if(StringUtil.isNotEmpty(buildNameAdd)){
			buildNameEdit += "、";
		}
		String buildUseage = this.translate(track.getHouseUseage(),track.getOldHouseUseage());

		if(track.getTrackType() == 0 && StringUtil.isEmpty(buildNameView) && StringUtil.isEmpty(buildNameEdit) && StringUtil.isEmpty(buildNameAdd)){
			content = "";
			buildUseage = buildUseage.substring(1, buildUseage.length());
		}
		return content + buildNameView + buildNameEdit + buildNameAdd + buildUseage;
	}

	private String translateOne(ErpBuildPermissionsTrack track,Map<Integer,String> orgMap,Map<Integer,String> permissionsMap){
		//类型为1 授予	授予该组织某楼盘核心信息查看权、编辑权、登记权
		String content = "授予该组织";
		if(track.getTrackType() == 2){
			content = "删除该组织";
		}
		String buildNameView = "";
		String buildNameEdit = "";
		String buildNameAdd = "";
		if(!StringUtil.isEmpty(track.getBuildIdsView())){//查看权
			String[] buildIds = track.getBuildIdsView().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameView += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameView = StringUtil.isEmpty(buildNameView) ? "" : buildNameView.substring(1,buildNameView.length()) + "核心信息查看权";
		} else if(!StringUtil.isEmpty(track.getBuildIdsEdit())){//编辑权
			String[] buildIds = track.getBuildIdsEdit().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameEdit += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameEdit = StringUtil.isEmpty(buildNameEdit) ? "" : buildNameEdit.substring(1,buildNameEdit.length()) + "核心信息查看权、编辑权";
		} else if(!StringUtil.isEmpty(track.getBuildIdsAdd())){//登记权
			String[] buildIds = track.getBuildIdsAdd().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameAdd += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameAdd = StringUtil.isEmpty(buildNameAdd) ? "" : buildNameAdd.substring(1,buildNameAdd.length()) + "核心信息查看权、编辑权、登记权";
		}

		String buildUseage = this.translate(track.getHouseUseage(),track.getOldHouseUseage());
		return content + buildNameView + buildNameEdit + buildNameAdd + buildUseage;
	}

	private String translateTwo(ErpBuildPermissionsTrack track,Map<Integer,String> orgMap,Map<Integer,String> permissionsMap){
		//类型为2 删除
		String content = "删除该组织";
		String buildNameView = "";
		String buildNameEdit = "";
		String buildNameAdd = "";
		if(!StringUtil.isEmpty(track.getBuildIdsView())){//查看权
			String[] buildIds = track.getBuildIdsView().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameView += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameView = StringUtil.isEmpty(buildNameView) ? "" : buildNameView.substring(1,buildNameView.length()) + "核心信息查看权";
		}
		if(!StringUtil.isEmpty(track.getBuildIdsEdit())){//编辑权
			String[] buildIds = track.getBuildIdsEdit().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameEdit += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameEdit = StringUtil.isEmpty(buildNameEdit) ? "" : buildNameEdit.substring(1,buildNameEdit.length()) + "核心信息查看权、编辑权";
			if(StringUtil.isNotEmpty(buildNameView)){
				buildNameEdit =  ";" + buildNameEdit;
			}
		}
		if(!StringUtil.isEmpty(track.getBuildIdsAdd())){//登记权
			String[] buildIds = track.getBuildIdsAdd().split(",");
			for (String buildId : buildIds) {
				if(StringUtil.isEmpty(buildId)){
					continue;
				}
				buildNameAdd += "," + permissionsMap.get(Integer.valueOf(buildId));
			}
			buildNameAdd = StringUtil.isEmpty(buildNameAdd) ? "" : buildNameAdd.substring(1,buildNameAdd.length()) + "核心信息查看权、编辑权、登记权";
			if(StringUtil.isNotEmpty(buildNameView) || StringUtil.isNotEmpty(buildNameEdit)){
				buildNameAdd =  ";" + buildNameAdd;
			}
		}

		String buildUseage = this.translate(track.getHouseUseage(),track.getOldHouseUseage());
		return content + buildNameView + buildNameEdit + buildNameAdd + buildUseage;
	}

	private String translateThree(ErpBuildPermissionsTrack track,Map<Integer,String> orgMap,Map<Integer,String> permissionsMap){
		//类型为3 复制	将A组织某楼盘的盘源权限复制给B组织
		String content = "";
		String targetOrgName = orgMap.get(track.getTargetOrganizationId());//A组织
		String orgName = orgMap.get(track.getOrganizationId());//B组织
		String buildNameView = "";
		if(track.getTrackType() == 3){
			if(!StringUtil.isEmpty(track.getBuildIdsView())){//复制权限的楼盘全放在这个字段的
				String[] buildIds = track.getBuildIdsView().split(",");
				for (String buildId : buildIds) {
					if(StringUtil.isEmpty(buildId)){
						continue;
					}
					buildNameView += "," + permissionsMap.get(Integer.valueOf(buildId));
				}
				buildNameView = StringUtil.isEmpty(buildNameView) ? "" : buildNameView.substring(1,buildNameView.length());
			}
			content = "将" + targetOrgName + "的" + buildNameView + "的盘源权限复制给" + orgName;
		} else {
			content = "将" + targetOrgName + "所有盘源权限复制给" + orgName;
		}
		return content;
	}

	private String translate(String houseUseage,String oldHouseUseage){
		String res = "";
		if(StringUtil.isNotEmpty(houseUseage)){
			res = houseUseage.replaceAll("1", "住宅").
					replaceAll("2", "别墅").
					replaceAll("4", "办公").
					replaceAll("3", "商业").
					replaceAll("8", "公寓").
					replaceAll("9", "工业").
					replaceAll("10", "其他").
					replaceAll("\\|", ",");
		}
		if(StringUtil.isNotEmpty(oldHouseUseage)){
			oldHouseUseage = oldHouseUseage.replaceAll("1", "住宅").
					replaceAll("2", "别墅").
					replaceAll("4", "办公").
					replaceAll("3", "商业").
					replaceAll("8", "公寓").
					replaceAll("9", "工业").
					replaceAll("10", "其他").
					replaceAll("\\|", ",");
			if(StringUtil.isNotEmpty(res)){
				res = oldHouseUseage + " --> " + res;
			}
		}
		return StringUtil.isNotEmpty(res) ? ";楼盘用途：" + res : res;
	}


	public static void main(String[] args) {
		String d = "1|3";
		String a = null;
		String b = "1123531,";
		String c = "2,3";

		a = a.replaceAll("1", "住宅").
				replaceAll("2", "别墅").
				replaceAll("4", "办公").
				replaceAll("3", "商业").
				replaceAll("8", "公寓").
				replaceAll("9", "工业").
				replaceAll("10", "其他").
				replaceAll("\\|", "、");
		System.out.println(a);

	}

}

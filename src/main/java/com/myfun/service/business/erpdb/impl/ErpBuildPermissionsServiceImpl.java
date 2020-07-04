package com.myfun.service.business.erpdb.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.ErpBuildPermissionsTrackMapper;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsTrack;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.erpWeb.build.param.CopyPermissionParam;
import com.myfun.erpWeb.build.param.CreatePermissionParam;
import com.myfun.erpWeb.build.param.DeletePermissionParam;
import com.myfun.erpWeb.build.param.Permission;
import com.myfun.erpWeb.build.param.UpdatePermission;
import com.myfun.erpWeb.build.param.UpdatePermissionParam;
import com.myfun.repository.erpdb.dao.ErpBuildPermissionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.po.ErpBuildPermissions;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsExample;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildPermissionsService;
import com.myfun.utils.StringUtil;
import scala.annotation.meta.param;

@Service
public class ErpBuildPermissionsServiceImpl extends AbstractService<ErpBuildPermissions, ErpBuildPermissions>
		implements ErpBuildPermissionsService {

	@Autowired
	private ErpBuildPermissionsMapper erpBuildPermissionsMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpBuildPermissionsTrackMapper erpBuildPermissionsTrackMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBuildPermissionsMapper;
	}

	@Override
	public void createPermission(CreatePermissionParam param) throws Exception {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer userId = param.getUserId();
		Date date = new Date();

		List<Permission> permissionList = param.getPermissionList();

		Map<String, ErpBuildPermissionsTrack> infoMap = new HashMap<>();
		for (Permission permission : permissionList) {
			Integer organizationId = permission.getOrganizationId();
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(cityId,
					compId.toString(), null, organizationId);
			List<Integer> orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId)
					.collect(Collectors.toList());

			// 去掉老的
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(cityId);
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(Byte.valueOf("0"))
					.andOrganizationIdIn(orgIdList).andBuildIdEqualTo(permission.getBuildId());
			ErpBuildPermissions oldBuildPermissions = new ErpBuildPermissions();
			oldBuildPermissions.setIsDel(Byte.valueOf("1"));
			oldBuildPermissions.setUpdateUserId(userId);
			oldBuildPermissions.setUpdateTime(date);
			erpBuildPermissionsMapper.updateByExampleSelective(oldBuildPermissions, erpBuildPermissionsExample);
			// 新增权限
			for (int i = 0; i < orgIdList.size(); i++) {
				ErpBuildPermissions erpBuildPermissions = new ErpBuildPermissions();
				BeanUtils.copyProperties(permission, erpBuildPermissions);
				erpBuildPermissions.setShardCityId(cityId);
				erpBuildPermissions.setCompId(compId);
				erpBuildPermissions.setCreateUserId(userId);
				erpBuildPermissions.setCreateTime(date);
				erpBuildPermissions.setIsDel(Byte.valueOf("0"));
				erpBuildPermissions.setOrganizationId(orgIdList.get(i));
				erpBuildPermissionsMapper.insertSelective(erpBuildPermissions);
				//拼装跟进信息
				String mapKey = orgIdList.get(i).toString();
				if(StringUtil.isNotEmpty(erpBuildPermissions.getHouseUseage())){
					mapKey += "," + erpBuildPermissions.getHouseUseage();
				}
				ErpBuildPermissionsTrack track = null == infoMap.get(mapKey) ? new ErpBuildPermissionsTrack() : infoMap.get(mapKey);
				if(erpBuildPermissions.getAddPermission() == 1){//授权了新增权，那么3个权限都有了
					if(StringUtil.isEmpty(track.getBuildIdsAdd())){//为空，第一次新增这个字段
						track.setBuildIdsAdd(StringUtil.toString(permission.getBuildId(), "0"));
					} else if(track.getBuildIdsAdd().indexOf(permission.getBuildId()) == -1){//判断这个楼盘ID在这个里面没有
						track.setBuildIdsAdd(track.getBuildIdsAdd() + "," + permission.getBuildId());
					}
				} else if (erpBuildPermissions.getEditPermission() == 1){//授权了编辑权，那么就授权了两个权限
					if(StringUtil.isEmpty(track.getBuildIdsEdit())){//为空，第一次新增这个字段
						track.setBuildIdsEdit(StringUtil.toString(permission.getBuildId(), "0"));
					} else if(track.getBuildIdsEdit().indexOf(permission.getBuildId().toString()) == -1){//判断这个楼盘ID在这个里面没有
						track.setBuildIdsEdit(track.getBuildIdsEdit() + "," + permission.getBuildId());
					}
				} else {//只授权了查看权
					if(StringUtil.isEmpty(track.getBuildIdsView())){//为空，第一次新增这个字段
						track.setBuildIdsView(StringUtil.toString(permission.getBuildId(), "0"));
					} else if(track.getBuildIdsView().indexOf(permission.getBuildId()) == -1){//判断这个楼盘ID在这个里面没有
						track.setBuildIdsView(track.getBuildIdsView() + "," + permission.getBuildId());
					}
				}
				if(StringUtil.isNotEmpty(erpBuildPermissions.getHouseUseage())){
					track.setHouseUseage(erpBuildPermissions.getHouseUseage());
				}
				infoMap.put(mapKey, track);
			}
		}
		//key出来的格式会是：组织ID,楼盘用途   10001,1|2|3  所以用逗号分隔取第一个就是组织ID
		for (String key : infoMap.keySet()) {
			//新增日志
			ErpBuildPermissionsTrack track = infoMap.get(key);
			track.setCompId(compId);
			track.setShardCityId(cityId);
			track.setTrackType(1);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			track.setOrganizationId(StringUtil.paseInteger(key.split(",")[0],0));//授权组织
			track.setCreationUid(param.getUserId());
			track.setCreationTime(new Date());
			erpBuildPermissionsTrackMapper.insertSelective(track);
		}

	}

	@Override
	public void updatePermission(UpdatePermissionParam param) throws Exception {
		Integer cityId = param.getCityId();
		Integer userId = param.getUserId();
		Integer selfCompId = param.getCompId();
		Date date = new Date();
		List<UpdatePermission> permissionList = param.getPermissionList();
		Map<String, ErpBuildPermissionsTrack> delInfoMap = new HashMap<>();
		Map<String, ErpBuildPermissionsTrack> addInfoMap = new HashMap<>();
		for (UpdatePermission updatePermission : permissionList) {
			ErpBuildPermissions oldBuildPermissions = erpBuildPermissionsMapper.selectByPrimaryKey(new ErpBuildPermissions(cityId, updatePermission.getBpId()));
			Integer compId = oldBuildPermissions.getCompId();
			Integer orgId = oldBuildPermissions.getOrganizationId();
			Integer buildId = oldBuildPermissions.getBuildId();
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(cityId,
					compId.toString(), null, orgId);
			List<Integer> orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId)
					.collect(Collectors.toList());

			//新增SQL，之前是在下面循环获取每个组织的信息，现在在外面直接拿所有组织信息
			List<ErpBuildPermissions> buildPermissions = erpBuildPermissionsMapper.selectByorgIds(cityId,orgIdList,buildId);
			Map<Integer,ErpBuildPermissions> permissionsMap = buildPermissions.stream().collect(Collectors.toMap(ErpBuildPermissions :: getOrganizationId, val -> val));

			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(cityId);
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andOrganizationIdIn(orgIdList).andIsDelEqualTo(Byte.valueOf("0"));
			
			ErpBuildPermissions erpBuildPermissions = new ErpBuildPermissions();
			erpBuildPermissions.setShardCityId(cityId);
			erpBuildPermissions.setUpdateUserId(userId);
			erpBuildPermissions.setUpdateTime(date);
			if (updatePermission.getAddPermission() != null) {
				erpBuildPermissions.setAddPermission(updatePermission.getAddPermission());
			}
			if (updatePermission.getEditPermission() != null) {
				erpBuildPermissions.setEditPermission(updatePermission.getEditPermission());
			}
			if (updatePermission.getViewPermission() != null) {
				erpBuildPermissions.setViewPermission(updatePermission.getViewPermission());
			}
			if (!StringUtil.isEmpty(updatePermission.getHouseUseage())) {
				erpBuildPermissions.setHouseUseage(updatePermission.getHouseUseage());
			}
			if (updatePermission.getIsUseageSame() != null) {
				erpBuildPermissions.setIsUseageSame(updatePermission.getIsUseageSame());
			}
			// 都为0就删除了
			if (Byte.valueOf("0").equals(updatePermission.getAddPermission())
					&& Byte.valueOf("0").equals(updatePermission.getEditPermission())
					&& Byte.valueOf("0").equals(updatePermission.getViewPermission())) {
				erpBuildPermissions.setIsDel(Byte.valueOf("1"));
			}

			for (Integer org : orgIdList) {//拼接日志信息
				if(null == org || !permissionsMap.containsKey(org)){
					continue;
				}
				String mapKey = org.toString();
				if(StringUtil.isNotEmpty(erpBuildPermissions.getHouseUseage())){
					mapKey += "," + erpBuildPermissions.getHouseUseage();
				}
				ErpBuildPermissions oldPermissions = permissionsMap.get(org);
				ErpBuildPermissionsTrack track = new ErpBuildPermissionsTrack();
				if(null != oldPermissions){
					Integer oldNum = oldPermissions.getAddPermission() + oldPermissions.getEditPermission() + oldPermissions.getViewPermission();
					Integer nowNum = erpBuildPermissions.getAddPermission() + erpBuildPermissions.getEditPermission() + erpBuildPermissions.getViewPermission();
					//判断是新增还是删除 这里修改的话不会涉及到查看权
					if(oldNum > nowNum){//删除
						if(!oldPermissions.getAddPermission().equals(erpBuildPermissions.getAddPermission())){//登记权不一样，意味着删除了登记权
							track = null == delInfoMap.get(mapKey) ? new ErpBuildPermissionsTrack() : track;
							track.setBuildIdsAdd(StringUtil.isEmpty(track.getBuildIdsAdd()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsAdd() + "," + buildId);
							delInfoMap.put(mapKey, track);
						}
						if(!oldPermissions.getEditPermission().equals(erpBuildPermissions.getEditPermission())){//编辑权不一样，意味着删除了编辑权
							track = null == delInfoMap.get(mapKey) ? new ErpBuildPermissionsTrack() : track;
							track.setBuildIdsEdit(StringUtil.isEmpty(track.getBuildIdsEdit()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsEdit() + "," + buildId);
							delInfoMap.put(mapKey, track);
						}
						if(StringUtil.isNotEmpty(erpBuildPermissions.getHouseUseage()) && !erpBuildPermissions.getHouseUseage().equals(oldPermissions.getHouseUseage())){//修改了用途
							track.setHouseUseage(erpBuildPermissions.getHouseUseage());
							track.setOldHouseUseage(oldPermissions.getHouseUseage());
							delInfoMap.put(mapKey, track);
						}
					} else {//新增
						if(!oldPermissions.getAddPermission().equals(erpBuildPermissions.getAddPermission())){//登记权不一样，意味着新增了登记权
							track = null == addInfoMap.get(mapKey) ? new ErpBuildPermissionsTrack() : track;
							track.setBuildIdsAdd(StringUtil.isEmpty(track.getBuildIdsAdd()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsAdd() + "," + buildId);
							addInfoMap.put(mapKey, track);
						}
						if(!oldPermissions.getEditPermission().equals(erpBuildPermissions.getEditPermission())){//编辑权不一样，意味着新增了编辑权
							track = null == addInfoMap.get(mapKey) ? new ErpBuildPermissionsTrack() : track;
							track.setBuildIdsEdit(StringUtil.isEmpty(track.getBuildIdsEdit()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsEdit() + "," + buildId);
							addInfoMap.put(mapKey, track);
						}
						if(StringUtil.isNotEmpty(erpBuildPermissions.getHouseUseage()) && !erpBuildPermissions.getHouseUseage().equals(oldPermissions.getHouseUseage())){//修改了用途
							track.setHouseUseage(erpBuildPermissions.getHouseUseage());
							track.setOldHouseUseage(oldPermissions.getHouseUseage());
							addInfoMap.put(mapKey, track);
						}
					}
				}
			}
			erpBuildPermissionsMapper.updateByExampleSelective(erpBuildPermissions, erpBuildPermissionsExample);
		}
		for (String key : delInfoMap.keySet()) {//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			//新增日志
			ErpBuildPermissionsTrack track = delInfoMap.get(key);
			track.setCompId(selfCompId);
			track.setShardCityId(cityId);
			track.setTrackType(-1);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			track.setOrganizationId(StringUtil.paseInteger(key.split(",")[0],0));//授权组织
			track.setCreationUid(param.getUserId());
			track.setCreationTime(new Date());
			erpBuildPermissionsTrackMapper.insertSelective(track);
		}
		for (String key : addInfoMap.keySet()) {//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			//新增日志
			ErpBuildPermissionsTrack track = addInfoMap.get(key);
			track.setCompId(selfCompId);
			track.setShardCityId(cityId);
			track.setTrackType(0);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			track.setOrganizationId(StringUtil.paseInteger(key.split(",")[0],0));//授权组织
			track.setCreationUid(param.getUserId());
			track.setCreationTime(new Date());
			erpBuildPermissionsTrackMapper.insertSelective(track);
		}
	}

	@Override
	public void deletePermission(DeletePermissionParam param) throws Exception {
		Integer cityId = param.getCityId();
		Integer userId = param.getUserId();
		Date date = new Date();
		String bpIds[] = param.getBpIds().split(",");
		Map<Integer, ErpBuildPermissionsTrack> infoMap = new HashMap<>();
		for (int i = 0; i < bpIds.length; i++) {
			ErpBuildPermissions oldBuildPermissions = erpBuildPermissionsMapper.selectByPrimaryKey(new ErpBuildPermissions(cityId, Integer.parseInt(bpIds[i])));
			Integer compId = oldBuildPermissions.getCompId();
			Integer orgId = oldBuildPermissions.getOrganizationId();
			Integer buildId = oldBuildPermissions.getBuildId();
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(cityId,
					compId.toString(), null, orgId);
			List<Integer> orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId)
					.collect(Collectors.toList());
			//新增SQL，之前是在下面循环获取每个组织的信息，现在在外面直接拿所有组织信息
			List<ErpBuildPermissions> buildPermissions = erpBuildPermissionsMapper.selectByorgIds(cityId,orgIdList,buildId);
			Map<Integer,ErpBuildPermissions> permissionsMap = buildPermissions.stream().collect(Collectors.toMap(ErpBuildPermissions :: getOrganizationId, val -> val));
			for (Integer org : orgIdList) {//拼接日志信息
				if(null == org || !permissionsMap.containsKey(org)){
					continue;
				}
				ErpBuildPermissions erpBuildPermissions = permissionsMap.get(org);
				if(null != erpBuildPermissions){
					if(null != erpBuildPermissions.getAddPermission() && erpBuildPermissions.getAddPermission().equals((byte) 1)){//有登记权,逻辑为有登记权就一定有编辑权和查看权
						ErpBuildPermissionsTrack track = infoMap.get(org);
						if(null == track){
							track = new ErpBuildPermissionsTrack();
						}
						track.setBuildIdsAdd(StringUtil.isEmpty(track.getBuildIdsAdd()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsAdd() + "," + buildId);
						infoMap.put(org, track);
					} else if (null != erpBuildPermissions.getEditPermission() && erpBuildPermissions.getEditPermission().equals((byte) 1)){//有编辑权，有编辑权就一定有查看权
						ErpBuildPermissionsTrack track = infoMap.get(org);
						if(null == track){
							track = new ErpBuildPermissionsTrack();
						}
						track.setBuildIdsEdit(StringUtil.isEmpty(track.getBuildIdsEdit()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsEdit() + "," + buildId);
						infoMap.put(org, track);
					} else {//只有查看权
						ErpBuildPermissionsTrack track = infoMap.get(org);
						if(null == track){
							track = new ErpBuildPermissionsTrack();
						}
						track.setBuildIdsView(StringUtil.isEmpty(track.getBuildIdsView()) ? StringUtil.toString(buildId,"0") : track.getBuildIdsView() + "," + buildId);
						infoMap.put(org, track);
					}
				}
			}

			ErpBuildPermissions erpBuildPermissions = new ErpBuildPermissions();
			erpBuildPermissions.setShardCityId(cityId);
			erpBuildPermissions.setIsDel(Byte.valueOf("1"));
			erpBuildPermissions.setUpdateUserId(userId);
			erpBuildPermissions.setUpdateTime(date);
			ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
			erpBuildPermissionsExample.setShardCityId(cityId);
			erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andOrganizationIdIn(orgIdList).andIsDelEqualTo(Byte.valueOf("0"));
			erpBuildPermissionsMapper.updateByExampleSelective(erpBuildPermissions, erpBuildPermissionsExample);
		}
		for (Integer key : infoMap.keySet()) {
			//新增日志
			ErpBuildPermissionsTrack track = infoMap.get(key);
            track.setCompId(param.getCompId());
			track.setShardCityId(cityId);
			track.setTrackType(2);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
			track.setOrganizationId(key);//授权组织
			track.setCreationUid(param.getUserId());
			track.setCreationTime(new Date());
			erpBuildPermissionsTrackMapper.insertSelective(track);
		}
	}

	@Override
	public Map<Integer, ErpBuildPermissionsTrack> copyPermission(CopyPermissionParam param) throws Exception {
		Date date = new Date();
		Integer cityId = param.getCityId();
		Integer userId = param.getUserId();
		Integer compId = param.getCompId();
		Integer organizationId = param.getOrganizationId();
		String[] buildIdArr = param.getBuildIds().split(",");
		String[] targetOrganizationIds = param.getTargetOrganizationIds().split(",");
		Map<Integer, ErpBuildPermissionsTrack> infoMap = new HashMap<>();//跟进信息map
		for (int i = 0; i < buildIdArr.length; i++) {
			Integer buildId = Integer.parseInt(buildIdArr[i]);
			ErpBuildPermissions erpBuildPermissions = erpBuildPermissionsMapper.getBuildPermissions(cityId, compId,
					organizationId, buildId);
			for (int j = 0; j < targetOrganizationIds.length; j++) {
				Integer targetOrgId = Integer.parseInt(targetOrganizationIds[j]);
				List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectOrgInfoByDefAndOrgId(cityId,
						compId.toString(), null, targetOrgId);
				List<Integer> orgIdList = orgList.stream().map(ErpFunOrganization::getOrganizationId)
						.collect(Collectors.toList());

				// 去掉老的
				ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
				erpBuildPermissionsExample.setShardCityId(cityId);
				erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(Byte.valueOf("0"))
						.andOrganizationIdIn(orgIdList).andBuildIdEqualTo(buildId);
				ErpBuildPermissions oldBuildPermissions = new ErpBuildPermissions();
				oldBuildPermissions.setIsDel(Byte.valueOf("1"));
				oldBuildPermissions.setUpdateUserId(userId);
				oldBuildPermissions.setUpdateTime(date);
				erpBuildPermissionsMapper.updateByExampleSelective(oldBuildPermissions, erpBuildPermissionsExample);
				if (erpBuildPermissions != null) {
					for (int k = 0; k < orgIdList.size(); k++) {
						// 新增
						ErpBuildPermissions targetBuildPermissions = new ErpBuildPermissions();
						targetBuildPermissions.setShardCityId(cityId);
						targetBuildPermissions.setAddPermission(erpBuildPermissions.getAddPermission());
						targetBuildPermissions.setBuildId(buildId);
						targetBuildPermissions.setCompId(erpBuildPermissions.getCompId());
						targetBuildPermissions.setCreateTime(date);
						targetBuildPermissions.setCreateUserId(userId);
						targetBuildPermissions.setEditPermission(erpBuildPermissions.getEditPermission());
						targetBuildPermissions.setOrganizationId(orgIdList.get(k));
						targetBuildPermissions.setHouseUseage(erpBuildPermissions.getHouseUseage());
						targetBuildPermissions.setIsDel(Byte.valueOf("0"));
						targetBuildPermissions.setIsUseageSame(erpBuildPermissions.getIsUseageSame());
						targetBuildPermissions.setViewPermission(erpBuildPermissions.getViewPermission());
						erpBuildPermissionsMapper.insertSelective(targetBuildPermissions);
						//拼装跟进信息
						//复制的文案是：将A组织的某楼盘的盘源权限复制给了B组织，就只需要记录楼盘ID和两个组织ID就好了
						ErpBuildPermissionsTrack track = null == infoMap.get(orgIdList.get(k)) ? new ErpBuildPermissionsTrack() : infoMap.get(orgIdList.get(k));
						if("1".equals(param.getIsAll())){//全部复制
						} else {
							if(StringUtil.isEmpty(track.getBuildIdsView())){
								track.setBuildIdsView(StringUtil.toString(buildId,"0"));
							} else if(track.getBuildIdsView().indexOf(buildId) == -1){//判断这个楼盘ID在这个里面没有
								track.setBuildIdsView(track.getBuildIdsView() + "," + buildId);
							}
						}
						track.setOrganizationId(orgIdList.get(k));//这里写的是目标的楼盘ID，意味着跟进是写在目标的楼盘ID上的，因为来源的楼盘权限其实没有修改。
						infoMap.put(orgIdList.get(k), track);
					}
				}
			}
		}

		if(!"1".equals(param.getIsAll())){
			for (Integer key : infoMap.keySet()) {
				//新增日志
				ErpBuildPermissionsTrack track = infoMap.get(key);
				track.setCompId(compId);
				track.setShardCityId(cityId);
				track.setTrackType(3);//操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制
				track.setTargetOrganizationId(organizationId);//来源组织
				track.setCreationUid(param.getUserId());
				track.setCreationTime(new Date());
				erpBuildPermissionsTrackMapper.insertSelective(track);
			}
		}
		return infoMap;
	}
}

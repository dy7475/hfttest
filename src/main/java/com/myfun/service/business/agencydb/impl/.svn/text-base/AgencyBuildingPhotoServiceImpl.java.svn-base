package com.myfun.service.business.agencydb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.agencydb.dao.AgencyBuildingPhotoMapper;
import com.myfun.repository.agencydb.dao.AgencyFunNewhouseMapper;
import com.myfun.repository.agencydb.dto.AgencyBuildingPhotoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingPhotoParam;
import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;
import com.myfun.repository.agencydb.po.AgencyBuildingPhotoKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBuildingPhotoService;

@Service
public class AgencyBuildingPhotoServiceImpl extends AbstractService<AgencyBuildingPhoto, AgencyBuildingPhotoKey> implements AgencyBuildingPhotoService {
	@Autowired
	private AgencyBuildingPhotoMapper agencyBuildingPhotoMapper;
	@Autowired
	private AgencyFunNewhouseMapper agencyFunNewhouseMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBuildingPhotoMapper;
	}

	@Override
	public PageInfo<AgencyBuildingPhotoDto> getLayoutList(AgencyBuildingPhotoParam agencyBuildingPhotoParam) {
		PageHelper.startPage(agencyBuildingPhotoParam.getPageNum(), agencyBuildingPhotoParam.getPageSize(), true);
		List<AgencyBuildingPhotoDto> resList = agencyBuildingPhotoMapper.getLayoutList(agencyBuildingPhotoParam);
		PageInfo<AgencyBuildingPhotoDto> pageInfo = new PageInfo<>(resList);
		return pageInfo;
	}

	@Transactional
	@Override
	public Integer updateLayout(Integer photoId, Integer layoutId, Integer buildId, Integer oldLayoutId, Integer cityId) {
		// 更新photo表
		AgencyBuildingPhoto agencyBuildingPhoto = new AgencyBuildingPhoto();
		agencyBuildingPhoto.setCityId(cityId.shortValue());
		agencyBuildingPhoto.setBuildId(buildId);
		agencyBuildingPhoto.setPhotoId(photoId);
		agencyBuildingPhoto.setLayoutId(layoutId);
		Integer res = agencyBuildingPhotoMapper.updateByPrimaryKeySelective(agencyBuildingPhoto);
		if(null == oldLayoutId){
			Integer count = agencyBuildingPhotoMapper.getCountByBuildId(buildId);
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("buildMap", count + 1);
			paramMap.put("buildId", buildId);
			Integer res2 = agencyFunNewhouseMapper.updateByBuildId(paramMap);
		}
		return res;
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-26 下午1:57:36
	 */
	@Override
	public PageInfo<AgencyBuildingPhoto> getDistBuildPhotoList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyBuildingPhoto> resList = agencyBuildingPhotoMapper.getDistBuildPhotoList(pMap);
		if(null != resList && resList.size() > 0) {
			for (AgencyBuildingPhoto agencyBuildingPhoto : resList) {
				String pohoAddr = agencyBuildingPhoto.getPhotoAddr();
				agencyBuildingPhoto.setPhotoAddr(CommonUtil.getPhotoUrl(pohoAddr));
			}
		}
		return new PageInfo<>(resList);
	}

	

}

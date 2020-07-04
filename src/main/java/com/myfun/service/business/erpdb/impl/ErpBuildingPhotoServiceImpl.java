package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpBuildingPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingPhotoMapper;
import com.myfun.repository.erpdb.dto.ErpBuildingPhotoDto;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoFastdfs;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingPhotoService;

@Service
public class ErpBuildingPhotoServiceImpl extends AbstractService<ErpBuildingPhoto, ErpBuildingPhotoKey> implements ErpBuildingPhotoService {
	@Autowired
	private ErpBuildingPhotoMapper erpBuildingPhotoMapper;
	@Autowired private ErpBuildingPhotoFastdfsMapper erpBuildingPhotoFastdfsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBuildingPhotoMapper;
	}

	@Override
	public List<ErpBuildingPhotoDto> getPicNumAndPicType(Short cityId, Integer buildId) {
		return erpBuildingPhotoMapper.getPicNumAndPicType(cityId,buildId);
	}

	@Override
	public List<ErpBuildingPhoto> getPhotos(Short cityId, Integer buildId, String type) {
		return erpBuildingPhotoMapper.getRecords(cityId, buildId, type);
	}

	@Override
	public Integer getId(Short shardCityId) {
		return erpBuildingPhotoMapper.getId(shardCityId);
	}

	@Override
	public List<ErpBuildingPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName) {
		Integer photoId = erpBuildingPhotoFastdfsMapper.selectLastPhotoId(shardDbName);
		List<ErpBuildingPhoto> photoList = erpBuildingPhotoMapper.getPhotoListOrderByPhotoIdDesc(shardDbName, photoId);
		if(photoList == null || photoList.size() <= 0) {
			return null;
		}
		List<ErpBuildingPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (ErpBuildingPhoto erpFunPhoto : photoList) {
			ErpBuildingPhotoFastdfs fastdfs = new ErpBuildingPhotoFastdfs();
			fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
			fastdfs.setCreationTime(new Date());
			fastdfs.setOldAddr(erpFunPhoto.getPhotoAddr());
			fastdfsPhotoList.add(fastdfs);
		}
		erpBuildingPhotoFastdfsMapper.insertList(shardDbName, fastdfsPhotoList);
		return photoList;
	}
}

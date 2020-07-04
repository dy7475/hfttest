package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhotoFastdfs;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPhotoService;

@Service
public class ErpFunPhotoServiceImpl extends AbstractService<ErpFunPhoto, ErpFunPhoto>implements ErpFunPhotoService {
	@Autowired
	private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired ErpFunPhotoFastdfsMapper erpFunPhotoFastdfsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunPhotoMapper;
	}
	
	@Override
	public ErpFunPhoto getValidPhotoByPhotoId(Integer photoId, Integer cityId) throws Exception {
		ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
		erpFunPhoto.setShardCityId(cityId);
		erpFunPhoto.setPhotoId(photoId);
		List<ErpFunPhoto> erpFunPhotos = erpFunPhotoMapper.getValidErpFunPhotoByCondition(erpFunPhoto);
		return (erpFunPhotos != null && !erpFunPhotos.isEmpty()) ? erpFunPhotos.get(0) : null;
	}


	@Override
	public List<ErpFunPhoto> getValidPhotosByCondition(Integer caseId, Byte caseType, Integer cityId) throws Exception {
		ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
		erpFunPhoto.setShardCityId(cityId);
		erpFunPhoto.setCaseId(caseId);
		erpFunPhoto.setCaseType(caseType);
		List<ErpFunPhoto> erpFunPhotos = erpFunPhotoMapper.getValidErpFunPhotoByCondition(erpFunPhoto);
		return (erpFunPhotos != null && !erpFunPhotos.isEmpty()) ? erpFunPhotos : null;
	}

	@Override
	public ErpFunPhoto getValidPhotoByIsTop(Integer caseId, Byte caseType, Integer cityId) throws Exception {
		ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
		erpFunPhoto.setShardCityId(cityId);
		erpFunPhoto.setCaseId(caseId);
		erpFunPhoto.setCaseType(caseType);
		erpFunPhoto.setIsTop((byte)1);
		List<ErpFunPhoto> erpFunPhotos = erpFunPhotoMapper.getValidErpFunPhotoByCondition(erpFunPhoto);
		return (erpFunPhotos != null && !erpFunPhotos.isEmpty()) ? erpFunPhotos.get(0) : null;
	}

	@Override
	public List<ErpFunPhoto> getValidPhotosByPhotoType(Integer caseId, Byte caseType, Byte photoType, Integer cityId) throws Exception {
		ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
		erpFunPhoto.setShardCityId(cityId);
		erpFunPhoto.setCaseId(caseId);
		erpFunPhoto.setCaseType(caseType);
		erpFunPhoto.setPhotoType(photoType);
		List<ErpFunPhoto> erpFunPhotos = erpFunPhotoMapper.getValidErpFunPhotoByCondition(erpFunPhoto);
		return (erpFunPhotos != null && !erpFunPhotos.isEmpty()) ? erpFunPhotos : null;
	}

	@Override
	public List<ErpFunPhotoDto> getPhotoList(Integer compId, Integer cityId, Integer caseType, Object[] housingIds) {
		return erpFunPhotoMapper.getPhotoList(compId, cityId, caseType, housingIds);
	}
	
	@Override
	public List<ErpFunPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName) {
		Integer photoId = erpFunPhotoFastdfsMapper.selectLastPhotoId(shardDbName);
		List<ErpFunPhoto> photoList = erpFunPhotoMapper.getPhotoListOrderByPhotoIdDesc(shardDbName, photoId);
		List<ErpFunPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (ErpFunPhoto erpFunPhoto : photoList) {
			ErpFunPhotoFastdfs fastdfs = new ErpFunPhotoFastdfs();
			fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
			fastdfs.setCreationTime(new Date());
			fastdfs.setOldAddr(erpFunPhoto.getPhotoAddr());
			fastdfsPhotoList.add(fastdfs);
		}
		erpFunPhotoFastdfsMapper.insertList(shardDbName, fastdfsPhotoList);
		return photoList;
	}
}

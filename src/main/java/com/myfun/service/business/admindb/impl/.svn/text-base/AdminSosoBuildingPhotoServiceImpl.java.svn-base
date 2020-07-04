package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminSosoBuildingPhotoFastdfsMapper;
import com.myfun.repository.admindb.dao.AdminSosoBuildingPhotoMapper;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhoto;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhotoFastdfs;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminSosoBuildingPhotoService;

/** 
 * 
 */
@Service
public class AdminSosoBuildingPhotoServiceImpl extends AbstractService<AdminSosoBuildingPhoto, Integer> implements AdminSosoBuildingPhotoService {
	@Autowired
	private AdminSosoBuildingPhotoMapper adminSosoBuildingPhotoMapper;
	@Autowired
	private AdminSosoBuildingPhotoFastdfsMapper adminSosoBuildingPhotoFastdfsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminSosoBuildingPhotoMapper;
	}

	@Override
	public List<AdminSosoBuildingPhoto> getPhotoListOrderByPhotoIdDesc() {
		Integer lastPhotoId = adminSosoBuildingPhotoFastdfsMapper.selectLastPhotoId();
		List<AdminSosoBuildingPhoto> photoList = adminSosoBuildingPhotoMapper.getPhotoListOrderByPhotoIdDesc(lastPhotoId);
		if(photoList == null || photoList.size() <= 0) {
			return null;
		}
		List<AdminSosoBuildingPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (AdminSosoBuildingPhoto adminSosoBuildingPhoto : photoList) {
			AdminSosoBuildingPhotoFastdfs fastdfs = new AdminSosoBuildingPhotoFastdfs();
			fastdfs.setPhotoId(adminSosoBuildingPhoto.getPhotoId());
			fastdfs.setCreationTime(new Date());
			fastdfs.setOldAddr(adminSosoBuildingPhoto.getPhotoAddr());
			fastdfsPhotoList.add(fastdfs);
		}
		adminSosoBuildingPhotoFastdfsMapper.insertList(fastdfsPhotoList);
		return photoList;
	}

}

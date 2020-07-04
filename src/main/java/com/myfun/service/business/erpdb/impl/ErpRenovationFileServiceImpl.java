package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpRenovationCustomerFileMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerTrackMapper;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerFile;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpRenovationFileService;

@Service
public class ErpRenovationFileServiceImpl extends AbstractService<ErpRenovationCustomerFile, ErpRenovationCustomerFile> implements ErpRenovationFileService {

	@Autowired
	private ErpRenovationCustomerFileMapper erpRenovationCustomerFileMapper;
	@Autowired
	private ErpRenovationCustomerTrackMapper erpRenovationCustomerTrackMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpRenovationCustomerFileMapper;
	}

	@Transactional
	@Override
	public void addRenovationFile(Integer cityId, Integer compId, Integer userId, Integer archiveId, Integer renovationCustomerId,
			String custPhotos, String otherPhotos, String userName) {
		erpRenovationCustomerFileMapper.updateIsDelByRenovationCustomerId(cityId, compId, renovationCustomerId);
		insertFile(cityId, compId, userId, archiveId, renovationCustomerId, 1, custPhotos, userName);
		insertFile(cityId, compId, userId, archiveId, renovationCustomerId, 2, otherPhotos, userName);
	}
	
	private void insertFile(Integer cityId, Integer compId, Integer userId, Integer archiveId, Integer renovationCustomerId, Integer fileType, String photoAddrs, String userName){
		if(StringUtils.isBlank(photoAddrs)) {
			return;
		}
		String[] photoAddrArr = photoAddrs.split(";");
		for(String photoAddr : photoAddrArr){
			ErpRenovationCustomerFile erpRenovationCustomerFile = new ErpRenovationCustomerFile();
			erpRenovationCustomerFile.setCompId(compId);
			erpRenovationCustomerFile.setUploadUser(userId);
			erpRenovationCustomerFile.setFileAddr(photoAddr);
			erpRenovationCustomerFile.setCreationTime(new Date());
			erpRenovationCustomerFile.setShardCityId(cityId);
			erpRenovationCustomerFile.setFileType(fileType);
			erpRenovationCustomerFile.setRenovationCustomerId(renovationCustomerId);
			erpRenovationCustomerFileMapper.insertSelective(erpRenovationCustomerFile);
			
		}
		String tempStr = null;
		if(fileType == 1){
			tempStr = "客户资料";
		}else if(fileType == 2){
			tempStr = "其他资料";
		}
		String trackContent = userName + "上传了" + photoAddrArr.length + "张" + tempStr;
		ErpRenovationCustomerTrack erpRenovationCustomerTrack = new ErpRenovationCustomerTrack();
		erpRenovationCustomerTrack.setRenovationCustomerId(renovationCustomerId);
		erpRenovationCustomerTrack.setCompId(compId);
		erpRenovationCustomerTrack.setUserId(userId);
		erpRenovationCustomerTrack.setArchiveId(archiveId);
		erpRenovationCustomerTrack.setCreationTime(new Date());
		erpRenovationCustomerTrack.setShardCityId(cityId);
		erpRenovationCustomerTrack.setTrackContent(trackContent);
		erpRenovationCustomerTrack.setTrackType((byte)0);
		erpRenovationCustomerTrackMapper.insertSelective(erpRenovationCustomerTrack);
	}
}

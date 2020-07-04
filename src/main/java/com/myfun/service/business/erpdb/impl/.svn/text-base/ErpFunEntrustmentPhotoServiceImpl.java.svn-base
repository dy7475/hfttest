package com.myfun.service.business.erpdb.impl;


import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminPhotoTmpMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustmentPhotoMapper;
import com.myfun.repository.erpdb.po.ErpFunEntrustmentPhoto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminPhotoTmpService;
import com.myfun.service.business.erpdb.ErpFunEntrustmentPhotoService;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunEntrustmentPhotoServiceImpl extends AbstractService<ErpFunEntrustmentPhoto, ErpFunEntrustmentPhoto> implements ErpFunEntrustmentPhotoService{
	@Autowired AdminPhotoTmpMapper adminPhotoTmpMapper;
	@Autowired AdminPhotoTmpService adminPhotoTmpService;
	@Autowired ErpFunEntrustmentPhotoMapper erpfunEntrustmentPhotoMapper;
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void addFunEntrustmentPhotos(Integer cityId, Integer compId, String urls, Integer caseId, Integer caseType,
			Integer photoType, Integer trackId, Integer userId) {
		if (StringUtils.isBlank(urls)) {
			return;
		}
		String[] urlsArr = urls.split(",");
		// 当前一个带看的房源只有一张图片
		for (String urlTmp : urlsArr) {
			if (StringUtils.isBlank(urlTmp)) {
				continue;
			}
			ErpFunEntrustmentPhoto erpFunEntrustmentPhoto = new ErpFunEntrustmentPhoto();
			erpFunEntrustmentPhoto.setShardCityId(cityId);
			erpFunEntrustmentPhoto.setPhotoAddr(urlTmp);
			erpFunEntrustmentPhoto.setCaseId(caseId);
			erpFunEntrustmentPhoto.setCaseType(caseType.byteValue());
			erpFunEntrustmentPhoto.setCompId(compId);
			erpFunEntrustmentPhoto.setPhotoType(photoType.byteValue());
			erpFunEntrustmentPhoto.setPhotoStatus((byte) 0);
			erpFunEntrustmentPhoto.setTrackId(trackId);
			erpFunEntrustmentPhoto.setUploadUser(userId);
			erpFunEntrustmentPhoto.setUploadDate(DateTimeHelper.formatDateTimetoString(new Date()));
			erpfunEntrustmentPhotoMapper.insertSelective(erpFunEntrustmentPhoto);
		}
		adminPhotoTmpMapper.updatePhotoTmp(urlsArr);
	}

	/**
	 * 覆盖房源委托书附件信息
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param caseId
	 * @param saleLeaseType
	 * @param saleLeaseId
	 */
	@Override
	public void updateFunEntrustmentToInvalid(Integer cityId,Integer compId,Integer caseType, Integer caseId, Integer saleLeaseType,
			Integer saleLeaseId) {
		erpfunEntrustmentPhotoMapper.updateFunEntrustmentToInvalid(cityId,compId,caseType,caseId);
	}

	/**
	 * 更新委托书附件的房源相关信息
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param cityId
	 * @param compId
	 * @param trackId
	 * @param caseType
	 * @param caseId
	 */
	@Override
	public void updateFunEntrustmentCaseInfo(Integer cityId,Integer compId,Integer trackId, Integer caseType, Integer caseId) {
		erpfunEntrustmentPhotoMapper.updateFunEntrustmentCaseInfo(cityId,compId,trackId);
	}
}

package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunEntrustmentPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface  ErpFunEntrustmentPhotoService extends BaseMapper<ErpFunEntrustmentPhoto, ErpFunEntrustmentPhoto>{
	public void addFunEntrustmentPhotos(Integer cityId,Integer compId,String urls, Integer caseId, Integer caseType,Integer photoType, Integer trackId,Integer userId);
	public void updateFunEntrustmentToInvalid(Integer cityId,Integer compId,Integer caseType, Integer caseId , Integer saleLeaseType, Integer saleLeaseId);
	public void updateFunEntrustmentCaseInfo(Integer cityId,Integer compId,Integer trackId, Integer caseType , Integer caseId);
}

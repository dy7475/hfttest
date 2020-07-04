package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.constract.param.UpdateFunDealPhotoParam;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.erpdb.po.ErpFunDealPhotoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface ErpFunDealPhotoService extends BaseMapper<ErpFunDealPhoto, ErpFunDealPhoto>{

	void uploadDealFile(Integer cityId, Integer dealId, Integer photoType, String filePath);

	Map<String, Object> createDealFile(Integer cityId, Integer dealId, Integer photoType);

	List<ErpFunDealPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName);

	void updateAndInsertPhoto(Integer cityId, Integer compId, Integer userId, String photoPath, byte photoType, Integer pellucidity, Byte fileType, Byte fileSubType);

	void updateFunDealPhotoList(UpdateFunDealPhotoParam param, ErpFunDealPhoto dealPhoto, ErpFunDealPhotoExample dealPhotoExample, GeneralParam generalParam,String trackContent);
}

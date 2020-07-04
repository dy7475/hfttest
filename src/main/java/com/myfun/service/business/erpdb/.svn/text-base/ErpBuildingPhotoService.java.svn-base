package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpBuildingPhotoDto;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoKey;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBuildingPhotoService extends BaseMapper<ErpBuildingPhoto, ErpBuildingPhotoKey> {
	public List<ErpBuildingPhotoDto> getPicNumAndPicType(Short cityId, Integer buildId);
	
	/**
	 * 获取全部图片
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	public List<ErpBuildingPhoto> getPhotos(Short cityId, Integer buildId, String type);

	public Integer getId(Short shardCityId);

	List<ErpBuildingPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName);
}

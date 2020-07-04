package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dto.AgencyBuildingPhotoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingPhotoParam;
import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;
import com.myfun.repository.agencydb.po.AgencyBuildingPhotoKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingPhotoService extends BaseMapper<AgencyBuildingPhoto, AgencyBuildingPhotoKey>{

	PageInfo<AgencyBuildingPhotoDto> getLayoutList(AgencyBuildingPhotoParam agencyBuildingPhotoParam);

	Integer updateLayout(Integer photoId, Integer layoutId, Integer buildId,Integer oldLayoutId, Integer cityId);

	PageInfo<AgencyBuildingPhoto> getDistBuildPhotoList(BaseMapParam param); 
}

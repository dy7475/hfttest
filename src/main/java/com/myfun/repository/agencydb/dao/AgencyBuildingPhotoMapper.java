package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myfun.repository.agencydb.dto.AgencyBuildingPhotoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingPhotoParam;
import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;
import com.myfun.repository.agencydb.po.AgencyBuildingPhotoKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBuildingPhotoMapper extends BaseMapper<AgencyBuildingPhoto, AgencyBuildingPhotoKey> {

	List<AgencyBuildingPhotoDto> getLayoutList(AgencyBuildingPhotoParam agencyBuildingPhotoParam);

	Integer getCountByBuildId(Integer buildId);

	Integer deleteLayout(Integer layoutId);

	List<AgencyBuildingPhoto> getDistBuildPhotoList(Map<String, Object> pMap);

	@Select(value="SELECT TOP 100  CITY_ID cityId,BUILD_ID buildId ,PHOTO_ID photoId,PHOTO_TYPE photoType,PHOTO_DESC photoDesc,PHOTO_ADDR photoAddr,IS_FIRST isFirst,LAYOUT_ID layoutId,LAYOUT_FIRST layoutFirst,SEQ_NO seqNo,UPLOAD_USER uploadUser,UPLOAD_DATE uploadDate,EDIT_FLAG editFlag,DEF_FFIMG_FLAG defFfimgFlag,TYPE_SEQ typeSeq FROM BUILDING_PHOTO20170724 WHERE EDIT_FLAG = 1 AND SEQ_NO = #{seqNo}")
	@ResultType(value=AgencyBuildingPhoto.class)
	List<AgencyBuildingPhoto> getTransplantTmpPhoto(Integer seqNo);

	@Update(value="UPDATE top(100) BUILDING_PHOTO20170724 SET EDIT_FLAG = 1,SEQ_NO = #{seqNo} WHERE EDIT_FLAG = 0")
	@ResultType(value=Integer.class)
	Integer lockTransplantTmpPhoto(Integer seqNo);

	@Update(value="UPDATE BUILDING_PHOTO20170724 SET PHOTO_DESC = #{newAddr} , EDIT_FLAG = 2 WHERE PHOTO_ID = #{photoId}")
	void updateTransplantTmpPhotoByPhotoId(@Param("photoId")Integer photoId, @Param("newAddr")String newAddr);

	Integer getMaxPhotoId();
}
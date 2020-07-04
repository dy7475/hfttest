package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.house.param.DeletePanoramaPhotoParam;
import com.myfun.erpWeb.house.param.PanoramaPhotoListParam;
import com.myfun.erpWeb.house.vo.ErpFunPanoramaPhotoVo;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhoto;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhotoExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunPanoramaPhotoMapper extends BaseMapper<ErpFunPanoramaPhoto, ErpFunPanoramaPhoto> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPanoramaPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPanoramaPhotoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPanoramaPhoto> selectByExample(ErpFunPanoramaPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPanoramaPhoto record,
			@Param("example") ErpFunPanoramaPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPanoramaPhoto record,
			@Param("example") ErpFunPanoramaPhotoExample example);

	/**
	 * 根据条件查询全景图片，具体查询条件 请查看mapper
	 * @author 陈文超
	 * @date 2016年6月2日 下午9:27:32
	 */
	List<ErpFunPanoramaPhoto> getPanoramaPhotosByCondition(ErpFunPanoramaPhoto erpFunPanoramaPhoto) throws Exception;
	
	/**
	 * 通过条件查询vr张数
	 * @author 张宏利
	 * @since 2017年4月27日
	 * @param erpFunPanoramaPhoto
	 * @return
	 */
	int getPanoramaCountByCondition(ErpFunPanoramaPhoto erpFunPanoramaPhoto);

	/**
	 * 获取720图片列表
	 * @author 臧铁
	 * @param cityId
	 * @param map   caseId 房客源ID  caseType 房客源类型
	 * @since 2017年5月11日
	 * @return
	 */
	List<ErpFunPanoramaPhotoVo> getPanoramaPhotoList(@Param("shardCityId") Integer cityId, @Param("param") PanoramaPhotoListParam map);

	/**
	 * 获取未删除720图片的数量
	 * @author 臧铁
	 * @param cityId
	 * @param map   caseId 房客源ID  caseType 房客源类型 photoId被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	int getNotDelPanoramaCount(@Param("shardCityId") Integer cityId,  @Param("param") Map<String, Object>  map);

	/**
	 * 删除720图片
	 * @author 臧铁
	 * @param map  caseId 房客源ID  caseType 房客源类型  photoId被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	int deletePanoramaPhoto(@Param("shardCityId")Integer cityId, @Param("param") DeletePanoramaPhotoParam map);
}
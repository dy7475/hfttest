package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpBuildingPhotoDto;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type=SwitchDBType.CITY_ID)
public interface ErpBuildingPhotoMapper extends BaseMapper<ErpBuildingPhoto, ErpBuildingPhotoKey> {
	/**
	 * 查询楼盘相册
	 * @param oldCityId
	 * @param buildId
	 * @return
	 */
	public List<ErpBuildingPhoto> getRecords(@Param("shardCityId")Short oldCityId, @Param("buildId")Integer buildId, @Param("type")String type);

	public Integer getId(@Param("shardCityId")Short shardCityId);

	Integer deleteByBuildId(@Param("shardCityId")Short oldCityId, @Param("oldBuildId")Integer oldBuildId);

	public List<ErpBuildingPhotoDto> getPicNumAndPicType(@Param("shardCityId")Short cityId, @Param("buildId")Integer buildId);

	List<ErpBuildingPhoto> getPhotosByids(@Param("shardCityId")Short cityId, @Param("buildId")Integer buildId, @Param("ids")String[] ids);

	public int countByBuildAndPhotoType(@Param("shardCityId")Short cityId,  @Param("buildId")Integer buildId);

	/**
	 * 获取当前楼盘字典图片列表
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param buildId 楼盘ID
	 * @return
	 * @throws Exception
	 */
	public List<ErpBuildingPhoto> selectBuildDicPhotoList(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId);

	List<ErpBuildingPhoto> getBuildDicPhotoList(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId);

	List<ErpBuildingPhoto> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("photoId")Integer photoId);
	String selectBuildingPhotoAddr(@Param("shardCityId")Integer cityId,@Param("buildId")Integer buildId);
	
	List<ErpBuildingPhoto> getOneRandomBuildPic(@Param("shardCityId")Integer cityId, @Param("ids")Set<Integer> buildIds, @Param("isFirst")Integer isFirst);

    List<ErpBuildingPhoto> getFirstPhotoAddr(@Param("shardCityId")Integer cityId,@Param("list") List<Integer> list,@Param("param") Map<String,Integer> param);

	public Integer getMaxPhotoId(@Param("shardCityId")Integer cityId);

	void deleteByPhotoIds(@Param("shardCityId") Integer cityId, @Param("photoIdSet") Set<Integer> photoId);
}
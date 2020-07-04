package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunDealPhotoDto;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealPhotoExample;

public interface ErpFunDealPhotoMapper extends BaseMapper<ErpFunDealPhoto, ErpFunDealPhoto> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealPhotoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealPhoto> selectByExample(ErpFunDealPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealPhoto record,
			@Param("example") ErpFunDealPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealPhoto record, @Param("example") ErpFunDealPhotoExample example);

	int getPhotoTypeCount(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("photoType") Integer photoType);

	List<ErpFunDealPhoto> getDealFiles(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("dealId") Integer dealId,@Param("photoType") Integer fileType);

	List<ErpFunDealPhoto> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("photoId")Integer photoId);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    List<ErpFunDealPhotoDto> getDealPhotoList(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId, @Param("photoTypes")List<Integer> photoTypes);

	void updateTransmitFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("photoType")byte photoType);
}
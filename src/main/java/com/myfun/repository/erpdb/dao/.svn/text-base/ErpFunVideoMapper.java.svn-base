package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.house.param.GetVideoListParam;
import com.myfun.erpWeb.house.vo.ErpFunVideoVo;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.erpdb.po.ErpFunVideoExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunVideoMapper extends BaseMapper<ErpFunVideo, ErpFunVideo> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunVideoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunVideoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunVideo> selectByExample(ErpFunVideoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunVideo record, @Param("example") ErpFunVideoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunVideo record, @Param("example") ErpFunVideoExample example);

	@SwitchDB(type=SwitchDBType.DB_NAME)
	List<ErpFunVideo> getFunVideoByFunSaleNotTopThumbForPage(String shardDbName);

	@SwitchDB(type = SwitchDBType.DB_NAME)
	List<ErpFunVideo> getFunVideoByFunLeaseNotTopThumbForPage(String shardDbName);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunVideo> getValidErpFunVideoByCondition(ErpFunVideo erpFunVideo);
	@SwitchDB(type = SwitchDBType.DB_NAME)
	List<ErpFunVideo> getVideoListOrderByVideoIdDesc(@Param("shardDbName")String shardDbName,
			@Param("videoId")Integer videoId);

	/**
	 * 获取视频列表
	 * @author 臧铁
	 * @param map  caseId 房客源ID  caseType 房客源类型
	 * @since 2017年5月16日
	 * @return
	 */
	List<ErpFunVideoVo> getVideoList(@Param("shardCityId")Integer cityId, @Param("param") GetVideoListParam map);
	
	/**
	 * 获取审核通过的视频
	 *@author 朱科
	 *@param 
	 *@return Integer
	 *@since 2018年2月12日
	 */
	Integer getVideoCount(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);

	Integer delVideo(@Param("shardCityId")Integer cityId, @Param("videoId")Integer videoId);
}
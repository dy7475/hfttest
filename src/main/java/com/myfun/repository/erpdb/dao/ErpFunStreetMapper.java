package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.StreetDataListParam;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpFunStreetSectionVO;
import com.myfun.repository.erpdb.po.ErpFunStreet;
import com.myfun.repository.erpdb.po.ErpFunStreetExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetMapper extends BaseMapper<ErpFunStreet, ErpFunStreet> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunStreetExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunStreetExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunStreet> selectByExample(ErpFunStreetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunStreet record, @Param("example") ErpFunStreetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunStreet record, @Param("example") ErpFunStreetExample example);

	List<ErpFunStreet> getStreetList(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("param") StreetDataListParam param);

	List<ErpFunStreet> getStreetListBySection(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("param") StreetDataListParam param);

	int deleteStreetById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
								@Param("id") Integer id, @Param("delUserId") Integer delUserId);

	int getMaxId(@Param("shardCityId") Integer shardCityId);

	List<ErpFunStreet> getStreetListByName(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("streetName") String streetName);

}
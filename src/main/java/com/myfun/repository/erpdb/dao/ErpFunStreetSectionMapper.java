package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.StreetSectionListParam;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpFunStreetSectionVO;
import com.myfun.repository.erpdb.po.ErpFunStreetSection;
import com.myfun.repository.erpdb.po.ErpFunStreetSectionExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetSectionMapper extends BaseMapper<ErpFunStreetSection, ErpFunStreetSection> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunStreetSectionExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunStreetSectionExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunStreetSection> selectByExample(ErpFunStreetSectionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunStreetSection record,
			@Param("example") ErpFunStreetSectionExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunStreetSection record,
			@Param("example") ErpFunStreetSectionExample example);

	List<ErpFunStreetSectionVO> getStreetSectionList(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("param") StreetSectionListParam param);

	int deleteStreetSectionById(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId,
								@Param("id") Integer id, @Param("delUserId") Integer delUserId);

	int getMaxId(@Param("shardCityId") Integer shardCityId);

}
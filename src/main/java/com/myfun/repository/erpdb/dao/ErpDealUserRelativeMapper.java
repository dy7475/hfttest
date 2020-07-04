package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpDealUserRelative;
import com.myfun.repository.erpdb.po.ErpDealUserRelativeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpDealUserRelativeMapper extends BaseMapper<ErpDealUserRelative, ErpDealUserRelative> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpDealUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpDealUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpDealUserRelative> selectByExample(ErpDealUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpDealUserRelative record,
			@Param("example") ErpDealUserRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpDealUserRelative record,
			@Param("example") ErpDealUserRelativeExample example);

	@SwitchDB(type= SwitchDBType.CITY_ID)
    Integer countModelData(@Param("shardCityId")Integer cityId,@Param("param") ErpDealUserRelative erpDealUserRelative, @Param("operIds")List<String> operIds);

	int insertSelectiveNewOrg(@Param("param") ErpDealUserRelative dealUserRelative,@Param("dbFieldPath") String dbFieldPath,@Param("orgIds") String orgIds);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.vo.EntrustFilesVO;
import com.myfun.repository.erpdb.po.ErpFunEntrustFiles;
import com.myfun.repository.erpdb.po.ErpFunEntrustFilesExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunEntrustFilesMapper extends BaseMapper<ErpFunEntrustFiles, ErpFunEntrustFiles> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEntrustFilesExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEntrustFilesExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEntrustFiles> selectByExample(ErpFunEntrustFilesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEntrustFiles record,
			@Param("example") ErpFunEntrustFilesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEntrustFiles record,
			@Param("example") ErpFunEntrustFilesExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<EntrustFilesVO> selectByEntrustIds(@Param("shardCityId") Integer cityId, @Param("entrustIds") List<Integer> entrustIds);
}
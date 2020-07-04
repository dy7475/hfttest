package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.common.vo.ErpFunRegVo;
import com.myfun.repository.erpdb.po.ErpFunReg;
import com.myfun.repository.erpdb.po.ErpFunRegExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRegMapper extends BaseMapper<ErpFunReg, ErpFunReg> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRegExample example);


	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRegExample example);


	/**
	 * @mbggenerated
	 */
	List<ErpFunReg> selectByExample(ErpFunRegExample example);


	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunReg record, @Param("example") ErpFunRegExample example);


	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunReg record, @Param("example") ErpFunRegExample example);


	List<ErpFunReg> getRegListByCityId(@Param("shardCityId") Integer cityId);
	
	
	List<ErpFunReg> getRegListByVertifyFlag(@Param("shardCityId") Integer cityId, @Param("vertifyFlag") Integer vertifyFlag);

    List<ErpFunRegVo> getRegVoListByCityId(@Param("shardCityId") Integer cityId);
}
package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyBeuse400;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBeuse400Mapper extends BaseMapper<AgencyBeuse400, String>{
    /**
     *
     * @mbggenerated
     */
    int insert(AgencyBeuse400 record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyBeuse400 record);
    
    /**
	 * 查询列表
	 * @param occupy
	 * @return
	 */
	public List<AgencyBeuse400> getListByOccUpy(String occupy);
	
	/**
	 * 更新occupy
	 * @param record
	 * @return
	 */
	public int updateOccupy(AgencyBeuse400 record);
	
	/**
	 * 获取400电话
	 * @param i
	 * @return
	 */
	AgencyBeuse400 getOccupy(@Param("occupy")int occupy);
}
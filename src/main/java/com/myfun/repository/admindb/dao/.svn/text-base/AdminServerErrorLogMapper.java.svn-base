package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminServerErrorLog;
import com.myfun.repository.admindb.po.AdminServerErrorLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminServerErrorLogMapper extends BaseMapper<AdminServerErrorLog, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminServerErrorLog> selectByExampleWithBLOBs(AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminServerErrorLog> selectByExample(AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminServerErrorLog record, @Param("example") AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") AdminServerErrorLog record, @Param("example") AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminServerErrorLog record, @Param("example") AdminServerErrorLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminServerErrorLog record);

	List<AdminServerErrorLog> getErrorLogList(@Param("tableEnd") String tableEnd);
	
	void deleteErrorLog(@Param("tableEnd") String tableEnd, @Param("idList") List<Integer> idList);
}
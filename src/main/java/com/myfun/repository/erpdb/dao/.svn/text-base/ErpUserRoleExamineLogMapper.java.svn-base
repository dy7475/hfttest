package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpUserRoleExamineLog;
import com.myfun.repository.erpdb.po.ErpUserRoleExamineLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpUserRoleExamineLogMapper extends BaseMapper<ErpUserRoleExamineLog, ErpUserRoleExamineLog> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpUserRoleExamineLogExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpUserRoleExamineLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpUserRoleExamineLog> selectByExample(ErpUserRoleExamineLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpUserRoleExamineLog record, @Param("example") ErpUserRoleExamineLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpUserRoleExamineLog record, @Param("example") ErpUserRoleExamineLogExample example);

    
	List<ErpUserRoleExamineLog> getListLog(@Param("shardCityId") Integer shardCityId,@Param("compId")Integer compId, @Param("time")Date time, @Param("userIds")Set<Integer> userIds);

	
}
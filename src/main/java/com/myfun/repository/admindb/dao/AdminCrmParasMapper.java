package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCrmParas;
import com.myfun.repository.admindb.po.AdminCrmParasExample;
import com.myfun.repository.admindb.po.AdminCrmParasKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCrmParasMapper extends BaseMapper<AdminCrmParas, AdminCrmParas> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCrmParasExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCrmParasExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCrmParas> selectByExample(AdminCrmParasExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCrmParas record, @Param("example") AdminCrmParasExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCrmParas record, @Param("example") AdminCrmParasExample example);

    AdminCrmParas selectCrmParaValue(AdminCrmParasKey crmParasKey);
}
package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunDeptsActivityPaid;
import com.myfun.repository.admindb.po.AdminFunDeptsActivityPaidExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunDeptsActivityPaidMapper extends BaseMapper<AdminFunDeptsActivityPaid, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunDeptsActivityPaidExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunDeptsActivityPaidExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunDeptsActivityPaid> selectByExample(AdminFunDeptsActivityPaidExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunDeptsActivityPaid record, @Param("example") AdminFunDeptsActivityPaidExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunDeptsActivityPaid record, @Param("example") AdminFunDeptsActivityPaidExample example);
}
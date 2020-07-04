package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCrmPaymentTasks;
import com.myfun.repository.admindb.po.AdminCrmPaymentTasksExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCrmPaymentTasksMapper extends BaseMapper<AdminCrmPaymentTasks, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCrmPaymentTasksExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCrmPaymentTasksExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCrmPaymentTasks> selectByExample(AdminCrmPaymentTasksExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCrmPaymentTasks record, @Param("example") AdminCrmPaymentTasksExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCrmPaymentTasks record, @Param("example") AdminCrmPaymentTasksExample example);

    AdminCrmPaymentTasks getCrmPaymentTasks(@Param("adminDeptId")Integer adminDeptId);
}
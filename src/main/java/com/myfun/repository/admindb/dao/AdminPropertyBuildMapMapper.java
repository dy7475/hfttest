package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminPropertyBuildMap;
import com.myfun.repository.admindb.po.AdminPropertyBuildMapExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPropertyBuildMapMapper extends BaseMapper<AdminPropertyBuildMap, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminPropertyBuildMapExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminPropertyBuildMapExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminPropertyBuildMap> selectByExample(AdminPropertyBuildMapExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminPropertyBuildMap record, @Param("example") AdminPropertyBuildMapExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminPropertyBuildMap record, @Param("example") AdminPropertyBuildMapExample example);
}
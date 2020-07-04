package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFddCity;
import com.myfun.repository.admindb.po.AdminFddCityExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFddCityMapper extends BaseMapper<AdminFddCity, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFddCityExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFddCityExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFddCity> selectByExample(AdminFddCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFddCity record, @Param("example") AdminFddCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFddCity record, @Param("example") AdminFddCityExample example);
}
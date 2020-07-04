package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminKjlNewCityRela;
import com.myfun.repository.admindb.po.AdminKjlNewCityRelaExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminKjlNewCityRelaMapper extends BaseMapper<AdminKjlNewCityRela, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminKjlNewCityRelaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminKjlNewCityRelaExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminKjlNewCityRela> selectByExample(AdminKjlNewCityRelaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminKjlNewCityRela record, @Param("example") AdminKjlNewCityRelaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminKjlNewCityRela record, @Param("example") AdminKjlNewCityRelaExample example);

	AdminKjlNewCityRela getKjlNewCityRelaByCityId(@Param("cityId")Integer cityId);
}
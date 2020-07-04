package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyYoujiaUser;
import com.myfun.repository.agencydb.po.AgencyYoujiaUserExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyYoujiaUserMapper extends BaseMapper<AgencyYoujiaUser, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyYoujiaUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyYoujiaUserExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyYoujiaUser> selectByExample(AgencyYoujiaUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyYoujiaUser record, @Param("example") AgencyYoujiaUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyYoujiaUser record, @Param("example") AgencyYoujiaUserExample example);
}
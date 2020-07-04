package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfDidiSetting;

public interface AgencyWfDidiSettingMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer wfId);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyWfDidiSetting record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyWfDidiSetting record);

    /**
     *
     * @mbggenerated
     */
    AgencyWfDidiSetting selectByPrimaryKey(Integer wfId);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyWfDidiSetting record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyWfDidiSetting record);
}
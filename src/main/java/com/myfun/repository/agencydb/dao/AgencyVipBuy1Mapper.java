package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyVipBuy1;
import com.myfun.repository.agencydb.po.AgencyVipBuy1Key;

public interface AgencyVipBuy1Mapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(AgencyVipBuy1Key key);

    /**
     *
     * @mbggenerated
     */
    int insert(AgencyVipBuy1 record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyVipBuy1 record);

    /**
     *
     * @mbggenerated
     */
    AgencyVipBuy1 selectByPrimaryKey(AgencyVipBuy1Key key);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AgencyVipBuy1 record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AgencyVipBuy1 record);
}
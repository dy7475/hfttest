package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyMyHftCustmap;

public interface AgencyMyHftCustmapMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(AgencyMyHftCustmap record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyMyHftCustmap record);

    /**
	 * @TODO 查询唯一码是否存在
	 * @author lcb
	 * @2016-10-14 上午11:00:54
	 */
    AgencyMyHftCustmap getCustMap(Integer custId);
}
package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCrmCompRange;
import com.myfun.repository.admindb.po.AdminCrmCompRangeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCrmCompRangeMapper extends BaseMapper<AdminCrmCompRange, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCrmCompRangeExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCrmCompRangeExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCrmCompRange> selectByExample(AdminCrmCompRangeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCrmCompRange record, @Param("example") AdminCrmCompRangeExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCrmCompRange record, @Param("example") AdminCrmCompRangeExample example);

	AdminCrmCompRange getAdminCrmCompRange(@Param("rangeId")Integer cityId,@Param("RangeType")Integer RangeType,@Param("proxyType")Integer proxyType);
}
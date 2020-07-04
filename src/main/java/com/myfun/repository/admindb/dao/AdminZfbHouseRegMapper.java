package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminZfbHouseReg;
import com.myfun.repository.admindb.po.AdminZfbHouseRegExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminZfbHouseRegMapper extends BaseMapper<AdminZfbHouseReg, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminZfbHouseRegExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminZfbHouseRegExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminZfbHouseReg> selectByExample(AdminZfbHouseRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminZfbHouseReg record, @Param("example") AdminZfbHouseRegExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminZfbHouseReg record, @Param("example") AdminZfbHouseRegExample example);
}
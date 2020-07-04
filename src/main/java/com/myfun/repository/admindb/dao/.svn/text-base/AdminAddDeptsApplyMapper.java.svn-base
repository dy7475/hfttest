package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminAddDeptsApply;
import com.myfun.repository.admindb.po.AdminAddDeptsApplyExample;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminAddDeptsApplyMapper extends BaseMapper<AdminAddDeptsApply, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminAddDeptsApplyExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminAddDeptsApplyExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminAddDeptsApply> selectByExample(AdminAddDeptsApplyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminAddDeptsApply record, @Param("example") AdminAddDeptsApplyExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminAddDeptsApply record, @Param("example") AdminAddDeptsApplyExample example);

    List<ErpFunDeptsDto> selectDeptApplyList(@Param("cityId") Integer cityId, @Param("compNo") String compNo, @Param("regId") Integer regId);
}
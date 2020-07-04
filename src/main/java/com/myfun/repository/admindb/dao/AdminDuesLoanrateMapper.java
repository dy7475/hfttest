package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminDuesLoanrateVo;
import com.myfun.repository.admindb.po.AdminDuesLoanrate;
import com.myfun.repository.admindb.po.AdminDuesLoanrateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminDuesLoanrateMapper extends BaseMapper<AdminDuesLoanrate, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminDuesLoanrateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminDuesLoanrateExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminDuesLoanrate> selectByExample(AdminDuesLoanrateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminDuesLoanrate record, @Param("example") AdminDuesLoanrateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminDuesLoanrate record, @Param("example") AdminDuesLoanrateExample example);

    List<AdminDuesLoanrateVo> getDuesLoanrateVoList(@Param("updateLoanrateTime")String updateLoanrateTime);
}
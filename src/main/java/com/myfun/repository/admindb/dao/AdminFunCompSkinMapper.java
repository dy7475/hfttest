package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunCompSkin;
import com.myfun.repository.admindb.po.AdminFunCompSkinExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunCompSkinMapper extends BaseMapper<AdminFunCompSkin, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunCompSkinExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunCompSkinExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunCompSkin> selectByExample(AdminFunCompSkinExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunCompSkin record, @Param("example") AdminFunCompSkinExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunCompSkin record, @Param("example") AdminFunCompSkinExample example);
}
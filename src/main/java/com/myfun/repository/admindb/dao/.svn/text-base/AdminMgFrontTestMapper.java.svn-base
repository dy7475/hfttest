package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminMgFrontTest;
import com.myfun.repository.admindb.po.AdminMgFrontTestExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMgFrontTestMapper extends BaseMapper<AdminMgFrontTest, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminMgFrontTestExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminMgFrontTestExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminMgFrontTest> selectByExample(AdminMgFrontTestExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminMgFrontTest record, @Param("example") AdminMgFrontTestExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminMgFrontTest record, @Param("example") AdminMgFrontTestExample example);

	String selectResponseJsonByUrl(@Param("userMobile")String userMobile, @Param("requestUrl")String requestUrl);
}
package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCustomLeagues;
import com.myfun.repository.admindb.po.AdminCustomLeaguesExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminCustomLeaguesMapper extends BaseMapper<AdminCustomLeagues, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminCustomLeaguesExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminCustomLeaguesExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminCustomLeagues> selectByExample(AdminCustomLeaguesExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminCustomLeagues record, @Param("example") AdminCustomLeaguesExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminCustomLeagues record, @Param("example") AdminCustomLeaguesExample example);
    
    /**
     * 通过公司编号查询加入的组织类型
     * @param compNo 公司编号
     * @return 组织类型
     */
    Integer selectLeaguesTypeByCompNo(@Param("compNo") String compNo);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.vo.RoyaltyInfoVO;
import com.myfun.repository.erpdb.po.ErpZxRoleConfig;
import com.myfun.repository.erpdb.po.ErpZxRoleConfigExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpZxRoleConfigMapper extends BaseMapper<ErpZxRoleConfig, ErpZxRoleConfig> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpZxRoleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpZxRoleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpZxRoleConfig> selectByExample(ErpZxRoleConfigExample example);

    ErpZxRoleConfig selectOneByExample(ErpZxRoleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpZxRoleConfig record, @Param("example") ErpZxRoleConfigExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpZxRoleConfig record, @Param("example") ErpZxRoleConfigExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
	ErpZxRoleConfig getCompRoleCofig(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);

    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<String> getRelevanceRole(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);

    void updateElseRole(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("roleId") String roleId);

    RoyaltyInfoVO getRoyaltyInfo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userPosition") String userPosition);
}
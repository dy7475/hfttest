package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyVipErpRelation;
import com.myfun.repository.agencydb.po.AgencyVipErpRelationExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyVipErpRelationMapper extends BaseMapper<AgencyVipErpRelation, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyVipErpRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyVipErpRelationExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyVipErpRelation> selectByExample(AgencyVipErpRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyVipErpRelation record, @Param("example") AgencyVipErpRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyVipErpRelation record, @Param("example") AgencyVipErpRelationExample example);

	AgencyVipErpRelation getAgencyVipErpRelation(@Param("cityId")Integer cityId,@Param("caseId")Integer caseId,@Param("caseType")Byte caseType);
	List<AgencyVipErpRelation> getAgencyVipErpRelationList(@Param("vipId")Integer vipId);
}
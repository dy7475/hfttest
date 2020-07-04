package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunWorkcountTargetOrgTemplate;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTargetOrgTemplateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunWorkcountTargetOrgTemplateMapper extends BaseMapper<ErpFunWorkcountTargetOrgTemplate, ErpFunWorkcountTargetOrgTemplate> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunWorkcountTargetOrgTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunWorkcountTargetOrgTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunWorkcountTargetOrgTemplate> selectByExample(ErpFunWorkcountTargetOrgTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunWorkcountTargetOrgTemplate record, @Param("example") ErpFunWorkcountTargetOrgTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunWorkcountTargetOrgTemplate record, @Param("example") ErpFunWorkcountTargetOrgTemplateExample example);

    void deleteByOrgIds(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("orgIds")List<Integer> allOrgIds, @Param("userPositionSet") Set<String> userPositionSet, @Param("partnerIds")List<Integer> partnerIds);
}
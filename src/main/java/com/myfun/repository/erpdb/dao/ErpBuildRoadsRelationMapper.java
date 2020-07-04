package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpBuildRoadsRelation;
import com.myfun.repository.erpdb.po.ErpBuildRoadsRelationExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpBuildRoadsRelationMapper extends BaseMapper<ErpBuildRoadsRelation, ErpBuildRoadsRelation> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpBuildRoadsRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpBuildRoadsRelationExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpBuildRoadsRelation> selectByExample(ErpBuildRoadsRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpBuildRoadsRelation record, @Param("example") ErpBuildRoadsRelationExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpBuildRoadsRelation record, @Param("example") ErpBuildRoadsRelationExample example);

    /**
     * 通过buildId获取楼盘干道关联表的列表
     * @author 臧铁
     * @since 2017年6月5日
     * @return
     */
    List<ErpBuildRoadsRelation> getListByBuildId(ErpBuildRoadsRelation erpBuildRoadsRelation);
}
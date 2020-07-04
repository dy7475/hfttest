package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpYouBuildDetailView;
import com.myfun.repository.erpdb.po.ErpYouBuildDetailViewExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpYouBuildDetailViewMapper extends BaseMapper<ErpYouBuildDetailView, ErpYouBuildDetailView> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpYouBuildDetailViewExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpYouBuildDetailViewExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpYouBuildDetailView> selectByExample(ErpYouBuildDetailViewExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpYouBuildDetailView record, @Param("example") ErpYouBuildDetailViewExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpYouBuildDetailView record, @Param("example") ErpYouBuildDetailViewExample example);

	ErpYouBuildDetailView getYouBuildDetailView(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId,@Param("detailId") Integer detailId);

    void updateYouBuildDetailView(@Param("shardCityId")Integer cityId,@Param("shardCityId") Integer compId,@Param("deptId") Integer deptId,@Param("userId") Integer userId,@Param("detailId") Integer detailId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);
}
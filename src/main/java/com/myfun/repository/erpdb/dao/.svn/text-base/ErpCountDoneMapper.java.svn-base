package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpCountDoneDto;
import com.myfun.repository.erpdb.po.ErpCountDone;
import com.myfun.repository.erpdb.po.ErpCountDoneExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpCountDoneMapper extends BaseMapper<ErpCountDone, ErpCountDone> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpCountDoneExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpCountDoneExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpCountDone> selectByExample(ErpCountDoneExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpCountDone record, @Param("example") ErpCountDoneExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpCountDone record, @Param("example") ErpCountDoneExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
   	List<ErpCountDoneDto> getHouseCountDoneList(@Param("shardCityId") Integer shardCityId,@Param("caseType")Integer caseType, @Param("archiveId")Integer selfArchiveId, @Param("caseIds")List<Integer> caseIds, @Param("sIds")Set<Integer> sIds);
}
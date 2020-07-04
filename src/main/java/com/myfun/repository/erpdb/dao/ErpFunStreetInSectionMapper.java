package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunStreetInSection;
import com.myfun.repository.erpdb.po.ErpFunStreetInSectionExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStreetInSectionMapper extends BaseMapper<ErpFunStreetInSection, ErpFunStreetInSection> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunStreetInSectionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunStreetInSectionExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunStreetInSection> selectByExample(ErpFunStreetInSectionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunStreetInSection record, @Param("example") ErpFunStreetInSectionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunStreetInSection record, @Param("example") ErpFunStreetInSectionExample example);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void batchAddStreetInSection(@Param("shardCityId") Integer cityId, @Param("inSections") List<ErpFunStreetInSection> inSections);

}
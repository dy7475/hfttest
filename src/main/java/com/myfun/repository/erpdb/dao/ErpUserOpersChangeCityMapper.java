package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersChangeCity;
import com.myfun.repository.erpdb.po.ErpUserOpersChangeCityExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpUserOpersChangeCityMapper extends BaseMapper<ErpUserOpersChangeCity, ErpUserOpersChangeCity> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpUserOpersChangeCityExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpUserOpersChangeCityExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpUserOpersChangeCity> selectByExample(ErpUserOpersChangeCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpUserOpersChangeCity record, @Param("example") ErpUserOpersChangeCityExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpUserOpersChangeCity record, @Param("example") ErpUserOpersChangeCityExample example);

	void insertList(@Param("shardCityId")Integer nowCityId, @Param("operList")List<ErpUserOpersDto> tempOperList);
}
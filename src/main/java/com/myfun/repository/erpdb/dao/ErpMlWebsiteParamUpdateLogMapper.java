package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpMlWebsiteParamUpdateLog;
import com.myfun.repository.erpdb.po.ErpMlWebsiteParamUpdateLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpMlWebsiteParamUpdateLogMapper extends BaseMapper<ErpMlWebsiteParamUpdateLog, ErpMlWebsiteParamUpdateLog> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpMlWebsiteParamUpdateLogExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpMlWebsiteParamUpdateLogExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpMlWebsiteParamUpdateLog> selectByExample(ErpMlWebsiteParamUpdateLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpMlWebsiteParamUpdateLog record, @Param("example") ErpMlWebsiteParamUpdateLogExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpMlWebsiteParamUpdateLog record, @Param("example") ErpMlWebsiteParamUpdateLogExample example);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealShareUser;
import com.myfun.repository.erpdb.po.ErpFunDealShareUserExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealShareUserMapper extends BaseMapper<ErpFunDealShareUser, ErpFunDealShareUser> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunDealShareUserExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunDealShareUserExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunDealShareUser> selectByExample(ErpFunDealShareUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunDealShareUser record, @Param("example") ErpFunDealShareUserExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunDealShareUser record, @Param("example") ErpFunDealShareUserExample example);
}
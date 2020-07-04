package com.myfun.repository.fafundb.dao;

import com.myfun.repository.fafundb.po.FafunShopInfo;
import com.myfun.repository.fafundb.po.FafunShopInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FafunShopInfoMapper extends BaseMapper<FafunShopInfo, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    List<FafunShopInfo> selectByExampleWithBLOBs(FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    List<FafunShopInfo> selectByExample(FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FafunShopInfo record, @Param("example") FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") FafunShopInfo record, @Param("example") FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FafunShopInfo record, @Param("example") FafunShopInfoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(FafunShopInfo record);

	Integer deleteUserWriteOffFaFaData(@Param("archiveId")Integer archiveId);
}
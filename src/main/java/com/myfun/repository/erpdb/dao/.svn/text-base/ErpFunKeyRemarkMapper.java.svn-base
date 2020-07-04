package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.vo.FunKeyRemarkDto;
import com.myfun.repository.erpdb.po.ErpFunKeyRemark;
import com.myfun.repository.erpdb.po.ErpFunKeyRemarkExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunKeyRemarkMapper extends BaseMapper<ErpFunKeyRemark, ErpFunKeyRemark> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunKeyRemarkExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunKeyRemarkExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunKeyRemark> selectByExample(ErpFunKeyRemarkExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunKeyRemark record, @Param("example") ErpFunKeyRemarkExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunKeyRemark record, @Param("example") ErpFunKeyRemarkExample example);

    FunKeyRemarkDto getFunKeyRemarkDto(@Param("shardCityId")Integer cityId, @Param("caseId")Integer caseId ,@Param("caseType")Integer caseType);
	
	List<ErpFunKeyRemark> getFunKeyRemarkList(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("caseIds") List<Integer> caseIds,@Param("caseType") Integer caseType);
 
	List<ErpFunKeyRemark> getFunKeyRemarkListByCaseIds(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);
 
}
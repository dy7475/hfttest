package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPolicyControl;
import com.myfun.repository.erpdb.po.ErpFunPolicyControlExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPolicyControlMapper extends BaseMapper<ErpFunPolicyControl, ErpFunPolicyControl> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPolicyControlExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPolicyControlExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPolicyControl> selectByExample(ErpFunPolicyControlExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPolicyControl record,
			@Param("example") ErpFunPolicyControlExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPolicyControl record,
			@Param("example") ErpFunPolicyControlExample example);

	ErpFunPolicyControl getPolicyControl(@Param("shardCityId")Integer cityId, @Param("caseId") Integer caseId, @Param("caseType")Integer caseType);
	
	List<ErpFunPolicyControl> getPolicyControlListByCaseIds(@Param("shardCityId")Integer cityId, @Param("caseIds") List<Integer> caseIds, @Param("caseType")Integer caseType);
}
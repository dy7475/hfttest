package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunPartnerDept;
import com.myfun.repository.erpdb.po.ErpFunPartnerDeptExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPartnerDeptMapper extends BaseMapper<ErpFunPartnerDept, ErpFunPartnerDept> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPartnerDeptExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPartnerDeptExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPartnerDept> selectByExample(ErpFunPartnerDeptExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPartnerDept record,
			@Param("example") ErpFunPartnerDeptExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPartnerDept record, @Param("example") ErpFunPartnerDeptExample example);

	ErpFunPartnerDept selectByDeptId(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);

	void updatePartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("partnerId")Integer partnerId);

    int countByPartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("partnerId")Integer partnerId);

    void updateRelativeTablePartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId, @Param("partnerId")Integer partnerId);
}
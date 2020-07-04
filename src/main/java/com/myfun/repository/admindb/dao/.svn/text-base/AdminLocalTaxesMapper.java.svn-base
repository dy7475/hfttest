package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminLocalTaxesVo;
import com.myfun.repository.admindb.po.AdminLocalTaxes;
import com.myfun.repository.admindb.po.AdminLocalTaxesExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLocalTaxesMapper extends BaseMapper<AdminLocalTaxes, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminLocalTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminLocalTaxesExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminLocalTaxes> selectByExample(AdminLocalTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminLocalTaxes record,
			@Param("example") AdminLocalTaxesExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminLocalTaxes record, @Param("example") AdminLocalTaxesExample example);

	List<AdminLocalTaxesVo> getLocalTaxesVoList(@Param("updateTaxesTime")String updateTaxesTime);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpTaskAssessmentTarget;
import com.myfun.repository.erpdb.po.ErpTaskAssessmentTargetExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpTaskAssessmentTargetMapper extends BaseMapper<ErpTaskAssessmentTarget, ErpTaskAssessmentTarget> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpTaskAssessmentTargetExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpTaskAssessmentTargetExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpTaskAssessmentTarget> selectByExample(ErpTaskAssessmentTargetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpTaskAssessmentTarget record,
			@Param("example") ErpTaskAssessmentTargetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpTaskAssessmentTarget record,
			@Param("example") ErpTaskAssessmentTargetExample example);
}
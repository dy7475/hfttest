package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.vo.ProcessModelStepVO;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpProcessModel;
import com.myfun.repository.erpdb.po.ErpProcessModelStep;
import com.myfun.repository.erpdb.po.ErpProcessModelStepExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpProcessModelStepMapper extends BaseMapper<ErpProcessModelStep, ErpProcessModelStep> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpProcessModelStepExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpProcessModelStepExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpProcessModelStep> selectByExample(ErpProcessModelStepExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpProcessModelStep record,
			@Param("example") ErpProcessModelStepExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpProcessModelStep record,
			@Param("example") ErpProcessModelStepExample example);

	List<ErpProcessModelStep> getMgrAllStepModelList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
	
	List<ProcessModelStepVO> getProcessModelStepList(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);
}
package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import com.myfun.erpWeb.managecenter.transaction.vo.RuntimeStepVO;

import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import com.myfun.repository.erpdb.po.ErpProcessRuntimeStepExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpProcessRuntimeStepMapper extends BaseMapper<ErpProcessRuntimeStep, ErpProcessRuntimeStep> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpProcessRuntimeStepExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpProcessRuntimeStepExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpProcessRuntimeStep> selectByExample(ErpProcessRuntimeStepExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpProcessRuntimeStep record,
			@Param("example") ErpProcessRuntimeStepExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpProcessRuntimeStep record,
			@Param("example") ErpProcessRuntimeStepExample example);

	List<ErpProcessRuntimeStep> getListData(@Param("shardCityId") Integer cityId,@Param("repeatDealIds") List<Integer> repeatDealIds);

	int resetSeqForRuntimeStep(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	List<Integer> getUpdateUserList(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId);

	void updateStepSeq(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("delFlag") Byte delFlag, @Param("stepSeq")Integer stepSeq);

	void createProcessRuntimeStep(@Param("shardCityId") Integer cityId, @Param("modelId") Integer modelId, @Param("dealId") Integer dealId);

	List<ErpProcessRuntimeStepDto> getMgrWarrantStepList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("dealId") Integer dealId);

	List<ErpProcessRuntimeStepDto> getMgrWarrantStepListByIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("ids") String[] ids);

	List<RuntimeStepVO> getRuntimeStepListByDealIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("dealIdList") List<Integer> dealIdList);

	ErpProcessRuntimeStep getNextRuntimeStep(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId, @Param("stepSeq")Integer stepSeq);

	ErpProcessRuntimeStep getBeforeRuntimeStep(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId, @Param("stepSeq")Integer stepSeq);
}
package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpModelStepDetailDto;
import com.myfun.repository.erpdb.po.ErpModelStepRelate;
import com.myfun.repository.erpdb.po.ErpModelStepRelateKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpModelStepRelateExample;

public interface ErpModelStepRelateMapper extends BaseMapper<ErpModelStepRelate, ErpModelStepRelateKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpModelStepRelateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpModelStepRelateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpModelStepRelate> selectByExample(ErpModelStepRelateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpModelStepRelate record,
			@Param("example") ErpModelStepRelateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpModelStepRelate record,
			@Param("example") ErpModelStepRelateExample example);

	List<ErpModelStepDetailDto> getMgrStepModelDetail(@Param("shardCityId")Integer cityId, @Param("modelId")Integer modelId);

	void updateModelStepRelateByMap(@Param("shardCityId")Integer cityId, @Param("param")Map<String,Object> map);

	ErpModelStepRelate selectModelStepRelate(@Param("shardCityId")Integer cityId, @Param("param")ErpModelStepRelate modelStepRelate);

	void deleteModelStepRelate(@Param("shardCityId")Integer cityId, @Param("param") ErpModelStepRelate model);

	void updateStepSeq(@Param("shardCityId")Integer cityId, @Param("param") ErpModelStepRelate updateModel);

	void deleteModelStepRelateByModelId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("modelId") Integer modelId);

	Integer countModelStepRelateByStepId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("stepId") Integer stepId);

	void deleteByStepIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("modelId") Integer modelId, @Param("cancelStepIdList") List<Integer> cancelStepIdList);
}
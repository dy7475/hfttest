package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpProcessModel;
import com.myfun.repository.erpdb.po.ErpProcessModelExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ErpProcessModelMapper extends BaseMapper<ErpProcessModel, ErpProcessModel> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpProcessModelExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpProcessModelExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpProcessModel> selectByExample(ErpProcessModelExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpProcessModel record,
			@Param("example") ErpProcessModelExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpProcessModel record, @Param("example") ErpProcessModelExample example);
	void insertInitCompProcessModel(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	void insertInitCompProcessModelStepByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	void insertInitCompModelStepRelateByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	List<Map<String,Object>> selectProcessModelListByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("pageOffset")Integer pageOffset , @Param("pageRows")Integer pageRows);

	Map<String,Object> getSerialNumber(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);

	Integer getNowInsertModelId(@Param("shardCityId")Integer cityId);

	Map<String,Integer> getMinMaxVal(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

    void updateConditionStepIdToNull(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("modelId")Integer modelId, @Param("conditionStepId") Integer stepId);

    ErpProcessModel getModelByDealId(@Param("shardCityId")Integer cityId, @Param("dealId")Integer dealId);
}
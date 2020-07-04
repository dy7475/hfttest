package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunDealCodeDto;
import com.myfun.repository.erpdb.po.ErpFunDealCode;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDealCodeExample;

public interface ErpFunDealCodeMapper extends BaseMapper<ErpFunDealCode, ErpFunDealCode> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealCodeExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealCodeExample example);
	/**
	 * @mbggenerated
	 */List<ErpFunDealCode> selectByExample(ErpFunDealCodeExample example);
	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunDealCode record,@Param("example") ErpFunDealCodeExample example);
	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunDealCode record,@Param("example") ErpFunDealCodeExample example);
	/**
	 * 查询合同列表
	 * @author 何传强
	 * @since 2017年7月5日
	 * @param shardCityId
	 * @param param
	 * @return
	 */
	List<ErpFunDealCode> getDealFunDealCodeList(@Param("shardCityId") Integer shardCityId,@Param("param") Map<String, Object> param);
	/**
	 * 分配,已使用统计
	 * @author 何传强
	 * @since 2017年7月5日
	 * @param shardCityId
	 * @param param
	 * @return
	 */
	ErpFunDealCodeDto getDealCountInfo(@Param("shardCityId") Integer shardCityId,@Param("param") Map<String, Object> param);
	/**
	 * 合同号段启用和停用
	 * @author 何传强
	 * @since 2017年7月6日
	 * @param cityId
	 * @param param
	 */
	void updateDealFunDealCode(@Param("shardCityId") Integer shardCityId,@Param("param") Map<String, Object> param);

	void updateUsedCount(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("codeId") Integer codeId);

	void updateCode(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("isCan")String isCan);

	void updateCodeLog(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("isCan")String isCan);

	void deleteByCodeId(@Param("shardCityId") Integer cityId,@Param("codeId") Integer codeId);

	List<ErpFunDealCodeDto> getFunDealCodeList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("dealType") Integer dealType, @Param("dealNo") String dealNo);
}
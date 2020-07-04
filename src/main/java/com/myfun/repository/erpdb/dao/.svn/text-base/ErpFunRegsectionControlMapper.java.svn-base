package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunRegsectionControl;
import com.myfun.repository.erpdb.po.ErpFunRegsectionControlExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunRegsectionControlMapper extends BaseMapper<ErpFunRegsectionControl, ErpFunRegsectionControl> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRegsectionControlExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRegsectionControlExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRegsectionControl> selectByExample(ErpFunRegsectionControlExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRegsectionControl record,
			@Param("example") ErpFunRegsectionControlExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRegsectionControl record,
			@Param("example") ErpFunRegsectionControlExample example);
	
	int countOneCaseInfoAndCaseType(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId,@Param("regionId") Integer regionId,@Param("sectionId") Integer sectionId);
	
	/**
	 * 通过公司和门店ID获取列表数据
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return 
	 * 
	 */
	List<ErpFunRegsectionControl> getRegsectionControlList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);
	
	/**
	 * 查询客户选择的区域下选择的板块
	 * @param 
	 * @auther zhuke
	 * @since 2018/5/3
	 * @return 
	 * 
	 */
	List<ErpFunRegsectionControl> getRegionAndSection(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);

	Map getUsersByOperRange(@Param("shardCityId")Integer cityId, @Param("queryRange") String queryRange, @Param("operRange")String operRange,
							@Param("compId")Integer compId, @Param("queryRangeId")Integer queryRangeId, @Param("operRangeAtt") Object operRangeAtt, @Param("deptId") Integer deptId);

	List<Map<String,String>> getRegsectionControl(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("deptId")Integer deptId);
}
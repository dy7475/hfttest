package com.myfun.repository.reportdb.dao;

import com.myfun.repository.reportdb.po.ReportFunDutyBuild;
import com.myfun.repository.reportdb.po.ReportFunDutyBuildExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ReportFunDutyBuildMapper extends BaseMapper<ReportFunDutyBuild, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunDutyBuildExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunDutyBuildExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunDutyBuild> selectByExample(ReportFunDutyBuildExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunDutyBuild record,
			@Param("example") ReportFunDutyBuildExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunDutyBuild record,
			@Param("example") ReportFunDutyBuildExample example);

	/**
	 * 删除之前的
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param cityId
	 * @param compId
	 * @param deptId
	 */
	void deleteDeptDutyBuild(@Param("cityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);
	
	/**
	 * 获取责任楼盘列表
	 * @author 张宏利
	 * @since 2017年9月28日
	 * @param cityId
	 * @param compId
	 * @param serchRange
	 * @param serchRangeId
	 * @return
	 */
	List<ReportFunDutyBuild> getDeptDutyBuild(@Param("cityId") Integer cityId,@Param("compId") Integer compId,@Param("serchRange") String serchRange,@Param("serchRangeId") Integer serchRangeId);
	
	/**
	 * 楼盘设置数大于6的列表
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param buildIdSet 楼盘ID列表
	 * @return
	 */
	List<Map<String, Object>> getBuildCountList(@Param("cityId") Integer cityId,@Param("compId") Integer compId, @Param("buildIdSet") Set<Integer> buildIdSet);
}


package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunScoreRecored;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunScoreRecoredMapper extends BaseMapper<AdminFunScoreRecored, Integer> {
	
	Map<String, Object> getSelfScore(@Param("cityId")Integer cityId, @Param("archiveId")Integer archiveId,@Param("startMonth") String startMonth, @Param("endMonth") String endMonth);
	
	Map<String, Object> getSelfRanking(@Param("cityId")Integer cityId, @Param("totalScore")Integer totalScore,@Param("startMonth") String startMonth, @Param("endMonth") String endMonth);

	List<Map<String, Object>> getScoreTotalRanking(@Param("cityId")Integer cityId, 
			@Param("startMonth") String startMonth, @Param("endMonth") String endMonth,
			@Param("userCreateTime") Date userCreateTime, @Param("compNo") String compNo);
}
package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunTrueHouseCount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunTrueHouseCountMapper extends BaseMapper<AdminFunTrueHouseCount, Integer> {

	Map<String, String> getTrueDayCount(String queryDate);

	Map<String, String> getTrueMobileCount(@Param("mobile") String mobile,@Param("startDate") String startDate,@Param("endDate") String endDate);

	Map<String, String> getTrueDeptCount(@Param("compNo")String compNo,@Param("deptNo") String deptNo,@Param("startDate") String startDate,@Param("endDate") String endDate);

	int countDetails(@Param("param") Map<String, Object> map);
	
	List<Map<String,Object>> caseDetailsList(@Param("param") Map<String, Object> map);
}
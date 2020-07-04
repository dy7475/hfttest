package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencySysPara;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AgencySysParaMapper extends BaseMapper<AgencySysPara, String> {
	
	String getAgencySysParaByParamId(@Param("paramId")String paramId);
}
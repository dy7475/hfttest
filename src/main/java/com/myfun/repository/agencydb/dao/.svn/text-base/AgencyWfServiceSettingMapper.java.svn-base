package com.myfun.repository.agencydb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyWfServiceSetting;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfServiceSettingMapper extends BaseMapper<AgencyWfServiceSetting, Integer> {
	public void changeRedPacketMumber(@Param("param")Map<String, Object> param);
	public Integer getNumberByArchiveId(@Param("param")Map<String, Object> param);
	public Integer getSwitchNumberByArchiveId(@Param("param")Map<String, Object> param);
}
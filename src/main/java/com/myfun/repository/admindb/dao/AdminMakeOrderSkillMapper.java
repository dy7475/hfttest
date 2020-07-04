package com.myfun.repository.admindb.dao;

import com.github.pagehelper.Page;
import com.myfun.repository.admindb.dto.AdminMakeOrderSkillDto;
import com.myfun.repository.admindb.param.AdminMakeOrderSkillParam;
import com.myfun.repository.admindb.po.AdminMakeOrderSkill;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMakeOrderSkillMapper extends BaseMapper<AdminMakeOrderSkill, Integer> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AdminMakeOrderSkill record);
    
	Page<AdminMakeOrderSkill> getAdminMakeOrderSkillList(AdminMakeOrderSkillParam adminMakeOrderSkillParam);
	
	/**
	 * 秘笈详情
	 * **/
	AdminMakeOrderSkillDto getAdminMakeOrderSkillByCondition(AdminMakeOrderSkillParam adminMakeOrderSkillParam);

	AdminMakeOrderSkill getAdminMakeOrderSkillById(Integer skillId);

    List<AdminMakeOrderSkill> getNeedDfsDealList();

	void insertForFastDfs(@Param("dfsParamList")List<Map<String, Object>> fastdfsFileList);
}
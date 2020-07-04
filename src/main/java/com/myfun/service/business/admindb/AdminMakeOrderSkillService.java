package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminMakeOrderSkillDto;
import com.myfun.repository.admindb.param.AdminMakeOrderSkillParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminMakeOrderSkill;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminMakeOrderSkillService extends BaseMapper<AdminMakeOrderSkill, Integer> {

	List<AdminMakeOrderSkill> getAdminMakeOrderSkillList(AdminMakeOrderSkillParam adminMakeOrderSkillParam);

	AdminMakeOrderSkill getAdminMakeOrderSkillById(Integer bulletId);

	Integer updateSkillId(AdminMakeOrderSkill adminMakeOrderSkill);

	Integer insertMakeOrder(AdminMakeOrderSkill adminMakeOrderSkill, AdminCrmUser adminCrmUser);

	Integer deleteByShillId(Integer skillId);
}

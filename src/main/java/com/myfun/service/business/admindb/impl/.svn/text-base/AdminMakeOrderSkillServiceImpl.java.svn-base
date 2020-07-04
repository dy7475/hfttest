package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.myfun.repository.admindb.dao.AdminMakeOrderSkillMapper;
import com.myfun.repository.admindb.param.AdminMakeOrderSkillParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminMakeOrderSkill;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminMakeOrderSkillService;
import com.myfun.utils.DateUtil;

/**
 * 开单秘笈
 * @author lcb
 *
 */
@Service
public class AdminMakeOrderSkillServiceImpl extends AbstractService<AdminMakeOrderSkill, Integer> implements AdminMakeOrderSkillService {
	@Autowired
	private AdminMakeOrderSkillMapper adminMakeOrderSkillMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminMakeOrderSkillMapper;
	}
	
	/**
	 * @Title: enclosing_method 
	 * @Description:开单秘笈
	 * @param tags
	 * @return return_type    返回类型 
	 * @throws 
	 * @author lcb
	 */
	@Override
	public List<AdminMakeOrderSkill> getAdminMakeOrderSkillList(AdminMakeOrderSkillParam adminMakeOrderSkillParam) {
		PageHelper.startPage(adminMakeOrderSkillParam.getPageNum(), adminMakeOrderSkillParam.getPageSize(), true);
		List<AdminMakeOrderSkill> resList = adminMakeOrderSkillMapper.getAdminMakeOrderSkillList(adminMakeOrderSkillParam);
		return resList;
	}

	@Override
	public AdminMakeOrderSkill getAdminMakeOrderSkillById(Integer bulletId) {
		// TODO Auto-generated method stub
		return adminMakeOrderSkillMapper.getAdminMakeOrderSkillById(bulletId);
	}

	@Override
	public Integer updateSkillId(AdminMakeOrderSkill adminMakeOrderSkill) {
		// TODO Auto-generated method stub
		return adminMakeOrderSkillMapper.updateByPrimaryKeySelective(adminMakeOrderSkill);
	}

	@Override
	public Integer insertMakeOrder(AdminMakeOrderSkill adminMakeOrderSkill, AdminCrmUser adminCrmUser) {
		// TODO Auto-generated method stub
		Date date = new Date();
		adminMakeOrderSkill.setCreationTime(date);
		adminMakeOrderSkill.setViewCount(0);
		adminMakeOrderSkill.setShareCount(0);
		adminMakeOrderSkill.setCreateUid(adminCrmUser.getArchiveId());
		adminMakeOrderSkill.setDateGroup(DateUtil.DateToString(date, "yyyy-MM-dd"));
		adminMakeOrderSkill.setUpdateDate(date);
		adminMakeOrderSkill.setIsMain(new Byte("0"));
		if(null != adminMakeOrderSkill.getIsMain() && adminMakeOrderSkill.getIsMain() == 1) {
			adminMakeOrderSkill.setIsMain(new Byte("1"));
		}
		return adminMakeOrderSkillMapper.insertSelective(adminMakeOrderSkill);
	}

	@Override
	public Integer deleteByShillId(Integer skillId) {
		// TODO Auto-generated method stub
		return adminMakeOrderSkillMapper.deleteByPrimaryKey(skillId);
	}
		
	
	
}


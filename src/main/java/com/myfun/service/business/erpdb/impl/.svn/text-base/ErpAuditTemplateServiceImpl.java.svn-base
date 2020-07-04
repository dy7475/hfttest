package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.dao.ErpAuditTemplateMapper;
import com.myfun.repository.erpdb.dao.ErpAuditUserTemplateMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.param.ErpAuditTemplateListParam;
import com.myfun.repository.erpdb.po.ErpAuditTemplate;
import com.myfun.repository.erpdb.po.ErpAuditUserTemplate;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpAuditTemplateService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSysParaService;

@Service
public class ErpAuditTemplateServiceImpl extends AbstractService<ErpAuditTemplate, ErpAuditTemplate> implements ErpAuditTemplateService{
	@Autowired private ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired ErpAuditRuntimeService erpAuditRuntimeService;
	@Autowired ErpSysParaService erpSysParaService;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAuditTemplateMapper;
	}

	@Transactional
	@Override
	public void saveAuditTemplate(String templateListStr, Integer cityId, Integer compId) {
		List<ErpAuditTemplateListParam> templateList = new LinkedList<>();
		try {
			templateList = JSON.parseArray(templateListStr, ErpAuditTemplateListParam.class);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		if(templateList == null || templateList.isEmpty()) {
			return;
		}
		for (ErpAuditTemplateListParam templateParam : templateList) {
			Integer auditType = templateParam.getAuditType();
			Byte auditResource = templateParam.getAuditResource();
			// 必须先删除user再删除模板
			erpAuditUserTemplateMapper.deleteByAuditId(cityId, compId, templateParam.getCaseType(), auditType, auditResource);
			// 审核人
			if(StringUtils.isNotBlank(templateParam.getAuditUser())) {
				List<ErpAuditUserTemplate> userTempList = JSON.parseArray(templateParam.getAuditUser(), ErpAuditUserTemplate.class);
				templateParam.setAuditUserList(userTempList);
			}
			boolean auditUserEmpty = (templateParam.getAuditUserList() == null || templateParam.getAuditUserList().isEmpty());
			templateParam.setCompId(compId);
			templateParam.setShardCityId(cityId);
			if(auditUserEmpty) {
				templateParam.setNeedAudit((byte) 0);// 没有审核人列表改为不需要审核
			}
			// 没有则插入，存在则更新
			ErpAuditTemplate auditTemplateSel = erpAuditTemplateMapper.selectByAuditType(cityId, compId, auditResource, auditType, templateParam.getCaseType());
			if(auditTemplateSel == null) {
				templateParam.setCreationTime(new Date());
				erpAuditTemplateMapper.insertSelective(templateParam);
			} else {
				templateParam.setId(auditTemplateSel.getId());
				templateParam.setUpdateTime(new Date());
				erpAuditTemplateMapper.updateByPrimaryKeySelective(templateParam);
			}
			// 查看电话是否需要审核同步到系统参数
			if(Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(auditType.byteValue())) {
				Byte needAudit = templateParam.getNeedAudit();
				Integer caseType = templateParam.getCaseType();
				String sysParamId = null;
				if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					sysParamId = "SALE_AUTO_EXAM_VIEW";
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					sysParamId = "LEASE_AUTO_EXAM_VIEW";
				} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
					sysParamId = "BUY_AUTO_EXAM_VIEW";
				} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
					sysParamId = "RENT_AUTO_EXAM_VIEW";
				}
				ErpSysPara erpSysPara = new ErpSysPara();
				erpSysPara.setShardCityId(cityId);
				erpSysPara.setCompId(compId);
				erpSysPara.setParamId(sysParamId);
				erpSysPara.setParamValue((needAudit == 0) ? "1" : "0");
				erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara);
				erpSysParaService.evictSysParamCache(cityId, compId);
				// 由无需审核改成要审核，踢人
				if(needAudit == 1) {
					if(auditTemplateSel == null || auditTemplateSel.getNeedAudit() == 0) {
						erpFunUsersService.endLoginDeptUser(cityId, compId, null, LogInEnum.SystemPara_UP);
					}
				}
			}
			if(auditUserEmpty) {
				continue;
			}
			// 审核人模板
			int auditSeq = 1;// 序号必须从1开始
			List<ErpAuditUserTemplate> auditUserTemplates = new LinkedList<>();
			for (ErpAuditUserTemplate erpAuditUser : templateParam.getAuditUserList()) {
				erpAuditUser.setCreationTime(new Date());
				erpAuditUser.setAuditId(templateParam.getId());
				if(erpAuditUser.getExamineType() == null) {
					erpAuditUser.setExamineType((byte) 0);
				}
				if(erpAuditUser.getAuditSeq() == null) {
					erpAuditUser.setAuditSeq(auditSeq);
				}
				auditUserTemplates.add(erpAuditUser);
				auditSeq++;
			}
			if(!auditUserTemplates.isEmpty()) {
				erpAuditUserTemplateMapper.insertList(cityId, auditUserTemplates);
			}
		}
	}
	
}


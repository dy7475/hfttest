package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.house.param.ProxyTemplateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunProxyTemplateMapper;
import com.myfun.repository.erpdb.po.ErpFunProxyTemplate;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunProxyTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ErpFunProxyTemplateServiceImpl extends AbstractService<ErpFunProxyTemplate, ErpFunProxyTemplate> implements ErpFunProxyTemplateService {
	@Autowired
	ErpFunProxyTemplateMapper erpFunProxyTemplateMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunProxyTemplateMapper;
	}

	/**
	 * 委托和带看确认模版更新
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@Transactional
	@Override
	public void saveProxyTemplate(Integer cityId, Integer compId,Integer id, Byte templateType, Byte caseType,String templateContent) {
		ErpFunProxyTemplate erpFunProxyTemplate=new ErpFunProxyTemplate();
		if (templateType==1){
			if (caseType==null){
				throw new BusinessException("确认带看书模版类型不能为空");
			}
		}

		erpFunProxyTemplate.setCaseType(caseType);
		erpFunProxyTemplate.setCompId(compId);
		erpFunProxyTemplate.setTemplateType(templateType);
		erpFunProxyTemplate.setCreateTime(new Date());
		erpFunProxyTemplate.setTemplateContent(templateContent);
		erpFunProxyTemplate.setShardCityId(cityId);
		if (id != null){
			erpFunProxyTemplate.setId(id);
			erpFunProxyTemplateMapper.updateByPrimaryKeySelective(erpFunProxyTemplate);
		}else {
			erpFunProxyTemplateMapper.insertSelective(erpFunProxyTemplate);
		}
	}

	@Override
	public void resetTemplateContent(Integer cityId, ProxyTemplateParam param) {
		erpFunProxyTemplateMapper.resetTemplateContent(cityId, param);

	}
}

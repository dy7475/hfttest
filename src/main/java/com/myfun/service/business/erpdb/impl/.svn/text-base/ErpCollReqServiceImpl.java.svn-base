package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpCollReqMapper;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.po.ErpCollReq;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpCollReqService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.utils.BeanUtil;
@Service
public class ErpCollReqServiceImpl extends AbstractService<ErpCollReq, ErpCollReq> implements ErpCollReqService{
	@Autowired private ErpCollReqMapper erpCollReqMapper;
	@Autowired private ErpFunDeptsService erpFunDeptsService;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpCollReqMapper;
		
	}
	@Override
	public PageInfo<ErpCollReq> getCollList(BaseMapParam param) {
		String[] deptIds = null;
		if(StringUtils.isNotBlank(param.getString("deptId"))){
			deptIds=new String[]{param.getString("deptId")};
		}
		if(StringUtils.isNotBlank(param.getString("regId"))) {
		    PageHelper.startPage(param.getPageOffset(), param.getPageRows());
			List<ErpFunDeptsDto> list = erpFunDeptsService.getDeptsList(param.getInteger("cityId"), param.getInteger("regId"));
			deptIds=BeanUtil.buildQueryKeys(list, "DEPT_ID");
		}else if(StringUtils.isNotBlank(param.getString("areaId"))) {
		    PageHelper.startPage(param.getPageOffset(), param.getPageRows());
			List<ErpFunDepts> list = erpFunDeptsService.getDeptListByArea(param.getInteger("cityId"),param.getInteger("compId"),  param.getInteger("areaId"));
			deptIds=BeanUtil.buildQueryKeys(list,"DEPT_ID");
		}
		param.setObject("deptIds",deptIds);
		PageInfo<ErpCollReq> pageInfo = new PageInfo<ErpCollReq>(erpCollReqMapper.getCollList(param.getInteger("cityId"),param.getMap()));
		return pageInfo;
	}

}

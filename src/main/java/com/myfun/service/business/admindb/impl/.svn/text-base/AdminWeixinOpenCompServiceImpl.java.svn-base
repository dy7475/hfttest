package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminWeixinOpenCompMapper;
import com.myfun.repository.admindb.dto.AdminFunCompDto;
import com.myfun.repository.admindb.param.AdminWeixinOpenCompParam;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminWeixinOpenComp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminWeixinOpenCompService;

/**
 * 微信公众号处理
 * **/
@Service
public class AdminWeixinOpenCompServiceImpl extends AbstractService<AdminWeixinOpenComp, Integer> implements AdminWeixinOpenCompService{

	@Autowired
	private AdminWeixinOpenCompMapper adminWeixinOpenCompMapper;
	@Autowired
	AdminFunCompMapper funCompMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminWeixinOpenCompMapper;
	}

	/**
	 * 获取公众微信列表
	 * 
	 * @author XC
	 **/
	public PageInfo<AdminFunCompDto> getPublicWechatList(AdminWeixinOpenCompParam param) {
		PageHelper.startPage(1, 50, true);
		//PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		return new PageInfo<AdminFunCompDto>(funCompMapper.getPublicWechatList(param));
	}

	/***
	 * 获取公司信息
	 * 
	 * @param compParam
	 * @return
	 * @author XC
	 */
	@Override
	public AdminWeixinOpenComp getWeixinOpenCompByCompID(Integer compId) {
		AdminWeixinOpenComp openCompDtos = adminWeixinOpenCompMapper.getWeixinOpenCompByCompID(compId);
		return openCompDtos;
	}

	/**
	 * 获取公司微信公众号信息
	 * 
	 * @author XC
	 */
	@Override
	public AdminFunComp getFunCompByCompId(Integer compId) {
		AdminFunComp weixinOpenComp = funCompMapper.selectByPrimaryKey(compId);
		return weixinOpenComp;
	}

	public void updateWeixinOpenCompByCompId(AdminWeixinOpenComp upWeixinOpenComp) {
		adminWeixinOpenCompMapper.updateWeixinOpenCompByCompId(upWeixinOpenComp);
	}


}

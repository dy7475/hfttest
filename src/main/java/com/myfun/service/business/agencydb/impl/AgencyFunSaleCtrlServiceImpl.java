package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyFunSaleCtrlMapper;
import com.myfun.repository.agencydb.dto.AgencyFunSaleCtrlDto;
import com.myfun.repository.agencydb.param.AgencyFunSaleCtrlParam;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrl;
import com.myfun.repository.agencydb.po.AgencyFunSaleCtrlKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunSaleCtrlService;

@Service
public class AgencyFunSaleCtrlServiceImpl extends AbstractService<AgencyFunSaleCtrl, AgencyFunSaleCtrlKey> 
implements AgencyFunSaleCtrlService {
	@Autowired
	private AgencyFunSaleCtrlMapper agencyFunSaleCtrlMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunSaleCtrlMapper;
	}

	@Override
	public int deleteByPrimaryKey(AgencyFunSaleCtrlKey id) {
		return 0;
	}

	@Override
	public AgencyFunSaleCtrl selectByPrimaryKey(AgencyFunSaleCtrlKey id) {
		return agencyFunSaleCtrlMapper.selectByPrimaryKey(id);
	}

	/**
	 * 列表
	 * **/
	@Override
	public PageInfo<AgencyFunSaleCtrlDto> getFunSaleCtrlList(AgencyFunSaleCtrlParam agencyFunSaleCtrlParam) {
		PageHelper.startPage(agencyFunSaleCtrlParam.getPageNum(), agencyFunSaleCtrlParam.getPageSize(), true);
		List<AgencyFunSaleCtrlDto> resList = agencyFunSaleCtrlMapper.getFunSaleCtrlList(agencyFunSaleCtrlParam);
		PageInfo<AgencyFunSaleCtrlDto> pageInfo = new PageInfo<AgencyFunSaleCtrlDto>(resList);
		return pageInfo;
	}

	@Override
	public Integer addOrupdateFunSaleCtrol(AgencyFunSaleCtrl agencyFunSaleCtrl, Integer type, AdminCrmUser adminCrmUser) {
		Integer res = 0;
		agencyFunSaleCtrl.setUpdateTime(new Date());
		agencyFunSaleCtrl.setUpdateUid(adminCrmUser.getUserId());
		if(type == 1) {
			res = agencyFunSaleCtrlMapper.updateByCondition(agencyFunSaleCtrl);
		}else {
			res = agencyFunSaleCtrlMapper.insertSelective(agencyFunSaleCtrl);
		}
		return res;
	}

	// 查询详情
	@Override
	public AgencyFunSaleCtrl getFunSaleCtrl(Integer cityId, Integer buildId, String houseNo) {
		AgencyFunSaleCtrl agencyFunSaleCtrl = new AgencyFunSaleCtrl();
		agencyFunSaleCtrl.setCityId(cityId);
		agencyFunSaleCtrl.setBuildId(buildId);
		agencyFunSaleCtrl.setHouseNo(houseNo);
		AgencyFunSaleCtrl ag = agencyFunSaleCtrlMapper.selectByPrimaryKey(agencyFunSaleCtrl);
		return ag;
	}

	
	

}

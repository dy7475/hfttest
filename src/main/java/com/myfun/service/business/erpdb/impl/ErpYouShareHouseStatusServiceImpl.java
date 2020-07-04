package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dao.ErpYouShareHouseStatusMapper;
import com.myfun.repository.erpdb.dto.ErpYouComplainDto;
import com.myfun.repository.erpdb.param.ErpYouComplainParam;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouShareHouseStatusService;
import com.myfun.utils.DateUtil;

@Service
public class ErpYouShareHouseStatusServiceImpl extends AbstractService<ErpYouShareHouseStatus, ErpYouShareHouseStatus> implements ErpYouShareHouseStatusService {
	@Autowired
	private ErpYouShareHouseStatusMapper erpYouShareHouseStatusMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=erpYouShareHouseStatusMapper;
	}

	@Override
	public PageInfo<ErpYouComplainDto> getComplainList(ErpYouComplainParam erpYouComplainParam) {
		if(erpYouComplainParam.getComplainTime()!= null && !"".equals(erpYouComplainParam.getComplainTime())){
			Date date =new Date();
			switch (erpYouComplainParam.getComplainTime()) {
			case "week":erpYouComplainParam.setComplainTimeStart(DateUtil.addDay(date, -7));
				erpYouComplainParam.setComplainTimeEnd(date);
				break;
			case "month":erpYouComplainParam.setComplainTimeStart(DateUtil.addMonth(date, -1));
				erpYouComplainParam.setComplainTimeEnd(date);
				break;
			case "quarter":erpYouComplainParam.setComplainTimeStart(DateUtil.addMonth(date, -3));
				erpYouComplainParam.setComplainTimeEnd(date);
				break;
			case "halfYear":erpYouComplainParam.setComplainTimeStart(DateUtil.addMonth(date, -6));
				erpYouComplainParam.setComplainTimeEnd(date);
				break;
			case "year":erpYouComplainParam.setComplainTimeStart(DateUtil.addYear(date, -1));
				erpYouComplainParam.setComplainTimeEnd(date);
				break;
			case "all":erpYouComplainParam.setComplainTime(null);
				break;
			}
		}
		if(erpYouComplainParam.getCaseType()==null){
			erpYouComplainParam.setCaseType(1);
		}
		if(erpYouComplainParam.getCityId()==null){
			erpYouComplainParam.setShardCityId(1);
		}else{
			erpYouComplainParam.setShardCityId(erpYouComplainParam.getCityId());
		}
		PageHelper.startPage(erpYouComplainParam.getPageNum(), erpYouComplainParam.getPageSize(), true);
		List<ErpYouComplainDto> list = erpYouShareHouseStatusMapper.getComplainList(erpYouComplainParam);
		return new PageInfo<ErpYouComplainDto>(list);
	}

	@Override
	public void downShareHouseByCondition(Integer cityId, ErpYouShareHouseStatus record) {
		erpYouShareHouseStatusMapper.downShareHouseByCondition(cityId, record);
		
	}

	/**
	 * 修改youjia数据
	 * **/
	@Override
	public void downShareDataByCaseIds(Integer cityId, Map<String, Object> pMap) {
		erpYouShareHouseStatusMapper.downShareDataByCaseIds(cityId, pMap);
	}

}

package com.myfun.service.business.erpdb.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunFinanceStatusMapper;
import com.myfun.repository.erpdb.po.ErpFunFinanceStatus;
import com.myfun.repository.erpdb.po.ErpFunFinanceStatusExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunFinanceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunFinanceStatusServiceImpl extends AbstractService<ErpFunFinanceStatus, ErpFunFinanceStatus> implements ErpFunFinanceStatusService {
	@Autowired
	ErpFunFinanceStatusMapper erpFunFinanceStatusMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunFinanceStatusMapper;
	}

	@Override
	public void createCompTempleteFinancStatusList(Integer cityId, Integer compId) {
		erpFunFinanceStatusMapper.createCompTempleteFinancStatusList(cityId, compId);
	}

	@Transactional
	@Override
	public void createFunFinancStatus(Integer cityId, Integer compId, List<ErpFunFinanceStatus> paramList) {
		if(paramList.size() == 0){
			return;
		}
		int index = 0;
		for(ErpFunFinanceStatus erpFunFinanceStatus : paramList){
			if(StringUtils.isEmpty(erpFunFinanceStatus.getFinancName())){
				continue;
			}
			index++;
			erpFunFinanceStatus.setSeqNo(index);
			erpFunFinanceStatus.setShardCityId(cityId);
			if(null == erpFunFinanceStatus.getFinancStatusId()){// 不存在时新增
				erpFunFinanceStatus.setCreateTime(new Date());
				erpFunFinanceStatus.setCanDel(new Byte("1"));
				erpFunFinanceStatus.setCompId(compId);
				// 类别	2：财务状态		1：合同类别
				Integer financStatusId = getHasFunFinancStatusID(cityId ,compId ,erpFunFinanceStatus.getFinancName());
				if(null == financStatusId){
					erpFunFinanceStatusMapper.insertSelective(erpFunFinanceStatus);
				}else{
					throw new BusinessException("财务状态名称不可重复");
				}

			} else {// 存在时通过主键修改
				erpFunFinanceStatusMapper.updateByPrimaryKeySelective(erpFunFinanceStatus);
			}
		}
	}

	private Integer getHasFunFinancStatusID(Integer cityId, Integer compId, String name){

		ErpFunFinanceStatusExample erpFunFinanceStatusExample = new ErpFunFinanceStatusExample();
		erpFunFinanceStatusExample.setShardCityId(cityId);
		erpFunFinanceStatusExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(new Byte("0")).andFinancNameEqualTo(name);

		List<ErpFunFinanceStatus> erpFunFinanceStatuses = erpFunFinanceStatusMapper.selectByExample(erpFunFinanceStatusExample);
		if(erpFunFinanceStatuses.size() > 0){
			return erpFunFinanceStatuses.get(0).getFinancStatusId();
		}else{
			return null;
		}

	}
}

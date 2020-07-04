package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunContractTagMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.po.ErpFunContractTag;
import com.myfun.repository.erpdb.po.ErpFunContractTagExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunContractTagService;
import com.myfun.service.business.erpdb.ErpFunDealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ErpFunContractTagServiceImpl extends AbstractService<ErpFunContractTag, ErpFunContractTag> implements ErpFunContractTagService {
	private static final Logger logger = LoggerFactory.getLogger(ErpFunContractTagServiceImpl.class);

	@Autowired
	ErpFunContractTagMapper erpFunContractTagMapper;
	@Autowired
	ErpFunDealService erpFunDealService;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;

	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunContractTagMapper;
	}


	@Override
	public void updateTagStatus(Integer cityId, Integer dealId, Integer compId, Integer deptId, Byte status, Integer crmCompId) {
		Boolean isYouJiaContract = erpFunDealService.isYouJiaDealByDealId(cityId, dealId, null, crmCompId);
		if (isYouJiaContract) {
			ErpFunDeal funDeal = new ErpFunDeal();
			funDeal.setDealId(dealId);
			funDeal.setShardCityId(cityId);
			funDeal = erpFunDealMapper.selectByPrimaryKey(funDeal);
			ErpFunContractTag updateModel = new ErpFunContractTag();
			updateModel.setTagStatus(status);
			updateModel.setUpdateId(Const.DIC_SYSTEM_USERID_999);
			updateModel.setUpdateTime(new Date());
			updateModel.setShardCityId(cityId);
			ErpFunContractTagExample contractTagExample = new ErpFunContractTagExample();
			contractTagExample.setShardCityId(cityId);
			contractTagExample.createCriteria().andContractIdEqualTo(funDeal.getContractId())
					.andCompIdEqualTo(funDeal.getCompId()).andDeptIdEqualTo(funDeal.getDeptId());
			erpFunContractTagMapper.updateByExampleSelective(updateModel, contractTagExample);
		} else {
			logger.error("合同信息错误!");
		}
	}
}

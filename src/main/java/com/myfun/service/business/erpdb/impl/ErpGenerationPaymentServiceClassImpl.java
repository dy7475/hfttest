package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunGenerationPaymentClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunGenerationPaymentMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentClassParam;
import com.myfun.repository.erpdb.param.ErpFunGenerationPaymentParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunGenerationPaymentClassService;
import com.myfun.service.business.erpdb.ErpFunGenerationPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ErpGenerationPaymentServiceClassImpl extends AbstractService<ErpFunGenerationPaymentClass, ErpFunGenerationPaymentClass> implements ErpFunGenerationPaymentClassService {

	@Autowired
	ErpFunGenerationPaymentClassMapper erpFunGenerationPaymentClassMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunGenerationPaymentClassMapper;
	}

	@Transactional
	@Override
	public void addEditGenerationPaymentClass(Integer cityId, Integer compId, ErpFunGenerationPaymentClassParam erpFunGenerationPaymentClassParam) {

		List<ErpFunGenerationPaymentClass> erpFunGenerationPaymentClassList = JSON.parseObject(erpFunGenerationPaymentClassParam.getGenerationPaymentClassList(), new TypeReference<List<ErpFunGenerationPaymentClass>>() {});

		Integer dataLength = erpFunGenerationPaymentClassList.size();
		if(dataLength == 0) {
			throw new BusinessException("至少保留一个代扣或代缴类型");
		}
		dataLength ++ ;
		for (ErpFunGenerationPaymentClass erpFunGenerationPaymentClass : erpFunGenerationPaymentClassList) {
			if(null == erpFunGenerationPaymentClass.getCompAmount()) {
				erpFunGenerationPaymentClass.setCompAmount(new BigDecimal(0));
			}
			if(null == erpFunGenerationPaymentClass.getPersonAmount()) {
				erpFunGenerationPaymentClass.setPersonAmount(new BigDecimal(0));
			}
			erpFunGenerationPaymentClass.setShardCityId(cityId);
			erpFunGenerationPaymentClass.setClassSeq(dataLength);
			if(null != erpFunGenerationPaymentClass.getId()) {
				erpFunGenerationPaymentClassMapper.updateByPrimaryKeySelective(erpFunGenerationPaymentClass);
			}else {
				erpFunGenerationPaymentClass.setCompId(compId);
				erpFunGenerationPaymentClass.setCreateTime(new Date());
				erpFunGenerationPaymentClassMapper.insertSelective(erpFunGenerationPaymentClass);
			}
			dataLength -- ;
		}
	}

	/**
	 * @Title 删除奖罚数据
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public Integer delGenerationPaymentClass(Integer cityId, Integer userId, ErpFunGenerationPaymentClassParam erpFunGenerationPaymentParam) {

		ErpFunGenerationPaymentClass erpFunGenerationPaymentClass = new ErpFunGenerationPaymentClass();
		erpFunGenerationPaymentClass.setId(erpFunGenerationPaymentParam.getId());
		erpFunGenerationPaymentClass.setIsDel((byte) 1);
		erpFunGenerationPaymentClass.setShardCityId(cityId);
		return erpFunGenerationPaymentClassMapper.updateByPrimaryKeySelective(erpFunGenerationPaymentClass);

	}
}

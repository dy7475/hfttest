package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunFinancPaymentMapper;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunFinancPaymentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunFinancPaymentServiceImpl extends AbstractService<ErpFunFinancPayment, ErpFunFinancPayment> implements ErpFunFinancPaymentService {

	@Autowired
	ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunFinancPaymentMapper;
	}


	/**
	 *  初始化财务款项配置
	 * **/
	@Override
	public void createCompTempleteFinancPaymentList(Integer cityId, Integer compId) {
		erpFunFinancPaymentMapper.createCompTempleteFinancPaymentList(cityId, compId);
	}

	@Transactional
	@Override
	public void updateFinancPaymentList(Integer cityId, Integer compId, List<ErpFunFinancPayment> paramList) {
		int index = 0;
		for(ErpFunFinancPayment erpFunFinancPayment : paramList){
			if(StringUtils.isBlank(erpFunFinancPayment.getPaymentName())){
				continue;
			}
			index++;
			erpFunFinancPayment.setSeqNo(index);
			erpFunFinancPayment.setShardCityId(cityId);
			if(null == erpFunFinancPayment.getPaymentId()){// 不存在时新增
				erpFunFinancPayment.setCreateTime(new Date());
				erpFunFinancPayment.setCanDel(1);
				erpFunFinancPayment.setCompId(compId);
				// 类别	2：财务状态		1：合同类别
				Integer paymentId = getHasFunFinancPaymentId(cityId, compId, erpFunFinancPayment.getPaymentName());
				if(null == paymentId){
					erpFunFinancPaymentMapper.insertSelective(erpFunFinancPayment);
				}else{
					throw new BusinessException("财务款项名称不可重复");
				}

			} else {// 存在时通过主键修改
				erpFunFinancPaymentMapper.updateByPrimaryKeySelective(erpFunFinancPayment);
			}

		}
	}

	private Integer getHasFunFinancPaymentId(Integer cityId, Integer compId, String paymentName) {

		ErpFunFinancPaymentExample erpFunFinancPaymentExample = new ErpFunFinancPaymentExample();
		erpFunFinancPaymentExample.setShardCityId(cityId);
		erpFunFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(new Byte("0")).andPaymentNameEqualTo(paymentName);

		List<ErpFunFinancPayment> erpFunFinancePayments = erpFunFinancPaymentMapper.selectByExample(erpFunFinancPaymentExample);
		if(erpFunFinancePayments.size() > 0){
			return erpFunFinancePayments.get(0).getPaymentId();
		}else{
			return null;
		}

	}

	@Override
	public Integer deletePaymentById(Integer cityId, Integer paymentId) {
		ErpFunFinancPayment erpFunFinancPayment = new ErpFunFinancPayment();
		erpFunFinancPayment.setShardCityId(cityId);
		erpFunFinancPayment.setPaymentId(paymentId);
		erpFunFinancPayment.setIsDel((byte) 1);
		return erpFunFinancPaymentMapper.updateByPrimaryKeySelective(erpFunFinancPayment);
	}
}

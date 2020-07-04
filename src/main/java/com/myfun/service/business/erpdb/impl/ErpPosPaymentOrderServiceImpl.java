package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpPosPaymentOrderMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrder;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrderExample;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpPosPaymentOrderService;
import com.myfun.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ErpPosPaymentOrderServiceImpl extends AbstractService<ErpPosPaymentOrder, ErpPosPaymentOrder> implements ErpPosPaymentOrderService {
	@Autowired private ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
	@Autowired private ErpProcessFinancMapper erpProcessFinancMapp;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpPosPaymentOrderMapper;
	}


	/**
	 * title ：a
	 * athor：lcb
	 * date  : 2017/10/27
	 * @Param financeType 1:诚意金 2:合同 3：普通收款
	 */
	@Transactional
	@Override
	public void asynchronousNotify(String orderNo, Integer cityId, Integer payStatus, Integer financeType,
								   Integer compId, Integer deptId, String paymentTime, String financeIds,
								   String posMachineId, String financeMoney ) {

		if(StringUtils.isBlank(financeIds)) {
			return;
		}
		String[] split = financeIds.split(",");
		Set<Integer> financeIntegerIds = new HashSet<>();
		for (String s : split) {
			financeIntegerIds.add(Integer.valueOf(s));
		}
		ErpPosPaymentOrder erpPosPaymentOrder = new ErpPosPaymentOrder();
		erpPosPaymentOrder.setOrderNo(orderNo);
		erpPosPaymentOrder.setPaymentTime(DateUtil.StringToDate(paymentTime, "yyyy-MM-dd HH:mm:ss"));
		erpPosPaymentOrder.setPosMachineId(posMachineId);
		erpPosPaymentOrder.setPayStatus(payStatus.byteValue());
		// 查询款项
		if(1==financeType || 2==financeType) {
			ErpPosPaymentOrderExample erpPosPaymentOrderExample = new ErpPosPaymentOrderExample();
			erpPosPaymentOrderExample.setShardCityId(cityId);
			erpPosPaymentOrderExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).
			andFinanceTypeEqualTo(financeType.byteValue()).andFinanceIdIn(new ArrayList<>(financeIntegerIds));
			erpPosPaymentOrderMapper.updateByExampleSelective(erpPosPaymentOrder ,erpPosPaymentOrderExample);
		} else {
			// 普通收款订单
			erpPosPaymentOrder.setShardCityId(cityId);
			erpPosPaymentOrder.setCompId(compId);
			erpPosPaymentOrder.setDeptId(deptId);
			erpPosPaymentOrder.setCreationTime(erpPosPaymentOrder.getPaymentTime());
			erpPosPaymentOrder.setFinanceType(new Byte("3")); // 普通收款
			erpPosPaymentOrder.setFinanceMoney(new BigDecimal(financeMoney));
			erpPosPaymentOrder.setFinanceName("普通收款");
			erpPosPaymentOrderMapper.insertSelective(erpPosPaymentOrder);
		}
	}

	@Transactional
	@Override
	public void delPosOrder(Integer cityId, Integer orderId, Integer financeId) {
		ErpPosPaymentOrder erpPosPaymentOrder = new ErpPosPaymentOrder();
		erpPosPaymentOrder.setShardCityId(cityId);
		erpPosPaymentOrder.setPayStatus(new Byte("3"));
		erpPosPaymentOrder.setId(orderId);
		erpPosPaymentOrder.setFinanceId(financeId);
		// 更新款项ID的支付类型

		ErpProcessFinanc erpProcessFinanc = new ErpProcessFinanc();
		erpProcessFinanc.setShardCityId(cityId);
		erpProcessFinanc.setPfId(financeId);

		erpProcessFinanc.setPayTypeDesc(" ");
		erpProcessFinanc.setPaymentType(1);
		erpProcessFinancMapp.updateByPrimaryKeySelective(erpProcessFinanc);

		erpPosPaymentOrderMapper.updateByPrimaryKeySelective(erpPosPaymentOrder);
	}
}

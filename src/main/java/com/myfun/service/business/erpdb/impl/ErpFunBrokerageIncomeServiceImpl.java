package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.constract.param.SaveBrokerageParamAndVo;
import com.myfun.repository.erpdb.dao.ErpFunBrokerageIncomeMapper;
import com.myfun.repository.erpdb.dao.ErpFunBrokerageMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunBrokerageExample;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncomeExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBrokerageIncomeService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ErpFunBrokerageIncomeServiceImpl extends AbstractService<ErpFunBrokerageIncome, ErpFunBrokerageIncome> implements ErpFunBrokerageIncomeService {

	@Autowired
	ErpFunBrokerageIncomeMapper erpFunBrokerageIncomeMapper;
	@Autowired
	ErpFunBrokerageMapper erpFunBrokerageMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunBrokerageIncomeMapper;
	}

	@Override
	public void initBrokerageIncomeByCompId(Integer cityId, List<ErpFunBrokerageIncome> paramList) {

		// 批量写入数据配置
		erpFunBrokerageIncomeMapper.insertBatch(cityId, paramList);

	}

	@Override
	public void initBrokerageByCompId(Integer cityId, List<ErpFunBrokerage> erpFunBrokerages) {
		// 批量写入数据配置
		erpFunBrokerageMapper.insertBatch(cityId, erpFunBrokerages);
	}

	/**
	 * @tag 编辑分佣比例
	 * @author 邓永洪
	 * @since 2018/7/23
	 */
	@Transactional
	@Override
	public void updateBrokerageIncome(Integer userId, Integer cityId, Integer compId, List<ErpFunBrokerageIncome> pList, String profitPercentRule) {
		if (pList != null && pList.size() > 0) {
			for (ErpFunBrokerageIncome brokerageIncome : pList) {
				ErpFunBrokerageIncomeExample funBrokerageIncomeExample = new ErpFunBrokerageIncomeExample();
				funBrokerageIncomeExample.setShardCityId(cityId);
				ErpFunBrokerageIncomeExample.Criteria criteria = funBrokerageIncomeExample.createCriteria();
				criteria.andCommionTypeEqualTo(brokerageIncome.getCommionType());
				if (brokerageIncome.getId() != null) {
					criteria.andIdEqualTo(brokerageIncome.getId());
				} else {
					criteria.andCompIdEqualTo(compId);
				}
				erpFunBrokerageIncomeMapper.updateByExampleSelective(brokerageIncome, funBrokerageIncomeExample);
			}
		}
		if (StringUtils.isBlank(profitPercentRule)) {
			return;
		}
		erpSysParaMapper.updateOaramValueByCompId(cityId, profitPercentRule, null, compId, "PROFIT_PERCENT_RULE");
		//重新登录
		erpFunUsersService.updateUserStatusBySysPara(userId, cityId, compId);
		//清理缓存
		erpSysParaService.evictSysParamCache(cityId, compId);
	}

	@Override
	public SaveBrokerageParamAndVo getBrokerageByComp(Integer cityId, Integer compId) {
		 SaveBrokerageParamAndVo resultVo = new SaveBrokerageParamAndVo();
		ErpFunBrokerageExample erpFunBrokerageExample = new ErpFunBrokerageExample();
        erpFunBrokerageExample.setShardCityId(cityId);
        erpFunBrokerageExample.createCriteria().andCompIdEqualTo(compId);
        erpFunBrokerageExample.setOrderByClause("ID DESC");
        List<ErpFunBrokerage> erpFunBrokerages = erpFunBrokerageMapper.selectByExample(erpFunBrokerageExample);
       
        if (erpFunBrokerages.size() == 0 && 0 != compId) {
            erpFunBrokerageExample = new ErpFunBrokerageExample();
            erpFunBrokerageExample.setShardCityId(cityId);
            erpFunBrokerageExample.createCriteria().andCompIdEqualTo(0);
            erpFunBrokerages = erpFunBrokerageMapper.selectByExample(erpFunBrokerageExample);
            for (ErpFunBrokerage erpFunBrokerageIncome : erpFunBrokerages) {
                erpFunBrokerageIncome.setCompId(compId);
                erpFunBrokerageIncome.setId(null);
            }
            if (erpFunBrokerages.size() > 0) {
                initBrokerageByCompId(cityId, erpFunBrokerages);
            }
        }
        int i = 0;
        for (ErpFunBrokerage po : erpFunBrokerages) {
            if (i > 1) {
                break;
            }
            BigDecimal brokerageRate = Optional.ofNullable(po.getBrokerageRate()).orElse(BigDecimal.ZERO);
            po.setBrokerageRate(brokerageRate.setScale(2, BigDecimal.ROUND_HALF_UP));
            BigDecimal chargeCustRate = Optional.ofNullable(po.getChargeCustRate()).orElse(BigDecimal.ZERO);
            po.setChargeCustRate(chargeCustRate.setScale(2, BigDecimal.ROUND_HALF_UP));
            BigDecimal chargeHouseRate = Optional.ofNullable(po.getChargeHouseRate()).orElse(BigDecimal.ZERO);
            po.setChargeHouseRate(chargeHouseRate.setScale(2, BigDecimal.ROUND_HALF_UP));
            if (101 == po.getSaleLease()) {
                resultVo.setSaleBrokerage(po);
            } else if (102 == po.getSaleLease()) {
                resultVo.setLeaseBrokerage(po);
            }
        }
        return resultVo;
	}

}

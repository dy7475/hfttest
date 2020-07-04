package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunWageConfigMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.param.ErpFunWageConfigParam;
import com.myfun.repository.erpdb.po.ErpFunWageConfig;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunWageConfigService;
import com.myfun.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Service
public class ErpFunWageConfigServiceImpl extends AbstractService<ErpFunWageConfig, ErpFunWageConfig> implements ErpFunWageConfigService {

	@Autowired private ErpFunWageConfigMapper erpFunWageConfigMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunWageConfigMapper;
	}

	/**
	 * @Title 修改薪资配置数据
	 * @Author lcb
	 * @Date 2018/1/4
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateWageConfig(Integer cityId, Integer compId, Integer userId, ErpFunWageConfigParam param) {
		Integer res = 0;
		// 直接查询当前考核周期内的配置，因为数据库每天在匹配数据
		String wageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		Date[] wageCycleDate = DateUtil.getWageCycleDate(null,wageAccountingDay);

		ErpFunWageConfig erpFunWageConfig = erpFunWageConfigMapper.getCurrentCycleConfig(cityId, compId, wageCycleDate[0], wageCycleDate[1]);

		if(null != erpFunWageConfig) {
			param.setId(erpFunWageConfig.getId());
			param.setShardCityId(cityId);
			erpFunWageConfigMapper.updateByPrimaryKeySelective(param);
		}else {
			// 新增
			res = addWageConfig(cityId, compId, userId,param);
		}
		return res;
	}

	private Integer addWageConfig(Integer cityId, Integer compId, Integer userId, ErpFunWageConfigParam param) {
		param.setCompId(compId);
		param.setCreateUid(userId);
		param.setCreateTime(new Date());
		param.setUpdateTime(new Date());
		param.setShardCityId(cityId);
		erpFunWageConfigMapper.insertSelective(param);
		return param.getId();

	}

}

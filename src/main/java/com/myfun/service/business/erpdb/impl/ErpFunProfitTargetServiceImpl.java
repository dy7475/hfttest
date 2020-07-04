package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.constract.vo.UserPositionAndLevelDto;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunRecalculateWageInfoMapper;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ProfitCountReportDto;
import com.myfun.repository.erpdb.param.CreateOrUpdateByHandProfitParam;
import com.myfun.repository.erpdb.param.ErpProfitMessageFormParam;
import com.myfun.repository.erpdb.param.QueryProfitCountReportParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunProfitTargetServiceImpl extends AbstractService<ErpFunProfitTarget, ErpFunProfitTarget> implements ErpFunProfitTargetService {

	@Autowired
	ErpFunProfitTargetMapper erpFunProfitTargetMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunProfitTargetMapper;
	}

	@Transactional
	@Override
	public void insertOrUpdateProfitTarget(Integer cityId, List<ErpFunProfitTarget> profitTargetPOList, Byte profitType, String profitDate) {
		String keyFild = null;
		String key= null;
		switch(profitType){
			case Const.DIC_PROFIT_TYPE_PERSONAL:
				keyFild = "USER_ID";
				key="userId";
				break;
			case Const.DIC_PROFIT_TYPE_GROUP:
				keyFild = "GR_ID";
				key="grId";
				break;
			case Const.DIC_PROFIT_TYPE_DEPT:
				keyFild = "DEPT_ID";
				key="deptId";
				break;
			case Const.DIC_PROFIT_TYPE_REG:
				keyFild = "REG_ID";
				key="regId";
				break;
			case Const.DIC_PROFIT_TYPE_AREA:
				keyFild = "AREA_ID";
				key="areaId";
				break;
			case Const.DIC_PROFIT_TYPE_COMP:
				keyFild = "COMP_ID";
				key="compId";
				break;
		}
		// 获取需要删除的ID
		String[] delKeys = BeanUtil.buildQueryKeysNoRepeat(profitTargetPOList, key);
		// 获取不需要删除的主键
		String[] ids = BeanUtil.buildQueryKeysNoRepeat(profitTargetPOList, "id");
		// 删除防止插入重复目标业绩
		/**
		 * 打开业绩目标页面，第一次没有ID，保存时直接插入，但再点一次保存时，由于页面没重新拉取数据，还是没有ID，造成了再次插入的情况
		 * 所以需要删除，来兼容以前的数据，以后就叫前段刷新下当前页的数据 zhl
		 */
		if(delKeys != null && delKeys.length > 0){
			erpFunProfitTargetMapper.deleteByParam(cityId,keyFild,delKeys,profitType,profitDate,ids);
		}

		// 录入目标业绩 存在主键时将跟新目标业绩
		for(ErpFunProfitTarget profitTargetPO : profitTargetPOList){
			profitTargetPO.setShardCityId(cityId);
			Integer primaryId = profitTargetPO.getId();
			if(primaryId!=null){
				erpFunProfitTargetMapper.updateByPrimaryKeySelective(profitTargetPO);
			}else{
				erpFunProfitTargetMapper.insertSelective(profitTargetPO);
			}
		}
	}
}

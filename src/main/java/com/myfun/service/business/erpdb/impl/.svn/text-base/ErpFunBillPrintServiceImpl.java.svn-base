package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunProfitDto;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ErpFunBillPrintServiceImpl extends AbstractService<ErpFunBillPrint, ErpFunBillPrint> implements ErpFunBillPrintService {

	@Autowired
	ErpFunBillPrintMapper erpFunBillPrintMapper;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;
	@Autowired
	ErpFunBillCodelogService erpFunBillCodelogService;


	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunBillPrintMapper;
	}

	@Transactional
	@Override
	public void deleteRelativeIdsByFinancIds(Integer cityId,Integer compId, List<String> delBillRelativeIds, Map<Integer, ErpProcessFinanc> financMap) {
		if (!delBillRelativeIds.isEmpty()) {
			erpFunBillMapper.updateBillStatusByIds(cityId,compId,delBillRelativeIds);

			erpFunBillPrintMapper.deleteByIds(cityId,compId,delBillRelativeIds);
			for (String pfId:delBillRelativeIds) {
				ErpProcessFinanc processFinancPO = financMap.get(pfId);
				if (processFinancPO!=null) {
					erpFunBillCodelogService.updateBillCodeLogStatus(cityId,compId, processFinancPO.getBillCodeNo(), "2");
				}
			}
		}
	}
}

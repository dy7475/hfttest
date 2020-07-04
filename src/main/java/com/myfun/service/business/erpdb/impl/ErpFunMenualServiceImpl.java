package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminErpBuildingInfoTmpMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunMenualMapper;
import com.myfun.repository.erpdb.dto.ErpDicDefinitionsDto;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.erpdb.po.ErpFunMenual;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;

@Service
public class ErpFunMenualServiceImpl extends AbstractService<ErpFunMenual, ErpFunMenual> implements ErpFunMenualService {
	@Autowired
	ErpFunMenualMapper erpFunMenualMapper;

	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired
	AdminErpBuildingInfoTmpMapper adminErpBuildingInfoTmpMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunMenualMapper;
	}

	@Override
	public ErpFunMenual getBizMnaualData(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		ErpFunMenual erpFunMenual = new ErpFunMenual();
		erpFunMenual.setShardCityId(param.getInteger("cityId"));
		erpFunMenual.setMuId(Integer.valueOf(pMap.get("muId")+""));
		return erpFunMenualMapper.selectByPrimaryKey(erpFunMenual);
	}

	@Override
	public List<ErpDicDefinitionsDto> getBizAllMnaualList(BaseMapParam param) {
		List<ErpDicDefinitionsDto> resList = new ArrayList<>();
		// 查询字典
		ErpDicDefinitions erpDicDefinitions = new ErpDicDefinitions();
		erpDicDefinitions.setDicType("MENUAL_TYPE");
		erpDicDefinitions.setShardCityId(param.getInteger("cityId"));
		List<ErpDicDefinitions> dicList = erpDicDefinitionsMapper.getDicDefinitionsByCondition(erpDicDefinitions);

		// 处理数据
		StringBuilder sb = new StringBuilder("");
		for (ErpDicDefinitions erpDicDefinitions1: dicList) {
			String dicValue = erpDicDefinitions1.getDicValue();
			sb.append(dicValue).append(",");
			ErpDicDefinitionsDto erpDicDefinitionsDto =new ErpDicDefinitionsDto();
			try {
				BeanUtils.copyProperties(erpDicDefinitionsDto, erpDicDefinitions1);
			}catch(Exception e) {

			}
			resList.add(erpDicDefinitionsDto);
		}
		String types="";
		if(sb.indexOf(",") > -1) {
			types = sb.substring(0, sb.length()-1);
		}
		// 查询FunMenual数据
		Map<String, Object> pMap = new HashedMap();
		pMap.put("compId", param.getInteger("compId"));
		pMap.put("deptId", param.getInteger("deptId"));
		pMap.put("menualTypes", types);
		List<ErpFunMenual> erpFunMenualList = erpFunMenualMapper.selectListByTypes(pMap, param.getInteger("cityId"));
		// 处理是否有子节点
		List<String> valueList = new ArrayList<>();
		for (ErpFunMenual erpFunMenual : erpFunMenualList) {
			valueList.add(erpFunMenual.getMenualType().toString());
		}

		for (ErpDicDefinitionsDto erpDicDefinitionsDto: resList ) {
			Integer count = 0;
			if(valueList.contains(erpDicDefinitionsDto.getDicValue())) {
				count = 1;
			}
			erpDicDefinitionsDto.setMenualCount(count);
		}
		return resList;
	}

	@Override
	public void updateBizAllMnaual(BuildingInfoTmpParam buildingInfoTmpParam) {
		adminErpBuildingInfoTmpMapper.insertBuilInfoTmp(buildingInfoTmpParam);
	}
}




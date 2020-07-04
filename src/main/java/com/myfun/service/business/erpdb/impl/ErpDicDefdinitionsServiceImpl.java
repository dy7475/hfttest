package com.myfun.service.business.erpdb.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.repository.erpdb.po.ErpDicDefinitionsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;

@Service
public class ErpDicDefdinitionsServiceImpl extends AbstractService<ErpDicDefinitions, ErpDicDefinitions> implements ErpDicDefdinitionsService {
	@Autowired 
	private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired 
	private CacheUtil cacheUtil;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpDicDefinitionsMapper;
	}

	@Override
	public List<ErpDicDefinitions> getDicDefinitionsByCondition(ErpDicDefinitions erpDicDefinitions) {
		List<ErpDicDefinitions> resList = erpDicDefinitionsMapper.getDicDefinitionsByCondition(erpDicDefinitions);
		return resList;
	}

	@Override
	public Map<String, Map<String, Map<String,ErpDicDefinitions>>> getAllDefinitions(Integer cityId){
		List<ErpDicDefinitions> erpDicDefinitions = erpDicDefinitionsMapper.getAllDicDefinitions(cityId);
		//DIC_KEY例如： HOUSE_ROUND_1 代表 成都的环域数据 陈文超
		//结构：HOUSE_ROUND_1 - HOUSE_ROUND - DIC_VALUE = DIC_OBJ
		Map<String, Map<String, Map<String,ErpDicDefinitions>>> cityDicMap = new HashMap<String, Map<String, Map<String,ErpDicDefinitions>>>();
		for(ErpDicDefinitions definitionsPO : erpDicDefinitions){
			//DIC_KEY 例如：HOUSE_ROUND_1 代表 成都的环域数据 陈文超
			String dicTypeTmp = definitionsPO.getDicType();
			String dicCityKey = dicTypeTmp + "_" + definitionsPO.getCityId();
			Map<String, Map<String,ErpDicDefinitions>> temp = cityDicMap.get(dicCityKey);
			if (temp == null) {
				//KEY = DIC_TYPE
				temp = new HashMap<String, Map<String, ErpDicDefinitions>>();
				Map<String,ErpDicDefinitions> dicRealValue = new HashMap<String, ErpDicDefinitions>();
				dicRealValue.put(definitionsPO.getDicValue(), definitionsPO);
				temp.put(dicTypeTmp, dicRealValue);
				cityDicMap.put(dicCityKey, temp);
			}else{
				temp.get(dicTypeTmp).put(definitionsPO.getDicValue(), definitionsPO);
			}
		}
		return cityDicMap;
	}
	
	@Override
	public ErpDicDefinitions getDicValue(String dicType ,String dicValue , Integer cityId){
		Map<String, Map<String, Map<String,ErpDicDefinitions>>> mapValue = this.getAllDefinitions(cityId);
		String dicCityKey = dicType + "_" + cityId;
		Map<String, Map<String, ErpDicDefinitions>> temp = mapValue.get(dicCityKey);
		if(temp==null){
			String dic = dicType + "_0";
			temp = mapValue.get(dic);
		}
		Map<String, ErpDicDefinitions> tmpDicValue = temp.get(dicType);
		if(tmpDicValue!= null){
			return tmpDicValue.get(dicValue);
		}else{
			throw new ConfirmException(dicType+"字典数据获取错误！");
		}
	
	}
	
	/**
	 * 获取英文
	 * @author 熊刚
	 * @since 2017年10月20日
	 * @param dicType
	 * @param dicValue
	 * @param cityId
	 * @return
	 */
	@Override
	public String getErpDicEnMsg(String dicType, String dicValue, Integer cityId){
		return this.getDicValue(dicType, dicValue, cityId).getDicEnMsg();
	}

	/**
	 * 获取中文
	 * @author 熊刚
	 * @since 2017年10月20日
	 * @param dicType
	 * @param dicValue
	 * @param cityId
	 * @return
	 */
	@Override
	public String getErpDicCnMsg(String dicType, Integer dicValue, Integer cityId) {
		return this.getDicValue(dicType, dicValue.toString(), cityId).getDicCnMsg();
	}

	@Override
	public void evictCacheableModelData() {
	    cacheUtil.del(CacheStructure.hfterpdb_commonCache_dicDefinition_map_map);
	    cacheUtil.del(CacheStructure.hfterpdb_commonCache_dicDefinition_map_list);
	}

	public List<ErpDicDefinitions> getDicValues(Integer cityId,String dicType, List<String> dicValues) {
		if (dicType==null || null == dicValues || dicValues.isEmpty()) {
			//避免NullPoint
			return Collections.emptyList();
		}
		ErpDicDefinitionsExample example = new ErpDicDefinitionsExample();
		example.setShardCityId(cityId);
		example.createCriteria().andDicTypeEqualTo(dicType).andDicValueIn(dicValues);
		return erpDicDefinitionsMapper.selectByExample(example);
	}
}

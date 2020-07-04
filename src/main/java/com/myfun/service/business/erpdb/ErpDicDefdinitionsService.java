package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.support.mybatis.api.BaseMapper;



public interface ErpDicDefdinitionsService extends BaseMapper<ErpDicDefinitions, ErpDicDefinitions>{
	/**
	 * 数据字典查询
	 * **/
	List<ErpDicDefinitions> getDicDefinitionsByCondition(ErpDicDefinitions erpDicDefinitions) throws Exception;
	/**
	 * 查询全部数据字典
	 * @author 陈文超
	 * @date 2016年6月1日 下午4:24:44
	 */
	Map<String, Map<String, Map<String,ErpDicDefinitions>>> getAllDefinitions(Integer cityId)throws Exception;
	
	/**
	 * 获取字典的对象
	 * @author 陈文超
	 * @date 2016年6月1日 下午4:48:56
	 */
	ErpDicDefinitions getDicValue(String dicType, String dicValue ,Integer cityId);
	/**
	 * 获取字典的英文值
	 * @author 陈文超
	 * @date 2016年6月1日 下午4:48:56
	 */
	String getErpDicEnMsg(String dicType, String dicValue ,Integer cityId);
	/**
	 * 获取字典的中文值
	 * @author 陈文超
	 * @date 2016年6月1日 下午4:48:56
	 */
	String getErpDicCnMsg(String dicType, Integer dicValue ,Integer cityId);

	void evictCacheableModelData();

	/**
	 *
	 * @param cityId
	 * @param dicType
	 * @param dicValues
	 * @return
	 */
	List<ErpDicDefinitions> getDicValues(Integer cityId,String dicType, List<String> dicValues);
}

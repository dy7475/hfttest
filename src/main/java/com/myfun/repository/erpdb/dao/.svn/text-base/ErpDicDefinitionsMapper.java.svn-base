package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.erpWeb.common.vo.ErpDicDefinitionsVo;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpDicDefinitionsExample;

public interface ErpDicDefinitionsMapper extends BaseMapper<ErpDicDefinitions, ErpDicDefinitions> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpDicDefinitionsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpDicDefinitionsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpDicDefinitions> selectByExample(ErpDicDefinitionsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpDicDefinitions record,
			@Param("example") ErpDicDefinitionsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpDicDefinitions record, @Param("example") ErpDicDefinitionsExample example);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpDicDefinitions> getDicDefinitionsByCondition(ErpDicDefinitions erpDicDefinitions);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpDicDefinitions> getAllDicDefinitions(@Param("shardCityId")Integer cityId);
	
	/**
	 * 通过类型和值获取对应的对象
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param cityId 城市ID
	 * @param dicType 字典类型
	 * @param dicValue 字典值
	 * @return
	 */
	ErpDicDefinitions getDicDefinitions(@Param("shardCityId")Integer cityId,@Param("dicType") String dicType,@Param("dicValue") String dicValue);
	
	/**
	 * 通过类型和值获取对应的中文解释
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param cityId 城市ID
	 * @param dicType 字典类型
	 * @param dicValue 字典值
	 * @return
	 */
	String getDicCnMsg(@Param("shardCityId")Integer cityId,@Param("dicType") String dicType,@Param("dicValue") String dicValue);

	List<ErpDicDefinitions> getDicDefinitionsByUpdateTime(@Param("shardCityId")Integer cityId,@Param("updateTime") String updateTime);

    List<ErpDicDefinitionsVo> getDicDefinitionsVoList(@Param("shardCityId")Integer cityId,@Param("updateTime") String updateTime);
    
    /**
	 * 通过类型和多个值获取整条字典数据
	 * @param cityId
	 * @param string
	 * @param fileTypeList
	 * @return 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpDicDefinitions> getDicListByDicValues(@Param("shardCityId") Integer cityId, @Param("dicType") String dicType, @Param("dicValues") List<Byte> dicValues);
}
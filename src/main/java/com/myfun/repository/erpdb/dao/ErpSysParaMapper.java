package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpSysParaExample;
import com.myfun.repository.erpdb.po.ErpSysParaKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@SwitchDB(type=SwitchDBType.COMP_ID)
public interface ErpSysParaMapper extends BaseMapper<ErpSysPara, ErpSysParaKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpSysParaExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpSysParaExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpSysPara> selectByExample(ErpSysParaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpSysPara record, @Param("example") ErpSysParaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpSysPara record, @Param("example") ErpSysParaExample example);

	/**
	 * 修改参数信息
	 * @param cityId 
	 * @param string
	 * @param enterCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateOaramValueByCompId(@Param("shardCityId") Integer cityId, @Param("parvalue")String parvalue, @Param("defaultVal")String defaultVal,
			@Param("compId")Integer compId, @Param("paramId")String paramId);

	/**
	 * 使用开库时添加公司系统参数
	 * @param cityId
	 * @param compId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertSysParaComp(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	/**
	 * 使用开库时修改公司系统参数
	 * @param erpSysPara
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateSysParaComp(ErpSysPara erpSysPara);


	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getParamValue(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("paramId")String paramId);


	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpSysPara> selectSysParaByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * 查询指定参数
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId
	 * @param compId
	 * @param params
	 * @return
	 */
	List<ErpSysPara> selectByParams(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("params")String[] params);
	
	/**
	 * 查询公司的系统参数
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	@MapKey("paramId")
	Map<String,ErpSysPara> getParaMapForLogin(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("partnerId") Integer partnerId);

	void cleanPartnerSysParam(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("sysParams") List<String> sysParams);

	void cleanSysParamByPartnerId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("partnerId")Integer partnerId, @Param("sysParams") List<String> sysParams);

	void copyCompSysParamToPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
								   @Param("partnerIds") List<Integer> partnerIds, @Param("sysParams") List<String> sysParams);

	void copyCompRoleSysParamToPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
									   @Param("partnerIds") List<Integer> partnerIds, @Param("sysParams") List<String> sysParams);

	void cleanCompPartnerSysParam(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("sysParams") List<String> sysParams);

	void cleanRoleSysParamByPartnerId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerId") Integer partnerId, @Param("sysParams") List<String> sysParams);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpSysPara> selectSysParamByBusinessType(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("businessType") Integer businessType);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void excuteSys(@Param("shardCityId") Integer cityId);

    /**  美联委托资料配置设置
    * @author 蔡春林
    * @date 2019/11/27 0027
    * @param cityId
    * @param record
    * @return int
    */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	int mlEntrustParamSetting(@Param("shardCityId") Integer cityId, @Param("record") ErpSysPara record);

	List<ErpSysPara> selectMLParamWithBusinessType(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("businessType") Integer businessType, @Param("paramId") String sysParamId);
	List<ErpSysPara> selectMLParamWithParamIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("businessType") Integer businessType, @Param("paramIds") List<String> paramIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpSysPara> selectMLSysParas(@Param("shardCityId") Integer cityId,  @Param("compId") Integer compId, @Param("businessType") Integer businessType);

	void cleanAllPartnerSysParam(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	void copyAllCompSysParamToPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("partnerIds") List<Integer> partnerIds);
	
	ErpSysPara getValueById(@Param("shardCityId") Integer cityId,@Param("erpCompId") Integer erpCompId, @Param("paramId") String paramId);
	

	@SwitchDB(type = SwitchDBType.CITY_ID)
	int deleteByCompId(@Param("shardCityId")Integer cityId, @Param("compId") Integer erpCompId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpSysPara> selectByParamIds(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("initializeParamIds") String initializeParamIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateParamValues(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("paramIds") List<String> paramIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateDefaultValues(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("defaultIds") List<String> defaultIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateMediumIdsValues(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("mediumIds") List<String> mediumIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateSeniorIdsValues(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("seniorIds") List<String> seniorIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateSysParaLevelToDefId(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("paramIds") String paramIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getParamByCompNo(@Param("shardCityId")Integer cityId, @Param("compNo")String compNo, @Param("paramId") String paramId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void insertWageTypeForComp(@Param("shardCityId") Short cityId, @Param("compId")Integer compId);

	@SwitchDB(type = SwitchDBType.COMP_ID)
	ErpSysPara selectByParamId(@Param("shardCityId")Integer cityId,@Param("erpCompId") Integer erpCompId,@Param("paramId") String paramId);

	@SwitchDB(type = SwitchDBType.COMP_ID)
	List<ErpSysPara> selectByOrgId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("organizationId") Integer organizationId);

	void copyParameterStrategyWithDef(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
							   @Param("organizationId") Integer organizationId, @Param("sysParams") List<String> sysParams,
							   @Param("defalutValue") Integer defalutValue);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateParameterStrategy(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("organizationId") Integer organizationId,
								 @Param("paramId") String paramId, @Param("paramValue") String paramValue);

    List<ErpSysPara> selectMLSysParamByOrgId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("orgId")Integer orgId, @Param("paramId")String paramId);
    List<ErpSysPara> selectMLSysParamListByOrgId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("orgId")Integer orgId, @Param("paramIds")List<String> paramId);

	void copyParameterStrategy(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
									  @Param("organizationId") Integer organizationId, @Param("sysParams") List<String> sysParams);

	void updateParameterBlank(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
						 @Param("businessType") Integer businessType, @Param("paramId") String paramId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getParamValueWithPartnerId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("partnerId") Integer partnerId, @Param("paramId") String sysParamId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	int updateValue(ErpSysPara record);
	/**
	 * 更新参数（不区分住宅工商铺）
	 * @author HuangJiang
	 * @since 2020年02月25日 9:50
	 * @param cityId
	 * @param erpSysPara
	 * @return void
	 * Modified XXX HuangJiang 2020年02月25日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateParamValueByParamId(@Param("shardCityId") Integer cityId, @Param("erpSysPara") ErpSysPara erpSysPara);
}
package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.house.param.UpdateEntrustFileConfigParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SysParamConfigInMeiLianParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SysParamConfigInPartnerListParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpSysParaKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.framework.session.Operator;

import java.util.List;
import java.util.Map;

public interface ErpSysParaService extends BaseMapper<ErpSysPara, ErpSysParaKey>{
	public boolean updateMgrParameter(BaseMapParam param);
	public boolean updateMgrParameterStrategy(BaseMapParam param);

	public Map<String,ErpSysPara> getSysParaByCompId(Integer cityId,Integer compId,boolean isPersonal);
	
	public ErpSysPara getErpSysPara(Integer compId, Integer cityId, String paraName);
	
	/**
	 * 获取指定参数的map
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId
	 * @param compId
	 * @param params
	 * @param isPersonal
	 * @return
	 */
	public Map<String,ErpSysPara> getByParams(Integer cityId, Integer compId, String[] params, boolean isPersonal);
	
	/**
	 *根据信息的租售求租求购类型判断当前系统该类型下是否是公盘运行模式,目前用于写跟进功能中和任务功能中 
	 * @author 熊刚
	 * @since 2017年10月19日
	 * @param caseType
	 * @param cityId
	 * @param compId
	 * @return
	 */
	public boolean getSysRunModelIsPublic(Integer caseType,Integer cityId,Integer compId);
	
	/**
	 * 根据信息的租售求租求购类型判断当前系统该类型下是否是私盘运行模式,目前用于写跟进功能中和任务功能中
	 * @author 熊刚
	 * @since 2017年10月18日
	 * @param caseType
	 * @param cityId
	 * @param compId
	 * @return
	 */
	public boolean getSysRunModelIsPrivate(Integer caseType,Integer cityId,Integer compId);
	
	/**
	 * 获取房源信息加密的MD5
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param roof
	 * @param unit
	 * @param floor
	 * @param num
	 * @param buildId
	 * @param useage
	 * @param tradeAddr
	 * @param cityId
	 * @param compId
	 * @return
	 */
	public List<String> encodeToMD5(String roof, String unit, String floor, String num, Integer buildId, Byte useage, String tradeAddr, Integer cityId, Integer compId);
	
	/**
	 * 清除公司缓存
	 * @param compId
	 */
	void evictSysParamCache(Integer cityId, Integer compId);

    Integer updateSysPara(Integer cityId, Integer compId, String paramId, String paramValue);
    
    String getHouseCustTimeColumn(Integer cityId, Integer compId);

    /**
     * 修改策略参数开关
     * @author 朱科
     * @since 2018年7月23日
     * @return
     */
    void updateInfoByPlot(Integer cityId, Integer compType, Integer compId, Integer plotSwitch, Integer partnerId);
    
    /**
     * 关闭策略参数更新标记
     * @author 朱科
     * @since 2018年7月23日
     * @return
     */
    void clearFlagByPlctSwotch(Integer cityId, Integer compType, Integer compId, Integer partnerId);




	void mlEntrustParamSetting(UpdateEntrustFileConfigParam param,Operator operator);
	
	public boolean isOpenNewOrganization(Integer cityId, Integer compId);

	void sysParamConfigInMeiLian(GeneralParam generalParam, SysParamConfigInMeiLianParam param);


	/**
	 * ===========================================================美联系统参数查询========================================================================
	 *
	 * 系统参数查询，按经纪人所属部门类型，ORGANIZATION_BUSSINESS_TYPE 1=住宅 2=工商铺 3=后勤部门 分开管控配置
	 * 查询时：BUSINESS
	 * 1.公司表erp fun_comp 上分开管控标记
	 * 2.fun_organization 	ORGANIZATION_BUSSINESS_TYPE 标记了部门类型，可知道经纪人所属类型
	 * 3.分开管控时查询对应erp..sys_para [PARTNER_ID] <-->[fun_organization..ORGANIZATION_BUSSINESS_TYPE]对应值【1,2,3↑】
	 * 4.查询时需要带指定经纪人userId
	 */
	ErpSysPara getMLSysParamByUserType(Integer cityId, Integer compId, Integer userId, String paramId);
	/**
	 * 默认值为 ""
	 */
	String getMLSysParamValByUserDefEmpty(Integer cityId, Integer compId, Integer userId, String paramId);

	/**
	 * 默认值为 "0"
	 */
	String getMLSysParamValByUserDefZero(Integer cityId, Integer compId, Integer userId, String paramId);
	/**
	 * 查询列表
	 */
	List<ErpSysPara> getMLSysParamList(Integer cityId, Integer compId, Integer userId, List<String> paramIds);

	List<ErpSysPara> getMLSysParamListDefEmpty(Integer cityId, Integer compId, Integer userId, List<String> paramIds);

	List<ErpSysPara> getMLSysParamListDefZero(Integer cityId, Integer compId, Integer userId, List<String> paramIds);


	/**
	 * 查询字典
	 */
	Map<String, String> getMLSysParamMapByUserType(Integer cityId, Integer compId, Integer userId, List<String> paramIds);

	Map<String, Map<String, Object>> getMLSysParaMap(Integer cityId, Integer compId, Integer userId, List<String> sysParas);

	void copyParameterStrategy(Integer cityId, Integer compId, Integer organizationId);

	/**
	 * ===========================================================美联系统参数查询========================================================================
	 */
	ErpSysPara getMLErpSysParamByOrgId(Integer cityId, Integer compId, Integer orgId, String paramId);
	List<ErpSysPara> getMLErpSysParamListByOrgId(Integer cityId, Integer compId, Integer orgId, List<String> paramId);
	String getMLErpSysParamValByOrgId(Integer cityId, Integer compId, Integer orgId, String paramId);
}
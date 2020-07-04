package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.house.vo.FunKeyDetailDto;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrSubmitKeyLogParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunKeyDto;
import com.myfun.repository.erpdb.po.ErpFunKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.condition.BaseQuery;
import com.myfun.repository.erpdb.po.ErpFunKeyExample;

public interface ErpFunKeyMapper extends BaseMapper<ErpFunKey, ErpFunKey> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunKeyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunKeyExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunKey> selectByExample(ErpFunKeyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunKey record, @Param("example") ErpFunKeyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunKey record, @Param("example") ErpFunKeyExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List <ErpFunKeyDto> selectListByCondition(@Param("shardCityId") Integer shardCityId,@Param("baseQuery")BaseQuery baseQuery);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param conditionModel
	 */
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	int countFunKey(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("conditionModel")ErpFunKey conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param conditionModel
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunKey selectKey(@Param("shardCityId")Integer cityId,@Param("conditionModel") ErpFunKey conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param keyIds
	 */	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void deleteFunKey(@Param("shardCityId")Integer cityId,@Param("keyIds")Object[] keyIds);

	/**
	 * 钥匙日子列表
	 **/
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunKeyDto> getMgrSubmitKeyLogList(@Param("shardCityId") Integer cityId, @Param("param") GetMgrSubmitKeyLogParam param);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getKeyIdsByCondition(@Param("shardCityId")Integer cityId, @Param("param")ErpFunKey condition);
	
	/**
	 * 获得已有的钥匙编号
	 * @author 臧铁
	 * @since 2017年7月13日
	 * @param caseId
	 * @param caseType
	 * @param curCompId 经纪人公司ID
	 * @param cityId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getExistNum(@Param("caseId")Integer caseId, @Param("caseType")Byte caseType, @Param("compId")Integer curCompId, @Param("shardCityId")Integer cityId);

	/**
	 * 获得新的钥匙编号
	 * @author 臧铁
	 * @since 2017年7月13日
	 * @param keyDeptId 以提交钥匙申请人的DEPTID和USERID为主  钥匙的所在门店
	 * @param curCompId 经纪人公司ID
	 * @param cityId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunKey> getNewNum( @Param("keyDeptId")Integer keyDeptId, @Param("compId")Integer curCompId, @Param("shardCityId") Integer cityId);
	/**
	 * 根据钥匙编号查询钥匙信息
	 * @author 何传强
	 * @since 2017年8月16日
	 * @param cityId
	 * @param map
	 * @return
	 */
	ErpFunKey getKeyInfoByKeyNum(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	public void updateErpFunKey(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType,@Param("deptId")Integer deptId);
	ErpFunKey getErpFunKey(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType);
	
	/**
	 * 通过房源ID获取钥匙列表
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 * @param saleLeaseId
	 * @param saleLeaseType
	 * @return
	 */
	List<ErpFunKey> getListByCaseId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("caseId")Integer caseId, @Param("caseType")Integer caseType, 
			@Param("saleLeaseId")Integer saleLeaseId, @Param("saleLeaseType")Byte saleLeaseType);
	
	/**
	 * 修改钥匙状态和钥匙日志ID
	 * @author 张宏利
	 * @since 2017年10月30日
	 * @param cityId 城市ID
	 * @param keyLogId 钥匙日志ID
	 * @param keyStatus 钥匙状态
	 */
	void updateKeyStatusAndLogId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("keyId")Integer keyId, @Param("keyLogId")Integer keyLogId, @Param("keyStatus")Integer keyStatus);

	ErpFunKey getKeyModel(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseType")Byte caseType,@Param("caseId")Integer caseId,@Param("saleLeaseType")Integer saleLeaseType,
			@Param("saleLeaseId")Byte saleLeaseId);

	ErpFunKey getErpFunKeyById(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("keyId")Integer keyId);

	/**
	 * 获取最新钥匙编号
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/20
	 */
	String getKeyNum(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("deptNo") String deptNo, @Param("userId") Integer userId);

	/**
	 * @tag 获取钥匙详情
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
    FunKeyDetailDto getKeyDetailDto(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("caseId") Integer caseId,
									@Param("caseType") Integer caseType,@Param("saleLeaseId") Integer saleLeaseId,@Param("saleLeaseType") Byte saleLeaseType);
    
    FunKeyDetailDto getKeyDetailDtoNewOrg(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("caseId") Integer caseId,
										@Param("caseType") Integer caseType,@Param("saleLeaseId") Integer saleLeaseId,@Param("saleLeaseType") Byte saleLeaseType);
    
    /**
     * 根据trackIds查询钥匙提交列表
     * @author 朱科
     * @since 2018年10月15日
     * @return
     */
    List<ErpFunKey> getFunKeyListByTrackIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("trackIds") Set<Integer> trackIds);

	List<Map<String,Object>> countCroupeByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rate") BigDecimal rate, @Param("cityRate") BigDecimal cityRate, @Param("organizationId")Integer organizationId, @Param("position")String position, @Param("userId")Integer userId);
}


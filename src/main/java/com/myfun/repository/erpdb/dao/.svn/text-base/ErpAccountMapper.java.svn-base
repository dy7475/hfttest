package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAccountMapper extends BaseMapper<ErpAccount, ErpAccount> {
	
	List<ErpAccount> selectAccountList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	ErpAccount selectByAtIdAndCompId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("atId")Integer atId, @Param("partnerId") Integer partnerId, @Param("openPartner") Integer openPartner);
	
	ErpAccount selectByActIdAndCompId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("actId")Integer actId);

	ErpAccount selectPreAccount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("atId") Integer atId,
			@Param("creationTime")String creationTime);

	List<ErpAccount> selectPreAccountList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
			 @Param("atId")Integer atId,  @Param("creationTime")String creationTime);

	void updateBeforeAccount(@Param("shardCityId")Integer cityId, @Param("aduitTime") String aduitTime,
			@Param("userId")Integer userId, @Param("record") ErpAccount record);
	
	List<ErpAccount> getAccountList(@Param("shardCityId")Integer cityId, @Param("param")AccountParam param);

	void updateAcountAfterThisOne(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
								  @Param("atId")Integer atId, @Param("creationTime")String creationTime,
								  @Param("amount") BigDecimal amount, @Param("actFlag") Boolean actFlag);

}
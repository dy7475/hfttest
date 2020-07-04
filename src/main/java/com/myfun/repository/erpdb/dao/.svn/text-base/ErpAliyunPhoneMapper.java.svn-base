package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.axn.param.AxnManageListParam;
import com.myfun.repository.erpdb.dto.AliyunPhoneDto;
import com.myfun.repository.erpdb.po.ErpAliyunPhone;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAliyunPhoneMapper extends BaseMapper<ErpAliyunPhone, ErpAliyunPhone> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpAliyunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAliyunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAliyunPhone> selectByExample(ErpAliyunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAliyunPhone record,
			@Param("example") ErpAliyunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAliyunPhone record, @Param("example") ErpAliyunPhoneExample example);

	/**
     * 解绑
     * @param shardCityId
     * @param bindX
     */
    void unBindNumber(@Param("shardCityId") Integer shardCityId,@Param("bindX") String bindX);
    
    /**
     * 释放
     * @param shardCityId
     * @param bindX
     */
    void releaseNumber(@Param("shardCityId") Integer shardCityId,@Param("bindX") String bindX);
    
    ErpAliyunPhone getPhoneNumber(@Param("shardCityId") Integer shardCityId,@Param("compId") Integer compId,@Param("bindX") String bindX);
    
    /**
     * 随机获得一个未绑定的号码
     * @param shardCityId
     * @param compId
     * @param orgId
     * @return
     */
    ErpAliyunPhone getUnbindPhoneNumber(@Param("shardCityId") Integer shardCityId,@Param("compId") Integer compId,@Param("orgId") Integer orgId);
    
    /**
     * 隐号管理列表
     * @param shardCityId
     * @param compId
     * @param bindFlag
     * @return
     */ 
    List<AliyunPhoneDto> getAxnManageList(@Param("shardCityId") Integer shardCityId,@Param("param") AxnManageListParam param);
    
    List<ErpAliyunPhone> getNumberManageList(@Param("shardCityId") Integer shardCityId,@Param("compId") Integer compId,@Param("numberPoolKey") String numberPoolKey,@Param("keys") String keys);
    
    ErpAliyunPhone getPhoneNumberByBindA(@Param("shardCityId") Integer shardCityId,@Param("compId") Integer compId,@Param("bindA") String bindA);

	ErpAliyunPhone getTop1Available(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
}
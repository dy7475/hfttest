package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunPhoneDto;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunPhone;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunPhoneExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;

public interface ErpFunPhoneMapper extends BaseMapper<ErpFunPhone, ErpFunPhone> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPhone> selectByExample(ErpFunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPhone record, @Param("example") ErpFunPhoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPhone record, @Param("example") ErpFunPhoneExample example);

	public void deleteByCondition(ErpFunPhone erpFunPhone);
	
	public void insertEntryList(@Param("shardDbName") String shardDbName,@Param("createPhones") List<ErpFunPhone> createPhones);
	
	List<ErpFunPhone> getErpFunPhoneList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType);
	
	/**
	 * 修改电话表的所属人信息
	 * 
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param createAuditUser
	 */
	void updateBelongUser(@Param("shardCityId") Integer cityId, @Param("caseId") Integer caseId,
			@Param("caseType") Integer caseType, @Param("erpFunUsers") ErpFunUsers erpFunUsers);

	List<ErpFunPhoneDto> getPhoneCountList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("caseType") Integer caseType, @Param("cellPhoneList") List<String> cellPhoneList);
	
	ErpFunPhone selectPhoneByCaseOffSeq(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseId")Integer caseId, @Param("caseType")Byte caseType, @Param("phoneIndex")byte phoneIndex);

	int updateByExampleSelectiveForCityId(@Param("record") ErpFunPhone record, @Param("example") ErpFunPhoneExample example, @Param("shardCityId")Integer shardCityId);

}



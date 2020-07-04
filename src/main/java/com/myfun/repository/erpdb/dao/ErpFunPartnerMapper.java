package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.sysmanager.param.QueryPartnerDeptParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SearchPartnerParam;
import com.myfun.repository.erpdb.dto.PartnerDeptDto;
import com.myfun.repository.erpdb.po.ErpFunPartner;
import com.myfun.repository.erpdb.po.ErpFunPartnerExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunPartnerMapper extends BaseMapper<ErpFunPartner, ErpFunPartner> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPartnerExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPartnerExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPartner> selectByExample(ErpFunPartnerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPartner record, @Param("example") ErpFunPartnerExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPartner record, @Param("example") ErpFunPartnerExample example);

	int countEnterpriseCreditCode(@Param("shardCityId")Integer cityId, @Param("enterpriseCreditCode") String enterpriseCreditCode);
	int countPartnerName(@Param("shardCityId")Integer cityId, @Param("partnerName") String partnerName);

    List<ErpFunPartner> selectAllPartner(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);

    ErpFunPartner selectById(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("id") Integer id);

    List<ErpFunPartner> selectPartners(@Param("shardCityId")Integer cityId,@Param("param") SearchPartnerParam param);

    List<ErpFunPartner> selectByUserId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);

    List<PartnerDeptDto> selectPartnerDeptList(@Param("shardCityId")Integer cityId, @Param("param")QueryPartnerDeptParam param);

	List<ErpFunPartner> selectPartnersForOrg(@Param("shardCityId")Integer cityId,@Param("param") SearchPartnerParam param);
}
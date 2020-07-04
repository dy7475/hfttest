package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpYouComplaintProof;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouComplaintProofMapper extends BaseMapper<ErpYouComplaintProof, ErpYouComplaintProof> {

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpYouComplaintProof> getComplaintProosList(@Param("shardCityId")Integer cityId, @Param("complainId")Integer complainId);
}
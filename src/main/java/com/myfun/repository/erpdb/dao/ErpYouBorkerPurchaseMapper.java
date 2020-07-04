package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jdom.Element;

import com.myfun.repository.erpdb.dto.ErpYouBorkerPurchaseDto;
import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouBorkerPurchaseMapper extends BaseMapper<ErpYouBorkerPurchase, ErpYouBorkerPurchase> {

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpYouBorkerPurchaseDto> getPurchaseRecords(@Param("shardCityId")Integer cityId, @Param("youShareId")Integer youShareId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpYouBorkerPurchase selectByPurchaseId(@Param("shardCityId")Integer cityId, @Param("purchaseId")Integer purchaseId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	int updateBorkerPurchaseAll(@Param("shardCityId")Integer cityId, @Param("targetInfoId")Integer targetInfoId);

	int updateByShareId(ErpYouBorkerPurchase borkerPurchase);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpYouBorkerPurchase> getHousePurchaseList(@Param("shardCityId")Integer cityId, @Param("purchaseId")Integer targetInfoId);

}
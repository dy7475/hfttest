package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.HouseCaseIdDto;
import com.myfun.repository.erpdb.po.ErpFunSalePublishInfo;
import com.myfun.repository.erpdb.po.ErpFunSalePublishInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunSalePublishInfoMapper extends BaseMapper<ErpFunSalePublishInfo, ErpFunSalePublishInfo> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSalePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunSalePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunSalePublishInfo> selectByExample(ErpFunSalePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunSalePublishInfo record,
			@Param("example") ErpFunSalePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunSalePublishInfo record,
			@Param("example") ErpFunSalePublishInfoExample example);

	
	List<HouseCaseIdDto> getWaitDownHouseList(@Param("shardCityId")Integer cityId, @Param("salesId") List<Integer> salesId);

    List<HouseCaseIdDto> getNotWriteOffHouseList(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);

	List<HouseCaseIdDto> getUserSalesOnWebsite(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);
}

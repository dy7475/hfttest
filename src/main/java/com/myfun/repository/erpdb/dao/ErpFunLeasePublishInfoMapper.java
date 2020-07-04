package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.HouseCaseIdDto;
import com.myfun.repository.erpdb.po.ErpFunLeasePublishInfo;
import com.myfun.repository.erpdb.po.ErpFunLeasePublishInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunLeasePublishInfoMapper extends BaseMapper<ErpFunLeasePublishInfo, ErpFunLeasePublishInfo> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunLeasePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunLeasePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunLeasePublishInfo> selectByExample(ErpFunLeasePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunLeasePublishInfo record,
			@Param("example") ErpFunLeasePublishInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunLeasePublishInfo record,
			@Param("example") ErpFunLeasePublishInfoExample example);

	List<HouseCaseIdDto> getNotWriteOffHouseList(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);

	List<HouseCaseIdDto> getWaitDownHouseList(@Param("shardCityId")Integer cityId, @Param("leaseIdsList") List<Integer> leaseIdsList);

    List<HouseCaseIdDto> getUserLeasesOnWebsite(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);
}
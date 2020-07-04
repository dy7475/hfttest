package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.vo.OwnerUserVO;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwnersExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunEntrustOwnersMapper extends BaseMapper<ErpFunEntrustOwners, ErpFunEntrustOwners> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEntrustOwnersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEntrustOwnersExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEntrustOwners> selectByExample(ErpFunEntrustOwnersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEntrustOwners record,
			@Param("example") ErpFunEntrustOwnersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEntrustOwners record,
			@Param("example") ErpFunEntrustOwnersExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	int updateByOwnerId(@Param("shardCityId") Integer cityId, @Param("ownerId") Integer ownerId, @Param("entrustId") Integer entrustId, @Param("signPicAddr") String signPicAddr);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<OwnerUserVO> selectByEntrustIds(@Param("shardCityId") Integer cityId, @Param("entrustIds") List<Integer> entrustIds);
    
	/**
	 * 修改业主信息
	 * @author HuangJiang
	 * @since 2019年11月27日 21:06
	 * @param erpFunEntrustOwners
	 * @return void
	 * Modified XXX HuangJiang 2019年11月27日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateOwnersInfo(ErpFunEntrustOwners erpFunEntrustOwners);


	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunEntrustOwners selectByEntrustIdAndOwnerCardNo(@Param("shardCityId") Integer cityId, @Param("entrustId") Integer entrustId, @Param("cardNo") String cardNo);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	int updateByentrustId(@Param("shardCityId") Integer cityId, @Param("entrustId") Integer entrustId, @Param("signPicAddr") String signPicAddr);
}
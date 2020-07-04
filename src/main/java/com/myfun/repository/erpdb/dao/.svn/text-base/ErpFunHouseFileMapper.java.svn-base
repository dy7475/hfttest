package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.transaction.param.HouseOrCustomerEnclosureParam;
import com.myfun.erpWeb.managecenter.transaction.vo.EnclosureVo;
import com.myfun.repository.erpdb.po.ErpFunHouseFile;
import com.myfun.repository.erpdb.po.ErpFunHouseFileExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunHouseFileMapper extends BaseMapper<ErpFunHouseFile, ErpFunHouseFile> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunHouseFileExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunHouseFileExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunHouseFile> selectByExample(ErpFunHouseFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunHouseFile record,
			@Param("example") ErpFunHouseFileExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunHouseFile record, @Param("example") ErpFunHouseFileExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<EnclosureVo> getHouseFile(@Param("shardCityId")Integer shardCityId,@Param("paramData")HouseOrCustomerEnclosureParam param);
}
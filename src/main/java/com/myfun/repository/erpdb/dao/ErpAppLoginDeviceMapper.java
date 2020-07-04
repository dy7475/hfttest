package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetAppLoginDeviceListParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpAppLoginDeviceDto;
import com.myfun.repository.erpdb.po.ErpAppLoginDevice;
import com.myfun.repository.erpdb.po.ErpAppLoginDeviceExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAppLoginDeviceMapper extends BaseMapper<ErpAppLoginDevice, ErpAppLoginDevice> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAppLoginDeviceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAppLoginDeviceExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAppLoginDevice> selectByExample(ErpAppLoginDeviceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAppLoginDevice record,
			@Param("example") ErpAppLoginDeviceExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAppLoginDevice record, @Param("example") ErpAppLoginDeviceExample example);

	/**
	 * 获取app登录设备审核列表
	 * @author 何传强
	 * @since 2017年6月12日
	 * @param shardCityId
	 * @param param
	 * @return
	 */
	List<ErpAppLoginDeviceDto> getAppLoginDeviceList(@Param("shardCityId") Integer shardCityId,@Param("param") GetAppLoginDeviceListParam param);
	/**
	 * 	审核
	 * @author 熊刚
	 * @since 2017年6月12日
	 * @param erpAppLoginDevice
	 */
	void updateDeviceStatus(ErpAppLoginDevice erpAppLoginDevice);
	/**
	 * 当审核通过后其余的过期
	 * @author 熊刚
	 * @since 2017年6月12日
	 * @param erpAppLoginDevice
	 */
	void updateDeviceStatusOverdue(ErpAppLoginDevice erpAppLoginDevice);

}
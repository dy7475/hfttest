package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.houseBidding.vo.HousePubFlagAllDto;
import com.myfun.repository.erpdb.po.ErpFunHousePublishStatus;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Map;

public interface ErpFunHousePublishStatusService  extends BaseMapper<ErpFunHousePublishStatus, ErpFunHousePublishStatus>{
	/**
	 * 根据条件查询对象
	 * @param obj
	 * @return
	 */
	public ErpFunHousePublishStatus getDataObject(ErpFunHousePublishStatus obj);
	
	/**
	 * 获取库存
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @return
	 *
	 */
	HousePubFlagAllDto getHousePubFlagAll(Integer cityId, Integer archiveId, Integer userId, Integer compId, Integer qqPublish);
}

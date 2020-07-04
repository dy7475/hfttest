package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月8日 下午6:19:32 
 * 类说明 
*/
public interface AdminDisCountConfigService extends BaseMapper<AdminDiscountConfig, Integer> {
	/**
	 * 获取折扣配置信息
	 * @param cityId
	 * @param type
	 * @return
	 */
	AdminDiscountConfig getConfigByCityAndType(Integer cityId, String type);
	
	/**
	 * 查询控件费
	 * @param cityLevel
	 * @param string
	 * @return
	 */
	AdminDiscountConfig getRecordByCityLevelAndType(Byte cityLevel, String string);

}

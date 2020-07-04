package com.myfun.service.business.admindb;

import java.math.BigDecimal;

import com.myfun.repository.admindb.po.AdminZhiyePayLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * 知业支付记录
 * @author 张宏利
 * @since 2017年6月22日
 */
public interface AdminZhiyePayLogService extends BaseMapper<AdminZhiyePayLog, Integer> {
	/**
	 * 创建一条支付记录
	 * @author 张宏利
	 * @since 2017年6月22日
	 * @return
	 */
	int createPayLog(Integer archiveId, String coursesType, String coursesId, String mediaId, String subjectId, BigDecimal payAmount);
	
	/**
	 * 判断是否已购买，有效期30以内的
	 * @author 张宏利
	 * @since 2017年6月22日
	 * @return
	 */
	boolean isPay(Integer archiveId, String mediaId);
}

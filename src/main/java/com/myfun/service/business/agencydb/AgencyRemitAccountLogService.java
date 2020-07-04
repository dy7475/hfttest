package com.myfun.service.business.agencydb;

import java.util.List;

import com.myfun.repository.agencydb.po.AgencyRemitAccountLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 下午3:20:07 
 * 类说明 
*/
public interface AgencyRemitAccountLogService extends BaseMapper<AgencyRemitAccountLog, Integer> {
	/**
	 * 获取账户日志
	 * @param archiveId
	 * @param compFlag
	 * @return
	 */
	List<AgencyRemitAccountLog> getPaidedHistory(String archiveId, String compFlag);

}

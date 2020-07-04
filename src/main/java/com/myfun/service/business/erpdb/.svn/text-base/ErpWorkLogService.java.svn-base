/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpWorkLogDto;
import com.myfun.repository.erpdb.po.ErpWorkLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateWorkLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryWorkLogListParam;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
public interface ErpWorkLogService  extends BaseMapper<ErpWorkLog, ErpWorkLog>{

	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param param
	 */
	
	
	void createOrUpdateWorkLog(CreateOrUpdateWorkLogParam param) throws Exception;
	/**
	 * @author 方李骥
	 * @since 2016年9月22日
	 * @param param
	 * @throws Exception 
	 */
	
	void adultWorkLog(CreateOrUpdateWorkLogParam param, String nowTime) throws Exception;
	Map<String, Object> detectExistLog(BaseMapParam param) throws Exception;
	
	Map<String, Object> getBizWorkLogList(Integer cityId,QueryWorkLogListParam param) throws Exception;
	
	ErpWorkLogDto selectWorkLogInfo(Integer cityId, Integer wlId) throws Exception;

}

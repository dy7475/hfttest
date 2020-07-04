package com.myfun.service.business.erpdb;

import java.util.Date;
import java.util.List;

import com.myfun.repository.erpdb.dto.ErpOutLogDto;
import com.myfun.repository.erpdb.po.ErpOutLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CreateOutLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;

public interface ErpOutLogService extends BaseMapper<ErpOutLog, ErpOutLog> {

	List<ErpOutLogDto> getMgrOutLogList(Integer cityId, QueryOutLogParam param);

	void createOutLog(Integer cityId, CreateOutLogParam param);
	
	/**
	 * 外出请假时创建外出日志
	 * @author 张宏利
	 * @since 2018年1月3日
	 * @param param
	 */
	void createOutLog(Integer cityId, Integer compId, Integer deptId, Integer userId, String outReason, Date startTime, Date endTime,Integer auditId);
	
	void outBack(Integer cityId,Integer userId);
}

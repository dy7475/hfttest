package com.myfun.service.business.erpdb;

import java.util.Date;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetSysLoginLogsParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPrologsService extends BaseMapper<ErpFunPrologs, ErpFunPrologs> {
	/**
	 * 登陆日志列表查询
	 */
	PageInfo<ErpFunPrologs> getSysLoginLogs(GetSysLoginLogsParam param, Integer compId, Integer cityId);

	PageInfo<ErpFunPrologs> getAppLoginLogs(GetSysLoginLogsParam param, Integer compId, Integer cityId);

	int countModelData(Integer cityId, Date nowTime, Integer compId, Integer userId);
	
	/**
	 * 退出登录
	 * @author 张宏利
	 * @since 2018年4月26日
	 * @param cityId
	 * @param prologsId
	 * @param outType
	 */
	void logout(Integer cityId, Integer prologsId, String outType);
}

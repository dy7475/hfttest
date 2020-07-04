package com.myfun.erpWeb.openApi.houseCust;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.photoDeal.FunArchiveController;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.utils.log.MybatisLogThreadLocal;
import com.myfun.utils.log.SqlInfo;

/**
 * 脚本执行压力测试
 * 
 * @author 张宏利
 * @since 2018年1月24日
 */
@Controller
@RequestMapping(value = "/openApi/funPhone")
public class ExecuteSqlTestController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(FunArchiveController.class);

	@Autowired
	ErpFunSaleService erpFunSaleService;
	@Autowired
	ErpFunLeaseService erpFunLeaseService;

	/**
	 * 测试出售
	 * 
	 * @author 张宏利
	 * @since 2018年1月24日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/testSaleSql")
	public ErpResponseJson testSaleSql(String rt, Long sleep, Integer allColumn) throws Exception {
		if(allColumn == null) {
			allColumn = 0;
		}
		List<Map<String, Object>> listList = erpFunSaleService.testSaleSql(132, allColumn);
		if (sleep == null || sleep < 200) {
			sleep = 10L;
		}
		String sqlExecTime = "";
		for (SqlInfo sqlInfo : MybatisLogThreadLocal.getLogRecord()) {
			sqlExecTime += sqlInfo.getSqlExecTime() + "ms;";
		}
		ErpResponseJson json = ErpResponseJson.ok();
		json.setExtra(sqlExecTime);
		Thread.sleep(sleep);
		if ("1".equals(rt)) {
			json.setData(listList);
		}
		return json;
	}

	/**
	 * 测试出售
	 * 
	 * @author 张宏利
	 * @since 2018年1月24日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/testLeaseSql")
	public ErpResponseJson testLeaseSql(String rt, Long sleep, Integer allColumn) throws Exception {
		if(allColumn == null) {
			allColumn = 0;
		}
		List<Map<String, Object>> listList = erpFunSaleService.testLeaseSql(132, allColumn);
		if (sleep == null || sleep < 200) {
			sleep = 10L;
		}
		String sqlExecTime = "";
		for (SqlInfo sqlInfo : MybatisLogThreadLocal.getLogRecord()) {
			sqlExecTime += sqlInfo.getSqlExecTime() + "ms;";
		}
		ErpResponseJson json = ErpResponseJson.ok();
		json.setExtra(sqlExecTime);
		Thread.sleep(sleep);
		if ("1".equals(rt)) {
			return ErpResponseJson.ok(listList);
		}
		return ErpResponseJson.ok();
	}

}

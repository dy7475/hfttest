package com.myfun.erpWeb.statisticalAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.support.annotation.AccessReadonlyDb;

/**
 * 统计分析-业绩龙虎版统计
 * @author flj
 * @2017-02-08 下午3:02:17
 */
@RestController
@RequestMapping("/statistic")
public class ErpExcuteSqlController extends BaseController{
@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	
	/**
	 * 执行sql的方法，一般情况不要调用
	 * 只读的查询，不能做修改操作
	 * @author 张宏利
	 * @since 2017年6月9日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AccessReadonlyDb
	@RequestMapping("/excuteSql")
	public ResponseJson testWorkCount(@RequestBody BaseMapParam param) throws Exception{
		Integer cityId = param.getInteger("cityId");
		String querySql = param.getString("querySql");
		String needTotal = param.getString("needTotal");
		List<Map<String,String>> returnList = new ArrayList<Map<String,String>>();
		Long total = 0L;
		if(StringUtils.isNotBlank(querySql)){
			returnList = erpFunRentCustomerMapper.excuteSqlList(cityId, querySql);
			if("1".equals(needTotal)) {
				total = erpFunRentCustomerMapper.excuteSqlCount(cityId, querySql);
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(returnList);
		responseJson.setTotal(total);
		return responseJson;
	}
	
}

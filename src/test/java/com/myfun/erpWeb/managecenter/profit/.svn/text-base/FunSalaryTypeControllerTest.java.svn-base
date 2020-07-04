package com.myfun.erpWeb.managecenter.profit;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class FunSalaryTypeControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
	}
	
	/**
	 * 查询工资方案列表
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getSalaryType() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("keyWord", "5");
		System.out.println(postNewErp(pMap,"/managecenter/profit/getSalaryType"));
	}
	
	/**
	 * 获取工资方案详情
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param id：主键id
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getSalaryTypeByData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("id", "7");
		System.out.println(postNewErp(pMap,"/managecenter/profit/getSalaryTypeByData"));
	}
	
	/**
	 * 工资考核方案下拉列表查询
	 * @author 臧铁
	 * @since 2017年8月29日
	 * @return
	 */
	@Test
	public void getSalaryTypeNameList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		System.out.println(postNewErp(pMap,"/managecenter/profit/getSalaryTypeNameList"));
	}
	
	/**
	 * 新增工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  
	 * stanrdassessmentTargetId:原有标准id
	 * salaryTypeName：方案名称    salaryMoney：基本薪资
	 * taskPercent：任务比例            tragetProfit：目标业绩
	 * @return
	 */
	@Test
	public void insertSalaryType() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("stanrdassessmentTargetId", "18");
		pMap.put("salaryTypeName", "王五er");
		pMap.put("salaryMoney", "3000");
		pMap.put("taskPercent", "80");
		pMap.put("tragetProfit", "1818.18");
		System.out.println(postNewErp(pMap,"/managecenter/profit/insertSalaryType"));
	}
	
	/**
	 * 删除工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  id：主键id
	 * @return  countFlag:有几个人在使用该工资方案
	 */
	@Test
	public void delSalaryTypeById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("id", "37");
		System.out.println(postNewErp(pMap,"/managecenter/profit/delSalaryTypeById"));
	}
}

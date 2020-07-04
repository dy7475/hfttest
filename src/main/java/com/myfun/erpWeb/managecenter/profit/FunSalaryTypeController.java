package com.myfun.erpWeb.managecenter.profit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myfun.framework.web.aspect.NotBlank;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunSalaryTypeMapper;
import com.myfun.repository.erpdb.dto.ErpFunSalaryTypeDto;
import com.myfun.repository.erpdb.param.ErpFunSalaryTypeParam;
import com.myfun.service.business.erpdb.ErpFunSalaryTypeService;


/**
 * 工资方案控制器
 * @author 臧铁
 * @since 2017年8月28日
 */
@RequestMapping(value="/managecenter/profit",method=RequestMethod.POST)
@RestController
public class FunSalaryTypeController  extends BaseController{
	@Autowired private ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired private ErpFunSalaryTypeService erpFunSalaryTypeService;
	
	/**
	 * 查询工资方案列表
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param keyWord:关键字
	 * @return
	 */
	@RequestMapping("/getSalaryType")
	public ResponseJson getSalaryType(@RequestBody ErpFunSalaryTypeParam param) {
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		if (StringUtils.isNotBlank(param.getKeyWord())) {
			param.setKeyWord("%" + param.getKeyWord() + "%");
		}
		List<ErpFunSalaryTypeDto> salaryTypeLists = erpFunSalaryTypeMapper.getSalaryType(param);
		return new ErpResponseJson(salaryTypeLists);
	}
	
	/**
	 * 获取工资方案详情
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param id：主键id
	 * @return
	 */
	@RequestMapping("/getSalaryTypeByData")
	public ResponseJson getSalaryTypeByData(@RequestBody ErpFunSalaryTypeParam param) {
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		List<ErpFunSalaryTypeDto> salaryTypeLists = erpFunSalaryTypeMapper.getSalaryType(param);
		if (salaryTypeLists.size() > 0) {
			return new ErpResponseJson(salaryTypeLists.get(0));
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 工资考核方案下拉列表查询
	 * @author 臧铁
	 * @since 2017年8月29日
	 * @return
	 *//*
	@RequestMapping("/getSalaryTypeNameList")
	public ResponseJson getSalaryTypeNameList(@RequestBody ErpFunSalaryTypeParam param) {
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		List<ErpFunSalaryTypeDto> salaryTypeLists = erpFunSalaryTypeMapper.getSalaryTypeNameList(param);
		return new ErpResponseJson(salaryTypeLists);
	}*/
	
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
	@RequestMapping("/insertSalaryType")
	@NotBlank({"salaryMoney"})
	public ResponseJson insertSalaryType(@RequestBody ErpFunSalaryTypeParam param) {
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		param.setCreateUserId(getOperator().getUserId());
		erpFunSalaryTypeService.insertSalaryType(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 删除工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  id：主键id
	 * @return countFlag:有几个人在使用该工资方案
	 */
	@RequestMapping("/delSalaryTypeById")
	public ResponseJson delSalaryTypeById(@RequestBody ErpFunSalaryTypeParam param) {
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		Integer countFlag = erpFunSalaryTypeService.delSalaryTypeById(param);
		Map<String,Integer> map = new HashMap<String, Integer>();
		if (countFlag == null) {
			return ErpResponseJson.ok();
		} else {
			map.put("countFlag", countFlag);
			return new ErpResponseJson(map);
		}
	}
}

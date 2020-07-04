package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.ErpFunSalaryTypeParam;
import com.myfun.repository.erpdb.po.ErpFunSalaryType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunSalaryTypeService extends BaseMapper<ErpFunSalaryType, ErpFunSalaryType>{
	
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
	public void insertSalaryType(ErpFunSalaryTypeParam param);

	/**
	 * 删除工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  id：主键id  confirm:确定删除标记 1=确定
	 * @return countFlag:有几个人在使用该工资方案
	 */
	public Integer delSalaryTypeById(ErpFunSalaryTypeParam param);
}


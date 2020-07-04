package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunBasewageDto;
import com.myfun.repository.erpdb.dto.ErpWagetypeUserRelativeDto;
import com.myfun.repository.erpdb.param.SaveSalaryPlanRelativeUserParam;
import com.myfun.repository.erpdb.po.ErpFunBasewage;
import com.myfun.repository.erpdb.po.ErpFunSalaryType;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBasewageService extends BaseMapper<ErpFunBasewage, ErpFunBasewage>{
	
	public void creatBasewage(ErpFunUsers erpFunUsers);
	
	/**
	 * 获取薪资方案列表，按员工获取
	 * @author 张宏利
	 * @since 2017年5月18日
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public List<ErpFunBasewageDto> getSalarySchemeListByUser(BaseMapParam param);

	/**
	 * 获取薪资方案列表，按业务类型获取
	 * @author 张宏利
	 * @since 2017年5月18日
	 * @param param
	 * @return
	 */
	public List<ErpFunWageTypeNew> getSalarySchemeListByType(BaseMapParam param);
	
	List<ErpWagetypeUserRelativeDto> getSalarySchemeUserList(Integer cityId, Integer wageTypeId);
	
	public void deleteSalaryScheme(Integer cityId, Integer compId, Integer wageTypeId);

	public List<ErpFunBasewageDto> getBaseWageList(Integer cityId,Integer compId,Integer deptId,String userPosition) throws Exception;
	
	public void updateBaseWage(Integer cityId, Integer compId, String baseWageJson) throws Exception;
	
	/**
	 * 获取薪资提成方案名称列表
	 * @author 方李骥
	 * @since 2017年5月18日
	 * @param wageTypeId 薪资方案ID
	 * @return
	 * @throws Exception
	 */
	public List<ErpFunWageTypeNew> getSalaryPlanNameList(
			Integer cityId, Integer compId);
	
	/**
	 * 修改薪资方案
	 * @author 张宏利
	 * @since 2017年5月24日
	 * @param param
	 * @return
	 */
	public void updateWagetypeUserRelative(SaveSalaryPlanRelativeUserParam param, List<ErpFunUsers> userList, ErpFunSalaryType erpFunSalaryType);
	
	/**
	 * 修改基本薪资
	 * @author 张宏利
	 * @since 2017年8月30日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param baseWage
	 */
	public void updateUserBasewage(Integer cityId, Integer compId, Integer userId, Integer baseWage);
	
	/**
	 * 重置个人提成方案
	 * @author 方李骥
	 * @since 2017年11月17日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param salaryTypeId
	 */
	public void resetWagetypeUserRelativeOffUserId(Integer cityId,Integer compId, Integer userId, Integer salaryTypeId);
}


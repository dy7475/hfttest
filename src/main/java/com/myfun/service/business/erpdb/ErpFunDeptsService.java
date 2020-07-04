package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.sysmanager.param.FunDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewDeptParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDeptsService extends BaseMapper<ErpFunDepts, ErpFunDepts> {

	int count(Integer cityId, String compNo, String deptNo);
	
	/**
	 * 查询部门信息
	 * @param
	 * @param
	 * @return
	 */
	ErpFunDepts queryDept(Integer archiveId);

	List<ErpFunDeptsDto> getDeptsList(Integer cityId, Integer regId);
	List<ErpFunDepts> getDeptListByRange(Integer cityId,ErpFunDepts conditon);

	List<ErpFunDeptsDto> getDeptListByReg(BaseMapParam param);

	List<ErpFunDepts> getDeptListByArea(Integer cityId,Integer compId,Integer areaId);
	Map<Object, ErpFunDepts> getAllDeptListByRange(Integer cityId,ErpFunDepts conditon);

	List<ErpFunDepts> getDeptListByDeptIds(Integer cityId, Set<Integer> deptIds);
	
	ErpFunDepts getDeptListByDeptId(Integer cityId, Integer deptIds);
	
	
	/**
	 * 员工调店
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param param
	 */
	void moveUserToNewDept(MoveUserToNewDeptParam param);
	
	/**
	 * 修改门店
	 * @author 朱科
	 * @since 2018年4月28日
	 * @param param
	 */
	void updateDept(FunDeptsParam param);
	
	public void evictDeptInfoByDeptPo(Integer cityId,Integer compId);

	/**
	 * 设置某一门店为总部门店或取消总部门店
	 * @param cityId
	 * @param isHQ 门店是否是总部 0 否 1 是
	 * @param deptId 门店ID
	 */
	void setOrCancleDeptHeadquarters(Integer cityId,Byte isHQ,Integer deptId);

	List<ErpFunDepts> getDeptListByUserIds(Integer cityId, Set<Integer> userIds);
}

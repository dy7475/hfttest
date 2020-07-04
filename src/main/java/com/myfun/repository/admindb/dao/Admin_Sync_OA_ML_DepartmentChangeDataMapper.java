package com.myfun.repository.admindb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myfun.framework.config.mybatis.CommonMapper;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_DepartmentChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_DepartmentChangeData;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_DeptVO;

/**
 * 
* @ClassName: Sync_OA_ML_UserChangeDataMapper 
* @Description: 同步HRS部门异动信息持久层
* @author fsjohnhuang
* @date 2020年6月22日 下午3:44:26 
*
 */
@Repository
public interface Admin_Sync_OA_ML_DepartmentChangeDataMapper extends CommonMapper<Admin_Sync_OA_ML_DepartmentChangeData> {

	/**
	 * 
	* @Title: getDeptTransferList 
	* @Description: 获取部门调迁列表 
	* @author tangliang1
	* @param @return  参数说明 
	* @return List<Admin_Sync_OA_ML_DeptVO>    返回类型 
	* @throws
	 */
	List<Admin_Sync_OA_ML_DeptVO> getDeptTransferList(Admin_Sync_OA_ML_DepartmentChangeDataParam param);
}

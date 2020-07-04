package com.myfun.service.business.admindb.synchrs;

import com.myfun.framework.config.mybatis.service.BaseFacadeService;
import com.myfun.framework.config.mybatis.service.JsonPageResponse;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_DepartmentChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_DepartmentChangeData;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_DeptVO;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeDataService 
* @Description: 部门异动信息接口
* @author tangliang1
* @date 2020年6月24日 下午12:43:21 
*
 */
public interface Admin_Sync_OA_ML_DepartmentChangeDataService extends BaseFacadeService<Admin_Sync_OA_ML_DepartmentChangeData> {

	/**
	 * 
	* @Title: getDeptTransferList 
	* @Description: 获取组织调迁列表 
	* @author tangliang1
	* @param @param param
	* @param @return  参数说明 
	* @return List<Admin_Sync_OA_ML_DeptVO>    返回类型 
	* @throws
	 */
	JsonPageResponse<Admin_Sync_OA_ML_DeptVO> getDeptTransferList(Admin_Sync_OA_ML_DepartmentChangeDataParam param);
}

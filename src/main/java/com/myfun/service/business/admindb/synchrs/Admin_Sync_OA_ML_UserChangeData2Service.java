package com.myfun.service.business.admindb.synchrs;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.mybatis.service.JsonPageResponse;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_UserChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_UserChangeData2;
import com.myfun.repository.admindb.vo.UserTransferVo;
import com.myfun.service.business.BaseService;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeDataService 
* @Description: 人员异动信息接口
* @author tangliang1
* @date 2020年6月24日 下午12:43:21 
*
 */
public interface Admin_Sync_OA_ML_UserChangeData2Service extends BaseService<Admin_Sync_OA_ML_UserChangeData2, Integer> {

	
	/**
	 * 
	* @Title: getUserTransferInfo 
	* @Description: 获取当前用户的调迁信息 
	* @author tangliang1
	* @param @param userId
	* @param @return  参数说明 
	* @return JSONObject    返回类型 
	* @throws
	 */
	JSONObject getUserTransferInfo(Integer userId);
	
	/**
	 * 
	* @Title: getUserTransferList 
	* @Description: 分页获取获取人员调迁记录
	* @author tangliang1
	* @param @param userChangeDataParam
	* @param @return  参数说明 
	* @return JsonPageResponse<<UserTransferVo>    返回类型 
	* @throws
	 */
	JsonPageResponse<UserTransferVo> getUserTransferList(Admin_Sync_OA_ML_UserChangeDataParam userChangeDataParam);
}

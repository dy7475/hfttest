package com.myfun.repository.admindb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myfun.framework.config.mybatis.CommonMapper;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_UserChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_UserChangeData;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_UserVO;
import com.myfun.repository.admindb.vo.UserTransferVo;

/**
 * 
* @ClassName: Sync_OA_ML_UserChangeDataMapper 
* @Description: 同步HRS人员异动信息持久层
* @author fsjohnhuang
* @date 2020年6月22日 下午3:44:26 
*
 */
@Repository
public interface Admin_Sync_OA_ML_UserChangeDataMapper extends CommonMapper<Admin_Sync_OA_ML_UserChangeData> {

	/**
	 * 
	* @Title: getSyncUserByHftUserId 
	* @Description: 获取指定用户当前职级信息 
	* @author tangliang1
	* @param @param userId
	* @param @return  参数说明 
	* @return Admin_Sync_OA_ML_UserVO    返回类型 
	* @throws
	 */
	Admin_Sync_OA_ML_UserVO getSyncUserByHftUserId(Integer userId);
    
    /**
     * 
    * @Title: getUserTransferList 
    * @Description:获取指定用户的调迁记录  
    * @author tangliang1
    * @param @param userChangeDataParam 用户调迁查询参数
    * @param @return  参数说明 
    * @return List<UserTransferVo>    返回类型 
    * @throws
     */
	List<UserTransferVo> getUserTransferList(Admin_Sync_OA_ML_UserChangeDataParam userChangeDataParam);
}

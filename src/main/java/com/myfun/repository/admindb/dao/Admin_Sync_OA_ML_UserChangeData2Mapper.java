package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.framework.config.mybatis.CommonQueryExample;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_UserChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_UserChangeData2;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_UserVO;
import com.myfun.repository.admindb.vo.UserTransferVo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface Admin_Sync_OA_ML_UserChangeData2Mapper extends BaseMapper<Admin_Sync_OA_ML_UserChangeData2, Integer> {
	
    int countByExample(CommonQueryExample example);

    int deleteByExample(CommonQueryExample example);

    List<Admin_Sync_OA_ML_UserChangeData2> selectByExample(CommonQueryExample example);

    int updateByExampleSelective(@Param("record") Admin_Sync_OA_ML_UserChangeData2 record, @Param("example") CommonQueryExample example);

    int updateByExample(@Param("record") Admin_Sync_OA_ML_UserChangeData2 record, @Param("example") CommonQueryExample example);
    
    
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
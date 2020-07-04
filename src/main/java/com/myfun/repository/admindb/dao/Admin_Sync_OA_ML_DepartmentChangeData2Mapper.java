package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.framework.config.mybatis.CommonQueryExample;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_DepartmentChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_DepartmentChangeData2;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_DeptVO;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface Admin_Sync_OA_ML_DepartmentChangeData2Mapper extends BaseMapper<Admin_Sync_OA_ML_DepartmentChangeData2, Integer> {
	
    int countByExample(CommonQueryExample example);

    int deleteByExample(CommonQueryExample example);
    
    List<Admin_Sync_OA_ML_DepartmentChangeData2> selectByExample(CommonQueryExample example);


    int updateByExampleSelective(@Param("record") Admin_Sync_OA_ML_DepartmentChangeData2 record, @Param("example") CommonQueryExample example);

    int updateByExample(@Param("record") Admin_Sync_OA_ML_DepartmentChangeData2 record, @Param("example") CommonQueryExample example);

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
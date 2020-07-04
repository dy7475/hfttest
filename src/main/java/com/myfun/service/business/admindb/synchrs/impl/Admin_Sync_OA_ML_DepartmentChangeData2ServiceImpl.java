package com.myfun.service.business.admindb.synchrs.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myfun.framework.config.mybatis.service.JsonPageResponse;
import com.myfun.repository.admindb.dao.Admin_Sync_OA_ML_DepartmentChangeData2Mapper;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_DepartmentChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_DepartmentChangeData2;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_DeptVO;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.synchrs.Admin_Sync_OA_ML_DepartmentChangeData2Service;


/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeDataServiceImpl 
* @Description: 同步部门异动信息服务
* @author tangliang1
* @date 2020年6月24日 下午2:54:38 
*
 */
@Service
public class Admin_Sync_OA_ML_DepartmentChangeData2ServiceImpl extends AbstractService<Admin_Sync_OA_ML_DepartmentChangeData2, Integer>
		implements Admin_Sync_OA_ML_DepartmentChangeData2Service {


	@Autowired
	private Admin_Sync_OA_ML_DepartmentChangeData2Mapper deptChangeDataMapper;
			
	/**
	 * 分页获取部门调迁记录
	 */
	@Override
	public JsonPageResponse<Admin_Sync_OA_ML_DeptVO> getDeptTransferList(Admin_Sync_OA_ML_DepartmentChangeDataParam param) {
		
		int pageNo = param.getPageOffset(), pageSize = param.getPageRows();
		// 执行分页查询
		Page<Admin_Sync_OA_ML_DeptVO> pageData = PageHelper.startPage(pageNo, pageSize);
		List<Admin_Sync_OA_ML_DeptVO> list = deptChangeDataMapper.getDeptTransferList(param);
		JsonPageResponse<Admin_Sync_OA_ML_DeptVO> jpRsp = new JsonPageResponse<Admin_Sync_OA_ML_DeptVO>(list, pageData);
		return jpRsp;
	}

	@Override
	public void setBaseMapper() {
		super.baseMapper=deptChangeDataMapper;
	}
			
}

package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.build.param.CopyPermissionParam;
import com.myfun.erpWeb.build.param.CreatePermissionParam;
import com.myfun.erpWeb.build.param.DeletePermissionParam;
import com.myfun.erpWeb.build.param.UpdatePermissionParam;
import com.myfun.repository.erpdb.po.ErpBuildPermissions;
import com.myfun.repository.erpdb.po.ErpBuildPermissionsTrack;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Map;

public interface ErpBuildPermissionsService extends BaseMapper<ErpBuildPermissions, ErpBuildPermissions> {

	void createPermission(CreatePermissionParam param) throws Exception;
	
	void updatePermission(UpdatePermissionParam param) throws Exception;
	
	void deletePermission(DeletePermissionParam param) throws Exception;

	Map<Integer, ErpBuildPermissionsTrack> copyPermission(CopyPermissionParam param)  throws Exception;
	
}

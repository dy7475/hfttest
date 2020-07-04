package com.myfun.erpWeb.build;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.build.param.BuildPermissionListParam;
import com.myfun.erpWeb.build.param.CopyPermissionParam;
import com.myfun.erpWeb.build.param.CreatePermissionParam;
import com.myfun.erpWeb.build.param.DeletePermissionParam;
import com.myfun.erpWeb.build.param.OrganizePermissionListParam;
import com.myfun.erpWeb.build.param.Permission;
import com.myfun.erpWeb.build.param.ReceiverListParam;
import com.myfun.erpWeb.build.param.UpdatePermission;
import com.myfun.erpWeb.build.param.UpdatePermissionParam;

public class BuildPermissionControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.200.156:8081/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "205939", "13438291208");
	}

	
	@Test
	public void CreatePermission() throws Exception {
		CreatePermissionParam param = new CreatePermissionParam();
		List<Permission> permissionList = new ArrayList<>();
		Permission permission = new Permission();
		permission.setAddPermission(Byte.valueOf("1"));
		permission.setBuildId(2069);
		permission.setEditPermission(Byte.valueOf("1"));
		permission.setOrganizationId(253202);
		permission.setHouseUseage("1|2");
		permission.setViewPermission(Byte.valueOf("1"));
		permissionList.add(permission);
		param.setPermissionList(permissionList);
		System.out.println(postNewErp(param, "buildPermission/createPermission"));
	}
	
	@Test
	public void getBuildPermissionList() throws Exception {
		BuildPermissionListParam param = new BuildPermissionListParam();
		param.setBuildId(2069);
//		param.setHasPermission(1);
//		param.setRangeId(42032);
//		param.setRangeType(Byte.valueOf("3"));
//		param.setRangeId(19223);
//		param.setRangeType(Byte.valueOf("2"));
//		param.setRangeId(892608);
//		param.setRangeType(Byte.valueOf("4"));
		System.out.println(postNewErp(param, "buildPermission/getBuildPermissionList"));
	}
	
	@Test
	public void getOrganizePermissionList() throws Exception {
		OrganizePermissionListParam param = new OrganizePermissionListParam();
		param.setOrganizationId(253829);
		param.setHasPermission(0);
		param.setHouseUseage(7);
		System.out.println(postNewErp(param, "buildPermission/getOrganizePermissionList"));
	}
	
	@Test
	public void updatePermission() throws Exception {
		UpdatePermissionParam param = new UpdatePermissionParam();
		List<UpdatePermission> updatePermissionList = new ArrayList<>();
		UpdatePermission updatePermission = new UpdatePermission();
		updatePermission.setBpId(3);
		updatePermission.setAddPermission(Byte.valueOf("0"));
		updatePermission.setEditPermission(Byte.valueOf("0"));
		updatePermission.setViewPermission(Byte.valueOf("1"));
		updatePermissionList.add(updatePermission);
		param.setPermissionList(updatePermissionList);
		System.out.println(postNewErp(param, "buildPermission/updatePermission"));
	}
	
	@Test
	public void deletePermission() throws Exception {
		DeletePermissionParam param = new DeletePermissionParam();
		param.setBpIds("3");
		System.out.println(postNewErp(param, "buildPermission/deletePermission"));
	}
	
	@Test
	public void getReceiverList() throws Exception {
		ReceiverListParam param = new ReceiverListParam();
		param.setBuildId(2069);
		param.setHouseUseage("1");
		System.out.println(postNewErp(param, "buildPermission/getReceiverList"));
	}
	
	@Test
	public void copyPermission() throws Exception {
		CopyPermissionParam param = new CopyPermissionParam();
		param.setOrganizationId(253344);
		param.setBuildIds("2042897");
		param.setTargetOrganizationIds("252617");
		System.out.println(postNewErp(param, "buildPermission/copyPermission"));
	}
	
}

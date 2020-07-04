package com.myfun.erpWeb.managecenter.employeeFiles;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import org.junit.Before;
import org.junit.Test;

public class EmployeeModuleControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.200.197:9001/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280288", "15982083618");
	}
	
	/**
	 * title ：编辑员工
	 * athor：lcb
	 * date  : 2017/11/6
	 */
	@Test
	public void editEmployeeDoc() throws Exception {
		BaseMapParam param = new BaseMapParam();
//		param.setString("id", "17");
		param.setString("userId", "20321492");
		param.setString("workYear", "1.5");
		param.setString("emergencyContact", "钢铁侠");
		param.setString("userQq", "10572639");
		param.setString("personnelLevels", "1");
		param.setString("archiveId", "669722");
		param.setString("nation", "藏2");
		param.setString("maritalStatus", "1");
		param.setString("placeOfOrigin", "四川 乐山");
		param.setString("userSchool", "清华大学");
		param.setString("bankAccount", "55544555666");
		param.setString("socialSecurityAccount", "55544555666");
		param.setString("remarkInfo", "备注信息2");
		param.setString("channelDescription", "备注信2息");
		param.setString("userSchlrecord", "1");
		System.out.println(postNewErp(param,"/manageCenter/funEmployeeModule/editEmployeeDoc"));

	}

	/**
	 * title ：编辑员工
	 * athor：lcb
	 * date  : 2017/11/6
	 */
	@Test
	public void editEmployeePhoto() throws Exception {
		BaseMapParam param = new BaseMapParam();
//		param.setString("id", "17");
		param.setString("userPhoto", "group1/M01/02/A5/wKgLq1pEnJCAa4hkAAErMK6HqnM079.png111");
		param.setString("id", "25267");
		System.out.println(postNewErp(param,"/manageCenter/funEmployeeModule/editEmployeePhoto"));

	}

}

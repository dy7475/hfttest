package com.myfun.erpWeb.common;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.common.param.GetAcrossTheCityOrganizationParam;
import com.myfun.erpWeb.common.param.OrganizationDefinitionListParam;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionListVO;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		//init("http://192.168.200.175:8081/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "46470", "18782920347");
		//initOnlyAddr("http://192.168.200.194:8068/erpWeb", "http://testApp.51vfang.cn/hftWebService/web/api/authentication/openLogin", "1279576", "13700000137");
		//init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280288", "15982083618");

		//init("http://192.168.200.165:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18811110320");
		//init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281168", "18802889999");
		//init("http://192.168.200.194:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1281168", "18802889999");
		initNew("http://192.168.200.194:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin", "18657498879", "123456");
		//init("http://localhost:8068/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "123456", "18782923250");// zt门店
	}

	//添加部门
	@Test
	public void addSubOrganization() throws Exception{
		Map<String, Object> map = new HashMap<>();
		/*map.put("organizationName", "研发中心");
		map.put("contactNumber", "18802889999");
		map.put("organizationAddr", "天府");
		map.put("defintionName", "大区级");
		//map.put("definitionLevel",3);
		map.put("adminUserId", "9010,9011");
		map.put("pid", 0);
		map.put("organizationSeq", 2);*/
		
		/*map.put("organizationName", "a子部门");
		map.put("contactNumber", "18782923250");
		map.put("organizationAddr", "高新区");
		map.put("definitionId",332);
		map.put("adminUserId", "20333471");
		map.put("pid", 894628);*/
		//map.put("organizationSeq", 7);

		map.put("organizationName", "24号当铺");
		map.put("contactNumber", "18782923250");
		map.put("organizationAddr", "24hao最新成都");
		map.put("definitionId",443);
		map.put("adminUserId", "20333878");
		map.put("pid", 0);
		map.put("organizationBussinessType", 1);
		
		System.err.println(postNewErp(map,"common/addSubOrganization"));
	}
	
	//获取子部门信息
	@Test
	public void getSubOrganizationInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organizationId", 204996);
		
		System.err.println(postNewErp(map, "common/getSubOrganizationInfo"));
	}
	
	//编辑部门        改部门名称、电话、地址、主管
	@Test
	public void editSubOrganization() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("adminUserId", "20322125");
		map.put("contactNumber", "18782920347");
		map.put("organizationAddr", "测试地址");
		map.put("organizationId", "204923");
		map.put("organizationName", "业务部");
		map.put("organizationBussinessType", 2);
		map.put("pid", 0); //专门做独立功能：如果更新pid，o_path也要更新
		
		System.err.println(postNewErp(map, "common/editSubOrganization"));
	}
	
	//删除部门
	@Test
	public void deleteSubOrganization() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organizationId", 205000); //204924
		
		System.err.println(postNewErp(map, "common/deleteSubOrganization"));
	}
	
	//申请修改PID
	@Test
	public void addUpdatePidApply() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("organizationId", 204927);
		map.put("oldPid", 0);
		map.put("newPid", 204924);
		
		System.err.println(postNewErp(map, "common/addUpdatePidApply"));
	}

	//新添编辑删除加业务层级定义
	@Test
	public void saveLevelDefinition() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("definitionId", "2");
		map.put("definitionLevel", "1");
		map.put("definitionName", "城市级");
		map.put("updateType", "2");
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("definitionId", "3");
		map1.put("definitionLevel", "2");
		map1.put("definitionName", "大区级");
		map1.put("updateType", "2");

		Map<String, Object> map2 = new HashMap<>();
		map2.put("definitionId", "4");
		map2.put("definitionLevel", "3");
		map2.put("definitionName", "片区级");
		map2.put("updateType", "2");
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("definitionId", "5");
		map3.put("definitionLevel", "5");
		map3.put("definitionName", "门店级");
		map3.put("updateType", "2");
		
		Map<String, Object> map4 = new HashMap<>();
		map4.put("definitionId", "6");
		map4.put("definitionLevel", "6");
		map4.put("definitionName", "分组级");
		map4.put("updateType", "2");
		
		Map<String, Object> map5 = new HashMap<>();
		map5.put("definitionId", "119");
		map5.put("definitionLevel", "7");
		map5.put("definitionName", "A组");
		map5.put("updateType", "2");
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		Map<String, Object> mapAll = new HashMap<>();
		mapAll.put("saveLevelDefinitionParamList", list);
		/*{"saveLevelDefinitionParamList":
			[
			 {"definitionId":"2","definitionLevel":"1","definitionName":"城市级","updateType":"2"},
			 {"definitionId":"3","definitionLevel":"2","definitionName":"大区级","updateType":"2"},
			 {"definitionId":"4","definitionLevel":"3","definitionName":"片区级","updateType":"2"},
			 {"definitionId":"5","definitionLevel":"5","definitionName":"门店级","updateType":"2"},
			 {"definitionId":"6","definitionLevel":"6","definitionName":"分组级","updateType":"2"},
			 {"definitionId":"119","definitionLevel":"7","definitionName":"A组","updateType":"2"}
			 ]
					 }*/

		System.err.println(postNewErp(mapAll, "common/saveLevelDefinition"));
	}
	
	//获取业务指定层级信息
	@Test
	public void getLevelDefinitionInfo() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("definitionId", 332);

		System.err.println(postNewErp(map, "common/getLevelDefinitionInfo"));
	}
	
	@Test
	public void getOrganizationDefinitionList() throws Exception{
		OrganizationDefinitionListParam param = new OrganizationDefinitionListParam();
		System.err.println(postNewErp(param, "common/getOrganizationDefinitionList"));
	}
	
	@Test
	public void getAllOrganizationDefinitionList() throws Exception{
		OrganizationDefinitionListParam param = new OrganizationDefinitionListParam();
		System.err.println(postNewErp(param, "common/getAllOrganizationDefinitionList"));
	}
	
	//编辑业务层级信息
	/*@Test
	public void editLevelDefinition() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("definitionId", 335);
		map.put("definitionName", "分组级");
		map.put("definitionLevel", "5");
	
		System.err.println(postNewErp(map, "common/editLevelDefinition"));
	}
	
	//删除业务层级
	@Test
	public void deleteLevelDefinition() throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("definitionId", 342);
	
		System.err.println(postNewErp(map, "common/deleteLevelDefinition"));
	}*/
	
	/**
	 * 无限组织架构下跨城-查询全集团的组织信息单元测试
	 * @throws Exception
	 */
	@Test
	public void getAcrossTheCityOrganizationTest() throws Exception {
		GetAcrossTheCityOrganizationParam param = new GetAcrossTheCityOrganizationParam();
		param.setUpdateTime("2019-12-25 11:00:00");
		System.err.println(postNewErp(param, "common/getAcrossTheCityOrganization"));
	}
	
	/**
	 * 无限组织架构下跨城-查询全集团的公司信息单元测试
	 * @throws Exception
	 */
	@Test
	public void getAcrossTheCityCompInfoTest() throws Exception {
		OrganizationDefinitionListParam param = new OrganizationDefinitionListParam();
		System.err.println(postNewErp(param, "common/getAcrossTheCityCompInfo"));
	}
	
	@Test
	public void getOrganizationDataListTest() throws Exception {
		OrganizationDefinitionListParam param = new OrganizationDefinitionListParam();
		System.err.println(postNewErp(param, "common/getOrganizationDataList"));
	}
}

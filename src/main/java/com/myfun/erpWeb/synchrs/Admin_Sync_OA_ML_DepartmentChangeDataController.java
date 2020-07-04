package com.myfun.erpWeb.synchrs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_DepartmentChangeDataParam;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.synchrs.Admin_Sync_OA_ML_DepartmentChangeData2Service;
import com.myfun.service.business.erpdb.ErpUserOpersService;

import io.swagger.annotations.Api;

/**
 * 
* @ClassName: Admin_Sync_OA_ML_DepartmentChangeDataController 
* @Description:部门调迁信息控制器（同步HRS人员信息异动记录）
* @author tangliang1
* @date 2020年6月24日 下午3:00:27 
*
 */
@Api(tags = "部门调迁信息控制器", value = "部门调迁信息控制器")
@RestController
@RequestMapping(value = "/synchrs/deptChange")
public class Admin_Sync_OA_ML_DepartmentChangeDataController extends BaseController {
	
	private static Logger LOG=LoggerFactory.getLogger(Admin_Sync_OA_ML_DepartmentChangeDataController.class);
	
	/****** 查看人员变动记录权限key ******/
	private final String LIMIT_VIEW_DEPT_CHANGE_KEY="VIEW_DEPT_CHANGE";
	
	@Autowired
//	private Admin_Sync_OA_ML_DepartmentChangeDataService  deptChangeDataService;
	private Admin_Sync_OA_ML_DepartmentChangeData2Service  deptChangeDataService;
	
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	
	/**
	 * 
	* @Title: getDeptChangeList 
	* @Description: 获取组织调迁列表
	* @author tangliang1
	* @param @param queryParam
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws
	 */
	@PostMapping(value = "/getDeptChangeList")
	public Object getDeptChangeList(@RequestBody Admin_Sync_OA_ML_DepartmentChangeDataParam queryParam) {
		
		// 待设置查询权限
		if (!this.checkUserJurisdiction(LIMIT_VIEW_DEPT_CHANGE_KEY)) {
			return ErpResponseJson.warn("您没有查看权限");
		}
		return deptChangeDataService.getDeptTransferList(queryParam);
	}

	/**
	 * 
	* @Title: getOrgList 
	* @Description:获取组织列表
	* @author tangliang1
	* @param @return  参数说明 
	* @return Object    返回类型 
	* @throws
	 */
	@PostMapping(value = "/getOrgList")
	public Object getOrgList() {
		
		// 获取当前操作人的公司信息
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		List<OrganizationVO> organizationVOList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, null);
		
		// 得到所有的一级部门
		List<JSONObject> orgListLevel1 = Lists.newArrayList();
		// 其它等级
		List<JSONObject> orgListLevelOther = Lists.newArrayList();
		for (Iterator<OrganizationVO> it = organizationVOList.iterator(); it.hasNext();) {
			OrganizationVO org =it.next();
			Integer level=org.getDefinitionLevel();
			Integer organizationId= org.getOrganizationId();
			Integer pid= org.getPid();
			
			JSONObject tempObj = new JSONObject();
			tempObj.put("organizationId", organizationId);
			tempObj.put("pid", pid);
			tempObj.put("definitionLevel", level);
			tempObj.put("cityId", org.getCityId());
			tempObj.put("compId", org.getCompId());
			tempObj.put("delFlag", org.getDelFlag());// 删除标记
			tempObj.put("organizationName", org.getOrganizationName());
			tempObj.put("bussinessType", org.getOrganizationBussinessType());
			tempObj.put("organizationName", org.getOrganizationName());
			if (org.getPid() == 0) {
				orgListLevel1.add(tempObj);
			} else {
				orgListLevelOther.add(tempObj);
			}
		}

		// 封装对应层级
		DefaultResponseJson respJson=new DefaultResponseJson();
		respJson.setData(this.getOrgJsonList(orgListLevelOther, orgListLevel1));
		respJson.setErrCode(Const.ResponseCode.SUCCESS);
		respJson.setErrMsg("操作成功");
		return respJson;
	}
	
	
	/**
	 * 
	* @Title: getOrgJsonList 
	* @Description: 设置组织层级
	* @author tangliang1
	* @param @param sourceList
	* @param @param targetList
	* @param @return  参数说明 
	* @return List<JSONObject>    返回类型 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	List<JSONObject> getOrgJsonList(List<JSONObject> sourceList,List<JSONObject> targetList){
		
		if (CollectionUtils.isEmpty(sourceList)) {
			return targetList;
		}
		List<JSONObject> children=null;
		for (JSONObject parentOrg : targetList) {
			Integer tempId= parentOrg.getIntValue("organizationId");
			children=parentOrg.getObject("children",ArrayList.class);
			if (Objects.isNull(children)) {
				children=Lists.newArrayList();
			}
			for (Iterator<JSONObject> it = sourceList.iterator(); it.hasNext();) {
				JSONObject childOrg = it.next();
				Integer tempPid= childOrg.getIntValue("pid");
				if (tempId.equals(tempPid)) {
					children.add(childOrg);
					it.remove();
				}
			}
			// 设置当前级的子层级数据
			if (CollectionUtils.isNotEmpty(children)) {
				this.getOrgJsonList(sourceList, children);
			}
			parentOrg.put("children", children);
		}
		return targetList;
	}
	
	/**
	 * 
	* @Title: checkUserJurisdiction 
	* @Description: 检查用户是否有查看权限
	* @author tangliang1
	* @param @param permissionName  指定的权限key
	* @return void    返回类型 
	* @throws
	 */
	Boolean checkUserJurisdiction(String permissionName) {
		Operator oper=super.getOperator();
		return  erpUserOpersService.judgePermission(oper.getCityId(), oper.getUserId(), permissionName);
	}
	
}

package com.myfun.erpWeb.managecenter.employeeFiles;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewDeptParam;
import com.myfun.erpWeb.openApi.user.param.DealNewOrgUserCountMessage;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.HttpUtil;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.erpdb.ErpFunEmployeeDocService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.report.ReportFunSaleMinService;

/**
 * title ：员工档案模块
 * auhor：lcb
 * date  : 2017/11/7
 */
@RestController
@RequestMapping("/manageCenter/funEmployeeModule")
public class FunEmployeeModuleController extends BaseController {

	@Autowired
	ErpFunEmployeeDocService erpFunEmployeeDocService;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private HttpRequestTask httpRequestTask;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ActiveMqPublisher publisher;
	@Autowired
	private ReportFunSaleMinService reportFunSaleMinService;
	/**
	 * @title ：编辑员工档案信息
	 * @athor：lcb
	 * @date  : 2017/11/7
	 */
	@RequestMapping("/editEmployeeDoc")
	public ResponseJson editEmployeeDoc(@RequestBody BaseMapParam baseMapParam) throws Exception{
		Operator operator = getOperator();
		if (operator.newOrganizationType()) {
			return editEmployeeNewOrg(baseMapParam);
		}
		Map<String, Object> paramJsonMap = baseMapParam.getMap();
		ErpFunEmployeeDoc erpFunEmployeeDoc = baseMapParam.getParamObj(baseMapParam.getParamBody(), ErpFunEmployeeDoc.class);
		AdminFunArchive adminFunArchive = baseMapParam.getParamObj(baseMapParam.getParamBody(), AdminFunArchive.class);
		ErpFunUsers erpFunUsers = baseMapParam.getParamObj(baseMapParam.getParamBody(), ErpFunUsers.class);

		Integer docId = erpFunEmployeeDocService.editEmployeeDoc(operator.getCityId(),operator.getCompId(),operator.getDeptId(),
				operator.getUserId(), erpFunEmployeeDoc, adminFunArchive, erpFunUsers, paramJsonMap, operator.getCompType(),null);

		// 员工编辑里面新增支持调店-分组, 有newDeptId但是没有传分组ID(newGrId), 则表示调店到未分组
		if (paramJsonMap.containsKey("newDeptId")) {
			Integer newDeptId = (Integer) paramJsonMap.get("newDeptId");
			ErpFunUsers users = erpFunUsersMapper.getFunUserByUserId(operator.getCityId(), erpFunUsers.getUserId());

			MoveUserToNewDeptParam param = new MoveUserToNewDeptParam();
			param.setUserId(erpFunUsers.getUserId());
			param.setNewDeptId(newDeptId);
			if (paramJsonMap.containsKey("newGrId")) {
				Integer newGrId = (Integer) paramJsonMap.get("newGrId");
				param.setNewGrId(newGrId);
			}
			param.setSelfUserId(operator.getUserId());
			param.setCityId(operator.getCityId());
			param.setCompId(operator.getCompId());
			param.setCompType(operator.getCompType());
			erpFunDeptsService.moveUserToNewDept(param);
			Map<String, Object> changeDeptInfo = new HashMap<>();

			if (null != users) {
				changeDeptInfo.put("cityId", param.getCityId());
				changeDeptInfo.put("compId", param.getCompId());
				changeDeptInfo.put("newDept", param.getNewDeptId());
				changeDeptInfo.put("oldDept", erpFunUsers.getDeptId());
				changeDeptInfo.put("archiveId", erpFunUsers.getArchiveId());
				httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeDept", changeDeptInfo);
			}
			
			//员工团队处理（只处理玛雅房基地）
			AdminFunComp adminFunComp =  adminFunCompMapper.selectByCompNo(getOperator().getCompNo());
			if(adminFunComp !=null){
				if("2".equals(adminFunComp.getCompManagementModel().toString()) && "1".equals(adminFunComp.getCustomizedType().toString())){
					Map<String,Object> changeUserParam = new HashMap<String,Object>();
					changeUserParam.put("cityId", param.getCityId());
					changeUserParam.put("userId", param.getUserId());
					changeUserParam.put("newUserId", param.getNewUserId());
					changeUserParam.put("newGrId", param.getNewGrId());
					HttpUtil.postNewErp(AppConfig.getZxWeb()+"/broker/org/moveUserToNewDept", param,getOperator().getClientKey());				
				}
			}
		}

		return ErpResponseJson.ok(docId);
	}
	
	/**
	 * 新版组织机构的编辑员工档案
	 * @param baseMapParam
	 * @return
	 * @throws Exception 
	 */
	private ResponseJson editEmployeeNewOrg(@RequestBody BaseMapParam baseMapParam) throws Exception {
		Operator operator = getOperator();
		Map<String, Object> paramJsonMap = baseMapParam.getMap();
		ErpFunEmployeeDoc erpFunEmployeeDoc = baseMapParam.getParamObj(baseMapParam.getParamBody(), ErpFunEmployeeDoc.class);
		AdminFunArchive adminFunArchive = baseMapParam.getParamObj(baseMapParam.getParamBody(), AdminFunArchive.class);
		ErpFunUsers erpFunUsers = baseMapParam.getParamObj(baseMapParam.getParamBody(), ErpFunUsers.class);
		
		String createUserName = null;
		if (getOperator().isSwitchCompLogin()){  //后续改为isSwitchCompLogin
			createUserName = getOperator().getUserName()+"("+getOperator().getCompName()+")";
		}

		Integer docId = erpFunEmployeeDocService.editEmployeeDoc(operator.getCityId(),operator.getCompId(),operator.getDeptId(),
				operator.getUserId(), erpFunEmployeeDoc, adminFunArchive, erpFunUsers, paramJsonMap, operator.getCompType(),createUserName);
		if (paramJsonMap.containsKey("newOrganizationId")) {
			reportFunSaleMinService.judgeOperatorTransferShop(operator.getCompNo(), operator.getCityId(), operator.getCompId(),
					erpFunUsers.getUserId().toString(), 6, null,null);
			Integer newOrgId = (Integer) paramJsonMap.get("newOrganizationId");
			Integer oldOrgId = (Integer) paramJsonMap.get("organizationId");
			ErpFunUsers users = erpFunUsersMapper.getFunUserByUserId(operator.getCityId(), erpFunUsers.getUserId());
	/*		DealNewOrgUserCountMessage message = new DealNewOrgUserCountMessage();
			message.setDealType(1);
			message.setCityId(operator.getCityId());
			message.setCompId(users.getCompId());
			message.setSelfUserId(operator.getUserId());
			message.setMoveUserId(users.getUserId());
			message.setMoveArchiveId(users.getArchiveId());
			message.setOldOrgId(oldOrgId);
			message.setNewOrgId(newOrgId);
			publisher.sendDealNewOrgMove(message);*/
			Map<String,Integer> resultMap = erpFunOrganizationService.moveUserNewOrganization(operator.getCityId(), erpFunUsers.getCompId(), operator.getUserId(), erpFunUsers.getUserId(), oldOrgId, newOrgId,createUserName);	
			Map<String, Object> changeDeptInfo = new HashMap<>();
			if (null != users) {
				changeDeptInfo.put("cityId", operator.getCityId());
				changeDeptInfo.put("compId", operator.getCompId());
				changeDeptInfo.put("newOrgId", resultMap.get("lookNewLevelId"));
				changeDeptInfo.put("oldOrgId", resultMap.get("lookOldLevelId"));
				changeDeptInfo.put("archiveId", erpFunUsers.getArchiveId());
				httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
			}
		}
		return ErpResponseJson.ok(docId);
	}

	/**
	 * @title ：修改编辑员工档案头像
	 * @athor：lcb
	 * @date  : 2017/11/7
	 */
	@RequestMapping("/editEmployeePhoto")
	public ResponseJson editEmployeePhoto(@RequestBody BaseMapParam baseMapParam){

		Operator operator = getOperator();
		String photoAddr = baseMapParam.getString("userPhoto");
		Integer userId = baseMapParam.getInteger("userId");
		Integer res = erpFunEmployeeDocService.changeUserPhoto(operator.getCityId(), userId, operator.getCompId(), photoAddr);
		return ErpResponseJson.ok(res);
	}

}

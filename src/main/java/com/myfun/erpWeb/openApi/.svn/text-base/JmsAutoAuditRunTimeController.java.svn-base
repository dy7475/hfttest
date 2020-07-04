package com.myfun.erpWeb.openApi;

import com.myfun.service.business.erpdb.ErpFunUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpAuditRuntimeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.erpdb.ErpFunTrackService;

/**
* 超期自动审核的调用接口
* @author 方李骥
* @since 2017年4月17日
*/
@Controller
@RequestMapping(value = "/openApi/autoAudit")
public class JmsAutoAuditRunTimeController {
	@Autowired ErpFunTrackService erpFunTrackService;
	@Autowired ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunUsersService erpFunUsersService;

	@ResponseBody
	@RequestMapping("/autoAuditPass")
	public ErpResponseJson autoAuditPass(Integer cityId, Integer compId, Integer auditId) throws Exception {

		ErpAuditRuntime erpAuditRuntime = erpAuditRuntimeMapper.selectById(cityId, compId, auditId);
		if (erpAuditRuntime != null && erpAuditRuntime.getAuditStatus()  == 0) {
			ErpFunUsers generalManager = erpFunUsersService.getGeneralManagerByCompId(cityId, compId);
			//ErpFunUsers generalManager = erpFunUsersMapper.getGeneralManagerByCompId(cityId, compId);
			erpFunTrackService.autoLimitAuditEndExec(erpAuditRuntime, cityId, generalManager.getUserId(), 4);
		}
		return ErpResponseJson.ok();
	}
}

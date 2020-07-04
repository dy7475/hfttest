package com.myfun.erpWeb.openApi;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.deal.param.DealBussinessCommonParam;
import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.AuditVO;
import com.myfun.repository.erpdb.param.RevokeAuditParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpDealTrack;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunDealService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
* 补合同跟进数据
* @author 方李骥
* @since 2017年4月17日
*/
@Controller
@RequestMapping(value = "/openApi/dealAudit")
public class DealAuditController extends BaseController{


	@Autowired
	ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired
	ErpFunDealService erpFunDealService;

	/**
	 * 审核合同类审批
	 * lcb
	 *  @Param
	 * **/
	@ApiOperation("撤销审核")
	@PostMapping("/revokeAudit")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AuditVO.class, message = "成功")
	})
	@ResponseBody
	public ResponseJson revokeAudit(@RequestBody RevokeAuditParam param) throws Exception{
		// 判断是否存在和是否有审核权限（是否已经审核）
		ErpAuditRuntime erpAuditRuntimeUp = new ErpAuditRuntime();
		erpAuditRuntimeUp.setShardCityId(param.getCityId());
		erpAuditRuntimeUp.setId(param.getId());
		erpAuditRuntimeUp = erpAuditRuntimeMapper.selectByPrimaryKey(erpAuditRuntimeUp);
		if(null != erpAuditRuntimeUp) {
			erpAuditRuntimeUp.setShardCityId(param.getCityId());
			DealBussinessCommonParam dealParam = JSON.parseObject(erpAuditRuntimeUp.getParamJson(), DealBussinessCommonParam.class);
			erpFunDealService.doUpdateBussinessStatus(dealParam, 0);
		}
		return ErpResponseJson.ok();
	}

}

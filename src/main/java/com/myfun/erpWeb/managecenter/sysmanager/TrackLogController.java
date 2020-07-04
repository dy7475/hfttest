package com.myfun.erpWeb.managecenter.sysmanager;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.erpdb.param.ErpFunTrackParam;
import com.myfun.service.business.admindb.AdminIpCallLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: TrackLogController
* @Description: 跟进日志
* @author lcb
* @date 2017-09-27
 */
@RestController
@RequestMapping("/managerCenter/trackLog")
public class TrackLogController extends BaseController{

	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;

	@RequestMapping("/getMgrTrackList")
	public ResponseJson getMgrTrackList(@Valid @RequestBody BaseMapParam param) throws Exception{
		Operator operator = getOperator();
		Map<String, Object> map = param.getMap();
		map.put("compId", operator.getCompId());
		map.put("userId", operator.getUserId());
		// 1:根据条件查询日志列表

		// 2:带看跟进需要关联数据
		return ErpResponseJson.ok(null);
	}

	/**
	 * 查询关联数据
	 * **/
	private List<ErpFunTrackDto> getTrackLogList(Integer cityId, Map<String, Object> map) {

		return null;
	}


	/**
	 * 绑定相关数据
	 * ***/
	private void bindLinkData( ){

	}
}

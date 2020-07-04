package com.myfun.erpWeb.managecenter.attendance;

import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceParamMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceClassParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunAttendanceClassService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 管理中心-新版考勤 配置表
 * @author lcb
 * @2017-11-22
 */
@RestController
@RequestMapping("/managerCenter/attendanceSettingModule")
public class AttendanceSettintController extends BaseController {

	@Autowired
	private ErpFunAttendanceParamMapper erpFunAttendanceParamMapper;

	/**
	 * 查询考勤配置
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceSettingList")
	public ResponseJson getAttendanceSettingList(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		ErpFunAttendanceParamExample erpFunAttendanceParamExample = new ErpFunAttendanceParamExample();
		erpFunAttendanceParamExample.setShardCityId(operator.getCityId());
		erpFunAttendanceParamExample.createCriteria().andCompIdEqualTo(operator.getCompId());
		erpFunAttendanceParamExample.setOrderByClause("PARAM_TYPE ASC");
		List<ErpFunAttendanceParam> erpFunAttendanceParams = erpFunAttendanceParamMapper.selectByExample(erpFunAttendanceParamExample);
		return ErpResponseJson.ok(erpFunAttendanceParams);
	}

	/**
	 * 修改保存配置
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveSetting")
	public ResponseJson saveSetting(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		ErpFunAttendanceParam erpFunAttendanceParam = new ErpFunAttendanceParam();
		BeanUtils.copyProperties(param, erpFunAttendanceParam);
		erpFunAttendanceParam.setShardCityId(operator.getCityId());
		Integer res = erpFunAttendanceParamMapper.updateByPrimaryKeySelective(erpFunAttendanceParam);
		return ErpResponseJson.ok(res);
	}
}

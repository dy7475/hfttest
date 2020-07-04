package com.myfun.erpWeb.managecenter.axn.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.managecenter.axn.param.AxnManageListParam;
import com.myfun.erpWeb.managecenter.axn.param.BatchBindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.BatchUnBindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.BindHistoryListParam;
import com.myfun.erpWeb.managecenter.axn.param.BindLogListParam;
import com.myfun.erpWeb.managecenter.axn.param.BindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.CallRecordListParam;
import com.myfun.erpWeb.managecenter.axn.param.CreateNumberPoolParam;
import com.myfun.erpWeb.managecenter.axn.param.ImportNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.NumberManageListParam;
import com.myfun.erpWeb.managecenter.axn.param.NumberPoolListParam;
import com.myfun.erpWeb.managecenter.axn.param.PhoneBillListParam;
import com.myfun.erpWeb.managecenter.axn.param.PoolNameListParam;
import com.myfun.erpWeb.managecenter.axn.param.ReleaseNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberListParam;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberParam;
import com.myfun.erpWeb.managecenter.axn.vo.AxnManageListVO;
import com.myfun.erpWeb.managecenter.axn.vo.BindHistoryListVO;
import com.myfun.erpWeb.managecenter.axn.vo.BindLogListVO;
import com.myfun.erpWeb.managecenter.axn.vo.CallRecordListVO;
import com.myfun.erpWeb.managecenter.axn.vo.ImportNumberVO;
import com.myfun.erpWeb.managecenter.axn.vo.NumberManageListVO;
import com.myfun.erpWeb.managecenter.axn.vo.NumberPoolListVO;
import com.myfun.erpWeb.managecenter.axn.vo.PhoneBillListVO;
import com.myfun.erpWeb.managecenter.axn.vo.PoolNameListVO;
import com.myfun.erpWeb.managecenter.axn.vo.UnBindNumberListVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "axn电话管理", value = "axn电话管理")
@RequestMapping(value = "/axnPool")
public interface AxnPoolApi {

	@ApiOperation(value = "创建号池")
	@ApiImplicitParam(dataTypeClass = CreateNumberPoolParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "创建成功") })
	@PostMapping("/createNumberPool")
	ResponseJson createNumberPool(@RequestBody CreateNumberPoolParam param) throws Exception;
	
	@ApiOperation(value = "查询号池列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = NumberPoolListVO.class) })
	@PostMapping("/getNumberPoolList")
	ResponseJson getNumberPoolList(@RequestBody NumberPoolListParam param) throws Exception;
	
	@ApiOperation(value = "导入号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = ImportNumberVO.class) })
	@PostMapping("/importNumber")
	ResponseJson importNumber(@RequestBody ImportNumberParam param) throws Exception;

	@ApiOperation(value = "号池号码管理列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = NumberManageListVO.class) })
	@PostMapping("/getNumberManageList")
	ResponseJson getNumberManageList(@RequestBody NumberManageListParam param) throws Exception;
	
	@ApiOperation(value = "绑定历史列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = BindHistoryListVO.class) })
	@PostMapping("/getBindHistoryList")
	ResponseJson getBindHistoryList(@RequestBody BindHistoryListParam param) throws Exception;
	
	@ApiOperation(value = "单个解绑号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/unBindNumber")
	ResponseJson unBindNumber(@RequestBody UnBindNumberParam param) throws Exception;
	
	@ApiOperation(value = "删除释放号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/releaseNumber")
	ResponseJson releaseNumber(@RequestBody ReleaseNumberParam param) throws Exception;
	
	@ApiOperation(value = "单个绑定号码绑定号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/bindNumber")
	ResponseJson bindNumber(@RequestBody BindNumberParam param) throws Exception;
	
	@ApiOperation(value = "未绑定号码绑定号码列表,单个号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = UnBindNumberListVO.class) })
	@PostMapping("/getUnBindNumberList")
	ResponseJson getUnBindNumberList(@RequestBody UnBindNumberListParam param) throws Exception;
	
	@ApiOperation(value = "查询绑定日志列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = BindLogListVO.class) })
	@PostMapping("/getBindLogList")
	ResponseJson getBindLogList(@RequestBody BindLogListParam param) throws Exception;

	@ApiOperation(value = "批量绑定号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "")})
	@PostMapping("/batchBindNumber")
	ResponseJson batchBindNumber(@RequestBody BatchBindNumberParam param) throws Exception;
	
	@ApiOperation(value = "批量解绑号码")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "") })
	@PostMapping("/batchUnBindNumber")
	ResponseJson batchUnBindNumber(@RequestBody BatchUnBindNumberParam param) throws Exception;
	
	@ApiOperation(value = "隐号管理列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = AxnManageListVO.class) })
	@PostMapping("/getAxnManageList")
	ResponseJson getAxnManageList(@RequestBody AxnManageListParam param) throws Exception;
	
	@ApiOperation(value = "通话记录列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = CallRecordListVO.class) })
	@PostMapping("/getCallRecordList")
	ResponseJson getCallRecordList(@RequestBody CallRecordListParam param) throws Exception;
	
	@ApiOperation(value = "话费管理列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = PhoneBillListVO.class) })
	@PostMapping("/getPhoneBillList")
	ResponseJson getPhoneBillList(@RequestBody PhoneBillListParam param) throws Exception;
	
	@ApiOperation(value = "号池名称列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = PoolNameListVO.class) })
	@PostMapping("/getPoolNameList")
	ResponseJson getPoolNameList(@RequestBody PoolNameListParam param) throws Exception;
	
//	@ApiOperation(value = "电话统计列表")
//	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = PhoneBillListVO.class) })
//	@PostMapping("/getAxbStatisticsList")
//	ResponseJson getAxbStatisticsList() throws Exception;
	
}

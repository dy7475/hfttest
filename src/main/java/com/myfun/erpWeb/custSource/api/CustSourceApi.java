package com.myfun.erpWeb.custSource.api;

import com.myfun.erpWeb.custSource.param.*;
import com.myfun.erpWeb.custSource.vo.CustSourceEditVO;
import com.myfun.erpWeb.custSource.vo.CustSourceListVO;
import com.myfun.erpWeb.custSource.vo.GetCodeVO;
import com.myfun.erpWeb.custSource.vo.GetOneCustSoureVO;
import com.myfun.erpWeb.task.param.SendTaskParam;
import com.myfun.erpWeb.task.vo.SendTaskVO;
import com.myfun.framework.web.json.ResponseJson;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "客源来源控制器", value = "客源来源控制器")
@RequestMapping(value = "/custSource")
public interface CustSourceApi {
    @ApiOperation(value = "客源来源新增")
    @ApiImplicitParam(dataTypeClass = CustSourceAddParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "新增成功", response = SendTaskVO.class) })
    @PostMapping("/custSourceAdd")
    ResponseJson custSourceAdd(@RequestBody CustSourceAddParam custSourceAddParam) throws Exception;

    @ApiOperation(value = "客源来源编辑,禁用/启用")
    @ApiImplicitParam(dataTypeClass = CustSourceEditParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = CustSourceEditVO.class) })
    @PostMapping("/custSourceEdit")
    ResponseJson custSourceEdit(@RequestBody CustSourceEditParam custSourceEditParam) throws Exception;

    @ApiOperation(value = "客源来源列表")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功", response = CustSourceListVO.class) })
    @PostMapping("/custSourceList")
    ResponseJson custSourceList(@RequestBody CustSourceListParam custSourceListParam) throws Exception;

    @ApiOperation(value = "获取编码")
    @ApiImplicitParam(dataTypeClass = GetCodeParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功", response = GetCodeVO.class) })
    @PostMapping("/getCode")
    ResponseJson getCode(@RequestBody GetCodeParam getCodeParam) throws Exception;

    @ApiOperation(value = "获取单条信息")
    @ApiImplicitParam(dataTypeClass = GetCodeParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "查询成功", response = GetOneCustSoureVO.class) })
    @PostMapping("/getOneCustSoure")
    ResponseJson getOneCustSoure(@RequestBody GetOneCustSoureParam getCodeParam) throws Exception;

}

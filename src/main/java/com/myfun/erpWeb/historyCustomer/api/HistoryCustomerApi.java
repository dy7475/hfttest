package com.myfun.erpWeb.historyCustomer.api;

import com.myfun.erpWeb.historyCustomer.param.HistoryCustomerListParam;
import com.myfun.erpWeb.historyCustomer.param.TransferDataParam;
import com.myfun.erpWeb.historyCustomer.param.TransferRecordListParam;
import com.myfun.erpWeb.task.param.SendTaskParam;
import com.myfun.erpWeb.task.vo.SendTaskVO;
import com.myfun.framework.web.json.ResponseJson;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "历史成交客控制器", value = "历史成交客控制器")
@RequestMapping(value = "/historyCustomer")
public interface HistoryCustomerApi {
    @ApiOperation(value = "历史成交客列表")
    @ApiImplicitParam(dataTypeClass = SendTaskParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "发送成功", response = SendTaskVO.class) })
    @PostMapping("/historyCustomerList")
    ResponseJson historyCustomerList(@RequestBody HistoryCustomerListParam historyCustomerListParam) throws Exception;

    @ApiOperation(value = "变动记录列表")
    @ApiImplicitParam(dataTypeClass = SendTaskParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "发送成功", response = SendTaskVO.class) })
    @PostMapping("/transferRecordList")
    ResponseJson transferRecordList(@RequestBody TransferRecordListParam transferRecordListParam) throws Exception;

    @ApiOperation(value = "移交数据")
    @ApiImplicitParam(dataTypeClass = TransferDataParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "发送成功", response = SendTaskVO.class) })
    @PostMapping("/transferData")
    ResponseJson transferData(@RequestBody TransferDataParam transferDataParam) throws Exception;
}

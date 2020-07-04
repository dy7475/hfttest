package com.myfun.erpWeb.onlinepay.api;

import com.myfun.erpWeb.onlinepay.param.QueryBankCodeParam;
import com.myfun.erpWeb.onlinepay.vo.QueryBankCodeVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title 线上收款账户API
 * @author lcb
 * @since 2019/8/24
 * @param
 * @return
 */
@Api(tags = "在线收款-新网模块-银行相关")
@RequestMapping(value = "/onlineCollection/xwBankModule/bank/")
public interface BankApi {

    @ApiOperation(value = "查询银行行号")
    @ApiImplicitParam(dataTypeClass = QueryBankCodeParam.class)
    @ApiResponses(value= {
       @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "返回成功", response = QueryBankCodeVO.class)
    })
    @PostMapping("/queryBankCode")
    ResponseJson queryBankCode(QueryBankCodeParam param);

}

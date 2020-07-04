package com.myfun.erpWeb.house.api;

import com.myfun.erpWeb.deal.param.GetQrcodeWithOwnerIdParam;
import com.myfun.erpWeb.deal.vo.GetQrcodeWithOwnerIdVO;
import com.myfun.erpWeb.house.param.SendMsgToHouseOwnerParam;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 美联房源委托
 * @author HuangJiang
 * @since 2019年11月26日 15:07:05
 * Modified XXX HuangJiang 2019年11月26日
 */
@Api(tags = "美联房源委托Api", value = "entrustApi")
@RequestMapping(value = "/entrustApi")
public interface EntrustApi {
    
    @ApiOperation(value = "房源委托信息发送签约短信，作者：黄江")
    @ApiImplicitParam(dataTypeClass = SendMsgToHouseOwnerParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/sendMsgToHouseOwner")
    public ResponseJson sendMsgToHouseOwner(@Validated @RequestBody SendMsgToHouseOwnerParam param) throws Exception;
    
    @ApiOperation(value = "针对单个业主生成邀请签约二维码，作者：黄江")
    @ApiImplicitParam(dataTypeClass = GetQrcodeWithOwnerIdParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetQrcodeWithOwnerIdVO.class)
    })
    @PostMapping(value = "/getQrcodeWithOwnerId")
    public ResponseJson getQrcodeWithOwnerId(@Validated @RequestBody GetQrcodeWithOwnerIdParam param) throws Exception;
    
}

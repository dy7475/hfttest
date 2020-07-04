package com.myfun.erpWeb.house.api;

import com.myfun.erpWeb.house.param.EntrustProtocolDetailsParam;
import com.myfun.erpWeb.house.param.SaveEntrustProtocolParam;
import com.myfun.erpWeb.house.param.getOwnerInfoParam;
import com.myfun.erpWeb.house.vo.EntrustProtocolDetailsVO;
import com.myfun.erpWeb.house.vo.getOwnerInfoVo;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author 蔡春林
 * @Date 2019/11/23 0023 下午 2:38
 **/
@Api(tags = "美联房源委托Api", value = "houseEntrustApi")
@RequestMapping(value = "/openApi/houseEntrust")
public interface HouseEntrustApi {
    
    @ApiOperation(value = "业主签约委托书签约页面信息查询，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = EntrustProtocolDetailsParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= EntrustProtocolDetailsVO.class)
    })
    @PostMapping(value = "/entrustProtocolDetails")
    public ResponseJson entrustProtocolDetails(@Validated @RequestBody EntrustProtocolDetailsParam entrustProtocolDetailsParam) throws Exception; 
    
    @ApiOperation(value = "业主确认签约信息保存，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = EntrustProtocolDetailsParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/saveEntrustProtocol")
    public ResponseJson saveEntrustProtocol(@Validated @RequestBody SaveEntrustProtocolParam saveEntrustProtocolParam) throws Exception;    
    
    @ApiOperation(value = "业主确认签约信息保存，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = getOwnerInfoParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= getOwnerInfoVo.class)
    })
    @RequestMapping(value = "/getOwnerInfo",method={RequestMethod.POST,RequestMethod.GET} )
    public ResponseJson getOwnerInfo(@Validated getOwnerInfoParam param) throws Exception;   
   
}

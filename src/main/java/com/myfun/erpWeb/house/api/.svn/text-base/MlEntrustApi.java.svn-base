package com.myfun.erpWeb.house.api;

import com.myfun.erpWeb.house.param.*;
import com.myfun.erpWeb.house.vo.*;
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
 * @since 2019年11月25日 09:58:54
 * Modified XXX HuangJiang 2019年11月25日
 */
@Api(tags = "美联房源委托Api", value = "mlEntrustApi")
@RequestMapping(value = "/mlEntrustApi")
public interface MlEntrustApi {
    
    @ApiOperation(value = "查询房源有无历史委托，有无当前委托以及是否能够新增委托，作者：黄江")
    @ApiImplicitParam(dataTypeClass = GetHouseEntrustSituationParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= GetHouseEntrustSituationVO.class)
    })
    @PostMapping(value = "/getHouseEntrustSituation")
    public ResponseJson getHouseEntrustSituation(@Validated @RequestBody GetHouseEntrustSituationParam param) throws Exception;
    
    @ApiOperation(value = "发起委托时获取房源基础信息，作者：黄江")
    @ApiImplicitParam(dataTypeClass = GetHouseEntrustSituationParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= GetHouseBaseInfoVO.class)
    })
    @PostMapping(value = "/getHouseBaseInfo")
    public ResponseJson getHouseBaseInfo(@Validated @RequestBody GetHouseEntrustSituationParam param) throws Exception;
    
    @ApiOperation(value = "委托信息保存（新增），作者：黄江")
    @ApiImplicitParam(dataTypeClass = SaveEntrustInfoParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= SaveEntrustInfoVO.class)
    })
    @PostMapping(value = "/saveEntrustInfo")
    public ResponseJson saveEntrustInfo(@Validated @RequestBody SaveEntrustInfoParam param) throws Exception;

    @ApiOperation(value = "查询历史委托列表，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = GetHistoryEntrustParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= MlEntrustVO.class)
    })
    @PostMapping(value = "/getHistoryEntrust")
    public ResponseJson getHistoryEntrust(@Validated @RequestBody GetHistoryEntrustParam getHistoryEntrustParam) throws Exception;

    @ApiOperation(value = "查询当前委托详情信息，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = GetHistoryEntrustParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= MlEntrustVO.class)
    })
    @PostMapping(value = "/getHouseEffectiveEntrustInfo")
    public ResponseJson getHouseEffectiveEntrustInfo(@Validated @RequestBody GetHistoryEntrustParam getHistoryEntrustParam) throws Exception;
    
    @ApiOperation(value = "委托信息修改（纸质委托），作者：黄江")
    @ApiImplicitParam(dataTypeClass = SaveEntrustInfoParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/updateEntrustInfo")
    public ResponseJson updateEntrustInfo(@Validated @RequestBody SaveEntrustInfoParam param) throws Exception;

    @ApiOperation(value = "获取委托资料配置接口，作者：蔡春林")
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetEntrustFileConfigVO.class)
    })
    @PostMapping(value = "/getEntrustFileConfig")
    public ResponseJson getEntrustFileConfig() throws Exception; 
    

    @ApiOperation(value = "修改委托资料配置接口，作者：蔡春林 弃用")
    @ApiImplicitParam(dataTypeClass = UpdateEntrustFileConfigParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/updateEntrustFileConfig")
    public ResponseJson updateEntrustFileConfig(@Validated @RequestBody UpdateEntrustFileConfigParam param) throws Exception;

    @ApiOperation(value = "撤销委托，作者：黄江")
    @ApiImplicitParam(dataTypeClass = SaveEntrustInfoParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/cancelEntrust")
    public ResponseJson cancelEntrust(@Validated @RequestBody CancelEntrustParam param) throws Exception;
    
    @ApiOperation(value = "删除委托，作者：黄江")
    @ApiImplicitParam(dataTypeClass = SaveEntrustInfoParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    })
    @PostMapping(value = "/deleteEntrust")
    public ResponseJson deleteEntrust(@Validated @RequestBody CancelEntrustParam param) throws Exception;

    @ApiOperation(value = "查询历史委托详情信息，作者：蔡春林")
    @ApiImplicitParam(dataTypeClass = GetHistoryEntrustParam.class)
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response= MlEntrustVO.class)
    })
    @PostMapping(value = "/getHouseHistoryEntrustInfo")
    public ResponseJson getHouseHistoryEntrustInfo(@Validated @RequestBody GetHouseEntrustInfoParam param) throws Exception;
}

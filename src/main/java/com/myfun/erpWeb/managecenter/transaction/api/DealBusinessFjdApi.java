package com.myfun.erpWeb.managecenter.transaction.api;

import com.myfun.erpWeb.managecenter.profit.vo.ErpFunPerformanceTypeResultVo;
import com.myfun.erpWeb.managecenter.transaction.param.*;
import com.myfun.erpWeb.managecenter.transaction.vo.*;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.param.ErpFunPerformanceTypeParam;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import scala.annotation.meta.param;

@Api(tags = "合同模块")
@RequestMapping("/fjd/managerCenter/transaction/deal")
public interface DealBusinessFjdApi {

    @ApiOperation("获取业绩类别列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetFjdFunPerformanceTypeListVO.class, message = "成功")
    })
    @PostMapping("/getFjdFunPerformanceTypeList")
    public ResponseJson getFjdFunPerformanceTypeList();

    @ApiOperation("更新拆佣规则列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/updateCommissioningRulesList")
    public ErpResponseJson updateCommissioningRulesList(@RequestBody UpdateCommissioningRulesListParam param) throws Exception;

    @ApiOperation("查询停用业绩类型列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetPerformanceTypeListVO.class, message = "成功")
    })
    @PostMapping("/getDisablePerformanceTypeList")
    public ErpResponseJson getDisablePerformanceTypeList(@RequestBody GetDisablePerformanceTypeListParam param);

    @ApiOperation("停用业绩类型判重")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DisablePerformanceTypeJudgmentVO.class ,message = "成功")
    })
    @PostMapping("/disablePerformanceTypeJudgment")
    public ErpResponseJson disablePerformanceTypeJudgment(@RequestBody DisablePerformanceTypeJudgmentParam param);

    @ApiOperation("删除业绩类别")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class ,  message = "成功")
    })
    @PostMapping("/deletePerformanceCategory")
    public ResponseJson deletePerformanceCategory(@RequestBody DeletePerformanceCategoryParam param);

    @ApiOperation("删除拆分小类别配置")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class ,  message = "成功")
    })
    @PostMapping("/deleteSplitSmallCategoryConfiguration")
    public ResponseJson deleteSplitSmallCategoryConfiguration(@RequestBody DeleteSplitSmallCategoryConfigurationParam param);

    @ApiOperation("判断业绩类别是否已使用")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = DetermineIfThePerformanceCategoryIsUsedVO.class ,  message = "成功")
    })
    @PostMapping("/determineIfThePerformanceCategoryIsUsed")
    public ResponseJson determineIfThePerformanceCategoryIsUsed(@RequestBody DetermineIfThePerformanceCategoryIsUsedParam param);
}

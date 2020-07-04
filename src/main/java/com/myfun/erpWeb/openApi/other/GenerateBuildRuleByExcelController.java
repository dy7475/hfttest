package com.myfun.erpWeb.openApi.other;

import com.myfun.erpWeb.businesstools.builddic.param.GenerateBuildRuleByExcelParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomService;
import com.myfun.utils.HttpUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czq
 * @since 2019/9/17
 */
@Controller
@RequestMapping(value = "/openApi/buildRule")
public class GenerateBuildRuleByExcelController extends BaseController {

    @Resource
    private ErpBuildingSetRoomService erpBuildingSetRoomService;

    @PostMapping("/generateBuildRuleByExcel")
    @ResponseBody
    public ResponseJson generateBuildRuleByExcel(@Valid @RequestBody GenerateBuildRuleByExcelParam param) {
        erpBuildingSetRoomService.generateBuildRuleByExcel(param);
        return ErpResponseJson.ok();
    }

    @ApiOperation("10楼下补0")
    @PostMapping("/buildRuleAddZero")
    @ResponseBody
    public ResponseJson buildRuleAddZero(@Valid @RequestBody GenerateBuildRuleByExcelParam param) {
        erpBuildingSetRoomService.buildRuleAddZero(param);
        return ErpResponseJson.ok();
    }

    @ApiOperation("清空楼盘规则错误数据")
    @PostMapping("/delBuildRule")
    @ResponseBody
    public ResponseJson delBuildRule(@Valid @RequestBody GenerateBuildRuleByExcelParam param) {
        erpBuildingSetRoomService.delBuildRule(param);
        return ErpResponseJson.ok();
    }


    public static void main(String[] args) {
        Map<String, Object> paramMap = new HashMap<>();
       paramMap.put("compNo", "E2MZ");
        try {
            String result = HttpUtil.postJson("http://hft.myfun7.com/erpWeb/openApi/buildRule/generateBuildRuleByExcel", paramMap);
//            String result = HttpUtil.postJson("http://192.168.200.163:8070/erpWeb/openApi/buildRule/buildRuleAddZero", paramMap);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
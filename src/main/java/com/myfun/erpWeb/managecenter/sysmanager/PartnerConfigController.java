package com.myfun.erpWeb.managecenter.sysmanager;

import com.myfun.erpWeb.managecenter.sysmanager.param.UpdatePartnerConfigParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.PartnerConfigVo;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 */
@Api(tags = "加盟商配置管理")
@RestController
@RequestMapping("/managerCenter/organization/partner/")
public class PartnerConfigController extends BaseController {

    @Autowired
    private ErpFunPartnerConfigService erpFunPartnerConfigService;

    @ApiOperation("获取加盟配置")
    @PostMapping("/getConfig")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "获取配置", response = PartnerConfigVo.class)})
    public ErpResponseJson getConfig() {

        Operator op = getOperator();
        PartnerConfigDto dto = erpFunPartnerConfigService.getPartnerConfiguration(op.getCityId(), op.getCompId());
        PartnerConfigVo vo = new PartnerConfigVo();
        BeanUtils.copyProperties(dto,vo);
        return ErpResponseJson.ok(vo);
    }


    @ApiOperation("修改加盟配置")
    @PostMapping("/updateConfig")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "修改加盟配置", response = ErpResponseJson.class)})
    public ErpResponseJson updateConfig(@RequestBody UpdatePartnerConfigParam param) {

        Operator op = getOperator();
        param.setCityId(op.getCityId());
        param.setCompId(op.getCompId());
        erpFunPartnerConfigService.updateConfig(new GeneralParam(op), param);
        return ErpResponseJson.ok();
    }
}

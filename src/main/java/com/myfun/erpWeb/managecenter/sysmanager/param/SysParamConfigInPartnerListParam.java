package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2019/11/20
 */
public class SysParamConfigInPartnerListParam implements EncryParamIfc {

    @ApiModelProperty("系统参数-编辑的模块 1=隐号拨打 2=转盘规则 3=公盘、抢盘查看范围 4=查看核心信息规则 5=策略参数  修改哪些项就上传哪些项")
    private List<SysParamConfigInPartnerParam> configs;

    public List<SysParamConfigInPartnerParam> getConfigs() {
        return configs;
    }

    public void setConfigs(List<SysParamConfigInPartnerParam> configs) {
        this.configs = configs;
    }

}
package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/11/12
 */
public class SysParamConfigInPartnerParam implements EncryParamIfc {

    @ApiModelProperty("系统参数是否开启加盟商自行配置 0=关闭 1=开启")
    private Byte selfConfig;

    @ApiModelProperty("系统参数-编辑的模块 1=隐号拨打 2=转盘规则 3=公盘、抢盘查看范围 4=查看核心信息规则 5=策略参数")
    private Byte module;

    public Byte getSelfConfig() {
        return selfConfig;
    }

    public void setSelfConfig(Byte selfConfig) {
        this.selfConfig = selfConfig;
    }

    public Byte getModule() {
        return module;
    }

    public void setModule(Byte module) {
        this.module = module;
    }
}
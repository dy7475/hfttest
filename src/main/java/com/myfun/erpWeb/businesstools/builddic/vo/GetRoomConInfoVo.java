package com.myfun.erpWeb.businesstools.builddic.vo;

import com.myfun.repository.erpdb.po.ErpBuildingMarketingControl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class GetRoomConInfoVo {
    @ApiModelProperty("消控信息")
    private List<ErpBuildingMarketingControlDto> conInfos;

    public List<ErpBuildingMarketingControlDto> getConInfos() {
        return conInfos;
    }

    public void setConInfos(List<ErpBuildingMarketingControlDto> conInfos) {
        this.conInfos = conInfos;
    }
}

package com.myfun.erpWeb.managecenter.buildData.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @create by 程二狗 on 2019/2/19 0019
 **/
@ApiModel
public class MgrFloorListParam  implements EncryParamIfc {
    @ApiModelProperty("楼盘名称")
    private String  buildName;
    @ApiModelProperty("排序字段")
    private String  orderBy;
    @ApiModelProperty("页码")
    private  Integer pageOffset; // 1 第几页
    @ApiModelProperty("每页显示数量")
    private  Integer pageRows; // 50 一页多少条

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
    }
}

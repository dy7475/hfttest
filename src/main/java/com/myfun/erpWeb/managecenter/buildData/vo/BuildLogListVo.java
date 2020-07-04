package com.myfun.erpWeb.managecenter.buildData.vo;

import com.myfun.repository.erpdb.po.ErpBuildLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @create by 程二狗 on 2019/2/21 0021
 **/
@ApiModel
public class BuildLogListVo implements Serializable {
    @ApiModelProperty("页码")
    private  Integer pageOffset;
    @ApiModelProperty("每页显示数量")
    private  Integer pageRows;
    @ApiModelProperty("总数量")
    private Long totalcount;
    @ApiModelProperty("楼盘资料列表数据")
    private List<ErpBuildLog> buildLogList;

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

    public Long getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Long totalcount) {
        this.totalcount = totalcount;
    }

    public List<ErpBuildLog> getBuildLogList() {
        return buildLogList;
    }

    public void setBuildLogList(List<ErpBuildLog> buildLogList) {
        this.buildLogList = buildLogList;
    }
}

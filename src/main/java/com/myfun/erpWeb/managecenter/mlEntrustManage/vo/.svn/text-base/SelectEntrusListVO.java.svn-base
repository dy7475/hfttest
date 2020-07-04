package com.myfun.erpWeb.managecenter.mlEntrustManage.vo;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author HuangJiang
 * @since 2019年11月26日 17:30:54
 * Modified XXX HuangJiang 2019年11月26日
 */
@ApiModel
public class SelectEntrusListVO {

    @ApiModelProperty(value = "备案（或修改备案）权：0=无 1=有")
    private Integer entrustRecord;
    @ApiModelProperty(value = "清空备案权： 0=无 1=有")
    private Integer clearEntrustRecord;
    @ApiModelProperty(value = "委托信息")
    private PageInfo<EntrusListVO> pageInfo;
    
    public PageInfo<EntrusListVO> getPageInfo() {
        return pageInfo;
    }
    
    public void setPageInfo(PageInfo<EntrusListVO> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Integer getEntrustRecord() {
        return entrustRecord;
    }

    public void setEntrustRecord(Integer entrustRecord) {
        this.entrustRecord = entrustRecord;
    }
    
    public Integer getClearEntrustRecord() {
        return clearEntrustRecord;
    }
    
    public void setClearEntrustRecord(Integer clearEntrustRecord) {
        this.clearEntrustRecord = clearEntrustRecord;
    }
    
}

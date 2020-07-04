package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Auther: leber
 * @Description: 添加加盟商
 */
@ApiModel
public class SearchPartnerParam extends AbstractEncryParam {

    @ApiModelProperty(value = "加盟商id，自增")
    private Integer id;

    @ApiModelProperty(value = "公司id",hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "门店id")
    private Integer deptId;

    @ApiModelProperty(value = "负责人id")
    private Integer userId;

    @ApiModelProperty(value = "查询时间区间:开始时间")
    private String startTime;

    @ApiModelProperty(value = "查询时间区间:结束时间")
    private String endTime;

    @ApiModelProperty(value = "查询时间区间:开始时间",hidden = true)
    private Date startDate;

    @ApiModelProperty(value = "查询时间区间:结束时间", hidden = true)
    private Date endDate;
    @ApiModelProperty(value = "模糊检索:加盟商,负责人,门店")
    private String fuzzySearch;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFuzzySearch() {
        return fuzzySearch;
    }

    public void setFuzzySearch(String fuzzySearch) {
        this.fuzzySearch = fuzzySearch;
    }
}

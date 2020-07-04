package com.myfun.erpWeb.managecenter.profit.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import scala.Int;

/**
 * 查询业绩提成发放下拉列表
 * 请求参数封装
 * create by 程二狗 on 2018/11/17 0017
 */
@ApiModel
public class AbormalFunProfitDetailListParam implements EncryParamIfc {
    @ApiModelProperty(value = "公司ID",hidden = true)
    private Integer compId;
    @ApiModelProperty("用户ID(app)")
    private Integer userId;
    @ApiModelProperty(value = "查询月",hidden = true)
    private String queryMonth;
    @ApiModelProperty("结算月(app)")
    private String assessmentMonth;
    @ApiModelProperty("业绩类别1或2=正常 3=异常(app) 房基地分成时，没有这个参数")
    private Integer profitType;
    @ApiModelProperty(value = "用户档案ID",hidden = true)
    private Integer archiveId;

    public String getAssessmentMonth() {
        return assessmentMonth;
    }

    public void setAssessmentMonth(String assessmentMonth) {
        this.assessmentMonth = assessmentMonth;
    }

    public Integer getProfitType() {
        return profitType;
    }

    public void setProfitType(Integer profitType) {
        this.profitType = profitType;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getQueryMonth() {
        return queryMonth;
    }

    public void setQueryMonth(String queryMonth) {
        this.queryMonth = queryMonth;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}

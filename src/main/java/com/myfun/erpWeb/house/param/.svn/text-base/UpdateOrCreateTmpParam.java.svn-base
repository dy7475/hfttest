package com.myfun.erpWeb.house.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateOrCreateTmpParam {
    @ApiModelProperty("id不为空时删除  更新和新增时为空")
    private Integer tid;
    @ApiModelProperty("房源描述")
    private String richText;
    @ApiModelProperty("租售类型，1=出售 2=出租")
    private Byte caseType;
    @ApiModelProperty("0为公司 1为个人")
    private Integer queryType;
    @ApiModelProperty("1：更新  其他：新增")
    private String oper;
    @ApiModelProperty("模板id")
    private Integer tempid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getRichText() {
        return richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public Integer getTempid() {
        return tempid;
    }

    public void setTempid(Integer tempid) {
        this.tempid = tempid;
    }
}

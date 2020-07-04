package com.myfun.erpWeb.managecenter.profit.vo;

import com.myfun.repository.erpdb.po.ErpFunAssessmentStatistics;
import com.myfun.repository.erpdb.po.ErpFunRoleWageProfit;
import com.myfun.repository.erpdb.po.ErpFunRoleWageWorkcount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 基本工资返回数据VO
 * create by 程二狗 on 2018/11/14 0014
 */
@ApiModel(description = "基本工资")
public class PerformanceAssessmentCountListVo implements Serializable {
    @ApiModelProperty("状态码")
    private int errCode;
    @ApiModelProperty("返回值说明")
    private String errMsg;
    @ApiModelProperty("总条数")
    private Long total;
    @ApiModelProperty("页码")
    private Integer pageNum;
    @ApiModelProperty("每页数量")
    private Integer pageSize;
    @ApiModelProperty("总页数")
    private Integer totalPage;
    @ApiModelProperty("当前服务器时间")
    private String serverTime;
    @ApiModelProperty("用户列表")
    private List<ErpFunAssessmentStatistics> funUserLsit;
    @ApiModelProperty("考核统计")
    private List<ErpFunAssessmentStatistics> dataList;
    @ApiModelProperty("工作量考核薪资")
    private List<ErpFunRoleWageWorkcount> workCountConfigList;
    @ApiModelProperty("业绩提成")
    private List<ErpFunRoleWageProfit>  profitConfigList;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public List<ErpFunAssessmentStatistics> getFunUserLsit() {
        return funUserLsit;
    }

    public void setFunUserLsit(List<ErpFunAssessmentStatistics> funUserLsit) {
        this.funUserLsit = funUserLsit;
    }

    public List<ErpFunAssessmentStatistics> getDataList() {
        return dataList;
    }

    public void setDataList(List<ErpFunAssessmentStatistics> dataList) {
        this.dataList = dataList;
    }

    public List<ErpFunRoleWageWorkcount> getWorkCountConfigList() {
        return workCountConfigList;
    }

    public void setWorkCountConfigList(List<ErpFunRoleWageWorkcount> workCountConfigList) {
        this.workCountConfigList = workCountConfigList;
    }

    public List<ErpFunRoleWageProfit> getProfitConfigList() {
        return profitConfigList;
    }

    public void setProfitConfigList(List<ErpFunRoleWageProfit> profitConfigList) {
        this.profitConfigList = profitConfigList;
    }
}

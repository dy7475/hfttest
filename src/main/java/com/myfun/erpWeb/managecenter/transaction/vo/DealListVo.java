package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.dto.ErpFunDealExtVO;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @author czq
 * @since 2019/3/11
 */
public class DealListVo {
    @ApiModelProperty("合同列表")
    private List<ErpFunDealExtVO> list;

    @ApiModelProperty("总条数")
    private long total;

    @ApiModelProperty("额外数据({\"area(总面积)\":786.00,\"totalRealIncome(实收金额)\":20000.00," +
            "\"sellDealMoney(成交金额)\":54530000.00,\"totalNeedIncome(应收金额)\":130357.00,\"totalRealPerformance(实收业绩)\":20000.00})")
    private Map<String, Object> extra;

    @ApiModelProperty("当前页数")
    private Integer pageNum;

    @ApiModelProperty("每页条数")
    private Integer pageSize;

    public List<ErpFunDealExtVO> getList() {
        return list;
    }

    public void setList(List<ErpFunDealExtVO> list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
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
}
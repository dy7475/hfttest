package com.myfun.erpWeb.usercenter.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class InvoiceNotWritedDto extends BaseListResultVo {

    private List<InvoiceNotWritedVo> list;

    public InvoiceNotWritedDto(PageInfo pageInfo) {
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        this.setList(pageInfo.getList());
    }

    public List<InvoiceNotWritedVo> getList() {
        return list;
    }

    public void setList(List<InvoiceNotWritedVo> list) {
        this.list = list;
    }
}

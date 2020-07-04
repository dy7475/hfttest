package com.myfun.erpWeb.usercenter.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class GetPaidListVo extends BaseListResultVo {

    private List<AdminFunPaidVo> list;

    public GetPaidListVo(PageInfo pageInfo) {
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        this.setList(pageInfo.getList());
    }

    public List<AdminFunPaidVo> getList() {
        return list;
    }

    public void setList(List<AdminFunPaidVo> list) {
        this.list = list;
    }
}

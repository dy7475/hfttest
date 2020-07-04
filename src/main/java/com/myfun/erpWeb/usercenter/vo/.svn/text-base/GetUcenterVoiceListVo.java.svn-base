package com.myfun.erpWeb.usercenter.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class GetUcenterVoiceListVo extends BaseListResultVo {

    private List<AdminIpCallLog> list;

    public GetUcenterVoiceListVo(PageInfo pageInfo) {
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        this.setList(pageInfo.getList());
    }

    public List<AdminIpCallLog> getList() {
        return list;
    }

    public void setList(List<AdminIpCallLog> list) {
        this.list = list;
    }
}

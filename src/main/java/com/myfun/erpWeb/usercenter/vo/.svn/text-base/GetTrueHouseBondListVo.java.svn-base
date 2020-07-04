package com.myfun.erpWeb.usercenter.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.admindb.po.AdminTruehouseBondRecord;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class GetTrueHouseBondListVo extends BaseListResultVo {

    private List<AdminTruehouseBondRecord> list;

    public GetTrueHouseBondListVo(PageInfo pageInfo){
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        this.setList(pageInfo.getList());
    }

    public List<AdminTruehouseBondRecord> getList() {
        return list;
    }

    public void setList(List<AdminTruehouseBondRecord> list) {
        this.list = list;
    }
}

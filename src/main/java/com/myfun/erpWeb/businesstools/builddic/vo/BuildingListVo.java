package com.myfun.erpWeb.businesstools.builddic.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * create by wangchun on 2018/12/11
 */
@ApiModel
public class BuildingListVo extends BaseListResultVo {

    private List<BuildingInfoVo> list;

    public BuildingListVo(PageInfo pageInfo){
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        this.setList(pageInfo.getList());
    }

    public List<BuildingInfoVo> getList() {
        return list;
    }

    public void setList(List<BuildingInfoVo> list) {
        this.list = list;
    }
}

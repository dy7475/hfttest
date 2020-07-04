package com.myfun.erpWeb.businesstools.builddic.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czq
 * @since 2019/4/4
 */
public class BuildingListInMobileVo extends BaseListResultVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("楼盘字典列表")
    private List<BuildingInfoInMobileVo> builds;

    public BuildingListInMobileVo(PageInfo pageInfo){
        this.setPageNum(pageInfo.getPageNum());
        this.setPages(pageInfo.getPages());
        this.setPageSize(pageInfo.getPageSize());
        this.setTotal(pageInfo.getTotal());
        if (pageInfo.getList() == null) {
            this.setBuilds(new ArrayList<>());
        } else {
            this.setBuilds(pageInfo.getList());
        }
    }

    public List<BuildingInfoInMobileVo> getBuilds() {
        return builds;
    }

    public void setBuilds(List<BuildingInfoInMobileVo> builds) {
        this.builds = builds;
    }
}
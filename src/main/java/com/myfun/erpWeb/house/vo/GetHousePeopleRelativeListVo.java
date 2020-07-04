package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel
public class GetHousePeopleRelativeListVo {

    private List<SalePeRelDto> SalePeRelList;
    private List<LeasePeRelDto> leaseRelativeList;

    public List<SalePeRelDto> getSalePeRelList() {
        return SalePeRelList;
    }

    public void setSalePeRelList(List<SalePeRelDto> salePeRelList) {
        SalePeRelList = salePeRelList;
    }

    public List<LeasePeRelDto> getLeaseRelativeList() {
        return leaseRelativeList;
    }

    public void setLeaseRelativeList(List<LeasePeRelDto> leaseRelativeList) {
        this.leaseRelativeList = leaseRelativeList;
    }
}

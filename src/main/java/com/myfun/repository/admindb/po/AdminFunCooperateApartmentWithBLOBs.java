package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunCooperateApartmentWithBLOBs extends AdminFunCooperateApartment implements Serializable {
    /**
     *
     * @mbggenerated
    合作公寓系统的房屋图片url列表（JSON数组串）
     */
    private String picUrlList;

    /**
     *
     * @mbggenerated
    房间描述（50-500字以内）
     */
    private String houseDesc;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getPicUrlList() {
        return picUrlList;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPicUrlList(String picUrlList) {
        this.picUrlList = picUrlList == null ? null : picUrlList.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouseDesc() {
        return houseDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc == null ? null : houseDesc.trim();
    }
}
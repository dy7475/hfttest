package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopMenu implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short id;

    /**
     *
     * @mbggenerated
     */
    private Short pid;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String model;

    /**
     *
     * @mbggenerated
     */
    private String action;

    /**
     *
     * @mbggenerated
     */
    private String icon;

    /**
     *
     * @mbggenerated
     */
    private String remark;

    /**
     *
     * @mbggenerated
     */
    private Short sort;

    /**
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private String data;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getPid() {
        return pid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPid(Short pid) {
        this.pid = pid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @mbggenerated
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getAction() {
        return action;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Short getSort() {
        return sort;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @mbggenerated
     */
    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}
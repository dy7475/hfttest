package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopRule implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer weixinId;

    /**
     *
     * @mbggenerated
     */
    private Integer aid;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String replyType;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getWeixinId() {
        return weixinId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWeixinId(Integer weixinId) {
        this.weixinId = weixinId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAid() {
        return aid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAid(Integer aid) {
        this.aid = aid;
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
    public String getReplyType() {
        return replyType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReplyType(String replyType) {
        this.replyType = replyType == null ? null : replyType.trim();
    }
}
package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopWechatMenu implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     *
     * @mbggenerated
     */
    private String title;

    /**
     *
     * @mbggenerated
     */
    private String type;

    /**
     *
     * @mbggenerated
     */
    private String key;

    /**
     *
     * @mbggenerated
     */
    private String url;

    /**
     *
     * @mbggenerated
     */
    private Byte isSystem;

    /**
     *
     * @mbggenerated
     */
    private Integer weixinId;

    /**
     *
     * @mbggenerated
     */
    private Integer idx;

    /**
     *
     * @mbggenerated
     */
    private String cname;

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
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @mbggenerated
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsSystem() {
        return isSystem;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsSystem(Byte isSystem) {
        this.isSystem = isSystem;
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
    public Integer getIdx() {
        return idx;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCname() {
        return cname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}
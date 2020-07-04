package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopPosts implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer postId;

    /**
     *
     * @mbggenerated
     */
    private Integer brokerId;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    private Integer likeNum;

    /**
     *
     * @mbggenerated
     */
    private Integer ctime;

    /**
     *
     * @mbggenerated
     */
    private String content;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBrokerId() {
        return brokerId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCtime() {
        return ctime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
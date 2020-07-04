package com.myfun.repository.agencydb.po;

import java.util.Date;

public class AgencyWfImFriend {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private Integer friendId;

    /**
     *
     * @mbggenerated
     */
    private Byte state;

    /**
     *
     * @mbggenerated
     */
    private Date addTime;

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
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFriendId() {
        return friendId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getState() {
        return state;
    }

    /**
     *
     * @mbggenerated
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
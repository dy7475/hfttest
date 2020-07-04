package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminDicConvert extends AdminDicConvertKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String memo;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
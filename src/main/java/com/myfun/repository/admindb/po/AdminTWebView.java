package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminTWebView extends AdminTWebViewKey implements Serializable {
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
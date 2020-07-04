package com.myfun.repository.admindb.po;

public class AdminQrtzLocksKey {
    /**
     *
     * @mbggenerated
     */
    private String schedName;

    /**
     *
     * @mbggenerated
     */
    private String lockName;

    /**
     *
     * @mbggenerated
     */
    public String getSchedName() {
        return schedName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSchedName(String schedName) {
        this.schedName = schedName == null ? null : schedName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getLockName() {
        return lockName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLockName(String lockName) {
        this.lockName = lockName == null ? null : lockName.trim();
    }
}
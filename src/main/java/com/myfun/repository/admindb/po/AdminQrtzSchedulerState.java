package com.myfun.repository.admindb.po;

public class AdminQrtzSchedulerState extends AdminQrtzSchedulerStateKey {
    /**
     *
     * @mbggenerated
     */
    private Long lastCheckinTime;

    /**
     *
     * @mbggenerated
     */
    private Long checkinInterval;

    /**
     *
     * @mbggenerated
     */
    public Long getLastCheckinTime() {
        return lastCheckinTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLastCheckinTime(Long lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getCheckinInterval() {
        return checkinInterval;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCheckinInterval(Long checkinInterval) {
        this.checkinInterval = checkinInterval;
    }
}
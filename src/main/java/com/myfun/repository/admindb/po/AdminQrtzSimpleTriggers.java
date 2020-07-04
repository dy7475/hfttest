package com.myfun.repository.admindb.po;

public class AdminQrtzSimpleTriggers extends AdminQrtzSimpleTriggersKey {
    /**
     *
     * @mbggenerated
     */
    private Long repeatCount;

    /**
     *
     * @mbggenerated
     */
    private Long repeatInterval;

    /**
     *
     * @mbggenerated
     */
    private Long timesTriggered;

    /**
     *
     * @mbggenerated
     */
    public Long getRepeatCount() {
        return repeatCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRepeatCount(Long repeatCount) {
        this.repeatCount = repeatCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getRepeatInterval() {
        return repeatInterval;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRepeatInterval(Long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getTimesTriggered() {
        return timesTriggered;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTimesTriggered(Long timesTriggered) {
        this.timesTriggered = timesTriggered;
    }
}
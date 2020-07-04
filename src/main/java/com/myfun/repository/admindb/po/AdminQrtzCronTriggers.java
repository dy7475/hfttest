package com.myfun.repository.admindb.po;

public class AdminQrtzCronTriggers extends AdminQrtzCronTriggersKey {
    /**
     *
     * @mbggenerated
     */
    private String cronExpression;

    /**
     *
     * @mbggenerated
     */
    private String timeZoneId;

    /**
     *
     * @mbggenerated
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId == null ? null : timeZoneId.trim();
    }
}
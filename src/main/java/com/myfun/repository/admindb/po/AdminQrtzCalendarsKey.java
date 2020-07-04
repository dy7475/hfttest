package com.myfun.repository.admindb.po;

public class AdminQrtzCalendarsKey {
    /**
     *
     * @mbggenerated
     */
    private String schedName;

    /**
     *
     * @mbggenerated
     */
    private String calendarName;

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
    public String getCalendarName() {
        return calendarName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName == null ? null : calendarName.trim();
    }
}
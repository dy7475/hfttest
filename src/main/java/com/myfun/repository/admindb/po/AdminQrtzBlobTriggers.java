package com.myfun.repository.admindb.po;

public class AdminQrtzBlobTriggers {
    /**
     *
     * @mbggenerated
     */
    private String schedName;

    /**
     *
     * @mbggenerated
     */
    private String triggerName;

    /**
     *
     * @mbggenerated
     */
    private String triggerGroup;

    /**
     *
     * @mbggenerated
     */
    private byte[] blobData;

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
    public String getTriggerName() {
        return triggerName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTriggerGroup() {
        return triggerGroup;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup == null ? null : triggerGroup.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public byte[] getBlobData() {
        return blobData;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }
}
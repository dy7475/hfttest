package com.myfun.repository.admindb.po;

public class AdminQrtzFiredTriggersKey {
    /**
     *
     * @mbggenerated
     */
    private String schedName;

    /**
     *
     * @mbggenerated
     */
    private String entryId;

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
    public String getEntryId() {
        return entryId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEntryId(String entryId) {
        this.entryId = entryId == null ? null : entryId.trim();
    }
}
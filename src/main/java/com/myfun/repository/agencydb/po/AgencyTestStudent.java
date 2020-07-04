package com.myfun.repository.agencydb.po;

public class AgencyTestStudent {
    /**
     *
     * @mbggenerated
     */
    private Integer sNumber;

    /**
     *
     * @mbggenerated
     */
    private Integer classId;

    /**
     *
     * @mbggenerated
     */
    private String sName;

    /**
     *
     * @mbggenerated
     */
    private Integer sAge;

    /**
     *
     * @mbggenerated
     */
    private String sAddress;

    /**
     *
     * @mbggenerated
     */
    public Integer getsNumber() {
        return sNumber;
    }

    /**
     *
     * @mbggenerated
     */
    public void setsNumber(Integer sNumber) {
        this.sNumber = sNumber;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getsName() {
        return sName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getsAge() {
        return sAge;
    }

    /**
     *
     * @mbggenerated
     */
    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    /**
     *
     * @mbggenerated
     */
    public String getsAddress() {
        return sAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setsAddress(String sAddress) {
        this.sAddress = sAddress == null ? null : sAddress.trim();
    }
}
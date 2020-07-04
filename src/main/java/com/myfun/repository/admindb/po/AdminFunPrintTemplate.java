package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunPrintTemplate implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    private String jspName;

    /**
     *
     * @mbggenerated
     */
    private String templateName;

    /**
     *
     * @mbggenerated
     */
    private Byte saleLease;

    /**
     *
     * @mbggenerated
     */
    private String tempType;

    /**
     *
     * @mbggenerated
     */
    private String directType;

    /**
     *
     * @mbggenerated
     */
    private String updateTime;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getJspName() {
        return jspName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setJspName(String jspName) {
        this.jspName = jspName == null ? null : jspName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleLease() {
        return saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLease(Byte saleLease) {
        this.saleLease = saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTempType() {
        return tempType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTempType(String tempType) {
        this.tempType = tempType == null ? null : tempType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getDirectType() {
        return directType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDirectType(String directType) {
        this.directType = directType == null ? null : directType.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}
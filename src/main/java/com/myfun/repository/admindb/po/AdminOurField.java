package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminOurField implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Short fieldId;

    /**
     *
     * @mbggenerated
     */
    private Byte saleLease;

    /**
     *
     * @mbggenerated
     */
    private Byte urlType;

    /**
     *
     * @mbggenerated
     */
    private String fieldName;

    /**
     *
     * @mbggenerated
     */
    private String fieldDesc;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Short getFieldId() {
        return fieldId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFieldId(Short fieldId) {
        this.fieldId = fieldId;
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
    public Byte getUrlType() {
        return urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUrlType(Byte urlType) {
        this.urlType = urlType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }
}
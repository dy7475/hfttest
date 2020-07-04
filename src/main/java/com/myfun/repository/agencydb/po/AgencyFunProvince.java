package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyFunProvince implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer provinceId;

    /**
     *
     * @mbggenerated
     */
    private String provinceName;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private String provinceDesc;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
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

    /**
     *
     * @mbggenerated
     */
    public String getProvinceDesc() {
        return provinceDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceDesc(String provinceDesc) {
        this.provinceDesc = provinceDesc == null ? null : provinceDesc.trim();
    }
}
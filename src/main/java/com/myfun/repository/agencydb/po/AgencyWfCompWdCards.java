package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfCompWdCards implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer cardId;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String cardNumber;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String ia;

    /**
     *
     * @mbggenerated
     */
    private String iaAcr;

    /**
     *
     * @mbggenerated
     */
    private String type;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getCardId() {
        return cardId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIa() {
        return ia;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIa(String ia) {
        this.ia = ia == null ? null : ia.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getIaAcr() {
        return iaAcr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIaAcr(String iaAcr) {
        this.iaAcr = iaAcr == null ? null : iaAcr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
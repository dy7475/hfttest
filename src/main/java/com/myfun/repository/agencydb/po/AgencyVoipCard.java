package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AgencyVoipCard implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String cardNo;

    /**
     *
     * @mbggenerated
     */
    private String cardPw;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     *
     * @mbggenerated
     */
    private Integer cardStatus;

    /**
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private Date useTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCardPw() {
        return cardPw;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCardPw(String cardPw) {
        this.cardPw = cardPw == null ? null : cardPw.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCardStatus() {
        return cardStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCardStatus(Integer cardStatus) {
        this.cardStatus = cardStatus;
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

    /**
     *
     * @mbggenerated
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }
}
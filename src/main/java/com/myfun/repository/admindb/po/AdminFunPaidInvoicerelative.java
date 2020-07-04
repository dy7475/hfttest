package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminFunPaidInvoicerelative implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "消费id")
    private Integer paidId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "发票id")
    private Integer invoiceId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 消费id
     */
    public Integer getPaidId() {
        return paidId;
    }

    /**
     *
     * @mbggenerated
     * 消费id
     */
    public void setPaidId(Integer paidId) {
        this.paidId = paidId;
    }

    /**
     *
     * @mbggenerated
     * 发票id
     */
    public Integer getInvoiceId() {
        return invoiceId;
    }

    /**
     *
     * @mbggenerated
     * 发票id
     */
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }
}
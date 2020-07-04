package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.math.BigDecimal;

public class AdminOrder0713 implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String time;

    /**
     *
     * @mbggenerated
     */
    private String name;

    /**
     *
     * @mbggenerated
     */
    private String order;

    /**
     *
     * @mbggenerated
     */
    private BigDecimal money;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
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
    public String getOrder() {
        return order;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOrder(String order) {
        this.order = order == null ? null : order.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
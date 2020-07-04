package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyRfProcRela implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer relationId;

    /**
     *
     * @mbggenerated
     */
    private Integer procedureId;

    /**
     *
     * @mbggenerated
     */
    private Integer subId;

    /**
     *
     * @mbggenerated
     */
    private String flowname;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getRelationId() {
        return relationId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getProcedureId() {
        return procedureId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSubId() {
        return subId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFlowname() {
        return flowname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlowname(String flowname) {
        this.flowname = flowname == null ? null : flowname.trim();
    }
}
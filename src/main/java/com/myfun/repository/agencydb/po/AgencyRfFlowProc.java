package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyRfFlowProc implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer procedureId;

    /**
     *
     * @mbggenerated
     */
    private String procedureName;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getProcedureName() {
        return procedureName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName == null ? null : procedureName.trim();
    }
}
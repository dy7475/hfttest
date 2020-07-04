package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunTempletWithBLOBs extends AdminFunTemplet implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String charactTemplet;

    /**
     *
     * @mbggenerated
     */
    private String charactTempletEncode;

    /**
     *
     * @mbggenerated
     */
    private String charactTempletEncodeOld;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getCharactTemplet() {
        return charactTemplet;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCharactTemplet(String charactTemplet) {
        this.charactTemplet = charactTemplet == null ? null : charactTemplet.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCharactTempletEncode() {
        return charactTempletEncode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCharactTempletEncode(String charactTempletEncode) {
        this.charactTempletEncode = charactTempletEncode == null ? null : charactTempletEncode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCharactTempletEncodeOld() {
        return charactTempletEncodeOld;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCharactTempletEncodeOld(String charactTempletEncodeOld) {
        this.charactTempletEncodeOld = charactTempletEncodeOld == null ? null : charactTempletEncodeOld.trim();
    }
}
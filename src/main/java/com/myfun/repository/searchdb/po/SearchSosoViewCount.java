package com.myfun.repository.searchdb.po;

import java.io.Serializable;
import java.util.Date;

public class SearchSosoViewCount implements Serializable {
    /**
     *
     * @mbggenerated
    主键自增ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    admin库的门店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    数据类型，1=历史数据
     */
    private Byte dataType;

    /**
     *
     * @mbggenerated
    查看条数
     */
    private Integer viewCount;

    /**
     *
     * @mbggenerated
    查看日期
     */
    private Date creationTime;

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
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
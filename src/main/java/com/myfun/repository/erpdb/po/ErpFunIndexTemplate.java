package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpFunIndexTemplate extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    模板ID
     */
    private Integer templateId;

    /**
     *
     * @mbggenerated
    指标ID
     */
    private Integer indexId;

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
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getIndexId() {
        return indexId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunIndexTemplate() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunIndexTemplate(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}
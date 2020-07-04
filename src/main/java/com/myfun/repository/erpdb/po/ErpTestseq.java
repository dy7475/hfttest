package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpTestseq extends ShardDb {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String name;

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
    public ErpTestseq() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpTestseq(Integer shardCityId) {
        super(shardCityId);
    }
}
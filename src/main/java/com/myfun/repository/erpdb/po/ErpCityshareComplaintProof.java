package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;

public class ErpCityshareComplaintProof extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键自增
     */
    private Integer proofId;

    /**
     *
     * @mbggenerated
    关联投诉表主键ID
     */
    private Integer complaintId;

    /**
     *
     * @mbggenerated
    录音日志ID关联表
     */
    private String voipId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getProofId() {
        return proofId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProofId(Integer proofId) {
        this.proofId = proofId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getComplaintId() {
        return complaintId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getVoipId() {
        return voipId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setVoipId(String voipId) {
        this.voipId = voipId == null ? null : voipId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareComplaintProof() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareComplaintProof(Integer shardCityId, Integer proofId) {
        super(shardCityId);
        this.proofId = proofId;
    }
}
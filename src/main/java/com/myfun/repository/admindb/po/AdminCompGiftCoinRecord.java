package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminCompGiftCoinRecord implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键，自增")
    private Integer giftId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "门店id")
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司编号")
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "门店编号")
    private String deptNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "赠送金额")
    private Integer giftAmount;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "哪些人通过实名认证后赠送的,逗号分隔")
    private String archiveIds;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键，自增
     */
    public Integer getGiftId() {
        return giftId;
    }

    /**
     *
     * @mbggenerated
     * 主键，自增
     */
    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    /**
     *
     * @mbggenerated
     * 门店id
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     * 门店id
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     * 公司编号
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     * 公司编号
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    /**
     *
     * @mbggenerated
     * 门店编号
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     *
     * @mbggenerated
     * 门店编号
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    /**
     *
     * @mbggenerated
     * 赠送金额
     */
    public Integer getGiftAmount() {
        return giftAmount;
    }

    /**
     *
     * @mbggenerated
     * 赠送金额
     */
    public void setGiftAmount(Integer giftAmount) {
        this.giftAmount = giftAmount;
    }

    /**
     *
     * @mbggenerated
     * 哪些人通过实名认证后赠送的,逗号分隔
     */
    public String getArchiveIds() {
        return archiveIds;
    }

    /**
     *
     * @mbggenerated
     * 哪些人通过实名认证后赠送的,逗号分隔
     */
    public void setArchiveIds(String archiveIds) {
        this.archiveIds = archiveIds;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
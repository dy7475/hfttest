package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpCityshareBorkerPurchase extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    SEQ序列
     */
    private Integer purchaseId;

    /**
     *
     * @mbggenerated
    用户ID
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    是否返还 0=买家已付款 1=已过24小时，钱打到了房源方账号下 2=已退款 3：已过24小时 投诉中
     */
    private Byte returnStatus;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    CRM操作方便
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    分享表ID
     */
    private Integer sharehouseId;

    /**
     *
     * @mbggenerated
    1=免费 2=金额 3=本门店买断
     */
    private Byte purchaseType;

    /**
     *
     * @mbggenerated
    分享方 总经理所得费用
     */
    private BigDecimal managerGetMoney;

    /**
     *
     * @mbggenerated
    分享者所得费用
     */
    private BigDecimal shareGetMoney;

    /**
     *
     * @mbggenerated
    查看状态，0=已购买 1=已拨打过电话
     */
    private Byte viewStatus;

    /**
     *
     * @mbggenerated
    档案ID 查看方
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    给房源方的钱是否成功到账 0=初始值 1=已给   只是做记录
     */
    private Byte shareReturn;

    /**
     *
     * @mbggenerated
    给房源方的总经理的钱是否成功到账 0=初始值 1=已给   只是做记录
     */
    private Byte managerReturn;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Byte targetComplainFlag;

    /**
     *
     * @mbggenerated
     */
    private Byte complainFlag;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPurchaseId() {
        return purchaseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getReturnStatus() {
        return returnStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
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

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSharehouseId() {
        return sharehouseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSharehouseId(Integer sharehouseId) {
        this.sharehouseId = sharehouseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getPurchaseType() {
        return purchaseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPurchaseType(Byte purchaseType) {
        this.purchaseType = purchaseType;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getManagerGetMoney() {
        return managerGetMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setManagerGetMoney(BigDecimal managerGetMoney) {
        this.managerGetMoney = managerGetMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getShareGetMoney() {
        return shareGetMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShareGetMoney(BigDecimal shareGetMoney) {
        this.shareGetMoney = shareGetMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getViewStatus() {
        return viewStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setViewStatus(Byte viewStatus) {
        this.viewStatus = viewStatus;
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
    public Byte getShareReturn() {
        return shareReturn;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShareReturn(Byte shareReturn) {
        this.shareReturn = shareReturn;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getManagerReturn() {
        return managerReturn;
    }

    /**
     *
     * @mbggenerated
     */
    public void setManagerReturn(Byte managerReturn) {
        this.managerReturn = managerReturn;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTargetComplainFlag() {
        return targetComplainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTargetComplainFlag(Byte targetComplainFlag) {
        this.targetComplainFlag = targetComplainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getComplainFlag() {
        return complainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplainFlag(Byte complainFlag) {
        this.complainFlag = complainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareBorkerPurchase() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareBorkerPurchase(Integer shardCityId, Integer purchaseId) {
        super(shardCityId);
        this.purchaseId = purchaseId;
    }
}
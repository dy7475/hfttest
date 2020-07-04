package com.myfun.repository.fafundb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class FafunFafaDetailLog extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    自增id
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    用户序列
     */
    private Integer sId;

    /**
     *
     * @mbggenerated
    站点id
     */
    private Integer siteId;

    /**
     *
     * @mbggenerated
    操作类型 1:发布 2:删除/下架 4:刷新 5:下架重发 6:帐号验证&同步账号信息 7:扫描发布列表 8: 预约刷新 9: 同步房源 10:同步房源动态 11: 上传日志 12: 同步帐号信息 13: 检测账号相关信息
     */
    private Byte operType;

    /**
     *
     * @mbggenerated
    状态码 7位(从左边起第1位固定为1(发发)，第2、3位 为操作类型，后3位表示详细的发发状态码，最后一位是否正常（0正常，1不正常）)
     */
    private Integer statusId;

    /**
     *
     * @mbggenerated
    房屋id
     */
    private Integer houseId;

    /**
     *
     * @mbggenerated
    房屋类型
     */
    private Integer houseUseage;

    /**
     *
     * @mbggenerated
    出租出售
     */
    private Byte saleLease;

    /**
     *
     * @mbggenerated
    网站下架id
     */
    private String deleteId;

    /**
     *
     * @mbggenerated
    数据来源
     */
    private String houseFlag;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    城市id
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    提示信息
     */
    private String statusInfo;

    /**
     *
     * @mbggenerated
    片区
     */
    private Integer regId;

    /**
     *
     * @mbggenerated
    分组
     */
    private Integer grId;

    /**
     *
     * @mbggenerated
    门店
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    公司id
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    大区id
     */
    private Integer areaId;

    /**
     *
     * @mbggenerated
    用户id
     */
    private Integer userId;

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
    public Integer getsId() {
        return sId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSiteId() {
        return siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getOperType() {
        return operType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOperType(Byte operType) {
        this.operType = operType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getStatusId() {
        return statusId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getHouseUseage() {
        return houseUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSaleLease() {
        return saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSaleLease(Byte saleLease) {
        this.saleLease = saleLease;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDeleteId() {
        return deleteId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId == null ? null : deleteId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getHouseFlag() {
        return houseFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseFlag(String houseFlag) {
        this.houseFlag = houseFlag == null ? null : houseFlag.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    public String getStatusInfo() {
        return statusInfo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo == null ? null : statusInfo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getGrId() {
        return grId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGrId(Integer grId) {
        this.grId = grId;
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
    public Integer getAreaId() {
        return areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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
    public FafunFafaDetailLog() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public FafunFafaDetailLog(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}
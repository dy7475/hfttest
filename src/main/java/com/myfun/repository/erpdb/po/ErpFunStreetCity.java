package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunStreetCity extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键自增")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司ID")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "对应的街道地区表ID")
    private Integer streetTerritoryId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "对应的街道省份表ID")
    private Integer streetProvinceId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "对应的城市表ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市名称")
    private String cityName;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "唯一编码")
    private String code;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "排序")
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "描述")
    private String remark;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "编辑时间")
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否删除 0=没有删除 1=删除")
    private Byte isDel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "删除人用户ID")
    private Integer delUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "删除时间")
    private Date delTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键自增
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * 对应的街道地区表ID
     */
    public Integer getStreetTerritoryId() {
        return streetTerritoryId;
    }

    /**
     *
     * @mbggenerated
     * 对应的街道地区表ID
     */
    public void setStreetTerritoryId(Integer streetTerritoryId) {
        this.streetTerritoryId = streetTerritoryId;
    }

    /**
     *
     * @mbggenerated
     * 对应的街道省份表ID
     */
    public Integer getStreetProvinceId() {
        return streetProvinceId;
    }

    /**
     *
     * @mbggenerated
     * 对应的街道省份表ID
     */
    public void setStreetProvinceId(Integer streetProvinceId) {
        this.streetProvinceId = streetProvinceId;
    }

    /**
     *
     * @mbggenerated
     * 对应的城市表ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 对应的城市表ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @mbggenerated
     * 城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     * @mbggenerated
     * 唯一编码
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbggenerated
     * 唯一编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @mbggenerated
     * 排序
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     * 排序
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     * 编辑时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     * 编辑时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     * 是否删除 0=没有删除 1=删除
     */
    public Byte getIsDel() {
        return isDel;
    }

    /**
     *
     * @mbggenerated
     * 是否删除 0=没有删除 1=删除
     */
    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    /**
     *
     * @mbggenerated
     * 删除人用户ID
     */
    public Integer getDelUserId() {
        return delUserId;
    }

    /**
     *
     * @mbggenerated
     * 删除人用户ID
     */
    public void setDelUserId(Integer delUserId) {
        this.delUserId = delUserId;
    }

    /**
     *
     * @mbggenerated
     * 删除时间
     */
    public Date getDelTime() {
        return delTime;
    }

    /**
     *
     * @mbggenerated
     * 删除时间
     */
    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunStreetCity() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunStreetCity(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}
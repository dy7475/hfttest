package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpKpiRoleAssociateConfig extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "ID")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "配置ID")
    private Integer configId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "关联运用到人员档案ID")
    private String roleId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "配置类型：1.经纪人，2.行经，3.区经，4.区主")
    private Integer configType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否删除")
    private Integer isDel;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "修改时间")
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "状态：0.未生效,1.生效中")
    private Integer status;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * ID
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 配置ID
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     *
     * @mbggenerated
     * 配置ID
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * 关联运用到人员档案ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     *
     * @mbggenerated
     * 关联运用到人员档案ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     *
     * @mbggenerated
     * 配置类型：1.经纪人，2.行经，3.区经，4.区主
     */
    public Integer getConfigType() {
        return configType;
    }

    /**
     *
     * @mbggenerated
     * 配置类型：1.经纪人，2.行经，3.区经，4.区主
     */
    public void setConfigType(Integer configType) {
        this.configType = configType;
    }

    /**
     *
     * @mbggenerated
     * 是否删除
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     *
     * @mbggenerated
     * 是否删除
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     *
     * @mbggenerated
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     * 状态：0.未生效,1.生效中
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     * 状态：0.未生效,1.生效中
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpKpiRoleAssociateConfig() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpKpiRoleAssociateConfig(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}
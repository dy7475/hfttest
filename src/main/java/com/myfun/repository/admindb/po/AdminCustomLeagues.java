package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminCustomLeagues implements Serializable {
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
    @ApiModelProperty(value= "机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)")
    private Integer leaguesType;

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
    @ApiModelProperty(value= "公司编号")
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "admin库公司ID")
    private Integer adminCompId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "erp公司ID")
    private Integer erpCompId;

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
    @ApiModelProperty(value= "创建人")
    private Integer createUid;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司名称")
    private String compName;

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
     * 机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)
     */
    public Integer getLeaguesType() {
        return leaguesType;
    }

    /**
     *
     * @mbggenerated
     * 机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)
     */
    public void setLeaguesType(Integer leaguesType) {
        this.leaguesType = leaguesType;
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
     * admin库公司ID
     */
    public Integer getAdminCompId() {
        return adminCompId;
    }

    /**
     *
     * @mbggenerated
     * admin库公司ID
     */
    public void setAdminCompId(Integer adminCompId) {
        this.adminCompId = adminCompId;
    }

    /**
     *
     * @mbggenerated
     * erp公司ID
     */
    public Integer getErpCompId() {
        return erpCompId;
    }

    /**
     *
     * @mbggenerated
     * erp公司ID
     */
    public void setErpCompId(Integer erpCompId) {
        this.erpCompId = erpCompId;
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
     * 创建人
     */
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     *
     * @mbggenerated
     * 创建人
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     *
     * @mbggenerated
     * 公司名称
     */
    public String getCompName() {
        return compName;
    }

    /**
     *
     * @mbggenerated
     * 公司名称
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }
}
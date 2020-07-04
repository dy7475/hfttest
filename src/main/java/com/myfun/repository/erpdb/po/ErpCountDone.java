package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpCountDone extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "用户占地唯一标示")
    private Integer sId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "出租出售")
    private Byte saleLease;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源id")
    private Integer houseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房屋用途")
    private Integer houseUseage;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "状态（33：任务超时，93.正在发布，94.正在刷新，95正在下架，201发布成功,202刷新成功,203下架成功）")
    private Integer statuNow;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "网站id")
    private String siteHouseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "最后一次操作时间")
    private Date lastDoneTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "网站编辑id")
    private String editId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "网站下架id")
    private String deleteId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "cwc说已经弃用了 以前标记 同步数据与webHouse关联")
    private Short synrand;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市id")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司id")
    private Integer compId;

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
    @ApiModelProperty(value= "1发布、2下架、4刷新、5下架重发")
    private Byte actionOper;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "操作任务ID")
    private String taskId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 用户占地唯一标示
     */
    public Integer getsId() {
        return sId;
    }

    /**
     *
     * @mbggenerated
     * 用户占地唯一标示
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     *
     * @mbggenerated
     * 出租出售
     */
    public Byte getSaleLease() {
        return saleLease;
    }

    /**
     *
     * @mbggenerated
     * 出租出售
     */
    public void setSaleLease(Byte saleLease) {
        this.saleLease = saleLease;
    }

    /**
     *
     * @mbggenerated
     * 房源id
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     *
     * @mbggenerated
     * 房源id
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     *
     * @mbggenerated
     * 房屋用途
     */
    public Integer getHouseUseage() {
        return houseUseage;
    }

    /**
     *
     * @mbggenerated
     * 房屋用途
     */
    public void setHouseUseage(Integer houseUseage) {
        this.houseUseage = houseUseage;
    }

    /**
     *
     * @mbggenerated
     * 状态（33：任务超时，93.正在发布，94.正在刷新，95正在下架，201发布成功,202刷新成功,203下架成功）
     */
    public Integer getStatuNow() {
        return statuNow;
    }

    /**
     *
     * @mbggenerated
     * 状态（33：任务超时，93.正在发布，94.正在刷新，95正在下架，201发布成功,202刷新成功,203下架成功）
     */
    public void setStatuNow(Integer statuNow) {
        this.statuNow = statuNow;
    }

    /**
     *
     * @mbggenerated
     * 网站id
     */
    public String getSiteHouseId() {
        return siteHouseId;
    }

    /**
     *
     * @mbggenerated
     * 网站id
     */
    public void setSiteHouseId(String siteHouseId) {
        this.siteHouseId = siteHouseId;
    }

    /**
     *
     * @mbggenerated
     * 最后一次操作时间
     */
    public Date getLastDoneTime() {
        return lastDoneTime;
    }

    /**
     *
     * @mbggenerated
     * 最后一次操作时间
     */
    public void setLastDoneTime(Date lastDoneTime) {
        this.lastDoneTime = lastDoneTime;
    }

    /**
     *
     * @mbggenerated
     * 网站编辑id
     */
    public String getEditId() {
        return editId;
    }

    /**
     *
     * @mbggenerated
     * 网站编辑id
     */
    public void setEditId(String editId) {
        this.editId = editId;
    }

    /**
     *
     * @mbggenerated
     * 网站下架id
     */
    public String getDeleteId() {
        return deleteId;
    }

    /**
     *
     * @mbggenerated
     * 网站下架id
     */
    public void setDeleteId(String deleteId) {
        this.deleteId = deleteId;
    }

    /**
     *
     * @mbggenerated
     * cwc说已经弃用了 以前标记 同步数据与webHouse关联
     */
    public Short getSynrand() {
        return synrand;
    }

    /**
     *
     * @mbggenerated
     * cwc说已经弃用了 以前标记 同步数据与webHouse关联
     */
    public void setSynrand(Short synrand) {
        this.synrand = synrand;
    }

    /**
     *
     * @mbggenerated
     * 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 公司id
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司id
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
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
     * 1发布、2下架、4刷新、5下架重发
     */
    public Byte getActionOper() {
        return actionOper;
    }

    /**
     *
     * @mbggenerated
     * 1发布、2下架、4刷新、5下架重发
     */
    public void setActionOper(Byte actionOper) {
        this.actionOper = actionOper;
    }

    /**
     *
     * @mbggenerated
     * 操作任务ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     *
     * @mbggenerated
     * 操作任务ID
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCountDone() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCountDone(Integer shardCityId, Integer sId, Byte saleLease, Integer houseId, Integer houseUseage) {
        super(shardCityId);
        this.sId = sId;
        this.saleLease = saleLease;
        this.houseId = houseId;
        this.houseUseage = houseUseage;
    }
}
package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel
public class MessageBaseInfoListVo {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("城市ID")
    private Integer cityId;
    @ApiModelProperty("所属类型，1=ERP  //2=安卓，3=苹果，4=网站...")
    private Integer appType;
    @ApiModelProperty("消息接收人档案ID")
    private Integer archiveId;
    @ApiModelProperty("消息接收人电话")
    private String userMobile;
    @ApiModelProperty("消息对应的长连接ID")
    private String socketId;
    @ApiModelProperty("消息所属模块  1=房源，2=客源 ，3=城市公盘 4:需求中心")
    private Integer msgModule;
    @ApiModelProperty("消息所属模块的详细类型  1=强制写跟进 2=IP拨号")
    private Integer moduleType;
    @ApiModelProperty("房源ID")
    private Integer caseId;
    @ApiModelProperty("房源类型")
    private Integer caseType;
    @ApiModelProperty("房源用途 DD:HOUSE_USEAGE")
    private Byte houseUseage;
    @ApiModelProperty("消息内容")
    private String msgContent;
    @ApiModelProperty("是否删除 0=未删除 1=已删除")
    private Byte isDel;
    @ApiModelProperty("失效时间")
    private Date invalidTime;
    @ApiModelProperty("创建时间")
    private Date creationTime;
    @ApiModelProperty("房源NO")
    private String caseNo;
    @ApiModelProperty("操作人档案ID")
    private Integer createArchiveId;
    @ApiModelProperty("操作人名字")
    private String createUserName;
    @ApiModelProperty("目标ID，多个ID的时候的备份")
    private Integer targetId;
    @ApiModelProperty("ERP库公司ID，查询时只查询当前公司的，防止换公司后查到之前公司消息")
    private Integer compId;

    public Integer getId() {
     return id;
    }

    public void setId(Integer id) {
     this.id = id;
    }

    public Integer getCityId() {
     return cityId;
    }

    public void setCityId(Integer cityId) {
     this.cityId = cityId;
    }

    public Integer getAppType() {
     return appType;
    }

    public void setAppType(Integer appType) {
     this.appType = appType;
    }

    public Integer getArchiveId() {
     return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
     this.archiveId = archiveId;
    }

    public String getUserMobile() {
     return userMobile;
    }

    public void setUserMobile(String userMobile) {
     this.userMobile = userMobile;
    }

    public String getSocketId() {
     return socketId;
    }

    public void setSocketId(String socketId) {
     this.socketId = socketId;
    }

    public Integer getMsgModule() {
     return msgModule;
    }

    public void setMsgModule(Integer msgModule) {
     this.msgModule = msgModule;
    }

    public Integer getModuleType() {
     return moduleType;
    }

    public void setModuleType(Integer moduleType) {
     this.moduleType = moduleType;
    }

    public Integer getCaseId() {
     return caseId;
    }

    public void setCaseId(Integer caseId) {
     this.caseId = caseId;
    }

    public Integer getCaseType() {
     return caseType;
    }

    public void setCaseType(Integer caseType) {
     this.caseType = caseType;
    }

    public Byte getHouseUseage() {
     return houseUseage;
    }

    public void setHouseUseage(Byte houseUseage) {
     this.houseUseage = houseUseage;
    }

    public String getMsgContent() {
     return msgContent;
    }

    public void setMsgContent(String msgContent) {
     this.msgContent = msgContent;
    }

    public Byte getIsDel() {
     return isDel;
    }

    public void setIsDel(Byte isDel) {
     this.isDel = isDel;
    }

    public Date getInvalidTime() {
     return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
     this.invalidTime = invalidTime;
    }

    public Date getCreationTime() {
     return creationTime;
    }

    public void setCreationTime(Date creationTime) {
     this.creationTime = creationTime;
    }

    public String getCaseNo() {
     return caseNo;
    }

    public void setCaseNo(String caseNo) {
     this.caseNo = caseNo;
    }

    public Integer getCreateArchiveId() {
     return createArchiveId;
    }

    public void setCreateArchiveId(Integer createArchiveId) {
     this.createArchiveId = createArchiveId;
    }

    public String getCreateUserName() {
     return createUserName;
    }

    public void setCreateUserName(String createUserName) {
     this.createUserName = createUserName;
    }

    public Integer getTargetId() {
     return targetId;
    }

    public void setTargetId(Integer targetId) {
     this.targetId = targetId;
    }

    public Integer getCompId() {
     return compId;
    }

    public void setCompId(Integer compId) {
     this.compId = compId;
    }
}
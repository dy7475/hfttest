package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminCrmTask implements Serializable {
    /**
     *
     * @mbggenerated
    ID
     */
    private Integer taskId;

    /**
     *
     * @mbggenerated
    客户公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    部门ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    任务状态 ，0=初始化 1=已完成（新版弃用）
     */
    private Short taskStatus;

    /**
     *
     * @mbggenerated
    任务类型，0=提醒任务 1=审核任务 2=公告提醒 3=金融业务
     */
    private Short taskType;

    /**
     *
     * @mbggenerated
    任务主题
     */
    private String taskSubject;

    /**
     *
     * @mbggenerated
    任务内容
     */
    private String taskContent;

    /**
     *
     * @mbggenerated
    处理结果，0=否 1=是（新版弃用）
     */
    private Short dealResult;

    /**
     *
     * @mbggenerated
    处理意见（新版弃用）
     */
    private String dealDesc;

    /**
     *
     * @mbggenerated
    所属区域ID
     */
    private Integer crmCompId;

    /**
     *
     * @mbggenerated
    区域部门ID
     */
    private Integer crmDeptId;

    /**
     *
     * @mbggenerated
    任务接收目标userID（新版弃用，单独建表存）
     */
    private Integer taskOwner;

    /**
     *
     * @mbggenerated
    提醒时间（新版弃用）
     */
    private Date warmTime;

    /**
     *
     * @mbggenerated
    创建者
     */
    private Integer creatorUid;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    创建者名称
     */
    private String creatorName;

    /**
     *
     * @mbggenerated
    任务类型 DD:CRM_TASK_CLASS
     */
    private Byte taskClass;

    /**
     *
     * @mbggenerated
    是否已读 0=未读 1=已读(新版弃用)
     */
    private Byte isRead;

    /**
     *
     * @mbggenerated
    任务关联的经纪人信息
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    关联的经纪人挖掘信息ID
     */
    private Integer bvId;

    /**
     *
     * @mbggenerated
    是否属于弹窗 默认1=小秘书弹窗，2=在主页面加载，3=普通弹窗，4=主页菜单链接
     */
    private Byte isCpm;

    /**
     *
     * @mbggenerated
    弹窗连接
     */
    private String link;

    /**
     *
     * @mbggenerated
    弹窗连接参数 json格式数据
     */
    private String param;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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
    public Short getTaskStatus() {
        return taskStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getTaskType() {
        return taskType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskType(Short taskType) {
        this.taskType = taskType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTaskSubject() {
        return taskSubject;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskSubject(String taskSubject) {
        this.taskSubject = taskSubject;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTaskContent() {
        return taskContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getDealResult() {
        return dealResult;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealResult(Short dealResult) {
        this.dealResult = dealResult;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDealDesc() {
        return dealDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmCompId() {
        return crmCompId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmCompId(Integer crmCompId) {
        this.crmCompId = crmCompId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCrmDeptId() {
        return crmDeptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCrmDeptId(Integer crmDeptId) {
        this.crmDeptId = crmDeptId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTaskOwner() {
        return taskOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskOwner(Integer taskOwner) {
        this.taskOwner = taskOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWarmTime() {
        return warmTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWarmTime(Date warmTime) {
        this.warmTime = warmTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
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
    public String getCreatorName() {
        return creatorName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTaskClass() {
        return taskClass;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskClass(Byte taskClass) {
        this.taskClass = taskClass;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsRead() {
        return isRead;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsRead(Byte isRead) {
        this.isRead = isRead;
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
    public Integer getBvId() {
        return bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvId(Integer bvId) {
        this.bvId = bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsCpm() {
        return isCpm;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsCpm(Byte isCpm) {
        this.isCpm = isCpm;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @mbggenerated
     */
    public String getParam() {
        return param;
    }

    /**
     *
     * @mbggenerated
     */
    public void setParam(String param) {
        this.param = param;
    }
}
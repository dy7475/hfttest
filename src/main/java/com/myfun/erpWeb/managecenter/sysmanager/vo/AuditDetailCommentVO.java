package com.myfun.erpWeb.managecenter.sysmanager.vo;

import com.myfun.repository.erpdb.po.ErpAuditCommentFile;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author czq
 * @since 2019/7/8
 */
public class AuditDetailCommentVO {

    @ApiModelProperty("评论ID")
    private Integer commentId;
    @ApiModelProperty("评论者ID")
    private Integer userId;
    @ApiModelProperty("评论者grId  记录型数据，如果要实时组织的请前端自行取缓存")
    private Integer grId;
    @ApiModelProperty("评论者分组名称  记录型数据，如果要实时组织的请前端自行取缓存")
    private String grName;
    @ApiModelProperty("评论者门店ID  记录型数据，如果要实时组织的请前端自行取缓存")
    private Integer deptId;
    @ApiModelProperty("评论者门店名称  记录型数据，如果要实时组织的请前端自行取缓存")
    private String deptName;
    @ApiModelProperty("评论时间")
    private Date creationTime;
    @ApiModelProperty("评论内容")
    private String commentContent;
    @ApiModelProperty("评论文件")
    private List<ErpAuditCommentFile> fileList;

    @ApiModelProperty("头像地址")
    private String userPhoto;
    @ApiModelProperty("archiveId")
    private Integer archiveId;
    @ApiModelProperty("名字")
    private String userName;

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ErpAuditCommentFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<ErpAuditCommentFile> fileList) {
        this.fileList = fileList;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
package com.myfun.erpWeb.house.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2019/11/25 0025 下午 7:55
 **/
@ApiModel
public class EntrustFilesVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("附件ID")
    private Integer fileId;  
    @ApiModelProperty("文件路径 用于上传")
    private String filePath;
    @ApiModelProperty("文件类型 1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件 5=房屋说明书")
    private Byte fileType;
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId;
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件大小")
    private String fileSizeCn;
    @ApiModelProperty(value = "文件名称后缀")
    private String fileExt;
    @ApiModelProperty(value = "文件全路径 用于展示")
    private String filePathUrl;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Byte getFileType() {
        return fileType;
    }

    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }

    public Integer getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSizeCn() {
        return fileSizeCn;
    }

    public void setFileSizeCn(String fileSizeCn) {
        this.fileSizeCn = fileSizeCn;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFilePathUrl() {
        return filePathUrl;
    }

    public void setFilePathUrl(String filePathUrl) {
        this.filePathUrl = filePathUrl;
    }
}

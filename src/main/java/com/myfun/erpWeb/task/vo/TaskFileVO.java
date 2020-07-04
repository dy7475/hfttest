package com.myfun.erpWeb.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("附件")
public class TaskFileVO {
    @ApiModelProperty(value= "附件名")
    private String fileName;


    @ApiModelProperty(value= "附件地址")
    private String fileAddr;


    @ApiModelProperty(value= "附件大小")
    private String fileSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileAddr() {
        return fileAddr;
    }

    public void setFileAddr(String fileAddr) {
        this.fileAddr = fileAddr;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }
}

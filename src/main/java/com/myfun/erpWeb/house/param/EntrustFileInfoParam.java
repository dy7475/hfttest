package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author HuangJiang
 * @since 2019年11月25日 16:33:08
 * Modified XXX HuangJiang 2019年11月25日
 */
@ApiModel(description = "委托附件信息")
public class EntrustFileInfoParam implements EncryParamIfc {
    
    @ApiModelProperty(value = "委托附件ID（修改时要传）")
    private Integer fileId;
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    @ApiModelProperty(value = "文件大小")
    private String fileSizeCn;
    @ApiModelProperty(value = "文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件 5=房屋说明书")
    private Byte fileType;
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件后缀")
    private String fileExt;
    
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
    
    public String getFileSizeCn() {
        return fileSizeCn;
    }
    
    public void setFileSizeCn(String fileSizeCn) {
        this.fileSizeCn = fileSizeCn;
    }
    
    public Byte getFileType() {
        return fileType;
    }
    
    public void setFileType(Byte fileType) {
        this.fileType = fileType;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileExt() {
        return fileExt;
    }
    
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }
}

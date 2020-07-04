package com.myfun.erpWeb.managecenter.mlEntrustManage.vo;

import com.myfun.erpWeb.house.vo.EntrustCertificateVO;
import com.myfun.erpWeb.house.vo.EntrustFilesVO;
import com.myfun.erpWeb.house.vo.OwnerUserVO;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author HuangJiang
 * @since 2019年11月27日 15:05:14
 * Modified XXX HuangJiang 2019年11月27日
 */
public class EntrustAuditDetailVO implements EncryParamIfc {

    
    @ApiModelProperty(value = "委托ID")
    private Integer entrustId;
    @ApiModelProperty(value = "房源ID")
    private Integer caseId;
    @ApiModelProperty(value = "房源类型 1=出售 2=出租")
    private Byte caseType;
    @ApiModelProperty(value = "委托编号")
    private String entrustNo;
    @ApiModelProperty(value = "委托开始时间")
    private String entrustStart;
    @ApiModelProperty(value = "委托结束时间")
    private String entrustEnd;
    @ApiModelProperty(value="委托类型（1=普通；2=独家）")
    private Byte entrustType;

    private List<OwnerUserVO> ownerList;
    @ApiModelProperty(value = "产权信息")
    private List<EntrustCertificateVO> certificateList;
    @ApiModelProperty(value = "文件信息")
    private List<EntrustFilesVO> fileList;

    public Byte getEntrustType() {
        return entrustType;
    }

    public void setEntrustType(Byte entrustType) {
        this.entrustType = entrustType;
    }

    public Integer getEntrustId() {
        return entrustId;
    }
    
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }
    
    public Integer getCaseId() {
        return caseId;
    }
    
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }
    
    public Byte getCaseType() {
        return caseType;
    }
    
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }
    
    public String getEntrustNo() {
        return entrustNo;
    }
    
    public void setEntrustNo(String entrustNo) {
        this.entrustNo = entrustNo;
    }
    
    public String getEntrustStart() {
        return entrustStart;
    }
    
    public void setEntrustStart(String entrustStart) {
        this.entrustStart = entrustStart;
    }
    
    public String getEntrustEnd() {
        return entrustEnd;
    }
    
    public void setEntrustEnd(String entrustEnd) {
        this.entrustEnd = entrustEnd;
    }
    
    public List<OwnerUserVO> getOwnerList() {
        return ownerList;
    }
    
    public void setOwnerList(List<OwnerUserVO> ownerList) {
        this.ownerList = ownerList;
    }
    
    public List<EntrustCertificateVO> getCertificateList() {
        return certificateList;
    }
    
    public void setCertificateList(List<EntrustCertificateVO> certificateList) {
        this.certificateList = certificateList;
    }
    
    public List<EntrustFilesVO> getFileList() {
        return fileList;
    }
    
    public void setFileList(List<EntrustFilesVO> fileList) {
        this.fileList = fileList;
    }
}

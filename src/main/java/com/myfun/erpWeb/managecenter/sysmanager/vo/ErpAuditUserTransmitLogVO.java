package com.myfun.erpWeb.managecenter.sysmanager.vo;

import com.myfun.repository.erpdb.po.ErpAuditCommentFile;
import com.myfun.repository.erpdb.po.ErpAuditUserTransmitLog;

import java.util.List;

public class ErpAuditUserTransmitLogVO extends ErpAuditUserTransmitLog {
    
    private List<ErpAuditCommentFile> fileList;
    private String bbsPhoto;
    
    public List<ErpAuditCommentFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<ErpAuditCommentFile> fileList) {
        this.fileList = fileList;
    }

    public String getBbsPhoto() {
        return bbsPhoto;
    }

    public void setBbsPhoto(String bbsPhoto) {
        this.bbsPhoto = bbsPhoto;
    }
}

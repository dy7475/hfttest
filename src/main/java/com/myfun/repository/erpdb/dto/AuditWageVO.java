package com.myfun.repository.erpdb.dto;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Title 薪资参数
 * @Author lcb
 * @Date 2018/1/24
 * @Param
 **/
public class AuditWageVO implements EncryParamIfc {

	private Integer archiveId;
	private String month;
	private Integer userId;

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

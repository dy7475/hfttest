package com.myfun.erpWeb.house.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @Author 蔡春林
 * @Date 2019/11/25 0025 下午 4:59
 **/
@ApiModel
public class GetHistoryEntrustParam  implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "房源Id")
    @NotNull(message = "房源Id不能为null！")
    private Integer caseId;  
    @ApiModelProperty(value = "类型 1出售 2出租")
    @NotNull(message = "房源类型不能为null！")
    private Byte caseType;

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
}

package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/7
 */
public class StreetSectionListParam extends AbstractEncryParam {

    @ApiModelProperty(value = "查询什么范围下的数据 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区 ")
    private Byte dataRange;

    @ApiModelProperty(value = "查询范围的ID, 例如查找四川省下的街道商圈列表,传四川省的街道省份ID")
    private Integer dataId;

    @ApiModelProperty(value = "是否需要分页 0=不分页 1=分页")
    private Byte needPage;

    @ApiModelProperty(value = "模糊查询商圈名")
    private String sectionName;

    public Byte getDataRange() {
        return dataRange;
    }

    public void setDataRange(Byte dataRange) {
        this.dataRange = dataRange;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Byte getNeedPage() {
        return needPage;
    }

    public void setNeedPage(Byte needPage) {
        this.needPage = needPage;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author czq
 * @since 2020/2/6
 */
public class StreetDataListParam extends AbstractEncryParam {

    @ApiModelProperty(value = "查询什么范围下的数据 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区 5=街道商圈")
    private Byte dataRange;

    @ApiModelProperty(value = "查询范围的ID, 例如查找四川省下的街道列表, 传四川省的街道省份ID")
    private Integer dataId;

    @ApiModelProperty(value = "商圈ID", hidden = true)
    private List<Integer> sectionIds;

    @ApiModelProperty(value = "模糊查询街道名")
    private String streetName;
    @ApiModelProperty(value = "行政区ID", hidden = true)
    private Integer regId;
    @ApiModelProperty(value = "商圈ID", hidden = true)
    private Integer sectionId;
    
    public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

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

    public List<Integer> getSectionIds() {
        return sectionIds;
    }

    public void setSectionIds(List<Integer> sectionIds) {
        this.sectionIds = sectionIds;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
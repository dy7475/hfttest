package com.myfun.repository.agencydb.param;

import java.io.Serializable;

import com.myfun.repository.support.param.PageParam;

public class AgencyFunCompRealParam extends PageParam implements Serializable {
    /**
     * 城市Id
     */
    private Integer provinceId;

    /**
     * 公司名称
     */
    private String compName;


    /**
     *
     * 区域id
     */
    private Integer crmCompId;

    // 城市id
    private Integer cityId;
    
    /**
     * 时间特殊处理
     * 1:一周
     * 2:一月
     * 3:一季
     * 4:半年
     * 5:一年
     * **/
    private Integer dateType;
    
    private Integer source;
    
    private String startTime;
    private String endTime;
    
    private Integer developId;
    
    public Integer getDevelopId() {
		return developId;
	}

	public void setDevelopId(Integer developId) {
		this.developId = developId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	/**
     *
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     *
     */
    public String getCompName() {
        return compName;
    }

    /**
     *
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

	public Integer getCrmCompId() {
		return crmCompId;
	}

	public void setCrmCompId(Integer crmCompId) {
		this.crmCompId = crmCompId;
	}

   
}
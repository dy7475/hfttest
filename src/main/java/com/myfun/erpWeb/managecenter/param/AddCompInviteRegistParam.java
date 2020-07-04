package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddCompInviteRegistParam implements EncryParamIfc {

    @ApiModelProperty(value = "userMobile")
    private String userMobile;
    @ApiModelProperty(value = "deptId")
    private Integer deptId;
    @ApiModelProperty(value = "areaId")
    private Integer areaId;
    @ApiModelProperty(value = "regId")
    private Integer regId;
    @ApiModelProperty(value = "grId")
    private Integer grId;
    @ApiModelProperty(value = "管理范围")
    private String rangeIds;
    @ApiModelProperty(value = "管理层级")
    private Integer rangeType;
    @ApiModelProperty(value = "服务片区")
    private String serviceReg;
    @ApiModelProperty(value = "服务区域")
    private String serviceZone;
    @ApiModelProperty(value = "角色")
    private String userPosition;
    @ApiModelProperty(value = "性别")
    private Byte userSex;
    @ApiModelProperty(value = "服务区域ID")
    private String serviceZoneIds;
    @ApiModelProperty(value = "姓名")
    private String userName;
    @ApiModelProperty(value = "职级ID")
    private Integer roleLevelId;
    @ApiModelProperty(value = "团队管理人员")
    private Integer currentPId;
    @ApiModelProperty(value = "组织机构ID")
    private Integer organizationId;
    @ApiModelProperty(value = "城市id")
    private Integer cityId;
    @ApiModelProperty(value = "公司id")
    private Integer compId;
    @ApiModelProperty(value = "公司no")
    private String compNo;
    

    public Integer getCityId() {
	
		return cityId;
	}

	public void setCityId(Integer cityId) {
	
		this.cityId = cityId;
	}

	public Integer getCompId() {
	
		return compId;
	}

	public void setCompId(Integer compId) {
	
		this.compId = compId;
	}

	public String getCompNo() {
	
		return compNo;
	}

	public void setCompNo(String compNo) {
	
		this.compNo = compNo;
	}

	public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getCurrentPId() {
		return currentPId;
	}

	public void setCurrentPId(Integer currentPId) {
		this.currentPId = currentPId;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceZoneIds() {
        return serviceZoneIds;
    }

    public void setServiceZoneIds(String serviceZoneIds) {
        this.serviceZoneIds = serviceZoneIds;
    }

    public String getRangeIds() {
        return rangeIds;
    }

    public void setRangeIds(String rangeIds) {
        this.rangeIds = rangeIds;
    }

    public Integer getRangeType() {
        return rangeType;
    }

    public void setRangeType(Integer rangeType) {
        this.rangeType = rangeType;
    }

    public String getServiceReg() {
        return serviceReg;
    }

    public void setServiceReg(String serviceReg) {
        this.serviceReg = serviceReg;
    }

    public String getServiceZone() {
        return serviceZone;
    }

    public void setServiceZone(String serviceZone) {
        this.serviceZone = serviceZone;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
}

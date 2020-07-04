package com.myfun.repository.erpdb.dto;

import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class ErpBuildingInfoDto extends ErpBuildingInfo{

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("商圈名字")
	private String sectionName;
	@ApiModelProperty("行政区域名字")
	private String regName;
	@ApiModelProperty("照片地址")
	private String photoAddr;
	@ApiModelProperty("交通干道名称")
	private String roadsName;
	@ApiModelProperty("楼盘规定锁定")
	private Integer buildLock;
	@ApiModelProperty("首图地址")
	private String firstPicAddr;
	@ApiModelProperty("栋数")
	private Integer roofs;//
	@ApiModelProperty("单元数")
	private Integer units;
	@ApiModelProperty("户数")
	private Integer doors;
	@ApiModelProperty("是否进入修改页面")
	private Integer checkFlag;
	@ApiModelProperty("维护人id  逗号隔开")
	private String managerIds;
	@ApiModelProperty("在售数量")
	private Integer saleCount;
	@ApiModelProperty("在租数量")
	private Integer leaseCount;
	@ApiModelProperty("内成交数量")
	private Integer innerDealCount;
	@ApiModelProperty("外成交数量")
	private Integer outerDealCount;

	private List<ErpBuildingPhoto> buildPhotoList;

	public List<ErpBuildingPhoto> getBuildPhotoList() {
		return buildPhotoList;
	}

	public void setBuildPhotoList(List<ErpBuildingPhoto> buildPhotoList) {
		this.buildPhotoList = buildPhotoList;
	}

	public Integer getRoofs() {
		return roofs;
	}

	public void setRoofs(Integer roofs) {
		this.roofs = roofs;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public Integer getDoors() {
		return doors;
	}

	public void setDoors(Integer doors) {
		this.doors = doors;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getFirstPicAddr() {
		return firstPicAddr;
	}

	public void setFirstPicAddr(String firstPicAddr) {
		this.firstPicAddr = firstPicAddr;
	}

	public Integer getBuildLock() {
		return buildLock;
	}

	public void setBuildLock(Integer buildLock) {
		this.buildLock = buildLock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRoadsName() {
		return roadsName;
	}

	public void setRoadsName(String roadsName) {
		this.roadsName = roadsName;
	}

	public String getPhotoAddr() {
		return photoAddr;
	}
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getManagerIds() {
		return managerIds;
	}

	public void setManagerIds(String managerIds) {
		this.managerIds = managerIds;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Integer getLeaseCount() {
		return leaseCount;
	}

	public void setLeaseCount(Integer leaseCount) {
		this.leaseCount = leaseCount;
	}

	public Integer getInnerDealCount() {
		return innerDealCount;
	}

	public void setInnerDealCount(Integer innerDealCount) {
		this.innerDealCount = innerDealCount;
	}

	public Integer getOuterDealCount() {
		return outerDealCount;
	}

	public void setOuterDealCount(Integer outerDealCount) {
		this.outerDealCount = outerDealCount;
	}
}

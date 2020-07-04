package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CaseFavoriteParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "公司ID")
	private Integer compId;//公司ID
	@ApiModelProperty(value = "收藏时间")
	private String creationTime;//收藏时间
	@ApiModelProperty(value = "收藏人")
	private Integer favoriteUid;//收藏人
	@ApiModelProperty(value = "收藏状态 1收藏中")
	private Byte favoriteStatus;//收藏状态 1收藏中
	@ApiModelProperty(value = "房客源类型")
	private Byte caseType;//房客源类型
	@ApiModelProperty(value = "房客源id")
	private Integer caseId;//房客源id
	@ApiModelProperty(value = "房客源编号")
	private String caseNo;//房客源编号
	@ApiModelProperty(value = "主键")
	private Integer favoriteId;//主键
	@ApiModelProperty(value = "切库标识")
	private Integer cityId;//切库标识

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

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getFavoriteUid() {
		return favoriteUid;
	}

	public void setFavoriteUid(Integer favoriteUid) {
		this.favoriteUid = favoriteUid;
	}

	public Byte getFavoriteStatus() {
		return favoriteStatus;
	}

	public void setFavoriteStatus(Byte favoriteStatus) {
		this.favoriteStatus = favoriteStatus;
	}

	public Byte getCaseType() {
		return caseType;
	}

	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}
}

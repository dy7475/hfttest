package com.myfun.erpWeb.bulletin.vo;

import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.dto.AdminBulletReplyDto;
import com.myfun.repository.admindb.dto.AdminBulletinPsDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取帖子详情VO")
public class BulletinInfoVo implements Serializable {
	@ApiModelProperty("帖子状态")
	private Integer bulletinStatus;
	@ApiModelProperty("")
	private String allowCityBbs;
	@ApiModelProperty("帖子回复列表")
	private List<AdminBulletReplyDto> replayList;
	@ApiModelProperty("帖子状态")
	private Long pageRows;
	@ApiModelProperty("帖子信息")
	private AdminBulletDto bulletinInfo;
	@ApiModelProperty("范围， 0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报")
	private Byte bulletBound;
	@ApiModelProperty("客户端")
	private String clientKey;
	@ApiModelProperty("帖子Id")
	private Integer bulletId;
	@ApiModelProperty("")
	private Integer addCommunicInfo;
	@ApiModelProperty("帖子附件列表")
	private List<AdminBulletinPsDto> bulletinPsPOs;

	public Integer getBulletinStatus() {
		return bulletinStatus;
	}

	public void setBulletinStatus(Integer bulletinStatus) {
		this.bulletinStatus = bulletinStatus;
	}

	public List<AdminBulletReplyDto> getReplayList() {
		return replayList;
	}

	public void setReplayList(List<AdminBulletReplyDto> replayList) {
		this.replayList = replayList;
	}

	public Long getPageRows() {
		return pageRows;
	}

	public void setPageRows(Long pageRows) {
		this.pageRows = pageRows;
	}

	public AdminBulletDto getBulletinInfo() {
		return bulletinInfo;
	}

	public void setBulletinInfo(AdminBulletDto bulletinInfo) {
		this.bulletinInfo = bulletinInfo;
	}

	public Byte getBulletBound() {
		return bulletBound;
	}

	public void setBulletBound(Byte bulletBound) {
		this.bulletBound = bulletBound;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public Integer getBulletId() {
		return bulletId;
	}

	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}

	public Integer getAddCommunicInfo() {
		return addCommunicInfo;
	}

	public void setAddCommunicInfo(Integer addCommunicInfo) {
		this.addCommunicInfo = addCommunicInfo;
	}

	public List<AdminBulletinPsDto> getBulletinPsPOs() {
		return bulletinPsPOs;
	}

	public void setBulletinPsPOs(List<AdminBulletinPsDto> bulletinPsPOs) {
		this.bulletinPsPOs = bulletinPsPOs;
	}

	public String getAllowCityBbs() {
		return allowCityBbs;
	}

	public void setAllowCityBbs(String allowCityBbs) {
		this.allowCityBbs = allowCityBbs;
	}
}

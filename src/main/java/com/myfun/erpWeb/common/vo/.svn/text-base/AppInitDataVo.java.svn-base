package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.po.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("登陆初始化参数")
public class AppInitDataVo {

	@ApiModelProperty(value = "区域 新版组织机构（ORGANIZATION_TYPE=1）这个数据取消了")
	private List<ErpFunRegVo> region;
	@ApiModelProperty(value = "板块")
	private List<ErpFunSectionVo> section;
	@ApiModelProperty(value = "角色")
	private List<ErpCompRoles> mgrAllRoleList;
	@ApiModelProperty(value = "字典")
	private List<ErpDicDefinitionsVo> DDinfoList;
	@ApiModelProperty(value = "房客表头")
	private List<ErpFunHeadVo> funAndCustHeadList;
	@ApiModelProperty(value = "房源标签")
	private List<AdminFunTagsVo> houseTags;
	@ApiModelProperty(value = "跟进标签")
	private List<AdminTrackTagVo> trackTags;
	@ApiModelProperty(value = "跟进常用")
	private List<AdminTrackCommonLanguageVo> trackCommonLanguage;
	@ApiModelProperty("所有地铁线路")
	private List<SubwayVO> subwayList;
	@ApiModelProperty("所有地铁站点")
	private List<StationVO> stationList;

	public List<SubwayVO> getSubwayList() {
		return subwayList;
	}

	public void setSubwayList(List<SubwayVO> subwayList) {
		this.subwayList = subwayList;
	}

	public List<StationVO> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationVO> stationList) {
		this.stationList = stationList;
	}

	public List<ErpFunRegVo> getRegion() {
		return region;
	}

	public void setRegion(List<ErpFunRegVo> region) {
		this.region = region;
	}

	public List<ErpFunSectionVo> getSection() {
		return section;
	}

	public void setSection(List<ErpFunSectionVo> section) {
		this.section = section;
	}

	public List<ErpCompRoles> getMgrAllRoleList() {
		return mgrAllRoleList;
	}

	public void setMgrAllRoleList(List<ErpCompRoles> mgrAllRoleList) {
		this.mgrAllRoleList = mgrAllRoleList;
	}

	public List<ErpDicDefinitionsVo> getDDinfoList() {
		return DDinfoList;
	}

	public void setDDinfoList(List<ErpDicDefinitionsVo> DDinfoList) {
		this.DDinfoList = DDinfoList;
	}

	public List<ErpFunHeadVo> getFunAndCustHeadList() {
		return funAndCustHeadList;
	}

	public void setFunAndCustHeadList(List<ErpFunHeadVo> funAndCustHeadList) {
		this.funAndCustHeadList = funAndCustHeadList;
	}

	public List<AdminFunTagsVo> getHouseTags() {
		return houseTags;
	}

	public void setHouseTags(List<AdminFunTagsVo> houseTags) {
		this.houseTags = houseTags;
	}

	public List<AdminTrackTagVo> getTrackTags() {
		return trackTags;
	}

	public void setTrackTags(List<AdminTrackTagVo> trackTags) {
		this.trackTags = trackTags;
	}

	public List<AdminTrackCommonLanguageVo> getTrackCommonLanguage() {
		return trackCommonLanguage;
	}

	public void setTrackCommonLanguage(List<AdminTrackCommonLanguageVo> trackCommonLanguage) {
		this.trackCommonLanguage = trackCommonLanguage;
	}
}

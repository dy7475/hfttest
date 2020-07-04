package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经纪人升降情况数据统计
 * @Package com.myfun.erpWeb.managecenter.profit.vo 
 * @author 陈文超   
 * @date 2019年8月29日 下午3:57:58
 */
@ApiModel
public class FluctuantDetailVo implements Serializable {
	
	@ApiModelProperty("用户头像url")
    private String userPhotoUrl;
	
	@ApiModelProperty("用户姓名")
    private String userName;
	
	@ApiModelProperty("角色名称-房基地版中叫：职级名称")
    private String roleName;
	
	@ApiModelProperty("个人业绩数据")
    private BigDecimal personProfit = BigDecimal.ZERO;
	
	@ApiModelProperty("个人业绩目标")
    private BigDecimal personProfitAim = BigDecimal.ZERO;
	
	@ApiModelProperty("团队业绩数据")
    private BigDecimal teamProfit = BigDecimal.ZERO;
	
	@ApiModelProperty("团队业绩目标")
    private BigDecimal teamProfitAim = BigDecimal.ZERO;
	
	@ApiModelProperty("团队人数")
    private Integer teamPeople;
	
	@ApiModelProperty("团队人数目标")
    private Integer teamPeopleAim = 0;
	
	@ApiModelProperty("提示文案，例如：个人业绩还差xx元就可升级到xx了")
    private String getToAimTip;

	@ApiModelProperty("是否开启自动升级 0否 1.是")
    private Integer uOpernFalg;

	@ApiModelProperty("个人业绩是否展示 0否 1.是")
    private Byte personProfitShow;

	@ApiModelProperty("团队业绩是否展示 0否 1.是")
    private Byte teamProfitShow;

	@ApiModelProperty("团队人数是否展示 0否 1.是")
    private Byte teamPeopleShow;

	public Byte getPersonProfitShow() {
		return personProfitShow;
	}

	public void setPersonProfitShow(Byte personProfitShow) {
		this.personProfitShow = personProfitShow;
	}

	public Byte getTeamProfitShow() {
		return teamProfitShow;
	}

	public void setTeamProfitShow(Byte teamProfitShow) {
		this.teamProfitShow = teamProfitShow;
	}

	public Byte getTeamPeopleShow() {
		return teamPeopleShow;
	}

	public void setTeamPeopleShow(Byte teamPeopleShow) {
		this.teamPeopleShow = teamPeopleShow;
	}

	public Integer getuOpernFalg() {
		return uOpernFalg;
	}

	public void setuOpernFalg(Integer uOpernFalg) {
		this.uOpernFalg = uOpernFalg;
	}

	public BigDecimal getPersonProfit() {
		return personProfit;
	}

	public void setPersonProfit(BigDecimal personProfit) {
		this.personProfit = personProfit;
	}

	public BigDecimal getPersonProfitAim() {
		return personProfitAim;
	}

	public void setPersonProfitAim(BigDecimal personProfitAim) {
		this.personProfitAim = personProfitAim;
	}

	public BigDecimal getTeamProfit() {
		return teamProfit;
	}

	public void setTeamProfit(BigDecimal teamProfit) {
		this.teamProfit = teamProfit;
	}

	public BigDecimal getTeamProfitAim() {
		return teamProfitAim;
	}

	public void setTeamProfitAim(BigDecimal teamProfitAim) {
		this.teamProfitAim = teamProfitAim;
	}

	public Integer getTeamPeople() {
		return teamPeople;
	}

	public void setTeamPeople(Integer teamPeople) {
		this.teamPeople = teamPeople;
	}

	public Integer getTeamPeopleAim() {
		return teamPeopleAim;
	}

	public void setTeamPeopleAim(Integer teamPeopleAim) {
		this.teamPeopleAim = teamPeopleAim;
	}

	public String getGetToAimTip() {
		return getToAimTip;
	}

	public void setGetToAimTip(String getToAimTip) {
		this.getToAimTip = getToAimTip;
	}

	public String getUserPhotoUrl() {
		return userPhotoUrl;
	}

	public void setUserPhotoUrl(String userPhotoUrl) {
		this.userPhotoUrl = userPhotoUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}

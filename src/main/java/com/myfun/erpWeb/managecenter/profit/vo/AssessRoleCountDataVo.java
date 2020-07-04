package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 职级升降级考核数据
 * @Package com.myfun.erpWeb.managecenter.profit.vo 
 * @author 陈文超   
 * @date 2019年8月30日 下午4:31:25
 */
@ApiModel
public class AssessRoleCountDataVo implements Serializable {
	 
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("用户ID，用于计算直接和间接业绩")
    private Integer userId;
	
	@ApiModelProperty("用户档案ID，用于计算个人业绩")
	private Integer archiveId;
	
	@ApiModelProperty("用户姓名")
    private String userName;
	
	@ApiModelProperty("角色ID")
    private String roleId;
	
	@ApiModelProperty("角色名称-房基地的项目中叫：职级，注意与标准版的职级区分")
    private String roleName;
	
	@ApiModelProperty("推荐人userId")
	private Integer recommendUserId;
	
	@ApiModelProperty("推荐人姓名")
	private String recommendUserName;
	
	@ApiModelProperty("注册时间")
	private String registerDate;
	
	
	@ApiModelProperty("晋升情况-个人入账实收-目标")
	private BigDecimal incomeAim;
	
	@ApiModelProperty("晋升情况-个人入账实收-达成")
	private BigDecimal incomeReach;
	
	@ApiModelProperty("晋升情况-个人入账实收-差距")
	private BigDecimal incomeGap;
	
	
	@ApiModelProperty("晋升情况-团队入账实收-目标")
	private BigDecimal teamIncomeAim;
	
	@ApiModelProperty("晋升情况-团队入账实收-达成")
	private BigDecimal teamIncomeReach;
	
	@ApiModelProperty("晋升情况-团队入账实收-差距")
	private BigDecimal teamIncomeGap;
	
	
	@ApiModelProperty("晋升情况-人数-目标")
	private Integer teamPeopleAim;
	
	@ApiModelProperty("晋升情况-人数-达成")
	private Integer teamPeopleReach;
	
	@ApiModelProperty("晋升情况-人数-差距")
	private Integer teamPeopleGap;
	
	
	@ApiModelProperty("降级情况-个人入账实收-保级标准")
	private BigDecimal incomeAimDemotion;
	
	@ApiModelProperty("降级情况-个人入账实收-当前情况")
	private BigDecimal incomeReachDemotion;
	
	
	@ApiModelProperty("降级情况-团队入账实收-保级标准")
	private BigDecimal teamIncomeAimDemotion;
	
	@ApiModelProperty("降级情况-团队入账实收-当前情况")
	private BigDecimal teamIncomeReachDemotion;
	
	
	@ApiModelProperty("降级情况-人数-保级标准")
	private Integer teamPeopleAimDemotion;
	
	@ApiModelProperty("降级情况-人数-当前情况")
	private Integer teamPeopleReachDemotion;
	
	@ApiModelProperty("升降级结果，例：小掌柜")
	private String roleResultStr;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRecommendUserId() {
		return recommendUserId;
	}

	public void setRecommendUserId(Integer recommendUserId) {
		this.recommendUserId = recommendUserId;
	}

	public String getRecommendUserName() {
		return recommendUserName;
	}

	public void setRecommendUserName(String recommendUserName) {
		this.recommendUserName = recommendUserName;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public BigDecimal getIncomeAim() {
		return incomeAim;
	}

	public void setIncomeAim(BigDecimal incomeAim) {
		this.incomeAim = incomeAim;
	}

	public BigDecimal getIncomeReach() {
		return incomeReach;
	}

	public void setIncomeReach(BigDecimal incomeReach) {
		this.incomeReach = incomeReach;
	}

	public BigDecimal getIncomeGap() {
		return incomeGap;
	}

	public void setIncomeGap(BigDecimal incomeGap) {
		this.incomeGap = incomeGap;
	}

	public BigDecimal getTeamIncomeAim() {
		return teamIncomeAim;
	}

	public void setTeamIncomeAim(BigDecimal teamIncomeAim) {
		this.teamIncomeAim = teamIncomeAim;
	}

	public BigDecimal getTeamIncomeReach() {
		return teamIncomeReach;
	}

	public void setTeamIncomeReach(BigDecimal teamIncomeReach) {
		this.teamIncomeReach = teamIncomeReach;
	}

	public BigDecimal getTeamIncomeGap() {
		return teamIncomeGap;
	}

	public void setTeamIncomeGap(BigDecimal teamIncomeGap) {
		this.teamIncomeGap = teamIncomeGap;
	}

	public Integer getTeamPeopleAim() {
		return teamPeopleAim;
	}

	public void setTeamPeopleAim(Integer teamPeopleAim) {
		this.teamPeopleAim = teamPeopleAim;
	}

	public Integer getTeamPeopleReach() {
		return teamPeopleReach;
	}

	public void setTeamPeopleReach(Integer teamPeopleReach) {
		this.teamPeopleReach = teamPeopleReach;
	}

	public Integer getTeamPeopleGap() {
		return teamPeopleGap;
	}

	public void setTeamPeopleGap(Integer teamPeopleGap) {
		this.teamPeopleGap = teamPeopleGap;
	}

	public BigDecimal getIncomeAimDemotion() {
		return incomeAimDemotion;
	}

	public void setIncomeAimDemotion(BigDecimal incomeAimDemotion) {
		this.incomeAimDemotion = incomeAimDemotion;
	}

	public BigDecimal getIncomeReachDemotion() {
		return incomeReachDemotion;
	}

	public void setIncomeReachDemotion(BigDecimal incomeReachDemotion) {
		this.incomeReachDemotion = incomeReachDemotion;
	}

	public BigDecimal getTeamIncomeAimDemotion() {
		return teamIncomeAimDemotion;
	}

	public void setTeamIncomeAimDemotion(BigDecimal teamIncomeAimDemotion) {
		this.teamIncomeAimDemotion = teamIncomeAimDemotion;
	}

	public BigDecimal getTeamIncomeReachDemotion() {
		return teamIncomeReachDemotion;
	}

	public void setTeamIncomeReachDemotion(BigDecimal teamIncomeReachDemotion) {
		this.teamIncomeReachDemotion = teamIncomeReachDemotion;
	}

	public Integer getTeamPeopleAimDemotion() {
		return teamPeopleAimDemotion;
	}

	public void setTeamPeopleAimDemotion(Integer teamPeopleAimDemotion) {
		this.teamPeopleAimDemotion = teamPeopleAimDemotion;
	}

	public Integer getTeamPeopleReachDemotion() {
		return teamPeopleReachDemotion;
	}

	public void setTeamPeopleReachDemotion(Integer teamPeopleReachDemotion) {
		this.teamPeopleReachDemotion = teamPeopleReachDemotion;
	}

	public String getRoleResultStr() {
		return roleResultStr;
	}

	public void setRoleResultStr(String roleResultStr) {
		this.roleResultStr = roleResultStr;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
}

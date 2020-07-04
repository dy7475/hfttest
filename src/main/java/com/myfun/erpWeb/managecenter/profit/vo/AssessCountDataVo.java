package com.myfun.erpWeb.managecenter.profit.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 考核数据统计
 * @Package com.myfun.erpWeb.managecenter.profit.vo 
 * @author 陈文超   
 * @date 2019年8月28日 下午9:04:32
 */
@ApiModel
public class AssessCountDataVo implements Serializable {
	
	@ApiModelProperty("用户ID，用于计算直接和间接业绩")
    private Integer userId;
	
	@ApiModelProperty("用户档案ID，计算个人业绩时使用")
    private Integer archiveId;
	
	@ApiModelProperty("用户姓名")
    private String userName;
	
	@ApiModelProperty("角色ID")
    private String roleId;
	
	@ApiModelProperty("角色名称-房基地的项目中叫：职级，注意与标准版的职级区分")
    private String roleName;
	
	@ApiModelProperty("推荐人userId")
	private Integer recommendUserId;
	
	@ApiModelProperty("推荐人userId")
	private String recommendUserName;
	
	@ApiModelProperty("个人提成-应收业绩")
	private BigDecimal theoryProfit = BigDecimal.ZERO;
	
	@ApiModelProperty("个人提成-入账实收")
	private BigDecimal enterPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("个人提成-结盘实收")
	private BigDecimal overPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("个人提成-应发提成")
	private BigDecimal theoryBonus = BigDecimal.ZERO;
	
	@ApiModelProperty("个人提成-实发提成")
	private BigDecimal practicalBonus = BigDecimal.ZERO;
	
	
	@ApiModelProperty("直接培育-应收业绩")
	private BigDecimal directTheoryProfit = BigDecimal.ZERO;
	
	@ApiModelProperty("直接培育-入账实收")
	private BigDecimal directEnterPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("直接培育-结盘实收")
	private BigDecimal directOverPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("直接培育-应发提成")
	private BigDecimal directTheoryBonus = BigDecimal.ZERO;
	
	@ApiModelProperty("直接培育-实发提成")
	private BigDecimal directPracticalBonus = BigDecimal.ZERO;
	
	
	@ApiModelProperty("间接培育-应收业绩")
	private BigDecimal indirectTheoryProfit = BigDecimal.ZERO;
	
	@ApiModelProperty("间接培育-入账实收")
	private BigDecimal indirectEnterPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("间接培育-结盘实收")
	private BigDecimal indirectOverPaid = BigDecimal.ZERO;
	
	@ApiModelProperty("间接培育-应发提成")
	private BigDecimal indirectTheoryBonus = BigDecimal.ZERO;
	
	@ApiModelProperty("间接培育-实发提成")
	private BigDecimal indirectPracticalBonus = BigDecimal.ZERO;
	
	
	@ApiModelProperty("提成合计-应发")
	private BigDecimal sumTheoryBonus = BigDecimal.ZERO;
	
	@ApiModelProperty("提成合计-实发")
	private BigDecimal sumPracticalBonus = BigDecimal.ZERO;

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

	public BigDecimal getTheoryProfit() {
		return theoryProfit;
	}

	public void setTheoryProfit(BigDecimal theoryProfit) {
		this.theoryProfit = theoryProfit;
	}

	public BigDecimal getEnterPaid() {
		return enterPaid;
	}

	public void setEnterPaid(BigDecimal enterPaid) {
		this.enterPaid = enterPaid;
	}

	public BigDecimal getOverPaid() {
		return overPaid;
	}

	public void setOverPaid(BigDecimal overPaid) {
		this.overPaid = overPaid;
	}

	public BigDecimal getTheoryBonus() {
		return theoryBonus;
	}

	public void setTheoryBonus(BigDecimal theoryBonus) {
		this.theoryBonus = theoryBonus;
	}

	public BigDecimal getPracticalBonus() {
		return practicalBonus;
	}

	public void setPracticalBonus(BigDecimal practicalBonus) {
		this.practicalBonus = practicalBonus;
	}

	public BigDecimal getDirectTheoryProfit() {
		return directTheoryProfit;
	}

	public void setDirectTheoryProfit(BigDecimal directTheoryProfit) {
		this.directTheoryProfit = directTheoryProfit;
	}

	public BigDecimal getDirectEnterPaid() {
		return directEnterPaid;
	}

	public void setDirectEnterPaid(BigDecimal directEnterPaid) {
		this.directEnterPaid = directEnterPaid;
	}

	public BigDecimal getDirectOverPaid() {
		return directOverPaid;
	}

	public void setDirectOverPaid(BigDecimal directOverPaid) {
		this.directOverPaid = directOverPaid;
	}

	public BigDecimal getDirectTheoryBonus() {
		return directTheoryBonus;
	}

	public void setDirectTheoryBonus(BigDecimal directTheoryBonus) {
		this.directTheoryBonus = directTheoryBonus;
	}

	public BigDecimal getDirectPracticalBonus() {
		return directPracticalBonus;
	}

	public void setDirectPracticalBonus(BigDecimal directPracticalBonus) {
		this.directPracticalBonus = directPracticalBonus;
	}

	public BigDecimal getIndirectTheoryProfit() {
		return indirectTheoryProfit;
	}

	public void setIndirectTheoryProfit(BigDecimal indirectTheoryProfit) {
		this.indirectTheoryProfit = indirectTheoryProfit;
	}

	public BigDecimal getIndirectEnterPaid() {
		return indirectEnterPaid;
	}

	public void setIndirectEnterPaid(BigDecimal indirectEnterPaid) {
		this.indirectEnterPaid = indirectEnterPaid;
	}

	public BigDecimal getIndirectOverPaid() {
		return indirectOverPaid;
	}

	public void setIndirectOverPaid(BigDecimal indirectOverPaid) {
		this.indirectOverPaid = indirectOverPaid;
	}

	public BigDecimal getIndirectTheoryBonus() {
		return indirectTheoryBonus;
	}

	public void setIndirectTheoryBonus(BigDecimal indirectTheoryBonus) {
		this.indirectTheoryBonus = indirectTheoryBonus;
	}

	public BigDecimal getIndirectPracticalBonus() {
		return indirectPracticalBonus;
	}

	public void setIndirectPracticalBonus(BigDecimal indirectPracticalBonus) {
		this.indirectPracticalBonus = indirectPracticalBonus;
	}

	public BigDecimal getSumTheoryBonus() {
		return sumTheoryBonus;
	}

	public void setSumTheoryBonus(BigDecimal sumTheoryBonus) {
		this.sumTheoryBonus = sumTheoryBonus;
	}

	public BigDecimal getSumPracticalBonus() {
		return sumPracticalBonus;
	}

	public void setSumPracticalBonus(BigDecimal sumPracticalBonus) {
		this.sumPracticalBonus = sumPracticalBonus;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
}

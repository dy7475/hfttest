package com.myfun.repository.admindb.dto;

import java.util.List;

import com.myfun.repository.admindb.po.AdminBullet;
import com.myfun.repository.admindb.po.AdminBulletWithBLOBs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AdminBulletDto extends AdminBulletWithBLOBs{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("")
	private String userName;
	@ApiModelProperty("")
	private String deptName;
	@ApiModelProperty("")
	private String nickName;
	@ApiModelProperty("")
	private String bbsPhoto;
	@ApiModelProperty("")
	private String userPhotoMin;
	@ApiModelProperty("")
	private Integer userRight;
	@ApiModelProperty("")
	private String superUser;
	@ApiModelProperty("")
	private String superEnd;
	@ApiModelProperty("")
	private Integer score;
	@ApiModelProperty("")
	private String userMobile;
	@ApiModelProperty("")
	private Integer prohibitSpeak = 0;
	@ApiModelProperty("")
	private Integer crmBulletTop = 0;
	@ApiModelProperty("")
	private Integer bulletManage = 0;
	@ApiModelProperty("")
	private Integer webShow = 0;
	@ApiModelProperty("")
	private Integer isSuperComp;
	@ApiModelProperty("")
	private Integer isVoted = 1;
	@ApiModelProperty("选择项")
	private String votedOption; // 选择项
	@ApiModelProperty("投票内容")
	private String voteContentStr; // 投票内容
	@ApiModelProperty("")
	private Integer voteType;
	@ApiModelProperty("")
	private Integer userScore;
	@ApiModelProperty("")
	private String bbsName;
	@ApiModelProperty("")
	private String realPhoto;
	@ApiModelProperty("")
	private Integer canEdit;
	@ApiModelProperty("")
	private Integer canDelete;
	@ApiModelProperty("")
	private Integer canAddStick;
	@ApiModelProperty("已读量统计")
	private Integer readViewCount;//已读
	@ApiModelProperty("未读量统计")
	private Integer unReadViewCount;//未读
	@ApiModelProperty("自己是否已读 0=未读 1=已读")
	private Integer selfViewStatus;//自己是否已读  0 未读 1 已读

	public Integer getSelfViewStatus() {
		return selfViewStatus;
	}

	public void setSelfViewStatus(Integer selfViewStatus) {
		this.selfViewStatus = selfViewStatus;
	}

	public Integer getReadViewCount() {
		return readViewCount;
	}

	public void setReadViewCount(Integer readViewCount) {
		this.readViewCount = readViewCount;
	}

	public Integer getUnReadViewCount() {
		return unReadViewCount;
	}

	public void setUnReadViewCount(Integer unReadViewCount) {
		this.unReadViewCount = unReadViewCount;
	}

	public String getVoteContentStr() {
		return voteContentStr;
	}

	public void setVoteContentStr(String voteContentStr) {
		this.voteContentStr = voteContentStr;
	}

	public Integer getVoteType() {
		return voteType;
	}

	public void setVoteType(Integer voteType) {
		this.voteType = voteType;
	}

	private List<AdminVoteDto> voteList ;
	
	private List<AdminBulletReplyDto> replyList;
	
	public List<AdminBulletReplyDto> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<AdminBulletReplyDto> replyList) {
		this.replyList = replyList;
	}

	public String getVotedOption() {
		return votedOption;
	}

	public void setVotedOption(String votedOption) {
		this.votedOption = votedOption;
	}
	
	public Integer getIsVoted() {
		return isVoted;
	}

	public void setIsVoted(Integer isVoted) {
		this.isVoted = isVoted;
	}

	public List<AdminVoteDto> getVoteList() {
		return voteList;
	}

	public void setVoteList(List<AdminVoteDto> voteList) {
		this.voteList = voteList;
	}

	public Integer getIsSuperComp() {
		return isSuperComp;
	}

	public void setIsSuperComp(Integer isSuperComp) {
		this.isSuperComp = isSuperComp;
	}

	public Integer getWebShow() {
		return webShow;
	}

	public void setWebShow(Integer webShow) {
		this.webShow = webShow;
	}

	public Integer getCrmBulletTop() {
		return crmBulletTop;
	}

	public void setCrmBulletTop(Integer crmBulletTop) {
		this.crmBulletTop = crmBulletTop;
	}

	public Integer getBulletManage() {
		return bulletManage;
	}

	public void setBulletManage(Integer bulletManage) {
		this.bulletManage = bulletManage;
	}

	public Integer getProhibitSpeak() {
		return prohibitSpeak;
	}

	public void setProhibitSpeak(Integer prohibitSpeak) {
		this.prohibitSpeak = prohibitSpeak;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getSuperUser() {
		return superUser;
	}

	public void setSuperUser(String superUser) {
		this.superUser = superUser;
	}

	public String getSuperEnd() {
		return superEnd;
	}

	public void setSuperEnd(String superEnd) {
		this.superEnd = superEnd;
	}

	public Integer getUserRight() {
		return userRight;
	}

	public void setUserRight(Integer userRight) {
		this.userRight = userRight;
	}

	public String getUserPhotoMin() {
		return userPhotoMin;
	}

	public void setUserPhotoMin(String userPhotoMin) {
		this.userPhotoMin = userPhotoMin;
	}

	public String getBbsPhoto() {
		return bbsPhoto;
	}

	public void setBbsPhoto(String bbsPhoto) {
		this.bbsPhoto = bbsPhoto;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBbsName() {
		return bbsName;
	}

	public void setBbsName(String bbsName) {
		this.bbsName = bbsName;
	}

	public String getRealPhoto() {
		return realPhoto;
	}

	public void setRealPhoto(String realPhoto) {
		this.realPhoto = realPhoto;
	}

	public Integer getUserScore() {
		return userScore;
	}

	public void setUserScore(Integer userScore) {
		this.userScore = userScore;
	}

	public Integer getCanAddStick() {
		return canAddStick;
	}

	public void setCanAddStick(Integer canAddStick) {
		this.canAddStick = canAddStick;
	}

	public Integer getCanEdit() {
		return canEdit;
	}

	public void setCanEdit(Integer canEdit) {
		this.canEdit = canEdit;
	}

	public Integer getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}
	

}

package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel
public class AdminBulletReply implements Serializable {
    /**
	 * @mbggenerated 主键
	 */
	@ApiModelProperty(value = "主键")
	private Integer replyId;
	/**
	 * @mbggenerated 范围
	 */
	@ApiModelProperty(value = "范围")
	private Integer bulletBound;
	/**
	 * @mbggenerated 城市ID
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated 公司ID
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated 回复主题ID
	 */
	@ApiModelProperty(value = "回复主题ID")
	private Integer bulletId;
	/**
	 * @mbggenerated (是否)显示联系电话，0=不显示 1=显示(默认为0)
	 */
	@ApiModelProperty(value = "(是否)显示联系电话，0=不显示 1=显示(默认为0)")
	private Boolean showTel;
	/**
	 * @mbggenerated 发布人名字
	 */
	@ApiModelProperty(value = "发布人名字")
	private String userName;
	/**
	 * @mbggenerated 联系电话
	 */
	@ApiModelProperty(value = "联系电话")
	private String telePhone;
	/**
	 * @mbggenerated 所属分店名称
	 */
	@ApiModelProperty(value = "所属分店名称")
	private String deptName;
	/**
	 * @mbggenerated 所属公司简称
	 */
	@ApiModelProperty(value = "所属公司简称")
	private String compName;
	/**
	 * @mbggenerated 回复人门店用户ID
	 */
	@ApiModelProperty(value = "回复人门店用户ID")
	private Integer creatorUid;
	/**
	 * @mbggenerated 回复人档案ID
	 */
	@ApiModelProperty(value = "回复人档案ID")
	private Integer archiveId;
	/**
	 * @mbggenerated 用户ID
	 */
	@ApiModelProperty(value = "用户ID")
	private Integer userId;
	/**
	 * @mbggenerated 回复时间
	 */
	@ApiModelProperty(value = "回复时间")
	private String creationTime;
	/**
	 * @mbggenerated 回复楼数
	 */
	@ApiModelProperty(value = "回复楼数")
	private Short lou;
	/**
	 * @mbggenerated 回复是否被屏蔽，0=正常 1=屏蔽
	 */
	@ApiModelProperty(value = "回复是否被屏蔽，0=正常 1=屏蔽")
	private Boolean isshield;
	/**
	 * @mbggenerated 回复是否被删除，0=正常 1=被删除
	 */
	@ApiModelProperty(value = "回复是否被删除，0=正常 1=被删除")
	private Boolean isdelete;
	/**
	 * @mbggenerated 被引用贴
	 */
	@ApiModelProperty(value = "被引用贴")
	private Integer useReplyId;
	/**
	 * @mbggenerated 编辑时间
	 */
	@ApiModelProperty(value = "编辑时间")
	private String editTime;
	/**
	 * @mbggenerated 关联ID
	 */
	@ApiModelProperty(value = "关联ID")
	private Integer relateId;
	/**
	 * @mbggenerated ISGOOD
	 */
	@ApiModelProperty(value = "isgood")
	private Boolean isgood;
	/**
	 * @mbggenerated GOOD_TIME
	 */
	@ApiModelProperty(value = "赞的时间")
	private String goodTime;
	/**
	 * @mbggenerated GOOD_COUNT
	 */
	@ApiModelProperty(value = "赞统计")
	private Integer goodCount;
	/**
	 * @mbggenerated 赞
	 */
	@ApiModelProperty(value = "赞")
	private Integer zan;
	/**
	 * @mbggenerated 0CRM 1ERP
	 */
	@ApiModelProperty(value = "")
	private Byte source;
	/**
	 * @mbggenerated 回复回复的回复，找不到第一层了，所以用这个ID存第一层的ID
	 */
	@ApiModelProperty(value = "回复回复的回复,第一层的ID")
	private Integer mainRelateId;
	/**
	 * @mbggenerated 内容
	 */
	@ApiModelProperty(value = "内容")
	private String contents;
	/**
	 * @mbggenerated 赞用户
	 */
	@ApiModelProperty(value = "赞用户")
	private String zanUser;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getReplyId() {
		return replyId;
	}

	/**
	 * @mbggenerated
	 */
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBulletBound() {
		return bulletBound;
	}

	/**
	 * @mbggenerated
	 */
	public void setBulletBound(Integer bulletBound) {
		this.bulletBound = bulletBound;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBulletId() {
		return bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getShowTel() {
		return showTel;
	}

	/**
	 * @mbggenerated
	 */
	public void setShowTel(Boolean showTel) {
		this.showTel = showTel;
	}

	/**
	 * @mbggenerated
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @mbggenerated
	 */
	public String getTelePhone() {
		return telePhone;
	}

	/**
	 * @mbggenerated
	 */
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	/**
	 * @mbggenerated
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @mbggenerated
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreatorUid() {
		return creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreatorUid(Integer creatorUid) {
		this.creatorUid = creatorUid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated
	 */
	public String getCreationTime() {
		return creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @mbggenerated
	 */
	public Short getLou() {
		return lou;
	}

	/**
	 * @mbggenerated
	 */
	public void setLou(Short lou) {
		this.lou = lou;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsshield() {
		return isshield;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsshield(Boolean isshield) {
		this.isshield = isshield;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsdelete() {
		return isdelete;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getUseReplyId() {
		return useReplyId;
	}

	/**
	 * @mbggenerated
	 */
	public void setUseReplyId(Integer useReplyId) {
		this.useReplyId = useReplyId;
	}

	/**
	 * @mbggenerated
	 */
	public String getEditTime() {
		return editTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getRelateId() {
		return relateId;
	}

	/**
	 * @mbggenerated
	 */
	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}

	/**
	 * @mbggenerated
	 */
	public Boolean getIsgood() {
		return isgood;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsgood(Boolean isgood) {
		this.isgood = isgood;
	}

	/**
	 * @mbggenerated
	 */
	public String getGoodTime() {
		return goodTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setGoodTime(String goodTime) {
		this.goodTime = goodTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getGoodCount() {
		return goodCount;
	}

	/**
	 * @mbggenerated
	 */
	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getZan() {
		return zan;
	}

	/**
	 * @mbggenerated
	 */
	public void setZan(Integer zan) {
		this.zan = zan;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSource() {
		return source;
	}

	/**
	 * @mbggenerated
	 */
	public void setSource(Byte source) {
		this.source = source;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMainRelateId() {
		return mainRelateId;
	}

	/**
	 * @mbggenerated
	 */
	public void setMainRelateId(Integer mainRelateId) {
		this.mainRelateId = mainRelateId;
	}

	/**
	 * @mbggenerated
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * @mbggenerated
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * @mbggenerated
	 */
	public String getZanUser() {
		return zanUser;
	}

	/**
	 * @mbggenerated
	 */
	public void setZanUser(String zanUser) {
		this.zanUser = zanUser;
	}

	@Override
	public String toString() {
		return "AdminBulletReply [replyId=" + replyId + ", bulletBound="
				+ bulletBound + ", cityId=" + cityId + ", compId=" + compId
				+ ", bulletId=" + bulletId + ", showTel=" + showTel
				+ ", userName=" + userName + ", telePhone=" + telePhone
				+ ", deptName=" + deptName + ", compName=" + compName
				+ ", creatorUid=" + creatorUid + ", archiveId=" + archiveId
				+ ", userId=" + userId + ", creationTime=" + creationTime
				+ ", lou=" + lou + ", isshield=" + isshield + ", isdelete="
				+ isdelete + ", useReplyId=" + useReplyId + ", editTime="
				+ editTime + ", relateId=" + relateId + ", isgood=" + isgood
				+ ", goodTime=" + goodTime + ", goodCount=" + goodCount
				+ ", zan=" + zan + ", contents=" + contents + "]";
	}
    
    
}
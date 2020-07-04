package com.myfun.erpWeb.bulletin.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class CreateBulletParam  implements EncryParamIfc {
	@ApiModelProperty(value = "是否投票贴")
	private Integer isvote;
	@ApiModelProperty(value = "是否显示电话")
	private Integer showPhone;
	@ApiModelProperty(value = "发布范围，多个逗号分隔，0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报 9=优家体系 10=加盟商")
	private Integer bounds = 1;
	@ApiModelProperty(value = "回复评论 0=默认 1=关闭评论")
	private Byte replyStatus;
	@ApiModelProperty(value = "置顶，0=普通 1=置顶")
	private Boolean stick;

	@ApiModelProperty(value = "帖子ID")
	private Integer bulletId;
	@ApiModelProperty(value = "附件信息")
	private String bulletinPs;
	@ApiModelProperty(value = "帖子类型 0=默认 1=签单喜报 2=内部公示(已经弃用) 3=公告通知 4=总部公告 5=公司制度 6=行业技能 7=成功案例")
	private Byte bulletType;
	@ApiModelProperty(value = "标题",required = true)
	private String bulletSubject;
	@ApiModelProperty(value = "内容",required = true)
	private String bulletContent;

	public Integer getIsvote() {
		return isvote;
	}

	public void setIsvote(Integer isvote) {
		this.isvote = isvote;
	}

	public Integer getShowPhone() {
		return showPhone;
	}

	public void setShowPhone(Integer showPhone) {
		this.showPhone = showPhone;
	}

	public Integer getBounds() {
		return bounds;
	}

	public void setBounds(Integer bounds) {
		this.bounds = bounds;
	}

	public Byte getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(Byte replyStatus) {
		this.replyStatus = replyStatus;
	}

	public Boolean getStick() {
		return stick;
	}

	public void setStick(Boolean stick) {
		this.stick = stick;
	}

	public Integer getBulletId() {
		return bulletId;
	}

	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}

	public String getBulletinPs() {
		return bulletinPs;
	}

	public void setBulletinPs(String bulletinPs) {
		this.bulletinPs = bulletinPs;
	}

	public Byte getBulletType() {
		return bulletType;
	}

	public void setBulletType(Byte bulletType) {
		this.bulletType = bulletType;
	}

	public String getBulletSubject() {
		return bulletSubject;
	}

	public void setBulletSubject(String bulletSubject) {
		this.bulletSubject = bulletSubject;
	}

	public String getBulletContent() {
		return bulletContent;
	}

	public void setBulletContent(String bulletContent) {
		this.bulletContent = bulletContent;
	}
}

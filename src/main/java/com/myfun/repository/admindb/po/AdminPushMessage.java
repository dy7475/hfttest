package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminPushMessage implements Serializable {

	/**
	 * @mbggenerated
	 */
	private Integer msgId;
	/**
	 * @mbggenerated 经纪人ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated
	 */
	private String photoAddr;
	/**
	 * @mbggenerated IM小秘书标题
	 */
	private String title;
	/**
	 * @mbggenerated IM小秘书角标
	 */
	private String mark;
	/**
	 * @mbggenerated IM小秘书消息内容
	 */
	private String msgContent;
	/**
	 * @mbggenerated 默认：2用于优优-   1:用于其他类型
	 */
	private Integer imType;
	/**
	 * @mbggenerated 3=房源管理跳转 4=需求中心跳转 5=独家房源跳转 6=实名认证跳转 7=联动跳转 8=html跳转 10=小区专家跳转
	 * 11=房源管理跳转并且弹出真房源各种状态的框 13=本地tips消息  14=C端发过来的消息 15=本地委托房源消息 16=优优抢单跳转
	 * 17=本地发的一个空消息 18=B端发送客源 19=直播小秘书通知 20=真房源审核未通过系统通知 21=直播礼物 22=直播普通消息
	 * 23=积分商城 24=红包消息 25=红包提示消息 26=（小秘书）分销 27=一元夺宝 28=小秘书，（一元夺宝，分销集合版）
	 * 29=小秘书 ，一元夺宝 30=房源推广 31= 房源小秘书消息 32= 个人现金提现成功 33= 网页类型活动
	 */
	private Integer msgType;
	/**
	 * @mbggenerated 跳转web页面是的URL
	 */
	private String url;
	/**
	 * @mbggenerated 跳转原生界面时需要的JSON数据
	 */
	private String json;
	/**
	 * @mbggenerated 1已发送
	 */
	private Byte isPush;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 通知信息的ID【C端的信息ID】
	 */
	private Integer caseId;
	/**
	 * @mbggenerated C端的信息城市ID
	 */
	private Integer cityId;
	/**
	 * @mbggenerated C端的信息类型
	 */
	private Integer caseType;
	/**
	 * @mbggenerated 发送人
	 */
	private String sender;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getMsgId() {
		return msgId;
	}

	/**
	 * @mbggenerated
	 */
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
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
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr == null ? null : photoAddr.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @mbggenerated
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @mbggenerated
	 */
	public void setMark(String mark) {
		this.mark = mark == null ? null : mark.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * @mbggenerated
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent == null ? null : msgContent.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getImType() {
		return imType;
	}

	/**
	 * @mbggenerated
	 */
	public void setImType(Integer imType) {
		this.imType = imType;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getMsgType() {
		return msgType;
	}

	/**
	 * @mbggenerated
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	/**
	 * @mbggenerated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @mbggenerated
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getJson() {
		return json;
	}

	/**
	 * @mbggenerated
	 */
	public void setJson(String json) {
		this.json = json == null ? null : json.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsPush() {
		return isPush;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsPush(Byte isPush) {
		this.isPush = isPush;
	}

	/**
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
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
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @mbggenerated
	 */
	public void setSender(String sender) {
		this.sender = sender == null ? null : sender.trim();
	}
}
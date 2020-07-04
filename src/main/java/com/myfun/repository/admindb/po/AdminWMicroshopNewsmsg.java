package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopNewsmsg implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司uid
	 */
	private Integer weixinId;
	/**
	 * @mbggenerated 父文章id
	 */
	private Integer pid;
	/**
	 * @mbggenerated
	 */
	private String mediaId;
	/**
	 * @mbggenerated 图片id
	 */
	private String thumbMediaId;
	/**
	 * @mbggenerated 标题
	 */
	private String title;
	/**
	 * @mbggenerated 作者
	 */
	private String author;
	/**
	 * @mbggenerated 图片地址
	 */
	private String picurl;
	/**
	 * @mbggenerated
	 */
	private String sourceUrl;
	/**
	 * @mbggenerated
	 */
	private String outerUrl;
	/**
	 * @mbggenerated 是否是首条
	 */
	private Byte isFirst;
	/**
	 * @mbggenerated 创建时间
	 */
	private Integer ctime;
	/**
	 * @mbggenerated 文章描述
	 */
	private String desc;
	/**
	 * @mbggenerated 内容
	 */
	private String content;
	/**
	 * @mbggenerated
	 */
	private String contentBak;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getWeixinId() {
		return weixinId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWeixinId(Integer weixinId) {
		this.weixinId = weixinId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * @mbggenerated
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * @mbggenerated
	 */
	public String getMediaId() {
		return mediaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId == null ? null : mediaId.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	/**
	 * @mbggenerated
	 */
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId == null ? null : thumbMediaId.trim();
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
	public String getAuthor() {
		return author;
	}

	/**
	 * @mbggenerated
	 */
	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getPicurl() {
		return picurl;
	}

	/**
	 * @mbggenerated
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl == null ? null : picurl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getSourceUrl() {
		return sourceUrl;
	}

	/**
	 * @mbggenerated
	 */
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getOuterUrl() {
		return outerUrl;
	}

	/**
	 * @mbggenerated
	 */
	public void setOuterUrl(String outerUrl) {
		this.outerUrl = outerUrl == null ? null : outerUrl.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getIsFirst() {
		return isFirst;
	}

	/**
	 * @mbggenerated
	 */
	public void setIsFirst(Byte isFirst) {
		this.isFirst = isFirst;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCtime() {
		return ctime;
	}

	/**
	 * @mbggenerated
	 */
	public void setCtime(Integer ctime) {
		this.ctime = ctime;
	}

	/**
	 * @mbggenerated
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @mbggenerated
	 */
	public void setDesc(String desc) {
		this.desc = desc == null ? null : desc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @mbggenerated
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getContentBak() {
		return contentBak;
	}

	/**
	 * @mbggenerated
	 */
	public void setContentBak(String contentBak) {
		this.contentBak = contentBak == null ? null : contentBak.trim();
	}
}
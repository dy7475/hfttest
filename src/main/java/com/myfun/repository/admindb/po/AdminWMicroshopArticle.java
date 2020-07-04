package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminWMicroshopArticle implements Serializable {

	/**
	 * @mbggenerated 主键ID
	 */
	private Integer id;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer fcompid;
	/**
	 * @mbggenerated 门店ID
	 */
	private Integer fdeptid;
	/**
	 * @mbggenerated 城市ID
	 */
	private Integer fcityid;
	/**
	 * @mbggenerated 新闻Title
	 */
	private String title;
	/**
	 * @mbggenerated 新闻摘要
	 */
	private String summary;
	/**
	 * @mbggenerated 封面图
	 */
	private String defaultImage;
	/**
	 * @mbggenerated 状态
	 */
	private Byte status;
	/**
	 * @mbggenerated 封面图片是否显示在正文中
	 */
	private Byte showThumb;
	/**
	 * @mbggenerated 跟新时间
	 */
	private Date updateTime;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date addTime;
	/**
	 * @mbggenerated 内容
	 */
	private String content;
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
	public Integer getFcompid() {
		return fcompid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFcompid(Integer fcompid) {
		this.fcompid = fcompid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFdeptid() {
		return fdeptid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFdeptid(Integer fdeptid) {
		this.fdeptid = fdeptid;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFcityid() {
		return fcityid;
	}

	/**
	 * @mbggenerated
	 */
	public void setFcityid(Integer fcityid) {
		this.fcityid = fcityid;
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
	public String getSummary() {
		return summary;
	}

	/**
	 * @mbggenerated
	 */
	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getDefaultImage() {
		return defaultImage;
	}

	/**
	 * @mbggenerated
	 */
	public void setDefaultImage(String defaultImage) {
		this.defaultImage = defaultImage == null ? null : defaultImage.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getStatus() {
		return status;
	}

	/**
	 * @mbggenerated
	 */
	public void setStatus(Byte status) {
		this.status = status;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getShowThumb() {
		return showThumb;
	}

	/**
	 * @mbggenerated
	 */
	public void setShowThumb(Byte showThumb) {
		this.showThumb = showThumb;
	}

	/**
	 * @mbggenerated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * @mbggenerated
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
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
}
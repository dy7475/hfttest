package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminJrFinancePhoto implements Serializable {

	/**
	 * @mbggenerated ID自增
	 */
	private Integer id;
	/**
	 * @mbggenerated 图片相对路径
	 */
	private String photoPath;
	/**
	 * @mbggenerated 金融ID
	 */
	private Integer financeId;
	/**
	 * @mbggenerated 预留，排序
	 */
	private Byte seqNum;
	/**
	 * @mbggenerated 图片类型  DD:PHOTO_TYPE
	 */
	private Byte photoType;
	/**
	 * @mbggenerated 图片来源 0-CRM；1-优优；2-ERP
	 */
	private Byte source;
	/**
	 * @mbggenerated 创建姓名
	 */
	private String createUserName;
	/**
	 * @mbggenerated 创建人ID
	 */
	private Integer createUserId;
	/**
	 * @mbggenerated 创建时间
	 */
	private Date createTime;
	/**
	 * @mbggenerated 删除标记，0-未删除，1-已删除
	 */
	private Boolean deleteFlag;
	/**
	 * @mbggenerated 附件类型 1-买方附件；2-卖方附件；3-财务附件；4-其他附件
	 */
	private Byte attachmentType;
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
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath == null ? null : photoPath.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getFinanceId() {
		return financeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSeqNum() {
		return seqNum;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeqNum(Byte seqNum) {
		this.seqNum = seqNum;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPhotoType() {
		return photoType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPhotoType(Byte photoType) {
		this.photoType = photoType;
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
	public String getCreateUserName() {
		return createUserName;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
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
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getAttachmentType() {
		return attachmentType;
	}

	/**
	 * @mbggenerated
	 */
	public void setAttachmentType(Byte attachmentType) {
		this.attachmentType = attachmentType;
	}
}
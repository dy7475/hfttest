package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunEntrustFiles extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID自增")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托ID")
	private Integer entrustId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件路径")
	private String filePath;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件大小")
	private String fileSizeCn;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件 5=房屋说明书")
	private Byte fileType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件名称")
	private String fileName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "更新时间")
	private Date updateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件后缀")
	private String fileExt;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID自增
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键ID自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 委托ID
	 */
	public Integer getEntrustId() {
		return entrustId;
	}

	/**
	 * @mbggenerated 委托ID
	 */
	public void setEntrustId(Integer entrustId) {
		this.entrustId = entrustId;
	}

	/**
	 * @mbggenerated 文件路径
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @mbggenerated 文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @mbggenerated 文件大小
	 */
	public String getFileSizeCn() {
		return fileSizeCn;
	}

	/**
	 * @mbggenerated 文件大小
	 */
	public void setFileSizeCn(String fileSizeCn) {
		this.fileSizeCn = fileSizeCn;
	}

	/**
	 * @mbggenerated 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
	 */
	public Byte getFileType() {
		return fileType;
	}

	/**
	 * @mbggenerated 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
	 */
	public void setFileType(Byte fileType) {
		this.fileType = fileType;
	}

	/**
	 * @mbggenerated 文件名称
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @mbggenerated 文件名称
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @mbggenerated 文件后缀
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @mbggenerated 文件后缀
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEntrustFiles() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEntrustFiles(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}
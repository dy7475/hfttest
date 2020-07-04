package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunPhoto extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片ID")
	private Integer photoId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片地址")
	private String photoAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片类型：0室内图1户型图2委托书类型3=小区图片4=外景图")
	private Byte photoType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片类别：1原始图、2缩略图")
	private Byte useageType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片字典ID")
	private Integer pdId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人")
	private Integer uploadUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传时间")
	private String uploadDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "首图标记")
	private Byte isTop;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片来源、0:来自移动端  1=erp用户上传、3=酷家乐、5来自移动端-陈文超(后期发现好像其他地方也在用0)")
	private Byte photoSource;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片状态，目前的图片 0 和1 都是有效的 房源读取张数条件是<=1，超哥说!=2也是有效，但不知道3哪里来的,图片状态加一个4代表房勘图片 2=删除    5.美联没有权限的人上传后状态为5【表示审核中】")
	private Byte transmitFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "老的图片ID")
	private Integer photoIdOld;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片排序字段")
	private Integer photoSeq;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核标记，0：未审，1：通过，2：不通过，3：恶性")
	private Byte photoReviewFlag;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核人")
	private Integer photoReviewUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核时间")
	private Date photoReviewTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "锁定人")
	private Integer lockUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否无效，1=无效，图片处理时使用，http请求图片地址，状态码不为200就会被改为1，不影响业务逻辑")
	private Integer isInvalid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除人Id")
	private Integer delUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "删除时间")
	private Date delTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "跟进ID")
	private Integer trackId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超")
	private Byte fileSystemType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用")
	private String fileAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传的唯一标识")
	private String uploadClientId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人门店id")
	private Integer deptId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上传人门店名称")
	private String deptName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源室内图类型 DD:HOUSE_INDOOR_PHOTO_TYPE")
	private Byte houseIndoorPhotoType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "1=图片是房堪上传的，因为TRANSMIT_FLAG=4的状态会改变，所以增加此字段")
	private Byte fkPhoto;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "组织机构名称")
	private String organizationName;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 图片ID
	 */
	public Integer getPhotoId() {
		return photoId;
	}

	/**
	 * @mbggenerated 图片ID
	 */
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源类型
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 图片地址
	 */
	public String getPhotoAddr() {
		return photoAddr;
	}

	/**
	 * @mbggenerated 图片地址
	 */
	public void setPhotoAddr(String photoAddr) {
		this.photoAddr = photoAddr;
	}

	/**
	 * @mbggenerated 图片类型：0室内图1户型图2委托书类型3=小区图片4=外景图
	 */
	public Byte getPhotoType() {
		return photoType;
	}

	/**
	 * @mbggenerated 图片类型：0室内图1户型图2委托书类型3=小区图片4=外景图
	 */
	public void setPhotoType(Byte photoType) {
		this.photoType = photoType;
	}

	/**
	 * @mbggenerated 图片类别：1原始图、2缩略图
	 */
	public Byte getUseageType() {
		return useageType;
	}

	/**
	 * @mbggenerated 图片类别：1原始图、2缩略图
	 */
	public void setUseageType(Byte useageType) {
		this.useageType = useageType;
	}

	/**
	 * @mbggenerated 图片字典ID
	 */
	public Integer getPdId() {
		return pdId;
	}

	/**
	 * @mbggenerated 图片字典ID
	 */
	public void setPdId(Integer pdId) {
		this.pdId = pdId;
	}

	/**
	 * @mbggenerated 上传人
	 */
	public Integer getUploadUser() {
		return uploadUser;
	}

	/**
	 * @mbggenerated 上传人
	 */
	public void setUploadUser(Integer uploadUser) {
		this.uploadUser = uploadUser;
	}

	/**
	 * @mbggenerated 上传时间
	 */
	public String getUploadDate() {
		return uploadDate;
	}

	/**
	 * @mbggenerated 上传时间
	 */
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * @mbggenerated 首图标记
	 */
	public Byte getIsTop() {
		return isTop;
	}

	/**
	 * @mbggenerated 首图标记
	 */
	public void setIsTop(Byte isTop) {
		this.isTop = isTop;
	}

	/**
	 * @mbggenerated 图片来源、0:来自移动端  1=erp用户上传、3=酷家乐、5来自移动端-陈文超(后期发现好像其他地方也在用0)
	 */
	public Byte getPhotoSource() {
		return photoSource;
	}

	/**
	 * @mbggenerated 图片来源、0:来自移动端  1=erp用户上传、3=酷家乐、5来自移动端-陈文超(后期发现好像其他地方也在用0)
	 */
	public void setPhotoSource(Byte photoSource) {
		this.photoSource = photoSource;
	}

	/**
	 * @mbggenerated 图片状态，目前的图片 0 和1 都是有效的 房源读取张数条件是<=1，超哥说!=2也是有效，但不知道3哪里来的,图片状态加一个4代表房勘图片 2=删除    5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public Byte getTransmitFlag() {
		return transmitFlag;
	}

	/**
	 * @mbggenerated 图片状态，目前的图片 0 和1 都是有效的 房源读取张数条件是<=1，超哥说!=2也是有效，但不知道3哪里来的,图片状态加一个4代表房勘图片 2=删除    5.美联没有权限的人上传后状态为5【表示审核中】
	 */
	public void setTransmitFlag(Byte transmitFlag) {
		this.transmitFlag = transmitFlag;
	}

	/**
	 * @mbggenerated 老的图片ID
	 */
	public Integer getPhotoIdOld() {
		return photoIdOld;
	}

	/**
	 * @mbggenerated 老的图片ID
	 */
	public void setPhotoIdOld(Integer photoIdOld) {
		this.photoIdOld = photoIdOld;
	}

	/**
	 * @mbggenerated 图片排序字段
	 */
	public Integer getPhotoSeq() {
		return photoSeq;
	}

	/**
	 * @mbggenerated 图片排序字段
	 */
	public void setPhotoSeq(Integer photoSeq) {
		this.photoSeq = photoSeq;
	}

	/**
	 * @mbggenerated 审核标记，0：未审，1：通过，2：不通过，3：恶性
	 */
	public Byte getPhotoReviewFlag() {
		return photoReviewFlag;
	}

	/**
	 * @mbggenerated 审核标记，0：未审，1：通过，2：不通过，3：恶性
	 */
	public void setPhotoReviewFlag(Byte photoReviewFlag) {
		this.photoReviewFlag = photoReviewFlag;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public Integer getPhotoReviewUid() {
		return photoReviewUid;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public void setPhotoReviewUid(Integer photoReviewUid) {
		this.photoReviewUid = photoReviewUid;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public Date getPhotoReviewTime() {
		return photoReviewTime;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setPhotoReviewTime(Date photoReviewTime) {
		this.photoReviewTime = photoReviewTime;
	}

	/**
	 * @mbggenerated 锁定人
	 */
	public Integer getLockUser() {
		return lockUser;
	}

	/**
	 * @mbggenerated 锁定人
	 */
	public void setLockUser(Integer lockUser) {
		this.lockUser = lockUser;
	}

	/**
	 * @mbggenerated 是否无效，1=无效，图片处理时使用，http请求图片地址，状态码不为200就会被改为1，不影响业务逻辑
	 */
	public Integer getIsInvalid() {
		return isInvalid;
	}

	/**
	 * @mbggenerated 是否无效，1=无效，图片处理时使用，http请求图片地址，状态码不为200就会被改为1，不影响业务逻辑
	 */
	public void setIsInvalid(Integer isInvalid) {
		this.isInvalid = isInvalid;
	}

	/**
	 * @mbggenerated 删除人Id
	 */
	public Integer getDelUser() {
		return delUser;
	}

	/**
	 * @mbggenerated 删除人Id
	 */
	public void setDelUser(Integer delUser) {
		this.delUser = delUser;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public Date getDelTime() {
		return delTime;
	}

	/**
	 * @mbggenerated 删除时间
	 */
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public Integer getTrackId() {
		return trackId;
	}

	/**
	 * @mbggenerated 跟进ID
	 */
	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public Byte getFileSystemType() {
		return fileSystemType;
	}

	/**
	 * @mbggenerated 0-默认(老文件系统)、1-FastDFS、【2,3,4,5作为以后扩展】-陈文超
	 */
	public void setFileSystemType(Byte fileSystemType) {
		this.fileSystemType = fileSystemType;
	}

	/**
	 * @mbggenerated 文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用
	 */
	public String getFileAddr() {
		return fileAddr;
	}

	/**
	 * @mbggenerated 文件地址或ID【需要拼接图片访问域名，例：http//pic.vfanghui.com/bahqa1-jdsadsad-aj23nhhj-jhyuu6uj.jpg】-暂时不使用
	 */
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
	}

	/**
	 * @mbggenerated 上传的唯一标识
	 */
	public String getUploadClientId() {
		return uploadClientId;
	}

	/**
	 * @mbggenerated 上传的唯一标识
	 */
	public void setUploadClientId(String uploadClientId) {
		this.uploadClientId = uploadClientId;
	}

	/**
	 * @mbggenerated 上传人门店id
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 上传人门店id
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 上传人门店名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @mbggenerated 上传人门店名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @mbggenerated 房源室内图类型 DD:HOUSE_INDOOR_PHOTO_TYPE
	 */
	public Byte getHouseIndoorPhotoType() {
		return houseIndoorPhotoType;
	}

	/**
	 * @mbggenerated 房源室内图类型 DD:HOUSE_INDOOR_PHOTO_TYPE
	 */
	public void setHouseIndoorPhotoType(Byte houseIndoorPhotoType) {
		this.houseIndoorPhotoType = houseIndoorPhotoType;
	}

	/**
	 * @mbggenerated 1=图片是房堪上传的，因为TRANSMIT_FLAG=4的状态会改变，所以增加此字段
	 */
	public Byte getFkPhoto() {
		return fkPhoto;
	}

	/**
	 * @mbggenerated 1=图片是房堪上传的，因为TRANSMIT_FLAG=4的状态会改变，所以增加此字段
	 */
	public void setFkPhoto(Byte fkPhoto) {
		this.fkPhoto = fkPhoto;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated 组织机构ID
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated 组织机构名称
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @mbggenerated 组织机构名称
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPhoto() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunPhoto(Integer shardCityId, Integer photoId) {
		super(shardCityId);
		this.photoId = photoId;
	}
}
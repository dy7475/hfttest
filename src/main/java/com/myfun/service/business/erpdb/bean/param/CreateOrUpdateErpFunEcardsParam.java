package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
/**
* @ClassName: CreateOrUpdateErpFunEcardsParam 
* @Description: (创建或者更新电子名片参数类) 
* @author 方李骥
* @date 2016-9-24 下午2:42:50
 */
public class CreateOrUpdateErpFunEcardsParam extends AbstractEncryParam implements DaoBaseParam{
	
	private Integer ecardId;
	/**
	 *  收录人公司ID
	 */
	private Integer compId;
	/**
	 *  收录人分店ID
	 */
	private Integer deptId;
	/**
	 *  收录人ID
	 */
	private Integer archiveId;
	/**
	 *  姓名
	 */
	private String ecardsName;
	/**
	 *  姓别，1-先生
	 */
	private Boolean ecardsSex;
	/**
	 *  职务
	 */
	private String ecardsPost;
	/**
	 *  电子邮箱
	 */
	private String ecardsMail;
	/**
	 *  QQ号码
	 */
	private String ecardsQq;
	/**
	 *  电话
	 */
	private String ecardsTel;
	/**
	 *  公司名称
	 */
	private String ecardsComp;
	/**
	 *  方位
	 */
	private String ecardsPos;
	/**
	 *  地址
	 */
	private String compAdd;
	/**
	 *  公司网址
	 */
	private String compUrl;
	/**
	 *  备注
	 */
	private String ecardsRemarks;
	/**
	 *  收录入时间
	 */
	private String createTime;
	/**
	 *  是否公开，0=公开，1=保密
	 */
	private Boolean isPublic;
	/**
	 * 
	 */
	private Integer ecardsArchiveId; //与公司关联的人的档案ID
	private Integer cityId;//切库所需要使用的城市ID
	private Integer keyId;//钥匙ID
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private Integer currentUserId;//业务层需要使用当前用户Id
	private String userName;//业务层需要使用当前用户名称
	private String currentDeptName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private String phone;//客户电话
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getKeyId() {
		return keyId;
	}
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	public String getCurrentUserName() {
		return currentUserName;
	}
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentDeptName() {
		return currentDeptName;
	}
	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	public Integer getEcardId() {
		return ecardId;
	}
	public void setEcardId(Integer ecardId) {
		this.ecardId = ecardId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getEcardsName() {
		return ecardsName;
	}
	public void setEcardsName(String ecardsName) {
		this.ecardsName = ecardsName;
	}
	public Boolean getEcardsSex() {
		return ecardsSex;
	}
	public void setEcardsSex(Boolean ecardsSex) {
		this.ecardsSex = ecardsSex;
	}
	public String getEcardsPost() {
		return ecardsPost;
	}
	public void setEcardsPost(String ecardsPost) {
		this.ecardsPost = ecardsPost;
	}
	public String getEcardsMail() {
		return ecardsMail;
	}
	public void setEcardsMail(String ecardsMail) {
		this.ecardsMail = ecardsMail;
	}
	public String getEcardsQq() {
		return ecardsQq;
	}
	public void setEcardsQq(String ecardsQq) {
		this.ecardsQq = ecardsQq;
	}
	public String getEcardsTel() {
		return ecardsTel;
	}
	public void setEcardsTel(String ecardsTel) {
		this.ecardsTel = ecardsTel;
	}
	public String getEcardsComp() {
		return ecardsComp;
	}
	public void setEcardsComp(String ecardsComp) {
		this.ecardsComp = ecardsComp;
	}
	public String getEcardsPos() {
		return ecardsPos;
	}
	public void setEcardsPos(String ecardsPos) {
		this.ecardsPos = ecardsPos;
	}
	public String getCompAdd() {
		return compAdd;
	}
	public void setCompAdd(String compAdd) {
		this.compAdd = compAdd;
	}
	public String getCompUrl() {
		return compUrl;
	}
	public void setCompUrl(String compUrl) {
		this.compUrl = compUrl;
	}
	public String getEcardsRemarks() {
		return ecardsRemarks;
	}
	public void setEcardsRemarks(String ecardsRemarks) {
		this.ecardsRemarks = ecardsRemarks;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Integer getEcardsArchiveId() {
		return ecardsArchiveId;
	}
	public void setEcardsArchiveId(Integer ecardsArchiveId) {
		this.ecardsArchiveId = ecardsArchiveId;
	}
	
}

/**
 * @author 方李骥
 * @since 2016年8月30日
 */
package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年8月30日
 */
public class DestroyKeyParam extends AbstractEncryParam implements DaoBaseParam{
	private Integer compId;//业务层需要使用当前用户所在公司
	private Integer cityId;//切库所需要使用的城市ID
	private Integer keyId;//钥匙ID
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private Integer currentUserId;//业务层需要使用当前用户Id
	private String userName;//业务层需要使用当前用户名称
	private String currentDeptName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private String hongJICompModel;//判断当前公司是否是鸿基公司0鸿基1非鸿基
	private Integer caseId;//房源ID
	private String caseNo;//房源编号
	private Byte caseType;//房源类型 1出售2出租
	
	
	public Integer getCaseId() {
		return caseId;
	}
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Byte getCaseType() {
		return caseType;
	}
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}
	/**
	 * @return the currentDeptName
	 */
	public String getCurrentDeptName() {
		return currentDeptName;
	}
	/**
	 * @param currentDeptName the currentDeptName to set
	 */
	public void setCurrentDeptName(String currentDeptName) {
		this.currentDeptName = currentDeptName;
	}
	/**
	 * @return the hongJICompModel
	 */
	public String getHongJICompModel() {
		return hongJICompModel;
	}
	/**
	 * @param hongJICompModel the hongJICompModel to set
	 */
	public void setHongJICompModel(String hongJICompModel) {
		this.hongJICompModel = hongJICompModel;
	}
	/**
	 * @return the compId
	 */
	public Integer getCompId() {
		return compId;
	}
	/**
	 * @param compId the compId to set
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * @return the keyId
	 */
	public Integer getKeyId() {
		return keyId;
	}
	/**
	 * @param keyId the keyId to set
	 */
	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
	/**
	 * @return the currentUserName
	 */
	public String getCurrentUserName() {
		return currentUserName;
	}
	/**
	 * @param currentUserName the currentUserName to set
	 */
	public void setCurrentUserName(String currentUserName) {
		this.currentUserName = currentUserName;
	}
	/**
	 * @return the currentUserId
	 */
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	/**
	 * @param currentUserId the currentUserId to set
	 */
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the currentDeptId
	 */
	public Integer getCurrentDeptId() {
		return currentDeptId;
	}
	/**
	 * @param currentDeptId the currentDeptId to set
	 */
	public void setCurrentDeptId(Integer currentDeptId) {
		this.currentDeptId = currentDeptId;
	}
	

}

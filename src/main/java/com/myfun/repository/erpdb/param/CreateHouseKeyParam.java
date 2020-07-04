package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
public class CreateHouseKeyParam extends AbstractEncryParam implements DaoBaseParam {
	private Integer caseId;//房源ID
	private String caseNo;//房源编号
	private Byte caseType;//房源类型 1出售2出租
	private String key;//区分是否有钥匙备注1有钥匙0无钥匙
	private Integer keyDeptId;//钥匙所在门店
	private String keyNote;//备注说明
	private String keyNum;//指定的钥匙编号
	private Byte useAge;//用途
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private Integer currentUserId;//业务层需要使用当前用户Id
	private String userName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private String KeyStatus;//钥匙状态
	
	
	/**
	 * @return the keyStatus
	 */
	public String getKeyStatus() {
		return KeyStatus;
	}
	/**
	 * @param keyStatus the keyStatus to set
	 */
	public void setKeyStatus(String keyStatus) {
		KeyStatus = keyStatus;
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
	 * @return the currentUserId
	 */
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	/**
	 * @param integer the currentUserId to set
	 */
	public void setCurrentUserId(Integer integer) {
		this.currentUserId = integer;
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
	 * @return the caseId
	 */
	public Integer getCaseId() {
		return caseId;
	}
	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}
	/**
	 * @return the caseNo
	 */
	public String getCaseNo() {
		return caseNo;
	}
	/**
	 * @param caseNo the caseNo to set
	 */
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	/**
	 * @return the caseType
	 */
	public Byte getCaseType() {
		return caseType;
	}
	/**
	 * @param caseType the caseType to set
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the keyDeptId
	 */
	public Integer getKeyDeptId() {
		return keyDeptId;
	}
	/**
	 * @param keyDeptId the keyDeptId to set
	 */
	public void setKeyDeptId(Integer keyDeptId) {
		this.keyDeptId = keyDeptId;
	}
	/**
	 * @return the keyNote
	 */
	public String getKeyNote() {
		return keyNote;
	}
	/**
	 * @param keyNote the keyNote to set
	 */
	public void setKeyNote(String keyNote) {
		this.keyNote = keyNote;
	}
	/**
	 * @return the keyNum
	 */
	public String getKeyNum() {
		return keyNum;
	}
	/**
	 * @param keyNum the keyNum to set
	 */
	public void setKeyNum(String keyNum) {
		this.keyNum = keyNum;
	}
	/**
	 * @return the useAge
	 */
	public Byte getUseAge() {
		return useAge;
	}
	/**
	 * @param useAge the useAge to set
	 */
	public void setUseAge(Byte useAge) {
		this.useAge = useAge;
	}

	
}

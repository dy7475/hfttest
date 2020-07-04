package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

public class QueryVcardListParam extends AbstractEncryParam implements DaoBaseParam {
	private Integer compId;//业务层需要使用当前用户所在公司
	private Integer cityId;//切库所需要使用的城市ID
	private String currentUserName;//业务层需要使用当前用户的名称(带门店名称)
	private Integer currentUserId;//业务层需要使用当前用户Id
	private String userName;//业务层需要使用当前用户名称
	private String currentDeptName;//业务层需要使用当前用户名称
	private Integer currentDeptId;//当前用户所在门店ID
	private Integer deptId;//门店名称
	private String orderBy;//排序方式
	private String queryFor;//comp公司 name名称 tele电话 post邮政
	private String queryKey;//查询关键词
	private String ecardsComp;
	private String ecardsName;
	private String ecardsTel;
	private String ecardsPost;
	private Boolean isPublic;
	
	
	
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public String getEcardsComp() {
		return ecardsComp;
	}
	public void setEcardsComp(String ecardsComp) {
		this.ecardsComp = ecardsComp;
	}
	public String getEcardsName() {
		return ecardsName;
	}
	public void setEcardsName(String ecardsName) {
		this.ecardsName = ecardsName;
	}
	public String getEcardsTel() {
		return ecardsTel;
	}
	public void setEcardsTel(String ecardsTel) {
		this.ecardsTel = ecardsTel;
	}
	public String getEcardsPost() {
		return ecardsPost;
	}
	public void setEcardsPost(String ecardsPost) {
		this.ecardsPost = ecardsPost;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getQueryFor() {
		return queryFor;
	}
	public void setQueryFor(String queryFor) {
		this.queryFor = queryFor;
	}
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}

}

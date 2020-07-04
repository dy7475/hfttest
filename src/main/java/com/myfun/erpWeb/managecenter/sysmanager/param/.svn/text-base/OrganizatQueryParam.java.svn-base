package com.myfun.erpWeb.managecenter.sysmanager.param;

import java.util.Set;

/**
 * 该内用于组织机构模式下内部查询条件使用
 * 
 * 主要用于：列表查询、匹配查询
 * @author 陈文超
 * @date 2019年12月9日 上午11:15:52
 */
public class OrganizatQueryParam {

    /**
     * 主要用于判断是否不限制查询
     * 例：用户的查看范围已经是全公司权限了，则忽略所有的组织机构条件判断，该情况下：limit = false
     */
    private Boolean limit = false;
    
    /**
     * 本次查询的机构ID范围
     */
    private Set<Integer> queryOrgIds;
    
    /**
     * 只能查询本人数据时，该字段才有值
     */
    private Integer selfUserId;
    
    public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}

	public Boolean getLimit() {
        return limit;
    }

    public void setLimit(Boolean limit) {
        this.limit = limit;
    }

    public Set<Integer> getQueryOrgIds() {
        return queryOrgIds;
    }

    public void setQueryOrgIds(Set<Integer> queryOrgIds) {
        this.queryOrgIds = queryOrgIds;
    }
}

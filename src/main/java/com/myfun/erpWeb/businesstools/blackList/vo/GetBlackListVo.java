package com.myfun.erpWeb.businesstools.blackList.vo;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunBlackList;

import io.swagger.annotations.ApiModelProperty;

public class GetBlackListVo {

	@ApiModelProperty(value = "当前页")
	private int pageNum;
	@ApiModelProperty(value = "每页的数量")
	private int pageSize;
	@ApiModelProperty(value = "总记录数")
	private long total;
	@ApiModelProperty(value = "总页数")
	private int pages;
	private List<ErpFunBlackList> resultList;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public List<ErpFunBlackList> getResultList() {
		return resultList;
	}
	public void setResultList(List<ErpFunBlackList> resultList) {
		this.resultList = resultList;
	}
}

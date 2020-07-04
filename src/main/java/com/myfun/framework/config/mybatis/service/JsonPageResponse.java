package com.myfun.framework.config.mybatis.service;

import com.github.pagehelper.Page;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.repository.support.constant.Const;

import java.util.List;


/**
 * 
* @ClassName: JsonPageResponse 
* @Description: 通用分页响应实体
* @author tangliang1
* @date 2020年6月24日 下午2:44:12 
* 
* @param <T>
 */
public class JsonPageResponse<T> extends DefaultResponseJson {

	private int currPage;

	private int pageSize;
	
	private int totalPages;

	private long total;

	public JsonPageResponse() {
		super();
	}
	
	/**
	 * 设置分页数据
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param <T>
	* @param data
	* @param pageData
	 */
	public JsonPageResponse(List<T> data, Page<T> pageData) {
		super();
		super.setErrCode(Const.ResponseCode.SUCCESS);
		super.setErrMsg("操作成功");
		super.setData(data);
		this.total = pageData.getTotal();
		this.currPage = pageData.getPageNum();
		this.pageSize = pageData.getPageSize();
		this.totalPages=pageData.getPages();
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
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

	@SuppressWarnings("unchecked")
	public List<T> getData() {
		return (List<T>) super.getData();
	}

	public void setData(List<T> data) {
		super.setData(data);
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}



}

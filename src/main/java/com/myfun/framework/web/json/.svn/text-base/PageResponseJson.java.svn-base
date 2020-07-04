package com.myfun.framework.web.json;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.support.constant.Const;

/**
 * 带分页的存储格式
 * 
 * @ClassName: PageResponseJson
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:17:59
 *
 */
public class PageResponseJson extends DefaultResponseJson {
	private Long total;
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalPage;

	public PageResponseJson() {
		super();
	}

	public <T> PageResponseJson(List<Object> data, Long total, Integer pageNum, Integer numPerPage) {
		super();
		super.setErrCode(Const.ResponseCode.SUCCESS);
		super.setData(data);
		this.total = total;
		this.pageNum = pageNum;
		this.pageSize = numPerPage;
	}

	public <T> PageResponseJson(PageInfo<T> datas) {
		super();
		super.setErrCode(Const.ResponseCode.SUCCESS);
		super.setData(datas.getList());
		this.total = datas.getTotal();
		this.pageNum = datas.getPageNum();
		this.pageSize = datas.getPageSize();
		this.totalPage = datas.getPageNum();
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

}

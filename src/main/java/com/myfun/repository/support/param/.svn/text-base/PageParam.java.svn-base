package com.myfun.repository.support.param;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;

/**
 * 分页基础类
 * 
 * @ClassName: PageParam
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月3日 上午9:49:17
 * 
 *
 */
public class PageParam  implements EncryParamIfc{
	private Integer pageNum;
	private Integer pageSize;

	public PageParam() {

	}

	public PageParam(Integer pageNum, Integer pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum == null ? 1 : pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize == null ? Const.PAGE_NUMBER : pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}

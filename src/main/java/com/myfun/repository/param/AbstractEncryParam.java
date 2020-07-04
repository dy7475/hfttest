package com.myfun.repository.param;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public abstract class AbstractEncryParam implements EncryParamIfc{
	@ApiModelProperty("页码")
	protected Integer pageOffset = 1; // 1 第几页
	@ApiModelProperty("每页显示数量")
	protected Integer pageRows = 50; // 50 一页多少条
	@ApiModelProperty(hidden = true)
	protected String paramBody; // 请求参数字符串
	
	/**
	 * 通过参数转换成对象，只适用于自定义对象
	 * BaseMapParam的请使用BeanUtil.populate(setParam, param.getMap());
	 * @author 张宏利
	 * @since 2017年7月11日
	 * @param clazz
	 * @return
	 */
	public <T> T getParamObj(String jsonStr, Class<T> clazz){
		return JSON.parseObject(jsonStr, clazz);
	}
	
	public String getParamBody() {
		return paramBody;
	}

	public void setParamBody(String paramBody) {
		this.paramBody = paramBody;
	}
	
	/**
	 * 是否需要查询总数，第一页才需要查询
	 * @author 张宏利
	 * @since 2017年9月1日
	 * @return
	 */
	public boolean isNeedCount() {
		return getPageOffset() == 1;
	}
	
	public Integer getOffsetNow() {
		return (getPageOffset()-1)*getPageRows();
	}
	
	public Integer getPageOffset() {
		if(pageOffset == null || pageOffset <= 0){
			return Const.CURRENT_PAGE;
		}
		return pageOffset;
	}
	
	public void setPageOffset(Integer pageOffset) {
		this.pageOffset = pageOffset;
	}

	public Integer getPageRows() {
		if(pageRows == null || pageRows <= 0){
			return Const.PAGE_NUMBER;
		}
		return pageRows;
	}
	
	public Integer getPageRows(Integer p) {
		if(pageRows == null || pageRows <= 0){
			return p;
		}
		return pageRows;
	}
	
	public void setPageRows(Integer p) {
		pageRows = p;
	}
	
}

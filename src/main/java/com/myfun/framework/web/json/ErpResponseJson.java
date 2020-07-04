package com.myfun.framework.web.json;

import java.util.Date;
import java.util.List;

import org.apache.solr.common.util.Hash;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.utils.DateTimeHelper;


/**
 * 
 * ERP返回数据格式
 * 
 */
public class ErpResponseJson implements ResponseJson {
	private static SerializeConfig mapping = new SerializeConfig();
	static {
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}
	/** 状态码 **/
	private int errCode;
	/** 返回值说明 **/
	private String errMsg;
	/** 返回数据 **/
	private Object data;
	/** 总数 **/
	private Long total;
	/** 当前页数 **/
	private Integer pageNum;
	/** 每页条数 **/
	private Integer pageSize;
	/** 总页数 **/
	private Integer totalPage;
	/** 当前服务器时间**/
	private String serverTime = DateTimeHelper.formatDateTimetoString(new Date());
	/** 额外信息 **/
	private Object extra;
	private Object error;
	public ErpResponseJson() {
		this.setData(new Hash());
		this.errCode = Const.ResponseCode.SUCCESS;
	}

	public ErpResponseJson(Object data) {
		this.setData(data);
		this.errCode = Const.ResponseCode.SUCCESS;
	}

	public ErpResponseJson(int errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public ErpResponseJson(int errCode, String errMsg, Object data) {
		super();
		this.setData(data);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public ErpResponseJson(int errCode) {
		super();
		this.errCode = errCode;
	}

	public <T> ErpResponseJson(List<Object> data, Long total, Integer pageNum, Integer numPerPage) {
		super();
		this.errCode = Const.ResponseCode.SUCCESS;
		this.data = data;
		this.total = total;
		this.pageNum = pageNum;
		this.pageSize = numPerPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	
	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
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

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		if (null != data) {
			if(data instanceof PageInfo) {
				PageInfo<?> pageInfo = (PageInfo<?>) data;
				this.data = pageInfo.getList();
				this.total = pageInfo.getTotal();
				this.pageNum = pageInfo.getPageNum();
				this.pageSize = pageInfo.getPageSize();
				this.totalPage = pageInfo.getPages();
			}else {
				this.data = data;
			}
		}
	}

	public void setPageInfo(Object data) {
		if (null != data) {
			if(data instanceof PageInfo) {
				PageInfo<?> pageInfo = (PageInfo<?>) data;
				this.total = pageInfo.getTotal();
				this.pageNum = pageInfo.getPageNum();
				this.pageSize = pageInfo.getPageSize();
				this.totalPage = pageInfo.getPages();
			}else {
				this.data = data;
			}
		}
	}

	public String getServerTime() {
		return serverTime;
	}

	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	/**
	 * 需要前端配合展示的返回方法
	 * @author 张宏利
	 * @since 2017年4月26日
	 * @return
	 */
	public static ErpResponseJson warn(String errMsg){
		return new ErpResponseJson(ResponseCode.CONFIRM_CODE, errMsg);
	}
	
	/**
	 * 成功的返回方法
	 * @author 张宏利
	 * @since 2017年4月26日
	 * @return
	 */
	public static ErpResponseJson ok(){
		return new ErpResponseJson();
	}
	
	/**
	 * 成功的返回方法
	 * @author 张宏利
	 * @since 2017年4月26日
	 * @return
	 */
	public static ErpResponseJson ok(Object data){
		return new ErpResponseJson(data);
	}
	
	public String toJson() {
		return JSON.toJSONString(this, mapping);
	}
	@Override
	public String toString() {
		return "DefaultResponseJson [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + "]";
	}
	
	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

}

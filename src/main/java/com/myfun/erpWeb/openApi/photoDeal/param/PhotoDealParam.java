package com.myfun.erpWeb.openApi.photoDeal.param;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片处理参数
 * @author 张宏利
 * @since 2017年5月19日
 */
public class PhotoDealParam {
	private Boolean isStart = false;// 是否在拷贝中
	private Boolean copySwitch = false;// 拷贝开关 0=关闭 1=开启
	private Long sleepTime = 100L;// 拷贝暂停时间，毫秒
	private Integer dealCount = 1;// 每次请求循环处理多少次
	private Map<String, Integer> dealThreadCount = new HashMap<>();// 处理的单独线程数
	
	public Boolean getIsStart() {
		return isStart;
	}
	public void setIsStart(Boolean isStart) {
		this.isStart = isStart;
	}
	public Boolean getCopySwitch() {
		return copySwitch;
	}
	public void setCopySwitch(Boolean copySwitch) {
		this.copySwitch = copySwitch;
	}
	public Long getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(Long sleepTime) {
		this.sleepTime = sleepTime;
	}
	public Map<String, Integer> getDealThreadCount() {
		return dealThreadCount;
	}
	public void setDealThreadCount(Map<String, Integer> dealThreadCount) {
		this.dealThreadCount = dealThreadCount;
	}
	public Integer getDealCount() {
		return dealCount;
	}
	public void setDealCount(Integer dealCount) {
		this.dealCount = dealCount;
	}
	
}

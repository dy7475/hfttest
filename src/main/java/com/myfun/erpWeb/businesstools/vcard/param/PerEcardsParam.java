package com.myfun.erpWeb.businesstools.vcard.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;

public class PerEcardsParam extends AbstractEncryParam {

	@ApiModelProperty(value = "排序")
	private String orderBy;
	@ApiModelProperty(value = "查询关键字, 例如:_ ")
	private String queryKey;
	@ApiModelProperty(value = "查询来源, 例如: comp， name，tele")
	private String queryFor;
	@ApiModelProperty(hidden = true)
	private String ecardsComp;
	@ApiModelProperty(hidden = true)
	private String ecardsName;
	@ApiModelProperty(hidden = true)
	private String ecardsTel;
	@ApiModelProperty(hidden = true)
	private String ecardsPost;
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getQueryKey() {
		return queryKey;
	}
	public void setQueryKey(String queryKey) {
		this.queryKey = queryKey;
	}
	public String getQueryFor() {
		return queryFor;
	}
	public void setQueryFor(String queryFor) {
		this.queryFor = queryFor;
	}
}

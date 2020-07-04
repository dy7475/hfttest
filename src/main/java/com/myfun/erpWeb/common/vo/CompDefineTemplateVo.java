package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.AdminFunTemplet;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 单列表返回值继承此类
 */
@ApiModel("查询模板")
public class CompDefineTemplateVo {
	@ApiModelProperty(value = "返回数据")
	private List<TemplateVO> templetList;

	public List<TemplateVO> getTempletList() {
		return templetList;
	}

	public void setTempletList(List<TemplateVO> templetList) {
		this.templetList = templetList;
	}
}

package com.myfun.erpWeb.managecenter.sysmanager.vo;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;
import com.myfun.repository.erpdb.po.ErpFunPrologs;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "系统登陆日志列表VO")
public class ErpFunPrologsVo extends BaseListResultVo implements Serializable {

	private List<ErpFunPrologs> list;

	public ErpFunPrologsVo(PageInfo pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPages(pageInfo.getPages());
		this.setPageSize(pageInfo.getPageSize());
		this.setTotal(pageInfo.getTotal());
		this.setList(pageInfo.getList());
	}

	public ErpFunPrologsVo() {
	}

	public List<ErpFunPrologs> getList() {
		return list;
	}

	public void setList(List<ErpFunPrologs> list) {
		this.list = list;
	}
}

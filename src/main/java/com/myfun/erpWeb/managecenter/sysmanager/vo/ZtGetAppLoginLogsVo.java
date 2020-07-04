package com.myfun.erpWeb.managecenter.sysmanager.vo;
 /**
 * @author HuangJiang
 * @since 2019年7月1日 上午9:37:44
 * Modified XXX HuangJiang 2019年7月1日
 */

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.vo.BaseListResultVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "掌通登陆日志列表VO")
public class ZtGetAppLoginLogsVo extends BaseListResultVo implements Serializable {

	@ApiModelProperty(value="返回值LIST")
	private List<ZtAppLoginListVo> list;

	public ZtGetAppLoginLogsVo(PageInfo pageInfo) {
		this.setPageNum(pageInfo.getPageNum());
		this.setPages(pageInfo.getPages());
		this.setPageSize(pageInfo.getPageSize());
		this.setTotal(pageInfo.getTotal());
		this.setList(pageInfo.getList());
	}
	
	public ZtGetAppLoginLogsVo() {
	}
	
	public List<ZtAppLoginListVo> getList() {
	
		return list;
	}

	public void setList(List<ZtAppLoginListVo> list) {
	
		this.list = list;
	}
	
}


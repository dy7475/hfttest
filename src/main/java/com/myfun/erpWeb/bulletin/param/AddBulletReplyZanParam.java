package com.myfun.erpWeb.bulletin.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddBulletReplyZanParam extends AbstractEncryParam implements EncryParamIfc {
	@ApiModelProperty(value = "主键ID",required = true)
	private Integer replyId;
	@ApiModelProperty(value = "帖子ID",required = true)
	private Integer bulletId;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getBulletId() {
		return bulletId;
	}

	public void setBulletId(Integer bulletId) {
		this.bulletId = bulletId;
	}
}

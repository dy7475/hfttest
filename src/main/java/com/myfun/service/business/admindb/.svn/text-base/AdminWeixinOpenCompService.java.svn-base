package com.myfun.service.business.admindb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dto.AdminFunCompDto;
import com.myfun.repository.admindb.param.AdminWeixinOpenCompParam;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminWeixinOpenComp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminWeixinOpenCompService extends BaseMapper<AdminWeixinOpenComp, Integer>{
	/**
	 * 微信列表
	 * **/
	PageInfo<AdminFunCompDto> getPublicWechatList(AdminWeixinOpenCompParam weixinOpenCompParam);

	/**
	 * 公司信息
	 * @param compParam
	 * @return
	 */
	AdminWeixinOpenComp getWeixinOpenCompByCompID(Integer compId);

	/**
	 * 微信信息
	 */
	 AdminFunComp getFunCompByCompId(Integer compId);
	 
	 void updateWeixinOpenCompByCompId(AdminWeixinOpenComp upWeixinOpenComp);
}

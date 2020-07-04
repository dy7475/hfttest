package com.myfun.service.business.admindb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.bulletin.param.BulletinListParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.param.AdminBulletReplyParam;
import com.myfun.repository.admindb.po.AdminBullet;
import com.myfun.repository.erpdb.param.ReqBulletinHouseListParam;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBulletService extends BaseMapper<AdminBullet, Integer> {

	/**
	 * @TODO 帖子列表
	 * @author lcb
	 * @param operator 
	 * 
	 */
	PageInfo<AdminBulletDto> getBulletList(BulletinListParam baseMapParam, Operator operator);

	void addClick(Integer bulletId);

	AdminBulletDto getBulletinInfo(String bulletId);
	
	PageInfo<ErpFunSale> getFunSaleByBulletin(ReqBulletinHouseListParam param);
	PageInfo<ErpFunLease> getFunLeaseByBulletin(ReqBulletinHouseListParam param);
	
	/**
	 * 增加回复
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param param
	 */
	void addBulletReply(AdminBulletReplyParam param);


}

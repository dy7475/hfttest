package com.myfun.service.business.admindb;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.po.AdminFunBuildAuditPush;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@Service
public interface AdminFunBuildAuditPushService extends BaseMapper<AdminFunBuildAuditPush, Integer>{
	/**
	 * 判断当前用户是否弹窗
	 * @author 何传强
	 * @since 2017年6月27日
	 * @return
	 */
	public boolean pushWindowShow(Integer archiveId) ;

}

package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminInviteRegistErp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * 邀请注册
 * @author 张宏利
 * @since 2017年5月11日
 */
public interface AdminInviteRegistErpService extends BaseMapper<AdminInviteRegistErp, Integer> {
	
	void updateRegistStatus(Integer id);

	Integer getInviteCount(String userMobile);
	
}

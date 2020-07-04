package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunBuildAttention;
import com.myfun.repository.admindb.po.AdminFunBuildAttentionKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * Created by hukun on 2018/4/11.
 */
public interface AdminFunBuildAttentionService extends BaseMapper<AdminFunBuildAttention, AdminFunBuildAttentionKey> {
	
	/**
	 * 统计条数
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/11
	 * @return
	 *
	 */
	int countData(String newBuildId, Integer cityId, Integer archiveId);



	void createBuildAttention(Integer cityId, Integer archiveId, String oldBuildId, String newBuildId, String newBuildName);
}

package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunBuildAttention;
import com.myfun.repository.admindb.po.AdminFunBuildAttentionKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface AdminFunBuildAttentionMapper extends BaseMapper<AdminFunBuildAttention, AdminFunBuildAttentionKey> {
	
	/**
	 * 楼盘关注条数
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/11
	 * @return
	 *
	 */
	int count(@Param("cityId") Integer cityId,@Param("archiveId") Integer archiveId,@Param("buildId") String buildId);
	
	/**
	 * 删除楼盘关注
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/11
	 * @return
	 *
	 */
	void delete(@Param("cityId") Integer cityId,@Param("archiveId") Integer archiveId,@Param("buildId") String buildId);

	void deleteAutoAttention(@Param("archiveId")Integer archiveId);

	/**
	 * 手动关注
	 * @author ZangTie
	 * @since 2018年7月20日 下午8:39:42
	 * @param autoAttention
	 * @param archiveId
	 * @param buildId
	 * @param cityId
	 * Modified XXX ZangTie 2018年7月20日
	 */
	void updateAutoAttention(@Param("autoAttention")Integer autoAttention, @Param("archiveId")Integer archiveId,@Param("buildId") Integer buildId,@Param("cityId") Integer cityId);

	List<AdminFunBuildAttention> getBuildAttentionByArchiveIdAndCityId(@Param("cityId")Integer cityId,@Param("archiveId") Integer archiveId);
}
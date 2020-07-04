package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminBulletReplyZan;
import com.myfun.repository.admindb.po.AdminBulletReplyZanExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface AdminBulletReplyZanMapper extends BaseMapper<AdminBulletReplyZan, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminBulletReplyZanExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminBulletReplyZanExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminBulletReplyZan> selectByExample(AdminBulletReplyZanExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminBulletReplyZan record, @Param("example") AdminBulletReplyZanExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminBulletReplyZan record, @Param("example") AdminBulletReplyZanExample example);

	/**
	 * 增加用户赞的记录
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param cityId
	 * @param archiveId
	 * @param bulletId
	 * @param replyId
	 */
	void insertReplyZan(@Param("cityId") Integer cityId, @Param("archiveId") Integer archiveId,
			@Param("bulletId") Integer bulletId, @Param("replyId") Integer replyId);
	
	/**
	 * 查询自己是否赞过，通过回复的ID列表
	 * 
	 * @author 张宏利
	 * @since 2018年7月6日
	 * @param keySet
	 * @return
	 */
	List<AdminBulletReplyZan> getSelfZanList(@Param("archiveId") Integer archiveId, @Param("bulletId") Integer bulletId,
			@Param("replyIdSet") Set<Integer> replyIdSet);
}


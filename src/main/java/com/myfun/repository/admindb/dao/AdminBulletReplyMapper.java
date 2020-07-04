package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminBulletReplyDto;
import com.myfun.repository.admindb.po.AdminBulletReply;
import com.myfun.repository.admindb.po.AdminBulletReplyExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBulletReplyMapper extends BaseMapper<AdminBulletReply, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminBulletReply> selectByExampleWithBLOBs(AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminBulletReply> selectByExample(AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminBulletReply record,
			@Param("example") AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") AdminBulletReply record,
			@Param("example") AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminBulletReply record, @Param("example") AdminBulletReplyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminBulletReply record);

	List<AdminBulletReplyDto> getBulletReplyList(Integer bulletId);

	Integer updateCleanReply(Integer bulletId);

	Integer insertReply(AdminBulletReply adminBulletReply);

	Integer getMaxLouNumber(Integer bulletId);
	
	Integer updateBulletReplyPercent(Integer bulletId);

	AdminBulletReplyDto getReplyByReplyId(Integer replyId);
	
	List<AdminBulletReply> getBulletinReplyList(String bulletId);
	
	@MapKey("replyId")
	Map<Integer, AdminBulletReplyDto> getReplyMap(@Param("replyIdSet") Set<Integer> replyIdSet);
	
	/**
	 * 增加赞
	 * @author 张宏利
	 * @param replyId 
	 * @since 2018年2月8日
	 */
	void addZan(@Param("bulletId")Integer bulletId, @Param("replyId")Integer replyId);
	
	/**
	 * 删除帖子回复
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param bulletId
	 * @param replyId
	 */
	void deleteBulletReply(@Param("bulletId") Integer bulletId, @Param("replyId") Integer replyId);

}
package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminYouBorkerArchive;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminYouBorkerArchiveExample;
import java.util.List;

public interface AdminYouBorkerArchiveMapper extends BaseMapper<AdminYouBorkerArchive, Integer> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminYouBorkerArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminYouBorkerArchiveExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminYouBorkerArchive> selectByExample(AdminYouBorkerArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminYouBorkerArchive record,
			@Param("example") AdminYouBorkerArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminYouBorkerArchive record,
			@Param("example") AdminYouBorkerArchiveExample example);

	int updateIncreaseComplainCount(@Param("archiveId")Integer archiveId);
	
	/**
	 * 通过archiveId获取数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	AdminYouBorkerArchive getDataByArchiveId(@Param("archiveId") Integer archiveId);
	
	/**
	 * 通过archiveId修改
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	void updateByArchiveId(@Param("archiveId") Integer archiveId);
}
package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminContactInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface AdminContactInfoMapper extends BaseMapper<AdminContactInfo, Integer> {
	/**
	 * 统计记录数量
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/18
	 * @return 
	 * 
	 */
	int count(@Param("archiveId") Integer archiveId);
	
	/**
	 * 修改联系方式
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/18
	 * @return
	 *
	 */
	int updateByArchiveId(@Param("archiveId") Integer archiveId, @Param("contactFlag") String contactFlag, @Param("updateDate") Date updateDate);
	
	void insertContactInfo(@Param("archiveId") Integer archiveId, @Param("contactFlag") String contactFlag, @Param("updateDate") Date updateDate);
}
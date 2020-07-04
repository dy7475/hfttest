package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunArchiveFastdfs;
import com.myfun.repository.admindb.po.AdminFunArchiveFastdfsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunArchiveFastdfsMapper extends BaseMapper<AdminFunArchiveFastdfs, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunArchiveFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunArchiveFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunArchiveFastdfs> selectByExample(AdminFunArchiveFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunArchiveFastdfs record, @Param("example") AdminFunArchiveFastdfsExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunArchiveFastdfs record, @Param("example") AdminFunArchiveFastdfsExample example);
    
    Integer selectLastArchive();
	
	void insertHaveArchiveId(AdminFunArchiveFastdfs inAdminFunArchiveFastdfs);
}
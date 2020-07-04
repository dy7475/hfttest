package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunArchiveServicezone;
import com.myfun.repository.admindb.po.AdminFunArchiveServicezoneExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunArchiveServicezoneMapper extends BaseMapper<AdminFunArchiveServicezone, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminFunArchiveServicezoneExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunArchiveServicezoneExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunArchiveServicezone> selectByExample(AdminFunArchiveServicezoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunArchiveServicezone record,
			@Param("example") AdminFunArchiveServicezoneExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunArchiveServicezone record,
			@Param("example") AdminFunArchiveServicezoneExample example);

	void deleteBatDataInfo(@Param("archiveId")Integer archiveId);

    void createBatDataInfo(@Param("createModels") List<AdminFunArchiveServicezone> createModels);
	void deleteByRecordArchiveId(@Param("archiveId")Integer archiveId);
	void batchAddRecordList(@Param("archiveId")Integer archiveId, @Param("serviceZoneList")List<AdminFunArchiveServicezone> serviceZoneList);
}
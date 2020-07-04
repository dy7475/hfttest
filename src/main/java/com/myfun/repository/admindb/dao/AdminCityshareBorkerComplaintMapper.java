package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminCityshareBorkerComplaintDto;
import com.myfun.repository.admindb.po.AdminCityshareBorkerComplaint;
import com.myfun.repository.admindb.po.AdminCityshareBorkerComplaintExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCityshareBorkerComplaintMapper extends BaseMapper<AdminCityshareBorkerComplaint, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminCityshareBorkerComplaintExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminCityshareBorkerComplaintExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminCityshareBorkerComplaint> selectByExample(AdminCityshareBorkerComplaintExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminCityshareBorkerComplaint record,
			@Param("example") AdminCityshareBorkerComplaintExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminCityshareBorkerComplaint record,
			@Param("example") AdminCityshareBorkerComplaintExample example);
	
	List<AdminCityshareBorkerComplaint> getDealStatusList(@Param("selfArchiveId")Integer selfArchiveId, @Param("targetArchiveId")Integer targetArchiveId, @Param("shareHouseId")Integer shareHouseId, @Param("dealStatus")Integer dealStatus, @Param("dealStatusJudge")Integer dealStatusJudge, @Param("cinfoType")Byte cinfoType);
	
	List<AdminCityshareBorkerComplaintDto> getListForBaseBeans(@Param("cityId")Integer cityId, @Param("caseId")Integer caseId, @Param("caseType")Byte caseType, @Param("userId")Integer userId);
}
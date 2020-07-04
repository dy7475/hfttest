package com.myfun.repository.reportdb.dao;

import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.repository.reportdb.po.ReportFunUserScoreRecord;
import com.myfun.repository.reportdb.po.ReportFunUserScoreRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportFunUserScoreRecordMapper extends BaseMapper<ReportFunUserScoreRecord, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunUserScoreRecordExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunUserScoreRecordExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunUserScoreRecord> selectByExample(ReportFunUserScoreRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunUserScoreRecord record,
			@Param("example") ReportFunUserScoreRecordExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunUserScoreRecord record,
			@Param("example") ReportFunUserScoreRecordExample example);

	Double countScoreByDate(@Param("cityId")Integer cityId,@Param("compId") Integer compId,
                             @Param("archiveId") Integer archiveId, @Param("startTime")Date startTime,@Param("endTime") Date endTime);

	List<Map<String,Object>> countCompUserScoreListByDate(@Param("cityId")Integer cityId,@Param("compId") Integer compId,
													 @Param("startTime")Date startTime,@Param("endTime") Date endTime);
	
	/**
	 * @param currentMonthTime 当前的月初时间
	 * @param elevenMonthTime 十一个月前的时间
	 * @return 积分详情页的工作积分总数|包含当前月的近12个月工作积分总数(elevenMonthTime != null)
	 */
	Double selectStaffAllOrMeanScore(@Param("compId") Integer compId, @Param("cityId") Integer cityId,
								@Param("archiveId") Integer archiveId, @Param("currentMonthTime") Date currentMonthTime, @Param("elevenMonthTime") Date elevenMonthTime);

	Double selectCurrentMonthScore(@Param("compId") Integer compId, @Param("cityId") Integer cityId,
								@Param("archiveId") Integer archiveId, @Param("currentMonthTime") Date currentMonthTime);

	double countScoreByDateRange(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
								 @Param("rangeColumn")String rangeColumn,@Param("rangeIds") String rangeIds,@Param("startTime") Date startTime);

	List<Map<String,Object>> countCompUserScoreListByDateRange(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
															   @Param("rangeColumn")String rangeColumn,@Param("rangeIds") String rangeIds,
															   @Param("startTime") Date startTime);

	double countScoreByDateRangeNewOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId, @Param("erpOrganizationVOs") List<ErpOrganizationVO> erpOrganizationVOs,
										@Param("startTime") Date startTime);

	List<Map<String, Object>> countCompUserScoreListByDateRangeNewOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
																	@Param("erpOrganizationVOs")List<ErpOrganizationVO> erpOrganizationVOs,
																	@Param("startTime") Date startTime);
}
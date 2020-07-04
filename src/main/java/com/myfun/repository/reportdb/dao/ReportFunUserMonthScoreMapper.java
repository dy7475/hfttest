package com.myfun.repository.reportdb.dao;

import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.repository.reportdb.po.ReportFunUserMonthScore;
import com.myfun.repository.reportdb.po.ReportFunUserMonthScoreExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReportFunUserMonthScoreMapper extends BaseMapper<ReportFunUserMonthScore, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ReportFunUserMonthScoreExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ReportFunUserMonthScoreExample example);

	/**
	 * @mbggenerated
	 */
	List<ReportFunUserMonthScore> selectByExample(ReportFunUserMonthScoreExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ReportFunUserMonthScore record,
			@Param("example") ReportFunUserMonthScoreExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ReportFunUserMonthScore record,
			@Param("example") ReportFunUserMonthScoreExample example);

	Double countScoreBycCompDate(@Param("cityId")Integer cityId,@Param("compId") Integer compId,
                                 @Param("startTime")Date startTime, @Param("endTime")Date endTime);

	List<Map<String,Object>> countCompUserScoreListByDate(@Param("cityId")Integer cityId,@Param("compId") Integer compId,
                                                      @Param("startTime")Date startTime, @Param("endTime")Date endTime);

	double countScoreBycCompDateRange(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
                                      @Param("rangeColumn")String rangeColumn,@Param("rangeIds") String rangeIds,@Param("startTime") Date startTime);

	List<Map<String,Object>> countCompUserScoreListByDateRange(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
															   @Param("rangeColumn")String rangeColumn,@Param("rangeIds") String rangeIds,
															   @Param("startTime") Date startTime);

	double countScoreBycCompDateRangeNewOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId, @Param("erpOrganizationVOs") List<ErpOrganizationVO> erpOrganizationVOs,
											 @Param("startTime") Date startTime);

	List<Map<String, Object>> countCompUserScoreListByDateRangeNewOrg(@Param("cityId") Integer cityId, @Param("compId") Integer compId,
																	@Param("erpOrganizationVOs")List<ErpOrganizationVO> erpOrganizationVOs, 
																	@Param("startTime") Date startTime);
}
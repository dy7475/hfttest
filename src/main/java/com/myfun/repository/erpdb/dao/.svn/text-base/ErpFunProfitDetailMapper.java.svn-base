package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.param.AbormalFunProfitDetailListParam;
import com.myfun.erpWeb.managecenter.profit.vo.UserProfitVo;
import com.myfun.repository.erpdb.dto.ErpAssessCountDataDto;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunProfitDetailDto;
import com.myfun.repository.erpdb.dto.FunWageTmpDataDto;
import com.myfun.repository.erpdb.param.ErpFunProfitDetailParam;
import com.myfun.repository.erpdb.po.ErpFunProfitDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunProfitDetailMapper extends BaseMapper<ErpFunProfitDetail, ErpFunProfitDetail> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProfitDetailExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProfitDetailExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunProfitDetail> selectByExample(ErpFunProfitDetailExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunProfitDetail record,
			@Param("example") ErpFunProfitDetailExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunProfitDetail record,
			@Param("example") ErpFunProfitDetailExample example);

	List<ErpFunDealDto> getProfitList(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);
	Long getProfitCount(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);

	Map<String,Object> getCountData(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param);

	List<FunWageTmpDataDto> abnormalCount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userIdSet") Set<Integer> allUserIdSet,@Param("assessmentMonth") String assessmentMonth);

	/**
	 *查询业绩提成发放下拉列表
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunProfitDetailDto> getPersonFunProfitDetailList(@Param("shardCityId")Integer cityId,@Param("param") AbormalFunProfitDetailListParam param);

	Map<String,Object> getDealDataMap(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);

	List<Integer> countYsAmount(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);
	List<Integer> countSsAmount(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);

	List<Integer> countJsAmount(@Param("shardCityId")Integer cityId, @Param("param")ErpFunProfitDetailParam param,@Param("assessMentMonthSet") Set<String> assessMentMonth);

	void updateDelFagByDealId(@Param("shardCityId")Integer cityId,@Param("dealId") Integer dealId,@Param("delFlag") Integer delFlag);
	
	
	/**
	 * 个人战绩-个人提成统计列表数据
	 * compId：erp库的compId
	 * queryMonth：格式：2019-01
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月3日 下午3:53:43
	 */
	List<ErpAssessCountDataDto> getAssessCountData(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("queryMonth") String queryMonth);

	/**
	 * 个人的升降情况数据展示
	 * 查询个人总业绩
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年10月12日 下午6:07:38
	 */
	List<UserProfitVo> getUserAllIncomeAmount(@Param("shardCityId")Integer shardCityId, @Param("compId")Integer compId,@Param("archiveIds")Set<Integer> archiveIds);
}
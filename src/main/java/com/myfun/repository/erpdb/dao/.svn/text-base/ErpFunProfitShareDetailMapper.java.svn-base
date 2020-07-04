package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.param.AbormalFunProfitDetailListParam;
import com.myfun.erpWeb.managecenter.profit.vo.PersonShareProfitDetailVO;
import com.myfun.erpWeb.managecenter.profit.vo.UserProfitVo;
import com.myfun.repository.erpdb.po.ErpFunProfitShareDetail;
import com.myfun.repository.erpdb.po.ErpFunProfitShareDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunProfitShareDetailMapper extends BaseMapper<ErpFunProfitShareDetail, ErpFunProfitShareDetail> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunProfitShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunProfitShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunProfitShareDetail> selectByExample(ErpFunProfitShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunProfitShareDetail record, @Param("example") ErpFunProfitShareDetailExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunProfitShareDetail record, @Param("example") ErpFunProfitShareDetailExample example);

	void auditFunWage(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,@Param("signUserIdSet") Set<Integer> signUserIdSet,@Param("assessmentMonth") String assessmentMonth);

	List<PersonShareProfitDetailVO> getPersonShareProfitDetailList(@Param("shardCityId") Integer cityId,
			@Param("param")AbormalFunProfitDetailListParam param);
	
	
	List<ErpFunProfitShareDetail> getShareProfitDetailList(@Param("shardCityId") Integer cityId,
			 @Param("compId")Integer compId, @Param("userId") Integer userId,@Param("queryMonth") String queryMonth);

	List<UserProfitVo> getUserTeamAmount(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,@Param("userIds") Set<Integer> userIds);

	void deleteProfitDetail(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealId")Integer dealId);
}
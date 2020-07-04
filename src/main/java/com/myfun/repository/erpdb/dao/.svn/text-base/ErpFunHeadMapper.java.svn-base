package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.common.vo.ErpFunHeadVo;
import com.myfun.repository.erpdb.po.ErpFunHead;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunHeadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunHeadMapper extends BaseMapper<ErpFunHead, ErpFunHead> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunHeadExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunHeadExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunHead> selectByExample(ErpFunHeadExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunHead record, @Param("example") ErpFunHeadExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunHead record, @Param("example") ErpFunHeadExample example);

    List<ErpFunHeadVo> getHeadVoListByCompId(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,@Param("headShow")Byte headShow, @Param("caseType")Byte caseType);

    void deleteFunHead(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("funHeads") List<ErpFunHead> funHeads);
}
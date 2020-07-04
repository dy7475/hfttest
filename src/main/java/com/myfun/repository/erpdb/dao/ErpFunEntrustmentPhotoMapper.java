package com.myfun.repository.erpdb.dao;


import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.myfun.repository.erpdb.po.ErpFunEntrustmentPhoto;
import com.myfun.repository.erpdb.po.ErpFunEntrustmentPhotoExample;

public interface ErpFunEntrustmentPhotoMapper extends BaseMapper<ErpFunEntrustmentPhoto, ErpFunEntrustmentPhoto> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEntrustmentPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEntrustmentPhotoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEntrustmentPhoto> selectByExample(ErpFunEntrustmentPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEntrustmentPhoto record,
			@Param("example") ErpFunEntrustmentPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEntrustmentPhoto record,
			@Param("example") ErpFunEntrustmentPhotoExample example);

	/**
	 * 覆盖房源委托书附件信息
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param caseId
	 */
	 public void updateFunEntrustmentToInvalid(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseType")Integer caseType,@Param("caseId")Integer caseId);
	
	/**
	 *  更新委托书附件的房源相关信息
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param cityId
	 * @param compId
	 * @param trackId
	 */
	public void updateFunEntrustmentCaseInfo(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("trackId")Integer trackId);
}
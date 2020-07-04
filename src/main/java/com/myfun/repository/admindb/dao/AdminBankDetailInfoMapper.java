package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminBankDetailInfo;
import com.myfun.repository.admindb.po.AdminBankDetailInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminBankDetailInfoMapper extends BaseMapper<AdminBankDetailInfo, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminBankDetailInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminBankDetailInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminBankDetailInfo> selectByExample(AdminBankDetailInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminBankDetailInfo record,
			@Param("example") AdminBankDetailInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminBankDetailInfo record,
			@Param("example") AdminBankDetailInfoExample example);
}
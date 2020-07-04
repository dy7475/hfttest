package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminZfbTransDetail;
import com.myfun.repository.admindb.po.AdminZfbTransDetailExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminZfbTransDetailMapper extends BaseMapper<AdminZfbTransDetail, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminZfbTransDetailExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminZfbTransDetailExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminZfbTransDetail> selectByExample(AdminZfbTransDetailExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminZfbTransDetail record,
			@Param("example") AdminZfbTransDetailExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminZfbTransDetail record,
			@Param("example") AdminZfbTransDetailExample example);
}
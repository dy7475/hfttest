package com.myfun.repository.searchdb.dao;

import com.myfun.repository.searchdb.po.SosoView;
import com.myfun.repository.searchdb.po.SosoViewExample;
import com.myfun.repository.searchdb.po.SosoViewKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SosoViewMapper extends BaseMapper<SosoView, SosoViewKey> {

	/**
	 * @mbggenerated
	 */
	int countByExample(SosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(SosoViewExample example);

	/**
	 * @mbggenerated
	 */
	List<SosoView> selectByExample(SosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") SosoView record, @Param("example") SosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") SosoView record, @Param("example") SosoViewExample example);
}
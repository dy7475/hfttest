package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminBulletinPsDto;
import com.myfun.repository.admindb.po.AdminBulletinPs;
import com.myfun.repository.admindb.po.AdminBulletinPsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminBulletinPsMapper extends BaseMapper<AdminBulletinPs, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminBulletinPsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminBulletinPsExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminBulletinPs> selectByExample(AdminBulletinPsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminBulletinPs record,
			@Param("example") AdminBulletinPsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminBulletinPs record, @Param("example") AdminBulletinPsExample example);
	
	/**
	 * 通过帖子ID获取列表
	 * @author 张宏利
	 * @since 2018年2月10日
	 * @param bulletId
	 * @return
	 */
	List<AdminBulletinPsDto> getListByBulletId(Integer bulletId);
}


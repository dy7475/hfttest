package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.dto.AdminBulletViewLogDto;
import com.myfun.repository.admindb.po.AdminBulletViewLog;
import com.myfun.repository.admindb.po.AdminBulletViewLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminBulletViewLogMapper extends BaseMapper<AdminBulletViewLog, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminBulletViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminBulletViewLogExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminBulletViewLog> selectByExample(AdminBulletViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminBulletViewLog record,
								 @Param("example") AdminBulletViewLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminBulletViewLog record,
						@Param("example") AdminBulletViewLogExample example);

	List<AdminBulletViewLogDto> getViewCount(@Param("bulletIds")List<Integer> bulletIds);

	AdminBulletViewLogDto getViewCountByBulletId(@Param("bulletId") Integer bulletId);
}
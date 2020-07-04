package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminWeiUserInfo;
import com.myfun.repository.admindb.po.AdminWeiUserInfoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminWeiUserInfoMapper extends BaseMapper<AdminWeiUserInfo, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminWeiUserInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminWeiUserInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminWeiUserInfo> selectByExample(AdminWeiUserInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminWeiUserInfo record,
			@Param("example") AdminWeiUserInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminWeiUserInfo record, @Param("example") AdminWeiUserInfoExample example);

	List<AdminWeiUserInfo> getList(@Param("compNo") String compNo, @Param("deptNo") String deptNo);

    String getUserRoleId(@Param("userId")Integer userId);
}
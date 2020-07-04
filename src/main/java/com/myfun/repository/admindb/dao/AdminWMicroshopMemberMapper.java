package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminWMicroshopMember;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminWMicroshopMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminWMicroshopMemberMapper extends BaseMapper<AdminWMicroshopMember, String> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminWMicroshopMemberExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminWMicroshopMemberExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminWMicroshopMember> selectByExample(AdminWMicroshopMemberExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminWMicroshopMember record,
			@Param("example") AdminWMicroshopMemberExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminWMicroshopMember record,
			@Param("example") AdminWMicroshopMemberExample example);
}
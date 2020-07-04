package com.myfun.repository.admindb.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.PrivilegesDto;
import com.myfun.repository.admindb.dto.UserRoleDto;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCrmUserMapper extends BaseMapper<AdminCrmUser, Integer> {
	public AdminCrmUser getValidUserByLoginId(String userLoginid);

	 /**
     * 获取部门员工信息
     * @param deptId
     * @return
     */
	public ArrayList<SelectDto> getUserByDeptId(@Param("compId")Integer compId, @Param("deptId")String deptId, @Param("userName")String userName);
	

	/**
	 * 获取审核人信?
	 * 
	 * @param compId
	 * @param inputValue
	 * @return
	 */
	public ArrayList<SelectDto> getCrmUsersByCompIdAndInputValue(@Param("compId") Integer compId,
			@Param("inputValue") String inputValue);

	public ArrayList<AdminCrmUser> getUsers(String grId);

	/**
	 * 查询是否有员?
	 * 
	 * @param compId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	public int count(@Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("grId") Integer grId);

	public int countUserByMobile(String userMobile);

	public Integer getId();

	public AdminCrmUser getUserInfo();

	public ArrayList<AdminCrmUser> getUsersByCompId(Integer compId);

	public void writeOff(Integer compId);

	public ArrayList<AdminCrmUser> getUsesByCompId(@Param("compId") String compId);

	public ArrayList<AdminCrmUser> getUsesByOperId();

	/**
	 * 获取财务管理?
	 * 
	 * @param compId
	 * @return
	 */
	public AdminCrmUser getFinanceManagerUses(Integer compId);

	public AdminCrmUser selectByCompId(Integer compId);

	/**
	 * 查询公司信息
	 * 
	 * @param superCompId
	 * @param string
	 * @return
	 */
	public AdminCrmUser selectUserByCompIdAndUserPostion(@Param("superCompId") Integer superCompId,
			@Param("userPosition") String userPosition);

	public ArrayList<UserRoleDto> getUsersByCompIdAndDeptId(AdminCrmUser adminCrmUser);

	public ArrayList<PrivilegesDto> getPrivilegeByRoleId(String userPosition);

	public List<AdminCrmUser> getUserListByNotNull(AdminCrmUser adminCrmUser);

	public void updateCrmUserByUserIds(@Param("upCrmUser") AdminCrmUser upCrmUser, @Param("array") Integer[] userIds);

	public List<AdminCrmUser> selectAgentUserWithPriv(AdminCrmUser crmUser);

	/**
	 * 根据?发商与userName模糊查询
	 * @param compId
	 * @param userName
	 * @return
	 */
	public List<AdminCrmUser> getUsesByCompIdAndUserName(@Param("compId") Integer compId, @Param("userName") String userName);
	
	/**
	 * 清空小组人员
	 * @param deptId
	 * @param grId
	 */
	public void clearGroupUserIds(@Param("deptId")Integer deptId, @Param("grId")Integer grId);
	
	/**
	 * 查询crmUserIds
	 * @param crmUserIds
	 * @return
	 */
	public List<AdminCrmUser> getCrmUserListByIds(@Param("crmUserIds")List<String> crmUserIds);

}
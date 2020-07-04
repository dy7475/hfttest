package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.common.vo.ErpCompRolesVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetRoleByCompIdVo;
import com.myfun.repository.erpdb.po.ErpFunRoles;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpCompRolesExample;

public interface ErpCompRolesMapper extends BaseMapper<ErpCompRoles, ErpCompRoles> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpCompRolesExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpCompRolesExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpCompRoles> selectByExample(ErpCompRolesExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpCompRoles record, @Param("example") ErpCompRolesExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpCompRoles record, @Param("example") ErpCompRolesExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpCompRoles getCompRoleByUserEdition(
			@Param("shardCityId")Integer cityId, @Param("userPosition")String userEdition, @Param("compId")Integer compId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpCompRoles> getCompRoleListByRoleId(
			@Param("shardCityId")Integer cityId, @Param("userPosition")String userEdition, @Param("compId")Integer compId);
	
	/**
	 * 查询nowRole小于role的对?
	 * @author 张宏?
	 * @since 2017?10?16?
	 * @param cityId
	 * @param compId
	 * @param role
	 * @param nowRole
	 * @return
	 */
	ErpCompRoles getLowerRoles(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("role")String role, @Param("nowRole")String nowRole, @Param("isMix")Boolean isMix);
	
	/**
	 * 获取当前顺序
	 * @author 张宏?
	 * @since 2017?11?1?
	 * @param cityId
	 * @param compId
	 * @return
	 */
	int getNextRoleSeq(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
	
	/**
	 * 把大于seqNow?+1，留下一个位?
	 * @author 张宏?
	 * @since 2017?11?3?
	 * @param cityId
	 * @param compId
	 * @param seqNow
	 */
	void addSeqForRight(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId, @Param("seqNow")Integer seqNow);
	
	/**
	 * 通过roleId获取角色对象
	 * @author 张宏?
	 * @since 2017?11?6?
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param roleId 角色ID
	 * @return
	 */
	ErpCompRoles getByRoleId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);
	
	/**
	 * 修改角色顺序
	 * @author 张宏?
	 * @since 2017?11?13?
	 * @param cityId
	 * @param compId
	 * @param roleIds
	 */
	void updateRoleSeq(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleIdArr")String[] roleIdArr);
	
	/**
	 * 获取公司?有角色列?
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpCompRoles> getAllCompRole(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * 获取角色名的数量
	 * @param cityId
	 * @param compId
	 * @param roleName
	 * @return
	 */
	int countByRoleName(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleName")String roleName);
	
	/**
	 * 修改角色名字
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018?3?6?
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRoleNameByRoleId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId, @Param("roleName")String roleName, @Param("partStatistCount") Byte partStatistCount);
	
	/**
	 * 获取比自己低的角色列?
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/17
	 * @return 
	 * 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@AccessReadonlyDb
	List<ErpCompRoles> getLowerRolesList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("userPosition") String userPosition,@Param("isMix") Boolean isMix, @Param("propertyFlag") Boolean propertyFlag);

	/**
	 * 获取比自己低的角色列?
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/17
	 * @return
	 *
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@AccessReadonlyDb
	List<ErpCompRolesVo> getLowerRolesVoList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userPosition") String userPosition, @Param("isMix") Boolean isMix);
	
	/**
     * 根据公司ID查询出角色ID、角色名称、序号
     * @author LI XIAO TONG
     * @since 2019年8月28日 上午11:20:23
     * @param cityId
     * @param compId
     * @return
     * Modified XXX Li Xiao Tong 2019年8月28日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<GetRoleByCompIdVo> getRoleByCompId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);
    
    /**
     * 获取该公司牌面最低的角色ID
     * @author LI XIAO TONG
     * @since 2019年8月30日 下午7:50:01
     * @param cityId
     * @param compId
     * @return
     * Modified XXX Li Xiao Tong 2019年8月30日
     */
	String getLowRole(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);
	
	ErpCompRoles getMaxSeq(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId);

	ErpCompRoles getByCompId(@Param("shardCityId")Integer cityId, @Param("erpCompId") Integer erpCompId);

}



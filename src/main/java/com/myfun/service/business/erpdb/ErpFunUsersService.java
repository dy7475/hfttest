package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.profit.param.SetSalaryPlanManagerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.CreateUserParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.EditUserInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.InsertGroupData;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateUserInfoParam;
import com.myfun.erpWeb.openApi.inviteRegist.param.BrokerShareRegisterParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dto.AdminFunActivityRegisterDto;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminInviteRegistErp;
import com.myfun.repository.erpdb.dto.ErpFunDeptsgroupDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.dto.ErpUsersInfoDto;
import com.myfun.repository.erpdb.param.DeleteUsersParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface ErpFunUsersService extends BaseMapper<ErpFunUsers, Integer> {
	/**
	 * 修改密码
	 * 
	 * @param mobile
	 *            电话
	 * @param loginPwd
	 *            密码
	 */
	public void editPwd(String mobile, String loginPwd);
	
	/**
	 * 根据电话号码查询
	 * @param shardCityId
	 * @param userMobile
	 */
	public ErpFunUsers selectObjectByMobile(String shardCityId, String userMobile);
	
	/**
	 * 查询；对象
	 * @param cityId
	 * @param ccUserId
	 * @return
	 */
	public ErpFunUsers getUserInfoByUserId(Integer cityId, Integer ccUserId);
	
	/**
	 * 获取公众号报名经纪人
	 */
	public List<AdminFunActivityRegisterDto> getRegisterList(ErpFunUsers users);
	
	/**
	 * 获取用户信息
	 * @param compId
	 * @param compId2
	 * @param userMobile
	 * @return
	 */
	public ErpFunUsers selectObjectByMobileAndCompId(Short cityId, Integer compId, String userMobile);

	/**
	 * 根据archiveId查询用户信息
	 * @param archiveId
	 * @return
	 */
	public ErpFunUsers selectByArchiveId(Short cityId, Integer archiveId);

	public ErpFunUsers getUserByArchiveId(String archiveId, String shardCityId);

	public ErpFunUsersDto getUsersByArchiveId(Integer archiveId, Integer cityId);

	public int resetPwd(Integer archiveId, AdminCrmUser user) throws ParseException;

	public int getCountByUserNo(Short cityId, String userNo);

	public int updateByMobile(ErpFunUsers erpFunUsers);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param creatorUid
	 * @return
	 */
	
	
	public ErpFunUsers selectUserNameByUserId(Integer cityId, Integer creatorUid);

	/**
	 * @TODO 获取楼盘管理员
	 * @author lcb
	 * @2016-9-20 上午10:22:48
	 */
	public ErpFunUsers getDistCompRealAdmin(BaseMapParam param);
	/**
	 * @TODO 获取楼盘管理员
	 * @author lcb
	 * @2016-9-20 上午10:22:48
	 */
	public ErpFunUsers getDistBuildInfoAdmin(BaseMapParam param);

	/**
	 * @TODO 设置楼盘管理员
	 * @author lcb
	 * @2016-9-28 上午10:03:07
	 */
	public Integer setDistCompRealAdmin(BaseMapParam param);
	/**
	 * @Date:2016-9-24
	 * @Athor:方李骥
	 * @Title: selectUserByUserMobile 
	 * @Description: TODO(业务工具里面-生成电子名片的时候客户电话与本公司人员进行匹配) 
	 * @param cityId
	 * @param compId
	 * @return   
	 * @return List<ErpFunUsers>    返回类型 
	 * @throws
	 */
	public ErpFunUsers selectUserByUserMobile(Integer cityId,Integer compId, String[] phoneArr);


	public List<ErpFunUsers> getUserListByCompId(Integer cityId, Integer compId);

	/**
	 * @TODO 查询经纪人详细信息
	 * @author lcb
	 * @2016-10-19 下午2:00:06
	 * @throws Exception 
	 */
	public ErpFunUsersDto getUserInfoData(BaseMapParam param) throws Exception;

	public List<ErpFunPersonnelLevels> getPersonnelLevelList(BaseMapParam param);

	public List<ErpFunRecruitmentChannel> getRecruitmentChannelList(BaseMapParam param);

	/**
	 * @TODO 删除职级
	 * @author lcb
	 * @2016-10-19 下午4:30:08
	 */
	public Integer delPersonnelLevel(BaseMapParam param);

	/** 删除入职渠道
	 * @TODO
	 * @author lcb
	 * @2016-10-19 下午4:34:40
	 */
	public Integer delRecruitmentChannel(BaseMapParam param);

	/**
	 * @TODO
	 * @author lcb 
	 * 2016-10-21 下午5:03:50
	 */
	public Integer getRegisterUserStatus(BaseMapParam param);


	/** 
		添加分组
	 **/
	public Integer insertMgrGroupData(InsertGroupData param) throws Exception;

	/**
	 * 删除分组
	 * **/
	public Integer deleteMgrGroupData(BaseMapParam param);

	public Map<String, Object> getRegistManagerUser(Integer cityId,Integer compId);
	
	public List<ErpFunUsers> getRangeUserList(ErpFunUsers condition, Integer cityId);
	/**
	 * @TODO 查询分组信息
	 * @Author lcb
	 * @2016-10-22 上午10:53:02
	 **/
	public ErpFunDeptsgroupDto getGroupData(BaseMapParam param);

	public void updateUserStatusBySysPara(Integer userId, Integer cityId, Integer compId);

	/**
	 * @TODO 重置密码
	 * @Author lcb
	 * @2016-10-27 下午3:45:09
	 **/
	public Integer updateMgrResetUserPWData(BaseMapParam param) throws Exception;

	/**
	 *
	 * **/
	void updateMgrUserUseState(BaseMapParam param, ErpFunUsers erpFunUsers, String userName);

	/**
	 * 更新门店信息
	 **/
	void updateMgrDeptData(BaseMapParam param) throws Exception;

	// 查询用户泪飙
	Map<String, Object> getUserInfoList(BaseMapParam param);

	/**
	 * 获取用户列表根据userIds,注意sql显示的IN里面只能是两千个IDS,
	 * 
	 * @Author 一个渣渣flj @2017-03-03 下午3:45:09
	 **/
	public List<ErpFunUsers> getUserListByUserIds(Integer cityId,Set<Integer> userIds);

	public String getCurrUserName(ErpCreateTrackInfoParam param);
	public String getCurrUserName(Integer cityId, Integer userId, Integer deptId);

	/**
	 * 邀请注册
	 * @author 张宏利
	 * @since 2017年5月9日
	 * @param inviteRegistErp
	 * @param serviceReg
	 * @param serviceZone
	 * @param pwd
	 * @param repwd
	 * @return
	 */
	boolean registByInvite(AdminInviteRegistErp inviteRegistErp, String serviceReg, String serviceZone, String serviceZoneIds, String pwd, ErpFunDepts erpFunDepts);
	
	/**
	 * 踢人
	 * @author flj
	 * @since 2017年5月18日
	 * @param archiveId
	 * @return
	 */
	void endLoginUser(Integer archiveId, String userMobile, LogInEnum logInEnum);

	/**
	 * 踢某门店的人
	 * @author flj
	 * @since 2017年5月18日
	 * @param deptId
	 * @return
	 */
	void endLoginDeptUser(Integer cityId, Integer compId, Integer deptId, LogInEnum logInEnum);
	
	/**
	 * 踢某门店的人
	 * @author flj
	 * @since 2017年5月18日
	 * @param deptId
	 * @return
	 */
	void endLoginCompUser(Integer cityId, Integer compId, LogInEnum logInEnum);

	/**
	 * 设置薪资分配管理人员
	 * @author flj
	 * @since 2017年5月18日
	 * @param deptId
	 * @return
	 */
	public void setSalaryPlanManager(SetSalaryPlanManagerParam param, Integer userId);
	
	/**
	 * 清除缓存
	 * @author 张宏利
	 * @since 2017年5月25日
	 * @param erpFunUsers
	 */
	void evict(ErpFunUsers erpFunUsers);
	
	void evictBaseInfoByCompId(Integer cityId, Integer compId);

	/**
	 * 根据不同维度获取员工人数
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param cityId 分库
	 * @param compId 公司ID
	 * @param serchRange 范围， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param serchRangeId 范围ID
	 * @param dimension 维度， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param writeoff 是否注销，0=未注销 1=已注销
	 * @return 分组时返回的dim为：deptId_grId
	 */
	Map<String, Integer> getUserCountByRange(Integer cityId, Integer compId, 
			String serchRange, Integer serchRangeId,
			String dimension, Integer writeoff,Integer userId
			);
	
	/**
	 * 根据不同维度-各时间段员工人数
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param cityId 分库
	 * @param compId 公司ID
	 * @param serchRange 范围， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param serchRangeId 范围ID
	 * @param dimension 维度， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param writeoff 是否注销，0=未注销 1=已注销
	 * @return 分组时返回的dim为：deptId_grId
	 */
	public Map<String, Map<String, Integer>> getUserCountDateList(Integer cityId, Integer compId, 
			String serchRange, Integer serchRangeId, String dimension, Integer writeoff,
			String dateCountType, String startTime, String endTime
			);
	
	/**
	 * 查询一个时间段内的员工人数
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param cityId 分库
	 * @param compId 公司ID
	 * @param serchRange 范围， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param serchRangeId 范围ID
	 */
	public Integer getUserCountByTimeRange(Integer cityId, Integer compId, 
			String serchRange, Integer serchRangeId, String startTime, String endTime
			);
	
	public ErpUsersInfoDto getUserInfoByUserId(Integer cityId, Integer compId, Integer userId, boolean areaFlagVal);

	Integer setBespokeModuleManager(Integer cityId, Integer compId, Integer userId);
	
	/**
	 * 由下往上找存在该角色的员工列表
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId
	 * @param compId
	 * @param auditRoleId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	public List<Integer> getManageUserByUp(Integer cityId, Integer compId, String auditRoleId, Integer areaId,
			Integer regId, Integer deptId, Integer grId, Optional<Integer> nowRange);
	
	/**
	 * 由下往上找存在有权限的员工列表
	 * @param cityId
	 * @param compId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	public List<Integer> getHaveAuditUserListForKey(Integer cityId, Integer compId, Integer areaId, Integer regId,
			Integer deptId, Integer grId);
	
	/**
	 * 由下往上找存在有权限的员工列表
	 * @param cityId
	 * @param compId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	public List<Integer> getHaveAuditUserListForExamin(Integer cityId, Integer compId, Integer areaId, Integer regId,
			Integer deptId, Integer grId);
	
	ErpFunUsers writeOffUser(DeleteUsersParam param, ErpFunUsers funUsersSel, String createUserName) ;

	ErpFunUsers createUser(ErpFunUsers createUser, CreateUserParam param,Integer currentPId, boolean isFangJidi);

	ErpFunUsers createUserNew(ErpFunUsers createUser, CreateUserParam param,Integer currentPId, boolean isFangJidi, String createUserName);

	Map<String,Object> createInvitedUser(BrokerShareRegisterParam param);

	void updateUserInfo(UpdateUserInfoParam param);

	void updateUserManageRange(Integer userId,String userPosition, String rangeIds, Integer rangeType, CreateUserParam param, boolean isFangJidi);

	List<ErpFunUsers> getTaskUserList(Integer cityId, Integer dealId, Integer taskType, Integer compId, Integer userId);

	void updateForMobile(GeneralParam generalParam, String mobile);
	
	/**
	 * 充值刷新用户会话O2O_FLAG,SUPER_USER
	 */
	void refreshUserOperator(Integer archiveId, Integer cityId, String compNo, String deptNo, Integer refreshType);

	/**
	 * 更新工资审核人
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/21
	 */
	void updateShenheUserFlag(Integer cityId, Integer compId, String[] userIds);

	void updateUserStatus(Integer cityId, Integer compId, Integer userId, Integer closeOrOpen);

	void updateFloorMgrManager(Integer cityId, Integer compId, String userId, String deptId);

	/**
	 * 编辑用户角色
	 * @Package com.myfun.service.business.erpdb
	 * @author 陈文超
	 * @date 2019年7月27日 下午3:18:52
	 */
	void updateUserRole(Integer cityId, Integer compId, Integer userId, String roleId, Integer roleLevelId,
						Integer currentUserId,Integer inviteId, String createUserName);

	/**
	 * 修改员工职级
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超
	 * @date 2019年7月30日 下午4:07:14
	 */
	void updateUserRoleLevel(Integer cityId, Integer compId, Integer userId, Integer roleLevelId, Integer currentUserId);
	
	void editUserInfo(GeneralParam generalParam, EditUserInfoParam param);

	List<ErpUserOpers> getUpdateUserOpers(Integer cityId, Integer userId);

	ErpFunUsers getGeneralManagerByCompId(Integer cityId, Integer compId);

	int checkDeptUserNum(Integer cityId,Integer deptId,boolean updateRoleFlag,String roleId);

	void initWageData(ErpFunUsers funUsersPO, Integer opType);
	void initWageData(Integer cityId, Integer userId, Integer opType);

	void setCompConmmonAdmin(Integer cityId, Integer compId, Integer compType, Integer userId,  Integer currentUserId, boolean isFangJidi);
	
	void updateUser(Integer cityId, ErpFunUsers updateModel); 
	
	public void sendRegistrationAuditMsg(ErpFunUsers funUsers,Integer currentPId,Integer cityId);

	void updateUserStatusBySysParaByOrg(Integer userId, Integer cityId, Integer compId, List<Integer> orgIds);
	
	public void endLoginMoveOrgUser(Integer cityId, Integer compId, Integer orgId, LogInEnum logInEnum); 
	
	Map<Integer, UserOrganizationInfoVO> getUserOrganizationInfoByUserIds(Integer cityId, List<Integer> userIdList);

	// modify lcb 修改于 2020/5/25 修改用户手机号逻辑
	public void modifyUserUserMobile(Integer cityId, Integer archiveId, String userMobile, Integer selfUserId);

	void configureUserKPI(Integer cityId, ErpFunUsers funUsers);

	/**
	 * 初始化kpi数据记录
	 * @param cityId
	 * @param userId
	 */
	void initKpiStatisticRecord(Integer cityId,Integer userId);

	/**
	 * 失效某个经纪人kpi配置方案
	 * @param cityId
	 * @param userId
	 */
    void invalidOriginKpiConfig(Integer cityId, Integer userId);

	/**
	 * 角色变更关联修改KPI配置方案
	 * @param cityId
	 * @param funUsers
	 */
	void configureUserKPIForPositionModify(Integer cityId, ErpFunUsers funUsers);
}

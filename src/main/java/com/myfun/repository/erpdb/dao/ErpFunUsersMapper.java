package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.vo.BrokerOrganizationVO;
import com.myfun.erpWeb.managecenter.constract.vo.FunUserOrgVo;
import com.myfun.erpWeb.managecenter.constract.vo.UserPositionAndLevelDto;
import com.myfun.erpWeb.managecenter.profit.param.AssessCountDataParam;
import com.myfun.erpWeb.managecenter.profit.param.PerformanceAssessmentCountListParam;
import com.myfun.erpWeb.managecenter.profit.vo.AssessRoleCountDataVo;
import com.myfun.erpWeb.managecenter.sysmanager.param.InsertGroupData;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetAllCompUserVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetCompNotInviteUserRoleVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.WriteoffUserListVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpUserDeptNameVo;
import com.myfun.erpWeb.managecenter.userOpers.vo.GetCrossCompUserVO;
import com.myfun.erpWeb.usercenter.vo.GetOrganizationUserVo;
import com.myfun.repository.admindb.param.AdminCrmPresentParam;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.param.ErpAttendanceStatisticalAnalysisParam;
import com.myfun.repository.erpdb.param.ErpFunUsersParam;
import com.myfun.repository.erpdb.po.ErpFunAssessmentStatistics;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.*;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.service.business.erpdb.impl.ErpFunUsersServiceImpl;
import com.myfun.utils.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.*;
import java.util.List;

@SwitchDB(type = SwitchDBType.COMP_ID)
public interface ErpFunUsersMapper extends BaseMapper<ErpFunUsers, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunUsersExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunUsersExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunUsers> selectByExample(ErpFunUsersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunUsers record, @Param("example") ErpFunUsersExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunUsers record, @Param("example") ErpFunUsersExample example);

	List<ErpFunUsers> selectByUserNameExample(ErpFunUsersExample erpFunUsersExample);

	/**
	 * 根据条件获取用户列表<br/>
	 * (调用时注意,如果不符需求则另写方法)如果设置跨店（alldeptFlag）条件 where条件 （deptId or alldeptFlag）
	 * 
	 * @param erpFunUsersCondition
	 * @return
	 */
	List<ErpFunUsers> getUserListByNotNull(ErpFunUsers erpFunUsersCondition);

	/**
	 * 获取跨店登录
	 * 
	 * @param erpFunUsersCondition
	 * @return
	 */
	List<ErpFunUsers> getUserListByAllDept(ErpFunUsers erpFunUsersCondition);
	
	@SwitchDB(type = SwitchDBType.ARCHIVE_ID)
	ErpFunUsers getValidUserByArchiveId(Integer shardArchiveId);
	/**
	 * 根据电话号码查询对象信息
	 * @param shardCityId
	 * @param userMobile
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers selectObjectByMobile(@Param("shardCityId")String shardCityId, @Param("userMobile")String userMobile);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getRangeUserNotUserWriteoffList(@Param("shardCityId")Integer cityId,
			@Param("param")ErpFunUsers condition);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers getUserInfoByUserId(@Param("shardCityId")Integer cityId, @Param("userId")Integer ccUserId);
	
	@SwitchDB(type = SwitchDBType.COMP_ID)
	List<ErpFunUsers> getUsersByCompIdDeptIdAndachiveIDs(@Param("shardCompId")Integer compId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers selectObjectByMobileAndCompId(@Param("shardCityId")Short cityId, @Param("compId")Integer compId, @Param("userMobile")String userMobile);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers queryinfoByArchiveId(@Param("shardCityId")Short cityId, @Param("archiveId")Integer archiveId);
	
	/**
	 * 查询用户对象
	 * @param erpFunUsers
	 * @return
	 */
	ErpFunUsers selectByObj(ErpFunUsers erpFunUsers);

	void updatePhoneNum(ErpFunUsersParam erpFunUsers);
	
	/**
	 * 查询门店员工
	 * @param erpCompId
	 * @param erpDeptId
	 * @param i
	 * @return
	 */
	List<ErpFunUsers> selectByCompIdAndDeptidAndUserWOff(@Param("shardCompNo")String compNo, @Param("erpCompId")Integer erpCompId, @Param("erpDeptId")Integer erpDeptId, @Param("userOff")Integer userOff);
	
	/**
	 * 为用户注册精英版
	 * @param cityId 
	 * @param compNo
	 * @param erpCompId
	 * @param erpDeptId
	 */
	void batchInsert(@Param("shardCityId")Integer cityId, @Param("compNo")String compNo, @Param("erpCompId")Integer erpCompId, @Param("erpDeptId")Integer erpDeptId);
	
	/**
	 * erp用户设置为停用
	 * @param erpCompId
	 * @param erpDeptId
	 * @param i
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateByCompIdAndDeptIdAndWuserOff(@Param("shardCityId")Integer cityId, @Param("erpCompId")Integer erpCompId, @Param("erpDeptId")Integer erpDeptId, @Param("userOff")int userOff);
	@SwitchDB(type = SwitchDBType.COMP_ID)
	void insertSysMsg(AdminCrmPresentParam presentParam);

	/**
	 * 根据archiveId查询用户信息
	 * @param archiveId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.ARCHIVE_ID)
	ErpFunUsers selectByArchiveId(@Param("shardArchiveId")Integer archiveId);

	/**
	 * 获取用户信息，公司信息
	 * @param cityId
	 * @param archiveId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsersDto getUsersByArchiveId(@Param("shardCityId")Integer cityId, @Param("archiveId")Integer archiveId);

	int updateByArchiveIdSelective(ErpFunUsers erpFunUsers);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	int getCountByUserNo(@Param("shardCityId")Short cityId, @Param("userNo")String userNo);

	int getCountByUserNo(ErpFunUsers erpFunUsers);

	/**
	 * 获取总经理帐号
	 * @param cityId	城市ID
	 * @param archiveId	档案ID
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsersDto> getManagerUser(@Param("shardCityId")Short cityId, @Param("archiveId")Integer archiveId);

	int getId(Short shardCityId);

	int createUser(@Param("shardCityId")Short cityId, @Param("map")Map<String, Object> map);

	int writeOffUser(ErpFunUsers funUsers);
	
	/**
	 * 获取序列userId
	 * @param cityId
	 * @return
	 */
	int selectSeqUserId(@Param("shardCityId") Integer cityId);
	
	/**
	 * 获取所有人员
	 * @param cityId 
	 * @param enterCompId
	 * @param i
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getRecordsByCompIdAndUserWriteOff(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("userWriteOff")Integer userWriteOff);
	
	/**
	 * 修改用户类型 修改为门店版
	 * @param cityId 
	 * @param enterCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateUserEditionByCompId(@Param("shardCityId") short cityId, @Param("compId")String compId, @Param("userEdition")String userEdition);
	
	/**
	 * 除总经理和分行经理外的所有用户角色换为普通经纪人
	 * @param cityId 
	 * @param enterCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateRecordsByCompId(@Param("shardCityId") short cityId, @Param("shardCompId") String shardCompId);
	
	/**
	 * 删除用户权限
	 * @param cityId 
	 * @param enterCompId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void batchDeleteUserOpers(@Param("shardCityId")short cityId, @Param("shardCompId")String shardCompId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void writeSysMsg(@Param("shardCityId")Short shardCityId, @Param("userId")String userId, @Param("msg")String msg);
	
	/**
	 * 查询先关人员信息
	 * @param compId 公司ID
	 * @param userpostion 权限
	 * @param writeOff 员工状态
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.COMP_NO)
	ErpFunUsers getUserByCompIdAndUserPositionAndUserWriteoff(@Param("shardCompNo") String compNo, @Param("erpCompId")Integer compId, @Param("userpostion")String userpostion, @Param("writeOff")String writeOff);
	
	/**
	 * 该方法需要传入userId
	 * @param funUsers
	 * @return
	 */
	int insertSelectiveNotSeq(ErpFunUsers funUsers);

	/**
	 * 精英版开库转门店版 更新所有的业务数据，调用需谨慎
	 * @param users
	 */
	void updateRelevantBusiness(ErpFunUsersParam users);

	/**
	 * 永久停用，为用户注册精英版
	 * @param cityId
	 * @param cityNo
	 * @param erpCompId
	 * @param erpDeptId
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void eliteUser(@Param("shardCityId") Integer cityId, @Param("cityNo") String cityNo, @Param("erpCompId") Integer erpCompId, @Param("erpDeptId") Integer erpDeptId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getAgentNum(@Param("shardCityId")Integer shardCityId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers selectByUserId(@Param("shardCityId")Integer cityId, @Param("userId")Integer targetUserId);
	
	@SwitchDB(type = SwitchDBType.ARCHIVE_ID)
	String getCompNoByArchiveId(Integer archiveId);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param creatorUid
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers selectUserNameByUserId(@Param("shardCityId")Integer cityId, @Param("userId") Integer userId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<String> getFunUserIds(@Param("shardCityId")Integer cityId, @Param("areaId")String areaId, @Param("compId")Integer compId, @Param("regId")String regId, @Param("grId")String grId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getDeveloperAdmin(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("type")Integer type);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers getFunUsersBaseInfo(@Param("userId")Integer buildingAdmin, @Param("shardCityId")Integer cityId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	String getCurrUserName(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId,  @Param("deptId")Integer deptId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	public List<ErpFunChangeUsersDto> getChangeUsersNewDeptIds(@Param("shardCityId")Integer cityId,
			@Param("compId")Integer compId, @Param("userIds")Set<Integer> userIds);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsersDto getFunUserByArchiveId(@Param("shardCityId")Integer cityId, @Param("archiveId")Integer archiveId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer count(@Param("shardCityId")Integer cityId, @Param("deptId")Integer deptId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getUserCount(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> param,@Param("startTime")String startTime,@Param("endTime")String endTime);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer updateGroupMember(@Param("shardCityId")Integer cityId, @Param("pMap")InsertGroupData pMap);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer addMemberGroup(@Param("shardCityId")Integer cityId, @Param("pMap")InsertGroupData pMap);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getRegistManagerUser(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getRangeUserList(@Param("shardCityId")Integer cityId,@Param("param")ErpFunUsers condition);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateHouseForReg(@Param("shardCityId")Integer cityId, @Param("pMap")Map<String, Object> pMap);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListByUserIds(@Param("shardCityId")Integer cityId,@Param("userIds")Set<Integer> userIds);


	List<ErpFunUsers> getManagerUserListForOrg(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("partnerIds")List<Integer> partnerIds,@Param("whereCause") String whereCause);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListByStringUserIds(@Param("shardCityId")Integer cityId,@Param("userIds")List<String> userIds);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListByUserIdsNotWriteOff(@Param("shardCityId")Integer cityId,@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("userIds")Set<Integer> userIds);
//	@SelectProvider(method ="getInvoiceList", type=ErpFunUsersSqlProvider.class)
//	@ResultType(value = Map.class)
//	List<Map<String,Object>> getInvoiceList(@Param("shardCityId")Integer cityId,@Param("param") BaseMap baseMap) throws Exception;
	
	@SelectProvider(method ="getRangeListDaTaOfComp", type=ErpFunUsersSqlProvider.class)
	@ResultType(value = Map.class)
	List<Map<String, Object>> getRangeListDaTaOfComp(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("archiveId")Integer archiveId,
			@Param("dimension")String dimension,@Param("serchRange")String serchRange,
			@Param("serchRangeId") Integer serchRangeId,@Param("areaFlag") String areaFlag);
	
	@SelectProvider(method ="getRangeListDaTaOfComp", type=ErpFunUsersSqlProvider.class)
	@ResultType(value = Map.class)
	List<Map<String, Object>> getRangeListDaTaOfCompAreaToZero(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("archiveId")Integer archiveId,
			@Param("dimension")String dimension,@Param("serchRange")String serchRange,
			@Param("serchRangeId") Integer serchRangeId,@Param("areaFlag") String areaFlag,
			@Param("areaToZero") String areaToZero,@Param("userId") String userId
		);


	// 测试
	public static void main(String[] args) throws Exception {
		List<String> asList = Arrays.asList("COMP","AREA","REG","DEPT","GROUP","USER");
		for (int i = 1; i < asList.size(); i++) {
			for (int j = i; j < asList.size(); j++) {
				Map<String, Object> pMap = new HashMap<>();
				pMap.put("serchRange", asList.get(i));
				pMap.put("dimension", asList.get(j));
				pMap.put("areaFlag", "1");
				//String rangeListDaTaOfComp = ErpFunUsersSqlProvider.getRangeListDaTaOfComp(pMap);
				//System.out.println(rangeListDaTaOfComp);
				System.out.println();
			}
			System.out.println();
		}
	}

	/**
	 * title ：查询预约带看模块管理员
	 * auhor：lcb
	 * date  : 2017/11/2
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    ErpFunUsers getBespokeModuleManager(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    void setBespokerManage(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListByScopeType(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("mappingDbFiled")String mappingDbFiled, @Param("bizId")Integer bizId);

	List<ErpFunUsersDto> getHasWriteOffUserListByArchiveIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("archiveIds")Set<Integer> archiveIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers getSalaryPlanManager(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	/**
	 * 展开基本工资下拉列表
	 * @param cityId
	 * @param compId
	 * @param param
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunAssessmentStatistics> getWageCountUserList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
														 @Param("param") PerformanceAssessmentCountListParam param);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getAllUserByDeptId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId, @Param("startTime")String startTime);

	List<ErpFunUsers> selectUserList(@Param("shardCityId")Integer cityId, @Param("compId")  Integer compId, @Param("deptId")  Integer deptId, @Param("manageRangeRangeType") Integer manageRangeRangeType,
									 @Param("userManageRangeIds") Set<Integer> userManageRangeIds,@Param("startTime") String startTime);


	List<ErpFunUsers> selectOrgUserList(@Param("shardCityId")Integer cityId, @Param("compId")  Integer compId,
									 @Param("whereCause")String likeWhereCause, @Param("startTime") String startTime);

	List<ErpFunUsers> selectUserListForOrg(@Param("shardCityId")Integer cityId, @Param("compId")  Integer compId, @Param("dbField") String dbField,
									 @Param("orgIds") List<Integer> orgIds,@Param("startTime") String startTime);

	/**
	 * 修改密码
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/16
	 * @return
	 *
	 */
	@SwitchDB(type = SwitchDBType.ARCHIVE_ID)
	void modifyPwd(@Param("shardCityId") Integer cityId, @Param("loginPassword") String loginPassword, @Param("userId") Integer userId);
	
	@SwitchDB(type = SwitchDBType.ARCHIVE_ID)
	void updateUserForArea(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("regId") Integer regId,@Param("areaId") Integer areaId);
	
	/**
	 * 通过compId获取
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers getSalaryManger(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
	
	/**
	 * 根据用户ID获取用户信息
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/27
	 * @return
	 *
	 */
	@AccessReadonlyDb
	ErpFunUsers selectDataByUserId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("userId") Integer userId);

	/**
	 * 根据部门ID获取列表数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/27
	 * @return
	 *
	 */
	@AccessReadonlyDb
	List<ErpFunUsers> getUserListByDeptId(@Param("shardCityId") Integer cityId,@Param("deptId") Integer deptId);
	/**
	 * 根据部门ID获取列表数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/27
	 * @return
	 *
	 */
	@AccessReadonlyDb
	List<ErpFunUsers> getUserListByOrganizationId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("organizationId") Integer organizationId);

	/**
	 * 根据部门ID获取列表数据(在startTime和endTime之间注销的用户也一并查出)
	 * @param
	 * @auther 陈志强
	 * @since 2018/12/4
	 * @return
	 *
	 */
	@AccessReadonlyDb
	List<ErpFunUsers> getUserListByDeptIdAndInWriteOffTime(@Param("shardCityId") Integer cityId, @Param("deptId") Integer deptId,
														   @Param("startTime") String startTime, @Param("endTime") String endTime);
	
	/**
	 * 根据用户和部门ID查询数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/7
	 * @return
	 *
	 */
	ErpFunUsers getByUserIdAndDeptId(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("deptId") Integer deptId);

	List<ErpFunUsers> getFunUsersByGrId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("grId") Integer grId,@Param("userIdsList") List<Integer> userIdsList);

	/**
	 * @tag 用户列表，组织机构用
	 * @author 邓永洪
	 * @param integer 
	 * @since 2018/7/31
	 */
	@AccessReadonlyDb
	List<ErpFunUsersDto> getFunUsersDtoList(@Param("shardCityId")Integer cityId,@Param("param")ErpFunUsers condition, @Param("sortType")Integer sortType, @Param("orderBy")String orderBy,
											@Param("headCharacter")String headCharacter,@Param("isHeadquarters")Byte isHeadquarters, @Param("allUsersFlag")Integer allUsersFlag,@Param("notInviteRole")String notInviteRole,@Param("teamUserFlag") Integer teamUserFlag,@Param("userLevel") Integer userLevel,@Param("userId") Integer userId);

	/**
	 * 通过用户ID和门店ID注销用户
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/25
	 */
	void updateByUserIdAndDeptId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);

	void updateUserAllDeptFlag(@Param("shardCityId") Short cityId,@Param("userId") Integer userId,@Param("operId") String operId,@Param("compId") Integer compId);

	ErpFunUsers getGeneralUserByArchiveId(@Param("shardCityId")Integer cityId,@Param("archiveId") Integer archiveId);

	List<ErpFunUsers> getFunUsersListByAreaIds(@Param("shardCityId") Integer cityId,@Param("areaIds") List<Integer> areaIds);

	UserPositionAndLevelDto getUserPositionAndLevelDtoByUserId(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId);

	@SelectProvider(method ="getTaskUserList", type=ErpFunUsersSqlProvider.class)
	@ResultType(value = Map.class)
	List<Map<String,Integer>> getTaskUserList(@Param("shardCityId")Integer cityId,@Param("dealId")Integer dealId,@Param("taskType") Integer taskType,@Param("compId") Integer compId);

	List<ErpFunUsers> getAuthRoamUserList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	List<ErpFunUsers> getUserListByShenHe(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);

	void updateUserFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	void updateShenheUserFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userIds") String[] userIds);

	List<ErpFunUsersDto> getFunUsersDtoListWriteOff(@Param("shardCityId")Integer cityId,@Param("param")ErpFunUsers condition);

	/**
	 * 获取全公司用户基本信息集合,包含已注销用户
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */
	List<ErpFunUsers> getFunUsersListByCompId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId);

	ErpFunUsers  getFunUsersByMobile(@Param("shardCityId")Integer cityId,@Param("userMobile") String userMobile);

	/**
	 * @tag 获取公司所有员工Id
	 * @author 邓永洪
	 * @since 2018/7/16
	 */
	Set<Integer> getCompUserIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userWriteOff") Boolean userWriteOff);

	void updatesBuildRuleFalg(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptIds") String[] deptIds);

	void updatesBuildRuleFalgByUserId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userIds") String[] userIds);

	@AccessReadonlyDb
	List<Map<String,Integer>> countUserByArea(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	@AccessReadonlyDb
	List<Map<String,Integer>> countUserByRegion(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("areaId")Integer areaId);

	@AccessReadonlyDb
	List<Map<String,Integer>> countUserByDept(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,
											  @Param("regId") Integer regId,@Param("isHeadquarters")Byte isHeadquarters);

	@AccessReadonlyDb
	List<Map<String,Integer>> countUserByGroup(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);

	ErpFunUsersDto getFunUsersDtoById(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId);

	List<ErpFunUsers> selectUserListRank(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("grId") Integer grId,
										 @Param("writeoffTime") String writeoffTime,@Param("deptId")Integer deptId);

	List<ErpFunUsers> getDeptUngroupUsers(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId,@Param("writeoffTime") String writeoffTime);


	//todo
	ErpFunUsersDto getUsersCountOffRangeList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("rangeList") Integer rangeList,@Param("rangeColumn") String rangeColumn,@Param("startDate") String startDate,@Param("endDate") String endDate);

	int countFunUsers(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("roleId") String roleId);

    Integer countUserNumberForRentDept(@Param("shardCityId")Integer cityId,@Param("deptId")  Integer deptId);

	Integer getUserCountByRangeIdAndColumn(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
										   @Param("rangeColumn") String rangeColumn, @Param("rangeIds") String rangeIds);

	Integer getCountUsersByCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	Set<Integer> getArchiveIdListByDeptNo(@Param("shardCompNo")String compNo, @Param("deptNo")String deptNo,@Param("isPartner") boolean isPartner,@Param("partnerId") Integer partnerId);

	ErpFunUsers getGeneralUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	Integer countByRoleId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
						  @Param("deptId")  Integer deptId, @Param("roleId") String roleId);

	//查询分组内有某权限的档案ID
    List<Integer> getAuditGroupList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("grId") Integer grId,@Param("operId") String operId);

	//查询门店内有某权限的档案ID
	List<Integer> getAuditDeptList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId,@Param("operId") String operId);

	//查询大区内有某权限的档案ID
	List<Integer> getAuditAreaList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("areaId") Integer areaId,@Param("operId") String operId);

	//查询片区内有某权限的档案ID
	List<Integer> getAuditRegList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("regId") Integer regId,@Param("operId") String operId);

	//查询公司内有某权限的档案ID
	List<Integer> getAuditCompList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("operId") String operId);

	// 通过path更新org1到org14上的值
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateOrg1To14ByTissueLine(@Param("shardCityId") Integer cityId,@Param("userId") Integer userId,@Param("updateSql") String updateSql);

	@AccessReadonlyDb
    List<FunUserOrgVo> getUserOrgNameByUserIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userIdList") Set<Integer> userIdSet);

	//动态查询出员工的某个组织ID
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer selectByDynamicOrg(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("mappingDbField") String mappingDbField);

	//查询出新版组织架构下某个组织下的所有员工，包括组织下的组织的员工
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunUsers> getOrganizationAllUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId);



    class ErpFunUsersSqlProvider{

		public String getRangeListDaTaOfComp(Map<String, Object> pMap) throws Exception {
			String searchRange = pMap.get("serchRange").toString();
			String dimension = pMap.get("dimension").toString();
			Integer userId = StringUtil.parseInteger(pMap.get("userId"), null);
			Object areaFlag = pMap.get("areaFlag");
			Object areaToZero = pMap.get("areaToZero");
			String tableName = null, columnName = null, whereSql = null;
			if ("AREA".equals(dimension)) {
				tableName = "FUN_AREA";
				columnName = "AREA_ID AS areaId,AREA_ID AS range";
			} else if ("REG".equals(dimension)) {
				tableName = "FUN_REGION";
				columnName = "AREA_ID AS areaId,REG_ID AS regId,CONCAT(AREA_ID,'_',REG_ID,'') AS range";
			} else if ("DEPT".equals(dimension)) {
				tableName = "FUN_DEPTS";
				columnName = "AREA_ID AS areaId,REG_ID AS regId,DEPT_ID AS deptId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID) AS range";
			} else if ("GROUP".equals(dimension)) {
				tableName = "FUN_DEPTSGROUP A LEFT JOIN FUN_DEPTS B ON A.DEPT_ID=B.DEPT_ID";
				columnName = "B.AREA_ID AS areaId,B.REG_ID AS regId,A.DEPT_ID AS deptId,A.GR_ID AS grId,CONCAT(B.AREA_ID,'_',B.REG_ID,'_',A.DEPT_ID,'_',A.GR_ID) AS range";
			} else if ("USER".equals(dimension)) {
				tableName = "FUN_USERS";
				columnName = "AREA_ID AS areaId,REG_ID AS regId,DEPT_ID AS deptId,GR_ID AS grId,USER_ID AS userId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID,'_',GR_ID,'_',USER_ID) AS range";
			}
			if (areaFlag == null || !"1".equals(areaFlag.toString())) {
				if(areaToZero != null && "1".equals(areaToZero.toString())) {// 大区用0代替
					columnName = columnName.replaceAll("B.AREA_ID", "0");
					columnName = columnName.replaceAll("AREA_ID", "0");
				} else {
					columnName = columnName.replace("B.AREA_ID AS areaId,", "");
					columnName = columnName.replace("B.AREA_ID,'_',", "");
					columnName = columnName.replace("AREA_ID AS areaId,", "");
					columnName = columnName.replace("AREA_ID,'_',", "");
				}
			}
			if ("AREA".equals(dimension)) {
				whereSql = "IS_DEL=0 AND COMP_ID=#{compId}";
			} else if ("REG".equals(dimension)) {
				whereSql = "IS_DEL=0 AND COMP_ID=#{compId}";
			} else if ("DEPT".equals(dimension)) {
				whereSql = "DEPT_FLAG=2 AND COMP_ID = #{compId}";
			} else if ("GROUP".equals(dimension)) {
				whereSql = "A.IS_DEL=0 AND A.COMP_ID=#{compId}";
			} else if ("USER".equals(dimension)) {
				whereSql = "COMP_ID=#{compId} AND USER_WRITEOFF=0";
				if (userId != null) {
					whereSql += " AND USER_ID = #{userId}";
				}
			}
			String columnNameStr = null, columnValStr = "#{serchRangeId}";
			if ("AREA".equals(searchRange)) {
				columnNameStr = "AREA_ID";
			} else if ("REG".equals(searchRange)) {
				columnNameStr = "REG_ID";
			} else if ("DEPT".equals(searchRange)) {
				columnNameStr = "DEPT_ID";
			} else if ("GROUP".equals(searchRange)) {
				columnNameStr = "GR_ID";
			} else if ("USER".equals(searchRange)) {
				columnNameStr = "ARCHIVE_ID";
				columnValStr = "#{archiveId}";
			}
			if (columnNameStr != null) {
				whereSql += " AND ";
				if ("GROUP".equals(dimension)) {
					whereSql += "GROUP".equals(searchRange) ? " A." : " B.";
				}
				whereSql += columnNameStr + "=" + columnValStr;
			}
//			if(userId != null){
//				whereSql +="USER_ID" + "=" + "#{userId}";
//			}
			String sqlStr = "SELECT " + columnName + " FROM " + tableName + " WHERE " + whereSql;
			return sqlStr;
		}

		/*public String getInvoiceList(Map<String,Object> pMap) throws Exception{
			BaseMap baseMap = (BaseMap) pMap.get("param");
			String tableName = " hft_admindb.dbo.FUN_PAID fp left JOIN hft_admindb.dbo.FUN_ISSUE_INVOICE fi on fp.paid_id = fi.paid_id ";
			Condition condition = new Condition();
			condition.add(new ConditionItem("fp.REAL_WEIXIN","!=", Constants_DIC.DIC_IS_REAL_WEIXIN));
			Columns columns = null;
			String orderBy = null;
			String type = baseMap.getString("type");
			if("2".equals(type)) {
				// 查询历史
				// 查询待开发票
				// 总经理
				if(baseMap.getBoolean("isGeneralManager")) {
					Condition archiveCondition = new Condition();
					archiveCondition.add(new ConditionItem("fp.ARCHIVE_ID", "IN", new SQL(SQL.SELECT,"select archive_Id from fun_users where user_writeoff=0 and comp_id = ? and archive_id <> ?", new String[]{operator.getCompId(), operator.getArchiveId()})));
					 		archiveCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT"}));
					// 自己的数据
					Condition selfCondition = new Condition();
					selfCondition.add(new ConditionItem("fp.ARCHIVE_ID", "=", pMap.get("currentArchiveId")));
					selfCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT","SRV"}));
					archiveCondition.add(Condition.OR, selfCondition);
					condition.add(archiveCondition);

				}else { // 非总经理
					condition.add(new ConditionItem("fp.ARCHIVE_ID", "=", baseMap.get("currentArchiveId")));
				}
				condition.add(new ConditionItem("fi.INVOICE_ID", "IS", "NOT NULL"));
				condition.add(new ConditionItem("fi.INVOICE_STATUS", "!=", Constants_DIC.DIC_INVOICE_STATUS_6));
				columns = new Columns(new String[]{
						"fi.INVOICE_ID",
						"fi.INVOICE_TYPE",
						"fi.INVOICE_HEADER",
						"fi.CREATION_TIME",
						"fi.INVOICE_STATUS",
						"fi.INVOICE_ID",
						"fp.AMOUNT",
						"fp.PAID_TYPE",
						"fp.ARCHIVE_ID",
				});
				orderBy = "CASE WHEN  fi.INVOICE_STATUS=1 THEN 100 ELSE 1000 END ,fi.CREATION_TIME DESC";
			}else{
				// 查询待开发票
				condition.add(new ConditionItem("fp.PADI_TIME", ">=", "#{param.startPaidTime}"));
				// 总经理
				if(baseMap.getBoolean("isGeneralManager")) {
					Condition archiveCondition = new Condition();
					archiveCondition.add(new ConditionItem("fp.ARCHIVE_ID", "IN", new SQL(SQL.SELECT,"select archive_Id from fun_users where user_writeoff=0 and comp_id = ? and archive_id <> ?", new String[]{operator.getCompId(), operator.getArchiveId()})));
					 		archiveCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT"}));
					// 自己的数据
					Condition selfCondition = new Condition();
					selfCondition.add(new ConditionItem("fp.ARCHIVE_ID", "=", pMap.get("currentArchiveId")));
					selfCondition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT","SRV"}));
					archiveCondition.add(Condition.OR, selfCondition);
					condition.add(archiveCondition);

				}else {
					condition.add(new ConditionItem("fp.ARCHIVE_ID", "=", pMap.get("currentArchiveId")));
					condition.add(new ConditionItem("fp.PAID_TYPE", "IN", new String[]{"O2O","UPGRADE_SRV","PAY_WEIXIN","BUYDEPT","SRV"}));
				}
				Condition subCondition = new Condition();
				subCondition.add(new ConditionItem("fi.INVOICE_ID", "IS", "NULL"));
				subCondition.add(Condition.OR,new ConditionItem("fi.INVOICE_STATUS","=",Constants_DIC.DIC_INVOICE_STATUS_6));//
				condition.add(subCondition);
				columns = new Columns(new String[]{
						"fp.PADI_TIME",
						"fi.INVOICE_ID",
						"fp.ARCHIVE_ID",
						"fp.AMOUNT",
						"fp.PAID_TYPE",
						"fp.PAID_ID"
				});
				orderBy = "fp.PADI_TIME DESC";
			}
			return SQLBuilderSupport.constructSQLForSelect(SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, orderBy, null)).toString();
		}*/
		public String getInvoiceDetail(Map<String,Object> pMap) throws Exception{
			String tableName = "FUN_ISSUE_INVOICE fi left join FUN_PAID fp on fi.PAID_ID = fp.PAID_ID";
			String orderBy = "fi.INVOICE_ID desc";
			Columns columns = new Columns(new String[]{
					"fi.*","fp.PAID_TYPE"
			});
			Condition condition = new Condition();
			condition.add(new ConditionItem("fi.INVOICE_ID", "=", "#{invoiceId}"));
			SQL sql = SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, orderBy, null);
			return 	SQLBuilderSupport.constructSQLForSelect(sql).toString();
		}

		public String getTaskUserList(Map<String,Object> pMap) throws Exception {
			Integer taskType=(Integer) pMap.get("taskType");
			String sqlStr = "";
			if(0==taskType){
				sqlStr = "select SIGN_USER_ID,SIGN_MANAGER_ID,DEAL_USER_ID,CREATOR_UID from fun_deal where deal_id=#{dealId} and comp_id=#{compId}";
			}else if(1==taskType){
				sqlStr = "select distinct A.SIGN_USER_ID,A.SIGN_MANAGER_ID,A.DEAL_USER_ID,A.CREATOR_UID,B.AUDIT_USER from fun_deal A left join process_financ B on A.deal_id=B.deal_id where A.deal_id =#{dealId} and A.comp_id=#{compId}";
			}else if(2==taskType){
				sqlStr = "select distinct A.SIGN_USER_ID,A.SIGN_MANAGER_ID,A.DEAL_USER_ID,A.CREATOR_UID,B.AUDIT_USER,C.UPDATE_USER from fun_deal A left join process_financ B on A.deal_id=B.deal_id left join FUN_DEAL_TAXES C ON B.deal_id = C.deal_id where A.deal_id=#{dealId} and A.comp_id=#{compId}";
			}
			return sqlStr;
		}
	}

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunUsers selectUserByUserMobile(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("phoneArr") String[] phoneArr);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListByTime(@Param("shardCityId")Integer cityId,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("compId")Integer compId);
	//ErpFunUsers getUserInfoByUserIdByDbName(String shardDbName, Integer caseUserId);
	/**
	 * 人员统计
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param cityId
	 * @param map
	 * @return
	 */
	Integer getUsersCountData(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 根据ArchiveId查询用户
	 * @author 何传强
	 * @since 2017年7月14日
	 * @param cityId
	 * @param archiveIds
	 * @return
	 */
	List<ErpFunUsers> getUserListByArchiveIds(@Param("shardCityId")Integer cityId, @Param("archiveIds")Set<Integer> archiveIds);
	
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
	List<Map<String, Integer>> getUserCountByRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("serchRange")String serchRange, @Param("serchRangeId")Integer serchRangeId,
			@Param("dimension")String dimension, @Param("writeoff")Integer writeoff,@Param("userId")Integer userId
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
	List<Map<String, Integer>> getUserCountByRangeAndDate(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("serchRange")String serchRange, @Param("serchRangeId")Integer serchRangeId,
			@Param("dimension")String dimension, @Param("writeoff")Integer writeoff,
			@Param("startTime")String startTime, @Param("endTime")String endTime,
			@Param("dateListSql")String dateListSql
			);
	
	/**
	 * 查询一个时间段内的员工人数
	 * @author 张宏利
	 * @since 2017年7月29日
	 * @param cityId 分库
	 * @param compId 公司ID
	 * @param serchRange 范围， AREA_ID 大区 REG_ID 片区 DEPT_ID 门店 GR_ID 分组 USER_ID 员工
	 * @param serchRangeId 范围ID
	 * @param writeoff 是否注销，0=未注销 1=已注销
	 */
	Integer getUserCountByTimeRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("serchRange")String serchRange, @Param("serchRangeId")Integer serchRangeId,
			@Param("startTime")String startTime, @Param("endTime")String endTime
		);
	
	/**
	 * 根据公司ID查询所有的用户
	 * @author 何传强
	 * @since 2017年7月21日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunUsers> getUserListByCompId(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 查询人员信息,AREA,REG,DEPT,GR,USER
	 * @author 何传强
	 * @since 2017年7月29日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunUsers> getUserInfoList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	/**
	 * 根据
	 * @author 何传强
	 * @since 2017年8月14日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	ErpFunUsers getFunUserByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);
	
	
	/**
	 * 根据城市和公司ID和userId查用户
	 * @author 何传强
	 * @since 2017年8月14日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	ErpFunUsers getFunUserByUserIdNew(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("userId") Integer userId);
	
	/**
	 * 通过门店查询对于员工信息
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunUsers> getFunUsersBydept(@Param("shardCityId")Integer cityId,@Param("archiveIdList")List<Integer> archiveIdList);
	
	/**
	 * 依据角色查询未注销的用户列表，只查询了该接口需要的列
	 * @author 张宏利
	 * @since 2017年11月1日
	 * @param cityId 城市ID
	 * @param roleId 角色ID
	 * @param compId 公司ID
	 * @return
	 */
	List<ErpFunUsers> getUserListForRole(@Param("shardCityId")Integer cityId, @Param("roleId")String roleId,  @Param("userId")Integer userId, @Param("compId")Integer compId);
	
	/**
	 * 通过维度和角色查询未删除的员工列表
	 * @author 张宏利
	 * @since 2017年8月29日
	 * @return
	 */
	List<ErpFunUsers> getUserListByRole(@Param("shardCityId")Integer cityId, @Param("roleId")String roleId, @Param("compId")Integer compId, 
			@Param("areaId")Integer areaId, @Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId);
	
	/**
	 * 用于薪资配置根据角色和职级查询用户数据
	 * 如果roleLevelId 为 null 或者 等于0，则查询的是尚未配置职级的员工
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年10月16日 下午8:00:35
	 */
	List<ErpFunUsers> getUserListByRoleAndRoleLevel(@Param("shardCityId")Integer cityId, 
													@Param("roleId")String roleId,
													@Param("roleLevelId")Integer roleLevelId, 
													@Param("compId")Integer compId);
	
	/**
	 * 获取在时间段内存在过的员工
	 * @author 方李骥
	 * @since 2017年9月04日
	 * @return
	 */
	List<Map<String, Object>> getUserListNotWriteOffOnTime(@Param("shardCityId")Integer cityId,  @Param("param")Map<String, Object> map);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpUsersInfoDto getUserInfoByUserIdForDeal(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId,@Param("areaFlagVal") Integer areaFlagVal);
	
	
	/**
	 * 获取注册管理员信息
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpFunUsers> getMgrRegistManagerUser(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);
	
	/**
	 * 获取员工通讯录列表
	 * @author 张宏利
	 * @since 2017年9月29日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpFunUsersDto> getCommunicationList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);
	
	Integer selectSalaryManager(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * 获取有权限审核的人员列表<br/>
	 * 不再建议使用，会查询到所有有权限的人，一般只需要一层层网上找有权限的人<br/>
	 * 参考：{@link ErpFunUsersServiceImpl.getHaveAuditUserListForExamin}}
	 * @author 张宏利
	 * @since 2017年11月2日
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param areaId 大区ID
	 * @param regId 片区ID
	 * @param deptId 门店ID
	 * @param grId 分组ID
	 * @return
	 */
	@Deprecated
	List<Integer> getHaveAuditUserList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, 
			@Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId);
	
	/**
	 * 获取员工档案
	 * @author 熊刚
	 * @since 2017年11月3日
	 * @param cityId
	 * @param map
	 * @return
	 */
	List<ErpFunUsersDto> getEmployeeFilesList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);

	ErpFunUsersDto getFunUsersDtoByUserId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId, @Param("userId") Integer userId,@Param("nowTime") String nowTime);

	int getTotalUserCountOffRangeList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rangeColumn") String rangeColumn, @Param("rangeList") List<Integer> rangeList,@Param("startTime")String startTime,@Param("endTime") String endTime);
	List<ErpFunUsers> getErpFunUsersList(@Param("shardCityId") Integer cityId, @Param("userIdList")List<Integer> userIdList);
	
	/**
	 * 获取角色匹配度
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
	ErpFunUsers getLastUserByUp(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("roleId")String roleId, @Param("areaId")Integer areaId, @Param("regId")Integer regId,
			@Param("deptId")Integer deptId, @Param("grId")Integer grId);

	ErpFunUsers getGeneralManagerByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	/**
	 * 依据权限获取匹配度
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId
	 * @param compId
	 * @param operMap
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	ErpFunUsers getLastUserByUpForAudit(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
			@Param("operMap")Map<String, String> operMap, @Param("areaId")Integer areaId, @Param("regId")Integer regId,
			@Param("deptId")Integer deptId, @Param("grId")Integer grId);
	
	/**
	 * 获取有权限的人列表
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param cityId
	 * @param operMap
	 * @param compId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	List<ErpFunUsers> getUserListByAudit(@Param("shardCityId")Integer cityId, @Param("operMap")Map<String, String> operMap, @Param("compId")Integer compId, 
			@Param("areaId")Integer areaId, @Param("regId")Integer regId, @Param("deptId")Integer deptId, @Param("grId")Integer grId);

	List<Map<String, Object>> getUserListByTimeRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("searchRange") String searchRange,
			@Param("searchRangeId")Integer searchRangeId, @Param("startTime")String startTime,@Param("endTime") String endTime);
	
	/**
	 * 获取用户名和门店名信息
	 * @author 张宏利
	 * @since 2018年1月8日
	 * @param cityId
	 * @param userIds
	 * @return
	 */
	List<ErpFunUsersDto> getUserNameAndDeptNameByIds(@Param("shardCityId")Integer cityId, @Param("userIds") Set<Integer> userIds);
	
	/**
	 * 获取一个范围内角色列表
	 * 
	 * @author 张宏利
	 * @since 2018年1月13日
	 * @param cityId
	 * @param compId
	 * @param selfDeptId
	 * @return
	 */
	List<ErpFunUsers> getDeptBranchManager(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("areaId") Integer areaId, @Param("regId") Integer regId, @Param("deptId") Integer deptId,
			@Param("userPosition") String userPosition);
	
	List<Map<String, Object>> getUserPosition(@Param("shardCityId") Integer cityId, @Param("userIdSet")Set<Integer> userIdSet);

	List<ErpFunUsersDto> getUserArchiveList(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("userIds")String[] userIds);

	List<ErpFunUsers> getBuildManagerUsersList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("deptId")Integer deptId);
	List<ErpFunUsers> getFunUsersListByMap(@Param("shardCityId")Integer cityId,@Param("param") Map<String,Object> paramMap);
	
	/**
	 * 获取门店有效的员工数量
	 * 
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param cityId
	 * @param deptId
	 * @return
	 */
	Integer getDeptUserCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("deptId") Integer deptId, @Param("userPosition") String userPosition);
	
	/**
	 * 员工调店后的相关表更新
	 * 
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param cityId
	 * @param newDeptId
	 * @param userId
	 * @param endTime
	 * @param startTime
	 */
	void updateDeptByChangeDept(@Param("shardCityId") Integer cityId, @Param("newDeptId") Integer newDeptId,
			@Param("oldDeptId") Integer oldDeptId, @Param("archiveId") Integer archiveId,
			@Param("userId") Integer userId, @Param("endTime") String endTime, @Param("startTime") String startTime);

	void updateForMarketCompData(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("newUserId") Integer newUserId);
	
	/**
	 * 所有相关数据移交到总经理名下，crm用户脱离门店时使用
	 * @author 张宏利
	 * @since 2018年6月13日
	 * @param cityId
	 * @param userId
	 * @param generalManager
	 */
	void updateDataToGeneralManager(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId, @Param("newUser") ErpFunUsers generalManager);
	
	/**
	 * 非营销版注销员工要把之前精英版的个人数据带到脱离门店后的账号上
	 * @author 朱科
	 * @since 2018年6月20日
	 * @param cityId
	 * @param userId
	 * @param archiveId
	 */
	void updateDataToPersonal(@Param("shardCityId") Integer cityId, @Param("newUser") Integer userId, @Param("archiveId") Integer archiveId);
	
	void clearUserForGroup(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("grId") Integer grId, @Param("userIdsList")List<Integer> userIdsList, @Param("updateGrId") Integer updateGrId);
	
	ErpFunUsers getIsOperator(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, String range, String queryRange, Integer queryRangeId , Integer operQueryLevel);
	
	/**
	 * 获取某个维度下未注销的用户数量
	 * 
	 * @author 张宏利
	 * @since 2018年7月4日
	 * @param cityId
	 * @param compId
	 * @param areaId
	 * @param regId
	 * @param deptId
	 * @param grId
	 * @return
	 */
	Integer getUserCountByRangeId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
			@Param("areaId") Integer areaId, @Param("regId") Integer regId, @Param("deptId") Integer deptId,
			@Param("grId") Integer grId);
	
	/**
	 * 调片区同步房客源数据
	 *@author 朱科
	 *@param 
	 *@return 
	 *@since 2018年7月9日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateDataForArea(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, @Param("regId")Integer regId);

	/**
	 * 通过档案ID获取信息
	 * @author ZangTie
	 * @since 2018年7月20日 下午10:18:59
	 * @param cityId
	 * @param archiveId
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 */
	ErpFunUsers getUserInfoByArchiveId(@Param("shardCityId") Integer cityId, @Param("archiveId") Integer archiveId);
	
	/**
	 * 获取指定时间，指定范围内的员工总数
	 * @author 朱科
	 * @since 2018年8月2日
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getSpecifiedTimeUserList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											   @Param("rangeType") Integer rangeType, @Param("rangeId") Integer rangeId,
											   @Param("startTime") String startTime, @Param("deptId") Integer deptId);
	
	/**
	 * 获取门店的用户总人数
	 * @author 朱科
	 * @since 2018年9月5日
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsersDto> getCountUsersByDeptIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptIds") List<Integer> deptIds);


	List<ErpFunUsers> getUserListByRangeColumn(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											   @Param("rangeColumn")String rangeColumn,@Param("rangeIds")String rangeIds);

	/**
	 * 总经理查询经纪人账户数，不在某些角色的角色列表
	 * @author 朱科
	 * @since 2018年9月6日
	 * @return
	 */
	int getAgentOnlineCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("roleIds") List<String> roleIds);
	
	/**
	 * 查询门店分组人数
	 */
	List<ErpFunUsers> getUsersByGrIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("grIds") List<Integer> grIds);


	List<ErpFunUsers> getUsersByOrganization(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("areaId") Integer areaId, @Param("regId") Integer regId,@Param("deptId") Integer deptId,@Param("grId") Integer grId,@Param("userPosition") String userPosition);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> selectAllUserArchiveId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);
	
	int countByRangeIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("manageRangeRangeType") Integer manageRangeRangeType,
			 @Param("userManageRangeIds") Set<Integer> userManageRangeIds);

	/**
	 * 查询在职员工或当月离职的员工
	 * @param cityId
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserListBySearchRang(@Param("shardCityId") Integer cityId,@Param("param")ErpAttendanceStatisticalAnalysisParam param);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getAllUserName(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("startTime") String startTime);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer updateChangeUserRoleProccess(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId, @Param("roleId") String roleId);	

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getAuditList(@Param("shardCityId") Integer cityId, @Param("rangeType")Integer rangeType, @Param("grId")Integer grId, @Param("operId")String operId);

	
	/**
	 * 获取公司内所有未注册的员工角色
	 * @author LI XIAO TONG
	 * @since 2019年8月29日 上午10:44:52
	 * @param cityId
	 * @param compId
	 * @return
	 * Modified XXX Li Xiao Tong 2019年8月29日
	 */
	List<GetCompNotInviteUserRoleVo> getCompUserRole(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	/**
	 * 查询公司未注销并且为注册的员工
	 * @author LI XIAO TONG
	 * @since 2019年8月29日 上午10:59:50
	 * @param cityId
	 * @param compId
	 * @param string 
	 * @return
	 * Modified XXX Li Xiao Tong 2019年8月29日
	 */
	List<GetAllCompUserVo> getAllCompUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userName") String userName,@Param("roleId") String roleId);

	Integer getTeamNum(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("userLevel") Integer userLevel);

	void updateAssessment(@Param("shardCityId")Integer cityId,@Param("assessmentTime")Date assessmentTime, @Param("assessmentFlag") Integer assessmentFlag,@Param("userId") Integer userId);

	List<ErpUserDeptNameVo> getDeptNameByUserIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("userIdList") List<Integer> userIdList);

	List<AssessRoleCountDataVo> getUserTeamList(@Param("shardCityId") Integer cityId,@Param("userIdData")Integer userIdData,@Param("paramData")AssessCountDataParam param);

	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getAllCompUserIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getFunUserByUserLevelAndTissueLine(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId, @Param("userLevel") int userLevel);


	List<ErpFunUsers> selectUserListByIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("ids") List<Integer> userIds);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getUserAllTeamList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("userLevel")Integer userLevel);
	
	
	Map<String,Integer> getObtainingTheNumberOfInServiceSeparations(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("headCharacter")String headCharacter, @Param("keyWord")String keyWord);

	List<Integer> selectByRoleNotWrriteUserList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String auditRoleId);


	PartnerInfoDto selectUserPartnerInfo(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);

	@AccessReadonlyDb
	List<Map<String,Integer>> countUserByPartnerId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,
											  @Param("partnerId") Integer partnerId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunUsers> getRecordsByCompIdAndUserWriteOffByPartner(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
																 @Param("partnerId") Integer partnerId, @Param("userWriteOff") Integer userWriteOff);

	List<ErpFunUsers> selectUserListByArchiveIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("ids") List<Integer> archiveIds);
	
	List<ErpFunUsers> selectUserListByUserName(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("names") List<String> userNames);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BrokerOrganizationVO> selectBrokerOrganizationByUserIds(@Param("shardCityId") Integer cityId, @Param("userIds") List<Integer> userIds, @Param("compId") Integer compId);

	List<CompPartnerCountVO> getCompPartnerCount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("partnerIdList")List<Integer> partnerIdList);
	
	Integer getUserCountByRangeIdAndColumnNewOrg(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIds);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Set<Integer> getArchiveIdSetByCondition(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("pubOrganizationId") String pubOrganizationId, @Param("isPartner") boolean isPartner, @Param("partnerId") Integer partnerId, @Param("bulletBound") Integer bulletBound);

	List<ErpFunUsers> getUserListByRangeColumnNewOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeIds") Set<Integer> rangeIdSet);
	
	List<ErpFunUsers> selectUserByOrgDefinitionLevel(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealOrgList")List<Integer> dealOrgList,
			@Param("defLevel")Integer defLevel);
	
	List<ErpFunUsers> selectUserByOrgDefinitionLevelAndMangeRange(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("dealOrgList")List<Integer> dealOrgList, @Param("roleId") String roleId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Map<String, Object>> selectByOrg(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("rangeColumn") String rangeColumn,@Param("rangeId") Integer rangeId);


	//美联查询系统参数相关
	PartnerInfoDto selectMLUserInfoByUserId(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);


	GetCrossCompUserVO selectUserRoleByUserID(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer countOrganizationAllUser(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("organizationId") Integer organizationId);
	
	List<UserOrganizationInfoVO> getUserOrganizationInfoByUserIds(@Param("shardCityId") Integer cityId, @Param("userIdList") List<Integer> userIdList);

	@Select("select top 1 * from fun_users where comp_id = #{compId} and USER_WRITEOFF=0")
	@ResultType(ErpFunUsers.class)
    ErpFunUsers getTop1ValidUserByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	

	List<GetOrganizationUserVo> getUserByOrganizationId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("organizationId") Integer organizationId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	@AccessReadonlyDb
	List<ErpFunUsers> getRecordsByCompIdAndUserNotWriteOff(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("userWriteOff")Integer userWriteOff);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<WriteoffUserListVO> selectWriteoffUserList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("date") Date date);
}



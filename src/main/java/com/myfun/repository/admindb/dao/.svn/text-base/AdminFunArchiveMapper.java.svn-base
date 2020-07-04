package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.myfun.erpWeb.managecenter.vstore.param.GetEmployeeDynamicsListParam;
import com.myfun.repository.admindb.dto.ActiveBrokerActionDto;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.admindb.param.ActiveBrokerActionParam;
import com.myfun.repository.admindb.param.AdminFunArchiveParam;
import com.myfun.repository.admindb.param.BrokerArchiveParam;
import com.myfun.repository.admindb.param.RecommendPersonalListpParam;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunArchiveExample;

public interface AdminFunArchiveMapper extends BaseMapper<AdminFunArchive, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunArchiveExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunArchive> selectByExample(AdminFunArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunArchive record,
			@Param("example") AdminFunArchiveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunArchive record, @Param("example") AdminFunArchiveExample example);

	AdminFunArchive getArchiveByMobile(@Param("userMobile") String userMobile);

	/**
	 * 精英版管理列表
	 * @param funArchive
	 * @return
	 */
	List<AdminFunArchiveDto> getRecommendPersonalList(RecommendPersonalListpParam funArchive);

	AdminFunArchive selectByMobile(String userMobile);

	AdminFunArchive queryCompGeneralUserArchiveInfoByAdminCompNo(String compNo);
	
	/**
	 * 跟进条件查询数量
	 **/
	Integer getCountByCondition(AdminFunArchive av);

	void updateBySellComp(Integer compId);

	void updateByCompId(Integer compId);
	
	/**
	 * 判断改电话号码是否在档案表中存在
	 * 
	 * @param phone
	 * @param cellphone
	 * @return
	 */
	public int getCountByPhone(@Param("phone") String phone, @Param("cellphone") String cellphone);

	/**
	 * 精英版登记列表
	 * @param funArchive
	 * @return
	 */
	Page<AdminFunArchiveDto> getPersonalList(AdminFunArchive funArchive);
	
	
	/**
	 * 检查个人是否关联资金帐户
	 * @param archiveId
	 * @return
	 */
	int countArchiveUaId(String archiveId);
	
	public void updatePhoneNum(Map<String, Object> map);

	List<AdminFunArchiveDto> getUserByMobile(String phoneNum);

	public int delUserByMobile(String phoneNum);

	/**
	 * 精英版批量移交
	 * @param sellId
	 * @param oldSellId
	 */
	void translateDataAll(@Param("sellId") String sellId, @Param("funArchiveIds") List<String> funArchiveIds);

	/**
	 * 精英版全部移交
	 * @param sellId
	 * @param oldSellId
	 */
	void translateDataBySellId(@Param("sellId") String sellId, @Param("oldSellId") String oldSellId);

	AdminFunArchive getArchiveByMobileAndCompId(AdminFunArchiveParam archiveParam);

	List<AdminFunArchiveDto> getBrokerArchiveList(BrokerArchiveParam funArchiveParam);

	/**
	 * 经纪人信息详情
	 * @param archiveId
	 * @return
	 */
	AdminFunArchiveDto getBrokerInfoByArchiveId(Integer archiveId);

	/**
	 * 经纪人实名认证信息
	 * @param archiveId
	 * @return
	 */
	AdminFunArchiveDto getBrokerApproveByArchiveId(Integer archiveId);

	void initPushBuild(Integer archiveId);

	void giveScore(Map<String, Object> map);

	List<String> selectHasUser(AdminFunArchive archive);

	void sendMsg(@Param("userId")String userId, @Param("msg")String msg);


	AdminFunArchive getArchiveById(Integer banArchiveId);
	
	/**
	 * 根据公司ID获取该公司总经理ARCHIVE_ID
	 * @param compId
	 * @return
	 */
	AdminFunArchive getArchiveIdByCompId(Integer compId);
	
	/**
	 * 查找公司总经理的UA_ID
	 * @param archiveId
	 * @param i
	 * @return
	 */
	AdminFunArchive getObjectByArchiveIdAndUaId(@Param("archiveId")String archiveId, @Param("uaId")int uaId);
	
	/**
	 * 修改经纪人档案信息
	 * @param userEdition
	 * @param split
	 */
	void updateUserEdition(@Param("userEdition")String userEdition, @Param("archiveIds")String[] archiveIds);

	AdminFunArchive queryAdminFunArchiveId(Integer archiveId);

	List<ActiveBrokerActionDto> getArchiveByLoginTime(ActiveBrokerActionParam param);
	
	/**
	 * 获取用户档案信息
	 * @param userMobile
	 * @param superComp
	 * @param compid
	 * @return
	 */
	AdminFunArchive getRecordByUserMobileAndCompId(@Param("userMobile")String userMobile, @Param("superComp")String superComp,
			@Param("compid")Integer compid);

	/**
	 * 判断资金账户是否被绑定
	 * @param uaId
	 * @return
	 */
	int countArchiveByUaId(Integer uaId);

	/**
	 * 查询公司门店下经济人
	 * @param archiveIds
	 * @return
	 */
	List<AdminFunArchiveParam> getBrokerFlow(@Param("archiveIds") List<Integer> archiveIds);

	/**
	 * 永久停用门店时，更新用户状态与好友标记
	 * @param archiveIds
	 */
	void updateUserEditionAndFriendFlag(@Param("archiveIds") List<Integer> archiveIds);
	
	/**
	 * 跟进账号ID查询用户
	 * @param uaId
	 * @return
	 */
	AdminFunArchive getUserNameByUaId(@Param("uaId")String uaId);
	
	/**
	 * 查询一批经纪人的fun_archive信息
	 * @author 陈文超
	 * @date 2016年6月21日 下午3:33:25
	 */
	List<AdminFunArchive> getArchiveInfosByIds(List<Integer> list);

	List<AdminFunArchive> getArchiveIdList(String archiveIds);
	
	/**
	 * 获取夺宝币排名数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @return
	 */
	List<AdminFunArchiveDto> getTreasureCoinRanking();
	
	/**
	 * 获取个人夺宝币排名数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @return
	 */
	AdminFunArchiveDto getSelfTreasureCoinRanking(@Param("archiveId") Integer archiveId);
	
	AdminFunArchive selectLastArchive(@Param("archiveId") Integer archiveId);
	
	/**
	 * 查询对于门店的所有
	 * @param param
	 * @return
	 */
	List<AdminFunArchiveDto> getArchiveListBydept(@Param("param")Map<String, Object> param);
	
	List<AdminFunArchiveDto> getPhotoByArchiveId(@Param("archiveIdList")List<Integer> archiveIdList,@Param("param")GetEmployeeDynamicsListParam param);
	List<AdminFunArchiveDto> getAdminFunArchiveDtoList(@Param("archiveIdList")List<String> archiveIdList);
	@AccessReadonlyDb
	AdminFunArchiveDto getDtoByArchiveId(@Param("archiveId")Integer archiveId);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> fastdfsFileList);

	@MapKey("archiveId")
	Map<Integer, AdminFunArchive> getModelDataMap(@Param("archiveIds") Set<Integer> archiveIds);
	
	List<AdminFunArchive> selectUserName(@Param("archiveIdList")List<Integer> archiveIdList);
	
	List<AdminFunArchive> selectUserPhoto(@Param("archiveIdList")List<Integer> archiveIdList);
	
	/**
	 * 更新最后登录时间
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	void updateUserLastLoginTime(@Param("archiveId") Integer archiveId,@Param("date") Date date);
	
	/**
	 * 个人中心的修改用户信息
	 * @author 张宏利
	 * @since 2018年5月21日
	 * @param adminFunArchive
	 */
	void updatePersonalInfoByUcenter(AdminFunArchive adminFunArchive);

	List<AdminFunArchive> getListByArchiveIds(@Param("archiveIds") List<Integer> archiveIds);

	void moveTrack(@Param("archiveId")Integer archiveId,@Param("userMobile") String userMobile);

	/**
	 * 验证手机号是否注册
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/8
	 */
	List<AdminFunArchive> getValidMobileIsRegist(@Param("mobile") String mobile);
	
	void updateUserPhoto(@Param("archiveId")Integer archiveId, @Param("photoPath")String photoPath);

	List<AdminFunArchive> getArchiveList(@Param("archiveId")Integer archiveId,@Param("nowTime") String nowTime,@Param("superEnd") String superEnd);
}


package com.myfun.service.business.admindb;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.usercenter.param.MyBaisInfoParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dto.ActiveBrokerActionDto;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.admindb.param.ActiveBrokerActionParam;
import com.myfun.repository.admindb.param.BrokerArchiveParam;
import com.myfun.repository.admindb.param.RecommendPersonalListpParam;
import com.myfun.repository.admindb.po.AdminBan;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunUserRqs;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface AdminFunArchiveService extends BaseMapper<AdminFunArchive, Integer> {

	/**
	 * 精英版管理列表
	 * 
	 * @param funArchive
	 * @param pageNumber
	 * @return
	 */
	PageInfo<AdminFunArchiveDto> getRecommendPersonalList(RecommendPersonalListpParam funArchive);

	/**
	 * 根据电话号码查询用户信息
	 * 
	 * @param userMobile
	 * @return
	 */
	AdminFunArchive selectByMobile(String userMobile);

	/**
	 * 查询改电话号码是否在档案信息表中是否存在
	 * 
	 * @param phone
	 * @return
	 */
	public int getCountByPhone(String phone, String cellphone);

	/**
	 * 精英版登记列表
	 * 
	 * @param funArchive
	 * @param i
	 * @return
	 */
	Page<AdminFunArchiveDto> getPersonalList(AdminFunArchive funArchive, int i);

	/**
	 * 检查个人是否关联资金帐户
	 * 
	 * @param archiveId
	 * @return
	 */
	int countArchiveUaId(String archiveId);

	public int ChangePhoneNum(Map<String, Object> map);

	public List<AdminFunArchiveDto> getUserByMobile(String phoneNum);

	int delUserByMobile(String phoneNum);

	/**
	 * 精英版批量移交
	 * 
	 * @param selleId
	 * @param oldSellId
	 * @return
	 */
	void translateDataAll(String sellId, String oldSellId);

	/**
	 * 精英版数据移交
	 * 
	 * @param selleId
	 * @param oldSellIds
	 */
	void translateData(String sellId, String ids);

	/**
	 * 看跟进
	 * 
	 * @param archiveId
	 * @param pageNumber
	 * @return
	 */
	Page<AdminCrmBrokerTrack> getBrokerTrackList(Integer archiveId, Integer pageNumber);

	PageInfo<AdminFunArchiveDto> getBrokerArchiveList(BrokerArchiveParam funArchiveParam);

	AdminFunArchiveDto getBrokerInfoByArchiveId(Integer parseInt);

	AdminFunArchive getFunArchiveByArchiveId(Integer archiveId);

	AdminFunArchiveDto getBrokerApproveByArchiveId(Integer archiveId);

	int sendMsg(Integer archiveId, String msg);

	int sendSMSCode(Integer archiveId, AdminCrmUser user, String ipAddr) throws ParseException;

	AdminFunArchive getBrokerInfoByMobile(String mobile);

	List<AdminBan> getBanRecords(Integer archiveId, Byte type);

	int userSilent(AdminBan ban, AdminCrmUser user) throws ParseException;

	int delSilent(Integer archiveId);

	int downHouse(AdminBan ban, AdminCrmUser user) throws ParseException;

	int cancelDownHouse(Integer archiveId, AdminCrmUser user) throws ParseException;

	int saveAuditAction(String type, String result, Integer archiveId, String desc, String userNo, String icCode,
			AdminCrmUser user) throws ParseException;

	List<String> selectHasUser(AdminFunArchive archive);

	void updateUserInfo(AdminFunArchiveDto archive);

	String sepratorPer(Integer archiveId, AdminCrmUser user) throws ParseException;

	AdminFunUserRqs getUserRqsInfo(Integer archiveId);

	int updateUserRqs(AdminFunUserRqs rqs);

	PageInfo<ActiveBrokerActionDto> getActiveBrokerList(ActiveBrokerActionParam param) throws ParseException;
	
	/**
	 * 获取用户档案信息
	 * @param userMobile
	 * @param superComp
	 * @param compid
	 * @return
	 */
	AdminFunArchive getRecordByUserMobileAndCompId(String userMobile, String superComp, Integer compid);

	AdminFunArchive getUserNameByUaId(String uaId);
	/**
	 * 查询一批经纪人信息
	 * @author 陈文超
	 * @date 2016年6月21日 下午3:36:19
	 */
	List<AdminFunArchive> getArchiveIdList(String archiveIds);

	List<AdminFunArchive> getArchiveInfosByIds(List<Integer> archiveIds);

	Map<Integer, AdminFunArchive> getModelDataMap(List<Integer> userIds);

	Integer isSuperUser(Integer superUser, Date superEnd);

	void updateFriendFlagForSysParaByKeys(Integer cityId, Integer compId, Set<Integer> archiveIds, String string);
	
	/**
	 * 创建用户
	 * @author 张宏利
	 * @since 2017年5月10日
	 * @param cityId
	 * @param serviceReg
	 * @param serviceZone
	 * @param provinceId
	 * @param selUid
	 * @param i
	 * @return
	 */
	AdminFunArchive createOrUpdateByErpCreateUser(Integer cityId, String serviceReg, String serviceZone,
												  String serviceZoneIds, ErpFunUsers erpFunUsers, Integer provinceId, Integer selUid, byte type);

	AdminFunArchive createOrUpdateByErpCreateUserNew(Integer cityId, String serviceReg, String serviceZone,
												  String serviceZoneIds, ErpFunUsers erpFunUsers, Integer provinceId, Integer selUid, byte type);

	void updateUaIdBycreateUser(Integer uaId, Integer archiveId, String userMobile, String userName);

	/**
	 * 获取B端用户完整的标准头像地址（工作照，实名认证后处理的工作照）
	 * 以后需要获取其他方法的时候，再写方法。例如：获取身份证图片、个人小头像、个人社交头像等
	 * 
	 * @author 陈文超
	 * @date 2017年4月14日 上午11:01:30
	 */
	public String getUserPhotoUrl(AdminFunArchive adminFunArchive);

	/**
	 * 是否实名认证
	 * 
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param archiveId
	 * @return
	 */
	boolean isUserRight(Integer archiveId);

    void updatePersonalInfoByUcenter(Integer cityId,AdminFunArchive adminFunArchive);
	
    /**
     * 更新最后登录时间
     * @param
     * @auther 胡坤
     * @since 2018/4/24
     * @return
     *
     */
	void updateUserLastLoginTime(Integer archiveId, Date date);

	void updateUserMobile(GeneralParam generalParam, String mobile);
	
	void updateUserPhoto(Integer archiveId, String photoPath);
	
	/**
	 * 增加夺宝币
	 * @author HeWei
	 * @since 2018年7月23日 下午4:07:21
	 * @param archiveId
	 * @param coinSource
	 * @param sourceId
	 * @param sourceType
	 * @param addFrom
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月23日
	 */
	public String addTreasureCoin(Integer archiveId, String coinSource, Integer sourceId, Integer sourceType, String addFrom,Integer userId,String otoFlag,String deptFlag,Integer cityId,String superUser,String userRight,Boolean personalVersion) throws Exception;
	
	public void updateUserService(Short cityId, Integer archiveId, String serviceReg, String serviceZoneIds);
	void updateMyBaseInfo(MyBaisInfoParam param);

	boolean judgeIsSupUser(Integer archiveId, boolean fromSoso);

	void updateFaceFlag(Integer cityId, Integer archiveId, Integer compId, Integer selfDeptId, Integer selfUserId, Byte faceFlag, String selfUserName);

	/**
     * 获取推送消息中用到的好房豆的别名
     * @param archiveId	经纪人档案id
     * @return 好房豆的别名
     */
    String getHfdAliasInPushMessage(Integer archiveId);
}

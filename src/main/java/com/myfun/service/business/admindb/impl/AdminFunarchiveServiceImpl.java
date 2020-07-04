package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.usercenter.param.MyBaisInfoParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.ActiveBrokerActionDto;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.admindb.param.ActiveBrokerActionParam;
import com.myfun.repository.admindb.param.BrokerArchiveParam;
import com.myfun.repository.admindb.param.RecommendPersonalListpParam;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.admindb.po.AdminFunTreasureCoinExample.Criteria;
import com.myfun.repository.agencydb.dao.AgencyFunCustMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.param.ErpFunLeaseParam;
import com.myfun.repository.erpdb.param.ErpFunSaleParam;
import com.myfun.repository.erpdb.param.ErpFunUsersParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCrmBrokerTrackService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunErpUserGuideService;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.*;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scala.annotation.meta.param;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdminFunarchiveServiceImpl extends AbstractService<AdminFunArchive, Integer>implements AdminFunArchiveService {

	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunUserAccountMapper userAccountMapper;
	@Autowired
	AdminFunUserRqsMapper rqsMapper;
	@Autowired
	AdminFunRegInfoMapper regInfoMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunPersonalIntentMapper adminFunPersonalIntentMapper;
	@Autowired
	private AdminCrmBrokerTrackMapper adminCrmBrokerTrackMapper;
	@Autowired
	private AdminCrmBrokerTrackService adminCrmBrokerTrackService;
	@Autowired
	ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	AdminMobileKeyMapper mobileKeyMapper;
	@Autowired
	AdminCrmBrokerTrackMapper crmBrokerTrackMapper;
	@Autowired
	AdminBanMapper banMapper;
	@Autowired
	AdminFunUserRqsMapper adminFunUserRqsMapper;
	@Autowired
	AdminSystemMessageMapper systemMessageMapper;
	@Autowired
	AdminMsgPushMapper msgPushMapper;
	@Autowired
	AdminAppLoginMapper appLoginMapper;
	@Autowired
	AdminFunPaidMapper funPaidMapper;
	@Autowired
	AdminFunUserAccountMapper funUserAccountMapper;
	@Autowired
	AdminSysParaMapper sysParaMapper;
	@Autowired
	AdminFunHaofangGiftMapper haofangGiftMapper;
	@Autowired
	ErpLimiteParaMapper limiteParaMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper buyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	AgencyFunCustMapper agencyFunCustMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired AdminBanMapper adminBanMapper;
	@Autowired AdminFunErpUserGuideService adminFunErpUserGuideService;
	@Autowired AdminFunArchiveServicezoneMapper adminFunArchiveServicezoneMapper;
	@Autowired ErpFunSectionMapper erpFunSectionMapper;
	@Autowired AdminFunBuildAttentionMapper adminFunBuildAttentionMapper;
	@Autowired AdminFunSectionMapper adminFunSectionMapper;
	@Autowired AdminFunArchiveLevelMarkingDetailMapper adminFunArchiveLevelMarkingDetailMapper;
	@Autowired AdminCrmUserMapper adminCrmUserMapper;
	@Autowired AdminCrmCompRangeMapper adminCrmCompRangeMapper;
	@Autowired AdminBrokerVisitMapper adminBrokerVisitMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	private AdminJmsMessageService adminJmsMessageService;
	@Autowired
	private AdminFunTreasureCoinMapper adminFunTreasureCoinMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminCustomLeaguesMapper adminCustomLeaguesMapper;
	@Autowired
	private AdminCustomLeaguesSkinModelMapper adminCustomLeaguesSkinModelMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunArchiveMapper;
	}

	/**
	 * 精英版管理列表
	 */
	@Override
	public PageInfo<AdminFunArchiveDto> getRecommendPersonalList(RecommendPersonalListpParam funArchive) {
		PageHelper.startPage(funArchive.getPageNum(), funArchive.getPageSize(), true);
		List<AdminFunArchiveDto> archives = adminFunArchiveMapper.getRecommendPersonalList(funArchive);
		return new PageInfo<>(archives);
	}

	@Override
	public AdminFunArchive selectByMobile(String userMobile) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByMobile(userMobile);
		return adminFunArchive;
	}

	@Override
	public int getCountByPhone(String phone, String cellphone) {
		return adminFunArchiveMapper.getCountByPhone(phone, cellphone);
	}

	/**
	 * 精英版登记列表
	 * 
	 */
	@Override
	public Page<AdminFunArchiveDto> getPersonalList(AdminFunArchive funArchive, int pageNumber) {
		PageHelper.startPage(pageNumber, Const.PAGE_NUMBER, true);
		Page<AdminFunArchiveDto> archives = adminFunArchiveMapper.getPersonalList(funArchive);
		return archives;
	}

	@Override
	public int countArchiveUaId(String archiveId) {
		return adminFunArchiveMapper.countArchiveUaId(archiveId);
	}

	/**
	 * 修改手机号码
	 */
	@Transactional
	@Override
	public int ChangePhoneNum(Map<String, Object> map) {
		ErpFunUsersParam erpFunUsers =new ErpFunUsersParam();
		erpFunUsers.setNewNum((String) map.get("newNum"));
		erpFunUsers.setUserMobile((String) map.get("oldNum"));
		erpFunUsers.setShardCityId(Integer.parseInt(map.get("cityId") + ""));
		adminFunArchiveMapper.updatePhoneNum(map);
		userAccountMapper.updatePhoneNum(map);
		//rqsMapper.updatePhoneNum(map);		//user_mobile字段无效，等待确认
		regInfoMapper.updatePhoneNum(map);
		erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updatePhoneNum(erpFunUsers);
		return 1;
	}

	@Override
	public List<AdminFunArchiveDto> getUserByMobile(String phoneNum) {
		List<AdminFunArchiveDto> userlist=adminFunArchiveMapper.getUserByMobile(phoneNum);
		return userlist;
	}

	@Override
	public int delUserByMobile(String phoneNum) {
		adminFunArchiveMapper.delUserByMobile(phoneNum);
		return 0;
	}

	/**
	 * 精英版批量移交
	 */
	@Transactional
	@Override
	public void translateDataAll(String sellId, String oldSellId) {
		adminFunArchiveMapper.translateDataBySellId(sellId, oldSellId);
		adminFunPersonalIntentMapper.translateDataByCreateUser(sellId, oldSellId);
	}

	/**
	 * 精英版数据移交
	 */
	@Transactional
	@Override
	public void translateData(String sellId, String ids) {
		// 找出哪些是更新fun_archive的 哪些是更新fun_personal_intent的
		String[] datas = ids.split(";");
		List<String> funArchiveIds = new ArrayList<String>();
		List<String> personalIds = new ArrayList<String>();
		for (int i = 0; i < datas.length; i++) {
			String[] dataInfo = datas[i].split(",");
			//为0代表非正式
			String isRegist = dataInfo[1];
			if ("0".equals(isRegist)) {
				personalIds.add(dataInfo[0]);
			} else {
				funArchiveIds.add(dataInfo[0]);
			}
		}
		//更新正式
		if(funArchiveIds.size() > 0){
			adminFunArchiveMapper.translateDataAll(sellId, funArchiveIds);
			adminFunPersonalIntentMapper.translateDataByArchiveId(sellId, funArchiveIds);
		}
		//更新非正式
		if(personalIds.size() > 0){
			adminFunPersonalIntentMapper.translateDataById(sellId, personalIds);
		}
	}

	/**
	 * 看跟进
	 */
	@Override
	public Page<AdminCrmBrokerTrack> getBrokerTrackList(Integer archiveId, Integer pageNumber) {
		PageHelper.startPage(pageNumber, Const.PAGE_NUMBER, true);
		Page<AdminCrmBrokerTrack> brokerTracks = adminCrmBrokerTrackMapper.selectByArchiveId(archiveId);
		return brokerTracks;
	}

	/**
	 * 经纪人档案
	 */
	@Override
	public PageInfo<AdminFunArchiveDto> getBrokerArchiveList(BrokerArchiveParam funArchiveParam) {
		//梳理查询条件
		if(null !=funArchiveParam.getUserAmount() && !"".equals(funArchiveParam.getUserAmount())){//资金账户
			funArchiveParam.setAmountMin(BigDecimal.valueOf(Double.parseDouble(funArchiveParam.getUserAmount().split("\\-")[0])));
			funArchiveParam.setAmountMax(BigDecimal.valueOf(Double.parseDouble(funArchiveParam.getUserAmount().split("\\-")[1])));
		}
		if(null !=funArchiveParam.getUserHaoFangAmount() && !"".equals(funArchiveParam.getUserHaoFangAmount())){//好房币
			funArchiveParam.setHaofangAmountMin(BigDecimal.valueOf(Double.parseDouble(funArchiveParam.getUserHaoFangAmount().split("\\-")[0])));
			funArchiveParam.setHaofangAmountMax(BigDecimal.valueOf(Double.parseDouble(funArchiveParam.getUserHaoFangAmount().split("\\-")[1])));
		}
		if(null !=funArchiveParam.getStatus() && !"".equals(funArchiveParam.getStatus())){		//状态
			switch (funArchiveParam.getStatus()) {
			case "actualWait":funArchiveParam.setRqsActualStatus(100);break;
			case "bothPass":funArchiveParam.setRqsActualStatus(1);funArchiveParam.setRqsAptitudeStatus(1);break;
			case "actualPass":funArchiveParam.setRqsActualStatus(1);break;
			case "aptitudePass":funArchiveParam.setRqsAptitudeStatus(1);break;
			case "actualFail":funArchiveParam.setRqsActualStatus(0);break;
			case "aptitudeFail":funArchiveParam.setRqsAptitudeStatus(0);break;
			case "bothFail":funArchiveParam.setRqsActualStatus(0);funArchiveParam.setRqsAptitudeStatus(0);break;
			case "webstoreOn":funArchiveParam.setWebstoreStatus(1);;break;
			case "webstoreOff":funArchiveParam.setWebstoreStatus(0);;break;
			case "houseBt50":funArchiveParam.setHouseSouseTotal(1);break;
			default:
				break;
			}
		}
		if(null !=funArchiveParam.getCustom() && !"".equals(funArchiveParam.getCustom())){	//客户回访
			funArchiveParam.setUserNote(Integer.valueOf(funArchiveParam.getCustom()));
		}
		PageHelper.startPage(funArchiveParam.getPageNum(), funArchiveParam.getPageSize(), true);
		return new PageInfo<>(adminFunArchiveMapper.getBrokerArchiveList(funArchiveParam));
	}

	/**
	 * 获取经纪人详情
	 * @param archiveId
	 * @return
	 */
	@Override
	public AdminFunArchiveDto getBrokerInfoByArchiveId(Integer archiveId) {
		return adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
	}

	/**
	 * 获取经纪人认证信息
	 * @param archiveId
	 * @return
	 */
	@Override
	public AdminFunArchive getFunArchiveByArchiveId(Integer archiveId) {
		return adminFunArchiveMapper.queryAdminFunArchiveId(archiveId);
	}

	
	
	@Override
	public AdminFunArchiveDto getBrokerApproveByArchiveId(Integer archiveId) {
		return adminFunArchiveMapper.getBrokerApproveByArchiveId(archiveId);
	}

	/**
	 * 站内留言
	 * @param archiveId
	 * @param msg
	 * @return
	 */
	@Override
	public int sendMsg(Integer archiveId, String msg) {
		AdminFunArchiveDto archiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		ErpFunUsers funUsersDto = erpFunUsersMapper.selectByArchiveId(archiveId);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		ErpFunMsg funMsg = new ErpFunMsg();
		funMsg.setShardCityId(Integer.parseInt(String.valueOf(archiveDto.getCityId())));
		funMsg.setReadFlag(false);
		funMsg.setCompId(funUsersDto.getCompId());
		funMsg.setReceiveDept(funUsersDto.getDeptId());
		funMsg.setMsgContent(msg);
		funMsg.setSendUser(999);
		funMsg.setReceiveUser(funUsersDto.getUserId());
		funMsg.setReceiveDel(false);
		funMsg.setSendTime(date);
		funMsg.setSendDel(false);
		erpFunMsgMapper.insertSelective(funMsg);
		return 1;
	}

	/**
	 * 发送验证码
	 * @param archiveId
	 * @param user
	 * @param ipAddr
	 * @return
	 * @throws ParseException
	 */
	@Transactional
	@Override
	public int sendSMSCode(Integer archiveId, AdminCrmUser user, String ipAddr) throws ParseException {
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		int key = new Random().nextInt(999999);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminMobileKey mobileKey = new AdminMobileKey();
		mobileKey.setMobile(funArchiveDto.getUserMobile());
		mobileKey.setKey(String.valueOf(key));
		mobileKey.setCreateTime(time.parse(time.format(date)));
		mobileKey.setIpAddr(ipAddr);
		mobileKeyMapper.insertSelective(mobileKey);
		
		/***此处调用短信接口***/
		
		//String content = "您本次解除绑定的验证码为："+key+"，请在个人中心输入并点击“解除绑定”，即可解除与门店版的绑定，本验证码当天有效";
		
		
		/********************/
		
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(archiveId);
		brokerTrack.setProvinceId(funArchiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[发送验证码]");
		brokerTrack.setTrackContent(user.getUserName()+"向该用户发送了手机验证码");
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);
		return 1;
	}

	@Override
	public AdminFunArchive getBrokerInfoByMobile(String mobile) {
		return adminFunArchiveMapper.getArchiveByMobile(mobile);
	}

	@Override
	public List<AdminBan> getBanRecords(Integer archiveId, Byte type) {
		AdminBan ban =new AdminBan();
		ban.setArchiveId(archiveId);
		ban.setType(type);
		return banMapper.getSlientRecordByArchiveId(ban);
	}

	/**
	 * 用户禁言
	 */
	@Transactional
	@Override
	public int userSilent(AdminBan ban, AdminCrmUser user) throws ParseException {
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(ban.getArchiveId());
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		ban.setCityId(funArchiveDto.getCityId());
		ban.setType((byte) 1);
		banMapper.insertSelective(ban);		//记录禁言信息
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(ban.getArchiveId());
		brokerTrack.setProvinceId(funArchiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[用户禁言]");
		brokerTrack.setTrackContent(user.getUserName()+"对该用户禁言操作");
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);		//写跟进
		this.sendMsg(ban.getArchiveId(), ban.getMsg());			//留言
		
		/***************老版逻辑--暂时注释*************************/
/*		String bound = request.getParameter("bound");
		  if(bound!=null){
			  BulletinJBean bulletinJBean = new BulletinJBean(request);
			  Operator currOperator = new Operator("0");
		  	  currOperator.setDSConnectionId(bulletinJBean.getSessionValue("webConnId"));
			  if(bound.equals("3") || bound.equals("4") || bound.equals("5")){
		   		 currOperator.setDSConnectionId(MyfunDataStructure.DS_CONN_ID$MYFUN_ADMIN);
		   	  }else if(bound.equals("0")){
		   		//currOperator.setDSConnectionId(operator.getMyLocalConnId());
		   		currOperator.setDSConnectionId(CityInfoUJBean.getCityConn(cityId));
		   	  }
			  String type = request.getParameter("type");
			  String id = request.getParameter("id");
			  String content = request.getParameter("cause");
			  HashMap hmap = new HashMap();
			  Condition condition2 = new Condition();
			  if(type.equals("bullet")){
				  condition2.add(new ConditionItem("BULLET_ID","=",id));
				  hmap.put("ISDELETE", "1");//删除标记
				  dbManager.updateRecord(currOperator, "BULLET", hmap, condition2);
			  }else{
				  condition2.add(new ConditionItem("REPLY_ID","=",id));
				  hmap.put("CONTENTS", content);
				  dbManager.updateRecord(currOperator, "BULLET_REPLY", hmap, condition2);
			  }
		  }*/
		
		return 0;
	}

	/**
	 * 取消禁言
	 * @param archiveId
	 * @return
	 */
	@Override
	public int delSilent(Integer archiveId) {
		AdminBan ban = new AdminBan();
		ban.setArchiveId(archiveId);
		ban.setType((byte) 1);
		return banMapper.deleteByArchiveId(ban);
	}

	/**
	 * 用户房源下架
	 * @param ban
	 * @param user
	 * @return
	 * @throws ParseException
	 */
	@Transactional
	@Override
	public int downHouse(AdminBan ban, AdminCrmUser user) throws ParseException {
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(ban.getArchiveId());
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		ban.setCityId(funArchiveDto.getCityId());
		ban.setType((byte) 2);
		banMapper.insertSelective(ban);		//记录房源下架
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(ban.getArchiveId());
		brokerTrack.setProvinceId(funArchiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[房源下架]");
		brokerTrack.setTrackContent(user.getUserName()+"将该用户房源下架");
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);	//写跟进
		this.sendMsg(ban.getArchiveId(), ban.getMsg());		//留言
		return 1;
	}

	@Transactional
	@Override
	public int cancelDownHouse(Integer archiveId, AdminCrmUser user) throws ParseException {
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminBan ban = new AdminBan();
		ban.setArchiveId(archiveId);
		ban.setType((byte) 2);
		banMapper.deleteByArchiveId(ban);
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(ban.getArchiveId());
		brokerTrack.setProvinceId(funArchiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[取消下架]");
		brokerTrack.setTrackContent(user.getUserName()+"对该用户房源取消下架操作");
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);	//写跟进
		return 1;
	}

	/**
	 * 用户认证操作
	 * @throws ParseException 
	 */
	@Transactional
	@Override
	public int saveAuditAction(String type, String result, Integer archiveId, String desc, String userNo, String userIcCode, AdminCrmUser user) throws ParseException {
		//获取用户信息
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		if(null == funArchiveDto){return -1;}
		AdminFunUserRqs funUserRqs = adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
		ErpFunUsers funUsers = erpFunUsersMapper.selectByArchiveId(archiveId);
		if(null==funUserRqs){
			AdminFunUserRqs UserRqs = new AdminFunUserRqs();
			UserRqs.setArchiveId(archiveId);
			adminFunUserRqsMapper.insertSelective(UserRqs);
		}
		
		if("0".equals(result)){	//认证失败
			if("a".equals(type)){//实名认证
			//	1.更新fun_archive表USER_RIGHT
				AdminFunArchive archive = new AdminFunArchive();
				archive.setArchiveId(archiveId);
				archive.setUserRight(0);
				adminFunArchiveMapper.updateByPrimaryKeySelective(archive);
			// 2.更新fun_user_rqs表rqs_actual_status rqs_actual_desc rqs_actual_time process_by
				AdminFunUserRqs rqs = new AdminFunUserRqs();
				rqs.setRqsActualStatus(0);
				rqs.setRqsActualDesc(desc);
				rqs.setRqsActualTime(time.parse(time.format(date)));
				rqs.setProcessBy(String.valueOf(user.getArchiveId()));
				rqs.setArchiveId(archiveId);
				adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
				
			}else if("b".equals(type)){//资质认证
			// 1.更新fun_archive表USER_HONEST
				AdminFunArchive archive = new AdminFunArchive();
				archive.setArchiveId(archiveId);
				archive.setUserHonest(0);
				adminFunArchiveMapper.updateByPrimaryKeySelective(archive);
				
			// 2.更新fun_user_rqs表rqs_aptitude_status rqs_actual_desc rqs_actual_time process_by
				AdminFunUserRqs rqs = new AdminFunUserRqs();
				rqs.setRqsAptitudeStatus(0);
				rqs.setRqsAptitudeDesc(desc);
				rqs.setRqsAptitudeTime(time.parse(time.format(date)));
				rqs.setProcessBy(String.valueOf(user.getArchiveId()));
				rqs.setArchiveId(archiveId);
				adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
			}
		//公用操作
		// P1.新增一条本地库FUN_MSG记录
			ErpFunMsg funMsg = new ErpFunMsg();
			funMsg.setShardCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
			funMsg.setCompId(funUsers.getCompId());
			funMsg.setReadFlag(false);
			funMsg.setReceiveDept(funUsers.getDeptId());
			funMsg.setMsgContent("抱歉，您的好房通实名认证没有通过审核，原因："+desc);
			funMsg.setSendUser(999);
			funMsg.setReceiveUser(funUsers.getUserId());
			funMsg.setReceiveDel(false);
			funMsg.setSendTime(date);
			funMsg.setSendDel(false);
			erpFunMsgMapper.insertSelective(funMsg);
		// P2.系统消息 SYSTEM_MESSAGE
			//写留言
			String  aptiStr = "抱歉，您的好房通资质认证没有通过审核，原因："+desc;
			this.procPushMsg(archiveId, "您有一条消息", aptiStr);
		}else if("1".equals(result)){	//认证成功
			if("a".equals(type)){//实名认证
	/*************************实名认证成功开始*************************/
			// 1.更新fun_archive表USER_RIGHT
				AdminFunArchive archive = new AdminFunArchive();
				archive.setArchiveId(archiveId);
				archive.setUserRight(1);
				adminFunArchiveMapper.updateByPrimaryKeySelective(archive);
			// 2.更新fun_user_rqs表rqs_actual_status rqs_actual_desc rqs_actual_time process_by
				AdminFunUserRqs rqs = new AdminFunUserRqs();
				rqs.setRqsActualStatus(1);
				rqs.setRqsActualDesc(desc);
				rqs.setRqsActualTime(time.parse(time.format(date)));
				rqs.setProcessBy(String.valueOf(user.getArchiveId()));
				rqs.setArchiveId(archiveId);
				adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
			//实名认证，赠送10好房币  Edit By 谢亮 @2014-11-27   Edit By 谢亮  @2015-04-01(赠送好房币修改为赠送优惠券)
			//查询是否赠送过
				if(StringUtil.isEmpty(String.valueOf(funArchiveDto.getUaId()))){
					AdminFunPaid funPaid = new AdminFunPaid();
					funPaid.setUaId(funArchiveDto.getUaId());
					funPaid.setPaidType("DVALID_COIN");
					funPaid.setCardno("valid4"+funArchiveDto.getUaId());
					AdminFunPaid paid = funPaidMapper.selectByCondition(funPaid);
					if(null != paid){
						AdminSysPara days = sysParaMapper.selectByPrimaryKey("EFFECTIVE_TIME");
						Calendar day=Calendar.getInstance();
						day.add(Calendar.DATE, Integer.parseInt(days.getParamValue()));
						funUserAccountMapper.updateHaoFangAmount(funArchiveDto.getUaId());
						AdminFunPaid paid2 = new AdminFunPaid();
						paid2.setUaId(funArchiveDto.getUaId());
						paid2.setArchiveId(archiveId);
						paid2.setCityId(funArchiveDto.getCityId());
						paid2.setPaidCatigory("GIFT");
						paid2.setPaidType("DVALID_COIN");
						paid2.setCardno("valid4" + funArchiveDto.getUaId());
						paid2.setAmount((double) 10);
						paid2.setPadiTime(time.parse(time.format(date)));
						String cionStr = "恭喜！您已通过实名，活动期间已赠送您10优惠券(优惠券有效期至:" +time.format(day.getTime())+ "，到期自动清零)。";
						paid2.setDesc(cionStr);
						funPaidMapper.insertSelective(paid2);
					// P1.写留言
						ErpFunMsg funMsg = new ErpFunMsg();
						funMsg.setShardCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
						funMsg.setCompId(funUsers.getCompId());
						funMsg.setReadFlag(false);
						funMsg.setReceiveDept(funUsers.getDeptId());
						funMsg.setMsgContent(cionStr);
						funMsg.setSendUser(999);
						funMsg.setReceiveUser(funUsers.getUserId());
						funMsg.setReceiveDel(false);
						funMsg.setSendTime(new Date());
						funMsg.setSendDel(false);
						erpFunMsgMapper.insertSelective(funMsg);
					// P2.系统消息 SYSTEM_MESSAGE
						this.procPushMsg(archiveId, "您有一条消息", cionStr);
					//写赠送好房币记录	
						this.giftCoin(funArchiveDto.getUaId(), "10", "1");
					}
				}
			//初始化全城联网查看发布数	
				int limiteParaRecord = limiteParaMapper.selectRecordCount(funArchiveDto.getCityId(), archiveId);
				if(limiteParaRecord > 0){
					ErpLimitePara limitePara =new ErpLimitePara();
					limitePara .setSaleCoopView(200);
					limitePara.setLeaseCoopView(200);
					limitePara.setLimiteDate(time.parse(time.format(date)));
					limitePara.setArchiveId(archiveId);
					limiteParaMapper.updateByPrimaryKeySelective(limitePara);
				}else{
					ErpLimitePara limitePara =new ErpLimitePara();
					limitePara .setSaleCoopView(200);
					limitePara.setLeaseCoopView(200);
					limitePara.setLimiteDate(time.parse(time.format(date)));
					limitePara.setArchiveId(archiveId);
					limitePara.setDayLeaseCoop(0);
					limitePara.setDaySaleCoop(0);
					limiteParaMapper.insertSelective(limitePara);
				}
			//门店版实名认证 自动动过资质认证
				if("0".equals(funArchiveDto.getUserEdition()) || "-1".equals(funArchiveDto.getUserEdition()) || "1".equals(funArchiveDto.getUserEdition())){
					//实名认证自动通过资质认证
					AdminFunArchive funArchive = new AdminFunArchive();
					funArchive.setArchiveId(archiveId);
					funArchive.setUserHonest(1);
					adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);
					
					AdminFunUserRqs userRqs = new AdminFunUserRqs();
					userRqs.setRqsAptitudeStatus(1);
					userRqs.setRqsAptitudeTime(time.parse(time.format(date)));
					userRqs.setRqsAptitudeDesc(desc);
					userRqs.setArchiveId(archiveId);
					adminFunUserRqsMapper.updateByPrimaryKeySelective(userRqs);
				}
			//写留言
				desc = "恭喜！您的实名认证已通过，现在已经可以使用短信平台、" +
						"个人账户充值、搜发房功能开通、使用精英版登录以及快速申请其他网站的实名认证。";
				this.sendMsg(archiveId,desc);
			//初始化小区推送	(执行存储过程)
				adminFunArchiveMapper.initPushBuild(archiveId);
	/*************************实名认证成功结束*************************/	
			}else if("b".equals(type)){//资质认证
			//更新资质认证状态 USER_HONEST 
				AdminFunArchive funArchive = new AdminFunArchive();
				funArchive.setArchiveId(archiveId);
				funArchive.setUserHonest(1);
				adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);
			//更新fun_user_rqs rqs_aptitude_status rqs_actual_desc rqs_actual_time process_by	
				AdminFunUserRqs userRqs = new AdminFunUserRqs();
				userRqs.setRqsAptitudeStatus(1);
				userRqs.setRqsAptitudeTime(time.parse(time.format(date)));
				userRqs.setRqsAptitudeDesc(desc);
				userRqs.setArchiveId(archiveId);
				userRqs.setProcessBy(String.valueOf(user.getArchiveId()));
				adminFunUserRqsMapper.updateByPrimaryKeySelective(userRqs);
			//送积分
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("archiveId", archiveId);
				map.put("type", "3");
				map.put("num", "0");
				adminFunArchiveMapper.giveScore(map);
			//写留言
				desc = "恭喜！您的资质认证已通过。";
				this.sendMsg(archiveId,desc);
				//procPushMsg(archiveId, "您有一条消息", desc);
				this.procPushMsg(archiveId, "您有一条消息", desc);
			}
			
		}
		return 1;
	}

	private void procPushMsg(Integer archiveId, String msg, String desc) throws ParseException {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminSystemMessage systemMessage = new AdminSystemMessage();
		int msgId = systemMessageMapper.getId()+1;
		systemMessage.setMsgId(msgId);
		systemMessage.setArchiveId(archiveId);
		systemMessage.setTitle("系统消息");
		systemMessage.setMsgContent(desc);
		systemMessage.setIsRead(0);
		systemMessage.setCreateTime(time.parse(time.format(date)));
		systemMessage.setMsgType(4);
		systemMessage.setJson("{\"URL\":\"\",\"URL_TITLE\":\"\"}");
		systemMessageMapper.insertSelective(systemMessage);
	// P3.短信推送 MSG_PUSH
		AdminAppLogin appLogin = appLoginMapper.selectByPrimaryKey(archiveId);
		AdminMsgPush msgPush = new AdminMsgPush();
		msgPush.setDeviceType(appLogin.getDeviceType());
		msgPush.setPushToken(appLogin.getPushToken());
		msgPush.setIsPush(0);
		msgPush.setPushTitle("系统消息");
		msgPush.setPushContent(msg);
		msgPush.setCreateTime(time.parse(time.format(date)));
		msgPush.setReceiveArchiveId(String.valueOf(archiveId));
		msgPush.setSendArchiveId("0");
		msgPush.setPushLevel(2);
		msgPush.setUserType((byte) 1);
		msgPush.setPushJson("{\"type\":\"0\",\"msg_id\":\"" +msgId+ "\",\"msg_type\":\"4\"}");
		msgPushMapper.insertSelective(msgPush);
		
	}

	private void giftCoin(Integer uaId, String coin, String type) throws ParseException {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar day=Calendar.getInstance();
		Date date =new Date();
		if("1".equals(type)){
			AdminSysPara days = sysParaMapper.selectByPrimaryKey("EFFECTIVE_TIME");
			if(null != days){
				day.add(Calendar.DATE, Integer.parseInt(days.getParamValue()));
			}
			AdminFunPaid funPaid = new AdminFunPaid();
			funPaid.setUaId(uaId);
			funPaid.setPaidCatigory("GIFT");
			
			AdminFunPaid adminFunPaid = funPaidMapper.getPaidRecord(funPaid);
			if( null != adminFunPaid){
				AdminFunHaofangGift record =new AdminFunHaofangGift();
				record.setUaId(uaId);
				record.setAmount(Double.parseDouble(coin));
				record.setPaidId(adminFunPaid.getPaidId());
				record.setCreationTime(time.parse(time.format(date)));
				record.setEndTime(time.parse(time.format(day.getTime())));
				haofangGiftMapper.insertSelective(record);
			}
		}
		
	}

	@Override
	public List<String> selectHasUser(AdminFunArchive archive) {
		return adminFunArchiveMapper.selectHasUser(archive);
	}

	@Transactional
	@Override
	public void updateUserInfo(AdminFunArchiveDto archive) {
		//获取用户档案（用于切换数据库）
		AdminFunArchiveDto funArchiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archive.getArchiveId());
		//更新fun_users
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setUserMobile(archive.getUserMobile());
		erpFunUsers.setUserName(archive.getUserName());
		erpFunUsers.setUserSex(archive.getUserSex()==0?false:true);
		erpFunUsers.setShardCityId(Integer.parseInt(String.valueOf(funArchiveDto.getCityId())));
		erpFunUsers.setArchiveId(archive.getArchiveId());
		erpFunUsers.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunUsersMapper.updateByArchiveIdSelective(erpFunUsers);
		//更新 FUN_USER_RQS
		AdminFunUserRqs rqs = new AdminFunUserRqs();
		rqs.setArchiveId(archive.getArchiveId());
		if(StringUtil.isNotEmpty(archive.getCompName())){
			rqs.setCompName(archive.getCompName());
		}
		adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
		//更新FUN_ARCHIVE 
		AdminFunArchive funArchive = new AdminFunArchive();
		funArchive.setUserEmail(archive.getUserEmail());
		adminFunArchiveMapper.updateByPrimaryKeySelective(archive);
		//--如果身份证更换，需要把FUN_PAID的也更换

		AdminFunPaid funPaid1 =new AdminFunPaid();
		funPaid1.setArchiveId(archive.getArchiveId());
		Map<String, Object> condition =new HashMap<String, Object>();
		condition.put("archiveId", archive.getArchiveId());
		condition.put("archiveId", archive.getArchiveId());
		condition.put("paidType1", "23");	//数据字典PAID_TYPE
		condition.put("paidType2", "24");
		List<AdminFunPaid> paid = funPaidMapper.getFunPaidByArchiveIdAndPaidType(condition);
		if(paid.size() > 0){
			AdminFunPaid funPaid =new AdminFunPaid();
			funPaid.setCardno(archive.getUserIccode());
			funPaid.setArchiveId(archive.getArchiveId());
			funPaidMapper.updateCardNo(funPaid);
		}
		
	}

	@Transactional
	@Override
	public String sepratorPer(Integer archiveId, AdminCrmUser user) throws ParseException {
		String returnV = "SUCCESS";
		String verName = "企业版";
		String cityId = "";
		String userConnId = "";
		String compNo = "";
		String deptNo = "";
		Integer erpDeptId=null;
		AdminFunArchiveDto archiveDto = adminFunArchiveMapper.getBrokerInfoByArchiveId(archiveId);
		//清除FUN_ARCHIVE和FUN_USER_RQS 上的认证信息
		AdminFunArchive archive = new AdminFunArchive();
		archive.setUserEdition(2);
		archive.setFriendFlag(1);
		archive.setArchiveId(archiveId);
		if("1".equals(archiveDto.getUserHonest())){
			archive.setUserHonest(0);
			archive.setShopInnerPhoto("null");
			archive.setShopOuterPhoto("null");
			archive.setCardPhoto("null");
			//清除FUN_USER_RQS
			AdminFunUserRqs rqs = new AdminFunUserRqs();
			rqs.setArchiveId(archiveId);
			rqs.setRqsAptitudeStatus(0);
			adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
		}
		//清除FUN_ARCHIVE
		adminFunArchiveMapper.updateByPrimaryKeySelective(archive);
		//数据移交到总经理
		String userId = this.dataTransfer(archiveId, archiveDto.getCityId());
		if(userId.equals("ISMANAGEUSER")){
			 return "ISMANAGEUSER";
		}
		//获取cityNo,用于创建精英版账户
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(archiveDto.getCityId());
		//获取门店信息
		ErpFunDepts depts = erpFunDeptsMapper.queryDept(archiveDto.getArchiveId());
		compNo = depts.getCompNo();
		deptNo = depts.getDeptNo();
		erpDeptId = depts.getDeptId();
		//新建精英版用户
		this.createUser(archiveId, adminFunCity.getCompNo(), archiveDto.getCityId());
		//写留言 改调用存储过程
		String msg="由于你的帐号与门店版脱离，系统自动注销掉你原有的资质认证，请尽快提交资料重新审核！";
		erpFunUsersMapper.writeSysMsg(archiveDto.getCityId(), userId, msg);
		// 写跟进
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminCrmBrokerTrack brokerTrack = new AdminCrmBrokerTrack();
		brokerTrack.setArchiveId(archiveId);
		brokerTrack.setProvinceId(archiveDto.getProvinceId());
		brokerTrack.setCityId(Integer.parseInt(String.valueOf(archiveDto.getCityId())));
		brokerTrack.setCompId(user.getCompId());
		brokerTrack.setDeptId(user.getDeptId());
		brokerTrack.setTrackDesc("[脱离"+verName+"]");
		brokerTrack.setTrackContent(user.getUserName()+"于当重置了该用户脱离");
		brokerTrack.setTrackTime(time.parse(time.format(date)));
		brokerTrack.setTrackId(crmBrokerTrackMapper.getId()+1);
		crmBrokerTrackMapper.insertSelective(brokerTrack);
		return returnV;
	}

	private String createUser(Integer archiveId, String cityNo, Short cityId) {
		Map<String, Object> map =new HashMap<String, Object>();
		Integer userId = erpFunUsersMapper.getId(cityId)+1;
		map.put("archiveId", archiveId);
		map.put("userId", userId);
		map.put("cityNo", cityNo);
		map.put("userStatus", Const.UserStatus.DIC_USER_STATUS_FORMAL);
		// 创建新的精英版用户
		erpFunUsersMapper.createUser(cityId,map);
		//注销原有用户
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		ErpFunUsers funUsers = new ErpFunUsers();
		funUsers.setUserWriteoff(true);
		funUsers.setUserId(userId);
		funUsers.setArchiveId(archiveId);
		funUsers.setWriteoffTime(time.format(date));
		funUsers.setShardCityId(Integer.parseInt(String.valueOf(cityId)));
		erpFunUsersMapper.writeOffUser(funUsers);
		return String.valueOf(userId);
	}

	private String dataTransfer(Integer archiveId, Short cityId) throws ParseException {
		//找到总经理账户
		Integer erpUserId = null;
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		List<ErpFunUsersDto> erpFunUsers = erpFunUsersMapper.getManagerUser(cityId, archiveId);
		if(erpFunUsers.size()>0){
			//判断是否是总经理 如果是总经理的 则提示  此用户是总经理帐户，只能停用该分店方可脱离
			erpUserId = erpFunUsers.get(0).getUserId();
			Integer manageUserId = erpFunUsers.get(0).getManageUserId();
			Integer manageAreaId = erpFunUsers.get(0).getAreaId();
			Integer manageRegId = erpFunUsers.get(0).getRegId();
			Integer manageDeptId = erpFunUsers.get(0).getDeptId();
			Integer manageArchiveid = erpFunUsers.get(0).getManageArchiveId();
			if(erpUserId.equals(manageUserId)){
				return "ISMANAGEUSER";
			}
			//不是总经理 则把所有房源客源移交给总经理 
			//FUN_SALE
			Integer shardCityId = Integer.parseInt(String.valueOf(cityId));
			ErpFunSaleParam erpFunSale = new ErpFunSaleParam();
			erpFunSale.setShardCityId(shardCityId);
			erpFunSale.setAreaId(manageAreaId);
			erpFunSale.setRegId(manageRegId);
			erpFunSale.setDeptId(manageDeptId);
			erpFunSale.setUserId(erpUserId);
			erpFunSale.setUpdateTime(time.parse(time.format(date)));
			erpFunSale.setManageUserId(manageUserId);
			erpFunSaleMapper.updateByUserId(erpFunSale);
			
			//FUN_LEASE
			ErpFunLeaseParam erpFunLease = new ErpFunLeaseParam();
			erpFunLease.setShardCityId(shardCityId);
			erpFunLease.setAreaId(manageAreaId);
			erpFunLease.setRegId(manageRegId);
			erpFunLease.setDeptId(manageDeptId);
			erpFunLease.setUserId(erpUserId);
			erpFunLease.setUpdateTime(time.parse(time.format(date)));
			erpFunLease.setManageUserId(manageUserId);
			erpFunLeaseMapper.updateByUserId(erpFunLease);
			//ErpFunBuyCustomer buyCustomer = new ErpFunBuyCustomer();
			Map<String, Object> map =new HashMap<String, Object>();
			map.put("manageAreaId", manageAreaId);
			map.put("manageRegId", manageRegId);
			map.put("manageDeptId", manageDeptId);
			map.put("erpUserId", erpUserId);
			map.put("updateTime", time.parse(time.format(date)));
			map.put("manageUserId", manageUserId);
			//FUN_BUY_CUSTOMER
			buyCustomerMapper.updateByUserId(shardCityId, map);
			//FUN_RENT_CUSTOMER
			erpFunRentCustomerMapper.updateByUserId(shardCityId, map);
			
			//脱离门店版 判断是否有联动分销数据 如果有 则移交只总经理
			Map<String, Object> agencyMap =new HashMap<String, Object>();
			agencyMap.put("manageUserId", manageUserId);
			agencyMap.put("manageArchiveid", manageArchiveid);
			agencyMap.put("archiveId", archiveId);
			//AgencyFunCustMapper
			agencyFunCustMapper.updateByArchiveId(agencyMap);
			return String.valueOf(erpUserId);
		}
		return null;
	}

	@Override
	public AdminFunUserRqs getUserRqsInfo(Integer archiveId) {
		return adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
	}

	@Override
	public int updateUserRqs(AdminFunUserRqs rqs) {
		adminFunUserRqsMapper.updateByPrimaryKeySelective(rqs);
		return 1;
	}

	/**
	 * 获取活跃经纪人列表
	 */
	@Override
	public PageInfo<ActiveBrokerActionDto> getActiveBrokerList(ActiveBrokerActionParam param) throws ParseException {
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		if(param.getQryType() == null){
			param.setQryType("1");
		}
		int timeType = param.getTimeType();
		String MinTime ="";
		String MaxTime ="";
		if(timeType == 0){	//按月查询
			MinTime = param.getActiveTimeMonth()+"-01 00:00:00";
			MaxTime = DateUtil.addMonth(MinTime, 1);
		}else if(timeType == 1){
			MinTime = param.getActiveTimeDay()+" 00:00:00";
			MaxTime = param.getActiveTimeDay()+" 23:59:59";
		}
		String qryType = param.getQryType();
		if("1".equals(qryType)){//最后登录
			param.setLoginMinTime(DateUtil.StringToDate(MinTime, "yyyy-MM-dd"));
			param.setLoginmaxTime(DateUtil.StringToDate(MaxTime, "yyyy-MM-dd"));
		}else if("2".equals(qryType)){//最后跟进
			param.setTrackMinTime(DateUtil.StringToDate(MinTime, "yyyy-MM-dd"));
			param.setTrackMaxTime(DateUtil.StringToDate(MaxTime, "yyyy-MM-dd"));
		}else if("3".equals(qryType)){//最新注册
			param.setRegMinTime(DateUtil.StringToDate(MinTime, "yyyy-MM-dd"));
			param.setRegMaxTime(DateUtil.StringToDate(MaxTime, "yyyy-MM-dd"));
		}else if("4".equals(qryType)){//最新注销
			param.setWriteOffMinTime(DateUtil.StringToDate(MinTime, "yyyy-MM-dd"));
			param.setWriteOffMaxTime(DateUtil.StringToDate(MaxTime, "yyyy-MM-dd"));
		}
		return new PageInfo<ActiveBrokerActionDto>(adminFunArchiveMapper.getArchiveByLoginTime(param));
	}

	@Override
	public AdminFunArchive getRecordByUserMobileAndCompId(String userMobile, String superComp, Integer compid) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getRecordByUserMobileAndCompId(userMobile, superComp, compid);
		return adminFunArchive;
	}

	@Override
	public AdminFunArchive getUserNameByUaId(String uaId) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getUserNameByUaId(uaId);
		return adminFunArchive;
	}

	@Override
	public List<AdminFunArchive> getArchiveIdList(String archiveIds) {
		return adminFunArchiveMapper.getArchiveIdList(archiveIds);
	}

	@Override
	public List<AdminFunArchive> getArchiveInfosByIds(List<Integer> archiveIds) {
		return adminFunArchiveMapper.getArchiveInfosByIds(archiveIds);
	}

	@Override
	public Map<Integer, AdminFunArchive> getModelDataMap(List<Integer> archiveIds) {
		Map<Integer, AdminFunArchive> userMap = new HashMap<Integer, AdminFunArchive>();
		List<AdminFunArchive> list = this.getArchiveInfosByIds(archiveIds);
		if(list != null && !list.isEmpty()) {
			for (AdminFunArchive adminFunArchive : list) {
				userMap.put(adminFunArchive.getArchiveId(), adminFunArchive);
			}
		}
		return userMap;
	}

	@Override
	public Integer isSuperUser(Integer superUser, Date superEnd) {
		try {
			if (superEnd == null) {
				superUser = 0;
			} else if (superUser.equals("1")) {
				Date nowDate = DateTimeHelper.getSystemDate();
				if (DateTimeHelper.compareTwoDate(nowDate, superEnd) < 0){
					superUser = 0;
				}
			}
			return superUser;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public void updateFriendFlagForSysParaByKeys(Integer cityId, Integer compId, Set<Integer> archiveIds, String string) {
		// TODO Auto-generated method stub
	}

	@Transactional
	@Override
	public AdminFunArchive createOrUpdateByErpCreateUser(Integer cityId, String serviceReg, String serviceZone, String serviceZoneIds,
														 ErpFunUsers erpFunUsers, Integer provinceId, Integer selUid, byte type) {
		AdminFunArchive funArchiveSelect = adminFunArchiveMapper.getArchiveByMobile(erpFunUsers.getUserMobile());
		AdminFunArchive funArchiveInsert = new AdminFunArchive();
		if(funArchiveSelect != null) {
			if(funArchiveSelect.getUserEdition() != 2) {
				ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
				String deptName = (byDeptId == null) ? "" : byDeptId.getDeptCname();
				throw new ConfirmException("您已加入"+deptName+"门店<br/>请先从此门店注销后再进行此操作！");
			}
		}
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		String userPhoto = erpFunUsers.getUserPhoto();
		String userPhotoMin = erpFunUsers.getUserPhotoMin();
		if (StringUtils.isNotBlank(userPhoto)) {
			userPhoto = userPhoto.replaceAll(CommonUtil.getPhotoUrl(userPhoto), "");
			userPhoto = userPhoto.replaceAll(AppConfig.getPicDomainUrl(), "");
			funArchiveInsert.setUserPhoto(userPhoto);
		}
		if (StringUtils.isNotBlank(userPhotoMin)) {
			userPhotoMin = userPhotoMin.replaceAll(CommonUtil.getPhotoUrl(userPhotoMin), "");
			userPhotoMin = userPhotoMin.replaceAll(AppConfig.getPicDomainUrl(), "");
			funArchiveInsert.setUserPhotoMin(userPhotoMin);
		}
		if(StringUtils.isNotBlank(serviceReg)) {
			funArchiveInsert.setServiceReg(" "+serviceReg.trim()+" ");
		}
		if(StringUtils.isNotBlank(serviceZone)) {
			funArchiveInsert.setServiceZone(" "+serviceZone.trim()+" ");
		}
		if(StringUtils.isNotBlank(serviceZoneIds)) {
			funArchiveInsert.setServiceZoneIds(" "+serviceZoneIds.trim()+" ");
		}
		funArchiveInsert.setUserEdition(erpFunUsers.getUserEdition());
		funArchiveInsert.setCityId(erpFunUsers.getCityId());
		funArchiveInsert.setUserName(erpFunUsers.getUserName());
		funArchiveInsert.setUserSex((byte) (erpFunUsers.getUserSex()?1:0));
		funArchiveInsert.setProvinceId(adminFunCity.getProvinceId().intValue());
		funArchiveInsert.setIsRegist((byte)1);// 是否已经完善资料 0=尚未完善，登录时需要完善 1=已经完善
		// 判断定制
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, erpFunUsers.getCompId());
		if(null != erpFunComp) {
			AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
			// 开启定制的公司，不用弹协议窗
			if(null != adminFunComp && null != adminFunComp.getSpecialCustomized() && 1== adminFunComp.getSpecialCustomized().intValue()) {
				funArchiveInsert.setAgreeTruehouseRule((byte) 1);
			}
		}

		// 以前没有时插入
		if(funArchiveSelect == null) {
			AdminFunCity adminFunCityPO = adminFunCityMapper.selectByPrimaryKey(erpFunUsers.getCityId());
			Boolean superUser = adminFunCityPO.getSuperUser();
			Date superTime = adminFunCityPO.getSuperTime();
			Short superDay = adminFunCityPO.getPersonalSuper();
			Integer preSuperDays = 0; // 档案表中的SUPER_DAYS
			if (DateTimeHelper.getDaysOfTwoDate(superTime, new Date()) < 0D) {
				superDay = 0;
			} else {
				if(superDay != null) {
					preSuperDays = superDay.intValue();
				} else {
					superDay = 0;
				}
			}
			Date superStart = new Date();
			Date superEnd = DateTimeHelper.addDays(superStart, superDay);
			if (superUser && superDay > 0) {
				superEnd = superStart;
			}
			funArchiveInsert.setSuperUser(superDay <= 0 ? 0 : 1);
			funArchiveInsert.setSuperStart(superStart);
			funArchiveInsert.setSuperEnd(superEnd);
			funArchiveInsert.setSuperDays(preSuperDays);
			funArchiveInsert.setMobileValided((byte) 1);
			funArchiveInsert.setUserMobile(erpFunUsers.getUserMobile());
			funArchiveInsert.setCreationTime(new Date());
			funArchiveInsert.setRegFrom(type);// 7=邀请注册
			funArchiveInsert.setPlateType((byte) 0);
			funArchiveInsert.setProvinceId(provinceId);
			setSellerInfo(cityId,funArchiveInsert,false,selUid);
			funArchiveInsert = updateSeverIds(funArchiveInsert);
			funArchiveInsert.setArchiveLevel(1);
			adminFunArchiveMapper.insertSelective(funArchiveInsert);

			AdminFunArchiveLevelMarkingDetail levelMarking=new AdminFunArchiveLevelMarkingDetail();
			levelMarking.setCreateTime(new Date());
			levelMarking.setUserId(funArchiveInsert.getSellId());
			levelMarking.setAffiliationSellId(funArchiveInsert.getSellId());
			levelMarking.setArchiveId(funArchiveInsert.getArchiveId());
			levelMarking.setArchiveLevel(1);
			adminFunArchiveLevelMarkingDetailMapper.insertSelective(levelMarking);

			AdminBrokerVisit brokerVisit=new AdminBrokerVisit();
			brokerVisit.setBvPhone(funArchiveInsert.getUserMobile());
			if (adminBrokerVisitMapper.getCountByCondition(brokerVisit)>0){
				AdminBrokerVisit updateModel=new AdminBrokerVisit();
				updateModel.setIsReg((byte)1);
				updateModel.setRegSource((byte)2);
				updateModel.setBvPhone(funArchiveInsert.getUserMobile());
				adminBrokerVisitMapper.updateBrokerVisitByBvPhone(updateModel);
				try {
					adminFunArchiveMapper.moveTrack(funArchiveInsert.getArchiveId(),funArchiveInsert.getUserMobile());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			adminFunErpUserGuideService.insertAllUserGuide(funArchiveInsert.getArchiveId());
		} else {
			if (1 == funArchiveSelect.getUserRight()) {
				funArchiveInsert.setUserName(null);
				funArchiveInsert.setUserSex(null);
				funArchiveInsert.setUserHonest(1);// 用户关联门店时如果已经认证则 直接完成资质认证
				AdminFunUserRqs funUserRqsPO = new AdminFunUserRqs();
				funUserRqsPO.setArchiveId(funArchiveSelect.getArchiveId());
				funUserRqsPO.setRqsAptitudeStatus(1);
				funUserRqsPO.setRqsAptitudeDesc("恭喜！您的资质认证已通过。");
				funUserRqsPO.setRqsAptitudeTime(new Date());
				adminFunUserRqsMapper.updateByPrimaryKeySelective(funUserRqsPO);
			}
			funArchiveInsert.setArchiveId(funArchiveSelect.getArchiveId());
			funArchiveInsert.setMobileValided((byte) 1);
			funArchiveInsert = updateSeverIds(funArchiveInsert);
			adminFunArchiveMapper.updateByPrimaryKeySelective(funArchiveInsert);
		}
		// 添加滴滴好房经纪人服务器区域
		this.updateUserService(erpFunUsers.getCityId(), funArchiveInsert.getArchiveId(), funArchiveInsert.getServiceReg(), funArchiveInsert.getServiceZoneIds());
		return funArchiveInsert;
	}

	/**
	* 新版组织机构新增FUN_ARCHIVE信息
	* @param null
	* @author zangtie
	* @since 2019/12/9 14:05
	* @return
	**/
	@Transactional
	@Override
	public AdminFunArchive createOrUpdateByErpCreateUserNew(Integer cityId, String serviceReg, String serviceZone, String serviceZoneIds,
														 ErpFunUsers erpFunUsers, Integer provinceId, Integer selUid, byte type) {
		AdminFunArchive funArchiveSelect = null;
		String userIccode = erpFunUsers.getUserIccode();
		if(StringUtils.isNotBlank(userIccode)) {
			AdminFunArchiveExample adminFunArchiveExample = new AdminFunArchiveExample();
			adminFunArchiveExample.createCriteria().andUserIccodeEqualTo(userIccode);
			List<AdminFunArchive> adminFunArchives =  adminFunArchiveMapper.selectByExample(adminFunArchiveExample);
			if(adminFunArchives.size() > 0) {
				funArchiveSelect = adminFunArchives.get(0);
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.setShardCityId(cityId);
				erpFunUsersExample.createCriteria().andArchiveIdEqualTo(funArchiveSelect.getArchiveId()).andUserWriteoffEqualTo(false);
				int count = erpFunUsersMapper.countByExample(erpFunUsersExample);
				Assert.isTrueThrow(count > 0, "此身份证已有在职人员");
			}
		}

		if(null == funArchiveSelect) {
			funArchiveSelect = adminFunArchiveMapper.getArchiveByMobile(erpFunUsers.getUserMobile());
		}
		AdminFunArchive funArchiveInsert = new AdminFunArchive();
		if(funArchiveSelect != null) {
			//判断城市是否一致
			Assert.isTrueThrow(cityId.intValue() != funArchiveSelect.getCityId().intValue(), "城市不一致");
			//判断当前archive_id是否存在在职用户
			ErpFunUsers erpFunUsers2 = erpFunUsersMapper.getValidUserByArchiveId(funArchiveSelect.getArchiveId());
			if(erpFunUsers2 != null){
				Assert.isTrueThrow(true, "当前用户已在职，不能重复注册");
			}
			
			/*jsg 2020-06-03 部判断经营办逻辑
			 * if(funArchiveSelect.getUserEdition() != 2) { ErpFunDepts byDeptId =
			 * erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId()); if (byDeptId
			 * != null) { String deptName = (byDeptId == null) ? "" :
			 * byDeptId.getDeptCname(); throw new ConfirmException("您已加入" + deptName +
			 * "门店<br/>请先从此门店注销后再进行此操作！"); } else { ErpFunOrganization erpFunOrganization =
			 * erpFunOrganizationMapper.selectOrgByOrgId(cityId, erpFunUsers.getCompId(),
			 * erpFunUsers.getOrganizationId()); String orgName = (erpFunOrganization ==
			 * null) ? "" : erpFunOrganization.getOrganizationName(); throw new
			 * ConfirmException("您已加入"+orgName+"组织<br/>请先从此组织注销后再进行此操作！"); } }
			 */
		}
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		String userPhoto = erpFunUsers.getUserPhoto();
		String userPhotoMin = erpFunUsers.getUserPhotoMin();
		if (StringUtils.isNotBlank(userPhoto)) {
			userPhoto = userPhoto.replaceAll(CommonUtil.getPhotoUrl(userPhoto), "");
			userPhoto = userPhoto.replaceAll(AppConfig.getPicDomainUrl(), "");
			funArchiveInsert.setUserPhoto(userPhoto);
		}
		if (StringUtils.isNotBlank(userPhotoMin)) {
			userPhotoMin = userPhotoMin.replaceAll(CommonUtil.getPhotoUrl(userPhotoMin), "");
			userPhotoMin = userPhotoMin.replaceAll(AppConfig.getPicDomainUrl(), "");
			funArchiveInsert.setUserPhotoMin(userPhotoMin);
		}
		if(StringUtils.isNotBlank(serviceReg)) {
			funArchiveInsert.setServiceReg(" "+serviceReg.trim()+" ");
		}
		if(StringUtils.isNotBlank(serviceZone)) {
			funArchiveInsert.setServiceZone(" "+serviceZone.trim()+" ");
		}
		if(StringUtils.isNotBlank(serviceZoneIds)) {
			funArchiveInsert.setServiceZoneIds(" "+serviceZoneIds.trim()+" ");
		}
		funArchiveInsert.setUserEdition(erpFunUsers.getUserEdition());
		funArchiveInsert.setCityId(erpFunUsers.getCityId());
		funArchiveInsert.setUserName(erpFunUsers.getUserName());
		funArchiveInsert.setUserSex((byte) (erpFunUsers.getUserSex()?1:0));
		funArchiveInsert.setProvinceId(adminFunCity.getProvinceId().intValue());
		funArchiveInsert.setIsRegist((byte)1);// 是否已经完善资料 0=尚未完善，登录时需要完善 1=已经完善
		funArchiveInsert.setUserIccode(erpFunUsers.getUserIccode());

		// 判断定制
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, erpFunUsers.getCompId());
		if(null != erpFunComp) {
			AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
			// 开启定制的公司，不用弹协议窗
			if(null != adminFunComp && null != adminFunComp.getSpecialCustomized() && 1== adminFunComp.getSpecialCustomized().intValue()) {
				funArchiveInsert.setAgreeTruehouseRule((byte) 1);
			}
		}

		// 以前没有时插入
		if(funArchiveSelect == null) {
			AdminFunCity adminFunCityPO = adminFunCityMapper.selectByPrimaryKey(erpFunUsers.getCityId());
			Boolean superUser = adminFunCityPO.getSuperUser();
			Date superTime = adminFunCityPO.getSuperTime();
			Short superDay = adminFunCityPO.getPersonalSuper();
			Integer preSuperDays = 0; // 档案表中的SUPER_DAYS
			if (DateTimeHelper.getDaysOfTwoDate(superTime, new Date()) < 0D) {
				superDay = 0;
			} else {
				if(superDay != null) {
					preSuperDays = superDay.intValue();
				} else {
					superDay = 0;
				}
			}
			Date superStart = new Date();
			Date superEnd = DateTimeHelper.addDays(superStart, superDay);
			if (superUser && superDay > 0) {
				superEnd = superStart;
			}
			funArchiveInsert.setSuperUser(superDay <= 0 ? 0 : 1);
			funArchiveInsert.setSuperStart(superStart);
			funArchiveInsert.setSuperEnd(superEnd);
			funArchiveInsert.setSuperDays(preSuperDays);
			funArchiveInsert.setMobileValided((byte) 1);
			funArchiveInsert.setUserMobile(erpFunUsers.getUserMobile());
			funArchiveInsert.setCreationTime(new Date());
			funArchiveInsert.setRegFrom(type);// 7=邀请注册
			funArchiveInsert.setPlateType((byte) 0);
			funArchiveInsert.setProvinceId(provinceId);
			setSellerInfo(cityId,funArchiveInsert,false,selUid);
			funArchiveInsert = updateSeverIds(funArchiveInsert);
			funArchiveInsert.setArchiveLevel(1);
			adminFunArchiveMapper.insertSelective(funArchiveInsert);

			AdminFunArchiveLevelMarkingDetail levelMarking=new AdminFunArchiveLevelMarkingDetail();
			levelMarking.setCreateTime(new Date());
			levelMarking.setUserId(funArchiveInsert.getSellId());
			levelMarking.setAffiliationSellId(funArchiveInsert.getSellId());
			levelMarking.setArchiveId(funArchiveInsert.getArchiveId());
			levelMarking.setArchiveLevel(1);
			adminFunArchiveLevelMarkingDetailMapper.insertSelective(levelMarking);

			AdminBrokerVisit brokerVisit=new AdminBrokerVisit();
			brokerVisit.setBvPhone(funArchiveInsert.getUserMobile());
			if (adminBrokerVisitMapper.getCountByCondition(brokerVisit)>0){
				AdminBrokerVisit updateModel=new AdminBrokerVisit();
				updateModel.setIsReg((byte)1);
				updateModel.setRegSource((byte)2);
				updateModel.setBvPhone(funArchiveInsert.getUserMobile());
				adminBrokerVisitMapper.updateBrokerVisitByBvPhone(updateModel);
				try {
					adminFunArchiveMapper.moveTrack(funArchiveInsert.getArchiveId(),funArchiveInsert.getUserMobile());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			adminFunErpUserGuideService.insertAllUserGuide(funArchiveInsert.getArchiveId());
		} else {
			if (1 == funArchiveSelect.getUserRight()) {
				funArchiveInsert.setUserName(null);
				funArchiveInsert.setUserSex(null);
				funArchiveInsert.setUserHonest(1);// 用户关联门店时如果已经认证则 直接完成资质认证
				AdminFunUserRqs funUserRqsPO = new AdminFunUserRqs();
				funUserRqsPO.setArchiveId(funArchiveSelect.getArchiveId());
				funUserRqsPO.setRqsAptitudeStatus(1);
				funUserRqsPO.setRqsAptitudeDesc("恭喜！您的资质认证已通过。");
				funUserRqsPO.setRqsAptitudeTime(new Date());
				adminFunUserRqsMapper.updateByPrimaryKeySelective(funUserRqsPO);
			}
			funArchiveInsert.setArchiveId(funArchiveSelect.getArchiveId());
			funArchiveInsert.setMobileValided((byte) 1);
			funArchiveInsert = updateSeverIds(funArchiveInsert);

			// modify lcb 修改于 2020/5/28 电话号码更新逻辑
			funArchiveInsert.setUserMobile(!funArchiveSelect.getUserMobile().equals(erpFunUsers.getUserMobile())? erpFunUsers.getUserMobile() : funArchiveInsert.getUserMobile());
			adminFunArchiveMapper.updateByPrimaryKeySelective(funArchiveInsert);
		}
		// 添加滴滴好房经纪人服务器区域
		this.updateUserService(erpFunUsers.getCityId(), funArchiveInsert.getArchiveId(), funArchiveInsert.getServiceReg(), funArchiveInsert.getServiceZoneIds());
		return funArchiveInsert;
	}

	/**
	 * @tag 服务区域ID增加首尾空格
	 * @author 邓永洪
	 * @since 2018/5/28
	 */
	private AdminFunArchive updateSeverIds(AdminFunArchive funArchiveInsert) {
		if (funArchiveInsert == null)
			return null;
		// 首尾加个空格，滴滴好房查询时优化 --张宏利
		if (StringUtils.isNotBlank(funArchiveInsert.getServiceReg()))
			funArchiveInsert.setServiceReg(" " + funArchiveInsert.getServiceReg().trim() + " ");// .trim()防止存在首尾空格的情况
		if (StringUtils.isNotBlank(funArchiveInsert.getServiceZoneIds()))
			funArchiveInsert.setServiceZoneIds(" " + funArchiveInsert.getServiceZoneIds().trim() + " ");
		return funArchiveInsert;
	}

	/**
	 * @tag 根据销售政策获取所属销售信息
	 * @author 邓永洪
	 * @since 2018/5/28
	 */
	private void setSellerInfo(Integer cityId, AdminFunArchive funArchive, boolean isPersonalVersion, Integer sellId) {
		AdminCrmUser crmUser=new AdminCrmUser();
		if (sellId != null && 0 != sellId) {
			crmUser = adminCrmUserMapper.selectByPrimaryKey(sellId);
		}
		Integer sellIdLast = null;
		Integer sellCompIdLast = null;
		Integer sellPlateTypeLast = null;
		if(!isPersonalVersion) {
			// 门店版归属门店所属公司
			sellIdLast = sellId;
			sellPlateTypeLast = 0;
			sellCompIdLast = crmUser == null ? null :crmUser.getCompId();
		} else {
			 AdminCrmCompRange crmCompRange = adminCrmCompRangeMapper.getAdminCrmCompRange(cityId,1,1);
			if (crmCompRange!=null){
				// 独家代理的归独家代理公司
				sellPlateTypeLast = 0;
				sellCompIdLast = crmCompRange.getCompId();
			}else if(crmCompRange==null){
				// 没有销售，改为抢盘
				sellPlateTypeLast = 3;
			}else if(crmCompRange.getCompId()==1){
				// 总部所属销售
				sellIdLast = sellId;
				sellPlateTypeLast = 0;
				sellCompIdLast = crmCompRange.getCompId();
			}else {
				crmCompRange = adminCrmCompRangeMapper.getAdminCrmCompRange(cityId,1,0);
				if(crmCompRange != null) {
					// 代理商城市，归属代理商
					sellIdLast = sellId;
					sellPlateTypeLast = 0;
					sellCompIdLast = crmCompRange.getCompId();
				} else {
					// 大抢盘
					sellPlateTypeLast = 3;
				}
			}

		}
		funArchive.setSellId(sellIdLast);
		funArchive.setSellComp(sellCompIdLast);
		funArchive.setPlateType(sellPlateTypeLast.byteValue());
	}

	/**
	 * 更新用户的服务区域和商圈信息，目前主要用于滴滴好房项目
	 * @author 陈文超
	 * @throws Exception
	 * @date Dec 7, 2015 5:27:22 PM
	 */
	public void updateUserService(Short cityId, Integer archiveId, String serviceReg, String serviceZoneIds){
		if(StringUtils.isBlank(serviceReg) || StringUtils.isBlank(serviceZoneIds)) {
			return;
		}
		List<Integer> serviceRegIntList = StringUtil.toIntList(serviceReg, " ");
		ErpFunSectionExample sectionExample = new ErpFunSectionExample();
		sectionExample.createCriteria().andVertifyFlagEqualTo((byte) 1)
			.andRegIdIn(serviceRegIntList).andCityIdEqualTo(cityId);
		sectionExample.setShardCityId(cityId.intValue());
		List<ErpFunSection> sectionList = erpFunSectionMapper.selectByExample(sectionExample);
		Map<Integer, Map<Integer, ErpFunSection>> regMap = new HashMap<>();
		for (ErpFunSection erpFunSection : sectionList) {
			Map<Integer, ErpFunSection> tempMap = regMap.get(erpFunSection.getRegId());
			if (tempMap == null) {
				tempMap = new HashMap<>();
				tempMap.put(erpFunSection.getSectionId(), erpFunSection);
				regMap.put(erpFunSection.getRegId(), tempMap);
			} else {
				tempMap.put(erpFunSection.getSectionId(), erpFunSection);
			}
		}
		List<Integer> serviceZoneListIntList = StringUtil.toIntList(serviceZoneIds, " ");
		List<AdminFunArchiveServicezone> servicezoneList = new LinkedList<>();
		for (Integer regId : serviceRegIntList) {
			boolean haveServicezone = false;
			Map<Integer, ErpFunSection> sectionPo = regMap.get(regId);
			if (sectionPo != null) {
				for (Integer sectionId : serviceZoneListIntList) {
					if (sectionPo.containsKey(sectionId)) {
						AdminFunArchiveServicezone tmpPo = new AdminFunArchiveServicezone();
						tmpPo.setArchiveId(archiveId);
						tmpPo.setRegionId(regId);
						tmpPo.setSectionId(sectionId);
						servicezoneList.add(tmpPo);
						haveServicezone = true;
					}
				}
			}
			// 没有的时候不设置sectionId
			if(!haveServicezone) {
				AdminFunArchiveServicezone tmpPo = new AdminFunArchiveServicezone();
				tmpPo.setArchiveId(archiveId);
				tmpPo.setRegionId(regId);
				servicezoneList.add(tmpPo);
			}
		}
		// 有的时候删除再创建
		if(!servicezoneList.isEmpty()) {
			AdminFunArchiveServicezoneExample deleteExample = new AdminFunArchiveServicezoneExample();
			deleteExample.createCriteria().andArchiveIdEqualTo(archiveId);
			adminFunArchiveServicezoneMapper.deleteByExample(deleteExample);
			for (AdminFunArchiveServicezone adminFunArchiveServicezone : servicezoneList) {
				adminFunArchiveServicezoneMapper.insertSelective(adminFunArchiveServicezone);
			}
		}
	}

	@Transactional
	@Override
	public void updateUaIdBycreateUser(Integer uaId, Integer archiveId, String userMobile, String userName) {
		AdminFunArchive record = new AdminFunArchive();
		record.setUaId(uaId);
		record.setArchiveId(archiveId);
		adminFunArchiveMapper.updateByPrimaryKeySelective(record);
		adminCrmBrokerTrackService.createRegisterTrack(archiveId, "'" + userName+"'绑定资金账户'"+userMobile+"'", "[资金账户变更]");
	}
	
	
	@Override
	public String getUserPhotoUrl(AdminFunArchive adminFunArchive) {
		String userPhoto = null;
		if (!StringUtil.isEmpty(adminFunArchive.getUserPhoto())) {
			userPhoto = CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto());
		} else {
			if (!AppConfig.isOnline()) {
				userPhoto = "http://pic.myfun7.com/pic/FACE/1_1/160_160/CD0000349_615955974828446595.jpg";
			}
		}
		return userPhoto;
	}

	@Override
	public boolean isUserRight(Integer archiveId) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		if(adminFunArchive == null || adminFunArchive.getUserRight() == null) {
			return false;
		}
		return (adminFunArchive.getUserRight() == 1);
	}


	/**
	 * @author 邓永洪
	 * @since 2018/4/12
	 * @tag 个人中心更新档案信息
	 */
	@Transactional
	@Override
	public void updatePersonalInfoByUcenter(Integer cityId, AdminFunArchive adminFunArchive) {
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		adminFunBuildAttentionMapper.deleteAutoAttention(adminFunArchive.getArchiveId());
		this.updateUserService(cityId.shortValue(), adminFunArchive.getArchiveId(), adminFunArchive.getServiceReg(),
				adminFunArchive.getServiceZoneIds());
	}
	
	/**
	 * 更新最后登录时间
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	@Override
	public void updateUserLastLoginTime(Integer archiveId, Date date) {
		adminFunArchiveMapper.updateUserLastLoginTime(archiveId,date);
	}

	private Map<String, Map<String, Map<String, Object>>> listMapToMapPack(List<Map<String, Object>> list, String fieldName, String packFieldName) {
		Map<String, Map<String, Map<String, Object>>> map = new HashMap();
		Map<String, Map<String, Object>> pack = null;
		if (list.size() > 0) {
			for (Map<String, Object> tmpMap : list) {
				Object obj = tmpMap.get(fieldName);
				String fieldValue = null;
				if (null != obj) {
					fieldValue = obj.toString();
				}
				Object obj2 = tmpMap.get(packFieldName);
				String packfieldValue = null;
				if (null != obj2) {
					packfieldValue = obj2.toString();
				}
				if (map.get(fieldValue) == null) {
					pack = new HashMap();
					map.put(fieldValue, pack);
				} else {
					pack = map.get(fieldValue);
				}
				pack.put(packfieldValue, tmpMap);
			}
		}
		return map;
	}

	/**
	 * @tag 个人中心-变更电话号码
	 * @author 邓永洪
	 * @since 2018/6/8
	 */
	@Transactional
	@Override
	public void updateUserMobile(GeneralParam generalParam, String mobile) {
		AdminFunArchive funArchive=new AdminFunArchive();
		funArchive.setArchiveId(generalParam.getArchiveId());
		funArchive.setUserMobile(mobile);
		adminFunArchiveMapper.updateByPrimaryKeySelective(funArchive);
		erpFunUsersService.updateForMobile(generalParam, mobile);

		AdminCrmBrokerTrack crmBrokerTrack=new AdminCrmBrokerTrack();
		crmBrokerTrack.setTrackTime(new Date());
		crmBrokerTrack.setArchiveId(generalParam.getArchiveId());
		crmBrokerTrack.setTrackDesc("[手机变更]");
		crmBrokerTrack.setTrackUser(Const.DIC_SYSTEM_USERID_999);
		crmBrokerTrack.setTrackContent("'" + generalParam.getUserName() +
						"'变更了联系方式'" + generalParam.getUserMobile() + "'>>'" + mobile + "'");
		crmBrokerTrackMapper.insertSelective(crmBrokerTrack);
	}

	/**
	 * 修改个人中心头像
	 * @author 朱科
	 * @since 2018/6/19
	 */
	@Override
	public void updateUserPhoto(Integer archiveId, String photoPath) {
		adminFunArchiveMapper.updateUserPhoto(archiveId, photoPath);
	}

	@Transactional
	@Override
	public String addTreasureCoin(Integer archiveId, String coinSource, Integer sourceId, Integer sourceType,String addFrom,Integer userId, String otoFlag,String deptFlag,Integer cityId,String superUser,String userRight,Boolean personalVersion) throws Exception {
		// 增加夺宝币
		if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_2.equals(coinSource)) {
			adminJmsMessageService.addWorkCount(StatisticDetailType.FYTG_COUNT, new Date(), userId, sourceType, sourceId, null, 1,cityId);
		} else if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_3.equals(coinSource)) {
			adminJmsMessageService.addWorkCount(StatisticDetailType.XQZJ_COUNT, new Date(), userId, 0, sourceId, null, 1,cityId);
		}
		// 不是VIP
		if(!"1".equals(superUser)) {
			return null;
		}
		// 未实名认证
		if(!"1".equals(userRight)) {
			return null;
		}
		// 非纯精英版
		if(!personalVersion) {
			// o2o到期
			if(!"1".equals(otoFlag)) {
				return null;
			}
			// 非正式门店
			if(!Constants_DIC.DIC_DEPT_FLAG_2.equals(deptFlag)) {
				return null;
			}
		}
		AdminFunTreasureCoin coinGetCount = null;
		
		if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_1.equals(coinSource)
				|| Constants_DIC.DIC_TREASURE_COIN_SOURCE_3.equals(coinSource)) {
			AdminFunTreasureCoinExample adminFunTreasureCoinExample = new AdminFunTreasureCoinExample();
			Criteria criteria = adminFunTreasureCoinExample.createCriteria();
			if(sourceId!=null) {
				criteria.andSourceIdEqualTo(sourceId);
			}
			if(sourceType!=null) {
				criteria.andSourceTypeEqualTo(sourceType);
			}
			criteria.andArchiveIdEqualTo(archiveId);
			// 点亮真房源
			if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_1.equals(coinSource)) {
				// 时间限制，出售6个月，出租3个月
				Calendar calendar = Calendar.getInstance();
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(sourceType)) {
					calendar.add(Calendar.MONTH, -6);
				} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(sourceType)) {
					calendar.add(Calendar.MONTH, -3);
				}
				criteria.andCreationTimeGreaterThan(calendar.getTime());
				// 小区竞价
			} else if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_3.equals(coinSource)) {
				criteria.andCreationTimeGreaterThanOrEqualTo(new Date());
			}
			List<AdminFunTreasureCoin> selectByExample = adminFunTreasureCoinMapper.selectByExample(adminFunTreasureCoinExample);
			if (selectByExample.size()>0) {
				coinGetCount = selectByExample.get(0);
			}
		}
		// 增加夺宝币
		String coin = null;
		String coinDesc = null;
		if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_1.equals(coinSource)) {
			// 真房源需要判断房源，一条房源一个人一个时间段内只获得一次夺宝币
			if(coinGetCount != null) {
				return null;
			}
			coin = "1";
			coinDesc = "点亮真房源获取夺宝币";
		} else if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_2.equals(coinSource)) {
			coin = "2";
			coinDesc = "房源推广获取夺宝币";
		} else if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_3.equals(coinSource)) {
			if(coinGetCount != null) {
				return null;// 一天内有多次小区竞价则返回，肯定只会有一次，多了就是错的
			}
			coin = "3";
			coinDesc = "小区竞价获取夺宝币";
		} else if(Constants_DIC.DIC_TREASURE_COIN_SOURCE_4.equals(coinSource)) {
			coin = "3";
			coinDesc = "新盘竞价获取夺宝币";
		} else {
			return null;
		}
		// 夺宝币是否增加，1=增加
		String treasureCoinIsOpen = adminSysParaMapper.selectParamVlue("TREASURE_COIN_IS_OPEN");
		if (StringUtil.isEmpty(treasureCoinIsOpen)) {
			throw new Exception("系统参数TREASURE_COIN_IS_OPEN值为空");
		}
		if(!"1".equals(treasureCoinIsOpen)) {
			return null;
		}
		AdminFunArchive funArchivePO = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
		int coinAfter = funArchivePO.getTreasureCoin()==null?0:funArchivePO.getTreasureCoin() + StringUtil.paseInteger(coin, 0);
		
		// 写记录
		AdminFunTreasureCoin adminFunTreasureCoin = new AdminFunTreasureCoin();
		adminFunTreasureCoin.setSourceId(sourceId);
		adminFunTreasureCoin.setSourceType(sourceType);
		adminFunTreasureCoin.setArchiveId(archiveId);
		adminFunTreasureCoin.setCityId(cityId);
		adminFunTreasureCoin.setCoin(Integer.valueOf(coin));
		adminFunTreasureCoin.setCoinAfter(coinAfter);
		adminFunTreasureCoin.setCoinBefore(funArchivePO.getTreasureCoin());
		adminFunTreasureCoin.setCoinDesc(coinDesc);
		adminFunTreasureCoin.setCoinSource(Integer.valueOf(coinSource));
		adminFunTreasureCoin.setCoinType(Integer.valueOf(Constants_DIC.DIC_TREASURE_COIN_TYPE_1));
		adminFunTreasureCoin.setCreationTime(new Date());
		adminFunTreasureCoinMapper.insertSelective(adminFunTreasureCoin);
		
		funArchivePO.setTreasureCoin(Integer.valueOf(coin));
		adminFunArchiveMapper.updateByPrimaryKeySelective(funArchivePO);
		
		if(!"1".equals(AppConfig.treasureCoinIsOpen())) {
			return null;
		}
		// 移动端来的小区竞价写小秘书
		if("2".equals(addFrom) && Constants_DIC.DIC_TREASURE_COIN_SOURCE_3.equals(coinSource)) {
			ErpFunUsers funUsersDto = erpFunUsersMapper.selectByArchiveId(archiveId);
			Date date=new Date();
			ErpFunMsg funMsg = new ErpFunMsg();
			funMsg.setShardCityId(cityId);
			funMsg.setReadFlag(false);
			funMsg.setCompId(funUsersDto.getCompId());
			funMsg.setReceiveDept(funUsersDto.getDeptId());
			funMsg.setMsgContent("恭喜您获得"+coin+"个夺宝币，赶快去参加百万豪礼");
			funMsg.setSendUser(999);
			funMsg.setReceiveUser(funUsersDto.getUserId());
			funMsg.setReceiveDel(false);
			funMsg.setSendTime(date);
			funMsg.setSendDel(false);
			erpFunMsgMapper.insertSelective(funMsg);
		}
		return coin;
	}

	/**
	 * 是否是PLUS会员
	 * @param archiveId 经纪人档案id
	 * @param fromSoso 是否来自搜搜的验证 是就传true，否则全传false
	 * @since 2019/2/23
	 */
	@Override
	public boolean judgeIsSupUser(Integer archiveId, boolean fromSoso) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		if (!fromSoso) {
			if(Byte.valueOf("1").equals(adminFunArchive.getIsFreeUser())) {
				return true;
			}
		}
		if (Integer.valueOf(1).equals(adminFunArchive.getSuperUser()) 
				&& adminFunArchive.getSuperEnd().getTime() > System.currentTimeMillis()) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public void updateMyBaseInfo(MyBaisInfoParam param) {
		Integer archiveId = param.getArchiveId();
		Integer cityId = param.getCityId();
		String nickName = param.getNickName();
		String professionSub = param.getProfessionSub();
		String bbsPhoto = param.getBbsPhoto();
		String userPhoto = param.getUserPhoto();
		String serviceRegIds = param.getServiceRegIds();
		String serviceZoneIds = param.getServiceZoneids();
		String compName = param.getCompName();
		String serviceZones = param.getServiceZones();
		String regAndSecJson = param.getRegAndSecJson();
		Byte userSex = param.getUserSex();
		String userName = param.getUserName();

		List<String> serviceRegIdsList = null;
		List<String> serviceZoneidsList = null;
		List<String> serviceZonesList = null;
		String serviceRegIdsStr = null;
		String serviceZoneidsStr = null;
		String serviceZonesStr = null;
		if (org.apache.commons.lang3.StringUtils.isNotBlank(serviceRegIds)) {
			// 转换成list
			serviceRegIdsList = Arrays.asList(serviceRegIds.split(","));
			// 转换成空格分割的字符串
			serviceRegIdsStr = " " + String.join(" ", serviceRegIdsList).trim() + " ";
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(serviceZoneIds)) {
			serviceZoneidsList = Arrays.asList(serviceZoneIds.split(","));
			serviceZoneidsStr = " " + String.join(" ", serviceZoneidsList).trim() + " ";
		}
		if (org.apache.commons.lang3.StringUtils.isNotBlank(serviceZones)) {
			serviceZonesList = Arrays.asList(serviceZones.split(","));
			serviceZonesStr = " " + String.join(" ", serviceZonesList).trim() + " ";
		}

		AdminFunArchive adminFunArchive = new AdminFunArchive();
		adminFunArchive.setArchiveId(archiveId);
		adminFunArchive.setBbsPhoto(bbsPhoto);
		adminFunArchive.setUserPhoto(userPhoto);
		adminFunArchive.setNickName(nickName);
		adminFunArchive.setProfessionSub(professionSub);
		adminFunArchive.setServiceReg(serviceRegIdsStr);
		adminFunArchive.setServiceZone(serviceZonesStr);
		adminFunArchive.setServiceZoneIds(serviceZoneidsStr);
		adminFunArchive.setIsRegist((byte) 1);
		adminFunArchive.setCompName(compName);
		if (userSex != null || userName != null) {
			adminFunArchive.setUserSex(userSex);
			adminFunArchive.setUserName(userName);
			adminFunArchive.setArchiveId(archiveId);
			ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setShardCityId(cityId);
			erpFunUsers.setArchiveId(archiveId);
			if (userSex != null) {
				erpFunUsers.setUserSex(userSex == 1 ? true : false);
			}
			erpFunUsers.setUserName(userName);
			erpFunUsersMapper.updateByArchiveIdSelective(erpFunUsers);
		}
		adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
		if (serviceRegIdsList != null && !serviceRegIdsList.isEmpty()
				|| (serviceZoneidsList != null && !serviceZoneidsList.isEmpty())) {// 判断是否修改服务区
			List<AdminFunArchiveServicezone> regAndZoneList = JSON.parseArray(regAndSecJson,
					AdminFunArchiveServicezone.class);
			adminFunBuildAttentionMapper.deleteAutoAttention(archiveId);
			adminFunArchiveServicezoneMapper.deleteByRecordArchiveId(archiveId);
			if (regAndZoneList != null && !regAndZoneList.isEmpty()) {
				adminFunArchiveServicezoneMapper.batchAddRecordList(archiveId, regAndZoneList);
			}
		}
	}

	@Transactional
	@Override
	public void updateFaceFlag(Integer cityId, Integer archiveId, Integer compId, Integer selfDeptId, Integer selfUserId, Byte faceFlag, String selfUserName) {
		AdminFunArchive updateModel = new AdminFunArchive();
		updateModel.setArchiveId(archiveId);
		updateModel.setFaceRecognitionFlag(faceFlag);
		adminFunArchiveMapper.updateByPrimaryKeySelective(updateModel);
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByArchiveId(updateModel.getArchiveId());
		// 开关刷脸认证写日志
		// 某人于某个时间关闭/开启了某人的更换手机设备需刷脸认证的开关。 
		SSL_TYPE openFaceRecognitionFlag = SystemOperateUtil.SSL_TYPE.OPEN_FACE_RECOGNITION_FLAG;
		String openFlag = "开启";
		if(0 == faceFlag){
			openFaceRecognitionFlag = SystemOperateUtil.SSL_TYPE.CLOSE_FACE_RECOGNITION_FLAG;
			openFlag = "关闭";
		}
		String content = openFlag + "了刷脸认证";
		Map<String, Object> beforeMap = new HashMap<>();
		Byte beforeFlag = 0;
		if(faceFlag == 0){
			beforeFlag = 1;
		}
		beforeMap.put("FACE_RECOGNITION_FLAG", beforeFlag);
		Map<String, Object> afterMap = new HashMap<>();
		afterMap.put("FACE_RECOGNITION_FLAG", faceFlag);
		erpSystemSettingLogsService.insertSysLog(openFaceRecognitionFlag, erpFunUsers.getUserId(), erpFunUsers.getDeptId(), content, 
				beforeMap, afterMap, cityId, compId, selfDeptId, selfUserId);
	}
	
	@Override
	public String getHfdAliasInPushMessage(Integer archiveId) {
		if (null != archiveId) {
			AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
			if (null != adminFunArchive) {
				ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByArchiveId(adminFunArchive.getCityId().intValue(), adminFunArchive.getArchiveId());
				if (null != erpFunUsers && !Integer.valueOf("2").equals(erpFunUsers.getUserEdition())) {
					ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(erpFunUsers.getCityId().intValue(), erpFunUsers.getCompId());
					if (null != erpFunComp) {
						AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
						if (null != adminFunComp && Byte.valueOf("1").equals(adminFunComp.getSpecialCustomized())) {
							Integer leaguesType = adminCustomLeaguesMapper.selectLeaguesTypeByCompNo(adminFunComp.getCompNo());
							if (null != leaguesType) {
								String hfdAlias = adminCustomLeaguesSkinModelMapper.selectSkinPicUrlByLeaguesTypeAndSkinType(leaguesType, "HFD_ALIAS");
								return StringUtil.isNotBlank(hfdAlias) ? hfdAlias : "好房豆";
							}
						}
					}
				}
			}
		}
		return "好房豆";
	}

}


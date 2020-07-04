package com.myfun.service.business.erpdb.impl;

import static com.myfun.framework.session.ThreadLocalHelper.getOperator;
import static com.myfun.utils.DateTimeHelper.getTimeNow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.extension.framework.mq.context.MqUtil;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminCrmCompMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunUserMessageMapper;
import com.myfun.repository.admindb.dao.AdminWMicroshopMemberMapper;
import com.myfun.repository.admindb.dao.AdminYoujiaReserveHouseEvaMapper;
import com.myfun.repository.admindb.dao.AdminYoujiaReserveMapper;
import com.myfun.repository.admindb.po.AdminCrmComp;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.admindb.po.AdminJmsMessage;
import com.myfun.repository.admindb.po.AdminWMicroshopMember;
import com.myfun.repository.admindb.po.AdminWMicroshopMemberExample;
import com.myfun.repository.admindb.po.AdminYoujiaReserve;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEva;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEvaExample;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.repository.erpdb.po.ErpFunViewLogExample.Criteria;
import com.myfun.repository.jms.JmsMsgAction;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.MsgModule;
import com.myfun.repository.support.constant.Const.MsgModuleType;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunUserMessageService;
import com.myfun.service.business.agencydb.AgencyVipErpRelationService;
import com.myfun.service.business.erpdb.bean.param.BorrowOrReturnKeyParam;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.bean.AsycPushMessage;
import com.myfun.utils.Assert;
import com.myfun.utils.BaseUtil;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.PhoneUtil;
import com.myfun.utils.StringHelper;
import com.myfun.utils.StringUtil;

/**
 * 跟进相关操作
 * @author 张宏利
 * @since 2017年06月2日
 */
@Service
public class ErpFunTrackServiceImpl extends AbstractService<ErpFunTrack, ErpFunTrack> implements ErpFunTrackService {
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private ErpFunTrackService erpFunTrackService;
	@Autowired private ErpTrackUsersService erpTrackUsersService;
	@Autowired private ErpTrackUsersMapper erpTrackUsersMapper;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunTrackExtendMapper erpFunTrackExtendMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunBuyCustomerService erpFunBuyCustomerService;
	@Autowired private ErpFunRentCustomerService erpFunRentCustomerService;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper ;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper ;
	@Autowired private AdminFunCompMapper adminFunCompMapper ;
	@Autowired private ErpFunTaskService erpFunTaskService ;
	@Autowired private ErpFunTaskMapper erpFunTaskMapper ;
	@Autowired private ErpSysParaService erpSysParaService ;
	@Autowired private ErpSysParaMapper erpSysParaMapper ;
	@Autowired private ErpFunLeaseService erpFunLeaseService ;
	@Autowired private ErpFunSaleService erpFunSaleService ;
	@Autowired private ErpBuildingSetRoomService erpBuildingSetRoomService ;
	@Autowired private ErpFunEntrustmentPhotoService erpFunEntrustmentPhotoService ;
	@Autowired private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired private ErpUserOpersService erpUserOpersService ;
	@Autowired private ErpFunViewLogService erpFunViewLogService ;
	@Autowired private ErpAuditRuntimeMapper erpAuditRuntimeMapper ;
	@Autowired private ErpAuditRuntimeService erpAuditRuntimeService ;
	@Autowired private ErpFunKeyMapper erpFunKeyMapper ;
	@Autowired private ErpBuildingInfoMapper erpBuildingInfoMapper ;
	@Autowired private ErpFunPhoneMapper erpFunPhoneMapper ;
	@Autowired private ErpFunPolicyControlService erpFunPolicyControlService ;
	@Autowired private AgencyVipErpRelationService agencyVipErpRelationService;
	@Autowired private ErpFunOutdealService erpFunOutdealService;
	@Autowired private AdminFunUserMessageMapper adminFunUserMessageMapper;
	@Autowired private ErpFunAdAuditMapper erpAdAuditMapper;
	@Autowired private ErpYouBorkerPurchaseService erpYouBorkerPurchaseService;
	@Autowired private ErpFunViewLogMapper erpFunViewLogMapper;
	@Autowired private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired private ErpFunVideoMapper erpFunVideoMapper;
	@Autowired private ErpFunPanoramaPhotoMapper erpFunPanoramaPhotoMapper;
	@Autowired private AdminFunUserMessageService adminFunUserMessageService;
	@Autowired private ErpFunCaseFavoriteService erpFunCaseFavoriteService;
	@Autowired private AdminFunCityMapper adminFunCityMapper;
	@Autowired private ErpTrackVideoService erpTrackVideoService;
	@Autowired private ErpFunCoreInfoService erpFunCoreInfoService;
	@Autowired private AdminYoujiaReserveHouseEvaMapper adminYoujiaReserveHouseEvaMapper;
	@Autowired private AdminYoujiaReserveMapper adminYoujiaReserveMapper;
	@Autowired private ErpFunCompMapper erpFunCompMapper;
	@Autowired private AdminCrmCompMapper adminCrmCompMapper;
	@Autowired private AdminWMicroshopMemberMapper adminWMicroshopMemberMapper;
	@Autowired private ErpSalePeopleRelativeService erpSalePeopleRelativeService;
	@Autowired private ErpLeasePeopleRelativeService erpLeasePeopleRelativeService;
	@Autowired private ErpFunKeyRemarkMapper erpFunKeyRemarkMapper;
	@Autowired private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Resource
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Resource
	private ErpFunPartnerMapper erpFunPartnerMapper;
	@Autowired private MqUtil mqUtil;

	private final static Map<Integer, String> caseTypeChineseMap = new HashMap<>();
	private final static Map<Byte, String> caseStatusChineseMap = new HashMap<>();
	static {
		// 房客源类型字典
		caseTypeChineseMap.put(Const.DIC_CASE_TYPE_SALE_FUN, "出售房源");
		caseTypeChineseMap.put(Const.DIC_CASE_TYPE_LEASE_FUN, "出租房源");
		caseTypeChineseMap.put(Const.DIC_CASE_TYPE_BUY_CUST, "求购客户");
		caseTypeChineseMap.put(Const.DIC_CASE_TYPE_RENT_CUST, "求租客户");
		// 房客源状态字典
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_AVAILABLE, "有效");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_DEAL, "外成交");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_INNERDEAL, "内成交");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_RESPITE, "暂缓");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_SCHEDULE, "预定");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_SPECIAL, "封盘");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_TRANSAVAILABLE, "转有效");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_TRANSLEASE, "转租");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_TRANSPRIVATE, "转私盘");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_TRANSSALE, "转售");
		caseStatusChineseMap.put(Const.DIC_HOUSE_STATUS_WRITEOFF, "注销");
	}

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunTrackMapper;
	}

	/**
	 * @Title: insertBatch
	 * @Description: 批量
	 * @author lcb
	 * @Time 2016-6-21 下午2:24:00
	 * @throws
	 */
	@Transactional
	@Override
	public void insertBatch(Integer cityId, List<Map<String, Object>> resList) {
		if (null != resList && resList.size() > 0) {
			for (Map<String, Object> map : resList) {
				ErpFunTrack erpFunTrack = new ErpFunTrack();
				erpFunTrack.setShardCityId(cityId);
				erpFunTrack.setCaseId(Integer.parseInt(map.get("caseId") + ""));
				erpFunTrack.setCaseNo(map.get("caseNo") + "");
				erpFunTrack.setCompId(Integer.parseInt(map.get("compId") + ""));
				erpFunTrack.setDeptId(Integer.parseInt(map.get("deptId") + ""));
				erpFunTrack.setCaseType(new Byte(map.get("caseType") + ""));
				erpFunTrack.setTrackType(new Byte("13"));
				erpFunTrack.setTrackClassic("[ 业务跟进 ]");
				erpFunTrack.setTrackContent("房源" + map.get("caseNo") + " 投诉下架");
				erpFunTrack.setTrackWarm(false);
				erpFunTrack.setCreatorUid(999);
				erpFunTrack.setCreationTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
				erpFunTrackMapper.insertFunTrack(erpFunTrack);
			}
		}
//		funTrackMapper.insertBatch(cityId, resList);
	}

	@Override
	public void insertFunTrack(ErpFunTrack erpFunTrack) {
		erpFunTrackMapper.insertFunTrack(erpFunTrack);

	}

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @return
	 */
	@Override
	public ErpFunTrack writeTrackByHouseKeyTrack(Integer cityId, Integer compId, BorrowOrReturnKeyParam param, String trackKey) {
		Byte trackType = Const.DIC_TRACK_TYPE_KEY;
		String trackContent=null;
		String keyNote = param.getKeyNote();
		boolean trackFlag = false;
		if("0".equals(trackKey)){
			trackContent = param.getCurrentUserName() + "退还该房源钥匙，申请审核";
		}else if("1".equals(trackKey)){
			trackFlag = true;
			trackContent = param.getCurrentUserName() + "提交该房源钥匙，申请审核\n";
			if(!StringUtil.isBlank(keyNote)){
				trackContent = trackContent+"钥匙说明："+keyNote;
			}
		}
		ErpFunTrack insertModel = new ErpFunTrack();
		insertModel.setCompId(compId);
		insertModel.setDeptId(param.getCurrentDeptId());
		insertModel.setCaseId(param.getCaseId());
		insertModel.setCaseType(param.getCaseType());
		insertModel.setCaseNo(param.getCaseNo());
		insertModel.setTrackType(trackType);
		insertModel.setTrackClassic(Const.DIC_TRACKCLASSIC_4);
		insertModel.setTrackContent(trackContent);
		insertModel.setTrackKey(trackFlag);
		insertModel.setTrackWarm(false);
		insertModel.setTargetDept(param.getKeyDeptId());
		insertModel.setKeyNum(param.getKeyNum());
		insertModel.setCreatorUid(param.getCurrentUserId());
		insertModel.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		insertModel.setShardCityId(cityId);
		erpFunTrackMapper.insertFunTrack(insertModel);
		return insertModel;
	}

	@Override
	public Map<String, Object> selectMgrTrackList(BaseMapParam param) throws Exception {
		Map<String,Object> resultMap = new HashMap<>(10);
		Map<String,Object> map = param.getMap();
		map.put("compId",param.getInteger("compId"));
		if(map.get("date2")!=null&&org.apache.commons.lang.StringUtils.isNotBlank(String.valueOf(map.get("date2")))){
			map.put("date2", map.get("date2")+" 23:59:59");
		}
		Integer count = erpFunTrackMapper.countMgrTrackList(map,param.getInteger("cityId"));
		resultMap.put("total",count);
		if(count>0){
			List<ErpFunTrackDto> list = erpFunTrackMapper.selectMgrTrackList(map,param.getInteger("cityId"));
			resultMap.put("trackList",list);
			Set<Integer> queryKeyList = new HashSet<Integer>();
			if("BY_USER".equals(String.valueOf(param.getString("operType")))){
				if(!BaseUtil.isEmpty(list)){
					for(ErpFunTrackDto vo : list){
						queryKeyList.add(vo.getCaseId());
					}
				}
			}
			Map<String,Object> ownerUserMap = null;
			String delContent ="该房源跟进已被管理员删除";
			String caseType = param.getString("caseType");
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
				delContent ="该房源跟进已被管理员删除";
			}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
				delContent ="该房源跟进已被管理员删除";
			}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
				delContent ="该客源跟进已被管理员删除";
			}else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
				delContent ="该客源跟进已被管理员删除";
			}
			if(!BaseUtil.isEmpty(queryKeyList)){
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
					List<Map<String,Object>> saleList = erpFunSaleMapper.selectFunSaleListByIds(param.getInteger("cityId"),queryKeyList.toArray(new Integer[]{}) , new String[]{"USER_ID","SALE_ID"},param.getInteger("compId"));
					ownerUserMap = BeanUtilsHelper.listMapToMapObject(saleList,"SALE_ID");
				} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
					List<Map<String,Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(param.getInteger("cityId"),queryKeyList.toArray(new Integer[]{}) , new String[]{"USER_ID","LEASE_ID"},param.getInteger("compId"));
					ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList,"LEASE_ID");
				} else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
					List<Map<String,Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(param.getInteger("cityId"),queryKeyList.toArray(new Integer[]{}) , new String[]{"USER_ID","BUY_CUST_ID"},param.getInteger("compId"));
					ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList,"BUY_CUST_ID");
				} else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
					List<Map<String,Object>> leaseList = erpFunLeaseMapper.selectFunLeaseListByIds(param.getInteger("cityId"),queryKeyList.toArray(new Integer[]{}) , new String[]{"USER_ID","RENT_CUST_ID"}, param.getInteger("compId"));
					ownerUserMap = BeanUtilsHelper.listMapToMapObject(leaseList,"RENT_CUST_ID");
				}
			}
			List<ErpFunUsers> userList = erpFunUsersService.getUserListByCompId(param.getInteger("cityId"), param.getInteger("compId"));
			Map<Object,ErpFunUsers> userMap = BeanUtilsHelper.listToMapObjectOffKeyType(userList,"userId");
			for(ErpFunTrackDto dto : list){
				Integer trackUserId = dto.getCreatorUid();
				ErpFunUsers usersPO = userMap.get(trackUserId);
				if(usersPO!=null){
					dto.setViewName(usersPO.getUserName());
				}

				if(!"1".equals(String.valueOf(dto.getIsDel()))){
					continue;
				}
				if(ownerUserMap!=null){
					Integer ownerUserId = null;
					if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
						ErpFunSale funSalePO = (ErpFunSale)ownerUserMap.get(dto.getCaseId());
						if(funSalePO != null) {
							ownerUserId = funSalePO.getUserId();
						}
					} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
						ErpFunLease funLeasePO = (ErpFunLease)ownerUserMap.get(dto.getCaseId());
						if(funLeasePO != null) {
							ownerUserId = funLeasePO.getUserId();
						}
					} else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
						ErpFunBuyCustomer funBuyCustomerPO = (ErpFunBuyCustomer)ownerUserMap.get(dto.getCaseId());
						if(funBuyCustomerPO != null) {
							ownerUserId = funBuyCustomerPO.getUserId();
						}
					} else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
						ErpFunRentCustomer funRentCustomerPO = (ErpFunRentCustomer)ownerUserMap.get(dto.getCaseId());
						if(funRentCustomerPO != null) {
							ownerUserId = funRentCustomerPO.getUserId();
						}
					}

					if(param.getInteger("userId").equals(ownerUserId)||param.getInteger("userId").equals(dto.getCreatorUid())){
						dto.setCanView("1");
					}else{
						String trackConent = dto.getTrackContent();
						trackConent = buildDelTrackContent(trackConent);
						trackConent+= delContent;
						dto.setTrackContent(trackConent);
					}
					dto.setOwnerUserId(ownerUserId);
				}else{
					if(param.getInteger("userId").equals(dto.getOwnerUserId())||param.getInteger("userId").equals(dto.getCreatorUid())){
						dto.setCanView("1");
					}else{
						String trackConent = dto.getTrackContent();
						trackConent = buildDelTrackContent(trackConent);
						trackConent+= delContent;
						dto.setTrackContent(trackConent);
					}
				}
			}
			Set<Integer> trackIds = new HashSet<Integer>(list.size());
			for(ErpFunTrackDto dto:list){
				if (Const.DIC_TRACK_TYPE_DAIKAN.equals(dto.getTrackType())) {
					trackIds.add(dto.getTrackId());
				}
			}
			if(!BaseUtil.isEmpty(trackIds)){
				List<ErpTrackUsersDto> trackUserList = erpTrackUsersMapper.getTrackUsersListByTrackIds(param.getInteger("cityId"), trackIds.toArray(new Integer[]{}),new String[]{"TRACK_ID","USER_NAME"}, param.getInteger("compId"));
				Map<Integer,String> trackUserMap = new HashMap<Integer,String>();
				for(ErpTrackUsersDto trackUserDto:trackUserList){
					Integer trackId = trackUserDto.getTrackId();
					String userName = trackUserMap.get(trackId);
					if(StringUtil.isNotBlank(userName)){
						userName= userName+"," +trackUserDto.getUsername();
					}else{
						trackUserMap.put(trackId,trackUserDto.getUsername());
					}
				}
				resultMap.put("userList", trackUserList);
			}
		}
		return resultMap;
	}

	private String buildDelTrackContent(String trackContent) throws Exception{
		int startIndex = trackContent.lastIndexOf("跟进内容：");
		if(startIndex!=-1){
			trackContent = trackContent.substring(0, startIndex+"跟进内容：".length());
		}else{
			startIndex = trackContent.lastIndexOf("查看原因：");
			if(startIndex!=-1){
				trackContent = trackContent.substring(0, startIndex+"查看原因：".length());
			}
		}
		return trackContent;
	}

	/**
	 * 根据caseId和caseType查询房客源所属人
	 */
	@Override
	public Map<String, Integer> getCaseInfo(Integer cityId, Integer caseId, Integer caseType) {
		Map<String, Integer> returnMap = new HashMap<String, Integer>();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale key = new ErpFunSale();
			key.setShardCityId(cityId);
			key.setSaleId(caseId);
			ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(key);
			if (erpFunSale != null) {
				returnMap.put("compId", erpFunSale.getCompId());
				returnMap.put("areaId", erpFunSale.getAreaId());
				returnMap.put("regId", erpFunSale.getRegId());
				returnMap.put("deptId", erpFunSale.getDeptId());
				returnMap.put("grId", erpFunSale.getGrId());
				returnMap.put("userId", erpFunSale.getUserId());
				returnMap.put("plateType", Integer.valueOf(erpFunSale.getPlateType()));
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease key = new ErpFunLease();
			key.setShardCityId(cityId);
			key.setLeaseId(caseId);
			ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(key);
			if (erpFunLease != null) {
				returnMap.put("compId", erpFunLease.getCompId());
				returnMap.put("areaId", erpFunLease.getAreaId());
				returnMap.put("regId", erpFunLease.getRegId());
				returnMap.put("deptId", erpFunLease.getDeptId());
				returnMap.put("grId", erpFunLease.getGrId());
				returnMap.put("userId", erpFunLease.getUserId());
				returnMap.put("plateType", Integer.valueOf(erpFunLease.getPlateType()));
			}
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer key = new ErpFunBuyCustomer();
			key.setShardCityId(cityId);
			key.setBuyCustId(caseId);
			ErpFunBuyCustomer erpBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(key);
			if (erpBuyCustomer != null) {
				returnMap.put("compId", erpBuyCustomer.getCompId());
				returnMap.put("areaId", erpBuyCustomer.getAreaId());
				returnMap.put("regId", erpBuyCustomer.getRegId());
				returnMap.put("deptId", erpBuyCustomer.getDeptId());
				returnMap.put("grId", erpBuyCustomer.getGrId());
				returnMap.put("userId", erpBuyCustomer.getUserId());
				returnMap.put("plateType", Integer.valueOf(erpBuyCustomer.getPlateType()));
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomerKey key = new ErpFunRentCustomerKey();
			key.setShardCityId(cityId);
			key.setRentCustId(caseId);
			ErpFunRentCustomer erpRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(key);
			if (erpRentCustomer != null) {
				returnMap.put("compId", erpRentCustomer.getCompId());
				returnMap.put("areaId", erpRentCustomer.getAreaId());
				returnMap.put("regId", erpRentCustomer.getRegId());
				returnMap.put("deptId", erpRentCustomer.getDeptId());
				returnMap.put("grId", erpRentCustomer.getGrId());
				returnMap.put("userId", erpRentCustomer.getUserId());
				returnMap.put("plateType", Integer.valueOf(erpRentCustomer.getPlateType()));
			}
		}
		return returnMap;
	}

	/**
	 * 公共写跟进
	 * @author 臧铁
	 * @param param  userName  deptName  cityShareName  currentUserId  currentCompId  currentDeptId  cityId 注意param在controller中需要有这些参数  下面的才会生效
	 * @param type  类型
	 * @param flag  开关 0关 1开
	 * @since 2017年5月19日
	 * @return
	 */
	@Transactional
	@Override
	public void addTrack(Integer caseId, String caseNo, String type, String flag, Integer caseType, BaseMapParam param) throws Exception {
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		String currUserName = param.getString("userName");

		String trackContent = currUserName + " 对该数据的信息进行了编辑\n";
		if(type.equals(Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_5)){
			trackContent = currUserName + " 删除了图片，该数据不再满足真房源条件\n";
		}else if(Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_7.equals(type)){
			trackContent = currUserName + " 删除了视频，该数据不再满足真房源条件\n";
		}
		if(type.equals(Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_7) || type.equals(Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_1) ||type.equals(Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_5)){
			if("1".equals(flag)){
				trackContent += "跟进内容：真房源: 非真房源 >> 真房源";
				erpFunTrack.setIncludeTrack(Byte.valueOf(Constants_DIC.DIC_TRACK_INCLUDE_TRACK_TRUEHOUSE));
			}else{
				trackContent += "跟进内容：真房源: 真房源 >> 非真房源";
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_COOP_INFO_TYPE_2)){
			if("1".equals(flag)){
				trackContent += "跟进内容：是否合作: 不合作 >> 要合作";
			}else{
				trackContent += "跟进内容：是否合作: 要合作 >> 不合作";
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_WEIDIAN_INFO_TYPE_3)){
			if("1".equals(flag)){
				trackContent += "跟进内容：网店: 不发布 >> 要发布";
				erpFunTrack.setIncludeTrack(Byte.valueOf(Constants_DIC.DIC_TRACK_INCLUDE_TRACK_MICROSHOP_PUBLISH));
			}else{
				trackContent += "跟进内容：网店: 要发布 >> 不发布";
				erpFunTrack.setIncludeTrack(Byte.valueOf(Constants_DIC.DIC_TRACK_INCLUDE_TRACK_MICROSHOP_DOWN));
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_TENCENT_INFO_TYPE_4)){
			if("1".equals(flag)){
				trackContent += "跟进内容：发布到腾讯网: 不发布 >> 要发布";
			}else{
				trackContent += "跟进内容：发布到腾讯网: 要发布 >> 不发布";
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_YOU_INFO_TYPE_6)){
			if("1".equals(flag)){
				trackContent += "跟进内容：" +param.getObject("cityShareName")+ "房源: 不分享 >> 要分享";
			}else{
				trackContent += "跟进内容：" +param.getObject("cityShareName")+ "房源: 要分享 >> 不分享";
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_YOU_INFO_TYPE_8)){
			if("1".equals(flag)){
				trackContent += "跟进内容：" +param.getObject("cityShareName")+ "客源: 不分享 >> 要分享";
			}else{
				trackContent += "跟进内容：" +param.getObject("cityShareName")+ "客源: 要分享 >> 不分享";
			}
		}else if(type.equals(Constants_DIC.DIC_INFO_CITY_SHARE)){ // 10 分享城市公盘
			if(flag.equals(Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_1)){
				trackContent += "跟进内容：合作分享" + ": 不合作 >> 要合作";
			}else if(flag.equals(Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_2)){
				trackContent += "跟进内容：合作分享" + ": 不合作 >> 隐号合作";
			}else if(flag.equals(Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_3)){
				trackContent += "跟进内容：合作分享" + ": 要合作>> 不合作";
			}else if(flag.equals(Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_DOWN_TYPE_4)){
				trackContent += "跟进内容：合作分享" + ": 隐号合作>> 不合作";
			}
		}
		Map<String,Integer> resultMap = erpFunTrackService.getCaseInfo(param.getInteger("cityId"), param.getInteger("caseId"),param.getInteger("caseType"));
		erpFunTrack.setCaseId(caseId);
		erpFunTrack.setCaseNo(caseNo);
		erpFunTrack.setCaseType(caseType.byteValue());
		erpFunTrack.setTrackClassic(Constants_DIC.DIC_TRACKCLASSIC_7);
		erpFunTrack.setTrackContent(trackContent);
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
		erpFunTrack.setCreatorUid(param.getInteger("currentUserId"));
		erpFunTrack.setCaseUserId(resultMap.get("userId"));
		erpFunTrack.setCaseDeptId(resultMap.get("deptId"));
		erpFunTrack.setCreationTime(DateUtil.DateToString(new Date()));
		erpFunTrack.setCompId(param.getInteger("currentCompId"));
		erpFunTrack.setDeptId(param.getInteger("currentDeptId"));
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setShardCityId(param.getInteger("cityId"));
		erpFunTrackService.insertSelective(erpFunTrack);
	}

	@Override
	@Deprecated
	public String convertSecretInfo(String trackContent, String caseType, boolean phoneShow) {
		// 请使用CommonUtil的convertSecretInfo方法
		return null;
	}

	/**
	 * 相关人操作跟进
	 * @author 熊刚
	 * @since 2017年9月8日
	 * @param param
	 * @param erpFunUsers
	 */
	@Override
	public void insertHousePeopleRelativeTrack(HousePeopleRelativeParam param, ErpFunUsers erpFunUsers) {
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		String trackContent = this.getTrackContent(param.getCityId(), param.getDeptName(), param.getUserName(),
				param.getPeopleType(), param.getBeforUserId(), erpFunUsers, param.getRemarksContent(), param.getDelFlag());
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getCaseId());
			erpFunTrack.setCaseDeptId(erpFunSale.getDeptId());
			erpFunTrack.setCaseUserId(erpFunSale.getUserId());
			erpFunTrack.setCaseNo(erpFunSale.getSaleNo());
		} else {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getCaseId());
			erpFunTrack.setCaseDeptId(erpFunLease.getDeptId());
			erpFunTrack.setCaseUserId(erpFunLease.getUserId());
			erpFunTrack.setCaseNo(erpFunLease.getLeaseNo());
		}
		erpFunTrack.setShardCityId(param.getCityId());
		erpFunTrack.setTrackContent(trackContent);
		erpFunTrack.setCaseId(param.getCaseId());
		erpFunTrack.setCaseType(param.getCaseType().byteValue());
		erpFunTrack.setCompId(param.getCompId());
		erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunTrack.setCreatorUid(param.getSelfUserId());
		erpFunTrack.setDeptId(param.getDeptId());
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setGrId(param.getGrId());
		erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_RELATIVE_PEOPLE_CHANGE);
		erpFunTrackMapper.insertSelective(erpFunTrack);
	}

	/**
	 * 获取跟进内容
	 * @author 熊刚
	 * @since 2017年9月8日
	 * @param deptName 门店名
	 * @param peopleType 相关人类型
	 * @param userName 操作人
	 * @param afterUserName 改过后的人
	 * @param changeUserName 被改人
	 * @return
	 */
	public String getTrackContent(Integer cityId, String deptName, String userName, Integer peopleType, Integer beforUserId,
			ErpFunUsers erpFunUsers, String remarksContent, Integer delFlag) {
		String beforDeptAndUser = null;
		String changeDeptAndUser = null;
		if (erpFunUsers == null || (null != delFlag && 1 == delFlag)) {
//			changeDeptAndUser = "空";
		} else {
//			ErpFunDepts funDetps = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
			changeDeptAndUser = erpFunUsers.getUserName();
		}
		if (beforUserId == null) {
//			beforDeptAndUser = "空";
		} else {
			ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, beforUserId);
//			ErpFunDepts funDetps = erpFunDeptsMapper.getByDeptId(cityId, funUsers.getDeptId());
			beforDeptAndUser = funUsers.getUserName();
		}
		StringBuilder content = new StringBuilder();
		if (beforUserId == null) {// 添加
			content.append(userName).append(" 添加该分佣人员<br/>").append(CommonUtil.getHousePeopleRelativeName(peopleType) + "：")
			.append(changeDeptAndUser + " ");
		} else if (erpFunUsers == null || (null != delFlag && 1 == delFlag)) {// 删除
			content.append(userName).append(" 删除该分佣人员<br/>").append(CommonUtil.getHousePeopleRelativeName(peopleType) + "：")
			.append(beforDeptAndUser + " ");
		} else {// 修改
			content.append(userName).append(" 修改该分佣人员<br/>").append(CommonUtil.getHousePeopleRelativeName(peopleType) + "：")
			.append(beforDeptAndUser).append(" >> ").append(changeDeptAndUser + " ");
		}
		if (remarksContent != null) {
			content.append("跟进内容：").append(remarksContent);
		}
		return content.toString();
	}

	/**
	 * 删除跟进日志
	 * @author 熊刚
	 * @since 2017年9月21日
	 * @param cityId
	 * @param param
	 */
	@Override
	public void deleteFunTrack(Integer cityId,BaseMapParam param) {
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setTrackId(param.getInteger("trackId"));
		erpFunTrack.setIsDel((byte)1);
		erpFunTrack.setCaseUserId(param.getInteger("userId"));
		erpFunTrack.setDelUserName(param.getString("userName"));
		erpFunTrack.setShardCityId(param.getInteger("cityId"));
		erpFunTrack.setDelTime(DateUtil.getDate(DateTimeHelper.formatDateTimetoString(new Date())));
		erpFunTrackMapper.updateByPrimaryKeySelective(erpFunTrack);
	}

	@Override
	public List<ErpFunTrack> getNewExaminTask(Integer cityId, BaseMapParam param) {

		return null;
	}

	@Transactional
	@Override
	public Map<String, Object> createTrackInfo(ErpCreateTrackInfoParam param) {
		// 把房源的信息放入参数（需要放在外面，创建审核任务时候还没进创建跟进方法要用房源信息）
		CaseInfoDto caseInfoDto = this.getCaseInfoById(param.getCityId(), param.getCaseId(), param.getCaseType());
		param.setCaseInfoDto(caseInfoDto);
		// 依据房客源设置一些公用信息
		this.generatorCaseInfoToParam(param);
		// 创建审核任务的人和门店
		ErpFunUsers createUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getSelfUserId());
		ErpFunDepts createDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getSelfDeptId());
		param.setCreateAuditUser(createUsers);
		param.setCreateAuditDept(createDepts);

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("needAudit", 0);// 是否是人工审核跟进
		// 带看的时候多次循环调用
		if (Const.DIC_TRACK_TYPE_DAIKAN.equals(param.getTrackType())) {
			// 房源ID
			String targetIds = param.getTargetIds();
			String[] targetIdArr = targetIds.split(",");
			String[] dkPhotoUrlArr = null;
			if (StringUtils.isNotBlank(param.getPhotoUrls())) {
				dkPhotoUrlArr = param.getPhotoUrls().split(",");
			}
			param.setTargetIdLength(targetIdArr.length);
			for (int i = 0; i < targetIdArr.length; i++) {
				// 里面的方法（generatorParamByParam）会把TargetIds赋值到TargetId
				param.setTargetIds(targetIdArr[i]);
				Integer targetId = StringUtil.parseInteger(targetIdArr[i], 0);
				Integer targetType = param.getTargetType();
				param.setTargetId(targetId);// 赋值到targetId，里面使用targetId
				// 带看信息
				CaseInfoDto targetCaseInfoDto = this.getCaseInfoById(param.getCityId(), targetId, targetType);
				param.setTargetCaseInfoDto(targetCaseInfoDto);
				if (targetCaseInfoDto.getErpFunSale() != null) {
					param.setTargetNo(targetCaseInfoDto.getErpFunSale().getSaleNo());
					param.setTargetUseage(targetCaseInfoDto.getErpFunSale().getSaleUseage().intValue());
				} else if (targetCaseInfoDto.getErpFunLease() != null) {
					param.setTargetNo(targetCaseInfoDto.getErpFunLease().getLeaseNo());
					param.setTargetUseage(targetCaseInfoDto.getErpFunLease().getLeaseUseage().intValue());
				}
				// 只适用于一个带看房源一张图片
				boolean haveDkPhoto = dkPhotoUrlArr != null && dkPhotoUrlArr.length > i && StringUtils.isNotBlank(dkPhotoUrlArr[i]);
				param.setPhotoUrls(haveDkPhoto ? dkPhotoUrlArr[i] : null);
				this.createTrackInfo(param, resultMap);

			}
			// 用完了一定要设置回去，外面还要用
			param.setTargetIds(targetIds);
		} else {
			this.createTrackInfo(param, resultMap);
		}
		return resultMap;
	}

	/**
	 * lcb
	 * 带看评价(看了没用就注释掉了)
	 *
	 * **/
//	private void daiKanEva(ErpCreateTrackInfoParam param) {
//		try{
//			CaseInfoDto caseInfoDto = param.getCaseInfoDto();
//			String cellEncode = "";
//			if(Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType())) {
//				cellEncode = caseInfoDto.getErpFunBuyCustomer().getCellPhone();
//			}else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(param.getCaseType())) {
//				cellEncode = caseInfoDto.getErpFunRentCustomer().getCellPhone();
//			}
//			cellEncode = PhoneUtil.decodePhoneToArr(cellEncode, false)[0];
//			// 推送
//			Map<String, Object> content = new HashMap<>();
//			content.put("cityId", param.getCityId());
//			content.put("reservePhone", cellEncode);
//			content.put("busType","5");
//			content.put("caseType", param.getTargetType());
//			content.put("caseIds", param.getTargetIds());
//			content.put("dkUserId", param.getSelfUserId());
//			// 扩展字段，增加哪一个工作量，和数据库表字段名一致
//			// 增加的量，大于1时caseId是个数组[12,56,46]
//			// 组装消息的发送
//			AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
//			adminJmsMessage.setMsgSource("ERP");
//			adminJmsMessage.setAction(JmsMsgAction.SEND_MESSAGE);
//			adminJmsMessage.setCreateTime(new Date());
//			adminJmsMessage.setCityId(param.getCityId());
//			adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_4);
//			adminJmsMessage.setMsgContent(JSON.toJSONString(content));
//			JmsPublisher.sendMessage(adminJmsMessage);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * 区分营销版和门店版
	 * @author 张宏利
	 * @since 2017年11月15日
	 */
	private void createTrackInfo(ErpCreateTrackInfoParam param, Map<String, Object> resultMap) {
		// 营销版创建跟进或精英版创建跟进
		if (Const.DIC_COMP_TYPE_3.equals(param.getCompType()) || param.getIsPersonalVersion()) {
			param.setTrackFromType(1);// 营销版或精英版
			this.createCommonTrackInfo(param, resultMap);
		} else {
			// 门店版创建跟进
			// 转私盘判断已抢条数是否大于可抢条数
			if (Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE.equals(param.getTrackType())) {
				this.getPublicCaseCount(param.getCaseType(), param.getCityId(), param.getCompId(), param.getCreateAuditUser().getUserId());
			}
			param.setTrackFromType(2);// 初始为门店版自动审核
			this.createTrackInfoForDept(param, resultMap);
		}
		// 创建提醒任务
		erpFunTaskService.createWarmTask(param, null, (byte) 0);
	}

	/**
	 * 门店版创建跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 * @param resultMap
	 * @return
	 * @throws Exception
	 */
	private void createTrackInfoForDept(ErpCreateTrackInfoParam param, Map<String, Object> resultMap) {
		Byte trackType = param.getTrackType();
		Integer cityId = param.getCityId();
		Integer createAuditUid = param.getCreateAuditUser().getUserId();
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		Integer compId = param.getCompId();
		Assert.isNullThrow(trackType, "请选择跟进类型！【TRACK_TYPE】");
		// 0=初始，1=无需审核，2=已全部通过且处理完成(全部是自己审核，一路自动通过)，3=创建审核成功
		Integer auditResult = 0;
		if (Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(trackType)) {
			// 提交钥匙时钥匙所在门店为空则无需审核
			if (param.getKeyDeptId() == null) {
				auditResult = 1;
			}
		} else if (Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(trackType)) {
			// 查看电话在里面判断是否需要审核
			auditResult = 1;
			// 判断是否已经申请了查看，如果已经申请 请等待审核。
			this.checkApply4Viewexamin(cityId, compId, createAuditUid, caseType, caseId);
		}
		if (auditResult == 0) {
			// 修改房源所属楼盘，要设置更改后的楼盘，审核详情页要显示
			if (Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD.equals(trackType)) {
				ErpBuildingInfoDto buildingInfo = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, param.getTargetId());
				param.setTargetNo(param.getCaseBuildName() + ">>" + buildingInfo.getBuildName());
			}
			auditResult = erpAuditRuntimeService.createAuditRuntimeForTrack(param, null);
		}
		// 1=无需审核，2=已全部通过且处理完成(全部是自己审核，一路自动通过)，3=创建审核成功
		if (auditResult == 1) {
			this.createCommonTrackInfo(param, resultMap);
		} else if (auditResult == 2) {
			resultMap.put("needAudit", 0);
		} else if (auditResult == 3 || auditResult == 4) {
			resultMap.put("needAudit", 1);
			resultMap.put("auditId", param.getAuditRuntime().getId());
			resultMap.put("withoutAuditUser", (auditResult == 4) ? 1 : 0);// 4代表没有审核人
			//超期自动审核逻辑
			this.isSendAutoAuditAndLimit(param.getCaseType(), trackType, param.getCompId(), param.getAuditRuntime().getId(), param.getCityId());
		}
		// 添加编辑带看房源项目
		this.addEditReserveItem(param, auditResult);
	}

	/**
	 * 添加编辑带看房源项目
	 * @author lcb
	 * @since 2018年1月24日
	 * @param param
	 * @param auditResult
	 * @param auditResult
	 */
	private void addEditReserveItem(ErpCreateTrackInfoParam param, Integer auditResult) {
		boolean isDaikanTrack = Const.DIC_TRACK_TYPE_DAIKAN.equals(param.getTrackType()) && null != param.getTrackId();
		if (!isDaikanTrack) {
			return;
		}
		Integer trackId = param.getTrackId();
		Byte targetType = Optional.ofNullable(param.getTargetType()).orElse(0).byteValue();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		String userName = "";
		String cellEncode = "";
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType())) {
			ErpFunBuyCustomer erpFunBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
			cellEncode = erpFunBuyCustomer.getCellPhone();
			userName = erpFunBuyCustomer.getBuyCustName();
		}else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(param.getCaseType())) {
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			cellEncode = erpFunRentCustomer.getCellPhone();
			userName = erpFunRentCustomer.getRentCustName();
		}
		String[] tempCellEncode = PhoneUtil.decodePhoneToArr(cellEncode, false);
		cellEncode = (tempCellEncode != null && tempCellEncode.length > 0) ? tempCellEncode[0] : "";
		// 先查询youjia userId
		AdminWMicroshopMemberExample adminWMicroshopMemberExample = new AdminWMicroshopMemberExample();
		adminWMicroshopMemberExample.createCriteria().andPhoneEqualTo(cellEncode);
		List<AdminWMicroshopMember> adminWMicroshopMemberList = adminWMicroshopMemberMapper.selectByExample(adminWMicroshopMemberExample);
		if(adminWMicroshopMemberList.size() == 0) {
			return ;
		}

		// 查询最新的一条未完成的预约记录
		AdminYoujiaReserve adminYoujiaReserve = adminYoujiaReserveMapper.selectNotFinish(param.getCityId(), param.getCompId(), cellEncode);
		if(null != adminYoujiaReserve) {
			AdminYoujiaReserveHouseEvaExample adminYoujiaReserveHouseEvaExample = new AdminYoujiaReserveHouseEvaExample();
			adminYoujiaReserveHouseEvaExample.createCriteria().andCaseIdEqualTo(param.getTargetId()).
					andCaseTypeEqualTo(param.getTargetType().byteValue()).andYoujiaUserIdEqualTo(adminWMicroshopMemberList.get(0).getUid());
			List<AdminYoujiaReserveHouseEva> adminYoujiaReserveHouseEvas = adminYoujiaReserveHouseEvaMapper.selectByExample(adminYoujiaReserveHouseEvaExample);
			if(adminYoujiaReserveHouseEvas.size() > 0) {
				AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva = adminYoujiaReserveHouseEvas.get(0);
				adminYoujiaReserveHouseEva.setTrackId(trackId);
				adminYoujiaReserveHouseEva.setTrackType(auditResult.byteValue());
				adminYoujiaReserveHouseEva.setStatus((byte)3);
//				adminYoujiaReserveHouseEva.setHouseShowStatus((byte)1);

				adminYoujiaReserveHouseEvaMapper.updateByPrimaryKeySelective(adminYoujiaReserveHouseEva);
			}else {
				AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva = new AdminYoujiaReserveHouseEva();
				adminYoujiaReserveHouseEva.setCityId(param.getCityId());
				adminYoujiaReserveHouseEva.setYoujiaUserId(adminWMicroshopMemberList.get(0).getUid());
				adminYoujiaReserveHouseEva.setReserverId(adminYoujiaReserve.getId());
				adminYoujiaReserveHouseEva.setCreateTime(new Date());
				adminYoujiaReserveHouseEva.setShowStatus((byte)1);
				adminYoujiaReserveHouseEva.setCaseId(param.getTargetId());
				adminYoujiaReserveHouseEva.setCaseType(targetType);

				// 大客户的都是微店
				if(null == param.getCrmCompId()) {
					adminYoujiaReserveHouseEva.setStatus((byte)3);
					adminYoujiaReserveHouseEva.setHouseShowStatus((byte)0);
				}else {
					adminYoujiaReserveHouseEva.setStatus((byte)2);
					adminYoujiaReserveHouseEva.setHouseShowStatus((byte)1);
				}

				adminYoujiaReserveHouseEva.setReserveFrom(adminYoujiaReserve.getReserveFrom());
				adminYoujiaReserveHouseEva.setCompId(param.getCompId());
				adminYoujiaReserveHouseEva.setDeptId(param.getSelfDeptId());
				adminYoujiaReserveHouseEva.setHouseUserId(param.getCaseUserId());
				adminYoujiaReserveHouseEva.setDkUserId(param.getSelfUserId());
				adminYoujiaReserveHouseEva.setTrackId(trackId);
				adminYoujiaReserveHouseEva.setTrackType(auditResult.byteValue());

				adminYoujiaReserveHouseEva.setReserveTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
				String weekday = DateUtil.getWeek(new Date()).getChineseName()+" 全天";
				adminYoujiaReserveHouseEva.setDateInfo(weekday);
				adminYoujiaReserveHouseEvaMapper.insertSelective(adminYoujiaReserveHouseEva);
			}
		}else {
			// 新增记录
			adminYoujiaReserve = new AdminYoujiaReserve();
			adminYoujiaReserve.setYoujiaUserId(adminWMicroshopMemberList.get(0).getUid());
			adminYoujiaReserve.setCreateTime(new Date());
			adminYoujiaReserve.setReservePhone(cellEncode);
			adminYoujiaReserve.setIsDk((byte)1);
			adminYoujiaReserve.setReserveFrom((byte)3);
			adminYoujiaReserve.setCityId(param.getCityId());
			adminYoujiaReserve.setCompId(param.getCompId());
			adminYoujiaReserve.setReserveName(userName);
			adminYoujiaReserve.setReserveTime(new Date());
			// 创建成功
			adminYoujiaReserveMapper.insertSelective(adminYoujiaReserve);

			AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva = new AdminYoujiaReserveHouseEva();
			adminYoujiaReserveHouseEva.setCityId(param.getCityId());
			adminYoujiaReserveHouseEva.setYoujiaUserId(adminWMicroshopMemberList.get(0).getUid());
			adminYoujiaReserveHouseEva.setReserverId(adminYoujiaReserve.getId());
			adminYoujiaReserveHouseEva.setCreateTime(new Date());
			adminYoujiaReserveHouseEva.setShowStatus((byte)1);
			adminYoujiaReserveHouseEva.setCaseId(param.getTargetId());
			adminYoujiaReserveHouseEva.setCaseType(targetType);
			adminYoujiaReserveHouseEva.setStatus((byte)3);
			adminYoujiaReserveHouseEva.setReserveFrom((byte)0);
			adminYoujiaReserveHouseEva.setCompId(param.getCompId());
			adminYoujiaReserveHouseEva.setDeptId(param.getSelfDeptId());
			adminYoujiaReserveHouseEva.setHouseUserId(param.getCaseUserId());
			adminYoujiaReserveHouseEva.setDkUserId(param.getSelfUserId());
			adminYoujiaReserveHouseEva.setTrackId(trackId);
			adminYoujiaReserveHouseEva.setTrackType(auditResult.byteValue());
			adminYoujiaReserveHouseEva.setHouseShowStatus((byte)0);
			adminYoujiaReserveHouseEva.setReserveTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			String weekday = DateUtil.getWeek(new Date()).getChineseName()+" 全天";
			adminYoujiaReserveHouseEva.setDateInfo(weekday);
			adminYoujiaReserveHouseEvaMapper.insertSelective(adminYoujiaReserveHouseEva);
		}
		if(1 == auditResult || 2 == auditResult) {
			// count下条数
			AdminYoujiaReserveHouseEvaExample adminYoujiaReserveHouseEvaExample = new AdminYoujiaReserveHouseEvaExample();
			adminYoujiaReserveHouseEvaExample.createCriteria().andReserverIdEqualTo(adminYoujiaReserve.getId());
			int i = adminYoujiaReserveHouseEvaMapper.countByExample(adminYoujiaReserveHouseEvaExample);
			if(i>= param.getTargetIdLength()) {
				if(null == param.getCrmCompId()) {
					// 判断是否是大客户
					// 发送jms 判断是否推送
//					Map<String, Object> content = new HashMap<>();
//					content.put("cityId", param.getCityId());
//					content.put("reserveId", adminYoujiaReserve.getId());
//					content.put("busType","5");
//					content.put("dkUserId", param.getSelfUserId());
//					// 扩展字段，增加哪一个工作量，和数据库表字段名一致
//					// 增加的量，大于1时caseId是个数组[12,56,46]
//					// 组装消息的发送
//					AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
//					adminJmsMessage.setMsgSource("ERP");
//					adminJmsMessage.setAction(JmsMsgAction.SEND_MESSAGE);
//					adminJmsMessage.setCreateTime(new Date());
//					adminJmsMessage.setCityId(param.getCityId());
//					adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_4);
//					adminJmsMessage.setMsgContent(JSON.toJSONString(content));
//					JmsPublisher.sendMessage(adminJmsMessage);
					// 用新方式发送消息
					AsycPushMessage asycPushMessage = new AsycPushMessage();
					asycPushMessage.setCityId(param.getCityId());
					asycPushMessage.setReserveId(adminYoujiaReserve.getId());
					asycPushMessage.setBusType(5);
					asycPushMessage.setDkUserId(param.getSelfUserId());
					asycPushMessage.setQueneName(JmsMsgAction.SEND_MESSAGE);
					asycPushMessage.setCreateTime(new Date());
					mqUtil.sendMessage(asycPushMessage);

//				String url = "http://youjia.haofang.net/Home/MyInfo/sendEvaTempMsg";
//				HttpUtil.post(url, content);
					// 更新数据为一带看
					adminYoujiaReserve.setIsDk((byte)1);
					adminYoujiaReserveMapper.updateByPrimaryKeySelective(adminYoujiaReserve);
				}else {
					// 全部更新成带看
					AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva = new AdminYoujiaReserveHouseEva();
					adminYoujiaReserveHouseEva.setStatus((byte)3);
					adminYoujiaReserveHouseEvaMapper.countByExample(adminYoujiaReserveHouseEvaExample);

					adminYoujiaReserve = new AdminYoujiaReserve();
					adminYoujiaReserve.setId(adminYoujiaReserveHouseEva.getReserverId());
					adminYoujiaReserve.setIsDk((byte) 1);
					adminYoujiaReserveMapper.updateByPrimaryKeySelective(adminYoujiaReserve);
				}
			}
		}
	}

	/**
	 * 判断是否发送自动审核消息
	 * @author 张宏利
	 * @since 2017年11月16日
	 * @param caseType
	 * @param trackType
	 * @param compId
	 * @param auditRuntimeId
	 * @param cityId
	 */
	public void isSendAutoAuditAndLimit(Integer caseType , Byte trackType, Integer compId, Integer auditRuntimeId, Integer cityId){
		String limitItem = this.getCompSysParamExam(trackType);
		if(StringUtils.isBlank(limitItem)) {
			return;
		}
		String paramId = null;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			paramId = "AUTO_ADUIT_HOUSE_ITEMS";
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			paramId = "AUTO_ADUIT_CUSTOMER_ITEMS";
		}
		String itemParam = erpSysParaMapper.getParamValue(cityId, compId, paramId);
		if (StringUtils.isNotBlank(itemParam) && itemParam.contains(limitItem)) {
			String aduitLimit = erpSysParaMapper.getParamValue(cityId, compId, "AUTO_AUDIT_LIMIT");
			if(StringUtils.isNotBlank(aduitLimit)) {
				Integer limit = StringUtil.parseInteger(aduitLimit, 0); // 分钟为单位
				JmsPublisher.sendJmsMessageForAutoExmain(cityId, auditRuntimeId, compId, limit * 60);
			}
		}
	}

	/**
	 * 所有的创建跟进
	 * @author 张宏利
	 * @throws Exception
	 * @since 2017年10月11日
	 */
	private void createCommonTrackInfo(ErpCreateTrackInfoParam param, Map<String, Object> resultMap) {
		Byte trackType = param.getTrackType();
		boolean isPersonalVersion = param.getIsPersonalVersion();
		// 依据参数设置一些特殊信息
		this.generatorParamByParam(param);

		if(Const.DIC_TRACK_TYPE_BARGAIN.equals(trackType)){// 议价-15
			this.createTrack4Bargain(param);
		} else if(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)// 加密-17
				|| Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(trackType)){// 推荐-18
			this.createTrack4HouseLevel(param);//z-
		} else if(Const.DIC_TRACK_TYPE_DAIKAN.equals(trackType)){// 带看-4
			this.createTrack4DaiKan(param);
		} else if(Const.DIC_TRACK_TYPE_FUNCAN.equals(trackType)){// 房勘-3
			this.createTrack4FangKan(param);//z-
		} else if (Const.DIC_TRACK_TYPE_LIMITED.equals(trackType)// 限时-6
				|| Const.DIC_TRACK_TYPE_ALONE.equals(trackType)// 独家-7
				|| Const.DIC_TRACK_TYPE_RENT.equals(trackType)// 包租-9
				|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(trackType)) {// 普通委托-19
			this.createTrack4Weituo(param);
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)) {// 转有效-21
			if(!isPersonalVersion) {
				this.judgeCanTransAvailable(param, "转为有效", true);
			}
			this.createTrack4TransAvailable(param);
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE.equals(trackType)) {// 转私盘-22
			this.createTrack4TransPrivate(param, resultMap);
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSSALE.equals(trackType)) {// 转售-23
			this.createTrackTransSale(param);
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE.equals(trackType)) {// 转租-24
			this.createTrackTransLease(param);
		} else if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)// 预订-25
				|| Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)// 封盘-26
				|| Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)// 暂缓-27
				|| Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)// 内成交-28
				|| Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)// 外成交-29
				|| Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)// 注销-30
				|| Const.DIC_TRACK_TYPE_STATUS_AVAILABLE.equals(trackType)// 普通-50
				) {
			if(Const.DIC_COMP_TYPE_1.equals(param.getCompType())) {
				this.createTrack4DeptStatusChange(param);// 门店版状态变更
			} else {
				this.createTrack4StatusChange(param);// 营销版或纯精英版状态变更
			}
		} else if (Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(trackType)) {// 查看电话-31
			this.createTrack4ViewPhone(param, resultMap);
		} else if (Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD.equals(trackType)) {// 楼盘变更-20
			if(!isPersonalVersion) {
				this.judgeCanTransAvailable(param, "修改楼盘", false);
			}
			this.createTrack4ChangeBuild(param);
		} else if (Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(trackType)) {// 提交钥匙-32
			this.createTrack4SubmitKey(param);
		} else if (Const.DIC_TRACK_TYPE_BORROW_KEY.equals(trackType)) {// 钥匙借用-33
			this.createTrack4BorrowKey(param);
		} else if (Const.DIC_TRACK_TYPE_RETURN_KEY.equals(trackType)) {// 钥匙归还-34
			this.createTrack4ReturnKey(param);
		} else if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(trackType)) {// 钥匙注销-35
			this.createTrack4DestroyKey(param);
		} else if (Const.DIC_TRACK_TYPE_CASE_TRANSFER.equals(trackType)) {// 公盘房源数据移交-54
			this.createTrack4TransData(param);
		} else if (Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER.equals(trackType)) {// 私盘数据移交-55
			this.createTrack4TransPrivateData(param);
		}
//		else if (Const.DIC_TRACK_TYPE_NOLY_SALE.equals(trackType)) {// 仅售,仅租(暂时取消)
//			this.createTrack4OnlySaleOrLease(param);
//		}
		else {// 普通跟进
			this.createTrack4Common(param);
		}
		// 走过流程之后还是需要审核的，则不走下面的逻辑
		Integer needAudit = StringUtil.parseInteger(resultMap.get("needAudit"), 0);
		if(needAudit == 1) {
			return;
		}
		// 当跟进人不是本人或者他店的，要为信息所属人写一条跟进提醒任务
		this.writeWarmTaskForInfoOner(param);
	}

	/**
	 * 发送jms消息增加工作量等
	 * @author 张宏利
	 * @since 2017年10月31日
	 */
	
	public void sendJmsMessageForWorkCount(ErpCreateTrackInfoParam param) {
		Byte trackType = param.getTrackType();
		StatisticDetailType statisticDetailType = param.getStatisticDetailType();
		ErpAuditRuntime auditRuntime = param.getAuditRuntime();
		Integer createAuditUserId = param.getCreateAuditUser().getUserId();
		Date auditCreationTime = (auditRuntime != null) ? auditRuntime.getCreationTime() : new Date();
		if(statisticDetailType == null) {
			return;
		}
		param.setStatisticDetailType(null);// 防止多次增加工作量（全部自动通过的情况会出现）
		// 增加工作量
		double totalPrice = Optional.ofNullable(param.getTotalPrice()).orElse(BigDecimal.ZERO).doubleValue();
		if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)// 内成交-28
						|| Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)) {// 外成交-29
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
				ErpFunSale erpFunSale = param.getCaseInfoDto().getErpFunSale();
				if (totalPrice <= 0) {
					totalPrice = Optional.ofNullable(erpFunSale.getSaleTotalPrice()).orElse(BigDecimal.ZERO).doubleValue();
				}
				totalPrice = totalPrice * 10000;
			} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())){
				ErpFunLease erpFunLease = param.getCaseInfoDto().getErpFunLease();
				byte priceUnit = Optional.ofNullable(param.getPriceUnit()).orElse(0).byteValue();
				if (totalPrice <= 0) {
					totalPrice = Optional.ofNullable(erpFunLease.getLeaseTotalPrice()).orElse(BigDecimal.ZERO).doubleValue();
				}
				if (priceUnit <= 0) {
					priceUnit = Optional.ofNullable(erpFunLease.getPriceUnit()).orElse((byte) 0);
				}
				double leaseArea = Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(new BigDecimal(20)).doubleValue();
				totalPrice = CommonUtil.getLeaseMoneyByMonth(priceUnit, totalPrice, leaseArea);
				if (param.getTargetTime() != null) {
					// 元每月*多少个月
					double daysOfTwoDate = DateTimeHelper.getDaysOfTwoDate(new Date(), param.getTargetTime());
					totalPrice = totalPrice * (Math.abs(daysOfTwoDate) / 30);
				}
			}
		}
		// 带看工作量特殊处理（带看有多个员工）
		if(StatisticDetailType.DK_COUNT.equals(statisticDetailType)
				|| StatisticDetailType.SPDK_COUNT.equals(statisticDetailType)) {
			String[] targetIdArr = param.getTargetIds().split(",");// 房源ID
			String[] userIdArr = StringHelper.split(param.getUserIds(), ",");
			// 循环发消息的每个消息增加延迟时间
			int delaySeconds = 0;
			// 循环给每个房源加
			for (String targetId : targetIdArr) {
				Integer targetIdInt = StringUtil.parseInteger(targetId, 0);
				// 循环给每个带看用户加
				for (String userIdStr : userIdArr) {
					delaySeconds += 2;
					Integer userId = StringUtil.parseInteger(userIdStr, 0);
					this.sendJmsMessageForWorkCount(param.getCityId(), statisticDetailType, auditCreationTime,
							userId, param.getCaseType(), String.valueOf(param.getCaseId()), targetIdInt, 1, null, delaySeconds);
				}
			}
		} else {
			this.sendJmsMessageForWorkCount(param.getCityId(), statisticDetailType, auditCreationTime,
					createAuditUserId, param.getCaseType(), String.valueOf(param.getCaseId()), param.getTrackId(), 1, totalPrice, 0);
		}
	}

	/**
	 * 发送jms消息增加工作量等
	 * @author 张宏利
	 * @since 2017年10月31日
	 */
	public void sendJmsMessageForWorkCount(Integer cityId, StatisticDetailType countFieldName, Date auditCreationTime,
			Integer userId, Integer caseType, String caseId, Integer trackId, int countSize, Double dealMoney, Integer delaySeconds) {
		if(countFieldName == null) {
			return;
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		// 工作量算在审批当天
		String workCountExamineDay = erpSysParaMapper.getParamValue(cityId, erpFunUsers.getCompId(), "WORK_COUNT_EXAMINE_DAY");
		if("1".equals(workCountExamineDay)) {
			auditCreationTime = new Date();
		}
		Integer grId = erpFunUsers.getGrId();
		Map<String, Object> content = new HashMap<>();
		content.put("CASE_TYPE", caseType);
		content.put("CASE_ID", caseId);
		content.put("TRACK_ID", trackId);
		content.put("DEAL_MONEY", dealMoney);
		content.put("ARCHIVE_ID", erpFunUsers.getArchiveId());
		content.put("USER_ID", erpFunUsers.getUserId());
		content.put("GR_ID", grId == null ? 0 : grId);
		content.put("DEPT_ID", erpFunUsers.getDeptId());
		content.put("REG_ID", erpFunUsers.getRegId());
		content.put("AREA_ID", erpFunUsers.getAreaId());
		content.put("COMP_ID", erpFunUsers.getCompId());
		content.put("CITY_ID", erpFunUsers.getCityId());
		content.put("STATISTIC_TYPE", countFieldName.toString());
		// 必须是到日
		content.put("CREATE_TIME", DateTimeHelper.formatDatetoString(auditCreationTime));
		// 扩展字段，增加哪一个工作量，和数据库表字段名一致
		content.put("COUNT_FIELD_NAME", countFieldName.name());
		// 增加的量，大于1时caseId是个数组[12,56,46]
		content.put("COUNT_SIZE", String.valueOf(countSize));
		AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
		adminJmsMessage.setMsgSource("ERP");
		adminJmsMessage.setAction(JmsMsgAction.ADD_WORK_COUNT);
		adminJmsMessage.setCreateTime(new Date());
		adminJmsMessage.setCityId(cityId);
		adminJmsMessage.setDelaySeconds(delaySeconds);
		adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_1);
		adminJmsMessage.setMsgContent(JSON.toJSONString(content));
		JmsPublisher.sendMessage(adminJmsMessage);
	}

	/**
	 * 所有审核任务完成之后执行
	 * @author 张宏利
	 * @param cityId 城市ID
	 * @param auditUserId 审核人userId
	 * @throws Exception
	 * @since 2017年10月17日
	 */
	@Override
	public ErpCreateTrackInfoParam auditEndExec(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId ,Integer trackFromType, Integer sureToAviliable) {
		ErpCreateTrackInfoParam param = generatorTrackParam(auditRuntime, cityId, auditUserId, trackFromType);
		if(null != sureToAviliable) {
			param.setSureToAviliable(sureToAviliable);
		}
		// 把房源的信息放入参数（需要放在外面，创建审核任务时候还没进创建跟进方法要用房源信息）
		CaseInfoDto caseInfoDto = this.getCaseInfoById(param.getCityId(), param.getCaseId(), param.getCaseType());
		param.setCaseInfoDto(caseInfoDto);
		// 带看信息
		if (Const.DIC_TRACK_TYPE_DAIKAN.equals(param.getTrackType())) {
			Integer targetId = StringUtil.parseInteger(auditRuntime.getTargetIds(), 0);
			Integer targetType = param.getTargetType();
			CaseInfoDto targetCaseInfoDto = this.getCaseInfoById(param.getCityId(), targetId, targetType);
			param.setTargetCaseInfoDto(targetCaseInfoDto);
		}
		// 依据房客源设置一些公用信息
		this.generatorCaseInfoToParam(param);
		Map<String, Object> resultMap = new HashMap<>();
		// 通过后的trackId
		this.createCommonTrackInfo(param, resultMap);
		// 同步带看评价数据
		this.dealReserveData(cityId, param, auditRuntime);
		// 增加工作量，必须在最后
		erpFunTrackService.sendJmsMessageForWorkCount(param);
		return param;
	}

	/**
	 * 同步带看评价数据
	 * @author lcb
	 * @since 2018年1月24日
	 * @param cityId
	 * @param param
	 * @param auditRuntime
	 */
	private void dealReserveData(Integer cityId, ErpCreateTrackInfoParam param, ErpAuditRuntime auditRuntime) {
		// 申请时的trackId
		Integer trackIdNew = param.getTrackId();
		Integer trackIdOld = auditRuntime.getTrackId();
		if (!Const.DIC_TRACK_TYPE_DAIKAN.equals(param.getTrackType()) || trackIdOld == null) {
			return;
		}
		// 直接查询更新
		AdminYoujiaReserveHouseEvaExample adminYoujiaReserveHouseEvaExample = new AdminYoujiaReserveHouseEvaExample();
		adminYoujiaReserveHouseEvaExample.createCriteria().andCityIdEqualTo(cityId)
				.andCompIdEqualTo(param.getCompId()).andTrackIdEqualTo(trackIdOld)
				.andCaseIdEqualTo(param.getTargetId());
		List<AdminYoujiaReserveHouseEva> adminYoujiaReserveHouseEvas = adminYoujiaReserveHouseEvaMapper.selectByExample(adminYoujiaReserveHouseEvaExample);
		if (adminYoujiaReserveHouseEvas.size() > 0) {
			AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva = adminYoujiaReserveHouseEvas.get(0);
			adminYoujiaReserveHouseEva.setTrackId(trackIdNew);
			adminYoujiaReserveHouseEva.setStatus((byte)3);
			adminYoujiaReserveHouseEva.setTrackType((byte) 4);
			adminYoujiaReserveHouseEvaMapper.updateByPrimaryKeySelective(adminYoujiaReserveHouseEva);

			adminYoujiaReserveHouseEvaExample = new AdminYoujiaReserveHouseEvaExample();
			adminYoujiaReserveHouseEvaExample.createCriteria().andCityIdEqualTo(cityId)
					.andCompIdEqualTo(param.getCompId())
					.andReserverIdEqualTo(adminYoujiaReserveHouseEva.getReserverId())
					.andTrackTypeEqualTo((byte) 3);
			int houseEvaCount = adminYoujiaReserveHouseEvaMapper.countByExample(adminYoujiaReserveHouseEvaExample);


			if (houseEvaCount == 0) {

				// 判断是否是大客户公司
			    ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, param.getCompId());
				// 先查询到adminCompId
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(null != adminFunComp) {
					AdminCrmComp adminCrmComp = adminCrmCompMapper.getCrmCompNo(adminFunComp.getCompId());
					if(null != adminCrmComp) {
						AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva1 = new AdminYoujiaReserveHouseEva();
						adminYoujiaReserveHouseEva1.setStatus((byte)3);
						adminYoujiaReserveHouseEvaMapper.updateByExample(adminYoujiaReserveHouseEva1, adminYoujiaReserveHouseEvaExample);
						AdminYoujiaReserve adminYoujiaReserve = new AdminYoujiaReserve();
						adminYoujiaReserve.setId(adminYoujiaReserveHouseEva.getReserverId());
						adminYoujiaReserve.setIsDk((byte) 1);
						adminYoujiaReserveMapper.updateByPrimaryKeySelective(adminYoujiaReserve);
						return;
					}
				}

				// 发送jms 判断是否推送
//				Map<String, Object> content = new HashMap<>();
//				content.put("cityId", param.getCityId());
//				content.put("reserveId", adminYoujiaReserveHouseEva.getReserverId());
//				content.put("busType", "5");
//				content.put("dkUserId", auditRuntime.getUserId());
//				// 扩展字段，增加哪一个工作量，和数据库表字段名一致
//				// 增加的量，大于1时caseId是个数组[12,56,46]
//				// 组装消息的发送
//				AdminJmsMessage adminJmsMessage = new AdminJmsMessage();
//				adminJmsMessage.setMsgSource("ERP");
//				adminJmsMessage.setAction(JmsMsgAction.SEND_MESSAGE);
//				adminJmsMessage.setCreateTime(new Date());
//				adminJmsMessage.setCityId(param.getCityId());
//				adminJmsMessage.setSendProducer(Const.DIC_JMS_SEND_PRODUCER_4);
//				adminJmsMessage.setMsgContent(JSON.toJSONString(content));
//				JmsPublisher.sendMessage(adminJmsMessage);

				AsycPushMessage asycPushMessage = new AsycPushMessage();
				asycPushMessage.setCityId(param.getCityId());
				asycPushMessage.setReserveId(adminYoujiaReserveHouseEva.getReserverId());
				asycPushMessage.setBusType(5);
				asycPushMessage.setDkUserId(param.getSelfUserId());
				asycPushMessage.setQueneName(JmsMsgAction.SEND_MESSAGE);
				asycPushMessage.setCreateTime(new Date());
				mqUtil.sendMessage(asycPushMessage);

//				String url = "http://youjia.haofang.net/Home/MyInfo/sendEvaTempMsg";
//				HttpUtil.post(url, content);
				// 更新数据为一带看
				AdminYoujiaReserve adminYoujiaReserve = new AdminYoujiaReserve();
				adminYoujiaReserve.setId(adminYoujiaReserveHouseEva.getReserverId());
				adminYoujiaReserve.setIsDk((byte) 1);
				adminYoujiaReserveMapper.updateByPrimaryKeySelective(adminYoujiaReserve);
			}
		}
	}

	// --写跟进方法--开始

	/**
	 * 议价跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 * @throws Exception
	 */
	private void createTrack4Bargain(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer caseType = param.getCaseType();

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());

		erpFunTaskService.updateCaseBargainFlag(erpFunTrack, param.getCaseInfoDto(), param.getCreateAuditUser());
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
		param.setStatisticDetailType(StatisticDetailType.YJ_COUNT);
	}

	/**
	 * 级别跟进-加密或推荐跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4HouseLevel(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer caseType = param.getCaseType();
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		
		if (this.judgeIsInsertLevelTrack(param, caseInfoDto)) {
			erpFunTrackMapper.insertSelective(erpFunTrack);
			param.setTrackId(erpFunTrack.getTrackId());
		}
		erpFunTaskService.updateCaseHouseLevel4House(param, erpFunTrack);
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
	}

	/**
	 * @tag 判断是否要写加密或推荐的跟进
	 * @author 邓永洪
	 * @since 2018/6/14
	 */
	private boolean judgeIsInsertLevelTrack(ErpCreateTrackInfoParam param, CaseInfoDto caseInfoDto) {
		Integer caseType = param.getCaseType();
		Integer selfUserId = param.getSelfUserId();
		Integer creUserId = param.getCreateAuditUser().getUserId();
		byte trackType = param.getTrackType();
		if (!(selfUserId == creUserId && param.getTrackFromType() == 3)){
			return true;
		}
		boolean flag = false;
		switch (caseType) {
			case 1:
				ErpFunSale funSale = caseInfoDto.getErpFunSale();
				flag = (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funSale.getSaleLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funSale.getSaleLevel() == Const.DIC_HOUSE_LEVEL_COMMEND);
				break;
			case 2:
				ErpFunLease funLease = caseInfoDto.getErpFunLease();
				flag = (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funLease.getLeaseLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funLease.getLeaseLevel() == Const.DIC_HOUSE_LEVEL_COMMEND);
				break;
			case 3:
				ErpFunBuyCustomer funBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
				flag = (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funBuyCustomer.getBuyCustLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funBuyCustomer.getBuyCustLevel() == Const.DIC_HOUSE_LEVEL_COMMEND);
				break;
			case 4:
				ErpFunRentCustomer funRentCustomer = caseInfoDto.getErpFunRentCustomer();
				flag = (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD == trackType && funRentCustomer.getRentCustLevel() == Const.DIC_HOUSE_LEVEL_PASSWORD) ||
						(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND == trackType && funRentCustomer.getRentCustLevel() == Const.DIC_HOUSE_LEVEL_COMMEND);
				break;
		}
		return !flag;
	}

	/**
	 * 带看跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4DaiKan(ErpCreateTrackInfoParam param) {
		Integer trackId = null;
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer caseType = param.getCaseType();
		String dkPhotoUrls = param.getPhotoUrls();
		String dkVideoUrls = param.getVideoUrls();// 视频
		String videoLocations = param.getVideoLocations();
		String videoShootingTime = param.getVideoShootingTimes();
		// 审核的时间
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
//		// 关联评价
//		List<AdminYoujiaReserveHouseEva> evaHouseList = param.getEvaHouseList();
//		if(evaHouseList != null && !evaHouseList.isEmpty()) {
//			for (AdminYoujiaReserveHouseEva adminYoujiaReserveHouseEva : evaHouseList ) {
//				// 房源
//				if(targetType.equals(adminYoujiaReserveHouseEva.getCaseType().intValue()) && targetId.equals(adminYoujiaReserveHouseEva.getCaseId())) {
//					erpFunTrack.setReserverHouseEvaId(adminYoujiaReserveHouseEva.getId());
//				}
//			}
//		}
		erpFunTrackMapper.insertSelective(erpFunTrack);
		trackId = erpFunTrack.getTrackId();
		param.setTrackId(trackId);
		// 写提醒任务
		String taskSubject = Const.DIC_TASK_TYPE_TRACK_REMIND_STR + " " + param.getTaskSubject();
		this.createCommonWarmTask(taskSubject, erpFunTrack.getTrackContent(), param, Const.DIC_TASK_TYPE_TRACK_REMIND);
		// 生成带看人
		erpTrackUsersService.createTargetUser(trackId, cityId, compId, param.getUserIds(),
				param.getUserNames(), param.getDeptNames());
		// 带看图片
		erpFunEntrustmentPhotoService.addFunEntrustmentPhotos(cityId, compId, dkPhotoUrls, erpFunTrack.getCaseId(),
				erpFunTrack.getCaseType().intValue(), 2, trackId, createAuditUser.getUserId());
		// 视频带看
		erpTrackVideoService.addTrackVideos(cityId, erpFunTrack.getTargetId(), dkVideoUrls, erpFunTrack.getCaseId(),
				erpFunTrack.getCaseType().intValue(), trackId, createAuditUser.getUserId(),videoLocations,videoShootingTime);
		// 更新房源和客源的带看信息
		erpFunTaskService.updateCaseDaikan4Cust(param, erpFunTrack);
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());

		// 增加工作量（带看有多个员工）
		StatisticDetailType countType = StatisticDetailType.DK_COUNT;
		if(StringUtils.isNotBlank(dkVideoUrls)) {
			countType = StatisticDetailType.SPDK_COUNT;
		}
		param.setStatisticDetailType(countType);
	}

	/**
	 * 房勘跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 * @throws Exception
	 */
	private void createTrack4FangKan(ErpCreateTrackInfoParam param) {
//		不要首次房勘必须传图逻辑了
//		if (param.getTrackFromType() == 2) {
//			if (!param.getHasFankan() && StringUtils.isBlank(param.getPhotoIds())) {
//				throw new ConfirmException("首次房勘必须传图!");
//			}
//		}
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer caseType = param.getCaseType();
		ErpAuditRuntime auditRuntime = param.getAuditRuntime();
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 处理房堪扩展字段
		ErpFunTrackExtend erpFunTrackExtend = new ErpFunTrackExtend();
		if(null != auditRuntime && auditRuntime.getId() != null){
			ErpFunTrackExtendExample example = new ErpFunTrackExtendExample();
			example.createCriteria().andAuditIdEqualTo(auditRuntime.getId());
			example.setShardCityId(param.getCityId());
			List<ErpFunTrackExtend> trackExtendList = erpFunTrackExtendMapper.selectByExample(example);
			if(null != trackExtendList && trackExtendList.size() > 0){
				erpFunTrackExtend = trackExtendList.get(0);
				erpFunTrackExtend.setAuditId(null);
			}
		}
		erpFunTrackExtend.setTrackId(erpFunTrack.getTrackId());
		erpFunTrackExtend.setShardCityId(param.getCityId());
		// 判断
		if(StringUtils.isNotBlank(param.getFitmentDescribe())
				|| StringUtils.isNotBlank(param.getCoreSellPoint())
				|| StringUtils.isNotBlank(param.getLayoutIntroduce())
				|| StringUtils.isNotBlank(param.getPropertyRights())) {
			erpFunTrackExtend.setCompId(param.getCompId());
			erpFunTrackExtend.setFitmentDescribe(param.getFitmentDescribe());
			erpFunTrackExtend.setCoreSellPoint(param.getCoreSellPoint());
			erpFunTrackExtend.setLayoutIntroduce(param.getLayoutIntroduce());
			erpFunTrackExtend.setPropertyRights(param.getPropertyRights());
		}
		erpFunTrackExtend.setCreationTime(new Date());
		erpFunTrackExtendMapper.insertSelective(erpFunTrackExtend);
		//更新房源的房勘信息
		erpFunTaskService.updateCaseFangcan4House(param, erpFunTrack);
		Boolean isSaleLease = (param.getSaleLeaseId() != null);
		String createCurrUserName = param.getCreateCurrUserName();
		this.updateFkPhotoStatus(erpFunTrack, param.getOldStatus().byteValue(), param.getPhotoIds(), param.getVrIds(),
				param.getVideoIds(), isSaleLease, param.getSaleLeaseId(), createCurrUserName, param.getCaseDeptId(),
				param.getCaseUserId(), erpFunTrack.getCreatorUid(), erpFunTrack.getDeptId());
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
		param.setStatisticDetailType(StatisticDetailType.FK_COUNT);
	}

	/**
	 * 审核通过后,更改图片状态
	 *
	 * @author flj
	 * @since 2017年11月02日
	 * @param erpFunTrack
	 * @param photoIds
	 * @param isSaleLease
	 * @param otherSaleLeaseId
	 * @throws Exception
	 */
	private void updateFkPhotoStatus(ErpFunTrack erpFunTrack, Byte caseStatus, String photoIds, String vrIds,
			String videoIds, boolean isSaleLease, Integer otherSaleLeaseId, String currUserName, Integer caseDeptId,
			Integer caseUserId, Integer creatorUserId, Integer creatorDeptId) {
		Integer caseType = erpFunTrack.getCaseType().intValue();
		String dateTimeNow = String.valueOf(DateTimeHelper.getSystemTime());
		Integer trackId = erpFunTrack.getTrackId();

		Integer otherSaleLeaseCaseType = null;
		List<Integer> photoIdList = new ArrayList<Integer>();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			otherSaleLeaseCaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			otherSaleLeaseCaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		if (StringUtils.isNotBlank(photoIds)) {
			String[] photoIdArr = photoIds.split(",");
			for (String photoIdStr : photoIdArr) {
				Integer photoId = StringUtil.parseInteger(photoIdStr, 0);
				if (photoId > 0) {
					photoIdList.add(photoId);
				}
			}
			if (!photoIdList.isEmpty()) {
				ErpFunPhotoExample example = new ErpFunPhotoExample();
				example.setShardCityId(erpFunTrack.getShardCityId());
				example.createCriteria().andPhotoIdIn(photoIdList);
				ErpFunPhoto record = new ErpFunPhoto();
				record.setTrackId(trackId);
				erpFunPhotoMapper.updateByExampleSelective(record, example);
			} else {
				ErpFunPhotoExample example = new ErpFunPhotoExample();
				example.setShardCityId(erpFunTrack.getShardCityId());
				example.createCriteria().andTrackIdEqualTo(erpFunTrack.getTrackId());
				List<ErpFunPhoto> photoList = erpFunPhotoMapper.selectByExample(example);
				if (!photoList.isEmpty()) {
					photoIdList = photoList.stream().collect(Collectors.mapping(ErpFunPhoto::getPhotoId, Collectors.toList()));
				}
			}
			// 修改房勘图片查询判断逻辑
			if (photoIdList != null && photoIdList.size() > 0) {
				int houseInPhotoCountNow = 0;// 当前房源上室内图片的数量有多少
				int houseLayoutCountNow = 0;// 当前房源上室内图片的数量有多少
				Map<String, Object> photoCountMap = erpFunPhotoMapper.getPhotoTypeCount(erpFunTrack.getShardCityId(),
						erpFunTrack.getCompId(), erpFunTrack.getCaseType(), erpFunTrack.getCaseId(),
						otherSaleLeaseCaseType, otherSaleLeaseId);
				if (photoCountMap != null) {
					houseInPhotoCountNow = StringUtil.parseInteger(photoCountMap.get("ATTR_0"), 0);// 当前房源上室内图片的数量有多少
					houseLayoutCountNow = StringUtil.parseInteger(photoCountMap.get("ATTR_1"), 0);// 当前房源上室内图片的数量有多少
				}
				ErpFunPhotoExample example = new ErpFunPhotoExample();
				example.setShardCityId(erpFunTrack.getShardCityId());
				example.createCriteria().andPhotoIdIn(photoIdList);
				example.setOrderByClause("PHOTO_ID asc");
				List<ErpFunPhoto> photoList = erpFunPhotoMapper.selectByExample(example);
				Map<Integer, List<ErpFunPhoto>> photoListMap = photoList.stream().collect(Collectors.groupingBy(photo -> photo.getPhotoType().intValue()));
				List<ErpFunPhoto> houseInPhotoList = photoListMap.get(0);
				List<ErpFunPhoto> houseLayoutPhotoList = photoListMap.get(1);
				if (houseInPhotoCountNow < 12 || houseLayoutCountNow < 3) {
					List<Integer> needUpdateIdList = new ArrayList<>();
					String topPhotoUrl = null;
					Integer topPhotoId = null;
					// 当前户型图少于三张而且房勘图中有户型图
					if (houseLayoutCountNow < 3 && houseLayoutPhotoList != null && houseLayoutPhotoList.size() > 0) {
						int needLayoutCounts = 3 - houseLayoutCountNow;
						// 如果需要的数量大于总数
						if (needLayoutCounts >= houseLayoutPhotoList.size()) {
							needLayoutCounts = houseLayoutPhotoList.size();
						}
						topPhotoUrl = houseLayoutPhotoList.get(0).getPhotoAddr();
						topPhotoId = houseLayoutPhotoList.get(0).getPhotoId();
						for (int i = 0; i < needLayoutCounts; i++) {
							needUpdateIdList.add(houseLayoutPhotoList.get(i).getPhotoId());
						}
					}
					// 判断室内图数量不能超过12张
					if (houseInPhotoCountNow < 12 && houseInPhotoList != null && houseInPhotoList.size() >= 0) {
						int needHouseInCounts = 12 - houseInPhotoCountNow;
						if (needHouseInCounts >= houseInPhotoList.size()) {
							needHouseInCounts = houseInPhotoList.size();
						}
						topPhotoUrl = houseInPhotoList.get(0).getPhotoAddr();
						topPhotoId = houseInPhotoList.get(0).getPhotoId();
						for (int i = 0; i < needHouseInCounts; i++) {
							needUpdateIdList.add(houseInPhotoList.get(i).getPhotoId());
						}
					}
					if (needUpdateIdList.size() > 0) {
//						Collections.sort(needUpdateIdList);// 这里排序有啥用
						ErpFunPhotoExample photoExample = new ErpFunPhotoExample();
						photoExample.setShardCityId(erpFunTrack.getShardCityId());
						photoExample.createCriteria().andPhotoIdIn(needUpdateIdList);
						ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
						erpFunPhoto.setTransmitFlag((byte)0);// 改为有效
						erpFunPhotoMapper.updateByExampleSelective(erpFunPhoto, photoExample);
						boolean photoFlag = false;
						// 修改首图和图片张数
						if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
							ErpFunSale erpFunSale = new ErpFunSale();
							erpFunSale.setShardCityId(erpFunTrack.getShardCityId());
							erpFunSale.setSaleId(erpFunTrack.getCaseId());
							ErpFunSale funSalePO = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
							Byte saleMap = funSalePO.getSaleMap();
							saleMap = (saleMap == null) ? (byte)0 : saleMap;
							erpFunSale.setSaleMap((byte) (saleMap.intValue() + needUpdateIdList.size()));
							if (saleMap == 0 && topPhotoUrl != null) {
								photoFlag = true;
								erpFunSale.setThumbpicVer(dateTimeNow);
								erpFunSale.setThumbUrl(topPhotoUrl);
							}
							erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
						} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
							ErpFunLease erpFunLease = new ErpFunLease();
							erpFunLease.setShardCityId(erpFunTrack.getShardCityId());
							erpFunLease.setLeaseId(erpFunTrack.getCaseId());
							ErpFunLease funLeasePO = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
							Integer leaseMap = funLeasePO.getLeaseMap();
							leaseMap = (leaseMap == null) ? 0 : leaseMap;

							erpFunLease.setLeaseMap(leaseMap + needUpdateIdList.size());
							if (leaseMap == 0 && topPhotoUrl != null) {
								photoFlag = true;
								erpFunLease.setThumbpicVer(dateTimeNow);
								erpFunLease.setThumbUrl(topPhotoUrl);
							}
							erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
						}
						// 修改首图和顺序
						if (photoFlag) {
							erpFunPhotoMapper.updateHousePhotoSeq(erpFunTrack.getShardCityId(), topPhotoId, needUpdateIdList);
						}
						//写跟进
						this.writeTrackByUploadPhoto(erpFunTrack.getShardCityId(), erpFunTrack.getCompId(), erpFunTrack.getCaseId(), erpFunTrack.getCaseType(), erpFunTrack.getCaseNo(), caseStatus, currUserName, caseDeptId, caseUserId, creatorUserId, creatorDeptId);
					}
				}
			}
		}
		//判断来源是否是手机端，如果是手机端判断有没有视频，有没有首图，生成缩略图，最后判断vr，vr的逻辑和图片一样
		Integer vrCount = null;
		String houseThumbUrl = null;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(erpFunTrack.getShardCityId(), erpFunTrack.getCaseId());
			vrCount = erpFunSale.getPanoramaMap();
			houseThumbUrl = erpFunSale.getThumbUrl();
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(erpFunTrack.getShardCityId(), erpFunTrack.getCaseId());
			vrCount = erpFunLease.getPanoramaMap();
			houseThumbUrl = erpFunLease.getThumbUrl();
		}
		if (StringUtils.isNotBlank(videoIds)) {
			List<String> videoUrlListTmp = Arrays.asList(videoIds.split(","));
			List<Integer> videoUrlList = videoUrlListTmp.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
			ErpFunVideoExample example = new ErpFunVideoExample();
			example.setShardCityId(erpFunTrack.getShardCityId());
			example.createCriteria().andVideoIdIn(videoUrlList);
			List<ErpFunVideo> videoList = erpFunVideoMapper.selectByExample(example);
			if (!videoList.isEmpty()) {
				ErpFunVideo erpFunVideo = videoList.get(0);
				erpFunVideo.setShardCityId(erpFunTrack.getShardCityId());
				erpFunVideo.setVideoStatus(0);
				erpFunVideo.setTrackId(trackId);
				erpFunVideoMapper.updateByPrimaryKeySelective(erpFunVideo);
				String thumbUrl = erpFunVideo.getPhotoAddr();
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					ErpFunSale erpFunSale = new ErpFunSale();
					erpFunSale.setShardCityId(erpFunTrack.getShardCityId());
					erpFunSale.setSaleId(erpFunTrack.getCaseId());
					if (StringUtil.isBlank(houseThumbUrl) && StringUtil.isNotBlank(thumbUrl)) {
						// 查询该视频对应的图地址，生成缩略图
						erpFunSale.setThumbpicVer(dateTimeNow);
						erpFunSale.setThumbUrl(thumbUrl);
					}
					erpFunSale.setVideoNum((byte)1);
					erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					ErpFunLease record = new ErpFunLease();
					record.setShardCityId(erpFunTrack.getShardCityId());
					record.setLeaseId(erpFunTrack.getCaseId());
					if (StringUtil.isBlank(houseThumbUrl) && StringUtil.isNotBlank(thumbUrl)) {
						// 查询该视频对应的图地址，生成缩略图
						record.setThumbpicVer(dateTimeNow);
						record.setThumbUrl(thumbUrl);
					}
					record.setVideoNum(1);
					erpFunLeaseMapper.updateByPrimaryKeySelective(record);
				}
			}
		}
		if(StringUtils.isNotBlank(vrIds)){
			vrCount = (vrCount == null) ? 0 : vrCount;
			List<String> vrUrlListTemp = Arrays.asList(vrIds.split(","));
			List<Integer> vrUrlList = vrUrlListTemp.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
			// 修改跟进ID
			ErpFunPanoramaPhotoExample vrExample = new ErpFunPanoramaPhotoExample();
			vrExample.setShardCityId(erpFunTrack.getShardCityId());
			vrExample.createCriteria().andPhotoIdIn(vrUrlList);
			ErpFunPanoramaPhoto recordUp = new ErpFunPanoramaPhoto();
			recordUp.setTrackId(trackId);
			erpFunPanoramaPhotoMapper.updateByExampleSelective(recordUp, vrExample);
			// 1.首先判断是否有vr
			if (vrCount != null && vrCount <= 15) {
				int needSaleVrCount = 15 - vrCount;
				vrExample = new ErpFunPanoramaPhotoExample();
				vrExample.setShardCityId(erpFunTrack.getShardCityId());
				vrExample.createCriteria().andPhotoIdIn(vrUrlList);
				List<ErpFunPanoramaPhoto> vrPhotoList = erpFunPanoramaPhotoMapper.selectByExample(vrExample);
				if (!vrPhotoList.isEmpty()) {
					if (needSaleVrCount > vrPhotoList.size()) {
						needSaleVrCount = vrPhotoList.size();
					}
					List<Integer> vrPhotoIds = new ArrayList<Integer>();
					for (int i = 0; i < needSaleVrCount; i++) {
						ErpFunPanoramaPhoto funPanoramaPhotoPO = vrPhotoList.get(i);
						vrPhotoIds.add(funPanoramaPhotoPO.getPhotoId());
					}
					if (!vrPhotoIds.isEmpty()) {
						vrExample = new ErpFunPanoramaPhotoExample();
						vrExample.setShardCityId(erpFunTrack.getShardCityId());
						vrExample.createCriteria().andPhotoIdIn(vrPhotoIds);
						ErpFunPanoramaPhoto panoramaPhoto = new ErpFunPanoramaPhoto();
						panoramaPhoto.setPhotoStatus((byte)0);
						erpFunPanoramaPhotoMapper.updateByExampleSelective(panoramaPhoto, vrExample);
						if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
							ErpFunSale erpFunSale = new ErpFunSale();
							erpFunSale.setShardCityId(erpFunTrack.getShardCityId());
							erpFunSale.setSaleId(erpFunTrack.getCaseId());
							erpFunSale.setPanoramaMap(vrCount + needSaleVrCount);
							erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
						} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
							ErpFunLease erpFunLease = new ErpFunLease();
							erpFunLease.setShardCityId(erpFunTrack.getShardCityId());
							erpFunLease.setLeaseId(erpFunTrack.getCaseId());
							erpFunLease.setPanoramaMap(vrCount + needSaleVrCount);
							erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
						}
					}
				}
			}
		}
	}

	/**
	 * 委托跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4Weituo(ErpCreateTrackInfoParam param) {
		Integer caseType = param.getCaseType();
		Byte trackType = param.getTrackType();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 更新房源的委托逻辑
		erpFunTaskService.updateCaseWeituo(param, erpFunTrack);
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
		// 工作量类型
		if (trackType.equals(Const.DIC_TRACK_TYPE_ALONE)) {
			param.setStatisticDetailType(StatisticDetailType.DJWT_COUNT);
		} else if (trackType.equals(Const.DIC_TRACK_TYPE_LIMITED)) {
			param.setStatisticDetailType(StatisticDetailType.XSWT_COUNT);
		} else if (trackType.equals(Const.DIC_TRACK_TYPE_RENT)) {
			param.setStatisticDetailType(StatisticDetailType.BZWT_COUNT);
		} else if (trackType.equals(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT)) {
			param.setStatisticDetailType(StatisticDetailType.PTWT_COUNT);
		}
	}

	/**
	 * 状态变更跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4StatusChange(ErpCreateTrackInfoParam param) {
		Byte status = param.getStatus();
		Integer caseType = param.getCaseType();
		Byte trackType = param.getTrackType();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		param.setStatisticDetailType(StatisticDetailType.ZTBG_COUNT);

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 自动审核成功直接修改状态
		erpFunTaskService.updateCaseStatus(param, erpFunTrack);
		// 如果是外成交跟进则需要创建外成交记录,目前只有企业版具备这个功能
		if (Const.DIC_HOUSE_STATUS_DEAL.equals(status) && Const.DIC_COMP_TYPE_1.equals(param.getCompType())) {
			erpFunOutdealService.createOutDealInfo(param);
		}
		if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
				|| Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
			// 工作量类型是成交
			param.setStatisticDetailType(StatisticDetailType.CJ_COUNT);
		}
		// 当为成交跟进并且数据是出租或者求租时，写租期到期时间
		if ((Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)
				|| Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType))
				&& (Const.DIC_HOUSE_STATUS_DEAL.equals(status)
					|| Const.DIC_HOUSE_STATUS_INNERDEAL.equals(status))) {
			this.updateDuetime(param, param.getTargetTime());// 这个必须在前面执行
			erpFunTaskService.createDueWarmTask(param);
		}
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType.intValue(), true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
	}

	/**
	 * 转有效跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4TransAvailable(ErpCreateTrackInfoParam param) {
		Integer oldStatus = param.getOldStatus();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer caseType = param.getCaseType();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);

		//私盘制下出售求购数据可以转有效，1:是 0:否
		boolean isRunModelIsPublicSale = erpSysParaService.getSysRunModelIsPrivate(Const.DIC_CASE_TYPE_SALE_FUN, cityId, compId);
		boolean isRunModelIsPublicBuy = erpSysParaService.getSysRunModelIsPrivate(Const.DIC_CASE_TYPE_BUY_CUST, cityId, compId);
		if ((Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType()) && isRunModelIsPublicSale)
				|| (Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType()) && isRunModelIsPublicBuy)) {
			ErpSysPara erpSysPara = erpSysParaService.getErpSysPara(compId, cityId, "TRANS_DEAL_EFFECT");
			String saleBuyDealTransToAva = "";
			if (erpSysPara != null) {
				saleBuyDealTransToAva = erpSysPara.getParamValue();
			} else {
				saleBuyDealTransToAva = "";
			}
			if ("0".equals(saleBuyDealTransToAva)) {
				// 后台做一次验证，根据参数判断成交数据是否能转有效
				if (Const.DIC_HOUSE_STATUS_DEAL.equals(oldStatus)
						|| Const.DIC_HOUSE_STATUS_INNERDEAL.equals(oldStatus)) {
					throw new ConfirmException("私盘制下出售或者求购的成交信息不允许直接转有效！");
				}
			}
		}
		erpFunTaskService.updateCaseStatus(param, erpFunTrack);
		// 审核之后的查房源信息，给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
		param.setStatisticDetailType(StatisticDetailType.ZYX_COUNT);
	}

	/**
	 * 转私盘跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4TransPrivate(ErpCreateTrackInfoParam param, Map<String, Object> resultMap) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer caseType = param.getCaseType();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();

		// 验证用户抢盘数据的范围 前端已经验证为保证数据安全服务器端再验证一次
		if (!erpUserOpersService.userGetPublicInfoCheckRange(cityId, compId,createAuditUser.getUserId(), param.getCaseDeptId(),
				param.getCaseRegId(), param.getCaseAreaId(), caseType, param.getAreaFlag(), createAuditUser.getAreaId(),
				createAuditUser.getRegId(), createAuditUser.getDeptId())) {
			throw new ConfirmException("该抢盘信息已超出公司允许的查看范围，无法转私盘，请检查公司系统参数！");
		}
		String publicMsg = this.getPublicCaseCount(caseType, cityId, compId, createAuditUser.getUserId());

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);

		this.updateInfoPlateType(param);
		param.setTrackId(erpFunTrack.getTrackId());
		resultMap.put("fromPublic", 1);// 是否成功将抢盘数据转为私盘数据
		resultMap.put("publicMsg", publicMsg);
		param.setStatisticDetailType(StatisticDetailType.ZP_COUNT);
	}

	/**
	 * 转售跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrackTransSale(ErpCreateTrackInfoParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer caseId = param.getCaseId();
		Byte trackType = param.getTrackType();
		ErpFunUsers erpFunUsers = param.getCreateAuditUser();
		ErpFunDepts erpFunDepts = param.getCreateAuditDept();
		//源对象
		ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
		// 判断是否是对应的房源1：如果有，直接同步状态 2：没有对应房源，创建一条房源
		ErpFunSale erpFunSale = new ErpFunSale();
		erpFunSale.setShardCityId(param.getCityId());
		Integer saleLeaseId = erpFunLease.getSaleLeaseId();
		// 将出售数据插入到数据出
		Integer oldCaseId = erpFunLease.getLeaseId();
		if (null != saleLeaseId) {
			judgeRepeat(param, erpFunSale, erpFunLease);
			erpFunSale.setSaleId(saleLeaseId);
			erpFunSale.setSaleStatus(new Byte("1"));
			erpFunSale.setIsSaleLease(new Byte("1"));
			erpFunSale.setUpdateTime(new Date());
			erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
		} else {
			try {
				BeanUtil.diffTwoPoValueCopy(erpFunLease, "lease", erpFunSale, "sale");
			} catch (Exception e) {
				throw new ConfirmException("对象拷贝失败", e);
			}
			Integer[] integers = judgeRepeat(param, erpFunSale, erpFunLease);
			erpFunSale.setSaleAccount(null);
			erpFunSale.setSaleId(null);
			erpFunSale.setSaleNo(null);
			erpFunSale.setCreationTime(new Date());
			erpFunSale.setActionTime(new Date());
			erpFunSale.setTrackTime(new Date());
			erpFunSale.setUpdateTime(new Date());
			erpFunSale.setSaleLowestPrice(param.getLowestPrice());
			erpFunSale.setSaleTotalPrice(param.getTotalPrice());
			String repeatFlag = "0";
			if(integers[0] > 0 && integers[1] > 0) {
				repeatFlag = "3";
			}else if(integers[0] > 0){
				repeatFlag = "2";
			}else if(integers[1] > 0) {
				repeatFlag = "1";
			}
			erpFunSale.setRepeatFlag(new Byte(repeatFlag)); // 地址重复
			erpFunSale.setOrangeFlag(false);
			erpFunSale.setRedFlag(false);
			AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(param.getCityId().shortValue());
			String saleNo = erpFunSaleMapper.generatorSaleNo(param.getCityId(), adminFunCity.getCompNo());
			erpFunSale.setSaleNo(saleNo);
			erpFunSale.setIsSaleLease((byte) 1);
			erpFunSale.setSaleLeaseId(oldCaseId);
			erpFunSale.setCityId(param.getCityId());
			BigDecimal divide = new BigDecimal(0);
			if(null != erpFunSale.getSaleArea() && erpFunSale.getSaleArea().doubleValue() > 0 && null != erpFunSale.getSaleTotalPrice()) {
				BigDecimal saleTotalPrice = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
				divide = saleTotalPrice.divide(erpFunSale.getSaleArea(),2, BigDecimal.ROUND_HALF_UP);
			}
			erpFunSale.setSaleUnitPrice(divide);
			erpFunSale.setCityShareFlag((byte) 0);
			erpFunSaleMapper.insertSelective(erpFunSale);
			// 更新房东联系方式记录表
			List<ErpFunPhone> erpFunPhoneList = erpFunPhoneMapper.getErpFunPhoneList(cityId, compId, oldCaseId, Const.DIC_CASE_TYPE_LEASE_FUN);
			for (ErpFunPhone erpFunPhone : erpFunPhoneList) {
				erpFunPhone.setPhoneId(null);
				erpFunPhone.setCaseId(erpFunLease.getSaleLeaseId());
				erpFunPhone.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
				erpFunPhone.setShardCityId(cityId);
				erpFunPhoneMapper.insertSelective(erpFunPhone);
			}
			// 往核心信息表增加数据
			erpFunCoreInfoService.createOrUpdateCoreInfo(cityId, compId, erpFunSale.getSaleId(), Const.DIC_CASE_TYPE_SALE_FUN, erpFunSale.getBuildId(), erpFunSale.getSaleRoofT(),
					erpFunSale.getSaleUnitT(), erpFunSale.getUnitFloor(), erpFunSale.getSaleNumT(), erpFunSale.getSaleUseage(), erpFunSale.getTradeAddr());
		}
		//地址重复的需要判断，该公司是否可以录入重复数据。--数据判重
//			String result = funLeaseService.detectHouseOrCustRepeat("", Const.DIC_CASE_TYPE_LEASE_FUN,funLeasePOTemp);
//			funLeasePo.setREPEAT_FLAG(result);//设置是否重复标记
		if(param.isPublicModel()){
			erpFunSale.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}else{
			erpFunSale.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		}
		Integer oldCaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		// 重新开始策略参数天数
		erpFunPolicyControlService.resetPrivateDay(cityId, oldCaseId, oldCaseType, true, false, compId, param.getCreateAuditUser().getUserId());

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);

		// 如果来源于滴滴则将滴滴和ERP关联表的记录变为失效
		if(Const.DIC_HOUSE_SOURCE_DIDI_HOUSE.equals(erpFunLease.getLeaseSource())){
			agencyVipErpRelationService.updateStautsByTransData(cityId, oldCaseId, oldCaseType.byteValue());
		}
		ErpFunLease erpFunLeaseUp = new ErpFunLease();
		erpFunLeaseUp.setLeaseId(erpFunLease.getLeaseId());
		erpFunLeaseUp.setIsSaleLease((byte)1);
		erpFunLeaseUp.setSaleLeaseId(erpFunSale.getSaleId());
		erpFunLeaseUp.setShardCityId(param.getCityId());
		erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLeaseUp);
		//这里更新操作来触发一次初始化竞价数据添加的离线作业，因为离线作业只监听了UPDATE的操作。这里仅仅只是触发作业使用。
		ErpFunSale updateFunSale =  new ErpFunSale();
		updateFunSale.setSaleId(erpFunSale.getSaleId());
		updateFunSale.setShardCityId(cityId);
		updateFunSale.setCityId(cityId);
		erpFunSaleMapper.updateByPrimaryKeySelective(updateFunSale);

		erpFunTaskService.cancelAuditTaskForTransHouse(cityId, compId, oldCaseId, oldCaseType, trackType);
		// 更新房源相关人
		String deptName = null;
		if(null != erpFunDepts){
			deptName = erpFunDepts.getDeptName();
		}
		// 更新售维护人、更新登记人
		erpSalePeopleRelativeService.transSaleUpdateRegisterPeopleRelative(cityId, erpFunSale.getSaleId(), erpFunUsers.getUserId(), erpFunUsers.getUserName(), erpFunUsers.getUserMobile(), deptName);
	}
	
	/**
	 * 公盘房源数据移交
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param param
	 */
	private void createTrack4TransData(ErpCreateTrackInfoParam param) {
		String transferParam = "PUBLIC_HOUSE_TRANSFER";
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType()) || Const.DIC_CASE_TYPE_RENT_CUST.equals(param.getCaseType())) {
			transferParam = "PUBLIC_CUST_TRANSFER";
		}
//		String publicHouseTransfer = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), transferParam);
		String publicHouseTransfer = erpSysParaService.getMLSysParamValByUserDefZero(param.getCityId(), param.getCompId(), param.getCreateAuditUser().getUserId(), transferParam);
		if(!"1".equals(publicHouseTransfer)) {
			throw new ConfirmException("公司未开启公盘数据可移交参数");
		}
		if(!Const.DIC_PLATE_TYPE_SHARE.equals(param.getCasePlateType())) {
			throw new ConfirmException("只允许移交公盘数据");
		}
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 出租出售分开处理
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
			erpFunSaleService.createTrack4TransData(param);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
			erpFunLeaseService.createTrack4TransData(param);
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType())) {
			erpFunBuyCustomerService.createTrack4TransData(param);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(param.getCaseType())) {
			erpFunRentCustomerService.createTrack4TransData(param);
		}
	}

	/**
	 * 私盘房源数据移交
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param param
	 */
	private void createTrack4TransPrivateData(ErpCreateTrackInfoParam param) {
		String transferParam = "PRIVATE_HOUSE_TRANSFER";
//		String publicHouseTransfer = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), transferParam);
		String publicHouseTransfer = erpSysParaService.getMLSysParamValByUserDefZero(param.getCityId(), param.getCompId(), param.getCreateAuditUser().getUserId(), transferParam);
		if(!"1".equals(publicHouseTransfer)) {
			throw new ConfirmException("公司未开启私盘数据可移交参数");
		}
		if(!Const.DIC_PLATE_TYPE_PRIVATE.equals(param.getCasePlateType())) {
			throw new ConfirmException("只允许移交私盘数据");
		}
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 出租出售分开处理
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
			erpFunSaleService.createTrack4TransData(param);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
			erpFunLeaseService.createTrack4TransData(param);
		} else {
			throw new ConfirmException("只允许移交私盘房源数据");
		}
	}

	/**
	 * title ：判断租售房源是否重复
	 * athor：lcb
	 * date  : 2017/11/15
	 */
	private Integer[] judgeRepeat(ErpCreateTrackInfoParam param, ErpFunSale erpFunSale, ErpFunLease erpFunLease) {
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();

		CaseInfoDto repeatInfoDto = new CaseInfoDto();
		Integer dealRepaetCaseType;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
			ErpFunSale dealSale = caseInfoDto.getErpFunSale();
			if(null != dealSale.getSaleLeaseId()) {
				erpFunLease.setShardCityId(param.getCityId());
				erpFunLease.setLeaseId(dealSale.getSaleLeaseId());
				erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
				erpFunLease.setLeaseId(null);
			}
			repeatInfoDto.setErpFunLease(erpFunLease);
			dealRepaetCaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		}else {
			ErpFunLease dealLease = caseInfoDto.getErpFunLease();

			if(null != dealLease.getSaleLeaseId()) {
				erpFunSale.setShardCityId(param.getCityId());
				erpFunSale.setSaleId(dealLease.getSaleLeaseId());
				erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
				erpFunSale.setSaleId(null);
			}
			repeatInfoDto.setErpFunSale(erpFunSale);
			dealRepaetCaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		return detectHouseOrCustRepeat(param.getCityId(), param.getCompId(), null, param.getSelfUserId(), param.getSelfDeptId(),
				dealRepaetCaseType, param.getIsPersonalVersion(), repeatInfoDto);
	}

	/**
	 * 转租跟进
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrackTransLease(ErpCreateTrackInfoParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer caseType = param.getCaseType();
		Integer caseId = param.getCaseId();
		Byte trackType = param.getTrackType();
		ErpFunUsers erpFunUsers = param.getCreateAuditUser();
		ErpFunDepts erpFunDepts = param.getCreateAuditDept();
		//源对象
		ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);

		// 判断是否是对应的房源 1：如果有，直接同步状态 2：没有对应房源，创建一条房源
		ErpFunLease erpFunLease = new ErpFunLease();
		erpFunLease.setShardCityId(param.getCityId());
		Integer saleLeaseId = erpFunSale.getSaleLeaseId();
		// 将出售数据插入到数据出
		Integer oldCaseId = erpFunSale.getSaleId();
		if(null != saleLeaseId) {
			erpFunLease.setLeaseId(saleLeaseId);
			erpFunLease.setLeaseStatus(1);
			erpFunLease.setIsSaleLease(new Byte("1"));
			erpFunLease.setUpdateTime(new Date());
			judgeRepeat(param, erpFunSale, erpFunLease);
			erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
		} else {
			try {
				BeanUtil.diffTwoPoValueCopy(erpFunSale, "sale", erpFunLease, "lease");
			} catch (Exception e) {
				throw new ConfirmException("对象拷贝失败", e);
			}
			Integer[] integers = judgeRepeat(param, erpFunSale, erpFunLease);
			erpFunLease.setLeaseAccount(null);
			erpFunLease.setLeaseId(null);
			erpFunLease.setLeaseNo(null);
			erpFunLease.setCreationTime(new Date());
			erpFunLease.setActionTime(new Date());
			erpFunLease.setTrackTime(new Date());
			erpFunLease.setUpdateTime(new Date());
			erpFunLease.setLeaseLowestPrice(param.getLowestPrice());
			Integer priceUnit = Optional.ofNullable(param.getPriceUnit()).orElse(0);
			erpFunLease.setPriceUnit(priceUnit.byteValue());
			erpFunLease.setLeaseTotalPrice(param.getTotalPrice());
			String repeatFlag = "0";
			if(integers[0] > 0 && integers[1] > 0) {
				repeatFlag = "3";
			}else if(integers[0] > 0){
				repeatFlag = "2";
			}else if(integers[1] > 0) {
				repeatFlag = "1";
			}
			erpFunLease.setRepeatFlag(Integer.valueOf(repeatFlag)); // 地址重复
			erpFunLease.setOrangeFlag(false);
			erpFunLease.setRedFlag(false);
			AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(param.getCityId().shortValue());
			String leaseNo = erpFunLeaseMapper.generatorLeaseNo(param.getCityId(), adminFunCity.getCompNo());
			erpFunLease.setLeaseNo(leaseNo);
			erpFunLease.setIsSaleLease((byte)1);
			erpFunLease.setSaleLeaseId(oldCaseId);
			erpFunLease.setCityId(param.getCityId());
			erpFunLease.setCityShareFlag((byte)0);
			erpFunLeaseMapper.insertSelective(erpFunLease);
			//更新房东联系方式记录表
			List<ErpFunPhone> erpFunPhoneList = erpFunPhoneMapper.getErpFunPhoneList(cityId, compId, oldCaseId, Const.DIC_CASE_TYPE_SALE_FUN);
			for(ErpFunPhone erpFunPhone : erpFunPhoneList){
				erpFunPhone.setPhoneId(null);
				erpFunPhone.setCaseId(erpFunSale.getSaleLeaseId());
				erpFunPhone.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
				erpFunPhone.setShardCityId(cityId);
				erpFunPhoneMapper.updateByPrimaryKeySelective(erpFunPhone);
			}
			// 往核心信息表增加数据
			erpFunCoreInfoService.createOrUpdateCoreInfo(cityId, compId, erpFunLease.getLeaseId(), Const.DIC_CASE_TYPE_LEASE_FUN, erpFunLease.getBuildId(), erpFunLease.getLeaseRoofT(),
					erpFunLease.getLeaseUnitT(), erpFunLease.getUnitFloor(), erpFunLease.getLeaseNumT(), erpFunLease.getLeaseUseage(), erpFunLease.getTradeAddr());
		}
		//地址重复的需要判断，该公司是否可以录入重复数据。--数据判重
//			String result = funLeaseService.detectHouseOrCustRepeat("", Const.DIC_CASE_TYPE_LEASE_FUN,funLeasePOTemp);
//			funLeasePo.setREPEAT_FLAG(result);//设置是否重复标记
		if(param.isPublicModel()){
			erpFunLease.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}else{
			erpFunLease.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		}
		Integer oldCaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		// 重新开始策略参数天数
		erpFunPolicyControlService.resetPrivateDay(cityId, oldCaseId, oldCaseType.intValue(), true, false, compId, param.getCreateAuditUser().getUserId());

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);

		// 如果来源于滴滴则将滴滴和ERP关联表的记录变为失效
		if (Const.DIC_HOUSE_SOURCE_DIDI_HOUSE.equals(erpFunSale.getSaleSource())) {
			agencyVipErpRelationService.updateStautsByTransData(cityId, oldCaseId, oldCaseType.byteValue());
		}
		ErpFunSale erpFunSaleUp= new ErpFunSale();
		erpFunSaleUp.setSaleId(erpFunSale.getSaleId());
		erpFunSaleUp.setIsSaleLease((byte)1);
		erpFunSaleUp.setSaleLeaseId(erpFunLease.getLeaseId());
		erpFunSaleUp.setShardCityId(param.getCityId());
		erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSaleUp);

		//这里更新操作来触发一次初始化竞价数据添加的离线作业，因为离线作业只监听了UPDATE的操作。这里仅仅只是触发作业使用。
		ErpFunLease updateFunLease =  new ErpFunLease();
		updateFunLease.setLeaseId(erpFunLease.getLeaseId());
		updateFunLease.setShardCityId(cityId);
		updateFunLease.setCityId(cityId);
		erpFunLeaseMapper.updateByPrimaryKeySelective(updateFunLease);
		erpFunTaskService.cancelAuditTaskForTransHouse(cityId, compId, caseId, caseType, trackType);
		
		// 更新租维护人、租登记人
		String deptName = null;
		if(null != erpFunDepts){
			deptName = erpFunDepts.getDeptName();
		}
		erpLeasePeopleRelativeService.transLeaseUpdateRegisterPeopleRelative(cityId, erpFunLease.getLeaseId(), erpFunUsers.getUserId(), erpFunUsers.getUserName(), erpFunUsers.getUserMobile(), deptName);
	}



	/**
	 * 查看电话跟进
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 * @param resultMap "result"={limit=当天查看条数达到上限，pass=通过}
	 * @throws Exception
	 */
	private void createTrack4ViewPhone(ErpCreateTrackInfoParam param, Map<String, Object> resultMap) {
		Integer cityId = param.getCityId();
		Integer isMobileApi = Optional.ofNullable(param.getIsMobileApi()).orElse(0);
		Integer caseUserId = param.getCaseUserId();
		Integer caseId = param.getCaseId();
		Integer selfDeptId = param.getSelfDeptId();
		Integer selfArchiveId = param.getSelfArchiveId();
		Integer selfUserId = param.getSelfUserId();
		Integer caseType = param.getCaseType();
		Integer compId = param.getCompId();
		Integer trackFromType = param.getTrackFromType();
		Integer caseAreaId = param.getCaseAreaId();// 房源所属人大区ID
		Integer caseRegId = param.getCaseRegId();// 房源所属人片区ID
		Integer caseGrId = param.getCaseGrId();// 房源所属人分组ID
		String userPosition = param.getUserPosition();
		Byte oldStatus = param.getOldStatus().byteValue();
		Integer caseDeptId = param.getCaseDeptId();
		Integer casePlateType = param.getCasePlateType();
		boolean isGeneralManager = param.getIsGeneralManager();
		Integer saleLeaseId = param.getSaleLeaseId();
		Integer viewUserId = param.getCreateAuditUser().getUserId();
		Integer viewGrId = param.getCreateAuditUser().getGrId();
		Integer viewDeptId = param.getCreateAuditUser().getDeptId();
		Integer viewRegId = param.getCreateAuditUser().getRegId();
		Integer viewAreaId = param.getCreateAuditUser().getAreaId();
		String userName = param.getCreateAuditUser().getUserName();
		String caseNo = param.getCaseNo();
		Byte trackType = param.getTrackType();
		String pcname = param.getPcname();
		String createCurrUserName = param.getCreateCurrUserName();
		Byte caseUseage = StringUtil.parseByte(param.getCaseUseage());

		// 审核通过之后写一条跟进，查看记录在下次查看的时候写
		if(trackFromType == 3 || trackFromType == 4) {
			ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
			erpFunTrackMapper.insertSelective(erpFunTrack);
			return;
		}
		Byte caseLevel1 = param.getCaseLevel();
		Byte caseLevel2 = 0;
		Integer casePlateType1 = param.getCasePlateType();
		Integer casePlateType2 = 0;

		// 租售房源的信息
		if(saleLeaseId != null) {
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, saleLeaseId);
				if(erpFunLease != null) {
					caseLevel2 = erpFunLease.getLeaseLevel();
					casePlateType2 = erpFunLease.getPlateType().intValue();
				}
			} else {
				ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, saleLeaseId);
				if(erpFunSale != null) {
					caseLevel2 = erpFunSale.getSaleLevel();
					casePlateType2 = erpFunSale.getPlateType().intValue();
				}
			}
		}
		Byte viewStatus = Const.DIC_VIEW_STATUS_AVAILABLE;
		if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {
			viewStatus = Const.DIC_VIEW_STATUS_WRITEOFF;
		}
		if (!viewUserId.equals(param.getCaseUserId())) {
			if (Const.DIC_HOUSE_LEVEL_PASSWORD.equals(caseLevel1)
					|| Const.DIC_HOUSE_LEVEL_PASSWORD.equals(caseLevel2)) {
				throw new ConfirmException("信息为\"加密\"时，只有本人才能查看核心信息！");
			}
			if (Const.DIC_PLATE_TYPE_PRIVATE.equals(casePlateType1)
					|| Const.DIC_PLATE_TYPE_PRIVATE.equals(casePlateType2)) {
				String operId = null;
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					operId = "QUERY_OTHER_SALE_PHONE";
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					operId = "QUERY_OTHER_LEASE_PHONE";
				} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
					operId = "QUERY_OTHER_BUY_PHONE";
				} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
					operId = "QUERY_OTHER_RENT_PHONE";
				}
				boolean queryOtherPhone = erpUserOpersService.judgePermission(cityId, viewUserId, operId);
				if (!queryOtherPhone) {
					throw new ConfirmException("对不起，你没有权限查看该信息");
				}
			}
		}
		Map<String, Object> viewCountMap = erpFunViewLogService.detectViewLog(cityId, viewUserId, caseUserId, caseId,
				caseType, saleLeaseId, isGeneralManager, compId, viewDeptId, caseUserId, caseNo,
				casePlateType.byteValue(), caseDeptId, pcname, oldStatus, createCurrUserName, caseDeptId,
				trackFromType, selfUserId, param.getTrackContent(), isMobileApi);
		int viewCount = (int) viewCountMap.get("viewCount");

		Byte caseStatus = null;
		// 判断封盘预定
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(erpFunSale != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(erpFunSale.getSaleStatus()+"") || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(erpFunSale.getSaleStatus()+""))) {
				viewCount = 0;
				caseStatus = erpFunSale.getSaleStatus();
			}
		} else {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(erpFunLease != null && (Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(erpFunLease.getLeaseStatus()+"") || Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(erpFunLease.getLeaseStatus()+""))) {
				viewCount = 0;
				caseStatus = erpFunLease.getLeaseStatus().byteValue();
			}
		}

		boolean isAddWorkCount = (boolean) viewCountMap.get("isWorkAddCount");
		resultMap.put("count", viewCount);
		if (viewCount > 0) {
			resultMap.put("result", "pass");
			if (isAddWorkCount) {
				param.setTrackId(StringUtil.parseInteger(viewCountMap.get("trackId")));
				param.setStatisticDetailType(StatisticDetailType.CKDH_COUNT);
			}
			return;
		}
		boolean isPublicModel = erpSysParaService.getSysRunModelIsPublic(caseType, cityId, compId);
		boolean publicNotSpecial = isPublicModel && !Const.DIC_HOUSE_STATUS_SPECIAL.equals(oldStatus)
				&& !Const.DIC_HOUSE_STATUS_SCHEDULE.equals(oldStatus);
		// 不需要判断是否自动审核的
		//1、当前用户查看自己的数据，2、公盘制模式并且不是封盘和预订状态，3、不是公盘制模式但是该房源是公盘的，4、已注销数据
		if (viewUserId.equals(caseUserId)// 当前用户查看自己的数据
				|| publicNotSpecial// 公盘制模式并且不是封盘和预订状态
				|| (!isPublicModel && Const.DIC_PLATE_TYPE_SHARE.equals(casePlateType))// 不是公盘制模式但是该房源是公盘的
				|| Const.DIC_HOUSE_STATUS_WRITEOFF.equals(oldStatus)) {//已注销数据
			// 总经理查看自己的不受上限限制
			boolean isGeneralManagerAndSelf = isGeneralManager && viewUserId.equals(caseUserId);
			int viewLimited = 0;
			if (!isGeneralManagerAndSelf) {
				viewLimited = this.detectLimited(cityId, compId, caseType, casePlateType, caseDeptId, selfDeptId,
						viewUserId, userPosition, !isPublicModel, userName, caseId, caseNo, isMobileApi);
				if (!Const.DIC_HOUSE_STATUS_WRITEOFF.equals(oldStatus) && viewLimited <= 0) {
					throw new ConfirmException("对不起，你今天的查看条数已达到上限！");
				}
			}
			ErpFunViewLog erpFunViewLog = erpFunViewLogService.createViewLog(cityId, compId, viewDeptId, viewUserId,
					caseUserId, caseId, caseType.byteValue(), caseNo, casePlateType.byteValue(), caseDeptId, pcname,
					viewStatus, isMobileApi);
			// 当前剩余查看条数-1等于0，则是最后一条可查看的了，写通知
			if(viewLimited - 1 == 0) {
				TaskQueueThread.sendMessage(cityId, compId, caseType, casePlateType, userName, caseId, caseNo, caseDeptId,
						selfDeptId, selfUserId);
			}
			// 注销房客源在写查看日志的时候将VIEW_STATUS改为注销标记，否则都为有效标记
			// 私盘下的公盘数据、公盘制、公房、公客或注销的数据需要写跟进
			if(Const.DIC_PLATE_TYPE_SHARE.equals(casePlateType) || Const.DIC_HOUSE_STATUS_WRITEOFF.equals(oldStatus)){
				Integer trackId = this.writeTrackByGeneralViewLog(erpFunViewLog, oldStatus, createCurrUserName, caseDeptId, selfUserId, param.getTrackContent());
				param.setTrackId(trackId);
			}
			// 非总经理/非自己的数据/非注销数据才创建提醒记录
			if(!isGeneralManager && !viewUserId.equals(caseUserId)
					&& !Const.DIC_HOUSE_STATUS_WRITEOFF.equals(oldStatus)){
				String writeTrackByView = erpSysParaMapper.getParamValue(cityId, compId, "WRITE_TRACK_BY_VIEW");
				if ("1".equals(writeTrackByView)) {
					Integer msgModule = MsgModule.CUST;
					if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
						msgModule = MsgModule.HOUSE;
					}
					// 如果开了强制写跟进则插入记录，在写跟进的时候删除这条记录，否则会在下次进入房源的时候弹强制写跟进界面
					adminFunUserMessageService.createWriteTrackByViewMessage(cityId, compId, selfArchiveId, caseId, caseType, caseUseage, msgModule);
				}
			}
			isAddWorkCount = true;
			resultMap.put("result", "pass");
		} else if(!viewUserId.equals(caseUserId)) {
			// 查看条数是否达到上限
			int viewLimited = this.detectLimited(cityId, compId, caseType, casePlateType, caseDeptId, selfDeptId, viewUserId,
					userPosition, !isPublicModel, userName, caseId, caseNo, isMobileApi);
			if (viewLimited <= 0) {
				throw new ConfirmException("对不起，你今天的查看条数已达到上限！");
			}
			// 判断是否具备自动审核的条件
			boolean autoExam = false;
			Integer mastAuditType = null;// 必须审核类型，为空则只依据审核配置来
			String dateNow = DateTimeHelper.formatDatetoString(new Date());
			ErpAuditRuntime erpAuditRuntime = erpAuditRuntimeMapper.getLastAuditByCase(cityId, compId, viewUserId,
					caseId, caseType, Const.DIC_TRACK_TYPE_VIEW_PHONE, DateTimeHelper.parseToDate(dateNow));
			// 如果今天有申请过，而且状态是已通过

			if(erpAuditRuntime != null) {
				if(null != caseStatus) {
					if(null != erpAuditRuntime.getCaseStatus() && erpAuditRuntime.getCaseStatus().intValue() == caseStatus.intValue()) {
						autoExam = true;
					}
//					List<ErpFunViewLog> viewLogList = this.checkViewLog(cityId, caseId, caseType, compId, viewUserId);
//					if(viewLogList.size() == 0) {
//						autoExam = true;
//					}else {
//						// 是否有封盘预定的数据
//						List<ErpFunViewLog> collect = viewLogList.stream().filter(val -> (val.getViewCaseStatus() != null && (2 == val.getViewCaseStatus() || 4 == val.getViewCaseStatus()))).collect(Collectors.toList());
//						if(collect.size() > 0) {
//							autoExam = true;
//						}
//					}
				}else {
					autoExam = true;
				}
			} else {
				// 否则判断权限和强制审核
				boolean hasAutoExamView = erpUserOpersService.getViewPhoneExaminLimit(cityId, compId, caseGrId,
						caseDeptId, caseRegId, caseAreaId, caseType, viewAreaId, viewRegId, viewDeptId, viewGrId,
						viewUserId);
				// 查看数据是封盘、预定数据依然需要审核
				if (Const.DIC_HOUSE_STATUS_SPECIAL.equals(oldStatus) || Const.DIC_HOUSE_STATUS_SCHEDULE.equals(oldStatus)) {
					mastAuditType = 6;
				} else {
					autoExam = hasAutoExamView;// 否则按照权限来
				}
				// 查看房源封盘核心信息只需要通过权限控制
				if((Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType))// 房源
						&& Const.DIC_HOUSE_STATUS_SPECIAL.equals(oldStatus)// 封盘数据
						&& hasAutoExamView){
					String viewSpecialCoreinfoByOpers = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, viewUserId,"VIEW_SPECIAL_COREINFO_BY_OPERS");
					if ("1".equals(viewSpecialCoreinfoByOpers)) {// 如果系统参数配置的是：查看房源封盘核心信息只需要通过权限控制
						autoExam = true;
					}
				}
			}
			// 没有权限或需要强制创建审核任务的
			if (!autoExam) {
				Integer auditResult = erpAuditRuntimeService.createAuditRuntimeForTrack(param, mastAuditType);
				if (auditResult == 3 || auditResult == 4) {
					resultMap.put("needAudit", 1);
					resultMap.put("auditId", param.getAuditRuntime().getId());
					resultMap.put("withoutAuditUser", (auditResult == 4) ? 1 : 0);// 4代表没有审核人
					resultMap.put("result", "examin");
					return;
				}
			}
			ErpFunViewLog erpFunViewLog = erpFunViewLogService.createViewLog(cityId, compId, viewDeptId, viewUserId,
					caseUserId, caseId, caseType.byteValue(), caseNo, casePlateType.byteValue(), caseDeptId, pcname,
					Const.DIC_VIEW_STATUS_AVAILABLE, isMobileApi);
			Integer trackId = this.writeTrackByGeneralViewLog(erpFunViewLog, oldStatus, createCurrUserName, caseDeptId, selfUserId, param.getTrackContent());
			// 当前剩余查看条数-1等于0，则是最后一条可查看的了，写通知
			if(viewLimited - 1 == 0) {
				TaskQueueThread.sendMessage(cityId, compId, caseType, casePlateType, userName, caseId, caseNo, caseDeptId,
						selfDeptId, selfUserId);
			}
			isAddWorkCount = true;
			param.setTrackId(trackId);
			resultMap.put("result", "pass");
		}
		//判断是否增加工作量，只有写了跟进才会增加
		if (isAddWorkCount) {
			param.setStatisticDetailType(StatisticDetailType.CKDH_COUNT);
		}
	}

	/**
	 * 核心信息查看，判断之前查看核心信息申请是否还在审核中，请等待审核。
	 * @author 张宏利
	 * @since 2017年11月13日
	 */
	protected void checkApply4Viewexamin(Integer cityId, Integer compId, Integer userId, Integer caseType, Integer caseId) {
		ErpAuditRuntime erpAuditRuntime = erpAuditRuntimeMapper.getHaveAuditByType(cityId, compId, userId, caseId, caseType, Const.DIC_TRACK_TYPE_VIEW_PHONE);
		if (erpAuditRuntime != null) {
			String applyTime = DateTimeHelper.formatDateTimetoString(erpAuditRuntime.getCreationTime(), "yyyy-MM-dd HH:mm");
			throw new ConfirmException("您在" + applyTime + "提交过对该信息的核心内容查看申请，请等待审核！");
		}
	}

	/**
	 * 检查查看信息上限
	 * @author 方李骥
	 * @since 2017年11月01日
	 * @return 剩余可查看条数
	 */
	private int detectLimited(Integer cityId, Integer compId, Integer caseType, Integer casePlateType,
			Integer caseDeptId, Integer selfDeptId, Integer selfUserId, String userPosition, boolean isPrivateModel,
			String userName, Integer caseId, String caseNo, Integer isMobileApi) {
		// 找出当天查看总数
		String allCanViewCount = "";
		String appCanViewCount = "";
		boolean isFromMobile = (1 == isMobileApi);
		// 私盘下的公盘才使用下面的参数进行判断
		ErpFunViewLogExample example = new ErpFunViewLogExample();
		example.setShardCityId(cityId);
		Criteria criteria = example.createCriteria();
		criteria.andTargetTypeEqualTo(caseType.byteValue());
		if (casePlateType.equals(Const.DIC_PLATE_TYPE_SHARE) && isPrivateModel) {
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			// 本店的公盘
			if (caseDeptId.equals(selfDeptId)) {
				if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"SHARE_FUN_CORE_DEPT");
				} else {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"SHARE_CUST_CORE_DEPT");
				}
				criteria.andDeptIdEqualTo(selfDeptId);
			} else {
				if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"SHARE_FUN_CORE_OTHER");
				} else {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId, "SHARE_CUST_CORE_OTHER");
				}
				criteria.andDeptIdNotEqualTo(selfDeptId);
			}
		} else {
			// 非私盘制或者公盘
			if (isPrivateModel) {
				criteria.andPlateTypeNotEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			}
			if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
				allCanViewCount = erpSysParaMapper.getParamValue(cityId, compId, "VIEW_FUN_COUNT_" + userPosition);
				if (StringUtils.isBlank(allCanViewCount)) {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId, "VIEW_FUN_COUNT");
				}
				if(isFromMobile) {
					appCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"APP_VIEW_FUN_NUM_" + userPosition);
					if (StringUtils.isBlank(appCanViewCount)) {
						appCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"VIEW_FUN_COUNT_APP");
					}
				}
			} else if (caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST) || caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST)) {
				allCanViewCount = erpSysParaMapper.getParamValue(cityId, compId, "VIEW_CUST_COUNT_" + userPosition);
				if (StringUtils.isBlank(allCanViewCount)) {
					allCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"VIEW_CUST_COUNT");
				}
				if(isFromMobile) {
					appCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"APP_VIEW_CUST_NUM_" + userPosition);
					if(StringUtils.isBlank(appCanViewCount)) {
						appCanViewCount = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, selfUserId,"VIEW_CUST_COUNT_APP");
					}
				}
			}
		}
		Date sysDate = DateTimeHelper.getSystemDate();
		criteria.andViewUserEqualTo(selfUserId);
		criteria.andCompIdEqualTo(compId);
		criteria.andViewTimeGreaterThanOrEqualTo(DateTimeHelper.formatDateTimetoString(sysDate, "yyyy-MM-dd 00:00:00"));
		criteria.andViewTimeLessThanOrEqualTo(DateTimeHelper.formatDateTimetoString(sysDate, "yyyy-MM-dd 23:59:59"));
		criteria.andViewStatusEqualTo(Const.DIC_VIEW_STATUS_AVAILABLE);
		int nowViewCount = erpFunViewLogMapper.countByExample(example);
		int selfCount = StringUtil.parseInteger(allCanViewCount, 0);
		if (selfCount > nowViewCount) {
			return selfCount - nowViewCount;
		}
		// 手机端来的限制手机端查看条数
		if (isFromMobile) {
			// 手机端查看条数排除自己的数据
			criteria.andOwnerIdNotEqualTo(selfUserId);
			nowViewCount = erpFunViewLogMapper.countByExample(example);
			selfCount = StringUtil.parseInteger(appCanViewCount, 0);
			if (selfCount > nowViewCount) {
				return selfCount - nowViewCount;
			}
		}
		return 0;
	}
	
	/**
	 * 房源提交钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	private void createTrack4SubmitKey(ErpCreateTrackInfoParam param) {
		// 没有收到钥匙跟进内容不一样
		boolean isKeyTrack = (param.getKeyDeptId() != null);
		// 营销版和纯精英版通过key判断
		if(param.getTrackFromType() == 1) {
			isKeyTrack = (param.getKey() != null && param.getKey() == 1);
		}
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		// 有钥匙才提交钥匙，否则只写上面的跟进
		if(isKeyTrack) {
			param.setTrackId(erpFunTrack.getTrackId());
			erpFunTaskService.createSubmitKey(param);
			param.setStatisticDetailType(StatisticDetailType.YSTJ_COUNT);
		}
		//钥匙备注处理
		ErpFunKeyRemarkExample deleteExample=new ErpFunKeyRemarkExample();
		deleteExample.setShardCityId(param.getCityId());
		deleteExample.createCriteria().andCaseIdEqualTo(param.getCaseId()).andCaseTypeEqualTo(param.getCaseType());
		erpFunKeyRemarkMapper.deleteByExample(deleteExample);
		ErpFunKeyRemark insertModel=new ErpFunKeyRemark();
		insertModel.setShardCityId(param.getCityId());
		insertModel.setCaseId(param.getCaseId());
		insertModel.setCaseType(param.getCaseType());
		insertModel.setCompId(param.getCompId());
		insertModel.setCreatorUid(param.getSelfUserId());
		insertModel.setCreationTime(new Date());
		String remark = param.getTrackContent().substring( param.getTrackContent().indexOf("\n") + 1,  param.getTrackContent().length());
		insertModel.setRemark(remark);
		erpFunKeyRemarkMapper.insertSelective(insertModel);
	}

	/**
	 * 借用钥匙
	 * @author 张宏利
	 * @since 2017年10月30日
	 * @param param
	 */
	private void createTrack4BorrowKey(ErpCreateTrackInfoParam param) {
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		erpFunTaskService.createTrack4BorrowKey(param, erpFunTrack.getTrackContent());
	}

	/**
	 * 归还提交钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	private void createTrack4ReturnKey(ErpCreateTrackInfoParam param) {
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		erpFunTaskService.createReturnKey(param, erpFunTrack.getTrackContent());
	}

	/**
	 * 注销钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	private void createTrack4DestroyKey(ErpCreateTrackInfoParam param) {
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		//钥匙备注删除
		ErpFunKeyRemarkExample deleteExample=new ErpFunKeyRemarkExample();
		deleteExample.setShardCityId(param.getCityId());
		deleteExample.createCriteria().andCaseIdEqualTo(param.getCaseId()).andCaseTypeEqualTo(param.getCaseType());
		erpFunKeyRemarkMapper.deleteByExample(deleteExample);
		erpFunTaskService.createTrack4DestroyKey(param);
	}

	/**
	 * 修改房源楼盘
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	private void createTrack4ChangeBuild(ErpCreateTrackInfoParam param) {
		Integer cityId = param.getCityId();
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		Integer saleLeaseId = param.getSaleLeaseId();
		Byte isSaleLease = param.getIsSaleLease();
		// 修改之后的楼盘信息
		ErpBuildingInfoDto buildingInfo = erpBuildingInfoMapper.getInfoForChangeBuild(cityId, param.getTargetId());
		if(buildingInfo == null) {
			throw new ConfirmException("该楼盘信息不完整，请联系客服处理");
		}
		param.setNewBuildName(buildingInfo.getBuildName());
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		erpFunTaskService.changeHouseBuild(cityId, caseId, caseType, buildingInfo);
		if(isSaleLease == 1) {
			Integer saleLeaseType = (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) ? Const.DIC_CASE_TYPE_LEASE_FUN : Const.DIC_CASE_TYPE_SALE_FUN;
			erpFunTaskService.changeHouseBuild(cityId, saleLeaseId, saleLeaseType, buildingInfo);
		}
	}

	/**
	 * 普通跟进
	 * @author 张宏利
	 * @since 2017年10月11日cxc
	 * @param param
	 */
	private void createTrack4Common(ErpCreateTrackInfoParam param) {
		Integer caseType = param.getCaseType();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();

		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_19);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		this.updateInfoTrackTime(param);
		// 删除强制写跟进消息
		Integer msgModule = MsgModule.CUST;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			msgModule = MsgModule.HOUSE;
		}
		// 不管开没开参数都删一次，防止关了参数，永远存在一条没删除的
		adminFunUserMessageMapper.deleteMessage(param.getCaseId(), param.getCaseType(), msgModule,
				MsgModuleType.WRITE_TRACK_BY_VIEW, param.getSelfArchiveId());
		// 给房源所属人写推送消息
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITE_TRACK, erpFunTrack.getTrackContent());
		param.setStatisticDetailType(StatisticDetailType.GJ_COUNT);
	}

	/**
	 * 门店版状态变更
	 * @author 张宏利
	 * @since 2017年10月11日
	 * @param param
	 */
	private void createTrack4DeptStatusChange(ErpCreateTrackInfoParam param) {
		Integer plateType = param.getCasePlateType();
		Integer cityId =  param.getCityId();
		Byte trackType = param.getTrackType();
		Byte status = param.getStatus();
		Integer caseType = param.getCaseType();
		Integer caseId = param.getCaseId();
		Integer compId = param.getCompId();
		Integer selfArchiveId = param.getSelfArchiveId();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		param.setStatisticDetailType(StatisticDetailType.ZTBG_COUNT);

		// 注销-成交 -->（内成交、外成交、封盘、预定、暂缓、电话查看）状态的审核任务都要变为失效
		if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType) ||
				Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType) ||
				Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)){
			erpFunTaskService.cancelAuditTaskForWriteoff(cityId, compId, caseId, caseType, trackType);
			erpAdAuditMapper.deleteByCaseId(param.getCityId(), param.getCaseId(), param.getCaseType());
			// 成交、删除 后下架真房源标记
			// 先查出来是真房源才update好像也查不多，直接更新了吧 T…T
			if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				ErpFunSale updateModel = new ErpFunSale();
				updateModel.setSaleId(caseId);
				updateModel.setTrueFlag((byte) 0);
				updateModel.setShardCityId(cityId);
				erpFunSaleMapper.updateByPrimaryKeySelective(updateModel);
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				ErpFunLease updateModel = new ErpFunLease();
				updateModel.setLeaseId(caseId);
				updateModel.setTrueFlag((byte) 0);
				updateModel.setShardCityId(cityId);
				erpFunLeaseMapper.updateByPrimaryKeySelective(updateModel);
			}
		}
		// 组装跟进内容
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		boolean isPrivate = erpSysParaService.getSysRunModelIsPrivate(caseType, param.getCityId(), param.getCompId());
		boolean publicCase = plateType.equals(Const.DIC_PLATE_TYPE_SHARE) && isPrivate;
		if (!publicCase) {
			Byte taskType = null;
			if(Const.DIC_TRACKCLASSIC_1.equals(erpFunTrack.getTrackClassic())){
				taskType = Const.DIC_TASK_TYPE_BUSINESS_TRACKING;
			} else {
				taskType = Const.DIC_TASK_TYPE_TRACK_REMIND;
			}
			String taskSubject = erpFunTrack.getTrackClassic() + " " + param.getTaskSubject();
			this.createCommonWarmTask(taskSubject, erpFunTrack.getTrackContent(), param,taskType);
		}
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		// 自动审核成功直接修改状态
		erpFunTaskService.updateCaseStatus(param, erpFunTrack);
		String trackContent = erpFunTrack.getTrackContent();
		String opTypeStr = "";
		if(Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {
			opTypeStr="删除";
		}else if(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
			opTypeStr="内成交";
		}else if(Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)) {
			opTypeStr="外成交";
		}
		/** 后面erpFunTrack 的caseId,caseType,caseNo 三个字段被污染了 ，请慎用 **/
		// 判断租售房源
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			if(1 == param.getMakeSure().intValue() && null != param.getIsSaleLease() && param.getIsSaleLease().intValue() == 1 && null != param.getSaleLeaseId()) {
				// 查询房源编号
				ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, param.getSaleLeaseId());
				if(null != funLeaseByLeaseId) {
					String saleLeaseTrackContent = param.getCreateCurrUserName() +" 将出售房源"+opTypeStr+"时同时删除此房源";
					erpFunTrack.setTrackContent(saleLeaseTrackContent);
					erpFunTrack.setTrackId(null);
					erpFunTrack.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN.byteValue());
					erpFunTrack.setCaseId(param.getSaleLeaseId());
					erpFunTrack.setCaseNo(funLeaseByLeaseId.getLeaseNo());
					erpFunTrackMapper.insertSelective(erpFunTrack);
				}
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			if(1 == param.getMakeSure().intValue() && null != param.getIsSaleLease() && param.getIsSaleLease().intValue() == 1 && null != param.getSaleLeaseId()) {
				// 查询房源编号
				ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, param.getSaleLeaseId());
				if(null != funSale) {
					String saleLeaseTrackContent = param.getCreateCurrUserName() +" 将出租房源"+opTypeStr+"时同时删除此房源";
					erpFunTrack.setTrackContent(saleLeaseTrackContent);
					erpFunTrack.setTrackId(null);
					erpFunTrack.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN.byteValue());
					erpFunTrack.setCaseId(param.getSaleLeaseId());
					erpFunTrack.setCaseNo(funSale.getSaleNo());
					erpFunTrackMapper.insertSelective(erpFunTrack);
				}
			}
		}

		// 审核成功之后，勾选了数据移交则移交该条数据到申请人名下
		if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)
				|| Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)) {
			// targetType=1来表示勾选了数据移交则移交该条数据到申请人名下
			if(Optional.ofNullable(param.getTargetType()).orElse(0) == 1) {
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					erpFunSaleService.createTrack4TransData(param);
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					erpFunLeaseService.createTrack4TransData(param);
				}
			}
		}
		// 如果是外成交跟进则需要创建外成交记录,目前只有企业版具备这个功能
		if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
				&& Const.DIC_COMP_TYPE_1.equals(param.getCompType())) {
			erpFunOutdealService.createOutDealInfo(param);
		}
		if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
				|| Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
			// 工作量类型是成交
			param.setStatisticDetailType(StatisticDetailType.CJ_COUNT);
			if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				this.updateDuetime(param, param.getTargetTime());// 这个必须在前面执行
				erpFunTaskService.createDueWarmTask(param);
				erpYouBorkerPurchaseService.sendMsgToParticipant(param.getCaseType(), param.getCityId(), status);
			}
			// 成交，给房源所属人写推送消息
			AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
					createAuditUser.getArchiveId(), createAuditUser.getUserName());
			TaskQueueThread.sendMessage(userMessage, MsgModuleType.DEAL_HOUSE_CUST_BY_CONTRACT, trackContent);
			// 推送消息给收藏方
			erpFunCaseFavoriteService.sendMsgToFavoriteUser(cityId, compId, selfArchiveId, caseType, caseId, trackType, param);
		}else if (Const.DIC_HOUSE_STATUS_WRITEOFF.equals(status)) {
			// 注销的工作量
			param.setStatisticDetailType(StatisticDetailType.ZX_COUNT);
			// 注销，给房源所属人写推送消息
			AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, true,
					createAuditUser.getArchiveId(), createAuditUser.getUserName());
			TaskQueueThread.sendMessage(userMessage, MsgModuleType.WRITEOFF_HOUSE_CUST, trackContent);
			// 推送消息给收藏方
			erpFunCaseFavoriteService.sendMsgToFavoriteUser(cityId, compId, selfArchiveId, caseType, caseId, trackType, param);
		}
	}

	// --写跟进方法--结束

	/**
	 * 当跟进人不是本人或者他店的，要为信息所属人写一条跟进提醒任务
	 * @author 张宏利
	 * @since 2017年10月11日
	 */
	public void writeWarmTaskForInfoOner(ErpCreateTrackInfoParam param) {
		Integer createAuditUid = param.getCreateAuditUser().getUserId();
		Integer caseUserId = param.getCaseUserId();
		// 是自己的房源则不用提醒
		if (caseUserId.equals(createAuditUid)) {
			return;
		}
		Integer caseType = param.getCaseType();
		Integer deptId = param.getCaseDeptId();
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		String createCurrUserName = param.getCreateCurrUserName();
		String caseTypeDicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(param.getCityId(), "CASE_TYPE", param.getCaseType().toString());
		String trackTypeDicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(param.getCityId(), "TRACK_TYPE", param.getTrackType().toString());
		if(11 == param.getTrackType().intValue()){
			trackTypeDicCnMsg = "普通";
		} else if(6 == param.getTrackType().intValue() || 7 == param.getTrackType().intValue() 
				|| 19 == param.getTrackType().intValue()|| 9 == param.getTrackType().intValue()){
			trackTypeDicCnMsg += "委托";
		}
		String taskDesc = createCurrUserName + "为你编号为" + param.getCaseNo() + caseTypeDicCnMsg + "完成了" + trackTypeDicCnMsg + "跟进";
		// 获取提醒任务类型
		Object[] taskTypeArr = this.generatorTaskSubjectByTrackType(param.getTrackType());
		ErpFunTask erpFunTask = new ErpFunTask();
		erpFunTask.setCaseId(param.getCaseId());
		erpFunTask.setCaseNo(param.getCaseNo());
		erpFunTask.setCaseType(caseType.byteValue());
		erpFunTask.setTaskSubject(taskTypeArr[1].toString() + " " + taskDesc);
		erpFunTask.setTaskDesc(taskDesc);
		erpFunTask.setCompId(param.getCompId());
		erpFunTask.setDeptId(deptId);
		erpFunTask.setTaskOwner(caseUserId);
		erpFunTask.setTaskType(StringUtil.parseByte(taskTypeArr[0].toString()));
		erpFunTask.setTypeFlag((byte)0);
		erpFunTask.setWarmTime(timeNow);
		erpFunTask.setIsRead(false);
		erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		erpFunTask.setCreatorUid(createAuditUid);
		erpFunTask.setCreationTime(timeNow);
		erpFunTask.setTrackWarm(false);
		erpFunTask.setWarmTime(timeNow);
		erpFunTask.setShardCityId(param.getCityId());
		erpFunTask.setTrackType(param.getTrackType());
		// 判断是否是注销房源
		if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(param.getTrackType())) {
			// 从新编辑提醒内容
			taskDesc = createCurrUserName + " 将您编号为 " + param.getCaseNo() + caseTypeDicCnMsg + " 更改为删除";
			erpFunTask.setTaskSubject(Const.DIC_TASK_TYPE_DELETE_REMIND_STR + " " + taskDesc);
			erpFunTask.setTaskDesc(taskDesc);
			erpFunTask.setTrackId(param.getTrackId());
			erpFunTask.setTrackWarm(true);// 房客源如果注销了需要提醒
			erpFunTask.setTaskType(Const.DIC_TASK_TYPE_DELETE_REMIND);
		} else if (Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(param.getTrackType())) {
			taskDesc = createCurrUserName + " 查看您编号为 " + param.getCaseNo() + caseTypeDicCnMsg + " 的核心信息";
			erpFunTask.setTaskSubject(Const.DIC_TASK_TYPE_CORE_INFORMATION_STR + " " + taskDesc);
			erpFunTask.setTaskDesc(taskDesc);
			erpFunTask.setTaskType(Const.DIC_TASK_TYPE_CORE_INFORMATION);
		}
		erpFunTaskService.insertTask(param.getCityId(), erpFunTask, (byte) 0);
	}

	private Object[] generatorTaskSubjectByTrackType(Byte trackType){
		Byte taskType = null;
		String taskSubject = null;
		if(Const.DIC_TRACK_TYPE_FUNCAN.equals(trackType)){ // 房堪
			taskType = Const.DIC_TASK_TYPE_ROOMEXPLORATION_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_ROOMEXPLORATION_REMIND_STR;
		} else if(Const.DIC_TRACK_TYPE_DAIKAN.equals(trackType)){ // 带看
			taskType = Const.DIC_TASK_TYPE_TAKE_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_TAKE_REMIND_STR;
		} else if(Const.DIC_TRACK_TYPE_JUMP_SHARE.equals(trackType)){ // 公盘
			taskType = Const.DIC_TASK_TYPE_PUBLIC_NOTIFY;
			taskSubject = Const.DIC_TASK_TYPE_PUBLIC_NOTIFY_STR;
		} else if(Const.DIC_TRACK_TYPE_JUMP_PUBLIC.equals(trackType)){ // 抢盘
			taskType = Const.DIC_TASK_TYPE_PLATE_NOTIFY;
			taskSubject = Const.DIC_TASK_TYPE_PLATE_NOTIFY_STR;
		} else if(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType) 
				|| Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)){ // 内、外成交
			taskType = Const.DIC_TASK_TYPE_BARGAIN_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_BARGAIN_REMIND_STR;
		} else if(Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)){ // 注销
			taskType = Const.DIC_TASK_TYPE_DELETE_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_DELETE_REMIND_STR;
		} else if(Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(trackType)){ // 查看电话
			taskType = Const.DIC_TASK_TYPE_CORE_INFORMATION;
			taskSubject = Const.DIC_TASK_TYPE_CORE_INFORMATION_STR;
		} else if(Const.DIC_TRACK_TYPE_CANCEL_WEITUO.equals(trackType)){ // 委托到期
			taskType = Const.DIC_TASK_TYPE_TRUSTOUT_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_TRUSTOUT_REMIND_STR;
		} else if(Const.DIC_TRACK_TYPE_CASE_TRANSFER.equals(trackType) 
				|| Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER.equals(trackType)){ // 数据移交
			taskType = Const.DIC_TASK_TYPE_DATA_TURN;
			taskSubject = Const.DIC_TASK_TYPE_DATA_TURN_STR;
		} else{
			taskType = Const.DIC_TASK_TYPE_TRACK_REMIND;
			taskSubject = Const.DIC_TASK_TYPE_TRACK_REMIND_STR;
		}
		return new Object[]{taskType, taskSubject};
	}
	/**
	 * 专业版不需要写门店名
	 * @author 熊刚
	 * @since 2017年10月12日
	 * @param currUname
	 * @param compType
	 * @param isPersonalVersion
	 * @return
	 */
	@Override
	public String getCurrUserName(String selfDeptName,String currUname,Integer compType,boolean isPersonalVersion) {
		// 不是纯精英版也不是专业版 才写门店名称
		if (!Const.DIC_COMP_TYPE_2.equals(compType) && !isPersonalVersion) {
			currUname = selfDeptName + " " + currUname;
		}
		return currUname;
	}

	/**
	 * 获取是否是本人跟进的数据 或者 公盘数据，需要跟新TRACK_TIME 和 红色 橙色标记
	 * @author 熊刚
	 * @since 2017年10月12日
	 * @return
	 */
	@Override
	public boolean getMustBeWriteTrackInfo(CaseInfoDto caseInfoDto, Integer cityId, Integer compId, Integer caseType, Integer selfUserId){
		//获取跟进前的房源或者客源的信息，用于判断完成跟进。 例如：是否更新TRACK_TIME，要本人跟进自己的数据才更新该字段 注意公盘数据。
		Byte plateType = null;
		Integer userId = null;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			ErpFunSale funSale = caseInfoDto.getErpFunSale();
			userId = funSale.getUserId();
			plateType = funSale.getPlateType();
		}else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			ErpFunLease funLease = caseInfoDto.getErpFunLease();
			userId = funLease.getUserId();
			plateType = funLease.getPlateType();
		}else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			ErpFunBuyCustomer funBuy = caseInfoDto.getErpFunBuyCustomer();
			userId = funBuy.getUserId();
			plateType = funBuy.getPlateType();
		}else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			ErpFunRentCustomer funRent = caseInfoDto.getErpFunRentCustomer();
			userId = funRent.getUserId();
			plateType = funRent.getPlateType();
		}
		boolean trackUserSelf = selfUserId.equals(userId);
		if(trackUserSelf) {
			return true;
		}

		// 是鸿基的模式
		String isOpenTrack = erpSysParaMapper.getParamValue(cityId, compId, "IS_OPEN_TRACK");
		boolean isHongjiModel = Const.DIC_IS_HONGJI_COMP_MODEL.equals(isOpenTrack);
		boolean runModelIsPublic = erpSysParaService.getSysRunModelIsPublic(caseType, cityId, compId);
		boolean plateTypeShare = plateType != null && Const.DIC_PLATE_TYPE_SHARE.equals(plateType.intValue());
		// 是否跟新跟进橙色标记、红色标记和跟进时间
		return (trackUserSelf || runModelIsPublic || plateTypeShare || isHongjiModel);
	}

	/**
	 * 设置公用信息数据
	 * @author 熊刚
	 * @since 2017年10月27日
	 * @param param
	 */
	private void generatorTrackByParam(ErpCreateTrackInfoParam param, ErpFunTrack erpFunTrack, String trackClassic) {
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss.S");
		Integer caseType = Optional.ofNullable(param.getCaseType()).orElse(0);
		erpFunTrack.setShardCityId(param.getCityId());
		erpFunTrack.setCompId(param.getCompId());
		erpFunTrack.setCaseId(Optional.ofNullable(param.getCaseId()).orElse(0));
		erpFunTrack.setCaseType(caseType.byteValue());
		erpFunTrack.setCaseNo(param.getCaseNo());
		erpFunTrack.setCaseDeptId(param.getCaseDeptId());
		erpFunTrack.setCaseStatus(param.getStatus());
		erpFunTrack.setCaseUserId(param.getCaseUserId());
		erpFunTrack.setCreationTime(timeNow);
		erpFunTrack.setCreatorUid(param.getCreateAuditUser().getUserId());// 创建人就是创建审核的人，而不是审核人
		erpFunTrack.setDeptId(param.getCreateAuditUser().getDeptId());// 创建人就是创建门店的人，而不是门店人

		if(!param.getIsPersonalVersion()) {
			if(null != param.getCreateAuditUser().getDeptId()) {
				ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getCreateAuditUser().getDeptId());
				erpFunTrack.setDeptName(byDeptId.getDeptCname());
			}
			Integer grId = param.getCreateAuditUser().getGrId();
			erpFunTrack.setGrId(grId);// 分组
			if(null != grId && grId > 0) {
				ErpFunDeptsgroup dataByGrId = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), grId);
				erpFunTrack.setGrName(dataByGrId.getGrName());
			}
		}

		erpFunTrack.setIsUserTrack(1);
		erpFunTrack.setTrackType(Optional.ofNullable(param.getTrackType()).orElse((byte) 0));
		erpFunTrack.setTrackContent(param.getTrackContent());
		erpFunTrack.setTrackNo(param.getTrackNo());
		erpFunTrack.setTargetId(param.getTargetId());
		erpFunTrack.setTargetNo(param.getTargetNo());
		if(param.getTargetType() != null) {
			erpFunTrack.setTargetType(param.getTargetType().byteValue());
		}
		erpFunTrack.setUseage(StringUtil.parseByte(param.getCaseUseage()));
		erpFunTrack.setExaminTime(timeNow);
		erpFunTrack.setTargetFlag(true);// 直接为审核成功
		erpFunTrack.setTrackClassic(trackClassic);
		Byte status = param.getStatus();
		Date targetTime = param.getTargetTime();
		if (Const.DIC_HOUSE_STATUS_SPECIAL.equals(status)) {// 变成封盘
			erpFunTrack.setSpecialEndTime(targetTime);
		} else if (Const.DIC_HOUSE_STATUS_SCHEDULE.equals(status)) {// 变成预定
			erpFunTrack.setScheduleEndTime(targetTime);
		} else if (Const.DIC_HOUSE_STATUS_RESPITE.equals(status)) {// 变成暂缓
			erpFunTrack.setRespiteEndTime(targetTime);
		}
		if (Const.DIC_TRACK_TYPE_LIMITED.equals(param.getTrackType())// 限时-6
				|| Const.DIC_TRACK_TYPE_ALONE.equals(param.getTrackType())// 独家-7
				|| Const.DIC_TRACK_TYPE_RENT.equals(param.getTrackType())// 包租-9
				|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(param.getTrackType())) {// 普通委托-19
			erpFunTrack.setEntrustEndTime(targetTime);
		}
	}

	/**
	 * 获取加密和推荐条数，提出来，都可以调用
	 * @author 熊刚
	 * @since 2017年10月13日
	 * @param cityId
	 * @param caseType
	 * @return[推荐条数，加密条数]
	 * @throws Exception
	 */
	@Override
	public Integer[] getSpecialCaseCount(Integer cityId, Integer caseId, Integer caseType, Integer infoOwnerUserId, Integer compId, Integer deptId){
		Integer[] result = new Integer[] { 0, 0 };
		Map<String, Integer> returnMap = new HashMap<>();
		//加上caseId这个条件，排除该房客源数据已经是加密或申请
		if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)) {
			returnMap = erpFunSaleMapper.getLevelCounts(cityId, caseId, infoOwnerUserId, compId, deptId);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
			returnMap = erpFunLeaseMapper.getLevelCounts(cityId, caseId, infoOwnerUserId, compId, deptId);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST)) {
			returnMap = erpFunBuyCustomerMapper.getLevelCounts(cityId, caseId, infoOwnerUserId, compId, deptId);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST)) {
			returnMap = erpFunRentCustomerMapper.getLevelCounts(cityId, caseId, infoOwnerUserId, compId, deptId);
		}
		if(returnMap!=null){
			result[0] = returnMap.get("commendLevel");
			result[1] = returnMap.get("passwordLevel");
		}
		return result;
	}

	/**
	 * 创建提醒任务只为跟进功能调用
	 * @author 熊刚
	 * @since 2017年10月16日
	 * @throws Exception
	 */
	private void createCommonWarmTask(String taskSubject, String trackContent, ErpCreateTrackInfoParam param, Byte taskType) {
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		ErpFunTask erpFunTask = new ErpFunTask();
		erpFunTask.setCaseId(param.getCaseId());
		erpFunTask.setCaseNo(param.getCaseNo());
		erpFunTask.setCaseType(param.getCaseType().byteValue());
		erpFunTask.setTrackId(param.getTrackId());
		erpFunTask.setTrackType(param.getTrackType());
		erpFunTask.setTaskSubject(taskSubject);
		erpFunTask.setTaskDesc(trackContent);
		erpFunTask.setTaskOwner(createAuditUser.getUserId());
		erpFunTask.setDeptId(createAuditUser.getDeptId());
		erpFunTask.setCompId(createAuditUser.getCompId());
		erpFunTask.setTaskType(taskType);
		erpFunTask.setTypeFlag((byte)0);
		erpFunTask.setIsRead(false);
		erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		erpFunTask.setCreatorUid(param.getCreateAuditUser().getUserId());
		erpFunTask.setCreationTime(DateUtil.DateToString(param.getWarmTime()));
		erpFunTask.setTrackWarm(false);
		erpFunTask.setWarmTime(timeNow);
		erpFunTask.setCreationTime(timeNow);
		erpFunTask.setShardCityId(param.getCityId());
		erpFunTaskService.insertTask(param.getCityId(), erpFunTask, (byte) 0);
	}

	@Override
	public void writeFunTrackForPublish(ErpCreateTrackInfoParam param, Boolean publish, Boolean cooperate) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		String caseNo = param.getCaseNo();
		boolean oldPublish = param.getCasePublish();
		boolean oldCoop = param.getCaseCooperate();

		String content = param.getCreateCurrUserName() + " 对该数据的信息进行了编辑\n跟进内容: ";
		if(publish != null) {
			if (publish && !oldPublish) {
				content += "网络推广: 关闭 >> 开启 \n";
			} else if (!publish && oldPublish) {
				content += "网络推广: 开启 >> 关闭 \n";
			}
		}
		if(cooperate != null) {
			if (cooperate && !oldCoop) {
				content += "合作: 不合作>> 合作  \n";
			} else if (!cooperate && oldCoop) {
				content += "合作: 合作>> 不合作 \n";
			}
		}
		if (content.endsWith("\n")) {
			content = content.substring(0, content.length() - 2);
			Map<String, Integer> resultMap = getUserAndDeptByCaseIdOffCaseType(param.getCityId(), caseType.intValue(), caseId);
			ErpFunTrack erpFunTrack = new ErpFunTrack();
			erpFunTrack.setShardCityId(param.getCityId());
			erpFunTrack.setCaseId(caseId);
			erpFunTrack.setCaseNo(caseNo);
			erpFunTrack.setCaseType(caseType.byteValue());
			erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
			erpFunTrack.setTrackContent(content);
			erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
			erpFunTrack.setCreatorUid(createAuditUser.getUserId());
			erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
			erpFunTrack.setDeptId(createAuditUser.getDeptId());
			erpFunTrack.setCompId(createAuditUser.getCompId());
			erpFunTrack.setCaseUserId(resultMap.get("userId"));
			erpFunTrack.setCaseDeptId(resultMap.get("deptId"));
			erpFunTrack.setTrackWarm(false);
			erpFunTrack.setUseage((byte) 0);
			erpFunTrackMapper.insertSelective(erpFunTrack);
			param.setTrackId(erpFunTrack.getTrackId());
		}
	}

	@Override
	public Map<String, Integer> getUserAndDeptByCaseIdOffCaseType(Integer cityId, Integer caseType, Integer caseId) {
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId, caseId);
			if (erpFunSale != null) {
				resultMap.put("userId", erpFunSale.getUserId());
				resultMap.put("deptId", erpFunSale.getDeptId());
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, caseId);
			if (erpFunLease != null) {
				resultMap.put("userId", erpFunLease.getUserId());
				resultMap.put("deptId", erpFunLease.getDeptId());
			}
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			if (erpFunBuyCustomer != null) {
				resultMap.put("userId", erpFunBuyCustomer.getUserId());
				resultMap.put("deptId", erpFunBuyCustomer.getDeptId());
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			if (erpFunRentCustomer != null) {
				resultMap.put("userId", erpFunRentCustomer.getUserId());
				resultMap.put("deptId", erpFunRentCustomer.getDeptId());
			}
		}
		return resultMap;
	}

	private void updateInfoPlateType(ErpCreateTrackInfoParam param) {
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Integer caseType = param.getCaseType();
		Integer caseId = param.getCaseId();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		paramMap.put("privateUserId", createAuditUser.getUserId());
		paramMap.put("grId", createAuditUser.getGrId());
		paramMap.put("deptId", createAuditUser.getDeptId());
		paramMap.put("regId", createAuditUser.getRegId());
		paramMap.put("areaId", createAuditUser.getAreaId());
		paramMap.put("userId", createAuditUser.getUserId());
		paramMap.put("archiveId", createAuditUser.getArchiveId());
		paramMap.put("plateType", Const.DIC_PLATE_TYPE_PRIVATE);
		paramMap.put("privateTime", DateTimeHelper.formatDateTimetoString(new Date()));

		Integer privateUserId = null;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			privateUserId = caseInfoDto.getErpFunSale().getPrivateUserId();
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			privateUserId = caseInfoDto.getErpFunLease().getPrivateUserId();
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			privateUserId = caseInfoDto.getErpFunBuyCustomer().getPrivateUserId();
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			privateUserId = caseInfoDto.getErpFunRentCustomer().getPrivateUserId();
		}
		Assert.isTrueThrow(createAuditUser.getUserId().equals(privateUserId), "不允许重复抢盘！");
		// 这里查询一次房源数据是否已经再试抢盘数据了，由于前端数据缓存，可能被其他用户已经转为
		paramMap.put("orangeFlag", 0);
		paramMap.put("redFlag", 0);
		paramMap.put("trackTime", nowTime);
		paramMap.put("actionTime", nowTime);
		paramMap.put("updateTime", nowTime);
		// 标记抢为从抢盘转换获得
		paramMap.put("fromPublic", 1);

		int updateCount = 0;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			paramMap.put("saleStatus", Const.DIC_HOUSE_STATUS_AVAILABLE);
			paramMap.put("saleLevel", Const.DIC_HOUSE_LEVEL_COMMON);
			updateCount = erpFunSaleMapper.updateModelData(cityId, paramMap, param.getCaseId(), 1);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			paramMap.put("leaseStatus", Const.DIC_HOUSE_STATUS_AVAILABLE);
			paramMap.put("leaseLevel", Const.DIC_HOUSE_LEVEL_COMMON);
			updateCount = erpFunLeaseMapper.updateModelData(cityId, paramMap, param.getCaseId(), 1);
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			paramMap.put("buyCustStatus", Const.DIC_HOUSE_STATUS_AVAILABLE);
			paramMap.put("buyCustLevel", Const.DIC_HOUSE_LEVEL_COMMON);
			updateCount = erpFunBuyCustomerMapper.updateModelData(cityId, paramMap, param.getCaseId(), 1);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			paramMap.put("rentCustStatus", Const.DIC_HOUSE_STATUS_AVAILABLE);
			paramMap.put("rentCustLevel", Const.DIC_HOUSE_LEVEL_COMMON);
			updateCount = erpFunRentCustomerMapper.updateModelData(cityId, paramMap, param.getCaseId(), 1);
		}
		Assert.isTrueThrow(updateCount == 0, "数据由抢盘转换到私盘时失败！原因：该数据可能已被转为私盘，请检查！");
		// 更新钥匙表DEPT_ID
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKey(cityId, compId, caseId, caseType);
			if (erpFunKey != null) {
				erpFunKey.setDeptId(createAuditUser.getDeptId());
				erpFunKey.setShardCityId(cityId);
				erpFunKeyMapper.updateByPrimaryKeySelective(erpFunKey);
			}
		}
		// 修改电话数据
		ErpFunPhoneExample phoneExample = new ErpFunPhoneExample();
		phoneExample.setShardCityId(cityId);
		phoneExample.createCriteria().andCompIdEqualTo(compId)
		.andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
		ErpFunPhone erpFunPhone = new ErpFunPhone();
		erpFunPhone.setAreaId(createAuditUser.getAreaId());
		erpFunPhone.setRegId(createAuditUser.getRegId());
		erpFunPhone.setGrId(createAuditUser.getGrId());
		erpFunPhone.setDeptId(createAuditUser.getDeptId());
		erpFunPhone.setUserId(createAuditUser.getUserId());
		erpFunPhoneMapper.updateByExampleSelective(erpFunPhone, phoneExample);
		// 修改售维护人
		ErpFunDepts createAuditDept = param.getCreateAuditDept();
		String deptName = null;
		if(null != createAuditDept){
			deptName = createAuditDept.getDeptName();
		}
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			erpSalePeopleRelativeService.privatePlateUpdatePeopleRelative(cityId, caseId, createAuditUser.getUserId(),createAuditUser.getUserName(), createAuditUser.getUserMobile(), deptName);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			erpLeasePeopleRelativeService.privatePlateUpdatePeopleRelative(cityId, caseId, createAuditUser.getUserId(), createAuditUser.getUserName(), createAuditUser.getUserMobile(), deptName);
		}
	}

	/**
	 * 更新出租或者求租数据的租期到期时间.
	 * @author 陈文超
	 */
	private void updateDuetime(ErpCreateTrackInfoParam param, Date dueTime) {
		Integer caseType = param.getCaseType();
		Integer cityId = param.getCityId();
		Integer caseId = param.getCaseId();

		if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			erpFunLease.setShardCityId(cityId);
			erpFunLease.setDueTime(DateUtil.StringToDate(DateTimeHelper.formatDateTimetoString(dueTime, "yyyy-MM-dd")));
			erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			erpFunRentCustomer.setShardCityId(cityId);
			erpFunRentCustomer.setDueTime(DateUtil.StringToDate(DateTimeHelper.formatDateTimetoString(dueTime, "yyyy-MM-dd")));
			erpFunRentCustomerMapper.updateByPrimaryKeySelective(erpFunRentCustomer);
		}
	}

	/**
	 * 修改房客源信息的跟进时间
	 * @author 张宏利
	 * @since 2017年11月4日
	 * @param param
	 */
	private void updateInfoTrackTime(ErpCreateTrackInfoParam param) {
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer createAuditUid = param.getCreateAuditUser().getUserId();

		boolean writeTrackTime4House = erpFunTrackService.getMustBeWriteTrackInfo(caseInfoDto, param.getCityId(), param.getCompId(), param.getCaseType(), createAuditUid);
		if (!writeTrackTime4House) {
			return;
		}
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)) {
			ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
			ErpFunSale erpFunSaleUp = new ErpFunSale();
			erpFunSaleUp.setOrangeFlag(false);
			erpFunSaleUp.setTrackTime(new Date());
			erpFunSaleUp.setShardCityId(param.getCityId());
			erpFunSaleUp.setSaleId(erpFunSale.getSaleId());
			erpFunSaleUp.setCompId(erpFunSale.getCompId());
			erpFunSaleUp.setUpdateTime(new Date());
			erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSaleUp);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
			ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
			ErpFunLease erpFunLeaseUp = new ErpFunLease();
			erpFunLeaseUp.setOrangeFlag(false);
			erpFunLeaseUp.setTrackTime(new Date());
			erpFunLeaseUp.setShardCityId(param.getCityId());
			erpFunLeaseUp.setLeaseId(erpFunLease.getLeaseId());
			erpFunLeaseUp.setCompId(erpFunLease.getCompId());
			erpFunLeaseUp.setUpdateTime(new Date());
			erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLeaseUp);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST)) {
			ErpFunBuyCustomer erpFunBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
			ErpFunBuyCustomer buyCustomerUp = new ErpFunBuyCustomer();
			buyCustomerUp.setOrangeFlag(false);
			buyCustomerUp.setTrackTime(nowTime);
			buyCustomerUp.setShardCityId(param.getCityId());
			buyCustomerUp.setCompId(erpFunBuyCustomer.getCompId());
			buyCustomerUp.setBuyCustId(erpFunBuyCustomer.getBuyCustId());
			buyCustomerUp.setUpdateTime(new Date());
			erpFunBuyCustomerMapper.updateByPrimaryKeySelective(buyCustomerUp);
		} else if (caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST)) {
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			ErpFunRentCustomer rentCustomerUp = new ErpFunRentCustomer();
			rentCustomerUp.setOrangeFlag(false);
			rentCustomerUp.setTrackTime(new Date());
			rentCustomerUp.setUpdateTime(new Date());
			rentCustomerUp.setShardCityId(param.getCityId());
			rentCustomerUp.setCompId(erpFunRentCustomer.getCompId());
			rentCustomerUp.setRentCustId(erpFunRentCustomer.getRentCustId());
			erpFunRentCustomerMapper.updateByPrimaryKeySelective(rentCustomerUp);
		}
		erpFunPolicyControlService.resetPrivateDay(param.getCityId(), caseId, caseType, true, false, param.getCompId(), createAuditUid);
	}

	/**
	 * 获得当前用户当天已转公盘信息条数
	 * @author 熊刚
	 * @since 2017年10月27日
	 * @param caseType
	 * @param cityId
	 * @param compId
	 * @return
	 */
	private String getPublicCaseCount(Integer caseType, Integer cityId, Integer compId,Integer userId) {
		String detectType = "";
		String trackDay = "";
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			detectType = "GET_PUBLIC_SELL";
			trackDay = "GET_PUBLIC_RED_SELL";
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			detectType = "GET_PUBLIC_LEASE";
			trackDay = "GET_PUBLIC_RED_LEASE";
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			detectType = "GET_PUBLIC_BUY";
			trackDay = "GET_PUBLIC_RED_BUY";
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			detectType = "GET_PUBLIC_RENT";
			trackDay = "GET_PUBLIC_RED_RENT";
		}
		String startDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 00:00:00");
		String endDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 23:59:59");

		Integer exsistRecords = erpFunTrackMapper.getCount(cityId, compId, caseType, Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE,
				userId, startDate, endDate, 1);
		List<String> sysParamIds = new ArrayList<>();
		sysParamIds.add(detectType);
		sysParamIds.add(trackDay);
		Map<String,String> sysParaMap = erpSysParaService.getMLSysParamMapByUserType(cityId, compId, userId, sysParamIds);
		String maxRecordStr = sysParaMap.get(detectType);
		Integer maxRecords = StringUtil.parseInteger(maxRecordStr, 0);
		if (exsistRecords >= maxRecords) {
			throw new ConfirmException("对不起，您今天可获抢盘信息条数已用完，请明天再进行此操作！");
		} else {
			String trackDayParam = sysParaMap.get(trackDay);
			if (maxRecords - exsistRecords - 1 > 0) {
				return "成功获取该抢盘信息，请于" + trackDayParam + "天内完成跟进。您今日还可获取" + (maxRecords - exsistRecords - 1) + "条该类抢盘信息！";
			} else {
				return "成功获取该抢盘信息，请于" + trackDayParam + "天内完成跟进。您今天可获抢盘信息条数已用完！";
			}
		}
	}

	// --熊刚加的-结束--


	// --张宏利加的-开始--
	@Override
	public CaseInfoDto getCaseInfoById(Integer cityId, Integer caseId, Integer caseType) {
		CaseInfoDto caseInfoDto = new CaseInfoDto();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			Assert.isNullThrow(erpFunSale, "未找到该出售数据");
			caseInfoDto.setErpFunSale(erpFunSale);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			Assert.isNullThrow(erpFunLease, "未找到该出租数据");
			caseInfoDto.setErpFunLease(erpFunLease);
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			Assert.isNullThrow(erpFunBuyCustomer, "未找到该求购数据");
			caseInfoDto.setErpFunBuyCustomer(erpFunBuyCustomer);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			Assert.isNullThrow(erpFunRentCustomer, "未找到该求租数据");
			caseInfoDto.setErpFunRentCustomer(erpFunRentCustomer);
		}
		return caseInfoDto;
	}

	/**
	 * 依据审核的内容生成跟进参数
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @return
	 */
	private ErpCreateTrackInfoParam generatorTrackParam(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId, Integer trackFromType) {
		ErpCreateTrackInfoParam param = new ErpCreateTrackInfoParam();
		ErpFunUsers createUsers = erpFunUsersMapper.selectByUserId(cityId, auditRuntime.getUserId());
		ErpFunDepts createDepts = erpFunDeptsMapper.getByDeptId(cityId, createUsers.getDeptId());
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, auditUserId);
		ErpFunDepts erpFunDepts = createDepts;
		// 不是同一个门店则重新查询
		if(!createDepts.getDeptId().equals(erpFunUsers.getDeptId())) {
			erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
		}
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunDepts.getCompNo());
		// 参考写跟进需要的参数
		param.setCityId(cityId);
		param.setCompId(erpFunUsers.getCompId());
		param.setSelfDeptId(erpFunUsers.getDeptId());
		param.setSelfUserId(erpFunUsers.getUserId());
		param.setSelfUserName(erpFunUsers.getUserName());
		param.setSelfArchiveId(erpFunUsers.getArchiveId());
		param.setSelfDeptName(erpFunDepts.getDeptName());
		param.setCompType(adminFunComp.getCompType().intValue());
		param.setAreaFlag(adminFunComp.getAreaFlag().toString());
		param.setIsPersonalVersion(false);
		// 审核之后需要设置的信息
		param.setTrackFromType(trackFromType);// 审核通过
		param.setCreateAuditUser(createUsers);
		param.setCreateAuditDept(createDepts);
		param.setAuditRuntime(auditRuntime);
		param.setTargetType(auditRuntime.getTargetType());
		param.setCaseId(auditRuntime.getCaseId());
		param.setCaseType(auditRuntime.getCaseType());
		param.setCaseNo(auditRuntime.getCaseNo());
		param.setTrackContent(auditRuntime.getAuditExplain());
		param.setTargetTime(auditRuntime.getTargetTime());
		param.setTargetId(auditRuntime.getTargetId());
		param.setTargetIds(auditRuntime.getTargetIds());
		param.setTargetNo(auditRuntime.getTargetNo());
		param.setTargetUseage(auditRuntime.getTargetUseage());
		param.setWarmTime(auditRuntime.getWarmTime());
		param.setWarmContent(auditRuntime.getWarmContent());
		param.setPhotoUrls(auditRuntime.getPhotoUrls());
		param.setUserIds(auditRuntime.getUserIds());
		param.setUserNames(auditRuntime.getUserNames());
		param.setDeptNames(auditRuntime.getDeptNames());
		param.setTrackNo(auditRuntime.getTrackNo());
		param.setVideoIds(auditRuntime.getVideoIds());
		param.setVideoLocations(auditRuntime.getVideoLocations());
		param.setVideoShootingTimes(auditRuntime.getVideoShootingTimes());
		param.setVrIds(auditRuntime.getVrIds());
		param.setPhotoIds(auditRuntime.getPhotoIds());
		param.setKeyDeptId(auditRuntime.getKeyDeptId());
		param.setVideoUrls(auditRuntime.getVideoUrls());
		param.setMakeSure(auditRuntime.getMakeSure());
		if(null != auditRuntime.getTotalPrice()) {
			param.setTotalPrice(auditRuntime.getTotalPrice());
		}
		if(null != auditRuntime.getPriceUnit()) {
			param.setPriceUnit(auditRuntime.getPriceUnit());
		}
		if(null != auditRuntime.getLowestPrice()) {
			param.setLowestPrice(auditRuntime.getLowestPrice());
		}
		// 跟进类型和状态
		param.setTrackType(auditRuntime.getAuditType().byteValue());
		return param;
	}

	/**
	 * 依据不同来源创建相关跟进内容字符串
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTrackContent(ErpCreateTrackInfoParam param, String dealInfo) {
		return generatorTrackContent(param, dealInfo, "");
	}

	/**
	 * 依据不同来源创建相关跟进内容字符串
	 * 适用于大部分跟进内容的模板
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTrackContent(ErpCreateTrackInfoParam param, String dealInfo, String otherInfo) {
		String trackContentOffUser = param.getTrackContent();
		trackContentOffUser = (trackContentOffUser == null) ? "" : trackContentOffUser;
		if(trackContentOffUser.length() > 1000) {
			throw new ConfirmException("跟进内容不能超过1000字！");
		}
		otherInfo = (otherInfo == null) ? "" : otherInfo;
		String trackContent = this.generatorTrackContentBase(param, "对该信息" + dealInfo);
		if(Const.DIC_TRACK_TYPE_FUNCAN.equals(param.getTrackType())){
			trackContent += otherInfo + "\n跟进内容：" ;
		} else {
			String s = addDueDate(param);
			if(StringUtils.isNotBlank(s)) {
				otherInfo += "<br /><span style='color:#000000;'>" + s + "</span>";
			}
			trackContent += otherInfo + "\n跟进内容：" + trackContentOffUser;
		}
		return trackContent;
	}

	/**
	 * 依据不同来源创建相关跟进内容字符串
	 * 并且末尾拼接：\n跟进内容：xxx
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTrackContentBaseBefor(ErpCreateTrackInfoParam param, String dealInfo) {
		String trackContentOffUser = param.getTrackContent();
		trackContentOffUser = (trackContentOffUser == null) ? "" : trackContentOffUser;
		String trackContent = this.generatorTrackContentBase(param, dealInfo);

		String dueDateStr = this.addDueDate(param);
		if(StringUtils.isNotBlank(dueDateStr)) {
			trackContent+= "<br /><span style='color:#000000;'>" + dueDateStr + "</span>";
		}
		trackContent += "\n跟进内容：" + trackContentOffUser;
		return trackContent;
	}
	
	/**
	 * 暂缓、委托、预定、封盘、内成交（出租）将到期时间写入跟进之中
	 * @author lcb
	 * @date 2018/7/4
	 * @return
	 */
	private String addDueDate(ErpCreateTrackInfoParam param) {
		String dueTimeStr = "";
		switch (param.getTrackType()) {
			case 27:
				dueTimeStr = "暂缓到期：";
				break;
			case 6:
				dueTimeStr = "委托截止：";
				break;
			case 7:
				dueTimeStr = "委托截止：";
				break;
			case 19:
				dueTimeStr = "委托截止：";
				break;
			case 9:
				dueTimeStr = "委托截止：";
				break;
			case 25:
				dueTimeStr = "预订保护：";
				break;
			case 26:
				dueTimeStr = "封盘保护：";
				break;
			case 29:
				if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
					dueTimeStr = "租期截止：";
				}
				break;
			case 28:
				if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
					dueTimeStr = "租期截止：";
				}
				break;
		}
		if(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(param.getTrackType())
				|| Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(param.getTrackType())){
			String paramValue = "";
//			ErpFunComp erpFunComp = new ErpFunComp();
//			erpFunComp.setCompId(param.getCompId());
//			erpFunComp.setShardCityId(param.getCityId());
//			erpFunComp = erpFunCompMapper.getCompInfoByCompId(erpFunComp);

			Integer userId = param.getCreateAuditUser().getUserId();
			Integer cityId = param.getCityId();
			Integer compId = param.getCompId();
			// 查看策略参数是否隔离
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
			Integer partnerId = erpFunUsers.getPartnerId();
			CheckPartnerConfigDto strategyParamApartConfig = erpFunPartnerConfigService.checkPartnerConfig(cityId, compId, partnerId, "strategyParamApart");
			Byte openPartner = strategyParamApartConfig.getOpenPartner();
			Byte isApart = strategyParamApartConfig.getIsApart();

			// 该公司是否开启了策略参数
			boolean plotSwitch = false;

			// 如果公司开启了加盟商模式, 并且策略参数独立配置
			if (openPartner == 1 && isApart == 1 && partnerId > 0) {
				ErpFunPartner condition = new ErpFunPartner(cityId, partnerId);
				condition.setShardCityId(cityId);
				ErpFunPartner erpFunPartner = erpFunPartnerMapper.selectByPrimaryKey(condition);

				if (erpFunPartner != null && erpFunPartner.getPlotSwitch() != null) {
					// 0=没有开启 1=开启
					plotSwitch = erpFunPartner.getPlotSwitch() == 1;
				}
			} else {
				ErpFunComp funComp = new ErpFunComp();
				funComp.setShardCityId(cityId);
				funComp.setCompId(compId);
				ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(funComp);

				if (erpFunComp != null && erpFunComp.getPlotSwitch() != null) {
					plotSwitch = erpFunComp.getPlotSwitch();
				}
			}

//			if(null != erpFunComp && null != erpFunComp.getPlotSwitch() && erpFunComp.getPlotSwitch()){
			if(plotSwitch){
				if(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(param.getTrackType())){
					paramValue = erpSysParaService.getMLErpSysParamValByOrgId(param.getCityId(), param.getCompId(), param.getCreateAuditUser().getOrganizationId(), "INFO_MAX_SECRECY");
					//paramValue = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "INFO_MAX_SECRECY"); // 加密保护期
					dueTimeStr = "加密到期：";
				} else if(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(param.getTrackType())){
					paramValue = erpSysParaService.getMLErpSysParamValByOrgId(param.getCityId(), param.getCompId(), param.getCreateAuditUser().getOrganizationId(), "INFO_MAX_COMMEND_DAYS");
					//paramValue = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "INFO_MAX_COMMEND_DAYS");// 推荐截止日期
					dueTimeStr = "推荐截止：";
				}
				param.setTargetTime(DateTimeHelper.addDays(new Date(), StringUtil.paseInteger(paramValue, 0)));
			}
		}
		if(StringUtils.isNotBlank(dueTimeStr) && null != param.getTargetTime()) {
			dueTimeStr+= DateUtil.DateToString(param.getTargetTime(), "yyyy-MM-dd");
		}
		return dueTimeStr;
	}

	/**
	 * 依据不同来源创建相关跟进内容字符串
	 * 末尾没有拼接跟进内容
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTrackContentBase(ErpCreateTrackInfoParam param, String dealInfo) {
		String trackContent = null;
		String selfCurrUserName = param.getSelfCurrUserName();
		String createCurrUserName = param.getCreateCurrUserName();
		if (param.getTrackFromType() == 1) {
			trackContent = createCurrUserName + dealInfo;
		} else if (param.getTrackFromType() == 2) {
			trackContent = "系统自动通过了" + createCurrUserName + dealInfo + "的申请";
		} else if (param.getTrackFromType() == 3) {
			ErpAuditRuntime auditRuntime = param.getAuditRuntime();
			String auditCreateTime = DateTimeHelper.formatDateTimetoString(auditRuntime.getCreationTime());
			trackContent = selfCurrUserName + "审核通过了" + createCurrUserName + "于" + auditCreateTime + dealInfo + "的申请";
		} else if (4 == param.getTrackFromType()) {
			trackContent = "系统超期自动审核通过了" + createCurrUserName + dealInfo + "的申请";
		} else if (5 == param.getTrackFromType()) {
			trackContent = createCurrUserName + dealInfo + "，申请审核";
		} else if (6 == param.getTrackFromType()) {
			ErpAuditRuntime auditRuntime = param.getAuditRuntime();
			String auditCreateTime = DateTimeHelper.formatDateTimetoString(auditRuntime.getCreationTime());
			trackContent = selfCurrUserName + "审核失败了" + createCurrUserName + "于" + auditCreateTime + dealInfo + "的申请";
		}
		return trackContent;
	}
	
	/**
	 * 依据不同来源创建相关审核标题字符串
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTaskSubject(ErpCreateTrackInfoParam param, String dealInfo) {
		return generatorTaskSubject(param, dealInfo, "");
	}

	/**
	 * 依据不同来源创建相关审核标题字符串
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTaskSubjectBaseBefor(ErpCreateTrackInfoParam param, String dealInfo) {
		String taskSubject = this.generatorTaskSubjectBase(param, dealInfo);
		return taskSubject;
	}
	
	/**
	 * 依据不同来源创建相关审核标题字符串
	 * 适用于大部分跟进内容的模板
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTaskSubject(ErpCreateTrackInfoParam param, String dealInfo, String otherInfo) {
		otherInfo = (otherInfo == null) ? "" : otherInfo;
		String taskSubject = this.generatorTaskSubjectBase(param, "对该信息" + dealInfo);
		taskSubject += otherInfo;
		return taskSubject;
	}
	
	/**
	 * 依据不同来源创建相关审核标题字符串
	 * 末尾没有拼接跟进内容
	 * @author 张宏利
	 * @since 2017年10月23日
	 * @param param
	 * @return
	 */
	private String generatorTaskSubjectBase(ErpCreateTrackInfoParam param, String dealInfo) {
		String taskSubject = null;
		String createCurrUserName = param.getCreateCurrUserName();
		if (param.getTrackFromType() == 1) {
			taskSubject = createCurrUserName + dealInfo;
		} else if (param.getTrackFromType() == 2) {
			taskSubject = "系统自动通过了" + createCurrUserName + dealInfo + "的申请";
		} else if (param.getTrackFromType() == 3) {
			taskSubject = createCurrUserName + dealInfo + "的申请已审核通过";
		} else if (4 == param.getTrackFromType()) {
			taskSubject = "系统超期自动审核通过了" + createCurrUserName + dealInfo + "的申请";
		} else if (5 == param.getTrackFromType()) {
			taskSubject = createCurrUserName + dealInfo + "，申请审核";
		} else if (6 == param.getTrackFromType()) {
			taskSubject = createCurrUserName + dealInfo + "的申请已审核失败";
		}
		return taskSubject;
	}

	/**
	 * 判断是否可以转有效，不满足时抛异常
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param param
	 * @param actionName 操作名称：转为有效、修改楼盘
	 * @param warning 允许重复但存在重复时是否提示，不提示直接通过
	 */
	private void judgeCanTransAvailable(ErpCreateTrackInfoParam param, String actionName, boolean warning) {
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		Integer compId = param.getCompId();
		Integer cityId = param.getCityId();
		Integer sureToAviliable = param.getSureToAviliable();
		Integer createAuditUid = param.getCreateAuditUser().getUserId();
		boolean idCardRepeat = false;
		// 楼盘变更时查询变更之后的楼盘是否重复
		boolean useTargetId = Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD.equals(param.getTrackType());
		// 确定转有效了就不用下面的判断了
		if(sureToAviliable != null && sureToAviliable == 1) {
			return;
		}
		String houseOnly = erpSysParaMapper.getParamValue(cityId, compId, "HOUSEDATA_MUSTBE_ONLYONE");
		String custOnly = erpSysParaMapper.getParamValue(cityId, compId, "CUSTDATA_MUSTBE_ONLYONE");
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = param.getCaseInfoDto().getErpFunSale();
			Integer buildId = useTargetId ? param.getTargetId() : erpFunSale.getBuildId();
			Byte saleUseage = erpFunSale.getSaleUseage();
			String houseRoof = EnCodeHelper.decode(erpFunSale.getSaleRoof());
			String houseUnit = EnCodeHelper.decode(erpFunSale.getSaleUnit());
			String unitFloor = EnCodeHelper.decode(erpFunSale.getUnitFloor());
			String houseNum = EnCodeHelper.decode(erpFunSale.getSaleNum());
			// 判断是否符合规则
			erpBuildingSetRoomService.judgeHouseRuleAndThrow(cityId, compId,createAuditUid, buildId, houseRoof, houseUnit,
					houseNum, unitFloor, caseType, saleUseage);
			Map<String, String> addrRepet = erpFunSaleService.getAddrRepetCount(
					cityId, compId, caseId, caseType, null, buildId, houseRoof,
					houseUnit, unitFloor, houseNum, erpFunSale.getTradeAddr(), erpFunSale.getSaleUseage(),
					param.getIsPersonalVersion(), createAuditUid, erpFunSale.getAreaId(), erpFunSale.getRegId(),
					erpFunSale.getDeptId(), erpFunSale.getGrId());
			int[] count = new int[]{StringUtil.paseInteger(addrRepet.get("compCount"), 0),
					StringUtil.paseInteger(addrRepet.get("deptCount"), 0)};
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunSale.getCellPhone(), false);
			Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
					phoneArr, null, param.getIsPersonalVersion(), createAuditUid, param.getSelfDeptId(),
					erpFunSale.getAreaId(), erpFunSale.getRegId(), erpFunSale.getDeptId(), erpFunSale.getGrId());

			int[] countHousePhone = new int[]{StringUtil.paseInteger(phoneRepet.get("compCount"), 0),
					StringUtil.paseInteger(phoneRepet.get("deptCount"), 0)};

			if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_2.equals(houseOnly)) {
				if ((count[0] + count[1] > 0) && (countHousePhone[0] + countHousePhone[1] > 0)) {
					throw new BusinessException("该房源与其他房源信息重复，不能" + actionName + "！");// 转为有效-修改楼盘
				}
			} else if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_1.equals(houseOnly)) {
				if (count[0] + count[1] > 0) {
					throw new BusinessException("该房源与其他房源信息重复，不能" + actionName + "！");
				}
			} else if (warning) {
				if ((count[0] + count[1] > 0) || (countHousePhone[0] + countHousePhone[1] > 0)) {
					throw new BusinessException("该房源与其他房源信息重复，是否" + actionName + "？", "-2");
				}
			}
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = param.getCaseInfoDto().getErpFunLease();
			Integer buildId = useTargetId ? param.getTargetId() : erpFunLease.getBuildId();
			Byte leaseUseage = erpFunLease.getLeaseUseage();
			String houseRoof = EnCodeHelper.decode(erpFunLease.getLeaseRoof());
			String houseUnit = EnCodeHelper.decode(erpFunLease.getLeaseUnit());
			String unitFloor = EnCodeHelper.decode(erpFunLease.getUnitFloor());
			String houseNum = EnCodeHelper.decode(erpFunLease.getLeaseNum());
			// 判断是否符合规则
			String houseFloor = StringUtils.isBlank(unitFloor) ? String.valueOf(erpFunLease.getLeaseFloor()) : unitFloor;
			erpBuildingSetRoomService.judgeHouseRuleAndThrow(cityId, compId,createAuditUid, buildId, houseRoof, houseUnit,
					houseNum, houseFloor, caseType, leaseUseage);
			Map<String, String> addrRepet = erpFunSaleService.getAddrRepetCount(
					cityId, compId, caseId, caseType, null, buildId, houseRoof,
					houseUnit, unitFloor, houseNum, erpFunLease.getTradeAddr(), erpFunLease.getLeaseUseage(),
					param.getIsPersonalVersion(), createAuditUid, erpFunLease.getAreaId(), erpFunLease.getRegId(),
					erpFunLease.getDeptId(), erpFunLease.getGrId());
			int[] count = new int[]{StringUtil.paseInteger(addrRepet.get("compCount"), 0),
					StringUtil.paseInteger(addrRepet.get("deptCount"), 0)};
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunLease.getCellPhone(), false);
			Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
					phoneArr, null, param.getIsPersonalVersion(), createAuditUid, param.getSelfDeptId(),
					erpFunLease.getAreaId(), erpFunLease.getRegId(), erpFunLease.getDeptId(), erpFunLease.getGrId());

			int[] countHousePhone = new int[]{StringUtil.paseInteger(phoneRepet.get("compCount"), 0),
					StringUtil.paseInteger(phoneRepet.get("deptCount"), 0)};

			if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_2.equals(houseOnly)) {
				if ((count[0] + count[1] > 0) && (countHousePhone[0] + countHousePhone[1] > 0)) {
					throw new BusinessException("该房源与其他房源信息重复，不能" + actionName + "！");
				}
			} else if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_1.equals(houseOnly)) {
				if (count[0] + count[1] > 0) {
					throw new BusinessException("该房源与其他房源信息重复，不能" + actionName + "！");
				}
			} else if (warning) {
				if ((count[0] + count[1] > 0) || (countHousePhone[0] + countHousePhone[1] > 0)) {
					throw new BusinessException("该房源与其他房源信息重复，是否" + actionName + "？", "-2");
				}
			}
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = param.getCaseInfoDto().getErpFunBuyCustomer();
			Integer idCardType = Optional.ofNullable(erpFunBuyCustomer.getIdCardType()).orElse(0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunBuyCustomer.getCellPhone(), false);
			Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
					phoneArr, null, param.getIsPersonalVersion(), createAuditUid, param.getSelfDeptId(),
					erpFunBuyCustomer.getAreaId(), erpFunBuyCustomer.getRegId(), erpFunBuyCustomer.getDeptId(),
					erpFunBuyCustomer.getGrId());
			int[] countHousePhone = new int[] { StringUtil.paseInteger(phoneRepet.get("compCount"), 0),
					StringUtil.paseInteger(phoneRepet.get("deptCount"), 0) };
			if (StringUtil.isNotBlank(erpFunBuyCustomer.getIdCard())) {
				// 身份证
				idCardRepeat = erpFunBuyCustomerService.getIdCardRepeat(cityId, compId, createAuditUid, caseId,
						param.getIsPersonalVersion(), caseType, erpFunBuyCustomer.getIdCard(), idCardType);
			}
			if ("0".equals(custOnly)) {
				if (idCardRepeat || countHousePhone[0] + countHousePhone[1] > 0) {
					throw new BusinessException("该客源与其他客源信息重复，不能" + actionName + "！");
				}
			} else if (warning) {
				if (idCardRepeat || countHousePhone[0] + countHousePhone[1] > 0) {
					throw new BusinessException("该客源与其他客源信息重复，是否" + actionName + "？", "-2");
				}
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = param.getCaseInfoDto().getErpFunRentCustomer();
			Integer idCardType = Optional.ofNullable(erpFunRentCustomer.getIdCardType()).orElse(0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunRentCustomer.getCellPhone(), false);
			Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
					phoneArr, null, param.getIsPersonalVersion(), createAuditUid, param.getSelfDeptId(),
					erpFunRentCustomer.getAreaId(), erpFunRentCustomer.getRegId(), erpFunRentCustomer.getDeptId(),
					erpFunRentCustomer.getGrId());
			int[] countHousePhone = new int[] { StringUtil.paseInteger(phoneRepet.get("compCount"), 0),
					StringUtil.paseInteger(phoneRepet.get("deptCount"), 0) };
			if (StringUtil.isNotBlank(erpFunRentCustomer.getIdCard())) {
				// 身份证
				idCardRepeat = erpFunBuyCustomerService.getIdCardRepeat(cityId, compId, createAuditUid, caseId,
						param.getIsPersonalVersion(), caseType, erpFunRentCustomer.getIdCard(), idCardType);
			}
			if ("0".equals(custOnly)) {
				if (idCardRepeat || countHousePhone[0] + countHousePhone[1] > 0) {
					throw new BusinessException("该客源与其他客源信息重复，不能" + actionName + "！");
				}
			} else if (warning) {
				if (idCardRepeat || countHousePhone[0] + countHousePhone[1] > 0) {
					throw new BusinessException("该客源与其他客源信息重复，是否" + actionName + "？", "-2");
				}
			}
		}
	}

	/**
	 * 依据类型获取跟进是否需要审核的参数名
	 * @author 张宏利
	 * @since 2016年5月26日
	 * @return
	 */
	private String getCompSysParamExam(Byte trackType){
		if(Const.DIC_TRACK_TYPE_FUNCAN.equals(trackType)){
			return "FUNCAN";
		} else if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)){
			return "YUDING";
		} else if (Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)){
			return "FENGPAN";
		} else if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)){
			return "JIAMI";
		} else if (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(trackType)){
			return "TUIJIAN";
		} else if (Const.DIC_TRACK_TYPE_BARGAIN.equals(trackType)){
			return "YIJIA";
		} else if (Const.DIC_TRACK_TYPE_DAIKAN.equals(trackType)){
			return "DAIKAN";
		} else if (trackType.equals(Const.DIC_TRACK_TYPE_LIMITED)
				|| trackType.equals(Const.DIC_TRACK_TYPE_ALONE)
				|| trackType.equals(Const.DIC_TRACK_TYPE_RENT)
				|| trackType.equals(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT)){
			return "WEITUO";
		} else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)){
			return "WAICHENGJIAO";
		} else if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)){
			return "NEICHENGJIAO";
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)){
			return "ZHUANYOUXIAO";
		} else if (Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)){// 暂缓
			return "ZANHUAN";
		} else if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)){// 注销
			return "ZHUXIAO";
		}
		return "";
	}

	/**
	 * 把房源的信息放入参数
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param param
	 */
	private void generatorCaseInfoToParam(ErpCreateTrackInfoParam param) {
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		Integer caseType = param.getCaseType();
		Object houseCust = null;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
			param.setCaseNo(erpFunSale.getSaleNo());
			param.setOldStatus(erpFunSale.getSaleStatus().intValue());
			param.setCaseUseage(String.valueOf(erpFunSale.getSaleUseage()));
			param.setSaleLeaseId(erpFunSale.getSaleLeaseId());
			param.setIsSaleLease(erpFunSale.getIsSaleLease());
			param.setCaseLevel(erpFunSale.getSaleLevel());
			param.setHasFankan(erpFunSale.getSaleExplrth());// 不要使用房源上的HAS_FANKAN字段了，废弃了
			param.setCasePublish(erpFunSale.getSalePublish());
			param.setCaseCooperate(null != erpFunSale.getSaleCooperate() ? erpFunSale.getSaleCooperate() : false);
			param.setCaseBuildName(erpFunSale.getBuildName());
			houseCust = erpFunSale;
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
			param.setCaseNo(erpFunLease.getLeaseNo());
			param.setOldStatus(erpFunLease.getLeaseStatus());
			param.setCaseUseage(String.valueOf(erpFunLease.getLeaseUseage()));
			param.setSaleLeaseId(erpFunLease.getSaleLeaseId());
			param.setIsSaleLease(erpFunLease.getIsSaleLease());
			param.setHasFankan(erpFunLease.getLeaseExplrth());// 不要使用房源上的HAS_FANKAN字段了，废弃了
			param.setCaseLevel(erpFunLease.getLeaseLevel());
			param.setCasePublish(erpFunLease.getLeasePublish());
			param.setCaseCooperate(null != erpFunLease.getLeaseCooperate() ? erpFunLease.getLeaseCooperate() : false);
			param.setCaseBuildName(erpFunLease.getBuildName());
			houseCust = erpFunLease;
		} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			ErpFunBuyCustomer erpFunBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
			param.setCaseNo(erpFunBuyCustomer.getBuyCustNo());
			param.setOldStatus(erpFunBuyCustomer.getBuyCustStatus().intValue());
			param.setCaseUseage(erpFunBuyCustomer.getHouseUseage());
			param.setCaseLevel(erpFunBuyCustomer.getBuyCustLevel());
			param.setCaseBuildName(erpFunBuyCustomer.getBuildName());
			houseCust = erpFunBuyCustomer;
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			param.setCaseNo(erpFunRentCustomer.getRentCustNo());
			param.setOldStatus(erpFunRentCustomer.getRentCustStatus().intValue());
			param.setCaseUseage(erpFunRentCustomer.getHouseUseage());
			param.setCaseLevel(erpFunRentCustomer.getRentCustLevel());
			param.setCaseBuildName(erpFunRentCustomer.getBuildName());
			houseCust = erpFunRentCustomer;
		}
		param.setCaseAreaId(BeanUtil.getProperty(houseCust, "areaId"));
		param.setCaseRegId(BeanUtil.getProperty(houseCust, "regId"));
		param.setCaseDeptId(BeanUtil.getProperty(houseCust, "deptId"));
		param.setCaseGrId(BeanUtil.getProperty(houseCust, "grId"));
		param.setCaseUserId(BeanUtil.getProperty(houseCust, "userId"));
		param.setCasePlateType(BeanUtil.getProperty(houseCust, "plateType"));
	}

	/**
	 * 总经理查看电话写跟进
	 * @author 张宏利
	 * @since 2017年10月31日
	 * @param erpFunViewLog
	 */
	@Override
	public Integer writeTrackByGeneralViewLog(ErpFunViewLog erpFunViewLog, Byte caseStatus, String currUserName, Integer caseDeptId, Integer creatorUid, String trackContract) {
		String plateTypeCn = erpDicDefinitionsMapper.getDicCnMsg(erpFunViewLog.getShardCityId(), "PLATE_TYPE", erpFunViewLog.getPlateType().toString());
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setShardCityId(erpFunViewLog.getShardCityId());
		erpFunTrack.setCaseId(erpFunViewLog.getTargetId());
		erpFunTrack.setCaseType(erpFunViewLog.getTargetType());
		erpFunTrack.setCaseNo(erpFunViewLog.getTargetNo());
		erpFunTrack.setDeptId(erpFunViewLog.getDeptId());
		erpFunTrack.setCompId(erpFunViewLog.getCompId());
		erpFunTrack.setCreatorUid(creatorUid);
		erpFunTrack.setCaseUserId(erpFunViewLog.getOwnerId());
		erpFunTrack.setCaseStatus(caseStatus);
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_VIEW_PHONE);
		erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_6);
		erpFunTrack.setTargetFlag(true);
		erpFunTrack.setExaminTime(timeNow);
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setCaseDeptId(caseDeptId);
		erpFunTrack.setCreationTime(timeNow);
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(erpFunViewLog.getTargetType().intValue())
				|| Const.DIC_CASE_TYPE_LEASE_FUN.equals(erpFunViewLog.getTargetType().intValue())) {
			erpFunTrack.setTrackContent(currUserName + "查看了该" + plateTypeCn + "房源核心信息.");
		} else {
			erpFunTrack.setTrackContent(currUserName + "查看了该" + plateTypeCn + "客源核心信息.");
		}
		if(StringUtils.isNotBlank(trackContract)) {
			erpFunTrack.setTrackContent(erpFunTrack.getTrackContent() + "查看理由："+trackContract);
		}
		erpFunTrackMapper.insertSelective(erpFunTrack);
		return erpFunTrack.getTrackId();
	}

	/**
	 * 依据跟进来源获取跟进类型文字
	 * @author 张宏利
	 * @since 2017年11月4日
	 * @param trackFromType
	 * @return
	 */
	private String getTrackClassic(Integer trackFromType, Byte trackType) {
		// 依据不用来源区分类型标题
//		if (trackFromType == 2) {
//			trackClassic = Const.DIC_TRACKCLASSIC_3;
//		} else if (trackFromType == 3) {
//			trackClassic = Const.DIC_TRACKCLASSIC_5;
//		}
		String trackClassic = Const.AUDIT_TYPE_CLASSIC_MAP.get(trackType);
		if(trackClassic == null) {
			trackClassic = Const.DIC_TRACKCLASSIC_1;
		}
		return trackClassic;
	}

	/**
	 * 总经理查看电话写跟进
	 * @author 张宏利
	 * @since 2017年10月31日
	 */
	public void writeTrackByUploadPhoto(Integer cityId ,Integer compId,Integer caseId, Byte caseType,String caseNo,Byte caseStatus, String currUserName, Integer caseDeptId,Integer caseUserId,Integer creatorUserId,Integer creatorDeptId) {
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setShardCityId(cityId);
		erpFunTrack.setCaseId(caseId);
		erpFunTrack.setCaseType(caseType);
		erpFunTrack.setCaseNo(caseNo);
		erpFunTrack.setDeptId(creatorDeptId);
		erpFunTrack.setCaseStatus(caseStatus);
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_PHOTO_UPLOAD);
		erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_10);
		erpFunTrack.setCreatorUid(creatorUserId);
		erpFunTrack.setCaseUserId(caseUserId);
		erpFunTrack.setCaseDeptId(caseDeptId);
		erpFunTrack.setTrackContent(currUserName + " 今日上传了图片");
		erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunTrackMapper.insertSelective(erpFunTrack);
	}

	/**
	 * 依据跟进类型来设置一些属性
	 * @author 张宏利
	 * @since 2017年11月4日
	 * @param param
	 */
	private void generatorParamByParam(ErpCreateTrackInfoParam param) {
		Byte trackType = param.getTrackType();
		if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)) {// 预订-25
			param.setStatus(Const.DIC_HOUSE_STATUS_SCHEDULE);
		} else if (Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)) {// 封盘-26
			param.setStatus(Const.DIC_HOUSE_STATUS_SPECIAL);
		} else if (Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)) {// 暂缓-27
			param.setStatus(Const.DIC_HOUSE_STATUS_RESPITE);
		} else if (Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {// 内成交-28
			param.setStatus(Const.DIC_HOUSE_STATUS_INNERDEAL);
		} else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)) {// 外成交-29
			param.setStatus(Const.DIC_HOUSE_STATUS_DEAL);
		} else if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {// 注销-30
			param.setStatus(Const.DIC_HOUSE_STATUS_WRITEOFF);
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)) {// 转有效-21
			param.setStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
		} else if (Const.DIC_TRACK_TYPE_STATUS_AVAILABLE.equals(trackType)) {// 状态变有效-50
			param.setStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
		}
		// 设置用户门店名+用户名
		String currUserName = getCurrUserName(param.getSelfDeptName(), param.getSelfUserName(), param.getCompType(), param.getIsPersonalVersion());
		param.setSelfCurrUserName(currUserName);
		ErpFunDepts createDept = param.getCreateAuditDept();
		ErpFunUsers createUser = param.getCreateAuditUser();
		String createCurrUserName = getCurrUserName(createDept.getDeptName(), createUser.getUserName(), param.getCompType(), param.getIsPersonalVersion());
		param.setCreateCurrUserName(createCurrUserName);
		// 跟进内容为null时置为空
		String trackContent = param.getTrackContent();
		param.setTrackContent((trackContent == null) ? "" : trackContent);
	}


	/**
	 * 超期自动审核
	 * @author 张宏利
	 * @since 2017年11月4日
	 */
	@Transactional
	@Override
	public void autoLimitAuditEndExec(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId,
			Integer trackFromType) {
		ErpAuditRuntime record = new ErpAuditRuntime();
		record.setShardCityId(cityId);
		record.setAuditStatus((byte)4);
		record.setLastAuditTime(new Date());
		record.setId(auditRuntime.getId());
		erpAuditRuntimeMapper.updateByPrimaryKeySelective(record);
		erpFunTrackService.auditEndExec(auditRuntime, cityId, auditUserId, trackFromType, 1);
	}

	/**
	 * @Title 房源通过核心信息进行查重
	 * @Author lcb
	 * @Date 2017/11/28
	 * @Param
	 **/
	@Override
	public Integer[] detectHouseOrCustRepeat(Integer cityId, Integer compId, Integer caseId,Integer selfUid, Integer selfDeptId,
											  Integer caseType,Boolean isPersonalVersion, CaseInfoDto caseInfoDto) {

		Integer[] resCount = new  Integer[]{0, 0};
		Integer phoneCount = 0;
		boolean idCardRepeat = false;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
			Integer buildId = erpFunSale.getBuildId();
			String houseRoof = EnCodeHelper.decode(erpFunSale.getSaleRoof());
			String houseUnit = EnCodeHelper.decode(erpFunSale.getSaleUnit());
			String unitFloor = EnCodeHelper.decode(erpFunSale.getUnitFloor());
			String houseNum = EnCodeHelper.decode(erpFunSale.getSaleNum());
			Map<String, String> addrRepet = erpFunSaleService.getAddrRepetCount(cityId, compId, caseId, caseType, null,
					buildId, houseRoof, houseUnit, unitFloor, houseNum, erpFunSale.getTradeAddr(),
					erpFunSale.getSaleUseage(), isPersonalVersion, selfUid, erpFunSale.getAreaId(),
					erpFunSale.getRegId(), erpFunSale.getDeptId(), erpFunSale.getGrId());
			Integer addreddCount = StringUtil.paseInteger(addrRepet.get("compCount"), 0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunSale.getCellPhone(), false);
			if (null != phoneArr && phoneArr.length > 0) {
				for (Integer len = 0; len < phoneArr.length; len++) {
					phoneArr[len] = EnCodeHelper.encode(phoneArr[len]);
				}
				Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
						phoneArr, null, isPersonalVersion, selfUid, selfDeptId, erpFunSale.getAreaId(),
						erpFunSale.getRegId(), erpFunSale.getDeptId(), erpFunSale.getGrId());
				phoneCount = StringUtil.paseInteger(phoneRepet.get("compCount"), 0);
			}
			resCount = new Integer[] { addreddCount, phoneCount };
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
			Integer buildId = erpFunLease.getBuildId();
			String houseRoof = EnCodeHelper.decode(erpFunLease.getLeaseRoof());
			String houseUnit = EnCodeHelper.decode(erpFunLease.getLeaseUnit());
			String unitFloor = EnCodeHelper.decode(erpFunLease.getUnitFloor());
			String houseNum = EnCodeHelper.decode(erpFunLease.getLeaseNum());
			Map<String, String> addrRepet = erpFunSaleService.getAddrRepetCount(cityId, compId, caseId, caseType, null,
					buildId, houseRoof, houseUnit, unitFloor, houseNum, erpFunLease.getTradeAddr(),
					erpFunLease.getLeaseUseage(), isPersonalVersion, selfUid, erpFunLease.getAreaId(),
					erpFunLease.getRegId(), erpFunLease.getDeptId(), erpFunLease.getGrId());
			Integer addreddCount = StringUtil.paseInteger(addrRepet.get("compCount"), 0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunLease.getCellPhone(), false);
			if (null != phoneArr && phoneArr.length > 0) {
				for (Integer len = 0; len < phoneArr.length; len++) {
					phoneArr[len] = EnCodeHelper.encode(phoneArr[len]);
				}
				Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
						phoneArr, null, isPersonalVersion, selfUid, selfDeptId, erpFunLease.getAreaId(),
						erpFunLease.getRegId(), erpFunLease.getDeptId(), erpFunLease.getGrId());
				phoneCount = StringUtil.paseInteger(phoneRepet.get("compCount"), 0);
			}
			resCount = new Integer[] { addreddCount, phoneCount };
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
			Integer idCardType = Optional.ofNullable(erpFunBuyCustomer.getIdCardType()).orElse(0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunBuyCustomer.getCellPhone(), false);
			if (null != phoneArr && phoneArr.length > 0) {
				for (Integer len = 0; len < phoneArr.length; len++) {
					phoneArr[len] = EnCodeHelper.encode(phoneArr[len]);
				}
				Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
						phoneArr, null, isPersonalVersion, selfUid, selfDeptId, erpFunBuyCustomer.getAreaId(),
						erpFunBuyCustomer.getRegId(), erpFunBuyCustomer.getDeptId(), erpFunBuyCustomer.getGrId());
				phoneCount = StringUtil.paseInteger(phoneRepet.get("compCount"), 0);
			}
			// 身份证
			if (StringUtil.isNotBlank(erpFunBuyCustomer.getIdCard())) {
				idCardRepeat = erpFunBuyCustomerService.getIdCardRepeat(cityId, compId, selfUid, caseId,
						isPersonalVersion, caseType, erpFunBuyCustomer.getIdCard(), idCardType);
			}
			resCount = new Integer[] { idCardRepeat ? 1 : 0, phoneCount };
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			Integer idCardType = Optional.ofNullable(erpFunRentCustomer.getIdCardType()).orElse(0);
			String[] phoneArr = PhoneUtil.decodePhoneToArr(erpFunRentCustomer.getCellPhone(), false);
			if (null != phoneArr && phoneArr.length > 0) {
				for (Integer len = 0; len < phoneArr.length; len++) {
					phoneArr[len] = EnCodeHelper.encode(phoneArr[len]);
				}
				Map<String, String> phoneRepet = erpFunSaleService.detectPhoneRepeat(cityId, compId, caseId, caseType,
						phoneArr, null, isPersonalVersion, selfUid, selfDeptId, erpFunRentCustomer.getAreaId(),
						erpFunRentCustomer.getRegId(), erpFunRentCustomer.getDeptId(), erpFunRentCustomer.getGrId());
				phoneCount = StringUtil.paseInteger(phoneRepet.get("compCount"), 0);
			}
			if (StringUtil.isNotBlank(erpFunRentCustomer.getIdCard())) {
				idCardRepeat = erpFunBuyCustomerService.getIdCardRepeat(cityId, compId, selfUid, caseId,
						isPersonalVersion, caseType, erpFunRentCustomer.getIdCard(), idCardType);
			}
			resCount = new Integer[] { idCardRepeat ? 1 : 0, phoneCount };
		}
		// 判重给提示
		String houseOnly = erpSysParaMapper.getParamValue(cityId, compId, "HOUSEDATA_MUSTBE_ONLYONE");
		String custOnly = erpSysParaMapper.getParamValue(cityId, compId, "CUSTDATA_MUSTBE_ONLYONE");
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {

			if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_2.equals(houseOnly)) {
				if (resCount[0] > 0 && resCount[1] > 0) {
					throw new BusinessException("公司不允许录入重复房源！");
				}
			} else if (Const.DIC_SYSPARA_HOUSE_REPEAT_RULE_1.equals(houseOnly)) {
				if (resCount[0] > 0) {
					throw new BusinessException("公司不允许录入重复房源！");
				}
			}
		} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			if("0".equals(custOnly)) {
				if (resCount[0]>0 || resCount[1] > 0) {
					throw new BusinessException("公司不允许录入重复客源！");
				}
			}
		}
		return resCount;
	}

	/**
	 * 根据不同类型生成跟进
	 * @param param
	 */
	private ErpFunTrack generatorErpFunTrack(ErpCreateTrackInfoParam param) {
		Byte trackType = param.getTrackType();
		Integer cityId = param.getCityId();

		String trackContent = null, taskSubject = null;
		ErpFunTrack erpFunTrack = new ErpFunTrack();

		String trackClassic = this.getTrackClassic(param.getTrackFromType(), param.getTrackType());
		this.generatorTrackByParam(param, erpFunTrack, trackClassic);
		if(Const.DIC_TRACK_TYPE_BARGAIN.equals(trackType)){// 议价-15
			trackContent = this.generatorTrackContent(param, "议价");
			taskSubject = this.generatorTaskSubject(param, "议价");
		} else if(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)// 加密-17
				|| Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND.equals(trackType)){// 推荐-18
			String levelName = (Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD.equals(trackType)) ? "级别转加密" : "级别转推荐";
			trackContent = this.generatorTrackContent(param, levelName);
			taskSubject = this.generatorTaskSubject(param, levelName);
		} else if(Const.DIC_TRACK_TYPE_DAIKAN.equals(trackType)){// 带看-4
			Integer targetType = param.getTargetType().intValue();
			CaseInfoDto targetCaseInfoDto = param.getTargetCaseInfoDto();
			erpFunTrack.setDkPhotoCount((StringUtils.isNotBlank(param.getPhotoUrls())) ? 1 : 0);
			erpFunTrack.setTrackResult((StringUtils.isNotBlank(param.getVideoUrls())) ? (byte)1 : 0);
			String targetNoStr = null;
			if (Const.DIC_CASE_TYPE_SALE_FUN.equals(targetType)) {
				ErpFunSale erpFunSale = targetCaseInfoDto.getErpFunSale();
				if (erpFunSale != null) {
					erpFunTrack.setTargetDept(erpFunSale.getDeptId());
					erpFunTrack.setTargetUserId(erpFunSale.getUserId());
					erpFunTrack.setTargetUseage(erpFunSale.getSaleUseage());
					erpFunTrack.setTargetNo(erpFunSale.getSaleNo());
					targetNoStr = "（带看房源：" + erpFunSale.getSaleNo() + ")";
				}
			} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(targetType)) {
				ErpFunLease erpFunLease = targetCaseInfoDto.getErpFunLease();
				if(erpFunLease != null) {
					erpFunTrack.setTargetDept(erpFunLease.getDeptId());
					erpFunTrack.setTargetUserId(erpFunLease.getUserId());
					erpFunTrack.setTargetUseage(erpFunLease.getLeaseUseage());
					erpFunTrack.setTargetNo(erpFunLease.getLeaseNo());
					targetNoStr = "（带看房源：" + erpFunLease.getLeaseNo() + ")";
				}
			}
			trackContent = this.generatorTrackContent(param, "带看", targetNoStr);
			taskSubject = this.generatorTaskSubject(param, "带看");
		} else if(Const.DIC_TRACK_TYPE_FUNCAN.equals(trackType)){// 房勘-3
			trackContent = this.generatorTrackContent(param, "房勘");
			taskSubject = this.generatorTaskSubject(param, "房勘");
			erpFunTrack.setTrackResult((StringUtils.isNotBlank(param.getVideoIds())) ? (byte)1 : 0);
			if (StringUtils.isNotBlank(param.getPhotoIds())) {
				erpFunTrack.setFkPhotoCount(param.getPhotoIds().split(",").length);
			}
			if (StringUtils.isNotBlank(param.getVrIds())) {
				erpFunTrack.setVrPhoto(param.getVrIds().split(",").length);
			}
		} else if (Const.DIC_TRACK_TYPE_LIMITED.equals(trackType)// 限时-6
				|| Const.DIC_TRACK_TYPE_ALONE.equals(trackType)// 独家-7
				|| Const.DIC_TRACK_TYPE_RENT.equals(trackType)// 包租-9
				|| Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT.equals(trackType)) {// 普通委托-19
			String dicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "TRACK_TYPE", trackType.toString());
			trackContent = this.generatorTrackContent(param, dicCnMsg + "委托");
			taskSubject = this.generatorTaskSubject(param, dicCnMsg + "委托");
			String proxyUrls = param.getPhotoUrls();
			if (StringUtils.isNotBlank(proxyUrls)) {
				long counts = Arrays.asList(proxyUrls.split(",")).stream().filter(val -> StringUtils.isNotBlank(val)).count();
				erpFunTrack.setProxyUrl(String.valueOf(counts));
			}
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE.equals(trackType)) {// 转有效-21
			Integer oldStatus = param.getOldStatus();
			Integer plateType = param.getCasePlateType();
			String oldStatusCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_STATUS", String.valueOf(oldStatus));
			// 修改状态颜色
			oldStatusCnMsg = "<span style='color:#259cf3;'>" + oldStatusCnMsg + "</span>";
			String statusCnMsg = "<span style='color:#259cf3;'>有效</span>";
			// 组装跟进内容
			boolean publicCase = Const.DIC_PLATE_TYPE_SHARE.equals(plateType) && param.isPrivateModel();
			String tempContent = "将该" + (publicCase ? "公盘" : "") + "信息状态由" + oldStatusCnMsg + "变更为" + statusCnMsg;
			trackContent = this.generatorTrackContentBaseBefor(param, tempContent);
			taskSubject = this.generatorTaskSubjectBaseBefor(param, tempContent);
			erpFunTrack.setCaseStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
			erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_2);// 跟进类型
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE.equals(trackType)) {// 转私盘-22
			trackContent = this.generatorTrackContentBaseBefor(param, "将该信息由抢盘变更为私盘");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "将该信息由抢盘变更为私盘");
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSSALE.equals(trackType)) {// 转售-23
			trackContent = this.generatorTrackContentBaseBefor(param, "将该出租房源转为可租售房源");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "将该出租房源转为可租售房源");
		} else if (Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE.equals(trackType)) {// 转租-24
			trackContent = this.generatorTrackContentBaseBefor(param, "将该出售房源转为可租售房源");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "将该出售房源转为可租售房源");
		} else if (Const.DIC_TRACK_TYPE_STATUS_SCHEDULE.equals(trackType)// 预订-25
				|| Const.DIC_TRACK_TYPE_STATUS_SPECIAL.equals(trackType)// 封盘-26
				|| Const.DIC_TRACK_TYPE_STATUS_RESPITE.equals(trackType)// 暂缓-27
				|| Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)// 内成交-28
				|| Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)// 外成交-29
				|| Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)// 注销-30
				|| Const.DIC_TRACK_TYPE_STATUS_AVAILABLE.equals(trackType)// 普通-50
				) {
			Byte status = param.getStatus();
			Integer caseType = param.getCaseType();
			Integer priceUnit = param.getPriceUnit();
			BigDecimal totalPrice = param.getTotalPrice();
			Integer oldStatus = param.getOldStatus();
			Integer plateType = param.getCasePlateType();
			String statusCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_STATUS", status.toString());
			String oldStatusCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_STATUS", oldStatus.toString());
			// 修改状态颜色
			oldStatusCnMsg = "<span style='color:#259cf3;'>" + oldStatusCnMsg + "</span>";
			statusCnMsg = "<span style='color:#259cf3;'>" + statusCnMsg + "</span>";
			// 组装跟进内容
			boolean publicCase = Const.DIC_PLATE_TYPE_SHARE.equals(plateType) && param.isPrivateModel();
			String tempContent = "将该" + (publicCase ? "公盘" : "") + "信息状态由" + oldStatusCnMsg + "变更为" + statusCnMsg;
			// 成交金额
			if (totalPrice != null && totalPrice.doubleValue() > 0) {
				tempContent += " 成交金额：" + totalPrice;
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
					tempContent += "万元";
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
					String dicCnMsg = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", priceUnit.toString());
					tempContent += dicCnMsg;
				}
			}
			trackContent = this.generatorTrackContentBaseBefor(param, tempContent);
			taskSubject = this.generatorTaskSubjectBaseBefor(param, tempContent);
		} else if (Const.DIC_TRACK_TYPE_VIEW_PHONE.equals(trackType)) {// 查看电话-31
			trackContent = this.generatorTrackContentBaseBefor(param, "查看核心信息");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "查看核心信息");
		} else if (Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD.equals(trackType)) {// 楼盘变更-20
			String oldBuildName = param.getCaseBuildName();
			// 修改之后的楼盘信息
			String newBuildName = param.getNewBuildName();
			if(StringUtils.isBlank(newBuildName)) {
				ErpBuildingInfoDto buildingInfo = erpBuildingInfoMapper.getInfoForChangeBuild(cityId, param.getTargetId());
				if(null == buildingInfo){
					throw new BusinessException("该楼盘信息有误，请联系在线客服");
				}
				newBuildName = buildingInfo.getBuildName();
			}
			// 修改状态颜色
			oldBuildName = "<span style='color:#259cf3;'>" + oldBuildName + "</span>";
			newBuildName = "<span style='color:#259cf3;'>" + newBuildName + "</span>";
			String tempContent = "将该信息的楼盘由" + oldBuildName + "变更为" + newBuildName;
			trackContent = this.generatorTrackContentBaseBefor(param, tempContent);
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "楼盘变更");
		} else if (Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(trackType)) {// 提交钥匙-32
			// 没有收到钥匙跟进内容不一样
			boolean isKeyTrack = (param.getKeyDeptId() != null);
			// 营销版和纯精英版通过key判断
			if(param.getTrackFromType() == 1) {
				isKeyTrack = (param.getKey() != null && param.getKey() == 1);
			}
			if (isKeyTrack) {
				trackContent = this.generatorTrackContent(param, "提交钥匙");
				taskSubject = this.generatorTaskSubject(param, "提交钥匙");
			} else {
				String createCurrUserName = param.getCreateCurrUserName();
				trackContent = createCurrUserName + " 对该房源添加了钥匙说明\n" + param.getTrackContent();
				taskSubject = createCurrUserName + " 对该房源添加了钥匙说明";
				param.setTrackType(Const.DIC_TRACK_TYPE_KEY_EXPLAIN);
				erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_KEY_EXPLAIN);
			}
		} else if (Const.DIC_TRACK_TYPE_BORROW_KEY.equals(trackType)) {// 钥匙借用-33
			trackContent = this.generatorTrackContent(param, "借用钥匙");
			taskSubject = this.generatorTaskSubject(param, "借用钥匙");
		} else if (Const.DIC_TRACK_TYPE_RETURN_KEY.equals(trackType)) {// 钥匙归还-34
			trackContent = this.generatorTrackContent(param, "归还钥匙");
			taskSubject = this.generatorTaskSubject(param, "归还钥匙");
		} else if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(trackType)) {// 钥匙注销-35
			trackContent = this.generatorTrackContentBase(param, "对该信息注销钥匙");
			taskSubject = this.generatorTaskSubjectBase(param, "对该信息注销钥匙");
		} else if (Const.DIC_TRACK_TYPE_CASE_TRANSFER.equals(trackType)) {// 公盘数据移交-54
			trackContent = this.generatorTrackContentBaseBefor(param, "移交该数据");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "移交该数据");
		} else if (Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER.equals(trackType)) {// 私盘数据移交-55
			trackContent = this.generatorTrackContentBaseBefor(param, "移交该数据");
			taskSubject = this.generatorTaskSubjectBaseBefor(param, "移交该数据");
		} else {// 普通跟进
			String currUname = param.getCreateCurrUserName();
			trackContent = currUname + "跟进\n跟进内容：" + param.getTrackContent();
			taskSubject = currUname + "对该信息提交了跟进";
		}
		param.setTaskSubject(taskSubject);
		erpFunTrack.setTrackContent(trackContent);
		return erpFunTrack;
	}

	@Transactional
	@Override
	public void createTrackForCreateAudit(ErpCreateTrackInfoParam param, ErpFunTrackExtend erpFunTrackExtend, ErpAuditRuntime auditRuntime) {
		Integer trackFromType = param.getTrackFromType();
		param.setTrackFromType(5);// 申请审核
		// 依据参数设置一些特殊信息
		this.generatorParamByParam(param);
		// 写跟进
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		erpFunTrack.setExaminTime(null);
		erpFunTrack.setTargetFlag(false);
		// 所有数量类值为0
		erpFunTrack.setDkPhotoCount(0);
		erpFunTrack.setTrackResult((byte)0);
		erpFunTrack.setFkPhotoCount(0);
		erpFunTrack.setVrPhoto(0);
		erpFunTrack.setProxyUrl(null);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		param.setTrackId(erpFunTrack.getTrackId());
		if(erpFunTrackExtend != null && null != erpFunTrackExtend.getId()) {
//			erpFunTrackExtend.setAuditId(auditRuntime.getId());
//			erpFunTrackExtend.setShardCityId(auditRuntime.getShardCityId());
			erpFunTrackExtend.setTrackId(erpFunTrack.getTrackId());
//			erpFunTrackExtendMapper.insertSelective(erpFunTrackExtend);
			erpFunTrackExtendMapper.updateByPrimaryKey(erpFunTrackExtend);
		}
		// 类型修改为原始的
		param.setTrackFromType(trackFromType);
	}

	@Transactional
	@Override
	public void writeFailAuditTrack(ErpAuditRuntime auditRuntime, Integer cityId, Integer auditUserId,
			Integer trackFromType,String trackContent) {
		ErpCreateTrackInfoParam param = generatorTrackParam(auditRuntime, cityId, auditUserId, trackFromType);
		param.setTrackContent(trackContent);
		// 把房源的信息放入参数（需要放在外面，创建审核任务时候还没进创建跟进方法要用房源信息）
		CaseInfoDto caseInfoDto = this.getCaseInfoById(param.getCityId(), param.getCaseId(), param.getCaseType());
		param.setCaseInfoDto(caseInfoDto);
		// 带看信息
		if (Const.DIC_TRACK_TYPE_DAIKAN.equals(param.getTrackType())) {
			Integer targetId = StringUtil.parseInteger(auditRuntime.getTargetIds(), 0);
			int targetType = param.getTargetType().intValue();
			CaseInfoDto targetCaseInfoDto = this.getCaseInfoById(param.getCityId(), targetId, targetType);
			param.setTargetCaseInfoDto(targetCaseInfoDto);
		}
		// 依据房客源设置一些公用信息
		this.generatorCaseInfoToParam(param);
		this.generatorParamByParam(param);
		ErpFunTrack erpFunTrack = this.generatorErpFunTrack(param);
		if (Const.DIC_TRACK_TYPE_FUNCAN.equals(param.getTrackType())) {
			erpFunTrack.setTrackContent(erpFunTrack.getTrackContent() + trackContent);
		}
		erpFunTrack.setTargetFlag(false);
		erpFunTrackMapper.insertSelective(erpFunTrack);
		this.updateFkPhotoStatusForAuditFail(param, erpFunTrack.getTrackId());
		// 审核失败写房堪更进扩展字段
		if(Const.DIC_TRACK_TYPE_FUNCAN.equals(param.getTrackType()) && null != auditRuntime.getId()){
			ErpFunTrackExtendExample example = new ErpFunTrackExtendExample();
			example.createCriteria().andAuditIdEqualTo(auditRuntime.getId());
			example.setShardCityId(cityId);
			List<ErpFunTrackExtend> trackExtendList = erpFunTrackExtendMapper.selectByExample(example);
			if(null != trackExtendList && trackExtendList.size() > 0){
				ErpFunTrackExtend erpFunTrackExtend = new ErpFunTrackExtend();
				erpFunTrackExtend = trackExtendList.get(0);
				erpFunTrackExtend.setId(null);
				erpFunTrackExtend.setAuditId(null);
				erpFunTrackExtend.setCreationTime(new Date());
				erpFunTrackExtend.setTrackId(erpFunTrack.getTrackId());
				erpFunTrackExtend.setShardCityId(cityId);
				erpFunTrackExtendMapper.insertSelective(erpFunTrackExtend);
			}
		}
	}

	/**
	 * 写审核失败跟进的时候，不需要带的图片数量等字段。清空
	 * v2：不清空了，把图片那些展示出来，和跟进相关联
	 * @author 方李骥
	 * @since 2018年2月9日
	 */
	private void updateFkPhotoStatusForAuditFail(ErpCreateTrackInfoParam param, Integer trackId) {
		Integer cityId = param.getCityId();
		String vrIds = param.getVrIds();
		String videoIds = param.getVideoIds();
		String photoIds = param.getPhotoIds();
		if (StringUtils.isNotBlank(photoIds)) {
			List<String> photoIdListTmp = Arrays.asList(photoIds.split(","));
			List<Integer> photoIdList = photoIdListTmp.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
			ErpFunPhotoExample example = new ErpFunPhotoExample();
			example.setShardCityId(cityId);
			example.createCriteria().andPhotoIdIn(photoIdList);
			ErpFunPhoto record = new ErpFunPhoto();
			record.setTrackId(trackId);
			erpFunPhotoMapper.updateByExampleSelective(record, example);
		}
		// 判断来源是否是手机端，如果是手机端判断有没有视频，有没有首图，生成缩略图，最后判断vr，vr的逻辑和图片一样
		if (StringUtils.isNotBlank(videoIds)) {
			List<String> videoUrlListTmp = Arrays.asList(videoIds.split(","));
			List<Integer> videoIdList = videoUrlListTmp.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
			ErpFunVideoExample example = new ErpFunVideoExample();
			example.setShardCityId(cityId);
			example.createCriteria().andVideoIdIn(videoIdList);
			ErpFunVideo erpFunVideo = new ErpFunVideo();
			erpFunVideo.setShardCityId(cityId);
			erpFunVideo.setVideoStatus(0);
			erpFunVideo.setTrackId(trackId);
			erpFunVideoMapper.updateByExampleSelective(erpFunVideo, example);
		}
		if (StringUtils.isNotBlank(vrIds)) {
			List<String> vrUrlListTemp = Arrays.asList(vrIds.split(","));
			List<Integer> vrUrlList = vrUrlListTemp.stream().collect(Collectors.mapping(val -> StringUtil.parseInteger(val, 0), Collectors.toList()));
			// 修改跟进ID
			ErpFunPanoramaPhotoExample vrExample = new ErpFunPanoramaPhotoExample();
			vrExample.setShardCityId(cityId);
			vrExample.createCriteria().andPhotoIdIn(vrUrlList);
			ErpFunPanoramaPhoto recordUp = new ErpFunPanoramaPhoto();
			recordUp.setTrackId(trackId);
			erpFunPanoramaPhotoMapper.updateByExampleSelective(recordUp, vrExample);
		}
	}
	
	public static void main(String[] args) {
//		Map<String, Object> content = new HashMap<>();
//		content.put("cityId", "1");
//		content.put("reserveId", "49");
//		content.put("busType","5");
//		content.put("dkUserId", "20075283");
//		// 扩展字段，增加哪一个工作量，和数据库表字段名一致
//		// 增加的量，大于1时caseId是个数组[12,56,46]
//		// 组装消息的发送
//		String url = "http://youjia.haofang.net/Home/MyInfo/sendEvaTempMsg";
//		String post = HttpUtil.post(url, content);
//		System.out.println(post);
		BigDecimal divide = new BigDecimal(0);
		BigDecimal divide1 = new BigDecimal(0);
		BigDecimal divide2 = new BigDecimal(18);
		divide = divide1.divide(divide2,2, BigDecimal.ROUND_HALF_UP);
		System.out.println(divide);
	}

	/**
	 * 新版首页带看热度
	 *@author 朱科
	 *@param
	 *@return List<Map<String,Object>>
	 *@since 2018年3月8日
	 */
	@Override
	@AccessReadonlyDb
	public List<Map<String, Object>> getBasicDaiKanHotrank(Integer cityId, Integer compId, Integer userId,
			String startTime, Integer houseCust) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		// 查询数据
		List<Map<String, Object>> trackList = null;
		if (houseCust == 1) {
			trackList = erpFunTrackMapper.getBasicDaiKanHotrankHouse(cityId, compId, userId, startTime);
		} else if (houseCust == 2) {
			trackList = erpFunTrackMapper.getBasicDaiKanHotrankCust(cityId, compId, userId, startTime);
		}
		Map<Integer, List<Map<String, Object>>> caseTypeList = trackList.stream()
				.collect(Collectors.groupingBy(map -> StringUtil.parseInteger(map.get("caseType"), 0)));
		if (caseTypeList.isEmpty()) {
			return null;
		}
		for (Integer caseType : caseTypeList.keySet()) {
			List<Map<String, Object>> caseList = caseTypeList.get(caseType);
			if (caseList == null || caseList.isEmpty()) {
				continue;
			}
			Set<Integer> caseIdList = caseList.stream().collect(
					Collectors.mapping(map -> StringUtil.parseInteger(map.get("caseId"), 0), Collectors.toSet()));
			if (caseIdList != null && caseIdList.size() > 0) {
				Map<Integer, Map<String, Object>> caseListMap = caseList.stream()
						.collect(Collectors.toMap(key -> StringUtil.parseInteger(key.get("caseId"), 0), val -> val));
				Map<String, Object> caseMap = new HashMap<>();
				caseMap.put("caseIdList", caseIdList);
				caseMap.put("caseType", caseType);
				List<Map<String, Object>> erpFunCaseList = erpFunSaleMapper.getCaseListCut(cityId, caseMap);
				for (Map<String, Object> caseData : erpFunCaseList) {
					Integer saleId = StringUtil.parseInteger(caseData.get("caseId"), 0);
					Map<String, Object> map = caseListMap.get(saleId);
					if (map != null) {
						caseData.put("daikanCount", StringUtil.parseInteger(map.get("counts"), 0));
					}
				}
				resultList.addAll(erpFunCaseList);
			}
		}
		return resultList;
	}

	/**
	* @author 邓永洪
	* @since 2018/4/24
	* @tag 写跟进,移交数据用
	*/
	@Transactional
	@Override
	public void createTrackForTransData(Integer cityId, ErpFunUsers acceptUser, Integer caseType, List<Integer> caseIds,
										String[] caseNos, Byte plateType, DataTranslateParam param) {
		// 数据移交 -->（内成交、外成交、封盘、预定、暂缓、电话查看）状态的审核任务都要变为失效
		String srcUserId = param.getSrcUserId();
		for (int i = 0; i < caseIds.size(); i++) {
			erpFunTaskService.cancelAuditTaskForWriteoff(cityId, param.getCompId(), caseIds.get(i), caseType, Const.DIC_TRACK_TYPE_CASE_TRANSFER);
		}
		// 转盘或分配（查数据的盘别，私盘就是分配、抢盘或公盘就是转盘）
		if (acceptUser != null && acceptUser.getUserId() != null) {
			StatisticDetailType countType = null;
			// 转盘（有限私盘制下统计）
			if (("public".equalsIgnoreCase(srcUserId) || "share".equalsIgnoreCase(srcUserId))
					&& erpSysParaService.getSysRunModelIsPrivate(caseType, cityId, param.getCompId())) {
				countType = StatisticDetailType.ZP_COUNT;
			} else {
				// 分配(私盘移交（公盘制/公房制下数据移交均算为分配）)
				countType = StatisticDetailType.FP_COUNT;
			}
			this.sendJmsMessageForWorkCount(cityId, countType, new Date(), acceptUser.getUserId(), caseType,
					StringUtil.intArr2String(caseIds.toArray(new Integer[]{}), ","), null, caseIds.size(),
					null, null);
		}
		String trackContent = this.buildTrackContentForTransData(param, acceptUser, plateType);
		Integer tempSrcUserId = null;
		if ("public".equalsIgnoreCase(srcUserId) || "share".equalsIgnoreCase(srcUserId)) {
			tempSrcUserId = StringUtil.paseInteger(srcUserId);
		}
		int i = 0;
		while (i < caseIds.size()) {
			List<ErpFunTrack> trackList = new ArrayList<>();
			for (int j = 0; j < 500 && i < caseIds.size(); i++, j++) {// insert语句最大允许1000条记录同时写入
				ErpFunTrack funTrack = new ErpFunTrack();
				funTrack.setCreationTime(getTimeNow());
				funTrack.setCreatorUid(param.getCurrentUserId());
				funTrack.setCompId(param.getCompId());
				funTrack.setDeptId(param.getDeptId());
				funTrack.setCaseType(caseType.byteValue());
				funTrack.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
				funTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_2);
				funTrack.setTrackWarm(false);
				funTrack.setTrackContent(trackContent);
				funTrack.setCaseId(Integer.valueOf(caseIds.get(i)));
				funTrack.setCaseNo(caseNos[i]);
				funTrack.setCaseDeptId(param.getSrcDeptId());
				funTrack.setCaseUserId(tempSrcUserId);
				trackList.add(funTrack);
			}
			erpFunTrackMapper.insertFunTrackByList(param.getCityId(), trackList);
		}
	}

	/**
	* @author 邓永洪
	* @since 2018/4/24
	* @tag 生成跟进内容,数据移交用
	*/
	private String buildTrackContentForTransData(DataTranslateParam param, ErpFunUsers acceptUser, Byte plateType) {
		String sourceUserDeptName = "";
		String sourceUser = "";
		String transReson = param.getTransReson();
		ErpFunDepts srcDeptsPO = erpFunDeptsMapper.getByDeptId(param.getCityId(),param.getSrcDeptId());
		if (param.getSrcUserId().equalsIgnoreCase("public")) {
			sourceUser = "抢盘";
		} else if (param.getSrcUserId().equalsIgnoreCase("share")) {
			sourceUser = "公盘";
		} else {
			ErpFunUsers srcUsersPO = erpFunUsersMapper.getUserInfoByUserId(param.getCityId(),StringUtil.paseInteger(param.getSrcUserId()));//移交数据的来源
			if(srcUsersPO == null){
				sourceUser = " 的";
			} else {
				sourceUser = srcUsersPO.getUserName() + "的";
			}
		}
		sourceUserDeptName = srcDeptsPO.getDeptName() +" ";

		String destUser = "抢盘";
		if(Const.DIC_PLATE_TYPE_SHARE.equals(StringUtil.parseInteger(plateType))) {
			destUser = "公盘";
		}
		String destUserDeptName = "";
		if(!CommonUtil.isnull(acceptUser)){
			destUser = acceptUser.getUserName();
			destUserDeptName = erpFunDeptsMapper.getByDeptId(param.getCityId(),acceptUser.getDeptId()).getDeptName();
		}else if(!CommonUtil.isnull(param.getAcceptDeptId())){
			destUserDeptName =  erpFunDeptsMapper.getByDeptId(param.getCityId(),param.getAcceptDeptId()).getDeptName();
		}
		String trackContent = param.getCurrentDeptName()+" "+param.getCurrentUserNamme() + " 将该 " + sourceUserDeptName + " " + sourceUser + " 信息移交给 " + destUserDeptName +" "+ destUser + "\n移交原因：" + transReson;
		return trackContent;
	}

	@Transactional
	@Override
	public Map<String, Object> writeTrackInfoToDeal(Integer cityId, ErpFunDeal dealModel, String trackContent, InsertDealInfoParam param) {
		Map<String, Object> returnMap = new HashMap<>();
		List<ErpFunTrack> trackList = new ArrayList<>();
		returnMap.put("trackList", trackList);
		Integer houseCaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		Integer custCaseType = Const.DIC_CASE_TYPE_BUY_CUST;
		if (dealModel.getDealType().equals(Const.DIC_CASE_TYPE_RENT_DEAL.byteValue())) {
			houseCaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
			custCaseType = Const.DIC_CASE_TYPE_RENT_CUST;
		}
		String caseTrackContent = buildTrackContentForCreateDeal(dealModel, dealModel.getDealHouseNo(), houseCaseType, dealModel.getDealCustomerNo(), custCaseType, param);
		if (StringUtils.isNotBlank(trackContent)) {
			caseTrackContent += "\n 跟进内容:" + trackContent;
		}
		// 出租房源走内成交的时候 trackContent 没有取的,在后面拼租期截止
		if (dealModel.getDealType().equals(Const.DIC_CASE_TYPE_RENT_DEAL.byteValue())) {
			caseTrackContent += "\n 跟进内容:" + "租期截止: " + param.getRentOverDate();
		}

		// 2.给房源方写跟进和提醒任务(只提醒房源业务员),如果勾选了提醒任务,需要额外给自己创建一条提醒任务
		Integer caseId = dealModel.getDealHouseId();
		String caseNo = dealModel.getDealHouseNo();
		Integer caseType = houseCaseType;
		Integer caseUserId = dealModel.getHouseUserUid();
		
		// 房基地的出售房源会让出租变成暂缓
		if (null != caseId && param.isFangJidi() && houseCaseType == Const.DIC_CASE_TYPE_SALE_FUN) {
			writeRespiteTrack(cityId, caseId, param);
		}
		
		if (null != caseId && null != caseUserId) {
			createTrackAndTask(cityId, caseType, caseId, caseNo, caseUserId, dealModel, caseTrackContent, returnMap, param);

		} else if (caseId != null && null == caseUserId) {
			// 公盘的房源
			writeTrack(cityId, param.getSelfUserId(), caseType, caseId, caseNo, caseTrackContent, dealModel.getDealId(),returnMap);
		}
		// 3.给客源方写跟进和提醒任务(只提醒客源业务员),如果勾选了提醒任务,需要额外给自己创建一条提醒任务
		caseId = dealModel.getDealCustomerId();
		caseUserId = dealModel.getCustUserUid();
		caseNo = dealModel.getDealCustomerNo();
		caseType = custCaseType;
		if (!CommonUtil.isnull(caseId) && !CommonUtil.isnull(caseUserId)) {
			this.createTrackAndTask(cityId, caseType, caseId, caseNo, caseUserId, dealModel, caseTrackContent, returnMap, param);
		} else if (!CommonUtil.isnull(caseId) && CommonUtil.isnull(caseUserId)) {
			// 公盘的客源
			writeTrack(cityId, param.getSelfUserId(), caseType, caseId, caseNo, caseTrackContent, dealModel.getDealId(),returnMap);
		}
		return returnMap;
	}

	/***
	 * 写暂缓跟进
	 * @param cityId
	 * @param caseId
	 * @param param
	 */
	private void writeRespiteTrack(Integer cityId,Integer caseId, InsertDealInfoParam param) {
		ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(new ErpFunSale(cityId, caseId));
		if (erpFunSale.getSaleLeaseId() != null && Byte.valueOf("1").equals(erpFunSale.getIsSaleLease())) {
			ErpFunLease updateModel = new ErpFunLease();
			updateModel.setLeaseId(erpFunSale.getSaleLeaseId());
			updateModel.setLeaseStatus((int)Const.HouseCustStatus.DIC_STATUS_RESPITE);
			updateModel.setShardCityId(cityId);
			erpFunLeaseMapper.updateByPrimaryKeySelective(updateModel);
			ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(new ErpFunLease(param.getCityId(), erpFunSale.getSaleLeaseId()));
			// 写跟进
			String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
			ErpFunTrack erpFunTrack = new ErpFunTrack();
			erpFunTrack.setShardCityId(cityId);
			erpFunTrack.setCaseDeptId(erpFunLease.getDeptId());
			erpFunTrack.setCaseId(erpFunLease.getLeaseId());
			erpFunTrack.setCaseNo(erpFunLease.getLeaseNo());
			erpFunTrack.setCaseStatus(Const.HouseCustStatus.DIC_STATUS_RESPITE);
			erpFunTrack.setCaseType(Const.HouseCustType.LEASE);
			erpFunTrack.setCaseUserId(erpFunLease.getUserId());
			erpFunTrack.setCompId(erpFunLease.getCompId());
			erpFunTrack.setCreationTime(timeNow);
			erpFunTrack.setCreatorUid(param.getSelfUserId());
			erpFunTrack.setDeptId(param.getSelfDeptId());
			erpFunTrack.setIncludeTrack(null);
			erpFunTrack.setTrackClassic(Const.DIC_TRACKCLASSIC_1);
			erpFunTrack.setTrackContent("跟进内容：该租售房源已出售成交，出租自动更改为暂缓！");
			erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_STATUS_RESPITE);
			erpFunTrack.setUseage(erpFunLease.getLeaseUseage());
			if(null != param.getSelfDeptId()) {
				ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getSelfDeptId());
				erpFunTrack.setDeptName(byDeptId.getDeptCname());
			}
			Integer grId = param.getSelfGrId();
			erpFunTrack.setGrId(grId);// 分组
			if(null != grId && grId > 0) {
				ErpFunDeptsgroup dataByGrId = erpFunDeptsgroupMapper.getDataByGrId(param.getCityId(), grId);
				erpFunTrack.setGrName(dataByGrId.getGrName());
			}
			erpFunTrackMapper.insertSelective(erpFunTrack);
		}
	}
	
	/**
	 * @tag 撤销合同创建房客源跟进
	 * @author 邓永洪
	 * @since 2018/6/15
	 */
	@Transactional
	@Override
	public void createTrackForUndoDeal(GeneralParam generalParam, ErpFunDeal deal) {
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(deal.getDealType().intValue())) {
			Integer houseId = deal.getDealHouseId();
			if (null != houseId) {
				ErpFunTrack insertModel = createTrackPOForDeal(generalParam, Const.DIC_CASE_TYPE_SALE_FUN, houseId, deal.getDealHouseNo(),
						deal.getHouseDeptId(), Const.DIC_HOUSE_STATUS_AVAILABLE);
				erpFunTrackMapper.insertSelective(insertModel);
			}
			Integer custId = deal.getDealCustomerId();
			if (null != custId) {
				ErpFunTrack insertModel = createTrackPOForDeal(generalParam, Const.DIC_CASE_TYPE_BUY_CUST, custId, deal.getDealCustomerNo(),
						deal.getCustDeptId(), Const.DIC_HOUSE_STATUS_AVAILABLE);
				erpFunTrackMapper.insertSelective(insertModel);
			}
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(deal.getDealType().intValue())) {
			Integer houseId = deal.getDealHouseId();
			if (null != houseId) {
				ErpFunTrack insertModel = createTrackPOForDeal(generalParam, Const.DIC_CASE_TYPE_LEASE_FUN, houseId, deal.getDealHouseNo(),
						deal.getHouseDeptId(), Const.DIC_HOUSE_STATUS_AVAILABLE);
				erpFunTrackMapper.insertSelective(insertModel);
			}
			Integer custId = deal.getDealCustomerId();
			if (null != custId) {
				ErpFunTrack insertModel = createTrackPOForDeal(generalParam, Const.DIC_CASE_TYPE_RENT_CUST, custId, deal.getDealCustomerNo(),
						deal.getCustDeptId(), Const.DIC_HOUSE_STATUS_AVAILABLE);
				erpFunTrackMapper.insertSelective(insertModel);
			}
		}
	}

	/**
	 * 求租客源写跟进
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/11
	 */	
	@Transactional
	@Override
	public void writeTrackByCreateHouseInfo(ErpFunRentCustomerParam param) {
		Byte trackType = Const.DIC_TRACK_TYPE_OTHER;
		String includeTrackType = Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER;
		String caseNo="";
		String cellPhone = param.getCellPhone();
		String trackContent = this.getCurrUserName(getOperator().getDeptName(),getOperator().getUserName(),getOperator().getCompType(),getOperator().isPersonalVersion()) + "于本日对该";
		String trackClassic = "";
		String addrRepaeatNos = null;
		String phoneRepaeatNos = null;
		String trackTypeStr = null;
		Integer caseUserId = param.getUserId();

		caseNo=param.getRentCustNo();
		Integer caseId=param.getRentCustId();
		Byte houseLevel = param.getRentCustLevel();
		Integer caseType=Const.DIC_CASE_TYPE_RENT_CUST;
		trackContent += this.transferTrackType(StringUtil.parseInteger(param.getPlateType()))+ "客源";
		trackTypeStr = "求租客源";
		trackClassic = Const.DIC_TRACKCLASSIC_9;


		Map<String, String> phoneRepeatMap = erpFunSaleService.detectPhoneRepeat(param.getCityId(),param.getCompId(),param.getRentCustId(),
				caseType,cellPhone.split(","), null,getOperator().isPersonalVersion(),param.getCreatorUid(),
				param.getDeptId(),param.getAreaId(),param.getRegId(),param.getDeptId(),param.getGrId());
		phoneRepaeatNos = phoneRepeatMap.get("CASE_NOS");
		String siteName = param.getSiteName();//发发房源导入时的站点说明.为空串说明不是来自发发导入.
		if(!"".equals(siteName)){
			siteName = "该房源从发发站点"+siteName+"导入。";
		}
		if(Const.DIC_HOUSE_LEVEL_PASSWORD.equals(houseLevel)) {
			trackContent += "（加密）";
		} else if(Const.DIC_HOUSE_LEVEL_COMMEND.equals(houseLevel)) {
			trackContent += "（推荐）";
		}
		trackContent += "进行登记！" + siteName;
		String ruleFlag = param.getRuleFlag();
		// 来源于楼盘资料
		if ("FROM_RULE".equals(ruleFlag)) {
			Integer entityId = param.getEntityId();
			//TODO
//			Condition condition = new Condition();
//			condition.add(new ConditionItem("BUILD_RULE_ID", "=", entityId));
//			List<ErpFunBuildTrack> funtrackPos = erpFunBuildTrackMapper.getFunBuildTrackById();
//			if (funtrackPos != null && !funtrackPos.isEmpty()) {
//				StringBuilder trackSql = new StringBuilder("INSERT INTO FUN_TRACK(TRACK_ID,CASE_ID,CASE_TYPE,TRACK_TYPE,TRACK_CLASSIC,TRACK_CONTENT,CASE_NO,CASE_STATUS,TRACK_WARM,CREATION_TIME,COMP_ID,DEPT_ID,CREATOR_UID,CASE_USER_ID,CASE_DEPT_ID) VALUES");
//				for (int i = 0; i < funtrackPos.size(); i++) {
//					FunBuildTrackPO funBuildTrackPO = funtrackPos.get(i);
//					if (i > 0) {
//						trackSql.append(",");
//					}
//					trackSql.append(" ((NEXT VALUE FOR SEQ_FUN_TRACK_TRACK_ID),'" + caseId + "','" + caseType + "','"
//							+ Constants_DIC.DIC_TRACK_TYPE_OTHER + "'," + "'" + Constants_DIC.DIC_TRACKCLASSIC_1
//							+ "','来源于楼盘资料:" + funBuildTrackPO.getTRACK_CONTENT() + "','" + caseNo + "','"
//							+ Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE + "','0','" + funBuildTrackPO.getTRACK_TIME()
//							+ "','" + getOperator().getCompId() + "','" + getOperator().getDeptId() + "','"
//							+ funBuildTrackPO.getCREATE_UID() + "'," + caseUserId + "," + housePO.getDEPT_ID() + ")");
//				}
//				SQL sql = new SQL(SQL.UPDATE, trackSql.toString(), null);
//				dao.execute(sql);
//			}
//			FunBuildTrackPO funBuildTrack = new FunBuildTrackPO();
//			funBuildTrack.setTRACK_TIME(getTimeNow());
//			funBuildTrack.setCOMP_ID(getOperator().getCompId());
//			funBuildTrack.setBUILD_RULE_ID(entityId);
//			funBuildTrack.setTRACK_CONTENT("此信息由 " + funUsersService.getCurrUserName() + " 转到了" + trackTypeStr + ".");
//			funBuildTrack.setCREATE_UID(getOperator().getUserId());
//			funBuildTrack.setTRACK_TYPE(caseType);
//			funBuildTrackService.writeTrack(funBuildTrack);
		}
	}

	@Transactional
	@Override
	public void writeTrackInfoToMgrProfit(Integer cityId, InsertDealInfoParam param, ErpFunDeal dealPO) {
		Integer houseId=dealPO.getDealHouseId();
		String houseNo=dealPO.getDealHouseNo();
		Integer houseUserId=dealPO.getHouseUserUid();
		Integer custId=dealPO.getDealCustomerId();
		String custNo=dealPO.getDealCustomerNo();
		Integer custUserId=dealPO.getCustUserUid();
		// 跟进内容都是一样的
		Integer houseCaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		Integer custCaseType = Const.DIC_CASE_TYPE_BUY_CUST;
		if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(StringUtil.parseInteger(dealPO.getDealType()))) {
			houseCaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
			custCaseType = Const.DIC_CASE_TYPE_RENT_CUST;
		}
		String trackContent = buildTrackContentForCreateDeal(dealPO, houseNo, houseCaseType, custNo, custCaseType,param);
		// 2.给房源方写跟进和提醒任务(只提醒房源业务员),如果勾选了提醒任务,需要额外给自己创建一条提醒任务

		Integer caseType = houseCaseType;
		if (houseId!=null && houseUserId!=null) {
			this.createTrackAndTask(cityId,caseType, houseId, houseNo, houseUserId, dealPO, trackContent, null,param);
		}
		// 3.给客源方写跟进和提醒任务(只提醒客源业务员),如果勾选了提醒任务,需要额外给自己创建一条提醒任务
		if (custId!=null && custUserId!=null) {
			this.createTrackAndTask(cityId,custCaseType, custId, custNo, custUserId, dealPO, trackContent, null,param);
		}
	}

	/**
	 * @tag 为合同创建房客源跟进
	 * @author 邓永洪
	 * @since 2018/6/15
	 */
	private ErpFunTrack createTrackPOForDeal(GeneralParam generalParam, Integer caseType, Integer caseId, String caseNo,Integer caseDeptId, Byte caseStatus) {
		Map<String, Integer> userDeptMap = getUserAndDeptByCaseIdOffCaseType(generalParam.getCityId(), caseType, caseId);
		ErpFunTrack insertModel = new ErpFunTrack();
		insertModel.setCompId(generalParam.getCompId());
		insertModel.setDeptId(caseDeptId);
		insertModel.setCaseId(caseId);
		insertModel.setCaseNo(caseNo);
		insertModel.setCaseType(caseType.byteValue());
		insertModel.setCaseStatus(caseStatus);
		insertModel.setTrackType(Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE);
		insertModel.setTrackClassic(Const.DIC_TRACKCLASSIC_2);
		insertModel.setExaminTime(getTimeNow());
		insertModel.setTrackContent(createTrackContent(caseType, generalParam.getUserName(),caseNo, caseStatus));
		insertModel.setTrackType((byte)0);
		insertModel.setCreatorUid(generalParam.getUserId());
		insertModel.setCreationTime(getTimeNow());
		insertModel.setCaseUserId(userDeptMap.get("userId"));
		insertModel.setCaseDeptId(userDeptMap.get("deptId"));
		insertModel.setShardCityId(generalParam.getCityId());
		return insertModel;
	}

	private String createTrackContent(Integer caseType,String userName , String caseNo, Byte caseStatus) {
		String caseTypeCN = caseTypeChineseMap.get(caseType);
		String caseStatusCN = caseStatusChineseMap.get(caseStatus);
		String result = "编号为 " + caseNo + " 的 " + caseTypeCN + " 由 " + userName + " 更改为 " + caseStatusCN;
		return result;
	}
	/**
	 * @tag 只是公盘房源成交跟进，没有userId
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private void writeTrack(Integer cityId, Integer userId, Integer caseType, Integer caseId, String caseNo,
							String caseTrackContent, Integer dealId,Map<String, Object> returnMap ) {
		Integer deptId = null;
		Integer compId = null;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale baseInfoFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if (null != baseInfoFunSale) {
				compId = baseInfoFunSale.getCompId();
				deptId = baseInfoFunSale.getDeptId();
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if (null != funLease) {
				compId = funLease.getCompId();
				deptId = funLease.getDeptId();
			}
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer funBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			if (null != funBuyCustomer) {
				compId = funBuyCustomer.getCompId();
				deptId = funBuyCustomer.getDeptId();
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer funRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			if (null != funRentCustomer) {
				compId = funRentCustomer.getCompId();
				deptId = funRentCustomer.getDeptId();
			}
		}
		//跟进
		ErpFunTrack track = new ErpFunTrack();
		track.setCompId(compId);
		track.setDeptId(deptId);
		track.setCaseType(caseType.byteValue());
		track.setCaseId(caseId);
		track.setDealId(dealId);
		track.setCaseNo(caseNo);
		track.setTargetFlag(true);
		track.setTrackType(Const.DIC_TRACK_TYPE_STATUS);
		track.setTrackClassic(Const.DIC_TRACKCLASSIC_2);
		track.setCaseStatus(Const.DIC_HOUSE_STATUS_INNERDEAL);
		track.setTrackContent(caseTrackContent);
		track.setCreatorUid(userId);
		track.setCreationTime(getTimeNow());
		track.setShardCityId(cityId);
		erpFunTrackMapper.insertSelective(track);
		erpAuditRuntimeService.cancelAuditTask4InnerOrOutBargain(cityId,compId,caseType,caseId,track.getTrackType());
		if (returnMap != null) {
			List trackList = (List) returnMap.get("trackList");
			trackList.add(track);
		}
	}

	/**
	 * @tag 该方法只用于成交合同类的操作
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private void createTrackAndTask(Integer cityId, Integer caseType, Integer caseId, String caseNo, Integer caseUserId,
									ErpFunDeal funDeal, String trackContent, Map<String, Object> returnMap, InsertDealInfoParam param) {
		boolean trackWarm = param.getIsTrackWarm();
		String workContent = param.getWarmContent();
		String warmTime = param.getWarmTime();
		param.setCityId(cityId);
		ErpFunUsers funUsers = erpFunUsersMapper.getUserInfoByUserId(cityId, caseUserId);
		if(null == funUsers) {
			return;
		}
		Map<String, Integer> resultMap = getUserAndDeptByCaseIdOffCaseType(cityId, caseType, caseId);
		//跟进
		ErpFunTrack track = new ErpFunTrack();
		track.setCompId(funUsers.getCompId());
		track.setDeptId(funUsers.getDeptId());
		track.setCaseType(caseType.byteValue());
		track.setCaseId(caseId);
		track.setDealId(funDeal.getDealId());
		track.setCaseNo(caseNo);
		track.setTargetFlag(true);
		track.setTrackType(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL);
		track.setTrackClassic(Const.DIC_TRACKCLASSIC_2);
		track.setCaseStatus(Const.DIC_HOUSE_STATUS_INNERDEAL);
		track.setTrackContent(trackContent);
		erpAuditRuntimeService.cancelAuditTask4InnerOrOutBargain(cityId,param.getCompId(),caseType,caseId,track.getTrackType());
		if (trackWarm && caseType.equals(param.getCaseType())) {
			trackWarm = true;
		} else {
			trackWarm = false;
		}
		track.setTrackWarm(trackWarm);
		track.setWarmContent(workContent);
		track.setWarmTime(warmTime);
		track.setCreatorUid(param.getSelfUserId());
		track.setCaseUserId(caseUserId);
		track.setCaseDeptId(resultMap.get("deptId"));
		track.setCreationTime(getTimeNow());
		track.setShardCityId(cityId);
		erpFunTrackMapper.insertSelective(track);
		if (returnMap != null) {
			List trackList = (List) returnMap.get("trackList");
			trackList.add(track);
		}
		Integer trackId = track.getTrackId();

		// 出租房源转内成交,选择需要合同,生成出租房源到期提醒任务,发送短信
		if (funDeal.getDealType().equals(Const.DIC_CASE_TYPE_RENT_DEAL.byteValue())) {
			ErpFunTask funTask = new ErpFunTask();
			String dueTime = param.getRentOverDate();
			String rentOverDate = param.getRentOverDate();

			if (StringUtils.isBlank(dueTime)) {
				return;
			}

			String rentPayEarly = funDeal.getRentPayEarly();
			if (StringUtils.isNotBlank(rentPayEarly)) {
				int warmDays = Integer.valueOf(rentPayEarly.replace("提前", "").replace("天", ""));
				dueTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addDays(DateTimeHelper.parseToDate(dueTime), -warmDays), "yyyy-MM-dd");
				rentOverDate = DateTimeHelper.formatDateTimetoString(rentOverDate, "yyyy-MM-dd");
			}

			String subject = "";
			if (caseType == 2) {
				ErpFunLease erpFunLease = new ErpFunLease();
				erpFunLease.setShardCityId(cityId);
				erpFunLease.setLeaseId(caseId);
				erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
				String buildName = erpFunLease.getBuildName();
				Byte leaseRoom = erpFunLease.getLeaseRoom();
				subject = "你成交 " + buildName + " " + (leaseRoom == null ? "" : leaseRoom + "室 ") + "的房源租赁合同将于" + rentOverDate + "到期，请及时跟进客户挖掘需求";
			} else if (caseType == 4) {
				ErpFunRentCustomerKey erpFunRentCustomerKey = new ErpFunRentCustomerKey();
				erpFunRentCustomerKey.setShardCityId(cityId);
				erpFunRentCustomerKey.setRentCustId(caseId);
				ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(erpFunRentCustomerKey);

				String rentCustName = erpFunRentCustomer.getRentCustName();
				// true=先生 false=女士
				Boolean rentCustSex = Optional.ofNullable(erpFunRentCustomer.getRentCustSex()).orElse(true);
				// 你成交 李先生 的租赁合同将于YYYY-MM-DD到期，请及时跟进客户挖掘需求
				subject = "你成交 " +  rentCustName + (rentCustSex ? "先生" : "女士") + " 的租赁合同将于" + rentOverDate + "到期，请及时跟进客户挖掘需求";
			} else {
				subject = Const.DIC_TASK_TYPE_LEASE_REMIND_STR + " 该出租房源合同将于" + DateTimeHelper.formatDateTimetoString(rentOverDate, "yyyy-MM-dd") + "到期";
			}

			funTask.setWarmTime(dueTime + " 14:00:00");
			funTask.setCaseId(track.getCaseId());
			funTask.setCaseNo(track.getCaseNo());
			funTask.setCaseType(track.getCaseType());
			funTask.setTrackId(track.getTrackId());
			funTask.setTrackType(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL);
			funTask.setTaskSubject(subject);
			funTask.setTaskDesc(subject);
			Integer caseDeptId = funUsers.getDeptId();
			// 如果是公盘数据的话就提醒 写成交的用户
			if (caseUserId == null) {
				caseUserId = param.getSelfUserId();
				caseDeptId = param.getSelfDeptId();
			}
			funTask.setTaskOwner(caseUserId);
			funTask.setDeptId(caseDeptId);
			funTask.setCompId(track.getCompId());
			funTask.setTaskType(Const.DIC_TASK_TYPE_LEASE_REMIND);
			funTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
			funTask.setTrackWarm(true);
			funTask.setIndexShow(1);
			funTask.setIsRead(false);
			funTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
			funTask.setCreatorUid(param.getSelfUserId());
			funTask.setCreationTime(DateTimeHelper.getTimeNow());
			funTask.setShardCityId(funUsers.getCityId().intValue());
			funTask.setCaseId(caseId);
			funTask.setCaseType(caseType.byteValue());
			erpFunTaskService.insertTask(funUsers.getCityId().intValue(), funTask, (byte) 0);
		}

		// xxx店xx人 将你 英郡 2室 69㎡ 70万 房源修改为内成交，并生成买卖(租赁)合同
		// xxx店xx人 将你 李先生求购2-3室 60-90㎡ 的客户修改为内成交，并生成买卖(租赁)合同
		List<AdminFunUserMessage> messages = erpFunTaskService.createTask(cityId, track.getCompId(), param.getSelfDeptId(), param.getSelfUserName(),
				funDeal.getDealType(), caseId, caseNo, caseType, param.getSelfUserId(), funUsers.getArchiveId(), caseUserId,
				funDeal.getDealId(), funDeal.getContractNo());

		ErpFunUsers user = erpFunUsersMapper.selectByUserId(cityId, caseUserId);
		if (user != null) {
			if (messages != null && messages.size() > 0 && returnMap != null) {
				returnMap.put("messages", messages);
			}
		}

		if (returnMap != null) {
			returnMap.put("HOUSE_TRACK_WARM", trackWarm);
			if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				returnMap.put("HOUSE_TRACK", trackId);
			} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
				returnMap.put("CUST_TRACK", trackId);
			}
		} else {
			//租期到期提醒
			if (funDeal.getDealType().equals(Const.DIC_CASE_TYPE_RENT_DEAL.byteValue())) {
				erpFunTaskService.rentOverWarmTask(track, caseUserId, funUsers.getDeptId(), param);
			}
			if (trackWarm) {
				createTrackWarmTask(track, param);
			}
			//提醒
			if (!param.getSelfUserId().equals(caseUserId)) {
				ErpFunTask funTask = new ErpFunTask();
				funTask.setTrackId(trackId);
				funTask.setCaseId(caseId);
				funTask.setCaseNo(caseNo);
				funTask.setCaseType(caseType.byteValue());
				funTask.setTrackType(track.getTrackType());
				String taskDesc = buildTaskSubject(caseNo, caseType, param.getSelfUserName());
				funTask.setTaskDesc(taskDesc);
				funTask.setTaskSubject(Const.DIC_TASK_TYPE_BARGAIN_REMIND_STR + " " + taskDesc);
				funTask.setCompId(funUsers.getCompId());
				funTask.setDeptId(funUsers.getDeptId());
				funTask.setTaskOwner(param.getSelfUserId());
				funTask.setTaskType(Const.DIC_TASK_TYPE_BARGAIN_REMIND);
				funTask.setTypeFlag((byte) 0);
				funTask.setTrackWarm(false);
				funTask.setIndexShow(1);
				funTask.setWarmTime(getTimeNow());
				funTask.setIsRead(false);
				funTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
				funTask.setCreatorUid(param.getSelfUserId());
				funTask.setCreationTime(getTimeNow());
				erpFunTaskService.insertTask(funUsers.getCityId().intValue(), funTask, (byte) 0);
			}
		}
	}

	/**
	 * @tag 该方法只用于成交合同类的操作
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private String buildTaskSubject(String caseNo, Integer caseType, String userName) {
		String caseTypeStr = "";
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			caseTypeStr = "出售房源";
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			caseTypeStr = "出租房源";
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			caseTypeStr = "求购客源";
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			caseTypeStr = "求租客源";
		}
		return userName + " 将您的编号为 " + caseNo + " 的 " + caseTypeStr + " 更改为内成交";
	}

	/**
	 * @tag 生成跟进提醒任务
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private void createTrackWarmTask(ErpFunTrack track, InsertDealInfoParam param) {
		String warmTime = track.getWarmTime();
		if (CommonUtil.isnull(warmTime)) {
			throw new BusinessException("勾选了跟进提醒时，请设置提醒时间！");
		}
		String taskName = track.getWarmContent();
		if (CommonUtil.isnull(taskName)) {
			throw new BusinessException("勾选了跟进提醒时，请填写提醒内容！");
		}
		if (taskName.length() > 50) {
			taskName = format_Str(taskName, 50);
		}
		ErpFunTask funTask = new ErpFunTask();
		funTask.setCaseId(track.getCaseId());
		funTask.setCaseNo(track.getCaseNo());
		funTask.setCaseType(track.getCaseType());
		funTask.setTrackId(track.getTrackId());
		funTask.setTrackType(track.getTrackType());
		funTask.setTaskSubject("[ 跟进提醒 ] " + taskName);
		funTask.setTaskDesc(taskName);
		funTask.setCompId(param.getSelfCompId());
		funTask.setDeptId(param.getSelfDeptId());
		funTask.setTaskOwner(param.getSelfUserId());
		funTask.setTaskType(Const.DIC_TASK_TYPE_REMIND);
		funTask.setTypeFlag((byte) 0);
		funTask.setTrackWarm(track.getTrackWarm());
		funTask.setIndexShow(1);
		funTask.setWarmTime(track.getWarmTime());
		funTask.setIsRead(false);
		funTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
		funTask.setCreatorUid(track.getCreatorUid());
		funTask.setCreationTime(track.getCreationTime());
		funTask.setShardCityId(param.getCityId());
		erpFunTaskMapper.insertSelective(funTask);
	}

	/**
	 * 根据指定的长度切取字符串
	 */
	private String format_Str(String source, int width) {
		String result = "";
		if (source != null && !source.equals("")) {
			for (int i = 0, w = 0; i < source.length() && w < width; i++) {
				char charCi = source.charAt(i);
				if (charCi > 255) {
					w += 2;
				} else {
					w++;
				}
				result += charCi;
			}
		} else {
			result = "&nbsp;";
		}
		return result;
	}

	private String buildTrackContentForCreateDeal(ErpFunDeal funDeal, String caseNo, Integer caseType, String targetNo, Integer targetType, InsertDealInfoParam param) {
		String house = "";
		String cust = "";
		String houseCn = "";
		String custCn = "";
		String dealTotalMoney = null;
		ErpCreateTrackInfoParam trackInfoParam = new ErpCreateTrackInfoParam();
		trackInfoParam.setSelfUserName(param.getSelfUserName());
		trackInfoParam.setIsPersonalVersion(param.isPersonalVersion());
		trackInfoParam.setCompType(param.getSelfCompType());
		trackInfoParam.setDeptNames(param.getSelfDeptName());
		String uNameA = erpFunUsersService.getCurrUserName(trackInfoParam);
		if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(funDeal.getDealType().intValue())) {
			house = "编号为";
			cust = "编号为";
			houseCn = "出租房源";
			custCn = "求租客源";
			if (funDeal.getSellDealMoney() != null) {
				dealTotalMoney = funDeal.getSellDealMoney() + (funDeal.getSalePriceUnit() == 0 ? "万元" : "元");
			}
		} else if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(funDeal.getDealType().intValue())) {
			house = "编号为";
			cust = "编号为";
			houseCn = "出售房源";
			custCn = "求购客源";
			if (null != funDeal.getRentDealMoney()) {
				ErpDicDefinitions definitions = erpDicDefinitionsMapper.getDicDefinitions(param.getCityId(), "PRICE_UNIT", funDeal.getRentPriceUnit().toString());
				dealTotalMoney = funDeal.getRentDealMoney() + definitions.getDicCnMsg();
			}
		}
		String houseNo = "";
		String custNo = "";
		if (null != targetNo) {// 数据转换
			if (Const.DIC_CASE_TYPE_RENT_CUST.equals(targetType) || Const.DIC_CASE_TYPE_BUY_CUST.equals(targetType)) {
				houseNo = caseNo;
				custNo = targetNo;
			} else if (Const.DIC_CASE_TYPE_SALE_FUN.equals(targetType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(targetType)) {
				houseNo = targetNo;
				custNo = caseNo;
			}
		} else {
			if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType) || Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
				custNo = caseNo;
			} else if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				houseNo = caseNo;
			}
		}
		// 拼接字符串
		StringBuilder resultSb = new StringBuilder();
		if (CommonUtil.isnull(houseNo)) {
			resultSb.append(cust).append(custNo).append("的").append(custCn).append("由").append(uNameA).append("更改为内成交");
		} else if (CommonUtil.isnull(custNo)) {
			resultSb.append(house).append(houseNo).append("的").append(houseCn).append("由").append(uNameA).append("更改为内成交");
		} else {
			resultSb.append(house).append(houseNo).append("的").append(houseCn)
					.append("和").append(custNo).append("的").append(custCn).append("由").append(uNameA).append("更改为内成交");
		}

		if (StringUtils.isNotBlank(house) && (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN))) {
			if (funDeal.getIsbyhand()!=1) {
				resultSb.append(" 成交金额").append(getDealAmountStr(param.getCityId(), funDeal));
			}
		}
		if (dealTotalMoney != null) {
			resultSb.append(" ").append(dealTotalMoney);
		}
		resultSb.append(" 合同编号：<a style=\"color:#259CF3;text-decoration: none;\" href=\"").append(funDeal.getDealId())
				.append(",").append(funDeal.getDealType())
				.append(",").append(funDeal.getAgreementNo()).append("\">")
				.append(funDeal.getContractNo())
				.append("</a>");
		return resultSb.toString();
	}

	/**
	 * @tag 处理成交金额
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private String getDealAmountStr(Integer cityId, ErpFunDeal funDeal) {
		StringBuilder stringBuilder = new StringBuilder("");
		// 出售合同
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(funDeal.getDealType().intValue())) {
			BigDecimal bigDecimal = funDeal.getSellDealMoney().divide(new BigDecimal(10000));
			stringBuilder.append(bigDecimal.toString() + "万元");
		} else {
			stringBuilder.append(funDeal.getRentDealMoney() + erpDicDefinitionsMapper.getDicDefinitions(cityId, "PRICE_UNIT", funDeal.getRentPriceUnit().toString()).getDicCnMsg());
		}
		return stringBuilder.toString();
	}

	/**
	 * 盘别判断
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/11
	 */	
	private String transferTrackType(Integer plateType) {
		if (Const.DIC_PLATE_TYPE_PRIVATE.equals(plateType)) {
			return "私盘";
		} else if (Const.DIC_PLATE_TYPE_PUBLIC.equals(plateType)) {
			return "抢盘";
		} else if (Const.DIC_PLATE_TYPE_SHARE.equals(plateType)) {
			return "公盘";
		}
		return "";
	}
	
	/**
	 * 根据caseId和caseType查询房客源所属人
	 */
	@Override
	public String getCaseOrgPath(Integer cityId, Integer caseId, Integer caseType) {
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSale key = new ErpFunSale();
			key.setShardCityId(cityId);
			key.setSaleId(caseId);
			ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(key);
			if (erpFunSale != null) {
				 return erpFunSale.getTissueLine();
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease key = new ErpFunLease();
			key.setShardCityId(cityId);
			key.setLeaseId(caseId);
			ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(key);
			if (erpFunLease != null) {
				 return erpFunLease.getTissueLine();
			}
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer key = new ErpFunBuyCustomer();
			key.setShardCityId(cityId);
			key.setBuyCustId(caseId);
			ErpFunBuyCustomer erpBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(key);
			if (erpBuyCustomer != null) {
				return erpBuyCustomer.getTissueLine();
			}
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomerKey key = new ErpFunRentCustomerKey();
			key.setShardCityId(cityId);
			key.setRentCustId(caseId);
			ErpFunRentCustomer erpRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(key);
			if (erpRentCustomer != null) {
				return erpRentCustomer.getTissueLine();
			}
		}
		return null;
	}

}


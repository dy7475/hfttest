package com.myfun.service.business.erpdb.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminTrueHouseComplaintMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.repository.erpdb.dao.ErpCityshareHouseMapper;
import com.myfun.repository.erpdb.dao.ErpFunAdsContentMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunHousePublishLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunHousePublishStatusMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhoneMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSalePeopleRelativeMapper;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.houseAuditDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.houseAuditParam;
import com.myfun.repository.erpdb.po.ErpCityshareHouse;
import com.myfun.repository.erpdb.po.ErpFunAdsContent;
import com.myfun.repository.erpdb.po.ErpFunHousePublishLog;
import com.myfun.repository.erpdb.po.ErpFunHousePublishStatus;
import com.myfun.repository.erpdb.po.ErpFunKey;
import com.myfun.repository.erpdb.po.ErpFunKeyExample;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunPhone;
import com.myfun.repository.erpdb.po.ErpFunPhoneExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelative;
import com.myfun.repository.erpdb.po.ErpSalePeopleRelativeExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.PageParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.erpdb.ErpFunHouseBiddingService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;
import com.myfun.utils.bean.TBDefinetion;

@Service
public class ErpFunLeaseServiceImpl extends AbstractService<ErpFunLease, ErpFunLease> implements ErpFunLeaseService {
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunHousePublishStatusMapper erpFunHousePublishStatusMapper;
	@Autowired
	private ErpFunHousePublishLogMapper erpFunHousePublishLogMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private ErpFunAdsContentMapper erpFunAdsContentMapper;
	@Autowired
	private AdminFunArchiveService adminFunArchiveService;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	@Autowired
	private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	private ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired
	private ErpSysParaService erpSysParaService;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired
	private AdminTrueHouseComplaintMapper adminTrueHouseComplaintMapper;
	@Autowired
	private ErpFunTrackService erpFunTrackService;
	@Autowired
	private ErpFunHouseBiddingService erpFunHouseBiddingService;
	@Autowired
	private ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired
	private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	private ErpCityshareHouseMapper erpCityshareHouseMapper;
	@Autowired
	private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunLeaseMapper;
	}
	
	@Override
	public void updateTrueFlag(Integer cityId, Integer[] leaseIds, Byte trueFlag) {
		erpFunLeaseMapper.updateTrueFlag(cityId, leaseIds, trueFlag);
	}
	
	@Override
	public Page<houseAuditDto> getHouseLeaseList(int pageNum, String shardCityId, houseAuditParam param) {
		PageHelper.startPage(pageNum, Const.PAGE_NUMBER, true);
		Page<houseAuditDto> list = erpFunLeaseMapper.getHouseLease(shardCityId, param);
		return list;
	}
	
	@Transactional
	@Override
	public void updatePublishCheck(String fPubId, String oldPublishSite, String houseId, String publishSite,
			String userId, String desc, String cityId) {
		//修改房源状态
		ErpFunHousePublishStatus record = new ErpFunHousePublishStatus();
//		record.setHouseId(StringUtil.parseInteger(houseId));
		record.setPubId(StringUtil.parseInteger(fPubId));
		record.setSaleLease((byte)2);
		
		record.setShardCityId(StringUtil.parseInteger(cityId));
		record.setPublishSite(StringUtil.parseInteger(publishSite));
		record.setCheckStatus((byte)1);
		record.setUpdateTime(new Date());
		record.setCheckUser(StringUtil.parseInteger(userId));
		erpFunHousePublishStatusMapper.updateByPrimaryKeySelective(record);
		
		//写跟进
		if(!oldPublishSite.equals(publishSite)){
			AdminFunCity  funcity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId));
			String cityPublish = String.valueOf(funcity.getQqPublish());
			
			ErpFunHousePublishLog record2 = new ErpFunHousePublishLog();
			record2.setfPubId(StringUtil.parseInteger(fPubId));
			record2.setPublishSite(StringUtil.parseInteger(publishSite));
			record2.setCityPublish(StringUtil.parseByte(cityPublish));
			record2.setCheckStatus((byte)1);
			record2.setCheckUser(StringUtil.parseInteger(userId));
			record2.setCheckDesc(desc);
			record2.setCheckDate(new Date());
			record2.setShardCityId(StringUtil.parseInteger(cityId));
			erpFunHousePublishLogMapper.insertSelective(record2);
		}
	}
	/**
	 * 房源详情
	 * **/
	@Override
	public Map<String, Object> getFunLeaseDetailInfo(Integer housId, Integer cityId, Byte funType) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		//状态
		ErpFunHousePublishStatus publicStatus = getPublicStatus(housId, cityId, funType);
		//详情
		ErpFunLease funLease = getFunLease(housId, cityId);
		resMap.put("publicStatus", publicStatus);
		resMap.put("funLease", funLease);
		return resMap;
	}
	/**
	 * 查询房源状态
	 * **/
	private ErpFunHousePublishStatus getPublicStatus(Integer housId, Integer cityId, Byte funType) {
		ErpFunHousePublishStatus obj = new ErpFunHousePublishStatus();
		obj.setHouseId(housId);
		obj.setCityId(cityId);
		obj.setSaleLease(funType);
		obj.setShardCityId(cityId);
		
		return erpFunHousePublishStatusMapper.getDataObject(obj);
	}
	/**
	 * 查询房源详情
	 * **/
	@Override
	public ErpFunLease getFunLease(Integer housId, Integer cityId) {
		ErpFunLease s = new ErpFunLease();
		s.setShardCityId(cityId);
		s.setLeaseId(housId);
		List<ErpFunLease> resList = erpFunLeaseMapper.getFunLeaseByCondition(s);
		return resList.size() > 0 ? resList.get(0) : null;
	}
	
	
	@Override
	public ErpFunLease getFunLease4OtherWeb(Integer housId, Integer cityId) {
		ErpFunLease s = new ErpFunLease();
		s.setShardCityId(cityId);
		s.setLeaseId(housId);
		s.setLeasePublish(true);
		s.setLeaseStatus(Integer.parseInt(Const.HouseCustStatus.DIC_STATUS_AVAILABLE+""));
		List<ErpFunLease> resList = erpFunLeaseMapper.getFunLeaseByCondition(s);
		return resList.size() > 0 ? resList.get(0) : null;
	}
	
	@Override
	public PageInfo<ErpFunLease> getFunLeaseList4YouYouInfo(Integer cityId,PageParam pageParam){
		pageParam.setPageSize(2);
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return new PageInfo<ErpFunLease>(erpFunLeaseMapper.getFunLeaseList4YouYou(cityId));
	}
	@Override
	public ErpFunLease getFunLeaseInfo4YouYouInfo(Integer housId, Integer cityId) {
		ErpFunLease s = new ErpFunLease();
		s.setShardCityId(cityId);
		s.setLeaseId(housId);
		List<ErpFunLease> resList = erpFunLeaseMapper.getFunLeaseByCondition4YouYou(s);
		return resList.size() > 0 ? resList.get(0) : null;
	}
	@Override
	public List<ErpFunLease> getLeaseList(Integer cityId, String leaseIds) {
		return erpFunLeaseMapper.getLeaseList(cityId,leaseIds);
	}
	@Override
	public void updateCancleTrueHouse(Short cityId, Integer caseId) {
		erpFunLeaseMapper.updateCancleTrueHouse(cityId, caseId);
	}

	@Override
	public List<ErpBulletHouseDto> getLeaseListForCreateBullet(Integer compId, Integer cityId, String[] caseIds) {
		return erpFunLeaseMapper.getLeaseListForCreateBullet(compId, cityId, caseIds);
	}
	@Override
	public boolean countShareHouse(Integer cityId,Integer compId) {
		Integer count = erpFunLeaseMapper.countShareHouse(cityId,compId);
		return count>0;
	}

	@Override
	public boolean countShareHouseByPartner(Integer cityId, Integer compId, Integer partnerId) {
		Integer count = erpFunLeaseMapper.countShareHouseByPartner(cityId, compId, partnerId);
		return count > 0;
	}

	@Override
	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId) {
		ErpFunLease conditionModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		ErpFunLease updateModel = new ErpFunLease();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		//20-5-19 wc task#141368 美联 去掉非手写跟进更改更近时间
//		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		updateModel.setSpecialTime(DateTimeHelper.getSystemDate());
		updateModel.setScheduleTime(DateTimeHelper.getSystemDate());
		updateModel.setSecrecyTime(DateTimeHelper.getSystemDate());
		updateModel.setCommendTime(DateTimeHelper.getSystemDate());
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
		
	}
	@Override
	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId) {
		ErpFunLease conditionModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		ErpFunLease updateModel = new ErpFunLease();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_SHARE));
	
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
		
	}
	@Override
	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		conditionModel.setPublicCount(0);
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		conditionModel.setPublicCount(0);
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, orgIds);
	}

	@Override
	public void updateHouseTrackTime(Integer cityId, Integer compId, String string) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		boolean fromPublic = "0".equals(string)?false:true;
		conditionModel.setFromPublic(fromPublic);
		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
		
	}

	@Override
	public void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		boolean fromPublic = !"0".equals(string);
		conditionModel.setFromPublic(fromPublic);
		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, orgIds);
	}

	@Override
	public void updateHousePublicTime(Integer cityId, Integer compId) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PUBLIC));
		updateModel.setPublicTime(DateTimeHelper.getSystemDate());		
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHousePublicTimeByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunLease conditionModel = new ErpFunLease();
		ErpFunLease updateModel = new ErpFunLease();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PUBLIC));
		updateModel.setPublicTime(DateTimeHelper.getSystemDate());
		erpFunLeaseMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, orgIds);
	}

	@Override
	public void updateHouseSourceNotCooperate(Integer cityId, Integer compId) {
		ErpFunLeaseExample example = new ErpFunLeaseExample();
		example.createCriteria().andCompIdEqualTo(compId).andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunLease updateModel = new ErpFunLease();
		updateModel.setCityShareFlag((byte)0);
		erpFunLeaseMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunLeaseExample example = new ErpFunLeaseExample();
		example.createCriteria()
				.andCompIdEqualTo(compId)
				.andOrganizationIdIn(orgIds)
				.andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunLease updateModel = new ErpFunLease();
		updateModel.setCityShareFlag((byte)0);
		erpFunLeaseMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public List<ErpBulletHouseDto> getLeaseListForBullet(Integer compId, Integer cityId, String[] caseIds) {
		return erpFunLeaseMapper.getLeaseListForBullet(compId, cityId, caseIds);
	}

	/**
	 * 依据规则修改真房源标记
	 * @author 臧铁
	 * @param cityId  切库标记
	 * @param caseId  房客源ID
	 * @since 2017年5月15日
	 * @return
	 */
	@Override
	public Byte updateHouseTrueFlag(Integer cityId,Integer caseId, ErpFunLease erpFunLease) {
		Byte trueHouseFlag = judgeTrueHouseForChangeInfo(erpFunLease.getPanoramaMap(), erpFunLease.getLeaseMap(), erpFunLease.getTrueFlag(), erpFunLease.getVideoNum());
		// 如果可以则将真房源标记改为假的
		ErpFunLease erpFunLeaseUpdate = new ErpFunLease();
		erpFunLeaseUpdate.setLeaseId(caseId);
		erpFunLeaseUpdate.setShardCityId(cityId);
		if(Const.DIC_INFO_TRUE_INFO_FLAG_0.equals(trueHouseFlag)){
			erpFunLeaseUpdate.setTrueFlag((byte)0);
		}
		erpFunLeaseUpdate.setUpdateTime(new Date());
		erpFunLeaseUpdate.setPanoramaMap(erpFunLease.getPanoramaMap());
		erpFunLeaseUpdate.setVideoNum(erpFunLease.getVideoNum());
		erpFunLeaseUpdate.setThumbUrl(erpFunLease.getThumbUrl());
		erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLeaseUpdate);
		return trueHouseFlag;
	}

	/**
	 * 删除图片、视频、VR时的一些真房源判断逻辑
	 * @author 臧铁
	 * @param panoramaMap  720相机图片有多少张
	 * @param photoMap  图片张数，默认=0
	 * @param trueFlag  真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源 Def：0
	 * @param videoNum  视频数量，Def：0
	 * @since 2017年5月15日
	 * @return true 不需要改为假房源，但也不能改为真房源   false 可以改为假房源
	 */
	@Override
	public Byte judgeTrueHouseForChangeInfo(Integer panoramaMap, Integer photoMap, Byte trueFlag, Integer videoNum) {
		// 投诉下架的，不能修改为假房源0--因为修改之后又可以点亮真房源了
		if(Const.DIC_INFO_TRUE_INFO_FLAG_2.equals(trueFlag) ){
			return Const.DIC_INFO_TRUE_INFO_FLAG_2;
		}
		boolean isPicTrueHouse = (photoMap==null?0:photoMap) >= 5;
		if(!isPicTrueHouse){// 如果图片不满足
			return Const.DIC_INFO_TRUE_INFO_FLAG_0;
		}
		return Const.DIC_INFO_TRUE_INFO_FLAG_1;
	}

	@Override
	public void cancelAds(Integer cityId, Integer compId, Integer caseId, String caseNo) {
		ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
		erpFunLease.setAdsFlag(Byte.valueOf(Constants_DIC.DIC_ADS_CASE_STATUS_0));
		ErpFunAdsContent erpFunAdsContent = erpFunAdsContentMapper.getErpFunAdsContentByCaseNo(cityId,caseNo);
		if(erpFunAdsContent!=null){
			erpFunAdsContent.setAdsStatus(Byte.valueOf(Constants_DIC.DIC_ADS_CASE_STATUS_0));
		}
	}

	@Transactional
	@Override
	public void createTrack4TransData(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		
		Date dateNow = new Date();
		ErpFunLease leaseUpdate = new ErpFunLease();
		leaseUpdate.setShardCityId(param.getCityId());
		leaseUpdate.setLeaseId(param.getCaseId());
		leaseUpdate.setRedFlag(false);
		leaseUpdate.setLeaseSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		leaseUpdate.setLeaseLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		leaseUpdate.setUpdateTime(dateNow);
		leaseUpdate.setSyncTime(dateNow);
		leaseUpdate.setActionTime(dateNow);
		leaseUpdate.setTrackTime(dateNow);
		leaseUpdate.setTrackTime2(dateNow);// 只有房源才更新
		leaseUpdate.setSendtotencent((byte) 0);// 移交的数据要从腾讯下架
		leaseUpdate.setTrueFlag(Const.DIC_INFO_TRUE_INFO_FLAG_0);// 下架真房源
		// 移交之后的信息
		leaseUpdate.setUserId(createAuditUser.getUserId());
		leaseUpdate.setArchiveId(createAuditUser.getArchiveId());
		leaseUpdate.setAreaId(createAuditUser.getAreaId());
		leaseUpdate.setRegId(createAuditUser.getRegId());
		leaseUpdate.setDeptId(createAuditUser.getDeptId());
		leaseUpdate.setGrId(createAuditUser.getGrId());
		boolean sysRunModelIsPrivate = erpSysParaService.getSysRunModelIsPrivate(param.getCaseType(), param.getCityId(), param.getCompId());
		if (sysRunModelIsPrivate) {
			leaseUpdate.setPrivateTime(dateNow);
			leaseUpdate.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		} else {
			leaseUpdate.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		boolean isUserRight = adminFunArchiveService.isUserRight(createAuditUser.getArchiveId());
		if (!isUserRight) {
			leaseUpdate.setLeaseCooperate(false);
			leaseUpdate.setCityShareFlag((byte) 0);
		}
		// 任务失效
		erpFunTaskService.cancelAuditTaskForWriteoff(param.getCityId(), param.getCompId(), param.getCaseId(),
				param.getCaseType(), param.getTrackType());
		// 更新数据
		erpFunLeaseMapper.updateByPrimaryKeySelective(leaseUpdate);
		// 更新钥匙所在门店
		erpFunKeyMapper.updateErpFunKey(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType(),
				createAuditUser.getDeptId());
		// 更新电话表所属人
		erpFunPhoneMapper.updateBelongUser(param.getCityId(), param.getCaseId(), param.getCaseType(), createAuditUser);
		// 修改城市大工盘数据
		ErpCityshareHouse shareHouseUpdate = new ErpCityshareHouse();
		shareHouseUpdate.setUserId(createAuditUser.getUserId());
		shareHouseUpdate.setArchiveId(createAuditUser.getArchiveId());
		shareHouseUpdate.setDeptId(createAuditUser.getDeptId());
		shareHouseUpdate.setCaseId(param.getCaseId());
		shareHouseUpdate.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN.byteValue());
		erpCityshareHouseMapper.transDataByCaseId(param.getCityId(), shareHouseUpdate);
		// 修改跟进
//		erpFunTrackMapper.updateTrackByCaseId(param.getCityId(), Const.DIC_CASE_TYPE_LEASE_FUN, createAuditUser);
	}

	@Override
	public Byte judgeTrueHouseChangeInfo(Integer photoMap, Byte trueFlag) {

		// 投诉下架的，不能修改为假房源0--因为修改之后又可以点亮真房源了
		if(Const.DIC_INFO_TRUE_INFO_FLAG_2.equals(trueFlag) ){
			return Const.DIC_INFO_TRUE_INFO_FLAG_2;
		}
		boolean isPicTrueHouse = photoMap >= 5;
		if (!isPicTrueHouse) {// 图片不满足
			return Const.DIC_INFO_TRUE_INFO_FLAG_0;
		}
		return Const.DIC_INFO_TRUE_INFO_FLAG_1;
	}

	/**
	 * @tag 出租房源数据移交
	 * @author 邓永洪
	 * @since 2018/5/2
	 */
	@Transactional
	@Override
	public void dataTranslate(ErpFunLease updateModel, ErpFunUsers acceptUser, List<ErpFunLease> casePOListTmp, DataTranslateParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer caseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		if (casePOListTmp == null || casePOListTmp.isEmpty()) {
			throw new BusinessException("数据错误，请重新查询后再进行移交！", "-1");
		}
		// 真房源列表
		Set<Integer> caseIdSetTrue = casePOListTmp.stream().filter(val -> Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(val.getTrueFlag()))
				.collect(Collectors.mapping(val -> val.getLeaseId(), Collectors.toSet()));
		List<Integer> caseIds = casePOListTmp.stream().collect(Collectors.mapping(val -> val.getLeaseId(), Collectors.toList()));
		List<String> caseNos = casePOListTmp.stream().collect(Collectors.mapping(val -> val.getLeaseNo(), Collectors.toList()));
		
		boolean userRightFlag = false;
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			if (acceptUser != null) {
				userRightFlag = adminFunArchiveService.isUserRight(acceptUser.getArchiveId());
			}
			// todo 包含真房源情况
			if (caseIdSetTrue.size() > 0) {
				//ThreadLocalUtil.setEXTRA("HAVE_TRUEHOUSE");
			}
			List<AdminTrueHouseComplaint> complaintPOList = adminTrueHouseComplaintMapper.getComplaintList(caseIds, caseType, srcUserId, cityId, compId);
			if (complaintPOList != null && complaintPOList.size() > 0) {
				Map<Integer, AdminTrueHouseComplaint> complaintMap = complaintPOList.stream().collect(Collectors.toMap(AdminTrueHouseComplaint::getCaseId, val -> val));
				// 将真房源从这里面移除
				for (int i = casePOListTmp.size() - 1; i >= 0; i--) {
					ErpFunLease funLease = casePOListTmp.get(i);
					if (complaintMap.containsKey(funLease.getLeaseId())) {
						casePOListTmp.remove(i);
						caseIds.remove(funLease.getLeaseId());
						caseNos.remove(funLease.getLeaseNo());
					}
				}
				//todo 包含投诉真房源
				//ThreadLocalUtil.setEXTRA("HAVE_COMPLAINT_TRUEHOUSE");
				// 全是投诉中的真房源
				if (casePOListTmp == null || casePOListTmp.size() <= 0) {
					return;
				}
			}
		}
		// 没所属人或未实名认证取消合作和分享
		if (!userRightFlag) {
			updateModel.setLeaseCooperate(false);
			updateModel.setCityShareFlag((byte) 0);
		}
		String[] caseNoArr = caseNos.toArray(new String[caseNos.size()]);
		//房源出售数据移交
		// STEP 1. 写跟进
		erpFunTrackService.createTrackForTransData(cityId, acceptUser, caseType, caseIds, caseNoArr, updateModel.getPlateType(), param);
		//STEP 2更新竞价数据的所属人 说明不是移交到抢盘  数据移交下架竞价
		erpFunHouseBiddingService.updateHouse4TransDataArchiveId(caseType, caseIds, param);
		// STEP 3. 处理相关提醒任务
		if (!CommonUtil.isnull(acceptUser) && !"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {// 移交原始人不是公盘或抢盘,移交目标是经纪人时才更新提醒任务
			erpFunTaskService.updateTaskForTransData(acceptUser, caseType, param,caseIds);
		}
		// STEP 4. 写提醒任务
		if (acceptUser != null) {// 当移交目标是经纪人时才写提醒任务,并且只写一条
			erpFunTaskService.createTaskForTransData(cityId, caseIds, acceptUser, caseNoArr, caseType, caseIds.size(), param);
		}
		// STEP 5. 进行数据移交
		ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
		funLeaseExample.setShardCityId(cityId);
		funLeaseExample.createCriteria().andCompIdEqualTo(compId).andLeaseIdIn(caseIds);
		erpFunLeaseMapper.updateByExampleSelective(updateModel, funLeaseExample);
		// STEP 6. 钥匙跟着房源走移交
		ErpFunKey funKey = new ErpFunKey();
		funKey.setDeptId(acceptDeptId);
		ErpFunKeyExample funKeyExample = new ErpFunKeyExample();
		funKeyExample.setShardCityId(cityId);
		funKeyExample.createCriteria().andCompIdEqualTo(compId).andCaseIdIn(caseIds).andCaseTypeEqualTo(caseType.byteValue());
		// STEP 7. 业主电话跟着房源门店走
		erpFunKeyMapper.updateByExampleSelective(funKey, funKeyExample);
		ErpFunPhone funPhone = new ErpFunPhone();
		funPhone.setAreaId(updateModel.getAreaId());
		funPhone.setRegId(updateModel.getRegId());
		funPhone.setDeptId(updateModel.getDeptId());
		funPhone.setGrId(updateModel.getGrId());
		funPhone.setUserId(updateModel.getUserId());
		ErpFunPhoneExample erpFunPhoneExample = new ErpFunPhoneExample();
		erpFunPhoneExample.setShardCityId(cityId);
		erpFunPhoneExample.createCriteria().andCompIdEqualTo(compId).andCaseIdIn(caseIds).andCaseTypeEqualTo(caseType);
		erpFunPhoneMapper.updateByExampleSelective(funPhone, erpFunPhoneExample);
		// 修改房源维护人
		ErpSalePeopleRelative salePeopleRelative = new ErpSalePeopleRelative();
		if (acceptUser == null) {
			salePeopleRelative.setDelFlag(1);
			salePeopleRelative.setDelTime(new Date());
		} else {
			salePeopleRelative.setDelFlag(0);
			salePeopleRelative.setUserId(acceptUser.getUserId());
			salePeopleRelative.setUserName(acceptUser.getUserName());
			salePeopleRelative.setUserMobile(acceptUser.getUserMobile());
		}
		ErpSalePeopleRelativeExample salePeopleRelativeExample = new ErpSalePeopleRelativeExample();
		salePeopleRelativeExample.setShardCityId(cityId);
		salePeopleRelativeExample.createCriteria().andSaleIdIn(caseIds).andPeopleTypeEqualTo(2);
		erpSalePeopleRelativeMapper.updateByExampleSelective(salePeopleRelative, salePeopleRelativeExample);
		// 写移交记录
		String acceptUserName = "";
		Integer tempSrcUserId = null;
		Integer tempSrcDeptId = null;
		if ("public".equalsIgnoreCase(srcUserId)) {
			acceptUserName = "抢盘";
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			acceptUserName = "公盘";
		} else if (acceptUser != null) {
			tempSrcUserId = acceptUser.getUserId();
			acceptUserName = acceptUser.getUserName();
			tempSrcDeptId = acceptUser.getDeptId();
		}
		String content = "将" + caseIds.size() + "条数据移交给 " + acceptUserName;
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.TRANS_LEASE_DATA, tempSrcUserId, tempSrcDeptId, content,
				null, null, cityId, compId, param.getDeptId(), param.getCurrentUserId());
	}

	/**
	 * @tag 验证移交数据中是否存在已成交或注销的数据
	 * @author 邓永洪
	 * @since 2018/5/2
	 */
	@Override
	public boolean detectTransData(DataTranslateParam param, String caseIds) {
		ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
		funLeaseExample.setShardCityId(param.getCityId());
		funLeaseExample.createCriteria().andCompIdEqualTo(param.getCompId()).andLeaseStatusIn(Arrays.asList(new Integer[]{
				Const.DIC_HOUSE_STATUS_WRITEOFF.intValue(),
				Const.DIC_HOUSE_STATUS_INNERDEAL.intValue(),
				Const.DIC_HOUSE_STATUS_DEAL.intValue()})).andLeaseIdIn(StringUtil.toIntList(caseIds,","));
		List<ErpFunLease> funleaseList = erpFunLeaseMapper.selectByExample(funLeaseExample);
		return funleaseList != null &&funleaseList.size()>0 && funleaseList.get(0) != null;
	}

	/**
	 * @tag 判断指定员工的所有信息中是否存在已成交或注销信息
	 * @author 邓永洪
	 * @since 2018/5/2
	 */
	@Override
	public boolean detectTransDataByDeptIdAndUserId(DataTranslateParam param) {
		String srcUserId = param.getSrcUserId();
		ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
		funLeaseExample.setShardCityId(param.getCityId());
		ErpFunLeaseExample.Criteria criteria = funLeaseExample.createCriteria();
		criteria.andDeptIdEqualTo(param.getDeptId());
		if (!CommonUtil.isnull(srcUserId) && !"share".equalsIgnoreCase(srcUserId) && !"public".equalsIgnoreCase(srcUserId)) {
			criteria.andUserIdEqualTo(Integer.valueOf(srcUserId));
		} else if ("share".equalsIgnoreCase(srcUserId)) { // 公盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		} else if ("public".equalsIgnoreCase(srcUserId)) { // 抢盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		}
		criteria.andLeaseStatusIn(Arrays.asList(new Integer[]{Const.DIC_HOUSE_STATUS_WRITEOFF.intValue(),
				Const.DIC_HOUSE_STATUS_INNERDEAL.intValue(),
				Const.DIC_HOUSE_STATUS_DEAL.intValue()}));
		List<ErpFunLease> funleaseList = erpFunLeaseMapper.selectByExample(funLeaseExample);
		return funleaseList != null &&funleaseList.size()>0 && funleaseList.get(0) != null;
	}

	@Override
	public void synchronizeSaleLeaseHouse(Integer caseId, Byte caseType, ErpFunLease erpFunLease) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (erpFunLease.getIsSaleLease().byteValue() != 1) {
			return;
		}
		Map<String, String> saleLeaseTransferMap = TBDefinetion.getSaleLeaseTransferMap(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN);
		ErpFunSale erpFunSale = new ErpFunSale();
		erpFunSale.setCityId(erpFunLease.getCityId());
		erpFunSale.setShardCityId(erpFunLease.getCityId());
		for (Entry<String, String> entry : saleLeaseTransferMap.entrySet()) {
			String fieldValue = BeanUtils.getProperty(erpFunLease, entry.getKey());
			if(StringUtils.isBlank(fieldValue)) {
				fieldValue = null;
			}
			BeanUtils.copyProperty(erpFunSale, entry.getValue(), fieldValue);
		}
		erpFunSaleMapper.updateByPrimaryKey(erpFunSale);
	}

}

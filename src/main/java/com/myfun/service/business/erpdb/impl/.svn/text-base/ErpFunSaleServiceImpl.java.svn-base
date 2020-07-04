package com.myfun.service.business.erpdb.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.HouseCaseIdDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.house.vo.FunSaleDto;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminFunBuildingBiddingMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunHouseBiddingMapper;
import com.myfun.repository.admindb.dao.AdminTrueHouseComplaintMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunBuildingBidding;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.repository.agencydb.dao.AgencyFunNewBuildingBiddingMapper;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.erpdb.dto.houseAuditDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.param.houseAuditParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.PageParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.adminRpt.AdminFunShareRelevanceService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.erpdb.ErpCountDoneService;
import com.myfun.service.business.erpdb.ErpFunHouseBiddingService;
import com.myfun.service.business.erpdb.ErpFunRegsectionControlService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.bean.TBDefinetion;
import scala.annotation.meta.param;

@Service
public class ErpFunSaleServiceImpl extends AbstractService<ErpFunSale, ErpFunSale>implements ErpFunSaleService {
	private static final String ErpFunSale = null;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private AdminFunArchiveService adminFunArchiveService;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	@Autowired
	private ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	private ErpFunHousePublishStatusMapper erpFunHousePublishStatusMapper;
	@Autowired
	private ErpFunHousePublishLogMapper erpFunHousePublishLogMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private ErpSysParaService erpSysParaService;
	@Autowired
	private ErpUserOpersService erpUserOpersService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired
	private ErpFunAdsContentMapper erpFunAdsContentMapper;
	@Autowired
	private ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired
	private ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired
	private AdminFunBuildingBiddingMapper adminFunBuildingBiddingMapper;
	@Autowired
	private ErpCityshareHouseMapper erpCityshareHouseMapper;
	@Autowired
	private AgencyFunNewBuildingBiddingMapper agencyFunNewBuildingBiddingMapper;
	@Autowired
	private AdminFunHouseBiddingMapper adminFunHouseBiddingMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired
	AdminTrueHouseComplaintMapper adminTrueHouseComplaintMapper;
	@Autowired
	ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunHouseBiddingService erpFunHouseBiddingService;
	@Autowired
	ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunRegsectionControlService erpFunRegsectionControlService;
	@Autowired
	AdminFunShareRelevanceService adminFunShareRelevanceService;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunKeyRemarkMapper erpFunKeyRemarkMapper;
	@Autowired
	ErpFunCaseFavoriteMapper erpFunCaseFavoriteMapper;
	@Autowired
	ErpFunPolicyControlMapper erpFunPolicyControlMapper;
	@Autowired
	ErpCountDoneService erpCountDoneService;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpFunSalePublishInfoMapper erpFunSalePublishInfoMapper;
	@Autowired
	ErpFunLeasePublishInfoMapper erpFunLeasePublishInfoMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunSaleMapper;
	}

	@Override
	public Page<houseAuditDto> getHouseSaleList(int pageNum, String shardCityId, houseAuditParam param) {
		PageHelper.startPage(pageNum, Const.PAGE_NUMBER, true);
		Page<houseAuditDto> list = erpFunSaleMapper.getHouseAuditSaleList(shardCityId, param);
		return list;
	}

	@Transactional
	@Override
	public void updatePublishCheck(String fPubId, String oldPublishSite, String houseId, String publishSite, String userId, String desc, String cityId) {
		// 修改房源状态
		ErpFunHousePublishStatus record = new ErpFunHousePublishStatus();
		// record.setHouseId(StringUtil.parseInteger(houseId));
		record.setPubId(StringUtil.parseInteger(fPubId));
		record.setSaleLease((byte) 1);

		record.setShardCityId(StringUtil.parseInteger(cityId));
		record.setPublishSite(StringUtil.parseInteger(publishSite));
		record.setCheckStatus((byte) 1);
		record.setUpdateTime(new Date());
		record.setCheckUser(StringUtil.parseInteger(userId));
		erpFunHousePublishStatusMapper.updateByPrimaryKeySelective(record);

		// 写跟进
		if (!oldPublishSite.equals(publishSite)) {
			AdminFunCity funcity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId));
			String cityPublish = String.valueOf(funcity.getQqPublish());

			ErpFunHousePublishLog record2 = new ErpFunHousePublishLog();
			record2.setfPubId(StringUtil.parseInteger(fPubId));
			record2.setPublishSite(StringUtil.parseInteger(publishSite));
			record2.setCityPublish(StringUtil.parseByte(cityPublish));
			record2.setCheckStatus((byte) 1);
			record2.setCheckUser(StringUtil.parseInteger(userId));
			record2.setCheckDesc(desc);
			record2.setCheckDate(new Date());
			record2.setShardCityId(StringUtil.parseInteger(cityId));
			erpFunHousePublishLogMapper.insertSelective(record2);
		}
	}

	/**
	 * 房源信息查询
	 **/
	@Override
	public Map<String, Object> getFunSaleDetailInfo(Integer housId, Integer cityId, Byte funType) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 状态
		ErpFunHousePublishStatus publicStatus = getPublicStatus(housId, cityId, funType);
		// 详情
		ErpFunSale funSale = getFunSale(housId, cityId);
		resMap.put("publicStatus", publicStatus);
		resMap.put("funSale", funSale);
		return resMap;
	}

	/**
	 * 查询房源状态
	 **/
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
	 **/
	@Override
	public ErpFunSale getFunSale(Integer housId, Integer cityId) {
		return erpFunSaleMapper.getFunSaleBySaleId(cityId, housId);
	}

	@Override
	public ErpFunSale getFunSale4OtherWeb(Integer housId, Integer cityId) {
		ErpFunSale s = new ErpFunSale();
		s.setShardCityId(cityId);
		s.setSaleId(housId);
		s.setSalePublish(true);
		s.setSaleStatus(Const.HouseCustStatus.DIC_STATUS_AVAILABLE);
		List<ErpFunSale> resList = erpFunSaleMapper.getFunSaleByCondition(s);
		return resList.size() > 0 ? resList.get(0) : null;
	}

	@Override
	public PageInfo<ErpFunSale> getFunSaleList4YouYouInfo(Integer cityId, PageParam pageParam) {
		pageParam.setPageSize(2);
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		// TODO Auto-generated method stub
		return new PageInfo<ErpFunSale>(erpFunSaleMapper.getFunSaleList4YouYou(cityId));
	}

	@Override
	public ErpFunSale getFunSaleInfo4YouYouInfo(Integer housId, Integer cityId) {
		ErpFunSale s = new ErpFunSale();
		s.setShardCityId(cityId);
		s.setSaleId(housId);
		List<ErpFunSale> resList = erpFunSaleMapper.getFunSaleByCondition4YouYou(s);
		return resList.size() > 0 ? resList.get(0) : null;
	}

	@Override
	public void updateTrueFlag(Integer cityId, Integer[] saleIds, Byte trueFlag) {
		erpFunSaleMapper.updateTrueFlag(cityId, saleIds, trueFlag);
	}

	/**
	 * @Title: getSaleList
	 * @Description: 查询列表
	 * @author lcb
	 * @Time 2016-6-21 下午1:47:05
	 * @throws
	 */
	@Override
	public List<ErpFunSale> getSaleList(Integer cityId, String saleIds) {
		return erpFunSaleMapper.getFunSaleList(cityId, saleIds);
	}
	
	public List<ErpBulletHouseDto> getSaleListForCreateBullet(Integer compId, Integer cityId, String[] saleIds) {
		return erpFunSaleMapper.getSaleListForCreateBullet(compId, cityId, saleIds);
	}

	@Override
	public void updateCancleTrueHouse(Short cityId, Integer caseId) {
		erpFunSaleMapper.updateCancleTrueHouse(cityId, caseId);
	}

	@Override
	public boolean countShareHouse(Integer cityId,Integer compId) {
		Integer count = erpFunSaleMapper.countShareHouse(cityId,compId);
		return count>0;
	}

	@Override
	public boolean countShareHouseByPartner(Integer cityId, Integer compId, Integer partnerId) {
		Integer count = erpFunSaleMapper.countShareHouseByPartner(cityId, compId, partnerId);
		return count > 0;
	}

	@Override
	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		updateModel.setSpecialTime(DateTimeHelper.getSystemDate());
		updateModel.setScheduleTime(DateTimeHelper.getSystemDate());
		updateModel.setSecrecyTime(DateTimeHelper.getSystemDate());
		updateModel.setCommendTime(DateTimeHelper.getSystemDate());
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_SHARE));
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		conditionModel.setPublicCount(0);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		conditionModel.setPublicCount(0);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setActionTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, orgIds);
	}

	@Override
	public void updateHouseTrackTime(Integer cityId, Integer compId, String string) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		boolean fromPublic = "0".equals(string)?false:true;
		conditionModel.setFromPublic(fromPublic);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PRIVATE));
		boolean fromPublic = !"0".equals(string);
		conditionModel.setFromPublic(fromPublic);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setTrackTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId, conditionModel, updateModel, orgIds);
	}

	@Override
	public void updateHousePublicTime(Integer cityId, Integer compId) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PUBLIC));
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setPublicTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId,conditionModel,updateModel, null);
	}

	@Override
	public void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunSale conditionModel = new ErpFunSale();
		conditionModel.setCompId(compId);
		conditionModel.setPlateType(Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PUBLIC));
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setPublicTime(DateTimeHelper.getSystemDate());
		erpFunSaleMapper.updateHouseOffCompId(cityId, conditionModel, updateModel, orgIds);
	}

	@Override
	public void updateHouseSourceNotCooperate(Integer cityId, Integer compId) {
		ErpFunSaleExample example = new ErpFunSaleExample();
		example.createCriteria().andCompIdEqualTo(compId).andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setCityShareFlag((byte)0);
		erpFunSaleMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunSaleExample example = new ErpFunSaleExample();
		example.createCriteria()
				.andCompIdEqualTo(compId)
				.andOrganizationIdIn(orgIds)
				.andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunSale updateModel = new ErpFunSale();
		updateModel.setCityShareFlag((byte)0);
		erpFunSaleMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void downHouseFormWebSite(ErpFunUsers funUsersSel, List<HouseCaseIdDto> saleIds, List<HouseCaseIdDto> leaseIds) {//人员离职下架房源
		List<String> houseIdList = CollUtil.newArrayList();
		//查询上架官网系统参数条件
		List<String> paramIds = new ArrayList<>();
		paramIds.add("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET");
		paramIds.add("RENT_HOUSE_PUBLISH_WEBSITE_SET");
		paramIds.add("SECOND_HAND_HOUSE_PRICE_CHANGE");
		paramIds.add("SECOND_HAND_HOUSE_AREA_CHANGE");
		paramIds.add("SECOND_HAND_HOUSE_ALL_RELATED_MAN_DELETE");
		paramIds.add("SECOND_HAND_HOUSE_CHANGE_INVALID");
		paramIds.add("SECOND_HAND_HOUSE_ENTRUST_EXPIRE");
		paramIds.add("SECOND_HAND_HOUSE_ANY_FILE_DELETE");
		paramIds.add("RENT_HOUSE_PRICE_CHANGE");
		paramIds.add("RENT_HOUSE_AREA_CHANGE");
		paramIds.add("RENT_HOUSE_ALL_RELATED_MAN_DELETE");
		paramIds.add("RENT_HOUSE_CHANGE_INVALID");
		paramIds.add("RENT_HOUSE_ENTRUST_EXPIRE");
		paramIds.add("RENT_HOUSE_ANY_FILE_DELETE");
		paramIds.add("SECOND_HOUSE_DOWN_CONTROL_TYPE");
		paramIds.add("SECOND_HOUSE_DOWN_RELAUNCH_DAY");
		Map<String, String> sysParamMap = erpSysParaService.getMLSysParamMapByUserType(funUsersSel.getCityId().intValue(), funUsersSel.getCompId(), funUsersSel.getUserId(), paramIds);

		if (sysParamMap.get("SECOND_HAND_HOUSE_ALL_RELATED_MAN_DELETE") != null) {
			if ("1".equals(sysParamMap.get("SECOND_HAND_HOUSE_ALL_RELATED_MAN_DELETE"))) {
				List<Integer> salesId = new ArrayList<>();
				for (HouseCaseIdDto saleId : saleIds) {
					salesId.add(saleId.getHouseId());
				}
				if (salesId.size() > 0) {
					List<HouseCaseIdDto> saleList = erpFunSalePublishInfoMapper.getWaitDownHouseList(funUsersSel.getCityId().intValue(), salesId);
					List<String> saleIdList = new ArrayList<>();
					for (HouseCaseIdDto houseCaseIdDto : saleList) {
						saleIdList.add(houseCaseIdDto.getHouseId()+"");
					}
					if (saleIdList.size() > 0) {
						ErpFunSalePublishInfoExample erpFunSalePublishInfoExample = new ErpFunSalePublishInfoExample();
						erpFunSalePublishInfoExample.createCriteria().andSaleIdIn(saleIdList).andWebsiteStateEqualTo("1");
						erpFunSalePublishInfoExample.setShardCityId(funUsersSel.getCityId().intValue());
						List<ErpFunSalePublishInfo> erpFunSalePublishInfos = erpFunSalePublishInfoMapper.selectByExample(erpFunSalePublishInfoExample);
						if (erpFunSalePublishInfos.size() > 0) {
							ErpFunSalePublishInfo erpFunSalePublishInfo = new ErpFunSalePublishInfo();
							erpFunSalePublishInfo.setWebsiteState("0");
							erpFunSalePublishInfo.setWebsiteLastDownTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
							erpFunSalePublishInfo.setMlhfState("0");
							erpFunSalePublishInfo.setMlhfLastDownTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
							if (sysParamMap.get("SECOND_HOUSE_DOWN_CONTROL_TYPE") != null) {
								erpFunSalePublishInfo.setDownControl(StringUtil.parseByte(sysParamMap.get("SECOND_HOUSE_DOWN_CONTROL_TYPE")));
							}
							if (sysParamMap.get("SECOND_HOUSE_DOWN_RELAUNCH_DAY") != null) {
								try {
									int reLaunchDay = StringUtil.parseInteger(sysParamMap.get("SECOND_HOUSE_DOWN_RELAUNCH_DAY"));
									Date launchDate = DateUtil.addDay(new Date(), reLaunchDay);
									erpFunSalePublishInfo.setEstimatedRelaunchTime(launchDate);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							erpFunSalePublishInfoMapper.updateByExampleSelective(erpFunSalePublishInfo, erpFunSalePublishInfoExample);

							for (ErpFunSalePublishInfo publishInfo : erpFunSalePublishInfos) {
								// 请求threadTaskWeb
								LinkedHashMap<String, String> paramData = new LinkedHashMap<>();
								paramData.put("caseId", publishInfo.getSaleId().toString());
								paramData.put("caseType", "1");
								paramData.put("cityId", funUsersSel.getCityId().toString());
								paramData.put("syncState", "0");
								try {
									HttpUtilNew.post(AppConfig.getProperty("common.threadTaskWeb.path") + "/systemApi/syncMlhfStateData", paramData, null);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}

			}
		}

		if (sysParamMap.get("RENT_HOUSE_ALL_RELATED_MAN_DELETE") != null) {
			if ("1".equals(sysParamMap.get("RENT_HOUSE_ALL_RELATED_MAN_DELETE"))) {
				List<Integer> leaseIdsList = new ArrayList<>();
				for (HouseCaseIdDto leaseId : leaseIds) {
					if (leaseId != null) {
						leaseIdsList.add(leaseId.getHouseId());
					}
				}
				if (leaseIdsList.size() > 0) {
					List<HouseCaseIdDto> leaseList = erpFunLeasePublishInfoMapper.getWaitDownHouseList(funUsersSel.getCityId().intValue(), leaseIdsList);
					List<String> leaseIdList = new ArrayList<>();
					for (HouseCaseIdDto houseCaseIdDto : leaseList) {
						leaseIdList.add(houseCaseIdDto.getHouseId()+"");
					}
					if (leaseIdList.size() > 0) {
						ErpFunLeasePublishInfoExample erpFunLeasePublishInfoExample = new ErpFunLeasePublishInfoExample();
						erpFunLeasePublishInfoExample.createCriteria().andLeaseIdIn(leaseIdList).andWebsiteStateEqualTo("1");
						erpFunLeasePublishInfoExample.setShardCityId(funUsersSel.getCityId().intValue());
						List<ErpFunLeasePublishInfo> erpFunLeasePublishInfos = erpFunLeasePublishInfoMapper.selectByExample(erpFunLeasePublishInfoExample);
						if (erpFunLeasePublishInfos.size() > 0) {
							ErpFunLeasePublishInfo erpFunLeasePublishInfo = new ErpFunLeasePublishInfo();
							erpFunLeasePublishInfo.setWebsiteState("0");
							erpFunLeasePublishInfo.setWebsiteLastDownTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
							erpFunLeasePublishInfo.setMlhfState("0");
							erpFunLeasePublishInfo.setMlhfLastDownTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
							erpFunLeasePublishInfoMapper.updateByExampleSelective(erpFunLeasePublishInfo, erpFunLeasePublishInfoExample);
							for (ErpFunLeasePublishInfo publishInfo : erpFunLeasePublishInfos) {
								// 请求threadTaskWeb
								LinkedHashMap<String, String> paramData = new LinkedHashMap<>();
								paramData.put("caseId", publishInfo.getLeaseId().toString());
								paramData.put("caseType", "2");
								paramData.put("cityId", funUsersSel.getCityId().toString());
								paramData.put("syncState", "0");
								try {
									HttpUtilNew.post(AppConfig.getProperty("common.threadTaskWeb.path") + "/systemApi/syncMlhfStateData", paramData, null);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		if (CollUtil.isNotEmpty(houseIdList)) {
			String houseIdStr = CollUtil.join(houseIdList, ",");
			Map<String, String> haoFangParam = MapUtil.newHashMap();
			haoFangParam.put("houseId", houseIdStr);
			HttpUtil.post(AppConfig.getProperty("haoFangBaseUrl")+"/userreservation/noticeOfRemoval", haoFangParam);
		}
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
	public Byte updateHouseTrueFlag(Integer cityId,Integer caseId, ErpFunSale erpFunSale) {
		Byte trueHouseFlag = judgeTrueHouseForChangeInfo(erpFunSale.getPanoramaMap(), erpFunSale.getSaleMap().intValue(), erpFunSale.getTrueFlag(), erpFunSale.getVideoNum().intValue());
		// 如果可以则将真房源标记改为假的
		ErpFunSale erpFunSaleUpdate = new ErpFunSale();
		erpFunSaleUpdate.setSaleId(caseId);
		erpFunSaleUpdate.setShardCityId(cityId);
		if(Const.DIC_INFO_TRUE_INFO_FLAG_0.equals(trueHouseFlag)){
			erpFunSaleUpdate.setTrueFlag((byte)0);
		}
		erpFunSaleUpdate.setUpdateTime(new Date());
		erpFunSaleUpdate.setPanoramaMap(erpFunSale.getPanoramaMap());
		erpFunSaleUpdate.setVideoNum(erpFunSale.getVideoNum());
		erpFunSaleUpdate.setVideoReviewFlag(erpFunSale.getVideoReviewFlag());
		erpFunSaleUpdate.setThumbUrl(erpFunSale.getThumbUrl());
		erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSaleUpdate);
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
		boolean isPicTrueHouse = photoMap >= 5;
		if(!isPicTrueHouse){// 如果图片不满足
			return Const.DIC_INFO_TRUE_INFO_FLAG_0;
		}
		return Const.DIC_INFO_TRUE_INFO_FLAG_1;
	}

	/**
	 * 出售房源匹配求购客户
	 * @author 臧铁
	 * @param param  caseId 房客源ID  date 时间范围 deptId 门店ID matchType   SOURCE_DEPT_ID
	 * @param param  bound 匹配范围 0 全公司【本公司】 范围 1 共享圈 范围 3 好友圈 范围 CITY_SHARE 匹配城市公盘，排除本公司范围
	 * @param param  plateType 盘别 1抢盘2私盘3公盘  orderBy 排序方式
	 * @since 2017年5月23日
	 * @return
	 */
	@Override
	public List<?> getMatchBuyCustomerList(BaseMapParam param) throws Exception {
		String date = param.getString("date");
		String compBound = param.getString("bound");
		Integer currentDeptId = param.getInteger("currentDeptId");
		Integer currentGrId = param.getInteger("currentGrId");
		Integer currentAreaId = param.getInteger("currentAreaId");
		Integer currentRegId = param.getInteger("currentRegId");
		String orderBy = param.getString("orderBy");
		Integer caseId = param.getInteger("caseId");
		Integer cityId = param.getInteger("cityId");
		Integer currentCompId = param.getInteger("currentCompId");
		String userPosition = param.getString("userPosition");
		String matchItem = param.getString("matchItem");
		Integer currentUserId = param.getInteger("currentUserId");
		Integer compType = param.getInteger("compType");
		Boolean isPerLogin = (Boolean) param.getObject("isPerLogin");
		if (StringUtil.isNotBlank(date)) {
			String[] conStr = DateConvert.getConditionDate(date);
			param.setString("creationTime1", conStr[0]);
			param.setString("creationTime2", conStr[1]);
		}
		ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
		if (null != erpFunSale.getBuildId()) {
			param.setString("buildId", "%" + erpFunSale.getBuildId() + "%");
		}
		// 这个不能为null
		if (StringUtils.isBlank(matchItem)) {
			matchItem = "";
		}
		if (matchItem.contains("AREA")) {
			param.setObject("area", erpFunSale.getSaleArea());
		}
		if (matchItem.contains("FLOOR")) {
			param.setObject("floor", erpFunSale.getSaleFloor());
		}
		if (matchItem.contains("PRICE")) {
			param.setObject("totalPrice", erpFunSale.getSaleTotalPrice());
		}
		if (matchItem.contains("ROOM")) {
			param.setObject("saleRoom", erpFunSale.getSaleRoom());
		}
		param.setObject("saleUseage", erpFunSale.getSaleUseage());
		param.setObject("region", erpFunSale.getSaleReg());
		param.setString("orderBy", "CREATION_TIME DESC");
		if (StringUtil.isNotBlank(orderBy)) {// order by暂不清楚前端会传什么，如果排序有问题再加入进入
			if (StringUtil.contains(orderBy, new String[]{"CREATION_TIME"})) {
				//param.setString("orderBy", "CREATION_TIME DESC");
			}
		}
		if (isPerLogin == null || !isPerLogin) {// 不是精英版登录才判断权限
			String operColumn = erpUserOpersService.conditionMixByOperRange(Constants_DIC.DIC_PLATE_TYPE_ALL_EN, Constants_DIC.DIC_CASE_TYPE_BUY_CUST, cityId, currentCompId, currentUserId, currentGrId, compType, userPosition);
			if ("AREA".equals(operColumn)) {
				param.setString("operColumn", "AREA_ID");
				param.setInteger("operValue", currentAreaId);
			} else if ("REG".equals(operColumn)) {
				param.setString("operColumn", "REG_ID");
				param.setInteger("operValue", currentRegId);
			} else if ("DEPT".equals(operColumn)) {
				param.setString("operColumn", "DEPT_ID");
				param.setInteger("operValue", currentDeptId);
			} else if ("GROUP".equals(operColumn)) {
				param.setString("operColumn", "GR_ID");
				param.setInteger("operValue", currentGrId);
			}
		}
		List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getMatchBuyCustomerList(cityId, param.getMap());
		if (StringUtil.isBlank(compBound) || Constants_DIC.DIC_BOUND_0.equals(compBound)) {
			return buyCustomerList;
		}
		if (buyCustomerList == null || buyCustomerList.size() <= 0) {
			return buyCustomerList;
		}
		Set<Integer> userIdSet = new HashSet<>();
		buyCustomerList.stream().forEach(erpFunBuyCustomer -> {
			userIdSet.add(erpFunBuyCustomer.getUserId());
		});
		if(userIdSet.size() > 0) {// 有用户id时才查询
			List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
			Map<Integer, ErpFunUsers> userMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
			// 拼userName
			List<ErpFunBuyCustomerDto> resultVos = new LinkedList<>();
			buyCustomerList.stream().forEach(erpFunBuyCustomer -> {
				ErpFunUsers funUsers = userMap.get(erpFunBuyCustomer.getUserId());
				ErpFunBuyCustomerDto erpFunBuyCustomerDto = new ErpFunBuyCustomerDto();
				erpFunBuyCustomerDto.setErpFunBuyCustomer(erpFunBuyCustomer);
				if (funUsers != null) {
					erpFunBuyCustomerDto.setUserName(funUsers.getUserName());
				}
				resultVos.add(erpFunBuyCustomerDto);
			});
			return resultVos;
		}
		return buyCustomerList;
	}
	
	/**
	 * 查询房源所属人
	 * @author 熊刚
	 * @since 2017年10月18日
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	@Override
	public Integer[] getCurrentArchiveId(Integer cityId,Integer caseId, Integer caseType){
		Integer archiveId = 0;
		Integer trueFlag = 0;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			ErpFunSale erpFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId, caseId);	
			if(null != erpFunSale){
				archiveId = erpFunSale.getArchiveId();
				if(null != erpFunSale.getTrueFlag()) {
					trueFlag = erpFunSale.getTrueFlag().intValue();
				}
			}
		}else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, caseId);
			if(null != erpFunLease){
				archiveId = erpFunLease.getArchiveId();
				if(null != erpFunLease.getTrueFlag()) {
					trueFlag = erpFunLease.getTrueFlag().intValue();
				}
			}
		}else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			if(null != erpFunBuyCustomer){
				archiveId = erpFunBuyCustomer.getArchiveId();
				trueFlag = 2;
			}
		}else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			if(null != erpFunRentCustomer){
				archiveId = erpFunRentCustomer.getArchiveId();
				trueFlag = 2;
			}
		}
		return new Integer[]{archiveId, trueFlag};
	}
	
	/**
	 * 获取重复房源信息
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	@Override
	public Map<String, String> getAddrRepetCount(Integer cityId, Integer compId, Integer caseId,
			Integer caseType, String judgeRepetWithAll, Integer buildId, String roof, String unit,
			String floor, String num, String tradeAddr, Byte useage, boolean isPersonalVersion, Integer selfUserId,
			Integer houseAreaId, Integer houseRegId, Integer houseDeptId, Integer houseGrId){
		Map<String, String> addrMap = new HashMap<>();
		// 生成MD5
		List<String> md5StrList = erpSysParaService.encodeToMD5(roof, unit, floor, num, buildId, useage, tradeAddr, cityId, compId);
		if(buildId == null || md5StrList == null || md5StrList.size() <= 0) {
			return addrMap;
		}
		// 商铺、厂房、仓库、车库
		String tradeAddrCon = null, numCon = null;
		if (Const.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
			|| Const.DIC_HOUSE_USEAGE_STORE.equals(useage)
			|| Const.DIC_HOUSE_USEAGE_GARAGE.equals(useage)
			|| Const.DIC_HOUSE_USEAGE_TRADE.equals(useage)) {
			// 1=地址与号位，只要其中一项重复，则判为重盘 2=地址与号位，同时重复，则判为重盘
			String shopWarehouseRepeatType = erpSysParaMapper.getParamValue(cityId, compId, "SHOP_WAREHOUSE_REPEAT_TYPE");
			if ("1".equals(shopWarehouseRepeatType)) {
				numCon = num;
				tradeAddrCon = tradeAddr;
			}
		}
		Byte[] useageArr = null;
		if (Const.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
				|| Const.DIC_HOUSE_USEAGE_STORE.equals(useage)
				|| Const.DIC_HOUSE_USEAGE_GARAGE.equals(useage)) {
			useageArr = new Byte[] {Const.DIC_HOUSE_USEAGE_MANUFACT, Const.DIC_HOUSE_USEAGE_STORE, Const.DIC_HOUSE_USEAGE_GARAGE};
		} else if (Const.DIC_HOUSE_USEAGE_TRADE.equals(useage)) {// 商铺 只与 商铺 判重
			useageArr = new Byte[] {Const.DIC_HOUSE_USEAGE_TRADE};
		}
		selfUserId = isPersonalVersion ? selfUserId : null;// 非精英版不使用用户ID条件
		List<Map<String, Object>> poList = null;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			poList = erpFunSaleMapper.getAddrRepetList(cityId, compId, selfUserId, buildId, md5StrList, useageArr, tradeAddrCon, numCon);
		} else {
			poList = erpFunLeaseMapper.getAddrRepetList(cityId, compId, selfUserId, buildId, md5StrList, useageArr, tradeAddrCon, numCon);
		}
		int compEffectiveCount = 0;
		int realRepeatCount = 0;// 真正的重复数量
		int repeatCount = 0;
		int dealRepeatCount = 0;// 与成交房源的重复数
		// 非纯精英版才判断门店范围内的地址重复数据，少一个循环
		Integer tempCount = 0;
		Integer tempMyDeptCount = 0;
		StringBuilder caseNoSb = new StringBuilder();
		// 传的不是null强制使用这个参数，否则再查系统参数
		if (judgeRepetWithAll == null) {
			judgeRepetWithAll = erpSysParaMapper.getParamValue(cityId, compId, "JUDGE_REPET_WITH_ALL");
		}
		// 房源重复数据判重范围 1=公司 2=大区 3=片区 4=门店 5=分组
		String houseRepeatRange = erpSysParaMapper.getParamValue(cityId, compId, "HOUSE_REPEAT_RANGE");
		for (Map<String, Object> tmpHousePo : poList) {
			if (caseId != null && caseId.equals(StringUtil.parseInteger(tmpHousePo.get("caseId")))) {
				continue;// 跳过当前数据
			}
			boolean isNeedAddCompCount = true;
			if ("2".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseAreaId.equals(StringUtil.parseInteger(tmpHousePo.get("areaId")));
			} else if ("3".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseRegId.equals(StringUtil.parseInteger(tmpHousePo.get("regId")));
			} else if ("4".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseDeptId.equals(StringUtil.parseInteger(tmpHousePo.get("deptId")));
			} else if ("5".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseGrId.equals(StringUtil.parseInteger(tmpHousePo.get("grId")));
			}
			String status = String.valueOf(tmpHousePo.get("status"));
			if ("1".equals(judgeRepetWithAll)) {
				if (isNeedAddCompCount) {// 判重范围允许判重，不需要加这个值，不然录入不进去
					compEffectiveCount++;// 公司开了与所有数据判重，不管是否有效
				}
				realRepeatCount++;
			} else if (Constants_DIC.DIC_HOUSE_STATUS_RESPITE.equals(status)
					|| Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(status)
					|| Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(status)
					|| Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE.equals(status)) {
				if (isNeedAddCompCount) {// 判重范围允许判重，不需要加这个值，不然录入不进去
					compEffectiveCount++;// 这个量只统计有效的
				}
				realRepeatCount++;
			}
			String houseStatus = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_STATUS", status);
			if (StringUtils.isNotBlank(houseStatus)) {
				repeatCount++;
				if (repeatCount < 4) {
					if (caseNoSb.length() > 0) {
						caseNoSb.append("、");
					}
					caseNoSb.append("<a style=\"color:#259CF3;text-decoration: none;\" href=\"").append(tmpHousePo.get("caseId"))
					.append(",").append(caseType)
					.append(",").append(tmpHousePo.get("useage")).append("\">")
					.append(tmpHousePo.get("caseNo"))
					.append("</a>")
					.append("(").append(houseStatus).append(")");
				}
			}
			// 成交的重复数量
			if (Constants_DIC.DIC_HOUSE_STATUS_DEAL.equals(status)
					|| Constants_DIC.DIC_HOUSE_STATUS_INNERDEAL.equals(status)) {
				dealRepeatCount++;
			}
			// 本门店的重复数量
			if (houseDeptId.equals(StringUtil.parseInteger(tmpHousePo.get("deptId")))) {
				tempCount = StringUtil.paseInteger(addrMap.get("myDeptCount" + status), 0);
				if (tempCount == null) {
					tempCount = 0;
				}
				addrMap.put("myDeptCount" + status, String.valueOf(tempCount + 1));
				if ("1".equals(judgeRepetWithAll)) {
					tempMyDeptCount++;// 公司开了与所有数据判重，不管是否有效
				} else {
					if (Constants_DIC.DIC_HOUSE_STATUS_RESPITE.equals(status)
							|| Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(status)
							|| Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(status)
							|| Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE.equals(status)) {
						tempMyDeptCount++;// 这个量只统计有效的
					}
				}
			} else {// 其他门店的重复数量
				tempCount = StringUtil.paseInteger(addrMap.get("otherDeptCount" + status), 0);
				if (tempCount == null) {
					tempCount = 0;
				}
				addrMap.put("otherDeptCount" + status, String.valueOf(tempCount + 1));
			}
		}
		if (repeatCount >= 4) {
			caseNoSb.append("等").append(repeatCount).append("条");
		}
		addrMap.put("caseNos", caseNoSb.toString());
		addrMap.put("deptCount", String.valueOf(tempMyDeptCount));
		addrMap.put("compCount", String.valueOf(compEffectiveCount));
		addrMap.put("realRepeatCount", String.valueOf(realRepeatCount));
		addrMap.put("dealRepeatCount", String.valueOf(dealRepeatCount));
		return addrMap;
	}
	
	@Override
	public Map<String, String> detectPhoneRepeat(Integer cityId, Integer compId, Integer caseId, Integer caseType, String[] phoneArr,
			String judgeRepetWithAll, boolean isPersonalVersion, Integer selfUserId, Integer selfDeptId, 
			Integer houseAreaId, Integer houseRegId, Integer houseDeptId, Integer houseGrId) {
		Map<String, String> addrMap = new HashMap<>();
		// 纯精英版只判断个人重复数据
		if (phoneArr == null || phoneArr.length <= 0) {
			return addrMap;// 没有获取到电话，不需要查数据库是否重复了
		}
		// 电话加密后去查询数据库
		for (int i = 0; i < phoneArr.length; i++) {
			phoneArr[i] = EnCodeHelper.encode(phoneArr[i]);
		}
		String houseRepeatRangeParam = "HOUSE_REPEAT_RANGE";
		selfUserId = isPersonalVersion ? selfUserId : null;// 非精英版不使用用户ID条件
		List<Map<String, Object>> phoneRepeatList = null;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			phoneRepeatList = erpFunSaleMapper.getPhoneRepeatList(cityId, compId, selfUserId, phoneArr);
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			phoneRepeatList = erpFunLeaseMapper.getPhoneRepeatList(cityId, compId, selfUserId, phoneArr);
		} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			houseRepeatRangeParam = "CUST_REPEAT_RANGE";
			phoneRepeatList = erpFunBuyCustomerMapper.getPhoneRepeatList(cityId, compId, selfUserId, phoneArr);
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			houseRepeatRangeParam = "CUST_REPEAT_RANGE";
			phoneRepeatList = erpFunRentCustomerMapper.getPhoneRepeatList(cityId, compId, selfUserId, phoneArr);
		}
		// 如果没有
 		if (phoneRepeatList.isEmpty()) {
			return addrMap;
		}
		int repeatCount = 0;
		Integer tempCount = 0;
		int compEffectiveCount = 0;
		int realCompRepeatCount = 0;
		int realMyDeptRepeatCount = 0;
		Integer tempMyDeptCount = 0;
		if (judgeRepetWithAll == null) {
			judgeRepetWithAll = erpSysParaMapper.getParamValue(cityId, compId, "JUDGE_REPET_WITH_ALL");
		}
		// 房源重复数据判重范围 1=公司 2=大区 3=片区 4=门店 5=分组
		String houseRepeatRange = erpSysParaMapper.getParamValue(cityId, compId, houseRepeatRangeParam);
		StringBuilder caseNoSb = new StringBuilder();
		for (Map<String, Object> dataObject : phoneRepeatList) {
			if (caseId != null && caseId.equals(StringUtil.parseInteger(dataObject.get("caseId")))) {
				continue;// 跳过当前数据
			}
			boolean isNeedAddCompCount = true;
			if ("2".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseAreaId.equals(StringUtil.parseInteger(dataObject.get("areaId")));
			} else if ("3".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseRegId.equals(StringUtil.parseInteger(dataObject.get("regId")));
			} else if ("4".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseDeptId.equals(StringUtil.parseInteger(dataObject.get("deptId")));
			} else if ("5".equals(houseRepeatRange)) {
				isNeedAddCompCount = houseGrId.equals(StringUtil.parseInteger(dataObject.get("grId")));
			}
			String status = String.valueOf(dataObject.get("status"));
			String houseStatus = erpDicDefinitionsMapper.getDicCnMsg(cityId, "HOUSE_STATUS", status);
			if (houseStatus != null) {
				repeatCount++;
				if (repeatCount < 4) {
					if (caseNoSb.length() > 0) {
						caseNoSb.append("、");
					}
					caseNoSb.append("<a style=\"color:#259CF3;text-decoration: none;\" href=\"").append(dataObject.get("caseId"))
					.append(",").append(caseType)
					.append(",").append(dataObject.get("useage")).append("\">")
					.append(dataObject.get("caseNo"))
					.append("</a>")
					.append("(").append(houseStatus).append(")");
				}
			}
			// 如果是本门店房源且该房源不是第一个登记的则++
//			if (caseId != null && caseId.equals(phoneRepeatList.get(0).get("caseId"))) {
//				continue;
//			}
			if ("1".equals(judgeRepetWithAll)) {// 公司开了与所有数据判重，不管是否有效
				if (isNeedAddCompCount) {
					compEffectiveCount++;// 全公司
					tempMyDeptCount++;// 本门店
				}
				realCompRepeatCount++;// 全公司真正重复数
				realMyDeptRepeatCount++;// 本门店真正重复数
			} else {
				if(Constants_DIC.DIC_HOUSE_STATUS_RESPITE.equals(status) ||
						Constants_DIC.DIC_HOUSE_STATUS_SPECIAL.equals(status) ||
						Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE.equals(status) ||
						Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE.equals(status)) {
					if (isNeedAddCompCount) {
						compEffectiveCount++;// 全公司
					}
					realCompRepeatCount++;// 全公司真正重复数
					if (selfDeptId.equals(StringUtil.parseInteger(dataObject.get("deptId")))) {
						if (isNeedAddCompCount) {
							tempMyDeptCount++;// 本门店
						}
						realMyDeptRepeatCount++;// 本门店真正重复数
					}
				}
			}
			if (selfDeptId.equals(StringUtil.parseInteger(dataObject.get("deptId")))) {
				tempCount = StringUtil.paseInteger(addrMap.get("myDeptCount" + status), 0);
				if (tempCount == null) {
					tempCount = 0;
				}
				addrMap.put("myDeptCount" + dataObject.get("status"), String.valueOf(tempCount + 1));
			} else {
				tempCount = StringUtil.paseInteger(addrMap.get("otherDeptCount" + status), 0);
				if (tempCount == null) {
					tempCount = 0;
				}
				addrMap.put("otherDeptCount" + status, String.valueOf(tempCount + 1));
			}
		}
		if (repeatCount >= 4) {
			caseNoSb.append("等").append(repeatCount).append("条");
		}
		addrMap.put("realCompRepeatCount", String.valueOf(realCompRepeatCount));
		addrMap.put("realMyDeptRepeatCount", String.valueOf(realMyDeptRepeatCount));
		addrMap.put("compCount", String.valueOf(compEffectiveCount));
		addrMap.put("deptCount", String.valueOf(tempMyDeptCount));
		addrMap.put("caseNos", caseNoSb.toString());
		return addrMap;
	}
	
	@Override
	public void cancelAds(Integer cityId, Integer compId, Integer caseId, String caseNo) {
		ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
		erpFunSale.setAdsFlag(Byte.valueOf(Constants_DIC.DIC_ADS_CASE_STATUS_0));
		ErpFunAdsContent erpFunAdsContent = erpFunAdsContentMapper.getErpFunAdsContentByCaseNo(cityId,caseNo);
		if(erpFunAdsContent!=null){
			erpFunAdsContent.setAdsStatus(Byte.valueOf(Constants_DIC.DIC_ADS_CASE_STATUS_0));
		}
	}

	@Override
	public List<Map<String, Object>> testSaleSql(int cityId, Integer allColumn) {
		return erpFunSaleMapper.testSaleSql(cityId, allColumn);
	}

	@Override
	public List<Map<String, Object>> testLeaseSql(int cityId, Integer allColumn) {
		return erpFunLeaseMapper.testLeaseSql(cityId, allColumn);
	}

	@Transactional
	@Override
	public void createTrack4TransData(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		
		Date dateNow = new Date();
		ErpFunSale saleUpdate = new ErpFunSale();
		saleUpdate.setShardCityId(param.getCityId());
		saleUpdate.setSaleId(param.getCaseId());
		saleUpdate.setRedFlag(false);
		saleUpdate.setSaleSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		saleUpdate.setSaleLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		saleUpdate.setUpdateTime(dateNow);
		saleUpdate.setSyncTime(dateNow);
		saleUpdate.setActionTime(dateNow);
		saleUpdate.setTrackTime(dateNow);
		saleUpdate.setTrackTime2(dateNow);// 只有房源才更新
		saleUpdate.setSendtotencent((byte) 0);// 移交的数据要从腾讯下架
		saleUpdate.setTrueFlag(Const.DIC_INFO_TRUE_INFO_FLAG_0);// 下架真房源
		// 移交之后的信息
		saleUpdate.setUserId(createAuditUser.getUserId());
		saleUpdate.setArchiveId(createAuditUser.getArchiveId());
		saleUpdate.setAreaId(createAuditUser.getAreaId());
		saleUpdate.setRegId(createAuditUser.getRegId());
		saleUpdate.setDeptId(createAuditUser.getDeptId());
		saleUpdate.setGrId(createAuditUser.getGrId());
		boolean sysRunModelIsPrivate = erpSysParaService.getSysRunModelIsPrivate(param.getCaseType(), param.getCityId(), param.getCompId());
		if (sysRunModelIsPrivate) {
			saleUpdate.setPrivateTime(dateNow);
			saleUpdate.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		} else {
			saleUpdate.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		boolean isUserRight = adminFunArchiveService.isUserRight(createAuditUser.getArchiveId());
		if (!isUserRight) {
			saleUpdate.setSaleCooperate(false);
			saleUpdate.setCityShareFlag((byte) 0);
		}
		// 任务失效
		erpFunTaskService.cancelAuditTaskForWriteoff(param.getCityId(), param.getCompId(), param.getCaseId(),
				param.getCaseType(), param.getTrackType());
		// 更新数据
		erpFunSaleMapper.updateByPrimaryKeySelective(saleUpdate);
		// 更新钥匙所在门店
		erpFunKeyMapper.updateErpFunKey(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType(),
				createAuditUser.getDeptId());
		// 更新电话表所属人
		erpFunPhoneMapper.updateBelongUser(param.getCityId(), param.getCaseId(), param.getCaseType(), createAuditUser);
		// 修改城市大工盘数据
		ErpCityshareHouse shareHouseUpdate = new ErpCityshareHouse();
		shareHouseUpdate.setShardCityId(param.getCityId());
		shareHouseUpdate.setUserId(createAuditUser.getUserId());
		shareHouseUpdate.setArchiveId(createAuditUser.getArchiveId());
		shareHouseUpdate.setDeptId(createAuditUser.getDeptId());
		shareHouseUpdate.setCaseId(param.getCaseId());
		shareHouseUpdate.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN.byteValue());
		erpCityshareHouseMapper.transDataByCaseId(param.getCityId(), shareHouseUpdate);
		// 修改跟进
//		erpFunTrackMapper.updateTrackByCaseId(param.getCityId(), Const.DIC_CASE_TYPE_SALE_FUN, createAuditUser);
	}

	@Transactional
	@Override
	public void updateHouseExtension(Integer cityId, Integer archiveId, String endTime, String nowDate, Integer compId) {
		List<Integer> archiveIds = new ArrayList<>();
		archiveIds.add(archiveId);
		// 下架 真房源
		erpFunSaleMapper.updatePublishAndTrueFlagByArchiveId(cityId, compId, archiveIds, null);
		// 下架 竞价房源
		erpFunHouseBiddingMapper.updateBiddingEndTimeToLastTime(cityId, archiveIds, endTime,nowDate);
		adminFunHouseBiddingMapper.updateBiddingEndTimeToLastTime(archiveIds, endTime, nowDate);
		// 下架 小区专家
		adminFunBuildingBiddingMapper.updateBiddingEndTimeToLastTime(archiveIds, endTime, nowDate);
		// 下架 新盘顾问
		agencyFunNewBuildingBiddingMapper.updateEndTimeToLastTime(archiveIds, endTime, nowDate);
	}

	@Transactional
	@Override
	public void updateHouseExtensionDept(Integer compId, Integer deptId, Integer cityId, String endTime, String nowDate) {
		// 下架 真房源
		// 下架 竞价房源
		List<Integer> archiveIds = new ArrayList<>();
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardCityId(cityId);
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		if(null != funUsersList && funUsersList.size() >0){
			archiveIds = funUsersList.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toList()));
			erpFunSaleMapper.updatePublishAndTrueFlagByArchiveId(cityId, compId, archiveIds, deptId);
			erpFunHouseBiddingMapper.updateBiddingEndTimeToLastTime(cityId, archiveIds, endTime,nowDate);
			adminFunHouseBiddingMapper.updateBiddingEndTimeToLastTime(archiveIds, endTime, nowDate);
			// 下架 小区专家
			adminFunBuildingBiddingMapper.updateBiddingEndTimeToLastTime(archiveIds, endTime, nowDate);
			// 下架 新盘顾问
			agencyFunNewBuildingBiddingMapper.updateEndTimeToLastTime(archiveIds, endTime, nowDate);
		}
	}

	/**
	 * 出售房源数据移交
	 *
	 * @param param
	 * @return
	 * @author 李成兵
	 * @since 2018/4/23
	 */
	@Transactional
	@Override
	public void dataTranslate(ErpFunSale updateModel, ErpFunUsers acceptUser, List<ErpFunSale> casePOListTmp, DataTranslateParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		
		if (casePOListTmp == null || casePOListTmp.isEmpty()) {
			throw new BusinessException("数据错误，请重新查询后再进行移交！");
		}
		// 真房源列表
		Set<Integer> caseIdSetTrue = casePOListTmp.stream().filter(val -> Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(val.getTrueFlag()))
				.collect(Collectors.mapping(val -> val.getSaleId(), Collectors.toSet()));
		List<Integer> caseIds = casePOListTmp.stream().collect(Collectors.mapping(val -> val.getSaleId(), Collectors.toList()));
		List<String> caseNos = casePOListTmp.stream().collect(Collectors.mapping(val -> val.getSaleNo(), Collectors.toList()));
		boolean userRightFlag = false;
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			if (!CommonUtil.isnull(acceptUser)) {
				userRightFlag = adminFunArchiveService.isUserRight(acceptUser.getArchiveId());
			}
			// todo 包含真房源情况
			if (caseIdSetTrue.size() > 0) {
				//ThreadLocalUtil.setEXTRA("HAVE_TRUEHOUSE");
			}
			List<AdminTrueHouseComplaint> complaintPOList = adminTrueHouseComplaintMapper.getComplaintList(caseIds,
					caseType, srcUserId, cityId, compId);
			if (complaintPOList != null && complaintPOList.size() > 0) {
				Map<Integer, AdminTrueHouseComplaint> complaintMap = complaintPOList.stream().collect(Collectors.toMap(AdminTrueHouseComplaint::getCaseId, val -> val));
				// 将真房源从这里面移除
				for (int i = casePOListTmp.size() - 1; i >= 0; i--) {
					ErpFunSale funSale = casePOListTmp.get(i);
					if (complaintMap.containsKey(funSale.getSaleId())) {
						casePOListTmp.remove(i);
						caseIds.remove(funSale.getSaleId());
						caseNos.remove(funSale.getSaleNo());
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
			updateModel.setSaleCooperate(false);
			updateModel.setCityShareFlag((byte) 0);
		}
		// STEP 1. 写跟进
		String[] caseNoArr = caseNos.toArray(new String[]{});
		// 注意4种房客源虽然是同样的逻辑但是类型不同，一定要区分清
		erpFunTrackService.createTrackForTransData(cityId, acceptUser, caseType, caseIds, caseNoArr,
				updateModel.getPlateType(), param);
		// STEP 7更新竞价数据的所属人 说明不是移交到抢盘
		erpFunHouseBiddingService.updateHouse4TransDataArchiveId(caseType, caseIds, param);
		// STEP 2. 处理相关提醒任务
		if (!CommonUtil.isnull(acceptUser) && !"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			// 移交原始人不是公盘或抢盘,移交目标是经纪人时才更新提醒任务
			erpFunTaskService.updateTaskForTransData(acceptUser, caseType, param, caseIds);
		}
		// STEP 3. 写提醒任务
		if (acceptUser != null) {// 当移交目标是经纪人时才写提醒任务,并且只写一条
			erpFunTaskService.createTaskForTransData(cityId, caseIds, acceptUser, caseNoArr, caseType, caseIds.size(), param);
		}
		// STEP 5. 进行数据移交
		ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
		funSaleExample.setShardCityId(cityId);
		funSaleExample.createCriteria().andCompIdEqualTo(compId).andSaleIdIn(caseIds);
		erpFunSaleMapper.updateByExampleSelective(updateModel, funSaleExample);
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
				erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.TRANS_SALE_DATA, tempSrcUserId, tempSrcDeptId, content,
				null, null, cityId, compId, param.getDeptId(), param.getCurrentUserId());
	}

	/**
	 * @tag 数据中是否存在已经成交或注销的信息
	 * @author 邓永洪
	 * @since 2018/4/28
	 */
	@Override
	public boolean detectTransData(DataTranslateParam param, String caseIds) {
		ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
		funSaleExample.setShardCityId(param.getCityId());
		funSaleExample.createCriteria().andSaleStatusIn(
				Arrays.asList(
					Const.DIC_HOUSE_STATUS_WRITEOFF,
					Const.DIC_HOUSE_STATUS_INNERDEAL,
					Const.DIC_HOUSE_STATUS_DEAL
				)
			).andSaleIdIn(StringUtil.toIntList(caseIds, ","));
		Integer count = erpFunSaleMapper.countByExample(funSaleExample);
		return count > 0;
	}

	/**
	 * @tag 判断指定员工的所有信息中是否存在已成交或注销信息
	 * @author 邓永洪
	 * @since 2018/4/28
	 */
	@Override
	public boolean detectTransDataByDeptIdAndUserId(DataTranslateParam param) {
		String srcUserId = param.getSrcUserId();
		ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
		funSaleExample.setShardCityId(param.getCityId());
		ErpFunSaleExample.Criteria criteria = funSaleExample.createCriteria();
		criteria.andCompIdEqualTo(param.getCompId()).andDeptIdEqualTo(param.getDeptId());
		if (!"share".equalsIgnoreCase(srcUserId) && !"public".equalsIgnoreCase(srcUserId)) {
			criteria.andUserIdEqualTo(StringUtil.parseInteger(srcUserId));
		} else if ("share".equalsIgnoreCase(srcUserId)) { // 公盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		} else if ("public".equalsIgnoreCase(srcUserId)) { // 抢盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		}
		criteria.andSaleStatusIn(Arrays.asList(
				Const.DIC_HOUSE_STATUS_WRITEOFF, Const.DIC_HOUSE_STATUS_INNERDEAL,
				Const.DIC_HOUSE_STATUS_DEAL)
			);
		Integer count = erpFunSaleMapper.countByExample(funSaleExample);
		return count > 0;
	}

	 @Override
	public PageInfo<FunSaleDto> getHouseSaleList(QueryHouseCustListParam param){
		// TODO Auto-generated method stub
		String status = param.getStatus();
		String shareCompNo = param.getCompNo();
		Integer cityId = param.getSelfCityId();
		Integer bound = param.getBound();
		// 传入的userId
		String userId = param.getPublicOrprivateUserId();
		Integer grId = param.getGrId();
		Integer deptId = param.getDeptId();
		Integer regId = param.getRegId();
		Integer areaId = param.getAreaId();
		String orderBy = param.getOrderBy();
		String colorFlag = param.getColorFlag();
		Integer isTopFloor = param.getIsTopFloor();
		Integer showCooperate = param.getShowCooperate();
//			boolean showCooperate = (1 == param.getShowCooperate());
		// 自己的数据
		Integer selfAreaId = param.getSelfAreaId();
		Integer selfRegId = param.getSelfRegId();
		Integer selfDeptId = param.getSelfDeptId();
		Integer selfGrId = param.getSelfGrId();
		Integer selfUserId = param.getSelfUserId();
		// 方便后面使用
		Integer tempInt = 1;
		Integer tempIntZero = 0;
		List<FunSaleDto> saleList = null;
		boolean havaFavorite = false;
		if (null != param.getTodayPublic() && 1 == param.getTodayPublic()) {
			//今日抢盘数据
			status = "PLATE_TYPE-1";
		}
		// 全公司以及加盟圈 //所有条件均为互斥条件
		QueryHouseCustListParam queryParam = param;
		// 加盟圈
		Integer shareCompId = null;
		List<Integer> shareCompIds = null;
		if ((StringUtils.isNotBlank(shareCompNo) || null != param.getShareId()) && param.isSelfCompModel()) {
			if (StringUtils.isBlank(shareCompNo)) {// 如果为空则使用本公司的NO
				shareCompNo = param.getSelfCompNo();
			}
			if (null != param.getShareId()) {
				// 排除shareCompNo
				shareCompIds = adminFunShareRelevanceService.getCompIdsByShareId(param.getShareId(), cityId);
				if (null == shareCompIds) {
					return new PageInfo<>(saleList);
				}
			}else if (StringUtils.isNotBlank(shareCompNo)) {
				List<String> compNoList = Arrays.asList(shareCompNo.split(","));
				if (compNoList.size() > 1) {
					shareCompIds = erpFunCompMapper.getCompIdsByCompNos(cityId, compNoList);
				} else {
					ErpFunComp erpFunComp = erpFunCompMapper.getCompByCompNo(shareCompNo);
					if(null != erpFunComp){
						shareCompId = erpFunComp.getCompId();
					}
				}
			}
		}
		// 根据bound参数判断筛选的数据范围 0 全公司 1 共享圈 2 全系统
		if (!Const.DIC_BOUND_0.equals(bound)) {
			return new PageInfo<>(saleList);
		}
		Integer conCompFlag = 0;
		if (null != shareCompId && null == shareCompIds) {// 加盟圈查询某个公司
			queryParam.setCompId(shareCompId);
			queryParam.setShareCompIds(null);
			if(null != deptId){
				queryParam.setDeptId(deptId);
			}
		} else if (null != shareCompIds && shareCompIds.size() > 0){
			queryParam.setShareCompId(shareCompId);
		} else {
			// TODO 这部分代码应该有问题
			if(null != grId){
				queryParam.setGrId(grId);
			} else if(null != deptId){
				queryParam.setDeptId(deptId);
			} else if(null != regId){
				queryParam.setRegId(regId);
			} else if(null != areaId){
				queryParam.setAreaId(areaId);
			}
			queryParam.setCompId(param.getSelfCompId());
			String plateTypeQuery = "";
			String range = "";
			if (Const.DIC_PLATE_TYPE_PUBLIC_EN.equals(userId) || "PLATE_TYPE-1".equals(status)) {
				plateTypeQuery = Const.DIC_PLATE_TYPE_PUBLIC_EN;
			} else if (Const.DIC_PLATE_TYPE_SHARE_EN.equals(userId) || "PLATE_TYPE-3".equals(status)) {
				plateTypeQuery = Const.DIC_PLATE_TYPE_SHARE_EN;
			}
			// userId这里的是表示人和盘别等，有多个值 
			range = erpUserOpersService.conditionMixByOperRange(plateTypeQuery, Constants_DIC.DIC_CASE_TYPE_SALE_FUN, cityId, param.getSelfCompId(), param.getSelfUserId(), param.getSelfGrId(), param.getSelfCompType(), param.getSelfUserPosition());
			if ("GROUP".equals(range)) {
				range = "GR";
			}
			queryParam.setRange(range);
			range = range + "_ID";
			//添加行政区控制
			String isRegSectionControllStr = erpSysParaMapper.getParamValue(cityId, param.getSelfCompId(), "IS_REG_SECTION_CONTROLL");
			if("1".equals(isRegSectionControllStr)){
				Integer flag = erpFunRegsectionControlService.buildHouseListQueryRegSection(queryParam, param.getCompId(), areaId, regId, deptId, grId, userId, range, cityId, selfAreaId, selfRegId, selfDeptId, selfGrId, selfUserId);
				queryParam.setRegSectionControllFlag(flag);
			}
		}
		String cityShareFlag = Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_1;
		if (param.isSelfIsYouUser()) {
			cityShareFlag = Constants_DIC.DIC_INFO_CITY_SHARE_FLAG_3;
		}
		if (!StringUtils.isBlank(orderBy)) {
			if (orderBy.contains("SALE_FLOOR")) {// 如果点击楼层排序,忽略合作房源数据
				showCooperate = 0;
			}
		}
		if (StringUtils.isNotBlank(colorFlag)) {// 如果传了警示标示,忽略合作房源数据
			showCooperate = 0;
		}
		if (null != isTopFloor && 1 == isTopFloor) {// 如果顶层查询,忽略合作房源数据
			showCooperate = 0;
		}
		// 查询本公司的数据或本城市合作房源
		showCooperate = ((null != showCooperate && 1 == showCooperate)
				&& StringUtils.isBlank(userId)
				&& StringUtils.isBlank(param.getCellPhone())
				&& (StringUtils.isBlank(status) || status.equals("HOUSE_STATUS-NORMAL") || status.equals("HOUSE_STATUS-1"))
				&& StringUtils.isBlank(param.getSaleNo()) && StringUtils.isBlank(param.getNum())
				&& null != param.getRoof() && null != param.getUnit()
				&& null != param.getFloor1() && null != param.getFloor2())?1:0;
		if (1 == showCooperate) {
			queryParam.setCityShareFlag(StringUtil.parseByte(cityShareFlag));
			queryParam.setCityId(cityId);
			if (null == param.getFloorsType()) { // 如果楼层检索为空,检索内部房源,否则检索合作房源
				conCompFlag = 1;
			} else {

			}
			// TODO 
			// conAll.add("OR", conCooperate);
			// 查询未跟进房源不显示合作房源
			if (CommonUtil.isnull(param.getEndtimeNoTrack())) {
				// condition.add(conAll);
			}
		} else {
			// condition.add(conComp);
		}
		queryParam.setShowCooperate(showCooperate);
		String timeColumn = erpSysParaService.getHouseCustTimeColumn(cityId, param.getSelfCompId());
		boolean tempAvailableTimeFlag = true;
		// 房源新增新增字段
		if(tempInt.equals(param.getXzCreationTime())
				|| (tempInt.equals(param.getHomePage()) && tempInt.equals(param.getDate()) && "NEW_ADDED".equals(status))){// 这行为经纪人专用的条件
			timeColumn = "CREATION_TIME";
			tempAvailableTimeFlag = false;
		}
		String orderBySelfFirst = "(CASE WHEN USER_ID = " + param.getSelfUserId() + " THEN 1 ELSE 3 END) ASC, " + timeColumn + " DESC";
		if(StringUtils.isBlank(orderBy)){
			if (StringUtils.isNotBlank(param.getSelfFirst())) {
				orderBy = orderBySelfFirst;
			}
			if(tempInt.equals(param.getTrackOrder()) && tempIntZero.equals(bound)){
				orderBy = "TRACK_TIME DESC, " + timeColumn + " DESC";
			} else if(StringUtils.isBlank(orderBy) && tempIntZero.equals(bound)){
				if (tempInt.equals(showCooperate)) {
					orderBy = timeColumn + " DESC";
				} else {
					orderBy = "(CASE WHEN SALE_LEVEL = 2 THEN 1 ELSE 2 END) ASC, " + timeColumn + " DESC";
				}
				if (StringUtils.isNotBlank(param.getSelfFirst())) {
					orderBy = orderBySelfFirst;
				}
			} else if (StringUtils.isNotBlank(orderBy) && 2 == bound) {
				orderBy = "TRACK_TIME DESC";
			} else {
				orderBy = timeColumn + " DESC";
			}
			queryParam.setOrderBy(orderBy);
		}
		// 查询盘别
		if(StringUtils.isNotBlank(param.getPlateTypes())){
			List<Integer> intList = StringUtil.toIntList(param.getPlateTypes());
			queryParam.setInPlateTypes(intList);
		}
		String statusTemp = status;
		if (StringUtils.isNotBlank(status) && status.contains("-")) {
			statusTemp = status.split("-").length > 0 ? status.split("-")[1] : status;
			queryParam.setStatusTemp(statusTemp);
		}
		if (StringUtils.isNotBlank(param.getNo())) {
			queryParam.setCompId(param.getSelfCompId());
			Integer innerNo = StringUtil.parseInteger(param.getNo(),0);
			if(0 == innerNo || null == innerNo){
				queryParam.setSaleNo(param.getNo());// 编号必须等于，有编号查询则忽略其他查询条件。
			} else {
				queryParam.setInnerNo(innerNo);
			}
		} else if (StringUtil.isNotBlank(param.getCellPhone()) && 0 == bound){
			String cellPhone = param.getCellPhone();
			cellPhone = EnCodeHelper.encode(cellPhone);
			queryParam.setCellPhone(cellPhone);
			queryParam.setBound(bound);
			if (status.equals("PLATE_TYPE-1") || status.equals("PLATE_TYPE-2") || status.equals("PLATE_TYPE-3")) {
				String tempStatus = status.split("-").length > 0 ? status.split("-")[1] : status;
				queryParam.setPlateType(StringUtil.parseByte(tempStatus));
				String searchByPhone = "0"; // 初始化权限值
				if(erpUserOpersService.judgePermission(cityId, param.getSelfUserId(), "SEARCH_BY_PHONE") || Const.DIC_COMP_TYPE_3.equals(param.getSelfCompType())){
					searchByPhone = "1";
				}
				queryParam.setSearchByPhone(searchByPhone);
			}
		} else {
			if (1 == param.getTodayPublic()) {
				//今日抢盘数据
				status = "PLATE_TYPE-1";
			}
			if (StringUtils.isNotBlank(param.getFitment())) {// 装修
				List<Integer> intList = StringUtil.toIntList(param.getFitment());
				queryParam.setInSaleFitments(intList);
			}

			if(StringUtil.isNotBlank(param.getBuildIds())){
				queryParam.setInBuildIds(StringUtil.toIntList(param.getBuildIds()));
			} else if(StringUtil.isNotBlank(param.getBuildName())){
				queryParam.setBuildName( "%" + param.getBuildName() + "%");
			}
			if(StringUtil.isNotBlank(param.getRoadsId())){
				queryParam.setInRoadIds(StringUtil.toIntList(param.getRoadsId()));
			}
			if(StringUtil.isNotBlank(param.getSectionIds())){
				queryParam.setInSectionIds(StringUtil.toIntList(param.getSectionIds()));
			}
			if(null != param.getRound()){
				queryParam.setSaleRound(param.getRound().byteValue());
			}
			if(null != param.getType()){
				queryParam.setSaleType(param.getType().byteValue());
			}
			if(null != param.getDate() && tempInt.equals(param.getHomePage())){
				String[] conStr = DateConvert.getConditionDate(param.getHomePage().toString());
				queryParam.setStartTime(conStr[0]);
				queryParam.setEndTime(conStr[1]);
				if(null != param.getZhTrackTime()){
					queryParam.setZhTrackTime(param.getZhTrackTime());
				} else if (StringUtil.isNotBlank(status)){
					if(status.equals("HOUSE_STATUS-5") || status.equals("HOUSE_STATUS-6")){ // 内、外成交
						queryParam.setDealTime(DateTimeHelper.parseToDate(conStr[0]));
					} else if (status.equals("HOUSE_STATUS-7")){
						queryParam.setWriteoffTime(DateTimeHelper.parseToDate(conStr[0]));
					} else if (1 == param.getTodayPublic()){
						// 今日抢盘不加AVAILABLE_TIME的限制条件
					} else {
						// XML还没写
						builderTimeAreaCondition(queryParam, conStr[0], conStr[1], timeColumn);
					}
				}
			} else if (null != param.getDate()){
				String[] conStr = DateConvert.getConditionDate(param.getHomePage().toString());
				builderTimeAreaCondition(queryParam, conStr[0], conStr[1], timeColumn);
			}
			// 栋座查询
			if (StringUtil.isNotBlank(param.getUnit()) || StringUtil.isNotBlank(param.getRoof()) || StringUtil.isNotBlank(param.getNum())){
				if(StringUtil.isNotBlank(param.getBuildIds())){
					queryParam.setInBuildIds(StringUtil.toIntList(param.getBuildIds()));
				}
				if(StringUtil.isNotBlank(param.getRoof())){
					if(param.getRoof().matches("^[0-9A-Za-z]{0,}$")){
						queryParam.setHouseRoof(param.getRoof());
					} else {
						queryParam.setLikeHouseRoof("%" + param.getRoof() + "%");
					}
				}
				if(StringUtil.isNotBlank(param.getNum())){
					if(param.getNum().matches("^[0-9A-Za-z]{0,}$")){
						queryParam.setHouseNum(param.getNum());
					} else {
						queryParam.setLikeHouseNum("%" + param.getNum() + "%");
					}
				}
				if(StringUtil.isNotBlank(param.getUnit())){
					if(param.getUnit().matches("^[0-9A-Za-z]{0,}$")){
						queryParam.setHouseUnit(param.getUnit());
					} else {
						queryParam.setLikeHouseUnit("%" + param.getUnit() + "%");
					}
				}
			}
			if("HOUSE_STATUS-3".equals(param.getLevel())){
				queryParam.setLevel(param.getLevel());
			} else if (StringUtil.isNotBlank(param.getLevel())){
				queryParam.setLevel(param.getLevel().replaceAll("HOUSE_LEVEL_", ""));
			}
			if(null != param.getSaleDirects()){
				queryParam.setInsaleDirects(StringUtil.toIntList(param.getSaleDirects()));
			}
			if(StringUtil.isNotBlank(param.getDataRange())){
				String[] val = param.getDataRange().split("~");
				// 必须是两个单位
				if (val.length == 2 && StringUtil.isNotBlank(val[0]) && StringUtil.isNotBlank(val[1])) {
					String startTime = val[0];
					if(val[0].length() < 15) {
						startTime = val[0] + " 00:00:00";
					}

					String endTime = val[1];
					if(val[1].length() < 15) {
						endTime = val[1] + " 23:59:59";
					}
					// 用dataRange1、dataRange2零食存储用于XML写逻辑
					queryParam.setDataRange1(startTime);
					queryParam.setDataRange2(startTime);
					builderTimeAreaCondition(queryParam, startTime, endTime, timeColumn);
				}
			}
			if(null != param.getEndtimeNoTrack()){
				String[] conStr = DateConvert.getConditionDate(param.getEndtimeNoTrack().toString());
				queryParam.setStartTime(conStr[0]);
				queryParam.setTrackTime(DateTimeHelper.parseToDate(conStr[0]));
			}
		}
		// 这里只查询收藏列表
		if(tempInt.equals(param.getFavorite())){
			// 查询当前人的收藏
			saleList = erpFunSaleMapper.getHouseSaleList(cityId, queryParam);
			havaFavorite = true;
		} else {
			PageHelper.startPage(queryParam.getPageNum(), queryParam.getPageSize(), true);
			saleList = erpFunSaleMapper.getHouseSaleList(cityId, queryParam);
		}
		PageInfo<FunSaleDto> pageInfo = new PageInfo<>(saleList);
		// 修改VO的其他信息
		updateSaleInfo(saleList, havaFavorite, queryParam.getWideList(), queryParam.getCityId(), param.getSelfCompId(), param.getSelfUserId(), param.getSelfArchiveId());
		return pageInfo;
	}

	private void builderTimeAreaCondition(QueryHouseCustListParam queryParam, String beforeTime, String afterTime, String fieldName){
		if (StringUtils.isNotBlank(beforeTime)) {
			if("CREATION_TIME".equals(fieldName)){
				queryParam.setCreationTimeStart(DateTimeHelper.parseToDate(beforeTime));
			}
			if("AVAILABLE_TIME".equals(fieldName)){
				queryParam.setAvailableTimeStart(DateTimeHelper.parseToDate(beforeTime));
			}
		}
		if (StringUtils.isNotBlank(afterTime)) {
			if("CREATION_TIME".equals(fieldName)){
				queryParam.setCreationTimeEnd(DateTimeHelper.parseToDate(afterTime));
			}
			if("AVAILABLE_TIME".equals(fieldName)){
				queryParam.setAvailableTimeEnd(DateTimeHelper.parseToDate(afterTime));
			}
		}
	}
	
	/**
	 * @param saleList
	 * @param havaFavorite
	 * @param wideList
	 * @param cityId
	 * @param selfCompId
	 * @param selfUserId
	 * @param selfArchiveId
	 */
	private void updateSaleInfo(List<FunSaleDto> saleList, boolean havaFavorite, Integer wideList, Integer cityId, Integer selfCompId, Integer selfUserId, Integer selfArchiveId){
		if (null == saleList || saleList.size() <= 0) {
			return;
		}
		List<Integer> archiveIdList = saleList.stream().collect(Collectors.mapping(FunSaleDto::getArchiveId, Collectors.toList()));// archiveIds
		Set<Integer> buildIdsSet = saleList.stream().collect(Collectors.mapping(FunSaleDto::getBuildId, Collectors.toSet()));// 楼盘IDs
		List<Integer> saleIdsList = saleList.stream().collect(Collectors.mapping(FunSaleDto::getSaleId, Collectors.toList()));
		Set<Integer> userIdSet = new HashSet<Integer>();// 用户IDs
		Set<Integer> deptIdSet = saleList.stream().collect(Collectors.mapping(FunSaleDto::getDeptId, Collectors.toSet()));
		Set<Integer> otherCompCaseIdsSet = new HashSet<>();
		Set<Integer> saleLeaseSet = new HashSet<>();
		for (FunSaleDto funSale : saleList) {
//			// 楼层高,中,低,超高判断
			Integer floors = funSale.getSaleFloors();// 获取总楼层
			Integer floor = (null == funSale.getSaleFloor())?0:funSale.getSaleFloor().intValue();// 获取当前楼层
			Integer floorType = CommonUtil.getBuildFloorType(floor, floors);
			funSale.setFloorsType(floorType);
			if (null != funSale.getUserId()) {
				userIdSet.add(funSale.getUserId());
			}
			if(funSale.getCityShareFlag() > 0) {
				otherCompCaseIdsSet.add(funSale.getSaleId());
			}
			// 租售房源IDs
			if(1 == funSale.getIsSaleLease()) {
				saleLeaseSet.add(funSale.getSaleLeaseId());
			}
		}
		List<ErpFunKeyRemark> funKeyRemarkList = erpFunKeyRemarkMapper.getFunKeyRemarkList(cityId, null, saleIdsList, Const.DIC_CASE_TYPE_SALE_FUN);
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
		Map<Integer, ErpFunUsers> funUsersMap = funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val ->val));
		Map<Integer, ErpFunCaseFavorite> favoriteMap = null;// 我的收藏
		Map<Integer, String> countDownMap = null;// 发发状态
		Map<Integer, AdminFunBuildingBidding> biddingMap = null;// 小区专家
		List<AdminFunBuildingBidding> willBiddPos = null;// 小区专家预约下一期的
		Map<Integer, AdminFunArchive> archiveMap = null;// 小区专家经纪人信息
		Map<Integer, ErpFunLease> saleLeaseMap = null;
		Map<Integer, ErpFunPolicyControl> policyControlMap = null;
		if (!havaFavorite) {
			List<ErpFunCaseFavorite> favoriteList = erpFunCaseFavoriteMapper.getFavoriteListByCaseIds(cityId, selfCompId, selfUserId, Const.DIC_CASE_TYPE_SALE_FUN, saleIdsList);
			if(null != favoriteList && favoriteList.size() >0){
				favoriteMap = favoriteList.stream().collect(Collectors.toMap(ErpFunCaseFavorite::getCaseId, map ->map));
			}
		}
		if(!saleLeaseSet.isEmpty()){
			ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
			erpFunLeaseExample.createCriteria().andLeaseIdIn(new ArrayList<>(saleLeaseSet));
			erpFunLeaseExample.setShardCityId(cityId);
			List<ErpFunLease> funLeaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
			if(null != funLeaseList && funLeaseList.size() > 0){
				saleLeaseMap = funLeaseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, map ->map));
			}
		}
		List<ErpFunPolicyControl> policyControlList= erpFunPolicyControlMapper.getPolicyControlListByCaseIds(cityId, saleIdsList, Const.DIC_CASE_TYPE_SALE_FUN);
		if(null != policyControlList && policyControlList.size() > 0){
			policyControlMap = policyControlList.stream().collect(Collectors.toMap(ErpFunPolicyControl::getCaseId, map ->map));
		}
		// 发发和小区专家宽列表才查询
		if(null != wideList && 1 == wideList){
			countDownMap = erpCountDoneService.getHouseCountDoneList(cityId, selfCompId, saleIdsList, Const.DIC_CASE_TYPE_SALE_FUN, selfArchiveId);
			List<AdminFunBuildingBidding> biddingList = adminFunBuildingBiddingMapper.getNowBuildingUserInfo(cityId, buildIdsSet);
			biddingMap = biddingList.stream().collect(Collectors.toMap(AdminFunBuildingBidding::getBuildId, map->map));
			archiveIdList.addAll(biddingList.stream().collect(Collectors.mapping(AdminFunBuildingBidding::getArchiveId, Collectors.toSet())));
			if(null == buildIdsSet || buildIdsSet.size() < 1){
				willBiddPos= adminFunBuildingBiddingMapper.getFutureBuildBiddList(cityId, selfArchiveId, null);
			} else {
				willBiddPos = adminFunBuildingBiddingMapper.getFutureBuildBiddList(cityId, selfArchiveId, buildIdsSet);
			}
		}
		// 对接了，窄列表和其他也要返回实名认证情况。
		if(null != archiveIdList && archiveIdList.size() > 0){
			List<AdminFunArchive> funArchiveList = adminFunArchiveService.getArchiveInfosByIds(archiveIdList);
			archiveMap = funArchiveList.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, map->map));
		}
		// 城市大公盘分享数据
		Map<Integer, ErpCityshareHouse> cityshareMap = null;
		if(null != otherCompCaseIdsSet && otherCompCaseIdsSet.size() > 0){
			List<ErpCityshareHouse> shareHouseList = erpCityshareHouseMapper.getHouseByCaseIds(cityId, Const.DIC_CASE_TYPE_SALE_FUN, otherCompCaseIdsSet);
			cityshareMap = shareHouseList.stream().collect(Collectors.toMap(ErpCityshareHouse::getCaseId, map ->map));
		}
		Map<Integer, ErpFunDepts> deptMap = null;
		if(null != deptIdSet && deptIdSet.size() > 0){
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdSet);
			deptMap = erpFunDeptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, map ->map));
		}
		Map<String, ErpFunSalePublishInfo> funSalePublishInfoMap = null;
		if (!saleIdsList.isEmpty()) {
			List<String> ids = saleIdsList.stream().map(x -> x + "").collect(Collectors.toList());
			ErpFunSalePublishInfoExample erpFunSalePublishInfoExample = new ErpFunSalePublishInfoExample();
			erpFunSalePublishInfoExample.createCriteria().andSaleIdIn(ids);
			erpFunSalePublishInfoExample.setShardCompId(cityId);
			List<ErpFunSalePublishInfo> erpFunSalePublishInfos = erpFunSalePublishInfoMapper.selectByExample(erpFunSalePublishInfoExample);
			funSalePublishInfoMap = erpFunSalePublishInfos.stream().collect(Collectors.toMap(ErpFunSalePublishInfo::getSaleId, map ->map));
		}
		String isShowHouseRoof = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, selfCompId,selfUserId, "IS_SHOW_HOUSE_ROOF");
		String isShowHouseUnit = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, selfCompId,selfUserId, "IS_SHOW_HOUSE_UNIT");
		String isShowHouseNum = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, selfCompId,selfUserId,"IS_SHOW_HOUSE_NUM");
		String showShopOtherAddr = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, selfCompId,selfUserId,"SHOW_SHOP_OTHER_ADDR");

		// 查询完成，开始处理额外信息
		for(FunSaleDto funSaleDto : saleList){
			Integer buildId = funSaleDto.getBuildId();
			// 不是自己公司的数据或加密房源
			if (!selfCompId.equals(funSaleDto.getCompId()) || Const.DIC_HOUSE_LEVEL_PASSWORD.equals(funSaleDto.getSaleLevel())){
				funSaleDto.hideCoreInfo("0", "0", "0", showShopOtherAddr);
			} else {
				funSaleDto.hideCoreInfo(isShowHouseRoof, isShowHouseUnit, isShowHouseNum, showShopOtherAddr);
			}
			
			// 带看次数
			if(null != policyControlMap){
				ErpFunPolicyControl erpFunPolicyControl = policyControlMap.get(funSaleDto.getSaleId());
				if(null != erpFunPolicyControl){
					funSaleDto.setModifyPriceStart(DateTimeHelper.formatDateTimetoString(erpFunPolicyControl.getModifyPriceStart()));// 修改价格时间
					funSaleDto.setModifyPriceBefore(erpFunPolicyControl.getModifyPriceBefor());
					funSaleDto.setModifyPriceAfter(erpFunPolicyControl.getModifyPriceAfter());
					funSaleDto.setLookCount(erpFunPolicyControl.getLookCount());
				} else {
					funSaleDto.setModifyPriceEnd(null);
					funSaleDto.setModifyPriceTrend(null);
				}
			}
			
			// 分佣比例
			if (null != cityshareMap ) {
				ErpCityshareHouse erpCityshareHouse = cityshareMap.get(funSaleDto.getSaleId());
				if (erpCityshareHouse != null) {
					funSaleDto.setCommissionRate(erpCityshareHouse.getCommissionRate());
				}
			}
			// 门店名称
			if (null !=  deptMap) {
				ErpFunDepts erpFunDepts = deptMap.get(funSaleDto.getDeptId());
				if (erpFunDepts != null) {
					funSaleDto.setDeptName(erpFunDepts.getDeptName());
				}
			}
			// 租售房源信息
			if (null != saleLeaseMap) {
				ErpFunLease erpFunLease = saleLeaseMap.get(funSaleDto.getSaleLeaseId());
				if (erpFunLease != null) {
					funSaleDto.setLeaseBuildId(erpFunLease.getBuildId());
					funSaleDto.setLeaseId(erpFunLease.getLeaseId());
					funSaleDto.setLeaseUseage(erpFunLease.getLeaseUseage());
					funSaleDto.setLeaseStatus(erpFunLease.getLeaseStatus());
					funSaleDto.setPriceUnit(erpFunLease.getPriceUnit());
					funSaleDto.setLeaseTotalPrice(erpFunLease.getLeaseTotalPrice());
				}
			}
			// 设置楼盘所属小区专家
			if (biddingMap != null && biddingMap.size() > 0) {
				AdminFunBuildingBidding adminFunBuildingBidding = biddingMap.get(buildId);
				if(null != adminFunBuildingBidding){
					if(null != archiveMap){
						AdminFunArchive adminFunArchive = archiveMap.get(adminFunBuildingBidding.getArchiveId());
						if(null != adminFunArchive){
							funSaleDto.setBuildUserName(adminFunArchive.getUserName());
							funSaleDto.setBuildUserPhoto(CommonUtil.getCommonPhotoUrl(adminFunArchive.getUserPhoto()));
						}
					}
					Date endTime = adminFunBuildingBidding.getEndTime();
					double seconds = DateTimeHelper.getSecondsOfTwoDate(endTime, new Date());
					double rsMinutes = Math.floor(seconds);
					long days = Math.round(Math.floor(NumberHelper.div(rsMinutes, 60 * 60 * 24)));
					long hours = Math.round(Math.floor(NumberHelper.div(seconds, 60 * 60) % 24));
					long minutes = Math.round(Math.floor(NumberHelper.div(seconds, 60) % 60));
					funSaleDto.setBuildShowTime(days + "_" + hours + "_" + minutes);
					funSaleDto.setBuildBeginDate(DateTimeHelper.formatDateTimetoString(adminFunBuildingBidding.getBeginTime()));
					funSaleDto.setBuildEndDate(DateTimeHelper.formatDateTimetoString(endTime));
				}
			}
			// 设置楼盘所属小区专家--下期信息
			if(null != willBiddPos && willBiddPos.size() > 0){
				for(AdminFunBuildingBidding adminFunBuildingBidding: willBiddPos){
					if (!adminFunBuildingBidding.getBuildId().equals(buildId)) {
						continue;
					}
					Byte isTop = adminFunBuildingBidding.getIsTop(); // 预约下一期，是否是第一。
					if(1 == isTop && selfArchiveId.equals(adminFunBuildingBidding.getArchiveId())){ // 等待下期
						funSaleDto.setBuildBiddflag(Const.DIC_BUILD_BIDD_FLAG_5);
					} else if (0 == isTop && selfArchiveId.equals(adminFunBuildingBidding.getArchiveId())){
						funSaleDto.setBuildBiddflag(Const.DIC_BUILD_BIDD_FLAG_4);
					} else if (1 == isTop && CommonUtil.isnull(funSaleDto.getBuildBiddflag()) && selfArchiveId.equals(adminFunBuildingBidding.getArchiveId())){
						funSaleDto.setBuildBiddflag(Const.DIC_BUILD_BIDD_FLAG_3);
					}
				}
			}
			// 设置发发站点发布状态
			if (null != countDownMap && countDownMap.size() > 0) {
				String fafaSiteStr = countDownMap.get(funSaleDto.getSaleId());
				if (!CommonUtil.isnull(fafaSiteStr)) {
					funSaleDto.setFafaSites(fafaSiteStr);
				}
			}
			if (null != funUsersMap) {// 这里一般在跨公司查询时候使用，例如：共享圈 好友圈 加盟圈 查询
				if (!CommonUtil.isnull(funSaleDto.getUserId()) && !funSaleDto.getUserId().equals(Const.DIC_SYSTEM_USERID_999)) {
					ErpFunUsers erpFunUsers = funUsersMap.get(funSaleDto.getUserId());
					if (null != erpFunUsers) {
						funSaleDto.setUserName(erpFunUsers.getUserName());
						funSaleDto.setUserNo(erpFunUsers.getUserNo());
						funSaleDto.setUserMobile(erpFunUsers.getUserMobile());
					}
				}
			}
			// 遍历收藏--查询收藏列表时Map为空
			if (null != favoriteMap && favoriteMap.size() > 0) {
				ErpFunCaseFavorite erpFunCaseFavorite = favoriteMap.get(funSaleDto.getSaleId());
				if (null != erpFunCaseFavorite) {
					funSaleDto.setFavoriteId(erpFunCaseFavorite.getFavoriteId());
				}
			}
			// 返回房源所属人实名认证状态
			if(null != funSaleDto.getArchiveId() && null != archiveMap ){
				AdminFunArchive adminFunArchive = archiveMap.get(funSaleDto.getArchiveId());
				if(null != adminFunArchive){
					if(Const.DIC_USER_EDITION_2.equals(adminFunArchive.getUserEdition())){
						funSaleDto.setCompName(adminFunArchive.getCompName());
					}
					funSaleDto.setUserPhoto(CommonUtil.getCommonPhotoUrl(adminFunArchive.getUserPhoto()));
					funSaleDto.setUserRight(adminFunArchive.getUserRight());
				}
			}
			// 格式化创建时间和跟进时间
			funSaleDto.setThumbUrl(CommonUtil.getCommonPhotoUrl(funSaleDto.getThumbUrl()));
			funSaleDto.setCreationTime(DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(funSaleDto.getCreationTime(), "yyyy-MM-dd HH:mm")));
			if(null != funSaleDto.getTrackTime()){
				funSaleDto.setTrackTime(DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(funSaleDto.getTrackTime(), "yyyy-MM-dd HH:mm")));
			}
			// 未收到钥匙添加备注信息
			if (null == funSaleDto.getSaleKey() || !funSaleDto.getSaleKey()){
				if (null != funKeyRemarkList && funKeyRemarkList.size() == 1){
					ErpFunKeyRemark erpFunKeyRemark = funKeyRemarkList.get(0);
					if(null != erpFunKeyRemark){
						funSaleDto.setKeyNote(erpFunKeyRemark.getRemark());
					}
				}
			}

			if (funSalePublishInfoMap != null) {	//美联官网发布状态
				ErpFunSalePublishInfo erpFunSalePublishInfo = funSalePublishInfoMap.get(funSaleDto.getSaleId());
				if (erpFunSalePublishInfo != null) {
					funSaleDto.setWebsiteState(erpFunSalePublishInfo.getWebsiteState());
				} else {
					funSaleDto.setWebsiteState("0");
				}
			}

		}
	}
	
	@Override
	public boolean dealInfoIsLock(Object object, Integer cityId, Integer compId, Integer userId) {
		//是否显示合同锁定权限 CAN_LOCK_WARRANT
		String viewDealOperLock=erpSysParaMapper.getParamValue(cityId,compId,"CAN_LOCK_WARRANT");
		if(!"1".equals(viewDealOperLock)){
			return false;
		}
		boolean isLockOper = erpUserOpersService.judgePermission(cityId,userId, "DEAL_LOCK_VIEW");
		if(isLockOper){//有查看合同锁定权 直接通过
			return false;
		}
		Integer dealType = null;
		Integer dealCaseId = null;
		ErpFunDeal conditionModel = new ErpFunDeal();
		if(object instanceof ErpFunBuyCustomer){
			if(!((ErpFunBuyCustomer)object).getBuyCustStatus().equals(Const.DIC_HOUSE_STATUS_INNERDEAL)){
				return false;
			}
			dealCaseId = ((ErpFunBuyCustomer)object).getBuyCustId();
			dealType = Const.DIC_CASE_TYPE_SALE_DEAL;
			conditionModel.setDealCustomerId(dealCaseId);
		}else if(object instanceof ErpFunRentCustomer){
			if(!((ErpFunRentCustomer)object).getRentCustStatus().equals(Const.DIC_HOUSE_STATUS_INNERDEAL)){
				return false;
			}
			dealCaseId = ((ErpFunRentCustomer)object).getRentCustId();
			dealType = Const.DIC_CASE_TYPE_RENT_DEAL;
			conditionModel.setDealCustomerId(dealCaseId);
		}else if(object instanceof ErpFunSale){
			if(!((ErpFunSale)object).getSaleStatus().equals(Const.DIC_HOUSE_STATUS_INNERDEAL)){
				return false;
			}
			dealCaseId = ((ErpFunSale)object).getSaleId();
			dealType = Const.DIC_CASE_TYPE_SALE_DEAL;
			conditionModel.setDealHouseId(dealCaseId);
		}else if(object instanceof ErpFunLease){
			if(!((ErpFunLease)object).getLeaseStatus().equals(StringUtil.parseInteger(Const.DIC_HOUSE_STATUS_INNERDEAL))){
				return false;
			}
			dealCaseId = ((ErpFunLease)object).getLeaseId();
			dealType = Const.DIC_CASE_TYPE_RENT_DEAL;
			conditionModel.setDealHouseId(dealCaseId);
		}
		conditionModel.setDealType(dealType.byteValue());
		conditionModel.setCompId(compId);
		List<ErpFunDeal> dealPos = erpFunDealMapper.getFunDealList(cityId, conditionModel);
		if(dealPos!=null){
			return dealPos.get(0).getLockFlag()==1;
		}
		return false;
	}

	/**
	 * @tag 合同税费修改业主电话更新房源信息
	 * @author 邓永洪
	 * @since 2018/6/6
	 */
	@Transactional
	@Override
	public void updateHouseSourceInfoByDealTaxes(UpdateOrInsertDealTaxesParam param, ErpFunSale updateModel, String oldCellphone, String newCellPhone) {
		Integer cityId=param.getCityId();
//		ErpFunSale oldSale=erpFunSaleMapper.getFunSaleBySaleId(cityId,updateModel.getSaleId());
		// 处理加密和推荐信息的时间，策略参数根据该时间来确定保护期
		Integer caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		Integer caseId = updateModel.getSaleId();
		String caseNo = updateModel.getSaleNo();
		ErpFunSale updateFunSale = new ErpFunSale();                           
		updateFunSale.setSaleId(updateModel.getSaleId());
		updateFunSale.setUpdateTime(new Date());
		updateFunSale.setTrackTime(new Date());
		updateFunSale.setSyncTime(new Date());
		updateFunSale.setShardCityId(cityId);
		erpFunSaleMapper.updateByPrimaryKeySelective(updateFunSale);
		String newPhoneValue = "";
		String newValue = "";
		String oldPhoneValue = "";
		String oldValue = "";

		String[] newPhones = StringHelper.split(newCellPhone, "&&&");
		for (int p = 0; p < newPhones.length; p++) {
			String[] phoneValues = StringHelper.split(newPhones[p], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			newPhoneValue += phoneValues[0] + ":" + phoneValues[1] + " ";
		}
		// 以前的号码
		String[] oldCellphones = StringHelper.split(oldCellphone, "&&&");
		for (int p = 0; p < oldCellphones.length; p++) {
			String[] phoneValues = StringHelper.split(oldCellphones[p], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			oldPhoneValue += phoneValues[0] + ":" + phoneValues[1] + " ";
		}

		newValue = newPhoneValue.trim();
		oldValue = oldPhoneValue.trim();

		if (StringUtils.isNotBlank(newValue)) {
			String[] phones = StringHelper.split(newValue, " ");
			String[] beforePhones = StringHelper.split(oldValue, " ");
			String[] beforePhoneValues = StringHelper.split(beforePhones[0], ":");
			String beforePhone = EnCodeHelper.encode(beforePhoneValues[1]);

			// 如果本次提交的电话与以前的不一致，那么先删除原先的房东联系方式然后再次添加。
//			ErpFunPhoneExample phoneExample=new ErpFunPhoneExample();
//			phoneExample.setShardCityId(cityId);
//			phoneExample.createCriteria().andCompIdEqualTo(param.getCompId()).andCityIdEqualTo(cityId).andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
//			erpFunPhoneMapper.deleteByExample(phoneExample);

			if (StringUtils.isNotBlank(beforePhone)) {
				for (String phoneValue : phones) {
					ErpFunPhoneExample phoneExample = new ErpFunPhoneExample();
					phoneExample.setShardCityId(cityId);
					phoneExample.createCriteria().andCompIdEqualTo(param.getCompId()).andCityIdEqualTo(cityId)
							.andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType).andPhoneEqualTo(beforePhone);

					String[] phoneValues = StringHelper.split(phoneValue, ":");
					ErpFunPhone phone = new ErpFunPhone();
					phone.setPhone(EnCodeHelper.encode(phoneValues[1]));
//					phone.setCaseId(caseId);
//					phone.setCaseType(caseType);
//					phone.setAreaId(updateModel.getAreaId());
//					phone.setRegId(updateModel.getRegId());
//					phone.setDeptId(updateModel.getDeptId());
//					phone.setUserId(updateModel.getUserId());
//					phone.setGrId(updateModel.getGrId());
//					phone.setCityId(cityId);
//					phone.setCompId(param.getCompId());
//					phone.setCreationTime(DateUtil.StringToDate(updateModel.getCreationTime()));
//					phone.setShardCityId(cityId);
//					erpFunPhoneMapper.insertSelective(phone);
					erpFunPhoneMapper.updateByExampleSelective(phone, phoneExample);
				}
			}

//			String[] phones = StringHelper.split(newCellPhone, " ");
//			for (String phoneValue : phones){
//				if(StringUtils.isBlank(phoneValue)) {
//					continue;
//				}
//				String [] phoneValues = StringHelper.split(phoneValue, ":");
//				if(phoneValues == null || phoneValues.length < 2) {
//					continue;
//				}
//				ErpFunPhone phone = new ErpFunPhone();
//				phone.setPhone(EnCodeHelper.encode(phoneValues[1]));
//				phone.setCaseId(caseId);
//				phone.setCaseType(caseType);
//				phone.setAreaId(updateModel.getAreaId());
//				phone.setRegId(updateModel.getRegId());
//				phone.setDeptId(updateModel.getDeptId());
//				phone.setUserId(updateModel.getUserId());
//				phone.setGrId(updateModel.getGrId());
//				phone.setCityId(cityId);
//				phone.setCompId(param.getCompId());
//				phone.setCreationTime(new Date());
//				phone.setShardCityId(cityId);
//				erpFunPhoneMapper.insertSelective(phone);
//			}
		}
		ErpFunTrack trackInsertModel = new ErpFunTrack();
		trackInsertModel.setCaseId(caseId);
		trackInsertModel.setCaseType(caseType.byteValue());
		trackInsertModel.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
		trackInsertModel.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
		trackInsertModel.setTrackContent(param.getCurrUserName()+ " 今日在合同税费中修改了业主电话。\n跟进内容：电话:" +
				SyncUtil.decodePhoneForHouseDetailOfFirst(oldCellphone, false) + " >> " +
				SyncUtil.decodePhoneForHouseDetailOfFirst(updateModel.getCellPhone(), false));
		trackInsertModel.setCaseNo(caseNo);
		trackInsertModel.setCaseStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
		trackInsertModel.setTrackWarm(false);
		trackInsertModel.setCreatorUid(param.getUserId());
		trackInsertModel.setCaseUserId(updateModel.getUserId());
		trackInsertModel.setCaseDeptId(updateModel.getDeptId());
		trackInsertModel.setShardCityId(cityId);
		trackInsertModel.setDeptId(param.getDeptId());
		erpFunTrackMapper.insertSelective(trackInsertModel);
	}

	@Override
	public void synchronizeSaleLeaseHouse(Integer caseId, Byte caseType,ErpFunSale erpFunSale) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (erpFunSale.getIsSaleLease().byteValue() != 1) {
			return;
		}
		Map<String, String> saleLeaseTransferMap = TBDefinetion.getSaleLeaseTransferMap(Constants_DIC.DIC_CASE_TYPE_SALE_FUN);
		ErpFunLease erpFunLease = new ErpFunLease();
		erpFunLease.setCityId(erpFunSale.getCityId());
		erpFunLease.setShardCityId(erpFunSale.getCityId());
		for (Entry<String, String> entry : saleLeaseTransferMap.entrySet()) {
			String fieldValue = BeanUtils.getProperty(erpFunSale, entry.getKey());
			if(StringUtils.isBlank(fieldValue)) {
				fieldValue = null;
			}
			BeanUtils.copyProperty(erpFunLease, entry.getValue(), fieldValue);
		}
		erpFunLeaseMapper.updateByPrimaryKey(erpFunLease);
	}
}

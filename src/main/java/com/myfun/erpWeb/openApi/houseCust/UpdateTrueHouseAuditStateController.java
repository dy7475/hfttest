package com.myfun.erpWeb.openApi.houseCust;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;


@RestController
@RequestMapping(value = "/openApi/trueHouse")
public class UpdateTrueHouseAuditStateController extends BaseController {

	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	private ErpFunSaleService erpFunSaleService;
	@Autowired
	private ErpFunLeaseService erpFunLeaseService;
	@Autowired
	private ErpFunPanoramaPhotoMapper erpFunPanoramaPhotoMapper;
	@Autowired
	private ErpFunVideoMapper erpFunVideoMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;

	/**
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/updateTrueHouseState",method= RequestMethod.POST)
	public ResponseJson updateTrueHouseAuditState(Integer type, Integer cityId ,Integer caseType, String caseIds) {
		
		// 公用参数
		String[] split = caseIds.split(",");
		List<Integer> caseIdList = new ArrayList<>();
		for(String ids:split){
			Integer id = StringUtil.parseInteger(ids);
			caseIdList.add(id);
		}
		// 房源类型判断
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			ErpFunSaleExample example = new ErpFunSaleExample();
			example.createCriteria().andSaleIdIn(caseIdList);
			example.setShardCityId(cityId);
			List<ErpFunSale> funSaleList = erpFunSaleMapper.selectByExample(example);
			Map<Integer, ErpFunSale> saleMap = funSaleList.stream()
					.collect(Collectors.toMap(ErpFunSale::getSaleId, val -> val));
			for (ErpFunSale funSaleId : funSaleList) {
				ErpFunSale erpFunSale = saleMap.get(funSaleId.getSaleId());
				Byte trueFlag = Optional.ofNullable(erpFunSale.getTrueFlag()).orElse((byte) 0);
				// 真房源才判断
				if (trueFlag == 1) {
					Integer compId = Optional.ofNullable(erpFunSale.getCompId()).orElse(0);
					// 房源图片
					Integer[] photoFlag = new Integer[] { 0, 1 }; // 0 =审核，1=审核
					Integer photoMap = erpFunPhotoMapper.getCountByType(cityId, compId, caseType, funSaleId.getSaleId(),
							null, photoFlag);
					// VR图片
					Map<String, Object> map = new HashMap<>();
					map.put("caseId", funSaleId.getSaleId());
					map.put("caseType", caseType);
					Integer panoramaMap = erpFunPanoramaPhotoMapper.getNotDelPanoramaCount(cityId, map);
					// 视频
					Integer videoNum =erpFunVideoMapper.getVideoCount(cityId, map);
					Byte judgeTrueFlag = erpFunSaleService.judgeTrueHouseForChangeInfo(panoramaMap, photoMap, trueFlag,
							videoNum);
					if (judgeTrueFlag != 1) {
						ErpFunSale updateFunSale = new ErpFunSale();
						updateFunSale.setSaleId(erpFunSale.getSaleId());
						updateFunSale.setShardCityId(cityId);
						// 如果已经是真房源了
						// 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源
						updateFunSale.setTrueFlag(judgeTrueFlag);
						erpFunSaleMapper.updateByPrimaryKeySelective(updateFunSale);
						// 写跟进
						ErpFunTrack erpFunTrack = new ErpFunTrack();
						erpFunTrack.setShardCityId(cityId);
						erpFunTrack.setCaseId(funSaleId.getSaleId());
						erpFunTrack.setCaseNo(funSaleId.getSaleNo());
						erpFunTrack.setCompId(compId);
						erpFunTrack.setDeptId(erpFunSale.getDeptId());
						erpFunTrack.setCaseType(caseType.byteValue());
						erpFunTrack.setTrackType(Const.DIC_TASK_TYPE_BUSINESS_TRACKING);
						erpFunTrack.setTrackClassic(Const.DIC_TASK_TYPE_BUSINESS_TRACKING_STR);
						String content = "";
						if (type == 1) { // VR
							content = "VR";
						} else if (type == 2) { // 视频
							content = "视频";
						} else if (type == 3) { // 图片
							content = "图片";
						}
						if (judgeTrueFlag == 0) {
							if(null != erpFunSale.getArchiveId()) {
                                // 推送
                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put("templateId", "50");
                                jsonObject.put("receiver", erpFunSale.getArchiveId());
                                jsonObject.put("caseId", erpFunSale.getSaleId());
                                jsonObject.put("caseType", caseType);
                                JSONObject param = new JSONObject();
                                param.put("paramExt", jsonObject.toJSONString());
                                HttpUtil.postJson(AppConfig.getPushWebDomain() + "openApi/kafka/pushMsg", param);
                            }

							erpFunTrack.setTrackContent("房源" + funSaleId.getSaleNo() + "由于" + content + "审核失败被系统下架");
						} else if (judgeTrueFlag == 2) {
							erpFunTrack.setTrackContent("被投诉的真房源" + funSaleId.getSaleNo() + "不能再点亮真房源");
						}
						erpFunTrack.setTrackWarm(false);
						erpFunTrack.setCreatorUid(999);
						erpFunTrack.setCreationTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
						erpFunTrack.setCaseUserId(erpFunSale.getUserId());
						erpFunTrack.setCaseDeptId(erpFunSale.getDeptId());
						erpFunTrackMapper.insertFunTrack(erpFunTrack);
					}
				}
				// 更新房源
                KafkaBizUtils.syncHouse(cityId, funSaleId.getSaleId(), caseType.intValue());
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			ErpFunLeaseExample example = new ErpFunLeaseExample();
			example.createCriteria().andLeaseIdIn(caseIdList);
			example.setShardCityId(cityId);
			List<ErpFunLease> leaseList = erpFunLeaseMapper.selectByExample(example);
			Map<Integer, ErpFunLease> leaseMap = leaseList.stream()
					.collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));
			for (ErpFunLease funLease : leaseList) {
				ErpFunLease erpFunLease = leaseMap.get(funLease.getLeaseId());
				// 真房源标志，1=标记为真房源0=未标记2=永久下架,不能再次变为真房源
				Byte trueFlag = Optional.ofNullable(erpFunLease.getTrueFlag()).orElse((byte) 0);
				if (trueFlag == 1) {
					Integer compId = Optional.ofNullable(erpFunLease.getCompId()).orElse(0);
					Integer[] photoFlag = new Integer[] { 0, 1 }; // 0 =审核，1=审核
					Integer photoMap = erpFunPhotoMapper.getCountByType(cityId, compId, caseType, funLease.getLeaseId(),
							null, photoFlag);
					Byte judgeTrueFlag = erpFunLeaseService.judgeTrueHouseChangeInfo(photoMap, trueFlag);
					if (judgeTrueFlag != 1) {
						// 更新房源
						ErpFunLease updateFunLease = new ErpFunLease();
						updateFunLease.setShardCityId(cityId);
						updateFunLease.setLeaseId(erpFunLease.getLeaseId());
						updateFunLease.setTrueFlag(judgeTrueFlag);
						erpFunLeaseMapper.updateByPrimaryKeySelective(updateFunLease);
						// 写跟进
						ErpFunTrack erpFunTrack = new ErpFunTrack();
						erpFunTrack.setShardCityId(cityId);
						erpFunTrack.setCaseId(erpFunLease.getLeaseId());
						erpFunTrack.setCaseNo(erpFunLease.getLeaseNo());
						erpFunTrack.setCompId(compId);
						erpFunTrack.setDeptId(erpFunLease.getDeptId());
						erpFunTrack.setCaseType(caseType.byteValue());
						erpFunTrack.setTrackType(new Byte("13"));
						erpFunTrack.setTrackClassic("[ 业务跟进 ]");
						String content = "";
						if (type == 1) { // VR
							content = "VR";
						} else if (type == 2) { // 视频
							content = "视频";
						} else if (type == 3) { // 图片
							content = "图片";
						}
						if (judgeTrueFlag == 0) {
							erpFunTrack.setTrackContent("房源" + erpFunLease.getLeaseNo() + "由于" + content + "审核失败被系统下架");

                            if(null != erpFunLease.getArchiveId()) {
                                // 推送
                                JSONObject jsonObject = new JSONObject();
                                jsonObject.put("templateId", "50");
                                jsonObject.put("receiver", erpFunLease.getArchiveId());
                                jsonObject.put("caseId", erpFunLease.getLeaseId());
                                jsonObject.put("caseType", caseType);
                                JSONObject param = new JSONObject();
                                param.put("paramExt", jsonObject.toJSONString());
                                HttpUtil.postJson(AppConfig.getPushWebDomain() + "openApi/kafka/pushMsg", param);
                            }

                        } else if (judgeTrueFlag == 2) {
							erpFunTrack.setTrackContent("被投诉的真房源" + erpFunLease.getLeaseNo() + "不能再点亮真房源");
						}
						erpFunTrack.setTrackWarm(false);
						erpFunTrack.setCreatorUid(999);
						erpFunTrack.setCreationTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
						erpFunTrack.setCaseUserId(erpFunLease.getUserId());
						erpFunTrack.setCaseDeptId(erpFunLease.getDeptId());
						erpFunTrackMapper.insertFunTrack(erpFunTrack);
					}
				}
                // 更新房源
                KafkaBizUtils.syncHouse(cityId, funLease.getLeaseId(), caseType.intValue());
			}
		} else {
			throw new ConfirmException("房源类型出错!");
		}
	
		return ErpResponseJson.ok();
	}
	
	/**
	 * 精英版
	 * 下架客户在推广的“真房源”，“竞价房源”，“小区专家”，“新盘顾问”
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/updateHouseExtension",method= RequestMethod.POST)
	public ResponseJson updateHouseExtension(Integer archiveId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByArchiveId(archiveId);
		if(null == erpFunUsers){
			return ErpResponseJson.ok();
		}
		// 初始化数据
		Date systemDate = DateTimeHelper.getSystemDate();
		String nowDate = DateTimeHelper.formatDateTimetoString(systemDate, "yyyy-MM-dd 00:00:00");
		Date lastDate = DateTimeHelper.addDays(systemDate, -1);
		String endTime = DateTimeHelper.formatDateTimetoString(lastDate, "yyyy-MM-dd 23:59:59"); // 将结束时间改为当天的前一天
		Integer cityId = erpFunUsers.getCityId().intValue();
		Integer compId = erpFunUsers.getCompId();
		erpFunSaleService.updateHouseExtension(cityId, archiveId, endTime, nowDate, compId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 门店版下架在推广的“真房源”，“竞价房源”，“小区专家”，“新盘顾问”
	 * @param compId
	 * @param deptId
	 * @param cityId
	 * @return
	 */
	@RequestMapping(value="/updateHouseExtensionDept",method= RequestMethod.POST)
	public ResponseJson updateHouseExtensionDept(String compNo, String deptNo, Integer cityId) {
		// 初始化数据
		Date systemDate = DateTimeHelper.getSystemDate();
		String nowDate = DateTimeHelper.formatDateTimetoString(systemDate, "yyyy-MM-dd 00:00:00");
		Date lastDate = DateTimeHelper.addDays(systemDate, -1);
		String endTime = DateTimeHelper.formatDateTimetoString(lastDate, "yyyy-MM-dd 23:59:59"); // 将结束时间改为当天的前一天
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
		erpFunSaleService.updateHouseExtensionDept(erpFunDepts.getCompId(), erpFunDepts.getDeptId(), cityId, endTime, nowDate);
		return ErpResponseJson.ok();
	}
}

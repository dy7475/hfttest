package com.myfun.erpWeb.openApi;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.utils.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunTrueHouseCountMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPanoramaPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhoto;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.utils.Assert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.KafkaBizUtils;

/**
 * 真房源相关开放接口
 * @author 张宏利
 * @since 2017年3月15日
 */
@Controller
@RequestMapping(value = "/openApi/trueHouse")
public class TrueHouseStatistics extends BaseController{
	@Resource
	AdminFunTrueHouseCountMapper adminFunTrueHouseCountMapper;
	@Resource
	ErpFunSaleService erpFunSaleService;
	@Resource
	ErpFunLeaseService erpFunLeaseService;
	@Resource
	ErpFunPanoramaPhotoMapper erpFunPanoramaPhotoMapper;
	@Resource
	ErpFunTrackService erpFunTrackService;
	@Resource
	ErpFunSaleMapper erpFunSaleMapper;
	@Resource
	ErpFunLeaseMapper erpFunLeaseMapper;

	/**
	 * 验证是否还是真房源，如果不是则下架和一些列处理
	 * <br/>1、判断不满足真房源条件则下架+写跟进
	 * <br/>供CRM调用
	 * @param cityId 城市ID
	 * @param caseId 房源ID
	 * @param caseType 房源类型
	 * @param source 审核来源 1=视频审核未通过 2=图片审核未通过 3=VR审核未通过
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/validateDownTrueHouse")
	public String validateDownTrueHouse(Integer cityId, Integer caseId, Byte caseType, Integer source) throws Exception {
		if(cityId == null || caseId == null || caseType == null){
			throw new Exception("参数错误");
		}
		HashMap<String, Object> resultMap = new HashMap<>();
		Integer archiveId = null;
		ErpFunTrack erpFunTrack = null;
		if(Const.HouseCustType.SALE == caseType) {
			ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			archiveId = funSale.getArchiveId();
			Assert.isNullThrow(funSale, "未找到该房源");
			boolean trueHouse = judgeForOpenTrueHouse(funSale.getVideoReviewFlag(),
					funSale.getSaleMap() == null ? null : funSale.getSaleMap().intValue(), funSale.getTrueFlag(), funSale.getVideoNum(),
					cityId, caseId, caseType);
			// 不满足真房源条件，而且之前是真房源则下架
			if(!trueHouse && funSale.getTrueFlag() != null && funSale.getTrueFlag() == 1) {
				erpFunSaleService.updateTrueFlag(cityId, new Integer[]{caseId}, (byte) 0);
				erpFunTrack = new ErpFunTrack();
				erpFunTrack.setCaseType((byte) 1);
				erpFunTrack.setDeptId(funSale.getDeptId());
				erpFunTrack.setCompId(funSale.getCompId());
				erpFunTrack.setCaseId(funSale.getSaleId());
				erpFunTrack.setCaseNo(funSale.getSaleNo());
				erpFunTrack.setCaseStatus(funSale.getSaleStatus().byteValue());
				erpFunTrack.setCaseDeptId(funSale.getDeptId());
			}
		} else if(Const.HouseCustType.LEASE == caseType) {
			ErpFunLease s = new ErpFunLease();
			s.setShardCityId(cityId);
			s.setLeaseId(caseId);
			List<ErpFunLease> resList = erpFunLeaseMapper.getFunLeaseByCondition(s);
			if (resList.size() > 0) {
				ErpFunLease funLease = resList.get(0);
				archiveId = funLease.getArchiveId();
				Assert.isNullThrow(funLease, "未找到该房源");
				boolean trueHouse = judgeForOpenTrueHouse(funLease.getVideoReviewFlag(),
						funLease.getLeaseMap(), funLease.getTrueFlag(), funLease.getVideoNum().byteValue(),
						cityId, caseId, caseType);
				// 不满足真房源条件，而且之前是真房源则下架
				if(!trueHouse && funLease.getTrueFlag() != null && funLease.getTrueFlag() == 1) {
					erpFunLeaseService.updateTrueFlag(cityId, new Integer[]{caseId}, (byte) 0);
					erpFunTrack = new ErpFunTrack();
					erpFunTrack.setCaseType((byte) 2);
					erpFunTrack.setDeptId(funLease.getDeptId());
					erpFunTrack.setCompId(funLease.getCompId());
					erpFunTrack.setCaseId(funLease.getLeaseId());
					erpFunTrack.setCaseNo(funLease.getLeaseNo());
					erpFunTrack.setCaseStatus(funLease.getLeaseStatus().byteValue());
					erpFunTrack.setCaseDeptId(funLease.getDeptId());
				}
			}else {
				throw new BusinessException();
			}
		}
		// 如果有更新则给房源写取消真房源跟进
		if(erpFunTrack != null) {
			resultMap.put("downFlag", 1);
			erpFunTrack.setShardCityId(cityId);
			erpFunTrack.setTrackType((byte) 13);
			erpFunTrack.setTrackWarm(false);
			erpFunTrack.setCreatorUid(999);
			erpFunTrack.setTrackClassic("[ 系统通知 ]");
			erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
			erpFunTrack.setTrackContent("因"+getDownTypeStr(source)+"导致不符合真房源标准，已被取消真房源标签");
			erpFunTrackService.insertSelective(erpFunTrack);
			KafkaBizUtils.syncHouse(cityId, caseId, caseType.intValue());

			if(null != archiveId) {
				// 推送
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("templateId", "50");
				jsonObject.put("receiver", archiveId);
				jsonObject.put("caseId", caseId);
				jsonObject.put("caseType", caseType);
				JSONObject param = new JSONObject();
				param.put("paramExt", jsonObject.toJSONString());
				HttpUtil.postJson(AppConfig.getPushWebDomain() + "openApi/kafka/pushMsg", param);
			}

		}
		return ErpResponseJson.ok(resultMap).toJson();
	}
	
	/**
	 * 获取失败原因
	 * @author 张宏利
	 * @since 2017年4月27日
	 * @param type
	 * @return
	 */
	private String getDownTypeStr(Integer type) {
		if(type == null) return "未审核通过";
		if(type == 1) return "视频未审核通过";
		if(type == 2) return "图片未审核通过";
		if(type == 3) return "VR未审核通过";
		return "审核未通过";
	}
	
	/**
	 * 点亮真房源时的一些列判断逻辑
	 * @throws Exception
	 */
	public boolean judgeForOpenTrueHouse(Byte videoReviewFlag, Integer photoMap, Byte trueFlag, 
			Byte videoNum, Integer cityId, Integer caseId, Byte caseType) throws Exception {
		//5张图片+1个视频或3张VR图片才能点亮真房源
		boolean isPicTrueHouse = (photoMap != null && photoMap >= 5) && (videoNum != null && videoNum > 0);
		boolean videoFlag = (videoReviewFlag != null && 2 == videoReviewFlag);
		if(!isPicTrueHouse || videoFlag){// 如果图片和视频不满足  或  视频审核未通过
			// 未审或审核通过的vr张数
			ErpFunPanoramaPhoto erpFunPanoramaPhoto = new ErpFunPanoramaPhoto();
			erpFunPanoramaPhoto.setCaseId(caseId);
			erpFunPanoramaPhoto.setCaseType(caseType);
			erpFunPanoramaPhoto.setVrReviewFlag((byte) -1);
			erpFunPanoramaPhoto.setShardCityId(cityId);
			int count = erpFunPanoramaPhotoMapper.getPanoramaCountByCondition(erpFunPanoramaPhoto);
			if(count < 3) {
				return false;
			}
		}
		// 投诉下架的
		if(trueFlag != null && 2 == trueFlag){
			return false;//throw new Exception("该房源已经被投诉为假房源，不能点亮真房源标签！");
		}
		return true;
	}
	
	/**
	 * 获取真房源数量页面
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 */
	@RequestMapping(value = "/trueDayCount")
	public String trueDayCount() {
		return "openApi/utils/trueHouseStatistics";
	}
	
	/**
	 * 获取真房源数量
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/getTrueDayCount")
	public String getTrueDayCount(String queryDate) throws Exception {
		queryDate = DateTimeHelper.formatDatetoString(queryDate);
		Map<String, String> countMap = adminFunTrueHouseCountMapper.getTrueDayCount(queryDate);
		return ErpResponseJson.ok(countMap).toJson();
	}
	
	/**
	 * 按手机号获取真房源数量
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTrueMobileCount")
	public String getTrueMobileCount(String mobile, String startDate, String endDate) throws Exception {
		startDate = DateTimeHelper.formatDatetoString(startDate)+" 00:00:00";
		endDate = DateTimeHelper.formatDatetoString(endDate)+" 23:59:59";
		Map<String, String> countMap = adminFunTrueHouseCountMapper.getTrueMobileCount(mobile, startDate, endDate);
		return ErpResponseJson.ok(countMap).toJson();
	}
	
	/**
	 * 按门店编号获取真房源数量
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTrueDeptCount")
	public String getTrueDeptCount(String compNo, String deptNo, String startDate, String endDate) throws Exception {
		startDate = DateTimeHelper.formatDatetoString(startDate)+" 00:00:00";
		endDate = DateTimeHelper.formatDatetoString(endDate)+" 23:59:59";
		Map<String, String> countMap = adminFunTrueHouseCountMapper.getTrueDeptCount(compNo, deptNo, startDate, endDate);
		return ErpResponseJson.ok(countMap).toJson();
	}
}

package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.erpWeb.house.param.DeleteVideoParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunVideoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunVideoMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.erpdb.po.ErpFunVideoFastdfs;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunHouseBiddingService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpFunVideoService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateUtil;

@Service
public class ErpFunVideoServiceImpl extends AbstractService<ErpFunVideo, ErpFunVideo>implements ErpFunVideoService {
	@Autowired
	private ErpFunVideoMapper erpFunVideoMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunSaleService erpFunSaleService;
	@Autowired
	private ErpFunLeaseService erpFunLeaseService;
	@Autowired
	private ErpFunVideoFastdfsMapper erpFunVideoFastdfsMapper;
	@Autowired
	private ErpFunTrackService erpFunTrackService;
	@Autowired
	private ErpFunHouseBiddingService erpFunHouseBiddingService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunVideoMapper;
	}

	@Override
	public ErpFunVideo getValidVideoByVideoId(Integer videoId, Integer cityId) throws Exception {
		ErpFunVideo erpFunVideo = new ErpFunVideo();
		erpFunVideo.setShardCityId(cityId);
		erpFunVideo.setVideoId(videoId);
		List<ErpFunVideo> erpFunVideos = erpFunVideoMapper.getValidErpFunVideoByCondition(erpFunVideo);
		return (erpFunVideos != null && !erpFunVideos.isEmpty()) ? erpFunVideos.get(0) : null;
	}

	@Override
	public List<ErpFunVideo> getValidVideoByCondition(Integer caseId, Byte caseType, Integer cityId) throws Exception {
		ErpFunVideo erpFunVideo = new ErpFunVideo();
		erpFunVideo.setShardCityId(cityId);
		erpFunVideo.setCaseId(caseId);
		erpFunVideo.setCaseType(caseType);
		List<ErpFunVideo> erpFunVideos = erpFunVideoMapper.getValidErpFunVideoByCondition(erpFunVideo);
		return (erpFunVideos != null && !erpFunVideos.isEmpty()) ? erpFunVideos : null;
	}

	@Transactional
	@Override
	public List<ErpFunVideo> getVideoListOrderByVideoIdDesc(String shardDbName, Integer lastVideoId) {
		//Integer videoId = erpFunVideoFastdfsMapper.selectLastVideoId(shardDbName);
		List<ErpFunVideo> videoList = erpFunVideoMapper.getVideoListOrderByVideoIdDesc(shardDbName, lastVideoId);
		List<ErpFunVideoFastdfs> fastdfsVideoList = new LinkedList<>();
		for (ErpFunVideo erpFunVideo : videoList) {
			ErpFunVideoFastdfs fastdfs = new ErpFunVideoFastdfs();
			fastdfs.setVideoId(erpFunVideo.getVideoId());
			fastdfs.setCreateTime(new Date());
			fastdfs.setOldPhotoAddr(erpFunVideo.getPhotoAddr());
			fastdfs.setOldVideoAddr(erpFunVideo.getVideoAddr());
			fastdfsVideoList.add(fastdfs);
		}
		erpFunVideoFastdfsMapper.insertList(shardDbName, fastdfsVideoList);
		return videoList;
	}

	/**
	 * 删除视频
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  videoId 视频Id caseNo 房客源编号 uploadDeptName uploadUserName cancelTrueFlag
	 * @since 2017年5月18日
	 * @return
	 */
	@Transactional
	@Override
	public void deleteVideo(DeleteVideoParam param) throws Exception{
		Integer caseType = param.getCaseType();
		Integer cityId = param.getCityId();
		Integer caseId = param.getCaseId();
		ErpFunVideo erpFunVideo = new ErpFunVideo();
		erpFunVideo.setVideoId(param.getVideoId());
		erpFunVideo.setShardCityId(cityId);
		erpFunVideo.setVideoStatus(Integer.valueOf(Constants_DIC.DIC_VIDEO_STATUS_1_));
		erpFunVideoMapper.updateByPrimaryKeySelective(erpFunVideo);
		
		if("1".equals(param.getIsMeiLian().toString())){
			erpFunVideoMapper.delVideo(cityId,param.getVideoId());
		}
		
		writeDelVideoTrack(param);
        BaseMapParam baseMapParam = new BaseMapParam();
        baseMapParam.setString("deptName",param.getDeptName());
        baseMapParam.setString("userName",param.getUserName());
        baseMapParam.setObject("cityShareName",param.getCityShareName());
        baseMapParam.setInteger("cityId",cityId);
        baseMapParam.setInteger("caseId",caseId);
        baseMapParam.setInteger("caseType",caseType);
        baseMapParam.setInteger("currentCompId",param.getCurrentCompId());
        baseMapParam.setInteger("currentDeptId",param.getCurrentDeptId());
        baseMapParam.setInteger("currentUserId",param.getCurrentUserId());

        if(Const.HouseCustType.SALE == caseType){
			// 查询老数据，获取真房源标记和分享的优家房源ID
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId,caseId);
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setShardCityId(cityId);
			if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
				param.setSaleLeaseId(erpFunSale.getSaleLeaseId());
				param.setSaleLeaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
				erpFunLease.setLeaseId(erpFunSale.getSaleLeaseId());
				erpFunLease.setVideoNum(0);
				erpFunLease.setVideoReviewFlag((byte)0);
				erpFunLease.setThumbUrl(erpFunSale.getThumbUrl());
			}
			
			erpFunSale.setVideoNum((byte)0);
			erpFunSale.setVideoReviewFlag((byte)0);
			erpFunSale.setShardCityId(cityId);
			if (0 == erpFunSale.getSaleMap()) {
				erpFunSale.setThumbUrl(null);
				if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
					erpFunLease.setThumbUrl(null);
				}
			}
			if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
				erpFunLeaseMapper.updateThumbUrl(erpFunLease);
			}
			erpFunSaleMapper.updateThumbUrl(erpFunSale);
			/*Byte oldHouseTrueFlag = erpFunSale.getTrueFlag();
			Byte newHouseTrueFlag = erpFunSaleService.updateHouseTrueFlag(cityId, caseId, erpFunSale);
			// 意思是以前是真房源，所以写个跟进：你的真房源不满足条件了，给你取消了
			if (Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(oldHouseTrueFlag) && Const.DIC_INFO_TRUE_INFO_FLAG_0.equals(newHouseTrueFlag)) {
				erpFunTrackService.addTrack(caseId, caseNo, Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_7, "0", caseType,baseMapParam);
				// 判断竞价,下架竞价   优优竞价  下架逻辑并 写房源跟进(此功能暂未全部完成)
				erpFunHouseBiddingService.downBiddingYY(cityId,caseId, caseType, caseNo, 8);
			}*/
		} else if(Const.HouseCustType.LEASE == caseType){
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId,caseId);
			erpFunLease.setShardCityId(cityId);
			ErpFunSale erpFunSale = new ErpFunSale();
			erpFunSale.setShardCityId(cityId);
			if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
				param.setSaleLeaseId(erpFunLease.getSaleLeaseId());
				param.setSaleLeaseType(Const.DIC_CASE_TYPE_SALE_FUN);
				erpFunSale.setSaleId(erpFunLease.getSaleLeaseId());
				erpFunSale.setVideoNum((byte)0);
				erpFunSale.setVideoReviewFlag((byte)0);
				erpFunSale.setThumbUrl(erpFunLease.getThumbUrl());
			}
			erpFunLease.setVideoNum(0);
			erpFunLease.setVideoReviewFlag((byte)0);
			if (0 == erpFunLease.getLeaseMap()) {
				erpFunLease.setThumbUrl(null);
				if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
					erpFunSale.setThumbUrl(null);
				}
			}
			erpFunLeaseMapper.updateThumbUrl(erpFunLease);
			if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
				erpFunSaleMapper.updateThumbUrl(erpFunSale);
			}
			/*Byte oldHouseTrueFlag = erpFunLease.getTrueFlag();
			Byte newHouseTrueFlag = erpFunLeaseService.updateHouseTrueFlag(cityId,caseId, erpFunLease);
			// 意思是以前是真房源，所以写个跟进：你的真房源不满足条件了，给你取消了
			if (Const.DIC_INFO_TRUE_INFO_FLAG_1.equals(oldHouseTrueFlag) && Const.DIC_INFO_TRUE_INFO_FLAG_0.equals(newHouseTrueFlag)) {
				erpFunTrackService.addTrack(caseId,caseNo, Constants_DIC.DIC_INFO_TRUE_INFO_TYPE_7, "0", caseType,baseMapParam);
				// 判断竞价,下架竞价
				erpFunHouseBiddingService.downBiddingYY(cityId,caseId, caseType, caseNo, 8);
			}*/
		}

	}

	/**
	 * 写跟进
	 * @author 臧铁
	 * @param param
	 * @since 2017年5月18日
	 * @return
	 */
	private void writeDelVideoTrack(DeleteVideoParam param) throws Exception{
		Integer caseType = param.getCaseType();
		Integer cityId = param.getCityId();
		Integer caseId = param.getCaseId();
		String caseNo = param.getCaseNo();
		Map<String,Integer> resultMap = erpFunTrackService.getCaseInfo(cityId, caseId,caseType);
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setShardCityId(cityId);
		erpFunTrack.setCaseId(caseId);
		erpFunTrack.setCaseType(caseType.byteValue());
		erpFunTrack.setCaseNo(caseNo);
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_OTHER);
		erpFunTrack.setCreationTime(DateUtil.DateToString(new Date()));
		erpFunTrack.setIncludeTrack(Byte.valueOf(Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO));
		erpFunTrack.setTrackClassic(Constants_DIC.DIC_TRACKCLASSIC_16);
		erpFunTrack.setCreatorUid(param.getCurrentUserId());
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setCompId(param.getCurrentCompId());
		erpFunTrack.setDeptId(param.getCurrentDeptId());
		erpFunTrack.setCaseUserId(resultMap.get("userId"));
		erpFunTrack.setCaseDeptId(resultMap.get("deptId"));
		String trackContent = param.getUserName()+" 今日删除了 "+param.getUploadDeptName()+" "+param.getUploadUserName()+" 上传的视频";
		erpFunTrack.setTrackContent(trackContent);
		erpFunTrackService.insertSelective(erpFunTrack);
	}
}

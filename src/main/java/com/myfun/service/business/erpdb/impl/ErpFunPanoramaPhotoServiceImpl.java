package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.erpWeb.house.param.DeletePanoramaPhotoParam;
import com.myfun.erpWeb.house.param.PanoramaPhotoListParam;
import com.myfun.erpWeb.house.vo.ErpFunPanoramaPhotoVo;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPanoramaPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunPanoramaPhotoService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@Service
public class ErpFunPanoramaPhotoServiceImpl extends AbstractService<ErpFunPanoramaPhoto, ErpFunPanoramaPhoto>implements ErpFunPanoramaPhotoService {
	@Autowired
	private ErpFunPanoramaPhotoMapper erpFunPanoramaPhotoMapper;
	@Autowired
	private ErpFunSaleService erpFunSaleService;
	@Autowired
	private ErpFunLeaseService erpFunLeaseService;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunTrackService erpFunTrackService;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;


	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunPanoramaPhotoMapper;
	}

	@Override
	public ErpFunPanoramaPhoto getValidPanoramaPhotoByPhotoId(Integer photoId, Integer cityId) throws Exception {
		ErpFunPanoramaPhoto erpFunPanoramaPhoto = new ErpFunPanoramaPhoto();
		erpFunPanoramaPhoto.setShardCityId(cityId);
		erpFunPanoramaPhoto.setPhotoId(photoId);
		List<ErpFunPanoramaPhoto> erpFunPanPhotos = erpFunPanoramaPhotoMapper.getPanoramaPhotosByCondition(erpFunPanoramaPhoto);
		return (erpFunPanPhotos != null && !erpFunPanPhotos.isEmpty()) ? erpFunPanPhotos.get(0) : null;
	}

	@Override
	public List<ErpFunPanoramaPhoto> getValidPanoramaPhotosByCondition(Integer caseId, Byte caseType, Integer cityId)
			throws Exception {
		ErpFunPanoramaPhoto erpFunPanoramaPhoto = new ErpFunPanoramaPhoto();
		erpFunPanoramaPhoto.setShardCityId(cityId);
		erpFunPanoramaPhoto.setCaseId(caseId);
		erpFunPanoramaPhoto.setCaseType(caseType);
		List<ErpFunPanoramaPhoto> erpFunPanPhotos = erpFunPanoramaPhotoMapper.getPanoramaPhotosByCondition(erpFunPanoramaPhoto);
		return (erpFunPanPhotos != null && !erpFunPanPhotos.isEmpty()) ? erpFunPanPhotos : null;
	}

	/**
	 * 获取720图片列表
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型
	 * @since 2017年5月11日
	 * @return
	 */
	@Override
	public List<ErpFunPanoramaPhotoVo> getPanoramaPhotoList(PanoramaPhotoListParam param) {
		List<ErpFunPanoramaPhotoVo> erpFunPanPhotos = erpFunPanoramaPhotoMapper.getPanoramaPhotoList(param.getCityId(),param);
		for (ErpFunPanoramaPhoto erpFunPanoramaPhoto : erpFunPanPhotos){
			String photoAddr = erpFunPanoramaPhoto.getPhotoAddr();
			if(StringUtil.isNotBlank(photoAddr)){
				photoAddr = photoAddr.replaceAll("\\\\","/");
				if(!photoAddr.endsWith("/")){
					photoAddr += '/';
				}
				erpFunPanoramaPhoto.setPhotoAddr(photoAddr+"front.jpg");
			}
		}
		return erpFunPanPhotos;
	}

	/**
	 * 删除720图片
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  photoId被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	@Transactional
	@Override
	public void deletePanoramaPhoto(DeletePanoramaPhotoParam param) throws Exception{
		String[] photoIds = param.getPhotoId().split(",");
		param.setPhotoIds(photoIds);
		Integer caseType = param.getCaseType();
		Integer saleLeaseId = null;
		Integer saleLeaseType = null;
		ErpFunSale erpFunSale = null;
		ErpFunLease erpFunLease = null;
		Map<String, Object> map = BeanUtil.objToObjMap(param);
		if (Const.HouseCustType.SALE == caseType) {
			erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getCaseId());
			saleLeaseId = erpFunSale.getSaleLeaseId();
			saleLeaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		} else {
			erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getCaseId());
			saleLeaseId = erpFunLease.getSaleLeaseId();
			saleLeaseType = Const.DIC_CASE_TYPE_SALE_FUN;
		}
		map.put("saleLeaseId", saleLeaseId);
		map.put("saleLeaseType", saleLeaseType);
		int totleCount = erpFunPanoramaPhotoMapper.getNotDelPanoramaCount(param.getCityId(), map);// 删之前的数量
		int deleteCount = erpFunPanoramaPhotoMapper.deletePanoramaPhoto(param.getCityId(), param);// 删除数量
		Integer panoramaMap = totleCount - deleteCount;// 删之前的数量-删除数量=当前数量
		// 修改房源上的720图片数量
		if (Const.HouseCustType.SALE == caseType) {
			erpFunSale.setPanoramaMap(panoramaMap);
			erpFunLease = new ErpFunLease();
			erpFunLease.setLeaseMap(erpFunSale.getSaleMap()==null?0:erpFunSale.getSaleMap().intValue());
			erpFunLease.setPanoramaMap(panoramaMap);
			erpFunLease.setShardCityId(param.getCityId());
			//租售房源，图片，视频，vr这个是物理属性，不管现在是不是可租可售状态，物理属性都是要同步的
			if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
				erpFunLease.setLeaseId(erpFunSale.getSaleLeaseId());
				erpFunLease.setTrueFlag(erpFunSale.getTrueFlag());
				erpFunLease.setVideoNum(erpFunSale.getVideoNum()==null?0:erpFunSale.getVideoNum().intValue());
				param.setSaleLeaseId(erpFunSale.getSaleLeaseId());
				param.setSaleLeaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
			}
			// 删除VR图片首图修改逻辑
			if (null == erpFunSale.getPanoramaMap() || erpFunSale.getPanoramaMap() <= 0) {
				erpFunSale.setThumbUrl("");
				erpFunLease.setThumbUrl("");
				if (null != erpFunSale.getSaleMap() && erpFunSale.getSaleMap() > 0) {
					ErpFunPhoto erpFunPhoto = erpFunPhotoMapper.getFunPhoto(param.getCityId(), param.getCaseId(),
							Const.DIC_CASE_TYPE_SALE_FUN);
					if (null != erpFunPhoto) {
						erpFunSale.setThumbUrl(erpFunPhoto.getPhotoAddr());
						erpFunLease.setThumbUrl(erpFunPhoto.getPhotoAddr());
					} else if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
						erpFunPhoto = erpFunPhotoMapper.getFunPhoto(param.getCityId(), erpFunSale.getSaleLeaseId(),
								Const.DIC_CASE_TYPE_LEASE_FUN);
						if (null != erpFunPhoto) {
							erpFunSale.setThumbUrl(erpFunPhoto.getPhotoAddr());
							erpFunLease.setThumbUrl(erpFunPhoto.getPhotoAddr());
						}
					}
				}
			}
			erpFunSaleService.updateHouseTrueFlag(param.getCityId(), param.getCaseId(), erpFunSale);
			if (erpFunSale.getSaleLeaseId()!=null && erpFunSale.getSaleLeaseId()>0) {
				erpFunLeaseService.updateHouseTrueFlag(param.getCityId(), erpFunSale.getSaleLeaseId(), erpFunLease);
			}
			writeDelVRTrack(deleteCount, param, erpFunSale.getSaleNo());
		} else if (Const.HouseCustType.LEASE == caseType) {
			erpFunLease.setPanoramaMap(panoramaMap);
			erpFunSale = new ErpFunSale();
			erpFunSale.setSaleMap(erpFunLease.getLeaseMap() == null ? (byte) 0 : erpFunLease.getLeaseMap().byteValue());
			erpFunSale.setPanoramaMap(panoramaMap);
			erpFunSale.setShardCityId(param.getCityId());
			if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
				erpFunSale.setSaleId(erpFunLease.getSaleLeaseId());
				erpFunSale.setTrueFlag(erpFunLease.getTrueFlag());
				erpFunSale.setVideoNum(erpFunLease.getVideoNum()==null?Byte.valueOf("0"):erpFunLease.getVideoNum().byteValue());
				param.setSaleLeaseId(erpFunLease.getSaleLeaseId());
				param.setSaleLeaseType(Const.DIC_CASE_TYPE_SALE_FUN);
			}
			// 删除VR图片首图修改逻辑
			if (null == erpFunLease.getPanoramaMap() || erpFunLease.getPanoramaMap() <= 0) {
				erpFunLease.setThumbUrl("");
				erpFunSale.setThumbUrl("");
				if (null != erpFunLease.getLeaseMap() && erpFunLease.getLeaseMap() > 0) {
					ErpFunPhoto erpFunPhoto = erpFunPhotoMapper.getFunPhoto(param.getCityId(), param.getCaseId(),
							Const.DIC_CASE_TYPE_LEASE_FUN);
					if (null != erpFunPhoto) {
						erpFunSale.setThumbUrl(erpFunPhoto.getPhotoAddr());
						erpFunLease.setThumbUrl(erpFunPhoto.getPhotoAddr());
					} else if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
						erpFunPhoto = erpFunPhotoMapper.getFunPhoto(param.getCityId(), erpFunLease.getSaleLeaseId(),
								Const.DIC_CASE_TYPE_SALE_FUN);
						if (null != erpFunPhoto) {
							erpFunSale.setThumbUrl(erpFunPhoto.getPhotoAddr());
							erpFunLease.setThumbUrl(erpFunPhoto.getPhotoAddr());
						}
					}
				}
			}
			erpFunLeaseService.updateHouseTrueFlag(param.getCityId(), param.getCaseId(), erpFunLease);
			if (erpFunLease.getSaleLeaseId()!=null && erpFunLease.getSaleLeaseId()>0) {
				erpFunSaleService.updateHouseTrueFlag(param.getCityId(), erpFunLease.getSaleLeaseId(), erpFunSale);
			}
			writeDelVRTrack(deleteCount, param, erpFunLease.getLeaseNo());
		}
	}

	/**
	 * 写跟进
	 * @author 臧铁
	 * @param param  deleteCount 删除数量
	 * @param param  caseNo  房源编码，时间生存编号
	 * @since 2017年5月15日
	 * @return
	 */
	private void writeDelVRTrack(int deleteCount,DeletePanoramaPhotoParam param,String caseNo)throws Exception{
		Map<String,Integer> resultMap = erpFunTrackService.getCaseInfo(param.getCityId(), param.getCaseId(),param.getCaseType());
		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setShardCityId(param.getCityId());
		erpFunTrack.setCaseId(param.getCaseId());
		erpFunTrack.setCaseType(param.getCaseType().byteValue());
		erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_OTHER);
		erpFunTrack.setCreationTime(DateUtil.DateToString(new Date()));
		erpFunTrack.setIncludeTrack(Byte.valueOf(Constants_DIC.DIC_TRACK_INCLUDE_TRACK_PHOTO720));
		erpFunTrack.setTrackClassic(Constants_DIC.DIC_TRACKCLASSIC_17);
		erpFunTrack.setCreatorUid(param.getCurrentUserId());
		erpFunTrack.setCaseNo(caseNo);
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setCompId(param.getCurrentCompId());
		erpFunTrack.setDeptId(param.getCurrentDeptId());
		erpFunTrack.setCaseUserId(resultMap.get("userId"));
		erpFunTrack.setCaseDeptId(resultMap.get("deptId"));
		String trackContent = param.getUserName()+" 删除了该房源"+deleteCount+"张VR图片";
		erpFunTrack.setTrackContent(trackContent);
		erpFunTrackService.insertSelective(erpFunTrack);
	}

}

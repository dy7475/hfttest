package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.constract.param.UpdateFunDealPhotoParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpFunDealRecordService;
import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.ErpFunContractMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunIndexValueMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.service.business.erpdb.ErpFunCompService;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
@Service
public class ErpFunDealPhotoServiceImpl extends AbstractService<ErpFunDealPhoto, ErpFunDealPhoto> implements ErpFunDealPhotoService {
	@Autowired private ErpFunDealPhotoMapper erpFunDealPhotoMapper;
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ErpFunContractMapper erpFunContractMapper;
	@Autowired private ErpFunIndexValueMapper erpFunIndexValueMapper;
	@Autowired private AdminSysParaService adminSysParaService;
	@Autowired private AdminFunCompMapper adminFunCompMapper;
	@Autowired private ErpFunCompService erpFunCompService;
	@Autowired ErpFunDealPhotoFastdfsMapper erpFunDealPhotoFastdfsMapper;
	@Autowired ErpFunDealRecordService erpFunDealRecordService;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunDealPhotoMapper;
	}

	@Override
	public void uploadDealFile(Integer cityId, Integer dealId, Integer photoType, String photoAddr) {
		// 看合同是否存在
		ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, dealId, 
				new String[]{"DEAL_ID", "COMP_ID"}
		);
		if(erpFunDeal == null) {
			return;
		}
		// 看是否已请求过上传
		List<ErpFunDealPhoto> photoTypeList = erpFunDealPhotoMapper.getDealFiles(cityId, erpFunDeal.getCompId(), dealId, photoType);
		if(photoTypeList == null || photoTypeList.isEmpty()) {
			return;
		}
		ErpFunDealPhoto erpFunDealPhoto = photoTypeList.get(0);
		// 已经设置过地址则不再修改
		if(StringUtils.isNotBlank(erpFunDealPhoto.getPhotoAddr())) {
			return;
		}
		// 修改记录
		ErpFunDealPhoto dealPhotoPO = new ErpFunDealPhoto();
		dealPhotoPO.setPhotoId(erpFunDealPhoto.getPhotoId());
		dealPhotoPO.setPhotoAddr(photoAddr);
		dealPhotoPO.setShardCityId(cityId);
		erpFunDealPhotoMapper.updateByPrimaryKeySelective(dealPhotoPO);
	}

	@Transactional
	@Override
	public Map<String, Object> createDealFile(Integer cityId, Integer dealId, Integer photoType) {
		// 看合同是否存在
		ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, dealId,null);
		if(erpFunDeal == null) {
			return null;
		}
		Integer[] photoTypeArr = (photoType == null) ? new Integer[]{5,6}:new Integer[]{photoType};
		// 获取生成附件所需的数据
		Map<String, Object> resultMap = new HashMap<>();
		boolean isHaveData = false;
		for (Integer typeTemp : photoTypeArr) {
			// 看是否已创建记录
			int photoTypeCount = erpFunDealPhotoMapper.getPhotoTypeCount(cityId, dealId, typeTemp);
			if(photoTypeCount > 0) {
				continue;
			}
			ErpFunDealPhoto dealPhotoPO = new ErpFunDealPhoto();
			dealPhotoPO.setDealId(erpFunDeal.getDealId());
			dealPhotoPO.setCompId(erpFunDeal.getCompId());
			dealPhotoPO.setPhotoType(typeTemp.byteValue());
			dealPhotoPO.setTransmitFlag((byte) 0);
			dealPhotoPO.setUploadDate(new Date());
			dealPhotoPO.setUploadUser(999);
			dealPhotoPO.setUploadUserName("系统");
			dealPhotoPO.setShardCityId(cityId);
			erpFunDealPhotoMapper.insertSelective(dealPhotoPO);
			Integer contractId = null;
			String[] contractAndIndexName = null;
			if(typeTemp == 5) {
				contractId = erpFunDeal.getContractId();
				resultMap.put("contractId", contractId);// contractId
				contractAndIndexName = new String[]{"contractContent", "contractIndex"};
			} else if(typeTemp == 6) {
				contractId = erpFunDeal.getProtocolId();
				resultMap.put("protocolId", contractId);// protocolId
				contractAndIndexName = new String[]{"protocolContent", "protocolIndex"};
			}
			if(contractId != null) {
				isHaveData = true;
				ErpFunContract erpFunContract = new ErpFunContract();
				erpFunContract.setContractId(contractId);
				erpFunContract.setShardCityId(cityId);
				ErpFunContract funContract = erpFunContractMapper.selectByPrimaryKey(erpFunContract);
				resultMap.put(contractAndIndexName[0], funContract);// 合同内容
				// 合同指标值
				List<Map<String, Object>> indexValueList = erpFunIndexValueMapper.getIndexValue(cityId, contractId);
				resultMap.put(contractAndIndexName[1], indexValueList);// 合同指标值
			}
		}
		if(!isHaveData) {
			return null;
		}
		// 合同印章
		List<ErpFunDealPhoto> dealFiles = erpFunDealPhotoMapper.getDealFiles(cityId, erpFunDeal.getCompId(), null, 3);
		if(dealFiles != null && dealFiles.size() > 0) {
			ErpFunDealPhoto erpFunDealPhoto = dealFiles.get(0);
			if(erpFunDealPhoto.getPhotoAddr() != null) {
				String accessDomain = FastdfsManager.getHttpAccessDomain();
				erpFunDealPhoto.setPhotoAddr(accessDomain + erpFunDealPhoto.getPhotoAddr());
				resultMap.put("sealInfo", erpFunDealPhoto);// 合同印章
			}
		}
		// 合同二维码地址
		ErpFunComp erpFunCompCon = new ErpFunComp();
		erpFunCompCon.setShardCityId(cityId);
		erpFunCompCon.setCompId(erpFunDeal.getCompId());
		ErpFunComp erpFunComp = erpFunCompService.getCompByCompId(erpFunCompCon);
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		String hftQrAddr = adminSysParaService.getSysParamToString("HFT_QR_URL");
		hftQrAddr = hftQrAddr + "/" + adminFunComp.getCompId() + "/" + erpFunDeal.getContractNo();
		resultMap.put("hftDealQrAddr", hftQrAddr);// 合同二维码地址
		resultMap.put("dealId", dealId);// 合同ID
		resultMap.put("cityId", cityId);// 城市ID
		resultMap.put("funDealData", erpFunDeal);// 城市ID
		return resultMap;
	}

	@Override
	public List<ErpFunDealPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName) {
		Integer photoId = erpFunDealPhotoFastdfsMapper.selectLastPhotoId(shardDbName);
		List<ErpFunDealPhoto> photoList = erpFunDealPhotoMapper.getPhotoListOrderByPhotoIdDesc(shardDbName, photoId);
		if(photoList == null || photoList.size() <= 0) {
			return null;
		}
		List<ErpFunDealPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (ErpFunDealPhoto erpFunPhoto : photoList) {
			ErpFunDealPhotoFastdfs fastdfs = new ErpFunDealPhotoFastdfs();
			fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
			fastdfs.setCreationTime(new Date());
			fastdfs.setOldAddr(erpFunPhoto.getPhotoAddr());
			fastdfsPhotoList.add(fastdfs);
		}
		erpFunDealPhotoFastdfsMapper.insertList(shardDbName, fastdfsPhotoList);
		return photoList;
	}

	/**
	 * @tag 合同附件保存
	 * @author 邓永洪
	 * @since 2018/6/7
	 */
	@Transactional
	@Override
	public void updateAndInsertPhoto(Integer cityId, Integer compId, Integer userId, String photoPath, byte photoType, Integer pellucidity, Byte fileType, Byte fileSubType) {
		erpFunDealPhotoMapper.updateTransmitFlag(cityId,compId,photoType);
		ErpFunDealPhoto insertModel=new ErpFunDealPhoto();
		insertModel.setCompId(compId);
		insertModel.setPhotoAddr(photoPath);
		insertModel.setPhotoType(photoType);
		insertModel.setUseageType((byte)1);
		insertModel.setUploadUser(userId);
		insertModel.setUploadDate(new Date());
		insertModel.setTransmitFlag((byte)0);
		insertModel.setShardCityId(cityId);
		insertModel.setPellucidity(pellucidity);
		insertModel.setFileType(fileType);
		insertModel.setFileSubType(fileSubType);
		erpFunDealPhotoMapper.insertSelective(insertModel);
	}

	@Transactional
	@Override
	public void updateFunDealPhotoList(UpdateFunDealPhotoParam param, ErpFunDealPhoto dealPhoto, ErpFunDealPhotoExample dealPhotoExample, GeneralParam generalParam,String trackContent) {
		erpFunDealPhotoMapper.updateByExampleSelective(dealPhoto, dealPhotoExample);
		Integer buyCount = param.getBuyCount();
		Integer sellCount = param.getSellCount();
		Integer otherCount = param.getOtherCount();
		Integer dealId = param.getDealId();
		String photoTypeDesc = "";
		if (buyCount != null) {
			photoTypeDesc += buyCount + "张客户资料附件图片 ";
		}
		if (sellCount != null) {
			photoTypeDesc += sellCount + "张业主资料附件图片 ";
		}
		if (otherCount != null) {
			photoTypeDesc += otherCount + "张其他资料附件图片 ";
		}
		trackContent = trackContent + " 删除了" + photoTypeDesc;
		String updateClassic = Const.DIC_DEAL_UPDATE_CLASSIC_DEL_PHOTO;
		if (dealId != null) {
			erpFunDealRecordService.writeDealRecord(generalParam, dealId, null, updateClassic, (byte) 0,
					trackContent, 0, null, false, null);
		}
	}
}


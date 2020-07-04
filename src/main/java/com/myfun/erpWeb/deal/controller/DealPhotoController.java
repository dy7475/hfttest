package com.myfun.erpWeb.deal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.build.param.UploadSealLogoPhotoParam;
import com.myfun.erpWeb.build.param.UploadSealPhotoParam;
import com.myfun.erpWeb.deal.api.DealPhotoApi;
import com.myfun.erpWeb.deal.param.UploadDealPhotoParam;
import com.myfun.erpWeb.deal.param.UploadFailureCausePhotoParam;
import com.myfun.erpWeb.deal.vo.AdminFunInvoiceEnclosureListVO;
import com.myfun.erpWeb.deal.vo.ErpFunDealPhotoListVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunInvoiceEnclosureMapper;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealTaxesMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealTaxesRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.erpdb.po.ErpFunDealPhotoExample;
import com.myfun.repository.erpdb.po.ErpFunDealRecord;
import com.myfun.repository.erpdb.po.ErpFunDealTaxes;
import com.myfun.repository.erpdb.po.ErpFunDealTaxesRecord;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

@RestController
public class DealPhotoController extends BaseController implements DealPhotoApi{
	@Autowired
	private ErpFunDealPhotoMapper erpFunDealPhotoMapper;
	@Autowired
	private ErpFunDealMapper erpFunDealMapper;
	@Autowired
	private ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	private ErpFunDealTaxesRecordMapper erpFunDealTaxesRecordMapper;
	@Autowired
	private ErpFunDealTaxesMapper erpFunDealTaxesMapper;
	@Autowired
	private ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired
	private AdminFunInvoiceEnclosureMapper adminFunInvoiceEnclosureMapper;

	@Override
	public ResponseJson uploadFunDealPhoto(@RequestBody UploadDealPhotoParam uploadDealPhotoParam) throws Exception {
		Integer dealId = uploadDealPhotoParam.getDealId();
		Byte photoType = uploadDealPhotoParam.getPhotoType();
		String[] photoAddrArr = uploadDealPhotoParam.getPhotoAddr().split(",");
		Integer photoId = uploadDealPhotoParam.getPhotoId();
		
		Operator operator = getOperator();
		// 将需要删除的图片标记为删除
		if(photoId != null){
			ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
			erpFunDealPhoto.setPhotoId(photoId);
			erpFunDealPhoto.setTransmitFlag((byte) 2);
			erpFunDealPhoto.setShardCityId(operator.getCityId());
			erpFunDealPhotoMapper.updateByPrimaryKeySelective(erpFunDealPhoto);
		}
		
		List<ErpFunDealPhoto> list = new ArrayList<>();
		for (String photoAddr : photoAddrArr) {
			ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
			erpFunDealPhoto.setPhotoAddr(photoAddr);
			erpFunDealPhoto.setTransmitFlag((byte) 0);
			erpFunDealPhoto.setUploadUser(operator.getUserId());
			erpFunDealPhoto.setUseageType((byte) 1);
			erpFunDealPhoto.setUploadUserName(operator.getUserName());
			erpFunDealPhoto.setUploadDate(DateTimeHelper.getSystemDate());;
			erpFunDealPhoto.setDealId(dealId);
			erpFunDealPhoto.setCompId(operator.getCompId());
			erpFunDealPhoto.setPhotoType(photoType);;//室内图默认为0，必须为0 不能为null
			erpFunDealPhoto.setFileType(uploadDealPhotoParam.getFileType());
			erpFunDealPhoto.setFileSubType(uploadDealPhotoParam.getFileSubType());
			erpFunDealPhoto.setShardCityId(operator.getCityId());
			erpFunDealPhoto.setUploadDeptName(operator.getDeptCName());
			erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);
			list.add(erpFunDealPhoto);
		}
		//图片上传未成功  会造成集合大小为零
		if(photoAddrArr.length > 0){
			// 0=客户资料附件 1=业主资料表 2=其他资料表 3=定章 4=合同快照
			String photoTypeDesc = "";
            if (photoType == 0) {
                photoTypeDesc = "客户资料附件";
            } else if (photoType == 1) {
                photoTypeDesc = "业主资料附件";
            } else if (photoType == 2) {
                photoTypeDesc = "其他资料附件";
            } else if (photoType == 3) {
                photoTypeDesc = "订章";
            } else if (photoType == 4) {
                photoTypeDesc = "合同快照";
            }
			String trackContent = operator.getUserName()+" 上传了" + photoAddrArr.length + "张"+photoTypeDesc+"图片";
			String updateClassic = Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_UPLOAD_PHOTO;
			writeDealRecord(dealId, null, updateClassic, "0", trackContent, 0,null,false,null);
		}
		ErpFunDealPhotoListVO listVO = new ErpFunDealPhotoListVO();
		listVO.setErpFunDealPhotoList(list);
		listVO.setPicDomain(AppConfig.getHousePicUrl());
		return ErpResponseJson.ok(listVO);
	}
	
	
	/**
	 * 生成合同的记录,记录现在的状态
	 */
	public void writeDealRecord(Integer dealId, String system, String updateClassic, String updateType,
			String trackContent, Integer type, String pfActual, boolean isDetailFlag, String payType) throws Exception {
		String updateContent = buildUpdateContent(dealId, updateType, pfActual, payType);
		if(updateContent.length() <= 0){
			throw new BusinessException("生成合同修改记录内容失败");
		}
		//当前逻辑不需要setFront
//		if(0 != type) {
//			if (isDetailFlag){
//				erpFunDeal.setFront();
//			}
//			erpFunDeal.setUPDATE_CONTENT(updateContent);
//		}
		ErpFunDealRecord erpFunDealRecord = new ErpFunDealRecord();
		erpFunDealRecord.setUpdateClassic(updateClassic);
		erpFunDealRecord.setCompId(getOperator().getCompId());
		erpFunDealRecord.setAgreementNo(dealId.toString());// 虽然字段名是AGREEMENT_NO 实际上存的是DEAL_ID  原因是  这个表是旧表  所以没有修改字段名  仍然实现原来的字段名
		erpFunDealRecord.setUpdateDate(DateTimeHelper.getTimeNow());
		if(!CommonUtil.isnull(system)){
			erpFunDealRecord.setUpdateUid(999);
			erpFunDealRecord.setUpdateUserName("系统默认");
		}else{
			erpFunDealRecord.setUpdateUid(getOperator().getUserId());
			erpFunDealRecord.setUpdateUserName(getOperator().getUserName());
		}
		erpFunDealRecord.setDeptId(getOperator().getDeptId());
		erpFunDealRecord.setTrackContent(trackContent);
		erpFunDealRecord.setUpdateType(Byte.parseByte(updateType));
		erpFunDealRecord.setShardCityId(getOperator().getCityId());
//		erpFunDealRecord.setPfActual(Byte.parseByte(pfActual));
		erpFunDealRecordMapper.insertSelective(erpFunDealRecord);
	}
	
	

	/**
	 * 创建一个合同记录的 updateContent
	 * @author 春平
	 */
	private String buildUpdateContent(Integer dealId,String updateType,String pfActual, String payType) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Operator operator = getOperator();
		ErpFunDeal erpFunDeal = new ErpFunDeal();
		erpFunDeal.setDealId(dealId);
		erpFunDeal.setShardCityId(operator.getCityId());
		erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDeal);
		if("0".equals(updateType)){
			paramMap.put("FUN_DEAL",BeanUtil.objToMap(erpFunDeal));
		}
		List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
		if("1".equals(updateType)){
			List<ErpProcessFinanc> financList = erpProcessFinancMapper.getFinancListByDealId(operator.getCityId(),dealId,pfActual);
			for(ErpProcessFinanc financPO : financList){
				mapList.add(BeanUtil.objToMap(financPO));
			}
			paramMap.put("PROCESS_FINANC",mapList);
		}else if("2".equals(updateType)){
			List<ErpFunProfit> profitList = erpFunProfitMapper.getProFitListByDealId(operator.getCityId(),operator.getCompId(),dealId);
			for(ErpFunProfit profitPO : profitList){
				mapList.add(BeanUtil.objToMap(profitPO));
			}
			paramMap.put("FUN_PROFIT",mapList);
			paramMap.put("FINANC_NAME", erpFunDeal.getFinancName());
		} else if ("4".equals(updateType) || "5".equals(updateType)) {// 4=买方税费 5=卖方税费（税费日志详细比较）
			List<ErpFunDealTaxesRecord> recordPOs = erpFunDealTaxesRecordMapper.getModelDataList(operator.getCityId(),dealId,payType);
			paramMap.put("FUN_TAXES_RECORD", recordPOs);
			List<ErpFunDealTaxes> taxesPOs = erpFunDealTaxesMapper.getModelDataList(operator.getCityId(),dealId,payType);
			paramMap.put("FUN_TAXES", taxesPOs);
		}
		return JSON.toJSONString(paramMap);
	}


	@Override
	public ResponseJson uploadSealPhoto(@RequestBody UploadSealPhotoParam uploadSealPhotoParam) throws Exception {
		Operator operator = getOperator();
		String[] photoAddrArr = uploadSealPhotoParam.getPhotoAddr().split(",");
		
		List<ErpFunDealPhoto> list = new ArrayList<>();
		for (String photoAddr : photoAddrArr) {
			ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
			erpFunDealPhoto.setTransmitFlag((byte) 2);
			ErpFunDealPhotoExample example = new ErpFunDealPhotoExample();
			example.createCriteria().andCompIdEqualTo(getOperator().getCompId());
			example.createCriteria().andPhotoTypeEqualTo((byte) 3);
			example.setShardCityId(operator.getCityId());
			erpFunDealPhotoMapper.updateByExampleSelective(erpFunDealPhoto, example);
			erpFunDealPhoto.setPhotoAddr(photoAddr);
			erpFunDealPhoto.setTransmitFlag((byte) 0);
			erpFunDealPhoto.setCompId(operator.getCompId());
			erpFunDealPhoto.setUploadUser(operator.getUserId());
			erpFunDealPhoto.setUploadDeptName(operator.getDeptCName());
			erpFunDealPhoto.setUploadUserName(operator.getUserName());
			erpFunDealPhoto.setUseageType((byte) 1);
			erpFunDealPhoto.setUploadDate(DateTimeHelper.getSystemDate());
			erpFunDealPhoto.setPhotoType((byte) 7);// 印章
			erpFunDealPhoto.setShardCityId(operator.getCityId());
			erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);
			
			list.add(erpFunDealPhoto);
		}
		ErpFunDealPhotoListVO listVO = new ErpFunDealPhotoListVO();
		listVO.setErpFunDealPhotoList(list);
		return ErpResponseJson.ok(listVO);
	}


	@Override
	public ResponseJson uploadDealLogoPhoto(@RequestBody UploadSealLogoPhotoParam uploadSealPhotoParam) throws Exception {
		Operator operator = getOperator();
		
		List<ErpFunDealPhoto> list = new ArrayList<>();
		String[] photoAddrArr = uploadSealPhotoParam.getPhotoAddr().split(",");
		for (String photoAddr : photoAddrArr) {
			// 更新原本的LOGO
			ErpFunDealPhoto erpFunDealPhoto = new ErpFunDealPhoto();
			erpFunDealPhoto.setShardCityId(operator.getCityId());
			erpFunDealPhoto.setTransmitFlag((byte) 2);
			ErpFunDealPhotoExample example = new ErpFunDealPhotoExample();
			example.createCriteria().andPhotoTypeEqualTo((byte) 3);
			example.createCriteria().andCompIdEqualTo(operator.getCompId());
			example.setShardCityId(operator.getCityId());
			erpFunDealPhotoMapper.updateByExampleSelective(erpFunDealPhoto, example);
			
			erpFunDealPhoto = new ErpFunDealPhoto();
			erpFunDealPhoto.setShardCityId(operator.getCityId());
			erpFunDealPhoto.setPhotoAddr(photoAddr);
			erpFunDealPhoto.setTransmitFlag((byte) 0);
			erpFunDealPhoto.setCompId(operator.getCompId());
			erpFunDealPhoto.setUploadUser(operator.getUserId());
			erpFunDealPhoto.setUseageType((byte) 1);
			erpFunDealPhoto.setUploadDate(DateTimeHelper.getSystemDate());
			erpFunDealPhoto.setPhotoType((byte) 3);// LOGO
			erpFunDealPhoto.setUploadDeptName(operator.getDeptCName());
			erpFunDealPhoto.setUploadUserName(operator.getUserName());
			erpFunDealPhotoMapper.insertSelective(erpFunDealPhoto);

			list.add(erpFunDealPhoto);
		}
		ErpFunDealPhotoListVO listVO = new ErpFunDealPhotoListVO();
		listVO.setErpFunDealPhotoList(list);
		return ErpResponseJson.ok(listVO);
	}


	@Override
	public ResponseJson uploadFailureCauseEdit(@RequestBody UploadFailureCausePhotoParam uploadFailureCausePhotoParam) throws Exception {
		Operator operator = getOperator();
		
		List<AdminFunInvoiceEnclosure> list = new ArrayList<>();
		String[] photoAddrArr = uploadFailureCausePhotoParam.getPhotoAddr().split(",");
		for (String photoAddr : photoAddrArr) {
			AdminFunInvoiceEnclosure adminFunInvoiceEnclosure = new AdminFunInvoiceEnclosure();
			
			adminFunInvoiceEnclosure.setEsType(uploadFailureCausePhotoParam.getEsType());
			adminFunInvoiceEnclosure.setInvoiceId(uploadFailureCausePhotoParam.getInvoiceId());
			adminFunInvoiceEnclosure.setEsPath(photoAddr);
			adminFunInvoiceEnclosure.setCityId(Short.valueOf(operator.getCityId().toString()));
			adminFunInvoiceEnclosure.setCompNo(operator.getCompNo());
			adminFunInvoiceEnclosure.setDeptNo(operator.getDeptNo());
			adminFunInvoiceEnclosure.setCreationTime(DateTimeHelper.getSystemDate());
			adminFunInvoiceEnclosure.setCreateUid(operator.getUserId());
			adminFunInvoiceEnclosure.setEsStatus((byte) 1);

			adminFunInvoiceEnclosureMapper.insertSelective(adminFunInvoiceEnclosure);
			list.add(adminFunInvoiceEnclosure);
		}
		AdminFunInvoiceEnclosureListVO voList = new AdminFunInvoiceEnclosureListVO();
		voList.setAdminFunInvoiceEnclosureList(list);
		return ErpResponseJson.ok(voList);
	}
}

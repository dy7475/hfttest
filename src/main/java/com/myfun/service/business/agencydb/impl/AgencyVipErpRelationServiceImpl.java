package com.myfun.service.business.agencydb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.agencydb.dao.AgencyVipErpRelationMapper;
import com.myfun.repository.agencydb.po.AgencyVipErpRelation;
import com.myfun.repository.agencydb.po.AgencyVipErpRelationExample;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyVipErpRelationService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.utils.Constants_DIC;
@Service
public class AgencyVipErpRelationServiceImpl extends AbstractService<AgencyVipErpRelation, AgencyVipErpRelation>implements AgencyVipErpRelationService {
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired AdminSysParaMapper adminSysParaMapper;
	@Autowired AgencyVipErpRelationMapper agencyVipErpRelationMapper;
	@Autowired ErpFunSaleService erpFunSaleService;
	@Autowired ErpFunLeaseService erpFunLeaseService;
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creatDiDiHouseDealTrack(Integer cityId,Integer caseId, Byte caseType) {
		// 如果当前房源的来源方式不是滴滴就返回，只处理从滴滴来的数据
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
			ErpFunSale erpFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId,caseId);	
			if(!Byte.valueOf(Constants_DIC.DIC_HOUSE_SOURCE_DIDI_HOUSE).equals(erpFunSale.getSaleSource())){
				return;
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)){
			ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, caseId);	
			if(!Byte.valueOf(Constants_DIC.DIC_HOUSE_SOURCE_DIDI_HOUSE).equals(erpFunLease.getLeaseSource())){
				return;
			}
		}
		// 访问uu好房项目同步他们那边
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("caseId", caseId);
			param.put("caseType", caseType);
			param.put("cityId", cityId);
			String didiWebsiteRooturl = adminSysParaMapper.selectParamVlue("YOUYOU_WEBSITE_ROOTURL");
			//HttpHelper.post(didiWebsiteRooturl + "entrust/synHouseDealAction", param);
		} catch (Exception e) {}
		AgencyVipErpRelation agencyVipErpRelation =agencyVipErpRelationMapper.getAgencyVipErpRelation(cityId,caseId,caseType);
		if(agencyVipErpRelation == null){
			return;
		}
		List<AgencyVipErpRelation> agencyVipErpRelationList = agencyVipErpRelationMapper.getAgencyVipErpRelationList(agencyVipErpRelation.getVipId());
	
		// 怕不在一个城市，先记录下来，处理完后再设置回当前用户所在的城市
		//String cityId = getOperator().getCityId();
		
		for (AgencyVipErpRelation agencyVipErpRelationDto : agencyVipErpRelationList) {
			// 当前房源不管
			if(agencyVipErpRelationDto.getVipId().equals(agencyVipErpRelation.getVipId())){
				continue;
			}
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
	//			erpFunSaleService.updateOpenApiHouseDealSync(caseId, Constants_DIC.DIC_HOUSE_STATUS_DEAL);
			} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)){
		//		erpFunLeaseService.updateOpenApiHouseDealSync(caseId, Constants_DIC.DIC_HOUSE_STATUS_DEAL);
			}
		}
		AgencyVipErpRelation updateAgencyVipErpRelation = agencyVipErpRelationMapper.selectByPrimaryKey(agencyVipErpRelation.getVipId());
		updateAgencyVipErpRelation.setStatus(Integer.valueOf(Constants_DIC.DIC_VIPERP_RELATION_STATUS_INVALID));
		agencyVipErpRelationMapper.updateByPrimaryKeySelective(updateAgencyVipErpRelation);
		
		// 回到当前用户的城市
		//getOperator().setCityId(cityId);
	}

	/**
	 * 租转售或售转租时将关联表的记录变为失效
	 * @author 熊刚
	 * @since 2017年10月20日
	 * @param cityId
	 * @param oldCaseId
	 * @param oldCaseType
	 */
	@Override
	public void updateStautsByTransData(Integer cityId, Integer oldCaseId, Byte oldCaseType) {
		AgencyVipErpRelation agencyVipErpRelation =agencyVipErpRelationMapper.getAgencyVipErpRelation(cityId,oldCaseId,oldCaseType);
		agencyVipErpRelation.setStatus(Integer.valueOf(Constants_DIC.DIC_VIPERP_RELATION_STATUS_INVALID));
		agencyVipErpRelationMapper.updateByPrimaryKeySelective(agencyVipErpRelation);
	}

}

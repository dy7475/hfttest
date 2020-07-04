package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminWebSiteMapper;
import com.myfun.repository.admindb.po.AdminWebSite;
import com.myfun.repository.erpdb.dao.ErpCountDoneMapper;
import com.myfun.repository.erpdb.dto.ErpCountDoneDto;
import com.myfun.repository.erpdb.po.ErpCountDone;
import com.myfun.repository.fafundb.dao.FafunShopInfoMapper;
import com.myfun.repository.fafundb.po.FafunShopInfo;
import com.myfun.repository.fafundb.po.FafunShopInfoExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpCountDoneService;
import com.myfun.utils.StringUtil;

@Service
public class ErpCountDoneServiceImpl extends AbstractService< ErpCountDone, ErpCountDone> implements ErpCountDoneService {

	@Autowired
	private ErpCountDoneMapper erpCountDoneMapper;
	@Autowired
	private AdminWebSiteMapper adminWebSiteMapper;
	@Autowired
	private FafunShopInfoMapper fafunShopInfoMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpCountDoneMapper;
	}

	@Override
	public Map<Integer, String> getHouseCountDoneList(Integer cityId, Integer compId, List<Integer> caseIds, Integer caseType, Integer selfArchiveId) {
		if(caseIds == null || caseIds.size() <= 0){
			return null;
		}
		List<AdminWebSite> webSiteList = adminWebSiteMapper.getSiteMapByCityId(cityId);
		List<Integer> sitesList = null;
		if(null != webSiteList && webSiteList.size() > 0){
			sitesList = webSiteList.stream().collect(Collectors.mapping(AdminWebSite::getSiteId, Collectors.toList()));
		}
		// 老版本说的有空能为空
		if(null == sitesList){
			return null;
		}
		FafunShopInfoExample fafunShopInfoExample = new FafunShopInfoExample();
		fafunShopInfoExample.createCriteria().andArchiveIdEqualTo(selfArchiveId).andSiteIdIn(new ArrayList<Integer>(sitesList));
		
		List<FafunShopInfo> fafunShopInfos =  fafunShopInfoMapper.selectByExample(fafunShopInfoExample);
		if(fafunShopInfos == null || fafunShopInfos.size() < 1){
			return null;
		}
		Map<Integer,Integer> sIdSiteIdMap = fafunShopInfos.stream().collect(Collectors.toMap(FafunShopInfo::getsId, FafunShopInfo->FafunShopInfo.getSiteId()));
		Set<Integer> sIds = new HashSet<Integer>();
		for (FafunShopInfo fafunShopInfo : fafunShopInfos) {
			sIds.add(fafunShopInfo.getsId());
		}
		List<ErpCountDoneDto> countDoneList = erpCountDoneMapper.getHouseCountDoneList(cityId,caseType, selfArchiveId, caseIds, sIds);
		Map<Integer, String> resultMap= new HashMap<Integer, String>();
		
		if(countDoneList !=null && countDoneList.size() > 0){
			for (ErpCountDoneDto fafaCountDonePO : countDoneList) {
				Integer houseId = fafaCountDonePO.getHouseId();
				Integer sId = fafaCountDonePO.getsId();
				String siteIds = resultMap.get(houseId);
				if(StringUtil.isBlank(siteIds)){
					siteIds = "";
				} else {
					siteIds += ",";
				}
				siteIds += sIdSiteIdMap.get(sId);
				resultMap.put(houseId, siteIds);
			}
		}
		return resultMap;
	}
	

}

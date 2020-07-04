package com.myfun.service.business.searchdb.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.framework.exception.ConfirmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.searchdb.dao.SearchHezuMapper;
import com.myfun.repository.searchdb.dao.SearchSosoViewMapper;
import com.myfun.repository.searchdb.dto.SearchHeZuDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.po.SearchHezu;
import com.myfun.repository.searchdb.po.SearchHezuKey;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.searchdb.SearchHeZuService;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

@Service
public class SearchHeZuServiceImpl extends AbstractService<SearchHezu, SearchHezuKey> implements SearchHeZuService {
	@Autowired
	private SearchHezuMapper searchHezuMapper;
	@Autowired
	private SearchSosoViewMapper searchSosoViewMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = searchHezuMapper;
	}
	@Override
	public List<SearchRepeatDto> getRepeatHezuList(String cityId, String caseIds) {
		
		return searchHezuMapper.getRepeatHezuList(cityId, caseIds.split(","));
	}
	@Override
	public SearchHeZuDataInfoDto getDataInfoById(SoSoSaleDataInfoParam param) {
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		SearchHeZuDataInfoDto dataInfoDto = searchHezuMapper.getDataInfoById(param);
		if(dataInfoDto != null){
			Integer tatusFlag = dataInfoDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			dataInfoDto.setHouseFlag(tatusFlag);
		}
		return dataInfoDto;
	}
	@Override
	public PageInfo<SearchHeZuDataInfoDto> getSoSoShopMainList(SoSoSaleListParam param, Integer archiveId) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		List<SearchHeZuDataInfoDto> resultList = searchHezuMapper.getSoSoHezuList(param);
		if (resultList != null && resultList.size() > 0) {
			Set<Integer> idSet = new HashSet<Integer>();
			for (SearchHeZuDataInfoDto searchLeaseInDto : resultList) {
				idSet.add(searchLeaseInDto.getId());
			}
			List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(idSet.toArray(new Integer[idSet.size()]),null, archiveId);
			Map<Integer, SearchSosoView> viewMap = new HashMap<Integer, SearchSosoView>();
			for (SearchSosoView searchSosoView : viewInfo) {
				viewMap.put(searchSosoView.getSosoId(), searchSosoView);
			}
			for (int i = 0; i < resultList.size(); i++) {
				SearchHeZuDataInfoDto infoDto = resultList.get(i);
				Integer id = infoDto.getRepeatId();
				if (id == null || id <= 10) {
					id = infoDto.getId();
				}
				SearchSosoView sosoView = viewMap.get(id);
				if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
					infoDto.setConerted("0");
					infoDto.setReaded("1");
					infoDto.setComplaintFlag(sosoView.getComplaintFlag());
					infoDto.setComplaintTime(sosoView.getComplaintTime());
				}else{
					infoDto.setReaded("0");
					infoDto.setConerted("0");
				}
			}
			for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
				Integer tatusFlag = searchHeZuDataInfoDto.getStatusFlag();
				// 判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				searchHeZuDataInfoDto.setHouseFlag(tatusFlag);
			}
		}
		PageInfo<SearchHeZuDataInfoDto> pageInfo = new PageInfo<SearchHeZuDataInfoDto>(resultList);
		return pageInfo;
	}
	@Override
	public PageInfo<SearchHeZuDataInfoDto> getSOSOViewedHeZuList(SoSoSaleListParam param) {
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchHeZuDataInfoDto> resultList = searchHezuMapper.getSOSOViewedHeZuList(param);
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
			Integer tatusFlag = searchHeZuDataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			searchHeZuDataInfoDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchHeZuDataInfoDto> pageInfo = new PageInfo<SearchHeZuDataInfoDto>(resultList);
		return pageInfo;
	}
	
	@Transactional
	@Override
	public void complaintSosoData(String time, Integer sosoId,Integer repeatId, Integer complaintType, Integer archiveId, Integer provinceId, Integer cityId) {
		sosoId = (repeatId == null || repeatId <= 10) ? sosoId : repeatId;
		List<SearchSosoView> soSoViewList = searchSosoViewMapper.getSoSoViewList(new Integer[]{sosoId},repeatId, archiveId);
		if(soSoViewList == null || soSoViewList.isEmpty()) {
			throw new ConfirmException("获取查看记录失败");
		}
		// 已经标记过
		SearchSosoView searchSosoView = soSoViewList.get(0);
		Byte complaintFlag = searchSosoView.getComplaintFlag();
		if(complaintFlag != null && complaintFlag != 0) {
			return;
		}
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(time);
		SearchSosoView sosoViewKey = new SearchSosoView();
		sosoViewKey.setArchiveId(archiveId);
		sosoViewKey.setSosoId(sosoId);
		sosoViewKey.setSosoProperty(searchSosoView.getSosoProperty());
		sosoViewKey.setSosoType(searchSosoView.getSosoType());
		sosoViewKey.setComplaintFlag(complaintType.byteValue());
		searchSosoViewMapper.updateComplaintFlag(sosoViewKey);
		searchHezuMapper.addComplaintCount(tables[0], sosoId, complaintType, provinceId, cityId);
	}
}

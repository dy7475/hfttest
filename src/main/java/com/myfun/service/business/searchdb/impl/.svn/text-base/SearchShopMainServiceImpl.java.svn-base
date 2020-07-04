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
import com.myfun.repository.searchdb.dao.SearchShopMainMapper;
import com.myfun.repository.searchdb.dao.SearchSosoViewMapper;
import com.myfun.repository.searchdb.dto.SearchShopMainInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchHeZuDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.po.SearchShopMain;
import com.myfun.repository.searchdb.po.SearchShopMainKey;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.searchdb.SearchShopMainService;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

@Service
public class SearchShopMainServiceImpl extends AbstractService<SearchShopMain, SearchShopMainKey> implements SearchShopMainService {
	@Autowired
	private SearchShopMainMapper searchShopMainMapper;
	@Autowired
	private SearchSosoViewMapper searchSosoViewMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = searchShopMainMapper;
	}
	@Override
	public List<SearchRepeatDto> getShopMainRepeatList(String cityId, String caseIds) {
		return searchShopMainMapper.getShopMainRepeatList(cityId, caseIds.split(","));
	}
	@Override
	public SearchShopMainInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam param) {
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		SearchShopMainInDataInfoDto dataInfoDto = searchShopMainMapper.getDataInfoById(param);
		if(dataInfoDto != null){
			Integer tatusFlag = dataInfoDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			dataInfoDto.setHouseFlag(tatusFlag);
		}
		return dataInfoDto;
	}
	@Override
	public PageInfo<SearchShopMainInDataInfoDto> getSoSoShopMainList(SoSoSaleListParam param, Integer archiveId) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		List<SearchShopMainInDataInfoDto> resultList = searchShopMainMapper.getSoSoShopMainList(param);
		if (resultList != null && resultList.size() > 0) {
			Set<Integer> idSet = new HashSet<Integer>();
			for (SearchShopMainInDataInfoDto shopMainInDataInfoDto : resultList) {
				idSet.add(shopMainInDataInfoDto.getId());
			}
			List<SearchSosoView> viewInfo = searchSosoViewMapper
					.getSoSoViewList(idSet.toArray(new Integer[idSet.size()]),null, archiveId);
			Map<Integer, SearchSosoView> viewMap = new HashMap<Integer, SearchSosoView>();
			for (SearchSosoView searchSosoView : viewInfo) {
				viewMap.put(searchSosoView.getSosoId(), searchSosoView);
			}
			for (int i = 0; i < resultList.size(); i++) {
				SearchShopMainInDataInfoDto dataInfoDto = resultList.get(i);
				Integer id = dataInfoDto.getRepeatId();
				if (id == null || id <= 10) {
					id = dataInfoDto.getId();
				}
				SearchSosoView sosoView = viewMap.get(id);
				if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
					dataInfoDto.setConerted("0");
					dataInfoDto.setReaded("1");
					dataInfoDto.setComplaintFlag(sosoView.getComplaintFlag());
					dataInfoDto.setComplaintTime(sosoView.getComplaintTime());
				} else {
					dataInfoDto.setReaded("0");
					dataInfoDto.setConerted("0");
				}
			}
			for (SearchShopMainInDataInfoDto searchShopMainInDataInfoDto : resultList) {
				Integer tatusFlag = searchShopMainInDataInfoDto.getStatusFlag();
				// 判断中介虚假房源
				Integer huoseFlag = CommonUtil.getHouseFlg(tatusFlag);
				searchShopMainInDataInfoDto.setHouseFlag(huoseFlag);
			}
		}
		PageInfo<SearchShopMainInDataInfoDto> pageInfo = new PageInfo<SearchShopMainInDataInfoDto>(resultList);
		return pageInfo;
	}
	@Override
	public PageInfo<SearchShopMainInDataInfoDto> getSOSOViewedShopList(SoSoSaleListParam param) {
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchShopMainInDataInfoDto> resultList = searchShopMainMapper.getSOSOViewedShopList(param);
		for (SearchShopMainInDataInfoDto searchShopMainInDataInfoDto : resultList) {
			Integer tatusFlag = searchShopMainInDataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			searchShopMainInDataInfoDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchShopMainInDataInfoDto> pageInfo = new PageInfo<SearchShopMainInDataInfoDto>(resultList);
		return pageInfo;
	}
	
	@Transactional
	@Override
	public void complaintSosoData(String time, Integer sosoId,Integer repeatId, Integer complaintType, Integer archiveId, Integer provinceId, Integer cityId) {
		//sosoId = (sosoId == null || sosoId <= 10) ? sosoId : repeatId;
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
		String[] tables = CommonUtil.getShopTableNameAndDetailName(time);
		SearchSosoView sosoViewKey = new SearchSosoView();
		sosoViewKey.setArchiveId(archiveId);
		sosoViewKey.setSosoId(sosoId);
		sosoViewKey.setSosoProperty(searchSosoView.getSosoProperty());
		sosoViewKey.setSosoType(searchSosoView.getSosoType());
		sosoViewKey.setComplaintFlag(complaintType.byteValue());
		searchSosoViewMapper.updateComplaintFlag(sosoViewKey);
		searchShopMainMapper.addComplaintCount(tables[0], sosoId, complaintType, cityId);
	}
}

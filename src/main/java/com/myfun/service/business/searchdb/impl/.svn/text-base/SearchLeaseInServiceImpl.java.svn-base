package com.myfun.service.business.searchdb.impl;

import java.util.Date;
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
import com.myfun.repository.searchdb.dao.SearchLeaseInMapper;
import com.myfun.repository.searchdb.dao.SearchSosoViewMapper;
import com.myfun.repository.searchdb.dto.SearchLeaseInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchLeaseInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.param.LeaseInParam;
import com.myfun.repository.searchdb.po.SearchLeaseIn;
import com.myfun.repository.searchdb.po.SearchLeaseInKey;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.searchdb.SearchLeaseInService;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;

@Service
public class SearchLeaseInServiceImpl extends AbstractService<SearchLeaseIn, SearchLeaseInKey>implements SearchLeaseInService {
	@Autowired
	private SearchLeaseInMapper searchLeaseInMapper;
	@Autowired
	private SearchSosoViewMapper searchSosoViewMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = searchLeaseInMapper;
	}

	@Override
	public List<SearchRepeatDto> getRepeatLeaseIn(String cityId, String caseIds) {
		return searchLeaseInMapper.getRepeatLeaseIn(cityId, caseIds.split(","));
	}

	@Override
	public void updateLeaseInNotNullById(SearchLeaseIn searchLeaseIn) {
		searchLeaseInMapper.updateNotNullById(searchLeaseIn);
	}

	@Override
	public List<SearchLeaseIn> getLeaseInList(LeaseInParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		return searchLeaseInMapper.getLeaseInList(param);
	}

	@Override
	public SearchLeaseIn getSearchLeaseInById(String id, Date inTime) {
		return searchLeaseInMapper.getSearchLeaseInById(id, "LEASE_IN");
	}

	@Override
	public SearchLeaseInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam param) {
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		SearchLeaseInDataInfoDto dataInfoDto = searchLeaseInMapper.getDataInfoById(param);
		if( dataInfoDto != null ){
			Integer tatusFlag = dataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			dataInfoDto.setHouseFlag(tatusFlag);
		}
		return dataInfoDto;
	}

	@Override
	public PageInfo<SearchLeaseInDto> getSoSoLeaseList(SoSoSaleListParam param, Integer archiveId) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		List<SearchLeaseInDto> resultList = searchLeaseInMapper.getSoSoLeaseList(param);
		if (resultList != null && resultList.size() > 0) {
			Set<Integer> idSet = new HashSet<Integer>();
			for (SearchLeaseInDto searchLeaseInDto : resultList) {
				idSet.add(searchLeaseInDto.getId());
			}
			List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(idSet.toArray(new Integer[idSet.size()]),null, archiveId);
			Map<Integer, SearchSosoView> viewMap = new HashMap<Integer, SearchSosoView>();
			for (SearchSosoView searchSosoView : viewInfo) {
				viewMap.put(searchSosoView.getSosoId(), searchSosoView);
			}
			for (int i = 0; i < resultList.size(); i++) {
				SearchLeaseInDto leaseInDto = resultList.get(i);
				Integer id = leaseInDto.getRepeatId();
				if (id == null || id <= 10) {
					id = leaseInDto.getId();
				}
				SearchSosoView sosoView = viewMap.get(id);
				if (sosoView != null) {
					if ("1".equals(sosoView.getIsConvert())) {
						leaseInDto.setConerted("1");
						leaseInDto.setReaded("1");
					} else {
						leaseInDto.setReaded("1");
						leaseInDto.setConerted("0");
					}
					leaseInDto.setComplaintFlag(sosoView.getComplaintFlag());
					leaseInDto.setComplaintTime(sosoView.getComplaintTime());
				}else{
					leaseInDto.setReaded("0");
					leaseInDto.setConerted("0");
				}
			}
			for(SearchLeaseInDto searchLeaseInDto :resultList){
				Integer tatusFlag = searchLeaseInDto.getStatusFlag();
				//判断中介虚假房源
				Integer huoseFlag = CommonUtil.getHouseFlg(tatusFlag);
				searchLeaseInDto.setHouseFlag(huoseFlag);
			}
		}
		PageInfo<SearchLeaseInDto> pageInfo = new PageInfo<SearchLeaseInDto>(resultList);
		return pageInfo;
	}

	@Override
	public PageInfo<SearchLeaseInDto> getSOSOViewedLeaseList(SoSoSaleListParam param) {
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchLeaseInDto> resultList = searchLeaseInMapper.getSOSOViewedLeaseList(param);
		for(SearchLeaseInDto searchLeaseInDto :resultList){
			Integer tatusFlag = searchLeaseInDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			searchLeaseInDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchLeaseInDto> pageInfo = new PageInfo<SearchLeaseInDto>(resultList);
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
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(time);
		SearchSosoView sosoViewKey = new SearchSosoView();
		sosoViewKey.setArchiveId(archiveId);
		sosoViewKey.setSosoId(sosoId);
		sosoViewKey.setSosoProperty(searchSosoView.getSosoProperty());
		sosoViewKey.setSosoType(searchSosoView.getSosoType());
		sosoViewKey.setComplaintFlag(complaintType.byteValue());
		searchSosoViewMapper.updateComplaintFlag(sosoViewKey);
		searchLeaseInMapper.addComplaintCount(tables[0], sosoId, complaintType, provinceId, cityId);
	}
}

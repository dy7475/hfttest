package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyMessageFavMapper;
import com.myfun.repository.agencydb.dto.AgencyMessageFavDto;
import com.myfun.repository.agencydb.po.AgencyMessageFav;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyMessageFavService;

/**
 * @TODO
 * @author lcb
 * @2016-9-19 下午5:53:58
 */
@Service
public class AgencyMeaageFavServiceImpl extends AbstractService<AgencyMessageFav, Integer>implements AgencyMessageFavService {
	@Autowired
	AgencyMessageFavMapper agencyMessageFavMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyMessageFavMapper;
	}

	@Override
	public PageInfo<AgencyMessageFavDto> getDistMsgConnllectionList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("archiveId", param.getInteger("archiveId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyMessageFavDto> resList = agencyMessageFavMapper.getDistMsgConnllectionList(pMap);
		return new PageInfo<>(resList);
	}

	@Override
	public Integer updateDistMsgConnllection(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("archiveId", param.getInteger("archiveId"));
		String type = pMap.get("operType")+"";
		if("1".equals(type)) { // 收藏
			Integer count = agencyMessageFavMapper.countByCondition(pMap);
			if(count == 0) {
				AgencyMessageFav agencyMessageFav = new AgencyMessageFav();
				agencyMessageFav.setArchiveId( param.getInteger("archiveId"));
				agencyMessageFav.setMessTime(new Date());
				agencyMessageFav.setMsgId(Integer.valueOf(pMap.get("spreadId")+""));
				agencyMessageFav.setUserNo(param.getString("userNo"));
				agencyMessageFavMapper.insertSelective(agencyMessageFav);
			}
		}else { // 取消收藏
			agencyMessageFavMapper.deleteByCondition(pMap);
		}
		return null;
	}


}

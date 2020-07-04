package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.ErpBuildSectionMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.po.ErpBuildSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunSectionMapper;
import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.repository.erpdb.po.ErpFunSectionExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunSectionService;

@Service
public class ErpFunSectionServiceImpl extends AbstractService<ErpFunSection, ErpFunSection> implements ErpFunSectionService {
	@Autowired
	private ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpBuildSectionMapper erpBuildSectionMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunSectionMapper;
	}

	@Override
	public List<ErpFunSection> getSectionList(Integer cityId, Integer regId) {
		ErpFunSectionExample example = new ErpFunSectionExample();
		example.createCriteria().andCityIdEqualTo(cityId.shortValue())
		.andRegIdEqualTo(regId).andVertifyFlagEqualTo((byte) 1);
		example.setShardCityId(cityId);
		return erpFunSectionMapper.selectByExample(example);
	}

	@Transactional
	@Override
	public Integer getSectionIdBySectionName(Integer cityId, String sectionName, Integer saleRegion, Integer buildId) {
		List<ErpFunSection> funSectionPOList =erpFunSectionMapper.selectSectionListByName(cityId.shortValue(),sectionName.toUpperCase());
		// 有同名的片区返回sectionId
		if (!funSectionPOList.isEmpty()) {
			return funSectionPOList.get(0).getSectionId();
		}
		// 没有同名片区就添加一个片区
		ErpFunSection funSectionPO = new ErpFunSection();
		// 没有build_id和province_id这两个字段
		funSectionPO.setRegId(saleRegion);
		funSectionPO.setCityId(cityId.shortValue());
		funSectionPO.setSectionName(sectionName);
		funSectionPO.setVertifyFlag((byte)0);
		funSectionPO.setShardCityId(cityId);
		erpFunSectionMapper.insertSelective(funSectionPO);
		Integer sectionId=funSectionPO.getSectionId();
		/* 参考 saleJBean.java 中的2010-06-02 增加更新楼盘所属片区 */
		erpBuildingInfoMapper.UpdateFloorSection(cityId,sectionId,buildId);
		/* 参考 saleJBean.java 中的2010-06-07 增加楼盘片区关联收集 */
		ErpBuildSection buildSectionPO = new ErpBuildSection();
		buildSectionPO.setBuildId(buildId);
		buildSectionPO.setSectionId(sectionId);
		buildSectionPO.setShardCityId(cityId);
		erpBuildSectionMapper.insertSelective(buildSectionPO);
		return sectionId;
	}

}

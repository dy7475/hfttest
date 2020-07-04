package com.myfun.service.business.agencydb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyBuildLayoutMapper;
import com.myfun.repository.agencydb.dao.AgencyBuildingPhotoMapper;
import com.myfun.repository.agencydb.po.AgencyBuildLayout;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBuildLayoutService;

@Service
public class AgencyBuildLayoutServiceImpl extends AbstractService<AgencyBuildLayout, Integer> implements AgencyBuildLayoutService {
	@Autowired
	private AgencyBuildLayoutMapper agencyBuildLayoutMapper;
	@Autowired
	private AgencyBuildingPhotoMapper agencyBuildingPhotoMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBuildLayoutMapper;
	}

	@Override
	public Integer addOrEditBuildLayout(AgencyBuildLayout agencyBuildLayout, AdminCrmUser adminCrmUser) {
		Integer res = 0;
		// 判断layoutId
		if(null != agencyBuildLayout.getLayoutId()) {
			// 编辑
			res = agencyBuildLayoutMapper.updateByPrimaryKeySelective(agencyBuildLayout);
		}else {
			//
			res = agencyBuildLayoutMapper.insertSelective(agencyBuildLayout);
		}
		return res;
	}

	@Override
	public AgencyBuildLayout selectByBuildLayoutId(Integer layoutId) {
		// TODO Auto-generated method stub
		return agencyBuildLayoutMapper.selectByPrimaryKey(layoutId);
	}

	@Override
	public List<AgencyBuildLayout> selectBuildLayoutByBuildAndCity(Integer buildId, Integer cityId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		return agencyBuildLayoutMapper.selectBuildLayoutByBuildAndCity(paramMap);
	}

	/**
	 * 删除
	 * **/
	@Transactional
	@Override
	public Integer deleteBuildLayout(Integer layoutId) {
		Integer res = agencyBuildingPhotoMapper.deleteLayout(layoutId);
		return agencyBuildLayoutMapper.deleteByPrimaryKey(layoutId);
	}

	/**
	 * @TODO 新增修改删除户型
	 * @author lcb
	 * @2016-10-9 上午11:50:27
	 * @param * 3新增，2编辑，1删除
	 */
	@Transactional
	@Override
	public Integer saveOrUpdateDistBuildLayout(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		String editFlag = pMap.get("editFlag")+"";
		String layoutId = pMap.get("layoutId")+"";
		String buildId = pMap.get("buildId")+"";
		String layoutPic1 = pMap.get("layoutPic1")+"";
		String layoutPic2 = pMap.get("layoutPic2")+"";
		if(StringUtils.isNotBlank(layoutPic1)){
			pMap.put("layoutPic1", layoutPic1.replace(AppConfig.getPicDomainUrl(), ""));
		}
		if(StringUtils.isNotBlank(layoutPic2)){
			pMap.put("layoutPic2", layoutPic1.replace(AppConfig.getPicDomainUrl(), ""));
		}
		if (StringUtils.isBlank(layoutId) && "3".equals(editFlag)) {
			 // 查询最大seqNo
			AgencyBuildLayout agencyBuildLayout = agencyBuildLayoutMapper.selectMaxSeqNo(param.getInteger("cityId"), buildId);
			if(null != agencyBuildLayout) {
				pMap.put("seqNo", agencyBuildLayout.getSeqNo()+1);
			}else {
				pMap.put("seqNo", 0);
			}
			agencyBuildLayoutMapper.insertSelectiveMap(pMap);
		} else {
			agencyBuildLayoutMapper.updateBySelectiveMap(pMap);
		}
		return null;
	}

	/**
	 * @TODO 分销户型
	 * @author lcb
	 * @2016-9-24 下午5:25:15
	 */
	@Override
	public PageInfo<AgencyBuildLayout> getBuildLayoutList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyBuildLayout> resList = agencyBuildLayoutMapper.getBuildLayoutList(pMap);
		for (int i = 0; i < resList.size(); i++) {
			AgencyBuildLayout pic = resList.get(i);
			if(StringUtils.isNotBlank(pic.getLayoutPic1())){
				String picStr1 = CommonUtil.getPhotoUrl(pic.getLayoutPic1());
				pic.setLayoutPic1(picStr1);
			}
			if(StringUtils.isNotBlank(pic.getLayoutPic2())){
				String picStr2 = CommonUtil.getPhotoUrl(pic.getLayoutPic2());
				pic.setLayoutPic2(picStr2);
			}
		}
		return new PageInfo<>(resList);
	}

}

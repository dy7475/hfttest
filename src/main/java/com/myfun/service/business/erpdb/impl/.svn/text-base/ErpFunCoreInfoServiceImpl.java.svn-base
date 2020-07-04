package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunCoreInfoMapper;
import com.myfun.repository.erpdb.po.ErpFunCoreInfo;
import com.myfun.repository.erpdb.po.ErpFunCoreInfoExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunCoreInfoService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.EnCodeHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class ErpFunCoreInfoServiceImpl extends AbstractService<ErpFunCoreInfo, ErpFunCoreInfo> implements ErpFunCoreInfoService {
	@Autowired private ErpFunCoreInfoMapper erpFunCoreInfoMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunCoreInfoMapper;
	}

	/**
	 * title ：核心信息修改增加
	 * athor：lcb
	 * date  : 2017/11/15
	 */
	@Transactional
	@Override
	public void createOrUpdateCoreInfo(Integer cityId, Integer compId, Integer caseId, Integer caseType, Integer buildId, String houseRoof,
									   String houseUnit, String unitFloor, String houseRoom, Byte useage, String tradeAddr) {
		unitFloor = EnCodeHelper.decode(unitFloor);
		ErpFunCoreInfoExample erpFunCoreInfoExample = new ErpFunCoreInfoExample();
		erpFunCoreInfoExample.setShardCityId(cityId);
		erpFunCoreInfoExample.createCriteria().andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
		List<ErpFunCoreInfo> recordList = erpFunCoreInfoMapper.selectByExample(erpFunCoreInfoExample);
		if(StringUtils.isBlank(houseRoom)) {
			houseRoom = "";
		}
		String[] houseRoomArr = houseRoom.split(",");
		for (String room : houseRoomArr) {
			List<String> md5StrList = erpSysParaService.encodeToMD5(houseRoof, houseUnit, unitFloor, room, buildId, useage, tradeAddr, cityId, compId);
			String addrMd5 = "";// 默认更新为空值
			if(md5StrList.size() > 0) {
				addrMd5 = md5StrList.get(0);
			}

			ErpFunCoreInfo erpFunCoreInfo = new ErpFunCoreInfo();
			erpFunCoreInfo.setShardCityId(cityId);
			erpFunCoreInfo.setCaseId(caseId);
			erpFunCoreInfo.setCaseType(caseType);
			erpFunCoreInfo.setBuildId(buildId);
			erpFunCoreInfo.setCompId(compId);
			erpFunCoreInfo.setAddrMd5(addrMd5);
			erpFunCoreInfo.setHouseFloor(unitFloor);
			erpFunCoreInfo.setHouseRoof(houseRoof);
			erpFunCoreInfo.setHouseUnit(houseUnit);
			erpFunCoreInfo.setRoomId(room);
			if (recordList == null || recordList.isEmpty()) {
				erpFunCoreInfo.setCreationTime(new Date());
				erpFunCoreInfoMapper.insertSelective(erpFunCoreInfo);
			} else {
				ErpFunCoreInfo removeInfo = recordList.remove(0);
				erpFunCoreInfo.setId(removeInfo.getId());
				erpFunCoreInfoMapper.updateByPrimaryKeySelective(erpFunCoreInfo);
			}
		}

		Set<Integer> ids = new HashSet<>();

		for (ErpFunCoreInfo erpFunCoreInfo : recordList) {
			ids.add(erpFunCoreInfo.getId());
		}

		// 删除多余的
		if(ids.size() > 0) {
			erpFunCoreInfoExample = new ErpFunCoreInfoExample();
			erpFunCoreInfoExample.setShardCityId(cityId);
			erpFunCoreInfoExample.createCriteria().andIdIn(new ArrayList<>(ids));
			erpFunCoreInfoMapper.deleteByExample(erpFunCoreInfoExample);
		}
	}
	

}

package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.buildData.param.saveBuildDeptsParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpBuildAllotMapper;
import com.myfun.repository.erpdb.dao.ErpBuildLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.po.ErpBuildAllot;
import com.myfun.repository.erpdb.po.ErpBuildLog;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildAllotService;
import com.myfun.utils.StringUtil;
import org.apache.kafka.common.config.ConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @create by 程二狗 on 2019/2/21 0021
 **/
@Service
public class ErpBuildAllotServiceImpl extends AbstractService<ErpBuildAllot, ErpBuildAllot> implements ErpBuildAllotService {

    @Autowired
    ErpBuildAllotMapper erpBuildAllotMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpBuildLogMapper erpBuildLogMapper;
    @Autowired
    ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildAllotMapper;
    }

    @Transactional
    @Override
    public void saveErpBuildAllot(Integer cityId, Integer compId,String userName,Integer userId, String deptName,saveBuildDeptsParam param, boolean newOrg) {
		String depts = param.getDeptIds();
		Set<Integer> detsList = new HashSet<>();
		Integer buildId = param.getBuildId();
		if (null == buildId) {
			throw new BusinessException("请选择要分配的楼盘!");
		}
		erpBuildAllotMapper.deleteBeforConfigBuild(cityId, compId, buildId);
		if (StringUtil.isEmpty(depts)) {
			ErpBuildLog log = new ErpBuildLog();
			log.setShardCityId(cityId);
			log.setBuildId(param.getBuildId());
			log.setTrackTime(new Date());
			log.setCreationTime(new Date());
			log.setUpdateUser(userName);
			log.setUpdateUserId(userId);
			log.setCompId(compId);
			String content = deptName + "店" + userName + "清空了该楼盘的分配";
			log.setTrackConten(content);
			erpBuildLogMapper.insertSelective(log);
			return;
		}

		if (depts.contains(",")) {
			List<String> detsListTem = Arrays.asList(depts.split(","));
			detsListTem.forEach(val -> detsList.add(Integer.valueOf(val)));
		} else {
			detsList.add(Integer.valueOf(depts));
		}
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, detsList);
		Map<Integer, String> deptNames = deptList.stream()
				.collect(Collectors.toMap(val -> val.getDeptId(), val -> val.getDeptCname()));
		String deptNamesStr = deptList.stream().map(val -> val.getDeptCname()).collect(Collectors.joining("、"));

		if (newOrg) {
			List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectOrgByOrgWithOrgIds(cityId,
					new ArrayList<>(detsList));
			deptNames = erpFunOrganizations.stream()
					.collect(Collectors.toMap(val -> val.getOrganizationId(), val -> val.getOrganizationName()));
			deptNamesStr = erpFunOrganizations.stream().map(val -> val.getOrganizationName())
					.collect(Collectors.joining("、"));
		}
		for (Integer deptId : detsList) {
			// 判重 前端控制
			// ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
			// allotExample.setShardCityId(cityId);
			// allotExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(param.getBuildId()).andDeptIdEqualTo(deptId).andIsDelEqualTo((byte)1);
			// List<ErpBuildAllot> allowtList =
			// erpBuildAllotMapper.selectByExample(allotExample);
			ErpBuildAllot allot = new ErpBuildAllot();
			allot.setShardCityId(cityId);
			allot.setCreateTime(new Date());
			allot.setBuildId(param.getBuildId());
			allot.setCompId(compId);
			allot.setCreateUser(userName);
			allot.setCreateUserId(userId);
			allot.setDeptId(deptId);
			allot.setDeptName(deptNames.get(deptId));
			erpBuildAllotMapper.insertSelective(allot);
		}
		ErpBuildLog log = new ErpBuildLog();
		log.setShardCityId(cityId);
		log.setBuildId(param.getBuildId());
		log.setTrackTime(new Date());
		log.setCreationTime(new Date());
		log.setUpdateUser(userName);
		log.setUpdateUserId(userId);
		log.setCompId(compId);
		String content = deptName + "店" + userName + "将楼盘分配给" + deptNamesStr + "使用";
		log.setTrackConten(content);
		erpBuildLogMapper.insertSelective(log);
    }
}

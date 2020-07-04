package com.myfun.service.business.admindb.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.Constants_DIC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunErpUserGuideMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunErpUserGuide;
import com.myfun.repository.admindb.po.AdminFunErpUserGuideExample;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.erpdb.po.ErpUserOpersExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunErpUserGuideService;
import com.myfun.utils.DateTimeHelper;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

/**
 * 用户首次登陆引导
 */
@Service
public class AdminFunErpUserGuideServiceImpl extends AbstractService<AdminFunErpUserGuide, Integer>implements AdminFunErpUserGuideService {

	@Autowired AdminFunErpUserGuideMapper adminFunErpUserGuideMapper;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunErpUserGuideMapper;
	}

	@Transactional
	@Override
	public void insertAllUserGuide(Integer archiveId) {
		AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date registrationTime = funArchive.getCreationTime();
		Integer[] guideType = new Integer[]{};
		String onlineTime = "2017-08-15 00:00:00";
		try {
			if (DateTimeHelper.compareTwoDate(sdf.parse(onlineTime), registrationTime) > 0) {
				guideType = new Integer[]{1, 2, 3, 4, 5, 9};
			} else {
				guideType = new Integer[]{1, 2, 3, 4, 5, 10};
			}
			AdminFunErpUserGuide insertModel = new AdminFunErpUserGuide();
			insertModel.setArchiveId(archiveId);
			insertModel.setCreationTime(new Date());
			insertModel.setStatus((byte) 0);
			for (Integer type : guideType) {
				insertModel.setGuideType(type);
				insertModel.setId(null);// 必须设置为空，不然第二次会主键冲突
				adminFunErpUserGuideMapper.insertSelective(insertModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertUserSeniorGuide(Integer userId, Integer archiveId) {
		if(userId == null || archiveId == null) {
			return;
		}
		Set<Integer> guideTypeSet = new HashSet<Integer>();
		ErpUserOpersExample example = new ErpUserOpersExample();
		example.createCriteria().andUserIdEqualTo(userId).andOperIdIn(Arrays.asList("GROUP_MANAGE", "ROLE_MANAGE"));
		example.setShardArchiveId(archiveId);
		List<ErpUserOpers> opersList = erpUserOpersMapper.selectByExample(example);
		if(opersList == null || opersList.isEmpty()) {
			return;
		}
		Map<String, ErpUserOpers> opersMap = new HashMap<String, ErpUserOpers>();
		for (ErpUserOpers erpUserOpers : opersList) {
			opersMap.put(erpUserOpers.getOperId(), erpUserOpers);
		}
		// 如果用户具有这个权限--组织机构管理权
		if(opersMap.get("GROUP_MANAGE") != null) {
			guideTypeSet.add(6);
		}
		// 员工权限配置权
		if(opersMap.get("ROLE_MANAGE") != null) {
			guideTypeSet.add(7);
		}
		if(guideTypeSet.isEmpty()) {
			return;
		}
		// 没有时插入这个引导
		for (Integer guideType : guideTypeSet) {
			AdminFunErpUserGuideExample countExample = new AdminFunErpUserGuideExample();
			countExample.createCriteria().andArchiveIdEqualTo(archiveId).andGuideTypeEqualTo(guideType);
			int count = adminFunErpUserGuideMapper.countByExample(countExample);
			// 如果已经有引导记录
			if(count <= 0) {
				AdminFunErpUserGuide insertModel = new AdminFunErpUserGuide();
				insertModel.setArchiveId(archiveId);
				insertModel.setGuideType(guideType);
				insertModel.setCreationTime(new Date());
				insertModel.setStatus((byte) 0);
				adminFunErpUserGuideMapper.insertSelective(insertModel);
			}
		}
	}

	/**
	 * 修改引导状态
	 * @author 朱科
	 * @since 2018年7月13日
	 * @return
	 */
	@Override
	public void updateUserGuide(Integer status, Integer archiveId, String guideType) {
		if(StringUtils.isBlank(guideType)) {
			return;
		}
		String updateTime = DateTimeHelper.formatDateTimetoString(new Date());
		adminFunErpUserGuideMapper.updateUserGuide(status, archiveId, guideType, updateTime);
	}

	/**
	  * @Title  : 添加引导
	  * @author : lcb
	  * @Time   ： 2018/7/23
	  *
	  **/
	@Override
	public void insertUserSeniorGuideByRole(Integer cityId, Integer compId, String roleId) {
		// 查询出有权限的人列表 组织机构管理权，员工权限配置权
		List<ErpUserOpers> operList = erpUserOpersMapper.getListByRoleId(cityId, compId, roleId);
		if(operList.size() > 0) {
			List<Integer> userIdList = operList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIdList);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			Map<Integer, ErpFunUsers> erpFunUsersMap = erpFunUsersList.stream().collect(Collectors.toMap(val -> val.getUserId(), val->val));

			for (ErpUserOpers erpUserOpers : operList) {
				ErpFunUsers erpFunUsers = erpFunUsersMap.get(erpUserOpers.getUserId());
				if(null != erpFunUsers) {
					AdminFunErpUserGuide adminFunErpUserGuide = new AdminFunErpUserGuide();
					adminFunErpUserGuide.setArchiveId(erpFunUsers.getArchiveId());
					// 如果用户具有这个权限--组织机构管理权
					if("GROUP_MANAGE".equals(erpUserOpers.getOperId())) {
						adminFunErpUserGuide.setGuideType(Const.DIC_ERP_USER_GUIDE_TYPE_6);
					}
					// 员工权限配置权
					if("ROLE_MANAGE".equals(erpUserOpers.getOperId())) {
						adminFunErpUserGuide.setGuideType(Const.DIC_ERP_USER_GUIDE_TYPE_7);
					}
					AdminFunErpUserGuideExample guideExample = new AdminFunErpUserGuideExample();
					guideExample.createCriteria().andArchiveIdEqualTo(erpFunUsers.getArchiveId()).andGuideTypeEqualTo(adminFunErpUserGuide.getGuideType());
					Integer count = adminFunErpUserGuideMapper.countByExample(guideExample);
					// 如果没有引导记录
					if(count <= 0) {
						adminFunErpUserGuide.setCreationTime(new Date());
						adminFunErpUserGuide.setStatus((byte) 0);
						adminFunErpUserGuideMapper.insertSelective(adminFunErpUserGuide);
					}
				}
			}
		}
	}
}

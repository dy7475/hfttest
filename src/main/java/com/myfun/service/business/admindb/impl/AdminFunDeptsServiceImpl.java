package com.myfun.service.business.admindb.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminCustomLeaguesMapper;
import com.myfun.repository.admindb.dao.AdminCustomLeaguesSkinModelMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminWeiUserInfoMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminWeiUserInfo;
import com.myfun.repository.admindb.po.AdminWeiUserInfoExample;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;

@Service
public class AdminFunDeptsServiceImpl extends AbstractService<AdminFunDepts, Integer>implements AdminFunDeptsService {
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	AdminWeiUserInfoMapper adminWeiUserInfoMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminCustomLeaguesMapper adminCustomLeaguesMapper;
	@Autowired
	private AdminCustomLeaguesSkinModelMapper adminCustomLeaguesSkinModelMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunDeptsMapper;
	}

	@Override
	public List<AdminWeiUserInfo> getYouConnectorList(String compNo, String deptNo) {
		// 查询对接人
		List<AdminWeiUserInfo> list = adminWeiUserInfoMapper.getList(compNo, deptNo);
		// 这里做冗余
		if(list.size() == 0) {
			// 查询区域内相邻门店的过户人
			List<AdminFunDepts> resList = adminFunDeptsMapper.getList(compNo, deptNo);
			Integer youDockingUid,youTransferUid;
			if(resList.size() > 0) {
				AdminFunDepts adminFunDeptsPO = resList.get(0);
				youDockingUid = adminFunDeptsPO.getYouDockingUid();
				youTransferUid = adminFunDeptsPO.getYouTransferUid();
				List<Integer> userIds = Arrays.asList(new Integer[]{youDockingUid, youTransferUid});
				AdminWeiUserInfoExample adminWeiUserInfoExample = new AdminWeiUserInfoExample();
				adminWeiUserInfoExample.createCriteria().andWeiUserIdIn(userIds);

				List<AdminWeiUserInfo> record = adminWeiUserInfoMapper.selectByExample(adminWeiUserInfoExample);
				for (AdminWeiUserInfo adminWeiUserInfo: record) {
					if(adminWeiUserInfo.getWeiUserId().equals(adminFunDeptsPO.getYouDockingUid())) {
						list.add(adminWeiUserInfo);
						break;
					}
				}

			}else {
				youDockingUid= Constants_DIC.YOUJIA_DOCKING_DEFAULT_UID;
				youTransferUid=Constants_DIC.YOUJIA_TRANSFER_DEFAULT_UID;
				// 查询万芳的信息
				AdminWeiUserInfo adminWeiUserInfo = adminWeiUserInfoMapper.selectByPrimaryKey(youDockingUid);
				if(null != adminWeiUserInfo) {
					list.add(adminWeiUserInfo);
				}
			}
			// 修改
			AdminFunDepts adminFunDepts = new AdminFunDepts();
			adminFunDepts.setCompNo(compNo);
			adminFunDepts.setDeptNo(deptNo);
			adminFunDepts.setYouDockingUid(youDockingUid);
			adminFunDepts.setYouTransferUid(youTransferUid);
			adminFunDeptsMapper.updateFunDeptsDockUidAndTransferUid(adminFunDepts);
		}
		return list;
	}
	
	/**
	 * 是否开通YOU+
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	@Override
	public boolean isShowYou(Integer compId) {
		int count = adminFunDeptsMapper.countNumByCompId(compId);
		//获取系统参数的开通YOu+的最大值
		String openYouNum = adminSysParaMapper.selectParamVlue("OPENYOUNUM");
		int num = StringUtil.paseInteger(openYouNum, 0);
		return count < num;
	}

	@Override
	public String getAppIdByVersion(Integer archiveId) {
		if (null == archiveId) {
			return "";
		}
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
		if (null != adminFunArchive) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByArchiveId(adminFunArchive.getCityId().intValue(), adminFunArchive.getArchiveId());
			if (null != erpFunUsers) {
				Integer deptId = erpFunUsers.getDeptId();
				ErpFunDepts erpFunDepts = new ErpFunDepts();
				erpFunDepts.setShardCityId(adminFunArchive.getCityId().intValue());
				erpFunDepts.setDeptId(deptId);
				erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);
				if (null != erpFunDepts) {
					String compNo = erpFunDepts.getCompNo();
					String deptNo = erpFunDepts.getDeptNo();
					if (StringUtil.isNotBlank(compNo) && StringUtil.isNotBlank(deptNo)) {
						AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
						if (null != adminFunDepts) {// 是否是物业版，是就物业版的子弹找房分享appId
							if (Byte.valueOf("5").equals(adminFunDepts.getDeptType())) {
								return AppConfig.getPropertyZdzfShareAppId();
							}
						}
						AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
						if (null != adminFunComp && Byte.valueOf("1").equals(adminFunComp.getSpecialCustomized())) {// 是否开启了定制，比如房口袋或者友邻通
							Integer leaguesType = adminCustomLeaguesMapper.selectLeaguesTypeByCompNo(compNo);
							if (null != leaguesType) {
								String appId = adminCustomLeaguesSkinModelMapper.selectSkinPicUrlByLeaguesTypeAndSkinType(leaguesType, "MINI_PROGRAM_ID");
								if (StringUtil.isNotBlank(appId)) {
									return appId;
								}
							}
						}
						
						if (null != adminFunComp) {// 玛雅好房的小程序id
							if (Byte.valueOf("2").equals(adminFunComp.getCompManagementModel()) && Integer.valueOf(1).equals(adminFunComp.getCustomizedType())) {
								return AppConfig.getFjdShareAppId();
							} else if ((AppConfig.isOnline() && "E1DP".equals(adminFunComp.getCompNo())) || (!AppConfig.isOnline() && Arrays.asList("CGM6", "D239").contains(adminFunComp.getCompNo()))) {// 玛雅好房是一家公司，直接写死公司编号
								return AppConfig.getMyhfShareAppId();
							}
						}
						
						if (null != adminFunDepts) {
							if (Integer.valueOf("1").equals(adminFunDepts.getYouDianStatus())) {
								return AppConfig.getShareAppId();
							} else {
								return AppConfig.getFlagShipShareAppId();
							}
						}
					}
				}
			}
		}
		return "";
	}
}

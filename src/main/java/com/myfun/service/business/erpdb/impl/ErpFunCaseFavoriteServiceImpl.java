package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.dao.ErpFunCaseFavoriteMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.param.CaseFavoriteParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunCaseFavorite;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.MsgModuleType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunUserMessageService;
import com.myfun.service.business.erpdb.ErpFunCaseFavoriteService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.StringUtil;

@Service
public class ErpFunCaseFavoriteServiceImpl extends AbstractService<ErpFunCaseFavorite, ErpFunCaseFavorite> implements ErpFunCaseFavoriteService{
	@Autowired private ErpFunCaseFavoriteMapper erpFunCaseFavoriteMapper;
	@Autowired private AdminSysParaMapper adminSysParaMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private AdminFunUserMessageService adminFunUserMessageService;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunCaseFavoriteMapper;
	}

	/**
	 * 添加收藏房客源
	 * @author 臧铁
	 * @param param  compId 公司ID  creationTime 收藏时间  favoriteUid 收藏人 favoriteStatus 收藏状态 1收藏中 ...
	 * @since 2017年5月9日
	 * @return
	 */
	@Override
	public Integer insertFunCaseFavorite(CaseFavoriteParam param) {
		Integer allCount = null;
		String paramId = "";
		switch (param.getCaseType()) {
			case Const.HouseCustType.SALE:
				paramId = "FUN_SALE_FAVORITE_COUNT";
				allCount = erpFunCaseFavoriteMapper.countSaleFavorite(param.getCityId(), param);
				break;
			case Const.HouseCustType.LEASE:
				paramId = "FUN_LEASE_FAVORITE_COUNT";
				allCount = erpFunCaseFavoriteMapper.countLeaseFavorite(param.getCityId(), param);
				break;
			case Const.HouseCustType.BUY_CUST:
				paramId = "BUY_CUST_FAVORITE_COUNT";
				allCount = erpFunCaseFavoriteMapper.count(param.getCityId(), param);
				break;
			case Const.HouseCustType.RENT_CUST:
				paramId = "RENT_CUST_FAVORITE_COUNT";
				allCount = erpFunCaseFavoriteMapper.count(param.getCityId(), param);
				break;
		}
		String adminSysPara = adminSysParaMapper.selectParamVlue(paramId);
		Integer canWriteCount = StringUtil.parseInteger(adminSysPara, 50);
		if (allCount < canWriteCount) {
			ErpFunCaseFavorite caseFavorite = erpFunCaseFavoriteMapper.getByFavoriteUid(param.getCityId(), param);
			if (null != caseFavorite) {
				Byte favoriteStatus = caseFavorite.getFavoriteStatus();
				if (favoriteStatus == null || 0 == favoriteStatus) {
					caseFavorite.setFavoriteStatus((byte) 1);
					caseFavorite.setCreationTime(new Date());
					caseFavorite.setShardCityId(param.getCityId());
					erpFunCaseFavoriteMapper.updateByPrimaryKeySelective(caseFavorite);
					return caseFavorite.getFavoriteId();
				} else {
					throw new BusinessException("您已经收藏过了!");
				}
			} else {
				ErpFunCaseFavorite erpFunCaseFavorite = new ErpFunCaseFavorite();
				erpFunCaseFavorite.setCreationTime(new Date());
				erpFunCaseFavorite.setCompId(param.getCompId());
				erpFunCaseFavorite.setFavoriteStatus((byte) 1);
				erpFunCaseFavorite.setFavoriteUid(param.getFavoriteUid());
				erpFunCaseFavorite.setCaseId(param.getCaseId());
				erpFunCaseFavorite.setCaseNo(param.getCaseNo());
				erpFunCaseFavorite.setCaseType(param.getCaseType());
				erpFunCaseFavorite.setShardCityId(param.getCityId());
				erpFunCaseFavoriteMapper.insertSelective(erpFunCaseFavorite);
				return erpFunCaseFavorite.getFavoriteId();
			}
		} else {
			throw new BusinessException("收藏数超过" + canWriteCount + "条！");
		}
	}

	/**
	 * 删除收藏房客源
	 * @author 臧铁
	 * @param param  favoriteId 主键
	 * @since 2017年5月9日
	 * @return
	 */
	@Override
	public void delCaseFavorite(CaseFavoriteParam param) throws Exception {
		ErpFunCaseFavorite erpFunCaseFavorite = new ErpFunCaseFavorite();
		erpFunCaseFavorite.setFavoriteId(param.getFavoriteId());
		erpFunCaseFavorite.setFavoriteStatus((byte)0);
		erpFunCaseFavorite.setShardCityId(param.getCityId());
		erpFunCaseFavoriteMapper.updateByPrimaryKeySelective(erpFunCaseFavorite);
	}

	@Override
	public void sendMsgToFavoriteUser(Integer cityId, Integer compId, Integer selfArchiveId, Integer caseType, Integer caseId, 
			Byte trackType, ErpCreateTrackInfoParam param) {
		if(!Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) && !Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			return;// 只有房源才有收藏
		}
		List<Integer> favoriteList = erpFunCaseFavoriteMapper.getFavoriteList(cityId, compId, caseType, caseId);
		if(favoriteList == null || favoriteList.isEmpty()) {
			return;// 没有收藏人
		}
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		CaseInfoDto caseInfoDto = param.getCaseInfoDto();
		AdminFunUserMessage userMessage = adminFunUserMessageService.getUserMessage(caseInfoDto, caseType, false, 
				createAuditUser.getArchiveId(), createAuditUser.getUserName());
		if(userMessage == null) {
			return;
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, new HashSet<>(favoriteList));
		Map<Integer, Integer> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val.getArchiveId()));
		for (Integer favoriteUid : favoriteList) {
			Integer archiveId = userMap.get(favoriteUid);
			// 收藏人是自己不提醒
			if(selfArchiveId.equals(archiveId)) {
				continue;
			}
			String caseTypeStr = "客源";
			if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
				caseTypeStr = "房源";
			}
			userMessage.setArchiveId(archiveId);
			if (Const.DIC_TRACK_TYPE_STATUS_WRITEOFF.equals(trackType)) {
				userMessage.setModuleType(MsgModuleType.FAVORITE_HOUSE_CUST_WRITEOFF);
				userMessage.setMsgContent("您收藏的编号为" + userMessage.getCaseNo() + "的" + caseTypeStr + "被注销");
			} else if (Const.DIC_TRACK_TYPE_STATUS_OUTDEAL.equals(trackType)
					|| Const.DIC_TRACK_TYPE_STATUS_INNERDEAL.equals(trackType)) {
				userMessage.setModuleType(MsgModuleType.FAVORITE_HOUSE_CUST_DEAL);
				userMessage.setMsgContent("您收藏的编号为" + userMessage.getCaseNo() + "的" + caseTypeStr + "被成交");
			} else {
				continue;
			}
			TaskQueueThread.sendMessage(userMessage);
		}
		
	}

}

package com.myfun.service.business.admindb.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminCityshareBorkerComplaintMapper;
import com.myfun.repository.admindb.dao.AdminYouBorkerArchiveMapper;
import com.myfun.repository.admindb.po.AdminCityshareBorkerComplaint;
import com.myfun.repository.admindb.po.AdminYouBorkerArchive;
import com.myfun.repository.erpdb.dao.ErpCityshareComplaintProofMapper;
import com.myfun.repository.erpdb.dao.ErpCityshareHouseMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpCityshareComplaintProof;
import com.myfun.repository.erpdb.po.ErpCityshareHouse;
import com.myfun.repository.erpdb.po.ErpCityshareHouseExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCityshareBorkerComplaintService;
import com.myfun.service.business.admindb.bean.param.CityshareBorkerComplaintParam;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

@Service
public class AdminCityshareBorkerComplaintServiceImpl extends AbstractService<AdminCityshareBorkerComplaint, Integer> implements AdminCityshareBorkerComplaintService {

	@Autowired
	AdminCityshareBorkerComplaintMapper adminCityshareBorkerComplaintMapper;
	@Autowired
	AdminYouBorkerArchiveMapper adminYouBorkerArchiveMapper;
	@Autowired
	ErpCityshareComplaintProofMapper erpCityshareComplaintProofMapper;
	@Autowired
	ErpCityshareHouseMapper erpCityshareHouseMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminCityshareBorkerComplaintMapper;
	}

	/**
	 * 城市公盘写投诉
	 * @author 朱科
	 * @since 2018年4月9日
	 * @return
	 */
	@Transactional
	@Override
	public void addCityshareBorkerComplaint(Integer selfArchiveId, Integer selfUserId, Integer selfCompId,
			Integer selfDeptId, Integer cityId, CityshareBorkerComplaintParam param) {
		ErpCityshareHouse cityshareHouse = new ErpCityshareHouse();
		cityshareHouse.setSharehouseId(param.getSharehouseId());
		cityshareHouse.setShardCityId(cityId);
		cityshareHouse = erpCityshareHouseMapper.selectByPrimaryKey(cityshareHouse);
		if (cityshareHouse == null) {
			throw new BusinessException("分享的房源不存在");
		}
		// 这里的0用来判断 != ,1用来判断 = ;
		// dealStatus != 2 的查询
		List<AdminCityshareBorkerComplaint> dealStatusList = adminCityshareBorkerComplaintMapper.getDealStatusList(
				selfArchiveId, param.getTargetArchiveId(), cityshareHouse.getSharehouseId(), 2, 0,
				param.getCinfoType());
		if (null != dealStatusList && !dealStatusList.isEmpty()) {
			AdminCityshareBorkerComplaint adminCityshareBorkerComplaint = dealStatusList.get(0);
			if (0 == adminCityshareBorkerComplaint.getDealStatus()) {
				throw new BusinessException("投诉正在处理中，请等待投诉结果");
			}
			if (1 == adminCityshareBorkerComplaint.getDealStatus()) {
				throw new BusinessException("您已成功投诉过该信息");
			}
		}
		// dealStatus = 2 的查询
		List<AdminCityshareBorkerComplaint> complaintList = adminCityshareBorkerComplaintMapper.getDealStatusList(
				selfArchiveId, param.getTargetArchiveId(), cityshareHouse.getSharehouseId(), 2, 1,
				param.getCinfoType());
		if (null != complaintList && complaintList.size() >= 3) {
			throw new BusinessException("您对该信息投诉失败过3次，不能再次投诉");
		}
		// 隐号分享的数据查看过才能投诉
		if (Const.CITYSHARE_COOPERATION_TYPE_2.equals(cityshareHouse.getCooperationType())) {
			ErpCityshareHouseExample example = new ErpCityshareHouseExample();
			example.createCriteria().andSharehouseIdEqualTo(cityshareHouse.getSharehouseId())
					.andArchiveIdEqualTo(selfArchiveId).andCityIdEqualTo(cityId);
			example.setShardCityId(cityId);
			List<ErpCityshareHouse> cityshareHouseList = erpCityshareHouseMapper.selectByExample(example);
			if (null == cityshareHouseList || cityshareHouseList.size() <= 0) {
				throw new BusinessException("查看过该信息后才可以投诉");
			} else {
				ErpCityshareHouse erpCityshareHouse = cityshareHouseList.get(0);
				Date dateView = erpCityshareHouse.getCreationTime();
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.HOUR_OF_DAY, -24);
				if (DateTimeHelper.compareTwoDate(dateView, calendar.getTime()) == 1) {
					throw new BusinessException("查看时间已超过24小时，不能进行投诉");
				}
			}
		}
		AdminCityshareBorkerComplaint complaintInsert = new AdminCityshareBorkerComplaint();
		complaintInsert.setComplainTime(DateTimeHelper.getSystemDate());
		complaintInsert.setDealStatus(Const.DIC_TRUEHOUSE_DEAL_STATUS_0);
		Integer targetArchiveId = null;// 被投诉人的档案ID
		if (1 == param.getCinfoType()) {// 分享者投诉购买者
			// 被投诉人的信息
			ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getTargetUserId());
			complaintInsert.setTargetArchiveId(erpFunUsers.getArchiveId());
			complaintInsert.setTargetUserId(erpFunUsers.getUserId());
			complaintInsert.setTargetCompId(erpFunUsers.getCompId());
			complaintInsert.setTargetDeptId(erpFunUsers.getDeptId());
			// 投诉人的信息
			complaintInsert.setSourceUserId(selfUserId);
			complaintInsert.setSourceArchiveId(selfArchiveId);
			complaintInsert.setSourceCompId(selfCompId);
			complaintInsert.setSourceDeptId(selfDeptId);
			targetArchiveId = erpFunUsers.getArchiveId();
		} else if (0 == param.getCinfoType()) {
			// 被投诉人的信息
			complaintInsert.setTargetArchiveId(cityshareHouse.getArchiveId());
			complaintInsert.setTargetUserId(cityshareHouse.getUserId());
			complaintInsert.setTargetCompId(cityshareHouse.getCompId());
			complaintInsert.setTargetDeptId(cityshareHouse.getDeptId());
			// 投诉人的信息
			complaintInsert.setSourceUserId(selfUserId);
			complaintInsert.setSourceArchiveId(selfArchiveId);
			complaintInsert.setSourceCompId(selfCompId);
			complaintInsert.setSourceDeptId(selfDeptId);
			targetArchiveId = cityshareHouse.getArchiveId();
		}
		// 投诉的房源信息
		complaintInsert.setCityId(cityId);
		complaintInsert.setCaseNo(cityshareHouse.getCaseNo());
		complaintInsert.setCaseId(cityshareHouse.getCaseId());
		complaintInsert.setCaseType(cityshareHouse.getCaseType());
		complaintInsert.setSharehouseId(cityshareHouse.getSharehouseId());
		// 投诉类型等
		complaintInsert.setComplainType(param.getComplainType());
		complaintInsert.setCinfoType(param.getCinfoType());
		complaintInsert.setComplainContent(param.getComplainContent());
		complaintInsert.setCooperationType(cityshareHouse.getCooperationType());
		adminCityshareBorkerComplaintMapper.insertSelective(complaintInsert);
		// 把积分表的投诉次数+1
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(cityshareHouse.getCaseType().intValue())
				|| Const.DIC_CASE_TYPE_LEASE_FUN.equals(cityshareHouse.getCaseType().intValue())) {
			// 不存在时创建一个
			AdminYouBorkerArchive youBorkerArchivePO = adminYouBorkerArchiveMapper.selectByPrimaryKey(targetArchiveId);
			if (youBorkerArchivePO == null) {
				AdminYouBorkerArchive adminYouBorkerArchive = new AdminYouBorkerArchive();
				if (null != targetArchiveId) {
					adminYouBorkerArchive.setArchiveId(selfArchiveId);
				} else {
					adminYouBorkerArchive.setArchiveId(targetArchiveId);
				}
				adminYouBorkerArchive.setComplainCount(0);
				adminYouBorkerArchive.setYouAmount(new BigDecimal(0));
				adminYouBorkerArchive.setComplainSuccessCount(0);
				adminYouBorkerArchive.setCreationTime(new Date());
				adminYouBorkerArchiveMapper.insertSelective(adminYouBorkerArchive);
			}
			adminYouBorkerArchiveMapper.updateIncreaseComplainCount(targetArchiveId);
		}
		// 投诉关联的语音日志ID
		String[] logIdArr = param.getLogIds().trim().split(",");
		for (int j = 0; j < logIdArr.length; j++) {
			if (StringUtil.isBlank(logIdArr[j])) {
				continue;
			}
			ErpCityshareComplaintProof complaintProofPO = new ErpCityshareComplaintProof();
			complaintProofPO.setComplaintId(complaintInsert.getComplaintId());
			complaintProofPO.setVoipId(logIdArr[j]);
			complaintProofPO.setShardCityId(cityId);
			erpCityshareComplaintProofMapper.insertSelective(complaintProofPO);
		}
	}
}

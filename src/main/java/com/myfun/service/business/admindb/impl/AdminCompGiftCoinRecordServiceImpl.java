package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSONObject;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCompGiftCoinRecordService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.utils.KafkaBizUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminCompGiftCoinRecordServiceImpl extends AbstractService<AdminCompGiftCoinRecord, Integer>
		implements AdminCompGiftCoinRecordService {
	@Autowired
	private AdminCompGiftCoinRecordMapper adminCompGiftCoinRecordMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminFunPaidMapper adminFunPaidMapper;
	@Autowired
	private AdminFunArchiveService adminFunArchiveService;
	

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminCompGiftCoinRecordMapper;
	}

	@Override
	public void giftCompCoin(Integer archiveId) {
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.createCriteria().andArchiveIdEqualTo(archiveId).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardArchiveId(archiveId);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		ErpFunUsers erpFunUsers = userList.get(0);
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setDeptId(erpFunUsers.getDeptId());
		erpFunDepts.setShardCityId(erpFunUsers.getCityId().intValue());
		erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(erpFunDepts);
		String compNo = erpFunDepts.getCompNo();
		String deptNo = erpFunDepts.getDeptNo();
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		Byte compType = adminFunComp.getCompType();
		// 如果是不是营销版就返回
		if (compType != Const.DIC_COMP_TYPE_4.byteValue()) {
			return;
		}
		// 判断赠送了没有
		AdminCompGiftCoinRecordExample adminCompGiftCoinRecordExample = new AdminCompGiftCoinRecordExample();
		adminCompGiftCoinRecordExample.createCriteria().andCompNoEqualTo(compNo).andDeptNoEqualTo(deptNo);
		int count = adminCompGiftCoinRecordMapper.countByExample(adminCompGiftCoinRecordExample);
		if (count > 0) {
			return;
		}
		// 赠送好房豆
		Integer giftQuan = Const.GIFT_COIN;
		// 实名达到多少人送好房豆
		Integer rightCount = 3;

		List<Integer> archiveList = new ArrayList<>();
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.createCriteria().andDeptIdEqualTo(erpFunUsers.getDeptId()).andUserWriteoffEqualTo(false);
		usersExample.setShardCityId(erpFunUsers.getCityId().intValue());
		List<ErpFunUsers> erpUserList = erpFunUsersMapper.selectByExample(usersExample);
		for (ErpFunUsers funUsers : erpUserList) {
			archiveList.add(funUsers.getArchiveId());
		}
		List<Integer> isRightArchiveList = new ArrayList<>();// 已实名的人
		List<Integer> notRightArchiveList = new ArrayList<>();// 未实名的人
		StringBuilder archiveIds = new StringBuilder();
		AdminFunArchiveExample adminFunArchiveExample = new AdminFunArchiveExample();
		adminFunArchiveExample.createCriteria().andArchiveIdIn(archiveList);
		List<AdminFunArchive> list = adminFunArchiveMapper.selectByExample(adminFunArchiveExample);
		for (int i = 0; i < list.size(); i++) {
			AdminFunArchive adminFunArchive = list.get(i);
			if (adminFunArchive.getUserRight() == 1) {
				archiveIds.append(adminFunArchive.getArchiveId() + ",");
				isRightArchiveList.add(adminFunArchive.getArchiveId());
			} else {
				notRightArchiveList.add(adminFunArchive.getArchiveId());
			}
		}
		// 如果没达到要求就返回 总数不到3人
		if (isRightArchiveList.size() < rightCount) {
			String hfdAlias = adminFunArchiveService.getHfdAliasInPushMessage(archiveId);
			// 推送消息给未实名的
			for (Integer notRightArchiveId : notRightArchiveList) {
				//推送消息
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("templateId", "37");
				jsonObject.put("title", "实名认证送" + hfdAlias);
				jsonObject.put("receiver", notRightArchiveId);
				jsonObject.put("content", "门店实名认证人数已达" + isRightArchiveList.size() + "人，还差"
						+ (rightCount - isRightArchiveList.size()) + "人实名通过公司即可获赠" + giftQuan + hfdAlias);
				KafkaBizUtils.pushMsgByTemplate(jsonObject);
			}
			return;
		}
		Integer uaId = adminFunComp.getUaId();
		if (uaId == null) {
			return;
		}
		AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);

		adminFunUserAccountMapper.updateGift4HfAmount(giftQuan, uaId);
		// 写消费记录
		AdminFunPaid adminFunPaid = new AdminFunPaid();
		adminFunPaid.setAmount(giftQuan.doubleValue());
		adminFunPaid.setAmountAfter(adminFunUserAccount.getHaofangAmount().doubleValue() + giftQuan);
		adminFunPaid.setAmountBefore(adminFunUserAccount.getHaofangAmount().doubleValue());
		adminFunPaid.setAmountQuan(giftQuan.doubleValue());
		adminFunPaid.setArchiveId(adminFunComp.getGeneralArchive());
		adminFunPaid.setCityId(adminFunComp.getCityId().shortValue());
		adminFunPaid.setDesc("门店实名认证已达3人，赠送" + Const.GIFT_COIN + "公司好房豆");
		adminFunPaid.setPadiTime(new Date());
		adminFunPaid.setPaidCatigory("GIFT");
		adminFunPaid.setPaidType("GIFT_COMP_QUAN");
		adminFunPaid.setUaId(uaId);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByDeptNoAndCompNo(deptNo, compNo);
		if(null != adminFunDepts && null != erpFunUsers.getUserEdition() && 2!=erpFunUsers.getUserEdition()) {
			adminFunPaid.setDeptId(adminFunDepts.getDeptId());
		}
		adminFunPaidMapper.insertSelective(adminFunPaid);
		// 写赠送表

		AdminCompGiftCoinRecord adminCompGiftCoinRecord = new AdminCompGiftCoinRecord();
		adminCompGiftCoinRecord.setArchiveIds(archiveIds.toString());
		adminCompGiftCoinRecord.setCompNo(compNo);
		adminCompGiftCoinRecord.setCreationTime(new Date());
		adminCompGiftCoinRecord.setDeptId(adminFunDepts.getDeptId());
		adminCompGiftCoinRecord.setDeptNo(deptNo);
		adminCompGiftCoinRecord.setGiftAmount(giftQuan);
		adminCompGiftCoinRecordMapper.insertSelective(adminCompGiftCoinRecord);
	}

	@Override
	public String getAlterMsg(Integer compType, String compNo, String deptNo) {
		if (compType == null || compType != Const.DIC_COMP_TYPE_4) {
			return "";
		}
		AdminCompGiftCoinRecordExample adminCompGiftCoinRecordExample = new AdminCompGiftCoinRecordExample();
		adminCompGiftCoinRecordExample.createCriteria().andCompNoEqualTo(compNo).andDeptNoEqualTo(deptNo);
		int count = adminCompGiftCoinRecordMapper.countByExample(adminCompGiftCoinRecordExample);
		if (count > 0) {
			return "";
		}
		Integer giftQuan = Const.GIFT_COIN;
//		return "门店实名用户达到3人还可获赠" + giftQuan + "公司好房豆哦。";
		return "";
	}
}
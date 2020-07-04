package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.erpWeb.bulletin.param.BulletinListParam;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminBulletMapper;
import com.myfun.repository.admindb.dao.AdminBulletReplyMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUsersCountMapper;
import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.param.AdminBulletReplyParam;
import com.myfun.repository.admindb.po.AdminBullet;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.erpdb.dao.ErpBroadcastMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.param.ReqBulletinHouseListParam;
import com.myfun.repository.erpdb.po.ErpBroadcast;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.condition.Condition;
import com.myfun.repository.support.mybatis.condition.ConditionItem;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminBulletService;
import com.myfun.service.business.admindb.AdminFunUsersCountService;
import com.myfun.service.business.erpdb.ErpFunPhotoService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

/**
 * 公告管理
 * 
 * @author lcb
 *
 */
@Service
public class AdminBulletServiceImpl extends AbstractService<AdminBullet, Integer>implements AdminBulletService {
	Logger logger = LoggerFactory.getLogger(AdminBulletServiceImpl.class);

	@Autowired private AdminBulletMapper adminBulletMapper;
	@Autowired private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired private ErpBroadcastMapper erpBroadcastMapper;
	@Autowired private AdminFunUsersCountService adminFunUsersCountService;
	@Autowired private AdminFunUsersCountMapper adminFunUsersCountMapper;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private AdminBulletReplyMapper adminBulletReplyMapper;
	@Autowired private ErpFunPhotoService erpFunPhotoService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminBulletMapper;
	}

	/**
	 * @Title: enclosing_method 
	 * @Description: 公告管理
	 * @param tags
	 * @return return_type    返回类型  @throws 
	 * @author lcb
	 */
	@Override
	public PageInfo<AdminBulletDto> getBulletList(BulletinListParam param, Operator operator) {
		// 
		param.setYouCompFlag(operator.getYouCompFlag());
		param.setCompAttr(operator.getCompAttr());
		param.setTopJoinComp(operator.getTopJoinCircleCompId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getAdminCompId());
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		param.setPartnerId(operator.getPartnerId());
		param.setOpenPartner(operator.openPartner());
		System.out.println(param.getPageOffset());
		System.out.println(param.getPageRows());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		return new PageInfo<AdminBulletDto>(adminBulletMapper.getBulletList(param));
	}

	@Override
	public void addClick(Integer bulletId) {
		adminBulletMapper.addClick(bulletId);
	}

	@Override
	public AdminBulletDto getBulletinInfo(String bulletId) {
		AdminBulletDto adminBullet = adminBulletMapper.getBulletByBulletId(Integer.valueOf(bulletId));
		// 组装数据
		AdminFunArchive archivePO = adminFunArchiveMapper.selectByPrimaryKey(adminBullet.getArchiveId());
		AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByPrimaryKey(adminBullet.getDeptId());
		if(adminFunDeptsPO == null){
			adminBullet.setDeptName("网络经纪人");
		}else {
			adminBullet.setDeptName(adminFunDeptsPO.getDeptName());
		}
		if(archivePO != null){
			adminBullet.setUserMobile(archivePO.getUserMobile());
			adminBullet.setUserName(archivePO.getUserName());
			adminBullet.setUserPhotoMin(CommonUtil.getBbsPhoto(archivePO.getUserPhoto()));
			adminBullet.setBbsName(archivePO.getNickName());
			adminBullet.setRealPhoto(archivePO.getUserPhotoMin());
		}
		return adminBullet;
	}
	
	@Override
	public PageInfo<ErpFunLease> getFunLeaseByBulletin(ReqBulletinHouseListParam param){
		Condition condition = new Condition();
		if (StringUtils.isNotEmpty(param.getAreaText()) && !"-全部".equals(param.getAreaText())) {
			String areas[] = param.getAreaText().split("-");
			if (areas.length > 1) {
				param.setCaseAreas1(areas[0]);
				param.setCaseAreas2(areas[1]);
			}
		}
		if (StringUtils.isNotEmpty(param.getRoomText()) && !"-全部".equals(param.getRoomText())) {
			String rooms[] = param.getRoomText().split("-");
			if (rooms.length > 1) {
				param.setCaseRooms1(rooms[0]);
				param.setCaseRooms2(rooms[1]);
			}
		}
		condition.add(new ConditionItem("USER_ID", "=", param.getUserId()));
		condition.add(new ConditionItem("LEASE_STATUS", "<=", Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE));
		if (StringUtils.isNotEmpty(param.getRegionText())) {
			param.setRegionNames(param.getRegionText().split(" "));
		}
		if (StringUtils.isNotEmpty(param.getBuildIdText())) {
			param.setBuildNames(param.getBuildIdText().split(" "));
		}
		// 查询数据
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunLease> resultList = erpFunLeaseMapper.getBulletinHouseList(param);
		Set<Integer> houseIds = new HashSet<Integer>();
		for(int i=0; i< resultList.size(); i++){
			houseIds.add(resultList.get(i).getLeaseId());
		}
		Map<Integer, String> housePicMap = getHousePicMap(param.getCompId(), param.getCityId(), Const.DIC_CASE_TYPE_LEASE_FUN, houseIds);
		for(int i=0; i< resultList.size(); i++){
			ErpFunLease dataObject = resultList.get(i);
			dataObject.setThumbUrl(housePicMap.get(dataObject.getLeaseId()));//PHOTO_ADDRESS
		}
		PageInfo<ErpFunLease> pageInfo = new PageInfo<ErpFunLease>(resultList);
		return pageInfo;
	}

	@Override
	public PageInfo<ErpFunSale> getFunSaleByBulletin(ReqBulletinHouseListParam param){
		if (StringUtils.isNotEmpty(param.getAreaText()) && !"-全部".equals(param.getAreaText())) {
			String areas[] = param.getAreaText().split("-");
			if (areas.length > 1) {
				param.setCaseAreas1(areas[0]);
				param.setCaseAreas2(areas[1]);
			}
		}
		if (StringUtils.isNotEmpty(param.getRoomText()) && !"-全部".equals(param.getRoomText())) {
			String rooms[] = param.getRoomText().split("-");
			if (rooms.length > 1) {
				param.setCaseRooms1(rooms[0]);
				param.setCaseRooms2(rooms[1]);
			}
		}
		if (StringUtils.isNotEmpty(param.getRegionText())) {
			param.setRegionNames(param.getRegionText().split(" "));
		}
		if (StringUtils.isNotEmpty(param.getBuildIdText())) {
			param.setBuildNames(param.getBuildIdText().split(" "));
		}
		// 查询数据
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunSale> resultList = erpFunSaleMapper.getBulletinHouseList(param);
		Set<Integer> houseIds = new HashSet<Integer>();
		for(int i=0; i< resultList.size(); i++){
			houseIds.add(resultList.get(i).getSaleId());
		}
		Map<Integer, String> housePicMap = getHousePicMap(param.getCompId(), param.getCityId(), Const.DIC_CASE_TYPE_SALE_FUN, houseIds);
		for(int i=0; i< resultList.size(); i++){
			ErpFunSale dataObject = resultList.get(i);
			dataObject.setThumbUrl(housePicMap.get(dataObject.getSaleId()));//PHOTO_ADDRESS
		}
		PageInfo<ErpFunSale> pageInfo = new PageInfo<ErpFunSale>(resultList);
		return pageInfo;
	}
	
	private Map<Integer, String> getHousePicMap(Integer compId, Integer cityId, Integer caseType, Set<Integer> houseIds) {
		Map<Integer, String> housePicMap = new HashMap<Integer, String>();
		List<ErpFunPhotoDto> photoPOs = erpFunPhotoService.getPhotoList(compId, cityId, caseType, houseIds.toArray(new Integer[houseIds.size()]));
		//组装房源图片
		if(photoPOs != null && !photoPOs.isEmpty()){
			for(int i=0; i<photoPOs.size(); i++){
				ErpFunPhoto funPhotoPO = photoPOs.get(i);
				String pics = housePicMap.get(funPhotoPO.getCaseId());
				if(StringUtils.isEmpty(pics)){
					pics=funPhotoPO.getPhotoAddr().replaceAll("\\\\", "/") + ";";
				}else{
					pics += funPhotoPO.getPhotoAddr().replaceAll("\\\\", "/") + ";";
				}
				housePicMap.put(funPhotoPO.getCaseId(), pics);
			}
		}
		return housePicMap;
	}

	@Transactional
	@Override
	public void addBulletReply(AdminBulletReplyParam param) {
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		param.setEditTime(timeNow);
		param.setCreationTime(timeNow);
		adminBulletReplyMapper.insertSelective(param);
		// 增加回复数
		adminBulletMapper.updateReplyCount(param.getBulletId());
		try {
			// 通知发帖人
			ErpBroadcast record = new ErpBroadcast();
			record.setArchiveId(param.getArchiveId());
			record.setCreateTime(timeNow);
			record.setBound(param.getBulletBound());
			record.setBulletId(param.getBulletId());
			record.setUserId(param.getUserId());
			record.setShardCityId(param.getCityId());
			record.setBcType((param.getUseReplyId() == null) ? 3 : 5);
			erpBroadcastMapper.insertSelective(record);
		} catch (Exception e) {
			logger.error("主键重复了，不管他，谁设计的表不允许重复通知");
		}
		// 增加积分啥的
		adminFunUsersCountService.addScore(param.getArchiveId(), 14, 1.0);
	}
}



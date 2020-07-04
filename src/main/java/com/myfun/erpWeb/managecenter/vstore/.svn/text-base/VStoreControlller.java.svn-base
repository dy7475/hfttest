package com.myfun.erpWeb.managecenter.vstore;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.vstore.param.GetEmployeeDynamicsListParam;
import com.myfun.erpWeb.managecenter.vstore.param.GetVStoreEntrustListParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.agencydb.dao.AgencyVipBuyMapper;
import com.myfun.repository.agencydb.dao.AgencyVipLeaseMapper;
import com.myfun.repository.agencydb.dao.AgencyVipRentMapper;
import com.myfun.repository.agencydb.dao.AgencyVipSaleMapper;
import com.myfun.repository.agencydb.dao.AgencyWfArchiveTotalMapper;
import com.myfun.repository.agencydb.dao.AgencyWfCompleteEvaMapper;
import com.myfun.repository.agencydb.dao.AgencyWfPushLogMapper;
import com.myfun.repository.agencydb.dao.AgencyWfRecomHouseEvaMapper;
import com.myfun.repository.agencydb.dao.AgencyWfRecomHouseMapper;
import com.myfun.repository.agencydb.dao.AgencyWfServiceSettingMapper;
import com.myfun.repository.agencydb.dao.AgencyWfUserMapper;
import com.myfun.repository.agencydb.dto.AgencyVipLeaseDto;
import com.myfun.repository.agencydb.dto.AgencyVipSaleDto;
import com.myfun.repository.agencydb.dto.AgencyWfCompleteEvaDto;
import com.myfun.repository.agencydb.dto.AgencyWfPushLogDto;
import com.myfun.repository.agencydb.dto.AgencyWfRecomHouseDto;
import com.myfun.repository.agencydb.dto.AgencyWfRecomHouseEvaDto;
import com.myfun.repository.agencydb.po.AgencyVipBuy;
import com.myfun.repository.agencydb.po.AgencyVipRent;
import com.myfun.repository.agencydb.po.AgencyWfArchiveTotal;
import com.myfun.repository.agencydb.po.AgencyWfPushLog;
import com.myfun.repository.agencydb.po.AgencyWfRecomHouse;
import com.myfun.repository.agencydb.po.AgencyWfServiceSetting;
import com.myfun.repository.agencydb.po.AgencyWfUser;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.agencydb.AgencyWfServiceSettingService;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;

@RestController
@RequestMapping("/manageCenter/vStore")
public class VStoreControlller extends BaseController {

	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AgencyWfPushLogMapper agencyWfPushLogMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private AgencyWfServiceSettingService agencyWfServiceSettingService;
	@Autowired
	private AgencyWfServiceSettingMapper agencyWfServiceSettingMapper;
	@Autowired
	private AgencyWfUserMapper agencyWfUserMapper;
	@Autowired
	private AgencyWfRecomHouseMapper agencyWfRecomHouseMapper;
	@Autowired
	private AgencyVipSaleMapper agencyVipSaleMapper;
	@Autowired
	private AgencyVipLeaseMapper agencyVipLeaseMapper;
	@Autowired
	private AgencyVipBuyMapper agencyVipBuyMapper;
	@Autowired
	private AgencyVipRentMapper agencyVipRentMapper;
	@Autowired
	private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	private AgencyWfCompleteEvaMapper agencyWfCompleteEvaMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private AgencyWfArchiveTotalMapper agencyWfArchiveTotalMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AgencyWfRecomHouseEvaMapper agencyWfRecomHouseEvaMapper;

	/**
	 * 获取委托列表
	 * 
	 * @author 何传强
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getVStoreEntrustList")
	public ResponseJson getVStoreEntrustList(@RequestBody GetVStoreEntrustListParam param) throws Exception {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());

		param.setNewOrganization(getOperator().newOrganizationType());
		String serchRange = param.getSerchRange();
		Integer caseType = param.getCaseType();// 委托类型
		Integer wtStatus = param.getWtStatus();// 委托状态
		if (wtStatus != null) {
			if (wtStatus == 1 && caseType != null) {
				if (caseType == 1 || caseType == 2) {// 出售和出租
					param.setWtStatus(10);
				} else if (caseType == 3 || caseType == 4) {// 求租和求购
					param.setWtStatus(4);
				}
			} else if (wtStatus == 0) {
				param.setWtStatus(null);
				param.setRequireStatus(0);
			}
		}
		if ("GROUP".equals(serchRange)) {
			param.setSerchRange("GR");
		}
		String startTime = param.getStartTime();
		if (StringUtil.isNotBlank(startTime)) {
			param.setStartTime(startTime + " 00:00:00");
		}
		String endTime = param.getEndTime();
		if (StringUtil.isNotBlank(endTime)) {
			param.setEndTime(endTime + " 23:59:59");
		}
		if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
			param.setOrganizationId(null);
		}
		Set<Integer> archiveIds = new HashSet<>();
		Set<Integer> pushLogIds = new HashSet<>();
		Set<Integer> wxIds = new HashSet<>();
		// 获取委托记录列表
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyWfPushLogDto> wfPushLogList = agencyWfPushLogMapper.getWfPushLogList(param);
		PageInfo<AgencyWfPushLogDto> pageInfo = new PageInfo<>(wfPushLogList);
		if (wfPushLogList.size() <= 0) {
			return ErpResponseJson.ok();
		}
		for (AgencyWfPushLogDto agencyWfPushLogDto : wfPushLogList) {
			archiveIds.add(agencyWfPushLogDto.getArchiveId());
			pushLogIds.add(agencyWfPushLogDto.getId());
			wxIds.add(agencyWfPushLogDto.getWxId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date createTime = agencyWfPushLogDto.getCreateTime();
			String format = sdf.format(createTime);
			agencyWfPushLogDto.setWtTime(format);
			agencyWfPushLogDto.setWtStatus(String.valueOf(agencyWfPushLogDto.getPushStatus()));
			;
			agencyWfPushLogDto.setDkCount(
					agencyWfPushLogDto.getDaikanCount() > 0 ? String.valueOf(agencyWfPushLogDto.getDaikanCount())
							: "-");
		}
		if (archiveIds.size() > 0) {// 经纪人查询
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByArchiveIds(getOperator().getCityId(),
					archiveIds);
			Set<Integer> deptIdSet = userList.stream()
					.collect(Collectors.mapping(ErpFunUsers::getDeptId, Collectors.toSet()));
			Map<Integer, ErpFunUsers> userMap = userList.stream()
					.collect(Collectors.toMap(ErpFunUsers::getArchiveId, user -> user));
			// 获取门店列表
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(getOperator().getCityId(), deptIdSet);
			Map<Integer, ErpFunDepts> deptMap = deptList.stream()
					.collect(Collectors.toMap(ErpFunDepts::getDeptId, dept -> dept));
			for (AgencyWfPushLogDto agencyWfPushLogDto : wfPushLogList) {
				ErpFunUsers erpFunUsers = userMap.get(agencyWfPushLogDto.getArchiveId());
				if (erpFunUsers != null) {
					agencyWfPushLogDto.setUserName(erpFunUsers.getUserName());
					agencyWfPushLogDto.setJjrUserId(erpFunUsers.getUserId());
					agencyWfPushLogDto.setUserAreaId(erpFunUsers.getAreaId());
					agencyWfPushLogDto.setUserRegId(erpFunUsers.getRegId());
					agencyWfPushLogDto.setUserDeptId(erpFunUsers.getDeptId());
					agencyWfPushLogDto.setUserGrId(erpFunUsers.getGrId());
					agencyWfPushLogDto.setUserCompId(erpFunUsers.getCompId());
				} else {
					agencyWfPushLogDto.setUserName("");
				}
				ErpFunDepts deptInfo = deptMap.get(erpFunUsers.getDeptId());
				if (deptInfo != null) {
					agencyWfPushLogDto.setDeptName(deptInfo.getDeptName());
				}
			}
		}
		if (wxIds.size() > 0) {
			// 查询客户信息
			List<AgencyWfUser> wfUserList = agencyWfUserMapper.getWfUserListByCaseIds(wxIds);
			Map<Integer, AgencyWfUser> wfUserMap = wfUserList.stream()
					.collect(Collectors.toMap(AgencyWfUser::getWxId, wfUser -> wfUser));
			for (AgencyWfPushLogDto agencyWfPushLogDto : wfPushLogList) {
				AgencyWfUser wfUser = wfUserMap.get(agencyWfPushLogDto.getWxId());
				if (wfUser != null) {
					agencyWfPushLogDto.setCustomerName(wfUser.getWxNickname());
					agencyWfPushLogDto.setCustomerPhone(wfUser.getWeidianMobile());
				} else {
					agencyWfPushLogDto.setCustomerName("");
					agencyWfPushLogDto.setCustomerPhone("");
				}
				String customerName = agencyWfPushLogDto.getCustomerName();
				if (StringUtil.isNotBlank(customerName)) {
					agencyWfPushLogDto.setIsUpload("1");// 已上传
				} else {
					agencyWfPushLogDto.setIsUpload("0");// 未上传
				}
			}
			// 佣金金额和保留意向
			List<AgencyWfRecomHouseDto> wfRecomHouseList = agencyWfRecomHouseMapper
					.getWfRecomHouseListByPushLogIds(caseType, pushLogIds);
			Map<Integer, AgencyWfRecomHouseDto> wfRecomHouseMap = wfRecomHouseList.stream()
					.collect(Collectors.toMap(AgencyWfRecomHouse::getPushLogId, wfRecomHouse -> wfRecomHouse));
			for (AgencyWfPushLogDto agencyWfPushLogDto : wfPushLogList) {
				AgencyWfRecomHouseDto wfRecomHouse = wfRecomHouseMap.get(agencyWfPushLogDto.getId());
				if (wfRecomHouse != null) {
					// 如果委托状态为成交,才显示佣金金额（查询的时候就带了成交条件的）
					if (wfRecomHouse.getBrokerMoney() != null && wfRecomHouse.getBrokerMoney() > 0) {
						agencyWfPushLogDto.setYjCount(String.valueOf(wfRecomHouse.getBrokerMoney()));
					} else {
						agencyWfPushLogDto.setYjCount("-");
					}
					agencyWfPushLogDto.setBlCount(String.valueOf(wfRecomHouse.getBlCount()));
				} else {
					agencyWfPushLogDto.setBlCount("-");
					agencyWfPushLogDto.setYjCount("-");
				}
			}
		}
		return ErpResponseJson.ok(pageInfo);
	}

	
	/**
	 * 获取详细信息(出租caseType=2,出售caseType=1)
	 * 
	 * @author 何传强
	 * @since 2017年8月18日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSaleOrLeaseDetaile")
	public ResponseJson getSaleOrLeaseDetaile(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		Integer caseType = param.getInteger("caseType");
		Integer pushLogId = param.getInteger("pushLogId");
		String caseId = param.getString("caseId");
		Integer cityIdInt = getOperator().getCityId();
		String cityId = String.valueOf(cityIdInt);
		Assert.isNullThrow(pushLogId, "该功能已经优化，请升级到新版后使用！");
		AgencyWfPushLog wfPushLog = agencyWfPushLogMapper.selectByPrimaryKey(pushLogId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (caseType == 1) {// 出售
			String saleId = "";
			AgencyVipSaleDto vipSaleDetail = agencyVipSaleMapper.getVipSaleInfo(caseId, cityId);
			if (vipSaleDetail != null) {
				saleId = String.valueOf(vipSaleDetail.getSaleId());// 需求ID
				if (StringUtil.isNotBlank(saleId)) {
					param.setString("saleId", saleId);
				}
				if (wfPushLog != null && wfPushLog.getFangkanTime() != null) {
					vipSaleDetail.setFkTime(sdf.format(wfPushLog.getFangkanTime()));
				}
				// 成交时间
				AgencyWfRecomHouse wfRecomHouse = agencyWfRecomHouseMapper.getWfRecomHouseInfoByCaseId(caseId,
						caseType);
				if (wfRecomHouse != null) {
					if (wfRecomHouse.getHouseMoney() != null) {
						vipSaleDetail.setHouseMoney(String.valueOf(wfRecomHouse.getHouseMoney()));
					}
					if (wfRecomHouse.getActTime() != null) {
						vipSaleDetail.setCjTime(sdf.format(wfRecomHouse.getActTime()));
					}
				}
				List<ErpFunPhoto> funPhotoList = erpFunPhotoMapper.getHousePhotoByCaseId(getOperator().getCityId(),
						param.getMap());
				if (funPhotoList.size() > 0) {
					vipSaleDetail.setPhotoCount(String.valueOf(funPhotoList.size()));
					String photoAddr = funPhotoList.get(0).getPhotoAddr();
					if (photoAddr != null && !"".equals(photoAddr)) {
						vipSaleDetail.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
					}
				}
				return new ErpResponseJson(vipSaleDetail);
			}
		}
		if (caseType == 2) {// 出租
			AgencyVipLeaseDto vipLease = agencyVipLeaseMapper.getvipLeaseDetail(caseId, cityId);
			if (vipLease != null) {
				String leasId = String.valueOf(vipLease.getLeaseId());// 需求ID
				if (StringUtil.isNotBlank(leasId)) {
					param.setString("leasId", leasId);
				}
				if (wfPushLog != null && wfPushLog.getFangkanTime() != null) {
					vipLease.setFkTime(sdf.format(wfPushLog.getFangkanTime()));
				}
				AgencyWfRecomHouse wfRecomHouse = agencyWfRecomHouseMapper.getWfRecomHouseInfoByCaseId(caseId,
						caseType);
				if (wfRecomHouse != null) {
					if (wfRecomHouse.getHouseMoney() != null) {
						vipLease.setHouseMoney(String.valueOf(wfRecomHouse.getHouseMoney()));
					}
					if (wfRecomHouse.getActTime() != null) {
						vipLease.setCjTime(sdf.format(wfRecomHouse.getActTime()));// 成交时间
					}
				}
				List<ErpFunPhoto> funPhotoList = erpFunPhotoMapper.getHousePhotoByCaseId(getOperator().getCityId(),
						param.getMap());
				if (funPhotoList.size() > 0) {
					vipLease.setPhotoCount(String.valueOf(funPhotoList.size()));
					String photoAddr = funPhotoList.get(0).getPhotoAddr();
					if (photoAddr != null && !"".equals(photoAddr)) {
						vipLease.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
					}
				}
				return ErpResponseJson.ok(vipLease);
			}
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 获取详细信息(求租,求购)
	 * 
	 * @author 何传强
	 * @since 2017年8月18日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBuyOrRentDetaile")
	public ResponseJson getBuyOrRentDetaile(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("compId", getOperator().getCompId());
		Integer caseType = param.getInteger("caseType");
		String caseId = param.getString("caseId");
		Integer pushLogId = param.getInteger("pushLogId");
		Assert.isNullThrow(pushLogId, "该功能已经优化，请升级到新版后使用！");
		Map<String, Object> resultMap = new HashMap<>();
		Map<String, Object> baseMap = new HashMap<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AgencyWfPushLog agencyWfPushLog = agencyWfPushLogMapper.selectByPrimaryKey(pushLogId);
		if (caseType == 3) {// 求购
			String buyId = "";
			AgencyVipBuy vipBuy = agencyVipBuyMapper.getVipBuyInfoByCaseId(getOperator().getCityId(), caseId);
			if (vipBuy != null) {
				baseMap.put("regionName", vipBuy.getRegionName());// 期望区域
				baseMap.put("room", vipBuy.getRoomH());// 期望户型
				baseMap.put("houseUseage", vipBuy.getHouseUseage());// 用途
				baseMap.put("priceL", vipBuy.getPriceL());// 最低价格
				baseMap.put("priceH", vipBuy.getPriceH());// 最高价格
				buyId = String.valueOf(vipBuy.getBuyId());
				if (StringUtil.isNotBlank(buyId)) {
					param.setString("buyId", buyId);
				}
				baseMap.put("buyId", buyId);
				AgencyWfRecomHouse wfRecomHouseInfo = agencyWfRecomHouseMapper
						.getWfRecomHouseTimeForCust(getOperator().getCityId(), pushLogId);
				if (wfRecomHouseInfo != null) {
					if (wfRecomHouseInfo.getReceiveTime() != null) {
						baseMap.put("dkTime", sdf.format(wfRecomHouseInfo.getReceiveTime()));// 带看时间
					}
					if (wfRecomHouseInfo.getEvaTime() != null) {
						baseMap.put("pjTime", sdf.format(wfRecomHouseInfo.getEvaTime()));// 评价时间
					}
					if (wfRecomHouseInfo.getActTime() != null) {
						baseMap.put("cjTime", sdf.format(wfRecomHouseInfo.getActTime()));// 成交时间
					}
				}
			}
			resultMap.put("baseInfo", baseMap);
			// 根据需求Id获取到主键ID
			if (agencyWfPushLog != null) {
				// 根据主键ID一对多查询WF_RECOM_HOUSE,获取房源ID
				List<AgencyWfRecomHouseDto> wfRecomHouseList = agencyWfRecomHouseMapper
						.getWfRecomHouseByPushLogId(getOperator().getCityId(), pushLogId);
				// 查询已看房源
				for (AgencyWfRecomHouseDto agencyWfRecomHouse : wfRecomHouseList) {
					Integer houseId = agencyWfRecomHouse.getCaseId();
					ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(getOperator().getCityId(), houseId);
					if (funSale != null) {
						agencyWfRecomHouse.setBuildName(funSale.getBuildName());// 楼盘名称
						agencyWfRecomHouse.setHouseUseAge(String.valueOf(funSale.getSaleUseage()));// 房屋用途
						agencyWfRecomHouse.setHouseRoom(String.valueOf(funSale.getSaleRoom()));// 几室
						agencyWfRecomHouse.setHouseHall(String.valueOf(funSale.getSaleHall()));// 几厅
						agencyWfRecomHouse.setHouseWei(String.valueOf(funSale.getSaleWei()));// 几卫
						agencyWfRecomHouse.setHouseArea(String.valueOf(funSale.getSaleArea()));// 面积
						agencyWfRecomHouse.setHouseFitment(String.valueOf(funSale.getSaleFitment()));// 装修情况
						agencyWfRecomHouse.setHouseFloor(String.valueOf(funSale.getSaleFloor()));// 当前楼层
						agencyWfRecomHouse.setHouseFloors(String.valueOf(funSale.getSaleFloors()));// 总楼层
						agencyWfRecomHouse.setIsTrue(funSale.getTrueFlag() == 1 ? "1" : "0");// 1=真房源
					}
					agencyWfRecomHouse.setIsDeal(agencyWfRecomHouse.getSeeStatus() == 4 ? "1" : "0");// 1=已成交
					agencyWfRecomHouse.setBlStatus(agencyWfRecomHouse.getDelStatus() == 0 ? "0" : "1");// 0=保留意向,1=不再考虑
					if (agencyWfRecomHouse.getHouseMoney() != null) {
						agencyWfRecomHouse.setPrice(String.valueOf(agencyWfRecomHouse.getHouseMoney()));// 业主标价
					}
					param.setInteger("houseId", houseId);
					param.setInteger("caseType", Const.DIC_CASE_TYPE_SALE_FUN);
					List<ErpFunPhoto> funPhotoList = erpFunPhotoMapper.getHousePhotoByCaseId(getOperator().getCityId(),
							param.getMap());
					param.setInteger("caseType", caseType);
					if (funPhotoList.size() > 0) {
						agencyWfRecomHouse.setPhotoCount(String.valueOf(funPhotoList.size()));// 图片总量
						agencyWfRecomHouse.setPhotoAddr(CommonUtil.getHousePhoto(funPhotoList.get(0).getPhotoAddr()));// 首图地址
					}
					// 根据archiveId到WF_ARCHIVE_TOTAL 表中查询评价
					Integer archiveId = agencyWfRecomHouse.getArchiveId();
					AgencyWfArchiveTotal wfArchiveTotal = agencyWfArchiveTotalMapper
							.getWfArchiveTotalByArchiveId(archiveId);
					agencyWfRecomHouse.setPraiseNum(String.valueOf(wfArchiveTotal.getPraiseNum()));// 好评数
					agencyWfRecomHouse.setRentId(String.valueOf(houseId));// 房源ID
				}
				resultMap.put("ykHouseList", wfRecomHouseList);
			}
		} else if (caseType == 4) {// 求租
			AgencyVipRent vipRent = agencyVipRentMapper.getVipBuyInfoByCaseId(getOperator().getCityId(), caseId);
			String rentId = "";
			if (vipRent != null) {
				baseMap.put("regionName", vipRent.getRegionName());// 期望区域
				baseMap.put("room", vipRent.getRoomH());// 期望户型
				baseMap.put("houseUseage", vipRent.getHouseUseage());// 用途
				baseMap.put("priceL", vipRent.getPriceL());// 最低价格
				baseMap.put("priceH", vipRent.getPriceH());// 最高价格
				rentId = String.valueOf(vipRent.getRentId());
				if (StringUtil.isNotBlank(rentId)) {
					param.setString("rentId", rentId);
				}
				baseMap.put("rentId", rentId);
				AgencyWfRecomHouse wfRecomHouseInfo = agencyWfRecomHouseMapper
						.getWfRecomHouseTimeForCust(getOperator().getCityId(), pushLogId);
				if (wfRecomHouseInfo != null) {
					if (wfRecomHouseInfo.getReceiveTime() != null) {
						baseMap.put("dkTime", sdf.format(wfRecomHouseInfo.getReceiveTime()));// 带看时间
					}
					if (wfRecomHouseInfo.getEvaTime() != null) {
						baseMap.put("pjTime", sdf.format(wfRecomHouseInfo.getEvaTime()));// 评价时间
					}
					if (wfRecomHouseInfo.getActTime() != null) {
						baseMap.put("cjTime", sdf.format(wfRecomHouseInfo.getActTime()));// 成交时间
					}
				}
			}
			resultMap.put("baseInfo", baseMap);
			// 根据需求Id获取到主键ID
			if (agencyWfPushLog != null) {
				// 根据主键ID一对多查询WF_RECOM_HOUSE,获取房源ID
				List<AgencyWfRecomHouseDto> wfRecomHouseList = agencyWfRecomHouseMapper
						.getWfRecomHouseByPushLogId(getOperator().getCityId(), pushLogId);
				// 查询已看房源
				for (AgencyWfRecomHouseDto agencyWfRecomHouse : wfRecomHouseList) {
					Integer houseId = agencyWfRecomHouse.getCaseId();
					ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(getOperator().getCityId(), houseId);
					if (funLease != null) {
						agencyWfRecomHouse.setBuildName(funLease.getBuildName());// 楼盘名称
						agencyWfRecomHouse.setHouseUseAge(String.valueOf(funLease.getLeaseUseage()));// 房屋用途
						agencyWfRecomHouse.setHouseRoom(String.valueOf(funLease.getLeaseRoom()));// 几室
						agencyWfRecomHouse.setHouseHall(String.valueOf(funLease.getLeaseHall()));// 几厅
						agencyWfRecomHouse.setHouseWei(String.valueOf(funLease.getLeaseWei()));// 几卫
						agencyWfRecomHouse.setHouseArea(String.valueOf(funLease.getLeaseArea()));// 面积
						agencyWfRecomHouse.setHouseFitment(String.valueOf(funLease.getLeaseFitment()));// 装修情况
						agencyWfRecomHouse.setHouseFloor(String.valueOf(funLease.getLeaseFloor()));// 当前楼层
						agencyWfRecomHouse.setHouseFloors(String.valueOf(funLease.getLeaseFloors()));// 总楼层
						agencyWfRecomHouse.setIsTrue(funLease.getTrueFlag() == 1 ? "1" : "0");// 1=真房源
					}
					agencyWfRecomHouse.setIsDeal(agencyWfRecomHouse.getSeeStatus() == 4 ? "1" : "0");// 1=已成交
					agencyWfRecomHouse.setBlStatus(agencyWfRecomHouse.getDelStatus() == 0 ? "0" : "1");// 0=保留意向,1=不再考虑
					if (agencyWfRecomHouse.getHouseMoney() != null) {
						agencyWfRecomHouse.setPrice(String.valueOf(agencyWfRecomHouse.getHouseMoney()));// 业主标价
					}
					param.setInteger("houseId", houseId);
					param.setInteger("caseType", Const.DIC_CASE_TYPE_LEASE_FUN);
					List<ErpFunPhoto> funPhotoList = erpFunPhotoMapper.getHousePhotoByCaseId(getOperator().getCityId(),
							param.getMap());
					param.setInteger("caseType", caseType);
					if (funPhotoList.size() > 0) {
						agencyWfRecomHouse.setPhotoCount(String.valueOf(funPhotoList.size()));// 图片总量
						agencyWfRecomHouse.setPhotoAddr(CommonUtil.getHousePhoto(funPhotoList.get(0).getPhotoAddr()));// 首图地址
					}
					// 根据archiveId到WF_ARCHIVE_TOTAL 表中查询评价
					Integer archiveId = agencyWfRecomHouse.getArchiveId();
					AgencyWfArchiveTotal wfArchiveTotal = agencyWfArchiveTotalMapper
							.getWfArchiveTotalByArchiveId(archiveId);
					agencyWfRecomHouse.setPraiseNum(String.valueOf(wfArchiveTotal.getPraiseNum()));// 好评数
					agencyWfRecomHouse.setRentId(String.valueOf(houseId));// 房源ID
				}
				resultMap.put("ykHouseList", wfRecomHouseList);
			}
		}
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 设置红包
	 * 
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeRedPacketNumber")
	public ResponseJson changeRedPacketNumber(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("archiveId", getOperator().getArchiveId());
		agencyWfServiceSettingService.changeRedPacketNumber(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 进入红包页面
	 * 
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getRedPacketPage")
	public ResponseJson getRedPacketPage(@RequestBody BaseMapParam param) throws Exception {
		AgencyWfServiceSetting agencyWfServiceSetting = agencyWfServiceSettingMapper
				.selectByPrimaryKey(getOperator().getArchiveId());
		return ErpResponseJson.ok(agencyWfServiceSetting);
	}

	/**
	 * 微店红包开启或者关闭
	 * 
	 * @author xionggang
	 * @since 2017年8月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/changeSwitchState")
	public ResponseJson changeSwitchState(@RequestBody BaseMapParam param) throws Exception {
		param.setInteger("archiveId", getOperator().getArchiveId());
		agencyWfServiceSettingService.changeSwitchState(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 员工动态
	 * 
	 * @author xionggang
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getEmployeeDynamicsList")
	public ResponseJson getEmployeeDynamicsList(@RequestBody GetEmployeeDynamicsListParam param) throws Exception {
		param.setCompId(getOperator().getCompId());
		param.setCityId(getOperator().getCityId());
		// PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		// 查询出员工的佣金，接单量，带看量，成交量，房勘量
		if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
			param.setOrganizationId(null);
		}
		int totalCount = agencyWfPushLogMapper.getCountOffWfPushLogListByDeptId(param);
		if (totalCount == 0) {
			return ErpResponseJson.ok();
		}
		List<AgencyWfPushLogDto> wfPushLogList = agencyWfPushLogMapper.getWfPushLogListByDeptId(param);
		PageInfo<AgencyWfPushLogDto> pageInfo = new PageInfo<AgencyWfPushLogDto>(wfPushLogList);
		pageInfo.setPageSize(param.getPageRows());
		pageInfo.setTotal(totalCount);
		List<Integer> archiveIdList = wfPushLogList.stream().collect(Collectors.mapping(AgencyWfPushLogDto::getArchiveId, Collectors.toList()));
		if (archiveIdList != null && !archiveIdList.isEmpty()) {
			// 获取员工基本详情
			List<ErpFunUsers> funUsersList = erpFunUsersMapper.getFunUsersBydept(getOperator().getCityId(), archiveIdList);
			Map<Integer, ErpFunUsers> funUsersMap = funUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getArchiveId, val -> val));
			// 经纪人头像
			List<AdminFunArchiveDto> archivePhotoList = adminFunArchiveMapper.getPhotoByArchiveId(archiveIdList, param);
			Map<Integer, AdminFunArchiveDto> archivePhotoMap = archivePhotoList.stream().collect(Collectors.toMap(AdminFunArchiveDto::getArchiveId, val -> val));
			// 组装数据
			for (AgencyWfPushLogDto agencyWfPushLogDto : wfPushLogList) {
				Integer archiveId = agencyWfPushLogDto.getArchiveId();
				String starRating = agencyWfPushLogDto.getStarRating();
				BigDecimal starRatingBD = new BigDecimal(starRating);
				starRating = new BigDecimal(starRatingBD + "").setScale(2, BigDecimal.ROUND_HALF_UP).toString();
				agencyWfPushLogDto.setStarRating(starRating);
				ErpFunUsers erpFunUsers = funUsersMap.get(archiveId);
				AdminFunArchiveDto adminFunArchiveDto = archivePhotoMap.get(archiveId);
				agencyWfPushLogDto.setUserPhoto(CommonUtil.getBbsPhoto(adminFunArchiveDto.getUserPhoto()));
				agencyWfPushLogDto.setUserName(erpFunUsers.getUserName());
				agencyWfPushLogDto.setUserPosition(erpFunUsers.getUserPosition());
			}
		}
		ErpResponseJson responseJson = ErpResponseJson.ok(pageInfo);
		responseJson.setTotal(Long.valueOf(wfPushLogList.size()));
		return responseJson;
	}

	/**
	 * 员工评价详情
	 * 
	 * @author xionggang
	 * @since 2017年8月22日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getEvaluationDetailsByArchiveId")
	public ResponseJson getEvaluationDetailsByArchiveId(@RequestBody BaseMapParam param) throws Exception {
		// 获取评价占比
		AgencyWfCompleteEvaDto agencyWfCompleteEvaDto = agencyWfCompleteEvaMapper
				.getRateByArchiveId(getOperator().getCityId(), param.getInteger("archiveId"));
		// 获取真房源占比
		AgencyWfRecomHouseEvaDto agencyWfRecomHouseEvaDto = agencyWfRecomHouseEvaMapper
				.getTrueRateByArchiveId(getOperator().getCityId(), param.getInteger("archiveId"));
		// 获取意向占比
		AgencyWfRecomHouseDto agencyWfRecomHouseDto = agencyWfRecomHouseMapper
				.getIntentionRateByArchiveId(getOperator().getCityId(), param.getInteger("archiveId"));
		// 拼接
		if (agencyWfCompleteEvaDto == null) {
			agencyWfCompleteEvaDto = new AgencyWfCompleteEvaDto();
		}
		if (null != agencyWfRecomHouseDto) {
			agencyWfCompleteEvaDto.setIntentionRate(agencyWfRecomHouseDto.getIntentionRate());
		}
		if (null != agencyWfRecomHouseEvaDto) {
			agencyWfCompleteEvaDto.setTrueHouseRate(agencyWfRecomHouseEvaDto.getTrueHouseRate());
		}
		return ErpResponseJson.ok(agencyWfCompleteEvaDto);
	}
}

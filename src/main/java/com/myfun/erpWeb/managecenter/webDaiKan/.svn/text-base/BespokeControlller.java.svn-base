package com.myfun.erpWeb.managecenter.webDaiKan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminYoujiaReserveEvaMapper;
import com.myfun.repository.admindb.dao.AdminYoujiaReserveHouseEvaMapper;
import com.myfun.repository.admindb.dao.AdminYoujiaReserveMapper;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.admindb.dto.AdminYoujiaReserveDto;
import com.myfun.repository.admindb.dto.AdminYoujiaReserveHouseEvaDto;
import com.myfun.repository.admindb.po.AdminYoujiaReserve;
import com.myfun.repository.admindb.po.AdminYoujiaReserveEva;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEva;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEvaExample;
import com.myfun.repository.agencydb.dao.*;
import com.myfun.repository.agencydb.dto.*;
import com.myfun.repository.agencydb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunLeaseDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.agencydb.AgencyWfServiceSettingService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manageCenter/bespoke/")
public class BespokeControlller extends BaseController {
	
	@Autowired
	private AdminYoujiaReserveMapper adminYoujiaReserveMapper;
	@Autowired
	private AdminYoujiaReserveEvaMapper adminYoujiaReserveEvaMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;
	@Autowired
	private ErpFunUsersService erpFunUsersService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private AdminYoujiaReserveHouseEvaMapper adminYoujiaReserveHouseEvaMapper;
	@Autowired
	private ErpFunPhoneMapper erpFunPhoneMapper;

	/**
	 * @title ：预约带看列表
	 * @athor：lcb
	 * @date  : 2017/11/2
	 */
	@RequestMapping("/getDaiKanList")
	public ResponseJson getDaiKanList(@RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer deptId = param.getInteger("deptId");
		String keyWords = param.getString("keyWords");
		String startTimeStr = param.getString("startTime");
		String endTimeStr = param.getString("endTime");
		Integer userId = param.getInteger("userId");
		Integer grId = param.getInteger("grId");

		Date startTime = null;
		Date endTime = null;
		if(StringUtils.isNotBlank(startTimeStr)) {
			startTimeStr = startTimeStr+" 00:00:00";
			startTime = DateUtil.StringToDate(startTimeStr, "yyyy-MM-dd HH:mm:ss");
		}
		if(StringUtils.isNotBlank(endTimeStr)) {
			endTimeStr = endTimeStr+" 23:59:59";
			endTime = DateUtil.StringToDate(endTimeStr, "yyyy-MM-dd HH:mm:ss");
		}

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<AdminYoujiaReserveDto> resList = adminYoujiaReserveMapper.getDaiKanList(cityId, compId,
				deptId, grId, keyWords, userId, startTime, endTime);

		Set<Integer> resIds = new HashSet<>();
		// 查询房源信息
		Set<String> phoneSet = new HashSet<>();
		for (AdminYoujiaReserveDto adminYoujiaReserveDto : resList) {
			resIds.add(adminYoujiaReserveDto.getId());
			phoneSet.add(EnCodeHelper.encode(adminYoujiaReserveDto.getReservePhone()));
		}

		List<ErpFunPhone> erpFunPhones = new ArrayList<>();
		if(phoneSet.size() > 0) {

			// 查询funPhone表
			ErpFunPhoneExample erpFunPhoneExample = new ErpFunPhoneExample();
			erpFunPhoneExample.setShardCityId(cityId);
			ErpFunPhoneExample.Criteria criteria = erpFunPhoneExample.createCriteria();
			criteria.andCompIdEqualTo(compId).andUserIdEqualTo(userId).andPhoneIn(new ArrayList<>(phoneSet)).andCaseTypeIn(Arrays.asList(new Integer[]{Const.DIC_CASE_TYPE_BUY_CUST, Const.DIC_CASE_TYPE_RENT_CUST }));
			erpFunPhones = erpFunPhoneMapper.selectByExample(erpFunPhoneExample);
		}

		if(resIds.size() > 0) {
			// 查询带看清单
			List<AdminYoujiaReserveHouseEvaDto> adminYoujiaReserveHouseEvas = adminYoujiaReserveHouseEvaMapper.getList(resIds);
			Map<Integer, List<AdminYoujiaReserveHouseEvaDto>> resHouselistMap = adminYoujiaReserveHouseEvas.stream().collect(Collectors.groupingBy(AdminYoujiaReserveHouseEvaDto::getReserverId));

			Set<String> saleIdSet = new HashSet<>();
			Set<String> leaseIdSet = new HashSet<>();
			// 清单数据
			for (AdminYoujiaReserveHouseEvaDto adminYoujiaReserveHouseEva : adminYoujiaReserveHouseEvas) {

				if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(adminYoujiaReserveHouseEva.getCaseType().toString())) {
					saleIdSet.add(adminYoujiaReserveHouseEva.getCaseId() + "");
				} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(adminYoujiaReserveHouseEva.getCaseType().toString())) {
					leaseIdSet.add(adminYoujiaReserveHouseEva.getCaseId() + "");
				} else {
					continue;
				}
			}

			// 查询房源列表
			Map<Integer, ErpFunSaleDto> funSaleMap = new HashMap<>();
			Map<Integer, ErpFunLeaseDto> funLeaseMap = new HashMap<>();

			if(saleIdSet.size() > 0) {
				funSaleMap = erpFunSaleMapper.getDkErpFunSale(cityId, compId, saleIdSet.toArray(new String[]{}));
			}

			if(leaseIdSet.size() > 0) {
				funLeaseMap = erpFunLeaseMapper.getDkErpLease(cityId, compId, leaseIdSet.toArray(new String[]{}));
			}

			for (AdminYoujiaReserveHouseEvaDto adminYoujiaReserveHouseEva : adminYoujiaReserveHouseEvas) {

				if(Const.DIC_CASE_TYPE_SALE_FUN.equals(adminYoujiaReserveHouseEva.getCaseType().intValue())) {

					ErpFunSaleDto erpFunSaleDto = funSaleMap.get(adminYoujiaReserveHouseEva.getCaseId());
					if(null != erpFunSaleDto) {
						adminYoujiaReserveHouseEva.setBuildAddr(erpFunSaleDto.getBuildAddr());
						adminYoujiaReserveHouseEva.setBuildName(erpFunSaleDto.getBuildName());
						adminYoujiaReserveHouseEva.setCaseUseage(erpFunSaleDto.getSaleUseage());
						adminYoujiaReserveHouseEva.setCaseRoof(erpFunSaleDto.getSaleRoofT());
						adminYoujiaReserveHouseEva.setCaseUnit(erpFunSaleDto.getSaleUnitT());
						adminYoujiaReserveHouseEva.setCaseNum(erpFunSaleDto.getSaleNumT());
						adminYoujiaReserveHouseEva.setCaseTotalPrice(erpFunSaleDto.getSaleTotalPrice());
						adminYoujiaReserveHouseEva.setRegionName(erpFunSaleDto.getRegionName());
						adminYoujiaReserveHouseEva.setCaseRound(erpFunSaleDto.getSaleRound());
						adminYoujiaReserveHouseEva.setCaseHall(erpFunSaleDto.getSaleHall());
						adminYoujiaReserveHouseEva.setCaseRoom(erpFunSaleDto.getSaleRoom());
						adminYoujiaReserveHouseEva.setCaseWei(erpFunSaleDto.getSaleWei());
						adminYoujiaReserveHouseEva.setCaseArea(erpFunSaleDto.getSaleArea());
						adminYoujiaReserveHouseEva.setBuildId(erpFunSaleDto.getBuildId());
						adminYoujiaReserveHouseEva.setCaseNo(erpFunSaleDto.getSaleNo());
						adminYoujiaReserveHouseEva.setRegId(erpFunSaleDto.getRegId());
						adminYoujiaReserveHouseEva.setRegionId(erpFunSaleDto.getSaleReg());
						adminYoujiaReserveHouseEva.setAreaId(erpFunSaleDto.getAreaId());
					}
				}else {
					ErpFunLeaseDto erpFunLeaseDto = funLeaseMap.get(adminYoujiaReserveHouseEva.getCaseId());
					if(null != erpFunLeaseDto) {
						adminYoujiaReserveHouseEva.setBuildAddr(erpFunLeaseDto.getBuildAddr());
						adminYoujiaReserveHouseEva.setBuildName(erpFunLeaseDto.getBuildName());
						adminYoujiaReserveHouseEva.setCaseUseage(erpFunLeaseDto.getLeaseUseage());
						adminYoujiaReserveHouseEva.setCaseRoof(erpFunLeaseDto.getLeaseRoofT());
						adminYoujiaReserveHouseEva.setCaseUnit(erpFunLeaseDto.getLeaseUnitT());
						adminYoujiaReserveHouseEva.setCaseNum(erpFunLeaseDto.getLeaseNumT());
						adminYoujiaReserveHouseEva.setCaseTotalPrice(erpFunLeaseDto.getLeaseTotalPrice());
						adminYoujiaReserveHouseEva.setCasePriceUnit(erpFunLeaseDto.getPriceUnit());
						adminYoujiaReserveHouseEva.setRegionName(erpFunLeaseDto.getRegionName());
						adminYoujiaReserveHouseEva.setCaseRound(erpFunLeaseDto.getLeaseRound());
						adminYoujiaReserveHouseEva.setCaseHall(erpFunLeaseDto.getLeaseHall());
						adminYoujiaReserveHouseEva.setCaseRoom(erpFunLeaseDto.getLeaseRoom());
						adminYoujiaReserveHouseEva.setCaseWei(erpFunLeaseDto.getLeaseWei());
						adminYoujiaReserveHouseEva.setCaseArea(erpFunLeaseDto.getLeaseArea());
						adminYoujiaReserveHouseEva.setBuildId(erpFunLeaseDto.getBuildId());
						adminYoujiaReserveHouseEva.setCaseNo(erpFunLeaseDto.getLeaseNo());
						adminYoujiaReserveHouseEva.setRegId(erpFunLeaseDto.getRegId());
						adminYoujiaReserveHouseEva.setRegionId(erpFunLeaseDto.getLeaseReg());
						adminYoujiaReserveHouseEva.setAreaId(erpFunLeaseDto.getAreaId());
					}
				}
			}

			// 最后一次封装数据
			for (AdminYoujiaReserveDto adminYoujiaReserveDto : resList) {
				List<AdminYoujiaReserveHouseEvaDto> houseList = new ArrayList<>();
//				for (AdminYoujiaReserveHouseEvaDto adminYoujiaReserveHouseEva : adminYoujiaReserveHouseEvas) {
//					if(adminYoujiaReserveDto.getId().equals(adminYoujiaReserveHouseEva.getReserverId())) {
//						houseList.add(adminYoujiaReserveHouseEva);
//					}
//				}

				List<AdminYoujiaReserveHouseEvaDto> adminYoujiaReserveHouseEvaDtos = resHouselistMap.get(adminYoujiaReserveDto.getId());
				if(null != adminYoujiaReserveHouseEvaDtos) {
					houseList.addAll(adminYoujiaReserveHouseEvaDtos);
				}

				for (ErpFunPhone erpFunPhone : erpFunPhones) {

					String phoneEncode = EnCodeHelper.encode(adminYoujiaReserveDto.getReservePhone());
					if(phoneEncode.equals(erpFunPhone.getPhone())) {
						adminYoujiaReserveDto.setSysCaseId(erpFunPhone.getCaseId());
						adminYoujiaReserveDto.setSysCaseType(erpFunPhone.getCaseType());
					}
				}
				adminYoujiaReserveDto.setHouseEvaDtoList(houseList);
			}

		}

		return ErpResponseJson.ok(new PageInfo<>(resList));
	}

	/**
	 * title ：设置管理员
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@RequestMapping("/setManager")
	@NotBlank({"userId"})
	public ResponseJson setManager(@RequestBody BaseMapParam param) throws Exception {

		Integer userId = param.getInteger("userId");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer resUserId = erpFunUsersService.setBespokeModuleManager(cityId,operator.getCompId(), userId);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("managerUserId", resUserId);
		return ErpResponseJson.ok(resMap);
	}

	/**
	 * title ：查询模块管理员
	 * athor：lcb
	 * date  : 2017/11/2
	 */
	@RequestMapping("/getBespokeModuleManager")
	public ResponseJson getBespokeModuleManager(@RequestBody BaseMapParam param) throws Exception {

		Operator operator = getOperator();

		ErpFunUsers erpFunUsers = erpFunUsersMapper.getBespokeModuleManager(operator.getCityId(), operator.getCompId());
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("managerInfo", erpFunUsers);
		return ErpResponseJson.ok(resMap);
	}
}

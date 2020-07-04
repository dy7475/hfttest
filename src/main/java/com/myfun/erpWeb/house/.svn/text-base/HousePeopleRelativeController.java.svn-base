package com.myfun.erpWeb.house;

import com.myfun.erpWeb.house.param.GetHousePeopleRelativeListParam;
import com.myfun.erpWeb.house.vo.GetHousePeopleRelativeListVo;
import com.myfun.erpWeb.house.vo.LeasePeRelDto;
import com.myfun.erpWeb.house.vo.SalePeRelDto;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpLeasePeopleRelativeService;
import com.myfun.service.business.erpdb.ErpSalePeopleRelativeService;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/house", method = RequestMethod.POST)
public class HousePeopleRelativeController extends BaseController{

	@Autowired
	ErpSalePeopleRelativeMapper erpSalePeopleRelativeMapper;
	@Autowired
	ErpLeasePeopleRelativeMapper erpLeasePeopleRelativeMapper;
	@Autowired
	ErpSalePeopleRelativeService erpSalePeopleRelativeService;
	@Autowired
	ErpLeasePeopleRelativeService erpLeasePeopleRelativeService;
	@Autowired
	ErpFunUsersMapper erpFunusersMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	
	/**
	 * 获取相关人列表
	 * @author 熊刚
	 * @since 2017年9月7日
	 * @param param
	 * @return
	 * @throws Exception
	 */
/*
	@ResponseBody
	@RequestMapping(value = "/getHousePeopleRelativeList")
	@NotBlank({"caseId","caseType"})
	public ResponseJson getHousePeopleRelativeList(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseId = param.getInteger("caseId");
		Integer caseType = param.getInteger("caseType");
		
		List<Map<String, Object>> relativeList = new LinkedList<>();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			relativeList = erpSalePeopleRelativeMapper.getListByCaseId(cityId, compId, caseId, null);
			ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(null != erpFunSale && 1 == erpFunSale.getIsSaleLease().intValue()) {
				List<Map<String, Object>> leaseRelativeList = erpLeasePeopleRelativeMapper.getListByCaseId(cityId, compId, erpFunSale.getSaleLeaseId(), 1);
				relativeList.addAll(leaseRelativeList);
			}
		} else {
			relativeList = erpLeasePeopleRelativeMapper.getListByCaseId(cityId, compId, caseId, null);
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(null != erpFunLease && 1 == erpFunLease.getIsSaleLease().intValue()) {
				List<Map<String, Object>> saleRelativeList = erpSalePeopleRelativeMapper.getListByCaseId(cityId, compId, erpFunLease.getSaleLeaseId(), 1);
				relativeList.addAll(saleRelativeList);
			}
		}
		return ErpResponseJson.ok(relativeList);
	}
*/

	/**
	 * 获取相关人列表
	 * @author 王淳
	 * @since 2018年12月17日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取相关人列表")
	@ApiResponses({@ApiResponse(code = 200,response = GetHousePeopleRelativeListVo.class,message = "success")})
	@ResponseBody
	@PostMapping(value = "/getHousePeopleRelativeList")
	@NotBlank({"caseId","caseType"})
	public ResponseJson getHousePeopleRelativeList(@Valid @RequestBody GetHousePeopleRelativeListParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		List<SalePeRelDto> salePeRelList = new ArrayList<>();
		List<LeasePeRelDto> leasePeRelList = new ArrayList<>();
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			salePeRelList = erpSalePeopleRelativeMapper.getListByCaseId(cityId, compId, caseId, null);
			ErpFunSale erpFunSale = erpFunSaleMapper.getSaleLeaseInfo(cityId, caseId);
			if(null != erpFunSale && 1 == erpFunSale.getIsSaleLease().intValue()) {
				leasePeRelList = erpLeasePeopleRelativeMapper.getListByCaseId(cityId, compId, erpFunSale.getSaleLeaseId(), 1);
			}
		} else {
			leasePeRelList = erpLeasePeopleRelativeMapper.getListByCaseId(cityId, compId, caseId, null);
			ErpFunLease erpFunLease = erpFunLeaseMapper.getLeaseSaleInfo(cityId, caseId);
			if(null != erpFunLease && 1 == erpFunLease.getIsSaleLease().intValue()) {
				salePeRelList = erpSalePeopleRelativeMapper.getListByCaseId(cityId, compId, erpFunLease.getSaleLeaseId(), 1);
			}
		}

		List<ErpFunPerformanceType> performances = erpFunPerformanceTypeMapper.getDataListByCompId(cityId,compId);
		Map<String, BigDecimal> perfMap = new HashMap<>();
		if (CollectionUtils.isNotEmpty(performances)){
			perfMap = performances.stream().filter(val-> val != null).filter(val-> StringUtils.isNotBlank(val.getEnMsg()))
					.collect(HashMap::new, (m, v) -> m.put(v.getEnMsg(), v.getPerformanceProportion()),HashMap::putAll);
		}

		if (CollectionUtils.isNotEmpty(salePeRelList)) {
			for (SalePeRelDto dto : salePeRelList){
				dto.setPerformanceProportion(setPeoplePerformance(dto.getPeopleType(), perfMap));
			}
		}
		if (CollectionUtils.isNotEmpty(leasePeRelList)) {
			for (LeasePeRelDto dto : leasePeRelList){
				dto.setPerformanceProportion(setPeoplePerformance(dto.getPeopleType(), perfMap));
			}
		}

		GetHousePeopleRelativeListVo resultVo = new GetHousePeopleRelativeListVo();
		resultVo.setSalePeRelList(salePeRelList);
		resultVo.setLeaseRelativeList(leasePeRelList);
		return ErpResponseJson.ok(resultVo);
	}

	//相关人列表封装业绩分配比例
	public BigDecimal setPeoplePerformance(Integer performanceType, Map<String, BigDecimal> perfMap){
		BigDecimal bigDecimal = BigDecimal.ZERO;
		switch (performanceType){
			case 1: bigDecimal = perfMap.get("HOUSE_CREATE"); break;
			case 2: bigDecimal = perfMap.get("HOUSE_GUARDIAN"); break;
			case 3: bigDecimal = perfMap.get("KEY"); break;
			case 4: bigDecimal = perfMap.get("FANKAN"); break;
			case 5: bigDecimal = perfMap.get("WEITUO"); break;
			case 6: bigDecimal = perfMap.get("YIJIA"); break;
			case 7: bigDecimal = perfMap.get("BUILD_MANAGER"); break;
			default: break;
		}
		return bigDecimal;
	}

	/**
	 * 删除或者变更房源相关人
	 * @author 熊刚
	 * @since 2017年9月7日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value ="/updateHousePeopleRelative")
	public ResponseJson updateHousePeopleRelative(@Valid @RequestBody HousePeopleRelativeParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setDeptName(operator.getDeptName());
		param.setUserName(operator.getUserName());
		param.setDeptId(operator.getDeptId());
		param.setCompId(operator.getCompId());
		param.setSelfUserId(operator.getUserId());
		param.setGrId(operator.getGrId());
		param.setOrganizationId(operator.getOrganizationId());
		param.setOrganizationName(operator.getOrganizationName());
		if (param.getId() != null && param.getId() > 0) {
			throw new ConfirmException("该功能已经优化，请升级到新版后使用！");
		}
		if(null != param.getUserId()){
			ErpFunUsers erpFunUsers = erpFunusersMapper.getFunUserByUserId(operator.getCityId(), param.getUserId());
			if(null != erpFunUsers){
				param.setDeptId(erpFunUsers.getDeptId());
			} else {
				param.setDeptId(operator.getDeptId());
			}
		} else if(null != param.getDelFlag() && 1 == param.getDelFlag()){
			param.setDeptId(operator.getDeptId());
			param.setUserId(param.getBeforUserId());
		}
		// 必须这样判断
		if (null != param.getSaleRelativeId()) {
			erpSalePeopleRelativeService.updateHousePeopleRelative(param);
		} else if (param.getLeaseRelativeId() != null){
			erpLeasePeopleRelativeService.updateErpLeasePeopleRelative(param);
		} else if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())){
			erpSalePeopleRelativeService.updateHousePeopleRelative(param);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())){
			erpLeasePeopleRelativeService.updateErpLeasePeopleRelative(param);
		}
		return ErpResponseJson.ok();
	}
}

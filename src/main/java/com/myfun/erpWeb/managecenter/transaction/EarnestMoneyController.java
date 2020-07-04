package com.myfun.erpWeb.managecenter.transaction;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.buildData.vo.ErpFunBuildRuleDto;
import com.myfun.erpWeb.managecenter.transaction.param.CancelAuditParam;
import com.myfun.erpWeb.managecenter.transaction.param.CancellationParam;
import com.myfun.erpWeb.managecenter.transaction.param.ConvertDepositHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.DealFunEarbestMoneyDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.InsertDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToCommssionParam;
import com.myfun.erpWeb.managecenter.transaction.param.PayDepositToOwnerParam;
import com.myfun.erpWeb.managecenter.transaction.param.QueryDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.QueryDepositListParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundMoneyParam;
import com.myfun.erpWeb.managecenter.transaction.param.QueryDepositLogParam;
import com.myfun.erpWeb.managecenter.transaction.param.RefundDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestHouseParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToBrokerageParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransEarnestToProprietorParam;
import com.myfun.erpWeb.managecenter.transaction.param.TransToDepositParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateDepositStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateEarbestStatusParam;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.erpWeb.managecenter.transaction.vo.CustInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositDetailVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositListVO;
import com.myfun.erpWeb.managecenter.transaction.vo.DepositVO;
import com.myfun.erpWeb.managecenter.transaction.vo.EarbestDetailVO;
import com.myfun.erpWeb.managecenter.transaction.vo.EarbestMoneyListVo;
import com.myfun.erpWeb.managecenter.transaction.vo.EarbestVO;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpFunEarbestMoneyVo;
import com.myfun.erpWeb.managecenter.transaction.vo.HouseInfoVO;
import com.myfun.erpWeb.managecenter.transaction.vo.MatchInnerDealListVo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunDepositMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyrecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.param.QueryDealListParam;
import com.myfun.repository.erpdb.po.ErpFunDealExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminJmsMessageService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunDepositService;
import com.myfun.service.business.erpdb.ErpFunEarbestMoneyService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;
import com.myfun.service.jms.bean.UpdateFunProfitMessage;
import com.myfun.utils.Assert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SyncUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import com.myfun.erpWeb.managecenter.transaction.param.ErpDealEarbestMoneyParam;
/**
* @ClassName: EarnestMoneyController 
* @Description: 跟进日志
* @author 方李骥
* @date 2017-02-06 10:12:30
 */
@Api(tags ="诚意金定金管理模块")
@RestController
@RequestMapping("/managerCenter/transaction/earbestMoney")
public class EarnestMoneyController extends BaseController{
	@Autowired
	ErpFunEarbestMoneyService erpFunEarbestMoneyService;
	@Autowired
	ErpEarbestMoneyMapper erpEarbestMoneyMapper;
	@Autowired
	ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;
	@Autowired
	ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
	@Autowired
	ErpFunBillCodelogService erpFunBillCodelogService;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunDepositMapper erpFunDepositMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunDepositService erpFunDepositService;
	@Autowired
	ErpFunDepositLogMapper erpFunDepositLogMapper;
	@Autowired
	AdminJmsMessageService adminJmsMessageService;

	/**
	 * 查询诚意金列表
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("查询诚意金列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = EarbestMoneyListVo.class, message = "成功")
	})
	@PostMapping("/new/getEarbestMoneyList")
	public ErpResponseJson getEarbestMoneyList(@Valid @RequestBody QueryErpEarbestMoneyListParam param) throws Exception {
		List<ErpFunEarbestMoneyDto> resList = getList(1, param);
		PageInfo<ErpFunEarbestMoneyDto> page = new PageInfo<>(resList);
		return ErpResponseJson.ok(page);
	}
	
	/**
	 * 查询定金列表
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("查询定金列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DepositListVO.class, message = "成功")
	})
	@PostMapping("/getDepositList")
	public ErpResponseJson getDepositList(@Valid @RequestBody QueryDepositListParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		if (StringUtils.isNotBlank(param.getReceiptNo())) {
			param.setReceiptNo("%" + param.getReceiptNo() + "%");
		}
		if (StringUtils.isNotBlank(param.getBuildId())) {
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		} else if (StringUtils.isNotBlank(param.getBuildName())) {
			param.setBuildName("%" + param.getBuildName() + "%");
		}
		String types = param.getTypes();
		if (StringUtils.isNotBlank(types)) {
			String[] typeList = types.split(",");
			param.setTypeList(typeList);
		}
		/*if (Objects.nonNull(param.getStatus()) && Byte.valueOf("1").equals(param.getStatus())) {//查询审核时 只查询收诚意金的审核记录 why？guizhidao
			param.setTypeList(new String[]{"0"});
		}*/
		if (param.getUserId()!=null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(operator.getCityId(), param.getUserId());
			if (erpFunUsers==null) {
				throw new BusinessException("此员工不存在！");
			}
			if (erpFunUsers.getUserLevel()!=null) {
				param.setUserLevel(erpFunUsers.getUserLevel()+2);
			}
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.ID DESC");
		param.setDateType("A."+param.getDateType());
		param.setIsNewOrganization(getOperator().newOrganizationType());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<DepositVO> list = erpFunDepositMapper.selectDepositList(param.getCityId(),param);
		List<Integer> saleIdList = list.stream().filter(a->Byte.valueOf("1").equals(a.getCaseType())).collect(Collectors.mapping(DepositVO::getCaseId, Collectors.toList()));
		List<Integer> leaseIdList = list.stream().filter(a->Byte.valueOf("2").equals(a.getCaseType())).collect(Collectors.mapping(DepositVO::getCaseId, Collectors.toList()));
		Map<Integer,HouseInfoVO> saleHouseInfoMap = null;
		if (saleIdList!=null && !saleIdList.isEmpty()) {
			saleHouseInfoMap = getHouseInfoByHouseIds(operator.getCityId(), operator.getCompId(), saleIdList, Const.DIC_CASE_TYPE_SALE_FUN);
		}
		Map<Integer,HouseInfoVO> leaseHouseInfoMap = null;
		if (leaseIdList!=null && !leaseIdList.isEmpty()) {
			leaseHouseInfoMap = getHouseInfoByHouseIds(operator.getCityId(), operator.getCompId(), leaseIdList, Const.DIC_CASE_TYPE_LEASE_FUN);
		}
		for (DepositVO depositVO:list) {
			HouseInfoVO houseInfoVo = null;
			if (Byte.valueOf("1").equals(depositVO.getCaseType())) {
				houseInfoVo = saleHouseInfoMap.get(depositVO.getCaseId());
			}
			if (Byte.valueOf("2").equals(depositVO.getCaseType())) {
				houseInfoVo = leaseHouseInfoMap.get(depositVO.getCaseId());
			}
			if (houseInfoVo!=null) {
				BeanUtils.copyProperties(houseInfoVo, depositVO);
			}
		}
		PageInfo<DepositVO> page = new PageInfo<>(list);
		return ErpResponseJson.ok(page);
	}
	
	/**
	 * 查询定金详情
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("查询定金详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DepositDetailVO.class, message = "成功")
	})
	@RequestMapping("/getDepositDetail")
	public ErpResponseJson getDepositDetail(@Valid @RequestBody QueryDepositDetailParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		DepositDetailVO resultVo = new DepositDetailVO();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunDeposit id = new ErpFunDeposit();
		id.setShardCityId(cityId);
		id.setId(param.getId());
		id = erpFunDepositMapper.selectByPrimaryKey(id);
		DepositVO detail = new DepositVO();
		BeanUtils.copyProperties(id, detail);
		detail.setBillPhoto(AppConfig.getUserPhotoPicDomainPath(detail.getBillPhoto()));
		resultVo.setDetail(detail);
		Map<Integer,HouseInfoVO> houseInfoMap = getHouseInfoByHouseIds(cityId, compId, Arrays.asList(detail.getCaseId()), detail.getCaseType().intValue());
		try {
			HouseInfoVO houseInfo = houseInfoMap.get(detail.getCaseId());
			BeanUtils.copyProperties(houseInfo, detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<Integer,CustInfoVO> custInfoMap = getCustInfoByCustIds(cityId, compId, Arrays.asList(detail.getCustId()), detail.getCustType().intValue());
		try {
			CustInfoVO custInfo = custInfoMap.get(detail.getCustId());
			BeanUtils.copyProperties(custInfo, detail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<DepositVO> list = null;
		if (detail.getDealId()!=null) {
			list = erpFunDepositMapper.selectDepositListByDealId(cityId, compId, id.getDealId(), param.getId());
		} else {
			list = erpFunDepositMapper.selectDepositListByHouseCustId(cityId, compId, id.getCustId(), id.getCustType(), id.getCaseId(), id.getCaseType(), param.getId());
		}
		resultVo.setList(list);
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：0 1.转房源，2代付 3.客户转拥，4.退款 5=作废.6=业主转佣
		for (DepositVO vo:list) {
			if (Byte.valueOf("0").equals(vo.getOperationType())) {
				balance = balance.add(vo.getReceiptMoney());
			} else if (Byte.valueOf("3").equals(vo.getOperationType()) || Byte.valueOf("6").equals(vo.getOperationType()) || Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {
				//转佣的，代付的，退款的
				balance = balance.subtract(vo.getReceiptMoney());
			}
			if (StringUtil.isNotBlank(vo.getBillPhoto())) {
				vo.setBillPhoto(AppConfig.getUserPhotoPicDomainPath(vo.getBillPhoto()));
			}
		}
		if (Byte.valueOf("0").equals(detail.getOperationType())) {
			balance = balance.add(detail.getReceiptMoney());
		} else if (Byte.valueOf("3").equals(detail.getOperationType()) || Byte.valueOf("6").equals(detail.getOperationType()) || Byte.valueOf("2").equals(detail.getOperationType()) || Byte.valueOf("4").equals(detail.getOperationType())) {
			//转佣的，代付的，退款的
			balance = balance.subtract(detail.getReceiptMoney());
		}
		resultVo.setBalance(balance);
		return ErpResponseJson.ok(resultVo);
	}
	
	
	/**
	 * 新增定金
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("插入定金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDeposit.class, message = "成功")
	})
	@RequestMapping("/insertDepositDetail")
	public ErpResponseJson insertDepositDetail(@Valid @RequestBody InsertDepositDetailParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setDeptId(operator.getDeptId());
		param.setGrId(operator.getGrId());
		param.setDeptCName(operator.getDeptCName());
		ErpFunDeposit erpFunDeposit = erpFunDepositService.insertDepositDetail(param);
		return ErpResponseJson.ok(erpFunDeposit);
	}
	
	/**
	 * 查询定金详情
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("更新定金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DepositDetailVO.class, message = "成功")
	})
	@RequestMapping("/updateDepositDetail")
	public ErpResponseJson updateDepositDetail(@Valid @RequestBody UpdateDepositDetailParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setDeptId(operator.getDeptId());
		param.setGrId(operator.getGrId());
		param.setDeptCName(operator.getDeptCName());
		erpFunDepositService.updateFunDepositDetail(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询定金详情
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("审核，撤销审核，作废时调用此接口")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@RequestMapping("/updateDepositStatus")
	public ErpResponseJson updateDepositStatus(@Valid @RequestBody UpdateDepositStatusParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		GeneralParam generalParam = new GeneralParam(operator);
		param.setGeneralParam(generalParam);
		erpFunDepositService.updateDepositStatus(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 
	 * 转房源接口
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("转房源接口")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@RequestMapping("/convertDepositHouse")
	public ErpResponseJson convertDepositHouse(@Valid @RequestBody ConvertDepositHouseParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		GeneralParam generalParam = new GeneralParam(operator);
		param.setGeneralParam(generalParam);
		erpFunDepositService.convertDepositHouse(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 转房源接口
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("定金退款接口")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@RequestMapping("/refundDeposit")
	public ErpResponseJson refundDeposit(@Valid @RequestBody RefundDepositParam param) throws Exception {
		// 1.已审核未成交之前
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		GeneralParam generalParam = new GeneralParam(operator);
		param.setGeneralParam(generalParam);
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		param.setDeposit(oldModel);
		List<DepositVO> list = null;
		if (oldModel.getDealId()!=null) {
			list = erpFunDepositMapper.selectDepositListByDealId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getDealId(),null);
		} else {
			list = erpFunDepositMapper.selectDepositListByHouseCustId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getCustId(), oldModel.getCustType(), oldModel.getCaseId(), oldModel.getCaseType(), null);
		}
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：0 默认 1.转房源，2.代付，3.转拥，4.退款
		for (DepositVO vo:list) {
			if (Byte.valueOf("0").equals(vo.getDepositStatus())) {
				throw new BusinessException("存在未审核的定金，不允许退款！");
			}
			if (Byte.valueOf("0").equals(vo.getOperationType())) {
				balance = balance.add(vo.getReceiptMoney());
			} else if (Byte.valueOf("3").equals(vo.getOperationType()) || Byte.valueOf("6").equals(vo.getOperationType()) || Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {
				//转佣的，代付的，退款的
				balance = balance.subtract(vo.getReceiptMoney());
			}
		}
		if (balance.compareTo(param.getRefundMoney())<0) {
			throw new BusinessException("定金余额不足！");
		}
		List<Integer> custIdList = new ArrayList<>();
		custIdList.add(oldModel.getCustId());
		Map<Integer, CustInfoVO> custInfoMap = getCustInfoByCustIds(operator.getCityId(), operator.getCompId(), custIdList, oldModel.getCustType().intValue());
		param.setCustInfo(custInfoMap.get(oldModel.getCustId()));
		erpFunDepositService.refundDeposit(param);
		return ErpResponseJson.ok();
	}
	
	
	/**
	 * 转佣金
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("转佣金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDeposit.class, message = "成功")
	})
	@RequestMapping("/payDepositToCommssion")
	public ErpResponseJson payDepositToCommssion(@Valid @RequestBody PayDepositToCommssionParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setDeptId(operator.getDeptId());
		param.setGrId(operator.getGrId());
		param.setDeptCName(operator.getDeptCName());
		//1.转佣金的时候 a.是否所有审核通过 a.验证余额还能够转佣金 b.生成财务款项c.写合同日志d.生成一条转佣的记录，状态已经审核，已转佣
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		GeneralParam generalParam = new GeneralParam(operator);
		param.setGeneralParam(generalParam);
		ErpFunDeposit id = new ErpFunDeposit();
		id.setShardCityId(cityId);
		id.setId(param.getId());
		id = erpFunDepositMapper.selectByPrimaryKey(id);
		if (id.getDealId() == null) {
			throw new BusinessException("转成交之前不能操作转佣金！");
		}
		param.setDeposit(id);
		ErpFunDeal dealInfo = erpFunDealMapper.selectByDealId(param.getCityId(), id.getDealId(), new String[]{"DEAL_AUDIT_STATUS","DEAL_STATUS"});
		//合同结算之后，不能操作转佣
		if (Byte.valueOf("2").equals(dealInfo.getDealStatus())) {
			throw new BusinessException("合同已结算，不能操作转佣！");
		}
		//合同作废之后，不能操作转佣
		if (Byte.valueOf("3").equals(dealInfo.getDealAuditStatus())) {
			throw new BusinessException("合同已作废，不能操作转佣！");
		}
		Integer count = 0;
		count = erpFunDepositMapper.countDepositListByDealId(cityId, compId, id.getDealId());
		
		if (count>0) {
			throw new BusinessException("还存在未审核的定金，不能操作转佣金！");
		}
		List<Integer> houseIdList = new ArrayList<>();
		houseIdList.add(id.getCaseId());
		List<Integer> custIdList = new ArrayList<>();
		custIdList.add(id.getCustId());
		Map<Integer,HouseInfoVO> houseInfoMap = getHouseInfoByHouseIds(operator.getCityId(), operator.getCompId(), houseIdList, id.getCaseType().intValue());
		param.setHouseInfo(houseInfoMap.get(id.getCaseId()));
		Map<Integer, CustInfoVO> custInfoMap = getCustInfoByCustIds(operator.getCityId(), operator.getCompId(), custIdList, id.getCustType().intValue());
		param.setCustInfo(custInfoMap.get(id.getCustId()));
		List<DepositVO> list = erpFunDepositMapper.selectDepositListByDealId(cityId, compId, id.getDealId(), null);
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：0 默认 1.转房源，2.代付，3.转拥，4.退款
		for (DepositVO vo:list) {
			if (Byte.valueOf("0").equals(vo.getOperationType())) {
				balance = balance.add(vo.getReceiptMoney());
			} else if (Byte.valueOf("3").equals(vo.getOperationType()) || Byte.valueOf("6").equals(vo.getOperationType()) || Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {
				//转佣的，代付的，退款的
				balance = balance.subtract(vo.getReceiptMoney());
			}
		}
		if (balance.compareTo(param.getCommssion())<0) {
			throw new BusinessException("定金余额不足！");
		}
		
		ErpFunDeposit deposit = erpFunDepositService.payDepositToCommssion(param);
		UpdateFunProfitMessage message = new UpdateFunProfitMessage();
		message.setCityId(cityId);
		message.setCompId(compId);
		message.setDealId(id.getDealId());
		message.setPfIds(param.getPfId().toString());
		message.setDealOpType(1);
		adminJmsMessageService.createProfitDetail(message);
		return ErpResponseJson.ok(deposit);
	}
	/**
	 * 定金代付業主
	 * flj 2019-09-23
	 * @param param
	 * @return
	 * @throws Exception2
	 */
	@ApiOperation("代付业主定金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDeposit.class, message = "成功")
	})
	@RequestMapping("/payDepositToOwner")
	public ErpResponseJson payDepositToOwner(@Valid @RequestBody PayDepositToOwnerParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		Operator operator = getOperator();
		GeneralParam generalParam = new GeneralParam(operator);
		param.setGeneralParam(generalParam);
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(generalParam.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		param.setDeposit(oldModel);
		List<DepositVO> list = null;
		if (oldModel.getDealId()!=null) {
			list = erpFunDepositMapper.selectDepositListByDealId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getDealId(), null);
		} else {
			list = erpFunDepositMapper.selectDepositListByHouseCustId(generalParam.getCityId(), generalParam.getCompId(), oldModel.getCustId(), oldModel.getCustType(), oldModel.getCaseId(), oldModel.getCaseType(), null);
		}
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：0 默认 1.转房源，2.代付，3.转拥，4.退款
		for (DepositVO vo:list) {
			if (Byte.valueOf("0").equals(vo.getDepositStatus())) {
				throw new BusinessException("存在未审核的定金，不允许代付！");
			}
			if (Byte.valueOf("0").equals(vo.getOperationType())) {
				balance = balance.add(vo.getReceiptMoney());
			} else if (Byte.valueOf("3").equals(vo.getOperationType()) || Byte.valueOf("6").equals(vo.getOperationType()) || Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {
				//转佣的，代付的，退款的
				balance = balance.subtract(vo.getReceiptMoney());
			}
		}
		if (balance.compareTo(param.getCommssion())<0) {
			throw new BusinessException("定金余额不足！");
		}
		List<Integer> houseIdList = new ArrayList<>();
		houseIdList.add(oldModel.getCaseId());
		
		Map<Integer,HouseInfoVO> houseInfoMap = getHouseInfoByHouseIds(operator.getCityId(), operator.getCompId(), houseIdList, oldModel.getCaseType().intValue());
		param.setHouseInfo(houseInfoMap.get(oldModel.getCaseId()));
		
		ErpFunDeposit deposit = erpFunDepositService.payDepositToOwner(param);
		return ErpResponseJson.ok(deposit);
	}
	
	/**
	 * 获取诚意金日志列表
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("定金日志列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunDepositLog.class, message = "成功")
	})
	@RequestMapping("/getDepositLogList")
	public ErpResponseJson getDepositLogList(@Valid @RequestBody QueryDepositLogParam param) throws Exception {
		Operator operator = getOperator();
		ErpFunDeposit oldModel = new ErpFunDeposit();
		oldModel.setShardCityId(operator.getCityId());
		oldModel.setId(param.getId());
		oldModel = erpFunDepositMapper.selectByPrimaryKey(oldModel);
		List<DepositVO> list = null;
		if (oldModel.getDealId()!=null) {
			list = erpFunDepositMapper.selectDepositListByDealId(operator.getCityId(), operator.getCompId(), oldModel.getDealId(), null);
		} else {
			list = erpFunDepositMapper.selectDepositListByHouseCustId(operator.getCityId(), operator.getCompId(), oldModel.getCustId(), oldModel.getCustType(), oldModel.getCaseId(), oldModel.getCaseType(), null);
		}
		List<Integer> idList = list.stream().collect(Collectors.mapping(DepositVO::getId, Collectors.toList()));
		ErpFunDepositLogExample erpFunDepositLogExample = new ErpFunDepositLogExample();
		erpFunDepositLogExample.setShardCityId(operator.getCityId());
		erpFunDepositLogExample.setOrderByClause("CREATE_TIME DESC");
		erpFunDepositLogExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andDepositIdIn(idList);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunDepositLog> recordList = erpFunDepositLogMapper.selectByExample(erpFunDepositLogExample);
		PageInfo<ErpFunDepositLog> pageInfo = new PageInfo<ErpFunDepositLog>(recordList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	

	/**
	 * 获取房源信息
	 * @param cityId
	 * @param compId
	 * @param houseIds
	 * @param caseType
	 * @return
	 */
	private Map<Integer,HouseInfoVO> getHouseInfoByHouseIds (Integer cityId, Integer compId, List<Integer> houseIds ,Integer caseType) {
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			List<HouseInfoVO> custList = erpFunSaleMapper.selectHouseInfoListByIds(cityId, compId, houseIds);
			return custList.stream().collect(Collectors.toMap(HouseInfoVO::getHouseId, a->a));
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			List<HouseInfoVO> custList = erpFunLeaseMapper.selectHouseInfoListByIds(cityId, compId, houseIds);
			return custList.stream().collect(Collectors.toMap(HouseInfoVO::getHouseId, a->a));
		}
		return Collections.emptyMap();
	}

	/**
	 * 获取客源信息
	 * @param cityId
	 * @param compId
	 * @param houseIds
	 * @param caseType
	 * @return
	 */
	private Map<Integer,CustInfoVO> getCustInfoByCustIds (Integer cityId, Integer compId, List<Integer> custIds ,Integer caseType) {
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			List<CustInfoVO> custList = erpFunBuyCustomerMapper.selectCustInfoListByIds(cityId, compId, custIds);
			return custList.stream().collect(Collectors.toMap(CustInfoVO::getCustId, a->a));
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			List<CustInfoVO> custList = erpFunRentCustomerMapper.selectCustInfoListByIds(cityId, compId, custIds);
			return custList.stream().collect(Collectors.toMap(CustInfoVO::getCustId, a->a));
		}
        return Collections.emptyMap();
	}



	/**
	 * title ：分页查询和列表查询
	 * athor：lcb
	 * date  : 2017/10/26
	 */
	private List<ErpFunEarbestMoneyDto> getList(Integer isPageQuery, QueryErpEarbestMoneyListParam param ) {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
			//模糊检索包括客户姓名
//			param.setCustName("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());

		if (StringUtils.isNotBlank(param.getTypes())) {
			String[] types = param.getTypes().replaceAll("\\s", "").split(",");
			List<Integer> typeList = Stream.of(types).filter(NumberUtils::isNumber).map(Integer::parseInt).collect(Collectors.toList());
			param.setTypeList(typeList);
		}else {
			param.setTypeList(null);
		}
		/*if (Objects.nonNull(param.getStatus()) && Byte.valueOf("1").equals(param.getStatus())) {//查询审核时 只查询收诚意金的审核记录 why？guizhidao
			param.setTypeList(Collections.singletonList(0));
		}*/
		if (param.getUserId()!=null) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getUserId());
			if (erpFunUsers==null) {
				throw new BusinessException("此员工不存在！");
			}
			if (erpFunUsers.getUserLevel()!=null) {
				param.setUserLevel(erpFunUsers.getUserLevel()+2);
			}
		}
		if(1 == isPageQuery) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		}else {
			PageHelper.startPage(1, 1800, false);
		}
		param.setIsNewOrganization(getOperator().newOrganizationType());
		List<ErpFunEarbestMoneyDto> list =  erpEarbestMoneyMapper.selectEarbestMoneyListNew(param.getCityId(),param);
		List<Integer> userIds = new ArrayList<>();
		if(null != list && !list.isEmpty()){
			List<Integer> receiptUserIds = list.stream().filter(val -> null != val.getReceiptUserId()).collect(Collectors.mapping(ErpFunEarbestMoneyDto::getReceiptUserId, Collectors.toList()));
			userIds.addAll(receiptUserIds);
			List<Integer> createUserIds = list.stream().filter(val -> null != val.getCreateUser()).collect(Collectors.mapping(ErpFunEarbestMoneyDto::getCreateUser, Collectors.toList()));
			userIds.addAll(createUserIds);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getErpFunUsersList(param.getCityId(), userIds);
			Map<Integer, ErpFunUsers> userMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val ->val));
			List<Integer> saleIdList = list.stream().filter(a->Integer.valueOf("1").equals(getCaseType(a.getCaseNo()))).map(ErpFunEarbestMoneyDto::getCaseId).collect(Collectors.toList());
			List<Integer> leaseIdList = list.stream().filter(a->Integer.valueOf("2").equals(getCaseType(a.getCaseNo()))).map(ErpFunEarbestMoneyDto::getCaseId).collect(Collectors.toList());
			Map<Integer,HouseInfoVO> saleHouseInfoMap = Collections.emptyMap();
			if (saleIdList!=null && !saleIdList.isEmpty()) {
				saleHouseInfoMap = getHouseInfoByHouseIds(param.getCityId(), param.getCompId(), saleIdList, Const.DIC_CASE_TYPE_SALE_FUN);
			}
			Map<Integer,HouseInfoVO> leaseHouseInfoMap = Collections.emptyMap();
			if (leaseIdList!=null && !leaseIdList.isEmpty()) {
				leaseHouseInfoMap = getHouseInfoByHouseIds(param.getCityId(), param.getCompId(), leaseIdList, Const.DIC_CASE_TYPE_LEASE_FUN);
			}
			for(ErpFunEarbestMoneyDto erpFunEarbestMoneyDto : list){
				Integer createUser = erpFunEarbestMoneyDto.getCreateUser();
				ErpFunUsers createFunUsers = userMap.get(createUser);
				if(null != createFunUsers){
					erpFunEarbestMoneyDto.setCreateGrId(createFunUsers.getGrId());
					erpFunEarbestMoneyDto.setCreateDeptId(createFunUsers.getDeptId());
				}
				Integer receiptUserId = erpFunEarbestMoneyDto.getReceiptUserId();
				ErpFunUsers receiptFunUsers = userMap.get(receiptUserId);
				if(null != receiptFunUsers){
					erpFunEarbestMoneyDto.setReceiptGrId(receiptFunUsers.getGrId());
				}

				HouseInfoVO houseInfoVo = null;
				if (Integer.valueOf("1").equals(getCaseType(erpFunEarbestMoneyDto.getCaseNo()))) {
					houseInfoVo = saleHouseInfoMap.get(erpFunEarbestMoneyDto.getCaseId());
				}
				if (Integer.valueOf("2").equals(getCaseType(erpFunEarbestMoneyDto.getCaseNo()))) {
					houseInfoVo = leaseHouseInfoMap.get(erpFunEarbestMoneyDto.getCaseId());
				}
				if (houseInfoVo!=null) {
					BeanUtils.copyProperties(houseInfoVo, erpFunEarbestMoneyDto);
					erpFunEarbestMoneyDto.setHouseRoom(Optional.ofNullable(houseInfoVo.getHouseRoom()).map(Integer::byteValue).orElse(null));
					erpFunEarbestMoneyDto.setHouseHall(Optional.ofNullable(houseInfoVo.getHouseHall()).map(Integer::byteValue).orElse(null));
					erpFunEarbestMoneyDto.setHouseWei(Optional.ofNullable(houseInfoVo.getHouseWei()).map(Integer::byteValue).orElse(null));
					erpFunEarbestMoneyDto.setHouseArea(houseInfoVo.getHouseArea());
					erpFunEarbestMoneyDto.setHousePrice(houseInfoVo.getHousePrice());
					erpFunEarbestMoneyDto.setHousePriceUnit(houseInfoVo.getHousePriceUnit());
				}
				erpFunEarbestMoneyDto.setAuditDeptId(erpFunEarbestMoneyDto.getConfirmDeptId());
				erpFunEarbestMoneyDto.setAuditDeptName(erpFunEarbestMoneyDto.getConfirmDeptName());
				erpFunEarbestMoneyDto.setAuditUserId(erpFunEarbestMoneyDto.getConfirmUserId());
				erpFunEarbestMoneyDto.setAuditUserName(erpFunEarbestMoneyDto.getConfirmUserName());
				erpFunEarbestMoneyDto.setAuditTime(erpFunEarbestMoneyDto.getConfirmTime());
				erpFunEarbestMoneyDto.setBillCodeNo(erpFunEarbestMoneyDto.getReceiptNo());
				if (null != erpFunEarbestMoneyDto.getDealId()&&Objects.nonNull(erpFunEarbestMoneyDto.getDealNo())) {
					erpFunEarbestMoneyDto.setDealStatus(1);
				}
			}
		}
		return list;
	}

	/**
	 * 查询诚意金列表-导出
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/new/getEarbestMoneyListForExport")
	public ErpResponseJson getEarbestMoneyListForExport(@Valid @RequestBody QueryErpEarbestMoneyListParam param) throws Exception {
		List<ErpFunEarbestMoneyDto> list = getList(0, param);
		return ErpResponseJson.ok(list);
	}

	/**
	 * 新增诚意金
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("创建诚意金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/new/createDealFunEarbestMoney")
	public ErpResponseJson createDealFunEarbestMoney(@Valid @RequestBody CreateOrUpdateEarbestMoneyParam param) throws Exception {
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setGrId(operator.getGrId());
		if (Objects.isNull(param.getReceiptMoney()) || param.getReceiptMoney() <= 0) {
			throw new BusinessException("请输入金额");
		}
		param.setReceiptNo(param.getBillCodeNo());
		if (StringUtil.isBlank(param.getReceiptNo())) {
			throw new BusinessException("请选择票据编号");
		}
		if (StringUtil.isBlank(param.getCustName()) || StringUtil.isBlank(param.getCustMobile())) {
			throw new BusinessException("请填写客户姓名及电话");
		}
		if (param.getCaseType() != null) {
			if (param.getPerformanceName() != null) {
				param.setCaseType(Integer.parseInt(param.getPerformanceName()));
			}else {
				param.setCaseType(getCaseType(param.getCaseNo()));
			}
		}
		erpFunEarbestMoneyService.createDealFunEarbestMoney(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 编辑诚意金
	 * flj 2017-10-12
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("修改诚意金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/new/updateEarbestMoney")
	public ErpResponseJson updateEarbestMoney(@Valid @RequestBody CreateOrUpdateEarbestMoneyParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setCompId(operator.getCompId());
		param.setDeptName(operator.getDeptCName());
		param.setReceiptNo(param.getBillCodeNo());

		ErpFunEarbestMoney updateModel = new ErpFunEarbestMoney();
		erpFunEarbestMoneyService.updateEarbestMoney(param, updateModel);
		return ErpResponseJson.ok();
	}

	/**
	 * 删除诚意金
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("/deleteEarbestMoney")
//	@NotBlank({"earbestId"})
	public ErpResponseJson deleteEarbestMoney(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId",getOperator().getCityId());
		erpFunEarbestMoneyService.deleteEarbestMoney(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 修改诚意金状态
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @param status:诚意金状态 （0待确认,1已收,2已退,3转定金）
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("诚意金，审核，撤销审核，作废时调用此接口")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/new/updateEarbestMoneyStatus")
	public ErpResponseJson updateEarbestMoneyStatus(@Valid @RequestBody UpdateEarbestStatusParam param) throws Exception {
		Operator operator = getOperator();
		param.setGeneralParam(new GeneralParam(operator));
		param.setFJD(operator.isFangJidi());
		param.setCurrentUserName(getCurrentUserName());
		erpFunEarbestMoneyService.updateEarbestMoneyStatus(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 获取诚意金详情
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping("/getDealFunEarbestMoneyDetail")
//	@NotBlank({"earbestId"})
	public ErpResponseJson getDealFunEarbestMoneyDetail_bak(@Valid @RequestBody DealFunEarbestMoneyDetailParam param) throws Exception {
		ErpFunEarbestMoneyDto result = erpEarbestMoneyMapper.selectEarbestMoneyDetail(getOperator().getCityId(),param.getEarbestId());
		String billPhotoUrl = result.getBillPhoto();
		result.setBillPhoto(CommonUtil.getHousePhoto(billPhotoUrl));
		// dyh 增加返回值archiveId  IM用
		Set<Integer> userIdSet = new HashSet<>();
		userIdSet.add(result.getReceiptUserId());//收款人
		userIdSet.add(result.getCreateUser()); //登记人
		userIdSet.add(result.getConfirmUserId()); //确认人
		userIdSet.add(result.getDepositUserId());//转定金人
		userIdSet.add(result.getRefundUserId()); //退款人
		if (userIdSet.isEmpty()) {
			return ErpResponseJson.ok(result);
		}
		List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIdSet);
		Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
		result.setCreateArchiveId(archiveIdMap.get(result.getCreateUser()));
		result.setReceiptArchiveId(archiveIdMap.get(result.getReceiptUserId()));
		result.setConfirmArchiveId(archiveIdMap.get(result.getConfirmUserId()));
		result.setDepositArchiveId(archiveIdMap.get(result.getDepositUserId()));
		result.setRefundArchiveId(archiveIdMap.get(result.getRefundUserId()));
		return ErpResponseJson.ok(result);
	}


	/**
	 * 获取诚意金详情
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取诚意金详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = EarbestDetailVO.class, message = "成功")
	})
	@PostMapping("/new/getDealFunEarbestMoneyDetail")
	@NotBlank({"earbestId"})
	public ErpResponseJson getDealFunEarbestMoneyDetail(@Valid @RequestBody DealFunEarbestMoneyDetailParam param) throws Exception {
		// 1.首先根据定金id查询当前id，根据是否存在deal_id判断当前是否是转成交了，如果转成交通过dealId查询，否则根据房客源id来查询
		EarbestDetailVO resultVo = new EarbestDetailVO();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunEarbestMoney id = new ErpFunEarbestMoney();
		id.setShardCityId(cityId);
		id.setEarbestId(param.getEarbestId());
		id = erpFunEarbestMoneyMapper.selectByPrimaryKey(id);
		if (Objects.isNull(id)) {
			throw new BusinessException("数据不存在.");
		}
		//拷贝
		EarbestVO voDetail = new EarbestVO();
		resultVo.setDetail(voDetail);
		org.apache.commons.beanutils.BeanUtils.copyProperties(voDetail, id);
		voDetail.setEarbestId(id.getEarbestId());
		voDetail.setBillCodeNo(id.getReceiptNo());
		voDetail.setAuditDeptId(id.getConfirmDeptId());
		voDetail.setAuditDeptName(id.getConfirmDeptName());
		voDetail.setAuditUserId(id.getConfirmUserId());
		voDetail.setAuditUserName(id.getConfirmUserName());
		voDetail.setAuditTime(id.getConfirmTime());
        Integer caseType = getCaseType(id.getCaseNo());
        Integer custType  = getCustType(id.getCustNo());
        voDetail.setCaseType(caseType==0?null:caseType.byteValue());
        voDetail.setCustType(custType==0?null:custType.byteValue());
		voDetail.setBillPhoto(AppConfig.getUserPhotoPicDomainPath(voDetail.getBillPhoto()));

		Map<Integer,HouseInfoVO> houseInfoMap = getHouseInfoByHouseIds(cityId, compId, Collections.singletonList(voDetail.getCaseId()), caseType);
		HouseInfoVO houseInfo = houseInfoMap.get(voDetail.getCaseId());
		if (Objects.nonNull(houseInfo)) {
			org.apache.commons.beanutils.BeanUtils.copyProperties(voDetail, houseInfo);
		}
		Map<Integer,CustInfoVO> custInfoMap = getCustInfoByCustIds(cityId, compId, Collections.singletonList(voDetail.getCustId()), custType);
		CustInfoVO custInfo = custInfoMap.get(voDetail.getCustId());
		if (Objects.nonNull(custInfo)) {
            org.apache.commons.beanutils.BeanUtils.copyProperties(voDetail, custInfo);
		}
		List<ErpFunEarbestMoney> list = null;
		if (voDetail.getDealId()!=null) {
			list = erpFunEarbestMoneyMapper.selectEarbestListByDealId(cityId, compId, id.getDealId());
		} else {
			list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(cityId,operator.getCompId(),id.getCustNo(), id.getCustId(), id.getCaseNo(), id.getCaseId(),false);
		}
        if (list.isEmpty()) {//兼容没有房客源的老数据
            list = new ArrayList<>();
            list.add(id);
        }
		List<EarbestVO> resultList = new ArrayList<>();
		for (ErpFunEarbestMoney obj : list) {
			EarbestVO earbestVO = new EarbestVO();
			resultList.add(earbestVO);
			org.apache.commons.beanutils.BeanUtils.copyProperties(earbestVO, obj);
			earbestVO.setEarbestId(obj.getEarbestId());
			earbestVO.setAuditDeptId(id.getConfirmDeptId());
			earbestVO.setAuditDeptName(id.getConfirmDeptName());
			earbestVO.setAuditUserId(id.getConfirmUserId());
			earbestVO.setAuditUserName(id.getConfirmUserName());
			earbestVO.setAuditTime(id.getConfirmTime());
			earbestVO.setCaseType(getCaseType(obj.getCaseNo()).byteValue());
			earbestVO.setCaseType(getCustType(obj.getCustNo()).byteValue());
			earbestVO.setBillCodeNo(obj.getReceiptNo());
			earbestVO.setCaseType(getCaseType(obj.getCaseNo()).byteValue());
			earbestVO.setBillPhoto(AppConfig.getUserPhotoPicDomainPath(earbestVO.getBillPhoto()));

		}
		resultVo.setList(resultList);
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：默认0,  1.转房源，2.代付，3.转拥，4.退款，5.作废，6.业主佣金 7.转定金，
		int index = -1;
		for (int i=0;i<list.size();i++) {

			ErpFunEarbestMoney vo = list.get(i);
			if (Objects.equals(vo.getEarbestId(), voDetail.getEarbestId())) {
				index = i;
			}
			if (Byte.valueOf("0").equals(vo.getOperationType()) && Byte.valueOf("1").equals(vo.getEarbestStatus())
					|| Byte.valueOf("0").equals(vo.getOperationType()) && Byte.valueOf("0").equals(vo.getEarbestStatus())) {//包含已审核，未审核
				balance = balance.add(new BigDecimal(vo.getReceiptMoney()));
			} else if (Byte.valueOf("3").equals(vo.getOperationType())|| Byte.valueOf("6").equals(vo.getOperationType())
					|| Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {//转拥，代付，退款
				//转佣的，代付的，退款的
				balance = balance.subtract(new BigDecimal((vo.getReceiptMoney())));
			}
		}
		if (balance.compareTo(BigDecimal.ZERO) < 0) {//兼容老数据退款
			balance = BigDecimal.ZERO;
		}
		//移除但当前记录
		if (index >= 0) {
			resultList.remove(index);
		}
		resultVo.setBalance(balance);
		return ErpResponseJson.ok(resultVo);
	}



	private Integer getCustType(String custNo) {
		if (StringUtil.isBlank(custNo)) {
			return 0;
		}
		if (custNo.startsWith("QG")) {
			return 3;
		} else if (custNo.startsWith("QZ")) {
			return 4;
		}
		return 0;
	}

	private Integer getCaseType(String caseNo) {
		if (StringUtil.isBlank(caseNo)) {
			return 0;
		}
		if (caseNo.startsWith("CS")) {
			return 1;
		} else if (caseNo.startsWith("CZ")) {
			return 2;
		}
		return 0;
	}
	/**
	 * 获取诚意金详情
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/new/checkDealReceiptNoRepeat")
	@NotBlank({"earbestId"})
	public ErpResponseJson checkDealReceiptNoRepeat(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId",getOperator().getCityId());
		ErpFunEarbestMoneyDto result = erpEarbestMoneyMapper.selectEarbestMoneyDetail(param.getInteger("cityId"),param.getInteger("earbestId"));
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 获取诚意金日志列表
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/new/getEarbestMoneyLogList")
	@NotBlank({"earbestId"})
	public ErpResponseJson getEarbestMoneyLogList(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer earbestId = param.getInteger("earbestId");
		Integer cityId = getOperator().getCityId();
		ErpFunEarbestMoneyrecordExample example = new ErpFunEarbestMoneyrecordExample();
		example.setShardCityId(cityId);
		example.setOrderByClause("CREATE_TIME DESC");
		Operator operator = getOperator();
		ErpFunEarbestMoney id = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(cityId, earbestId));
		if (id == null) {
			throw new BusinessException("数据不存在");
		}
		List<ErpFunEarbestMoney> list = null;
		ArrayList<Integer> idList = new ArrayList<>();
		idList.add(id.getEarbestId());
		if (id.getDealId()!=null) {
			list = erpFunEarbestMoneyMapper.selectEarbestListByDealId(cityId, operator.getCompId(), id.getDealId());
		} else {
			list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(cityId,operator.getCompId(),id.getCustNo(), id.getCustId(), id.getCaseNo(), id.getCaseId(),false);
		}
		List<Integer> ids = list.stream().map(ErpFunEarbestMoney::getEarbestId).collect(Collectors.toList());
		if (ids!=null && !ids.isEmpty()) {
			idList.addAll(ids);
		}
		example.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andEarbestIdIn(idList);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunEarbestMoneyrecord> recordList = erpFunEarbestMoneyrecordMapper.selectByExample(example);
		PageInfo<ErpFunEarbestMoneyrecord> pageInfo = new PageInfo<ErpFunEarbestMoneyrecord>(recordList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * @tag 删除诚意金
	 * @author 邓永洪
	 * @since 2018/5/29
	 */
//	@RequestMapping("/deleteDealFunEarbestMoney")
	public ErpResponseJson deleteDealFunEarbestMoney(@RequestBody BaseMapParam param) {
		GeneralParam generalParam = new GeneralParam(getOperator());
		Integer earbestId = param.getInteger("earbestId");
		erpFunEarbestMoneyService.deleteDealFunEarbestMoney(generalParam, earbestId);
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 修改诚意金状态
	 * @author 邓永洪
	 * @since 2018/7/24
	 */
//	@ApiOperation("修改诚意金")
//	@ApiResponses(value = {
//			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
//	})
//	@PostMapping("/updateDealFunEarbestMoney")
	public ErpResponseJson updateDealFunEarbestMoney(@RequestBody updateDealFunEarbestParam param) {
		Operator operator = getOperator();
		ErpFunEarbestMoney earbestMoney = new ErpFunEarbestMoney();
		earbestMoney.setEarbestId( param.getEarbestId());
		earbestMoney.setShardCityId(operator.getCityId());
		earbestMoney=erpFunEarbestMoneyMapper.selectByPrimaryKey(earbestMoney);
		ErpFunBillExample billExample=new ErpFunBillExample();
		billExample.setShardCityId(operator.getCityId());
		ErpFunBillExample.Criteria billExampleCriteria = billExample.createCriteria();
		billExampleCriteria.andEarbestIdEqualTo(param.getEarbestId());
		String currUserName = getCurrentUserName();

		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCityId(operator.getCityId());
		erpFunEarbestMoneyService.updateDealFunEarbestMoney(param, earbestMoney, currUserName);
		return ErpResponseJson.ok();
	}
	
	
//	@RequestMapping("/getDealFunEarbestMoneyList")
//	public ErpResponseJson getDealFunEarbestMoneyList(@RequestBody ErpDealEarbestMoneyParam param){
//		param.setSelfCompId(getOperator().getCompId());
//		param.setSelfCityId(getOperator().getCityId());
//		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
////		erpEarbestMoneyMapper
//		return ErpResponseJson.ok();
//	}
	
	/**
	 * 诚意金详情转定金列表
	 * @author HeWei
	 * @since 2018年7月27日 上午11:43:02
	 * @param param
	 * @return
	 * Modified XXX HeWei 2018年7月27日
	 */
//	@ApiOperation("诚意金详情转定金列表")
//	@ApiResponses(value = {
//			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchInnerDealListVo.class, message = "成功")
//	})
//	@PostMapping("/getMatchInnerDealList")
	public ErpResponseJson getMatchInnerDealList(@RequestBody QueryDealListParam param) {
		QueryDealListParam queryDealListParam = getParamObj(QueryDealListParam.class);
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
		erpFunDealExample.setOrderByClause(" SIGN_DATE DESC,DEAL_ID DESC");
		erpFunDealExample.setShardCityId(cityId);
		Criteria createCriteria = erpFunDealExample.createCriteria();
		createCriteria.andCompIdEqualTo(compId).andIsbyhandEqualTo((byte)0);

		if (!CommonUtil.isnull(queryDealListParam.getUserId())) {
			createCriteria.andSignUserIdEqualTo(queryDealListParam.getUserId());
		}

		if (!CommonUtil.isnull(queryDealListParam.getDeptId())) {
			createCriteria.andSignUserDeptIdEqualTo(queryDealListParam.getDeptId());
		}
		if (!CommonUtil.isnull(queryDealListParam.getCaseType())) {
			createCriteria.andDealTypeEqualTo(Byte.valueOf(queryDealListParam.getCaseType()));
		}
		if (!CommonUtil.isnull(queryDealListParam.getContractNo())) {
			createCriteria.andContractNoEqualTo(queryDealListParam.getContractNo());
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunDeal> list = erpFunDealMapper.selectByExample(erpFunDealExample);
		for (ErpFunDeal erpFunDeal : list) {
			if (erpFunDeal.getDealType()!=null && erpFunDeal.getDealType()==101) {
				erpFunDeal.setHouseaddress("[售]"+erpFunDeal.getHouseaddress());
			}else{
				erpFunDeal.setHouseaddress("[租]"+erpFunDeal.getHouseaddress());
			}
		}
		PageInfo<ErpFunDeal> pageInfo = new PageInfo<>(list);
		MatchInnerDealListVo resultVo = new MatchInnerDealListVo(pageInfo);
		return ErpResponseJson.ok(resultVo);
	}




	/**
	 * @param param getEarnestId
	 * @return xxx
	 */
//	@ApiOperation("诚意金撤销审核")
//	@ApiResponses(value = {
//			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
//	})
//	@RequestMapping("/cancelEarnestAudit")
	public ErpResponseJson cancelAudit(@RequestBody CancelAuditParam param) {

		if (Objects.isNull(param.getEarnestId())) {
			throw new com.myfun.framework.exception.BusinessException("参数异常");
		}
		Operator op = getOperator();
		param.setCityId(op.getCityId());
		param.setCompId(op.getCompId());
		param.setCurrUserName(op.getUserName());
		param.setUserId(op.getUserId());
		param.setUserName(op.getUserName());
		param.setDeptId(op.getDeptId());
		erpFunEarbestMoneyService.cancelAudit(param);
		return ErpResponseJson.ok();
	}

	/**
	 * @param param getEarnestId
	 * @return xxx
	 */
//	@ApiOperation("作废诚意金")
//	@ApiResponses(value = {
//			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
//	})
//	@RequestMapping("/cancellationEarnest")
	public ErpResponseJson cancellationEarnest(@RequestBody CancellationParam param) {

		if (Objects.isNull(param.getEarnestId())) {
			throw new com.myfun.framework.exception.BusinessException("参数异常");
		}
		Operator op = getOperator();
		param.setCityId(op.getCityId());
		param.setCompId(op.getCompId());
		param.setCurrUserName(op.getUserName());
		param.setDeptId(op.getDeptId());
		erpFunEarbestMoneyService.cancellationEarnest(param);
		return ErpResponseJson.ok();
	}
	@ApiOperation("诚意金转房源")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/new/transEarbestHouse")
	public ErpResponseJson transEarnestHouse(@RequestBody TransEarnestHouseParam param) throws Exception {

		checkTransHouseParam(param);
		Operator operator = getOperator();
		param.setFJD(operator.isFangJidi());
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		param.setCityId(operator.getCityId());
		erpFunEarbestMoneyService.transEarnestHouse(param);
		return ErpResponseJson.ok();
	}




	@ApiOperation("诚意金转定金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/new/transToDeposit")
	public ErpResponseJson transToDeposit(@RequestBody TransToDepositParam param) {
		Operator op = getOperator();
		param.setCityId(op.getCityId());
		param.setCompId(op.getCompId());
		param.setUserId(op.getUserId());
		param.setUserName(op.getUserName());
		param.setFJD(op.isFangJidi());
		erpFunEarbestMoneyService.transToDeposit(param);
		return ErpResponseJson.ok();
	}
	/**
	 * 转佣金的时候 a.是否所有审核通过 a.验证余额还能够转佣金 b.生成财务款项c.写合同日志d.生成一条转佣的记录，状态已经审核，已转佣
	 */
	@ApiOperation("诚意金转佣金")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/new/transEarnestToCommssion")
	public ErpResponseJson tansToBrokerage(@RequestBody TransEarnestToBrokerageParam param) throws Exception {

		//1.转佣金的时候 a.是否所有审核通过 a.验证余额还能够转佣金 b.生成财务款项c.写合同日志d.生成一条转佣的记录，状态已经审核，已转佣
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		ErpFunEarbestMoney record = new ErpFunEarbestMoney();
		record.setShardCityId(cityId);
		record.setEarbestId(param.getEarbestId());
		record = erpFunEarbestMoneyService.selectByPrimaryKey(record);
		if (Objects.isNull(record)) {
			throw new BusinessException("数据不存在");
		}
		if (record.getOperationType() == 1) {
			throw new BusinessException("该条已转房源");
		}
		if (record.getOperationType() == 7) {
			throw new BusinessException("该条已转定金");
		}
        if (Objects.isNull(record.getDealId())) {
            throw new BusinessException("未成交不能转佣");
        }
		judgeAllChecked(cityId, compId, record,"还存在未审核的诚意金，不能操作转佣金！");
		judgeRemaining(param.getCommssion(), cityId, compId, record,"诚意金余额不足以支持转佣金！",false);
		Operator op = getOperator();
		param.setCityId(op.getCityId());
		param.setCompId(op.getCompId());
		param.setUserId(op.getUserId());
		param.setUserName(op.getUserName());
		param.setCurrentUserName(getCurrentUserName());
		param.setDeptId(op.getDeptId());
		param.setDeptName(op.getDeptName());
		param.setGeneralParam(new GeneralParam(op));
		erpFunEarbestMoneyService.transEarnestToBroker(param);

		UpdateFunProfitMessage message = new UpdateFunProfitMessage();
		message.setCityId(cityId);
		message.setCompId(compId);
		message.setDealId(record.getDealId());
		message.setPfIds(param.getPfId().toString());
		message.setDealOpType(1);
		adminJmsMessageService.createProfitDetail(message);
		return ErpResponseJson.ok();
	}
	/**
	 * 代付业主
	 * @return
	 */
	@ApiOperation("代付")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/new/transEarnestToProprietor")
	public ErpResponseJson transToProprietor(@RequestBody TransEarnestToProprietorParam param) throws Exception {

		Operator op = getOperator();
		param.setCompId(op.getCompId());
		param.setDeptId(op.getDeptId());
		param.setDeptName(op.getDeptName());
		param.setCityId(op.getCityId());
		param.setUserId(op.getUserId());
		param.setUserName(op.getUserName());
		param.setCurrentUserName(getCurrentUserName());
		Assert.isNullThrow(param.getEarbestId(),"参数异常");
		ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(param.getCityId(), param.getEarbestId()));
		Assert.isNullThrow(record,"数据不存在");
//		judgeAllChecked(param.getCityId(),param.getCompId(),record,"还存在未审核的诚意金，不能操作代付！");
		judgeRemaining(param.getPayMoney(),param.getCityId(),param.getCompId(),record,"诚意金余额不足以支持代付！",false);
		//代付业主
		erpFunEarbestMoneyService.transEarnestToProprietor(param);

		return ErpResponseJson.ok();
	}

    @ApiOperation("诚意金退款")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/new/refundEarnestHouse")
    public ErpResponseJson refundEarnestHouse(@RequestBody RefundMoneyParam param) throws Exception {
        Operator op = getOperator();
        Assert.isTrueThrow(Objects.isNull(param.getEarbestId())||Objects.isNull(param.getRefundMoney()),"参数异常");
        ErpFunEarbestMoney record = erpFunEarbestMoneyMapper.selectByPrimaryKey(new ErpFunEarbestMoney(op.getCityId(), param.getEarbestId()));
        Assert.isTrueThrow(!Objects.equals(record.getEarbestStatus(),(byte)1),"不能退款");
        judgeRemaining(param.getRefundMoney(), op.getCityId(), op.getCompId(), record,"诚意金余额不足以支持退款！",true);
//        judgeAllChecked(op.getCityId(),op.getCompId(),record,"还存在未审核的诚意金，不能操作退款！");

		param.setFJD(op.isFangJidi());
        param.setCompId(op.getCompId());
        param.setUserId(op.getUserId());
        param.setCityId(op.getCityId());
        param.setUserName(op.getUserName());
        param.setDeptId(op.getDeptId());
        param.setDeptName(op.getDeptName());
        erpFunEarbestMoneyService.refundEarnestHouse(param);
        return ErpResponseJson.ok();
    }
	/**
	 * 判断 是否还存在未审核的佣金
	 * @param cityId
	 * @param compId
	 * @param record
	 */
	private void judgeAllChecked(Integer cityId, Integer compId, ErpFunEarbestMoney record,String errMsg) {
		Integer count;
		if (record.getDealId()!=null) {
			count = erpFunEarbestMoneyMapper.countEarbestListByDealId(cityId, compId, record.getDealId());
		} else {
			count = erpFunEarbestMoneyMapper.countEarbestListByHouseCustId(cityId, compId, record.getCustNo(),record.getCustId(),record.getCaseNo(),record.getCaseId());
		}
		if (count>0) {
			throw new BusinessException(errMsg);
		}
	}

	/**
	 * 判断余额
	 * @param commssion
	 * @param cityId
	 * @param compId
	 * @param record
	 */
	private void judgeRemaining(BigDecimal commssion, Integer cityId, Integer compId, ErpFunEarbestMoney record,String errMsg,boolean needAudit) {
		List<ErpFunEarbestMoney> list;
		if (record.getDealId()!=null) {
			list = erpFunEarbestMoneyMapper.selectEarbestListByDealId(cityId, compId, record.getDealId());
		} else {
			list = erpFunEarbestMoneyMapper.selectEarbestListByHouseCustId(cityId, compId,  record.getCustNo(),record.getCustId(), record.getCaseNo(),record.getCaseId(),needAudit);
		}
		BigDecimal balance = BigDecimal.ZERO;
		//OPERATION_TYPE	操作类别：默认0,  1.转房源，2.代付，3.转客户拥，4.退款，5.作废，6.转业主佣金，7.转定金
		for (ErpFunEarbestMoney vo:list) {
			if (Byte.valueOf("0").equals(vo.getOperationType()) && Byte.valueOf("1").equals(vo.getEarbestStatus())
					|| Byte.valueOf("0").equals(vo.getOperationType()) && Byte.valueOf("0").equals(vo.getEarbestStatus())) {//包含已审核，未审核
				balance = balance.add(new BigDecimal(vo.getReceiptMoney()));
			} else if (Byte.valueOf("3").equals(vo.getOperationType())|| Byte.valueOf("6").equals(vo.getOperationType())
					|| Byte.valueOf("2").equals(vo.getOperationType()) || Byte.valueOf("4").equals(vo.getOperationType())) {//转拥，代付，退款
				//转佣的，代付的，退款的
				balance = balance.subtract(new BigDecimal((vo.getReceiptMoney())));
			}
		}
		if (balance.compareTo(commssion)<0) {
			throw new BusinessException(errMsg);
		}
	}
	/**
	 * @param param check
	 */
	private void checkTransHouseParam(TransEarnestHouseParam param) {
		if (Objects.isNull(param.getEarbestId()) || Objects.isNull(param.getCaseId()) || Objects.isNull(param.getCaseType())) {
			throw new com.myfun.framework.exception.BusinessException("参数异常");
		}
		if (!Objects.equals(Const.DIC_CASE_TYPE_SALE_FUN, param.getCaseType()) && !Objects.equals(Const.DIC_CASE_TYPE_LEASE_FUN, param.getCaseType())) {
			throw new com.myfun.framework.exception.BusinessException("房源参数异常");
		}
	}
	
	public static void main(String[] args) {
		BigDecimal zero = new BigDecimal("10.05");
		System.out.println(NumberHelper.formatNumber(zero.toString(), NumberHelper.NUMBER_IN_2));
		
	}
	
}

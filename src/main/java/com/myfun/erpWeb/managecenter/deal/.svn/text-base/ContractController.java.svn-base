package com.myfun.erpWeb.managecenter.deal;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.github.pagehelper.Page;
import com.myfun.erpWeb.managecenter.constract.param.DealCodeParam;
import com.myfun.erpWeb.managecenter.param.ContractParam;
import com.myfun.erpWeb.managecenter.param.DealStatictisListParam;
import com.myfun.erpWeb.managecenter.vo.DealBusinessVo;
import com.myfun.erpWeb.managecenter.vo.DealStatictisListVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunProfitDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dto.ErpFunDealCodeDto;
import com.myfun.service.business.erpdb.ErpFunDealCodeService;
import com.myfun.service.business.erpdb.ErpFunDealCodelogService;
import com.myfun.utils.BeanUtil;

/**
 * 合同号管理
 * @author 何传强
 * @since 2017年7月5日
 */
@Api(tags = "合同号管理模块")
@Controller
@RequestMapping("/managecenter/deal")
public class ContractController extends BaseController{
	@Autowired
	private ErpFunDealCodeService erpFunDealCodeService;
	@Autowired
	private ErpFunDealCodeMapper erpFunDealCodeMapper;
	@Autowired
	private ErpFunDealCodelogService erpFunDealCodelogService;
	@Autowired
	private ErpFunDealCodelogMapper erpFunDealCodelogMapper;
	@Autowired
	private ErpFunDealMapper erpFunDealMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	private ErpSysParaService erpSysParaService;
	
	/**
	 * 获取合同编号列表
	 * @author 何传强
	 * @since 2017年7月5日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDealFunDealCodeList")
	public ErpResponseJson getDealFunDealCodeList(@Valid @RequestBody BaseMapParam param){
		param.setInteger("cityId", getOperator().getCityId());
		//param.setInteger("deptId", getOperator().getDeptId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("newOrganization", getOperator().newOrganizationType() ? 1 : 0);
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		String isExport = param.getString("isExport");
		if (StringUtils.isNotBlank(startTime)) {
			param.setString("startTime", startTime + " 00:00:00");
		}
		if (StringUtils.isNotBlank(endTime)) {
			param.setString("endTime", endTime + " 23:59:59");
		}
		
		if(param.getInteger("userId") !=null){
			ErpFunUsers erpFunUsers =  erpFunUsersMapper.selectByUserId(getOperator().getCityId(), param.getInteger("userId"));
			if(erpFunUsers != null){
				param.setInteger("userLevel", erpFunUsers.getUserLevel() +2);
			}
		}
		
		Map<String, Object> resultMap = new HashMap<>();
		Integer total=0;
		// 是否导出报表
		if ("1".equals(isExport)) {
			// 不分页
			List<ErpFunDealCode> dealCodeListExport = erpFunDealCodeMapper.getDealFunDealCodeList(param.getInteger("cityId"), param.getMap());
			resultMap.put("dealCodeList", dealCodeListExport);
		} else {
			// 分页
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			List<ErpFunDealCode> dealCodeList = erpFunDealCodeMapper.getDealFunDealCodeList(param.getInteger("cityId"), param.getMap());
			PageInfo<ErpFunDealCode> pageInfo = new PageInfo<>(dealCodeList);
			resultMap.put("dealCodeList", pageInfo.getList());
			total=dealCodeList.size();
		}
		//分配已使用统计
		ErpFunDealCodeDto dealCountInfo = erpFunDealCodeMapper.getDealCountInfo(param.getInteger("cityId"),param.getMap());
		resultMap.put("dealCodeCount", dealCountInfo);
		List<Map<String,Object>> returnList = new ArrayList<>();
		returnList.add(resultMap);
		ErpResponseJson responseJson = ErpResponseJson.ok(returnList);
		responseJson.setTotal(Long.valueOf(total));
		return responseJson;
	}
	
	/**
	 * 合同号段停用和启用
	 * @author 何传强
	 * @since 2017年7月6日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateDealFunDealCode")
	public ErpResponseJson updateDealFunDealCode(@Valid @RequestBody BaseMapParam param) {
		param.setInteger("deptId", getOperator().getDeptId());
		Integer cityId = getOperator().getCityId();
		erpFunDealCodeService.updateDealFunDealCode(cityId, param.getMap());
		erpFunDealCodelogService.updateFunDealCodeLog(cityId, param.getMap());
		return ErpResponseJson.ok();
	}
	
	/**
	 * 添加合同号段
	 * @author 何传强
	 * @since 2017年7月11日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createDealFunDealCode")
	public ErpResponseJson createDealFunDealCode(@Valid @RequestBody BaseMapParam param) {
		ErpFunDealCode erpFunDealCode = BeanUtil.populate(param.getMap(), ErpFunDealCode.class);
		Integer cityId = getOperator().getCityId();
		erpFunDealCode.setCreateTime(new Date());
		erpFunDealCode.setCreateUser(getOperator().getUserId());
		erpFunDealCode.setCreateUserName(getOperator().getUserName());
		erpFunDealCode.setUsedCount(0);
		String zeroStr = param.getString("zeroStr");
		Integer organizationId = param.getInteger("organizationId");
		String codeStart = erpFunDealCode.getCodeStart();
		erpFunDealCode.setTotalCount((Integer.valueOf(erpFunDealCode.getCodeEnd()) - Integer.valueOf(codeStart)) + 1);
		
		param.setInteger("codeNoLen", (erpFunDealCode.getCodePrefix()+erpFunDealCode.getCodeEnd()).length());
		param.setInteger("compId", getOperator().getCompId());
		param.setString("codePrefix", erpFunDealCode.getCodePrefix());
		param.setString("codeCountStart", erpFunDealCode.getCodeStart());
		param.setString("codeCountEnd", erpFunDealCode.getCodeEnd());
		if (StringUtils.isNotBlank(zeroStr)) {
			codeStart = zeroStr + codeStart;
		}
		int count = erpFunDealCodelogMapper.countModelData(cityId, param.getMap());
		if (count > 0) {
			return ErpResponseJson.warn("合同编码分配和已分配的编码重复!");
		}
		erpFunDealCode.setStatus((byte) 1);
		erpFunDealCode.setCodeStart(codeStart);
		erpFunDealCode.setCompId(getOperator().getCompId());
		erpFunDealCode.setShardCityId(cityId);
		erpFunDealCode.setOrganizationId(organizationId);
		erpFunDealCodeService.createDealFunDealCode(erpFunDealCode);
		createFunDealCodeLogList(erpFunDealCode,erpFunDealCode.getCodeId(),param);
		return ErpResponseJson.ok();
	}

	private void createFunDealCodeLogList(ErpFunDealCode erpFunDealCode, Integer codeId, BaseMapParam param) {
		String zeroStr = param.getString("zeroStr");
		if (StringUtils.isBlank(zeroStr)) {
			zeroStr = "";
		}
		String codePrefix = erpFunDealCode.getCodePrefix();
		String codeStart = erpFunDealCode.getCodeStart().substring(zeroStr.length());
		Integer start = Integer.valueOf(codeStart);
		String codeEnd = erpFunDealCode.getCodeEnd();
		Integer end = Integer.valueOf(codeEnd);
		int codeLength = codeEnd.length();
		List<ErpFunDealCodelog> list = new ArrayList<ErpFunDealCodelog>();
		String zeroaddStr = "";
		for (int i = 0; i <= (end - start); i++) {
			ErpFunDealCodelog erpFunDealCodelog = new ErpFunDealCodelog();
			Integer codeCount = start + i;
			zeroaddStr = "";
			for (int j = 0; j < (codeLength - codeCount.toString().length()); j++) {
				zeroaddStr += "0";
			}
			erpFunDealCodelog.setCodeId(codeId);
			erpFunDealCodelog.setCodeNo(codePrefix+zeroaddStr+(start+i));
			erpFunDealCodelog.setCodeCount(codeCount);
			erpFunDealCodelog.setCodePrefix(codePrefix);
			erpFunDealCodelog.setCompId(getOperator().getCompId());
			erpFunDealCodelog.setUseStatus((byte) 0);
			erpFunDealCodelog.setShardCityId(getOperator().getCityId());
			list.add(erpFunDealCodelog);
		}
		erpFunDealCodelogService.createBatchFunDealCodeLogList(list);
	}
	
	/**
	 * 合同号段详情查询
	 * @author 何传强
	 * @since 2017年7月12日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getDealFunDealCodeInfo")
	public ErpResponseJson getDealFunDealCodeInfo(@Valid @RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		List<ErpFunDeal> dealList = erpFunDealMapper.getDealFunDealCodeInfo(getOperator().getCityId(),param.getMap());
		ErpResponseJson responseJson = ErpResponseJson.ok(dealList);
		responseJson.setTotal(Long.valueOf(dealList.size()));
		return responseJson;
	}

	/**
	 * 成交统计-获取成交统计列表
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/17
	 * @return
	 *
	 */
	@ApiOperation("获取成交统计列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealStatictisListVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getMgrDealStatictisList")
	public ErpResponseJson getMgrDealStatictisList(@Valid @RequestBody DealStatictisListParam param) {
		Integer userId = param.getUserId();
		String dataRange = param.getDataRange();
		String orderBy = param.getOrderBy();
		String dateType = param.getDateType();
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String startDate=null;
		String endDate=null;

		param.setCompId(compId);
		if (orderBy == null) {// 默认排序
			orderBy = "B.SIGN_DATE DESC";
		}
		param.setOrderBy(orderBy);

		if (StringUtil.isNotBlank(dataRange)) {
			String[] val = dataRange.split("~");
			// 必须是两个单位
			if (val.length == 2 && val[0]!=null && val[1]!=null) {
				// 此逻辑有效期至 9999 年
				if (val[0].length() <= "2015-05".length()) {
					val[0] = CommonUtil.getFirstDateOfMonth(val[0] + "-01");
				}
				if (val[1].length() <= "2015-05".length()) {
					val[1] = CommonUtil.getFirstDateOfNextMonth(val[1] + "-01");
				} else {
					val[1] = CommonUtil.getNextDate(val[1]);// 返回的年月日
				}
				startDate=val[0];
				endDate=val[1];
			}
		}
		param.setStartDate(startDate);
		param.setEndDate(endDate);
		param.setDateType(dateType);
		if(getOperator().newOrganizationType()){
			param.setIsNewOrganization(true);
		}
		if (null != userId) {// 部门查询
			ErpFunUsers user = erpFunUsersMapper.selectByUserId(cityId, userId);
			param.setArchiveId(user.getArchiveId());
		}
		// 手动统计条数
		Integer totalCount = erpFunDealMapper.getPageCountByMap(cityId,param);
		if (totalCount == null || totalCount == 0) {
			return ErpResponseJson.ok();
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<ErpFunDeal> list = erpFunDealMapper.getDealListByMap(cityId,param);
		List<Integer> dealIds = list.stream().collect(Collectors.mapping(ErpFunDeal::getDealId,Collectors.toList()));
		param.setCompId(compId);
		Map<Integer,List<ErpFunProfit>> erpFunProfitMap=new HashedMap();
		if (dealIds.size()>0){
			List<ErpFunProfit> erpFunProfits = erpFunProfitMapper.getProfitByMap(cityId,param,dealIds);
			//将dealId相同的重组
			for(ErpFunProfit erpFunProfit:erpFunProfits){
				Integer dealId = erpFunProfit.getDealId();
				if(erpFunProfitMap.containsKey(dealId)){
					erpFunProfitMap.get(dealId).add(erpFunProfit);
				}else{
					List<ErpFunProfit> erpFunProfits1 = new ArrayList<>();
					erpFunProfits1.add(erpFunProfit);
					erpFunProfitMap.put(dealId,erpFunProfits1);
				}
			}
		}

		List<ErpFunDealDto> dealList = new LinkedList<>();
		for (ErpFunDeal funDeal : list) {
			List<ErpFunProfit> funProfitPOs = erpFunProfitMap.get(funDeal.getDealId());
			if (funProfitPOs == null) {
				continue;
			}
			for (ErpFunProfit funProfit : funProfitPOs) {
				ErpFunDealDto deal = new ErpFunDealDto();
				try {
					BeanUtilsHelper.copyProperties(deal,funDeal);
				} catch (Exception e) {
					throw new BusinessException("数据异常，请重试或联系在线客服！", e);
				}
				deal.setUserId(funProfit.getUserId());
				deal.setDeptId(funProfit.getDeptId());
				deal.setReceivableMoney(funProfit.getReceivableMoney());
				deal.setProfitProportion(funProfit.getProfitProportion());
				deal.setProfitMoney(funProfit.getProfitMoney());
				deal.setPerformanceName(funProfit.getPerformanceName());
				deal.setPerformanceType(funProfit.getPerformanceType());
				dealList.add(deal);
			}
		}
		Map<String, Object> moneyMap = new HashMap<>();
		Map<String,Object> dealMapper=erpFunProfitMapper.getProfitData(cityId,param);
		moneyMap.put("realMoney", dealMapper.get("TOTAL_REAL_INCOME"));// ss
		moneyMap.put("totalMoney", dealMapper.get("TOTAL_NEED_INCOME"));// ys
//		List<Map<String, String>> dealMap = BeanUtil.listObjToMapAndunPackBaseBean(dealList);
		PageInfo<ErpFunDeal> erpFunDealPageInfo = new PageInfo<>(list);
		erpFunDealPageInfo.setTotal(totalCount);
		ErpResponseJson ok = ErpResponseJson.ok(erpFunDealPageInfo);
		// 设置返回值
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("resultList", dealList);
//		paramMap.put("dataList", list);
		paramMap.put("money", moneyMap);
		ok.setData(paramMap);
		return ok;
	}

	/**
	 * 设置合同号使用规则
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/19
	 */
	@ApiOperation("设置合同号使用规则")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/updateContracNoUseRule")
	public ErpResponseJson updateContracNoUseRule(@Valid @RequestBody ContractParam param) {
		String isSplit = param.getSaleRentDealRepeat();// 买卖、租赁合同编号分开判重
		// 1是0否
		String isAllow = param.getAllowUnuseDealnoIsbyhand();// 允许手动录入未使用的自动分配的合同编号
		// 1是0否
		String isCan = param.getInvalidDealnoCanUseAgain();// 作废的合同编号可以重新使用

		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		// 作废的合同编号可以重新使用 1是0否 控制是 否 是 否的切换
		erpFunDealCodeService.updateCode(cityId,compId,isCan,isSplit,isAllow);
		return ErpResponseJson.ok();
	}

	/**
	 * 删除合同号段
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/19
	 */
	@ApiOperation("删除合同号段")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class,message = "success")})
	@ResponseBody
	@PostMapping("/deleteDealFunDealCode")
	public ErpResponseJson deleteDealFunDealCode(@Valid @RequestBody DealCodeParam param) {
		Integer codeId = param.getCodeId();
		Integer cityId=getOperator().getCityId();
		erpFunDealCodeService.deleteByCodeId(cityId,codeId);
		return ErpResponseJson.ok();
	}
}

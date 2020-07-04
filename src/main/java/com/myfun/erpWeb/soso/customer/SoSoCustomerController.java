package com.myfun.erpWeb.soso.customer;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.erpWeb.soso.param.DeductCostParam;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.agencydb.dao.AgencyPurchaseBorkerMapper;
import com.myfun.repository.agencydb.dao.AgencyVipBuyMapper;
import com.myfun.repository.agencydb.dao.AgencyVipRentMapper;
import com.myfun.repository.agencydb.dao.AgencyWebClientMapper;
import com.myfun.repository.agencydb.dto.AgencyVipBuyDto;
import com.myfun.repository.agencydb.dto.AgencyVipBuyListDto;
import com.myfun.repository.agencydb.dto.AgencyVipLeaseDto;
import com.myfun.repository.agencydb.dto.AgencyVipRentDto;
import com.myfun.repository.agencydb.po.AgencyPurchaseBorker;
import com.myfun.repository.agencydb.po.AgencyWebClient;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyDataParam;
import com.myfun.service.business.agencydb.bean.param.SoSoBuyListParam;
import com.myfun.service.business.searchdb.SearchSosoViewService;
import com.myfun.utils.DateConvert;
import com.myfun.utils.StringUtil;

/**
 * 搜搜客源控制器
 * @author 张宏利
 * @since 2016年8月30日
 */
@RestController
@RequestMapping(value="/soso/customer")
public class SoSoCustomerController extends BaseController{
	
	@Autowired SearchSosoViewService searchSosoViewService;
	@Autowired AgencyVipBuyMapper agencyVipBuyMapper;
	@Autowired AgencyPurchaseBorkerMapper agencyPurchaseBorkerMapper;
	@Autowired AgencyWebClientMapper agencyWebClientMapper;
	@Autowired AgencyVipRentMapper agencyVipRentMapper;
	
	private static final int GIFT_PRICE = 5; // 首次购买赠送5元花费
	private static final int CALL_NUM = 5; // 购买一次的拨打次数
	
	/**
	 * 获取搜搜求购列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getSoSoBuyList")
	public ResponseJson getSoSoBuyList(@Valid @RequestBody SoSoBuyListParam param){
		this.createLikeElement(param);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyVipBuyListDto> resultList = agencyVipBuyMapper.getSoSoBuyList(param);
		PageInfo<AgencyVipBuyListDto> pageInfo = new PageInfo<AgencyVipBuyListDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 解密电话
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("解密电话")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOPhone")
	public ResponseJson deductCost(@Valid @RequestBody DeductCostParam param) throws Exception{
		String caseType = param.getCaseType();// 房源类型
		Integer caseId = param.getCaseId();// 房源ID
		String source = param.getSource();// 来源
		String sosoType = param.getSosoType();// 搜搜类型
		List<Map<String, String>> result = null;
		if ("SOSO".equals(source)) {
			searchSosoViewService.decodeSosoPhone(sosoType, caseId, getOperator().getUaId(), getOperator().getArchiveId());
		} else {
			result = searchSosoViewService.decodeNotSosoPhone(caseType, caseId, getOperator().getUaId(),
					getOperator().getCityId(), getOperator().getArchiveId(),
					getOperator().getUserName(), getOperator().getUserMobile(), getOperator().getAdminDeptId());
		}
		return new ErpResponseJson(result);
	}

	/**
	 * 获取搜搜求购详情
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getVipBuyData")
	public ResponseJson getVipBuyData(@Valid @RequestBody SoSoBuyDataParam param){
		param.setArchiveId(getOperator().getArchiveId());
		param.setCityId(getOperator().getCityId());
		// 获取详细信息
		AgencyVipBuyDto vipEl = null;
		try {
			vipEl = agencyVipBuyMapper.getVipBuyById(param.getCaseId(), param.getCityId());
		} catch (Exception e) {
			return null;
		}
		vipEl.setCallNum(CALL_NUM);
		vipEl.setGiftPrice(GIFT_PRICE);
		// 获取当前用户对当前数据的查看情况
		AgencyPurchaseBorker purchaseBorker = agencyPurchaseBorkerMapper.getPurchaseBorker(param.getCityId(), param.getCaseId(), param.getCaseType(), param.getArchiveId());
		AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
		if(webClientPO != null){
			vipEl.setClientMobile(StringUtil.encodeMobile(webClientPO.getClientMobile()));
			vipEl.setClientName(webClientPO.getClientName());
		}
		if (purchaseBorker != null) {
			// 如果已经查看
			vipEl.setCallCount(1);
			vipEl.setBuyCount(1);
			if (purchaseBorker.getCallCount() > 0) {
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			// 返回用户姓名
			vipEl.setPerpetualFlag(1);
			vipEl.setPbTime(purchaseBorker.getPbTime());
		}
		return ErpResponseJson.ok(vipEl);
	}
	
	/**
	 * 获取搜搜求购已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getVipBuyViewedList")
	public ResponseJson getVipBuyViewedList(@Valid @RequestBody SoSoBuyListParam param){
		this.createLikeElement(param);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyVipBuyListDto> resultList = agencyVipBuyMapper.getVipBuyViewedList(param);
		PageInfo<AgencyVipBuyListDto> pageInfo = new PageInfo<AgencyVipBuyListDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取搜搜求购列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getSoSoRentList")
	public ResponseJson getSoSoRentList(@Valid @RequestBody SoSoBuyListParam param){
		this.createLikeElement(param);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyVipLeaseDto> resultList = agencyVipRentMapper.getSoSoRentList(param);
		PageInfo<AgencyVipLeaseDto> pageInfo = new PageInfo<AgencyVipLeaseDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取搜搜求租已查看列表
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/getVipRentViewedList")
	public ResponseJson getVipRentViewedList(@Valid @RequestBody SoSoBuyListParam param){
		this.createLikeElement(param);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyVipLeaseDto> resultList = agencyVipRentMapper.getVipRentViewedList(param);
		PageInfo<AgencyVipLeaseDto> pageInfo = new PageInfo<AgencyVipLeaseDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 生成档案ID，城市ID，区域和关键字模糊匹配项
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 */
	private void createLikeElement(SoSoBuyListParam param){
		param.setArchiveId(getOperator().getArchiveId());
		param.setCityId(getOperator().getCityId());
		if(StringUtils.isNotBlank(param.getTime())){
			String[] date = DateConvert.getConditionDateForSoso(param.getTime());
			param.setTime1(date[0]);
			param.setTime2(date[1]);
		}
		String region = param.getRegion();
		if(StringUtils.isNotBlank(region)){
			String[] regions = region.split(" ");
			for (int i = 0; i < regions.length; i++) {
				String string = regions[i];
				regions[i] = "%" + string + "%";
			}
			param.setRegions(regions);
		}
		if(StringUtils.isNotBlank(param.getKeywords())){
			param.setKeywords("%"+param.getKeywords()+"%");
		}
	}

	/**
	 * 搜搜求租详情
	 * @author 李成兵
	 * @return
	 */
	@RequestMapping(value="/getVipRentData")
	public ResponseJson getVipRentData(@Valid @RequestBody SoSoBuyDataParam param){
		param.setArchiveId(getOperator().getArchiveId());
		param.setCityId(getOperator().getCityId());
		// 获取详细信息
		AgencyVipRentDto vipEl = null;
		try {
			vipEl = agencyVipRentMapper.getVipRentById(param.getCaseId(), param.getCityId());
		} catch (Exception e) {
			return null;
		}
		vipEl.setCallNum(CALL_NUM);
		vipEl.setGiftPrice(GIFT_PRICE);
		// 获取当前用户对当前数据的查看情况
		AgencyPurchaseBorker purchaseBorker = agencyPurchaseBorkerMapper.getPurchaseBorker(param.getCityId(), param.getCaseId(), param.getCaseType(), param.getArchiveId());
		AgencyWebClient webClientPO = agencyWebClientMapper.selectByPrimaryKey(Integer.valueOf(vipEl.getClientId()));
		if(webClientPO != null){
			vipEl.setClientMobile(StringUtil.encodeMobile(webClientPO.getClientMobile()));
			vipEl.setClientName(webClientPO.getClientName());
		}
		if (purchaseBorker != null) {
			// 如果已经查看
			vipEl.setCallCount(1);
			vipEl.setBuyCount(1);
			if (purchaseBorker.getCallCount() > 0) {
				vipEl.setClientMobile(webClientPO.getClientMobile());
			}
			// 返回用户姓名
			vipEl.setPerpetualFlag(1);
			vipEl.setPbTime(purchaseBorker.getPbTime());
		}
		return ErpResponseJson.ok(vipEl);
	}
}

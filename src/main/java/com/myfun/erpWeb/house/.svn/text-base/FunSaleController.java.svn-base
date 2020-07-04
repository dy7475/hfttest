package com.myfun.erpWeb.house;

import static com.myfun.utils.StringUtil.convertStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.myfun.service.business.erpdb.ErpSysParaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.house.vo.FunSaleDto;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminTrueHouseComplaintMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunCaseFavoriteMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunHouseBiddingMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyRemarkMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseToSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunPolicyControlMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleToLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpRichTextMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunLeaseDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunCaseFavorite;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunHouseBidding;
import com.myfun.repository.erpdb.po.ErpFunKeyRemark;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseToSale;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPolicyControl;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleToLease;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpRichText;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.bean.param.QueryHouseCustDetailParam;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateConvert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SyncUtil;

@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class FunSaleController extends BaseController{
	
	@Autowired
	ErpFunSaleService erpFunSaleService;
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunSaleToLeaseMapper erpFunSaleToLeaseMapper;
	@Autowired
	ErpFunLeaseToSaleMapper erpFunLeaseToSaleMapper;
	@Autowired
	ErpRichTextMapper erpRichTextMapper;
	@Autowired
	AdminTrueHouseComplaintMapper adminTrueHouseComplaintMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	ErpFunCaseFavoriteMapper erpFunCaseFavoriteMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	ErpFunKeyRemarkMapper erpFunKeyRemarkMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired
	ErpFunPolicyControlMapper erpFunPolicyControlMapper;

	/**
	 * 加密数据请求--普通map--通过
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get1")
	public String get1(HttpServletRequest request,@Valid @RequestBody BaseMapParam mapParam){
		Integer caseId = StringUtil.parseInteger(mapParam.getString("CASE_ID"));
		Integer cityId = getOperator().getCityId();
		erpFunSaleService.getFunSale(caseId, cityId);
		return "getSaleInfoBySaleId-->OK-->"+mapParam.getString("CASE_ID");
	}
	
	/**
	 * 加密数据请求--实体类--通过
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/get2")
	public String get2(HttpServletRequest request,@Valid @RequestBody QueryHouseCustDetailParam mapParam){
		Integer cityId = getOperator().getCityId();
		System.out.println("saleId1=" + mapParam.getCASE_ID());
		System.out.println("saleId2=" + getOperator().getCompId());
		ErpFunSale erpFunSale = erpFunSaleService.getFunSale(mapParam.getCASE_ID(), cityId);
		return new ErpResponseJson(erpFunSale).toJson();
	}

	/**
	 * 出售房源匹配求购客户
	 * @author 臧铁
	 * @param param  caseId 房客源ID  date 时间范围 deptId 门店ID  matchType   sourceDeptId
	 * @param param  bound 匹配范围 0 全公司【本公司】 范围 1 共享圈 范围 3 好友圈 范围 CITY_SHARE 匹配城市公盘，排除本公司范围
	 * @param param  plateType 盘别 1抢盘2私盘3公盘  orderBy 排序方式
	 * @since 2017年5月23日
	 * @return
	 * 
	 * 陈文超
	 * 该方法已停用，并移植到houseCustWeb项目中2019-11-22
	 */
	@ResponseBody
	@RequestMapping(value = "/getMatchBuyCustomerList")
	@Deprecated
	public ResponseJson getMatchBuyCustomerList(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("currentUserId", getOperator().getUserId());
		param.setInteger("currentGrId", getOperator().getGrId());
		param.setInteger("currentDeptId", getOperator().getDeptId());
		param.setInteger("currentRegId", getOperator().getRegId());
		param.setInteger("currentAreaId", getOperator().getAreaId());
		param.setInteger("currentCompId", getOperator().getCompId());
		param.setInteger("compType", getOperator().getCompType());
		param.setString("userPosition", getOperator().getUserPosition());
		param.setObject("isPerLogin", getOperator().isPerLogin());
		if (null != getOperator().getAttribute("compIds")) {
			String[] compIds = ((String) getOperator().getAttribute("compIds")).split(",");
			param.setObject("compIds", compIds);
		}

		String date = param.getString("date");
		String compBound = param.getString("bound");
		Integer currentDeptId = param.getInteger("currentDeptId");
		Integer currentGrId = param.getInteger("currentGrId");
		Integer currentAreaId = param.getInteger("currentAreaId");
		Integer currentRegId = param.getInteger("currentRegId");
		String orderBy = param.getString("orderBy");
		Integer caseId = param.getInteger("caseId");
		Integer cityId = param.getInteger("cityId");
		Integer currentCompId = param.getInteger("currentCompId");
		String userPosition = param.getString("userPosition");
		String matchItem = param.getString("matchItem");
		Integer currentUserId = param.getInteger("currentUserId");
		Integer compType = param.getInteger("compType");
		Boolean isPerLogin = (Boolean) param.getObject("isPerLogin");
		if (StringUtil.isNotBlank(date)) {
			String[] conStr = DateConvert.getConditionDate(date);
			param.setString("creationTime1", conStr[0]);
			param.setString("creationTime2", conStr[1]);
		}
		ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
		if (erpFunSale == null) {
			throw new BusinessException("请求的房源未找到");
		}
		if (null != erpFunSale.getBuildId()) {
			param.setString("buildId", "%" + erpFunSale.getBuildId() + "%");
		}
		// 这个不能为null
		if (StringUtils.isBlank(matchItem)) {
			matchItem = "";
		}
		if (matchItem.contains("AREA")) {
			param.setObject("area", erpFunSale.getSaleArea());
		}
		if (matchItem.contains("FLOOR")) {
			param.setObject("floor", erpFunSale.getSaleFloor());
		}
		if (matchItem.contains("PRICE")) {
			param.setObject("totalPrice", erpFunSale.getSaleTotalPrice());
		}
		if (matchItem.contains("ROOM")) {
			param.setObject("saleRoom", erpFunSale.getSaleRoom());
		}
		param.setObject("saleUseage", erpFunSale.getSaleUseage());
		param.setObject("region", erpFunSale.getSaleReg());
		String isUseCreationTimeQuery =erpSysParaMapper.getParamValue(cityId,currentCompId,"IS_USE_CREATION_TIME_QUERY");
		param.setString("isUseCreationTimeQuery",isUseCreationTimeQuery);
		if (StringUtil.isBlank(orderBy)){
			if ("1".equals(isUseCreationTimeQuery)) {
				param.setString("orderBy", "CREATION_TIME DESC");
			}else {
				param.setString("orderBy", "AVAILABLE_TIME DESC");
			}
		}
		if (isPerLogin == null || !isPerLogin) {// 不是精英版登录才判断权限
			String operColumn = erpUserOpersService.conditionMixByOperRange(Constants_DIC.DIC_PLATE_TYPE_ALL_EN, Constants_DIC.DIC_CASE_TYPE_BUY_CUST, cityId, currentCompId, currentUserId, currentGrId, compType, userPosition);
			if ("AREA".equals(operColumn)) {
				param.setString("operColumn", "AREA_ID");
				param.setInteger("operValue", currentAreaId);
			} else if ("REG".equals(operColumn)) {
				param.setString("operColumn", "REG_ID");
				param.setInteger("operValue", currentRegId);
			} else if ("DEPT".equals(operColumn)) {
				param.setString("operColumn", "DEPT_ID");
				param.setInteger("operValue", currentDeptId);
			} else if ("GROUP".equals(operColumn)) {
				param.setString("operColumn", "GR_ID");
				param.setInteger("operValue", currentGrId);
			}
		}
		List<ErpFunBuyCustomer> buyCustomerList = erpFunBuyCustomerMapper.getMatchBuyCustomerList(cityId, param.getMap());
		ErpResponseJson json = new ErpResponseJson();
		if (StringUtil.isBlank(compBound) || Constants_DIC.DIC_BOUND_0.equals(compBound)) {
			json.setData(buyCustomerList);
			return json;
		}
		if (buyCustomerList == null || buyCustomerList.size() <= 0) {
			json.setData(buyCustomerList);
			return json;
		}
		Set<Integer> userIdSet = new HashSet<>();
		buyCustomerList.stream().forEach(erpFunBuyCustomer -> {
			userIdSet.add(erpFunBuyCustomer.getUserId());
		});
		if(userIdSet.size() > 0) {// 有用户id时才查询
			List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
			Map<Integer, ErpFunUsers> userMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
			// 拼userName
			List<ErpFunBuyCustomerDto> resultVos = new LinkedList<>();
			buyCustomerList.stream().forEach(erpFunBuyCustomer -> {
				ErpFunUsers funUsers = userMap.get(erpFunBuyCustomer.getUserId());
				ErpFunBuyCustomerDto erpFunBuyCustomerDto = new ErpFunBuyCustomerDto();
				erpFunBuyCustomerDto.setErpFunBuyCustomer(erpFunBuyCustomer);
				if (funUsers != null) {
					erpFunBuyCustomerDto.setUserName(funUsers.getUserName());
				}
				resultVos.add(erpFunBuyCustomerDto);
			});
			json.setData(resultVos);
			return json;
		}
		json.setData(buyCustomerList);
		json.setTotal(Long.valueOf(buyCustomerList.size()));
		return json;
	}
	
	/**
	 * 房源管理-首页-查询房源列表
	 * @author 朱科
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getHouseSaleList")
	public ResponseJson getHouseSaleList(@Valid @RequestBody QueryHouseCustListParam param){
		Operator operator = getOperator();
		param.setSelfCityId(operator.getCityId());
		param.setCityId(operator.getCityId());
		param.setSelfCompId(operator.getCompId());
		param.setSelfAreaId(operator.getAreaId());
		param.setSelfRegId(operator.getRegId());
		param.setSelfDeptId(operator.getDeptId());
		param.setSelfGrId(operator.getGrId());
		param.setSelfUserId(operator.getUserId());
		param.setSelfCompModel(operator.isJoinCompModel());
		param.setSelfCompNo(operator.getCompNo());
		param.setSelfIsYouUser(operator.isYouJiaUser());
		param.setSelfUserPosition(operator.getUserPosition());
		param.setSelfCompType(operator.getCompType());
		param.setSelfArchiveId(operator.getArchiveId());
		PageInfo<FunSaleDto> houseSaleList = erpFunSaleService.getHouseSaleList(param);
		ErpResponseJson json = new ErpResponseJson();
		json.setData(houseSaleList);
		json.setTotal(houseSaleList.getTotal());
		return json;
	}
	
	/**
	 * 获取房源出售数据
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/7
	 */
	@ResponseBody
	@RequestMapping(value = "/getHouseSaleData")
	public ResponseJson getHouseSaleData(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer caseType = param.getInteger("caseType");
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseId = param.getInteger("caseId");
		ErpFunSaleDto funSaleVO = new ErpFunSaleDto();
		ErpFunSale funSale = (ErpFunSale) this.getHouseAndHiddenBaseInfo(caseId, caseType);
		String proxyUrl = funSale.getProxyUrl()==null ? "0" : "1";
		funSaleVO.setProxyUrl(proxyUrl);
		String checkCodeUrl = funSale.getCheckCodeUrl()==null ? "0" : "1";
		funSaleVO.setCheckCodeUrl(checkCodeUrl);
		
		ErpRichText richText = erpRichTextMapper.getHouseRichText(cityId, caseId, caseType);
		if (null != richText) {
			funSaleVO.setRichText(richText.getRichText());
			funSaleVO.setRichTextFitment(richText.getRichText());
			funSaleVO.setRichTextLayout(richText.getRichTextLayout());
			funSaleVO.setRichTextRights(richText.getRichTextRights());
			funSaleVO.setOnlyTextCore(richText.getOnlyTextCore());
			funSaleVO.setOnlyTextFitment(richText.getOnlyTextFitment());
			funSaleVO.setOnlyTextLayout(richText.getOnlyTextLayout());
			funSaleVO.setOnlytextRight(richText.getOnlyTextRights());
			if (StringUtil.isNotBlank(richText.getOnlyTextCore())) {
				funSaleVO.setSaleCharact(richText.getOnlyTextCore());
			}
		}
		// 自己的房源
		if (getOperator().getUserId().equals(funSale.getUserId())) {// USER_ID可能为null
			funSaleVO.setUserName(getOperator().getUserName());
			funSaleVO.setUserRight(StringUtil.parseInteger(getOperator().getUserRight()));
			List<AdminTrueHouseComplaint> complaintList = null;
			if (funSale.getSaleId() != null) {
				complaintList = adminTrueHouseComplaintMapper.getComplaintListNotDel(new Integer[]{funSale.getSaleId()}, Const.DIC_CASE_TYPE_SALE_FUN, getOperator().getUserId(), cityId, compId);
			}
			if (complaintList != null && complaintList.size() > 0) {
				AdminTrueHouseComplaint complaint = complaintList.get(0);
				funSaleVO.setTrueComplaintType(complaint.getComplaintType());// 投诉状态
				funSaleVO.setTrueCreationTime(complaint.getCreationTime());// 投诉时间
				funSaleVO.setTrueAppealTime(complaint.getAppealTime());// 申诉时间
				funSaleVO.setTrueDealContent(complaint.getDealContent());// 处理描述
				funSaleVO.setTrueDealStatus(complaint.getDealStatus());// 处理状态
				funSaleVO.setTrueDealType(complaint.getDealType());// 处理类型
			}
		} else if (funSale.getUserId() != null && !Const.DIC_SYSTEM_USERID_999.equals(funSale.getUserId())) {
			ErpFunUsers funUsers = erpFunUsersMapper.getByUserIdAndDeptId(cityId, funSale.getUserId(), funSale.getDeptId());
			if (funUsers != null) {
				// 查询实名认证
				AdminFunArchive archivePO = adminFunArchiveMapper.queryAdminFunArchiveId(funUsers.getArchiveId());
				funSaleVO.setUserName(funUsers.getUserName());
				funSaleVO.setUserMobile(funUsers.getUserMobile());
				funSaleVO.setUserRight(archivePO.getUserRight());
			}
		}
		// 到图片列表找个图片--认证真房源要显示一张图片
		ErpFunPhoto funPhoto = erpFunPhotoMapper.getFunPhoto(cityId, caseId, Const.DIC_CASE_TYPE_SALE_FUN);// 只查一条记录
		ErpFunCaseFavorite funCaseFavorite = erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId, caseId, Const.DIC_CASE_TYPE_SALE_FUN, getOperator().getUserId());
		if (null != funCaseFavorite) {
			funSaleVO.setFavoriteId(funCaseFavorite.getFavoriteId());
		}
		if (funPhoto != null) {
			funSaleVO.setThumbUrl(funPhoto.getPhotoAddr());
		}
		ErpFunDepts fundDepts = null;
		
		String[] paramIds = new String[]{"IS_SHOW_HOUSE_ROOF", "IS_SHOW_HOUSE_UNIT", "IS_SHOW_HOUSE_NUM", "SHOW_SHOP_OTHER_ADDR"};
//		List<ErpSysPara> erpSysParaList = erpSysParaMapper.selectByParams(cityId, getOperator().getCompId(), paramIds);
		List<ErpSysPara> erpSysParaList = erpSysParaService.getMLSysParamListDefEmpty(cityId, getOperator().getCompId(),getOperator().getUserId(), Arrays.asList(paramIds));
		Map<String, String> resMap = erpSysParaList.stream().collect(Collectors.toMap(key -> key.getParamId(), val -> val.getParamValue()));
		
		String isShowHouseRoof = resMap.get("IS_SHOW_HOUSE_ROOF");
		String isShowHouseUnit = resMap.get("IS_SHOW_HOUSE_UNIT");
		String isShowHouseNum = resMap.get("IS_SHOW_HOUSE_NUM");
		String showShopOtherAddr = resMap.get("SHOW_SHOP_OTHER_ADDR");
		if (compId.equals(funSale.getCompId())) {
			fundDepts = erpFunDeptsMapper.getByDeptId(cityId, funSale.getDeptId());
		} else {
			fundDepts = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, funSale.getCompId(), funSale.getDeptId());
		}
		funSale.hideCoreInfo(isShowHouseRoof, isShowHouseUnit, isShowHouseNum, showShopOtherAddr);
		if (fundDepts != null) {
			funSaleVO.setDeptName(fundDepts.getDeptName());
			funSaleVO.setDeptPhone(fundDepts.getDeptTele());
		}
		try {
			BeanUtil.copyObject(funSale, funSaleVO);
		} catch (Exception e) {
			throw new ConfirmException("对象拷贝失败", e);
		}
		if (!funSale.getSaleKey()) {
			List<ErpFunKeyRemark> funKeyRemarkList = erpFunKeyRemarkMapper.getFunKeyRemarkListByCaseIds(cityId, compId, funSale.getSaleId(), Const.DIC_CASE_TYPE_SALE_FUN);
			if (funKeyRemarkList != null && funKeyRemarkList.size() > 0) {
				String remark = funKeyRemarkList.get(0).getRemark();
				funSaleVO.setKeyNote(remark);
				
			}
		}
		if (erpFunSaleService.dealInfoIsLock(funSale, cityId, compId, getOperator().getUserId())) {
			funSaleVO.setDealLockFlag("1");
		} else {
			funSaleVO.setDealLockFlag("0");
		}
		funSaleVO.setQrcodeAddr(this.getTxWebOrHaoFangLink(
				funSale.getArchiveId(), funSale.getSaleId(),
				Const.DIC_CASE_TYPE_SALE_FUN, funSale.getSalePublish(),
				funSale.getVideoNum(), funSale.getPanoramaMap()));
		// 查询推广情况
		List<Integer> saleId = new ArrayList<Integer>();
		saleId.add(funSale.getSaleId());
		List<ErpFunHouseBidding> listByCaseIds = erpFunHouseBiddingMapper.getFunHouseBiddingList(cityId, Const.HOUSE_BIDDING_YY_STATUS_1,
				Const.DIC_CASE_TYPE_SALE_FUN, saleId);
		funSaleVO.setBiddingStatus("0");
		if (null != listByCaseIds && listByCaseIds.size() > 0) {
			funSaleVO.setBiddingStatus("1");
		}
		// 查询租售详情信息  该房源出租的部分信息
		if (funSale.getIsSaleLease() == 1) {// IS_SALE_LEASE是否是租售房源，1=是，默认=0=否
			ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, funSale.getSaleLeaseId());
			if (funLease != null) {
				funSaleVO.setBuildId(funLease.getBuildId());
				funSaleVO.setLeaseId(funLease.getLeaseId());
				funSaleVO.setLeaseUseage(funLease.getLeaseUseage());
				funSaleVO.setLeaseStatus(funLease.getLeaseStatus());
				funSaleVO.setPriceUnit(funLease.getPriceUnit());
				funSaleVO.setLeaseTotalPrice(funLease.getLeaseTotalPrice());
			}
		}
		Integer compare = 0;
		if (funSale.getModifyPriceEnd() != null) {
			compare = DateTimeHelper.compareTwoDate(new Date(), funSale.getModifyPriceEnd());
		}
		ErpFunPolicyControl policyControl = null;
		if (compare == 1) {
			policyControl = erpFunPolicyControlMapper.getPolicyControl(cityId, funSale.getSaleId(), Const.DIC_CASE_TYPE_SALE_FUN);
		}
		if (policyControl != null) {
			funSaleVO.setModifyPriceStart(policyControl.getModifyPriceStart());// 修改价格时间
			funSaleVO.setModifyPriceBefor(policyControl.getModifyPriceBefor());// 修改之前的价格
			funSaleVO.setModifyPriceAfter(policyControl.getModifyPriceAfter());// 修改之后的价格
		} else {
			funSaleVO.setModifyPriceEnd(null);
			funSaleVO.setModifyPriceTrend(null);
		}
		return ErpResponseJson.ok(funSaleVO);
	}
	
	/**
	 * 获取房源出租信息
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/7
	 */
	@ResponseBody
	@RequestMapping(value = "/getHouseLeaseData")
	public ResponseJson getHouseLeaseData(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer caseType = param.getInteger("caseType");
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseId = param.getInteger("caseId");
		ErpFunLeaseDto funLeaseDto = new ErpFunLeaseDto();
		ErpFunLease funLease = (ErpFunLease) this.getHouseAndHiddenBaseInfo(caseId, caseType);
		String proxyUrl = StringUtils.isBlank(funLease.getProxyUrl()) ? "0" : "1";
		funLeaseDto.setProxyUrl(proxyUrl);
		
		ErpRichText richText = erpRichTextMapper.getHouseRichText(cityId, caseId, caseType);
		if (null != richText) {
			funLeaseDto.setRichText(richText.getRichText());
			funLeaseDto.setRichTextFitment(richText.getRichText());
			funLeaseDto.setRichTextLayout(richText.getRichTextLayout());
			funLeaseDto.setRichTextRights(richText.getRichTextRights());
			funLeaseDto.setOnlyTextCore(richText.getOnlyTextCore());
			funLeaseDto.setOnlyTextFitment(richText.getOnlyTextFitment());
			funLeaseDto.setOnlyTextLayout(richText.getOnlyTextLayout());
			funLeaseDto.setOnlytextRight(richText.getOnlyTextRights());
			if (StringUtil.isNotBlank(richText.getOnlyTextCore())) {
				funLeaseDto.setLeaseCharact(richText.getOnlyTextCore());
			}
		}
		// 自己的房源
		if (getOperator().getUserId().equals(funLease.getUserId())) {// USER_ID可能为null
			funLeaseDto.setUserName(getOperator().getUserName());
			funLeaseDto.setUserRight(StringUtil.parseInteger(getOperator().getUserRight()));
			List<AdminTrueHouseComplaint> complaintList = null;
			if (funLease.getLeaseId() != null) {
				complaintList = adminTrueHouseComplaintMapper.getComplaintListNotDel(new Integer[]{funLease.getLeaseId()}, Const.DIC_CASE_TYPE_LEASE_FUN, getOperator().getUserId(), cityId, compId);
			}
			if (complaintList != null && complaintList.size() > 0) {
				AdminTrueHouseComplaint complaint = complaintList.get(0);
				funLeaseDto.setTrueComplaintType(complaint.getComplaintType());// 投诉状态
				funLeaseDto.setTrueCreationTime(complaint.getCreationTime());// 投诉时间
				funLeaseDto.setTrueAppealTime(complaint.getAppealTime());// 申诉时间
				funLeaseDto.setTrueDealContent(complaint.getDealContent());// 处理描述
				funLeaseDto.setTrueDealStatus(complaint.getDealStatus());// 处理状态
				funLeaseDto.setTrueDealType(complaint.getDealType());// 处理类型
			}
		} else if (funLease.getUserId() != null && !Const.DIC_SYSTEM_USERID_999.equals(funLease.getUserId())) {
			ErpFunUsers funUsers = erpFunUsersMapper.getByUserIdAndDeptId(cityId, funLease.getUserId(), funLease.getDeptId());
			if (funUsers != null) {
				// 查询实名认证
				AdminFunArchive archivePO = adminFunArchiveMapper.queryAdminFunArchiveId(funUsers.getArchiveId());
				funLeaseDto.setUserName(funUsers.getUserName());
				funLeaseDto.setUserMobile(funUsers.getUserMobile());
				funLeaseDto.setUserRight(archivePO.getUserRight());
			}
		}
		// 到图片列表找个图片--认证真房源要显示一张图片
		ErpFunPhoto funPhoto = erpFunPhotoMapper.getFunPhoto(cityId, caseId, Const.DIC_CASE_TYPE_LEASE_FUN);// 只查一条记录
		ErpFunCaseFavorite funCaseFavorite = erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId, caseId, Const.DIC_CASE_TYPE_LEASE_FUN, getOperator().getUserId());
		if (null != funCaseFavorite) {
			funLeaseDto.setFavoriteId(funCaseFavorite.getFavoriteId());
		}
		if (funPhoto != null) {
			funLeaseDto.setThumbUrl(funPhoto.getPhotoAddr());
		}
		ErpFunDepts fundDepts = null;
		
		String[] paramIds = new String[]{"IS_SHOW_HOUSE_ROOF", "IS_SHOW_HOUSE_UNIT", "IS_SHOW_HOUSE_NUM", "SHOW_SHOP_OTHER_ADDR"};
//		List<ErpSysPara> erpSysParaList = erpSysParaMapper.selectByParams(cityId, getOperator().getCompId(), paramIds);
		List<ErpSysPara> erpSysParaList = erpSysParaService.getMLSysParamListDefEmpty(cityId, getOperator().getCompId(),getOperator().getUserId(), Arrays.asList(paramIds));
		Map<String, String> resMap = erpSysParaList.stream().collect(Collectors.toMap(key -> key.getParamId(), val -> val.getParamValue()));
		
		String isShowHouseRoof = resMap.get("IS_SHOW_HOUSE_ROOF");
		String isShowHouseUnit = resMap.get("IS_SHOW_HOUSE_UNIT");
		String isShowHouseNum = resMap.get("IS_SHOW_HOUSE_NUM");
		String showShopOtherAddr = resMap.get("SHOW_SHOP_OTHER_ADDR");
		if (compId.equals(funLease.getCompId())) {
			fundDepts = erpFunDeptsMapper.getByDeptId(cityId, funLease.getDeptId());
		} else {
			fundDepts = erpFunDeptsMapper.getDeptByCompIdAndDeptId(cityId, funLease.getCompId(), funLease.getDeptId());
		}
		funLease.hideCoreInfo(isShowHouseRoof, isShowHouseUnit, isShowHouseNum, showShopOtherAddr);
		if (fundDepts != null) {
			funLeaseDto.setDeptName(fundDepts.getDeptName());
			funLeaseDto.setDeptPhone(fundDepts.getDeptTele());
		}
		try {
			BeanUtil.copyObject(funLease, funLeaseDto);
		} catch (Exception e) {
			throw new ConfirmException("对象拷贝失败", e);
		}
		
		if (!funLease.getLeaseKey()) {
			List<ErpFunKeyRemark> funKeyRemarkList = erpFunKeyRemarkMapper.getFunKeyRemarkListByCaseIds(cityId, compId, funLease.getLeaseId(), Const.DIC_CASE_TYPE_LEASE_FUN);
			if (funKeyRemarkList != null && funKeyRemarkList.size() > 0) {
				String remark = funKeyRemarkList.get(0).getRemark();
				funLeaseDto.setKeyNote(remark);
				
			}
		}
		if (erpFunSaleService.dealInfoIsLock(funLease, cityId, compId, getOperator().getUserId())) {
			funLeaseDto.setDealLockFlag("1");
		} else {
			funLeaseDto.setDealLockFlag("0");
		}
		funLeaseDto.setQrcodeAddr(this.getTxWebOrHaoFangLink(
				funLease.getArchiveId(), funLease.getLeaseId(),
				Const.DIC_CASE_TYPE_LEASE_FUN, funLease.getLeasePublish(),
				funLease.getVideoNum().byteValue(), funLease.getPanoramaMap()));
		// 查询推广情况
		List<Integer> leaseId = new ArrayList<Integer>();
		leaseId.add(funLease.getLeaseId());
		List<ErpFunHouseBidding> listByCaseIds = erpFunHouseBiddingMapper.getFunHouseBiddingList(cityId, Const.HOUSE_BIDDING_YY_STATUS_1,
				Const.DIC_CASE_TYPE_LEASE_FUN, leaseId);
		funLeaseDto.setBiddingStatus("0");
		if (null != listByCaseIds && listByCaseIds.size() > 0) {
			funLeaseDto.setBiddingStatus("1");
		}
		// 查询出售详情信息  该房源出租的部分信息
		if (funLease.getIsSaleLease() == 1) {// IS_SALE_LEASE是否是租售房源，1=是，默认=0=否
			ErpFunSale funSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, funLease.getSaleLeaseId());
			if (funLease != null) {
				funLeaseDto.setBuildId(funSale.getBuildId());
				funLeaseDto.setSaleId(funSale.getSaleId());
				funLeaseDto.setSaleUseage(funSale.getSaleUseage());
				funLeaseDto.setSaleStatus(funSale.getSaleStatus());
				funLeaseDto.setSaleUnitPrice(funSale.getSaleUnitPrice());
				funLeaseDto.setSaleTotalPrice(funSale.getSaleTotalPrice());
			}
		}
		Integer compare = 0;
		if (funLease.getModifyPriceEnd() != null) {
			compare = DateTimeHelper.compareTwoDate(new Date(), funLease.getModifyPriceEnd());
		}
		ErpFunPolicyControl policyControl = null;
		if (compare == 1) {
			policyControl = erpFunPolicyControlMapper.getPolicyControl(cityId, funLease.getLeaseId(), Const.DIC_CASE_TYPE_LEASE_FUN);
		}
		if (policyControl != null) {
			funLeaseDto.setModifyPriceStart(policyControl.getModifyPriceStart());// 修改价格时间
			funLeaseDto.setModifyPriceBefor(policyControl.getModifyPriceBefor());// 修改之前的价格
			funLeaseDto.setModifyPriceAfter(policyControl.getModifyPriceAfter());// 修改之后的价格
		} else {
			funLeaseDto.setModifyPriceEnd(null);
			funLeaseDto.setModifyPriceTrend(null);
		}
		return ErpResponseJson.ok(funLeaseDto);
	}
	
	/**
	 * 根据类型和ID获取房源数据并隐藏核心信息
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/7
	 */
	public Object getHouseAndHiddenBaseInfo(Integer caseId, Integer caseType) {
		Integer cityId = getOperator().getCityId();
		String type = "";
		Object object = null;
		ErpFunLease erpFunLease = null;
		ErpFunSale erpFunSale = null;
		String cellPhone = null;
		if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)) {
			erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			type = "SALE_";
			// 全部加密返回
			cellPhone = erpFunSale.getCellPhone();
			object = erpFunSale;
		} else if (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
			erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			type = "LEASE_";
			// 全部加密返回
			cellPhone = erpFunLease.getCellPhone();
			object = erpFunLease;
		}
		
		if (object == null) {
			if (caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN)) {
				//condition.add(new ConditionItem("SALE_ID", "=", caseId));
				ErpFunSaleToLease erpFunSaleToLease = erpFunSaleToLeaseMapper.getFunSaleToLeaseById(cityId, caseId);
				if (erpFunSaleToLease != null) {
					throw new BusinessException("该出售房源已被转为出租，编号：" + erpFunSaleToLease.getLeaseNo());
				}
			} else if (caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN)) {
				//condition.add(new ConditionItem("LEASE_ID", "=", caseId));
				ErpFunLeaseToSale erpFunLeaseToSale = erpFunLeaseToSaleMapper.getFunLeaseToSaleById(cityId, caseId);
				if (erpFunLeaseToSale != null) {
					throw new BusinessException("该出租房源已被转为出售，编号：" + erpFunLeaseToSale.getSaleNo());
				}
			} else {
				throw new BusinessException("获取房源失败");
			}
		}
		
		String owner = BeanUtil.getMethodFieldForString(type + "OWNER", object);
		String jointCellPhone = BeanUtil.getMethodFieldForString("JOINT_CELL_PHONE", object);
		cellPhone = convertStr(cellPhone, 8);
		cellPhone = SyncUtil.decodePhoneForHouseDetail(cellPhone, true);
		jointCellPhone = SyncUtil.decodePhoneForHouseDetail(jointCellPhone, true);
		owner = SyncUtil.decodeOwnerForHouseDetail(owner);
		
		BeanUtil.setMethodForStringType(type + "ROOF", null, object);
		BeanUtil.setMethodForStringType(type + "UNIT", null, object);
		BeanUtil.setMethodForStringType("UNIT_FLOOR", null, object);
		BeanUtil.setMethodForStringType(type + "NUM", null, object);
		BeanUtil.setMethodForStringType("CELL_PHONE", cellPhone, object);
		BeanUtil.setMethodForStringType("JOINT_CELL_PHONE", jointCellPhone, object);
		BeanUtil.setMethodForStringType(type + "MEMO", null, object);
		BeanUtil.setMethodForStringType(type + "OWNER", owner, object);
		BeanUtil.setMethodForStringType("ID_CARD", null, object);
		return object;
	}
	
	/**
	 * 获取房源标贴打印二维码地址
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/7
	 */
	public String getTxWebOrHaoFangLink(Integer archiveId, Integer houseId, Integer salelease, boolean isPublish, byte videoNum, Integer panoramaMap) throws Exception {
		// 没视频&&没VR=直接返回
		if (videoNum <= 0 && panoramaMap <= 0) {
			return null;
		}
		String cityDiDi = StringUtil.toString(getOperator().getAttribute("didiFlag"));
		if (StringUtils.isBlank(cityDiDi)) {
			cityDiDi = "0";
		}
		if (!"1".equals(isPublish)) {// 没有点击要发布则不显示二维码
			return null;
		}
		Operator operator = getOperator();
		String hftQrAddr = adminSysParaMapper.selectParamVlue("HFT_QR_URL");// admin的系统参数
		// 所有人都有个人微店---2016-05-07大白说的！只需要判断这条数据没有archiveId就行了，没有就跳腾讯，城市未开通腾讯的跳虚拟页面
		String isOpenWeiXinShop = "5";
		String deptYouJia = ("1".equals(StringUtil.toString(getOperator().getAttribute("youjiaCityFlag"), ""))// 城市开通you+
				&& operator.youJiaDeptFlag()// 门店开通you+
				&& !operator.youJiaDeptBanFlag()) ? "1" : "0";// 门店you+未被停权
		// 如果房源所属人的ARCHIVEID为空则返回当前用户信息，而且不能跳个人微店，找不到地址
		if (CommonUtil.isnull(archiveId)) {
			archiveId = operator.getArchiveId();
			isOpenWeiXinShop = "0";
			if (1 != operator.getQQPublish() && !"1".equals(cityDiDi)) {
				return null;
			}
		}
		// 这里使用当前用户的档案ID，扫描二维码后在网页上展示的时候就展示当前人的电话号码
		archiveId = operator.getArchiveId();
		return hftQrAddr + "/" + operator.getCityId() + "/" + archiveId + "/"
				+ salelease + "/" + houseId + "/" + isOpenWeiXinShop
				+ "/" + cityDiDi + "/" + deptYouJia;//不能随便改路径，否则不兼容，会导致以前的路径访问不到
	}
}

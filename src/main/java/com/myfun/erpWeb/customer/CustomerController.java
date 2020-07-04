package com.myfun.erpWeb.customer;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.dto.ErpFunRentCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunProxyTemplateService;
import com.myfun.service.business.erpdb.ErpFunRentCustomerService;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController extends BaseController {
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunCaseFavoriteMapper erpFunCaseFavoriteMapper;
	@Autowired
	ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpFunRentCustomerService erpFunRentCustomerService;
	@Autowired
	ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired
	ErpFunProxyTemplateMapper erpFunProxyTemplateMapper;
	@Autowired
	ErpFunProxyTemplateService erpFunProxyTemplateService;


	/**
	 * 获取宽列表客源求租带看列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */
	@ResponseBody
	@RequestMapping(value = "/getRentCustomerDaiKanList")
	public ResponseJson getRentCustomerDaiKanList(@Valid @RequestBody BaseMapParam param){
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String[] caseIds;
		if (StringUtil.isNotBlank(param.getString("rentCustIds"))){
			caseIds = param.getString("rentCustIds").split(",");
			if(caseIds == null || caseIds.length <= 0){
				return ErpResponseJson.ok();
			}
			List<ErpFunTrack> trackResultList = this.getCustomerDaiKanList(cityId,compId,caseIds,Const.DIC_CASE_TYPE_RENT_CUST,Const.DIC_CASE_TYPE_LEASE_FUN);
			return ErpResponseJson.ok(trackResultList);
		}else {
			return ErpResponseJson.ok();
		}
	}

	/**
	 * 获取宽列表客源求购带看列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */
	@ResponseBody
	@RequestMapping(value = "/getBuyCustomerDaiKanList")
	public ResponseJson getBuyCustomerDaiKanList(@Valid @RequestBody BaseMapParam param){
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		String[] caseIds;
		if (StringUtil.isNotBlank(param.getString("buyCustIds"))){
			caseIds = param.getString("buyCustIds").split(",");
			if(caseIds == null || caseIds.length <= 0){
				return ErpResponseJson.ok();
			}
			List<ErpFunTrack> trackResultList = this.getCustomerDaiKanList(cityId,compId,caseIds,Const.DIC_CASE_TYPE_BUY_CUST,Const.DIC_CASE_TYPE_SALE_FUN);
			return ErpResponseJson.ok(trackResultList);
		}else {
			return ErpResponseJson.ok();
		}
	}

	/**
	 * 获取求购数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/4
	 */	
	@ResponseBody
	@RequestMapping(value = "/getCustomBuyCustom")
	public ResponseJson getCustomBuyCustom(@Valid @RequestBody BaseMapParam param){
		Integer buyCustId=param.getInteger("buyCustId");
		Integer cityId=getOperator().getCityId();
		ErpFunBuyCustomer funBuyCustomerPO=erpFunBuyCustomerMapper.getFunBuyCustomer(cityId,buyCustId);
		if(funBuyCustomerPO==null){
			throw new BusinessException("你所查询的客源信息不存在");
		}

		ErpFunBuyCustomerDto funBuyCustomerVO=new ErpFunBuyCustomerDto();
		try {
			BeanUtil.copyObject(funBuyCustomerPO,funBuyCustomerVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//funBuyCustomerVO.setErpFunBuyCustomer(funBuyCustomerPO);
		// 对客户和电话加密
		String cellPhone = funBuyCustomerPO.getCellPhone();
		String custName = funBuyCustomerPO.getBuyCustName();
		cellPhone = SyncUtil.decodePhoneForHouseDetail(cellPhone, true);
		custName = SyncUtil.decodeOwnerForHouseDetail(custName);
		funBuyCustomerPO.setCellPhone(cellPhone);
		funBuyCustomerPO.setBuyCustName(custName);

		if(funBuyCustomerPO.getUserId()!=null && !Const.DIC_SYSTEM_USERID_999.equals(funBuyCustomerPO.getUserId())){
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId,funBuyCustomerPO.getUserId());
			if(usersPO!=null){
				// 查询实名认证
				AdminFunArchive archivePO = adminFunArchiveMapper.getArchiveById(usersPO.getArchiveId());
				funBuyCustomerVO.setUserName(usersPO.getUserName());
				funBuyCustomerVO.setUserMobile(usersPO.getUserMobile());
				funBuyCustomerVO.setUserNo(usersPO.getUserNo());
				if(archivePO != null){
					funBuyCustomerVO.setUserRight(archivePO.getUserRight());
				}
			}
		}
		Boolean houseLook = funBuyCustomerPO.getHouseLook();
		if(houseLook!=null && houseLook){// 查询带看编号
			String funTrack = erpFunTrackMapper.getErpFunTrackNo(cityId,Const.DIC_CASE_TYPE_BUY_CUST,StringUtil.parseInteger(Const.DIC_TRACK_TYPE_DAIKAN),1,funBuyCustomerPO.getBuyCustId());
			if(funTrack != null ){
				funBuyCustomerVO.setTrackNo(funTrack);
			}
		}
		if(funBuyCustomerPO.getDeptId()!=null){
			ErpFunDepts funDeptsPO = erpFunDeptsMapper.getByDeptId(cityId,funBuyCustomerPO.getDeptId());
			if(funDeptsPO!=null){
				funBuyCustomerVO.setDeptName(funDeptsPO.getDeptName());
				funBuyCustomerVO.setDeptTele(funDeptsPO.getDeptTele());
			}
		}
		boolean isLock=this.dealInfoIsLock(StringUtil.toString(funBuyCustomerPO.getBuyCustStatus()),funBuyCustomerPO.getBuyCustId(),Const.DIC_CASE_TYPE_BUY_CUST);
		if(isLock){
			funBuyCustomerVO.setDealLockFlag(1);
		}else{
			funBuyCustomerVO.setDealLockFlag(0);
		}

		ErpFunCaseFavorite erpFunCaseFavorite=erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId,buyCustId,Const.DIC_CASE_TYPE_BUY_CUST,getOperator().getUserId());
		if(null != erpFunCaseFavorite) {
			funBuyCustomerVO.setFavoriteId(erpFunCaseFavorite.getFavoriteId());
		}

		ErpFunEarbestMoneyDto erpEarbestMoneyDto=erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(cityId,StringUtil.parseInteger(funBuyCustomerPO.getBuyCustNo()));
		if(null != erpEarbestMoneyDto){
			funBuyCustomerVO.setReceiptNo(erpEarbestMoneyDto.getReceiptNo());
			funBuyCustomerVO.setEarbestId(erpEarbestMoneyDto.getEarbestId());
		}
		return ErpResponseJson.ok(funBuyCustomerVO);
	}

	/**
	 * 获取求租数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/5
	 */
	@ResponseBody
	@RequestMapping(value = "/getCustomRentCustom")
	public ResponseJson getCustomRentCustom(@Valid @RequestBody BaseMapParam param){
		Integer rentCustId=param.getInteger("rentCustId");
		Integer cityId=getOperator().getCityId();
		ErpFunRentCustomer funRentCustomer=erpFunRentCustomerMapper.getRentCustomerByCustId(cityId,rentCustId);
		if(funRentCustomer==null){
			throw new BusinessException("你所查询的客源信息不存在");
		}

		ErpFunRentCustomerDto funRentCustomerDto=new ErpFunRentCustomerDto();
		try {
			BeanUtil.copyObject(funRentCustomer,funRentCustomerDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//funBuyCustomerVO.setErpFunBuyCustomer(funBuyCustomerPO);
		// 对客户和电话加密
		String cellPhone = funRentCustomerDto.getCellPhone();
		String custName = funRentCustomerDto.getRentCustName();
		cellPhone = SyncUtil.decodePhoneForHouseDetail(cellPhone, true);
		custName = SyncUtil.decodeOwnerForHouseDetail(custName);
		funRentCustomer.setCellPhone(cellPhone);
		funRentCustomer.setRentCustName(custName);

		if(funRentCustomer.getUserId()!=null && !Const.DIC_SYSTEM_USERID_999.equals(funRentCustomer.getUserId())){
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId,funRentCustomer.getUserId());
			if(usersPO!=null){
				// 查询实名认证
				AdminFunArchive archivePO = adminFunArchiveMapper.getArchiveById(usersPO.getArchiveId());
				funRentCustomerDto.setUserName(usersPO.getUserName());
				funRentCustomerDto.setUserMobile(usersPO.getUserMobile());
				funRentCustomerDto.setUserNo(usersPO.getUserNo());
				if(archivePO != null){
					funRentCustomerDto.setUserRight(archivePO.getUserRight());
				}
			}
		}
		Boolean houseLook = funRentCustomer.getHouseLook();
		if(houseLook!=null && houseLook){// 查询带看编号
			String funTrack = erpFunTrackMapper.getErpFunTrackNo(cityId,Const.DIC_CASE_TYPE_RENT_CUST,StringUtil.parseInteger(Const.DIC_TRACK_TYPE_DAIKAN),1,funRentCustomer.getRentCustId());
			if(funTrack != null ){
				funRentCustomerDto.setTrackNo(funTrack);
			}
		}
		if(funRentCustomer.getDeptId()!=null){
			ErpFunDepts funDeptsPO = erpFunDeptsMapper.getByDeptId(cityId,funRentCustomer.getDeptId());
			if(funDeptsPO!=null){
				funRentCustomerDto.setDeptName(funDeptsPO.getDeptName());
				funRentCustomerDto.setDeptTele(funDeptsPO.getDeptTele());
			}
		}
		boolean isLock=this.dealInfoIsLock(StringUtil.toString(funRentCustomer.getRentCustStatus()),funRentCustomer.getRentCustId(),Const.DIC_CASE_TYPE_RENT_CUST);
		if(isLock){
			funRentCustomerDto.setDealLockFlag(1);
		}else{
			funRentCustomerDto.setDealLockFlag(0);
		}

		ErpFunCaseFavorite erpFunCaseFavorite=erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId,rentCustId,Const.DIC_CASE_TYPE_BUY_CUST,getOperator().getUserId());
		if(null != erpFunCaseFavorite) {
			funRentCustomerDto.setFavoriteId(erpFunCaseFavorite.getFavoriteId());
		}

		ErpFunEarbestMoneyDto erpEarbestMoneyDto=erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(cityId,StringUtil.parseInteger(funRentCustomer.getRentCustNo()));
		if(null != erpEarbestMoneyDto){
			funRentCustomerDto.setReceiptNo(erpEarbestMoneyDto.getReceiptNo());
			funRentCustomerDto.setEarbestId(erpEarbestMoneyDto.getEarbestId());
		}
		return ErpResponseJson.ok(funRentCustomerDto);
	}

	/**
	 * 获取客源求购列表-单条信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/9
	 */
	@ResponseBody
	@RequestMapping(value = "/getOneBuyCustomerLikeList")
	public ResponseJson getOneBuyCustomerLikeList(@Valid @RequestBody BaseMapParam param){
		Integer buyCustId = param.getInteger("buyCustId");
		String useType = param.getString("useType");

		Integer cityId=getOperator().getCityId();
		ErpFunBuyCustomer erpFunBuyCustomer=erpFunBuyCustomerMapper.getFunBuyCustomer(cityId,buyCustId);
		ErpFunBuyCustomerDto erpFunBuyCustomerDto = new ErpFunBuyCustomerDto();
		try {
			BeanUtil.copyObject(erpFunBuyCustomer,erpFunBuyCustomerDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.updateCustVOInfo(erpFunBuyCustomerDto, useType,false);
		return ErpResponseJson.ok(erpFunBuyCustomerDto);
	}

	/**
	 * 获取客源求租列表-单条信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */
	@ResponseBody
	@RequestMapping(value = "/getOneRentCustomerLikeList")
	public ResponseJson getOneRentCustomerLikeList(@Valid @RequestBody BaseMapParam param){
		Integer rentCustId = param.getInteger("rentCustId");
		String useType = param.getString("useType");

		Integer cityId=getOperator().getCityId();
		ErpFunRentCustomer erpFunRentCustomer=erpFunRentCustomerMapper.getRentCustomerByCustId(cityId,rentCustId);
		ErpFunRentCustomerDto erpFunRentCustomerDto = new ErpFunRentCustomerDto();
		try {
			BeanUtil.copyObject(erpFunRentCustomer,erpFunRentCustomerDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.updateCustVOInfo(erpFunRentCustomerDto, useType,false);
		return ErpResponseJson.ok(erpFunRentCustomerDto);
	}

	/**
	 * 登记求租数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 * TODO
	 */	
	@ResponseBody
	@RequestMapping(value = "/insertCustomRentCustom")
	public ResponseJson insertCustomRentCustom(@Valid @RequestBody ErpFunRentCustomerParam param){
		if (param.getRentCustLevel()==null && param.getRentCustLevel()==Const.DIC_HOUSE_LEVEL_COMMEND) {
			param.setCommendTime(new Date());
		} else if (CommonUtil.isnull(param.getRentCustLevel()) && param.getRentCustLevel().equals(Const.DIC_HOUSE_LEVEL_PASSWORD)) {
			param.setSecrecyTime(new Date());
		}
		param.setHouseLook(false);
		param.setRentCustStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
		// 处理需要收尾加空格的字段
		this.dealCustField(param);
		// 加密需要加密的字段
		param.setWechatNumber(EnCodeHelper.encode(param.getWechatNumber()));
		param.setCreateArchiveId(getOperator().getArchiveId());
		param.setCreatorUid(getOperator().getUserId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setAreaId(getOperator().getAreaId());
		param.setRegId(getOperator().getRegId());
		param.setDeptId(getOperator().getDeptId());
		param.setShardCityId(getOperator().getCityId());
		boolean isPersonalVersion=getOperator().isPersonalVersion();
		String[] idAndNo=erpFunRentCustomerService.createHouseOrCustInfo(param,isPersonalVersion,getOperator().getGrId());
		//如果是加密或推荐房源写一条审核跟进
		Byte caseLevel=param.getRentCustLevel();
		if (Const.DIC_HOUSE_LEVEL_COMMEND.equals(caseLevel)||
				Const.DIC_HOUSE_LEVEL_PASSWORD.equals(caseLevel)) {
			this.sendCreateTrackInfo(idAndNo[0], Constants_DIC.DIC_CASE_TYPE_RENT_CUST, caseLevel);
		}
		//funCustRegsectionsService.createFunCustRegsections(model.getHOUSE_REGION(), model.getSECTION_ID(),model.getRENT_CUST_ID(),Constants_DIC.DIC_CASE_TYPE_RENT_CUST);
		//funCustDemandSplitService.createFunCustDemandSplit(model.getHOUSE_TYPE(), model.getHOUSE_USEAGE(),model.getBUILD_ID(), model.getRENT_CUST_ID(),Constants_DIC.DIC_CASE_TYPE_RENT_CUST);
		return ErpResponseJson.ok();
	}

	/**
	 * 如果是加密或推荐房源写一条审核跟进
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */	
	private void sendCreateTrackInfo(String caseId, String caseType, Byte caseLevel) {
		String trackContent = "";
		Byte trackType = Const.DIC_HOUSE_LEVEL_COMMEND.equals(caseLevel) ? Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND :
				Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD;
		Boolean flag = this.judgeAudit(getOperator().getCompId(), caseType, trackType, "1");
		if (!flag) {
			return;
		}
		String trackStr = Constants_DIC.DIC_HOUSE_LEVEL_COMMEND.equals(caseLevel) ? "推荐" : "加密";
		switch (caseType) {
			case "1"://出售
				trackContent = "登记房源时申请" + trackStr;
				break;
			case "2"://出租
				trackContent = "登记房源时申请" + trackStr;
				break;
			case "3"://求购
				trackContent = "登记客源时申请" + trackStr;
				break;
			case "4"://求租
				trackContent = "登记客源时申请" + trackStr;
				break;
		}
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("caseId", caseId);
		paramMap.put("caseType", caseType);
		paramMap.put("trackType", StringUtil.toString(trackType));
		paramMap.put("trackContent", trackContent);
		paramMap.put("clientkey", getOperator().getClientKey());
//		SwitchListMap.SwitchClass switchClass = new SwitchListMap.SwitchClass();
//		switchClass.setUrl("houseCust/createTrackInfo");
//		switchClass.setParams(paramMap);
//		BaseSwitch.commSwitch4ListObject(switchClass, null);
	}

	/**
	 * 
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */	
	private Boolean judgeAudit(Integer compId, String caseType, Byte trackType, String auditResource) {
		Boolean ret=false;
//		ErpAuditTemplate templatePO = erpAuditTemplateMapper.getAuditTemplate(getOperator().getCityId(),compId,caseType,StringUtil.parseInteger(trackType));
//		ret=templatePO==null?false:"1".equals(templatePO.getNeedAudit());
		return ret;
	}

	/**
	 * 处理需要收尾加空格的字段
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */
	private void dealCustField(ErpFunRentCustomerParam param) {
		if (param.getHouseYearLow()==null){
			param.setHouseYearLow(new Short("10000"));
		}
		if (param.getHouseYearHigh()==null){
			param.setHouseYearHigh(new Short("10000"));
		}

		//客源多字段数据 前后都要加空格
		String buildId1 = param.getBuildId1();
		buildId1 = buildId1.equals("") ? "" : (buildId1 + " ");
		String buildName1 = buildId1.equals("") ? "" : (param.getBuildId1Text() + " ");

		String buildId2 =  param.getBuildId2();
		buildId2 = buildId2.equals("") ? "" : (buildId2 + " ");
		String buildName2 = buildId2.equals("") ? "" : (param.getBuildId2Text() + " ");

		String buildId3 =  param.getBuildId3();
		buildId3 = buildId3.equals("") ? "" : (buildId3 + " ");
		String buildName3 = buildId3.equals("") ? "" : (param.getBuildId3Text() + " ");

		String buildId4 =  param.getBuildId4();
		buildId4 = buildId4.equals("") ? "" : (buildId4 + " ");
		String buildName4 = buildId4.equals("") ? "" : (param.getBuildId4Text() + " ");

		String buildId5 =  param.getBuildId5();
		buildId5 = buildId5.equals("") ? "" : (buildId5 + " ");
		String buildName5 = buildId5.equals("") ? "" : (param.getBuildId5Text() + " ");

		String buildId = " " + buildId1 + buildId2 + buildId3 + buildId4 + buildId5;
		String buildName = " " + buildName1 + buildName2 + buildName3 + buildName4 + buildName5;
		if(StringUtils.isNotBlank(buildId) && StringUtils.isNotBlank(buildName)){
			param.setBuildId(buildId);
			param.setBuildName(buildName);
		}
		// 干道信息
		String roadsIds =param.getRoadsIds();
		if (StringUtils.isNotBlank(roadsIds)) {
			String[] buildRoadsArr = roadsIds.split(",");
			StringBuilder roadSb = new StringBuilder();
			for (String str : buildRoadsArr) {
				roadSb.append(str).append(" ");
			}
			if (roadSb.length() > 0) {
				param.setRoadsIds(" " + roadSb.toString());
			}
		}
		String roadsName =param.getRoadsName();
		if (StringUtils.isNotBlank(roadsName)) {
			String[] buildRoadsArr = roadsName.split(",");
			StringBuilder roadSb = new StringBuilder();
			for (String str : buildRoadsArr) {
				roadSb.append(str).append(" ");
			}
			if (roadSb.length() > 0) {
				param.setRoadsName(" " + roadSb.toString());
			}
		}
		if(StringUtil.isNotBlank(param.getHouseRegion())){
			param.setHouseRegion(" " + param.getHouseRegion() + " ");
		}
		if(StringUtil.isNotBlank(param.getRegionName())){
			param.setRegionName(" " + param.getRegionName() + " ");
		}
		if(StringUtil.isNotBlank(param.getSectionId())){
			param.setSectionId(" " + param.getSectionId() + " ");
		}
		if(StringUtil.isNotBlank(param.getSectionName())){
			param.setSectionName(" " + param.getSectionName() + " ");
		}
		if(StringUtil.isNotBlank(param.getHouseRound())){
			param.setHouseRound(" " + param.getHouseRound() + " ");
		}
		if(StringUtil.isNotBlank(param.getHouseType())){
			param.setHouseType(" " + param.getHouseType() + " ");
		}
		if(StringUtil.isNotBlank(param.getHouseUseage())){
			param.setHouseUseage(" " + param.getHouseUseage() + " ");
		}
	}

	/**
	 * 添加其他信息，收藏信息等信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/9
	 */	
	private void updateCustVOInfo(Object object,String useType , boolean havaFavorite) {
		if(object == null){
			return;
		}
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		Integer userId=null;
		Integer deptId=null;
		if (object instanceof ErpFunBuyCustomerDto){
			ErpFunBuyCustomerDto erpFunBuyCustomerDto=(ErpFunBuyCustomerDto)object;

			Integer caseId=erpFunBuyCustomerDto.getBuyCustId();
			Integer archiveId=erpFunBuyCustomerDto.getArchiveId();
			if (erpFunBuyCustomerDto.getUserId()!=null) {
				userId=erpFunBuyCustomerDto.getUserId();
			}
			if(!getOperator().getCompId().equals(erpFunBuyCustomerDto.getCompId())) {
				deptId=erpFunBuyCustomerDto.getDeptId();
			}
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
			ErpFunCaseFavorite erpFunCaseFavorite=null;
			if(!havaFavorite){
				erpFunCaseFavorite = erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId,caseId, Const.DIC_CASE_TYPE_BUY_CUST,getOperator().getUserId());
			}
			AdminFunArchive adminFunArchive=adminFunArchiveMapper.getArchiveById(archiveId);
			ErpFunDepts erpFunDepts=null;
			if(deptId!=null){
				erpFunDepts=erpFunDeptsMapper.getByDeptId(cityId,deptId);
			}
			if(erpFunDepts != null) {
				erpFunBuyCustomerDto.setDeptName(erpFunDepts.getDeptName());
			}
			if(StringUtil.isNotBlank(useType)){
				String cellPhone = erpFunBuyCustomerDto.getCellPhone();
				if(StringUtil.isNotBlank(cellPhone)){
					erpFunBuyCustomerDto.setCellPhone(SyncUtil.decodePhoneForHouseDetailOfFirst(cellPhone, true));
				}
				String idCard = erpFunBuyCustomerDto.getIdCard();
				if(StringUtil.isNotBlank(idCard)){
					erpFunBuyCustomerDto.setIdCard(SyncUtil.decodeIDCARDDetail(EnCodeHelper.decode(idCard)));
				}
			}
			// 遍历收藏
			if(erpFunCaseFavorite != null){
				erpFunBuyCustomerDto.setFavoriteId(erpFunCaseFavorite.getFavoriteId());
			}
			if(erpFunBuyCustomerDto.getArchiveId()!=null){
				if(adminFunArchive != null){
					erpFunBuyCustomerDto.setUserPhoto(StringUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
				}
			}
			if(usersPO!=null){//这里一般在跨公司查询时候使用，例如：共享圈 好友圈 加盟圈 查询
				if (erpFunBuyCustomerDto.getUserId()!=null && !Const.DIC_SYSTEM_USERID_999.equals(erpFunBuyCustomerDto.getUserId())) {
					erpFunBuyCustomerDto.setUserName(usersPO.getUserName());
					erpFunBuyCustomerDto.setUserNo(usersPO.getUserNo());
					erpFunBuyCustomerDto.setUserMobile(usersPO.getUserMobile());
				}
			}
			//格式化创建时间和跟进时间
			erpFunBuyCustomerDto.setCreationTime(DateTimeHelper.formatDateTimetoString(erpFunBuyCustomerDto.getCreationTime(),"yyyy-MM-dd HH:mm"));
			if(erpFunBuyCustomerDto.getTrackTime()!=null){
				erpFunBuyCustomerDto.setTrackTime(DateTimeHelper.formatDateTimetoString(erpFunBuyCustomerDto.getTrackTime(),"yyyy-MM-dd HH:mm"));
			}
		}else if (object instanceof ErpFunRentCustomerDto){
			ErpFunRentCustomerDto erpFunRentCustomerDto=(ErpFunRentCustomerDto)object;
			Integer caseId=erpFunRentCustomerDto.getRentCustId();
			Integer archiveId=erpFunRentCustomerDto.getArchiveId();
			if (erpFunRentCustomerDto.getUserId()!=null) {
				userId=erpFunRentCustomerDto.getUserId();
			}
			if(!getOperator().getCompId().equals(erpFunRentCustomerDto.getCompId())) {
				deptId=erpFunRentCustomerDto.getDeptId();
			}
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
			ErpFunCaseFavorite erpFunCaseFavorite=null;
			if(!havaFavorite){
				erpFunCaseFavorite = erpFunCaseFavoriteMapper.getFunCaseFavorite(cityId,caseId, Const.DIC_CASE_TYPE_BUY_CUST,getOperator().getUserId());
			}
			AdminFunArchive adminFunArchive=adminFunArchiveMapper.getArchiveById(archiveId);
			ErpFunDepts erpFunDepts=null;
			if(deptId!=null){
				erpFunDepts=erpFunDeptsMapper.getByDeptId(cityId,deptId);
			}
			if(erpFunDepts != null) {
				erpFunRentCustomerDto.setDeptName(erpFunDepts.getDeptName());
			}
			if(StringUtil.isNotBlank(useType)){
				String cellPhone = erpFunRentCustomerDto.getCellPhone();
				if(StringUtil.isNotBlank(cellPhone)){
					erpFunRentCustomerDto.setCellPhone(SyncUtil.decodePhoneForHouseDetailOfFirst(cellPhone, true));
				}
				String idCard = erpFunRentCustomerDto.getIdCard();
				if(StringUtil.isNotBlank(idCard)){
					erpFunRentCustomerDto.setIdCard(SyncUtil.decodeIDCARDDetail(EnCodeHelper.decode(idCard)));
				}
			}
			// 遍历收藏
			if(erpFunCaseFavorite != null){
				erpFunRentCustomerDto.setFavoriteId(erpFunCaseFavorite.getFavoriteId());
			}
			if(erpFunRentCustomerDto.getArchiveId()!=null){
				if(adminFunArchive != null){
					erpFunRentCustomerDto.setUserPhoto(StringUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
				}
			}
			if(usersPO!=null){//这里一般在跨公司查询时候使用，例如：共享圈 好友圈 加盟圈 查询
				if (erpFunRentCustomerDto.getUserId()!=null && !Const.DIC_SYSTEM_USERID_999.equals(erpFunRentCustomerDto.getUserId())) {
					erpFunRentCustomerDto.setUserName(usersPO.getUserName());
					erpFunRentCustomerDto.setUserNo(usersPO.getUserNo());
					erpFunRentCustomerDto.setUserMobile(usersPO.getUserMobile());
				}
			}
			//格式化创建时间和跟进时间
			erpFunRentCustomerDto.setCreationTime(erpFunRentCustomerDto.getCreationTime());
			if(erpFunRentCustomerDto.getTrackTime()!=null){
				erpFunRentCustomerDto.setTrackTime(erpFunRentCustomerDto.getTrackTime());
			}
		}

	}

	/**
	 *	判断数据是否合同锁定
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/4
	 */
	private boolean dealInfoIsLock(String custStatus,Integer custId,Integer caseType) {
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		//是否显示合同锁定权限 CAN_LOCK_WARRANT
		String viewDealOperLock=erpSysParaMapper.getParamValue(cityId,compId,"CAN_LOCK_WARRANT");
		if(!"1".equals(viewDealOperLock)){
			return false;
		}
		boolean isLockOper = this.judgePermission(this.getOperator().getUserId(), "DEAL_LOCK_VIEW");
		if(isLockOper){//有查看合同锁定权 直接通过
			return false;
		}
		ErpFunDeal conditionModel = new ErpFunDeal();
		Integer dealType=null;
		if (caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST)){
			if(!custStatus.equals(Const.DIC_HOUSE_STATUS_INNERDEAL)){
				return false;
			}
			Integer dealCaseId = custId;
			dealType = Const.DIC_CASE_TYPE_SALE_DEAL;
			conditionModel.setDealCustomerId(dealCaseId);
		}else if (caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST)){
			if(!custStatus.equals(Const.DIC_HOUSE_STATUS_INNERDEAL)){
				return false;
			}
			Integer dealCaseId = custId;
			dealType = Const.DIC_CASE_TYPE_RENT_DEAL;
			conditionModel.setDealCustomerId(dealCaseId);
		}

		conditionModel.setDealType(dealType.byteValue());
		conditionModel.setCompId(compId);
		Integer dealPos = erpFunDealMapper.getDealLockFlagList(cityId,conditionModel);
		if(dealPos!=null){
			return dealPos==1;
		}
		return false;
	}

	/**
	 * 校验用户权限
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/3
	 */
	private boolean judgePermission(Integer userId, String operId) {
		List<ErpUserOpers> userOpersList=erpUserOpersMapper.getListById(getOperator().getCityId(),userId);
		Map<String, ErpUserOpers> funOpersPOMap=userOpersList.stream().collect(Collectors.toMap(ErpUserOpers::getOperId,val->val));
		return funOpersPOMap.containsKey(operId);
	}

	/**
	 * 获取客源带看列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/30
	 */
	private List<ErpFunTrack> getCustomerDaiKanList(Integer cityId, Integer compId, String[] caseIds, Integer caseType,Integer caseTypeFun) {
		List<ErpFunTrack> trackPOList =erpFunTrackMapper.getErpFunTrackRentCustomerList(cityId,compId,caseType,caseIds);
		if(trackPOList == null || trackPOList.size() <= 0){
			return null;
		}
		Set<Integer> caseIdSet = new HashSet<>();
		Map<Integer, Integer> nowCount = new HashMap<>();
		for (ErpFunTrack funTrackPO : trackPOList) {
			Integer tempCount = null;
			Integer tempCaseId = null;
			if(caseTypeFun==funTrackPO.getCaseType().intValue()){
				tempCaseId = funTrackPO.getTargetId();
				tempCount = nowCount.get(tempCaseId);
				if(tempCount == null || tempCount < 4){
					caseIdSet.add(funTrackPO.getCaseId());
				}
			} else if(caseTypeFun==funTrackPO.getTargetType().intValue()){
				tempCaseId = funTrackPO.getCaseId();
				tempCount = nowCount.get(tempCaseId);
				if(tempCount == null || tempCount < 4){
					caseIdSet.add(funTrackPO.getTargetId());
				}
			}
			if(tempCount == null){
				tempCount = 0;
			}
			tempCount++;
			nowCount.put(tempCaseId, tempCount);
		}
		if(caseIdSet.size() <= 0){
			return null;
		}
		List<ErpFunUsers> usersList = erpFunUsersMapper.getFunUsersListByCompId(cityId,compId);
		Map<Integer, ErpFunUsers> userMap=usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId,val->val));
		List<ErpFunTrack> trackResultList = new LinkedList<>();
		if (caseType==4){
			String isUseCreationTimeQuery=erpSysParaMapper.getParamValue(cityId,compId,"IS_USE_CREATION_TIME_QUERY");
			String timeColumn = null;
			if ("1".equals(isUseCreationTimeQuery)){
				timeColumn="CREATION_TIME";
			}else {
				timeColumn="AVAILABLE_TIME";
			}
			List<ErpFunLease> leasePOList =erpFunLeaseMapper.getFunLeaseListByIds(cityId,compId,timeColumn,caseIdSet);
			Map<Integer, ErpFunLease> funLeasePOMap = new HashMap<>();
			for (ErpFunLease funLeasePO : leasePOList) {
				funLeasePOMap.put(funLeasePO.getLeaseId(), funLeasePO);
			}
			for (ErpFunTrack funTrackPO : trackPOList) {
				ErpFunLease funLeasePO = null;
				Integer tempCustId = null;
				if(caseTypeFun==funTrackPO.getCaseType().intValue()){
					funLeasePO = funLeasePOMap.get(funTrackPO.getCaseId());
					tempCustId = funTrackPO.getTargetId();
				} else if(caseTypeFun==funTrackPO.getTargetType().intValue()){
					funLeasePO = funLeasePOMap.get(funTrackPO.getTargetId());
					tempCustId = funTrackPO.getCaseId();
				}
				if(funLeasePO != null){
					ErpFunTrackDto funTrackVO = new ErpFunTrackDto();
					ErpFunUsers funUsersPO = userMap.get(funTrackPO.getCreatorUid());
					if(funUsersPO != null){
						funTrackVO.setTrackUserName(funUsersPO.getUserName());
					}
					funTrackVO.setCustId(tempCustId);
					funTrackVO.setLeaseId(funLeasePO.getLeaseId());
					funTrackVO.setBuildName(funLeasePO.getBuildName());
					funTrackVO.setTrackTime(funTrackPO.getCreationTime());
					trackResultList.add(funTrackVO);
				}
			}
		}else if (caseType==3){
			List<ErpFunSale> erpFunSaleList =erpFunSaleMapper.getFunSaleListByIds(cityId,compId,caseIdSet);
			Map<Integer, ErpFunSale> funSaleMap = new HashMap<>();
			for (ErpFunSale erpFunSale : erpFunSaleList) {
				funSaleMap.put(erpFunSale.getSaleId(), erpFunSale);
			}
			for (ErpFunTrack funTrackPO : trackPOList) {
				ErpFunSale funSale = null;
				Integer tempCustId = null;
				if(caseTypeFun==funTrackPO.getCaseType().intValue()){
					funSale = funSaleMap.get(funTrackPO.getCaseId());
					tempCustId = funTrackPO.getTargetId();
				} else if(caseTypeFun==funTrackPO.getTargetType().intValue()){
					funSale = funSaleMap.get(funTrackPO.getTargetId());
					tempCustId = funTrackPO.getCaseId();
				}
				if(funSale != null){
					ErpFunTrackDto funTrackVO = new ErpFunTrackDto();
					ErpFunUsers funUsersPO = userMap.get(funTrackPO.getCreatorUid());
					if(funUsersPO != null){
						funTrackVO.setTrackUserName(funUsersPO.getUserName());
					}
					funTrackVO.setCustId(tempCustId);
					funTrackVO.setLeaseId(funSale.getSaleId());
					funTrackVO.setBuildName(funSale.getBuildName());
					funTrackVO.setTrackTime(funTrackPO.getCreationTime());
					trackResultList.add(funTrackVO);
				}
			}
		}
		return trackResultList;
	}
}

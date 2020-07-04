package com.myfun.erpWeb.soso.house;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.house.vo.FunSaleDto;
import com.myfun.erpWeb.soso.param.ComplaintParam;
import com.myfun.erpWeb.soso.param.SosoPhotoListParam;
import com.myfun.erpWeb.soso.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunPhoneDto;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfo;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfoExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.search2db.dao.Search2HezuMapper;
import com.myfun.repository.search2db.dao.Search2LeaseInMapper;
import com.myfun.repository.search2db.dao.Search2SaleInMapper;
import com.myfun.repository.search2db.dao.Search2ShopMainMapper;
import com.myfun.repository.searchdb.dao.*;
import com.myfun.repository.searchdb.dto.*;
import com.myfun.repository.searchdb.po.SearchPhotoZj;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminCompGiftCoinRecordService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.searchdb.*;
import com.myfun.service.business.searchdb.bean.param.SoSoConverDetectParam;
import com.myfun.service.business.searchdb.bean.param.SoSoConvertRegisterParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 搜搜房源控制器
 * @author 张宏利
 * @since 2016年8月18日
 */
@Api(tags ="搜搜房源模块")
@RestController
@RequestMapping(value="/soso/house/")
public class SoSoHouseController extends BaseController{

	@Resource SearchSaleInService searchSaleInService;
	@Resource SearchLeaseInService searchLeaseInService;
	@Resource SearchShopMainService searchShopMainService;
	@Resource SearchHeZuService searchHezuService;
	@Resource SearchSosoViewMapper searchSosoViewMapper;
	@Resource SearchSosoViewService searchSosoViewService;
	@Resource SearchSosoViewCountMapper searchSosoViewCountMapper;
	@Resource SearchPhotoZjMapper searchPhotoZjMapper;
	@Resource ErpFunRoadsInfoMapper erpFunRoadsInfoMapper;
	@Resource ErpFunPhoneMapper erpFunPhoneMapper;
	@Resource AdminFunArchiveMapper adminFunArchiveMapper;
	@Resource SearchSaleInMapper searchSaleInMapper;
	@Resource Search2SaleInMapper search2SaleInMapper;
	@Resource SearchLeaseInMapper searchLeaseInMapper;
	@Resource Search2LeaseInMapper search2LeaseInMapper;
	@Resource SearchShopMainMapper searchShopMainMapper;
	@Resource Search2ShopMainMapper search2ShopMainMapper;
	@Resource SearchHezuMapper searchHezuMapper;
	@Resource Search2HezuMapper search2HezuMapper;
	@Resource AdminSysParaMapper adminSysParaMapper;
	@Resource AdminFunCityMapper adminFunCityMapper;
	@Resource AdminAppLoginMapper adminAppLoginMapper;
	@Resource ErpSysParaMapper erpSysParaMapper;
	@Resource ErpUserOpersMapper erpUserOpersMapper;
	@Resource ErpFunSaleMapper erpFunSaleMapper;
	@Resource ErpFunLeaseMapper erpFunLeaseMapper;
	@Resource ErpFunUsersMapper erpFunUsersMapper;
	@Resource AdminFunArchiveService adminFunArchiveService;
	@Resource AdminFunDeptsMapper adminFunDeptsMapper;
	@Resource AdminCompGiftCoinRecordService adminCompGiftCoinRecordService;
	@Resource ErpSysParaService erpSysParaService;

	/**
	 * 修改查看记录的专属手机号
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/updateExclusiveMobile")
	@NotBlank({"sosoId", "sosoType", "exclusiveMobile"})
	public ResponseJson updateExclusiveMobile(@RequestBody BaseMapParam param){
		Operator operator = getOperator();
		Integer archiveId = operator.getArchiveId();
		searchSosoViewMapper.updateExclusiveMobile(param.getInteger("sosoId"), param.getInteger("sosoType"), param.getString("exclusiveMobile"), archiveId);
		return ErpResponseJson.ok();
	}

	/**
	 * 投诉搜搜出售数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param param
	 * @return
	 */
	@ApiOperation("投诉搜搜出售数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/complaintSoSoSale")
	@NotBlank({"time", "sosoId", "complaintType"})
	public ResponseJson complaintSale(@RequestBody ComplaintParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer provinceId = operator.getProvinceId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/complaintSoSoSale", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 投诉搜搜出租数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param param
	 * @return
	 */
	@ApiOperation("投诉搜搜出租数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/complaintSoSoLease")
	@NotBlank({"time", "sosoId", "complaintType"})
	public ResponseJson complaintLease(@RequestBody ComplaintParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer provinceId = operator.getProvinceId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/complaintSoSoLease", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 投诉搜搜转铺数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param param
	 * @return
	 */
	@ApiOperation("投诉搜搜转铺数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/complaintSoSoShop")
	@NotBlank({"time", "sosoId", "complaintType"})
	public ResponseJson complaintShop(@RequestBody ComplaintParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer provinceId = operator.getProvinceId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/complaintSoSoShop", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 投诉搜搜合租数据
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param param
	 * @return
	 */
	@ApiOperation("投诉搜搜合租数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/complaintSoSoHezu")
	@NotBlank({"time", "sosoId", "complaintType"})
	public ResponseJson complaintHezu(@RequestBody ComplaintParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer provinceId = operator.getProvinceId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/complaintSoSoHezu", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 获取搜搜图片列表
	 * @author 张宏利
	 * @param CASE_ID 房源ID、CASE_TYPE 房源类型
	 * @since 2016年8月18日
	 * @return
	 */
	@ApiOperation("获取搜搜图片列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoPhotoListVo.class, message = "成功")
	})
	@NotBlank({"caseId","caseType"})
	@RequestMapping(value="/getSOSOPhotoList")
	public ResponseJson getSOSOPhotoList(@RequestBody SosoPhotoListParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSOSOPhotoList", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		List<SearchPhotoZj> photoZjList = JSON.parseArray(jsonObject.get("data").toString(), SearchPhotoZj.class);
		return ErpResponseJson.ok(photoZjList);
	}

	/**
	 *
	 * @author 张宏利
	 * @since 2016年8月29日
	 * @param param
	 * @return
	 */
	@ApiOperation("搜搜出售列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/getSoSoSaleList")
	public ResponseJson getSoSoSaleList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();
		Integer provinceId = getOperator().getProvinceId();

		param.setProvinceId(provinceId);
		param.setCityId(cityId);
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchSaleInDto> resultList = null;
		if ("SALE_IN".equals(param.getTbName())) {
			resultList = searchSaleInMapper.getSoSoSaleList(param);
		} else {
			resultList = search2SaleInMapper.getSoSoSaleList(param);
		}
		PageInfo<SearchSaleInDto> pageInfo = new PageInfo<>(resultList);
		if (resultList == null || resultList.isEmpty()) {
			return ErpResponseJson.ok(pageInfo);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchSaleInDto searchSaleInDto : resultList) {
			Integer sosoId = searchSaleInDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchSaleInDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfoList = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfoList) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}

		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchSaleInDto searchSaleInDto : resultList) {
			String mobilePhone = searchSaleInDto.getMobilePhone();
			String telePhone = searchSaleInDto.getTelePhone();
			String telSource = searchSaleInDto.getTelSource();
			phoneAddrMap.put(searchSaleInDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(1, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 1, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}
		for (SearchSaleInDto saleInViewDto : resultList) {
			Integer sosoId = saleInViewDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = saleInViewDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(saleInViewDto.getId());
			saleInViewDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(saleInViewDto.getId());
			saleInViewDto.setReaded("0");
			saleInViewDto.setConerted("0");
			if (sosoView != null) {
				saleInViewDto.setReaded("1");
				Byte isConvert = Optional.ofNullable(sosoView.getIsConvert()).orElse((byte) 0);
				if (isConvert == 1) {
					saleInViewDto.setConerted("1");
				}
				SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
				if(null != searchSosoViewDto){
					Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
					saleInViewDto.setConvertCount(convertCount);
					saleInViewDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
				}
				saleInViewDto.setPhone(sosoPhoneStr);
				saleInViewDto.setComplaintFlag(sosoView.getComplaintFlag());
				saleInViewDto.setComplaintTime(sosoView.getComplaintTime());
				saleInViewDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间
				// 返回电话登记次数和转入系统次数
				Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
				saleInViewDto.setRegisterStatus(phoneCount);
			} else {
				saleInViewDto.setOwner(this.getEncryptOwnerName(saleInViewDto.getOwner()));
				saleInViewDto.setPhone(this.getEncryptPhone(sosoPhoneStr));
				saleInViewDto.setTelePhone(this.getEncryptPhone(saleInViewDto.getTelePhone()));
				saleInViewDto.setMobilePhone(this.getEncryptPhone(saleInViewDto.getMobilePhone()));
			}
			//判断中介虚假房源
			Integer tatusFlag = saleInViewDto.getStatusFlag();
			saleInViewDto.setHouseFlag(CommonUtil.getHouseFlg(tatusFlag));
		}
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取加密的名字
	 * @author 张宏利
	 * @since 2018年6月26日
	 * @param ownerStr
	 * @return
	 */
	private String getEncryptOwnerName(String ownerStr) {
		if (StringUtils.isNotBlank(ownerStr)) {
			ownerStr = ownerStr.substring(0, 1);
			return ownerStr + "**";
		}else {
			return null;
		}
	}

	/**
	 * 获取加密的电话
	 * @author 张宏利
	 * @since 2018年6月26日
	 * @param phone
	 * @return
	 */
	private String getEncryptPhone(String phone) {
		if (StringUtils.isBlank(phone)) {
			return "***";
		} else if(phone.indexOf("/") >= 0){
			return "***";
		} else {
			int length = phone.length();
			if (length <= 5) {
				phone = phone.substring(0, 1) + "****" + phone.substring(length - 1, length);
			} else {
				phone = phone.substring(0, 3) + "****" + phone.substring(length - 4, length);
			}
		}
		return phone;
	}

	/**
	 * 电话登记次数统计
	 * @param caseType 1=出售，2=其他
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/22
	 */
	private Map<String, Integer> getPhoneCountMap(Integer caseType, Map<Integer, String> phoneAddrMap) {
		List<String> cellPhoneList = new ArrayList<>();
		Map<String, Integer> phoneCountMap = new HashMap<>();
		for (String cellPhone : phoneAddrMap.values()) {
			// 获取电话在公司登记的次数
			if ((null != cellPhone && cellPhone.startsWith("400")) || cellPhone.indexOf("/") >= 0) {
				phoneCountMap.put(cellPhone, -1);
			} else if(StringUtil.isNotBlank(cellPhone)){
				cellPhoneList.add(EnCodeHelper.encode(cellPhone));
			}
		}
		if(cellPhoneList.size() > 0) {
			List<ErpFunPhoneDto> erpFunPhoneDtoList = erpFunPhoneMapper.getPhoneCountList(getOperator().getCityId(), getOperator().getCompId(), caseType, cellPhoneList);
			if (erpFunPhoneDtoList.size() > 0) {
				Map<String, Integer> erpFunPhoneDtoMap = erpFunPhoneDtoList.stream().collect(Collectors.toMap(val->EnCodeHelper.decode(val.getPhone()), ErpFunPhoneDto::getPhoneCount));
				phoneCountMap.putAll(erpFunPhoneDtoMap);
			}
		}
		return phoneCountMap;
	}

	/**
	 * 获取搜搜出租列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@ApiOperation("获取搜搜出租列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoLeaseListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOLeaseList")
	public ResponseJson getSOSOLeaseList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();
		Integer provinceId = getOperator().getProvinceId();
		param.setProvinceId(provinceId);
		param.setCityId(cityId);
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<SearchLeaseInDto> resultList = null;
		if ("LEASE_IN".equals(param.getTbName())) {
			resultList = searchLeaseInMapper.getSoSoLeaseList(param);
		} else {
			resultList = search2LeaseInMapper.getSoSoLeaseList(param);
		}
		PageInfo<SearchLeaseInDto> pageInfo = new PageInfo<>(resultList);
		if (resultList == null || resultList.isEmpty()) {
			return ErpResponseJson.ok(pageInfo);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchLeaseInDto searchLeaseInDto : resultList) {
			Integer sosoId = searchLeaseInDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchLeaseInDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}
		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchLeaseInDto searchSaleInDto : resultList) {
			String mobilePhone = searchSaleInDto.getMobilePhone();
			String telePhone = searchSaleInDto.getTelePhone();
			String telSource = searchSaleInDto.getTelSource();
			phoneAddrMap.put(searchSaleInDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 2, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}

		for (int i = 0; i < resultList.size(); i++) {
			SearchLeaseInDto leaseInDto = resultList.get(i);
			Integer sosoId = leaseInDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = leaseInDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(leaseInDto.getId());
			leaseInDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(leaseInDto.getId());
			leaseInDto.setReaded("0");
			leaseInDto.setConerted("0");
			if (sosoView != null) {
				leaseInDto.setReaded("1");
				Byte isConvert = Optional.ofNullable(sosoView.getIsConvert()).orElse((byte) 0);
				if (isConvert == 1) {
					leaseInDto.setConerted("1");
				}
				SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
				if(null != searchSosoViewDto){
					Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
					leaseInDto.setConvertCount(convertCount);
					leaseInDto.setConvertTime(searchSosoViewDto.getConvertTime());
				}
				leaseInDto.setPhone(sosoPhoneStr);
				leaseInDto.setComplaintFlag(sosoView.getComplaintFlag());
				leaseInDto.setComplaintTime(sosoView.getComplaintTime());
				leaseInDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间
				// 返回电话登记次数和转入系统次数
				Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
				leaseInDto.setRegisterStatus(phoneCount);
			} else {
				leaseInDto.setOwner(this.getEncryptOwnerName(leaseInDto.getOwner()));
				leaseInDto.setPhone(this.getEncryptPhone(sosoPhoneStr));
				leaseInDto.setTelePhone(this.getEncryptPhone(leaseInDto.getTelePhone()));
				leaseInDto.setMobilePhone(this.getEncryptPhone(leaseInDto.getMobilePhone()));
			}
			//判断中介虚假房源
			Integer tatusFlag = leaseInDto.getStatusFlag();
			leaseInDto.setHouseFlag(CommonUtil.getHouseFlg(tatusFlag));
		}
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜转铺列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@ApiOperation("获取搜搜转铺列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoShopListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOShopList")
	public ResponseJson getSOSOShopList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchShopMainInDataInfoDto> resultList = null;
		if ("SHOP_MAIN".equals(param.getTbName())) {
			resultList = searchShopMainMapper.getSoSoShopMainList(param);
		} else {
			resultList = search2ShopMainMapper.getSoSoShopMainList(param);
		}
		PageInfo<SearchShopMainInDataInfoDto> pageInfo = new PageInfo<>(resultList);
		if (resultList == null || resultList.isEmpty()) {
			return ErpResponseJson.ok(pageInfo);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchShopMainInDataInfoDto searchShopMainInDataInfoDto : resultList) {
			Integer sosoId = searchShopMainInDataInfoDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchShopMainInDataInfoDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}
		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchShopMainInDataInfoDto searchShopMainInDataInfoDto : resultList) {
			String mobilePhone = searchShopMainInDataInfoDto.getMobilePhone();
			String telePhone = searchShopMainInDataInfoDto.getTelePhone();
			String telSource = searchShopMainInDataInfoDto.getTelSource();
			phoneAddrMap.put(searchShopMainInDataInfoDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 3, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}

		for (int i = 0; i < resultList.size(); i++) {
			SearchShopMainInDataInfoDto dataInfoDto = resultList.get(i);
			Integer sosoId = dataInfoDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = dataInfoDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(dataInfoDto.getId());
			dataInfoDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(dataInfoDto.getId());
			dataInfoDto.setReaded("0");
			dataInfoDto.setConerted("0");
			if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
				dataInfoDto.setConerted("0");
				dataInfoDto.setReaded("1");
				
				SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
				if(null != searchSosoViewDto){
					Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
					dataInfoDto.setConvertCount(convertCount);
					dataInfoDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
				}
				dataInfoDto.setPhone(sosoPhoneStr);
				dataInfoDto.setComplaintFlag(sosoView.getComplaintFlag());
				dataInfoDto.setComplaintTime(sosoView.getComplaintTime());
				dataInfoDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间
				// 返回电话登记次数和转入系统次数
				Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
				dataInfoDto.setRegisterStatus(phoneCount);
			} else {
				dataInfoDto.setOwner(this.getEncryptOwnerName(dataInfoDto.getOwner()));
				dataInfoDto.setPhone(this.getEncryptPhone(sosoPhoneStr));
				dataInfoDto.setTelePhone(this.getEncryptPhone(dataInfoDto.getTelePhone()));
				dataInfoDto.setMobilePhone(this.getEncryptPhone(dataInfoDto.getMobilePhone()));
			}
			//判断中介虚假房源
			Integer tatusFlag = dataInfoDto.getStatusFlag();
			dataInfoDto.setHouseFlag(CommonUtil.getHouseFlg(tatusFlag));
		}
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜合租列表
	 * @author 张宏利
	 * @since 2016年8月18日
	 * @return
	 */
	@ApiOperation("获取搜搜合租列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoHezuListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOHezuList")
	public ResponseJson getSOSOHezuList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		this.generatorSearchInfo(param);
		// 查询数据
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		List<SearchHeZuDataInfoDto> resultList = null;
		if ("HEZU".equals(param.getTbName())) {
			resultList = searchHezuMapper.getSoSoHezuList(param);
		} else {
			resultList = search2HezuMapper.getSoSoHezuList(param);
		}
		PageInfo<SearchHeZuDataInfoDto> pageInfo = new PageInfo<>(resultList);
		if (resultList == null || resultList.isEmpty()) {
			return ErpResponseJson.ok(pageInfo);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
			Integer sosoId = searchHeZuDataInfoDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchHeZuDataInfoDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}
		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
			String mobilePhone = searchHeZuDataInfoDto.getMobilePhone();
			String telePhone = searchHeZuDataInfoDto.getTelePhone();
			String telSource = searchHeZuDataInfoDto.getTelSource();
			phoneAddrMap.put(searchHeZuDataInfoDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 4, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}
		for (int i = 0; i < resultList.size(); i++) {
			SearchHeZuDataInfoDto infoDto = resultList.get(i);
			Integer sosoId = infoDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = infoDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(infoDto.getId());
			infoDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(infoDto.getId());
			infoDto.setReaded("0");
			infoDto.setConerted("0");
			if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
				infoDto.setConerted("0");
				infoDto.setReaded("1");
				
				SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
				if (null != searchSosoViewDto) {
					Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
					infoDto.setConvertCount(convertCount);
					infoDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
				}
				infoDto.setPhone(sosoPhoneStr);
				infoDto.setComplaintFlag(sosoView.getComplaintFlag());
				infoDto.setComplaintTime(sosoView.getComplaintTime());
				infoDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间
				// 返回电话登记次数和转入系统次数
				Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
				infoDto.setRegisterStatus(phoneCount);
			} else {
				infoDto.setOwner(this.getEncryptOwnerName(infoDto.getOwner()));
				infoDto.setPhone(this.getEncryptPhone(sosoPhoneStr));
				infoDto.setTelePhone(this.getEncryptPhone(infoDto.getTelePhone()));
				infoDto.setMobilePhone(this.getEncryptPhone(infoDto.getMobilePhone()));
			}
			//判断中介虚假房源
			Integer tatusFlag = infoDto.getStatusFlag();
			infoDto.setHouseFlag(CommonUtil.getHouseFlg(tatusFlag));
		}
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * @detail  2020年3月23日12:02:11 He Wei task#0 兼容美联装修字段
	 * 获取搜搜出租详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜出租详细信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SearchLeaseInDataInfoDto.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOLeaseDataById")
	public ResponseJson getSOSOLeaseDataById(@Valid @RequestBody SoSoSaleDataInfoParam param) throws Exception {
		Operator operator = getOperator();
		Integer provinceId = operator.getProvinceId();
		Integer cityId = operator.getCityId();
		param.setCityId(cityId);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSOSOLeaseDataById", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		SearchLeaseInDataInfoDto dataInfoDto = JSON.parseObject(jsonObject.get("data").toString(), SearchLeaseInDataInfoDto.class);
		String fitment = dataInfoDto.getFitment();
		if("1".equals(fitment)){
			dataInfoDto.setFitment("1");
		}else {
			dataInfoDto.setFitment("8");
		}
		return ErpResponseJson.ok(dataInfoDto);
	}

	/**
	 * @detail  2020年3月23日12:02:11 He Wei task#0 兼容美联装修字段
	 * 获取搜搜出售详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜出售详细信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SearchSaleInDataInfoDto.class, message = "成功")
	})
	@RequestMapping(value="/getSaleInDataInfoById")
	public ResponseJson getSaleInDataInfoById(@Valid @RequestBody SoSoSaleDataInfoParam param) throws Exception {
		Operator operator = getOperator();
		Integer provinceId = operator.getProvinceId();
		Integer cityId = operator.getCityId();
		param.setCityId(cityId);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSaleInDataInfoById", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		SearchSaleInDataInfoDto dataInfoDto = JSON.parseObject(jsonObject.get("data").toString(), SearchSaleInDataInfoDto.class);
		String fitment = dataInfoDto.getFitment();
		if("1".equals(fitment)){
			dataInfoDto.setFitment("1");
		}else {
			dataInfoDto.setFitment("8");
		}
		return ErpResponseJson.ok(dataInfoDto);
	}

	/**
	 * 获取搜搜转铺详细信息
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜转铺详细信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SearchShopMainInDataInfoDto.class, message = "成功")
	})
	@RequestMapping(value="/getShopDataInfoById")
	public ResponseJson getShopDataInfoById(@Valid @RequestBody SoSoSaleDataInfoParam param) throws Exception {
		Operator operator = getOperator();
		Integer provinceId = operator.getProvinceId();
		Integer cityId = operator.getCityId();
		param.setCityId(cityId);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getShopDataInfoById", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		SearchShopMainInDataInfoDto dataInfoDto = JSON.parseObject(jsonObject.get("data").toString(), SearchShopMainInDataInfoDto.class);
		return ErpResponseJson.ok(dataInfoDto);
	}

	/**
	 * 获取搜搜合租详细信息
	 * @author 张宏利
	 * @since 2016年8月25日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取搜搜合租详细信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SearchHeZuDataInfoDto.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOHezuSmpInfo")
	public ResponseJson getSOSOHezuSmpInfo(@Valid @RequestBody SoSoSaleDataInfoParam param) throws Exception {
		Operator operator = getOperator();
		Integer provinceId = operator.getProvinceId();
		Integer cityId = operator.getCityId();
		param.setCityId(cityId);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSOSOHezuSmpInfo", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		SearchHeZuDataInfoDto dataInfoDto = JSON.parseObject(jsonObject.get("data").toString(), SearchHeZuDataInfoDto.class);
		return ErpResponseJson.ok(dataInfoDto);
	}

	/**
	 * 获取搜搜查看条数
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜查看条数")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOViewCount")
	public ResponseJson getSOSOViewCountController() {
		Operator operator = getOperator();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("mlUserId",operator.getUserId());
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSOSOViewCount", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		Map resultMap = JSON.parseObject(jsonObject.get("data").toString(), Map.class);

		return new ErpResponseJson(resultMap);
	}

	/**
	 * 获取搜搜电话
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取搜搜电话")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOConvertDetectData")
	public ResponseJson getSOSOConvertDetectData(@Valid @RequestBody SoSoConverDetectParam param) throws Exception {
		Operator operator = getOperator();
		Integer provinceId = operator.getProvinceId();
		Integer cityId = operator.getCityId();
		Map<String, Object> hashMap = new HashMap<>();
		hashMap = BeanUtil.objectToMap(param);
		hashMap.put("mlUserId",operator.getUserId());
		hashMap.put("provinceId",provinceId);
		hashMap.put("cityId",cityId);
		String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getSOSOConvertDetectData", hashMap);
		JSONObject jsonObject = JSONObject.parseObject(postJson);
		if(!"200".equals(jsonObject.get("errCode").toString())){
			throw new BusinessException(jsonObject.get("errMsg").toString());
		}
		List<Map> resultList = JSON.parseArray(jsonObject.get("data").toString(), Map.class);
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 获取SOSO转入和登记列表
	 * @author 朱科
	 * @since 2018年8月28日
	 * @return
	 */
	@ApiOperation(value = "获取SOSO转入和登记列表,需求:8379,作者:朱科")
	@PostMapping(value = "/getConvertOrRegisterList")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = FunSaleDto.class, message = "成功")
	})
	public ResponseJson getConvertOrRegisterList(@Valid @RequestBody SoSoConvertRegisterParam param){
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer deptId = operator.getDeptId();
		Integer adminCompId = operator.getAdminCompId();
		Integer grId = operator.getGrId();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Integer repeatId = param.getRepeatId();
		Integer sosoId = param.getSosoId(); // sosoId
		Integer sosoType = param.getSosoType(); // 
		String phone = param.getPhone();
		if(StringUtil.isNotBlank(phone)){
			phone =  EnCodeHelper.encode(phone);
		}
		if(null != repeatId && repeatId > 0){
			sosoId = repeatId;
		}
		Integer lookHouseRange = StringUtil.parseInteger(erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId,userId, "LOOK_HOUSE_RANGE"), 6);
		
		String runModel = erpSysParaMapper.getParamValue(cityId, compId, "SYSTEM_RUN_MODEL");
		List<ErpUserOpers> userOpersList = erpUserOpersMapper.getListById(cityId, userId);
		List<SearchSosoViewDto> sosoViewDataList = new ArrayList<SearchSosoViewDto>();
		if(null == userOpersList || userOpersList.isEmpty()){
			return ErpResponseJson.ok();
		}
		Map<String, String> opersMap = userOpersList.stream().collect(Collectors.toMap(ErpUserOpers::getOperId, ErpUserOpers::getOperId));
		boolean compListFlag = (null != opersMap.get("VIEW_COMP_HOUSE_LIST_INFO"));
		boolean areaListFlag = (null != opersMap.get("VIEW_AREA_HOUSE_LIST_INFO"));
		boolean regListFlag = (null != opersMap.get("VIEW_REG_HOUSE_LIST_INFO"));
		boolean deptListFlag = (null != opersMap.get("VIEW_DEPT_HOUSE_LIST_INFO"));
		boolean groupListFlag = (null != opersMap.get("VIEW_GROUP_HOUSE_LIST_INFO"));
		Integer trueViewRang = 6;
//		if("PRIVATE".equals(runModel)){
			if(compListFlag || lookHouseRange == 1){
				trueViewRang = 1;
			} else if (areaListFlag || lookHouseRange == 2){
				trueViewRang = 2;
			} else if (regListFlag || lookHouseRange == 3){
				trueViewRang = 3;
			} else if (deptListFlag || lookHouseRange == 4){
				trueViewRang = 4;
			} else if (groupListFlag || lookHouseRange == 5){
				trueViewRang = 5;
			} 
//		} else {
//			if(compListFlag){
//				trueViewRang = lookHouseRange;
//			} else if(areaListFlag){
//				if(lookHouseRange >= 2){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 2;
//				}
//			} else if(regListFlag){
//				if(lookHouseRange >= 3){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 3;
//				}
//			} else if(deptListFlag){
//				if(lookHouseRange >= 4){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 4;
//				}
//			} else if(groupListFlag){
//				if(lookHouseRange >= 5){
//					trueViewRang = lookHouseRange;
//				} else{
//					trueViewRang = 5;
//				}
//			}
//		}
		Set<Integer> caseIds = new HashSet<>();
		if(null != sosoId){
			Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("sosoId",sosoId);
			hashMap.put("adminCompId",adminCompId);
			String postJson = HttpUtil.postJson(AppConfig.getSosoWebPathHft()+"openApi/ml/getTransferRecords", hashMap);
			JSONObject jsonObject = JSONObject.parseObject(postJson);
			if("200".equals(jsonObject.get("errCode").toString())){
				List<Integer> data = JSON.parseArray(jsonObject.get("data").toString(), Integer.class);
				caseIds.addAll(data);
			}
		}

		if (CollectionUtils.isEmpty(caseIds) && StringUtils.isBlank(phone)) {
			return ErpResponseJson.ok();
		}

		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		if(1 == sosoType){
			sosoViewDataList = erpFunSaleMapper.getSosoViewDataList(cityId, compId, areaId, regId, deptId, grId, userId, caseIds, phone, trueViewRang);
		} else {
			sosoViewDataList = erpFunLeaseMapper.getSosoViewDataList(cityId, compId, areaId, regId, deptId, grId, userId, caseIds, phone, trueViewRang);
		}
		if(sosoViewDataList.isEmpty()){
			return ErpResponseJson.ok();
		}
		Set<Integer> userIds = sosoViewDataList.stream().collect(Collectors.mapping(SearchSosoViewDto::getUserId, Collectors.toSet()));
		List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		Map<Integer, String> userMap = usersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName));
		for (SearchSosoViewDto result : sosoViewDataList) {
			String userName = userMap.get(result.getUserId());
			result.setUserName(userName);
		}
		ErpResponseJson erpResponseJson = new ErpResponseJson();
		erpResponseJson.setData(sosoViewDataList);
		erpResponseJson.setTotal(Long.valueOf(sosoViewDataList.size()));
		erpResponseJson.setPageNum(param.getPageOffset());
		erpResponseJson.setPageSize(param.getPageRows());
		return erpResponseJson;
	}
	
	
	
	/**
	 * 创建搜搜的查看记录
	 * @author 张宏利
	 * @since 2018年5月31日
	 * @param sosoId
	 * @param repeatId
	 * @param sosoType
	 * @param sosoProperty
	 * @param oldData
	 */
	private void createSosoViewLog(Integer cityId ,Integer erpCompId ,Integer erpDeptId ,Integer archiveId, Integer adminDeptId, Integer sosoId, Integer sosoType, Integer sosoProperty, Byte oldData) {
		SearchSosoView viewPO = new SearchSosoView();
		viewPO.setCityId(cityId);
		viewPO.setErpCompId(erpCompId);
		viewPO.setErpDeptId(erpDeptId);
		viewPO.setArchiveId(archiveId);
		viewPO.setSosoId(sosoId);
		viewPO.setSosoType(sosoType);
		viewPO.setSosoProperty(sosoProperty);
		viewPO.setIsConvert((byte) 0);// 默认未转入系统
		viewPO.setViewTime(new Date());
		viewPO.setDeptId(adminDeptId);
		viewPO.setDataType(oldData);
		viewPO.setViewSource(Byte.valueOf("0"));
		try {
			searchSosoViewMapper.insertSelective(viewPO);
			searchSosoViewService.updateViewCount(viewPO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 搜搜查看扣费
	 * @author 张宏利
	 * @since 2018年5月31日
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/payForSoSoView")
	public ResponseJson payForViewSoSo(@RequestBody SoSoConverDetectParam param){
		Integer archiveId = getOperator().getArchiveId();
		Integer adminDeptId = getOperator().getAdminDeptId();

		// --获取当前查看电话信息
		Map<String, String> houseMap = this.getSSMobile(param);
		String repeatIdStr = houseMap.get("repeatId");
		String inTime = houseMap.get("inTime");
		String readed = houseMap.get("readed");
		Integer repeatId = StringUtil.parseInteger(repeatIdStr, null);
		double daysOfTwoDate = 0.0;
		if (StringUtil.isNotBlank(inTime)) {
			try {
				Date creationDate = DateTimeHelper.parseToDate(inTime, "yyyy-MM-dd HH:mm:ss");
				daysOfTwoDate = DateTimeHelper.getDaysOfTwoDate(new Date(), creationDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean isOldData = daysOfTwoDate > 90;
		if (!isOldData) {
			throw new ConfirmException("历史数据才能购买后查看");
		}
		if ("1".equals(readed)) {
			throw new ConfirmException("您已查看过该数据，请勿重复购买");
		}
		Byte dataType = 0;
		// 当前经纪人信息
		AdminFunArchive adminFunArchive = adminFunArchiveService.getFunArchiveByArchiveId(getOperator().getArchiveId());
		// 当前经纪人门店信息 精英版为null
		AdminFunDepts adminFunDepts = getSosoMobilePhoneDept(getOperator(), adminFunArchive);
		// 实名用户
		boolean isUserRight = "1".equals(getOperator().getUserRight());
		// plus会员
		boolean isPlusVip = adminFunArchiveService.judgeIsSupUser(getOperator().getArchiveId(), true);
		// 预存会员用户
    	boolean isPrestoreVip = isPrestoreVip(getOperator().getCompType(), adminFunDepts);
    	// 白金会员用户
    	boolean isPlatinumVip = isPlatinumVip(adminFunDepts);
    	// 房源库用户
    	boolean isHouseRepoVip = isHouseRepoVip(adminFunDepts);
    	// 终生会员用户
    	boolean isFeverVip = is4everVip(adminFunArchive);
		
		// 精英版
		boolean isPersonalVersion = getOperator().isPersonalVersion();
		// LINK版
		boolean isLinkEdition = getOperator().isLinkEdition();
		// 老赢销版
		boolean isOldMarketEdition = getOperator().isOldMarketEdition();
		// 单店版
		boolean isSingleDeptEdition = getOperator().isSingleDeptEdition();
		
		if (!(isFeverVip || isPlusVip || isPrestoreVip || isPlatinumVip || isHouseRepoVip) 
    			&& isUserRight && (isPersonalVersion) // 取消LINK季度外半年内数据收费的判断 
    			&& daysOfTwoDate > 90 && daysOfTwoDate <= 180) {// 一季度外半年内
			dataType = 2;
		} else if (daysOfTwoDate > 180) {// 半年外
			dataType = 1;
		}
		
		// --执行扣费逻辑
		BigDecimal payAmount = new BigDecimal(5);
		PayMoneyUtil.deductTelecastMoney(archiveId, payAmount, "SOSO_VIEW_PAY");

		// --写查看记录
		Integer sosoId = param.getSosoId();
		// 重复ID不为空则使用重复ID，小于10的都排除，不知道干啥的
		sosoId = (repeatId != null && repeatId > 10) ? repeatId : sosoId;
		this.createSosoViewLog(getOperator().getCityId(),getOperator().getCompId(), getOperator().getDeptId(), archiveId, adminDeptId, sosoId, param.getSosoType(), param.getSosoProperty(), dataType);
		return ErpResponseJson.ok();
	}

	/**
	 * 获取搜搜已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜已查看列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SoSoSaleListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOViewedSaleList")
	public ResponseJson getSOSOViewedSaleList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();

		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		param.setArchiveId(getOperator().getArchiveId());
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchSaleInDto> resultList = null;
		if ("SALE_IN".equals(param.getTbName())) {
			resultList = searchSaleInMapper.getSOSOViewedSaleList(param);
		} else {
			resultList = search2SaleInMapper.getSOSOViewedSaleList(param);
		}

		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchSaleInDto searchSaleInDto : resultList) {
			Integer sosoId = searchSaleInDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchSaleInDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo =new ArrayList<>();
		if (sosoIdSet.size()>0){
			viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		}
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}

		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchSaleInDto searchSaleInDto : resultList) {
			String mobilePhone = searchSaleInDto.getMobilePhone();
			String telePhone = searchSaleInDto.getTelePhone();
			String telSource = searchSaleInDto.getTelSource();
			phoneAddrMap.put(searchSaleInDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(1, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 1, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList=new ArrayList<>();
		if (sosoIdSet.size()>0){
			convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		}
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}
		for (int i = 0; i < resultList.size(); i++) {
			SearchSaleInDto saleInDto = resultList.get(i);
			Integer sosoId = saleInDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = saleInDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(saleInDto.getId());
			saleInDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(saleInDto.getId());
			SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
			if (null != searchSosoViewDto) {
				Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
				saleInDto.setConvertCount(convertCount);
				saleInDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
			}
			saleInDto.setPhone(sosoPhoneStr);
			// 返回电话登记次数和转入系统次数
			Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
			saleInDto.setRegisterStatus(phoneCount);
			if (sosoView!=null){
				saleInDto.setReaded("1");
				Byte isConvert = Optional.ofNullable(sosoView.getIsConvert()).orElse((byte) 0);
				if (isConvert == 1) {
					saleInDto.setConerted("1");
				}

				saleInDto.setComplaintFlag(sosoView.getComplaintFlag());
				saleInDto.setComplaintTime(sosoView.getComplaintTime());
				saleInDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间

			}
			Integer tatusFlag = saleInDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			saleInDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchSaleInDto> pageInfo = new PageInfo<>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜出租已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜出租已查看列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoLeaseListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOViewedLeaseList")
	public ResponseJson getSOSOViewedLeaseList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();

		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		param.setArchiveId(getOperator().getArchiveId());
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchLeaseInDto> resultList = null;
		if ("LEASE_IN".equals(param.getTbName())) {
			resultList = searchLeaseInMapper.getSOSOViewedLeaseList(param);
		} else {
			resultList = search2LeaseInMapper.getSOSOViewedLeaseList(param);
		}

		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchLeaseInDto searchLeaseInDto : resultList) {
			Integer sosoId = searchLeaseInDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchLeaseInDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo =new ArrayList<>();
		if (sosoIdSet.size()>0){
			viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		}
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}

		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchLeaseInDto searchLeaseInDto : resultList) {
			String mobilePhone = searchLeaseInDto.getMobilePhone();
			String telePhone = searchLeaseInDto.getTelePhone();
			String telSource = searchLeaseInDto.getTelSource();
			phoneAddrMap.put(searchLeaseInDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 2, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList=new ArrayList<>();
		if (sosoIdSet.size()>0){
			convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		}
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}

		for (int i = 0; i < resultList.size(); i++) {
			SearchLeaseInDto leaseInDto = resultList.get(i);
			Integer sosoId = leaseInDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = leaseInDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(leaseInDto.getId());
			leaseInDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(leaseInDto.getId());
			leaseInDto.setPhone(sosoPhoneStr);
			// 返回电话登记次数和转入系统次数
			Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
			leaseInDto.setRegisterStatus(phoneCount);
			SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
			if (null != searchSosoViewDto) {
				Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
				leaseInDto.setConvertCount(convertCount);
				leaseInDto.setConvertTime(searchSosoViewDto.getConvertTime());
			}
			if (sosoView!=null){
				leaseInDto.setReaded("1");
				Byte isConvert = Optional.ofNullable(sosoView.getIsConvert()).orElse((byte) 0);
				if (isConvert == 1) {
					leaseInDto.setConerted("1");
				}
				leaseInDto.setComplaintFlag(sosoView.getComplaintFlag());
				leaseInDto.setComplaintTime(sosoView.getComplaintTime());
				leaseInDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间
			}

			Integer tatusFlag = leaseInDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			leaseInDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchLeaseInDto> pageInfo = new PageInfo<SearchLeaseInDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜转铺已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜转铺已查看列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoShopListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOViewedShopList")
	public ResponseJson getSOSOViewedShopList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		param.setArchiveId(getOperator().getArchiveId());
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchShopMainInDataInfoDto> resultList = null;
		if ("SHOP_MAIN".equals(param.getTbName())) {
			resultList = searchShopMainMapper.getSOSOViewedShopList(param);
		} else {
			resultList = search2ShopMainMapper.getSOSOViewedShopList(param);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchShopMainInDataInfoDto shopMainInDataInfoDto : resultList) {
			Integer sosoId = shopMainInDataInfoDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? shopMainInDataInfoDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo =new ArrayList<>();
		if (sosoIdSet.size()>0){
			viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		}
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}

		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchShopMainInDataInfoDto shopMainInDataInfoDto : resultList) {
			String mobilePhone = shopMainInDataInfoDto.getMobilePhone();
			String telePhone = shopMainInDataInfoDto.getTelePhone();
			String telSource = shopMainInDataInfoDto.getTelSource();
			phoneAddrMap.put(shopMainInDataInfoDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 3, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList=new ArrayList<>();
		if (sosoIdSet.size()>0){
			convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		}
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}

		for (int i = 0; i < resultList.size(); i++) {
			SearchShopMainInDataInfoDto shopMainInDataInfoDto = resultList.get(i);
			Integer sosoId = shopMainInDataInfoDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = shopMainInDataInfoDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(shopMainInDataInfoDto.getId());
			shopMainInDataInfoDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(shopMainInDataInfoDto.getId());
			SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
			if (null != searchSosoViewDto) {
				Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
				shopMainInDataInfoDto.setConvertCount(convertCount);
				shopMainInDataInfoDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
			}
			shopMainInDataInfoDto.setPhone(sosoPhoneStr);
			// 返回电话登记次数和转入系统次数
			Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
			shopMainInDataInfoDto.setRegisterStatus(phoneCount);
			if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
				shopMainInDataInfoDto.setConerted("0");
				shopMainInDataInfoDto.setReaded("1");

				shopMainInDataInfoDto.setComplaintFlag(sosoView.getComplaintFlag());
				shopMainInDataInfoDto.setComplaintTime(sosoView.getComplaintTime());
				shopMainInDataInfoDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间

			}

			Integer tatusFlag = shopMainInDataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			shopMainInDataInfoDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchShopMainInDataInfoDto> pageInfo = new PageInfo<>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜合租已查看列表
	 * @author 张宏利
	 * @since 2016年8月19日
	 * @return
	 */
	@ApiOperation("获取搜搜合租已查看列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = SosoHezuListVo.class, message = "成功")
	})
	@RequestMapping(value="/getSOSOViewedHeZuList")
	public ResponseJson getSOSOViewedHeZuList(@Valid @RequestBody SoSoSaleListParam param){
		Integer cityId = getOperator().getCityId();
		Integer adminCompId = getOperator().getAdminCompId();

		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		param.setArchiveId(getOperator().getArchiveId());
		this.generatorSearchInfo(param);
		// 查询数据
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchHeZuDataInfoDto> resultList = null;
		if ("HEZU".equals(param.getTbName())) {
			resultList = searchHezuMapper.getSOSOViewedHeZuList(param);
		} else {
			resultList = search2HezuMapper.getSOSOViewedHeZuList(param);
		}
		List<Integer> sosoIdSet = new LinkedList<>();
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
			Integer sosoId = searchHeZuDataInfoDto.getRepeatId();
			sosoId = (sosoId == null || sosoId <= 10) ? searchHeZuDataInfoDto.getId() : sosoId;
			sosoIdSet.add(sosoId);
		}
		List<SearchSosoView> viewInfo =new ArrayList<>();
		if (sosoIdSet.size()>0){
			viewInfo = searchSosoViewMapper.getSoSoViewList(sosoIdSet.toArray(new Integer[]{}),null, getOperator().getArchiveId());
		}
		Map<Integer, SearchSosoView> viewMap = new HashMap<>();
		for (SearchSosoView searchSosoView : viewInfo) {
			viewMap.put(searchSosoView.getSosoId(), searchSosoView);
		}

		Map<Integer, String> phoneAddrMap = new HashMap<>();
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto : resultList) {
			String mobilePhone = searchHeZuDataInfoDto.getMobilePhone();
			String telePhone = searchHeZuDataInfoDto.getTelePhone();
			String telSource = searchHeZuDataInfoDto.getTelSource();
			phoneAddrMap.put(searchHeZuDataInfoDto.getId(), this.getSalePhone(mobilePhone, telePhone, telSource));
		}
		// 电话登记次数
		Map<String, Integer> phoneCountMap = this.getPhoneCountMap(2, phoneAddrMap);
		Map<Integer, String> searchPhotoZjMap = new HashMap<>();
		Map<Integer, SearchSosoViewDto> convertCountMap = new HashMap<>();
		// 获取第一张图片和搜搜转入系统次数列表
		if (phoneAddrMap.size() > 0) {
			List<Integer> caseIds = new LinkedList<>(phoneAddrMap.keySet());
			// 查询第一张图片地址列表
			List<SearchPhotoZj> photoZjList = searchPhotoZjMapper.getPhotoZjList(cityId, 4, caseIds);
			if (photoZjList.size() > 0) {
				searchPhotoZjMap = photoZjList.stream().collect(Collectors.toMap(SearchPhotoZj::getSlId, val -> val.getPhotoAddr()));
			}
		}
		// 统计搜搜转入系统次数列表
		List<SearchSosoViewDto> convertCountList=new ArrayList<>();
		if (sosoIdSet.size()>0){
			convertCountList = searchSosoViewMapper.getConvertCountList(adminCompId, sosoIdSet);
		}
		if (convertCountList.size() > 0) {
			convertCountMap = convertCountList.stream().collect(Collectors.toMap(SearchSosoViewDto::getSosoId, val -> val));
		}

		for (int i = 0; i < resultList.size(); i++) {
			SearchHeZuDataInfoDto searchHeZuDataInfoDto = resultList.get(i);
			Integer sosoId = searchHeZuDataInfoDto.getRepeatId();
			if (sosoId == null || sosoId <= 10) {
				sosoId = searchHeZuDataInfoDto.getId();
			}
			// 查询第一张图片地址
			String firstPhoto = searchPhotoZjMap.get(searchHeZuDataInfoDto.getId());
			searchHeZuDataInfoDto.setThumbUrl(CommonUtil.getSoSoPhotoUrl(firstPhoto));
			// 查看记录
			SearchSosoView sosoView = viewMap.get(sosoId);
			String sosoPhoneStr = phoneAddrMap.get(searchHeZuDataInfoDto.getId());
			searchHeZuDataInfoDto.setPhone(sosoPhoneStr);
			SearchSosoViewDto searchSosoViewDto = convertCountMap.get(sosoId);
			if (null != searchSosoViewDto) {
				Integer convertCount = Optional.ofNullable(searchSosoViewDto.getConvertCount()).orElse(0);
				searchHeZuDataInfoDto.setConvertCount(convertCount);
				searchHeZuDataInfoDto.setConvertTime(DateTimeHelper.formatDateTimetoString(searchSosoViewDto.getConvertTime()));
			}
			// 返回电话登记次数和转入系统次数
			Integer phoneCount = Optional.ofNullable(phoneCountMap.get(sosoPhoneStr)).orElse(0);
			searchHeZuDataInfoDto.setRegisterStatus(phoneCount);
			if (sosoView != null && sosoView.getSosoId() != null && sosoView.getSosoId() > 0) {
				searchHeZuDataInfoDto.setConerted("0");
				searchHeZuDataInfoDto.setReaded("1");

				searchHeZuDataInfoDto.setComplaintFlag(sosoView.getComplaintFlag());
				searchHeZuDataInfoDto.setComplaintTime(sosoView.getComplaintTime());
				searchHeZuDataInfoDto.setPbTime(DateTimeHelper.formatDateTimetoString(sosoView.getViewTime()));//查看时间

			}


			Integer tatusFlag = searchHeZuDataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			searchHeZuDataInfoDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchHeZuDataInfoDto> pageInfo = new PageInfo<>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * 获取搜搜数据通过sosoId和房源类型
	 * @param param
	 * @return
	 */
	public Map<String, String> getSSMobile(SoSoConverDetectParam param) {
		String mobilePhone = null;
		String telePhone = null;
		String telSource = null;
		Integer repeatId = null;
		String readed = null;
		String owner = null;
		Date inTime = null;
		SoSoSaleDataInfoParam dataInfoParam = new SoSoSaleDataInfoParam();
		dataInfoParam.setProvinceId(getOperator().getProvinceId());
		dataInfoParam.setCityId(getOperator().getCityId());
		dataInfoParam.setArchiveId(getOperator().getArchiveId());
		if (null != param.getRepeatId() && param.getRepeatId() > 10) {
			dataInfoParam.setSosoId(param.getRepeatId());
		} else {
			dataInfoParam.setSosoId(param.getSosoId());
		}

		if ("1".equals(param.getType())) {
			if(StringUtil.isNotEmpty(param.getInTime())){
				dataInfoParam.setTime(DateConvert.convertInTimeToDigit(param.getInTime()));
			}
			String[] tables = CommonUtil.getSaleTableNameAndDetailName(dataInfoParam.getTime());
			dataInfoParam.setTbName(tables[0]);
			dataInfoParam.setTbNameDetail(tables[1]);
			// 查询数据
			SearchSaleInDataInfoDto houseInfo = null;
			if ("SALE_IN".equals(tables[0])) {
				houseInfo = searchSaleInMapper.getSaleInDataInfoById(dataInfoParam);
			} else {
				houseInfo = search2SaleInMapper.getSaleInDataInfoById(dataInfoParam);
			}
			if (houseInfo!= null) {
				Integer tatusFlag = houseInfo.getStatusFlag();
				// 判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				houseInfo.setHouseFlag(tatusFlag);
				mobilePhone = houseInfo.getMobilePhone();
				telePhone = houseInfo.getTelePhone();
				telSource = houseInfo.getTelSource();
				inTime = houseInfo.getInTime();
				repeatId = houseInfo.getRepeatId();
				readed = houseInfo.getReaded();
				owner = houseInfo.getOwner();
			} else if (null != param.getRepeatId() && param.getRepeatId() > 10) {// 如果repeatId() > 10 && houseInfo==null，则需要查询sale_2、3、4表中数据，
				boolean flag = true;
				while (flag) {
					if ("SALE_IN".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SALE_2");
						dataInfoParam.setTbNameDetail("sale_2_detail");
					} else if ("SALE_2".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SALE_3");
						dataInfoParam.setTbNameDetail("sale_3_detail");
					} else if ("SALE_3".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SALE_4");
						dataInfoParam.setTbNameDetail("sale_4_detail");
					} else {
						flag = false;
					}
					houseInfo = search2SaleInMapper.getSaleInDataInfoById(dataInfoParam);
					if (null != houseInfo) {
						Integer tatusFlag = houseInfo.getStatusFlag();
						// 判断中介虚假房源
						tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
						houseInfo.setHouseFlag(tatusFlag);
						mobilePhone = houseInfo.getMobilePhone();
						telePhone = houseInfo.getTelePhone();
						telSource = houseInfo.getTelSource();
						inTime = houseInfo.getInTime();
						repeatId = houseInfo.getRepeatId();
						readed = houseInfo.getReaded();
						owner = houseInfo.getOwner();
						flag = false;
					}
				}
			}
		} else if ("2".equals(param.getType())) {
			if(StringUtil.isNotEmpty(param.getInTime())){
				dataInfoParam.setTime(DateConvert.convertInTimeToDigit(param.getInTime()));
			}
			String[] tables = CommonUtil.getLeaseTableNameAndDetailName(dataInfoParam.getTime());
			dataInfoParam.setTbName(tables[0]);
			dataInfoParam.setTbNameDetail(tables[1]);
			// 查询数据
			SearchLeaseInDataInfoDto houseInfo = null;
			if("LEASE_IN".equals(tables[0])) {
				houseInfo = searchLeaseInMapper.getDataInfoById(dataInfoParam);
			} else {
				houseInfo = search2LeaseInMapper.getDataInfoById(dataInfoParam);
			}
			if( houseInfo != null ){
				Integer tatusFlag = houseInfo.getStatusFlag();
				// 判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				houseInfo.setHouseFlag(tatusFlag);
				mobilePhone = houseInfo.getMobilePhone();
				telePhone = houseInfo.getTelePhone();
				telSource = houseInfo.getTelSource();
				inTime = houseInfo.getInTime();
				repeatId = houseInfo.getRepeatId();
				readed = houseInfo.getReaded();
				owner = houseInfo.getOwner();
			} else if (null != param.getRepeatId() && param.getRepeatId() > 10) {// 如果repeatId() > 10 && houseInfo==null，则需要查询sale_2、3、4表中数据，
				boolean flag = true;
				while (flag) {
					if ("LEASE_IN".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("LEASE_2");
						dataInfoParam.setTbNameDetail("lease_2_detail");
					} else if ("LEASE_2".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("LEASE_3");
						dataInfoParam.setTbNameDetail("lease_3_detail");
					} else if ("LEASE_3".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("LEASE_4");
						dataInfoParam.setTbNameDetail("lease_4_detail");
					} else {
						flag = false;
					}
					houseInfo = search2LeaseInMapper.getDataInfoById(dataInfoParam);
					if (null != houseInfo) {
						Integer tatusFlag = houseInfo.getStatusFlag();
						// 判断中介虚假房源
						tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
						houseInfo.setHouseFlag(tatusFlag);
						mobilePhone = houseInfo.getMobilePhone();
						telePhone = houseInfo.getTelePhone();
						telSource = houseInfo.getTelSource();
						inTime = houseInfo.getInTime();
						repeatId = houseInfo.getRepeatId();
						readed = houseInfo.getReaded();
						owner = houseInfo.getOwner();
						flag = false;
					}
				}
			}
		} else if ("3".equals(param.getType())) {
			if(StringUtil.isNotEmpty(param.getInTime())){
				dataInfoParam.setTime(DateConvert.convertInTimeToDigit(param.getInTime()));
			}
			String[] tables = CommonUtil.getShopTableNameAndDetailName(dataInfoParam.getTime());
			dataInfoParam.setTbName(tables[0]);
			dataInfoParam.setTbNameDetail(tables[1]);
			// 查询数据
			SearchShopMainInDataInfoDto houseInfo = null;
			if("SHOP_MAIN".equals(tables[0])) {
				houseInfo = searchShopMainMapper.getDataInfoById(dataInfoParam);
			} else {
				houseInfo = search2ShopMainMapper.getDataInfoById(dataInfoParam);
			}
			if(houseInfo != null){
				Integer tatusFlag = houseInfo.getStatusFlag();
				//判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				houseInfo.setHouseFlag(tatusFlag);
				mobilePhone = houseInfo.getMobilePhone();
				telePhone = houseInfo.getTelePhone();
				telSource = houseInfo.getTelSource();
				inTime = houseInfo.getInTime();
				repeatId = houseInfo.getRepeatId();
				readed = houseInfo.getReaded();
				owner = houseInfo.getOwner();
			} else if (null != param.getRepeatId() && param.getRepeatId() > 10) {// 如果repeatId() > 10 && houseInfo==null，则需要查询sale_2、3、4表中数据，
				boolean flag = true;
				while (flag) {
					if ("SHOP_MAIN".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SHOP_2");
						dataInfoParam.setTbNameDetail("shop_2_detail");
					} else if ("SHOP_2".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SHOP_3");
						dataInfoParam.setTbNameDetail("shop_3_detail");
					} else if ("SHOP_3".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("SHOP_4");
						dataInfoParam.setTbNameDetail("shop_4_detail");
					} else {
						flag = false;
					}
					houseInfo = search2ShopMainMapper.getDataInfoById(dataInfoParam);
					if (null != houseInfo) {
						Integer tatusFlag = houseInfo.getStatusFlag();
						// 判断中介虚假房源
						tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
						houseInfo.setHouseFlag(tatusFlag);
						mobilePhone = houseInfo.getMobilePhone();
						telePhone = houseInfo.getTelePhone();
						telSource = houseInfo.getTelSource();
						inTime = houseInfo.getInTime();
						repeatId = houseInfo.getRepeatId();
						readed = houseInfo.getReaded();
						owner = houseInfo.getOwner();
						flag = false;
					}
				}
			}
		} else if ("4".equals(param.getType())) {
			if(StringUtil.isNotEmpty(param.getInTime())){
				dataInfoParam.setTime(DateConvert.convertInTimeToDigit(param.getInTime()));
			}
			String[] tables = CommonUtil.getHezuTableNameAndDetailName(dataInfoParam.getTime());
			dataInfoParam.setTbName(tables[0]);
			dataInfoParam.setTbNameDetail(tables[1]);
			// 查询数据
			SearchHeZuDataInfoDto houseInfo = null;
			if("HEZU".equals(tables[0])) {
				houseInfo = searchHezuMapper.getDataInfoById(dataInfoParam);
			} else {
				houseInfo = search2HezuMapper.getDataInfoById(dataInfoParam);
			}
			if(houseInfo != null){
				Integer tatusFlag = houseInfo.getStatusFlag();
				//判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				houseInfo.setHouseFlag(tatusFlag);
				mobilePhone = houseInfo.getMobilePhone();
				telePhone = houseInfo.getTelePhone();
				telSource = houseInfo.getTelSource();
				inTime = houseInfo.getInTime();
				repeatId = houseInfo.getRepeatId();
				readed = houseInfo.getReaded();
				owner = houseInfo.getOwner();
			} else if (null != param.getRepeatId() && param.getRepeatId() > 10) {// 如果repeatId() > 10 && houseInfo==null，则需要查询sale_2、3、4表中数据，
				boolean flag = true;
				while (flag) {
					if ("HEZU".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("HEZU_2");
						dataInfoParam.setTbNameDetail("hezu_2_detail");
					} else if ("HEZU_2".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("HEZU_3");
						dataInfoParam.setTbNameDetail("hezu_3_detail");
					} else if ("HEZU_3".equals(dataInfoParam.getTbName())) {
						dataInfoParam.setTbName("HEZU_4");
						dataInfoParam.setTbNameDetail("hezu_4_detail");
					} else {
						flag = false;
					}
					houseInfo = search2HezuMapper.getDataInfoById(dataInfoParam);
					if (null != houseInfo) {
						Integer tatusFlag = houseInfo.getStatusFlag();
						// 判断中介虚假房源
						tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
						houseInfo.setHouseFlag(tatusFlag);
						mobilePhone = houseInfo.getMobilePhone();
						telePhone = houseInfo.getTelePhone();
						telSource = houseInfo.getTelSource();
						inTime = houseInfo.getInTime();
						repeatId = houseInfo.getRepeatId();
						readed = houseInfo.getReaded();
						owner = houseInfo.getOwner();
						flag = false;
					}
				}
			}
		}
		mobilePhone = StringUtil.isEmpty(mobilePhone) ? "" : HTMLHelper
				.toHTMLString(mobilePhone, HTMLHelper.ES_DEF$INPUT)
				.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");
		telePhone = StringUtil.isEmpty(telePhone) ? "" : HTMLHelper
				.toHTMLString(telePhone, HTMLHelper.ES_DEF$INPUT)
				.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");

		if(telSource == null) {
			telSource = "";
		}
		repeatId = (repeatId == null || repeatId <= 10) ? 0 : repeatId;
		String cellPhone = (mobilePhone + " " + telePhone).trim();
		String hasPicPhone = StringUtil.isEmpty(telSource) ? "0" : "1";
		telSource = StringHelper.replace(telSource, "\\", "/");
		telSource = CommonUtil.getSoSoPhonePicUrl(telSource);
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("phone", hasPicPhone.equals("0") ? cellPhone : telSource);
		resultMap.put("ispic", hasPicPhone);
		resultMap.put("inTime", DateTimeHelper.formatDateTimetoString(inTime));
		resultMap.put("repeatId", String.valueOf(repeatId));
		resultMap.put("readed", readed);
		resultMap.put("owner", owner);
		return resultMap;
	}

	/**
	 * 获取搜搜查看条数
	 * @author 张宏利
	 * @param sosoDataType 1=一季内数据、2=一季外半年内、3=半年外
	 * @since 2016年8月19日
	 * @return
	 */
	public Map<String, String> getSOSOViewCount(int sosoDataType) {
		Operator operator = getOperator();
		// 七天登录的验证：0=不提示，1=提示用户下载，2=7天没有登录过APP，引导用户登录
		Integer applogined = this.getAppLoginEnd();
		// 2019-06-04 房口袋用户不受七天未登录限制
		applogined = operator.isSpecialSustomized() ? 0 : applogined;
		// 白金会员判断
		Integer archiveId = operator.getArchiveId();
//		Integer adminDeptId = operator.getAdminDeptId();
//		Integer compType = operator.getCompType();
		Integer cityId = operator.getCityId();
		
		// 当前经纪人信息
		AdminFunArchive adminFunArchive = adminFunArchiveService.getFunArchiveByArchiveId(archiveId);
		// 当前经纪人门店信息 精英版为null
		AdminFunDepts adminFunDepts = getSosoMobilePhoneDept(operator, adminFunArchive);
		// 搜搜查看电话受不受手机APP登录限制，1=要收限制
		AdminFunCity adminFunCityPO = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
		Integer phoneBound = adminFunCityPO.getPhoneBound();
		phoneBound = (phoneBound == null) ? 0 : phoneBound;
		Map<String, String> resultMap = getViewCountByPlusVipRule(sosoDataType, applogined, phoneBound, adminFunArchive, adminFunDepts, operator);
//		if (operator.isPersonalVersion()) {
//			resultMap = this.getPerViewCount(sosoDataType, userRight, archiveId, applogined, isPlusVip, phoneBound, compType);
//		} else {
//			resultMap = this.getDeptViewCount(sosoDataType, userRight, archiveId, applogined, isPlusVip, deptLevel,
//					custLevel, adminDeptId, phoneBound, compType);
//		}
		return resultMap;
	}
	
	//------------------------------------------新版PLUS会↓员20190223--------------------------------------------------
    // 新版会员的查看的限制条件常量
    /** * PLUS会员每天查看半年以内的数据量,也是每天总量 */
    private static final int PLUS_VIP_VIEW_COUNT_PER_DAY = 50;
    /** * PLUS会员每天查看半年以外历史数据量 */
    private static final int PLUS_VIP_VIEW_HISTORY_COUNT_PER_DAY = 30;
    /** * 实名认证用户每天查看季度以内的数据量,也是每天总量  */
    private static final int RIGHT_VIEW_COUNT_PER_DAY = 50;
    /** * 实名认证单店或LINK版用户每天查看半年以外历史数据量 */
    private static final int RIGHT_VIEW_HISTORY_COUNT_PER_DAY = 30;
    /** * 皇冠 终身 白金 房源库 每天查看半年以内数据量,也是每天总量  */
    private static final int OTHER_VIP_VIEW_COUNT_PER_DAY = 50;
    /** * 皇冠 终身 白金 房源库 每天查看半年以外历史数据量 */
    private static final int OTHER_VIP_VIEW_HISTORY_COUNT_PER_DAY = 30;
    /** * 皇冠 终身 白金 房源库 每天查看半年以外免费历史数据量 */
    private static final int OTHER_VIP_FREE_VIEW_HISTORY_COUNT_PER_DAY = 15;
    /** * 门店每天查看数据量 */
    private static final int DEPT_VIEW_COUNT_PER_YEAR = 10000;
    /** * 实名认证精英版用户每天付费查看季度外半年内的数据量  */
    private static final int RIGHT_PERSONAL_VIEW_COUNT_PER_DAY = 30;
    /** * 实名认证门店版用户每天付费查看季度外半年内的数据量  */
    private static final int RIGHT_LINK_VIEW_COUNT_PER_DAY = 30;
    
    // 新版会员判断后返回的类型常量
    /**可以直接免费看 */
    private static final int VIEW_FREE_CAN_VIEW = 0;
    /**当天的总条数已经达上限，不能再看了 */
    private static final int VIEW_OVER_ALL_COUNT_CANT_VIEW = 1;
    /**不能查看半年外的数据 */
    private static final int VIEW_NEED_DOWNLOAD_APP_CANT_VIEW = 2;
    /**七天没登录的用户，引导登录APP */
    private static final int VIEW_NEED_LOGIN_APP_CANT_VIEW = 3;
    /**引导实名认证 */
    private static final int VIEW_NEED_USER_RIGHT = 4;
    /**查看历史数据免费15条用光后的另外15条要收费的的操作 */
    private static final int VIEW_15_HISTORY_NEED_BEANS = 1000000000;
    /**当天个人的历史数据的总条数已达上限，不能再看历史数据了 */
    private static final int VIEW_OVER_HISTORY_COUNT_CANT_VIEW = 7;
    /**超出门店10000条/年/店的上限 */
    private static final int VIEW_DEPT_OVER_10000 = 8;
    /**精英版认证会员看半年外数据提示升级PLUS */
    private static final int VIEW_HISTORY_RIGHT_CANT_VIEW_UPGRADE_PLUS = 9;
    /**赢销版版认证会员看季度外数据提示升级LINK */
    private static final int VIEW_HISTORY_RIGHT_CANT_VIEW_UPGRADE_LINK = 13;
    /**物业版认证会员看季度外数据提示升级预存好房豆  2019-11-12因为已经没有充值好房豆成会员的政策了，ERP前端提示的是升级plus*/
    private static final int VIEW_HISTORY_RIGHT_CANT_VIEW_NEED_PRESTORE_BEANS = 14;
    /**通过好房豆查看数据 */
    private static final int VIEW_SELECT_BY_BEANS = 1000000000;
    /** */
    private static final int VIEW_NOT_VERIFIED_TOTAL_ONLY_50 = 1000000000;
    /**是已经看过的数据直接查看 */
    private static final int VIEW_HAS_VIEWED = 1000000000;
    /**查看历史数据需要消费好房豆的操作 */
    private static final int VIEW_HISTORY_NEED_BEANS = 16;
    
    // 不能查看原因：1=今日查看条数达到上限，2=引导下载APP，3=7天没有登录过APP，4=历史数据实名认证后查看更多
	// 5=非O2O会员只能查看一季度内的，6=超级房源库才能查看历史数据，7=今日历史数据查看条数达到上限
	// 8=门店总查看条数达到上限，9=精英版认证会员提示升级plusVip查看更多，10=续费O2O查看更多，11=VIP或O2O但未实名认证
	// 12=未实名认证终身50条，实名认证后查看更多，13=新营销版季度内数据达到上限，14=新营销版查看季度外数据提示升级LINK
    // 15=物业版认证会员看季度外数据提示升级预存好房豆
	// 16=提示需要消耗5好房豆才能查看
    
  //------------------------------------------新版PLUS会↑员20190223--------------------------------------------------
    
	/**
	 * 新版PLUS会员查看搜搜逻辑
	 * @param sosoDataType 1=一季内数据、2=一季外半年内、3=半年外
	 * @param applogined 七天登录的验证：0=不提示，1=提示用户下载，2=7天没有登录过APP，引导用户登录
	 * @param phoneBound 搜搜查看电话受不受手机APP登录限制，1=要收限制
	 * @param adminFunArchive 经纪人信息
	 * @param adminFunDepts 经纪人门店信息（可能为null）
	 * @param operator 会话信息
	 * @since 2019年2月23日
	 * @return map 返回map
	 */
	private Map<String, String> getViewCountByPlusVipRule(int sosoDataType, Integer applogined, Integer phoneBound,
			AdminFunArchive adminFunArchive, AdminFunDepts adminFunDepts, Operator operator) {
		Integer archiveId = operator.getArchiveId();
		// 实名用户
		boolean isUserRight = "1".equals(operator.getUserRight());
		// plus会员
		boolean isPlusVip = adminFunArchiveService.judgeIsSupUser(archiveId, true);
		// 预存会员用户
    	boolean isPrestoreVip = isPrestoreVip(operator.getCompType(), adminFunDepts);
    	// 白金会员用户
    	boolean isPlatinumVip = isPlatinumVip(adminFunDepts);
    	// 房源库用户
    	boolean isHouseRepoVip = isHouseRepoVip(adminFunDepts);
    	// 终生会员用户
    	boolean isFeverVip = is4everVip(adminFunArchive);
		
		// 精英版
		boolean isPersonalVersion = operator.isPersonalVersion();
		// LINK版
		boolean isLinkEdition = operator.isLinkEdition();
		// 物业版
		boolean isPropertyEdition = operator.isPropertyEdition();
		// 新赢销版
		boolean isMarketEdition = operator.isMarketEdition();
		// 老赢销版
		boolean isOldMarketEdition = operator.isOldMarketEdition();
		// 单店版
		boolean isSingleDeptEdition = operator.isSingleDeptEdition();
		
		int cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
		String todayStartTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		// 剩下的可看的数量
		int canViewCount = 0;
		int oldCanViewCount = 0;
		int todayHasViewSosoNum = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
		if (1 == sosoDataType) {// 查看季度内数据
			if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名用户在每天总条数内
				canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
				cantViewReson = VIEW_FREE_CAN_VIEW;
				if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
					cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
				}
			} else {// 实名用户达每天总条数上限
				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
			}
		} else {// 季度外不可看根据版本提示不同的信息
			cantViewReson =  VIEW_NEED_DOWNLOAD_APP_CANT_VIEW;
		}



//		if (isUserRight) {
//			if (isFeverVip) {// 终生会员并且是精英版
//	    		int todayHasViewSosoNum = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//	    		if (1 == sosoDataType || 2 == sosoDataType) {// 半年内数据
//	    			if (isViewSosoTodayLt(OTHER_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 终生会员在每天免费条数内
//	    				canViewCount = OTHER_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    				cantViewReson = VIEW_FREE_CAN_VIEW;
//	    				if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//							cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//						}
//	    			} else {// 终生会员超出了每天的总条数上限
//	    				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    			}
//	    		} else {// 半年外的数据
//	    			if (isViewSosoTodayLt(OTHER_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 终生会员在每天总条数内
//	    				int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//	    				if (isViewSosoTodayLt(OTHER_VIP_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 也在历史数据条数内
//	    					canViewCount = OTHER_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    					oldCanViewCount = OTHER_VIP_VIEW_HISTORY_COUNT_PER_DAY - oldDataViewCount;
//	    					if (isViewSosoTodayLt(OTHER_VIP_FREE_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 前15条历史数据免费
//	    						cantViewReson = VIEW_FREE_CAN_VIEW;
//	    					} else {// 后15条历史数据收费
//	    						cantViewReson = VIEW_HISTORY_NEED_BEANS;
//	    					}
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	    				} else {// 终生会员历史数据达上限
//	    					cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	    				}
//	    			} else {// 终生会员达每天总条数上限
//	    				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    			}
//	    		}
//	    	} else if (isPlusVip || isPrestoreVip) {// PLUS会员或者预存会员
//				int todayHasViewSosoNum = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//	    		if (1 == sosoDataType || 2 == sosoDataType) {// 半年内数据
//	    			if (isViewSosoTodayLt(PLUS_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 在每天免费条数内
//	    				canViewCount = PLUS_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    				cantViewReson = VIEW_FREE_CAN_VIEW;
//						if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//							cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//						}
//	    			} else {// 会员超出了每天的总条数上限
//	    				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    			}
//	    		} else {// 半年外的数据 sosoDataType == 3
//	    			if (isViewSosoTodayLt(PLUS_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 还是在每天可看条数内
//	    				int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//	    				if (isViewSosoTodayLt(PLUS_VIP_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 也在收费历史数据条数内
//	    					canViewCount = PLUS_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    					oldCanViewCount = PLUS_VIP_VIEW_HISTORY_COUNT_PER_DAY - oldDataViewCount;
//	    					cantViewReson = VIEW_HISTORY_NEED_BEANS;
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	    				} else {// 会员每天可看的收费历史数据条数达上限
//	    					cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	    				}
//	    			} else {// 员超出了每天的总条数上限
//	    				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    			}
//	    		}
//	    	} else if ((isPlatinumVip || isHouseRepoVip) && (isLinkEdition || isSingleDeptEdition || isOldMarketEdition)) {// 白金会员或者房源库 并且 LINK版或者单店版	10157 搜搜老赢销版优化
//	    		int todayHasViewSosoNum = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//	    		if (1 == sosoDataType || 2 == sosoDataType) {// 半年内数据
//	    			if (isViewSosoTodayLt(OTHER_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 在每天免费条数内
//	    				canViewCount = OTHER_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    				cantViewReson = VIEW_FREE_CAN_VIEW;
//	    				if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//							cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//						}
//	    			} else {// 白金、房源库会员超出了每天的总条数上限
//	    				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    			}
//	    		} else {// 半年外的数据 sosoDataType == 3
//	    			int deptsToyearHasViewSosoNum = getDeptsHasViewSosoNum(adminFunDepts);
//	    			if (isViewSosoTodayLt(DEPT_VIEW_COUNT_PER_YEAR, deptsToyearHasViewSosoNum)) {// 门店的10000条限制内
//	    				if (isViewSosoTodayLt(OTHER_VIP_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 在白金、房源库会员的每天总量内
//	    					int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//	    					if (isViewSosoTodayLt(OTHER_VIP_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 也在历史数据条数内
//	    						canViewCount = OTHER_VIP_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    						oldCanViewCount = OTHER_VIP_VIEW_HISTORY_COUNT_PER_DAY - oldDataViewCount;
//	        					if (isViewSosoTodayLt(OTHER_VIP_FREE_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 前15条历史数据免费
//	        						cantViewReson = VIEW_FREE_CAN_VIEW;
//	        					} else {// 后15条历史数据收费
//	        						cantViewReson = VIEW_HISTORY_NEED_BEANS;
//	        					}
//	        					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	        						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	        					}
//	        				} else {// 白金、房源库会员历史数据达上限
//	        					cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	        				}
//	    				} else {// 白金、房源库会员的每天总量上限
//	    					cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    				}
//	    			} else {// 白金、房源库会员达门店的10000条/年/店限制
//	    				cantViewReson = VIEW_DEPT_OVER_10000;
//	    			}
//	    		}
//	    	} else if (isUserRight) {// 剩下的只是实名了的用户，还是判断下实名
//	    		int todayHasViewSosoNum = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//	    		if (isPersonalVersion) {// 精英版
//	    			if (1 == sosoDataType) {// 查看季度内数据
//	    				if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名用户在每天总条数内
//	    					canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    					cantViewReson = VIEW_FREE_CAN_VIEW;
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	        			} else {// 实名用户达每天总条数上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	        			}
//	    			} else if (2 == sosoDataType) {
//	    				if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名用户在每天总条数内
//	    					int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 2);
//	    					if (isViewSosoTodayLt(RIGHT_PERSONAL_VIEW_COUNT_PER_DAY, oldDataViewCount)) {// 还是在收费的条数内 30个，5豆/个
//	    						canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//		    					oldCanViewCount = RIGHT_PERSONAL_VIEW_COUNT_PER_DAY - oldDataViewCount;
//		    					cantViewReson = VIEW_HISTORY_NEED_BEANS;
//		    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//		    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//		    					}
//	    					} else {// 季度外半年内条数达到上限
//	    						cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	    					}
//	    				} else {// 实名用户达每天总条数上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    				}
//	    			} else {// 半年外不可看
//    					cantViewReson = VIEW_HISTORY_RIGHT_CANT_VIEW_UPGRADE_PLUS;
//	    			}
//	    		} else if (isMarketEdition || isPropertyEdition) {// 赢销版 || 物业版
//	    			if (1 == sosoDataType) {// 查看季度内数据
//	    				if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名用户在每天总条数内
//	    					canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	    					cantViewReson = VIEW_FREE_CAN_VIEW;
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	        			} else {// 实名用户达每天总条数上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	        			}
//	    			} else {// 季度外不可看根据版本提示不同的信息
//	    				if (isPropertyEdition) {// 物业版
//	    					cantViewReson = VIEW_HISTORY_RIGHT_CANT_VIEW_NEED_PRESTORE_BEANS;
//	    				} else if (isMarketEdition) {// 赢销版
//	    					cantViewReson = VIEW_HISTORY_RIGHT_CANT_VIEW_UPGRADE_LINK;
//	    				}
//	    			}
//	    		} else if (isSingleDeptEdition || isLinkEdition || isOldMarketEdition) {// 单店版 || LINK版	10157 搜搜老赢销版优化
//	    			/*if (1 == sosoDataType) {// 一季内数据
//	        			if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名并且是单店版或者LINK版每天可看半年内的总条数
//	        				canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	        				cantViewReson = VIEW_FREE_CAN_VIEW;
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	        			} else {// 实名并且是单店版或者LINK版每天可看总条数达上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	        			}
//	        		} else if (2 == sosoDataType) {// 一季外半年内
//	        			if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名并且是单店版或者LINK版每天可看总条数内
//	    					int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 2);
//	    					if (isViewSosoTodayLt(RIGHT_LINK_VIEW_COUNT_PER_DAY, oldDataViewCount)) {// 还是在收费的条数内 30个，5豆/个
//	    						canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//		    					oldCanViewCount = RIGHT_LINK_VIEW_COUNT_PER_DAY - oldDataViewCount;
//		    					cantViewReson = VIEW_HISTORY_NEED_BEANS;
//		    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//		    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//		    					}
//	    					} else {// 季度外半年内条数达到上限
//	    						cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	    					}
//	    				} else {// 实名用户达每天总条数上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	    				}
//	        		}*/
//	    			if (1 == sosoDataType || 2 == sosoDataType) {// 半年内数据
//	        			if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名并且是单店版或者LINK版每天可看半年内的总条数
//	        				canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	        				cantViewReson = VIEW_FREE_CAN_VIEW;
//	    					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	    						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	    					}
//	        			} else {// 实名并且是单店版或者LINK版每天可看总条数达上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	        			}
//	        		} else {// 半年外的数据
//	        			if (isViewSosoTodayLt(RIGHT_VIEW_COUNT_PER_DAY, todayHasViewSosoNum)) {// 实名并且是单店版或者LINK版每天可看总条数内
//	        				int oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//	        				if (isViewSosoTodayLt(RIGHT_VIEW_HISTORY_COUNT_PER_DAY, oldDataViewCount)) {// 实名并且是单店版或者LINK版历史收费条数内
//	        					canViewCount = RIGHT_VIEW_COUNT_PER_DAY - todayHasViewSosoNum;
//	        					oldCanViewCount = RIGHT_VIEW_HISTORY_COUNT_PER_DAY - oldDataViewCount;
//	        					cantViewReson = VIEW_HISTORY_NEED_BEANS;
//	        					if (1 == phoneBound && 0 != applogined) {// 2=引导下载APP，3=7天没有登录过APP
//	        						cantViewReson = (applogined == 1) ? VIEW_NEED_DOWNLOAD_APP_CANT_VIEW : VIEW_NEED_LOGIN_APP_CANT_VIEW;
//	        					}
//	        				} else {// 实名并且是单店版或者LINK版历史收费条数上限
//	        					cantViewReson = VIEW_OVER_HISTORY_COUNT_CANT_VIEW;
//	        				}
//	        			} else {// 实名并且是单店版或者LINK版每天可看总条数达上限
//	        				cantViewReson = VIEW_OVER_ALL_COUNT_CANT_VIEW;
//	        			}
//	        		}
//	    		}
//	    	}
//		} else {
//			cantViewReson = VIEW_NEED_USER_RIGHT;
//		}
		oldCanViewCount = (oldCanViewCount < 0) ? 0 : oldCanViewCount;
		Map<String, String> resultMap = new HashMap<String, String>();
		// 不能查看原因
		resultMap.put("cantViewReson", String.valueOf(cantViewReson));
		// 剩余可查看条数，有可能有条数，但因为没登录掌通或其他原因也不能查看
		resultMap.put("canViewCount", String.valueOf(canViewCount));
		// 历史数据剩余已查看条数
		resultMap.put("oldCanViewCount", String.valueOf(oldCanViewCount));
		return resultMap;
	}

	/**
	 * 获取门店版搜搜查看条数
	 * @author 张宏利
	 * @since 2018年3月15日
	 * @return
	 */
	private Map<String, String> getDeptViewCount(int sosoDataType, boolean userRight, Integer archiveId,
												 Integer applogined, String superUser, String deptLevel, String custLevel, Integer adminDeptId,
												 Integer phoneBound, Integer compType) {
		String todayStartTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		int canViewCount = 0, oldDataViewCount = 0;
		boolean isMarketEdition = (compType != null && compType == 4);
		boolean isPropertyEdition = (compType != null && compType == 5);
		// 不能查看原因：1=今日查看条数达到上限，2=引导下载APP，3=7天没有登录过APP，4=历史数据实名认证后查看更多
		// 5=非O2O会员只能查看一季度内的，6=超级房源库才能查看历史数据，7=今日历史数据查看条数达到上限
		// 8=门店总查看条数达到上限，9=续费充值VIP查看更多，10=续费O2O查看更多，11=VIP或O2O但未实名认证
		// 12=未实名认证终身50条，实名认证后查看更多，13=新营销版季度内数据达到上限，14=新营销版查看季度外数据
		// 16=提示需要消耗5好房豆才能查看
		int cantViewReson = 0;

		if (sosoDataType == 1) {
			// 实名后查看50条
            superUser = "1";
			if (userRight) {
				int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
				if (countView >= 2) {
					if(superUser.equals("1")) {
						if(countView >= 50) {
							cantViewReson = 1;// 今日查看条数达到上限
						} else {
							canViewCount = 50 - countView;
							if (phoneBound == 1 && applogined != 0) {
								cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
							}
						}
					} else {
						cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 10;// 续费O2O查看更多
					}
				} else {
					if(superUser.equals("1")) {
						canViewCount = 50 - countView;
					} else {
						canViewCount = 2 - countView;
					}
					if (phoneBound == 1 && applogined != 0) {
						cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
					}
				}
			} else {
                cantViewReson = 4;// 4=实名认证后可查看更多
//				int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, null, null);
//				if (countView >= 20) {
//					cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 12;// 未实名认证终身20条，实名认证后查看更多
//				} else {
//					countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//					if (countView >= 2) {
//						if (superUser.equals("1")) {
//							cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 11;// VIP或O2O但未实名认证
//						} else {
//							cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 10;// 续费O2O查看更多
//						}
//					} else {
//						if(superUser.equals("1")) {
//							canViewCount = 20 - countView;
//						} else {
//							canViewCount = 2 - countView;
//						}
//					}
//				}
			}
		} else if (sosoDataType == 2) {
//			if (superUser.equals("1")) {
//				if (userRight) {
//					int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//					if (countView >= 50) {
//						cantViewReson = 1;// 今日查看条数达到上限
//					} else {
//						canViewCount = 50 - countView;
//						if (phoneBound == 1 && applogined != 0) {
//							cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
//						}
//					}
//				} else {
//					cantViewReson = 4;// 实名认证后可查看更多
//				}
//			} else {
//				cantViewReson = (isMarketEdition || isPropertyEdition)? 14 : 5;// 14=新营销版查看季度外数据，5=非O2O会员只能查看一季度内的
//			}
			if (userRight) {
				if (superUser.equals("1")) {
					int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
					if (countView >= 50) {
						cantViewReson = 1;// 今日查看条数达到上限
					} else {
						canViewCount = 50 - countView;
						if (phoneBound == 1 && applogined != 0) {
							cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
						}
					}
				} else {
//					cantViewReson = (isMarketEdition || isPropertyEdition)? 14 : 5;// 14=新营销版查看季度外数据，5=非O2O会员只能查看一季度内的
                    int todayCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
                    if(todayCount >= 50) {
                        cantViewReson = 1;// 今日查看条数达到上限
                    }else {
                        if(isMarketEdition || isPropertyEdition) {
                            int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
                            if (countView >= 15) {
                                cantViewReson = 1;// 今日查看条数达到上限
                            } else {
                                canViewCount = 15 - countView;
                                cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
                            }
                        }else {
                            cantViewReson =  5;// 14=新营销版查看季度外数据，5=非O2O会员只能查看一季度内的
                        }
                    }

				}

			}  else {
				cantViewReson = 4;// 实名认证后可查看更多
			}
		} else if (sosoDataType == 3) {
//			if (superUser.equals("1")) {
//				if (userRight) {
//					// 终身会员判断
//					AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
//					int isFreeUser = Optional.ofNullable(funArchive.getIsFreeUser()).orElse((byte)0).intValue();
//					// 终身会员或白金会员或超级房源库
//					if (isFreeUser == 1 || "2".equals(deptLevel) || "2".equals(custLevel)) {
//						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//						if (countView >= 50) {
//							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//						} else {
//							canViewCount = 50 - countView;
//							oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//							if (oldDataViewCount >= 15) {
//								cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//							} else {
//								Calendar calendar = Calendar.getInstance();
//								calendar.add(Calendar.YEAR, -1);
//								String oneYear = DateTimeHelper.formatDatetoString(calendar.getTime());
//								countView = searchSosoViewCountMapper.getViewCount(null, adminDeptId, oneYear, (byte) 1);
//								if (countView > 10000) {
//									cantViewReson = 8;// 门店总查看条数达到上限
//								} else {
//									if (phoneBound == 1 && applogined != 0) {
//										cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
//									}
//								}
//							}
//						}
//					} else {
//						cantViewReson = 16;// 4=新营销版查看季度外数据，16=提示需要消耗5好房豆才能查看
//					}
//				} else {
//					cantViewReson = 4;// 实名认证后可查看更多
//				}
//			} else {
//				cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 5;// 4=新营销版查看季度外数据，5=非O2O用户只能查看一季度内的
//			}

			if(userRight) {

				if (superUser.equals("1")) {
					// 终身会员判断
					AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
					int isFreeUser = Optional.ofNullable(funArchive.getIsFreeUser()).orElse((byte)0).intValue();
					// 终身会员或白金会员或超级房源库
					if (isFreeUser == 1 || "2".equals(deptLevel) || "2".equals(custLevel)) {
						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
						if (countView >= 50) {
							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
						} else {
							canViewCount = 50 - countView;
							oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
							if (oldDataViewCount >= 15) {
								cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
							} else {
								Calendar calendar = Calendar.getInstance();
								calendar.add(Calendar.YEAR, -1);
								String oneYear = DateTimeHelper.formatDatetoString(calendar.getTime());
								countView = searchSosoViewCountMapper.getViewCount(null, adminDeptId, oneYear, (byte) 1);
								if (countView > 10000) {
									cantViewReson = 8;// 门店总查看条数达到上限
								} else {
									if (phoneBound == 1 && applogined != 0) {
										cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
									}
								}
							}
						}
					} else {
						cantViewReson = 16;// 4=新营销版查看季度外数据，16=提示需要消耗5好房豆才能查看
					}
				} else {
                    int todayCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
                    if(todayCount >= 50) {
                        cantViewReson = 1;// 今日查看条数达到上限
                    }else {
                        // cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 5;// 4=新营销版查看季度外数据，5=非O2O用户只能查看一季度内的
                        // 只有物业版和新营销版
                        if(isMarketEdition || isPropertyEdition) {
                            int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
                            if (countView >= 15) {
                                cantViewReson = 1;// 今日查看条数达到上限
                            } else {
                                canViewCount = 15 - countView;
                                cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
                            }
                        }else {
                            cantViewReson = 5;// 4=新营销版查看季度外数据，5=非O2O用户只能查看一季度内的
                        }
                    }

				}
			}else {
				cantViewReson = 4;// 实名认证后可查看更多
			}



//			if (superUser.equals("1")) {
//				if (userRight) {
//					// 终身会员判断
//					AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
//					int isFreeUser = Optional.ofNullable(funArchive.getIsFreeUser()).orElse((byte)0).intValue();
//					// 终身会员或白金会员或超级房源库
//					if (isFreeUser == 1 || "2".equals(deptLevel) || "2".equals(custLevel)) {
//						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//						if (countView >= 50) {
//							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//						} else {
//							canViewCount = 50 - countView;
//							oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//							if (oldDataViewCount >= 15) {
//								cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//							} else {
//								Calendar calendar = Calendar.getInstance();
//								calendar.add(Calendar.YEAR, -1);
//								String oneYear = DateTimeHelper.formatDatetoString(calendar.getTime());
//								countView = searchSosoViewCountMapper.getViewCount(null, adminDeptId, oneYear, (byte) 1);
//								if (countView > 10000) {
//									cantViewReson = 8;// 门店总查看条数达到上限
//								} else {
//									if (phoneBound == 1 && applogined != 0) {
//										cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
//									}
//								}
//							}
//						}
//					} else {
//						cantViewReson = 16;// 4=新营销版查看季度外数据，16=提示需要消耗5好房豆才能查看
//					}
//				} else {
//					cantViewReson = 4;// 实名认证后可查看更多
//				}
//			} else {
//				cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 5;// 4=新营销版查看季度外数据，5=非O2O用户只能查看一季度内的
//			}

		}
		int oldCanViewCount = 15 - oldDataViewCount;
		oldCanViewCount = (oldCanViewCount < 0) ? 0 :oldCanViewCount;

		Map<String, String> resultMap = new HashMap<String, String>();
		// 不能查看原因
		resultMap.put("cantViewReson", String.valueOf(cantViewReson));
		// 剩余可查看条数，有可能有条数，但因为没登录掌通或其他原因也不能查看
		resultMap.put("canViewCount", String.valueOf(canViewCount));
		// 历史数据剩余已查看条数
		resultMap.put("oldCanViewCount", String.valueOf(oldCanViewCount));
		return resultMap;
	}

	/**
	 * 获取精英版版搜搜查看条数
	 * @author 张宏利
	 * @param applogined 0=正常，1=引导下载，2=7天没有登录过APP
	 * @since 2018年3月15日
	 * @return
	 */
	private Map<String, String> getPerViewCount(int sosoDataType, boolean userRight, Integer archiveId,
												Integer applogined, String superUser, Integer phoneBound, Integer compType) {
		String todayStartTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		int canViewCount = 0, oldDataViewCount = 0;
		boolean isMarketEdition = (compType != null && compType == 4);
		boolean isPropertyEdition = (compType != null && compType == 5);
		// 不能查看原因：1=今日查看条数达到上限，2=引导下载APP，3=7天没有登录过APP，4=历史数据实名认证后查看更多
		// 5=非O2O会员只能查看一季度内的，6=超级房源库才能查看历史数据，7=今日历史数据查看条数达到上限
		// 8=门店总查看条数达到上限，9=续费充值VIP查看更多，10=续费O2O查看更多，11=VIP或O2O但未实名认证
		// 12=未实名认证终身50条，实名认证后查看更多，13=新营销版季度内数据达到上限，14=新营销版查看季度外数据
		// 16=提示需要消耗5好房豆才能查看
		int cantViewReson = 0;

		if (sosoDataType == 1) {
			superUser = "1";
			if (userRight) {
				int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
				if (countView >= 2) {
					if (superUser.equals("1")) {
						if(countView >= 50) {
							cantViewReson = 1;// 今日查看条数达到上限
						} else {
							canViewCount = 50 - countView;
							if (phoneBound == 1 && applogined != 0) {
								cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
							}
						}
					} else {
						cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 9;// 13=新营销版季度内数据达到上限，9=续费充值VIP查看更多
					}
				} else {
					if (superUser.equals("1")) {
						canViewCount = 50 - countView;
					} else {
						canViewCount = 2 - countView;
					}
					if (phoneBound == 1 && applogined != 0) {
						cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
					}
				}
			} else {
                cantViewReson = 4;// 4=实名认证后可查看更多
//				int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, null, null);
//				if (countView >= 20) {
//					cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 12;// 13=新营销版季度内数据达到上限，12=未实名认证终身20条，实名认证后查看更多
//				} else {
//					countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//					if (countView >= 2) {
//						if (superUser.equals("1")) {
//							cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 11;// 13=新营销版季度内数据达到上限，11=VIP或O2O但未实名认证
//						} else {
//							cantViewReson = (isMarketEdition || isPropertyEdition) ? 13 : 9;// 13=新营销版季度内数据达到上限，9=续费充值VIP查看更多
//						}
//					} else {
//						if (superUser.equals("1")) {
//							canViewCount = 20 - countView;
//						} else {
//							canViewCount = 2 - countView;
//						}
//					}
//				}
			}
		} else if (sosoDataType == 2) {

			if(userRight) {
				if (superUser.equals("1")) {
					int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
					if (countView >= 50) {
						cantViewReson = 1;// 1=今日查看条数达到上限
					} else {
						canViewCount = 50 - countView;
						if (phoneBound == 1 && applogined != 0) {
							cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
						}
					}
				}else {
                    int todayCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
                    if(todayCount >= 50) {
                        cantViewReson = 1;// 今日查看条数达到上限
                    }else {
						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
						if (countView >= 15) {
							cantViewReson = 1;// 今日查看条数达到上限
						} else {
							canViewCount = 15 - countView;
							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
						}
                    }

				}

			} else {
				cantViewReson = 4;// 4=实名认证后可查看更多
			}



//			if (superUser.equals("1")) {
//				if (userRight) {
//					int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//					if (countView >= 50) {
//						cantViewReson = 1;// 1=今日查看条数达到上限
//					} else {
//						canViewCount = 50 - countView;
//						if (phoneBound == 1 && applogined != 0) {
//							cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
//						}
//					}
//				} else {
//					cantViewReson = 4;// 4=实名认证后可查看更多
//				}
//			} else {
//				cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 5;// 14=新营销版查看季度外数据，5=非O2O会员只能查看一季度内的
//			}
		} else if (sosoDataType == 3) {
			if(userRight) {
				if (superUser.equals("1")) {
					// 终身会员判断
					AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
					int isFreeUser = Optional.ofNullable(funArchive.getIsFreeUser()).orElse((byte)0).intValue();
					if (isFreeUser == 1) {
						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
						if (countView >= 50) {
							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
						} else {
							canViewCount = 50 - countView;
							oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
							if (oldDataViewCount >= 15) {
								cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
							} else {
								if (phoneBound == 1 && applogined != 0) {
									cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
								}
							}
						}
					} else {
						cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 16;// 14=新营销版查看季度外数据，16=提示需要消耗5好房豆才能查看
					}
				} else {
                    int todayCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
                    if(todayCount >= 50) {
                        cantViewReson = 1;// 今日查看条数达到上限
                    }else {
						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
						if (countView >= 15) {
							cantViewReson = 1;// 今日查看条数达到上限
						} else {
							canViewCount = 15 - countView;
							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
						}

                    }

				}
			}else {
				cantViewReson = 4;// 实名认证后可查看更多
			}

//			if (superUser.equals("1")) {
//				if (userRight) {
//					// 终身会员判断
//					AdminFunArchive funArchive = adminFunArchiveMapper.getArchiveById(archiveId);
//					int isFreeUser = Optional.ofNullable(funArchive.getIsFreeUser()).orElse((byte)0).intValue();
//					if (isFreeUser == 1) {
//						int countView = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, null);
//						if (countView >= 50) {
//							cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//						} else {
//							canViewCount = 50 - countView;
//							oldDataViewCount = searchSosoViewCountMapper.getViewCount(archiveId, null, todayStartTime, (byte) 1);
//							if (oldDataViewCount >= 15) {
//								cantViewReson = 16;// 16=提示需要消耗5好房豆才能查看
//							} else {
//								if (phoneBound == 1 && applogined != 0) {
//									cantViewReson = (applogined == 1) ? 2 : 3;// 2=引导下载APP，3=7天没有登录过APP
//								}
//							}
//						}
//					} else {
//						cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 16;// 14=新营销版查看季度外数据，16=提示需要消耗5好房豆才能查看
//					}
//				} else {
//					cantViewReson = 4;// 实名认证后可查看更多
//				}
//			} else {
//				cantViewReson = (isMarketEdition || isPropertyEdition) ? 14 : 5;// 14=新营销版查看季度外数据，5=非O2O用户只能查看一季度内的
//			}
		}
		int oldCanViewCount = 15 - oldDataViewCount;
		oldCanViewCount = (oldCanViewCount < 0) ? 0 :oldCanViewCount;

		Map<String, String> resultMap = new HashMap<String, String>();
		// 不能查看原因
		resultMap.put("cantViewReson", String.valueOf(cantViewReson));
		// 剩余可查看条数，有可能有条数，但因为没登录掌通或其他原因也不能查看
		resultMap.put("canViewCount", String.valueOf(canViewCount));
		// 历史数据剩余已查看条数
		resultMap.put("oldCanViewCount", String.valueOf(oldCanViewCount));
		return resultMap;
	}

	/**
	 * 获取手机登录时间
	 * @author 张宏利
	 * @since 2018年3月15日
	 * @return 0=正常，1=引导下载，2=7天没有登录过APP
	 */
	public Integer getAppLoginEnd() {
		AdminAppLogin adminAppLogin = adminAppLoginMapper.getAppLastLoginTimeDiff(getOperator().getArchiveId());
		int reHours = 0;
		if(adminAppLogin != null && adminAppLogin.getLoginCount() != null){
			reHours = adminAppLogin.getLoginCount();
		}else {
			return 1;//提示用户下载
		}
		if (reHours >= 7 * 24) {
			return 2;// 代表提示用户7天没有登录过手机ERP了  引导用户登录
		}
		return 0;//不提示
	}

	/**
	 * 组装处理搜索信息
	 * @author 张宏利
	 * @since 2017年10月26日
	 */
	private void generatorSearchInfo(SoSoSaleListParam param) {
		String[] timeArr = DateConvert.getConditionDateForSoso(param.getTime());// 转换成时间段
		param.setTime1(timeArr[0]);
		param.setTime2(timeArr[1]);
		if(StringUtils.isNotBlank(param.getKeywords())){
			param.setKeywords("%"+param.getKeywords()+"%");
		}
		if(StringUtils.isNotBlank(param.getRegion())){
			param.setRegions(param.getRegion().split(" "));
		}
		if(StringUtils.isNotBlank(param.getSection())){
			param.setSectionArr(param.getSection().split(" "));
		}
	}

	/**
	 * 生成干道首字母使用，之前用过，留在这里
	 * @author 张宏利
	 * @since 2017年6月9日
	 */
	@SuppressWarnings("unused")
	private void dealRoadsNameCode(){
		ErpFunRoadsInfoExample example = new ErpFunRoadsInfoExample();
		example.setShardCityId(1);
		List<ErpFunRoadsInfo> roadsInfoList = erpFunRoadsInfoMapper.selectByExample(example);
		roadsInfoList.stream().forEach(road -> {
			ErpFunRoadsInfo record = new ErpFunRoadsInfo();
			record.setShardCityId(1);
			record.setId(road.getId());
			record.setRoadsCode(Pinyin4jUtil.converterToFirstSpell(road.getRoadsName()));
			erpFunRoadsInfoMapper.updateByPrimaryKeySelective(record);
		});
	}

	/**
	 * 获取搜搜出售重复房源列表
	 * @author 熊刚
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getSaleInRepeatById")
	public ResponseJson getSaleInRepeatById(@Valid @RequestBody SoSoSaleDataInfoParam param) {
		if(param.getRepeatId() == null || param.getRepeatId() <= 0) {
			return ErpResponseJson.ok();
		}
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		List<SearchSaleInDto> pageList = null;
		if("SALE_IN".equals(tables[0])) {
			pageList = searchSaleInMapper.getSaleInRepeatById(param);
		} else {
			pageList = search2SaleInMapper.getSaleInRepeatById(param);
		}
		return ErpResponseJson.ok(pageList);
	}

	/**
	 * 获取搜搜出租重复房源列表
	 * @author 熊刚
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getLeaseRepeatById")
	public ResponseJson getLeaseRepeatById(@Valid @RequestBody SoSoSaleDataInfoParam param) {
		if(param.getRepeatId() == null || param.getRepeatId() <= 0) {
			return ErpResponseJson.ok();
		}
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		String[] tables = CommonUtil.getLeaseTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		List<SearchLeaseInDto> pageList = null;
		if("LEASE_IN".equals(tables[0])) {
			pageList = searchLeaseInMapper.getLeaseRepeatById(param);
		} else {
			pageList = search2LeaseInMapper.getLeaseRepeatById(param);
		}
		return ErpResponseJson.ok(pageList);
	}

	/**
	 * 获取搜搜转铺重复房源列表
	 * @author 熊刚
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getShopRepeatById")
	public ResponseJson getShopRepeatById(@Valid @RequestBody SoSoSaleDataInfoParam param) {
		if(param.getRepeatId() == null || param.getRepeatId() <= 0) {
			return ErpResponseJson.ok();
		}
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		String[] tables = CommonUtil.getShopTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		List<SearchShopMainInDataInfoDto> pageList = null;
		if("SHOP_MAIN".equals(tables[0])) {
			pageList = searchShopMainMapper.getShopRepeatById(param);
		} else {
			pageList = search2ShopMainMapper.getShopRepeatById(param);
		}
		return ErpResponseJson.ok(pageList);
	}

	/**
	 * 获取搜搜合租重复房源列表
	 * @author 熊刚
	 * @since 2016年8月19日
	 * @return
	 */
	@RequestMapping(value="/getHezuRepeatById")
	public ResponseJson getHezuRepeatById(@Valid @RequestBody SoSoSaleDataInfoParam param) {
		if(param.getRepeatId() == null || param.getRepeatId() <= 0) {
			return ErpResponseJson.ok();
		}
		param.setProvinceId(getOperator().getProvinceId());
		param.setCityId(getOperator().getCityId());
		String[] tables = CommonUtil.getHezuTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		List<SearchHeZuDataInfoDto> pageList = null;
		if("HEZU".equals(tables[0])) {
			pageList = searchHezuMapper.getHezuRepeatById(param);
		} else {
			pageList = search2HezuMapper.getHezuRepeatById(param);
		}
		return ErpResponseJson.ok(pageList);
	}

	/**
	 * title ：根据url查询列表
	 * athor：lcb
	 * date  : 2017/10/30
	 */
	@RequestMapping(value="/getSosoCountByUrl")
	public ResponseJson getSosoListByUrl(@Valid @RequestBody SoSoSaleDataInfoParam param) {
		Operator operator = getOperator();
		Integer count = 0;
		Integer countSale = searchSaleInMapper.countByUrl(operator.getProvinceId(), operator.getCityId(), param.getDataUrl());
		count+= countSale;
		if (count == 0) {
			Integer countLease = searchLeaseInMapper.countByUrl(operator.getProvinceId(), operator.getCityId(), param.getDataUrl());
			count += countLease;
		}
		return ErpResponseJson.ok(count);
	}

	/**
	 * 获取出售图片地址
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/22
	 */
	private String getSalePhone(String mobilePhone, String telePhone, String telSource) {
		mobilePhone = StringUtil.isEmpty(mobilePhone) ? ""
				: HTMLHelper.toHTMLString(mobilePhone, HTMLHelper.ES_DEF$INPUT).replaceAll("\r", "&EACE")
				.replaceAll("\n", "&EACE");
		telePhone = StringUtil.isEmpty(telePhone) ? ""
				: HTMLHelper.toHTMLString(telePhone, HTMLHelper.ES_DEF$INPUT).replaceAll("\r", "&EACE")
				.replaceAll("\n", "&EACE");
		if (telSource == null) {
			telSource = "";
		}
		String cellPhone = (mobilePhone + " " + telePhone).trim();
		String hasPicPhone = StringUtil.isEmpty(telSource) ? "0" : "1";
		telSource = StringHelper.replace(telSource, "\\", "/");
		telSource = CommonUtil.getSoSoPhonePicUrl(telSource);
		String phone = hasPicPhone.equals("0") ? cellPhone : telSource;
		return phone;
	}

	/**
	 * 获取出租图片地址
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/22
	 */
	private Map<Integer,Map<String,String>> getLeasePhoneAddr(List<SearchLeaseInDto> searchLeaseInDtoList) {
		Map<Integer,Map<String,String>> phoneAddrMap=new HashMap<>();
		for (SearchLeaseInDto searchLeaseInDto:searchLeaseInDtoList){
			Integer id = searchLeaseInDto.getRepeatId();
			if (id == null || id <= 10) {
				id = searchLeaseInDto.getId();
			}
			String mobilePhone=searchLeaseInDto.getMobilePhone();
			String telePhone=searchLeaseInDto.getTelePhone();
			String telSource=searchLeaseInDto.getTelSource();
			mobilePhone = StringUtil.isEmpty(mobilePhone) ? "" : HTMLHelper
					.toHTMLString(mobilePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");
			telePhone = StringUtil.isEmpty(telePhone) ? "" : HTMLHelper
					.toHTMLString(telePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");

			if(telSource == null) {
				telSource = "";
			}
			String cellPhone = (mobilePhone + " " + telePhone).trim();
			String hasPicPhone = StringUtil.isEmpty(telSource) ? "0" : "1";
			telSource = StringHelper.replace(telSource, "\\", "/");
			telSource = CommonUtil.getSoSoPhonePicUrl(telSource);
			String phone=hasPicPhone.equals("0") ? cellPhone : telSource;
			Map<String, String> phoneMap=new HashMap<>();
			phoneMap.put("phone",phone);
			phoneMap.put("isPic",hasPicPhone);
			phoneAddrMap.put(id,phoneMap);
		}
		return phoneAddrMap;
	}

	/**
	 * 获取转铺图片地址
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/22
	 */
	private Map<Integer,Map<String,String>> getShopPhoneAddr(List<SearchShopMainInDataInfoDto> searchShopMainInDataInfoDtos) {
		Map<Integer,Map<String,String>> phoneAddrMap=new HashMap<>();
		for (SearchShopMainInDataInfoDto searchShopMainInDataInfoDto:searchShopMainInDataInfoDtos){
			Integer id = searchShopMainInDataInfoDto.getRepeatId();
			if (id == null || id <= 10) {
				id = searchShopMainInDataInfoDto.getId();
			}
			String mobilePhone=searchShopMainInDataInfoDto.getMobilePhone();
			String telePhone=searchShopMainInDataInfoDto.getTelePhone();
			String telSource=searchShopMainInDataInfoDto.getTelSource();
			mobilePhone = StringUtil.isEmpty(mobilePhone) ? "" : HTMLHelper
					.toHTMLString(mobilePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");
			telePhone = StringUtil.isEmpty(telePhone) ? "" : HTMLHelper
					.toHTMLString(telePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");

			if(telSource == null) {
				telSource = "";
			}
			String cellPhone = (mobilePhone + " " + telePhone).trim();
			String hasPicPhone = StringUtil.isEmpty(telSource) ? "0" : "1";
			telSource = StringHelper.replace(telSource, "\\", "/");
			telSource = CommonUtil.getSoSoPhonePicUrl(telSource);
			String phone=hasPicPhone.equals("0") ? cellPhone : telSource;
			Map<String, String> phoneMap=new HashMap<>();
			phoneMap.put("phone",phone);
			phoneMap.put("isPic",hasPicPhone);
			phoneAddrMap.put(id,phoneMap);
		}
		return phoneAddrMap;
	}

	/**
	 * 获取图片地址
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/22
	 */
	private Map<Integer,Map<String,String>> getHuzuPhoneAddr(List<SearchHeZuDataInfoDto> searchHeZuDataInfoDtoList) {
		Map<Integer,Map<String,String>> phoneAddrMap=new HashMap<>();
		for (SearchHeZuDataInfoDto searchHeZuDataInfoDto:searchHeZuDataInfoDtoList){
			Integer id = searchHeZuDataInfoDto.getRepeatId();
			if (id == null || id <= 10) {
				id = searchHeZuDataInfoDto.getId();
			}
			String mobilePhone=searchHeZuDataInfoDto.getMobilePhone();
			String telePhone=searchHeZuDataInfoDto.getTelePhone();
			String telSource=searchHeZuDataInfoDto.getTelSource();
			mobilePhone = StringUtil.isEmpty(mobilePhone) ? "" : HTMLHelper
					.toHTMLString(mobilePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");
			telePhone = StringUtil.isEmpty(telePhone) ? "" : HTMLHelper
					.toHTMLString(telePhone, HTMLHelper.ES_DEF$INPUT)
					.replaceAll("\r", "&EACE").replaceAll("\n", "&EACE");

			if(telSource == null) {
				telSource = "";
			}
			String cellPhone = (mobilePhone + " " + telePhone).trim();
			String hasPicPhone = StringUtil.isEmpty(telSource) ? "0" : "1";
			telSource = StringHelper.replace(telSource, "\\", "/");
			telSource = CommonUtil.getSoSoPhonePicUrl(telSource);
			String phone=hasPicPhone.equals("0") ? cellPhone : telSource;
			Map<String, String> phoneMap=new HashMap<>();
			phoneMap.put("phone",phone);
			phoneMap.put("isPic",hasPicPhone);
			phoneAddrMap.put(id,phoneMap);
		}
		return phoneAddrMap;
	}
	
	/**
	 * 查询当前经纪人的admin库门店信息
	 * @param operator
	 * @param funArchive
	 * @return
	 */
	private AdminFunDepts getSosoMobilePhoneDept(Operator operator, AdminFunArchive funArchive) {
        if (!operator.isPersonalVersion()) {
            AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
            adminFunDeptsExample.createCriteria().andDeptNoEqualTo(operator.getDeptNo())
                    .andCompNoEqualTo(operator.getCompNo());
            List<AdminFunDepts> deptList = adminFunDeptsMapper.selectByExample(adminFunDeptsExample);
            if (deptList == null || deptList.isEmpty()) {
                throw new BusinessException("获取搜搜电话失败，账号所在的门店为空");
            } else {
                return deptList.get(0);
            }
        } else {
            return null;
        }
    }
	
	/**
     * 是否是预存会员用户（物业版||新赢销版）&& （adminFunDepts.otoEnd > now）
     * @param funDepts
     * @return
     */
    private boolean isPrestoreVip(Integer compType, AdminFunDepts funDepts) {
    	if (null != compType && null != funDepts) {
    		if (Const.DIC_COMP_TYPE_4.equals(compType) || Const.DIC_COMP_TYPE_5.equals(compType)) {
    			if (null != funDepts.getOtoEnd()) {
    				return funDepts.getOtoEnd().getTime() > System.currentTimeMillis();
    			}
    		}
		}
		return false;
    }
    
    /**
     * 是否是白金会员
     */
    private boolean isPlatinumVip(AdminFunDepts funDepts) {
        if (funDepts != null) {
            if (Byte.valueOf((byte) 2).equals(funDepts.getCustLevel())
                    && funDepts.getCustEndTime() != null) {
                return funDepts.getCustEndTime().getTime() > System.currentTimeMillis();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * 是否是房源库用户，判断条件和白金用户一样
     */
    private boolean isHouseRepoVip(AdminFunDepts funDepts) {
        return isPlatinumVip(funDepts);
    }
    
    /**
     * 是否是永久用户
     */
    private boolean is4everVip(AdminFunArchive funArchive) {
        return Byte.valueOf((byte) 1).equals(funArchive.getIsFreeUser());
    }
    
    /**
     * 已看条数是否小于限制可看条数
     * @param n	限制可看条数
     * @param todayHasViewSosoNum 已看条数
     * @return	已看小于可看为true
     */
    private boolean isViewSosoTodayLt(int n, int todayHasViewSosoNum) {
        return todayHasViewSosoNum < n;
    }
	
    /**
     * 查询白金、房源库用户门店查看历史数据量（10000/店/年）
     * @param n
     * @param depts
     * @return
     */
    private int getDeptsHasViewSosoNum(AdminFunDepts depts) {
        if (depts != null) {
            Integer deptId = depts.getDeptId();
            Date formTime = depts.getFormTime();
            String startYear = null;
            String endYear = null;
            if (null != formTime) {
            	Calendar formTimeCalendar = Calendar.getInstance();
            	formTimeCalendar.setTime(formTime);
            	Calendar currentTimeCalendar = Calendar.getInstance();
            	formTimeCalendar.set(Calendar.YEAR, currentTimeCalendar.get(Calendar.YEAR));
            	if (formTimeCalendar.getTimeInMillis() > currentTimeCalendar.getTimeInMillis()) {
            		// 去年时间到今年
            		endYear = DateTimeHelper.formatDateTimetoString(formTimeCalendar.getTime(), "yyyy-MM-dd HH:mm:ss");
            		formTimeCalendar.add(Calendar.YEAR, -1);
            		startYear = DateTimeHelper.formatDateTimetoString(formTimeCalendar.getTime(), "yyyy-MM-dd HH:mm:ss");
            	} else {
            		// 今年时间到明年
            		startYear = DateTimeHelper.formatDateTimetoString(formTimeCalendar.getTime(), "yyyy-MM-dd HH:mm:ss");
            		formTimeCalendar.add(Calendar.YEAR, 1);
            		endYear = DateTimeHelper.formatDateTimetoString(formTimeCalendar.getTime(), "yyyy-MM-dd HH:mm:ss");
            	}
            } else {
            	String year = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy");
            	startYear = year + "-1-1 00:00:00";
            	endYear = year + "-12-31 23:59:59";
            }
            int deptsToyearHasViewSosoNum = searchSosoViewCountMapper.getDeptViewCount(deptId, startYear, endYear);
            return deptsToyearHasViewSosoNum;
        } else {
            return 0;
        }
    }
    

	public static void main(String[] args) {
//		ErpBuildingSetRoom room = new ErpBuildingSetRoom();
//		room.setId(1);
//		room.setCityId(1);
//		room.setCompId(12001);
//		room.setBuildId(100);
//		room.setSysRoomId(101);
//		room.setRoomId("101");
//		room.setHouseRoom((byte) 3);
//		room.setHouseHall((byte) 2);
//		room.setHouseWei((byte) 2);
//		room.setHouseYang((byte) 1);
//		room.setHouseDirect((byte) 1);
//		room.setHouseArea(BigDecimal.ZERO);
//		room.setHouseInnerarea(BigDecimal.ZERO);
//		room.setCreationTime(new Date());
//		room.setUpdateTime(new Date());
//		System.out.println(JSON.toJSONString(room));
	}
}



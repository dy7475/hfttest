package com.myfun.erpWeb.managecenter.sysmanager;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomerExample;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunBuyCustomerService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunRentCustomerService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.impl.ErpFunDeptsServiceImpl;
import com.myfun.utils.Assert;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

/**
 * @TODO 组织机构模块
 * @author lcb
 * @2016-10-18 下午6:00:17
 */
@RestController
@RequestMapping("/managerCenter/translate")
public class DataTranslateController extends BaseController{
	Logger logger = LoggerFactory.getLogger(ErpFunDeptsServiceImpl.class);
	@Autowired private ErpFunSaleService         erpFunSaleService;
	@Autowired private ErpFunLeaseService        erpFunLeaseService;
	@Autowired private ErpFunBuyCustomerService  erpFunBuyCustomerService;
	@Autowired private ErpFunRentCustomerService erpFunRentCustomerService;
	@Autowired private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	
	/**
	 * 数据移交操作
	 * @author 张宏利
	 * @since 2018年4月23日
	 * @param param
	 * @return
	 */
	@ApiOperation("数据移交操作")
	@ApiResponses({@ApiResponse(code = 200, message = "success")})
	@PostMapping("/dataTranslate")
	public ErpResponseJson dataTranslate(@RequestBody DataTranslateParam param) {
		Operator operator=getOperator();
		param.setCustom(operator.isCustom());
		param.setCurrentUserId(operator.getUserId());
		param.setCurrentUserNamme(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());
		param.setCurrentDeptName(operator.getDeptName());
		param.setDeptId(operator.getDeptId());
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
			ErpFunSale updateModel = getParamObj(ErpFunSale.class);
			this.dataTranslateSale(param, updateModel);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
			ErpFunLease updateModel = getParamObj(ErpFunLease.class);
			this.dataTranslateLease(param, updateModel);
		} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(param.getCaseType())) {
			ErpFunBuyCustomer updateModel = getParamObj(ErpFunBuyCustomer.class);
			this.dataTranslateBuyCust(param, updateModel);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(param.getCaseType())) {
			ErpFunRentCustomer updateModel = getParamObj(ErpFunRentCustomer.class);
			this.dataTranslateRentCust(param, updateModel);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 移交求租数据
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @param updateModel
	 */
	public void dataTranslateRentCust(DataTranslateParam param, ErpFunRentCustomer updateModel) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String caseIds = param.getCaseIds();
		String acceptUserId = param.getAcceptUserId();// 接收人
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		if (StringUtils.isBlank(caseIds) || caseIds.split(",").length <= 0) {
			throw new BusinessException("没有选中任何移交数据");
		}
		Date nowDate = new Date();
		updateModel.setHouseUseage(null);// 前端传了非法的HOUSE_USEAGE
		updateModel.setRedFlag(false);
		updateModel.setRentCustSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		updateModel.setRentCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		updateModel.setUpdateTime(nowDate);
		updateModel.setSyncTime(nowDate);
		updateModel.setTrackTime(nowDate);
		updateModel.setActionTime(nowDate);
		// 移交方和接收方同时为公盘或者抢盘不做 不能将数据移交给本人 判断
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			Assert.isTrueThrow(srcUserId.equals(acceptUserId), "不能将数据移交给本人！");
		}
		Integer caseType = Const.DIC_CASE_TYPE_RENT_CUST;
		String tmpUserId = null;
		Integer tmpPlateType = null;
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			tmpUserId = srcUserId;
		} else if ("public".equalsIgnoreCase(srcUserId)) {
			tmpPlateType = Const.DIC_PLATE_TYPE_PUBLIC;
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			tmpPlateType = Const.DIC_PLATE_TYPE_SHARE;
		}
		ErpFunUsers acceptUser = null;
		if ("public".equalsIgnoreCase(acceptUserId) || "share".equalsIgnoreCase(acceptUserId)) {// 移交到抢盘
			boolean haveDealData = true;
			if ("all".equalsIgnoreCase(caseIds)) {
				// 判断指定员工的所有信息中是否存在已成交或注销信息
				haveDealData = erpFunRentCustomerMapper.detectTransDataByDeptIdAndUserId(cityId, srcDeptId, tmpUserId, tmpPlateType) != null;
			} else {
				// 数据中是否存在已经成交或注销的信息
				haveDealData = erpFunRentCustomerMapper.detectTransData(cityId, compId, caseIds.split(",")) != null;
			}
			// 转移到抢盘时,须判断选中的信息中是否存在已成交信息
			Assert.isTrueThrow(haveDealData, "您选中的信息有成交或注销的信息，不能移交到" + ("public".equals(acceptUserId) ? "抢盘" : "公盘") + "，请选择经纪人再移交！");
			ErpFunDepts acceptDept = erpFunDeptsMapper.getByDeptId(param.getCityId(), acceptDeptId);
			updateModel.setUserId(null);
			updateModel.setArchiveId(null);
			updateModel.setGrId(Integer.valueOf(Constants_DIC.DIC_DEFAULT_GROUP_ID));
			updateModel.setDeptId(acceptDept.getDeptId());// 先用指定的部门的id
			updateModel.setRegId(acceptDept.getRegId());
			updateModel.setAreaId(acceptDept.getAreaId());
			/** 处理公盘或者抢盘 **/
			Integer plateType = "public".equalsIgnoreCase(acceptUserId) ? Const.DIC_PLATE_TYPE_PUBLIC : Const.DIC_PLATE_TYPE_SHARE;
			updateModel.setPlateType(plateType.byteValue());
			updateModel.setRentCustStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setPrivateTime(nowDate);
			} else {
				updateModel.setPublicTime(nowDate);
			}
			updateModel.setOrangeFlag(false);
			updateModel.setPublicCount(1);
			updateModel.setCreatorUid(null);
		} else {
			acceptUser = erpFunUsersMapper.getFunUserByUserId(cityId, StringUtil.parseInteger(acceptUserId));
			Assert.isTrueThrow(acceptUser.getUserWriteoff(), "接收人账号已被注销，请确认接收人是否正确！");
			updateModel.setUserId(acceptUser.getUserId());
			updateModel.setArchiveId(acceptUser.getArchiveId());
			updateModel.setGrId(acceptUser.getGrId());
			updateModel.setDeptId(acceptUser.getDeptId());
			updateModel.setRegId(acceptUser.getRegId());
			updateModel.setAreaId(acceptUser.getAreaId());
			// 系统运行模式是否为私有
			if (erpSysParaService.getSysRunModelIsPrivate(caseType, cityId, compId)) {
				updateModel.setPrivateTime(nowDate);
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
			} else {
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			}
		}
		if ("ALL".equals(caseIds)) {
			//reportFunSaleMinService.judgeOperatorTransferShop(cityId, compId, srcUserId, 3, Const.DIC_CASE_TYPE_RENT_CUST);
			int whileCount = 0;// 还是避免下死循环，一次最多一万条
			while (++whileCount < 10) {
				List<ErpFunRentCustomer> casePOList = erpFunRentCustomerMapper.getTopFunRentCustomer(cityId, compId, srcDeptId, tmpUserId, tmpPlateType, 1000);
				if (casePOList == null || casePOList.size() <= 0) {
					break;
				}
				List<Integer> caseIdList = casePOList.stream().collect(Collectors.mapping(ErpFunRentCustomer::getRentCustId, Collectors.toList()));
				List<String> caseNoList = casePOList.stream().collect(Collectors.mapping(ErpFunRentCustomer::getRentCustNo, Collectors.toList()));
				erpFunRentCustomerService.dataTranslate(updateModel, acceptUser, caseIdList, caseNoList.toArray(new String[] {}), param);
			}
		} else {
			List<Integer> caseIdList = StringUtil.toIntList(caseIds, ",");
			ErpFunRentCustomerExample funRentCustomerExample = new ErpFunRentCustomerExample();
			funRentCustomerExample.setShardCityId(param.getCityId());
			funRentCustomerExample.createCriteria().andCompIdEqualTo(compId).andRentCustIdIn(caseIdList);
			List<ErpFunRentCustomer> casePOList = erpFunRentCustomerMapper.selectByExample(funRentCustomerExample);
			List<String> caseNoList = casePOList.stream().collect(Collectors.mapping(ErpFunRentCustomer::getRentCustNo, Collectors.toList()));
			erpFunRentCustomerService.dataTranslate(updateModel, acceptUser, caseIdList, caseNoList.toArray(new String[] {}), param);
		}
	}
	
	/**
	 * 移交求购数据
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @param updateModel
	 */
	public void dataTranslateBuyCust(DataTranslateParam param,ErpFunBuyCustomer updateModel) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String caseIds = param.getCaseIds();
		String acceptUserId = param.getAcceptUserId();// 接收人
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		if (StringUtils.isBlank(caseIds) || caseIds.split(",").length <= 0) {
			throw new BusinessException("没有选中任何移交数据");
		}
		Date nowDate = new Date();
		updateModel.setHouseUseage(null);// 前端传了非法的HOUSE_USEAGE
		updateModel.setRedFlag(false);
		updateModel.setBuyCustSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		updateModel.setBuyCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		updateModel.setUpdateTime(nowDate);
		updateModel.setSyncTime(nowDate);
		updateModel.setTrackTime(DateTimeHelper.getTimeNow());
		updateModel.setActionTime(DateTimeHelper.getTimeNow());
		// 移交方和接收方同时为公盘或者抢盘不做 不能将数据移交给本人 判断
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			Assert.isTrueThrow(srcUserId.equals(acceptUserId), "不能将数据移交给本人！");
		}
		Integer caseType = Const.DIC_CASE_TYPE_BUY_CUST;
		ErpFunUsers acceptUser = null;
		String tmpUserId = null;
		Integer tmpPlateType = null;
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			tmpUserId = srcUserId;
		} else if ("public".equalsIgnoreCase(srcUserId)) {
			tmpPlateType = Const.DIC_PLATE_TYPE_PUBLIC;
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			tmpPlateType = Const.DIC_PLATE_TYPE_SHARE;
		}
		if ("public".equalsIgnoreCase(acceptUserId) || "share".equalsIgnoreCase(acceptUserId)) {// 移交到抢盘
			boolean haveDealData = true;
			if ("all".equalsIgnoreCase(caseIds)) {
				// 判断指定员工的所有信息中是否存在已成交或注销信息
				haveDealData = erpFunBuyCustomerMapper.detectTransDataByDeptIdAndUserId(cityId, srcDeptId, tmpUserId, tmpPlateType) != null;
			} else {
				// 数据中是否存在已经成交或注销的信息
				haveDealData = erpFunBuyCustomerMapper.detectTransData(cityId, compId, caseIds.split(",")) != null;
			}
			// 转移到抢盘时,须判断选中的信息中是否存在已成交信息
			String plateTypeStr = ("public".equalsIgnoreCase(acceptUserId) ? "抢盘" : "公盘");
			Assert.isTrueThrow(haveDealData, "您选中的信息有成交或注销的信息，不能移交到" + plateTypeStr + "，请选择经纪人再移交！");
			ErpFunDepts acceptDept = erpFunDeptsMapper.getByDeptId(cityId, acceptDeptId);
			updateModel.setUserId(null);
			updateModel.setArchiveId(null);
			updateModel.setGrId(Const.DIC_DEFAULT_GROUP_ID);
			updateModel.setDeptId(acceptDept.getDeptId());// 先用指定的部门的id
			updateModel.setRegId(acceptDept.getRegId());
			updateModel.setAreaId(acceptDept.getAreaId());
			// 处理公盘或者抢盘
			Integer plateType = "public".equalsIgnoreCase(acceptUserId) ? Const.DIC_PLATE_TYPE_PUBLIC : Const.DIC_PLATE_TYPE_SHARE;
			updateModel.setPlateType(plateType.byteValue());
			updateModel.setBuyCustStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setPrivateTime(DateTimeHelper.getTimeNow());
			} else {
				updateModel.setPublicTime(DateTimeHelper.getTimeNow());
			}
			updateModel.setOrangeFlag(false);
			updateModel.setPublicCount(1);
			updateModel.setCreatorUid(null);
			updateModel.setCooperateFlag(0);
		} else {
			acceptUser = erpFunUsersMapper.getFunUserByUserId(cityId, Integer.valueOf(acceptUserId));
			Assert.isTrueThrow(acceptUser.getUserWriteoff(), "接收人账号已被注销，请确认接收人是否正确！");
			updateModel.setUserId(acceptUser.getUserId());
			updateModel.setArchiveId(acceptUser.getArchiveId());
			updateModel.setGrId(acceptUser.getGrId());
			updateModel.setDeptId(acceptUser.getDeptId());
			updateModel.setRegId(acceptUser.getRegId());
			updateModel.setAreaId(acceptUser.getAreaId());
			if (erpSysParaService.getSysRunModelIsPrivate(caseType, cityId, compId)) {// 系统运行模式是否为私有
				updateModel.setPrivateTime(DateTimeHelper.getTimeNow());
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
			} else {
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			}
		}
		if ("all".equalsIgnoreCase(caseIds)) {
			//reportFunSaleMinService.judgeOperatorTransferShop(cityId, compId, srcUserId, 3, Const.DIC_CASE_TYPE_BUY_CUST);
			int whileCount = 0;// 还是避免下死循环，一次最多一万条
			while (++whileCount < 10) {
				List<ErpFunBuyCustomer> casePOList = erpFunBuyCustomerMapper.getTopFunBuyCustomer(cityId, compId,
						srcDeptId, tmpUserId, tmpPlateType, 1000);
				if (casePOList == null || casePOList.size() <= 0) {
					break;
				}
				List<Integer> caseIdList = casePOList.stream().collect(Collectors.mapping(ErpFunBuyCustomer::getBuyCustId, Collectors.toList()));
				List<String> caseNoList = casePOList.stream().collect(Collectors.mapping(ErpFunBuyCustomer::getBuyCustNo, Collectors.toList()));
				erpFunBuyCustomerService.dataTranslate(cityId, updateModel, acceptUser, caseIdList, caseNoList.toArray(new String[]{}), param);
			}
		} else {
			List<Integer> caseIdList = StringUtil.toIntList(caseIds, ",");
			ErpFunBuyCustomerExample funBuyCustomerExample = new ErpFunBuyCustomerExample();
			funBuyCustomerExample.setShardCityId(cityId);
			funBuyCustomerExample.createCriteria().andCompIdEqualTo(compId).andBuyCustIdIn(caseIdList);
			List<ErpFunBuyCustomer> casePOList = erpFunBuyCustomerMapper.selectByExample(funBuyCustomerExample);
			List<String> caseNoList = casePOList.stream().collect(Collectors.mapping(ErpFunBuyCustomer::getBuyCustNo, Collectors.toList()));
			erpFunBuyCustomerService.dataTranslate(cityId, updateModel, acceptUser, caseIdList,
					caseNoList.toArray(new String[] {}), param);
		}
	}
	
	/**
	 * 移交出租数据
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @param updateModel
	 */
	public void dataTranslateLease(DataTranslateParam param, ErpFunLease updateModel) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String caseIds = param.getCaseIds();
		String acceptUserId = param.getAcceptUserId();// 接收人
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		if (StringUtils.isBlank(caseIds) || caseIds.split(",").length <= 0) {
			throw new BusinessException("没有选中任何移交数据");
		}
		// 移交方和接收方同时为公盘或者抢盘不做 不能将数据移交给本人 判断
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			Assert.isTrueThrow(srcUserId.equals(acceptUserId), "不能将数据移交给本人！");
		}
		Date nowDate = new Date();
		updateModel.setRedFlag(false);// 前端传了非法的HOUSE_USEAGE
		updateModel.setLeaseSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		updateModel.setLeaseLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		updateModel.setUpdateTime(nowDate);
		updateModel.setSyncTime(nowDate);
		updateModel.setTrackTime(nowDate);
		updateModel.setActionTime(nowDate);
		updateModel.setTrackTime2(nowDate);
		updateModel.setSendtotencent(Const.DIC_QQ_PUBLISH_SYNC_FLAG_0);// 移交的数据要从腾讯下架
		Integer caseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		ErpFunUsers acceptUser = null;
		if ("public".equalsIgnoreCase(acceptUserId) || "share".equalsIgnoreCase(acceptUserId)) {// 将数据移交到抢盘或者公盘
			boolean haveDealData = true;
			if ("all".equalsIgnoreCase(caseIds)) {
				haveDealData = erpFunLeaseService.detectTransDataByDeptIdAndUserId(param);
			} else {
				haveDealData = erpFunLeaseService.detectTransData(param, caseIds);
			}
			// 转移到抢盘时,须判断选中的信息中是否存在已成交信息
			Assert.isTrueThrow(haveDealData, "您选中的信息有成交或注销的信息，不能移交到" + ("public".equalsIgnoreCase(acceptUserId) ? "抢盘" : "公盘") + "，请选择经纪人再移交！");
			ErpFunDepts acceptDept = erpFunDeptsMapper.getByDeptId(cityId, acceptDeptId);
			updateModel.setUserId(null);
			updateModel.setArchiveId(null);
			updateModel.setGrId(Const.DIC_DEFAULT_GROUP_ID);
			updateModel.setDeptId(acceptDept.getDeptId());// 先用指定的部门的id
			updateModel.setRegId(acceptDept.getRegId());
			updateModel.setAreaId(acceptDept.getAreaId());
			// 处理公盘或者抢盘
			Integer plateType = "public".equalsIgnoreCase(acceptUserId) ? Const.DIC_PLATE_TYPE_PUBLIC : Const.DIC_PLATE_TYPE_SHARE;
			updateModel.setPlateType(plateType.byteValue());
			updateModel.setLeaseStatus(Const.DIC_HOUSE_STATUS_AVAILABLE.intValue());
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setPrivateTime(nowDate);
			} else {
				updateModel.setPublicTime(nowDate);
			}
			updateModel.setOrangeFlag(false);
			updateModel.setPublicCount(1);
			updateModel.setCreatorUid(null);
			updateModel.setLeaseCooperate(false);
			updateModel.setCityShareFlag((byte) 0);
			// 抢盘的时候取消网络推广，公盘不取消
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setLeasePublish(false);
				updateModel.setSendtotencent((byte) 0);
				updateModel.setSendtoWeidian((byte) 0);
				updateModel.setSendtoYouyou((byte) 0);
			}
		} else {
			acceptUser = erpFunUsersMapper.getFunUserByUserId(cityId, Integer.valueOf(acceptUserId));
			// 服务器端也要验证一次接收人是否被注销
			Assert.isTrueThrow(acceptUser.getUserWriteoff(), "接收人账号已被注销，请确认接收人是否正确！");
			updateModel.setUserId(acceptUser.getUserId());
			updateModel.setArchiveId(acceptUser.getArchiveId());
			updateModel.setGrId(acceptUser.getGrId());
			updateModel.setDeptId(acceptUser.getDeptId());
			updateModel.setRegId(acceptUser.getRegId());
			updateModel.setAreaId(acceptUser.getAreaId());
			if (erpSysParaService.getSysRunModelIsPrivate(caseType, cityId, compId)) {// 系统运行模式是否为私有
				updateModel.setPrivateTime(nowDate);
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
			} else {
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			}
		}
		if ("all".equalsIgnoreCase(caseIds)) {
			//reportFunSaleMinService.judgeOperatorTransferShop(cityId, compId, srcUserId, 3, Const.DIC_CASE_TYPE_LEASE_FUN);
			int whileCount = 0;// 还是避免下死循环，一次最多一万条
			while (++whileCount < 10) {
				String tmpUserId = null;
				Integer plateType = null;
				if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
					tmpUserId = srcUserId;
				} else if ("public".equalsIgnoreCase(srcUserId)) {
					plateType = Const.DIC_PLATE_TYPE_PUBLIC;
				} else if ("share".equalsIgnoreCase(srcUserId)) {
					plateType = Const.DIC_PLATE_TYPE_SHARE;
				}
				List<ErpFunLease> casePOList = erpFunLeaseMapper.getTopFunLease(cityId, compId, srcDeptId, tmpUserId, plateType, 500);
				if (casePOList == null || casePOList.size() <= 0) {
					break;
				}
				erpFunLeaseService.dataTranslate(updateModel, acceptUser, casePOList, param);
			}
		} else {
			ErpFunLeaseExample funLeaseExample = new ErpFunLeaseExample();
			funLeaseExample.setShardCityId(cityId);
			funLeaseExample.createCriteria().andLeaseIdIn(StringUtil.toIntList(caseIds, ","));
			List<ErpFunLease> casePOList = erpFunLeaseMapper.selectByExample(funLeaseExample);
			erpFunLeaseService.dataTranslate(updateModel, acceptUser, casePOList, param);
		}
	}
	
	/**
	 * 移交出售数据
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @param updateModel
	 */
	public void dataTranslateSale(DataTranslateParam param, ErpFunSale updateModel) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String caseIds = param.getCaseIds();
		String acceptUserId = param.getAcceptUserId();// 接收人
		Integer acceptDeptId = param.getAcceptDeptId();// 接收门店
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		if (StringUtils.isBlank(caseIds) || caseIds.split(",").length <= 0) {
			throw new BusinessException("没有选中任何移交数据");
		}
		// 移交方和接收方同时为公盘或者抢盘不做 不能将数据移交给本人 判断
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			Assert.isTrueThrow(srcUserId.equals(acceptUserId), "不能将数据移交给本人！");
		}

		Date nowDate = new Date();
		updateModel.setRedFlag(false);// 前端传了非法的HOUSE_USEAGE
		updateModel.setSaleSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		updateModel.setSaleLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		updateModel.setUpdateTime(nowDate);
		updateModel.setSyncTime(nowDate);
		updateModel.setTrackTime(nowDate);
		updateModel.setActionTime(nowDate);
		updateModel.setTrackTime2(nowDate);
		updateModel.setSendtotencent(Const.DIC_QQ_PUBLISH_SYNC_FLAG_0);
		updateModel.setTrueFlag(Const.DIC_INFO_TRUE_INFO_FLAG_0);
		Integer caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		ErpFunUsers acceptUser = null;
		// 将数据移交到抢盘或者公盘
		if ("public".equalsIgnoreCase(acceptUserId) || "share".equalsIgnoreCase(acceptUserId)) {
			// 判断是否有移交成交数据，如果有成交的数据，不可移交到抢盘
			boolean haveDealData = true;
			if ("all".equalsIgnoreCase(caseIds)) {
				haveDealData = erpFunSaleService.detectTransDataByDeptIdAndUserId(param);
			} else {
				haveDealData = erpFunSaleService.detectTransData(param, caseIds);
			}
			// 转移到抢盘时,须判断选中的信息中是否存在已成交信息
			Assert.isTrueThrow(haveDealData, "您选中的信息有成交或注销的信息，不能移交到" + ("public".equals(acceptUserId) ? "抢盘" : "公盘") + "，请选择经纪人再移交！");
			ErpFunDepts acceptDept = erpFunDeptsMapper.getByDeptId(cityId, acceptDeptId);
			updateModel.setUserId(null);
			updateModel.setArchiveId(null);
			updateModel.setGrId(Const.DIC_DEFAULT_GROUP_ID);
			updateModel.setDeptId(acceptDept.getDeptId());// 先用指定的部门的id
			updateModel.setRegId(acceptDept.getRegId());
			updateModel.setAreaId(acceptDept.getAreaId());
			// 处理公盘或者抢盘
			Integer plateType = "public".equalsIgnoreCase(acceptUserId) ? Const.DIC_PLATE_TYPE_PUBLIC : Const.DIC_PLATE_TYPE_SHARE;
			updateModel.setPlateType(plateType.byteValue());
			updateModel.setSaleStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setPrivateTime(nowDate);
			} else {
				updateModel.setPublicTime(nowDate);
			}
			updateModel.setOrangeFlag(false);
			updateModel.setPublicCount(1);
			updateModel.setCreatorUid(null);
			updateModel.setSaleCooperate(false);
			updateModel.setCityShareFlag((byte) 0);
			// 抢盘的时候取消网络推广，公盘不取消
			if ("public".equalsIgnoreCase(acceptUserId)) {
				updateModel.setSalePublish(false);
				updateModel.setSendtotencent((byte) 0);
				updateModel.setSendtoWeidian((byte) 0);
				updateModel.setSendtoYouyou((byte) 0);
			}
		} else {
			acceptUser = erpFunUsersMapper.getFunUserByUserId(cityId, StringUtil.parseInteger(acceptUserId));
			// 服务器端也要验证一次接收人是否被注销
			Assert.isTrueThrow(acceptUser.getUserWriteoff(), "接收人账号已被注销，请确认接收人是否正确！");
			updateModel.setUserId(acceptUser.getUserId());
			updateModel.setArchiveId(acceptUser.getArchiveId());
			updateModel.setGrId(acceptUser.getGrId());
			updateModel.setDeptId(acceptUser.getDeptId());
			updateModel.setRegId(acceptUser.getRegId());
			updateModel.setAreaId(acceptUser.getAreaId());
			if (erpSysParaService.getSysRunModelIsPrivate(caseType, cityId, compId)) {// 系统运行模式是否为私有
				updateModel.setPrivateTime(nowDate);
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
			} else {
				updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
			}
		}
		if ("all".equalsIgnoreCase(caseIds)) {
			//reportFunSaleMinService.judgeOperatorTransferShop(cityId, compId, srcUserId, 3, Const.DIC_CASE_TYPE_SALE_FUN);
			int whileCount = 0;// 还是避免下死循环，一次最多一万条
			while (++whileCount < 10) {
				String tmpUserId = null;
				Integer plateType = null;
				if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
					tmpUserId = srcUserId;
				} else if ("public".equalsIgnoreCase(srcUserId)) {
					plateType = Const.DIC_PLATE_TYPE_PUBLIC;
				} else if ("share".equalsIgnoreCase(srcUserId)) {
					plateType = Const.DIC_PLATE_TYPE_SHARE;
				}
				List<ErpFunSale> casePOList = erpFunSaleMapper.getTopFunSale(cityId, compId, srcDeptId, tmpUserId, plateType, 500);
				if (casePOList == null || casePOList.size() <= 0) {
					break;
				}
				erpFunSaleService.dataTranslate(updateModel, acceptUser, casePOList, param);
			}
		} else {
			ErpFunSaleExample funSaleExample = new ErpFunSaleExample();
			funSaleExample.setShardCityId(cityId);
			funSaleExample.createCriteria().andSaleIdIn(StringUtil.toIntList(caseIds, ","));
			List<ErpFunSale> casePOList = erpFunSaleMapper.selectByExample(funSaleExample);
			erpFunSaleService.dataTranslate(updateModel, acceptUser, casePOList, param);
		}
	}
}




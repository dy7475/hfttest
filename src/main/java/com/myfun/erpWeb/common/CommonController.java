package com.myfun.erpWeb.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.myfun.erpWeb.common.param.*;
import com.myfun.erpWeb.common.vo.*;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.admindb.po.AdminIpCallLogExample.Criteria;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunLeaseDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.*;
import com.myfun.service.business.erpdb.ErpAuditRuntimeService;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.bean.vo.MoveOrganizationServiceVO;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.*;
import com.myfun.utils.bean.FileUploadResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * 找不到分类的接口放这里
 * @author 张宏利
 * @since 2017年9月21日
 */
@RestController
@RequestMapping(value="/common",method=RequestMethod.POST)
public class CommonController extends BaseController{
	@Autowired ErpFunCityMapper erpFunCityMapper;
	@Autowired AdminFunArchiveService adminFunArchiveService;
	@Autowired AdminFunTempletService adminFunTempletService;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired
	AdminFunScoreStandardMonthService adminFunScoreStandardMonthService;
	@Autowired
	ErpDicDefdinitionsService erpDicDefdinitionsService;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired
	private ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	private ErpFunHeadMapper erpFunHeadMapper;
	@Autowired
	private AdminFunTagsMapper adminFunTagsMapper;
	@Autowired
	private AdminLoanRateMapper adminLoanRateMapper;
	@Autowired
	private AdminLocalTaxesMapper adminLocalTaxesMapper;
	@Autowired
	private AdminDuesLoanrateMapper adminDuesLoanrateMapper;
	@Autowired
	private AdminNPicWatermarkMapper adminNPicWatermarkMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private AdminFunShareCompMapper adminFunShareCompMapper;
	@Autowired
	private AdminFunShareRelevanceMapper adminFunShareRelevanceMapper;
	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
	private ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	private AdminIpCallLogMapper adminIpCallLogMapper;
	@Autowired
	AdminFunTempletMapper adminFunTempletMapper;
	@Autowired
	AdminTrackTagMapper adminTrackTagMapper;
	@Autowired
	AdminTrackCommonLanguageMapper adminTrackCommonLanguageMapper;
	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	ErpFunBuildRuleMapper erpFunBuildRuleMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	AdminFunCompSkinMapper adminFunCompSkinMapper;
	@Autowired
	AdminCompGiftCoinRecordService adminCompGiftCoinRecordService;
	@Autowired
	ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired
	ErpFunPrologsMapper erpFunPrologsMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Autowired
	ErpFunSubwayMapper erpFunSubwayMapper;
	@Autowired
	ErpFunStationMapper erpFunStationMapper;
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	private ErpFunPartnerMapper erpFunPartnerMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	ReportFunSaleMinService reportFunSaleMinService;
	@Autowired
	ActiveMqPublisher activeMqPublisher;
	@Autowired
	HttpRequestTask httpRequestTask;
	@Autowired
	ErpFunCrossCompStatusMapper erpFunCrossCompStatusMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpAuditRuntimeService erpAuditRuntimeService;

	/**
	 * 依据省份ID获取城市
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("provinceId")
	@RequestMapping("/getCityListByProvince")
	public ResponseJson getCityListByProvince(@RequestBody BaseMapParam param) {
		List<ErpFunCity> cityList = erpFunCityMapper.getCityListByProvince(getOperator().getCityId(), param.getString("provinceId"));
		return ErpResponseJson.ok(cityList);
	}
	
	/**
	 * 文件上传新接口
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年3月6日
	 */
	@RequestMapping("/fileUpload")
	public ResponseJson fileUpload(@RequestParam("hftPic") MultipartFile[] files, @RequestParam(required = false,name = "watermarkFlag") String watermarkFlag) throws Exception{
		if (!"1".equals(watermarkFlag)) {
			watermarkFlag = "0";
		}
		FileUploadResult fileUploadResult = FileUtil.fileUpload(AppConfig.getFileWebUrl(), files, watermarkFlag);
		return ErpResponseJson.ok(fileUploadResult);
	}
	
	/**
	 * 修改脸部刷脸认证
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年5月14日
	 */
	@RequestMapping("/updateBrokerFaceRecognitionFlag")
	public ResponseJson updateBrokerFaceRecognitionFlag(@RequestBody BaseMapParam param) {
		AdminFunArchive updateModel = new AdminFunArchive();
		updateModel.setArchiveId(param.getInteger("archiveId"));
		updateModel.setFaceRecognitionFlag(StringUtil.parseByte(param.getString("faceFlag"), (byte) 0));
		Operator operator = getOperator();
		adminFunArchiveService.updateFaceFlag(operator.getCityId(), updateModel.getArchiveId(), operator.getCompId(),
				operator.getDeptId(), operator.getUserId(), updateModel.getFaceRecognitionFlag(),
				operator.getUserName());
		return ErpResponseJson.ok();
	}
	
	/**
	 * 修改模板
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年6月26日
	 */
	@RequestMapping("/updateHouseTemplet")
	public ResponseJson updateHouseTemplet(@RequestBody BaseMapParam param){
		Integer id = param.getInteger("id");
		String subjectTemplet = param.getString("subjectTemplet");
		String charactTemplet = param.getString("charactTemplet");
		adminFunTempletService.updateHouseTemplet(id, charactTemplet, subjectTemplet);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询模板
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年6月26日
	 */
	@RequestMapping("/getHouseTemplet")
	public ResponseJson getHouseTemplet(@RequestBody BaseMapParam param){
		// TODO
		return ErpResponseJson.ok();
	}

	/**
	 * 获取核心信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/2
	 */	
	@RequestMapping("/getComCoreInfoById")
	public ResponseJson getComCoreInfoById(@RequestBody BaseMapParam param){
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer caseType = param.getInteger("caseType");
		Integer caseId = param.getInteger("caseId");
		Object resultObj = null;

		// 有明文查看权限的才可以将核心信息明文返回
		boolean encrypt = false;
		boolean fromDealFlag = false;
		Integer isFromDeal = param.getInteger("isFromDeal");//是否来自合同页面，不管权限全部加星号
		if("1".equals(isFromDeal)){
			fromDealFlag = true;
		}
		Integer archiveId = null;
		String caseNo = null;
		String useage = null;
		Byte plateType = null;
		Integer msgModule = null;
		String caseTypeStr = null;
		boolean isSelfInfo =false;
		if (Const.DIC_CASE_TYPE_SALE_FUN==caseType) {
			//根据ID获取房客源数据
			ErpFunSale salePo = erpFunSaleMapper.getFunSaleBySaleId(cityId,caseId);
			// 获取核心信息只能本公司
			if(!getOperator().getCompId().equals(salePo.getCompId())) {
				throw new BusinessException("获取核心信息失败");
			}
			Integer infoUserId=salePo.getUserId();
			isSelfInfo = getOperator().getUserId().equals(infoUserId);
			//暂时取消判断
			encrypt = this.showAllOwnerPhoneInfo(Const.DIC_CASE_TYPE_SALE_FUN, isSelfInfo);
			ErpFunSaleDto funSaleVO = new ErpFunSaleDto();
			if(fromDealFlag){
				encrypt = false;
			}
			Map<String,String> decodePhoneMap = this.decodePhone(salePo.getJointIdCard(),salePo.getJointCellPhone(),salePo.getCellPhone(),encrypt);
			funSaleVO.setPhoneSend(decodePhoneMap.get("phoneSend"));
			funSaleVO.setJointCellPhone(decodePhoneMap.get("jointCellPhone"));
			funSaleVO.setCellPhone(decodePhoneMap.get("cellPhone"));


			salePo.setIdCard(EnCodeHelper.decode(salePo.getIdCard()));
			salePo.setSaleRoof(EnCodeHelper.decode(salePo.getSaleRoof()));
			salePo.setSaleUnit(EnCodeHelper.decode(salePo.getSaleUnit()));
			salePo.setUnitFloor(EnCodeHelper.decode(salePo.getUnitFloor()));
			salePo.setSaleNum(EnCodeHelper.decode(salePo.getSaleNum()));
			salePo.setSaleRoofR(EnCodeHelper.decode(salePo.getSaleRoofR()));
			salePo.setSaleUnitR(EnCodeHelper.decode(salePo.getSaleUnitR()));
			salePo.setUnitFloorR(EnCodeHelper.decode(salePo.getUnitFloorR()));
			salePo.setSaleNumR(EnCodeHelper.decode(salePo.getSaleNumR()));
			try {
				BeanUtil.copyObject(salePo,funSaleVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultObj = funSaleVO;
			// 写提醒房源所属人
			archiveId = salePo.getArchiveId();
			caseNo = salePo.getSaleNo();
			caseType = Const.DIC_CASE_TYPE_SALE_FUN;
			useage = StringUtil.toString(salePo.getSaleUseage());
			msgModule = Const.MsgModule.HOUSE;
			plateType = salePo.getPlateType();
			caseTypeStr = "房源";
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN==caseType) {
			//根据ID获取房客源数据
			ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId,caseId);
			// 获取核心信息只能本公司
			if(!getOperator().getCompId().equals(funLease.getCompId())) {
				throw new BusinessException("获取核心信息失败");
			}
			Integer infoUserId=funLease.getUserId();
			isSelfInfo = getOperator().getUserId().equals(infoUserId);
			//暂时取消判断
			encrypt = this.showAllOwnerPhoneInfo(Const.DIC_CASE_TYPE_LEASE_FUN, isSelfInfo);
			ErpFunLeaseDto funLeaseDto = new ErpFunLeaseDto();
			if(fromDealFlag){
				encrypt = false;
			}
			Map<String,String> decodePhoneMap = this.decodePhone(funLease.getJointIdCard(),funLease.getJointCellPhone(),funLease.getCellPhone(),encrypt);
			funLeaseDto.setPhoneSend(decodePhoneMap.get("phoneSend"));
			funLeaseDto.setJointCellPhone(decodePhoneMap.get("jointCellPhone"));
			funLeaseDto.setCellPhone(decodePhoneMap.get("cellPhone"));

			funLease.setIdCard(EnCodeHelper.decode(funLease.getIdCard()));
			funLease.setLeaseRoof(EnCodeHelper.decode(funLease.getLeaseRoof()));
			funLease.setLeaseUnit(EnCodeHelper.decode(funLease.getLeaseUnit()));
			funLease.setUnitFloor(EnCodeHelper.decode(funLease.getUnitFloor()));
			funLease.setLeaseNum(EnCodeHelper.decode(funLease.getLeaseNum()));
			funLease.setLeaseRoofR(EnCodeHelper.decode(funLease.getLeaseRoofR()));
			funLease.setLeaseUnitR(EnCodeHelper.decode(funLease.getLeaseUnitR()));
			funLease.setUnitFloorR(EnCodeHelper.decode(funLease.getUnitFloorR()));
			funLease.setLeaseNumR(EnCodeHelper.decode(funLease.getLeaseNumR()));
			try {
				BeanUtil.copyObject(funLease,funLeaseDto);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultObj = funLeaseDto;
			// 写提醒房源所属人
			archiveId = funLease.getArchiveId();
			caseNo = funLease.getLeaseNo();
			caseType = Const.DIC_CASE_TYPE_LEASE_FUN;
			useage = StringUtil.toString(funLease.getLeaseUseage());
			msgModule = Const.MsgModule.HOUSE;
			plateType = funLease.getPlateType();
			caseTypeStr = "房源";
		} else if (Const.DIC_CASE_TYPE_BUY_CUST==caseType) {
			//根据ID获取房客源数据
			ErpFunRentCustomer rentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId,caseId);
			// 获取核心信息只能本公司
			if(!getOperator().getCompId().equals(rentCustomer.getCompId())) {
				throw new BusinessException("获取核心信息失败");
			}
			Integer infoUserId=rentCustomer.getUserId();
			isSelfInfo = getOperator().getUserId().equals(infoUserId);
			//暂时取消判断
			encrypt = this.showAllOwnerPhoneInfo(Const.DIC_CASE_TYPE_BUY_CUST, isSelfInfo);
			ErpFunBuyCustomerDto funbuyCustomerVO = new ErpFunBuyCustomerDto();
			//处理加密字符串custMemo

			String[] strings=this.decodeCustField(rentCustomer.getCustMemo(),rentCustomer.getCustAddr());
			rentCustomer.setCustMemo(strings[0]);
			rentCustomer.setCustAddr(strings[1]);
			rentCustomer.setIdCard(EnCodeHelper.decode(rentCustomer.getIdCard()));
			if(fromDealFlag){
				encrypt = false;
			}
			String weChat = rentCustomer.getWechatNumber();
			weChat = StringUtil.isBlank(weChat)? "" :EnCodeHelper.decode(weChat);
			if(StringUtil.isNotBlank(weChat) && !encrypt) {
				weChat = weChat.substring(0, 1)+"***"+weChat.substring(weChat.length()-1, weChat.length());
			}
			rentCustomer.setWechatNumber(weChat);
			Map<String,String> decodePhoneMap = this.decodePhone(null,null,rentCustomer.getCellPhone(),encrypt);
			funbuyCustomerVO.setPhoneSend(decodePhoneMap.get("phoneSend"));
			try {
				BeanUtil.copyObject(rentCustomer,funbuyCustomerVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultObj = funbuyCustomerVO;
			// 写提醒房源所属人
			caseNo = rentCustomer.getRentCustNo();
			archiveId = rentCustomer.getArchiveId();
			caseType = Const.DIC_CASE_TYPE_BUY_CUST;
			useage = rentCustomer.getHouseUseage();
			msgModule = Const.MsgModule.CUST;
			plateType = rentCustomer.getPlateType();
			caseTypeStr = "客源";
		} else if (Const.DIC_CASE_TYPE_RENT_CUST==caseType) {
			//根据ID获取房客源数据
			ErpFunBuyCustomer buyCustPO = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId,caseId);
			// 获取核心信息只能本公司
			if(!getOperator().getCompId().equals(buyCustPO.getCompId())) {
				throw new BusinessException("获取核心信息失败");
			}
			Integer infoUserId=buyCustPO.getUserId();
			isSelfInfo = getOperator().getUserId().equals(infoUserId);
			//暂时取消判断
			encrypt = this.showAllOwnerPhoneInfo(Const.DIC_CASE_TYPE_RENT_CUST, isSelfInfo);
			ErpFunBuyCustomerDto funbuyCustomerVO = new ErpFunBuyCustomerDto();
			//处理加密字符串
			String[] strings=this.decodeCustField(buyCustPO.getCustMemo(),buyCustPO.getCustAddr());
			buyCustPO.setCustMemo(strings[0]);
			buyCustPO.setCustAddr(strings[1]);
			buyCustPO.setIdCard(EnCodeHelper.decode(buyCustPO.getIdCard()));
			if(fromDealFlag){
				encrypt = false;
			}
			String weChat = buyCustPO.getWechatNumber();
			weChat = CommonUtil.isnull(weChat) ? "" :EnCodeHelper.decode(weChat);
			if(!CommonUtil.isnull(weChat) && !encrypt) {
				weChat = weChat.substring(0, 1)+"***"+weChat.substring(weChat.length()-1, weChat.length());
			}
			buyCustPO.setWechatNumber(weChat);
			Map<String,String> decodePhoneMap = this.decodePhone(null,null,buyCustPO.getCellPhone(),encrypt);
			funbuyCustomerVO.setPhoneSend(decodePhoneMap.get("phoneSend"));
			try {
				BeanUtil.copyObject(buyCustPO,funbuyCustomerVO);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resultObj = funbuyCustomerVO;
			// 写提醒房源所属人
			caseNo = buyCustPO.getBuyCustNo();
			archiveId = buyCustPO.getArchiveId();
			caseType = Const.DIC_CASE_TYPE_RENT_CUST;
			useage = buyCustPO.getHouseUseage();
			msgModule = Const.MsgModule.CUST;
			plateType = buyCustPO.getPlateType();
			caseTypeStr = "客源";
		}
		// 不是自己的房源，则写socket提醒给房源所属人电话被查看
		if(!isSelfInfo){
			ErpDicDefinitions erpDicDefinitions = erpDicDefinitionsMapper.getDicDefinitions(cityId,"PLATE_TYPE", StringUtil.toString(plateType));
			String plateMsg=erpDicDefinitions.getDicCnMsg();
			String msgContent = this.getCurrUserName() + "查看了该"+plateMsg+caseTypeStr+"核心信息.";

			AdminFunUserMessage adminFunUserMessage=new AdminFunUserMessage();
			adminFunUserMessage.setArchiveId(archiveId);
			adminFunUserMessage.setCityId(cityId);
			adminFunUserMessage.setCompId(compId);
			adminFunUserMessage.setMsgContent(msgContent);
			adminFunUserMessage.setCaseId(caseId);
			adminFunUserMessage.setCaseType(caseType);
			adminFunUserMessage.setCaseNo(caseNo);
			adminFunUserMessage.setHouseUseage(useage.getBytes()[0]);
			adminFunUserMessage.setMsgModule(msgModule);
			adminFunUserMessage.setModuleType(Const.MsgModuleType.VIEW_PHONE);
			adminFunUserMessage.setAppType(1);
			adminFunUserMessage.setIsDel((byte)0);
			TaskQueueThread.sendMessage(adminFunUserMessage);
		}
		return ErpResponseJson.ok(resultObj);
	}

	/**
	 * 好房通使用评分
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	@ApiOperation(value = "好房通使用评分",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = ErpResponseJson.class,message = "success")})
	@RequestMapping("/createCppUseOperation")
	@NotBlank("scoreType")
	public ResponseJson createCppUseOperation(@RequestBody @Valid  CppUseOperationParam param){
		Integer scoreType = param.getScoreType();
		GeneralParam generalParam=new GeneralParam(getOperator());
		adminFunScoreStandardMonthService.insertAdminFunUseScoreRecore(scoreType,generalParam);
		return ErpResponseJson.ok();
	}

	/**
	 * 返回所有数据字典信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/24
	 */
	@ApiOperation("返回所有数据字典信息,作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpDicDefinitionsVo.class, message = "成功")})
	@RequestMapping("/getDDinfoList")
	public ResponseJson getDDinfoList(@RequestBody GetDDinfoListParam param) {
		String updateTime = param.getUpdateTime();
		Integer cityId = getOperator().getCityId();
		List<ErpDicDefinitions> list = erpDicDefinitionsMapper.getDicDefinitionsByUpdateTime(cityId, updateTime);
		for (ErpDicDefinitions definitionsPO : list) {
			if ("HOUSE_FITMENT".equals(definitionsPO.getDicType())) {
				if ("4".equals(definitionsPO.getDicValue()) || "5".equals(definitionsPO.getDicValue())) {
					definitionsPO.setIsDel((byte) 1);
				}
			}
		}
		// 下面的代码 只做容错处理，后期等前端发布版本后要删除掉
		boolean citySelfRound = false;// 该城市是否有自己的范围
		List<ErpDicDefinitions> listTmp = new ArrayList<>();
		List<ErpDicDefinitions> listTmpZero = new ArrayList<>();
		for (ErpDicDefinitions tmp : list) {
			if (tmp.getDicType().equals("HOUSE_ROUND")) {
				// 如果该城市具备
				if (tmp.getCityId().equals(getOperator().getCityId().shortValue())) {
					citySelfRound = true;
					listTmp.add(tmp);
				} else if (tmp.getCityId() == 0) {
					listTmpZero.add(tmp);
				}
			}
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			ErpDicDefinitions tmp = list.get(i);
			if (tmp.getDicType().equals("HOUSE_ROUND")) {
				list.remove(i);
			}
		}
		if (citySelfRound) {
			list.addAll(listTmp);
		} else {
			list.addAll(listTmpZero);
		}
		// 上面的代码 只做容错处理，后期等前端发布版本后要删除掉
		if (list.size() > 0) {// 检测如果存在更新则清除缓存
			erpDicDefdinitionsService.evictCacheableModelData();
		}
		return ErpResponseJson.ok(list);
	}

	/**
	 * 通用的获取部门加用户名
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/3
	 */	
	private String getCurrUserName() {
		String currUname = getOperator().getUserName();
		// 不是纯精英版也不是专业版 才写门店名称
		if (!Constants_DIC.DIC_COMP_TYPE_2.equals(getOperator().getCompType()) && !getOperator().isPersonalVersion()) {
			currUname = getOperator().getDeptName() + " " + currUname;
		}
		return currUname;
	}	

	/**
	 * 是否明文显示业主的手机号
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/3
	 */
	private boolean showAllOwnerPhoneInfo(Integer caseType, boolean isSelfInfo) {
		//纯精英版默认直接显示业主手机号 陈文超
		Operator operator = getOperator();
		if (operator.isPersonalVersion()) {
			return true;
		}
		List<ErpSysPara> erpSysParas = erpSysParaService.getMLSysParamListDefZero(operator.getCityId(), operator.getCompId(), getOperator().getUserId(), Arrays.asList(new String[]{"IS_OPEN_HIDEPHONE","IS_OPEN_HIDE_SELF_PHONE"}));
		Map<String,ErpSysPara> sysParaMap = erpSysParas.stream().collect(Collectors.toMap(ErpSysPara::getParamId,val->val));
		boolean haveShowPhone = false;
		//2016-01-21改版之前是用权限控制的---2016-05-17又要这个权限来控制了zhl
		// 如果租售分开控制了，请一定要改调用这个的地方！
		if(Const.DIC_CASE_TYPE_SALE_FUN==caseType ||Const.DIC_CASE_TYPE_LEASE_FUN==caseType){
			haveShowPhone = this.judgePermission(getOperator().getUserId(), "HOUSE_VOIP_SHOW_PHONE");
		}else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) ||Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			haveShowPhone =this.judgePermission(getOperator().getUserId(), "CUSTOMER_VOIP_SHOW_PHONE");
		}
		// 如果有权限看明文直接返回，否则判断是否开启隐号模式
		if(haveShowPhone){
			return true;
		}
		// 判断隐号拨打模式--开启则不能明文显示
		ErpSysPara isOpenHiddenPhone = sysParaMap.get("IS_OPEN_HIDEPHONE");
		if(isOpenHiddenPhone != null && Const.IS_OPEN_HIDEPHONE_1.equals(isOpenHiddenPhone.getParamValue())){//隐号拨打
			if(getOperator().isGeneralManager() || ("5".equals(getOperator().getCompType()) && "PROPERTY_SERVER".equals(getOperator().getUserPosition()))) {
				return true;// 隐号拨打时总经理账号可看明文电话
			}
			ErpSysPara isOpenHiddenOwnerPhone = sysParaMap.get("IS_OPEN_HIDE_SELF_PHONE");
			if(isOpenHiddenOwnerPhone != null && isSelfInfo
					&& !Const.IS_OPEN_HIDE_SELF_PHONE_1.equals(isOpenHiddenOwnerPhone.getParamValue())
					){
				return true;// 参数：个人不是隐号，而且数据是自己的则直接返回明文号码
			}
			return false;
		} else {
			return true;
		}
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
	 * 电话号码解密
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/3
	 */	
	protected Map<String,String> decodePhone(String jointIdCard,String jointCellPhone,String cellPhone, boolean encrypt){
		Map<String,String> map=new HashMap<>();
		if (StringUtil.isNotBlank(jointIdCard) ) {
			String phone = "";
			String[] phones = StringHelper.split(jointCellPhone, "&&&");
			try {
				for (int i = 0; i < phones.length; i++) {
					String[] phoneValues = StringHelper.split(phones[i], "|||");
					phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
					if (!encrypt && !"境外".equals(phoneValues[0])) {
						SyncUtil.ecodePhoneToArr(phoneValues);// 电话中间加密成*号
					}
					phone += phoneValues[0] + ":" + phoneValues[1];// 以后共有人电话多个时候加空字符串
				}
			} catch (Exception e) {
				phone = jointCellPhone;
			}
			map.put("jointCellPhone",phone);
		}
		String phone = " ";
		if (StringUtil.isNotBlank(cellPhone)) {
			String[] phones = StringHelper.split(cellPhone, "&&&");
			try {
				for (int i = 0; i < phones.length; i++) {
					String[] phoneValues = StringHelper.split(phones[i], "|||");
					phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
					if (!encrypt && !"境外".equals(phoneValues[0])) {
						SyncUtil.ecodePhoneToArr(phoneValues);// 电话中间加密成*号
					}
					phone += phoneValues[0] + ":" + phoneValues[1] + " ";
				}
			} catch (Exception e) {
				phone = cellPhone;
			}
			map.put("cellPhone",phone);
		}
		String phoneSend = phone;
		phoneSend = StringHelper.replaceAll(phoneSend, "手机", "MOBILE");
		phoneSend = StringHelper.replaceAll(phoneSend, "小灵通", "CELL");
		phoneSend = StringHelper.replaceAll(phoneSend, "座机", "TELE");
		phoneSend = StringHelper.replaceAll(phoneSend, "境外", "FOREIGN");
		map.put("phoneSend",phoneSend);
		return map;
	}

	private String[] decodeCustField(String custMemo,String custAddr){
		custMemo = CommonUtil.isnull(custMemo) ? "" : HTMLHelper.toHTMLString(custMemo, HTMLHelper.ES_DEF$INPUT).replaceAll("\r\n","").replaceAll("\n","&EACE");
		custMemo = custMemo.replaceAll("\\\\", "/");
		custAddr = CommonUtil.isnull(custAddr) ? "" : HTMLHelper.toHTMLString(custAddr, HTMLHelper.ES_DEF$INPUT).replaceAll("\r\n","&EACE").replaceAll("\n","&EACE");
		String[] strings=new String[]{};
		strings[0]=custMemo;
		strings[1]=custAddr;
		return strings;
	}
	
	/**
	 * @Title 登陆前初始化
	 * @Author lcbErpFunStationMapper
	 * @Time 2018/11/22
	 **/
	@RequestMapping("/getAppInitData")
	@ApiOperation("登陆初始化数据")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = AppInitDataVo.class)})
	public ResponseJson getAppInitData(@RequestBody AppInitDataParam param) throws Exception{
		AppInitDataVo returnVO = new AppInitDataVo();
		Integer compId = param.getCompId();
		String updateTime = param.getUpdateTime();
		String updateDicTime = param.getUpdateDicTime();
		Integer deptFlag = param.getDeptFlag();
		Integer cityId = param.getCityId();
		if(0 != deptFlag) {
			List<ErpFunRegVo> regListByCityId = this.getRegVoListByCityIdUpdate(param.getCityId(),param.getUpdateTime());
			returnVO.setRegion(regListByCityId);
			List<ErpFunSectionVo> erpFunSectionList = this.getSectionVoListByCityIdUpdate(param.getCityId(),param.getUpdateTime());
			returnVO.setSection(erpFunSectionList);
			returnVO.setMgrAllRoleList(this.getAllRoleList(param));
			returnVO.setFunAndCustHeadList(getHeadList(cityId, compId, null, param.getHeadShow(), param.getCaseType(), param.getUpdateTime()));
			returnVO.setHouseTags(getFunTagsVoList(updateTime));
			returnVO.setDDinfoList(getDDList(cityId, updateDicTime));
			returnVO.setSubwayList(this.getAllSubway(param));
			returnVO.setStationList(this.getAllStation(param));
		}

		List<AdminTrackTagVo> adminTrackTags = this.getTrackTagVoListUpdate(updateTime);
		returnVO.setTrackTags(adminTrackTags);
		List<AdminTrackCommonLanguageVo> adminTrackCommonLanguages = this.getTrackCommonLanuageVoListUpdate(updateTime);
		returnVO.setTrackCommonLanguage(adminTrackCommonLanguages);
		return ErpResponseJson.ok(returnVO);
	}

	private List<ErpDicDefinitionsVo> getDDList(Integer cityId, String updateDicTime) {
		List<ErpDicDefinitionsVo> erpDicDefinitionsList = erpDicDefinitionsMapper.getDicDefinitionsVoList(cityId, updateDicTime);

		for (ErpDicDefinitionsVo definitionsPO : erpDicDefinitionsList) {
			if("HOUSE_FITMENT".equals(definitionsPO.getDicType())) {
				if("4".equals(definitionsPO.getDicValue()) || "5".equals(definitionsPO.getDicValue())) {
					definitionsPO.setIsDel(1);
				}
			}
		}

		//下面的代码 只做容错处理，后期等前端发布版本后要删除掉 陈文超
		Boolean citySelfRound = false;//该城市是否有自己的范围
		List<ErpDicDefinitionsVo> listTmp = new ArrayList<>(erpDicDefinitionsList.size());
		List<ErpDicDefinitionsVo> listTmpZero = new ArrayList<>(erpDicDefinitionsList.size());
		for (ErpDicDefinitionsVo tmp : erpDicDefinitionsList) {
			if(tmp.getDicType().equals("HOUSE_ROUND")){
				//如果该城市具备
				if(tmp.getCityId().equals(cityId.shortValue())){
					citySelfRound = true;
					listTmp.add(tmp);
				}else if(0 == tmp.getCityId().intValue()){
					listTmpZero.add(tmp);
				}
			}
		}

		Iterator<ErpDicDefinitionsVo> iterator = erpDicDefinitionsList.iterator();
		while (iterator.hasNext()) {
			ErpDicDefinitionsVo student = iterator.next();
			if ("HOUSE_ROUND".equals(student.getDicType())) {
				iterator.remove();//使用迭代器的删除方法删除
			}
		}

		if(citySelfRound){
			erpDicDefinitionsList.addAll(listTmp);
		}else{
			erpDicDefinitionsList.addAll(listTmpZero);
		}

		//上面的代码 只做容错处理，后期等前端发布版本后要删除掉  陈文超
		if(erpDicDefinitionsList.size() > 0){//检测如果存在更新则清除缓存
			erpDicDefdinitionsService.evictCacheableModelData();
		}

		return erpDicDefinitionsList;
	}

	private List<AdminFunTagsVo> getFunTagsVoList(String updateTime) {
		if(StringUtils.isNotBlank(updateTime)) {
			AdminFunTagsExample adminFunTagsExample = new AdminFunTagsExample();
			adminFunTagsExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(updateTime);
			int updateCount = adminFunTagsMapper.countByExample(adminFunTagsExample);
			if(updateCount < 1 ) {
				return null;
			}
		}
		List<AdminFunTagsVo> funTagsVoList = adminFunTagsMapper.getFunTagsVoList();
		return funTagsVoList;
	}

	public List<ErpCompRoles> getAllRoleList(AppInitDataParam param) {
		if(StringUtils.isNotBlank(param.getUpdateTime())) {
			// 先判断时间段内有无修改的
			ErpCompRolesExample erpCompRolesExample = new ErpCompRolesExample();
			erpCompRolesExample.setShardCityId(param.getCityId());
			erpCompRolesExample.createCriteria().andCompIdEqualTo(param.getCompId()).andUpdateTimeGreaterThanOrEqualTo(param.getUpdateTime());
			int updateCount = erpCompRolesMapper.countByExample(erpCompRolesExample);
			if(updateCount < 1) {
				return null;
			}
		}

		List<ErpCompRoles> lowerRolesList = erpCompRolesMapper.getAllCompRole(param.getCityId(), param.getCompId());
		Integer generalIndex = null;
		for (int i = 0; i < lowerRolesList.size(); i++) {
			if ("GENERAL_MANAGER".equals(lowerRolesList.get(i).getRoleId())) {
				generalIndex = i;
				break;
			}
		}
		if (generalIndex != 0) {
			Collections.swap(lowerRolesList, 0, generalIndex);
		}
		return lowerRolesList;
	}

	private List<AdminTrackCommonLanguageVo> getTrackCommonLanuageVoListUpdate(String updateTime) {
		if(StringUtils.isNotBlank(updateTime)) {
			AdminTrackCommonLanguageExample  trackCommonLanguageExample = new AdminTrackCommonLanguageExample();
			if (StringUtils.isNotBlank(updateTime)){
				trackCommonLanguageExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateTime));
			}
			Integer count = adminTrackCommonLanguageMapper.countByExample(trackCommonLanguageExample);
			if (count <= 0){
				return null;
			}
		}
		return adminTrackCommonLanguageMapper.getTrackCommonLanuageVoList();
	}

	private List<AdminTrackTagVo> getTrackTagVoListUpdate(String updateTime) {

		if(StringUtils.isNotBlank(updateTime)) {
			AdminTrackTagExample  adminTrackTagExample = new AdminTrackTagExample();
			adminTrackTagExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateTime));
			Integer count = adminTrackTagMapper.countByExample(adminTrackTagExample);
			if (count < 1){
				return null;
			}
		}

		return  adminTrackTagMapper.getTrackTagVoList();
	}

	private List<ErpFunSectionVo> getSectionVoListByCityIdUpdate(Integer cityId, String updateTime) {
		if(StringUtils.isNotBlank(updateTime)) {
			ErpFunSectionExample  erpFunSectionExample = new ErpFunSectionExample();
			erpFunSectionExample.setShardCityId(cityId);
			ErpFunSectionExample.Criteria criteria = erpFunSectionExample.createCriteria();
			criteria.andCityIdEqualTo(cityId.shortValue());
			if (StringUtils.isNotBlank(updateTime)){
				criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
			}
			Integer count = erpFunSectionMapper.countByExample(erpFunSectionExample);
			if (count <= 0){
				return null;
			}
		}
		return erpFunSectionMapper.getRegVoListByCityId(cityId);
	}

	private List<ErpFunRegVo> getRegVoListByCityIdUpdate(Integer cityId, String updateTime) {
		if(StringUtils.isNotBlank(updateTime)) {
			ErpFunRegExample  erpFunRegExample = new ErpFunRegExample();
			erpFunRegExample.setShardCityId(cityId);
			ErpFunRegExample.Criteria criteria = erpFunRegExample.createCriteria();
			criteria.andCityIdEqualTo(cityId.shortValue());
			if (StringUtils.isNotBlank(updateTime)){
				criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
			}
			Integer count = erpFunRegMapper.countByExample(erpFunRegExample);
			if (count <= 0){
				return null;
			}
		}

		return  erpFunRegMapper.getRegVoListByCityId(cityId);
	}

	/**
	 * @author lcb
	 * detail [2020-04-11] yz 美联2.3 - 美联kpi路由
	 * @tag  登录接口
	 * @since 2019/11/7
	 */
	@ApiOperation("登录中调用,作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = GetAppInitDataWithSessionVo.class, message = "成功")})
	@RequestMapping("/getAppInitDataWithSession")
	public ResponseJson getAppInitDataWithSession(@RequestBody GetAppInitDataWithSessionParam param) throws Exception {
		GetAppInitDataWithSessionVo returnVO = new GetAppInitDataWithSessionVo();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String updateTime = param.getUpdateTime();
		Integer delCompId = param.getDelCompId();
		String currentCompNo = operator.getCompNo();
		String currentDeptNo = operator.getDeptNo();
		String updateDelcompinfoTime = param.getUpdateDelcompinfoTime();

		String compModel = getOperator().getCompModel();
		if(Constants_DIC.DIC_IS_KEWEI_COMP_MODEL.equals(compModel)){
			// 加盟圈总店
			String compAttr = getOperator().getCompAttr();
			if("1".equals(compAttr)){
				if(Constants_DIC.DIC_COMP_VIEW_RANGE.equals(getOperator().getAttribute("COMP_VIEW_RANGE"))){
					returnVO.setJoinCompNewList(this.getJoinCompListNew(cityId, currentCompNo));
					returnVO.setJoinCircleList(this.getShareCompList(cityId, currentCompNo));
				}else{
					//总公司下的所有加盟公司
					List<JoinCompListNewVO> joinCompList = this.getJoinCompList(cityId);
					if(joinCompList.size() > 0) {
						StringBuffer buffer = new StringBuffer();
						joinCompList.forEach(val-> {
							buffer.append(val.getCompNo() + ",");
						});
						buffer.setLength(buffer.length() - 1);
						operator.setAttribute("COMP_NOS",  buffer.toString());
					}
					returnVO.setJoinCompNewList(joinCompList);
				}
				// 分店
			}else {
				if(Constants_DIC.DIC_COMP_VIEW_RANGE.equals(getOperator().getAttribute("COMP_VIEW_RANGE"))){
					returnVO.setJoinCompNewList(this.getJoinCompListNew(cityId, currentCompNo));
					returnVO.setJoinCircleList(this.getShareCompList(cityId, currentCompNo));
				}else{
					Integer shareId = param.getShareId();
					//不是总公司的只能查询与之共享的公司【共享圈数据】
					returnVO.setJoinCompNewList(this.getJoinCompsByShareId(cityId, currentCompNo, shareId));
					if(null != shareId) {
						operator.setAttribute("SHARE_ID", shareId);
					}
				}
			}
		}

		List<ErpFunAreaBaseInfoVO> areaBaseInfoList = this.getAreaBaseInfoList(operator.getAreaId(), param.getUpdateTime());

		List<ErpFunRegBaseInfoVO> regionBaseInfoList = this.getRegionBaseInfoList(cityId, compId,param.getAreaId(), param.getUpdateTime(), operator.getAreaId());
		// 片区
		returnVO.setRangeList(regionBaseInfoList);
		// 大区
		returnVO.setAreaList(areaBaseInfoList);

		// 更新分组
		List<ErpFunDeptsGroupBaseInfoVO> groupList = this.getGroupListUpdate(cityId, compId, updateTime);
		returnVO.setGroupList(groupList);

		boolean keweiCompModel = getOperator().isKEWEI_COMP_MODEL();
		returnVO.setCircleDeptList(this.getCircleDeptIdsByCompNos(cityId, param.getCompNos(), keweiCompModel));
		returnVO.setAreaDelList(this.getDelAreaUpdateList(delCompId, updateDelcompinfoTime));
		returnVO.setRegDelList(this.getDelRegionUpdateList(delCompId, updateDelcompinfoTime));
		returnVO.setDeptDelList(this.getDelDeptUpdateList(delCompId, updateDelcompinfoTime));
		returnVO.setGroupDelList(this.getDelGroupUpdateList(delCompId, updateDelcompinfoTime));
		// 临时注释
//		returnVO.setUserDelList(this.getDelUserUpdateList(delCompId, updateDelcompinfoTime));

		if(!getOperator().isPersonalVersion()){
			List<ErpFunDepts> deptsList = this.getDeptListUpdate(cityId,compId,updateTime);
			List<ErpFunUsers> userList = this.getUserListUpdate(cityId,compId,updateTime);
			returnVO.setDeptList(deptsList);
			returnVO.setUserList(userList);
		}

		// 返回图片的地址
		AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByDeptNoAndCompNo(currentDeptNo, currentCompNo);

		ErpFunComp compInfoByCompNo = erpFunCompMapper.getBaseCompInfo(cityId, compId);

		AdminFunCity adminFunCityTemp = adminFunCityMapper.getDataByCityId(cityId);
		AppInitDataWithSessionPicVo appInitDataWithSessionPicVo = new AppInitDataWithSessionPicVo();
		String cEndIcon = CommonUtil.getHousePhoto("oss/online/nihao/2019/06/24/59478f29fb9b4f8eb9dfed79c7d6e04e.png");// 优选平台图标（@3x）
		String funCompLogoAddr = "";
		if(null != adminFunDeptsPO.getYouDianStatus() && 1 == adminFunDeptsPO.getYouDianStatus()){
			funCompLogoAddr = CommonUtil.getHousePhoto(adminFunCityTemp.getYouDianLogoPath());// 优优好房的LOGO
			cEndIcon = CommonUtil.getHousePhoto("oss/online/nihao/2019/06/24/6c6f4b1f0b7741ffba0edf0e2c8d2ed8.png"); // 优优平台图标（@3x）
		} else if(null != adminFunDeptsPO.getYoujiaDeptFlag() && 1 == adminFunDeptsPO.getYoujiaDeptFlag()){
			funCompLogoAddr = CommonUtil.getHousePhoto(adminFunCityTemp.getYouLogoPath());// 公司水牌打印上的LOGO 陈文超 任海生
		}else if (StringUtils.isNotBlank(compInfoByCompNo.getLogoPath())) {
			funCompLogoAddr = CommonUtil.getHousePhoto(compInfoByCompNo.getLogoPath());// 公司水牌打印上的LOGO 陈文超 任海生
		}
		appInitDataWithSessionPicVo.setcEndIcon(cEndIcon);
		appInitDataWithSessionPicVo.setFunCompLogoAddr(funCompLogoAddr);
		// 109636 【ERP】软件初始化时增加图片信息返回，区分版本
		appInitDataWithSessionPicVo.setAppDownloadAddr(CommonUtil.getHousePhoto("oss/online/nihao/2019/07/18/68c601e6fff1435f9d1b60cac0404522.png"));// 掌通的下载二维码图
		returnVO.setAppInitDataPicVo(appInitDataWithSessionPicVo);

		Byte openPartner = compInfoByCompNo.getOpenPartner();
		if (openPartner != null && openPartner == 1) {
			ErpFunPartnerExample erpFunPartnerExample = new ErpFunPartnerExample();
			erpFunPartnerExample.setShardCityId(cityId);
			erpFunPartnerExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0);
			List<ErpFunPartner> partners = erpFunPartnerMapper.selectByExample(erpFunPartnerExample);

			if (CollectionUtils.isNotEmpty(partners)) {
				returnVO.setPartnerList(partners);
			}
		}

		// 内嵌网页地址列表
		List<WebUrlVO> webUrlList = new ArrayList<>();
		String uuhfWebNetDomain = AppConfig.getProperty("common.uuhfWebNet.path");
		WebUrlVO webUrlVO1 = new WebUrlVO();
		webUrlVO1.setName("entrustDetail"); // 委托详情
		webUrlVO1.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/erpCurrentEntrust");
		webUrlList.add(webUrlVO1);

		WebUrlVO webUrlVO2 = new WebUrlVO();
		webUrlVO2.setName("historyEntrustList"); // 历史委托
		webUrlVO2.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/erpHistoryEntrust");
		webUrlList.add(webUrlVO2);

		WebUrlVO webUrlVO3 = new WebUrlVO();
		webUrlVO3.setName("entrustAuditDetail"); // 委托审核详情
		webUrlVO3.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/erpEntrustDetail");
		webUrlList.add(webUrlVO3);

		WebUrlVO webUrlVO4 = new WebUrlVO();
		webUrlVO4.setName("editEntrust"); // 新增、编辑委托
		webUrlVO4.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/erpEditEntrust");
		webUrlList.add(webUrlVO4);

		WebUrlVO webUrlVO5 = new WebUrlVO();
		webUrlVO5.setName("pictureCheck"); // 图片审核
		webUrlVO5.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/erpPictureCheck");
		webUrlList.add(webUrlVO5);

		WebUrlVO webUrlVO6 = new WebUrlVO();
		webUrlVO6.setName("newBuildAgencyProject"); // 新房 代理项目
		webUrlVO6.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/projectAgent");
		webUrlList.add(webUrlVO6);
		if (operator.newOrganizationType()) { // 新版组织架构
			String uuhfWebNetDomain1 = AppConfig.getProperty("common.uuhfWebNet.path");
			WebUrlVO webUrlVO = new WebUrlVO();
			webUrlVO.setName("compGroupMap");
			webUrlVO.setWebUrl(uuhfWebNetDomain1 + "/B/Home/ErpPersonManager/compGroupMap");
			webUrlList.add(webUrlVO);
		}
		WebUrlVO webUrlVO7 = new WebUrlVO();
		// 潜在业绩
		webUrlVO7.setName("potentialAchievement");
		webUrlVO7.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/potentialAchievement");
		webUrlList.add(webUrlVO7);

		WebUrlVO webUrlVO8 = new WebUrlVO();
		// 街道维护
		webUrlVO8.setName("streetManage");
		webUrlVO8.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/streetManage");
		webUrlList.add(webUrlVO8);

		WebUrlVO webUrlVO9 = new WebUrlVO();
		// 预约摄影师管理
		webUrlVO9.setName("orderPhotographer");
		webUrlVO9.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/orderPhotographer");
		webUrlList.add(webUrlVO9);

		//美联2.2 - 预约摄影师订单管理
		WebUrlVO webUrlVO10 = new WebUrlVO();
		webUrlVO10.setName("photographerOrderManage");
		webUrlVO10.setWebUrl(uuhfWebNetDomain + "B/Home/ZtMeilian/orderManagement");
		webUrlList.add(webUrlVO10);
		//美联2.2 - 预约申请单(经纪人)
		WebUrlVO webUrlVO11 = new WebUrlVO();
		webUrlVO11.setName("appointmentApplyList");
		webUrlVO11.setWebUrl(uuhfWebNetDomain + "B/Home/ZtMeilian/orderRequisition");
		webUrlList.add(webUrlVO11);
		//美联2.2 - 预约订单(摄影师)
		WebUrlVO webUrlVO12 = new WebUrlVO();
		webUrlVO12.setName("appointmentOrderList");
		webUrlVO12.setWebUrl(uuhfWebNetDomain + "B/Home/ZtMeilian/reverseOrder");
		webUrlList.add(webUrlVO12);
		//美联2.2 - 摄影师管理
		WebUrlVO webUrlVO13 = new WebUrlVO();
		webUrlVO13.setName("photographerManage");
		webUrlVO13.setWebUrl(uuhfWebNetDomain + "B/Home/ZtMeilian/photoRrapherAdmin");
		webUrlList.add(webUrlVO13);
			//detail [2020-04-11] yz 美联2.3 - 美联kpi路由
		WebUrlVO webUrlVO14 = new WebUrlVO();
		webUrlVO14.setName("kpiStatistic"); // 美联2.3 - 美联Erp 内嵌 Kpi 统计页面
		webUrlVO14.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/kpiStatistics");
		webUrlList.add(webUrlVO14);

		WebUrlVO webUrlV15 = new WebUrlVO();
		webUrlV15.setName("kpiConfig"); // 美联2.3 - 美联Erp 内嵌 Kpi 配置页面
		webUrlV15.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/kpiConfig");
		webUrlList.add(webUrlV15);

		WebUrlVO webUrlV16 = new WebUrlVO();
		webUrlV16.setName("treadAuditDetail"); // 美联2.3 - 踩盘详情网页地址
		webUrlV16.setWebUrl(uuhfWebNetDomain + "/B/Home/ZtMeilian/firstTreadAuditDetail");
		webUrlList.add(webUrlV16);

		WebUrlVO webUrlVO17 = new WebUrlVO();
		webUrlVO17.setName("ruleDescription"); //需求ID：12352 5.15上线-美联工作台增加规则说明页面  lxt  URL是美联那边给过来的
		webUrlVO17.setWebUrl("https://imgs.m1200.com.cn/project/kpi-static/web/kpi.html");
		webUrlList.add(webUrlVO17);
		returnVO.setWebUrlList(webUrlList);
		
		//此用户的可跨城公司列表
		ErpFunCrossCompStatusExample crossCompStatusExample = new ErpFunCrossCompStatusExample();
		crossCompStatusExample.createCriteria().andOpenFlagEqualTo((byte)1).andUserIdEqualTo(operator.getUserId());
		crossCompStatusExample.setShardCityId(cityId);
		List<ErpFunCrossCompStatus> crossCompStatusList = erpFunCrossCompStatusMapper.selectByExample(crossCompStatusExample);
		if (crossCompStatusList.size() > 0) {
			List<CrossCompListVO> crossCompList = new ArrayList<CrossCompListVO>();
			for (ErpFunCrossCompStatus erpFunCrossCompStatus : crossCompStatusList) {
				//获取compName
				ErpFunComp erpFunComps = erpFunCompMapper.selectByCompId(cityId, erpFunCrossCompStatus.getCompId());
				CrossCompListVO vo = new CrossCompListVO();
				vo.setCompId(erpFunCrossCompStatus.getCompId());
				vo.setCompName(erpFunComps.getCompName());
				//获取cityName
				ErpFunCity erpFunCityId = new ErpFunCity();
				erpFunCityId.setCityId(erpFunCrossCompStatus.getCityId().shortValue());
				erpFunCityId.setShardCityId(cityId);
				ErpFunCity erpFunCity = erpFunCityMapper.selectByPrimaryKey(erpFunCityId);
				vo.setCityId(erpFunCrossCompStatus.getCityId());
				vo.setCityName(erpFunCity.getCityName());
				crossCompList.add(vo);
			}
			returnVO.setCrossCompList(crossCompList);
		}
		
		return ErpResponseJson.ok(returnVO);
	}

	private List<ErpFunDeptsBaseInfoVO> getCircleDeptIdsByCompNos(Integer cityId, String compNos, Boolean keWeiModel) {
		if(!keWeiModel ){
			return null;
		}

		if (CommonUtil.isnull(compNos)) {
			return null;
		}
		String[] compNoArr = compNos.split(",");
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setOrderByClause(" SEQ_NO ASC ");
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompNoIn(Arrays.asList(compNoArr)).andDeptFlagGreaterThanOrEqualTo(1);
		List<ErpFunDepts> resList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		List<ErpFunDeptsBaseInfoVO> returnList = new ArrayList<>(resList.size());
		for (ErpFunDepts erpFunDepts : resList) {
			ErpFunDeptsBaseInfoVO erpFunDeptsBaseInfoVO = new ErpFunDeptsBaseInfoVO();
			erpFunDeptsBaseInfoVO.setCompNo(erpFunDepts.getCompNo());
			erpFunDeptsBaseInfoVO.setDeptId(erpFunDepts.getDeptId());
			erpFunDeptsBaseInfoVO.setDeptName(erpFunDepts.getDeptName());
			returnList.add(erpFunDeptsBaseInfoVO);
		}
		return returnList;

	}

	/**
	 * @Desc 返回全公司人员
	 * @Time 2019/11/25
	 * @Author lcb
	 **/
	private List<ErpFunUsers> getUserListUpdate(Integer cityId, Integer compId, String updateTime) {
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = erpFunUsersExample.createCriteria().andCompIdEqualTo(compId);
		if (StringUtils.isNotBlank(updateTime)){
			criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
		}
		int count = erpFunUsersMapper.countByExample(erpFunUsersExample);
		if (count <= 0){
			return  null;
		}

		// 登录返回员工
		List<ErpFunUsers> recordsByCompIdAndUserWriteOff = erpFunUsersMapper.getRecordsByCompIdAndUserNotWriteOff(cityId, compId, 0);

		return recordsByCompIdAndUserWriteOff;
	}

	private List<ErpFunDepts> getDeptListUpdate(Integer cityId, Integer compId, String updateTime) {
		ErpFunDeptsExample deptsExample = new ErpFunDeptsExample();
		deptsExample.setShardCityId(cityId);
		ErpFunDeptsExample.Criteria criteria = deptsExample.createCriteria().andCompIdEqualTo(compId);
		if (StringUtils.isNotBlank(updateTime)){
			criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
		}
		int count = erpFunDeptsMapper.countByExample(deptsExample);
		if (count <= 0){
			return  null;
		}
		return erpFunDeptsMapper.getCacheableDeptListByCompId(cityId, compId);
	}

	private List<ErpFunDeptsGroupBaseInfoVO> getGroupListUpdate(Integer cityId, Integer compId, String updateTime) {
		ErpFunDeptsgroupExample erpFunDeptsgroupExample = new ErpFunDeptsgroupExample();
		erpFunDeptsgroupExample.setShardCityId(cityId);
		ErpFunDeptsgroupExample.Criteria criteria = erpFunDeptsgroupExample.createCriteria().andCompIdEqualTo(compId);
		if (StringUtils.isNotBlank(updateTime)){
			criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
		}
		int count = erpFunDeptsgroupMapper.countByExample(erpFunDeptsgroupExample);
		if (count <= 0){
			return  null;
		}
		return erpFunDeptsgroupMapper.getGroupBaseInfoList(cityId, compId);
	}

	public List<ErpFunHeadVo> getHeadList(Integer cityId, Integer compId, Integer userId, Byte headShow, Byte caseType, String updateTime) {

//		if(StringUtils.isNotBlank(updateTime)) {
//			ErpFunHeadExample erpFunHeadExample = new ErpFunHeadExample();
//			erpFunHeadExample.setShardCityId(cityId);
//			ErpFunHeadExample.Criteria criteria = erpFunHeadExample.createCriteria();
//			criteria.andHeadUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateTime)).andCompIdEqualTo(compId);
//
//			if(null != headShow) {
//				criteria.andHeadShowEqualTo(headShow);
//			}
//
//			if(null != caseType) {
//				criteria.andCaseTypeEqualTo(caseType);
//			}
//			int updateCount = erpFunHeadMapper.countByExample(erpFunHeadExample);
//
//
//			if(updateCount < 1){
//				Integer headCompId = 1;// 默认栋座单元房号,号室也包含了
////				String coreInfoType = erpSysParaMapper.getParamValue(cityId, compId,"CORE_INFO_TYPE");
//				String coreInfoType = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"CORE_INFO_TYPE");
//				if("2".equals(coreInfoType)) {
//					headCompId = 2;
//				}
//				erpFunHeadExample = new ErpFunHeadExample();
//				erpFunHeadExample.setShardCityId(cityId);
//				erpFunHeadExample.createCriteria().andCompIdEqualTo(headCompId).andHeadUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateTime));
//				// 查询模板
//				updateCount = erpFunHeadMapper.countByExample(erpFunHeadExample);
//				if(updateCount < 1) {
//					return null;
//				}
//			}
//		}

		List<ErpFunHeadVo> list = erpFunHeadMapper.getHeadVoListByCompId(cityId, compId, headShow, caseType);

		if(CollectionUtils.isEmpty(list)){
			Integer headCompId = 1;// 默认栋座单元房号,号室也包含了
			String coreInfoType = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"CORE_INFO_TYPE");
			if("2".equals(coreInfoType)) {
				headCompId = 2;
			}
			list = erpFunHeadMapper.getHeadVoListByCompId(cityId, headCompId, null, null);
		}

		// 新版的核心参数, 在 userLogin 接口去过滤这几项
//		String isShowHouseRoof = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"IS_SHOW_HOUSE_ROOF");
//		String isShowHouseUnit = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"IS_SHOW_HOUSE_UNIT");
//		String isShowHouseNum = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId,"IS_SHOW_HOUSE_NUM");
//
//		Iterator<ErpFunHeadVo> iterator = list.iterator();
//
//		while (iterator.hasNext()) {
//			ErpFunHeadVo next = iterator.next();
//			if("0".equals(isShowHouseRoof) && "SALE_ROOF_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			} else if ("0".equals(isShowHouseUnit) && "SALE_UNIT_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			} else if ("0".equals(isShowHouseNum) && "SALE_NUM_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			}
//
//			if("0".equals(isShowHouseRoof) && "LEASE_ROOF_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			} else if ("0".equals(isShowHouseUnit) && "LEASE_UNIT_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			} else if ("0".equals(isShowHouseNum) && "LEASE_NUM_T".equals(next.getHeadValue())) {
//				iterator.remove();
//			}
//		}
	return list;

	}
	
	protected String getStringAndCheck(String key) {
		String value=null;
		if(getOperator().getRequestParamMap()!=null){
			String[] values=getOperator().getRequestParamMap().get(key);
			if(values!=null&&values.length>0){
				value= values[0];
			}
		}
		if(value==null){
			Map<String, String> map = getOperator().getParamMap();
			value= map.get(key);
		}
		if(value==null){
			value="";
		}
		return value;
	}
	
	public Map<String, String> getMapByCompNos(Set<String> compNos) throws Exception {
		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(getOperator().getCityId());
		erpFunCompExample.createCriteria().andCompNoIn(new ArrayList<>(compNos));
		List<ErpFunComp> list = erpFunCompMapper.selectByExample(erpFunCompExample);
		Map<String, String> idNoMap = new HashMap<>();
		if (list != null && list.size() > 0) {
			for (ErpFunComp funCompPO : list) {
				idNoMap.put(funCompPO.getCompNo().toUpperCase(), funCompPO.getCompId().toString());
			}
		}
		return idNoMap;
	}
	
	/**
	 * 公司所有加盟公司
	 * @author HeWei
	 * @since 2018年7月25日 下午3:52:17
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月25日
	 */
	public List<JoinCompListNewVO> getJoinCompListNew(Integer cityId, String compNo) throws Exception {

		String mainCompNo = (String) getOperator().getAttribute("MAIN_COMP_NO");
		if (StringUtils.isNotBlank(mainCompNo)) {
			compNo = mainCompNo;
		}

		List<JoinCompListNewVO> dataObjects = adminFunCompMapper.getJoinCompListNew(compNo);
		List<String> compNoSet = new ArrayList<>();
		if(dataObjects.size() > 0) {
			compNoSet = dataObjects.stream().collect(Collectors.mapping(val->val.getCompNo(), Collectors.toList()));
		}

		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoIn(compNoSet);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Map<String, Integer> compNoIdMap = erpFunComps.stream().collect(Collectors.toMap(val -> val.getCompNo(), val -> val.getCompId()));

		for (JoinCompListNewVO joinCompListVO : dataObjects) {
			Integer compId = compNoIdMap.get(joinCompListVO.getCompNo());
			joinCompListVO.setCompId(compId);
		}

		return dataObjects;
	}
	
	/**
	 * 公司下所有加盟圈
	 * @author HeWei
	 * @since 2018年7月25日 下午4:28:10
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月25日
	 */
	public List<JoinCircleListVO> getShareCompList(Integer cityId, String compNo) throws Exception {

		String mainCompNo = (String) getOperator().getAttribute("MAIN_COMP_NO");
		if (StringUtils.isNotBlank(mainCompNo)) {
			compNo = mainCompNo;
		}

		AdminFunShareCompExample adminFunShareCompExample = new AdminFunShareCompExample();
		adminFunShareCompExample.createCriteria().andCompNoEqualTo(compNo).andFlagEqualTo(1);

		List<JoinCircleListVO> dataObjects = adminFunShareCompMapper.getShareCompList(compNo);
        List<String> compNoSet = new ArrayList<>();
        if(dataObjects.size() > 0) {
            compNoSet = dataObjects.stream().collect(Collectors.mapping(val->val.getCompNo(), Collectors.toList()));
        }

        ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
        erpFunCompExample.setShardCityId(cityId);
        erpFunCompExample.createCriteria().andCompNoIn(compNoSet);
        List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
        Map<String, Integer> compNoIdMap = erpFunComps.stream().collect(Collectors.toMap(val -> val.getCompNo(), val -> val.getCompId()));

        for (JoinCircleListVO joinCircleListVO : dataObjects) {
            Integer compId = compNoIdMap.get(joinCircleListVO.getCompNo());
            joinCircleListVO.setCompId(compId);
        }

        return dataObjects;
	}
	

	public List<JoinCompListNewVO> getJoinCompList(Integer cityId) throws Exception {

		List<JoinCompListNewVO> joinCompListVOList = adminFunCompMapper.getJoinCompList(getOperator().getCompNo());

		List<String> compNos = joinCompListVOList.stream().collect(Collectors.mapping(val->val.getCompNo(), Collectors.toList()));

		if(compNos.size() == 0) {
			return null;
		}

		// 注意：这里设置的是erp库的公司ID
		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoIn(compNos);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Map<String, Integer> compNoIdMap = erpFunComps.stream().collect(Collectors.toMap(val -> val.getCompNo(), val -> val.getCompId()));

		for (JoinCompListNewVO compListVO : joinCompListVOList) {
			Integer compId = compNoIdMap.get(compListVO.getCompNo());
			compListVO.setCompId(compId);
		}


		return joinCompListVOList;
	}
	
	/**
	 * 查询加盟公司之间的共享圈公司信息。
	 * 注意：共享圈并不一定有，加盟公司中可以不设置共享圈信息
	 * @author HeWei
	 * @since 2018年7月25日 下午5:40:59
	 * @return
	 * @throws Exception
	 * Modified XXX HeWei 2018年7月25日
	 */
	public List<JoinCompListNewVO> getJoinCompsByShareId(Integer cityId, String compNo, Integer shareId) throws Exception {
		if (null == shareId) {
			AdminFunShareRelevanceExample adminFunShareRelevanceExample = new AdminFunShareRelevanceExample();
			adminFunShareRelevanceExample.createCriteria().andShareCompNoEqualTo(compNo);
			List<AdminFunShareRelevance> selectByExample = adminFunShareRelevanceMapper.selectByExample(adminFunShareRelevanceExample);
			if (selectByExample.size()>0) {
				AdminFunShareRelevance funShareRelevancePO = selectByExample.get(0);
				shareId = funShareRelevancePO.getShareId();
			}else{
				return null;
			}
		}
		List<JoinCompListNewVO> joinComps = adminFunCompMapper.getJoinCompsByShareId(shareId, compNo);
		if(joinComps.size() == 0) {
			return null;
		}
		List<String> compNoSet = new ArrayList<>();
		if(joinComps.size() > 0) {
			compNoSet = joinComps.stream().collect(Collectors.mapping(val->val.getCompNo(), Collectors.toList()));
		}

		ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
		erpFunCompExample.setShardCityId(cityId);
		erpFunCompExample.createCriteria().andCompNoIn(compNoSet);
		List<ErpFunComp> erpFunComps = erpFunCompMapper.selectByExample(erpFunCompExample);
		Map<String, Integer> compNoIdMap = erpFunComps.stream().collect(Collectors.toMap(val -> val.getCompNo(), val -> val.getCompId()));

		for (JoinCompListNewVO joinCircleListVO : joinComps) {
			Integer compId = compNoIdMap.get(joinCircleListVO.getCompNo());
			joinCircleListVO.setCompId(compId);
		}
		return joinComps;
	}

	// 查询大区精简信息
	public List<ErpFunAreaBaseInfoVO> getAreaBaseInfoList(Integer areaId, String updateTime) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		//先判断是否有修改，否则不返回
		ErpFunAreaExample erpFunAreaExample = new ErpFunAreaExample();
		erpFunAreaExample.setShardCityId(cityId);
		ErpFunAreaExample.Criteria criteria = erpFunAreaExample.createCriteria().andCompIdEqualTo(compId);
		if (StringUtils.isNotBlank(updateTime)){
			criteria.andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateTime));
		}
		int count = erpFunAreaMapper.countByExample(erpFunAreaExample);
		if (count <= 0){
			return  null;
		}

		List<ErpFunArea> tempList = erpFunAreaMapper.getAllAreaCount(cityId, compId);
		
		List<ErpFunAreaBaseInfoVO> list=new ArrayList<>(tempList.size());

		for(ErpFunArea temp:tempList){
			ErpFunAreaBaseInfoVO vo = new ErpFunAreaBaseInfoVO();
			vo.setAreaId(temp.getAreaId());
			vo.setAreaName(temp.getAreaName());
			//将自己所在的大区置顶
			if(temp.getAreaId().equals(areaId)){
				list.add(0, vo);
			}else {
				list.add(vo);
			}
		}
		return list;
	}
	
	public List<ErpFunRegBaseInfoVO> getRegionBaseInfoList(Integer cityId, Integer compId, Integer areaId, String updateTime, Integer selfRegId) {
		List<ErpFunRegion> tempList = null;
		//先判断是否有修改，否则不返回
		ErpFunRegionExample funRegionExample = new ErpFunRegionExample();
		funRegionExample.setShardCityId(cityId);
		ErpFunRegionExample.Criteria criteria = funRegionExample.createCriteria().andCompIdEqualTo(compId);
		if (StringUtils.isNotBlank(updateTime)){
			criteria.andUpdateTimeGreaterThanOrEqualTo(updateTime);
		}
		int count = erpFunRegionMapper.countByExample(funRegionExample);
		if (count <= 0){
			return  null;
		}

		if (null == areaId) {
			tempList = erpFunRegionMapper.getAllRegCount(cityId, compId);
		} else {
			tempList = erpFunRegionMapper.getRegListByAreaId(cityId, getOperator().getCompId(), areaId);
		}
		List<ErpFunRegBaseInfoVO> list = new ArrayList<>(tempList.size());
		for (ErpFunRegion temp : tempList) {

			ErpFunRegBaseInfoVO vo = new ErpFunRegBaseInfoVO();
			vo.setRegId(temp.getRegId());
			vo.setRegName(temp.getRegName());
			vo.setAreaId(temp.getAreaId());
			if (temp.getRegId().equals(selfRegId)) {
				list.add(0, vo);
			} else {
				list.add(vo);
			}
		}
		return list;
	}
	
	public List<ErpFunArea> getDelAreaUpdateList(Integer delCompId,String updateDelcompinfoTime) throws Exception{
		if(CommonUtil.isnull(delCompId)){
			delCompId = getOperator().getCompId();
		}
		if(!CommonUtil.isnull(updateDelcompinfoTime)){
			ErpFunAreaExample funAreaExample = new ErpFunAreaExample();
			funAreaExample.setShardCityId(getOperator().getCityId());
			funAreaExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(updateDelcompinfoTime));
			int count = erpFunAreaMapper.countByExample(funAreaExample);
			if(count <= 0) {
				return null;
			}
		}
		ErpFunAreaExample erpFunAreaExample = new ErpFunAreaExample();
		erpFunAreaExample.setShardCityId(getOperator().getCityId());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		erpFunAreaExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeBetween(cal.getTime(), new Date()).andIsDelEqualTo((byte)1);
		return erpFunAreaMapper.selectByExample(erpFunAreaExample);
	}
	
	public List<ErpFunRegion> getDelRegionUpdateList(Integer delCompId,String updateDelcompinfoTime) throws Exception{
		if(CommonUtil.isnull(delCompId)){
			delCompId = getOperator().getCompId();
		}
		if(!CommonUtil.isnull(updateDelcompinfoTime)){
			ErpFunRegionExample erpFunRegionExample = new ErpFunRegionExample();
			erpFunRegionExample.setShardCityId(getOperator().getCityId());
			erpFunRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeGreaterThanOrEqualTo(updateDelcompinfoTime);
			int count = erpFunRegionMapper.countByExample(erpFunRegionExample);
			if(count <= 0) {
				return null;
			}
		}
		ErpFunRegionExample funRegionExample = new ErpFunRegionExample();
		funRegionExample.setShardCityId(getOperator().getCityId());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		String startTime = DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd 00:00:00");
		String endTime = DateTimeHelper.formatDateTimetoString(new Date());
		funRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeBetween(startTime, endTime).andIsDelEqualTo((byte)1);
		
		return erpFunRegionMapper.selectByExample(funRegionExample);
	}
	
	public List<ErpFunDepts> getDelDeptUpdateList(Integer delCompId,String updateDelcompinfoTime) throws Exception {
		if(CommonUtil.isnull(delCompId)){
			delCompId = getOperator().getCompId();
		}
		if(!CommonUtil.isnull(updateDelcompinfoTime)){
			ErpFunDeptsExample erpFunRegionExample = new ErpFunDeptsExample();
			erpFunRegionExample.setShardCityId(getOperator().getCityId());
			erpFunRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeGreaterThanOrEqualTo(updateDelcompinfoTime);
			int count = erpFunDeptsMapper.countByExample(erpFunRegionExample);
			if(count <= 0) {
				return null;
			}
		}
		ErpFunDeptsExample funRegionExample = new ErpFunDeptsExample();
		funRegionExample.setShardCityId(getOperator().getCityId());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		String startTime = DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd 00:00:00");
		String endTime = DateTimeHelper.formatDateTimetoString(new Date());
		funRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeBetween(startTime, endTime).andDeptFlagEqualTo(0);
		return erpFunDeptsMapper.selectByExample(funRegionExample);
	}
	
	public List<ErpFunDeptsgroup> getDelGroupUpdateList(Integer delCompId,String updateDelcompinfoTime) throws Exception{
		if(CommonUtil.isnull(delCompId)){
			delCompId = getOperator().getCompId();
		}
		if(!CommonUtil.isnull(updateDelcompinfoTime)){
			ErpFunDeptsgroupExample erpFunRegionExample = new ErpFunDeptsgroupExample();
			erpFunRegionExample.setShardCityId(getOperator().getCityId());
			erpFunRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeGreaterThanOrEqualTo(updateDelcompinfoTime);
			int count = erpFunDeptsgroupMapper.countByExample(erpFunRegionExample);
			if(count <= 0) {
				return null;
			}
		}
		ErpFunDeptsgroupExample funRegionExample = new ErpFunDeptsgroupExample();
		funRegionExample.setShardCityId(getOperator().getCityId());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6);
		String startTime = DateTimeHelper.formatDateTimetoString(cal.getTime(), "yyyy-MM-dd 00:00:00");
		String endTime = DateTimeHelper.formatDateTimetoString(new Date());
		funRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUpdateTimeBetween(startTime, endTime).andIsDelEqualTo((byte)1);
		return erpFunDeptsgroupMapper.selectByExample(funRegionExample);
	}
	
	public List<ErpFunUsers> getDelUserUpdateList(Integer delCompId,String updateDelcompinfoTime)throws Exception{
		if(CommonUtil.isnull(delCompId)){
			delCompId = getOperator().getCompId();
		}
		if(!CommonUtil.isnull(updateDelcompinfoTime)){
			ErpFunUsersExample erpFunRegionExample = new ErpFunUsersExample();
			erpFunRegionExample.setShardCityId(getOperator().getCityId());
			erpFunRegionExample.createCriteria().andCompIdEqualTo(delCompId).andWriteoffTimeGreaterThanOrEqualTo(updateDelcompinfoTime).andUserWriteoffEqualTo(true);
			int count = erpFunUsersMapper.countByExample(erpFunRegionExample);
			if(count <= 0) {
				return null;
			}
		}
		ErpFunUsersExample funRegionExample = new ErpFunUsersExample();
		funRegionExample.setShardCityId(getOperator().getCityId());
		funRegionExample.setOrderByClause(" WRITEOFF_TIME DESC");
		funRegionExample.createCriteria().andCompIdEqualTo(delCompId).andUserWriteoffEqualTo(true);
		return erpFunUsersMapper.selectByExample(funRegionExample);
	}
	
	@RequestMapping("/getSelfManageRange")
	@ApiOperation("获取自己的管理层级列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = FunUserManageRangeDto.class, message = "成功")
	})
	public ResponseJson getSelfManageRange(@RequestBody BaseMapParam param) throws Exception{
		Operator operator = getOperator();
		if (operator.newOrganizationType()) {
			return getSelfManageRangeForOrg(param);
		}
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Integer compId = operator.getCompId();
		String selfUserName = operator.getUserName();
		List<FunUserManageRangeVo> resultList = new ArrayList<>();
		List<ErpFunUserManageRange> userManageRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		if(null == userManageRangeList || userManageRangeList.isEmpty()){
			FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
			funUserManageRangeVo.setRangeId(userId);
			funUserManageRangeVo.setRangeType(6);
			funUserManageRangeVo.setRangeName(selfUserName);
			resultList.add(funUserManageRangeVo);
		} else {
			for(ErpFunUserManageRange result: userManageRangeList){
				Integer rangeId = result.getRangeId();
				Integer rangeType = result.getRangeType();
				FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
				resultList.add(funUserManageRangeVo);
				String rangeName = "";
				funUserManageRangeVo.setRangeType(rangeType);
				funUserManageRangeVo.setRangeId(rangeId);
				if(null == rangeType || null == rangeId){
					continue;
				}
				if(1 == rangeType){
					ErpFunComp erpFunComp = new ErpFunComp();
					erpFunComp.setCompId(compId);
					erpFunComp.setShardCityId(cityId);
					erpFunComp = erpFunCompMapper.selectByPrimaryKey(erpFunComp);
					rangeName = erpFunComp.getCompName();
				} else if(2 == rangeType){
					ErpFunArea erpFunArea = erpFunAreaMapper.getAreaByAreaId(cityId, compId, rangeId);
					if (erpFunArea!=null){
						rangeName = erpFunArea.getAreaName();
					}
				} else if(3 == rangeType){
					ErpFunRegion erpFunRegion = erpFunRegionMapper.getDataById(cityId, rangeId);
					if (erpFunRegion!=null){
						rangeName = erpFunRegion.getRegName();
					}
				} else if(4 == rangeType){
					ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, rangeId);
					if (erpFunDepts!=null){
						rangeName = erpFunDepts.getDeptName();
					}
				} else if(5 == rangeType){
					ErpFunDeptsgroup erpFunDeptsgroup = erpFunDeptsgroupMapper.getDataByGrId(cityId, rangeId);
					if (erpFunDeptsgroup!=null){
						rangeName = erpFunDeptsgroup.getGrName();
					}
				} else if(6 == rangeType){
					ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, rangeId);
					if (erpFunUsers!=null){
						rangeName = erpFunUsers.getUserName();
					}
				}
				funUserManageRangeVo.setRangeName(rangeName);
			}
		}
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultList", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	public ResponseJson getSelfManageRangeForOrg(BaseMapParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Integer compId = operator.getCompId();
		String selfUserName = operator.getUserName();
		List<FunUserManageRangeVo> resultList = new ArrayList<>();
		List<ErpFunUserManageRange> userManageRangeList = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		if((null == userManageRangeList || userManageRangeList.isEmpty())){
			FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
			funUserManageRangeVo.setDefId(-2);//个人用-2
			funUserManageRangeVo.setOrganizationId(userId);
			funUserManageRangeVo.setDefinitionLevel(100);//同前端
			funUserManageRangeVo.setDefinitionName(operator.getUserName());
			resultList.add(funUserManageRangeVo);
		} else {
			Set<Integer> set = userManageRangeList.stream().map(ErpFunUserManageRange::getRangeId).collect(Collectors.toSet());
			if (!set.isEmpty()) {
				if (set.contains(0)) {
					//范围为全公司
					FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
					funUserManageRangeVo.setDefId(0);
					funUserManageRangeVo.setOrganizationId(compId);
					funUserManageRangeVo.setDefinitionLevel(0);//同前端
					funUserManageRangeVo.setDefinitionName(operator.getCompName());
					resultList.add(funUserManageRangeVo);
				}
				List<ErpOrganizationVO> orgList = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, set);
				if (orgList.isEmpty() && resultList.isEmpty()) {//个人
					FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
					funUserManageRangeVo.setDefId(-2);//个人用-2
					funUserManageRangeVo.setOrganizationId(userId);
					funUserManageRangeVo.setDefinitionLevel(100);//同前端
					funUserManageRangeVo.setDefinitionName(operator.getUserName());
					resultList.add(funUserManageRangeVo);
				}
				for (ErpOrganizationVO obj : orgList) {
					Integer orgId = obj.getOrganizationId();
					Integer defId = obj.getOrganizationDefinitionId();
					FunUserManageRangeVo funUserManageRangeVo = new FunUserManageRangeVo();
					funUserManageRangeVo.setDefinitionName(obj.getDefinitionName());
					funUserManageRangeVo.setDefId(defId);
					funUserManageRangeVo.setOrganizationId(orgId);
					funUserManageRangeVo.setDefinitionLevel(obj.getDefinitionLevel());
					funUserManageRangeVo.setDefinitionName(obj.getDefinitionName());
					resultList.add(funUserManageRangeVo);
				}
			}
		}
		//层级排序
		resultList = resultList.stream().sorted(Comparator.comparing(FunUserManageRangeVo::getDefinitionLevel)).collect(Collectors.toList());;
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultList", resultList);
		return ErpResponseJson.ok(resultMap);
	}

	/**
	 * 获取楼盘估价
	 * 对应老版接口：getBuildAssess，方法：BuildModule.getBuildAssess()
	 * @author 朱科
	 * @since 2018年9月14日
	 * @return
	 */
	@ApiOperation(value = "获取楼盘估价")
	@ApiResponses(value = {@ApiResponse(code = 1, message = "")})
	@PostMapping("/getBuildAssess")
	public ResponseJson getBuildAssess(@RequestBody HouseIdTypeParam houseIdTypeParam) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("cityId", getOperator().getCityId().toString());
		param.put("buildId", houseIdTypeParam.getBuildId());
		param.put("area", houseIdTypeParam.getArea());
		param.put("floor", houseIdTypeParam.getFloor());
		param.put("totalfloor", houseIdTypeParam.getTotalFloor());
		param.put("toward", houseIdTypeParam.getToward());
		param.put("roomType", houseIdTypeParam.getRoomType());
		param.put("hall", houseIdTypeParam.getHall());
		param.put("toilet", houseIdTypeParam.getToilet());
		param.put("houseNumber", houseIdTypeParam.getHouseNumber());
		param.put("renovation", houseIdTypeParam.getRenovation());
		param.put("specialFactors", houseIdTypeParam.getSpecialFactors());
		param.put("totalPrice", houseIdTypeParam.getTotalPrice());
		param.put("caseId", (houseIdTypeParam.getCaseId() != null)?houseIdTypeParam.getCaseId().toString():"");
		param.put("caseType", (houseIdTypeParam.getCaseType() != null)?houseIdTypeParam.getCaseType().toString():"");
		param.put("reSource", "1");
		if(Const.DIC_HOUSE_USEAGE_HOUSING.equals(houseIdTypeParam.getUseage())){
			param.put("houseType", "住宅");
		} else if(Const.DIC_HOUSE_USEAGE_VILLA.equals(houseIdTypeParam.getUseage())){
			param.put("houseType", "别墅");
		} else {
			return ErpResponseJson.ok();
		}
		String uuhfWebRootUrl = AppConfig.getRootUuhfWebDomainPath();
		if(uuhfWebRootUrl != null && uuhfWebRootUrl.endsWith("/")){
			uuhfWebRootUrl = uuhfWebRootUrl.substring(0, uuhfWebRootUrl.length() - 1);
		}
		try {
			String result = HttpUtil.post(uuhfWebRootUrl + "/yunfang/buildingController/inquiryResults", param);
			Map<String, String> parseMap = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
			if (parseMap != null && "200".equals(parseMap.get("code"))) {
				parseMap = JSON.parseObject(parseMap.get("data"), new TypeReference<Map<String, String>>() {});
				if(parseMap != null && !parseMap.isEmpty()) {
					List<Map<String, String>> list = new LinkedList<Map<String, String>>();
					Map<String, String> resultMap = new HashMap<String, String>();
					list.add(resultMap);
					resultMap.put("leasePrice", parseMap.get("rent"));// 出租价格(元)
					resultMap.put("salePrice", parseMap.get("price"));// 出售价格（元/㎡）
					resultMap.put("totalPrice", parseMap.get("totalprice"));// 总价格（万元）
					resultMap.put("dyprice", parseMap.get("dyPrice"));// 抵押单价(单位：元)
					resultMap.put("totalDyprice", parseMap.get("totalDyPrice"));// 抵押总价（单位：万元）
					return ErpResponseJson.ok(list);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取楼盘估价
	 * 对应老版接口：getBuildInfoIpCallLog，方法：AdminIpCallLogServiceImpl.getBuildInfoIpCallLog()
	 * @author 张宏利
	 * @since 2018年9月14日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "楼盘资料语音日志")
	@ApiResponses(value = {@ApiResponse(code = 1, message = "成功", response = BuildInfoIpCallLogVo.class)})
	@PostMapping("/getBuildInfoIpCallLog")
	public ResponseJson getBuildInfoIpCallLog(@RequestBody BuildInfoVoiceNoteLogParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer areaId = param.getAreaId();
		Integer deptId = param.getDeptId();
		Integer regId = param.getRegId();
		Integer grId = param.getGrId();
		List<Integer> deptIds = null;
		List<Integer> userIdList = null;
		ErpFunDepts erpFunDepts = new ErpFunDepts();
		erpFunDepts.setCompId(compId);
		if(StringUtil.isNotBlank(param.getTime1())){
			if(param.getTime1().length() < 11){
				param.setTime1(param.getTime1() + " 00:00:00");
			}
		}
		if(StringUtil.isNotBlank(param.getTime2())){
			if(param.getTime2().length() < 11){
				param.setTime2(param.getTime2() + " 23:59:59");
			}
		}
		if(null != deptId){
		} else if(null != areaId){
			erpFunDepts.setAreaId(areaId);
			List<ErpFunDepts> deptsList = erpFunDeptsMapper.getDeptListByRange(cityId, erpFunDepts);
			deptIds = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toList()));
		} else if(null != regId){
			erpFunDepts.setRegId(regId);
			List<ErpFunDepts> deptsList = erpFunDeptsMapper.getDeptListByRange(cityId, erpFunDepts);
			deptIds = deptsList.stream().collect(Collectors.mapping(ErpFunDepts::getDeptId, Collectors.toList()));
		} else if(null != grId && !Const.DIC_DEFAULT_GROUP_ID.equals(grId)){
			List<ErpFunUsers> usersList = erpFunUsersMapper.getFunUsersByGrId(cityId,compId, grId, null);
			if(null != usersList && !usersList.isEmpty()){
				userIdList = usersList.stream().collect(Collectors.mapping(ErpFunUsers::getUserId, Collectors.toList()));
			}
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<AdminIpCallLog> ipCallLogList = adminIpCallLogMapper.getBuildInfoIpCallLog(cityId, compId, param, deptIds, userIdList);
		for (AdminIpCallLog adminIpCallLog : ipCallLogList) {
			if(null != adminIpCallLog && StringUtil.isNotBlank(adminIpCallLog.getCallRecordUrl())){
				adminIpCallLog.setCallRecordUrl(AppConfig.getVideoDomainUrl() + adminIpCallLog.getCallRecordUrl());
			}
		}
		ErpResponseJson erpResponseJson = new ErpResponseJson();
		erpResponseJson.setData(ipCallLogList);
		erpResponseJson.setTotal(Long.valueOf(ipCallLogList.size()));
		return erpResponseJson;
	}

	@ApiOperation(value = "查询公司定义的模板")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "", response = CompDefineTemplateVo.class)})
	@PostMapping("/getCompDefineTemplateData")
	@AccessReadonlyDb
	public ResponseJson getComCompDefineTempletData(@RequestBody CompDefineTemplateParam param) throws Exception {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setArchiveId(getOperator().getArchiveId());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<AdminFunTemplet> adminFunTemplets = adminFunTempletMapper.selectCompDefineTemplate(param);
		List<TemplateVO> templateVOS = new ArrayList<>(adminFunTemplets.size());
		for (AdminFunTemplet adminFunTemplet : adminFunTemplets) {
			TemplateVO dest = new TemplateVO();
			BeanUtil.copyObject(adminFunTemplet, dest);
			templateVOS.add(dest);
		}
		CompDefineTemplateVo compDefineTemplateVo = new CompDefineTemplateVo();
		compDefineTemplateVo.setTempletList(templateVOS);
		return ErpResponseJson.ok(compDefineTemplateVo);
	}

	@ApiOperation(value = "查询模板")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "", response = CompDefineTemplateVo.class)})
	@PostMapping("/getComTemplateData")
	@AccessReadonlyDb
	public ResponseJson getComTemplateData(@RequestBody CompDefineTemplateParam param) throws Exception {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setArchiveId(getOperator().getArchiveId());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<AdminFunTemplet> adminFunTemplets = adminFunTempletMapper.selectCompTemplate(param);
		List<TemplateVO> templateVOS = new ArrayList<>(adminFunTemplets.size());
		for (AdminFunTemplet adminFunTemplet : adminFunTemplets) {
			TemplateVO dest = new TemplateVO();
			BeanUtil.copyObject(adminFunTemplet, dest);
			templateVOS.add(dest);
		}
		CompDefineTemplateVo compDefineTemplateVo = new CompDefineTemplateVo();
		compDefineTemplateVo.setTempletList(templateVOS);
		return ErpResponseJson.ok(compDefineTemplateVo);
	}

	@ApiOperation(value = "新增或者编辑模板")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = AdminIpCallLog.class)})
	@PostMapping("/addEditComDefineTemplateData")
	public ResponseJson addEditComDefineTemplateData(@RequestBody AddEditCompDefineTemplateParam param) {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        String charact = param.getCharactTemplet();
        if(StringUtils.isNotBlank(charact)){
            charact = charact.replaceAll("(<!--\\[if gte mso [\\d]*\\]><xml>[\\s\\S]+?\\[endif\\]-->)", "");
            charact = charact.replaceAll("(<!--\\[if gte mso [\\d]*\\]>[\\s\\S]+?endif\\]-->)", "");
            charact = charact.replaceAll("(?i)(<script[\\s\\S]*?>[\\s\\S]*?</script>)", "");
            charact = charact.trim();
        }
        param.setCharactTemplet(charact);
        param.setTypesFlag("111111");
        param.setHouseUseage((byte)0);
        param.setUseCount(0);
        param.setCityId(cityId);
        param.setCompId(operator.getCompId());
        param.setUpdatetime(new Date(System.currentTimeMillis()));

        Integer queryType = param.getQueryType();// 0为公司 1为个人
        if(null != queryType && 1 == queryType.intValue()){
            param.setArchiveId(operator.getArchiveId());
        }

        Integer id = param.getId();
        if(null != id){
            adminFunTempletMapper.updateTemplateById(param);
        }else{
            adminFunTempletMapper.insertTemplate(param);
        }
		return ErpResponseJson.ok(param);
	}

    @ApiOperation(value = "删除模板")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功")})
    @PostMapping("/deleteComDefineTemplateData")
    public ResponseJson deleteComDefineTemplateData(@RequestBody DeleteCompDefineTemplateParam param) {
	    adminFunTempletMapper.deleteByPrimaryKey(param.gettId());
        return ErpResponseJson.ok();
    }


	/**
	 * 登录解锁
	 * @since 2018-11-20
	 * @author wangchun
	 * @param param`
	 * @return
	 */
	@ApiOperation(value = "登录解锁")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功", response = UpdateLoginUnlockVo.class)})
    @PostMapping("/updateLoginUnlock")
    public ResponseJson updateLoginUnlock(@RequestBody UpdateLoginUnlockParam param){
		UpdateLoginUnlockVo vo = new UpdateLoginUnlockVo();
		if(param.getLoginPassWord().equals(getOperator().getAttribute("upwd"))){
			vo.setErrCode(0);
		}else {
			vo.setErrMsg("密码错误!");
			vo.setErrCode(-5);
		}
		return ErpResponseJson.ok(vo);
	}
	
	@ApiOperation(value = "获取初始化其他信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "",response = AppInitDataOtherInfoVo.class)})
	@PostMapping("/getAppInitDataOtherInfo")
	public ResponseJson getAppInitDataOtherInfo(@RequestBody AppInitDataOtherInfoParam param) {
		List<AdminLoanRateVo> currLoanRate = this.getLoanRateVoListUpdate(param);
		List<AdminLocalTaxesVo> taxes = this.getLocalTaxesVoListByUpdate(param);
		List<AdminDuesLoanrateVo> loanrate = this.getDuesLoanrateVoListByUpdate(param);
		List<AdminNPicWatermarkVo> watermarkPos = this.getNpicWatermarkVoListByUpdate(param);
		List<AdminFunCity> cityList = adminFunCityMapper.getCityByProviceId(null);
		FafaServiceVo fafaService = new FafaServiceVo();
//		String fafaRoot = AppConfig.getFaFaServiceRoot();// 发发项目的地址
		String fafaCurl = AppConfig.getFaFaTaskServiceRoot();// C++发发任务分发服务器项目的地址
		String fafaWebCurl = AppConfig.getFaFaWebServiceRoot();// C++发发服务器项目的地址
		fafaService.setFafaServiceRoot(AppConfig.getFaFaWebUrl());// 发发URL信息
		fafaService.setFafaTaskServiceRoot(fafaCurl);// C++发发任务分发URL信息
		fafaService.setFafaWebServiceRoot(fafaWebCurl);// C++发发服务器URL信息
		fafaService.setFafaSiteIconPath("sitePic");// 发发URL信息
//		fafaService.setFafaWebkitUrlConfig(fafaRoot + "/config/main.jsp");// 手动发布的路径
		// 参数：PARAM={"CONFIG_TYPE":"SERVICE_URL","SERVICE_NAME":""}
		fafaService.setFafaProxyPubReftimer("3");// 代发服务时的状态更新间隔发送请求的时间。单位：秒。例子：6秒钟请求一次服务器
		List<FafaServiceVo> listS = new ArrayList<>();
		listS.add(fafaService);
		AppInitDataOtherInfoVo resultVo = new AppInitDataOtherInfoVo();
		resultVo.setCurrLoanRate(currLoanRate);
		resultVo.setFafaService(listS);
		resultVo.setLoanrate(loanrate);
		resultVo.setWatermarkPos(watermarkPos);
		resultVo.setTaxes(taxes);
		resultVo.setCityList(cityList);
		return ErpResponseJson.ok(resultVo);
	}

	private List<AdminNPicWatermarkVo> getNpicWatermarkVoListByUpdate(AppInitDataOtherInfoParam param) {
		AdminNPicWatermarkExample adminNPicWatermarkExample = new AdminNPicWatermarkExample();
		if (StringUtils.isNotBlank(param.getUpdateTime())) {
			adminNPicWatermarkExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(param.getUpdateTime());
		}
		int count = adminNPicWatermarkMapper.countByExample(adminNPicWatermarkExample);
		if (count > 0){
			return adminNPicWatermarkMapper.getNpicWatermarkVoList();
		}
		return null;
	}

	private List<AdminDuesLoanrateVo> getDuesLoanrateVoListByUpdate(AppInitDataOtherInfoParam param) {
		List<AdminDuesLoanrateVo> adminLoanRateList = null;
		AdminDuesLoanrateExample adminDuesLoanrateExample = new AdminDuesLoanrateExample();
		if (StringUtils.isNotBlank(param.getUpdateTime())) {
			adminDuesLoanrateExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(param.getUpdateTime()));
		}
		int count = adminDuesLoanrateMapper.countByExample(adminDuesLoanrateExample);
		if (count > 0) {
			adminLoanRateList = adminDuesLoanrateMapper.getDuesLoanrateVoList(param.getUpdateTime());
		}
		return adminLoanRateList;
	}

	private List<AdminLocalTaxesVo> getLocalTaxesVoListByUpdate(AppInitDataOtherInfoParam param) {
		AdminLocalTaxesExample adminLocalTaxesExample = new AdminLocalTaxesExample();
		List<AdminLocalTaxesVo> localTaxesVoList =null;
		if (StringUtils.isNotBlank(param.getUpdateTime())){
			adminLocalTaxesExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(param.getUpdateTime()));
		}
		int count = adminLocalTaxesMapper.countByExample(adminLocalTaxesExample);
		if (count > 0){
			localTaxesVoList = adminLocalTaxesMapper.getLocalTaxesVoList(param.getUpdateTime());
		}
		return  localTaxesVoList;
	}

	private List<AdminLoanRateVo> getLoanRateVoListUpdate(AppInitDataOtherInfoParam param) {
		List<AdminLoanRateVo> adminLoanRateList = new ArrayList<>();
		AdminLoanRateExample  adminLoanRateExample = new AdminLoanRateExample();
		if (StringUtils.isNotBlank(param.getUpdateTime())){
			adminLoanRateExample.createCriteria().andUpdateTimeGreaterThanOrEqualTo(DateUtil.StringToDate(param.getUpdateTime()));
		}
		Integer hasUpdate = adminLoanRateMapper.countByExample(adminLoanRateExample);
		if(hasUpdate > 0) {
			List<AdminLoanRateVo> adminDuesLoanrates = adminLoanRateMapper.getLoanRateVoList();
			if (adminDuesLoanrates.size()>0) {
				AdminLoanRateVo adminLoanRate = adminDuesLoanrates.get(0);
				adminLoanRateList.add(adminLoanRate);
			}
		}
		return adminLoanRateList;
	}
	
	@ApiOperation(value = "经济人获取AXB接口，作者:朱科，需求:9081")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "",response = CreateSecretNoVo.class)})
	@PostMapping("/getPhoneNumber")
	public ResponseJson getPhoneNumber(@RequestBody CreateSecretNoParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		String userRight = operator.getUserRight();
		Integer compUaId = operator.getCompUaId();
		Integer businessType = operator.getBusinessType();
		Integer uaId = operator.getUaId();
		Byte callType = param.getCallType();
		Integer phoneId = param.getPhoneId();
		Integer caseCompId = null;
		Integer caseUserId = null;
		// 判断实名认证
//		if(!"1".equals(userRight)){
//			String alterMsg = adminCompGiftCoinRecordService.getAlterMsg(operator.getCompType(), operator.getCompNo(), operator.getDeptNo());
//			throw new BusinessException("请先实名认证！", Const.ResponseErrorCode.USER_VALIDATE,AlertUtil.realNameAuthenticationAlert("实名认证","进行隐号转接前，请先完善个人信息" + (StringUtil.isNotBlank(alterMsg) ? "，" + alterMsg : alterMsg)));
//		}
//		if(null == param.getFeeFlag() || param.getFeeFlag() != 0){
//			// 判断账户余额
//			BigDecimal compLimitPrice = StringUtil.parseBigDecimal(erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, operator.getUserId(), "VOIP_USE_COMP_MONEY"));
//			/*BigDecimal compLimitPrice = StringUtil.parseBigDecimal(erpSysParaMapper.getParamValue(cityId, compId, "VOIP_USE_COMP_MONEY"));
//*/			AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);
//			// 个人当天可以使用公司额度
//			Date nowDate = new Date();
//			BigDecimal compBalance = new BigDecimal(0.0);
//			if(compAccount.getVoipAvailableDate() != null && DateUtil.DateToString(compAccount.getVoipAvailableDate(), "yyyy-MM-dd").equals(DateUtil.DateToString(nowDate, "yyyy-MM-dd"))){
//				if(compLimitPrice.compareTo(compAccount.getVoipUsedCompHf()) > 0){
//					compBalance = compLimitPrice.subtract(compAccount.getVoipUsedCompHf());
//				}
//			} else {
//				compBalance = compLimitPrice;
//			}
//			BigDecimal useCompBalance = compAccount.getCashMoney().compareTo(compBalance) > 0 ? compBalance : compAccount.getCashMoney();
//			// 金额改为参数控制改这儿就可以了
//			if (useCompBalance.compareTo(BigDecimal.valueOf(0.1)) < 0) {
//				AdminFunUserAccount userAccount = adminFunUserAccountMapper.selectByPrimaryKey(uaId);
//				if(null == userAccount || userAccount.getCashMoney().compareTo(BigDecimal.valueOf(0.1)) < 0){
//					AdminSysPara adminSysPara = adminSysParaMapper.getAdminSysParaById("AXB_PHONE_COST_LIMIT");
//					if(userAccount!=null && userAccount.getCashMoney().compareTo(BigDecimal.valueOf(0)) > 0){
//						throw new BusinessException("隐号转接通话每次" + adminSysPara.getParamValue() + "元，你当前现金余额为" + userAccount.getCashMoney() + "，为了不遗失客户,请立即充值！","-4031");
//					} else {
//						throw new BusinessException("隐号转接通话每次" + adminSysPara.getParamValue() + "元，你当前现金余额为0，为了不遗失客户,请立即充值！","-4031");
//					}
//				}
//			}
//		}
		CreateSecretNoVo createSecretNoVo = new CreateSecretNoVo();
		Integer phoneIndex = param.getPhoneIndex();
		Integer entityId = param.getEntityId();
		String customerMobile = param.getCustomerMobile();
		String userMobile = operator.getUserMobile(); // 
		Integer targetId = param.getTargetId();
		Integer targetType = param.getTargetType();
		Boolean customerMobileFlag = false;
		Byte plateType = null;
		if(StringUtil.isNotBlank(customerMobile) && customerMobile.indexOf("*") < 0){
			customerMobileFlag = true;
		} else {
			if(null != entityId){
				ErpFunBuildRule erpFunBuildRule = new ErpFunBuildRule();
				erpFunBuildRule.setEntityId(entityId);
				erpFunBuildRule.setShardCityId(cityId);
				erpFunBuildRule = erpFunBuildRuleMapper.selectByPrimaryKey(erpFunBuildRule);
				if(null == erpFunBuildRule){
					throw new BusinessException("未找到相应楼盘资料！");
				}
				customerMobile = erpFunBuildRule.getCellPhone();
				if(null != phoneIndex && phoneIndex == 3 || StringUtil.isBlank(customerMobile)){
					customerMobile = erpFunBuildRule.getShareCellPhone();
				}
				callType = 26;
			} else if (null != targetId) {
				if (Const.DIC_CASE_TYPE_SALE_FUN.equals(targetType)) {
					ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, targetId);
					caseCompId = erpFunSale.getCompId();
					customerMobile = erpFunSale.getCellPhone();
					caseUserId = erpFunSale.getUserId();
					callType = 1;
				} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(targetType)) {
					ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, targetId);
					caseCompId = erpFunLease.getCompId();
					caseUserId = erpFunLease.getUserId();
					customerMobile = erpFunLease.getCellPhone();
					callType = 2;
				} else if (Const.DIC_CASE_TYPE_BUY_CUST.equals(targetType)) {
					ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustByCustId(cityId,
							targetId);
					caseCompId = erpFunBuyCustomer.getCompId();
					caseUserId = erpFunBuyCustomer.getUserId();
					callType = 3;
					plateType = erpFunBuyCustomer.getPlateType();
				} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(targetType)) {
					ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getFunRentCustByRentId(cityId,
							targetId);
					caseCompId = erpFunRentCustomer.getCompId();
					caseUserId = erpFunRentCustomer.getUserId();
					callType = 4;
					plateType = erpFunRentCustomer.getPlateType();
				}
				if (!caseCompId.equals(compId) && !userId.equals(caseUserId)) {
					throw new BusinessException("你没有权限拨打");
				}
			}
		}
		String errowName = "业主";
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(targetType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(targetType)){
			errowName = "客户"; 
		}
		if (!customerMobileFlag) {
			if (null != entityId) {
				String[] phones = StringHelper.split(customerMobile, "&&&");
				Integer numberType = 0;
				if(null != phoneIndex && 2 == phoneIndex){
					numberType = 1;
				}
				String[] phoneValues = StringHelper.split(phones[numberType], "|||");
				customerMobile = EnCodeHelper.decode(phoneValues[1]);
				if("座机".equals(phoneValues[0]) && StringUtil.isNotBlank(customerMobile) && customerMobile.length() < 10){
					AdminFunCity funCity = adminFunCityMapper.getDataByCityId(cityId);
					String telCode = funCity.getTelCode();
					customerMobile = telCode + customerMobile;
				}
				customerMobileFlag = true;
			} else {
//				ErpFunPhone phone = erpFunPhoneMapper.selectPhoneByCaseOffSeq(cityId, caseCompId, targetId, targetType.byteValue(), phoneIndex.byteValue());
				ErpFunPhone phone = erpFunPhoneMapper.selectByPrimaryKey(new ErpFunPhone(cityId, phoneId));
				if (phone!=null) {
					customerMobile = EnCodeHelper.decode(phone.getPhone());
					if(Byte.valueOf("2").equals(phone.getPhoneType()) && StringUtil.isNotBlank(customerMobile) && customerMobile.length() < 10){
						AdminFunCity funCity = adminFunCityMapper.getDataByCityId(cityId);
						String telCode = funCity.getTelCode();
						customerMobile = telCode + customerMobile;
					}
					customerMobileFlag = true;
				}
			}
		}
		if(!customerMobileFlag){
			throw new BusinessException(errowName + "号码错误请修改后重试！");
		}
		if (StringUtil.isNotBlank(customerMobile) && customerMobile.equals(userMobile)){
			throw new BusinessException("不可向本机拨打隐号电话！");
		}
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(targetType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(targetType)) {
			if (plateType != null && plateType == Const.DIC_PLATE_TYPE_SHARE.byteValue()) {
				ErpFunComp erpComp = erpFunCompMapper.selectByCompId(cityId, compId);
				// 需要判断每日公客号码拨打次数限制系统参数
				Byte businessApart = erpComp.getBusinessApart();
				List<Integer> orgIds = new ArrayList<>();
				if (Byte.valueOf("1").equals(businessApart)) {
					ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
					orgExample.setShardCityId(cityId);
					orgExample.createCriteria().andCompIdEqualTo(compId).andOrganizationBussinessTypeEqualTo(businessType.byteValue()).andDelFlagEqualTo(Byte.valueOf("0"));
					List<ErpFunOrganization> orgInfo = erpFunOrganizationMapper.selectByExample(orgExample);
					orgIds = orgInfo.stream().collect(Collectors.mapping(ErpFunOrganization::getOrganizationId, Collectors.toList()));
				}
				String paramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(operator.getCityId(),
						operator.getCompId(), operator.getUserId(), "CUST_CALL_LIMIT_EVERY_DAY");
				int callLimit = StringUtil.paseInteger(paramValue, 10);
		
				Date[] dates = DateUtil.getToDayDate();
				AdminIpCallLogExample adminIpCallLogExample = new AdminIpCallLogExample();
				Criteria criteria = adminIpCallLogExample.createCriteria();
				criteria.andCallCompIdEqualTo(compId);
				criteria.andTargetTypeEqualTo(targetType.byteValue());
				criteria.andTargetIdEqualTo(targetId);
				criteria.andCreateTimeBetween(dates[0], dates[1]);
				criteria.andCallLengthGreaterThan(0);
				if (!orgIds.isEmpty()) {
					criteria.andOrganizationIdIn(orgIds);
				}
				int logsCount = adminIpCallLogMapper.countByExample(adminIpCallLogExample);
				if (callLimit <= logsCount) {
					throw new BusinessException("该号码已超出每日拨打限制，今日不可再拨打！");
				}
			}
		}
		// AppConfig.getAdminWebUrl()
//		String payUrl = AppConfig.getAdminWebUrl() +"/axbIpCallRecords/createSecretNo";
		String payUrl = AppConfig.getPushWebDomain() + "systemApi/axb/createSecretNo";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userMobile", userMobile);
		paramMap.put("customerMobile", customerMobile);
		paramMap.put("cityId", cityId);
		paramMap.put("targetId", targetId);
		paramMap.put("targetType", targetType);
		paramMap.put("entityId", entityId);
		paramMap.put("callType", callType);
		paramMap.put("useDirection", "2");
		paramMap.put("targetSource", operator.isMobileApi() ? "1" : "2");
		if(null != param.getFeeFlag()){
			// 抢单AXB不透传，不扣费
			paramMap.put("feeFlag", param.getFeeFlag());
			paramMap.put("useDirection", "1");
		}
		// 物业版访客拨打要透传，不扣费
		if (param.getCallType() != null && param.getCallType() == 40) {
			paramMap.put("useDirection", "2");
		}
		
		String payResult = HttpUtil.postJson(payUrl, paramMap);
		if(StringUtils.isNotBlank(payResult)) {
			Map<String, Object> payMap = JSON.parseObject(payResult, new TypeReference<Map<String, Object>>(){});
			String errCode = String.valueOf(payMap.get("errCode"));
			if("200".equals(errCode)) {
				Object data = payMap.get("data");
				if(Map.class.isAssignableFrom(data.getClass())) {
					@SuppressWarnings("unchecked")
					Map<String, Object> dataMap = (Map<String, Object>) data;
					String phoneX = String.valueOf(dataMap.get("phoneX"));
					if(StringUtil.isNotBlank(phoneX)){
						createSecretNoVo.setPhoneX(phoneX);
						createSecretNoVo.setTimeOut(String.valueOf(dataMap.get("timeOut")));
					}
				}
			}
		}
//		if(StringUtil.isBlank(createSecretNoVo.getPhoneX()) || "null".equals(createSecretNoVo.getPhoneX())){
//			throw new BusinessException(errowName + "号码错误请修改后重试！");
//		}
////		判断经纪人电话和客户电视是否都是移动号
//		if(PhoneUtils.isChinaMobilePhoneNum(customerMobile)&&PhoneUtils.isChinaMobilePhoneNum(userMobile)){
//			createSecretNoVo.setWarmTips("检测到您和客户的号码均为移动，因移动运营商限制，可能无法接通！");
//		}
		return ErpResponseJson.ok(createSecretNoVo);
	}

	/***
	  * @title 皮肤冠名接口
	  * @author lcb
	  * @date 2019/2/28 0028
	  *
	  **/
	@ApiOperation(value = "更新公司冠名，皮肤，需求:9476")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")})
	@PostMapping("/updateCompCustomerProperty")
	public ResponseJson updateCustomerProperty(@RequestBody UpdateCompCustomerPropertuParam param) {
		Operator operator = getOperator();
		String customerPropertyList = param.getCustomerPropertyList();
		if(StringUtils.isNotBlank(customerPropertyList)) {
			List<AdminFunCompSkin> compSkinList = JSON.parseArray(customerPropertyList, AdminFunCompSkin.class);
			compSkinList.stream().forEach(val-> {
				val.setAdminCompId(operator.getAdminCompId());
				val.setCompNo(operator.getCompNo());
				val.setClientType(0);
				val.setCreateTime(new Date());
			});

			// 请求crm接口
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("funCompSkinsList", JSON.toJSON(compSkinList));
			String post = HttpUtil.post(AppConfig.getCrmWebUrl()+"crmOpenApi/customerManage/updateErpIconPic", paramMap);
		}

		return ErpResponseJson.ok();
	}

	/***
	 * @title 皮肤冠名接口
	 * @author lcb
	 * @date 2019/2/28 0028
	 *
	 **/
	@ApiOperation(value = "查询定制，皮肤，需求:9476")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = CompCustomerPropertyVo.class)})
	@PostMapping("/getCompCustomerPropertyList")
	public ResponseJson getCompPropertyList(@RequestBody SelectCompCustomerPropertuParam param) {

		Operator operator = getOperator();

		AdminFunCompSkinExample adminFunCompSkinExample = new AdminFunCompSkinExample();
		adminFunCompSkinExample.createCriteria().andCompNoEqualTo(operator.getCompNo()).andClientTypeEqualTo(0);

		List<AdminFunCompSkin> adminFunCompSkins = adminFunCompSkinMapper.selectByExample(adminFunCompSkinExample);
		if(adminFunCompSkins.size() > 0) {
			adminFunCompSkins.stream().forEach(val-> {
				if(null != val.getSkinPicUrlType() && 1== val.getSkinPicUrlType()) {
					val.setSkinPicUrl(AppConfig.getPicDomainUrl()+val.getSkinPicUrl());
				}
			});
		}

		CompCustomerPropertyVo compCustomerPropertyVo = new CompCustomerPropertyVo();
		compCustomerPropertyVo.setPropertyList(adminFunCompSkins);
		return ErpResponseJson.ok(compCustomerPropertyVo);
	}
	public List<SubwayVO> getAllSubway(AppInitDataParam param) {
		return erpFunSubwayMapper.getSubwayVOList(param.getCityId(),param);
	}
	public List<StationVO> getAllStation(AppInitDataParam param) {
		return  erpFunStationMapper.getStationVOList(param.getCityId(),param);
	}

	/**
	 * @Desc 新版查询组织机构， 只有ORGANIZATION_TYPE=1的才有数据
	 * @Time 2019/11/23
	 * @Author lcb
	 **/
	@ApiOperation(value = "新版查询组织机构， 只有ORGANIZATION_TYPE=1的才有数据")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = OrganizationDataListVO.class)})
	@RequestMapping("/getOrganizationDataList")
	public ResponseJson getOrganizationDataList(@RequestBody OrganizationDataListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		if (null != param.getCityId()) {
			cityId = param.getCityId();
		}
		Integer compId = operator.getCompId();
		if (null != param.getCompId()) {
			compId = param.getCompId();
		}
		String updateTime = param.getUpdateTime();
		Integer partnerId = operator.getPartnerId();
		Integer openPartner = operator.openPartner();
		
//		FUN_COMP表，MAIN_COMP=1为主公司、MAIN_COMP=2为子公司
//		OPEN_TRANS_CITY 1=开启 0=关闭 系统参数
//		TRANS_CITY_CONFIG 跨城配置权
		
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		if (null != erpFunComp && Byte.valueOf("1").equals(erpFunComp.getMainComp()) && !operator.isMobileApi()) {// 主公司
			String openTransCity = adminSysParaMapper.selectParamVlue("OPEN_TRANS_CITY");
			if ("1".equals(openTransCity)) {// 开启了跨城
				ErpUserOpers erpUserOper = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, operator.getUserId(), "TRANS_CITY_CONFIG");
				if (null != erpUserOper) {// 存在跨城配置权
					compId = null;// 查询多个公司的组织数据，不使用compId了
				}
			}
		}
		List<OrganizationDefinitionVO> organizationDefinitionList =erpFunOrganizationDefinitionMapper.getOrganizationDefinitionList(cityId, compId);
		List<OrganizationVO> organizationVOList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, updateTime);

		// 这里给IOS做个兼容
		organizationVOList.stream().forEach(val-> {
			Integer definitionLevel = val.getDefinitionLevel();
			if(null == definitionLevel) {
				val.setDefinitionLevel(100);
			}
		});

		List<Integer> organizationIdList = null;
		if(organizationVOList.size() > 0) {
			organizationIdList = organizationVOList.stream().collect(Collectors.mapping(val -> val.getOrganizationId(), Collectors.toList()));
		}

		// 查询组织机构管理员
		List<OrganizationManagerVO> managerList = erpFunOrganizationManagerMapper.getOrganizationManagerList(cityId, compId, organizationIdList);

		OrganizationDataListVO organizationListVo = new OrganizationDataListVO();
		organizationListVo.setOrganizationManagerList(managerList);
		organizationListVo.setOrganizationDefinitionList(organizationDefinitionList);
		organizationListVo.setOrganizationList(organizationVOList);
		// 暂时没处理数据
		return ErpResponseJson.ok(organizationListVo);
	}

	/**
	 * @Desc 新版查询组织机构， 只有ORGANIZATION_TYPE=1的才有数据
	 * @Time 2019/11/23
	 * @Author lcb
	 **/
	@ApiOperation(value = "新版组织机构定义表， 只有ORGANIZATION_TYPE=1的才有数据")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = OrganizationDefinitionListVO.class)})
	@RequestMapping("/getOrganizationDefinitionList")
	public ResponseJson getOrganizationDefinitionList(@RequestBody OrganizationDefinitionListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<OrganizationDefinitionVO> organizationDefinitionList =erpFunOrganizationDefinitionMapper.getOrganizationDefinitionList(cityId, compId);
		OrganizationDefinitionListVO resVO = new OrganizationDefinitionListVO();
		resVO.setOrganizationDefinitionList(organizationDefinitionList);
		return ErpResponseJson.ok(resVO);
	}
	
	/**
	 * @Desc 新版查询组织机构， 只有ORGANIZATION_TYPE=1的才有数据，此接口查询出的层级数据包括已逻辑删除（关闭）的
	 * @Time 2020/1/8
	 * @Author lzg
	 **/
	@ApiOperation(value = "新版组织机构定义表， 只有ORGANIZATION_TYPE=1的才有数据，此接口查询出的层级数据包括已逻辑删除（关闭）的")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = OrganizationDefinitionListVO.class)})
	@RequestMapping("/getAllOrganizationDefinitionList")
	public ResponseJson getAllOrganizationDefinitionList(@RequestBody OrganizationDefinitionListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<OrganizationDefinitionVO> organizationDefinitionList =erpFunOrganizationDefinitionMapper.getAllOrganizationDefinitionList(cityId, compId);
		OrganizationDefinitionListVO resVO = new OrganizationDefinitionListVO();
		resVO.setOrganizationDefinitionList(organizationDefinitionList);
		return ErpResponseJson.ok(resVO);
	}
	
	

	/**
	 * @desc （新版组织机构）添加子部门
	 * @author lzg
	 * @since 2019年11月25日
	 */
	@ApiOperation(value = "（新版组织机构）添加子部门")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AddSubOrganizationVO.class, message = "成功")})
	@PostMapping("/addSubOrganization")
	@NotBlank({"organizationName", "adminUserId"})
	public ErpResponseJson addSubOrganization(@RequestBody @Valid AddSubOrganizationParam param) {
		//部门名称、联系电话、地址、层级（组织机构定义id）、部门主管、
		Operator operator = getOperator();
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		if (param.getCityId()==null) {
			param.setCityId(operator.getCityId());
		}
		if (param.getCompId()==null) {
			param.setCompId(operator.getCompId());
		}
		param.setUserId(operator.getUserId());
		ErpFunComp funComp = erpFunCompMapper.selectByCompId(param.getCityId(), param.getCompId());
		if (funComp!=null) {
			param.setCompType(funComp.getCompType().intValue());
			param.setCompNo(funComp.getCompNo());
		} else {
			param.setCompType(operator.getCompType());
			param.setCompNo(operator.getCompNo());
		}
		String userName = null;
		if (getOperator().isSwitchCompLogin()){ //后续改为isSwitchCompLogin
			userName = getOperator().getUserName()+"("+getOperator().getCompName()+")";  
		}
		Integer newOrganizationId = erpFunOrganizationService.insertOrganizationInfo(param,userName);
		activeMqPublisher.sendMoveOrgMsg(param.getCityId(), param.getCompId(), newOrganizationId, null);
		AddSubOrganizationVO vo = new AddSubOrganizationVO();
		vo.setOrganizationId(newOrganizationId);
		return ErpResponseJson.ok(vo);
	}
	
	/**
	 * @desc （新版组织机构）获取子部门信息
	 * @author lzg
	 * @since 2019年11月26日
	 */
	@ApiOperation(value = "（新版组织机构）获取子部门信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "", response = GetSubOrganizationInfoVO.class)})
	@PostMapping("/getSubOrganizationInfo")
	@NotBlank("organizationId")
	public ErpResponseJson getSubOrganizationInfo(@RequestBody @Valid GetSubOrganizationInfoParam param) {
		Operator operator = getOperator();
		//param.setCityId(operator.getCityId());
		//param.setCompId(operator.getCompId());
		if(param.getOrganizationId() < 1) {
			throw new BusinessException("组织机构id不合法");
		}
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		if (param.getCityId()==null) {
			param.setCityId(operator.getCityId());
		} 
		if (param.getCompId()==null) {
			param.setCompId(operator.getCompId());
		}
		//部门名称、联系电话、地址、层级（组织机构定义id）、部门主管、
		ErpFunOrganizationExample selectOrgExample = new ErpFunOrganizationExample();
		selectOrgExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId()).andDelFlagEqualTo((byte)0);//.andCompIdEqualTo(param.getCompId()).andCityIdEqualTo(param.getCityId())
		selectOrgExample.setShardCityId(param.getCityId());
		List<ErpFunOrganization> organizationData = erpFunOrganizationMapper.selectByExample(selectOrgExample);//部门名称、联系电话、地址、序号
		if(null == organizationData || organizationData.size() < 1) {
			throw new BusinessException("获取子部门信息失败");
		}
		ErpFunOrganizationDefinition selectDef = new ErpFunOrganizationDefinition();
		selectDef.setDefinitionId(organizationData.get(0).getOrganizationDefinitionId());
		selectDef.setShardCityId(param.getCityId());
		ErpFunOrganizationDefinition definitionData = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(selectDef);//层级（组织机构定义id）
		ErpFunOrganizationManagerExample selectMgrExample = new ErpFunOrganizationManagerExample();
		selectMgrExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId());//.andCompIdEqualTo(param.getCompId())
		selectMgrExample.setShardCityId(param.getCityId());
		List<ErpFunOrganizationManager> managerData = erpFunOrganizationManagerMapper.selectByExample(selectMgrExample);//部门主管
		
		GetSubOrganizationInfoVO getSubOrganizationInfoVo = new GetSubOrganizationInfoVO();
		getSubOrganizationInfoVo.setOrganizationName(organizationData.get(0).getOrganizationName());
		getSubOrganizationInfoVo.setPid(organizationData.get(0).getPid());
		getSubOrganizationInfoVo.setOrganizationId(organizationData.get(0).getOrganizationId());
		getSubOrganizationInfoVo.setContactNumber(organizationData.get(0).getContactNumber());
		getSubOrganizationInfoVo.setOrganizationAddr(organizationData.get(0).getOrganizationAddr());
		getSubOrganizationInfoVo.setOrganizationSeq(organizationData.get(0).getOrganizationSeq());
		getSubOrganizationInfoVo.setOrganizationBussinessType(organizationData.get(0).getOrganizationBussinessType().intValue());
		getSubOrganizationInfoVo.setDefinitionId(definitionData.getDefinitionId());
		getSubOrganizationInfoVo.setCreationTime(DateTimeHelper.formatDateTimetoString(organizationData.get(0).getCreationTime()));
		String adminUsersId = "";
		if(null != managerData && managerData.size() > 0) {
			if(managerData.size() >= 2) {
				for(ErpFunOrganizationManager mg : managerData) {
					adminUsersId += mg.getUserId() + ",";
				}
			} else {
				adminUsersId = managerData.get(0).getUserId().toString();
			}
		}
		getSubOrganizationInfoVo.setAdminUserId(adminUsersId);
		return ErpResponseJson.ok(getSubOrganizationInfoVo);
	}
	
	/**
	 * @desc （新版组织机构）编辑子部门信息
	 * @author lzg
	 * @since 2019年11月27日
	 */
	@ApiOperation(value = "（新版组织机构）编辑子部门信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/editSubOrganization")
	@NotBlank({"organizationName", "adminUserId"})
	public ErpResponseJson editSubOrganization(@RequestBody @Valid EditSubOrganizationParam param) {
		Operator operator = getOperator();
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		if (param.getCityId()==null) {
			param.setCityId(operator.getCityId());
		}
		if (param.getCompId()==null) {
			param.setCompId(operator.getCompId());
		}
		param.setUserId(operator.getUserId());
		
		ErpFunOrganizationExample seleOrgExample = new ErpFunOrganizationExample();
		seleOrgExample.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andOrganizationIdEqualTo(param.getOrganizationId());
		seleOrgExample.setShardCityId(param.getCityId());
		List<ErpFunOrganization> listOrg = erpFunOrganizationMapper.selectByExample(seleOrgExample);
		
		//修改父级：新旧pid不为空，且数据库查询出的pid和收到的新pid不相同时才做修改
		//1.判断调动组织下面的房客源数据，有多少,如果超过三千，那么晚上去调动,前端需要给个文案提示
		MoveOrganizationVO result = new MoveOrganizationVO();
		if (null != param.getPid() && param.getPid() >= 0) {
			if(! listOrg.get(0).getPid().equals(param.getPid())) {
				boolean moveFlag = reportFunSaleMinService.canMoveOrgNow(operator.getCompNo(), operator.getCityId(), operator.getCompId(), listOrg.get(0).getPid(), null);
				if (moveFlag) {
					result.setMoveType(0);
					MoveOrganizationServiceVO moveOrganizationServiceVO = erpFunOrganizationService.moveOrganization(operator.getCityId(),operator.getCompId(),operator.getUserId(),param.getOrganizationId(),listOrg.get(0).getPid(),param.getPid());
					//将老组织下所有的人员，包括老组织下的组织的人员，都查出archiveId，循环调用上面的方法
					//将调用了组织的人员数量记录下来,然后查询出影响到的老组织线和新组织线，发送JMS修改老组织和新组织的人数
					List<ErpFunUsers> organizationAllUser = moveOrganizationServiceVO.getOrganizationAllUser();
					for (ErpFunUsers funUser : organizationAllUser) {
						Map<String, Object> changeDeptInfo = new HashMap<>();
						changeDeptInfo.put("cityId", param.getCityId());
						changeDeptInfo.put("compId", param.getCompId());
						changeDeptInfo.put("newOrgId", moveOrganizationServiceVO.getLookNewLevelId());
						changeDeptInfo.put("oldOrgId", moveOrganizationServiceVO.getLookOldLevelId());
						changeDeptInfo.put("archiveId", funUser.getArchiveId());
						httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
					}
				
				} else {
					result.setMoveType(1);
					result.setMoveMsg("由于当前业务数据量改动大，为避免影响使用，本次调动组织操作系统由22点开始执行本次操作！");
					MoveOrganizationParam moveParam = new MoveOrganizationParam();
					moveParam.setCityId(param.getCityId());
					moveParam.setOrganizationId(param.getOrganizationId());
					moveParam.setCompId(param.getCompId());
					moveParam.setOldPid(listOrg.get(0).getPid());
					moveParam.setNewPid(param.getPid());
					moveParam.setUserId(param.getUserId());
					erpFunOrganizationService.insertUpdatePidApplyInfo(moveParam);
				}
			}
		}
		//修改部门信息
		erpFunOrganizationService.editOrganizationInfo(param);
		//如果改了主管判断一下审核这边的处理情况 2020-06-24
		if (StringUtils.isNotBlank(param.getAdminUserId())) {
			erpAuditRuntimeService.createAuditUserForOrgManagerChange(param.getCityId(), param.getCompId(), Integer.valueOf(param.getAdminUserId()));
		}
		activeMqPublisher.sendMoveOrgMsg(param.getCityId(), param.getCompId(), param.getOrganizationId(), null);
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * @desc （新版组织机构）删除子部门
	 * @author lzg
	 * @since 2019年11月26日
	 */
	@ApiOperation(value = "（新版组织机构）删除子部门")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/deleteSubOrganization")
	@NotBlank("organizationId")
	public ErpResponseJson deleteSubOrganization(@RequestBody @Valid DeleteSubOrganizationParam param) {
		Operator operator = getOperator();
		//针对跨城管理公司需求：前端有传用前端的，没传就用会话的
		if (null == param.getCityId()) {
			param.setCityId(operator.getCityId());
		}
		if (null == param.getCompId()) {
			param.setCompId(operator.getCompId());
		}
		param.setUserId(operator.getUserId());
		erpFunOrganizationService.deleteOrgByOrganizationId(param);
		activeMqPublisher.sendMoveOrgMsg(param.getCityId(), param.getCompId(), param.getOrganizationId(), null);
		return ErpResponseJson.ok();
	}
	
	/**
	 * @desc （新版组织机构）添加申请修改父级组织id（修改PID）
	 * @author lzg
	 * @since 2019年11月27日
	 */
	@ApiOperation(value = "（新版组织机构）调动组织机构")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MoveOrganizationVO.class, message = "成功")})
	@PostMapping("/moveOrganization")
	@NotBlank("organizationId")
	public ErpResponseJson moveOrganization(@RequestBody MoveOrganizationParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		MoveOrganizationVO result = new MoveOrganizationVO();
		//1.判断调动组织下面的房客源数据，有多少,如果超过三千，那么晚上去调动,前端需要给个文案提示
		//调动的修改orgPath的逻辑是 先where条件为当前orgPath包含当前原有的组织机构id的下的所有
		//的组织更新值为 把原有组织的orgPath中的原有上级的orgPath替换成新的上级的orgPath就阔以了
		//只是需要注意一点，如果当前调动组织的第一级没有上级，则替换内容为当前第一级的orgPath;
		boolean moveFlag = reportFunSaleMinService.canMoveOrgNow(operator.getCompNo(), operator.getCityId(), operator.getCompId(), param.getOldPid(), null);
		if (moveFlag) {
			result.setMoveType(0);
			MoveOrganizationServiceVO moveOrganizationServiceVO = erpFunOrganizationService.moveOrganization(operator.getCityId(),operator.getCompId(),operator.getUserId(),param.getOrganizationId(),param.getOldPid(),param.getNewPid());
			//将老组织下所有的人员，包括老组织下的组织的人员，都查出archiveId，循环调用上面的方法
			//将调用了组织的人员数量记录下来,然后查询出影响到的老组织线和新组织线，发送JMS修改老组织和新组织的人数
			List<ErpFunUsers> organizationAllUser = moveOrganizationServiceVO.getOrganizationAllUser();
			for (ErpFunUsers funUser : organizationAllUser) {
				Map<String, Object> changeDeptInfo = new HashMap<>();
				changeDeptInfo.put("cityId", param.getCityId());
				changeDeptInfo.put("compId", param.getCompId());
				changeDeptInfo.put("newOrgId", moveOrganizationServiceVO.getLookNewLevelId());
				changeDeptInfo.put("oldOrgId", moveOrganizationServiceVO.getLookOldLevelId());
				changeDeptInfo.put("archiveId", funUser.getArchiveId());
				httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
			}
			
		} else {
			result.setMoveType(1);
			result.setMoveMsg("由于当前业务数据量改动大，为避免影响使用，本次调动组织操作系统由22点开始执行本次操作！");
			erpFunOrganizationService.insertUpdatePidApplyInfo(param);
		}
		return ErpResponseJson.ok(result);
	}
	/**
	 * @desc （新版组织机构）添加申请修改父级组织id（修改PID）
	 * @author lzg
	 * @since 2019年11月27日
	 */
	@ApiOperation(value = "（新版组织机构）调动组织机构")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MoveOrganizationVO.class, message = "成功")})
	@PostMapping("/openApi/moveOrganization")
	@NotBlank("organizationId")
	public ErpResponseJson moveOrganizationOpenApi(@RequestBody MoveOrganizationParam param) {
		//1.判断调动组织下面的房客源数据，有多少,如果超过三千，那么晚上去调动,前端需要给个文案提示
		//调动的修改orgPath的逻辑是 先where条件为当前orgPath包含当前原有的组织机构id的下的所有
		//的组织更新值为 把原有组织的orgPath中的原有上级的orgPath替换成新的上级的orgPath就阔以了
		//只是需要注意一点，如果当前调动组织的第一级没有上级，则替换内容为当前第一级的orgPath;
		MoveOrganizationServiceVO moveOrganizationServiceVO = erpFunOrganizationService.moveOrganization(param.getCityId(),param.getCompId(),param.getUserId(),param.getOrganizationId(),param.getOldPid(),param.getNewPid());
		//将老组织下所有的人员，包括老组织下的组织的人员，都查出archiveId，循环调用上面的方法
		//将调用了组织的人员数量记录下来,然后查询出影响到的老组织线和新组织线，发送JMS修改老组织和新组织的人数
		List<ErpFunUsers> organizationAllUser = moveOrganizationServiceVO.getOrganizationAllUser();
		for (ErpFunUsers funUser : organizationAllUser) {
			Map<String, Object> changeDeptInfo = new HashMap<>();
			changeDeptInfo.put("cityId", param.getCityId());
			changeDeptInfo.put("compId", param.getCompId());
			changeDeptInfo.put("newOrgId", moveOrganizationServiceVO.getLookNewLevelId());
			changeDeptInfo.put("oldOrgId", moveOrganizationServiceVO.getLookOldLevelId());
			changeDeptInfo.put("archiveId", funUser.getArchiveId());
			httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/changeOrg", changeDeptInfo);
		}

			
		return ErpResponseJson.ok();
	}
	
	/**
	 * @desc （新版组织机构）添加、编辑、删除 业务层级定义
	 * @author lzg
	 * @since 2019年12月6日
	 */
	@ApiOperation(value = "（新版组织机构）添加、编辑、删除 业务层级定义")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")})
	@PostMapping("/saveLevelDefinition")
	public ErpResponseJson saveLevelDefinition(@RequestBody SaveLevelDefinitionListParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setOperatorUserId(operator.getUserId());
		erpFunOrganizationService.saveOrganizationDefinitionInfo(param);
		
		return ErpResponseJson.ok();
	}
	
	/**
	 * @title 新版组织架构查询组织信息
	 * @author Lee
	 * @date 2019/12/9 9:32
	 ***/
	@ApiOperation(value = "（新版组织机构）查询组织信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunOrganization.class, message = "成功")})
	@PostMapping("/getOrganizationListInfo")
	public ErpResponseJson getOrganizationListInfo(@RequestBody @Valid OrganizationListInfoParam param) {
		Operator operator = getOperator();

		String organizationIds = param.getOrganizationIds();
		if(StringUtils.isNotBlank(organizationIds)) {
			String[] idsArr = organizationIds.split(",");
			if(idsArr.length > 0) {
				List<Integer> organizationIdList = Arrays.stream(idsArr).map(s->Integer.parseInt(s.trim())).collect(Collectors.toList());
				ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
				erpFunOrganizationExample.setShardCityId(operator.getCityId());
				erpFunOrganizationExample.createCriteria().andOrganizationIdIn(organizationIdList);
				List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
				return ErpResponseJson.ok(erpFunOrganizations);
			}
		}
		return ErpResponseJson.ok();
	}
	
	
	@ApiOperation(value = "无限组织架构下跨城-查询全集团的组织信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetAcrossTheCityOrganizationVO.class, message = "成功")})
	@PostMapping("/getAcrossTheCityOrganization")
	@Deprecated// 废弃原因：erp说在erpWeb/common/getOrganizationDataList上增加全集团组织信息返回
	public ErpResponseJson getAcrossTheCityOrganization(@RequestBody GetAcrossTheCityOrganizationParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		String updateTime = param.getUpdateTime();
		if (StringUtil.isNotBlank(updateTime)) {
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.hasGreaterThanUpdateTime(cityId, updateTime);
			if (null == erpFunOrganization) {// 没有更新的数据
				return ErpResponseJson.ok();
			}
		}
		// 查询集团下所有的组织信息
		List<ErpFunOrganization> acrossTheCityOrganizationList = erpFunOrganizationMapper.getAcrossTheCityOrganization(cityId);
		// 公司对应所有组织数据
		GetAcrossTheCityOrganizationVO resultVO = new GetAcrossTheCityOrganizationVO();
		if (!acrossTheCityOrganizationList.isEmpty()) {
			// 获取城市信息
			List<Integer> cityIdList = acrossTheCityOrganizationList.stream().distinct().map(ErpFunOrganization :: getCityId).collect(Collectors.toList());
			Map<Integer, String> cityInfoMap = null;// 城市信息map
			if (!cityIdList.isEmpty()) {
				List<ErpFunCity> cityIdInfo = erpFunCityMapper.getCityInfoByCityIds(cityId, cityIdList);
				cityInfoMap = cityIdInfo.stream().collect(Collectors.toMap(val ->  val.getCityId().intValue(), val -> val.getCityName()));
			}
			
			// 获取公司信息
			Map<Integer, List<ErpFunOrganization>> compOrgMap = acrossTheCityOrganizationList.stream().collect(Collectors.groupingBy(ErpFunOrganization :: getCompId));
			Map<Integer, ErpFunComp> compInfoMap = null;// 公司信息map
			
			if (null != compOrgMap) {
				Set<Integer> keySet = compOrgMap.keySet();
				ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
				erpFunCompExample.setShardCityId(cityId);
				erpFunCompExample.createCriteria().andCompIdIn(new ArrayList<Integer>(keySet));
				List<ErpFunComp> erpFunCompList = erpFunCompMapper.selectByExample(erpFunCompExample);
				compInfoMap = erpFunCompList.stream().collect(Collectors.toMap(ErpFunComp :: getCompId, val -> val));
			}
			
			// 查询组织中的子级组织数量
			List<GetChildOrganizationCountVO> childOrganizationCountList = erpFunOrganizationMapper.getChildOrganizationCount(cityId);
			Map<Integer, Integer> childOrganizationCountMap = null;// 组织的子级组织数量map
			if (!childOrganizationCountList.isEmpty()) {
				childOrganizationCountMap = childOrganizationCountList.stream().collect(Collectors.toMap(GetChildOrganizationCountVO :: getpId, val -> val.getCountNum()));
			}
			
			// 查询各个组织的主管信息
			List<Integer> organizationIdList = acrossTheCityOrganizationList.stream().map(ErpFunOrganization :: getOrganizationId).collect(Collectors.toList());
			ErpFunOrganizationManagerExample erpFunOrganizationManagerExample = new ErpFunOrganizationManagerExample();
			erpFunOrganizationManagerExample.setShardCityId(cityId);
			erpFunOrganizationManagerExample.createCriteria().andOrganizationIdIn(organizationIdList);
			List<ErpFunOrganizationManager> erpFunOrganizationManagerList = erpFunOrganizationManagerMapper.selectByExample(erpFunOrganizationManagerExample);
			Map<Integer, ErpFunUsers> userInfoMap = null;// 主管信息map
			Map<Integer, List<OrgManagerVO>> orgManagerInfoMap = new HashMap<Integer, List<OrgManagerVO>>();// 组织主管信息map
			if (!erpFunOrganizationManagerList.isEmpty()) {
				List<Integer> userIdList = erpFunOrganizationManagerList.stream().filter(val -> null != val.getUserId()).map(ErpFunOrganizationManager :: getUserId).collect(Collectors.toList());
				if (!userIdList.isEmpty()) { 
					List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getErpFunUsersList(cityId, userIdList);
					userInfoMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers :: getUserId, val -> val));
				}
				for (ErpFunOrganizationManager a : erpFunOrganizationManagerList) {
					Integer organizationId = a.getOrganizationId();
					Integer userId = a.getUserId();
					if (null != userInfoMap) {
						ErpFunUsers erpFunUsers = userInfoMap.get(userId);
						if (null != erpFunUsers) {
							OrgManagerVO orgManagerVO = new OrgManagerVO();
							try {
								BeanUtilsHelper.copyProperties(orgManagerVO, erpFunUsers);
							} catch (Exception e) {
								e.printStackTrace();
							}
							if (null != orgManagerInfoMap.get(organizationId)) {
								List<OrgManagerVO> list = orgManagerInfoMap.get(organizationId);
								list.add(orgManagerVO);
							} else {
								List<OrgManagerVO> tmpList = new ArrayList<OrgManagerVO>();
								tmpList.add(orgManagerVO);
								orgManagerInfoMap.put(organizationId, tmpList);
							}
						}
					}
				}
			}
			List<ErpFunOrganizationVO> orgVoList = new ArrayList<ErpFunOrganizationVO>();
			for (ErpFunOrganization erpFunOrganization : acrossTheCityOrganizationList) {
				Integer orgCityId = erpFunOrganization.getCityId();
				Integer orgcompId = erpFunOrganization.getCompId();
				Integer orgOrganizationId = erpFunOrganization.getOrganizationId();
				ErpFunOrganizationVO erpFunOrganizationVO = new ErpFunOrganizationVO();
				try {
					BeanUtilsHelper.copyProperties(erpFunOrganizationVO, erpFunOrganization);
					if (null != childOrganizationCountMap) {
						Integer childOrgNum = childOrganizationCountMap.get(orgOrganizationId);
						erpFunOrganizationVO.setChildOrganizationNum(null != childOrgNum ? childOrgNum : 0);
					}
					if (null != cityInfoMap) {
						String cityName = cityInfoMap.get(orgCityId);
						erpFunOrganizationVO.setCityName(cityName);
					}
					if (null != compInfoMap) {
						ErpFunComp erpFunComp = compInfoMap.get(orgcompId);
						if (null != erpFunComp) {
							erpFunOrganizationVO.setCompName(erpFunComp.getCompName());
						}
					}
					List<OrgManagerVO> orgManagerList = orgManagerInfoMap.get(orgOrganizationId);
					if (null != orgManagerList) {
						erpFunOrganizationVO.setManagerList(orgManagerList);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				orgVoList.add(erpFunOrganizationVO);
			}
			resultVO.setList(orgVoList);
		} else {
			resultVO.setList(Collections.emptyList());
		}
		return ErpResponseJson.ok(resultVO);
	}
	
	@ApiOperation(value = "无限组织架构下跨城-查询全集团的公司信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetAcrossTheCityCompInfoVO.class, message = "成功")})
	@PostMapping("/getAcrossTheCityCompInfo")
	public ErpResponseJson getAcrossTheCityCompInfo() {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		GetAcrossTheCityCompInfoVO resultVO = new GetAcrossTheCityCompInfoVO();// 结果集
		// 查询集团下所有的组织信息
		List<ErpFunOrganization> acrossTheCityOrganizationList = erpFunOrganizationMapper.getAcrossTheCityOrganization(cityId);
		if (!acrossTheCityOrganizationList.isEmpty()) {
			// 获取公司信息
			Map<Integer, List<ErpFunOrganization>> compOrgMap = acrossTheCityOrganizationList.stream().collect(Collectors.groupingBy(ErpFunOrganization :: getCompId));
			Map<Integer, ErpFunComp> compInfoMap = null;// 公司信息map
			Map<Integer, Integer> compOrgCountMap = new HashMap<>();// 公司组织数量map
			Map<Integer, Integer> compOrgEmpCountMap = new HashMap<>();// 公司下总人数map
			
			if (null != compOrgMap) {
				Set<Entry<Integer,List<ErpFunOrganization>>> entrySet = compOrgMap.entrySet();
				Iterator<Entry<Integer, List<ErpFunOrganization>>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					Entry<Integer, List<ErpFunOrganization>> entry = iterator.next();
					Integer key = entry.getKey();
					List<ErpFunOrganization> value = entry.getValue();
					int orgCount = 0;
					int orgEmpCount = 0;
					for (ErpFunOrganization org : value) {
						orgEmpCount += org.getOrganizationUserNum();
						orgCount ++;
					}
					compOrgCountMap.put(key, orgCount);
					compOrgEmpCountMap.put(key, orgEmpCount);
				}
				ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
				erpFunCompExample.setShardCityId(cityId);
				erpFunCompExample.createCriteria().andMainCompIn(Arrays.asList(Byte.valueOf("1"), Byte.valueOf("2")));
				List<ErpFunComp> erpFunCompList = erpFunCompMapper.selectByExample(erpFunCompExample);
				compInfoMap = erpFunCompList.stream().collect(Collectors.toMap(ErpFunComp :: getCompId, val -> val));
			}
			
			if (null != compInfoMap) {// 组装每一个公司的信息
				// 获取城市信息
				List<Integer> cityIdList = compInfoMap.values().stream().distinct().map(val -> val.getCityId().intValue()).collect(Collectors.toList());
				Map<Integer, String> cityInfoMap = null;// 城市信息map
				if (!cityIdList.isEmpty()) {
					List<ErpFunCity> cityIdInfo = erpFunCityMapper.getCityInfoByCityIds(cityId, cityIdList);
					cityInfoMap = cityIdInfo.stream().collect(Collectors.toMap(val ->  val.getCityId().intValue(), val -> val.getCityName()));
				}
				
				List<ErpFunCompOrganizationVO> list = new ArrayList<ErpFunCompOrganizationVO>();
				Set<Entry<Integer,ErpFunComp>> entrySet = compInfoMap.entrySet();
				Iterator<Entry<Integer, ErpFunComp>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					Entry<Integer, ErpFunComp> next = iterator.next();
					Integer key = next.getKey();
					ErpFunComp value = next.getValue();
					if (null != value) {
						ErpFunCompOrganizationVO erpFunCompOrganizationVO = new ErpFunCompOrganizationVO();
						try {
							BeanUtilsHelper.copyProperties(erpFunCompOrganizationVO, value);
							if (null != cityInfoMap) {
								String cityName = cityInfoMap.get(value.getCityId().intValue());
								erpFunCompOrganizationVO.setCityName(cityName);
							}
							if (null != compOrgCountMap.get(key)) {
								erpFunCompOrganizationVO.setCompOrgNum(compOrgCountMap.get(key));
							}
							if (null != compOrgEmpCountMap.get(key)) {
								erpFunCompOrganizationVO.setCompOrgUserNum(compOrgEmpCountMap.get(key));
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						list.add(erpFunCompOrganizationVO);
					}
				}
				resultVO.setList(list);
			} else {
				resultVO.setList(Collections.emptyList());
			}
		} else {
			resultVO.setList(Collections.emptyList());
		}
		return ErpResponseJson.ok(resultVO);
	}

	@ApiOperation(value = "添加分公司")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")})
	@PostMapping("/createChildComp")
	public ErpResponseJson createChildComp(@RequestBody UpdateChileCompParam param) throws Exception{
		Date date = new Date();
		AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(param.getCityId().shortValue());
		AdminFunComp funComp = new AdminFunComp();
		funComp.setProvinceId(adminFunCity.getProvinceId().intValue());
		if (param.getCityId() == 0) {
			throw new BusinessException("请选择此公司所在城市");
		}
		funComp.setCityId(param.getCityId());
		String plantPwd = StringUtil.generateInstallPwd(16);
		String instalPwd = EncryptHelper.getKeyBean.getkeyBeanofStr(plantPwd);
		funComp.setMainComp(param.getMainComp().byteValue());
		funComp.setCrmCompId(1);
		funComp.setInstallPwd(instalPwd);
		funComp.setPlaintPwd(plantPwd);
		funComp.setDeptStatus(Const.getDeptCustStatus.DIC_DEPT_FLAG_AVAILABLE);		//付费状态
		funComp.setCreationTime(date);
		funComp.setTrackTime(date);
		funComp.setSellTrackTime(date);
		funComp.setCompWeixinStatus(1);
		funComp.setCompModel((byte) 1);
		funComp.setCreatorUid(999);
		funComp.setCompType((byte) 1);
		funComp.setCompName(param.getCompName());
		funComp.setCompCname(param.getCompName());
		funComp.setCompAddr(param.getContactAddress());
		funComp.setCompTele(param.getContactPhoneNumber());
		funComp.setCompContact(param.getUserName());
		funComp.setContactPhone(param.getUserMobile());
		funComp.setCustomizedType(2);

		// 新建分店
		AdminFunDepts adminFunDepts = new AdminFunDepts();
		adminFunDepts.setRegisterSource((byte)2);
		adminFunDepts.setChainCustomerMark(1);// 集团客户标记
		adminFunDepts.setDeptType((byte) 1);
		adminFunDepts.setCityId(param.getCityId());
		adminFunDepts.setProvinceId(adminFunCity.getProvinceId().intValue());
		Integer organizationId = adminFunDeptsMapper.GetOrganizationId();
		adminFunDepts.setDeptId(organizationId);
		adminFunDepts.setCompId(funComp.getCompId());
		adminFunDepts.setCrmCompId(1);
		adminFunDepts.setProvinceId(funComp.getProvinceId());
		adminFunDepts.setCityId(funComp.getCityId());
		adminFunDepts.setSeqNo(1);
		adminFunDepts.setDeptName(funComp.getCompName());
		adminFunDepts.setDeptCname(funComp.getCompCname());
		adminFunDepts.setDeptAddr(funComp.getCompAddr());
		adminFunDepts.setDeptTele(funComp.getCompTele());
		adminFunDepts.setDeptContact(funComp.getCompContact());
		adminFunDepts.setContactPhone(funComp.getContactPhone());
		adminFunDepts.setDeptStatus(Const.getDeptCustStatus.DIC_CUST_STATUS_FORMAL);
		adminFunDepts.setExtendCount(0);
		adminFunDepts.setDeptFlag(Const.getDeptCustStatus.DIC_DEPT_FLAG_FORMAL);
		adminFunDepts.setCloseFlag(false);
		adminFunDepts.setUseFlag(false);
		adminFunDepts.setPwdDesc(plantPwd);
		adminFunDepts.setTrackTime(date);
		adminFunDepts.setSellTrackTime(date);
		adminFunDepts.setCreatorUid(999);
		adminFunDepts.setCreationTime(date);
		adminFunDepts.setActionTime(date);
		adminFunDepts.setPlateType((byte) 0);
		adminFunDepts.setDeptSource("DEVELOP");

		String result = adminFunCompService.createSubComp(funComp, adminFunDepts);

		if ("OK".equals(result)) {
			return ErpResponseJson.ok();
		} else if("HAS".equals(result)){
			return ErpResponseJson.warn("当前用户目前在其他门店中，不能开库，请更换手机号码！");

		}else if("CITY".equals(result)){
			return ErpResponseJson.warn("该用户注册城市与开库城市不在同一城市！");
		}else{
			return ErpResponseJson.warn(result);
		}
	}

	@ApiOperation(value = "修改分公司信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")})
	@PostMapping("/updateCompInfo")
	public ErpResponseJson updateCompInfo(@RequestBody UpdateChileCompParam param) throws Exception{
		String result = adminFunCompService.updateCompInfo(param);
		if (!"OK".equals(result)) {
			return ErpResponseJson.warn(result);
		}
		return ErpResponseJson.ok();
	}

	@ApiOperation(value = "获取公司信息")
	@ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")})
	@PostMapping("/selectCompInfoByCompId")
	public ErpResponseJson selectCompInfoByCompId(@RequestBody CompInfoParam param) throws Exception{
		if (param.getCityId() == null) {
			return ErpResponseJson.warn("城市ID参数缺失");
		}
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(param.getCityId(), param.getCompId());
		if (erpFunComp != null) {
			AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
			return ErpResponseJson.ok(adminFunComp);
		} else {
			return ErpResponseJson.warn("未获取到公司信息");
		}
	}
	
	/**
	   * 获取行政区商圈列表
	   * @author 方李骥
	   * @since 2020年03月03日
	   * @return
	   */
	  @ApiOperation(value = "获取行政区商圈列表")
	  @ApiResponses(value = {@ApiResponse(code = 1, message = "",response = GetRegSectionListVO.class)})
	  @PostMapping("/getRegSectionList")
	  public ResponseJson getRegSectionList(@RequestBody GetRegSectionListParam param) {
	    GetRegSectionListVO getRegSecionListVo = new GetRegSectionListVO();
	    ErpFunRegExample example = new ErpFunRegExample();
	    example.setShardCityId(param.getCityId());
	    example.createCriteria().andCityIdEqualTo(param.getCityId().shortValue()).andVertifyFlagEqualTo(Byte.valueOf(Byte.valueOf("0")));
	    List<ErpFunReg> regList = erpFunRegMapper.selectByExample(example);
	    ErpFunSectionExample sectionExample = new ErpFunSectionExample();
	    sectionExample.setShardCityId(param.getCityId());
	    sectionExample.createCriteria().andCityIdEqualTo(param.getCityId().shortValue()).andVertifyFlagEqualTo(Byte.valueOf("0"));
	    List<ErpFunSection> sectionList = erpFunSectionMapper.selectByExample(sectionExample);
	    getRegSecionListVo.setRegionList(regList);
	    getRegSecionListVo.setSectionList(sectionList);
	    return ErpResponseJson.ok(getRegSecionListVo);
	  }

}
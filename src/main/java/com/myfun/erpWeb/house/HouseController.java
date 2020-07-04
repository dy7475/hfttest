package com.myfun.erpWeb.house;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.build.param.RemovePhotoParam;
import com.myfun.erpWeb.house.param.GetRoadsMenuParam;
import com.myfun.erpWeb.house.param.ProxyTemplateParam;
import com.myfun.erpWeb.house.param.UpdateOrCreateTmpParam;
import com.myfun.erpWeb.house.param.houseParam;
import com.myfun.erpWeb.house.vo.ErpFunProxyTemplateVo;
import com.myfun.erpWeb.house.vo.FunKeyDetailDto;
import com.myfun.erpWeb.house.vo.UpdateOrCreateTmpVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunTempletMapper;
import com.myfun.repository.admindb.dao.AdminFunUserMessageMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminFunTemplet;
import com.myfun.repository.admindb.po.AdminFunTempletExample;
import com.myfun.repository.admindb.po.AdminFunTempletExample.Criteria;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunBuyCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunLeaseDto;
import com.myfun.repository.erpdb.dto.ErpFunRentCustomerDto;
import com.myfun.repository.erpdb.dto.ErpFunSaleDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpBuildingSetSetting;
import com.myfun.repository.erpdb.po.ErpBuildingSetSettingExample;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunKey;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManagerExample;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhotoExample;
import com.myfun.repository.erpdb.po.ErpFunProxyTemplate;
import com.myfun.repository.erpdb.po.ErpFunReg;
import com.myfun.repository.erpdb.po.ErpFunRegExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerKey;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfo;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.repository.erpdb.po.ErpFunSectionExample;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunKeyService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunProxyTemplateService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpFunTrackService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.Assert;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.Constants_DIC.MsgModule;
import com.myfun.utils.Constants_DIC.MsgModuleType;
import com.myfun.utils.DateConvert;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.QRCodeUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rijindael.AESHelper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 房源控制器
 */
@Api(tags = "房源模块")
@Controller
@RequestMapping(value = "/house")
public class HouseController extends BaseController {

    @Autowired
    ErpFunRoadsInfoMapper erpFunRoadsInfoMapper;
    @Autowired
    private ErpFunTaskService erpFunTaskService;
    @Autowired
    private ErpFunTrackService erpFunTrackService;
    @Autowired
    private ErpFunKeyMapper erpFunKeyMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunKeyLogMapper erpFunKeyLogMapper;
    @Autowired
    private ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    ErpFunKeyRemarkMapper erpFunKeyRemarkMapper;
    @Autowired
    ErpFunKeyService erpFunKeyService;
    @Autowired
    ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Autowired
    ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
    @Autowired
    ErpFunSectionMapper erpFunSectionMapper;
    @Autowired
    ErpFunRegMapper erpFunRegMapper;
    @Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
    @Autowired
    ErpFunHousePublishStatusMapper erpFunHousePublishStatusMapper;
    @Autowired
    ErpSysParaMapper erpSysParaMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpUserOpersService erpUserOpersService;
    @Autowired
    AdminSysParaMapper adminSysParaMapper;
    @Autowired
    ErpFunPhotoMapper erpFunPhotoMapper;
    @Autowired
    AdminFunTempletMapper adminFunTempletMapper;
    @Autowired
    ErpFunProxyTemplateMapper erpFunProxyTemplateMapper;
    @Autowired
    ErpFunProxyTemplateService erpFunProxyTemplateService;
    @Autowired
    ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired
	private AdminFunUserMessageMapper adminFunUserMessageMapper;
	@Autowired
	private ErpFunSaleService erpFunSaleService;
	@Autowired
	private ErpFunLeaseService erpFunLeaseService;
	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private AdminFunCompService adminFunCompService;
    @Autowired
    private ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	
	
	
	/**
	 * 查询交通干道菜单
	 * @author 臧铁
	 * @param param roadsName 干道名称
	 * @since erpFunKeyRemarkMapper
	 * @return
	 */
	@ApiOperation("查询交通干道菜单")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping(value = "/getRoadsMenu")
	public ResponseJson getRoadsMenu(@Valid @RequestBody GetRoadsMenuParam param){
		param.setCityId(getOperator().getCityId());
		String roadsName = param.getRoadsName();
		if (null != roadsName) {
			param.setRoadsName("%" + roadsName + "%");
		}
		List<ErpFunRoadsInfo> resList = erpFunRoadsInfoMapper.getRoadsMenu(param.getCityId(), param);
		return ErpResponseJson.ok(resList);
	}


    /**
     * 修改房源的所属楼盘
     *
     * @return
     * @author
     * @since 2017年8月23日
     */
    @ResponseBody
    @RequestMapping("/updateHouseBuild")
    public ResponseJson updateHouseBuild(@RequestBody ErpCreateTrackInfoParam param) throws Exception {
        this.generatorParamForKey(param, false);
        param.setTrackType(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD);
        Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
        // 增加工作量
        erpFunTrackService.sendJmsMessageForWorkCount(param);
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 钥匙相关审核任务参数组装
     *
     * @param param
     * @author 张宏利
     * @since 2017年11月6日
     */
    private void generatorParamForKey(ErpCreateTrackInfoParam param, boolean isKeyTask) {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        param.setSelfAreaId(operator.getAreaId());
        param.setSelfRegId(operator.getRegId());
        param.setSelfDeptId(operator.getDeptId());
        param.setSelfUserId(operator.getUserId());
        param.setSelfUserName(operator.getUserName());
        param.setSelfDeptName(operator.getDeptName());
        param.setSelfArchiveId(operator.getArchiveId());
        param.setSelfGrId(operator.getGrId());
        param.setCompType(operator.getCompType());
        param.setIsPersonalVersion(operator.isPersonalVersion());
        param.setAreaFlag(operator.getAreaFlag());
        param.setPcname(operator.getString("PCNAME"));
        param.setUserPosition(operator.getUserPosition());
        param.setIsGeneralManager(operator.isGeneralManager());
        // 钥匙ID
        if (isKeyTask && param.getTargetId() != null) {
            ErpFunKey erpFunKey = new ErpFunKey();
            erpFunKey.setKeyId(param.getTargetId());
            erpFunKey.setShardCityId(getOperator().getCityId());
            ErpFunKey erpFunKeySelect = erpFunKeyMapper.selectByPrimaryKey(erpFunKey);
            Assert.isNullThrow(erpFunKeySelect, "未找到该钥匙");
            param.setCaseId(erpFunKeySelect.getCaseId());
            param.setCaseType(erpFunKeySelect.getCaseType().intValue());
            param.setKeyDeptId(erpFunKeySelect.getKeyDeptId());
            param.setTargetNo(erpFunKeySelect.getKeyNum());
        }
        // 需要审核的时候，要找钥匙所在门店，注销的钥匙编号等
        if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(param.getTrackType())
                || Const.DIC_TRACK_TYPE_BORROW_KEY.equals(param.getTrackType())
                || Const.DIC_TRACK_TYPE_RETURN_KEY.equals(param.getTrackType())
                ) {
            if (param.getKeyDeptId() == null) {
                if (param.getCaseId() != null && param.getCaseType() != null) {
                    ErpFunKey erpFunKey = erpFunKeyMapper.getErpFunKey(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType());
                    if (Const.DIC_TRACK_TYPE_DESTROY_KEY.equals(param.getTrackType()) && erpFunKey == null) {
                        Integer saleLeaseId = null;
                        Integer saleLeaseType = null;
                        if (Const.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType())) {
                            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(param.getCityId(), param.getCaseId());
                            if (null != erpFunSale && null != erpFunSale.getSaleLeaseId() && (null != erpFunSale.getIsSaleLease() && 1 == erpFunSale.getIsSaleLease().intValue())) {
                                saleLeaseId = erpFunSale.getSaleLeaseId();
                                saleLeaseType = Const.DIC_CASE_TYPE_LEASE_FUN;
                            }
                        } else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(param.getCaseType())) {
                            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(param.getCityId(), param.getCaseId());
                            if (null != erpFunLease && null != erpFunLease.getSaleLeaseId() && (null != erpFunLease.getIsSaleLease() && 1 == erpFunLease.getIsSaleLease().intValue())) {
                                saleLeaseId = erpFunLease.getSaleLeaseId();
                                saleLeaseType = Const.DIC_CASE_TYPE_SALE_FUN;
                            }
                        }
                        erpFunKey = erpFunKeyMapper.getErpFunKey(param.getCityId(), param.getCompId(), saleLeaseId, saleLeaseType);
                    }
                    if (erpFunKey != null) {
                        param.setKeyDeptId(erpFunKey.getKeyDeptId());
                        param.setTargetNo(erpFunKey.getKeyNum());
                    }
                }
            }
        }
    }

    /**
     * 提交钥匙
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年10月11日
     */
    @ResponseBody
    @RequestMapping("/submitKey")
    public ResponseJson submitKey(@Valid @RequestBody ErpCreateTrackInfoParam param) throws Exception {
        param.setTrackType(Const.DIC_TRACK_TYPE_SUBMIT_KEY);
        this.generatorParamForKey(param, true);
        // 增加判断房源有没有钥匙
        if (Integer.valueOf(1).equals(param.getKey())) {
            erpFunKeyService.detectHouseKey(param.getCityId(), param.getCompId(), param.getCaseId(), param.getCaseType().byteValue());
            // 判断是否已经提交了提交钥匙的审核
            ErpAuditRuntime erpAuditRuntime = erpAuditRuntimeMapper.getHaveAuditByType(param.getCityId(), param.getCompId(), param.getSelfUserId(), param.getCaseId(), param.getCaseType(), param.getCaseType().byteValue());
            if (null != erpAuditRuntime) {
                throw new BusinessException("该房源提交的钥匙审核尚未被审核");
            }
        }
        Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
        // 增加工作量
        erpFunTrackService.sendJmsMessageForWorkCount(param);
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 借用钥匙
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年10月11日
     */
    @ResponseBody
    @RequestMapping("/borrowKey")
    public ResponseJson borrowKey(@Valid @RequestBody ErpCreateTrackInfoParam param) throws Exception {
        param.setTrackType(Const.DIC_TRACK_TYPE_BORROW_KEY);
        this.generatorParamForKey(param, true);
        Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
        // 增加工作量
        erpFunTrackService.sendJmsMessageForWorkCount(param);
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 归还钥匙
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年10月11日
     */
    @ResponseBody
    @RequestMapping("/returnKey")
    public ResponseJson returnKey(@Valid @RequestBody ErpCreateTrackInfoParam param) throws Exception {
        param.setTrackType(Const.DIC_TRACK_TYPE_RETURN_KEY);
        this.generatorParamForKey(param, true);
        Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
        // 增加工作量
        erpFunTrackService.sendJmsMessageForWorkCount(param);
        return ErpResponseJson.ok(resultMap);
    }

    /**
     * 注销钥匙
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年10月11日
     */
    @ResponseBody
    @RequestMapping("/destroyKey")
    public ResponseJson destroyKey(@Valid @RequestBody ErpCreateTrackInfoParam param) throws Exception {
        param.setTrackType(Const.DIC_TRACK_TYPE_DESTROY_KEY);
        this.generatorParamForKey(param, true);
        Map<String, Object> resultMap = erpFunTrackService.createTrackInfo(param);
        // 增加工作量
        erpFunTrackService.sendJmsMessageForWorkCount(param);
        return ErpResponseJson.ok(resultMap);
    }


    /**
     * @author 邓永洪
     * @tag f房源详情->获取钥匙详情
     * @since 2018/4/20
     */
    @ResponseBody
    @RequestMapping("/getHouseKeyInfo")
    public ResponseJson getHouseKeyInfo(@Valid @RequestBody ErpCreateTrackInfoParam param) {
        Operator operator = getOperator();
        Integer currentUserId = operator.getUserId();
        Integer currentDeptId = operator.getDeptId();
        Integer cityId = operator.getCityId();
        this.generatorParamForKey(param, true);
        if (operator.newOrganizationType()) {
			param.setNewOrganization(true);
		}
        FunKeyDetailDto keyDetail = erpFunKeyService.getKeyDetail(param,cityId,currentUserId,currentDeptId);
     if(operator.getUserId().equals(keyDetail.getUserId())){
            keyDetail.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
        }else if(keyDetail.getUserId() != null && keyDetail.getUserId() != 0){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, keyDetail.getUserId());
            ErpFunOrganizationManagerExample managerExample = new ErpFunOrganizationManagerExample();
            managerExample.setShardCityId(cityId);
            managerExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(erpFunUsers != null ? erpFunUsers.getOrganizationId() : -10086);
            List<ErpFunOrganizationManager> directlyLeaderManagers = erpFunOrganizationManagerMapper.selectByExample(managerExample);
            //获取直属领导的IDS，再查询直属领导的信息，确认是否被注销了
            List<Integer> directlyLeaderUserId = directlyLeaderManagers.stream().map(ErpFunOrganizationManager::getUserId).collect(Collectors.toList());
            List<Integer> directlyLeaderIdsNotWriteoff = new ArrayList<>();
            if(!directlyLeaderUserId.isEmpty()){
                ErpFunUsersExample userExample = new ErpFunUsersExample();
                userExample.setShardCityId(cityId);
                userExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andUserIdIn(directlyLeaderUserId).andUserWriteoffEqualTo(false);
                List<ErpFunUsers> directlyLeaders = erpFunUsersMapper.selectByExample(userExample);
                if(!directlyLeaders.isEmpty()){
                    List<Integer> collect = directlyLeaders.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
                    directlyLeaderIdsNotWriteoff.addAll(collect);
                }
            }
            for (int i = 0; i < directlyLeaderManagers.size(); i++) {
                if(operator.getUserId().equals(directlyLeaderManagers.get(i).getUserId())){
                    keyDetail.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
                    break;
                }
            }
            //没有直属领导
            int length = erpFunUsers != null ?erpFunUsers.getTissueLine().split(":").length : 0;
            if(directlyLeaderIdsNotWriteoff.size() == 0 && length > 2){
                managerExample.clear();
                managerExample.setShardCityId(cityId);
                managerExample.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdEqualTo(Integer.valueOf(erpFunUsers.getTissueLine().split(":")[length-2]));
                List<ErpFunOrganizationManager> upLeaderManagers = erpFunOrganizationManagerMapper.selectByExample(managerExample);
                for (int i = 0; i < upLeaderManagers.size(); i++) {
                    if(operator.getUserId().equals(upLeaderManagers.get(i).getUserId())){
                        keyDetail.setDirectlyLeaderOrSelf(Byte.valueOf("1"));
                        break;
                    }
                }
            }
        };
        return ErpResponseJson.ok(keyDetail);
    }

    /**
     * 查询二维码数据页面
     *
     * @return
     * @author 李成兵
     * @since 2017年10月11日
     */
    @RequestMapping("/houseCheckQrCode")
    public ModelAndView getHouseCheckQrCode(ModelAndView model, String param) {
        model.addObject("param", param);
        model.setViewName("house/houseCheckQrCode");
        return model;
    }

    /**
     * 查询二维码数据页面
     *
     * @return
     * @author 李成兵
     * @since 2017年10月11日
     */
    @RequestMapping("/houseCheckQrCodeData")
    @ResponseBody
    public void houseCheckQrCodeData(String param, HttpServletResponse response, HttpSession session) throws Exception {
        if (StringUtil.isBlank(param)) {
            return;
        }
        // 解密param
        String decode = AESHelper.decode(param);
        Map<String, String> tempMap = JSON.parseObject(decode, new TypeReference<HashMap<String, String>>() {
        });
        String compNo = tempMap.get("compNo");
        String caseId = tempMap.get("caseId");
        String caseType = tempMap.get("caseType");
        String cityId = tempMap.get("cityId");
        String checkCodeFun = "";
        if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
            ErpFunSale funSaleBySaleId = erpFunSaleMapper.getFunSaleBySaleId(Integer.valueOf(cityId), Integer.valueOf(caseId));
            checkCodeFun = funSaleBySaleId.getCheckCodeFun();
        } else {
            ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(Integer.valueOf(cityId), Integer.valueOf(caseId));
            checkCodeFun = funLeaseByLeaseId.getCheckCodeFun();
        }

        response.setContentType("image/png");
        String urlPath = session.getServletContext().getRealPath("/") + "statics/images/checkCodeLogo.png";
        File f = new File(urlPath);
        String houseCertificateUrl = QRCodeUtil.getHouseCertificateUrl(compNo, checkCodeFun);
        OutputStream outputStream = response.getOutputStream();
        QRCodeUtil.drawLogoQRCode(f, houseCertificateUrl, outputStream);
        outputStream.flush();
    }

    /**
     * 房源查询楼盘
     *
     * @param searchKey:查询关键字
     * @return
     * @author lcb
     * @date 2018/6/11
     */
    @RequestMapping("/getBuildingInfoList")
    @ResponseBody
    @NotBlank("searchKey")
    public ResponseJson getBuildingInfoList(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        String searchKey = param.getString("searchKey");
        Integer buildingFlag = param.getInteger("buildingFlag");

        List<ErpBuildingInfoDto> buildInfoList = erpBuildingInfoMapper.selectBuildingInfoList(cityId, searchKey, buildingFlag);
        // 查询楼盘是否锁定
        if (buildInfoList.size() > 0) {
            List<Integer> buildIdList = buildInfoList.stream().collect(Collectors.mapping(val -> val.getBuildId(), Collectors.toList()));
            Map<Integer, Byte> buildSetSettingMap = new HashMap(buildIdList.size());
            Map<Integer, String> buildSectionMap = new HashMap(buildIdList.size());
            Map<Integer, String> buildRegMap = new HashMap(buildIdList.size());

            if (buildIdList.size() > 0) {
                ErpBuildingSetSettingExample example = new ErpBuildingSetSettingExample();
                example.setShardCityId(cityId);
                example.createCriteria().andBuildIdIn(buildIdList);
                List<ErpBuildingSetSetting> erpBuildingSetSettings = erpBuildingSetSettingMapper.selectByExample(example);
                // 转map
                buildSetSettingMap = erpBuildingSetSettings.stream().collect(Collectors.toMap(val -> val.getBuildId(), val -> val.getBuildLock()));
            }

            List<Integer> buildSectionIdList = buildInfoList.stream().collect(Collectors.mapping(val -> val.getSectionId(), Collectors.toList()));
            if (buildSectionIdList.size() > 0) {
                // 查询sectionName
                ErpFunSectionExample sectionExample = new ErpFunSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andSectionIdIn(buildSectionIdList);
                List<ErpFunSection> erpFunSections = erpFunSectionMapper.selectByExample(sectionExample);
                // 转map
                buildSectionMap = erpFunSections.stream().collect(Collectors.toMap(val -> val.getSectionId(), val -> val.getSectionName()));
            }

            // 查询regName
            List<Integer> buildRegionIdList = buildInfoList.stream().collect(Collectors.mapping(val -> val.getBuildRegion(), Collectors.toList()));
            if (buildRegionIdList.size() > 0) {
                ErpFunRegExample regExample = new ErpFunRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andRegIdIn(buildRegionIdList);
                List<ErpFunReg> erpFunRegList = erpFunRegMapper.selectByExample(regExample);
                // 转map
                buildRegMap = erpFunRegList.stream().collect(Collectors.toMap(val -> val.getRegId(), val -> val.getRegName()));
            }

            for (ErpBuildingInfoDto erpBuildingInfoDto : buildInfoList) {
                Byte buildLock = buildSetSettingMap.get(erpBuildingInfoDto.getBuildId());
                if (null != buildLock) {
                    erpBuildingInfoDto.setBuildLock(buildLock.intValue());
                }

                if (null != erpBuildingInfoDto.getSectionId()) {
                    String sectionName = buildSectionMap.get(erpBuildingInfoDto.getSectionId());
                    erpBuildingInfoDto.setSectionName(sectionName);
                }
                if (null != erpBuildingInfoDto.getBuildRegion()) {
                    String regName = buildRegMap.get(erpBuildingInfoDto.getBuildRegion());
                    erpBuildingInfoDto.setRegName(regName);
                }
            }
        }
        return ErpResponseJson.ok(buildInfoList);
    }


    /**
     * 获取加密和推荐条数，提出来，都可以调用
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/23
     */
    @ResponseBody
    @RequestMapping("/getPwdCount")
    public ResponseJson getPwdCount(@Valid @RequestBody BaseMapParam param) {
        Integer caseType = param.getInteger("caseType");
        Integer infoOwnerId = param.getInteger("infoOwnerUserId");
        Integer cityId = getOperator().getCityId();
        Integer archiveId = getOperator().getArchiveId();

        //获取本人推荐加密条数
        Integer[] houseLevel = getSpecialCaseCount(infoOwnerId, caseType);
        Integer countCommed = houseLevel[0];
        Integer countPws = houseLevel[1];
        Integer countTencent = 0;//腾讯上架数
        //腾讯上架逻辑 只有房源才统计腾讯上架数
        if (caseType == Const.DIC_CASE_TYPE_SALE_FUN
                || caseType == Const.DIC_CASE_TYPE_LEASE_FUN) {
            countTencent = erpFunHousePublishStatusMapper.getQQPublishCount(cityId, archiveId);
        }
        Map<String, Integer> dataMap = new HashMap<>();
        dataMap.put("recommend", countCommed);//推荐
        dataMap.put("encrypt", countPws);//加密
        dataMap.put("tencentSend", countTencent);//腾讯上架数 添加
        List<Map<String, Integer>> list = new ArrayList<>();
        list.add(dataMap);
        return ErpResponseJson.ok(list);
    }

    /**
     * 根据出租房源ID获得与之匹配的客户
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/3
     * 
     * 2019-11-22-陈文超将该方法停用，并统一移植到houseCustWeb项目中
     */
    @ResponseBody
    @RequestMapping("/getHouseLeaseMateCliList")
    @Deprecated
    public ResponseJson getHouseLeaseMateCliList(@Valid @RequestBody BaseMapParam param) {
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
        ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
        if (erpFunLease == null) {
            throw new BusinessException("请求的房源未找到");
        }
        if (null != erpFunLease.getBuildId()) {
            param.setString("buildId", "%" + erpFunLease.getBuildId() + "%");
        }
        // 这个不能为null
        if (StringUtils.isBlank(matchItem)) {
            matchItem = "";
        }
        if (matchItem.contains("AREA")) {
            param.setObject("area", erpFunLease.getLeaseArea());
        }
        if (matchItem.contains("FLOOR")) {
            param.setObject("floor", erpFunLease.getLeaseFloor());
        }
        if (matchItem.contains("PRICE")) {
            param.setObject("totalPrice", erpFunLease.getLeaseTotalPrice());
        }
        if (matchItem.contains("ROOM")) {
            param.setObject("leaseRoom", erpFunLease.getLeaseRoom());
        }
        param.setObject("leaseUsage", erpFunLease.getLeaseUseage());
        param.setObject("region", erpFunLease.getLeaseReg());
        String isUseCreationTimeQuery = erpSysParaMapper.getParamValue(cityId, currentCompId, "IS_USE_CREATION_TIME_QUERY");
        param.setString("isUseCreationTimeQuery", isUseCreationTimeQuery);
        if (StringUtil.isBlank(orderBy)) {
            if ("1".equals(isUseCreationTimeQuery)) {
                param.setString("orderBy", "CREATION_TIME DESC");
            } else {
                param.setString("orderBy", "AVAILABLE_TIME DESC");
            }
        }

        if (isPerLogin == null || !isPerLogin) {// 不是精英版登录才判断权限
            String operColumn = erpUserOpersService.conditionMixByOperRange(Const.DIC_PLATE_TYPE_ALL_EN, StringUtil.toString(Const.DIC_CASE_TYPE_RENT_CUST), cityId, currentCompId, currentUserId, currentGrId, compType, userPosition);
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
        List<ErpFunRentCustomer> rentCustomerList = erpFunRentCustomerMapper.getMatchRentCustomerList(cityId, param.getMap());
        ErpResponseJson json = new ErpResponseJson();
        if (StringUtil.isBlank(compBound) || Constants_DIC.DIC_BOUND_0.equals(compBound)) {
            json.setData(rentCustomerList);
            return json;
        }
        if (rentCustomerList == null || rentCustomerList.size() <= 0) {
            json.setData(rentCustomerList);
            return json;
        }
        Set<Integer> userIdSet = new HashSet<>();
        rentCustomerList.stream().forEach(erpFunRentCustomer -> {
            userIdSet.add(erpFunRentCustomer.getUserId());
        });
        if (userIdSet.size() > 0) {// 有用户id时才查询
            List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
            Map<Integer, ErpFunUsers> userMap = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, user -> user));
            // 拼userName
            List<ErpFunRentCustomerDto> resultVos = new LinkedList<>();
            rentCustomerList.stream().forEach(erpFunRentCustomer -> {
                ErpFunUsers funUsers = userMap.get(erpFunRentCustomer.getUserId());
                ErpFunRentCustomerDto erpFunRentCustomerDto = new ErpFunRentCustomerDto();
                erpFunRentCustomerDto.setErpFunRentCustomer(erpFunRentCustomer);
                if (funUsers != null) {
                    erpFunRentCustomerDto.setUserName(funUsers.getUserName());
                }
                resultVos.add(erpFunRentCustomerDto);
            });
            json.setData(resultVos);
            return json;
        }
        json.setData(rentCustomerList);
        json.setTotal(Long.valueOf(rentCustomerList.size()));
        return json;
    }

    /**
     * 驱动手机播放对应的720图片
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/14
     */
    @ApiOperation("驱动手机播放对应的720图片")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
    @ResponseBody
    @RequestMapping("/letAppShowVR")
    public ResponseJson letAppShowVR(@Valid @RequestBody BaseMapParam param) {
        Integer caseType = param.getInteger("caseType");
        Integer caseId = param.getInteger("caseId");
        Map<String, Object> postParam = new HashMap<>();
        postParam.put("caseType", caseType);
        postParam.put("caseId", caseId);
        postParam.put("archiveId", getOperator().getArchiveId());
        postParam.put("cityId", getOperator().getCityId());
        postParam.put("action", "openScene");
        String postResult = null;
        try {
            AdminSysPara adminSysParaPO = adminSysParaMapper.getAdminSysParaById("ERP_OPEN_APP_VR_URL");
            postResult = HttpUtil.post(adminSysParaPO.getParamValue(), postParam);
            if (StringUtils.isNotEmpty(postResult)) {
                postResult = postResult.trim();
            }
            Map<String, String> resultMap = JSON.parseObject(postResult, new TypeReference<HashMap<String, String>>() {
            });
            // {"status":"1","data":""} status=1就是成功0就是失败
            if (resultMap != null && "1".equals(resultMap.get("status"))) {
                return ErpResponseJson.ok();
            }
        } catch (Exception e) {
            throw new BusinessException("打开手机VR失败");
        }
        throw new BusinessException("打开手机VR失败");
    }

    /**
     * 房勘跟进时删除图片
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/14
     */
    @ApiOperation("房勘跟进时删除图片")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @ResponseBody
    @PostMapping("/deleteFangKanPhoto")
    @NotBlank("picIds")
    public ResponseJson deleteFangKanPhoto(@Valid @RequestBody houseParam param) {
        String picIds = param.getPicIds();//图片的ID格式：1,2,3,4,5...
        Integer userId = getOperator().getUserId();
        Integer cityId = getOperator().getCityId();
        if (StringUtil.isNotBlank(picIds)) {
            String[] photoIds = picIds.split(",");
            erpFunPhotoMapper.updateFangKanPhoto(cityId, userId, getTimeNow(), photoIds);
        }
        return ErpResponseJson.ok();
    }

    /**
     * 获取本人推荐加密条数
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/6/23
     */
    private Integer[] getSpecialCaseCount(Integer infoOwnerId, Integer caseType) {
        Integer[] result = new Integer[]{0, 0};
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer deptId = getOperator().getDeptId();

        if (infoOwnerId == null) {
            throw new BusinessException("信息所属人不存在，请检查数据是否正确！");
        }
        if (caseType == Const.DIC_CASE_TYPE_SALE_FUN) {
            List<ErpFunSaleDto> erpFunSaleList = erpFunSaleMapper.getSpecialListCount(cityId, compId, deptId, infoOwnerId);
            for (ErpFunSaleDto erpFunSaleDto : erpFunSaleList) {
                Integer level = erpFunSaleDto.getLevel();
                if (level == 2) {
                    result[0] = erpFunSaleDto.getAttrname();
                } else if (Const.DIC_HOUSE_LEVEL_PASSWORD == level.byteValue()) {
                    result[1] = erpFunSaleDto.getAttrname();
                }
            }
        } else if (caseType == Const.DIC_CASE_TYPE_LEASE_FUN) {
            List<ErpFunLeaseDto> erpFunLeaseDtoList = erpFunLeaseMapper.getSpecialListCount(cityId, compId, deptId, infoOwnerId);
            for (ErpFunLeaseDto erpFunLeaseDto : erpFunLeaseDtoList) {
                Integer level = erpFunLeaseDto.getLevel();
                if (level == 2) {
                    result[0] = erpFunLeaseDto.getAttrname();
                } else if (Const.DIC_HOUSE_LEVEL_PASSWORD == level.byteValue()) {
                    result[1] = erpFunLeaseDto.getAttrname();
                }
            }

        } else if (caseType == Const.DIC_CASE_TYPE_BUY_CUST) {
            List<ErpFunBuyCustomerDto> erpFunBuyCustomerDtoList = erpFunBuyCustomerMapper.getSpecialListCount(cityId, compId, deptId, infoOwnerId);
            for (ErpFunBuyCustomerDto erpFunBuyCustomerDto : erpFunBuyCustomerDtoList) {
                Integer level = erpFunBuyCustomerDto.getLevel();
                if (level == 2) {
                    result[0] = erpFunBuyCustomerDto.getAttrname();
                } else if (Const.DIC_HOUSE_LEVEL_PASSWORD == level.byteValue()) {
                    result[1] = erpFunBuyCustomerDto.getAttrname();
                }
            }

        } else if (caseType == Const.DIC_CASE_TYPE_RENT_CUST) {
            List<ErpFunRentCustomerDto> erpFunRentCustomerDtoList = erpFunRentCustomerMapper.getSpecialListCount(cityId, compId, deptId, infoOwnerId);
            for (ErpFunRentCustomerDto erpFunRentCustomerDto : erpFunRentCustomerDtoList) {
                Integer level = erpFunRentCustomerDto.getLevel();
                if (level == 2) {
                    result[0] = erpFunRentCustomerDto.getAttrname();
                } else if (Const.DIC_HOUSE_LEVEL_PASSWORD == level.byteValue()) {
                    result[1] = erpFunRentCustomerDto.getAttrname();
                }
            }
        }
        return result;
    }

    /**
     * 插入或更新或者删除公司自定义模板数据
     *
     * @param param
     * @return Modified XXX ZangTie 2018年7月23日
     * @author ZangTie
     * @since 2018年7月23日 下午2:25:18
     */
	@ApiOperation("插入或更新或者删除公司自定义模板数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = UpdateOrCreateTmpVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/updateOrCreateTmp")
	public ResponseJson updateOrCreateTmp(@Valid @RequestBody UpdateOrCreateTmpParam param){
		UpdateOrCreateTmpVo vo = new UpdateOrCreateTmpVo();
		Integer tid = param.getTid();
		if (tid != null) {
			// 删除逻辑
			adminFunTempletMapper.deleteByPrimaryKey(tid);
		} else {
			// 新增或者更新逻辑
			String richText = param.getRichText();
			Byte caseType = param.getCaseType();
			Integer cityId = getOperator().getCityId();
			Integer compId = getOperator().getCompId();
			Integer archiveId = getOperator().getArchiveId();
			Integer queryType = param.getQueryType();// 0为公司 1为个人
			String oper = param.getOper();
			AdminFunTemplet adminFunTemplet = getParamObj(AdminFunTemplet.class);
			if (StringUtil.isNotEmpty(richText)) {
				richText = richText.replaceAll("(<!--\\[if gte mso [\\d]*\\]><xml>[\\s\\S]+?\\[endif\\]-->)", "");
				richText = richText.replaceAll("(<!--\\[if gte mso [\\d]*\\]>[\\s\\S]+?endif\\]-->)", "");
				richText = richText.replaceAll("(?i)(<script[\\s\\S]*?>[\\s\\S]*?</script>)", "");
				richText = richText.trim();
			}
			adminFunTemplet.setCharactTemplet(richText);
			adminFunTemplet.setSaleLease(caseType);
			adminFunTemplet.setTypesFlag("111111");// 包含哪些内容在模板中，111111表示适用于所有要求,100000:表示包含BNAME（楼盘名称）,011000:表示包含FITMENT（装修）和ROOM(几室),以此类推,BNAME:1,FITMENT:2,ROOM:3,PRICE:4,AREA:5,DIRECT:6
			adminFunTemplet.setHouseUseage((byte)0);
			adminFunTemplet.setUseCount(0);
			adminFunTemplet.setCityId(cityId);
			adminFunTemplet.setCompId(compId);
			adminFunTemplet.setUpdatetime(new Date());
			if (queryType != null && queryType == 1) {
				adminFunTemplet.setArchiveId(archiveId);
			}
			if ("1".equals(oper)) {
				// 更新
				Integer tempid = param.getTempid();
				AdminFunTempletExample adminFunTempletExample = new AdminFunTempletExample();
				Criteria createCriteria = adminFunTempletExample.createCriteria();
				createCriteria.andIdEqualTo(tempid).andCityIdEqualTo(cityId).andCompIdEqualTo(compId);
				if (queryType != null && queryType == 1) {
					createCriteria.andArchiveIdEqualTo(archiveId);
				}
				adminFunTempletMapper.updateByExampleSelective(adminFunTemplet, adminFunTempletExample);
			} else {
				// 新增
				adminFunTempletMapper.insertSelective(adminFunTemplet);
			}
		}
		vo.setStatus("SUCCESS");
		return ErpResponseJson.ok(vo);
	}

    /**
     * 查看委托带看确认书模版
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/8/6
     */
    @ApiOperation("查看委托书或带看确认书模版")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunProxyTemplateVo.class, message = "成功")
    })
    @ResponseBody
    @PostMapping("/getProxyTemplate")
    @NotBlank("templateType")
    public ResponseJson getProxyTemplate(@Valid @RequestBody ProxyTemplateParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Byte templateType = param.getTemplateType();
        Byte caseType = param.getCaseType();
        List<ErpFunProxyTemplate> erpFunProxyTemplate = erpFunProxyTemplateMapper.getFunProxyTemplateByCompId(cityId, compId, templateType, caseType);
        if (erpFunProxyTemplate.size() == 0) {

            erpFunProxyTemplate = erpFunProxyTemplateMapper.getFunProxyTemplateByCompId(cityId, 0, templateType, caseType);

            ErpFunProxyTemplate funProxyTemplate = erpFunProxyTemplate.get(0);
            funProxyTemplate.setId(null);
            funProxyTemplate.setCompId(compId);
            funProxyTemplate.setShardCityId(cityId);
            erpFunProxyTemplateMapper.insertSelective(funProxyTemplate);

            if (erpFunProxyTemplate.size() > 0) {
                erpFunProxyTemplate.forEach(val -> {
                    val.setId(funProxyTemplate.getId());
                });
            }
        }
        return ErpResponseJson.ok(erpFunProxyTemplate);
    }

    /**
     * 委托带看确认书保存
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/8/6
     */
    @ApiOperation("委托书或带看确认书模版保存")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @ResponseBody
    @PostMapping("/saveProxyTemplate")
    @NotBlank("templateType")
    public ResponseJson saveProxyTemplate(@Valid @RequestBody ProxyTemplateParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();

        Byte templateType = param.getTemplateType();
        String templateContent = param.getTemplateContent();
        Byte caseType = param.getCaseType();
        Integer id = param.getId();
        erpFunProxyTemplateService.saveProxyTemplate(cityId, compId, id, templateType, caseType, templateContent);
        return ErpResponseJson.ok();
    }

    /**
     * 委托书或带看确认书模版重置
     * @param
     * @return
     * @auther 王震平
     * @since 2018/10/26
     */
    @ApiOperation("委托书或带看确认书模版重置")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List",response = com.myfun.repository.erpdb.po.ErpFunProxyTemplate.class, message = "成功")
    })
    @ResponseBody
    @PostMapping("/restProxyTemplate")
    @NotBlank("templateType")
    public ResponseJson restProxyTemplate(@Valid @RequestBody ProxyTemplateParam param) {
        Operator operator = getOperator();
        Integer compId = getOperator().getCompId();
        Byte templateType = param.getTemplateType();
        Byte caseType = param.getCaseType();
        Integer cityId = getOperator().getCityId();
        param.setCityId(cityId);
        List<ErpFunProxyTemplate> paramList = new ArrayList<>(3);
        if(1 == param.getTemplateType().intValue()) {
            paramList = erpFunProxyTemplateMapper.getFunProxyTemplateByCompId(cityId, 0, templateType, caseType);
        }else {
            paramList = erpFunProxyTemplateMapper.getFunProxyTemplateByCompId(cityId, 0, templateType, null);
        }
        if(paramList.size() == 0) {
            throw new BusinessException("模板库异常，请联系在线客服");
        }
        param.setTemplateContent(paramList.get(0).getTemplateContent());
        param.setCompId(compId);
        erpFunProxyTemplateService.resetTemplateContent(cityId, param);
        return ErpResponseJson.ok(paramList);
    }
    
	@ApiOperation(value = "图片删除[移植remove]")
	@ApiImplicitParam(dataTypeClass = RemovePhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ResponseBody
	@ApiResponses(value = { @ApiResponse(code = 200, message = "删除成功", response = ErpResponseJson.class) })
	@PostMapping("/removePhoto")
	ResponseJson remove(@Valid @RequestBody RemovePhotoParam removePhotoParam) throws Exception {
		Integer photoId = removePhotoParam.getPhotoId();
		Integer caseId = removePhotoParam.getCaseId();
		Byte caseType = removePhotoParam.getCaseType();

		Integer trackId = writeTrackByUploadPhotoAndUploadHouseSourceInfo(removePhotoParam.getCaseNo(),caseId, caseType, "REMOVE", (0 - 1), "null", true, null);
		ErpFunPhoto erpFunPhoto = new ErpFunPhoto();
		erpFunPhoto.setPhotoId(photoId);
		erpFunPhoto.setShardCityId(getOperator().getCityId());
		erpFunPhoto.setTrackId(trackId);
		erpFunPhoto.setTransmitFlag((byte) 2);
		erpFunPhoto.setDelUser(getOperator().getUserId());
		erpFunPhoto.setDelTime(DateTimeHelper.getSystemDate());
		
		ErpFunPhotoExample example = new ErpFunPhotoExample();
		example.createCriteria().andPhotoIdEqualTo(photoId);
		example.createCriteria().andTransmitFlagNotEqualTo((byte) 2);
		example.setShardCityId(getOperator().getCityId());
		erpFunPhotoMapper.updateByExampleSelective(erpFunPhoto, example);

		return ErpResponseJson.ok();
	}
	
	
	//	writeTrackByUploadPhotoAndUploadHouseSourceInfo(caseId, caseType, "REMOVE", (0 - 1), "null", true, null);
	public Integer writeTrackByUploadPhotoAndUploadHouseSourceInfo(String caseNo, Integer caseId, Byte caseType,
			String flag, Integer photoCount, String thumbPic, boolean isNeedCreateTrack, String trackUser)
			throws Exception {
		HashMap<String, String> inputHM = new HashMap<String, String>();
		Map<String, Object> resultMap = getUserAndDeptByCaseIdOffCaseType(caseType, caseId);
		Operator operator = getOperator();
		Integer nowUser = getOperator().getUserId();
		String nowTime = DateTimeHelper.getTimeNow();
		String trackContent = "";
		Byte trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_UPLOAD;
		Byte includeTrackType = null;
		String msgModuleType = null;
		Integer deptId = getOperator().getDeptId();
		String userName = null;
		if (StringUtil.isNotBlank(trackUser)) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByPrimaryKey(Integer.parseInt(trackUser));
			nowUser = Integer.parseInt(trackUser);
			deptId = erpFunUsers.getDeptId();
			userName = erpFunUsers.getUserName();
		} else {
			userName = operator.getUserName();
		}
		Integer trackId = null;
		Byte isDelTrack = 0;
		if (flag.equals("UPLOAD")) {
			if (StringUtil.isNotBlank(thumbPic)) {
				trackContent = userName + " 上传图片时设置了首图";
			} else {
				trackContent = userName + " 上传了图片";
			}
			includeTrackType = Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE_BYTE;
			msgModuleType = MsgModuleType.UPLOAD_PHOTO;
		} else if (flag.equals("REMOVE")) {
			trackContent = userName + " 删除了" + (0 - photoCount) + "张图片";// 变成正数写入跟进
			isDelTrack = 1;
			trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_DELETE;
			includeTrackType = Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE_BYTE;
			msgModuleType = MsgModuleType.DELETE_PHOTO;
			inputHM.put("IS_DELTRACK", "1");
		} else if ("FAFAUPLOAD".equals(flag)) {// 陈文超添加，用于发发同步导入功能。
			trackContent = "从发发导入了图片";
			trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_IMPORT;
			inputHM.put("INCLUDE_TRACK", Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE);
		} else if ("EDITOR".equals(flag)) {
			if (StringUtil.isNotBlank(thumbPic)) {
				trackContent = "编辑图片时设置了首图";
				trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_TOP;
			} else {
				trackContent = "编辑了图片";
				trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_EDIT;
			}
			includeTrackType = Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE_BYTE;
		} else if ("AUTO".equals(flag)) {
			if (StringUtil.isNotBlank(thumbPic)) {
				trackContent = "系统自动设置了首图";
				trackType = Constants_DIC.DIC_TRACK_TYPE_PHOTO_TOP;
				includeTrackType = Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE_BYTE;
			} else {
				return null;// 没有跟进内容就不写跟进了
			}
		}

		ErpFunTrack erpFunTrack = new ErpFunTrack();
		erpFunTrack.setShardCityId(operator.getCityId());
		erpFunTrack.setDeptId(deptId);
		erpFunTrack.setCompId(operator.getCompId());
		erpFunTrack.setCaseId(caseId);
		erpFunTrack.setCaseNo(caseNo);
		erpFunTrack.setCaseType(caseType);
		erpFunTrack.setTrackType(trackType);
		erpFunTrack.setTrackClassic(Constants_DIC.DIC_TRACKCLASSIC_10);
		erpFunTrack.setTrackContent(trackContent);
		erpFunTrack.setTrackWarm(false);
		erpFunTrack.setCreatorUid(nowUser);
		erpFunTrack.setCreationTime(nowTime);
		erpFunTrack.setIncludeTrack(includeTrackType);
		erpFunTrack.setIsDeltrack(isDelTrack);
		if (resultMap.get("USER_ID") != null) {
			erpFunTrack.setCaseUserId(Integer.parseInt(resultMap.get("USER_ID").toString()));
		}
		if (resultMap.get("DEPT_ID") != null) {
			erpFunTrack.setCaseDeptId(Integer.parseInt(resultMap.get("DEPT_ID").toString()));
		}

		if (!getOperator().isPersonalVersion()) {
			String grName = "";
			if (!getOperator().isPersonalVersion() && StringUtil.isNotBlank(operator.getGrId().toString())
					&& (operator.getGrId() != 0)) {
				ErpFunDeptsgroup erpFunDeptsgroup = new ErpFunDeptsgroup();
				erpFunDeptsgroup.setGrId(getOperator().getGrId());
				erpFunDeptsgroup.setShardCityId(operator.getCityId());
				erpFunDeptsgroup = erpFunDeptsgroupMapper.selectByPrimaryKey(erpFunDeptsgroup);
				grName = erpFunDeptsgroup.getGrName();
			}

			erpFunTrack.setGrName(grName);
			erpFunTrack.setGrId(operator.getGrId());
			erpFunTrack.setDeptName(operator.getDeptCName());
			;
		}

		// 搜搜转入时不需要创建图片跟进，由传入参数控制
		if (isNeedCreateTrack) {
			erpFunTrackMapper.insertSelective(erpFunTrack);
			trackId = erpFunTrack.getTrackId();
			// 给房源所属人写推送消息，有人给他的房源删除或上传了图片
			if (msgModuleType != null) {
				Object object = resultMap.get("Object");
				AdminFunUserMessage infoadminFunUserMessage = getUserMessage(object, caseId, caseType, true);
				if (infoadminFunUserMessage != null) {
					infoadminFunUserMessage.setModuleType(Integer.parseInt(msgModuleType));
					infoadminFunUserMessage.setMsgContent(trackContent);
					TaskQueueThread.sendMessage(infoadminFunUserMessage);
				}
			}
		}

		if (!"null".equals(thumbPic) && StringUtil.isNotBlank(thumbPic)) {
			String dateTime = DateTimeHelper.getSystemTime() + "";
			// 触发首图的更新和网站数据同步--这样写方便同步程序的拦截， 故不使用直接SQL语句的形式 陈文超写
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)) {
				ErpFunSale erpFunSale = new ErpFunSale();
				erpFunSale.setCityId(operator.getCityId());
				erpFunSale.setShardCityId(operator.getCityId());
				erpFunSale.setSaleId(caseId);
				erpFunSale.setThumbpicVer(dateTime);
				erpFunSale.setThumbUrl(thumbPic);
				erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
			} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)) {
				ErpFunLease erpFunLease = new ErpFunLease();
				erpFunLease.setCityId(operator.getCityId());
				erpFunLease.setShardCityId(operator.getCityId());
				erpFunLease.setLeaseId(caseId);
				erpFunLease.setThumbpicVer(dateTime);
				erpFunLease.setThumbUrl(thumbPic);
				erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
			}
		}

		// 写最后跟进时间
		if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN)) {
			// 上传图片写跟进更新房源跟进时间以及首图缩略图
			updateHouseSourceTrackTimeByUploadPhoto(caseId, caseType, flag, photoCount, resultMap.get("Object"));
			// 修改图片之后同步一下信息，图片张数、首图等
			erpFunSaleService.synchronizeSaleLeaseHouse(caseId, caseType, (ErpFunSale) resultMap.get("Object"));
		} else if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN)) {
			// 上传图片写跟进更新房源跟进时间以及首图缩略图
			updateHouseSourceTrackTimeByUploadPhoto(caseId, caseType, flag, photoCount, resultMap.get("Object"));
			erpFunLeaseService.synchronizeSaleLeaseHouse(caseId, caseType, (ErpFunLease) resultMap.get("Object"));
		}
		return trackId;
	}

	public Map<String, Object> getUserAndDeptByCaseIdOffCaseType(Byte caseType, Integer caseId) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Operator operator = getOperator();
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)) {
			ErpFunSale erpFunSale = new ErpFunSale();
			erpFunSale.setCityId(operator.getCityId());
			erpFunSale.setShardCityId(operator.getCityId());
			erpFunSale.setSaleId(caseId);
			erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
			if (erpFunSale != null) {
				resultMap.put("USER_ID", erpFunSale.getUserId());
				resultMap.put("DEPT_ID", erpFunSale.getDeptId());
				resultMap.put("Object", erpFunSale);
			}
		} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)) {
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setCityId(operator.getCityId());
			erpFunLease.setShardCityId(operator.getCityId());
			erpFunLease.setLeaseId(caseId);
			erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
			if (erpFunLease != null) {
				resultMap.put("USER_ID", erpFunLease.getUserId());
				resultMap.put("DEPT_ID", erpFunLease.getDeptId());
				resultMap.put("Object", erpFunLease);
			}
		} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = new ErpFunBuyCustomer();
			erpFunBuyCustomer.setCityId(operator.getCityId());
			erpFunBuyCustomer.setShardCityId(operator.getCityId());
			erpFunBuyCustomer.setBuyCustId(caseId);
			erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(erpFunBuyCustomer);
			if (erpFunBuyCustomer != null) {
				resultMap.put("USER_ID", erpFunBuyCustomer.getUserId());
				resultMap.put("DEPT_ID", erpFunBuyCustomer.getDeptId());
				resultMap.put("Object", erpFunBuyCustomer);
			}
		} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(caseType)) {// TODO 该方法需确认后使用
			ErpFunRentCustomer erpFunRentCustomer = new ErpFunRentCustomer();
			ErpFunRentCustomerKey erpFunRentCustomerKey = new ErpFunRentCustomerKey();
			erpFunRentCustomerKey.setShardCityId(operator.getCityId());
			erpFunRentCustomerKey.setRentCustId(caseId);
			erpFunRentCustomer = erpFunRentCustomerMapper.selectByPrimaryKey(erpFunRentCustomerKey);
			if (erpFunRentCustomer != null) {
				resultMap.put("USER_ID", erpFunRentCustomer.getUserId());
				resultMap.put("DEPT_ID", erpFunRentCustomer.getDeptId());
				resultMap.put("Object", erpFunRentCustomer);
			}
		}
		return resultMap;
	}

	public AdminFunUserMessage getUserMessage(Object object, Integer caseId, Byte caseType, Boolean judgeNowUser)
			throws Exception {
		AdminFunUserMessage adminFunUserMessage = new AdminFunUserMessage();
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)) {
			ErpFunSale erpFunSale = (ErpFunSale) object;
			// 需要判断不是本人
			if (erpFunSale == null || (judgeNowUser && (erpFunSale.getArchiveId() == null
					|| getOperator().getArchiveId() == erpFunSale.getArchiveId()))) {
				return null;
			}
			// 非私盘数据不推送
			if (!Constants_DIC.DIC_PLATE_TYPE_PRIVATE.equals(erpFunSale.getPlateType().toString())) {
				return null;
			}
			adminFunUserMessage.setArchiveId(erpFunSale.getArchiveId());
			adminFunUserMessage.setHouseUseage(erpFunSale.getSaleUseage());
			adminFunUserMessage.setCaseNo(erpFunSale.getSaleNo());
			adminFunUserMessage.setMsgModule(Integer.parseInt(MsgModule.HOUSE));
		} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)) {
			ErpFunLease erpFunLease = (ErpFunLease) object;
			// 需要判断不是本人
			if (erpFunLease == null || (judgeNowUser && (erpFunLease.getArchiveId() == null
					|| getOperator().getArchiveId() == erpFunLease.getArchiveId()))) {
				return null;
			}
			// 非私盘数据不推送
			if (!Constants_DIC.DIC_PLATE_TYPE_PRIVATE.equals(erpFunLease.getPlateType().toString())) {
				return null;
			}
			adminFunUserMessage.setArchiveId(erpFunLease.getArchiveId());
			adminFunUserMessage.setHouseUseage(erpFunLease.getLeaseUseage());
			adminFunUserMessage.setCaseNo(erpFunLease.getLeaseNo());
			adminFunUserMessage.setMsgModule(Integer.parseInt(MsgModule.HOUSE));
		} else if (Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(caseType)) {
			ErpFunBuyCustomer erpFunBuyCustomer = (ErpFunBuyCustomer) object;
			if (erpFunBuyCustomer == null || (judgeNowUser && (erpFunBuyCustomer.getArchiveId() == null
					|| getOperator().getArchiveId() == erpFunBuyCustomer.getArchiveId()))) {
				return null;
			}
			// 非私盘数据不推送
			if (!Constants_DIC.DIC_PLATE_TYPE_PRIVATE.equals(erpFunBuyCustomer.getPlateType().toString())) {
				return null;
			}
			adminFunUserMessage.setArchiveId(erpFunBuyCustomer.getArchiveId());
			if (StringUtil.isNotBlank(erpFunBuyCustomer.getHouseUseage())) {
				adminFunUserMessage.setHouseUseage(Byte.valueOf(erpFunBuyCustomer.getHouseUseage()));
			}
			adminFunUserMessage.setCaseNo(erpFunBuyCustomer.getBuyCustNo());
			adminFunUserMessage.setMsgModule(Integer.parseInt(MsgModule.CUST));
		} else if (Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(caseType)) {
			ErpFunRentCustomer erpFunRentCustomer = (ErpFunRentCustomer) object;
			if (erpFunRentCustomer == null || (judgeNowUser && (erpFunRentCustomer.getArchiveId() == null
					|| getOperator().getArchiveId() == erpFunRentCustomer.getArchiveId()))) {
				return null;
			}
			// 非私盘数据不推送
			if (!Constants_DIC.DIC_PLATE_TYPE_PRIVATE.equals(erpFunRentCustomer.getPlateType().toString())) {
				return null;
			}
			adminFunUserMessage.setArchiveId(erpFunRentCustomer.getArchiveId());
			if (StringUtil.isNotBlank(erpFunRentCustomer.getHouseUseage())) {
				adminFunUserMessage.setHouseUseage(Byte.valueOf(erpFunRentCustomer.getHouseUseage()));
			}
			adminFunUserMessage.setCaseNo(erpFunRentCustomer.getRentCustNo());
			adminFunUserMessage.setMsgModule(Integer.parseInt(MsgModule.CUST));
		} else {
			return null;
		}
		adminFunUserMessage.setCaseType(Integer.parseInt(caseType.toString()));
		adminFunUserMessage.setCaseId(caseId);
		adminFunUserMessage.setCityId(getOperator().getCityId());
		adminFunUserMessage.setAppType(1);// 1=ERP
		adminFunUserMessage.setIsDel((byte) 0);// 默认未删除
		adminFunUserMessage.setCreationTime(DateTimeHelper.getSystemDate());
		adminFunUserMessage.setCreateArchiveId(getOperator().getArchiveId());
		adminFunUserMessage.setCreateUserName(getOperator().getUserName());
		adminFunUserMessage.setCompId(getOperator().getCompId());
		return adminFunUserMessage;
	}

	public void updateHouseSourceTrackTimeByUploadPhoto(Integer caseId, Byte caseType, String flag, Integer photoCount,
			Object object) throws Exception {
		StringBuffer updateLocalSqlStr = new StringBuffer();
		String tableName = "";
		String idField = "";
		String mapField = "";
		String photoNum = null;
		if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE)) {
			idField = "SALE_ID";
			mapField = "SALE_MAP";
			tableName = " FUN_SALE SET ";
		} else if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE)) {
			idField = "LEASE_ID";
			mapField = "LEASE_MAP";
			tableName = " FUN_LEASE SET ";
		}
		// 如果图片数量变更photoCount 为0 则 没有更新房源图片数量
		if (!flag.equals("EDITOR") && photoCount != 0) {
			updateLocalSqlStr.append(" UPDATE " + tableName);
			if (flag.equals("REMOVE")) {
				String mapCount = mapField + " + " + photoCount;
				updateLocalSqlStr.append(" THUMB_URL = iif(" + mapCount + " <= 0, null,THUMB_URL),");
				updateLocalSqlStr.append(mapField + " = iif(" + mapCount + " <= 0, 0, " + mapCount + ")" + " ");
			}
			updateLocalSqlStr.append("WHERE " + idField + " = '" + caseId + "'  ");
		}
		// 房源图片从无变成有，写入第一次上传图片时间
		if (flag.equals("UPLOAD") || "FAFAUPLOAD".equals(flag)) {// 陈文超添加方法
			String photoTimeSql = " UPDATE " + tableName + "PHOTO_TIME = GETDATE() WHERE " + idField + " = '" + caseId
					+ "' AND PHOTO_TIME IS NULL AND " + mapField + " = " + photoCount + " ";
			updateLocalSqlStr.append(photoTimeSql);
		}
		// 如果是自己的房源更新跟进时间 由SQL条件判断处理
		updateLocalSqlStr.append(" UPDATE " + tableName + " TRACK_TIME=GETDATE(),SYNC_TIME=GETDATE() WHERE " + idField
				+ " = '" + caseId + "' AND USER_ID='" + getOperator().getUserId() + "'");

		if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE)) {
			erpFunSaleMapper.updateByUserDefineSql(getOperator().getCityId(), updateLocalSqlStr.toString());
		} else {
			erpFunLeaseMapper.updateByUserDefineSql(getOperator().getCityId(), updateLocalSqlStr.toString());
		}

		String trueFlag = null;
		Byte oldTrueFlag = null;
		if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE)) {
			ErpFunSale erpFunSale = (ErpFunSale) object;
			oldTrueFlag = erpFunSale.getTrueFlag();
			trueFlag = judgeTrueHouseForChangeInfo(erpFunSale.getPanoramaMap(), erpFunSale.getSaleMap() == null ? null : erpFunSale.getSaleMap().intValue(),
					erpFunSale.getTrueFlag(), erpFunSale.getVideoNum(), caseType);
		} else if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE)) {
			ErpFunLease erpFunLease = (ErpFunLease) object;
			oldTrueFlag = erpFunLease.getTrueFlag();
			trueFlag = judgeTrueHouseForChangeInfo(erpFunLease.getPanoramaMap(), erpFunLease.getLeaseMap(),
					erpFunLease.getTrueFlag(), Byte.parseByte(erpFunLease.getVideoNum().toString()), caseType);
		}
		// 真房源改为假房源可以改
		if (oldTrueFlag != null && oldTrueFlag.equals(Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_1)
				&& !oldTrueFlag.equals(trueFlag)) {
			if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE)) {
				ErpFunSale erpFunSaleUpdate = new ErpFunSale();
				erpFunSaleUpdate.setCityId(getOperator().getCityId());
				erpFunSaleUpdate.setSaleId(caseId);
				erpFunSaleUpdate.setTrueFlag(Byte.parseByte("1"));
				erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSaleUpdate);
			} else if (caseType.equals(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE)) {
				ErpFunLease erpFunLeaseUpdate = new ErpFunLease();
				erpFunLeaseUpdate.setCityId(getOperator().getCityId());
				erpFunLeaseUpdate.setLeaseId(caseId);
				erpFunLeaseUpdate.setTrueFlag(Byte.parseByte("1"));
				erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLeaseUpdate);
			}
		}
	}

	/**
	 * 删除图片、视频、VR时的一些真房源判断逻辑
	 * 
	 * @throws Exception
	 * @return true 不需要改为假房源，但也不能改为真房源 false 可以改为假房源
	 */
	public String judgeTrueHouseForChangeInfo(Integer panoramaMap, Integer photoMap, Byte trueFlag, Byte videoNum,
			Byte caseType) throws Exception {
		// 投诉下架的，不能修改为假房源0--因为修改之后又可以点亮真房源了
		if (Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_2.equals(trueFlag.toString())) {
			return Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_2;
		}
		if (Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_3.equals(trueFlag.toString())) {
			return Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_3;
		}
		// 新的真房源逻辑
		if (Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_1.equals(trueFlag)) {
			if (StringUtil.paseInteger(photoMap.toString(), 0) < 5) {
				return Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_0;
			}
		}
		return Constants_DIC.DIC_INFO_TRUE_INFO_FLAG_1;
	}
		
}


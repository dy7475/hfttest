package com.myfun.erpWeb.house.controller;

import com.myfun.erpWeb.house.api.MlEntrustApi;
import com.myfun.erpWeb.house.param.*;
import com.myfun.erpWeb.house.vo.*;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunEntrustService;
import com.myfun.service.business.erpdb.ErpFunOrganizationDefinitionService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author HuangJiang
 * @since 2019年11月25日 10:05:49
 * Modified XXX HuangJiang 2019年11月25日
 */
@RestController
public class MlEntrustApiController extends BaseController implements MlEntrustApi {
    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Autowired
    private ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
    @Autowired
    private ErpFunEntrustService erpFunEntrustService;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpFunEntrustCertificateMapper erpFunEntrustCertificateMapper;
    @Autowired
    private ErpFunEntrustFilesMapper erpFunEntrustFilesMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;
    @Autowired
    private ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    private ErpBuildPermissionsMapper erpBuildPermissionsMapper;
    @Autowired
    private ErpUserOpersService erpUserOpersService;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Autowired
    private ErpFunOrganizationDefinitionService erpFunOrganizationDefinitionService;
    @Autowired
    private ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
    @Autowired
    private ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Autowired
    private ErpFunEntrustKpiLogMapper erpFunEntrustKpiLogMapper;
    @Autowired
    private ErpKpiStatisticBrokerPerformanceMapper erpKpiStatisticBrokerPerformanceMapper;
    @Autowired
    private AdminFunCityMapper adminFunCityMapper;

    @Override
    public ResponseJson getHouseEntrustSituation(@RequestBody GetHouseEntrustSituationParam param) throws Exception {
        if (null == param.getCaseId()) {
            return ErpResponseJson.warn("未接收到房源ID参数");
        }
        if (null == param.getCaseType()) {
            return ErpResponseJson.warn("未接收到房源类型参数");
        }
    
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        GetHouseEntrustSituationVO getHouseEntrustSituationVO = new GetHouseEntrustSituationVO();
        Integer hasHisEntrust = 0; // 有无历史委托 0=无；1=有
        Integer canAddEntrust = 0; // 能否新增委托 0=无；1=有
        Integer hasEffectiveEntrust = 0; // 有无当前委托 0=无；1=有
        boolean respiteFlag1 = false; // 暂缓状态标记
        boolean respiteFlag2 = false;
        // 1.判断有无历史委托，同时需要判断是否有权限
        ErpFunEntrustExample erpFunEntrustExample1 = new ErpFunEntrustExample();
        erpFunEntrustExample1.setShardCityId(cityId);
        erpFunEntrustExample1.createCriteria().andCompIdEqualTo(compId).andCaseIdEqualTo(param.getCaseId())
                .andCaseTypeEqualTo(param.getCaseType().byteValue()).andIsEffectiveEqualTo((byte) 0);
        int hisEntrustCount = erpFunEntrustMapper.countByExample(erpFunEntrustExample1);
        if (hisEntrustCount > 0) { // 有历史委托 并且有权限  才有历史委托的入口
            ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, operator.getUserId(), "SEE_HISTORY_ENTRUST");
            if (null != erpUserOpers) {
                hasHisEntrust = 1;
            }
        }
    
        // 判断当前登录人的业务范围（盘源权限）
        Integer buildId = null;
        String houseUsage = "";
        Byte houseStatus = null;
        // 房源类型 1=出售，2=出租
        if (1 == param.getCaseType()) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, param.getCaseId());
            if (null == erpFunSale) {
                return ErpResponseJson.warn("未查询出该房源信息");
            }
            if (null != erpFunSale) {
                buildId = erpFunSale.getBuildId();
                houseUsage = erpFunSale.getSaleUseage().toString();
                houseStatus = erpFunSale.getSaleStatus().byteValue();
            }
        } else if (2 == param.getCaseType()) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, param.getCaseId());
            if (null == erpFunLease) {
                return ErpResponseJson.warn("未查询出该房源信息");
            }
            if (null != erpFunLease) {
                buildId = erpFunLease.getBuildId();
                houseUsage = erpFunLease.getLeaseUseage().toString();
                houseStatus = erpFunLease.getLeaseStatus().byteValue();
            }
        }
        boolean buildPermission = false; // 是否在当前登录人业务范围内
        if (null != buildId && StringUtil.isNotEmpty(houseUsage)) {
            ErpBuildPermissions erpBuildPermissions = new ErpBuildPermissions();
            ErpBuildPermissionsExample erpBuildPermissionsExample = new ErpBuildPermissionsExample();
            erpBuildPermissionsExample.setShardCityId(cityId);
            erpBuildPermissionsExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0).andOrganizationIdEqualTo(operator.getOrganizationId())
                    .andViewPermissionEqualTo((byte) 1).andBuildIdEqualTo(buildId).andHouseUseageLike("%" + houseUsage + "%");
            int count = erpBuildPermissionsMapper.countByExample(erpBuildPermissionsExample);
            if (count > 0) {
                buildPermission = true; // 在业务范围内
            }
        }
        
        // 如果是总经理账号，则默认在业务范围内（盘源权限）
        if (operator.isGeneralManager()) {
            buildPermission = true; // 在业务范围内
        }
        
        // 判断委托共享参数是否开启，如果开启了，还需要判断是否有历史委托
        //String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHARE_ENTRUST_DATA"); 
        String paramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_SHARE_ENTRUST_DATA"); // 租售房源委托资料是否共用 0=否 1=是
        Integer isSaleLease = 0; // 是否是租售房源，1=是，默认=0=否
        Integer saleLeaseId = null;
        if (StringUtil.isNotEmpty(paramValue) && "1".equals(paramValue)) {
            // 判断是否租售房源
            Byte caseType = 1; // 1=出售 2=出租
            if (param.getCaseType() == 1) {
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, param.getCaseId());
                if (Const.DIC_HOUSE_STATUS_RESPITE.equals(erpFunSale.getSaleStatus().byteValue())) {
                    respiteFlag1 = true;
                }
                isSaleLease = erpFunSale.getIsSaleLease().intValue();
                saleLeaseId = erpFunSale.getSaleLeaseId();
                caseType = 2;
            } else {
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, param.getCaseId());
                if (Const.DIC_HOUSE_STATUS_RESPITE.equals(erpFunLease.getLeaseStatus().byteValue())) {
                    respiteFlag1 = true;
                }
                isSaleLease = erpFunLease.getIsSaleLease().intValue();
                saleLeaseId = erpFunLease.getSaleLeaseId();
                caseType = 1;
            }
            
            // 如果是租售房源，则需要用对应的租售ID再次查询委托，判断是否存在委托业务=出售出租委托的有效委托
            if (isSaleLease == 1 && null != saleLeaseId) {
                // 判断有无历史委托
                ErpFunEntrustExample entrustExample = new ErpFunEntrustExample();
                entrustExample.setShardCityId(cityId);
                entrustExample.createCriteria().andCaseIdEqualTo(saleLeaseId).andCaseTypeEqualTo(caseType).andIsEffectiveEqualTo((byte) 0).andIsShareEqualTo((byte) 1);
                int hisCount = erpFunEntrustMapper.countByExample(entrustExample);
                if (hisCount > 0) {
                    ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, operator.getUserId(), "SEE_HISTORY_ENTRUST");
                    if (null != erpUserOpers) {
                        hasHisEntrust = 1;
                    }
                }
                
                ErpFunEntrustExample erpFunEntrustExample3 = new ErpFunEntrustExample();
                erpFunEntrustExample3.setShardCityId(cityId);
                erpFunEntrustExample3.createCriteria().andCaseIdEqualTo(saleLeaseId).andCaseTypeEqualTo(caseType)
                        .andIsEffectiveEqualTo((byte) 1).andIsShareEqualTo((byte) 1);
                int count2 = erpFunEntrustMapper.countByExample(erpFunEntrustExample3);
                if (count2 > 0 && buildPermission) { // 存在有效委托且在业务范围内
                    hasEffectiveEntrust = 1;
                    getHouseEntrustSituationVO.setHasHisEntrust(hasHisEntrust);
                    getHouseEntrustSituationVO.setCanAddEntrust(0);
                    getHouseEntrustSituationVO.setHasEffectiveEntrust(hasEffectiveEntrust);
                    return ErpResponseJson.ok(getHouseEntrustSituationVO);
                }
                if (caseType == 1) {
                    ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, saleLeaseId);
                    if (null == erpFunSale) {
                        return ErpResponseJson.warn("未查询出该房源信息");
                    }
                    if (Const.DIC_HOUSE_STATUS_RESPITE.equals(erpFunSale.getSaleStatus().byteValue())) {
                        respiteFlag2 = true;
                    }
                } else if (caseType == 2) {
                    ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, saleLeaseId);
                    if (null == erpFunLease) {
                        return ErpResponseJson.warn("未查询出该房源信息");
                    }
                    if (Const.DIC_HOUSE_STATUS_RESPITE.equals(erpFunLease.getLeaseStatus().byteValue())) {
                        respiteFlag2 = true;
                    }
                }
            }
        }
        
        // 2.判断有无当前委托
        ErpFunEntrustExample erpFunEntrustExample2 = new ErpFunEntrustExample();
        erpFunEntrustExample2.setShardCityId(cityId);
        erpFunEntrustExample2.createCriteria().andCompIdEqualTo(compId).andCaseIdEqualTo(param.getCaseId())
                .andCaseTypeEqualTo(param.getCaseType().byteValue()).andIsEffectiveEqualTo((byte) 1);
        int effectiveEntrustCount = erpFunEntrustMapper.countByExample(erpFunEntrustExample2);
        if (effectiveEntrustCount > 0) { // 有当前委托，就可以不用判断是否能新增委托了，因为一个房源只能有一个有效委托
            if (buildPermission) {
                hasEffectiveEntrust = 1;
            } else {
                hasEffectiveEntrust = 0;
            }
            getHouseEntrustSituationVO.setHasHisEntrust(hasHisEntrust);
            getHouseEntrustSituationVO.setCanAddEntrust(0);
            getHouseEntrustSituationVO.setHasEffectiveEntrust(hasEffectiveEntrust);
            return ErpResponseJson.ok(getHouseEntrustSituationVO);
        } else { // 没有有效委托，才需要判断是否能新增委托
            // 3.判断能否新增委托  员工可新增范围=业务范围内，非成交（内外）、非暂缓（租售房源判断不能同时为暂缓）、非删除
            List<Byte> houseStatusList = new ArrayList<>();
            houseStatusList.add(Const.DIC_HOUSE_STATUS_INNERDEAL);
            houseStatusList.add(Const.DIC_HOUSE_STATUS_DEAL);
            houseStatusList.add(Const.DIC_HOUSE_STATUS_WRITEOFF);
            if (isSaleLease == 1 && null != saleLeaseId) {
                if (respiteFlag1 && respiteFlag2) {
                    houseStatusList.add(Const.DIC_HOUSE_STATUS_RESPITE);
                }
            } else {
                if (respiteFlag1) {
                    houseStatusList.add(Const.DIC_HOUSE_STATUS_RESPITE);
                }
            }
    
            // 还需要判断是否在员工业务范围内
            if (buildPermission && !houseStatusList.contains(houseStatus)) {
                canAddEntrust = 1;
            }
            getHouseEntrustSituationVO.setHasHisEntrust(hasHisEntrust);
            getHouseEntrustSituationVO.setCanAddEntrust(canAddEntrust);
            getHouseEntrustSituationVO.setHasEffectiveEntrust(hasEffectiveEntrust);
            return ErpResponseJson.ok(getHouseEntrustSituationVO);
        }
    }
    
    @Override
    public ResponseJson getHouseBaseInfo(@RequestBody GetHouseEntrustSituationParam param) throws Exception {
        if (null == param.getCaseId()) {
            return ErpResponseJson.warn("未接收到房源ID参数");
        }
        if (null == param.getCaseType()) {
            return ErpResponseJson.warn("未接收到房源类型参数");
        }
    
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer isSaleLease = 0;
        Integer buildId = null;
        String buildName = "";
        String roofT = "";
        String unitT = "";
        String roomNum = "";
        String floor = "";
        GetHouseBaseInfoVO getHouseBaseInfoVO = new GetHouseBaseInfoVO();
        if (param.getCaseType() == 1) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, param.getCaseId());
            if (null == erpFunSale) {
                return ErpResponseJson.warn("未查询出出售房源信息");
            }
            getHouseBaseInfoVO.setPropertySituation(NumberHelper.formatNumber(Optional.ofNullable(erpFunSale.getSaleArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2));
            isSaleLease = erpFunSale.getIsSaleLease().intValue();
            buildId = erpFunSale.getBuildId();
            buildName = erpFunSale.getBuildName();
            roofT = erpFunSale.getSaleRoofT();
            unitT = erpFunSale.getSaleUnitT();
            roomNum = erpFunSale.getSaleNumT();
            if (null != erpFunSale.getMlWholeLayer() && erpFunSale.getMlWholeLayer() == 1) {
                roomNum = "整层";
            }
            floor = null == erpFunSale.getSaleFloor() ? "" : erpFunSale.getSaleFloor().toString();
        } else if (param.getCaseType() == 2) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, param.getCaseId());
            if (null == erpFunLease) {
                return ErpResponseJson.warn("未查询出出租房源信息");
            }
            getHouseBaseInfoVO.setPropertySituation(NumberHelper.formatNumber(Optional.ofNullable(erpFunLease.getLeaseArea()).orElse(BigDecimal.ZERO).doubleValue(), NumberHelper.NUMBER_IN_2));
            if (null != erpFunLease) {
                isSaleLease = erpFunLease.getIsSaleLease().intValue();
                buildId = erpFunLease.getBuildId();
                buildName = erpFunLease.getBuildName();
                roofT = erpFunLease.getLeaseRoofT();
                unitT = erpFunLease.getLeaseUnitT();
                roomNum = erpFunLease.getLeaseNumT();
                if (null != erpFunLease.getMlWholeLayer() && erpFunLease.getMlWholeLayer() == 1) {
                    roomNum = "整层";
                }
                floor = null == erpFunLease.getLeaseFloor() ? "" : erpFunLease.getLeaseFloor().toString();
            }
        } else {
            return ErpResponseJson.warn("房源类型错误");
        }
        
        if (null == buildId) {
            return ErpResponseJson.warn("该房源无楼盘信息");
        }
        
        ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, buildId);
        String promotionName = ""; // 楼盘推广名
        if (null != erpBuildingInfo) {
            promotionName = erpBuildingInfo.getPromotionName();
        }
        
        // 获取单位
        String roofName = "栋"; // 栋的单位
        String unitName = "单元"; // 单元的单位
        if(StringUtils.isNotBlank(roofT) ) {
            ErpBuildingSetRoofExample example = new ErpBuildingSetRoofExample();
            example.setShardCityId(cityId);
            ErpBuildingSetRoofExample.Criteria criteria = example.createCriteria();
            criteria.andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildRoofEqualTo(roofT);
            List<ErpBuildingSetRoof> setRoofList = erpBuildingSetRoofMapper.selectByExample(example);
            if (null != setRoofList && setRoofList.size() > 0) {
                ErpBuildingSetRoof erpBuildingSetRoof = setRoofList.get(0);
                roofName = StringUtil.isNotEmpty(erpBuildingSetRoof.getBuildRoofName()) ? erpBuildingSetRoof.getBuildRoofName() : "";
            }
        }
        
        if(StringUtils.isNotBlank(unitT)) {
            ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
            example.setShardCityId(cityId);
            ErpBuildingSetUnitExample.Criteria criteria = example.createCriteria();
            criteria.andCompIdEqualTo(0).andBuildIdEqualTo(buildId).andBuildUnitEqualTo(unitT);
            if(StringUtils.isNotBlank(roofT)) {
                criteria.andBuildRoofEqualTo(roofT);
            }
            List<ErpBuildingSetUnit> setUnitPOList = erpBuildingSetUnitMapper.selectByExample(example);
            if (null != setUnitPOList && setUnitPOList.size() > 0) {
                ErpBuildingSetUnit erpBuildingSetUnit = setUnitPOList.get(0);
                unitName = StringUtil.isNotEmpty(erpBuildingSetUnit.getBuildUnitName()) ? erpBuildingSetUnit.getBuildUnitName() : "";
            }
        }
        
        // 产权地址 =  楼盘 + 栋座 + 单元 + 楼层 + 房号
        StringBuilder sb = new StringBuilder();
        // 楼盘有推广名就用推广名，没有推广名才用楼盘名称
        if (StringUtil.isNotEmpty(promotionName)) {
            sb.append(promotionName);
        } else if (StringUtil.isNotEmpty(buildName)) {
            sb.append(buildName);
        }
        if (StringUtil.isNotEmpty(roofT)) {
            sb.append(roofT + roofName);
        }
        if (StringUtil.isNotEmpty(unitT)) {
            sb.append(unitT + unitName);
        }
        if (StringUtil.isNotEmpty(floor)) {
            sb.append(floor + "楼");
        }
        if (StringUtil.isNotEmpty(roomNum)) {
            sb.append(roomNum);
        }
        String houseAddr = sb.toString();
        
        // 顺便返回相关系统参数 IS_OPEN_ELECTRONIC_ENTRUST  是否开启电子委托 0=否 1=是   IS_SHARE_ENTRUST_DATA 租售房源委托资料是否共用 0=否 1=是
        String isOpenElectronicEntrust = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_OPEN_ELECTRONIC_ENTRUST");
        String isShareEntrustData = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_SHARE_ENTRUST_DATA");
        
        
        getHouseBaseInfoVO.setIsSaleLease(isSaleLease);
        getHouseBaseInfoVO.setHouseAddr(houseAddr);
        getHouseBaseInfoVO.setIsOpenElectronicEntrust(isOpenElectronicEntrust);
        getHouseBaseInfoVO.setIsShareEntrustData(isShareEntrustData);
        
        // 委托资料的房屋说明书是否必填 1=是 0=否 默认1
        AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
        if (null != adminFunCity) {
            getHouseBaseInfoVO.setCityId(cityId);
            getHouseBaseInfoVO.setCityName(adminFunCity.getCityName());  
        }
        if (null != adminFunCity || null != adminFunCity.getEntrustHouseInstruction()) {
            getHouseBaseInfoVO.setEntrustHouseInstruction(adminFunCity.getEntrustHouseInstruction());
        } else {
            getHouseBaseInfoVO.setEntrustHouseInstruction((byte) 1);
        }
        return ErpResponseJson.ok(getHouseBaseInfoVO);
    }
    
    @Override
    public ResponseJson saveEntrustInfo(@RequestBody SaveEntrustInfoParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        this.saveEntrustParamJudgeCommon(param, cityId);
        if (param.getElectronicEntrust() == 1 && null == param.getElectronicEntrustType()) {
            return ErpResponseJson.warn("请选择电子委托书类型");
        }
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        String deptName = operator.getOrganizationName();
        String userName = operator.getUserName();
    
        SaveEntrustInfoVO saveEntrustInfoVO = erpFunEntrustService.saveEntrustInfo(param, cityId, compId, userId, deptName, userName, operator.getClientKey());
    
        // 如果是纸质委托，保存后直接发起审核流程
        if (0 == param.getElectronicEntrust()) {
            // 创建跟进（发起审核） 调用houseWeb接口
            Map<String, Object> paramData = new HashMap<>();
            paramData.put("entrustId", saveEntrustInfoVO.getEntrustId());
            paramData.put("cityId", cityId);
            HttpUtil.postJson(AppConfig.getHouseWebUrl() + "/openApi/mlEntrust/entrustCreateTrackInfo", paramData);
        }
        
        return ErpResponseJson.ok(saveEntrustInfoVO);
    }
    
    /**
     * 新增或修改委托时的参数的简单判断
     * @author HuangJiang
     * @since 2019年11月27日 20:15
     * @param param
     * @param cityId
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    private void saveEntrustParamJudgeCommon(SaveEntrustInfoParam param, Integer cityId) {
        // 参数判断
        if (null == param.getCaseId()) {
            throw new BusinessException("未获取到房源ID");
        }
        if (null == param.getCaseType()) {
            throw new BusinessException("未获取到房源类型");
        }
        if (null == param.getEntrustType()) {
            throw new BusinessException("请选择委托类型");
        }
        if (null == param.getHouseStatus()) {
            throw new BusinessException("请选择产权状态");
        }
        if (StringUtil.isEmpty(param.getEntrustStart())) {
            throw new BusinessException("请选择委托期限");
        }
        //建议委托 委托编号为必填
        if (0 == param.getElectronicEntrust() && StringUtil.isEmpty(param.getEntrustNo())) {
            throw new BusinessException("请填写委托编号");
        }
        List<EntrustOwnersInfoParam> ownersList = param.getOwnersList();
        if (null == ownersList) {
            throw new BusinessException("业主信息至少要填写一组");
        } else if (ownersList.size() == 0) {
            throw new BusinessException("业主信息至少要填写一组");
        }
    
        List<EntrustCertificateInfoParam> certificateList = param.getCertificateList();
        if (null == certificateList) {
            throw new BusinessException("产权号至少填一个");
        } else if (certificateList.size() == 0) {
            throw new BusinessException("产权号至少填一个");
        }
    
        List<EntrustFileInfoParam> fileList = param.getFileList();
        AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
        if ("重庆市".equals(adminFunCity.getCityName())) {
            if (param.getPropertySituation() == null && ((param.getEntrustType() != null && param.getEntrustType() == 1) || (param.getEntrustBusiness() != null && param.getEntrustBusiness() == 2))) {
                throw new BusinessException("请填写物业情况");
            }
            if (StringUtil.isEmpty(param.getCertificateOfProduction()) && ((param.getEntrustType() != null && param.getEntrustType() == 2) && (param.getEntrustBusiness() != null && param.getEntrustBusiness() == 1))) {
                throw new BusinessException("请填写产证文件");
            } 
            if (StringUtil.isEmpty(param.getLandNature()) && ((param.getEntrustType() != null && param.getEntrustType() == 2) && (param.getEntrustBusiness() != null && param.getEntrustBusiness() == 1))) {
                throw new BusinessException("请填写土地性质");
            }
            if (param.getEntrustedAmount() == null && ((param.getEntrustType() != null && param.getEntrustType() == 2) && (param.getEntrustBusiness() != null && param.getEntrustBusiness() == 1))) {
                throw new BusinessException("请填写委托金额");
            }
            if (param.getEntrustArea() == null && ((param.getEntrustType() != null && param.getEntrustType() == 2) && (param.getEntrustBusiness() != null && param.getEntrustBusiness() == 1))) {
                throw new BusinessException("请填写委托面积");
            }
        } else if ("广州市".equals(adminFunCity.getCityName()) || "珠海市".equals(adminFunCity.getCityName())) {
            if (param.getHasAccountOccupancy() == null) {
                throw new BusinessException("请选择户口占用情况");
            }
            if (param.getHasDegreeOccupation() == null) {
                throw new BusinessException("请选择学位占用情况");
            }
        }
        if (! ("广州市".equals(adminFunCity.getCityName()) || "珠海市".equals(adminFunCity.getCityName()))) {  //但凡使用深圳模板的
            if (Const.HouseCustType.LEASE == param.getCaseType()){
                BigDecimal num = new BigDecimal(9999999999.99);
                if (null == param.getCustomRentAmount()){
                    throw new BusinessException("请输入租金");
                } else if (num.compareTo(param.getCustomRentAmount()) < 0){
                    throw new BusinessException("上限 9999999999.99元");
                }
            }
        }
        if (StringUtil.isEmpty(param.getEntrustEnd()) && !("广州市".equals(adminFunCity.getCityName()) || "珠海市".equals(adminFunCity.getCityName()))) {
            throw new BusinessException("请选择委托期限");
        }
        if (null == fileList) {
            throw new BusinessException("附件信息不能为空");
        } else if (fileList.size() == 0) {
            throw new BusinessException("附件信息不能为空");
        } else {
            // 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件
            Set<Byte> fileTypeSet = fileList.stream().filter(fileType -> null != fileType).map(EntrustFileInfoParam::getFileType).collect(Collectors.toSet());
            if (fileTypeSet.size() == 0) {
                throw new BusinessException("附件类型不能为空");
            }
            
            // 判断房屋说明书是否必填 文件类型：1=委托书 2=产权证明文件 3=业主身份证明文件 4=其他文件 5=房屋说明书
            boolean isNeedHouseInstruction = true;
            if (null == adminFunCity || null == adminFunCity.getEntrustHouseInstruction()) {
                isNeedHouseInstruction = true;
            } else {
                // 委托资料的房屋说明书是否必填 1=是 0=否 默认1
                isNeedHouseInstruction = adminFunCity.getEntrustHouseInstruction() == 1 ? true : false;
            }
            if (isNeedHouseInstruction && !fileTypeSet.contains((byte) 5)) { // 如果必填，但是不包含房屋说明书，则返回错误提示
                throw new BusinessException("请上传房屋说明书");
            }
            // 是否电子委托（0=否；1=是）
            if (1 == param.getElectronicEntrust()) {
                // 电子委托必传：业主身份证明文件、产权证明文件
                if (!fileTypeSet.contains((byte) 2) || !fileTypeSet.contains((byte) 3)) {
                    throw new BusinessException("电子委托必传：业主身份证明文件、产权证明文件");
                }
            } else {
                // 纸质必传：委托书、业主身份证明文件、产权证明文件 
                if (!fileTypeSet.contains((byte) 1) || !fileTypeSet.contains((byte) 2) || !fileTypeSet.contains((byte) 3)) {
                    throw new BusinessException("纸质委托必传：委托书、业主身份证明文件、产权证明文件");
                }
            }
        }
    }
    
    @Override
    public ResponseJson getHistoryEntrust(@Validated @RequestBody GetHistoryEntrustParam getHistoryEntrustParam){
        Operator operator = getOperator();
        List<MlEntrustVO> entrust = getEntrust(getHistoryEntrustParam, null, (byte) 0, operator);
        this.checkOperToViewEntrystList(operator.getCityId(),operator.getCompId(),operator.getUserId(),entrust);
        return ErpResponseJson.ok(entrust);
    }

    @Override 
    public ResponseJson getHouseEffectiveEntrustInfo(@Validated @RequestBody GetHistoryEntrustParam getHistoryEntrustParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer organizationId = operator.getOrganizationId();
        //查询有效的委托  有效委托只能有一条
        List<MlEntrustVO> entrust = getEntrust(getHistoryEntrustParam, null, (byte) 1, operator);
        MlEntrustVO vo = new MlEntrustVO();
        if (entrust != null && entrust.size() > 0) {
            vo = entrust.get(0);
        }
        Date createTime = vo.getCreateTime();
        //查询系统参数查询签署有效期
        Integer signEndTimeNum = 3;
        String signEndTime = adminSysParaMapper.selectParamVlue("ML_SIGN_END_TIME");
        if (StringUtil.isNotBlank(signEndTime)) {
            signEndTimeNum = StringUtil.paseInteger(signEndTime);
        }
        createTime = DateUtil.addDay(createTime, signEndTimeNum);
        vo.setSignEndTime(createTime);
        //如果没有审核
        // 判断撤销、删除、修改权限 按照委托申请人的层级来判断
        if (null != vo.getApproveUserId()) {
            // 委托提交人
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, vo.getApproveUserId());
            if (null != erpFunUsers && null != erpFunUsers.getOrganizationId()) {
                // 未审核状态：电子委托-撤销；纸质委托-修改，撤销
                if (vo.getAuditStatus() != null && vo.getAuditStatus() == 0) {
                    // 判断能否撤销
                    boolean cancelEntrustPermisson = this.checkEntrustOper(cityId, compId, userId, "CANCEL_ENTRUST", vo.getApproveUserId(), operator.isSwitchCompLogin());
                    if (cancelEntrustPermisson) {
                        vo.setCanCancel((byte) 1);
                    }
                    
                    // 判断能否修改
                    //如果是电子委托  只能撤销；纸质委托才支持修改
                    if (vo.getElectronicEntrust() != null && vo.getElectronicEntrust() == 0) {
                        boolean updateEntrustPermisson = this.checkEntrustOper(cityId, compId, userId, "UPDATE_ENTRUST", vo.getApproveUserId(), operator.isSwitchCompLogin());
                        if (updateEntrustPermisson) { // 有权限
                            vo.setCanEdit((byte)1);
                        }
                    }
                }
                
                // 已审核：删除
                if (vo.getAuditStatus() != null && vo.getAuditStatus() != 0) {
                    boolean deleteEntrustPermisson = this.checkEntrustOper(cityId, compId, userId, "DELETE_ENTRUST", vo.getApproveUserId(), operator.isSwitchCompLogin());
                    if (deleteEntrustPermisson) {
                        vo.setCanDelete((byte) 1);
                    }
                }
            }
        }
        ErpFunUsers approveUser = erpFunUsersMapper.selectByUserId(operator.getCityId(), vo.getApproveUserId());
        Boolean  canView = false;
        if(approveUser != null){
            canView = this.checkOperToViewEntryst(operator.getCityId(),operator.getCompId(),operator.getUserId(),approveUser);
            //canView = erpUserOpersService.checkOperNewOrg(operator.getCityId(),operator.getCompId(),operator.getUserId(),null,null,"VIEW_ENTRUST_CORE_INFO",approveUser.getOrganizationId(),operator.isSwitchCompLogin()&& !operator.isMobileApi());
        }
        vo.setCanView(canView ? (byte)1 : (byte)0);
        return ErpResponseJson.ok(vo);
    }
    
    /**
     * 判断委托相关权限
     * @author HuangJiang
     * @since 2019年12月31日 13:57
     * @param cityId 城市ID
     * @param compId 公司ID
     * @param userId 员工ID
     * @param operId 权限
     * @param organizationId 员工所在部门
     * @param isSwitchCompLogin
     * @return boolean
     * Modified XXX HuangJiang 2019年12月31日
     */
    private boolean checkEntrustOper(Integer cityId, Integer compId, Integer currUserId, String operId, Integer compareUserId, boolean isSwitchCompLogin) {
        ErpUserOpers userOper = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, currUserId, operId);
        boolean hasOper = false;
        if (userOper != null) {
            String caseOrgPath = erpFunUsersMapper.getFunUserByUserId(cityId, compareUserId).getTissueLine();//userInfo一定不能为null
            hasOper = erpFunOrganizationDefinitionService.currentUserHasOneLevelOperOffCaseOrgPath(cityId, compId, currUserId, null, caseOrgPath, compareUserId, userOper.getOrganizationDefinitionId());
        } else { // 未查询出权限，则表示权限到个人或者无
            if (currUserId.equals(compareUserId)) {
                hasOper = true;
            }
            if ("DELETE_ENTRUST".equals(operId)) { //委托删除权最低到无
                hasOper = false;
            }
        }
        return hasOper;
    }

    private void  checkOperToViewEntrystList(Integer cityId, Integer compId, Integer currentUserId, List<MlEntrustVO> entrust){
        ErpUserOpers userOperByUSerIdOperId = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, currentUserId, "VIEW_ENTRUST_CORE_INFO");
        List<Integer> approveUserIds = entrust.stream().map(MlEntrustVO::getApproveUserId).collect(Collectors.toList());
        //获取委托申请人的信息MAP
        Map<Integer, ErpFunUsers> idAndUser = new HashMap<>();
        if(!approveUserIds.isEmpty()){
            List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectUserListByIds(cityId, compId, approveUserIds);
            if(!erpFunUsers.isEmpty()){
                idAndUser.putAll(erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, o -> o)));
            }
        }

        ErpFunUsers funUserByCurrentUserId = erpFunUsersMapper.getFunUserByUserId(cityId, currentUserId);
        if(userOperByUSerIdOperId == null){//看自己
            entrust.stream().forEach(o->{
                if(currentUserId.equals(o.getApproveUserId())){
                    o.setCanView((byte)1);
                }
            });
            return;
        }
        Integer organizationDefinitionId = userOperByUSerIdOperId.getOrganizationDefinitionId();
        if(organizationDefinitionId != null){
            if(organizationDefinitionId == 0){//全公司
                entrust.stream().forEach(o->{
                        o.setCanView((byte)1);
                });
                return;
            }
            //当不为只看本人的时候，管理范围内的数据可以查看
            List<ErpFunUserManageRange> currentUserManageRanges = erpFunUserManageRangeMapper.selectByCompIdAndUserId(cityId, compId, currentUserId);
            if(!currentUserManageRanges.isEmpty()){
                entrust.stream().forEach(o->{
                    String tissueLine = idAndUser.get(o.getApproveUserId()).getTissueLine();
                    for (ErpFunUserManageRange currentUserManageRange : currentUserManageRanges) {
                        if(tissueLine.contains(currentUserManageRange.getRangeId().toString())){
                            o.setCanView((byte)1);
                        }
                    }
                });
            }
            ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
            orgExample.setShardCityId(cityId);
            orgExample.createCriteria().andOrganizationDefinitionIdEqualTo(organizationDefinitionId).andCompIdEqualTo(compId);
            List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(orgExample);
            //权限范围包括自己，且包括数据
            entrust.stream().forEach(obj->{
                Set<Integer> currenOrgDefIds = erpFunOrganizations.stream().filter(o -> idAndUser.get(obj.getApproveUserId()).getTissueLine().contains(o.getOrganizationId().toString())
                        && funUserByCurrentUserId.getTissueLine().contains(o.getOrganizationId().toString())
                        && funUserByCurrentUserId.getTissueLine().indexOf(o.getOrganizationId().toString()) <= idAndUser.get(obj.getApproveUserId()).getTissueLine().indexOf(o.getOrganizationId().toString()))
                        .map(ErpFunOrganization::getOrganizationDefinitionId).collect(Collectors.toSet());
                if(!currenOrgDefIds.isEmpty()){
                    obj.setCanView((byte)1);
                }
                //如果不满足数据在权限范围内，或者，权限范围小于自身层级，那么只能看自己的数据和管理范围的
                if(currentUserId.equals(obj.getApproveUserId())){
                    obj.setCanView((byte)1);
                }
            });
        }
    }

    private boolean  checkOperToViewEntryst(Integer cityId, Integer compId, Integer currentUserId, ErpFunUsers approveUser){
        ErpUserOpers userOperByUSerIdOperId = erpUserOpersMapper.getUserOperByUSerIdOperId(cityId, currentUserId, "VIEW_ENTRUST_CORE_INFO");
        ErpFunUsers funUserByCurrentUserId = erpFunUsersMapper.getFunUserByUserId(cityId, currentUserId);
        if(userOperByUSerIdOperId == null){//看自己
            return currentUserId.equals(approveUser.getUserId());
        }
        Integer organizationDefinitionId = userOperByUSerIdOperId.getOrganizationDefinitionId();
        if(organizationDefinitionId != null){
            if(organizationDefinitionId == 0){//全公司
                return true;
            }
            //当不为只看本人的时候，管理范围内的数据可以查看
            List<ErpFunUserManageRange> currentUserManageRanges = erpFunUserManageRangeMapper.selectByCompIdAndUserId(cityId, compId, currentUserId);
            if(!currentUserManageRanges.isEmpty()){
                String tissueLine = approveUser.getTissueLine();
                for (ErpFunUserManageRange currentUserManageRange : currentUserManageRanges) {
                    if(tissueLine.contains(currentUserManageRange.getRangeId().toString())){
                        return true;
                    }
                }
            }
            ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
            orgExample.setShardCityId(cityId);
            orgExample.createCriteria().andOrganizationDefinitionIdEqualTo(organizationDefinitionId).andCompIdEqualTo(compId);
            List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(orgExample);
            //权限范围包括自己，且包括数据
            Set<Integer> currenOrgDefIds = erpFunOrganizations.stream().filter(o -> approveUser.getTissueLine().contains(o.getOrganizationId().toString())
                    && funUserByCurrentUserId.getTissueLine().contains(o.getOrganizationId().toString())).map(ErpFunOrganization::getOrganizationDefinitionId).collect(Collectors.toSet());
            if(!currenOrgDefIds.isEmpty()){
                ErpFunOrganization approveOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId,compId,approveUser.getOrganizationId());
                ErpFunOrganizationDefinition aprroveOrgDef = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionId(cityId, compId, approveOrganization.getOrganizationDefinitionId());
                List<ErpFunOrganizationDefinition> currentOrgDefs = erpFunOrganizationDefinitionMapper.getOrganizationDefinitionByDefIdSet(cityId, compId, currenOrgDefIds);
                for (ErpFunOrganizationDefinition currentOrgDef : currentOrgDefs) {
                    if(currentOrgDef.getDefinitionLevel() <= aprroveOrgDef.getDefinitionLevel()){
                        return true;
                    }
                }
            }
            //如果不满足数据在权限范围内，或者，权限范围小于自身层级，那么只能看自己的数据和管理范围的
            return currentUserId.equals(approveUser.getUserId());
        }
        return false;
    }
    @Override
    public ResponseJson updateEntrustInfo(@Validated @RequestBody SaveEntrustInfoParam param) throws Exception {
        // 参数判断
        if (null == param.getEntrustId()) {
            return ErpResponseJson.warn("未获取到委托ID");
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        param.setElectronicEntrust((byte) 0); // 设置成纸质委托，兼容参数判断
        this.saveEntrustParamJudgeCommon(param, cityId);
        
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        String deptName = operator.getDeptName();
        String userName = operator.getUserName();
        erpFunEntrustService.updateEntrustInfo(param, cityId, compId, userId, deptName, userName);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson getEntrustFileConfig() throws Exception {
        GetEntrustFileConfigVO getEntrustFileConfigVO = new GetEntrustFileConfigVO();
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        String openElectronicEntrust = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_OPEN_ELECTRONIC_ENTRUST");
        String isShareEntrustData = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_SHARE_ENTRUST_DATA");
        if (StringUtil.isNotBlank(openElectronicEntrust)) {
            getEntrustFileConfigVO.setOpenElectronicEntrust(StringUtil.parseByte(openElectronicEntrust));
        }
        if (StringUtil.isNotBlank(isShareEntrustData)) {
            getEntrustFileConfigVO.setDataSharing(StringUtil.parseByte(isShareEntrustData));
        }
        return ErpResponseJson.ok(getEntrustFileConfigVO);
    }

    @Override
    public ResponseJson updateEntrustFileConfig(@Validated @RequestBody UpdateEntrustFileConfigParam param) throws Exception {
        Operator operator = getOperator();
        if (param == null || (param.getDataSharing() == null && param.getOpenElectronicEntrust() == null)) {
            return ErpResponseJson.warn("请选择修改的参数！");
        }
        erpSysParaService.mlEntrustParamSetting(param, operator);
        return ErpResponseJson.ok();
    }
    
    @Override
    public ResponseJson cancelEntrust(@Validated @RequestBody CancelEntrustParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        String userName = operator.getUserName();
        ErpFunEntrust erpFunEntrust = this.judgeParam(param.getEntrustId(), cityId);
        erpFunEntrustService.cancelEntrust(userName, compId, cityId, userId, erpFunEntrust);
        return ErpResponseJson.ok();
    }
    
    @Override
    public ResponseJson deleteEntrust(@Validated @RequestBody CancelEntrustParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        String userName = operator.getUserName();
        String clientKey = operator.getClientKey();
        ErpFunEntrust erpFunEntrust = this.judgeParam(param.getEntrustId(), cityId);
        erpFunEntrustService.deleteEntrust(userName, compId, cityId, userId, erpFunEntrust, clientKey);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson getHouseHistoryEntrustInfo(@Validated @RequestBody GetHouseEntrustInfoParam param) throws Exception {
        Operator operator = getOperator();
        List<MlEntrustVO> entrust = getEntrust(null, param, null, operator);
        MlEntrustVO vo = new MlEntrustVO();
        if (entrust != null && entrust.size() > 0) {
            vo = entrust.get(0);
        }
        Date createTime = vo.getCreateTime();
        //查询系统参数查询签署有效期
        Integer signEndTimeNum = 3;
        String signEndTime = adminSysParaMapper.selectParamVlue("ML_SIGN_END_TIME");
        if (StringUtil.isNotBlank(signEndTime)) {
            signEndTimeNum = StringUtil.paseInteger(signEndTime);
        }
        createTime = DateUtil.addDay(createTime, signEndTimeNum);
        vo.setSignEndTime(createTime);
        ErpFunUsers approveUser = erpFunUsersMapper.selectByUserId(operator.getCityId(), vo.getApproveUserId());
        Boolean  canView = false;
        if(approveUser != null){
            canView = this.checkOperToViewEntryst(operator.getCityId(),operator.getCompId(),operator.getUserId(),approveUser);
            //canView = erpUserOpersService.checkOperNewOrg(operator.getCityId(),operator.getCompId(),operator.getUserId(),null,null,"VIEW_ENTRUST_CORE_INFO",approveUser.getOrganizationId(),operator.isSwitchCompLogin()&& !operator.isMobileApi());
        }
        vo.setCanView(canView ? (byte)1 : (byte)0);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 参数判断
     * @author HuangJiang
     * @since 2019年11月27日 19:19
     * @param entrustId
     * @param cityId
     * @return com.myfun.repository.erpdb.po.ErpFunEntrust
     * Modified XXX HuangJiang 2019年11月27日
     */
    private ErpFunEntrust judgeParam(Integer entrustId, Integer cityId) {
        if (null == entrustId) {
            throw new BusinessException("未获取到委托ID");
        }
        ErpFunEntrust selectKey = new ErpFunEntrust();
        selectKey.setShardCityId(cityId);
        selectKey.setEntrustId(entrustId);
        ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(selectKey);
        if (null == erpFunEntrust) {
            throw new BusinessException("未查询出委托信息");
        }
        return erpFunEntrust;
    }
    
    private List<MlEntrustVO> getEntrust(GetHistoryEntrustParam param, GetHouseEntrustInfoParam getHouseEntrustInfoParam,Byte isEffective, Operator operator) {
        List<MlEntrustVO> voList = new ArrayList<>();
        List<ErpFunEntrust> erpFunEntrusts = new ArrayList<>();
        Integer saleId = null;
        Integer leaseId = null;
        Byte isSaleLease = 0;
        if (getHouseEntrustInfoParam != null && getHouseEntrustInfoParam.getEntrustId() != null) {
            ErpFunEntrust selectKey = new ErpFunEntrust();
            selectKey.setShardCityId(operator.getCityId());
            selectKey.setEntrustId(getHouseEntrustInfoParam.getEntrustId());
            ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(selectKey);
            erpFunEntrusts.add(erpFunEntrust);
        } else {
            if (Const.HouseCustType.SALE == param.getCaseType()) {
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(operator.getCityId(), param.getCaseId());
                if (erpFunSale.getSaleLeaseId() != null && erpFunSale.getSaleLeaseId() > 0) {
                    leaseId = erpFunSale.getSaleLeaseId();
                    isSaleLease = 1;
                }
            } else {
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(operator.getCityId(), param.getCaseId());
                if (erpFunLease.getSaleLeaseId() != null && erpFunLease.getSaleLeaseId() > 0) {
                    saleId = erpFunLease.getSaleLeaseId();
                    isSaleLease = 1;
                }
            }
            //查询系统参数 查询是否开启了租售共用资料
//            String isShareEntrustData = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "IS_SHARE_ENTRUST_DATA");
            String isShareEntrustData = erpSysParaService.getMLSysParamValByUserDefEmpty(operator.getCityId(), operator.getCompId(), operator.getUserId(), "IS_SHARE_ENTRUST_DATA");

            Byte shareEntrustData = (isShareEntrustData == null ? 0 : StringUtil.parseByte(isShareEntrustData));
            erpFunEntrusts = erpFunEntrustMapper.selectByCaseId(operator.getCityId(), operator.getCompId(), param.getCaseType(), param.getCaseId(), saleId, leaseId, isSaleLease, isEffective, shareEntrustData);
            
        } 
       
        if (erpFunEntrusts == null || erpFunEntrusts.size() < 1) {
            return voList;
        }
        List<Integer> entrustIds = erpFunEntrusts.stream().collect(Collectors.mapping(ErpFunEntrust::getEntrustId, Collectors.toList()));
        List<Integer> approveUserIds = erpFunEntrusts.stream().collect(Collectors.mapping(ErpFunEntrust::getApproveUserId, Collectors.toList()));
        List<Integer> auditUserIds = erpFunEntrusts.stream().collect(Collectors.mapping(ErpFunEntrust::getAuditUserId, Collectors.toList()));
        if (approveUserIds == null) {
            approveUserIds = new ArrayList();
        } 
        if (auditUserIds == null) {
            auditUserIds = new ArrayList();
        }
        approveUserIds.addAll(auditUserIds);
//        List<BrokerOrganizationVO> brokerOrganizationVOS = erpFunUsersMapper.selectBrokerOrganizationByUserIds(operator.getCityId(), approveUserIds, operator.getCompId());
//        Map<Integer, BrokerOrganizationVO> userMap = brokerOrganizationVOS.stream().collect(Collectors.toMap(BrokerOrganizationVO::getUserId, var -> var));
//        List<Integer> archiveIds = brokerOrganizationVOS.stream().collect(Collectors.mapping(BrokerOrganizationVO::getArchiveId, Collectors.toList()));
//        List<AdminFunArchive> listByArchiveIds = adminFunArchiveMapper.getListByArchiveIds(archiveIds);
//        Map<Integer, AdminFunArchive> archivePhotoMap = listByArchiveIds.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId,var -> var));
    
        // 员工
        List<ErpFunUsers> userList = erpFunUsersMapper.getErpFunUsersList(operator.getCityId(), approveUserIds);
        Map<Integer, ErpFunUsers> userMap = new HashMap();
        List<Integer> archiveIds = new ArrayList();  // 经纪人
        List<AdminFunArchive> listByArchiveIds = new ArrayList();
        Map<Integer, AdminFunArchive> archivePhotoMap = new HashMap();
        List<Integer> organizationIds = new ArrayList();// 组织
        if (userList != null && userList.size() > 0) {
            userMap .putAll(userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, var -> var)));
            archiveIds.addAll(userList.stream().map(ErpFunUsers::getArchiveId).collect(Collectors.toList()));
            organizationIds.addAll(userList.stream().map(ErpFunUsers::getOrganizationId).collect(Collectors.toList()));
            listByArchiveIds.addAll(adminFunArchiveMapper.getListByArchiveIds(archiveIds));
            if (listByArchiveIds != null && listByArchiveIds.size() > 0) {
                archivePhotoMap.putAll(listByArchiveIds.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, var -> var)));
            }
        }
        
        
        List<ErpFunOrganization> organizationList = erpFunOrganizationMapper.selectOrgByOrgIds(operator.getCityId(), operator.getCompId(), organizationIds);
        Map<Integer, ErpFunOrganization> organizationMap = new HashMap();
        if (organizationList != null && organizationList.size() > 0) {
            organizationMap.putAll(organizationList.stream().collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, var -> var)));
        }
        
        //查询业主信息
        List<OwnerUserVO> erpFunEntrustOwners = erpFunEntrustOwnersMapper.selectByEntrustIds(operator.getCityId(),entrustIds);
        Map<Integer, List<OwnerUserVO>> ownerUserVOMap = new HashMap();
        if (erpFunEntrustOwners != null && erpFunEntrustOwners.size() > 0) {
            ownerUserVOMap.putAll(erpFunEntrustOwners.stream().collect(Collectors.groupingBy(OwnerUserVO::getEntrustId)));
        }
        //查询产权信息
        List<EntrustCertificateVO> erpFunEntrustCertificates = erpFunEntrustCertificateMapper.selectByEntrustIds(operator.getCityId(),entrustIds);
        Map<Integer, List<EntrustCertificateVO>> entrustCertificateVOMap = new HashMap();
        if (erpFunEntrustCertificates != null && erpFunEntrustCertificates.size() > 0) {
            entrustCertificateVOMap.putAll(erpFunEntrustCertificates.stream().collect(Collectors.groupingBy(EntrustCertificateVO::getEntrustId)));
        }
        //查询文件信息
        List<EntrustFilesVO> erpFunEntrustFiles = erpFunEntrustFilesMapper.selectByEntrustIds(operator.getCityId(),entrustIds);
        Map<Integer, List<EntrustFilesVO>> entrustFilesVOMap = new HashMap();
        if(erpFunEntrustFiles!=null&&erpFunEntrustFiles.size()>0) {
            erpFunEntrustFiles.stream().forEach(var -> {
                if (StringUtil.isNotBlank(var.getFilePath())) {
                    var.setFilePathUrl(AppConfig.getPicDomainUrl() + var.getFilePath());
                }
            });
            entrustFilesVOMap.putAll(erpFunEntrustFiles.stream().collect(Collectors.groupingBy(EntrustFilesVO::getEntrustId)));
        }
        //遍历委托  组装数据
        erpFunEntrusts.stream().forEach(var->{
            MlEntrustVO vo = new MlEntrustVO();
            BeanUtils.copyProperties(var, vo);
            vo.setAssociationName(var.getApproveOrganizationName());
            vo.setApproveDept(var.getApproveOrganizationName());
            ErpFunUsers erpFunUsers = userMap.get(var.getApproveUserId());
            if (erpFunUsers != null) {
                AdminFunArchive adminFunArchive = archivePhotoMap.get(erpFunUsers.getArchiveId());
                if (adminFunArchive != null && StringUtil.isNotBlank(adminFunArchive.getUserPhoto())) {
                    vo.setApproveUserPhoto(AppConfig.getPicDomainUrl() + adminFunArchive.getUserPhoto());
                }
                vo.setApproveUserName(erpFunUsers.getUserName());
               /* if (null != erpFunUsers.getOrganizationId()) {
                    ErpFunOrganization erpFunOrganization = organizationMap.get(erpFunUsers.getOrganizationId());
                    if (null != erpFunOrganization && StringUtil.isNotEmpty(erpFunOrganization.getOrganizationName())) {
                        vo.setAssociationName(erpFunOrganization.getOrganizationName());
                        vo.setApproveDept(erpFunOrganization.getOrganizationName());
                    }
                }*/
            }
            
            if (var.getAuditUserId() != null) {
                ErpFunUsers erpFunUsers1 = userMap.get(var.getAuditUserId());
                if (null != erpFunUsers1 && StringUtil.isNotEmpty(erpFunUsers1.getUserName())) {
                    vo.setAuditUserName(erpFunUsers1.getUserName());
                }
            }
            if (ownerUserVOMap != null && ownerUserVOMap.size() > 0) {
                vo.setOwnerUserVOList(ownerUserVOMap.get(var.getEntrustId()));
            }  
            if (entrustCertificateVOMap != null && entrustCertificateVOMap.size() > 0) {
                vo.setEntrustCertificateVOList(entrustCertificateVOMap.get(var.getEntrustId()));
            }  
            if (entrustFilesVOMap != null && entrustFilesVOMap.size() > 0) {
                vo.setEntrustFilesVOList(entrustFilesVOMap.get(var.getEntrustId()));
            }
            voList.add(vo);
        });
        return voList;
    }
    
    
}

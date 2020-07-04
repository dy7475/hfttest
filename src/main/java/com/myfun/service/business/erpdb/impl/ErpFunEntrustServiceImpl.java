package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.deal.controller.EntrustApiController;
import com.myfun.erpWeb.house.controller.MlEntrustApiController;
import com.myfun.erpWeb.house.param.EntrustCertificateInfoParam;
import com.myfun.erpWeb.house.param.EntrustFileInfoParam;
import com.myfun.erpWeb.house.param.EntrustOwnersInfoParam;
import com.myfun.erpWeb.house.param.SaveEntrustInfoParam;
import com.myfun.erpWeb.house.vo.OwnerUserVO;
import com.myfun.erpWeb.house.vo.SaveEntrustInfoVO;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.UpdateEntrustRecordParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.BestsignService;
import com.myfun.service.business.erpdb.ErpFunEntrustService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scala.annotation.meta.param;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author HuangJiang
 * @since 2019年11月25日 17:26:11
 * Modified XXX HuangJiang 2019年11月25日
 */
@Service
public class ErpFunEntrustServiceImpl extends AbstractService<ErpFunEntrust, ErpFunEntrust> implements ErpFunEntrustService {
    
    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpFunEntrustFilesMapper erpFunEntrustFilesMapper;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpFunEntrustCertificateMapper erpFunEntrustCertificateMapper;
    @Autowired
    private ErpFunEntrustTrackMapper erpFunEntrustTrackMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpAuditRuntimeMapper erpAuditRuntimeMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private EntrustApiController entrustApiController;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private BestsignService bestsignService;
    @Autowired
    private ErpSysParaService erpSysParaService;
    @Autowired
    private ErpAuditTemplateMapper erpAuditTemplateMapper;
    @Autowired
    private ErpBuildingInfoMapper erpBuildingInfoMapper;
    @Autowired
    private ErpFunEntrustRecordKpiLogMapper erpFunEntrustRecordKpiLogMapper;
    @Autowired
    private MlEntrustApiController mlEntrustApiController;
    @Autowired
    private ErpKpiStatisticBrokerPerformanceMapper erpKpiStatisticBrokerPerformanceMapper;
    @Autowired
    private ErpFunEntrustRecordNoMapper erpFunEntrustRecordNoMapper;
    @Autowired
    private ErpFunTrackMapper erpFunTrackMapper;
   	@Autowired 
    private ErpFunEntrustKpiLogMapper erpFunEntrustKpiLogMapper;
    @Autowired
    private ErpFunEntrustKpiTrackMapper erpFunEntrustKpiTrackMapper;
    @Autowired
    private ErpFunEntrustRecordKpiTrackMapper erpFunEntrustRecordKpiTrackMapper;
    @Autowired
    private AdminFunCityMapper adminFunCityMapper;
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpFunEntrustMapper;
    }
    
    /**
     * 保存委托
     * @param param
     * @param cityId
     * @param compId
     * @param userId
     * @param deptName
     * @param userName
     * @return void
     * Modified XXX HuangJiang 2019年11月25日
     * @since 2019年11月25日 17:31
     */
    @Override
    @Transactional
    public SaveEntrustInfoVO saveEntrustInfo(SaveEntrustInfoParam param, Integer cityId, Integer compId, Integer userId, String deptName, String userName, String clientKey) throws Exception {
        ErpFunEntrust erpFunEntrust = new ErpFunEntrust();
        BeanUtil.copyObject(param, erpFunEntrust);
        Date date = new Date();
    
        // 1.保存委托
        erpFunEntrust.setShardCityId(cityId);
        Byte signStatus = 0; //是否签约（1=签约完毕；0=待签约）
        // 是否电子委托（0=否；1=是）
        boolean needAddKpi = false; // 是否需要新增KPI记录
        if (0 == erpFunEntrust.getElectronicEntrust()) {
            // 纸质委托保存 默认为签约完毕 签约完成时间默认当前时间
            signStatus = 1;
            erpFunEntrust.setSignFinashDate(date);
            
            // 由于纸质委托保存后不需要业主签约这一流程，直接到审核这一步，所以需要判断是否配置了委托资料的审核流程，没有审核流程，则默认审核通过
            // 判断是否配置了审核流程，如果配置了则需要走审核流程，如果没有配置，则不需要审核这个步骤
            ErpAuditTemplate erpAuditTemplate = erpAuditTemplateMapper.selectByAuditType(cityId, compId, (byte) 1, Const.DIC_TRACK_TYPE_ENTRUST_DATA.intValue(), erpFunEntrust.getCaseType().intValue());
            boolean needAudit = false;
            if (null != erpAuditTemplate && erpAuditTemplate.getNeedAudit() == 1) {
                needAudit = true;
            }
            if (!needAudit) { // 没有审核流程，则默认审核通过
                erpFunEntrust.setAuditStatus((byte) 2); // 审核状态（0=待审核 1=审核拒绝 2=审核完成）
                erpFunEntrust.setAuditDate(date);
                erpFunEntrust.setAuditUserId(999);
                // 委托类型（1=普通；2=独家）
                if (null != param.getEntrustType() && param.getEntrustType() == 2) {
                    needAddKpi = true; // 如果是纸质独家委托委托且不需要审核的情况下，则需要记录KPI数据
                }
            }
        } else {
            // 电子委托状态为待签署
            erpFunEntrust.setEntrustStatus((byte) 11);
            //电子委托的编码需要自动生成
            String entrustNo = getEntrustNo(cityId, param.getElectronicEntrustType());
            erpFunEntrust.setEntrustNo(entrustNo);
        }
        erpFunEntrust.setSignStatus(signStatus);
        erpFunEntrust.setCompId(compId);
        erpFunEntrust.setCityId(cityId);
        erpFunEntrust.setCreateTime(date);
        erpFunEntrust.setApproveUserId(userId);
        erpFunEntrust.setApproveOrganizationName(deptName);
        erpFunEntrust.setRecordStatus((byte) 1); // 备案状态（1=未备案 2=已备案 0=清空备案）
        
        // 获取房源价格
        Byte isSaleLease = (byte) 0;
        if (erpFunEntrust.getCaseType() == 1) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, param.getCaseId());
            if (null == erpFunSale) {
                throw new BusinessException("未查询出该房源信息");
            }
            isSaleLease = erpFunSale.getIsSaleLease();
            erpFunEntrust.setSalePrice(erpFunSale.getSaleTotalPrice());
            
            // 委托业务（1=出售委托；2出租委托; 3=出租出售委托）
            if (null != erpFunEntrust.getEntrustBusiness() && erpFunEntrust.getEntrustBusiness() == 3 && isSaleLease == 1 && null != erpFunSale.getSaleLeaseId()) {
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, erpFunSale.getSaleLeaseId());
                if (null != erpFunLease) {
                    erpFunEntrust.setLeasePrice(erpFunLease.getLeaseTotalPrice());
                }
            }
        } else {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, param.getCaseId());
            if (null == erpFunLease) {
                throw new BusinessException("未查询出该房源信息");
            }
            isSaleLease = erpFunLease.getIsSaleLease();
            erpFunEntrust.setLeasePrice(erpFunLease.getLeaseTotalPrice());
    
            // 委托业务（1=出售委托；2出租委托; 3=出租出售委托）
            if (null != erpFunEntrust.getEntrustBusiness() && erpFunEntrust.getEntrustBusiness() == 3 && isSaleLease == 1 && null != erpFunLease.getSaleLeaseId()) {
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, erpFunLease.getSaleLeaseId());
                if (null != erpFunSale) {
                    erpFunEntrust.setSalePrice(erpFunSale.getSaleTotalPrice());
                }
            }
            if (null != param.getCustomRentAmount()){
                //erpFunEntrust.set
            }
        }
        String paramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, userId, "IS_SHARE_ENTRUST_DATA"); // 租售房源委托资料是否共用 0=否 1=是
        //开启了直接写成1 预防之后在转租转售的时候查不到
        if ("1".equals(paramValue)) {
            erpFunEntrust.setIsShare((byte) 1);
        }
        // 判断是否已经存在有效委托 没有才能新增
        ErpFunEntrustExample erpFunEntrustExample = new ErpFunEntrustExample();
        erpFunEntrustExample.setShardCityId(cityId);
        erpFunEntrustExample.createCriteria().andCompIdEqualTo(compId).andCaseIdEqualTo(param.getCaseId()).andCaseTypeEqualTo(param.getCaseType()).andIsEffectiveEqualTo((byte) 1);
        int count = erpFunEntrustMapper.countByExample(erpFunEntrustExample);
        if (count > 0) {
            throw new BusinessException("该房源存在有效委托，无法新增");
        }
        erpFunEntrustMapper.insertSelective(erpFunEntrust);

        //detail task#0 [20-5-19] wc 上传房源委托的时候设置房源委托标记
        if (erpFunEntrust.getCaseId() != null) {
            if (Byte.valueOf("1").equals(erpFunEntrust.getCaseType())) {
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, erpFunEntrust.getCaseId());
                if (erpFunSale != null) {
                    erpFunSaleMapper.setEntrustInfoBySaleId(cityId, erpFunEntrust.getCaseId(), 0, 1, null);
                    if (Byte.valueOf("1").equals(erpFunEntrust.getIsShare()) && null != erpFunSale.getSaleLeaseId() && Byte.valueOf("1").equals(erpFunSale.getIsSaleLease())) {
                        erpFunLeaseMapper.setEntrustInfoByLeaseId(cityId, erpFunSale.getSaleLeaseId(), 0, 1, null);
                    }
                }
            } else if (Byte.valueOf("2").equals(erpFunEntrust.getCaseType())) {                                 
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, erpFunEntrust.getCaseId());
                if (null != erpFunLease) {
                    erpFunLeaseMapper.setEntrustInfoByLeaseId(cityId, erpFunEntrust.getCaseId(), 0, 1, null);
                    if (Byte.valueOf("1").equals(erpFunEntrust.getIsShare()) && null != erpFunLease.getSaleLeaseId() && Byte.valueOf("1").equals(erpFunLease.getIsSaleLease())) {
                        erpFunSaleMapper.setEntrustInfoBySaleId(cityId, erpFunLease.getSaleLeaseId(), 0, 1, null);
                    }
                }
            }
        }

        Integer entrustId = erpFunEntrust.getEntrustId(); // 委托ID
        
        // 2.保存业主信息
        List<EntrustOwnersInfoParam> ownersList = param.getOwnersList();
        ErpFunEntrustOwners erpFunEntrustOwners = new ErpFunEntrustOwners();
        erpFunEntrustOwners.setShardCityId(cityId);
        erpFunEntrustOwners.setEntrustId(entrustId);
        for (EntrustOwnersInfoParam ownersInfo : ownersList) {
            erpFunEntrustOwners.setOwnerName(ownersInfo.getOwnerName());
            if (null != ownersInfo.getNativePlace()) {
                erpFunEntrustOwners.setNativePlace(ownersInfo.getNativePlace().byteValue());
            } else {
                erpFunEntrustOwners.setNativePlace(null);
            }
            if (null != ownersInfo.getIdType()) {
                erpFunEntrustOwners.setIdType(ownersInfo.getIdType().byteValue());
            } else {
                erpFunEntrustOwners.setIdType(null);
            }
            erpFunEntrustOwners.setCardNo(ownersInfo.getCardNo());
            erpFunEntrustOwners.setOwnerPhone(ownersInfo.getOwnerPhone());
            erpFunEntrustOwners.setAddress(ownersInfo.getAddress());
            // 跟委托信息上的签约状态保持一致（电子委托默认未签约，纸质委托默认签约完成）
            erpFunEntrustOwners.setIsSign(signStatus);
            if (1 == signStatus) {
                erpFunEntrustOwners.setSignDate(date);
            }
            erpFunEntrustOwnersMapper.insertSelective(erpFunEntrustOwners);
        }
        
        // 3.保存产权号信息
        List<EntrustCertificateInfoParam> certificateList = param.getCertificateList();
        ErpFunEntrustCertificate erpFunEntrustCertificate = new ErpFunEntrustCertificate();
        erpFunEntrustCertificate.setShardCityId(cityId);
        erpFunEntrustCertificate.setEntrustId(entrustId);
        for (EntrustCertificateInfoParam certificateInfo : certificateList) {
            if (null != certificateInfo.getCertificateType()) {
                erpFunEntrustCertificate.setCertificateType(certificateInfo.getCertificateType().byteValue());
            } else {
                erpFunEntrustCertificate.setCertificateType(null);
            }
            erpFunEntrustCertificate.setCertificateNo(certificateInfo.getCertificateNo());
            erpFunEntrustCertificateMapper.insertSelective(erpFunEntrustCertificate);
        }
        
        // 4.保存附件信息
        List<EntrustFileInfoParam> fileList = param.getFileList();
        ErpFunEntrustFiles erpFunEntrustFiles = new ErpFunEntrustFiles();
        erpFunEntrustFiles.setShardCityId(cityId);
        erpFunEntrustFiles.setEntrustId(entrustId);
        erpFunEntrustFiles.setUpdateTime(date);
        for (EntrustFileInfoParam fileInfo : fileList) {
            erpFunEntrustFiles.setFilePath(fileInfo.getFilePath());
            // 此处兼容一下，如果前端传回来的文件名没有包含文件后缀，则将后缀拼在文件名后面
            if (StringUtil.isNotEmpty(fileInfo.getFileExt()) && StringUtil.isNotEmpty(fileInfo.getFileName()) && !fileInfo.getFileName().endsWith("." + fileInfo.getFileExt())) {
                erpFunEntrustFiles.setFileName(fileInfo.getFileName() + "." + fileInfo.getFileExt());
            } else {
                erpFunEntrustFiles.setFileName(fileInfo.getFileName());
            }
            erpFunEntrustFiles.setFileSizeCn(fileInfo.getFileSizeCn());
            if (null != fileInfo.getFileType()) {
                erpFunEntrustFiles.setFileType(fileInfo.getFileType().byteValue());
            } else {
                erpFunEntrustFiles.setFileType(null);
            }
            erpFunEntrustFiles.setFileExt(fileInfo.getFileExt());
            erpFunEntrustFilesMapper.insertSelective(erpFunEntrustFiles);
        }
        
        SaveEntrustInfoVO saveEntrustInfoVO = new SaveEntrustInfoVO();
        saveEntrustInfoVO.setEntrustId(entrustId);
        // 纸质委托，则直接保存成功；电子委托：如果是一个业主则返回二维码地址，如果是多个业主：1简易委托：返回文案；2标准委托：返回文案，给业主发送短信
        if (1 == erpFunEntrust.getElectronicEntrust()) { // 电子委托
            String contractId = ""; // 委托合同ID
            if (ownersList.size() > 1) { // 多个业主 不返回二维码
                // 电子委托书类型（1=标准；2=简易）
                if (2 == erpFunEntrust.getElectronicEntrustType()) {
                    saveEntrustInfoVO.setText("委托信息已保存，您可在当前委托中复制链接、分享二维码邀请业主签约");
                } else if (1 == erpFunEntrust.getElectronicEntrustType()) { // 标准委托
                    saveEntrustInfoVO.setText("签约信息已通过短信发送至业主手机，您也可在当前委托中复制链接、分享二维码邀请业主签约");
                    //获取业主列表
                    List<ErpFunEntrustOwners> entrustOwnersList = this.getEntrustOwnersList(cityId, entrustId);
                    contractId = this.createContractId(erpFunEntrust, entrustOwnersList, cityId, certificateList);
                    // TODO 发送短信  调用美联的接口
                    for (ErpFunEntrustOwners entrustOwners : entrustOwnersList) {
                        entrustApiController.sendEntrustMsg(cityId, entrustOwners.getOwnerPhone(), erpFunEntrust.getEntrustEnd(),contractId,entrustOwners.getId());
                    }
                }
            } else { // 单个业主 要返回二维码
                // 电子委托书类型 1=标准（二维码地址美联提供） ；2=简易（二维码地址我们提供）
                //获取业主列表
                List<ErpFunEntrustOwners> entrustOwnersList = this.getEntrustOwnersList(cityId, entrustId);
                ErpFunEntrustOwners funEntrustOwners = entrustOwnersList.get(0);
                if (null == funEntrustOwners) {
                    throw new BusinessException("未获取到业主信息");
                }
                saveEntrustInfoVO.setOwnerId(funEntrustOwners.getId()); // 单个业主
                if (2 == erpFunEntrust.getElectronicEntrustType()) {
                    saveEntrustInfoVO.setText("委托信息保存成功，您可通过以下方式邀请业主签订委托");
                    saveEntrustInfoVO.setSignAddr(AppConfig.getProperty("common.uuhfWebNet.path") + "/B/Home/ZtMeilian/entrustH5?entrustId=" + entrustId + "&ownerId=" + funEntrustOwners.getId() + "&cityId=" + cityId); // 二维码地址
                } else if (1 == erpFunEntrust.getElectronicEntrustType()) { // 标准委托
                    saveEntrustInfoVO.setText("签约信息已通过短信发送至业主手机，您也可通过以下方式邀请业主签订委托");
                    contractId = this.createContractId(erpFunEntrust, entrustOwnersList, cityId, certificateList);
                    // TODO 发送短信  调用美联的接口
                    entrustApiController.sendEntrustMsg(cityId, funEntrustOwners.getOwnerPhone(), erpFunEntrust.getEntrustEnd(),contractId,funEntrustOwners.getId());
                    // 美联提供二维码地址
                    saveEntrustInfoVO.setSignAddr(AppConfig.getErpWebUrl() + "/openApi/mlEntrustApi/perRegPage?contractId=" + contractId+"&ownerId=" + funEntrustOwners.getId() + "&cityId=" + cityId); // 二维码地址
                }
            }
            // 将合同ID保存到委托上，发送短信、获取二维码时需要用到
            if (StringUtil.isNotEmpty(contractId)) {
                ErpFunEntrust funEntrustUpdate = new ErpFunEntrust();
                funEntrustUpdate.setShardCityId(cityId);
                funEntrustUpdate.setEntrustId(entrustId);
                funEntrustUpdate.setContractId(contractId);
                erpFunEntrustMapper.updateByPrimaryKeySelective(funEntrustUpdate);
            }
        }
    
        // 记录跟进
        String trackDesc = userName + "于今日登记了该委托";
        this.createEntrustTrack(cityId, compId, userId, trackDesc, date, erpFunEntrust, (byte) 0);

        Integer houseUserId = null;
        Integer houseCompId = null;
        Byte houseStatus = null;
        if (erpFunEntrust.getCaseType() == Const.HouseCustType.SALE) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, erpFunEntrust.getCaseId());
            houseStatus = erpFunSale.getSaleStatus();
            houseUserId = erpFunSale.getUserId();
            houseCompId = erpFunSale.getCompId();
        } else if (erpFunEntrust.getCaseType() == Const.HouseCustType.LEASE) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, erpFunEntrust.getCaseId());
            houseStatus = erpFunLease.getLeaseStatus().byteValue();
            houseUserId = erpFunLease.getUserId();
            houseCompId = erpFunLease.getCompId();
        }

        // 请求threadTaskWeb
        LinkedHashMap<String, String> paramData = new LinkedHashMap<>();
        paramData.put("entrustId", entrustId.toString());
        paramData.put("cityId", cityId.toString());
        paramData.put("entrustStart", DateUtil.DateToString(erpFunEntrust.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        paramData.put("entrustEnd", erpFunEntrust.getEntrustEnd());
    
        try {
            // story#11736 房产资料独家委托新增量统计
            if (needAddKpi) {
                this.insertEntrustKpiLog(erpFunEntrust, date);
            }
            
            //请求请求threadTaskWeb
            HttpUtilNew.post(AppConfig.getProperty("common.threadTaskWeb.path") + "/systemApi/syncMlEntrustData", paramData, null);
            //请求houseCustWeb发布官网
            List<String> paramIds = new ArrayList<>();
            paramIds.add("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET");
            paramIds.add("RENT_HOUSE_PUBLISH_WEBSITE_SET");
            Map<String, String> sysParamMap = erpSysParaService.getMLSysParamMapByUserType(cityId, houseCompId, houseUserId, paramIds);
            if (sysParamMap.get("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET") != null || sysParamMap.get("RENT_HOUSE_PUBLISH_WEBSITE_SET") != null ) {
                if (("0".equals(sysParamMap.get("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET")) && erpFunEntrust.getCaseType() == 1)
                        || ("0".equals(sysParamMap.get("RENT_HOUSE_PUBLISH_WEBSITE_SET")) && erpFunEntrust.getCaseType() == 2)) {//二手房发官网设置,1:手动发布，0：自动发布
                    Map<String, Object> mlParamData = new HashMap<>();
                    mlParamData.put("caseId", erpFunEntrust.getCaseId());
                    mlParamData.put("caseType", erpFunEntrust.getCaseType());
                    mlParamData.put("flag", "0");
                    HttpUtil.postNewErp(AppConfig.getHouseCustWeb() + "/broker/house/sendHouseToWebsite", mlParamData, clientKey);
                }
            }
            return saveEntrustInfoVO;
        } catch (Exception e) {
            e.printStackTrace();
            return saveEntrustInfoVO;
        }


    }
    
    /**
     * 生成电子委托合同ID
     * @author HuangJiang
     * @since 2019年12月31日 11:33
     * @param erpFunEntrust
     * @param entrustOwnerList
     * @param cityId
     * @return java.lang.String
     * Modified XXX HuangJiang 2019年12月31日
     */
    private String createContractId(ErpFunEntrust erpFunEntrust, List<ErpFunEntrustOwners> entrustOwnerList, Integer cityId, List<EntrustCertificateInfoParam> certificateList) {
        //TODO 生成电子委托   返回合同ID  contractId
        Map<String, String> templateValues;
        AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
        String tidPrefix;
        if (adminFunCity != null) {
            if ("北京市".equals(adminFunCity.getCityName())) {
                tidPrefix="Electronic_delegate_Template_bj_";
                templateValues = getBjEntrustTemplateParam(erpFunEntrust);
            } else if ("成都市".equals(adminFunCity.getCityName())) {
                tidPrefix="Electronic_delegate_Template_cd_";
                templateValues = getCdEntrustTemplateParam(erpFunEntrust);
            } else if ("重庆市".equals(adminFunCity.getCityName())) {
                tidPrefix="Electronic_delegate_Template_cq_";
                templateValues = getCqEntrustTemplateParam(erpFunEntrust);
            } else if ("广州市".equals(adminFunCity.getCityName())) {
                tidPrefix="Electronic_delegate_Template_gz_or_zh_";
                templateValues = getGzOrZhEntrustTemplateParam(erpFunEntrust, "广州市越秀南路183号创举商务大厦2101之A", certificateList);
            } else if ("珠海市".equals(adminFunCity.getCityName())) {
                tidPrefix="Electronic_delegate_Template_gz_or_zh_";
                templateValues = getGzOrZhEntrustTemplateParam(erpFunEntrust, "珠海市香洲区港安街42号2015-2018办公（中安广场A栋2015-2018室）", certificateList);
            } else {//默认深圳市
                tidPrefix="Electronic_delegate_Template_sz_";
                templateValues = getSzEntrustTemplateParam(erpFunEntrust);
            } 
        } else {//默认深圳市
            tidPrefix="Electronic_delegate_Template_sz_";
            templateValues = getSzEntrustTemplateParam(erpFunEntrust);
        }
        Map resultMap = bestsignService.createContractSend2perTemplate(tidPrefix, templateValues, entrustOwnerList, cityId);
        if(resultMap == null || (resultMap.get("code") != null && !String.valueOf(resultMap.get("code")).equals("0"))) {
            System.out.println("-------------创建并发送合同失败"+resultMap.get("msg"));
            throw new BusinessException(resultMap.get("msg")+"");
        }
        String contractId = String.valueOf(resultMap.get("msg")+"");
        return contractId;
    }
    
    /**
     * 撤销委托
     * @param userName
     * @param compId
     * @param cityId
     * @param userId
     * @param erpFunEntrust
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     * @since 2019年11月27日 19:15
     */
    @Override
    @Transactional
    public void cancelEntrust(String userName, Integer compId, Integer cityId, Integer userId, ErpFunEntrust erpFunEntrust) {
        Date date = new Date();
        ErpFunEntrust erpFunEntrustUpdate = new ErpFunEntrust();
        erpFunEntrustUpdate.setShardCityId(cityId);
        erpFunEntrustUpdate.setEntrustId(erpFunEntrust.getEntrustId());
        // 委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署
        erpFunEntrustUpdate.setEntrustStatus((byte) 3);
        erpFunEntrustUpdate.setIsEffective((byte) 0); //是否有效（1=有效；0=无效）
        erpFunEntrustUpdate.setIncalidDate(date);
        erpFunEntrustUpdate.setIncalidReason(Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_2);
        erpFunEntrustMapper.updateByPrimaryKeySelective(erpFunEntrustUpdate);
        
        // 判断有无发起的正在审核中的审核流程，如果有 则需要修改为失效状态
        ErpAuditRuntimeExample erpAuditRuntimeExample = new ErpAuditRuntimeExample();
        erpAuditRuntimeExample.setShardCityId(cityId);
        ErpAuditRuntimeExample.Criteria criteria = erpAuditRuntimeExample.createCriteria();
        criteria.andCompIdEqualTo(compId).andTargetIdEqualTo(erpFunEntrust.getEntrustId()).andAuditStatusEqualTo((byte) 0);
        if (null != erpFunEntrust.getCaseId()) {
            criteria.andCaseIdEqualTo(erpFunEntrust.getCaseId());
        }
        if (null != erpFunEntrust.getCaseType()) {
            criteria.andCaseTypeEqualTo(erpFunEntrust.getCaseType().intValue());
        }
        List<ErpAuditRuntime> list = erpAuditRuntimeMapper.selectByExample(erpAuditRuntimeExample);
        if (list.size() > 0) {
            //ErpAuditRuntime erpAuditRuntime = erpAuditRuntimeMapper.
            ErpAuditRuntime erpAuditRuntime = new ErpAuditRuntime();
            erpAuditRuntime.setAuditStatus((byte) 5); // 审核状态，0=审核中 1=审核全部通过 2=未通过 3=已撤回 4=超期自动通过 5=已失效
            erpAuditRuntimeMapper.updateByExampleSelective(erpAuditRuntime, erpAuditRuntimeExample);
        }
        
        // 写跟进
        String trackDesc = userName + "于今日撤销了该委托";
        this.createEntrustTrack(cityId, compId, userId, trackDesc, date, erpFunEntrust, Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_2);
    }
    
    /**
     * 写跟进
     * @author HuangJiang
     * @since 2019年11月27日 19:44
     * @param cityId
     * @param compId
     * @param userId
     * @param trackDesc
     * @param date
     * @param erpFunEntrust
     * @param trackType  0 登记委托 1 删除委托 2.委托被撤销 3.委托签署时间超限 4.委托有效期时间超限  5.房源转暂缓 6.房源内成交 7房源外成交 8房源转删除 9清空备案 10修改价格 11.委托审核失败 12委托审核成功 13=修改委托 14=修改备案
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    private void createEntrustTrack(Integer cityId, Integer compId, Integer userId, String trackDesc, Date date, ErpFunEntrust erpFunEntrust, byte trackType) {
        ErpFunEntrustTrack erpFunEntrustTrack = new ErpFunEntrustTrack();
        erpFunEntrustTrack.setShardCityId(cityId);
        erpFunEntrustTrack.setCityId(cityId);
        erpFunEntrustTrack.setEntrustId(erpFunEntrust.getEntrustId());
        erpFunEntrustTrack.setCaseId(erpFunEntrust.getCaseId());
        erpFunEntrustTrack.setCaseType(erpFunEntrust.getCaseType());
        erpFunEntrustTrack.setCompId(compId);
        erpFunEntrustTrack.setTrackDesc(trackDesc);
        erpFunEntrustTrack.setTrackUid(userId);
        erpFunEntrustTrack.setTrackTime(DateUtil.DateToString(date));
        // 跟进类型（ 0 登记委托 1 删除委托 2.委托被撤销 3.委托签署时间超限 4.委托有效期时间超限  5.房源转暂缓 6.房源内成交 
        // 7房源外成交 8房源转删除 9清空备案 10修改价格 11.委托审核失败 12委托审核成功 13=修改委托 14=修改备案）
        erpFunEntrustTrack.setTrackType(trackType);
        erpFunEntrustTrackMapper.insertSelective(erpFunEntrustTrack);
        if(trackType == Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_1){
            ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
            ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsers.getOrganizationId());
            //写房源跟进
            ErpFunTrack erpFunTrack = new ErpFunTrack();
            erpFunTrack.setCompId(erpFunEntrust.getCompId());
            erpFunTrack.setTargetFlag(true);//带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过    备案没有审核，就直接通过，APP根据这个来展示在没在业务跟进里面
            erpFunTrack.setDeptId(erpFunUsers.getDeptId());
            erpFunTrack.setCaseType(erpFunEntrust.getCaseType());
            erpFunTrack.setCaseId(erpFunEntrust.getCaseId());
            erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_ENTRUST_RECORD_DEL);
            erpFunTrack.setTrackClassic("[ 清空备案 ]");
            erpFunTrack.setTargetId(erpFunEntrust.getCaseId());
            erpFunTrack.setTargetType(erpFunEntrust.getCaseType());
            erpFunTrack.setTrackContent("\n该房源委托失效，已清空备案");
            erpFunTrack.setTrackWarm(false);
            erpFunTrack.setCreatorUid(userId);
            erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
//            erpFunTrack.setCaseNo(erpFunSale.getSaleNo());
            erpFunTrack.setTrackResult((byte)0);
            erpFunTrack.setIsDel((byte)0);
            erpFunTrack.setTrackSource((byte)0);
            erpFunTrack.setIsUserTrack(0);
//            erpFunTrack.setCaseDeptId(erpFunSale.getDeptId());
            erpFunTrack.setIsDeltrack((byte)0);
            erpFunTrack.setDkPhotoCount(0);
            erpFunTrack.setVrPhoto(0);
            erpFunTrack.setDaikanNum(0);
            erpFunTrack.setOrganizationPath(erpFunUsers.getTissueLine());
            erpFunTrack.setOrganizationId(erpFunUsers.getOrganizationId());
//            erpFunTrack.setTargetOrganizationId(erpFunOrganization.getOrganizationId());
//            erpFunTrack.setCaseOrganizationId(erpFunOrganization.getOrganizationId());
            erpFunTrack.setOrganizationName(erpFunOrganization.getOrganizationName());
            erpFunTrack.setShardCityId(cityId);
            erpFunTrackMapper.insertFunTrack(erpFunTrack);
        }
    }
    
    /**
     * 删除委托
     * @param userName
     * @param compId
     * @param cityId
     * @param userId
     * @param erpFunEntrust
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     * @since 2019年11月27日 19:21
     */
    @Override
    @Transactional
    public void deleteEntrust(String userName, Integer compId, Integer cityId, Integer userId, ErpFunEntrust erpFunEntrust, String clientKey) {
        Date date = new Date();
        ErpFunEntrust erpFunEntrustUpdate = new ErpFunEntrust();
        erpFunEntrustUpdate.setShardCityId(cityId);
        erpFunEntrustUpdate.setEntrustId(erpFunEntrust.getEntrustId());
        // 委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署
        erpFunEntrustUpdate.setEntrustStatus((byte) 4);
        erpFunEntrustUpdate.setIsEffective((byte) 0); //是否有效（1=有效；0=无效）
        erpFunEntrustUpdate.setIncalidDate(date);
        erpFunEntrustUpdate.setIncalidReason(Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_1);
        erpFunEntrustMapper.updateByPrimaryKeySelective(erpFunEntrustUpdate);
    
        // 写跟进
        String trackDesc = userName + "于今日删除了该委托";
        this.createEntrustTrack(cityId, compId, userId, trackDesc, date, erpFunEntrust, Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_1);

        this.cleanEntrustInfo(erpFunEntrust);

        List<String> paramIds = new ArrayList<>();
        paramIds.add("SECOND_HAND_HOUSE_ANY_FILE_DELETE");
        paramIds.add("RENT_HOUSE_ANY_FILE_DELETE");
        Map<String, String> sysParamMap = erpSysParaService.getMLSysParamMapByUserType(cityId, compId, userId, paramIds);
        if ((erpFunEntrust.getCaseType() == 1 && sysParamMap.get("SECOND_HAND_HOUSE_ANY_FILE_DELETE") != null) || (erpFunEntrust.getCaseType() == 2 && sysParamMap.get("RENT_HOUSE_ANY_FILE_DELETE") != null)) {
            boolean doDownIt = false;
            if (erpFunEntrust.getCaseType() == 1 && "1".equals(sysParamMap.get("SECOND_HAND_HOUSE_ANY_FILE_DELETE"))) {
                doDownIt = true;
            }
            if (erpFunEntrust.getCaseType() == 2 && "1".equals(sysParamMap.get("RENT_HOUSE_ANY_FILE_DELETE"))) {
                doDownIt = true;
            }
            if (doDownIt) {
                Map<String, Object> paramData = new HashMap<>();
                paramData.put("caseId", erpFunEntrust.getCaseId());
                paramData.put("caseType", erpFunEntrust.getCaseType());
                paramData.put("flag", "0");
                String res = HttpUtil.postNewErp(AppConfig.getHouseCustWeb() + "/broker/house/downHouseFromWebsite", paramData, clientKey);
                System.out.println(res);
            }
        }
    }

     /**
     * 委托失效时，修改房源信息中的委托相关信息
     * @detail [2020年05月18日] HuangJiang
     * @author HuangJiang
     * @since 2020年05月18日 16:41
     * @param erpFunEntrust
     * @return void
     * Modified XXX HuangJiang 2020年05月18日
     */
    public void cleanEntrustInfo(ErpFunEntrust erpFunEntrust) {
        if (null != erpFunEntrust.getCaseType() && null != erpFunEntrust.getCaseId()) {
            if (erpFunEntrust.getCaseType() == 1) { // 出售
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(1, erpFunEntrust.getCaseId());
                if (null != erpFunSale) {
                    erpFunSaleMapper.cleanEntrustInfoBySaleId(1, erpFunEntrust.getCaseId());
                    if (null != erpFunEntrust.getIsShare() && erpFunEntrust.getIsShare() == 1 && null != erpFunSale.getSaleLeaseId()) { // 租售房源共享委托
                        erpFunLeaseMapper.cleanEntrustInfoByLeaseId(1, erpFunSale.getSaleLeaseId());
                    }
                }
            } else if (erpFunEntrust.getCaseType() == 2) { // 出租
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(1, erpFunEntrust.getCaseId());
                if (null != erpFunLease) {
                    erpFunLeaseMapper.cleanEntrustInfoByLeaseId(1, erpFunEntrust.getCaseId());
                    if (null != erpFunEntrust.getIsShare() && erpFunEntrust.getIsShare() == 1 && null != erpFunLease.getSaleLeaseId()) { // 租售房源共享委托
                        erpFunSaleMapper.cleanEntrustInfoBySaleId(1, erpFunLease.getSaleLeaseId());
                    }
                }
            }
        }
    }
    
    /**
     * 修改委托
     * @param param
     * @param cityId
     * @param compId
     * @param userId
     * @param deptName
     * @param userName
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     * @since 2019年11月27日 20:25
     */
    @Override
    @Transactional
    public void updateEntrustInfo(SaveEntrustInfoParam param, Integer cityId, Integer compId, Integer userId, String deptName, String userName) throws Exception {
        ErpFunEntrust erpFunEntrust = new ErpFunEntrust();
        BeanUtil.copyObject(param, erpFunEntrust);
        Date date = new Date();
        Integer entrustId = erpFunEntrust.getEntrustId(); // 委托ID
        
        // 更新委托
        erpFunEntrust.setShardCityId(cityId);
        erpFunEntrustMapper.updateEntrustInfo(erpFunEntrust);
        
        // 保存业主信息 先删除 后插入
        ErpFunEntrustOwnersExample erpFunEntrustOwnersExample = new ErpFunEntrustOwnersExample();
        erpFunEntrustOwnersExample.setShardCityId(cityId);
        erpFunEntrustOwnersExample.createCriteria().andEntrustIdEqualTo(entrustId);
        erpFunEntrustOwnersMapper.deleteByExample(erpFunEntrustOwnersExample);
        
        List<EntrustOwnersInfoParam> ownersList = param.getOwnersList();
        ownersList.stream().forEach(owner -> {
            ErpFunEntrustOwners erpFunEntrustOwners = new ErpFunEntrustOwners();
            erpFunEntrustOwners.setShardCityId(cityId);
            erpFunEntrustOwners.setEntrustId(entrustId);
            BeanUtils.copyProperties(owner, erpFunEntrustOwners);
            erpFunEntrustOwners.setIsSign((byte) 1); // 纸质委托默认业主已签约
            erpFunEntrustOwners.setSignDate(date);
            erpFunEntrustOwnersMapper.insertSelective(erpFunEntrustOwners);
        });
        
        // 保存产证号信息 先删除 后插入
        ErpFunEntrustCertificateExample erpFunEntrustCertificateExample = new ErpFunEntrustCertificateExample();
        erpFunEntrustCertificateExample.setShardCityId(cityId);
        erpFunEntrustCertificateExample.createCriteria().andEntrustIdEqualTo(entrustId);
        erpFunEntrustCertificateMapper.deleteByExample(erpFunEntrustCertificateExample);
        
        List<EntrustCertificateInfoParam> certificateList = param.getCertificateList();
        certificateList.stream().forEach(certificate -> {
            ErpFunEntrustCertificate erpFunEntrustCertificate = new ErpFunEntrustCertificate();
            erpFunEntrustCertificate.setShardCityId(cityId);
            erpFunEntrustCertificate.setEntrustId(entrustId);
            BeanUtils.copyProperties(certificate, erpFunEntrustCertificate);
            erpFunEntrustCertificateMapper.insertSelective(erpFunEntrustCertificate);
        });
        
        // 保存附件信息 先全部删除，再重新插入
        ErpFunEntrustFilesExample erpFunEntrustFilesExample = new ErpFunEntrustFilesExample();
        erpFunEntrustFilesExample.setShardCityId(cityId);
        erpFunEntrustFilesExample.createCriteria().andEntrustIdEqualTo(entrustId);
        erpFunEntrustFilesMapper.deleteByExample(erpFunEntrustFilesExample);
        
        List<EntrustFileInfoParam> fileList = param.getFileList();
        fileList.stream().forEach(file -> {
            ErpFunEntrustFiles erpFunEntrustFiles = new ErpFunEntrustFiles();
            erpFunEntrustFiles.setShardCityId(cityId);
            erpFunEntrustFiles.setEntrustId(entrustId);
            erpFunEntrustFiles.setUpdateTime(date);
            BeanUtils.copyProperties(file, erpFunEntrustFiles);
            // 此处兼容一下，如果前端传回来的文件名没有包含文件后缀，则将后缀拼在文件名后面
            if (StringUtil.isNotEmpty(erpFunEntrustFiles.getFileExt()) && StringUtil.isNotEmpty(erpFunEntrustFiles.getFileName()) && !erpFunEntrustFiles.getFileName().endsWith("." + erpFunEntrustFiles.getFileExt())) {
                erpFunEntrustFiles.setFileName(erpFunEntrustFiles.getFileName() + "." + erpFunEntrustFiles.getFileExt());
            }
            erpFunEntrustFilesMapper.insertSelective(erpFunEntrustFiles);
        });
        
        // 跟进
        String trackDesc = userName + "于今日修改了该委托";
        this.createEntrustTrack(cityId, compId, userId, trackDesc, date, erpFunEntrust, Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_13);
    }
    
    /**
     * 修改备案（添加，修改或清空备案）
     * detail task#12332 [20-5-12] wc 备案增加委托价格
     * detail task#0 [20-5-16] wc 清空备案同时清除房源上的备案标记和委托价格标记  添加/修改备案同时设置房源上的备案标记和委托价格标记
     * @param operator
     * @param erpFunEntrust
     * @param param
     * @return void
     * Modified XXX HuangJiang 2019年11月28日
     * @since 2019年11月28日 13:44
     */
    @Override
    @Transactional
    public void updateEntrustRecord(Operator operator, ErpFunEntrust erpFunEntrust, UpdateEntrustRecordParam param) {
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer compId = operator.getCompId();
        String userName =  operator.getUserName();
        Date date = new Date();
        ErpFunEntrust entrustOld = new ErpFunEntrust();
        ErpFunEntrust erpFunEntrustUpdate = new ErpFunEntrust();
        erpFunEntrustUpdate.setShardCityId(cityId);
        erpFunEntrustUpdate.setEntrustId(param.getEntrustId());
        erpFunEntrustUpdate.setRecordUpdateTime(date);

        erpFunEntrustRecordNoMapper.deleteByEntrustId(cityId,param.getEntrustId());//物理删除备案编号，因为清空备案都是置空
        // 操作类型 1=添加备案 2=修改备案 3=清空备案（同时需要失效该委托）
        String trackDesc = "";
        byte trackType = (byte) 14; // 修改备案
        if (param.getOperateType() == 3) {
            trackDesc = userName + "于今日进行了清空备案的操作，委托变为失效。";
            trackType = (byte) 9; // 清空备案
            erpFunEntrustUpdate.setIsEffective((byte) 0); // 是否有效（1=有效；0=无效）
            // 委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格
            erpFunEntrustUpdate.setEntrustStatus((byte) 12);
            erpFunEntrustUpdate.setIncalidDate(date);
            erpFunEntrustUpdate.setIncalidReason(Const.ML_ENTRUST_INCALID_REASON.INCALID_REASON_9);
            erpFunEntrustUpdate.setRecordStatus((byte) 3); // 备案状态（1=未备案 2=已备案 0=清空备案）
            erpFunEntrustUpdate.setRecordOrganizationName(null);
            erpFunEntrustUpdate.setRecordUser(null);
            erpFunEntrustUpdate.setRecordNo(null);
            erpFunEntrustMapper.clearEntrustRecord(erpFunEntrustUpdate);
        } else {
            if (param.getOperateType() == 1) {
                trackDesc = userName +  "于今日添加了备案。";
            } else {
                trackDesc = userName + "于今日修改了备案";
                entrustOld = erpFunEntrustMapper.selectByPrimaryKey(erpFunEntrustUpdate);//修改的话把老的查询出来对比修改了哪些，写入日志中
            }
            erpFunEntrustUpdate.setRecordUser(param.getRecordUser());
            erpFunEntrustUpdate.setRecordTime(param.getRecordTime());
            erpFunEntrustUpdate.setRecordNo(param.getRecordNo());
            erpFunEntrustUpdate.setSaleEntrustPrice(param.getSaleEntrustPrice());
            erpFunEntrustUpdate.setLeaseEntrustPrice(param.getLeaseEntrustPrice());
            erpFunEntrustUpdate.setPriceUnit(param.getPriceUnit());
            erpFunEntrustUpdate.setRecordStatus((byte) 2); // 备案状态（1=未备案 2=已备案 0=清空备案）
            
            ErpFunEntrustRecordKpiTrack erpFunEntrustRecordKpiTrack = new ErpFunEntrustRecordKpiTrack();
            erpFunEntrustRecordKpiTrack.setContent(trackDesc);
            
            // 查询备案人部门
            ErpFunUsers funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, param.getRecordUser());
            if (null != funUsers && null != funUsers.getOrganizationId()) {
                erpFunEntrustRecordKpiTrack.setOrganizationId(funUsers.getOrganizationId());
                erpFunEntrustRecordKpiTrack.setOrganizationPath(funUsers.getTissueLine());
                ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, funUsers.getOrganizationId());
                if (null != erpFunOrganization) {
                    erpFunEntrustUpdate.setRecordOrganizationName(erpFunOrganization.getOrganizationName());
                }
            }
            erpFunEntrustMapper.updateEntrust(erpFunEntrustUpdate);
            
            // story#11736 KPI 备案次数统计 只在新增备案的时候触发  如同一房源当月新增备案x次则计算x次，备案号清空不影响 记录在备案日期（前端选择）那一天
            // 操作类型 1=添加备案 2=修改备案 3=清空备案（同时需要失效该委托）
            if (param.getOperateType() == 1) {
                ErpFunEntrustRecordKpiLog erpFunEntrustRecordKpiLog = new ErpFunEntrustRecordKpiLog();
                erpFunEntrustRecordKpiLog.setShardCityId(cityId);
                erpFunEntrustRecordKpiLog.setCompId(erpFunEntrust.getCompId());
                erpFunEntrustRecordKpiLog.setEntrustId(erpFunEntrust.getEntrustId());
                erpFunEntrustRecordKpiLog.setRecordNo(param.getRecordNo()); // 本次备案的备案号
                erpFunEntrustRecordKpiLog.setCaseId(erpFunEntrust.getCaseId());
                erpFunEntrustRecordKpiLog.setCaseType(erpFunEntrust.getCaseType());
                erpFunEntrustRecordKpiLog.setUserId(param.getRecordUser()); // 备案人（房产资料上传人）
                erpFunEntrustRecordKpiLog.setCreateTime(param.getRecordTime()); // 记录在备案日期（前端选择）那一天；不是记录在添加备案的时间
                erpFunEntrustRecordKpiLogMapper.insertSelective(erpFunEntrustRecordKpiLog);
    
                // 次数同步到经纪人KPI日表中去
                ErpKpiStatisticBrokerPerformanceExample erpKpiStatisticBrokerPerformanceExample = new ErpKpiStatisticBrokerPerformanceExample();
                erpKpiStatisticBrokerPerformanceExample.setShardCityId(cityId);
                erpKpiStatisticBrokerPerformanceExample.createCriteria().andUserIdEqualTo(param.getRecordUser())
                        .andCreateTimeBetween(DateUtil.StringToDate(DateUtil.DateToString(param.getRecordTime(), "yyyy-MM-dd") + " 00:00:00"), DateUtil.getLastSecondOfDay(param.getRecordTime()));
                erpKpiStatisticBrokerPerformanceExample.setOrderByClause(" CREATE_TIME ASC ");
                ErpKpiStatisticBrokerPerformance erpKpiStatisticBrokerPerformance = erpKpiStatisticBrokerPerformanceMapper.selectOneByExample(erpKpiStatisticBrokerPerformanceExample);
                if (null != erpKpiStatisticBrokerPerformance) {
                    ErpKpiStatisticBrokerPerformance kpiStatisticBrokerPerformanceUpdate = new ErpKpiStatisticBrokerPerformance();
                    kpiStatisticBrokerPerformanceUpdate.setShardCityId(cityId);
                    kpiStatisticBrokerPerformanceUpdate.setId(erpKpiStatisticBrokerPerformance.getId());
                    Integer oldCount = null == erpKpiStatisticBrokerPerformance.getHouseRegistration() ? 0 : erpKpiStatisticBrokerPerformance.getHouseRegistration();
                    kpiStatisticBrokerPerformanceUpdate.setHouseRegistration(oldCount + 1); // 备案
                    kpiStatisticBrokerPerformanceUpdate.setUpdateTime(date);
                    erpKpiStatisticBrokerPerformanceMapper.updateByPrimaryKeySelective(kpiStatisticBrokerPerformanceUpdate);
                } else {
                    erpFunEntrustRecordKpiTrack.setContent(trackDesc + "次数未记录。");
                }
                // 备案记录KPI日志
                erpFunEntrustRecordKpiTrack.setShardCityId(cityId);
                erpFunEntrustRecordKpiTrack.setCompId(compId);
                erpFunEntrustRecordKpiTrack.setUserId(param.getRecordUser()); // 备案人
                erpFunEntrustRecordKpiTrack.setCaseId(erpFunEntrust.getCaseId());
                erpFunEntrustRecordKpiTrack.setCaseType(erpFunEntrust.getCaseType());
                erpFunEntrustRecordKpiTrack.setEntrustId(erpFunEntrust.getEntrustId());
                erpFunEntrustRecordKpiTrack.setRecordNo(param.getRecordNo());
                erpFunEntrustRecordKpiTrack.setRecordTime(param.getRecordTime());
                erpFunEntrustRecordKpiTrack.setCreateTime(new Date());
                erpFunEntrustRecordKpiTrackMapper.insertSelective(erpFunEntrustRecordKpiTrack);
            }
            //12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料 #3
            //因为要实现精准查询，将备案编号同时维护一份到FUN_ENTRUST_RECORD_NO表

        }

        if(StringUtil.isNotBlank(param.getRecordNo())){//将备案编号拆开多维护一张表，用于在房源列表和审核列表进行精确查询
            String[] recordNo = param.getRecordNo().split(",");
            for (String dimension : recordNo) {
                if(StringUtil.isBlank(dimension)){
                    continue;
                }
                ErpFunEntrustRecordNo funEntrustRecordNo = new ErpFunEntrustRecordNo();
                funEntrustRecordNo.setShardCityId(cityId);
                funEntrustRecordNo.setEntrustId(param.getEntrustId());
                funEntrustRecordNo.setRecordNo(dimension);
                erpFunEntrustRecordNoMapper.insertSelective(funEntrustRecordNo);
            }
        }


        //detail task#0 [20-5-16] wc 清空备案同时清除房源上的备案标记和委托价格标记  添加/修改备案同时设置房源上的备案标记和委托价格标记
        if (erpFunEntrust.getCaseId() != null) {
            boolean clear = param.getOperateType() == 3;
            if (Byte.valueOf("1").equals(erpFunEntrust.getCaseType())) {
                ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, erpFunEntrust.getCaseId());
                if (erpFunSale != null) {
                    erpFunSaleMapper.setEntrustInfoBySaleId(cityId, erpFunEntrust.getCaseId(), clear ? 0 : 1, clear ? 0 : 1, clear ? null : param.getSaleEntrustPrice());
                    if (Byte.valueOf("1").equals(erpFunEntrust.getIsShare()) && null != erpFunSale.getSaleLeaseId()) {
                        erpFunLeaseMapper.setEntrustInfoByLeaseId(cityId, erpFunSale.getSaleLeaseId(), clear ? 0 : 1, clear ? 0 : 1, clear ? null : param.getLeaseEntrustPrice());
                    }
                }
            } else if (Byte.valueOf("2").equals(erpFunEntrust.getCaseType())) {
                ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, erpFunEntrust.getCaseId());
                if (null != erpFunLease) {
                    erpFunLeaseMapper.setEntrustInfoByLeaseId(cityId, erpFunEntrust.getCaseId(), clear ? 0 : 1 , clear ? 0 : 1 , clear ? null : param.getLeaseEntrustPrice());
                    if (Byte.valueOf("1").equals(erpFunEntrust.getIsShare()) && null != erpFunLease.getSaleLeaseId()) {
                        erpFunSaleMapper.setEntrustInfoBySaleId(cityId, erpFunLease.getSaleLeaseId(), clear ? 0 : 1 , clear ? 0 : 1 , clear ? null : param.getSaleEntrustPrice());
                    }
                }
            }
        }

        // 写跟进
        this.createEntrustTrack(cityId, compId, userId, trackDesc, date, erpFunEntrust, trackType);
        //12544 6.15上线 PC&APP房源委托备案成功后，在房源生成相应的跟进记录
        erpFunEntrustUpdate.setCaseId(erpFunEntrust.getCaseId());
        erpFunEntrustUpdate.setCaseType(erpFunEntrust.getCaseType());
        this.createRecordTrack(cityId, compId, userId,entrustOld,erpFunEntrustUpdate,param.getOperateType());
    }

    public void createRecordTrack(Integer cityId,Integer compId,Integer userId,ErpFunEntrust entrustOld,ErpFunEntrust erpFunEntrust,Integer operateType){
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);//当前登录人
        String caseNo = "";
        Integer organizationId = 0;
        Integer organizationCompId = 0;
        Byte trackType = Const.DIC_TRACK_TYPE_ENTRUST_RECORD_ADD;
        String trackClassic = "[ 委托备案 ]";
        operateType = null == operateType ? 1 : operateType;
        if(null != erpFunEntrust.getCaseType() && Const.DIC_CASE_TYPE_SALE_FUN.equals(erpFunEntrust.getCaseType().intValue())){
            ErpFunSale sale = new ErpFunSale();
            sale.setShardCityId(cityId);
            sale.setSaleId(erpFunEntrust.getCaseId());
            sale = erpFunSaleMapper.selectByPrimaryKey(sale);
            caseNo = sale.getSaleNo();
            organizationId = sale.getOrganizationId();
            organizationCompId = sale.getCompId();
        } else {
            ErpFunLease lease = new ErpFunLease();
            lease.setShardCityId(cityId);
            lease.setLeaseId(erpFunEntrust.getCaseId());
            lease = erpFunLeaseMapper.selectByPrimaryKey(lease);
            caseNo = lease.getLeaseNo();
            organizationId = lease.getOrganizationId();
            organizationCompId = lease.getCompId();
        }
        String trackContent = "";
        String priceUnit = "";
        if("1".equals(operateType.toString())){
            ErpFunUsers newRecordUser = erpFunUsersMapper.selectByUserId(cityId, erpFunEntrust.getRecordUser());//新备案人
            trackContent = "\n备案人：" + newRecordUser.getUserName() + "\n备案日期：" + DateUtil.DateToString(new Date(),"yyyy-MM-dd") + "\n备案号：" + erpFunEntrust.getRecordNo();
            if(null != erpFunEntrust.getLeaseEntrustPrice()){
                DecimalFormat df = new DecimalFormat("###.##");
                trackContent += "\n出租委托价格：" + df.format(erpFunEntrust.getLeaseEntrustPrice());
                if(null != erpFunEntrust.getPriceUnit() && erpFunEntrust.getPriceUnit().equals((byte) 1)){
                    priceUnit = "元/月";
                } else if(null != erpFunEntrust.getPriceUnit() && erpFunEntrust.getPriceUnit().equals((byte) 5)){
                    priceUnit = "元/年";
                } else if(null != erpFunEntrust.getPriceUnit() && erpFunEntrust.getPriceUnit().equals((byte) 3)){
                    priceUnit = "元/平米*月";
                }
                trackContent += priceUnit;
            }
            if(null != erpFunEntrust.getSaleEntrustPrice()){
                DecimalFormat df = new DecimalFormat("###.##");
                trackContent += "\n出售委托价格：" + df.format(erpFunEntrust.getSaleEntrustPrice()) + "万元";
            }
        } else if ("2".equals(operateType.toString())){
            //如果为空就设置为0，下面进行判断，并不会修改数据
            entrustOld.setLeaseEntrustPrice(null == entrustOld.getLeaseEntrustPrice() ? new BigDecimal(0) : entrustOld.getLeaseEntrustPrice());
            entrustOld.setSaleEntrustPrice(null == entrustOld.getSaleEntrustPrice() ? new BigDecimal(0) : entrustOld.getSaleEntrustPrice());
            erpFunEntrust.setLeaseEntrustPrice(null == erpFunEntrust.getLeaseEntrustPrice() ? new BigDecimal(0) : erpFunEntrust.getLeaseEntrustPrice());
            erpFunEntrust.setSaleEntrustPrice(null == erpFunEntrust.getSaleEntrustPrice() ? new BigDecimal(0) : erpFunEntrust.getSaleEntrustPrice());
            trackType = Const.DIC_TRACK_TYPE_ENTRUST_RECORD_UPDATE;
            trackClassic = "[ 修改备案 ]";
            if(!entrustOld.getRecordUser().equals(erpFunEntrust.getRecordUser())){
                ErpFunUsers oldRecordUser = erpFunUsersMapper.selectByUserId(cityId, entrustOld.getRecordUser());//老的备案人
                ErpFunUsers newRecordUser = erpFunUsersMapper.selectByUserId(cityId, erpFunEntrust.getRecordUser());//新备案人
                trackContent = "\n备案人：" + oldRecordUser.getUserName() + " >> " + newRecordUser.getUserName();
            }
            if(entrustOld.getRecordTime().compareTo(erpFunEntrust.getRecordTime()) != 0){
                trackContent += "\n备案日期：" + DateUtil.DateToString(entrustOld.getRecordTime(),"yyyy-MM-dd") + " >> " + DateUtil.DateToString(erpFunEntrust.getRecordTime(),"yyyy-MM-dd");
            }
            if(!entrustOld.getRecordNo().equals(erpFunEntrust.getRecordNo())){
                trackContent += "\n备案号：" + entrustOld.getRecordNo() + " >> " + erpFunEntrust.getRecordNo();
            }
            String priceUnitNow = this.priceUnitSwitch(erpFunEntrust.getPriceUnit());
            String priceUnitOld = this.priceUnitSwitch(entrustOld.getPriceUnit());
            if(entrustOld.getLeaseEntrustPrice().compareTo(erpFunEntrust.getLeaseEntrustPrice()) != 0){
                DecimalFormat df = new DecimalFormat("###.##");
                trackContent += "\n出租委托价格：" + df.format(entrustOld.getLeaseEntrustPrice()) + priceUnitOld +" >> " + df.format(erpFunEntrust.getLeaseEntrustPrice()) + priceUnitNow;
            } else if(!priceUnitNow.equals(priceUnitOld)){
                DecimalFormat df = new DecimalFormat("###.##");
                trackContent += "\n出租委托价格：" + df.format(entrustOld.getLeaseEntrustPrice()) + priceUnitOld +" >> " + df.format(erpFunEntrust.getLeaseEntrustPrice()) + priceUnitNow;
            }
            if(entrustOld.getSaleEntrustPrice().compareTo(erpFunEntrust.getSaleEntrustPrice()) != 0){
                DecimalFormat df = new DecimalFormat("###.##");
                trackContent += "\n出售委托价格：" + df.format(entrustOld.getSaleEntrustPrice()) + "万元 >> " + df.format(erpFunEntrust.getSaleEntrustPrice()) + "万元";
            }
        } else if ("3".equals(operateType.toString())){
            trackType = Const.DIC_TRACK_TYPE_ENTRUST_RECORD_DEL;
            trackClassic = "[ 清空备案 ]";
            trackContent = "\n" + erpFunUsers.getUserName() + "清空了该房源的备案";
        }
        ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, organizationCompId, organizationId);
        ErpFunTrack erpFunTrack = new ErpFunTrack();
        erpFunTrack.setCompId(compId);
        erpFunTrack.setTargetFlag(true);//带看标记2008-11-19更新为所有审核通过标记，null=初始值 1=审核通过 0=审核未通过    备案没有审核，就直接通过，APP根据这个来展示在没在业务跟进里面
        erpFunTrack.setDeptId(erpFunUsers.getDeptId());
        erpFunTrack.setCaseType(erpFunEntrust.getCaseType());
        erpFunTrack.setCaseId(erpFunEntrust.getCaseId());
        erpFunTrack.setTrackType(trackType);
        erpFunTrack.setTrackClassic(trackClassic);
        erpFunTrack.setTargetId(erpFunEntrust.getCaseId());
        erpFunTrack.setTargetType(erpFunEntrust.getCaseType());
        erpFunTrack.setTrackContent(trackContent);
        erpFunTrack.setTrackWarm(false);
        erpFunTrack.setCreatorUid(userId);
        erpFunTrack.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date()));
        erpFunTrack.setCaseNo(caseNo);
        erpFunTrack.setTrackResult((byte)0);
        erpFunTrack.setIsDel((byte)0);
        erpFunTrack.setTrackSource((byte)0);
        erpFunTrack.setIsUserTrack(0);
        erpFunTrack.setCaseDeptId(compId);
        erpFunTrack.setIsDeltrack((byte)0);
        erpFunTrack.setDkPhotoCount(0);
        erpFunTrack.setVrPhoto(0);
        erpFunTrack.setDaikanNum(0);
        erpFunTrack.setOrganizationPath(erpFunUsers.getTissueLine());
        erpFunTrack.setOrganizationId(erpFunUsers.getOrganizationId());
        erpFunTrack.setTargetOrganizationId(organizationId);
        erpFunTrack.setCaseOrganizationId(organizationId);
        erpFunTrack.setOrganizationName(erpFunOrganization.getOrganizationName());
        erpFunTrack.setShardCityId(cityId);
        erpFunTrackMapper.insertFunTrack(erpFunTrack);
    }

    private String priceUnitSwitch(Byte price){
        if(null == price){
            return "元/月";
        }
        if(price.equals((byte) 5)){
            return "元/年";
        } else if(price.equals((byte) 3)){
            return "元/平米*月";
        } else{
            return "元/月";
        }
    }
    
    /**
     * 获取业主列表
     * @author HuangJiang
     * @since 2019年11月26日 10:04
     * @param cityId 城市ID
     * @param entrustId 委托ID
     * @return java.util.List<com.myfun.repository.erpdb.po.ErpFunEntrustOwners>
     * Modified XXX HuangJiang 2019年11月26日
     */
    private List<ErpFunEntrustOwners> getEntrustOwnersList(Integer cityId, Integer entrustId) {
        ErpFunEntrustOwnersExample erpFunEntrustOwnersExample = new ErpFunEntrustOwnersExample();
        erpFunEntrustOwnersExample.setShardCityId(cityId);
        erpFunEntrustOwnersExample.createCriteria().andEntrustIdEqualTo(entrustId);
        List<ErpFunEntrustOwners> entrustOwnersList = erpFunEntrustOwnersMapper.selectByExample(erpFunEntrustOwnersExample);
        return entrustOwnersList;
    }
    
    /**  
    * @author 蔡春林 深圳电子委托 获取模板参数
    * @date 2020/2/5 0005
    * @param erpFunEntrust
    * @return java.util.Map<java.lang.String,java.lang.String>
    */
    private Map<String, String> getSzEntrustTemplateParam(ErpFunEntrust erpFunEntrust) {
        HashMap<String, String> templateParam = new HashMap<>();
        String text42 = "";//委托人姓名
        String text43 = "";//委托人证件号码
        String text44 = "";//代理人
        String text46 = "";//代理人证件号码
        String text47 = "";//委托人地址
        String text48 = "";//text43:委托人电话号码
        String text52 = "";//楼盘名称
        String text53 = "";//房源编号
        String text54 = "";//建筑面积
        String text55 = "";//出售（√）
        String text56 = "";//出租（√）
        String text57 = "";//产权完整（√）
        String text58 = "";//有抵押（√）
        String text59 = "";//无租约（√）
        String text60 = "";//有租约（√）
        String text61 = "";//租约开始（年）
        String text62 = "";//租约开始（月）
        String text63 = "";//租约开始（日）
        String text64 = "";//租约结束（年）
        String text65 = "";//租约结束（月）
        String text66 = "";//租约结束（日）
        String text68 = "";//租金价格大写
        String text70 = "";//租金价格小写
        String text71 = "";//委托开始（年）
        String text72 = "";//委托开始（月）
        String text73 = "";//委托开始（日） 
        String text74 = "";//委托结束（年）
        String text75 = "";//委托结束（月）
        String text76 = "";//委托结束（日）
        String text78 = "";//独家委托（√）
        String text79 = "";//非独家委托（√）
        String text80 = "";//房地产证复印件（√）
        String text81 = "";//产权人身份资料复印件（√）
        String text82 = "";//房地产买卖合同复印件（√）
        String text83 = "";//购买发票复印件（√）
        String text84 = "";//付清房款证明书复印件（√）
        String text85 = "";//产权人委托书（√）
        String text86 = "";//其他（√）
        String text87 = "";//其他的内容
        String text89 = "";//甲方将该物业钥匙交于乙方作看房之用 （√）
        String text90 = "";//双方另行约定时间看房（√）
        String text91 = "";//出售价格中文
        String text92 = "";//出租价格中文
        String text93 = "";//出售价格数字
        String text94 = "";//出租价格数字
        String text95 = "";//出售佣金中文
        String text96 = "";//出售佣金数字
        String text97 = "";//出租佣金几个月租金
        String text98 = "";//甲方联系地址
        String text99 = "";//甲方联系人
        String text100 = "";//甲方联系电话
   
        String stamp = "";//美联公司印章
        String text125 = erpFunEntrust.getEntrustNo();//委托编号
        String nowDate = DateUtil.DateToString(new Date(), "yyyy-MM-dd");
        String[] nowDateArray = nowDate.split("-");
        String text108 = nowDateArray[0];//签约年
        String text109 = nowDateArray[1];//签约月
        String text110 = nowDateArray[2];//签约日
        Byte entrustBusiness = erpFunEntrust.getEntrustBusiness();
        if (erpFunEntrust.getHouseStatus() != null&&erpFunEntrust.getHouseStatus()==1) {
            text57 = "√";
        } else if (erpFunEntrust.getHouseStatus() != null && erpFunEntrust.getHouseStatus() == 2) {
            text58 = "√";
        }
        if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 0) {
            text59 = "√";
        } else if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 1) {
            text60 = "√";
            if (erpFunEntrust.getLeaseEndTime() != null) {
                String leaseEnd = DateUtil.DateToString(erpFunEntrust.getLeaseEndTime(), "yyyy-MM-dd");
                String[] leaseEndArray = leaseEnd.split("-");
                text64 = leaseEndArray[0];//租约结束（年）
                text65 = leaseEndArray[1];//租约结束（月）
                text66 = leaseEndArray[2];//租约结束（日）
            }
        }
        if (erpFunEntrust.getOldRentMoney() != null) {
            text68 = Num2RMB.NumToRMBStr(erpFunEntrust.getOldRentMoney().toString());
            text70 = erpFunEntrust.getOldRentMoney().toString();
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustStart())) {
            String[] entrustStart = erpFunEntrust.getEntrustStart().split("-");
            text71 = entrustStart[0];
            text72 = entrustStart[1];
            text73 = entrustStart[2];
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustEnd())) {
            String[] entrustEnd = erpFunEntrust.getEntrustEnd().split("-");
            text74 = entrustEnd[0];
            text75 = entrustEnd[1];
            text76 = entrustEnd[2];
        }
        if (erpFunEntrust.getEntrustType() != null && erpFunEntrust.getEntrustType() == 1) {
            text79 = "√";
        } else if (erpFunEntrust.getEntrustType() != null && erpFunEntrust.getEntrustType() == 2) {
            text78 = "√";
        }

        if (erpFunEntrust.getInspectionType() != null && erpFunEntrust.getInspectionType() == 1) {
            text89 = "√";
 
        } else if (erpFunEntrust.getInspectionType() != null && erpFunEntrust.getInspectionType() == 2) {
            text90 = "√";
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustom())) {
            String[] depositFileForCustom = erpFunEntrust.getDepositFileForCustom().split(",");
            for (String depositFile : depositFileForCustom) {
                if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_1.equals(depositFile)) {
                    text80 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_2.equals(depositFile)) {
                    text81 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_3.equals(depositFile)) {
                    text82 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_4.equals(depositFile)) {
                    text83 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_5.equals(depositFile)) {
                    text84 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_6.equals(depositFile)) {
                    text85 = "√";
                }
            }
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustomOther())) {
            text86 = "√";
            text87 = erpFunEntrust.getDepositFileForCustomOther();
        }
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(erpFunEntrust.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(erpFunEntrust.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() == 0) {
            return templateParam;
        }
        List<OwnerUserVO> ownerUserVOList = new ArrayList<>();
       
        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            text42 += (ownerUserVO.getOwnerName() + " ");
            text43 += (ownerUserVO.getCardNo() + " ");
            text47 += (ownerUserVO.getAddress() + " ");
            text48 += (ownerUserVO.getOwnerPhone() + " ");
            text98 += (ownerUserVO.getAddress() + " ");
            text99 += (ownerUserVO.getOwnerName() + " ");
            text100+=(ownerUserVO.getOwnerPhone() + " ");
        }
        
        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(erpFunEntrust.getCityId());
            funSale.setShardCityId(erpFunEntrust.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale != null) {
//                text53 = erpFunSale.getSaleNo();
                text54 = erpFunSale.getSaleArea() == null ? " " : erpFunSale.getSaleArea().toString();
                text55 = "√";
                //buildName 需要取楼盘的注册名才会有法律效应
                String buildName = "";
                if (erpFunSale.getBuildId() != null) {
                    ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
                    erpBuildingInfo.setShardCityId(erpFunSale.getCityId());
                    erpBuildingInfo.setCityId(erpFunSale.getCityId().shortValue());
                    erpBuildingInfo.setBuildId(erpFunSale.getBuildId());
                    erpBuildingInfo = erpBuildingInfoMapper.selectByPrimaryKey(erpBuildingInfo);
                    if (erpBuildingInfo != null ) {
                        buildName = StringUtil.isBlank(erpBuildingInfo.getPromotionName()) ? (StringUtil.isBlank(erpBuildingInfo.getBuildName()) ? "" : erpBuildingInfo.getBuildName()) : erpBuildingInfo.getPromotionName();
                    }
                }
                String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
                String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
                if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                    text52 = buildName + saleRoofT + saleNumT;
                } else {
                    if (StringUtil.isBlank(tradeAddr)) {
                        text52 = buildName + saleRoofT + saleNumT;
                    } else {
                        text52 = tradeAddr;
                    } 
                }
                if (erpFunEntrust.getSaleCommission() != null) {
                    text95 = Num2RMB.NumToRMBStr(erpFunEntrust.getSaleCommission().toString());
                    text96 = erpFunEntrust.getSaleCommission().toString();
                }
                if (erpFunSale.getSaleTotalPrice() != null) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    text91 = Num2RMB.NumToRMBStr(price.toString());
                    text93 = price.toString();
                }
                //如果是租售共用的委托需要查询出  出租的价格
                if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setCityId(erpFunEntrust.getCityId());
                    funLease.setShardCityId(erpFunEntrust.getCityId());
                    funLease.setLeaseId(erpFunSale.getSaleLeaseId());
                    ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
                    //[2020-06-22]lizhongguo 需求id：12688 【bug转需求】出租租金，改为手动填写
                    if (erpFunEntrust.getCustomRentAmount() != null){
                        BigDecimal customRentAmount = erpFunEntrust.getCustomRentAmount();
                        text94 = customRentAmount.toString();
                        if (customRentAmount.compareTo(BigDecimal.ZERO) > 0) {
                            text92 = Num2RMB.NumToRMBStr(customRentAmount.toString());
                        }
                    }
                    //计算价格
                    /*if (erpFunLease.getLeaseTotalPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {// 元/天 值:2
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {// 元/平米*月 值:3
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {// 元/平米*天 值:4
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {//  元/年  值:5
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text94 = leaseTotalPrice.toString();
                        if (leaseTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
                            text92 = Num2RMB.NumToRMBStr(leaseTotalPrice.toString());
                        }
                    }*/
                }
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(erpFunEntrust.getCityId());
            funLease.setShardCityId(erpFunEntrust.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease != null) {
//                text53 = erpFunLease.getLeaseNo();
                text54 = erpFunLease.getLeaseArea() == null ? " " : erpFunLease.getLeaseArea().toString();
                text56 = "√";
                //buildName 需要取楼盘的注册名才会有法律效应
                String buildName = "";
                if (erpFunLease.getBuildId() != null) {
                    ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
                    erpBuildingInfo.setShardCityId(erpFunLease.getCityId());
                    erpBuildingInfo.setCityId(erpFunLease.getCityId().shortValue());
                    erpBuildingInfo.setBuildId(erpFunLease.getBuildId());
                    erpBuildingInfo = erpBuildingInfoMapper.selectByPrimaryKey(erpBuildingInfo);
                    if (erpBuildingInfo != null ) {
                        buildName = StringUtil.isBlank(erpBuildingInfo.getPromotionName()) ? (StringUtil.isBlank(erpBuildingInfo.getBuildName()) ? "" : erpBuildingInfo.getBuildName()) : erpBuildingInfo.getPromotionName();
                    }         
                }       
                String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
                String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
                if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                    text52 = buildName + leaseRoofT + leaseNumT;
                } else {
                    if (StringUtil.isBlank(tradeAddr)) {
                        text52 = buildName + leaseRoofT + leaseNumT;
                    } else {
                        text52 = tradeAddr;
                    }
                }
                text97 = erpFunEntrust.getLeaseCommission() == null ? " " : erpFunEntrust.getLeaseCommission().toString();
                //[2020-06-22]lizhongguo 需求id：12688 【bug转需求】出租租金，改为手动填写
                if (erpFunEntrust.getCustomRentAmount() != null){
                    BigDecimal customRentAmount = erpFunEntrust.getCustomRentAmount();
                    text94 = customRentAmount.toString();
                    if (customRentAmount.compareTo(BigDecimal.ZERO) > 0) {
                        text92 = Num2RMB.NumToRMBStr(customRentAmount.toString());
                    }
                }
                //计算价格
                /*if (erpFunLease.getLeaseTotalPrice() != null) {
                    BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                    if (leaseTotalPrice == null) {
                        leaseTotalPrice = new BigDecimal("0");
                    }
                    BigDecimal leaseArea = erpFunLease.getLeaseArea();
                    if (leaseArea == null) {
                        leaseArea = new BigDecimal("0");
                    }
                    Byte priceUnit = erpFunLease.getPriceUnit();
                    // 默认以30天为标准
                    if (priceUnit == 2) {// 元/天 值:2
                        leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                    } else if (priceUnit == 3) {// 元/平米*月 值:3
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                    } else if (priceUnit == 4) {// 元/平米*天 值:4
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                    } else if (priceUnit == 5) {//  元/年  值:5
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                    }
                    text94 = leaseTotalPrice.toString();
                    if (leaseTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
                        text92 = Num2RMB.NumToRMBStr(leaseTotalPrice.toString());
                    }
                } */
            }
            //如果是租售共用的委托需要查询出  出售的价格
            if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                ErpFunSale funSale = new ErpFunSale();
                funSale.setCityId(erpFunEntrust.getCityId());
                funSale.setShardCityId(erpFunEntrust.getCityId());
                funSale.setSaleId(erpFunLease.getSaleLeaseId());
                ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
                if (erpFunSale.getSaleTotalPrice() != null) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    text91 = Num2RMB.NumToRMBStr(price.toString());
                    text93 = price.toString();
                }
            }
        }
      
        String mlCompanySeal = erpSysParaMapper.getParamValue(erpFunEntrust.getCityId(), erpFunEntrust.getCompId(), "ML_COMPANY_SEAL");
       /* if (StringUtil.isNotBlank(mlCompanySeal)) {
            stamp = AppConfig.getPicDomainUrl() + mlCompanySeal;
        }*/
        templateParam.put("text42", text42); 
        templateParam.put("text43", text43); 
        templateParam.put("text44", text44); 
        templateParam.put("text46", text46); 
        templateParam.put("text47", text47); 
        templateParam.put("text48", text48); 
        templateParam.put("text52", text52); 
        templateParam.put("text53", text53); 
        templateParam.put("text54", text54); 
        templateParam.put("text55", text55); 
        templateParam.put("text56", text56); 
        templateParam.put("text57", text57); 
        templateParam.put("text58", text58); 
        templateParam.put("text59", text59); 
        templateParam.put("text60", text60); 
        templateParam.put("text61", text61); 
        templateParam.put("text62", text62); 
        templateParam.put("text63", text63); 
        templateParam.put("text64", text64); 
        templateParam.put("text65", text65); 
        templateParam.put("text66", text66); 
        templateParam.put("text68", text68); 
        templateParam.put("text70", text70); 
        templateParam.put("text71", text71); 
        templateParam.put("text72", text72); 
        templateParam.put("text73", text73); 
        templateParam.put("text74", text74); 
        templateParam.put("text75", text75); 
        templateParam.put("text76", text76); 
        templateParam.put("text78", text78); 
        templateParam.put("text79", text79); 
        templateParam.put("text80", text80); 
        templateParam.put("text81", text81); 
        templateParam.put("text82", text82); 
        templateParam.put("text83", text83); 
        templateParam.put("text84", text84); 
        templateParam.put("text85", text85); 
        templateParam.put("text86", text86); 
        templateParam.put("text87", text87); 
        templateParam.put("text89", text89); 
        templateParam.put("text90", text90); 
        templateParam.put("text91", text91); 
        templateParam.put("text92", text92); 
        templateParam.put("text93", text93); 
        templateParam.put("text94", text94); 
        templateParam.put("text95", text95); 
        templateParam.put("text96", text96); 
        templateParam.put("text97", text97); 
        templateParam.put("text98", text98); 
        templateParam.put("text99", text99);
        templateParam.put("text100", text100);
        templateParam.put("text108", text108);
        templateParam.put("text109", text109);
        templateParam.put("text110", text110);
        templateParam.put("text125", text125);
        templateParam.put("stamp", stamp);
     
        return templateParam;
    }

    /**
     * @author 蔡春林 北京电子委托 获取模板参数
     * @date 2020/2/5 0005
     * @param erpFunEntrust
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    private Map<String, String> getBjEntrustTemplateParam(ErpFunEntrust erpFunEntrust) {
        HashMap<String, String> templateParam = new HashMap<>();
        String text42 = "";//委托人姓名
        String text43 = "";//委托人证件号码
        String text44 = "";//代理人
        String text46 = "";//代理人证件号码
        String text47 = "";//委托人地址
        String text48 = "";//text43:委托人电话号码
        String text52 = "";//楼盘名称
        String text53 = "";//房源编号
        String text54 = "";//建筑面积
        String text55 = "";//出售（√）
        String text56 = "";//出租（√）
        String text57 = "";//产权完整（√）
        String text58 = "";//有抵押（√）
        String text59 = "";//无租约（√）
        String text60 = "";//有租约（√）
        String text61 = "";//租约开始（年）
        String text62 = "";//租约开始（月）
        String text63 = "";//租约开始（日）
        String text64 = "";//租约结束（年）
        String text65 = "";//租约结束（月）
        String text66 = "";//租约结束（日）
        String text68 = "";//租金价格大写
        String text70 = "";//租金价格小写
        String text71 = "";//委托开始（年）
        String text72 = "";//委托开始（月）
        String text73 = "";//委托开始（日） 
        String text74 = "";//委托结束（年）
        String text75 = "";//委托结束（月）
        String text76 = "";//委托结束（日）
        String text78 = "";//独家委托（√）
        String text79 = "";//非独家委托（√）
        String text80 = "";//房地产证复印件（√）
        String text81 = "";//产权人身份资料复印件（√）
        String text82 = "";//房地产买卖合同复印件（√）
        String text83 = "";//购买发票复印件（√）
        String text84 = "";//付清房款证明书复印件（√）
        String text85 = "";//产权人委托书（√）
        String text86 = "";//其他（√）
        String text87 = "";//其他的内容
        String text89 = "";//甲方将该物业钥匙交于乙方作看房之用 （√）
        String text90 = "";//双方另行约定时间看房（√）
        String text91 = "";//出售价格中文
        String text92 = "";//出租价格中文
        String text93 = "";//出售价格数字
        String text94 = "";//出租价格数字
        String text95 = "";//出售佣金中文
        String text96 = "";//出售佣金数字
        String text97 = "";//出租佣金几个月租金
        String text98 = "";//甲方联系地址
        String text99 = "";//甲方联系人
        String text100 = "";//甲方联系电话

        String stamp = "";//美联公司印章
        String text125 = erpFunEntrust.getEntrustNo();//委托编号
        String nowDate = DateUtil.DateToString(new Date(), "yyyy-MM-dd");
        String[] nowDateArray = nowDate.split("-");
        String text108 = nowDateArray[0];//签约年
        String text109 = nowDateArray[1];//签约月
        String text110 = nowDateArray[2];//签约日
        Byte entrustBusiness = erpFunEntrust.getEntrustBusiness();
        if (erpFunEntrust.getHouseStatus() != null&&erpFunEntrust.getHouseStatus()==1) {
            text57 = "√";
        } else if (erpFunEntrust.getHouseStatus() != null && erpFunEntrust.getHouseStatus() == 2) {
            text58 = "√";
        }
        if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 0) {
            text59 = "√";
        } else if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 1) {
            text60 = "√";
            if (erpFunEntrust.getLeaseEndTime() != null) {
                String leaseEnd = DateUtil.DateToString(erpFunEntrust.getLeaseEndTime(), "yyyy-MM-dd");
                String[] leaseEndArray = leaseEnd.split("-");
                text64 = leaseEndArray[0];//租约结束（年）
                text65 = leaseEndArray[1];//租约结束（月）
                text66 = leaseEndArray[2];//租约结束（日）
            }
        }
        if (erpFunEntrust.getOldRentMoney() != null) {
            text68 = ChineseYuanUtil.convert(erpFunEntrust.getOldRentMoney().toString());
            text70 = erpFunEntrust.getOldRentMoney().toString();
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustStart())) {
            String[] entrustStart = erpFunEntrust.getEntrustStart().split("-");
            text71 = entrustStart[0];
            text72 = entrustStart[1];
            text73 = entrustStart[2];
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustEnd())) {
            String[] entrustEnd = erpFunEntrust.getEntrustEnd().split("-");
            text74 = entrustEnd[0];
            text75 = entrustEnd[1];
            text76 = entrustEnd[2];
        }
        if (erpFunEntrust.getEntrustType() != null && erpFunEntrust.getEntrustType() == 1) {
            text79 = "√";
        } else if (erpFunEntrust.getEntrustType() != null && erpFunEntrust.getEntrustType() == 2) {
            text78 = "√";
        }

        if (erpFunEntrust.getInspectionType() != null && erpFunEntrust.getInspectionType() == 1) {
            text89 = "√";

        } else if (erpFunEntrust.getInspectionType() != null && erpFunEntrust.getInspectionType() == 2) {
            text90 = "√";
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustom())) {
            String[] depositFileForCustom = erpFunEntrust.getDepositFileForCustom().split(",");
            for (String depositFile : depositFileForCustom) {
                if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_1.equals(depositFile)) {
                    text80 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_2.equals(depositFile)) {
                    text81 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_3.equals(depositFile)) {
                    text82 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_4.equals(depositFile)) {
                    text83 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_5.equals(depositFile)) {
                    text84 = "√";
                } else if (Const.DIC_DEPOSIT_FILE_FOR_CUSTOM_6.equals(depositFile)) {
                    text85 = "√";
                }
            }
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustomOther())) {
            text86 = "√";
            text87 = erpFunEntrust.getDepositFileForCustomOther();
        }
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(erpFunEntrust.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(erpFunEntrust.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() == 0) {
            return templateParam;
        }
        List<OwnerUserVO> ownerUserVOList = new ArrayList<>();

        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            text42 += (ownerUserVO.getOwnerName() + " ");
            text43 += (ownerUserVO.getCardNo() + " ");
            text47+=(ownerUserVO.getAddress() + " ");
            text48+=(ownerUserVO.getOwnerPhone() + " ");
            text98+=(ownerUserVO.getAddress() + " ");
            text99 += (ownerUserVO.getOwnerName() + " ");
            text100+=(ownerUserVO.getOwnerPhone() + " ");
        }

        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(erpFunEntrust.getCityId());
            funSale.setShardCityId(erpFunEntrust.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale != null) {
//                text53 = erpFunSale.getSaleNo();
                text54 = erpFunSale.getSaleArea() == null ? " " : erpFunSale.getSaleArea().toString();
                text55 = "√";
                String buildName = StringUtil.isBlank(erpFunSale.getBuildName()) ? "" : erpFunSale.getBuildName();
                String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
                String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
                if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                    text52 = buildName + saleRoofT + saleNumT;
                } else {
                    text52 = tradeAddr;
                }
                if (erpFunEntrust.getSaleCommission() != null) {
                    text95 = ChineseYuanUtil.convert(erpFunEntrust.getSaleCommission().toString());
                    text96 = erpFunEntrust.getSaleCommission().toString();
                }
                if (erpFunSale.getSaleTotalPrice() != null) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    text91 = ChineseYuanUtil.convert(price.toString());
                    text93 = price.toString();
                }
                //如果是租售共用的委托需要查询出  出租的价格
                if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setCityId(erpFunEntrust.getCityId());
                    funLease.setShardCityId(erpFunEntrust.getCityId());
                    funLease.setLeaseId(erpFunSale.getSaleLeaseId());
                    ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
                    //计算价格
                    if (erpFunLease.getLeaseLowestPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {/** 元/天 值:2 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {/**元/年  值:5 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text94 = leaseTotalPrice.toString();
                        if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                            text92 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                        }
                    }
                }
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(erpFunEntrust.getCityId());
            funLease.setShardCityId(erpFunEntrust.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease != null) {
//                text53 = erpFunLease.getLeaseNo();
                text54 = erpFunLease.getLeaseArea() == null ? " " : erpFunLease.getLeaseArea().toString();
                text56 = "√";
                String buildName = StringUtil.isBlank(erpFunLease.getBuildName()) ? "" : erpFunLease.getBuildName();
                String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
                String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
                if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                    text52 = buildName + leaseRoofT + leaseNumT;
                } else {
                    text52 = tradeAddr;
                }
                text97 = erpFunEntrust.getLeaseCommission() == null ? null : erpFunEntrust.getLeaseCommission().toString();

                //计算价格
                if (erpFunLease.getLeaseLowestPrice() != null) {
                    BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                    if (leaseTotalPrice == null) {
                        leaseTotalPrice = new BigDecimal("0");
                    }
                    BigDecimal leaseArea = erpFunLease.getLeaseArea();
                    if (leaseArea == null) {
                        leaseArea = new BigDecimal("0");
                    }
                    Byte priceUnit = erpFunLease.getPriceUnit();
                    // 默认以30天为标准
                    if (priceUnit == 2) {/** 元/天 值:2 */
                        leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                    } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                    } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                    } else if (priceUnit == 5) {/**元/年  值:5 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                    }
                    text94 = leaseTotalPrice.toString();
                    if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                        text92 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                    }
                }
            }
            //如果是租售共用的委托需要查询出  出售的价格
            if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                ErpFunSale funSale = new ErpFunSale();
                funSale.setCityId(erpFunEntrust.getCityId());
                funSale.setShardCityId(erpFunEntrust.getCityId());
                funSale.setSaleId(erpFunLease.getSaleLeaseId());
                ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
                if (erpFunSale.getSaleTotalPrice() != null) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    text91 = ChineseYuanUtil.convert(price.toString());
                    text93 = price.toString();
                }
            }
        }

        String mlCompanySeal = erpSysParaMapper.getParamValue(erpFunEntrust.getCityId(), erpFunEntrust.getCompId(), "ML_COMPANY_SEAL");
       /* if (StringUtil.isNotBlank(mlCompanySeal)) {
            stamp = AppConfig.getPicDomainUrl() + mlCompanySeal;
        }*/
        templateParam.put("text42", text42);
        templateParam.put("text43", text43);
        templateParam.put("text44", text44);
        templateParam.put("text46", text46);
        templateParam.put("text47", text47);
        templateParam.put("text48", text48);
        templateParam.put("text52", text52);
        templateParam.put("text53", text53);
        templateParam.put("text54", text54);
        templateParam.put("text55", text55);
        templateParam.put("text56", text56);
        templateParam.put("text57", text57);
        templateParam.put("text58", text58);
        templateParam.put("text59", text59);
        templateParam.put("text60", text60);
        templateParam.put("text61", text61);
        templateParam.put("text62", text62);
        templateParam.put("text63", text63);
        templateParam.put("text64", text64);
        templateParam.put("text65", text65);
        templateParam.put("text66", text66);
        templateParam.put("text68", text68);
        templateParam.put("text70", text70);
        templateParam.put("text71", text71);
        templateParam.put("text72", text72);
        templateParam.put("text73", text73);
        templateParam.put("text74", text74);
        templateParam.put("text75", text75);
        templateParam.put("text76", text76);
        templateParam.put("text78", text78);
        templateParam.put("text79", text79);
        templateParam.put("text80", text80);
        templateParam.put("text81", text81);
        templateParam.put("text82", text82);
        templateParam.put("text83", text83);
        templateParam.put("text84", text84);
        templateParam.put("text85", text85);
        templateParam.put("text86", text86);
        templateParam.put("text87", text87);
        templateParam.put("text89", text89);
        templateParam.put("text90", text90);
        templateParam.put("text91", text91);
        templateParam.put("text92", text92);
        templateParam.put("text93", text93);
        templateParam.put("text94", text94);
        templateParam.put("text95", text95);
        templateParam.put("text96", text96);
        templateParam.put("text97", text97);
        templateParam.put("text98", text98);
        templateParam.put("text99", text99);
        templateParam.put("text100", text100);
        templateParam.put("text108", text108);
        templateParam.put("text109", text109);
        templateParam.put("text110", text110);
        templateParam.put("text125", text125);
        templateParam.put("stamp", stamp);

        return templateParam;
    }

    /**
     * @author 蔡春林 成都电子委托 获取模板参数
     * @date 2020/2/5 0005
     * @param erpFunEntrust
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    private Map<String, String> getCdEntrustTemplateParam(ErpFunEntrust erpFunEntrust) {
        HashMap<String, String> templateParam = new HashMap<>();
        String text= erpFunEntrust.getEntrustNo();//委托编号
        String text1 = "";//委托人姓名
        String text2 = "";//委托人证件号
        String text3 = "";//委托人代理人姓名
        String text4 = "";//委托人代理人证件号
        String text5 = "";//委托人或代理人地址
        String text6 = "";//委托人手机1
        String text7 = "";//委托人手机2
        String text8 = "";//委托人家庭电话
        String text9 = "";//委托人公司电话
        String text10 = "";//委托人传真
        String text11 = "";//委托人联系人
        String text12 = "";//委托人联系人电话
        String text13 = "";//委托项目1
        String text14 = "";//委托人签字1
        String text15 = "";//委托项目2
        String text16 = "";//委托人签字2
        String text17 = "";//委托项目3
        String text18 = "";//委托人签字3
        String text19 = "";//委托项目4
        String text20 = "";//委托人签字4
        String text21 = "";//委托项目5
        String text22 = "";//委托人签字5
        String text23 = "";//委托人身份证号码
        String text24 = "";//委托人代理人身份证号码
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(erpFunEntrust.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(erpFunEntrust.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() == 0) {
            return templateParam;
        }
        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            text1 += (ownerUserVO.getOwnerName() + " ");
            text11 += (ownerUserVO.getOwnerName() + " ");
            text14 += (ownerUserVO.getOwnerName() + " ");
            text2 += (ownerUserVO.getCardNo() + " ");
            text23 += (ownerUserVO.getCardNo() + " ");
            text6+=(ownerUserVO.getOwnerPhone() + " ");
            text12+=(ownerUserVO.getOwnerPhone() + " ");
            text5+=(ownerUserVO.getAddress() + " ");
        }

        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(erpFunEntrust.getCityId());
            funSale.setShardCityId(erpFunEntrust.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale != null) {
                String buildName = StringUtil.isBlank(erpFunSale.getBuildName()) ? "" : erpFunSale.getBuildName();
                String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
                String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
                if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                    text13 = buildName + saleRoofT + saleNumT;
                } else {
                    text13 = tradeAddr;
                }
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(erpFunEntrust.getCityId());
            funLease.setShardCityId(erpFunEntrust.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease != null) {
                String buildName = StringUtil.isBlank(erpFunLease.getBuildName()) ? "" : erpFunLease.getBuildName();
                String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
                String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
                if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                    text13 = buildName + leaseRoofT + leaseNumT;
                } else {
                    text13 = tradeAddr;
                }
            }
        }
        templateParam.put("text", text);
        templateParam.put("text1", text1);
        templateParam.put("text2", text2);
        templateParam.put("text3", text3);
        templateParam.put("text4", text4);
        templateParam.put("text5", text5);
        templateParam.put("text6", text6);
        templateParam.put("text7", text7);
        templateParam.put("text8", text8);
        templateParam.put("text9", text9);
        templateParam.put("text10", text10);
        templateParam.put("text11", text11);
        templateParam.put("text12", text12);
        templateParam.put("text13", text13);
        templateParam.put("text14", text14);
        templateParam.put("text15", text15);
        templateParam.put("text16", text16);
        templateParam.put("text17", text17);
        templateParam.put("text18", text18);
        templateParam.put("text19", text19);
        templateParam.put("text20", text20);
        templateParam.put("text21", text21);
        templateParam.put("text22", text22);
        templateParam.put("text23", text23);
        templateParam.put("text24", text24);
        return templateParam;
    }

    /**
     * @author 蔡春林 重庆电子委托 获取模板参数
     * @date 2020/2/5 0005
     * @param erpFunEntrust
     * @return java.util.Map<java.lang.String,java.lang.String>
     */
    private Map<String, String> getCqEntrustTemplateParam(ErpFunEntrust erpFunEntrust) {
        HashMap<String, String> templateParam = new HashMap<>();
        String text = erpFunEntrust.getEntrustNo();//委托人编号
        String text1 = "";//委托人姓名
        String text2 = "";//委托人证件号码
        String text3 = "";//委托人地址
        String text4 = "";//委托楼盘
        String text5 = erpFunEntrust.getCertificateOfProduction();//委托房地产证明文件
        String text6 = erpFunEntrust.getLandNature();//委托土地性质
        String text7 = "";//委托建筑面积
        String text8 = "";//委托价格中文
        String text9 = "";//委托价格中文数字
        String text10 = "";//委托销售期限n个工作日
        String text11 = "";//委托证件
        String text12 = erpFunEntrust.getEntrustNote();//备注

        if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustom()) && StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustomOther())) {
            text11 = erpFunEntrust.getDepositFileForCustom() + "," + erpFunEntrust.getDepositFileForCustomOther();
        } else if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustom())) {
            text11 = erpFunEntrust.getDepositFileForCustom(); 
        } else if (StringUtil.isNotBlank(erpFunEntrust.getDepositFileForCustomOther())) {
            text11 = erpFunEntrust.getDepositFileForCustomOther();
        }
      
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(erpFunEntrust.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(erpFunEntrust.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() == 0) {
            return templateParam;
        }
        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            text1 += (ownerUserVO.getOwnerName() + " ");
            text2 += (ownerUserVO.getCardNo() + " ");
            text3+=(ownerUserVO.getAddress() + " ");
        }

        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(erpFunEntrust.getCityId());
            funSale.setShardCityId(erpFunEntrust.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale != null) {
                text7 = erpFunSale.getSaleArea() == null ? " " : erpFunSale.getSaleArea().toString();
                String buildName = StringUtil.isBlank(erpFunSale.getBuildName()) ? "" : erpFunSale.getBuildName();
                String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
                String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
                if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                    text4 = buildName + saleRoofT + saleNumT;
                } else {
                    text4 = tradeAddr;
                }
               
                if (erpFunSale.getSaleTotalPrice() != null) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    text8 = ChineseYuanUtil.convert(price.toString());
                    text9 = price.toString();
                }
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(erpFunEntrust.getCityId());
            funLease.setShardCityId(erpFunEntrust.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease != null) {
                text7 = erpFunLease.getLeaseArea() == null ? " " : erpFunLease.getLeaseArea().toString();
                String buildName = StringUtil.isBlank(erpFunLease.getBuildName()) ? "" : erpFunLease.getBuildName();
                String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
                String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
                if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                    text4 = buildName + leaseRoofT + leaseNumT;
                } else {
                    text4 = tradeAddr;
                }

                //计算价格
                if (erpFunLease.getLeaseLowestPrice() != null) {
                    BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                    if (leaseTotalPrice == null) {
                        leaseTotalPrice = new BigDecimal("0");
                    }
                    BigDecimal leaseArea = erpFunLease.getLeaseArea();
                    if (leaseArea == null) {
                        leaseArea = new BigDecimal("0");
                    }
                    Byte priceUnit = erpFunLease.getPriceUnit();
                    // 默认以30天为标准
                    if (priceUnit == 2) {/** 元/天 值:2 */
                        leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                    } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                    } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                    } else if (priceUnit == 5) {/**元/年  值:5 */
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                    }
                    text9 = leaseTotalPrice.toString();
                    if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                        text8 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                    }
                }
            }
        }
        templateParam.put("text", text);
        templateParam.put("text1", text1);
        templateParam.put("text2", text2);
        templateParam.put("text3", text3);
        templateParam.put("text4", text4);
        templateParam.put("text5", text5);
        templateParam.put("text6", text6);
        templateParam.put("text7", text7);
        templateParam.put("text8", text8);
        templateParam.put("text9", text9);
        templateParam.put("text10", text10);
        templateParam.put("text11", text11);
        templateParam.put("text12", text12);
        return templateParam;
    }


    /**  
    * @author 蔡春林   广州 珠海电子委托 获取模板参数
    * @date 2020/2/5 0005
    * @param erpFunEntrust
    * @param address
    * @return java.util.Map<java.lang.String,java.lang.String>
    */
    private Map<String, String> getGzOrZhEntrustTemplateParam(ErpFunEntrust erpFunEntrust,String address, List<EntrustCertificateInfoParam> certificateList) {
        HashMap<String, String> templateParam = new HashMap<>();
        String text= erpFunEntrust.getEntrustNo();//委托编号
        String text1 = "";//委托人姓名
        String text2 = "";//委托人证件类型
        String text3 = "";//委托人证件号码
        String text4 = "";//委托人电话号码
        String text5 = "";//委托人地址
        String text6= address;//乙方地址
        String text7 = "";//出租（√）
        String text8 = "";//出售（√）
        String text9 = "";//委托房屋地址
        String text10 = "";//委托房屋权证号
        String text11 = "";//建筑面积
        String text12 = "";//无抵押（√）
        String text13 = "";//有抵押（√）   
        String text14 = "";//户口无占用（√）
        String text15 = "";//户口有占用（√）
        String text16 = "";//交吉（√）
        String text17 = "";//带租约（√）
        String text18 = "";//学位占用情况：无（√）
        String text19 = "";//学位占用情况：有（√）
        //[2020-06-16] 广州珠海的委托合同 的委托期限只有起始日期，下边test字段复用
        String text20 = "";//委托结束（年）
        String text21 = "";//委托结束（月）
        String text22 = "";//委托结束（日）
        String text23 = "";//出租价格中文
        String text24 = "";//出租价格数字
        String text25 = "";//出售价格中文
        String text26 = "";//出售价格数字

        //签署日期委托对接群和产品文静pm才宝确认过，采用自动生成也就是当前时间了
        Integer year = DateUtil.getYear(new Date());
        Integer month = DateUtil.getMonth(new Date());
        Integer day = DateUtil.getDay(new Date());
        //String date = year+"年"+month+"月"+day+"日";//广州珠海之一、二人模板的签署日期在签名方法里获取  "/contract/sendByTemplate/"
        String text27 = year.toString();//广州珠海之三人模板的签署日期（年）
        String text28 = month.toString();//广州珠海之三人模板的签署日期（月）
        String text29 = day.toString();//广州珠海之三人模板的签署日期（日）

        //[2020-06-16]
        String certificate = "";
        /*for (EntrustCertificateInfoParam certificateInfoParam : certificateList) {
            certificate = certificate + certificateInfoParam.getCertificateNo() + ", ";
        }*/
        for (int i=0; i < certificateList.size(); i++){
            certificate = certificate + certificateList.get(i).getCertificateNo();
            if (i < certificateList.size()-1){
                certificate += ", ";
            }
        }
        if (StringUtil.isNotEmpty(certificate)){
            text10 = certificate;
        }
        if (erpFunEntrust.getHasAccountOccupancy() != null&&erpFunEntrust.getHasAccountOccupancy()==1) {
            text15 = "√";
        }
        if (erpFunEntrust.getHasAccountOccupancy() != null&&erpFunEntrust.getHasAccountOccupancy()==0) {
            text14 = "√";
        }
        if (erpFunEntrust.getHasDegreeOccupation() != null&&erpFunEntrust.getHasDegreeOccupation()==1) { //20200616原： if (erpFunEntrust.getHasDegreeOccupation() != null&&erpFunEntrust.getHasDegreeOccupation()==0) {
            text19 = "√";
        } 
        if (erpFunEntrust.getHasDegreeOccupation() != null&&erpFunEntrust.getHasDegreeOccupation()==0) {
            text18 = "√";
        }
        if (erpFunEntrust.getHouseStatus() != null&&erpFunEntrust.getHouseStatus()==1) {
            text12 = "√";
        } else if (erpFunEntrust.getHouseStatus() != null && erpFunEntrust.getHouseStatus() == 2) {
            text13 = "√";
        }
        if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 0) {
            text16 = "√";
        } else if (erpFunEntrust.getHasLeaseContract() != null && erpFunEntrust.getHasLeaseContract() == 1) {
            text17 = "√";
        }
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustEnd())) {
            String[] entrustEnd = erpFunEntrust.getEntrustEnd().split("-");
            text20 = entrustEnd[0];
            text21 = entrustEnd[1];
            text22 = entrustEnd[2];
        }
        //[2020/06/16] lizhongguo 需求id#11665 PC&APP房源委托其他城市
        if (StringUtil.isNotBlank(erpFunEntrust.getEntrustStart()) && StringUtil.isEmpty(erpFunEntrust.getEntrustEnd())){
            String[] entrustStart = erpFunEntrust.getEntrustStart().split("-");
            text20 = entrustStart[0];
            text21 = entrustStart[1];
            text22 = entrustStart[2];
        }
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(erpFunEntrust.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(erpFunEntrust.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() == 0) {
            return templateParam;
        }
        List<OwnerUserVO> ownerUserVOList = new ArrayList<>();

        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            text1 += (ownerUserVO.getOwnerName() + " ");
            //证件类型 1=身份证 2=护照 3=军官证 4=士兵证 5=回乡证 6=台胞证
            if (ownerUserVO.getIdType() != null) {
                if (1 == ownerUserVO.getIdType()) {
                    text2 += "身份证 ";
                } else if (2 == ownerUserVO.getIdType()) {
                    text2 += "护照 ";
                } else if (3 == ownerUserVO.getIdType()) {
                    text2 += "军官证 ";
                } else if (4 == ownerUserVO.getIdType()) {
                    text2 += "士兵证 ";
                } else if (5 == ownerUserVO.getIdType()) {
                    text2 += "回乡证 ";
                } else if (6 == ownerUserVO.getIdType()) {
                    text2 += "台胞证 ";
                } else {
                    text2 += "身份证 ";
                } 
            } else {
                text2 += "身份证 ";
            } 
            text3 += (ownerUserVO.getCardNo() + " ");
            text5 += (ownerUserVO.getAddress() + " ");
            text4 += (ownerUserVO.getOwnerPhone() + " ");
        }

        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(erpFunEntrust.getCityId());
            funSale.setShardCityId(erpFunEntrust.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale != null) {
                text11 = erpFunSale.getSaleArea() == null ? " " : erpFunSale.getSaleArea().toString();
                String buildName = StringUtil.isBlank(erpFunSale.getBuildName()) ? "" : erpFunSale.getBuildName();
                String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
                String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
                if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                    text9 = buildName + saleRoofT + saleNumT;
                } else {
                    text9 = tradeAddr;
                }
                //计算价格
                if (null != erpFunEntrust.getEntrustBusiness() && erpFunEntrust.getEntrustBusiness() == 1){ //只展示售
                    text8 = "√";
                    if (erpFunSale.getSaleTotalPrice() != null) {
                        BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                        text25 = ChineseYuanUtil.convert(price.toString());
                        text26 = price.toString();
                    }
                } else if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) { //展示租售    //如果是租售共用的委托需要查询出  出租的价格
                    //售
                    text8 = "√";
                    if (erpFunSale.getSaleTotalPrice() != null) {
                        BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                        text25 = ChineseYuanUtil.convert(price.toString());
                        text26 = price.toString();
                    }

                    //租
                    text7 = "√";
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setCityId(erpFunEntrust.getCityId());
                    funLease.setShardCityId(erpFunEntrust.getCityId());
                    funLease.setLeaseId(erpFunSale.getSaleLeaseId());
                    ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
                    //计算价格
                    if (erpFunLease.getLeaseTotalPrice() != null) {  //if (erpFunLease.getLeaseLowestPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {/** 元/天 值:2 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {/**元/年  值:5 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text24 = leaseTotalPrice.toString();
                        if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                            text23 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                        }
                    }
                } else if (null != erpFunEntrust.getEntrustBusiness() && erpFunEntrust.getEntrustBusiness() == 2){  //只展示租
                    text7 = "√";
                    ErpFunLease funLease = new ErpFunLease();
                    funLease.setCityId(erpFunEntrust.getCityId());
                    funLease.setShardCityId(erpFunEntrust.getCityId());
                    funLease.setLeaseId(erpFunSale.getSaleLeaseId());
                    ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
                    //计算价格
                    if (erpFunLease.getLeaseTotalPrice() != null) {  //if (erpFunLease.getLeaseLowestPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {/** 元/天 值:2 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {/**元/年  值:5 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text24 = leaseTotalPrice.toString();
                        if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                            text23 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                        }
                    }
                }
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(erpFunEntrust.getCityId());
            funLease.setShardCityId(erpFunEntrust.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease != null) {
                text11 = erpFunLease.getLeaseArea() == null ? " " : erpFunLease.getLeaseArea().toString();
                String buildName = StringUtil.isBlank(erpFunLease.getBuildName()) ? "" : erpFunLease.getBuildName();
                String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
                String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
                String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
                if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                    text9 = buildName + leaseRoofT + leaseNumT;
                } else {
                    text9 = tradeAddr;
                }
                //计算价格
                if (null != erpFunEntrust && erpFunEntrust.getEntrustBusiness() == 2){  //出租
                    text7 = "√";
                    if (erpFunLease.getLeaseTotalPrice() != null) {  //if (erpFunLease.getLeaseLowestPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {/** 元/天 值:2 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {/**元/年  值:5 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text24 = leaseTotalPrice.toString();
                        if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                            text23 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                        }
                    }
                } else if (null != erpFunEntrust && erpFunEntrust.getEntrustBusiness() == 3){  //租售    //如果是租售共用的委托需要查询出  出售的价格
                    //租
                    text7 = "√";
                    if (erpFunLease.getLeaseTotalPrice() != null) {  //if (erpFunLease.getLeaseLowestPrice() != null) {
                        BigDecimal leaseTotalPrice = erpFunLease.getLeaseTotalPrice();
                        if (leaseTotalPrice == null) {
                            leaseTotalPrice = new BigDecimal("0");
                        }
                        BigDecimal leaseArea = erpFunLease.getLeaseArea();
                        if (leaseArea == null) {
                            leaseArea = new BigDecimal("0");
                        }
                        Byte priceUnit = erpFunLease.getPriceUnit();
                        // 默认以30天为标准
                        if (priceUnit == 2) {/** 元/天 值:2 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                        } else if (priceUnit == 3) {/** 元/平米*月 值:3 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                        } else if (priceUnit == 4) {/** 元/平米*天 值:4 */
                            leaseTotalPrice = new BigDecimal(
                                    NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                        } else if (priceUnit == 5) {/**元/年  值:5 */
                            leaseTotalPrice = new BigDecimal(NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                        }
                        text24 = leaseTotalPrice.toString();
                        if (!new BigDecimal("0").equals(leaseTotalPrice)) {
                            text23 = ChineseYuanUtil.convert(leaseTotalPrice.toString());
                        }
                    }
                    //售
                    text8 = "√";
                    ErpFunSale funSale = new ErpFunSale();
                    funSale.setCityId(erpFunEntrust.getCityId());
                    funSale.setShardCityId(erpFunEntrust.getCityId());
                    funSale.setSaleId(erpFunLease.getSaleLeaseId());
                    ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
                    if (erpFunSale.getSaleTotalPrice() != null) {
                        BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                        text25 = ChineseYuanUtil.convert(price.toString());
                        text26 = price.toString();
                    }
                } else if (null != erpFunEntrust && erpFunEntrust.getEntrustBusiness() == 1){  //售
                    text8 = "√";
                    ErpFunSale funSale = new ErpFunSale();
                    funSale.setCityId(erpFunEntrust.getCityId());
                    funSale.setShardCityId(erpFunEntrust.getCityId());
                    funSale.setSaleId(erpFunLease.getSaleLeaseId());
                    ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
                    if (erpFunSale.getSaleTotalPrice() != null) {
                        BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                        text25 = ChineseYuanUtil.convert(price.toString());
                        text26 = price.toString();
                    }
                }
            }
        }

        String mlCompanySeal = erpSysParaMapper.getParamValue(erpFunEntrust.getCityId(), erpFunEntrust.getCompId(), "ML_COMPANY_SEAL");
       /* if (StringUtil.isNotBlank(mlCompanySeal)) {
            stamp = AppConfig.getPicDomainUrl() + mlCompanySeal;
        }*/
        templateParam.put("text", text);
        templateParam.put("text1", text1 );
        templateParam.put("text2", text2 );
        templateParam.put("text3", text3 );
        templateParam.put("text4", text4 );
        templateParam.put("text5", text5 );
        templateParam.put("text6", text6);
        templateParam.put("text7", text7 );
        templateParam.put("text8", text8 );
        templateParam.put("text9", text9 );
        templateParam.put("text10", text10);
        templateParam.put("text11", text11);
        templateParam.put("text12", text12);
        templateParam.put("text13", text13);
        templateParam.put("text14", text14);
        templateParam.put("text15", text15);
        templateParam.put("text16", text16);
        templateParam.put("text17", text17);
        templateParam.put("text18", text18);
        templateParam.put("text19", text19);
        templateParam.put("text20", text20);
        templateParam.put("text21", text21);
        templateParam.put("text22", text22);
        templateParam.put("text23", text23);
        templateParam.put("text24", text24);
        templateParam.put("text25", text25);
        templateParam.put("text26", text26);
        templateParam.put("text27", text27);
        templateParam.put("text28", text28);
        templateParam.put("text29", text29);
        return templateParam;
    }
    /**
     * 生成电子委托的委托编号 规则详情参考需求 11650
     * @author HuangJiang
     * @since 2020年01月09日 16:17
     * @param cityId 城市ID
     * @param electronicEntrustType 电子委托书类型（1=标准；2=简易）
     * @return java.lang.String
     * Modified XXX HuangJiang 2020年01月09日
     */
    private String getEntrustNo(Integer cityId, Byte electronicEntrustType) {
        String entrustNo = erpFunEntrustMapper.selectByEntrustType(cityId, electronicEntrustType);
        if (StringUtil.isNotBlank(entrustNo)) {
            // 取出前四位字母
            String entrustNoPrefix = entrustNo.substring(0, 4);
            // 截取出字母后面的数字
            entrustNo = entrustNo.substring(4);
            // 最新的数字+1
            String entrustNum = (StringUtil.parseInteger(entrustNo) + 1) + "";
            // 拼接委托编号
            entrustNo = entrustNoPrefix + entrustNo.substring(0, entrustNo.length() - entrustNum.length()) + entrustNum;
        } else {
            AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(cityId.shortValue());
            StringBuilder sb = new StringBuilder();
            // 如果未查询出城市、或者城市上的拼音码为空，则默认成深圳 SZ；否则就取城市信息上的拼音码（需要转换成大写字母）
            if (null == adminFunCity || StringUtil.isEmpty(adminFunCity.getcPyCode())) {
                sb.append("SZ");
            } else {
                sb.append(adminFunCity.getcPyCode().toUpperCase());
            }
            // 标准电子委托 DR  简易电子委托 DF
            if (null != electronicEntrustType && electronicEntrustType == 1) {
                sb.append("DR");
            } else {
                sb.append("DF");
            }
            entrustNo = sb.append("0000001").toString();
        } 
        return entrustNo;
    }
    
    /**
     * 插入房产资料KPI数据
     * @detail [2020年04月07日] HuangJiang story#11736 房产资料独家委托新增量统计
     * @author HuangJiang
     * @since 2020年04月07日 18:32
     * @param erpFunEntrust 委托信息
     * @param date 日期
     * @return void
     * Modified XXX HuangJiang 2020年04月07日
     */
    @Override
    public void insertEntrustKpiLog(ErpFunEntrust erpFunEntrust, Date date) {
        Integer cityId = erpFunEntrust.getCityId();
        Integer userId = erpFunEntrust.getApproveUserId();
        ErpFunEntrustKpiLog erpFunEntrustKpiLog = new ErpFunEntrustKpiLog();
        erpFunEntrustKpiLog.setShardCityId(cityId);
        erpFunEntrustKpiLog.setCompId(erpFunEntrust.getCompId());
        erpFunEntrustKpiLog.setEntrustId(erpFunEntrust.getEntrustId());
        erpFunEntrustKpiLog.setCaseId(erpFunEntrust.getCaseId());
        erpFunEntrustKpiLog.setCaseType(erpFunEntrust.getCaseType());
        erpFunEntrustKpiLog.setCreateTime(date);
        erpFunEntrustKpiLog.setUserId(userId);
        erpFunEntrustKpiLogMapper.insertSelective(erpFunEntrustKpiLog);
    
        // 记录独家委托KPI日志
        ErpFunEntrustKpiTrack erpFunEntrustKpiTrack = new ErpFunEntrustKpiTrack();
        erpFunEntrustKpiTrack.setShardCityId(cityId);
        erpFunEntrustKpiTrack.setUserId(erpFunEntrust.getApproveUserId());
        erpFunEntrustKpiTrack.setCompId(erpFunEntrust.getCompId());
        erpFunEntrustKpiTrack.setCaseId(erpFunEntrust.getCaseId());
        erpFunEntrustKpiTrack.setCaseType(erpFunEntrust.getCaseType());
        erpFunEntrustKpiTrack.setEntrustId(erpFunEntrust.getEntrustId());
        erpFunEntrustKpiTrack.setContent("新增独家委托，无需审核");
        erpFunEntrustKpiTrack.setEntrustTime(erpFunEntrust.getCreateTime());
        erpFunEntrustKpiTrack.setAuditTime(erpFunEntrust.getAuditDate());
        erpFunEntrustKpiTrack.setCreateTime(new Date());
        ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
        if (null != erpFunUsers) {
            erpFunEntrustKpiTrack.setOrganizationId(erpFunUsers.getOrganizationId());
            erpFunEntrustKpiTrack.setOrganizationPath(erpFunUsers.getTissueLine());
        }
        
        // 次数同步到经纪人KPI日表中去
        ErpKpiStatisticBrokerPerformanceExample erpKpiStatisticBrokerPerformanceExample = new ErpKpiStatisticBrokerPerformanceExample();
        erpKpiStatisticBrokerPerformanceExample.setShardCityId(cityId);
        erpKpiStatisticBrokerPerformanceExample.createCriteria().andUserIdEqualTo(userId)
                .andCreateTimeBetween(DateUtil.StringToDate(DateUtil.DateToString(date, "yyyy-MM-dd") + " 00:00:00"), DateUtil.getLastSecondOfDay(date));
        erpKpiStatisticBrokerPerformanceExample.setOrderByClause(" CREATE_TIME ASC ");
        ErpKpiStatisticBrokerPerformance erpKpiStatisticBrokerPerformance = erpKpiStatisticBrokerPerformanceMapper.selectOneByExample(erpKpiStatisticBrokerPerformanceExample);
        if (null != erpKpiStatisticBrokerPerformance) {
            ErpKpiStatisticBrokerPerformance kpiStatisticBrokerPerformanceUpdate = new ErpKpiStatisticBrokerPerformance();
            kpiStatisticBrokerPerformanceUpdate.setShardCityId(cityId);
            kpiStatisticBrokerPerformanceUpdate.setId(erpKpiStatisticBrokerPerformance.getId());
            Integer oldCount = null == erpKpiStatisticBrokerPerformance.getExclusiveCommission() ? 0 : erpKpiStatisticBrokerPerformance.getExclusiveCommission();
            kpiStatisticBrokerPerformanceUpdate.setExclusiveCommission(oldCount + 1); // 独家委托
            kpiStatisticBrokerPerformanceUpdate.setUpdateTime(date);
            erpKpiStatisticBrokerPerformanceMapper.updateByPrimaryKeySelective(kpiStatisticBrokerPerformanceUpdate);
        } else {
            erpFunEntrustKpiTrack.setContent("新增独家委托，无需审核，次数未记录");
        }
        erpFunEntrustKpiTrackMapper.insertSelective(erpFunEntrustKpiTrack);
    }
    
}

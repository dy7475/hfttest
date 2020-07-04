package com.myfun.erpWeb.managecenter.mlEntrustManage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.house.vo.EntrustCertificateVO;
import com.myfun.erpWeb.house.vo.EntrustFilesVO;
import com.myfun.erpWeb.house.vo.OwnerUserVO;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.EntrustAuditDetailParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.SelectEntrusListParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.UpdateEntrustRecordParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.vo.EntrusListVO;
import com.myfun.erpWeb.managecenter.mlEntrustManage.vo.EntrustAuditDetailVO;
import com.myfun.erpWeb.managecenter.mlEntrustManage.vo.SelectEntrusListVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunEntrustService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 美联委托管理
 * @author HuangJiang
 * @since 2019年11月26日 16:23:53
 * Modified XXX HuangJiang 2019年11月26日
 */
@Api(tags = "美联委托管理")
@RestController
@RequestMapping("/manageCenter/mlEntrustManage")
public class MlEntrustManageController extends BaseController {
    
    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpFunEntrustFilesMapper erpFunEntrustFilesMapper;
    @Autowired
    private ErpFunEntrustCertificateMapper erpFunEntrustCertificateMapper;
    @Autowired
    private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpFunEntrustTrackMapper erpFunEntrustTrackMapper;
    @Autowired
    private ErpFunEntrustService erpFunEntrustService;
    @Autowired
    private ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;

    /**
     * 管理中心-委托列表查询
     * detail task#12332 [20-5-12] wc 备案增加委托价格
     * detail task#141358 [20-5-15] wc 委托列表增加租售委托价格 是否租售共享 房屋用途
     * @author HuangJiang
     * @since 2019年11月26日 16:29
     * @param param
     * @return com.myfun.framework.web.json.ErpResponseJson
     * Modified XXX HuangJiang 2019年11月26日
     */
    @ApiOperation(value = "管理中心-委托列表查询，作者：黄江")
    @PostMapping("/selectEntrusList")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = SelectEntrusListVO.class)})
    public ErpResponseJson selectEntrusList(@RequestBody SelectEntrusListParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        param.setCurrentUserId(operator.getUserId());
        List<Integer> userIdList = new ArrayList<>();
        // 关联查询的表：1=分组 2=门店 3=片区 4=大区
        if (null != param.getUserId()) {
            userIdList.add(param.getUserId());
        } else if (null != param.getGrId()) {
            param.setSelectTalbe(1);
        } else if (null != param.getDeptId()) {
            param.setSelectTalbe(2);
        } else if (null != param.getRegId()) {
            param.setSelectTalbe(3);
        } else if (null != param.getAreaId()) {
            param.setSelectTalbe(4);
        }
        if (null == param.getCompId()) {
            param.setCompId(compId);
        }
        
        // 人员类型对应字段 1=APPROVE_USER_ID 2=AUDIT_USER_ID 3=RECORD_USER 默认APPROVE_USER_ID
        if (null != param.getUserType()) {
            if (param.getUserType() == 1) {
                param.setUserTypeCn("APPROVE_USER_ID");
            } else if (param.getUserType() == 2) {
                param.setUserTypeCn("AUDIT_USER_ID");
            } else if (param.getUserType() == 3) {
                param.setUserTypeCn("RECORD_USER");
            }
        } else {
            param.setUserTypeCn("APPROVE_USER_ID");
        }
        
        if (StringUtil.isNotEmpty(param.getCreateTimeStart()) && StringUtil.isNotEmpty(param.getCreateTimeEnd())) {
            param.setCreateTime1(DateUtil.StringToDate(param.getCreateTimeStart() + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
            param.setCreateTime2(DateUtil.StringToDate(param.getCreateTimeEnd() + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
        }
        if (null != param.getOrganizationId() && param.getOrganizationId() == 0) {
            param.setOrganizationId(null);
        }
        param.setAuditType(Const.DIC_TRACK_TYPE_ENTRUST_DATA);
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<EntrusListVO> listVO = erpFunEntrustMapper.selectEntrustList(cityId, param);
        PageInfo<EntrusListVO> pageInfo = new PageInfo<>(listVO);
        
        // 获取楼盘名称
        if (listVO.size() > 0) {
            // 获取委托参与员工姓名map
            Set<Integer> userIdSet = new HashSet<>();
            Set<Integer> approveUserIdSet = listVO.stream().filter(approveUserId -> null != approveUserId).map(EntrusListVO::getApproveUserId).collect(Collectors.toSet());
            Set<Integer> auditUserIdSet = listVO.stream().filter(auditUserId -> null != auditUserId).map(EntrusListVO::getAuditUserId).collect(Collectors.toSet());
            Set<Integer> recordUserIdSet = listVO.stream().filter(recordUser -> null != recordUser).map(EntrusListVO::getRecordUser).collect(Collectors.toSet());
            userIdSet.addAll(approveUserIdSet);
            userIdSet.addAll(auditUserIdSet);
            userIdSet.addAll(recordUserIdSet);
            List<ErpFunUsers> userList = new ArrayList<>();
            if (userIdSet.size() > 0) {
                userList = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
            }
            Map<Integer, String> userNameMap = new HashMap<>();
            if (userList.size() > 0) {
                for (ErpFunUsers erpFunUsers : userList) {
                    userNameMap.put(erpFunUsers.getUserId(), erpFunUsers.getUserName());
                }
            }
            Integer caseId = null; // 房源ID
            Integer caseType = null; // 房源类型 1=出售 2=出租
            // 查询 楼盘名称 楼层 总楼层 栋座 单元 房号
            String[] saleColumns = {"BUILD_NAME","SALE_FLOOR","SALE_FLOORS","SALE_ROOF_T","SALE_UNIT_T","SALE_NUM_T","UNIT_FLOOR_R","ML_WHOLE_LAYER","IS_SALE_LEASE","SALE_LEASE_ID","SALE_USEAGE"};
            String[] leaseColumns = {"BUILD_NAME","LEASE_FLOOR","LEASE_FLOORS","LEASE_ROOF_T","LEASE_UNIT_T","LEASE_NUM_T","UNIT_FLOOR_R","ML_WHOLE_LAYER","IS_SALE_LEASE","SALE_LEASE_ID","LEASE_USEAGE"};
            //detail task#141358 [20-5-15] wc 委托列表增加租售委托价格 是否租售共享 房屋用途
            String pramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, operator.getUserId(), "IS_SHARE_ENTRUST_DATA");
            for (EntrusListVO vo : listVO) {
                // 查房源
                caseId = vo.getCaseId();
                caseType = vo.getCaseType();
                if (null != caseId && null != caseType) {
                    if (caseType == 1) {
                        ErpFunSale erpFunSale = erpFunSaleMapper.selectColumnById(cityId, caseId, compId, saleColumns);
                        if (null != erpFunSale) {
                            vo.setBuildName(erpFunSale.getBuildName());
                            if (null != erpFunSale.getSaleFloor()) {
                                vo.setFloor(erpFunSale.getSaleFloor().toString());
                            } else {
                                if (StringUtil.isNotEmpty(erpFunSale.getUnitFloorR())) {
                                    vo.setFloor(EnCodeHelper.decode(erpFunSale.getUnitFloorR()).replaceFirst("^0*", ""));
                                }
                            }
                            if (null != erpFunSale.getSaleFloors()) {
                                vo.setTotalFloor(erpFunSale.getSaleFloors().toString());
                            }
                            vo.setRoof(erpFunSale.getSaleRoofT());
                            vo.setUnit(erpFunSale.getSaleUnitT());
                            vo.setRoomNum(erpFunSale.getSaleNumT());
                            if (null != erpFunSale.getMlWholeLayer() && erpFunSale.getMlWholeLayer() == 1) {
                                vo.setRoomNum("整层");
                            }

                            vo.setHouseUseage(erpFunSale.getSaleUseage());
                            if ("1".equals(pramValue) && Byte.valueOf("1").equals(erpFunSale.getIsSaleLease()) && null != erpFunSale.getSaleLeaseId()) {
                                vo.setSaleLease(true);
                            }
                        }
                    } else {
                        ErpFunLease erpFunLease = erpFunLeaseMapper.selectColumnById(cityId, caseId, compId, leaseColumns);
                        if (null != erpFunLease) {
                            vo.setBuildName(erpFunLease.getBuildName());
                            if (null != erpFunLease.getLeaseFloor()) {
                                vo.setFloor(erpFunLease.getLeaseFloor().toString());
                            } else if (StringUtil.isNotEmpty(erpFunLease.getUnitFloorR())) {
                                vo.setFloor(EnCodeHelper.decode(erpFunLease.getUnitFloorR()));
                            }
                            if (null != erpFunLease.getLeaseFloors()) {
                                vo.setTotalFloor(erpFunLease.getLeaseFloors().toString());
                            }
                            vo.setRoof(erpFunLease.getLeaseRoofT());
                            vo.setUnit(erpFunLease.getLeaseUnitT());
                            vo.setRoomNum(erpFunLease.getLeaseNumT());
                            if (null != erpFunLease.getMlWholeLayer() && erpFunLease.getMlWholeLayer() == 1) {
                                vo.setRoomNum("整层");
                            }

                            vo.setHouseUseage(erpFunLease.getLeaseUseage());
                            if ("1".equals(pramValue) && Byte.valueOf("1").equals(erpFunLease.getIsSaleLease()) && null != erpFunLease.getSaleLeaseId()) {
                                vo.setSaleLease(true);
                            }
                        }
                    }
                }
                
                // 查姓名
                vo.setApproveUserName(userNameMap.get(vo.getApproveUserId()));
                vo.setRecordUserName(userNameMap.get(vo.getRecordUser()));
                vo.setAuditUserName(userNameMap.get(vo.getAuditUserId()));
            }
        }
        SelectEntrusListVO selectEntrusListVO = new SelectEntrusListVO();
        ErpUserOpers erpUserOpers1 = erpUserOpersMapper.selectPerPermissionByName(cityId, operator.getUserId(), "ENTRUST_RECORD");
        if (null != erpUserOpers1) {
            selectEntrusListVO.setEntrustRecord(1);
        } else {
            selectEntrusListVO.setEntrustRecord(1);
        }
        ErpUserOpers erpUserOpers2 = erpUserOpersMapper.selectPerPermissionByName(cityId, operator.getUserId(), "ENTRUST_RECORD");
        if (null != erpUserOpers2) {
            selectEntrusListVO.setClearEntrustRecord(1);
        } else {
            selectEntrusListVO.setClearEntrustRecord(1);
        }
        selectEntrusListVO.setPageInfo(pageInfo);
        return ErpResponseJson.ok(selectEntrusListVO);
    }
    
    /**
     * 委托资料审核详情
     * @author HuangJiang
     * @since 2019年11月27日 15:52
     * @param param
     * @return com.myfun.framework.web.json.ErpResponseJson
     * Modified XXX HuangJiang 2019年11月27日
     */
    @ApiOperation(value = "委托资料审核详情，作者：黄江")
    @PostMapping("/entrustAuditDetail")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "", response = EntrustAuditDetailVO.class)})
    public ErpResponseJson entrustAuditDetail(@RequestBody EntrustAuditDetailParam param) throws Exception {
        if (null == param.getEntrustId()) {
            return ErpResponseJson.warn("未获取到委托ID");
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();

        // 查询委托信息
        ErpFunEntrust selectKey = new ErpFunEntrust();
        selectKey.setShardCityId(cityId);
        selectKey.setEntrustId(param.getEntrustId());
        ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(selectKey);
        if (null == erpFunEntrust) {
            return ErpResponseJson.warn("未查询出委托信息");
        }

        // 查询房源信息 楼盘名称 房源用途 面积 几室几厅 装修情况 朝向 价格
        if (null == erpFunEntrust.getCaseId() || null == erpFunEntrust.getCaseType()) {
            return ErpResponseJson.warn("该委托中的房源信息缺失");
        }
    
        // 查询业主信息
        ErpFunEntrustOwnersExample erpFunEntrustOwnersExample = new ErpFunEntrustOwnersExample();
        erpFunEntrustOwnersExample.setShardCityId(cityId);
        erpFunEntrustOwnersExample.createCriteria().andEntrustIdEqualTo(param.getEntrustId());
        List<ErpFunEntrustOwners> ownersList = erpFunEntrustOwnersMapper.selectByExample(erpFunEntrustOwnersExample);
        List<OwnerUserVO> ownerList = new ArrayList<>();
        if (ownersList.size() > 0) {
            for (ErpFunEntrustOwners owners : ownersList) {
                OwnerUserVO ownerUserVO = new OwnerUserVO();
                ownerUserVO.setId(owners.getId());
                ownerUserVO.setOwnerName(owners.getOwnerName());
                ownerUserVO.setCardNo(owners.getCardNo());
                ownerUserVO.setIdType(owners.getIdType());
                ownerUserVO.setEntrustId(owners.getEntrustId());
                ownerList.add(ownerUserVO);
            }
        }
        
        // 查询产权号信息
        ErpFunEntrustCertificateExample erpFunEntrustCertificateExample = new ErpFunEntrustCertificateExample();
        erpFunEntrustCertificateExample.setShardCityId(cityId);
        erpFunEntrustCertificateExample.createCriteria().andEntrustIdEqualTo(param.getEntrustId());
        List<ErpFunEntrustCertificate> certificatesList = erpFunEntrustCertificateMapper.selectByExample(erpFunEntrustCertificateExample);
        List<EntrustCertificateVO> certificateList = new ArrayList<>();
        if (certificatesList.size() > 0){
            for (ErpFunEntrustCertificate certificate : certificatesList) {
                EntrustCertificateVO entrustCertificateVO = new EntrustCertificateVO();
                entrustCertificateVO.setCertificateId(certificate.getId());
                entrustCertificateVO.setEntrustId(certificate.getEntrustId());
                entrustCertificateVO.setCertificateType(certificate.getCertificateType());
                entrustCertificateVO.setCertificateNo(certificate.getCertificateNo());
                certificateList.add(entrustCertificateVO);
            }
        }

        // 查询附件信息
        ErpFunEntrustFilesExample erpFunEntrustFilesExample = new ErpFunEntrustFilesExample();
        erpFunEntrustFilesExample.setShardCityId(cityId);
        erpFunEntrustFilesExample.createCriteria().andEntrustIdEqualTo(param.getEntrustId());
        List<ErpFunEntrustFiles> filesList = erpFunEntrustFilesMapper.selectByExample(erpFunEntrustFilesExample);
        List<EntrustFilesVO> fileList = new ArrayList<>();
        if (filesList.size() > 0) {
            String picDomain = AppConfig.getPicDomainUrl();
            for (ErpFunEntrustFiles files : filesList) {
                EntrustFilesVO entrustFilesVO = new EntrustFilesVO();
                BeanUtil.copyObject(files, entrustFilesVO);
                entrustFilesVO.setFileId(files.getId());
                entrustFilesVO.setFilePathUrl(picDomain + files.getFilePath());
                fileList.add(entrustFilesVO);
            }
        }

        // 组装返回值
        EntrustAuditDetailVO entrustAuditDetailVO = new EntrustAuditDetailVO();
        entrustAuditDetailVO.setEntrustType(erpFunEntrust.getEntrustType());
        entrustAuditDetailVO.setEntrustEnd(erpFunEntrust.getEntrustEnd());
        entrustAuditDetailVO.setCaseId(erpFunEntrust.getCaseId());
        entrustAuditDetailVO.setCaseType(erpFunEntrust.getCaseType());
        entrustAuditDetailVO.setEntrustNo(erpFunEntrust.getEntrustNo());
        entrustAuditDetailVO.setEntrustStart(erpFunEntrust.getEntrustStart());
        entrustAuditDetailVO.setEntrustEnd(erpFunEntrust.getEntrustEnd());
        entrustAuditDetailVO.setOwnerList(ownerList);
        entrustAuditDetailVO.setCertificateList(certificateList);
        entrustAuditDetailVO.setFileList(fileList);
        return ErpResponseJson.ok(entrustAuditDetailVO);
    }
    
    /**
     * 修改备案（添加，修改或清空备案）
     * @author HuangJiang
     * @since 2019年11月28日 10:13
     * @param param
     * @return com.myfun.framework.web.json.ErpResponseJson
     * Modified XXX HuangJiang 2019年11月28日
     */
    @ApiOperation(value = "修改备案（添加，修改或清空备案），作者：黄江")
    @PostMapping("/updateEntrustRecord")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "")})
    public ErpResponseJson updateEntrustRecord(@RequestBody UpdateEntrustRecordParam param) throws Exception {

        if (null == param.getEntrustId()) {
            return ErpResponseJson.warn("未获取到委托ID");
        }
        if (null == param.getOperateType()) {
            return ErpResponseJson.warn("未获取到操作类型");
        }
        if (param.getOperateType() < 1 || param.getOperateType() > 3) {
            return ErpResponseJson.warn("操作类型错误");
        }
        if (param.getOperateType() != 3 && null == param.getRecordUser()) {
            return ErpResponseJson.warn("备案人不能为空");
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunEntrust selectKey = new ErpFunEntrust();
        selectKey.setShardCityId(cityId);
        selectKey.setEntrustId(param.getEntrustId());
        ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(selectKey);
        if (null == erpFunEntrust) {
            return ErpResponseJson.warn("未查询出委托信息");
        }
        erpFunEntrustService.updateEntrustRecord(operator, erpFunEntrust, param);

        try {
            // 修改备案后，判断是否需要自动发布官网
            //查询上架官网系统参数条件
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

            List<String> paramIds = new ArrayList<>();
            paramIds.add("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET");
            paramIds.add("RENT_HOUSE_PUBLISH_WEBSITE_SET");
            Map<String, String> sysParamMap = erpSysParaService.getMLSysParamMapByUserType(cityId, houseCompId, houseUserId, paramIds);
            if (param.getOperateType() == 1) {
                if ((erpFunEntrust.getCaseType() == 1 && sysParamMap.get("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET") != null) || (erpFunEntrust.getCaseType() == 2 && sysParamMap.get("RENT_HOUSE_PUBLISH_WEBSITE_SET") != null)) {
                    if ("0".equals(sysParamMap.get("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET")) || "0".equals(sysParamMap.get("RENT_HOUSE_PUBLISH_WEBSITE_SET"))) {
                        Map<String, Object> paramData = new HashMap<>();
                        paramData.put("caseId", erpFunEntrust.getCaseId());
                        paramData.put("caseType", erpFunEntrust.getCaseType());
                        paramData.put("flag", "0");
                        String res = HttpUtil.postNewErp(AppConfig.getHouseCustWeb() + "/broker/house/sendHouseToWebsite", paramData, operator.getClientKey());
                        System.out.println(res);
                    }
                }
            } else if (param.getOperateType() == 3) {
                if ((erpFunEntrust.getCaseType() == 1 && sysParamMap.get("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET") != null) || (erpFunEntrust.getCaseType() == 2 && sysParamMap.get("RENT_HOUSE_PUBLISH_WEBSITE_SET") != null)) {
                    Map<String, Object> paramData = new HashMap<>();
                    paramData.put("caseId", erpFunEntrust.getCaseId());
                    paramData.put("caseType", erpFunEntrust.getCaseType());
                    paramData.put("flag", "0");
                    String res = HttpUtil.postNewErp(AppConfig.getHouseCustWeb() + "/broker/house/downHouseFromWebsite", paramData, operator.getClientKey());
                    System.out.println(res);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErpResponseJson.ok();
    }
    
    
}

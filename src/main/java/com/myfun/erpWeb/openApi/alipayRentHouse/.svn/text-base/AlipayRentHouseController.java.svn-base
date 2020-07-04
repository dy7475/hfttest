package com.myfun.erpWeb.openApi.alipayRentHouse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayEcoRenthouseRoomStateSyncModel;
import com.alipay.api.internal.util.AlipayEncrypt;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayEcoRenthouseRoomStateSyncRequest;
import com.alipay.api.response.AlipayEcoRenthouseRoomStateSyncResponse;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.RentHouseResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminAliRenthousePunishmentMapper;
import com.myfun.repository.admindb.dao.AdminZfbHouseTransMapper;
import com.myfun.repository.admindb.dao.AdminZfbTransDetailMapper;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpAliRentHouseReservationService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.bean.param.AlipayRentHouseParam;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
  * 支付宝租房同步平台接口
  * @author 李成兵
  * @since 2018/5/21
  * @param 
  * @return
  */
@Controller
@RequestMapping( "/openApi/alipayRentHouse")
public class AlipayRentHouseController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(AlipayRentHouseController.class);

    @Autowired
    ErpFunSaleService erpFunSaleService;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    AdminZfbTransDetailMapper adminZfbTransDetailMapper;
    @Autowired
    ErpAliRentHouseReservationService erpAliRentHouseReservationService;
    @Autowired
    AdminAliRenthousePunishmentMapper adminAliRenthousePunishmentMapper;
    @Autowired
    AdminZfbHouseTransMapper adminZfbHouseTransMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    ErpAliRenthouseDialingrecordMapper erpAliRenthouseDialingrecordMapper;
    @Autowired
    ErpAliRenthouseReservationMapper erpAliRenthouseReservationMapper;
//    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    /**
     * 预约看房
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/createReservationOrder")
    public RentHouseResponseJson bookingSeeHouse(AlipayRentHouseParam param){
        try{
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            Boolean validate = validataParamSign(request);
            if(!validate) {
                logger.error("在线预约接口无权访问,参数："+param.toString()+",IP地址："+getIpAddress(request));
                return new RentHouseResponseJson(3);
            }

            // 拿到roomCode 查询数据
            if(StringUtils.isNotBlank(param.getRoomCode())) {
                    // 查询房源信息
                AdminZfbTransDetail adminZfbTransDetail = adminZfbTransDetailMapper.selectByPrimaryKey(Integer.valueOf(param.getRoomCode()));
                ErpAliRenthouseReservationExample example = new ErpAliRenthouseReservationExample();
                example.setShardCityId(adminZfbTransDetail.getCityId());
                example.createCriteria().andAliUserIdEqualTo(param.getAliUserId()).andRoomCodeEqualTo(param.getRoomCode()).andLookTimeEqualTo(DateUtil.StringToDate(param.getLookTime(), "yyyy-MM-dd HH:mm"));
                Integer count = erpAliRenthouseReservationMapper.countByExample(example);
                if(count == 0) {
                    if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(adminZfbTransDetail.getCaseType() + "")) {
                        ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(adminZfbTransDetail.getCityId(), adminZfbTransDetail.getCaseId());
                        // 预发 qWNyRTM76HojuQcLGBqYsA==
                        // 正式 OFjw+p+lXidckub5aDa88A==
                        String aes = AlipayEncrypt.decryptContent(param.getBookPhone(), "AES", "OFjw+p+lXidckub5aDa88A==", "UTF-8");
                        ErpAliRenthouseReservation erpAliRenthouseReservation = new ErpAliRenthouseReservation();
                        erpAliRenthouseReservation.setAliUserId(param.getAliUserId());
                        erpAliRenthouseReservation.setBookPhone(aes);
                        erpAliRenthouseReservation.setBookSex(param.getBookSex());
                        erpAliRenthouseReservation.setCaseId(funLeaseByLeaseId.getLeaseId());
                        erpAliRenthouseReservation.setCaseType(Integer.valueOf(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN));
                        erpAliRenthouseReservation.setCompId(funLeaseByLeaseId.getCompId());
                        erpAliRenthouseReservation.setDeptId(adminZfbTransDetail.getSyncCaseDeptId());
                        erpAliRenthouseReservation.setFlatsTag(param.getFlatsTag());
                        erpAliRenthouseReservation.setLookTime(DateUtil.StringToDate(param.getLookTime(), "yyyy-MM-dd HH:mm"));
                        erpAliRenthouseReservation.setRemark(param.getRemark());
                        erpAliRenthouseReservation.setRoomCode(param.getRoomCode());
                        erpAliRenthouseReservation.setShardCityId(adminZfbTransDetail.getCityId());
                        erpAliRenthouseReservation.setBookName(param.getBookName());
                        erpAliRenthouseReservation.setCaseUserId(adminZfbTransDetail.getSyncCaseUserId());
                        erpAliRentHouseReservationService.createReservation(erpAliRenthouseReservation, funLeaseByLeaseId);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("预约看房报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
        return new RentHouseResponseJson();
    }

    static String getIpAddress(HttpServletRequest request) {
           String ip = request.getHeader("x-forwarded-for");
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
              ip = request.getHeader("Proxy-Client-IP");
          }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
              ip = request.getHeader("WL-Proxy-Client-IP");
          }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
              ip = request.getHeader("HTTP_CLIENT_IP");
          }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
              ip = request.getHeader("HTTP_X_FORWARDED_FOR");
          }
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
              ip = request.getRemoteAddr();
          }
      return ip;
    }


     /**
      * 拨号记录
      * @author 李成兵
      * @since 2018/5/21
      * @param
      * @return
      */
    @ResponseBody
    @RequestMapping("/dialingRecord")
    public RentHouseResponseJson dialingRecord(AlipayRentHouseParam param){
        try{
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            Boolean validate = validataParamSign(request);
            if(!validate) {
                logger.error("拨打电话接口无权访问,参数："+param.toString()+",IP地址："+getIpAddress(request));
                return new RentHouseResponseJson(3);
            }
            // 拿到roomCode 查询数据
            if(StringUtils.isNotBlank(param.getRoomCode())) {
                // 判重
                AdminZfbTransDetail adminZfbTransDetail = adminZfbTransDetailMapper.selectByPrimaryKey(Integer.valueOf(param.getRoomCode()));
                ErpAliRenthouseDialingrecordExample example = new ErpAliRenthouseDialingrecordExample();
                example.setShardCityId(adminZfbTransDetail.getCityId());
                example.createCriteria().andAliUserIdEqualTo(param.getAliUserId()).andRoomCodeEqualTo(param.getRoomCode()).andRecordTimeEqualTo(DateUtil.StringToDate(param.getRecordTime(), "yyyy-MM-dd HH:mm"));
                Integer i = erpAliRenthouseDialingrecordMapper.countByExample(example);
                // 同一时间的数据不管
                if(i == 0) {
                    // 查询房源信息
                    if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(adminZfbTransDetail.getCaseType() + "")) {
                        ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(adminZfbTransDetail.getCityId(), adminZfbTransDetail.getCaseId());
                        ErpAliRenthouseDialingrecord record = new ErpAliRenthouseDialingrecord();
                        record.setAliUserId(param.getAliUserId());
                        record.setCaseId(funLeaseByLeaseId.getLeaseId());
                        record.setCaseType(Integer.valueOf(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN));
                        record.setCityId(adminZfbTransDetail.getCityId());
                        record.setCompId(funLeaseByLeaseId.getCompId());
                        record.setDeptId(adminZfbTransDetail.getSyncCaseDeptId());
                        record.setFlatsTag(param.getFlatsTag());
                        record.setRecordTime(DateUtil.StringToDate(param.getRecordTime(), "yyyy-MM-dd HH:mm"));
                        record.setRoomCode(param.getRoomCode());
                        record.setUserId(adminZfbTransDetail.getSyncCaseUserId());
                        record.setZhimaOpenId(param.getZhimaOpenId());
                        record.setShardCityId(adminZfbTransDetail.getCityId());
                        erpAliRentHouseReservationService.createDataDialRecord(record);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("拨号记录报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
       return new RentHouseResponseJson();
    }

    /**
     * 确认租约
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/confirmLeaseContract")
    public RentHouseResponseJson confirmLease(AlipayRentHouseParam param){
        try{

            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String ipAddress = getIpAddress(request);
            System.out.println(ipAddress);

        }catch (Exception e) {
            logger.error("确认租约报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
       return new RentHouseResponseJson();
    }

    /**
     * 小区状态通知
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/communityStatusNotify")
    public RentHouseResponseJson communityStatusNotify(AlipayRentHouseParam param){
        try{
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String ipAddress = getIpAddress(request);
            System.out.println(ipAddress);

        }catch (Exception e) {
            logger.error("小区状态通知报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
       return new RentHouseResponseJson();
    }

    /**
     * 房源惩罚隐藏
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/punishHideNotify")
    public RentHouseResponseJson punishHideNotify(AlipayRentHouseParam param){
        try{
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            Boolean validate = validataParamSign(request);
            if(!validate) {
                logger.error("房源惩罚接口无权访问,参数："+param.toString()+",IP地址："+getIpAddress(request));
                return new RentHouseResponseJson(3);
            }
            // 拿到roomCode 查询数据
            if(StringUtils.isNotBlank(param.getRoomCode())) {
                // 查询房源信息
                AdminZfbTransDetail adminZfbTransDetail = adminZfbTransDetailMapper.selectByPrimaryKey(Integer.valueOf(param.getRoomCode()));
                if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(adminZfbTransDetail.getCaseType() + "")) {
                   ErpFunLease funLease = erpFunLeaseMapper.getFunLeaseByLeaseId(adminZfbTransDetail.getCityId(), adminZfbTransDetail.getCaseId());
                   AdminAliRenthousePunishment punishment = new AdminAliRenthousePunishment();
                   punishment.setRoomCode(param.getRoomCode());
                   punishment.setRemark(param.getRemark());
                   punishment.setPunishmentStatus(param.getPunishmentStatus());
                   punishment.setPunishmentReason(param.getPunishmentReason());
                   punishment.setPunishmentDays(param.getPunishmentDays());
                   punishment.setFlatNum(param.getFlatNum());
                   punishment.setDeptId(adminZfbTransDetail.getSyncCaseDeptId());
                   punishment.setCreateTime(new Date());
                   punishment.setCompId(funLease.getCompId());
                   punishment.setCityId(adminZfbTransDetail.getCityId());
                   punishment.setCaseType(Integer.valueOf(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN));
                   punishment.setCaseId(funLease.getLeaseId());

                   Integer userId = adminZfbTransDetail.getSyncCaseUserId();
                   ErpFunUsers userInfoByUserId = erpFunUsersMapper.getUserInfoByUserId(adminZfbTransDetail.getCityId(), userId);
                   ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(adminZfbTransDetail.getCityId(), userInfoByUserId.getUserId());

                   punishment.setArchiveId(userInfoByUserId.getArchiveId());
                   punishment.setUserId(userId);
                   punishment.setDeptNo(erpFunDepts.getDeptNo());
                   punishment.setCompNo(erpFunDepts.getCompNo());
                   adminAliRenthousePunishmentMapper.insertSelective(punishment);
                   if( 0== param.getPunishmentStatus()) {
                       // 下架
                       AdminZfbTransDetail update = new AdminZfbTransDetail();
                       update.setRoomStatus((byte) 0);
                       update.setId(adminZfbTransDetail.getId());
                       adminZfbTransDetailMapper.updateByPrimaryKeySelective(update);
                   }else {
                       // 恢复
                       reupdateToUploadToZfb(funLease);
                   }

                }
            }
        }catch (Exception e) {
            logger.error("房源惩罚隐藏报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
       return new RentHouseResponseJson();
    }

    private void reupdateToUploadToZfb(ErpFunLease erpFunLease) {
        AdminZfbHouseTransExample adminZfbHouseTransExample = new AdminZfbHouseTransExample();
        adminZfbHouseTransExample.createCriteria().andCaseIdEqualTo(erpFunLease.getLeaseId()).
                andCaseTypeEqualTo(2).andCityIdEqualTo(erpFunLease.getCityId()).andAuditStatusNotEqualTo(3);
        adminZfbHouseTransExample.setOrderByClause("ID DESC");
        List<AdminZfbHouseTrans> zfbHouseTrans = adminZfbHouseTransMapper.selectByExample(adminZfbHouseTransExample);

        if(zfbHouseTrans.size() > 0) {
            // 未审核
            List<Integer> resList0 = new ArrayList<>();
            // 审核成功
            List<Integer> resList1 = new ArrayList<>();
            // 同步成功
            List<Integer> resList2 = new ArrayList<>();
            // 审核失败，此房源不会再被通过
            List<Integer> resList3 = new ArrayList<>();
            // 审核失败
            List<Integer> resList4 = new ArrayList<>();
            for (AdminZfbHouseTrans adminZfbHouseTrans : zfbHouseTrans) {

                if(0 == adminZfbHouseTrans.getAuditStatus().intValue()) {
                    resList0.add(adminZfbHouseTrans.getId());
                }
                if(1 == adminZfbHouseTrans.getAuditStatus().intValue()) {
                    resList1.add(adminZfbHouseTrans.getId());
                }
                if(2 == adminZfbHouseTrans.getAuditStatus().intValue()) {
                    resList2.add(adminZfbHouseTrans.getId());
                }
                if(3 == adminZfbHouseTrans.getAuditStatus().intValue()) {
                    resList3.add(adminZfbHouseTrans.getId());
                }
            }

            // 如果有审核失败的数据，那么其他数据都改为作废（不删除是为了关联）
            if(resList3.size() > 0) {
                // 有假房源之类的数据，不在上了
                return;
            }else if(resList1.size() > 0 || resList0.size() > 0 || resList2.size() > 0) {
                // 只保留一条审核成功的数据，修改为待审核
                Integer id = 0;
                if(resList1.size() > 0) {
                    id= resList1.get(0);
                }else if(resList0.size() > 0){
                    id= resList0.get(0);
                }else if(resList2.size() > 0){
                    id= resList2.get(0);
                }else if(resList4.size() > 0){
                    id= resList4.get(0);
                }
                adminZfbHouseTransExample = new AdminZfbHouseTransExample();
                adminZfbHouseTransExample.createCriteria().andIdEqualTo(id);
                AdminZfbHouseTrans adminZfbHouseTrans = new AdminZfbHouseTrans();
                adminZfbHouseTrans.setAuditStatus(0);
                adminZfbHouseTrans.setCreationTime(new Date());

                if (null != erpFunLease.getCreatorUid() && null != erpFunLease.getDeptId()) {
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(erpFunLease.getCityId(), erpFunLease.getUserId());
                    ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(erpFunLease.getCityId(), erpFunLease.getDeptId());
                    adminZfbHouseTrans.setCompNo(erpFunDepts.getCompNo());
                    adminZfbHouseTrans.setDeptNo(erpFunDepts.getDeptNo());
                    adminZfbHouseTrans.setUserName(erpFunUsers.getUserName());
                    adminZfbHouseTrans.setUserMobile(erpFunUsers.getUserMobile());
                    adminZfbHouseTrans.setHouseTitile(erpFunLease.getLeaseSubject());
                    adminZfbHouseTransMapper.updateByExampleSelective(adminZfbHouseTrans, adminZfbHouseTransExample);
                }
            } else {
                AdminZfbHouseTrans adminZfbHouseTrans = new AdminZfbHouseTrans();
                adminZfbHouseTrans.setCaseId(erpFunLease.getLeaseId());
                adminZfbHouseTrans.setCaseType(Integer.valueOf(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN));
                adminZfbHouseTrans.setCityId(erpFunLease.getCityId());
                adminZfbHouseTrans.setCreationTime(new Date());
                if (null != erpFunLease.getCreatorUid() && null != erpFunLease.getDeptId()) {
                    ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(erpFunLease.getCityId(), erpFunLease.getCreatorUid());
                    ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(erpFunLease.getCityId(), erpFunLease.getDeptId());
                    adminZfbHouseTrans.setCompNo(erpFunDepts.getCompNo());
                    adminZfbHouseTrans.setDeptNo(erpFunDepts.getDeptNo());
                    adminZfbHouseTrans.setUserName(erpFunUsers.getUserName());
                    adminZfbHouseTrans.setUserMobile(erpFunUsers.getUserMobile());
                    adminZfbHouseTrans.setHouseTitile(erpFunLease.getLeaseSubject());
                    adminZfbHouseTrans.setCaseNo(erpFunLease.getLeaseNo());
                    adminZfbHouseTransMapper.insertSelective(adminZfbHouseTrans);
                }
            }
        }
    }

    /**
     * 支付成功通知
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/paySuccessNotify")
    public RentHouseResponseJson paySuccessNotify(AlipayRentHouseParam param){
        try{
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = requestAttributes.getRequest();
            String ipAddress = getIpAddress(request);
            System.out.println(ipAddress);
        }catch (Exception e) {
            logger.error("支付成功通知报错!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
       return new RentHouseResponseJson();
    }

    private Boolean validataParamSign(HttpServletRequest request) throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
        Map<String, String> params = new HashMap<String, String>();
        if (null != request) {
            Set<String> paramsKey = request.getParameterMap().keySet();
            for (String key : paramsKey) {
                params.put(key, request.getParameter(key));
            }
        }

        System.out.println(params);

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以下仅供参考)//

        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        //计算得出通知验证结果
        boolean verify_result = false;
        try {
            verify_result = AlipaySignature.rsaCheckV2(params, publicKey, AlipayConstants.CHARSET_UTF8);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return  verify_result;
    }

    /**
     * 下架单条房源
     * @author 李成兵
     * @since 2018/5/21
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/downAllZfbHouse")
    public RentHouseResponseJson downSignleHouse(AlipayRentHouseParam param){
        try{
            Integer archiveId = param.getArchiveId();
            // 查询在线房源
            AdminZfbTransDetailExample example = new AdminZfbTransDetailExample();
            example.createCriteria().andSyncCaseArchiveIdEqualTo(archiveId).andRoomStatusEqualTo((byte) 1);

            List<AdminZfbTransDetail> adminZfbTransDetails = adminZfbTransDetailMapper.selectByExample(example);
            for (AdminZfbTransDetail adminZfbTransDetail : adminZfbTransDetails) {
                downLoadHouse(adminZfbTransDetail.getCityId(), adminZfbTransDetail.getCaseId(), 0, (byte)2);
            }
        }catch (Exception e) {
            logger.error("下架个人同步房源失败!参数:"+param.toString());
            return new RentHouseResponseJson(2);
        }
        return new RentHouseResponseJson();
    }

    private void downLoadHouseBiz(AdminZfbTransDetail adminZfbTransDetail, Integer rentStatus, Integer roomStatus) throws Exception{
        String appId = AppConfig.getProperty("common.taskWeb.aliPayRentHouse.appId");
        String appSecurityKey = AppConfig.getProperty("common.taskWeb.aliPayRentHouse.appSecurityKey");
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", appId, appSecurityKey, "json", "utf-8", "", "RSA2");
        AlipayEcoRenthouseRoomStateSyncModel alipayEcoRenthouseRoomStateSyncModel = new AlipayEcoRenthouseRoomStateSyncModel();
        alipayEcoRenthouseRoomStateSyncModel.setFlatsTag(1L);
        alipayEcoRenthouseRoomStateSyncModel.setRentStatus(rentStatus.longValue());
        alipayEcoRenthouseRoomStateSyncModel.setRoomCode(adminZfbTransDetail.getId() + "");
        alipayEcoRenthouseRoomStateSyncModel.setRoomStatus(roomStatus.longValue());

        AlipayEcoRenthouseRoomStateSyncRequest rentHouseFileUploadRequest = new AlipayEcoRenthouseRoomStateSyncRequest();
        rentHouseFileUploadRequest.setBizModel(alipayEcoRenthouseRoomStateSyncModel);
        AlipayEcoRenthouseRoomStateSyncResponse response = alipayClient.execute(rentHouseFileUploadRequest);
        // 更新下架状态

        if(response.isSuccess()) {
            adminZfbTransDetail.setRoomStatus(roomStatus.byteValue());
            adminZfbTransDetail.setSysDes("下架成功:强制下架");
        }else {
            adminZfbTransDetail.setSysMd5("-1");
            adminZfbTransDetail.setSysDes("下架失败："+response.getBody());
        }
        adminZfbTransDetailMapper.updateByPrimaryKeySelective(adminZfbTransDetail);

    }

    public void downLoadHouse(Integer cityId, Integer caseId, Integer leaseStatus, Byte caseType) {
        try{
            // 不符合条件都下架
            // 判断是否有上架记录
            AdminZfbTransDetailExample adminZfbTransDetailExample = new AdminZfbTransDetailExample();
            adminZfbTransDetailExample.createCriteria().andCityIdEqualTo(cityId).andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType).andRoomStatusEqualTo((byte) 1);
            List<AdminZfbTransDetail> adminZfbTransDetails = adminZfbTransDetailMapper.selectByExample(adminZfbTransDetailExample);
            if(adminZfbTransDetails.size() > 0) {
                for (AdminZfbTransDetail adminZfbTransDetail : adminZfbTransDetails) {
                    downLoadHouseBiz(adminZfbTransDetail, Constants_DIC.DIC_HOUSE_STATUS_AVAILABLE.equals(leaseStatus+"") ? 1 : 2, 0);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @title ：支付宝租房急速下架房源
     * @author：lcb
     * @date  : 2017/11/3
     * @Param roomStatus 0:下架 1：上架
     */
    @RequestMapping("/downLoadHouse")
    @ResponseBody
    public ResponseJson downLoadHouse(Integer cityId, Integer caseId, Byte caseType, Byte roomStatus) throws Exception{
        ErpFunLease erpFunLease = new ErpFunLease();
        erpFunLease.setShardCityId(cityId);
        erpFunLease.setLeaseId(caseId);
        erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
        if(null == erpFunLease) {
            return new DefaultResponseJson(300, "房源数据错误");
        }
        // 查询上架记录
        AdminZfbTransDetailExample adminZfbTransDetailExample = new AdminZfbTransDetailExample();
        AdminZfbTransDetailExample.Criteria criteria = adminZfbTransDetailExample.createCriteria();

        criteria.andCityIdEqualTo(cityId). andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);

        if("0".equals(roomStatus.toString())) {
            criteria.andRoomStatusEqualTo(new Byte("1"));
        }else {
            criteria.andRoomStatusEqualTo(new Byte("0"));
        }
        List<AdminZfbTransDetail> adminZfbTransDetails = adminZfbTransDetailMapper.selectByExample(adminZfbTransDetailExample);
        if(adminZfbTransDetails.size() > 0) {
            AdminZfbTransDetail adminZfbTransDetail = adminZfbTransDetails.get(0);

            String appId = AppConfig.getProperty("common.taskWeb.aliPayRentHouse.appId");
            String appSecurityKey = AppConfig.getProperty("common.taskWeb.aliPayRentHouse.appSecurityKey");
            String aliPayKey = AppConfig.getProperty("common.taskWeb.aliPayRentHouse.aliPayKey");
            AlipayClient alipayClient = new
                    DefaultAlipayClient("https://openapi.alipay.com/gateway.do",appId, appSecurityKey,"json","utf-8",
                    aliPayKey,"RSA2" );

            AlipayEcoRenthouseRoomStateSyncModel alipayEcoRenthouseRoomStateSyncModel = new AlipayEcoRenthouseRoomStateSyncModel();
            alipayEcoRenthouseRoomStateSyncModel.setFlatsTag(1L);
            Long rentStatus = 1L;
            if(Constants_DIC.DIC_HOUSE_STATUS_INNERDEAL.equals(erpFunLease.getLeaseStatus().toString()) ||
                    Constants_DIC.DIC_HOUSE_STATUS_DEAL.equals(erpFunLease.getLeaseStatus().toString())  ) {
                rentStatus = 2L;
            }
            alipayEcoRenthouseRoomStateSyncModel.setRentStatus(rentStatus);
            alipayEcoRenthouseRoomStateSyncModel.setRoomCode(adminZfbTransDetail.getId() + "");
            alipayEcoRenthouseRoomStateSyncModel.setRoomStatus(roomStatus.longValue());

            AlipayEcoRenthouseRoomStateSyncRequest rentHouseFileUploadRequest = new AlipayEcoRenthouseRoomStateSyncRequest();
            rentHouseFileUploadRequest.setBizModel(alipayEcoRenthouseRoomStateSyncModel);
            AlipayEcoRenthouseRoomStateSyncResponse response = alipayClient.execute(rentHouseFileUploadRequest);

            if(roomStatus.intValue() == 1) {
                adminZfbTransDetail.setSysDes("人工上架成功");
                adminZfbTransDetail.setRoomStatus((byte) 1);
            }else {
                adminZfbTransDetail.setRoomStatus((byte) 0);
                adminZfbTransDetail.setSysDes("人工下架成功");
            }
            adminZfbTransDetailMapper.updateByPrimaryKeySelective(adminZfbTransDetail);
            return new DefaultResponseJson(response.isSuccess() ? 200 : 300, response.getSubMsg());
        }
        return new DefaultResponseJson(300, "没查询到同步记录");
    }
}

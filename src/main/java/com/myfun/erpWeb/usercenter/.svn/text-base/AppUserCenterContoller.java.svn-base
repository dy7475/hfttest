package com.myfun.erpWeb.usercenter;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.house.vo.QualificationCertificationVO;
import com.myfun.erpWeb.usercenter.param.EditPasswordParam;
import com.myfun.erpWeb.usercenter.param.MyBaisInfoParam;
import com.myfun.erpWeb.usercenter.param.NameAuthenticationParam;
import com.myfun.erpWeb.usercenter.param.QualificationCertificationParam;
import com.myfun.erpWeb.usercenter.param.UpdateMyAccountParam;
import com.myfun.erpWeb.usercenter.vo.AppRealNameAuthenticationVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUserRqsMapper;
import com.myfun.repository.admindb.dao.AdminMobileKeyMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunUserRqs;
import com.myfun.repository.admindb.po.AdminMobileKey;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.admindb.AdminCompGiftCoinRecordService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunUserRqsService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.HttpUtilNew;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author czq
 * @since 2018/12/30
 */
@Api(tags = "桥接mobileWeb模块")
@RestController
@RequestMapping("/app/myHome")
public class AppUserCenterContoller extends BaseController {

    @Autowired
    private AdminFunUserRqsMapper adminFunUserRqsMapper;
    @Autowired
    private AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    AdminMobileKeyMapper adminMobileKeyMapper;
    @Autowired
    private AdminMobileKeyService adminMobileKeyService;
    @Autowired
    private AdminFunUserRqsService adminFunUserRqsService;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private AdminCompGiftCoinRecordService adminCompGiftCoinRecordService;
    @Autowired
    private AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    private AdminFunArchiveService adminFunArchiveService;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private CacheUtil cacheUtil;

    /**
     * 资质认证
     *
     * @author czq
     * @since 2017年12月30日
     * @param param QualificationCertificationParam
     */
    @ApiOperation("资质认证")
    @ApiResponses(value = {@ApiResponse(code = 0, message = "", response = QualificationCertificationVO.class)})
    @PostMapping("/qualificationCertification")
    @ResponseBody
    public ResponseJson qualificationCertification(@RequestBody QualificationCertificationParam param) {

//		{"data":{"rqsAptitudeStatus":100,"userHonest":0},"errCode":200}

        Operator operator = getOperator();
        Integer archiveId = operator.getArchiveId();
        param.setArchiveId(archiveId);
        adminFunUserRqsService.updateQualificationCertification(param);

        QualificationCertificationVO qualificationCertificationVO = new QualificationCertificationVO();
        AdminFunUserRqs adminFunUserRqs = adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        Integer userHonest = adminFunArchive.getUserHonest();
        if (adminFunUserRqs != null) {
            Integer rqsAptitudeStatus = adminFunUserRqs.getRqsAptitudeStatus();
            qualificationCertificationVO.setRqsAptitudeStatus(rqsAptitudeStatus);
        }
        qualificationCertificationVO.setUserHonest(userHonest);

        return ErpResponseJson.ok(qualificationCertificationVO);
    }

    /**
     * 修改资金账户
     *
     * @author wangchun
     * @since 2018年12月30日
     * @param param UpdateMyAccountParam
     */
    @ApiOperation("修改资金账户")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/updateMyAccount")
    @ResponseBody
    public ResponseJson updateMyAccount(@RequestBody UpdateMyAccountParam param) {
        Operator operator = getOperator();
        Integer archiveId = operator.getArchiveId();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deptId = operator.getDeptId();
        String userName = operator.getUserName();
        Integer provinceId = operator.getProvinceId();
        String mobile = param.getMobile();
        String key = param.getKey();
        Date date = new Date();
        String paseTime = adminSysParaMapper.selectParamVlue("MOBILE_KEY_INVALID_TIME");// 过期时间
        Integer paseTimeInt = Integer.valueOf(paseTime);
        Calendar instance = Calendar.getInstance();
        Date nowTime = instance.getTime();
        instance.setTime(nowTime);
        instance.add(Calendar.MINUTE, -paseTimeInt);
        Date minTime = instance.getTime();
        Integer wrongTime = 0;
        param.setUserName(userName);
        param.setCreateTime(date);
        param.setArchiveId(archiveId);
        param.setCityId(cityId);
        param.setCompId(compId);
        param.setDeptId(deptId);
        param.setProvinceId(provinceId);
        param.setTrackDesc("[资金账户变更]");
        param.setTrackTime(date);
        param.setTrackUser(null);
        String errorCount = adminSysParaMapper.selectParamVlue("MOBILE_KEY_INVALID_COUNT");// 错误次数
        Integer errorCountInt = Integer.valueOf(errorCount);
        List<AdminMobileKey> mobileKeyList = adminMobileKeyMapper.getMobileKey(mobile, minTime, errorCountInt);
        if (!mobileKeyList.isEmpty()) {
            AdminMobileKey adminMobileKey = mobileKeyList.get(0);
            String mobileKey = adminMobileKey.getKey();
            Integer keyId = adminMobileKey.getKeyId();
            if ((StringUtils.isNotEmpty(mobileKey) && key.equals(mobileKey))) {
                Map<String, Object> postParam = new HashMap<String, Object>();
                postParam.put("key", key);
                postParam.put("archiveId", archiveId);
                postParam.put("userMobile", mobile);
                String ret = HttpUtilNew.post(AppConfig.getAdminProjectDomain() + "userAccountBiz/updateUserAccount" , postParam);
                JSONObject jsonObject = JSONObject.parseObject(ret);
                Integer errCode = jsonObject.getInteger("errCode");
                if (errCode != Const.ResponseCode.SUCCESS) {
                    throw new BusinessException(jsonObject.getString("errMsg"));
                }
            } else {
                // 错误次数+1
                wrongTime = wrongTime + 1;
                adminMobileKeyService.addWrongTime(keyId, wrongTime);
                if (wrongTime > errorCountInt - 1) {// 修改状态
                    adminMobileKeyService.changeStatus(keyId);
                }
                throw new BusinessException("验证码错误!请重试!");
            }
        } else {
            throw new BusinessException("验证码错误!请重试!");
        }
        return ErpResponseJson.ok();
    }
    @ApiOperation("实名认证")
    @PostMapping("/realNameAuthentication")
    @ApiResponses(value = {@ApiResponse(code = 0, message = "", response = AppRealNameAuthenticationVO.class)})
    public ResponseJson realNameAuthentication(@Valid @RequestBody NameAuthenticationParam param) throws Exception {
        Operator operator = getOperator();
        Integer archiveId = operator.getArchiveId();
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        //这里依然可以继续提交，原有没有人脸识别的数据可以再次刷脸认证-陈文超-2018-05-24，注意赠送的逻辑防止多次赠送
//		Integer userRight = adminFunArchive.getUserRight();
//		if(userRight.equals(1)){
//			throw new BusinessException("您已经实名认证成功");
//		}
        if(StringUtil.isEmpty(param.getUserIccode())){
            throw new BusinessException("身份证号不能为空");
        }
        param.setArchiveId(archiveId);
        param.setPersonalVersion(operator.isPersonalVersion());
        param.setSellId(this.getSellId());
        adminFunUserRqsService.updateMyNameAuthentication(param);

        AppRealNameAuthenticationVO appRealNameAuthenticationVO = new AppRealNameAuthenticationVO();
        AdminFunUserRqs adminFunUserRqs = adminFunUserRqsMapper.selectByPrimaryKey(archiveId);
        if (adminFunUserRqs != null) {
            Integer rqsActualStatus = adminFunUserRqs.getRqsActualStatus();
            appRealNameAuthenticationVO.setCheckFlag(rqsActualStatus);
        }

        adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        appRealNameAuthenticationVO.setUserRight(adminFunArchive.getUserRight());
        appRealNameAuthenticationVO.setUserIccode(adminFunArchive.getUserIccode());
        appRealNameAuthenticationVO.setRealNamePhoto(AppConfig.getUserPhotoPicDomainPath(adminFunArchive.getRealNamePhoto()));
        if ("0".equals(param.getArtificial())) {
            // 更新房源同步标记
            erpFunSaleMapper.updatePassRealNamePublish(operator.getCityId(), operator.getCompId(), operator.getDeptId(), operator.getUserId());
            erpFunLeaseMapper.updatePassRealNamePublish(operator.getCityId(), operator.getCompId(), operator.getDeptId(), operator.getUserId());
            if(getOperator().isMarketEdition()){
                //赠送公司好房豆
                //取消赠送300好房豆9.0.6
//                adminCompGiftCoinRecordService.giftCompCoin(getOperator().getArchiveId());
            }
            // 刷新会话
            operator.setUserRight("1");
            cacheUtil.put(Const.CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), operator.getAllAtrtibute(), CacheUtilExt.SESSION_TIME_OUT);
        }
        return ErpResponseJson.ok(appRealNameAuthenticationVO);
    }
    /***
     * 查询销售id
     * @author 尹振兴
     * @since 2018年5月4日
     * @return
     */
    private Integer getSellId() {
        Operator operator = getOperator();
        Integer sellId = null;
        if (operator.isPersonalVersion()) {
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(operator.getArchiveId());
            sellId = adminFunArchive.getSellId();
        } else {
            AdminFunDepts adminFunDepts = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(operator.getCompNo(), operator.getDeptNo());
            sellId = adminFunDepts.getSellId();
        }
        return sellId;
    }
    @ApiOperation("修改个人信息")
    @PostMapping("/updateMyBaisInfo")
    public ResponseJson updateMyBaisInfo(@RequestBody MyBaisInfoParam param) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer archiveId = operator.getArchiveId();
        param.setArchiveId(archiveId);
        param.setCityId(cityId);
        adminFunArchiveService.updateMyBaseInfo(param);
        return ErpResponseJson.ok();
    }

    @ApiOperation(value = "修改用户密码")
    @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
    @ApiResponses(value={
            @ApiResponse(code = 0, message = "")
    })
    @NotBlank({"oldPwd","newPwd","confirmPwd"})
    @PostMapping(value = "/editUserPwd")
    public ResponseJson editUserPwd(@RequestBody EditPasswordParam condition) {
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(getOperator().getCityId(),
                getOperator().getUserId());
        // 验证旧密码是否输入正确
        String oldPwdEnc = EncryptHelper.encryptHftPassword(condition.getOldPwd());
        if (!oldPwdEnc.equals(erpFunUsers.getLoginPassword())) {
            return ErpResponseJson.warn("原密码不对，请重新输入！");
        }
        // 验证新旧密码是否一致
        if (!condition.getNewPwd().equals(condition.getConfirmPwd())) {
            return ErpResponseJson.warn("两次输入的密码不一致，请重新输入！");
        }
        // 直接修改密码
        ErpFunUsers upErpFunUsers = new ErpFunUsers();
        upErpFunUsers.setShardCityId(getOperator().getCityId());
        upErpFunUsers.setCityId(getOperator().getCityId().shortValue());
        upErpFunUsers.setUserId(getOperator().getUserId());
        upErpFunUsers.setLoginPassword(EncryptHelper.encryptHftPassword(condition.getConfirmPwd()));
        erpFunUsersMapper.updateByPrimaryKeySelective(upErpFunUsers);
        return ErpResponseJson.ok();
    }
}
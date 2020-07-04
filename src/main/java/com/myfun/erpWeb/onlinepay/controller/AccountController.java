package com.myfun.erpWeb.onlinepay.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.onlinepay.api.AccountApi;
import com.myfun.erpWeb.onlinepay.param.*;
import com.myfun.erpWeb.onlinepay.vo.*;
import com.myfun.erpWeb.usercenter.UserCenterController;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminMobileKeyMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminMobileKeyExample;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.admindb.po.AdminXwBankAccount;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.admindb.AdminXwBankAccountService;
import com.myfun.utils.Assert;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;

/**
 * @title 在线收款账户模块
 * @author lcb
 * @since 2019/8/24
 * @param 
 * @return
 */
@RestController
public class AccountController extends BaseController implements AccountApi {

    @Autowired
    AdminXwBankAccountService adminXwBankAccountService;
    @Autowired
    UserCenterController userCenterController;
    @Autowired
    AdminMobileKeyService adminMobileKeyService;
    @Autowired
    AdminMobileKeyMapper adminMobileKeyMapper;
    @Autowired
    AdminSysParaMapper adminSysParaMapper;
    /**
     * @title 查询台账开通情况
     * @author lcb
     * @since 2019/8/24
     * @param
     * @return
     */
    @Override
    public ResponseJson checkAccountStatus(@RequestBody CheckAccountStatusParam param) {
        Operator operator = getOperator();
        Integer compId = null == param.getCompId() ? operator.getCompId() : param.getCompId();
        Integer archiveId = null == param.getArchiveId() ? operator.getArchiveId() : param.getArchiveId();
        Integer cityId = null == param.getCityId() ? operator.getCityId() : param.getCityId();

        param.setCompId(compId);
        param.setArchiveId(archiveId);
        param.setCityId(cityId);

        AdminXwBankAccount adminXwBankAccount = adminXwBankAccountService.checkXwBankAccountStatus(param);

        CheckAccountStatusVO checkAccountStatusVO = new CheckAccountStatusVO();
        if(null != adminXwBankAccount) {
            checkAccountStatusVO.setOpenAccountStatus(adminXwBankAccount.getOpenAccountStatus());
            checkAccountStatusVO.setAccountId(adminXwBankAccount.getId());
        }
        return ErpResponseJson.ok(checkAccountStatusVO);
    }

    /**
     * @title 同步文件，调起开户页面
     * @author lcb
     * @since 2019/8/26
     * @param
     * @return
     */
    @Override
    public ResponseJson applyAccount(@Valid @RequestBody ApplyAccountParam param) throws Exception {
        Operator operator = getOperator();

        Assert.isNullThrow(param.getAccountType(), "账户类型必传");

        if(2 == param.getAccountType()) {
            Assert.isNullThrow(param.getEnterpriseLegalFileUrl1(), "身份证文件必传");
            Assert.isNullThrow(param.getEnterpriseLegalFileUrl2(), "身份证文件必传");
            Assert.isNullThrow(param.getEnterpriseUnifiedFileUrl(), "营业执照文件必传");
        }

        Byte accountType = param.getAccountType();
        Integer accountHftIdentification = null;
        if(1 == accountType) {
            accountHftIdentification = operator.getArchiveId();
        }else {
            accountHftIdentification = operator.getCompId();
        }

        param.setAccountHftIdentification(accountHftIdentification);
        param.setCityId(operator.getCityId());
        param.setCompNo(operator.getCompNo());

        ApplyAccountVO applyAccountVO = adminXwBankAccountService.applyAccount(param);
        return ErpResponseJson.ok(applyAccountVO);
    }

    @Override
    public ResponseJson sendOnlineCollectValidateMsg(@Valid @RequestBody OnlineCollectValidateMsgParam param) throws Exception {
        Operator operator = getOperator();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String clientIpAddr = getClientIpAddr(request);
        userCenterController.createMobileKeyAndSend(clientIpAddr, "web", operator.getUserMobile(), operator.getCompNo());
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson requireValidate() throws Exception {
        Operator operator = getOperator();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -30);
        // 查询短信发送记录
        AdminMobileKeyExample adminMobileKeyExample = new AdminMobileKeyExample();
        adminMobileKeyExample.createCriteria().andMobileEqualTo(operator.getUserMobile()).andCreateTimeGreaterThanOrEqualTo(calendar.getTime()).andStatusEqualTo(-1).andWrongTimeLessThanOrEqualTo((byte)3);
        Integer msgCount = adminMobileKeyMapper.countByExample(adminMobileKeyExample);

        ValidateMsgCodeVO validateMsgCodeVO = new ValidateMsgCodeVO();

        validateMsgCodeVO.setRequireValidate(msgCount == 0 ? 1 : 0);
        return ErpResponseJson.ok(validateMsgCodeVO);
    }

    @Override
    public ResponseJson updateXwBankAccountPassword(@Valid @RequestBody XwAccountPasswordParam param) throws Exception {
        Operator operator = getOperator();
        Assert.isNullThrow(param.getAccountId(), "账户类型有误");

        param.setCityId(operator.getCityId());
        XwAccountPasswordVO xwAccountPasswordVO = adminXwBankAccountService.updateXwBankAccountPassword(param);
        return ErpResponseJson.ok(xwAccountPasswordVO);
    }


    @Override
    public ResponseJson updateNotifyStatus(@Valid @RequestBody UpdateNotifyStatusParam param) throws Exception {
        Operator operator = getOperator();

        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        adminXwBankAccountService.updateNotifyStatus(param);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson queryAccountBankInfo(@Valid @RequestBody AccountBankInfoParam param) throws Exception {
        Operator operator = getOperator();
        Assert.isNullThrow(param.getAccountId(), "账户有误");
        param.setCityId(operator.getCityId());
        AccountInfoVO accountBankInfoVO= adminXwBankAccountService.checkAccountBankInfo(param);
        return ErpResponseJson.ok(accountBankInfoVO);
    }

    @Override
    public ResponseJson updateAccountBankInfo(@RequestBody @Valid UpdateAccountBankInfoParam param) throws Exception {
        // 进行数据检测
        Assert.isNullThrow(param.getOpType(), "操作类型有误");

        if(2 == param.getOpType()) {
            Assert.isNullThrow(param.getBindingAccountBankCode(), "参数有误");
            Assert.isNullThrow(param.getBindingAccountBankName(), "参数有误");
        }
        UpdateAccountBankInfoVO updateAccountBankInfoVO = adminXwBankAccountService.updateAccountBankInfo(param);
        return ErpResponseJson.ok(updateAccountBankInfoVO);
    }

    @Override
    public ResponseJson validateMessage(@RequestBody ValidateMessageParam param) throws Exception {
        Operator operator = getOperator();
        param.setCityId(operator.getCityId());
        param.setCompId(operator.getCompId());
        ValidateMessageVO returnVO = adminXwBankAccountService.validateMessage(param);
        return ErpResponseJson.ok(returnVO);
    }
}

package com.myfun.erpWeb.deal.controller;

import com.myfun.erpWeb.deal.param.GetQrcodeWithOwnerIdParam;
import com.myfun.erpWeb.deal.vo.GetQrcodeWithOwnerIdVO;
import com.myfun.erpWeb.house.api.EntrustApi;
import com.myfun.erpWeb.house.param.SendMsgToHouseOwnerParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunEntrustMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustOwnersMapper;
import com.myfun.repository.erpdb.po.ErpFunEntrust;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;
import com.myfun.service.business.erpdb.BestsignService;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.*;

/**
 * @author HuangJiang
 * @since 2019年11月26日 15:11:52
 * Modified XXX HuangJiang 2019年11月26日
 */
@RestController
public class EntrustApiController extends BaseController implements EntrustApi {
    
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private BestsignService bestsignService;
    
    @Override
    public ResponseJson sendMsgToHouseOwner(@RequestBody SendMsgToHouseOwnerParam param) throws Exception {
        if (null == param.getOwnerId()) {
            return ErpResponseJson.warn("请求参数异常");
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunEntrustOwners selectKey = new ErpFunEntrustOwners();
        selectKey.setShardCityId(cityId);
        selectKey.setId(param.getOwnerId());
        ErpFunEntrustOwners erpFunEntrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(selectKey);
        if (null == erpFunEntrustOwners) {
            return ErpResponseJson.warn("未查询到业主记录");
        }
        if (StringUtil.isEmpty(erpFunEntrustOwners.getOwnerPhone())) {
            return ErpResponseJson.warn("业主手机号为空");
        }
        ErpFunEntrust erpFunEntrustKey = new ErpFunEntrust();
        erpFunEntrustKey.setShardCityId(cityId);
        erpFunEntrustKey.setEntrustId(erpFunEntrustOwners.getEntrustId());
        ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(erpFunEntrustKey);
        if (null == erpFunEntrust) {
            return ErpResponseJson.warn("未查询出该业主的委托信息");
        }
        if (StringUtil.isEmpty(erpFunEntrust.getEntrustEnd())) {
            return ErpResponseJson.warn("未查询出该业主的委托截止日期");
        }
        String contractId = erpFunEntrust.getContractId();
        if (StringUtil.isEmpty(contractId)) {
            return ErpResponseJson.warn("未获取到委托合同ID");
        }
        // TODO 调用美联发送短信接口
        this.sendEntrustMsg(cityId, erpFunEntrustOwners.getOwnerPhone(), erpFunEntrust.getEntrustEnd(), contractId, erpFunEntrustOwners.getId());
        return ErpResponseJson.ok();
    }
    
    /**
     * 委托-调用美联接口发送邀请业主签约短信
     * @author HuangJiang
     * @since 2019年12月05日 17:11
     * @param cityId 城市ID 房源的城市ID
     * @param ownerPhone 电话
     * @param entrustEnd 签约截止日期
     * @return void
     * Modified XXX HuangJiang 2019年12月05日
     */
    public static void sendEntrustMsg(Integer cityId, String ownerPhone, String entrustEnd, String contractId, Integer ownerId) {
        if (StringUtil.isNotEmpty(ownerPhone)) {
            String compName = "";
            switch(cityId){
                case 11: // 深圳
                    compName = "美联物业代理（深圳）有限公司";
                    break;
                case 12: // 广州
                    compName = "广州美联港置房地产代理有限公司";
                    break;
                case 208: // 珠海
                    compName = "广州美联港置房地产代理有限公司";
                    break;
                default:
                    compName = "美联物业代理（深圳）有限公司";
                    break;
            }
            String templateId = AppConfig.getProperty("TX_SMS_dzwt_templateId");
            if (StringUtil.isEmpty(templateId)) {
                templateId = "522962";
            }
            String[] params = {compName, entrustEnd, "\"openApi/mlEntrustApi/perRegPage?contractId=" + contractId + "&ownerId=" + ownerId + "&cityId=" + cityId + "\""};
            Map<String, Object> param = new HashMap<>();
            param.put("templateId", templateId);
            param.put("phoneNumber", ownerPhone);
            param.put("params", Arrays.asList(params));
            String url = AppConfig.getProperty("sms_path");
            if (StringUtil.isEmpty(url)) {
                url = "http://transition.staging.midlandmap.cn/sms-api";
            }
            HttpUtil.post(url + "/sms/singleSender", param);
        }
    }
    
    public static void main(String[] args) {
        String contractId = "1234555";
        Integer ownerId = 100;
        Integer cityId = 11;
        String[] params = {"美联物业代理（深圳）有限公司", "2020-03-10", "\"openApi/mlEntrustApi/perRegPage?contractId=" + contractId + "&ownerId=" + ownerId + "&cityId=" + cityId + "\""};
        Map<String, Object> param = new HashMap<>();
        param.put("templateId", 522962);
        param.put("phoneNumber", "15182729709");
        param.put("params", Arrays.asList(params));
        String url = "http://transition.staging.midlandmap.cn/sms-api";
        System.out.println(params);
        System.out.println(param);
        String result = HttpUtil.post(url + "/sms/singleSender", param);
        System.out.println(result);
    }
    
    @Override
    public ResponseJson getQrcodeWithOwnerId(@RequestBody GetQrcodeWithOwnerIdParam param) throws Exception {
        if (null == param.getEntrustId()) {
            return ErpResponseJson.warn("未获取到委托ID");
        }
        if (null == param.getOwnerId()) {
            return ErpResponseJson.warn("未获取到业主ID");
        }
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        ErpFunEntrust selectKey = new ErpFunEntrust();
        selectKey.setShardCityId(cityId);
        selectKey.setEntrustId(param.getEntrustId());
        ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(selectKey);
        if (null == erpFunEntrust) {
            return ErpResponseJson.warn("未获取到委托信息");
        }
        if (null == erpFunEntrust.getElectronicEntrust()) {
            return ErpResponseJson.warn("未获取到该委托的委托类型");
        }
        if (erpFunEntrust.getElectronicEntrust() != 1) {
            return ErpResponseJson.warn("该委托不是电子委托");
        }
        if (null == erpFunEntrust.getElectronicEntrustType()) {
            return ErpResponseJson.warn("未获取到该委托的电子委托书类型");
        }
        
        // 电子委托书类型 1=标准（二维码地址美联提供） ；2=简易（二维码地址我们提供）
        String signAddr = "";
        if (erpFunEntrust.getElectronicEntrustType() == 1) {
            String contractId = erpFunEntrust.getContractId();
            if (StringUtil.isEmpty(contractId)) {
                return ErpResponseJson.warn("未获取到委托合同ID");
            }
            ErpFunEntrustOwners selectOnwerKey = new ErpFunEntrustOwners();
            selectOnwerKey.setShardCityId(cityId);
            selectOnwerKey.setId(param.getOwnerId());
            ErpFunEntrustOwners erpFunEntrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(selectOnwerKey);
            if (null == erpFunEntrustOwners) {
                return ErpResponseJson.warn("未查询到业主记录");
            }
            if (StringUtil.isEmpty(erpFunEntrustOwners.getOwnerPhone())) {
                return ErpResponseJson.warn("业主手机号为空");
            }
            List<ErpFunEntrustOwners> entrustOwnersList = new ArrayList<>();
            entrustOwnersList.add(erpFunEntrustOwners);
            signAddr = AppConfig.getErpWebUrl() + "/openApi/mlEntrustApi/perRegPage?contractId=" + contractId + "&ownerId=" + erpFunEntrustOwners.getId() + "&cityId=" + cityId;
        } else {
            signAddr = AppConfig.getProperty("common.uuhfWebNet.path") + "/B/Home/ZtMeilian/entrustH5?entrustId=" + param.getEntrustId() + "&ownerId=" + param.getOwnerId() + "&cityId=" + cityId;
        }
        GetQrcodeWithOwnerIdVO vo = new GetQrcodeWithOwnerIdVO();
        vo.setEntrustId(param.getEntrustId());
        vo.setOwnerId(param.getOwnerId());
        vo.setSignAddr(signAddr);
        return ErpResponseJson.ok(vo);
    }
    
}

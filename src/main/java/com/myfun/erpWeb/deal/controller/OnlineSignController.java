package com.myfun.erpWeb.deal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.deal.api.OnlineSignApi;
import com.myfun.erpWeb.deal.param.*;
import com.myfun.erpWeb.deal.vo.*;
import com.myfun.erpWeb.managecenter.constract.param.ShareDealParam;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpProcessRuntimeStepDto;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminSsqAccountInfoMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminSsqAccountInfo;
import com.myfun.repository.commdb.dao.CommContractSignSiteMapper;
import com.myfun.repository.commdb.po.CommContractSignSite;
import com.myfun.repository.commdb.po.CommContractSignSiteExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunIndexValueDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.admindb.AdminFunDeptsService;
import com.myfun.service.business.admindb.AdminOnlineService;
import com.myfun.service.business.erpdb.ErpFunContractService;
import com.myfun.service.business.erpdb.ErpFunDealService;
import com.myfun.utils.*;
import com.myfun.utils.rijindael.AESHelper;
import com.myfun.utils.ssq.BestsignOpenApiClient;
import com.myfun.utils.ssq.MailUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.*;

@RestController
public class OnlineSignController extends BaseController implements OnlineSignApi {
    @Resource
    AdminFunCompMapper adminFunCompMapper;
    @Resource
    AdminOnlineService adminOnlineService;
    @Resource
    ErpFunDealMapper erpFunDealMapper;
    @Resource
    AdminSsqAccountInfoMapper adminSsqAccountInfoMapper;
    @Resource
    ErpSsqContractMapper erpSsqContractMapper;
    @Resource
    ErpFunDealService erpFunDealService;
    @Resource
    ErpFunContractMapper erpFunContractMapper;
    @Resource
    ErpFunContractCategoryMapper erpFunContractCategoryMapper;
    @Resource
    ErpFunIndexValueMapper erpFunIndexValueMapper;
    @Resource
    ErpFunUsersMapper erpFunUsersMapper;
    @Resource
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Resource
    ErpProcessRuntimeStepMapper erpProcessRuntimeStepMapper;
    @Resource
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Resource
    AdminFunDeptsService adminFunDeptsService;
    @Resource
    CacheUtil cacheUtil;
    @Resource
    ErpFunContractService erpFunContractService;
    @Resource
    ErpFunCompMapper erpFunCompMapper;
    @Resource
    CommContractSignSiteMapper commContractSignSiteMapper;

    @Override
    public ResponseJson getCompOpenOlineContract() throws Exception {
        Operator operator = getOperator();
        Integer userId = operator.getUserId();
        Integer cityId = operator.getCityId();
        Integer adminCompId = operator.getAdminCompId();
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompId(adminCompId);
        Byte openOnlineContract = adminFunComp.getOpenOnlineContract();
        CompVO companyVo = new CompVO();
        companyVo.setOpenOnlineContract(openOnlineContract == null ? 0 : openOnlineContract);
        String compInfoUrl = AppConfig.getUuHaofang() + "/B/Home/ZtContract/openSign";
        companyVo.setCompInfoWebUrl(compInfoUrl);
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
        String userPosition = erpFunUsers.getUserPosition();
        if ("GENERAL_MANAGER".equals(userPosition)) {
            companyVo.setUserosition("1");
        } else {
            companyVo.setUserosition("0");
        }
        return ErpResponseJson.ok(companyVo);
    }

    @Override
    public ResponseJson openOnlineContract(@Valid @RequestBody AccountInfoParam accountInfoParam) throws Exception {
        Operator operator = getOperator();
        accountInfoParam.setAccount(operator.getAdminCompId().toString());
        accountInfoParam.setUserType(2);
        // 企业验证三要素
        String responseBody = BestsignOpenApiClient.identity3(accountInfoParam.getName(), accountInfoParam.getRegCode(), accountInfoParam.getLegalPerson());
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        if ("0".equals(jsonObject.getJSONObject("data").getString("result"))) {
        	throw new BusinessException(jsonObject.getJSONObject("data").getString("msg"));
        }
        
        // 注册上上签账号
        BestsignOpenApiClient.userEnterpriseReg(accountInfoParam.getAccount(), accountInfoParam.getName(), accountInfoParam.getRegCode()
                , accountInfoParam.getOrgCode(), accountInfoParam.getTaxCode(), accountInfoParam.getLegalPerson(), accountInfoParam.getIdentityCode(), accountInfoParam.getContactMobile());
        // 生成印章
        BestsignOpenApiClient.signatureImageCreate(accountInfoParam.getAccount());
        
        // 发送短信
        responseBody = BestsignOpenApiClient.vcodeSender(accountInfoParam.getAccount(), accountInfoParam.getLegalPerson(), accountInfoParam.getIdentityCode(), accountInfoParam.getContactMobile());
        jsonObject = JSONObject.parseObject(responseBody);
        if ("0".equals(jsonObject.getJSONObject("data").getString("result"))) {
        	throw new BusinessException(jsonObject.getJSONObject("data").getString("msg"));
        }
        String personalIdentity3Key = jsonObject.getJSONObject("data").getString("personalIdentity3Key");
        
        accountInfoParam.setAccount(operator.getAdminCompId().toString());
        adminOnlineService.openOnlineContract(accountInfoParam);
        
        OpenOnlineContractVO openOnlineContractVO = new OpenOnlineContractVO();
        openOnlineContractVO.setPersonalIdentity3Key(personalIdentity3Key);
        
        return ErpResponseJson.ok(openOnlineContractVO);
    }
    
	@Override
	public ResponseJson vcodeVerify(@Valid @RequestBody VcodeVerifyParam param) throws Exception {
		Operator operator = getOperator();
		// 验证短信
		String responseBody = BestsignOpenApiClient.vcodeVerify(param.getVcode(), param.getPersonalIdentity3Key());
		JSONObject jsonObject = JSONObject.parseObject(responseBody);
        if ("0".equals(jsonObject.getJSONObject("data").getString("result"))) {
        	throw new BusinessException(jsonObject.getJSONObject("data").getString("msg"));
        }
        adminOnlineService.updateOnlineContract(operator.getAdminCompId().toString());
        // 获取证书编号
		responseBody = BestsignOpenApiClient.getCert(operator.getAdminCompId().toString());
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			JSONObject dataObj = jsonObj.getJSONObject("data");
			String certId = dataObj.getString("certId");
			adminOnlineService.updateCertId(operator.getAdminCompId().toString(), certId);
		}
		return ErpResponseJson.ok();
	}

    @Override
    public ResponseJson faceVerify(@Valid @RequestBody FaceVerifyParam faceVerifyParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer dealId = faceVerifyParam.getDealId();
        Integer ownerType = faceVerifyParam.getOwnerType();
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(new ErpFunDeal(cityId, dealId));
        String ownerName = null;
        String idCard = null;
        // 判断是买家还是卖家
        if (ownerType == 0) {
            ownerName = erpFunDeal.getSellOwnerName();
            idCard = erpFunDeal.getSellIdCard();
        } else if (ownerType == 1) {
            ownerName = erpFunDeal.getBuyOwnerName();
            idCard = erpFunDeal.getBuyIdCard();
        }
        if (StringUtil.isEmpty(idCard)) {
            throw new BusinessException("身份证必填");
        }
        // 判断是否注册了上上签账户
        AdminSsqAccountInfo adminSsqAccountInfo = adminSsqAccountInfoMapper.selectByPrimaryKey(idCard);
        if (adminSsqAccountInfo == null) {
            // 注册个人用户
            BestsignOpenApiClient.userPersonalReg(idCard, ownerName, idCard);
            // 生成印章
            BestsignOpenApiClient.signatureImageCreate(idCard);
            // 写入数据库
            AdminSsqAccountInfo ssqAccountInfo = new AdminSsqAccountInfo();
            ssqAccountInfo.setAccount(idCard);
            ssqAccountInfo.setName(ownerName);
            ssqAccountInfo.setUserType(1);
            ssqAccountInfo.setIdentityCode(idCard);
            ssqAccountInfo.setCreateTime(new Date());
            adminSsqAccountInfoMapper.insertSelective(ssqAccountInfo);
            
            // 获取证书编号
    		String responseBody = BestsignOpenApiClient.getCert(idCard);
    		JSONObject jsonObj = JSON.parseObject(responseBody);
    		// 返回errno为0，表示成功，其他表示失败
    		if (jsonObj.getIntValue("errno") == 0) {
    			JSONObject dataObj = jsonObj.getJSONObject("data");
    			String certId = dataObj.getString("certId");
    			adminOnlineService.updateCertId(idCard, certId);
    		}
        }


        // 查询是否已经生成了合同，如果没生成就要先生成
        ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
        erpSsqContractExample.setShardCityId(cityId);
        erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo(Byte.valueOf("0"));
        List<ErpSsqContract> ssqContractList = erpSsqContractMapper.selectByExample(erpSsqContractExample);
        if (ssqContractList.isEmpty()) {
            Object obj = cacheUtil.get("ssq_contract_" + cityId + "_" + erpFunDeal.getContractId());
            if (obj != null) {
                throw new BusinessException("请不要重复提交");
            }
            cacheUtil.put("ssq_contract_" + cityId + "_" + erpFunDeal.getContractId(), "1", 5);
            // 请求网站接口返回合同的相关信息
//          String result = "{\"data\":{\"page\":\"1\",\"pdfAddr\":\"oss/online/nihao/2019/08/16/60c785e492174daeab3c9f3dd2a01d47.pdf\",\"partyAInfo\":{\"signX\":\"0.5\",\"signY\":\"0.5\",\"dateX\":\"0.6\",\"dateY\":\"0.5\",\"pageNum\":\"1\"},\"partyBInfo\":{\"signX\":\"0.5\",\"signY\":\"0.6\",\"dateX\":\"0.6\",\"dateY\":\"0.6\",\"pageNum\":\"1\"},\"partyCInfo\":{\"signX\":\"0.7\",\"signY\":\"0.7\",\"pageNum\":\"1\"}}}";
            CommContractSignSiteExample commContractSignSiteExample = new CommContractSignSiteExample();
            commContractSignSiteExample.createCriteria().andCityIdEqualTo(cityId).andDealIdEqualTo(dealId);
            List<CommContractSignSite> contractSignSiteList = commContractSignSiteMapper.selectByExample(commContractSignSiteExample);
            if (contractSignSiteList.isEmpty()) {
                throw new BusinessException("合同生成失败");
            }
            CommContractSignSite commContractSignSite = contractSignSiteList.get(0);
            PdfInfoVO pdfInfoVO = new PdfInfoVO();
            PdfInfoVO.PartyInfo partyAInfo = new PdfInfoVO.PartyInfo();
            PdfInfoVO.PartyInfo partyBInfo = new PdfInfoVO.PartyInfo();
            PdfInfoVO.PartyInfo partyCInfo = new PdfInfoVO.PartyInfo();
            Integer pages = commContractSignSite.getPage().intValue();
            String pdfAddr = AppConfig.getHousePicDomainPath(commContractSignSite.getPdfPath());
            String partyAInfoArr[] = commContractSignSite.getPartyAInfo().split(",");
            String partyADateArr[] = commContractSignSite.getPartyADate().split(",");
            String partyBInfoArr[] = commContractSignSite.getPartyBInfo().split(",");
            String partyBDateArr[] = commContractSignSite.getPartyBDate().split(",");
            String partyCInfoArr[] = commContractSignSite.getPartyCInfo().split(",");
            partyAInfo.setSignX(partyAInfoArr[0]);
            partyAInfo.setSignY(partyAInfoArr[1]);
            partyAInfo.setPageNum(partyAInfoArr[2]);
            partyAInfo.setDateX(partyADateArr[0]);
            partyAInfo.setDateY(partyADateArr[1]);
            partyBInfo.setSignX(partyBInfoArr[0]);
            partyBInfo.setSignY(partyBInfoArr[1]);
            partyBInfo.setPageNum(partyBInfoArr[2]);
            partyBInfo.setDateX(partyBDateArr[0]);
            partyBInfo.setDateY(partyBDateArr[1]);
            partyCInfo.setSignX(partyCInfoArr[0]);
            partyCInfo.setSignY(partyCInfoArr[1]);
            partyCInfo.setPageNum(partyCInfoArr[2]);
            pdfInfoVO.setPage(pages);
            pdfInfoVO.setPdfAddr(commContractSignSite.getPdfPath());
            pdfInfoVO.setPartyAInfo(partyAInfo);
            pdfInfoVO.setPartyBInfo(partyBInfo);
            pdfInfoVO.setPartyCInfo(partyCInfo);

            byte[] bdata = FileUtil.getFileByte(pdfAddr);
            String fname = pdfAddr.substring(pdfAddr.lastIndexOf(".") + 1, pdfAddr.length());
            String fpages = "1";
            String fmd5 = DigestUtils.md5Hex(bdata);
            String fdata = Base64.encodeBase64String(bdata);
            String title = "电子合同在线签约";
            String description = "电子合同在线签约";
            String responseBody = BestsignOpenApiClient.contractUpload(operator.getAdminCompId().toString(), fmd5, fname, fpages, fdata, description, title);
            JSONObject jsonObj = JSON.parseObject(responseBody);
            if (jsonObj.getIntValue("errno") != 0) {
                throw new BusinessException("生成合同失败" + jsonObj.getString("errmsg"));
            }
            //插入合同
            String contractId = jsonObj.getJSONObject("data").getString("contractId");
            // 合同盖章
            BestsignOpenApiClient.cert(contractId, operator.getAdminCompId().toString(), partyCInfo.getPageNum(), partyCInfo.getSignX(), partyCInfo.getSignY());

            ErpSsqContract erpSsqContract = new ErpSsqContract();
            erpSsqContract.setShardCityId(cityId);
            erpSsqContract.setSsqContractId(contractId);
            erpSsqContract.setAccount(operator.getAdminCompId().toString());
            erpSsqContract.setContractStatus(0);
            erpSsqContract.setCreateTime(new Date());
            erpSsqContract.setDealId(dealId);
            erpSsqContract.setFmd5(fmd5);
            erpSsqContract.setInitContractPdf(pdfInfoVO.getPdfAddr());
            erpSsqContract.setIsDel(Byte.valueOf("0"));
            erpSsqContract.setPages(pages);
            erpSsqContract.setPartyAComplete(Byte.valueOf("0"));
            erpSsqContract.setPartyBComplete(Byte.valueOf("0"));
            erpSsqContract.setPartyAInfo(JSONObject.toJSONString(pdfInfoVO.getPartyAInfo()));
            erpSsqContract.setPartyBInfo(JSONObject.toJSONString(pdfInfoVO.getPartyBInfo()));
            erpSsqContract.setPartyCInfo(JSONObject.toJSONString(pdfInfoVO.getPartyCInfo()));
            ErpFunDeal newFunDeal = new ErpFunDeal();
            newFunDeal.setShardCityId(cityId);
            newFunDeal.setDealId(dealId);
            newFunDeal.setSsqContractId(contractId);
            erpFunDealService.createSsqContract(erpSsqContract, newFunDeal);
        }

        // 随机数，请求订单
        String orderNo = System.currentTimeMillis() + "";
        // 刷脸
        String responseBody = BestsignOpenApiClient.idcardFaceVerify(idCard, orderNo);
        JSONObject jsonObj = JSON.parseObject(responseBody);
        if (jsonObj.getIntValue("errno") != 0) {
            throw new BusinessException("刷脸认证签名失败" + jsonObj.getString("errmsg"));
        }
        JSONObject jsonObject = jsonObj.getJSONObject("data");
        String webankUserId = jsonObject.getString("webankUserId"); //用户的唯一标识
        String randomStr = jsonObject.getString("randomStr"); //32位随机字符串
        String faceAuthSign = jsonObject.getString("faceAuthSign"); //url编码后的刷脸认证签名

        Object obj = cacheUtil.get("ssq_cache_api_ticket");
        if (obj == null) {
            // 返回格式  {"code":"0","msg":"请求成功","bizSeqNo":"19080820001015300711290717810015","transactionTime":"20190808112907","success":true,"access_token":"WAA0f-dGGlQHTVClazkxtmW6FX_nRhpUB01QpWs5MbZluhVvQPq6lFyK3jzvA9dnLnKYZ_ZrqSyxgkqcBTyTTJ4goA","expire_in":7200,"expire_time":"20190808132907"}
            String str = HttpUtil.get("https://idasc.webank.com/api/oauth2/access_token?app_id=" + BestsignOpenApiClient.appId + "&secret=" + BestsignOpenApiClient.secret + "&grant_type=client_credential&version=1.0.0", null);
            jsonObject = JSONObject.parseObject(str);
            if (!"0".equals(jsonObject.getString("code"))) {
                throw new BusinessException("刷脸失败," + jsonObject.getString("msg"));
            }
            String accessToken = jsonObject.getString("access_token");
            //返回格式 {"code":"0","msg":"请求成功","bizSeqNo":"19080820001015300213502918008331","result":{"bizSeqNo":"19080820001015300213502918008331","transactionTime":"20190808135029","orderNo":"d392946c7e139d206b6f78f91bc50205","faceId":"287893c8238f9c59263c69230cbac003","success":false},"transactionTime":"20190808135029"}
            str = HttpUtil.get("https://idasc.webank.com/api/oauth2/api_ticket?app_id=" + BestsignOpenApiClient.appId + "&access_token=" + accessToken + "&type=NONCE&version=1.0.0", null);
            jsonObject = JSONObject.parseObject(str);
            if (!"0".equals(jsonObject.getString("code"))) {
                throw new BusinessException("刷脸认证失败," + jsonObject.getString("msg"));
            }
            cacheUtil.put("ssq_cache_api_ticket", "1", 3600);
        }

        Map<String, String> map = new HashMap<>();
        map.put("webankAppId", BestsignOpenApiClient.appId);
        map.put("orderNo", orderNo);
        map.put("name", ownerName);
        map.put("idNo", idCard);
        map.put("userId", webankUserId);
        map.put("sourcePhotoType", "2");
        map.put("version", "1.0.0");
        map.put("sign", faceAuthSign);
        String str = HttpUtil.postJson("https://idasc.webank.com/api/server/getfaceid", map);

        jsonObject = JSONObject.parseObject(str).getJSONObject("result");
        String code = JSONObject.parseObject(str).getString("code");
        if (!"0".equals(code)) {
            throw new BusinessException(JSONObject.parseObject(str).getString("msg"));
        }
        String faceId = jsonObject.getString("faceId");
        FaceVerifyVO faceVerifyVO = new FaceVerifyVO();
        faceVerifyVO.setFaceAuthSign(faceAuthSign);
        faceVerifyVO.setFaceId(faceId);
        faceVerifyVO.setOrderNo(orderNo);
        faceVerifyVO.setRandomStr(randomStr);
        faceVerifyVO.setWebankUserid(webankUserId);
        faceVerifyVO.setAppId(BestsignOpenApiClient.appId);
        return ErpResponseJson.ok(faceVerifyVO);
    }

    @Override
    public ResponseJson faceVerifyResult(@Valid @RequestBody FaceVerifyResultParam faceVerifyResultParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer dealId = faceVerifyResultParam.getDealId();
        Integer ownerType = faceVerifyResultParam.getOwnerType();
        String orderNo = faceVerifyResultParam.getOrderNo();
        String responseBody = BestsignOpenApiClient.getFaceAuthResult(orderNo);
        JSONObject jsonObject = JSONObject.parseObject(responseBody);
        if (!"0".equals(jsonObject.getString("errno"))) {
            throw new BusinessException("刷脸验证失败");
        }

        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(new ErpFunDeal(cityId, dealId));
        ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
        erpSsqContractExample.setShardCityId(cityId);
        erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo(Byte.valueOf("0"));
        List<ErpSsqContract> ssqContractList = erpSsqContractMapper.selectByExample(erpSsqContractExample);
        if (ssqContractList.isEmpty()) {
            throw new BusinessException("合同出错");
        }
        ErpSsqContract erpSsqContract = ssqContractList.get(0);
        String idCard = null;
        JSONObject partyInfoObj = null;
        if (ownerType == 0) {
            idCard = erpFunDeal.getSellIdCard();
            partyInfoObj = JSONObject.parseObject(erpSsqContract.getPartyAInfo());
        } else if (ownerType == 1) {
            idCard = erpFunDeal.getBuyIdCard();
            partyInfoObj = JSONObject.parseObject(erpSsqContract.getPartyBInfo());
        }
        String pushUrl = AppConfig.getErpWebUrl() + "/openApi/onlineSign/notifySignResult?cityId=" + cityId + "&dealId=" + dealId + "&ownerType=" + ownerType + "&token=" + AESHelper.encode(dealId + "");
        String returnUrl = "";
        responseBody = BestsignOpenApiClient.send(idCard, erpSsqContract.getSsqContractId(), partyInfoObj.getString("pageNum"), partyInfoObj.getString("signX"), partyInfoObj.getString("signY"), partyInfoObj.getString("dateX"), partyInfoObj.getString("dateY"), pushUrl, returnUrl);
        jsonObject = JSONObject.parseObject(responseBody);
        if (!"0".equals(jsonObject.getString("errno"))) {
            throw new BusinessException("刷脸认证失败" + jsonObject.getString("errmsg"));
        }
        String url = jsonObject.getJSONObject("data").getString("url");
        SsqSignVO ssqSignVO = new SsqSignVO();
        ssqSignVO.setSignUrl(url);
        return ErpResponseJson.ok(ssqSignVO);
    }

    @Override
    public ResponseJson notifySignResult(@Valid NotifySignResultParam notifySignResultParam) throws Exception {
        Integer cityId = notifySignResultParam.getCityId();
        Integer dealId = notifySignResultParam.getDealId();
        Integer ownerType = notifySignResultParam.getOwnerType();
        String token = notifySignResultParam.getToken();
        Integer tokenDealId = Integer.parseInt(AESHelper.decode(token));
        // 如果验证不通过的话
        if (!dealId.equals(tokenDealId)) {
            return ErpResponseJson.ok();
        }
        ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
        erpSsqContractExample.setShardCityId(cityId);
        erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo(Byte.valueOf("0"));
        List<ErpSsqContract> ssqContractList = erpSsqContractMapper.selectByExample(erpSsqContractExample);
        if (ssqContractList.isEmpty()) {
            return ErpResponseJson.ok();
        }
        ErpSsqContract erpSsqContract = ssqContractList.get(0);
        if (ownerType == 0) {
            erpSsqContract.setPartyAComplete(Byte.valueOf("1"));
            if (Byte.valueOf("1").equals(erpSsqContract.getPartyBComplete())) {
                erpSsqContract.setContractStatus(1);
            }
        } else if (ownerType == 1) {
            erpSsqContract.setPartyBComplete(Byte.valueOf("1"));
            if (Byte.valueOf("1").equals(erpSsqContract.getPartyAComplete())) {
                erpSsqContract.setContractStatus(1);
            }
        }
        // 如果双方都签订了就锁定合同签约就完成了
        if (Byte.valueOf("1").equals(erpSsqContract.getPartyAComplete()) && Byte.valueOf("1").equals(erpSsqContract.getPartyBComplete())) {
            String responseBody = BestsignOpenApiClient.lock(erpSsqContract.getSsqContractId());
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            if (!"0".equals(jsonObject.getString("errno"))) {
                //throw new BusinessException("合同锁定失败");
            }
            // 下载合同
            byte[] file = BestsignOpenApiClient.contractDownload(erpSsqContract.getSsqContractId());
            String completeContractPdf = FileUtil.commonUploadOneFile("pdf", file, "0");
            erpSsqContract.setCompleteContractPdf(completeContractPdf);
            erpSsqContract.setCompleteTime(new Date());
            ErpFunDeal erpFunDeal = new ErpFunDeal(cityId, dealId);
            erpFunDeal.setSignType(Byte.valueOf("1"));
            erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);
        } else {
            // 下载合同
            byte[] file = BestsignOpenApiClient.contractDownload(erpSsqContract.getSsqContractId());
            String initContractPdf = FileUtil.commonUploadOneFile("pdf", file, "0");
            erpSsqContract.setInitContractPdf(initContractPdf);
            erpSsqContract.setCompleteTime(new Date());
        }
        erpSsqContract.setShardCityId(cityId);
        erpSsqContractMapper.updateByPrimaryKeySelective(erpSsqContract);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson getContractDetails(@RequestBody ContractDetailsParam contractDetailsParam) throws Exception {
        ContractDetailsVO contractDetailsVo = new ContractDetailsVO();
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer dealId = contractDetailsParam.getDealId();
        ErpFunDeal erpFunDealexample = new ErpFunDeal();
        erpFunDealexample.setDealId(dealId);
        erpFunDealexample.setShardCityId(cityId);
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDealexample);
        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在");
        }
        String ssqContractId = erpFunDeal.getSsqContractId();
        Integer userId = erpFunDeal.getSignUserId();
        if (StringUtil.isEmpty(userId.toString())) {
            throw new BusinessException("数据出错，签约人不存在");
        }
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
        Integer archiveId = erpFunUsers.getArchiveId();
        if (StringUtil.isEmpty(ssqContractId)) {
            contractDetailsVo.setSignStatus((byte) 0);//签约状态 0,未签约 1 已经签约
        } else {
            ErpSsqContract condition = new ErpSsqContract();
            condition.setSsqContractId(ssqContractId);
            condition.setShardCityId(cityId);
            ErpSsqContract erpSsqContract1 = erpSsqContractMapper.selectByPrimaryKey(condition);
            if (erpSsqContract1 == null) {
                throw new Exception("数据出错，fun_Deal表有ssqId，但是没有ssq这条数数据");
            }
            Integer contractStatus = erpSsqContract1.getContractStatus();
            if (contractStatus == null) {
                contractDetailsVo.setSignStatus((byte) 0);//签约状态 0,未签约 1 已经签约
            } else {
                contractDetailsVo.setSignStatus(contractStatus.byteValue());
            }
            if (erpSsqContract1.getContractStatus() == 1) { // 已经完成
                contractDetailsVo.setFileUrl(AppConfig.getHousePicDomainPath(erpSsqContract1.getCompleteContractPdf()));
            } else {
                contractDetailsVo.setFileUrl(AppConfig.getHousePicDomainPath(erpSsqContract1.getInitContractPdf()));
            }
            contractDetailsVo.setPartyAComplete(erpSsqContract1.getPartyAComplete());
            contractDetailsVo.setPartyBComplete(erpSsqContract1.getPartyBComplete());
        }
        Integer contractId = erpFunDeal.getContractId();
        if (contractId != null) {
            ErpFunContract contract = new ErpFunContract();
            contract.setShardCityId(cityId);
            contract.setContractId(contractId);
            ErpFunContract contract1 = erpFunContractMapper.selectByPrimaryKey(contract);
            contractDetailsVo.setAuditStatus(erpFunDeal.getDealAuditStatus());// 审核状态
            contractDetailsVo.setContractTemplateContent(contract1.getContractContent());// 合同模板内容
            contractDetailsVo.setLogoPosition(contract1.getLogoPosition());// logo位置
            Integer adminCompId = operator.getAdminCompId();
            AdminFunComp adminFunComp = adminFunCompMapper.selectByCompId(adminCompId);
            Byte openOnlineContract = adminFunComp.getOpenOnlineContract();
            if (openOnlineContract == null) {
                openOnlineContract = (byte) 0;
            }
            contractDetailsVo.setIsOpenOnlineSign(openOnlineContract);// 是否开通在线签约
            // 设置签约类型，线下 0 ，线上1
            Byte signType1 = erpFunDeal.getSignType();
            if (signType1 == null) {
                Integer categoryId = erpFunDeal.getCategoryId();
                ErpFunContractCategory erpFunContractCategory = new ErpFunContractCategory();
                erpFunContractCategory.setCategoryId(categoryId);
                erpFunContractCategory.setShardCityId(cityId);
                ErpFunContractCategory erpFunContractCategory1 = erpFunContractCategoryMapper.selectByPrimaryKey(erpFunContractCategory);
                if (erpFunContractCategory1 != null) {
                    Byte signType = erpFunContractCategory1.getSignType();
                    contractDetailsVo.setCompOpenOlineContract(signType);// 签约配置
                } else {
                    contractDetailsVo.setCompOpenOlineContract((byte) 0);// 签约配置
                }
            } else {
                contractDetailsVo.setCompOpenOlineContract(signType1);
            }
            ArrayList<Integer> contractIds = new ArrayList<>();
            contractIds.add(contractId);
            List<ErpFunIndexValueDto> indexValueList = erpFunIndexValueMapper.getIndexValueList(operator.getCityId(), contractIds, null);
            contractDetailsVo.setIndexList(indexValueList);//合同模板数据
        }

//
        String appletUrl = "packageShare/pages/contractInfo/contractInfo?cityId=" + cityId + "&userId=" + userId + "&dealId=" + dealId + "&archiveId=" + archiveId + "&erpCompId=" + compId;
        contractDetailsVo.setUrl(appletUrl);//路径
        contractDetailsVo.setImage(AppConfig.getErpWebUrl() + "statics/images/ssq/ssq.png");// 图片
//        String appIdByVersion = adminFunDeptsService.getAppIdByVersion(operator.getArchiveId());// 登录人的archiveId
        contractDetailsVo.setAppletId("gh_06dda4d2e2c1");// 小程序ID
        contractDetailsVo.setDocument("您的合同已创建，点击即可查看办理进度");// 文案
        return ErpResponseJson.ok(contractDetailsVo);
    }

    /**
     * @param appletContractDetailsParam
     * @return
     * @throws Exception 小程序返回合同详情，
     */

    @Override
    public ResponseJson getAppletContractDetails(@RequestBody AppletContractDetailsParam appletContractDetailsParam) throws Exception {
        AppletContractDetailsVO vo = new AppletContractDetailsVO();
        Integer dealId = appletContractDetailsParam.getDealId();
        Integer cityId = appletContractDetailsParam.getCityId();
        Integer userId = appletContractDetailsParam.getUserId();
        ErpFunDeal erpFunDealCondition = new ErpFunDeal();
        erpFunDealCondition.setShardCityId(cityId);
        erpFunDealCondition.setDealId(dealId);
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(erpFunDealCondition);
        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在");
        }
        // 设置 经纪人信息
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
        if (erpFunUsers == null) {
            throw new BusinessException("用户不存在");
        }
        Integer archiveId = erpFunUsers.getArchiveId();
        vo.setArchiveId(archiveId);
        vo.setUserId(userId);
        vo.setUserName(erpFunUsers.getUserName());
        vo.setCityId(cityId);
        Integer deptId = erpFunUsers.getDeptId();
        ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, deptId);
        vo.setUserDeptName(byDeptId.getDeptName());
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        vo.setUserImageUrl(AppConfig.getHousePicDomainPath(adminFunArchive.getUserPhoto()));
        vo.setUserTel(erpFunUsers.getUserMobile());
        // 设置合同模板

        String ssqContractId = erpFunDeal.getSsqContractId();
        if (StringUtil.isEmpty(ssqContractId)) {
            Integer contractId = erpFunDeal.getContractId();
            ErpFunContract contractCondition = new ErpFunContract();
            contractCondition.setShardCityId(cityId);
            contractCondition.setContractId(contractId);
            ErpFunContract contract = erpFunContractMapper.selectByPrimaryKey(contractCondition);
            if (contract == null) {
                throw new BusinessException("合同文本数据不存在");
            }
            String contractContent = contract.getContractContent();
            vo.setContractTemplateContent(contractContent);
            // 设置合同数据
            ArrayList<Integer> contractIds = new ArrayList<>();
            contractIds.add(contractId);
            List<ErpFunIndexValueDto> indexValueList = erpFunIndexValueMapper.getIndexValueList(cityId, contractIds, null);
            vo.setIndexList(indexValueList);
            vo.setCityId(cityId);
        } else {
            ErpSsqContract condition = new ErpSsqContract();
            condition.setShardCityId(cityId);
            condition.setSsqContractId(ssqContractId);
            ErpSsqContract erpSsqContract = erpSsqContractMapper.selectByPrimaryKey(condition);
            Integer contractStatus = erpSsqContract.getContractStatus();
            if (contractStatus.equals(0)) {// 未完成
                vo.setPdfUrl(AppConfig.getHousePicDomainPath(erpSsqContract.getInitContractPdf()));
            }
            if (contractStatus.equals(1)) {// 已经完成
                vo.setPdfUrl(AppConfig.getHousePicDomainPath(erpSsqContract.getCompleteContractPdf()));
            }

        }
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson getAppletWarrantStepList(@RequestBody AppletWarrantStepParam appletWarrantStepParam) throws Exception {
        Integer cityId = appletWarrantStepParam.getCityId();
        Integer compId = appletWarrantStepParam.getCompId();
        Integer dealId = appletWarrantStepParam.getDealId();
        Integer userId = appletWarrantStepParam.getUserId();
        List<ErpProcessRuntimeStepDto> runtimeStepDtoList = erpProcessRuntimeStepMapper.getMgrWarrantStepList(cityId, compId, dealId);
        AppletWarrantStepAppletWarrantStepVO vo = new AppletWarrantStepAppletWarrantStepVO();
        vo.setStepList(runtimeStepDtoList);
        // 设置经纪人信息
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
        if (erpFunUsers == null) {
            throw new BusinessException("经纪人不存在");
        }
        ErpFunDeal condition = new ErpFunDeal();
        condition.setDealId(dealId);
        condition.setShardCityId(cityId);
        condition.setCompId(compId);
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(condition);
        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在");
        }
        vo.setBuildName(erpFunDeal.getBuildName());
        vo.setArea(erpFunDeal.getArea());
        vo.setDealType(erpFunDeal.getDealType() + "");
        if ("101".equals(erpFunDeal.getDealType() + "")) { //出售： 101   出租 102
            vo.setSellDealMoney(erpFunDeal.getSellDealMoney());
        }
        if ("102".equals(erpFunDeal.getDealType() + "")) {
            vo.setSellDealMoney(erpFunDeal.getRentDealMoney());
        }

        vo.setBuyOwnerName(erpFunDeal.getBuyOwnerName());
        vo.setSellOwnerName(erpFunDeal.getSellOwnerName());
        vo.setHouseAdress(erpFunDeal.getSellAddress());
        vo.setDealAuditStatus(erpFunDeal.getDealAuditStatus());
        vo.setCompleteTime(erpFunDeal.getSignDate());
        String ssqContractId = erpFunDeal.getSsqContractId();
        ErpSsqContract conditon = new ErpSsqContract();
        conditon.setSsqContractId(ssqContractId);
        conditon.setShardCityId(cityId);
        ErpSsqContract erpSsqContract = erpSsqContractMapper.selectByPrimaryKey(conditon);
        if (erpSsqContract != null) {
            vo.setContractStatus(erpSsqContract.getContractStatus());
        } else {
            vo.setContractStatus(0);
        }
        // 合同类别
        ErpFunContractCategory contractCategorycondition = new ErpFunContractCategory();
        contractCategorycondition.setShardCityId(cityId);
        contractCategorycondition.setCategoryId(erpFunDeal.getCategoryId());
        ErpFunContractCategory contractCategory = erpFunContractCategoryMapper.selectByPrimaryKey(contractCategorycondition);
        if (contractCategory != null) {// 有的合同没有合同类别
            vo.setSignType(contractCategory.getSignType());
        }

        Integer archiveId = erpFunUsers.getArchiveId();
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
        vo.setUserId(userId);
        vo.setArchiveId(archiveId);
        vo.setUserName(erpFunUsers.getUserName());
        Integer deptId = erpFunUsers.getDeptId();
        ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, deptId);
        vo.setUserDeptName(byDeptId.getDeptName());
        vo.setUserImageUrl(AppConfig.getHousePicDomainPath(adminFunArchive.getUserPhoto()));
        vo.setUserTel(erpFunUsers.getUserMobile());
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson sendEmail(@RequestBody SendEmailParam sendEmailParam) throws Exception {
        String telNum = sendEmailParam.getTelNum();
        if (StringUtil.isEmpty(telNum)) {
            throw new Exception("电话号码为空，不能查看合同");
        }
        String hostName = "smtp.qiye.aliyun.com";
        String emailName = "noreply@haofang.net";
        String passWord = "Hft@123456";
        Integer dealId = sendEmailParam.getDealId();
        String emailAddress = sendEmailParam.getEmailAddress();
        Integer cityId = sendEmailParam.getCityId();
        ErpFunDeal idcondition = new ErpFunDeal();
        idcondition.setDealId(dealId);
        idcondition.setShardCityId(cityId);
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(idcondition);
        if (erpFunDeal == null) {
            throw new BusinessException("合同不存在");
        }
        if (erpFunDeal.getContractId() == null) {
            throw new BusinessException("合同文本不存在");
        }
        // 验证电话号码
        String buyCustomerPhone = erpFunDeal.getBuyCustomerPhone();
        String sellOwnerPhone = erpFunDeal.getSellOwnerPhone();
        String buyphoneNum = "";
        String sellphoneNum = "";
        if (!StringUtil.isEmpty(buyCustomerPhone)) {
            String[] num = buyCustomerPhone.split(":");
            buyphoneNum = num[1];
        }
        if (!StringUtil.isEmpty(sellOwnerPhone)) {
            String[] num = sellOwnerPhone.split(":");
            sellphoneNum = num[1];
        }
        if (!telNum.equals(buyphoneNum) && !telNum.equals(sellphoneNum)) {
            throw new BusinessException("电话号码与合同的买卖的任意一方都不匹配");
        }
        String buildName = erpFunDeal.getBuildName();
        Integer signUserId = erpFunDeal.getSignUserId();
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, signUserId);
        Integer compId = erpFunUsers.getCompId();
        ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
        String compName = erpFunComp.getCompName();
        String compTele = erpFunComp.getCompTele();
        Byte dealType = erpFunDeal.getDealType();
        String dealTypeStr = "";
        if (dealType == 101) {
            dealTypeStr = "卖买";
        } else {
            dealTypeStr = "租赁";
        }
        String title = compName + "房屋" + dealTypeStr + "合同";
        String content = "尊敬的用户：\n" +
                "感谢您选择" + compName + "的服务,为了充分保障双方的合法权益，在签署合同前，您已仔细阅读过全部合同条款并予以理解和接受，同时我们的工作人员已向您告知与房屋及合同签署相关的信息。\n" +
                "我们现将合同以电子文件附件形式发送至您的邮箱，请妥善保管。\n" +
                "\n" +
                "如您在居住过程中有任何需求，可联系为您服务的经纪人或拨打以下电话进行联系：\n" +
                "\n" +
                "电话：" + compTele + "\n" +
                "\n" +
                "\n" +
                "----------------------" + compName;
        String fileName = buildName + "房屋" + dealTypeStr + "合同.pdf";
        String pdfUrl = "";
        String ssqContractId = erpFunDeal.getSsqContractId();

        ErpSsqContract condition = new ErpSsqContract();
        condition.setShardCityId(cityId);
        condition.setSsqContractId(ssqContractId);
        ErpSsqContract erpSsqContract = erpSsqContractMapper.selectByPrimaryKey(condition);
        if (erpSsqContract == null) {
            throw new BusinessException("没有生产上上签合同，不存在pdf");
//            String result = HttpUtil.get(AppConfig.getProperty("common.path.public") + "api/Pdf/htmlToPdf?cityId=" + cityId + "&dealId=" + dealId, null);
//            PdfInfoVO pdfInfoVO = JSON.parseObject(JSONObject.parseObject(result).getJSONObject("data").toJSONString() , new TypeReference<PdfInfoVO>() {});
//            pdfUrl = AppConfig.getHousePicDomainPath(pdfInfoVO.getPdfAddr());
        } else {
            Integer contractStatus = erpSsqContract.getContractStatus();
            if (contractStatus == 1) {
                pdfUrl = AppConfig.getHousePicDomainPath(erpSsqContract.getCompleteContractPdf());
            }
            if (contractStatus == 0) {
                pdfUrl = AppConfig.getHousePicDomainPath(erpSsqContract.getInitContractPdf());
            }
        }
        MailUtil.sendEmailsWithOnlineAttachments(hostName, emailName, compName, passWord, emailAddress, title, content, pdfUrl, 465, fileName);
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson verifyTelphoneNum(@RequestBody VerifyTelphoneNumParam verifyTelphoneNumParam) throws Exception {
        VerifyTelphoneNumVO vo = new VerifyTelphoneNumVO();
        vo.setSuccess(false);
        Integer dealid = verifyTelphoneNumParam.getDealId();
        Integer cityId = verifyTelphoneNumParam.getCityId();
        String telPhoneNum = verifyTelphoneNumParam.getTelPhoneNum();
        ErpFunDeal erpFunDeal = erpFunDealMapper.selectByDealId(cityId, dealid, new String[]{"BUY_CUSTOMER_PHONE", "SELL_OWNER_PHONE"});
        String buyCustomerPhone = erpFunDeal.getBuyCustomerPhone();
        String sellOwnerPhone = erpFunDeal.getSellOwnerPhone();
        if (buyCustomerPhone != null) {
            String[] num = buyCustomerPhone.split(":");
            String phoneNum = num[1];
            if (phoneNum.equals(telPhoneNum)) {
                vo.setSuccess(true);
            }
        }
        if (sellOwnerPhone != null) {
            String[] num = sellOwnerPhone.split(":");
            String phoneNum = num[1];
            if (phoneNum.equals(telPhoneNum)) {
                vo.setSuccess(true);
            }
        }
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson shareDeal(@RequestBody @Valid ShareDealParam param) {
        ShareDealVo shareDealVo = erpFunContractService.shareDeal(param);
        return ErpResponseJson.ok(shareDealVo);
    }

    @Override
    public ResponseJson savePdfPosition(@RequestBody @Valid PdfInfoParam param) throws Exception {
        String pdfPath = param.getPdfPath();
        String pdfOssPath = param.getPdfOssPath();
        String signAdress = param.getSignAdress().replaceAll(" ", "").trim();
        String signPartyA = param.getSignPartyA().replaceAll(" ", "").trim();
        String signPartyB = param.getSignPartyB().replaceAll(" ", "").trim();
        String signPartyADate = param.getSignPartyADate().replaceAll(" ", "").trim();
        String signPartyBDate = param.getSignPartyBDate().replaceAll(" ", "").trim();
        Integer dealId = param.getDealId();
        Integer cityId = param.getCityId();
        CommContractSignSiteExample example = new CommContractSignSiteExample();
        example.createCriteria().andDealIdEqualTo(dealId).andCityIdEqualTo(cityId);
        List<CommContractSignSite> commContractSignSites = commContractSignSiteMapper.selectByExample(example);
        if (StringUtil.isEmpty(pdfPath)) {
            if (commContractSignSites.size() > 0) {
                String pdfPath1 = commContractSignSites.get(0).getPdfPath();
                if (StringUtil.isEmpty(pdfPath1)) {
                    return ErpResponseJson.ok();
                }
                pdfPath = "http://img01-uat.m1200.com.cn/" + pdfPath1;
                pdfOssPath = pdfPath1;
            }
        }

        Map<Integer, String> set = new LinkedHashMap<>();
        set.put(PdfType.OWNER, signPartyA);
        set.put(PdfType.CUSTOMER, signPartyB);
        set.put(PdfType.OWNER_SING_DATE, signPartyADate);
        set.put(PdfType.CUSTOMER_SING_DATE, signPartyBDate);
        set.put(PdfType.SIGN, signAdress);
        CoordinateInfoModel pdfXy = PdfUtils.getPdfXy(pdfPath, set);
        CommContractSignSite commContractSignSite = new CommContractSignSite();
//        BeanUtil.copyObject(pdfXy, commContractSignSite);
        commContractSignSite.setDealId(dealId);
        commContractSignSite.setCityId(cityId);
        commContractSignSite.setPdfPath(pdfOssPath);
        commContractSignSite.setA4Hight(pdfXy.getA4_HIGHT() + "");
//        commContractSignSite.setContentHight(pdfXy.get);
        commContractSignSite.setPage(Byte.valueOf(pdfXy.getPAGE() + ""));
        commContractSignSite.setPartyADate(pdfXy.getPARTY_A_DATE());
        commContractSignSite.setPartyAInfo(pdfXy.getPARTY_A_INFO());
        commContractSignSite.setPartyBDate(pdfXy.getPARTY_B_DATE());
        commContractSignSite.setPartyBInfo(pdfXy.getPARTY_B_INFO());
        commContractSignSite.setPartyCInfo(pdfXy.getPARTY_C_INFO());
        if (commContractSignSites.size() > 0) {
            CommContractSignSite commContractSignSite1 = commContractSignSites.get(0);
            commContractSignSite.setId(commContractSignSite1.getId());
            commContractSignSiteMapper.updateByPrimaryKeySelective(commContractSignSite);
        } else {
            commContractSignSiteMapper.insertSelective(commContractSignSite);
        }
        return ErpResponseJson.ok();
    }

	@Override
	public ResponseJson userPersonalRegTest(String account, String ownerName, String idCard) throws Exception {
		HashMap<String, String> hashMap = BestsignOpenApiClient.userPersonalRegTest(account, ownerName, idCard);
		return ErpResponseJson.ok(hashMap);
	}
    
}

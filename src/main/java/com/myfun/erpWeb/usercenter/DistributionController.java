package com.myfun.erpWeb.usercenter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.erpWeb.usercenter.vo.GetAgencyUseFlagVo;
import com.myfun.repository.agencydb.dao.*;
import com.myfun.repository.agencydb.po.*;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.agencydb.dto.AgencyAmountHistoryDto;
import com.myfun.repository.agencydb.dto.AgencyBuildingInfoDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustDealDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustDto;
import com.myfun.repository.agencydb.dto.AgencyFunRewardLogDto;
import com.myfun.repository.agencydb.dto.AgencyMessageFavDto;
import com.myfun.repository.agencydb.dto.AgencySpreadDto;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.agencydb.AgencyAmountHistoryService;
import com.myfun.service.business.agencydb.AgencyBrokerCompRateService;
import com.myfun.service.business.agencydb.AgencyBuildLayoutService;
import com.myfun.service.business.agencydb.AgencyBuildingInfoService;
import com.myfun.service.business.agencydb.AgencyBuildingPhotoService;
import com.myfun.service.business.agencydb.AgencyCooperationRuleService;
import com.myfun.service.business.agencydb.AgencyFunBrokerAccountService;
import com.myfun.service.business.agencydb.AgencyFunCompRealService;
import com.myfun.service.business.agencydb.AgencyFunCustService;
import com.myfun.service.business.agencydb.AgencyFunCustTrackService;
import com.myfun.service.business.agencydb.AgencyFunRewardLogService;
import com.myfun.service.business.agencydb.AgencyMessageFavService;
import com.myfun.service.business.agencydb.AgencySpreadService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.DateUtil;

/**
 * @author lcb
 * @TODO 楼盘分销模块
 */
@RequestMapping("/distribution")
@Controller
public class DistributionController extends BaseController {

    @Autowired
    AgencyBuildingInfoService agencyBuildingInfoService;
    @Autowired
    AgencyFunCustService agencyFunCustService;
    @Autowired
    AgencyFunRewardLogService agencyFunRewardLogService;
    @Autowired
    AgencyAmountHistoryService agencyAmountHistoryService;
    @Autowired
    AgencySpreadService agencySpreadService;
    @Autowired
    AgencyMessageFavService agencyMessageFavService;
    @Autowired
    ErpFunUsersService funUsersService;
    @Autowired
    AgencyFunCompRealService agencyFunCompRealService;
    @Autowired
    AgencyBuildLayoutService agencyBuildLayoutService;
    @Autowired
    AgencyCooperationRuleService agencyCooperationRuleService;
    @Autowired
    AgencyBuildingPhotoService agencyBuildingPhotoService;
    @Autowired
    AgencyFunCustTrackService agencyFunCustTrackService;
    @Autowired
    AgencyFunBrokerAccountService agencyFunBrokerAccountService;
    @Autowired
    AgencyBrokerCompRateService agencyBrokerCompRateService;
    @Autowired
    AdminFunArchiveMapper adminFunArchiveMapper;
    @Autowired
    AgencyBuildingInfoMapper agencyBuildingInfoMapper;
    @Autowired
    AgencyFunCustMapper agencyFunCustMapper;
    @Autowired
    AgencyFunCustDealMapper agencyFunCustDealMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    AgencyFunRewardLogMapper agencyFunRewardLogMapper;
    @Autowired
    AgencyAmountHistoryMapper agencyAmountHistoryMapper;
    @Autowired
    AgencySpreadMapper agencySpreadMapper;
    @Autowired
    AgencyMessageFavMapper agencyMessageFavMapper;
    @Autowired
    AgencyFunCompRealMapper agencyFunCompRealMapper;
    @Autowired
    AgencyCooperationRuleMapper agencyCooperationRuleMapper;
    @Autowired
    AgencyBuildLayoutMapper agencyBuildLayoutMapper;
    @Autowired
    AgencyBuildingPhotoMapper agencyBuildingPhotoMapper;
    @Autowired
    AgencyFunBrokerAccountMapper agencyFunBrokerAccountMapper;
    @Autowired
    AgencyBrokerCompRateMapper agencyBrokerCompRateMapper;
    @Autowired
    AgencyDistributeAdsMapper agencyDistributeAdsMapper;

    /**
     * @TODO 请求楼盘列表
     * @author lcb
     * @2016-8-30 下午7:46:39
     */
    @ResponseBody
    @RequestMapping("/getDistBuildListOffIndex")
    public ErpResponseJson getDistBuildingList(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        String buildId = param.getString("buildId");

        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", operator.getCityId());
        pMap.put("compNo", operator.getCompNo());
        pMap.put("compId", operator.getCompId());
        if (StringUtils.isNotBlank(buildId)) {
            pMap.put("buildIdArr", buildId.split(","));
        }

        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AgencyBuildingInfoDto> resList = agencyBuildingInfoMapper.getBuildInfoListOnIndex(pMap);
        for (AgencyBuildingInfoDto agency : resList) {
            String photoAddr = agency.getPhotoAddr();
            agency.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
        }
        PageInfo<AgencyBuildingInfoDto> pageInfo = new PageInfo<AgencyBuildingInfoDto>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 获取首页广告列表
     * @author hk
     */
    @ResponseBody
    @RequestMapping("/getDistAdsOnIndex")
    public ErpResponseJson getDistAdsOnIndex(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();

        String cityId = "%," + operator.getCityId() + ",%";
        String compNo = "%,0,%";


        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
        List<AgencyDistributeAds> resList = agencyDistributeAdsMapper.getDistAdsOnIndex(cityId, operator.getCompId(), compNo);
        for (AgencyDistributeAds agency : resList) {
            String photoAddr = agency.getPhotoAddr();
            agency.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
        }
        PageInfo<AgencyDistributeAds> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }


    /**
     * @TODO 楼盘卖点->导向网页
     * @author lcb
     * @2016-8-30 下午7:49:38
     */
    @RequestMapping("/getBuildSellPoint.htm")
    public String getBuildSellPoint(@Valid @RequestBody BaseMapParam param) {
//		PageInfo<AgencyBuildingInfoDto> resList = agencyBuildingInfoService.getDistBuildingList(param, getOperator());
//		ErpResponseJson responseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resList);
        return "/distribution/buildSellPoint";
    }

    /**
     * @TODO 拓客技巧->导向网页
     * @author lcb
     * @2016-8-30 下午7:49:38
     */
    @RequestMapping("/getMoreCustomerSkill.htm")
    public String getMoreCustomerSkill(@Valid @RequestBody BaseMapParam param) {
//		PageInfo<AgencyBuildingInfoDto> resList = agencyBuildingInfoService.getDistBuildingList(param, getOperator());
//		ErpResponseJson responseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resList);
        return "/distribution/moreCustomerSkill";
    }

    /**
     * @TODO 分销须知->导向网页
     * @author lcb
     * @2016-8-30 下午7:49:38
     */
    @RequestMapping("/getDistNotice.htm")
    public String distNotice(@Valid @RequestBody BaseMapParam param) {
//		PageInfo<AgencyBuildingInfoDto> resList = agencyBuildingInfoService.getDistBuildingList(param, getOperator());
//		ErpResponseJson responseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resList);
        return "/distribution/distNotice";
    }

    /**
     * @TODO 政策动态->导向网页
     * @author lcb
     * @2016-8-30 下午7:49:38
     */
    @RequestMapping("/getPolicyInfo.htm")
    public String getPolicyInfo(@Valid @RequestBody BaseMapParam param) {
//		PageInfo<AgencyBuildingInfoDto> resList = agencyBuildingInfoService.getDistBuildingList(param, getOperator());
//		ErpResponseJson responseJson = new ErpResponseJson(Const.ResponseCode.SUCCESS, "查询成功", resList);
        return "/distribution/policyInfo";
    }


    /**
     * @TODO (客户管理)获取带看客户统计信息
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCountCustInfo")
    @ResponseBody
    public ErpResponseJson getDistCountCustInfo(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        // 已报备 已审核 已带看 已认购
        Map<String, String> resMap = agencyFunCustMapper.getDistCountCustInfo(operator.getArchiveId());
        // 查询百分比
        // 查询成交数
        Integer res = agencyFunCustMapper.getSuccessCount(operator.getArchiveId());
        Map<String, Object> resMap2 = agencyFunCustMapper.getCountCustInfo(res);
        String sumNum = resMap2.get("SUM_NUM") + "";//总人数
        String minNum = resMap2.get("MIN_NUM") + "";//小于的
        double runkNum = Double.parseDouble(minNum) / Double.parseDouble(sumNum);
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        String num = nf.format(runkNum);
        resMap.put("archiveRank", num);
        return ErpResponseJson.ok(resMap);
    }

    /**
     * @TODO 获取业绩趋势走向图数据
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCountOfferToBuy")
    @ResponseBody
    public ErpResponseJson getDistCountOfferToBuy(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, String> paramMap = new LinkedHashMap<String, String>();
        Calendar calendar = Calendar.getInstance();
        Date startTime = calendar.getTime();
        paramMap.put(DateUtil.formatDateTimetoString(startTime, "yyyy-MM"), "0");
        for (int i = 0; i < 11; i++) {
            calendar.add(Calendar.MONTH, -1);
            paramMap.put(DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM"), "0");
        }
        List<Map<String, String>> resList = agencyFunCustMapper.getDistCountOfferToBuy(operator.getArchiveId(), DateUtil.DateToString(startTime, "yyyy-MM-01"),
                DateUtil.DateToString(startTime, "yyyy-MM-dd 23:59:59"));
        for (Map<String, String> map : resList) {
            if (!map.isEmpty()) {
                String month = map.get("MONTH");
                String num = map.get("NUM");
                if (paramMap.containsKey(month)) {
                    paramMap.put(month, num);
                }
            }
        }
        return ErpResponseJson.ok(paramMap);
    }

    /**
     * @TODO 根据公司和门店查询出当前参与的楼盘
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistBuildByComp")
    @ResponseBody
    public ErpResponseJson getDistBuildByComp(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", operator.getCityId() + "");
        pMap.put("compNo", operator.getCompNo());
        pMap.put("compId", operator.getCompId() + "");
        List<AgencyBuildingInfo> res = agencyBuildingInfoMapper.getDistBuildByComp(pMap);
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO 查询报备客户列表信息(未完成)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCustList")
    @ResponseBody
    public ErpResponseJson getDistCustList(@Valid @RequestBody BaseMapParam param) {
        List<AgencyFunCust> res = agencyFunCustService.getDistCustList(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 查询我的佣金数据/（我的联动)获取平台/公司分销/加盟圈佣金信息
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCountBorkerAmmount")
    @ResponseBody
    public ErpResponseJson getDistCountBorkerAmmount(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, Object> pMap = param.getMap();
        pMap.put("compId", operator.getCompId() + "");
        pMap.put("archiveId", operator.getArchiveId() + "");
        // 佣金数据
        Map<String, String> resMap = agencyFunCustDealMapper.getDistCountBorkerAmmount(pMap);
        // 年收入
        String m = agencyFunCustDealMapper.getCountCustInfo(operator.getArchiveId());
        Map<String, Integer> r = agencyFunCustDealMapper.getCountCustPercentInfo(m);
        String sumNum = r.get("SUM_NUM") + "";//总人数
        String minNum = r.get("MIN_NUM") + "";//小于的
        double runkNum = Double.parseDouble(minNum) / Double.parseDouble(sumNum);
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        String num = nf.format(runkNum);
        resMap.put("moneyRank", num);
        return ErpResponseJson.ok(resMap);
    }

    /**
     * @TODO （我的联动)获取最近一年的收入信息
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCountMoneyOfYear")
    @ResponseBody
    public ErpResponseJson getDistCountMoneyOfYear(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, String> paramMap = new LinkedHashMap<String, String>();
        Calendar calendar = Calendar.getInstance();
        Date startTime = calendar.getTime();
        paramMap.put(DateUtil.formatDateTimetoString(startTime, "yyyy-MM"), "0");
        for (int i = 0; i < 11; i++) {
            calendar.add(Calendar.MONTH, -1);
            paramMap.put(DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM"), "0");
        }
        List<Map<String, String>> resList = agencyFunCustDealMapper.getCountViewMap(operator.getArchiveId(), DateUtil.DateToString(startTime, "yyyy-MM-01"),
                DateUtil.DateToString(startTime, "yyyy-MM-dd 23:59:59"));
        for (int i = 0; i < resList.size(); i++) {
            Map<String, String> rMap = resList.get(i);
            String month = rMap.get("MONTH");
            String money = rMap.get("MONEY");
            DecimalFormat df = new DecimalFormat();
            df.applyPattern("##0.##");
            money = df.format(Double.parseDouble(money));
            if (paramMap.containsKey(month)) {
                paramMap.put(month, money);
            }
        }
        return ErpResponseJson.ok(paramMap);
    }

    /**
     * @TODO 我的佣金(个人佣金记录)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistPersonalCommList")
    @ResponseBody
    public ErpResponseJson getDistPersonalCommList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> rMap = new HashMap<>();
        Map<String, Object> pMap = param.getMap(); // 参数公用Map
        List<String> rUserIdsList = getPersonalCommList(param, pMap);
        List<AgencyFunCustDealDto> resList = new ArrayList<>();
        if ((null != pMap.get("areaId") || null != pMap.get("regId") ||
                null != pMap.get("grId")) && rUserIdsList.size() != 0) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyFunCustDealMapper.getPersonalCommList(pMap);
        } else if ((null == pMap.get("areaId") && null == pMap.get("regId") &&
                null == pMap.get("grId"))) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyFunCustDealMapper.getPersonalCommList(pMap);
        }
        List<Map<String, String>> commCountInfo = getPersonalCommCountInfo(pMap);
        rMap.put("PERCUST_DEAL_COUNT", commCountInfo);
        rMap.put("PERCUST_DEAL_LIST", new PageInfo<>(resList));
        return ErpResponseJson.ok(rMap);
    }

    /**
     * @TODO 我的佣金(佣金明细列表)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistCustDealList")
    @ResponseBody
    public ErpResponseJson getDistCustDealList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> rMap = new HashMap<>();
        List<AgencyFunCustDealDto> resList = new ArrayList<>();
        Map<String, Object> pMap = param.getMap(); // 参数公用Map
        List<String> rUserIdsList = getPersonalCommList(param, pMap);
        if ((null != pMap.get("areaId") || null != pMap.get("regId") || null != pMap.get("grId"))) {
            if (rUserIdsList.size() != 0) {
                pMap.put("userIds", rUserIdsList);
                PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
                resList = agencyFunCustDealMapper.getCustDealListDetail(pMap);
            }
        } else {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            resList = agencyFunCustDealMapper.getCustDealListDetail(pMap);
        }
        List<Map<String, String>> countList = agencyFunCustDealMapper.getCountCustDealOfStatus(pMap);
        rMap.put("CUST_DEAL_COUNT", countList);
        rMap.put("CUST_DEAL_LIST", resList);
        return ErpResponseJson.ok(rMap);
    }

    /**
     * @TODO 我的佣金(带看奖励列表)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistDaikanRewardsList")
    @ResponseBody
    public ErpResponseJson getDistDaikanRewardsList(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, Object> pMap = param.getMap();
        pMap.put("compId", operator.getCompId() + "");
        pMap.put("archiveId1", operator.getArchiveId() + "");
        pMap.put("cityId", operator.getCityId() + "");
        if (null != pMap.get("startTime")) {
            pMap.put("startTime", pMap.get("startTime") + "00:00:00");
        }
        if (null != pMap.get("endTime")) {
            pMap.put("endTime", pMap.get("endTime") + "23:59:59");
        }
        List<String> rUserIdsList = new ArrayList<>();
        // 查询userId....
        PageInfo<AgencyFunRewardLogDto> pageInfo = null;
        if (null != pMap.get("areaId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(operator.getCityId(), pMap.get("areaId") + "", operator.getCompId(), null, null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                pageInfo = new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        } else if (null != pMap.get("regId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(operator.getCityId(), null, operator.getCompId(), pMap.get("regId") + "", null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                pageInfo = new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        } else if (null != pMap.get("grId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(operator.getCityId(), null, operator.getCompId(), null, pMap.get("grId") + "");
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                pageInfo = new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        } else {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
            List<AgencyFunRewardLogDto> resList = agencyFunRewardLogMapper.getDistDaikanRewardsList(pMap);
            pageInfo = new PageInfo<>(resList);
        }
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 我的佣金(提现记录)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistAmountHistory")
    @ResponseBody
    public ErpResponseJson getDistAmountHistory(@Valid @RequestBody BaseMapParam param) {
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        Map<String, Object> pMap = param.getMap();
        List<AgencyAmountHistoryDto> resList = agencyAmountHistoryMapper.getDistAmountHistory(pMap);
        PageInfo<AgencyAmountHistoryDto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 最新消息(系统消息)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistSystemMessage")
    @ResponseBody
    public ErpResponseJson getDistSystemMessage(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("archiveId", getOperator().getArchiveId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencySpreadDto> resList = agencySpreadMapper.getDistSystemMessage(pMap);
        PageInfo<AgencySpreadDto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 最新消息(系统消息)
     * @author lcb
     * @2016-8-31 下午6:09:15
     */
    @RequestMapping("/getDistMsgConnllectionList")
    @ResponseBody
    public ErpResponseJson getDistMsgConnllectionList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("archiveId", getOperator().getArchiveId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyMessageFavDto> resList = agencyMessageFavMapper.getDistMsgConnllectionList(pMap);
        PageInfo<AgencyMessageFavDto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 获取楼盘管理员
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getDistCompRealAdmin")
    @ResponseBody
    public ErpResponseJson getDistCompRealAdmin(@Valid @RequestBody BaseMapParam param) {
        List<ErpFunUsers> resList = erpFunUsersMapper.getDeveloperAdmin(getOperator().getCityId(), getOperator().getCompId(), 1);
        if (null != resList && resList.size() > 0) {
            ErpFunUsers erpFunUsers = resList.get(0);
            return ErpResponseJson.ok(erpFunUsers);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 获取开发商列表
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getDistFunCompRealList")
    @ResponseBody
    public ErpResponseJson getFunCompRealList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        pMap.put("erpCompId", getOperator().getErpCompId());
        if (null != pMap.get("startTime")) {
            String conStr = pMap.get("startTime") + "";
            String nowTime = "00:00:00";
            conStr = conStr + " " + nowTime;
            pMap.put("startTime", conStr);
        }
        if (null != pMap.get("endTime")) {
            String conStr = pMap.get("endTime") + "";
            String nowTime = "23:59:59";
            conStr = conStr + " " + nowTime;
            pMap.put("endTime", conStr);
        }
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyFunCompReal> resList = agencyFunCompRealMapper.getFunCompRealDevelopList(pMap);
        PageInfo<AgencyFunCompReal> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 获取楼盘管理员
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getDistBuildInfoAdmin")
    @ResponseBody
    public ErpResponseJson getDistBuildInfoAdmin(@Valid @RequestBody BaseMapParam param) {
        List<ErpFunUsers> resList = erpFunUsersMapper.getDeveloperAdmin(getOperator().getCityId(), getOperator().getCompId(), 2);
        if (null != resList && resList.size() > 0) {
            ErpFunUsers erpFunUsers = resList.get(0);
            return ErpResponseJson.ok(erpFunUsers);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 分销楼盘列表(未完成)
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getBuildInfoList")
    @ResponseBody
    public ErpResponseJson getBuildInfoList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("erpCompId", getOperator().getCompId());
        pMap.put("cityId", getOperator().getCityId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        // 查询主体数据
        List<AgencyBuildingInfoDto> resList = agencyBuildingInfoMapper.getBuildInfoList(pMap);

        // 处理时间
        pMap.put("startTime", pMap.get("startTime") + " 00:00:00");
        pMap.put("endTime", pMap.get("endTime") + " 23:59:59");
        for (AgencyBuildingInfoDto agencyBuildingInfoDto : resList) {
            // 查询参数经纪人数
            List<Map<String, String>> count = agencyFunCustMapper.getBorkerCount(pMap);
            // 报备、带看、认购、结佣
            Map<String, String> daiKanCount = agencyFunCustDealMapper.daiKanCount(pMap);
            // 已结佣金
            agencyBuildingInfoDto.setParticipatingBroker(count.size());
            agencyBuildingInfoDto.setSettledCommission(null != daiKanCount.get("SETTLED_COMMISSION") ? daiKanCount.get("SETTLED_COMMISSION") : "0");
            List<Map<String, String>> yongjin = agencyFunCustMapper.getFinishedFee(pMap);
            for (Map<String, String> map : yongjin) {
                String custNumber = map.get("custNumber");
                String custStatus = map.get("CUST_STATUS");
                if ("1".equals(custStatus)) {
                    agencyBuildingInfoDto.setReport(StringUtils.isNotBlank(custNumber) ? custNumber : "0");
                } else if ("3".equals(custStatus)) {
                    agencyBuildingInfoDto.setSee(StringUtils.isNotBlank(custNumber) ? custNumber : "0");
                } else if ("4".equals(custStatus)) {
                    agencyBuildingInfoDto.setSubScription(StringUtils.isNotBlank(custNumber) ? custNumber : "0");
                } else if ("5".equals(custStatus)) {
                    agencyBuildingInfoDto.setCommissionJunction(StringUtils.isNotBlank(custNumber) ? custNumber : "0");
                }
            }
        }
        PageInfo<AgencyBuildingInfoDto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 分销客户列表信息
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getFunCustList")
    @ResponseBody
    public ErpResponseJson getFunCustList(@Valid @RequestBody BaseMapParam param) {
        Operator operator = getOperator();
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", operator.getCityId());
        pMap.put("compId", operator.getCompId());
        pMap.put("deptId", operator.getDeptId());
        List<String> rUserIdsList = new ArrayList<>();
        if (null != pMap.get("areaId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    operator.getCityId(), pMap.get("areaId") + "",
                    operator.getCompId(), null, null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        }
        if (null != pMap.get("regId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    operator.getCityId(), null, operator.getCompId(),
                    pMap.get("regId") + "", null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        }
        if (null != pMap.get("grId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    operator.getCityId(), null, operator.getCompId(), null,
                    pMap.get("grId") + "");
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
            } else {
                pMap.put("userIds", rUserIdsList);
            }
        }
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyFunCustDto> resList = agencyFunCustMapper.getAgencyFunCustList(pMap);
        PageInfo<AgencyFunCustDto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 跟进列表
     * @author lcb
     * @2016-9-20 上午10:19:46
     */
    @RequestMapping("/getDistFunCustTrackList")
    @ResponseBody
    @NotBlank("custId")
    public ErpResponseJson getDistFunCustTrackList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyFunCust> resList = agencyFunCustMapper.getDistFunCustTrackList(pMap);
        PageInfo<AgencyFunCust> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getFunCustDetail")
    @ResponseBody
    @NotBlank("custId")
    public ErpResponseJson getFunCustDetail(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        AgencyFunCustDto agencyFunCustDto = agencyFunCustMapper.getFunCustDetail(pMap);
        if (null != agencyFunCustDto) {
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(agencyFunCustDto.getArchiveId());
            String agencyName = "暂无";
            String agencyMobile = "暂无";
            if (null != adminFunArchive) {
                agencyName = adminFunArchive.getUserName();
                agencyMobile = adminFunArchive.getUserMobile();
            }
            agencyFunCustDto.setAgencyName(agencyName);
            agencyFunCustDto.setAgencyMobile(agencyMobile);
        }
        return ErpResponseJson.ok(agencyFunCustDto);
    }

    /**
     * @TODO
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getBuildInfoDetailed")
    @ResponseBody
    @NotBlank("buildId")
    public ErpResponseJson getBuildInfoDetailed(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        AgencyBuildingInfoDto agencyBuildingInfoDto = new AgencyBuildingInfoDto();
        if ("1".equals(pMap.get("needRule"))) { // 老版本预留的
            agencyBuildingInfoDto = agencyBuildingInfoMapper.getBuildInfoDetailed(pMap);
        } else {
            agencyBuildingInfoDto = agencyBuildingInfoMapper.getBuildInfoDetailed(pMap);
        }
        // 查询楼盘管理员基本信息,老版本是查全部字段.这里先查询基本字段,到时考虑不全的字段临时加
        if (null != agencyBuildingInfoDto && StringUtils.isNotBlank(agencyBuildingInfoDto.getBuildingAdmin())) {
            ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUsersBaseInfo(Integer.valueOf(agencyBuildingInfoDto.getBuildingAdmin()), agencyBuildingInfoDto.getCityId());
            if (null != erpFunUsers) {
                agencyBuildingInfoDto.setBuildingAdminName(erpFunUsers.getUserName());
                agencyBuildingInfoDto.setDeptId(erpFunUsers.getDeptId());
            }
        }
        Integer draw = agencyBuildingInfoDto.getDraw();
        if (null == draw) {
            agencyBuildingInfoDto.setDraw(0);
        }
        return ErpResponseJson.ok(agencyBuildingInfoDto);
    }

    /**
     * @TODO 分销楼盘合作规则详情
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getDistCooperationRuleDetailed")
    @ResponseBody
    @NotBlank({"ruleId", "buildId", "devloperId"})
    public ErpResponseJson getDistCooperationRuleDetailed(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        AgencyCooperationRule agencyCooperationRule = agencyCooperationRuleMapper.getDistCooperationRuleDetailed(pMap);
        return ErpResponseJson.ok(agencyCooperationRule);
    }

    /**
     * @TODO 楼盘户型
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getBuildLayoutList")
    @ResponseBody
    @NotBlank({"buildId"})
    public ErpResponseJson getBuildLayoutList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyBuildLayout> resList = agencyBuildLayoutMapper.getBuildLayoutList(pMap);
        for (int i = 0; i < resList.size(); i++) {
            AgencyBuildLayout pic = resList.get(i);
            if (StringUtils.isNotBlank(pic.getLayoutPic1())) {
                String picStr1 = CommonUtil.getPhotoUrl(pic.getLayoutPic1());
                picStr1 = picStr1.replace("\\", "/");
                pic.setLayoutPic1(picStr1);
            }
            if (StringUtils.isNotBlank(pic.getLayoutPic2())) {
                String picStr2 = CommonUtil.getPhotoUrl(pic.getLayoutPic2());
                picStr2 = picStr2.replace("\\", "/");
                pic.setLayoutPic2(picStr2);
            }
        }
        PageInfo<AgencyBuildLayout> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * @TODO 设置楼盘管理员
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/setDistCompRealAdmin")
    @ResponseBody
    @NotBlank({"buildId"})
    public ErpResponseJson setDistCompRealAdmin(@Valid @RequestBody BaseMapParam param) {
        param.setInteger("cityId", getOperator().getCityId());
        Integer res = funUsersService.setDistCompRealAdmin(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 添加编辑楼盘开发商
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/addEditDeveloper")
    @ResponseBody
    public ErpResponseJson addEditDeveloper(@Valid @RequestBody BaseMapParam param) {
        param.setInteger("cityId", getOperator().getCityId());
        param.setInteger("compId", getOperator().getCompId());
        Integer res = agencyFunCompRealService.setDistCompRealAdmin(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 楼盘图片列表
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getDistBuildPhotoList")
    @ResponseBody
    @NotBlank({"buildId"})
    public ErpResponseJson getDistBuildPhotoList(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<AgencyBuildingPhoto> resList = agencyBuildingPhotoMapper.getDistBuildPhotoList(pMap);
        if (null != resList && resList.size() > 0) {
            for (AgencyBuildingPhoto agencyBuildingPhoto : resList) {
                String pohoAddr = agencyBuildingPhoto.getPhotoAddr();
                agencyBuildingPhoto.setPhotoAddr(CommonUtil.getPhotoUrl(pohoAddr));
            }
        }
        PageInfo<AgencyBuildingPhoto> pageInfo = new PageInfo<>(resList);
        return ErpResponseJson.ok(pageInfo);
    }


    /**
     * @TODO 新增编辑删除户型
     * @2016-9-24 下午1:58:54
     * @author lcb
     */
    @RequestMapping("/saveOrUpdateDistBuildLayout")
    @ResponseBody
    public ErpResponseJson saveOrUpdateDistBuildLayout(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        Integer res = agencyBuildLayoutService.saveOrUpdateDistBuildLayout(param);
        return ErpResponseJson.ok();
    }


    /**
     * @TODO 修改客户状态
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/updateDistFunCust")
    @ResponseBody
    @NotBlank({"custStatus"})
    public ErpResponseJson updateDistFunCust(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("userId", getOperator().getUserId());
        param.setInteger("cityId", getOperator().getCityId());
        param.setString("userName", getOperator().getUserName());
        param.setInteger("provinceId", getOperator().getProvinceId());
        param.setInteger("deptId", getOperator().getDeptId());
        param.setInteger("compId", getOperator().getCompId());
        param.setInteger("archiveId", getOperator().getArchiveId());
        Integer res = agencyFunCustService.updateDistFunCust(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 数据移交
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/transferDistFunCust")
    @ResponseBody
    @NotBlank({"custStatus"})
    public ErpResponseJson transferDistFunCust(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("userId", getOperator().getUserId());
        param.setInteger("cityId", getOperator().getCityId());
        param.setString("userName", getOperator().getUserName());
        param.setInteger("provinceId", getOperator().getProvinceId());
        param.setInteger("deptId", getOperator().getDeptId());
        param.setInteger("compId", getOperator().getCompId());
        param.setInteger("archiveId", getOperator().getArchiveId());
        param.setString("deptName", getOperator().getDeptName());
        Integer res = agencyFunCustService.transferDistFunCust(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO kaifashang xiangqing
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getFunCompRealInfo")
    @ResponseBody
    @NotBlank({"devloperId"})
    public ErpResponseJson getFunCompRealInfo(@Valid @RequestBody BaseMapParam param) {
        AgencyFunCompReal agencyFunCompReal = new AgencyFunCompReal();
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        List<AgencyFunCompReal> resList = agencyFunCompRealMapper.selectByCondition(pMap);
        if (null != resList && resList.size() > 0) {
            agencyFunCompReal = resList.get(0);
        }
        AgencyFunCompReal res = agencyFunCompReal;
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO 新增编辑楼盘消息
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/addEditBuildInfo")
    @ResponseBody
    public ErpResponseJson addEditBuildInfo(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("userId", getOperator().getUserId());
        param.setInteger("cityId", getOperator().getCityId());
        param.setString("userName", getOperator().getUserName());
        param.setInteger("provinceId", getOperator().getProvinceId());
        param.setInteger("deptId", getOperator().getDeptId());
        param.setInteger("compId", getOperator().getCompId());
        param.setInteger("archiveId", getOperator().getArchiveId());
        param.setString("deptName", getOperator().getDeptName());
        param.setString("compNo", getOperator().getCompNo());
        Integer res = agencyBuildingInfoService.addEditBuildInfo(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 更新楼盘分销状态
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/updateDistBuildstatus")
    @ResponseBody
    @NotBlank({"buildId", "agencyStatus"})
    public ErpResponseJson updateDistBuildstatus(@Valid @RequestBody BaseMapParam param) {
        Integer res = agencyBuildingInfoService.updateDistBuildstatus(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO (客户管理)电话判重
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/checkDistMobileRepreated")
    @ResponseBody
    @NotBlank({"buildId", "firstMobile"})
    public ErpResponseJson checkDistMobileRepreated(@Valid @RequestBody BaseMapParam param) {
        Integer res = agencyFunCustService.checkDistMobileRepreated(param);
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO 报备客户
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/createDistCust")
    @ResponseBody
    public ErpResponseJson createDistCust(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        param.setInteger("compId", getOperator().getCompId());
        param.setInteger("deptId", getOperator().getDeptId());
        param.setInteger("userId", getOperator().getUserId());
        param.setInteger("archiveId", getOperator().getArchiveId());
        param.setString("userName", getOperator().getUserName());
        Integer res = agencyFunCustService.createDistCust(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getDistCustInfo")
    @ResponseBody
    public ErpResponseJson createDistCustTrack(@Valid @RequestBody BaseMapParam param) throws Exception {
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", getOperator().getCityId());
        AgencyFunCustDto agencyFunCustDto = agencyFunCustMapper.getDistCustInfo(pMap);
        if (null != agencyFunCustDto) {
            Integer archiveId = agencyFunCustDto.getArchiveId();
            AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
            if (null != adminFunArchive) {
                agencyFunCustDto.setErpUserMobile(adminFunArchive.getUserMobile());
                agencyFunCustDto.setErpUserName(adminFunArchive.getUserName());
            }
        }
        return ErpResponseJson.ok(agencyFunCustDto);
    }

    /**
     * @TODO (我的联动)获取当前用户绑定的银行卡信息
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getDistUserBindBankList")
    @ResponseBody
    public ErpResponseJson getDistUserBindBankList(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        Map<String, Object> pMap = param.getMap();
        String userPosition = operator.getUserPosition();
        pMap.put("cityId", operator.getCityId());
        pMap.put("archiveId", operator.getArchiveId());
        if ("GENERAL_MANAGER".equals(userPosition)) {
            pMap.put("archiveId", operator.getCompId());
        }
        AgencyFunBrokerAccount res = agencyFunBrokerAccountMapper.getDistUserBindBankList(pMap);
        return ErpResponseJson.ok(res);
    }

    /**
     * @TODO (我的联动)获取当前用户绑定的银行卡信息
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/addDistUserBank")
    @ResponseBody
    public ErpResponseJson addDistUserBank(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        // 先注销当前账号
        Map<String, Object> pMap = param.getMap();
        pMap.put("cityId", operator.getCityId());
        Integer archiveId = operator.getArchiveId();
        if ("GENERAL_MANAGER".equals(operator.getUserPosition())) {
            archiveId = operator.getCompId();
        }
        pMap.put("archiveId", archiveId);
        agencyFunBrokerAccountMapper.updateCurrentAccount(pMap);
        // 新建一条数据HashMap param = new HashMap();
        AgencyFunBrokerAccount funBrokerAccount = new AgencyFunBrokerAccount();
        funBrokerAccount.setArchiveId(archiveId);
        funBrokerAccount.setCityId(operator.getCityId());
        funBrokerAccount.setUaType(Integer.valueOf(pMap.get("uaType") + ""));
        funBrokerAccount.setAccountStatus(1);
        funBrokerAccount.setUserIccode(pMap.get("userIccode") + "");
        funBrokerAccount.setAccountType(new Byte(pMap.get("accountType") + ""));
        funBrokerAccount.setAccountBank(pMap.get("accountBank") + "");
        funBrokerAccount.setBankUsername(pMap.get("bankUserName") + "");
        funBrokerAccount.setAccountNo(pMap.get("accountNo") + "");
        funBrokerAccount.setCustMobile(pMap.get("custMobile") + "");
        funBrokerAccount.setBindTime(new Date());
        int accountId = agencyFunBrokerAccountMapper.insertSelective(funBrokerAccount);
        accountId = funBrokerAccount.getAccountId();
        funBrokerAccount = new AgencyFunBrokerAccount();
        funBrokerAccount.setAccountNo(pMap.get("accountNo") + "");
        funBrokerAccount.setAccountId(accountId);
        return ErpResponseJson.ok(funBrokerAccount);
    }

    /**
     * @TODO (我的联动)获取当前用户绑定的银行卡信息
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/getDistCompCommissionRate")
    @ResponseBody
    public ErpResponseJson getDistCompCommissionRate(@Valid @RequestBody BaseMapParam param) throws Exception {
        Operator operator = getOperator();
        AgencyBrokerCompRateKey agencyBrokerCompRateKey = new AgencyBrokerCompRateKey();
        agencyBrokerCompRateKey.setCityId(operator.getCityId());
        agencyBrokerCompRateKey.setCompId(operator.getCompId());
        AgencyBrokerCompRate agencyBrokerCompRate = agencyBrokerCompRateMapper.selectByPrimaryKey(agencyBrokerCompRateKey);
        if (null == agencyBrokerCompRate) {
            agencyBrokerCompRate = new AgencyBrokerCompRate();
            agencyBrokerCompRate.setPaidRate(new BigDecimal(0));
        }
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 我的佣金设置分佣比例饿
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/setCompCommissionRate")
    @ResponseBody
    public ErpResponseJson setCompCommissionRate(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setInteger("cityId", getOperator().getCityId());
        param.setInteger("compId", getOperator().getCompId());
        Integer res = agencyBrokerCompRateService.setCompCommissionRate(param);
        return ErpResponseJson.ok();
    }

    /**
     * @TODO 收藏消息, 取消收藏
     * @author lcb
     * @2016-9-24 下午1:58:54
     */
    @RequestMapping("/updateDistMsgConnllection")
    @ResponseBody
    @NotBlank({"operType", "spreadId"})
    public ErpResponseJson updateDistMsgConnllection(@Valid @RequestBody BaseMapParam param) throws Exception {
        param.setString("userNo", getOperator().getUserNo());
        param.setInteger("archiveId", getOperator().getArchiveId());
        Integer res = agencyMessageFavService.updateDistMsgConnllection(param);
        return ErpResponseJson.ok();
    }

    /**
     * 同意新房分销使用协议
     *
     * @return
     * @author 臧铁
     * @since 2017年7月10日
     */
    @ApiOperation("同意新房分销使用协议")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @ResponseBody
    @RequestMapping("/agreeAgencyUseRule")
    public ResponseJson agreeAgencyUseRule(@Valid @RequestBody BaseMapParam param) {
        AdminFunArchive adminFunArchive = new AdminFunArchive();
        adminFunArchive.setArchiveId(getOperator().getArchiveId());
        adminFunArchive.setAgencyUseFlag((byte) 1);
        adminFunArchiveMapper.updateByPrimaryKeySelective(adminFunArchive);
        return ErpResponseJson.ok();
    }

    /**
     * 获取新房分销使用协议状态
     *
     * @return
     * @author 臧铁
     * @since 2017年7月10日
     */
    @ApiOperation("获取新房分销使用协议状态")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetAgencyUseFlagVo.class, message = "成功")
    })
    @ResponseBody
    @RequestMapping("/getAgencyUseFlag")
    public ResponseJson getAgencyUseFlag(@Valid @RequestBody BaseMapParam param) {
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(getOperator().getArchiveId());
        List<Map<String, Object>> resultList = new LinkedList<>();
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put("agencyUseFlag", adminFunArchive.getAgencyUseFlag());
        resultList.add(resultMap);
        return new ErpResponseJson(resultList);
    }

    public List<Map<String, String>> getPersonalCommCountInfo(Map<String, Object> pMap) {
        return agencyFunCustDealMapper.getCustDealListForPersonalCommList(pMap);
    }

    private List<String> getPersonalCommList(BaseMapParam param, Map<String, Object> pMap) {
        pMap.put("compId", getOperator().getCompId() + "");
        pMap.put("archiveId", getOperator().getArchiveId() + "");
        pMap.put("cityId", getOperator().getCityId() + "");
        if (null != pMap.get("startTime")) {
            pMap.put("startTime", pMap.get("startTime") + "00:00:00");
        }
        if (null != pMap.get("endTime")) {
            pMap.put("endTime", pMap.get("endTime") + "23:59:59");
        }
        List<String> rUserIdsList = new ArrayList<>();
        // 查询userId....
        if (null != pMap.get("areaId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    getOperator().getCityId(), pMap.get("areaId") + "",
                    getOperator().getCompId(), null, null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                return new ArrayList<>();
            } else {
                pMap.put("userId", rUserIdsList);
            }
        }
        if (null != pMap.get("regId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    getOperator().getCityId(), null, getOperator().getCompId(),
                    pMap.get("regId") + "", null);
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                return new ArrayList<>();
            } else {
                pMap.put("userId", rUserIdsList);
            }
        }
        if (null != pMap.get("grId")) {
            rUserIdsList = erpFunUsersMapper.getFunUserIds(
                    getOperator().getCityId(), null, getOperator().getCompId(), null,
                    pMap.get("grId") + "");
            if (null == rUserIdsList || rUserIdsList.size() == 0) {
                return new ArrayList<>();
            } else {
                pMap.put("userId", rUserIdsList);
            }
        }
        return rUserIdsList;
    }
}

package com.myfun.erpWeb.managecenter.houseComplain;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.houseComplain.param.GetHouseComplainListParam;
import com.myfun.erpWeb.managecenter.houseComplain.vo.HouseComplainListVo;
import com.myfun.erpWeb.managecenter.houseComplain.vo.HouseComplainResultVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAuditRuntimeMapper;
import com.myfun.repository.erpdb.dao.ErpAuditUserRuntimeMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpAuditRuntime;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntime;
import com.myfun.repository.erpdb.po.ErpAuditUserRuntimeExample;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpDicDefdinitionsService;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.NumberHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.EncryptUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
@Api(tags = "投诉管理模块")
@Controller
@RequestMapping("/manageCenter/houseComplain/")
public class HouseComplainController extends BaseController {


    @Autowired
    private ErpAuditRuntimeMapper erpAuditRuntimeMapper;
    @Autowired
    private ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
    @Autowired
    private ErpDicDefdinitionsService erpDicDefdinitionsService;


    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;

    //筛选条件：
    //
    //投诉人、处理人、投诉类型（全部、具体投诉类型）、状态、（全部（默认）、成功、失败、未处理）、投诉时间段（具体到日）
    @ApiOperation("投诉审核列表")
    @ApiResponses(value = {@ApiResponse(code = 200, response = HouseComplainResultVo.class, message = "成功")})
    @RequestMapping("/houseComplainList")
    @ResponseBody
    public ResponseJson houseComplainList(@RequestBody GetHouseComplainListParam param) {

        Operator operator = getOperator();
        checkParam(param);
        //非导出需分页
        if (Objects.equals((byte)1,param.getIsExport())) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        }

        param.setAuditResource((byte) 5);//投诉类型
        param.setCompId(operator.getCompId());
        if (!"COMMON_ADMIN".equals(operator.getUserPosition()) && !"GENERAL_MANAGER".equals(operator.getUserPosition())) {
            param.setSelfUserId(operator.getUserId());
        }
        List<ErpAuditRuntime> houseComplainList = erpAuditRuntimeMapper.selectComplainList(operator.getCityId(), param);
        PageInfo<ErpAuditRuntime> pageInfo = new PageInfo<>(houseComplainList);
        List<Integer> saleIds = houseComplainList.stream()
                .filter(obj -> Const.DIC_CASE_TYPE_SALE_FUN.equals(obj.getCaseType()))
                .map(ErpAuditRuntime::getCaseId)
                .collect(Collectors.toList());
        List<Integer> leaseIds = houseComplainList.stream()
                .filter(obj -> Const.DIC_CASE_TYPE_LEASE_FUN.equals(obj.getCaseType()))
                .map(ErpAuditRuntime::getCaseId)
                .collect(Collectors.toList());
        List<Integer> processedAuditIds = houseComplainList
                .stream()
                .filter(obj -> !Objects.equals(obj.getAuditStatus(), (byte)0))
                .map(ErpAuditRuntime::getId)
                .collect(Collectors.toList());
        //已处理人
        List<Integer> dealUserIds = Collections.emptyList();
        Map<Integer, ErpAuditUserRuntime> auditDealUser = Collections.emptyMap();
        if (!processedAuditIds.isEmpty()) {
            List<ErpAuditUserRuntime> erpAuditUserRuntimes = erpAuditUserRuntimeMapper.selectUserByAuditId(operator.getCityId(), processedAuditIds);
            dealUserIds = erpAuditUserRuntimes.stream().map(ErpAuditUserRuntime::getAuditUserId).distinct().collect(Collectors.toList());
            auditDealUser = erpAuditUserRuntimes.stream().collect(Collectors.toMap(ErpAuditUserRuntime::getAuditId, obj -> obj, (old, newVal) -> newVal));
        }
        Set<Integer> createUserIds = houseComplainList.stream().map(ErpAuditRuntime::getUserId).filter(Objects::nonNull).collect(Collectors.toSet());
        ArrayList<Integer> ids = new ArrayList<>();
        ids.addAll(createUserIds);
        ids.addAll(dealUserIds);
        //相关人
        List<ErpFunUsers> erpFunUsers = Collections.emptyList();
        if (!ids.isEmpty()) {
            ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
            erpFunUsersExample.setShardCityId(operator.getCityId());
            erpFunUsersExample.createCriteria().andUserIdIn(ids);
            erpFunUsers = erpFunUsersMapper.selectUserListByIds(operator.getCityId(), operator.getCompId(), ids);
        }
        List<ErpFunSale> erpFunSales = Collections.emptyList();

        if (!saleIds.isEmpty()) {
            ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
            erpFunSaleExample.setShardCityId(operator.getCityId());
            erpFunSaleExample.createCriteria().andSaleIdIn(saleIds);
            erpFunSales = erpFunSaleMapper.selectByExample(erpFunSaleExample);
        }
        List<ErpFunLease> erpFunLeases = Collections.emptyList();
        if (!leaseIds.isEmpty()) {
            ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
            erpFunLeaseExample.setShardCityId(operator.getCityId());
            erpFunLeaseExample.createCriteria().andLeaseIdIn(leaseIds);
            erpFunLeases = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
        }
        Map<Integer, ErpFunSale> saleMap = erpFunSales.stream().collect(Collectors.toMap(ErpFunSale::getSaleId, obj -> obj));
        Map<Integer, ErpFunLease> leaseMap = erpFunLeases.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, obj -> obj));
        Map<Integer, ErpFunUsers> users = erpFunUsers.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, obj -> obj));
        ArrayList<HouseComplainListVo> data = new ArrayList<>();
        ErpAuditUserRuntime defUser = new ErpAuditUserRuntime();
        ErpFunUsers defVal = new ErpFunUsers();
        //出租单价
        Map<String, ErpDicDefinitions> priceUnitMap = new HashMap<>();
        List<String> priceUnits = erpFunLeases.stream().map(ErpFunLease::getPriceUnit).filter(Objects::nonNull).map(String::valueOf).distinct().collect(Collectors.toList());
        if (!leaseIds.isEmpty() && !priceUnits.isEmpty()) {
            List<ErpDicDefinitions> priceUnit = erpDicDefdinitionsService.getDicValues(getOperator().getCityId(), "PRICE_UNIT", priceUnits);
            Map<String, ErpDicDefinitions> priceMap = priceUnit.stream().collect(Collectors.toMap(ErpDicDefinitions::getDicValue, obj -> obj, (e1, e2) -> e2));
            //出租映射
            priceUnitMap.putAll(priceMap);
        }

        for (ErpAuditRuntime obj : houseComplainList) {
            HouseComplainListVo vo = new HouseComplainListVo();
            Integer auditStatus = Optional.ofNullable(obj.getAuditStatus()).map(Integer::valueOf).orElse(null);
            vo.setAuditStatus(auditStatus);
            //创建人
            vo.setCreateUserId(obj.getUserId());
            vo.setCreateUserName(Optional.ofNullable(users.get(obj.getUserId())).orElse(defVal).getUserName());
            //处理人
            Integer dealUserId = Optional.ofNullable(auditDealUser.get(obj.getId())).orElse(defUser).getAuditUserId();
            if (null != auditStatus && 0 != auditStatus) {
                vo.setDealUserId(dealUserId);
                vo.setDealUserName(Optional.ofNullable(users.get(dealUserId)).orElse(defVal).getUserName());
                //处理时间
                ErpAuditUserRuntime erpAuditUserRuntime = auditDealUser.get(obj.getId());
                if (Objects.nonNull(erpAuditUserRuntime) && Objects.nonNull(erpAuditUserRuntime.getAuditTime())) {
                    vo.setDealTime(erpAuditUserRuntime.getAuditTime());
                }
            }
            vo.setCreateUserId(obj.getUserId());
            vo.setAuditId(obj.getId());
            vo.setCaseId(obj.getCaseId());
            vo.setCaseType(obj.getCaseType());
            vo.setHouseComplainType(obj.getAuditType());
            vo.setComplainReason(obj.getAuditExplain());
            //创建时间
            vo.setCreateTime(obj.getCreationTime());
            //houseInfo
            if (Objects.equals(obj.getCaseType(), Const.DIC_CASE_TYPE_SALE_FUN)) {
                ErpFunSale erpFunSale = saleMap.get(obj.getCaseId());
                if (Objects.nonNull(erpFunSale)) {
                    BigDecimal saleTotalPrice = erpFunSale.getSaleTotalPrice();
                    String price = "";
                    if (Objects.nonNull(saleTotalPrice)) {
                        price = new DecimalFormat("#0.##").format(saleTotalPrice.doubleValue());
                    }
                    String houseInfo = String.format("%s %d室 %d㎡ %s万", erpFunSale.getBuildName(),
                            erpFunSale.getSaleRoom(), Optional.ofNullable(erpFunSale.getSaleArea())
                                    .orElse(new BigDecimal(0)).intValue(), price);
                    houseInfo = houseInfo.replaceAll("(null.\\s?)", "");
                    vo.setHouseInfo(houseInfo);
                }
            } else if (Objects.equals(Const.DIC_CASE_TYPE_LEASE_FUN, obj.getCaseType())) {
                ErpFunLease erpFunLease = leaseMap.get(obj.getCaseId());
                if (Objects.nonNull(erpFunLease)) {
                    String priceUnitCn = "";
                    if(Objects.nonNull(erpFunLease.getPriceUnit())){
                        ErpDicDefinitions definitions = priceUnitMap.get(erpFunLease.getPriceUnit().toString());
                        if(Objects.nonNull(definitions)){
                            priceUnitCn = definitions.getDicCnMsg();
                        }
                    }
                    //出租价格及单位
                    String price = NumberHelper.formatNumber(erpFunLease.getLeaseTotalPrice().toString(), NumberHelper.NUMBER_IN_2) + (StringUtil.isEmpty(priceUnitCn) ? "元/月" : priceUnitCn);
                    String houseInfo = String.format("%s %d室 %d㎡ %s", erpFunLease.getBuildName(),
                            erpFunLease.getLeaseRoom(), Optional.ofNullable(erpFunLease.getLeaseArea()).map(BigDecimal::intValue).orElse(null), price);
                    houseInfo = houseInfo.replaceAll("(null.\\s?)", "");
                    vo.setHouseInfo(houseInfo);
                }
            }
            data.add(vo);
        }
        ErpResponseJson json = new ErpResponseJson();
        json.setData(pageInfo);
        HouseComplainResultVo houseComplainResultVo = new HouseComplainResultVo();
        houseComplainResultVo.setHouseComplainList(data);
        json.setData(houseComplainResultVo);
        return json;


    }

    private void checkParam(GetHouseComplainListParam param) {
        if (Objects.isNull(param)) {
            throw new BusinessException("参数异常");
        }
        if (Objects.nonNull(param.getAuditStatus())) {
            if (param.getAuditStatus() > 2 || param.getAuditStatus() < 0) {
                throw new BusinessException("参数异常");
            }
        }

        //前端按类型传值
        param.setCreateUserId(null);
        param.setDealUserId(null);
        if (Objects.nonNull(param.getUserId())) {
            Integer userType = param.getUserType();
            if (Objects.nonNull(userType)) {
                if (userType == 2){//处理人
                    param.setDealUserId(param.getUserId());
                }else {//投诉人
                    param.setCreateUserId(param.getUserId());
                }
                param.setUserId(null);
            }
        }

        if (StringUtils.isNotBlank(param.getEndTime())) {
            String endTime = param.getEndTime().trim()+" 23:59:59.999";
            param.setEndTime(endTime);
        }
    }
}

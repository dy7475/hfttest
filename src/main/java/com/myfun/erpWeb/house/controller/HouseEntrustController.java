package com.myfun.erpWeb.house.controller;

import com.myfun.erpWeb.house.api.HouseEntrustApi;
import com.myfun.erpWeb.house.param.EntrustProtocolDetailsParam;
import com.myfun.erpWeb.house.param.SaveEntrustProtocolParam;
import com.myfun.erpWeb.house.param.getOwnerInfoParam;
import com.myfun.erpWeb.house.vo.EntrustProtocolDetailsVO;
import com.myfun.erpWeb.house.vo.OwnerUserVO;
import com.myfun.erpWeb.house.vo.getOwnerInfoVo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunEntrustOwnersService;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author 蔡春林 此接口无会话
 * @Date 2019/11/23 0023 下午 3:16
 **/
@RestController
public class HouseEntrustController implements HouseEntrustApi {

    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpFunEntrustOwnersService erpFunEntrustOwnesService;
    @Autowired
    private ActiveMqPublisher activeMqPublisher;
    @Autowired
    private AdminSysParaMapper adminSysParaMapper;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private ErpBuildingInfoMapper erpBuildingInfoMapper;

    @Override
    public ResponseJson entrustProtocolDetails(@Validated @RequestBody EntrustProtocolDetailsParam param) {
        //查询委托信息
        ErpFunEntrust erpFunEntrust = new ErpFunEntrust();
        erpFunEntrust.setCityId(param.getCityId());
        erpFunEntrust.setShardCityId(param.getCityId());
        erpFunEntrust.setEntrustId(param.getEntrustId());
        erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(erpFunEntrust);
        if (erpFunEntrust == null) {
            return ErpResponseJson.warn("委托不存在！");
        }
        EntrustProtocolDetailsVO vo = new EntrustProtocolDetailsVO();
        BeanUtils.copyProperties(erpFunEntrust, vo);
        //这儿需要使用委托的委托业务类型
        vo.setCaseType(erpFunEntrust.getEntrustBusiness());
        //查询业主信息
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(param.getCityId());
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(param.getEntrustId());
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunEntrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() < 1) {
            return ErpResponseJson.warn("业主信息错误！");
        }
        List<OwnerUserVO> ownerUserVOList = new ArrayList<>();
        for (ErpFunEntrustOwners erpFunentrustOwner : erpFunentrustOwners) {
            OwnerUserVO ownerUserVO = new OwnerUserVO();
            BeanUtils.copyProperties(erpFunentrustOwner, ownerUserVO);
            if (StringUtil.isNotBlank(erpFunentrustOwner.getSignPicAddr())) {
                ownerUserVO.setSignPicAddr(AppConfig.getPicDomainUrl() + erpFunentrustOwner.getSignPicAddr());
            }
            ownerUserVOList.add(ownerUserVO);
        }
        vo.setCurrentOwerUserId(param.getOwnerId());
        if (Const.HouseCustType.SALE == erpFunEntrust.getCaseType()) {
            ErpFunSale funSale = new ErpFunSale();
            funSale.setCityId(param.getCityId());
            funSale.setShardCityId(param.getCityId());
            funSale.setSaleId(erpFunEntrust.getCaseId());
            ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
            if (erpFunSale == null) {
                return ErpResponseJson.warn("房源信息丢失！");
            }
            //buildName 需要取楼盘的注册名才会有法律效应
            String buildName = " ";
            if (erpFunSale.getBuildId() != null) {
                ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
                erpBuildingInfo.setShardCityId(erpFunSale.getCityId());
                erpBuildingInfo.setCityId(erpFunSale.getCityId().shortValue());
                erpBuildingInfo.setBuildId(erpFunSale.getBuildId());
                erpBuildingInfo = erpBuildingInfoMapper.selectByPrimaryKey(erpBuildingInfo);
                if (erpBuildingInfo != null ) {
                    buildName = StringUtil.isBlank(erpBuildingInfo.getPromotionName()) ? (StringUtil.isBlank(erpBuildingInfo.getBuildName()) ? " " : erpBuildingInfo.getBuildName()) : erpBuildingInfo.getPromotionName();
                }
            }
            String saleRoofT = StringUtil.isBlank(erpFunSale.getSaleRoofT()) ? "" : (erpFunSale.getSaleRoofT() + "栋/座");
            String saleNumT = StringUtil.isBlank(erpFunSale.getSaleNumT()) ? "" : (erpFunSale.getSaleNumT() + "号");
            String tradeAddr = StringUtil.isBlank(erpFunSale.getTradeAddr()) ? "" : erpFunSale.getTradeAddr();
            if (erpFunSale.getSaleUseage() == 1 || erpFunSale.getSaleUseage() == 2 || erpFunSale.getSaleUseage() == 4) {
                vo.setEntrustSubject(buildName + saleRoofT + saleNumT);
            } else {
                if (StringUtil.isBlank(tradeAddr)) {
                    vo.setEntrustSubject(buildName + saleRoofT + saleNumT);
                } else {
                    vo.setEntrustSubject(tradeAddr);
                }
            }
            
            vo.setSaleCommission(erpFunEntrust.getSaleCommission());
            vo.setHouseArea(erpFunSale.getSaleArea());
            // compareTo:  -1：小于；   0 ：等于；   1 ：大于；
            if (erpFunEntrust.getSaleCommission() != null) {
                if (erpFunEntrust.getSaleCommission().compareTo(BigDecimal.ZERO) > 0) {
                    vo.setSaleCommissionCn(Num2RMB.NumToRMBStr(erpFunEntrust.getSaleCommission().toString()));
                } else {
                    vo.setSaleCommissionCn("零");
                }
            }
            if (erpFunSale.getSaleTotalPrice() != null) {
                if (erpFunSale.getSaleTotalPrice().compareTo(BigDecimal.ZERO) > 0) {
                    BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                    vo.setSalePrice(price);
                    vo.setSalePriceCn(Num2RMB.NumToRMBStr(price.toString()));
                } else {
                    vo.setSalePriceCn("零");
                }
            }
            //如果是租售共用的委托需要查询出  出租的价格
            if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                ErpFunLease funLease = new ErpFunLease();
                funLease.setCityId(param.getCityId());
                funLease.setShardCityId(param.getCityId());
                funLease.setLeaseId(erpFunSale.getSaleLeaseId());
                ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
                //[2020-06-22]lizhongguo 需求id：12688 【bug转需求】出租租金，改为手动填写
                if (erpFunEntrust.getCustomRentAmount() != null){
                    BigDecimal customRentAmount = erpFunEntrust.getCustomRentAmount();
                    vo.setLeasePrice(customRentAmount);
                    if (customRentAmount.compareTo(BigDecimal.ZERO) > 0) {
                        vo.setLeasePriceCn(Num2RMB.NumToRMBStr(customRentAmount.toString()));
                    } else {
                        vo.setLeasePriceCn("零");
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
                    if (priceUnit == 2) {*//** 元/天 值:2 *//*
                        leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                    } else if (priceUnit == 3) {*//** 元/平米*月 值:3 *//*
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                    } else if (priceUnit == 4) {*//** 元/平米*天 值:4 *//*
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                    } else if (priceUnit == 5) {*//**元/年  值:5 *//*
                        leaseTotalPrice = new BigDecimal(
                                NumberHelper.div(leaseTotalPrice.doubleValue(), 12, 2));
                    }
                    vo.setLeasePrice(leaseTotalPrice);
                    if (leaseTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
                        vo.setLeasePriceCn(Num2RMB.NumToRMBStr(leaseTotalPrice.toString()));
                    } else {
                        vo.setLeasePriceCn("零");
                    }
                }*/
            }
        } else {
            ErpFunLease funLease = new ErpFunLease();
            funLease.setCityId(param.getCityId());
            funLease.setShardCityId(param.getCityId());
            funLease.setLeaseId(erpFunEntrust.getCaseId());
            ErpFunLease erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(funLease);
            if (erpFunLease == null) {
                return ErpResponseJson.warn("房源信息丢失！");
            }
            //buildName 需要取楼盘的注册名才会有法律效应
            String buildName = "";
            if (erpFunLease.getBuildId() != null) {
                ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
                erpBuildingInfo.setShardCityId(erpFunLease.getCityId());
                erpBuildingInfo.setCityId(erpFunLease.getCityId().shortValue());
                erpBuildingInfo.setBuildId(erpFunLease.getBuildId());
                erpBuildingInfo = erpBuildingInfoMapper.selectByPrimaryKey(erpBuildingInfo);
                if (erpBuildingInfo != null ) {
                    buildName = StringUtil.isBlank(erpBuildingInfo.getPromotionName()) ? (StringUtil.isBlank(erpBuildingInfo.getBuildName()) ? " " : erpBuildingInfo.getBuildName()) : erpBuildingInfo.getPromotionName();
                }
            }
            String leaseRoofT = StringUtil.isBlank(erpFunLease.getLeaseRoofT()) ? "" : (erpFunLease.getLeaseRoofT() + "栋/座");
            String leaseNumT = StringUtil.isBlank(erpFunLease.getLeaseNumT()) ? "" : (erpFunLease.getLeaseNumT() + "号");
            String tradeAddr = StringUtil.isBlank(erpFunLease.getTradeAddr()) ? "" : erpFunLease.getTradeAddr();
            if (erpFunLease.getLeaseUseage() == 1 || erpFunLease.getLeaseUseage() == 2 || erpFunLease.getLeaseUseage() == 4) {
                vo.setEntrustSubject(buildName + leaseRoofT + leaseNumT);
            } else {
                if (StringUtil.isBlank(tradeAddr)) {
                    vo.setEntrustSubject(buildName + leaseRoofT + leaseNumT);
                } else {
                    vo.setEntrustSubject(tradeAddr);
                }
            }

            vo.setLeaseCommission(erpFunEntrust.getLeaseCommission());
            vo.setHouseArea(erpFunLease.getLeaseArea());
            //[2020-06-22]lizhongguo 需求id：12688 【bug转需求】出租租金，改为手动填写
            if (erpFunEntrust.getCustomRentAmount() != null){
                BigDecimal customRentAmount = erpFunEntrust.getCustomRentAmount();
                vo.setLeasePrice(customRentAmount);
                if (customRentAmount.compareTo(BigDecimal.ZERO) > 0) {
                    vo.setLeasePriceCn(Num2RMB.NumToRMBStr(customRentAmount.toString()));
                } else {
                    vo.setLeasePriceCn("零");
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
                if (priceUnit == 2) {*//** 元/天 值:2 *//*
                    leaseTotalPrice = new BigDecimal(NumberHelper.mul(leaseTotalPrice.doubleValue(), 30));
                } else if (priceUnit == 3) {*//** 元/平米*月 值:3 *//*
                    leaseTotalPrice = new BigDecimal(
                            NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()));
                } else if (priceUnit == 4) {*//** 元/平米*天 值:4 *//*
                    leaseTotalPrice = new BigDecimal(
                            NumberHelper.mul(NumberHelper.mul(leaseTotalPrice.doubleValue(), leaseArea.doubleValue()), 30));
                } else if (priceUnit == 5) {*//**元/年  值:5 *//*
                    leaseTotalPrice =  new BigDecimal(
                            NumberHelper.div(leaseTotalPrice.doubleValue(), 12,2));
                }
                vo.setLeasePrice(leaseTotalPrice);
                if (leaseTotalPrice.compareTo(BigDecimal.ZERO) > 0) {
                    vo.setLeasePriceCn(Num2RMB.NumToRMBStr(leaseTotalPrice.toString()));
                } else {
                    vo.setLeasePriceCn("零");
                }
            }*/
            //如果是租售共用的委托需要查询出  出售的价格
            if (erpFunEntrust.getEntrustBusiness() != null && erpFunEntrust.getEntrustBusiness() == 3) {
                ErpFunSale funSale = new ErpFunSale();
                funSale.setCityId(param.getCityId());
                funSale.setShardCityId(param.getCityId());
                funSale.setSaleId(erpFunLease.getSaleLeaseId());
                ErpFunSale erpFunSale = erpFunSaleMapper.selectByPrimaryKey(funSale);
                // 优先读取保存委托时存的房源价格，如果为空再去读取房源当前价格
                if (null != erpFunEntrust.getSalePrice()) {
                    if (erpFunEntrust.getSalePrice().compareTo(BigDecimal.ZERO) > 0) {
                        BigDecimal price = erpFunEntrust.getSalePrice().multiply(new BigDecimal(10000));
                        vo.setSalePrice(price);
                        vo.setSalePriceCn(Num2RMB.NumToRMBStr(price.toString()));
                    } else {
                        vo.setSalePriceCn("零");
                    }
                } else if (erpFunSale.getSaleTotalPrice() != null) {
                    if (erpFunSale.getSaleTotalPrice().compareTo(BigDecimal.ZERO) > 0) {
                        BigDecimal price = erpFunSale.getSaleTotalPrice().multiply(new BigDecimal(10000));
                        vo.setSalePrice(price);
                        vo.setSalePriceCn(Num2RMB.NumToRMBStr(price.toString()));
                    } else {
                        vo.setSalePriceCn("零");
                    }
                }
            } 
        }
        if (erpFunEntrust.getOldRentMoney() != null) {
            if (erpFunEntrust.getOldRentMoney().compareTo(BigDecimal.ZERO) > 0) {
                vo.setOldRentMoneyCn(Num2RMB.NumToRMBStr(erpFunEntrust.getOldRentMoney().toString()));
            } else {
                vo.setOldRentMoneyCn("零");
            }
        }
        vo.setOwnerUserVOList(ownerUserVOList);
        vo.setCityId(param.getCityId());
        vo.setEntrustNo(erpFunEntrust.getEntrustNo());
        String mlCompanySeal = erpSysParaMapper.getParamValue(param.getCityId(), erpFunEntrust.getCompId(), "ML_COMPANY_SEAL");
        if (StringUtil.isNotBlank(mlCompanySeal)) {
            vo.setCompanySealPicAddr(AppConfig.getPicDomainUrl() + mlCompanySeal);
        }
        return ErpResponseJson.ok(vo);
    }

    @Override
    public ResponseJson saveEntrustProtocol(@Validated @RequestBody SaveEntrustProtocolParam param) {
        //查询委托信息
        ErpFunEntrust erpFunEntrust = new ErpFunEntrust();
        erpFunEntrust.setCityId(param.getCityId());
        erpFunEntrust.setShardCityId(param.getCityId());
        erpFunEntrust.setEntrustId(param.getEntrustId());
        erpFunEntrust = erpFunEntrustMapper.selectByPrimaryKey(erpFunEntrust);
        if (erpFunEntrust == null || (erpFunEntrust.getIsEffective() != null && erpFunEntrust.getIsEffective() == 0)) {
            return ErpResponseJson.warn("委托已失效！");
        }
        //查询系统参数查询签署有效期
        Integer signEndTimeNum = 3;
        String signEndTime = adminSysParaMapper.selectParamVlue("ML_SIGN_END_TIME");
        if (StringUtil.isNotBlank(signEndTime)) {
            signEndTimeNum = StringUtil.paseInteger(signEndTime);
        }
        Date signEndDate = DateUtil.addDay(erpFunEntrust.getCreateTime(), signEndTimeNum);
        Date nowTime = new Date();
        if (DateUtil.dateCompare(signEndDate, nowTime) <= 0) {
            return ErpResponseJson.warn("签署日期已超限！");
        }
        //签署委托协议
        int status = erpFunEntrustOwnesService.updateOwnerSignStatus(param.getCityId(), param.getCurrentOwerId(), param.getEntrustId(), param.getSignaturePic(), erpFunEntrust);
        //如果当前签署人是最后一位业主需要保存协议图片和修改委托状态，并且需要判断委托状态 jms执行后续逻辑 
        if (status == 1) {
            // 创建跟进（发起审核） 调用houseWeb接口
            Map<String, Object> paramData = new HashMap<>();
            paramData.put("entrustId", param.getEntrustId());
            paramData.put("cityId", param.getCityId());
            HttpUtil.postJson(AppConfig.getHouseWebUrl() + "/openApi/mlEntrust/entrustCreateTrackInfo", paramData);
            //HttpUtil.postJson("http://test.51vfang.cn/houseWeb/openApi/mlEntrust/entrustCreateTrackInfo", paramData);
            //HttpUtil.postJson("http://192.168.200.155:9004/houseWeb/openApi/mlEntrust/entrustCreateTrackInfo", paramData);
            
            activeMqPublisher.sendAgreementPictureMsg(param.getCityId(), param.getEntrustId(), param.getCurrentOwerId());
        }
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson getOwnerInfo(getOwnerInfoParam param) throws Exception {
        ErpFunEntrustOwners erpFunEntrustOwners = new ErpFunEntrustOwners();
        erpFunEntrustOwners.setId(param.getOwnerId());
        erpFunEntrustOwners.setShardCityId(param.getCityId());
        erpFunEntrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(erpFunEntrustOwners);
        if (erpFunEntrustOwners == null) {
            return ErpResponseJson.warn("未查询到数据！");
        }
        getOwnerInfoVo vo = new getOwnerInfoVo();
        BeanUtils.copyProperties(erpFunEntrustOwners, vo);
        vo.setOwnerId(erpFunEntrustOwners.getId());
        if (StringUtil.isNotBlank(erpFunEntrustOwners.getSignPicAddr())) {
            vo.setSignPicAddr(AppConfig.getPicDomainUrl() + erpFunEntrustOwners.getSignPicAddr());
        }
        return ErpResponseJson.ok(vo);
    }
}

package com.myfun.erpWeb.managecenter.transaction.controller;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.profit.vo.ErpFunPerformanceTypeResultVo;
import com.myfun.erpWeb.managecenter.transaction.api.DealBusinessFjdApi;
import com.myfun.erpWeb.managecenter.transaction.param.*;
import com.myfun.erpWeb.managecenter.transaction.vo.*;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeExtMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpFunPerformanceTypeExtListDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunPerformanceTypeService;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import scala.annotation.meta.param;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class DealBusinessFjdController extends BaseController implements DealBusinessFjdApi {
    @Autowired
    private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
    @Autowired
    private ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;
    @Autowired
    private ErpFunPerformanceTypeService erpFunPerformanceTypeService;
    @Autowired
    private ErpFunProfitMapper erpFunProfitMapper;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private AdminFunCompMapper adminFunCompMapper;

    @Override
    public ResponseJson getFjdFunPerformanceTypeList() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        boolean isFjd= false;//是否是房基地
        String compNo = getOperator().getCompNo();
        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
        Integer customizedType = adminFunComp.getCustomizedType();
        if (customizedType == null) {
            customizedType=0;
        }
        Byte compManagementModel = adminFunComp.getCompManagementModel();
        if (compManagementModel == null) {
            compManagementModel=1;
        }
        if(compManagementModel==2 && customizedType==1){
            isFjd = true;
        }
        if (list.isEmpty()) {
            if(isFjd){
                erpFunPerformanceTypeMapper.insertFunPerforManceTypeForFjd(cityId, compId);
            }else {
                erpFunPerformanceTypeMapper.insertFunPerforManceType(cityId,compId);
            }
            list = erpFunPerformanceTypeMapper.getDataListByCompId(cityId, compId);
        }
        if(isFjd){
        	list = erpFunPerformanceTypeMapper.getFjdDataListByCompId(cityId, compId);
        }
        //判断是否初始化
        ErpFunPerformanceTypeExtExample extExample = new ErpFunPerformanceTypeExtExample();
        extExample.setShardCityId(cityId);
        extExample.createCriteria().andCompIdEqualTo(compId);
        List<ErpFunPerformanceTypeExt> typeExts = erpFunPerformanceTypeExtMapper.selectByExample(extExample);
        if(typeExts.isEmpty()){
            erpFunPerformanceTypeService.initializationData(compId, cityId, isFjd);
        }
        List<ErpFunPerformanceTypeExtListDto> extList = erpFunPerformanceTypeExtMapper.getErpFunPerformanceTypeExtList(cityId, compId);
        List<FjdFunPerformanceTypeVO> resultList = new ArrayList<>();
        for (ErpFunPerformanceType a : list) {
            FjdFunPerformanceTypeVO vo = new FjdFunPerformanceTypeVO();
            vo.setErpFunPerformanceType(a);
            if(extList!=null && extList.size()>0){
                List<ErpFunPerformanceTypeExtListDto> extArrayList = new ArrayList<>();
                extList.stream().forEach(ext->{
                    if(a.getPerformanceId().equals(ext.getPerformanceId())){
                        if(ext.getCommissionType() != null){
                            if(ext.getCommissionType()==1){// 1房源 2客源 3交易服务
                                ext.setUnionStr("房源方-"+ext.getAlias());
                            }else if(ext.getCommissionType()==2){
                                ext.setUnionStr("客源方-"+ext.getAlias());
                            }else if(ext.getCommissionType()==3){
                                ext.setUnionStr("交易服务-"+ext.getAlias());
                            }else if(ext.getCommissionType()==4){
                                ext.setUnionStr("金融服务-"+ext.getAlias());
                            }
                        }
                        ext.setEditExtAble(a.getEditExtAble());
                        extArrayList.add(ext);
                    }
                });
                if(extArrayList.size()==0 && a.getCommissionType()<3){
                    String performanceName = a.getPerformanceName();
                    ErpFunPerformanceTypeExtListDto typeExtListDto = new ErpFunPerformanceTypeExtListDto();
                    typeExtListDto.setEditExtAble(a.getEditExtAble());
                    if(!"自定义".equals(performanceName)){
                        if(isFjd){
                            if(!"销售转介".equals(performanceName)){
                                typeExtListDto.setExtType((byte)1);
                                typeExtListDto.setPerformanceId(a.getPerformanceId());
                                extArrayList.add(typeExtListDto);
                            }
                        }else {
                            if(!"带看".equals(performanceName) && !"开发".equals(performanceName)){
                                typeExtListDto.setExtType((byte)1);
                                typeExtListDto.setPerformanceId(a.getPerformanceId());
                                extArrayList.add(typeExtListDto);
                            }
                        }
                    }
                }
                vo.setList(extArrayList);
            }
            resultList.add(vo);
        };
        GetFjdFunPerformanceTypeListVO listVO = new GetFjdFunPerformanceTypeListVO();
        List<FjdFunPerformanceTypeVO> secondHandHouseList = new ArrayList<>();
        List<FjdFunPerformanceTypeVO> leaseList = new ArrayList<>();
        List<FjdFunPerformanceTypeVO> newHouseList = new ArrayList<>();
        List<FjdFunPerformanceTypeVO> transferList = new ArrayList<>();
        List<FjdFunPerformanceTypeVO> financialList = new ArrayList<>();
        resultList.stream().forEach(a->{
            Byte collectionType = a.getErpFunPerformanceType().getCollectionType();
            if (collectionType != null) {
                if(collectionType ==1){//过户
                    transferList.add(a);
                }else if(collectionType ==2){//二手房
                    secondHandHouseList.add(a);
                }else if(collectionType ==3){//新房
                    newHouseList.add(a);
                }else if(collectionType ==4){//租赁
                    leaseList.add(a);
                }else if(collectionType ==5){//金融
                    financialList.add(a);
                }
            }
        });
        List<FjdFunPerformanceTypeListVO> typeList = new ArrayList<FjdFunPerformanceTypeListVO>();
        //二手房
        FjdFunPerformanceTypeListVO typeListVO = new FjdFunPerformanceTypeListVO();
        typeListVO.setCollectionType(2);
        typeListVO.setCollectionTypeCn("二手房佣金");
        if(secondHandHouseList.size()>0){
            HashSet<Byte> hashSet = new HashSet<>();
            for (FjdFunPerformanceTypeVO fjdFunPerformanceTypeVO : secondHandHouseList) {
                hashSet.add(fjdFunPerformanceTypeVO.getErpFunPerformanceType().getCommissionType());
            }
            for (byte i =1;i<4;i++){
            	if(isFjd && i== 3){
            		continue;
            	}
                if(!hashSet.contains(i)){
                    secondHandHouseList.add(newModel(i,2));
                }
            }
        }else {
            for (byte i =1;i<4;i++){
            	if(isFjd && i== 3){
            		continue;
            	}
                secondHandHouseList.add(newModel(i,2));
            }
        }
        typeListVO.setList(secondHandHouseList);
        typeList.add(typeListVO);

        //租赁
        typeListVO = new FjdFunPerformanceTypeListVO();
        typeListVO.setCollectionType(4);
        typeListVO.setCollectionTypeCn("租赁佣金");
        if(leaseList.size()>0){
            HashSet<Byte> hashSet = new HashSet<>();
            for (FjdFunPerformanceTypeVO fjdFunPerformanceTypeVO : leaseList) {
                hashSet.add(fjdFunPerformanceTypeVO.getErpFunPerformanceType().getCommissionType());
            }
            for (byte i =1;i<3;i++){
                if(!hashSet.contains(i)){
                    leaseList.add(newModel(i,4));
                }
            }
        }else {
            for (byte i =1;i<3;i++){
                leaseList.add(newModel(i,4));
            }
        }
        typeListVO.setList(leaseList);
        typeList.add(typeListVO);

        //新房
        typeListVO = new FjdFunPerformanceTypeListVO();
        typeListVO.setCollectionType(3);
        typeListVO.setCollectionTypeCn("新房佣金");
        if(newHouseList.size()==0){
            newHouseList.add(newModel((byte)2,3));
        }
        typeListVO.setList(newHouseList);
        typeList.add(typeListVO);

        //过户
        typeListVO = new FjdFunPerformanceTypeListVO();
        typeListVO.setCollectionType(1);
        typeListVO.setCollectionTypeCn("过户业绩");
        if(transferList.size()==0){
            transferList.add(newModel((byte)3,1));
        }
        typeListVO.setList(transferList);
        typeList.add(typeListVO);

        //金融
        typeListVO = new FjdFunPerformanceTypeListVO();
        typeListVO.setCollectionType(5);
        typeListVO.setCollectionTypeCn("金融业绩");
        if(financialList.size()==0){
            financialList.add(newModel((byte)4,5));
        }
        typeListVO.setList(financialList);
        typeList.add(typeListVO);

        listVO.setTypeList(typeList);
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
        if(StringUtil.isEmpty(paramValue)){
            ErpSysPara erpSysPara = new ErpSysPara();
            erpSysPara.setShardCityId(cityId);
            erpSysPara.setCompId(compId);
            erpSysPara.setParamId("SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
            erpSysPara.setParamValue("0");
            erpSysPara.setParamType("int");
            erpSysPara.setDefaultValue("0");
            erpSysPara.setParamDesc("抽取总业绩百分比");
            erpSysPara.setNeedRelogin((byte)0);
            erpSysPara.setMediumValue("0");
            erpSysPara.setSeniorValue("0");
            erpSysParaMapper.insertSelective(erpSysPara);
            paramValue="0";
        }
        listVO.setParamValue(paramValue);
        return ErpResponseJson.ok(listVO);
    }

    private FjdFunPerformanceTypeVO newModel(Byte i,Integer type){
        FjdFunPerformanceTypeVO vo = new FjdFunPerformanceTypeVO();
        ErpFunPerformanceType performanceType = new ErpFunPerformanceType();
        performanceType.setCommissionType(i);
        performanceType.setCollectionType(type.byteValue());
        List<ErpFunPerformanceTypeExtListDto> list = new ArrayList<>();
        ErpFunPerformanceTypeExtListDto typeExtListDto = new ErpFunPerformanceTypeExtListDto();
        typeExtListDto.setExtType((byte)1);
        list.add(typeExtListDto);
        vo.setErpFunPerformanceType(performanceType);
        vo.setList(list);
        return vo;
    }

    @Override
    public ErpResponseJson updateCommissioningRulesList(@RequestBody UpdateCommissioningRulesListParam param) throws Exception {
        List<FjdFunPerformanceTypeVO> list = JSON.parseArray(param.getPerformanceJson(), FjdFunPerformanceTypeVO.class);
        if (list.isEmpty()) {
            return ErpResponseJson.ok();
        }
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        erpFunPerformanceTypeService.updatePerformanceList(list,compId,cityId);
        if(StringUtil.isNotEmpty(param.getParamValue())){
            ErpSysPara erpSysPara = new ErpSysPara();
            erpSysPara.setShardCityId(cityId);
            erpSysPara.setParamValue(param.getParamValue());
            erpSysPara.setCompId(compId);
            erpSysPara.setParamId("SIPHON_TOTAL_PERFORMANCE_PERCENTAGE");
            erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara);
        }
        return ErpResponseJson.ok();
    }

    @Override
    public ErpResponseJson getDisablePerformanceTypeList(@RequestBody GetDisablePerformanceTypeListParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
        erpFunPerformanceTypeExample.setShardCityId(cityId);
        erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte)2).andCollectionTypeEqualTo(param.getCollectionType())
        .andCommissionTypeEqualTo(param.getCommissionType());
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.selectByExample(erpFunPerformanceTypeExample);
        GetPerformanceTypeListVO listVO = new GetPerformanceTypeListVO();
        listVO.setList(list);
        return ErpResponseJson.ok(listVO);
    }

    @Override
    public ErpResponseJson disablePerformanceTypeJudgment(@RequestBody DisablePerformanceTypeJudgmentParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        DisablePerformanceTypeJudgmentVO disablePerformanceTypeJudgmentVO = new DisablePerformanceTypeJudgmentVO();
        ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
        erpFunPerformanceTypeExample.setShardCityId(cityId);
        ErpFunPerformanceTypeExample.Criteria criteria = erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 2).andCollectionTypeEqualTo(param.getCollectionType())
                .andCommissionTypeEqualTo(param.getCommissionType());
        String alias = param.getAlias();
        if(StringUtil.isNotEmpty(alias)){
            if("委托".equals(alias) || "独家委托".equals(alias) || "限时委托".equals(alias) || "包租委托".equals(alias)){
                ArrayList<String> objectList = new ArrayList<>();
                objectList.add("普通委托");
                objectList.add("独家委托");
                objectList.add("限时委托");
                objectList.add("包租委托");
                criteria.andPerformanceNameIn(objectList);
            }else {
                criteria.andAliasEqualTo(alias);
            }
        }else {
            return ErpResponseJson.ok();
        }
        List<ErpFunPerformanceType> list = erpFunPerformanceTypeMapper.selectByExample(erpFunPerformanceTypeExample);
        disablePerformanceTypeJudgmentVO.setList(list);
        return ErpResponseJson.ok(disablePerformanceTypeJudgmentVO);
    }

    @Override
    public ResponseJson deletePerformanceCategory(@RequestBody DeletePerformanceCategoryParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        String performanceIdStr = param.getPerformanceIdStr();
        if(StringUtil.isEmpty(performanceIdStr)){
            throw new BusinessException("删除类型id不能为空");
        }
        if (performanceIdStr.indexOf(",")==-1){
            performanceIdStr+=",";
        }
        String[] split = performanceIdStr.split(",");
        for (String s : split) {
            if(StringUtil.isEmpty(s)){
                continue;
            }
            Integer performanceId = Integer.valueOf(s);
            ErpFunPerformanceType erpFunPerformanceType = new ErpFunPerformanceType();
            erpFunPerformanceType.setPerformanceId(performanceId);
            erpFunPerformanceType.setShardCityId(cityId);
            erpFunPerformanceType = erpFunPerformanceTypeMapper.selectByPrimaryKey(erpFunPerformanceType);
            erpFunPerformanceType.setShardCityId(cityId);
            Integer canDel = erpFunPerformanceType.getCanDel();
            if(canDel==2){
                erpFunPerformanceType.setIsDel((byte)2);
            }else if(canDel==0){
                continue;
            }else {
                ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
                erpFunProfitExample.setShardCityId(cityId);
                erpFunProfitExample.createCriteria().andCompIdEqualTo(compId).andPerformanceIdEqualTo(performanceId);
                int count = erpFunProfitMapper.countByExample(erpFunProfitExample);
                if(count>0){
                    erpFunPerformanceType.setIsDel((byte)2);
                }else {
                    erpFunPerformanceType.setIsDel((byte)1);
                }
            }
            erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(erpFunPerformanceType);

            ErpFunPerformanceTypeExtExample erpFunPerformanceTypeExtExample = new ErpFunPerformanceTypeExtExample();
            erpFunPerformanceTypeExtExample.setShardCityId(cityId);
            erpFunPerformanceTypeExtExample.createCriteria().andPerformanceIdEqualTo(performanceId);
            ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
            erpFunPerformanceTypeExt.setIdDel((byte)1);
            erpFunPerformanceTypeExtMapper.updateByExampleSelective(erpFunPerformanceTypeExt,erpFunPerformanceTypeExtExample);
        }
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson deleteSplitSmallCategoryConfiguration(@RequestBody DeleteSplitSmallCategoryConfigurationParam param) {
        String extIds = param.getExtIds();
        if(StringUtil.isEmpty(extIds)){
            throw new BusinessException("删除类型id不能为空");
        }
        Integer cityId = getOperator().getCityId();
        if (extIds.indexOf(",")==-1){
            extIds+=",";
        }
        String[] split = extIds.split(",");
        for (String extId : split) {
            if(StringUtil.isEmpty(extId)){
                continue;
            }
            ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
            erpFunPerformanceTypeExt.setShardCityId(cityId);
            erpFunPerformanceTypeExt.setIdDel((byte)1);
            erpFunPerformanceTypeExt.setExtId(Integer.valueOf(extId));
            erpFunPerformanceTypeExtMapper.updateByPrimaryKeySelective(erpFunPerformanceTypeExt);
        }
        return ErpResponseJson.ok();
    }

    @Override
    public ResponseJson determineIfThePerformanceCategoryIsUsed(@RequestBody  DetermineIfThePerformanceCategoryIsUsedParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        String performanceIdStr = param.getPerformanceIdStr();
        if (performanceIdStr.indexOf(",")==-1){
            performanceIdStr+=",";
        }
        String[] split = performanceIdStr.split(",");
        DetermineIfThePerformanceCategoryIsUsedVO vo = new DetermineIfThePerformanceCategoryIsUsedVO();
        vo.setFlag(0);
        for (String s : split) {
            if(StringUtil.isEmpty(s)){
                continue;
            }
            Integer performanceId = Integer.valueOf(s);
            ErpFunProfitExample erpFunProfitExample = new ErpFunProfitExample();
            erpFunProfitExample.setShardCityId(cityId);
            erpFunProfitExample.createCriteria().andCompIdEqualTo(compId).andPerformanceIdEqualTo(performanceId);
            int count = erpFunProfitMapper.countByExample(erpFunProfitExample);
            if(count>0){
                vo.setFlag(1);
                break;
            }
        }
        return ErpResponseJson.ok(vo);
    }
}

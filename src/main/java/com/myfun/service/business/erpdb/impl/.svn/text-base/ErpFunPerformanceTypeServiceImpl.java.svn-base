package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.transaction.DealBusinessController;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateCommissioningRulesListParam;
import com.myfun.erpWeb.managecenter.transaction.vo.FjdFunPerformanceTypeVO;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeExtMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.dto.ErpFunPerformanceTypeExtListDto;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExt;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPerformanceTypeService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scala.annotation.meta.param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunPerformanceTypeServiceImpl extends AbstractService<ErpFunPerformanceType, ErpFunPerformanceType> implements ErpFunPerformanceTypeService {
    @Autowired
    private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
    @Autowired
    private ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;

    @Override
    public void setBaseMapper() {
        super.baseMapper=erpFunPerformanceTypeMapper;
    }

    @Override
    @Transactional
    public void updatePerformanceList(List<FjdFunPerformanceTypeVO> list, Integer compId, Integer cityId) throws Exception {
        Integer index = 0;
        for (FjdFunPerformanceTypeVO typeVO : list) {
            ErpFunPerformanceType erpFunPerformanceType = typeVO.getErpFunPerformanceType();
            if(StringUtil.isEmpty(erpFunPerformanceType.getAlias())){
                continue;
            }
            if (StringUtil.isBlank(erpFunPerformanceType.getPerformanceName())) {
                erpFunPerformanceType.setPerformanceName("自定义");
            }
            index++;
            erpFunPerformanceType.setSeqNo(index);
            erpFunPerformanceType.setShardCityId(cityId);
            if (null == erpFunPerformanceType.getPerformanceId()) {// 不存在时新增
                erpFunPerformanceType.setCreateTime(new Date());
                erpFunPerformanceType.setCompId(compId);
                Integer hasunPerformanceTypeId = erpFunPerformanceTypeMapper.getFjdHasunPerformanceTypeId(cityId, compId, erpFunPerformanceType.getPerformanceName(),erpFunPerformanceType.getAlias(),erpFunPerformanceType.getCollectionType(),erpFunPerformanceType.getCommissionType());
                if (null == hasunPerformanceTypeId) {
                    erpFunPerformanceType.setCanDel(1);
                    erpFunPerformanceType.setIsDel((byte)0);
                    erpFunPerformanceType.setIsAuto((byte)1);
                    erpFunPerformanceTypeMapper.insertSelective(erpFunPerformanceType);
                    erpFunPerformanceType.setPerformanceId(erpFunPerformanceType.getPerformanceId());
                } else {
                    ErpFunPerformanceType funPerformanceType = new ErpFunPerformanceType();
                    funPerformanceType.setSeqNo(index);
                    funPerformanceType.setPerformanceId(hasunPerformanceTypeId);
                    funPerformanceType.setShardCityId(cityId);
                    erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(funPerformanceType);
                    erpFunPerformanceType.setPerformanceId(hasunPerformanceTypeId);
                }
            } else {// 存在时通过主键修改
                erpFunPerformanceTypeMapper.updateByPrimaryKeySelective(erpFunPerformanceType);
            }
        }
        for (FjdFunPerformanceTypeVO typeVO : list) {
            ErpFunPerformanceType erpFunPerformanceType = typeVO.getErpFunPerformanceType();
            List<ErpFunPerformanceTypeExtListDto> typeVOList = typeVO.getList();
            if (typeVOList == null) {
                continue;
            }
            for (ErpFunPerformanceTypeExtListDto typeExt : typeVOList) {
                String unionStr = typeExt.getUnionStr();
                ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                BeanUtil.copyObject(typeExt,erpFunPerformanceTypeExt);
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                if (erpFunPerformanceTypeExt.getTargetPerformanceId() == null) {
                    if(StringUtil.isNotEmpty(erpFunPerformanceTypeExt.getEnMsg())){
                        String[] split = erpFunPerformanceTypeExt.getEnMsg().split(",");
                        ErpFunPerformanceTypeExample typeExample = new ErpFunPerformanceTypeExample();
                        typeExample.setShardCityId(cityId);
                        typeExample.createCriteria().andCollectionTypeEqualTo(Byte.valueOf(split[0])).andCommissionTypeEqualTo(Byte.valueOf(split[1]))
                                .andAliasEqualTo(split[2]).andCompIdEqualTo(compId);
                        ErpFunPerformanceType performanceType = erpFunPerformanceTypeMapper.selectOneByExample(typeExample);
                        if(performanceType!=null){
                            erpFunPerformanceTypeExt.setTargetPerformanceId(performanceType.getPerformanceId());
                        }
                    }
                }
                if (erpFunPerformanceTypeExt.getExtId() == null) {
                    erpFunPerformanceTypeExt.setCompId(compId);
                    erpFunPerformanceTypeExt.setCreateTime(new Date());
                    erpFunPerformanceTypeExt.setIdDel((byte)0);
                    erpFunPerformanceTypeExt.setPerformanceId(erpFunPerformanceType.getPerformanceId());
                    erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                }else{
                    if(StringUtil.isNotEmpty(unionStr) && "不分配".equals(unionStr)){
                        erpFunPerformanceTypeExtMapper.updateTargetPerformanceIdNull(cityId,erpFunPerformanceTypeExt.getExtId());
                    }else {
                        erpFunPerformanceTypeExtMapper.updateByPrimaryKeySelective(erpFunPerformanceTypeExt);
                    }
                }
            }
        }
    }

    @Override
    @Transactional
    public void initializationData(Integer compId, Integer cityId, Boolean isFjd) {
        Date date = new Date();
        if(isFjd){
            for (byte i =2;i<5;i++){
                if(i==3){
                    continue;
                }
                //二手房佣金-房源方-房源房勘人-无人时归属客源登记人
                ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1).andPerformanceNameEqualTo("独家委托");
                ErpFunPerformanceType survey = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1).andPerformanceNameEqualTo("房源维护人");
                ErpFunPerformanceType register = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)2).andPerformanceNameEqualTo("客源登记人");
                ErpFunPerformanceType custRegister = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(survey.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(custRegister.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                //二手房佣金-房源方-钥匙提交人-无人时归属客源登记人
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1).andPerformanceNameEqualTo("钥匙提交人");
                ErpFunPerformanceType lockOpener = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(lockOpener.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(custRegister.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                //二手房佣金-房源方-房源房勘人-无人时归属房源维护人
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1).andPerformanceNameEqualTo("房源房勘人");
                ErpFunPerformanceType fangkan = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(fangkan.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(custRegister.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                //二手房佣金-房源方-普通委托-无人时归属独家委托
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1).andPerformanceNameEqualTo("普通委托");
                ErpFunPerformanceType simpleWeituo = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(simpleWeituo.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(survey.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                //二手房佣金-客源方-销售助攻-无人时归属客源登记人
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)2).andPerformanceNameEqualTo("销售助攻");
                ErpFunPerformanceType bargainer = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(bargainer.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(custRegister.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)2).andPerformanceNameEqualTo("销售转介");
                ErpFunPerformanceType yijia = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(yijia.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(custRegister.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
            }
        }else {
            for (byte i =2;i<5;i++){
                if(i==3){
                    continue;
                }
                ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1)
                        .andPerformanceNameEqualTo("钥匙提交人");
                ErpFunPerformanceType keyAuthor = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)2)
                        .andPerformanceNameEqualTo("销售助攻");
                ErpFunPerformanceType bargainer = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
                erpFunPerformanceTypeExample.setShardCityId(cityId);
                erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo(i).andCommissionTypeEqualTo((byte)1)
                        .andPerformanceNameEqualTo("独家委托");
                ErpFunPerformanceType exclusiveCommission = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
                

                //独家委托超出部分从钥匙拆分5%；客源促成拆分10%
                ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(exclusiveCommission.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(keyAuthor.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(5));
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
                erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
                erpFunPerformanceTypeExt.setShardCityId(cityId);
                erpFunPerformanceTypeExt.setPerformanceId(exclusiveCommission.getPerformanceId());
                erpFunPerformanceTypeExt.setCompId(compId);
                erpFunPerformanceTypeExt.setExtType((byte)1);
                erpFunPerformanceTypeExt.setTargetPerformanceId(bargainer.getPerformanceId());
                erpFunPerformanceTypeExt.setIdDel((byte)0);
                erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(10));
                erpFunPerformanceTypeExt.setCreateTime(date);
                erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
            }
        }

    }

}

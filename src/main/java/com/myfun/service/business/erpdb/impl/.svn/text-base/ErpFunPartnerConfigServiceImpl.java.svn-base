package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.sysmanager.param.UpdatePartnerConfigParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerLogMapper;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunPartnerConfig;
import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.utils.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * @Date: 2019/11/12 14:10
 * @Description:
 */
@Service
public class ErpFunPartnerConfigServiceImpl extends AbstractService<ErpFunPartnerConfig,ErpFunPartnerConfig> implements ErpFunPartnerConfigService {

    @Autowired
    private ErpFunPartnerConfigMapper erpFunPartnerConfigMapper;
    @Autowired
    private ErpFunCompMapper erpFunCompMapper;
    @Autowired
    private ErpFunPartnerLogMapper erpFunPartnerLogMapper;


    @Override
    public void setBaseMapper() {
        super.baseMapper = erpFunPartnerConfigMapper;
    }

    @Transactional
    @Override
    public PartnerConfigDto getPartnerConfiguration(Integer cityId, Integer compId) {
        ErpFunPartnerConfig config = erpFunPartnerConfigMapper.selectByPartnerId(cityId, compId, null);
        int recordMonth = -1;
        int recordYear = -1;
        if (Objects.nonNull(config)) {
            Optional<LocalDateTime> recordDate = Optional.ofNullable(config.getCurrentMonth()).map(Date::toInstant).map(obj -> LocalDateTime.ofInstant(obj, ZoneId.systemDefault()));
            if (recordDate.isPresent()) {
                recordMonth = recordDate.get().getMonthValue();
                recordYear = recordDate.get().getYear();
            }
        }
        PartnerConfigDto dto = new PartnerConfigDto();
        if (Objects.isNull(config)) {
            setDefaultVal(dto);
            config = new ErpFunPartnerConfig();
            BeanUtils.copyProperties(dto,config);
            config.setCompId(compId);
            insertNewRecord(cityId, config);
            //将id,compId拷贝回来
            BeanUtils.copyProperties(config,dto);
        } else if (LocalDate.now().getYear() != recordYear || LocalDate.now().getMonthValue() != recordMonth) {
            //不是同一个月
            ErpFunPartnerConfig insertModel = new ErpFunPartnerConfig();
            BeanUtils.copyProperties(config, insertModel);
            insertNewRecord(cityId, insertModel);
            BeanUtils.copyProperties(insertModel, dto);
            //
        }else {
            BeanUtils.copyProperties(config, dto);
        }
        return dto;
    }

    @Transactional
    @Override
    public void updateConfig(GeneralParam generalParam, UpdatePartnerConfigParam param) {
        ErpFunPartnerConfig record = erpFunPartnerConfigMapper.selectByPartnerId(param.getCityId(), param.getCompId(), null);
        int recordMonth = -1;
        int recordYear = -1;
        if (Objects.nonNull(record)) {
            Optional<LocalDateTime> recordDate = Optional.ofNullable(record.getCurrentMonth()).map(Date::toInstant).map(obj -> LocalDateTime.ofInstant(obj, ZoneId.systemDefault()));
            if (recordDate.isPresent()) {
                recordMonth = recordDate.get().getMonthValue();
                recordYear = recordDate.get().getYear();
            }
        }
        if (Objects.isNull(record)) {
            //insert
            ErpFunPartnerConfig model = new ErpFunPartnerConfig();
            BeanUtils.copyProperties(param, model);
            checkDealConfig(model);
            insertNewRecord(param.getCityId(),model);
            writeLog(generalParam, null, model);
        } else if(LocalDate.now().getYear() != recordYear || LocalDate.now().getMonthValue() != recordMonth){
            //不是同一个月
            ErpFunPartnerConfig insertModel = new ErpFunPartnerConfig();
            BeanUtils.copyProperties(record, insertModel);
            String[] ignoreProps = BeanUtil.getNullPropertyNames(param);
            BeanUtils.copyProperties(param, insertModel, ignoreProps);
            checkDealConfig(insertModel);
            insertNewRecord(param.getCityId(), insertModel);
            writeLog(generalParam, record, insertModel);
        } else {
            ErpFunPartnerConfig updateModel = new ErpFunPartnerConfig();
            BeanUtils.copyProperties(record, updateModel);
            BeanUtils.copyProperties(param, updateModel,  BeanUtil.getNullPropertyNames(param));
            updateModel.setUpdateTime(new Date());
            updateModel.setShardCityId(param.getCityId());
            checkDealConfig(updateModel);
            erpFunPartnerConfigMapper.updateByPrimaryKeySelective(updateModel);
            writeLog(generalParam, record, updateModel);
        }
    }

    private void checkDealConfig(ErpFunPartnerConfig config) {
        if (Objects.equals(config.getBusinessDataApart(), (byte)1)) {
            config.setDealApart((byte)1);
        }
    }

    private  void  writeLog(GeneralParam generalParam,ErpFunPartnerConfig oldModel, ErpFunPartnerConfig newModel) {
        ErpFunPartnerLog log = new ErpFunPartnerLog();
        log.setShardCityId(generalParam.getCityId());
        log.setCompId(generalParam.getCompId());
        log.setCreateTime(new Date());
        log.setCreateUid(generalParam.getUserId());
        log.setModular((byte)3);
        log.setPartnerId(-1);
        log.setBeforeModification(JSON.toJSONString(oldModel));
        log.setAfterModification(JSON.toJSONString(newModel));
        String logContent = String.format("%s修改了公司分组参数配置", generalParam.getUserName());
        log.setLogContent(logContent);
        erpFunPartnerLogMapper.insertSelective(log);
    }

    private void insertNewRecord(Integer cityId, ErpFunPartnerConfig config) {
        Instant instant = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date currMonth = Date.from(instant);
        Date now = new Date();
        config.setCreateTime(now);
        config.setUpdateTime(now);
        config.setIsDel((byte)0);
        config.setCurrentMonth(currMonth);
        config.setCompId(config.getCompId());
        config.setShardCityId(cityId);
        config.setId(null);
        try {
            erpFunPartnerConfigMapper.insertSelective(config);
        } catch (Exception e) {
            //
        }
    }

    static void setDefaultVal(Object configDto) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(configDto);
        PropertyDescriptor[] descriptors = beanWrapper.getPropertyDescriptors();
        for (PropertyDescriptor pd : descriptors) {
            Method method = pd.getReadMethod();
            if (Objects.isNull(method)) {
                continue;
            }
            try {
                Object val = method.invoke(configDto);
                if (Objects.isNull(val) && Objects.nonNull(pd.getWriteMethod()) && pd.getName().endsWith("Apart") && pd.getPropertyType() == Byte.class) {
                    pd.getWriteMethod().invoke(configDto, (byte) 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CheckPartnerConfigDto checkPartnerConfig(Integer cityId, Integer compId, Integer partnerId, String apartName) {
        ErpFunComp condition = new ErpFunComp(cityId, compId);
        ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(condition);
        CheckPartnerConfigDto result = new CheckPartnerConfigDto();

        if (erpFunComp != null) {
            // 该公司是否开启加盟商配置 0=没有开启 1=开启(独立配置)
            Byte openPartner = erpFunComp.getOpenPartner();
            result.setOpenPartner(openPartner == null ? (byte) 0 : openPartner);

            // 开启加盟商
            if (openPartner != null && openPartner == 1) {
                // 开启了加盟商 获取加盟管理配置表
                PartnerConfigDto config = this.getPartnerConfiguration(cityId, compId);
                try {
                    // 例如 getHouseDataApart: 房源是否分开管控
                    String getter = "get" + apartName.substring(0, 1).toUpperCase() + apartName.substring(1);
                    Method method = config.getClass().getMethod(getter);
                    byte isApart = (byte) method.invoke(config);
                    result.setIsApart(isApart);

                    if (partnerId > 0) {
                        result.setPartnerIds(Collections.singletonList(partnerId));
                    } else {
                        // 总部和直营共用的返回-1以及0(例如系统参数)
                        if ("strategyParamApart".equals(apartName)) {
                            result.setPartnerIds(Arrays.asList(-1, 0));
                        } else {
                            // 总部和直营不共用的返回各自的加盟商ID(例如房客源)
                            result.setPartnerIds(Collections.singletonList(partnerId));
                        }
                    }
                } catch (Exception e) {
                    throw new BusinessException("获取加盟管理配置项错误");
                }
            }
        }
        return result;
    }

}

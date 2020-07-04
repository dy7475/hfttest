package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.sysmanager.param.AddPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.FunDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerDeptMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinitionExample;
import com.myfun.repository.erpdb.po.ErpFunPartner;
import com.myfun.repository.erpdb.po.ErpFunPartnerDept;
import com.myfun.repository.erpdb.po.ErpFunPartnerExample;
import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpFunPartnerService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.Assert;
import org.apache.zookeeper.Op;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import scala.util.control.Exception;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
@Service
public class ErpFunPartnerServiceImpl extends AbstractService<ErpFunPartner, ErpFunPartner> implements ErpFunPartnerService {

    @Autowired
    private ErpFunPartnerMapper erpFunPartnerMapper;
    @Autowired
    private ErpFunDeptsService erpFunDeptsService;
    @Autowired
    private ErpFunPartnerDeptMapper erpFunPartnerDeptMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpFunUsersService erpFunUsersService;
    @Autowired
    private ErpFunPartnerLogMapper erpFunPartnerLogMapper;
    @Autowired
    private ErpSysParaMapper erpSysParaMapper;
    @Autowired
    private ErpFunPartnerConfigService erpFunPartnerConfigService;
    @Autowired
    private ReportFunSaleMinMapper reportFunSaleMinMapper;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpFunPartnerMapper;
    }

    private List<String> implicitCallApartParams = Arrays.asList("IS_OPEN_HIDEPHONE", "IS_OPEN_HIDE_SELF_PHONE_HOUSE", "IS_OPEN_HIDE_SELF_PHONE_CUSTOMER",
            "IPCALL_HIDEPHONE_COUNT", "IPCALL_AREA_HIDEPHONE_COUNT", "VOIP_USE_COMP_MONEY");
    private List<String> transPlateRuleParams = Arrays.asList("HOUSE_TRANSFER_FOR_WHO", "PRIVATE_HOUSE_TRANSFER", "PUBLIC_HOUSE_TRANSFER",
            "PUBLIC_CUST_TRANSFER", "PRIVATE_HOUSE_TRANSFER_PUBLIC", "PRIVATE_CUST_TRANSFER_PUBLIC");
    private List<String> plateRangeParams = Arrays.asList("SHARE_HOUSE_RANGE", "SHARE_CUST_RANGE", "PUBLIC_HOUSE_RANGE", "PUBLIC_CUST_RANGE");

    private List<String> coreInfoParams = Arrays.asList("SHARE_FUN_CORE_DEPT", "SHARE_FUN_CORE_OTHER", "SHARE_CUST_CORE_DEPT", "SHARE_CUST_CORE_OTHER");
    private List<String> coreInfoRoleParams = Arrays.asList("VIEW_HOUSE_COUNT_SELF%", "VIEW_HOUSE_COUNT_OTHER%", "VIEW_CUST_COUNT_SELF%", "VIEW_CUST_COUNT_OTHER%");

    private List<String> strategySysParams = Arrays.asList("SPECIAL_PROTECT_DAYS", "PASSWORD_RECORDS", "INFO_MAX_SECRECY", "SCHEDULE_PROTECT_DAYS",
            "WARMDAY_OF_RENTDUE", "RESPITE_PROTECT_DAYS", "DEPT_COMMEND_RECORDS", "COMMEND_RECORDS", "INFO_MAX_COMMEND_DAYS",
            "INFO_MAX_FOCUS_DAYS", "INFO_MAX_FOCUS_DAYS",

            "FANGKAN_RED_SELL", "RED_FANGKAN_PUBLIC_SELL", "TRACK_RED_SELL", "RED_TRACK_PUBLIC_SELL", "GET_PUBLIC_SELL",
            "GET_PUBLIC_RED_SELL", "GET_RED_TRACK_PUBLIC_SELL", "PUBLIC_CANCEL_SELL", "PUBLIC_NOTGET_CANCEL_SELL",

            "FANGKAN_RED_LEASE", "RED_FANGKAN_PUBLIC_LEASE", "TRACK_RED_LEASE", "RED_TRACK_PUBLIC_LEASE", "GET_PUBLIC_LEASE",
            "GET_PUBLIC_RED_LEASE", "GET_RED_TRACK_PUBLIC_LEASE", "PUBLIC_CANCEL_LEASE", "PUBLIC_NOTGET_CANCEL_LEASE",

            "FANGKAN_RED_BUY", "RED_FANGKAN_PUBLIC_BUY", "TRACK_RED_BUY", "RED_TRACK_PUBLIC_BUY", "GET_PUBLIC_BUY", "GET_PUBLIC_RED_BUY",
            "GET_RED_TRACK_PUBLIC_BUY", "PUBLIC_CANCEL_BUY", "PUBLIC_NOTGET_CANCEL_BUY",

            "FANGKAN_RED_RENT", "RED_FANGKAN_PUBLIC_RENT", "TRACK_RED_RENT", "RED_TRACK_PUBLIC_RENT", "GET_PUBLIC_RENT", "GET_PUBLIC_RED_RENT",
            "GET_RED_TRACK_PUBLIC_RENT", "PUBLIC_CANCEL_RENT", "PUBLIC_NOTGET_CANCEL_RENT"
    );
    private List<String> strategyRoleSysParams = Arrays.asList("SALE_LIMIT%", "LEASE_LIMIT%");

    @Transactional(propagation = Propagation.REQUIRED)
    public ErpFunPartner addPartner(AddPartnerParam param) {
        //c.写数据记录，写日志
        ErpFunPartner erpFunPartner = new ErpFunPartner();
        BeanUtils.copyProperties(param, erpFunPartner);
        erpFunPartner.setCompId(param.getCompId());
        Date now = new Date();
        erpFunPartner.setCreateTime(now);
        erpFunPartner.setUpdateTime(now);
        erpFunPartner.setIsDel((byte) 0);
        erpFunPartner.setShardCityId(param.getCityId());
        erpFunPartnerMapper.insertSelective(erpFunPartner);
        //FUN_PARTNER_LOG FunPartnerLog
        String content = MessageFormat.format("{0}新增了分组[{1}]", param.getUserName(), param.getPartnerName());
        writeAddPartnerLog(content, param, erpFunPartner, erpFunPartner.getId());
        //公司已经开启加盟模式情况下拷贝系统参数
        deduceCopySysPara(param.getCityId(), param.getCompId(), erpFunPartner);
        //返回创建内容
        return erpFunPartner;
    }

    public void deletePartnerSysParam(Integer cityId, Integer compId, Integer partnerId) {
        List<String> params = Stream.of(implicitCallApartParams, transPlateRuleParams, plateRangeParams, coreInfoParams, strategySysParams)
                .flatMap(List::stream).collect(Collectors.toList());
        erpSysParaMapper.cleanSysParamByPartnerId(cityId, compId, partnerId, params);
        //角色
        List<String> roleParams = Stream.of(coreInfoRoleParams, strategyRoleSysParams)
                .flatMap(List::stream).collect(Collectors.toList());
        erpSysParaMapper.cleanRoleSysParamByPartnerId(cityId, compId, partnerId, roleParams);
    }


    private void deduceCopySysPara(Integer cityId, Integer compId, ErpFunPartner erpFunPartner) {

        List<Integer> partnerIds = Collections.singletonList(erpFunPartner.getId());
        PartnerConfigDto config = erpFunPartnerConfigService.getPartnerConfiguration(cityId, compId);
        //分别判断各系统模块是否分开管控
        //1.隐号拨打
        if (Objects.equals(config.getImplicitCallApart(), (byte) 1)) {
            // 复制系统参数设置到加盟商设置中, 给所有加盟商都配置一份
            copySysParam(cityId, compId, erpFunPartner.getId(), implicitCallApartParams);
        }
        //2.转盘规则
        if (Objects.equals(config.getTransPlateRuleApart(), (byte) 1)) {
            copySysParam(cityId, compId, erpFunPartner.getId(), transPlateRuleParams);
        }
        //3.公盘抢盘范围
        if (Objects.equals(config.getPlateRangeApart(), (byte) 1)) {
            copySysParam(cityId, compId, erpFunPartner.getId(), plateRangeParams);
        }
        //4.核心信息查看条数
        if (Objects.equals(config.getCoreInfoApart(), (byte) 1)) {
            copySysParam(cityId, compId, erpFunPartner.getId(), coreInfoParams);
            copyRoleSysParam(cityId, compId, erpFunPartner.getId(), coreInfoRoleParams);
        }
        //5.策略参数
        if (Objects.equals(config.getStrategyParamApart(), (byte) 1)) {
            copySysParam(cityId, compId, erpFunPartner.getId(), strategySysParams);
            copyRoleSysParam(cityId, compId, erpFunPartner.getId(), strategyRoleSysParams);
        }
    }

    private void copyRoleSysParam(Integer cityId, Integer compId, Integer partnerId, List<String> roleSysParams) {
        // 复制系统参数设置到加盟商设置中, 给所有加盟商都配置一份
        // 按角色配置到加盟商设置中
        erpSysParaMapper.cleanCompPartnerSysParam(cityId, compId, roleSysParams);
        erpSysParaMapper.copyCompRoleSysParamToPartner(cityId, compId, Collections.singletonList(partnerId), roleSysParams);
    }

    private void copySysParam(Integer cityId, Integer compId, Integer partnerId, List<String> sysParams) {
        // 清空加盟商的系统参数设置, 除了公司的都清除掉, 防止已经有参数但是重复插入
        // 复制系统参数设置到加盟商设置中, 给所有加盟商都配置一份
        erpSysParaMapper.cleanPartnerSysParam(cityId, compId, sysParams);
        erpSysParaMapper.copyCompSysParamToPartner(cityId, compId, Collections.singletonList(partnerId), sysParams);
    }


    private void writeAddPartnerLog(String content, AddPartnerParam op, ErpFunPartner updated, Integer partnerId) {
        String newJson = JSON.toJSONString(updated);
        ErpFunPartnerLog log = new ErpFunPartnerLog();
        log.setPartnerId(partnerId);
        log.setCompId(op.getCompId());
        log.setModular((byte) 0);
        log.setCreateUid(op.getUserId());
        log.setAfterModification(newJson);
        log.setLogContent(content);
        log.setCreateTime(new Date());
        log.setShardCityId(op.getCityId());
        erpFunPartnerLogMapper.insertSelective(log);
    }

    /**
     * 无限组织机构下添加加盟分组
     * 1.当前是否是第一次添加
     * 2.只能第一次添加能修改层级
     * @param param p
     * @return
     */
    @Transactional
    @Override
    public ErpFunPartner addPartnerForNewOrg(AddPartnerParam param) {
        //c.写数据记录，写日志
        //若partnerLevel不为空，判断公司下已有的加盟商是否符合该层级
        ErpFunOrganizationDefinitionExample ode = new ErpFunOrganizationDefinitionExample();
        ode.setShardCityId(param.getCityId());
        ode.createCriteria().andCompIdEqualTo(param.getCompId()).andPartnerLevelEqualTo(Byte.valueOf("1"));
        List<ErpFunOrganizationDefinition> list = erpFunOrganizationDefinitionMapper.selectByExample(ode);
        if (list.isEmpty()) {
            Assert.isNullThrow(param.getPartnerLevel(),"请先选择组织分组层级,再添加分组");
            //添加新的加盟层级标记
            erpFunOrganizationDefinitionMapper.updateSetPartnerLevelFlag(param.getCityId(), param.getCompId(), param.getPartnerLevel());
        }else{
            if (!Objects.equals(list.get(0).getDefinitionLevel(), param.getPartnerLevel())) {
                //已添加的分组
                ErpFunPartnerExample ex = new ErpFunPartnerExample();
                ex.setShardCityId(param.getCityId());
                ex.createCriteria().andCompIdEqualTo(param.getCompId());
                int count = erpFunPartnerMapper.countByExample(ex);
                Optional.of(count).filter(e -> e == 0).orElseThrow(() -> new BusinessException("已设置分组!"));
                //原先有加盟层级标记 但是没有添加加盟商 可修改加盟商所在层级
                //原层级上标记取消
                ErpFunOrganizationDefinition updateModel = new ErpFunOrganizationDefinition();
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerLevel(Byte.valueOf("0"));
                updateModel.setDefinitionId(list.get(0).getDefinitionId());
                erpFunOrganizationDefinitionMapper.updateByPrimaryKeySelective(updateModel);
                //添加新的加盟层级标记
                erpFunOrganizationDefinitionMapper.updateSetPartnerLevelFlag(param.getCityId(), param.getCompId(), param.getPartnerLevel());
            }
        }
        //添加组织分组记录
        return addPartner(param);
    }
}

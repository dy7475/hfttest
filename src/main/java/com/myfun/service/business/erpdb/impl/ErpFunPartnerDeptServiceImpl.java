package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerOrgParam;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerDeptMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerOrgMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunPartner;
import com.myfun.repository.erpdb.po.ErpFunPartnerDept;
import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.erpdb.po.ErpFunPartnerOrg;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.BaseService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpFunPartnerDeptService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.utils.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Date: 2019/11/11 19:22
 * @Description:
 */
@Service
public class ErpFunPartnerDeptServiceImpl extends AbstractService<ErpFunPartnerDept, ErpFunPartnerDept> implements ErpFunPartnerDeptService {


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
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunPartnerOrgMapper erpFunPartnerOrgMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private CacheUtil cacheUtil;

    @PostConstruct
    @Override
    public void setBaseMapper() {
        super.baseMapper = erpFunPartnerDeptMapper;
    }

    /**
     * 修改加盟信息
     *
     * @param param p
     */
    @Transactional
    public void updatePartnerInfo(PartnerDeptsParam param) {
        //
        ErpFunDepts deptRecord = erpFunDeptsMapper.getDeptByCompIdAndDeptId(param.getCityId(), param.getCompId(), param.getDeptId());
        Assert.isNullThrow(deptRecord, "未找门店信息!");
        //没有执行类型 0.直营，1.加盟,2.总部
        if (!Objects.equals(param.getPartnerType(), (byte) 0) && !Objects.equals(param.getPartnerType(), (byte) 1) &&
                !Objects.equals(param.getPartnerType(), (byte) 2)) {
        }
        //	直营加盟经营模式时修改门店下的经纪人标记。
        ErpFunPartnerDept partnerDept = erpFunPartnerDeptMapper.selectByDeptId(param.getCityId(), param.getCompId(), param.getDeptId());
        byte newType = param.getPartnerType();
        byte oldType = Optional.ofNullable(partnerDept).map(ErpFunPartnerDept::getPartnerType).orElse((byte) -1);
        Date now = new Date();
        if (Objects.isNull(partnerDept)) {//设置门店为加盟商或总部
            insertJoinAndHeadDept(param, newType);
        } else if (oldType != newType) {//切换运营模式
            changeDeptRunMode(param, partnerDept, newType, oldType);
        } else if (oldType == 1) {//改加盟圈ID
            changePartnerId(param, partnerDept);
        }
    }


    private void changePartnerId(PartnerDeptsParam param, ErpFunPartnerDept partnerDept) {
        ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
        Assert.isNullThrow(partner, "分组不存在!");
        if (Objects.equals(partnerDept.getPartnerId(), param.getPartnerId())) {
            return;
        }
        ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
        BeanUtils.copyProperties(partnerDept, updateModel);
        updateModel.setShardCityId(param.getCityId());
        updateModel.setPartnerId(param.getPartnerId());
        Optional.ofNullable(param.getCooperateStartTime()).ifPresent(updateModel::setCooperateStartTime);
        Optional.ofNullable(param.getCooperateEndTime()).ifPresent(updateModel::setCooperateEndTime);
        updateModel.setUpdateTime(new Date());
        erpFunPartnerDeptMapper.updateByPrimaryKeySelective(updateModel);
        writeLog(param, partnerDept, updateModel);
        synPartnerId(param, partner.getId());
    }

    private void changeDeptRunMode(PartnerDeptsParam param, ErpFunPartnerDept partnerDept, byte newType, byte oldType) {
        if (oldType == 1) {//加盟 -->直营|总店
            ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
            BeanUtils.copyProperties(partnerDept, updateModel);
            updateModel.setShardCityId(param.getCityId());
            updateModel.setUpdateTime(new Date());
            updateModel.setCooperateStartTime(null);
            updateModel.setCooperateEndTime(null);
            if (newType == 0) {//直营
                param.setPartnerId(-1);
                updateModel.setPartnerType((byte) 0);
                updateModel.setPartnerId(-1);
            } else if (newType == 2) {//总部
                param.setPartnerId(0);
                updateModel.setPartnerType((byte) 0);
                updateModel.setPartnerId(0);
            }
            erpFunPartnerDeptMapper.updateByPrimaryKey(updateModel);
            writeLog(param, partnerDept, updateModel);
            synPartnerId(param, param.getPartnerId());
        } else if (oldType == 0) {//直营-->加盟|总店
            if (newType == 1) {//加盟
                //从直营置位加盟模式
                ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
                Assert.isNullThrow(partner, "分组不存在!");
                ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(param.getPartnerId());
                updateModel.setPartnerType(newType);
                updateModel.setCooperateStartTime(param.getCooperateStartTime());
                updateModel.setCooperateEndTime(param.getCooperateEndTime());
                updateModel.setUpdateTime(new Date());
                erpFunPartnerDeptMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                synPartnerId(param, param.getPartnerId());
            } else if (newType == 2) {//总店
                param.setPartnerId(0);
                ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(0);
                updateModel.setPartnerType(newType);
                updateModel.setUpdateTime(new Date());
                erpFunPartnerDeptMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                synPartnerId(param, param.getPartnerId());
            }
        } else if (oldType == 2) {//总店-->直营|加盟
            if (newType == 0) {//直营
                param.setPartnerId(-1);
                ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(-1);
                updateModel.setPartnerType(newType);
                updateModel.setUpdateTime(new Date());
                erpFunPartnerDeptMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                synPartnerId(param, param.getPartnerId());
            } else if (newType == 1) {//加盟
                //从总店置位加盟模式
                ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
                Assert.isNullThrow(partner, "分组不存在!");
                ErpFunPartnerDept updateModel = new ErpFunPartnerDept();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(param.getPartnerId());
                updateModel.setPartnerType(newType);
                updateModel.setCooperateStartTime(param.getCooperateStartTime());
                updateModel.setCooperateEndTime(param.getCooperateEndTime());
                updateModel.setUpdateTime(new Date());
                erpFunPartnerDeptMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                synPartnerId(param, param.getPartnerId());
            }
        }
    }

    private void insertJoinAndHeadDept(PartnerDeptsParam param, byte newType) {
        if (newType == 1) {
            //从直营置位加盟模式
            ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
            Assert.isNullThrow(partner, "分组不存在!");
            ErpFunPartnerDept insertModel = new ErpFunPartnerDept();
            insertModel.setShardCityId(param.getCityId());
            insertModel.setPartnerId(param.getPartnerId());
            insertModel.setDeptId(param.getDeptId());
            insertModel.setCompId(param.getCompId());
            insertModel.setPartnerType(newType);
            insertModel.setCooperateStartTime(param.getCooperateStartTime());
            insertModel.setCooperateEndTime(param.getCooperateEndTime());
            insertModel.setCreateTime(new Date());
            insertModel.setUpdateTime(new Date());
            erpFunPartnerDeptMapper.insertSelective(insertModel);
            writeLog(param, null, insertModel);
            synPartnerId(param, param.getPartnerId());
        } else if (newType == 2) {
            ErpFunPartnerDept insertModel = new ErpFunPartnerDept();
            insertModel.setShardCityId(param.getCityId());
            insertModel.setPartnerId(0);
            insertModel.setDeptId(param.getDeptId());
            insertModel.setCompId(param.getCompId());
            insertModel.setPartnerType(newType);
            insertModel.setCreateTime(new Date());
            insertModel.setUpdateTime(new Date());
            erpFunPartnerDeptMapper.insertSelective(insertModel);
            writeLog(param, null, insertModel);
            synPartnerId(param, 0);
        }
        //直营不修改数据
    }


    private void synPartnerId(PartnerDeptsParam param, Integer newPartnerId) {
        if (param.getPartnerType() == 0) {
            param.setPartnerId(-1);
        } else if (param.getPartnerType() == 2) {
            param.setPartnerId(0);
        }
        erpFunPartnerDeptMapper.updatePartnerId(param.getCityId(), param.getCompId(), param.getDeptId(), newPartnerId);
        //异步删除缓存会话标记
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                erpFunUsersService.endLoginDeptUser(param.getCityId(), param.getCompId(), param.getDeptId(), Const.LogInEnum.DEPT_CHANGE);
                updatePartnerDeptRelativeId(param.getCityId(), param.getCompId(), param.getDeptId(), param.getPartnerId());
            }
        });
    }

    public void updatePartnerDeptRelativeId(Integer cityId, Integer compId, Integer deptId, Integer newPartnerId) {
        //erp库相关表更新
        try {
            erpFunPartnerDeptMapper.updateRelativeTablePartnerId(cityId, compId, deptId, newPartnerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //房客源
        try {
            reportFunSaleMinMapper.updatePartnerId(cityId, compId, deptId, newPartnerId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void writeLog(PartnerDeptsParam param, ErpFunPartnerDept old, ErpFunPartnerDept model) {
        ErpFunPartnerLog log = new ErpFunPartnerLog();
        BeanUtils.copyProperties(model, log);
        log.setModular((byte) 2);//门店修改
        ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getDeptId());
        String oldType = Optional.ofNullable(old).map(ErpFunPartnerDept::getPartnerType).map(this::getType).orElse("直营");
        String content = String.format("%s 修改门店 %s [%s]->[%s]模式", param.getUserName(), funDepts.getDeptName(), oldType, getType(model.getPartnerType()));
        log.setLogContent(content);
        log.setCreateUid(param.getSelfUserId());
        log.setBeforeModification(JSON.toJSONString(old));
        log.setAfterModification(JSON.toJSONString(model));
        log.setCreateTime(new Date());
        log.setShardCityId(param.getCityId());
        erpFunPartnerLogMapper.insertSelective(log);
    }

    private String getType(Byte type) {
        switch (type) {
            case 2:
                return "总店";
            case 1:
                return "加盟";
            default:
                return "直营";
        }
    }
    //-------------------------------------------------------------------------------------------------------
    //----------------------------------------------组织机构加盟商--------------------------------------------
    //-------------------------------------------------------------------------------------------------------

    @Override
    public void updateOrgPartnerInfo(PartnerOrgParam param) {
        //
        ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(param.getCityId(), param.getCompId(), param.getOrganizationId());
        Assert.isNullThrow(organization, "未找部门信息!");
        //没有执行类型 0.直营，1.加盟,2.总部
        if (!Objects.equals(param.getPartnerType(), (byte) 0) && !Objects.equals(param.getPartnerType(), (byte) 1) &&
                !Objects.equals(param.getPartnerType(), (byte) 2)) {
        }
        //	直营加盟经营模式时修改门店下的经纪人标记。

        ErpFunPartnerOrg partnerOrg = erpFunPartnerOrgMapper.selectByOrgId(param.getCityId(), param.getCompId(), param.getOrganizationId());
        byte newType = param.getPartnerType();
        byte oldType = Optional.ofNullable(partnerOrg).map(ErpFunPartnerOrg::getPartnerType).orElse((byte) -1);
        Date now = new Date();
        if (Objects.isNull(partnerOrg)) {//设置门店为加盟商或总部
            insertJoinAndHeadDept(param, newType);
        } else if (oldType != newType) {//切换运营模式
            changeDeptRunMode(param, partnerOrg, newType, oldType);
        } else if (oldType == 1) {//改加盟圈ID
            changePartnerId(param, partnerOrg);
        }
    }


    /**
     * 新增
     * @param param
     * @param newType
     */
    private void insertJoinAndHeadDept(PartnerOrgParam param, byte newType) {
        if (newType == 1) {
            //从直营置位加盟模式
            ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
            Assert.isNullThrow(partner, "分组不存在!");
            ErpFunPartnerOrg insertModel = new ErpFunPartnerOrg();
            insertModel.setShardCityId(param.getCityId());
            insertModel.setPartnerId(param.getPartnerId());
            insertModel.setOrganizationId(param.getOrganizationId());
            insertModel.setCompId(param.getCompId());
            insertModel.setPartnerType(newType);
            insertModel.setCooperateStartTime(param.getCooperateStartTime());
            insertModel.setCooperateEndTime(param.getCooperateEndTime());
            insertModel.setCreateTime(new Date());
            insertModel.setUpdateTime(new Date());
            erpFunPartnerOrgMapper.insertSelective(insertModel);
            writeLog(param, null, insertModel);
            orgUpdateRelatePartnerId(param, param.getPartnerId());
        } else if (newType == 2) {
            ErpFunPartnerOrg insertModel = new ErpFunPartnerOrg();
            insertModel.setShardCityId(param.getCityId());
            insertModel.setPartnerId(0);
            insertModel.setOrganizationId(param.getOrganizationId());
            insertModel.setCompId(param.getCompId());
            insertModel.setPartnerType(newType);
            insertModel.setCreateTime(new Date());
            insertModel.setUpdateTime(new Date());
            erpFunPartnerOrgMapper.insertSelective(insertModel);
            writeLog(param, null, insertModel);
            orgUpdateRelatePartnerId(param, 0);
        }
        //直营不修改数据
    }


    /**
     * 切换模式
     * @param param
     * @param partnerDept
     * @param newType
     * @param oldType
     */
    private void changeDeptRunMode(PartnerOrgParam param, ErpFunPartnerOrg partnerDept, byte newType, byte oldType) {
        if (oldType == 1) {//加盟 -->直营|总店
            ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
            BeanUtils.copyProperties(partnerDept, updateModel);
            updateModel.setShardCityId(param.getCityId());
            updateModel.setUpdateTime(new Date());
            updateModel.setCooperateStartTime(null);
            updateModel.setCooperateEndTime(null);
            if (newType == 0) {//直营
                param.setPartnerId(-1);
                updateModel.setPartnerType((byte) 0);
                updateModel.setPartnerId(-1);
            } else if (newType == 2) {//总部
                param.setPartnerId(0);
                updateModel.setPartnerType((byte) 0);
                updateModel.setPartnerId(0);
            }
            erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
            writeLog(param, partnerDept, updateModel);
            orgUpdateRelatePartnerId(param, param.getPartnerId());
        } else if (oldType == 0) {//直营-->加盟|总店
            if (newType == 1) {//加盟
                //从直营置位加盟模式
                ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
                Assert.isNullThrow(partner, "分组不存在!");
                ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(param.getPartnerId());
                updateModel.setPartnerType(newType);
                updateModel.setCooperateStartTime(param.getCooperateStartTime());
                updateModel.setCooperateEndTime(param.getCooperateEndTime());
                updateModel.setUpdateTime(new Date());
                erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                orgUpdateRelatePartnerId(param, param.getPartnerId());
            } else if (newType == 2) {//总店
                param.setPartnerId(0);
                ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(0);
                updateModel.setPartnerType(newType);
                updateModel.setUpdateTime(new Date());
                erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                orgUpdateRelatePartnerId(param, param.getPartnerId());
            }
        } else if (oldType == 2) {//总店-->直营|加盟
            if (newType == 0) {//直营
                param.setPartnerId(-1);
                ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(-1);
                updateModel.setPartnerType(newType);
                updateModel.setUpdateTime(new Date());
                erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                orgUpdateRelatePartnerId(param, param.getPartnerId());
            } else if (newType == 1) {//加盟
                //从总店置位加盟模式
                ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
                Assert.isNullThrow(partner, "分组不存在!");
                ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
                BeanUtils.copyProperties(partnerDept, updateModel);
                updateModel.setShardCityId(param.getCityId());
                updateModel.setPartnerId(param.getPartnerId());
                updateModel.setPartnerType(newType);
                updateModel.setCooperateStartTime(param.getCooperateStartTime());
                updateModel.setCooperateEndTime(param.getCooperateEndTime());
                updateModel.setUpdateTime(new Date());
                erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
                writeLog(param, partnerDept, updateModel);
                orgUpdateRelatePartnerId(param, param.getPartnerId());
            }
        }
    }


    /**
     * 更改加盟商
     * @param param
     * @param partnerDept
     */
    private void changePartnerId(PartnerOrgParam param, ErpFunPartnerOrg partnerDept) {
        ErpFunPartner partner = erpFunPartnerMapper.selectById(param.getCityId(), param.getCompId(), param.getPartnerId());
        Assert.isNullThrow(partner, "分组不存在!");
        if (Objects.equals(partnerDept.getPartnerId(), param.getPartnerId())) {
            return;
        }
        ErpFunPartnerOrg updateModel = new ErpFunPartnerOrg();
        BeanUtils.copyProperties(partnerDept, updateModel);
        updateModel.setShardCityId(param.getCityId());
        updateModel.setPartnerId(param.getPartnerId());
        Optional.ofNullable(param.getCooperateStartTime()).ifPresent(updateModel::setCooperateStartTime);
        Optional.ofNullable(param.getCooperateEndTime()).ifPresent(updateModel::setCooperateEndTime);
        updateModel.setUpdateTime(new Date());
        erpFunPartnerOrgMapper.updateByPrimaryKey(updateModel);
        writeLog(param, partnerDept, updateModel);
        orgUpdateRelatePartnerId(param, partner.getId());
    }

    private void writeLog(PartnerOrgParam param, ErpFunPartnerOrg old, ErpFunPartnerOrg model) {
        ErpFunPartnerLog log = new ErpFunPartnerLog();
        BeanUtils.copyProperties(model, log);
        log.setModular((byte) 2);//修改部门
        ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(param.getCityId(), param.getCompId(), param.getOrganizationId());
        String oldType = Optional.ofNullable(old).map(ErpFunPartnerOrg::getPartnerType).map(this::getType).orElse("直营");
        String content = String.format("%s 修改门店 %s [%s]->[%s]模式", param.getUserName(), organization.getOrganizationName(), oldType, getType(model.getPartnerType()));
        log.setLogContent(content);
        log.setCreateUid(param.getSelfUserId());
        log.setBeforeModification(JSON.toJSONString(old));
        log.setAfterModification(JSON.toJSONString(model));
        log.setCreateTime(new Date());
        log.setShardCityId(param.getCityId());
        erpFunPartnerLogMapper.insertSelective(log);
    }



    private void orgUpdateRelatePartnerId(PartnerOrgParam param, Integer newPartnerId) {
        if (param.getPartnerType() == 0) {
            param.setPartnerId(-1);
        } else if (param.getPartnerType() == 2) {
            param.setPartnerId(0);
        }
        //同步修改组织上partner_id
        erpFunPartnerOrgMapper.updatePartnerId(param.getCityId(), param.getCompId(), param.getOrganizationPath(), newPartnerId);
        //异步删除缓存会话标记
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                endLoginDeptUser(param.getCityId(), param.getCompId(), param.getOrganizationPath(), Const.LogInEnum.DEPT_CHANGE);
                updateOrgPartnerDeptRelativeId(param.getCityId(), param.getCompId(), param.getOrganizationPath(), param.getPartnerId());
            }
        });
    }

    /**
     * 更新相关表的partner_id
     * @param cityId
     * @param compId
     * @param orgPath
     * @param newPartnerId
     */
    public void updateOrgPartnerDeptRelativeId(Integer cityId, Integer compId, String orgPath, Integer newPartnerId) {
        //erp库相关表更新
        try {
            erpFunPartnerDeptMapper.updateRelativeTablePartnerId(cityId, 0, 1, newPartnerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //房客源
        try {
            reportFunSaleMinMapper.updateOrgPartnerId(cityId, compId, orgPath, newPartnerId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 清除登录token
     * @param cityId
     * @param compId
     * @param orgPath
     * @param logInEnum
     */
    public void endLoginDeptUser(Integer cityId, Integer compId, String orgPath, Const.LogInEnum logInEnum) {

        ErpFunUsersExample ex = new ErpFunUsersExample();
        ex.setShardCityId(cityId);
        ex.createCriteria().andCompIdEqualTo(compId).andTissueLineLike(orgPath);
        List<ErpFunUsers> deptUserList = erpFunUsersMapper.selectByExample(ex);
        //clienkey来clear
        for (ErpFunUsers erpFunUsers : deptUserList) {
            Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + erpFunUsers.getArchiveId());
            if (loginKey != null) {
                cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
            }
            loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + erpFunUsers.getArchiveId());
            if (loginKey != null) {
                cacheUtil.put(loginKey, logInEnum.getValue(), CacheUtilExt.INVALID_TIME_OUT);
            }
        }
        Set<Integer> collect = deptUserList.stream().map(ErpFunUsers::getArchiveId).collect(Collectors.toSet());
        TaskQueueThread.sendMessageMergeAppRefreshUser(logInEnum, collect.toArray(new Integer[0]));
    }
}

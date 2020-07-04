package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.house.controller.MlEntrustApiController;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpAuditTemplateMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustOwnersMapper;
import com.myfun.repository.erpdb.po.ErpAuditTemplate;
import com.myfun.repository.erpdb.po.ErpFunEntrust;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwnersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunEntrustOwnersService;
import com.myfun.service.business.erpdb.ErpFunEntrustService;
import com.myfun.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 蔡春林
 * @Date 2019/11/26 0026 上午 11:55
 **/
@Service
public class ErpFunEntrustOwnersServiceImpl  extends AbstractService<ErpFunEntrustOwners, ErpFunEntrustOwners> implements ErpFunEntrustOwnersService {
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunentrustOwnersMapper;  
    @Autowired
    private ErpFunEntrustMapper erpFunentrustMapper;
    @Autowired
    private ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpAuditTemplateMapper erpAuditTemplateMapper;
    @Autowired
    private MlEntrustApiController mlEntrustApiController;
    @Autowired
    private ErpFunEntrustService erpFunEntrustService;
    @Override
    public void setBaseMapper() {
        super.baseMapper = erpFunentrustOwnersMapper;
    }

    @Override
    public int updateOwnerSignStatus(Integer cityId, Integer ownerId, Integer entrustId, String signaturePic, ErpFunEntrust erpFunEntrust) {
        //保存当前人的签署图片，并修改签署时间和签署状态
        if (erpFunentrustOwnersMapper.updateByOwnerId(cityId, ownerId, entrustId, signaturePic) <= 0) {
            throw new BusinessException("请勿重复提交！");
        }
        Date date = new Date();
        ErpFunEntrustOwnersExample example = new ErpFunEntrustOwnersExample();
        example.setShardCityId(cityId);
        ErpFunEntrustOwnersExample.Criteria criteria = example.createCriteria();
        criteria.andEntrustIdEqualTo(entrustId);
        criteria.andIsSignEqualTo((byte) 0);
        List<ErpFunEntrustOwners> erpFunentrustOwners = erpFunentrustOwnersMapper.selectByExample(example);
        if (erpFunentrustOwners == null || erpFunentrustOwners.size() <= 0) {
            ErpFunEntrust erpFunEntrustUpdate = new ErpFunEntrust();
            erpFunEntrustUpdate.setShardCityId(cityId);
            erpFunEntrustUpdate.setCityId(cityId);
            erpFunEntrustUpdate.setEntrustId(entrustId);
            erpFunEntrustUpdate.setSignStatus((byte) 1);
            erpFunEntrustUpdate.setSignFinashDate(date);
            // 如果是在待签署的状态下，最后一位业主签约，则将状态更新为正常
            if (erpFunEntrust.getEntrustStatus() == 11) {
                erpFunEntrustUpdate.setEntrustStatus((byte) 1);
            }
    
            // 判断是否配置了审核流程，如果配置了则需要走审核流程，如果没有配置，则不需要审核这个步骤
            ErpAuditTemplate erpAuditTemplate = erpAuditTemplateMapper.selectByAuditType(cityId, erpFunEntrust.getCompId(), (byte) 1, Const.DIC_TRACK_TYPE_ENTRUST_DATA.intValue(), erpFunEntrust.getCaseType().intValue());
            boolean needAudit = false;
            if (null != erpAuditTemplate && erpAuditTemplate.getNeedAudit() == 1) {
                needAudit = true;
            }
            if (!needAudit) { // 没有审核流程，则默认审核通过
                erpFunEntrustUpdate.setShardCityId(cityId);
                erpFunEntrustUpdate.setEntrustId(erpFunEntrust.getEntrustId());
                erpFunEntrustUpdate.setAuditStatus((byte) 2); // 审核状态（0=待审核 1=审核拒绝 2=审核完成）
                erpFunEntrustUpdate.setAuditDate(date);
                erpFunEntrustUpdate.setAuditUserId(999);
                if (null != erpFunEntrust.getEntrustType() && erpFunEntrust.getEntrustType() == 2) { // 独家委托
                    erpFunEntrust.setAuditDate(date);
                    erpFunEntrustService.insertEntrustKpiLog(erpFunEntrust, erpFunEntrust.getCreateTime()); // 这里用委托创建时间，不用签约完毕时间
                }
            }
            
            erpFunentrustMapper.updateByPrimaryKeySelective(erpFunEntrustUpdate);
            return 1;
        }
        return 0;
    }
}

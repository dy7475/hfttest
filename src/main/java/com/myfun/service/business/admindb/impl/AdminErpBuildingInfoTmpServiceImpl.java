package com.myfun.service.business.admindb.impl;

import com.myfun.repository.admindb.dao.AdminErpBuildingInfoTmpMapper;
import com.myfun.repository.admindb.po.AdminErpBuildingInfoTmp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminErpBuildingInfoTmpService;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class AdminErpBuildingInfoTmpServiceImpl extends AbstractService<AdminErpBuildingInfoTmp,Integer> implements AdminErpBuildingInfoTmpService {

    @Autowired
    AdminErpBuildingInfoTmpMapper adminErpBuildingInfoTmpMapper;


    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = adminErpBuildingInfoTmpMapper;
    }


    @Override
    public void updateBuildDicInfo(BuildingInfoTmpParam buildingInfoTmpParam) {
        adminErpBuildingInfoTmpMapper.insertBuilInfoTmp(buildingInfoTmpParam);
    }

}

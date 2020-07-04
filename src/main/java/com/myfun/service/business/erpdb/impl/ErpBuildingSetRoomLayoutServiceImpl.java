package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.businesstools.builddic.param.ErpRegisterBuildingSetRoomLaYouTParam;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildingSetRoomLaYouTListVO;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildingSetRoomLaYouTVO;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.ErpBuildingSetRoomLayoutMapper;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoomLayout;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoomLayoutExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingSetRoomLayoutService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class ErpBuildingSetRoomLayoutServiceImpl extends AbstractService<ErpBuildingSetRoomLayout, ErpBuildingSetRoomLayout> implements ErpBuildingSetRoomLayoutService {

    @Autowired
    private ErpBuildingSetRoomLayoutMapper erpBuildingSetRoomLayoutMapper;
    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildingSetRoomLayoutMapper;
    }


}

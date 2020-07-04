package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpBuildingManagerMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingSetRoofMapper;
import com.myfun.repository.erpdb.param.CreatOrEditManagerParam;
import com.myfun.repository.erpdb.po.ErpBuildingManager;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildingManagerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ErpBuildingManagerServiceImpl extends AbstractService<ErpBuildingManager,ErpBuildingManager> implements ErpBuildingManagerService {

    @Autowired
    ErpBuildingManagerMapper erpBuildingManagerMapper;
    @Autowired
    ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;


    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpBuildingManagerMapper;
    }

    @Transactional
    @Override
    public void creatOrEditManager(CreatOrEditManagerParam param) {
        Integer buildId = param.getBuildId();
        Integer cityId = param.getCityId();
        Integer compId = param.getCompId();
        Integer userId = param.getUserId();

        ErpBuildingManager manager = new ErpBuildingManager();
        manager.setCompId(compId);
        manager.setCityId(cityId);
        manager.setBuildId(buildId);
        manager.setManagerType((byte)1);
        manager.setUserId(userId);
        manager.setCreationTime(new Date());
        manager.setUpdateTime(new Date());
        manager.setCityId(cityId);
        manager.setShardCityId(cityId);
        if (StringUtils.isEmpty(param.getBuildingSetRoofId())) {
            Integer user = erpBuildingManagerMapper.getBuildManageUserId(cityId,buildId,compId);
            if (user == null) {
                erpBuildingManagerMapper.insertManager(manager);
            }else if(!user.equals(userId)){
                erpBuildingManagerMapper.updateManager(cityId,compId,buildId,userId);
            }

            //当变更楼盘责任人时，将没有栋维护人的栋设置为楼盘的责任人
            List<Integer> roofs = erpBuildingSetRoofMapper.getNoManagerRoofs(cityId,compId,buildId);
            if(roofs.size() > 0){
                //添加新的栋座以后，有可能存在已经设置了楼盘责任人，而新的栋没有栋维护人的情况
                Integer buildingManagerId = erpBuildingManagerMapper.getRoofManagerByUserId(cityId,compId,buildId,userId);
                if (buildingManagerId == null) {
                    manager.setManagerType((byte)2);
                    erpBuildingManagerMapper.insertManager(manager);
                    buildingManagerId = manager.getBuildingManagerId();
                }
                //将新添加的栋维护人id设置到栋上
                erpBuildingSetRoofMapper.updateRoofManager(cityId,compId,roofs,buildingManagerId);
            }
        }else {
            Integer count = erpBuildingManagerMapper.ckeckHaveManager(cityId,compId,buildId);
            if (count == 0) {
                //如果该楼盘一个维护人都没设置，首次设置时、将楼盘和所有栋的维护人都设置为该维护人
                erpBuildingManagerMapper.insertManager(manager);
                manager.setManagerType((byte)2);
                erpBuildingManagerMapper.insertManager(manager);
                erpBuildingSetRoofMapper.updateAllRoofManager(cityId,compId,buildId,manager.getBuildingManagerId());
            }else {
                manager.setManagerType((byte)2);
                Integer roofManager = erpBuildingManagerMapper.getRoofManagerByUserId(cityId,compId,buildId,userId);
                if (roofManager == null) {
                    erpBuildingManagerMapper.insertManager(manager);
                    roofManager = manager.getBuildingManagerId();
                }
                List<Integer> roofs = new ArrayList<>();
                String[] ids = param.getBuildingSetRoofId().trim().split(",");
                for (int i=0;i<ids.length;i++){
                    roofs.add(Integer.valueOf(ids[i]));
                }
                erpBuildingSetRoofMapper.updateRoofManager(cityId,compId,roofs,roofManager);
            }
        }
    }

}

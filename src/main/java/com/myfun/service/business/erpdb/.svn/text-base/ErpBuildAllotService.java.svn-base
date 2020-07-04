package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.buildData.param.saveBuildDeptsParam;
import com.myfun.repository.erpdb.po.ErpBroadcast;
import com.myfun.repository.erpdb.po.ErpBroadcastKey;
import com.myfun.repository.erpdb.po.ErpBuildAllot;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @create by 程二狗 on 2019/2/21 0021
 **/
public interface ErpBuildAllotService extends BaseMapper<ErpBuildAllot, ErpBuildAllot> {

    void saveErpBuildAllot(Integer cityId, Integer compId,String userName,Integer userId,String deptName, saveBuildDeptsParam param, boolean newOrg);
}

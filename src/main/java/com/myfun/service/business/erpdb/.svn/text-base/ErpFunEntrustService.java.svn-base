package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.house.param.SaveEntrustInfoParam;
import com.myfun.erpWeb.house.vo.SaveEntrustInfoVO;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.UpdateEntrustRecordParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.po.ErpFunEntrust;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;

/**
 * @author HuangJiang
 * @since 2019年11月25日 17:23:08
 * Modified XXX HuangJiang 2019年11月25日
 */
public interface ErpFunEntrustService extends BaseMapper<ErpFunEntrust, ErpFunEntrust> {
    
    /**
     * 保存委托
     * @author HuangJiang
     * @since 2019年11月25日 17:31
     * @param param
     * @param cityId
     * @param compId
     * @param userId
     * @param deptName
     * @param userName
     * @return void
     * Modified XXX HuangJiang 2019年11月25日
     */
    SaveEntrustInfoVO saveEntrustInfo(SaveEntrustInfoParam param, Integer cityId, Integer compId, Integer userId, String deptName, String userName, String clientKey) throws Exception;
    
    /**
     * 撤销委托
     * @author HuangJiang
     * @since 2019年11月27日 19:15
     * @param userName
     * @param compId
     * @param cityId
     * @param userId
     * @param erpFunEntrust
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    void cancelEntrust(String userName, Integer compId, Integer cityId, Integer userId, ErpFunEntrust erpFunEntrust);
    
    /**
     * 删除委托
     * @author HuangJiang
     * @since 2019年11月27日 19:21
     * @param userName
     * @param compId
     * @param cityId
     * @param userId
     * @param erpFunEntrust
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    void deleteEntrust(String userName, Integer compId, Integer cityId, Integer userId, ErpFunEntrust erpFunEntrust, String clientKey);
    
    /**
     * 修改委托
     * @author HuangJiang
     * @since 2019年11月27日 20:25
     * @param param
     * @param cityId
     * @param compId
     * @param userId
     * @param deptName
     * @param userName
     * @return void
     * Modified XXX HuangJiang 2019年11月27日
     */
    void updateEntrustInfo(SaveEntrustInfoParam param, Integer cityId, Integer compId, Integer userId, String deptName, String userName) throws Exception;
    
    /**
     * 修改备案（添加，修改或清空备案）
     * @author HuangJiang
     * @since 2019年11月28日 13:44
     * @param operator
     * @param erpFunEntrust
     * @param param
     * @return void
     * Modified XXX HuangJiang 2019年11月28日
     */
    void updateEntrustRecord(Operator operator, ErpFunEntrust erpFunEntrust, UpdateEntrustRecordParam param);
    
    /**
     * 插入房产资料KPI数据
     * @detail [2020年04月07日] HuangJiang story#11736 房产资料独家委托新增量统计
     * @author HuangJiang
     * @since 2020年04月07日 18:32
     * @param erpFunEntrust 委托信息
     * @param date 日期
     * @return void
     * Modified XXX HuangJiang 2020年04月07日
     */
    public void insertEntrustKpiLog(ErpFunEntrust erpFunEntrust, Date date);
    
}

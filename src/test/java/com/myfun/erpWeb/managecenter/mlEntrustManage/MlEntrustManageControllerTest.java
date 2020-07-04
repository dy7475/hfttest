package com.myfun.erpWeb.managecenter.mlEntrustManage;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.EntrustAuditDetailParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.SelectEntrusListParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.param.UpdateEntrustRecordParam;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author HuangJiang
 * @since 2019年11月27日 10:54:00
 * Modified XXX HuangJiang 2019年11月27日
 */
public class MlEntrustManageControllerTest extends BaseTestController {
    
    @Before
    public void init(){
        initNew("http://192.168.200.155:8068/erpWeb", "http://192.168.200.155:8068/erpWeb/usercenter/session/openLogin", "15124242424", "123456");
    }
    
    /**
     * 管理中心-委托列表
     * @author HuangJiang
     * @since 2019年11月28日 11:38
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月28日
     */
    @Test
    public void selectEntrusList() throws Exception {
        SelectEntrusListParam param = new SelectEntrusListParam();
        param.setIsEffective((byte) 1); // 是否有效（1=有效；0=无效）
        param.setUserType(1); // 人员类型 1=申请人，2=审核人，3=备案人
        //param.setCompId(47735);
        //param.setAreaId(19994);
        //param.setRegId(47265);
        //param.setDeptId(894133);
        //param.setGrId(253422);
        //param.setUserId(20331726);
        
        String result = postNewErp(param, "/manageCenter/mlEntrustManage/selectEntrusList");
        System.out.println(result);
    }
    
    /**
     * 委托审核详情
     * @author HuangJiang
     * @since 2019年11月28日 11:38
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月28日
     */
    @Test
    public void entrustAuditDetail() throws  Exception {
        EntrustAuditDetailParam param = new EntrustAuditDetailParam();
        param.setEntrustId(9);
        String result = postNewErp(param, "/manageCenter/mlEntrustManage/entrustAuditDetail");
        System.out.println(result);
    }
    
    /**
     * 修改备案（添加，修改或清空备案）
     * @author HuangJiang
     * @since 2019年11月28日 11:45
     * @param 
     * @return void
     * Modified XXX HuangJiang 2019年11月28日
     */
    @Test
    public void updateEntrustRecord() throws  Exception {
        UpdateEntrustRecordParam param = new UpdateEntrustRecordParam();
        param.setEntrustId(89);
        param.setOperateType(1); // 操作类型 1=添加备案 2=修改备案 3=清空备案
        param.setRecordUser(20331561);
        param.setRecordTime(new Date());
        param.setRecordNo("NBA20191202165500");
        String result = postNewErp(param, "/manageCenter/mlEntrustManage/updateEntrustRecord");
        System.out.println(result);
    }
}

package com.myfun.erpWeb.app;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.app.param.AppAchieveMonthStatisticsRankDetailParam;
import com.myfun.erpWeb.app.param.AppAchieveStatisticsCountTotalParam;
import com.myfun.erpWeb.common.param.AddSubOrganizationParam;
import com.myfun.erpWeb.common.param.UpdateChileCompParam;
import com.myfun.erpWeb.common.vo.AddSubOrganizationVO;
import com.myfun.erpWeb.managecenter.sysmanager.param.GetPartnerDeptListParam;
import com.myfun.erpWeb.openApi.user.param.UpdateOrgUserNumParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.bean.TBDefinetion;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import javax.validation.Valid;

public class AppOperateCenterControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.200.101:8081/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
	}
	
	/**
	 * 掌通运营分析排行榜房增、客增、带看、钥匙、房勘总量
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	@Test
	public void getStatisticsRankCountTotal() throws Exception {
		AppAchieveStatisticsCountTotalParam param = new AppAchieveStatisticsCountTotalParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		System.out.println(postNewErp(param, "/appOperateCenter/getStatisticsRankCountTotal"));
	}
	
	@Test
	public void getAppAchieveMonthStatisticsRankDetailHouseAdd() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		param.setCaseType(1);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailHouseAdd"));
	}
	
	@Test
	public void getAppAchieveMonthStatisticsRankDetailCustomerAdd() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		param.setCaseType(3);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailCustomerAdd"));
	}
	
	@Test
	public void getAppAchieveMonthStatisticsRankDetailYs() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		param.setCaseType(1);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailYs"));
	}
	
	@Test
	public void getAppAchieveMonthStatisticsRankDetailFunCan() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		param.setCaseType(1);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailFunCan"));
	}

	@Test
	public void getAppAchieveMonthStatisticsRankDetailDk() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(2);
		param.setLookTypeId(17179);
		param.setAssessmentMonth("2018-10-01");
		param.setDeptId(888227);
		param.setCaseType(4);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailDk"));
	}
	@Test
	public void getAppAchieveMonthStatisticsRankDetailYk() throws Exception {
		AppAchieveMonthStatisticsRankDetailParam param = new AppAchieveMonthStatisticsRankDetailParam();
		param.setLookType(3);
		param.setLookTypeId(45363);
		param.setAssessmentMonth("2019-05-01");
		param.setDeptId(892130);
		param.setCaseType(3);
		System.out.println(postNewErp(param, "/appOperateCenter/getAppAchieveMonthStatisticsRankDetailYk"));
	}
	@Test
	public void getDeptListByPartnerId() throws Exception {
		GetPartnerDeptListParam param = new GetPartnerDeptListParam();
		param.setCountUser(1);
		param.setPartnerId(-1);
		System.out.println(postNewErp(param, "/managerCenter/organization/getDeptListByPartnerId"));
	}
	
	@Test
    public void createComp(){
	    UpdateChileCompParam param = new UpdateChileCompParam();
	    param.setCityId(11);
	    param.setCompName("深证美联");
	    param.setContactAddress("深证美联");
	    param.setContactPhoneNumber("13551527615");
	    param.setMainComp(1);
	    param.setUserName("深证负责人");
	    param.setUserMobile("13551527615");
	    String result = HttpUtil.postJson("http://localhost:8068/erpWeb/openApi/user/createComp", param);
	    System.out.println(result);
    }
	
	@Test
    public void createOrg(){
	    AddSubOrganizationParam param = new AddSubOrganizationParam();
	    param.setCityId(11);
	    param.setCompId(47984);
	    param.setPid(0);
	    param.setOrganizationBussinessType(1);
	    param.setDefinitionId(645);
	    param.setOrganizationName("罗湖 - 幸福里第二分行");
	    param.setOrganizationAddr("罗湖 - 幸福里第二分行");
	    //param.setAdminUserId(adminUserId);
        String result = HttpUtil.postJson("http://localhost:8068/erpWeb/openApi/user/addSubOrganization", param);
        System.out.println(result);
    }

	@Test
    public void updateOrgUserNum(){
		UpdateOrgUserNumParam param = new UpdateOrgUserNumParam();
		param.setCityId(1);
		param.setCompId(47938);
//		param.setMovePath(":894629:205002:205194::205195:");
	    //param.setAdminUserId(adminUserId);
        String result = HttpUtil.post("http://localhost:8068/erpWeb/openApi/user/updateOrgUserNum", param);
        System.out.println(result);
    }

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		ErpFunLease erpFunLease = new ErpFunLease();
		Map<String, String> saleLeaseTransferMap = TBDefinetion.getSaleLeaseTransferMap(Constants_DIC.DIC_CASE_TYPE_SALE_FUN);
		Map<String, String> updateMap = new HashMap<String, String>();
		for (Entry<String, String> entry : saleLeaseTransferMap.entrySet()) {
			String fieldValue = BeanUtils.getProperty(erpFunLease, entry.getKey());
			if(StringUtils.isBlank(fieldValue)) {
				fieldValue = null;
			}
			updateMap.put(entry.getValue(), fieldValue);
		}
	}
}

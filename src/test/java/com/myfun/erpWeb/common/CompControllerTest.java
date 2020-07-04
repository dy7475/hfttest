package com.myfun.erpWeb.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.common.param.GetAppInitDataWithSessionParam;
import com.myfun.erpWeb.common.param.OrganizationDataListParam;
import com.myfun.erpWeb.common.param.UpdateCompCustomerPropertuParam;
import com.myfun.repository.admindb.po.AdminFunCompSkin;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringHelper;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompControllerTest extends BaseTestController{
	
	@Before
	public void init(){
		init("http://localhost:8068/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do",
				"1281228", "15182721203");

	}

	@Test
	public void getCompDefineTemplateData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("type", "CHARACT");
		pMap.put("caseType", "1");
		pMap.put("queryType", "0");
		pMap.put("qtype", "1");
		System.err.println(postNewErp(pMap,"/common/getCompDefineTemplateData"));
	}
	@Test
	public void getComTemplateData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("useage", "1");
		pMap.put("types", "NONE");
		pMap.put("caseType", "1");
		System.err.println(postNewErp(pMap,"/common/getComTemplateData"));
	}

	// {","UPDATE_TAXES_TIME":"2018-09-27 16:04:11","UPDATE_TIME":"2018-11-06 15:17:57.510"}
	@Test
	public void getAppInitData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compId", 46470);
		pMap.put("cityId", 1);
		pMap.put("deptFlag", 1);
		pMap.put("updateTime", "2019-11-11 15:25:02");
		pMap.put("updateDicTime", "2019-11-11 15:24:22.293");
		System.err.println(postNewErp(pMap,"/common/getAppInitData"));
	}
	
	@Test
	public void getAppInitDataWithSession() throws Exception{
		GetAppInitDataWithSessionParam param = new GetAppInitDataWithSessionParam();
		param.setCityId(1);
		param.setCompId(47889);
		System.err.println(postNewErp(param,"/common/getAppInitDataWithSession"));
	}

	@Test
	public void updateCompCustomerProperty() throws Exception{
		UpdateCompCustomerPropertuParam param = new UpdateCompCustomerPropertuParam();
		List<AdminFunCompSkin> list = new ArrayList<>();
		AdminFunCompSkin adminFunCompSkin = new AdminFunCompSkin();
		adminFunCompSkin.setSkinPicUrl("LCB");
		adminFunCompSkin.setSkinPicUrlType(2);
		adminFunCompSkin.setSkinType("desktopShortcutName");
		list.add(adminFunCompSkin);
		param.setCustomerPropertyList(JSON.toJSONString(list));
		System.err.println(postNewErp(param,"/common/updateCompCustomerProperty"));
	}

	@Test
	public void getPhoneNumber() throws Exception{
		Integer numberType = 0;
		String cellPhone = "&&&手机|||9333>313939545<45;0045&&&";
		String[] phones = StringHelper.split(cellPhone, "&&&");
		String[] phoneValues = StringHelper.split(phones[numberType], "|||");
		String userMobile = EnCodeHelper.decode(phoneValues[1]);
//		System.out.println(userMobile);
		String payUrl = "http://admin.myfun7.com/adminWeb/axbIpCallRecords/createSecretNo";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userMobile", userMobile);
		paramMap.put("customerMobile", "15821850886");
		paramMap.put("cityId", 8);
		paramMap.put("targetId", 8042110);
		paramMap.put("targetType", 1);
//		paramMap.put("entityId", entityId);
		paramMap.put("callType", 1);
		paramMap.put("useDirection", "2");
		// 物业版访客拨打要透传，不扣费
		String payResult = HttpUtil.postJson(payUrl, paramMap);
		if(StringUtils.isNotBlank(payResult)) {
			Map<String, Object> payMap = JSON.parseObject(payResult, new TypeReference<Map<String, Object>>(){});
			String errCode = String.valueOf(payMap.get("errCode"));
			if("200".equals(errCode)) {
				Object data = payMap.get("data");
				if(Map.class.isAssignableFrom(data.getClass())) {
					@SuppressWarnings("unchecked")
					Map<String, Object> dataMap = (Map<String, Object>) data;
					String phoneX = String.valueOf(dataMap.get("phoneX"));
					System.out.println(phoneX);
				}
			}
		}
	}


	@Test
	public void getOrganizationDataList() throws Exception{
		OrganizationDataListParam param = new OrganizationDataListParam();
		System.err.println(postNewErp(param,"/common/getOrganizationDataList"));
	}

	@Test
	public void getOrganizationDefinitionList() throws Exception{
		OrganizationDataListParam param = new OrganizationDataListParam();
		System.err.println(postNewErp(param,"/common/getOrganizationDefinitionList"));
	}

}

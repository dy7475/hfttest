/**
 * @author 方李骥
 * @since 2016年9月5日
 */
package com.myfun.erpWeb.businesstools.natureTemplet;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.BorrowKeyParam;
import com.myfun.repository.erpdb.po.ErpFunNatureTemplet;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;
import com.myfun.service.business.erpdb.bean.param.ErpFunKeyParam;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FunNatureTempletControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.11.101:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
	}

	/**
	 * title ：税费模板列表
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@Test
	public void getNatureTempletList() throws Exception{
		ErpFunKeyParam	param = new ErpFunKeyParam();
		System.out.println(postNewErp(param,"businesstools/natureFeeModule/getNatureTempletList"));
	}

	/**
	 * title ：添加编辑模板
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@Test
	public void addOrEditNatureTemplet() throws Exception{
		ErpFunNatureTemplet erpFunNatureTemplet = new ErpFunNatureTemplet();
		// erpFunNatureTemplet.setId(26);
		erpFunNatureTemplet.setBuyNature(new Byte("1"));
		erpFunNatureTemplet.setFunNature(new Byte("1"));
		erpFunNatureTemplet.setGsRate(new BigDecimal("22"));
		erpFunNatureTemplet.setGsType(new Byte("1"));
		erpFunNatureTemplet.setLandCardFee(new BigDecimal("2"));
		erpFunNatureTemplet.setQsRate(new BigDecimal("2"));
		erpFunNatureTemplet.setRegFee(new BigDecimal("2"));
		erpFunNatureTemplet.setServerFee(new BigDecimal("2"));
		erpFunNatureTemplet.setServerType(new Byte("2"));
		erpFunNatureTemplet.setTaxName("cewccwecwec");
		erpFunNatureTemplet.setTradeFee(new BigDecimal("2"));
		erpFunNatureTemplet.setTransferFee(new BigDecimal("4"));
		erpFunNatureTemplet.setYearNature(new Byte("3"));
		erpFunNatureTemplet.setYhRate(new BigDecimal("423"));
		erpFunNatureTemplet.setZzsRate(new BigDecimal("5234"));
		erpFunNatureTemplet.setZzsType(new Byte("6"));


		List<Map<String, Object>> paramList = new ArrayList<>();
		Map<String, Object> p = new HashMap<>();
		p.put("name", "李成兵");
		List<Map<String, Object>> paramList2 = new ArrayList<>();
		Map<String, Object> p2 = new HashMap<>();
		p2.put("p1", "2222");
		p2.put("p2", "3333");
		paramList2.add(p2);
		p.put("extParam", paramList2);
		paramList.add(p);
		erpFunNatureTemplet.setExtParam(JSON.toJSONString(paramList));
		System.out.println(postNewErp(erpFunNatureTemplet,"businesstools/natureFeeModule/addOrEditNatureTemplet"));
	}

}

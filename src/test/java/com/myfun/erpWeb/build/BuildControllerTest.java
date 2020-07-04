package com.myfun.erpWeb.build;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.bean.TBDefinetion;

public class BuildControllerTest {
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		ErpFunLease erpFunLease = new ErpFunLease();
		BeanUtils.copyProperty(erpFunLease, "leaseFloor", 1);
		System.out.println(erpFunLease.getLeaseFloor());
		
		Map<String, String> saleLeaseTransferMap = TBDefinetion.getSaleLeaseTransferMap(Constants_DIC.DIC_CASE_TYPE_SALE_FUN);
		for (Entry<String, String> entry : saleLeaseTransferMap.entrySet()) {
			System.out.println(entry);
		}
	}

}

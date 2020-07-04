package com.myfun.erpWeb.openApi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunUserMessageMapper;
import com.myfun.repository.erpdb.dao.ErpFunCoreInfoMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunCoreInfo;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;

/**
 * 重新生成房源MD5和单元
 * @author 张宏利
 * @since 2017年1月17日
 */
@Controller
@RequestMapping(value = "/openApi/updateFunHouseInfoUnit")
public class UpdateFunHouseInfoUnitController extends BaseController {

	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	AdminFunUserMessageMapper adminFunUserMessageMapper;
	@Autowired
	ErpFunCoreInfoMapper erpFunCoreInfoMapper;

	public static Map<String, String> coreInfoTypeMap = new HashMap<>();

	public static int switchFlag = 0;

	/**
	 * 控制开关
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/switchUpdate")
	public String stopUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		switchFlag = StringUtil.paseInteger(request.getParameter("switch"), 1);// // 控制开关
		return ErpResponseJson.ok().toJson();
	}

	/**
	 * 重新生成房源MD5和单元
	 *
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateHouseInfo")
	public String updateHouseUnit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		for (int i = 0; i < configs.size(); i++) {
			String dbName = configs.get(i);
//			String dbName = "hft_erpdb_CD";
			new UpdateSaleUnitThread(dbName).start();
			new UpdateLeaseUnitThread(dbName).start();
		}
		return new ErpResponseJson().toJson();
	}

	class UpdateSaleUnitThread extends Thread {
		String dbName = null;

		public UpdateSaleUnitThread(String dbName) {
			this.dbName = dbName;
		}

		@Override
		public void run() {
			while (true) {
				// 增加开关
				if (1 == switchFlag) {
					break;
				}
				List<ErpFunSale> saleList = erpFunSaleMapper.getNeedDealUnitList(dbName);
				if (saleList == null || saleList.isEmpty()) {
					break;
				}
				for (ErpFunSale funSalePO : saleList) {
					String decode = EnCodeHelper.decode(funSalePO.getUnitFloor());// 先解密
					ErpFunCoreInfo erpFunCoreInfo = new ErpFunCoreInfo();
					erpFunCoreInfo.setHouseFloor(decode);
					erpFunCoreInfo.setId(funSalePO.getSaleId());// 查询的时候用saleId存的coreInfo的ID
					erpFunCoreInfo.setShardDbName(dbName);
					erpFunCoreInfoMapper.updateByPrimaryKeySelective(erpFunCoreInfo);
				}
			}
		}
	}

	class UpdateLeaseUnitThread extends Thread {
		String dbName = null;

		public UpdateLeaseUnitThread(String dbName) {
			this.dbName = dbName;
		}

		@Override
		public void run() {
			while (true) {
				// 增加开关
				if (1 == switchFlag) {
					break;
				}
				List<ErpFunLease> leaseList = erpFunLeaseMapper.getNeedDealUnitList(dbName);
				if (leaseList == null || leaseList.isEmpty()) {
					break;
				}
				for (ErpFunLease erpFunLease : leaseList) {
					String decode = EnCodeHelper.decode(erpFunLease.getUnitFloor());
					ErpFunCoreInfo erpFunCoreInfo = new ErpFunCoreInfo();
					erpFunCoreInfo.setHouseFloor(decode);
					erpFunCoreInfo.setId(erpFunLease.getLeaseId());// 查询的时候用leaseId存的coreInfo的ID
					erpFunCoreInfo.setShardDbName(dbName);
					erpFunCoreInfoMapper.updateByPrimaryKeySelective(erpFunCoreInfo);
				}
			}
		}
	}
}


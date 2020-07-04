package com.myfun.erpWeb.openApi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
@RequestMapping(value = "/openApi/updateFunHouseInfo")
public class UpdateFunHouseInfoController extends BaseController {

	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunCoreInfoMapper erpFunCoreInfoMapper;
	@Autowired
	AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	AdminFunUserMessageMapper adminFunUserMessageMapper;

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
		Integer compId = StringUtil.paseInteger(request.getParameter("compId"), null);
		String dbNameParam = request.getParameter("dbName");
		List<String> dbList = new LinkedList<String>();
		if(StringUtils.isNotBlank(dbNameParam)) {
			dbList.add(dbNameParam);
		} else {
			dbList = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		}
		for (int i = 0; i < dbList.size(); i++) {
			String dbName = dbList.get(i);
			new UpdateSaleUnitThread(dbName, compId).start();
			new UpdateLeaseUnitThread(dbName, compId).start();
		}
		return new ErpResponseJson().toJson();
	}

	class UpdateSaleUnitThread extends Thread {
		String dbName = null;
		Integer compId = null;

		public UpdateSaleUnitThread(String dbName, Integer compId) {
			this.compId = compId;
			this.dbName = dbName;
		}

		@Override
		public void run() {
			while (true) {
				// 增加开关
				if (1 == switchFlag) {
					break;
				}
				// 查询lock=0的数据
//				List<ErpFunSale> saleList = erpFunSaleMapper.getNeedUpdateHouseUnitList(dbName, 1000, null, 0);
				// 查询unit不为空、unit_t为空的数据
				List<ErpFunSale> saleList = erpFunSaleMapper.getUnitNotEqDecryptList(dbName, 1000, compId);
				if (saleList == null || saleList.isEmpty()) {
					break;
				}
				for (ErpFunSale funSalePO : saleList) {
					ErpFunSale funSaleUpdate = new ErpFunSale();
					// 先解密
					funSaleUpdate.setSaleRoofT(EnCodeHelper.decode(funSalePO.getSaleRoof()));
					funSaleUpdate.setSaleUnitT(EnCodeHelper.decode(funSalePO.getSaleUnit()));
					funSaleUpdate.setSaleNumT(EnCodeHelper.decode(funSalePO.getSaleNum()));
					funSaleUpdate.setSaleId(funSalePO.getSaleId());
					funSaleUpdate.setLock((byte)1);
					funSaleUpdate.setShardDbName(dbName);
					erpFunSaleMapper.updateByPrimaryKeySelective(funSaleUpdate);
					// 修改核心信息表
					ErpFunCoreInfo erpFunCoreInfo = new ErpFunCoreInfo();
					erpFunCoreInfo.setShardDbName(dbName);
					erpFunCoreInfo.setHouseRoof(funSaleUpdate.getSaleRoofT());
					erpFunCoreInfo.setHouseUnit(funSaleUpdate.getSaleUnitT());
					erpFunCoreInfo.setRoomId(funSaleUpdate.getSaleNumT());
					erpFunCoreInfo.setHouseFloor(EnCodeHelper.decode(funSalePO.getUnitFloor()));
					erpFunCoreInfo.setCaseId(funSalePO.getSaleId());
					erpFunCoreInfo.setCaseType(1);
					erpFunCoreInfoMapper.updateByCaseInfo(erpFunCoreInfo);
				}
			}
		}
	}

	class UpdateLeaseUnitThread extends Thread {
		String dbName = null;
		Integer compId = null;

		public UpdateLeaseUnitThread(String dbName, Integer compId) {
			this.compId = compId;
			this.dbName = dbName;
		}

		@Override
		public void run() {
			while (true) {
				// 增加开关
				if (1 == switchFlag) {
					break;
				}
//				List<ErpFunLease> leaseList = erpFunLeaseMapper.getNeedUpdateHouseUnitList(dbName, 1000, null, 0);
				List<ErpFunLease> leaseList = erpFunLeaseMapper.getUnitNotEqDecryptList(dbName, 1000, compId);
				if (leaseList == null || leaseList.isEmpty()) {
					break;
				}
				for (ErpFunLease funLeasePO : leaseList) {
					// 先解密
					ErpFunLease funLeaseUpdate = new ErpFunLease();
					funLeaseUpdate.setLeaseRoofT(EnCodeHelper.decode(funLeasePO.getLeaseRoof()));
					funLeaseUpdate.setLeaseUnitT(EnCodeHelper.decode(funLeasePO.getLeaseUnit()));
					funLeaseUpdate.setLeaseNumT(EnCodeHelper.decode(funLeasePO.getLeaseNum()));
					funLeaseUpdate.setLeaseId(funLeasePO.getLeaseId());
					funLeaseUpdate.setShardDbName(dbName);
					funLeaseUpdate.setLock((byte) 1);
					erpFunLeaseMapper.updateByPrimaryKeySelective(funLeaseUpdate);
					// 修改核心信息表
					ErpFunCoreInfo erpFunCoreInfo = new ErpFunCoreInfo();
					erpFunCoreInfo.setShardDbName(dbName);
					erpFunCoreInfo.setHouseRoof(funLeaseUpdate.getLeaseRoofT());
					erpFunCoreInfo.setHouseUnit(funLeaseUpdate.getLeaseUnitT());
					erpFunCoreInfo.setRoomId(funLeaseUpdate.getLeaseNumT());
					erpFunCoreInfo.setHouseFloor(EnCodeHelper.decode(funLeasePO.getUnitFloor()));
					erpFunCoreInfo.setCaseId(funLeasePO.getLeaseId());
					erpFunCoreInfo.setCaseType(2);
					erpFunCoreInfoMapper.updateByCaseInfo(erpFunCoreInfo);
				}
			}
		}
	}
}


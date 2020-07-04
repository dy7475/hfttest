package com.myfun.erpWeb.openApi;

import java.util.HashMap;
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
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;

/**
 * 重新生成房源MD5和单元
 * @author 张宏利
 * @since 2017年1月17日
 */
@Controller
@RequestMapping(value = "/openApi/houseUnit")
public class UpdateHouseUnit extends BaseController{
	
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired AdminFunUserMessageMapper adminFunUserMessageMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	
	public static Map<String, String> coreInfoTypeMap = new HashMap<>();
	
	public static int switchFlag = 0;
	
	/**
	 * 控制开关
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/switchUpdate")
	public String stopUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		switchFlag = StringUtil.paseInteger(request.getParameter("switch"), 1);// // 控制开关
		return ErpResponseJson.ok().toJson();
	}
	
	/**
	 * 重新生成房源MD5和单元
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/updateHouseUnit")
	public String updateHouseUnit(HttpServletRequest request, HttpServletResponse response) throws Exception{
//		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
//		for (int i = 0; i < configs.size(); i++) {
//			String dbName = configs.get(i);
			String dbName = "hft_erpdb_CI";
			new UpdateSaleUnitThread(dbName).start();
			new UpdateLeaseUnitThread(dbName).start();
//		}
		return new ErpResponseJson().toJson();
	}
	
	class UpdateSaleUnitThread extends Thread{
		String dbName = null;
		
		public UpdateSaleUnitThread(String dbName) {
			this.dbName = dbName;
		}
		
		@Override
		public void run() {
			while(true) {
				// 增加开关
				if(1 == switchFlag) {
					break;
				}
				List<ErpFunSale> saleList = erpFunSaleMapper.getNeedUpdateHouseUnitList(dbName, 1000, "2017-10-25", 1);
				if(saleList == null || saleList.isEmpty()) {
					break;
				}
				for (ErpFunSale funSalePO : saleList) {
					// 先解密
					funSalePO.setSaleRoof(EnCodeHelper.decode(funSalePO.getSaleRoof()));
					funSalePO.setSaleUnit(EnCodeHelper.decode(funSalePO.getSaleUnit()));
					funSalePO.setUnitFloor(EnCodeHelper.decode(funSalePO.getUnitFloor()));
					funSalePO.setSaleNum(EnCodeHelper.decode(funSalePO.getSaleNum()));
					// 计算MD5
					String ecodeStr = encodeToMD5(
							funSalePO.getSaleRoof(), funSalePO.getSaleUnit(),
							funSalePO.getUnitFloor(), funSalePO.getSaleNum(),
							funSalePO.getBuildId(), funSalePO.getSaleUseage(),
							funSalePO.getTradeAddr(), funSalePO.getCityId(),
							funSalePO.getCompId()
						);
					ErpFunSale funSaleUpdate = new ErpFunSale();
					funSaleUpdate.setAddrMd5(ecodeStr);
					funSaleUpdate.setLock((byte) 0);
					// mapper里面也要改
//					funSaleUpdate.setSaleUnitR(EnCodeHelper.encode(StringUtil.convertStr(funSalePO.getSaleUnit(), Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT)));
					funSaleUpdate.setSaleId(funSalePO.getSaleId());
					funSaleUpdate.setShardDbName(dbName);
					erpFunSaleMapper.updateMd5AndUnit(funSaleUpdate);
				}
			}
		}
	}
	
	class UpdateLeaseUnitThread extends Thread{
		String dbName = null;
		
		public UpdateLeaseUnitThread(String dbName) {
			this.dbName = dbName;
		}
		
		@Override
		public void run() {
			while(true) {
				// 增加开关
				if(1 == switchFlag) {
					break;
				}
				List<ErpFunLease> leaseList = erpFunLeaseMapper.getNeedUpdateHouseUnitList(dbName, 1000, "2017-10-25", 1);
				if(leaseList == null || leaseList.isEmpty()) {
					break;
				}
				for (ErpFunLease funLeasePO : leaseList) {
					// 先解密
					funLeasePO.setLeaseRoof(EnCodeHelper.decode(funLeasePO.getLeaseRoof()));
					funLeasePO.setLeaseUnit(EnCodeHelper.decode(funLeasePO.getLeaseUnit()));
					funLeasePO.setUnitFloor(EnCodeHelper.decode(funLeasePO.getUnitFloor()));
					funLeasePO.setLeaseNum(EnCodeHelper.decode(funLeasePO.getLeaseNum()));
					// 计算MD5
					String ecodeStr = encodeToMD5(
							funLeasePO.getLeaseRoof(), funLeasePO.getLeaseUnit(),
							funLeasePO.getUnitFloor(), funLeasePO.getLeaseNum(),
							funLeasePO.getBuildId(), funLeasePO.getLeaseUseage(),
							funLeasePO.getTradeAddr(), funLeasePO.getCityId(),
							funLeasePO.getCompId()
						);
					ErpFunLease funLeaseUpdate = new ErpFunLease();
					funLeaseUpdate.setAddrMd5(ecodeStr);
					funLeaseUpdate.setLock((byte) 0);
//					funLeaseUpdate.setLeaseUnitR(EnCodeHelper.encode(StringUtil.convertStr(funLeasePO.getLeaseUnit(), Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT)));
					funLeaseUpdate.setLeaseId(funLeasePO.getLeaseId());
					funLeaseUpdate.setShardDbName(dbName);
					erpFunLeaseMapper.updateMd5AndUnit(funLeaseUpdate);
				}
			}
		}
	}
	
	/**
	 * 房源地址MD5加密- 不能用于客源
	 * 同步ErpSysParaServiceImpl.encodeToMD5()
	 */
	public String encodeToMD5(String roof, String unit, String floor, String num, Integer buildId, Byte useage, String tradeAddr, Integer cityId, Integer compId) {
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		roof = (roof == null ? "" : roof).toUpperCase();
		unit = (unit == null ? "" : unit).toUpperCase();
		floor = (floor == null ? "" : floor).toUpperCase();
		num = (num == null ? "" : num).toUpperCase();
		if (Integer.valueOf(-1).equals(buildId)
				|| Constants_DIC.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_STORE.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_GARAGE.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_TRADE.equals(useage)) {
			return EnCodeHelper.ecodeByMD5(tradeAddr + "_" + num);
		}
		// 做个缓存
		String coreInfoType = coreInfoTypeMap.get(cityId + "_" + compId);
		if(coreInfoType == null) {
			// 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
			coreInfoType = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
			coreInfoTypeMap.put(cityId + "_" + compId, coreInfoType);
		}
		// 号室规则下忽略楼层和栋座
		if("2".equals(coreInfoType)) {
			floor = roof = "";
			if(StringUtils.isBlank(unit) && StringUtils.isBlank(num)) {
				return null;
			}
		} else {
			if(StringUtils.isBlank(roof) && StringUtils.isBlank(unit) 
					&& StringUtils.isBlank(floor) && StringUtils.isBlank(num)) {
				return null;
			}
		}
		roof = EnCodeHelper.encode(StringUtil.convertStr(roof, Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT));
		unit = EnCodeHelper.encode(StringUtil.convertStr(unit, Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT));
		floor = EnCodeHelper.encode(StringUtil.convertStr(floor, Constants_DIC.DIC_FLOOR_REPEAT_LENGTH_LIMIT));
		num = EnCodeHelper.encode(StringUtil.convertStr(num, Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT));
		String ecodeStr = EnCodeHelper.ecodeByMD5(roof + "_" + unit + "_" + floor + "_" + num);
		return ecodeStr;
	}
	
	/**
	 * 房源地址MD5加密- 不能用于客源
	 */
	public static void main(String[] args) {
		// select addr_md5,LEASE_ROOF,LEASE_UNIT,UNIT_FLOOR,LEASE_NUM,LEASE_USEAGE,TRADE_ADDR,BUILD_ID,*
		// from FUN_LEASE where lease_no='CZAT1709231444002'
		String roof = ";1";
		String unit = ";1";
		String floor = ";301";
		String num = "=3>;47";
		String useage = "1";
		String tradeAddr = "";
		Integer buildId = 201587;
		String coreInfoType = "1";
		
		roof = EnCodeHelper.decode(roof);
		unit = EnCodeHelper.decode(unit);
		floor = EnCodeHelper.decode(floor);
		num = EnCodeHelper.decode(num);
		// 计算MD5
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		roof = (roof == null ? "" : roof).toUpperCase();
		unit = (unit == null ? "" : unit).toUpperCase();
		floor = (floor == null ? "" : floor).toUpperCase();
		num = (num == null ? "" : num).toUpperCase();
		if (Integer.valueOf(-1).equals(buildId)
				|| Constants_DIC.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_STORE.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_GARAGE.equals(useage)
				|| Constants_DIC.DIC_HOUSE_USEAGE_TRADE.equals(useage)) {
			System.out.println("1--" + EnCodeHelper.ecodeByMD5(tradeAddr + "_" + num));
			return;
		}
		// 号室规则下忽略楼层和栋座
		if("2".equals(coreInfoType)) {
			floor = roof = "";
			if(StringUtils.isBlank(unit) && StringUtils.isBlank(num)) {
				System.out.println("2--");return;
			}
		} else {
			if(StringUtils.isBlank(roof) && StringUtils.isBlank(unit) 
					&& StringUtils.isBlank(floor) && StringUtils.isBlank(num)) {
				System.out.println("3--");return;
			}
		}
		roof = EnCodeHelper.encode(StringUtil.convertStr(roof, Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT));
		unit = EnCodeHelper.encode(StringUtil.convertStr(unit, Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT));
		floor = EnCodeHelper.encode(StringUtil.convertStr(floor, Constants_DIC.DIC_FLOOR_REPEAT_LENGTH_LIMIT));
		num = EnCodeHelper.encode(StringUtil.convertStr(num, Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT));
		String ecodeStr = EnCodeHelper.ecodeByMD5(roof + "_" + unit + "_" + floor + "_" + num);
		System.out.println("4--" + ecodeStr);
	}
}


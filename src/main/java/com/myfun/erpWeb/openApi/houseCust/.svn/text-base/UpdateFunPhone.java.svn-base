package com.myfun.erpWeb.openApi.houseCust;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.photoDeal.FunArchiveController;
import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveFastdfsMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhoneMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPhone;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.StringHelper;
import com.myfun.utils.StringUtil;

/**
 * 依据房源表生成fun_phone表的数据
 * @author 张宏利
 * @since 2017年5月31日
 */
@Controller
@RequestMapping(value = "/openApi/funPhone")
public class UpdateFunPhone extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FunArchiveController.class);
	
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunArchiveFastdfsMapper adminFunArchiveFastdfsMapper;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	ErpFunPhotoFastdfsMapper erpFunPhotoFastdfsMapper;
	@Autowired
	AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunPhoneMapper erpFunPhoneMapper;

	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();

	/**
	 * 依据房源表生成fun_phone表的数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/createSwitch")
	public ErpResponseJson copySwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String needUpdateParam = request.getParameter("needUpdateParam");// 是否需要修改参数
		if(!"1".equals(needUpdateParam)) {
			return ErpResponseJson.ok(photoDealParam);
		}
		Long tempSleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		if(tempSleepTime <= 50) {
			tempSleepTime = 50L;
		}
		photoDealParam.setSleepTime(tempSleepTime);
		int copySwitch = StringUtil.paseInteger(request.getParameter("copySwitch"), 0);// 是否启动
		if(copySwitch == 1) {
			photoDealParam.setCopySwitch(true);
		} else {
			photoDealParam.setCopySwitch(false);
		}
		int dealCount = StringUtil.paseInteger(request.getParameter("dealCount"), 1);// 每次请求处理循环多少次
		photoDealParam.setDealCount(dealCount);
		String dbName = request.getParameter("threadDbName");
		if(StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if(threadCount <= 0) {
				threadCount = 1;
			} else if(threadCount > 20) {
				threadCount = 10;
			}
			photoDealParam.getDealThreadCount().put(dbName, threadCount);
		}
		return ErpResponseJson.ok(photoDealParam);
	}
	
	/**
	 * 依据房源表生成fun_phone表的数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/startCreate")
	public ErpResponseJson startCopy(HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(photoDealParam.getIsStart()) {
			return ErpResponseJson.warn("执行中，请先停止再尝试开启");
		}
		photoDealParam.setIsStart(true);
		photoDealParam.setCopySwitch(true);
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			// 每个库增加不同的线程数
			Integer threadCount = photoDealParam.getDealThreadCount().get(shardDbName.toLowerCase());
			if(threadCount == null || threadCount <= 0){
				threadCount = 1;
			}
			logger.error("-----create thread---");
			new DealPhotoThread(photoDealParam.getDealCount(), shardDbName).start();
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 依据房源表生成fun_phone表的数据
	 * @author 张宏利
	 * @since 2017年4月27日
	 */
	public class DealPhotoThread extends Thread{
		int dealSize = 0;
		String shardDbName = null;
		public DealPhotoThread(int dealSize, String shardDbName){
			this.dealSize = dealSize;
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			try {
				boolean saleOver = false;
				boolean leaseOver = false;
				for (int i = 0; i < dealSize; i++) {
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					if(saleOver && leaseOver) {
						break;
					}
					if(!saleOver) {
						List<ErpFunSale> saleList = erpFunSaleMapper.getNoFunPhoneData(shardDbName);
						// 没有数据时退出循环
						if(saleList == null || saleList.size() <= 0) {
							saleOver = true;
						} else {
							Date dateNow = new Date();
							List<ErpFunPhone> createPhones = new LinkedList<>();
							for (ErpFunSale erpFunSale : saleList) {
								String[] phones = StringHelper.split(erpFunSale.getCellPhone(), "&&&");
								for (String phoneValue : phones) {
									String[] phoneValues = StringHelper.split(phoneValue, "|||");
									if (phoneValues == null || phoneValues.length < 2) {
										continue;
									}
									ErpFunPhone erpFunPhone = new ErpFunPhone();
									erpFunPhone.setCaseType(1);
									erpFunPhone.setPhone(phoneValues[1]);
									erpFunPhone.setCaseId(erpFunSale.getSaleId());
									erpFunPhone.setAreaId(erpFunSale.getAreaId());
									erpFunPhone.setRegId(erpFunSale.getRegId());
									erpFunPhone.setDeptId(erpFunSale.getDeptId());
									erpFunPhone.setUserId(erpFunSale.getUserId());
									erpFunPhone.setCompId(erpFunSale.getCompId());
									erpFunPhone.setCityId(erpFunSale.getCityId());
									erpFunPhone.setCreationTime(dateNow);
									createPhones.add(erpFunPhone);
								}
							}
							erpFunPhoneMapper.insertEntryList(shardDbName, createPhones);
						}
					}
					if(!leaseOver) {
						List<ErpFunLease> leaseList = erpFunLeaseMapper.getNoFunPhoneData(shardDbName);
						// 没有数据时退出循环
						if(leaseList == null || leaseList.size() <= 0) {
							leaseOver = true;
						} else {
							Date dateNow = new Date();
							List<ErpFunPhone> createPhones = new LinkedList<>();
							for (ErpFunLease erpFunLease : leaseList) {
								String[] phones = StringHelper.split(erpFunLease.getCellPhone(), "&&&");
								for (String phoneValue : phones) {
									String[] phoneValues = StringHelper.split(phoneValue, "|||");
									if (phoneValues == null || phoneValues.length < 2) {
										continue;
									}
									ErpFunPhone erpFunPhone = new ErpFunPhone();
									erpFunPhone.setCaseType(2);
									erpFunPhone.setPhone(phoneValues[1]);
									erpFunPhone.setCaseId(erpFunLease.getLeaseId());
									erpFunPhone.setAreaId(erpFunLease.getAreaId());
									erpFunPhone.setRegId(erpFunLease.getRegId());
									erpFunPhone.setDeptId(erpFunLease.getDeptId());
									erpFunPhone.setUserId(erpFunLease.getUserId());
									erpFunPhone.setCompId(erpFunLease.getCompId());
									erpFunPhone.setCityId(erpFunLease.getCityId());
									erpFunPhone.setCreationTime(dateNow);
									createPhones.add(erpFunPhone);
								}
							}
							erpFunPhoneMapper.insertEntryList(shardDbName, createPhones);
						}
					}
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
			photoDealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
}


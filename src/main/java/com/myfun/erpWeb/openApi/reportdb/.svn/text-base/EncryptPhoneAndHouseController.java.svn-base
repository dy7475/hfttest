package com.myfun.erpWeb.openApi.reportdb;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindbRpt.dao.AdminRptVInquiryDianhuaMapper;
import com.myfun.repository.admindbRpt.dao.AdminRptVPropertyDongzuoMapper;
import com.myfun.repository.admindbRpt.po.AdminRptVInquiryDianhua;
import com.myfun.repository.admindbRpt.po.AdminRptVInquiryDianhuaExample;
import com.myfun.repository.admindbRpt.po.AdminRptVPropertyDongzuo;
import com.myfun.repository.admindbRpt.po.AdminRptVPropertyDongzuoExample;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.PhoneUtil;
import com.myfun.utils.StringUtil;

/**
 * 对电话和栋座信息进行加密操作
 * @author 张宏利
 * @since 2017年8月18日
 */
@Controller
@RequestMapping(value = "/openApi/encode/encryptPhone")
public class EncryptPhoneAndHouseController extends BaseController{
private static final Logger logger = LoggerFactory.getLogger(EncryptPhoneAndHouseController.class);
	
	@Autowired AdminRptVInquiryDianhuaMapper adminRptVInquiryDianhuaMapper;
	@Autowired AdminRptVPropertyDongzuoMapper adminRptVPropertyDongzuoMapper;
	
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	private static ArrayBlockingQueue<List<AdminRptVPropertyDongzuo>> AGENCY_DONGZUO_QUEYE = new ArrayBlockingQueue<List<AdminRptVPropertyDongzuo>>(100);
	private static ArrayBlockingQueue<List<AdminRptVInquiryDianhua>> AGENCY_PHONE_QUEYE = new ArrayBlockingQueue<List<AdminRptVInquiryDianhua>>(100);
	
	/**
	 * 开关和修改参数
	 */
	@ResponseBody
	@RequestMapping(value="/copySwitch")
	public ErpResponseJson copySwitch(HttpServletRequest request, HttpServletResponse response) {
		String needUpdateParam = request.getParameter("needUpdateParam");// 是否需要修改参数
		if (!"1".equals(needUpdateParam)) {
			return ErpResponseJson.ok(photoDealParam);
		}
		Long tempSleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		if (tempSleepTime <= 50) {
			tempSleepTime = 50L;
		}
		photoDealParam.setSleepTime(tempSleepTime);
		int copySwitch = StringUtil.paseInteger(request.getParameter("copySwitch"), 0);// 是否启动
		if (copySwitch == 1) {
			photoDealParam.setCopySwitch(true);
		} else {
			photoDealParam.setCopySwitch(false);
		}
		int dealCount = StringUtil.paseInteger(request.getParameter("dealCount"), 1);// 每次请求处理循环多少次
		photoDealParam.setDealCount(dealCount);
		String dbName = request.getParameter("threadDbName");
		if (StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if (threadCount <= 0) {
				threadCount = 1;
			} else if (threadCount > 20) {
				threadCount = 10;
			}
			photoDealParam.getDealThreadCount().put(dbName, threadCount);
		}
		return ErpResponseJson.ok(photoDealParam);
	}
	
	/**
	 * 开始处理
	 * @author 张宏利
	 * @since 2017年8月18日
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/startQuery")
	public ErpResponseJson startQuery(HttpServletRequest request, HttpServletResponse response) {
		photoDealParam.setCopySwitch(true);
		logger.error("-----create thread---");
		new QueryDianHuaThread().start();
		new QueryDongzuoThread().start();
		return ErpResponseJson.ok();
	}
	
	@ResponseBody
	@RequestMapping(value = "/startCopy")
	public ErpResponseJson startCopy(HttpServletRequest request, HttpServletResponse response) {
		photoDealParam.setCopySwitch(true);
		new DealDianHuaThread().start();
		new DealDongzuoThread().start();
		return ErpResponseJson.ok();
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateWaitingToNull")
	public ErpResponseJson updateWaitingToNull(HttpServletRequest request, HttpServletResponse response) {
		adminRptVInquiryDianhuaMapper.updateWaitingToNull();
		adminRptVPropertyDongzuoMapper.updateWaitingToNull();
		return ErpResponseJson.ok();
	}
	
	/**
	 * 查询线程
	 */
	public class QueryDianHuaThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					List<AdminRptVInquiryDianhua> dianhuaList = adminRptVInquiryDianhuaMapper.getTop100List();
					if(dianhuaList.size() <= 0 || !photoDealParam.getCopySwitch()) {
						return;
					}
					AdminRptVInquiryDianhua updateRecord = new AdminRptVInquiryDianhua();
					AdminRptVInquiryDianhuaExample example = new AdminRptVInquiryDianhuaExample();
					List<String> values = dianhuaList.stream().collect(Collectors.mapping(AdminRptVInquiryDianhua::getInquiryid, Collectors.toList()));
					example.createCriteria().andInquiryidIn(values);
					updateRecord.setCellPhoneR("waiting");
					adminRptVInquiryDianhuaMapper.updateByExampleSelective(updateRecord, example);
					AGENCY_PHONE_QUEYE.put(dianhuaList);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 查询线程
	 */
	public class QueryDongzuoThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					List<AdminRptVPropertyDongzuo> dongzuoList = adminRptVPropertyDongzuoMapper.getTop100List();
					if(dongzuoList.size() <= 0 || !photoDealParam.getCopySwitch()) {
						return;
					}
					AdminRptVPropertyDongzuo updateRecord = new AdminRptVPropertyDongzuo();
					AdminRptVPropertyDongzuoExample example = new AdminRptVPropertyDongzuoExample();
					List<String> values = dongzuoList.stream().collect(Collectors.mapping(AdminRptVPropertyDongzuo::getPropertyid, Collectors.toList()));
					example.createCriteria().andPropertyidIn(values);
					updateRecord.setCellPhoneR("waiting");
					adminRptVPropertyDongzuoMapper.updateByExampleSelective(updateRecord, example);
					AGENCY_DONGZUO_QUEYE.put(dongzuoList);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 处理的线程
	 */
	public class DealDianHuaThread extends Thread{
		@Override
		public void run() {
			try {
//				v_Inquiry_dianhua表中把cell_phone 电话加密到 cell_phone_r
				while(true) {
					if(AGENCY_PHONE_QUEYE.isEmpty()) {
						break;
					}
					List<AdminRptVInquiryDianhua> vInquiryDianhuaList = AGENCY_PHONE_QUEYE.take();
					for (AdminRptVInquiryDianhua vInquiryDianhua : vInquiryDianhuaList) {
						if (!photoDealParam.getCopySwitch()) {
							return;// 动态停止
						}
						AdminRptVInquiryDianhua dianhua = new AdminRptVInquiryDianhua();
						if(StringUtils.isBlank(vInquiryDianhua.getCellPhone())) {
							dianhua.setCellPhoneR("-");// 防止下次再查到
						} else {
							dianhua.setCellPhoneR(PhoneUtil.dealPhoneForSpace(vInquiryDianhua.getCellPhone()));
						}
						AdminRptVInquiryDianhuaExample updateExample = new AdminRptVInquiryDianhuaExample();
						updateExample.createCriteria().andInquiryidEqualTo(vInquiryDianhua.getInquiryid());
						adminRptVInquiryDianhuaMapper.updateByExampleSelective(dianhua, updateExample);
					}
				}
				logger.error("------------------over------------------");
			} catch (Exception e) {
				logger.error("!!!!!!!!!!!!!!!!!!!error,over!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 处理的线程
	 */
	public class DealDongzuoThread extends Thread{
		@Override
		public void run() {
			try {
//				v_Property_dongzuo表中把cell_phone 电话加密到 cell_phone_r，
//				把build_roof,build_unit,house_num加密到build_roof_s,build_unit_s,house_num_s，
//				补位加密到build_roof_r,build_unit_r,house_num_r
				while(true) {
					if(AGENCY_DONGZUO_QUEYE.isEmpty()) {
						break;
					}
					List<AdminRptVPropertyDongzuo> dongzuoList = AGENCY_DONGZUO_QUEYE.take();
					for (AdminRptVPropertyDongzuo vPropertyDongzuo : dongzuoList) {
						if (!photoDealParam.getCopySwitch()) {
							return;// 动态停止
						}
						AdminRptVPropertyDongzuo dongzuo = new AdminRptVPropertyDongzuo();
						if(StringUtils.isBlank(vPropertyDongzuo.getCellPhone())) {
							dongzuo.setCellPhoneR("-");// 防止下次再查到
						} else {
							dongzuo.setCellPhoneR(PhoneUtil.dealPhoneForSpace(vPropertyDongzuo.getCellPhone()));
						}
						if(StringUtils.isNotBlank(vPropertyDongzuo.getBuildRoof())) {
							dongzuo.setBuildRoofS(EnCodeHelper.encode(vPropertyDongzuo.getBuildRoof()));
							dongzuo.setBuildRoofR(EnCodeHelper.encode(StringUtil.convertStr(vPropertyDongzuo.getBuildRoof(), Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT)));
						}
						if(StringUtils.isNotBlank(vPropertyDongzuo.getBuildUnit())) {
							dongzuo.setBuildUnitS(EnCodeHelper.encode(vPropertyDongzuo.getBuildUnit()));
							dongzuo.setBuildUnitR(EnCodeHelper.encode(StringUtil.convertStr(vPropertyDongzuo.getBuildUnit(), Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT)));
						}
						if(StringUtils.isNotBlank(vPropertyDongzuo.getHouseNum())) {
							dongzuo.setHouseNumS(EnCodeHelper.encode(vPropertyDongzuo.getHouseNum()));
							dongzuo.setHouseNumR(EnCodeHelper.encode(StringUtil.convertStr(vPropertyDongzuo.getHouseNum(), Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT)));
						}
						AdminRptVPropertyDongzuoExample updateExample = new AdminRptVPropertyDongzuoExample();
						updateExample.createCriteria().andPropertyidEqualTo(vPropertyDongzuo.getPropertyid());
						adminRptVPropertyDongzuoMapper.updateByExampleSelective(dongzuo, updateExample);
					}
				}
				logger.error("------------------over------------------");
			} catch (Exception e) {
				logger.error("!!!!!!!!!!!!!!!!!!!error,over!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
	}
}

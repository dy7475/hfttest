package com.myfun.erpWeb.openApi.houseCust;

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

import com.alibaba.fastjson.JSON;
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
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPhone;
import com.myfun.repository.erpdb.po.ErpFunPhoneExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.PhoneUtil;
import com.myfun.utils.StringUtil;

/**
 * 依据fun_phone表修改房源表的电话信息
 * @author 张宏利
 * @since 2017年6月26日
 */
@Controller
@RequestMapping(value = "/openApi/salePhone")
public class UpdateSalePhoneController extends BaseController{
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
	@Autowired
	ErpFunTrackMapper erpFunTrackMapper;

	private volatile static PhotoDealParam dealParam = new PhotoDealParam();

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
			return ErpResponseJson.ok(dealParam);
		}
		Long tempSleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		if(tempSleepTime <= 50) {
			tempSleepTime = 50L;
		}
		dealParam.setSleepTime(tempSleepTime);
		int copySwitch = StringUtil.paseInteger(request.getParameter("copySwitch"), 0);// 是否启动
		if(copySwitch == 1) {
			dealParam.setCopySwitch(true);
		} else {
			dealParam.setCopySwitch(false);
		}
		int dealCount = StringUtil.paseInteger(request.getParameter("dealCount"), 1);// 每次请求处理循环多少次
		dealParam.setDealCount(dealCount);
		String dbName = request.getParameter("threadDbName");
		if(StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if(threadCount <= 0) {
				threadCount = 1;
			} else if(threadCount > 20) {
				threadCount = 10;
			}
			dealParam.getDealThreadCount().put(dbName, threadCount);
		}
		return ErpResponseJson.ok(dealParam);
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
		if(dealParam.getIsStart()) {
			return ErpResponseJson.warn("执行中，请先停止再尝试开启");
		}
		dealParam.setIsStart(true);
		dealParam.setCopySwitch(true);
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			logger.error("-----create thread---");
			new DataDealThread(dealParam.getDealCount(), shardDbName).start();
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 依据房源表生成fun_phone表的数据
	 * @author 张宏利
	 * @since 2017年4月27日
	 */
	public class DataDealThread extends Thread{
		int dealSize = 0;
		String shardDbName = null;
		public DataDealThread(int dealSize, String shardDbName){
			this.dealSize = dealSize;
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			try {
				List<ErpFunTrack> trackList = erpFunTrackMapper.selectPhoneErrorList(shardDbName);
				// 没有数据时退出循环
				if(trackList == null || trackList.size() <= 0) {
					return;
				}
				for (ErpFunTrack erpFunTrack : trackList) {
					String joinCellPhone = null;
					if(1 == erpFunTrack.getCaseType()) {
						ErpFunSale erpFunSale = new ErpFunSale();
						erpFunSale.setSaleId(erpFunTrack.getCaseId());
						erpFunSale.setShardDbName(shardDbName);
						ErpFunSale funSale = erpFunSaleMapper.getCellPhone(erpFunSale);
						if(funSale == null) {
							continue;
						}// 不为空不处理，这是处理之后，第二次处理才用得上
						//if(StringUtils.isNotBlank(funSale.getCellPhone())) {
						//	continue;
						//}
						joinCellPhone = funSale.getJointCellPhone();
					} else if(2 == erpFunTrack.getCaseType()){
						ErpFunLease erpFunLease = new ErpFunLease();
						erpFunLease.setLeaseId(erpFunTrack.getCaseId());
						erpFunLease.setShardDbName(shardDbName);
						ErpFunLease funLease = erpFunLeaseMapper.getCellPhone(erpFunLease);
						if(funLease == null) {
							continue;
						}
						// 不为空不处理，这是处理之后，第二次处理才用得上
						//if(StringUtils.isNotBlank(funLease.getCellPhone())) {
						//	continue;
						//}
						joinCellPhone = funLease.getJointCellPhone();
					} else {
						continue;
					}
					String[] joinCellPhoneArr = PhoneUtil.decodePhoneToArr(joinCellPhone, false);
					if(joinCellPhoneArr == null || joinCellPhoneArr.length <= 0) {
						continue;
					}
					ErpFunPhoneExample example = new ErpFunPhoneExample();
					example.createCriteria().andCaseIdEqualTo(erpFunTrack.getCaseId())
					.andCaseTypeEqualTo(erpFunTrack.getCaseType().intValue());
					example.setShardDbName(shardDbName);
					List<ErpFunPhone> phoneList = erpFunPhoneMapper.selectByExample(example);
					String updatePhoneStr = "";
					boolean isJoinPhone = false;
					for (ErpFunPhone erpFunPhone : phoneList) {
						String funPhone = EnCodeHelper.decode(erpFunPhone.getPhone());
						if(!isJoinPhone) {
							for (String phone : joinCellPhoneArr) {
								if(phone.equals(funPhone)) {
									isJoinPhone = true;
									break;
								}
							}
							if(isJoinPhone) {
								continue;
							}
						}
						if(updatePhoneStr.length() > 0) {
							updatePhoneStr += " ";
						}
						updatePhoneStr += "手机:"+funPhone;
					}
					String procePhone = PhoneUtil.procePhone(updatePhoneStr);
					if(1 == erpFunTrack.getCaseType()) {
						ErpFunSale erpFunSale = new ErpFunSale();
						erpFunSale.setSaleId(erpFunTrack.getCaseId());
						erpFunSale.setShardDbName(shardDbName);
						erpFunSale.setCellPhone(procePhone);// 修改手机号
						erpFunSaleMapper.updateCellPhoneByPrimaryKey(erpFunSale);
						System.out.println(JSON.toJSONString(erpFunSale));
					} else if(2 == erpFunTrack.getCaseType()){
						ErpFunLease erpFunLease = new ErpFunLease();
						erpFunLease.setLeaseId(erpFunTrack.getCaseId());
						erpFunLease.setShardDbName(shardDbName);
						erpFunLease.setCellPhone(procePhone);// 修改手机号
						erpFunLeaseMapper.updateCellPhoneByPrimaryKey(erpFunLease);
						System.out.println(JSON.toJSONString(erpFunLease));
					}
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
			dealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
}


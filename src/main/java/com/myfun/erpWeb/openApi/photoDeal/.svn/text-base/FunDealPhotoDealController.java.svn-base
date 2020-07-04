package com.myfun.erpWeb.openApi.photoDeal;

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

import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoFastdfsMapper;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.erpdb.po.ErpFunDealPhotoFastdfs;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.StringUtil;

/**
 * 合同相关图片处理
 * http://pic.myfun7.com/pic/hftpic/house/2016/04/1_1/AA01D0/FunDeal/101/93360c5a-ab00-4b2b-9995-7f094051c4fc.png
 * @author 张宏利
 * @since 2017年5月16日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal/funDealPhoto")
public class FunDealPhotoDealController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FunDealPhotoDealController.class);
	
	@Autowired ErpFunDealPhotoService erpFunDealPhotoService;
	@Autowired ErpFunDealPhotoFastdfsMapper erpFunDealPhotoFastdfsMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	// 处理的参数
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	
	static{
//		dealThreadCount.put("hft_erpdb_cd", 5);
//		dealThreadCount.put("hft_erpdb_zz", 20);
	}
	
	/**
	 * 参数配置页--所有处理统一的
	 * 需要在页面上配置各个处理的copySwitch和startCopy地址
	 * @return
	 */
	@RequestMapping(value="/manage")
	public String manage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "openApi/dealPhoto/dealPhotoManage";
	}
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copySwitch")
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
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/startCopy")
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
			for (int j = 0; j < threadCount; j++) {
				logger.error("-----create thread---");
				new DealPhotoThread(photoDealParam.getDealCount(), shardDbName).start();
			}
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 处理图片的线程
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
				for (int i = 0; i < dealSize; i++) {
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					List<ErpFunDealPhoto> photoList = null;
					synchronized(FunDealPhotoDealController.class){
						photoList = erpFunDealPhotoService.getPhotoListOrderByPhotoIdDesc(shardDbName);
					}
					// 没有数据时退出循环
					if(photoList == null || photoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					List<ErpFunDealPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
					for (ErpFunDealPhoto erpFunDealPhoto : photoList) {
						String photoAddr = erpFunDealPhoto.getPhotoAddr();
						String newAddr = FileUtil.uploadFileToFastdfs("/hftdata/static/pic/hftpic/house/", photoAddr);
						if(newAddr != null) {
							ErpFunDealPhotoFastdfs fastdfs = new ErpFunDealPhotoFastdfs();
							fastdfs.setPhotoAddr(newAddr);
							fastdfs.setPhotoId(erpFunDealPhoto.getPhotoId());
							fastdfsPhotoList.add(fastdfs);
						}
						photoDealParam.setIsStart(true);// 有在执行中则一直会被改为处理中
						Thread.sleep(photoDealParam.getSleepTime());
					}
					if(fastdfsPhotoList.isEmpty()) {
						logger.error("-----deal nothing---");
						continue;
					}
					erpFunDealPhotoFastdfsMapper.updatePhotoAddrForList(shardDbName, fastdfsPhotoList);
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


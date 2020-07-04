package com.myfun.erpWeb.openApi.photoDeal.erp;

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

import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingPhotoMapper;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.repository.erpdb.po.ErpBuildingPhotoFastdfs;
import com.myfun.utils.FileUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.bean.FileUploadResult;

/**
 * 楼盘相关图片处理
 * url：http://pic.myfun7.com/pic/hftpic/house/SmallPic/BUILDING/2017/04/4_26/593542_1491617177698.GIF
 * disk：SmallPic/BUILDING/2017/04/4_26/593542_1491617177698.GIF
 * @author 张宏利
 * @since 2017年5月19日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal/erpBuildingPhotoToFastDfs")
public class ErpBuildingPhotoFastDfsController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ErpBuildingPhotoFastDfsController.class);
	
	@Autowired
	ErpBuildingPhotoMapper erpBuildingPhotoMapper;
	@Autowired
	ErpBuildingPhotoFastdfsMapper erpBuildingPhotoFastdfsMapper;
	@Autowired
	AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	
	// 处理的参数
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	
	static{
//		dealThreadCount.put("hft_erpdb_cd", 5);
//		dealThreadCount.put("hft_erpdb_zz", 20);
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
				while(true) {
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					List<ErpBuildingPhoto> photoList = null;
					synchronized(ErpBuildingPhotoFastDfsController.class){
						photoList = getPhotoListOrderByPhotoIdDesc(shardDbName);
					}
					// 没有数据时退出循环
					if(photoList == null || photoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					List<ErpBuildingPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
					for (ErpBuildingPhoto erpFunDealPhoto : photoList) {

						String photoAddr = "http://pic.myfun7.com/pic/hftpic/house/" + erpFunDealPhoto.getPhotoAddr();
						FileUploadResult uploadResult = FileUtil.fileUpload(photoAddr, AppConfig.getFileWebUrl(), "0");
						if(null != uploadResult) {
							ErpBuildingPhotoFastdfs fastdfs = new ErpBuildingPhotoFastdfs();
							fastdfs.setPhotoAddr(uploadResult.getFilePath());
							fastdfs.setPhotoId(erpFunDealPhoto.getPhotoId());
							fastdfsPhotoList.add(fastdfs);
						}
						photoDealParam.setIsStart(true);// 有在执行中则一直会被改为处理中
						Thread.sleep(photoDealParam.getSleepTime());
					}
					if(fastdfsPhotoList.isEmpty()) {
						logger.error("-----deal nothing---");
					}else {
						erpBuildingPhotoFastdfsMapper.updatePhotoAddrForList(shardDbName, fastdfsPhotoList);
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

	public List<ErpBuildingPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName) {
		Integer photoId = erpBuildingPhotoFastdfsMapper.selectLastPhotoId(shardDbName);
		List<ErpBuildingPhoto> photoList = erpBuildingPhotoMapper.getPhotoListOrderByPhotoIdDesc(shardDbName, photoId);
		if(photoList == null || photoList.size() <= 0) {
			return null;
		}
		List<ErpBuildingPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (ErpBuildingPhoto erpFunPhoto : photoList) {
			ErpBuildingPhotoFastdfs fastdfs = new ErpBuildingPhotoFastdfs();
			fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
			fastdfs.setCreationTime(new Date());
			fastdfs.setOldAddr(erpFunPhoto.getPhotoAddr());
			fastdfsPhotoList.add(fastdfs);
		}
		erpBuildingPhotoFastdfsMapper.insertList(shardDbName, fastdfsPhotoList);
		return photoList;
	}


}


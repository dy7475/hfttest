package com.myfun.erpWeb.openApi.photoDeal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhotoFastdfs;
import com.myfun.service.business.erpdb.ErpFunPhotoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 图片处理
 * @author 张宏利
 * @since 2017年4月17日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal")
public class PhotoDealController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PhotoDealController.class);
	
	@Autowired ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired ErpFunPhotoService erpFunPhotoService;
	@Autowired ErpFunPhotoFastdfsMapper erpFunPhotoFastdfsMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	
	private volatile static boolean copyFunPhotoToFastdfs = true;
	private volatile static long sleepTime = 50;
	private volatile static Map<String, Integer> dealThreadCount = new HashMap<>();
	
	static{
		dealThreadCount.put("hft_erpdb_cd", 5);
		dealThreadCount.put("hft_erpdb_zz", 20);
	}
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyFunPhotoToFastdfsSwitch")
	public String copyFunPhotoToFastdfsSwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		sleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		int switchVal = StringUtil.paseInteger(request.getParameter("switch"), 0);// 是否启动
		if(switchVal == 1) {
			copyFunPhotoToFastdfs = true;
		} else {
			copyFunPhotoToFastdfs = false;
		}
		String dbName = request.getParameter("threadDbName");
		if(StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if(threadCount <= 0) {
				threadCount = 1;
			}
			dealThreadCount.put(dbName, threadCount);
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("暂停时间", sleepTime);
		resultMap.put("开启状态", copyFunPhotoToFastdfs);
		resultMap.put("线程数", dealThreadCount);
		return new ErpResponseJson(resultMap).toJson();
	}
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyFunPhotoToFastdfs")
	public String validateAllSoSoPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		final int dealSize = StringUtil.paseInteger(request.getParameter("dealSize"), 1);// 每个库处理多少次
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			// 每个库增加不同的线程数
			Integer threadCount = dealThreadCount.get(shardDbName.toLowerCase());
			if(threadCount == null){
				threadCount = 1;
			}
			for (int j = 0; j < threadCount; j++) {
				logger.error("-----create thread---");
				new DealPhotoThread(dealSize, shardDbName).start();
			}
		}
		return new ErpResponseJson().toJson();
	}
	
	/**
	 * 处理拷贝错误的数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/dealCopyFunPhotoWhosError")
	public String dealCopyFunPhotoWhosError(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String shardDbName = "hft_erpdb_ZZ";
		List<ErpFunPhotoFastdfs> photoList = erpFunPhotoFastdfsMapper.dealCopyFunPhotoWhosError(shardDbName);
		// 没有数据时退出循环
		if(photoList == null || photoList.size() <= 0) {
			return "-----no data,return---";
		}
		List<ErpFunPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
		for (ErpFunPhotoFastdfs erpFunPhoto : photoList) {
			String fileName = erpFunPhoto.getOldAddr();
			byte[] remoteImage = new byte[]{};
			if(fileName.startsWith("http://")) {
				remoteImage = HttpUtil.getRemoteImage(fileName);
			} else {
				fileName = fileName.replaceAll("\\\\", "/");
				fileName = "/hftdata/static/pic/hftpic/house/"+fileName;
				remoteImage = FileUtil.getDiskFile(fileName);
			}
			if(remoteImage.length > 0) {
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				String uploadFile = FastdfsManager.uploadFile(remoteImage, fileExt);
				ErpFunPhotoFastdfs fastdfs = new ErpFunPhotoFastdfs();
				fastdfs.setPhotoAddr(uploadFile);
				fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
				fastdfsPhotoList.add(fastdfs);
			}
		}
		if(fastdfsPhotoList.isEmpty()) {
			return "-----deal nothing---";
		}
		erpFunPhotoFastdfsMapper.updatePhotoAddrForList(shardDbName, fastdfsPhotoList);
		return "-----deal over---";
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
					if(!copyFunPhotoToFastdfs) {
						break;
					}
					List<ErpFunPhoto> photoList = null;
					synchronized(PhotoDealController.class){
						photoList = erpFunPhotoService.getPhotoListOrderByPhotoIdDesc(shardDbName);
					}
					// 没有数据时退出循环
					if(photoList == null || photoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					List<ErpFunPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
					for (ErpFunPhoto erpFunPhoto : photoList) {
						String fileName = erpFunPhoto.getPhotoAddr();
						byte[] remoteImage = new byte[]{};
						if(fileName.startsWith("http://")) {
							remoteImage = HttpUtil.getRemoteImage(fileName);
						} else {
							fileName = fileName.replaceAll("\\\\", "/");
							fileName = "/hftdata/static/pic/hftpic/house/"+fileName;
							remoteImage = FileUtil.getDiskFile(fileName);
						}
						if(remoteImage.length > 0) {
							String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							String uploadFile = FastdfsManager.uploadFile(remoteImage, fileExt);
							ErpFunPhotoFastdfs fastdfs = new ErpFunPhotoFastdfs();
							fastdfs.setPhotoAddr(uploadFile);
							fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
							fastdfsPhotoList.add(fastdfs);
						}
						Thread.sleep(sleepTime);
					}
					if(fastdfsPhotoList.isEmpty()) {
						logger.error("-----deal nothing---");
						continue;
					}
					erpFunPhotoFastdfsMapper.updatePhotoAddrForList(shardDbName, fastdfsPhotoList);
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
		}
	}
}


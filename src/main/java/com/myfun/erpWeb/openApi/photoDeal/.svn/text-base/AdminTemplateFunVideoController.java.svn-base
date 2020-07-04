package com.myfun.erpWeb.openApi.photoDeal;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.filter.CaptureFilter;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminTemplateFunVideoMapper;
import com.myfun.repository.admindb.po.AdminTemplateFunVideo;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * admin 试用数据模板 地址处理
 * lcb
 */
@Controller
@RequestMapping(value = "/openApi/adminTemplateFunVideo")
public class AdminTemplateFunVideoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PhotoDealController.class);
	
	@Autowired
	AdminTemplateFunVideoMapper adminTemplateFunVideoMapper;

	private static final LinkedBlockingQueue<Map<String, Object>> FUN_ARCHIVE_FAST_DFS_TMP = new LinkedBlockingQueue<Map<String, Object>>();
	
	private volatile static boolean copyFileToFastdfs = true;
	private volatile static long sleepTime = 50;
	private volatile static Map<String, Integer> dealThreadCount = new HashMap<>();
	
	static{
		// 暂时单个库不增加多线程处理
		//dealThreadCount.put("hft_erpdb_cd", 5);
		//dealThreadCount.put("hft_erpdb_zz", 20);
	}


	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyFileToFastdfsSwitch")
	public String copyVideoToFastdfsSwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		sleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		int switchVal = StringUtil.paseInteger(request.getParameter("switch"), 0);// 是否启动
		if(switchVal == 1) {
			copyFileToFastdfs = true;
		} else {
			copyFileToFastdfs = false;
		}
		int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
		if(threadCount <= 0) {
			threadCount = 1;
		}
		dealThreadCount.put("hft_admindb", threadCount);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("暂停时间", sleepTime);
		resultMap.put("开启状态", copyFileToFastdfs);
		resultMap.put("线程数", dealThreadCount);
		return new ErpResponseJson(resultMap).toJson();
	}

	
	/**
	 * 将以前的视频拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyFileToFastdfs")
	@AccessReadonlyDb
	public String copyFunVideoToFastdfs(HttpServletRequest request, HttpServletResponse response) throws Exception{
		final int dealSize = StringUtil.paseInteger(request.getParameter("dealSize"), 1);// 每个库处理多少次
//		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每admin库
		final String shardDbName = "hft_admindb";
		// 每个库增加不同的线程数
		Integer threadCount = dealThreadCount.get(shardDbName.toLowerCase());
		if(threadCount == null){
			threadCount = 1;
		}
		for (int j = 0; j < threadCount; j++) {
			logger.error("-----create thread---");
			new dealJrFinancePhoto(dealSize).start();
		}
//		开启一个读线程 数据少就不需要单独开线程来读取了
		//new AdminFunArchiveControllerThread().start();
		return new ErpResponseJson().toJson();
	}

	/**
	 * 写入日志
	 *
	 * @author jsg
	 *
	 */
	public class AdminFunArchiveControllerThread extends Thread {
		Logger logger = LoggerFactory.getLogger(CaptureFilter.KafkaWriteAccessLogThread.class);

		List<Map<String, Object>> pMap = new ArrayList<>();
		@Override
		public void run() {
			while (true) {
				try {
					while (pMap.size() < 100) {
						pMap.add(FUN_ARCHIVE_FAST_DFS_TMP.take());
					}
//					adminFunArchiveMapper.insertForFastDfs(pMap);
					System.out.println("---100条-----");
					pMap.clear();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 处理视频的线程
	 * 
	 */
	public class dealJrFinancePhoto extends Thread{
		
		int dealSize = 0;
		public dealJrFinancePhoto(int dealSize){
			this.dealSize = dealSize;
		}
		
		@Override
		public void run() {
			try {
				System.out.println(0<1);
				System.out.println(dealSize);
				for (int i = 0; i < dealSize; i++) {
					System.out.println("xxx");
					// 动态停止
					if(!copyFileToFastdfs) {
						break;
					}
					List<AdminTemplateFunVideo> videoList =  adminTemplateFunVideoMapper.getList();
					// 没有数据时退出循环
					if(videoList == null || videoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					// 一页处理100条
					List<Map<String, Object>> fastdfsFileList = new LinkedList<>();
					for (AdminTemplateFunVideo adminTemplateFunVideo : videoList) {

						String videoAddr = "";
						String photoAddr = "";
						if(StringUtils.isNotBlank(adminTemplateFunVideo.getVideoAddr())) {
							// 拷贝文件
							videoAddr = uploadFile(adminTemplateFunVideo.getVideoAddr());
						}
						if(StringUtils.isNotBlank(adminTemplateFunVideo.getPhotoAddr())) {
							// 拷贝文件
							photoAddr = uploadFile(adminTemplateFunVideo.getPhotoAddr());
						}

						Map<String, Object> fastdfsParamMap = new HashMap<>();
						fastdfsParamMap.put("videoId", adminTemplateFunVideo.getVideoId());

						fastdfsParamMap.put("videoAddrOld", adminTemplateFunVideo.getVideoAddr());
						fastdfsParamMap.put("videoAddrNew", videoAddr);

						fastdfsParamMap.put("photoAddrOld", adminTemplateFunVideo.getPhotoAddr());
						fastdfsParamMap.put("photoAddrNew", photoAddr);
						fastdfsFileList.add(fastdfsParamMap);
						Thread.sleep(sleepTime);
						if(fastdfsFileList.isEmpty()) {
							logger.error("-----deal nothing---");
							continue;
						}
					}
					// 写入新表
					adminTemplateFunVideoMapper.insertForFastDfs(fastdfsFileList);
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 上传文件
	 * @param fileAddr 图片或视频地址
	 * @return 上传到fastdfs上的地址
	 */
	private static String uploadFile(String fileAddr) {
		try{
			fileAddr = fileAddr.replaceAll("\\\\", "/");
			fileAddr = "http://video4.myfun7.com/"+fileAddr;
			InputStream in = getRemoteImage(fileAddr);
			byte[] bytes = toByteArray(in);
			if(bytes.length>0){
				String fileVideoExt = fileAddr.substring(fileAddr.lastIndexOf(".") + 1).toLowerCase();
				String uploadVideoFile = FastdfsManager.uploadFile(bytes, fileVideoExt);
				return uploadVideoFile;
			}
		}catch (Exception e) {

		}
		return null;
	}

	public static byte[] toByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
		}
		return output.toByteArray();
	}

	/**
	 *
	 * 远程获取一张图片
	 * **/
	public final static InputStream getRemoteImage(String imgUrl) {
		ByteArrayOutputStream baos = null;
		InputStream inputStream = null;
		try {
			// "http://192.168.11.171/group1/M00/00/00/wKgLq1jyaTaAIzKtAAAX4fr6QDo823.png"
			URL u = new URL(imgUrl);
			return u.openStream();
		}
		catch (Exception e){
		}
		finally{
			if(baos != null)
			{
				try {
					baos.close();
				} catch (IOException e) {
				}
			}
		}
		return inputStream;
	}

	
}

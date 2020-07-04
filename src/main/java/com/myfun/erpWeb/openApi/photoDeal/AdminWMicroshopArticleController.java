package com.myfun.erpWeb.openApi.photoDeal;

import com.github.pagehelper.PageHelper;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.filter.CaptureFilter;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminWMicroshopArticleMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunArchiveExample;
import com.myfun.repository.admindb.po.AdminWMicroshopArticle;
import com.myfun.repository.admindb.po.AdminWMicroshopArticleExample;
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

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * admin 微店文章默认图片迁移
 * lcb
 */
@Controller
@RequestMapping(value = "/openApi/adminWMicroshopArticlePhoto")
public class AdminWMicroshopArticleController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PhotoDealController.class);
	
	@Autowired
	AdminWMicroshopArticleMapper  adminWMicroshopArticleMapper;

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
//		开启一个读线程
		new AdminFunArchiveControllerThread().start();
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
					adminWMicroshopArticleMapper.insertForFastDfs(pMap);
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
				for (int i = 0; i < dealSize; i++) {
					System.out.println("xxx");
					// 动态停止
					if(!copyFileToFastdfs) {
						break;
					}

					// 分页读取 免得搞死数据库
					AdminWMicroshopArticleExample adminWMicroshopArticleExample = new AdminWMicroshopArticleExample();
					adminWMicroshopArticleExample.createCriteria().andDefaultImageNotLike("group%").andDefaultImageIsNotNull();

					Integer totalCount = adminWMicroshopArticleMapper.countByExample(adminWMicroshopArticleExample);
					adminWMicroshopArticleExample.setOrderByClause(" id ASC");

					//每页显示的记录数
					Integer pageSize=30;
					//页数
					Integer totalPage = (totalCount+pageSize - 1) / pageSize;

					for (Integer j = 1; j <= totalPage ; j++ ) {
						PageHelper.startPage(j, pageSize);
						List<AdminWMicroshopArticle> videoList =  adminWMicroshopArticleMapper.selectByExample(adminWMicroshopArticleExample);
						// 没有数据时退出循环
						if(videoList == null || videoList.size() <= 0) {
							logger.error("-----no data,return---");
							break;
						}
						// 一页处理100条
						List<Map<String, Object>> fastdfsFileList = new LinkedList<>();
						for (AdminWMicroshopArticle adminWMicroshopArticle : videoList) {

							String defaultImage = "";
							if(StringUtils.isNotBlank(adminWMicroshopArticle.getDefaultImage())) {
								// 拷贝文件
								defaultImage = uploadFile(adminWMicroshopArticle.getDefaultImage());
							}

							Map<String, Object> fastdfsParamMap = new HashMap<>();
							fastdfsParamMap.put("wmId", adminWMicroshopArticle.getId());

							fastdfsParamMap.put("defaultImageOld", adminWMicroshopArticle.getDefaultImage());
							fastdfsParamMap.put("defaultImageNew", defaultImage);

							FUN_ARCHIVE_FAST_DFS_TMP.offer(fastdfsParamMap);
							Thread.sleep(sleepTime);
						}
						if(fastdfsFileList.isEmpty()) {
							logger.error("-----deal nothing---");
							continue;
						}
						// 写入新表

//						adminFunArchiveMapper.insertForFastDfs(fastdfsFileList);
					}
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
			fileAddr = "http://pic.myfun7.com/weixin/"+fileAddr;
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
			BufferedImage image = ImageIO.read(u);
			//convert BufferedImage to byte array
			baos = new ByteArrayOutputStream();
			String fileExt = imgUrl.substring(imgUrl.lastIndexOf(".") + 1).toLowerCase();
			ImageIO.write( image, fileExt, baos);
			baos.flush();
			byte[] bytes = baos.toByteArray();
			inputStream = new ByteArrayInputStream(bytes);

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

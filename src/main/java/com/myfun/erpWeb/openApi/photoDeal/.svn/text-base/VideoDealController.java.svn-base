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
import com.myfun.repository.erpdb.dao.ErpFunVideoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunVideoMapper;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.erpdb.po.ErpFunVideoFastdfs;
import com.myfun.service.business.erpdb.ErpFunVideoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 视频处理
 * @author 方李骥
 * @since 2017年5月3日
 */
@Controller
@RequestMapping(value = "/openApi/videoDeal")
public class VideoDealController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(PhotoDealController.class);
	
	@Autowired ErpFunVideoMapper erpFunVideoMapper;
	@Autowired ErpFunVideoService erpFunVideoService;
	@Autowired ErpFunVideoFastdfsMapper erpFunVideoFastdfsMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	
	private volatile static boolean copyFunPhotoToFastdfs = true;
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
	@RequestMapping(value="/copyVideoToFastdfsSwitch")
	public String copyVideoToFastdfsSwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
	 * 将以前的视频拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyVideoToFastdfs")
	public String copyFunVideoToFastdfs(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
				new DealVideoThread(dealSize, shardDbName).start();
			}
		}
		return new ErpResponseJson().toJson();
	}
	/**
	 * 处理视频的线程
	 * 
	 */
	public class DealVideoThread extends Thread{
		
		int dealSize = 0;
		String shardDbName = null;
		public DealVideoThread(int dealSize, String shardDbName){
			this.dealSize = dealSize;
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			try {
				Integer lastVideoId = null;
				for (int i = 0; i < dealSize; i++) {
					// 动态停止
					if(!copyFunPhotoToFastdfs) {
						break;
					}
					List<ErpFunVideo> videoList = null;
					synchronized(VideoDealController.class){
						videoList = erpFunVideoService.getVideoListOrderByVideoIdDesc(shardDbName, lastVideoId);
					}
					// 没有数据时退出循环
					if(videoList == null || videoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					List<ErpFunVideoFastdfs> fastdfsVideoList = new LinkedList<>();
					for (ErpFunVideo erpFunVideo : videoList) {
						// 拷贝文件
						String newPhotoAddr = uploadFile(erpFunVideo.getPhotoAddr());
						String newVideoAddr = uploadFile(erpFunVideo.getVideoAddr());
						// 处理的有文件
						if(newPhotoAddr != null || newVideoAddr != null) {
							ErpFunVideoFastdfs fastdfs = new ErpFunVideoFastdfs();
							fastdfs.setVideoId(erpFunVideo.getVideoId());
							if(newPhotoAddr != null) {
								fastdfs.setPhotoAddr(newPhotoAddr);// 图片
							}
							if(newVideoAddr != null){
								fastdfs.setVideoAddr(newVideoAddr);// 视频
							}
							fastdfsVideoList.add(fastdfs);
						}
						if(lastVideoId == null || lastVideoId > erpFunVideo.getVideoId()) {
							lastVideoId = erpFunVideo.getVideoId();
						}
						Thread.sleep(sleepTime);
					}
					if(fastdfsVideoList.isEmpty()) {
						logger.error("-----deal nothing---");
						continue;
					}
					erpFunVideoFastdfsMapper.updateVideoAddrForList(shardDbName, fastdfsVideoList);
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
		byte[] fileByte = new byte[]{};
		if(fileAddr.startsWith("http://")) {
			fileByte = HttpUtil.getFileByUrl(fileAddr);
		} else {
			fileAddr = fileAddr.replaceAll("\\\\", "/");
			fileAddr = "/hftdata/video/"+fileAddr;
			fileByte = FileUtil.getDiskFile(fileAddr);
		}
		if(fileByte.length>0){
			String fileVideoExt = fileAddr.substring(fileAddr.lastIndexOf(".") + 1).toLowerCase();
			String uploadVideoFile = FastdfsManager.uploadFile(fileByte, fileVideoExt);
			return uploadVideoFile;
		}
		return null;
	}
	
}

package com.myfun.erpWeb.openApi.photoDeal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import javax.imageio.ImageIO;
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
import com.myfun.repository.agencydb.dao.AgencyBuildingPhotoMapper;
import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoFastdfsMapper;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.StringUtil;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 合同相关图片处理
 * http://pic.myfun7.com/pic/hftpic/house/2016/04/1_1/AA01D0/FunDeal/101/
 * 93360c5a-ab00-4b2b-9995-7f094051c4fc.png
 * 
 * @author 张宏利
 * @since 2017年5月16日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal/agencyBuildingPhotoCompressPngController")
public class AgencyBuildingPhotoCompressPngController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AgencyBuildingPhotoCompressPngController.class);

	@Autowired
	ErpFunDealPhotoService erpFunDealPhotoService;
	@Autowired
	ErpFunDealPhotoFastdfsMapper erpFunDealPhotoFastdfsMapper;
	@Autowired
	AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	AgencyBuildingPhotoMapper agencyBuildingPhotoMapper;
	// 处理的参数
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();

	private static ArrayBlockingQueue<List<AgencyBuildingPhoto>> AGENCY_BUILD_PHOTO_QUEYE = new ArrayBlockingQueue<List<AgencyBuildingPhoto>>(
			50);

	static {
		// dealThreadCount.put("hft_erpdb_cd", 5);
		// dealThreadCount.put("hft_erpdb_zz", 20);
	}

	/**
	 * 参数配置页--所有处理统一的 需要在页面上配置各个处理的copySwitch和startCopy地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manage")
	public String manage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "openApi/dealPhoto/dealPhotoManage";
	}

	/**
	 * 将以前的图片拷贝到fastdfs中
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/copySwitch")
	public ErpResponseJson copySwitch(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	 * 将以前的图片拷贝到fastdfs中
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/startCopy")
	public ErpResponseJson startCopy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//开启查询
		new QueryPhotoThread().start();
		
		//开启处理
		new DealPhotoThread().start();
		new DealPhotoThread().start();
		new DealPhotoThread().start();
		new DealPhotoThread().start();
		new DealPhotoThread().start();
		new DealPhotoThread().start();
		
		
		return ErpResponseJson.ok();
	}

	/**
	 * 查询线程
	 * 
	 * @author Administrator
	 *
	 */
	public class QueryPhotoThread extends Thread {
		public QueryPhotoThread() {
			System.out.println("初始化查询线程。。。。。。。。。");
		}

		@Override
		public void run() {
			int i = 0;
			while (true) {
				if (agencyBuildingPhotoMapper.lockTransplantTmpPhoto(++i) > 0) {
					List<AgencyBuildingPhoto> agencyBuildingPhotos = agencyBuildingPhotoMapper.getTransplantTmpPhoto(i);
					try {
						System.out.println("生产队里大小->" + agencyBuildingPhotos.size());
						System.out.println("当前队列大小->" + AGENCY_BUILD_PHOTO_QUEYE.size());
						AGENCY_BUILD_PHOTO_QUEYE.put(agencyBuildingPhotos);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					break;
				}
			}
		}
	}

	/**
	 * 处理图片的线程
	 * 
	 * @author 张宏利
	 * @since 2017年4月27日
	 */
	public class DealPhotoThread extends Thread {

		public DealPhotoThread() {
			System.out.println("初始化处理线程0000000000");
		}

		@Override
		public void run() {
			while(true){
				try {
					List<AgencyBuildingPhoto> agencyBuildingPhotos = AGENCY_BUILD_PHOTO_QUEYE.take();
					System.out.println("消费一个大小->" + agencyBuildingPhotos.size());
					System.out.println("消费当前队列大小->" + AGENCY_BUILD_PHOTO_QUEYE.size());
					if(agencyBuildingPhotos.isEmpty()){
						continue;
					}
					for (AgencyBuildingPhoto agencyBuildingPhoto : agencyBuildingPhotos) {
						if(agencyBuildingPhoto == null){
							continue;
						}
						String photoAddr = agencyBuildingPhoto.getPhotoAddr();
						String newAddr = "";
						try {
							String fileName = StringUtil.getUUIDBySub()+".jpg";
							BufferedImage image = ImageIO.read(new URL("http://img01-uat.m1200.com.cn/"+photoAddr));
				            Thumbnails.of(image).scale(1.0).toFile(new File("/tmp/" + fileName));
							newAddr = FileUtil.uploadFileToFastdfs("/tmp/", fileName);
						} catch (Exception e) {
							e.printStackTrace();
						}
						agencyBuildingPhotoMapper.updateTransplantTmpPhotoByPhotoId(agencyBuildingPhoto.getPhotoId(),
								newAddr);
						System.out.println("处理成功" + agencyBuildingPhoto.toString());
					}
				} catch (Exception e) {
					logger.error("-----error,over---");
					e.printStackTrace();
				}
			}
		}
	}
}

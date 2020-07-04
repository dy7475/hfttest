package com.myfun.erpWeb.openApi.photoDeal;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.csource.FastdfsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminSosoBuildingPhotoFastdfsMapper;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhoto;
import com.myfun.repository.admindb.po.AdminSosoBuildingPhotoFastdfs;
import com.myfun.service.business.admindb.AdminSosoBuildingPhotoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.StringUtil;

/**
 * 图片处理
 * @author 张宏利
 * @since 2017年4月17日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal")
public class BuildingPhotoDealController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(BuildingPhotoDealController.class);
	
	@Autowired AdminSosoBuildingPhotoService adminSosoBuildingPhotoService;
	@Autowired AdminSosoBuildingPhotoFastdfsMapper adminSosoBuildingPhotoFastdfsMapper;
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyBuildingPhotoToFastdfs")
	public String validateAllSoSoPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		final int dealSize = StringUtil.paseInteger(request.getParameter("dealSize"), 1);// 每个库处理多少次
		for (int i = 0; i < 1; i++) {
			new DealPhotoThread(dealSize).start();
		}
		return new ErpResponseJson().toJson();
	}

	/**
	 * 处理图片的线程
	 * @author 张宏利
	 * @since 2017年4月27日
	 */
	public class DealPhotoThread extends Thread{
		
		int dealSize = 0;
		public DealPhotoThread(int dealSize){
			this.dealSize = dealSize;
		}
		
		@Override
		public void run() {
			try {
				for (int i = 0; i < dealSize; i++) {
					List<AdminSosoBuildingPhoto> photoList = null;
					synchronized(BuildingPhotoDealController.class){
						photoList = adminSosoBuildingPhotoService.getPhotoListOrderByPhotoIdDesc();
					}
					// 没有数据时退出循环
					if(photoList == null || photoList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					List<AdminSosoBuildingPhotoFastdfs> fastdfsPhotoList = new LinkedList<>();
					for (AdminSosoBuildingPhoto erpFunPhoto : photoList) {
						String fileName = erpFunPhoto.getPhotoAddr();
						fileName = fileName.replaceAll("\\\\", "/");
						fileName = "/hftdata/static/pic/hftpic/net/"+fileName;
						byte[] remoteImage = FileUtil.getDiskFile(fileName);
						if(remoteImage.length > 0) {
							String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
							String uploadFile = FastdfsManager.uploadFile(remoteImage, fileExt);
							AdminSosoBuildingPhotoFastdfs fastdfs = new AdminSosoBuildingPhotoFastdfs();
							fastdfs.setPhotoAddr(uploadFile);
							fastdfs.setPhotoId(erpFunPhoto.getPhotoId());
							fastdfsPhotoList.add(fastdfs);
						}
						Thread.sleep(50);
					}
					if(fastdfsPhotoList.isEmpty()) {
						logger.error("-----deal nothing---");
						continue;
					}
					adminSosoBuildingPhotoFastdfsMapper.updatePhotoAddrForList(fastdfsPhotoList);
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
		}
	}
}


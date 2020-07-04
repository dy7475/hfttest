package com.myfun.erpWeb.openApi.photoDeal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
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
import com.myfun.repository.admindb.dao.AdminFunArchiveFastdfsMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunArchiveFastdfs;
import com.myfun.repository.erpdb.dao.ErpFunPhotoFastdfsMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.FileUtil;
import com.myfun.utils.StringUtil;

/**
 * fun_archive相关图片处理
 * URL：http://pic.myfun7.com/pic/ID_CARD/18_193/SMALL/QZ0D11002_2.JPG
 * DISK：/hftdata/static/pic/ID_CARD/18_193/SMALL/QZ0D11002_2.JPG
 * DATABASE：ID_CARD/18_193/SMALL/QZ0D11002_2.JPG
 * http://pic.myfun7.com/pic/HEAD/18_193/SMALL/QZ0D11002_1.JPG
 * http://pic.myfun7.com/pic/HEAD/18_193/SMALL/QZ0D11002_MIN.JPG
 * http://pic.myfun7.com/pic/NAME_CARD\18_193\SMALL\QZ0D11002_3.JPG
 * http://pic.myfun7.com/pic/FACE/default/003_40_40.png
 * http://pic.myfun7.com/pic/SHOP\18_193\SMALL\QZ0D11002_4.JPG
 * http://pic.myfun7.com/pic/SHOP\18_193\SMALL\QZ0D11002_5.JPG
 * @author 张宏利
 * @since 2017年5月16日
 */
@Controller
@RequestMapping(value = "/openApi/photoDeal/funArchive")
public class FunArchiveController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FunArchiveController.class);
	
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired AdminFunArchiveFastdfsMapper adminFunArchiveFastdfsMapper;
	@Autowired ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired ErpFunDealPhotoService erpFunDealPhotoService;
	@Autowired ErpFunPhotoFastdfsMapper erpFunPhotoFastdfsMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;

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
		logger.error("-----create thread---");
		new DealPhotoThread(photoDealParam.getDealCount()).start();
		return ErpResponseJson.ok();
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
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					Integer archiveId = adminFunArchiveFastdfsMapper.selectLastArchive();
					AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectLastArchive(archiveId);
					if(adminFunArchive == null) {
						logger.error("-----no data,return---");
						break;
					}
					AdminFunArchiveFastdfs inAdminFunArchiveFastdfs = new AdminFunArchiveFastdfs();
					inAdminFunArchiveFastdfs.setArchiveId(adminFunArchive.getArchiveId());
					inAdminFunArchiveFastdfs.setIsDeal((byte)0);
					// 修改参数
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "icPhoto1");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "icPhoto2");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "userPhoto");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "userPhotoMin");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "cardPhoto");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "bbsPhoto");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "shopInnerPhoto");
					updateProperty(adminFunArchive, inAdminFunArchiveFastdfs, "shopOuterPhoto");
					// 插入至数据库
					adminFunArchiveFastdfsMapper.insertHaveArchiveId(inAdminFunArchiveFastdfs);
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
			photoDealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
	
	/**
	 * 下载adminFunArchive的picKey的图片到fastdfs
	 * 然后将图片地址放到adminFunArchiveFastdfs的picKey，同时将老的地址存入picKeyOld
	 * @author 张宏利
	 * @since 2017年5月19日
	 * @param adminFunArchive
	 * @param adminFunArchiveFastdfs
	 * @param picKey
	 */
	public static void updateProperty(AdminFunArchive adminFunArchive, AdminFunArchiveFastdfs adminFunArchiveFastdfs, String picKey){
		try {
			String picKeyOld = picKey + "Old";
			String picKeyVal = BeanUtils.getProperty(adminFunArchive, picKey);
			if(StringUtils.isNotBlank(picKeyVal)) {
				BeanUtils.setProperty(adminFunArchiveFastdfs, picKeyOld, picKeyVal);
				String newAddr = null;
				if(picKeyVal.startsWith("group")) {
					newAddr = picKeyVal;
				} else {
					newAddr = FileUtil.uploadFileToFastdfs("/hftdata/static/pic/", picKeyVal);
				}
				if(newAddr != null) {
					BeanUtils.setProperty(adminFunArchiveFastdfs, picKey, newAddr);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


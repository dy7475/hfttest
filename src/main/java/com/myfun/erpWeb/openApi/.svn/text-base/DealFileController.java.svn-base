package com.myfun.erpWeb.openApi;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDealPhotoMapper;
import com.myfun.repository.erpdb.po.ErpFunDealPhoto;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.service.business.erpdb.ErpFunDealPhotoService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.HttpUtil;

/**
 * 外部文件上传
 * @author 张宏利
 * @since 2017年4月17日
 */
@Controller
@RequestMapping(value = "/openApi/dealFile")
public class DealFileController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(DealFileController.class);
	
	@Autowired ErpFunDealPhotoService erpFunDealPhotoService;
	@Autowired ErpFunDealPhotoMapper erpFunDealPhotoMapper;

	/**
	 * 获取上传测试页面
	 * @author 张宏利
	 * @since 2017年3月15日
	 * @return
	 */
	@RequestMapping(value = "/uploadFileTest")
	public String uploadFileTest() {
		return "testPage/uploadFileTest";
	}
	
	/**
	 * 合同及补充协议上传
	 * @author 张宏利
	 * @since 2017年4月20日
	 * @param request
	 * @param cityId 城市ID
	 * @param dealId 合同ID
	 * @param fileType 文件类型 5=合同文件 6=补充协议文件
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/uploadDealFile")
	public String uploadDealPdf(StandardMultipartHttpServletRequest request, Integer cityId, Integer dealId, Integer photoType) throws Exception {
		try {
			if(cityId == null || dealId == null || photoType == null) {
				return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "参数错误").toJson();
			}
			if(photoType != 5 && photoType != 6) {
				return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "参数错误").toJson();
			}
			Map<String, MultipartFile> multiFileMap = request.getFileMap();
			for (MultipartFile multipartFile : multiFileMap.values()) {
				String fileName = multipartFile.getOriginalFilename();
				byte[] bytes = multipartFile.getBytes();
				logger.debug("图片名：{}，图片大小：{}", fileName, bytes.length);
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
				String filePath = FastdfsManager.uploadFile(multipartFile.getBytes(), fileExt);
				if(StringUtils.isBlank(filePath)) {
					continue;
				}
				erpFunDealPhotoService.uploadDealFile(cityId, dealId, photoType, filePath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "处理失败").toJson();
		}
		return new ErpResponseJson(ResponseCode.SUCCESS, "处理完成").toJson();
	}
	
	/**
	 * 获取合同及补充协议
	 * @author 张宏利
	 * @since 2017年4月20日
	 * @param request
	 * @param cityId 城市ID
	 * @param dealId 合同ID
	 * @param fileType 文件类型 5=合同文件 6=补充协议文件
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getDealFileList")
	public String getDealFileList(Integer cityId, Integer dealId, Integer photoType) throws Exception {
		if(cityId == null || dealId == null) {
			return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "参数错误").toJson();
		}
		if(photoType != null && photoType != 5 && photoType != 6) {
			return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "参数错误").toJson();
		}
		List<ErpFunDealPhoto> photoList = erpFunDealPhotoMapper.getDealFiles(cityId, null, dealId, photoType);
		if(photoList.isEmpty()) {
			createDealFile(cityId, dealId, photoType);
		} else {
			String accessDomain = FastdfsManager.getHttpAccessDomain();
			for (ErpFunDealPhoto erpFunDealPhoto : photoList) {
				if(erpFunDealPhoto.getPhotoAddr() != null) {
					erpFunDealPhoto.setPhotoAddr(accessDomain + erpFunDealPhoto.getPhotoAddr());
				}
			}
		}
		return new ErpResponseJson(photoList).toJson();
	}
	
	/**
	 * 创建合同及补充协议
	 * @author 张宏利
	 * @since 2017年4月20日
	 * @param request
	 * @param cityId 城市ID
	 * @param dealId 合同ID
	 * @param fileType 文件类型 5=合同文件 6=补充协议文件
	 * @throws Exception
	 */
	public void createDealFile(Integer cityId, Integer dealId, Integer photoType) throws Exception {
		// 创建记录
		Map<String, Object> createDealFile = erpFunDealPhotoService.createDealFile(cityId, dealId, photoType);
		// 通知c++服务器创建文件
		if(createDealFile != null) {
			String jsonString = JSON.toJSONString(createDealFile);
			jsonString = EncryptHelper.enBase64(jsonString);
			Map<String, Object> param = new HashMap<>();
			param.put("callBackUrl", AppConfig.getErpWebUrl() + "/openApi/dealFile/uploadDealFile");
			param.put("data", jsonString);
			param.put("charset0", Charset.defaultCharset());
			param.put("charset1", System.getProperty("file.encoding"));
			param.put("serverTime", DateTimeHelper.formatDateTimetoString(new Date()));
			HttpUtil.post(AppConfig.getProperty("common.erpWeb.cpp.createDeal.server")+"/printContract", param);
		}
	}
}


package com.myfun.erpWeb.openApi.photoDeal;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.searchdb.dao.SearchPhotoZjMapper;
import com.myfun.repository.searchdb.po.SearchPhotoZj;
import com.myfun.utils.FileUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 搜搜图片处理，标记是否有效
 * @author 张宏利
 * @since 2017年1月17日
 */
@Controller
@RequestMapping(value = "/openApi/soSoPhoto")
public class SosoPhotoZjValidate extends BaseController{
	
	@Autowired SearchPhotoZjMapper searchPhotoZjMapper;
	
	/**
	 * 处理搜搜图片标记为是否有效
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/validateAllSoSoPhoto")
	public String validateAllSoSoPhoto(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int start = StringUtil.paseInteger(request.getParameter("start"), 0);// 扫描开始城市ID
		int end = StringUtil.paseInteger(request.getParameter("end"), 10);// 扫描结束城市ID
		final int counts = StringUtil.paseInteger(request.getParameter("counts"), 10);// 扫描次数
		final int pageSize = StringUtil.paseInteger(request.getParameter("pageSize"), 1000);// 每次扫描多少条数据
		for (int index = start; index < end; index++) {
			final String nowIndex = String.valueOf(index);
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("-----scan start-----");
						for (int i = 0; i < counts; i++) {
							List<SearchPhotoZj> needValidatePhotoList = searchPhotoZjMapper.getNeedValidatePhotoList(pageSize, nowIndex);
							// 没有数据时推出循环
							if(needValidatePhotoList == null || needValidatePhotoList.size() <= 0) {
								System.out.println("-----no data,return---");
								return;
							}
							for (SearchPhotoZj searchPhotoZj : needValidatePhotoList) {
								String isValid = "3";
								String addr = searchPhotoZj.getPhotoAddr();
								if(StringUtils.isBlank(addr)) {
									isValid = "7";
								} else {
									if(addr.startsWith("http://")) {
										if(!HttpUtil.isRealImg(addr)) {
											isValid = "7";
										}
									} else {
										addr = addr.replaceAll("\\\\", "/");
										addr = "/hftdata/static/pic/hftpic/net/"+addr;
										boolean isRealDiskFile = FileUtil.isRealDiskFile(addr);
										if(!isRealDiskFile) {
											isValid = "7";
										}
									}
								}
								searchPhotoZjMapper.updateIsValid(isValid, searchPhotoZj);
							}
							Thread.sleep(500);
						}
						System.out.println("-----deal over---");
					} catch (Exception e) {
						System.out.println("-----error,over---");
						e.printStackTrace();
					}
				}
			}).start();
		}
		return new ErpResponseJson().toJson();
	}
}


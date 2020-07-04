package com.myfun.erpWeb.openApi.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.manage.aspect.TokenValidate;
import com.myfun.framework.config.AppConfig;
import com.myfun.utils.FileUtil;

/**
 * 日志文件获取相关
 * @author 张宏利
 * @since 2017年5月19日
 */
@Controller
@TokenValidate
@RequestMapping("/openApi/sysManage")
public class LogFileManageController {

	@ResponseBody
	@RequestMapping("/getLogFileLastLins")
	public String getLogFileLastLins(
			@RequestParam(defaultValue="0") Integer log,// 日志下标，配有多个日志，需要选择查看配置的哪一个
			@RequestParam(defaultValue="0") Long lineCount,// 查看多少行
			@RequestParam(defaultValue="<br/>") String br// 使用什么换行
			){
		String logFileDiskPath = AppConfig.getLogFileDiskPath(log);
		if(lineCount > 10000) {
			lineCount = 10000L;
		}
		String readLastLines = FileUtil.readLastLines(logFileDiskPath, lineCount, br);
		return readLastLines;
	}
}

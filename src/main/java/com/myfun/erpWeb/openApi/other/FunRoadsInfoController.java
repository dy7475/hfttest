package com.myfun.erpWeb.openApi.other;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunRoadsInfoMapper;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfo;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfoExample;
import com.myfun.utils.Pinyin4jUtil;

@Controller
@RequestMapping(value = "/openApi/adress")
public class FunRoadsInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(FunRoadsInfoController.class);
	@Resource ErpFunRoadsInfoMapper erpFunRoadsInfoMapper;

	/**
	 * 处理干道信息，生成字母
	 * @author 张宏利
	 * @since 2018年1月5日
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/dealRoadsInfoCode")
	public ErpResponseJson dealRoadsInfoCode(HttpServletRequest request, HttpServletResponse response) {
		final String shardDbName = request.getParameter("dbName");
		if (StringUtils.isBlank(shardDbName)) {
			return ErpResponseJson.warn("请先选择库");
		}
		// 生成干道首字母使用
		ErpFunRoadsInfoExample example = new ErpFunRoadsInfoExample();
		example.setShardDbName(shardDbName);
		List<ErpFunRoadsInfo> roadsInfoList = erpFunRoadsInfoMapper.selectByExample(example);
		roadsInfoList.stream().forEach(road -> {
			ErpFunRoadsInfo record = new ErpFunRoadsInfo();
			record.setShardDbName(shardDbName);
			record.setId(road.getId());
			record.setRoadsCode(Pinyin4jUtil.converterToFirstSpell(road.getRoadsName()));
			erpFunRoadsInfoMapper.updateByPrimaryKeySelective(record);
		});
		logger.info("==over==");
		return ErpResponseJson.ok();
	}
}

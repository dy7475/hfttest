package com.myfun.erpWeb.noticeInfo.goodNews;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.myfun.erpWeb.noticeInfo.vo.DealBulletListVo;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminBulletMapper;
import com.myfun.repository.admindb.po.AdminBulletWithBLOBs;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dto.DealBulletDto;
import com.myfun.service.business.admindb.AdminBulletService;
import com.myfun.service.business.erpdb.ErpFunDealService;
import com.myfun.service.business.erpdb.bean.param.DealBulletListParam;
import com.myfun.utils.DateTimeHelper;
@Api(tags ="喜报模块")
@Controller
@RequestMapping("/noticeInfo/goodNews")
public class DealBulletController extends BaseController {
	
	@Autowired ErpFunDealService erpFunDealService;
	@Autowired AdminBulletMapper adminBulletMapper;
	@Autowired AdminBulletService adminBulletService;
	@Autowired ErpFunDealMapper erpFunDealMapper;

	@ApiOperation("获取喜报列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DealBulletListVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getDealBulletList")
	public ResponseJson getDealBulletList(@Valid @RequestBody DealBulletListParam param) throws Exception {
		Operator operator = getOperator();
		param.setAdminCompId(operator.getAdminCompId());
		param.setCompId(operator.getCompId());
		if(StringUtils.isNotBlank(param.getBuildName())) {
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		if(StringUtils.isNotBlank(param.getContractNo())) {
			param.setContractNo("%"+param.getContractNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getStartTime())) {
			param.setStartTime(param.getStartTime()+" 00:00:00");
		}
		if(StringUtils.isNotBlank(param.getEndTime())) {
			param.setEndTime(param.getEndTime()+" 23:59:59");
		}
		if(StringUtils.isBlank(param.getOrderBy())){
			param.setOrderBy("B.BULLET_TIME DESC");
		}
		param.setIsCount("0");
		List<DealBulletDto> list = erpFunDealMapper.selectDealBulletList(operator.getCityId(), param);
		PageInfo<DealBulletDto> pageInfo = new PageInfo<>(list);
		pageInfo.setPageNum(param.getPageOffset());
		if (list.size() > 0 && list.size() <= param.getPageRows()) {
			param.setIsCount("1");
			Integer count = erpFunDealMapper.selectDealBulletListCount(operator.getCityId(), param);
			pageInfo.setTotal(count);
		} else {
			pageInfo.setTotal(list.size());
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 发布喜报
	 * @author 熊刚
	 * @since 2017年6月29日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateReleaseStatus")
	public ResponseJson updateReleaseStatus(@Valid @RequestBody BaseMapParam paramMap) throws Exception {
		Operator operator = getOperator();
		Date date = DateTimeHelper.getSystemDate();
		String nowTime = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMddHHmmssS);
		paramMap.setInteger("userId", operator.getUserId());
		paramMap.setInteger("bcType", 1);
		paramMap.setInteger("bound", 8);
		paramMap.setInteger("archiveId", operator.getArchiveId());
		paramMap.setInteger("compId", operator.getCompId());
		paramMap.setString("createTime", nowTime);
		erpFunDealService.updateByPrimaryKeys(operator.getCityId(), paramMap);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取编辑喜报详情
	 * @author 熊刚
	 * @since 2017年6月29日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/getGoodNewsHtmlContent")
	public ResponseJson getGoodNewsHtmlContent(@Valid @RequestBody BaseMapParam param) throws Exception {
		AdminBulletWithBLOBs adminBulletWithBLOBs = adminBulletMapper.selectByBulletId(param.getMap());
		return ErpResponseJson.ok(adminBulletWithBLOBs);
	}
	
	/**
	 * 保存喜报
	 * @author 熊刚
	 * @since 2017年6月29日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/updateGoodNewsHtmlContent")
	public ResponseJson updateGoodNewsHtmlContent(@Valid @RequestBody BaseMapParam param) throws Exception {
		String bulletContent = param.getString("bulletContent");
		String newsBackUrl = param.getString("newsBackUrl");
		AdminBulletWithBLOBs adminBulletWithBLOBs = adminBulletMapper.selectByBulletId(param.getMap());
		adminBulletWithBLOBs.setBulletContent(bulletContent);
		adminBulletWithBLOBs.setNewsBackUrl(newsBackUrl);
		adminBulletService.updateByPrimaryKey(adminBulletWithBLOBs);
		return ErpResponseJson.ok();
	}
}

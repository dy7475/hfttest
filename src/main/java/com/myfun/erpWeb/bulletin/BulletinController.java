package com.myfun.erpWeb.bulletin;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.myfun.erpWeb.bulletin.param.BulletinListParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminBanMapper;
import com.myfun.repository.admindb.dao.AdminBulletMapper;
import com.myfun.repository.admindb.dao.AdminBulletReplyMapper;
import com.myfun.repository.admindb.dao.AdminBulletinPsMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUsersCountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminVoteLogMapper;
import com.myfun.repository.admindb.dao.AdminVoteMapper;
import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.dto.AdminBulletReplyDto;
import com.myfun.repository.admindb.dto.AdminBulletinPsDto;
import com.myfun.repository.admindb.dto.AdminFunUsersCountDto;
import com.myfun.repository.admindb.dto.AdminVoteDto;
import com.myfun.repository.admindb.po.AdminBulletReply;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.admindb.po.AdminVote;
import com.myfun.repository.admindb.po.AdminVoteLog;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunRegMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.param.ReqBulletinHouseListParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.condition.Condition;
import com.myfun.repository.support.mybatis.condition.ConditionItem;
import com.myfun.repository.support.param.PageParam;
import com.myfun.service.business.admindb.AdminBulletService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.OperatorSessionUtil;
import com.myfun.utils.StringUtil;

/**
 * @TODO 帖子模块
 * @author lcb
 * 
 */

@Controller
@RequestMapping("/bulletin")
@Deprecated
public class BulletinController extends BaseController {
	
	@Autowired
	AdminBulletService adminBulletService;
	@Autowired
	AdminVoteMapper adminVoteMapper;
	@Autowired
	AdminVoteLogMapper adminVoteLogMapper;
	@Autowired
	AdminBulletinPsMapper adminBulletinPsMapper;
	@Autowired
	ErpFunRegMapper erpFunRegMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	AdminBulletMapper adminBulletMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	AdminFunUsersCountMapper adminFunUsersCountMapper;
	@Autowired
	AdminBanMapper adminBanMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	AdminBulletReplyMapper adminBulletReplyMapper;
	@Autowired
	ErpFunTaskMapper erpFunTaskMapper;

	/**
	 * 获取公告信息
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param request
	 * @param bulletBound
	 * @param bulletId
	 * @param caseType
	 * @param housingIds
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createBulletin")
	public String getCreateBulletinPage(HttpServletRequest request, String bulletBound, Integer bulletId, String caseType, String housingIds, ModelMap modelMap) throws Exception {
		Operator operator = getOperator();
		modelMap.put("bulletBound", bulletBound);
		modelMap.put("bulletId", bulletId);
		modelMap.put("CLIENTKEY", request.getParameter("CLIENTKEY"));
		modelMap.put("operator", operator);
		if(operator.isPersonalVersion()){
			modelMap.put("ADD_COMMUNIC_INFO", true);
		}else{// 权限
			ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "ADD_COMMUNIC_INFO");
			modelMap.put("ADD_COMMUNIC_INFO", erpUserOpers != null);
		}
		// 权限
		boolean pubBulletinInfoOper = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "PUB_BULLETIN_INFO_OPER") != null;
		if("8".equals(bulletBound)){
			pubBulletinInfoOper = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "GOODNEWS_MANAGE") != null;
		}
		modelMap.put("PUB_BULLETIN_INFO_OPER", pubBulletinInfoOper);
		AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("BULLETIN_INFO_DAY");
		if (adminSysPara != null) {
			modelMap.put("BULLETIN_INFO_DAY", adminSysPara.getParamValue());
		}
		AdminSysPara adminSysParaBu = adminSysParaMapper.selectByPrimaryKey("BULLETIN_INFO");
		if (adminSysParaBu != null) {
			modelMap.put("BULLETIN_INFO", adminSysParaBu.getParamValue());
		}
		// 当前公司是否关闭同城交流
//		ErpSysParaKey paraKey = new ErpSysParaKey();
//		paraKey.setCompId(operator.getCompId());
//		paraKey.setParamId("ALLOW_CITY_BBS");
//		paraKey.setShardCityId(operator.getCityId());
//		ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(paraKey);
		ErpSysPara erpSysPara = erpSysParaMapper.getValueById(operator.getCityId(), operator.getCompId(), "ALLOW_CITY_BBS");

		modelMap.put("ALLOW_CITY_BBS", erpSysPara==null?"0":erpSysPara.getParamValue());
		// 判断是否有房源需要发布
		if (StringUtils.isNotEmpty(housingIds)) {
			List<ErpBulletHouseDto> dataObjects = null;
			if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
				dataObjects = erpFunSaleMapper.getSaleListForCreateBullet(operator.getCompId(), operator.getCityId(), housingIds.split(","));
			} else {
				dataObjects = erpFunLeaseMapper.getLeaseListForCreateBullet(operator.getCompId(), operator.getCityId(), housingIds.split(","));
			}
			modelMap.put("houseList", dataObjects);
			// 获取房源图片情况
			if (dataObjects != null) {
				List<ErpFunPhotoDto> picList = erpFunPhotoMapper.getPhotoList(operator.getCompId(), operator.getCityId(), Integer.valueOf(caseType), housingIds.split(","));
				for (ErpBulletHouseDto houseInfo : dataObjects) {
					StringBuilder picStr = new StringBuilder();
					for (ErpFunPhotoDto picInfo : picList) {
						if (houseInfo.getId() != null && houseInfo.getId().equals(picInfo.getCaseId())) {
							picStr.append(picInfo.getPhotoAddr().replaceAll("\\\\", "/")).append(";");
						}
					}
					houseInfo.setPicList(picStr.toString());
				}
			}
		}
		// 判断是否是编辑
		if (bulletId != null) {
			// 查询出公告信息和投票信息
			AdminBulletDto dataObject = adminBulletMapper.getBulletByBulletId(Integer.valueOf(bulletId));
			// 组装数据
			AdminFunArchive archivePO = adminFunArchiveMapper.selectByPrimaryKey(dataObject.getArchiveId());
			AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByPrimaryKey(dataObject.getDeptId());
			if(adminFunDeptsPO == null){
				dataObject.setDeptName("网络经纪人");
			}else {
				dataObject.setDeptName(adminFunDeptsPO.getDeptName());
			}
			if(archivePO != null){
				dataObject.setUserMobile(archivePO.getUserMobile());
				dataObject.setUserName(archivePO.getUserName());
				dataObject.setUserPhotoMin(CommonUtil.getBbsPhoto(archivePO.getBbsPhoto()));
				dataObject.setBbsName(archivePO.getNickName());
				dataObject.setRealPhoto(archivePO.getUserPhotoMin());
			}
			//把内容中的单双引号改下
			String bulletContent = dataObject.getBulletContent();
			if(StringUtils.isNotEmpty(bulletContent)){
				bulletContent = bulletContent.replaceAll("'", "\\\\'");
				dataObject.setBulletContent(bulletContent);
			}
			modelMap.put("bulletinInfo", dataObject);
			// 当前帖子是否可编辑
			boolean canEditBulletin = canEditBulletin(operator, dataObject);
			modelMap.put("canEdit", canEditBulletin);
			//获取公告附件
			if(bulletBound.equals("0") || bulletBound.equals("1") || bulletBound.equals("7")){
				List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
				modelMap.put("bulletinPsPOs", bulletinPsPOs);
			}
		}
		return "bulletin/createBulletin";
	}

	/**
	 * 设置值
	 * @param request
	 * @param response
	 * @param paramMap 参数传递
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/setParameter")
	public void setParameter(HttpServletRequest request, String key, String value) throws Exception{
		Operator operator = getOperator();
		if(key == null || key.trim().length() <1){
			throw new Exception("参数不能为空");
		}
		operator.setAttribute(key, value);
	}
	
	/**
	 * 返回参数key对应的参数
	 * @param request
	 * @param response
	 * @param paramMap 参数传递
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getParameter")
	public void getParameter(HttpServletRequest request, HttpServletResponse response, String key) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		Operator operator =getOperator();
		//返回json值
		if(key == null || key.trim().length() <1){
			throw new Exception("获取参数失败");
		}
		String value = (String) operator.getAttribute(key);
		String jsonStr = "{\"" +key+ "\":\"" +value+ "\"}";
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		pw.write(jsonStr);
		pw.flush();
	}
	
	/**
	 * 
	 */
	@ResponseBody
	@RequestMapping("/getParameters")
	public ErpResponseJson getParameters(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Map<String, Object> map = new HashMap<String, Object>();
		if(operator.getOperatorHT() != null){
			AdminSysPara adminSysParaInt = adminSysParaMapper.selectByPrimaryKey("INTERVAL_FROMSAMEPH");
			if (adminSysParaInt != null) {
				operator.setAttribute("INTERVAL_FROMSAMEPH", adminSysParaInt.getParamValue());
			}
			AdminSysPara adminSysParaCan = adminSysParaMapper.selectByPrimaryKey("CANSEND_FROMSAMEIP");
			if (adminSysParaCan != null) {
				operator.setAttribute("CANSEND_FROMSAMEIP", adminSysParaCan.getParamValue());
			}
			AdminSysPara adminSysParaCans = adminSysParaMapper.selectByPrimaryKey("CANSEND_FROMSAMEPH");
			if (adminSysParaCans != null) {
				operator.setAttribute("CANSEND_FROMSAMEPH", adminSysParaCans.getParamValue());
			}
			AdminSysPara adminSysParaVip = adminSysParaMapper.selectByPrimaryKey("VIP_INFO_SEECOUNT");
			if (adminSysParaVip != null) {
				operator.setAttribute("VIP_INFO_SEECOUNT", adminSysParaVip.getParamValue());
			}
			map.putAll(operator.getOperatorHT());
		}
		return ErpResponseJson.ok(map);
	}
	
	/**
	 * 获取帖子列表
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param param
	 * @return
	 */
	@ResponseBody
	@NotBlank("bound")// 必传参数
	@RequestMapping("/getBulletinList")
	public ErpResponseJson getBulletinList(@Valid @RequestBody BulletinListParam param) {
		Operator operator = getOperator();
		param.setYouCompFlag(getOperator().getYouCompFlag());
		param.setCompAttr(getOperator().getCompAttr());
		param.setTopJoinComp(getOperator().getTopJoinCircleCompId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getAdminCompId());
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		PageInfo<AdminBulletDto> resList = new PageInfo<AdminBulletDto>(adminBulletMapper.getBulletList(param));
		return ErpResponseJson.ok(resList);
	}
	
	/**
	 * 获取帖子详情
	 * @author 张宏利
	 * @since 2016年10月13日
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/bulletinInfo")
	public String bulletinInfo(HttpServletRequest request, Map<String, Object> paramMap, Integer bulletId, String bulletBound) throws Exception {
		Operator operator = getOperator();
		paramMap.put("operator", operator);
		// 获取回复信息
		Condition condition = new Condition();
		condition.add(new ConditionItem("bulletId", "=", bulletId));
		// 更新点击量
		adminBulletService.addClick(bulletId);
		AdminBulletDto bulletPO = adminBulletMapper.getBulletByBulletId(bulletId);
		// 组装数据
		AdminFunArchive archivePO = adminFunArchiveMapper.selectByPrimaryKey(bulletPO.getArchiveId());
		AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByPrimaryKey(bulletPO.getDeptId());
		if(adminFunDeptsPO == null){
			bulletPO.setDeptName("网络经纪人");
		}else {
			bulletPO.setDeptName(adminFunDeptsPO.getDeptName());
		}
		if(archivePO != null){
			bulletPO.setUserMobile(archivePO.getUserMobile());
			bulletPO.setUserName(archivePO.getUserName());
			bulletPO.setUserPhotoMin(CommonUtil.getBbsPhoto(archivePO.getBbsPhoto()));
			bulletPO.setBbsName(archivePO.getNickName());
			bulletPO.setRealPhoto(archivePO.getUserPhotoMin());
		}
		if("8".equals(bulletBound)){
			String bulletContent = null;
			// 兼容老版
			if("images/goodNews/01.png".equals(bulletPO.getNewsBackUrl())){
				bulletContent = new StringBuilder().append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-position:center center;height:860px;' >")
						.append("<div style='padding:200px 50px 0px;'>")
						.append(bulletPO.getNewsBackUrl())
						.append("</div></div>").toString()
						.replaceAll("#NEWS_BACK_URL#",bulletPO.getNewsBackUrl());
			} else {
				bulletContent = new StringBuilder().append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-position:center center;height:500px;' >")
						.append("<div style='padding:170px 80px 0px;'>")
						.append(bulletPO.getBulletContent())
						.append("</div></div>").toString()
						.replaceAll("#NEWS_BACK_URL#",bulletPO.getNewsBackUrl());
			}
			bulletPO.setBulletContent(bulletContent);
		}
		// 获取投票内容
		if ("1".equals(bulletPO.getIsvote())) {
			AdminVote vote = new AdminVote();
			vote.setBulletId(Integer.valueOf(bulletId));
			List<AdminVoteDto> voteList = adminVoteMapper.getvoteByCondition(vote);
			// 判断当前用户是否投个票
			List<AdminVoteLog> adminVoteLogList = adminVoteLogMapper.selectVoteList(bulletId, operator.getArchiveId());
			boolean isVoted = (adminVoteLogList == null || adminVoteLogList.isEmpty() ? false : true);
			// 如果当前用户已经投票 返回投票描述
			paramMap.put("isVoted", isVoted ? "1" : "0");
			if (isVoted) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < adminVoteLogList.size(); i++) {
					sb.append("," + adminVoteLogList.get(i).getVoteId());
				}
				sb.append(",");
				StringBuilder sb1 = new StringBuilder("");
				for (int i = 0; i < voteList.size(); i++) {
					if (sb.toString().indexOf("," + voteList.get(i).getVoteId() + ",") != -1) {
						sb1.append("、" + (i + 1));
					}
				}
				if (sb1.toString().equals("")) {
					paramMap.put("voteDesc", "您已投过票");
				} else {
					sb1.replace(0, 1, "");
					paramMap.put("voteDesc", "您已投票给第" + sb1 + "项");
				}
			}
			paramMap.put("voteList", voteList);
		}
		// 获取回复
		try{
			PageParam pageParam = new PageParam(1, 50);
			PageInfo<AdminBulletReplyDto> replayBulletinVOs = getBulletinReplyList(bulletId, pageParam);
			paramMap.put("replayList", replayBulletinVOs.getList());
			paramMap.put("pageOffset", replayBulletinVOs.getPageNum());
			paramMap.put("pageRowSize", replayBulletinVOs.getPageSize());
			paramMap.put("pageRows", replayBulletinVOs.getPageSize());
		}catch(Exception e){
			e.printStackTrace();
		}
		// 获取用户认证情况
		AdminFunArchive funArchivePO = adminFunArchiveMapper.queryAdminFunArchiveId(bulletPO.getArchiveId());
		// 是否是付费用户
		if(funArchivePO != null){
			Integer isSuperUser = OperatorSessionUtil.isSuperUser(funArchivePO.getSuperUser(), funArchivePO.getSuperEnd());
			bulletPO.setSuperUser(String.valueOf(isSuperUser));
		}
		if(operator.isPersonalVersion()){
			paramMap.put("ADD_COMMUNIC_INFO", true);
		}else{
			boolean addCommunicInfo = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "ADD_COMMUNIC_INFO") != null;
			paramMap.put("ADD_COMMUNIC_INFO", addCommunicInfo);
		}
		
		// 当前帖子是否可编辑
		boolean canEditBulletin = canEditBulletin(operator, bulletPO);
//		bulletPO.setCanEdit(canEditBulletin);
		
		// 当前帖子是否可以置顶
		boolean canAddStick = ("GENERAL_MANAGER".equals(operator.getUserPosition()) 
				|| "DEPUTY_MANAGER".equals(operator.getUserPosition()))
				&& ("0".equals(bulletBound) || "1".equals(bulletBound) || "7".equals(bulletBound));
		if("8".equals(bulletBound)){
			canAddStick = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "GOODNEWS_MANAGE") != null;
		}
//		bulletPO.setCanAddStick(canAddStick);
		// 用户积分
		if(funArchivePO != null){
			List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(new Integer[]{funArchivePO.getArchiveId()});
			if(list != null && list.size() > 0) {
				AdminFunUsersCountDto userScorByArchiveId = list.get(0);
				if(userScorByArchiveId != null) {
					bulletPO.setUserScore(userScorByArchiveId.getTotalScore());
				}
			}
			bulletPO.setUserRight(funArchivePO.getUserRight());
		}
//		bulletPO.setCanDelete(this.canDeleteBulletin(operator, bulletPO));
		if(StringUtil.isBlank(bulletPO.getBulletSubject()) || bulletPO.getBulletSubject().length() < 5){
			throw new Exception("帖子标题不能少于5个文字");
		}
		paramMap.put("bulletinInfo", bulletPO);
		// 是否开启同城交流平台 ALLOW_CITY_BBS
//		ErpSysParaKey paraKey = new ErpSysParaKey();
//		paraKey.setCompId(operator.getCompId());
//		paraKey.setParamId("ALLOW_CITY_BBS");
//		paraKey.setShardCityId(operator.getCityId());
//		ErpSysPara sysParaPO = erpSysParaMapper.selectByPrimaryKey(paraKey);
		ErpSysPara sysParaPO = erpSysParaMapper.getValueById(operator.getCityId(), operator.getCompId(), "ALLOW_CITY_BBS");

		if(sysParaPO!=null){
			String allowCityBbs = sysParaPO.getParamValue();
			paramMap.put("ALLOW_CITY_BBS", allowCityBbs);
		}else{
			paramMap.put("ALLOW_CITY_BBS", "1");
		}
		// 查询出当前用的状态 是否被禁言
		if(funArchivePO != null){
			String nowDate = DateTimeHelper.formatDatetoString(new Date());
			Integer bulletinStatus = adminBanMapper.getIsBanIng(nowDate, 1, funArchivePO.getArchiveId());
			paramMap.put("bulletinStatus", bulletinStatus);
		}
		//判断帖子是否被删除 如果被删除则返回错误
		if("1".equals(bulletPO.getIsDelete())){
			throw new Exception("该帖子已经被删除,请刷新列表");
		}
		//获取公告附件
		if(bulletBound.equals("0") || bulletBound.equals("1") || bulletBound.equals("7")||bulletBound.equals("8")){
			List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
			paramMap.put("bulletinPsPOs", bulletinPsPOs);
		}
		return "bulletin/bulletinInfo";
	}

	/**
	 *
	 * @param bound 范围id 1-本公司  2-全系统  3-经纪天地  4-商家信息 5-业务知识
	 * @param replayId 回复id
	 * @return
	 * @throws Exception
	 */
	public AdminBulletReplyDto getBulletinReplay(Integer replayId) {
		AdminBulletReplyDto bulletReply = adminBulletReplyMapper.getReplyByReplyId(replayId);
		if(bulletReply != null){
			// 组装数据
			AdminFunArchive funArchivePO = adminFunArchiveMapper.selectByPrimaryKey(bulletReply.getArchiveId());
			// 纯精英版经纪人被删除，这里有可能查不出，这里就是用默认用户名：好房达人
			if(funArchivePO == null) {
				bulletReply.setNickName(Constants_DIC.DIC_SYSTEM_USERNAME);
			} else {
				bulletReply.setNickName(funArchivePO.getNickName());
			}
		}
		return bulletReply;
	}

	// service 去除事务调用
	public PageInfo<AdminBulletReplyDto> getBulletinReplyList(Integer bulletId, PageParam pageParam) {

		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		List<AdminBulletReplyDto> bulletPOs = adminBulletReplyMapper.getBulletReplyList(bulletId);
		PageInfo<AdminBulletReplyDto> pageInfo = new PageInfo<AdminBulletReplyDto>(bulletPOs);
		if (bulletPOs.isEmpty()) {
			return pageInfo;
		}

		Set<Integer> archiveIds = new HashSet<>();
		for (AdminBulletReply bulletPO : bulletPOs) {
			archiveIds.add(bulletPO.getArchiveId());
		}
		Map<Integer, AdminFunArchive> funUsersPOs = new HashMap<>();
		Map<Integer, AdminFunUsersCountDto> userScores = new HashMap<>();
		if(archiveIds.size() > 0) {
			funUsersPOs = adminFunArchiveMapper.getModelDataMap(archiveIds);
			userScores = adminFunUsersCountMapper.getUserScorCountMapKey(archiveIds);
		}
		// 获取用户积分
		for (AdminBulletReplyDto bulletReplyPO : bulletPOs) {
			Integer archiveId = bulletReplyPO.getArchiveId();
			// 组装用户信息
			if(!funUsersPOs.containsKey(archiveId)){
				continue;
			}
			bulletReplyPO.setBbsName(funUsersPOs.get(archiveId).getNickName());
			bulletReplyPO.setRealPhoto(funUsersPOs.get(archiveId).getUserPhotoMin());
			bulletReplyPO.setUserPhoto(CommonUtil.getBbsPhoto(funUsersPOs.get(archiveId).getUserPhoto()));
			// 用户认证情况
			bulletReplyPO.setUserRight(funUsersPOs.get(archiveId).getUserRight());
			// 付费情况
			Integer superUser = funUsersPOs.get(archiveId).getSuperUser();
			Date superEnd = funUsersPOs.get(archiveId).getSuperEnd();
			bulletReplyPO.setSuperUser(OperatorSessionUtil.isSuperUser(superUser, superEnd));
			// 获取积分
			AdminFunUsersCountDto userScoreDo = userScores.get(archiveId);
			if(userScoreDo != null){
				bulletReplyPO.setUserScore(userScoreDo.getTotalScore()==null ? 0 : userScoreDo.getTotalScore());
			}else{
				bulletReplyPO.setUserScore(0);
			}
//			// 如果当前回复属于引用引用类型则查处引用
//			if (bulletReplyPO.getUseReplyId() != null
//					&& !"1".equals(bulletReplyPO.getIsdelete())
//					&& !"1".equals(bulletReplyPO.getIsshield())) {
//				AdminBulletReplyDto relateReplay = getBulletinReplay(bulletReplyPO.getUseReplyId());
//				bulletReplyPO.setUseReplay(relateReplay);
//			}
//			// 如果当前回复属于回复回复类型 则查询出被回复的内容
//			if (bulletReplyPO.getRelateId() != null
//					&& !"1".equals(bulletReplyPO.getIsdelete())
//					&& !"1".equals(bulletReplyPO.getIsshield())) {
//				AdminBulletReplyDto relateReplay = getBulletinReplay(bulletReplyPO.getRelateId());
//				bulletReplyPO.setRelateReplay(relateReplay);
//			}
		}
		return pageInfo;
	}

/**
	 * 1 删除公司公告 有删除权限并且 有公司其他业务查看权
	 * 2删除门店公告   又删除权限即可
	 * @param operator
	 * @param bulletPO
	 * @return
	 * @throws Exception
	 */
	private boolean canDeleteBulletin(Operator operator, AdminBulletDto bulletPO) {
		boolean canDelete = false;
		boolean deleteRight = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "DEL_COMMUNIC_INFO") != null;
		boolean viewInfoComp = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MGR_OTHER_BIZ_DATA_COMP") != null;
		boolean GOODNEWS_MANAGE = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "GOODNEWS_MANAGE") != null;
		String bulletBound = bulletPO.getBulletBound().toString();
		if("8".equals(bulletBound)){
			return GOODNEWS_MANAGE;
		}
		if ("4".equals(bulletBound)
				|| "5".equals(bulletBound)) {
			canDelete = false;
		// 本店信息、公司信息、同城交流，本人的可以删
		} else if (("0".equals(bulletBound)
				|| "1".equals(bulletBound)
				|| "2".equals(bulletBound)
				|| "7".equals(bulletBound)
				|| "3".equals(bulletBound))
				&& bulletPO.getArchiveId() == operator.getArchiveId()) {
			canDelete = true;
		}
		if (bulletPO.getCompId().equals(operator.getAdminCompId())
				&& ("0".equals(bulletBound) || "1".equals(bulletBound))) {
			// 其他权限是公司范围直接可以删除
			if(viewInfoComp && deleteRight){
				canDelete = true;
				// 本店0，如果其他权限是大区、片区、门店则需要帖子所在区域和当前用户权限区域一致则可以删除
			} else if("0".equals(bulletBound) && deleteRight){
				canDelete = true;
			}
		}
		return canDelete;
	}
	
	private boolean canEditBulletin(Operator operator, AdminBulletDto bulletPO) throws Exception {
		boolean canEdit = false;
		boolean viewInfoComp = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MGR_OTHER_BIZ_DATA_COMP") != null;
		boolean pubBulletinInfoOper = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "PUB_BULLETIN_INFO_OPER") != null;
		Byte bulletBound = bulletPO.getBulletBound();
		if(bulletBound == 7){
			return pubBulletinInfoOper;
		}
		if(bulletBound == 8){
			return false;
		}
		if (4 == bulletBound || 5 == bulletBound) {
			canEdit = false;
		// 本店信息、公司信息、同城交流，本人的可以删
		} else if ((0 == bulletBound
				|| 1 == bulletBound
				|| 2 == bulletBound
				|| 7 == bulletBound
				&& bulletPO.getUserId() == operator.getUserId())) {
			canEdit = true;
		} else if (3 == bulletBound && bulletPO.getArchiveId() == operator.getArchiveId()) {
			canEdit = true;
		// 信息属于本公司，而且帖子是本公司或本门店的数据
		} else if (bulletPO.getCompId().equals(operator.getAdminCompId())
				&& (0 == bulletBound || 1 == bulletBound)) {
			// 其他权限是公司范围直接可以删除
			if(viewInfoComp){
				canEdit = true;
			// 本店0，如果其他权限是大区、片区、门店则需要帖子所在区域和当前用户权限区域一致则可以删除
			} else if(0 == bulletBound){
				/*if(viewInfoArea && bulletPO.get("AREA_ID").equals(operator.getAreaId())){
					canEdit = true;
				} else if(viewInfoReg && bulletPO.get("REG_ID").equals(operator.getRegId())){
					canEdit = true;
				} else if(viewInfoDept && bulletPO.get("DEPT_ID").equals(operator.getAdminDeptId())){
					canEdit = true;
				}
				有趣，没看到有那个地方设置了 AREA_ID REG_ID DEPT_ID 这些ID
				*/
			}
		}
		return canEdit;
	}

	/**
	 * 插入房源信息
	 * @author 何传强
	 * @since 2017年9月1日
	 * @param request
	 * @param param
	 * @param map
	 * @return
	 */
	@RequestMapping("/insertHouseInfo")
	public String getBulletinHouseList(HttpServletRequest request, ReqBulletinHouseListParam param, ModelMap map) {
		Operator operator = getOperator();
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setUserId(operator.getUserId());
		param.setCityId(operator.getCityId());
		param.setShardCityId(operator.getCityId());
		param.setPageOffset(1);
		param.setPageRows(10);
		if (StringUtils.isEmpty(param.getCaseType())) {
			param.setCaseType("SALE_FUN");
		}
		map.put("param", param);
		map.put("cityId", operator.getCityId());
		try {
			//获取房源信息
			if("SALE_FUN".equals(param.getCaseType())) {
				if (StringUtils.isNotEmpty(param.getAreaText()) && !"-全部".equals(param.getAreaText())) {
					String areas[] = param.getAreaText().split("-");
					if (areas.length > 1) {
						param.setCaseAreas1(areas[0]);
						param.setCaseAreas2(areas[1]);
					}
				}
				if (StringUtils.isNotEmpty(param.getRoomText()) && !"-全部".equals(param.getRoomText())) {
					String rooms[] = param.getRoomText().split("-");
					if (rooms.length > 1) {
						param.setCaseRooms1(rooms[0]);
						param.setCaseRooms2(rooms[1]);
					}
				}
				if (StringUtils.isNotEmpty(param.getRegionText())) {
					param.setRegionNames(param.getRegionText().split(" "));
				}
				if (StringUtils.isNotEmpty(param.getBuildIdText())) {
					param.setBuildNames(param.getBuildIdText().split(" "));
				}
				// 查询数据
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
				List<ErpFunSale> resultList = erpFunSaleMapper.getBulletinHouseList(param);
				Set<Integer> houseIds = new HashSet<Integer>();
				for(int i=0; i< resultList.size(); i++){
					houseIds.add(resultList.get(i).getSaleId());
				}
				Map<Integer, String> housePicMap = getHousePicMap(param.getCompId(), param.getCityId(), Const.DIC_CASE_TYPE_SALE_FUN, houseIds);
				for(int i=0; i< resultList.size(); i++){
					ErpFunSale dataObject = resultList.get(i);
					dataObject.setThumbUrl(housePicMap.get(dataObject.getSaleId()));//PHOTO_ADDRESS
				}
				PageInfo<ErpFunSale> funSaleByBulletin = new PageInfo<ErpFunSale>(resultList);
				map.put("houseList", funSaleByBulletin.getList());
				map.put("totalRows", funSaleByBulletin.getTotal());
			} else {
				Condition condition = new Condition();
				if (StringUtils.isNotEmpty(param.getAreaText()) && !"-全部".equals(param.getAreaText())) {
					String areas[] = param.getAreaText().split("-");
					if (areas.length > 1) {
						param.setCaseAreas1(areas[0]);
						param.setCaseAreas2(areas[1]);
					}
				}
				if (StringUtils.isNotEmpty(param.getRoomText()) && !"-全部".equals(param.getRoomText())) {
					String rooms[] = param.getRoomText().split("-");
					if (rooms.length > 1) {
						param.setCaseRooms1(rooms[0]);
						param.setCaseRooms2(rooms[1]);
					}
				}
				condition.add(new ConditionItem("USER_ID", "=", param.getUserId()));
				condition.add(new ConditionItem("LEASE_STATUS", "<=", Constants_DIC.DIC_HOUSE_STATUS_SCHEDULE));
				if (StringUtils.isNotEmpty(param.getRegionText())) {
					param.setRegionNames(param.getRegionText().split(" "));
				}
				if (StringUtils.isNotEmpty(param.getBuildIdText())) {
					param.setBuildNames(param.getBuildIdText().split(" "));
				}
				// 查询数据
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
				List<ErpFunLease> resultList = erpFunLeaseMapper.getBulletinHouseList(param);
				Set<Integer> houseIds = new HashSet<Integer>();
				for(int i=0; i< resultList.size(); i++){
					houseIds.add(resultList.get(i).getLeaseId());
				}
				Map<Integer, String> housePicMap = getHousePicMap(param.getCompId(), param.getCityId(), Const.DIC_CASE_TYPE_LEASE_FUN, houseIds);
				for(int i=0; i< resultList.size(); i++){
					ErpFunLease dataObject = resultList.get(i);
					dataObject.setThumbUrl(housePicMap.get(dataObject.getLeaseId()));//PHOTO_ADDRESS
				}
				PageInfo<ErpFunLease> funLeaseByBulletin = new PageInfo<ErpFunLease>(resultList);
				map.put("houseList", funLeaseByBulletin.getList());
				map.put("totalRows", funLeaseByBulletin.getTotal());
			}
			//获取行政区域信息
			List<ErpFunReg> funRegPOs = erpFunRegMapper.getRegListByCityId(getOperator().getCityId());
			map.put("regList", funRegPOs);
			map.put("pageOffset", param.getPageOffset());
			map.put("pageRowSize", param.getPageRows());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "bulletin/insertHouseInfo";
	}
	
	/**
	 * 预览
	 * @author 张宏利
	 * @since 2016年10月13日
	 * @param param
	 * @return
	 */
	@RequestMapping("/preview")
	public String preview(HttpServletRequest request, Map<String, Object> paramMap) {
		Operator operator = getOperator();
		List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(new Integer[]{operator.getArchiveId()});
		if(list != null && list.size() > 0) {
			AdminFunUsersCountDto userScorByArchiveId = list.get(0);
			// 获取用户信息 积分
			paramMap.put("operator", operator);
			paramMap.put("nowTime", new Date());
			paramMap.put("userScore", userScorByArchiveId.getTotalScore());
			return "bulletin/preview";
		}
		return null;
	}
	private Map<Integer, String> getHousePicMap(Integer compId, Integer cityId, Integer caseType, Set<Integer> houseIds) {
		Map<Integer, String> housePicMap = new HashMap<Integer, String>();
		List<ErpFunPhotoDto> photoPOs = erpFunPhotoMapper.getPhotoList(compId, cityId, caseType,  houseIds.toArray(new Integer[houseIds.size()]));
		//组装房源图片
		if(photoPOs != null && !photoPOs.isEmpty()){
			for(int i=0; i<photoPOs.size(); i++){
				ErpFunPhoto funPhotoPO = photoPOs.get(i);
				String pics = housePicMap.get(funPhotoPO.getCaseId());
				if(StringUtils.isEmpty(pics)){
					pics=funPhotoPO.getPhotoAddr().replaceAll("\\\\", "/") + ";";
				}else{
					pics += funPhotoPO.getPhotoAddr().replaceAll("\\\\", "/") + ";";
				}
				housePicMap.put(funPhotoPO.getCaseId(), pics);
			}
		}
		return housePicMap;
	}
	
	/**
	 * 
	 */
	@ResponseBody
	@RequestMapping("/updateReleaseStatus")
	public ErpResponseJson updateReleaseStatus(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Map<String, Object> map = new HashMap<String, Object>();
		//updateReleaseStatus(param)
		return ErpResponseJson.ok(map);
	}

	@ResponseBody
	@RequestMapping("/getBulletinWarmTask")
	public ErpResponseJson getBulletinWarmTask(@RequestBody BaseMapParam param) {
		Operator operator=getOperator();
		String[] conditionDate = DateUtil.getConditionDate(Constants_DIC.DIC_DATE_SEARCH_TYPE_WEEK);
		if (operator.isSwitchCompLogin()) {
			return ErpResponseJson.ok(new ArrayList<>());
		}
		List<ErpFunTask> bulletinWarmTask = erpFunTaskMapper.getBulletinWarmTask(operator.getCityId(), operator.getUserId(), operator.getCompId(), conditionDate[0], conditionDate[1]);
		return  ErpResponseJson.ok(bulletinWarmTask);
	}

}

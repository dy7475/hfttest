package com.myfun.erpWeb.openApi.inviteRegist;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.managecenter.sysmanager.param.CreateUserParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.UserPhoneValidParam;
import com.myfun.erpWeb.openApi.inviteRegist.param.BrokerShareRegisterParam;
import com.myfun.erpWeb.openApi.inviteRegist.param.EditEmployeeDocParam;
import com.myfun.erpWeb.openApi.inviteRegist.param.FjdArchivalParam;
import com.myfun.erpWeb.usercenter.UserCenterController;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.MlHrsSyncAddUserParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.utils.*;
import com.myfun.utils.bean.FileUploadResult;
import com.myfun.utils.rijindael.AESHelper;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 邀请注册相关页面
 * @author 张宏利
 * @since 2017年5月9日
 */
@Controller
@RequestMapping(value = "/openApi/inviteRegist")
public class InviteRegistController extends BaseController{
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	AdminInviteRegistErpMapper adminInviteRegistErpMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	AdminMobileKeyService adminMobileKeyService;
	@Autowired
	ErpFunRegMapper erpFunRegMapper;
	@Autowired
	ErpFunSectionService erpFunSectionService;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	UserCenterController userCenterController;
	@Autowired
	AdminSysParaService adminSysParaService;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	ErpFunUsersInvitedMapper erpFunUsersInvitedMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	AdminFunRegMapper adminFunRegMapper;
	@Autowired
	AdminFunSectionMapper adminFunSectionMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	AdminCrmUserMapper adminCrmUserMapper;
	@Autowired
	ErpFunAreaMapper erpFunAreaMapper;
	@Autowired
	ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	HttpRequestTask httpRequestTask;
	@Autowired
	AdminCustomLeaguesSkinModelMapper adminCustomLeaguesSkinModelMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunEmployeeDocService erpFunEmployeeDocService;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	AdminAppUpgradeMapper adminAppUpgradeMapper;
	@Autowired
	ErpAliyunPhoneService erpAliyunPhoneService;
	@Autowired
	private ErpSysParaService erpSysParaService;


	/**
	 * @title ：房基地四期：因为之前是两个页面两个方法保存，现在换成在最后员工档案的时候再保存，新增一个方法调用之前两个保存方法
	 */
	@RequestMapping("/finalSaveFjdUser")
	@ResponseBody
	public ResponseJson finalSaveFjdUser(EditEmployeeDocParam param) throws Exception{
		BrokerShareRegisterParam brokerShareRegisterParam = new BrokerShareRegisterParam();
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		BeanUtils.copyProperties(param, brokerShareRegisterParam);
		//首先调用接口创建员工账号
		Map<String,Object> map = this.brokerShareRegister(brokerShareRegisterParam);
		//再调用接口添加员工档案信息
		if(null != map){
			Integer archiveId = null != map.get("archiveId") ? StringUtil.paseInteger(map.get("archiveId").toString()) : 0;
			Integer compType = null != map.get("compType") ? StringUtil.paseInteger(map.get("compType").toString()) : 0;
			Integer userId = null != map.get("userId") ? StringUtil.paseInteger(map.get("userId").toString()) : 0;
			param.setArchiveId(archiveId);
			param.setCompType(compType);
			param.setUserId(userId);
		}
		this.editEmployeeDoc(param);
		return ErpResponseJson.ok();
	}


	/**
	 * @title ：编辑员工档案信息
	 * @athor：lcb
	 * @date  : 2017/11/7
	 */
	@RequestMapping("/editEmployeeDoc")
	@ResponseBody
	public ResponseJson editEmployeeDoc(EditEmployeeDocParam param) throws Exception{

	AdminFunArchive adminFunArchive = new AdminFunArchive();
	ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	BeanUtils.copyProperties(param, adminFunArchive);
	adminFunArchive.setUserBirthday(DateUtil.StringToDate(param.getUserBirthday()));

	ErpFunUsers erpFunUsers = new ErpFunUsers();
	ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	BeanUtils.copyProperties(param, erpFunUsers);

	ErpFunEmployeeDoc erpFunEmployeeDoc = new ErpFunEmployeeDoc();
	ConvertUtils.register(new DateConverter(null), java.util.Date.class);
	BeanUtils.copyProperties(param, erpFunEmployeeDoc);

	Map<String, Object> paramJsonMap = new HashMap<>();
	paramJsonMap.put("fjdShareRegister",1);
	paramJsonMap.put("inviteId",param.getInviteId());
	if(StringUtil.isNotEmpty(param.getUserIccodeUrl())){
		paramJsonMap.put("userIccodeUrl",param.getUserIccodeUrl());
	}
	if(StringUtil.isNotEmpty(param.getEducationUrl())){
		paramJsonMap.put("educationUrl",param.getEducationUrl());
	}
	
	String createUserName = "";
	//线上bug 取不到会话
/*	if (getOperator().isSwitchCompLogin()){//后续改为isSwitchCompLogin
		createUserName = getOperator().getUserName()+"("+getOperator().getCompName()+")";
	}*/

	Integer docId = erpFunEmployeeDocService.editEmployeeDoc(param.getCityId(),param.getCompId(),param.getDeptId(),
				null, erpFunEmployeeDoc, adminFunArchive, erpFunUsers, paramJsonMap, param.getCompType(),createUserName);
		return ErpResponseJson.ok();
	}

    /**
     * 文件上传新接口
     *@author 朱科
     *@param
     *@return ResponseJson
     *@since 2018年3月6日
     */
    @RequestMapping("/fileUpload")
	@ResponseBody
    public ResponseJson fileUpload(@RequestParam("files") MultipartFile[] files, @RequestParam(name = "watermarkFlag",required = false) String watermarkFlag) throws Exception{
		if (!"1".equals(watermarkFlag)) {
			watermarkFlag = "0";
		}
		FileUploadResult fileUploadResult = FileUtil.fileUpload(AppConfig.getFileWebUrl(), files, watermarkFlag);
//        FileUploadResult fileUploadResult = FileUtil.fileUpload("http://devcommon.51vfang.cn/fileWeb/", files);
        return ErpResponseJson.ok(fileUploadResult);
    }

	/**
	 * 房基地二期，跳转填写档案页面
	 * @return
	 */
	@RequestMapping(value="/fjdArchival", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView fjdArchival(FjdArchivalParam param, ModelAndView view) throws Exception {
		view.addObject("cityId", param.getCityId());
		view.addObject("compId", param.getCompId());
		view.addObject("deptId", param.getDeptId());
		view.addObject("inviteId", param.getInviteId());
		JSONObject jsonObj= new JSONObject(BeanUtil.objectToMap(param));
		view.addObject("paramData", jsonObj);
		view.setViewName("fjdInvitation/fjdOrganization");
		return view;
	}

	/**
	 * 分享注册
	 * @param cityId
	 * @param userMobile
	 * @param inviteUserId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/brokerShareRegister", method={RequestMethod.POST})
	public Map<String,Object> brokerShareRegister(BrokerShareRegisterParam param) throws Exception{
		Map<String,Object> map = erpFunUsersService.createInvitedUser(param);
		return map;
	}

	
	/**
	 * 跳转邀请注册页面
	 * @author LI XIAO TONG
	 * @since 2019年8月30日 下午9:12:31
	 * @param cityId
	 * @param invitedId
	 * @return
	 * Modified XXX Li Xiao Tong 2019年8月30日
	 * @throws Exception 
	 */
	@RequestMapping(value="/fjdShareLogin", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView fjdShareLogin(Integer cityId,Integer userId,Long time,ModelAndView view) throws Exception{
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		ErpFunDepts funDepts = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsers.getDeptId());
		if(null == erpFunUsers){
			throw new Exception("数据错误,请联系在线客服");
		}
		view.addObject("funDepts", funDepts);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String laterDate = DateUtil.addMinute(simpleDateFormat.format(time),10);
		Integer dateCompare = DateUtil.dateCompare(new Date(), DateUtil.StringToDate(laterDate));
		if(dateCompare > 0){
			view.addObject("pastFlag", 1);
			view.setViewName("fjdInvitation/fjdIndex");
			return view;
		}
		ErpFunComp erpFunComp = erpFunCompMapper.getCompByCompNo(funDepts.getCompNo());
		Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("cityId", cityId);
        paramMap.put("compId", erpFunComp.getCompId());
        paramMap.put("compNo", erpFunComp.getCompNo());
        String encode = AESHelper.encode(JSON.toJSONString(paramMap));
        view.addObject("paramData", encode);
        view.addObject("invitedMobile", erpFunUsers.getUserMobile());
		view.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		view.addObject("adminWebUrl", AppConfig.getAdminWebUrl());
		view.addObject("crmWebUrl", AppConfig.getCrmWebUrl());
		view.addObject("cityId", cityId);
		view.addObject("invitedId", userId);
		view.addObject("invitedName", erpFunUsers.getUserName());
		view.setViewName("fjdInvitation/fjdIndex");
        return view;
    }

    /**
     * 邀请注册成功页
     * @param cityId
     * @param userId
     * @param time
     * @param view
     * @return
     * @throws Exception
     */
	@RequestMapping(value="/fjdSucc", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView fjdSucc(String deptName,ModelAndView view) throws Exception{
		String androidDownloadUrl =  adminAppUpgradeMapper.selectAndroidDownloadUrl(1);
        view.addObject("deptName", deptName);
        view.addObject("androidDownloadUrl", androidDownloadUrl);
		view.setViewName("fjdInvitation/fjdSucc");
		return view;
	}

    /**
     * 添加 组织架构线
     * @param cityId
     * @param userMobile
     * @param inviteUserId
     * @return
     * @throws Exception
     */
	@ResponseBody
	@RequestMapping(value="/setUseArchitecturalHierarchy", method={RequestMethod.POST})
	public ErpResponseJson setUseArchitecturalHierarchy(Integer cityId,String userMobile, Integer inviteUserId) throws Exception{
		if(StringUtil.isEmpty(userMobile)){
			return ErpResponseJson.warn("电话信息错误");
		} 
		if(cityId == null || inviteUserId == null){
			return ErpResponseJson.warn("参数错误");
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUsersByMobile(cityId, userMobile);
		if(erpFunUsers !=null){
			erpFunUsersService.sendRegistrationAuditMsg(erpFunUsers, inviteUserId, cityId);
		}
		return ErpResponseJson.ok();
	}
	

	/**
	 * 获取商圈列表
	 * @author 张宏利
	 * @since 2017年5月11日
	 * @param code
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/getServiceZoneList", method={RequestMethod.POST})
	public ErpResponseJson getServiceZoneList(Integer cityId, Integer regId) throws Exception{
		ErpFunRegExample example = new ErpFunRegExample();
        ErpFunRegExample.Criteria criteria = example.createCriteria().andCityIdEqualTo(cityId.shortValue()).andVertifyFlagEqualTo((byte) 1);
        if(null != regId) {
            criteria.andRegIdEqualTo(regId);
        }
        example.setShardCityId(cityId);
		List<ErpFunReg> sectionList = erpFunRegMapper.selectByExample(example);
		return ErpResponseJson.ok(sectionList);
	}
	
	/**
	 * 测试发送短信
	 */
	@ResponseBody
	@RequestMapping(value="/snRestSmsTetS", method={RequestMethod.GET})
	public ErpResponseJson snRestSmsTetS(String code, HttpServletRequest request) throws Exception{
//		if(true) {
//			return ErpResponseJson.ok();// 要调试的时候再打开，开了记得关
//		}
		// 发送短信给被邀请人
		String url = AppConfig.getErpWebUrl()+"/openApi/inviteRegist/regist?code="+StringUtil.getUUIDBySub();
		String ddzUrl = HttpUtil.createDdz(url);
		String content = String.format("【好房通】%s，我是你的同事%s，邀请你加入%s，本次邀请验证码为：%s，点击填写资料%s，此链接将于24小时后失效。",
				"李峰", "张宏利", "好房通测试A店", "546413", ddzUrl);
		adminMobileKeyService.sendNoticeSms("18583948225", null, content);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 邀请注册获取验证码
	 * @author 张宏利
	 * @since 2017年5月9日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/sendRegistSms", method={RequestMethod.POST})
	public ErpResponseJson sendRegistSms(String code, HttpServletRequest request) throws Exception{
		AdminInviteRegistErp inviteRegistErp = getInviteRegistInfo(code);
		if(inviteRegistErp == null) {
			return ErpResponseJson.warn("该邀请已过期<br/>请联系管理员重新发送邀请！");
		}
		// 发送短信
		this.sendMsgAndValidateCount(getClientIpAddr(request), "registerAcc", inviteRegistErp.getUserMobile(), "");
		return ErpResponseJson.ok();
	}

	public void sendMsgAndValidateCount(String ipAddr, String regFrom, String mobile, String compNo) {
		int sendSamePHCount = userCenterController.getSendNumSamePH(mobile);
		int canSendFromSamePH = Integer.parseInt(adminSysParaService.getSysParamToString("CANSEND_FROMSAMEPH"));
		if (sendSamePHCount >= canSendFromSamePH) {
			int num=(canSendFromSamePH-sendSamePHCount);
			throw new ConfirmException("同一电话最多可以发送"+canSendFromSamePH+"次,还剩 "+(num<=0?0:num)+" 次");
		}else {
			int sendedcount = userCenterController.getSendNumToday(ipAddr);
			int canSendFromSameIP = Integer.parseInt(adminSysParaService.getSysParamToString("CANSEND_FROMSAMEIP"));
			if (sendedcount >= canSendFromSameIP) {
				int num=canSendFromSameIP-sendedcount;
				throw new ConfirmException("同一IP最多可以发送"+canSendFromSameIP+"次,还剩 "+(num<=0?0:num)+" 次");
			} else {
				sendSamePHCount += 1;
				userCenterController.createMobileKeyAndSend(ipAddr, regFrom, mobile, compNo);
			}
		}
	}

	/**
	 * 邀请注册主页面
	 * @author 张宏利
	 * @since 2017年5月9日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/regist", method={RequestMethod.GET})
	public ModelAndView regist(HttpServletRequest request, String code, ModelAndView view) throws Exception{
		request.setAttribute("customErrPage", "openApi/inviteRegist/result");// 默认一个错误页面
		AdminInviteRegistErp inviteRegistErp = getInviteRegistInfo(code);
		if(inviteRegistErp == null) {
			return view;
		}
		AdminFunArchive funArchiveSelect = adminFunArchiveMapper.getArchiveByMobile(inviteRegistErp.getUserMobile());
		if(funArchiveSelect != null) {
			if(funArchiveSelect.getUserEdition() != 2) {
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByArchiveId(funArchiveSelect.getArchiveId());
				ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(funArchiveSelect.getCityId().intValue(), erpFunUsers.getDeptId());
				// 这个链接注册成功了的就返回注册成功页面
				if (inviteRegistErp.getRegistStatus() == 1) {
					view.addObject("deptName", erpFunDepts.getDeptName());
					view.setViewName("openApi/inviteRegist/success");// 注册成功页面
					return view;
				}
				throw new ConfirmException("您已加入" + erpFunDepts.getDeptName() + "门店<br/>请先从此门店注销后再进行此操作！");
			}
			if (!inviteRegistErp.getCityId().equals(funArchiveSelect.getCityId().intValue())) {
				throw new ConfirmException("账号已在其他城市注册！<br/>若需加入此门店，请先联系好房通客服处理！");
			}
			view.addObject("userEdition", funArchiveSelect.getUserEdition());
		}
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptNo(inviteRegistErp.getCompNo(), inviteRegistErp.getDeptNo());
		if(erpFunDepts != null) {
			ErpCompRoles erpCompRoles = erpCompRolesMapper.getCompRoleByUserEdition(inviteRegistErp.getCityId(), inviteRegistErp.getRoleId(), erpFunDepts.getCompId());
			view.addObject("adminFunDepts", erpFunDepts);
			view.addObject("erpCompRoles", erpCompRoles);
			List<ErpFunReg> regListByCityId = erpFunRegMapper.getRegListByCityId(inviteRegistErp.getCityId());
			view.addObject("regList", regListByCityId);
			ErpFunSectionExample example = new ErpFunSectionExample();
			example.createCriteria().andCityIdEqualTo(inviteRegistErp.getCityId().shortValue())
			.andRegIdEqualTo(regListByCityId.get(0).getRegId()).andVertifyFlagEqualTo((byte) 1);
			example.setShardCityId(inviteRegistErp.getCityId());
			List<ErpFunSection> sectionList = erpFunSectionMapper.selectByExample(example);
			view.addObject("sectionList", sectionList);
		}
		view.addObject("inviteInfo", inviteRegistErp);
		view.addObject("code", code);
		view.setViewName("openApi/inviteRegist/regist");
		return view;
	}
	
	/**
	 * 邀请注册提交
	 * @author 张宏利
	 * @since 2017年5月9日
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/regist", method={RequestMethod.POST})
	public ModelAndView registPost(HttpServletRequest request, ModelAndView view, String uuidCode, String serviceReg, String serviceZone, String serviceZoneIds, String pwd, String repwd, String smsCode, String organizationId) throws Exception{
		request.setAttribute("customErrPage", "openApi/inviteRegist/result");// 默认一个错误页面
		AdminInviteRegistErp inviteRegistErp = getInviteRegistInfo(uuidCode);
		if(inviteRegistErp == null) {
			return view;
		}
		view.setViewName("openApi/inviteRegist/result");
		boolean validate = adminMobileKeyService.validateSmsCode(smsCode, inviteRegistErp.getUserMobile());
		String message = null;
		// 参数验证smsCode
		if(!validate) {
			message = "验证码错误<br/>请重新输入！";
		} else {
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptNo(inviteRegistErp.getCompNo(), inviteRegistErp.getDeptNo());
			if(erpFunDepts == null) {
				throw new ConfirmException("门店信息错误<br/>请联系好房通客服处理！");
			}
			boolean status = erpFunUsersService.registByInvite(inviteRegistErp, serviceReg, serviceZone, serviceZoneIds, pwd, erpFunDepts);
			if(status) {
				view.addObject("deptName", erpFunDepts.getDeptName());
				view.setViewName("openApi/inviteRegist/success");// 注册成功页面
			} else {
				message = "注册失败<br/>请联系好房通客服处理！";
			}
		}
		view.addObject("message", message);
		return view;
	}
	
	/**
	 * 获取邀请注册信息
	 * @author 张宏利
	 * @since 2017年5月11日
	 * @param view
	 * @param uuidCode
	 * @return
	 */
	private AdminInviteRegistErp getInviteRegistInfo(String uuidCode){
		List<AdminInviteRegistErp> registList = null;
		if(uuidCode != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, -3);
			AdminInviteRegistErpExample example = new AdminInviteRegistErpExample();
			example.createCriteria().andUuidEqualTo(uuidCode)
			.andCreateTimeGreaterThan(calendar.getTime());
			registList = adminInviteRegistErpMapper.selectByExample(example);
		}
		if(registList == null || registList.size() <= 0) {
			throw new ConfirmException("邀请已过期<br/>请联系管理员发送邀请！");
		}
		AdminInviteRegistErp adminInviteRegistErp = registList.get(0);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -24);
		int compareTwoDate = DateTimeHelper.compareTwoDate(calendar.getTime(), adminInviteRegistErp.getCreateTime());
		if(compareTwoDate < 0) {
			throw new ConfirmException("邀请已过期<br/>请联系管理员发送邀请！");
		}
		return adminInviteRegistErp;
	}

    /**
      * @title  公司邀请注册页面
      * @author lcb  
      * @date   2018/9/7 11:15
      * @desc 
      **/
    @RequestMapping(value="/getCompInvite.htm")
    public ModelAndView getCompInvite(ModelAndView view, String param) throws Exception{
    	if(StringUtils.isBlank(param)) {
			view.setViewName("openApi/inviteRegist/result");
		}
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		String compNo = jsonObject.getString("compNo");
		String leaguesType = jsonObject.getString("leaguesType");
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		view.addObject("compName", adminFunComp.getCompCname());
		view.addObject("cityId", jsonObject.getInteger("cityId"));
		view.addObject("param", param);
		view.addObject("leaguesType", 1);
		// 背景色
		view.addObject("baseColor", "#068EFE");
		view.addObject("getCodeColor", "#068EFE");
		// banner上的文字的颜色
		view.addObject("bannerTt", "#FFFFFF");
		view.addObject("checkBtnTt", "#FFFFFF");

		//根据系统参数判断是不是新组织架构  //zt组织机构
		// param传的参数例子：{"compId":47588,"cityId":1,"compNo":"CEH8"}
		String organizationType = erpSysParaMapper.getParamValue(jsonObject.getInteger("cityId"), jsonObject.getInteger("compId"), "ORGANIZATION_TYPE");
		view.addObject("organizationType", organizationType); // 1是新组织机构
		view.setViewName("openApi/compInviteRegist/index");
        return view;
    }

    public static void main(String[] args) {
        String ste = "{\"compId\":57433,\"cityId\":1,\"compNo\":\"AFH3\",\"leaguesType\":\"4\"}";
        try {

        System.out.println(AESHelper.encode(ste));
        } catch (Exception e) {
            throw new BusinessException("数据异常，请重试或联系在线客服！", e);
        }
    }
	/**
	  * @title  公司邀请注册
	  * @author lcb
	  * @date   2018/9/7 16:32
	  * @desc
	  **/
	@ResponseBody
	@RequestMapping(value="/sendCompInviteRegistSms", method={RequestMethod.POST})
	public ErpResponseJson sendCompInviteRegistSms(String userMobile, String param,Integer isFjd,HttpServletRequest request) throws Exception{
		if(StringUtils.isBlank(param) || StringUtils.isBlank(userMobile)) {
			return ErpResponseJson.ok();
		}
		if(isFjd == null){
			isFjd = 0;
		}
		
		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		String compNo = jsonObject.getString("compNo");
		Integer cityId = jsonObject.getInteger("cityId");
		Integer compId = jsonObject.getInteger("compId");
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserMobileEqualTo(userMobile).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardCityId(cityId);
		Integer countUser = erpFunUsersMapper.countByExample(erpFunUsersExample);
		if(countUser > 0){
			return ErpResponseJson.warn("您已经是该公司的员工，无需再次验证！");
		}
		if("0".equals(isFjd.toString())){
			ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
			example.setShardCityId(cityId);
			example.createCriteria().andUserMobileEqualTo(userMobile).andCompIdEqualTo(compId).
					andCompNoEqualTo(compNo).andInviteStatusEqualTo((byte) 0).andCityIdEqualTo(cityId);
			List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
			if(resList.size() > 0) {
				ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
				// 发送短信
				this.sendMsgAndValidateCount(getClientIpAddr(request), "registerAcc", userMobile,compNo);
				//根据系统参数判断是不是新组织架构
				String organizationType = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");
				if("1".equals(organizationType)){//zt组织机构
					// 检测下组织状态
					ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsersInvited.getOrganizationId());
					if (erpFunOrganization == null) {
						return ErpResponseJson.warn("该组织不存在，请联系管理员！");
					} else {
						// //zt组织机构待定
						// 检查用户注册已经达到许可的最大值(此逻辑暂时没写   等待销售政策？)
					}
				} else {
					// 检测下门店状态
					ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsersInvited.getDeptId());
					if(null != byDeptId && 0 != byDeptId.getDeptFlag()) {
						String s = checkDeptUserNum(cityId, byDeptId);
						if(StringUtils.isNotBlank(s)) {
							return ErpResponseJson.ok(s);
						}
					}else {
						return ErpResponseJson.warn("该门店不存在，请联系管理员！");
					}
				}
				return ErpResponseJson.ok();
			}else {
				return ErpResponseJson.warn("该公司未发出邀请，请联系管理员！");
			}
		}else{
			this.sendMsgAndValidateCount(getClientIpAddr(request), "registerAcc", userMobile,compNo);
		}
		return ErpResponseJson.ok();
	}

	@ResponseBody
	@RequestMapping(value="/validateCompInviteMsg", method={RequestMethod.POST})
	public ErpResponseJson validateCompInviteMsg(String userMobile, String param, String code,Integer isFjd) throws Exception{

		if(StringUtils.isBlank(param) || StringUtils.isBlank(userMobile)) {
			return ErpResponseJson.ok();
		}
		if(null == isFjd){
			isFjd = 0;
		}
		// 校验能不能注册
		AdminFunArchive archiveByMobile = adminFunArchiveMapper.getArchiveByMobile(userMobile);
		if (null != archiveByMobile && !(2 == archiveByMobile.getUserEdition())) {
			return ErpResponseJson.warn("手机号已在其他门店注册！");
		}
		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		String compNo = jsonObject.getString("compNo");
		Integer cityId = jsonObject.getInteger("cityId");
		Integer compId = jsonObject.getInteger("compId");
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserMobileEqualTo(userMobile).andUserWriteoffEqualTo(false);
		erpFunUsersExample.setShardCityId(cityId);
		Integer countUser = erpFunUsersMapper.countByExample(erpFunUsersExample);
		if(countUser > 0){
			return ErpResponseJson.warn("您已经是该公司的员工，无需再次验证！");
		}
		UserPhoneValidParam validParam = new UserPhoneValidParam();
		validParam.setCityId(cityId);
		validParam.setCompId(compId);
		validParam.setMobile(userMobile);
		validParam.setKey(code);
		Boolean validKey = this.isValidKey(validParam);
		if (!validKey) {
			return ErpResponseJson.warn("校验码错误！");
		}
		Map<String, Object> resMap = new HashMap<>();
		if("0".equals(isFjd.toString())){
			ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
			example.setShardCityId(cityId);
			example.createCriteria().andUserMobileEqualTo(userMobile).andCompIdEqualTo(compId).
			andCompNoEqualTo(compNo).andInviteStatusEqualTo((byte) 0).andCityIdEqualTo(cityId);
			List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
			if(resList.size() == 0) {
				return ErpResponseJson.warn("该公司未发出邀请，请联系管理员！");
			}
			ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
			ErpCompRoles byRoleId = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsersInvited.getUserPosition());
			if(null != byRoleId && 0 == byRoleId.getIsDel()) {
				resMap.put("roleId", byRoleId.getRoleId());
				resMap.put("roleName", byRoleId.getRoleName());
			}else {
				resMap.put("roleId", "PRACTY_BIZ");
				resMap.put("roleName", "见习经纪人");
			}
		
			//获取上级
			
			// 处理服务区域
			String serviceReg = erpFunUsersInvited.getServiceReg();
			String serviceZoneId = erpFunUsersInvited.getServiceZoneIds();
	
			resMap.put("serviceReg", serviceReg);
			resMap.put("serviceZoneId", serviceZoneId);
			if(StringUtils.isNotBlank(serviceReg)) {
				// 查询区域
				String[] serviceRegs = serviceReg.split(" ");
				String[] serviceZoneIds = serviceZoneId.split(" ");
				List<String> strings = Arrays.asList(serviceRegs);
				List<String> zoneIds = Arrays.asList(serviceZoneIds);
				List<Integer> regIds = strings.stream().map(Integer::valueOf).collect(Collectors.toList());
				List<Integer> sectionIds = zoneIds.stream().map(Integer::valueOf).collect(Collectors.toList());
	
				List<AdminFunReg> funRegList = adminFunRegMapper.getFunRegList(regIds);
				Map<Integer, AdminFunReg> regMap = funRegList.stream().collect(Collectors.toMap(val->val.getRegId(), val->val));
	
				List<AdminFunSection> sectionList = adminFunSectionMapper.selectListBySectionIds(cityId, sectionIds);
	
				List<Map<String, Object>> regSectionMap = new ArrayList<>();
				for (AdminFunSection adminFunSection : sectionList) {
					Map<String, Object> itemMap = new HashMap<>();
					itemMap.put("regId", adminFunSection.getRegId());
					AdminFunReg adminFunReg = regMap.get(adminFunSection.getRegId());
					if(null == adminFunReg) {
						continue;
					}
					itemMap.put("regName", adminFunReg.getRegName());
					itemMap.put("sectionId", adminFunSection.getSectionId());
					itemMap.put("sectionName", adminFunSection.getSectionName());
					regSectionMap.add(itemMap);
				}
	
				resMap.put("serviceString", regSectionMap);
			}
			resMap.put("inviteId", erpFunUsersInvited.getId());
			resMap.put("userMobile", erpFunUsersInvited.getUserMobile());
			resMap.put("userName", erpFunUsersInvited.getUserName());
			
			if(erpFunUsersInvited.getCurrentPId() !=null){
				resMap.put("currentPId", erpFunUsersInvited.getCurrentPId());
				ErpFunUsers erpFunUsers  = erpFunUsersMapper.selectByUserId(cityId, erpFunUsersInvited.getCurrentPId());
				resMap.put("pUserName", erpFunUsers.getUserName());
			}

			//根据系统参数判断是不是新组织架构
			String organizationType = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");
			if("1".equals(organizationType)){//zt组织机构
				// 检测下组织状态
				ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsersInvited.getOrganizationId());
				if (erpFunOrganization == null) {
					return ErpResponseJson.warn("该组织不存在，请联系管理员！");
				} else {
					// //zt组织机构待定
					// 检查用户注册已经达到许可的最大值(此逻辑暂时没写   等待销售政策？)
//					resMap.put("organizationId", erpFunOrganization.getOrganizationId());
//					resMap.put("organizationName", erpFunOrganization.getOrganizationName());
					resMap.put("deptId", erpFunOrganization.getOrganizationId());// 组织ID
					resMap.put("deptName", erpFunOrganization.getOrganizationName());// 组织名称
				}
			} else {
				// 检测下门店状态
				ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsersInvited.getDeptId());
				if(null != byDeptId && 0 != byDeptId.getDeptFlag()) {
					String s = checkDeptUserNum(cityId, byDeptId);
					if(StringUtils.isNotBlank(s)) {
						return ErpResponseJson.warn(s);
					}else {
						resMap.put("deptId", byDeptId.getDeptId());
						resMap.put("deptName", byDeptId.getDeptCname());
					}
				}else {
					return ErpResponseJson.warn("该门店不存在，请联系管理员！");
				}
			}
			

			return ErpResponseJson.ok(resMap);
		}
		return ErpResponseJson.ok();
	}

	/**
	  * @title  短信验证
	  * @author lcb
	  * @date   2018/9/8 18:29
	  * @desc
	  **/
	private Boolean isValidKey(UserPhoneValidParam param) {
		String userMobile = param.getMobile();
		String validateKey = param.getKey();
		Boolean checked = false;
		validateKey = validateKey == null ? "" : validateKey;
		Map<String, Object> resultMap = new HashMap<>();
		boolean isValid = false;
		if (!"".equals(validateKey)) {// 检测电话号码是否通过
			// 这里判断是否有定制参数
			String notValidteMsgCodeTime = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "NOT_VALIDTE_MSG_CODE_TIME");
			// 时间未过期
			if(StringUtils.isNotBlank(notValidteMsgCodeTime)) {
				boolean notValidMsgCode = DateUtil.StringToDate(notValidteMsgCodeTime).after(new Date());

				if(notValidMsgCode) {
					String commonMsgCode = erpSysParaMapper.getParamValue(param.getCityId(), param.getCompId(), "COMMON_MSG_CODE");
					if(StringUtils.isNotBlank(commonMsgCode) && commonMsgCode.equals(validateKey)) {
						isValid = true;
					}
				}
			}

			// 如果用了通用码就不再验证了
			if (!isValid){
				isValid = adminMobileKeyService.validateSmsCode(validateKey, userMobile);
			}
		} else {// 如果没有输入验证码 检测是否打过电话认证
			isValid = adminMobileKeyService.checkMobileDialToday(userMobile);
		}
		if (isValid) {
			checked = true;
		}
		return checked;
	}

	private String checkDeptUserNum(Integer cityId, ErpFunDepts byDeptId) {
		// 查询门店是否是租用或者新营销版
		AdminFunDepts deptByCompNoAndDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(byDeptId.getCompNo(), byDeptId.getDeptNo());

		String resultMsg = null;
		Integer userNum = null;
		if ((null != deptByCompNoAndDeptNo.getDeptType() && 4 == deptByCompNoAndDeptNo.getDeptType().intValue()) ||
				(null != deptByCompNoAndDeptNo.getPayType() && 5 == deptByCompNoAndDeptNo.getPayType().intValue())) {
			userNum = erpFunUsersMapper.countUserNumberForRentDept(cityId, byDeptId.getDeptId());
		}else {
			ErpFunUsersExample usersExample=new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andDeptIdEqualTo(byDeptId.getDeptId()).andUserWriteoffEqualTo(false);
			userNum=erpFunUsersMapper.countByExample(usersExample);
		}

		Integer deptsUserNum = byDeptId.getUserNum();
		if (deptsUserNum == null){
			resultMsg = "该公司暂未发出邀请，请联系管理员！";
		}
		if (deptsUserNum<=userNum){
			resultMsg = "用户注册已经达到许可的最大值，请联系管理员";
		}
		return resultMsg;
	}

	/**
	  * @title  公司邀请注册
	  * @author lcb
	  * @date   2018/9/8 8:38
	  * @desc
	  **/
	@ResponseBody
	@RequestMapping(value="/getCompInviteSectionList", method={RequestMethod.POST})
	public ErpResponseJson getCompInviteSectionList(String param, Integer regId) throws Exception{
		if(StringUtils.isBlank(param)) {
			return ErpResponseJson.ok();
		}
		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		Integer cityId = jsonObject.getInteger("cityId");
		ErpFunSectionExample example = new ErpFunSectionExample();
		example.createCriteria().andCityIdEqualTo(cityId.shortValue())
				.andRegIdEqualTo(regId).andVertifyFlagEqualTo((byte) 1);
		example.setShardCityId(cityId);
		List<ErpFunSection> sectionList = erpFunSectionMapper.selectByExample(example);
		return ErpResponseJson.ok(sectionList);
	}

	/**
	 * @title  公司邀请注册
	 * @author lcb
	 * @date   2018/9/8 8:38
	 * @desc
	 **/
	@ResponseBody
	@RequestMapping(value="/getCompInviteRegList", method={RequestMethod.POST})
	public ErpResponseJson getCompInviteRegList(String param) throws Exception{
		if(StringUtils.isBlank(param)) {
			return ErpResponseJson.ok();
		}
		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		Integer cityId = jsonObject.getInteger("cityId");

		AdminFunRegExample example = new AdminFunRegExample();
		example.createCriteria().andCityIdEqualTo(cityId.shortValue());
		List<AdminFunReg> adminFunRegs = adminFunRegMapper.selectByExample(example);
		return ErpResponseJson.ok(adminFunRegs);
	}

	/**
	 * @title  公司邀请注册
	 * @author lcb
	 * @date   2018/9/8 8:38
	 * @desc
	 **/
	@RequestMapping(value="/addCompInviteUser", method={RequestMethod.POST})
	@ResponseBody
	public ErpResponseJson addCompInviteUser(String param, String password, String regIds,
		String sectionIds, String serviceZone, Integer inviteId) throws Exception{
		if(StringUtils.isBlank(param)) {
			return ErpResponseJson.warn("系统错误，请联系在线客服");
		}
		if(StringUtils.isBlank(regIds) || StringUtils.isBlank(sectionIds)) {
			return ErpResponseJson.warn("请选择服务范围");
		}
		if(StringUtils.isBlank(password)) {
			return ErpResponseJson.warn("请填写密码");
		}

		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		Integer cityId = jsonObject.getInteger("cityId");
		Integer compId = jsonObject.getInteger("compId");
		String compNo = jsonObject.getString("compNo");

		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
			
		ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
		example.setShardCityId(cityId);
		example.createCriteria().andIdEqualTo(inviteId).andCompIdEqualTo(compId).
				andCompNoEqualTo(compNo).andInviteStatusEqualTo((byte) 0).andCityIdEqualTo(cityId);
		example.setOrderByClause(" ID DESC");
		List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
		if(resList.size() == 0) {
			return ErpResponseJson.warn("数据异常，请管理员重新邀请");
		}

		ErpFunUsersInvited erpFunUsersInvited = resList.get(0);

		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunUsersInvited.getCreateUid());

		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(erpFunUsers.getArchiveId());

		// 调新增员工接口
		CreateUserParam addParam = new CreateUserParam();
		addParam.setCurrentCityId(cityId);
		addParam.setCurrentCompId(compId);
		addParam.setCurrentUserId(erpFunUsers.getUserId());
		addParam.setServiceReg(regIds);
		addParam.setServiceZone(serviceZone);
		addParam.setServiceZoneIds(sectionIds);

		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		addParam.setCurrentCompType(adminFunComp.getCompType().intValue());
		addParam.setCurrentDeptId(erpFunUsersInvited.getDeptId());
		addParam.setCurrentUserEdition(erpFunUsers.getUserEdition());
		addParam.setProvinceId(adminFunCity.getProvinceId().intValue());
		addParam.setSelUid(adminFunArchive.getSellId());
		addParam.setPerLogin(false);
		addParam.setCompType(adminFunComp.getCompType().intValue());

		// 根据电话查询
//		AdminFunArchive addArchive = adminFunArchiveMapper.selectByMobile(erpFunUsersInvited.getUserMobile());
		ErpFunUsers newUser = new ErpFunUsers();
		// modify lcb 修改于 2020/5/26 美联取消精英版
//		if(null != addArchive) {
//			if(2 != addArchive.getUserEdition()) {
//				return ErpResponseJson.warn("操作失败，您已加入门店了");
//			}
//			newUser = erpFunUsersMapper.selectByArchiveId(addArchive.getArchiveId());
//		}
//
//		if(null == newUser) {
//			newUser = new ErpFunUsers();
//		}
//		ErpFunUsers newUser = getParamObj(ErpFunUsers.class);
		newUser.setCompId(compId);
		newUser.setCityId(cityId.shortValue());
		newUser.setUserName(erpFunUsersInvited.getUserName());
		newUser.setGrId(null == erpFunUsersInvited.getGrId() ? 0 : erpFunUsersInvited.getGrId());
		newUser.setAreaId(StringUtil.parseInteger(erpFunUsersInvited.getAreaId()));

		// 检查大区是否删除
		if(null != erpFunUsersInvited.getRegId()) {
			ErpFunRegion dataById = erpFunRegionMapper.getDataById(cityId, erpFunUsersInvited.getRegId());
			if(null != dataById && 0 == dataById.getIsDel()) {
				newUser.setRegId(StringUtil.parseInteger(erpFunUsersInvited.getRegId()));
			}else {
				// 查找一个默认大区
				List<ErpFunRegion> cacheableRegionListByAreaId = erpFunRegionMapper.getCacheableRegionListByAreaId(cityId, compId);
				if(cacheableRegionListByAreaId.size() > 0) {
					newUser.setRegId(cacheableRegionListByAreaId.get(0).getRegId());
				}
			}
		}else {
			newUser.setRegId(0);
		}


		newUser.setCompId(erpFunUsersInvited.getCompId());
		newUser.setDeptId(erpFunUsersInvited.getDeptId());
		newUser.setUserMobile(erpFunUsersInvited.getUserMobile());
		newUser.setUserStatus((byte) 1);

		// 检查下管理范围是否失效
		addParam.setUserPosition(erpFunUsersInvited.getUserPosition());
		newUser.setUserPosition(erpFunUsersInvited.getUserPosition());
		newUser.setLoginPassword(password);
		newUser.setUserSex(null != erpFunUsersInvited.getUserSex() && 1 == erpFunUsersInvited.getUserSex());
		this.validateManageRange(cityId, compId, erpFunUsersInvited.getRangeType(), erpFunUsersInvited.getRangeIds(), addParam);
		if (adminFunComp.getCompType() == Const.DIC_COMP_TYPE_5.intValue()) {
			if (Const.DIC_ROLE_NAME_BRANCH_MANAGER.equals(erpFunUsersInvited.getUserPosition())) {
				addParam.setRangeIds(erpFunUsersInvited.getDeptId() + "");
				addParam.setRangeType(4);
			}
		}

		//**********************组织架构改版********************************
		String organizationType = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");// 1=开启无限组织机构
		if ("1".equals(organizationType)) {//zt组织机构
			// 先检测下组织状态
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsersInvited.getOrganizationId());
			if (erpFunOrganization == null) {
				return ErpResponseJson.warn("该组织不存在，请联系管理员！");
			}
			addParam.setOrganizationType(organizationType);
			addParam.setRangeIds(null);
			addParam.setRangeType(null);
			addParam.setOrganizationId(erpFunUsersInvited.getOrganizationId());
			addParam.setTissueLine(erpFunOrganization.getOrganizationPath());// 不能用邀请注册表的path  很有可能组织变了 path就会变 要取最新的
			newUser.setOrganizationId(erpFunUsersInvited.getOrganizationId());
			newUser.setTissueLine(erpFunOrganization.getOrganizationPath());

//			String validResult = this.validateManageRangeNew(cityId, compId, addParam);// 通过organizationId设置新的管理范围ID

		}
		//**********************组织架构改版********************************
		//添加职级ID
		addParam.setRoleLevelId(erpFunUsersInvited.getRoleLevelId());
		boolean isFangJidi = this.judgerIsFangjidi(adminFunComp.getCompId());

		String createUserName = null;

		ErpFunUsers createUser = erpFunUsersService.createUserNew(newUser, addParam, erpFunUsersInvited.getCurrentPId(), isFangJidi,createUserName);
		// 注册是否自动绑定小号
		try{
//			String paramValue = erpSysParaMapper.getParamValueWithPartnerId(cityId, createUser.getCompId(), createUser.getPartnerId() ,"AUTO_BIND_AXN");
//			if ("1".equals(paramValue)) {
//				List<Integer> userIdList = new ArrayList<Integer>();
//				userIdList.add(createUser.getUserId());
//				erpAliyunPhoneService.batchBindNumber(cityId, compId, createUser.getUserId(), userIdList);
//			}
            //String paramValue = erpSysParaMapper.getParamValueWithPartnerId(cityId, compId, createUser.getPartnerId(), "AUTO_BIND_AXN");
            String paramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, createUser.getUserId(), "AUTO_BIND_AXN");
            if (StringUtil.isNotEmpty(paramValue) && "1".equals(paramValue)) {
                // 判断是否是自动绑定的角色 是需要自动绑定的角色，才调用绑定逻辑
                if (StringUtil.isNotEmpty(createUser.getUserPosition())) {
                    String autoBindAxnNumberRole = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, createUser.getUserId(), "AUTO_BIND_AXN_NUMBER_ROLE"); // 自动绑定小号的角色
                    if (StringUtil.isNotEmpty(autoBindAxnNumberRole) && autoBindAxnNumberRole.contains(createUser.getUserPosition())) {
                        List<Integer> userIdList = new ArrayList<Integer>();
                        userIdList.add(createUser.getUserId());
                        erpAliyunPhoneService.batchBindNumber(cityId, compId, createUser.getUserId(), userIdList);
                    }
                }
            }
		} catch (Exception e) {
		    System.out.println("绑定小号异常");
			e.printStackTrace();
		}

		Map<String, Object> userInfo = new HashMap<>();
		userInfo.put("cityId", createUser.getCityId());
		userInfo.put("compId", createUser.getCompId());
		userInfo.put("archiveId", createUser.getArchiveId());
		userInfo.put("orgId", erpFunUsersInvited.getOrganizationId());
		httpRequestTask.postToMobileWeb("approveOpenApi/yxTeam/newEmpOrg", userInfo);

		// 删除带邀请
		ErpFunUsersInvited updateFunUserInvited = new ErpFunUsersInvited();
		updateFunUserInvited.setUpdateTime(new Date());
		updateFunUserInvited.setInviteStatus((byte) 2);
		ErpFunUsersInvitedExample updateExample = new ErpFunUsersInvitedExample();
		updateExample.setShardCityId(cityId);
		updateExample.createCriteria().andUserMobileEqualTo(erpFunUsersInvited.getUserMobile());
		erpFunUsersInvitedMapper.updateByExampleSelective(updateFunUserInvited, updateExample);
		return ErpResponseJson.ok();
	}

	/**
	 * 通过organizationId设置新的管理范围ID
	 * @param cityId
	 * @param compId
	 * @param addParam
	 * @author zangtie
	 * @since 2019/12/8 14:30
	 * @return void
	 **/
	private String validateManageRangeNew(Integer cityId, Integer compId, CreateUserParam addParam) {
		String validResult = "";
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, addParam.getOrganizationId());
		if (erpFunOrganization == null) {
			validResult = "当前组织不存在，请联系管理重新发起邀请注册";
		}
		return null;
	}



	public boolean judgerIsFangjidi(Integer adminCompId) {
		boolean isHouseBase = false;
		if (null != adminCompId) {
			AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminCompId);
			if (null != adminFunComp) {
				if (Byte.valueOf("2").equals(adminFunComp.getCompManagementModel()) && Integer.valueOf(1).equals(adminFunComp.getCustomizedType())) {
					isHouseBase = true;
				}
			}
		}
		return isHouseBase;
	}

	public void validateManageRange(Integer cityId, Integer compId, Integer rangeType, String rangeIds, CreateUserParam addParam) {
		if(null == rangeType || StringUtils.isBlank(rangeIds)) {
			return;
		}

		String[] rangeId = rangeIds.split(",");
		List<String> strings = Arrays.asList(rangeId);
		List<Integer> regIds = strings.stream().map(Integer::valueOf).collect(Collectors.toList());
		String newRangeIds = "";
		switch (rangeType) {
			case 2 :
				ErpFunAreaExample areaExample = new ErpFunAreaExample();
				areaExample.setShardCityId(cityId);
				areaExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0);
				List<ErpFunArea> erpFunAreas = erpFunAreaMapper.selectByExample(areaExample);
				for (ErpFunArea erpFunArea : erpFunAreas) {
					if (regIds.contains(erpFunArea.getAreaId())) {
						newRangeIds += erpFunArea.getAreaId() + ",";
					}
				}
				break;
			case 3 :
				ErpFunRegionExample regionExample = new ErpFunRegionExample();
				regionExample.setShardCityId(cityId);
				regionExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0);
				List<ErpFunRegion> erpFunRegionList = erpFunRegionMapper.selectByExample(regionExample);
				for (ErpFunRegion erpFunRegion : erpFunRegionList) {
					if (regIds.contains(erpFunRegion.getRegId())) {
						newRangeIds += erpFunRegion.getRegId() + ",";
					}
				}
				break;
			case 4 :
				ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
				erpFunDeptsExample.setShardCityId(cityId);
				erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId);
				List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
				for (ErpFunDepts erpFunDepts : erpFunDeptsList) {
					if (regIds.contains(erpFunDepts.getDeptId())) {
						newRangeIds += erpFunDepts.getDeptId() + ",";
					}
				}
				break;
			case 5 :
				ErpFunDeptsgroupExample funDeptsgroupExample = new ErpFunDeptsgroupExample();
				funDeptsgroupExample.setShardCityId(cityId);
				funDeptsgroupExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0);
				List<ErpFunDeptsgroup> erpFunDeptsgroupList = erpFunDeptsgroupMapper.selectByExample(funDeptsgroupExample);
				for (ErpFunDeptsgroup erpFunDeptsgroup : erpFunDeptsgroupList) {
					if (regIds.contains(erpFunDeptsgroup.getGrId())) {
						newRangeIds += erpFunDeptsgroup.getGrId() + ",";
					}
				}
				break;
		}
		if(StringUtils.isNotBlank(newRangeIds)) {
			newRangeIds = StringUtils.removeEnd(newRangeIds,  ",");
			addParam.setRangeIds(newRangeIds);
			addParam.setRangeType(rangeType);
		}
	}

	/**
	 * @title  公司邀请注册
	 * @author lcb
	 * @date   2018/9/8 8:38
	 * @desc
	 **/
	@RequestMapping(value="/success.htm")
	public ModelAndView successHtm(ModelAndView view, String param) throws Exception{
		// 查询数据
		String decode = AESHelper.decode(param);
		JSONObject jsonObject = JSON.parseObject(decode);
		String compNo = jsonObject.getString("compNo");
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		view.addObject("compName", adminFunComp.getCompCname());
		String leaguesType = jsonObject.getString("leaguesType");
		String url="openApi/compInviteRegist/leaguesTypeSucc";
		try {
			String downLoadUrl = getDownLoadUrl(compNo, leaguesType);
			view.addObject("downLoadUrl", downLoadUrl);
		}catch (Exception e){}

		view.addObject("leaguesType", 1);
		view.setViewName(url);
		return view;
	}

	/**
	  * @title 获取APP 下载地址
	  * @author lcb
	  * @date 2019/6/5
	  * @param
	  * @return
	  */
	private String getDownLoadUrl(String compNo, String leaguesType) {
		String downLoadUrl = "";
		if(StringUtils.isBlank(leaguesType)) {
			return downLoadUrl;
		}
		AdminCustomLeaguesSkinModelExample adminCustomLeaguesSkinModelExample = new AdminCustomLeaguesSkinModelExample();
		adminCustomLeaguesSkinModelExample.createCriteria().andLeaguesTypeEqualTo(Integer.valueOf(leaguesType)).andSkinTypeEqualTo("appDownLoadUrl");
		List<AdminCustomLeaguesSkinModel> adminCustomLeaguesSkinModels = adminCustomLeaguesSkinModelMapper.selectByExample(adminCustomLeaguesSkinModelExample);
		return adminCustomLeaguesSkinModels.size() > 0 ? adminCustomLeaguesSkinModels.get(0).getSkinPicUrl() : "";
	}

	@ResponseBody
    @RequestMapping(value="/validateCompInviteMsgNew", method={RequestMethod.POST})
	@Deprecated
    public ErpResponseJson validateCompInviteMsgNew(String userMobile,  String code,Integer isFjd,
            String compNo, Integer cityId, Integer compId) throws Exception{

        if(StringUtils.isBlank(userMobile)) {
            return ErpResponseJson.ok();
        }
        if(null == isFjd){
            isFjd = 0;
        }
        // 校验能不能注册
        AdminFunArchive archiveByMobile = adminFunArchiveMapper.getArchiveByMobile(userMobile);
        if (null != archiveByMobile && !(2 == archiveByMobile.getUserEdition())) {
            return ErpResponseJson.warn("手机号已在其他门店注册！");
        }
        // 查询数据
        ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
        erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserMobileEqualTo(userMobile).andUserWriteoffEqualTo(false);
        erpFunUsersExample.setShardCityId(cityId);
        Integer countUser = erpFunUsersMapper.countByExample(erpFunUsersExample);
        if(countUser > 0){
            return ErpResponseJson.warn("您已经是该公司的员工，无需再次验证！");
        }
        UserPhoneValidParam validParam = new UserPhoneValidParam();
        validParam.setCityId(cityId);
        validParam.setCompId(compId);
        validParam.setMobile(userMobile);
        validParam.setKey(code);
        Boolean validKey = this.isValidKey(validParam);
        if (!validKey) {
            return ErpResponseJson.warn("校验码错误！");
        }
        Map<String, Object> resMap = new HashMap<>();
        if("0".equals(isFjd.toString())){
            ErpFunUsersInvitedExample example = new ErpFunUsersInvitedExample();
            example.setShardCityId(cityId);
            example.createCriteria().andUserMobileEqualTo(userMobile).andCompIdEqualTo(compId).
            andCompNoEqualTo(compNo).andInviteStatusEqualTo((byte) 0).andCityIdEqualTo(cityId);
            List<ErpFunUsersInvited> resList = erpFunUsersInvitedMapper.selectByExample(example);
            if(resList.size() == 0) {
                return ErpResponseJson.warn("该公司未发出邀请，请联系管理员！");
            }
            ErpFunUsersInvited erpFunUsersInvited = resList.get(0);
            ErpCompRoles byRoleId = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsersInvited.getUserPosition());
            if(null != byRoleId && 0 == byRoleId.getIsDel()) {
                resMap.put("roleId", byRoleId.getRoleId());
                resMap.put("roleName", byRoleId.getRoleName());
            }else {
                resMap.put("roleId", "PRACTY_BIZ");
                resMap.put("roleName", "见习经纪人");
            }
        
            //获取上级
            
            // 处理服务区域
            String serviceReg = erpFunUsersInvited.getServiceReg();
            String serviceZoneId = erpFunUsersInvited.getServiceZoneIds();
    
            resMap.put("serviceReg", serviceReg);
            resMap.put("serviceZoneId", serviceZoneId);
            if(StringUtils.isNotBlank(serviceReg)) {
                // 查询区域
                String[] serviceRegs = serviceReg.split(" ");
                String[] serviceZoneIds = serviceZoneId.split(" ");
                List<String> strings = Arrays.asList(serviceRegs);
                List<String> zoneIds = Arrays.asList(serviceZoneIds);
                List<Integer> regIds = strings.stream().map(Integer::valueOf).collect(Collectors.toList());
                List<Integer> sectionIds = zoneIds.stream().map(Integer::valueOf).collect(Collectors.toList());
    
                List<AdminFunReg> funRegList = adminFunRegMapper.getFunRegList(regIds);
                Map<Integer, AdminFunReg> regMap = funRegList.stream().collect(Collectors.toMap(val->val.getRegId(), val->val));
    
                List<AdminFunSection> sectionList = adminFunSectionMapper.selectListBySectionIds(cityId, sectionIds);
    
                List<Map<String, Object>> regSectionMap = new ArrayList<>();
                for (AdminFunSection adminFunSection : sectionList) {
                    Map<String, Object> itemMap = new HashMap<>();
                    itemMap.put("regId", adminFunSection.getRegId());
                    AdminFunReg adminFunReg = regMap.get(adminFunSection.getRegId());
                    if(null == adminFunReg) {
                        continue;
                    }
                    itemMap.put("regName", adminFunReg.getRegName());
                    itemMap.put("sectionId", adminFunSection.getSectionId());
                    itemMap.put("sectionName", adminFunSection.getSectionName());
                    regSectionMap.add(itemMap);
                }
    
                resMap.put("serviceString", regSectionMap);
            }
            resMap.put("inviteId", erpFunUsersInvited.getId());
            resMap.put("userMobile", erpFunUsersInvited.getUserMobile());
            resMap.put("userName", erpFunUsersInvited.getUserName());
            
            if(erpFunUsersInvited.getCurrentPId() !=null){
                resMap.put("currentPId", erpFunUsersInvited.getCurrentPId());
                ErpFunUsers erpFunUsers  = erpFunUsersMapper.selectByUserId(cityId, erpFunUsersInvited.getCurrentPId());
                resMap.put("pUserName", erpFunUsers.getUserName());
            }

            //根据系统参数判断是不是新组织架构
            String organizationType = "1";//erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");
            if("1".equals(organizationType)){//zt组织机构
                // 检测下组织状态
                ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsersInvited.getOrganizationId());
                if (erpFunOrganization == null) {
                    return ErpResponseJson.warn("该组织不存在，请联系管理员！");
                } else {
                    // //zt组织机构待定
                    // 检查用户注册已经达到许可的最大值(此逻辑暂时没写   等待销售政策？)
//                  resMap.put("organizationId", erpFunOrganization.getOrganizationId());
//                  resMap.put("organizationName", erpFunOrganization.getOrganizationName());
                    resMap.put("deptId", erpFunOrganization.getOrganizationId());// 组织ID
                    resMap.put("deptName", erpFunOrganization.getOrganizationName());// 组织名称
                }
            } else {
                // 检测下门店状态
                ErpFunDepts byDeptId = erpFunDeptsMapper.getByDeptId(cityId, erpFunUsersInvited.getDeptId());
                if(null != byDeptId && 0 != byDeptId.getDeptFlag()) {
                    String s = checkDeptUserNum(cityId, byDeptId);
                    if(StringUtils.isNotBlank(s)) {
                        return ErpResponseJson.warn(s);
                    }else {
                        resMap.put("deptId", byDeptId.getDeptId());
                        resMap.put("deptName", byDeptId.getDeptCname());
                    }
                }else {
                    return ErpResponseJson.warn("该门店不存在，请联系管理员！");
                }
            }
            

            return ErpResponseJson.ok(resMap);
        }
        return ErpResponseJson.ok();
    }

    /**
     * @title 导数据使用的程序上不能调用
     * @author lcb
     * @date 2019/12/29
     *
     **/
	@RequestMapping(value="/addCompInviteUserNew", method={RequestMethod.POST})
    @ResponseBody
	@Deprecated
    public ErpResponseJson addCompInviteUserNew(MlHrsSyncAddUserParam param) throws Exception{

		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String compNo = param.getCompNo();

		if(StringUtils.isBlank(param.getRegIds()) || StringUtils.isBlank(param.getSectionIds())) {
            return ErpResponseJson.warn("请选择服务范围");
        }
        if(StringUtils.isBlank(param.getPassword())) {
            return ErpResponseJson.warn("请填写密码");
        }

        AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
            
        ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getSelfUserId());

        if(erpFunUsers == null){
            erpFunUsers = erpFunUsersMapper.getTop1ValidUserByCompId(cityId, compId);
        }
        
        AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(erpFunUsers.getArchiveId());

        // 调新增员工接口
        CreateUserParam addParam = new CreateUserParam();
        addParam.setUserJobDate(param.getUserJobDate());
        addParam.setCurrentCityId(cityId);
        addParam.setCurrentCompId(compId);
        addParam.setCurrentUserId(erpFunUsers.getUserId());
        addParam.setServiceReg(param.getRegIds());
        addParam.setServiceZone(param.getServiceZone());
        addParam.setServiceZoneIds(param.getSectionIds());

        AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
        addParam.setCurrentCompType(adminFunComp.getCompType().intValue());
        addParam.setCurrentDeptId(param.getDeptId());
        addParam.setCurrentUserEdition(erpFunUsers.getUserEdition());
        addParam.setProvinceId(adminFunCity.getProvinceId().intValue());
        addParam.setSelUid(adminFunArchive.getSellId());
        addParam.setPerLogin(false);
        addParam.setCompType(adminFunComp.getCompType().intValue());


        // 根据电话查询
//        AdminFunArchive addArchive = adminFunArchiveMapper.selectByMobile(param.getUserMobile());
        ErpFunUsers newUser = new ErpFunUsers();
        // modify lcb 修改于 2020/5/26 取消精英版逻辑
//        if(null != addArchive) {
//            if(2 != addArchive.getUserEdition()) {
//                return ErpResponseJson.warn("操作失败，您已加入门店了");
//            }
//            newUser = erpFunUsersMapper.selectByArchiveId(addArchive.getArchiveId());
//        }
//
//        if(null == newUser) {
//            newUser = new ErpFunUsers();
//        }
//      ErpFunUsers newUser = getParamObj(ErpFunUsers.class);
        newUser.setCompId(compId);
        newUser.setCityId(cityId.shortValue());
        newUser.setUserName(param.getUserName());
        newUser.setGrId(null == param.getGrId() ? 0 : param.getGrId());
        newUser.setAreaId(StringUtil.parseInteger(param.getAreaId()));

        // 检查大区是否删除
        if(null != param.getRegId()) {
            ErpFunRegion dataById = erpFunRegionMapper.getDataById(cityId, param.getRegId());
            if(null != dataById && 0 == dataById.getIsDel()) {
                newUser.setRegId(StringUtil.parseInteger(param.getRegId()));
            }else {
                // 查找一个默认大区
                List<ErpFunRegion> cacheableRegionListByAreaId = erpFunRegionMapper.getCacheableRegionListByAreaId(cityId, compId);
                if(cacheableRegionListByAreaId.size() > 0) {
                    newUser.setRegId(cacheableRegionListByAreaId.get(0).getRegId());
                }
            }
        }else {
            newUser.setRegId(0);
        }


        newUser.setCompId(param.getCompId());
        newUser.setDeptId(param.getDeptId());
        newUser.setUserMobile(param.getUserMobile());
        newUser.setUserStatus((byte) 1);

        // 检查下管理范围是否失效
        addParam.setUserPosition(param.getUserPosition());
        newUser.setUserPosition(param.getUserPosition());
        newUser.setLoginPassword(param.getPassword());
        newUser.setUserSex(null != param.getUserSex() && 1 == param.getUserSex());
        this.validateManageRange(cityId, compId, param.getRangeType(), param.getRangeIds(), addParam);

        //**********************组织架构改版********************************
		// 先检测下组织状态
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, param.getOrganizationId());
		if (erpFunOrganization == null) {
			return ErpResponseJson.warn("该组织不存在，请联系管理员！");
		}
		addParam.setOrganizationType("1");
		addParam.setRangeIds(null);
		addParam.setRangeType(null);
		addParam.setOrganizationId(param.getOrganizationId());
		addParam.setTissueLine(erpFunOrganization.getOrganizationPath());// 不能用邀请注册表的path  很有可能组织变了 path就会变 要取最新的
		newUser.setOrganizationId(param.getOrganizationId());
		newUser.setTissueLine(erpFunOrganization.getOrganizationPath());
		// modify lcb 修改于 2020/5/26 美联userId和userNo
		newUser.setMlUserId(param.getMlUserId());
		newUser.setUserNo(param.getMlUserNo());
		newUser.setUserIccode(param.getIccode());
        //**********************组织架构改版********************************
        //添加职级ID
        addParam.setRoleLevelId(param.getRoleLevelId());
        boolean isFangJidi = this.judgerIsFangjidi(adminFunComp.getCompId());

        String createUserName = erpFunUsers.getUserName();
//
		ErpFunUsers createUser = erpFunUsersService.createUserNew(newUser, addParam, null, isFangJidi,createUserName);
		// 注册是否自动绑定小号
		try{
//			ErpSysPara erpSysPara = erpSysParaMapper.selectByParamId(cityId, createUser.getCompId(), "AUTO_BIND_AXN");
//			if (erpSysPara != null && "1".equals(erpSysPara.getParamValue())) {
//				List<Integer> userIdList = new ArrayList<Integer>();
//				userIdList.add(createUser.getUserId());
//				erpAliyunPhoneService.batchBindNumber(cityId, compId, createUser.getUserId(), userIdList);
//			}
			String paramValue = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, createUser.getUserId(), "AUTO_BIND_AXN");
			if (StringUtil.isNotEmpty(paramValue) && "1".equals(paramValue)) {
				// 判断是否是自动绑定的角色 是需要自动绑定的角色，才调用绑定逻辑
				if (StringUtil.isNotEmpty(createUser.getUserPosition())) {
					String autoBindAxnNumberRole = erpSysParaService.getMLSysParamValByUserDefEmpty(cityId, compId, createUser.getUserId(), "AUTO_BIND_AXN_NUMBER_ROLE"); // 自动绑定小号的角色
					if (StringUtil.isNotEmpty(autoBindAxnNumberRole) && autoBindAxnNumberRole.contains(createUser.getUserPosition())) {
						List<Integer> userIdList = new ArrayList<Integer>();
						userIdList.add(createUser.getUserId());
						erpAliyunPhoneService.batchBindNumber(cityId, compId, createUser.getUserId(), userIdList);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

        return ErpResponseJson.ok(createUser);
    }

	@RequestMapping(value="/configureUserKPI", method={RequestMethod.GET})
	@ResponseBody
	public ErpResponseJson configureUserKPI(@RequestParam("cityId") Integer cityId, @RequestParam("userId")Integer userId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		Assert.isNullThrow(erpFunUsers, "经纪人不存在！");
		erpFunUsersService.configureUserKPI(cityId, erpFunUsers);
		erpFunUsersService.initKpiStatisticRecord(cityId, userId);
		return ErpResponseJson.ok();
	}
}


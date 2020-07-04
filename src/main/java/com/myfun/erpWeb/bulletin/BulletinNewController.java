package com.myfun.erpWeb.bulletin;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.bulletin.param.AddBulletReplyZanParam;
import com.myfun.erpWeb.bulletin.param.BulletBaseInfoParam;
import com.myfun.erpWeb.bulletin.param.BulletinInfoParam;
import com.myfun.erpWeb.bulletin.param.BulletinListParam;
import com.myfun.erpWeb.bulletin.param.CreateBulletParam;
import com.myfun.erpWeb.bulletin.vo.AdminBulletVo;
import com.myfun.erpWeb.bulletin.vo.BulletinInfoVo;
import com.myfun.erpWeb.bulletin.vo.CreateBulletVo;
import com.myfun.erpWeb.bulletin.vo.FileUploadResultVo;
import com.myfun.erpWeb.common.vo.OrganizationVO;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.taskJob.AsyncTask;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminBanMapper;
import com.myfun.repository.admindb.dao.AdminBulletMapper;
import com.myfun.repository.admindb.dao.AdminBulletReplyMapper;
import com.myfun.repository.admindb.dao.AdminBulletReplyZanMapper;
import com.myfun.repository.admindb.dao.AdminBulletViewLogMapper;
import com.myfun.repository.admindb.dao.AdminBulletYouUsersMapper;
import com.myfun.repository.admindb.dao.AdminBulletinPsMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunUsersCountMapper;
import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.dto.AdminBulletReplyDto;
import com.myfun.repository.admindb.dto.AdminBulletViewLogDto;
import com.myfun.repository.admindb.dto.AdminBulletinPsDto;
import com.myfun.repository.admindb.dto.AdminFunUsersCountDto;
import com.myfun.repository.admindb.param.AdminBulletReplyParam;
import com.myfun.repository.admindb.po.AdminBullet;
import com.myfun.repository.admindb.po.AdminBulletExample;
import com.myfun.repository.admindb.po.AdminBulletReply;
import com.myfun.repository.admindb.po.AdminBulletReplyExample;
import com.myfun.repository.admindb.po.AdminBulletReplyZan;
import com.myfun.repository.admindb.po.AdminBulletReplyZanExample;
import com.myfun.repository.admindb.po.AdminBulletViewLog;
import com.myfun.repository.admindb.po.AdminBulletinPs;
import com.myfun.repository.admindb.po.AdminBulletinPsExample;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.erpdb.dto.CompPartnerCountVO;
import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.PageParam;
import com.myfun.service.business.admindb.AdminBulletService;
import com.myfun.service.business.erpdb.ErpFunOrganizationDefinitionService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.FileUtil;
import com.myfun.utils.OperatorSessionUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.bean.FileUploadResult;
import com.myfun.utils.bean.FileUploadResult.FileInfo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 帖子相关
 * 
 * @author 张宏利
 * @since 2018年2月6日
 */
@Controller
@RequestMapping("/bulletinNew")
public class BulletinNewController extends BaseController {

	@Autowired
	private AdminBulletService adminBulletService;
	@Autowired
	ErpBroadcastMapper erpBroadcastMapper;
	@Autowired
	private AdminBulletinPsMapper adminBulletinPsMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private AdminBulletMapper adminBulletMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminFunUsersCountMapper adminFunUsersCountMapper;
	@Autowired
	private AdminBanMapper adminBanMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private AdminBulletReplyMapper adminBulletReplyMapper;
	@Autowired
	private AdminBulletReplyZanMapper adminBulletReplyZanMapper;
	@Autowired
	private AdminBulletYouUsersMapper adminBulletYouUsersMapper;
	@Autowired
	private ErpFunTaskMapper erpFunTaskMapper;
	@Autowired
	private ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	private AdminBulletViewLogMapper adminBulletViewLogMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AsyncTask asyncTask;
	@Autowired
	private ErpFunOrganizationDefinitionService erpFunOrganizationDefinitionService;
	@Autowired
	private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpFunOrganizationService erpFunOrganizationService;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
    private ErpFunTaskTimedMapper erpFunTaskTimedMapper;

	/**
	 * 创建帖子页面
	 * @author 张宏利
	 * @since 2018年2月9日
	 * @param paramMap
	 * @param bulletId
	 * @param bulletBound
	 * @return
	 */
	@GetMapping("/createBullet")
	public String createBullet(Map<String, Object> paramMap, Integer bulletId) {
		Operator operator = getOperator();
		if (operator.newOrganizationType()) {
			return createBulletNewOrg(paramMap, bulletId, operator);
		} else {
			return createBulletOldOrg(paramMap, bulletId, operator);
		}
	}
	
	/**
	 * 创建一个公告，get请求获取创建/修改的页面（旧版组织架构）
	 * @param paramMap
	 * @param bulletId
	 * @param operator
	 * @return jsp页面地址
	 */
	private String createBulletOldOrg(Map<String, Object> paramMap, Integer bulletId, Operator operator) {
		String[] operArr = new String[]{"MANAGE_DEPT_BULLET", "MANAGE_COMP_BULLET", "MANAGE_PARTNER_BULLET"};
		Set<String> operSet = erpUserOpersMapper.getUsersOpersByUserId(operator.getCityId(), operator.getUserId(), operArr);
		
		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (getOperator().getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}
		
		// 本店的发布权都没有直接不让进页面了，非加盟商拥有了加盟商的公告管理权也不进入页面了
		if ((!operSet.contains("MANAGE_DEPT_BULLET")) || ((flagList.contains(Byte.valueOf("1")) || flagList.contains(Byte.valueOf("3"))) && operSet.contains("MANAGE_PARTNER_BULLET"))) {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		if(bulletId != null && bulletId > 0) {
			AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
			// 判断帖子是否被删除 如果被删除则返回错误
			if (adminBulletDto.getIsDelete()) {
				throw new ConfirmException("该帖子已经被删除，请刷新列表");
			}
			// 不是本公司数据
			if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
				throw new ConfirmException("该帖子不存在，请刷新列表");
			}
			Byte bulletBound = adminBulletDto.getBulletBound();
			boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
			boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
			// 是否可以编辑
			boolean canEditBulletin = this.canEditBulletin(operator.getCityId(), operator.getUserId(), bulletBound.byteValue(), isSelfComp, isSelfArchive, operator.getPartnerId());
			// 没有编辑权限
			if (!canEditBulletin) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			paramMap.put("bulletId", bulletId);
			paramMap.put("bulletinInfo", adminBulletDto);
			// 获取公告附件
			if (bulletBound == 0 || bulletBound == 1 || bulletBound == 7 || bulletBound == 8 || bulletBound == 10) {
				List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
				for (AdminBulletinPsDto adminBulletinPs : bulletinPsPOs) {
					Long fileSize = adminBulletinPs.getFileSize();
					if(fileSize != null && fileSize > 0) {
						String convertFileSize = FileUtil.convertFileSize(fileSize);
						adminBulletinPs.setFileSizeStr(convertFileSize);
					}
					adminBulletinPs.setFileType(this.getFileTypeIcon(adminBulletinPs.getFileName()));
				}
				paramMap.put("bulletinPsPOs", bulletinPsPOs);
			}
		}
		paramMap.put("partnerFlag", Integer.valueOf(1).equals(getOperator().openPartner()) && flagList.contains(Byte.valueOf("2")) && operSet.contains("MANAGE_PARTNER_BULLET") ? 1 : 0);
		paramMap.put("compFlag", operSet.contains("MANAGE_COMP_BULLET") ? 1 : 0);
		paramMap.put("clientKey", operator.getClientKey());
		return "bulletinNew/createBullet";
	}
	
	/**
	 * 创建一个公告，get请求获取创建/修改的页面（无限组织架构）
	 * @param paramMap
	 * @param bulletId
	 * @param operator
	 * @return jsp页面地址
	 */
	private String createBulletNewOrg(Map<String, Object> paramMap, Integer bulletId, Operator operator) {
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
		// story#11307 先判断当前公司是否说开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果说加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(operator.openPartner())) {
			if (Integer.valueOf(0).equals(operator.getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (operator.getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));
			}
		}
		
		// 无限组织架构下，非加盟商直接判断为空，加盟商判断包含2并且权限上的DEFINITION_ID=-1
		if (null == erpUserOpers) {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		
		// 查询出我能发布的组织层级信息	换设计了，不按照层级了，只有全公司与本组织了。
		/*List<ErpFunOrganizationDefinition> canPubDefinitionList = erpFunOrganizationDefinitionMapper.getCanPubDefinitionList(operator.getCityId(), operator.getCompId(), erpUserOpers.getOrganizationDefinitionId());
		paramMap.put("canPubDefinitionList", canPubDefinitionList);*/
		
		if (null != bulletId && bulletId > 0) {// 详情中修改本公告
			AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
			// 判断帖子是否被删除 如果被删除则返回错误
			if (adminBulletDto.getIsDelete()) {
				throw new ConfirmException("该帖子已经被删除，请刷新列表");
			}
			// 不是本公司数据
			if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
				throw new ConfirmException("该帖子不存在，请刷新列表");
			}
			// 是否可以编辑
			boolean canEditBulletin = this.canEditBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			// 没有编辑权限
			if (!canEditBulletin) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			paramMap.put("bulletId", bulletId);
			paramMap.put("bulletinInfo", adminBulletDto);
			// 获取公告附件
			List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
			for (AdminBulletinPsDto adminBulletinPs : bulletinPsPOs) {
				Long fileSize = adminBulletinPs.getFileSize();
				if(fileSize != null && fileSize > 0) {
					String convertFileSize = FileUtil.convertFileSize(fileSize);
					adminBulletinPs.setFileSizeStr(convertFileSize);
				}
				adminBulletinPs.setFileType(this.getFileTypeIcon(adminBulletinPs.getFileName()));
			}
			paramMap.put("bulletinPsPOs", bulletinPsPOs);
		}
		paramMap.put("partnerFlag", (Integer.valueOf(1).equals(operator.openPartner()) && flagList.contains(Byte.valueOf("2")) 
				&& Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId())) ? 1 : 0);
		paramMap.put("compFlag", (Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId())) 
				|| (Integer.valueOf(1).equals(operator.openPartner()) && flagList.contains(Byte.valueOf("2")) 
						&& Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId())) ? 1 : 0);
		paramMap.put("orgFlag", Integer.valueOf(1).equals(erpUserOpers.getOrganizationDefinitionId()) ? 1 : 0);
		paramMap.put("clientKey", operator.getClientKey());
		return "bulletinNew/createBulletNewOrg";
	}
	
	/**
	 * 上传附件
	 * @author 张宏利
	 * @since 2018年2月9日
	 * @param paramMap
	 * @param bulletId
	 * @param bulletBound
	 * @return
	 */
	@ApiOperation("上传附件")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = FileUploadResultVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping(value="/uploaderFile")
	public ResponseJson uploaderFile(MultipartFile file, HttpServletRequest request, @RequestParam(name = "watermarkFlag",required = false)String watermarkFlag) throws Exception{
		if (!"1".equals(watermarkFlag)) {
			watermarkFlag = "0";
		}
		FileUploadResult returnMap = FileUtil.fileUpload(AppConfig.getFileWebUrl(), file,watermarkFlag);
		returnMap.setDomain(AppConfig.getPicDomainUrl());
		List<FileInfo> fileList = returnMap.getFileList();
		if (fileList != null && fileList.size() > 0) {
			FileInfo fileInfo = fileList.get(0);
			fileInfo.setFileType(this.getFileTypeIcon(fileInfo.getFileOldName()));
		}
		return ErpResponseJson.ok(returnMap);
	}

	/**
	 * 获取帖子详情
	 * @author 张宏利
	 * @since 2018年2月9日
	 * @param paramMap
	 * @param bulletId
	 * @param bulletBound
	 * @return
	 */
	@RequestMapping("/bulletinInfo")
	public String bulletinInfo(Map<String, Object> paramMap, Integer bulletId,HttpServletRequest request) {
		Operator operator = getOperator();
		paramMap = this.getBulletin(paramMap,bulletId,operator,0);
		
//		if(null != adminBulletDto.getBulletType() && adminBulletDto.getBulletType().intValue() > 4) {
//			adminBulletDto.setBulletContent(URLDecoder.decode(adminBulletDto.getBulletContent()));
//		}
		request.setAttribute("isSwitchCompLogin", operator.isSwitchCompLogin()?1:0);
		return "bulletinNew/bulletinInfo";
	}

	/**
	 * 获取帖子详情
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "获取帖子详情",httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BulletinInfoVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getBulletinInfo")
	public ResponseJson getBulletinInfo(@Valid @RequestBody BulletinInfoParam param) {
		Operator operator = getOperator();
		Integer bulletId = param.getBulletId();
		BulletinInfoVo bulletinInfoVo = new BulletinInfoVo();
		bulletinInfoVo = this.getBulletDetail(bulletinInfoVo,bulletId,operator,1);
		return ErpResponseJson.ok(bulletinInfoVo);
	}

	/**
	 * 获取回复列表
	 * 
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @param bulletId
	 * @param pageParam
	 * @return
	 */
	public PageInfo<AdminBulletReplyDto> getBulletinReplyList(Integer archiveId, Integer bulletId, PageParam pageParam) {
		List<AdminBulletReplyDto> bulletReplyList = adminBulletReplyMapper.getBulletReplyList(bulletId);
		PageInfo<AdminBulletReplyDto> pageInfo = new PageInfo<AdminBulletReplyDto>(bulletReplyList);
		if(pageParam.getPageNum() == 1 && bulletReplyList.size() == pageParam.getPageSize()) {
			AdminBulletReplyExample example = new AdminBulletReplyExample();
			example.createCriteria().andBulletIdEqualTo(bulletId);
			int count = adminBulletReplyMapper.countByExample(example);
			pageInfo.setTotal(count);
		}
		if (bulletReplyList == null || bulletReplyList.isEmpty()) {
			return pageInfo;
		}
		Map<Integer, List<AdminBulletReplyDto>> allRelateMap = bulletReplyList.stream().filter(val -> (val.getMainRelateId() != null && val.getMainRelateId() > 0))
			.collect(Collectors.groupingBy(AdminBulletReplyDto::getMainRelateId));
		
		// 第一层回复列表的map
		Map<Integer, AdminBulletReplyDto> allReplyMap = bulletReplyList.stream().collect(Collectors.toMap(key -> key.getReplyId(), val -> val));
		
		Set<Integer> archiveIds = bulletReplyList.stream().collect(Collectors.mapping(AdminBulletReplyDto::getArchiveId, Collectors.toSet()));
		Map<Integer, AdminFunArchive> funArchiveMap = adminFunArchiveMapper.getModelDataMap(archiveIds);
//		Map<Integer, AdminFunUsersCountDto> userScores = adminFunUsersCountMapper.getUserScorCountMapKey(archiveIds);
		List<AdminBulletReplyDto> resultReplyList = new LinkedList<>();
		// 获取自己是否赞过
		List<AdminBulletReplyZan> selfZanList = adminBulletReplyZanMapper.getSelfZanList(archiveId, bulletId, allReplyMap.keySet());
		Set<Integer> selfZanReplyIdSet = selfZanList.stream().collect(Collectors.mapping(AdminBulletReplyZan::getReplyId, Collectors.toSet()));
		// 设置用户积分等信息
		for (int index = 0; index < bulletReplyList.size(); index++) {
			AdminBulletReplyDto bulletReplyPO = bulletReplyList.get(index);
			// 自己是否赞过
			if (selfZanReplyIdSet.contains(bulletReplyPO.getReplyId())){
				bulletReplyPO.setSelfZan(1);
			}
			// 回复的谁的发言
			if (bulletReplyPO.getRelateId() != null && bulletReplyPO.getRelateId() > 0) {
				AdminBulletReplyDto bulletReplyDto = allReplyMap.get(bulletReplyPO.getRelateId());
				if(bulletReplyDto != null) {
					AdminFunArchive funArchive = funArchiveMap.get(bulletReplyDto.getArchiveId());
					if (funArchive != null) {
						bulletReplyPO.setRelateUserName(funArchive.getUserName());
					}
				}
			} else {
				resultReplyList.add(bulletReplyPO);
			}
			// 是不是自己回复的，1=是自己
			boolean isSelf = archiveId.equals(bulletReplyPO.getArchiveId());
			bulletReplyPO.setIsSelfReply(isSelf ? 1 : 0);
			// 把回复的回复插进去
			List<AdminBulletReplyDto> listTmp = allRelateMap.get(bulletReplyPO.getReplyId());
			if (listTmp != null && listTmp.size() > 0) {
				// 按时间倒序排
				listTmp = listTmp.stream().sorted((val1, val2) -> val2.getReplyId().compareTo(val1.getReplyId()))
						.collect(Collectors.toList());
				listTmp.get(listTmp.size() - 1).setLastSubRelate(1);
				resultReplyList.addAll(listTmp);
			}
			AdminFunArchive funArchive = funArchiveMap.get(bulletReplyPO.getArchiveId());
			if (funArchive == null) {
				continue;
			}
			bulletReplyPO.setBbsName(funArchive.getNickName());
			String userPhoto = CommonUtil.getBbsPhoto(funArchive.getUserPhoto());
			
			bulletReplyPO.setRealPhoto(userPhoto);
			bulletReplyPO.setUserPhoto(StringUtil.isNotBlank(userPhoto) ? userPhoto : AppConfig.getErpWebUrl() + "statics/common/image/bulletinHeadPortraits.png");
			// 用户认证情况
			bulletReplyPO.setUserRight(funArchive.getUserRight());
			Integer superUser = OperatorSessionUtil.isSuperUser(funArchive.getSuperUser(), funArchive.getSuperEnd());
			bulletReplyPO.setSuperUser(superUser);
			// 获取积分，现在没展示积分了，先不查出来
//			AdminFunUsersCountDto userScoreDo = userScores.get(bulletReplyPO.getArchiveId());
//			int userScore = (userScoreDo != null && userScoreDo.getTotalScore() != null) ? userScoreDo.getTotalScore() : 0;
//			bulletReplyPO.setUserScore(userScore);
		}
		pageInfo.setList(resultReplyList);
		return pageInfo;
	}
	
	/**
	 * 创建或修改公告信息
	 * @author 张宏利
	 * @since 2018年2月9日
	 * @param isvote 是否是投票贴
	 * @param showPhone 是否显示电话
	 * @param bounds 发布范围，多个逗号分隔，0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报
	 * @param bulletinPs 附件信息，长这样：HfClear.exe,64513524,oss/185ef.exe;HfClear.exe,64513524,oss/185ef.exe;
	 * @param bulletType 帖子类型 0=默认 1=签单喜报 2=内部公示 3=公告通知
	 * @param bulletSubject 标题
	 * @param bulletContent 内容
	 * @return
	 */
	@ApiOperation("创建或修改公告信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = CreateBulletVo.class, message = "成功")
	})
	@ResponseBody 
	@PostMapping(value="/createBullet")
	public ResponseJson createBullet(CreateBulletParam param) {
		/**
		 * 当加盟商模式时。总部与直营权限中存在加盟商公告管理权时代表没有公告管理权
		 * 加盟商模式下的总部、加盟商、直营，都只查询自己对应类型的公告列表。
		 */
		if (getOperator().newOrganizationType()) {
			return createBulletNewOrg(param, getOperator());
		} else {
			return createBulletOldOrg(param, getOperator());
		}
	}
	
	/**
	 * 创建或修改公告信息，post请求创建或修改公告信息（旧版组织架构）
	 * @param param
	 * @param operator
	 * @return
	 */
	private ErpResponseJson createBulletOldOrg(CreateBulletParam param, Operator operator) {
		Integer bounds = 0;
		String bulletSubject = param.getBulletSubject();
		boolean isPartner = Integer.valueOf(1).equals(operator.openPartner());
		String[] operArr = new String[]{"MANAGE_DEPT_BULLET", "MANAGE_COMP_BULLET", "MANAGE_PARTNER_BULLET"};
		Set<String> operSet = erpUserOpersMapper.getUsersOpersByUserId(operator.getCityId(), operator.getUserId(), operArr);
		
		if (Integer.valueOf(1).equals(operator.openPartner()) && null != operator.getPartnerId() && operator.getPartnerId() > 0) {// 加盟商
			if (bounds == 0) {
				if (!operSet.contains("MANAGE_DEPT_BULLET")) {
					throw new ConfirmException("对不起，您没有发布本店公告权限！");
				}
			} else if (bounds == 1) {
				if (!operSet.contains("MANAGE_COMP_BULLET")) {
					throw new ConfirmException("对不起，您没有发布本公司公告权限！");
				}
			} else if (bounds == 10) {
				if (!operSet.contains("MANAGE_PARTNER_BULLET")) {
					throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
				}
			} else {
				throw new ConfirmException("对不起，您没有发布公告权限！");
			}
		} else if (bounds == 0) {
			if (!operSet.contains("MANAGE_DEPT_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本店公告权限！");
			} else if (operSet.contains("MANAGE_PARTNER_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本店公告权限！");
			}
		} else if (bounds == 1) {
			if (!operSet.contains("MANAGE_COMP_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本公司公告权限！");
			} else if (operSet.contains("MANAGE_PARTNER_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本公司公告权限！");
			}
		} else if (bounds == 10 ) {
			throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
		} else {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		if(StringUtil.isBlank(bulletSubject) || bulletSubject.length() < 5){
			throw new ConfirmException("标题不能少于5个字！");
		}
		AdminBullet adminBullet=this.addBullet(operator, param);
		sendMsgToApp(adminBullet,isPartner);
		return ErpResponseJson.ok(adminBullet.getBulletId());
	}
	
	/**
	 * 创建或修改公告信息，post请求创建或修改公告信息（无限组织架构）
	 * @param param
	 * @param operator
	 * @return
	 */
	private ErpResponseJson createBulletNewOrg(CreateBulletParam param, Operator operator) {
		String bulletSubject = param.getBulletSubject();
		Integer bounds = param.getBounds();
		
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
		// 权限判断
		if (null != erpUserOpers) {
			if (Integer.valueOf(1).equals(operator.openPartner()) && null != operator.getPartnerId() && operator.getPartnerId() > 0) {// 加盟商
				if (Integer.valueOf(-1).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
					}
				} else if (Integer.valueOf(0).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId()) && !Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布公司公告权限！");
					}
				} else if (Integer.valueOf(1).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId()) 
							&& !Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId()) 
							&& !Integer.valueOf(1).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布组织公告的权限！");
					}
				}
			} else if (Integer.valueOf(0).equals(bounds)) {
				if (!Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId())) {
					throw new ConfirmException("对不起，您没有发布公司公告权限！");
				}
			} else if (Integer.valueOf(1).equals(bounds)) {
				if (!Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId()) 
						&& !Integer.valueOf(1).equals(erpUserOpers.getOrganizationDefinitionId())) {
					throw new ConfirmException("对不起，您没有发布组织公告的权限！");
				}
			}
		} else {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		if(StringUtil.isBlank(bulletSubject) || bulletSubject.length() < 5){
			throw new ConfirmException("标题不能少于5个字！");
		}
		AdminBullet adminBullet=this.addBulletNewOrg(operator, param, erpUserOpers);
		sendMsgToAppNewOrg(adminBullet, operator);
		return ErpResponseJson.ok(adminBullet.getBulletId());
	}

	/**
	 * app端发帖或修改帖子
	 * @auther: 胡坤
	 * @date: 2018/9/25
	 */
	@ApiOperation("app端发帖或修改帖子")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = CreateBulletVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping(value="/app/createBullet")
	public ResponseJson createBulletApp(@RequestBody CreateBulletParam param) {
		if (getOperator().newOrganizationType()) {
			return createBulletAppNewOrg(param);
		} else {
			return createBulletAppOldOrg(param);
		}
	}
	
	/**
	 * app端发帖或修改帖子（旧版组织）
	 * @auther: 胡坤
	 * @date: 2018/9/25
	 */
	private ResponseJson createBulletAppOldOrg(CreateBulletParam param) {
		Integer bounds = 0;
		String bulletSubject = param.getBulletSubject();
		Operator operator = getOperator();
		boolean isPartner = Integer.valueOf(1).equals(operator.openPartner());
		String[] operArr = new String[]{"MANAGE_DEPT_BULLET", "MANAGE_COMP_BULLET", "MANAGE_PARTNER_BULLET"};
		Set<String> operSet = erpUserOpersMapper.getUsersOpersByUserId(operator.getCityId(), operator.getUserId(), operArr);
		if (Integer.valueOf(1).equals(operator.openPartner()) && null != operator.getPartnerId() && operator.getPartnerId() > 0) {// 加盟商
			if (bounds == 0) {
				if (!operSet.contains("MANAGE_DEPT_BULLET")) {
					throw new ConfirmException("对不起，您没有发布本店公告权限！");
				}
			} else if (bounds == 1) {
				if (!operSet.contains("MANAGE_COMP_BULLET")) {
					throw new ConfirmException("对不起，您没有发布本公司公告权限！");
				}
			} else if (bounds == 10) {
				if (!operSet.contains("MANAGE_PARTNER_BULLET")) {
					throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
				}
			} else {
				throw new ConfirmException("对不起，您没有发布公告权限！");
			}
		} else if (bounds == 0) {
			if (!operSet.contains("MANAGE_DEPT_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本店公告权限！");
			} else if (operSet.contains("MANAGE_PARTNER_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本公司公告权限！");
			}
		} else if (bounds == 1) {
			if (!operSet.contains("MANAGE_COMP_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本公司公告权限！");
			} else if (operSet.contains("MANAGE_PARTNER_BULLET")) {
				throw new ConfirmException("对不起，您没有发布本公司公告权限！");
			}
		} else if (bounds == 10 ) {
			throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
		}
		else {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		if(StringUtil.isBlank(bulletSubject) || bulletSubject.length() < 5){
			throw new ConfirmException("标题不能少于5个字！");
		}
		AdminBullet adminBullet=this.addBullet(operator, param);
		sendMsgToApp(adminBullet,isPartner);
		return ErpResponseJson.ok(adminBullet.getBulletId());
	}
	
	/**
	 * app端发帖或修改帖子（无限组织）
	 * @auther: chenfeng
	 * @date: 2019/12/07
	 */
	private ResponseJson createBulletAppNewOrg(CreateBulletParam param) {
		Integer bounds = param.getBounds();
		String bulletSubject = param.getBulletSubject();
		Operator operator = getOperator();
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
		// 权限判断
		if (null != erpUserOpers) {
			if (Integer.valueOf(1).equals(operator.openPartner()) && null != operator.getPartnerId() && operator.getPartnerId() > 0) {// 加盟商
				if (Integer.valueOf(-1).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布加盟商公告权限！");
					}
				} else if (Integer.valueOf(0).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId()) 
							&& !Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布本公司公告权限！");
					}
				} else if (Integer.valueOf(1).equals(bounds)) {
					if (!Integer.valueOf(-1).equals(erpUserOpers.getOrganizationDefinitionId()) 
							&& !Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId()) 
							&& !Integer.valueOf(1).equals(erpUserOpers.getOrganizationDefinitionId())) {
						throw new ConfirmException("对不起，您没有发布组织公告的权限！");
					}
				}
			} else if (Integer.valueOf(0).equals(bounds)) {
				if (!Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId())) {
					throw new ConfirmException("对不起，您没有发布本公司公告权限！");
				}
			} else if (Integer.valueOf(1).equals(bounds)) {
				if (!Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId()) 
					&& !Integer.valueOf(1).equals(erpUserOpers.getOrganizationDefinitionId())) {
					throw new ConfirmException("对不起，您没有发布组织公告的权限！");
				}
			}
		} else {
			throw new ConfirmException("对不起，您没有发布公告权限！");
		}
		if(StringUtil.isBlank(bulletSubject) || bulletSubject.length() < 5){
			throw new ConfirmException("标题不能少于5个字！");
		}
		AdminBullet adminBullet=this.addBulletNewOrg(operator, param, erpUserOpers);
		sendMsgToAppNewOrg(adminBullet, operator);
		return ErpResponseJson.ok(adminBullet.getBulletId());
	}
	
	/**
	  * @title  app推送
	  * @author lcb  
	 * @param isPartner 
	  * @date   2018/9/30 15:57
	  * @desc 
	  **/
	private void sendMsgToApp(AdminBullet adminBullet, boolean isPartner) {
		try {
			// 范围， 0 本店信息 1=本公司
			Byte bulletBound = adminBullet.getBulletBound();
			if(null != bulletBound) {
				Integer deptId = adminBullet.getDeptId();
				Integer partnerId = adminBullet.getPartnerId();
				AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(deptId);
				Set<Integer> archiveIdSet = new HashSet<>();
				if(0 == bulletBound) {
					archiveIdSet= erpFunUsersMapper.getArchiveIdListByDeptNo(adminFunDepts.getCompNo(), adminFunDepts.getDeptNo(),isPartner && Byte.valueOf("10").equals(bulletBound),partnerId );
				}else {
					archiveIdSet = erpFunUsersMapper.getArchiveIdListByDeptNo(adminFunDepts.getCompNo(), null, isPartner && Byte.valueOf("10").equals(bulletBound),partnerId);
				}
				for (Integer archiveId : archiveIdSet) {
					try{
						asyncTask.sendMsg(adminBullet.getCityId(), archiveId, adminBullet.getBulletId(), adminBullet.getBulletSubject(), adminBullet.getBulletContent());
					}catch (Exception e) {

					}
				}
			}
		} catch (Exception e) {

		}
	}
	
	/**
	 * app推送（无限组织）
	 * @author lcb
	 * @param isPartner 
	 * @date   2018/9/30 15:57
	 **/
	private void sendMsgToAppNewOrg(AdminBullet adminBullet, Operator operator) {
		try {
			Integer bulletBound = adminBullet.getOrganizationDefinitionId();// 0=公司1=本组织
			boolean isPartner = Integer.valueOf(1).equals(operator.openPartner());
			if (null != bulletBound) {
				Integer partnerId = adminBullet.getPartnerId();
				String pubOrganizationId = null;
				if (bulletBound > 0) {// 需要找到发布的对应的组织信息id，找出该组织下的所有人
					pubOrganizationId = null != adminBullet.getOrganizationId() ? adminBullet.getOrganizationId().toString() : null;
				}
				Set<Integer> archiveIdSet = erpFunUsersMapper.getArchiveIdSetByCondition(operator.getCityId(), operator.getCompId(), pubOrganizationId, isPartner && Integer.valueOf(-1).equals(bulletBound), partnerId, bulletBound);
				for (Integer archiveId : archiveIdSet) {
					try {
						asyncTask.sendMsg(adminBullet.getCityId(), archiveId, adminBullet.getBulletId(), adminBullet.getBulletSubject(), adminBullet.getBulletContent());
					} catch (Exception e) {

					}
				}
			}
		} catch (Exception e) {

		}
	}

	/**
	 * 获取帖子列表
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @param BulletinListParam 范围
	 * @return
	 */
	@ApiOperation("获取帖子列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AdminBulletVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getBulletinList")
	public ResponseJson getBulletinList(@RequestBody BulletinListParam param) {
		if (getOperator().newOrganizationType()) {
			return getBulletinListNewOrg(param);
		} else {
			return getBulletinListOldOrg(param);
		}
	}
	
	/**
	 * 获取帖子列表（旧版组织）
	 * @return
	 */
	private ResponseJson getBulletinListOldOrg(BulletinListParam param) {
		Operator operator = getOperator();
		String keyWord = param.getKeyWord();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getAdminCompId();
		Integer isViewStatus = param.getIsViewStatus()!=null?param.getIsViewStatus():0;
		if (StringUtils.isNotBlank(keyWord)) {
			param.setKeyWord("%" + keyWord + "%");
		}
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		param.setPartnerId(operator.getPartnerId());
		param.setOpenPartner(operator.openPartner());
		
		// 分页查询
		Integer countBulletList = adminBulletMapper.getBulletListCount(param);
		if(countBulletList <= 0) {
			return ErpResponseJson.ok();
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<AdminBulletDto> bulletList = adminBulletMapper.getBulletList(param);
		if (isViewStatus == 1 && bulletList.size() > 0){
//				Set<Integer> deptsSet = bulletList.stream().collect(Collectors.mapping(AdminBulletDto::getDeptId,Collectors.toSet()));
				List<Integer> bulletIds = bulletList.stream().collect(Collectors.mapping(AdminBulletDto::getBulletId,Collectors.toList()));
				//统计帖子已读人数
				List<AdminBulletViewLogDto> adminBulletViewLogDtos = adminBulletViewLogMapper.getViewCount(bulletIds);
				Map<Integer,Integer> bulletViewLogMap = adminBulletViewLogDtos.stream().collect(Collectors.toMap(AdminBulletViewLogDto::getBulletId,AdminBulletViewLogDto::getViewCount));
				//统计门店人数
				List<AdminFunDepts> adminFunDeptsList = adminFunDeptsMapper.getFunDeptsByDeptsId(compId);
				Map<Integer,Integer> deptsMap = adminFunDeptsList.stream().collect(Collectors.toMap(AdminFunDepts::getDeptId,AdminFunDepts::getIncumbencyNumber));
				//统计公司人数
				Integer allCompUserCount = 0;
				List<Integer> partnerIdList = bulletList.stream().filter(a->Byte.valueOf("10").equals(a.getBulletBound())).collect(Collectors.mapping(AdminBulletDto::getPartnerId, Collectors.toList()));
				List<CompPartnerCountVO> parnterCountList = null;
				Map<Integer,Integer> partnerUserCountMap = new HashMap<>();
				
				if (partnerIdList!=null && !partnerIdList.isEmpty()) {
					parnterCountList  = erpFunUsersMapper.getCompPartnerCount(cityId,operator.getCompId(),partnerIdList);
					parnterCountList.forEach(partner->{
						partnerUserCountMap.put(partner.getPartnerId(), partner.getUserCount());
					});
				}
				for (AdminFunDepts adminFunDepts:adminFunDeptsList){
					Integer incumbencyNumber = adminFunDepts.getIncumbencyNumber();
					if (incumbencyNumber!=null){
						allCompUserCount += incumbencyNumber;
					}
				}
				for (AdminBulletDto adminBulletDto:bulletList){
					Integer readViewCount = bulletViewLogMap.get(adminBulletDto.getBulletId())!=null?bulletViewLogMap.get(adminBulletDto.getBulletId()):0;//已读
					adminBulletDto.setReadViewCount(readViewCount);
					// 全公司
					if(1 == adminBulletDto.getBulletBound().intValue()) {
						Integer unReadViewCount = allCompUserCount > readViewCount ? (allCompUserCount-readViewCount) : 0;
						adminBulletDto.setUnReadViewCount(unReadViewCount);
					} else if(0 == adminBulletDto.getBulletBound().intValue()){
						// 本店
						Integer deptCount = deptsMap.get(adminBulletDto.getDeptId());
						deptCount = null != deptCount ? deptCount: 0;
						Integer unReadViewCount = deptCount > readViewCount ? (deptCount - readViewCount) : 0;
						adminBulletDto.setUnReadViewCount(unReadViewCount);
					} else if(10 == adminBulletDto.getBulletBound().intValue()) {
						Integer partnerCount = partnerUserCountMap.get(adminBulletDto.getPartnerId());
						partnerCount = null != partnerCount ? partnerCount: 0;
						Integer unReadViewCount = partnerCount > readViewCount ? (partnerCount - readViewCount) : 0;
						adminBulletDto.setUnReadViewCount(unReadViewCount);
					}
				}
		}
		Page<AdminBulletDto> pageList = (Page)bulletList;
		pageList.setTotal(countBulletList);
		//已读未读统计
		PageInfo<AdminBulletDto> pageInfo = new PageInfo<>(pageList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取帖子列表（无限组织）
	 * @return
	 */
	private ResponseJson getBulletinListNewOrg(BulletinListParam param) {
		Operator operator = getOperator();
		String keyWord = param.getKeyWord();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getAdminCompId();
		if (operator.isSwitchCompLogin()) {
			ErpFunComp funComp = erpFunCompMapper.selectByCompId(cityId, operator.getCompId());
			AdminFunComp adminComp = adminFunCompMapper.selectByCompNo(funComp.getCompNo());
			compId = adminComp.getCompId();
		}
		Integer isViewStatus = param.getIsViewStatus()!=null?param.getIsViewStatus():0;
		if (StringUtils.isNotBlank(keyWord)) {
			param.setKeyWord("%" + keyWord + "%");
		}
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		param.setPartnerId(operator.getPartnerId());
		param.setOpenPartner(operator.openPartner());
		param.setOrganizationId(operator.getOrganizationId());
		param.setOrganizationPath(operator.getOrganizationPath());
		
		// 分页查询
		Integer countBulletList = adminBulletMapper.getBulletListCountNewOrg(param);
		if(countBulletList <= 0) {
			return ErpResponseJson.ok();
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<AdminBulletDto> bulletList = adminBulletMapper.getBulletListNewOrg(param);
		if (isViewStatus == 1 && bulletList.size() > 0){
//				Set<Integer> deptsSet = bulletList.stream().collect(Collectors.mapping(AdminBulletDto::getDeptId,Collectors.toSet()));
			List<Integer> bulletIds = bulletList.stream().collect(Collectors.mapping(AdminBulletDto::getBulletId,Collectors.toList()));
			//统计帖子已读人数
			List<AdminBulletViewLogDto> adminBulletViewLogDtos = adminBulletViewLogMapper.getViewCount(bulletIds);
			Map<Integer,Integer> bulletViewLogMap = adminBulletViewLogDtos.stream().collect(Collectors.toMap(AdminBulletViewLogDto::getBulletId, AdminBulletViewLogDto::getViewCount));
			//统计组织人数
			List<OrganizationVO> organizationList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, null);
			Map<Integer, Integer> organizationMap = organizationList.stream().collect(Collectors.toMap(OrganizationVO :: getOrganizationId, OrganizationVO :: getOrganizationUserNum));
			
			//统计公司人数
			Integer allCompUserCount = 0;
			List<Integer> partnerIdList = bulletList.stream().filter(a->Integer.valueOf("-1").equals(a.getOrganizationDefinitionId())).collect(Collectors.mapping(AdminBulletDto::getPartnerId, Collectors.toList()));
			List<CompPartnerCountVO> parnterCountList = null;
			Map<Integer,Integer> partnerUserCountMap = new HashMap<>();
			
			if (partnerIdList!=null && !partnerIdList.isEmpty()) {
				parnterCountList  = erpFunUsersMapper.getCompPartnerCount(cityId, operator.getCompId(), partnerIdList);
				parnterCountList.forEach(partner->{
					partnerUserCountMap.put(partner.getPartnerId(), partner.getUserCount());
				});
			}
			for (OrganizationVO organization : organizationList) {
				Integer organizationUserNum = organization.getOrganizationUserNum();
				if (organizationUserNum!=null){
					allCompUserCount += organizationUserNum;
				}
			}
			
			String[] orgIds = operator.getOrganizationPath().split(":");
			List<Integer> orgIdList = new ArrayList<>();
			for (String orgIdStr:orgIds) {
				if (StringUtils.isNotBlank(orgIdStr) && !":".equals(orgIdStr)) {
					orgIdList.add(StringUtil.parseInteger(orgIdStr,0));
				}
			}
			ErpFunOrganizationExample example = new ErpFunOrganizationExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo(Byte.valueOf("0"));
			List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectByExample(example);// 查询所有的组织
			
			// 公司全部组织的map
			Map<Integer, ErpFunOrganization> organizationMapTemp = orgList.stream().filter(org->org.getOrganizationDefinitionId() != null).collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, val -> val));
			
			Map<Integer, Integer> orgAndCountMap = new HashMap<Integer, Integer>();// 公告id为key，组织内人数为value
			for (AdminBulletDto bullet : bulletList) {
				Integer bulletOrganizationId = bullet.getOrganizationId();
				Integer organizationDefinitionId = bullet.getOrganizationDefinitionId();
				
				if (null != bulletOrganizationId) {
					int organizationAllUserNum = 0;
					for (ErpFunOrganization erpFunOrganization : orgList) {
						if (erpFunOrganization.getOrganizationPath().indexOf(bulletOrganizationId.toString()) != -1) {
							organizationAllUserNum += erpFunOrganization.getOrganizationUserNum();
						}
					}
					orgAndCountMap.put(bullet.getBulletId(), organizationAllUserNum);
				}
			}
			
			for (AdminBulletDto adminBulletDto : bulletList){
				Integer readViewCount = bulletViewLogMap.get(adminBulletDto.getBulletId())!=null?bulletViewLogMap.get(adminBulletDto.getBulletId()):0;//已读
				adminBulletDto.setReadViewCount(readViewCount);
				if (Integer.valueOf(-1).equals(adminBulletDto.getOrganizationDefinitionId())) {
					Integer partnerCount = partnerUserCountMap.get(adminBulletDto.getPartnerId());
					partnerCount = null != partnerCount ? partnerCount: 0;
					Integer unReadViewCount = partnerCount > readViewCount ? (partnerCount - readViewCount) : 0;
					adminBulletDto.setUnReadViewCount(unReadViewCount);
				} else if (Integer.valueOf(0).equals(adminBulletDto.getOrganizationDefinitionId())) {
					Integer unReadViewCount = allCompUserCount > readViewCount ? (allCompUserCount-readViewCount) : 0;
					adminBulletDto.setUnReadViewCount(unReadViewCount);
				} else if (Integer.valueOf(1).equals(adminBulletDto.getOrganizationDefinitionId())) {
					Integer orgCount = orgAndCountMap.get(adminBulletDto.getBulletId());
					orgCount = null != orgCount ? orgCount : 0;
					Integer unReadViewCount = orgCount > readViewCount ? (orgCount - readViewCount) : 0;
					adminBulletDto.setUnReadViewCount(unReadViewCount);
				}
			}
		}
		Page<AdminBulletDto> pageList = (Page)bulletList;
		pageList.setTotal(countBulletList);
		//已读未读统计
		PageInfo<AdminBulletDto> pageInfo = new PageInfo<>(pageList);
		return ErpResponseJson.ok(pageInfo);
	}

	/**
	 * APP获取帖子列表
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @param bound 范围
	 * @param keyWord 关键字
	 * @return
	 */
	@ApiOperation("获取帖子列表")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AdminBulletVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getBulletinListForApp")
	public ResponseJson getBulletinListForApp(@RequestBody BulletinListParam param) {
		if (getOperator().newOrganizationType()) {
			return getBulletinListForAppNewOrg(param);
		} else {
			return getBulletinListForAppOldOrg(param);
		}
	}
	
	/**
	 * APP获取帖子列表（旧版组织架构）
	 * @return
	 */
	private ErpResponseJson getBulletinListForAppOldOrg(BulletinListParam param) {
		Operator operator = getOperator();
		String keyWord = param.getKeyWord();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getAdminCompId();

		if (StringUtils.isNotBlank(keyWord)) {
			param.setKeyWord("%" + keyWord + "%");
		}
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		param.setPartnerId(operator.getPartnerId());// story#11306 加盟模式-加盟定制开启后默认可自行管理的模块
		param.setOpenPartner(operator.openPartner());
		// 分页查询
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<AdminBulletDto> bulletList = adminBulletMapper.getBulletList(param);

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("resList", bulletList);
		return ErpResponseJson.ok(resMap);
	}
	
	/**
	 * APP获取帖子列表（无限组织架构）
	 * @return
	 */
	private ErpResponseJson getBulletinListForAppNewOrg(BulletinListParam param) {
		Operator operator = getOperator();
		String keyWord = param.getKeyWord();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getAdminCompId();

		if (StringUtils.isNotBlank(keyWord)) {
			param.setKeyWord("%" + keyWord + "%");
		}
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setArchiveId(operator.getArchiveId());
		param.setDeptId(operator.getAdminDeptId());
		param.setErpUserDeptNo(operator.getDeptNo());
		param.setYouJiaDeptFlag(operator.youJiaDeptFlag() ? "1" : "0");
		param.setUserId(operator.getUserId());
		param.setPartnerId(operator.getPartnerId());// story#11306 加盟模式-加盟定制开启后默认可自行管理的模块
		param.setOpenPartner(operator.openPartner());
		param.setOrganizationId(operator.getOrganizationId());
		param.setOrganizationPath(operator.getOrganizationPath());
		// 分页查询
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), false);
		List<AdminBulletDto> bulletList = adminBulletMapper.getBulletListNewOrg(param);

		Map<String, Object> resMap = new HashMap<>();
		resMap.put("resList", bulletList);
		return ErpResponseJson.ok(resMap);
	}
	
	/**
	 * 删除帖子的回复
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "删除帖子的回复",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class,message = "success"))
	@ResponseBody
	@RequestMapping("/deleteBulletReply")
	public ResponseJson deleteBulletReply(Integer bulletId, Integer replyId) {
		Operator operator = getOperator();
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
		// 判断是否有权限删除
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		
		if (operator.newOrganizationType()) {
			ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
			if (null == erpUserOpers) {
				return ErpResponseJson.warn("你没有删除权限，不能删除回复");
			}
			if (!this.canDeleteBulletinNewOrg(operator, adminBulletDto, erpUserOpers)) {
				return ErpResponseJson.warn("你没有删除权限，不能删除回复");
			}
		} else {
			if (!this.canDeleteBulletin(operator.getCityId(), operator.getUserId(), adminBulletDto.getBulletBound().intValue(), 
					isSelfComp, isSelfArchive, operator.getPartnerId())) {
				return ErpResponseJson.warn("你没有删除权限，不能删除回复");
			}
		}
		adminBulletReplyMapper.deleteBulletReply(bulletId, replyId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 赞别人的回复
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param param
	 * @return
	 */
	@ApiOperation("赞别人的回复")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/addBulletReplyZan")
	public ResponseJson addBulletReplyZan(AddBulletReplyZanParam param) {
		Operator operator = getOperator();
		Integer bulletId = param.getBulletId();
		Integer replyId = param.getReplyId();
		
		// 赞过就不能再赞了
		AdminBulletReplyZanExample example = new AdminBulletReplyZanExample();
		example.createCriteria().andArchiveIdEqualTo(operator.getArchiveId())
			.andBulletIdEqualTo(bulletId).andReplyIdEqualTo(replyId);
		int bulletReplyZan = adminBulletReplyZanMapper.countByExample(example);
		if(bulletReplyZan > 0) {
			return ErpResponseJson.warn("你已经赞过了哦！");
		}
		// 增加赞和写赞的记录
		adminBulletReplyMapper.addZan(bulletId, replyId);
		adminBulletReplyZanMapper.insertReplyZan(operator.getCityId(), operator.getArchiveId(), bulletId, replyId);
		return ErpResponseJson.ok();
	}

	/**
	 * app赞别人的回复
	 * @param: 
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2018/9/25
	 */
	@ApiOperation("赞别人的回复")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/app/addBulletReplyZan")
	public ResponseJson addBulletReplyZanApp(@RequestBody AddBulletReplyZanParam param) {
		Operator operator = getOperator();
		Integer bulletId = param.getBulletId();
		Integer replyId = param.getReplyId();

		// 赞过就不能再赞了
		AdminBulletReplyZanExample example = new AdminBulletReplyZanExample();
		example.createCriteria().andArchiveIdEqualTo(operator.getArchiveId())
				.andBulletIdEqualTo(bulletId).andReplyIdEqualTo(replyId);
		int bulletReplyZan = adminBulletReplyZanMapper.countByExample(example);
		if(bulletReplyZan > 0) {
			return ErpResponseJson.warn("你已经赞过了哦！");
		}
		// 增加赞和写赞的记录
		adminBulletReplyMapper.addZan(bulletId, replyId);
		adminBulletReplyZanMapper.insertReplyZan(operator.getCityId(), operator.getArchiveId(), bulletId, replyId);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 置顶帖子
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "置顶帖子",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class,message = "success"))
	@ResponseBody
	@RequestMapping("/updateBulletStick")
	public ResponseJson updateBulletStick(Integer bulletId, Integer stick) {
		Operator operator = getOperator();
		
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
		Byte bulletBound = adminBulletDto.getBulletBound();
		// 当前帖子是否可以置顶
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		// 是否可以编辑
		if (operator.newOrganizationType()) {
			ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
			if (null == erpUserOpers) {
				return ErpResponseJson.warn("你没有权限置顶该帖子哦！");
			}
			boolean canEditBulletinNewOrg = this.canEditBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			// 没有编辑权限
			if (!canEditBulletinNewOrg) {
				return ErpResponseJson.warn("你没有权限置顶该帖子哦！");
			}
		} else {
			boolean canEditBulletin = this.canEditBulletin(operator.getCityId(), operator.getUserId(), bulletBound.byteValue(), isSelfComp, isSelfArchive, operator.getPartnerId());
			// 没有编辑权限
			if (!canEditBulletin) {
				return ErpResponseJson.warn("你没有权限置顶该帖子哦！");
			}
		}
		// 修改置顶状态
		AdminBullet record = new AdminBullet();
		record.setStick(stick == 1);
		record.setBulletId(bulletId);
		adminBulletMapper.updateByPrimaryKeySelective(record);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 删除帖子
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "删除帖子",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = Const.ResponseCode.SUCCESS,response = ErpResponseJson.class,message = "success"))
	@ResponseBody
	@RequestMapping("/deleteBullet")
	public ResponseJson deleteBullet(Integer bulletId) {
		Operator operator = getOperator();
		
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
		// 当前帖子是否可以删除
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		if (operator.newOrganizationType()) {
			ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
			if (null == erpUserOpers) {
				return ErpResponseJson.warn("你没有权限删除该帖子哦！");
			}
			boolean canDeleteBulletinNewOrg = this.canDeleteBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			// 没有编辑权限
			if (!canDeleteBulletinNewOrg) {
				return ErpResponseJson.warn("你没有权限删除该帖子哦！");
			}
		} else {
			if (!this.canDeleteBulletin(operator.getCityId(), operator.getUserId(), adminBulletDto.getBulletBound().intValue(), 
					isSelfComp, isSelfArchive, operator.getPartnerId())) {
				return ErpResponseJson.warn("你没有权限删除该帖子哦！");
			}
		}
		// 修改删除状态
		AdminBullet record = new AdminBullet();
		record.setIsDelete(true);
		record.setBulletId(bulletId);
		adminBulletMapper.updateByPrimaryKeySelective(record);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 回复帖子
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param BULLET_ID,BULLET_BOUND,SHOW_TEL,USE_REPLY_ID,CONTENTS
	 * @return
	 */
	@ApiOperation("回复帖子")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/addBulletReply")
	public ResponseJson addBulletReply(AdminBulletReplyParam param) {
		Operator operator = getOperator();
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(param.getBulletId());
		if(adminBulletDto.getReplyStatus() == 1) {
			return ErpResponseJson.warn("已关闭评论功能，不能进行评论");
		}
		this.bulletReply(operator,param);
		return ErpResponseJson.ok();
	}

	/**
	 * app帖子回复
	 * @param param
	 * @return
	 */
	@ApiOperation("app帖子回复")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/app/addBulletReply")
	public ResponseJson addBulletReplyApp(@RequestBody AdminBulletReplyParam param) {
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(param.getBulletId());
		if(adminBulletDto.getReplyStatus() == 1) {
			return ErpResponseJson.warn("已关闭评论功能，不能进行评论");
		}
		Operator operator = getOperator();
		this.bulletReply(operator,param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * app基础信息修改（删除、置顶、开启评论）
     * 权限由app端控制，只适用于app端
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "app基础信息修改(删除、置顶、开启评论)",httpMethod = "POST")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class,message = "成功")
	})
	@ResponseBody
	@PostMapping("/app/updateBulletBaseInfo")
    @NotBlank("bulletId")
	public ResponseJson addBulletReplyApp(@RequestBody BulletBaseInfoParam param) {
		Integer bulletId = param.getBulletId();
		Boolean stick = param.getStick() == null ? false:param.getStick();
		Integer isDelete = param.getIsDelete() == null ? 0:param.getIsDelete();
		Integer replyStatus = param.getReplyStatus() == null ? 0:param.getReplyStatus();
        AdminBullet adminBullet = new AdminBullet();
        adminBullet.setBulletId(bulletId);
        adminBullet.setStick(stick);
		adminBullet.setReplyStatus(replyStatus.byteValue());
        adminBullet.setIsDelete(isDelete == 1);
        adminBulletMapper.updateByPrimaryKeySelective(adminBullet);
		return ErpResponseJson.ok();
	}

	/**
	 * 获取附件类型的图标
	 * @author 张宏利
	 * @since 2018年2月10日
	 * @param fileName
	 */
	private String getFileTypeIcon(String fileName) {
		String fileSub = StringUtil.getFileSub(fileName);
		String filType = Const.FILE_TYPE_MAP.get(fileSub);
		return (filType == null) ? "other" : filType;
	}
	
	/**
	 * 创建帖子附件
	 * @author 张宏利
	 * @since 2018年2月10日
	 * @param bulletId
	 * @param userId
	 * @param pathTmp 附件，格式：名字,大小,地址
	 */
	private void createBulletinPs(Integer bulletId, Integer userId, String pathTmp) {
		pathTmp = Optional.ofNullable(pathTmp).orElse("");
		String[] tPath = pathTmp.split(",");
		if(tPath.length != 3) {
			return;
		}
		AdminBulletinPs bulletinPsPO = new AdminBulletinPs();
		bulletinPsPO.setBulletinId(bulletId);
		bulletinPsPO.setCreateTime(new Date());
		bulletinPsPO.setCreateUid(userId);
		bulletinPsPO.setFileName(tPath[0]);
		bulletinPsPO.setFileSize(StringUtil.parseLong(tPath[1]));
		bulletinPsPO.setPsPath(tPath[2]);
		adminBulletinPsMapper.insertSelective(bulletinPsPO);
	}

	/**
	 * 1 删除公司公告 有删除权限并且 有公司其他业务查看权
	 * 2删除门店公告   又删除权限即可
	 * @param operator
	 * @param bulletPO
	 * @return
	 */
	private boolean canDeleteBulletin(Integer cityId, Integer userId, Integer bulletBound, boolean isSelfComp, boolean isSelfArchive, Integer partnerId) {
		boolean canDelete = false;
		// 有喜报管理权的可以删
		boolean goodnewsManage = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "GOODNEWS_MANAGE") != null;
		if (bulletBound == 8) {
			return goodnewsManage;
		}
		// 同城交流，本人的可以删
		if ((bulletBound == 2 || bulletBound == 3 || bulletBound == 7 || bulletBound == 10) && isSelfArchive) {
			canDelete = true;
		} else if (isSelfComp && (bulletBound == 0 || bulletBound == 1 || bulletBound == 10)) {
			// 本公司的，有权限的可以删
			String[] operArr = new String[]{"MANAGE_DEPT_BULLET", "MANAGE_COMP_BULLET", "MANAGE_PARTNER_BULLET"};
			Set<String> operSet = erpUserOpersMapper.getUsersOpersByUserId(cityId, userId, operArr);
			if (null != partnerId && partnerId > 0) {// 加盟商
				if (bulletBound == 0) {
					if (operSet.contains("MANAGE_DEPT_BULLET")) {
						canDelete = true;
					}
				} else if (bulletBound == 1) {
					if (operSet.contains("MANAGE_COMP_BULLET")) {
						canDelete = true;
					}
				} else if (bulletBound == 10) {
					if (operSet.contains("MANAGE_PARTNER_BULLET")) {
						canDelete = true;
					}
				}
			} else {
				if (bulletBound == 0) {
					if (operSet.contains("MANAGE_DEPT_BULLET")) {
						canDelete = true;
					}
				} else if (bulletBound == 1) {
					if (operSet.contains("MANAGE_COMP_BULLET")) {
						canDelete = true;
					}
				}
			} 
		}
		return canDelete;
	}
	
	/**
	 * 删除公告 有删除权限并且 有公司其他业务查看权（无限组织架构）
	 * @param operator
	 * @param bulletPO
	 * @return
	 */
	private boolean canDeleteBulletinNewOrg(Operator operator, AdminBulletDto adminBulletDto, ErpUserOpers erpUserOpers) {
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Integer compId = operator.getCompId();
		Integer partnerId = operator.getPartnerId();
		Integer operOrganizationDefinitionId = erpUserOpers.getOrganizationDefinitionId();// 权限上的组织层级id	0=全公司 1=本组织
		Integer bulletOrganizationDefinitionId = adminBulletDto.getOrganizationDefinitionId();// 数据发布范围 0=全公司 1=本组织
		Integer bulletOrganizationId = adminBulletDto.getOrganizationId();// 数据上的组织id
		boolean canDelete = false;
		
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		
		// 本店信息、公司信息、同城交流，本人的可以删	范围， 0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报 9:优家体系 10:加盟商
		if (isSelfArchive) {
			canDelete = true;
		} else if (isSelfComp && null != erpUserOpers) {// 信息属于本公司的，验证权限级别了
			if (null != partnerId && partnerId > 0) {// 加盟商
				if (Integer.valueOf(-1).equals(bulletOrganizationDefinitionId)) {
					canDelete = Integer.valueOf(-1).equals(operOrganizationDefinitionId);
				} else if (Integer.valueOf(0).equals(bulletOrganizationDefinitionId)) {
					canDelete = Integer.valueOf(-1).equals(operOrganizationDefinitionId) 
							|| Integer.valueOf(0).equals(operOrganizationDefinitionId);
				} else if (Integer.valueOf(1).equals(bulletOrganizationDefinitionId)) {
					canDelete = Integer.valueOf(-1).equals(operOrganizationDefinitionId) 
							|| Integer.valueOf(0).equals(operOrganizationDefinitionId) 
							|| (Integer.valueOf(1).equals(operOrganizationDefinitionId) 
									&& erpFunOrganizationService.judgePermissionByOrganizationId(cityId, compId, operator.getOrganizationId(), bulletOrganizationId));
				}
			} else {
				if (Integer.valueOf(0).equals(bulletOrganizationDefinitionId)) {
					canDelete = Integer.valueOf(0).equals(operOrganizationDefinitionId);
				} else if (Integer.valueOf(1).equals(bulletOrganizationDefinitionId)) {
					canDelete = Integer.valueOf(0).equals(operOrganizationDefinitionId) 
							|| (Integer.valueOf(1).equals(operOrganizationDefinitionId) 
									&& erpFunOrganizationService.judgePermissionByOrganizationId(cityId, compId, operator.getOrganizationId(), bulletOrganizationId));
				}
			}
		}
		return canDelete;
	}
	
	/**
	 * 是否可以编辑帖子
	 * @author 张宏利
	 * @since 2018年2月8日
	 * @param operator
	 * @param bulletBound
	 * @param isSelfComp
	 * @param isSelfArchive
	 * @return
	 */
	private boolean canEditBulletin(Integer cityId, Integer userId, Byte bulletBound, boolean isSelfComp, boolean isSelfArchive, Integer partnerId) {
		boolean canEdit = false;
		// 本店信息、公司信息、同城交流，本人的可以删	范围， 0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报 9:优家体系 10:加盟商
		if ((3 == bulletBound || 2 == bulletBound || 7 == bulletBound || 10 == bulletBound) && isSelfArchive) {
			canEdit = true;
		// 信息属于本公司，而且帖子是本公司或本门店的数据
		} else if (isSelfComp && (0 == bulletBound || 1 == bulletBound || 10 == bulletBound)) {
			String[] operArr = new String[]{"MANAGE_DEPT_BULLET", "MANAGE_COMP_BULLET", "MANAGE_PARTNER_BULLET"};
			Set<String> operSet = erpUserOpersMapper.getUsersOpersByUserId(cityId, userId, operArr);
			if (null != partnerId && partnerId > 0) {// 加盟商
				if (bulletBound == 0) {
					if (operSet.contains("MANAGE_DEPT_BULLET")) {
						canEdit = true;
					}
				} else if (bulletBound == 1) {
					if (operSet.contains("MANAGE_COMP_BULLET")) {
						canEdit = true;
					}
				} else if (bulletBound == 10) {
					if (operSet.contains("MANAGE_PARTNER_BULLET")) {
						canEdit = true;
					}
				}
			} else {
				if (bulletBound == 0) {
					if (operSet.contains("MANAGE_DEPT_BULLET")) {
						canEdit = true;
					}
				} else if (bulletBound == 1) {
					if (operSet.contains("MANAGE_COMP_BULLET")) {
						canEdit = true;
					}
				}
			}
		}
		return canEdit;
	}
	
	/**
	 * 无限组织架构下是否可以编辑帖子
	 * @author chenfeng
	 * @since 2019年12月06日
	 * @param operator
	 * @param adminBulletDto
	 * @param erpUserOpers
	 * @return boolean
	 */
	private boolean canEditBulletinNewOrg(Operator operator, AdminBulletDto adminBulletDto, ErpUserOpers erpUserOpers) {
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer partnerId = operator.getPartnerId();
		Integer operOrganizationDefinitionId = erpUserOpers.getOrganizationDefinitionId();// 权限上的组织层级id	0=全公司 1=本组织
		Integer bulletOrganizationDefinitionId = adminBulletDto.getOrganizationDefinitionId();// 数据发布范围 0=全公司 1=本组织
		Integer bulletOrganizationId = adminBulletDto.getOrganizationId();// 数据上的组织id
		
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		boolean canEdit = false;
		
		// 本店信息、公司信息、同城交流，本人的可以删	范围， 0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报 9:优家体系 10:加盟商
		if (isSelfArchive) {
			canEdit = true;
		} else if (isSelfComp && null != erpUserOpers) {// 信息属于本公司的，验证权限级别了
			if (null != partnerId && partnerId > 0) {// 加盟商
				if (Integer.valueOf(-1).equals(bulletOrganizationDefinitionId)) {
					canEdit = Integer.valueOf(-1).equals(operOrganizationDefinitionId);
				} else if (Integer.valueOf(0).equals(bulletOrganizationDefinitionId)) {
					canEdit = Integer.valueOf(-1).equals(operOrganizationDefinitionId) 
							|| Integer.valueOf(0).equals(operOrganizationDefinitionId);
				} else if (Integer.valueOf(1).equals(bulletOrganizationDefinitionId)) {// 发到本组织的公告数据
					canEdit = Integer.valueOf(-1).equals(operOrganizationDefinitionId) 
							|| Integer.valueOf(0).equals(operOrganizationDefinitionId) 
							|| (Integer.valueOf(1).equals(operOrganizationDefinitionId) 
									&& erpFunOrganizationService.judgePermissionByOrganizationId(cityId, compId, operator.getOrganizationId(), bulletOrganizationId));
				}
			} else {
				if (Integer.valueOf(0).equals(adminBulletDto.getOrganizationDefinitionId())) {
					canEdit = Integer.valueOf(0).equals(erpUserOpers.getOrganizationDefinitionId());
				} else if (Integer.valueOf(1).equals(adminBulletDto.getOrganizationDefinitionId())) {
					canEdit = Integer.valueOf(0).equals(operOrganizationDefinitionId) 
							|| (Integer.valueOf(1).equals(operOrganizationDefinitionId) 
									&& erpFunOrganizationService.judgePermissionByOrganizationId(cityId, compId, operator.getOrganizationId(), bulletOrganizationId));
				}
			}
		}
		return canEdit;
	}
	
	/**
	  * 登陆获取小秘书
	  * @author 李成兵
	  * @since 2018/5/22
	  * @param 
	  * @return
	  */
	@ApiOperation(value = "登陆获取小秘书",httpMethod = "POST")
	@ApiResponses(@ApiResponse(code = Const.ResponseCode.SUCCESS,message = "success"))
	@RequestMapping("/getMsgList")
	@ResponseBody
	public ResponseJson getMsgList() throws Exception{
		Operator operator = getOperator();

		List<Map<String, Object>> taskList = getTaskList(operator);
		taskList.addAll(getFunMsgList(operator));
		taskList.addAll(getBroadCast(operator));
		return ErpResponseJson.ok(taskList);
	}

	private List<Map<String, Object>> getBroadCast(Operator operator) throws Exception{
		//判断当前用户所在门店是否是you+用户
		Boolean isYouJia = getOperator().youJiaDeptFlag();
		Integer archiveId = getOperator().getArchiveId();
		Integer cityId = operator.getCityId();

		List<ErpBroadcast> broadcastList = erpBroadcastMapper.getBroadCastList(archiveId, isYouJia);

		//公告id
		List<Integer> bulletIds = new ArrayList<>();
		//回复id 用于查找公告id
		List<Integer> replayIds = new ArrayList<Integer>();
		if (broadcastList.size() > 0) {
			broadcastList.stream().forEach(erpBroadcast -> {
				Integer bulletId = erpBroadcast.getBulletId();
				Integer bcType = erpBroadcast.getBcType();
				if(Constants_DIC.DIC_BROADCAST_TYPE_BULLET.equals(bcType+"") || Constants_DIC.DIC_BROADCAST_TYPE_BUSUSINESS_INFORMATION .equals(bcType+"")){
					bulletIds.add(bulletId);
				}else if(Constants_DIC.DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY.equals(bcType+"") || Constants_DIC.DIC_BROADCAST_TYPE_REMINDER_TASK.equals(bcType+"") || Constants_DIC.DIC_BROADCAST_TYPE_ANNOUNCEMENT_REPLY_REPLY.equals(bcType+"")){
					replayIds.add(bulletId);
				}
			});
		}

		if (!replayIds.isEmpty()) {
			AdminBulletReplyExample adminBulletReplyExample = new AdminBulletReplyExample();
			adminBulletReplyExample.createCriteria().andReplyIdIn(replayIds);
			List<AdminBulletReply> adminBulletReplies = adminBulletReplyMapper.selectByExample(adminBulletReplyExample);

			if (adminBulletReplies.size() > 0) {
				List<Integer> collect = adminBulletReplies.stream().collect(Collectors.mapping(val -> val.getBulletId(), Collectors.toList()));
				bulletIds.addAll(collect);
			}
		}
		if (bulletIds.isEmpty()) {
			return new ArrayList<>();
		}

		//删除所有提醒
		erpBroadcastMapper.deleteByArchiveId(cityId, archiveId);
		List<Map<String, Object>> bulletList = new ArrayList<>();
		if(bulletIds.size() > 0) {
			AdminBulletExample adminBulletExample = new AdminBulletExample();
			adminBulletExample.createCriteria().andBulletIdIn(bulletIds);
			List<AdminBullet> adminBullets = adminBulletMapper.selectByExample(adminBulletExample);
			if(adminBullets.size() > 0) {
				Set<Integer> collect = adminBullets.stream().collect(Collectors.mapping(val -> val.getArchiveId(), Collectors.toSet()));
				Map<Integer, AdminFunArchive> modelDataMap = adminFunArchiveMapper.getModelDataMap(collect);

				adminBullets.stream().forEach(adminBullet -> {
					AdminFunArchive adminFunArchive = modelDataMap.get(adminBullet.getArchiveId());
					Map<String, Object> mapItem = new HashedMap();
					mapItem.put("title", "newBullet");
					mapItem.put("id", adminBullet.getBulletId());
					if (getOperator().newOrganizationType()) {
						mapItem.put("bound", adminBullet.getOrganizationDefinitionId());
					} else {
						mapItem.put("bound", adminBullet.getBulletBound());
					}
					mapItem.put("content", adminBullet.getBulletSubject());
					mapItem.put("contract", adminBullet.getContract());
					mapItem.put("senduser", null != adminFunArchive ? adminFunArchive.getUserName() : "");
					if(StringUtils.isNotBlank(adminBullet.getEditTime())) {
						mapItem.put("sendtime", adminBullet.getEditTime().substring(0,6));
					}else {
						mapItem.put("sendtime", adminBullet.getBulletTime().substring(0,6));
					}
					bulletList.add(mapItem);

				});
			}
		}
		return bulletList;
	}
    /**
    * @brief 方法简介
    *   （可能）是获取未读任务列表，用于erp小秘书弹窗
    *
    * @Date  2020/3/10 11:52
    *  * @param operator
    * @return
    * @Author 未知。
    * @note 2020.3.10 杨杰修改。原因：有一条未读任务，小秘书不停弹窗。
     *      修改为：查询过后，就把未读状态设为已读。
	 *      2020.3.13 杨杰修改，取消设置为已读状态。由前端自己判断小秘书弹窗。已经拉去过的数据，就不弹窗了。
    */

	private List<Map<String, Object>> getTaskList(Operator operator) throws Exception{
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		Map<String, Object> pMap = new HashedMap();
		String startTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd 00:00:00");
		String endTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd HH:mm:ss");
		pMap.put("remindType", 1);
		pMap.put("isRead", 0);
		pMap.put("startTime", startTime);
		pMap.put("endTime", endTime);
		// funTask全部是提醒任务，去掉typeFlag
//		pMap.put("typeFlag", 0);
		pMap.put("trackWarm", 1);
		pMap.put("curUserId", userId);
		pMap.put("curCompId", operator.getCompId());
		List<ErpFunTaskDto> warmTaskList = erpFunTaskMapper.getWarmTaskList(cityId, pMap);
		// 处理特殊字段，
		List<Map<String, Object>> funTaskList = new ArrayList<>();

		if(warmTaskList.size() > 0) {
			warmTaskList.stream().forEach(erpFunTaskDto -> {
				Map<String, Object> mapItem = new HashMap();
				mapItem.put("title", "trackwarm");
				mapItem.put("id", erpFunTaskDto.getTaskId());
				mapItem.put("bound", erpFunTaskDto.getTrackId());
				mapItem.put("content", erpFunTaskDto.getTaskSubject());
				mapItem.put("senduser", "系统");
				System.out.println(erpFunTaskDto.getCreationTime());
				mapItem.put("sendtime", erpFunTaskDto.getCreationTime().substring(5,10));
				funTaskList.add(mapItem);
			});
		}
		// 将状态设为已读。取消设置为已读。
//        if(warmTaskList.size()>0){
//            List<Integer> taskIds = warmTaskList.stream().map(ErpFunTask::getTaskId).collect(Collectors.toList());
//            ErpFunTaskTimed erpFunTaskTimed = new ErpFunTaskTimed();
//            erpFunTaskTimed.setReadFlag((byte)1);
//			ErpFunTaskTimedExample erpFunTaskTimedExample = new ErpFunTaskTimedExample();
//			erpFunTaskTimedExample.setShardCityId(cityId);
//			erpFunTaskTimedExample.createCriteria().andTaskIdIn(taskIds).andArchiveIdEqualTo(operator.getArchiveId());
//            erpFunTaskTimedMapper.updateByExampleSelective(erpFunTaskTimed,erpFunTaskTimedExample);
//        }

		return funTaskList;
	}

	private List<Map<String, Object>> getFunMsgList(Operator operator) throws Exception{
		Integer cityId = operator.getCityId();
		List<Map<String, Object>> funMsgList = erpFunMsgMapper.getFunMsgList(cityId, getOperator().getCompId(), operator.getUserId());
		if(funMsgList.size() > 0) {
			List<Integer> msgIdList = funMsgList.stream().collect(Collectors.mapping(val -> Integer.valueOf(val.get("id") + ""), Collectors.toList()));
			ErpFunMsgExample example = new ErpFunMsgExample();
			example.setShardCityId(cityId);
			example.createCriteria().andMsgIdIn(msgIdList);
			ErpFunMsg erpFunMsg = new ErpFunMsg();
			erpFunMsg.setReadFlag(true);
			erpFunMsgMapper.updateByExampleSelective(erpFunMsg, example);
		}
		return funMsgList;
	}

	private Map<String, Object> getBulletin (Map<String, Object> paramMap, Integer bulletId, Operator operator, Integer isViewStatus) {
		// 更新点击量
		adminBulletService.addClick(bulletId);
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
		// 判断帖子是否被删除 如果被删除则返回错误
		if (null!=adminBulletDto.getIsDelete() && adminBulletDto.getIsDelete()) {
			throw new ConfirmException("该帖子已经被删除，请刷新列表");
		}
		if(null != adminBulletDto.getYouJiaFlag() && 1 != adminBulletDto.getYouJiaFlag().intValue()) {
			//不是本公司数据
			if (!operator.isSwitchCompLogin()) {
				if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
					throw new ConfirmException("该帖子不存在，请刷新列表");
				}
			}
		}
		Byte bulletBound = adminBulletDto.getBulletBound();
		// 组装数据
		AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByPrimaryKey(adminBulletDto.getDeptId());
		adminBulletDto.setDeptName((adminFunDeptsPO == null) ? "网络经纪人" : adminFunDeptsPO.getDeptName());
		// 发帖人信息
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(adminBulletDto.getArchiveId());
		if(adminFunArchive != null) {
			adminBulletDto.setUserMobile(adminFunArchive.getUserMobile());
			adminBulletDto.setUserName(adminFunArchive.getUserName());
			adminBulletDto.setBbsName(adminFunArchive.getNickName());
			adminBulletDto.setRealPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getUserPhotoMin()));
			adminBulletDto.setUserPhotoMin(CommonUtil.getBbsPhoto(adminFunArchive.getBbsPhoto()));
			adminBulletDto.setUserRight(adminFunArchive.getUserRight());
			// 是否是付费用户
			Integer isSuperUser = OperatorSessionUtil.isSuperUser(adminFunArchive.getSuperUser(), adminFunArchive.getSuperEnd());
			adminBulletDto.setSuperUser(String.valueOf(isSuperUser));
			// 用户积分
			List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(new Integer[] { adminFunArchive.getArchiveId() });
			if (list != null && list.size() > 0) {
				AdminFunUsersCountDto userScorByArchiveId = list.get(0);
				if (userScorByArchiveId != null) {
					adminBulletDto.setUserScore(userScorByArchiveId.getTotalScore());
				}
			}
		}
		// 查询出当前用的状态 是否被禁言
		String nowDate = DateTimeHelper.formatDatetoString(new Date());
		Integer bulletinStatus = adminBanMapper.getIsBanIng(nowDate, 1, operator.getArchiveId());
		paramMap.put("bulletinStatus", bulletinStatus);
		if (Byte.valueOf("8").equals(bulletBound) && !operator.newOrganizationType()) {
			String bulletContent = null;
			// 兼容老版
			if ("images/goodNews/01.png".equals(adminBulletDto.getNewsBackUrl())) {
				bulletContent = new StringBuilder()
						.append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-size: 580px 500px;background-position:center center;height:860px;' >")
						.append("<div style='padding:200px 50px 0px;'>").append(adminBulletDto.getNewsBackUrl())
						.append("</div></div>").toString().replaceAll("#NEWS_BACK_URL#", adminBulletDto.getNewsBackUrl());
			} else {
				bulletContent = new StringBuilder()
						.append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-size: 580px 500px;background-position:center center;height:500px;' >")
						.append("<div style='padding:170px 80px 0px;'>").append(adminBulletDto.getBulletContent())
						.append("</div></div>").toString().replaceAll("#NEWS_BACK_URL#", adminBulletDto.getNewsBackUrl());
			}
			adminBulletDto.setBulletContent(bulletContent);
		}


		// 获取回复
		PageParam pageParam = new PageParam(1, 50);
		PageInfo<AdminBulletReplyDto> replayBulletinVOs = this.getBulletinReplyList(operator.getArchiveId(), bulletId, pageParam);
		paramMap.put("replayList", replayBulletinVOs.getList());
		paramMap.put("pageRows", replayBulletinVOs.getTotal());
		paramMap.put("bulletinInfo", adminBulletDto);
		paramMap.put("clientKey", operator.getClientKey());
		paramMap.put("bulletBound", !operator.newOrganizationType() ? bulletBound : adminBulletDto.getOrganizationDefinitionId());
		paramMap.put("bulletId", bulletId);
		if (operator.isPersonalVersion()) {
			paramMap.put("addCommunicInfo", 1);
		} else {
			ErpUserOpers userOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "ADD_COMMUNIC_INFO");
			paramMap.put("addCommunicInfo", (userOpers != null) ? 1 : 0);
		}
		// 是否开启同城交流平台 ALLOW_CITY_BBS，同城交流才需要，现在没有了，就不查了
		String allowCityBbs = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ALLOW_CITY_BBS");
		paramMap.put("allowCityBbs", allowCityBbs);
		// 获取公告附件
//		if (bulletBound == 0 || bulletBound == 1 || bulletBound == 7 || bulletBound == 8) {
			List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
			for (AdminBulletinPsDto adminBulletinPs : bulletinPsPOs) {
				Long fileSize = adminBulletinPs.getFileSize();
				adminBulletinPs.setPsPath(CommonUtil.getPhotoUrl(adminBulletinPs.getPsPath()));
				if(fileSize != null && fileSize > 0) {
					String convertFileSize = FileUtil.convertFileSize(fileSize);
					adminBulletinPs.setFileSizeStr(convertFileSize);
				}
				adminBulletinPs.setFileType(this.getFileTypeIcon(adminBulletinPs.getFileName()));
			}
			paramMap.put("bulletinPsPOs", bulletinPsPOs);
//		}
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		// 是否可以删除
		boolean canDeleteBulletin = false;
		// 是否可以编辑
		boolean canEditBulletin = false;
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
		if (operator.newOrganizationType()) {
			if (null != erpUserOpers) {
				canDeleteBulletin = this.canDeleteBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
				canEditBulletin = this.canEditBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			}
		} else {
			canDeleteBulletin = this.canDeleteBulletin(operator.getCityId(), operator.getUserId(), adminBulletDto.getBulletBound().intValue(),
					isSelfComp, isSelfArchive, operator.getPartnerId());
			canEditBulletin = this.canEditBulletin(operator.getCityId(), operator.getUserId(), bulletBound, isSelfComp, isSelfArchive, operator.getPartnerId());
		}
		adminBulletDto.setCanDelete(canDeleteBulletin ? 1 : 0);
		adminBulletDto.setCanEdit(canEditBulletin ? 1 : 0);

		// you+  已阅修改
		if("1".equals(operator.getYouCompFlag())) {
			adminBulletYouUsersMapper.updateIsView(bulletId, operator.getCityId(), operator.getUserId());
		}
		//查看帖子生成查看记录
		AdminBulletViewLog adminBulletViewLog = new AdminBulletViewLog();
		adminBulletViewLog.setCityId(operator.getCityId());
		adminBulletViewLog.setBulletId(bulletId);
		adminBulletViewLog.setCompNo(operator.getCompNo());
		adminBulletViewLog.setDeptNo(operator.getDeptNo());
		adminBulletViewLog.setErpAreaId(operator.getAreaId());
		adminBulletViewLog.setErpCompId(operator.getCompId());
		adminBulletViewLog.setErpDeptId(operator.getDeptId());
		adminBulletViewLog.setErpGrId(operator.getGrId());
		adminBulletViewLog.setErpRegId(operator.getRegId());
		adminBulletViewLog.setErpUserId(operator.getUserId());
		adminBulletViewLog.setViewTime(new Date());
		adminBulletViewLogMapper.insertSelective(adminBulletViewLog);
		//获取帖子已读未读数据
		if (isViewStatus == 1){
			if (operator.newOrganizationType()) {
				this.setViewCountNewOrg(adminBulletDto, bulletId, operator);
			} else {
				this.setViewCount(adminBulletDto, bulletId);
			}
		}
		return paramMap;
	}

	/**
	 *	帖子回复
	 * @param:
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2018/9/25
	 */
	private void bulletReply(Operator operator, AdminBulletReplyParam param) {
		param.setContents(StringUtil.replaceHtmlToBlank(param.getContents()));
		param.setUserName(operator.getUserName());
		param.setCreatorUid(operator.getUserId());
		param.setArchiveId(operator.getArchiveId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setUserId(operator.getUserId());
		param.setTelePhone((String) operator.getAttribute("USER_MOBILE"));
		param.setDeptName((operator.getDeptName() == null) ? "网络经纪人" : operator.getDeptName());
		param.setCompName((operator.getCompName() == null) ? "网络经纪人" : operator.getCompName());
		param.setIsdelete(false);
		param.setIsshield(false);
		param.setSource((byte)1);
		// 属于几楼
		Integer louNumber = adminBulletReplyMapper.getMaxLouNumber(param.getBulletId());
		param.setLou(louNumber.shortValue());
		// 兼容第一层
		Integer relateId = Optional.ofNullable(param.getRelateId()).orElse(0);
		Integer mainRelateId = Optional.ofNullable(param.getMainRelateId()).orElse(0);
		if (relateId > 0 && mainRelateId <= 0) {
			param.setMainRelateId(relateId);
		}
		adminBulletService.addBulletReply(param);
	}

	/**
	 * 发帖
	 * @param:
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2018/9/25
	 */
	private AdminBullet addBullet(Operator operator, CreateBulletParam param) {
		Integer bounds = param.getBounds();
		Boolean stick = param.getStick()!=null?param.getStick():false;
		Byte replyStatus = param.getReplyStatus()!=null?param.getReplyStatus():0;
		Integer showPhone = 0;
		Integer isvote = 0;
		Byte bulletType = param.getBulletType();
		String bulletSubject = param.getBulletSubject();
		String bulletContent = param.getBulletContent();
		Integer bulletId = param.getBulletId();
		String bulletinPs = param.getBulletinPs();
		String nowtime = DateTimeHelper.formatDateTimetoString(new Date());
		boolean isPartner = Integer.valueOf(1).equals(operator.openPartner());
		AdminBullet adminBullet = new AdminBullet();
		adminBullet.setEditTime(nowtime);
		adminBullet.setStick(stick);
		adminBullet.setReplyStatus(replyStatus);
		adminBullet.setShowTel(showPhone == 1);
		adminBullet.setBulletSubject(bulletSubject);
		adminBullet.setOrderTime(nowtime);
		adminBullet.setIsvote(isvote == 1);
		adminBullet.setBulletContent(bulletContent);
		adminBullet.setBulletType(bulletType);
		adminBullet.setBulletBound(bounds.byteValue());
		adminBullet.setPic(bulletContent.indexOf("hftImagesUrlAddress") >= 0);
		adminBullet.setPartnerId(operator.getPartnerId());
		if(bulletId != null && bulletId > 0) {
			AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
			// 判断帖子是否被删除 如果被删除则返回错误
			if (adminBulletDto.getIsDelete()) {
				throw new ConfirmException("该帖子已经被删除，请刷新列表");
			}
			// 不是本公司数据
			if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			Byte bulletBound = adminBulletDto.getBulletBound();
			boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
			boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
			// 是否可以编辑
			boolean canEditBulletin = this.canEditBulletin(operator.getCityId(), operator.getUserId(), bulletBound.byteValue(), isSelfComp, isSelfArchive, operator.getPartnerId());
			// 没有编辑权限
			if (!canEditBulletin) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			adminBullet.setBulletId(bulletId);
			adminBulletService.updateByPrimaryKeySelective(adminBullet);
			AdminBulletinPsExample example = new AdminBulletinPsExample();
			example.createCriteria().andBulletinIdEqualTo(bulletId);
			List<AdminBulletinPs> psList = adminBulletinPsMapper.selectByExample(example);
			// 之前没有传图
			if(psList.size() <= 0) {
				if(StringUtils.isNotBlank(bulletinPs)) {
					String[] paths = bulletinPs.split(";");
					for (String pathTmp : paths) {
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
			} else {
				// 之前传有图片的情况
				Map<String, AdminBulletinPs> bulletinPsMap = psList.stream().collect(Collectors.toMap(AdminBulletinPs::getPsPath, val -> val));
				String[] paths = bulletinPs.split(";");
				for (String pathTmp : paths) {
					String[] tPath = pathTmp.split(",");
					if (tPath == null || tPath.length != 3) {
						continue;
					}
					AdminBulletinPs adminBulletinPs = bulletinPsMap.get(tPath[2]);
					// 之前和现在都有则从map里面移除，剩下的全是要删除的
					if(adminBulletinPs != null) {
						bulletinPsMap.remove(tPath[2]);
					} else {
						// 现在有，之前没有的则新增
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
				// 之前有，现在没了的全部删除掉
				if(bulletinPsMap.size() > 0) {
					List<Integer> psIdList = bulletinPsMap.values().stream().collect(Collectors.mapping(AdminBulletinPs::getId, Collectors.toList()));
					example = new AdminBulletinPsExample();
					example.createCriteria().andBulletinIdEqualTo(bulletId).andIdIn(psIdList);
					adminBulletinPsMapper.deleteByExample(example);
				}
			}
		} else {
			adminBullet.setBulletTime(nowtime);
			adminBullet.setClickCount(0);
			adminBullet.setUserId(operator.getUserId());
			adminBullet.setArchiveId(operator.getArchiveId());
			adminBullet.setElite(false);
			adminBullet.setIsDelete(false);
			adminBullet.setRecommend(false);
			adminBullet.setReplyCount((short) 0);
			adminBullet.setCompId(operator.getAdminCompId());
			adminBullet.setDeptId(operator.getAdminDeptId());
			adminBullet.setCompName(operator.getCompName());
			adminBullet.setContract(operator.getUserName());
			adminBullet.setCityId(operator.getCityId());
			adminBullet.setSource((byte) 1);
			adminBulletService.insertSelective(adminBullet);
			bulletId = adminBullet.getBulletId();
			// 如果是本店或者公司则广播
			if (bounds == 0 || bounds == 1 || bounds == 7 || bounds==10) {
				Integer deptId = (bounds == 0) ? operator.getDeptId() : null;
				erpBroadcastMapper.insertBulletBroadcast(operator.getCityId(), operator.getCompId(),
						adminBullet.getBulletId(), bounds, operator.getUserId(), deptId,isPartner && bounds==10,operator.getPartnerId());
				// 如果是本店信息 公司信息 加盟圈信息 则判断附件情况
				if (StringUtil.isNotEmpty(bulletinPs)) {
					String[] paths = bulletinPs.split(";");
					for (String pathTmp : paths) {
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
			}
		}
		return adminBullet;
	}
	
	/**
	 * 发帖（无限组织架构）
	 * @param:
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2019/12/07
	 */
	private AdminBullet addBulletNewOrg(Operator operator, CreateBulletParam param, ErpUserOpers erpUserOpers) {
		Integer bounds = param.getBounds();
		Boolean stick = param.getStick()!=null?param.getStick():false;
		Byte replyStatus = param.getReplyStatus()!=null?param.getReplyStatus():0;
		Integer showPhone = 0;
		Integer isvote = 0;
		Byte bulletType = param.getBulletType();
		String bulletSubject = param.getBulletSubject();
		String bulletContent = param.getBulletContent();
		Integer bulletId = param.getBulletId();
		String bulletinPs = param.getBulletinPs();
		String nowtime = DateTimeHelper.formatDateTimetoString(new Date());
		boolean isPartner = Integer.valueOf(1).equals(operator.openPartner());
		AdminBullet adminBullet = new AdminBullet();
		adminBullet.setEditTime(nowtime);
		adminBullet.setStick(stick);
		adminBullet.setReplyStatus(replyStatus);
		adminBullet.setShowTel(showPhone == 1);
		adminBullet.setBulletSubject(bulletSubject);
		adminBullet.setOrderTime(nowtime);
		adminBullet.setIsvote(isvote == 1);
		adminBullet.setBulletContent(bulletContent);
		adminBullet.setBulletType(bulletType);
//		adminBullet.setBulletBound(bounds.byteValue());
		adminBullet.setPic(bulletContent.indexOf("hftImagesUrlAddress") >= 0);
		adminBullet.setPartnerId(operator.getPartnerId());
		adminBullet.setOrganizationId(Integer.valueOf(1).equals(bounds) ? operator.getOrganizationId() : null);// null=全公司，其他代表当前人本组织
		adminBullet.setOrganizationDefinitionId(bounds);// 设置0=公司，1=本组织也用以前的这个参数传值
		if(bulletId != null && bulletId > 0) {
			AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
			// 判断帖子是否被删除 如果被删除则返回错误
			if (adminBulletDto.getIsDelete()) {
				throw new ConfirmException("该帖子已经被删除，请刷新列表");
			}
			// 不是本公司数据
			if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			// 是否可以编辑
			boolean canEditBulletin = this.canEditBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			// 没有编辑权限
			if (!canEditBulletin) {
				throw new ConfirmException("你没有编辑帖子的权限");
			}
			adminBullet.setBulletId(bulletId);
			adminBulletService.updateByPrimaryKeySelective(adminBullet);
			AdminBulletinPsExample example = new AdminBulletinPsExample();
			example.createCriteria().andBulletinIdEqualTo(bulletId);
			List<AdminBulletinPs> psList = adminBulletinPsMapper.selectByExample(example);
			// 之前没有传图
			if (psList.size() <= 0) {
				if(StringUtils.isNotBlank(bulletinPs)) {
					String[] paths = bulletinPs.split(";");
					for (String pathTmp : paths) {
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
			} else {
				// 之前传有图片的情况
				Map<String, AdminBulletinPs> bulletinPsMap = psList.stream().collect(Collectors.toMap(AdminBulletinPs::getPsPath, val -> val));
				String[] paths = bulletinPs.split(";");
				for (String pathTmp : paths) {
					String[] tPath = pathTmp.split(",");
					if (tPath == null || tPath.length != 3) {
						continue;
					}
					AdminBulletinPs adminBulletinPs = bulletinPsMap.get(tPath[2]);
					// 之前和现在都有则从map里面移除，剩下的全是要删除的
					if(adminBulletinPs != null) {
						bulletinPsMap.remove(tPath[2]);
					} else {
						// 现在有，之前没有的则新增
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
				// 之前有，现在没了的全部删除掉
				if(bulletinPsMap.size() > 0) {
					List<Integer> psIdList = bulletinPsMap.values().stream().collect(Collectors.mapping(AdminBulletinPs::getId, Collectors.toList()));
					example = new AdminBulletinPsExample();
					example.createCriteria().andBulletinIdEqualTo(bulletId).andIdIn(psIdList);
					adminBulletinPsMapper.deleteByExample(example);
				}
			}
		} else {
			adminBullet.setBulletTime(nowtime);
			adminBullet.setClickCount(0);
			adminBullet.setUserId(operator.getUserId());
			adminBullet.setArchiveId(operator.getArchiveId());
			adminBullet.setElite(false);
			adminBullet.setIsDelete(false);
			adminBullet.setRecommend(false);
			adminBullet.setReplyCount((short) 0);
			adminBullet.setCompId(operator.getAdminCompId());
			adminBullet.setDeptId(operator.getAdminDeptId());
			adminBullet.setCompName(operator.getCompName());
			adminBullet.setContract(operator.getUserName());
			adminBullet.setCityId(operator.getCityId());
			adminBullet.setSource((byte) 1);
			adminBulletService.insertSelective(adminBullet);
			bulletId = adminBullet.getBulletId();
			// 如果是本店或者公司则广播
			if (null != bounds) {
				String pubOrganizationId = null;
				if (bounds > 0) {// 需要找到发布的对应的组织信息id，找出该组织下的所有人
					pubOrganizationId = operator.getOrganizationId().toString();
				}
				erpBroadcastMapper.insertBulletBroadcastNewOrg(operator.getCityId(), operator.getCompId(),
						adminBullet.getBulletId(), bounds, operator.getUserId(), pubOrganizationId, isPartner && Integer.valueOf(-1).equals(bounds), operator.getPartnerId());
				// 判断附件情况
				if (StringUtil.isNotEmpty(bulletinPs)) {
					String[] paths = bulletinPs.split(";");
					for (String pathTmp : paths) {
						this.createBulletinPs(bulletId, operator.getUserId(), pathTmp);
					}
				}
			}
		}
		return adminBullet;
	}

	/**
	 * 设置已读未读数据
	 * @param:
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2018/9/26
	 */
	private void setViewCount(AdminBulletDto adminBulletDto,Integer bulletId) {
		//统计帖子已读
		AdminBulletViewLogDto adminBulletViewLogDto = adminBulletViewLogMapper.getViewCountByBulletId(bulletId);
		//统计门店人数
		List<AdminFunDepts> adminFunDeptsList = adminFunDeptsMapper.getFunDeptsByDeptsId(getOperator().getAdminCompId());

		Map<Integer,Integer> deptsMap = adminFunDeptsList.stream().collect(Collectors.toMap(AdminFunDepts::getDeptId,AdminFunDepts::getIncumbencyNumber));
		//统计公司人数
		Integer allCompUserCount = 0;
		for (AdminFunDepts adminFunDepts:adminFunDeptsList){
			Integer incumbencyNumber = adminFunDepts.getIncumbencyNumber();
			if (incumbencyNumber!=null){
				allCompUserCount += incumbencyNumber;
			}
		}

		Integer readViewCount = adminBulletViewLogDto.getViewCount()!=null?adminBulletViewLogDto.getViewCount():0;//已读
		adminBulletDto.setReadViewCount(readViewCount);

		// 全公司
		if(1 == adminBulletDto.getBulletBound().intValue()) {
			Integer unReadViewCount = allCompUserCount > readViewCount ? (allCompUserCount-readViewCount) : 0;
			adminBulletDto.setUnReadViewCount(unReadViewCount);
		} else if(0 == adminBulletDto.getBulletBound().intValue()){
			// 本店
			Integer deptCount = deptsMap.get(adminBulletDto.getDeptId());
			deptCount = null != deptCount ? deptCount: 0;
			Integer unReadViewCount = deptCount > readViewCount ? (deptCount - readViewCount) : 0;
			adminBulletDto.setUnReadViewCount(unReadViewCount);
		}
	}
	
	/**
	 * 设置已读未读数据（无线组织架构）
	 * @param:
	 * @return: 
	 * @auther: 胡坤
	 * @date: 2018/9/26
	 */
	private void setViewCountNewOrg(AdminBulletDto adminBulletDto, Integer bulletId, Operator operator) {
		//统计帖子已读
		AdminBulletViewLogDto adminBulletViewLogDto = adminBulletViewLogMapper.getViewCountByBulletId(bulletId);
		List<AdminBulletDto> bulletList = new ArrayList<AdminBulletDto>();
		AdminBulletDto bulletByBulletId = adminBulletMapper.getBulletByBulletId(bulletId);
		if (null != bulletByBulletId) {
			bulletList.add(bulletByBulletId);
		}
		
		//统计组织人数
		List<OrganizationVO> organizationList = erpFunOrganizationMapper.getOrganizationList(operator.getCityId(), operator.getCompId(), null);
		
		//统计公司人数
		int allCompUserCount = 0;
		List<Integer> partnerIdList = bulletList.stream().filter(a->Integer.valueOf("-1").equals(a.getOrganizationDefinitionId())).collect(Collectors.mapping(AdminBulletDto::getPartnerId, Collectors.toList()));
		List<CompPartnerCountVO> parnterCountList = null;
		Map<Integer,Integer> partnerUserCountMap = new HashMap<>();
		
		Integer readViewCount = adminBulletViewLogDto.getViewCount()!=null?adminBulletViewLogDto.getViewCount():0;//已读
		adminBulletDto.setReadViewCount(readViewCount);
		
		if (partnerIdList!=null && !partnerIdList.isEmpty()) {
			parnterCountList  = erpFunUsersMapper.getCompPartnerCount(operator.getCityId(), operator.getCompId(), partnerIdList);
			parnterCountList.forEach(partner->{
				partnerUserCountMap.put(partner.getPartnerId(), partner.getUserCount());
			});
		}
		for (OrganizationVO organization : organizationList){
			Integer organizationUserNum = organization.getOrganizationUserNum();
			if (organizationUserNum!=null){
				allCompUserCount += organizationUserNum;
			}
		}
		
		String[] orgIds = operator.getOrganizationPath().split(":");
		List<Integer> orgIdList = new ArrayList<>();
		for (String orgIdStr:orgIds) {
			if (StringUtils.isNotBlank(orgIdStr) && !":".equals(orgIdStr)) {
				orgIdList.add(StringUtil.parseInteger(orgIdStr,0));
			}
		}
		ErpFunOrganizationExample example = new ErpFunOrganizationExample();
		example.setShardCityId(operator.getCityId());
		example.createCriteria().andCompIdEqualTo(operator.getCompId()).andDelFlagEqualTo(Byte.valueOf("0"));
		List<ErpFunOrganization> orgList = erpFunOrganizationMapper.selectByExample(example);// 查询所有的组织
		
		// 公司全部组织的map
		Map<Integer, ErpFunOrganization> organizationMapTemp = orgList.stream().filter(org->org.getOrganizationDefinitionId() != null).collect(Collectors.toMap(ErpFunOrganization::getOrganizationId, val -> val));
		
		Map<Integer, Integer> orgAndCountMap = new HashMap<Integer, Integer>();// 公告id为key，组织内人数为value
		for (AdminBulletDto bullet : bulletList) {
			Integer bulletOrganizationId = bullet.getOrganizationId();
			Integer bulletOrganizationDefinitionId = bullet.getOrganizationDefinitionId();
			
			if (null != bulletOrganizationId) {
				int organizationAllUserNum = 0;
				for (ErpFunOrganization erpFunOrganization : orgList) {
					if (erpFunOrganization.getOrganizationPath().indexOf(bulletOrganizationId.toString()) != -1) {
						organizationAllUserNum += erpFunOrganization.getOrganizationUserNum();
					}
				}
				orgAndCountMap.put(bullet.getBulletId(), organizationAllUserNum);
			}
		}
		
		adminBulletDto.setReadViewCount(readViewCount);
		if (Integer.valueOf(-1).equals(adminBulletDto.getOrganizationDefinitionId())) {
			Integer partnerCount = partnerUserCountMap.get(adminBulletDto.getPartnerId());
			partnerCount = null != partnerCount ? partnerCount: 0;
			Integer unReadViewCount = partnerCount > readViewCount ? (partnerCount - readViewCount) : 0;
			adminBulletDto.setUnReadViewCount(unReadViewCount);
		} else if (Integer.valueOf(0).equals(adminBulletDto.getOrganizationDefinitionId())) {
			Integer unReadViewCount = allCompUserCount > readViewCount ? (allCompUserCount-readViewCount) : 0;
			adminBulletDto.setUnReadViewCount(unReadViewCount);
		} else if (Integer.valueOf(1).equals(adminBulletDto.getOrganizationDefinitionId())) {
			Integer orgCount = orgAndCountMap.get(adminBulletDto.getBulletId());
			orgCount = null != orgCount ? orgCount : 0;
			Integer unReadViewCount = orgCount > readViewCount ? (orgCount - readViewCount) : 0;
			adminBulletDto.setUnReadViewCount(unReadViewCount);
		}
	}
	
	private BulletinInfoVo getBulletDetail(BulletinInfoVo bulletinInfoVo, Integer bulletId, Operator operator, Integer isViewStatus) {
		// 更新点击量
		adminBulletService.addClick(bulletId);
		AdminBulletDto adminBulletDto = adminBulletMapper.getBulletByBulletId(bulletId);
		// 判断帖子是否被删除 如果被删除则返回错误
		if (null!=adminBulletDto.getIsDelete() && adminBulletDto.getIsDelete()) {
			throw new ConfirmException("该帖子已经被删除，请刷新列表");
		}
		if(null != adminBulletDto.getYouJiaFlag() && 1 != adminBulletDto.getYouJiaFlag().intValue()) {
			//不是本公司数据
			if (!operator.getAdminCompId().equals(adminBulletDto.getCompId())) {
				throw new ConfirmException("该帖子不存在，请刷新列表");
			}
		}
		Byte bulletBound = adminBulletDto.getBulletBound();
		// 组装数据
		AdminFunDepts adminFunDeptsPO = adminFunDeptsMapper.selectByPrimaryKey(adminBulletDto.getDeptId());
		adminBulletDto.setDeptName((adminFunDeptsPO == null) ? "网络经纪人" : adminFunDeptsPO.getDeptName());
		// 发帖人信息
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(adminBulletDto.getArchiveId());
		if(adminFunArchive != null) {
			adminBulletDto.setUserMobile(adminFunArchive.getUserMobile());
			adminBulletDto.setUserName(adminFunArchive.getUserName());
			adminBulletDto.setBbsName(adminFunArchive.getNickName());
			adminBulletDto.setRealPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getUserPhotoMin()));
			adminBulletDto.setUserPhotoMin(CommonUtil.getBbsPhoto(adminFunArchive.getBbsPhoto()));
			adminBulletDto.setUserRight(adminFunArchive.getUserRight());
			// 是否是付费用户
			Integer isSuperUser = OperatorSessionUtil.isSuperUser(adminFunArchive.getSuperUser(), adminFunArchive.getSuperEnd());
			adminBulletDto.setSuperUser(String.valueOf(isSuperUser));
			// 用户积分
			List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(new Integer[] { adminFunArchive.getArchiveId() });
			if (list != null && list.size() > 0) {
				AdminFunUsersCountDto userScorByArchiveId = list.get(0);
				if (userScorByArchiveId != null) {
					adminBulletDto.setUserScore(userScorByArchiveId.getTotalScore());
				}
			}
		}
		// 查询出当前用的状态 是否被禁言
		String nowDate = DateTimeHelper.formatDatetoString(new Date());
		Integer bulletinStatus = adminBanMapper.getIsBanIng(nowDate, 1, operator.getArchiveId());
		bulletinInfoVo.setBulletinStatus(bulletinStatus);
		if (Byte.valueOf("8").equals(bulletBound) && !operator.newOrganizationType()) {
			String bulletContent = null;
			// 兼容老版
			if ("images/goodNews/01.png".equals(adminBulletDto.getNewsBackUrl())) {
				bulletContent = new StringBuilder()
						.append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-size: 580px 500px;background-position:center center;height:860px;' >")
						.append("<div style='padding:200px 50px 0px;'>").append(adminBulletDto.getNewsBackUrl())
						.append("</div></div>").toString().replaceAll("#NEWS_BACK_URL#", adminBulletDto.getNewsBackUrl());
			} else {
				bulletContent = new StringBuilder()
						.append("<div style='background: url(#NEWS_BACK_URL#) no-repeat;background-size: 580px 500px;background-position:center center;height:500px;' >")
						.append("<div style='padding:170px 80px 0px;'>").append(adminBulletDto.getBulletContent())
						.append("</div></div>").toString().replaceAll("#NEWS_BACK_URL#", adminBulletDto.getNewsBackUrl());
			}
			adminBulletDto.setBulletContent(bulletContent);
		}

		// 获取回复
		PageParam pageParam = new PageParam(1, 50);
		PageInfo<AdminBulletReplyDto> replayBulletinVOs = this.getBulletinReplyList(operator.getArchiveId(), bulletId, pageParam);
		bulletinInfoVo.setReplayList(replayBulletinVOs.getList());
		bulletinInfoVo.setPageRows(replayBulletinVOs.getTotal());
		bulletinInfoVo.setBulletinInfo(adminBulletDto);
		bulletinInfoVo.setClientKey(operator.getClientKey());
		bulletinInfoVo.setBulletBound(!operator.newOrganizationType() ? bulletBound : (null != adminBulletDto.getOrganizationDefinitionId() ? adminBulletDto.getOrganizationDefinitionId().byteValue() : null));
		bulletinInfoVo.setBulletId(bulletId);
		if (operator.isPersonalVersion()) {
			bulletinInfoVo.setAddCommunicInfo(1);
		} else {
			ErpUserOpers userOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "ADD_COMMUNIC_INFO");
			bulletinInfoVo.setAddCommunicInfo((userOpers != null) ? 1 : 0);
		}
		// 是否开启同城交流平台 ALLOW_CITY_BBS，同城交流才需要，现在没有了，就不查了
		String allowCityBbs = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "ALLOW_CITY_BBS");
		bulletinInfoVo.setAllowCityBbs(allowCityBbs);
		// 获取公告附件
//		if (bulletBound == 0 || bulletBound == 1 || bulletBound == 7 || bulletBound == 8) {
			List<AdminBulletinPsDto> bulletinPsPOs = adminBulletinPsMapper.getListByBulletId(bulletId);
			for (AdminBulletinPsDto adminBulletinPs : bulletinPsPOs) {
				Long fileSize = adminBulletinPs.getFileSize();
				adminBulletinPs.setPsPath(CommonUtil.getPhotoUrl(adminBulletinPs.getPsPath()));
				if(fileSize != null && fileSize > 0) {
					String convertFileSize = FileUtil.convertFileSize(fileSize);
					adminBulletinPs.setFileSizeStr(convertFileSize);
				}
				adminBulletinPs.setFileType(this.getFileTypeIcon(adminBulletinPs.getFileName()));
			}
			bulletinInfoVo.setBulletinPsPOs(bulletinPsPOs);
//		}
		boolean isSelfComp = operator.getAdminCompId().equals(adminBulletDto.getCompId());
		boolean isSelfArchive = operator.getArchiveId().equals(adminBulletDto.getArchiveId());
		// 是否可以删除
		boolean canDeleteBulletin = false;
		// 是否可以编辑
		boolean canEditBulletin = false;
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(operator.getCityId(), operator.getUserId(), "MANAGE_ORGANIZATION_BULLET");
		if (operator.newOrganizationType()) {
			if (null != erpUserOpers) {
				canDeleteBulletin = this.canDeleteBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
				canEditBulletin = this.canEditBulletinNewOrg(operator, adminBulletDto, erpUserOpers);
			}
		} else {
			canDeleteBulletin = this.canDeleteBulletin(operator.getCityId(), operator.getUserId(), adminBulletDto.getBulletBound().intValue(),
					isSelfComp, isSelfArchive, operator.getPartnerId());
			canEditBulletin = this.canEditBulletin(operator.getCityId(), operator.getUserId(), bulletBound, isSelfComp, isSelfArchive, operator.getPartnerId());
		}
		adminBulletDto.setCanDelete(canDeleteBulletin ? 1 : 0);
		adminBulletDto.setCanEdit(canEditBulletin ? 1 : 0);

		// you+  已阅修改
		if("1".equals(operator.getYouCompFlag())) {
			adminBulletYouUsersMapper.updateIsView(bulletId, operator.getCityId(), operator.getUserId());
		}
		//查看帖子生成查看记录
		AdminBulletViewLog adminBulletViewLog = new AdminBulletViewLog();
		adminBulletViewLog.setCityId(operator.getCityId());
		adminBulletViewLog.setBulletId(bulletId);
		adminBulletViewLog.setCompNo(operator.getCompNo());
		adminBulletViewLog.setDeptNo(operator.getDeptNo());
		adminBulletViewLog.setErpAreaId(operator.getAreaId());
		adminBulletViewLog.setErpCompId(operator.getCompId());
		adminBulletViewLog.setErpDeptId(operator.getDeptId());
		adminBulletViewLog.setErpGrId(operator.getGrId());
		adminBulletViewLog.setErpRegId(operator.getRegId());
		adminBulletViewLog.setErpUserId(operator.getUserId());
		adminBulletViewLog.setViewTime(new Date());
		adminBulletViewLogMapper.insertSelective(adminBulletViewLog);
		//获取帖子已读未读数据
		if (isViewStatus == 1) {
			if (operator.newOrganizationType()) {
				this.setViewCountNewOrg(adminBulletDto, bulletId, operator);
			} else {
				this.setViewCount(adminBulletDto,bulletId);
			}
		}
		return bulletinInfoVo;
	}
}
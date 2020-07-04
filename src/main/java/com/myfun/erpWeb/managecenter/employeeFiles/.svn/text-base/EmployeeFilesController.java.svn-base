package com.myfun.erpWeb.managecenter.employeeFiles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.employeeFiles.param.DelEmployeeFileParam;
import com.myfun.erpWeb.managecenter.employeeFiles.param.GetEmployeeInfoParam;
import com.myfun.erpWeb.managecenter.employeeFiles.param.GetEnclosureInfoParam;
import com.myfun.erpWeb.managecenter.employeeFiles.param.UploadEmployeeFileParam;
import com.myfun.erpWeb.managecenter.employeeFiles.vo.GetEmployeeFileVo;
import com.myfun.erpWeb.managecenter.param.EmployeeExperienceParam;
import com.myfun.erpWeb.managecenter.vo.ErpFunUserResumeVO;
import com.myfun.erpWeb.statisticalAnalysis.DataAnalysisController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeDocMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeFileMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunUserResumeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSystemSettingLogsMapper;
import com.myfun.repository.erpdb.dto.ErpFunEmployeeDocDto;
import com.myfun.repository.erpdb.dto.ErpFunEmployeeLogDto;
import com.myfun.repository.erpdb.dto.ErpFunUserResumeDto;
import com.myfun.repository.erpdb.dto.ErpSystemSettingLogsDto;
import com.myfun.repository.erpdb.param.ErpFunEmployeeLogParam;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDocExample;
import com.myfun.repository.erpdb.po.ErpFunEmployeeFile;
import com.myfun.repository.erpdb.po.ErpFunUserResume;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunEmployeeDocService;
import com.myfun.service.business.erpdb.ErpFunEmployeeFileService;
import com.myfun.service.business.erpdb.ErpFunUserResumeService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 员工档案
 * @author 熊刚
 * @since 2017年11月3日
 */
@Api(tags = "员工档案模块")
@RestController
@RequestMapping("/manageCenter/employeeFiles")
public class EmployeeFilesController  extends BaseController {
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	@Autowired ErpFunEmployeeFileMapper erpFunEmployeeFileMapper;
	@Autowired ErpFunEmployeeFileService erpFunEmployeeFileService;
	@Autowired ErpFunEmployeeDocService erpFunEmployeeDocService;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired ErpFunEmployeeLogMapper erpFunEmployeeLogMapper;
	@Autowired ErpFunUserResumeMapper erpFunUserResumeMapper;
	@Autowired ErpFunUserResumeService erpFunUserResumeService;
	@Autowired ErpFunUsersService erpFunUsersService;
	
	/**
	 * 员工档案列表
	 * @author 熊刚
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
//	@ApiOperation("员工档案列表,需求:8592，作者:朱科")
//	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunEmployeeDoc.class, message = "成功")})
	@RequestMapping("/getEmployeeFilesList")
	public ResponseJson getCommunicationList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = getOperator().getCityId();
		param.setInteger("compId", operator.getCompId());
		param.setInteger("cityId", cityId);
		DataAnalysisController.changeSerchRange(param);
		String startTime = param.getString("startTime");
		String endTime = param.getString("endTime");
		if (StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)) {
			param.setString("startTime", startTime + " 00:00:00");
			param.setString("endTime", endTime + " 23:59:59");
		}
		// 依据条件查询用户列表
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunEmployeeDocDto> employeeDocDtoList = erpFunEmployeeDocMapper.getEmployeeDocList(cityId,param.getMap());
		PageInfo<ErpFunEmployeeDocDto> pageInfo = new PageInfo<>(employeeDocDtoList);
		if (employeeDocDtoList.size() == 0) {
			return ErpResponseJson.ok(pageInfo);
		}
		// 再查询用户的qq和邮箱，到admin的fun_archive去查
		List<Integer> userIdSet = employeeDocDtoList.stream().collect(Collectors.mapping(ErpFunEmployeeDocDto::getUserId, Collectors.toList()));
		// 先查ErpFunEmployeeDoc
		ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
		docExample.createCriteria().andUserIdIn(userIdSet).andCompIdEqualTo(getOperator().getCompId());
		docExample.setShardCityId(getOperator().getCityId());
		List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
		Map<Integer, ErpFunEmployeeDoc> erpFunEmployeeDocMap = erpFunEmployeeDocList.stream().collect(Collectors.toMap(ErpFunEmployeeDoc::getUserId, val -> val));
		// 组装数据
		for (ErpFunEmployeeDocDto erpFunEmployeeDocDto : employeeDocDtoList) {
			ErpFunEmployeeDoc erpFunEmployeeDoc = erpFunEmployeeDocMap.get(erpFunEmployeeDocDto.getUserId());
			List<ErpFunEmployeeLogDto> resultList = erpFunEmployeeLogMapper.getLogListByEmployeeId(cityId,erpFunEmployeeDoc.getId());
			if (resultList.size() > 0) {
				erpFunEmployeeDocDto.setChanges(DateTimeHelper.formatDateTimetoString(resultList.get(0).getCreationTime(), DateTimeHelper.FMT_yyyyMMdd) + " " +resultList.get(0).getContent());
			}
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取详情
	 * @author 熊刚
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取档案详情,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunEmployeeDocDto.class, message = "成功")})
	@RequestMapping("/getEmployeeInfo")
	public ResponseJson getEmployeeInfo(@RequestBody GetEmployeeInfoParam param) {
		Operator operator = getOperator();
		Integer userId = param.getUserId();
		Integer cityId = operator.getCityId();
		ErpFunUsers erpFunUsers = new ErpFunUsers();
		erpFunUsers.setUserId(userId);
		erpFunUsers.setShardCityId(cityId);
		erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		if(null == erpFunUsers){
			return ErpResponseJson.ok();
		}

		boolean newOrganizationType = operator.newOrganizationType();
		ErpFunEmployeeDoc employeeInfo = null;
		if(newOrganizationType) {
			 employeeInfo = erpFunEmployeeDocService.getEmployeeInfoNewOrg(cityId, operator.getCompId(), erpFunUsers);
		}else {
			employeeInfo = erpFunEmployeeDocService.getEmployeeInfo(cityId, operator.getCompId(), erpFunUsers);
		}

		return ErpResponseJson.ok(employeeInfo);
	}

	/**
	 * 删除员工档案文件
	 * @author flj
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
	@ApiOperation("删除员工档案文件,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ResponseJson.class, message = "成功")})
	@RequestMapping("/delEmployeeFile")
	public ResponseJson delEmployeeFile(@RequestBody DelEmployeeFileParam param) {
		Operator operator = getOperator();
		String fileIds = param.getFileIds();
		Integer refrenceUserId = param.getRefrenceUserId();
		if (StringUtils.isNotBlank(fileIds)) {
			Integer compId = operator.getCompId();
			Integer deptId = operator.getDeptId();
			Integer userId = operator.getUserId();
			erpFunEmployeeFileService.delEmployeeFile(operator.getCityId(), fileIds.split(","), compId, deptId, userId, refrenceUserId);
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取员工档案附件
	 * @author xiongang
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取员工档案附件,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = GetEmployeeFileVo.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/getEmployeeFile")
	public ResponseJson getEnclosureInfo(@RequestBody GetEnclosureInfoParam param) {
		List<ErpFunEmployeeFile> erpFunEmployeeFileList = erpFunEmployeeFileMapper.getEmployeeFile(getOperator().getCityId(), getOperator().getCompId(), param.getEmployeeDocId());
		for (ErpFunEmployeeFile erpFunEmployeeFile : erpFunEmployeeFileList) {
			String employeeFileUrl = erpFunEmployeeFile.getFileUrl();
			erpFunEmployeeFile.setFileUrl(CommonUtil.getPhotoUrl(employeeFileUrl));
		}
		GetEmployeeFileVo employeeFileVo = new GetEmployeeFileVo();
		employeeFileVo.setErpFunEmployeeFileList(erpFunEmployeeFileList);
		return ErpResponseJson.ok(employeeFileVo);
	}
	
	/**
	 * 获取员工动态
	 * @author xiongang
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getEnclosureLogs")
	public ResponseJson getEnclosureLogs(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer userId = param.getInteger("userId");
		PageInfo<ErpFunEmployeeLogDto> pageInfoList = erpFunEmployeeFileService.getEnclosureLogs(operator.getCityId(), operator.getCompId(), userId, param);
		return ErpResponseJson.ok(pageInfoList);
	}
	
	/**
	 * 获取单个员工修改记录
	 *@author 朱科
	 *@param 
	 *@return ResponseJson
	 *@since 2018年2月5日
	 */
	@RequestMapping("/getPersonalModifyRecordList")
	public ResponseJson getPersonalModifyRecordList(@Valid @RequestBody BaseMapParam param){
		Operator operator = getOperator();
		Integer userId = param.getInteger("userId");
		ErpFunEmployeeDoc erpFunEmployeeDoc = erpFunEmployeeDocMapper.getErpFunEmployeeDocByUserId(operator.getCityId(), operator.getCompId(), userId);
		if(null == erpFunEmployeeDoc){
			return ErpResponseJson.ok();
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpSystemSettingLogsDto> erpSystemSettingLogsList = erpSystemSettingLogsMapper.getEnclosureLogs(
				getOperator().getCityId(), getOperator().getCompId(), erpFunEmployeeDoc.getArchiveId(), 1);
		
		// story#11536 PC跨城管理-查询人员的组织信息
		Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = null;
		if (!erpSystemSettingLogsList.isEmpty()) {
			List<Integer> userIdList = erpSystemSettingLogsList.stream().map(ErpSystemSettingLogsDto :: getCreateUid).collect(Collectors.toList());
			if (!userIdList.isEmpty()) {
				userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(operator.getCityId(), userIdList);
			}
		}
		
		for (ErpSystemSettingLogsDto erpSystemSettingLogsDto : erpSystemSettingLogsList) {
			// 判断设置对比标记
			if (erpSystemSettingLogsDto.getAfterModification() != null
					|| erpSystemSettingLogsDto.getBeforeModification() != null) {
				erpSystemSettingLogsDto.setContrastMark(1);
			}
			
			if (null != userOrganizationInfoMap) {
				UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(erpSystemSettingLogsDto.getCreateUid());
				if (null != userOrganizationInfoVO) {
					erpSystemSettingLogsDto.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
					erpSystemSettingLogsDto.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
					erpSystemSettingLogsDto.setCompName(userOrganizationInfoVO.getCompName());
				}
			}
		}
		PageInfo<ErpSystemSettingLogsDto> pageInfo = new PageInfo<>(erpSystemSettingLogsList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	
	/**
	 * 获取对比信息
	 * @author xiongang
	 * @since 2017年11月3日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getChangeEnclosureLogs")
	public ResponseJson getChangeEnclosureLogs(@RequestBody BaseMapParam param) {
		ErpSystemSettingLogsDto erpSystemSettingLogs = erpSystemSettingLogsMapper
				.getChangeEnclosureLogs(getOperator().getCityId(), param.getInteger("systemSettingLogsId"));
		String afterModificationStr = erpSystemSettingLogs.getAfterModification();
		String beforeModificationStr = erpSystemSettingLogs.getBeforeModification();
		Map<String, Object> returnMap = new HashMap<>();
		if (StringUtils.isNotBlank(afterModificationStr)) {
			Map<String, Object> afterDataMap = JSON.parseObject(afterModificationStr, Map.class);
			returnMap.put("newVal", afterDataMap.get("EMPLOYEE_DOC_DATA"));
		}
		if (StringUtils.isNotBlank(beforeModificationStr)) {
			Map<String, Object> beforeModificationMap = JSON.parseObject(beforeModificationStr, Map.class);
			returnMap.put("oldVal", beforeModificationMap.get("EMPLOYEE_DOC_DATA"));
		}
		return ErpResponseJson.ok(returnMap);
	}
	
	/**
	 * 员工异动记录
	 * @author 朱科
	 * @since 2017年12月28日
	 * @param 
	 * @return
	 */
	@RequestMapping("/getEmployeeLogList")
	public ResponseJson getEmployeeLogList(@RequestBody ErpFunEmployeeLogParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setNewOrganization(operator.newOrganizationType());
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunEmployeeLogDto> employeeLogList = erpFunEmployeeLogMapper.getEmployeeLogList(cityId, param, compId);
		PageInfo<ErpFunEmployeeLogDto> pageInfo = new PageInfo<>(employeeLogList);
		ErpResponseJson ok = new ErpResponseJson(pageInfo);
		ok.setData(employeeLogList);
		return ok;
	}

	/**
	 * 获取员工历程列表
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/8
	 */
    @ApiOperation("获取员工历程列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunUserResumeVO.class, message = "成功")
    })
	@PostMapping("/getUserResumeList")
	@NotBlank(value={"userId"})
	public ResponseJson getUserResumeList(@RequestBody EmployeeExperienceParam param) {
		Integer userId= param.getUserId();
		Integer compId=getOperator().getCompId();
		Integer cityId=getOperator().getCityId();
		ErpFunUsers erpFunUsers=erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
		AdminFunArchive adminFunArchive=adminFunArchiveMapper.getArchiveById(erpFunUsers.getArchiveId());
		List<ErpFunUserResumeDto> erpFunUserResumeList=erpFunUserResumeMapper.getUserResumeList(cityId,compId,userId);
		erpFunUserResumeList.stream().forEach(erpFunUserResumeDto->{
			erpFunUserResumeDto.setUserPhoto(CommonUtil.getBbsPhoto(adminFunArchive.getUserPhoto()));
		});
		return ErpResponseJson.ok(erpFunUserResumeList);
	}

	/**
	 * 添加员工历程
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/8
	 */
	@ApiOperation("添加员工历程")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response=ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/addOrUpdateUserResume")
	@NotBlank(value={"userId","occurrenceTime"})
	public ResponseJson addOrUpdateUserResume(@RequestBody EmployeeExperienceParam param) {
		Integer id = param.getId();
		Integer userId = param.getUserId();
		String occurrenceTime = param.getOccurrenceTime();
		String eventExplain = param.getEventExplain();
		Integer compId = getOperator().getCompId();
		Integer userIdSelf = getOperator().getUserId();
		Integer cityId = getOperator().getCityId();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
		Integer archiveId = erpFunUsers.getArchiveId();
		erpFunUserResumeService.addOrUpdateUserResume(cityId,compId,userId,id,userIdSelf,archiveId,occurrenceTime,eventExplain);
		return ErpResponseJson.ok();
	}

	/**
	 * 删除员工历程
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/8
	 */
	@ApiOperation("删除员工历程")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS,response=ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/delUserResume")
	@NotBlank(value={"id"})
	public ResponseJson delUserResume(@RequestBody EmployeeExperienceParam param) {
		Integer id=param.getId();
		ErpFunUserResume erpFunUserResume=new ErpFunUserResume();
		erpFunUserResume.setId(id);
		erpFunUserResume.setShardCityId(getOperator().getCityId());
		erpFunUserResume.setIsDel((byte)1);
		erpFunUserResumeMapper.updateByPrimaryKeySelective(erpFunUserResume);
		return ErpResponseJson.ok();
	}
	
	

	/**
	 * 掌通上传员工档案附件使用接
	 * @author 朱科
	 * @since 2018年11月20日
	 * @return
	 */
	@ApiOperation("掌通上传员工档案附件使用接口,需求:8592，作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpFunEmployeeFile.class, message = "成功")})
	@ResponseBody
	@RequestMapping("/uploadEmployeeFile")
	public ResponseJson uploadEmployeeFile(@RequestBody UploadEmployeeFileParam param) {
		Operator operator = getOperator();
		param.setCreatorUid(operator.getUserId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		if(param.getArchiveId() == null) {
			param.setArchiveId(operator.getArchiveId());
		}
		List<ErpFunEmployeeFile> uploadEmployeeFiles = erpFunEmployeeFileService.uploadEmployeeFile(param);
		// ERP
		if(uploadEmployeeFiles != null && uploadEmployeeFiles.size() > 0){
			for (ErpFunEmployeeFile erpFunEmployeeFile : uploadEmployeeFiles) {
				erpFunEmployeeFile.setFileUrl(StringUtil.getBbsPhoto(erpFunEmployeeFile.getFileUrl()));
			}
			
		}
		Map<String,Object> returnData = new HashMap<String,Object>();
		returnData.put("staffPhotoList", uploadEmployeeFiles);
		return ErpResponseJson.ok(returnData);
	}
}

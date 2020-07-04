package com.myfun.erpWeb.businesstools.vcard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.param.EcardsByDataParam;
import com.myfun.erpWeb.businesstools.vcard.param.PerCreateEcardsParam;
import com.myfun.erpWeb.businesstools.vcard.param.PerEcardsParam;
import com.myfun.erpWeb.businesstools.vcard.param.PerUpdateEcardsParam;
import com.myfun.erpWeb.businesstools.vcard.vo.PerEcardsVo;
import com.myfun.erpWeb.businesstools.vo.BusinessTooleCardListVo;
import com.myfun.erpWeb.businesstools.vo.EcardsByDataVo;
import com.myfun.erpWeb.statisticalAnalysis.DataAnalysisController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunUserMessageMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpFunEcardsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpFunEcardsDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.po.ErpFunEcards;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunEcardsService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateErpFunEcardsParam;
import com.myfun.service.business.erpdb.bean.param.QueryVcardListParam;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
* @ClassName: FunVcardController 
* @Description: (业务工具电子名片接口类) 
* @author 方李骥
* @date 2016-9-24 下午5:47:27
 */
@RequestMapping(value="/businesstools/vCard",method=RequestMethod.POST)
@RestController
public class FunVcardController extends BaseController{
	@Autowired
	ErpFunEcardsMapper erpFunEcardsMapper;
	@Autowired
	ErpFunEcardsService erpFunEcardsService;
	@Autowired
	AdminFunUserMessageMapper adminFunUserMessageMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;

	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: getBusinessTooleCardList 
	* @Description: (查询电子名片列表) 
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@ApiOperation("查询电子名片列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BusinessTooleCardListVo.class, message = "成功")
	})
	@RequestMapping("/getBusinessTooleCardList")
	public ResponseJson getBusinessTooleCardList(@RequestBody QueryVcardListParam param) throws Exception{
		Operator operator = getOperator();
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(operator.getUserName());
		param.setCurrentDeptId(operator.getDeptId());
		param.setCityId(operator.getCityId());
		param.setCompId(operator.getCompId());
		param.setCurrentUserId(operator.getUserId());
		param.setIsPerLogin(operator.isPerLogin());
		param.setArchiveId(operator.getArchiveId());
		if(!StringUtil.isBlank(param.getQueryKey())){//有查询关键字
			if("comp".equals(param.getQueryFor())){
				param.setEcardsComp("%"+param.getQueryKey()+"%");
			}else if("name".equals(param.getQueryFor())){
				param.setEcardsName("%"+param.getQueryKey()+"%");
			}else if("tele".equals(param.getQueryFor())){
				param.setEcardsTel("%"+param.getQueryKey()+"%");
			}else{
				param.setEcardsPost("%"+param.getQueryKey()+"%");
			}
		}
		if(!operator.isPerLogin()) {
			boolean isPublic = erpUserOpersMapper.selectPerPermissionByName(param.getCityId(), param.getCurrentUserId(),"BIZ_CARD_MANAGE") != null;
			if(!isPublic) {
				param.setIsPublic(false);
			}
		}
		PageHelper.startPage(param.getPageOffset(),param.getPageRows(),true);
		List<ErpFunEcardsDto> listCard = erpFunEcardsMapper.getBusinessTooleCardList(param.getCityId(),param);
		PageInfo<ErpFunEcardsDto> pageInfo = new PageInfo<ErpFunEcardsDto>(listCard);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: getEcardsByData 
	* @Description: (获取电子名片详情) 
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@ApiOperation("获取电子名片详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = EcardsByDataVo.class, message = "成功")
	})
	@RequestMapping("/getEcardsByData")
	public ResponseJson getEcardsByData(@RequestBody EcardsByDataParam param) throws Exception{
		ErpFunEcards erpFunEcards = new ErpFunEcards();	
		erpFunEcards.setEcardId(param.getEcardId());
		erpFunEcards.setShardCityId(getOperator().getCityId());
		ErpFunEcards returnData = erpFunEcardsMapper.selectByPrimaryKey(erpFunEcards);
		return ErpResponseJson.ok(returnData);
	}
	
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: insertEcards 
	* @Description: (插入电子名片) 
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/insertEcards")
	public ResponseJson insertEcards(@RequestBody CreateOrUpdateErpFunEcardsParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setArchiveId(getOperator().getArchiveId());
		erpFunEcardsService.insertErpFunEcards(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: editEcards 
	* @Description: (编辑电子名片) 
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/editEcards")
	public ResponseJson editEcards(@RequestBody CreateOrUpdateErpFunEcardsParam param) throws Exception{
		param.setCityId(getOperator().getCityId());
		erpFunEcardsService.updateErpFunEcards(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: delEcardsById 
	* @Description: (删除电子名片) 
	* @param param
	* @return
	* @throws Exception
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/delEcardsById")
	public ResponseJson delEcardsById(@RequestBody BaseMapParam param) throws Exception{
		ErpFunEcards erpFunEcards = new ErpFunEcards();	
		erpFunEcards.setEcardId(param.getInteger("ecardId"));
		erpFunEcards.setShardCityId(getOperator().getCityId());
		erpFunEcardsService.deleteByPrimaryKey(erpFunEcards);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取员工通讯录列表
	 * @author 张宏利
	 * @since 2017年9月29日
	 * @param param
	 * userStatus	1=在职，2=注销，3=调店
	 * serchRange	查询范围 COMP,AREA,REG,DEPT
	 * serchRangeId	查询范围ID
	 * matchStr	模糊匹配字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getCommunicationList")
	public ResponseJson getCommunicationList(@RequestBody BaseMapParam param) {
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("cityId", getOperator().getCityId());
		DataAnalysisController.changeSerchRange(param);
		String matchStr = param.getString("matchStr");
		if(StringUtils.isNotBlank(matchStr)) {
			param.setString("matchStr", "%" + matchStr + "%");
		}
		// 依据条件查询用户列表
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunUsersDto> userList = erpFunUsersMapper.getCommunicationList(getOperator().getCityId(), param.getMap());
		PageInfo<ErpFunUsersDto> pageInfo = new PageInfo<>(userList);
		if(userList == null || userList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		// 再查询用户的qq和邮箱，到admin的fun_archive去查
		List<Integer> archiveIdSet = userList.stream().collect(Collectors.mapping(ErpFunUsersDto::getArchiveId, Collectors.toList()));
		List<AdminFunArchive> archiveInfos = adminFunArchiveMapper.getArchiveInfosByIds(archiveIdSet);
		Map<Integer, AdminFunArchive> archiveMap = archiveInfos.stream().collect(Collectors.toMap(AdminFunArchive::getArchiveId, val -> val));
		for (ErpFunUsersDto erpFunUsers : userList) {
			AdminFunArchive funArchive = archiveMap.get(erpFunUsers.getArchiveId());
			if(funArchive != null) {
				erpFunUsers.setUserQq(funArchive.getUserQq());
				erpFunUsers.setUserEmail(funArchive.getUserEmail());
			}
		}
		return ErpResponseJson.ok(pageInfo);
	}
	
	@ApiOperation("精英版查询名片列表，有分页")
	@ApiResponses(value = {@ApiResponse(code = 200, response = PerEcardsVo.class, message = "成功")})
	@RequestMapping("/getEcardsLists")
	public ResponseJson getEcardsLists(@RequestBody PerEcardsParam param){
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		PerEcardsVo perEcardsVo = new PerEcardsVo();
		String queryKey = param.getQueryKey();
		String queryFor = param.getQueryFor();
		if("_".equals(queryKey)){
			return ErpResponseJson.ok(perEcardsVo);
		}
		if(!"".equals(queryKey)){
			if("comp".equals(queryFor)){
				param.setEcardsComp("%" + queryKey + "%");
			} else if("name".equals(queryFor)){
				param.setEcardsName("%" + queryKey + "%");
			} else if("tele".equals(queryFor)){
				param.setEcardsTel("%" + queryKey + "%");
			} else {
				param.setEcardsPost("%" + queryKey + "%");
			}
		}
		PageHelper.startPage(param.getPageOffset(),param.getPageRows(),true);
		List<ErpFunEcardsDto> ecardsList = erpFunEcardsMapper.getEcardsLists(cityId, compId, operator.getArchiveId(), param);
		perEcardsVo.setFunEcardsList(ecardsList);
		return ErpResponseJson.ok(ecardsList);
	}
	
	@ApiOperation("添加一条名片信息")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/createEcards")
	public ResponseJson createEcards(@RequestBody PerCreateEcardsParam param){
		Operator operator = getOperator();
		ErpFunEcards erpFunEcards = new ErpFunEcards();
		BeanUtils.copyProperties(param, erpFunEcards);
		erpFunEcards.setCompId(operator.getCompId());
		erpFunEcards.setDeptId(operator.getDeptId());
		erpFunEcards.setArchiveId(operator.getArchiveId());
		erpFunEcards.setCreateTime(DateTimeHelper.getTimeNow());
		erpFunEcards.setEcardsTel(param.getPhone());
		if(null == erpFunEcards.getIsPublic()){
			erpFunEcards.setIsPublic(param.getIsPublic());
		}
		erpFunEcards.setShardCityId(operator.getCityId());
		erpFunEcardsMapper.insertSelective(erpFunEcards);
		return ErpResponseJson.ok();
	}
	
	@ApiOperation("修改名片信息是否公开")
	@ApiResponses(value = {@ApiResponse(code = 200, response = ErpResponseJson.class, message = "成功")})
	@RequestMapping("/updateEcardsPublic")
	public ResponseJson updateEcardsPublic(@RequestBody PerUpdateEcardsParam param){
		Operator operator = getOperator();
		ErpFunEcards erpFunEcards = new ErpFunEcards();
		erpFunEcards.setCompId(operator.getCompId());
		erpFunEcards.setShardCityId(operator.getCityId());
		erpFunEcards.setEcardId(param.getEcardId());
		if(null != param.getIsPublic() && !param.getIsPublic()){
			erpFunEcards.setIsPublic(false);
		}
		erpFunEcardsMapper.updateByPrimaryKeySelective(erpFunEcards);
		return ErpResponseJson.ok();
	}
}



package com.myfun.erpWeb.managecenter.transaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.transaction.param.DealFunEarbestMoneyDetailParam;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.erpWeb.managecenter.transaction.vo.EarbestMoneyListVo;
import com.myfun.erpWeb.managecenter.transaction.vo.MatchInnerDealListVo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyrecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.param.QueryDealListParam;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunDealExample;
import com.myfun.repository.erpdb.po.ErpFunDealExample.Criteria;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecord;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecordExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunEarbestMoneyService;
import com.myfun.service.business.erpdb.OldErpFunEarbestMoneyService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;
import com.myfun.utils.DateTimeHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//import com.myfun.erpWeb.managecenter.transaction.param.ErpDealEarbestMoneyParam;

/**
* @ClassName: EarnestMoneyController 
* @Description: 跟进日志
* @author 方李骥
* @date 2017-02-06 10:12:30
 */
@Api(tags ="诚意金管理模块Old")
@RestController
@RequestMapping("/managerCenter/transaction/earbestMoney")
public class OldEarnestMoneyController extends BaseController {
	@Autowired
	OldErpFunEarbestMoneyService erpFunEarbestMoneyService;
	@Autowired
    ErpEarbestMoneyMapper erpEarbestMoneyMapper;
	@Autowired
    ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired
    ErpFunBillMapper erpFunBillMapper;
	@Autowired
    ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
	@Autowired
    ErpFunBillCodelogService erpFunBillCodelogService;
	@Autowired
    ErpFunDealMapper erpFunDealMapper;
	@Autowired
    ErpFunUsersMapper erpFunUsersMapper;

	/**
	 * 查询诚意金列表
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("查询诚意金列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = EarbestMoneyListVo.class, message = "成功")
	})
	@RequestMapping("/getEarbestMoneyList")
	public ErpResponseJson getEarbestMoneyList(@Valid @RequestBody QueryErpEarbestMoneyListParam param) throws Exception {
		List<ErpFunEarbestMoneyDto> resList = getList(1, param);
		PageInfo<ErpFunEarbestMoneyDto> page = new PageInfo<>(resList);
		return ErpResponseJson.ok(page);
	}

	/**
	 * title ：分页查询和列表查询
	 * athor：lcb
	 * date  : 2017/10/26
	 */
	private List<ErpFunEarbestMoneyDto> getList(Integer isPageQuery, QueryErpEarbestMoneyListParam param ) {
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());
		if(1 == isPageQuery) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		}
		List<ErpFunEarbestMoneyDto> list =  erpEarbestMoneyMapper.selectEarbestMoneyList(param.getCityId(),param);
		List<Integer> userIds = new ArrayList<>();
		if(null != list && !list.isEmpty()){
			List<Integer> receiptUserIds = list.stream().filter(val -> null != val.getReceiptUserId()).collect(Collectors.mapping(ErpFunEarbestMoneyDto::getReceiptUserId, Collectors.toList()));
			userIds.addAll(receiptUserIds);
			List<Integer> createUserIds = list.stream().filter(val -> null != val.getCreateUser()).collect(Collectors.mapping(ErpFunEarbestMoneyDto::getCreateUser, Collectors.toList()));
			userIds.addAll(createUserIds);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getErpFunUsersList(param.getCityId(), userIds);
			Map<Integer, ErpFunUsers> userMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val ->val));
			for(ErpFunEarbestMoneyDto erpFunEarbestMoneyDto : list){
				Integer createUser = erpFunEarbestMoneyDto.getCreateUser();
				ErpFunUsers createFunUsers = userMap.get(createUser);
				if(null != createFunUsers){
					erpFunEarbestMoneyDto.setCreateGrId(createFunUsers.getGrId());
					erpFunEarbestMoneyDto.setCreateDeptId(createFunUsers.getDeptId());
				}
				Integer receiptUserId = erpFunEarbestMoneyDto.getReceiptUserId();
				ErpFunUsers receiptFunUsers = userMap.get(receiptUserId);
				if(null != receiptFunUsers){
					erpFunEarbestMoneyDto.setReceiptGrId(receiptFunUsers.getGrId());
				}
			}
		}
		return list;
	}

	/**
	 * 查询诚意金列表-导出
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getEarbestMoneyListForExport")
	public ErpResponseJson getEarbestMoneyListForExport(@Valid @RequestBody QueryErpEarbestMoneyListParam param) throws Exception {
		List<ErpFunEarbestMoneyDto> list = getList(0, param);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 新增诚意金
	 * flj 2017-02-06
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/createDealFunEarbestMoney")
	public ErpResponseJson createDealFunEarbestMoney(@Valid @RequestBody CreateOrUpdateEarbestMoneyParam param) throws Exception {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setAreaId(operator.getAreaId());
		param.setRegId(operator.getRegId());
		param.setGrId(operator.getGrId());
		erpFunEarbestMoneyService.createDealFunEarbestMoney(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 编辑诚意金
	 * flj 2017-10-12
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateEarbestMoney")
	public ErpResponseJson updateEarbestMoney(@Valid @RequestBody CreateOrUpdateEarbestMoneyParam param) {
		Operator operator = getOperator();
		param.setCityId(operator.getCityId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setCompId(operator.getCompId());
		param.setDeptName(operator.getDeptCName());
		ErpFunEarbestMoney updateModel = getParamObj(ErpFunEarbestMoney.class);
		erpFunEarbestMoneyService.updateEarbestMoney(param, updateModel);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 删除诚意金
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteEarbestMoney")
	@NotBlank({"earbestId"})
	public ErpResponseJson deleteEarbestMoney(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId",getOperator().getCityId());
		erpFunEarbestMoneyService.deleteEarbestMoney(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 修改诚意金状态
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @param status:诚意金状态 （0待确认,1已收,2已退,3转定金）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateEarbestMoneyStatus")
	@NotBlank({"earbestId","status"})
	public ErpResponseJson updateEarbestMoneyStatus(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId",getOperator().getCityId());
		param.setInteger("userId",getOperator().getUserId());
		param.setString("userName",getOperator().getUserName());
		param.setInteger("deptId", getOperator().getDeptId());
		param.setString("deptName", String.valueOf(getOperator().getAttribute("DEPT_CNAME")));
		erpFunEarbestMoneyService.updateEarbestMoneyStatus(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取诚意金详情
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取诚意金详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunEarbestMoneyDto.class, message = "成功")
	})
	@RequestMapping("/getDealFunEarbestMoneyDetail")
	@NotBlank({"earbestId"})
	public ErpResponseJson getDealFunEarbestMoneyDetail(@Valid @RequestBody DealFunEarbestMoneyDetailParam param) throws Exception {
		ErpFunEarbestMoneyDto result = erpEarbestMoneyMapper.selectEarbestMoneyDetail(getOperator().getCityId(),param.getEarbestId());
		String billPhotoUrl = result.getBillPhoto();
		result.setBillPhoto(CommonUtil.getHousePhoto(billPhotoUrl));
		// dyh 增加返回值archiveId  IM用
		Set<Integer> userIdSet = new HashSet<>();
		userIdSet.add(result.getReceiptUserId());//收款人
		userIdSet.add(result.getCreateUser()); //登记人
		userIdSet.add(result.getConfirmUserId()); //确认人
		userIdSet.add(result.getDepositUserId());//转定金人
		userIdSet.add(result.getRefundUserId()); //退款人
		if (userIdSet.isEmpty()) {
			return ErpResponseJson.ok(result);
		}
		List<ErpFunUsers> usersList = erpFunUsersMapper.getUserListByUserIds(getOperator().getCityId(), userIdSet);
		Map<Integer, Integer> archiveIdMap = usersList.stream().collect(Collectors.toMap(user -> user.getUserId(), user -> user.getArchiveId()));
		result.setCreateArchiveId(archiveIdMap.get(result.getCreateUser()));
		result.setReceiptArchiveId(archiveIdMap.get(result.getReceiptUserId()));
		result.setConfirmArchiveId(archiveIdMap.get(result.getConfirmUserId()));
		result.setDepositArchiveId(archiveIdMap.get(result.getDepositUserId()));
		result.setRefundArchiveId(archiveIdMap.get(result.getRefundUserId()));
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 获取诚意金详情
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkDealReceiptNoRepeat")
	@NotBlank({"earbestId"})
	public ErpResponseJson checkDealReceiptNoRepeat(@Valid @RequestBody BaseMapParam param) throws Exception {
		param.setInteger("cityId",getOperator().getCityId());
		ErpFunEarbestMoneyDto result = erpEarbestMoneyMapper.selectEarbestMoneyDetail(param.getInteger("cityId"),param.getInteger("earbestId"));
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 获取诚意金日志列表
	 * flj 2017-02-06
	 * @param earbestId:诚意金Id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getEarbestMoneyLogList")
	@NotBlank({"earbestId"})
	public ErpResponseJson getEarbestMoneyLogList(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer earbestId = param.getInteger("earbestId");
		Integer cityId = getOperator().getCityId();
		ErpFunEarbestMoneyrecordExample example = new ErpFunEarbestMoneyrecordExample();
		example.setShardCityId(cityId);
		example.setOrderByClause("CREATE_TIME DESC");
		example.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andEarbestIdEqualTo(earbestId);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunEarbestMoneyrecord> recordList = erpFunEarbestMoneyrecordMapper.selectByExample(example);
		PageInfo<ErpFunEarbestMoneyrecord> pageInfo = new PageInfo<ErpFunEarbestMoneyrecord>(recordList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * @tag 删除诚意金
	 * @author 邓永洪
	 * @since 2018/5/29
	 */
	@RequestMapping("/deleteDealFunEarbestMoney")
	public ErpResponseJson deleteDealFunEarbestMoney(@RequestBody BaseMapParam param) {
		GeneralParam generalParam = new GeneralParam(getOperator());
		Integer earbestId = param.getInteger("earbestId");
		erpFunEarbestMoneyService.deleteDealFunEarbestMoney(generalParam, earbestId);
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 修改诚意金状态
	 * @author 邓永洪
	 * @since 2018/7/24
	 */
	@ApiOperation("修改诚意金状态")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@PostMapping("/updateDealFunEarbestMoney")
	public ErpResponseJson updateDealFunEarbestMoney(@RequestBody updateDealFunEarbestParam param) {
		Operator operator = getOperator();
		ErpFunEarbestMoney earbestMoney = new ErpFunEarbestMoney();
		earbestMoney.setEarbestId( param.getEarbestId());
		earbestMoney.setShardCityId(operator.getCityId());
		earbestMoney=erpFunEarbestMoneyMapper.selectByPrimaryKey(earbestMoney);
		ErpFunBillExample billExample=new ErpFunBillExample();
		billExample.setShardCityId(operator.getCityId());
		ErpFunBillExample.Criteria billExampleCriteria = billExample.createCriteria();
		billExampleCriteria.andEarbestIdEqualTo(param.getEarbestId());
		String currUserName = getCurrentUserName();

		param.setCompId(operator.getCompId());
		param.setDeptId(operator.getDeptId());
		param.setUserId(operator.getUserId());
		param.setUserName(operator.getUserName());
		param.setCityId(operator.getCityId());
		erpFunEarbestMoneyService.updateDealFunEarbestMoney(param, earbestMoney, currUserName);
		return ErpResponseJson.ok();
	}
	
	
//	@RequestMapping("/getDealFunEarbestMoneyList")
//	public ErpResponseJson getDealFunEarbestMoneyList(@RequestBody ErpDealEarbestMoneyParam param){
//		param.setSelfCompId(getOperator().getCompId());
//		param.setSelfCityId(getOperator().getCityId());
//		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
////		erpEarbestMoneyMapper
//		return ErpResponseJson.ok();
//	}
	
	/**
	 * 诚意金详情转定金列表
	 * @author HeWei
	 * @since 2018年7月27日 上午11:43:02
	 * @param param
	 * @return
	 * Modified XXX HeWei 2018年7月27日
	 */
	@ApiOperation("诚意金详情转定金列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MatchInnerDealListVo.class, message = "成功")
	})
	@PostMapping("/getMatchInnerDealList")
	public ErpResponseJson getMatchInnerDealList(@RequestBody QueryDealListParam param) {
		QueryDealListParam queryDealListParam = getParamObj(QueryDealListParam.class);
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		ErpFunDealExample erpFunDealExample = new ErpFunDealExample();
		erpFunDealExample.setOrderByClause(" SIGN_DATE DESC,DEAL_ID DESC");
		erpFunDealExample.setShardCityId(cityId);
		Criteria createCriteria = erpFunDealExample.createCriteria();
		createCriteria.andCompIdEqualTo(compId).andIsbyhandEqualTo((byte)0);

		if (!CommonUtil.isnull(queryDealListParam.getUserId())) {
			createCriteria.andSignUserIdEqualTo(queryDealListParam.getUserId());
		}

		if (!CommonUtil.isnull(queryDealListParam.getDeptId())) {
			createCriteria.andSignUserDeptIdEqualTo(queryDealListParam.getDeptId());
		}
		if (!CommonUtil.isnull(queryDealListParam.getCaseType())) {
			createCriteria.andDealTypeEqualTo(Byte.valueOf(queryDealListParam.getCaseType()));
		}
		if (!CommonUtil.isnull(queryDealListParam.getContractNo())) {
			createCriteria.andContractNoEqualTo(queryDealListParam.getContractNo());
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunDeal> list = erpFunDealMapper.selectByExample(erpFunDealExample);
		for (ErpFunDeal erpFunDeal : list) {
			if (erpFunDeal.getDealType()!=null && erpFunDeal.getDealType()==101) {
				erpFunDeal.setHouseaddress("[售]"+erpFunDeal.getHouseaddress());
			}else{
				erpFunDeal.setHouseaddress("[租]"+erpFunDeal.getHouseaddress());
			}
		}
		PageInfo<ErpFunDeal> pageInfo = new PageInfo<>(list);
		MatchInnerDealListVo resultVo = new MatchInnerDealListVo(pageInfo);
		return ErpResponseJson.ok(resultVo);
	}

}

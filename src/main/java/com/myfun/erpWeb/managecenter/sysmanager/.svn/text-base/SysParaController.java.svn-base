package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.managecenter.sysmanager.param.*;
import com.myfun.erpWeb.managecenter.sysmanager.vo.*;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.taskJob.AsyncTask;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDeptsExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 系统参数控制接口
 * @author 张宏利
 * @since 2017年10月16日
 */
@RestController
@RequestMapping("/managerCenter/sysPara")
public class SysParaController extends BaseController {
	@Autowired ErpSysParaService erpSysParaService;
	@Autowired ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired ErpAuditTemplateService erpAuditTemplateService;
	@Autowired ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired ErpAuditRuntimeService erpAuditRuntimeService;
	@Autowired ErpAuditRuntimeMapper erpAuditRuntimeMapper;
	@Autowired ErpAuditTrackMapper erpAuditTrackMapper;
	@Autowired ErpAuditUserRuntimeMapper erpAuditUserRuntimeMapper;
	@Autowired ErpFunCompMapper erpFunCompMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ReportFunSaleMinService reportFunSaleMinService;
	@Autowired ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired AsyncTask asyncTask;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
	private ErpBussinessTypePlotSwitchMapper erpBussinessTypePlotSwitchMapper;

	/**
	 * 获取策略参数开关
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/14
	 */
	@ApiOperation("获取策略参数开关")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrPlotSwitchVo.class, message = "成功")
	})
	@PostMapping("/getMgrPlotSwitch")
	public ErpResponseJson getMgrPlotSwitch(@Valid @RequestBody UpdateMgrchgLoginTypeParan param) {
		Integer compId = param.getCompId() != null ? param.getCompId() : getOperator().getCompId();
		Integer cityId = getOperator().getCityId();

		ErpFunComp compCondition = new ErpFunComp(cityId, compId);
		ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
		int plotSwitch = erpFunComp.getPlotSwitch() ? 1 : 0;

		MgrPlotSwitchVo resultVo = new MgrPlotSwitchVo();
		resultVo.setPlotswitch(plotSwitch);
		return ErpResponseJson.ok(resultVo);
	}

    @ApiOperation("获取住宅工商铺是否分开管控")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrPlotSwitchVo.class, message = "成功")
    })
    @PostMapping("/getBusinessApart")
    public ErpResponseJson getBusinessApart() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();

        ErpFunComp compCondition = new ErpFunComp(cityId, compId);
        ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
        Byte businessApart = erpFunComp.getBusinessApart();

        GetBusinessApartVO resultVo = new GetBusinessApartVO();
        resultVo.setBusinessApart(businessApart);
        return ErpResponseJson.ok(resultVo);
    }
	
	/**
	 * 获取自己公司的系统参数
	 * @auther zhuke
	 * @param param
	 * @return
	 */
	@ApiOperation("获取自己公司的系统参数")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetSelfCompSysParamListVo.class, message = "成功")
	})
	@PostMapping("/getSelfCompSysParamList")
	public ErpResponseJson getSelfCompSysParamList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer organizationId = operator.getOrganizationId();
		GetSelfCompSysParamListVo result = new GetSelfCompSysParamListVo();

		List<ErpSysPara> paramList = erpSysParaMapper.selectMLSysParas(cityId, compId, 0);

		ErpFunComp compCondition = new ErpFunComp(cityId, compId);
		ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
		// 判断是否开启了住宅 工商铺 后勤部门分开管控
		Byte businessApart = erpFunComp.getBusinessApart();
		boolean isOpenBusinessApart = Byte.valueOf("1").equals(businessApart);

		if (isOpenBusinessApart && organizationId != null) {
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);

			if (erpFunOrganization != null && erpFunOrganization.getOrganizationBussinessType() != null) {
				List<ErpSysPara> partnerParamList = erpSysParaMapper.selectMLSysParas(cityId, compId, erpFunOrganization.getOrganizationBussinessType().intValue());

				if (CollectionUtils.isNotEmpty(partnerParamList)) {
					List<String> paramIds = partnerParamList.stream().map(ErpSysPara::getParamId).collect(Collectors.toList());
					paramList = paramList.stream().filter(it -> !paramIds.contains(it.getParamId())).collect(Collectors.toList());
					paramList.addAll(partnerParamList);
				}
			}
		}

		if(CollectionUtils.isNotEmpty(paramList)){
			Map<String, Object> defaultValueMap = paramList.stream().filter(val -> StringUtil.isNotBlank(val.getDefaultValue())).
					collect(Collectors.toMap(ErpSysPara::getParamId, ErpSysPara::getDefaultValue));
			List<Map<String, Object>> defaultValueList = new LinkedList<Map<String, Object>>();
			defaultValueList.add(defaultValueMap);
			Map<String, Object> mediumValueMap = paramList.stream().filter(val -> StringUtil.isNotBlank(val.getMediumValue())).
					collect(Collectors.toMap(ErpSysPara::getParamId, ErpSysPara::getMediumValue));
			List<Map<String, Object>> mediumValueList = new LinkedList<Map<String, Object>>();
			mediumValueList.add(mediumValueMap);
			Map<String, Object> seniorValueMap = paramList.stream().filter(val -> StringUtil.isNotBlank(val.getSeniorValue())).
					collect(Collectors.toMap(ErpSysPara::getParamId, ErpSysPara::getSeniorValue));
			List<Map<String, Object>> seniorValueList = new LinkedList<Map<String, Object>>();
			seniorValueList.add(seniorValueMap);
			result.setDefaultValueList(defaultValueList);
			result.setMediumValueList(mediumValueList);
			result.setSeniorValueList(seniorValueList);
		}
		return ErpResponseJson.ok(result);
	}


	/**
	 * 修改策略参数开关
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	@ApiOperation("修改策略参数开关,作者:朱科")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "成功")})
	@PostMapping("/updatePlotSwitch")
	public ResponseJson updatePlotSwitch(@Valid @RequestBody UpdatePlotSwitchParam param){
		Integer plotSwitch = param.getPlotSwitch();
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer compType = operator.getCompType();
		String compNo = operator.getCompNo();

		boolean plotSwitchFlag = false;
		if(null == plotSwitch){
			plotSwitch = 0;
		}
		reportFunSaleMinService.judgeOperatorTransferShop(compNo, cityId, compId, null, 2, null, null);

		if (1 == plotSwitch) {
			plotSwitchFlag = true;
			erpSysParaService.updateInfoByPlot(cityId, compType, compId, plotSwitch, 0);
			erpSystemSettingLogsService.insertSysLog(SSL_TYPE.OPEN_PLOT_SWITCH, null, null, null, null, null, cityId, compId, operator.getDeptId(), operator.getUserId());
		} else if (0 == plotSwitch) {
			erpSystemSettingLogsService.insertSysLog(SSL_TYPE.CLOSE_PLOT_SWITCH, null, null, null, null, null, cityId, compId, operator.getDeptId(), operator.getUserId());
			erpSysParaService.clearFlagByPlctSwotch(cityId, compType, compId, 0);
		}

		ErpFunComp updateModel = new ErpFunComp();
		updateModel.setCompNo(compNo);
		updateModel.setCompId(compId);
		updateModel.setShardCityId(cityId);
		updateModel.setPlotSwitch(plotSwitchFlag);
		erpFunCompMapper.updateByCompNo(updateModel);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 系统参数-获取系统模式能否转换
	 * @author ZangTie
	 * @since 2018年7月24日 下午5:20:14
	 * @param param
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	@ApiOperation("获取操作日志对比记录列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = MgrSysParaModelConvertEnableVo.class, message = "成功")
	})
	@PostMapping("/getMgrSysParaModelConvertEnable")
	public ErpResponseJson getMgrSysParaModelConvertEnable(@Valid @RequestBody SysParaModelConvertEnableParam param){
		MgrSysParaModelConvertEnableVo resultVo = new MgrSysParaModelConvertEnableVo();
		resultVo.setFlag("false");
		Operator operator = getOperator();
		int count = 0;
		String runModel = param.getRunModel();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		String compNo = operator.getCompNo();
		
		String oldRunModel = erpSysParaMapper.getParamValue(cityId, compId, "SYSTEM_RUN_MODEL");
		if (StringUtil.isNotEmpty(runModel) && !runModel.equals(oldRunModel)) {
			// 如果更改运行模式，则修改房客源信息盘别
			// PUBFUN 仅公房制 PUBLIC 公盘制 PUBCUST仅公客制 PRIVATE 私盘制
			if ((runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN)
					|| runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
					&& oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)) {
				if (this.countShareHouse(1,compId) > 0 || this.countShareHouse(2,compId) > 0) {
					throw new BusinessException("系统中存在抢盘或者公盘房源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			if ((runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)
					|| runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
					&& oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)) {
				if (this.countShareHouse(3,compId) > 0 || this.countShareHouse(4,compId) > 0) {
					throw new BusinessException("系统中存在抢盘或者公盘客源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
				}
			}
		}
		if ((runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN)
				|| runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
				&& (oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)
						|| oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST))) {
			count = this.countShareHouse(1,compId);
			if (count > 0) {
				throw new BusinessException("系统中存在抢盘或者公盘出售房源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
			}
			count = this.countShareHouse(2,compId);
			if (count > 0) {
				throw new BusinessException("系统中存在抢盘或者公盘出租房源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
			}
		}
		if ((runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)
				|| runModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
				&& (oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)
						|| oldRunModel.equals(Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN))) {
			count = this.countShareHouse(3,compId);
			if (count > 0) {
				throw new BusinessException("系统中存在抢盘或者公盘求购客源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
			}
			count = this.countShareHouse(4,compId);
			if (count > 0) {
				throw new BusinessException("系统中存在抢盘或者公盘求租客源信息，请进入“数据移交”将此类信息指派给经纪人后再修改运行模式！");
			}
		}
		reportFunSaleMinService.judgeOperatorTransferShop(compNo, cityId, compId, null, 1, null, null);
		resultVo.setFlag("true");
		return ErpResponseJson.ok(resultVo);
	}

	/**
	 * 用户系统参数设置
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/3
	 */
	@ApiOperation("用户系统参数设置")
	@ApiResponses({@ApiResponse(code = 200,response = UpdateMgrParameterVo.class,message = "success")})
	@PostMapping("/updateMgrParameter")
	public ResponseJson updateMgrParameter(@Valid @RequestBody updateMgrParameterParam param) {
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		Map<String, String> paramCollMap = JSON.parseObject(param.getParamColl(), new TypeReference<Map<String, String>>() {});
		//param.getMap().putAll(paramCollMap);
		BaseMapParam baseMapParam = new BaseMapParam();
		baseMapParam.setInteger("cityId", cityId);
		baseMapParam.setInteger("compId", compId);
		baseMapParam.setString("compNo", getOperator().getCompNo());
		baseMapParam.setInteger("compType", getOperator().getCompType());
		baseMapParam.setInteger("userId", getOperator().getUserId());
		baseMapParam.setObject("isPersonalVersion", getOperator().isPersonalVersion());

		baseMapParam.setInteger("organizationId", getOperator().getOrganizationId());
		baseMapParam.setInteger("organizationBussinessType", param.getOrganizationBussinessType());

		baseMapParam.getMap().putAll(paramCollMap);
		boolean needRelogin = erpSysParaService.updateMgrParameter(baseMapParam);
		UpdateMgrParameterVo reloginMap = new UpdateMgrParameterVo();
		if(needRelogin) {
			reloginMap.setNeedRelogin("1");
		}
		//通知移动端刷新
		asyncTask.appRefreshSys(cityId, compId);
		return ErpResponseJson.ok(reloginMap);
	}

	/**
	 * 统计公盘和抢盘的数据
	 * @author ZangTie
	 * @since 2018年7月24日 下午5:43:16
	 * @param type：1=出售 2=出租 3=求购 4=求租
	 * @param compId=公司ID
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	private Integer countShareHouse(int type, Integer compId) {
		Integer count = 0;
		Byte[] plateTypeArr = {Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_SHARE),Byte.valueOf(Constants_DIC.DIC_PLATE_TYPE_PUBLIC)};
		if (type == 1) {
			ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
			erpFunSaleExample.createCriteria().andCompIdEqualTo(compId).andPlateTypeIn(Arrays.asList(plateTypeArr));
			erpFunSaleExample.setShardCityId(getOperator().getCityId());
			count = erpFunSaleMapper.countByExample(erpFunSaleExample);
			return count;
		} else if (type == 2) {
			ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
			erpFunLeaseExample.createCriteria().andCompIdEqualTo(compId).andPlateTypeIn(Arrays.asList(plateTypeArr));
			erpFunLeaseExample.setShardCityId(getOperator().getCityId());
			count = erpFunLeaseMapper.countByExample(erpFunLeaseExample);
			return count;
			
		} else if (type == 3) {
			ErpFunBuyCustomerExample erpFunBuyCustomerExample = new ErpFunBuyCustomerExample();
			erpFunBuyCustomerExample.createCriteria().andCompIdEqualTo(compId).andPlateTypeIn(Arrays.asList(plateTypeArr));
			erpFunBuyCustomerExample.setShardCityId(getOperator().getCityId());
			count = erpFunBuyCustomerMapper.countByExample(erpFunBuyCustomerExample);
			return count;
		} else if (type == 4) {
			ErpFunRentCustomerExample erpFunRentCustomerExample = new ErpFunRentCustomerExample();
			erpFunRentCustomerExample.createCriteria().andCompIdEqualTo(compId).andPlateTypeIn(Arrays.asList(plateTypeArr));
			erpFunRentCustomerExample.setShardCityId(getOperator().getCityId());
			count = erpFunRentCustomerMapper.countByExample(erpFunRentCustomerExample);
			return count;
		} else {
			return 0;
		}
	}

    @ApiOperation("查询所有参数设置")
    @ApiResponses({@ApiResponse(code = 200, response = SysParamListResultVO.class, message = "success")})
    @PostMapping("/getSysParamList")
    public ResponseJson getSysParamList() {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Integer organizationId = getOperator().getOrganizationId();

        List<ErpSysPara> sysParamList;
        // 如果是加盟商的参数, 需要把独立的 PARAM_ID 的系统参数, 替换掉公司的系统参数
        sysParamList = erpSysParaMapper.selectMLSysParas(cityId, compId, 0);
        ErpFunComp compCondition = new ErpFunComp(cityId, compId);
        ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
        // 该公司是否开启加盟商配置 0=没有开启 1=开启(独立配置)
        Byte businessApart = erpFunComp.getBusinessApart();
        // 开启了住宅 工商铺分开管控
        if (businessApart != null && businessApart == 1) {
            if (organizationId != null) {
				ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
                if (erpFunOrganization != null && erpFunOrganization.getOrganizationBussinessType() != null) {
                    List<ErpSysPara> partnerParamList = erpSysParaMapper.selectMLSysParas(cityId, compId, erpFunOrganization.getOrganizationBussinessType().intValue());
                    if (CollectionUtils.isNotEmpty(partnerParamList)) {
                        List<String> paramIds = partnerParamList.stream().map(ErpSysPara::getParamId).collect(Collectors.toList());
                        sysParamList = sysParamList.stream().filter(it -> !paramIds.contains(it.getParamId())).collect(Collectors.toList());
                        sysParamList.addAll(partnerParamList);
                    }
                }
            }
        }

        List<SysParamListVO> sysParamListVOs = new ArrayList<>();
        for (ErpSysPara erpSysPara : sysParamList) {
            SysParamListVO sysParamListVO = new SysParamListVO();
            BeanUtils.copyProperties(erpSysPara, sysParamListVO);
            sysParamListVOs.add(sysParamListVO);
        }
        SysParamListResultVO sysParamListResultVO = new SysParamListResultVO();
        sysParamListResultVO.setSysParamList(sysParamListVOs);
        sysParamListResultVO.setCompType(getOperator().getCompType());
        sysParamListResultVO.setAreaFlag(getOperator().getAreaFlag());
        Integer adminCompId = getOperator().getAdminCompId();
        AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
        adminFunDeptsExample.createCriteria().andCompIdEqualTo(adminCompId).andSupportPropertyFlagEqualTo(Byte.valueOf("1")).andDeptFlagGreaterThanOrEqualTo(0);
        int count = adminFunDeptsMapper.countByExample(adminFunDeptsExample);
        if (count > 0) {
            sysParamListResultVO.setSupportPropertyFlag(1);
        } else {
            sysParamListResultVO.setSupportPropertyFlag(0);
        }
        return ErpResponseJson.ok(sysParamListResultVO);
    }
	
	@ApiOperation("查询版本")
	@ApiResponses({@ApiResponse(code = 200,response = CompTypeVO.class,message = "success")})
	@PostMapping("/getCompType")
	public ResponseJson getCompType() {
		CompTypeVO compTypeVO = new CompTypeVO();
		compTypeVO.setCompType(getOperator().getCompType());
		Integer adminCompId = getOperator().getAdminCompId();
		AdminFunDeptsExample adminFunDeptsExample = new AdminFunDeptsExample();
		adminFunDeptsExample.createCriteria().andCompIdEqualTo(adminCompId).andSupportPropertyFlagEqualTo(Byte.valueOf("1")).andDeptFlagGreaterThanOrEqualTo(0);
		int count = adminFunDeptsMapper.countByExample(adminFunDeptsExample);
		if (count > 0) {
			compTypeVO.setSupportPropertyFlag(1);
		} else {
			compTypeVO.setSupportPropertyFlag(0);
		}
		return ErpResponseJson.ok(compTypeVO);
	}

    @ApiOperation("查询公司或者住宅、工商铺、后勤部门系统参数设置")
    @ApiResponses({@ApiResponse(code = 200, response = Map.class, message = "success")})
    @PostMapping("/getSysParams")
    public ResponseJson getSysParams(@Valid @RequestBody GetSysParamListParam param) {
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        // 需要查询特定的住宅 工商铺或者后勤部门的参数
        Integer organizationBussinessType = param.getOrganizationBussinessType();
        Integer organizationId = getOperator().getOrganizationId();

        List<ErpSysPara> sysParamList;
        // 如果是加盟商的参数, 需要把独立的 PARAM_ID 的系统参数, 替换掉公司的系统参数
        sysParamList = erpSysParaMapper.selectMLSysParas(cityId, compId, 0);

        ErpFunComp compCondition = new ErpFunComp(cityId, compId);
        ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
        // 该公司是否开启加盟商配置 0=没有开启 1=开启(独立配置)
        Byte businessApart = erpFunComp.getBusinessApart();
		if (businessApart != null && businessApart == 1) {
			if (organizationId != null) {
				ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
				Integer finalType = organizationBussinessType == null ? erpFunOrganization.getOrganizationBussinessType().intValue() : organizationBussinessType;

				List<ErpSysPara> partnerParamList = erpSysParaMapper.selectMLSysParas(cityId, compId, finalType);
				if (CollectionUtils.isNotEmpty(partnerParamList)) {
					List<String> paramIds = partnerParamList.stream().map(ErpSysPara::getParamId).collect(Collectors.toList());
					sysParamList = sysParamList.stream().filter(it -> !paramIds.contains(it.getParamId())).collect(Collectors.toList());
					sysParamList.addAll(partnerParamList);
				}
			}
		}

        Map<String, String> sysParamMap = new HashMap<>();
        sysParamList.forEach(it -> sysParamMap.put(it.getParamId(), it.getParamValue()));
        return ErpResponseJson.ok(sysParamMap);
    }

	@ApiOperation("美联是否开启住宅 工商铺 后勤部门分开管控")
	@ApiResponses({@ApiResponse(code = 200, message = "success")})
	@PostMapping("/sysParamConfigInMeiLian")
	public ResponseJson sysParamConfigInMeiLian(@Valid @RequestBody SysParamConfigInMeiLianParam param) {
		GeneralParam generalParam = new GeneralParam(getOperator());
		erpSysParaService.sysParamConfigInMeiLian(generalParam, param);
		return ErpResponseJson.ok();
	}

	/**
	 * @title 跳公策略参数设置
	 * @author lcb
	 * @date 2019/12/25
	 *
	 **/
	@ApiOperation("跳公策略参数设置")
	@ApiResponses({@ApiResponse(code = 200,response = UpdateMgrParameterVo.class,message = "success")})
	@PostMapping("/updateStrategyParam")
	public ResponseJson updateStrategyParam(@Valid @RequestBody UpdateStrategyParam param) {
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();

		String paramColl = param.getParamColl();
		if(StringUtils.isBlank(paramColl)){
			return ErpResponseJson.ok();
		}

		Map<String, String> paramCollMap = JSON.parseObject(param.getParamColl(), new TypeReference<Map<String, String>>() {});

		BaseMapParam baseMapParam = new BaseMapParam();
		baseMapParam.setInteger("cityId", cityId);
		baseMapParam.setInteger("compId", compId);
		baseMapParam.setString("compNo", getOperator().getCompNo());
		baseMapParam.setInteger("compType", getOperator().getCompType());
		baseMapParam.setInteger("userId", getOperator().getUserId());
		baseMapParam.setObject("isPersonalVersion", getOperator().isPersonalVersion());
		baseMapParam.setInteger("organizationId", param.getOrganizationId() == null ? getOperator().getOrganizationId() : param.getOrganizationId());

		baseMapParam.getMap().putAll(paramCollMap);
		boolean needRelogin = erpSysParaService.updateMgrParameterStrategy(baseMapParam);
		UpdateMgrParameterVo reloginMap = new UpdateMgrParameterVo();
		if(needRelogin) {
			reloginMap.setNeedRelogin("1");
		}
		//通知移动端刷新
		asyncTask.appRefreshSys(cityId, compId);
		return ErpResponseJson.ok(reloginMap);
	}

	/**
	 * 新加的跳公策略参数, 如果查询时发现该组织没有初始化, 就插入一份
	 **/
	private List<String> strategySysParams = Arrays.asList(
			// 基本策略
			"RESPITE_DAYS_STRATEGY_STATUS",
			"TRANS_WRITEOFF_USERR_HOUSE_DATA", "TRANS_WRITEOFF_USERR_CUST_DATA",
			// 出售房源
			"RED_TRACK_PUBLIC_SELL_DEFID", "SALE_TRACK_STRATEGY_STATUS",
			// 出租房源
			"RED_TRACK_PUBLIC_LEASE_DEFID", "LEASE_TRACK_STRATEGY_STATUS",
			// 求购客户
			"RED_TRACK_PUBLIC_BUY_DEFID", "BUY_TRACK_STRATEGY_STATUS", "TRACK_RED_BUY_SHARE",
			"TRACK_RED_BUY_SHARE_DEFID", "TRACK_RED_BUY_SHARE_DEFID_STRATEGY_STATUS",
			// 新房客户
			"TRACK_RED_NEWHOUSE", "RED_TRACK_PUBLIC_NEWHOUSE", "RED_TRACK_PUBLIC_NEWHOUSE_DEFID", "NEWHOUSE_TRACK_STRATEGY_STATUS",
			"TRACK_RED_NEWCUST_SHARE", "TRACK_RED_NEWCUST_SHARE_DEFID", "TRACK_RED_NEWCUSTSHARE_DEFID_STRATEGY_STATUS",
			// 求租客户
			"RED_TRACK_PUBLIC_RENT_DEFID", "RENT_TRACK_STRATEGY_STATUS", "TRACK_RED_RENT_SHARE",
			"TRACK_RED_RENT_SHARE_DEFID", "TRACK_RED_RENT_SHARE_DEFID_STRATEGY_STATUS"
	);

	@ApiOperation("根据不同组织查询跳公策略参数的列表")
	@ApiResponses({@ApiResponse(code = 200, response = Map.class, message = "success")})
	@PostMapping("/getStrategyParams")
	public ResponseJson getStrategyParams(@Valid @RequestBody GetStrategyParamsParam param) {
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		// 需要查询特定的住宅 工商铺或者后勤部门的参数
		Integer organizationId = param.getOrganizationId();

		ErpSysParaExample erpSysParaExample = new ErpSysParaExample();
		erpSysParaExample.setShardCityId(cityId);
		erpSysParaExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdEqualTo(organizationId).andParamIdIn(strategySysParams);
		long count = erpSysParaMapper.countByExample(erpSysParaExample);
		if (count == 0) {
			erpSysParaService.copyParameterStrategy(cityId, compId, organizationId);
		}
		List<ErpSysPara> sysParamList = erpSysParaMapper.selectByOrgId(cityId, compId, organizationId);
		Map<String, String> sysParamMap = new HashMap<>();
		sysParamList.forEach(it -> sysParamMap.put(it.getParamId(), it.getParamValue()));
		return ErpResponseJson.ok(sysParamMap);
	}

}

package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.extension.framework.codis.util.CacheUtil;
import com.extension.framework.web.response.ResponseJson;
import com.myfun.erpWeb.house.param.UpdateEntrustFileConfigParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SysParamConfigInMeiLianParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SysParamConfigInPartnerListParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SysParamConfigInPartnerParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dao.AdminZfbHouseBatchUpdateMapper;
import com.myfun.repository.admindb.po.AdminZfbHouseBatchUpdate;
import com.myfun.repository.admindbRpt.dao.AdminRptFunHeadMapper;
import com.myfun.repository.admindbRpt.po.AdminRptFunHead;
import com.myfun.repository.admindbRpt.po.AdminRptFunHeadExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.CheckPartnerConfigDto;
import com.myfun.repository.erpdb.dto.PartnerConfigDto;
import com.myfun.repository.erpdb.dto.PartnerInfoDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.regex.Pattern.compile;

@Service
public class ErpSysParaServiceImpl extends AbstractService<ErpSysPara,ErpSysParaKey> implements ErpSysParaService {
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpFunSaleService erpFunSaleService;
	@Autowired ErpFunLeaseService erpFunLeaseService;
	@Autowired ErpFunBuyCustomerService erpFunBuyCustomerService;
	@Autowired ErpFunRentCustomerService erpFunRentCustomerService;
	@Autowired ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired AdminFunArchiveService adminFunArchiveService;
	@Autowired ErpFunSaleMapper erpFunSaleMapper;
	@Autowired ErpFunCompMapper erpFunCompMapper;
	@Autowired ErpAuditTemplateMapper erpAuditTemplateMapper;
	@Autowired ErpAuditUserTemplateMapper erpAuditUserTemplateMapper;
	@Autowired ErpFunBrokerageMapper erpFunBrokerageMapper;
	@Autowired AdminZfbHouseBatchUpdateMapper adminZfbHouseBatchUpdateMapper;
	@Autowired ErpFunHeadMapper erpFunHeadMapper;
	@Autowired AdminRptFunHeadMapper adminRptFunHeadMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpFunPartnerConfigMapper erpFunPartnerConfigMapper;
	@Autowired
	private ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired
	private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunPartnerMapper erpFunPartnerMapper;
    @Autowired
    private ErpFunPartnerLogMapper erpFunPartnerLogMapper;
    @Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
    @Autowired
    private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ErpMlWebsiteParamUpdateLogMapper erpMlWebsiteParamUpdateLogMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = this.erpSysParaMapper;
	}

	@Transactional
	@Override
	public boolean updateMgrParameter(BaseMapParam param) {
		Integer compId = param.getInteger("compId");
		Integer compType = param.getInteger("compType");
		Integer cityId = param.getInteger("cityId");
		String compNo = param.getString("compNo");
		Integer organizationId = param.getInteger("organizationId");
        Integer organizationBussinessType = param.getInteger("organizationBussinessType");

        ErpFunComp compCondition = new ErpFunComp(cityId, compId);
        ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
        // 该公司是否开启加盟商配置 0=没有开启 1=开启(独立配置)
        Byte businessApart = erpFunComp.getBusinessApart();
        // 判断是否开启了住宅 工商铺 后勤部门分开管控
        boolean isOpenBusinessApart = Byte.valueOf("1").equals(businessApart);

        int bussinessType = 0;
        if (organizationBussinessType != null) {
            bussinessType = organizationBussinessType;
        } else {
            if (isOpenBusinessApart && organizationId != null) {
                ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
                if (erpFunOrganization != null && erpFunOrganization.getOrganizationBussinessType() != null) {
                    bussinessType = erpFunOrganization.getOrganizationBussinessType().intValue();
                }
            }
        }

		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(cityId);
		erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationBussinessTypeEqualTo((byte) bussinessType).andDelFlagEqualTo((byte) 0);
		List<ErpFunOrganization> organizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
		List<Integer> orgIds = organizations.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());

		// 核心信息项是否修改 0,1
		String isInputPhone = param.getString("IS_INPUT_PHONE_CHANGE");
		//合作标记项是否修改 0,1
		String isCoopFlag = param.getString("IS_COOPERATE_CHANGE");
		// 运用模板管控单独处理
		String templateParameterControl = param.getString("TEMPLATE_PARAMETER_CONTROL");
		if("1".equals(templateParameterControl)){
			// 没有开启加盟模式或者是总部,直营或者是策略参数没有分开管控就用公司的变更; 否则就更改加盟商的策略参数开关
			Boolean plotSwitch = erpFunCompMapper.selectByCompId(cityId, compId).getPlotSwitch();
			if(!plotSwitch){
				erpFunCompMapper.updatePlctSwotch(cityId, compId, "1");
			}
		}
		String aliRentHouseCommission = param.getString("ALI_RENT_HOUSE_COMMISSION");

		Map<String,ErpSysPara> oldMap = this.getSysParaByCompId(cityId, compId, (boolean) param.getObject("isPersonalVersion"));

		if (!isOpenBusinessApart) {

		} else {
			Map<String, ErpSysPara> partnerMap = this.getSysParaByPartnerId(cityId, compId, bussinessType);
			oldMap.putAll(partnerMap);
		}

		String runModel = param.getString("SYSTEM_RUN_MODEL");
		String oldRunModel = oldMap.get("SYSTEM_RUN_MODEL").getParamValue();
		String oldAliRentHouseCommission = oldMap.get("ALI_RENT_HOUSE_COMMISSION").getParamValue();
		boolean runModelFlag = false;
		if (!StringUtils.isBlank(runModel) && !runModel.equals(oldRunModel)) {
			// 如果更改运行模式，则修改房客源信息盘别
			//PUBFUN 仅公房制  PUBLIC 公盘制  PUBCUST仅公客制 PRIVATE 私盘制
			// 私-->公房==房源判断
			if(runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN) && oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)){
				if(erpFunSaleService.countShareHouse(cityId,compId)||erpFunLeaseService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在房源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			// 私-->公==房源、客源都判断
			else if(runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC) && oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)){
				if(erpFunSaleService.countShareHouse(cityId,compId)||erpFunLeaseService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在房源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
				if(erpFunBuyCustomerService.countShareHouse(cityId,compId)||erpFunRentCustomerService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在客源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			// 私-->公客==客源判断
			else if(runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST) && oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)){
				if(erpFunBuyCustomerService.countShareHouse(cityId,compId)||erpFunRentCustomerService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在客源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			// 公房-->公客||公==客源判断
			else if((runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST) || runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
					&& oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN)){
				if(erpFunBuyCustomerService.countShareHouse(cityId,compId)||erpFunRentCustomerService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在客源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			// 公客-->公房||公==房源判断
			else if((runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN) || runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))
					&& oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)){
				if(erpFunSaleService.countShareHouse(cityId,compId)||erpFunLeaseService.countShareHouse(cityId,compId)){
					throw new BusinessException("系统中存在房源抢盘或者公盘信息，请进入”数据移交“将此类信息指派给经纪人后再修改运行模式！");
				}
			}
			//===========改数据===========
			// 新：私盘制
			if (runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE)) {
				// 老：仅公房制||全公盘制=房源改为私盘
				if (oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN) || oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC)) {
					erpFunSaleService.updateHouseRunModelForPrivate(cityId,compId);
					erpFunLeaseService.updateHouseRunModelForPrivate(cityId,compId);
				}
				// 老：仅公客制||全公盘制=客源改为私盘
				if (oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST) || oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC)) {
					erpFunBuyCustomerService.updateHouseRunModelForPrivate(cityId,compId);
					erpFunRentCustomerService.updateHouseRunModelForPrivate(cityId,compId);
				}
			}
			// 仅公房制||全公盘制=房源改为公盘
			if (runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN) || runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC)) {
				erpFunSaleService.updateHousePlateTypeByRunModel(cityId,compId);
				erpFunLeaseService.updateHousePlateTypeByRunModel(cityId,compId);
				// 仅公房制下要把客源改为私盘=客源改为私盘
				if (runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN)
						&& (oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)
							||oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))){
					erpFunBuyCustomerService.updateHouseRunModelForPrivate(cityId, compId);
					erpFunRentCustomerService.updateHouseRunModelForPrivate(cityId, compId);
				}
			}
			// 仅公客制||全公盘制
			if (runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST) || runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC)) {
				erpFunBuyCustomerService.updateHousePlateTypeByRunModel(cityId,compId);
				erpFunRentCustomerService.updateHousePlateTypeByRunModel(cityId,compId);
				// 仅公客制下要把房源改为私盘
				if (runModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)
						&& (oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN)
							||oldRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC))){
					erpFunSaleService.updateHouseRunModelForPrivate(cityId, compId);
					erpFunLeaseService.updateHouseRunModelForPrivate(cityId, compId);
				}
			}
			//===========改数据===========
			
			Map<String, String> runModeMap = new HashMap<String, String>();
			runModeMap.put(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC, "公房公客");
			runModeMap.put(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE, "私房私客");
			runModeMap.put(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN, "公房私客");
			runModeMap.put(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST, "私房公客");
			String content = "将运行模式由"+runModeMap.get(oldRunModel)+"修改为"+runModeMap.get(runModel);
			erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.SYSTEM_RUN_MODEL, null, content, null, null, param);
			runModelFlag = true;
		}
		// 如果修改时间参数,则修改相应类型信息的时间,必须在更新参数前执行
				/* 房勘或跟进 */
		// 出售
		boolean redPubSaleDay = this.getPolicyAddDay(param,oldMap, "FANGKAN_RED_SELL", "RED_FANGKAN_PUBLIC_SELL");
		// 系统参数更新房勘计时起始时间
		if (redPubSaleDay) {
		    erpFunSaleService.updateHouseActionTimeBySysPara(cityId, compId);
		}
		// 出租
		boolean redPubLeaseDay = this.getPolicyAddDay(param,oldMap, "FANGKAN_RED_LEASE", "RED_FANGKAN_PUBLIC_LEASE");
		if (redPubLeaseDay) {
		    erpFunLeaseService.updateHouseActionTimeBySysPara(cityId, compId);
		}
		// 求购
		boolean redPubBuyDay = this.getPolicyAddDay(param,oldMap, "FANGKAN_RED_BUY", "RED_FANGKAN_PUBLIC_BUY");
		if (redPubBuyDay) {
		    erpFunBuyCustomerService.updateHouseActionTimeBySysPara(cityId, compId);
		}
		// 求租
		boolean redPubRentDay = this.getPolicyAddDay(param,oldMap, "FANGKAN_RED_RENT", "RED_FANGKAN_PUBLIC_RENT");
		//老的时间大于了新的时间那么，就把ACTION_TIME更新成当前的时间
		if (redPubRentDay) {
		    erpFunRentCustomerService.updateHouseActionTimeBySysPara(cityId, compId);
		}
		/************最后跟进时间************/
		//老的时间大于了新的时间那么，就把TRACK_TIME更新成当前的时间
		/*最后跟进时间*/
		// 出售
		boolean trackPubSaleDay = this.getPolicyAddDay(param,oldMap, "TRACK_RED_SELL", "RED_TRACK_PUBLIC_SELL");
		if (trackPubSaleDay) {
			//20-5-19 wc task#141368 美联 去掉非手写跟进更改更近时间
//		    erpFunSaleService.updateHouseTrackTime(cityId, compId, "0");
		}
		// 出租
		boolean trackPubLeaseDay = this.getPolicyAddDay(param,oldMap, "TRACK_RED_LEASE", "RED_TRACK_PUBLIC_LEASE");
		if (trackPubLeaseDay) {
			//20-5-19 wc task#141368 美联 去掉非手写跟进更改更近时间
//		    erpFunLeaseService.updateHouseTrackTime(cityId, compId, "0");
		}
		// 求购
		boolean trackPubBuyDay = this.getPolicyAddDay(param,oldMap, "TRACK_RED_BUY", "RED_TRACK_PUBLIC_BUY");
		if (trackPubBuyDay) {
		    erpFunBuyCustomerService.updateHouseTrackTime(cityId, compId, "0");
		}
		// 求租
		boolean trackPubRentDay = this.getPolicyAddDay(param,oldMap, "TRACK_RED_RENT", "RED_TRACK_PUBLIC_RENT");
		if (trackPubRentDay) {
		    erpFunRentCustomerService.updateHouseTrackTime(cityId, compId, "0");
		}
		/*抢盘变公盘计时时间*/
		// 出售
		String pubNotgetCelSell = param.getString("PUBLIC_NOTGET_CANCEL_SELL");
		if (!StringUtil.isBlank(pubNotgetCelSell) && Integer.parseInt(oldMap.get("PUBLIC_NOTGET_CANCEL_SELL").getParamValue()) > Integer.parseInt(pubNotgetCelSell)) {
			erpFunSaleService.updateHousePublicTime(cityId, compId);
		}
		// 出租
		String pubNotgetCelLease = param.getString("PUBLIC_NOTGET_CANCEL_LEASE");
		if (!StringUtil.isBlank(pubNotgetCelLease) && Integer.parseInt(oldMap.get("PUBLIC_NOTGET_CANCEL_LEASE").getParamValue()) > Integer.parseInt(pubNotgetCelLease)) {
			erpFunLeaseService.updateHousePublicTime(cityId, compId);
		}
		// 求购
		String pubNotgetCelBuy = param.getString("PUBLIC_NOTGET_CANCEL_BUY");
		if (!StringUtil.isBlank(pubNotgetCelBuy) && Integer.parseInt(oldMap.get("PUBLIC_NOTGET_CANCEL_BUY").getParamValue()) > Integer.parseInt(pubNotgetCelBuy)) {
			erpFunBuyCustomerService.updateHousePublicTime(cityId,compId);
		}
		// 求租
		String pubNotgetCelRent = param.getString("PUBLIC_NOTGET_CANCEL_RENT");
		if (!StringUtil.isBlank(pubNotgetCelRent) && Integer.parseInt(oldMap.get("PUBLIC_NOTGET_CANCEL_RENT").getParamValue()) > Integer.parseInt(pubNotgetCelRent)) {
			erpFunRentCustomerService.updateHousePublicTime(cityId,compId);
		}

        /*
         * @brief 系统参数图片上传分开管控
         * detail [2020-3-27] 陈志强 详细1 需求id#0 系统参数图片上传分开管控
         */
		List<String> newHouseParams = Arrays.asList("NEW_HOUSE_BROKERAGE_IN_DATE", "NEW_HOUSE_HAVE_THREE_PIC",
				"NEW_HOUSE_HAVE_PRESELL_LICENSE_PIC", "NEW_HOUSE_HAVE_DEVELOPER_BUSINESS_LICENSE_PIC", "NEW_HOUSE_IN_INNER_PROMOTION_PERIOD");

		List<ErpSysPara> beforeSysParaList = new ArrayList<>() ;
		List<ErpSysPara> afterSysParaList = new ArrayList<>() ;
		Iterator<Entry<String, Object>> it = param.getMap().entrySet().iterator();
		boolean allowPhoneFlag = false, allowCoopFlag = false;
		// 踢人的时候 加盟商compOrPartner=0 公司compOrPartner=1
		int updateFlag = 0, needRelogin = 0, compOrPartner = 0;

		while (it.hasNext()) {
			Map.Entry<String, Object> entry =  it.next();
			String paraId = entry.getKey();
			String value = StringUtil.toString(entry.getValue());

			/*
			 * @brief 系统参数修改值不能为空
			 * detail [2020-3-7] 陈志强 详细1 需求id#11784 系统参数修改值不能为空 暂时取消参数值为空判断
			 */
//			if (StringUtils.isBlank(value)) {
//				throw new BusinessException("请输入参数值！");
//			}

			if (StringUtil.isBlank(paraId) && paraId.equals("ACTION") && paraId.equals("CITY_COOP_FLAG")
					&& paraId.equals("FUN_PROVINCE") && paraId.equals("COMP_NAME")) {
				continue;
			}
			// 有才更新
			ErpSysPara oldSysParaPO = oldMap.get(paraId);

			// 公盘配置范围可以置空, 就删除掉这个key
			if ("SHARE_HOUSE_RANGE".equals(paraId) || "SHARE_CUST_RANGE".equals(paraId)) {
			    if (StringUtil.isBlank(value)) {
                    erpSysParaMapper.updateParameterBlank(cityId, compId, bussinessType, paraId);
                    continue;
                }
            }

			if(oldSysParaPO != null){
				//值一样的不更新
				if(!StringUtil.isBlank(value) && !StringUtil.isBlank(oldSysParaPO.getParamValue()) && oldSysParaPO.getParamValue().equals(value)){
					continue;
				}
				// 房客源无需审核项目不需要为空判断，有可以为空的就放这里
				if(!StringHelper.contains(new String[]{
						"SALE_AUTO_EXAM_APPLY","RENT_AUTO_EXAM_APPLY"
						,"LEASE_AUTO_EXAM_APPLY","BUY_AUTO_EXAM_APPLY"
						,"AUTO_ADUIT_CUSTOMER_ITEMS","AUTO_ADUIT_HOUSE_ITEMS"}, paraId)){
					//更新的值为空则跳过更新 - 防止数据被错误的更新为空
					if(StringUtil.isBlank(value)){
						continue;
					}
				} else {
					this.updateAuditTypeAndUser(cityId, compId, paraId, value, oldSysParaPO.getParamValue());
				}
				if (paraId.equals("ALLOW_INPUT_PHONE") && "1".equals(value)) {
					allowPhoneFlag = true;
				}
				if (paraId.equals("ALLOW_CITY_COOPERATE") && "1".equals(value)) {
					allowCoopFlag = true;
				}
//				if("IS_SHOW_HOUSE_ROOF".equals(paraId) || "IS_SHOW_HOUSE_UNIT".equals(paraId) || "IS_SHOW_HOUSE_NUM".equals(paraId)){
//					System.out.println("IS_SHOW_HOUSE_ROOF, IS_SHOW_HOUSE_UNIT, IS_SHOW_HOUSE_NUM " + paraId + ", " + value);
//					this.openOrCloseRoofUnitNum(cityId, compId, paraId, value);
//				}
				ErpSysPara sysParaPO = new ErpSysPara();
				sysParaPO.setParamId(paraId);
				sysParaPO.setParamType("int");
				sysParaPO.setParamValue(value);
				sysParaPO.setShardCityId(cityId);

				// 开启加盟模式,并且自己属于加盟商,并且当前改的这单个系统参数所属大项开启了独立配置 -> 修改加盟商的系统参数值, 如果所有的都是修改的加盟商独立参数, 则只踢加盟商
				if (isOpenBusinessApart) {
					sysParaPO.setCompId(compId);
					// 新房的参数一改全部都改
					if (!newHouseParams.contains(paraId)) {
						sysParaPO.setPartnerId(bussinessType);
					}
					if (compOrPartner != 1) {
						compOrPartner = 0;
					}
				} else {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(0);
					compOrPartner = 1;
				}
				oldSysParaPO.setParamId(paraId);
				beforeSysParaList.add(oldSysParaPO);
				afterSysParaList.add(sysParaPO);				
				// 自动绑定小号 自动绑定小号的角色 保存一个类型的参数时，要同步更新另外类型的参数值 不区分PARTNER_ID
				if ("AUTO_BIND_AXN".equals(paraId) || "AUTO_BIND_AXN_NUMBER_ROLE".equals(paraId)) {
					erpSysParaMapper.updateParamValueByParamId(cityId, sysParaPO);
				} else {
					erpSysParaMapper.updateValue(sysParaPO);
				}

				//如果更新了他人业主电话的相关参数，那么，清除对应的缓存
				if(paraId.contains("VIEW_OWNER_PHONE_COUNT_BY_NOT_CREATOR")){
					ErpFunUsersExample userExample = new ErpFunUsersExample();
					userExample.setShardCityId(cityId);
					userExample.createCriteria().andCompIdEqualTo(compId);
					List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(userExample);
					Set<Integer> archiveIdSet = erpFunUsers.stream().map(ErpFunUsers::getArchiveId).collect(Collectors.toSet());
					archiveIdSet.stream().forEach(o->{
						cacheUtil.del(o + DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd") + "-BYCOMPSET");
					});
				}else if(paraId.contains("VIEW_OWNER_PHONE_CONTROL_BY_ROLE_")){
					String role = paraId.substring(paraId.indexOf("ROLE_") + 5);
					ErpFunUsersExample userExample = new ErpFunUsersExample();
					userExample.setShardCityId(cityId);
					userExample.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo(role);
					List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectByExample(userExample);
					Set<Integer> archiveIdSet = erpFunUsers.stream().map(ErpFunUsers::getArchiveId).collect(Collectors.toSet());
					archiveIdSet.stream().forEach(o->{
						cacheUtil.del(o + DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd") + "-BYROLE");
					});
				}
				// 重新登录
				Byte relogin = oldSysParaPO.getNeedRelogin();
				if(relogin != null && (relogin == 1 // 都要重新登录
						|| (relogin == 2 && "1".equals(entry.getValue())) // 变为1要重新登录
						|| (relogin == 3 && "0".equals(entry.getValue())))){ // 变为0要重新登录
					needRelogin++;
				}
			// 角色查看核心信息条数的逻辑，动态添加的系统参数（APP_VIEW_FUN_NUM_的COUNT换成NUM，因为用COUNT太长了，数据库字段长度也改不了）
			} else if (paraId.startsWith("VIEW_HOUSE_COUNT_SELF_") || paraId.startsWith("VIEW_HOUSE_COUNT_OTHER_") || paraId.startsWith("VIEW_HOUSE_COUNT_OTHER_APP_")
					|| paraId.startsWith("VIEW_CUST_COUNT_SELF_") || paraId.startsWith("VIEW_CUST_COUNT_OTHER_") || paraId.startsWith("VIEW_CUST_COUNT_OTHER_APP_")) {
				// 插入新参数
				ErpSysPara sysParaPO = new ErpSysPara();

				// 开启加盟模式,并且自己属于加盟商,并且当前改的这单个系统参数所属大项开启了独立配置 -> 修改加盟商的系统参数值, 如果所有的都是修改的加盟商独立参数, 则只踢加盟商
				if (isOpenBusinessApart) {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(bussinessType);
					if (compOrPartner != 1) {
						compOrPartner = 0;
					}
				} else {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(0);
					compOrPartner = 1;
				}
				if (paraId.indexOf("VIEW_HOUSE_COUNT_SELF_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_HOUSE_COUNT_SELF");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色查看自己核心信息查看条数[房源]");
				} else if (paraId.indexOf("VIEW_HOUSE_COUNT_OTHER_APP_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_HOUSE_COUNT_OTHER_APP");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色手机查看他人核心信息查看条数[房源]");
				} else if (paraId.indexOf("VIEW_HOUSE_COUNT_OTHER_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_HOUSE_COUNT_OTHER");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色查看他人核心信息查看条数[房源]");
				} else if (paraId.indexOf("VIEW_CUST_COUNT_SELF_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_CUST_COUNT_SELF");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色查看自己核心信息查看条数[客源]");
				} else if (paraId.indexOf("VIEW_CUST_COUNT_OTHER_APP_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_CUST_COUNT_OTHER_APP");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色手机查看他人核心信息查看条数[客源]");
				} else if (paraId.indexOf("VIEW_CUST_COUNT_OTHER_") >= 0) {
					ErpSysPara erpSysPara = oldMap.get("VIEW_CUST_COUNT_OTHER");
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("角色查看他人核心信息查看条数[客源]");
				}
				sysParaPO.setParamId(paraId);
				sysParaPO.setParamType("INT");
				sysParaPO.setParamValue(value);
				sysParaPO.setShardCityId(cityId);
				erpSysParaMapper.insertSelective(sysParaPO);
				beforeSysParaList.add(new ErpSysPara());
				afterSysParaList.add(sysParaPO);
			} else if (paraId.startsWith("SALE_LIMIT_") || paraId.startsWith("LEASE_LIMIT_")) {
				// 插入新参数
				ErpSysPara sysParaPO = new ErpSysPara();

                // 开启加盟模式,并且自己属于加盟商,并且当前改的这单个系统参数所属大项开启了独立配置 -> 修改加盟商的系统参数值, 如果所有的都是修改的加盟商独立参数, 则只踢加盟商
                if (isOpenBusinessApart) {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(bussinessType);
					if (compOrPartner != 1) {
						compOrPartner = 0;
					}
				} else {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(0);
					compOrPartner = 1;
				}
				if (paraId.indexOf("SALE_LIMIT_") >= 0){
					ErpSysPara erpSysPara = oldMap.get("SALE_LIMIT");
					if(null != erpSysPara){
						sysParaPO.setDefaultValue(erpSysPara.getParamValue());
						sysParaPO.setMediumValue(erpSysPara.getMediumValue());
						sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
						sysParaPO.setParamDesc("私房制下限制经纪人私盘出售房源拥有条数");
					}
				} else {
					ErpSysPara erpSysPara = oldMap.get("LEASE_LIMIT");
					if(null != erpSysPara){
						sysParaPO.setDefaultValue(erpSysPara.getParamValue());
						sysParaPO.setMediumValue(erpSysPara.getMediumValue());
						sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
						sysParaPO.setParamDesc("私房制下限制经纪人私盘出租房源拥有条数");
					}
				}
				sysParaPO.setParamId(paraId);
				sysParaPO.setParamType("STRING");
				sysParaPO.setParamValue(value);
				sysParaPO.setShardCityId(cityId);
				erpSysParaMapper.insertSelective(sysParaPO);
				beforeSysParaList.add(new ErpSysPara());
				afterSysParaList.add(sysParaPO);
			} else if (paraId.startsWith("IS_OPEN_ELECTRONIC_ENTRUST") || paraId.startsWith("IS_SHARE_ENTRUST_DATA")) {
				// 插入新参数
				ErpSysPara sysParaPO = new ErpSysPara();
				// 开启加盟模式,并且自己属于加盟商,并且当前改的这单个系统参数所属大项开启了独立配置 -> 修改加盟商的系统参数值, 如果所有的都是修改的加盟商独立参数, 则只踢加盟商
				if (isOpenBusinessApart) {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(bussinessType);
					if (compOrPartner != 1) {
						compOrPartner = 0;
					}
				} else {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(0);
					compOrPartner = 1;
				}
				if (paraId.indexOf("IS_OPEN_ELECTRONIC_ENTRUST") >= 0){
					ErpSysPara erpSysPara = oldMap.get("IS_OPEN_ELECTRONIC_ENTRUST");
					if(null != erpSysPara){
						sysParaPO.setDefaultValue(erpSysPara.getParamValue());
						sysParaPO.setMediumValue(erpSysPara.getMediumValue());
						sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					}else {
						sysParaPO.setDefaultValue("0");
						sysParaPO.setMediumValue("0");
						sysParaPO.setSeniorValue("0");
					}
					sysParaPO.setParamDesc("是否开启电子委托 0=否 1=是");
				} else {
					ErpSysPara erpSysPara = oldMap.get("IS_SHARE_ENTRUST_DATA");
					if(null != erpSysPara){
						sysParaPO.setDefaultValue(erpSysPara.getParamValue());
						sysParaPO.setMediumValue(erpSysPara.getMediumValue());
						sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					}else {
						sysParaPO.setDefaultValue("0");
						sysParaPO.setMediumValue("0");
						sysParaPO.setSeniorValue("0");
					}
					sysParaPO.setParamDesc("租售房源委托资料是否共用 0=否 1=是");
				}
				sysParaPO.setParamId(paraId);
				sysParaPO.setParamType("INT");
				sysParaPO.setParamValue(value);
				sysParaPO.setShardCityId(cityId);
				erpSysParaMapper.insertSelective(sysParaPO);
				beforeSysParaList.add(new ErpSysPara());
				afterSysParaList.add(sysParaPO);
            } else if (paraId.startsWith("ALLOW_UPLOAD_SALE_HOUSE_PIC_ML") || paraId.startsWith("ALLOW_UPLOAD_SALE_HOUSE_LAYOUT_PIC_ML")
                    || paraId.startsWith("ALLOW_UPLOAD_LEASE_HOUSE_PIC_ML") || paraId.startsWith("ALLOW_UPLOAD_LEASE_HOUSE_LAYOUT_PIC_ML")) {
                // 插入新参数
                ErpSysPara sysParaPO = new ErpSysPara();
                // 开启加盟模式,并且自己属于加盟商,并且当前改的这单个系统参数所属大项开启了独立配置 -> 修改加盟商的系统参数值, 如果所有的都是修改的加盟商独立参数, 则只踢加盟商
                if (isOpenBusinessApart) {
                    sysParaPO.setCompId(compId);
                    sysParaPO.setPartnerId(bussinessType);
                    if (compOrPartner != 1) {
                        compOrPartner = 0;
                    }
                } else {
                    sysParaPO.setCompId(compId);
                    sysParaPO.setPartnerId(0);
                    compOrPartner = 1;
                }
                if (paraId.indexOf("ALLOW_UPLOAD_SALE_HOUSE_PIC_ML") >= 0) {
                    ErpSysPara erpSysPara = oldMap.get("ALLOW_UPLOAD_SALE_HOUSE_PIC_ML");
                    if (null != erpSysPara) {
                        sysParaPO.setDefaultValue(erpSysPara.getParamValue());
                        sysParaPO.setMediumValue(erpSysPara.getMediumValue());
                        sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
                    } else {
                        sysParaPO.setDefaultValue("0");
                        sysParaPO.setMediumValue("0");
                        sysParaPO.setSeniorValue("0");
                    }
                    sysParaPO.setParamDesc("是否允许上传出售户型图 0=否 1=是");
                } else if(paraId.indexOf("ALLOW_UPLOAD_SALE_HOUSE_LAYOUT_PIC_ML") >= 0) {
                    ErpSysPara erpSysPara = oldMap.get("ALLOW_UPLOAD_SALE_HOUSE_LAYOUT_PIC_ML");
                    if (null != erpSysPara) {
                        sysParaPO.setDefaultValue(erpSysPara.getParamValue());
                        sysParaPO.setMediumValue(erpSysPara.getMediumValue());
                        sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
                    } else {
                        sysParaPO.setDefaultValue("0");
                        sysParaPO.setMediumValue("0");
                        sysParaPO.setSeniorValue("0");
                    }
                    sysParaPO.setParamDesc("是否允许上传出售房源图 0=否 1=是");
                } else if(paraId.indexOf("ALLOW_UPLOAD_LEASE_HOUSE_PIC_ML") >= 0) {
                    ErpSysPara erpSysPara = oldMap.get("ALLOW_UPLOAD_LEASE_HOUSE_PIC_ML");
                    if (null != erpSysPara) {
                        sysParaPO.setDefaultValue(erpSysPara.getParamValue());
                        sysParaPO.setMediumValue(erpSysPara.getMediumValue());
                        sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
                    } else {
                        sysParaPO.setDefaultValue("0");
                        sysParaPO.setMediumValue("0");
                        sysParaPO.setSeniorValue("0");
                    }
                    sysParaPO.setParamDesc("是否允许上传出租房源图 0=否 1=是");
                } else if(paraId.indexOf("ALLOW_UPLOAD_LEASE_HOUSE_LAYOUT_PIC_ML") >= 0) {
                    ErpSysPara erpSysPara = oldMap.get("ALLOW_UPLOAD_LEASE_HOUSE_LAYOUT_PIC_ML");
                    if (null != erpSysPara) {
                        sysParaPO.setDefaultValue(erpSysPara.getParamValue());
                        sysParaPO.setMediumValue(erpSysPara.getMediumValue());
                        sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
                    } else {
                        sysParaPO.setDefaultValue("0");
                        sysParaPO.setMediumValue("0");
                        sysParaPO.setSeniorValue("0");
                    }
                    sysParaPO.setParamDesc("是否允许上传出租户型图 0=否 1=是");
                }
                sysParaPO.setParamId(paraId);
                sysParaPO.setParamType("INT");
                sysParaPO.setParamValue(value);
                sysParaPO.setShardCityId(cityId);
                erpSysParaMapper.insertSelective(sysParaPO);
                beforeSysParaList.add(new ErpSysPara());
                afterSysParaList.add(sysParaPO);
            } else if (paraId.startsWith("VIEW_OWNER_PHONE_CONTROL_BY_ROLE_")) {
				// 插入新参数
				ErpSysPara sysParaPO = new ErpSysPara();
				if (isOpenBusinessApart) {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(bussinessType);
					if (compOrPartner != 1) {
						compOrPartner = 0;
					}
				} else {
					sysParaPO.setCompId(compId);
					sysParaPO.setPartnerId(0);
					compOrPartner = 1;
				}

				ErpSysPara erpSysPara = oldMap.get("VIEW_OWNER_PHONE_CONTROL_BY_COMP_OR_ROLE");
				if(null != erpSysPara){
					sysParaPO.setDefaultValue(erpSysPara.getParamValue());
					sysParaPO.setMediumValue(erpSysPara.getMediumValue());
					sysParaPO.setSeniorValue(erpSysPara.getSeniorValue());
					sysParaPO.setParamDesc("每天可看他人创建业主电话条数");
				}

				sysParaPO.setParamId(paraId);
				sysParaPO.setParamType("INT");
				sysParaPO.setParamValue(value);
				sysParaPO.setShardCityId(cityId);
				erpSysParaMapper.insertSelective(sysParaPO);
				beforeSysParaList.add(new ErpSysPara());
				afterSysParaList.add(sysParaPO);
			} else {
                continue;
            }
			updateFlag++;
		}
		// 更新 是否开启“需求中心”平台 更新用户的朋友标记
		if("1".equals(isCoopFlag)){
			// 朱科走读注释的代码，不知道为啥要这样移植
//			if (allowCoopFlag) {
//				List<ErpFunUsers> funUsersPOs = erpFunUsersService.getUserListByCompId(cityId, compId);
//				Set<Integer> archiveIds = funUsersPOs.stream().collect(Collectors.mapping(ErpFunUsers::getArchiveId, Collectors.toSet()));
//				//BeanUtilsHelper.buildQueryKeys(funUsersPOs, "archiveId");
//				adminFunArchiveService.updateFriendFlagForSysParaByKeys(cityId,compId,archiveIds, param.getString("allowCityCooperate"));
//			}else{
				// 关闭“需求中心”，更改所有房源为“不合作” 0为关闭中心
				//房源
			if(!allowCoopFlag){
					erpFunSaleService.updateHouseSourceNotCooperate(cityId,compId);
					erpFunLeaseService.updateHouseSourceNotCooperate(cityId,compId);
					//客源
					erpFunRentCustomerService.updateCustomerSourceNotCooperate(cityId,compId);
					erpFunBuyCustomerService.updateCustomerSourceNotCooperate(cityId,compId);
				 /*else {
					erpFunSaleService.updateHouseSourceNotCooperateByPartner(cityId, compId, partnerId);
					erpFunLeaseService.updateHouseSourceNotCooperateByPartner(cityId, compId, partnerId);
					//客源
					erpFunRentCustomerService.updateCustomerSourceNotCooperateByPartner(cityId, compId, partnerId);
					erpFunBuyCustomerService.updateCustomerSourceNotCooperateByPartner(cityId, compId, partnerId);
				}*/
			}
//			}
		}
		// 开启核心信息录入，更新超出策略参数所设置时间以外的信息
		if("1".equals(isInputPhone) && !"1".equals(templateParameterControl)){
			// 开启加盟模式并且是策略参数隔离,公司的改公司的,加盟商改加盟商的
			erpFunCompMapper.updatePlctSwotch(cityId, compId, allowPhoneFlag?"1":"0");
			if (allowPhoneFlag) {
				this.updateInfoByPlot(cityId,compType,compId,1, 0);
			} else {
				//关闭核心信息录入策略参数也要关闭
				this.clearFlagByPlctSwotch(cityId, compType, compId, 0);
			}
		}
		//更新系统参数判断是否需要上架房源
		List<String> webSiteParam = new ArrayList<>();
		webSiteParam.add("SECOND_HAND_HOUSE_WITH_RESERVE_CASE_CODE");
		webSiteParam.add("SECOND_HAND_HOUSE_WITH_ENTRUST_CODE");
		webSiteParam.add("SECOND_HAND_HOUSE_WITH_DESC");
		webSiteParam.add("SECOND_HAND_HOUSE_WITH_SPECIFICATION");
		webSiteParam.add("SECOND_HAND_HOUSE_WEBSITEUP_UNITPRICE_SWITCH");
		webSiteParam.add("SECOND_HAND_HOUSE_WEBSITEUP_UNITPRICE_L");
		webSiteParam.add("SECOND_HAND_HOUSE_WEBSITEUP_UNITPRICE_H");
		webSiteParam.add("SECOND_HOUSE_DOWN_H_SWITCH_OPEN");
		webSiteParam.add("SECOND_HOUSE_DOWN_L_SWITCH_OPEN");
		webSiteParam.add("SECOND_HOUSE_DOWN_H_UNIT_PRICE");
		webSiteParam.add("SECOND_HOUSE_DOWN_L_UNIT_PRICE");

		webSiteParam.add("RENT_HOUSE_WITH_RESERVE_CASE_CODE");
		webSiteParam.add("RENT_HOUSE_WITH_ENTRUST_CODE");
		webSiteParam.add("RENT_HOUSE_WITH_DESC");
		webSiteParam.add("RENT_HOUSE_WITH_SPECIFICATION");

		webSiteParam.add("RENT_HOUSE_WEBSITEUP_UNITPRICE_SWITCH");
		webSiteParam.add("RENT_HOUSE_WEBSITEUP_UNITPRICE_L");
		webSiteParam.add("RENT_HOUSE_WEBSITEUP_UNITPRICE_H");
		webSiteParam.add("RENT_HOUSE_DOWN_H_SWITCH_OPEN");
		webSiteParam.add("RENT_HOUSE_DOWN_L_SWITCH_OPEN");
		webSiteParam.add("RENT_HOUSE_DOWN_H_UNIT_PRICE");
		webSiteParam.add("RENT_HOUSE_DOWN_L_UNIT_PRICE");

		for (String paramId : webSiteParam) {
			if (oldMap != null && param != null) {
				if (!oldMap.get(paramId).getParamValue().equals(param.getString(paramId))) {
					ErpMlWebsiteParamUpdateLog mlWebsiteParamUpdateLog = new ErpMlWebsiteParamUpdateLog();
					mlWebsiteParamUpdateLog.setUpdateParamId(paramId);
					mlWebsiteParamUpdateLog.setCompId(compId);
					mlWebsiteParamUpdateLog.setUpdateDate(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
					mlWebsiteParamUpdateLog.setCreateTime(new Date());
					mlWebsiteParamUpdateLog.setShardCityId(cityId);
					erpMlWebsiteParamUpdateLogMapper.insertSelective(mlWebsiteParamUpdateLog);

					// 请求threadTaskWeb
					LinkedHashMap<String, String> paramData = new LinkedHashMap<>();
					paramData.put("compId", compId+"");
					paramData.put("cityId", cityId.toString());
					paramData.put("userId", param.getString("userId"));
					paramData.put("organizationBussinessType", bussinessType+"");
					paramData.put("organizationId", organizationId.toString());
					try {
						//请求请求threadTaskWeb
						/*String res = HttpUtilNew.post(AppConfig.getProperty("common.threadTaskWeb.path") + "systemApi/syncMlHouseWebSiteData", paramData, null);
						//HttpUtilNew.post("http://192.168.200.165:9099/threadTaskWeb/systemApi/syncMlHouseWebSiteData", paramData, null);
						System.out.println("**************-------------");
						System.out.println(res);*/
						//kafkaTemplate.send("mlWebSiteSyncTopic", JSON.toJSONString(paramData));
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

		// 新营销版
		if(StringUtil.isNotBlank(aliRentHouseCommission) && (Const.DIC_COMP_TYPE_4.equals(compType) || Const.DIC_COMP_TYPE_3.equals(compType)
				|| Const.DIC_COMP_TYPE_2.equals(compType)) && !aliRentHouseCommission.equals(oldAliRentHouseCommission)){
			// 修改租金配置，并且处理已同步过得房源数据
			this.dealLeaseHouseRate(cityId, compNo, compId, aliRentHouseCommission);
		}
		//更新系统参数后，给所有登录人员一个提示,1代表修改系统参数
		if(needRelogin > 0){
			if (isOpenBusinessApart && bussinessType > 0) {
				erpFunUsersService.updateUserStatusBySysParaByOrg(param.getInteger("userId"), cityId, compId, orgIds);
			} else {
				// 公司
				erpFunUsersService.updateUserStatusBySysPara(param.getInteger("userId"),cityId,compId);
			}
		}
		if(updateFlag > 0){
			if(!runModelFlag || (runModelFlag && updateFlag > 1)){// 修改了运行模式且更新条数多于两条，说明不止改了运行模式
				erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.CHANGE_PARAMETER, null, null, beforeSysParaList, afterSysParaList, param);
			}
		}

		//清理缓存 todo 加盟商清理
		this.evictSysParamCache(cityId,compId);
				//如果权限范围变了那么清理一次角色对应的权限范围【暂时不需要执行】 陈文超
//				if(!StringUtil.isBlank(param.getString("LOOK_CUST_RANGE"))
//						||!StringUtil.isBlank(param.getString("LOOK_HOUSE_RANGE"))){
//					String [] roleNames = new String[]{
//							Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL,
//							Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER,
//							Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER,
//							Constants_DIC.DIC_ROLE_NAME_COMMON_BIZ,
//							Constants_DIC.DIC_ROLE_NAME_CUST_SERVER,
//							Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER,
//							Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER,
//							Constants_DIC.DIC_ROLE_NAME_PRACTY_BIZ,
//							Constants_DIC.DIC_ROLE_NAME_PROPERTY_SERVER,
//							Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER,
//							Constants_DIC.DIC_ROLE_NAME_SECRETARIAL,
//							Constants_DIC.DIC_ROLE_NAME_SYSTEM_MANAGE
//					};
//					for(String roleName : roleNames){
//						roleOpersService.evictCacheableModelData(new RoleOpersPO().setROLE_ID(roleName));
//					}
//				}
		return needRelogin > 0;
		}




	@Override
	public Map<String,ErpSysPara> getSysParaByCompId(Integer cityId, Integer compId ,boolean isPersonal) {
		//如果是纯精英版 则comp_id  默认为0
		if (isPersonal) {
			compId = 0;
		}
		List<ErpSysPara> paramList = erpSysParaMapper.selectSysParaByCompId(cityId, compId);
		Map<String, ErpSysPara> sysParaMap = paramList.stream().collect(Collectors.toMap(val->val.getParamId(), val -> val));
		return sysParaMap;
	}

	/**
	 * 按照加盟商获取系统参数列表
	 */
	public Map<String, ErpSysPara> getSysParaByPartnerId(Integer cityId, Integer compId, Integer partnerId) {
		List<ErpSysPara> paramList = erpSysParaMapper.selectSysParamByBusinessType(cityId, compId, partnerId);
		return paramList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
	}

    public Map<String, ErpSysPara> getSysParaByOrgId(Integer cityId, Integer compId, Integer organizationId) {
        List<ErpSysPara> paramList = erpSysParaMapper.selectByOrgId(cityId, compId, organizationId);
        return paramList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
    }

	/**
	 * 查询指定参数
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId
	 * @param compId
	 * @param params
	 * @param isPersonal
	 * @return
	 */
	@Override
	public Map<String,ErpSysPara> getByParams(Integer cityId, Integer compId, String[] params, boolean isPersonal) {
		//如果是纯精英版 则comp_id  默认为0
		if (isPersonal) {
			compId = 0;
		}
		List<ErpSysPara> paramList = erpSysParaMapper.selectByParams(cityId, compId, params);
		Map<String, ErpSysPara> sysParaMap = paramList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, val -> val));
		return sysParaMap;
	}

	@Override
	public ErpSysPara getErpSysPara(Integer compId, Integer cityId, String paraName) {
//		ErpSysParaKey paraKey = new ErpSysParaKey();
//		paraKey.setCompId(compId);
//		paraKey.setParamId(paraName);
//		paraKey.setShardCityId(cityId);
//		return erpSysParaMapper.selectByPrimaryKey(paraKey);

		return erpSysParaMapper.getValueById(cityId, compId, paraName);
	}

	/**
	 * 根据信息的租售求租求购类型判断当前系统该类型下是否是公盘运行模式,目前用于写跟进功能中和任务功能中
	 * @author 熊刚
	 * @since 2017年10月18日
	 * @param caseType
	 * @param cityId
	 * @param compId
	 * @return
	 */
	@Override
	public boolean getSysRunModelIsPublic(Integer caseType, Integer cityId, Integer compId) {
		String sysRunModel = erpSysParaMapper.getParamValue(cityId, compId, "SYSTEM_RUN_MODEL");
		// 是否是公盘模式
		boolean isPublicModel = Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC.equals(sysRunModel)// 全公盘制
				|| (
					(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType))
					&& Constants_DIC.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN.equals(sysRunModel)
				)// 仅公房制
				|| (
					(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType))
					&& Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST.equals(sysRunModel)
				);// 仅公客制
		return isPublicModel;
	}

	/**
	 * 根据信息的租售求租求购类型判断当前系统该类型下是否是私盘运行模式,目前用于写跟进功能中和任务功能中
	 * @author 熊刚
	 * @since 2017年10月18日
	 * @param caseType
	 * @param cityId
	 * @param compId
	 * @return
	 */
	@Override
	public boolean getSysRunModelIsPrivate(Integer caseType, Integer cityId, Integer compId) {
		String sysRunModel = erpSysParaMapper.getParamValue(cityId, compId,"SYSTEM_RUN_MODEL");
		//是否是私盘模式
		boolean isPrivateModel = Const.DIC_SYSRUNMODEL_DEPT_TYPE_PRIVATE.equals(sysRunModel)
				|| (
					(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType) || Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType))
					&& sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST)
				)//仅公客制--房源为私盘
				|| (
					(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType) || Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType))
					&& Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN.equals(sysRunModel)
				);//仅公房制--客源为私盘
		return isPrivateModel;
	}

	@Override
	public void evictSysParamCache(Integer cityId, Integer compId) {
	    cacheUtil.del(CacheStructure.hfterpdb_sysParaCache_map_by_CompId + compId + "_CITY_ID_" + cityId);
	}

	@Override
	public Integer updateSysPara(Integer cityId, Integer compId, String paramId, String paramValue) {
		ErpSysPara erpSysPara = new ErpSysPara();
		erpSysPara.setShardCityId(cityId);
		erpSysPara.setCompId(compId);
		erpSysPara.setParamValue(paramValue);
		erpSysPara.setParamId(paramId);
		return erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara);
	}



	/**
	 * 房源地址MD5加密- 不能用于客源
	 */
	@Override
	public List<String> encodeToMD5(String roof, String unit, String floor, String num, Integer buildId, Byte useage, String tradeAddr, Integer cityId, Integer compId) {
		// 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
		roof = (roof == null ? "" : roof).toUpperCase();
		unit = (unit == null ? "" : unit).toUpperCase();
		floor = (floor == null ? "" : floor).toUpperCase();
		num = (num == null ? "" : num).toUpperCase();

		List<String> md5List = new LinkedList<>();
		String[] numArr = num.split(",");
		for (String numNew : numArr) {
			if (Integer.valueOf(-1).equals(buildId)
					|| Constants_DIC.DIC_HOUSE_USEAGE_MANUFACT.equals(useage)
					|| Constants_DIC.DIC_HOUSE_USEAGE_STORE.equals(useage)
					|| Constants_DIC.DIC_HOUSE_USEAGE_GARAGE.equals(useage)
					|| Constants_DIC.DIC_HOUSE_USEAGE_TRADE.equals(useage)) {
				md5List.add(EnCodeHelper.ecodeByMD5(tradeAddr + "_" + numNew));
				continue;
			}
			// 做个缓存
			String coreInfoType = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
			// 号室规则下忽略楼层和栋座
			if("2".equals(coreInfoType)) {
				floor = roof = "";
				if(StringUtils.isBlank(unit) && StringUtils.isBlank(numNew)) {
					continue;
				}
			} else {
				if(StringUtils.isBlank(roof) && StringUtils.isBlank(unit)
						&& StringUtils.isBlank(floor) && StringUtils.isBlank(numNew)) {
					continue;
				}
			}
			String roofEncode = EnCodeHelper.encode(StringUtil.convertStr(roof, Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT));
			String unitEncode = EnCodeHelper.encode(StringUtil.convertStr(unit, Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT));
			String floorEncode = EnCodeHelper.encode(StringUtil.convertStr(floor, Constants_DIC.DIC_FLOOR_REPEAT_LENGTH_LIMIT));
			numNew = EnCodeHelper.encode(StringUtil.convertStr(numNew, Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT));
			String ecodeStr = EnCodeHelper.ecodeByMD5(roofEncode + "_" + unitEncode + "_" + floorEncode + "_" + numNew);
			md5List.add(ecodeStr);
		}
		return md5List;
	}
	@Override
	public String getHouseCustTimeColumn(Integer cityId, Integer compId) {
		String isUseCreationTimeQuery = erpSysParaMapper.getParamValue(cityId, compId, "IS_USE_CREATION_TIME_QUERY");
		if ("1".equals(isUseCreationTimeQuery)) {
			return "CREATION_TIME";
		}
		return "AVAILABLE_TIME";
	}


	/**
	 * 修改策略参数开关
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	@Transactional
	@Override
	public void updateInfoByPlot(Integer cityId, Integer compType, Integer compId, Integer plotSwitch, Integer bussinessType) {
		if (!compType.equals(Const.DIC_COMP_TYPE_1)) { // 只有企业版才做策略参数状态字段更新
			return;
		}

		List<Integer> orgIds = new ArrayList<>();
		if (bussinessType != null) {
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(cityId);
			erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationBussinessTypeEqualTo(bussinessType.byteValue()).andDelFlagEqualTo((byte) 0);
			List<ErpFunOrganization> organizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			orgIds = organizations.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		}

		Map<String, ErpSysPara> sysParaMap = erpSysParaMapper.getParaMapForLogin(cityId, compId, 0);
		// 1、2参数：房勘或带看, 更改ACTION_TIME
		// 出售
		String fkRedSell = sysParaMap.get("FANGKAN_RED_SELL").getParamValue();
		String redFkpSell = sysParaMap.get("RED_FANGKAN_PUBLIC_SELL").getParamValue();
		int sellActDays = StringUtil.parseInteger(fkRedSell) + StringUtil.parseInteger(redFkpSell);
		erpFunSaleMapper.updateHouseActionTimeByPlot(cityId, compId, "FUN_SALE", sellActDays, orgIds);
		// 出租
		String fkRedLease = sysParaMap.get("FANGKAN_RED_LEASE").getParamValue();
		String redFkpLease = sysParaMap.get("RED_FANGKAN_PUBLIC_LEASE").getParamValue();
		int leaseActDays = StringUtil.parseInteger(fkRedLease) + StringUtil.parseInteger(redFkpLease);
		erpFunSaleMapper.updateHouseActionTimeByPlot(cityId, compId, "FUN_LEASE", leaseActDays, orgIds);
		// 求购
		String fkRedBuy = sysParaMap.get("FANGKAN_RED_BUY").getParamValue();
		String redFkpBuy = sysParaMap.get("RED_FANGKAN_PUBLIC_BUY").getParamValue();
		int buyActDays = StringUtil.parseInteger(fkRedBuy) + StringUtil.parseInteger(redFkpBuy);
		erpFunSaleMapper.updateHouseActionTimeByPlot(cityId, compId, "FUN_BUY_CUSTOMER", buyActDays, orgIds);
		// 求租
		String fkRedRent = sysParaMap.get("FANGKAN_RED_RENT").getParamValue();
		String redFkpRent = sysParaMap.get("RED_FANGKAN_PUBLIC_RENT").getParamValue();
		int rentActDays = StringUtil.parseInteger(fkRedRent) + StringUtil.parseInteger(redFkpRent);
		erpFunSaleMapper.updateHouseActionTimeByPlot(cityId, compId, "FUN_RENT_CUSTOMER", rentActDays, orgIds);
		// 3、4参数：跟进，更改TRACK_TIME
		// 不需要修改跟进时间了，因为跳抢逻辑已经改为另一个表控制
		// 出售
		String trackRedSell = sysParaMap.get("TRACK_RED_SELL").getParamValue();
		String redTrackPubSell = sysParaMap.get("RED_TRACK_PUBLIC_SELL").getParamValue();
		int sellTrackDays = StringUtil.parseInteger(redTrackPubSell) + StringUtil.parseInteger(trackRedSell);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_SALE", 0, sellTrackDays, orgIds);
		// 出租
		String trackRedLease = sysParaMap.get("TRACK_RED_LEASE").getParamValue();
		String redTrackPubLease = sysParaMap.get("RED_TRACK_PUBLIC_LEASE").getParamValue();
		int leaseTrackDays = StringUtil.parseInteger(trackRedLease) + StringUtil.parseInteger(redTrackPubLease);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_LEASE", 0, leaseTrackDays, orgIds);
		// 求购
		String trackRedBuy = sysParaMap.get("TRACK_RED_BUY").getParamValue();
		String redTrackPubBuy = sysParaMap.get("RED_TRACK_PUBLIC_BUY").getParamValue();
		int buyTrackDays = StringUtil.parseInteger(trackRedBuy) + StringUtil.parseInteger(redTrackPubBuy);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_BUY_CUSTOMER", 0, buyTrackDays, orgIds);
		// 求租
		String trackRedRent = sysParaMap.get("TRACK_RED_RENT").getParamValue();
		String redTrackPubRent = sysParaMap.get("RED_TRACK_PUBLIC_RENT").getParamValue();
		int rentTrackDays = StringUtil.parseInteger(trackRedRent) + StringUtil.parseInteger(redTrackPubRent);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_RENT_CUSTOMER", 0, rentTrackDays, orgIds);
		// 6、7参数：抢盘变公盘，更改TRACK_TIME
		// 出售
		String getPubRedSell = sysParaMap.get("GET_PUBLIC_RED_SELL").getParamValue();
		String getRedTrackPubSell = sysParaMap.get("GET_RED_TRACK_PUBLIC_SELL").getParamValue();
		int sellTDays = StringUtil.parseInteger(getRedTrackPubSell) + StringUtil.parseInteger(getPubRedSell);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_SALE", 1, sellTDays, orgIds);
		// 出租
		String getPubRedLease = sysParaMap.get("GET_PUBLIC_RED_LEASE").getParamValue();
		String getRedTrackPubLease = sysParaMap.get("GET_RED_TRACK_PUBLIC_LEASE").getParamValue();
		int leaseTdays = StringUtil.parseInteger(getPubRedLease) + StringUtil.parseInteger(getRedTrackPubLease);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_LEASE", 1, leaseTdays, orgIds);
		// 求购
		String getPubRedBuy = sysParaMap.get("GET_PUBLIC_RED_BUY").getParamValue();
		String getRedTrackPubBuy = sysParaMap.get("GET_RED_TRACK_PUBLIC_BUY").getParamValue();
		int buyTdays = StringUtil.parseInteger(getPubRedBuy) + StringUtil.parseInteger(getRedTrackPubBuy);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_BUY_CUSTOMER", 1, buyTdays, orgIds);
		// 求租
		String getPubRedRent = sysParaMap.get("GET_PUBLIC_RED_RENT").getParamValue();
		String getRedTrackPubRent = sysParaMap.get("GET_RED_TRACK_PUBLIC_RENT").getParamValue();
		int rentTdays = StringUtil.parseInteger(getPubRedRent) + StringUtil.parseInteger(getRedTrackPubRent);
		erpFunSaleMapper.updateHouseTrackTimeByPlot(cityId, compId, "FUN_RENT_CUSTOMER", 1, rentTdays, orgIds);
		// 9参数：抢盘无人获取变公盘，更改PUBLIC_TIME
		// 出售
		String pubNotgetCelSell = sysParaMap.get("PUBLIC_NOTGET_CANCEL_SELL").getParamValue();
		int sellPDays = StringUtil.parseInteger(pubNotgetCelSell);
		erpFunSaleMapper.updateHousePublicTimeByPlot(cityId, compId, "FUN_SALE", sellPDays, orgIds);
		// 出租
		String pubNotgetCelLease = sysParaMap.get("PUBLIC_NOTGET_CANCEL_LEASE").getParamValue();
		int leasePDays = StringUtil.parseInteger(pubNotgetCelLease);
		erpFunSaleMapper.updateHousePublicTimeByPlot(cityId, compId, "FUN_LEASE", leasePDays, orgIds);
		// 求购
		String pubNotgetCelBuy = sysParaMap.get("PUBLIC_NOTGET_CANCEL_BUY").getParamValue();
		int buyPDays = StringUtil.parseInteger(pubNotgetCelBuy);
		erpFunSaleMapper.updateHousePublicTimeByPlot(cityId, compId, "FUN_BUY_CUSTOMER", buyPDays, orgIds);
		// 求租
		String pubNotgetCelRent = sysParaMap.get("PUBLIC_NOTGET_CANCEL_RENT").getParamValue();
		int rentPDays = StringUtil.parseInteger(pubNotgetCelRent);
		erpFunSaleMapper.updateHousePublicTimeByPlot(cityId, compId, "FUN_RENT_CUSTOMER", rentPDays, orgIds);
	}


	@Override
	public void clearFlagByPlctSwotch(Integer cityId, Integer compType, Integer compId, Integer bussinessType) {
		if(!compType.equals(Const.DIC_COMP_TYPE_1)){ //只有企业版才做策略参数状态字段更新
			return;
		}
		List<Integer> orgIds = new ArrayList<>();
		if (bussinessType != null) {
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(cityId);
			erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationBussinessTypeEqualTo(bussinessType.byteValue()).andDelFlagEqualTo((byte) 0);
			List<ErpFunOrganization> organizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			orgIds = organizations.stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
		}
		erpFunSaleMapper.clearFlagByPlctSwotch(cityId, compId, orgIds);
	}

	/**
	 *  获取策略参数是否修改
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/3
	 */
	private boolean getPolicyAddDay(BaseMapParam param, Map<String,ErpSysPara> oldMap, String redParam, String pubParam) {
		String redEdit = param.getString(redParam);// 出售信息登记几天后未房勘，信息变为红色警告
		String pubEdit = param.getString(pubParam);// 红色警告后几天仍未房勘，信息转为抢盘
		if (StringUtil.isNotBlank(redEdit) || StringUtil.isNotBlank(pubEdit)) {
			int redOld = Integer.parseInt(oldMap.get(redParam).getParamValue());
			int pubOld = Integer.parseInt(oldMap.get(pubParam).getParamValue());
			int dayOld = redOld + pubOld;
			int dayNew = StringUtil.paseInteger(redEdit, redOld) + StringUtil.paseInteger(pubEdit, pubOld);
			return (dayNew - dayOld) < 0;
		}
		return false;
	}

	/**
	 * 修改无需审核项时修改审批方式
	 * @author 朱科
	 * @since 2018年9月25日
	 * @return
	 */
	private void updateAuditTypeAndUser(Integer cityId, Integer compId, String paraId, String newParamVal, String oldParamVal){
		Integer caseType = null;
		if("saleAutoExamApply".equals(paraId)) {
			caseType = Const.DIC_CASE_TYPE_SALE_FUN;
		} else if("leaseAutoExamApply".equals(paraId)) {
			caseType = Const.DIC_CASE_TYPE_LEASE_FUN;
		} else if("buyAutoExamApply".equals(paraId)) {
			caseType = Const.DIC_CASE_TYPE_BUY_CUST;
		} else if("rentAutoExamApply".equals(paraId)) {
			caseType = Const.DIC_CASE_TYPE_RENT_CUST;
		} else {
			return;
		}
		String tempParamVal = newParamVal + "," + oldParamVal;
		String[] newParamValArr = tempParamVal.split(",");
		for (String value : newParamValArr) {
			if (StringUtil.isBlank(value)) {
				continue;
			}
			if(oldParamVal.contains(value) && newParamVal.contains(value)){
				continue;
			}
			// 老的没有，新配的有（找不到就是要审核）
			if(oldParamVal.contains(value) && !newParamVal.contains(value)) {
				if("WEITUO".equals(value)) {
					// 限时、独家、普通委托
					for (Byte auditType : new Byte[]{6, 7, 19}) {
						this.createAuditTemplate(cityId, compId,caseType, auditType);
					}
				} else {
					Byte auditType = Const.AUDIT_ITEM_MAP.get(value);
					if(auditType != null) {
						this.createAuditTemplate(cityId, compId,caseType, auditType);
					}
				}
			} else if(!oldParamVal.contains(value) && newParamVal.contains(value)){
				Byte auditType = Const.AUDIT_ITEM_MAP.get(value);
				if(auditType != null){
					ErpAuditTemplate auditTemplate = erpAuditTemplateMapper.getAuditTemplate(cityId, compId, caseType, auditType);
					if(null == auditTemplate){
						continue;
					}
					auditTemplate.setShardCityId(cityId);
					erpAuditTemplateMapper.deleteByPrimaryKey(auditTemplate);
					ErpAuditUserTemplate auditUserTemplate = new ErpAuditUserTemplate();
					auditUserTemplate.setShardCityId(cityId);
					auditUserTemplate.setAuditId(auditTemplate.getId());
					erpAuditUserTemplateMapper.deleteByPrimaryKey(auditUserTemplate);
				}
			}
		}
	}

	private void createAuditTemplate(Integer cityId, Integer compId, Integer caseType, Byte auditType){
		ErpAuditTemplate auditTemplate = erpAuditTemplateMapper.getAuditTemplate(cityId, compId, caseType, auditType);
		// 新的有，老的没有，而且有配置过审批则不管了
		if(auditTemplate != null) {
			return;
		}
		Date nowTime = new Date();
		auditTemplate = new ErpAuditTemplate();
		auditTemplate.setAuditType(auditType.intValue());
		auditTemplate.setCaseType(caseType);
		auditTemplate.setCompId(compId);
		auditTemplate.setCreationTime(nowTime);
		auditTemplate.setUpdateTime(nowTime);
		auditTemplate.setNeedAudit((byte) 1);
		auditTemplate.setShardCityId(cityId);
		erpAuditTemplateMapper.insertSelective(auditTemplate);
		// 审批人配置
		ErpAuditUserTemplate auditUserTemplate = new ErpAuditUserTemplate();
		auditUserTemplate.setAuditId(auditTemplate.getId());
		auditUserTemplate.setAuditSeq(1);
		// 1=指定用户 2=申请方 3=房客源所属方 4=钥匙所在门店 5=直接上级 6=信息归属方有权限的人 7=钥匙归属方有权限的人（6、7自动配置时才用）
		auditUserTemplate.setAuditUserType(6);
		auditUserTemplate.setCreationTime(nowTime);
		auditUserTemplate.setExamineType((byte)0);
		auditUserTemplate.setShardCityId(cityId);
		erpAuditUserTemplateMapper.insertSelective(auditUserTemplate);
	}

	/**
	 * 支付宝租赁佣金比列
	 * @author 朱科
	 * @since 2018年9月25日
	 * @return
	 */
	private void dealLeaseHouseRate(Integer cityId, String compNo, Integer compId, String paramValue){
		List<ErpFunBrokerage> dataList = erpFunBrokerageMapper.getBrokerageByCompId(cityId, compId, 102);
		if(null != dataList && !dataList.isEmpty()){
			ErpFunBrokerage erpFunBrokerage = dataList.get(0);
			this.updateBrokerAge(erpFunBrokerage, paramValue);
			erpFunBrokerage.setShardCityId(cityId);
			erpFunBrokerageMapper.updateByPrimaryKey(erpFunBrokerage);
		} else {
			dataList = erpFunBrokerageMapper.getBrokerageByCompId(cityId, 0, null);
			for (ErpFunBrokerage erpFunBrokerage : dataList) {
				if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(erpFunBrokerage.getSaleLease())){
					this.updateBrokerAge(erpFunBrokerage, paramValue);
				}
				erpFunBrokerage.setId(null);
				erpFunBrokerageMapper.insertSelective(erpFunBrokerage);
			}
		}
		AdminZfbHouseBatchUpdate adminZfbHouseBatchUpdate = new AdminZfbHouseBatchUpdate();
		adminZfbHouseBatchUpdate.setCompNo(compNo);
		adminZfbHouseBatchUpdate.setCreateTime(new Date());
		adminZfbHouseBatchUpdate.setDealStatus((byte)0);
		adminZfbHouseBatchUpdateMapper.insertSelective(adminZfbHouseBatchUpdate);
	}

	private void updateBrokerAge(ErpFunBrokerage erpFunBrokerage, String paramValue) {
		BigDecimal bigDecimal = new BigDecimal(paramValue);
		erpFunBrokerage.setBrokerageRate(bigDecimal);
		BigDecimal divide = bigDecimal.divide(new BigDecimal(2), 2, BigDecimal.ROUND_HALF_EVEN);
		erpFunBrokerage.setChargeHouseRate(divide);
		erpFunBrokerage.setChargeCustRate(divide);
		erpFunBrokerage.setBrokerCustRate(divide.multiply(new BigDecimal(100)));
		erpFunBrokerage.setBrokerHouseRate(divide.multiply(new BigDecimal(100)));
	}

	/**
	 * 开启或者关闭栋、单元、号
	 * @author 朱科
	 * @since 2018年9月26日
	 * @return
	 */
	private void openOrCloseRoofUnitNum(Integer cityId, Integer compId, String paramId, String paramValue){
		// 先删除erp库
		String coreInfoValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
		int templateCompId;
		if(StringUtil.isBlank(coreInfoValue) || "0".equals(coreInfoValue)){
			//栋座号模板
			templateCompId = 1;
		} else {
			//弄号室模板
			templateCompId = 2;
		}

		/**
		 * 开启栋、单元、号,删除模板中有的参数,最后再添加回来(防止将定制的删除到了，比如CREATION_TIME 登记时间，TRACK_TIME 跟进时间)
		 * 关闭栋、单元、号,只删除"SALE_ROOF_T", "SALE_UNIT_T", "SALE_NUM_T", "LEASE_ROOF_T", "LEASE_UNIT_T", "LEASE_NUM_T"
		 * */
		if("1".equals(paramValue)){
			ErpFunHeadExample example  = new ErpFunHeadExample();
			example.createCriteria().andCompIdEqualTo(templateCompId);
			example.setShardCityId(cityId);
			List<ErpFunHead> funHeads = erpFunHeadMapper.selectByExample(example);
			erpFunHeadMapper.deleteFunHead(cityId, compId, funHeads);
		} else {
			ErpFunHeadExample example  = new ErpFunHeadExample();
            List<String> list;
            if ("IS_SHOW_HOUSE_ROOF".equals(paramId)) {
                list = Arrays.asList("SALE_ROOF_T", "LEASE_ROOF_T");
            } else if ("IS_SHOW_HOUSE_UNIT".equals(paramId)) {
                list = Arrays.asList("SALE_UNIT_T", "LEASE_UNIT_T");
            } else {
                list = Arrays.asList("SALE_NUM_T", "LEASE_NUM_T");
            }
			example.createCriteria().andCompIdEqualTo(templateCompId).andHeadValueIn(list);
			example.setShardCityId(cityId);
			List<ErpFunHead> funHeads = erpFunHeadMapper.selectByExample(example);
			erpFunHeadMapper.deleteFunHead(cityId, compId, funHeads);
		}

		// 清除缓存
		cacheUtil.del(CacheStructure.hfterpdb_commonCache_funHead_map);
		if("1".equals(paramValue)){
			AdminRptFunHeadExample funHeadExample = new AdminRptFunHeadExample();
			AdminRptFunHeadExample.Criteria adminRptFunHeadExample = funHeadExample.createCriteria();
			//核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
			if(StringUtil.isBlank(coreInfoValue) || "0".equals(coreInfoValue)){
				//栋座号模板
				adminRptFunHeadExample.andCompIdEqualTo(1);
			} else {
				//弄号室模板
				adminRptFunHeadExample.andCompIdEqualTo(2);
			}
			List<AdminRptFunHead> rptFunHeadList = adminRptFunHeadMapper.selectByExample(funHeadExample);
			/*
			此处 paramValue必为1，所以注释掉
			 */
//			Iterator<AdminRptFunHead> iterator = rptFunHeadList.iterator();
//			String isShowHouseRoof = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_HOUSE_ROOF");
//			String isShowHouseUnit = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_HOUSE_UNIT");
//			String isShowHouseNum = erpSysParaMapper.getParamValue(cityId, compId, "IS_SHOW_HOUSE_NUM");
//			while (iterator.hasNext()) {
//				AdminRptFunHead next = iterator.next();
//				if("IS_SHOW_HOUSE_ROOF".equals(paramId) && "0".equals(paramValue) && ("SALE_ROOF_T".equals(next.getHeadValue()) || "LEASE_ROOF_T".equals(next.getHeadValue()))) {
//					iterator.remove();
//				} else if (paramId.equals("IS_SHOW_HOUSE_UNIT") && "0".equals(paramValue) && ("SALE_UNIT_T".equals(next.getHeadValue()) || "LEASE_UNIT_T".equals(next.getHeadValue()))) {
//					iterator.remove();
//				} else if (paramId.equals("IS_SHOW_HOUSE_NUM") && "0".equals(paramValue) && ("SALE_NUM_T".equals(next.getHeadValue()) || "LEASE_NUM_T".equals(next.getHeadValue()))) {
//					iterator.remove();
//				}
//			}
			for (AdminRptFunHead adminRptFunHead : rptFunHeadList) {
				ErpFunHead erpFunHead = new ErpFunHead();
				erpFunHead.setCompId(compId);
				erpFunHead.setCaseType(adminRptFunHead.getCaseType());
				erpFunHead.setHeadName(adminRptFunHead.getHeadName());
				erpFunHead.setHeadValue(adminRptFunHead.getHeadValue());
				erpFunHead.setHeadSeq(adminRptFunHead.getHeadSeq());
				erpFunHead.setHeadType(adminRptFunHead.getHeadType());
				erpFunHead.setHeadShow(adminRptFunHead.getHeadShow());
				erpFunHead.setHeadUpdateTime(adminRptFunHead.getHeadUpdateTime());
				erpFunHead.setHeadRatio(adminRptFunHead.getHeadRatio());
				erpFunHead.setShardCityId(cityId);
				// 最后将rpt库模板写入到erp库
				erpFunHeadMapper.insertSelective(erpFunHead);
			}
			// 清除缓存
			cacheUtil.del(CacheStructure.hfterpdb_commonCache_funHead_map);
		}
	}


	@Override
	@Transactional
	public void mlEntrustParamSetting(UpdateEntrustFileConfigParam param, Operator operator) {
		if (param.getOpenElectronicEntrust() != null) {
			ErpSysPara erpSysPara = new ErpSysPara();
			erpSysPara.setShardCityId(operator.getCityId());
			erpSysPara.setParamId("IS_OPEN_ELECTRONIC_ENTRUST");
			erpSysPara.setCompId(operator.getCompId());
			erpSysPara.setParamValue(param.getOpenElectronicEntrust().toString());
			erpSysPara.setParamType("int");
			erpSysPara.setParamDesc("是否开启电子委托 0=否 1=是");
			erpSysPara.setDefaultValue("1");
			erpSysPara.setNeedRelogin((byte)0);
			erpSysPara.setMediumValue("0");
			erpSysPara.setSeniorValue("0");
			erpSysPara.setPartnerId(0);
			if (erpSysParaMapper.mlEntrustParamSetting(operator.getCityId(), erpSysPara) < 1) {
				throw new BusinessException("已更新！请勿重复请求！");
			}
		}
		if (param.getDataSharing() != null) {
			ErpSysPara erpSysPara = new ErpSysPara();
			erpSysPara.setShardCityId(operator.getCityId());
			erpSysPara.setParamId("IS_SHARE_ENTRUST_DATA");
			erpSysPara.setCompId(operator.getCompId());
			erpSysPara.setParamValue(param.getDataSharing().toString());
			erpSysPara.setParamType("int");
			erpSysPara.setParamDesc("租售房源委托资料是否共用 0=否 1=是");
			erpSysPara.setDefaultValue("1");
			erpSysPara.setNeedRelogin((byte)0);
			erpSysPara.setMediumValue("0");
			erpSysPara.setSeniorValue("0");
			erpSysPara.setPartnerId(0);
			if (erpSysParaMapper.mlEntrustParamSetting(operator.getCityId(), erpSysPara) < 1) {
				throw new BusinessException("已更新！请勿重复请求！");
			}
		}
	}

	@Override
	public boolean isOpenNewOrganization(Integer cityId, Integer compId) {
		String paraValue = erpSysParaMapper.getParamValue(cityId, compId, "ORGANIZATION_TYPE");
		return "1".equals(paraValue);
	}

	// 隐号拨打设置
	private List<String> implicitCallApartParams = Arrays.asList("IS_OPEN_HIDEPHONE", "IS_OPEN_HIDE_SELF_PHONE_HOUSE", "IS_OPEN_HIDE_SELF_PHONE_CUSTOMER",
			"IPCALL_HIDEPHONE_COUNT", "IPCALL_AREA_HIDEPHONE_COUNT", "VOIP_USE_COMP_MONEY");
    // 新隐号拨打设置
    private List<String> callApartParams = Arrays.asList("DIRECTLY_LEADER_CAN_VIEW_OWNER_PHONE", "VIEW_OWNER_PHONE_CONTROL_BY_COMP_OR_ROLE",
            "VIEW_OWNER_PHONE_CONTROL_BY_ROLE", "VIEW_OWNER_PHONE_COUNT_BY_NOT_CREATOR");
	// 列表信息显示范围
	private List<String> lookRangeParams = Arrays.asList("LOOK_HOUSE_RANGE", "LOOK_CUST_RANGE");
	// 手机查看限制
	private List<String> viewPhoneParams = Collections.singletonList("ALLOW_PER_VIEWPHONE");
	// 合作配置
	private List<String> cooperateParams = Collections.singletonList("ALLOW_CITY_COOPERATE");
	// 判重规则
	private List<String> repeatParams = Arrays.asList("HOUSEDATA_MUSTBE_ONLYONE", "HOUSE_REPEAT_RANGE", "SHOP_WAREHOUSE_REPEAT_TYPE",
			"CUSTDATA_MUSTBE_ONLYONE", "CUST_REPEAT_RANGE");
	// 钥匙管理配置
	private List<String> keyParams = Arrays.asList("BORROW_KEY_PRICE", "MAX_BORROW_HOUR");
    // 系统拨号配置
    private List<String> sysCallParams = Collections.singletonList("AUTO_BIND_AXN");
	// 核心信息检索、显示配置
	private List<String> inputParams = Arrays.asList("ALLOW_INPUT_PHONE", "ONLY_INPUT_LOCK_BUILD_ROOM", "MODIFY_PRICE_SHOW_DAY", "ALLOW_QUERY_ROOF",
			"IS_SHOW_HOUSE_ROOF", "IS_SHOW_HOUSE_UNIT", "IS_SHOW_HOUSE_NUM", "DEAL_WILL_SHOW_PHONENUM", "RENT_INNERDEAL_CORE_INFO_HIDE_DAY");
	// 房客源核心信息查看条数配置
	private List<String> coreInfoParams = Arrays.asList("SHARE_FUN_CORE_DEPT", "SHARE_FUN_CORE_OTHER", "SHARE_CUST_CORE_DEPT", "SHARE_CUST_CORE_OTHER",
			"SHARE_FUN_CORE_DEPT_DEF_ID", "SHARE_FUN_CORE_OTHER_DEF_ID", "SHARE_CUST_CORE_DEPT_DEF_ID", "SHARE_CUST_CORE_OTHER_DEF_ID");
	// 转盘规则
	private List<String> transPlateRuleParams = Arrays.asList("HOUSE_TRANSFER_FOR_WHO", "PRIVATE_HOUSE_TRANSFER", "PUBLIC_HOUSE_TRANSFER",
			"PUBLIC_CUST_TRANSFER", "PRIVATE_HOUSE_TRANSFER_PUBLIC", "PRIVATE_CUST_TRANSFER_PUBLIC");
	// 公盘抢盘配置
	private List<String> plateRangeParams = Arrays.asList("SHARE_HOUSE_RANGE", "SHARE_CUST_RANGE", "PUBLIC_HOUSE_RANGE", "PUBLIC_CUST_RANGE");
	// 工作台业绩显示配置
	private List<String> showParams = Arrays.asList("IS_SHOW_PROFIT_DATA", "INDEX_PROFIT_SHOW_TYPE");
	// 薪资结算配置
	private List<String> wageParams = Arrays.asList("NEW_USER_WAGE_ASSESSMENT", "UPDATE_WAGE_CONFIG_EFFECTIVE", "UPDATE_ORG_USER_COUNT_BELONG");
	// 好房豆配置
	private List<String> amountParams = Collections.singletonList("HF_AMOUNT_CANUSE");
	// 跟进配置
	private List<String> trackParams = Collections.singletonList("TRACKCONTENT_LENGTH");
	// 房源发官网的相关设置
	private List<String> publishParams = Arrays.asList("SECOND_HAND_HOUSE_PUBLISH_WEBSITE_SET", "SECOND_HAND_HOUSE_WITH_RESERVE_CASE_CODE",
			"SECOND_HAND_HOUSE_WITH_ENTRUST_CODE", "SECOND_HAND_HOUSE_WITH_DESC", "SECOND_HAND_HOUSE_WITH_SPECIFICATION", "SECOND_HAND_HOUSE_PRICE_CHANGE",
			"SECOND_HAND_HOUSE_AREA_CHANGE", "SECOND_HAND_HOUSE_ALL_RELATED_MAN_DELETE", "SECOND_HAND_HOUSE_CHANGE_INVALID", "SECOND_HAND_HOUSE_ENTRUST_EXPIRE",
			"SECOND_HAND_HOUSE_ANY_FILE_DELETE", "RENT_HOUSE_PUBLISH_WEBSITE_SET", "RENT_HOUSE_WITH_RESERVE_CASE_CODE", "RENT_HOUSE_WITH_ENTRUST_CODE",
			"RENT_HOUSE_WITH_DESC", "RENT_HOUSE_WITH_SPECIFICATION", "RENT_HOUSE_PRICE_CHANGE", "RENT_HOUSE_AREA_CHANGE", "RENT_HOUSE_ALL_RELATED_MAN_DELETE",
			"RENT_HOUSE_CHANGE_INVALID", "RENT_HOUSE_ENTRUST_EXPIRE", "RENT_HOUSE_ANY_FILE_DELETE", "NEW_HOUSE_BROKERAGE_IN_DATE", "NEW_HOUSE_HAVE_THREE_PIC",
			"NEW_HOUSE_HAVE_PRESELL_LICENSE_PIC", "NEW_HOUSE_HAVE_DEVELOPER_BUSINESS_LICENSE_PIC", "NEW_HOUSE_IN_INNER_PROMOTION_PERIOD");

    // 普通管控 中度管控 深度管控
    private List<String> templateParams = Collections.singletonList("SYSTEM_PARAM_TEMPLATE");
    // 房源登记配置
    private List<String> createFunParams = Arrays.asList("REGISTER_SALE_ALLOW_AUDIT", "REGISTER_LEASE_ALLOW_AUDIT", "SEND_WEBSITE", "ENTRY_DEAL_INFO",
            "APPOINTMENT_CAMERAMAN", "TRACK_FUN", "RELEASE_PORT", "INCLUDED_WORKCOUNT");
    // 内容为经纪人【 】天未登录，提醒该经纪人直属上级
    private List<String> leaderDayParams = Collections.singletonList("SEND_LEADER_DAYS");
    // 委托管理配置
    private List<String> entrustParams = Arrays.asList("IS_OPEN_ELECTRONIC_ENTRUST", "IS_SHARE_ENTRUST_DATA");
    // 委托管理配置
    private List<String> picParams = Arrays.asList("ALLOW_UPLOAD_SALE_HOUSE_LAYOUT_PIC_ML", "ALLOW_UPLOAD_LEASE_HOUSE_PIC_ML",
            "ALLOW_UPLOAD_SALE_HOUSE_PIC_ML", "ALLOW_UPLOAD_LEASE_HOUSE_LAYOUT_PIC_ML");
	// 房源无效
	private List<String> houseInvalidParams = Arrays.asList("SALE_INVALID_REMIND_COUNT", "LEASE_INVALID_REMIND_COUNT");
	// 每日公客号码拨打次数限制
	private List<String> callLimitParams = Collections.singletonList("CUST_CALL_LIMIT_EVERY_DAY");
	// 短信验证控制系统参数 登记 ：HOUSE_SMS_VERIFICATION_REGISTER
    // 短信验证控制系统参数 内成交转有效：HOUSE_SMS_VERIFICATION_INNERDEAL_TRANS_AVALIABLE
    // 短信验证控制系统参数 外成交转有效：HOUSE_SMS_VERIFICATION_OUTERDEAL_TRANS_AVALIABLE
    // 短信验证控制系统参数 暂缓交转有效：HOUSE_SMS_VERIFICATION_RESPITE_TRANS_AVALIABLE
    // 短信验证控制系统参数 删除交转有效：HOUSE_SMS_VERIFICATION_WRITEOFF_TRANS_AVALIABLE
    // 短信相关
    private List<String> smsParams = Arrays.asList("HOUSE_SMS_VERIFICATION_REGISTER", "HOUSE_SMS_VERIFICATION_INNERDEAL_TRANS_AVALIABLE",
            "HOUSE_SMS_VERIFICATION_OUTERDEAL_TRANS_AVALIABLE", "HOUSE_SMS_VERIFICATION_RESPITE_TRANS_AVALIABLE", "HOUSE_SMS_VERIFICATION_WRITEOFF_TRANS_AVALIABLE");
    // 开启房源投诉功能系统参数
    private List<String> complaintParams = Collections.singletonList("OPEN_HOUSE_DETAIL_COMPLAIN");
    // 渠道客自动转公时间（天）
    private List<String> autoTransParams = Collections.singletonList("CUST_AUTO_TRANS_PUBLIC_DAY");
	// 摄影师
	private List<String> shootParams = Arrays.asList("AUTO_CANCEL_SHOOTING_FLAG", "AUTO_CANCEL_SHOOTING_TIME");
	// 新隐号拨打设置-角色
	private List<String> callApartRoleSysParams = Collections.singletonList("VIEW_OWNER_PHONE_CONTROL_BY_ROLE%");
	// 房客源核心信息查看条数配置-角色
	private List<String> coreInfoRoleParams = Arrays.asList("VIEW_HOUSE_COUNT_SELF%", "VIEW_HOUSE_COUNT_OTHER%", "VIEW_CUST_COUNT_SELF%", "VIEW_CUST_COUNT_OTHER%");
	private List<String> params = Stream.of(implicitCallApartParams, lookRangeParams, viewPhoneParams, cooperateParams, repeatParams, keyParams,
			inputParams, transPlateRuleParams, plateRangeParams, showParams, wageParams, amountParams, trackParams, coreInfoParams,
			publishParams, templateParams, callApartParams, createFunParams, leaderDayParams, entrustParams, picParams, sysCallParams,
			houseInvalidParams, callLimitParams, smsParams, complaintParams, autoTransParams, shootParams)
			.flatMap(List::stream).collect(Collectors.toList());
	private List<String> roleParams = Stream.of(coreInfoRoleParams, callApartRoleSysParams).flatMap(List::stream).collect(Collectors.toList());

	@Override
	@Transactional
	public void sysParamConfigInMeiLian(GeneralParam generalParam, SysParamConfigInMeiLianParam param) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		Byte businessApart = param.getBusinessApart();

		ErpFunComp compCondition = new ErpFunComp(cityId, compId);
		ErpFunComp erpFunComp = erpFunCompMapper.selectByPrimaryKey(compCondition);
		if (erpFunComp == null) {
			throw new BusinessException("公司不存在");
		}

		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(cityId);
		erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andDelFlagEqualTo((byte) 0);
		List<ErpFunOrganization> organizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
		// 如果公司没有组织, 直接返回
		if (CollectionUtils.isEmpty(organizations)) {
			throw new BusinessException("公司暂无组织，不用独立配置");
		}

		// 公司上的开启关闭单独配置标志
		ErpFunComp condition = new ErpFunComp();
		condition.setShardCityId(cityId);
		condition.setCompId(compId);
		condition.setBusinessApart(businessApart);
		erpFunCompMapper.updateByPrimaryKeySelective(condition);

		if (businessApart == 0) {
			// 关闭单独配置 0=初始(公司) 1=住宅 2=工商铺 3=后勤部门
			// 清除初始(公司)外的系统参数
			erpSysParaMapper.cleanPartnerSysParam(cityId, compId, params);
			// 清除初始(公司)外的角色系统参数
			erpSysParaMapper.cleanCompPartnerSysParam(cityId, compId, roleParams);
		} else {
			// 开启单独配置 0=初始(公司)拷贝到1=住宅 2=工商铺 3=后勤部门
			this.copySysParam(cityId, compId, Arrays.asList(1, 2, 3), params);
			this.copyRoleSysParam(cityId, compId, Arrays.asList(1, 2, 3), roleParams);
		}
	}

	private void copySysParam(Integer cityId, Integer compId, List<Integer> types, List<String> sysParams) {
		// 清空加盟商的系统参数设置, 除了公司的都清除掉, 防止已经有参数但是重复插入
		// 复制系统参数设置到加盟商设置中, 给所有加盟商都配置一份
		erpSysParaMapper.cleanPartnerSysParam(cityId, compId, sysParams);
		erpSysParaMapper.copyCompSysParamToPartner(cityId, compId, types, sysParams);
	}

	private void copyRoleSysParam(Integer cityId, Integer compId, List<Integer> types, List<String> roleSysParams) {
		// 复制系统参数设置到加盟商设置中, 给所有加盟商都配置一份
		// 按角色配置到加盟商设置中
		erpSysParaMapper.cleanCompPartnerSysParam(cityId, compId, roleSysParams);
		erpSysParaMapper.copyCompRoleSysParamToPartner(cityId, compId, types, roleSysParams);
	}

	/** 跳公策略参数 **/
	private List<String> strategySysParams = Arrays.asList(
			// 基本策略
			"PASSWORD_RECORDS", "INFO_MAX_SECRECY", "WARMDAY_OF_RENTDUE", "RESPITE_PROTECT_DAYS", "RESPITE_DAYS_STRATEGY_STATUS",
			"DEPT_COMMEND_RECORDS", "COMMEND_RECORDS", "INFO_MAX_COMMEND_DAYS", "INFO_MAX_FOCUS_DAYS",
			// 出售房源
			"TRACK_RED_SELL", "RED_TRACK_PUBLIC_SELL", "SALE_TRACK_STRATEGY_STATUS",
			// 出租房源
			"TRACK_RED_LEASE", "RED_TRACK_PUBLIC_LEASE", "LEASE_TRACK_STRATEGY_STATUS",
			// 求购客户
			"TRACK_RED_BUY", "RED_TRACK_PUBLIC_BUY",  "BUY_TRACK_STRATEGY_STATUS", "TRACK_RED_BUY_SHARE",
            "TRACK_RED_BUY_SHARE_DEFID_STRATEGY_STATUS",
			// 新房客户
			"TRACK_RED_NEWHOUSE", "RED_TRACK_PUBLIC_NEWHOUSE", "NEWHOUSE_TRACK_STRATEGY_STATUS",
			"TRACK_RED_NEWCUST_SHARE", "TRACK_RED_NEWCUSTSHARE_DEFID_STRATEGY_STATUS",
			// 求租客户
			"TRACK_RED_RENT", "RED_TRACK_PUBLIC_RENT", "RENT_TRACK_STRATEGY_STATUS", "TRACK_RED_RENT_SHARE",
            "TRACK_RED_RENT_SHARE_DEFID_STRATEGY_STATUS"
	);

    private List<String> strategySysParamsDef = Arrays.asList(
            // 基本策略
            "TRANS_WRITEOFF_USERR_HOUSE_DATA", "TRANS_WRITEOFF_USERR_CUST_DATA",
            // 出售房源
             "RED_TRACK_PUBLIC_SELL_DEFID",
            // 出租房源
            "RED_TRACK_PUBLIC_LEASE_DEFID",
            // 求购客户
             "RED_TRACK_PUBLIC_BUY_DEFID", "TRACK_RED_BUY_SHARE_DEFID",
            // 新房客户
            "RED_TRACK_PUBLIC_NEWHOUSE_DEFID", "TRACK_RED_NEWCUST_SHARE_DEFID",
            // 求租客户
            "RED_TRACK_PUBLIC_RENT_DEFID", "TRACK_RED_RENT_SHARE_DEFID"
    );

	/** 添加组织时拷贝跳公策略参数 **/
	@Override
	@Transactional
	public void copyParameterStrategy(Integer cityId, Integer compId, Integer organizationId) {
        erpSysParaMapper.copyParameterStrategy(cityId, compId, organizationId, strategySysParams);

        ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, organizationId);
        if (erpFunOrganization != null) {
            Integer defId = erpFunOrganization.getOrganizationDefinitionId();
            // 带跳级的参数默认本级
            erpSysParaMapper.copyParameterStrategyWithDef(cityId, compId, organizationId, strategySysParamsDef, defId);
        }
	}

	/**
	 * ===========================================================美联系统参数查询========================================================================
	 *
	 * 系统参数查询，按经纪人所属部门类型，ORGANIZATION_BUSSINESS_TYPE 1=住宅 2=工商铺 3=后勤部门 分开管控配置
	 * 查询时：BUSINESS
	 * 1.公司表erp fun_comp 上分开管控标记
	 * 2.fun_organization 	ORGANIZATION_BUSSINESS_TYPE 标记了部门类型，可知道经纪人所属类型
	 * 3.分开管控时查询对应erp..sys_para [PARTNER_ID] <-->[fun_organization..ORGANIZATION_BUSSINESS_TYPE]对应值【1,2,3↑】
	 * 4.查询时需要带指定经纪人userId
	 */
	//查询单个参数
	private ErpSysPara getSysParamByBusinessType(Integer cityId, Integer compId, Integer businessType, String sysParamId) {
		//总店及直营使用同一套配置 配置表中 partnerId = 0 表示总店及直营所属
		businessType = (businessType == null || businessType <= 0) ? 0 : businessType;
		List<ErpSysPara> sysParamList = erpSysParaMapper.selectMLParamWithBusinessType(cityId, compId, businessType, sysParamId);
		if (sysParamList.isEmpty()) {
			return null;
		}
		return sysParamList.stream().max(Comparator.comparing(ErpSysPara::getPartnerId)).get();
	}
	//同时查询多个参数
	private List<ErpSysPara> getSysParamListByBusinessType(Integer cityId, Integer compId, Integer businessType, List<String> sysParamIds) {
		//总店及直营使用同一套配置 配置表中 partnerId = 0 表示总店及直营所属
		businessType = (businessType == null || businessType <= 0) ? 0 : businessType;
		Integer finalType = businessType;
		List<ErpSysPara> list = erpSysParaMapper.selectMLParamWithParamIds(cityId, compId, businessType, sysParamIds);
		Map<String, ErpSysPara> map = list.stream().collect(Collectors.toMap(ErpSysPara::getParamId, Function.identity(), (obj1, obj2) -> {
			if (Objects.equals(obj1.getPartnerId(), finalType)) {
				return obj1;
			} else {
				return obj2;
			}
		}));
		return new ArrayList<>(map.values());
	}
	/**
	 * 美联查询系统参数 default null
	 */
	@Override
	public ErpSysPara getMLSysParamByUserType(Integer cityId, Integer compId, Integer userId, String paramId){
		PartnerInfoDto userInfo = erpFunUsersMapper.selectMLUserInfoByUserId(cityId, compId, userId);
		if (Objects.isNull(userInfo)) {
			return this.getSysParamByBusinessType(cityId, compId, 0, paramId);
		}
		//查询经纪人所属组织类型
		ErpFunOrganization org = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId,userInfo.getOrganizationId());
		//默认类型0
		Integer businessType = Optional.ofNullable(org).map(ErpFunOrganization::getOrganizationBussinessType).map(Byte::intValue).orElse(0);
		return this.getSysParamByBusinessType(cityId, compId, businessType, paramId);
	}


	/**
	 * 美联查询系统参数列表
	 */
	@Override
	public List<ErpSysPara> getMLSysParamList(Integer cityId, Integer compId, Integer userId, List<String> paramIds){
		PartnerInfoDto userInfo = erpFunUsersMapper.selectMLUserInfoByUserId(cityId, compId, userId);
		if (Objects.isNull(userInfo)) {
			return this.getSysParamListByBusinessType(cityId, compId, 0, paramIds);
		}
		//查询经纪人所属组织类型
		ErpFunOrganization org = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId,userInfo.getOrganizationId());
		//默认类型0
		Integer businessType = Optional.ofNullable(org).map(ErpFunOrganization::getOrganizationBussinessType).map(Byte::intValue).orElse(0);
		return this.getSysParamListByBusinessType(cityId, compId, businessType, paramIds);
	}

	/**
	 * 默认值为 ""
	 */
	@Override
	public String getMLSysParamValByUserDefEmpty(Integer cityId, Integer compId, Integer userId, String paramId) {
		ErpSysPara sysParam = this.getMLSysParamByUserType(cityId, compId, userId, paramId);
		return Optional.ofNullable(sysParam).map(ErpSysPara::getParamValue).orElse("");
	}

	/**
	 * 默认值为 "0"
	 */
	@Override
	public String getMLSysParamValByUserDefZero(Integer cityId, Integer compId, Integer userId, String paramId) {
		ErpSysPara sysParam = this.getMLSysParamByUserType(cityId, compId, userId, paramId);
		return Optional.ofNullable(sysParam).map(ErpSysPara::getParamValue).orElse("0");
	}


	/**
	 * 美联查询系统参数列表 每个参数均会返回值，无值默认""
	 */
	@Override
	public List<ErpSysPara> getMLSysParamListDefEmpty(Integer cityId, Integer compId, Integer userId, List<String> paramIds){
		return this.getMLSysParamListWithDefVal(cityId, compId, userId, paramIds, "");
	}

	/**
	 * 美联查询系统参数列表 每个参数均会返回值，无值默认""
	 */
	@Override
	public List<ErpSysPara> getMLSysParamListDefZero(Integer cityId, Integer compId, Integer userId, List<String> paramIds){
		return this.getMLSysParamListWithDefVal(cityId, compId, userId, paramIds, "0");
	}

	/**
	 * 美联查询系统参数列表 每个参数均会返回值，无值默认""
	 */
	private List<ErpSysPara> getMLSysParamListWithDefVal(Integer cityId, Integer compId, Integer userId, List<String> paramIds,final String defVal){
		List<ErpSysPara> paramList = this.getMLSysParamList(cityId, compId, userId, paramIds);
		Map<String, ErpSysPara> paramMap = paramList.stream().collect(Collectors.toMap(ErpSysPara::getParamId, Function.identity()));
		return paramIds.stream().map(paramId -> {
			ErpSysPara erpSysPara = paramMap.get(paramId);
			if (Objects.isNull(erpSysPara)) {
				erpSysPara = new ErpSysPara();
				erpSysPara.setParamId(paramId);
				erpSysPara.setParamValue(defVal);
			}
			return erpSysPara;
		}).collect(ArrayList::new, List::add, List::addAll);
	}

	/**
	 * 美联查询系统参数Map
	 */
	@Override
	public Map<String,String> getMLSysParamMapByUserType(Integer cityId, Integer compId, Integer userId, List<String> paramIds){
		List<ErpSysPara> list = this.getMLSysParamList(cityId, compId, userId, paramIds);
		return list.stream().collect(HashMap::new,(m,e)->m.put(e.getParamId(),e.getParamValue()), HashMap::putAll);
	}
	/**
	 * 特殊查询
	 */
	@Override
	public Map<String, Map<String, Object>> getMLSysParaMap(Integer cityId, Integer compId, Integer userId, List<String> sysParas) {

		Map<String, Map<String, Object>> mapMap = new HashMap<>();

		Map<String, String> sysParaList = this.getMLSysParamMapByUserType(cityId, compId, userId, sysParas);
		for (String key : sysParaList.keySet()) {
			Map<String, Object> paramValue = new HashMap<>();
			paramValue.put("paramValue", sysParaList.get(key));
			paramValue.put("paramId", key);
			mapMap.put(key, paramValue);
		}
		return mapMap;
	}
	/**
	 * ===========================================================美联系统参数查询========================================================================
	 */


	@Transactional
	@Override
	public boolean updateMgrParameterStrategy(BaseMapParam param) {
		Integer compId = param.getInteger("compId");
		Integer cityId = param.getInteger("cityId");
		Integer organizationId = param.getInteger("organizationId");
		// 该组织自己的策略参数
		Map<String, ErpSysPara> oldMap = this.getSysParaByOrgId(cityId, compId, organizationId);
		if (oldMap == null || oldMap.isEmpty()) {
			throw new BusinessException("该组织策略参数没有初始化！");
		}
		// 前端传上来的策略参数Map
		Map<String, String> newParaMap = new HashMap<>();
		for (String key : param.getMap().keySet()) {
			Object value = param.getMap().get(key);
			if (value != null) {
				newParaMap.put(key, value.toString());
			}
		}
		//老的时间大于了新的时间那么，就把TRACK_TIME更新成当前的时间
		/*最后跟进时间*/
		// 出售
		boolean trackPubSaleDay = this.getPolicyAddDay(param, oldMap, "TRACK_RED_SELL", "RED_TRACK_PUBLIC_SELL");
		if (trackPubSaleDay) {
			// 传上来的参数执行或者不执行求购跟进参数策略
			if (!newParaMap.isEmpty() && newParaMap.containsKey("SALE_TRACK_STRATEGY_STATUS")) {
				// 如果是执行跟进参数策略, 则更新最后跟进日期 trackTime
				if ("1".equals(String.valueOf(newParaMap.get("SALE_TRACK_STRATEGY_STATUS")))) {
					//20-5-19 wc task#141368 美联 去掉非手写跟进更改更近时间
//					erpFunSaleService.updateHouseTrackTimeByOrg(cityId, compId, "0", Collections.singletonList(organizationId));
				}
			}
		}
		// 出租    
		boolean trackPubLeaseDay = this.getPolicyAddDay(param, oldMap, "TRACK_RED_LEASE", "RED_TRACK_PUBLIC_LEASE");
		if (trackPubLeaseDay) {
			// 传上来的参数执行或者不执行求购跟进参数策略
			if (!newParaMap.isEmpty() && newParaMap.containsKey("LEASE_TRACK_STRATEGY_STATUS")) {
				// 如果是执行跟进参数策略, 则更新最后跟进日期 trackTime
				if ("1".equals(String.valueOf(newParaMap.get("LEASE_TRACK_STRATEGY_STATUS")))) {
					//20-5-19 wc task#141368 美联 去掉非手写跟进更改更近时间
//					erpFunLeaseService.updateHouseTrackTimeByOrg(cityId, compId, "0", Collections.singletonList(organizationId));
				}
			}
		}
		// 求购-二手房
		boolean trackPubBuyDay = this.getPolicyAddDay(param, oldMap, "TRACK_RED_BUY", "RED_TRACK_PUBLIC_BUY");
		if (trackPubBuyDay) {
			// 传上来的参数执行或者不执行求购跟进参数策略
			if (!newParaMap.isEmpty() && newParaMap.containsKey("BUY_TRACK_STRATEGY_STATUS")) {
				// 如果是执行跟进参数策略, 则更新最后跟进日期 trackTime
				if ("1".equals(String.valueOf(newParaMap.get("BUY_TRACK_STRATEGY_STATUS")))) {
					// 客源意向：1二手房、2新房
//					erpFunBuyCustomerService.updateHouseTrackTimeByOrg(cityId, compId, "0", Collections.singletonList(organizationId), 1);
				}
			}
		}
		// 求购-新房
		boolean trackPubBuyDayInNewHouse = this.getPolicyAddDay(param, oldMap, "TRACK_RED_NEWHOUSE", "RED_TRACK_PUBLIC_NEWHOUSE");
		if (trackPubBuyDayInNewHouse) {
			// 传上来的参数执行或者不执行求购跟进参数策略
			if (!newParaMap.isEmpty() && newParaMap.containsKey("NEWHOUSE_TRACK_STRATEGY_STATUS")) {
				// 如果是执行跟进参数策略, 则更新最后跟进日期 trackTime
				if ("1".equals(String.valueOf(newParaMap.get("NEWHOUSE_TRACK_STRATEGY_STATUS")))) {
					// 客源意向：1二手房、2新房
//					erpFunBuyCustomerService.updateHouseTrackTimeByOrg(cityId, compId, "0", Collections.singletonList(organizationId), 2);
				}
			}
		}
		// 求租
		boolean trackPubRentDay = this.getPolicyAddDay(param, oldMap, "TRACK_RED_RENT", "RED_TRACK_PUBLIC_RENT");
		if (trackPubRentDay) {
			// 传上来的参数执行或者不执行求购跟进参数策略
			if (!newParaMap.isEmpty() && newParaMap.containsKey("RENT_TRACK_STRATEGY_STATUS")) {
				// 如果是执行跟进参数策略, 则更新最后跟进日期 trackTime
				if ("1".equals(String.valueOf(newParaMap.get("RENT_TRACK_STRATEGY_STATUS")))) {
//					erpFunRentCustomerService.updateHouseTrackTimeByOrg(cityId, compId, "0", Collections.singletonList(organizationId));
				}
			}
		}
		List<ErpSysPara> beforeSysParaList = new ArrayList<>();
		List<ErpSysPara> afterSysParaList = new ArrayList<>();
		Iterator<Entry<String, Object>> it = param.getMap().entrySet().iterator();
		int updateFlag = 0, needRelogin = 0;

		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String paraId = entry.getKey();
			String value = StringUtil.toString(entry.getValue());
			// 有才更新
			ErpSysPara oldSysParaPO = oldMap.get(paraId);

			if (oldSysParaPO != null) {
				//值一样的不更新
				if (!StringUtil.isBlank(value) && !StringUtil.isBlank(oldSysParaPO.getParamValue()) && oldSysParaPO.getParamValue().equals(value)) {
					continue;
				}
				// 房客源无需审核项目不需要为空判断，有可以为空的就放这里
				if (!StringHelper.contains(new String[]{
						"SALE_AUTO_EXAM_APPLY", "RENT_AUTO_EXAM_APPLY"
						, "LEASE_AUTO_EXAM_APPLY", "BUY_AUTO_EXAM_APPLY"
						, "AUTO_ADUIT_CUSTOMER_ITEMS", "AUTO_ADUIT_HOUSE_ITEMS"}, paraId)) {
					//更新的值为空则跳过更新 - 防止数据被错误的更新为空
					if (StringUtil.isBlank(value)) {
						continue;
					}
				} else {
					this.updateAuditTypeAndUser(cityId, compId, paraId, value, oldSysParaPO.getParamValue());
				}

				ErpSysPara sysParaPo = new ErpSysPara();
				// 某个组织的参数
				sysParaPo.setOrganizationId(organizationId);
				sysParaPo.setParamId(paraId);
				sysParaPo.setParamType("int");
				sysParaPo.setParamValue(value);
				sysParaPo.setShardCityId(cityId);
				sysParaPo.setCompId(compId);
				sysParaPo.setPartnerId(0);
				oldSysParaPO.setParamId(paraId);
				beforeSysParaList.add(oldSysParaPO);
				afterSysParaList.add(sysParaPo);
				// 修改参数值, 这里只会有策略参数部分, partnerId为0
				erpSysParaMapper.updateParameterStrategy(cityId, compId, organizationId, paraId, value);
				// 重新登录
				Byte relogin = oldSysParaPO.getNeedRelogin();
				if (relogin != null && (relogin == 1 // 都要重新登录
						|| (relogin == 2 && "1".equals(entry.getValue())) // 变为1要重新登录
						|| (relogin == 3 && "0".equals(entry.getValue())))) { // 变为0要重新登录
					needRelogin++;
				}
			} else {
				continue;
			}
			updateFlag++;
		}

		//更新系统参数后，给所有登录人员一个提示,1代表修改系统参数
		if (needRelogin > 0) {
			erpFunUsersService.updateUserStatusBySysParaByOrg(param.getInteger("userId"), cityId, compId, Collections.singletonList(organizationId));
		}
		if (updateFlag > 0) {
			erpSystemSettingLogsService.insertLog(SystemOperateUtil.SSL_TYPE.CHANGE_PARAMETER, null, null, beforeSysParaList, afterSysParaList, param);
		}
		//清理缓存
		this.evictSysParamCache(cityId, compId);

		return needRelogin > 0;
	}


	public ErpSysPara getMLErpSysParamByOrgId(Integer cityId, Integer compId, Integer orgId, String paramId) {
		List<ErpSysPara> list = erpSysParaMapper.selectMLSysParamByOrgId(cityId, compId, orgId, paramId);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public List<ErpSysPara> getMLErpSysParamListByOrgId(Integer cityId, Integer compId, Integer orgId, List<String> paramId) {
		List<ErpSysPara> list = erpSysParaMapper.selectMLSysParamListByOrgId(cityId, compId, orgId, paramId);
		Map<String, ErpSysPara> paramMap = list.stream().sorted(Comparator.comparing(ErpSysPara::getOrganizationId)).collect(Collectors.toMap(ErpSysPara::getParamId, Function.identity(), (obj1, obj2) -> obj2));
		return new ArrayList<>(paramMap.values());
	}


	public String getMLErpSysParamValByOrgId(Integer cityId, Integer compId, Integer orgId, String paramId) {
		ErpSysPara sysParam = this.getMLErpSysParamByOrgId(cityId, compId, orgId, paramId);
		if (Objects.isNull(sysParam) || StringUtil.isBlank(sysParam.getParamValue())) {
			return "";
		}
		return sysParam.getParamValue().trim();
	}
}

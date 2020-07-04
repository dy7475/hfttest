package com.myfun.erpWeb.businesstools.builddic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.*;
import com.myfun.erpWeb.businesstools.param.GetBuildingInfoParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminErpBuildingInfoTmpMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunSectionMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunBuildRoofunitdoorsDto;
import com.myfun.repository.erpdb.dto.RoofInfoDto;
import com.myfun.repository.erpdb.param.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.admindb.AdminErpBuildingInfoTmpService;
import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateBuildInfoParam;
import com.myfun.service.business.erpdb.impl.ErpFunMenualService;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 方李骥
 * @since 2016年8月30日
 */
@Api(tags = "楼盘字典模块")
@Controller
@RequestMapping(value="/businesstools/buildDic")
public class FunBuildDicController extends BaseController{
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpBuildInfoService erpBuildInfoService;
	@Autowired
	ErpBuildingSetMapper erpBuildingSetMapper;
	@Autowired private ErpBuildingSetSettingMapper erpBuildingSetSettingMapper;
	@Autowired
	ErpBuildingSetLogMapper erpBuildingSetLogMapper;
	@Autowired
	ErpBuildingSetService erpBuildingSetService;
	@Autowired
	ErpBuildingPhotoMapper erpBuildingPhotoMapper;
	@Autowired
	AdminFunCityMapper adminFunCityMapper;
	@Autowired
	AdminErpBuildingInfoTmpMapper adminErpBuildingInfoTmpMapper;
	@Autowired
	ErpFunMenualService erpFunMenualService;
	@Autowired
	ErpBuildingSetRoomService erpBuildingSetRoomService;
	@Autowired
	ErpBuildingSetFloorMapper erpBuildingSetFloorMapper;
	@Autowired
	ErpBuildingSetRoomMapper erpBuildingSetRoomMapper;
	@Autowired
	ErpFunBuildRoofunitdoorsMapper erpFunBuildRoofunitdoorsMapper;
	@Autowired
	ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	ErpFunRegMapper erpFunRegMapper;
	@Autowired
	ErpBuildRoadsRelationMapper erpBuildRoadsRelationMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunCoreInfoMapper erpFunCoreInfoMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpBuildingSetRoofService erpBuildingSetRoofService;
    @Autowired
    ErpBuildingMarketingControlMinMapper erpBuildingMarketingControlMinMapper;
    @Autowired
    ErpBuildingManagerMapper erpBuildingManagerMapper;
    @Autowired
    ErpBuildingSetRoofMapper erpBuildingSetRoofMapper;
    @Autowired
    ErpBuildingSetUnitMapper erpBuildingSetUnitMapper;
    @Autowired
    ErpBuildingSetUnitService erpBuildingSetUnitService;
    @Autowired
    ErpBuildingSetFloorService erpBuildingSetFloorService;
    @Autowired
    ErpBuildingSetRoomLayoutService erpBuildingSetRoomLayoutService;
    @Autowired
    ErpBuildingMarketingControlMapper erpBuildingMarketingControlMapper;
    @Autowired
    ErpBuildingManagerService erpBuildingManagerService;
    @Autowired
    ErpBuildingSetRoomLayoutMapper erpBuildingSetRoomLayoutMapper;
    @Autowired
    AdminErpBuildingInfoTmpService adminErpBuildingInfoTmpService;
    @Autowired
    HttpRequestTask httpRequestTask;
    @Autowired
    ErpFunUsersMapper  erpFunUsersMapper;
    @Autowired
    private ErpUserOpersMapper erpUserOpersMapper;
    @Autowired
    private AdminFunSectionMapper adminFunSectionMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Resource
    private ErpFunTerritoryMapper erpFunTerritoryMapper;
    @Resource
    private ErpFunStreetProvinceMapper erpFunStreetProvinceMapper;
    @Resource
    private ErpFunStreetCityMapper erpFunStreetCityMapper;
    @Resource
    private ErpFunStreetRegMapper erpFunStreetRegMapper;
    @Resource
    private ErpFunStreetSectionMapper erpFunStreetSectionMapper;
    @Resource
    private ErpFunStreetMapper erpFunStreetMapper;
    @Resource
    private ErpFunStreetInSectionMapper erpFunStreetInSectionMapper;
    @Resource
    private ErpFunProvinceMapper erpFunProvinceMapper;
    @Resource
    private ErpFunCityMapper erpFunCityMapper;
    @Resource
    private ErpFunStreetInRegMapper erpFunStreetInRegMapper;


    /**
     * 楼盘字典列表
     * @author 熊刚
     * @since 2017年7月8日
     * @param param
     * @return
     * @throws Exception
     */
    @ApiOperation("楼盘字典列表")
    @ApiResponses({@ApiResponse(code = 200,response = BuildingListPageVo.class,message = "success")})
    @RequestMapping("/getBuildingList")
    @ResponseBody

    public ResponseJson getBuildingList(@Valid @RequestBody QueryBuildingListParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Object buildingFlag = getOperator().getAttribute("BUILDING_FLAG");
        param.setCityId(cityId);
        param.setBuildingFlag(StringUtil.parseInteger(buildingFlag, 0));
        if (StringUtil.isNotBlank(param.getBuildName())) {
            param.setBuildName("%" + param.getBuildName() + "%");
        }
        if (StringUtil.isNotBlank(param.getBuildIds())) {
            param.setBuildName(null);
            param.setBuildIdList(param.getBuildIds().split(","));
        }
        if (StringUtil.isNotBlank(param.getSectionIds())) {
            param.setSectionIdList(param.getSectionIds().split(","));
        }
//       PageHelper.startPage(param.getPageOffset(), param.getPageRows());

//        List<ErpBuildingInfoDto> erpBuildingInfoDtoList = erpBuildingInfoMapper.getBuildingListOffsetPage(param.getCityId(),param);
        PageInfo<ErpBuildingInfoDto> pageInfo = erpBuildInfoService.getBuildingListOffsetPages(param);
        int count=erpBuildingInfoMapper.count(param.getCityId(), param);
        pageInfo.setTotal(count);
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * 楼盘字典列表
     * @author wangchun
     * @param param
     * @return
     * @since 2018-12-11
     */
    @ApiOperation("楼盘字典列表")
    @ApiResponses({@ApiResponse(code = 200,response = BuildingListVo.class,message = "success")})
    @PostMapping("/getNewBuildingList")
    @ResponseBody
    public ResponseJson getNewBuildingList(@Valid @RequestBody QueryBuildingListParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Object buildingFlag = getOperator().getAttribute("BUILDING_FLAG");
        param.setCityId(cityId);
        Integer userId = param.getUserId();

        param.setBuildingFlag(StringUtil.parseInteger(buildingFlag, 0));
        if (StringUtil.isNotBlank(param.getBuildName())) {
            param.setBuildName("%" + param.getBuildName() + "%");
        }

  		Set<String> buildListTranse = new HashSet<>();
        if (StringUtil.isNotBlank(param.getBuildIds())) {
            param.setBuildName(null);
            String [] buildIds = param.getBuildIds().split(",");
            for (int i=0; i<buildIds.length; i++){
                buildListTranse.add(buildIds[i]);
            }
        }
        if (StringUtil.isNotBlank(param.getSectionIds())) {
            param.setSectionIdList(param.getSectionIds().split(","));
        }

        Boolean userFlage = false;
        //传维护人或门店的情况下(ErpBuildingManager无deptId，门店转维护人)
        //得到维护人维护的楼盘Id，需要剔除传过来的楼盘ID
        Set<String> buildList = new HashSet<>();
        if (null != userId) {
            userFlage = true;
            //1.楼盘管理员
            ErpBuildingManagerExample example  = new ErpBuildingManagerExample();
            example.setShardCityId(cityId);
            example.setOrderByClause(" CREATION_TIME DESC ");
            example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andManagerTypeEqualTo((byte)1);
            List<ErpBuildingManager> bExampleList = erpBuildingManagerMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(bExampleList)){
                buildList = bExampleList.stream().filter(val ->val.getBuildId() != null).map(val -> val.getBuildId().toString()).collect(Collectors.toSet());
            }
            //2.栋座管理员 需联表 BUILDING_SET_ROOF
            List<Integer> userIdList = new ArrayList<>();
            userIdList.add(userId);
            List<ErpBuildingManager> rList = erpBuildingManagerMapper.getBuildListByUserId(cityId,compId,userIdList,(byte)2);
            if (!CollectionUtils.isEmpty(rList)){
                buildList.addAll(rList.stream().filter(val -> val.getBuildId() != null).map(val -> (val.getBuildId() +"")).collect(Collectors.toSet()));
            }
        }

        Set<String> needParam =  null;
        if (CollectionUtils.isNotEmpty(buildList) && CollectionUtils.isNotEmpty(buildListTranse) ) {
            String userBuild = buildList.stream().map(val -> val).collect(Collectors.joining(","));
            String transBuild = buildListTranse.stream().map(val -> val).collect(Collectors.joining(","));
           if (userBuild.contains(transBuild)){
               needParam = buildListTranse;
           } else if(transBuild.contains(userBuild)){
               needParam =  buildList;
           }
        } else if (CollectionUtils.isNotEmpty(buildList)){
            needParam = buildList;
        } else if (CollectionUtils.isNotEmpty(buildListTranse)) {
            needParam = buildListTranse;
        }

        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        //获取楼盘基本信息列表
        if (userFlage && CollectionUtils.isEmpty(needParam)){
            return ErpResponseJson.ok();
        }

        //[2020/05/20] 李中国 楼盘字典列表根据登记时间降序排序 需求id#12259 5.20上线PC&APP 楼盘字典、房源、客源、业主电话、房间图，要求排最新登记时间排序
        List<BuildingInfoVo> infoList = erpBuildingInfoMapper.getBuildingList(param.getCityId(),param,needParam);
        if(CollectionUtils.isEmpty(infoList)){
            return ErpResponseJson.ok();
        }
        List<Integer> buildIds = infoList.stream().map(BuildingInfoVo::getBuildId).collect(Collectors.toList());

        //获取每个楼盘的右侧静态信息（在租，在售，内外成交）
        List<ErpBuildingMarketingControlMin> conInfos = erpBuildingMarketingControlMinMapper.getControlInfo(cityId,buildIds,compId);
        Map<Integer, ErpBuildingMarketingControlMin> controlInfos = new HashMap<>();
        if (conInfos != null) {
            controlInfos = conInfos.stream().collect(Collectors.toMap(ErpBuildingMarketingControlMin::getBuildId, val -> val));
        }

        //获取维护人列表
        List<ErpBuildingManager> bManagers = erpBuildingManagerMapper.getBuildingManagers(cityId,buildIds,compId);
        Map<Integer, Integer> buildManagers = new HashMap<>();
        if (bManagers != null) {
            buildManagers = bManagers.stream().collect(Collectors.toMap(ErpBuildingManager::getBuildId, ErpBuildingManager::getUserId));
        }

        List<ErpBuildingManager> rManagers = erpBuildingManagerMapper.getRoofManagers(cityId,buildIds,compId);
        Map<Integer, List<ErpBuildingManager>> roManagers = new HashMap<>();
        if (rManagers != null) {
            roManagers = rManagers.stream().collect(Collectors.groupingBy(ErpBuildingManager::getBuildId));
        }
        Map<Integer, String> roofManagers = new HashMap<>();
        roManagers.forEach((k,v) ->{
            roofManagers.put(k, v.stream().map(val -> String.valueOf(val.getUserId())).collect(Collectors.joining(",")));
        });

        List<ErpBuildingInfo> erpBuildingInfos = erpBuildingInfoMapper.getTempCompIdByBuildIds(cityId, compId, buildIds);
        List<Integer> buildIdList = erpBuildingInfos.stream().map(ErpBuildingInfo::getBuildId).collect(Collectors.toList());

        //封装结果数据
        boolean isMeiLian = getOperator().isMeiLianApi();
        for (BuildingInfoVo dto : infoList) {
            Integer buildId = dto.getBuildId();
            dto.setFirstPicAddr(CommonUtil.getHousePhoto(dto.getFirstPicAddr()));
            dto.setBuildManager(buildManagers.get(buildId));
            dto.setRoofManagers(roofManagers.get(buildId));
            if (controlInfos.get(buildId) != null) {
                dto.setSaleCount(controlInfos.get(buildId).getSaleCount());
                dto.setLeaseCount(controlInfos.get(buildId).getLeaseCount());
                dto.setInnerDealCount(controlInfos.get(buildId).getInnerDealCount());
                dto.setOuterDealCount(controlInfos.get(buildId).getOuterDealCount());
            }

            // 查看是否有系统模板
            dto.setHaveBuildTemplate(0);
            if (buildIdList.size() > 0 && buildIdList.contains(buildId)) {
                Optional<ErpBuildingInfo> build = erpBuildingInfos.stream().filter(it -> it.getBuildId().equals(buildId)).findFirst();
                if (build.isPresent()) {
                    ErpBuildingInfo buildingInfo = build.get();
                    if (buildingInfo.getTemplateCompId() != null && !buildingInfo.getTemplateCompId().equals(compId)) {
                        dto.setHaveBuildTemplate(1);
                    }
                }
            }
        }

        PageInfo<BuildingInfoVo> pageInfo = new PageInfo<>(infoList);
            BuildingListVo resultVo = new BuildingListVo(pageInfo);
        return ErpResponseJson.ok(resultVo);
    }

	/**
	 * 字典详情
	 * @author wangchun
	 * @since 2018年12月18日
	 * @param param
	 * @return
	 */
    @ApiOperation("字典详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpDetailsBuildingInfoVO.class, message = "成功")
    })
    @PostMapping("/getBuildDicInfo")
    @ResponseBody
	public ResponseJson getBuildDicInfo(@Valid @RequestBody GetBuildDicInfoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer buildId = param.getBuildId();

        ErpDetailsBuildingInfoVO erpDetailsBuildingInfoVO = new ErpDetailsBuildingInfoVO();
        erpDetailsBuildingInfoVO = erpBuildingInfoMapper.getDetailInfoByBuildId(cityId, buildId);
        erpDetailsBuildingInfoVO = erpDetailsBuildingInfoVO == null ? new ErpDetailsBuildingInfoVO() : erpDetailsBuildingInfoVO;
//        ErpFunBuildRoofunitdoors roofs = erpFunBuildRoofunitdoorsMapper.getRoUnDoCounts(cityId,getOperator().getCompId(),buildId);
//        if (roofs != null) {
//            erpDetailsBuildingInfoVO.setRoofs(roofs.getRoofs());
//        }

//		// 查看当前字典楼盘是否已有未审核的记录
//		Integer checkFlag = adminErpBuildingInfoTmpMapper.getCheckFlag(param.getMap());
//		if (checkFlag > 0) {
//			// throw new BusinessException("您已提交过该楼盘的纠错信息,请等待客服处理");
//			erpBuildingInfoDto.setCheckFlag(1);
//		}

        List<ErpBuildingPhoto> erpBuildingPhotos = erpBuildingPhotoMapper.getBuildDicPhotoList(cityId, buildId);

        Integer managerId = erpBuildingManagerMapper.getBuildManageUserId(cityId,buildId,operator.getCompId());
        if (CollectionUtils.isNotEmpty(erpBuildingPhotos)) {
            for (ErpBuildingPhoto dto : erpBuildingPhotos) {
                dto.setPhotoAddr(CommonUtil.getHousePhoto(dto.getPhotoAddr()));
            }
        }
        erpDetailsBuildingInfoVO.setBuildPhotoList(erpBuildingPhotos);
        erpDetailsBuildingInfoVO.setBuildManager(managerId);
         //暂时的方案，如果有多个产权类型，返回一个。
        //[2020-06-08] yz 要求产权类型支持多个，这里全部返回
//        String mlPropertyType = erpDetailsBuildingInfoVO.getMlPropertyType();
//        if(StringUtils.isNotEmpty(mlPropertyType)){
//            String[] split = mlPropertyType.split("\\|");
//            erpDetailsBuildingInfoVO.setMlPropertyType(split[0]);
//        }

        if (StringUtils.isNotBlank(erpDetailsBuildingInfoVO.getStreetIds())) {
            List<Integer> streetIdList = Arrays.stream(erpDetailsBuildingInfoVO.getStreetIds().split(",")).map(Integer::valueOf).collect(Collectors.toList());
            ErpFunStreetExample streetExample = new ErpFunStreetExample();
            streetExample.setShardCityId(cityId);
            streetExample.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andIdIn(streetIdList).andIsDelEqualTo((byte) 0);
            List<ErpFunStreet> streetInfos = erpFunStreetMapper.selectByExample(streetExample);

            List<ErpDetailsBuildingInfoVO.StreetData> streets = new ArrayList<>();
            for (ErpFunStreet street : streetInfos) {
                ErpDetailsBuildingInfoVO.StreetData data = new ErpDetailsBuildingInfoVO.StreetData();
                data.setId(street.getId());
                data.setStreetName(street.getStreetName());
                streets.add(data);
            }
            erpDetailsBuildingInfoVO.setStreets(streets);
        }

        return ErpResponseJson.ok(erpDetailsBuildingInfoVO);
    }


    /**
     * 纠错楼盘
     * @param buildingInfoTmpParam
     * @return
     * @author wangchun
     * @since 2018年12月18日
     */
    @ApiOperation("纠错楼盘")
    @ApiResponses({@ApiResponse(code = 200,message = "success")})
    @PostMapping("/updateBuildDicInfo")
    @ResponseBody
    public ResponseJson updateBuildDicInfo(@Valid @RequestBody BuildingInfoTmpParam buildingInfoTmpParam) {
        buildingInfoTmpParam.setProvinceId(getOperator().getProvinceId());
        buildingInfoTmpParam.setArchiveId(getOperator().getArchiveId());
        buildingInfoTmpParam.setCompId(getOperator().getCompId());
//        buildingInfoTmpParam.setDataType((byte)0);
        buildingInfoTmpParam.setCreateTime(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate()));
        adminErpBuildingInfoTmpService.updateBuildDicInfo(buildingInfoTmpParam);
        return ErpResponseJson.ok();
    }
    /**
     * 美联编辑保存楼盘字典
     * @param buildingInfoTmpParam
     * @return
     * @author wangchun
     * @since 2018年12月18日
     */
    @ApiOperation("美联编辑保存楼盘字典")
    @ApiResponses({@ApiResponse(code = 200,message = "success")})
    @PostMapping("/updateMlBuildDicInfo")
    @ResponseBody
    public ResponseJson updateMlBuildDicInfo(@Valid @RequestBody  InsertComBuildParam updateparam) throws  Exception {
        Integer cityId = getOperator().getCityId();
        ErpBuildingInfo erpBuildingInfo2 = erpBuildingInfoMapper.selectTopOneBuildingInfoOffPromotionName(cityId,updateparam.getPromotionName(),updateparam.getBuildId());
        if(erpBuildingInfo2 != null){
            InsertComBuildParam returnCord = new InsertComBuildParam();
            try {
                BeanUtilsHelper.copyProperties(returnCord, erpBuildingInfo2);
            } catch (Exception e) {
            }
            returnCord.setHasBuild(1);
            return ErpResponseJson.ok(returnCord);
        }

        updateparam.setProvinceId(getOperator().getProvinceId());
        updateparam.setArchiveId(getOperator().getArchiveId());
        updateparam.setCompId(getOperator().getCompId());

//        updateparam.setDataType((byte)0);
        //[2020/05/20] 李中国 根据楼盘字典创建时间排序，但楼盘字典更新不变动顺序 需求id#12259 5.20上线PC&APP 楼盘字典、房源、客源、业主电话、房间图，要求排最新登记时间排序
        //updateparam.setCreateTime(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate()));

        ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
        BeanUtils.copyProperties(updateparam, erpBuildingInfo);
        String buildCode = Pinyin4jUtil.converterToFirstSpell(updateparam.getBuildName());
        String quanPin = Pinyin4jUtil.converterToSpell(erpBuildingInfo.getBuildName());
        // 全拼，简拼，楼盘名，别名，别名全拼，别名简拼
        StringBuilder searchFiled = new StringBuilder(erpBuildingInfo.getBuildName());
        if(StringUtils.isNotBlank(quanPin)) {
            searchFiled.append("|").append(quanPin);
        }
        if(StringUtils.isNotBlank(buildCode)) {
            searchFiled.append("|").append(buildCode);
        }
        if(getOperator().isMeiLianApi()){
            String promotionName = erpBuildingInfo.getPromotionName();
            String quanpinpromotionName = Pinyin4jUtil.converterToSpell(promotionName);
            String buildCodepromotionName = Pinyin4jUtil.converterToFirstSpell(promotionName);
            if(StringUtils.isNotBlank(promotionName)){
                searchFiled.append("|");
                searchFiled.append(promotionName);
            }
            if(StringUtils.isNotBlank(quanpinpromotionName)) {
                searchFiled.append("|").append(quanpinpromotionName);
            }
            if(StringUtils.isNotBlank(buildCodepromotionName)) {
                searchFiled.append("|").append(buildCodepromotionName);
            }
        }
        erpBuildingInfo.setBuildCode(buildCode);
        erpBuildingInfo.setSearchField(searchFiled.toString());
        erpBuildingInfo.setShardCityId(getOperator().getCityId());
        erpBuildingInfo.setPositionY(updateparam.getPostionY());
        erpBuildingInfo.setUpdateTime(DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate()));
        erpBuildingInfoMapper.updateByPrimaryKeySelective(erpBuildingInfo);
        return ErpResponseJson.ok();
    }
    @ApiOperation("美联新增商圈")
    @ApiResponses({@ApiResponse(code = 200,message = "success")})
    @PostMapping("/addMlBuildSection")
    @ResponseBody
    public ResponseJson addMlBuildSection(@Valid @RequestBody  ErpFunSection erpFunSection) throws  Exception {
        Operator operator = getOperator();


        String sectionName=erpFunSection.getSectionName();
        // 根据名称判断重复
        List<ErpFunSection> erpFunSections = erpFunSectionMapper.selectSectionListByName(operator.getCityId().shortValue(), sectionName);
        if(erpFunSections.size()>0){
            return ErpResponseJson.warn("商圈已存在");
        }else{
            String spell = Pinyin4jUtil.converterToFirstSpell(sectionName);
            ErpFunSection funSection =new ErpFunSection();
            funSection.setRegId(erpFunSection.getRegId());
            funSection.setSectionCode(spell);
            funSection.setSectionName(sectionName);
            funSection.setVertifyFlag((byte)1);
            funSection.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
            funSection.setShardCityId(operator.getCityId());
            funSection.setCityId(operator.getCityId().shortValue());
            erpFunSectionMapper.insertSelective(funSection);

            AdminFunSection adminFunSection = new AdminFunSection();
            adminFunSection.setCityId(operator.getCityId().shortValue());
            adminFunSection.setRegId(erpFunSection.getRegId());
            adminFunSection.setSectionCode(spell);
            adminFunSection.setSectionName(sectionName);
            adminFunSection.setVertifyFlag((byte)1);
            adminFunSection.setErpSectionId(funSection.getSectionId());
            adminFunSection.setUpdateTime(new Date());
            adminFunSectionMapper.insertSelective(adminFunSection);
            return ErpResponseJson.ok();
        }
    }

    /**
     * 获取楼盘资料
     *
     * @param param buildId 主键
     * @return
     * @author 臧铁
     * @since 2017年5月31日
     */
    @ApiOperation("获取楼盘资料")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingInfoDto.class, message = "成功")
    })
    @RequestMapping("/getBuildingInfo")
    @ResponseBody
    public ResponseJson getBuildingInfo(@Valid @RequestBody GetBuildingInfoParam param) {
        Integer cityId = getOperator().getCityId();
        Integer buildId = param.getBuildId();
        ErpBuildingInfoDto erpBuildingInfoDto = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, buildId);
        if (null != erpBuildingInfoDto) {
            ErpFunSection erpFunSection = new ErpFunSection();
            erpFunSection.setShardCityId(cityId);
            erpFunSection.setSectionId(erpBuildingInfoDto.getSectionId());
            erpFunSection.setVertifyFlag((byte) 1);
            ErpFunSection funSection = erpFunSectionMapper.selectByPrimaryKey(erpFunSection);
            if (null != funSection) {
                erpBuildingInfoDto.setSectionName(funSection.getSectionName());
            }
            ErpFunReg erpFunReg = new ErpFunReg();
            erpFunReg.setShardCityId(cityId);
            erpFunReg.setRegId(erpBuildingInfoDto.getBuildRegion());
            erpFunReg.setVertifyFlag((byte) 1);
            ErpFunReg funReg = erpFunRegMapper.selectByPrimaryKey(erpFunReg);
            if (null != funReg) {
                erpBuildingInfoDto.setRegName(funReg.getRegName());
            }
            ErpBuildRoadsRelation erpBuildRoadsRelation = new ErpBuildRoadsRelation();
            erpBuildRoadsRelation.setShardCityId(cityId);
            erpBuildRoadsRelation.setBuildId(erpBuildingInfoDto.getBuildId());
            List<ErpBuildRoadsRelation> list = erpBuildRoadsRelationMapper.getListByBuildId(erpBuildRoadsRelation);
            if (list.size() > 0) {
                StringBuilder sbTemp = new StringBuilder();
                for (ErpBuildRoadsRelation relation : list) {
                    if (sbTemp.length() > 0) {
                        sbTemp.append("、");
                    }
                    sbTemp.append(relation.getRoadsName());
                }
                erpBuildingInfoDto.setRoadsName(sbTemp.toString());
            }
        }
        return ErpResponseJson.ok(erpBuildingInfoDto);
    }

    /**
     * 更新楼盘字典详细信息
     *
     * @param param
     * @return
     * @throws Exception
     * @author 方李骥
     * @since 2016年8月30日
     */
    @RequestMapping("/updateComBuild")
    @ResponseBody
    public ResponseJson updateComBuild(@Valid @RequestBody CreateOrUpdateBuildInfoParam param) {
        param.setCompId(getOperator().getCompId());
        param.setDeptId(getOperator().getDeptId());
        param.setCityId(Short.valueOf(getOperator().getCityId().toString()));
        param.setProvinceId(Integer.valueOf(getOperator().getProvinceId()));
        param.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
        CreateOrUpdateBuildInfoParam buildInfoTemp = erpBuildInfoService.updateBuildTmpInfo(getOperator().getCityId(), param);
        return ErpResponseJson.ok(buildInfoTemp);
    }

    /**
     * @param param
     * @return ResponseJson    返回类型
     * @throws Exception
     * @throws
     * @Date:2016-10-10
     * @Athor:方李骥
     * @Title: insertComBuild
     * @Description: 新增楼盘字典
     */
/*    @ApiOperation("新增楼盘字典")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/insertComBuild")
    @ResponseBody
    public ResponseJson insertComBuild(@Valid @RequestBody CreateOrUpdateBuildInfoParam param) {
        param.setCompId(getOperator().getCompId());
        param.setDeptId(getOperator().getDeptId());
        param.setArchiveId(getOperator().getArchiveId());
        param.setCityId(getOperator().getCityId().shortValue());
        param.setProvinceId(getOperator().getProvinceId());
        param.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
        Object object = erpBuildInfoService.createBuildInfo(getOperator().getCityId(), param);
        return ErpResponseJson.ok(object);
    }
    */

    /**
     * 新增楼盘字典
     *
     * @author wangchun
     * @since 2018-12-27
     * @param param
     * @return
     */
    @ApiOperation("新增楼盘字典")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class,message = "成功")
    })
    @PostMapping("/insertComBuild")
    @ResponseBody
    public ResponseJson insertComBuild(@Valid @RequestBody InsertComBuildParam param) {
        param.setCompId(getOperator().getCompId());
        param.setDeptId(getOperator().getDeptId());
        param.setArchiveId(getOperator().getArchiveId());
        param.setCityId(getOperator().getCityId().shortValue());
        param.setProvinceId(getOperator().getProvinceId());
        param.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
        Object object = erpBuildInfoService.insertComBuild(getOperator().getCityId(), param,getOperator());
        return ErpResponseJson.ok(object);
    }

    /**
     * 获取当前楼盘字典图片列表
     *
     * @param
     * @param
     * @return
     * @throws Exception
     * @author 方李骥
     * @since 2016年8月30日
     */
    @ApiOperation("获取当前楼盘字典图片列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingPhoto.class, message = "成功")
    })
    @RequestMapping("/getBuildDicPhotoList")
    @ResponseBody
    public ResponseJson getBuildDicPhotoList(@Valid @RequestBody GetBuildingInfoParam param) {
       /* List<ErpBuildingPhoto> list = erpBuildingPhotoMapper.selectBuildDicPhotoList(getOperator().getCityId(), param.getBuildId());
        for (ErpBuildingPhoto erpBuildingPhoto : list) {
            if (StringUtil.isNotBlank(erpBuildingPhoto.getPhotoAddr())) {
                String photoAddr = CommonUtil.getHousePhoto(erpBuildingPhoto.getPhotoAddr());
                erpBuildingPhoto.setPhotoAddr(photoAddr);
            }
        }*/
        return ErpResponseJson.ok(new ArrayList<>());
    }

    /**
     * 获得用户对应城市的中心坐标
     *
     * @param
     * @return
     * @throws Exception
     * @author 方李骥
     * @since 2016年8月30日
     */
    @RequestMapping("/getCityMapCenterPosition")
    @ResponseBody
    public ResponseJson getCityMapCenterPosition() {
        Integer cityId = getOperator().getCityId();
        if (cityId == null) {
            return ErpResponseJson.ok();
        }
        AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(Short.valueOf(cityId.toString()));
        String cityName = adminFunCity.getcCityName();
        if (cityName.lastIndexOf("市") != -1) {
            cityName = cityName.substring(0, cityName.lastIndexOf("市"));
        }
        adminFunCity.setCityName(cityName);
        return ErpResponseJson.ok(adminFunCity);
    }

    /**
     * 获取楼盘状态  判断是否锁定
     *
     * @param param buildId 楼盘ID
     * @return
     * @throws Exception
     * @author 方李骥
     * @since 2016年8月30日
     */
    @RequestMapping("/getBuildingStatus")
    @ResponseBody
    public ResponseJson getBuildingStatus(@Valid @RequestBody BaseMapParam param) {
        Integer buildId = param.getInteger("buildId");
        Map<String, Integer> map = new HashMap<>();
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(getOperator().getCityId(), getOperator().getCompId(), buildId);
        int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
        map.put("lockFlag", buildLock);
        return ErpResponseJson.ok(map);
    }

    /**
     * 获取楼盘规则列表
     * @author 方李骥
     * @since 2016年8月30日
     * @param param buildId 楼盘ID isLock 规则是否锁定
     * @return
     * @throws Exception
     *//*
    @ApiOperation("获取楼盘规则列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingSetVo.class, message = "成功")
    })
	@RequestMapping("/getBuildingRuleList")
	@ResponseBody
	public ResponseJson getBuildingRuleList(@Valid @RequestBody GetBuildingRuleListParam param){
		Integer buildId = param.getBuildId();
		Integer isLock = param.getIsLock()!=null?param.getIsLock():0;
		if (buildId == null) {
			return ErpResponseJson.ok();
		}
		// 指定要锁定的，未锁定直接返回
		if (isLock == 1) {
			ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(getOperator().getCityId(), getOperator().getCompId(), buildId);
			int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
			if (buildLock != 1) {
				return ErpResponseJson.ok();
			}
		}
		ErpBuildingSet conditionModel = new ErpBuildingSet();
		conditionModel.setCityId(getOperator().getCityId());
		conditionModel.setShardCityId(getOperator().getCityId());
		conditionModel.setCompId(getOperator().getCompId());
		conditionModel.setCompNo(getOperator().getCompNo());
		conditionModel.setBuildId(buildId);
		List<ErpBuildingSet> resultList = erpBuildingSetMapper.getBuildingRuleList(conditionModel);
		// 要锁定的，但是规则为空，组装一条为lock的数据，前端好区分是没有锁定还是没有规则
		if (isLock == 1 && (resultList == null || resultList.isEmpty())) {
			if (resultList == null) {
				resultList = new LinkedList<>();
			}
			ErpBuildingSet erpBuildingSet = new ErpBuildingSet();
			erpBuildingSet.setBuildLock((byte) 1);
			resultList.add(erpBuildingSet);
		}
		return ErpResponseJson.ok(resultList);
	}*/

//	/**
//	 * 添加楼盘规则 录入楼盘的单元栋号等
//	 * @author 方李骥
//	 * @since 2016年8月30日
//	 * @param param
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("/insertBuildingRule")
//	@ResponseBody
//	public ResponseJson insertBuildingRule(@Valid @RequestBody InsertBuildRuleOrUpdateParam param){
//		String[] buildRules = param.getData().split(",");
//		Integer userId = getOperator().getUserId();
//		if (buildRules.length > 1) {
//			// 添加新数据
//			for (int i = 0; i < buildRules.length; i++) {
//				String[] tStr = buildRules[i].split(":");
//				param.setCompId(getOperator().getCompId());
//				param.setBuildId(param.getBuildId());
//				param.setCompNo(getOperator().getCompNo());
//				param.setCityId(getOperator().getCityId());
//				param.setProvinceId(getOperator().getProvinceId());
//				param.setBuildLock((byte)0);
//				param.setBuildRoof(tStr[0]);
//				param.setBuildUnit(tStr[1]);
//				param.setBuildFloors(tStr[2]);
//				param.setBuildLadder(tStr[3]);
//				param.setBuildDoors(tStr[4]);
//				if (!"-1".equals((tStr[5]))) {
//					erpBuildingSetMapper.updateErpBuildingSet(param.getCityId(), param);
//					continue;
//				}
//				erpBuildingSetMapper.insertErpBuildingSet(param.getCityId(), param);
//				erpBuildingSetLogMapper.insertLog(param.getCityId(), userId, param.getCompId(), param.getBuildId(),
//						param.getBuildRoof(), param.getBuildUnit(), "新增规则日志01");
//			}
//		}
//		return ErpResponseJson.ok();
//	}

//	/**
//	 * 锁定当前楼  如果锁定 登记房源是则按照楼盘规则登记房源
//	 * @author 方李骥
//	 * @since 2016年9月2日
//	 * @param param
//	 * @return NODATA 没有数据   SUCCESS 成功  NO_LOCK_BUILDING 没有权限
//	 * @throws Exception
//	 */
//	@RequestMapping("/updateLockBuildRule")
//	@ResponseBody
//	public ResponseJson updateLockBuildRule(@Valid @RequestBody BaseMapParam param) {
//		Operator operator = getOperator();
//		Integer buildId = param.getInteger("buildId");
//		Integer lockFlag = param.getInteger("lockFlag");
//		String buildRoofName = param.getString("buildRoofName");
//		String buildUnitName = param.getString("buildUnitName");
//
//
//		ErpBuildingSet conditionModel = new ErpBuildingSet();
//		conditionModel.setCityId(operator.getCityId());
//		conditionModel.setCompId(operator.getCompId());
//		conditionModel.setBuildId(buildId);
//		conditionModel.setCompNo(operator.getCompNo());
//		conditionModel.setShardCityId(operator.getCityId());
//		erpBuildingSetService.updateLockBuildRule(conditionModel, lockFlag, operator.getUserId(), operator.getDeptId(),buildRoofName,buildUnitName);
//		return ErpResponseJson.ok();
//	}

//	/**
//	 * 锁定当前楼  如果锁定 登记房源是则按照楼盘规则登记房源
//	 * @author 方李骥
//	 * @since 2016年9月2日
//	 * @param param
//	 * @return NODATA 没有数据   SUCCESS 成功  NO_LOCK_BUILDING 没有权限
//	 * @throws Exception
//	 */
//	@RequestMapping("/copyTempBuildRule")
//	@ResponseBody
//	public ResponseJson copyTempBuildRule(@Valid @RequestBody BaseMapParam param) {
//		Operator operator = getOperator();
//		Integer cityId = operator.getCityId();
//		Integer compId = operator.getCompId();
//		String compNo = operator.getCompNo();
//		Integer userId = operator.getUserId();
//		Integer buildId = param.getInteger("buildId");
//		erpBuildingSetService.copyTempBuildRule(cityId, buildId, compId, compNo, userId);
//		return ErpResponseJson.ok();
//	}

//	/**
//	 * 获取当前栋好的 总楼层
//	 * @author 方李骥
//	 * @since 2016年9月2日
//	 * @param param
//	 * @throws Exception
//	 */
//	@RequestMapping("/getBuildFloors")
//	@ResponseBody
//	public ResponseJson getBuildFloors(@Valid @RequestBody BaseMapParam param){
//		Integer buildId = param.getInteger("BUILD_ID");
//		String roof = param.getString("roof");
//		String unit = param.getString("unit");
//		ErpBuildingSet condition = new ErpBuildingSet();
//		condition.setBuildId(buildId);
//		condition.setCompId(getOperator().getCompId());
//		condition.setCompNo(getOperator().getCompNo());
//		condition.setCityId(getOperator().getCityId());
//		condition.setBuildRoof(roof);
//		condition.setBuildUnit(unit);
//		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectBuildfloors(condition.getCityId(),condition);
//		return ErpResponseJson.ok(erpBuildingSet.getBuildFloors());
//	}

//	/**
//	 * 获取楼层梯户等
//	 * @author 方李骥
//	 * @since 2016年9月2日
//	 * @param param
//	 * @throws Exception
//	 */
//	@RequestMapping("/getLadordoor")
//	@ResponseBody
//	public ResponseJson getLadordoor(@Valid @RequestBody BaseMapParam param){
//		Integer buildId = param.getInteger("BUILD_ID");
//		String roof = param.getString("roof");
//		String unit = param.getString("unit");
//		ErpBuildingSet condition = new ErpBuildingSet();
//		condition.setBuildId(buildId);
//		condition.setCompId(getOperator().getCompId());
//		condition.setCompNo(getOperator().getCompNo());
//		condition.setCityId(getOperator().getCityId());
//		condition.setBuildRoof(roof);
//		condition.setBuildUnit(unit);
//		ErpBuildingSet erpBuildingSet = erpBuildingSetMapper.selectBuildfloors(condition.getCityId(),condition);
//		return ErpResponseJson.ok(erpBuildingSet.getBuildLadder());
//	}

//    /**
//     * 批量添加规则
//     *
//     * @author 张宏利
//     * @since 2017年8月21日
//     */
//    @NotBlank({"buildId"})
//    @RequestMapping("/batchImporFunBuildRules")
//    @ResponseBody
//    public ResponseJson batchImporFunBuildRules(@Valid @RequestBody ErpBuildingSetParam param) {
//        param.setCompId(getOperator().getCompId());
//        param.setCityId(getOperator().getCityId());
//        param.setCompNo(getOperator().getCompNo());
//        param.setShardCityId(getOperator().getCityId());
//        param.setProvinceId(getOperator().getProvinceId());
//        param.setSelfUserId(getOperator().getUserId());
//        erpBuildingSetService.batchImporFunBuildRules(param);
//        return ErpResponseJson.ok();
//    }

//    /**
//     * 修改栋座规则
//     *
//     * @author 张宏利
//     * @since 2017年8月21日
//     */
//    @RequestMapping("/updateBuildRule")
//    @ResponseBody
//    public ResponseJson updateBuildRule(@Valid @RequestBody ErpBuildingSetParam param) {
//        param.setCompId(getOperator().getCompId());
//        param.setCompNo(getOperator().getCompNo());
//        param.setCityId(getOperator().getCityId());
//        param.setShardCityId(getOperator().getCityId());
//        param.setProvinceId(getOperator().getProvinceId());
//        param.setSelfUserId(getOperator().getUserId());
//        erpBuildingSetService.updateBuildRule(param);
//        return ErpResponseJson.ok();
//    }


//    /**
//     * 清空楼盘规则
//     *
//     * @param
//     * @return
//     * @auther 胡坤
//     * @since 2018/8/6
//     */
//    @ApiOperation("清空楼盘规则")
//    @ApiResponses(value = {
//            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
//    })
//    @PostMapping("/delBuildById")
//    @ResponseBody
//    public ResponseJson delBuildById(@Valid @RequestBody ErpBuildingSetParam param) {
//        param.setCityId(getOperator().getCityId());
//        param.setCompId(getOperator().getCompId());
//        param.setShardCityId(getOperator().getCityId());
//        param.setSelfUserId(getOperator().getUserId());
//        erpBuildingSetService.delBuildById(param);
//        return ErpResponseJson.ok();
//    }

//	/**
//	 * 删除单元
//	 * @author 臧铁
//	 * @since 2017年8月25日
//	 * @param param compId buildId  buildRoof栋座   buildUnit单元
//	 * @return
//	 */
//	@RequestMapping("/delBuildUnitById")
//	@ResponseBody
//	public ResponseJson delBuildUnitById(@Valid @RequestBody ErpBuildingSetParam param) {
//		param.setCityId(getOperator().getCityId());
//		param.setCompId(getOperator().getCompId());
//		param.setShardCityId(getOperator().getCityId());
//		param.setSelfUserId(getOperator().getUserId());
//		erpBuildingSetService.delBuildUnitById(param);
//		return ErpResponseJson.ok();
//	}

//	/**
//	 * 删除房间
//	 * @author 臧铁
//	 * @since 2017年8月25日
//	 * @param param compId buildId  buildRoof栋座   buildUnit单元  sysRoomId前端计算出的房间号
//	 * @return
//	 */
//	@RequestMapping("/delBuildRoomById")
//	@ResponseBody
//	public ResponseJson delBuildRoomById(@Valid @RequestBody BaseMapParam param) {
//		param.setInteger("compId", getOperator().getCompId());
//		param.setInteger("cityId", getOperator().getCityId());
//		param.setInteger("shardCityId", getOperator().getCityId());
//		param.setInteger("selfUserId", getOperator().getUserId());
//		erpBuildingSetRoomService.delBuildRoomById(param);
//		return ErpResponseJson.ok();
//	}

    /**
     * 获取单元、栋号、房间数
     *
     * @param param
     * @return
     * @author 张宏利
     * @since 2017年8月25日
     */
    @RequestMapping("/getRoofUnitRoomCount")
    @ResponseBody
    public ResponseJson getRoofUnitRoomCount(@Valid @RequestBody ErpBuildingSetParam param) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setShardCityId(getOperator().getCityId());
        ErpFunBuildRoofunitdoorsDto roofunitdoors = erpFunBuildRoofunitdoorsMapper.getRoofUnitRoomCount(param);
        if (roofunitdoors == null) {
            roofunitdoors = new ErpFunBuildRoofunitdoorsDto();
        }
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(getOperator().getCityId(), getOperator().getCompId(), param.getBuildId());
        int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
        roofunitdoors.setBuildLock((byte) (buildLock > 0 ? 1 : 0));
        if (buildLock > 0) {
            roofunitdoors.setBuildRoofName(erpBuildingSetSetting.getBuildRoofName());
            roofunitdoors.setBuildUnitName(erpBuildingSetSetting.getBuildUnitName());
        }
        return ErpResponseJson.ok(roofunitdoors);
    }

//	/**
//	 * 复制房间信息到整列
//	 * @author
//	 * @since 2017年8月31日
//	 * @param param
//	 * @return
//	 */
//	@RequestMapping("/updateRoomInfoToLine")
//	@ResponseBody
//	public ResponseJson updateRoomInfoToLine(@Valid @RequestBody ErpBuildingSetRoomParam param) {
//		String sysRoomIds = param.getSysRoomIds();
//		String[] sysRoomIdsarr = sysRoomIds.split(",");
//		param.setCityId(getOperator().getCityId());
//		param.setShardCityId(getOperator().getCityId());
//		param.setCompId(getOperator().getCompId());
//		param.setSelfUserId(getOperator().getUserId());
//		if (sysRoomIdsarr.length > 0) {
//			erpBuildingSetRoomService.updateRoomInfoToLine(getOperator().getCityId(), param, sysRoomIdsarr);
//		}
//		return ErpResponseJson.ok();
//	}

//	/**
//	 * 修改楼盘楼层名
//	 * @author 张宏利
//	 * @since 2017年10月10日
//	 * @param param
//	 * @return
//	 */
//	@RequestMapping("/updateBuildFloor")
//	@ResponseBody
//	public ResponseJson updateBuildFloor(@Valid @RequestBody ErpBuildingSetFloorParam param) {
//		param.setCityId(getOperator().getCityId());
//		param.setShardCityId(getOperator().getCityId());
//		param.setCompId(getOperator().getCompId());
//		param.setSelfUserId(getOperator().getUserId());
//		erpBuildingSetRoomService.updateBuildFloor(param);
//		return ErpResponseJson.ok();
//	}

    /**
     * 根据栋座单元查询房源租售情况(条数)
     *
     * @param param
     * @return
     * @author 李成兵
     * @since 2017年12月4日
     */
    @RequestMapping("/getSaleLeaseCount")
    @ResponseBody
    public ResponseJson getSaleLeaseCount(@Valid @RequestBody ErpBuildingSetFloorParam param) {
        Operator operator = getOperator();
        // 查询系统参数
        String coreInfoType = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "CORE_INFO_TYPE");
        if (StringUtils.isNotBlank(coreInfoType) && "2".equals(coreInfoType)) {
            param.setCaseRoof(null);
        }
        List<Map<String, Object>> resList = erpFunCoreInfoMapper.getSaleLeaseCount(operator.getCityId(), operator.getCompId(), param.getBuildId(), param.getCaseRoof(), param.getCaseUnit());
//		// jiemi
//		for (Map<String, Object> m : resList) {
//			Object houseFloor = m.get("houseFloor");
//			if(null != houseFloor) {
//				String decode = EnCodeHelper.decode(houseFloor.toString());
//				m.put("houseFloor", decode);
//			}
//		}
        return ErpResponseJson.ok(resList);
    }

    /**
     * 根据栋座单元查询房源租售情况
     *
     * @param param
     * @return
     * @author 李成兵
     * @since 2017年12月4日
     */
    @RequestMapping("/getSaleList")
    @ResponseBody
    public ResponseJson getSaleList(@Valid @RequestBody ErpBuildingSetFloorParam param) {
        Operator operator = getOperator();
        // 判断下参数
        String erpSysPara = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "CORE_INFO_TYPE");
        if ("2".equals(erpSysPara)) {
            param.setCaseRoof(null);
            param.setCaseFloor(null);
        }
        List<ErpFunSale> erpFunSales = erpFunSaleMapper.getSaleListByRoomId(operator.getCityId(), operator.getCompId(), param);
        return ErpResponseJson.ok(erpFunSales);
    }

    /**
     * 根据栋座单元查询房源租售情况
     *
     * @param param
     * @return
     * @author 李成兵
     * @since 2017年12月4日
     */
    @RequestMapping("/getLeaseList")
    @ResponseBody
    public ResponseJson getLeaseList(@Valid @RequestBody ErpBuildingSetFloorParam param) {

        Operator operator = getOperator();
        List<ErpFunLease> erpFunSales = erpFunLeaseMapper.getLeaseListByRoomId(operator.getCityId(), operator.getCompId(), param);
        return ErpResponseJson.ok(erpFunSales);
    }

    /**
     * 租售房源统计
     *
     * @param param
     * @return
     * @author 李成兵
     * @since 2017年12月4日
     */
    @ResponseBody
    @RequestMapping("/getHouseTotalData")
    public ResponseJson getHouseTotalData(@Valid @RequestBody ErpBuildingSetFloorParam param) {
        Map<String, Integer> resDataMap = new HashMap<>();
        Operator operator = getOperator();
        // 查询已售未售
        Map<String, Integer> saleDataMap = erpFunSaleMapper.getSaleHouseBuildCountData(operator.getCityId(), operator.getCompId(), param.getBuildId(), param.getCaseRoof(), param.getCaseUnit());
        Map<String, Integer> leaseDataMap = erpFunLeaseMapper.getLeaseHouseBuildCountData(operator.getCityId(), operator.getCompId(), param.getBuildId(), param.getCaseRoof(), param.getCaseUnit());
        if (null != saleDataMap) {
            resDataMap.putAll(saleDataMap);
        }
        if (null != leaseDataMap) {
            resDataMap.putAll(leaseDataMap);
        }
        return ErpResponseJson.ok(resDataMap);
    }

    /**
     * 云房获取价格走势
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/16
     */
    @RequestMapping("/getBuildPriceTrend")
    @ResponseBody
    public ResponseJson getBuildPriceTrend(@Valid @RequestBody BaseMapParam param) {
        Map<String, Object> resultObjMap = new HashMap<String, Object>();
        param.setObject("cityId", getOperator().getCityId());
        String uuhfWebRootUrl = AppConfig.getRootUuhfWebDomainPath();
        if (uuhfWebRootUrl.endsWith("/")) {
            uuhfWebRootUrl = uuhfWebRootUrl.substring(0, uuhfWebRootUrl.length() - 1);
        }
        try {
            String houseBaseInfo = HttpUtil.post(uuhfWebRootUrl + "/yunfang/buildingController/houseBaseInfo", param.getMap());
            Map<String, String> parseMap = JSON.parseObject(houseBaseInfo, new TypeReference<Map<String, String>>() {
            });
            if (parseMap != null && "200".equals(parseMap.get("code"))) {
                parseMap = JSON.parseObject(parseMap.get("data"), new TypeReference<Map<String, String>>() {
                });
                if (!parseMap.isEmpty()) {
                    Map<String, String> resultUpDown = new HashMap<>();
                    resultUpDown.put("unitPrice", parseMap.get("unitPrice"));// 均价
                    resultUpDown.put("ratioLastMonth", parseMap.get("ratioByLastMonthForPrice"));// 均价环比
                    resultUpDown.put("ratioLastYear", parseMap.get("ratioByLastYearForPrice"));// 均价同比
                    resultObjMap.put("trendNow", resultUpDown);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String priceTrend = HttpUtil.post(uuhfWebRootUrl + "/yunfang/buildingController/getPriceTrend", param.getMap());
            Map<String, String> priceTrendMap = JSON.parseObject(priceTrend, new TypeReference<Map<String, String>>() {
            });
            if ("200".equals(priceTrendMap.get("code"))) {
                Map<String, String> parseDataMap = JSON.parseObject(priceTrendMap.get("data"), new TypeReference<Map<String, String>>() {
                });
                resultObjMap.put("cityList", this.getDataList(parseDataMap.get("city")));
                resultObjMap.put("regionList", this.getDataList(parseDataMap.get("region")));
                resultObjMap.put("houseList", this.getDataList(parseDataMap.get("house")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ErpResponseJson.ok(resultObjMap);
    }

    /**
     * 获取列表数据
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/16
     */
    private List<Map<String, String>> getDataList(String data) {
        List<Map<String, String>> parseListMap = JSON.parseObject(data, new TypeReference<List<Map<String, String>>>() {
        });
        List<Map<String, String>> list = new LinkedList<>();
        for (Map<String, String> map : parseListMap) {
            Map<String, String> resultMap = new HashMap<String, String>();
            resultMap.put("trendRatio", map.get("trendRatio"));// 趋势的百分比
            resultMap.put("trend", map.get("trend"));// 趋势描述
            resultMap.put("price", map.get("price"));// 价格
            resultMap.put("houseType", map.get("houseType"));// 房源来下1住宅2别墅
            resultMap.put("priceMonths", map.get("priceMonths"));// 走势月份
            list.add(resultMap);
        }
        Collections.sort(list, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                return o1.get("priceMonths").compareTo(o2.get("priceMonths"));
            }
        });
        return list;
    }

    /**
     * @Title 楼盘资料周边
     * @Author lcb
     * @Time 2018/8/22
     **/
    @RequestMapping("/getBuildingInfoMap")
    public String getBuildingInfoMap(Map<String, Object> paramMap, Integer buildId) {
        Operator operator = getOperator();
        ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.getBaseInfoByBuildId(operator.getCityId(), buildId);
        if (null != erpBuildingInfo) {
            if (StringUtils.isBlank(erpBuildingInfo.getPositionY()) || StringUtils.isBlank(erpBuildingInfo.getPositionX())) {
                String baiduLanLat = getBaiduLanLat(operator.getCityId(), erpBuildingInfo.getBuildAddr());
                JSONObject jsonObject = JSONObject.parseObject(baiduLanLat);

                String geocodes = jsonObject.getString("result");
                jsonObject = JSONObject.parseObject(geocodes);
                Map<String, Object> resMap = (Map<String, Object>) jsonObject.get("location");
                paramMap.put("lat", resMap.get("lat"));
                paramMap.put("lng", resMap.get("lng"));
            } else {
                Double latDouble = Double.valueOf(erpBuildingInfo.getPositionX());
                Double lngDouble = Double.valueOf(erpBuildingInfo.getPositionY());
                Object[] objects = map_tx2bd(latDouble, lngDouble);
                if (null != objects && objects.length == 2) {
                    paramMap.put("lat", objects[1]);
                    paramMap.put("lng", objects[0]);
                }
            }
        } else {
            String baiduLanLat = getBaiduLanLat(operator.getCityId(), null);
            JSONObject jsonObject = JSONObject.parseObject(baiduLanLat);
            String geocodes = jsonObject.getString("result");
            jsonObject = JSONObject.parseObject(geocodes);
            Map<String, Object> resMap = (Map<String, Object>) jsonObject.get("location");
            paramMap.put("lat", resMap.get("lat"));
            paramMap.put("lng", resMap.get("lng"));
        }
        paramMap.put("buildName", erpBuildingInfo.getBuildName());
        return "distribution/buildingInfoMap";
    }

    /**
     * @Title : 百度系
     * @author : lcb
     * @Time ： 2018/8/2
     **/
    public String getBaiduLanLat(Integer cityId, String address) {
        AdminFunCity adminFunCityPO = adminFunCityMapper.getDataByCityId(cityId);
        // 定位
        String mapUrl = "http://api.map.baidu.com/geocoder/v2/";
        Map<String, String> pMap = new HashMap<>();
        pMap.put("ak", "WGktd7uvWTFZhPlsivZAi1FwFZF0f3M2");
        pMap.put("city", adminFunCityPO.getCityName());
        pMap.put("address", StringUtils.isNotBlank(address) ? address : adminFunCityPO.getCityName());
        pMap.put("output", "json");
        String post = HttpUtil.post(mapUrl, pMap);
        return post;
    }

    public Object[] map_tx2bd(double lat, double lon) {
        double bd_lat;
        double bd_lon;
        double x_pi = 3.14159265358979324;
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;
        return new Object[]{bd_lon, bd_lat};
    }


    /**
     * 获取楼盘基本信息
     *
     * @param param
     * @author wangchun
     * @since 2018年12月13日
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取楼盘基本信息")
    @ApiResponses(value = {@ApiResponse(code = 200, response = GetBuildBaseInfoVo.class, message = "成功")})
    @PostMapping("/getBuildBaseInfo")
    @ResponseBody
    public ResponseJson getBuildBaseInfo(@Valid @RequestBody GetBuildBaseInfoParam param) {
        Integer buildId = param.getBuildId();
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        GetBuildBaseInfoVo vo = new GetBuildBaseInfoVo();

        // 是否是模板
        boolean isTemp = param.getIsTmp() != null && param.getIsTmp() == 1;
        if (isTemp) {
            ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(cityId, compId, buildId);
            if (null == info || null == info.getTemplateCompId()) {
                return ErpResponseJson.ok();
            }
            compId = info.getTemplateCompId();
        }

        ErpFunBuildRoofunitdoors counts = erpFunBuildRoofunitdoorsMapper.getRoUnDoCounts(cityId, 0, buildId);
//        ErpBuildingMarketingControlMin saleLeaseCount = null;
        // 模板不查询销控信息
        if (!isTemp) {
//            saleLeaseCount = erpBuildingMarketingControlMinMapper.getBuildOnSaleLeaseCount(cityId, compId, buildId);
            GeneralParam generalParam = new GeneralParam(getOperator());
            RoomConInfoCountParam roomConInfoCountParam = new RoomConInfoCountParam();
            roomConInfoCountParam.setBuildId(buildId);
            RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(roomConInfoCountParam, generalParam);

            if (conInfoCount != null) {
                vo.setOnSaleCount(conInfoCount.getSaleCount());
                vo.setOnLeaseCount(conInfoCount.getLeaseCount());
                vo.setSaleAndLeaseCount(conInfoCount.getSaleAndLeaseCount());
            }
        }

        Integer managerId = erpBuildingManagerMapper.getBuildManageUserId(cityId, buildId, compId);
        ErpBuildingSetSetting setting = erpBuildingSetSettingMapper.selectByBuildId(cityId, 0, buildId);

        if (counts != null) {
            vo.setRoofs(counts.getRoofs());
            vo.setUnits(counts.getUnits());
            vo.setRooms(counts.getDoors());
        }
        if (setting != null) {
            vo.setBuildLock(setting.getBuildLock() == null ? 0 : setting.getBuildLock());
        }

        vo.setBuildManager(managerId);
        return ErpResponseJson.ok(vo);
    }


    /**
     * 获取楼栋（户）信息
     * @author wangchun
     * @since 2018年12月13日
     * @param param
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取楼栋（户）信息")
    @ApiResponses(value = {@ApiResponse(code = 200, response = GetRoofInfoVo.class, message = "成功")})
    @PostMapping("/getRoofInfo")
    @ResponseBody
    public ResponseJson getRoofInfo(@Valid @RequestBody GetRoofInfoParam param){
        Integer compId = getOperator().getCompId();
        Integer cityId = getOperator().getCityId();
        Integer buildId = param.getBuildId();
        String paramValue = erpSysParaMapper.getParamValue(cityId,compId,"CORE_INFO_TYPE");
        paramValue = paramValue == null ? "0" : paramValue;
        if (param.getIsTmp() != null && param.getIsTmp() == 1) {
            ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(cityId, compId, buildId);
            if (null == info || null == info.getTemplateCompId()) {
                return ErpResponseJson.ok();
            }
            compId = info.getTemplateCompId();
        }
        GetRoofInfoVo vo = new GetRoofInfoVo();
        //栋
        if("0".equals(paramValue) && param.getBuildingSetRoof() != null && !"".equals(param.getBuildingSetRoof().trim())){
            vo = erpBuildingMarketingControlMapper.getRoofConInfo(cityId,buildId,compId,param.getBuildingSetRoof());
            vo = vo == null ? new GetRoofInfoVo() : vo;
            RoofInfoDto baseInfo = erpBuildingSetRoofMapper.getRoofInfo(cityId,compId,buildId,param.getBuildingSetRoof());
            if (baseInfo != null) {
                vo.setHouseUseage(baseInfo.getHouseUseage());
                vo.setHouseYear(baseInfo.getHouseYear());
                vo.setUnits(baseInfo.getUnits());
                vo.setDoors(baseInfo.getDoors());
                vo.setBuildingSetRoofId(baseInfo.getBuildingSetRoofId());
                if (baseInfo.getBuildingManagerId() != null) {
                    Integer userId = erpBuildingManagerMapper.getRoofManagerById(cityId,compId,baseInfo.getBuildingManagerId());
                    vo.setRoofManager(userId);
                }
            }
        }
        //号
        if ("2".equals(paramValue) && param.getBuildingSetUnit() != null && !"".equals(param.getBuildingSetUnit())) {
            vo = erpBuildingMarketingControlMapper.getUnitConInfo(cityId,buildId,compId,param.getBuildingSetUnit());
            vo = vo == null ? new GetRoofInfoVo() : vo;
            ErpBuildingSetUnit doorsAndId = erpBuildingSetUnitMapper.getUnitDoors(cityId,compId,buildId,param.getBuildingSetUnit());
            if (doorsAndId != null) {
                vo.setBuildingSetUnitId(doorsAndId.getId());
                vo.setDoors(doorsAndId.getDoors());
            }
        }
        return ErpResponseJson.ok(vo);
    }

    /**
     * 获取房间销控信息
     *
     * @param param GetRoomConInfoParam
     * @author wangchun
     * @since 2018年12月13日
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取房间销控信息")
    @ApiResponses(value = {@ApiResponse(code = 200, response = GetRoomConInfoVo.class, message = "成功")})
    @PostMapping("/getRoomConInfo")
    @ResponseBody
    public ResponseJson getRoomConInfo(@Valid @RequestBody GetRoomConInfoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        List<ErpBuildingMarketingControlDto> conInfos = erpBuildingMarketingControlMapper.getRoomConInfo(cityId,
                compId, param.getBuildId(), param.getBuildingSetRoof(), param.getBuildingSetUnit());

        List<ErpBuildingMarketingControlDto> saleConInfos = conInfos.stream().filter(it -> it.getCaseType() == 1).collect(Collectors.toList());
        List<ErpBuildingMarketingControlDto> leaseConInfos = conInfos.stream().filter(it -> it.getCaseType() == 2).collect(Collectors.toList());

        List<Integer> saleIds = saleConInfos.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toList());
        List<Integer> leaseIds = leaseConInfos.stream().map(ErpBuildingMarketingControlDto::getCaseId).collect(Collectors.toList());

        List<ErpFunSale> sales = new ArrayList<>();
        List<ErpFunLease> leases = new ArrayList<>();
        if (saleIds.size() > 0) {
            sales = erpFunSaleMapper.getFunListByCaseIds(cityId, compId, saleIds);
        }
        if (leaseIds.size() > 0) {
            leases = erpFunLeaseMapper.getFunListByCaseIds(cityId, compId, leaseIds);
        }

        for (ErpBuildingMarketingControlDto dto : conInfos) {
            Byte caseType = dto.getCaseType();

            if (caseType == 1) {
                if (sales != null && sales.size() > 0) {
                    Optional<ErpFunSale> sale = sales.stream().filter(it -> it.getSaleId().equals(dto.getCaseId())).findFirst();
                    if (sale.isPresent()) {
                        ErpFunSale funSale = sale.get();
                        String roof = funSale.getSaleRoofT();
                        String unit = funSale.getSaleUnitT();
                        String floor = funSale.getSaleFloor() == null ? "" : funSale.getSaleFloor().toString();
                        String room = funSale.getSaleNumT();

                        if ((dto.getBuildingSetRoof() != null && !dto.getBuildingSetRoof().equals(roof)) ||
                                (dto.getBuildingSetUnit() != null && !dto.getBuildingSetUnit().equals(unit)) ||
                                (dto.getBuildingSetFloor() != null && !dto.getBuildingSetFloor().equals(floor)) ||
                                (dto.getRoomId() != null && !dto.getRoomId().equals(room))) {
                            conInfos = conInfos.stream().filter(it -> !it.getCaseId().equals(dto.getCaseId())).collect(Collectors.toList());
                        }

                        if (funSale.getSaleStatus() == 7) {
                            conInfos = conInfos.stream().filter(it -> !it.getCaseId().equals(dto.getCaseId())).collect(Collectors.toList());
                        } else {
                            dto.setSalePrice(funSale.getSaleTotalPrice());
                        }
    
                        // 查询房源上的组织的业务类型 用于前端筛选
                        if (null != funSale.getOrganizationId()) {
                            ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, funSale.getOrganizationId());
                            if (null != erpFunOrganization) {
                                dto.setOrganizationBussinessType(erpFunOrganization.getOrganizationBussinessType());
                            }
                        }
                    }

                }
            } else {
                if (leases != null && leases.size() > 0) {
                    Optional<ErpFunLease> lease = leases.stream().filter(it -> it.getLeaseId().equals(dto.getCaseId())).findFirst();
                    if (lease.isPresent()) {
                        ErpFunLease funLease = lease.get();

                        String roof = funLease.getLeaseRoofT();
                        String unit = funLease.getLeaseUnitT();
                        String floor = funLease.getLeaseFloor() == null ? "" : funLease.getLeaseFloor().toString();
                        String room = funLease.getLeaseNumT();

                        if ((dto.getBuildingSetRoof() != null && !dto.getBuildingSetRoof().equals(roof)) ||
                                (dto.getBuildingSetUnit() != null && !dto.getBuildingSetUnit().equals(unit)) ||
                                (dto.getBuildingSetFloor() != null && !dto.getBuildingSetFloor().equals(floor)) ||
                                (dto.getRoomId() != null && !dto.getRoomId().equals(room))) {
                            conInfos = conInfos.stream().filter(it -> !it.getCaseId().equals(dto.getCaseId())).collect(Collectors.toList());
                        }

                        if (funLease.getLeaseStatus() == 7) {
                            conInfos = conInfos.stream().filter(it -> !it.getCaseId().equals(dto.getCaseId())).collect(Collectors.toList());
                        } else {
                            dto.setLeasePrice(funLease.getLeaseTotalPrice());
                            dto.setLeasePriceUnit(funLease.getPriceUnit());
                        }
                        dto.setLessor(funLease.getLessor());
    
                        // 查询房源上的组织的业务类型 用于前端筛选
                        if (null != funLease.getOrganizationId()) {
                            ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, funLease.getOrganizationId());
                            if (null != erpFunOrganization) {
                                dto.setOrganizationBussinessType(erpFunOrganization.getOrganizationBussinessType());
                            }
                        }
                    }
                }
            }
        }

        GetRoomConInfoVo vo = new GetRoomConInfoVo();
        vo.setConInfos(conInfos);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 获取楼盘、栋座信息与责任人
     * @author wangchun
     * @since 2018年12月17日
     * @param param GetManageInfoParam
     */
    @ApiOperation("获取楼盘、栋座信息与责任人")
    @ApiResponses(value = {@ApiResponse(code = 200, response = GetManageInfoVo.class, message = "成功")})
    @PostMapping("/getManagerInfo")
    @ResponseBody
    public ResponseJson getManageInfo(@Valid @RequestBody GetManageInfoParam param){
        Integer buildId = param.getBuildId();
        Integer buildManager = erpBuildingManagerMapper.getBuildManageUserId(getOperator().getCityId(), buildId ,getOperator().getCompId());

        List<RoofInfoDto> roofInfos = erpBuildingSetRoofMapper.getRoofInfos(getOperator().getCityId(),getOperator().getCompId(),buildId);

        GetManageInfoVo resultVo = new GetManageInfoVo();
        resultVo.setBuildManager(buildManager);
        resultVo.setRoofInfos(roofInfos);
        return ErpResponseJson.ok(resultVo);
    }

    /**
     * 创建或修改楼盘楼栋责任人
     *
     * @author wangchun
     * @since 2018年12月13日
     * @param param BaseMapParam
     */
    @ApiOperation("创建或修改楼盘楼栋责任人")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "成功")})
    @PostMapping("/creatOrEditManager")
    @NotBlank("userId")
    @ResponseBody
    public ResponseJson creatOrEditManager (@Valid @RequestBody CreatOrEditManagerParam param){
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        erpBuildingManagerService.creatOrEditManager(param);
        return ErpResponseJson.ok();
    }

    /**
     * 楼盘锁定或者解锁
     * @author wangchun
     * @since 2018年12月18日
     * @param param ErpBuildingSetSettingParam
     * @return NODATA 没有数据   SUCCESS 成功  NO_LOCK_BUILDING 没有权限
     */
    @ApiOperation("楼盘锁定或者解锁")
    @ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功") })
    @PostMapping("/updateLockBuildRule")
    @ResponseBody
    public ResponseJson updateLockBuildRule(@Valid @RequestBody ErpBuildingSetSettingParam param) {
		Operator operator = getOperator();
		Integer buildId = param.getBuildId();
		Integer lockFlag = param.getLockFlag();
		erpBuildingSetUnitService.updateLockBuildRule(operator.getCityId(),operator.getCompId(),operator.getCompNo(),operator.getProvinceId(),buildId,lockFlag,operator.getUserId(),operator.getDeptId());
        return ErpResponseJson.ok();
    }

    /**
     * 编辑房间
     * @author wangchun
     * @since 2018年12月18日
     * @param param BuildingSetRoomParam
     */
    @ApiOperation("编辑房间")
    @ApiResponses(value = {@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功") })
    @PostMapping("/updateRoomInfo")
    @ResponseBody
    public ResponseJson updateRoomInfo(@RequestBody UpdateRoomInfoParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        param.setSelfUserId(getOperator().getUserId());
        ErpBuildingSetRoom room = erpBuildingSetRoomMapper.checkExistsRoom(cityId,0,param.getBuildingSetRoomId());
        if (room == null) {
            throw new BusinessException("该房间不存在!");
        }
        // 判断房号占用只在当前楼层判断
        Integer count = erpBuildingSetRoomMapper.checkExistsRoomId(cityId,0,param.getBuildId(),param.getBuildingSetUnitId(),
                param.getRoomId(),param.getBuildingSetRoomId(), param.getBuildingSetFloorId());
        if (count > 0) {
            throw new BusinessException("该房号已被占用!");
        }

        String oldMd5 = room.getAddrMd5();
        String addrMd5 = null;

        // 号位规则, 房间MD5不带楼层
        String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        if (!room.getRoomId().equals(param.getRoomId())) {
            ErpBuildingSetFloor rounfl = erpBuildingSetFloorMapper.selectRoofAndUnitNameInFloor(cityId,0,param.getBuildId(),param.getBuildingSetFloorId());

            if ("2".equals(paramValue)) {
                addrMd5 = erpBuildingSetRoomService.encodeToMD5ByUnit(param.getBuildId(), rounfl.getBuildUnit(), param.getRoomId());
            } else {
                addrMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), rounfl.getBuildRoof(), rounfl.getBuildUnit(), rounfl.getBuildFloor(), param.getRoomId());
            }

//            addrMd5 = erpBuildingSetRoomService.encodeToMD5(param.getBuildId(), rounfl.getBuildRoof(), rounfl.getBuildUnit(), rounfl.getBuildFloor(), param.getRoomId());
        }
        erpBuildingSetRoomService.updateRoomInfo(param,addrMd5,cityId,compId,oldMd5);

        if (param.getReplacePhotos() != null && param.getReplacePhotos() == 1) {
            erpBuildingSetRoomService.insertHouseLayoutSync(param,addrMd5==null?oldMd5:addrMd5,cityId,0);
        }
        httpRequestTask.postToTaskWeb("/houseLayoutSync/sync",new HashMap<>());
        return ErpResponseJson.ok();
    }

    /**
     * 合并房间
     * @author wangchun
     * @since 2018年12月20日
     * @param param RoomIdsParam
     */
    @ApiOperation("合并房间")
    @ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功") })
    @PostMapping("/mergeRoomInfo")
    @NotBlank("buildingSetUnitId")
    @ResponseBody
    public ResponseJson mergeRoomInfo(@RequestBody RoomIdsParam param) {
        param.setCompId(getOperator().getCompId());
        param.setCityId(getOperator().getCityId());
        param.setSelfUserId(getOperator().getUserId());
        erpBuildingSetRoomService.mergeRoomInfo(param);
        return ErpResponseJson.ok();
    }

    /**
     * 取消合并房间
     *
     * @author wangchun
     * @since 2018年12月20日
     * @param param CancelMergeRoomInfoParam
     */
    @ApiOperation("取消合并房间")
    @ApiResponses(value = { @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功") })
    @PostMapping("/cancelMergeRoomInfo")
    @NotBlank("buildingSetUnitId")
    @ResponseBody
    public ResponseJson cancelMergeRoomInfo(@RequestBody CancelMergeRoomInfoParam param) {
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setUserId(getOperator().getUserId());
        erpBuildingSetRoomService.cancelMergeRoomInfo(param);
        return ErpResponseJson.ok();
    }

    /**
     * 获取楼盘栋座列表
     *
     * @author czq
     * @since 2018年12月12日
     * @param param BuildIdParam
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取楼盘栋座列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = BuildRoofListVo.class, message = "成功")
    })
    @PostMapping("/getBuildRoofList")
    @ResponseBody
    public ResponseJson getBuildRoofList(@Valid @RequestBody BuildIdParam param) {
        Operator operator = getOperator();

        // 是否需要统计栋座中销控表数量
        int needCount = param.getNeedCount() == null ? 0 : param.getNeedCount();
        List<ErpBuildingSetRoofNameVo> roofNameVos;

        if (needCount == 0) {
            roofNameVos = erpBuildingSetRoofMapper.getBuildRoofNameVo(getOperator().getCityId(), 0, param.getBuildId());
        } else {
            roofNameVos = erpBuildingSetRoofMapper.getRoofNameAndMarketingControlCount(getOperator().getCityId(), operator.getCompId(), param.getBuildId());
        }

        BuildRoofListVo buildRoofListVo = new BuildRoofListVo();
        buildRoofListVo.setRoofNameListVo(roofNameVos);
        buildRoofListVo.setHaveBuildTemplate(0);

//        // 查看是否有系统模板
//        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(getOperator().getCityId(), operator.getCompId(), param.getBuildId());
//
//        if(info != null && info.getTemplateCompId() != null && !info.getTemplateCompId().equals(getOperator().getCompId())) {
//            buildRoofListVo.setHaveBuildTemplate(1);
//        }

        return ErpResponseJson.ok(buildRoofListVo);
    }

    /**
     * 获取栋座规则详情
     *
     * @author czq
     * @since 2018年12月12日
     * @param param ErpBuildingSetRoofIdParam
     */
    @NotBlank({"buildingSetRoofId", "buildId"})
    @ApiOperation("获取栋座规则详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpBuildingSetRoofRuleVo.class, message = "成功")
    })
    @PostMapping("/getBuildRoofRule")
    @ResponseBody
    public ResponseJson getBuildRoofRule(@Valid @RequestBody ErpBuildingSetRoofIdParam param) {
        ErpBuildingSetRoofRuleVo roof = erpBuildingSetRoofMapper.getBuildingSetRoofRuleVo(getOperator().getCityId(),
                getOperator().getCompId(), param.getBuildId(), param.getBuildingSetRoofId());
        return ErpResponseJson.ok(roof);
    }

    /**
     * 获取楼盘栋座列表(模板)
     *
     * @author czq
     * @since 2018年12月13日
     * @param param BuildIdParam
     */
    @ApiOperation("获取楼盘栋座列表(模板)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpBuildingSetRoofNameVo.class, message = "成功")
    })
    @PostMapping("/getTempBuildRoofList")
    @ResponseBody
    public ResponseJson getTempBuildRoofList(@Valid @RequestBody BuildIdParam param) {
        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(getOperator().getCityId(), getOperator().getCompId(), param.getBuildId());
        if(info == null || null == info.getTemplateCompId()) {
            return ErpResponseJson.ok();
        }

        List<ErpBuildingSetRoofNameVo> roofNameVos = erpBuildingSetRoofMapper.getBuildRoofNameVo(getOperator().getCityId(), info.getTemplateCompId(), param.getBuildId());
        return ErpResponseJson.ok(roofNameVos);
    }

    /**
     * 获取单元或者号位列表
     *
     * 1.栋ID没有传,是号位规则
     *   1.1 查询出来的号位在单元表中是否有BuildingSetRoofId,有的话在栋表中查询该BuildingSetRoofId是否存在
     *     1.1.1 存在:普通栋座的楼盘,被号位的规则打开,提示楼盘为非号位规则
     *     1.2.1 不存在:返回正确的号位(unit)列表
     * 2.栋ID传了,普通规则,查询出单元(unit列表)
     * 3.统计是否有模板
     * 4.统计是否房间已经生产完毕
     *
     * @author czq
     * @since 2018年12月12日
     * @param param ErpBuildingSetRoofIdParam
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取单元或者号位列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpBuildingSetUnitNameVo.class, message = "成功")
    })
    @PostMapping("/getBuildUnitList")
    @ResponseBody
    public ResponseJson getBuildUnitList(@Valid @RequestBody ErpBuildingSetRoofIdParam param) {
        Operator operator = getOperator();

        List<ErpBuildingSetUnitVo> unitVos;

        // 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
        String paramVal = erpSysParaMapper.getParamValue(operator.getCityId(), operator.getCompId(), "CORE_INFO_TYPE");

        if ("2".equals(paramVal)) {
            unitVos = erpBuildingSetUnitMapper.getBuildUnitListVo(operator.getCityId(), operator.getCompId(), param.getBuildId(), null);
        } else {
            if (param.getBuildingSetRoofId() == null) {
                throw new BusinessException("楼盘为非号位规则!");
            }

            int needCount = param.getNeedCount() == null ? 0 : param.getNeedCount();

            if (needCount == 0) {
                unitVos = erpBuildingSetUnitMapper.getBuildUnitListVo(operator.getCityId(), operator.getCompId(), param.getBuildId(), param.getBuildingSetRoofId());
            } else {
                unitVos = erpBuildingSetUnitMapper.getUnitNameAndMarketingControlCount(operator.getCityId(), operator.getCompId(), param.getBuildId(), param.getBuildingSetRoofId());
            }
        }

        ErpBuildingSetUnitNameVo unitNameListVo = new ErpBuildingSetUnitNameVo();
        unitNameListVo.setUnitNameListVo(unitVos);
        unitNameListVo.setHaveBuildTemplate(0);

        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(getOperator().getCityId(), operator.getCompId(), param.getBuildId());
        if (info != null && info.getTemplateCompId() != null && !info.getTemplateCompId().equals(getOperator().getCompId())) {
            ErpBuildingSetUnitExample example = new ErpBuildingSetUnitExample();
            example.setShardCityId(operator.getCityId());

            if ("2".equals(paramVal)) {
                example.createCriteria()
                        .andBuildIdEqualTo(param.getBuildId())
                        .andCompIdEqualTo(info.getTemplateCompId());
            } else {
                example.createCriteria()
                        .andBuildIdEqualTo(param.getBuildId())
                        .andCompIdEqualTo(0)
                        .andBuildingSetRoofIdEqualTo(param.getBuildingSetRoofId());
            }

            int unitTempCount = erpBuildingSetUnitMapper.countByExample(example);
            if (unitTempCount > 0) {
                unitNameListVo.setHaveBuildTemplate(1);
            }
        }

        // 房间是否生成完毕
        long roomNotGeneratedCount = unitVos.stream().filter(it -> it.getRoomGenerated() != null && it.getRoomGenerated() != 1).count();
        if (roomNotGeneratedCount > 0) {
            unitNameListVo.setRoomGenerated((byte) 0);
        } else {
            unitNameListVo.setRoomGenerated((byte) 1);
        }

        return ErpResponseJson.ok(unitNameListVo);
    }

    /**
     * 根据楼盘栋座获取单元列表(模板)
     *
     * @author czq
     * @since 2018年12月12日
     * @param param ErpBuildingSetRoofIdParam
     */
    @ApiOperation("根据楼盘栋座获取单元列表(模板)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, responseContainer = "List", response = ErpBuildingSetUnitVo.class, message = "成功")
    })
    @PostMapping("/getTempBuildUnitList")
    @ResponseBody
    public ResponseJson getTempBuildUnitList(@Valid @RequestBody ErpBuildingSetRoofIdParam param) {
        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(getOperator().getCityId(), getOperator().getCompId(), param.getBuildId());
        if(info == null || null == info.getTemplateCompId()) {
            return ErpResponseJson.ok();
        }

        List<ErpBuildingSetUnitVo> unitVos = erpBuildingSetUnitMapper.getBuildUnitListVo(getOperator().getCityId(),
                info.getTemplateCompId(), param.getBuildId(), param.getBuildingSetRoofId());
        return ErpResponseJson.ok(unitVos);
    }

    /**
     * 获取单元或者号位规则详情
     *
     * @author czq
     * @since 2018年12月20日
     * @param param GetBuildUnitRuleParam
     */
    @NotBlank({"buildId"})
    @ApiOperation("获取单元或者号位规则详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingSetUnitDetailsVO.class, message = "成功")
    })
    @PostMapping("/getBuildUnitRule")
    @ResponseBody
    public ResponseJson getBuildUnitRule(@Valid @RequestBody GetBuildUnitRuleParam param) {
        ErpBuildingSetUnitDetailsVO detailsVO = erpBuildingSetUnitMapper.getBuildUnitRule(getOperator().getCityId(), getOperator().getCompId(), param);
        return ErpResponseJson.ok(detailsVO);
    }

	/**
	 * 通过栋座,单元,楼层获取房间列表
     * 1. 分为楼盘-栋-单元-楼层-房间 以及 楼盘-号位-楼层-房间, 区别为没有栋的ID
	 *
	 * @author czq
	 * @since 2018年12月12日
	 * @param param ErpBuildingGetRoomInfoListIdParam
	 */
	@ApiOperation("通过栋座,单元,楼层获取房间列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingSetRoomListVo.class, message = "成功")
	})
	@PostMapping("/getRoomInfoList")
	@ResponseBody
	public ResponseJson getRoomInfoList(@Valid @RequestBody ErpBuildingGetRoomInfoListIdParam param) {
        ErpBuildingSetRoomListVo roomListVo = new ErpBuildingSetRoomListVo();
        Integer cityId = getOperator().getCityId();

        ErpBuildingSetUnit unit = erpBuildingSetUnitMapper.getBuildUnitRoomGenerated(cityId, 0, param.getBuildId(), param.getBuildingSetUnitId());
        // 如果单元的状态还是为正在生成中,就返回空列表回去
        if (unit == null || unit.getRoomGenerated() == 0) {
            return ErpResponseJson.ok(roomListVo);
        }

        List<ErpBuildingSetFloorVo> floorVos = erpBuildingSetFloorMapper.selectFloorVos(cityId, 0, param.getBuildId(),
                param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        if (floorVos != null) {
            floorVos.forEach(it -> it.setFloorCount(floorVos.size()));
        }
        roomListVo.setFloorList(floorVos);

        List<ErpBuildingSetRoomShowInTableVo> roomShowInTableVos = erpBuildingSetRoomMapper.selectRoomShowInTableVos(cityId,
                0, param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        roomListVo.setRoomList(roomShowInTableVos);

		return ErpResponseJson.ok(roomListVo);
	}

    /**
     * 通过栋座,单元,楼层获取房间列表(模板)
     *
     * @author czq
     * @since 2018年12月12日
     * @param param ErpBuildingGetRoomInfoListIdParam
     */
    @ApiOperation("通过栋座,单元,楼层获取房间列表(模板)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingSetRoomListVo.class, message = "成功")
    })
    @PostMapping("/getTempRoomInfoList")
    @ResponseBody
    public ResponseJson getTempRoomInfoList(@Valid @RequestBody ErpBuildingGetRoomInfoListIdParam param) {
        ErpBuildingSetRoomListVo roomListVo = new ErpBuildingSetRoomListVo();
        Integer cityId = getOperator().getCityId();

        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(getOperator().getCityId(), getOperator().getCompId(), param.getBuildId());
        if(info == null || null == info.getTemplateCompId()) {
            return ErpResponseJson.ok();
        }

        ErpBuildingSetUnit unit = erpBuildingSetUnitMapper.getBuildUnitRoomGenerated(cityId, info.getTemplateCompId(), param.getBuildId(), param.getBuildingSetUnitId());
        // 如果单元的状态还是为正在生成中,就返回空列表回去
        if (unit == null || unit.getRoomGenerated() == 0) {
            return ErpResponseJson.ok(roomListVo);
        }

        List<ErpBuildingSetFloorVo> floorVos = erpBuildingSetFloorMapper.selectFloorVos(cityId, info.getTemplateCompId(), param.getBuildId(),
                param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        if (floorVos != null) {
            floorVos.forEach(it -> it.setFloorCount(floorVos.size()));
        }
        roomListVo.setFloorList(floorVos);

        List<ErpBuildingSetRoomShowInTableVo> roomShowInTableVos = erpBuildingSetRoomMapper.selectRoomShowInTableVos(cityId,
                info.getTemplateCompId(), param.getBuildId(), param.getBuildingSetRoofId(), param.getBuildingSetUnitId());
        roomListVo.setRoomList(roomShowInTableVos);

        return ErpResponseJson.ok(roomListVo);
    }

	/**
	 * 系统模板应用到当前楼盘
     *
	 * 1. 软删除以前的栋,单元,楼层,房间规则
     * 2. 把该栋compId为0的模板拷贝到新的栋,单元,楼层,房间规则
     * 3. 区分是普通楼盘,还是号位楼盘
     * 4. 替换栋,单元,楼层,房间规则的id关联
     * 5. 更新FUN_BUILD_ROOFUNITDOORS表的数据统计
     * 6. 写入日志
     *
	 * @author czq
	 * @since 2018年12月13日
	 * @param param BuildIdParam
	 */
	@ApiOperation("系统模板应用到当前楼盘")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@NotBlank({"buildId"})
	@PostMapping("/copyTempBuildRule")
	@ResponseBody
	public ResponseJson copyTempBuildRule(@Valid @RequestBody CopyTempParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer provenceId = operator.getProvinceId();
		String compNo = operator.getCompNo();
		erpBuildingSetService.copyTempBuildRule(param, cityId, compId, userId, compNo, provenceId);
		return ErpResponseJson.ok();
	}

	/**
     * 添加楼盘栋座信息(解析是单个添加还是批量添加, 在栋座表中插入相应条数的数据, 将添加的栋座id异步处理)
     *
     * 1. 解析出批量或者单个添加的栋座,以及栋座下的单元
     *   1.1 已有1栋1到3单元,新添规则1栋2到4单元,存在2单元和3单元的重复,抛出重复异常
     * 2. 检查栋是否已存在
     *   2.1 栋在此楼盘已经存在
     *      2.1.1 已有1栋1到3单元,新添规则1栋4到6单元,不存在重复,更新栋表中单元相关的规则,并发送给task那边处理
     *   2.2 栋在此楼盘不存在
     *      2.2.1 直接写入栋表信息,并发送给task那边处理
     * 3. 修改维护人信息
     * 4. 写入添加栋座的日志
	 *
	 * @author czq
	 * @since 2018年12月11日
	 * @param param ErpBuildingSetRoofAddParam
	 */
	@ApiOperation("添加楼盘栋座信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/addBuildRoof")
	@ResponseBody
	public ResponseJson addBuildRoof(@Valid @RequestBody ErpBuildingSetRoofAddParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        Integer provinceId = operator.getProvinceId();
        String compNo = operator.getCompNo();
        String unitIds = erpBuildingSetRoofService.addBuildRoof(param, cityId, compId, userId, provinceId, compNo);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(cityId, 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
	}

	/**
	 * 编辑栋座信息(只修改基础信息)
	 *
	 * 1. 查看传入的栋座名称是否已经存在于栋座表中(判重)
	 * 2. 修改栋座信息
     * 3. 修改维护人信息
     * 4. 栋座名修改
     *    4.1 更新下面的房间的md5
	 *    4.2 更新 BUILDING_SET_UNIT(单元表)中 BUILD_ROOF 字段
	 *    4.3 更新 BUILDING_SET_FLOOR(楼层表)中 BUILD_ROOF 字段
	 *    4.4 更新 BUILDING_SET_ROOM(房间表)中 BUILD_ROOF 字段
	 * 6. BuildingSetLog 写入栋座修改信息
	 *
	 * @author czq
	 * @since 2018年12月11日
	 * @param param ErpBuildingSetRoofUpdateParam
	 */
	@ApiOperation("编辑楼盘栋座信息(只修改基础信息)")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/updateBuildRoof")
	@ResponseBody
	public ResponseJson updateBuildRoof(@Valid @RequestBody ErpBuildingSetRoofUpdateParam param) {
		erpBuildingSetRoofService.updateBuildingSetRoof(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
		return ErpResponseJson.ok();
	}

	/**
	 * 删除栋座
	 *
	 * 1. 删除栋表中该栋的数据
	 * 2. 删除该栋中的单元
	 * 3. 删除该栋中的楼层
	 * 4. 删除该栋中的房间
     * 5. 删除该栋房间所对应的户型图
     * 6. FunBuildRoofunitdoors 表修改栋数,单元数,户数
	 * 7. 写入删除栋座的日志
	 *
	 * @author czq
	 * @since 2018年12月11日
	 * @param param ErpBuildingSetRoofIdParam
	 */
	@NotBlank({"buildingSetRoofId"})
	@ApiOperation("删除栋座")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/delBuildRoofById")
	@ResponseBody
	public ResponseJson delBuildRoofById(@Valid @RequestBody ErpBuildingSetRoofIdParam param) {
		erpBuildingSetRoofService.delBuildRoofById(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
		return ErpResponseJson.ok();
	}

	/**
	 * 获取房间详情(包含基础信息+图片)
     * 1. 获取房间详细信息
     * 2. 获取户型图列表
     * 3. 组装Vo
	 *
	 * @author czq
	 * @since 2018年12月11日
	 * @param param ErpBuildingSetRoomIdParam
	 */
	@NotBlank({"buildingSetRoomId"})
	@ApiOperation("获取房间详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpBuildingSetRoomDetailsVo.class, message = "成功")
	})
	@PostMapping("/getBuildRoomDetails")
	@ResponseBody
	public ResponseJson getBuildRoomDetails(@Valid @RequestBody ErpBuildingSetRoomIdParam param) {
	    Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        ErpBuildingSetRoomDetailsVo roomDetailsVo = erpBuildingSetRoomMapper.getBuildRoomDetailsVo(cityId,
                param.getBuildId(), param.getBuildingSetRoomId(), 0);

        List<ErpBuildingSetRoomLayoutVo> roomLayoutVos = erpBuildingSetRoomLayoutMapper.selectRoomLayoutListVo(cityId,
                param.getBuildId(), param.getBuildingSetRoomId(), 0);

        if (roomLayoutVos != null && roomLayoutVos.size() > 0) {
            String photoUrls = String.join(",", roomLayoutVos.stream()
                    .map(it -> !it.getLayoutUrl().contains(AppConfig.getPicDomainUrl()) ?
                            AppConfig.getPicDomainUrl() + it.getLayoutUrl() : it.getLayoutUrl()).collect(Collectors.toList()));
            roomDetailsVo.setPhotoUrls(photoUrls);
        }

		return ErpResponseJson.ok(roomDetailsVo);
	}

	/**
	 * 单独添加房间(包含基础信息+图片)
     *
     * 1. 判断将房间户型,建筑面积,套内面积,朝向应用到本栋本单元同房号
     *   1.1 应用：修改本栋本单元同房号的户型,建筑面积,套内面积,朝向
     * 2. 后端计算该房间的 sysRoomId
     * 3. 添加房间信息
     * 4. 本房间添加户型图
     * 5. 判断是否修改本栋本单元同房号的户型图
     * 6. 栋表添加户数1
     * 7. 单元表户数加1
     * 8. FUN_BUILD_ROOFUNITDOORS 表中户数加1
     * 9. 写入添加房间日志
     *
	 * @author czq
	 * @since 2018年12月11日
	 * @param param BuildingSetRoomParam
	 */
	@ApiOperation("单独添加房间")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/addBuildRoom")
	@ResponseBody
	public ResponseJson addBuildRoom(@Valid @RequestBody BuildingSetRoomParam param) {
	    erpBuildingSetRoomService.addBuildRoom(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
		return ErpResponseJson.ok();
	}

    /**
     * 删除房间
     *
     * 1. 删除单个或者本行或者本列房间
     * 2. 删除房间对应的户型图
     * 3. 减少栋表中的户数
     * 4. 减少单元表户数
     * 5. 减少FUN_BUILD_ROOFUNITDOORS 表中户数
     * 6. 写入删除房间日志
     *
     * @author czq
     * @since 2018年12月11日
     * @param param RoomIdsParam
     */
    @NotBlank({"buildingSetUnitId", "buildId"})
    @ApiOperation("删除单个或者本行或者本列的房间")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/deleteRoom")
    @ResponseBody
    public ResponseJson deleteRoom(@Valid @RequestBody RoomIdsParam param) {
        erpBuildingSetRoomService.deleteRoom(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
        return ErpResponseJson.ok();
    }

	/**
	 * 添加单元或者号位(解析是单个添加还是批量添加, 在单元表中插入相应条数的数据, 将添加的单元id提交给兴哥那边异步处理房间) todo
	 * 单元名为空则为批量添加
     *
     * 1. 解析出批量或者单个添加的单元
     *   1.1 已有1栋1到3单元,新添规则1栋2到4单元,存在2单元和3单元的重复,抛出重复异常
     *   1.2 添加单个单元,将单元id放入kafka
     * 2. 解析要添加的单元, ["1单元", "2单元", "3单元"]并判重
     * 2  多个添加,直接写入单元表信息,将单元ids放入kafka
     * 3. 写入添加单元的日志
     *
	 * @author czq
	 * @since 2018年12月12日
	 * @param param ErpBuildingSetUnitAddParam
	 */
	@ApiOperation("添加单元或者号位")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/addBuildUnit")
	@ResponseBody
	public ResponseJson addBuildUnit(@Valid @RequestBody ErpBuildingSetUnitAddParam param) {
	    String unitIds = erpBuildingSetUnitService.addBuildUnit(param, getOperator().getCityId(), getOperator().getCompId(),
                getOperator().getUserId(), getOperator().getProvinceId(), getOperator().getCompNo());

        // 将生成的单元id放入 kafka
        KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
		return ErpResponseJson.ok();
	}

	/**
	 * 删除单元或者号位
     * 1. 删除单元
     * 2. 删除楼层
     * 3. 删除房间
     * 4. 减少栋表中单元的数量
     * 5. 统计房间数,减少栋表中户数
     * 6. 减少FUN_BUILD_ROOFUNITDOORS 表中户数单元数
     * 7. 写入删除单元日志
	 *
	 * @author czq
	 * @since 2018年12月12日
	 * @param param ErpBuildingSetUnitIdParam
	 */
	@NotBlank({"buildingSetUnitId"})
	@ApiOperation("删除单元或者号位")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/delBuildUnitById")
	@ResponseBody
	public ResponseJson delBuildUnitById(@Valid @RequestBody ErpBuildingSetUnitIdParam param) {
	    erpBuildingSetUnitService.delBuildUnit(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
		return ErpResponseJson.ok();
	}

	/**
	 * 编辑单元或者号位
     *
     * 1. 修改单元信息,单元名称,梯户,楼层
     * 2. 查看排号规则
     *    2.1 单元排号 清空以前的规则重新生成
     *       2.1.1 将该公司该楼盘该栋该单元所有楼层规则软删除
     *       2.1.2 将该公司该楼盘该栋该单元所有房间规则软删除
     *       2.1.3 将生成的单元id放入kafka,然后程序结束
     *    2.2 楼层排号 少了的补上,多余的删除
     *       2.2.1 找出已经存在的房间和楼层,计算新的要添加的列表
     *       2.2.2 如果单元名修改,则修改重合部分房间的Md5,修改楼层表中单元名称信息,修改房间表中单元名称信息
     *       2.2.3 删除多余的房间,删除多余的楼层,添加新的需要增加的楼层,添加新的需要添加的房间
     *       2.2.4 新添加的房间关联楼层
     *       2.2.5 修改单元表中的户数,修改栋表中的户数单元数,修改 FUN_BUILD_ROOFUNITDOORS 表户数单元数
     *       2.2.6 写入修改单元或者号位的日志
	 *
	 * @author czq
	 * @since 2018年12月12日
	 * @param param ErpBuildingSetUnitParam
	 */
	@ApiOperation("编辑单元或者号位")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/updateBuildUnit")
	@ResponseBody
	public ResponseJson updateBuildUnit(@Valid @RequestBody ErpBuildingSetUnitParam param) {
        String unitIds = erpBuildingSetUnitService.updateBuildUnit(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());

        if (unitIds.length() > 0) {
            // 将生成的单元id放入 kafka
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

		return ErpResponseJson.ok();
	}

	/**
	 * 编辑楼层信息
     *
     * 1. 如果是新的要修改的这个楼层,名称以及用途和以前的用户输入的名称,用途一样,则直接返回不做操作
     * 2. 如果同单元存在同样的楼层名则提示楼层名重复错误
     * 3. 编辑楼层信息
     * 4. 如果楼层名字修改(修改楼层下的房间的MD5)
     * 5. 写入编辑楼层信息日志
	 *
	 * @author czq
	 * @since 2018年12月12日
	 * @param param BuildingSetFloorParam
	 */
	@ApiOperation("编辑楼层信息")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/updateBuildFloor")
	@ResponseBody
	public ResponseJson updateBuildFloor(@Valid @RequestBody BuildingSetFloorParam param) {
		erpBuildingSetFloorService.updateBuildFloor(param, getOperator().getCityId(), getOperator().getCompId(), getOperator().getUserId());
		return ErpResponseJson.ok();
	}

    /**
     * 清空楼盘规则
     *
     * 1. 软删除栋,单元,楼层,房间数据
     * 2. FUN_BUILD_ROOFUNITDOORS 统计数清0
     *
     * @author czq
     * @since 2018年12月20日
     * @param param BuildingSetFloorParam
     */
    @ApiOperation("清空楼盘规则")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    @PostMapping("/delBuildRuleById")
    @ResponseBody
    public ResponseJson delBuildRuleById(@Valid @RequestBody BuildIdParam param) {
        erpBuildingSetRoofService.delBuildRuleById(getOperator().getCityId(), getOperator().getCompId(), param.getBuildId(), getOperator().getUserId());
        return ErpResponseJson.ok();
    }

    /**
     * 获取楼盘规则列表
     *
     * @param param buildId 楼盘ID isLock 规则是否锁定
     * @return
     * @throws Exception
     * @author 黄建海
     * @since 2018年12月13日
     */
    @ApiOperation(value = "获取楼盘规则列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", response = ErpRegisterBuildingRuleListVO.class)
    })
    @PostMapping(value = "/getBuildingRuleList")
    @ResponseBody
    public ResponseJson getBuildingRuleList(@Valid @RequestBody ErpRegisterBuildingSetRoofparam param) {
        ErpRegisterBuildingRuleListVO buildingRuleListVO = new ErpRegisterBuildingRuleListVO();
        Operator operator = getOperator();
        Integer buildId = param.getBuildId();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer houseUseage = param.getHouseUseage();

        // 指定要锁定的，未锁定直接返回
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(getOperator().getCityId(),0, buildId);
        int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
        if (buildLock != 1) {
            return ErpResponseJson.ok(buildingRuleListVO);
        }
        //从小往大找
        List<ErpBuildingSetFloor> erpBuildingSetFloorList = erpBuildingSetFloorMapper.selectByHouseUseage(getOperator().getCityId(), 0, buildId, houseUseage);
        if (erpBuildingSetFloorList != null && erpBuildingSetFloorList.size() > 0) {
            Set<Integer> unitIds = erpBuildingSetFloorList.stream().map(ErpBuildingSetFloor::getBuildingSetUnitId).collect(Collectors.toSet());
            //当单元大于2000个时，现在房子不要钱，修得多
            int delBaseCount = 200;
            List<ErpRegisterBuildingSetUnitVO> erpBuildingSetUnitList = new ArrayList<>();
            if (unitIds.size() > 0) {
                for (int k = 0; k < unitIds.size(); k += delBaseCount) {
                    List<Integer> current = unitIds.stream().skip(k).limit(delBaseCount).collect(Collectors.toList());
                    if (current.size() > 0) {
                        List<ErpRegisterBuildingSetUnitVO> erpBuildingSetUnitList1 = erpBuildingSetUnitMapper.selectByBuildIdAndUnitIds(cityId, 0, buildId, current);
                        List<ErpRegisterBuildingSetUnitVO> maxSysFloorInUnits = erpBuildingSetFloorMapper.selectMaxSysFloorInUnits(cityId, 0, buildId, current);
                        for (ErpRegisterBuildingSetUnitVO vo : erpBuildingSetUnitList1) {
                            Integer buildingSetUnitId = vo.getBuildingSetUnitId();
                            if (buildingSetUnitId != null) {
                                Optional<ErpRegisterBuildingSetUnitVO> optional = maxSysFloorInUnits.stream().filter(it -> it.getBuildingSetUnitId().equals(buildingSetUnitId)).findFirst();
                                if (optional.isPresent()) {
                                    ErpRegisterBuildingSetUnitVO max = optional.get();
                                    Integer floorEnd = max.getFloorEnd();
                                    Integer buildingSetUnitId1 = max.getBuildingSetUnitId();
                                    // 因为美联有些栋，只有地下的层数。后端做个兼容，如果只有地下的层数，那么就去最小的层数的绝对值。--yj
                                    if(floorEnd<0){
                                        List<ErpRegisterBuildingSetUnitVO> erpRegisterBuildingSetUnitVOS = erpBuildingSetFloorMapper.selectMinSysFloorInUnits(cityId, 0, buildId, buildingSetUnitId1);
                                        if(erpRegisterBuildingSetUnitVOS!=null&&erpRegisterBuildingSetUnitVOS.size()>0){
                                            Integer floorEnd1 = erpRegisterBuildingSetUnitVOS.get(0).getFloorEnd();
                                            vo.setFloorEnd(Math.abs(floorEnd1));
                                        }
                                    }else{
                                        vo.setFloorEnd(floorEnd);
                                    }
                                }
                            }
                        }
                        erpBuildingSetUnitList.addAll(erpBuildingSetUnitList1);
                    }
                }
            }
            if (CollectionUtils.isNotEmpty(erpBuildingSetUnitList)) {
                erpBuildingSetUnitList.forEach(v->{ v.setBuildUnit(v.getBuildUnit().toUpperCase()); });
            }
            buildingRuleListVO.setBuildingSetUnitList(erpBuildingSetUnitList);

            //上海号室的没有栋座
            String core_info_type = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");
            if (!"2".equals(core_info_type)) {
                Set<Integer> roofIds = erpBuildingSetUnitList.stream().filter(it -> it.getBuildingSetRoofId() != null).map(ErpRegisterBuildingSetUnitVO::getBuildingSetRoofId).collect(Collectors.toSet());
                List<ErpRegisterBuildingSetRoofVO> erpBuildingSetRoofList = new ArrayList<>();
                //现在房子不要钱，修得多
                if (roofIds.size() > 0) {
                    for (int k = 0; k < roofIds.size(); k += delBaseCount) {
                        List<Integer> current = roofIds.stream().skip(k).limit(delBaseCount).collect(Collectors.toList());
                        if (current.size() > 0) {
                            List<ErpRegisterBuildingSetRoofVO> roofList = erpBuildingSetRoofMapper.selectRegisterByBuildId(cityId, 0, buildId, current);
                            erpBuildingSetRoofList.addAll(roofList);
                        }
                    }
                }

                if (CollectionUtils.isNotEmpty(erpBuildingSetRoofList)) {
                    erpBuildingSetRoofList.forEach(v->{ v.setBuildRoof(v.getBuildRoof().toUpperCase()); });
                }
                buildingRuleListVO.setBuildingSetRoofList(erpBuildingSetRoofList);
            }
        }
        return ErpResponseJson.ok(buildingRuleListVO);
    }

    /**
     * 房源登记中通过栋座,单元获取楼层房间列表 todo
     *
     * @param param ErpBuildingSetRoomParam
     * @author 黄建海
     * @since 2018年12月14日
     */
    @ApiOperation(value = "房源登记中通过栋座,单元获取楼层房间列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", response = ErpRegisterBuildFloorListVO.class)
    })
    @PostMapping(value = "/getBuildFloorAndRoomList")
    @ResponseBody
    public ResponseJson getBuildFloorAndRoomList(@Valid @RequestBody ErpRegisterBuildingSetFloorAndRoomparam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Map<String, String> result = new HashMap<>();
        result.put("data", "");
        Integer buildId = param.getBuildId();
        Integer buildingSetRoofId = param.getBuildingSetRoofId();
        Integer buildingSetUnitId = param.getBuildingSetUnitId();
        Integer floorUseage = param.getFloorUseage();
        ErpRegisterBuildFloorListVO erpRegisterBuildFloorListVO = new ErpRegisterBuildFloorListVO();
        //根据楼栋和单元查询楼层
        List<ErpRegisterBuildFloorAndRoomListVO> erpRegisterBuildFloorListVOS = new ArrayList<>();
        List<Integer> floorIds = new ArrayList<>();
        List<ErpRegisterBuildFloorAndRoomListVO> erpBuildingSetFloorList = erpBuildingSetFloorMapper.selectByBuildAndBuildRoofAndBuildUnit(cityId, compId, buildId, buildingSetRoofId, buildingSetUnitId, floorUseage);
        if (erpBuildingSetFloorList.size() <= 0) {
            return ErpResponseJson.ok(result);
        }
        for (ErpRegisterBuildFloorAndRoomListVO erpRegisterBuildFloorAndRoomListVO : erpBuildingSetFloorList) {
            floorIds.add(erpRegisterBuildFloorAndRoomListVO.getBuildingSetFloorId());
        }
        Map<Integer, ErpRegisterBuildFloorAndRoomListVO> floorMap = erpBuildingSetFloorList.stream().collect(Collectors.toMap(ErpRegisterBuildFloorAndRoomListVO::getBuildingSetFloorId, account -> account));
        //现在房子不要钱，修得多
        int delBaseCount = 1000;
        List<ErpRegisterBuildingSetRoomVO> erpBuildingSetRoomList=new ArrayList<>();
        if (floorIds.size() > 0) {
            for (int k = 0; k < floorIds.size(); k += delBaseCount) {
                List<Integer> current = floorIds.stream().skip(k).limit(delBaseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    List<ErpRegisterBuildingSetRoomVO> erpBuildingSetUnitList1 = erpBuildingSetRoomMapper.selectByBuildIdAndFloorIds(cityId, compId, buildId, current);
                    erpBuildingSetRoomList.addAll(erpBuildingSetUnitList1);
                }
            }
        }
        //查出最新修改的时间

        if (erpBuildingSetRoomList.size() <= 0) {
            return ErpResponseJson.ok(result);
        }
        //处理合并房间
        Map<Integer,List<ErpRegisterBuildingSetRoomVO>> mergeRooms = erpBuildingSetRoomList.stream().filter(it -> it.getMergeRoom() != null).collect(Collectors.groupingBy(ErpRegisterBuildingSetRoomVO::getMergeRoom));
        if (!mergeRooms.isEmpty()) {
            Set<Integer> ergeRooms = mergeRooms.keySet();
            ergeRooms.forEach(v -> {
                List<ErpRegisterBuildingSetRoomVO> rooms = mergeRooms.get(v);
                String roomId = rooms.stream().collect(Collectors.mapping(t -> t.getRoomId(), Collectors.joining(",")));
                String sysRoomId = rooms.stream().collect(Collectors.mapping(t -> t.getSysRoomId(), Collectors.joining(",")));
                ErpRegisterBuildingSetRoomVO modelRoom = rooms.get(0);
                for(ErpRegisterBuildingSetRoomVO vo : erpBuildingSetRoomList){
                    if(vo.getMergeRoom() != null && vo.getMergeRoom().equals(v)){
                        vo.setRoomId(roomId);
                        vo.setSysRoomId(sysRoomId);
                        vo.setHouseHall(modelRoom.getHouseHall());
                        vo.setHouseArea(modelRoom.getHouseArea());
                        vo.setHouseRoom(modelRoom.getHouseRoom());
                        vo.setHouseWei(modelRoom.getHouseWei());
                        vo.setHouseYang(modelRoom.getHouseYang());
                        vo.setHouseInnerarea(modelRoom.getHouseInnerarea());
                    }
                }
            });
        }

        Set<Integer> roomSet = erpBuildingSetRoomList.stream().map(ErpRegisterBuildingSetRoomVO::getBuildingSetFloorId).collect(Collectors.toSet());
        for (Integer str : roomSet) {
            if (floorMap.containsKey(str)) {
                ErpRegisterBuildFloorAndRoomListVO erpRegisterBuildFloorAndRoomListVO = floorMap.get(str);
                erpRegisterBuildFloorAndRoomListVO.setBuildFloor(erpRegisterBuildFloorAndRoomListVO.getBuildFloor().toUpperCase());
                erpRegisterBuildFloorListVOS.add(erpRegisterBuildFloorAndRoomListVO);
            }
        }
        //对楼层进行排序
        erpRegisterBuildFloorListVOS.sort((a, b) -> StringUtil.parseInteger(a.getSysBuildFloor()) - StringUtil.parseInteger(b.getSysBuildFloor()));
        erpRegisterBuildFloorListVO.setBuildFloorList(erpRegisterBuildFloorListVOS);
        erpRegisterBuildFloorListVO.setBuildingSetRoomList(erpBuildingSetRoomList);
        return ErpResponseJson.ok(erpRegisterBuildFloorListVO);
    }


    /**
     * 房源登记中通过栋座,单元获取楼层房间列表 --美联todo
     *
     * @param param ErpBuildingSetRoomParam
     * @author 黄建海
     * @since 2018年12月14日
     */
    @ApiOperation(value = "房源登记中通过栋座,单元获取楼层房间列表--美联")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", response = ErpRegisterBuildFloorListVO.class)
    })
    @PostMapping(value = "/getMLBuildFloorAndRoomList")
    @ResponseBody
    public ResponseJson getMLBuildFloorAndRoomList(@Valid @RequestBody MLErpRegisterBuildingSetFloorAndRoomparam param) {
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer userOrgId = operator.getOrganizationId();
        ErpFunOrganization userOrg = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, userOrgId);
        // 用户的类型 0=初始  1=住宅 2=工商铺 3=后勤部门
        Byte userBussinessType = userOrg.getOrganizationBussinessType();

        Map<String, String> result = new HashMap<>();
        result.put("data", "");
        Integer buildId = param.getBuildId();
        Integer buildingSetRoofId = param.getBuildingSetRoofId();
        Integer buildingSetUnitId = param.getBuildingSetUnitId();
        Integer floorUseage = param.getFloorUseage();
        MLErpRegisterBuildFloorListVO erpRegisterBuildFloorListVO = new MLErpRegisterBuildFloorListVO();
        //根据楼栋和单元查询楼层
        List<MLErpRegisterBuildFloorAndRoomListVO> erpRegisterBuildFloorListVOS = new ArrayList<>();
        List<Integer> floorIds = new ArrayList<>();
        List<MLErpRegisterBuildFloorAndRoomListVO> erpBuildingSetFloorList = erpBuildingSetFloorMapper.selectByBuildAndBuildRoofAndBuildUnitML(cityId, 0, buildId, buildingSetRoofId, buildingSetUnitId, floorUseage);
        if (erpBuildingSetFloorList.size() <= 0) {
            return ErpResponseJson.ok(result);
        }
        for (MLErpRegisterBuildFloorAndRoomListVO erpRegisterBuildFloorAndRoomListVO : erpBuildingSetFloorList) {
            floorIds.add(erpRegisterBuildFloorAndRoomListVO.getBuildingSetFloorId());
        }
        Map<Integer, MLErpRegisterBuildFloorAndRoomListVO> floorMap = erpBuildingSetFloorList.stream().collect(Collectors.toMap(MLErpRegisterBuildFloorAndRoomListVO::getBuildingSetFloorId, account -> account));
        //查询房间
        LinkedList<MLErpRegisterBuildingSetRoomVO> buildingSetRoomList = new LinkedList<>();
        //现在房子不要钱，修得多
        int delBaseCount = 1000;
        List<MLErpRegisterBuildingSetRoomVO> erpBuildingSetRoomList=new ArrayList<>();
        if (floorIds.size() > 0) {
            for (int k = 0; k < floorIds.size(); k += delBaseCount) {
                List<Integer> current = floorIds.stream().skip(k).limit(delBaseCount).collect(Collectors.toList());
                if (current.size() > 0) {
                    List<MLErpRegisterBuildingSetRoomVO> erpBuildingSetUnitList1 = erpBuildingSetRoomMapper.selectByBuildIdAndFloorIdsML(cityId, 0, buildId, current);
                    erpBuildingSetRoomList.addAll(erpBuildingSetUnitList1);
                }
            }
        }
        //查出最新修改的时间

        if (erpBuildingSetRoomList.size() <= 0) {
            return ErpResponseJson.ok(result);
        }
        Map<Integer, MLErpRegisterBuildingSetRoomVO> map = new HashMap<>();
        Map<Integer, String> roomIds = new HashMap<>();
        Map<Integer, String> sysRoomIds = new HashMap<>();
        Map<Integer, BigDecimal> houseAreas = new HashMap<>();
        Map<Integer, BigDecimal> houseInnerAreas = new HashMap<>();
        Set<Integer> roomSet = erpBuildingSetRoomList.stream().map(MLErpRegisterBuildingSetRoomVO::getBuildingSetFloorId).collect(Collectors.toSet());
        for (MLErpRegisterBuildingSetRoomVO erpRegisterBuildingSetRoomVO : erpBuildingSetRoomList) {
            List<ErpRegisterBuildingSetRoomVO> voList = new ArrayList<>();
            if (!map.containsKey(erpRegisterBuildingSetRoomVO.getBuildingSetRoomId())) {
                //处理合并房间
                if (erpRegisterBuildingSetRoomVO.getMergeRoom() != null) {
                    //找出房间标识一样的房间
                    List<MLErpRegisterBuildingSetRoomVO> erpRegisterBuildingSetRoomVOS = erpBuildingSetRoomList.stream().filter(it -> it.getMergeRoom() == (erpRegisterBuildingSetRoomVO.getMergeRoom())).collect(Collectors.toList());
//
//                    Optional<ErpRegisterBuildingSetRoomVO> results=erpRegisterBuildingSetRoomVOS.stream().max(ErpRegisterBuildingSetRoomVO::compareTo);
//                    ErpRegisterBuildingSetRoomVO resultVo=results.get();
                    voList = erpRegisterBuildingSetRoomVOS.stream()
                            .filter(it -> it.getUpdateTime() != null).sorted((val1, val2) -> val2.getUpdateTime().compareTo(val1.getUpdateTime()))
                            .collect(Collectors.toList());
                    String roomId = "";
                    String sysRoomId = "";
                    BigDecimal houseArea = new BigDecimal(0);
                    BigDecimal houseInnerArea = new BigDecimal(0);
                    for (MLErpRegisterBuildingSetRoomVO change : erpRegisterBuildingSetRoomVOS) {
                        if (erpRegisterBuildingSetRoomVO.getRoomId().equals(change.getRoomId())) {
                            roomId = roomId + change.getRoomId() + ",";
                            sysRoomId = sysRoomId + change.getSysRoomId() + ",";
                            houseArea = new BigDecimal(houseArea.intValue() + (change.getHouseArea() != null? change.getHouseArea().intValue():0));
                            houseInnerArea = new BigDecimal(houseInnerArea.intValue() + (change.getHouseInnerarea() != null? change.getHouseInnerarea().intValue():0));
                            continue;
                        }
                        roomId = roomId + change.getRoomId() + ",";
                        sysRoomId = sysRoomId + change.getSysRoomId() + ",";
                        houseArea = new BigDecimal(houseArea.intValue() + (change.getHouseArea() != null? change.getHouseArea().intValue():0));
                        houseInnerArea = new BigDecimal(houseInnerArea.intValue() + (change.getHouseInnerarea() != null? change.getHouseInnerarea().intValue():0));
                        if (erpRegisterBuildingSetRoomVO.getRoomFloor() == change.getRoomFloor()) {
                            map.put(change.getBuildingSetRoomId(), change);
                        }
                    }


                    roomId = roomId.substring(0, roomId.lastIndexOf(","));
                    sysRoomId = sysRoomId.substring(0,sysRoomId.lastIndexOf(","));
                    if (roomIds.containsKey(erpRegisterBuildingSetRoomVO.getMergeRoom())) {
                        erpRegisterBuildingSetRoomVO.setRoomId(roomIds.get(erpRegisterBuildingSetRoomVO.getMergeRoom()));
                        erpRegisterBuildingSetRoomVO.setSysRoomId(sysRoomIds.get(erpRegisterBuildingSetRoomVO.getMergeRoom()));
                        erpRegisterBuildingSetRoomVO.setHouseArea(houseAreas.get(erpRegisterBuildingSetRoomVO.getMergeRoom()));
                        erpRegisterBuildingSetRoomVO.setHouseInnerarea(houseInnerAreas.get(erpRegisterBuildingSetRoomVO.getMergeRoom()));
                    } else {
                        erpRegisterBuildingSetRoomVO.setRoomId(roomId);
                        erpRegisterBuildingSetRoomVO.setSysRoomId(sysRoomId);
                        erpRegisterBuildingSetRoomVO.setHouseArea(houseArea);
                        erpRegisterBuildingSetRoomVO.setHouseInnerarea(houseInnerArea);

                        sysRoomIds.put(erpRegisterBuildingSetRoomVO.getMergeRoom(),sysRoomId);
                        roomIds.put(erpRegisterBuildingSetRoomVO.getMergeRoom(), roomId);
                        houseAreas.put(erpRegisterBuildingSetRoomVO.getMergeRoom(), houseArea);
                        houseInnerAreas.put(erpRegisterBuildingSetRoomVO.getMergeRoom(), houseInnerArea);
                    }

                    erpRegisterBuildingSetRoomVO.setRoomId(erpRegisterBuildingSetRoomVO.getRoomId().toUpperCase());
                }
                if (voList != null && voList.size() > 0) {
                    ErpRegisterBuildingSetRoomVO erpRegisterBuildingSetRoomVO1 = voList.get(0);
                    erpRegisterBuildingSetRoomVO.setHouseHall(erpRegisterBuildingSetRoomVO1.getHouseHall());
                    //erpRegisterBuildingSetRoomVO.setHouseArea(erpRegisterBuildingSetRoomVO1.getHouseArea());
                    erpRegisterBuildingSetRoomVO.setHouseRoom(erpRegisterBuildingSetRoomVO1.getHouseRoom());
                    erpRegisterBuildingSetRoomVO.setKitchen(erpRegisterBuildingSetRoomVO1.getKitchen());
                    erpRegisterBuildingSetRoomVO.setHouseWei(erpRegisterBuildingSetRoomVO1.getHouseWei());
                    erpRegisterBuildingSetRoomVO.setHouseYang(erpRegisterBuildingSetRoomVO1.getHouseYang());
                    //erpRegisterBuildingSetRoomVO.setHouseInnerarea(erpRegisterBuildingSetRoomVO1.getHouseInnerarea());
                }
                buildingSetRoomList.add(erpRegisterBuildingSetRoomVO);
            }

        }

        List<Integer> typeOrgIds = new ArrayList<>();
        // 住宅 工商铺分开判重
        if (userBussinessType == 1 || userBussinessType == 2) {
            ErpFunOrganizationExample organizationExample = new ErpFunOrganizationExample();
            organizationExample.setShardCityId(cityId);
            organizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationBussinessTypeEqualTo(userBussinessType).andDelFlagEqualTo((byte) 0);
            List<ErpFunOrganization> typeOrgs = erpFunOrganizationMapper.selectByExample(organizationExample);
            typeOrgIds = typeOrgs.stream().filter(it -> it.getOrganizationId() != null).map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
        }
        List<Integer> finalTypeOrgIds = typeOrgIds;

        for (Integer str : roomSet) {
            if (floorMap.containsKey(str)) {
                MLErpRegisterBuildFloorAndRoomListVO erpRegisterBuildFloorAndRoomListVO = floorMap.get(str);
                erpRegisterBuildFloorAndRoomListVO.setBuildFloor(erpRegisterBuildFloorAndRoomListVO.getBuildFloor().toUpperCase());
                erpRegisterBuildFloorListVOS.add(erpRegisterBuildFloorAndRoomListVO);
            }
        }
        //增加每一层是否被注册过整层，以及，每个房间是否被注册过
        Set<String> wholeLayerRoof = new HashSet<>();
        Map<String, List<ErpFunSale>> floorNumMapSale = new HashMap<>();
        Map<String, List<ErpFunLease>> floorNumMapLease = new HashMap<>();
        if(Byte.valueOf("1").equals(param.getCaseType())){
            //获取房源
            ErpFunSaleExample funSaleExampleForNum = new ErpFunSaleExample();
            funSaleExampleForNum.setShardCityId(cityId);
            funSaleExampleForNum.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andSaleRoofTEqualTo(erpBuildingSetFloorList.get(0).getBuildRoof().toUpperCase())
                    .andSaleUnitTEqualTo(erpBuildingSetFloorList.get(0).getBuildUnit().toUpperCase()).andUnitFloorIsNotNull();
            List<ErpFunSale> erpFunSalesForNum = erpFunSaleMapper.selectByExample(funSaleExampleForNum);
            if (userBussinessType == 1 || userBussinessType == 2) {
                erpFunSalesForNum = erpFunSalesForNum.stream().filter(it -> finalTypeOrgIds.contains(it.getOrganizationId())).collect(Collectors.toList());
            }
            //房源楼层解密
//            erpFunSalesForNum.stream().forEach(o->{
//                if(o.getUnitFloorR() != null){
//                    o.setSaleFloor(Short.valueOf(EnCodeHelper.decode(o.getUnitFloorR()))
//                    );
//                }
//            });
            wholeLayerRoof.addAll(erpFunSalesForNum.stream().filter(o -> Byte.valueOf("1").equals(o.getMlWholeLayer()) && (!o.getSaleId().equals(param.getCaseId()))).map(ErpFunSale::getUnitFloor).collect(Collectors.toSet()));
            floorNumMapSale .putAll(erpFunSalesForNum.stream().filter(o -> Byte.valueOf("0").equals(o.getMlWholeLayer()) && (!o.getSaleId().equals(param.getCaseId()))).collect(Collectors.groupingBy(ErpFunSale::getUnitFloor)));
        }else if(Byte.valueOf("2").equals(param.getCaseType()) && Byte.valueOf("1").equals(param.getLessor())){
            //获取房源
            ErpFunLeaseExample funLeaseExampleForNum = new ErpFunLeaseExample();
            funLeaseExampleForNum.setShardCityId(cityId);
            funLeaseExampleForNum.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andLeaseRoofTEqualTo(erpBuildingSetFloorList.get(0).getBuildRoof().toUpperCase())
                    .andLeaseUnitTEqualTo(erpBuildingSetFloorList.get(0).getBuildUnit().toUpperCase()).andLessorEqualTo((byte)1).andUnitFloorIsNotNull();
            List<ErpFunLease> erpFunLeasesForNum = erpFunLeaseMapper.selectByExample(funLeaseExampleForNum);
            if (userBussinessType == 1 || userBussinessType == 2) {
                erpFunLeasesForNum = erpFunLeasesForNum.stream().filter(it -> finalTypeOrgIds.contains(it.getOrganizationId())).collect(Collectors.toList());
            }
            //房源楼层解密
//            erpFunLeasesForNum.stream().forEach(o->{
//                if(o.getUnitFloorR() != null){
//                    o.setLeaseFloor(Short.valueOf(EnCodeHelper.decode(o.getUnitFloorR()))
//                    );
//                }
//            });
            wholeLayerRoof.addAll(erpFunLeasesForNum.stream().filter(o -> Byte.valueOf("1").equals(o.getMlWholeLayer()) && (!o.getLeaseId().equals(param.getCaseId()))).map(ErpFunLease::getUnitFloor).collect(Collectors.toSet()));
            floorNumMapLease .putAll(erpFunLeasesForNum.stream().filter(o -> Byte.valueOf("0").equals(o.getMlWholeLayer()) && (!o.getLeaseId().equals(param.getCaseId()))).collect(Collectors.groupingBy(ErpFunLease::getUnitFloor)));
        }
        //给每一层添加是否登记过整层标记
        erpRegisterBuildFloorListVOS.stream().forEach(o->{
            if(wholeLayerRoof.contains(o.getBuildFloor())){
                o.setMlWholeLayer((byte)1);
            }
        });
        //
        buildingSetRoomList.stream().forEach(o->{
            Set<String> roomNumList = new HashSet<>();
            Set<String> numsList = new HashSet<>();
            //获取所有的房间号到集合
            if(Byte.valueOf("1").equals(param.getCaseType())){
                if(floorNumMapSale.get(o.getRoomFloor()) != null){
                    numsList.addAll(floorNumMapSale.get(o.getRoomFloor()).stream().map(ErpFunSale::getSaleNumT).collect(Collectors.toSet()));
                }
            }else{
                if(floorNumMapLease.get(o.getRoomFloor()) != null) {
                    numsList.addAll(floorNumMapLease.get(o.getRoomFloor()).stream().map(ErpFunLease::getLeaseNumT).collect(Collectors.toSet()));
                }
            }
            //将所哟房间号拆开放到集合中去
            if(!numsList.isEmpty()){
                numsList.stream().forEach(var->{
                    roomNumList.addAll(Arrays.asList(var.replace(" ", "").split(",")));
                });
            }
            Arrays.asList(o.getRoomId().replace(" ","").split(",")).stream().forEach(obj->{
                if(roomNumList.contains(obj)){
                    o.setMlNumExist((byte)1);
                }
            });
        });
        erpRegisterBuildFloorListVOS.sort((a, b) -> StringUtil.parseInteger(a.getSysBuildFloor()) - StringUtil.parseInteger(b.getSysBuildFloor()));
        erpRegisterBuildFloorListVO.setBuildFloorList(erpRegisterBuildFloorListVOS);
        erpRegisterBuildFloorListVO.setBuildingSetRoomList(buildingSetRoomList);
        return ErpResponseJson.ok(erpRegisterBuildFloorListVO);
    }
    /**
     * 通过栋座,房间id获取户型图列表 todo
     *
     * @param param ErpBuildingSetRoomParam
     * @author 黄建海
     * @since 2018年12月14日
     */
    @ApiOperation(value = "通过栋座,房间id获取户型图列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", response = ErpRegisterBuildingSetRoomLaYouTListVO.class)
    })
    @PostMapping(value = "/getBuildingSetRoomLaYouTList")
    @ResponseBody
    public ResponseJson getBuildingSetRoomLaYouTList(@Valid @RequestBody ErpRegisterBuildingSetRoomLaYouTParam param) {
        Map<String, String> result = new HashMap<>();
        result.put("data", "");
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer buildId = param.getBuildId();
        Integer buildingSetRoomId = Integer.valueOf(param.getBuildingSetRoomId().split(",")[0]);
        //查询户型图
        List<ErpRegisterBuildingSetRoomLaYouTVO> erpBuildingSetRoomLayoutList = erpBuildingSetRoomLayoutMapper.selectByBuildIdAndBuildSetRoomId(cityId, compId, buildId, buildingSetRoomId);
        List<ErpRegisterBuildingSetRoomLaYouTVO> buildingSetRoomLaYouTList = new ArrayList<>();
        ErpRegisterBuildingSetRoomLaYouTListVO erpRegisterBuildingSetRoomLaYouTListVO = new ErpRegisterBuildingSetRoomLaYouTListVO();
        if (erpBuildingSetRoomLayoutList.size() > 0) {
            for (ErpRegisterBuildingSetRoomLaYouTVO erpRegisterBuildingSetRoomLaYouTVO : erpBuildingSetRoomLayoutList) {
                if (erpRegisterBuildingSetRoomLaYouTVO.getLaYouTUrl() != null) {
                    if(!erpRegisterBuildingSetRoomLaYouTVO.getLaYouTUrl().contains("http:")){
                        erpRegisterBuildingSetRoomLaYouTVO.setLaYouTUrl((AppConfig.getPicDomainUrl() + erpRegisterBuildingSetRoomLaYouTVO.getLaYouTUrl()).replaceAll("\\\\", "/"));
                    }
                }
                buildingSetRoomLaYouTList.add(erpRegisterBuildingSetRoomLaYouTVO);
            }
            erpRegisterBuildingSetRoomLaYouTListVO.setBuildingSetRoomLaYouTList(buildingSetRoomLaYouTList);
            return ErpResponseJson.ok(erpRegisterBuildingSetRoomLaYouTListVO);
        }
        return ErpResponseJson.ok(result);


    }
    /**
     * 楼盘锁定返回数据
     *
     * @param param ErpBuildingSetRoomParam
     * @author 黄建海
     * @since 2018年12月14日
     */
    @ApiOperation(value = "楼盘锁定返回数据")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功", response = ErpBuildingLockDataVO.class)
    })
    @PostMapping(value = "/getBuildingLockData")
    @ResponseBody
    public ResponseJson getBuildingLockData(@Valid @RequestBody ErpBuildingLockDataParam param) {
        Integer buildId = param.getBuildId();
        Integer status = 1;
        ErpBuildingLockDataVO erpBuildingLockDataVO = new ErpBuildingLockDataVO();
        if (getOperator().isMeiLianApi()) {
        	erpBuildingLockDataVO.setStatus(status);
            return ErpResponseJson.ok(erpBuildingLockDataVO);
    	}
        //判断该楼层是否锁定
        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(getOperator().getCityId(), getOperator().getCompId(), buildId);
        if (erpBuildingSetSetting == null || erpBuildingSetSetting.getBuildLock() == 0) {
            erpBuildingLockDataVO.setStatus(status);
            return ErpResponseJson.ok(erpBuildingLockDataVO);
        } else if (erpBuildingSetSetting != null && erpBuildingSetSetting.getBuildLock() == 1) {
            status = erpBuildingSetRoofService.getBuildingLockDate(getOperator().getCityId(), getOperator().getCompId(), param);
        }
        erpBuildingLockDataVO.setStatus(status);
        return ErpResponseJson.ok(erpBuildingLockDataVO);
    }



    // 普通栋座加密
    public static String encodeToMD5(Integer buildId, String roof, String unit, String floor, String num) {
        // 自建房、厂房、仓库、车库、商铺直接用楼盘名+地址生成MD5
        String enCodeStr;
        roof = null == roof ? "" : roof;
        unit = null == unit ? "" : unit;
        floor = null == floor ? "" : floor;
        num = null == num ? "" : num;

        unit = EnCodeHelper.encode(unit.toUpperCase());
        floor = EnCodeHelper.encode(floor.toUpperCase());
        num = EnCodeHelper.encode(num.toUpperCase());
        roof = EnCodeHelper.encode(roof.toUpperCase());

        enCodeStr = EnCodeHelper.ecodeByMD5(buildId + roof + "_" + unit + "_" + floor + "_" + num);
        return enCodeStr;
    }

	/*
     *
	 * 获取楼盘栋座列表
	 * 获取楼盘栋座列表(模板)
	 * 根据楼盘栋座获取单元列表
	 * 根据楼盘栋座获取单元列表(模板)
	 * 根据楼盘单元获取楼层列表
	 *
	 * 通过栋座,单元,楼层获取房间列表
	 * 通过栋座,单元,楼层获取房间列表(模板)
	 * 系统模板应用到当前楼盘
	 *
	 * 添加楼盘栋座信息
	 *      1. 解析是单个添加还是批量添加, 在栋座表中插入相应条数的数据, 将添加的栋座id异步处理房间
	 * 编辑楼盘栋座信息
	 *      1. 编辑栋/单元信息时，规则信息部分是不能修改的(只修改基础信息)
	 * 删除栋座
	 *
	 * 获取房间详情(包含基础信息+图片+业主信息+挂牌信息)
	 * 单独添加房间(包含基础信息+图片+业主信息+挂牌信息)
	 * 删除房间
	 * 删除本列房间
	 * 删除本行房间
	 * 合并房间
	 * 取消合并房间
	 * 编辑房间
	 *      1. 物业版编辑房间才有业主信息，在售和在租确认内成交或外成交
	 *      2. 楼盘编辑房间后，相应的数据修改后同步到房源后的是否写跟进？
	 *
	 * 添加单元
	 *      1. 解析是单个添加还是批量添加, 在单元表中插入相应条数的数据, 将添加的单元id异步处理房间
	 *      2. 单元名判重 私有云在楼盘锁定情况下，栋座单元号不进行数字和字母的转换。例如：1栋1单元1楼1号 = A栋A单元1楼1号
	 * 删除单元
	 * 编辑单元
	 *      1. 编辑栋/单元信息时，规则信息部分是不能修改的(只修改基础信息)
	 * 编辑楼层信息
	 * 获取楼层梯户等信息
	 *
	 * 楼盘锁定或者解锁
	 *
	 * */


	/*-------------------------------------------------------------------------------------------------------------*/


    @ApiOperation("首次创建楼盘规则")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/addBuildRule")
    @ResponseBody
    public ResponseJson addBuildRule(@Valid @RequestBody BuildRuleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetRoofService.addBuildRule(param, generalParam);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            System.out.println("unitIds : " + unitIds);
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("批量增加栋座")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/batchAddBuildRoof")
    @ResponseBody
    public ResponseJson batchAddBuildRoof(@Valid @RequestBody BuildRuleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetRoofService.batchAddBuildRoofV2(param, generalParam);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(),0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("删除楼盘")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/deleteBuildingInfo")
    @ResponseBody
    public ResponseJson deleteBuildingInfo(@Valid @RequestBody BuildingInfoDeleteParam param) {
        Integer buildId = param.getBuildId();
        Byte requestFor = param.getRequestFor();
        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();

        /*ErpBuildPermissionsExample buildPermissionExample = new ErpBuildPermissionsExample();
        buildPermissionExample.setShardCityId(cityId);
        buildPermissionExample.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(compId);
        Integer buildPermissionCount = erpBuildPermissionsMapper.countByExample(buildPermissionExample);

        ErpBuildingSetSettingExample buildingSetSettingExample = new ErpBuildingSetSettingExample();
        buildingSetSettingExample.setShardCityId(cityId);
        buildingSetSettingExample.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(compId);
        Integer buildSetSettingCount = erpBuildingSetSettingMapper.countByExample(buildingSetSettingExample);*/

        ErpFunSaleExample saleExample = new ErpFunSaleExample();
        saleExample.setShardCityId(cityId);
        saleExample.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(compId);
        Integer funSaleCount = erpFunSaleMapper.countByExample(saleExample);

        ErpFunLeaseExample leaseExample = new ErpFunLeaseExample();
        leaseExample.setShardCityId(cityId);
        leaseExample.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(compId);
        Integer funLeaseCount = erpFunLeaseMapper.countByExample(leaseExample);

        if(Byte.valueOf("1").equals(requestFor)){
            if(0 == funSaleCount && 0 == funLeaseCount){
                return ErpResponseJson.ok();
            }else{
                throw new BusinessException("该楼盘已有房间，不能进行删除操作");
            }
        }else{
            if(0 == funSaleCount && 0 == funLeaseCount){
                erpBuildingSetRoofService.deleteBuildingInfo(cityId,compId,buildId,userId);
            }else{
                throw new BusinessException("该楼盘已有房间，不能进行删除操作");
            }
        }
        Map<String,String> result = new HashMap<>();
        result.put("result","success");
        return ErpResponseJson.ok(result);
    }

    @ApiOperation("单独增加栋座")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/addBuildRoofV2")
    @ResponseBody
    public ResponseJson addBuildRoofV2(@Valid @RequestBody RoofSingleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetRoofService.addBuildRoofV2(param, generalParam, false);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(),0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("复制栋座")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/copyBuildRoof")
    @ResponseBody
    public ResponseJson copyBuildRoof(@Valid @RequestBody RoofSingleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetRoofService.addBuildRoofV2(param, generalParam, true);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("增加单元或者号位")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/addBuildUnitV2")
    @ResponseBody
    public ResponseJson addBuildUnitV2(@Valid @RequestBody UnitSingleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetUnitService.addBuildUnitV2(param, generalParam, false);

        // 将生成的单元id放入 kafka
        KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        return ErpResponseJson.ok();
    }

    @ApiOperation("复制单元或者号位")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/copyBuildUnit")
    @ResponseBody
    public ResponseJson copyBuildUnit(@Valid @RequestBody UnitSingleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetUnitService.addBuildUnitV2(param, generalParam, true);

        // 将生成的单元id放入 kafka
        KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        return ErpResponseJson.ok();
    }

    @ApiOperation("增加楼层(只加楼层,不加房间)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/addBuildFloor")
    @ResponseBody
    public ResponseJson addBuildFloor(@Valid @RequestBody BuildFloorAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        erpBuildingSetFloorService.addBuildFloor(param, generalParam);

        return ErpResponseJson.ok();
    }

    @ApiOperation("编辑栋座")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/updateBuildRoofV2")
    @ResponseBody
    public ResponseJson updateBuildRoofV2(@Valid @RequestBody RoofEditParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetRoofService.updateBuildRoofV2(param, generalParam);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("编辑单元或者号位")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/updateBuildUnitV2")
    @ResponseBody
    public ResponseJson updateBuildUnitV2(@Valid @RequestBody UnitEditParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetUnitService.updateBuildUnitV2(param, generalParam);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }

    /** 废弃 */
    @ApiOperation("获取房间销控信息(出售, 出租, 租售)数量")
    @ApiResponses(value = {@ApiResponse(code = 200, response = RoomConInfoCountVo.class, message = "成功")})
    @PostMapping("/getRoomConInfoCount")
    @ResponseBody
    public ResponseJson getRoomConInfoCount(@Valid @RequestBody RoomConInfoCountParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        RoomConInfoCountVo conInfoCount = erpBuildingSetRoomService.getRoomConInfoCount(param, generalParam);

        return ErpResponseJson.ok(conInfoCount);
    }

    @NotBlank({"buildId", "caseType"})
    @ApiOperation("获取房间销控信息(出售, 出租, 租售)")
    @ApiResponses(value = {@ApiResponse(code = 200, response = RoomConInfoListVo.class, message = "成功")})
    @PostMapping("/getRoomConInfoByCase")
    @ResponseBody
    public ResponseJson getRoomConInfoByCase(@Valid @RequestBody RoomConInfoByCaseParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        List<RoomConInfoVo> roomConInfoVos = erpBuildingSetRoomService.getRoomConInfoByCase(param, generalParam);

        RoomConInfoListVo roomConInfoListVo = new RoomConInfoListVo();
        roomConInfoListVo.setRoomConInfoVos(roomConInfoVos);

        return ErpResponseJson.ok(roomConInfoListVo);
    }

    @NotBlank({"buildingSetUnitId", "buildId"})
    @ApiOperation("获取单元或者号位规则详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = UnitDetailsVo.class, message = "成功")
    })
    @PostMapping("/getBuildUnitRuleV2")
    @ResponseBody
    public ResponseJson getBuildUnitRuleV2(@Valid @RequestBody GetBuildUnitRuleParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        UnitDetailsVo unitDetailsVo = erpBuildingSetUnitService.getBuildUnitRuleV2(param, generalParam);
        return ErpResponseJson.ok(unitDetailsVo);
    }

    @NotBlank({"buildingSetRoofId", "buildId"})
    @ApiOperation("获取栋座规则详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = RoofDetailsVo.class, message = "成功")
    })
    @PostMapping("/getBuildRoofRuleV2")
    @ResponseBody
    public ResponseJson getBuildRoofRuleV2(@Valid @RequestBody ErpBuildingSetRoofIdParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        RoofDetailsVo roofDetailsVo = erpBuildingSetRoofService.getBuildRoofRuleV2(param, generalParam);
        return ErpResponseJson.ok(roofDetailsVo);
    }

    @ApiOperation("首次创建号位规则")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/addBuildUnitRule")
    @ResponseBody
    public ResponseJson addBuildUnitRule(@Valid @RequestBody BuildUnitRuleAddParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        String unitIds = erpBuildingSetUnitService.addBuildUnitRule(param, generalParam);
        // 将生成的单元id放入 kafka
        if (unitIds.length() > 0) {
            KafkaBizUtils.syncGenerateRoom(getOperator().getCityId(), 0, param.getBuildId(), 2, unitIds, (byte) 1);
        }

        return ErpResponseJson.ok();
    }


    /*----------------------------------------------------------------------------------------------------------------*/


    /**
     * 是否是系统模板:
     * 1=是 获取该楼盘在楼盘规则表中模板公司的ID
     * 0=不是 返回原公司ID
     */
    private Integer getCompIdWhenTemplate(Integer buildTemplate, GeneralParam generalParam, Integer buildId) {
        // 系统模板
        if (buildTemplate == 1) {
            Integer cityId = generalParam.getCityId();
            Integer compId = generalParam.getCompId();
            ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(cityId, compId, buildId);
            if (info == null || null == info.getTemplateCompId()) {
                throw new BusinessException("系统模板不存在！");
            } else {
                return info.getTemplateCompId();
            }
        } else {
            return generalParam.getCompId();
        }
    }

    @ApiOperation("楼盘是否有系统模板, 楼盘规则, 楼盘维护人以及锁定状态")
    @ApiResponses({@ApiResponse(code = 200, response = CheckBuildTemplateVo.class, message = "success")})
    @PostMapping("/checkBuildTemplate")
    @ResponseBody
    public ResponseJson checkBuildTemplate(@Valid @RequestBody OnlyBuildIdParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer buildId = param.getBuildId();

        // 是否拥有楼盘销控查看权
//        ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, getOperator().getUserId(), "BUILD_SELL_CONTROL_TABLE");
//
//        if (erpUserOpers == null) {
//            throw new BusinessException("您没有权限查看楼盘规则，如需查看请联系管理员配置权限！");
//        }

        CheckBuildTemplateVo checkBuildTemplateVo = new CheckBuildTemplateVo();

        // 查看是否有系统模板
        ErpBuildingInfo info = erpBuildingInfoMapper.getTempCompId(cityId, compId, buildId);

        checkBuildTemplateVo.setHaveBuildTemplate(0);
        if (info != null && info.getTemplateCompId() != null && !info.getTemplateCompId().equals(getOperator().getCompId())) {
            checkBuildTemplateVo.setHaveBuildTemplate(1);
        }

        // 核心信息类型：0=栋座单元楼室，1=弄号室，2=号室
        String paramVal = erpSysParaMapper.getParamValue(cityId, compId, "CORE_INFO_TYPE");

        // 是否有楼盘规则
        checkBuildTemplateVo.setHaveBuildRule(0);
        if ("2".equals(paramVal)) {
            ErpBuildingSetUnitExample unitExample = new ErpBuildingSetUnitExample();
            unitExample.setShardCityId(cityId);
            unitExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
            int unitCount = erpBuildingSetUnitMapper.countByExample(unitExample);

            if (unitCount > 0) {
                checkBuildTemplateVo.setHaveBuildRule(1);
            }
        } else {
            ErpBuildingSetRoofExample roofExample = new ErpBuildingSetRoofExample();
            roofExample.setShardCityId(cityId);
            roofExample.createCriteria().andCompIdEqualTo(0).andBuildIdEqualTo(buildId);
            int roofCount = erpBuildingSetRoofMapper.countByExample(roofExample);

            if (roofCount > 0) {
                checkBuildTemplateVo.setHaveBuildRule(1);
            }
        }

        ErpBuildingSetSetting erpBuildingSetSetting = erpBuildingSetSettingMapper.selectByBuildId(cityId, 0, buildId);
        int buildLock = (erpBuildingSetSetting != null) ? erpBuildingSetSetting.getBuildLock() : 0;
        // 楼盘是否锁定
        checkBuildTemplateVo.setBuildLock(buildLock);

        ErpBuildingManagerExample example = new ErpBuildingManagerExample();
        example.setShardCityId(cityId);
        example.setOrderByClause(" CREATION_TIME DESC ");
        example.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId).andManagerTypeEqualTo((byte) 1);
        List<ErpBuildingManager> managers = erpBuildingManagerMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(managers)) {
            checkBuildTemplateVo.setBuildingManagerId(managers.get(0).getUserId());
        }

        return ErpResponseJson.ok(checkBuildTemplateVo);
    }

    @NotBlank({"buildId"})
    @ApiOperation("移动端房态表(出售, 出租, 租售)")
    @ApiResponses(value = {@ApiResponse(code = 200, response = RoomConInfoListVo.class, message = "成功")})
    @PostMapping("/getRoomConInfoByCaseInMobile")
    @ResponseBody
    public ResponseJson getRoomConInfoByCaseInMobile(@Valid @RequestBody RoomConInfoByCaseInMobileParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        RoomConInfoByCaseParam caseParam = new RoomConInfoByCaseParam();
        caseParam.setBuildId(param.getBuildId());
        caseParam.setBuildingSetRoofId(param.getBuildingSetRoofId());
        caseParam.setBuildingSetUnitId(param.getBuildingSetUnitId());
        caseParam.setCaseType(param.getCaseType());
        List<RoomConInfoVo> roomConInfoVos = erpBuildingSetRoomService.getRoomConInfoByCase(caseParam, generalParam);

        RoomConInfoListVo roomConInfoListVo = new RoomConInfoListVo();
        roomConInfoListVo.setRoomConInfoVos(roomConInfoVos);

        return ErpResponseJson.ok(roomConInfoListVo);
    }

    @ApiOperation("移动端获取栋座规则列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = BuildRoofRuleInMobileVo.class, message = "成功")
    })
    @PostMapping("/getBuildRoofListInMobile")
    @ResponseBody
    public ResponseJson getBuildRoofListInMobile(@Valid @RequestBody BuildIdInMobileParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        BuildRoofRuleInMobileVo vo = erpBuildingSetRoofService.getBuildRoofListInMobile(param, generalParam);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("移动端获取栋座详情(包含单元列表)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = BuildRoofDetailsInMobileVo.class, message = "成功")
    })
    @PostMapping("/getBuildRoofDetailsInMobile")
    @ResponseBody
    public ResponseJson getBuildRoofDetailsInMobile(@Valid @RequestBody BuildRoofIdParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        BuildRoofDetailsInMobileVo vo = erpBuildingSetRoofService.getBuildRoofDetailsInMobile(param, generalParam);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("移动端获取房间列表(包含销控信息)")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = FloorListVo.class, message = "成功")
    })
    @PostMapping("/getRoomInfoListInMobile")
    @ResponseBody
    public ResponseJson getRoomInfoListInMobile(@Valid @RequestBody ErpBuildingGetRoomInfoListIdParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        FloorListVo floorListVo = erpBuildingSetRoomService.getRoomInfoListInMobile(param, generalParam);
        return ErpResponseJson.ok(floorListVo);
    }

    @ApiOperation("删除楼层")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
    })
    @PostMapping("/delBuildFloorById")
    @ResponseBody
    public ResponseJson delBuildFloorById(@Valid @RequestBody BuildFloorIdParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        erpBuildingSetFloorService.delBuildFloorById(param, generalParam);
        return ErpResponseJson.ok();
    }

    @ApiOperation("移动端获取号位规则列表")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = BuildUnitRuleInMobileVo.class, message = "成功")
    })
    @PostMapping("/getBuildUnitListInMobile")
    @ResponseBody
    public ResponseJson getBuildUnitListInMobile(@Valid @RequestBody BuildIdInMobileParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        BuildUnitRuleInMobileVo vo = erpBuildingSetUnitService.getBuildUnitListInMobile(param, generalParam);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("移动端获取号位详情")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = BuildUnitDetailsInMobileVo.class, message = "成功")
    })
    @PostMapping("/getBuildUnitDetailsInMobile")
    @ResponseBody
    public ResponseJson getBuildUnitDetailsInMobile(@Valid @RequestBody BuildUnitIdParam param) {
        Integer buildId = param.getBuildId();
        Integer buildTemplate = param.getBuildTemplate();
        GeneralParam generalParam = new GeneralParam(getOperator());

        // 获取公司ID(本公司或者是楼盘系统公司)
        Integer finalCompId = getCompIdWhenTemplate(buildTemplate, generalParam, buildId);
        generalParam.setCompId(finalCompId);

        BuildUnitDetailsInMobileVo vo = erpBuildingSetUnitService.getBuildUnitDetailsInMobile(param, generalParam);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("移动端楼盘字典列表")
    @ApiResponses({@ApiResponse(code = 200, response = BuildingListInMobileVo.class, message = "success")})
    @PostMapping("/getBuildingListInMobile")
    @ResponseBody
    public ResponseJson getBuildingListInMobile(@Valid @RequestBody QueryBuildingListParam param) {

        // 审核标志，1=是（纠正：入库标记 1-是； 0-否）
        Integer buildingFlag = StringUtil.parseInteger(getOperator().getAttribute("BUILDING_FLAG"), 0);

        GeneralParam generalParam = new GeneralParam(getOperator());
        BuildingListInMobileVo buildingListInMobileVo = erpBuildInfoService.getBuildingListInMobile(param, generalParam, buildingFlag);
        return ErpResponseJson.ok(buildingListInMobileVo);
    }

    @ApiOperation("移动端楼盘字典房间查看房源列表")
    @ApiResponses({@ApiResponse(code = 200, response = FunListByCaseIdsVo.class, message = "success")})
    @PostMapping("/getFunListByCaseIdsInMobile")
    @ResponseBody
    public ResponseJson getFunListByCaseIdsInMobile(@Valid @RequestBody CaseIdsParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        FunListByCaseIdsVo vo = erpBuildingSetRoomService.getFunListByCaseIdsInMobile(param, generalParam);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("查看客源列表")
    @ApiResponses({@ApiResponse(code = 200, response = CustomersByCaseIdsVo.class, message = "success")})
    @PostMapping("/getCustomersByCaseIds")
    @ResponseBody
    public ResponseJson getCustomersByCaseIds(@Valid @RequestBody CaseIdsParam param) {
        GeneralParam generalParam = new GeneralParam(getOperator());
        CustomersByCaseIdsVo vo = erpBuildingSetRoomService.getCustomersByCaseIds(param, generalParam);
        return ErpResponseJson.ok(vo);
    }


   /** -----------------------------------楼盘字典街道维护相关接口------------------------------------------------- **/


    @ApiOperation("获取街道维护地区列表(例如华南地区)")
    @ApiResponses({@ApiResponse(code = 200, response = StreetTerritoryVo.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetTerritoryList")
    @ResponseBody
    public ResponseJson getStreetTerritoryList() {
        List<StreetTerritoryVo> territories = erpFunTerritoryMapper.getStreetTerritoryList(getOperator().getCityId(), getOperator().getCompId());
        return ErpResponseJson.ok(territories);
    }

    @ApiOperation("获取街道维护省份列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunStreetProvinceVO.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetProvinceList")
    @ResponseBody
    public ResponseJson getStreetProvinceList(@Valid @RequestBody DataIdParam param) {
        List<ErpFunStreetProvinceVO> provinces = erpFunStreetProvinceMapper.getStreetProvinceList(getOperator().getCityId(), getOperator().getCompId(), param.getDataId());
        return ErpResponseJson.ok(provinces);
    }

    @ApiOperation("获取街道维护城市列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunStreetCityVO.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetCityList")
    @ResponseBody
    public ResponseJson getStreetCityList(@Valid @RequestBody DataIdParam param) {
        List<ErpFunStreetCityVO> cities = erpFunStreetCityMapper.getStreetCityList(getOperator().getCityId(), getOperator().getCompId(), param.getDataId());
        return ErpResponseJson.ok(cities);
    }

    @ApiOperation("获取街道维护行政区列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunStreetRegVO.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetRegList")
    @ResponseBody
    public ResponseJson getStreetRegList(@Valid @RequestBody DataIdParam param) {
        List<ErpFunStreetRegVO> regs = erpFunStreetRegMapper.getStreetRegList(getOperator().getCityId(), getOperator().getCompId(), param.getDataId());
        return ErpResponseJson.ok(regs);
    }

    @ApiOperation("获取街道维护的商圈列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunStreetSectionVO.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetSectionList")
    @ResponseBody
    public ResponseJson getStreetSectionList(@Valid @RequestBody StreetSectionListParam param) {
        // 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区
        if (param.getNeedPage() != null && param.getNeedPage() == 1) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        }
        List<ErpFunStreetSectionVO> sectionList = erpFunStreetSectionMapper.getStreetSectionList(getOperator().getCityId(), getOperator().getCompId(), param);
        if (param.getNeedPage() != null && param.getNeedPage() == 1) {
            PageInfo<ErpFunStreetSectionVO> pageInfo = new PageInfo<>(sectionList);
            return ErpResponseJson.ok(pageInfo);
        }
        return ErpResponseJson.ok(sectionList);
    }

    @ApiOperation("获取街道维护的街道列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunStreetVO.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetList")
    @ResponseBody
    public ResponseJson getStreetList(@Valid @RequestBody StreetDataListParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Byte dataRange = param.getDataRange();
        Integer dataId = param.getDataId();

        List<ErpFunStreetVO> streetVOS = new ArrayList<>();

        // 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区 5=街道商圈
        List<ErpFunStreet> streets;
        if (dataRange == 4) {
        	param.setRegId(dataId);
            PageHelper.startPage(param.getPageOffset(), param.getPageRows());
            PageHelper.orderBy("A.SEQ_NO ASC,A.ID");
            streets = erpFunStreetMapper.getStreetListBySection(getOperator().getCityId(), getOperator().getCompId(), param);
        } else if (dataRange == 5) {
        	param.setSectionId(dataId);
            PageHelper.startPage(param.getPageOffset(), param.getPageRows());
            PageHelper.orderBy("A.SEQ_NO ASC,A.ID");
            streets = erpFunStreetMapper.getStreetListBySection(getOperator().getCityId(), getOperator().getCompId(), param);
        } else {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows());
            streets = erpFunStreetMapper.getStreetList(getOperator().getCityId(), getOperator().getCompId(), param);
        }

        // 聚合城市、行政区、商圈信息
        if (CollectionUtils.isNotEmpty(streets)) {
            List<Integer> streetIds = streets.stream().map(ErpFunStreet::getId).collect(Collectors.toList());
            List<Integer> cityIds = streets.stream().map(ErpFunStreet::getStreetCityId).collect(Collectors.toList());
            ErpFunStreetCityExample cityExample = new ErpFunStreetCityExample();
            cityExample.setShardCityId(cityId);
            cityExample.createCriteria().andIdIn(cityIds);
            List<ErpFunStreetCity> cities = erpFunStreetCityMapper.selectByExample(cityExample);

            ErpFunStreetInSectionExample selectExample = new ErpFunStreetInSectionExample();
            selectExample.setShardCityId(cityId);
            selectExample.createCriteria().andStreetIdIn(streetIds).andIsDelEqualTo((byte) 0);
            List<ErpFunStreetInSection> inSections = erpFunStreetInSectionMapper.selectByExample(selectExample);

            // 所有的商圈信息
            List<ErpFunStreetSection> sectionInfos = new ArrayList<>();
            List<Integer> allSectionIds = inSections.stream().map(ErpFunStreetInSection::getStreetSectionId).distinct().collect(Collectors.toList());
            if (allSectionIds!=null && !allSectionIds.isEmpty()) {
            	ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
            	sectionExample.setShardCityId(cityId);
            	sectionExample.createCriteria().andIdIn(allSectionIds);
            	sectionInfos = erpFunStreetSectionMapper.selectByExample(sectionExample);
            }
            ErpFunStreetInRegExample selectRegExample = new ErpFunStreetInRegExample();
            selectRegExample.setShardCityId(cityId);
            selectRegExample.createCriteria().andStreetIdIn(streetIds).andIsDelEqualTo((byte) 0);
            List<ErpFunStreetInReg> inRegs = erpFunStreetInRegMapper.selectByExample(selectRegExample);

            // 行政区信息
            List<Integer> regIds = inRegs.stream().map(ErpFunStreetInReg::getStreetRegId).collect(Collectors.toList());
            ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
            regExample.setShardCityId(cityId);
            regExample.createCriteria().andIdIn(regIds);
            List<ErpFunStreetReg> regs = erpFunStreetRegMapper.selectByExample(regExample);

            for (ErpFunStreet street : streets) {
                ErpFunStreetVO streetVO = new ErpFunStreetVO();
                BeanUtils.copyProperties(street, streetVO);

                Optional<ErpFunStreetCity> cityOptional = cities.stream().filter(it -> it.getId().equals(street.getStreetCityId())).findFirst();
                if (cityOptional.isPresent()) {
                    String cityName = cityOptional.get().getCityName();
                    streetVO.setCityName(cityName);
                }

                // 该街道所属的所有商圈
                Integer streetId = street.getId();
                List<Integer> sectionIdList = inSections.stream().filter(it -> it.getStreetId().equals(streetId)).map(ErpFunStreetInSection::getStreetSectionId).collect(Collectors.toList());
                Set<Integer> regIdList = inRegs.stream().filter(it -> it.getStreetId().equals(streetId)).map(ErpFunStreetInReg::getStreetRegId).collect(Collectors.toSet());
                List<SectionVO> sectionVos = new ArrayList<>();
                
                if (CollectionUtils.isNotEmpty(sectionIdList)) {
                    for (Integer sectionId : sectionIdList) {
                        SectionVO sectionVO = new SectionVO();
                        Optional<ErpFunStreetSection> sectionOptional = sectionInfos.stream().filter(it -> sectionId.equals(it.getId())).findFirst();
                        if (sectionOptional.isPresent()) {
                            ErpFunStreetSection section = sectionOptional.get();
                            sectionVO.setStreetSectionId(section.getId());
                            sectionVO.setSectionName(section.getSectionName());

                            Integer currStreetRegId = section.getStreetRegId();
                            Optional<ErpFunStreetReg> regOptional = regs.stream().filter(it -> currStreetRegId.equals(it.getId())).findFirst();
                            if (regOptional.isPresent()) {
                                ErpFunStreetReg reg = regOptional.get();
                                regIdList.remove(reg.getId());
                                sectionVO.setStreetRegId(reg.getId());
                                sectionVO.setRegName(reg.getRegName());
                            }
                        }
                        sectionVos.add(sectionVO);
                    }
                }
                if (CollectionUtils.isNotEmpty(regIdList)) {
                	 for (Integer regId : regIdList) {
                         SectionVO sectionVO = new SectionVO();
                         Integer currStreetRegId = regId;
                         Optional<ErpFunStreetReg> regOptional = regs.stream().filter(it -> currStreetRegId.equals(it.getId())).findFirst();
                         if (regOptional.isPresent()) {
                             ErpFunStreetReg reg = regOptional.get();
                             sectionVO.setStreetRegId(reg.getId());
                             sectionVO.setRegName(reg.getRegName());
                             sectionVos.add(sectionVO);
                         }
                     }
                }
                streetVO.setSections(sectionVos);
                streetVOS.add(streetVO);
            }
        }
        PageInfo<ErpFunStreetVO> pageInfo = new PageInfo<>(streetVOS);
        return ErpResponseJson.ok(pageInfo);
    }

    @ApiOperation("添加,编辑,删除街道维护地区列表(例如华南地区)")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = StreetTerritoryVo.class)})
    @PostMapping("/editStreetTerritory")
    @ResponseBody
    public ResponseJson editStreetTerritory(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        Integer territoryId = null;

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            if (addData != null) {
                ErpFunTerritory erpFunTerritory = new ErpFunTerritory();
                BeanUtils.copyProperties(addData, erpFunTerritory);
                erpFunTerritory.setShardCityId(cityId);
                erpFunTerritory.setCompId(compId);
                erpFunTerritory.setTerritoryName(addData.getName());
                erpFunTerritory.setCreateTime(new Date());
                erpFunTerritoryMapper.insertSelective(erpFunTerritory);

                territoryId = erpFunTerritory.getId();
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();
            if (updateData != null) {
                ErpFunTerritory erpFunTerritory = new ErpFunTerritory();
                BeanUtils.copyProperties(updateData, erpFunTerritory);
                erpFunTerritory.setShardCityId(cityId);
                erpFunTerritory.setUpdateTime(new Date());
                erpFunTerritory.setCompId(compId);
                erpFunTerritory.setTerritoryName(updateData.getName());
                erpFunTerritoryMapper.updateByPrimaryKeySelective(erpFunTerritory);

                territoryId = updateData.getId();
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                // 删除地区下关联的街道省
                ErpFunStreetProvinceExample countProvinceExample = new ErpFunStreetProvinceExample();
                countProvinceExample.setShardCityId(cityId);
                countProvinceExample.createCriteria().andStreetTerritoryIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                int provinceCount = erpFunStreetProvinceMapper.countByExample(countProvinceExample);
                if (provinceCount>0) {
                	throw new BusinessException("下面还有省份，不能删除！");
                }
                erpFunTerritoryMapper.deleteStreetTerritoryById(cityId, compId, id, userId);
                ErpFunStreetProvince province = new ErpFunStreetProvince();
                province.setIsDel((byte) 1);
                province.setDelUserId(userId);
                province.setDelTime(new Date());
                ErpFunStreetProvinceExample provinceExample = new ErpFunStreetProvinceExample();
                provinceExample.setShardCityId(cityId);
                provinceExample.createCriteria().andStreetTerritoryIdEqualTo(id);
                erpFunStreetProvinceMapper.updateByExampleSelective(province, provinceExample);
                // 删除地区下关联的街道城市
                
                ErpFunStreetCity city = new ErpFunStreetCity();
                city.setIsDel((byte) 1);
                city.setDelUserId(userId);
                city.setDelTime(new Date());
                ErpFunStreetCityExample cityExample = new ErpFunStreetCityExample();
                cityExample.setShardCityId(cityId);
                cityExample.createCriteria().andStreetTerritoryIdEqualTo(id);
                erpFunStreetCityMapper.updateByExampleSelective(city, cityExample);
                // 删除地区下关联的街道行政区
                ErpFunStreetReg reg = new ErpFunStreetReg();
                reg.setIsDel((byte) 1);
                reg.setDelUserId(userId);
                reg.setDelTime(new Date());
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetTerritoryIdEqualTo(id);
                erpFunStreetRegMapper.updateByExampleSelective(reg, regExample);
                // 删除地区下关联的街道商圈
                ErpFunStreetSection section = new ErpFunStreetSection();
                section.setIsDel((byte) 1);
                section.setDelUserId(userId);
                section.setDelTime(new Date());
                ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andStreetTerritoryIdEqualTo(id);
                erpFunStreetSectionMapper.updateByExampleSelective(section, sectionExample);
                // 删除地区下关联的街道
                ErpFunStreet street = new ErpFunStreet();
                street.setIsDel((byte) 1);
                street.setDelUserId(userId);
                street.setDelTime(new Date());
                ErpFunStreetExample streetExample = new ErpFunStreetExample();
                streetExample.setShardCityId(cityId);
                streetExample.createCriteria().andStreetTerritoryIdEqualTo(id);
                erpFunStreetMapper.updateByExampleSelective(street, streetExample);
            }
        }

        if (territoryId != null) {
            StreetTerritoryVo territory = erpFunTerritoryMapper.getStreetTerritory(getOperator().getCityId(), getOperator().getCompId(), territoryId);
            if (territory != null) {
                return ErpResponseJson.ok(territory);
            }
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("添加,编辑,删除街道维护省份")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = ErpFunStreetProvinceVO.class)})
    @PostMapping("/editStreetProvince")
    @ResponseBody
    public ResponseJson editStreetProvince(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        Integer provinceId = null;

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            if (addData != null) {
            	ErpFunStreetProvinceExample example = new ErpFunStreetProvinceExample();
            	example.setShardCityId(cityId);
            	example.createCriteria().andProvinceNameEqualTo(addData.getName()).andIsDelEqualTo(Byte.valueOf("0"));
            	Integer count = erpFunStreetProvinceMapper.countByExample(example);
            	if (count>0) {
            		throw new BusinessException("省份名字不允许重复！");
            	}
            	ErpFunStreetProvince erpFunStreetProvince = new ErpFunStreetProvince();
                BeanUtils.copyProperties(addData, erpFunStreetProvince);
                erpFunStreetProvince.setShardCityId(cityId);
                erpFunStreetProvince.setCompId(compId);
                erpFunStreetProvince.setProvinceName(addData.getName());
                erpFunStreetProvince.setCreateTime(new Date());
                erpFunStreetProvince.setProvinceId(addData.getFunId());
                erpFunStreetProvince.setStreetTerritoryId(Integer.valueOf(addData.getParentId()));
                erpFunStreetProvinceMapper.insertSelective(erpFunStreetProvince);

                provinceId = erpFunStreetProvince.getId();
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();
            if (updateData != null) {
              	ErpFunStreetProvinceExample example = new ErpFunStreetProvinceExample();
            	example.setShardCityId(cityId);
            	example.createCriteria().andProvinceNameEqualTo(updateData.getName()).andIsDelEqualTo(Byte.valueOf("0")).andIdNotEqualTo(updateData.getId());
            	Integer count = erpFunStreetProvinceMapper.countByExample(example);
            	if (count>0) {
            		throw new BusinessException("省份名字不允许重复！");
            	}
                ErpFunStreetProvince erpFunStreetProvince = new ErpFunStreetProvince();
                BeanUtils.copyProperties(updateData, erpFunStreetProvince);
                erpFunStreetProvince.setShardCityId(cityId);
                erpFunStreetProvince.setUpdateTime(new Date());
                erpFunStreetProvince.setCompId(compId);
                erpFunStreetProvince.setProvinceName(updateData.getName());
                erpFunStreetProvince.setProvinceId(updateData.getFunId());
                erpFunStreetProvince.setStreetTerritoryId(Integer.valueOf(updateData.getParentId()));
                erpFunStreetProvinceMapper.updateByPrimaryKeySelective(erpFunStreetProvince);

                provinceId = updateData.getId();
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                ErpFunStreetCityExample countCityExample = new ErpFunStreetCityExample();
                countCityExample.setShardCityId(cityId);
                countCityExample.createCriteria().andStreetProvinceIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                int countCity = erpFunStreetCityMapper.countByExample(countCityExample);
                if (countCity>0) {
                	throw new BusinessException("省份下还有城市，不能删除！");
                }
                // 删除地街道省
                erpFunStreetProvinceMapper.deleteStreetProvinceById(cityId, compId, id, userId);
                // 删除街道省下关联的街道城市
                ErpFunStreetCity city = new ErpFunStreetCity();
                city.setIsDel((byte) 1);
                city.setDelUserId(userId);
                city.setDelTime(new Date());
                ErpFunStreetCityExample cityExample = new ErpFunStreetCityExample();
                cityExample.setShardCityId(cityId);
                cityExample.createCriteria().andStreetProvinceIdEqualTo(id);
                erpFunStreetCityMapper.updateByExampleSelective(city, cityExample);
                // 删除街道省下关联的街道行政区
                ErpFunStreetReg reg = new ErpFunStreetReg();
                reg.setIsDel((byte) 1);
                reg.setDelUserId(userId);
                reg.setDelTime(new Date());
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetProvinceIdEqualTo(id);
                erpFunStreetRegMapper.updateByExampleSelective(reg, regExample);
                // 删除街道省下关联的街道商圈
                ErpFunStreetSection section = new ErpFunStreetSection();
                section.setIsDel((byte) 1);
                section.setDelUserId(userId);
                section.setDelTime(new Date());
                ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andStreetProvinceIdEqualTo(id);
                erpFunStreetSectionMapper.updateByExampleSelective(section, sectionExample);
                // 删除街道省下关联的街道
                ErpFunStreet street = new ErpFunStreet();
                street.setIsDel((byte) 1);
                street.setDelUserId(userId);
                street.setDelTime(new Date());
                ErpFunStreetExample streetExample = new ErpFunStreetExample();
                streetExample.setShardCityId(cityId);
                streetExample.createCriteria().andStreetProvinceIdEqualTo(id);
                erpFunStreetMapper.updateByExampleSelective(street, streetExample);
            }
        }

        if (provinceId != null) {
            ErpFunStreetProvinceVO province = erpFunStreetProvinceMapper.getStreetProvince(getOperator().getCityId(), getOperator().getCompId(), provinceId);
            if (province != null) {
                return ErpResponseJson.ok(province);
            }
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("添加,编辑,删除街道维护城市")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = ErpFunStreetCityVO.class)})
    @PostMapping("/editStreetCity")
    @ResponseBody
    public ResponseJson editStreetCity(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        Integer streetCityId = null;

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            if (addData != null) {
                // 街道城市的街道省份ID
                Integer streetProvinceId = Integer.valueOf(addData.getParentId());
                ErpFunStreetProvince condition = new ErpFunStreetProvince(cityId, streetProvinceId);
                ErpFunStreetProvince province = erpFunStreetProvinceMapper.selectByPrimaryKey(condition);
                ErpFunStreetCityExample example = new ErpFunStreetCityExample();
                example.setShardCityId(cityId);
                example.createCriteria().andStreetProvinceIdEqualTo(streetProvinceId).andCityNameEqualTo(addData.getName()).andIsDelEqualTo(Byte.valueOf("0"));
                Integer count = erpFunStreetCityMapper.countByExample(example);
                if (count>0) {
                	throw new BusinessException("同一省份下面,不允许有重名的城市！");
                }
                ErpFunStreetCity erpFunStreetCity = new ErpFunStreetCity();
                BeanUtils.copyProperties(addData, erpFunStreetCity);
                erpFunStreetCity.setShardCityId(cityId);
                erpFunStreetCity.setCompId(compId);
                erpFunStreetCity.setCityId(addData.getFunId());
                if (province != null) {
                    erpFunStreetCity.setStreetTerritoryId(province.getStreetTerritoryId());
                }
                erpFunStreetCity.setStreetProvinceId(streetProvinceId);
                erpFunStreetCity.setCityName(addData.getName());
                erpFunStreetCity.setCreateTime(new Date());
                erpFunStreetCityMapper.insertSelective(erpFunStreetCity);

                streetCityId = erpFunStreetCity.getId();
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();
            if (updateData != null) {
                // 街道城市的街道省份ID
                Integer streetProvinceId = Integer.valueOf(updateData.getParentId());
                ErpFunStreetProvince condition = new ErpFunStreetProvince(cityId, streetProvinceId);
                ErpFunStreetProvince province = erpFunStreetProvinceMapper.selectByPrimaryKey(condition);
                ErpFunStreetCityExample example = new ErpFunStreetCityExample();
                example.setShardCityId(cityId);
                example.createCriteria().andStreetProvinceIdEqualTo(streetProvinceId).andCityNameEqualTo(updateData.getName()).andIsDelEqualTo(Byte.valueOf("0")).andIdNotEqualTo(updateData.getId());
                Integer count = erpFunStreetCityMapper.countByExample(example);
                if (count>0) {
                	throw new BusinessException("同一省份下面,不允许有重名的城市！");
                }
                ErpFunStreetCity erpFunStreetCity = new ErpFunStreetCity();
                BeanUtils.copyProperties(updateData, erpFunStreetCity);
                erpFunStreetCity.setShardCityId(cityId);
                erpFunStreetCity.setUpdateTime(new Date());
                erpFunStreetCity.setCompId(compId);
                erpFunStreetCity.setCityId(updateData.getFunId());
                if (province != null) {
                    erpFunStreetCity.setStreetTerritoryId(province.getStreetTerritoryId());
                }
                erpFunStreetCity.setStreetProvinceId(streetProvinceId);
                erpFunStreetCity.setCityName(updateData.getName());
                erpFunStreetCityMapper.updateByPrimaryKeySelective(erpFunStreetCity);

                streetCityId = updateData.getId();
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                // 删除街道城市
                // 如果城市下有行政区，则不允许删除
                ErpFunStreetRegExample regCityExample = new ErpFunStreetRegExample();
                regCityExample.setShardCityId(cityId);
                regCityExample.createCriteria().andStreetCityIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                Integer countStreet = erpFunStreetRegMapper.countByExample(regCityExample);
                if (countStreet>0) {
                	throw new BusinessException("城市下还有行政区,不允许删除！");
                }
                erpFunStreetCityMapper.deleteStreetCityById(cityId, compId, id, userId);
                // 删除街道城市下关联的街道行政区
                ErpFunStreetReg reg = new ErpFunStreetReg();
                reg.setIsDel((byte) 1);
                reg.setDelUserId(userId);
                reg.setDelTime(new Date());
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetCityIdEqualTo(id);
                erpFunStreetRegMapper.updateByExampleSelective(reg, regExample);
                // 删除街道城市下关联的街道商圈
                ErpFunStreetSection section = new ErpFunStreetSection();
                section.setIsDel((byte) 1);
                section.setDelUserId(userId);
                section.setDelTime(new Date());
                ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andStreetCityIdEqualTo(id);
                erpFunStreetSectionMapper.updateByExampleSelective(section, sectionExample);
                // 删除街道城市下关联的街道
                ErpFunStreet street = new ErpFunStreet();
                street.setIsDel((byte) 1);
                street.setDelUserId(userId);
                street.setDelTime(new Date());
                ErpFunStreetExample streetExample = new ErpFunStreetExample();
                streetExample.setShardCityId(cityId);
                streetExample.createCriteria().andStreetCityIdEqualTo(id);
                erpFunStreetMapper.updateByExampleSelective(street, streetExample);
            }
        }

        if (streetCityId != null) {
            ErpFunStreetCityVO city = erpFunStreetCityMapper.getStreetCity(getOperator().getCityId(), getOperator().getCompId(), streetCityId);
            if (city != null) {
                return ErpResponseJson.ok(city);
            }
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("添加,编辑,删除街道维护行政区")
    @ApiResponses({@ApiResponse(code = 200, message = "success", response = ErpFunStreetRegVO.class)})
    @PostMapping("/editStreetReg")
    @ResponseBody
    public ResponseJson editStreetReg(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        Integer streetRegId = null;

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            if (addData != null) {
                // 街道城市的街道城市ID
                Integer streetCityId = Integer.valueOf(addData.getParentId());
                ErpFunStreetCity condition = new ErpFunStreetCity(cityId, streetCityId);
                ErpFunStreetCity city = erpFunStreetCityMapper.selectByPrimaryKey(condition);
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetCityIdEqualTo(Integer.valueOf(addData.getParentId())).andRegNameEqualTo(addData.getName()).andIsDelEqualTo(Byte.valueOf("0"));
                int regCount = erpFunStreetRegMapper.countByExample(regExample);
                if (regCount>0) {
                	throw new BusinessException("同一个城市下面不允许有重复的行政区！");
                }
                ErpFunStreetReg erpFunStreetReg = new ErpFunStreetReg();
                BeanUtils.copyProperties(addData, erpFunStreetReg);
                erpFunStreetReg.setShardCityId(cityId);
                erpFunStreetReg.setCompId(compId);
                if (city != null) {
                    erpFunStreetReg.setStreetTerritoryId(city.getStreetTerritoryId());
                    erpFunStreetReg.setStreetProvinceId(city.getStreetProvinceId());
                }
                erpFunStreetReg.setStreetCityId(Integer.valueOf(addData.getParentId()));
                erpFunStreetReg.setRegId(addData.getFunId());
                erpFunStreetReg.setRegName(addData.getName());
                erpFunStreetReg.setCreateTime(new Date());
                erpFunStreetRegMapper.insertSelective(erpFunStreetReg);

                streetRegId = erpFunStreetReg.getId();
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();

            if (updateData != null) {
                // 街道城市的街道城市ID
                Integer streetCityId = Integer.valueOf(updateData.getParentId());
                ErpFunStreetCity condition = new ErpFunStreetCity(cityId, streetCityId);
                ErpFunStreetCity city = erpFunStreetCityMapper.selectByPrimaryKey(condition);
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetCityIdEqualTo(Integer.valueOf(updateData.getParentId())).andRegNameEqualTo(updateData.getName()).andIsDelEqualTo(Byte.valueOf("0")).andIdNotEqualTo(updateData.getId());
                int regCount = erpFunStreetRegMapper.countByExample(regExample);
                if (regCount>0) {
                	throw new BusinessException("同一个城市下面不允许有重复的行政区！");
                }
                ErpFunStreetReg erpFunStreetReg = new ErpFunStreetReg();
                BeanUtils.copyProperties(updateData, erpFunStreetReg);
                erpFunStreetReg.setShardCityId(cityId);
                erpFunStreetReg.setUpdateTime(new Date());
                erpFunStreetReg.setCompId(compId);
                if (city != null) {
                    erpFunStreetReg.setStreetTerritoryId(city.getStreetTerritoryId());
                    erpFunStreetReg.setStreetProvinceId(city.getStreetProvinceId());
                }
                erpFunStreetReg.setStreetCityId(Integer.valueOf(updateData.getParentId()));
                erpFunStreetReg.setRegId(updateData.getFunId());
                erpFunStreetReg.setRegName(updateData.getName());
                erpFunStreetRegMapper.updateByPrimaryKeySelective(erpFunStreetReg);

                streetRegId = updateData.getId();
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                // 删除街道行政区
                ErpFunStreetSectionExample regExample = new ErpFunStreetSectionExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andStreetRegIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                int streetCount = erpFunStreetSectionMapper.countByExample(regExample);
                if (streetCount>0) {
                	throw new BusinessException("行政区下面还有商圈，不允许删除！");
                }
                ErpFunStreetInRegExample regInExample = new ErpFunStreetInRegExample();
                regInExample.setShardCityId(cityId);
                regInExample.createCriteria().andStreetRegIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                int regCount = erpFunStreetInRegMapper.countByExample(regInExample);
                if (regCount>0) {
                	throw new BusinessException("行政区下面还有关联的街道，不允许删除！");
                }
                erpFunStreetRegMapper.deleteStreetRegById(cityId, compId, id, userId);
                // 删除街道行政区下关联的街道商圈
                ErpFunStreetSection section = new ErpFunStreetSection();
                section.setIsDel((byte) 1);
                section.setDelUserId(userId);
                section.setDelTime(new Date());
                ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andStreetRegIdEqualTo(id);
                erpFunStreetSectionMapper.updateByExampleSelective(section, sectionExample);
                // 该行政区下的商圈
                ErpFunStreetSectionExample sectionExample1 = new ErpFunStreetSectionExample();
                sectionExample1.setShardCityId(cityId);
                sectionExample1.createCriteria().andStreetRegIdEqualTo(id).andIsDelEqualTo((byte) 0);
                List<ErpFunStreetSection> sectionInfos = erpFunStreetSectionMapper.selectByExample(sectionExample1);
                List<Integer> sectionIds = sectionInfos.stream().map(ErpFunStreetSection::getId).collect(Collectors.toList());
                
                if (CollectionUtils.isNotEmpty(sectionIds)) {
                    // 该行政区下商圈与街道的关联
                    ErpFunStreetInSectionExample inSectionExample = new ErpFunStreetInSectionExample();
                    inSectionExample.setShardCityId(cityId);
                    inSectionExample.createCriteria().andStreetSectionIdIn(sectionIds);
                    List<ErpFunStreetInSection> inSections = erpFunStreetInSectionMapper.selectByExample(inSectionExample);
                    // 该行政区下的街道
                    List<Integer> streetIds = inSections.stream().map(ErpFunStreetInSection::getStreetId).distinct().collect(Collectors.toList());

                    // 删除街道行政区下关联的街道商圈
                    ErpFunStreetInSection deleteInSection = new ErpFunStreetInSection();
                    deleteInSection.setIsDel((byte) 1);
                    deleteInSection.setDelUserId(userId);
                    deleteInSection.setDelTime(new Date());
                    ErpFunStreetInSectionExample deleteInSectionExample1 = new ErpFunStreetInSectionExample();
                    deleteInSectionExample1.setShardCityId(cityId);
                    deleteInSectionExample1.createCriteria().andStreetSectionIdIn(sectionIds);
                    erpFunStreetInSectionMapper.updateByExampleSelective(deleteInSection, deleteInSectionExample1);

                    // 删除街道行政区下关联的街道
                    if (CollectionUtils.isNotEmpty(streetIds)) {
                        ErpFunStreet street = new ErpFunStreet();
                        street.setIsDel((byte) 1);
                        street.setDelUserId(userId);
                        street.setDelTime(new Date());
                        ErpFunStreetExample streetExample = new ErpFunStreetExample();
                        streetExample.setShardCityId(cityId);
                        streetExample.createCriteria().andIdIn(streetIds);
                        erpFunStreetMapper.updateByExampleSelective(street, streetExample);
                    }
                }
            }
        }

        if (streetRegId != null) {
            ErpFunStreetRegVO reg = erpFunStreetRegMapper.getStreetReg(getOperator().getCityId(), getOperator().getCompId(), streetRegId);
            if (reg != null) {
                return ErpResponseJson.ok(reg);
            }
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("添加,编辑,删除街道维护的商圈")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/editStreetSection")
    @ResponseBody
    public ResponseJson editStreetSection(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            if (addData != null) {
                // 街道城市的街道行政区ID
                Integer streetRegId = Integer.valueOf(addData.getParentId());
                ErpFunStreetReg condition = new ErpFunStreetReg(cityId, streetRegId);
                ErpFunStreetReg reg = erpFunStreetRegMapper.selectByPrimaryKey(condition);
                // 删除街道商圈
                ErpFunStreetSectionExample streetSectionExample = new ErpFunStreetSectionExample();
                streetSectionExample.setShardCityId(cityId);
                streetSectionExample.createCriteria().andStreetRegIdEqualTo(streetRegId).andSectionNameEqualTo(addData.getName()).andIsDelEqualTo(Byte.valueOf("0"));
                int countStreetSection = erpFunStreetSectionMapper.countByExample(streetSectionExample);
                if (countStreetSection>0) {
                	throw new BusinessException("同一行政区下不能有重复商圈！");
                }
                ErpFunStreetSection erpFunStreetSection = new ErpFunStreetSection();
                BeanUtils.copyProperties(addData, erpFunStreetSection);
                erpFunStreetSection.setShardCityId(cityId);
                erpFunStreetSection.setCompId(compId);
                if (reg != null) {
                    erpFunStreetSection.setStreetTerritoryId(reg.getStreetTerritoryId());
                    erpFunStreetSection.setStreetProvinceId(reg.getStreetProvinceId());
                    erpFunStreetSection.setStreetCityId(reg.getStreetCityId());
                }
                erpFunStreetSection.setStreetRegId(streetRegId);
                erpFunStreetSection.setSectionName(addData.getName());
                erpFunStreetSection.setCreateTime(new Date());
                erpFunStreetSectionMapper.insertSelective(erpFunStreetSection);
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();

            if (updateData != null) {
                // 街道城市的街道行政区ID
                Integer streetRegId = Integer.valueOf(updateData.getParentId());
                ErpFunStreetReg condition = new ErpFunStreetReg(cityId, streetRegId);
                ErpFunStreetReg reg = erpFunStreetRegMapper.selectByPrimaryKey(condition);
                // 删除街道商圈
                if (StringUtils.isNotBlank(updateData.getName())) {
	                ErpFunStreetSectionExample streetSectionExample = new ErpFunStreetSectionExample();
	                streetSectionExample.setShardCityId(cityId);
	                streetSectionExample.createCriteria().andStreetRegIdEqualTo(streetRegId).andSectionNameEqualTo(updateData.getName()).andIsDelEqualTo(Byte.valueOf("0")).andIdNotEqualTo(updateData.getId());
	                int countStreetSection = erpFunStreetSectionMapper.countByExample(streetSectionExample);
	                if (countStreetSection>0) {
	                	throw new BusinessException("同一行政区下不能有重复商圈！");
	                }
                }
                ErpFunStreetSection erpFunStreetSection = new ErpFunStreetSection();
                BeanUtils.copyProperties(updateData, erpFunStreetSection);
                erpFunStreetSection.setShardCityId(cityId);
                erpFunStreetSection.setUpdateTime(new Date());
                erpFunStreetSection.setCompId(compId);
                if (reg != null) {
                    erpFunStreetSection.setStreetTerritoryId(reg.getStreetTerritoryId());
                    erpFunStreetSection.setStreetProvinceId(reg.getStreetProvinceId());
                    erpFunStreetSection.setStreetCityId(reg.getStreetCityId());
                }
                erpFunStreetSection.setStreetRegId(streetRegId);
                erpFunStreetSection.setSectionName(updateData.getName());
                erpFunStreetSectionMapper.updateByPrimaryKeySelective(erpFunStreetSection);
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                // 删除街道商圈
                ErpFunStreetInSectionExample streetSectionExample = new ErpFunStreetInSectionExample();
                streetSectionExample.setShardCityId(cityId);
                streetSectionExample.createCriteria().andStreetSectionIdEqualTo(id).andIsDelEqualTo(Byte.valueOf("0"));
                int countStreetSection = erpFunStreetInSectionMapper.countByExample(streetSectionExample);
                if (countStreetSection>0) {
                	throw new BusinessException("商圈下有关联的街道，不能删除！");
                }
                erpFunStreetSectionMapper.deleteStreetSectionById(cityId, compId, id, userId);
                // 该行政区下商圈与街道的关联
                ErpFunStreetInSectionExample inSectionExample = new ErpFunStreetInSectionExample();
                inSectionExample.setShardCityId(cityId);
                inSectionExample.createCriteria().andStreetSectionIdEqualTo(id);
                List<ErpFunStreetInSection> inSections = erpFunStreetInSectionMapper.selectByExample(inSectionExample);
                // 该行政区下的街道
                List<Integer> streetIds = inSections.stream().map(ErpFunStreetInSection::getStreetId).distinct().collect(Collectors.toList());

                // 删除街道行政区下关联的街道商圈
                ErpFunStreetInSection deleteInSection = new ErpFunStreetInSection();
                deleteInSection.setIsDel((byte) 1);
                deleteInSection.setDelUserId(userId);
                deleteInSection.setDelTime(new Date());
                ErpFunStreetInSectionExample deleteInSectionExample1 = new ErpFunStreetInSectionExample();
                deleteInSectionExample1.setShardCityId(cityId);
                deleteInSectionExample1.createCriteria().andStreetSectionIdEqualTo(id);
                erpFunStreetInSectionMapper.updateByExampleSelective(deleteInSection, deleteInSectionExample1);

                // 删除街道商圈下关联的街道
                if (CollectionUtils.isNotEmpty(streetIds)) {
                    ErpFunStreet street = new ErpFunStreet();
                    street.setIsDel((byte) 1);
                    street.setDelUserId(userId);
                    street.setDelTime(new Date());
                    ErpFunStreetExample streetExample = new ErpFunStreetExample();
                    streetExample.setShardCityId(cityId);
                    streetExample.createCriteria().andIdIn(streetIds);
                    erpFunStreetMapper.updateByExampleSelective(street, streetExample);
                }
            }
        }

        return ErpResponseJson.ok();
    }

    @ApiOperation("添加,编辑,删除街道维护的街道")
    @ApiResponses({@ApiResponse(code = 200, message = "success")})
    @PostMapping("/editStreet")
    @ResponseBody
    public ResponseJson editStreet(@Valid @RequestBody EditStreetDataParam param) {
        Integer cityId = getOperator().getCityId();
        Integer compId = getOperator().getCompId();
        Integer userId = getOperator().getUserId();

        // 1=新增 2=编辑 3=删除
        Byte type = param.getType();
        if (Byte.valueOf("1").equals(type)) {
            EditStreetDataParam.AddData addData = param.getAddData();
            
            if (addData != null) {
            	//一个街道必定会有行政区，但是可能不一定关联商圈，flj 2020-06-11修改
            	List<Integer> regIdList = Arrays.stream(addData.getRegIds().split(",")).map(Integer::valueOf).collect(Collectors.toList());
                // 一个街道有多个商圈, 但是都属于同一个城市
                List<Integer> sectionIdList = null;
                if (StringUtils.isNotBlank(addData.getSectionIds())) {
                	sectionIdList = Arrays.stream(addData.getSectionIds().split(",")).map(Integer::valueOf).collect(Collectors.toList());
                }
                if (CollectionUtils.isNotEmpty(regIdList)) {
                	ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                	regExample.setShardCityId(cityId);
                	regExample.createCriteria().andIdIn(regIdList);
                	List<ErpFunStreetReg> regList = erpFunStreetRegMapper.selectByExample(regExample);
            	    ErpFunStreet erpFunStreet = new ErpFunStreet();
                    BeanUtils.copyProperties(addData, erpFunStreet);
                    erpFunStreet.setShardCityId(cityId);
                    erpFunStreet.setCompId(compId);
                    // 街道城市的行政区ID, 多个商圈,行政区, 都属于同一个城市
                    ErpFunStreetReg reg = regList.get(0);
                    if (reg != null) {
                        erpFunStreet.setStreetTerritoryId(reg.getStreetTerritoryId());
                        erpFunStreet.setStreetProvinceId(reg.getStreetProvinceId());
                        erpFunStreet.setStreetCityId(reg.getStreetCityId());
                    }
                    erpFunStreet.setStreetName(addData.getName());
                    erpFunStreet.setCreateTime(new Date());
                    erpFunStreetMapper.insertSelective(erpFunStreet);
                    Integer streetId = erpFunStreet.getId();
                    
                    //生成行政区的关联
                    //判断生成商圈的关联
                    insertStreetRegSectionRelative(cityId, compId, streetId, regIdList, sectionIdList, regList);
                }
            }
        } else if (Byte.valueOf("2").equals(type)) {
            EditStreetDataParam.UpdateData updateData = param.getUpdateData();
            
            if (updateData != null) {
               	//一个街道必定会有行政区，但是可能不一定关联商圈，flj 2020-06-11修改
            	List<Integer> regIdList = Arrays.stream(updateData.getRegIds().split(",")).map(Integer::valueOf).collect(Collectors.toList());
                // 一个街道有多个商圈, 但是都属于同一个城市
                List<Integer> sectionIdList = null;
                if (StringUtils.isNotBlank(updateData.getSectionIds())) {
                	sectionIdList = Arrays.stream(updateData.getSectionIds().split(",")).map(Integer::valueOf).collect(Collectors.toList());
                }
                if (CollectionUtils.isNotEmpty(regIdList)) {
                	ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                	regExample.setShardCityId(cityId);
                	regExample.createCriteria().andIdIn(regIdList);
                	List<ErpFunStreetReg> regList = erpFunStreetRegMapper.selectByExample(regExample);
                	ErpFunStreetReg reg = regList.get(0);
                    ErpFunStreet erpFunStreet = new ErpFunStreet();
                    BeanUtils.copyProperties(updateData, erpFunStreet);
                    erpFunStreet.setShardCityId(cityId);
                    erpFunStreet.setUpdateTime(new Date());
                    erpFunStreet.setCompId(compId);
                    if (reg != null) {
                        erpFunStreet.setStreetTerritoryId(reg.getStreetTerritoryId());
                        erpFunStreet.setStreetProvinceId(reg.getStreetProvinceId());
                        erpFunStreet.setStreetCityId(reg.getStreetCityId());
                    }
                    erpFunStreet.setStreetName(updateData.getName());
                    erpFunStreetMapper.updateByPrimaryKeySelective(erpFunStreet);
                    // 删除掉无用的行政区和街道关联
                    ErpFunStreetInReg deleteCondition = new ErpFunStreetInReg();
                    deleteCondition.setShardCityId(cityId);
                    deleteCondition.setDelTime(new Date());
                    deleteCondition.setIsDel((byte) 1);
                    deleteCondition.setDelUserId(userId);
                    ErpFunStreetInRegExample deleteExample = new ErpFunStreetInRegExample();
                    deleteExample.setShardCityId(cityId);
                    deleteExample.createCriteria().andStreetIdEqualTo(updateData.getId());
                    erpFunStreetInRegMapper.updateByExampleSelective(deleteCondition, deleteExample);
                    // 删除掉无用的商圈和街道关联
                    ErpFunStreetInSection deleteCondition1 = new ErpFunStreetInSection();
                    deleteCondition1.setShardCityId(cityId);
                    deleteCondition1.setDelTime(new Date());
                    deleteCondition1.setIsDel((byte) 1);
                    deleteCondition1.setDelUserId(userId);
                    ErpFunStreetInSectionExample deleteExample1 = new ErpFunStreetInSectionExample();
                    deleteExample1.setShardCityId(cityId);
                    deleteExample1.createCriteria().andStreetIdEqualTo(updateData.getId());
                    erpFunStreetInSectionMapper.updateByExampleSelective(deleteCondition1, deleteExample1);
                    insertStreetRegSectionRelative(cityId, compId, updateData.getId(), regIdList, sectionIdList, regList);
                }
            }
        } else if (Byte.valueOf("3").equals(type)) {
            EditStreetDataParam.DeleteData deleteData = param.getDeleteData();
            if (deleteData != null) {
                Integer id = deleteData.getId();
                // 删除街道
                erpFunStreetMapper.deleteStreetById(cityId, compId, id, userId);
            }
        }

        return ErpResponseJson.ok();
    }

	private void insertStreetRegSectionRelative(Integer cityId, Integer compId,
			Integer streetId, List<Integer> regIdList, List<Integer> sectionIdList,
			List<ErpFunStreetReg> regList) {
		//判断生成商圈的关联
		if (CollectionUtils.isNotEmpty(regIdList)) {
		       List<ErpFunStreetInReg> inRegs = new ArrayList<>();
		       for (ErpFunStreetReg regInfo : regList) {
		    	   ErpFunStreetInReg erpFunStreetInReg = new ErpFunStreetInReg();
		    	   erpFunStreetInReg.setCompId(compId);
		    	   erpFunStreetInReg.setCreateTime(new Date());
		    	   erpFunStreetInReg.setStreetRegId(regInfo.getId());
		    	   erpFunStreetInReg.setStreetId(streetId);
		    	   inRegs.add(erpFunStreetInReg);
		       }
		       erpFunStreetInRegMapper.batchAddStreetInReg(cityId,inRegs);
		       // 添加街道与商圈的关联
		     //  erpFunStreetInSectionMapper.batchAddStreetInSection(cityId, inSections);
		}
		if (CollectionUtils.isNotEmpty(sectionIdList)) {
		    List<ErpFunStreetInSection> inSections = new ArrayList<>();
		    for (Integer streetSectionId : sectionIdList) {
		        ErpFunStreetInSection inSection = new ErpFunStreetInSection();
		        inSection.setCompId(compId);
		        inSection.setCreateTime(new Date());
		        inSection.setStreetSectionId(streetSectionId);
		        inSection.setStreetId(streetId);
		        inSections.add(inSection);
		    }
		    // 添加街道与商圈的关联
		    erpFunStreetInSectionMapper.batchAddStreetInSection(cityId, inSections);
		}
	}

    @ApiOperation("生成地区、省份、城市、区域、商圈、街道的唯一编码")
    @ApiResponses({@ApiResponse(code = 200, response = GenerateCodeVO.class, message = "success")})
    @PostMapping("/generateCode")
    @ResponseBody
    public ResponseJson generateCode(@Valid @RequestBody GenerateCodeParam param) {
        Integer cityId = getOperator().getCityId();
        // 生成什么层级的唯一编码 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区 5=街道商圈 6=街道
        Byte dataRange = param.getDataRange();
        // 地区：地区简称+001  如西南  xn001
        //省：省份简称+001 如四川省  sc001
        //市：省份简称+市简称+001    如成都市 sccd001
        //区：省份简称+市简称+区简称+001  如四川省成都市高新区 sccdgx001
        //街道：市简称+jd+0000001
        //商圈：市简称+sq+0000001
        String dataName = param.getDataName();

        if (StringUtils.isBlank(dataName)) {
            throw new BusinessException("简称不能为空！");
        }

        // 数据库当前数据的最大主键ID
        int maxId = 0;
        // 拼音首字母
        String headChar = "";

        switch (dataRange) {
            case 1: {
                maxId = erpFunTerritoryMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName);
                break;
            }
            case 2: {
                maxId = erpFunStreetProvinceMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName);
                break;
            }
            case 3: {
                maxId = erpFunStreetCityMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName);
                break;
            }
            case 4: {
                maxId = erpFunStreetRegMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName);
                break;
            }
            case 5: {
                maxId = erpFunStreetSectionMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName) + "sq";
                break;
            }
            case 6: {
                maxId = erpFunStreetMapper.getMaxId(cityId);
                headChar = StringUtil.getPinYinHeadChar(dataName) + "jd";
                break;
            }
            default: {

            }
        }

        String code = headChar + maxId;

        switch (dataRange) {
            case 1: {
                ErpFunTerritoryExample territoryExample = new ErpFunTerritoryExample();
                territoryExample.setShardCityId(cityId);
                territoryExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunTerritoryMapper.countByExample(territoryExample);
                if (count > 0) {
                    code = headChar + (maxId + 1);
                }
                break;
            }
            case 2: {
                ErpFunStreetProvinceExample provinceExample = new ErpFunStreetProvinceExample();
                provinceExample.setShardCityId(cityId);
                provinceExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunStreetProvinceMapper.countByExample(provinceExample);
                if (count > 0) {
                    code = headChar + (maxId + 1);
                }
                break;
            }
            case 3: {
                ErpFunStreetCityExample cityExample = new ErpFunStreetCityExample();
                cityExample.setShardCityId(cityId);
                cityExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunStreetCityMapper.countByExample(cityExample);
                if (count > 0) {
                    code = headChar + (maxId + 1);
                }
                break;
            }
            case 4: {
                ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
                regExample.setShardCityId(cityId);
                regExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunStreetRegMapper.countByExample(regExample);
                if (count > 0) {
                    code = headChar + (maxId + 1);
                }
                break;
            }
            case 5: {
                ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
                sectionExample.setShardCityId(cityId);
                sectionExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunStreetSectionMapper.countByExample(sectionExample);
                if (count > 0) {
                    code = headChar + (maxId + 1) ;
                }
                break;
            }
            case 6: {
                ErpFunStreetExample streetExample = new ErpFunStreetExample();
                streetExample.setShardCityId(cityId);
                streetExample.createCriteria().andCodeEqualTo(code).andIsDelEqualTo((byte) 0);
                long count = erpFunStreetMapper.countByExample(streetExample);
                if (count > 0) {
                    code = headChar + (maxId + 1);
                }
                break;
            }
            default: {

            }
        }

        GenerateCodeVO vo = new GenerateCodeVO();
        vo.setCode(code);
        return ErpResponseJson.ok(vo);
    }

    @ApiOperation("获取全国的省份列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunProvince.class, responseContainer = "List", message = "success")})
    @PostMapping("/getProvinceList")
    @ResponseBody
    public ResponseJson getProvinceList() {
        List<ErpFunProvince> provinces = erpFunProvinceMapper.getProvinceList(getOperator().getCityId());
        return ErpResponseJson.ok(provinces);
    }

    @ApiOperation("根据省份获取城市列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunCity.class, responseContainer = "List", message = "success")})
    @PostMapping("/getCityList")
    @ResponseBody
    public ResponseJson getCityList(@Valid @RequestBody IdParam param) {
        List<ErpFunCity> cities = erpFunCityMapper.getCityListByProvince(getOperator().getCityId(), String.valueOf(param.getId()));
        return ErpResponseJson.ok(cities);
    }

    @ApiOperation("根据城市获取行政区列表")
    @ApiResponses({@ApiResponse(code = 200, response = ErpFunReg.class, responseContainer = "List", message = "success")})
    @PostMapping("/getRegList")
    @ResponseBody
    public ResponseJson getRegList(@Valid @RequestBody IdParam param) {
        List<ErpFunReg> regs = erpFunRegMapper.getRegListByCityId(param.getId());
        regs = regs.stream().filter(it -> it.getVertifyFlag() != null && it.getVertifyFlag() == 1).collect(Collectors.toList());
        return ErpResponseJson.ok(regs);
    }

    @ApiOperation("街道名称模糊查询街道列表")
    @ApiResponses({@ApiResponse(code = 200, response = StreetListByNameVo.class, responseContainer = "List", message = "success")})
    @PostMapping("/getStreetListByName")
    @ResponseBody
    public ResponseJson getStreetListByName(@Valid @RequestBody StreetListByNameParam param) {
        Integer cityId = getOperator().getCityId();
        String streetName = param.getStreetName();

        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<ErpFunStreet> streets = erpFunStreetMapper.getStreetListByName(getOperator().getCityId(), getOperator().getCompId(), streetName);

        List<StreetListByNameVo> streetListByNameVo = new ArrayList<>();
        // 聚合城市、行政区、商圈信息
        if (CollectionUtils.isNotEmpty(streets)) {
            List<Integer> streetIds = streets.stream().map(ErpFunStreet::getId).collect(Collectors.toList());
            ErpFunStreetInSectionExample selectExample = new ErpFunStreetInSectionExample();
            selectExample.setShardCityId(cityId);
            selectExample.createCriteria().andStreetIdIn(streetIds).andIsDelEqualTo((byte) 0);
            List<ErpFunStreetInSection> inSections = erpFunStreetInSectionMapper.selectByExample(selectExample);
            // 所有的商圈信息
            List<ErpFunStreetSection> sectionInfos = new ArrayList<>();
            List<Integer> allSectionIds = inSections.stream().map(ErpFunStreetInSection::getStreetSectionId).distinct().collect(Collectors.toList());
            if (allSectionIds!=null && !allSectionIds.isEmpty()) {
            	ErpFunStreetSectionExample sectionExample = new ErpFunStreetSectionExample();
            	sectionExample.setShardCityId(cityId);
            	sectionExample.createCriteria().andIdIn(allSectionIds);
            	sectionInfos = erpFunStreetSectionMapper.selectByExample(sectionExample);
            }
            ErpFunStreetInRegExample selectRegExample = new ErpFunStreetInRegExample();
            selectRegExample.setShardCityId(cityId);
            selectRegExample.createCriteria().andStreetIdIn(streetIds).andIsDelEqualTo((byte) 0);
            List<ErpFunStreetInReg> inRegs = erpFunStreetInRegMapper.selectByExample(selectRegExample);

            // 行政区信息
            List<Integer> regIds = inRegs.stream().map(ErpFunStreetInReg::getStreetRegId).collect(Collectors.toList());
            ErpFunStreetRegExample regExample = new ErpFunStreetRegExample();
            regExample.setShardCityId(cityId);
            regExample.createCriteria().andIdIn(regIds);
            List<ErpFunStreetReg> regs = erpFunStreetRegMapper.selectByExample(regExample);

            for (ErpFunStreet street : streets) {
            	StreetListByNameVo byNameVo = new StreetListByNameVo();
                BeanUtils.copyProperties(street, byNameVo);
                // 该街道所属的所有商圈
                Integer streetId = street.getId();
                List<Integer> sectionIdList = inSections.stream().filter(it -> it.getStreetId().equals(streetId)).map(ErpFunStreetInSection::getStreetSectionId).collect(Collectors.toList());
                Set<Integer> regIdList = inRegs.stream().filter(it -> it.getStreetId().equals(streetId)).map(ErpFunStreetInReg::getStreetRegId).collect(Collectors.toSet());
                List<SectionVO> sectionVos = new ArrayList<>();
                
                if (CollectionUtils.isNotEmpty(sectionIdList)) {
                    for (Integer sectionId : sectionIdList) {
                        SectionVO sectionVO = new SectionVO();
                        Optional<ErpFunStreetSection> sectionOptional = sectionInfos.stream().filter(it -> sectionId.equals(it.getId())).findFirst();
                        if (sectionOptional.isPresent()) {
                            ErpFunStreetSection section = sectionOptional.get();
                            sectionVO.setStreetSectionId(section.getId());
                            sectionVO.setSectionName(section.getSectionName());

                            Integer currStreetRegId = section.getStreetRegId();
                            Optional<ErpFunStreetReg> regOptional = regs.stream().filter(it -> currStreetRegId.equals(it.getId())).findFirst();
                            if (regOptional.isPresent()) {
                                ErpFunStreetReg reg = regOptional.get();
                                regIdList.remove(reg.getId());
                                sectionVO.setStreetRegId(reg.getId());
                                sectionVO.setRegName(reg.getRegName());
                            }
                        }
                        sectionVos.add(sectionVO);
                    }
                }
                if (CollectionUtils.isNotEmpty(regIdList)) {
                	 for (Integer regId : regIdList) {
                         SectionVO sectionVO = new SectionVO();
                         Integer currStreetRegId = regId;
                         Optional<ErpFunStreetReg> regOptional = regs.stream().filter(it -> currStreetRegId.equals(it.getId())).findFirst();
                         if (regOptional.isPresent()) {
                             ErpFunStreetReg reg = regOptional.get();
                             sectionVO.setStreetRegId(reg.getId());
                             sectionVO.setRegName(reg.getRegName());
                             sectionVos.add(sectionVO);
                         }
                     }
                }
                byNameVo.setSections(sectionVos);
                streetListByNameVo.add(byNameVo);
            }
        }
        
        
        return ErpResponseJson.ok(streetListByNameVo);
    }

}

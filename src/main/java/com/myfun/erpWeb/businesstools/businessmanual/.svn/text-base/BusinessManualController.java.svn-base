package com.myfun.erpWeb.businesstools.businessmanual;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.erpWeb.businesstools.param.BizManualDataParam;
import com.myfun.erpWeb.businesstools.param.DeleteBizManalDataParam;
import com.myfun.erpWeb.businesstools.param.GetBizMnaualDataParam;
import com.myfun.erpWeb.businesstools.param.BizMnaualListParam;
import com.myfun.erpWeb.businesstools.vo.BizMnaualListVo;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpBuildingInfoMapper;
import com.myfun.repository.erpdb.dao.ErpBuildingSetMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunMenualMapper;
import com.myfun.repository.erpdb.dto.ErpDicDefinitionsDto;
import com.myfun.repository.erpdb.po.ErpDicDefinitions;
import com.myfun.repository.erpdb.po.ErpFunMenual;
import com.myfun.utils.DateTimeHelper;

/**
 * @author 方李骥
 * @since 2016年9月2日
 */
@RequestMapping(value = "/businesstools/businessManual", method = RequestMethod.POST)
@RestController
public class BusinessManualController extends BaseController {
	@Autowired
	ErpFunMenualMapper erpFunMenualMapper;
	@Autowired
	ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	ErpBuildingSetMapper erpBuildingSetMapper;
	@Autowired
	ErpDicDefinitionsMapper erpDicDefinitionsMapper;

	/**
	 * 获取业务手册列表
	 * 
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取业务手册列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BizMnaualListVo.class, message = "成功")
	})
	@RequestMapping("/getBizMnaualList")
	public ResponseJson getBizMnaualList(@Valid @RequestBody BizMnaualListParam param) throws Exception {
		String dicValue = param.getDicValue();
		List<ErpFunMenual> list = erpFunMenualMapper.getBizMnaualList(getOperator().getCityId(),
				getOperator().getCompId(), dicValue);
		return ErpResponseJson.ok(list);
	}

	/**
	 * 添加业务手册
	 * 
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("添加业务手册")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/insertBizManualData")
	public ResponseJson insertBizManualData(@Valid @RequestBody BizManualDataParam param) throws Exception {
		ErpFunMenual insertModel = new ErpFunMenual();
		insertModel.setShardCityId(getOperator().getCityId());
		insertModel.setDeptId(getOperator().getDeptId());
		insertModel.setDepartment(getOperator().getDeptName());
		insertModel.setCompId(getOperator().getCompId());
		insertModel.setUserId(getOperator().getUserId());
		insertModel.setMenualName(param.getMenualName());
		insertModel.setMenualType(param.getMenualType());
		insertModel.setMenualSourse(param.getMenualSourse());
		insertModel.setMenualContent(param.getMenualContent());
		String menualNo = param.getMenualNo() == null ? "" : param.getMenualNo();
		insertModel.setMenualNo(menualNo);
		insertModel.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunMenualMapper.insertSelective(insertModel);
		return ErpResponseJson.ok(insertModel.getMuId());
	}

	/**
	 * 更新业务手册
	 * 
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("更新业务手册")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/updateBizManualData")
	public ResponseJson updateBizManualData(@Valid @RequestBody BizManualDataParam param) throws Exception {
		ErpFunMenual insertModel = new ErpFunMenual();
		insertModel.setShardCityId(getOperator().getCityId());
		insertModel.setDeptId(getOperator().getDeptId());
		insertModel.setCompId(getOperator().getCompId());
		insertModel.setMuId(param.getMuId());
		insertModel.setMenualContent(param.getMenualContent());
		insertModel.setMenualName(param.getMenualName());
		insertModel.setMenualType(param.getMenualType());
		insertModel.setMenualSourse(param.getMenualSourse());
		String menualNo = param.getMenualNo() == null ? "" : param.getMenualNo();
		insertModel.setMenualNo(menualNo);
		erpFunMenualMapper.updateByPrimaryKeySelective(insertModel);
		return ErpResponseJson.ok(insertModel.getMuId());
	}

	/**
	 * 删除业务手册
	 * 
	 * @author 方李骥
	 * @since 2016年9月8日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("删除业务手册")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@RequestMapping("/deleteBizManalData")
	public ResponseJson deleteBizManalData(@Valid @RequestBody DeleteBizManalDataParam param) throws Exception {
		ErpFunMenual deleteModel = new ErpFunMenual();
		deleteModel.setShardCityId(getOperator().getCityId());
		deleteModel.setMuId(param.getMuId());
		erpFunMenualMapper.deleteByPrimaryKey(deleteModel);
		return ErpResponseJson.ok();
	}

	/**
	 * 获取详情
	 * 
	 * @author lcb
	 * @throws Exception
	 */
	@ApiOperation("获取详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = BizMnaualListVo.class, message = "成功")
	})
	@RequestMapping("/getBizMnaualData")
	public ResponseJson getBizMnaualData(@Valid @RequestBody GetBizMnaualDataParam param) {
		ErpFunMenual erpFunMenual = new ErpFunMenual();
		erpFunMenual.setShardCityId(getOperator().getCityId());
		erpFunMenual.setMuId(param.getMuId());
		ErpFunMenual erpFunMenualInfo = erpFunMenualMapper.selectByPrimaryKey(erpFunMenual);
		return ErpResponseJson.ok(erpFunMenualInfo);
	}

	/**
	 * 获取分类
	 * 
	 * @author lcb
	 * @throws Exception
	 */
	@RequestMapping("/getBizAllMnaualList")
	public ResponseJson getBizAllMnaualList(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		List<ErpDicDefinitionsDto> resList = new ArrayList<>();
		// 查询字典
		ErpDicDefinitions erpDicDefinitions = new ErpDicDefinitions();
		erpDicDefinitions.setDicType("MENUAL_TYPE");
		erpDicDefinitions.setShardCityId(operator.getCityId());
		List<ErpDicDefinitions> dicList = erpDicDefinitionsMapper.getDicDefinitionsByCondition(erpDicDefinitions);
		// 处理数据
		StringBuilder sb = new StringBuilder("");
		for (ErpDicDefinitions erpDicDefinitions1: dicList) {
			String dicValue = erpDicDefinitions1.getDicValue();
			sb.append(dicValue).append(",");
			ErpDicDefinitionsDto erpDicDefinitionsDto =new ErpDicDefinitionsDto();
			try {
				BeanUtils.copyProperties(erpDicDefinitionsDto, erpDicDefinitions1);
			}catch(Exception e) {

			}
			resList.add(erpDicDefinitionsDto);
		}
		String types="";
		if(sb.indexOf(",") > -1) {
			types = sb.substring(0, sb.length()-1);
		}
		// 查询FunMenual数据
		Map<String, Object> pMap = new HashedMap();
		pMap.put("compId", operator.getCompId());
		pMap.put("deptId", operator.getDeptId());
		pMap.put("menualTypes", types);
		List<ErpFunMenual> erpFunMenualList = erpFunMenualMapper.selectListByTypes(pMap, operator.getCityId());
		// 处理是否有子节点
		List<String> valueList = new ArrayList<>();
		for (ErpFunMenual erpFunMenual : erpFunMenualList) {
			valueList.add(erpFunMenual.getMenualType().toString());
		}
		for (ErpDicDefinitionsDto erpDicDefinitionsDto: resList ) {
			Integer count = 0;
			if(valueList.contains(erpDicDefinitionsDto.getDicValue())) {
				count = 1;
			}
			erpDicDefinitionsDto.setMenualCount(count);
		}
		return ErpResponseJson.ok(resList);
	}
}

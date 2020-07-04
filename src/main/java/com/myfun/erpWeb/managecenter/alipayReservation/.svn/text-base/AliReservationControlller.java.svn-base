package com.myfun.erpWeb.managecenter.alipayReservation;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.alipayReservation.param.GetReservationListParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpAliRenthouseReservationMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dto.ErpAliRenthouseReservationDto;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manageCenter/aliReservation/")
@Api(tags = "支付宝房源预约控制器", value = "alipayHouseBiz")
public class AliReservationControlller extends BaseController {
	
	@Autowired
	ErpAliRenthouseReservationMapper erpAliRenthouseReservationMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;

	/**
	 * 预约带看列表
	 * @author lcb
	 * @date 2018/7/5
	 * @return
	 */
	@ApiOperation(value = "查询预约带看列表")
	@ApiImplicitParam(dataTypeClass = BaseMapParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
		@ApiResponse(code = 0, message = "", response = ErpResponseJson.class)
	})
	@RequestMapping("/getReservationList")
	public ResponseJson getDaiKanList(@RequestBody GetReservationListParam param) throws Exception {
		Operator operator = getOperator();
		
		param.setCompId(operator.getCompId());
		param.setCityId(operator.getCityId());
		//param.setNewOrganization(operator.newOrganizationType());
		if(null != param.getOrganizationId() && 0 == param.getOrganizationId()) {
			param.setOrganizationId(null);
		}

		// 查询出分页列表再拼接房源数据
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpAliRenthouseReservationDto> resList = erpAliRenthouseReservationMapper.getReservationList(operator.getCityId(), param);

		// 拼接房源信息
		if(resList.size() > 0) {
			List<Integer> caseIds = resList.stream().collect(Collectors.mapping(val -> val.getCaseId(), Collectors.toList()));
			// 查询房源信息
			ErpFunLeaseExample example = new ErpFunLeaseExample();
			example.setShardCityId(operator.getCityId());
			example.createCriteria().andLeaseIdIn(caseIds);
			List<ErpFunLease> houseList = erpFunLeaseMapper.selectByExample(example);
			if(houseList.size() > 0) {
				Map<Integer, ErpFunLease> userMap = houseList.stream().collect(Collectors.toMap(ErpFunLease::getLeaseId, val -> val));

				resList.forEach(val-> {
					ErpFunLease erpFunLease = userMap.get(val.getCaseId());
					if(null != erpFunLease) {
						if(StringUtils.isNotBlank(erpFunLease.getThumbUrl())) {
							val.setThumbUrl(AppConfig.getPicDomainUrl() + erpFunLease.getThumbUrl());
						}
						val.setBuildName(erpFunLease.getBuildName());
						val.setBuildId(erpFunLease.getBuildId());
						val.setLeaseNo(erpFunLease.getLeaseNo());
						val.setSectionName(erpFunLease.getSectionName());
						val.setLeaseHall(erpFunLease.getLeaseHall());
						val.setLeaseRoom(erpFunLease.getLeaseRoom());
						val.setLeaseWei(erpFunLease.getLeaseWei());
						val.setLeaseArea(erpFunLease.getLeaseArea());
						val.setLeaseTotalPrice(erpFunLease.getLeaseTotalPrice());
						val.setPriceUnit(erpFunLease.getPriceUnit());
					}
				});
			}
		}
		return ErpResponseJson.ok(new PageInfo<>(resList));
	}
}

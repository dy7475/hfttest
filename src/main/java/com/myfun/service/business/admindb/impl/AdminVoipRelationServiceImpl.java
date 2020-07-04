package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminVoipRelationMapper;
import com.myfun.repository.admindb.po.AdminVoipRelation;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoipRelationService;
import com.myfun.utils.JsonHelper;
import com.myfun.utils.rest.Rest;

@Service
public class AdminVoipRelationServiceImpl extends AbstractService<AdminVoipRelation, String>implements AdminVoipRelationService {
	@Autowired
	private AdminVoipRelationMapper adminVoipRelationMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminVoipRelationMapper;
	}

	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public AdminVoipRelation createVoipRelationByMobile(String mobile) {
		String result = Rest.testfindClientByMobile(true, Rest.ACCOUNT_SID, Rest.AUTH_TOKEN, mobile, Rest.APP_ID);
		Map<String, Object> mapJson = (Map<String, Object>) JsonHelper.parseMap(result).get("resp");
		String respCode = (String) mapJson.get("respCode");
		String clientNumber = null;
		String clientPwd = null;

		// 查询成功
		if ("000000".equals(respCode)) {
			mapJson = (Map<String, Object>) mapJson.get("client");
			clientNumber = String.valueOf(mapJson.get("clientNumber"));
			clientPwd = (String) mapJson.get("clientPwd");
		} else if ("100007".equals(respCode)) {
			// 重新创建
			result = Rest.testCreateClient(true, Rest.ACCOUNT_SID, Rest.AUTH_TOKEN, Rest.APP_ID, mobile, "0", "0", mobile);
			mapJson = (Map<String, Object>) JsonHelper.parseMap(result).get("resp");
			respCode = (String) mapJson.get("respCode");

			if ("000000".equals(respCode)) {
				clientNumber = String.valueOf(mapJson.get("clientNumber"));
				clientPwd = String.valueOf(mapJson.get("clientPwd"));
			}
		}

		if (clientNumber != null && clientPwd != null) {
			AdminVoipRelation relation = new AdminVoipRelation();
			relation.setClientNumber(clientNumber);
			relation.setClientPwd(clientPwd);
			relation.setCreateTime(new Date());
			relation.setUserMobile(mobile);
			adminVoipRelationMapper.insertSelective(relation);
			return relation;
		}

		throw new RuntimeException("创建账户失败");
	}

	@Override
	public AdminVoipRelation getVoipRelationByNullCreate(String mobile) {
		AdminVoipRelation adminVoipRelation = adminVoipRelationMapper.selectByPrimaryKey(mobile);
		if (adminVoipRelation == null) {
			adminVoipRelation = createVoipRelationByMobile(mobile);
		}
		return adminVoipRelation;
	}

}

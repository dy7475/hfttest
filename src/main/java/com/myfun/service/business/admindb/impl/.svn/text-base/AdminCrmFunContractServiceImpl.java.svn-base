package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.admindb.dao.AdminCrmFunContractMapper;
import com.myfun.repository.admindb.dto.SoftContractDto;
import com.myfun.repository.admindb.po.AdminCrmFunContract;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminCrmFunContractService;
import com.myfun.utils.CommonUtil;
import com.myfun.utils.MD5Helper;
import com.myfun.utils.StringUtil;

@Service
public class AdminCrmFunContractServiceImpl extends AbstractService<AdminCrmFunContract, Integer>
        implements AdminCrmFunContractService {
    @Autowired
    AdminCrmFunContractMapper adminCrmFunContractMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminCrmFunContractMapper;
	}

	/**
	 * @author 邓永洪
	 * @tag 展示软件合同
	 * @since 2018/4/13
	 */
	@Override
	public SoftContractDto showSoftContract(Integer adminDeptId) {
		SoftContractDto softContractDto = adminCrmFunContractMapper.getSoftContract(adminDeptId);
		if (softContractDto == null) {
			return null;// throw new ConfirmException("请联系你的销售顾问生成合同!");
		}
		String token = new MD5Helper().getMD5ofStr(String.valueOf(adminDeptId));
		String param = "?deptId=" + adminDeptId + "&token=" + token;
		if (softContractDto != null && softContractDto.getWeiContractHtml() != null) {
			String weiContractHtml = softContractDto.getWeiContractHtml();
			String weiContractPath = softContractDto.getWeiContractPath();

			if (StringUtil.isNotEmpty(weiContractPath)) {
				String newPath = AppConfig.getCrmWebUrl() + weiContractPath;// MyfunComfigurationUtil.getCrmPrejectRoot()+"bizFRM/contract/template/"
				softContractDto.setWeiContractHtml(newPath + param);
			} else if (!CommonUtil.isnull(weiContractHtml)) {
				if (weiContractHtml.startsWith("/") || weiContractHtml.startsWith("\\")) {
					weiContractHtml = weiContractHtml.substring(1, weiContractHtml.length());
				}
				softContractDto
						.setWeiContractHtml((AppConfig.getPicDomainUrl() + weiContractHtml).replaceAll("\\\\", "/"));
			}
			// 做新老版合同兼容
			if (softContractDto != null && !CommonUtil.isnull(softContractDto.getContractVersion())) {
				String contractVersion = softContractDto.getContractVersion();
				contractVersion = AppConfig.getCrmWebUrl() + contractVersion;

				contractVersion = contractVersion + param;
				softContractDto.setContractVersion(contractVersion);
				softContractDto.setContractHtml(contractVersion);
				// 新安全协议路径
				String safetyPath = softContractDto.getSafetyPath();
				safetyPath = AppConfig.getCrmWebUrl() + safetyPath;

				safetyPath = safetyPath + param;
				softContractDto.setSafetyPath(safetyPath);
			} else {
				if (softContractDto != null && !CommonUtil.isnull(softContractDto.getContractHtml())) {
					String contractHtml = softContractDto.getContractHtml();
					if ((contractHtml.startsWith("/") || contractHtml.startsWith("\\"))
							&& AppConfig.getPicDomainUrl().endsWith("/")) {
						contractHtml = contractHtml.substring(1, contractHtml.length());
					}
					softContractDto.setContractHtml((StringUtil.getPhotoUrl(contractHtml)).replaceAll("\\\\", "/"));
				}
				if (softContractDto != null && !CommonUtil.isnull(softContractDto.getSafetyPath())) {
					String safetyPath = softContractDto.getSafetyPath().split("\\|")[0];
					if ((safetyPath.startsWith("/") || safetyPath.startsWith("\\"))
							&& AppConfig.getPicDomainUrl().endsWith("/")) {
						safetyPath = safetyPath.substring(1, safetyPath.length());
					}
					softContractDto.setSafetyPath((StringUtil.getPhotoUrl(safetyPath)).replaceAll("\\\\", "/"));
				}
			}
		}
		return softContractDto;
	}
}

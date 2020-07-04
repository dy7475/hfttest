package com.myfun.service.business.admindb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunMacMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminFunDatasourceConfig;
import com.myfun.repository.admindb.po.AdminFunMac;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.utils.LoadBalanceHelper;
import com.myfun.utils.StringUtil;

@Service
public class AdminSysParaServiceImpl extends AbstractService<AdminSysPara, String>implements AdminSysParaService {
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunMacMapper adminFunMacMapper;
	@Autowired
	private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminSysParaMapper;
	}

	/**
	 * @see AdminSysParaService#getErpDownloadDirectory(String)
	 */
	@Override
	public String getErpDownloadDirectory(String version) {
		// 判断是否已经缓存域名
		if (LoadBalanceHelper.erpIsEmpty()) {
			// 初始化域名
			AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("ERP_UPGRADE_DOWNLOAD_DIRECTORY");
			LoadBalanceHelper.initErp(adminSysPara.getParamValue());
		}
		return LoadBalanceHelper.getErpOptimalDomain() + "/" + version + "/";
	}

	/**
	 * @see AdminSysParaService#getPerDownloadDirectory(String)
	 */
	@Override
	public String getPerDownloadDirectory(String version) {
		// 判断是否已经缓存域名
		if (LoadBalanceHelper.perIsEmpty()) {
			// 初始化域名
			AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("PER_UPGRADE_DOWNLOAD_DIRECTORY");
			LoadBalanceHelper.initPer(adminSysPara.getParamValue());
		}
		return LoadBalanceHelper.getPerOptimalDomain() + "/" + version + "/";
	}

	/**
	 * @see AdminSysParaService#getPersonVersion()
	 */
	@Override
	public Map<Object, Object> getPersonVersion() {
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("PER_UPGRADE_VERSION_last_version");
		retMap.put("result", "success");
		retMap.put("msg", "查找成功");
		retMap.put("md5", adminSysPara.getParamValue());
		retMap.put("version", "last_version");
		return retMap;
	}

	/**
	 * @see AdminSysParaService#getErpVersion(String)
	 */
	@Override
	public Map<Object, Object> getErpVersion(String mac) {
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		retMap.put("result", "success");
		retMap.put("msg", "查找成功");

		// 如果没有mac则获取最新版本
		if (StringUtil.isEmpty(mac)) {
			AdminSysPara lastVersionParam = adminSysParaMapper.selectByPrimaryKey("ERP_UPGRADE_VERSION_LAST_VERSION");
			AdminSysPara lastMd5Param = adminSysParaMapper.selectByPrimaryKey("ERP_UPGRADE_VERSION_LAST_VERSION");
			retMap.put("version", lastVersionParam.getParamValue());
			retMap.put("md5", lastMd5Param.getParamValue());

		} else {
			// 如果有mac 则判断当前mac的当前公司 应该升级到那个版本
			AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(mac);
			if (adminFunMac == null) {
				retMap.put("result", "faile");
				retMap.put("msg", "请先注册用户");

			} else {
				AdminFunDatasourceConfig datasourceConfig = adminFunDatasourceConfigMapper
						.selectByPrimaryKey(adminFunMac.getCompId());
				if (datasourceConfig == null) {
					retMap.put("result", "faile");
					retMap.put("msg", "没有找到当前公司对应的连接");

				} else {
					String version = datasourceConfig.getEnterpriseVesion();
					if (StringUtil.isEmpty(version)) {
						AdminSysPara lastVersionParam = adminSysParaMapper.selectByPrimaryKey("ERP_UPGRADE_VERSION_LAST_VERSION");
						AdminSysPara lastMd5Param = adminSysParaMapper.selectByPrimaryKey("ERP_UPGRADE_VERSION_LAST_VERSION");
						retMap.put("version", lastVersionParam.getParamValue());
						retMap.put("md5", lastMd5Param.getParamValue());

					} else {
						// 根据版本获取响应的md5
						String md5Param = "ERP_UPGRADE_MD5_" + version;
						AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey(md5Param);
						if (adminSysPara == null) {
							retMap.put("result", "faile");
							retMap.put("msg", "查找" + version + " 1版本的MD5码失败");

						} else {
							retMap.put("result", "success");
							retMap.put("md5", adminSysPara.getParamValue());
							retMap.put("version", version);

						}
					}
				}
			}
		}
		return retMap;
	}

	/**
	 * @see AdminSysParaService#getErpDownloadDirectoryByHXS()
	 */
	@Override
	public String getErpDownloadDirectoryByHXS() {
		// 判断是否已经缓存域名
		if (LoadBalanceHelper.hxsErpIsEmpty()) {
			// 初始化域名
			AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("ERP_DOWNLOAD_DIRECTORY_BY_HXS");
			LoadBalanceHelper.initHxsErp(adminSysPara.getParamValue());
		}
		return LoadBalanceHelper.getHxsErpDownloadDirectory();
	}

	@Override
	public String getPerDownloadDirectoryByHXS() {
		// 判断是否已经缓存域名
		if (LoadBalanceHelper.hxsPerIsEmpty()) {
			// 初始化域名
			AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("PER_DOWNLOAD_DIRECTORY_BY_HXS");
			LoadBalanceHelper.initHxsPer(adminSysPara.getParamValue());
		}
		return LoadBalanceHelper.getHxsPerDownloadDirectory();
	}

	/**
	 * @see AdminSysParaService#getSysParamToString(String)
	 */
	@Override
	public String getSysParamToString(String paramId) {
		AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey(paramId);
		if (adminSysPara != null) {
			return adminSysPara.getParamValue();
		}
		return null;
	}

	@Override
	public List<AdminSysPara> query() {
		List<AdminSysPara> list = adminSysParaMapper.query();
		return list;
	}

	@Override
	public void saveSysParam(String id, HttpServletRequest request) {
		String ids[] = id.split(",");
		
		for(int i = 0 ; i < ids.length; i++){
			String paramId = ids[i];
  			String value = request.getParameter(paramId);
  			AdminSysPara adminSysPara = new AdminSysPara();
  			adminSysPara.setParamId(paramId);
  			adminSysPara.setParamValue(value);
  			adminSysParaMapper.updateByPrimaryKeySelective(adminSysPara);
		}
	}

	@Override
	public Map<String, String> getAdminSysPara(String[] paramIds) {
		List<AdminSysPara> adminSysParas = adminSysParaMapper.getAdminSysPara(paramIds);
		Map<String, String> resultMap = new HashMap<>();
		for (AdminSysPara adminSysPara : adminSysParas) {
			resultMap.put(adminSysPara.getParamId(), adminSysPara.getParamValue());
		}
		return resultMap;
	}

}

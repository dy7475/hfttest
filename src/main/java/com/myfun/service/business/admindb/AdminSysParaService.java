package com.myfun.service.business.admindb;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminSysParaService extends BaseMapper<AdminSysPara, String> {
	/**
	 * 根据版本获取下载目录 实现简单负载均衡
	 * 
	 * @param version
	 *            版本号
	 * @return
	 */
	public String getErpDownloadDirectory(String version);

	/**
	 * 获取精英版下载目录 实现简单负载均衡
	 * 
	 * @param version
	 * @return
	 */
	public String getPerDownloadDirectory(String version);

	/**
	 * 获取精英版版本
	 * 
	 * @return
	 */
	public Map<Object, Object> getPersonVersion();

	/**
	 * 根据mac地址获取企业版版本
	 * 
	 * @param mac
	 * @return
	 */
	public Map<Object, Object> getErpVersion(String mac);

	public String getErpDownloadDirectoryByHXS();

	public String getPerDownloadDirectoryByHXS();
	
	public String getSysParamToString(String paramId);
	
	/**
	 * 查询全部系统参数
	 * @return
	 */
	public List<AdminSysPara> query();
	
	/**
	 * 保存系统参数
	 * @param compId
	 * @param rquestNames
	 * @param request
	 */
	public void saveSysParam(String ids, HttpServletRequest request);
	/**
	 * 普通的弹窗广告
	 * @author 何传强
	 * @since 2017年6月27日
	 * @param paramIds
	 * @return
	 */
	public Map<String, String> getAdminSysPara(String[] paramIds);

}

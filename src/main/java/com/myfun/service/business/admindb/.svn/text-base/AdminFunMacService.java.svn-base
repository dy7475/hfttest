package com.myfun.service.business.admindb;

import java.util.Map;

import com.myfun.repository.admindb.dto.AdminFunMacDto;
import com.myfun.repository.admindb.po.AdminFunMac;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunMacService extends BaseMapper<AdminFunMac, String> {
	/**
	 * 判断当前mac地址是否可以登录
	 * 
	 * @param mac
	 *            登录mac
	 * @param routMac
	 *            登录routMac
	 * @return 返回null说明 没有找到对应的mac记录<br/>
	 *         返回空map说明 当前登录mac没有被限制登录 <br/>
	 *         返回有数据map则根据返回类型 进行相应的逻辑处理
	 */
	public Map<Object, Object> isLoginByMac(String mac, String routMac);

	/**
	 * 在没有获取到用户mac的情况 则根据routMac判断是否自动进入注册逻辑
	 * 
	 * @param routMac
	 * @return 返回空集合则没有限值直接查询用户信息<br/>
	 *         如果返回非空集合说明被限制 则提醒用户
	 */
	public Map<Object, Object> isLoginByRoutMac(String routMac);

	/**
	 * 重置注册信息 直接清空fun_mac上的公司和门店信息
	 * 
	 * @param macAddr
	 * @return
	 */
	public boolean resetRegisterInfoByMac(String macAddr);

	/**
	 * 根据mac删除注册信息 清除本地和admin库 增加门店注册数量
	 * 
	 * @param nacAddr
	 * @return
	 */
	public boolean deleteRegisterInfoByMac(String macAddr);
	
	/**
	 * 根据macAddr获取compNo
	 * @param macAddr
	 * @return
	 */
	public String getCompNoByMacAddr(String macAddr);
	
	/**
	 * 获取门店和门店用户列表
	 * @param routemac
	 * @return
	 */
	public Map<Object, Object> getDeptAndUserList(String mac, String routMac, String lineType);
	
	/**
	 * 本次是否是漫游
	 * @param mac
	 * @return
	 */
	public boolean isRoam(String mac, String routMac);
	
	/**
	 * 修正MAC地址
	 * @param macAddr
	 * @return
	 */
	public String updateResiveMAC(String macAddr);

	AdminFunMacDto getCompInfoByMacAddr(String macAddr);

    void updateMgrchgCruise(Integer cityId, Integer compId, Integer roamUserId, String roam, String macaddr);

	Boolean getRoamCountIsMax(Integer cityId, Integer compId, Integer deptId);

	void updateMacInfoByMacAddrWithAdminDb(Integer cityId, Boolean roam, Integer roamUserId, String macaddr);
}

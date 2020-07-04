package com.myfun.service.business.admindb;

import java.util.List;
import java.util.Map;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dto.AdminFunUsersAccountDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunUserAccountService extends BaseMapper<AdminFunUserAccount, Integer> {

	public String clearCompData(String dempName);

	/**
	 * 统计查询
	 * 
	 * @param faaType
	 * @param adminPaidCountParam
	 * @param currentPage
	 * @return
	 */
	public List<AdminFunUsersAccountDto> selectByTypeAndOther(AdminPaidCountParam adminPaidCountParam);

	/**
	 * 检查账户余额是否足够
	 * 
	 * @param archiveId
	 * @param money
	 * @param isUseCompMoney
	 * @return
	 */
	@Deprecated
	public boolean checkBalance(int archiveId, double money, boolean isUseCompMoney);

	/**
	 * 检查账户余额是否足够 IP电话调用 <br/>
	 * --检查个人是否有资金账户并且个人账户必须大于0<br/>
	 * --判断公司和个人额度是否足够<br/>
	 * 
	 * @param archiveId
	 * @param money
	 * @param isUseCompMoney
	 * @return compPrice 10 --personalPrice 12 status 0 未通过  1 通过 2 未绑定资金账号 compUaId 公司资金账户  personalUaId 个人自己账户
	 */
	Map<String, String> checkVoipUseCompMoney(int archiveId, double money, boolean isUseCompMoney);

	/**
	 * 扣除voip拨号消费好房币<br/>
	 * 
	 * @param archiveId
	 *            扣除账户
	 * @param money
	 *            金额
	 * @param isUseCompMoney
	 *            是否抵扣公司账户
	 * @return --compPrice 10 --personalPrice 12 status 0 未通过  1 通过
	 */ 
	Map<String, String> deductVoipUseCompMoney(int archiveId, double money, boolean isUseCompMoney);

	/**
	 * 查询账户信息
	 * **/
	public AdminFunUserAccount selectAccountByArchiveId(Integer archiveId);

	/**
	 * 资金账户检查扣费 并存放总金额
	 * **/
    Integer checkSendSMSAndCharge(Integer i,BaseMapParam param) throws Exception;

    Map<String,String> getBiddPrice(String uaId, String compUaId, Boolean isPerLogin, Integer cityId, Integer compId, Double currMoney) throws Exception;
    
	public void createByCreateUser(ErpFunUsers erpFunUsers);

	/**
	 * 执行竞价扣费
	 * @author ZangTie
	 * @since 2018年7月20日 下午4:12:05
	 * @param uaId=个人资金账户ID
	 * @param compUaId=公司资金账户ID
	 * @param isPerLogin=是否是精英版
	 * @param cityId=城市ID
	 * @param compId=公司ID
	 * @param newBiddPirce=本次出价
	 * @param historyPrice=历史出价 没有历史出价的情况下该值为：0
	 * @param biddType=BUILD、HOUSE
	 * @param superUser
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 */
	public Map<String, String> updateBuildBiddPrice(Map<String, String> operatorMap, Boolean isPerLogin, double newBiddPirce, double historyPrice, String biddType) throws Exception;
	
	/**
	 * 查询可用推广返现
	 * @param archiveId
	 * @return
	 */
	public String getAvailableShareMoney(Integer archiveId);
}

package com.myfun.repository.admindb.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.myfun.repository.admindb.dto.AdminFunUsersAccountDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunUserAccountMapper extends BaseMapper<AdminFunUserAccount, Integer> {

	public void updatePhoneNum(Map<String, Object> map);

	/**
	 * @param userMobile
	 * @return
	 * 
	 */
	public AdminFunUserAccount selectByUserMoblie(String userMobile);
	
	/**
	 * 查询余额
	 * @return
	 */
	public AdminFunUserAccount getAmountByArchiveId(Integer aid);
	
	/**
	 * 扣费
	 * @param price
	 * @param uaid
	 */
	public void updateAmountAndConsumpt(@Param("price")float price, @Param("uaid")Integer uaid);
	
	/**
	 * 修改积分记录
	 * @param score
	 * @param aid
	 */
	public void updateScore(@Param("score")float score, @Param("aid")Integer aid);

	public Double getScoreByArchiveId(Integer archivedId);
	
	/**
	 * 删除公司资金帐户
	 */
	public void deleteUaIdByCompId(Integer compId);
	
	/**
	 * 统计帐户余额
	 * @param adminPaidCountParam
	 */
	public AdminPaidCountDto sumAmount(AdminPaidCountParam adminPaidCountParam);
	
	/**
	 * 查询账户统计详细
	 * @param faaType
	 * @param adminPaidCountParam
	 * @return
	 */
	public Page<AdminFunUsersAccountDto> selectByTypeAndOther(AdminPaidCountParam adminPaidCountParam);

	public int updateHaoFangAmount(Integer uaId);

	/**
	 * @param compLimitPrice
	 * @param uaIdComp
	 * @return
	 */
	public AdminFunUsersAccountDto getUsableCompPrice(@Param("compLimitPrice") double compLimitPrice, @Param("uaId") Integer uaId);

	/**
	 * @param uaId
	 * @param usedCompAmount
	 */
	public void updateUsedCompHf(@Param("uaId") Integer uaId, @Param("usedCompAmount") double usedCompAmount);

	/**
	 * @param compLimitPrice
	 * @param uaIdComp
	 * @return
	 */
	public AdminFunUsersAccountDto getVoipUsableCompPrice(@Param("compLimitPrice") double compLimitPrice, @Param("uaId") Integer uaId);
	
	/**
	 * @param uaId
	 * @param usedCompAmount
	 */
	public void updateVoipUsedCompHf(@Param("uaId") Integer uaId, @Param("voipUsedCompAmount") double voipUsedCompAmount);
	
	/**
	 * @param sendWxQuan
	 * @param sendBuyQuan
	 * @param compUaid
	 */
	public void updateSendGift(@Param("sendWxQuan") Integer sendWxQuan, @Param("sendBuyQuan") Integer sendBuyQuan, @Param("compUaid") Integer compUaid);
	
	/**
	 * 查询账户
	 * **/
	public AdminFunUserAccount getAccountByArchiveId(Integer archiveId);
	
	/**
	 * 扣资金账户上的钱
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param subPrice 扣多少
	 * @param uaId 资金账户ID
	 * @return
	 */
	public int subtractMoney(@Param("subPrice")double subPrice,@Param("uaId") int uaId);

    Map<String,Object> queryMoneyIsEnough(@Param("biddPrice")String biddPrice, @Param("uaId")String uaId);

    /**
     * 通过条件扣除公司资金账户相应金额
     * @author ZangTie
     * @since 2018年7月20日 下午5:46:28
     * @param compUaId=公司资金账户ID
     * @param biddPrice=扣除费用
     * @param biddType： "BUILD"=1  "HOUSE"=2
     * Modified XXX ZangTie 2018年7月20日
     */
	public void updateHaoFangAmountByBiddType(@Param("uaId")String uaId, @Param("biddPrice")double biddPrice, @Param("biddType")Integer biddType);

	/**
	 * 更新已经使用公司好房币+优惠券的额度
	 * @author ZangTie
	 * @since 2018年7月20日 下午6:01:59
	 * @param uaId=个人资金账户ID
	 * @param biddPrice=扣除费用
	 * Modified XXX ZangTie 2018年7月20日
	 */
	public void updateUsedCompHfByUaId(@Param("uaId")String uaId,  @Param("biddPrice")double biddPrice);

	/**
	 * 当购买好房币已经大于优惠券和好房币之和时，更新好房币
	 * @author ZangTie
	 * @since 2018年7月20日 下午6:04:52
	 * @param uaId=个人资金账户ID
	 * Modified XXX ZangTie 2018年7月20日
	 */
	public void updateHaoFangBuyByUaId(@Param("uaId")String uaId);
	Integer updateGift4HfAmount(@Param("sendHfQuan") Integer sendHfQuan, @Param("uaId") Integer uaId);
	public int updateShareMoney(Integer uaId);

	/**
	 * 充值好房豆，直接减，扣多少、够不够外面计算好
	 * @author 张宏利
	 * @since 2018年7月5日
	 * @param uaId 资金账户ID
	 * @param totalMoney 扣减金额
	 * @param deductCompMoney
	 */
	void rechargeHaofangAmount(@Param("uaId") Integer uaId, @Param("deductMoney") Double deductMoney);
}
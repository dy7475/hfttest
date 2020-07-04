package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyVipBuyDto;
import com.myfun.repository.agencydb.dto.AgencyVipBuyListDto;
import com.myfun.repository.agencydb.param.AgencyVipBuyParam;
import com.myfun.repository.agencydb.param.AgencyVipBuyParam4Create;
import com.myfun.repository.agencydb.po.AgencyVipBuy;
import com.myfun.repository.agencydb.po.AgencyVipBuyKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.repository.agencydb.po.AgencyVipBuyExample;

public interface AgencyVipBuyMapper extends BaseMapper<AgencyVipBuy, AgencyVipBuyKey> {

	/**
	 * 获取求购列表
	 * 
	 * @param vipBuyParam
	 * @return
	 */
	public List<AgencyVipBuyDto> getAgencyVipBuyDtoList(AgencyVipBuyParam vipBuyParam);

	/**
	 * 获取信息ID
	 * 
	 * @return
	 */
	public Integer getId();

	/**
	 * 创建求购信息
	 * 
	 * @param agencyVipBuyParam
	 */
	public void createRecord(AgencyVipBuyParam4Create agencyVipBuyParam);

	/**
	 * 获取对应的agency信息
	 * 
	 * @param hftCityId
	 * @param ugcId
	 * @return
	 */
	public AgencyVipBuy selectByCityIdAndUgcId(@Param("hftCityId") Short hftCityId, @Param("ugcId") Integer ugcId);
	
	/**
	 * 查询优优委托数据
	 * @author 陈文超
	 * @date 2016年6月17日 下午5:27:29
	 */
	List<AgencyVipBuy> getYouYouEntrustInfoList(@Param("caseIds")List<Integer> caseIds,@Param("cityId")Short cityId) throws Exception;
	
	/**
	 * 获取搜搜求购列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<AgencyVipBuyListDto> getSoSoBuyList(DaoBaseParam param);

	
	/**
	 * 获取搜搜求购已查看列表
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 */
	public List<AgencyVipBuyListDto> getVipBuyViewedList(DaoBaseParam param);

	AgencyVipBuyDto getVipBuyById(@Param("buyId")Integer buyId, @Param("cityId")Integer cityId);

	public AgencyVipBuy getVipBuyInfoByCaseId(@Param("cityId")Integer cityId,@Param("caseId")String caseId);

}
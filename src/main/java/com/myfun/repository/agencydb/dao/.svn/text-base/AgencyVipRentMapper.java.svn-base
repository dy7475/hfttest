package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyVipLeaseDto;
import com.myfun.repository.agencydb.dto.AgencyVipRentDto;
import com.myfun.repository.agencydb.param.AgencyVipRentParam;
import com.myfun.repository.agencydb.param.AgencyVipRentParam4Create;
import com.myfun.repository.agencydb.po.AgencyVipRent;
import com.myfun.repository.agencydb.po.AgencyVipRentKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.repository.agencydb.po.AgencyVipRentExample;

public interface AgencyVipRentMapper extends BaseMapper<AgencyVipRent, AgencyVipRentKey> {
	/**
	 * 求租信息列表查询
	 * 
	 * @param vipRentParam
	 * @return
	 */
	List<AgencyVipRentDto> getAgencyVipRentDtoList(AgencyVipRentParam vipRentParam);

	/**
	 * 获取ID
	 * 
	 * @return
	 */
	Integer getId();

	/**
	 * 求租信息保存
	 * 
	 * @param vipRentParam
	 */
	void createRecord(AgencyVipRentParam4Create vipRentParam);

	/**
	 * 获取求租信息
	 * 
	 * @param hftCityId
	 * @param fid
	 * @return
	 */
	AgencyVipRent selectByCityIdAndUgcId(@Param("hftCityId") Short hftCityId, @Param("fid") Integer fid);
	
	/**
	 * 查询优优委托数据
	 * @author 陈文超
	 * @date 2016年6月17日 下午5:27:29
	 */
	List<AgencyVipRent> getYouYouEntrustInfoList(@Param("caseIds")List<Integer> caseIds,@Param("cityId")Short cityId) throws Exception;
	
	/**
	 * 获取搜搜求租
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	List<AgencyVipLeaseDto> getSoSoRentList(DaoBaseParam param);

	/**
	 * 获取搜搜求租已看列表
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	List<AgencyVipLeaseDto> getVipRentViewedList(DaoBaseParam param);

	AgencyVipRentDto getVipRentById(@Param("rentId")Integer caseId, @Param("cityId")Integer cityId);

	AgencyVipRent getVipBuyInfoByCaseId(@Param("cityId")Integer cityId, @Param("caseId")String caseId);
}
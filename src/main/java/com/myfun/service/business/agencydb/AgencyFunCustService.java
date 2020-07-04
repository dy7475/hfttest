package com.myfun.service.business.agencydb;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.AgencyCommisionDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustCountDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustDto;
import com.myfun.repository.agencydb.param.AgencyFunCustParam;
import com.myfun.repository.agencydb.po.AgencyCommisionParam;
import com.myfun.repository.agencydb.po.AgencyFunCust;
import com.myfun.repository.agencydb.po.AgencyFunCustKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCustService extends BaseMapper<AgencyFunCust, AgencyFunCustKey>{

	PageInfo<AgencyFunCustDto> getFunCustList(AgencyFunCustParam agencyFunCustParam);

	AgencyFunCust getFunCusByCondition(Integer custId, Integer cityId);
	
	/**
	 * 获取客户
	 * @param custId
	 * @return
	 */
	AgencyFunCust getRecord(String custId);

	AgencyFunCustCountDto getCountByBuildIdAndCityId(Integer buildId,Integer cityId, String dateTime);
	
	/**
	 * 查询佣金管理列表
	 * @param agencyCommisionParam
	 * @return
	 */
	PageInfo<AgencyCommisionDto> getCommisionList(AgencyCommisionParam agencyCommisionParam);
	
	/**
	 * 获取佣金详细
	 * @param cityId
	 * @param custId
	 * @return
	 */
	AgencyFunCustDto getCommisionView(String cityId, String custId);
	
	/**
	 * 修改佣金
	 * @param cityId
	 * @param custId
	 * @param oldCustStatus
	 * @param custStatus
	 * @param paidAmount
	 * @param content
	 * @return
	 */
	int saveComision(AdminCrmUser adminCrmUser, String cityId, String custId, String oldCustStatus, String custStatus, String paidAmount,
			String content, String custMobile);

	/**
	 * @TODO 新房联动,我的客户数据
	 * @author lcb
	 * @2016-8-31 下午6:17:37
	 */
	Map<String, String> getDistCountCustInfo(BaseMapParam param);

	/**
	 * @TODO 业绩趋势图数据
	 * @author lcb
	 * @2016-9-2 下午5:45:29
	 */
	Map<String, String> getDistCountOfferToBuy(BaseMapParam param);

	/**
	 * @TODO 查询报备客户
	 * @author lcb
	 * @2016-9-5 上午10:46:34
	 */
	List<AgencyFunCust> getDistCustList(BaseMapParam param);

	Map<String, String> getDistCountBorkerAmmount(BaseMapParam param);

	/**
	 * @TODO 近一年的收入趋势
	 * @author lcb
	 * @2016-9-7 上午9:44:06
	 */
	Map<String, String> getDistCountMoneyOfYear(BaseMapParam param);

	Map<String, Object> getDistPersonalData(BaseMapParam param);

	/**
	 * @TODO 佣金明细列表查询
	 * @author lcb
	 * @2016-9-18 上午11:14:45
	 */
	Map<String, Object> getDistCustDealList(BaseMapParam param);

	/**
	 * @TODO 分销客户列表查询
	 * @author lcb
	 * @2016-9-21 下午5:19:19
	 */
	PageInfo<AgencyFunCustDto> getFunCustList(BaseMapParam param);

	PageInfo<AgencyFunCust> getDistFunCustTrackList(BaseMapParam param);

	/**
	 * @TODO 分销楼盘分销客户详情
	 * @author lcb
	 * @2016-9-24 下午2:03:32
	 */
	AgencyFunCustDto getFunCustDetail(BaseMapParam param, Integer cityId);

	/**
	 * @TODO 修改客户状态
	 * @author lcb
	 * @throws Exception 
	 * @2016-10-9 下午5:29:54
	 */
	Integer updateDistFunCust(BaseMapParam param) throws Exception;

	Integer transferDistFunCust(BaseMapParam param) throws Exception;

	/**
	 * @TODO 电话判重
	 * @author lcb
	 * @2016-10-12 下午4:38:39
	 */
	Integer checkDistMobileRepreated(BaseMapParam param);

	/**
	 * @TODO 报废客户
	 * @author lcb
	 * @2016-10-12 下午5:27:41
	 * @throws Exception 
	 */
	Integer createDistCust(BaseMapParam param) throws Exception;

	/**
	 * @TODO 我的客户 -管理-客户详情
	 * @author lcb
	 * @2016-10-14 下午2:10:13
	 */
	AgencyFunCustDto getDistCustInfo(BaseMapParam param);

}


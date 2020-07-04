package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpLeasePeopleRelative;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;

public interface ErpLeasePeopleRelativeService extends BaseMapper<ErpLeasePeopleRelative, ErpLeasePeopleRelative>{
	public void updateErpLeasePeopleRelative(HousePeopleRelativeParam param);
	/**
	 * 创建房源相关人
	 * @author 熊刚
	 * @since 2017年10月17日
	 * @param id
	 * @param userId
	 * @param houseRelativeType
	 * @param entrustType
	 * @throws Exception
	 */
	public void insertLeasePeopleRelative(Integer cityId,Integer caseId,Integer userId,Integer houseRelativeType,String entrustType);
	
	/**
	 * 转私盘时变更租维护人
	 * @author 朱科
	 * @since 2018/4/19
	 */
	public void privatePlateUpdatePeopleRelative(Integer cityId, Integer leaseId, Integer userId, String userName, String userMobile, String deptName);
	
	/**
	 * 转出租时变更租维护人、租登记人
	 * @author 朱科
	 * @since 2018/5/4
	 */
	public void transLeaseUpdateRegisterPeopleRelative(Integer cityId, Integer leaseId, Integer userId, String userName, String userMobile, String deptName);
}

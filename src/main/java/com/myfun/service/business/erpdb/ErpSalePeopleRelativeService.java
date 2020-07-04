package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpSalePeopleRelative;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.HousePeopleRelativeParam;

public interface ErpSalePeopleRelativeService extends BaseMapper<ErpSalePeopleRelative, ErpSalePeopleRelative> {
	public void updateHousePeopleRelative(HousePeopleRelativeParam param);
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
	public void insertSalePeopleRelative(Integer cityId,Integer caseId,Integer userId,Integer houseRelativeType,String entrustType);
	
	/**
	 * 转私盘时变更售维护人
	 * @author 朱科
	 * @since 2018/4/19
	 */
	public void privatePlateUpdatePeopleRelative(Integer cityId, Integer saleId, Integer userId, String userName, String userMobile, String deptName);
	
	/**
	 * 转出售时变更售登记人
	 * @author 朱科
	 * @since 2018/5/4
	 */
	public void transSaleUpdateRegisterPeopleRelative(Integer cityId, Integer saleId, Integer userId, String userName,
			String userMobile, String deptName);
}

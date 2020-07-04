/**
 * @author 方李骥
 * @since 2016年8月29日
 */
package com.myfun.service.business.erpdb;
import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerKey;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
public interface ErpFunRentCustomerService extends BaseMapper<ErpFunRentCustomer, ErpFunRentCustomerKey>{
	ErpFunRentCustomer getFunRentCustomer(Integer cityId,Integer rentCustId);

	boolean countShareHouse(Integer cityId, Integer compId);

	void updateHouseRunModelForPrivate(Integer cityId, Integer compId);

	void updateHousePlateTypeByRunModel(Integer cityId, Integer compId);

	void updateHouseActionTimeBySysPara(Integer cityId, Integer compId);

	void updateHouseTrackTime(Integer cityId, Integer compId, String string);

	void updateHousePublicTime(Integer cityId, Integer compId);

	void updateCustomerSourceNotCooperate(Integer cityId, Integer compId);

	/**
	 * 公盘房源数据移交
	 * @author 张宏利
	 * @since 2018年4月20日
	 * @param param
	 */
	public void createTrack4TransData(ErpCreateTrackInfoParam param);

	/**
	 * 数据移交
	 * @author 张宏利
	 * @since 2018年4月23日
	 * @param param
	 */
	public void dataTranslate(ErpFunRentCustomer updateModel, ErpFunUsers acceptUser, List<Integer> caseIds, String[] caseNos, DataTranslateParam param);

	String[] createHouseOrCustInfo(ErpFunRentCustomerParam param,boolean isPersonalVersion,Integer grId);

	void updateHouseActionTimeBySysParaByPartner(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds);

	void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateCustomerSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds);

}

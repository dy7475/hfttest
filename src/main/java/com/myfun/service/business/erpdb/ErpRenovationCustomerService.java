package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.RenovationCustomerParam;
import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpRenovationCustomerService extends BaseMapper<ErpRenovationCustomer, ErpRenovationCustomer> {

	void addRenovationCustomer(RenovationCustomerParam param);

	void updateRenovationCustomer(RenovationCustomerParam param);
}

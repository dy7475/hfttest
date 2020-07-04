package com.myfun.service.business.agencydb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.po.AgencyFunBrokerAccount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @TODO
 * @author lcb
 * @2016-10-14 下午2:34:11
 */

public interface AgencyFunBrokerAccountService extends BaseMapper<AgencyFunBrokerAccount, Integer> {

	AgencyFunBrokerAccount getDistUserBindBankList(BaseMapParam param);

	AgencyFunBrokerAccount addDistUserBank(BaseMapParam param);

}

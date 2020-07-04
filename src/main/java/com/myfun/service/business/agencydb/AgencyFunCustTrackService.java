package com.myfun.service.business.agencydb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.po.AgencyFunCustTrack;
import com.myfun.repository.agencydb.po.AgencyFunCustTrackKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @TODO
 * @author lcb
 * @2016-10-14 上午11:43:01
 */

public interface AgencyFunCustTrackService extends BaseMapper<AgencyFunCustTrack, AgencyFunCustTrackKey>{

	Integer writeFunCustTrack(Integer custId, Integer custSource, String trackType, String trackContent, Integer isWarn,BaseMapParam param);

	Integer createDistCustTrack(BaseMapParam param);
}

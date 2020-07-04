package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyVoipCard;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyVoipCardMapper extends BaseMapper<AgencyVoipCard, String> {
	public AgencyVoipCard selectOneValidVoipCard();
}
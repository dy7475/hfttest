package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dto.AgencyMessageFavDto;
import com.myfun.repository.agencydb.po.AgencyMessageFav;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyMessageFavService extends BaseMapper<AgencyMessageFav, Integer>{

	PageInfo<AgencyMessageFavDto> getDistMsgConnllectionList(BaseMapParam param);

	Integer updateDistMsgConnllection(BaseMapParam param);

}

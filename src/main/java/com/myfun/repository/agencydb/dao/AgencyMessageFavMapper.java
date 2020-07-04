package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.dto.AgencyMessageFavDto;
import com.myfun.repository.agencydb.po.AgencyMessageFav;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyMessageFavMapper extends BaseMapper<AgencyMessageFav, Integer>{
    /**
     *
     * @mbggenerated
     */
    int insert(AgencyMessageFav record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AgencyMessageFav record);

	List<AgencyMessageFavDto> getDistMsgConnllectionList(Map<String, Object> pMap);

	Integer countByCondition(Map<String, Object> pMap);

	void deleteByCondition(Map<String, Object> pMap);
}
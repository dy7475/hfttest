package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.dto.AdminVoteDto;
import com.myfun.repository.admindb.po.AdminVote;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminVoteMapper extends BaseMapper<AdminVote, Integer> {

	List<AdminVoteDto> getvoteByCondition(AdminVote v);

	List<AdminVote> getVoteByBoundId(Integer bulletId);

	Integer updateVoteCount(Map<String, Object> param);
}
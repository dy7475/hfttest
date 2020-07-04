package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.ErpYouBorkerArchive;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouBorkerArchiveMapper extends BaseMapper<ErpYouBorkerArchive, Integer> {

	int addComplainNumber(@Param("archiveId")Integer targetArchiveId);

	int buckleIntegral(ErpYouBorkerArchive archive);

	int returnIntegral(ErpYouBorkerArchive archive);
}
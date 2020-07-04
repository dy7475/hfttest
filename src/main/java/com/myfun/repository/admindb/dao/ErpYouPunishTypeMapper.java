package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.ErpYouPunishType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouPunishTypeMapper extends BaseMapper<ErpYouPunishType, Integer> {

	List<ErpYouPunishType> getPunishTypeList(String owner);

	List<ErpYouPunishType> getByComplainType(@Param("complainType")Integer complainType);
}
package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.admindb.po.ErpYouPunishType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouPunishTypeService extends BaseMapper<ErpYouPunishType, Integer>{

	List<ErpYouPunishType> getPunishTypeList(String owner);

	List<ErpYouPunishType> getYouPunishTypeList(Byte complainType);

	int delComplainType(Integer yctId);

	int saveYouComplainType(String data);

	int delPunishType(Integer yptId);

}

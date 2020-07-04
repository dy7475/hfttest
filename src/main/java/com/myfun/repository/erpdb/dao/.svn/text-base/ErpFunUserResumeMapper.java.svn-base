package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunUserResumeDto;
import com.myfun.repository.erpdb.po.ErpFunUserResume;
import com.myfun.repository.erpdb.po.ErpFunUserResumeExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type= SwitchDBType.CITY_ID)
public interface ErpFunUserResumeMapper extends BaseMapper<ErpFunUserResume, ErpFunUserResume> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunUserResumeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunUserResumeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunUserResume> selectByExample(ErpFunUserResumeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunUserResume record,
								 @Param("example") ErpFunUserResumeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunUserResume record, @Param("example") ErpFunUserResumeExample example);

	List<ErpFunUserResumeDto> getUserResumeList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userId") Integer userId);
	
	
	List<ErpFunUserResume> getUserResumeListByIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("archiveIds") List<Integer> archiveIds);

}
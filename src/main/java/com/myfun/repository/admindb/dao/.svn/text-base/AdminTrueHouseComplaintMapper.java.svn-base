package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AdminTrueHouseComplaintMapper extends BaseMapper<AdminTrueHouseComplaint, Integer> {

	List<AdminTrueHouseComplaint> getListByCondition(AdminTrueHouseComplaint adminTrueHouseComplaint);

	void updateDownAll(AdminTrueHouseComplaint complaint);

    List<AdminTrueHouseComplaint> getComplaintList(@Param("caseIds") List<Integer> caseIds,@Param("caseType") Integer caseType,@Param("srcUserId") String srcUserId,
												   @Param("cityId") Integer cityId, @Param("compId") Integer compId);
	
    /**
     * 查询未删除数据
     * @param
     * @auther 胡坤
     * @since 2018/5/7
     * @return
     *
     */
	List<AdminTrueHouseComplaint> getComplaintListNotDel(@Param("caseIds") Integer[] caseIds,@Param("caseType") Integer caseType,@Param("userId") Integer userId,@Param("cityId") Integer cityId,@Param("compId") Integer compId);
}
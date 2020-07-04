package com.myfun.repository.admindb.dao;

import com.github.pagehelper.Page;
import com.myfun.erpWeb.common.vo.JoinCompListNewVO;
import com.myfun.erpWeb.usercenter.session.vo.LoginLockVO;
import com.myfun.repository.admindb.dto.AdminFunCompDto;
import com.myfun.repository.admindb.param.AdminFunCompParam;
import com.myfun.repository.admindb.param.AdminWeixinOpenCompParam;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunCompExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AdminFunCompMapper extends BaseMapper<AdminFunComp, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunCompExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunComp> selectByExample(AdminFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunComp record, @Param("example") AdminFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunComp record, @Param("example") AdminFunCompExample example);

	AdminFunComp selectByCompNo(String compNo);
	
	AdminFunComp selectByCompTele(String compTele);

	Integer updateAdminFunComp(Integer brandId);
	
	Page<AdminFunCompDto> getPublicWechatList(AdminWeixinOpenCompParam param);
	
	/**
	 * 更新公司
	 * @param compId
	 */
	void updateDeptStatusAndUaIdByCompId(Integer compId);
	
	/**
	 * 修改公司类型和根据时?
	 * @param compId
	 */
	void updateRecordsByCompId(@Param("compId")Integer compId, @Param("nowTime")String nowTime, @Param("softType")String softType);

	Page<AdminFunCompDto> getCompManageList(Map<String, Object> paramMap);

	/**
	 * 意向客户修改公司状??
	 * @param funComp
	 */
	void updateCompStatus(AdminFunComp funComp);

	/**
	 * 更新公司门店?
	 * @param compNo
	 */
	void updateCompDeptsCount(String compNo);

	/**
	 * 查询出当前加入的加盟公司
	 * @param compNo
	 * @return
	 */
	AdminFunCompParam selectJoinComp(String compNo);
	
	/**
	 *
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	AdminFunComp selectByCompId(@Param("compId") Integer compId);

	AdminFunComp getAdminFunCompByComNoAndStartTime(@Param("compNo")String compNo,@Param("startTime") String startTime);
	
	/**
	 * 查询出当前公司创建的所有加盟公司
	 * @author HeWei
	 * @since 2018年7月25日 下午4:04:10
	 * @param compNo
	 * @return
	 * Modified XXX HeWei 2018年7月25日
	 */
	List<JoinCompListNewVO> getJoinCompListNew(@Param("compNo")String compNo);
	
	/**
	 * 查询出当前公司创建的所有加盟圈
	 * @author HeWei
	 * @since 2018年7月25日 下午5:11:47
	 * @param compNo
	 * @return
	 * Modified XXX HeWei 2018年7月25日
	 */
	List<JoinCompListNewVO> getJoinCompList(@Param("compNo")String compNo);
	
	/**
	 * 共享圈的所有加盟公司
	 * @author HeWei
	 * @since 2018年7月25日 下午5:54:27
	 * @param shareId
	 * @return
	 * Modified XXX HeWei 2018年7月25日
	 */
	List<JoinCompListNewVO> getJoinCompsByShareId(@Param("shareId") Integer shareId,@Param("compNo")String compNo);

    void updateByCompFirstIn(@Param("adminCompId")Integer adminCompId,@Param("firstIn") Integer firstIn);

    @Select("SELECT top 1 LOCK_LOGIN_END_TIME as lockLoginEndTime from LOGIN_LOCK_BLACK_LIST WHERE CITY_ID = #{cityId} AND COMP_NO = #{compNo} AND PCID = #{pcId} AND LOCK_TYPE = 1 ORDER BY ID DESC")
	LoginLockVO selectBlackListForPc(@Param("cityId")Integer cityId, @Param("compNo")String compNo,@Param("pcId") String pcId);

    @Select("SELECT top 1 LOCK_LOGIN_END_TIME as lockLoginEndTime from LOGIN_LOCK_BLACK_LIST WHERE CITY_ID = #{cityId} AND COMP_NO = #{compNo} AND USER_ID = #{userId} AND LOCK_TYPE = 2 ORDER BY ID DESC")
	LoginLockVO selectBlackListForUser(@Param("cityId")Integer cityId, @Param("compNo")String compNo, @Param("userId")Integer userId);


	@Select(" select comp_id as compId, comp_no as compNo from FUN_COMP WITH(NOLOCK) where COMP_NO = #{compNo}")
	AdminFunComp switchDbByCompNo(String compNo);

}


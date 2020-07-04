package com.myfun.repository.admindb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.extension.framework.mybatis.type.WrapMap;
import com.myfun.erpWeb.openApi.param.GenerateCaseMd5Param;
import com.myfun.erpWeb.openApi.param.GeneratePositionxyParam;
import com.myfun.erpWeb.usercenter.param.CrmFunContractParam;
import com.myfun.repository.admindb.dto.AdminCrmFunContrackDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminFunDeptsDto;
import com.myfun.repository.admindb.param.AdminFunDeptsParam;
import com.myfun.repository.admindb.param.AdminFunDeptsVoParam;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminFunDeptsMapper extends BaseMapper<AdminFunDepts, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunDepts> selectByExample(AdminFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunDepts record, @Param("example") AdminFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunDepts record, @Param("example") AdminFunDeptsExample example);

	List<AdminFunDepts> getDeptListByMac(String macaddr);

	AdminFunDepts getDeptByCompNoAndDeptNo(@Param("compNo") String compNo, @Param("deptNo") String deptNo);

	AdminFunDepts getDeptByRoutMac(String routMac);

	int countBySellId(String userId);

	int countByCrmCompId(Integer compId);
	
	int countByCompId(Integer compId);

	void updateByCompNoAndDeptNo(@Param("compNo")String compNo, @Param("deptNo")String deptNo);

	AdminFunDepts selectByContactPhone(String contactPhone);

	int updateMacByCompNoAndDeptNo(AdminFunDepts deptsInfo);
	
	/**
	 * 查询数据移交列表
	 * @param adminFunDepts
	 * @return
	 */
	List<AdminFunDepts> initData(AdminFunDeptsVoParam adminFunDepts);

	void updateTransFlag(@Param("tranflag")String tranflag, @Param("deptArray")String[] deptArray);

	int countCompIdByCompId(Integer compId);
	
	/**
	 * 批量移交
	 * @param record
	 * @param sourceUserId
	 */
	void updateAllSellIdBysellId(@Param("record")AdminFunDepts record, @Param("sourceUserId")Integer sourceUserId);
	
	/**
	 * 更新续费情况
	 * @param addDay
	 * @param compNo
	 * @param deptNo
	 */
	void updateRentalByCompNoAndDeptNo(@Param("addDay")Date addDay, @Param("compNo")String compNo, @Param("deptNo")String deptNo);
	
	/**
	 *  更新续费情况
	 * @param addDay
	 * @param compNo
	 * @param deptNo
	 */
	void updateRentalSignNotNullByCompNoAndDeptNo(@Param("addDay")Date addDay, @Param("compNo")String compNo, @Param("deptNo")String deptNo);
	
	/**
	 * 统计公司下门店个??
	 * @param erpCompId
	 * @param i
	 * @return
	 */
	int countByCompIdAndDeptFlag(@Param("erpCompId")Integer erpCompId, @Param("deptFlag")int deptFlag);
	
	/**
	 * 更新门店FUN_DEPTS
	 * @param deptId
	 */
	void updateByDeptId(Integer deptId);
	
	/**
	 * 统计门店有效个数
	 * @param compId
	 * @param deptFlag
	 * @return
	 */
	int countByCompIdAndDeptFlagEq2(@Param("compId")Integer compId, @Param("deptFlag")int deptFlag);
	
	/**
	 * ??要付费的门店
	 * @param compId
	 * @param i
	 * @return
	 */
	List<AdminFunDepts> getRecordsByCompIdAndDeptFlag(@Param("compId")Integer compId, @Param("deptFlag")int deptFlag);
	
	/**
	 * 合同ID修改为null
	 * @param compId
	 */
	void updateContractIdByCompId(Integer compId);
	
	/**
	 * 修改公司门店版本信息
	 * @param compId
	 * @param nowTime
	 * @param softType
	 */
	void updateRecordsByCompId(@Param("compId")Integer compId, @Param("nowTime")String nowTime, @Param("softType")String softType);
	
	/**
	 * 老用户升级，则赠送一年O2O服务??
	 * @param compId
	 * @param dateToString
	 */
	void updateRecordByCompIdAndFormTime(@Param("compId")Integer compId, @Param("date")String date);
	
	/**
	 * 查村公司下面的门??
	 * @param compNo
	 * @param deptType
	 * @param deptFlag
	 * @return
	 */
	List<AdminFunDepts> getRecordsByCompNoAndDeptTypeAndDeptFlag(@Param("compNo")String compNo, 
			@Param("deptType")String deptType, @Param("deptFlag")String deptFlag);
	

	AdminFunDepts getFunDeptsById(Integer deptId);

	/**
	 * 门店列表
	 * @param funDepts
	 * @return
	 */
	List<AdminFunDeptsParam> selectDeptList(AdminFunDeptsParam funDepts);

	/**
	 * 关店
	 * @param deptId
	 */
	void chgCloseFlag(Integer deptId);
	
	/**
	 * 判断当前门店是否可以差价购买
	 * @param deptId
	 * @return
	 */
	int getCrmAuthSurplusfees(String deptId);

	/**
	 * 调用?库存储过?
	 * @param compId
	 * @param deptId
	 * @param userId
	 * @param crmCompId
	 * @param userName
	 * @return
	 */
	String procCreateComp(@Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("userId") Integer userId, @Param("crmCompId") Integer crmCompId, @Param("userName") String userName);

	/**
	 * 修改意向客户状??
	 * @param funDepts
	 */
	void updateDeptStatus(AdminFunDepts funDepts);

	/**
	 * 根据COMP_NO查询最大的DEPT_NO
	 * @param compId
	 * @return
	 */
	AdminFunDepts selectDeptNoByCompId(Integer compId);

	/**
	 * 永久停用修改门店状态
	 * @param deptId
	 */
	void updateByDeptIdStop(Integer deptId);

	/**
	 * 取消封盘
	 * @param deptId
	 */
	void cancelSpecial(Integer deptId);

	/**
	 * 更新门店培训情况
	 * @param trainId
	 * @param deptId
	 */
	void updateTrainCount(@Param("trainId") Integer trainId, @Param("deptId") Integer deptId);

	/**
	 * 标记未用、在用
	 * @param deptId
	 */
	void chgUseFlag(Integer deptId);

	/**
	 * 重置MAC
	 * @param deptId
	 */
	void updateClearMAC(Integer deptId);

	/**
	 * 根据公司ID查询门店数据
	 * @param compId
	 * @return
	 */
	List<AdminFunDepts> selectByCompId(Integer compId);

	int stopObject(AdminFunDepts adminFunDepts);

	/**
	 * 指派人员
	 * @param deptIdStrs
	 * @param sellId
	 * @param appointFlag
	 */
	void appointPerson(@Param("deptIds") String[] deptIds, @Param("sellId") Integer sellId, @Param("appointFlag") Integer appointFlag);

	/**
	 * 修改公司旗下所有门店的信息
	 * @param funDepts
	 */
	void updateByCompNo(AdminFunDepts funDepts);

	/**
	 * 
	 * @param deptId
	 * @return
	 */
	int countSrvStatus(Integer deptId);

	/**
	 * 统计门店封盘数
	 * @param deptStatus
	 * @param deptId
	 * @return
	 */
	Integer countSpecialNum(@Param("deptStatus") String deptStatus, @Param("deptId") Integer deptId);
	
	/**
	 * 更新离职员工数据，将私盘的变为公盘
	 * @param userId
	 */
	void transPublic(@Param("userId")String userId);

	/**
	 * 升级
	 * @param deptId
	 * @param archiveId
	 * @param payway 0=现金支付，1=余额支付
	 * @param userId
	 */
	String procPay4dept(@Param("deptId") Integer deptId, @Param("archiveId") Integer archiveId, @Param("payway") String payway, @Param("userId") Integer userId);

	/**
	 * 删除合同
	 * @param deptId
	 */
	void updateContractIdIsNull(@Param("deptId") Integer deptId);
	
	/**
	 * 检查所选记录是否含有指定人信息
	 * @param deptIds
	 * @param reciveSellId
	 * @return
	 */
	int countBySellIdAndDeptids(@Param("deptIds")String[] deptIds, @Param("reciveSellId")String reciveSellId);

	/**
	 * 查询赢销版门店列表
	 * @param compId
	 * @return
	 */
	List<AdminFunDepts> selectDeptsByCompId(@Param("compId")Integer compId);

	void updateDeptsInstallCount(@Param("param")Map<String, Object> map);
	
	/**
	 * 通过基本信息获取有效的门店列表
	 * ！不是返回的全部字段，DEPT_NAME是like
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @param depts
	 * @return
	 */
	List<AdminFunDeptsDto> getVaildDeptList(AdminFunDepts depts);

    List<AdminFunDepts> getList(@Param("compNo")String compNo, @Param("deptNo")String deptNo);

    void updateFunDeptsDockUidAndTransferUid(AdminFunDepts adminFunDepts);
	
    /**
     * 通过公司和门店编号获取门店数据
     * @param
     * @auther 胡坤
     * @since 2018/4/23
     * @return
     *
     */
	AdminFunDeptsDto getDataByCompNoAndDeptNo(@Param("compNo") String compNo, @Param("deptNo")String deptNo);
	
	void updateYouLimitFlagByDeptId(@Param("deptId") Integer deptId);
	
	int countNumByCompId(@Param("compId") Integer compId);
	
	/**
	 * 新版统计
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return
	 *
	 */
	int countData(@Param("compId")Integer compId,@Param("deptId") Integer deptId,@Param("startTime") String startTime);
	
	Integer getPayNum(@Param("compId")Integer adminCompId);

	int getYouDeptCountByCompNo(@Param("compNo")String compNo);

	List<AdminCrmFunContrackDto> getDeptListForContract(@Param("param") CrmFunContractParam param);
	
	/**
	 * 获取公司租用门店
	 * @author 朱科
	 * @since 2018年9月5日
	 * @return
	 */
	List<AdminFunDepts> getRentDeptsList(@Param("compNo")String compNo, @Param("payType")Integer payType, @Param("rentEndTime")String rentEndTime);

	List<AdminFunDepts> getFunDeptsByDeptsId(@Param("compId") Integer compId);

	void updateIncumbencyNumberByDeptId(@Param("deptId") Integer deptId,@Param("delUserOrAddUser") Integer delUserOrAddUser);

	Integer countRentDepts(@Param("compNo")String compNo);
	/**
	 * 根据公司和门店编号查询门店数据
	 * @author 陈文超
	 * @date 2017年6月1日 下午8:47:57
	 */
	AdminFunDepts selectByDeptNoAndCompNo(@Param("deptNo")String deptNo, @Param("compNo")String compNo);

	AdminFunDepts selectByDeptNoAndCompId(@Param("deptNo")String deptNo, @Param("adminCompId")Integer adminCompId);

    List<AdminFunDepts> selectByDeptNos(@Param("compNo")String compNo, @Param("deptNos") List<String> deptNos);

	List<AdminFunDepts> selectByEndTime(@Param("compNo") String compNo, @Param("availableDate")Date availableDate);
	
	Integer getNewDeptIdBySeq();

	void createNewDept(AdminFunDepts adminDept);

	Integer GetOrganizationId();


	// 处理数据用
	@Select(value="select ID id, BUILD_ID buildId,BUILD_ROOF buildRoof,BUILD_UNIT buildUnit,ROOM_FLOOR roomFloor,  ROOM_ID roomId, [INFO_TYPE] infoType from GENERATE_MD5 where  ID >= ${minId} AND ID < ${maxId}")
	@ResultType(value= GenerateCaseMd5Param.class)
	List<GenerateCaseMd5Param> selectBuildingSetInitTmpByMaxMinId(@Param("minId")Integer minId, @Param("maxId")Integer maxId);

	@Update(value="UPDATE GENERATE_MD5_IDX SET NUM=NUM+${trehadFetchNum} WHERE TB_NAME = #{tbName}")
	void updateAdminBuildingSetUnitTmpIdx(@Param("tbName")String tbName, @Param("trehadFetchNum")Integer trehadFetchNum);

	@Select("insert into GENERATE_MD5_RECORD(id, status) values(#{id}, #{i})")
	void saveDealRecord(@Param("id")Integer id, @Param("i") Integer i);
	
	@Update(value = "update GENERATE_MD5 set md5='${md5}' where id=#{id}")
	Integer updateMd5(@Param("id") Integer id, @Param("md5") String md5);
	
	// 处理数据用——地图经纬度转换
	@Select(value="select ID id, BUILD_ID buildId,BUILD_ADDR buildAddr,POSITION_X positionX, POSITION_Y positionY from GENERATE_POSITIONXY where  ID >= ${minId} AND ID < ${maxId}")
	@ResultType(value= GeneratePositionxyParam.class)
	List<GeneratePositionxyParam> selectBuildingInfoSetInitTmpByMaxMinId(@Param("minId")Integer minId, @Param("maxId")Integer maxId);

	@Update(value = "update GENERATE_POSITIONXY set POSITION_X='${positionX}',POSITION_Y='${positionY}' where id=#{id}")
	Integer updatePositionxy(GeneratePositionxyParam param);

	/*@Update(value="UPDATE GENERATE_MD5_IDX SET NUM=NUM+${trehadFetchNum} WHERE TB_NAME = #{tbName}")
	void updateAdminBuildingSetUnitTmpIdx(@Param("tbName")String tbName, @Param("trehadFetchNum")Integer trehadFetchNum);
	
	@Select("insert into GENERATE_MD5_RECORD(id, status) values(#{id}, #{i})")
	void saveDealRecord(@Param("id")Integer id, @Param("i") Integer i);*/
	
}
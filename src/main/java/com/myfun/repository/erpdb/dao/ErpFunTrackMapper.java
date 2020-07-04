package com.myfun.repository.erpdb.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.constract.vo.CommonSelectVO;
import com.myfun.repository.erpdb.po.*;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;

import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQL;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.mybatis.query.SqlType;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunTrackExample;
import org.apache.ibatis.annotations.Param;

public interface ErpFunTrackMapper extends BaseMapper<ErpFunTrack, ErpFunTrack> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunTrackExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunTrack> selectByExample(ErpFunTrackExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunTrack record,@Param("example") ErpFunTrackExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunTrack record,@Param("example") ErpFunTrackExample example);

	/**
	 * 获取出租跟进中错误的数据
	 * @author 张宏利
	 * @since 2016年5月18日
	 * @param shardDbName
	 * @return
	 */
	@SwitchDB(type=SwitchDBType.DB_NAME)
	public List<ErpFunTrack> getLeaseErrorTrackCoreInfo(String shardDbName);
	
	/**
	 * 获取出售跟进中错误的数据
	 * @author 张宏利
	 * @since 2016年5月18日
	 * @param shardDbName
	 * @return
	 */
	@SwitchDB(type=SwitchDBType.DB_NAME)
	public List<ErpFunTrack> getSaleErrorTrackCoreInfo(String shardDbName);

	public void insertBatch(@Param("shardCityId")Integer cityId, @Param("resList")List<Map<String, Object>> resList);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertFunTrack(ErpFunTrack erpFunTrack);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	public Integer countTodayExplrthAndLook(@Param("shardCityId")Integer cityId,@Param("conditionModel")DaoBaseParam conditionModel,@Param("startTime")String startTime,@Param("endTime")String endTime);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	@SelectProvider(type = TrackSqlProvider.class, method = "selectMgrTrackListNew")
	@ResultMap("DtoBaseResultMap")
	public List<ErpFunTrackDto> selectMgrTrackList(@Param("param")Map<String, Object> map,
			@Param("shardCityId")Integer cityId);
	@SwitchDB(type=SwitchDBType.CITY_ID)
	@SelectProvider(type = TrackSqlProvider.class, method = "countMgrTrackList")
	@ResultType(value=Integer.class)
	public Integer countMgrTrackList(@Param("param")Map<String, Object> map,
			@Param("shardCityId")Integer cityId);

	List<ErpFunTrack> getErpFunTrackByMap(@Param("shardCityId")Integer cityId, @Param("param")Map<String,Object> param);

    void insertFunTrackByList(@Param("shardCityId")Integer cityId,@Param("list") List<ErpFunTrack> list);

	List<ErpFunTrackDto> getErpFunTrackDtoList(@Param("shardCityId")Integer cityId,@Param("trackIdsList") List<Integer> trackIdsList,
											   @Param("trackTypeList") List<Byte> trackTypeList, @Param("queryTable") String queryTable);

	List<ErpFunTrack> getErpFunTrackRentCustomerList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("caseType")Integer caseType,@Param("caseIds") String[] caseIds);

	String getErpFunTrackNo(@Param("shardCityId")Integer cityId,@Param("caseType")Integer caseType,@Param("trackType")Integer trackType,@Param("targetFlag")Integer targetFlag,@Param("caseId")Integer caseId);

    List<Map<String,Object>> countTakeLookTime(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("saleId")List<Integer> saleId, @Param("leaseId")List<Integer> leaseId);

	class TrackSqlProvider{
		public String countMgrTrackList(Map<String, Object> paramMap){
			BaseMap param = (BaseMap)paramMap.get("param");
			Condition condition = new Condition();
			Condition targetCondition = new Condition();
			condition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			targetCondition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			if(StringUtil.isNotBlank(param.getString("caseType"))){
				condition.add(new ConditionItem("A.CASE_TYPE", "=", param.get("caseType")));
				targetCondition.add(new ConditionItem("A.TARGET_TYPE", "=", param.get("caseType")));
			}
			StringBuilder stringBuilder = new StringBuilder();
			StringBuilder stringBuilderTwo = new StringBuilder();
			stringBuilder.append("select SUM(ATTR_NAME) AS ATTR_NAME from (");
			stringBuilder.append("SELECT COUNT(*) AS ATTR_NAME FROM FUN_TRACK AS A");
			stringBuilderTwo.append("SELECT COUNT(*) AS ATTR_NAME FROM FUN_TRACK AS A");
			if("BY_USER".equals(param.get("operateType").toString())){
				stringBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				stringBuilderTwo.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}else if("BY_INFO".equals(param.get("operateType").toString())){//根据数据所在门店
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_SALE AS B ON ((A.CASE_ID=B.SALE_ID AND A.CASE_TYPE=1))");
					stringBuilderTwo.append(" JOIN FUN_SALE AS B ON ((A.TARGET_ID=B.SALE_ID and A.TARGET_TYPE=1))");
				}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_LEASE AS B ON ((A.CASE_ID=B.LEASE_ID AND A.CASE_TYPE=2))");
					stringBuilderTwo.append(" JOIN FUN_LEASE AS B ON ((A.TARGET_ID=B.LEASE_ID and A.TARGET_TYPE=2))");
				}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.CASE_ID=B.BUY_CUST_ID AND A.CASE_TYPE=3))");
					stringBuilderTwo.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.TARGET_ID=B.BUY_CUST_ID and A.TARGET_TYPE=3))");
				}else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.CASE_ID=B.RENT_CUST_ID AND A.CASE_TYPE=4)");
					stringBuilderTwo.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.TARGET_ID=B.RENT_CUST_ID and A.TARGET_TYPE=4)");
				}
			}else if("BY_USER_INFO".equals(param.get("operateType").toString())){
				stringBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				stringBuilderTwo.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}
			if(StringUtil.isNotBlank(param.getString("operateType"))&&StringUtil.isNotBlank(param.getString("userId"))&&!"ALL".equals(param.getString("userId"))){
				if("BY_USER".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}else if("BY_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
				}else if("BY_USER_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}
			}
			if(param.getString("areaId")!=null) {
				condition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
				targetCondition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
			} else if(param.getString("regId")!=null) {
				condition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
				targetCondition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
			} else if(param.getString("deptId")!=null) {
				condition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
				targetCondition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
			} else if(param.getString("grId")!=null) {
				condition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
				targetCondition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
			}
			Condition queryCondition = new Condition();
			Condition queryStatusTrack = new Condition();
			if(StringUtil.isNotBlank(param.getString("trackType"))&&!"ALL".equals(param.getString("trackType"))){
				String[] statusArr = param.get("trackType").toString().split(",");
				if("STATUS".equals(statusArr[0])){
					condition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
					targetCondition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
				} else {
					for(int i=0;i<statusArr.length;i++){
						Condition subCondition = new Condition();
						if("VIDEO".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO}));
						} else if("NORMAL".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IS","NULL"));
						} else if("CORE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA));
						} else if("IMAGE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE}));	
						} else if("REGISTER".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER));
						} else if("OUT_FINISH".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.CASE_STATUS","=",Constants_DIC.DIC_HOUSE_STATUS_DEAL));
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_STATUS));
						} else if("KEY".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_KEY));
						} else if(Const.DIC_TRACK_TYPE_OTHER.equals(new Byte(statusArr[i]))){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","IN",
									new Byte[]{
											Const.DIC_TRACK_TYPE_EDIT,
											Const.DIC_TRACK_TYPE_OTHER,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND,
									}
								));
							Condition includeTrackCon = new Condition();
							includeTrackCon.add(new ConditionItem("A.INCLUDE_TRACK","IS", "NULL"));
							includeTrackCon.add("OR", new ConditionItem("A.INCLUDE_TRACK","NOT IN",new String[]{
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER
									}));
							subCondition.add(includeTrackCon);
						}else{
							queryCondition.add(Condition.OR, new ConditionItem("A.TRACK_TYPE", "=", statusArr[i]));
							continue;
						
						}
						queryCondition.add(Condition.OR,subCondition);
					}
				}
				queryStatusTrack.add(queryCondition);
			}
			String caseStatus = param.getString("caseStatus");
			if (StringUtils.isNotBlank(caseStatus)) {
				String[] statusArr = caseStatus.split(",");
				if(statusArr != null && statusArr.length > 0){
					Condition queryStatusCondition = new Condition();
					Condition queryStatusSub = new Condition();
					queryStatusCondition.add(new ConditionItem("A.TRACK_TYPE", "=", Const.DIC_TRACK_TYPE_STATUS));
					for(int i = 0; i < statusArr.length; i++){
						queryStatusSub.add(Condition.OR, new ConditionItem("A.CASE_STATUS", "=", statusArr[i]));
					}
					queryStatusCondition.add(queryStatusSub);
					queryStatusTrack.add("OR", queryStatusCondition);
				}
			}
			condition.add(queryStatusTrack);
			targetCondition.add(queryStatusTrack);
			if(StringUtil.isNotBlank(param.getString("date1"))){
				condition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
			}
			if(StringUtil.isNotBlank(param.getString("date2"))){
				condition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
			}
			StringBuilder conditionStatement2 = targetCondition.getConditionStatement(1);
			StringBuilder conditionStatement1 = condition.getConditionStatement(1);
			System.out.println(conditionStatement1.toString());
			System.out.println(conditionStatement2.toString());
			stringBuilder.append(" where "+condition.getConditionStatement(1));
			stringBuilderTwo.append(" where "+targetCondition.getConditionStatement(1));
			stringBuilder.append(" UNION ");
			stringBuilder.append(stringBuilderTwo);
			stringBuilder.append(" ) as C");
			System.out.println(condition.getConditionStatement(1));
			System.out.println(targetCondition.getConditionStatement(1));
			return stringBuilder.toString();
		}
		public String selectMgrTrackList(Map<String, Object> paramMap){
			BaseMap param = (BaseMap)paramMap.get("param");
			Condition condition = new Condition();
			Condition targetCondition = new Condition();
			String order = "C.CREATION_TIME DESC";
			if(StringUtil.isNotBlank(param.getString("caseType"))){
				condition.add(new ConditionItem("A.CASE_TYPE", "=", param.get("caseType")));
				targetCondition.add(new ConditionItem("A.TARGET_TYPE", "=", param.get("caseType")));
				
			}
			String orderEnum = param.getString("orderEnum"); 
			String orderRule = param.getString("orderRule"); // 0:升序 1:降序
			if(StringUtil.isNotBlank(orderEnum) && StringUtil.isNotBlank(orderRule)) {
				String orderStr = "1".equals(orderRule) ? "DESC" : "ASC";
				if("CREATION_TIME".equals(orderEnum)) {
					order = " C.CREATION_TIME " + orderStr;
				}
				if("TRACK_TYPE".equals(orderEnum)) {
					order = " C.TRACK_TYPE " + orderStr+ ",INCLUDE_TRACK "+ orderStr;
				}
				if("TARGET_NO".equals(orderEnum)) {
					order = " C.TARGET_NO " + orderStr;
				}
				if("CREATOR".equals(orderEnum)) {
					order = " C.CREATOR_UID " + orderStr;
				}
				if("TRACK_NO".equals(orderEnum)) {
					order = " C.TRACK_NO " + orderStr;
				}
			}
			
			StringBuilder stringBuilder = new StringBuilder();
			StringBuilder stringBuilderTwo = new StringBuilder();
			stringBuilder.append("select C.TRACK_ID,C.CASE_DEPT_ID,C.COMP_ID,C.DEPT_ID,C.IS_DEL,C.CASE_TYPE,C.CASE_ID,C.CASE_STATUS,C.TRACK_TYPE,C.TRACK_CLASSIC,C.TARGET_ID,C.CASE_USER_ID,C.TARGET_USER_ID,C.TARGET_NO,C.TARGET_TYPE,C.TARGET_BOUND,C.TARGET_FLAG,C.EXAMIN_TIME,C.TRACK_NO,C.TRACK_CONTENT,C.TRACK_WARM,C.WARM_TIME,C.WARM_CONTENT,C.TRACK_KEY,C.CREATOR_UID,C.CREATION_TIME,C.USEAGE,C.CASE_NO,C.TARGET_USEAGE,C.INDEX_SHOW,C.KEY_NUM,C.TARGET_DEPT,C.INCLUDE_TRACK,C.TRACK_RESULT,C.DEL_TIME,C.DEL_USER,C.DEL_USER_NAME,C.OWNER_USER_ID from (");
			stringBuilder.append("select A.TRACK_ID,A.COMP_ID,A.CASE_DEPT_ID,A.DEPT_ID,A.IS_DEL,A.CASE_TYPE,A.CASE_ID,A.CASE_STATUS,A.TRACK_TYPE,A.TRACK_CLASSIC,A.TARGET_ID,A.CASE_USER_ID,A.TARGET_USER_ID,A.TARGET_NO,A.TARGET_TYPE,A.TARGET_BOUND,A.TARGET_FLAG,A.EXAMIN_TIME,A.TRACK_NO,A.TRACK_CONTENT,A.TRACK_WARM,A.WARM_TIME,A.WARM_CONTENT,A.TRACK_KEY,A.CREATOR_UID,A.CREATION_TIME,A.USEAGE,A.CASE_NO,A.TARGET_USEAGE,A.INDEX_SHOW,A.KEY_NUM,A.TARGET_DEPT,A.INCLUDE_TRACK,A.TRACK_RESULT,A.DEL_TIME,A.DEL_USER,A.DEL_USER_NAME,B.USER_ID as OWNER_USER_ID from FUN_TRACK AS A ");
			stringBuilderTwo.append("select A.TRACK_ID,A.COMP_ID,A.CASE_DEPT_ID,A.DEPT_ID,A.IS_DEL,A.CASE_TYPE,A.CASE_ID,A.CASE_STATUS,A.TRACK_TYPE,A.TRACK_CLASSIC,A.TARGET_ID,A.CASE_USER_ID,A.TARGET_USER_ID,A.TARGET_NO,A.TARGET_TYPE,A.TARGET_BOUND,A.TARGET_FLAG,A.EXAMIN_TIME,A.TRACK_NO,A.TRACK_CONTENT,A.TRACK_WARM,A.WARM_TIME,A.WARM_CONTENT,A.TRACK_KEY,A.CREATOR_UID,A.CREATION_TIME,A.USEAGE,A.CASE_NO,A.TARGET_USEAGE,A.INDEX_SHOW,A.KEY_NUM,A.TARGET_DEPT,A.INCLUDE_TRACK,A.TRACK_RESULT,A.DEL_TIME,A.DEL_USER,A.DEL_USER_NAME,B.USER_ID as OWNER_USER_ID from FUN_TRACK AS A ");
			
			condition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			targetCondition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			if("BY_USER".equals(param.get("operateType").toString())){
				stringBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				stringBuilderTwo.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}else if("BY_INFO".equals(param.get("operateType").toString())){//根据数据所在门店
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_SALE AS B ON ((A.CASE_ID=B.SALE_ID AND A.CASE_TYPE=1))");
					stringBuilderTwo.append(" JOIN FUN_SALE AS B ON ((A.TARGET_ID=B.SALE_ID and A.TARGET_TYPE=1))");
				}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_LEASE AS B ON ((A.CASE_ID=B.LEASE_ID AND A.CASE_TYPE=2))");
					stringBuilderTwo.append(" JOIN FUN_LEASE AS B ON ((A.TARGET_ID=B.LEASE_ID and A.TARGET_TYPE=2))");
				}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.CASE_ID=B.BUY_CUST_ID AND A.CASE_TYPE=3))");
					stringBuilderTwo.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.TARGET_ID=B.BUY_CUST_ID and A.TARGET_TYPE=3))");
				}else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(param.get("caseType").toString())){
					stringBuilder.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.CASE_ID=B.RENT_CUST_ID AND A.CASE_TYPE=4)");
					stringBuilderTwo.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.TARGET_ID=B.RENT_CUST_ID and A.TARGET_TYPE=4)");
				}
			}else if("BY_USER_INFO".equals(param.get("operateType").toString())){
				stringBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				stringBuilderTwo.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}
			if(StringUtil.isNotBlank(param.getString("operateType"))&&StringUtil.isNotBlank(param.getString("userId"))&&!"ALL".equals(param.getString("userId"))){
				if("BY_USER".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}else if("BY_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
				}else if("BY_USER_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}
			}
			if(param.getString("areaId")!=null) {
				condition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
				targetCondition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
			} else if(param.getString("regId")!=null) {
				condition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
				targetCondition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
			} else if(param.getString("deptId")!=null) {
				condition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
				targetCondition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
			} else if(param.getString("grId")!=null) {
				condition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
				targetCondition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
			}
			Condition queryCondition = new Condition();
			Condition queryStatusTrack = new Condition();
			if(StringUtil.isNotBlank(param.getString("trackType"))&&!"ALL".equals(param.getString("trackType"))){
				String[] statusArr = param.get("trackType").toString().split(",");
				if("STATUS".equals(statusArr[0])){
					condition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
					targetCondition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
				} else {
					for(int i=0;i<statusArr.length;i++){
						Condition subCondition = new Condition();
						if("VIDEO".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO}));
						} else if("NORMAL".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IS","NULL"));
						} else if("CORE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA));
						} else if("IMAGE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE}));	
						} else if("REGISTER".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER));
						} else if("OUT_FINISH".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.CASE_STATUS","=",Constants_DIC.DIC_HOUSE_STATUS_DEAL));
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_STATUS));
						} else if("KEY".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_KEY));
						} else if(Const.DIC_TRACK_TYPE_OTHER.equals(new Byte(statusArr[i]))){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","IN",
									new Byte[]{
											Const.DIC_TRACK_TYPE_EDIT,
											Const.DIC_TRACK_TYPE_OTHER,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND,
									}
								));
							Condition includeTrackCon = new Condition();
							includeTrackCon.add(new ConditionItem("A.INCLUDE_TRACK","IS", "NULL"));
							includeTrackCon.add("OR", new ConditionItem("A.INCLUDE_TRACK","NOT IN",new String[]{
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER
									}));
							subCondition.add(includeTrackCon);
						}else{
							queryCondition.add(Condition.OR, new ConditionItem("A.TRACK_TYPE", "=", statusArr[i]));
							continue;
						
						}
						queryCondition.add(Condition.OR,subCondition);
					}
				}
				queryStatusTrack.add(queryCondition);
			}
			String caseStatus = param.getString("caseStatus");
			if (StringUtils.isNotBlank(caseStatus)) {
				String[] statusArr = caseStatus.split(",");
				if(statusArr != null && statusArr.length > 0){
					Condition queryStatusCondition = new Condition();
					Condition queryStatusSub = new Condition();
					queryStatusCondition.add(new ConditionItem("A.TRACK_TYPE", "=", Const.DIC_TRACK_TYPE_STATUS));
					for(int i = 0; i < statusArr.length; i++){
						queryStatusSub.add(Condition.OR, new ConditionItem("A.CASE_STATUS", "=", statusArr[i]));
					}
					queryStatusCondition.add(queryStatusSub);
					queryStatusTrack.add("OR", queryStatusCondition);
				}
			}
			condition.add(queryStatusTrack);
			targetCondition.add(queryStatusTrack);
			if(StringUtil.isNotBlank(param.getString("date1"))){
				condition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
			}
			if(StringUtil.isNotBlank(param.getString("date2"))){
				condition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
			}
			stringBuilder.append(" where "+condition.getConditionStatement(1));
			stringBuilderTwo.append(" where "+targetCondition.getConditionStatement(1));
			stringBuilder.append(" UNION ");
			stringBuilder.append(stringBuilderTwo);
			stringBuilder.append(" ) as C");
			stringBuilder.append(" order by "+order);// 条件			
			stringBuilder.append(" OFFSET "+(Integer.valueOf(param.getString("pageOffset"))-1)*Integer.valueOf(param.getString("pageRows"))+" ROW FETCH NEXT "+Integer.valueOf(param.getString("pageRows"))+" ROWS ONLY");// 条件
			return stringBuilder.toString();
		}
		public String selectMgrTrackListNew(Map<String, Object> paramMap) throws Exception{
			BaseMap param = (BaseMap)paramMap.get("param");
			Condition condition = new Condition();
			Condition targetCondition = new Condition();
			StringBuilder tableNameOneBuilder = new StringBuilder();
			StringBuilder tableNameTwoBuilder = new StringBuilder();
			String order = "C.CREATION_TIME DESC";
			if(StringUtil.isNotBlank(param.getString("caseType"))){
				condition.add(new ConditionItem("A.CASE_TYPE", "=", param.get("caseType")));
				targetCondition.add(new ConditionItem("A.TARGET_TYPE", "=", param.get("caseType")));
				
			}
			String orderEnum = param.getString("orderEnum"); 
			String orderRule = param.getString("orderRule"); // 0:升序 1:降序
			if(StringUtil.isNotBlank(orderEnum) && StringUtil.isNotBlank(orderRule)) {
				String orderStr = "1".equals(orderRule) ? "DESC" : "ASC";
				if("CREATION_TIME".equals(orderEnum)) {
					order = " C.CREATION_TIME " + orderStr;
				}
				if("TRACK_TYPE".equals(orderEnum)) {
					order = " C.TRACK_TYPE " + orderStr+ ",INCLUDE_TRACK "+ orderStr;
				}
				if("TARGET_NO".equals(orderEnum)) {
					order = " C.TARGET_NO " + orderStr;
				}
				if("CREATOR".equals(orderEnum)) {
					order = " C.CREATOR_UID " + orderStr;
				}
				if("TRACK_NO".equals(orderEnum)) {
					order = " C.TRACK_NO " + orderStr;
				}
			}
			
			tableNameOneBuilder.append(" FUN_TRACK AS A ");
			tableNameTwoBuilder.append(" FUN_TRACK AS A ");
			condition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			targetCondition.add(new ConditionItem("A.COMP_ID", "=", param.get("compId")));
			if("BY_USER".equals(param.get("operateType").toString())){
				tableNameOneBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				tableNameTwoBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}else if("BY_INFO".equals(param.get("operateType").toString())){//根据数据所在门店
				if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.get("caseType").toString())){
					tableNameOneBuilder.append(" JOIN FUN_SALE AS B ON ((A.CASE_ID=B.SALE_ID AND A.CASE_TYPE=1))");
					tableNameTwoBuilder.append(" JOIN FUN_SALE AS B ON ((A.TARGET_ID=B.SALE_ID and A.TARGET_TYPE=1))");
				}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(param.get("caseType").toString())){
					tableNameOneBuilder.append(" JOIN FUN_LEASE AS B ON ((A.CASE_ID=B.LEASE_ID AND A.CASE_TYPE=2))");
					tableNameTwoBuilder.append(" JOIN FUN_LEASE AS B ON ((A.TARGET_ID=B.LEASE_ID and A.TARGET_TYPE=2))");
				}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(param.get("caseType").toString())){
					tableNameOneBuilder.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.CASE_ID=B.BUY_CUST_ID AND A.CASE_TYPE=3))");
					tableNameTwoBuilder.append(" JOIN FUN_BUY_CUSTOMER AS B ON ((A.TARGET_ID=B.BUY_CUST_ID and A.TARGET_TYPE=3))");
				}else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(param.get("caseType").toString())){
					tableNameOneBuilder.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.CASE_ID=B.RENT_CUST_ID AND A.CASE_TYPE=4)");
					tableNameTwoBuilder.append(" JOIN FUN_RENT_CUSTOMER AS B ON (A.TARGET_ID=B.RENT_CUST_ID and A.TARGET_TYPE=4)");
				}
			}else if("BY_USER_INFO".equals(param.get("operateType").toString())){
				tableNameOneBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
				tableNameTwoBuilder.append(" JOIN FUN_USERS AS B ON A.CREATOR_UID=B.USER_ID");
			}
			if(StringUtil.isNotBlank(param.getString("operateType"))&&StringUtil.isNotBlank(param.getString("userId"))&&!"ALL".equals(param.getString("userId"))){
				if("BY_USER".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}else if("BY_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("B.USER_ID", "=","#{param.userId}"));
				}else if("BY_USER_INFO".equals(param.getString("operateType"))){
					condition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
					targetCondition.add(new ConditionItem("A.CREATOR_UID", "=","#{param.userId}"));
				}
			}
			if(param.getString("areaId")!=null) {
				condition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
				targetCondition.add(new ConditionItem("B.AREA_ID", "=","#{param.areaId}"));
			} else if(param.getString("regId")!=null) {
				condition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
				targetCondition.add(new ConditionItem("B.REG_ID", "=","#{param.regId}"));
			} else if(param.getString("deptId")!=null) {
				condition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
				targetCondition.add(new ConditionItem("B.DEPT_ID", "=","#{param.deptId}"));
			} else if(param.getString("grId")!=null) {
				condition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
				targetCondition.add(new ConditionItem("B.GR_ID", "=","#{param.grId}"));
			}
			Condition queryCondition = new Condition();
			Condition queryStatusTrack = new Condition();
			if(StringUtil.isNotBlank(param.getString("trackType"))&&!"ALL".equals(param.getString("trackType"))){
				String[] statusArr = param.get("trackType").toString().split(",");
				if("STATUS".equals(statusArr[0])){
					condition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
					targetCondition.add(new ConditionItem("A.CASE_STATUS", "is", "not null"));
				} else {
					for(int i=0;i<statusArr.length;i++){
						Condition subCondition = new Condition();
						if("VIDEO".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO}));
						} else if("NORMAL".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IS","NULL"));
						} else if("CORE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA));
						} else if("IMAGE".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","IN",new String[]{Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE}));	
						} else if("REGISTER".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_OTHER));
							subCondition.add(new ConditionItem("A.INCLUDE_TRACK","=",Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER));
						} else if("OUT_FINISH".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.CASE_STATUS","=",Constants_DIC.DIC_HOUSE_STATUS_DEAL));
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_STATUS));
						} else if("KEY".equals(statusArr[i])){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","=",Const.DIC_TRACK_TYPE_KEY));
						} else if(Const.DIC_TRACK_TYPE_OTHER.equals(new Byte(statusArr[i]))){
							subCondition.add(new ConditionItem("A.TRACK_TYPE","IN",
									new Byte[]{
											Const.DIC_TRACK_TYPE_EDIT,
											Const.DIC_TRACK_TYPE_OTHER,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD,
											Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND,
							}
									));
							Condition includeTrackCon = new Condition();
							includeTrackCon.add(new ConditionItem("A.INCLUDE_TRACK","IS", "NULL"));
							includeTrackCon.add("OR", new ConditionItem("A.INCLUDE_TRACK","NOT IN",new String[]{
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADVIDEO,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_UPLOADIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_DELIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_EDITIMAGE,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_IMPORT_DATA,
									Constants_DIC.DIC_TRACK_INCLUDE_TRACK_REGISTER
							}));
							subCondition.add(includeTrackCon);
						}else{
							queryCondition.add(Condition.OR, new ConditionItem("A.TRACK_TYPE", "=", statusArr[i]));
							continue;
							
						}
						queryCondition.add(Condition.OR,subCondition);
					}
				}
				queryStatusTrack.add(queryCondition);
			}
			String caseStatus = param.getString("caseStatus");
			if (StringUtils.isNotBlank(caseStatus)) {
				String[] statusArr = caseStatus.split(",");
				if(statusArr != null && statusArr.length > 0){
					Condition queryStatusCondition = new Condition();
					Condition queryStatusSub = new Condition();
					queryStatusCondition.add(new ConditionItem("A.TRACK_TYPE", "=", Const.DIC_TRACK_TYPE_STATUS));
					for(int i = 0; i < statusArr.length; i++){
						queryStatusSub.add(Condition.OR, new ConditionItem("A.CASE_STATUS", "=", statusArr[i]));
					}
					queryStatusCondition.add(queryStatusSub);
					queryStatusTrack.add("OR", queryStatusCondition);
				}
			}
			condition.add(queryStatusTrack);
			targetCondition.add(queryStatusTrack);
			if(StringUtil.isNotBlank(param.getString("date1"))){
				condition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME",">=","#{param.date1}"));
			}
			if(StringUtil.isNotBlank(param.getString("date2"))){
				condition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
				targetCondition.add(new ConditionItem("A.CREATION_TIME","<=","#{param.date2}"));
			}
			String[] queryColumn = new String[]{"C.TRACK_ID,C.CASE_DEPT_ID,C.COMP_ID,C.DEPT_ID,C.IS_DEL,C.CASE_TYPE,C.CASE_ID,C.CASE_STATUS,C.TRACK_TYPE,C.TRACK_CLASSIC,C.TARGET_ID,C.CASE_USER_ID,C.TARGET_USER_ID,C.TARGET_NO,C.TARGET_TYPE,C.TARGET_BOUND,C.TARGET_FLAG,C.EXAMIN_TIME,C.TRACK_NO,C.TRACK_CONTENT,C.TRACK_WARM,C.WARM_TIME,C.WARM_CONTENT,C.TRACK_KEY,C.CREATOR_UID,C.CREATION_TIME,C.USEAGE,C.CASE_NO,C.TARGET_USEAGE,C.INDEX_SHOW,C.KEY_NUM,C.TARGET_DEPT,C.INCLUDE_TRACK,C.TRACK_RESULT,C.DEL_TIME,C.DEL_USER,C.DEL_USER_NAME,C.OWNER_USER_ID"};
			String[] querySubColumn = new String[]{"A.TRACK_ID,A.CASE_DEPT_ID,A.COMP_ID,A.DEPT_ID,A.IS_DEL,A.CASE_TYPE,A.CASE_ID,A.CASE_STATUS,A.TRACK_TYPE,A.TRACK_CLASSIC,A.TARGET_ID,A.CASE_USER_ID,A.TARGET_USER_ID,A.TARGET_NO,A.TARGET_TYPE,A.TARGET_BOUND,A.TARGET_FLAG,A.EXAMIN_TIME,A.TRACK_NO,A.TRACK_CONTENT,A.TRACK_WARM,A.WARM_TIME,A.WARM_CONTENT,A.TRACK_KEY,A.CREATOR_UID,A.CREATION_TIME,A.USEAGE,A.CASE_NO,A.TARGET_USEAGE,A.INDEX_SHOW,A.KEY_NUM,A.TARGET_DEPT,A.INCLUDE_TRACK,A.TRACK_RESULT,A.DEL_TIME,A.DEL_USER,A.DEL_USER_NAME,B.USER_ID as OWNER_USER_ID"};
			SQL.SqlBuilder subOneSqlBuilder = new SQL.SqlBuilder(SqlType.SELECT.getType(), tableNameOneBuilder.toString(), new Columns(querySubColumn), condition);
			SQL.SqlBuilder subTwoSqlBuilder = new SQL.SqlBuilder(SqlType.SELECT.getType(), tableNameTwoBuilder.toString(), new Columns(querySubColumn), targetCondition);
			SQL subSqlOne = subOneSqlBuilder.createSQL();
			SQL subSqlTwo = subTwoSqlBuilder.createSQL();
			List<SQL> subList = new ArrayList<SQL>();
			subList.add(subSqlOne);
			subList.add(subSqlTwo);
			SQL.SqlBuilder sqlBuilder = new SQL.SqlBuilder(SqlType.UNIONPAGE.getType(), null, new Columns(queryColumn), null);
			sqlBuilder.isAutoPage(true);
			sqlBuilder.subList(subList);
			sqlBuilder.alias("C");
			sqlBuilder.orderBy(order);
			sqlBuilder.pageOffSet(Integer.valueOf(param.getString("pageOffset")));
			sqlBuilder.pageRows(Integer.valueOf(param.getString("pageRows")));
			SQL sql = sqlBuilder.createSQL();
			StringBuilder sqlSb = SQLBuilderSupport.constructUnionPageSQL(sql);
			return sqlSb.toString();
		}
		
	}
	
	/**
	 * 获取修改错误的电话跟进
	 * @author 张宏利
	 * @since 2017年6月26日
	 * @param shardDbName
	 * @return
	 */
	public List<ErpFunTrack> selectPhoneErrorList(@Param("shardDbName")String shardDbName);

	@SwitchDB(type=SwitchDBType.DB_NAME)
	public ErpFunTrack getTrackDeal(@Param("shardDbName")String shardDbName,@Param("caseType") String caseType,@Param("caseId") Integer dealHouseId, @Param("createTime") String systemRecordTime);

	/**
	 * 通过主键集合获取跟进对象
	 * @author 臧铁
	 * @since 2017年7月17日
	 * @param cityId
	 * @param arrs trackId的数组
	 * @return
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	public List<ErpFunTrack> getCaseStatusByTrackIds(@Param("shardCityId") Integer cityId,@Param("arrs") String[] arrs);

	/**
	 * 通过主键集合获取跟进列表
	 * @author 臧铁
	 * @since 2017年8月1日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<ErpFunTrack> getByTrackIds(@Param("shardCityId")Integer cityId, @Param("recordIds") String[] recordIds);
	
	/**
	 * 删除跟进日志
	 * @author 熊刚
	 * @since 2017年9月21日
	 * @param map
	 * @param cityId
	 */
	public void deleteFunTrack(@Param("shardCityId")Integer cityId,@Param("trackId")Integer trackId);
	public ErpFunTrack  getTrackResultById(@Param("shardCityId")Integer cityId,@Param("trackId")Integer trackId);
	
	List<Integer> getTrackIds(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType,@Param("caseStatus")Byte[] caseStatus);
	
	void updateTargetFlag(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("targetFlag")String targetFlag,@Param("trackIds")Integer[] trackIds);

	List<ErpFunTrack> getErpFunTrackList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);

	void updateFunTrackById(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("trackIds")String[] trackIds, @Param("targetFlag")String targetFlag);
	
	Integer getCount(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseType")Integer caseType, 
			@Param("trackType")Byte trackType ,@Param("userId")Integer userId,@Param("startDate")String startDate,
			@Param("endDate")String endDate, @Param("targetFlag") Integer targetFlag);
	
	/**
	 * 经纪人带看热度统计--房源
	 * @author 张宏利
	 * @since 2018年2月7日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param startTime
	 * @return
	 */
	List<Map<String, Object>> getBasicDaiKanHotrankHouse(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("userId")Integer userId, @Param("startTime")String startTime);
	
	/**
	 * 经纪人带看热度统计--客源
	 * @author 张宏利
	 * @since 2018年2月7日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param startTime
	 * @return
	 */
	List<Map<String, Object>> getBasicDaiKanHotrankCust(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, 
			@Param("userId")Integer userId, @Param("startTime")String startTime);
	

	@AccessReadonlyDb
	List<Map<String, Object>> getTrackZhList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("startTime")String startTime);

	/**
	* @author 邓永洪
	* @since 2018/4/20
	* @tag 获取跟进内容
	*/
	Map<String,Object>  getkeyTrackInfo(@Param("shardCityId")Integer cityId, @Param("caseId")Integer caseId ,@Param("caseType")Integer caseType,@Param("trackType")Integer trackType);
	
	/**
	 * 数据移交同步跟进组织机构
	 * @author 朱科
	 * @since 2018/6/20
	 */
	void updateTrackByCaseId(@Param("shardCityId")Integer cityId, @Param("caseType")Integer caseType, @Param("erpFunUsers")ErpFunUsers erpFunUsers);
	
	/**
	 * 掌通运营分析排行榜详情:钥匙
	 * @author 朱科
	 * @since 2018年10月22日
	 * @return
	 */
	List<ErpFunTrack> getYsTrackByCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds , @Param("caseType")Integer caseType, @Param("trackType")Byte trackType);

	/**
	 * 通过房源找指定类型的跟进
	 * @author 朱科
	 * @since 2018年10月23日
	 * @return
	 */
	List<ErpFunTrack> getFunTrackByCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseIds")Set<Integer> caseIds , @Param("caseType")Integer caseType, @Param("trackType")Byte trackType, @Param("deptIds")Set<Integer> deptIds, @Param("grId")Integer grId, @Param("userId")Integer userId, @Param("startTime")String startTime, @Param("endTime")String endTime);

	/**
	 * 通过房源找指定类型的跟进
	 * @author 朱科
	 * @since 2018年10月23日
	 * @return
	 */
	List<ErpFunTrack> getFunTrackByCaseIdsForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("partnerIds") List<Integer> partnerId, @Param("caseIds")Set<Integer> caseIds , @Param("caseType")Integer caseType, @Param("trackType")Byte trackType, @Param("whereCause") String whereCause, @Param("userId")Integer userId, @Param("startTime")String startTime, @Param("endTime")String endTime);

	@MapKey("selectKey")
	Map<Integer, CommonSelectVO> countDataByCaseIdsAndTrackType(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
																@Param("caseIds")Set<Integer> caseIds, @Param("caseType") Byte caseType,
																@Param("trackType") Integer trackType);

	ErpFunTrack selectByOneExample(ErpFunTrackExample erpFunTrackExample);

	void insertBatchForTransForSale(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("currentUserId") Integer currentUserId,
									@Param("currentDeptId") Integer deptId, @Param("caseType")Integer caseType, @Param("trackType")Byte trackType,
									@Param("trackClassic") String trackClassic,@Param("content") String content, @Param("srcUserId") Integer srcUserId,
//								    @Param("caseList") List<ErpFunSale> saleList,
									@Param("createOrganizationId") Integer createOrganizationId,@Param("createOrganizationName") String createOrganizationName,@Param("createOrganizationPath") String createOrganizationPath,@Param("caseOrganizationId") Integer caseOrganizationId,@Param("createUsername") String createUsername);
	void insertBatchForTransForLease(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("currentUserId") Integer currentUserId,
									 @Param("currentDeptId") Integer deptId, @Param("caseType")Integer caseType, @Param("trackType")Byte trackType,
									 @Param("trackClassic") String trackClassic,@Param("content") String content, @Param("srcUserId") Integer srcUserId,
//									 @Param("caseList") List<ErpFunLease> saleList,
									 @Param("createOrganizationId") Integer createOrganizationId,@Param("createOrganizationName") String createOrganizationName,@Param("createOrganizationPath") String createOrganizationPath,@Param("caseOrganizationId") Integer caseOrganizationId,@Param("createUsername") String createUsername);
	void insertBatchForTransForBuyCust(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("currentUserId") Integer currentUserId,
									   @Param("currentDeptId") Integer deptId, @Param("caseType")Integer caseType, @Param("trackType")Byte trackType,
									   @Param("trackClassic") String trackClassic,@Param("content") String content, @Param("srcUserId") Integer srcUserId,
//									   @Param("caseList") List<ErpFunBuyCustomer> custList,
									   @Param("createOrganizationId") Integer createOrganizationId,@Param("createOrganizationName") String createOrganizationName,@Param("createOrganizationPath") String createOrganizationPath,@Param("caseOrganizationId") Integer caseOrganizationId,@Param("createUsername") String createUsername);
	void insertBatchForTransForRentCust(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("currentUserId") Integer currentUserId,
										@Param("currentDeptId") Integer deptId, @Param("caseType")Integer caseType, @Param("trackType")Byte trackType,
										@Param("trackClassic") String trackClassic,@Param("content") String content, @Param("srcUserId") Integer srcUserId,
//									    @Param("caseList") List<ErpFunRentCustomer> custList,
										@Param("createOrganizationId") Integer createOrganizationId,@Param("createOrganizationName") String createOrganizationName,@Param("createOrganizationPath") String createOrganizationPath,@Param("caseOrganizationId") Integer caseOrganizationId,@Param("createUsername") String createUsername);

    ErpFunTrack getTrackByIdAndTable(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
                                     @Param("trackId") Integer trackId, @Param("queryTable") String queryTable);
}


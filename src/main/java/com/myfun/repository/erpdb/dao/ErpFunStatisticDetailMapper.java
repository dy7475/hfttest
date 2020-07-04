package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.dto.ErpFunStatisticDetailDto;
import com.myfun.repository.erpdb.po.ErpFunStatisticDetail;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunStatisticDetailMapper extends BaseMapper<ErpFunStatisticDetail, Integer> {
	public int count(ErpFunStatisticDetail erpFunStatisticDetail) throws Exception;
	public int countDetails(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	public List<Map<String, Object>> getDetailCountList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	public List<Map<String, Object>> getNeedRepairHouseCustFlowAnalysisCountList(@Param("shardDbName")String shardDbName,@Param("cityId") Object cityId,@Param("compId")Object compId, @Param("startTime") String startTime,@Param("endTime") String endTime);
	
	public List<Map<String, Object>> getNeedRepairHouseCustFlowAnalysisTrackList(@Param("shardDbName")String shardDbName,@Param("cityId") Object cityId,@Param("compId")Object compId,@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	public List<Map<String, Object>> getCaseList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	
	@SelectProvider(type = ErpFunStatisticDetailMapperProvider.class, method = "getDetailCaseList")
	@ResultType(value=Map.class)
	public List<Map<String, Object>> getDetailCaseList(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> map);
	class ErpFunStatisticDetailMapperProvider{
		public String getDetailCaseList(Map<String, Object> pMap) throws Exception {
			Map<String, Object> param = (Map<String, Object>) pMap.get("param");
			StringBuilder subSqlBuilder = new StringBuilder();
			StringBuilder commonSqlBuilder = new StringBuilder();
			if (param.get("areaId") != null) {
				commonSqlBuilder.append(" and AREA_ID = #{param.areaId}");
			}
			if (param.get("regId") != null) {
				commonSqlBuilder.append(" and REG_ID = #{param.regId}");
			}
			if (param.get("deptId") != null) {
				commonSqlBuilder.append(" and DEPT_ID = #{param.deptId}");
			}
			if (param.get("grId") != null) {
				commonSqlBuilder.append(" and GR_ID = #{param.grId}");
			}
			if (param.get("userId") != null) {
				commonSqlBuilder.append(" and USER_ID = #{param.userId}");
			}
			if (param.get("caseType") != null) {
				commonSqlBuilder.append(" and CASE_TYPE = #{param.caseType}");
			}
			subSqlBuilder.append(" select CASE_ID as caseId from FUN_STATISTIC_DETAIL ");
			subSqlBuilder.append(" where COMP_ID = #{param.compId} ");
			subSqlBuilder.append(commonSqlBuilder);
			if (param.get("statisticType") != null) {
				subSqlBuilder.append(" and STATISTIC_TYPE = #{param.statisticType}");
			}
			if (param.get("trackId") != null) {
				subSqlBuilder.append(" and TRACK_ID = #{param.trackId}");
			}
			if (param.get("statisticTotleId") != null) {
				subSqlBuilder.append(" and STATISTIC_TOTLE_ID = #{param.statisticTotleId}");
			}
			if (param.get("startTime") != null) {
				subSqlBuilder.append(" and CREATE_TIME >= #{param.startTime}");
			}
			if (param.get("endTime") != null) {
				subSqlBuilder.append(" and CREATE_TIME <= #{param.endTime}");
			}
			String tableName = "";
			String fieldName = "";
			String columns = "";
			String caseType = param.get("caseType").toString();
			if (Const.DIC_CASE_TYPE_SALE_FUN.toString().equals(caseType)) {
				tableName = " FUN_SALE ";
				columns = " sale_id,sale_id as caseId,comp_id,city_id,gr_id,reg_id,dept_id,user_id,archive_id,creation_time,creator_uid,sale_no,lock,sale_subject,build_id,build_name,build_code,sale_reg,region_name,section_id,section_name,sale_round,trade_addr,sale_room,sale_hall,sale_wei,sale_yang,sale_type,sale_floor,sale_floors,sale_fitment,sale_direct,sale_year,sale_useage,shop_usage,sale_street,sale_area,sale_total_price,sale_unit_price,sale_source,sale_key,sale_key_num,sale_explrth,sale_cooperate,sale_publish,sale_map,sale_level,plate_type,sale_status,track_time,track_time2,action_time,from_soso,repeat_flag,share_flag,complaint_flag,red_flag,orange_flag,public_time,special_time,schedule_time,deal_time,writeoff_time,secrecy_time,commend_time,private_time,from_public,thumb_url,update_time,sale_cert_time,publish_sites,area_id,video_num,sale_innerarea,sendtotencent,house_source_way,true_flag,you_share_flag,you_share_time,you_buy_count,owner_sex,you_share_id,thumbpic_ver,private_user_id,addr_md5,panorama_map,video_review_flag,youjia_statistic_flag,ads_flag,sync_time,compete_end_time,compete_price,you_share_money_state,proxy_url,sendto_weidian,sendto_youyou,check_code_url,upload_proxy_user,city_share_flag,file_system_type,check_code_fun,qz_code_fun,ownership_type,effective_date,funmanager_salestatus";
				fieldName = "SALE_ID";
			}else if (Const.DIC_CASE_TYPE_LEASE_FUN.toString().equals(caseType)){
				tableName = " FUN_LEASE ";
				columns = " lease_id,lease_id as caseId,comp_id,city_id,gr_id,reg_id,dept_id,user_id,archive_id,creation_time,lease_no,lease_subject,lock,build_id,build_name,build_code,lease_reg,region_name,section_id,section_name,lease_round,trade_addr,plate_type,lease_room,lease_hall,lease_wei,lease_yang,lease_type,lease_floor,lease_floors,lease_fitment,lease_direct,lease_year,lease_useage,lease_street,lease_area,lease_total_price,price_unit,lease_source,lease_level,lease_key,key_time,lease_explrth,lease_consign,lease_cooperate,complaint_flag,lease_publish,lease_map,lease_status,track_time,track_time2,action_time,from_soso,repeat_flag,friend_house,red_flag,orange_flag,public_count,public_time,due_time,special_time,schedule_time,deal_time,writeoff_time,secrecy_time,commend_time,private_time,from_public,thumb_url,update_time,lease_cert_time,publish_sites,area_id,video_num,creator_uid,lease_innerarea,sendtotencent,house_source_way,true_flag,you_share_flag,you_share_time,you_buy_count,owner_sex,you_share_id,thumbpic_ver,private_user_id,lease_room_type,lease_room_classic,flat_share_sex,addr_md5,panorama_map,video_review_flag,youjia_statistic_flag,ads_flag,sync_time,compete_end_time,compete_price,you_share_money_state,sendto_weidian,sendto_youyou,proxy_url,upload_proxy_user,city_share_flag,check_code_fun,ownership_type,qz_code_fun,effective_date,funmanager_salestatus";
				fieldName = "LEASE_ID";
			}else if (Const.DIC_CASE_TYPE_BUY_CUST.toString().equals(caseType)){
				tableName = " FUN_BUY_CUSTOMER ";
				columns = " buy_cust_id,buy_cust_id as caseId,city_id,gr_id,reg_id,comp_id,dept_id,user_id,archive_id,creation_time,buy_cust_no,buy_cust_name,buy_cust_sex,buy_cust_age,buy_cust_career,buy_ability,cust_level,plate_type,buy_cust_source,buy_cust_level,house_room,house_room_1,house_region,region_name,section_id,section_name,build_id,build_name,house_round,house_type,house_useage,house_fitment,house_direct,house_floor_low,house_floor_high,house_price_low,house_price_high,house_area_low,house_area_high,house_year_low,house_year_high,house_look,cust_request,buy_cust_status,track_time,repeat_flag,red_flag,orange_flag,public_count,public_time,special_time,schedule_time,deal_time,writeoff_time,secrecy_time,commend_time,action_time,private_time,from_public,cooperate_flag,update_time,friend_house,cooperate_time,area_id,private_user_id,sync_time,you_share_flag,you_share_time,you_share_id,you_buy_count,city_share_flag";
				fieldName = "BUY_CUST_ID";
			}else if (Const.DIC_CASE_TYPE_RENT_CUST.toString().equals(caseType)){
				tableName = " FUN_RENT_CUSTOMER ";
				columns = " comp_id,rent_cust_id,rent_cust_id as caseId,city_id,gr_id,reg_id,dept_id,user_id,archive_id,creation_time,rent_cust_no,rent_cust_name,rent_cust_sex,rent_cust_age,rent_cust_career,rent_lifebound,rent_ability,cust_level,house_room,house_room_1,house_region,region_name,build_id,build_name,section_id,section_name,house_round,house_type,house_useage,house_fitment,house_direct,plate_type,rent_cust_source,rent_cust_level,house_floor_low,house_floor_high,house_price_low,house_price_high,house_area_low,house_area_high,house_year_low,house_year_high,house_look,cust_request,rent_cust_status,track_time,action_time,repeat_flag,red_flag,orange_flag,public_count,public_time,due_time,special_time,schedule_time,deal_time,writeoff_time,secrecy_time,commend_time,private_time,from_public,cooperate_flag,update_time,friend_house,cooperate_time,area_id,private_user_id,sync_time,you_share_flag,you_share_time,you_share_id,you_buy_count,city_share_flag";
				fieldName = "RENT_CUST_ID";
			}
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append(" select ");
			sqlBuilder.append(columns);
			sqlBuilder.append(" from ");
			sqlBuilder.append(tableName);
			sqlBuilder.append(" where ");
			sqlBuilder.append(fieldName).append(" in ").append("(").append(subSqlBuilder).append(")");
			sqlBuilder.append(" order by ").append(fieldName).append(" desc ");
			return sqlBuilder.toString();
		}
	}
	
	/**
	 * 运营分析-工作量统计
	 * @author 何传强
	 * @since 2017年7月28日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<ErpFunStatisticDetailDto> getWorkCountStatistics(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 工作量统计-获取跟进状态下的数量
	 * @author 臧铁
	 * @since 2017年7月31日 
	 * @param cityId
	 * @param map
	 * @return
	 */
	public int countByWorkTrack(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	
	/**
	 * 获取IP拨号跟进列表
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountTrackIdList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
	
	/**
	 * 获取ip拨号条数
	 * @author 张宏利
	 * @since 2017年8月2日
	 * @param cityId
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> getWorkCountIpLogCounts(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> param);
}


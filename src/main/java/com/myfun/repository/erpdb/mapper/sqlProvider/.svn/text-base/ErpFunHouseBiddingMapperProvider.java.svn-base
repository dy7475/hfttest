package com.myfun.repository.erpdb.mapper.sqlProvider;

import java.util.Map;

import com.myfun.utils.Constants_DIC;
import com.myfun.utils.StringUtil;

/**
 * Created by lcb on 2017-02-08.
 */
public class ErpFunHouseBiddingMapperProvider {
    // Integer cityId, Integer saleLease, Integer buildId, Double biddMoney,Integer houseRoom
    public String compareBiddPrice(Map<String, Object> pMap){
        StringBuilder sb = new StringBuilder();
        sb.append("select TOP 1 ((select COUNT(1) from FUN_HOUSE_BIDDING where SALE_LEASE = "+pMap.get("saleLease")+" AND BIDDING_PRICE > "
                + "%s"
                + " and BUILD_ID = "
                + "%s"
                + " and (YY_STATUS = 1 OR YY_STATUS=0) and QQ_STATUS = 1 and HAOFANG_STATUS = 1 and BIDDING_END_TIME >= GETDATE()) + "
                + "(select COUNT(1) + 1 from FUN_HOUSE_BIDDING where SALE_LEASE = "+pMap.get("saleLease")+" AND BIDDING_PRICE = "
                + "%s"
                + " and BIDDING_SUCC_TIME < GETDATE() and BUILD_ID = "
                + "%s"
                + " and (YY_STATUS = 1 OR YY_STATUS=0) and QQ_STATUS = 1 and HAOFANG_STATUS = 1 and  BIDDING_END_TIME >= GETDATE())) as buildSeq,");
        sb.append("((select COUNT(1) from FUN_HOUSE_BIDDING where SALE_LEASE = "+pMap.get("saleLease")+" AND BIDDING_PRICE > "
                + "%s"
                + " and (YY_STATUS = 1 OR YY_STATUS=0) and QQ_STATUS = 1 and HAOFANG_STATUS = 1 and BIDDING_END_TIME >= GETDATE()) +"
                + "(select COUNT(1) + 1 from FUN_HOUSE_BIDDING where SALE_LEASE = "+pMap.get("saleLease")+" AND BIDDING_PRICE = "
                + "%s"
                + " and (YY_STATUS = 1 OR YY_STATUS=0) and QQ_STATUS = 1 and HAOFANG_STATUS = 1 and BIDDING_SUCC_TIME < GETDATE() and BIDDING_END_TIME >= GETDATE())) as houseSeq,");

        if(null != pMap.get("houseRoom") && !"0".equals(pMap.get("houseRoom"))){
            String tbName = "FUN_SALE";
            String field = "SALE_ID";
            String roomField = "SALE_ROOM";
            if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(pMap.get("saleLease"))){
                tbName = "FUN_LEASE";
                field = "LEASE_ID";
                roomField = "LEASE_ROOM";
            }
            sb.append("((select COUNT(1) from FUN_HOUSE_BIDDING fhb left join ").append(tbName).append(" tb ")
                    .append(" on tb.").append(field).append("=fhb.HOUSE_ID ")
                    .append("where fhb.SALE_LEASE = "+pMap.get("saleLease")+" AND fhb.BIDDING_PRICE > ")
                    .append("%s")
                    .append(" and tb.").append(roomField).append("=").append("%s")
                    .append(" and tb.BUILD_ID=").append("%s")
                    .append(" and (YY_STATUS = 1 OR YY_STATUS=0) and fhb.QQ_STATUS = 1 and fhb.HAOFANG_STATUS = 1 and fhb.BIDDING_END_TIME >= GETDATE()) +")
                    .append("(select COUNT(1) + 1 from FUN_HOUSE_BIDDING fhb left join ")
                    .append(tbName).append(" tb ")
                    .append(" on tb.").append(field).append("=fhb.HOUSE_ID ")
                    .append("where fhb.SALE_LEASE = "+pMap.get("saleLease")+" AND fhb.BIDDING_PRICE = %s")
                    .append(" and tb.").append(roomField).append("=%s")
                    .append(" and tb.BUILD_ID=%s")
                    .append(" and (YY_STATUS = 1 OR YY_STATUS=0) and fhb.QQ_STATUS = 1 and fhb.HAOFANG_STATUS = 1 and fhb.BIDDING_SUCC_TIME < GETDATE() and fhb.BIDDING_END_TIME >= GETDATE())) as roomSeq,");
        }
        sb.append("0 as buildExist,").append("0 as houseExist");
        String sql = String.format(sb.toString(), pMap.get("biddMoney"), pMap.get("buildId"), pMap.get("biddMoney"), pMap.get("buildId"), pMap.get("biddMoney"),pMap.get("biddMoney"), pMap.get("biddMoney")
                , pMap.get("houseRoom"), pMap.get("buildId"), pMap.get("biddMoney"), pMap.get("houseRoom"), pMap.get("buildId"));
        return sql;
    }

	public String getHouseBiddingList(Map<String, Object> pMap) {
		Map<String, Object> paramMap = (Map<String, Object>) pMap.get("pMap");
		String saleLease = paramMap.get("saleLease") + "";
		Object buildId = paramMap.get("buildId");
		String cityId = paramMap.get("cityId") + "";
		String archiveId = paramMap.get("archiveId") + "";
		Integer compId = Integer.valueOf(paramMap.get("compId") + "");
		String tableName = Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(saleLease) ? "SALE" : "LEASE";

		String sql = "SELECT A.CITY_ID,ISNULL(C.YY_STATUS,0) YY_STATUS,A.TRUE_FLAG,A.COMPLAINT_FLAG," + "A."
				+ tableName + "_STATUS AS HOUSE_STATUS,A.USER_ID,A." + tableName + "_PUBLISH as HOUSE_PUBLISH," + "A."
				+ tableName + "_USEAGE as HOUSE_USEAGE,A." + tableName + "_ID as HOUSE_ID,A." + tableName
				+ "_NO as HOUSE_NO,A." + tableName + "_FLOOR as HOUSE_FLOOR," + "A." + tableName
				+ "_SUBJECT as HOUSE_TITLE,A.BUILD_ID,A." + tableName + "_ROOM as HOUSE_ROOM,A." + tableName
				+ "_HALL as HOUSE_HALL,A.BUILD_NAME," + "A." + tableName + "_FITMENT as HOUSE_FITMENT,A." + tableName
				+ "_AREA as HOUSE_AREA,A." + tableName + "_TOTAL_PRICE as HOUSE_TOTAL_PRICE," + "A." + tableName
				+ "_MAP as HOUSE_MAP,A.CREATION_TIME,A.VIDEO_NUM,A.THUMB_URL,A.THUMBPIC_VER,getdate() as BIDD_DB_SYSTIME,"
				+ "C.BIDDING_DAYS,C.BIDDING_PRICE,C.BIDDING_END_TIME,1 SALE_LEASE,(case when (DATEDIFF(HOUR,getdate(),BIDDING_END_TIME)%24) > 0 "
				+ "then ((DATEDIFF(HOUR,getdate(),BIDDING_END_TIME)/24)+1) else ((DATEDIFF(HOUR,getdate(),BIDDING_END_TIME)/24))end) as REMAINS_DAYS,"
				+ "(DATEDIFF(MI,getdate(),BIDDING_END_TIME)/60) as REMAINS_HOURS,DATEDIFF(MI,getdate(),C.BIDDING_END_TIME) as REMAINS_MINUS,"
				+ "C.BIDDING_END_TIME as BIDDENDTIME,ISNULL(C.SALE_LEASE,0) as BIDDFLAG,C.BIDD_ID FROM ";
		if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(saleLease)) {
			sql += "FUN_SALE A LEFT JOIN FUN_HOUSE_BIDDING C ON A.SALE_ID = C.HOUSE_ID AND C.BIDDING_END_TIME >= getdate() "
					+ "AND C.SALE_LEASE = " + saleLease + " AND YY_STATUS = 1 WHERE A.COMP_ID = " + compId
					+ " AND A.CITY_ID = " + cityId + " AND A.ARCHIVE_ID = " + archiveId + " "
					+ "AND A.SALE_PUBLISH = '1' AND A.SALE_STATUS = " + saleLease + "";
		} else {
			sql += "FUN_LEASE A LEFT JOIN FUN_HOUSE_BIDDING C ON A.LEASE_ID = C.HOUSE_ID AND C.BIDDING_END_TIME >= getdate() "
					+ "AND C.SALE_LEASE = " + saleLease + " AND YY_STATUS = 1 WHERE A.COMP_ID = " + compId
					+ " AND A.CITY_ID = " + cityId + " AND A.ARCHIVE_ID = " + archiveId + ""
					+ "AND A.LEASE_PUBLISH = '1' AND A.LEASE_STATUS = " + saleLease + "";
		}
		if (buildId==null||StringUtil.isBlank(String.valueOf(buildId))) {
			sql += " ORDER BY C.BIDDING_END_TIME DESC, A.UPDATE_TIME DESC";
		} else {
			sql += " AND A.BUILD_ID =" + buildId + " ORDER BY C.BIDDING_END_TIME DESC, A.UPDATE_TIME DESC";
		}
		return sql;
	}
}

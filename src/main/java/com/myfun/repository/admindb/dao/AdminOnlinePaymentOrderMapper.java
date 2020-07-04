package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.onlinepay.param.DealRecordListParam;
import com.myfun.erpWeb.onlinepay.vo.OnlinePaymentOrderVO;
import com.myfun.repository.admindb.po.AdminOnlinePaymentOrder;
import com.myfun.repository.admindb.po.AdminOnlinePaymentOrderExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface AdminOnlinePaymentOrderMapper extends BaseMapper<AdminOnlinePaymentOrder, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminOnlinePaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminOnlinePaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminOnlinePaymentOrder> selectByExample(AdminOnlinePaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminOnlinePaymentOrder record,
			@Param("example") AdminOnlinePaymentOrderExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminOnlinePaymentOrder record,
			@Param("example") AdminOnlinePaymentOrderExample example);

	List<OnlinePaymentOrderVO> selectOrderList( DealRecordListParam param);

    @SelectProvider(type= AdminOnlinePaymentOrderMapperSqlProvider.class ,method = "selectReceiveAmountList")
    List<Map<String, BigDecimal>> selectReceiveAmountList(@Param("param")DealRecordListParam param);

    BigDecimal sumOrderAmount( @Param("cityId") Integer cityId, @Param("businessId") Integer cooperateId, @Param("businessType") byte businessType);

    class AdminOnlinePaymentOrderMapperSqlProvider {

        public static String selectReceiveAmountList(Map<String, Object> pMap) throws Exception {
            DealRecordListParam param = (DealRecordListParam) pMap.get("param");

			String queryColumn = DateUtil.getDateDimensionGroupBy2(param.getTimeType() + "", "PAYMENT_TIME", new String[]{param.getTimeStart(), param.getTimeEnd()});
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("SET DATEFIRST 1;")
					.append("SELECT ")
					.append(queryColumn)
					.append(" AS dateCount,");
			sqlBuilder.append(" sum(RECEIVED_AMOUNT) AS receivedAmount");
			sqlBuilder.append(" FROM ONLINE_PAYMENT_ORDER a join ONLINE_PAYMENT_ORDER_PAYEE b on a.city_id = b.city_id and a.comp_id = b.comp_id and a.id = b.ORDER_ID  ")
					.append(" WHERE ")
					.append(" a.PAYMENT_STATUS = 1 AND ORDER_TYPE= 1 and XW_BANK_ACCOUNT_ID = #{param.accountId} and b.COMP_ID = #{param.compId} ");

			sqlBuilder.append(" AND PAYMENT_TIME >= #{param.timeStart}");
			sqlBuilder.append(" AND PAYMENT_TIME <= #{param.timeEnd}");
			sqlBuilder.append(" group by ").append(queryColumn);

            return sqlBuilder.toString();
        }
    }
}
package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.ApplicationContext;

import com.myfun.repository.erpdb.po.ErpCollReq;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQL;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.mybatis.query.SqlFactory;
import com.myfun.utils.Constants_DIC;

public interface ErpCollReqMapper extends BaseMapper<ErpCollReq, ErpCollReq> {
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(method ="getCollList", type=CollReqSqlProvider.class)
	@ResultMap(value="BaseResultMap")
	List<ErpCollReq> getCollList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);
	class CollReqSqlProvider{
		public String getCollList(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap) pMap.get("param");
			Condition condition = new Condition();
			condition.add(new ConditionItem("IS_DEL","=","0"));
			if (Constants_DIC.DIC_COLL_FLAG_2.equals(param.getString("collFlag"))) {
				if(param.getBoolean("isPersonalVersion")){
					condition.add(new ConditionItem("TARGET_USER_ID", "=", param.getInteger("currentUserId")));
				}else{
					condition.add(new ConditionItem("TARGET_COMP_ID", "=", param.getInteger("compId")));
				}
			} else if (Constants_DIC.DIC_COLL_FLAG_1.equals(param.getString("collFlag"))) {
				if(param.getBoolean("isPersonalVersion")){
					condition.add(new ConditionItem("SOURCE_USER_ID", "=", param.getInteger("currentUserId")));
				}else{
					condition.add(new ConditionItem("SOURCE_COMP_ID", "=", param.getInteger("compId")));
				}
			} else {
				Condition compCondition = new Condition();
				if(param.getBoolean("isPersonalVersion")){
					compCondition.add(new ConditionItem("TARGET_USER_ID", "=", param.getInteger("currentUserId")));
					compCondition.add(Condition.OR, new ConditionItem("SOURCE_USER_ID", "=", param.getInteger("currentUserId")));
				}else{
					compCondition.add(new ConditionItem("TARGET_COMP_ID", "=", param.getInteger("compId")));
					compCondition.add(Condition.OR, new ConditionItem("SOURCE_COMP_ID", "=", param.getInteger("compId")));
				}
				condition.add(compCondition);
			}
			String collFrom = param.getString("collFrom");
			if(StringUtils.isNotBlank(collFrom)){
				condition.add(new ConditionItem("COLL_FROM", "=", collFrom));
			}else{
				if("1".equals(param.getString("YOUJIA_DEPT_FLAG"))){
					condition.add(new ConditionItem("COLL_FROM", "!=","4"));				
				}else if("1".equals(param.getString("CITY_SHARE_FLAG"))){
					condition.add(new ConditionItem("COLL_FROM", "!=","3"));
				}else{
					condition.add(new ConditionItem("COLL_FROM", "in",new Object[]{"1","2"}));
				}
			}
		/*	if (!CommonUtil.isnull(param.getCOLL_TIME())) {
				String[] deteFields = Myfun7Helper.getConditionDate(param
						.getCOLL_TIME());
				if (!CommonUtil.isnull(deteFields) && deteFields.length == 2) {
					Myfun7Helper.builderTimeAreaCondition(condition, deteFields[0],
							deteFields[1], "COLL_TIME");
				}
			}*/
			if (StringUtils.isNotBlank(param.getString("userId"))) {
				Condition userCondition = new Condition();
				userCondition.add(new ConditionItem("SOURCE_USER_ID", "=","#{param.userId}"));
				userCondition.add(Condition.OR, new ConditionItem("TARGET_USER_ID",
						"=", param.getString("userId")));
				condition.add(userCondition);
			}
			String dataRange = param.getString("dataRange");
			Object object = param.getObject("deptIds");
			String[] deptIds = null;
			if(object!=null){
				deptIds = (String[])object;
			}
			if(StringUtils.isNotBlank(dataRange)){
				String[] val = dataRange.split("~");
				condition.add(new ConditionItem("COLL_TIME",">=",val[0]));
				condition.add(new ConditionItem("COLL_TIME","<=",val[1]+" 23:59:59"));
			}
			/*if(!CommonUtil.isnull(dataRange)) {
				String[] val = dataRange.split("~");
				Myfun7Helper.builderTimeAreaCondition(condition, val[0],
						val[1], "COLL_TIME");
			}*/
		
	
			if (deptIds != null && deptIds.length > 0) {
				Condition deptCondition = new Condition();
				deptCondition.add(new ConditionItem("SOURCE_DEPT_ID", "IN", deptIds));
				deptCondition.add(Condition.OR, new ConditionItem("TARGET_DEPT_ID","IN", deptIds));
				condition.add(deptCondition);
			}
			if (!StringUtils.isBlank(param.getString("replyResult"))) {
				condition.add(new ConditionItem("REPLY_RESULT", "=", "#{param.replyResult}"));
			}
			String lookStatus = param.getString("daikan");
			if (!StringUtils.isBlank(lookStatus)) {
				Condition lookCondition = new Condition();
				// 如果是未带看 两个的值都必须是零,如果有带看则其中一个为1 即可
				if ("0".equals(lookStatus)) {
					if(param.getBoolean("isPersonalVersion")){
						lookCondition.add(new ConditionItem("(case SOURCE_USER_ID when " +param.getInteger("currentUserId")+ " then SOURCE_LOOK_STATUS else 2 end)", "=", "0"));
						lookCondition.add(Condition.OR, new ConditionItem("(case TARGET_USER_ID when " +param.getInteger("currentUserId")+ " then TARGET_LOOK_STATUS else 2 end)", "=", "0"));
					}else{
						lookCondition.add(new ConditionItem("(case SOURCE_COMP_ID when " +param.getInteger("compId")+ " then SOURCE_LOOK_STATUS else 2 end)","=","1"));
						lookCondition.add(Condition.OR, new ConditionItem("(case TARGET_COMP_ID when " +param.getInteger("compId")+ " then TARGET_LOOK_STATUS else 2 end)", "=", "1"));
					}
				} else {
					if(param.getBoolean("isPersonalVersion")){
						lookCondition.add(new ConditionItem("(case SOURCE_USER_ID when " +param.getInteger("currentUserId")+ " then SOURCE_LOOK_STATUS else 2 end)","=","0"));
						lookCondition.add(Condition.OR, new ConditionItem("(case TARGET_USER_ID when " +param.getInteger("currentUserId")+ " then TARGET_LOOK_STATUS else 2 end)","=","1"));
					}else{
						lookCondition.add(new ConditionItem("(case SOURCE_COMP_ID when " +param.getInteger("compId")+ " then SOURCE_LOOK_STATUS else 2 end)","=","1"));
						lookCondition.add(Condition.OR, new ConditionItem("(case TARGET_COMP_ID when " +param.getInteger("compId")+ " then TARGET_LOOK_STATUS else 2 end)","=","1"));
					}
				}
				condition.add(lookCondition);
			}
			String number = param.getString("NUMBER");
			if (!StringUtils.isBlank(number)) {
				Condition numberCondition = new Condition();
				numberCondition.add(new ConditionItem("SOURCE_NO", "LIKE", "%"
						+ number + "%"));
				numberCondition.add(Condition.OR, new ConditionItem("TARGET_NO",
						"LIKE", "%" + number + "%"));
				numberCondition.add(Condition.OR, new ConditionItem(
						"SOURCE_LOOK_NUMBER", "LIKE", "%" + number + "%"));
				numberCondition.add(Condition.OR, new ConditionItem(
						"TARGET_LOOK_NUMBER", "LIKE", "%" + number + "%"));
				condition.add(numberCondition);
			}
			SQL sql = SqlFactory.createDelFaultSelectSql(" COLL_REQ ", false, condition, new Columns(new String[]{"*"}), "COLL_TIME DESC",null);
			return SQLBuilderSupport.constructSQLForSelect(sql).toString();
		}
	}
}
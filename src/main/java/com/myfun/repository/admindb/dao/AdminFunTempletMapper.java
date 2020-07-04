package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.erpWeb.common.param.AddEditCompDefineTemplateParam;
import com.myfun.erpWeb.common.param.CompDefineTemplateParam;
import com.myfun.repository.admindb.po.AdminFunTemplet;
import com.myfun.repository.admindb.po.AdminFunTempletExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQL;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.mybatis.query.SqlFactory;

public interface AdminFunTempletMapper extends BaseMapper<AdminFunTemplet, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunTemplet> selectByExampleWithBLOBs(AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunTemplet> selectByExample(AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunTemplet record,
								 @Param("example") AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") AdminFunTemplet record,
								 @Param("example") AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunTemplet record, @Param("example") AdminFunTempletExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminFunTemplet record);

	@SelectProvider(method ="selectCompDefineTemplate", type= AdminFunTempletSqlProvider.class)
	@ResultMap("ResultMapWithBLOBs")
	List<AdminFunTemplet> selectCompDefineTemplate(CompDefineTemplateParam param);

	@SelectProvider(method ="selectCompTemplate", type= AdminFunTempletSqlProvider.class)
	@ResultMap("ResultMapWithBLOBs")
	@AccessReadonlyDb
	List<AdminFunTemplet> selectCompTemplate(CompDefineTemplateParam param);

	void updateTemplateById(AddEditCompDefineTemplateParam param);

	void insertTemplate(AddEditCompDefineTemplateParam param);

	class AdminFunTempletSqlProvider {

		public String selectCompDefineTemplate(CompDefineTemplateParam param) {
			String type = param.getType();
			Byte saleLease = param.getCaseType();
			Byte queryType =  param.getQueryType();// 0为公司 1为个人
			if("SUBJECT".equals(type)){
				type = "1";
			}else{//CHARACT
				type = "0";
			}
			String orderStr = "TYPES_FLAG ASC";
			String qType =  param.getType()+"";//当前是否是更新或者添加后的查询
			if("INIT".equals(qType)){
				orderStr = "updateTime desc,ID desc,"+orderStr;
			}else if("SEQ".equals(qType)){
				orderStr = "use_count desc,"+orderStr;
			}else {
				orderStr = "NewID()";
			}
			Condition condition = new Condition();
			condition.add(new ConditionItem("TYPE","=",type));
			condition.add(new ConditionItem("CITY_ID","=", param.getCityId()));
			if(null != queryType && 0 == queryType){
				condition.add(new ConditionItem("COMP_ID","=", param.getCompId()));//使用的中心库ID
				condition.add(new ConditionItem("ARCHIVE_ID","IS","NULL"));//用户id等于空
			}else{
				condition.add(new ConditionItem("ARCHIVE_ID","=", param.getArchiveId()));
			}
			if((null != saleLease && 1 == saleLease) || "1".equals(type)){
				Condition cond2 = new Condition();
				cond2.add(new ConditionItem("SALE_LEASE","=","0"));
				cond2.add(Condition.OR, new ConditionItem("SALE_LEASE","=",saleLease));
				condition.add(cond2);
			}else{
				condition.add(new ConditionItem("SALE_LEASE","=",saleLease));
			}
			SQL sql = SqlFactory.createDelFaultSelectSql("FUN_TEMPLET", false, condition, null, orderStr, null);
			return 	SQLBuilderSupport.constructSQLForSelect(sql).toString();
		}

		public String selectCompTemplate(CompDefineTemplateParam param) {
			String type = param.getType();
			Byte saleLease = param.getCaseType();
			String types = param.getTypes();
			Byte useage = param.getUseage();//当前类型是什么用途的信息
			if(StringUtils.isNotBlank(type) && "SUBJECT".equals(type)){
				type = "1";
			}
			Condition condition = new Condition();
			/**
			 * lcb 添加随机排序
			 *  **/
			String orderStr="NewID() ";
			if(!"".equals(types) && !"NONE".equals(types)){
				String [] array = types.split(",");
				//下标从1开始为查询参数,0为NONE是一个占位的单词无意义.
				String flag = "";
				for(int index=1;index<array.length;index++){
					flag = array[index];
					if("1".equals(flag)){
						condition.add(new ConditionItem("SUBSTRING(TYPES_FLAG,"+index+",1)","=",flag));
					}
				}
//			orderStr += " ASC";
			}else{
//			orderStr += " DESC";
			}
			if(StringUtils.isNotBlank(type)){
				condition.add(new ConditionItem("TYPE","=",type));
			}
			condition.add(new ConditionItem("HOUSE_USEAGE","IN",new Object[]{useage,0}));//0表示为所有的都通用
			condition.add(new ConditionItem("CITY_ID","=","0"));
			condition.add(new ConditionItem("COMP_ID","=","0"));
			if((null != saleLease && 1 == saleLease)  || "1".equals(type)){
				Condition cond2 = new Condition();
				cond2.add(new ConditionItem("SALE_LEASE","=","0"));
				cond2.add(Condition.OR, new ConditionItem("SALE_LEASE","=",saleLease));
				condition.add(cond2);
			}else{
				condition.add(new ConditionItem("SALE_LEASE","=",saleLease));
			}
			SQL sql = SqlFactory.createDelFaultSelectSql("FUN_TEMPLET", false, condition, null, orderStr, null);
			return 	SQLBuilderSupport.constructSQLForSelect(sql).toString();
		}
	}
}
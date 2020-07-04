package com.myfun.service.business.admindb.synchrs.enums;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;

/**
 * 
* @ClassName: DeptAndEmpTransferConstants 
* @Description: 部门、人员调迁常量枚举类
* @author tangliang1
* @date 2020年6月28日 上午10:20:22 
*
 */
public class DeptAndEmpTransferConstants {

	/**
	 * 
	* @ClassName: EmpChangType 
	* @Description:人员异动类型代码
	* @author tangliang1
	* @date 2020年6月28日 上午10:22:08 
	*
	 */
	public enum EmpChangTypeEnum{
		
		EMP_CHANGES("changes","异动操作",EmpChangType_changesEnum.getChanges()),
		
		EMP_ATTRIBUTE("attribute","属生修改",EmpChangType_attributeEnum.getChanges()),
		
		EMP_JOIN("join","入职登记",EmpChangType_joinEnum.getChanges()),
		
		EMP_LEAVE("leave","离职记录",EmpChangType_leaveEnum.getChanges()),
		
		;
		
		//异动类型代码
		private String typeCode;
		
		//异动类型描述
		private String desc;
		//异动事件列表
		private List<JSONObject> changeIdInfos;
		
		public String getTypeCode() {
			return typeCode;
		}


		public void setTypeCode(String typeCode) {
			this.typeCode = typeCode;
		}


		public String getDesc() {
			return desc;
		}


		public void setDesc(String desc) {
			this.desc = desc;
		}


		public List<JSONObject> getChangeIdInfos() {
			return changeIdInfos;
		}


		public void setChangeIdInfos(List<JSONObject> changeIdInfos) {
			this.changeIdInfos = changeIdInfos;
		}


		private EmpChangTypeEnum(String typeCode, String desc,List<JSONObject> changeIdInfos) {
			this.typeCode = typeCode;
			this.desc = desc;
			this.changeIdInfos=changeIdInfos;
		}
		
		
		/**
		 * 
		 * @Title: getValues
		 * @Description: 获取所有的枚举值
		 * @param @return 设定文件
		 * @return List<Map> 返回类型
		 * @throws
		 */
		public static List<JSONObject> getValues() {
			EmpChangTypeEnum[] types = EmpChangTypeEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (EmpChangTypeEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("typeCode", t.getTypeCode());
				obj.put("typeDesc", t.getDesc());
				obj.put("typeEvents", t.getChangeIdInfos());
				list.add(obj);
			}
			return list;
		}
		

		
		/**
		 * 
		 * @Title: getByType
		 * @Description: 获取指定类型
		 * @param @param type
		 * @param @return 设定文件
		 * @return PayType 返回类型
		 * @throws
		 */
		public static EmpChangTypeEnum getByType(String typeCode) {
			EmpChangTypeEnum[] types = EmpChangTypeEnum.values();
			for (EmpChangTypeEnum t : types) {
				if (t.getTypeCode().equals(typeCode)) {
					return t;
				}
			}
			return null;
		}
		
	}
	
	
	
	/**
	 * 
	* @ClassName: EmpChangType_changesEnum 
	* @Description:人员异动——[异动操作]事件类型枚举
	* @author tangliang1
	* @date 2020年6月28日 上午10:26:43 
	*
	 */
	public enum EmpChangType_changesEnum{
		
		/*** 1、晋升 ***/
		JIN_SHENG(1,"晋升"),
		/*** 2、调迁 ***/
		DIAO_QIAN(2,"调迁"),
		/*** 3、调迁及晋升 ***/
		JINSHENG_AND_DIAOQIAN(3,"调迁及晋升"),
		/*** 4、调迁及降职 ***/
		DIAOQIAN_AND_JIANGZHI(4,"调迁及降职"),
		/*** 5、调迁及转换职衔 ***/
		DIAOQIAN_AND_ZHUANGHUANZHIXIAN(5,"调迁及转换职衔"),
		/*** 6、转换职衔 ***/
		ZHUAN_HUAN_ZHI_XIAN(6,"转换职衔"),
	
		/*** 7、平调 ***/
		PING_DIAO(7,"平调"),
		/*** 8、降职 ***/
		JIANG_ZHI(8,"降职"),
		/*** 9、降级 ***/
		JIANG_JI(9,"降级"),
		/*** 10、录入更正 ***/
		LU_RU_GENG_ZHENG(10,"录入更正"),
		/*** 11、其它 ***/
		QI_TA(11,"其它"),
		/*** 12、主管变更 ***/
		ZHU_GUAN_BIAN_GENG(12,"主管变更"),
		/*** 13、调迁 (公司) ***/
		DIAO_QIAN_COMPANY(13,"调迁 (公司)"),
		/*** 14、提升 ***/
		TI_SHENG(14,"提升"),
		;
		
		private Integer changeCode;
		private String changeDesc;
		
		public Integer getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(Integer changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private EmpChangType_changesEnum(Integer changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			EmpChangType_changesEnum[] types = EmpChangType_changesEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (EmpChangType_changesEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	
	/**
	 * 
	* @ClassName: EmpChangType_attributeEnum 
	* @Description:人员异动——[属生修改]事件类型枚举
	* @author tangliang1
	* @date 2020年6月28日 上午10:26:43 
	*
	 */
	public enum EmpChangType_attributeEnum{
		
		/*** 1、内部调动 ***/
		NEI_BU_DIAO_YONG(1,"内部调动"),
		/*** 2、干部任免 ***/
		GAN_BU_REN_MIAN(2,"干部任免"),
		/*** 3、级别调动 ***/
		JI_BIE_DIAO_DONG(3,"级别调动"),
		/*** 4、录入更正 ***/
		LU_RU_GENG_ZHENG(4,"录入更正"),
		/*** 5、其它 ***/
		QI_TA(5,"其它"),
		/*** 6、晋级 ***/
		JIN_JI(6,"晋级"),
		/*** 7、降级 ***/
		JIANG_JI(7,"降级"),

		;
		
		private Integer changeCode;
		private String changeDesc;
		
		public Integer getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(Integer changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private EmpChangType_attributeEnum(Integer changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			EmpChangType_attributeEnum[] types = EmpChangType_attributeEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (EmpChangType_attributeEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	
	/**
	 * 
	* @ClassName: EmpChangType_joinEnum 
	* @Description:人员异动——[入职登录]事件类型枚举
	* @author tangliang1
	* @date 2020年6月28日 上午10:26:43 
	*
	 */
	public enum EmpChangType_joinEnum{
		
		/*** 1、重聘 ***/
		CHONG_PIN(1,"重聘"),
		/*** 2、新聘 ***/
		XIN_PIN(2,"新聘"),

		;
		
		private Integer changeCode;
		private String changeDesc;
		
		public Integer getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(Integer changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private EmpChangType_joinEnum(Integer changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			EmpChangType_joinEnum[] types = EmpChangType_joinEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (EmpChangType_joinEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	/**
	 * 
	* @ClassName: EmpChangType_changesEnum 
	* @Description:人员异动——[离职记录]事件类型枚举
	* @author tangliang1
	* @date 2020年6月28日 上午10:26:43 
	*
	 */
	public enum EmpChangType_leaveEnum{
		
		/*** 1、自动离职 ***/
		ZI_DONG_LI_ZHI(1,"自动离职"),
		/*** 2、解雇 ***/
		JIE_GU(2,"解雇"),
		/*** 3、转经纪人S7 ***/
		ZHUAN_JING_JI_REN_S7(3,"转经纪人S7"),
		/*** 4、被要求离职 ***/
		BEI_YAO_QIU_LI_ZHI(4,"被要求离职"),
		/*** 5、主管同意即时离职 ***/
		ZHU_GUAN_TONG_YI_JISHI_LIZHI(5,"主管同意即时离职"),
		/*** 6、未经主管同意下离职 ***/
		WEI_JING_ZHUGUAN_TONGYI_LIZHI(6,"未经主管同意下离职"),
	
		/*** 7、无故失踪 ***/
		WU_GU_SHI_ZONG(7,"无故失踪"),
		/*** 8、给予足够通知期离职 ***/
		TONG_ZHI_QI_LIZHI(8,"给予足够通知期离职"),
		/*** 9、未给予足够通知期离职 ***/
		WEI_TONG_ZHI_QI_LIZHI(9,"未给予足够通知期离职"),
		/*** 10、合同到期 ***/
		HE_TONG_DAO_QI(10,"合同到期"),
		/*** 11、其它 ***/
		QI_TA(11,"其它"),
		/*** 12、主动离职 ***/
		ZHU_DONG_LIZHI(12,"主动离职"),
		/*** 13、被动离职 ***/
		BEI_DONG_LIZHI(13,"被动离职"),
		/*** 14、作废 ***/
		ZUO_FEI(14,"作废"),
		;
		
		private Integer changeCode;
		private String changeDesc;
		
		public Integer getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(Integer changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private EmpChangType_leaveEnum(Integer changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			EmpChangType_leaveEnum[] types = EmpChangType_leaveEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (EmpChangType_leaveEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	
	//------------------------------- 以下为部门异动事件枚举  -------------------------------
	
	/**
	 * 
	* @ClassName: DeptChangTypeEnum 
	* @Description:部门异动类型代码
	* @author tangliang1
	* @date 2020年6月28日 上午10:22:08 
	*
	 */
	public enum DeptChangTypeEnum{
		
		
		ADD("1","新增",DeptChangType_addEnum.getChanges()),
		
		CHANGE("2","变更",DeptChangType_changeEnum.getChanges()),
		
		CLOSE("3","关闭",DeptChangType_closeEnum.getChanges()),
		
		REOPEN("4","重开",DeptChangType_reopenEnum.getChanges()),
		
		;
		
		//异动类型代码
		private String typeCode;
		
		//异动类型描述
		private String desc;
		//异动事件列表
		private List<JSONObject> changeIdInfos;
		
		public String getTypeCode() {
			return typeCode;
		}


		public void setTypeCode(String typeCode) {
			this.typeCode = typeCode;
		}


		public String getDesc() {
			return desc;
		}


		public void setDesc(String desc) {
			this.desc = desc;
		}


		public List<JSONObject> getChangeIdInfos() {
			return changeIdInfos;
		}


		public void setChangeIdInfos(List<JSONObject> changeIdInfos) {
			this.changeIdInfos = changeIdInfos;
		}


		private DeptChangTypeEnum(String typeCode, String desc,List<JSONObject> changeIdInfos) {
			this.typeCode = typeCode;
			this.desc = desc;
			this.changeIdInfos=changeIdInfos;
		}
		
		
		/**
		 * 
		 * @Title: getValues
		 * @Description: 获取所有的枚举值
		 * @param @return 设定文件
		 * @return List<Map> 返回类型
		 * @throws
		 */
		public static List<JSONObject> getValues() {
			DeptChangTypeEnum[] types = DeptChangTypeEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (DeptChangTypeEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("typeCode", t.getTypeCode());
				obj.put("typeDesc", t.getDesc());
				obj.put("typeEvents", t.getChangeIdInfos());
				list.add(obj);
			}
			return list;
		}
		

		
		/**
		 * 
		 * @Title: getByType
		 * @Description: 获取指定类型
		 * @param @param type
		 * @param @return 设定文件
		 * @return PayType 返回类型
		 * @throws
		 */
		public static DeptChangTypeEnum getByType(String typeCode) {
			DeptChangTypeEnum[] types = DeptChangTypeEnum.values();
			for (DeptChangTypeEnum t : types) {
				if (t.getTypeCode().equals(typeCode)) {
					return t;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * 
	* @ClassName: DeptChangType_addEnum 
	* @Description: 部门异动——部门新增
	* @author tangliang1
	* @date 2020年6月28日 上午11:28:28 
	*
	 */
	public enum DeptChangType_addEnum{
		
		/*** 1、新增 ***/
		ADD("100","新增"),

		;
		
		private String changeCode;
		private String changeDesc;
		
		public String getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(String changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private DeptChangType_addEnum(String changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			DeptChangType_addEnum[] types = DeptChangType_addEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (DeptChangType_addEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	/**
	 * 
	* @ClassName: DeptChangType_changeEnum 
	* @Description:部门异动——信息变更
	* @author tangliang1
	* @date 2020年6月28日 上午11:31:26 
	*
	 */
	public enum DeptChangType_changeEnum{
		
		/*** 1、属性变更 ***/
		ATTRIBUTE_CHANGE("1","属性变更"),
		/*** 2、部门调迁 ***/
		DEPT_TRANSFER("2","部门调迁"),
		/*** 3、主管变更 ***/
		DIRECTOR_CHANGE("3","主管变更"),
		/*** 6、电话变更 ***/
		MOBILE_CHANGE("6","电话变更"),
		/*** 7、名称变更 ***/
		NAME_CHANGE("7","名称变更"),
		/*** 0、未知变更 ***/
		CHANGE_UNKNOWN("0","未知变更"),

		;
		
		private String changeCode;
		private String changeDesc;
		
		public String getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(String changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private DeptChangType_changeEnum(String changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			DeptChangType_changeEnum[] types = DeptChangType_changeEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (DeptChangType_changeEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	/**
	 * 
	* @ClassName: DeptChangType_closeEnum 
	* @Description: 部门异动——部门关闭
	* @author tangliang1
	* @date 2020年6月28日 上午11:28:28 
	*
	 */
	public enum DeptChangType_closeEnum{
		
		/*** 300、关闭 ***/
		CLOSE("300","关闭"),

		;
		
		private String changeCode;
		private String changeDesc;
		
		public String getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(String changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private DeptChangType_closeEnum(String changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			DeptChangType_closeEnum[] types = DeptChangType_closeEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (DeptChangType_closeEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	
	/**
	 * 
	* @ClassName: DeptChangType_reopenEnum 
	* @Description: 部门异动——部门重开
	* @author tangliang1
	* @date 2020年6月28日 上午11:28:28 
	*
	 */
	public enum DeptChangType_reopenEnum{
		
		/*** 400、重开 ***/
		REOPEN("400","重开"),

		;
		
		private String changeCode;
		private String changeDesc;
		
		public String getChangeCode() {
			return changeCode;
		}


		public void setChangeCode(String changeCode) {
			this.changeCode = changeCode;
		}


		public String getChangeDesc() {
			return changeDesc;
		}


		public void setChangeDesc(String changeDesc) {
			this.changeDesc = changeDesc;
		}

		private DeptChangType_reopenEnum(String changeCode,String changeDesc) {
			this.changeCode=changeCode;
			this.changeDesc=changeDesc;
		}
		
		public static List<JSONObject> getChanges() {
			DeptChangType_reopenEnum[] types = DeptChangType_reopenEnum.values();
			List<JSONObject> list = Lists.newArrayList();
			for (DeptChangType_reopenEnum t : types) {
				JSONObject obj = new JSONObject();
				obj.put("changeId", t.getChangeCode());
				obj.put("changeDesc", t.getChangeDesc());
				list.add(obj);
			}
			return list;
		}
	}
	
	
}

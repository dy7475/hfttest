package com.myfun.utils;

/**
 * Created by 系统操作相关信息类 on 2016-10-28.
 */
public class SystemOperateUtil {
	/**
	 * 1:权限配置 2:组织机构 3:员工调动 4:系统参数 5:楼盘规则 6:数据移交7:楼盘变更
	 */
	public enum SSL_TYPE {
		OPERS_SETTING("1", "修改了该用户权限","1"),//1修改了该用户权限
		OPERS_DELETE("2", "删除了该角色权限","1"),//2 删除了该角色权限
		UPDATE_USER("3", "修改了该用户信息","2"),
		RESET_PWD("4", "重置了该用户密码","2"),
		CREATE_USER("5", "创建了该用户账号","2"),
		DELETE_USER("6", "注销了该用户账号","2"),
		DISABLE_USER("7", "冻结了该用户账号","2"),
		ENABLE_USER("8", "启用了该用户账号","2"),
		MOVE_USER("9", "将该员工从A店调动至B店","3"),
		CREATE_AREA("10", "创建了大区","2"),
		DELETE_AREA("11", "删除了大区","2"),
		CREATE_REGION("12", "创建了片区","2"),
		DELETE_REGION("13", "删除了片区","2"),
		UPDATE_AREA("14", "修改了大区信息","2"),
		UPDATE_REGION("15", "修改了片区信息","2"),
		UPDATE_DEPT("16", "修改了门店信息","2"),
		OPEN_PLOT_SWITCH("17", "开启了策略参数","4"),
		CLOSE_PLOT_SWITCH("18", "关闭了策略参数","4"),
		CHANGE_PARAMETER("19", "修改了系统参数","4"),
		RESET_PARAMETER("20", "将系统参数恢复了默认设置","4"),
		SYSTEM_RUN_MODEL("21", "将运行模式由有限私盘修改为全公盘制","4"),
		DEAL_COMPLETE_PARAM("22", "权证流程参数配置","4"),
		UPDATE_ROLE_OPERS("23", "修改了该角色权限","1"),
		OPERS_INSERT("24", "增加了该角色权限","1"),
		DELETE_EMPLOYEE_FILE("25", "删除员工附件","2"),
		REGSECTION_SWITCH("26", "基本信息和核心信息查看范围","4"),
		UPDATE_EMPLOYEE_DOC("27", "修改员工档案","2"),
		UPDATE_SALARY_TYPE("28", "修改薪资考核方案设置","4"),
		BUILDING_LOCK("29", "锁定了该楼盘","5"),
		BUILDING_UNLOCK("30", "取消锁定了该楼盘","5"),
		TRANS_SALE_DATA("31", "数据出售移交","6"),
		TRANS_LEASE_DATA("32", "数据出租移交","6"),
		TRANS_BUY_DATA("33", "数据求购移交","6"),
		TRANS_RENT_DATA("34", "数据求租移交","6"),
		UPDATE_GR_DATA("35", "修改分组信息","2"),
		UPDATE_ROLE_NAME("36", "修改了该角色名字","2"),
		MODIFY_SALE_BUILD("37", "楼盘变更","7"),
		MODIFY_LEASE_BUILD("38", "楼盘变更","7"),
		OPEN_FACE_RECOGNITION_FLAG("39", "开启手机设备需刷脸认证的开关","2"),
		CLOSE_FACE_RECOGNITION_FLAG("40", "关闭手机设备需刷脸认证的开关","2"),
		CREATE_ORGANIZATION("41","创建了部门","2"),
		UPDATE_ORGANIZATION("42","修改了部门","2"),
		DELETE_ORGANIZATION("43","删除了部门","2"),
		CREATE_LEVEL_DEFINITION("44","创建了层级定义","2"),
		UPDATE_LEVEL_DEFINITION("45","修改了层级定义","2"),
		DELETE_LEVEL_DEFINITION("46","删除了层级定义","2");
		
		
		private String name;
		private String modular;
		private String index;

		SSL_TYPE(String index,String name,String modular){
			this.setIndex(index);
			this.setName(name);
			this.setModular(modular);
		}
		
		@Override
		public String toString() {
			return getIndex();
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getModular() {
			return modular;
		}
		public void setModular(String modular) {
			this.modular = modular;
		}

		public String getIndex() {
			return index;
		}

		public void setIndex(String index) {
			this.index = index;
		}
    }
}

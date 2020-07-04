package com.myfun.service.business.erpdb.eum;

public enum SSL_TYPE{
	OPERS_SETTING("修改了该用户权限","1"),
	UPDATE_USER("修改了该用户信息","2"),
	RESET_PWD("重置了该用户密码","2"),
	CREATE_USER("创建了该用户账号","2"),
	DELETE_USER("注销了该用户账号","2"),
	DISABLE_USER("冻结了该用户账号","2"),
	ENABLE_USER("启用了该用户账号","2"),
	MOVE_USER("将该员工从A店调动至B店","3"),
	CREATE_AREA("创建了大区","2"),
	DELETE_AREA("删除了大区","2"),
	CREATE_REGION("创建了片区","2"),
	DELETE_REGION("删除了片区","2"),
	UPDATE_AREA("修改了大区信息","2"),
	UPDATE_REGION("修改了片区信息","2"),
	UPDATE_DEPT("修改了门店信息","2"),
	OPEN_PLOT_SWITCH("开启了策略参数","4"),
	CLOSE_PLOT_SWITCH("关闭了策略参数","4"),
	CHANGE_PARAMETER("修改了系统参数","4"),
	RESET_PARAMETER("将系统参数恢复了默认设置","4"),
	SYSTEM_RUN_MODEL("将运行模式由有限私盘修改为全公盘制","4"),
	DEAL_COMPLETE_PARAM("权证流程参数配置","4");
	
	private String name;
	private String modular;
	SSL_TYPE(String name,String modular){
		this.setName(name);
		this.setModular(modular);
	}
	@Override
	public String toString() {
		return String.valueOf(this.ordinal()+1);
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
}

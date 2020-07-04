package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

public class ErpSystemSettingLogs extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "日志ID")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "权限类型：1=修改了该用户权限 2=删除了该角色权限 3=修改了该用户信息 4=重置了该用户密码 5=创建了该用户账号 6=注销了该用户账号 7=冻结了该用户账号 8=启用了该用户账号 9=将该员工从A店调动至B店 10=创建了大区 11=删除了大区 12=创建了片区 13=删除了片区 14=修改了大区信息 15=修改了片区信息 16=修改了门店信息 17=开启了策略参数 18=关闭了策略参数 19=修改了系统参数 20=将系统参数恢复了默认设置 21=将运行模式由有限私盘修改为全公盘制 22=权证流程参数配置 23=修改了该角色权限 24=增加了该角色权限25=删除附件27=修改员工档案28=上传附件 29=楼盘锁定 30=楼盘解锁 31=数据出售移交 32=数据出租移交 33=数据求购移交 34=数据求租移交 35=修改分组信息 36=修改了该角色名字 37=修改出售楼盘 38=修改出租楼盘 39=开启手机设备需刷脸认证的开关 40=关闭手机设备需刷脸认证的开关,41=修改团队信息,42=查看日志")
	private Byte sslType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "操作人")
	private Integer createUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "影响人--（如果是楼盘操作，此id则等于楼盘id）")
	private Integer influenceUid;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "日志内容")
	private String logContent;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private String createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "属于哪个模块 1：权限配置 2组织机构 3：员工调动 4：系统参数  5：楼盘规则 6：数据移交 7：楼盘修改 8：查看日志")
	private Integer modular;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建人门店ID")
	private Integer createDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "影响人门店ID(组织机构改版后相当于ORGANIZATION_ID)")
	private Integer influenceDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String createUsername;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改之前")
	private String beforeModification;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "修改之后")
	private String afterModification;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 日志ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 日志ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 权限类型：1=修改了该用户权限 2=删除了该角色权限 3=修改了该用户信息 4=重置了该用户密码 5=创建了该用户账号 6=注销了该用户账号 7=冻结了该用户账号 8=启用了该用户账号 9=将该员工从A店调动至B店 10=创建了大区 11=删除了大区 12=创建了片区 13=删除了片区 14=修改了大区信息 15=修改了片区信息 16=修改了门店信息 17=开启了策略参数 18=关闭了策略参数 19=修改了系统参数 20=将系统参数恢复了默认设置 21=将运行模式由有限私盘修改为全公盘制 22=权证流程参数配置 23=修改了该角色权限 24=增加了该角色权限25=删除附件27=修改员工档案28=上传附件 29=楼盘锁定 30=楼盘解锁 31=数据出售移交 32=数据出租移交 33=数据求购移交 34=数据求租移交 35=修改分组信息 36=修改了该角色名字 37=修改出售楼盘 38=修改出租楼盘 39=开启手机设备需刷脸认证的开关 40=关闭手机设备需刷脸认证的开关,41=修改团队信息,42=查看日志
	 */
	public Byte getSslType() {
		return sslType;
	}

	/**
	 * @mbggenerated 权限类型：1=修改了该用户权限 2=删除了该角色权限 3=修改了该用户信息 4=重置了该用户密码 5=创建了该用户账号 6=注销了该用户账号 7=冻结了该用户账号 8=启用了该用户账号 9=将该员工从A店调动至B店 10=创建了大区 11=删除了大区 12=创建了片区 13=删除了片区 14=修改了大区信息 15=修改了片区信息 16=修改了门店信息 17=开启了策略参数 18=关闭了策略参数 19=修改了系统参数 20=将系统参数恢复了默认设置 21=将运行模式由有限私盘修改为全公盘制 22=权证流程参数配置 23=修改了该角色权限 24=增加了该角色权限25=删除附件27=修改员工档案28=上传附件 29=楼盘锁定 30=楼盘解锁 31=数据出售移交 32=数据出租移交 33=数据求购移交 34=数据求租移交 35=修改分组信息 36=修改了该角色名字 37=修改出售楼盘 38=修改出租楼盘 39=开启手机设备需刷脸认证的开关 40=关闭手机设备需刷脸认证的开关,41=修改团队信息,42=查看日志
	 */
	public void setSslType(Byte sslType) {
		this.sslType = sslType;
	}

	/**
	 * @mbggenerated 操作人
	 */
	public Integer getCreateUid() {
		return createUid;
	}

	/**
	 * @mbggenerated 操作人
	 */
	public void setCreateUid(Integer createUid) {
		this.createUid = createUid;
	}

	/**
	 * @mbggenerated 影响人--（如果是楼盘操作，此id则等于楼盘id）
	 */
	public Integer getInfluenceUid() {
		return influenceUid;
	}

	/**
	 * @mbggenerated 影响人--（如果是楼盘操作，此id则等于楼盘id）
	 */
	public void setInfluenceUid(Integer influenceUid) {
		this.influenceUid = influenceUid;
	}

	/**
	 * @mbggenerated 日志内容
	 */
	public String getLogContent() {
		return logContent;
	}

	/**
	 * @mbggenerated 日志内容
	 */
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 属于哪个模块 1：权限配置 2组织机构 3：员工调动 4：系统参数  5：楼盘规则 6：数据移交 7：楼盘修改 8：查看日志
	 */
	public Integer getModular() {
		return modular;
	}

	/**
	 * @mbggenerated 属于哪个模块 1：权限配置 2组织机构 3：员工调动 4：系统参数  5：楼盘规则 6：数据移交 7：楼盘修改 8：查看日志
	 */
	public void setModular(Integer modular) {
		this.modular = modular;
	}

	/**
	 * @mbggenerated 创建人门店ID
	 */
	public Integer getCreateDept() {
		return createDept;
	}

	/**
	 * @mbggenerated 创建人门店ID
	 */
	public void setCreateDept(Integer createDept) {
		this.createDept = createDept;
	}

	/**
	 * @mbggenerated 影响人门店ID(组织机构改版后相当于ORGANIZATION_ID)
	 */
	public Integer getInfluenceDept() {
		return influenceDept;
	}

	/**
	 * @mbggenerated 影响人门店ID(组织机构改版后相当于ORGANIZATION_ID)
	 */
	public void setInfluenceDept(Integer influenceDept) {
		this.influenceDept = influenceDept;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCreateUsername() {
		return createUsername;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	/**
	 * @mbggenerated 修改之前
	 */
	public String getBeforeModification() {
		return beforeModification;
	}

	/**
	 * @mbggenerated 修改之前
	 */
	public void setBeforeModification(String beforeModification) {
		this.beforeModification = beforeModification;
	}

	/**
	 * @mbggenerated 修改之后
	 */
	public String getAfterModification() {
		return afterModification;
	}

	/**
	 * @mbggenerated 修改之后
	 */
	public void setAfterModification(String afterModification) {
		this.afterModification = afterModification;
	}

	/**
	 * @mbggenerated
	 */
	public ErpSystemSettingLogs() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpSystemSettingLogs(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}
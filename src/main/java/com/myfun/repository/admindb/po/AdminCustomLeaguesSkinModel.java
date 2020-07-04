package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminCustomLeaguesSkinModel implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键自增")
	private Integer id;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)")
	private Integer leaguesType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "冠名信息类型（DIC_DEFINITIONS表DIC_TYPE = 'SKIN_TYPE'）appStartUrl5:app苹果5,appStartUrl6:app苹果6,appStartUrlPlus:app苹果Plus,appStartUrlX:app苹果x,ERP_LOGIN_ICON:erp登录背景,ERP_MENU_RIGHT_PIC_URL:erp导航栏背景,ERP_SYSTEM_NAME:erp系统名称 ,desktopShortcutName:桌面快捷方式的名称 ,desktopShortcutIcon:桌面快捷方式的显示图标 ,installationPackageName:安装包名称,installationPackageIcon:安装包图标，updateLogo：升级页面LOGO，installationPackageLogo：安装页面LOGO,  ERP_LOGIN_ICON_200=ERP系统ICON（2倍图，dpi图） ，ERP_MENU_RIGHT_PIC_URL_200=ERP系统LOGO（2倍图，dpi图）  appDownLoadUrl:app应用商店地址")
	private String skinType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片地址,根据类型复用")
	private String skinPicUrl;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户端类型：默认0:erp、1:APP")
	private Integer clientType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "图片地址类型  1=URL 2=文本")
	private Integer skinPicUrlType;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键自增
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 主键自增
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)
	 */
	public Integer getLeaguesType() {
		return leaguesType;
	}

	/**
	 * @mbggenerated 机构类别(机构ID，DIC_DEFINITIONS表DIC_TYPE = 'LEAGUES_TYPE' ) 1=房口袋(玛雅)
	 */
	public void setLeaguesType(Integer leaguesType) {
		this.leaguesType = leaguesType;
	}

	/**
	 * @mbggenerated 冠名信息类型（DIC_DEFINITIONS表DIC_TYPE = 'SKIN_TYPE'）appStartUrl5:app苹果5,appStartUrl6:app苹果6,appStartUrlPlus:app苹果Plus,appStartUrlX:app苹果x,ERP_LOGIN_ICON:erp登录背景,ERP_MENU_RIGHT_PIC_URL:erp导航栏背景,ERP_SYSTEM_NAME:erp系统名称 ,desktopShortcutName:桌面快捷方式的名称 ,desktopShortcutIcon:桌面快捷方式的显示图标 ,installationPackageName:安装包名称,installationPackageIcon:安装包图标，updateLogo：升级页面LOGO，installationPackageLogo：安装页面LOGO,  ERP_LOGIN_ICON_200=ERP系统ICON（2倍图，dpi图） ，ERP_MENU_RIGHT_PIC_URL_200=ERP系统LOGO（2倍图，dpi图）  appDownLoadUrl:app应用商店地址
	 */
	public String getSkinType() {
		return skinType;
	}

	/**
	 * @mbggenerated 冠名信息类型（DIC_DEFINITIONS表DIC_TYPE = 'SKIN_TYPE'）appStartUrl5:app苹果5,appStartUrl6:app苹果6,appStartUrlPlus:app苹果Plus,appStartUrlX:app苹果x,ERP_LOGIN_ICON:erp登录背景,ERP_MENU_RIGHT_PIC_URL:erp导航栏背景,ERP_SYSTEM_NAME:erp系统名称 ,desktopShortcutName:桌面快捷方式的名称 ,desktopShortcutIcon:桌面快捷方式的显示图标 ,installationPackageName:安装包名称,installationPackageIcon:安装包图标，updateLogo：升级页面LOGO，installationPackageLogo：安装页面LOGO,  ERP_LOGIN_ICON_200=ERP系统ICON（2倍图，dpi图） ，ERP_MENU_RIGHT_PIC_URL_200=ERP系统LOGO（2倍图，dpi图）  appDownLoadUrl:app应用商店地址
	 */
	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	/**
	 * @mbggenerated 图片地址,根据类型复用
	 */
	public String getSkinPicUrl() {
		return skinPicUrl;
	}

	/**
	 * @mbggenerated 图片地址,根据类型复用
	 */
	public void setSkinPicUrl(String skinPicUrl) {
		this.skinPicUrl = skinPicUrl;
	}

	/**
	 * @mbggenerated 客户端类型：默认0:erp、1:APP
	 */
	public Integer getClientType() {
		return clientType;
	}

	/**
	 * @mbggenerated 客户端类型：默认0:erp、1:APP
	 */
	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 图片地址类型  1=URL 2=文本
	 */
	public Integer getSkinPicUrlType() {
		return skinPicUrlType;
	}

	/**
	 * @mbggenerated 图片地址类型  1=URL 2=文本
	 */
	public void setSkinPicUrlType(Integer skinPicUrlType) {
		this.skinPicUrlType = skinPicUrlType;
	}
}
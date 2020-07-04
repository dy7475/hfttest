package com.myfun.repository.support.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * 强调 所有操作都必须加上对应的条件值
 * @author 胡飞龙
 */
public class CacheStructure {
	//在key值后不追加CITY_ID
	public final static String NOTAPPENDCITYID="NOTAPPENDCITYID";
	//本地缓存标记  对版本号不做校验  该类数据 无需变更的情况  切忌频繁修改
	public final static String NOTVALIDATE="NOTVALIDATE";
	
	public final static String ROOT_Cache="ROOT";
	// 用户正常登陆的缓存名
	public final static String LOGIN_ARCHIVE_ID="LOGIN_ARCHIVE_ID_";
	// erp对应的缓存头
	public final static String ARCHIVE_ID_ERP = "ARCHIVE_ID_ERP_";
	// app对应的缓存头
	public final static String ARCHIVE_ID_APP = "ARCHIVE_ID_APP_";
	// archiveId对应的会话数据key
	public final static String ARCHIVE_ID_OPERATOR = "ARCHIVE_ID_OPERATOR_";
	// 网页监控使用的缓存名
	public final static String DEBUG_LOCK_ARCHIVE_ID="DEBUG_LOCK_ARCHIVE_ID_";
	// 精英版和第三方登陆时，密码输入错误超过6次后锁定600秒的key
	public final static String LOCK_ARCHIVE_ID="LOCK_ARCHIVE_ID_";
	
	// 管理页面验证
	public final static String MANAGE_USER_ID="MANAGE_USER_ID_";
	
	/**请求新版接口的缓存名**/
	public final static String switchClassCache = "switchClassCache";
	public final static String switchClassCache_key = "switchClassCache_";
	
	public final static String hfterpdb_sysParaCache="hfterpdb_sysParaCache";
	public final static String hfterpdb_sysParaCache_map_by_CompId="hfterpdb_sysParaCache_map_by_CompId_";

	public static final String hfterpdb_funAreaCache = "hfterpdb_funAreaCache";
	public static final String hfterpdb_funAreaCache_by_COMP_ID="hfterpdb_funAreaCache_by_COMP_ID_";//存放AREA_ID 集合  by CompId

	public static final String hfterpdb_funRegionCache = "hfterpdb_funRegionCache";
	public static final String hfterpdb_funRegionCache_by_COMP_ID = "hfterpdb_funRegionCache_by_COMP_ID_";

	public final static String hfterpdb_funDeptsCache = "hfterpdb_funDeptsCache";
	public final static String hfterpdb_funDeptsCache_by_COMP_ID = "hfterpdb_funDeptsCache_by_COMP_ID_";

	public static final String hfterpdb_funDeptsgroupCache = "hfterpdb_funDeptsgroupCache";
	public final static String hfterpdb_funDeptsgroupCache_by_COMP_ID = "hfterpdb_funDeptsgroupCache_by_COMP_ID_";

	
	public static final String hfterpdb_funUsersCache = "hfterpdb_funUsersCache";
	
	public static final String hfterpdb_funUsersBaseInfoCache = "hfterpdb_funUsersBaseInfoCache";
	public static final String hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID = "hfterpdb_funUsersBaseInfoCache_map_by_COMP_ID_";
	public static final String hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID = "hfterpdb_funUsersBaseInfoCache_notwriteoff_map_by_COMP_ID_";

	public static final String hfterpdb_userOpersCache = "hfterpdb_userOpersCache";
	public static final String hfterpdb_userOpersCache_map_by_USER_ID = "hfterpdb_userOpersCache_map_by_USER_ID_";
	
	public static final String hfterpdb_funSecitonCache = "hfterpdb_funSecitonCache";
	public static final String hfterpdb_funSecitonCache_map_by_CITY_ID = "hfterpdb_funSecitonCache_map_by_CITY_ID_"+NOTAPPENDCITYID;
	
	public static final String hfterpdb_roleOpersCache = "hfterpdb_roleOpersCache";
	public static final String hfterpdb_roleOpersCache_compRoleOpers_by_Role_ID = "hfterpdb_roleOpersCache_compRoleOpers_by_";
	public static final String hfterpdb_ep_advance_roleOpers_by_ROLE_ID =  "hfterpdb_roleOpersCache_ep_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	public static final String hfterpdb_pro_advance_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_pro_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	public static final String hfterpdb_smp_advance_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_smp_advance_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	public static final String hfterpdb_ep_common_roleOpers_by_ROLE_ID =  "hfterpdb_roleOpersCache_ep_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	public static final String hfterpdb_pro_common_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_pro_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	public static final String hfterpdb_smp_common_roleOpers_by_ROLE_ID = "hfterpdb_roleOpersCache_smp_common_by_ROLE_ID_"+NOTAPPENDCITYID+NOTVALIDATE;
	
	//业务缓存  仅仅服务器缓存  本地缓存被屏蔽  无需版本号验证
	public static final String BS_hfterpdb_funViewLogCache = "BS_hfterpdb_funViewLogCache";
	public static final String BS_hfterpdb_funViewLogCache_By_USER_ID = "BS_hfterpdb_funViewLogCache_By_USER_ID_";
	
	public static final String BS_OpenApi_ROOT_Cache = "BS_OpenApi_ROOT_Cache";
	public static final String BS_OpenApi_ROOT_Cache_autoLogin = "BS_OpenApi_ROOT_Cache_autoLogin_";
	
	//跑分系统相关功能的缓存  陈文超负责
	public static final String BS_hftadminRptdb_Cache = "BS_hftadminRptdb_Cache";
	//RPT自定义缓存数据KEY 全城或者门店的最高分统计数据缓存    跑分
	public static final String BS_hftadminRptdb_Cache_RANGE_MAX_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_RANGE_MAX_CACHE_KEY";
	//RPT自定义缓存数据KEY 全城或者门店的平均分分统计数据缓存	 跑分
	public static final String BS_hftadminRptdb_Cache_RANGE_AVG_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_RANGE_AVG_CACHE_KEY";
	//首页前五名的跑分用户数据缓存
	public static final String BS_hftadminRptdb_Cache_TOP5_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_TOP5_SCORE_CACHE_KEY";
	//跑分功能首页的几个指标的排名情况
	public static final String BS_hftadminRptdb_Cache_EACH_SCORE_CACHE_KEY = "BS_hftadminRptdb_Cache_EACH_SCORE_CACHE_KEY";
	
	public static final String hfterpdb_funRolesCache="hfterpdb_funRolesCache";
	public static final String hfterpdb_funRolesCache_map = "hfterpdb_funRolesCache_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_funRolesCache_Lower_Roles_Map = "hfterpdb_funRolesCache_Lower_Roles_Map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_funRolesCache_Mix_Lower_Roles_Map = "hfterpdb_funRolesCache_Mix_Lower_Roles_Map_"+NOTAPPENDCITYID;
	
	// admin库公用缓存名
	public static final String hftadmindb_commonCache = "hftadmindb_commonCache";
	// admin库字典缓存
	public static final String hftadmindb_commonCache_dicDefinitions_map_by_Type = "hftadmindb_commonCache_dicDefinitions_map_by_Type_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_funCityCache_map = "hftadmindb_commonCache_funCityCache_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_funProvince_map = "hftadmindb_commonCache_funProvince_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_sysPara_map = "hftadmindb_commonCache_sysPara_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_kjlCityRela_map = "hftadmindb_commonCache_kjlCityRela_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_funTags_map = "hftadmindb_commonCache_funTags_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_DatasourceConfig_map = "hftadmindb_commonCache_DatasourceConfig_map_"+NOTAPPENDCITYID;
	public static final String hftadmindb_commonCache_discountConfig_map = "hftadmindb_commonCache_discountConfig_map_"+NOTAPPENDCITYID;
	// 跑分缓存
	public static final String hftadmindb_commonCache_RptImStandard_map = "hftadmindb_commonCache_RptImStandard_map_"+NOTAPPENDCITYID;
	
	// erp库公用缓存名
	public static final String hfterpdb_commonCache = "hfterpdb_commonCache";
	// 所有erp库fun_city都一样，只需缓存一份即可，不用加城市ID
	public static final String hfterpdb_commonCache_funCity_map_by_Type = "hfterpdb_commonCache_funCity_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_commonCache_funProvince_map = "hfterpdb_commonCache_funProvince_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_commonCache_funOpers_map = "hfterpdb_commonCache_funOpers_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_commonCache_advOpers_map = "hfterpdb_commonCache_advOpers_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_commonCache_dicDefinition_map_map = "hfterpdb_commonCache_dicDefinition_map_map_"+NOTAPPENDCITYID;
	public static final String hfterpdb_commonCache_dicDefinition_map_list = "hfterpdb_commonCache_dicDefinition_map_list_"+NOTAPPENDCITYID;
	// 行政区缓存
	public static final String hfterpdb_funRegCache = "hfterpdb_funRegCache";
	public static final String hfterpdb_funRegCache_map = "hfterpdb_funRegCache_map_";
	// 模板表头
	public static final String hfterpdb_commonCache_funHead_map = "hfterpdb_commonCache_funHead_map_"+NOTAPPENDCITYID;
	// 统计分析--房源统计缓存名
	public static final String hfterpdb_house_statisticsCache = "hfterpdb_house_statisticsCache";
	public static final String hfterpdb_house_statisticsCache_Data = "hfterpdb_house_statisticsCache_Data_";
	public static final String hfterpdb_house_statisticsCache_bottom = "hfterpdb_house_statisticsCache_bottom_";
	// 统计分析--客源统计缓存名
	public static final String hfterpdb_cust_statisticsCache = "hfterpdb_cust_statisticsCache";
	public static final String hfterpdb_cust_statisticsCache_Data = "hfterpdb_cust_statisticsCache_Data_";
	public static final String hfterpdb_cust_statisticsCache_bottom = "hfterpdb_cust_statisticsCache_bottom_";
	// 房客源分析--统计缓存名
	public static final String hfterpdb_houseCust_flowAnalysisCache = "hfterpdb_houseCust_flowAnalysisCache";
	public static final String hfterpdb_houseCust_flowAnalysisCache_Data = "hfterpdb_houseCust_flowAnalysisCache_Data_";
	// 统计分析--人均效能表
	
	public static final String hfterpdb_perCapitaEffectivenessCountChart = "hfterpdb_perCapitaEffectivenessCountChart";
	public static final String hfterpdb_perCapitaEffectivenessCountChart_Data = "hfterpdb_perCapitaEffectivenessCountChart_Data_";
	public static final String hfterpdb_perCapitaEffectivenessCountRank = "hfterpdb_perCapitaEffectivenessCountRank";
	public static final String hfterpdb_perCapitaEffectivenessCountRank_Data = "hfterpdb_perCapitaEffectivenessCountRank_Data_";
	public static final String hfterpdb_perCapitaEffectivenessCountReport = "hfterpdb_perCapitaEffectivenessCountReport";
	public static final String hfterpdb_perCapitaEffectivenessCountReport_Data = "hfterpdb_perCapitaEffectivenessCountReport_Data_";
	
	//统计分析--新增房客源统计
	public static final String hfterpdb_HouseAddCount = "hfterpdb_HouseAddCount";
	public static final String hfterpdb_HouseAddCount_Data = "hfterpdb_HouseAddCount_Data_";
	public static final String hfterpdb_CustAddCount = "hfterpdb_CustAddCount";
	public static final String hfterpdb_CustAddCount_Data = "hfterpdb_CustAddCount_Data_";
/*	public static final String hfterpdb_PerCapitaEffectivenessCountChart = "hfterpdb_house_statisticsCache";
	public static final String hfterpdb_house_statisticsCache_Data = "hfterpdb_house_statisticsCache_Data_";
	public static final String hfterpdb_house_statisticsCache_bottom = "hfterpdb_house_statisticsCache_bottom_";
*/
	// 缓存网页调试数据
	public static final String debug_ActionPack_Cache = "debug_ActionPack_Cache";
	// 缓存网页调试数据，通过archiveId
	public static final String debug_ActionPack_Cache_map_BY_archiveId = "debug_ActionPack_Cache_map_BY_archiveId_"+NOTAPPENDCITYID;
	
	public final static List<String> NOTVALIDATE_TYPE=new ArrayList<String>();
	static{
		NOTVALIDATE_TYPE.add(hfterpdb_roleOpersCache);
		NOTVALIDATE_TYPE.add(hfterpdb_funSecitonCache);
	}
	
	//内存缓存
//	public static final String hftadmindb_funCityCache="hftadmindb_funCityCache";
//	public static final String hftadmindb_funProvinceCache="hftadmindb_funProvinceCache";
//	public static final String hftadmindb_sysParaCache="hftadmindb_sysParaCache";
//	public static final String hftadmindb_kjlCityRelaCache="hftadmindb_kjlCityRelaCache";
//	public static final String hftadmindb_funTagsCache="hftadmindb_funTagsCache";
	
//	public static final String hftadminRptdb_imStandardCache = "hftadminRptdb_imStandardCache";
//	public static final String hfterpdb_funCityCache="hfterpdb_funCityCache";
//	public static final String hfterpdb_funProvinceCache="hfterpdb_funProvinceCache";
//	public static final String hfterpdb_funRegCache="hfterpdb_funRegCache";
//	public static final String hfterpdb_dicDefinitionCache="hfterpdb_dicDefinitionCache";
//	public static final String hfterpdb_funHeadCache="hfterpdb_funHeadCache";
//	public static final String hftadmindb_discountConfigCache="hfterpdb_discountConfigCache";
//	public static final String hfterpdb_roleOpersMemeryCache="hfterpdb_roleOpersMemeryCache";

	public static final String hfterpdb_funWorkCountTypeCache = "hfterpdb_funWorkCountTypeCache";
	public static final String hfterpdb_funWorkCountTypeCacheByCompId = "hfterpdb_funWorkCountTypeCacheByCompId";

	public static final String hfterpdb_compRoleOpersCache = "hfterpdb_compRoleOpersCache";
	public static final String hfterpdb_compRoleOpersCacheByCompId = "hfterpdb_compRoleOpersCacheByCompId_";

	public static final String hfterpdb_funOpersCache = "hfterpdb_funOpersCache";
	public static final String hfterpdb_funOpersCacheByCityId = "hfterpdb_funOpersCacheByCityId_";
	
}



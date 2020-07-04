package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.param.CaseFavoriteParam;
import com.myfun.repository.erpdb.po.ErpFunCaseFavorite;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunCaseFavoriteMapper extends BaseMapper<ErpFunCaseFavorite, ErpFunCaseFavorite> {
	/**
	 * 已收藏房客源的数量
	 * 
	 * @author 臧铁
	 * @param param
	 *            compId 公司ID caseType 房客源类型 favoriteUid 收藏人
	 * @since 2017年5月9日
	 * @return
	 */
	int count(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);

	/**
	 * 获取一个收藏房客源对象
	 * 
	 * @author 臧铁
	 * @param param
	 *            caseId 房客源ID caseType 房客源类型 favoriteUid 收藏人
	 * @since 2017年5月9日
	 * @return
	 */
	ErpFunCaseFavorite getByFavoriteUid(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);
	
	/**
	 * 获取收藏用户列表
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param caseId
	 * @return
	 */
	List<Integer> getFavoriteList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("caseType")Integer caseType, @Param("caseId")Integer caseId);
	
	ErpFunCaseFavorite getFunCaseFavorite(@Param("shardCityId") Integer cityId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType,@Param("userId") Integer userId);

	/**
	 * @tag 统计出售房源收藏，不包含已注销情况
	 * @author 邓永洪
	 * @since 2018/5/8
	 */
	Integer countSaleFavorite(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);

	/**
	 * @tag 统计出租房源收藏，不包含已注销情况
	 * @author 邓永洪
	 * @since 2018/5/8
	 */
	Integer countLeaseFavorite(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);

	/**
	 * @tag 统计求购客源源收藏，不包含已注销情况
	 * @author 邓永洪
	 * @since 2018/5/8
	 */
	Integer countBuyFavorite(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);

	/**
	 * @tag 统计求租客源源收藏，不包含已注销情况
	 * @author 邓永洪
	 * @since 2018/5/8
	 */
	Integer countRentFavorite(@Param("shardCityId") Integer cityId, @Param("param") CaseFavoriteParam param);
	
	/**
	 * 查询自己的收藏
	 * @param cityId
	 * @param selfCompId
	 * @param selfUserId
	 * @param caseType
	 * @param caseIds
	 * @return
	 */
	List<ErpFunCaseFavorite> getFavoriteListByCaseIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer selfCompId, @Param("userId")Integer selfUserId, @Param("caseType")Integer caseType, @Param("caseIds")List<Integer> caseIds);

	/**
	 * 查询本人收藏所有房源数量
	 * @param compId
	 * @param cityId
	 * @param currentUserId
	 * @param caseType
	 * @return
	 */
	int countByUserId(@Param("compId") Integer compId,@Param("shardCityId") Integer cityId,@Param("currentUserId") Integer currentUserId,@Param("caseType") Integer caseType);


}
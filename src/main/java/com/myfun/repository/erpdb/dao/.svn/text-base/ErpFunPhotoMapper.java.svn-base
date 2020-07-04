package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.house.param.GetHousePhotoParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;

import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhotoExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunPhotoMapper extends BaseMapper<ErpFunPhoto, ErpFunPhoto> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunPhotoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunPhoto> selectByExample(ErpFunPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunPhoto record, @Param("example") ErpFunPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunPhoto record, @Param("example") ErpFunPhotoExample example);

	/**
	 * 根据条件查询出有效的图片，具体条件查看mapper文件
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:09:43
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunPhoto> getValidErpFunPhotoByCondition(ErpFunPhoto erpFunPhoto) throws Exception;
	
	List<ErpFunPhotoDto> getPhotoList(@Param("compId")Integer compId,@Param("shardCityId") Integer cityId,@Param("caseType") Integer caseType,@Param("housingIds") Object[] housingIds);
	
	List<ErpFunPhoto> getPhotoListOrderByPhotoIdDesc(@Param("shardDbName") String shardDbName, @Param("photoId")Integer photoId);

	/**
	 * 获取房源图片列表
	 * @author 臧铁
	 * @param map  caseId 房客源ID  caseType 房客源类型
	 * @since 2017年5月17日
	 * @return
	 */
	List<ErpFunPhotoDto> getHousePhoto(@Param("shardCityId")Integer cityId, @Param("param") GetHousePhotoParam map);

	List<ErpFunPhoto> getHousePhotoByCaseId(@Param("shardCityId") Integer cityId, @Param("param") Map<String, Object> map);

	Map<String, Object> getPhotoTypeCount(@Param("shardCityId")Integer shardCityId ,@Param("compId")Integer compId, @Param("caseType")Byte caseType,  @Param("caseId")Integer caseId,
			 @Param("otherSaleLeaseCaseType")Integer otherSaleLeaseCaseType,  @Param("otherSaleLeaseId")Integer otherSaleLeaseId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@UpdateProvider(method = "updateHousePhotoSeq", type = ErpFunPhotoSqlProvider.class)
	void updateHousePhotoSeq(@Param("shardCityId")Integer shardCityId,@Param("topPhotoId")Integer topPhotoId, @Param("needUpdateIdList")List<Integer> needUpdateIdList);
	
	/**
	 * 获取图片数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/7
	 * @return
	 *
	 */
	ErpFunPhoto getFunPhoto(@Param("shardCityId")Integer cityId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);

	void updateFangKanPhoto(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("timeNow") String timeNow,@Param("photoIds") String[] photoIds);

	class ErpFunPhotoSqlProvider {
		public String updateHousePhotoSeq(Map<String, Object> pMap) {
			List<Integer> needUpdateIdList = (List<Integer>) pMap.get("needUpdateIdList");
			Integer topPhotoId = (Integer) pMap.get("topPhotoId");
			StringBuilder sqlBuilder = new StringBuilder();
			for (int i = 0; i < needUpdateIdList.size(); i++) {
				// 把第一张设置为首图
				if (topPhotoId != null) {
					if (topPhotoId.equals(needUpdateIdList.get(i).toString())) {
						sqlBuilder.append(" update FUN_PHOTO set IS_TOP = 1,PHOTO_SEQ = " + (i + 1)
								+ " where PHOTO_ID = " + needUpdateIdList.get(i));
					} else {
						sqlBuilder.append(" update FUN_PHOTO set IS_TOP = 0,PHOTO_SEQ = " + (i + 1)
								+ " where PHOTO_ID = " + needUpdateIdList.get(i));
					}
				}
			}
			return sqlBuilder.toString();
		}
	}
	
	/**
	 * 获取已有图片张数
	 * @author 朱科
	 * @since 2018年1月22日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param caseId
	 * @param saleLeaseId
	 * @return
	 */
	Integer getCountByType(@Param("shardCityId")Integer cityId ,@Param("compId")Integer compId,
			@Param("caseType")Integer caseType, @Param("caseId")Integer caseId, @Param("transmitFlag")Integer transmitFlag, @Param("photoReviewFlag")Integer[] photoReviewFlag);
	
	
	List<Map<Integer, String>> getOneRandomBuildPic(@Param("shardCityId")Integer cityId, @Param("buildIds")Set<Integer> buildIds, @Param("isFirst")Integer isFirst);

}
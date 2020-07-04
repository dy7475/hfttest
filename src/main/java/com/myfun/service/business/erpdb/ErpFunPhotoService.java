package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPhotoService extends BaseMapper<ErpFunPhoto, ErpFunPhoto> {
	
	/**
	 * 根据图片的ID查询一张有效的图片
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:19:35
	 */
	ErpFunPhoto getValidPhotoByPhotoId(Integer photoId,Integer cityId) throws Exception;
	
	/**
	 * 查询一张有效首图
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:21:48
	 */
	ErpFunPhoto getValidPhotoByIsTop(Integer caseId , Byte caseType , Integer cityId) throws Exception;
	
	/**
	 * 根据图片信息CASE_ID查询一批图片
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:19:51
	 */
	List<ErpFunPhoto> getValidPhotosByCondition(Integer caseId , Byte caseType , Integer cityId) throws Exception;
	
	/**
	 * 查询图片类型：室内图、户型图
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:19:51
	 */
	List<ErpFunPhoto> getValidPhotosByPhotoType(Integer caseId , Byte caseType , Byte photoType , Integer cityId) throws Exception;
	
	List<ErpFunPhotoDto> getPhotoList(Integer compId, Integer cityId, Integer caseType, Object[] housingIds);

	List<ErpFunPhoto> getPhotoListOrderByPhotoIdDesc(String shardDbName);
}

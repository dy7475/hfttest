package com.myfun.repository.searchdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.searchdb.po.SearchPhotoZj;
import com.myfun.repository.searchdb.po.SearchPhotoZjKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface SearchPhotoZjMapper extends BaseMapper<SearchPhotoZj, SearchPhotoZjKey> {

	List<SearchPhotoZj> getPhotoList(@Param("cityId")Integer cityId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);

	List<SearchPhotoZj> getNeedValidatePhotoList(@Param("pageSize")int pageSize, @Param("cityId") String cityId);

	void updateIsValid(@Param("isValid")String isValid, @Param("searchPhotoZj")SearchPhotoZj searchPhotoZj);

	SearchPhotoZj getPhotoOne(@Param("cityId") Integer cityId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);

	List<SearchPhotoZj> getPhotoZjList(@Param("cityId")Integer cityId,@Param("caseType") Integer caseType, @Param("caseIds") List<Integer> caseIds);
}
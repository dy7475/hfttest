package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.managecenter.axn.param.BatchUnBindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.BindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.ImportNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.ReleaseNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberParam;
import com.myfun.repository.erpdb.po.ErpAliyunPhone;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpAliyunPhoneService extends BaseMapper<ErpAliyunPhone, ErpAliyunPhone>{
	
	/**
	 * 导入号码
	 * @param param
	 */
	int importNumber(ImportNumberParam param);
	
	/***
	 * 解绑号码
	 * @param param
	 */
	void unBindNumber(UnBindNumberParam param);
	
	/***
	 * 释放号码
	 */
	void releaseNumber(ReleaseNumberParam param);
	
	/**
	 * 绑定号码
	 * @param param
	 */
	void bindNumber(BindNumberParam param);
	
	/**
	 * 批量绑定
	 */
	String batchBindNumber(Integer cityId, Integer compId, Integer operateUserId, List<Integer> userIdList);
	
	/**
	 * 批量解绑
	 * @param param
	 */
	void batchUnBindNumber(BatchUnBindNumberParam param);
	
	/***
	 * 调店修改axn绑定
	 * 
	 */
	void transAxn(Integer cityId, Integer userId);
	
	void deleteUnBindNumber(Integer cityId, Integer userId, Integer operateUserId);
}

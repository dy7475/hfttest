package com.myfun.framework.config.mybatis;

import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;

import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.SqlServerMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;

/**
 * 
* @ClassName: BaseMapper 
* @Description: 基础公共Mapper
* @author fsjohnhuang
* @date 2020年6月10日 上午10:48:27 
* 
* @param <T>
 */
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface CommonMapper<T> extends SqlServerMapper<T>, BaseSelectMapper<T>, BaseUpdateMapper<T>,
		BaseDeleteMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>, Marker {

}

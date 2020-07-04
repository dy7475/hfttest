package com.myfun.framework.config.mybatis.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.mybatis.CommonQueryExample;
import com.myfun.framework.web.json.ResponseJson;


/**
 * 
* @ClassName: BaseFacadeService 
* @Description: 基础公共接口
* @author tangliang1
* @date 2020年6月24日 下午2:24:18 
* 
* @param <T>
 */
public interface BaseFacadeService<T> {

	/**
	 * 
	* @Title: add 
	* @Description: 新增记录
	* @param @param param
	* @param @return    设定文件 
	* @return T    返回类型 
	* @throws
	 */
	T add(T param);
	
	/**
	 * 
	 * @Title: updateById
	 * @Description: 根据主键修改记录
	 * @param @param param
	 * @param @return 设定文件
	 * @return T 返回类型
	 * @throws
	 */
	T updateById(T param);
	
	/**
	 * 
	 * @Title: deleteById
	 * @Description: 根据主键删除记录
	 * @param @param id
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
	int deleteById(Object id);

	
	/**
	 * 
	* @Title: queryById 
	* @Description: 根据主键获取单挑记录
	* @param @param id
	* @param @return    设定文件 
	* @return T    返回类型 
	* @throws
	 */
	T queryById(Object id);
	
	
	/**
	 * 
	 * @Title: queryByCondition
	 * @Description: 条件获取记录
	 * @param @param param
	 * @param @return 设定文件
	 * @return List<T> 返回类型
	 * @throws
	 */
	List<T> queryByCondition(T param);
	
	
	/**
	 * 
	* @Title: queryCountBycondition 
	* @Description: 条件获取记录数
	* @param @param param
	* @param @return    设定文件 
	* @return int    返回类型 
	* @throws
	 */
	int queryCountBycondition(T param);
	
	/**
	 * 
	 * @Title: queryOneByCondition
	 * @Description: 条件获取单条记录
	 * @param @param param
	 * @param @return 设定文件
	 * @return T 返回类型
	 * @throws
	 */
	T queryOneByCondition(T param);
	
	/**
	 * 
	 * @Title: query4Page
	 * @Description: 条件查询分页列表
	 * @param @param param 查询参数实体
	 * @param @param pageInfo 分页信息实体
	 * @param @return 设定文件
	 * @return JsonPageResponse<T> 返回类型
	 * @throws
	 */
	ResponseJson query4Page(T param,PageInfo<T> pageInfo);
	
	
	/**
	 * 
	 * @Title: queryCountByCriteria
	 * @Description: 根据条件查询总数
	 * @param @param example
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
    int queryCountByCriteria(CommonQueryExample example);

	/**
	 * 
	 * @Title: deleteByCriteria
	 * @Description: 删除指定列表
	 * @param @param example
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
    int deleteByCriteria(CommonQueryExample example);

	/**
	 * 
	 * @Title: queryByCriteria
	 * @Description: 根据指定条件获取列表
	 * @param @param example
	 * @param @return 设定文件
	 * @return List<T> 返回类型
	 * @throws
	 */
    List<T> queryByCriteria(CommonQueryExample example);

	/**
	 * 
	 * @Title: updateByCriteria
	 * @Description:根据指定条件修改记录
	 * @param @param record
	 * @param @param criteria
	 * @param @return 设定文件
	 * @return int 返回类型
	 * @throws
	 */
    int updateByCriteria(T record,CommonQueryExample example);
}

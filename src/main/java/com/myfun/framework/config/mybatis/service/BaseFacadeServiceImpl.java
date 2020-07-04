package com.myfun.framework.config.mybatis.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.mybatis.CommonMapper;
import com.myfun.framework.config.mybatis.CommonQueryExample;
import com.myfun.framework.web.json.ResponseJson;


/**
 * 
* @ClassName: BaseFacadeServiceImpl 
* @Description: 公共基础服务实现
* @author tangliang1
* @date 2020年6月24日 下午2:24:08 
* 
* @param <T>
 */
@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
public abstract class BaseFacadeServiceImpl<T> implements BaseFacadeService<T> {

	/**
	 * 公共mybatis操作
	 */
    @Autowired
    protected CommonMapper<T> mapper;
    
	@Override
	public T add(T param) {
		mapper.insertSelective(param);
		return param;
	}

	@Override
	public T updateById(T param) {
		mapper.updateByPrimaryKeySelective(param);
		return param;
	}
	
	@Override
	public T queryById(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int deleteById(Object id) {
		return mapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public List<T> queryByCondition(T param) {
		return mapper.select(param);
	}
	
	@Override
	public int queryCountBycondition(T param){
		return mapper.selectCount(param);
	}

	@Override
	public T queryOneByCondition(T param) {
		return mapper.selectOne(param);
	}
	
	public ResponseJson query4Page(T param,PageInfo<T> pageInfo){
		
		// 设置分页默认值
		int pageNo = 1, pageSize = 10;
		if (Objects.isNull(pageInfo.getPageNum())) {
			pageNo = pageInfo.getPageNum();
		}
		if (Objects.isNull(pageInfo.getPageNum())) {
			pageSize = pageInfo.getPageSize();
		}
		
		// 执行分页查询
		Page<T> pageData = PageHelper.startPage(pageNo, pageSize);
		List<T> list = mapper.select(param);
		
		JsonPageResponse<T> jpRsp=new JsonPageResponse<T>(list,pageData);
		return jpRsp;
	}

	/**
	 * 按条件获取记录数
	 */
	@Override
	public int queryCountByCriteria(CommonQueryExample example) {
		return mapper.selectCountByExample(example);
	}

	/**
	 * 按条件删除记录
	 */
	@Override
	public int deleteByCriteria(CommonQueryExample example) {
		return mapper.deleteByExample(example);
	}

	/**
	 * 根据条件获取记录列表
	 */
	@Override
	public List<T> queryByCriteria(CommonQueryExample example) {
		return mapper.selectByExample(example);
	}

	/**
	 * 更新符合条件记录
	 */
	@Override
	public int updateByCriteria(T record, CommonQueryExample example) {
		return mapper.updateByExampleSelective(record, example);
	}

}

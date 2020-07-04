package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.dto.AdminPaidCountDto;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月13日 下午2:39:28 
 * 类说明 
*/
public interface AdminPaidCountMapper {

	List<AdminPaidCountDto> getCount(Map<String, Object> param);

}

package com.myfun.service.business.erpdb.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.ErpFunStatisticDetailMapper;
import com.myfun.repository.erpdb.po.ErpFunStatisticDetail;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunStatisticDetailService;
import com.myfun.utils.StringUtil;

@Service
public class ErpFunStatisticDetailServiceImpl extends AbstractService<ErpFunStatisticDetail, Integer>implements ErpFunStatisticDetailService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ErpFunStatisticDetailServiceImpl.class);
	@Autowired private ErpFunStatisticDetailMapper erpFunStatisticDetailMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunStatisticDetailMapper;
	}
	
	/**
	 * 列表排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param resultList 数据集
	 * @param byArrs 以什么排序，可以多个字段排序
	 * @param isAsc true=升序 false=降序
	 */
	public static void collectionsSort(List<Map<String,Object>> resultList, final String[] byArrs, final boolean isAsc){
		Collections.sort(resultList, new Comparator<Map<String,Object>>() {
			@Override
			public int compare(Map<String,Object> o1, Map<String,Object> o2) {
				Integer[] ids = getArrLastIds(o1, o2, byArrs, new Integer[]{0, 0}, 0);
				if(isAsc){
					return ids[0] - ids[1];
				}
				return ids[1] - ids[0];
			}
		});
	}
	
	/**
	 * 递归获取o1 o2 的byArrs指定的ID，用于排序
	 * @author 张宏利
	 * @since 2016年5月13日
	 * @param o1 对象1
	 * @param o2 对象2
	 * @param byArrs 需要排序的项
	 * @param ids 返回的结果数组
	 * @param index 当前索引
	 * @return
	 */
	private static Integer[] getArrLastIds(Map<String,Object> o1, Map<String,Object> o2, String[] byArrs, Integer[] ids, int index){
		if(byArrs.length <= index){return ids;}
		Object val1 = o1.get(byArrs[index]);
		Object val2 = o2.get(byArrs[index]);
		if(val1==null){
			ids[0] = StringUtil.paseInteger("", 0);
		}else{
			ids[0] = StringUtil.paseInteger(val1.toString(), 0);
		}
		if(val2==null){
			ids[1] = StringUtil.paseInteger("", 0);
		}else{
			ids[1] = StringUtil.paseInteger(val2.toString(), 0);
		}
		
		if(ids[0].equals(ids[1])){
			return getArrLastIds(o1, o2, byArrs, ids, index+1);
		}
		return ids;
	}
	
	/**
	 * 获取真实维度和维度ID
	 * @author 张宏利
	 * @since 2017年2月25日
	 * @param operRange
	 * @param erpFunUsers
	 * @return
	 */
	public static  String[] getRangeAndId(String operRange, Operator operator) {
		Integer operRangeId = null;
		if("COMP".equals(operRange)) {
			operRange = "COMP_ID";
			operRangeId = operator.getCompId();
		} else if("AREA".equals(operRange)) {
			operRange = "AREA_ID";
			operRangeId = operator.getAreaId();
		} else if("REG".equals(operRange)) {
			operRange = "REG_ID";
			operRangeId = operator.getRegId();
		} else if("DEPT".equals(operRange)) {
			operRange = "DEPT_ID";
			operRangeId = operator.getDeptId();
		} else if("GROUP".equals(operRange)) {
			operRange = "GR_ID";
			operRangeId = operator.getGrId();
		} else if("USER".equals(operRange)) {
			operRange = "USER_ID";
			operRangeId = operator.getUserId();
		} else {
			return null;
		}
		return new String[]{operRange, String.valueOf(operRangeId)};
	}
	public static  String getRange(String serchRange){
		if("COMP".equals(serchRange)){
			return "compId";
		} else if("AREA".equals(serchRange)){
			return "areaId";
		} else if("REG".equals(serchRange)){
			return "regId";
		} else if("DEPT".equals(serchRange)){
			return "deptId";
		} else if("GROUP".equals(serchRange)){
			return "grId";
		} else if("USER".equals(serchRange)){
			return "userId";
		}
		return "compId";
	}
	
	public static  String getRangeCapital(String serchRange){
		if("COMP".equals(serchRange)){
			return "COMP_ID";
		} else if("AREA".equals(serchRange)){
			return "AREA_ID";
		} else if("REG".equals(serchRange)){
			return "REG_ID";
		} else if("DEPT".equals(serchRange)){
			return "DEPT_ID";
		} else if("GROUP".equals(serchRange)){
			return "GR_ID";
		} else if("USER".equals(serchRange)){
			return "USER_ID";
		}
		return "COMP_ID";
	}
}

package com.myfun.repository.support.mybatis.condition;

import java.util.Arrays;

import com.myfun.repository.support.exception.DevelopmentException;



public class ConditionItem{
	private String logic;
	private String column;
	private String add;
	private Object values;
	private Object[] valuesArr;
	
	public final static String AND = "AND";
	public final static String OR = "OR";
	public final static String IN = "IN";
	
	public ConditionItem(String logic,String column,String add,Object values){
		this.logic = logic;
		this.column = column;
		this.add = add;
		this.values = values;
	}
	/**
	 * 仅供update时纯sql使用，例：new ConditionItem("count=count+1");
	 * @param sql
	 */
	public ConditionItem(String sql){
		this.logic = sql;
	}
	public ConditionItem(String column,String add, Object values){
		this(AND, column, add, values);
	}
	public ConditionItem(String logic,String column,String add,Object[] values){
		if(values == null || values.length <= 0){
			throw new DevelopmentException("参数不能为空");
		}
		this.logic = logic;
		this.add = add;
		this.column = column;
		this.valuesArr = values;
	}
	public ConditionItem(String column,String add,Object[] values){
		this(AND, column, add, values);
	}
	
	public static String arrToStr(Object[] values){
		String rt = Arrays.toString(values);
		return rt.substring(1, rt.length() - 1);
	}
	
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public Object getValues() {
		return values;
	}
	public void setValues(Object values) {
		this.values = values;
	}
	public void setLogic(String logic) {
		this.logic = logic;
	}
	public String getLogic() {
		return logic;
	}
	public Object[] getValuesArr() {
		return valuesArr;
	}
	public void setValuesArr(Object[] valuesArr) {
		this.valuesArr = valuesArr;
	}
}


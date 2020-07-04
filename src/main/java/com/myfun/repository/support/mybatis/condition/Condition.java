package com.myfun.repository.support.mybatis.condition;

import java.util.ArrayList;
import java.util.List;

public class Condition{
	private List<ConditionItem> condition;
	
	public Condition(){
		condition = new ArrayList<ConditionItem>();
	}
	
	public List<ConditionItem> getCondition() {
		return condition;
	}
	
	public Condition add(Condition conditions) {
		return this.add(ConditionItem.AND, conditions);
	}
	
	public Condition add(String logic, Condition conditions) {
		if(conditions == null || conditions.size() <= 0){return this;}
		this.add(new ConditionItem(logic, "(","",""));
		int i=0;
		for (ConditionItem conditionItem : conditions.getCondition()) {
			if(i++ == 0){
				conditionItem.setLogic("");
			}
			this.add(conditionItem);
		}
		this.add(new ConditionItem("", ")","",""));
		return this;
	}
	
	public Condition add(ConditionItem item) {
		condition.add(item);
		return this;
	}
	
	public int size() {
		if(condition == null)return 0;
		return condition.size();
	}
}


package com.myfun.erpWeb.managecenter.profit.vo;

public class ProfitBaseInfoDto  {
    private Integer userId;
    private  String userName;
    private float totalMoney;
    private Integer profitCount;//业绩组成

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getProfitCount() {
        return profitCount;
    }

    public void setProfitCount(Integer profitCount) {
        this.profitCount = profitCount;
    }
}

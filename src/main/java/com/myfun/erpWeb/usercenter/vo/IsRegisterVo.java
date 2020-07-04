package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.po.AdminFunArchive;
import io.swagger.annotations.ApiModel;

@ApiModel
public class IsRegisterVo {

    private AdminFunArchive adminFunArchives;

    private Integer userId;

    private Byte flag;

    private String reson;

    private Integer isRegister;

    public AdminFunArchive getAdminFunArchives() {
        return adminFunArchives;
    }

    public void setAdminFunArchives(AdminFunArchive adminFunArchives) {
        this.adminFunArchives = adminFunArchives;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getFlag() {
        return flag;
    }

    public void setFlag(Byte flag) {
        this.flag = flag;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Integer getIsRegister() {
        return isRegister;
    }

    public void setIsRegister(Integer isRegister) {
        this.isRegister = isRegister;
    }
}

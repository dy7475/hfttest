package com.myfun.repository.agencydb.po;

import java.io.Serializable;
import java.util.Date;

public class AgencyWfUserb implements Serializable {
    /**
     *
     * @mbggenerated
    记录ID
     */
    private Integer wfId;

    /**
     *
     * @mbggenerated
    用户昵称
     */
    private String wfNickname;

    /**
     *
     * @mbggenerated
    用户openid
     */
    private String wfOpenid;

    /**
     *
     * @mbggenerated
    用户头像
     */
    private String wfPhoto;

    /**
     *
     * @mbggenerated
    性别
     */
    private Byte wfSex;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date wfCreatetime;

    /**
     *
     * @mbggenerated
    用户电话
     */
    private String wfMobile;

    /**
     *
     * @mbggenerated
    关联经纪人的档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    是否关注 1:关注 0：未关注
     */
    private Byte subscribe;

    /**
     *
     * @mbggenerated
    数据是否有效 1：有效 0 无效
     */
    private Byte wfStatus;

    /**
     *
     * @mbggenerated
     */
    private String openIdBack;

    /**
     *
     * @mbggenerated
    是否是之前滴滴老用户
     */
    private Byte isUu;

    /**
     *
     * @mbggenerated
    绑定账号得到的红包金额 (已废弃)
     */
    private String bonusMoney;

    /**
     *
     * @mbggenerated
    绑定账号得到的红包时间 (已废弃)
     */
    private Date bonusTime;

    /**
     *
     * @mbggenerated
    绑定账号得到的红包流水号 (已废弃)
     */
    private String bonusBillno;

    /**
     *
     * @mbggenerated
    是否得到过绑定红包
     */
    private Byte wfBonus;

    /**
     *
     * @mbggenerated
    新的OPEN_ID
     */
    private String openIdNew;

    /**
     *
     * @mbggenerated
    绑定时间
     */
    private Date bindTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getWfId() {
        return wfId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfId(Integer wfId) {
        this.wfId = wfId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfNickname() {
        return wfNickname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfNickname(String wfNickname) {
        this.wfNickname = wfNickname == null ? null : wfNickname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfOpenid() {
        return wfOpenid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfOpenid(String wfOpenid) {
        this.wfOpenid = wfOpenid == null ? null : wfOpenid.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfPhoto() {
        return wfPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfPhoto(String wfPhoto) {
        this.wfPhoto = wfPhoto == null ? null : wfPhoto.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfSex() {
        return wfSex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfSex(Byte wfSex) {
        this.wfSex = wfSex;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getWfCreatetime() {
        return wfCreatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfCreatetime(Date wfCreatetime) {
        this.wfCreatetime = wfCreatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getWfMobile() {
        return wfMobile;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfMobile(String wfMobile) {
        this.wfMobile = wfMobile == null ? null : wfMobile.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSubscribe() {
        return subscribe;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfStatus() {
        return wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfStatus(Byte wfStatus) {
        this.wfStatus = wfStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOpenIdBack() {
        return openIdBack;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOpenIdBack(String openIdBack) {
        this.openIdBack = openIdBack == null ? null : openIdBack.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsUu() {
        return isUu;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsUu(Byte isUu) {
        this.isUu = isUu;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBonusMoney() {
        return bonusMoney;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBonusMoney(String bonusMoney) {
        this.bonusMoney = bonusMoney == null ? null : bonusMoney.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBonusTime() {
        return bonusTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBonusTime(Date bonusTime) {
        this.bonusTime = bonusTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBonusBillno() {
        return bonusBillno;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBonusBillno(String bonusBillno) {
        this.bonusBillno = bonusBillno == null ? null : bonusBillno.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWfBonus() {
        return wfBonus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWfBonus(Byte wfBonus) {
        this.wfBonus = wfBonus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getOpenIdNew() {
        return openIdNew;
    }

    /**
     *
     * @mbggenerated
     */
    public void setOpenIdNew(String openIdNew) {
        this.openIdNew = openIdNew == null ? null : openIdNew.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getBindTime() {
        return bindTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }
}
package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminWebSite implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer siteId;

    /**
     *
     * @mbggenerated
     */
    private Integer provinceId;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private String siteName;

    /**
     *
     * @mbggenerated
     */
    private Integer fatherId;

    /**
     *
     * @mbggenerated
     */
    private Boolean availableFlag;

    /**
     *
     * @mbggenerated
     */
    private Boolean bSpec;

    /**
     *
     * @mbggenerated
     */
    private Boolean bEdit;

    /**
     *
     * @mbggenerated
     */
    private Boolean bSelfpub;

    /**
     *
     * @mbggenerated
     */
    private Boolean bPhoto;

    /**
     *
     * @mbggenerated
     */
    private Boolean canServerPub;

    /**
     *
     * @mbggenerated
     */
    private String memo;

    /**
     *
     * @mbggenerated
     */
    private String cityCode;

    /**
     *
     * @mbggenerated
     */
    private String cityCode2;

    /**
     *
     * @mbggenerated
     */
    private String siteAddress;

    /**
     *
     * @mbggenerated
     */
    private String regAddress;

    /**
     *
     * @mbggenerated
     */
    private Byte invisible;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private String markPos;

    /**
     *
     * @mbggenerated
     */
    private String siteNote;

    /**
     *
     * @mbggenerated
     */
    private String regNote;

    /**
     *
     * @mbggenerated
     */
    private String sitePubNote;

    /**
     *
     * @mbggenerated
     */
    private Boolean bRichText;

    /**
     *
     * @mbggenerated
     */
    private Boolean bRef;

    /**
     *
     * @mbggenerated
     */
    private Boolean bPay;

    /**
     *
     * @mbggenerated
     */
    private Byte bOrderref;

    /**
     *
     * @mbggenerated
     */
    private Boolean bValid;

    /**
     *
     * @mbggenerated
     */
    private String loginAddress;

    /**
     *
     * @mbggenerated
     */
    private Byte siteUsage;

    /**
     *
     * @mbggenerated
     */
    private Integer siteIdOld;

    /**
     *
     * @mbggenerated
     */
    private Byte canClickCount;

    /**
     *
     * @mbggenerated
     */
    private Boolean showAccInfo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */

    private Byte engineVersion;
    public Integer getSiteId() {
        return siteId;
    }

    public Byte getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(Byte engineVersion) {
        this.engineVersion = engineVersion;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getProvinceId() {
        return provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFatherId() {
        return fatherId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getAvailableFlag() {
        return availableFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAvailableFlag(Boolean availableFlag) {
        this.availableFlag = availableFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbSpec() {
        return bSpec;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbSpec(Boolean bSpec) {
        this.bSpec = bSpec;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbEdit() {
        return bEdit;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbEdit(Boolean bEdit) {
        this.bEdit = bEdit;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbSelfpub() {
        return bSelfpub;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbSelfpub(Boolean bSelfpub) {
        this.bSelfpub = bSelfpub;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbPhoto() {
        return bPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbPhoto(Boolean bPhoto) {
        this.bPhoto = bPhoto;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getCanServerPub() {
        return canServerPub;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCanServerPub(Boolean canServerPub) {
        this.canServerPub = canServerPub;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCityCode2() {
        return cityCode2;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityCode2(String cityCode2) {
        this.cityCode2 = cityCode2 == null ? null : cityCode2.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteAddress() {
        return siteAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress == null ? null : siteAddress.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRegAddress() {
        return regAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress == null ? null : regAddress.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getInvisible() {
        return invisible;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInvisible(Byte invisible) {
        this.invisible = invisible;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getMarkPos() {
        return markPos;
    }

    /**
     *
     * @mbggenerated
     */
    public void setMarkPos(String markPos) {
        this.markPos = markPos == null ? null : markPos.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSiteNote() {
        return siteNote;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteNote(String siteNote) {
        this.siteNote = siteNote == null ? null : siteNote.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRegNote() {
        return regNote;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegNote(String regNote) {
        this.regNote = regNote == null ? null : regNote.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getSitePubNote() {
        return sitePubNote;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSitePubNote(String sitePubNote) {
        this.sitePubNote = sitePubNote == null ? null : sitePubNote.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbRichText() {
        return bRichText;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbRichText(Boolean bRichText) {
        this.bRichText = bRichText;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbRef() {
        return bRef;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbRef(Boolean bRef) {
        this.bRef = bRef;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbPay() {
        return bPay;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbPay(Boolean bPay) {
        this.bPay = bPay;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getbOrderref() {
        return bOrderref;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbOrderref(Byte bOrderref) {
        this.bOrderref = bOrderref;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getbValid() {
        return bValid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setbValid(Boolean bValid) {
        this.bValid = bValid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLoginAddress() {
        return loginAddress;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getSiteUsage() {
        return siteUsage;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteUsage(Byte siteUsage) {
        this.siteUsage = siteUsage;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSiteIdOld() {
        return siteIdOld;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSiteIdOld(Integer siteIdOld) {
        this.siteIdOld = siteIdOld;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCanClickCount() {
        return canClickCount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCanClickCount(Byte canClickCount) {
        this.canClickCount = canClickCount;
    }

    /**
     *
     * @mbggenerated
     */
    public Boolean getShowAccInfo() {
        return showAccInfo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setShowAccInfo(Boolean showAccInfo) {
        this.showAccInfo = showAccInfo;
    }
}
package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminPhotoTmp implements Serializable {
    /**
     *
     * @mbggenerated
    图片地址
     */
    private String photoAddr;

    /**
     *
     * @mbggenerated
    图片类型 crm:0.分销楼盘图;1.分销楼盘户型图;2.搜搜楼盘图;3.搜搜楼盘户型图;4.公司log水印;5.实名审核相关照片;6.微信公众号认证图片;7.公告管理发帖图片;8.商品管理图片;9.充值提现凭证;10.广告分析;11金融图片;12.商品图片;0 当来源是erp是代表委托书 1当来源是erp是代表委托书的附件信息 2带看确认书
     */
    private Integer photoType;

    /**
     *
     * @mbggenerated
    来源  1:crm 2:erp
     */
    private Integer source;

    /**
     *
     * @mbggenerated
    状态 0=临时 1=拷贝成功 2=删除
     */
    private Byte status;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getPhotoAddr() {
        return photoAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoAddr(String photoAddr) {
        this.photoAddr = photoAddr == null ? null : photoAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPhotoType() {
        return photoType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPhotoType(Integer photoType) {
        this.photoType = photoType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSource() {
        return source;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
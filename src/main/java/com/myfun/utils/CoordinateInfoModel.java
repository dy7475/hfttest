package com.myfun.utils;

public class CoordinateInfoModel {

    /**
     * 总页数
     */
    private int PAGE;
    /**
     * // 甲方签字坐标及页数 ownerSignX +','+ownerSignY +','+ownerSignPage
     */
    private String PARTY_A_INFO;

    /**
     * 乙方签字坐标及页数 customerSignX +','+customerSignY +','+customerSignPage
     */
    private String PARTY_B_INFO;

    /**
     * 甲方签字时间坐标 ownerSignTimeX +','+ownerSignTimeY
     */
    private String PARTY_A_DATE;

    /**
     * 乙方签字时间坐标 customerSignTimeX +','+customerSignTimeY
     */
    private String PARTY_B_DATE;

    /**
     * 印章坐标及页数 sealX +','+sealY +','+sealPage
     */
    private String PARTY_C_INFO;

    /**
     * A4高度
     */
    private float A4_HIGHT;

    /**
     * a4宽度
     */
    private float A4_WIDTH;

    public String getPARTY_A_INFO() {
        return PARTY_A_INFO;
    }

    public void setPARTY_A_INFO(String PARTY_A_INFO) {
        this.PARTY_A_INFO = PARTY_A_INFO;
    }

    public String getPARTY_B_INFO() {
        return PARTY_B_INFO;
    }

    public void setPARTY_B_INFO(String PARTY_B_INFO) {
        this.PARTY_B_INFO = PARTY_B_INFO;
    }

    public String getPARTY_A_DATE() {
        return PARTY_A_DATE;
    }

    public void setPARTY_A_DATE(String PARTY_A_DATE) {
        this.PARTY_A_DATE = PARTY_A_DATE;
    }

    public String getPARTY_B_DATE() {
        return PARTY_B_DATE;
    }

    public void setPARTY_B_DATE(String PARTY_B_DATE) {
        this.PARTY_B_DATE = PARTY_B_DATE;
    }

    public String getPARTY_C_INFO() {
        return PARTY_C_INFO;
    }

    public void setPARTY_C_INFO(String PARTY_C_INFO) {
        this.PARTY_C_INFO = PARTY_C_INFO;
    }

    public float getA4_HIGHT() {
        return A4_HIGHT;
    }

    public void setA4_HIGHT(float a4_HIGHT) {
        A4_HIGHT = a4_HIGHT;
    }

    public int getPAGE() {
        return PAGE;
    }

    public void setPAGE(int PAGE) {
        this.PAGE = PAGE;
    }

    public float getA4_WIDTH() {
        return A4_WIDTH;
    }

    public void setA4_WIDTH(float a4_WIDTH) {
        A4_WIDTH = a4_WIDTH;
    }
}

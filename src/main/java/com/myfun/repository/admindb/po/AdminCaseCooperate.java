package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdminCaseCooperate implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键自增ID")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源城市ID")
    private Integer houseCityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源所属人档案ID")
    private Integer houseArchiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源所属人用户ID")
    private Integer houseUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源ID")
    private Integer houseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源城市ID")
    private Integer custCityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源所属人档案ID")
    private Integer custArchiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源所属人用户ID")
    private Integer custUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源ID")
    private Integer custId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合作类型，1=买卖合作 2=租赁合作")
    private Byte cooperateType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "带看时间")
    private Date takeLookTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "扫码地点")
    private String scanCodeAddress;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效  7=确认成交")
    private Byte houseCooperateStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效   7=确认成交")
    private Byte custCooperateStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源详细信息JSON")
    private String houseJson;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源详细信息JSON")
    private String custJson;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "创建时间")
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源公司ID")
    private Integer houseCompId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源大区ID")
    private Integer houseAreaId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源片区ID")
    private Integer houseRegId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源门店ID")
    private Integer houseDeptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源分组ID")
    private Integer houseGrId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源公司ID")
    private Integer custCompId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源大区ID")
    private Integer custAreaId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源片区ID")
    private Integer custRegId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源门店ID")
    private Integer custDeptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源分组ID")
    private Integer custGrId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否扫码1=是")
    private Byte scanFlag;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源方合作状态最后更时间")
    private Date houseCooperateUpdateTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源方合作状态最后更时间")
    private Date custCooperateUpdateTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "成交金额")
    private BigDecimal houseDealPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "佣金")
    private BigDecimal houseBrokerage;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "成交金额")
    private BigDecimal custDealPrice;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "佣金")
    private BigDecimal custBrokerage;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "租期截至")
    private Date houseEnddate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "租期截至")
    private Date custEnddate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "描述")
    private String houseDealDesc;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "描述")
    private String custDealDesc;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "租金单位")
    private Byte houseLeaseUnit;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "租金单位")
    private Byte custLeaseUnit;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "申请成交人档案ID")
    private Integer dealArchiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "总佣金")
    private BigDecimal totalBrokerage;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "申请成交人公司ID")
    private Integer dealCompId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "申请成交人USER_ID")
    private Integer dealUserId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "申请成交方 1=房源方 2=客源方")
    private Byte dealHouseCust;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源佣金比例")
    private BigDecimal houseCommissionRate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源佣金比例")
    private BigDecimal custCommissionRate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "房源方投诉状态 0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)")
    private Byte houseComplaintStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "客源方投诉状态  0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)")
    private Byte custComplaintStatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键自增ID
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键自增ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 房源城市ID
     */
    public Integer getHouseCityId() {
        return houseCityId;
    }

    /**
     *
     * @mbggenerated
     * 房源城市ID
     */
    public void setHouseCityId(Integer houseCityId) {
        this.houseCityId = houseCityId;
    }

    /**
     *
     * @mbggenerated
     * 房源所属人档案ID
     */
    public Integer getHouseArchiveId() {
        return houseArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 房源所属人档案ID
     */
    public void setHouseArchiveId(Integer houseArchiveId) {
        this.houseArchiveId = houseArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 房源所属人用户ID
     */
    public Integer getHouseUserId() {
        return houseUserId;
    }

    /**
     *
     * @mbggenerated
     * 房源所属人用户ID
     */
    public void setHouseUserId(Integer houseUserId) {
        this.houseUserId = houseUserId;
    }

    /**
     *
     * @mbggenerated
     * 房源ID
     */
    public Integer getHouseId() {
        return houseId;
    }

    /**
     *
     * @mbggenerated
     * 房源ID
     */
    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    /**
     *
     * @mbggenerated
     * 客源城市ID
     */
    public Integer getCustCityId() {
        return custCityId;
    }

    /**
     *
     * @mbggenerated
     * 客源城市ID
     */
    public void setCustCityId(Integer custCityId) {
        this.custCityId = custCityId;
    }

    /**
     *
     * @mbggenerated
     * 客源所属人档案ID
     */
    public Integer getCustArchiveId() {
        return custArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 客源所属人档案ID
     */
    public void setCustArchiveId(Integer custArchiveId) {
        this.custArchiveId = custArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 客源所属人用户ID
     */
    public Integer getCustUserId() {
        return custUserId;
    }

    /**
     *
     * @mbggenerated
     * 客源所属人用户ID
     */
    public void setCustUserId(Integer custUserId) {
        this.custUserId = custUserId;
    }

    /**
     *
     * @mbggenerated
     * 客源ID
     */
    public Integer getCustId() {
        return custId;
    }

    /**
     *
     * @mbggenerated
     * 客源ID
     */
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    /**
     *
     * @mbggenerated
     * 合作类型，1=买卖合作 2=租赁合作
     */
    public Byte getCooperateType() {
        return cooperateType;
    }

    /**
     *
     * @mbggenerated
     * 合作类型，1=买卖合作 2=租赁合作
     */
    public void setCooperateType(Byte cooperateType) {
        this.cooperateType = cooperateType;
    }

    /**
     *
     * @mbggenerated
     * 带看时间
     */
    public Date getTakeLookTime() {
        return takeLookTime;
    }

    /**
     *
     * @mbggenerated
     * 带看时间
     */
    public void setTakeLookTime(Date takeLookTime) {
        this.takeLookTime = takeLookTime;
    }

    /**
     *
     * @mbggenerated
     * 扫码地点
     */
    public String getScanCodeAddress() {
        return scanCodeAddress;
    }

    /**
     *
     * @mbggenerated
     * 扫码地点
     */
    public void setScanCodeAddress(String scanCodeAddress) {
        this.scanCodeAddress = scanCodeAddress;
    }

    /**
     *
     * @mbggenerated
     * 房源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效  7=确认成交
     */
    public Byte getHouseCooperateStatus() {
        return houseCooperateStatus;
    }

    /**
     *
     * @mbggenerated
     * 房源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效  7=确认成交
     */
    public void setHouseCooperateStatus(Byte houseCooperateStatus) {
        this.houseCooperateStatus = houseCooperateStatus;
    }

    /**
     *
     * @mbggenerated
     * 客源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效   7=确认成交
     */
    public Byte getCustCooperateStatus() {
        return custCooperateStatus;
    }

    /**
     *
     * @mbggenerated
     * 客源方合作状态，0=待确认 1=合作同意 2=合作拒绝 3=合作成功 4=中止合作 5=已带看 6=失效   7=确认成交
     */
    public void setCustCooperateStatus(Byte custCooperateStatus) {
        this.custCooperateStatus = custCooperateStatus;
    }

    /**
     *
     * @mbggenerated
     * 房源详细信息JSON
     */
    public String getHouseJson() {
        return houseJson;
    }

    /**
     *
     * @mbggenerated
     * 房源详细信息JSON
     */
    public void setHouseJson(String houseJson) {
        this.houseJson = houseJson;
    }

    /**
     *
     * @mbggenerated
     * 客源详细信息JSON
     */
    public String getCustJson() {
        return custJson;
    }

    /**
     *
     * @mbggenerated
     * 客源详细信息JSON
     */
    public void setCustJson(String custJson) {
        this.custJson = custJson;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     * 创建时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     * 房源公司ID
     */
    public Integer getHouseCompId() {
        return houseCompId;
    }

    /**
     *
     * @mbggenerated
     * 房源公司ID
     */
    public void setHouseCompId(Integer houseCompId) {
        this.houseCompId = houseCompId;
    }

    /**
     *
     * @mbggenerated
     * 房源大区ID
     */
    public Integer getHouseAreaId() {
        return houseAreaId;
    }

    /**
     *
     * @mbggenerated
     * 房源大区ID
     */
    public void setHouseAreaId(Integer houseAreaId) {
        this.houseAreaId = houseAreaId;
    }

    /**
     *
     * @mbggenerated
     * 房源片区ID
     */
    public Integer getHouseRegId() {
        return houseRegId;
    }

    /**
     *
     * @mbggenerated
     * 房源片区ID
     */
    public void setHouseRegId(Integer houseRegId) {
        this.houseRegId = houseRegId;
    }

    /**
     *
     * @mbggenerated
     * 房源门店ID
     */
    public Integer getHouseDeptId() {
        return houseDeptId;
    }

    /**
     *
     * @mbggenerated
     * 房源门店ID
     */
    public void setHouseDeptId(Integer houseDeptId) {
        this.houseDeptId = houseDeptId;
    }

    /**
     *
     * @mbggenerated
     * 房源分组ID
     */
    public Integer getHouseGrId() {
        return houseGrId;
    }

    /**
     *
     * @mbggenerated
     * 房源分组ID
     */
    public void setHouseGrId(Integer houseGrId) {
        this.houseGrId = houseGrId;
    }

    /**
     *
     * @mbggenerated
     * 客源公司ID
     */
    public Integer getCustCompId() {
        return custCompId;
    }

    /**
     *
     * @mbggenerated
     * 客源公司ID
     */
    public void setCustCompId(Integer custCompId) {
        this.custCompId = custCompId;
    }

    /**
     *
     * @mbggenerated
     * 客源大区ID
     */
    public Integer getCustAreaId() {
        return custAreaId;
    }

    /**
     *
     * @mbggenerated
     * 客源大区ID
     */
    public void setCustAreaId(Integer custAreaId) {
        this.custAreaId = custAreaId;
    }

    /**
     *
     * @mbggenerated
     * 客源片区ID
     */
    public Integer getCustRegId() {
        return custRegId;
    }

    /**
     *
     * @mbggenerated
     * 客源片区ID
     */
    public void setCustRegId(Integer custRegId) {
        this.custRegId = custRegId;
    }

    /**
     *
     * @mbggenerated
     * 客源门店ID
     */
    public Integer getCustDeptId() {
        return custDeptId;
    }

    /**
     *
     * @mbggenerated
     * 客源门店ID
     */
    public void setCustDeptId(Integer custDeptId) {
        this.custDeptId = custDeptId;
    }

    /**
     *
     * @mbggenerated
     * 客源分组ID
     */
    public Integer getCustGrId() {
        return custGrId;
    }

    /**
     *
     * @mbggenerated
     * 客源分组ID
     */
    public void setCustGrId(Integer custGrId) {
        this.custGrId = custGrId;
    }

    /**
     *
     * @mbggenerated
     * 是否扫码1=是
     */
    public Byte getScanFlag() {
        return scanFlag;
    }

    /**
     *
     * @mbggenerated
     * 是否扫码1=是
     */
    public void setScanFlag(Byte scanFlag) {
        this.scanFlag = scanFlag;
    }

    /**
     *
     * @mbggenerated
     * 房源方合作状态最后更时间
     */
    public Date getHouseCooperateUpdateTime() {
        return houseCooperateUpdateTime;
    }

    /**
     *
     * @mbggenerated
     * 房源方合作状态最后更时间
     */
    public void setHouseCooperateUpdateTime(Date houseCooperateUpdateTime) {
        this.houseCooperateUpdateTime = houseCooperateUpdateTime;
    }

    /**
     *
     * @mbggenerated
     * 客源方合作状态最后更时间
     */
    public Date getCustCooperateUpdateTime() {
        return custCooperateUpdateTime;
    }

    /**
     *
     * @mbggenerated
     * 客源方合作状态最后更时间
     */
    public void setCustCooperateUpdateTime(Date custCooperateUpdateTime) {
        this.custCooperateUpdateTime = custCooperateUpdateTime;
    }

    /**
     *
     * @mbggenerated
     * 成交金额
     */
    public BigDecimal getHouseDealPrice() {
        return houseDealPrice;
    }

    /**
     *
     * @mbggenerated
     * 成交金额
     */
    public void setHouseDealPrice(BigDecimal houseDealPrice) {
        this.houseDealPrice = houseDealPrice;
    }

    /**
     *
     * @mbggenerated
     * 佣金
     */
    public BigDecimal getHouseBrokerage() {
        return houseBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 佣金
     */
    public void setHouseBrokerage(BigDecimal houseBrokerage) {
        this.houseBrokerage = houseBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 成交金额
     */
    public BigDecimal getCustDealPrice() {
        return custDealPrice;
    }

    /**
     *
     * @mbggenerated
     * 成交金额
     */
    public void setCustDealPrice(BigDecimal custDealPrice) {
        this.custDealPrice = custDealPrice;
    }

    /**
     *
     * @mbggenerated
     * 佣金
     */
    public BigDecimal getCustBrokerage() {
        return custBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 佣金
     */
    public void setCustBrokerage(BigDecimal custBrokerage) {
        this.custBrokerage = custBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 租期截至
     */
    public Date getHouseEnddate() {
        return houseEnddate;
    }

    /**
     *
     * @mbggenerated
     * 租期截至
     */
    public void setHouseEnddate(Date houseEnddate) {
        this.houseEnddate = houseEnddate;
    }

    /**
     *
     * @mbggenerated
     * 租期截至
     */
    public Date getCustEnddate() {
        return custEnddate;
    }

    /**
     *
     * @mbggenerated
     * 租期截至
     */
    public void setCustEnddate(Date custEnddate) {
        this.custEnddate = custEnddate;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public String getHouseDealDesc() {
        return houseDealDesc;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public void setHouseDealDesc(String houseDealDesc) {
        this.houseDealDesc = houseDealDesc;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public String getCustDealDesc() {
        return custDealDesc;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public void setCustDealDesc(String custDealDesc) {
        this.custDealDesc = custDealDesc;
    }

    /**
     *
     * @mbggenerated
     * 租金单位
     */
    public Byte getHouseLeaseUnit() {
        return houseLeaseUnit;
    }

    /**
     *
     * @mbggenerated
     * 租金单位
     */
    public void setHouseLeaseUnit(Byte houseLeaseUnit) {
        this.houseLeaseUnit = houseLeaseUnit;
    }

    /**
     *
     * @mbggenerated
     * 租金单位
     */
    public Byte getCustLeaseUnit() {
        return custLeaseUnit;
    }

    /**
     *
     * @mbggenerated
     * 租金单位
     */
    public void setCustLeaseUnit(Byte custLeaseUnit) {
        this.custLeaseUnit = custLeaseUnit;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人档案ID
     */
    public Integer getDealArchiveId() {
        return dealArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人档案ID
     */
    public void setDealArchiveId(Integer dealArchiveId) {
        this.dealArchiveId = dealArchiveId;
    }

    /**
     *
     * @mbggenerated
     * 总佣金
     */
    public BigDecimal getTotalBrokerage() {
        return totalBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 总佣金
     */
    public void setTotalBrokerage(BigDecimal totalBrokerage) {
        this.totalBrokerage = totalBrokerage;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人公司ID
     */
    public Integer getDealCompId() {
        return dealCompId;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人公司ID
     */
    public void setDealCompId(Integer dealCompId) {
        this.dealCompId = dealCompId;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人USER_ID
     */
    public Integer getDealUserId() {
        return dealUserId;
    }

    /**
     *
     * @mbggenerated
     * 申请成交人USER_ID
     */
    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    /**
     *
     * @mbggenerated
     * 申请成交方 1=房源方 2=客源方
     */
    public Byte getDealHouseCust() {
        return dealHouseCust;
    }

    /**
     *
     * @mbggenerated
     * 申请成交方 1=房源方 2=客源方
     */
    public void setDealHouseCust(Byte dealHouseCust) {
        this.dealHouseCust = dealHouseCust;
    }

    /**
     *
     * @mbggenerated
     * 房源佣金比例
     */
    public BigDecimal getHouseCommissionRate() {
        return houseCommissionRate;
    }

    /**
     *
     * @mbggenerated
     * 房源佣金比例
     */
    public void setHouseCommissionRate(BigDecimal houseCommissionRate) {
        this.houseCommissionRate = houseCommissionRate;
    }

    /**
     *
     * @mbggenerated
     * 客源佣金比例
     */
    public BigDecimal getCustCommissionRate() {
        return custCommissionRate;
    }

    /**
     *
     * @mbggenerated
     * 客源佣金比例
     */
    public void setCustCommissionRate(BigDecimal custCommissionRate) {
        this.custCommissionRate = custCommissionRate;
    }

    /**
     *
     * @mbggenerated
     * 房源方投诉状态 0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)
     */
    public Byte getHouseComplaintStatus() {
        return houseComplaintStatus;
    }

    /**
     *
     * @mbggenerated
     * 房源方投诉状态 0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)
     */
    public void setHouseComplaintStatus(Byte houseComplaintStatus) {
        this.houseComplaintStatus = houseComplaintStatus;
    }

    /**
     *
     * @mbggenerated
     * 客源方投诉状态  0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)
     */
    public Byte getCustComplaintStatus() {
        return custComplaintStatus;
    }

    /**
     *
     * @mbggenerated
     * 客源方投诉状态  0=投诉中 1=待申诉 2=申诉中 3=24小时未处理，投诉成立 4=不申诉，投诉成立  5=人工处理，投诉成立(申诉不成立) 6=人工处理，投诉不成立(申诉成立)
     */
    public void setCustComplaintStatus(Byte custComplaintStatus) {
        this.custComplaintStatus = custComplaintStatus;
    }
}
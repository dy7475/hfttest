package com.myfun.repository.erpdb.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunTrack;

public class ErpFunTrackDto extends ErpFunTrack{
	
	private String viewName;
	private String trackUserName;
	private String needAudit;
	private String trackUsers;
	private String trackDepts;
	private Integer custId;
	private Integer daikanUser;
	private Integer targetDept;
	private String custName;
	private Byte custSex;
	private String regName;
	private Double areaLow;
	private Double areaHigh;
	private Double priceLow;
	private Double priceHigh;
	private String buildName;
	private String bound;
	private Integer saleId;
	private Integer leaseId;
	private String status;
	private Byte room;
	private Byte hall;
	private Byte wei;
	private Byte yang;
	private Double area;
	private Double price;
	private String leaseNo;
	private String saleNo;
	private Integer lookCount;
	private Integer explrthCount;
	private String wlId;
	private String trackTime;
	private Integer ownerUserId;
	private String canView;
	private Date trackStickTime;
	private String fitmentDescribe;
	private String coreSellPoint;
	private String layoutIntroduce;
	private String propertyRights;
	private String canViewCoreChange;
	private Byte isHisTrack;
	private String otherInfo;
	private Integer daikanNum;
	private Date targetTime;
	private List<MkHouseInfo> mkLookHouses;
	private String cooperateUserName;
	
	private String cooperateDeptName;
	
	private Byte hasKeyVoucher;
	private Byte saleLeaseType;
	
	public List<MkHouseInfo> getMkLookHouses() {
		return mkLookHouses;
	}

	public void setMkLookHouses(List<MkHouseInfo> mkLookHouses) {
		this.mkLookHouses = mkLookHouses;
	}

	public static class MkHouseInfo {
		private Integer caseId;
		private String buildName;
		private Byte room;
		private Byte hall;
		private BigDecimal area;
		private BigDecimal price;
		private Byte usage;
		private Integer cooperateCaseId;
		private String cooperateDeptName;
		private String cooperateUserName;

		public Byte getUsage() {
			return usage;
		}

		public void setUsage(Byte usage) {
			this.usage = usage;
		}

		public Integer getCaseId() {
			return caseId;
		}

		public void setCaseId(Integer caseId) {
			this.caseId = caseId;
		}

		public String getBuildName() {
			return buildName;
		}

		public void setBuildName(String buildName) {
			this.buildName = buildName;
		}

		public Byte getRoom() {
			return room;
		}

		public void setRoom(Byte room) {
			this.room = room;
		}

		public Byte getHall() {
			return hall;
		}

		public void setHall(Byte hall) {
			this.hall = hall;
		}

		public BigDecimal getArea() {
			return area;
		}

		public void setArea(BigDecimal area) {
			this.area = area;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getCooperateDeptName() {
			return cooperateDeptName;
		}

		public void setCooperateDeptName(String cooperateDeptName) {
			this.cooperateDeptName = cooperateDeptName;
		}

		public String getCooperateUserName() {
			return cooperateUserName;
		}

		public void setCooperateUserName(String cooperateUserName) {
			this.cooperateUserName = cooperateUserName;
		}

		public Integer getCooperateCaseId() {
			return cooperateCaseId;
		}

		public void setCooperateCaseId(Integer cooperateCaseId) {
			this.cooperateCaseId = cooperateCaseId;
		}
		
	}

	public Integer getDaikanNum() {
		return daikanNum;
	}

	public void setDaikanNum(Integer daikanNum) {
		this.daikanNum = daikanNum;
	}

	public Byte getIsHisTrack() {
		return isHisTrack;
	}

	public void setIsHisTrack(Byte isHisTrack) {
		this.isHisTrack = isHisTrack;
	}

	public String getCanViewCoreChange() {
		return canViewCoreChange;
	}

	public void setCanViewCoreChange(String canViewCoreChange) {
		this.canViewCoreChange = canViewCoreChange;
	}

	public String getFitmentDescribe() {
		return fitmentDescribe;
	}

	public void setFitmentDescribe(String fitmentDescribe) {
		this.fitmentDescribe = fitmentDescribe;
	}

	public String getCoreSellPoint() {
		return coreSellPoint;
	}

	public void setCoreSellPoint(String coreSellPoint) {
		this.coreSellPoint = coreSellPoint;
	}

	public String getLayoutIntroduce() {
		return layoutIntroduce;
	}

	public void setLayoutIntroduce(String layoutIntroduce) {
		this.layoutIntroduce = layoutIntroduce;
	}

	public String getPropertyRights() {
		return propertyRights;
	}

	public void setPropertyRights(String propertyRights) {
		this.propertyRights = propertyRights;
	}

	public Date getTrackStickTime() {
		return trackStickTime;
	}

	public void setTrackStickTime(Date trackStickTime) {
		this.trackStickTime = trackStickTime;
	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getTrackUserName() {
		return trackUserName;
	}
	public void setTrackUserName(String trackUserName) {
		this.trackUserName = trackUserName;
	}
	public String getNeedAudit() {
		return needAudit;
	}
	public void setNeedAudit(String needAudit) {
		this.needAudit = needAudit;
	}
	public String getTrackUsers() {
		return trackUsers;
	}
	public void setTrackUsers(String trackUsers) {
		this.trackUsers = trackUsers;
	}
	public String getTrackDepts() {
		return trackDepts;
	}
	public void setTrackDepts(String trackDepts) {
		this.trackDepts = trackDepts;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Integer getDaikanUser() {
		return daikanUser;
	}
	public void setDaikanUser(Integer daikanUser) {
		this.daikanUser = daikanUser;
	}
	public Integer getTargetDept() {
		return targetDept;
	}
	public void setTargetDept(Integer targetDept) {
		this.targetDept = targetDept;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Byte getCustSex() {
		return custSex;
	}
	public void setCustSex(Byte custSex) {
		this.custSex = custSex;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public Double getAreaLow() {
		return areaLow;
	}
	public void setAreaLow(Double areaLow) {
		this.areaLow = areaLow;
	}
	public Double getAreaHigh() {
		return areaHigh;
	}
	public void setAreaHigh(Double areaHigh) {
		this.areaHigh = areaHigh;
	}
	public Double getPriceLow() {
		return priceLow;
	}
	public void setPriceLow(Double priceLow) {
		this.priceLow = priceLow;
	}
	public Double getPriceHigh() {
		return priceHigh;
	}
	public void setPriceHigh(Double priceHigh) {
		this.priceHigh = priceHigh;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getBound() {
		return bound;
	}
	public void setBound(String bound) {
		this.bound = bound;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public Integer getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Byte getRoom() {
		return room;
	}
	public void setRoom(Byte room) {
		this.room = room;
	}
	public Byte getHall() {
		return hall;
	}
	public void setHall(Byte hall) {
		this.hall = hall;
	}
	public Byte getWei() {
		return wei;
	}
	public void setWei(Byte wei) {
		this.wei = wei;
	}
	public Byte getYang() {
		return yang;
	}
	public void setYang(Byte yang) {
		this.yang = yang;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLeaseNo() {
		return leaseNo;
	}
	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}
	public String getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	public Integer getLookCount() {
		return lookCount;
	}
	public void setLookCount(Integer lookCount) {
		this.lookCount = lookCount;
	}
	public Integer getExplrthCount() {
		return explrthCount;
	}
	public void setExplrthCount(Integer explrthCount) {
		this.explrthCount = explrthCount;
	}
	public String getWlId() {
		return wlId;
	}
	public void setWlId(String wlId) {
		this.wlId = wlId;
	}
	public String getTrackTime() {
		return trackTime;
	}
	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime;
	}
	public Integer getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(Integer ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public String getCanView() {
		return canView;
	}
	public void setCanView(String canView) {
		this.canView = canView;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Date getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(Date targetTime) {
		this.targetTime = targetTime;
	}

	public String getCooperateUserName() {
		return cooperateUserName;
	}

	public void setCooperateUserName(String cooperateUserName) {
		this.cooperateUserName = cooperateUserName;
	}

	public String getCooperateDeptName() {
		return cooperateDeptName;
	}

	public void setCooperateDeptName(String cooperateDeptName) {
		this.cooperateDeptName = cooperateDeptName;
	}

	public Byte getHasKeyVoucher() {
		return hasKeyVoucher;
	}

	public void setHasKeyVoucher(Byte hasKeyVoucher) {
		this.hasKeyVoucher = hasKeyVoucher;
	}

	public Byte getSaleLeaseType() {
		return saleLeaseType;
	}

	public void setSaleLeaseType(Byte saleLeaseType) {
		this.saleLeaseType = saleLeaseType;
	}
	
}

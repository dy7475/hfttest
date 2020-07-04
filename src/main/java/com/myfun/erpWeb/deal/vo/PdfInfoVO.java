package com.myfun.erpWeb.deal.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PdfInfoVO implements Serializable{
	
	@ApiModelProperty("总页数")
	private Integer page;
	
	@ApiModelProperty("pdf地址")
	private String pdfAddr;
	
	@ApiModelProperty("甲方签字区域")
	private PartyInfo partyAInfo;
	
	@ApiModelProperty("乙方签字区域")
	private PartyInfo partyBInfo;
	
	@ApiModelProperty("丙方盖章区域")
	private PartyInfo partyCInfo;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getPdfAddr() {
		return pdfAddr;
	}

	public void setPdfAddr(String pdfAddr) {
		this.pdfAddr = pdfAddr;
	}

	public PartyInfo getPartyAInfo() {
		return partyAInfo;
	}

	public void setPartyAInfo(PartyInfo partyAInfo) {
		this.partyAInfo = partyAInfo;
	}

	public PartyInfo getPartyBInfo() {
		return partyBInfo;
	}

	public void setPartyBInfo(PartyInfo partyBInfo) {
		this.partyBInfo = partyBInfo;
	}

	public PartyInfo getPartyCInfo() {
		return partyCInfo;
	}

	public void setPartyCInfo(PartyInfo partyCInfo) {
		this.partyCInfo = partyCInfo;
	}

	@ApiModel
	public static class PartyInfo implements Serializable{
		@ApiModelProperty("签名坐标x")
		private String signX;
		
		@ApiModelProperty("签名坐标y")
		private String signY;
		
		@ApiModelProperty("日期坐标x")
		private String dateX;
		
		@ApiModelProperty("日期坐标y")
		private String dateY;
		
		@ApiModelProperty("签名页数")
		private String pageNum;

		public String getSignX() {
			return signX;
		}

		public void setSignX(String signX) {
			this.signX = signX;
		}

		public String getSignY() {
			return signY;
		}

		public void setSignY(String signY) {
			this.signY = signY;
		}

		public String getDateX() {
			return dateX;
		}

		public void setDateX(String dateX) {
			this.dateX = dateX;
		}

		public String getDateY() {
			return dateY;
		}

		public void setDateY(String dateY) {
			this.dateY = dateY;
		}

		public String getPageNum() {
			return pageNum;
		}

		public void setPageNum(String pageNum) {
			this.pageNum = pageNum;
		}
		
	}
}

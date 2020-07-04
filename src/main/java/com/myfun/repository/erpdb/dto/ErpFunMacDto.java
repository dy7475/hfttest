package com.myfun.repository.erpdb.dto;

public class ErpFunMacDto {
	/**
	 * 
	 */
	private String pcId;
	/**
	 * 
	 */
	private Integer compId;
	/**
	 * 
	 */
	private Integer deptId;
	/**
	 * 
	 */
	private String pcname;
	/**
	 * 
	 */
	private Byte flag;
	/**
	 * 
	 */
	private Boolean roam;
	/**
	 * 
	 */
	private Integer roamUser;
	/**
	 * 
	 */
	private String owner;
	/**
	 * 
	 */
	private String pcdiskno;
	/**
	 * 
	 */
	private String routemac;
	/**
	 * 
	 */
	private String regtime;
	/**
	 * 
	 */
	private String compNo;
	/**
	 * 
	 */
	private String deptNo;
	/**
	 * 
	 */
	private String macaddr;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private  Integer organizationId;

	public String getMacaddr() {
		return macaddr;
	}

	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	/**
	 * 
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * 
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * 
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * 
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * 
	 */
	public String getPcname() {
		return pcname;
	}

	/**
	 * 
	 */
	public void setPcname(String pcname) {
		this.pcname = pcname == null ? null : pcname.trim();
	}

	/**
	 * 
	 */
	public Byte getFlag() {
		return flag;
	}

	/**
	 * 
	 */
	public void setFlag(Byte flag) {
		this.flag = flag;
	}

	/**
	 * 
	 */
	public Boolean getRoam() {
		return roam;
	}

	/**
	 * 
	 */
	public void setRoam(Boolean roam) {
		this.roam = roam;
	}

	/**
	 * 
	 */
	public Integer getRoamUser() {
		return roamUser;
	}

	/**
	 * 
	 */
	public void setRoamUser(Integer roamUser) {
		this.roamUser = roamUser;
	}

	/**
	 * 
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * 
	 */
	public void setOwner(String owner) {
		this.owner = owner == null ? null : owner.trim();
	}

	/**
	 * 
	 */
	public String getPcdiskno() {
		return pcdiskno;
	}

	/**
	 * 
	 */
	public void setPcdiskno(String pcdiskno) {
		this.pcdiskno = pcdiskno == null ? null : pcdiskno.trim();
	}

	/**
	 * 
	 */
	public String getRoutemac() {
		return routemac;
	}

	/**
	 * 
	 */
	public void setRoutemac(String routemac) {
		this.routemac = routemac == null ? null : routemac.trim();
	}

	/**
	 * 
	 */
	public String getRegtime() {
		return regtime;
	}

	/**
	 * 
	 */
	public void setRegtime(String regtime) {
		this.regtime = regtime == null ? null : regtime.trim();
	}

	/**
	 * 
	 */
	public String getCompNo() {
		return compNo;
	}

	/**
	 * 
	 */
	public void setCompNo(String compNo) {
		this.compNo = compNo == null ? null : compNo.trim();
	}

	/**
	 * 
	 */
	public String getDeptNo() {
		return deptNo;
	}

	/**
	 * 
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo == null ? null : deptNo.trim();
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
}

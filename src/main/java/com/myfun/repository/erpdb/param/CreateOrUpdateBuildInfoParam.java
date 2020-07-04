/**
 * @author 方李骥
 * @since 2016年8月31日
 */
package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

/**
 * @author 方李骥
 * @since 2016年8月31日
 */
public class CreateOrUpdateBuildInfoParam extends AbstractEncryParam implements DaoBaseParam{
	/**
	 * @mbggenerated ，自增序列
	 */
	private Integer buildId;
	/**
	 * @mbggenerated 市(县)ID
	 */
	private Short cityId;
	/**
	 * @mbggenerated 楼盘名称
	 */
	private String buildName;
	/**
	 * @mbggenerated 检索码
	 */
	private String buildCode;
	/**
	 * @mbggenerated 开发商
	 */
	private String buildDevloper;
	/**
	 * @mbggenerated 楼盘位置
	 */
	private String buildAddr;
	/**
	 * @mbggenerated 行政区域
	 */
	private Integer buildRegion;
	/**
	 * @mbggenerated 片区ID
	 */
	private Integer sectionId;
	/**
	 * @mbggenerated 环域，DD:HOUSE_ROUND
	 */
	private Byte buildRound;
	/**
	 * @mbggenerated 地跌线路ID(多选)
	 */
	private String subwayIds;
	/**
	 * @mbggenerated 地跌站点ID(多选)
	 */
	private String stationIds;
	/**
	 * @mbggenerated 配套情况
	 */
	private String addCase;
	/**
	 * @mbggenerated 产权办理
	 */
	private String rightConduct;
	/**
	 * @mbggenerated 建筑类型
	 */
	private String buildType;
	/**
	 * @mbggenerated 开盘日期
	 */
	private String buildDate;
	/**
	 * @mbggenerated 交房日期
	 */
	private String submitDate;
	/**
	 * @mbggenerated 占地面积
	 */
	private String buildArea;
	/**
	 * @mbggenerated 项目套数
	 */
	private String projectCover;
	/**
	 * @mbggenerated 容积率
	 */
	private String projectSpace;
	/**
	 * @mbggenerated 绿化率
	 */
	private String projectGreen;
	/**
	 * @mbggenerated 车位情况
	 */
	private String carsCase;
	/**
	 * @mbggenerated 公交线路
	 */
	private String busLine;
	/**
	 * @mbggenerated 物管公司
	 */
	private String propertyComp;
	/**
	 * @mbggenerated 物管电话
	 */
	private String propertycompTele;
	/**
	 * @mbggenerated 收费标准
	 */
	private String costStandard;
	/**
	 * @mbggenerated 楼盘简介
	 */
	private String buildDescript;
	/**
	 * @mbggenerated 图片标记，N=图片张数
	 */
	private Integer buildPhoto;
	/**
	 * @mbggenerated 座标X
	 */
	private String positionX;
	/**
	 * @mbggenerated 座标Y
	 */
	private String positionY;
	/**
	 * @mbggenerated 座标标志，1=是
	 */
	private Short positionFlag;
	/**
	 * @mbggenerated 典型标志，1=是
	 */
	private Short typicFlag;
	/**
	 * @mbggenerated 审核标志，1=是
	 */
	private Short vertifyFlag;
	/**
	 * @mbggenerated 经纪人ID
	 */
	private Integer archiveId;
	/**
	 * @mbggenerated 提交时间
	 */
	private String createTime;
	/**
	 * @mbggenerated 更新时间
	 */
	private String updateTime;
	/**
	 * @mbggenerated 后台校正标记
	 */
	private Short examFlag;
	/**
	 * @mbggenerated 纠错时间
	 */
	private String checkTime;
	/**
	 * @mbggenerated 用户在新建房源时更改该楼盘地理信息的次数，Default{0}
	 */
	private Byte addrCount;
	/**
	 * @mbggenerated 楼盘状态
	 */
	private Byte buildStatus;
	/**
	 * @mbggenerated 物业类型描述
	 */
	private String buildUsage;
	/**
	 * @mbggenerated 施工进度
	 */
	private String buildProgress;
	/**
	 * @mbggenerated 项目特色IDS DD:HOUSE_FEATURE
	 */
	private String projectSpec;
	/**
	 * @mbggenerated 产权年限
	 */
	private String rightYears;
	/**
	 * @mbggenerated 楼盘销售许可证
	 */
	private String buildPermission;
	/**
	 * @mbggenerated 开盘日期
	 */
	private String sellDate;
	/**
	 * @mbggenerated 竣工日期
	 */
	private String finishDate;
	/**
	 * @mbggenerated 装修状况IDS DD:BUILD_FITMENT
	 */
	private String buildFitment;
	/**
	 * @mbggenerated 建筑面积
	 */
	private String constractArea;
	/**
	 * @mbggenerated 售楼部地址
	 */
	private String sellAddr;
	/**
	 * @mbggenerated 售楼电话
	 */
	private String sellTele;
	/**
	 * @mbggenerated 销售价格
	 */
	private Integer price;
	/**
	 * @mbggenerated 销售价格描述
	 */
	private String priceText;
	/**
	 * @mbggenerated 外景图
	 */
	private Integer photoExterior;
	/**
	 * @mbggenerated 效果图
	 */
	private Integer photoEffects;
	/**
	 * @mbggenerated 户型图
	 */
	private Integer photoModel;
	/**
	 * @mbggenerated 交通图
	 */
	private Integer photoTraffic;
	/**
	 * @mbggenerated 规划图
	 */
	private Integer photoPlan;
	/**
	 * @mbggenerated 配套图
	 */
	private Integer photoSet;
	/**
	 * @mbggenerated 样板图
	 */
	private Integer photoTemplet;
	/**
	 * @mbggenerated 新盘标志
	 */
	private Byte newFlag;
	/**
	 * @mbggenerated 审核后的图片张数
	 */
	private Byte examPhoto;
	/**
	 * @mbggenerated 售楼电话1
	 */
	private String sellTele1;
	/**
	 * @mbggenerated 400电话
	 */
	private String tele400;
	/**
	 * @mbggenerated 400分机号
	 */
	private String extcode;
	/**
	 * @mbggenerated 对接腾讯-物业类型
	 */
	private Integer fpropertyunit;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fbroadband;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fdrinkingwater;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fgas;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fparkids;
	/**
	 * @mbggenerated 对接腾讯-投资商
	 */
	private String finvestor;
	/**
	 * @mbggenerated 对接腾讯-承建商
	 */
	private String fbuilder;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String flandscape;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private Byte fstatus;
	/**
	 * @mbggenerated 楼盘别名
	 */
	private String falias;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private Integer fhouseid;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String funitids;
	/**
	 * @mbggenerated 对接腾讯-物业费
	 */
	private Double fpropertyfee;
	/**
	 * @mbggenerated 对接腾讯-
	 */
	private String fhousetypeids;
	/**
	 * @mbggenerated
	 */
	private Integer buildWebid;
	/**
	 * @mbggenerated 酷家乐楼盘名称
	 */
	private String kjlBuildName;
	/**
	 * @mbggenerated 地图坐标审核标志
	 */
	private Integer positionCheck;
	/**
	 * 
	 */
	private String regName;
	/**
	 * 
	 */
	private String cx;
	/**
	 * 
	 */
	private String cy;
	/**
	 * 
	 */
	private String buildLock;
	/**
	 * 
	 */
	private String hasBuild;
	/**
	 * 
	 */
	private String firstPicAddr;
	/**
	 * 
	 */
	private Integer sid;
	/**
	 * 
	 */
	private String sectionName;
	/**
	 * 
	 */
	private String sectionIdText;
	/**
	 * 
	 */
	private Integer provinceId;
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
	private Integer postionY;
	/**
	 * 
	 */
	private Byte checkFlag;
	public Integer getBuildId() {
		return buildId;
	}
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	public Short getCityId() {
		return cityId;
	}
	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getBuildCode() {
		return buildCode;
	}
	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}
	public String getBuildDevloper() {
		return buildDevloper;
	}
	public void setBuildDevloper(String buildDevloper) {
		this.buildDevloper = buildDevloper;
	}
	public String getBuildAddr() {
		return buildAddr;
	}
	public void setBuildAddr(String buildAddr) {
		this.buildAddr = buildAddr;
	}
	public Integer getBuildRegion() {
		return buildRegion;
	}
	public void setBuildRegion(Integer buildRegion) {
		this.buildRegion = buildRegion;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public Byte getBuildRound() {
		return buildRound;
	}
	public void setBuildRound(Byte buildRound) {
		this.buildRound = buildRound;
	}
	public String getSubwayIds() {
		return subwayIds;
	}
	public void setSubwayIds(String subwayIds) {
		this.subwayIds = subwayIds;
	}
	public String getStationIds() {
		return stationIds;
	}
	public void setStationIds(String stationIds) {
		this.stationIds = stationIds;
	}
	public String getAddCase() {
		return addCase;
	}
	public void setAddCase(String addCase) {
		this.addCase = addCase;
	}
	public String getRightConduct() {
		return rightConduct;
	}
	public void setRightConduct(String rightConduct) {
		this.rightConduct = rightConduct;
	}
	public String getBuildType() {
		return buildType;
	}
	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}
	public String getBuildDate() {
		return buildDate;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getBuildArea() {
		return buildArea;
	}
	public void setBuildArea(String buildArea) {
		this.buildArea = buildArea;
	}
	public String getProjectCover() {
		return projectCover;
	}
	public void setProjectCover(String projectCover) {
		this.projectCover = projectCover;
	}
	public String getProjectSpace() {
		return projectSpace;
	}
	public void setProjectSpace(String projectSpace) {
		this.projectSpace = projectSpace;
	}
	public String getProjectGreen() {
		return projectGreen;
	}
	public void setProjectGreen(String projectGreen) {
		this.projectGreen = projectGreen;
	}
	public String getCarsCase() {
		return carsCase;
	}
	public void setCarsCase(String carsCase) {
		this.carsCase = carsCase;
	}
	public String getBusLine() {
		return busLine;
	}
	public void setBusLine(String busLine) {
		this.busLine = busLine;
	}
	public String getPropertyComp() {
		return propertyComp;
	}
	public void setPropertyComp(String propertyComp) {
		this.propertyComp = propertyComp;
	}
	public String getPropertycompTele() {
		return propertycompTele;
	}
	public void setPropertycompTele(String propertycompTele) {
		this.propertycompTele = propertycompTele;
	}
	public String getCostStandard() {
		return costStandard;
	}
	public void setCostStandard(String costStandard) {
		this.costStandard = costStandard;
	}
	public String getBuildDescript() {
		return buildDescript;
	}
	public void setBuildDescript(String buildDescript) {
		this.buildDescript = buildDescript;
	}
	public Integer getBuildPhoto() {
		return buildPhoto;
	}
	public void setBuildPhoto(Integer buildPhoto) {
		this.buildPhoto = buildPhoto;
	}
	public String getPositionX() {
		return positionX;
	}
	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}
	public String getPositionY() {
		return positionY;
	}
	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}
	public Short getPositionFlag() {
		return positionFlag;
	}
	public void setPositionFlag(Short positionFlag) {
		this.positionFlag = positionFlag;
	}
	public Short getTypicFlag() {
		return typicFlag;
	}
	public void setTypicFlag(Short typicFlag) {
		this.typicFlag = typicFlag;
	}
	public Short getVertifyFlag() {
		return vertifyFlag;
	}
	public void setVertifyFlag(Short vertifyFlag) {
		this.vertifyFlag = vertifyFlag;
	}
	public Integer getArchiveId() {
		return archiveId;
	}
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public Short getExamFlag() {
		return examFlag;
	}
	public void setExamFlag(Short examFlag) {
		this.examFlag = examFlag;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public Byte getAddrCount() {
		return addrCount;
	}
	public void setAddrCount(Byte addrCount) {
		this.addrCount = addrCount;
	}
	public Byte getBuildStatus() {
		return buildStatus;
	}
	public void setBuildStatus(Byte buildStatus) {
		this.buildStatus = buildStatus;
	}
	public String getBuildUsage() {
		return buildUsage;
	}
	public void setBuildUsage(String buildUsage) {
		this.buildUsage = buildUsage;
	}
	public String getBuildProgress() {
		return buildProgress;
	}
	public void setBuildProgress(String buildProgress) {
		this.buildProgress = buildProgress;
	}
	public String getProjectSpec() {
		return projectSpec;
	}
	public void setProjectSpec(String projectSpec) {
		this.projectSpec = projectSpec;
	}
	public String getRightYears() {
		return rightYears;
	}
	public void setRightYears(String rightYears) {
		this.rightYears = rightYears;
	}
	public String getBuildPermission() {
		return buildPermission;
	}
	public void setBuildPermission(String buildPermission) {
		this.buildPermission = buildPermission;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public String getBuildFitment() {
		return buildFitment;
	}
	public void setBuildFitment(String buildFitment) {
		this.buildFitment = buildFitment;
	}
	public String getConstractArea() {
		return constractArea;
	}
	public void setConstractArea(String constractArea) {
		this.constractArea = constractArea;
	}
	public String getSellAddr() {
		return sellAddr;
	}
	public void setSellAddr(String sellAddr) {
		this.sellAddr = sellAddr;
	}
	public String getSellTele() {
		return sellTele;
	}
	public void setSellTele(String sellTele) {
		this.sellTele = sellTele;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getPriceText() {
		return priceText;
	}
	public void setPriceText(String priceText) {
		this.priceText = priceText;
	}
	public Integer getPhotoExterior() {
		return photoExterior;
	}
	public void setPhotoExterior(Integer photoExterior) {
		this.photoExterior = photoExterior;
	}
	public Integer getPhotoEffects() {
		return photoEffects;
	}
	public void setPhotoEffects(Integer photoEffects) {
		this.photoEffects = photoEffects;
	}
	public Integer getPhotoModel() {
		return photoModel;
	}
	public void setPhotoModel(Integer photoModel) {
		this.photoModel = photoModel;
	}
	public Integer getPhotoTraffic() {
		return photoTraffic;
	}
	public void setPhotoTraffic(Integer photoTraffic) {
		this.photoTraffic = photoTraffic;
	}
	public Integer getPhotoPlan() {
		return photoPlan;
	}
	public void setPhotoPlan(Integer photoPlan) {
		this.photoPlan = photoPlan;
	}
	public Integer getPhotoSet() {
		return photoSet;
	}
	public void setPhotoSet(Integer photoSet) {
		this.photoSet = photoSet;
	}
	public Integer getPhotoTemplet() {
		return photoTemplet;
	}
	public void setPhotoTemplet(Integer photoTemplet) {
		this.photoTemplet = photoTemplet;
	}
	public Byte getNewFlag() {
		return newFlag;
	}
	public void setNewFlag(Byte newFlag) {
		this.newFlag = newFlag;
	}
	public Byte getExamPhoto() {
		return examPhoto;
	}
	public void setExamPhoto(Byte examPhoto) {
		this.examPhoto = examPhoto;
	}
	public String getSellTele1() {
		return sellTele1;
	}
	public void setSellTele1(String sellTele1) {
		this.sellTele1 = sellTele1;
	}
	public String getTele400() {
		return tele400;
	}
	public void setTele400(String tele400) {
		this.tele400 = tele400;
	}
	public String getExtcode() {
		return extcode;
	}
	public void setExtcode(String extcode) {
		this.extcode = extcode;
	}
	public Integer getFpropertyunit() {
		return fpropertyunit;
	}
	public void setFpropertyunit(Integer fpropertyunit) {
		this.fpropertyunit = fpropertyunit;
	}
	public String getFbroadband() {
		return fbroadband;
	}
	public void setFbroadband(String fbroadband) {
		this.fbroadband = fbroadband;
	}
	public String getFdrinkingwater() {
		return fdrinkingwater;
	}
	public void setFdrinkingwater(String fdrinkingwater) {
		this.fdrinkingwater = fdrinkingwater;
	}
	public String getFgas() {
		return fgas;
	}
	public void setFgas(String fgas) {
		this.fgas = fgas;
	}
	public String getFparkids() {
		return fparkids;
	}
	public void setFparkids(String fparkids) {
		this.fparkids = fparkids;
	}
	public String getFinvestor() {
		return finvestor;
	}
	public void setFinvestor(String finvestor) {
		this.finvestor = finvestor;
	}
	public String getFbuilder() {
		return fbuilder;
	}
	public void setFbuilder(String fbuilder) {
		this.fbuilder = fbuilder;
	}
	public String getFlandscape() {
		return flandscape;
	}
	public void setFlandscape(String flandscape) {
		this.flandscape = flandscape;
	}
	public Byte getFstatus() {
		return fstatus;
	}
	public void setFstatus(Byte fstatus) {
		this.fstatus = fstatus;
	}
	public String getFalias() {
		return falias;
	}
	public void setFalias(String falias) {
		this.falias = falias;
	}
	public Integer getFhouseid() {
		return fhouseid;
	}
	public void setFhouseid(Integer fhouseid) {
		this.fhouseid = fhouseid;
	}
	public String getFunitids() {
		return funitids;
	}
	public void setFunitids(String funitids) {
		this.funitids = funitids;
	}
	public Double getFpropertyfee() {
		return fpropertyfee;
	}
	public void setFpropertyfee(Double fpropertyfee) {
		this.fpropertyfee = fpropertyfee;
	}
	public String getFhousetypeids() {
		return fhousetypeids;
	}
	public void setFhousetypeids(String fhousetypeids) {
		this.fhousetypeids = fhousetypeids;
	}
	public Integer getBuildWebid() {
		return buildWebid;
	}
	public void setBuildWebid(Integer buildWebid) {
		this.buildWebid = buildWebid;
	}
	public String getKjlBuildName() {
		return kjlBuildName;
	}
	public void setKjlBuildName(String kjlBuildName) {
		this.kjlBuildName = kjlBuildName;
	}
	public Integer getPositionCheck() {
		return positionCheck;
	}
	public void setPositionCheck(Integer positionCheck) {
		this.positionCheck = positionCheck;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getCy() {
		return cy;
	}
	public void setCy(String cy) {
		this.cy = cy;
	}
	public String getBuildLock() {
		return buildLock;
	}
	public void setBuildLock(String buildLock) {
		this.buildLock = buildLock;
	}
	public String getHasBuild() {
		return hasBuild;
	}
	public void setHasBuild(String hasBuild) {
		this.hasBuild = hasBuild;
	}
	public String getFirstPicAddr() {
		return firstPicAddr;
	}
	public void setFirstPicAddr(String firstPicAddr) {
		this.firstPicAddr = firstPicAddr;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSectionIdText() {
		return sectionIdText;
	}
	public void setSectionIdText(String sectionIdText) {
		this.sectionIdText = sectionIdText;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getPostionY() {
		return postionY;
	}
	public void setPostionY(Integer postionY) {
		this.postionY = postionY;
	}
	public Byte getCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(Byte checkFlag) {
		this.checkFlag = checkFlag;
	}

	
}

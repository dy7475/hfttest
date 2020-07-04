package com.myfun.repository.erpdb.param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class QueryHouseCustListParam extends ErpFunSale implements EncryParamIfc{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("室低值")
	private Integer roomNumLow;// 室低值
	@ApiModelProperty("室高值")
	private Integer roomNumHigh;// 室高值
	@ApiModelProperty("楼层1")
	private Integer floor1;// 楼层1
	@ApiModelProperty("楼层2")
	private Integer floor2;// 楼层2
	@ApiModelProperty("面积最小值")
	private BigDecimal areaLow;// 面积最小值
	@ApiModelProperty("面积最大值")
	private BigDecimal areaHigh;// 面积最大值
	@ApiModelProperty("套内面积1")
	private BigDecimal innerareaLow;// 套内面积1
	@ApiModelProperty("套内面积2")
	private BigDecimal innerareaHigh;// 套内面积2
	@ApiModelProperty("总价值低")
	private BigDecimal totalPrice1;// 总价值低
	@ApiModelProperty("总价值高")
	private BigDecimal totalPrice2;// 总价值高
	@ApiModelProperty("单价1")
	private BigDecimal unitPrice1;// 单价1
	@ApiModelProperty("单价2")
	private BigDecimal unitPrice2;// 单价2
	@ApiModelProperty("范围（0=本公司，1=共享圈，2=全系统，3=好友圈）")
	private Integer bound;// 范围（0=本公司，1=共享圈，2=全系统，3=好友圈）
//	private Integer areaId;// 大区id
//	private Integer regId;// 片区id
    @ApiModelProperty("模块id")
	private Integer regionId;// 模块id
//	private Integer deptId;// 门店id
//	private Integer grId;// 分组id
    @ApiModelProperty("用户id")
	private String publicOrprivateUserId;// 用户id
	@ApiModelProperty("")
	private Integer trackOrder;//
	@ApiModelProperty("楼盘id")
	private String buildIds;// 楼盘id
//	private String buildName;// 楼盘名称
	@ApiModelProperty("楼盘ids")
	private String roadsId;// 楼盘ids
	@ApiModelProperty("片区ID，板块ID")
	private String sectionIds;// 片区ID，板块ID
//	private String cellPhone;// 查询的电话（有此参数会忽略其他状态等条件）
    @ApiModelProperty("环域，DD:HOUSE_ROUND")
	private Integer round;// 环域，DD:HOUSE_ROUND
	@ApiModelProperty("环域，DD:HOUSE_ROUND")
	private Integer type;// 环域，DD:HOUSE_ROUND
	@ApiModelProperty("房源状态")
	private String status;// 房源状态
	@ApiModelProperty("楼盘栋数")
	private String roof;// 楼盘栋数
	@ApiModelProperty("单元号")
	private String unit;// 单元号
	@ApiModelProperty("号、室")
	private String num;// 号、室
	@ApiModelProperty("用途")
	private Integer useage;// 用途
	@ApiModelProperty("房客源编号")
	private String no;// 房客源编号
	@ApiModelProperty("装修情况")
	private String fitment;// 装修情况
	@ApiModelProperty("1=收藏")
	private Integer favorite;// 1=收藏
	@ApiModelProperty("公司编号")
	private String compNo;// 公司编号
	@ApiModelProperty("")
	private Integer shareId;//
	@ApiModelProperty("查询盘别")
	private String plateTypes;// 查询盘别
	@ApiModelProperty("日期范围")
	private Integer date;// 日期范围
//	private Integer modifyPriceTrend;// 调价走势，0=最近调价 1=上涨 2=下降
	@ApiModelProperty("待跟房")
	private Integer needTrackData;// 待跟房
	@ApiModelProperty("待完善")
	private Integer needImproveData;// 待完善
	@ApiModelProperty("楼层：是否是顶层 1=是")
	private Integer isTopFloor;// 楼层：是否是顶层 1=是
	//	private boolean saleExplrth;// 标题筛选字段
	@ApiModelProperty("")
	private Integer map;//
	@ApiModelProperty("")
	private String key;//
	@ApiModelProperty("")
	private String level;//
	//	private Integer plateType; // 盘别，DD：PLATE_TYPE
	@ApiModelProperty("信息来源，DD:HOUSE_SOURCE")
	private Integer source; // 信息来源，DD:HOUSE_SOURCE
	@ApiModelProperty("")
	private String colorFlag; //
	@ApiModelProperty("频数量，Def：0")
	private Integer saleVideo; // 视频数量，Def：0
	//	private String saleDirect;// 朝向
	@ApiModelProperty("")
	private String dataRange;//
	@ApiModelProperty("")
	private String dataRange1;//
	@ApiModelProperty("")
	private String dataRange2;// 
//	private Integer houseRight;// 产权，DD:HOUSE_RIGHT
//	private Integer houseBargain;// 0:未议价1:已议价，DEF:0
//	private Integer panoramaMap;// 查询有720相机的房源
	@ApiModelProperty("// 某个时间段内未跟进、15 = 3天，2 = 7天，16 = 15天")
	private Integer endtimeNoTrack; // 某个时间段内未跟进、15 = 3天，2 = 7天，16 = 15天
	@ApiModelProperty("首页暂缓盘加暂缓时间")
	private Integer zhTrackTime; // 首页暂缓盘加暂缓时间
	@ApiModelProperty("房源新增增加字段")
	private Integer xzCreationTime; // 房源新增增加字段
	@ApiModelProperty("首页增加字段")
	private Integer homePage; // 首页增加字段
	@ApiModelProperty("是否要显示合作房源，0=否 1=是")
	private Integer showCooperate; // 是否要显示合作房源，0=否 1=是
	@ApiModelProperty("如果有此参数，自己的房源排在最前")
	private String selfFirst;// 如果有此参数，自己的房源排在最前
	@ApiModelProperty("楼层状态 1=低层,2=中层, 3=高层, 4=超高层")
	private Integer floorsType; // 楼层状态 1=低层,2=中层, 3=高层, 4=超高层
	@ApiModelProperty("今日抢盘数据 ")
	private Integer todayPublic; // 今日抢盘数据 
	//	private Integer compId; // 公司Id
	@ApiModelProperty("")
	private String orderBy;//
	@ApiModelProperty("")
	private String startTime;//
	@ApiModelProperty("")
	private String endTime;//
	@ApiModelProperty("")
	private String range;//
	@ApiModelProperty("")
	private String queryRange;//
	@ApiModelProperty("")
	private String houseRoof;//
	@ApiModelProperty("")
	private String houseUnit;//
	@ApiModelProperty("")
	private String houseNum;//
	@ApiModelProperty("")
	private String likeHouseRoof;//
	@ApiModelProperty("")
	private String likeHouseUnit;//
	@ApiModelProperty("")
	private String likeHouseNum;//
	@ApiModelProperty("")
	private String saleDirects;//
	@ApiModelProperty("")
	private Date creationTimeStart;//
	@ApiModelProperty("")
	private Date creationTimeEnd;//
	@ApiModelProperty("")
	private Date availableTimeStart;//
	@ApiModelProperty("")
	private Date availableTimeEnd;//
	@ApiModelProperty("")
	private Integer queryRangeId;//
	@ApiModelProperty("")
	private Integer pageNum;
	@ApiModelProperty("")
	private Integer pageSize;
	@ApiModelProperty("宽列表")
	private Integer wideList; // 宽列表
	@ApiModelProperty("")
	private boolean selfCompModel; //
	@ApiModelProperty("")
	private String selfCompNo; //
	@ApiModelProperty("")
	private Integer selfCompId; //
	@ApiModelProperty("")
	private Integer selfArchiveId; //
	@ApiModelProperty("")
	private Integer selfAreaId; //
	@ApiModelProperty("")
	private Integer selfRegId; //
	@ApiModelProperty("")
	private Integer selfDeptId; //
	@ApiModelProperty("")
	private Integer selfGrId; //
	@ApiModelProperty("")
	private Integer selfUserId; //
	@ApiModelProperty("")
	private boolean selfIsYouUser; //
	@ApiModelProperty("")
	private Integer selfCityId; //
	@ApiModelProperty("")
	private Integer selfCompType; //
	@ApiModelProperty("")
	private String selfUserPosition; //
	@ApiModelProperty("")
	private Integer shareCompId;
	@ApiModelProperty("")
	private String statusTemp;
	@ApiModelProperty("")
	private String searchByPhone;
	@ApiModelProperty("")
	private List<Integer> shareCompIds;
	@ApiModelProperty("")
	private List<Integer> inPlateTypes;
	@ApiModelProperty("")
	private List<Integer> inSaleFitments;
	@ApiModelProperty("")
	private List<Integer> inBuildIds;
	@ApiModelProperty("")
	private List<Integer> inRoadIds;
	@ApiModelProperty("")
	private List<Integer> inSectionIds;
	@ApiModelProperty("")
	private List<Integer> insaleDirects;
	@ApiModelProperty("")
	private List<Integer[]> regSectionList;
	@ApiModelProperty("")
	private Integer regSectionCompId;
	@ApiModelProperty("")
	private Integer regSectionAreaId;
	@ApiModelProperty("")
	private Integer regSectionRegId;
	@ApiModelProperty("")
	private Integer regSectionDeptId;
	@ApiModelProperty("")
	private Integer regSectionGrId;
	@ApiModelProperty("")
	private Integer regSectionControllFlag;

	public String getQueryRange() {
		return queryRange;
	}
	public Integer getRegSectionCompId() {
		return regSectionCompId;
	}
	public void setRegSectionCompId(Integer regSectionCompId) {
		this.regSectionCompId = regSectionCompId;
	}
	public Integer getRegSectionAreaId() {
		return regSectionAreaId;
	}
	public void setRegSectionAreaId(Integer regSectionAreaId) {
		this.regSectionAreaId = regSectionAreaId;
	}
	public Integer getRegSectionRegId() {
		return regSectionRegId;
	}
	public void setRegSectionRegId(Integer regSectionRegId) {
		this.regSectionRegId = regSectionRegId;
	}
	public Integer getRegSectionDeptId() {
		return regSectionDeptId;
	}
	public void setRegSectionDeptId(Integer regSectionDeptId) {
		this.regSectionDeptId = regSectionDeptId;
	}
	public Integer getRegSectionGrId() {
		return regSectionGrId;
	}
	public void setRegSectionGrId(Integer regSectionGrId) {
		this.regSectionGrId = regSectionGrId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setQueryRange(String queryRange) {
		this.queryRange = queryRange;
	}
	public Integer getQueryRangeId() {
		return queryRangeId;
	}
	public void setQueryRangeId(Integer queryRangeId) {
		this.queryRangeId = queryRangeId;
	}
	public Integer getRoomNumLow() {
		return roomNumLow;
	}
	public void setRoomNumLow(Integer roomNumLow) {
		this.roomNumLow = roomNumLow;
	}
	public Integer getRoomNumHigh() {
		return roomNumHigh;
	}
	public void setRoomNumHigh(Integer roomNumHigh) {
		this.roomNumHigh = roomNumHigh;
	}
	public Integer getFloor1() {
		return floor1;
	}
	public void setFloor1(Integer floor1) {
		this.floor1 = floor1;
	}
	public Integer getFloor2() {
		return floor2;
	}
	public void setFloor2(Integer floor2) {
		this.floor2 = floor2;
	}
	public BigDecimal getAreaLow() {
		return areaLow;
	}
	public void setAreaLow(BigDecimal areaLow) {
		this.areaLow = areaLow;
	}
	public BigDecimal getAreaHigh() {
		return areaHigh;
	}
	public void setAreaHigh(BigDecimal areaHigh) {
		this.areaHigh = areaHigh;
	}
	public BigDecimal getInnerareaLow() {
		return innerareaLow;
	}
	public void setInnerareaLow(BigDecimal innerareaLow) {
		this.innerareaLow = innerareaLow;
	}
	public BigDecimal getInnerareaHigh() {
		return innerareaHigh;
	}
	public void setInnerareaHigh(BigDecimal innerareaHigh) {
		this.innerareaHigh = innerareaHigh;
	}
	public BigDecimal getTotalPrice1() {
		return totalPrice1;
	}
	public void setTotalPrice1(BigDecimal totalPrice1) {
		this.totalPrice1 = totalPrice1;
	}
	public BigDecimal getTotalPrice2() {
		return totalPrice2;
	}
	public void setTotalPrice2(BigDecimal totalPrice2) {
		this.totalPrice2 = totalPrice2;
	}
	public BigDecimal getUnitPrice1() {
		return unitPrice1;
	}
	public void setUnitPrice1(BigDecimal unitPrice1) {
		this.unitPrice1 = unitPrice1;
	}
	public BigDecimal getUnitPrice2() {
		return unitPrice2;
	}
	public void setUnitPrice2(BigDecimal unitPrice2) {
		this.unitPrice2 = unitPrice2;
	}
	public Integer getBound() {
		return bound;
	}
	public void setBound(Integer bound) {
		this.bound = bound;
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
//	public Integer getTrackTime() {
//		return trackTime;
//	}
//	public void setTrackTime(Integer trackTime) {
//		this.trackTime = trackTime;
//	}
	public String getRoadsId() {
		return roadsId;
	}
	public void setRoadsId(String roadsId) {
		this.roadsId = roadsId;
	}
	public Integer getRound() {
		return round;
	}
	public void setRound(Integer round) {
		this.round = round;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRoof() {
		return roof;
	}
	public void setRoof(String roof) {
		this.roof = roof;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Integer getUseage() {
		return useage;
	}
	public void setUseage(Integer useage) {
		this.useage = useage;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getFitment() {
		return fitment;
	}
	public void setFitment(String fitment) {
		this.fitment = fitment;
	}
	public Integer getFavorite() {
		return favorite;
	}
	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public Integer getShareId() {
		return shareId;
	}
	public void setShareId(Integer shareId) {
		this.shareId = shareId;
	}
	public String getPlateTypes() {
		return plateTypes;
	}
	public void setPlateTypes(String plateTypes) {
		this.plateTypes = plateTypes;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
//	public Integer getModifyPriceTrend() {
//		return modifyPriceTrend;
//	}
//	public void setModifyPriceTrend(Integer modifyPriceTrend) {
//		this.modifyPriceTrend = modifyPriceTrend;
//	}
	public Integer getNeedTrackData() {
		return needTrackData;
	}
	public void setNeedTrackData(Integer needTrackData) {
		this.needTrackData = needTrackData;
	}
	public Integer getNeedImproveData() {
		return needImproveData;
	}
	public void setNeedImproveData(Integer needImproveData) {
		this.needImproveData = needImproveData;
	}
	public Integer getIsTopFloor() {
		return isTopFloor;
	}
	public void setIsTopFloor(Integer isTopFloor) {
		this.isTopFloor = isTopFloor;
	}
	public Integer getMap() {
		return map;
	}
	public void setMap(Integer map) {
		this.map = map;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getColorFlag() {
		return colorFlag;
	}
	public void setColorFlag(String colorFlag) {
		this.colorFlag = colorFlag;
	}
	public Integer getSaleVideo() {
		return saleVideo;
	}
	public void setSaleVideo(Integer saleVideo) {
		this.saleVideo = saleVideo;
	}
	public String getDataRange() {
		return dataRange;
	}
	public void setDataRange(String dataRange) {
		this.dataRange = dataRange;
	}
	public Integer getEndtimeNoTrack() {
		return endtimeNoTrack;
	}
	public void setEndtimeNoTrack(Integer endtimeNoTrack) {
		this.endtimeNoTrack = endtimeNoTrack;
	}
	public Integer getZhTrackTime() {
		return zhTrackTime;
	}
	public void setZhTrackTime(Integer zhTrackTime) {
		this.zhTrackTime = zhTrackTime;
	}
	public Integer getXzCreationTime() {
		return xzCreationTime;
	}
	public void setXzCreationTime(Integer xzCreationTime) {
		this.xzCreationTime = xzCreationTime;
	}
	public Integer getHomePage() {
		return homePage;
	}
	public void setHomePage(Integer homePage) {
		this.homePage = homePage;
	}
	public Integer getShowCooperate() {
		return showCooperate;
	}
	public void setShowCooperate(Integer showCooperate) {
		this.showCooperate = showCooperate;
	}
	public String getSelfFirst() {
		return selfFirst;
	}
	public void setSelfFirst(String selfFirst) {
		this.selfFirst = selfFirst;
	}
	public Integer getFloorsType() {
		return floorsType;
	}
	public void setFloorsType(Integer floorsType) {
		this.floorsType = floorsType;
	}
	public Integer getTodayPublic() {
		return todayPublic;
	}
	public void setTodayPublic(Integer todayPublic) {
		this.todayPublic = todayPublic;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean isSelfCompModel() {
		return selfCompModel;
	}
	public void setSelfCompModel(boolean selfCompModel) {
		this.selfCompModel = selfCompModel;
	}
	public String getSelfCompNo() {
		return selfCompNo;
	}
	public void setSelfCompNo(String selfCompNo) {
		this.selfCompNo = selfCompNo;
	}
	public Integer getSelfCompId() {
		return selfCompId;
	}
	public void setSelfCompId(Integer selfCompId) {
		this.selfCompId = selfCompId;
	}
	public Integer getSelfAreaId() {
		return selfAreaId;
	}
	public void setSelfAreaId(Integer selfAreaId) {
		this.selfAreaId = selfAreaId;
	}
	public Integer getSelfRegId() {
		return selfRegId;
	}
	public void setSelfRegId(Integer selfRegId) {
		this.selfRegId = selfRegId;
	}
	public Integer getSelfDeptId() {
		return selfDeptId;
	}
	public void setSelfDeptId(Integer selfDeptId) {
		this.selfDeptId = selfDeptId;
	}
	public Integer getSelfGrId() {
		return selfGrId;
	}
	public void setSelfGrId(Integer selfGrId) {
		this.selfGrId = selfGrId;
	}
	public Integer getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	public boolean isSelfIsYouUser() {
		return selfIsYouUser;
	}
	public void setSelfIsYouUser(boolean selfIsYouUser) {
		this.selfIsYouUser = selfIsYouUser;
	}
	public Integer getSelfCityId() {
		return selfCityId;
	}
	public void setSelfCityId(Integer selfCityId) {
		this.selfCityId = selfCityId;
	}
	public Integer getSelfCompType() {
		return selfCompType;
	}
	public void setSelfCompType(Integer selfCompType) {
		this.selfCompType = selfCompType;
	}
	public String getSelfUserPosition() {
		return selfUserPosition;
	}
	public void setSelfUserPosition(String selfUserPosition) {
		this.selfUserPosition = selfUserPosition;
	}
	public Integer getShareCompId() {
		return shareCompId;
	}
	public void setShareCompId(Integer shareCompId) {
		this.shareCompId = shareCompId;
	}
	public List<Integer> getShareCompIds() {
		return shareCompIds;
	}
	public void setShareCompIds(List<Integer> shareCompIds) {
		this.shareCompIds = shareCompIds;
	}
	public String getPublicOrprivateUserId() {
		return publicOrprivateUserId;
	}
	public void setPublicOrprivateUserId(String publicOrprivateUserId) {
		this.publicOrprivateUserId = publicOrprivateUserId;
	}
	public Integer getRegSectionControllFlag() {
		return regSectionControllFlag;
	}
	public void setRegSectionControllFlag(Integer regSectionControllFlag) {
		this.regSectionControllFlag = regSectionControllFlag;
	}
	public Integer getTrackOrder() {
		return trackOrder;
	}
	public void setTrackOrder(Integer trackOrder) {
		this.trackOrder = trackOrder;
	}
	public List<Integer> getInPlateTypes() {
		return inPlateTypes;
	}
	public void setInPlateTypes(List<Integer> inPlateTypes) {
		this.inPlateTypes = inPlateTypes;
	}
	public List<Integer> getInSaleFitments() {
		return inSaleFitments;
	}
	public void setInSaleFitments(List<Integer> inSaleFitments) {
		this.inSaleFitments = inSaleFitments;
	}
	public String getBuildIds() {
		return buildIds;
	}
	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}
	public List<Integer> getInBuildIds() {
		return inBuildIds;
	}
	public void setInBuildIds(List<Integer> inBuildIds) {
		this.inBuildIds = inBuildIds;
	}
	public List<Integer> getInRoadIds() {
		return inRoadIds;
	}
	public void setInRoadIds(List<Integer> inRoadIds) {
		this.inRoadIds = inRoadIds;
	}
	public String getSectionIds() {
		return sectionIds;
	}
	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}
	public List<Integer> getInSectionIds() {
		return inSectionIds;
	}
	public void setInSectionIds(List<Integer> inSectionIds) {
		this.inSectionIds = inSectionIds;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getStatusTemp() {
		return statusTemp;
	}
	public void setStatusTemp(String statusTemp) {
		this.statusTemp = statusTemp;
	}
	public String getSearchByPhone() {
		return searchByPhone;
	}
	public void setSearchByPhone(String searchByPhone) {
		this.searchByPhone = searchByPhone;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getHouseRoof() {
		return houseRoof;
	}
	public void setHouseRoof(String houseRoof) {
		this.houseRoof = houseRoof;
	}
	public String getHouseUnit() {
		return houseUnit;
	}
	public void setHouseUnit(String houseUnit) {
		this.houseUnit = houseUnit;
	}
	public String getLikeHouseRoof() {
		return likeHouseRoof;
	}
	public void setLikeHouseRoof(String likeHouseRoof) {
		this.likeHouseRoof = likeHouseRoof;
	}
	public String getLikeHouseUnit() {
		return likeHouseUnit;
	}
	public void setLikeHouseUnit(String likeHouseUnit) {
		this.likeHouseUnit = likeHouseUnit;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getLikeHouseNum() {
		return likeHouseNum;
	}
	public void setLikeHouseNum(String likeHouseNum) {
		this.likeHouseNum = likeHouseNum;
	}
	public String getSaleDirects() {
		return saleDirects;
	}
	public void setSaleDirects(String saleDirects) {
		this.saleDirects = saleDirects;
	}
	public List<Integer> getInsaleDirects() {
		return insaleDirects;
	}
	public void setInsaleDirects(List<Integer> insaleDirects) {
		this.insaleDirects = insaleDirects;
	}
	public Integer getPageNum() {
		return pageNum == null ? 1 : pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize == null ? Const.PAGE_NUMBER : pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getWideList() {
		return wideList;
	}
	public void setWideList(Integer wideList) {
		this.wideList = wideList;
	}
	public Integer getSelfArchiveId() {
		return selfArchiveId;
	}
	public void setSelfArchiveId(Integer selfArchiveId) {
		this.selfArchiveId = selfArchiveId;
	}
	public List<Integer[]> getRegSectionList() {
		return regSectionList;
	}
	public void setRegSectionList(List<Integer[]> regSectionList) {
		this.regSectionList = regSectionList;
	}
	public Date getCreationTimeStart() {
		return creationTimeStart;
	}
	public void setCreationTimeStart(Date creationTimeStart) {
		this.creationTimeStart = creationTimeStart;
	}
	public Date getCreationTimeEnd() {
		return creationTimeEnd;
	}
	public void setCreationTimeEnd(Date creationTimeEnd) {
		this.creationTimeEnd = creationTimeEnd;
	}
	public Date getAvailableTimeStart() {
		return availableTimeStart;
	}
	public void setAvailableTimeStart(Date availableTimeStart) {
		this.availableTimeStart = availableTimeStart;
	}
	public Date getAvailableTimeEnd() {
		return availableTimeEnd;
	}
	public void setAvailableTimeEnd(Date availableTimeEnd) {
		this.availableTimeEnd = availableTimeEnd;
	}
	public String getDataRange1() {
		return dataRange1;
	}
	public void setDataRange1(String dataRange1) {
		this.dataRange1 = dataRange1;
	}
	public String getDataRange2() {
		return dataRange2;
	}
	public void setDataRange2(String dataRange2) {
		this.dataRange2 = dataRange2;
	}
}

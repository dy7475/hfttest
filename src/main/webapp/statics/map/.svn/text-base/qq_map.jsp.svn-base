<%@page import="com.myfun7.web.util.StringUtil"%>
<%@page import="com.sun.xml.internal.ws.util.StringUtils"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"  errorPage="/common/error.jsp" %>
<%@ page import="org.fto.jthink.jdbc.DataObject"%>
<%@ page import="org.fto.jthink.util.XMLHelper"%>
<%@ page import="org.fto.jthink.j2ee.web.util.HTMLHelper"%>
<%@page import="com.myfun7.bean.build.BuildingMapJBean" %>
<%
	BuildingMapJBean buildingMapJBean = new BuildingMapJBean(request);
	String siteRoot = request.getContextPath();
	
	String buildId = buildingMapJBean.getString("BUILD_ID");
	String userNo = buildingMapJBean.getString("USER_NO");
	String chkFlag = buildingMapJBean.getString("CHECK_FLAG");
	String action = buildingMapJBean.getString("ACTION");
	String dsConnId = buildingMapJBean.getString("DS_CONN_ID");
	String cityName = request.getParameter("CITY_NAME");
	String cityPositionX = request.getParameter("CITY_POSITION_X");
	String cityPositionY = request.getParameter("CITY_POSITION_Y");
	
	if(action.equals("save")){
		buildingMapJBean.createPosition(buildId);
	}else if(action.equals("chkerr")){
		buildingMapJBean.createTempPosition(buildId,userNo, "1");
	}
	
	DataObject dataInfoEL = buildingMapJBean.getBuildingInfo(buildId);
	
	String buildName = HTMLHelper.toHTMLString(dataInfoEL.get("BUILD_NAME"));
	String buildAddr = HTMLHelper.toHTMLString(dataInfoEL.get("BUILD_ADDR"));
	String positionX = dataInfoEL.get("POSITION_X"); String positionY = dataInfoEL.get("POSITION_Y");
	Boolean isHavePosition = true;
	if(StringUtil.isEmpty(positionX) || StringUtil.isEmpty(positionY) ){
		DataObject dObj = buildingMapJBean.getCITYInfo();
		positionX = dObj.get("POSITION_X");
		positionY = dObj.get("POSITION_Y");
		isHavePosition = false;
	}
	System.out.println("经度：" + positionX + "，纬度：" + positionY + "--------------");
	String positionFlag = dataInfoEL.get("POSITION_FLAG");
%>
<!DOCTYPE html>
<html>
<HEAD>
    <link href="../../css/button.css" rel="stylesheet" />
	<script type="text/javascript" src="../../map/js/js.js"></script>
	<script type="text/javascript" src="../../map/js/main.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<TITLE>好房通</TITLE>
	
	<style type="text/css">
		BODY {MARGIN: 0px; FONT-FAMILY: Arial,Helvetica,'宋体',sans-serif; BACKGROUND: #fff; COLOR: #333; FONT-SIZE: 12px;overflow: hidden;}
		.inputBtn{
			background-repeat: no-repeat;color:white; right:19px;bottom:13px;
			position: absolute;background-color:transparent;
			border:0px;cursor: pointer;
		}
		#container{width: 100%;height: 100%;}
		.divInfo{
		  position: absolute;
		  width: 124px;height: 24px;
		  z-index: 100;
		  right: 11px;top: 28px;
		  box-shadow: 0 0 6px rgb(174, 174, 174);
		}
		#pano_holder{width: 100%;height: 100%;display:none;}
		.marker{
			  position: absolute;
			  width: 200px;height:auto;
			  background-color: #F7F7F7;
			  border: 1px solid #999999;
			  border-radius: 4px;
			  box-shadow: 2px 4px 6px rgb(166, 166, 166);
  		 }
  		 .marker .leftpart{
  		 	background-image: url('../../map/Images/Directive.png');
  		 	width:12px;height:10px;
  		 	background-repeat: no-repeat;
  		 	position: absolute;
  			bottom: -10px;right: 13px;
  		 }
  		 .marker .rightpart{
  		 	margin: 8px;
  		 }
  		 .marker .rightpart .divTitle{
  		 	font-family: '宋体';font-size: 16px;color: RGB(68,68,68);
  		 	font-weight: bold; margin-bottom: 10px;
  		 	overflow: hidden;white-space: nowrap;text-overflow: ellipsis;
  		 }
  		 .marker .rightpart .divContent{
  		 	font-family: '宋体';font-size: 12px;color: RGB(153,153,153);
  		 }
	</style>
	<script language="javascript" src="../../publicJs/jquery-1.6.4.min.js"></script>
    
	<!-- <script src="http://map.qq.com/api/js?v=3.exp&key=XCHBZ-3ASAI-R63G4-5N3CC-TXVQT-T6BBR"></script> -->
	
	<script language="javascript">
	var marker,markerChange, map, MMID, MOID; var label = null;
	var pano = null; var pano_service = null;var isShow = true;
	var panoLatLng = null; var actionFlag = 0;
	window.POSTION_X = <%=positionX%>; window.POSTION_Y = <%=positionY%>;
	/* document.oncontextmenu = function(){
		var e = window.event || event;
		if(e.srcElement.type != "text" && e.srcElement.type != "textarea")	return false;
	}; */
	document.ontouchstart = null;
	document.ontuchmove = null;
	document.ontouchend = null;
	var InitMap = function() {
		map = new qq.maps.Map(document.getElementById("container"),{
			center: new qq.maps.LatLng(window.POSTION_X, window.POSTION_Y),
			mapTypeControl:false,
			zoom: 20
		});
	
		panoLatLng = new qq.maps.LatLng(window.POSTION_X, window.POSTION_Y);
		// 创建街景
		pano = new qq.maps.Panorama(document.getElementById("pano_holder"),{disableCompass: true});
		pano_service = new qq.maps.PanoramaService();
		
		<% if(isHavePosition == true){ %>
		var anchor = new qq.maps.Point(12, 36),
			size = new qq.maps.Size(29, 36),
	        origin = new qq.maps.Point(0, 0),
	        icon = new qq.maps.MarkerImage("../../map/Images/Location.png", size, origin, anchor);
		marker = new qq.maps.Marker({
			icon: icon,
			map: map,
			animation: qq.maps.MarkerAnimation.DROP,
			position: panoLatLng
		});
		
		var Label=function(opts){
	        qq.maps.Overlay.call(this, opts);
	    };
	
		//继承 Overlay 基类
		Label.prototype = new qq.maps.Overlay();
		Label.prototype.construct = function() {
			this.dom = document.createElement("div");
			this.dom.className = "marker";
			this.dom.innerHTML = "<div class='leftpart'>&nbsp;</div><div class='rightpart'>"
		    		+ "<div class='divTitle' title='<%=buildName%>'><%=buildName%></div><div class='divContent' title='<%=buildAddr%>'><%=buildAddr%></div></div>";
	
			//将 Dom 添加到覆盖物层
			this.getPanes().overlayLayer.appendChild(this.dom);
		};
		//文字绘画（原型对象集成）
		Label.prototype.draw = function() {
		    //获取地理经纬度坐标
		    var position = this.get('position');
			if (position) {
				var pixel = this.getProjection().fromLatLngToDivPixel(position);
				this.dom.style.left = pixel.getX() - 184 + 'px';
				var dsf = $($(this.dom).children()[1]).children(".divContent").text();
				if($(this.dom).height() == 58){
					this.dom.style.top = pixel.getY() - 108 + 'px';//一行
				}else if($(this.dom).height() == 72){
					this.dom.style.top = pixel.getY() - 120 + 'px';//二行
				}else if($(this.dom).height() == 86){
					this.dom.style.top = pixel.getY() - 137 + 'px';//三行
				}
			}
		};
		
		//移除 Dom（原型对象集成）
		Label.prototype.destroy = function() {
			this.dom.parentNode.removeChild(this.dom);
		};
	
		label = new Label({
			map:map,
			position:panoLatLng,
			clickable:true
		});
		
		qq.maps.event.addListener(map, "click", function(){
			if(isShow){
				label.dom.style.display = "none";
				marker.setVisible(true);
				isShow = false;
			}
		});
		
		qq.maps.event.addListener(marker, "click", function(){
			label.dom.style.display = "block";
			isShow = true;
		});
		<%}else{%>
		qq.maps.event.addListener(map, "click", function(e){
			createMarker(e.latLng,true);
			$(".inputBtn").val("保存"); $(".inputBtn").attr("data-static","Save");
		});
		<%}%>
		setTimeout(function(){
			$("#container").children().children()[2].remove();
		},500);
		addScrollEvent(document.getElementById("container"), "mousewheel", function(e)
		{
			stopEvent( e );
			var delta = getWheelValue(e);
			actionFlag++;
			
			if(actionFlag <2){
				if(delta>0){
					map.setZoom(map.getZoom() + 1);
				}else{
					map.setZoom(map.getZoom() - 1);
				}
	           setTimeout(function(){
	               actionFlag = 0;
	           },500);
	      	}
			
			return false;
		});
	}
	
	function createMarker(position,isCenter){
		if(markerChange){
			markerChange.setPosition(position);
			markerChange.setVisible(true); markerChange.label.setVisible(true);
			return;
		}else{
			var anchor = new qq.maps.Point(12, 36),
				size = new qq.maps.Size(29, 36),
				origin=new qq.maps.Point(0,0),
				icon = new qq.maps.MarkerImage('../../map/Images/ModifyLocation.png', size, origin, anchor);
			markerChange=new qq.maps.Marker({
				map: map,
				icon: icon,
				
				position: position,
				draggable:true
			});
			markerChange.label=new qq.maps.Label({
				map: map,
				content: "拖动我修改位置"
		    });
			PCID=qq.maps.event.addListener(markerChange,"position_changed",function(){
				markerAndLabel(this);
			});
			ZCID=qq.maps.event.addListener(map,"zoomlevel_changed",function(){
				markerAndLabel(this);
			});
		}
		if(isCenter){
			map.setCenter(position);
			map.setZoom(20);
		};
		markerAndLabel(markerChange);
	};
	
	function markerAndLabel(marker){
		var point=map.get('mapCanvasProjection').fromLatLngToContainerPixel(marker.getPosition());
		var pointN=new qq.maps.Point(point.getX()+15,point.getY()-40);			
		marker.label.setPosition(map.get('mapCanvasProjection').fromContainerPixelToLatLng(pointN));
		window.POSTION_X = marker.getPosition().getLat();
		window.POSTION_Y = marker.getPosition().getLng();
	};

	function MapCorrection(obj){
		if($(obj).attr("data-static") == "Correction"){
			if (label != null){
				label.setMap(null); marker.setVisible(false);
			}
			createMarker(panoLatLng,true);
			$(obj).val("保存"); $(obj).attr("data-static","Save");
		}else if($(obj).attr("data-static") == "Save"){
			if (document.getElementById("CCustObj").openMessageBox("你确定要保存，当前坐标吗？",5,2) == 1){
				/****************在这儿写代码******************/
				$.ajax({
		            url: "../building/recoveryBuildingInfoMap",
		            type: "POST",
		            data:{
		            	BUILD_ID: <%=buildId%>,
		            	POSITION_X: markerChange.position.getLat(),
		            	POSITION_Y: markerChange.position.getLng(),
		            	mtyefmupn: new Date().getMilliseconds() + Math.random()
		            },
		            dataType: "text",
		            success: function (response, text_status, xhr) {
		            	document.getElementById("CCustObj").openMessageBox("恭喜你，地图纠错成功。",4,1);
		            	$(obj).css("display","none");
						markerChange.setVisible(false);markerChange.label.setVisible(false);
						panoLatLng.lat = response.split("||")[0]; panoLatLng.lng = response.split("||")[1];
						qq.maps.event.clearListeners(map,"click");
						$(obj).val("地图标记"); $(obj).attr("data-static","Correction");
						
						/*---------------------改为正常标记---------------------*/
						var anchor = new qq.maps.Point(12, 36),
							size = new qq.maps.Size(29, 36),
					        origin = new qq.maps.Point(0, 0),
					        icon = new qq.maps.MarkerImage("../../map/Images/Location.png", size, origin, anchor);
						marker = new qq.maps.Marker({
							icon: icon,
							map: map,
							animation: qq.maps.MarkerAnimation.DROP,
							position: panoLatLng
						});
						
						var Label=function(opts){
					        qq.maps.Overlay.call(this, opts);
					    };
					
						//继承 Overlay 基类
						Label.prototype = new qq.maps.Overlay();
						Label.prototype.construct = function() {
							this.dom = document.createElement("div");
							this.dom.className = "marker";
							this.dom.innerHTML = "<div class='leftpart'>&nbsp;</div><div class='rightpart'>"
						    		+ "<div class='divTitle' title='<%=buildName%>'><%=buildName%></div><div class='divContent' title='<%=buildAddr%>'><%=buildAddr%></div></div>";
					
							//将 Dom 添加到覆盖物层
							this.getPanes().overlayLayer.appendChild(this.dom);
						};
						//文字绘画（原型对象集成）
						Label.prototype.draw = function() {
						    //获取地理经纬度坐标
						    var position = this.get('position');
							if (position) {
								var pixel = this.getProjection().fromLatLngToDivPixel(position);
								this.dom.style.left = pixel.getX() - 184 + 'px';
								var dsf = $($(this.dom).children()[1]).children(".divContent").text();
								if($(this.dom).height() == 58){
									this.dom.style.top = pixel.getY() - 108 + 'px';//一行
								}else if($(this.dom).height() == 72){
									this.dom.style.top = pixel.getY() - 120 + 'px';//二行
								}else if($(this.dom).height() == 86){
									this.dom.style.top = pixel.getY() - 137 + 'px';//三行
								}
							}
						};
						
						//移除 Dom（原型对象集成）
						Label.prototype.destroy = function() {
							this.dom.parentNode.removeChild(this.dom);
						};
					
						label = new Label({
							map:map,
							position:panoLatLng,
							clickable:true
						});
						
						qq.maps.event.addListener(map, "click", function(){
							if($(".inputBtn").attr("data-static") == "Correction"){
								if(isShow){
									label.dom.style.display = "none";
									marker.setVisible(true);
									isShow = false;
								}
							}
						});
						
						qq.maps.event.addListener(marker, "click", function(){
							label.dom.style.display = "block";
							isShow = true;
						});
		            },
		            error: function (respose, obj) {
		            	document.getElementById("CCustObj").openMessageBox("对不起，保存数据失败。",2,1);
		            }
				});
				
			}
		}
	}
	function showJJ(){
		$("#container").css("display","none");$("#pano_holder").css("display","block");$(".inputBtn").css("display","none");
		$("#jjDiv").css("backgroundColor","#259CF3"); $("#jjDiv").css("color","#FFFFFF");
		$("#wxDiv").css("backgroundColor","#fff"); $("#wxDiv").css("color","black");
		$("#dtDiv").css("backgroundColor","#fff"); $("#dtDiv").css("color","black");
		$(".divInfo").css("boxShadow","0 0 6px rgb(90, 90, 90)");
		var tempPanoLatLng = null
		if (markerChange == undefined){
			tempPanoLatLng = panoLatLng;
		}else if (markerChange != undefined){
			tempPanoLatLng = panoLatLng;
			tempPanoLatLng.lat = markerChange.position.getLat();
			tempPanoLatLng.lng = markerChange.position.getLng();
		}
		pano_service.getPano(tempPanoLatLng, 200, function(result){
	        pano.setPano(result.svid);
	        var x1 = result.latlng.lng;
	        var y1 = result.latlng.lat;
	        var x2 = marker.position.getLat();var y2 = marker.position.getLng();
	        if (markerChange != undefined){
	        	x2 = markerChange.position.getLat();
		        y2 = markerChange.position.getLng();
	        }

	        var alpha = Math.acos((y2 - y1) / Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
			if (x2 - x1 < 0) {
				alpha = Math.PI * 2 - alpha;
			}
			pano.setPov({heading : alpha/Math.PI*180, pitch : 0});
			setInterval(function(){
				$("#pano_holder").children().children()[2].remove();
			},500);
	    });
	}
	function showDT(){
		$("#container").css("display","block");$("#pano_holder").css("display","none");$(".inputBtn").css("display","block");
		$("#dtDiv").css("backgroundColor","#259CF3"); $("#dtDiv").css("color","#FFFFFF");
		$("#jjDiv").css("backgroundColor","#fff"); $("#jjDiv").css("color","black");
		$("#wxDiv").css("backgroundColor","#fff"); $("#wxDiv").css("color","black");
		$(".marker").css("boxShadow","2px 4px 6px rgb(166, 166, 166)");
		$(".divInfo").css("boxShadow","0 0 6px rgb(174, 174, 174)");
		map.setMapTypeId(qq.maps.MapTypeId.ROADMAP);
	}
	function showWX(){
		$("#container").css("display","block");$("#pano_holder").css("display","none");$(".inputBtn").css("display","block");
		$("#wxDiv").css("backgroundColor","#259CF3"); $("#wxDiv").css("color","#FFFFFF");
		$("#jjDiv").css("backgroundColor","#fff"); $("#jjDiv").css("color","black");
		$("#dtDiv").css("backgroundColor","#fff"); $("#dtDiv").css("color","black");
		$(".marker").css("boxShadow","2px 4px 6px rgb(61, 61, 61)");
		$(".divInfo").css("boxShadow","0 0 6px rgb(90, 90, 90)");
		map.setMapTypeId(qq.maps.MapTypeId.HYBRID);
	}
	function addScrollEvent(obj,type,fn) { 
		var isFirefox = typeof document.body.style.webkitUserSelect != 'undefined'; 
		if( obj.addEventListener ) 
			obj.addEventListener( isFirefox ? 'DOMMouseScroll' : type,fn,false ); 
		else 
			obj.attachEvent( 'on'+type,fn ); 
		return fn; 
	} 
	
	function stopEvent(e) 
	{ 
		e = e||event; 
		if( e.preventDefault )e.preventDefault(); 
		e.returnValue = false; 
	}
	//取得滚动值 
	function getWheelValue( e ) 
	{ 
		e = e||event;
		return (e.wheelDelta ? e.wheelDelta/120 : -(e.detail%3 == 0 ? e.detail/3 : e.detail));
	} 
	</script>
	</HEAD>
	<body style="background: #EAF0FE" onload="InitMap()" scroll="no"  onselectstart ="return false" onselect="document.selection.empty()" oncopy="document.selection.empty()" onbeforecopy="return false">
		<div class="divInfo" id="divInfo">
			<div onclick="showJJ()" style="width:40px;height:22px;line-height:22px;text-align:center;cursor:pointer;left:0px;position:absolute;z-index:100;border:1px solid #8F8E8E;background-color:#fff;" id="jjDiv">街景</div>
			<div onclick="showDT()" style="width:40px;height:22px;line-height:22px;text-align:center;cursor:pointer;left:41px;position:absolute;z-index:100;border:1px solid #8F8E8E;background-color:#259CF3;color:#FFFFFF;" id="dtDiv">地图</div>
			<div onclick="showWX()" style="width:40px;height:22px;line-height:22px;text-align:center;cursor:pointer;left:82px;position:absolute;z-index:100;border:1px solid #8F8E8E;background-color:#fff;" id="wxDiv">卫星</div>
		</div>
		<div id="container" style="position: absolute;"></div>
		<div id="pano_holder" style="position: absolute;"></div>
		<!-- <input type="button" class="inputBtn" value="地图纠错" onclick="MapCorrection(this)" data-static="Correction" style="display: none;"> -->
		<% if(isHavePosition == false){ %>
		<input type="button" class="inputBtn bt-green" value="地图标记" onclick="MapCorrection(this)" data-static="Correction">
		<%} %>
		<object type='application/x-qt-plugin' classid='custObj' id='CCustObj' style="height:0px;width:0px;display:block;" ></object>
	</body>
</html>
/*****************************选择框弹出层控制 divsetter***************************/

function chgTimeZone(selectedStatus){
   if(selectedStatus == "DEAL" || selectedStatus == "INNERDEAL" 
  			|| selectedStatus == "SCHEDULE" || selectedStatus == "7"){
		document.getElementById("CREATION_TIME_TEXT").value = "按跟进先后";
	    document.getElementById("CREATION_TIME1").value = "";
	    document.getElementById("CREATION_TIME2").value = "";
	    document.getElementById("TRACK_ORDER").value = "1"; 
	 }else{
		 document.getElementById("CREATION_TIME_TEXT").value = defaultDateShow;
	    document.getElementById("CREATION_TIME1").value = defaultDateStart;
	    document.getElementById("CREATION_TIME2").value = defaultDateEnd;
	    document.getElementById("TRACK_ORDER").value = "";
	 }
}

//用于多选
function selectValue1(displayName, valueName, selectObj){
	if(!selectObj.checked){
		escapceValue1(displayName, valueName, selectObj);
		return;
	}
	if($(displayName).value == ""){
		ocument.getElementById(displayName).value += (" " + selectObj.getAttribute("displayText") + " ");
	}else{
		ocument.getElementById(displayName).value += (selectObj.getAttribute("displayText") + " ");
	}
	if(ocument.getElementById(valueName).value == ""){
		ocument.getElementById(valueName).value += (" " + selectObj.value + " ");
	}else{
		ocument.getElementById(valueName).value += (selectObj.value + " ");
	}
}

function escapceValue1(displayName, valueName, selectObj){
	var replaceText = " " + selectObj.getAttribute("displayText") + " ";
	var rgExpText = window.eval("/" + replaceText + "/g");
	ocument.getElementById(displayName).value = ocument.getElementById(displayName).value.replace(rgExpText, " ");

	var replaceValue = " " + selectObj.value + " ";
	var rgExpValue = window.eval("/" + replaceValue + "/g");
	ocument.getElementById(valueName).value = ocument.getElementById(valueName).value.replace(rgExpValue, " ");
}

//用户手选
function setValue(isColse, displayName, name1, name2, value1, value2, callBackFun){
	if($.trim(value1) == "" && $.trim(value2) == ""){
		document.getElementById(displayName).value = "";
	}else{
		document.getElementById(displayName).value = value1 + "-" + value2;
	}

	if(!isColse){
		document.getElementById("TEMP1").value = value1;
		document.getElementById("TEMP2").value = value2;
	}else{
		closeed('fd1');
	}
	document.getElementById(name1).value = document.getElementById("TEMP1").value;
	document.getElementById(name2).value = document.getElementById("TEMP2").value;
}

function selectBuild(obj){
	if(!obj.checked){
		escapceBuild(obj);
		return;
	}
	var value = obj.value;
	var text = obj.getAttribute("text");
	if(document.getElementById("BUILD_ID").value == ""){
		document.getElementById("BUILD_ID").value += (" " + value + " ");

		document.getElementById("BUILD_ID_TEXT").value = "";
		document.getElementById("BUILD_NAME").value = "";
	}else{
		document.getElementById("BUILD_ID").value += (value + " ");
	}
	if(document.getElementById("BUILD_ID_TEXT").value == ""){
		document.getElementById("BUILD_ID_TEXT").value += (" " + text + " ");
	}else{
		document.getElementById("BUILD_ID_TEXT").value += (text + " ");
	}
}

function escapceBuild(obj){
	var value = obj.value;
	var text = obj.getAttribute("text");
	var replaceStr = " " + value + " ";
	var rgExpStr = window.eval("/" + replaceStr + "/g");
	document.getElementById("BUILD_ID").value = document.getElementById("BUILD_ID").value.replace(rgExpStr, " ");
	
	replaceStr = " " + text + " ";
	rgExpStr = window.eval("/" + replaceStr + "/g");
	document.getElementById("BUILD_ID_TEXT").value = document.getElementById("BUILD_ID_TEXT").value.replace(rgExpStr, " ");
}

function clearBuild(displayName, name, selectObj){
	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
    if(name != ""){
	  document.getElementById(name).value = selectObj.value;
    }
	document.getElementById("BUILD_NAME").value = "";
	var objs = document.getElementsByName(selectObj.name);
	for(var i=0; i<objs.length; i++){
		objs[i].checked = objs[i].checked && 0;
	}
}

function handSelect(){
	var hasCheck = false;
	var objss = document.getElementsByName("MATCH_BUILDcheckbox");
	for(var i=0; i<objss.length; i++){
		if(objss[i].checked){
			hasCheck = true;
			break;
		}
	}
	if(!hasCheck && document.getElementById("BUILD_CODE").value != "请输入楼盘拼音或名字"){
		document.getElementById("BUILD_ID").value = "";
		document.getElementById("BUILD_NAME").value = document.getElementById("BUILD_CODE").value;
		document.getElementById("BUILD_ID_TEXT").value = document.getElementById("BUILD_CODE").value;
	}
	closeed("fd2");
}

function selectDept(selectObj){
	document.getElementById("BOUND").value = "0";
	document.getElementById("BOUND_TEXT").value = selectObj.getAttribute("displayText");
	document.getElementById("DEPT_ID").value = selectObj.value;
	document.getElementById("USER_ID").value = "";
	document.getElementById("USER_ID_TEXT").value = "";
	try{
		getTiptopWindow().COND_BOUND = "0";
		getTiptopWindow().COND_DEPT_ID = selectObj.value;
		getTiptopWindow().COND_BOUND_TEXT = selectObj.getAttribute("displayText");
		getTiptopWindow().COND_USER_ID = "";
		getTiptopWindow().COND_USER_ID_TEXT = "";
	}catch(e){}
    chgButAbl(selectObj);
	try{
		closeed('fd1');
		closeed("fd2");
	}catch(e){}
	query('');
}

function selectBound(displayName, name1, name2, selectObj){
	if(displayName == "BOUND_TEXT" && selectObj.value != "0"){
		document.getElementById("USER_ID").value = "";
		document.getElementById("USER_ID_TEXT").value = "";
		try{
			document.getElementById("SALE_STATUS").value = "AVAILABLE";
			document.getElementById("SALE_STATUS_TEXT").value = "有效";
		}catch(e){
			document.getElementById("LEASE_STATUS").value = "AVAILABLE";
			document.getElementById("LEASE_STATUS_TEXT").value = "有效";
		}
		if(document.getElementById("TRACK_ORDER").value == "1"){
			document.getElementById("TRACK_ORDER").value = "";
			document.getElementById("CREATION_TIME_TEXT").value = "全部";
		}
	}
	document.getElementById("COMP_IDS").value = "";
	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
	if(name1 != ""){
		document.getElementById(name1).value = 	selectObj.value;
    }
    if(name2 != ""){
	    document.getElementById(name2).value = 	selectObj.getAttribute("value2");
    }
    chgButAbl();
	try{
		closeed('fd1');
		closeed("fd2");
	}catch(e){}
	query('');
}

function selectShareBound(displayName, name1, compIds, selectObj){
	document.getElementById("USER_ID").value = "";
	document.getElementById("USER_ID_TEXT").value = "";
	try{
		document.getElementById("SALE_STATUS").value = "AVAILABLE";
		document.getElementById("SALE_STATUS_TEXT").value = "有效";
	}catch(e){
		document.getElementById("LEASE_STATUS").value = "AVAILABLE";
		document.getElementById("LEASE_STATUS_TEXT").value = "有效";
	}
	if(document.getElementById("TRACK_ORDER").value == "1"){
		document.getElementById("TRACK_ORDER").value = "";
		document.getElementById("CREATION_TIME_TEXT").value = "全部";
	}
	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
	document.getElementById("COMP_IDS").value = compIds;
	if(name1 != ""){
		document.getElementById(name1).value = 	selectObj.value;
  	}
    chgButAbl();
	try{
		closeed('fd1');
		closeed("fd2");
	}catch(e){}
	query('');
}

function selectBound1(displayName, name, selectObj){
	if(displayName == "BOUND_TEXT" && selectObj.value != "0"){
		document.getElementById("FRIEND_ARCHIVE_ID").value = "";
		document.getElementById("FRIEND_ARCHIVE_ID_TEXT").value = "";
		try{
			document.getElementById("SALE_STATUS").value = "1";
			document.getElementById("SALE_STATUS_TEXT").value = "有效";
		}catch(e){
			document.getElementById("LEASE_STATUS").value = "1";
			document.getElementById("LEASE_STATUS_TEXT").value = "有效";
		}
		if(document.getElementById("TRACK_ORDER").value == "1"){
			document.getElementById("TRACK_ORDER").value = "";
			document.getElementById("CREATION_TIME_TEXT").value = "全部";
		}
	}

	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
	document.getElementById(name).value = selectObj.value;
	closeed('fd1');
	query("");
}

function selectUser(displayName, name, selectObj){
	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
    if(name != ""){
	  document.getElementById(name).value = selectObj.value;
    }
	try{
		getTiptopWindow().COND_USER_ID = selectObj.value;
		getTiptopWindow().COND_USER_ID_TEXT = selectObj.getAttribute("displayText");
	}catch(e){}
	closeed('fd1');
	query('');
}

function selectReg(obj){
	try{
		document.getElementById("SALE_REGION").value = obj.value;
		document.getElementById("REGION_SECTION_TEXT").value = obj.getAttribute("text");
	}catch(e){
		try{
			document.getElementById("LEASE_REGION").value = obj.value;
			document.getElementById("REGION_SECTION_TEXT").value = obj.getAttribute("text");
		}catch(e){
			try{
				document.getElementById("HOUSE_REGION").value = obj.value;
				document.getElementById("REGION_SECTION_TEXT").value = obj.getAttribute("text");
			}catch(e){
				document.getElementById("REGION").value = obj.value;
				document.getElementById("REGION_TEXT").value = obj.getAttribute("text");
			}
		}
	}
	try{
		closeed('fd1');
	}catch(e){}
	try{
		closeed('fd2');
	}catch(e){}
}

function cleanReg(selectObj){
	try{
		document.getElementById("SALE_REGION").value = "";
	    document.getElementById("SALE_SECTORS").value = "";
	    document.getElementById("REGION_SECTION_TEXT").value = "全部";
	}catch(e){
		try{
			document.getElementById("LEASE_REGION").value = "";
	    	document.getElementById("LEASE_REGION").value = "";
	    	document.getElementById("REGION_SECTION_TEXT").value = "全部";
	    }catch(e){
	    	try{
	    		 document.getElementById("HOUSE_REGION").value = "";
   				 document.getElementById("SECTION_ID").value = "";
    			 document.getElementById("REGION_SECTION_TEXT").value = "全部";
	    	}catch(e){
	    		document.getElementById("REGION").value = "";
   		   	    document.getElementById("REGION_TEXT").value = "全部";
   		    }
	    }
	}
    try{
		closeed('fd1');
	}catch(e){}
	try{
		closeed('fd2');
	}catch(e){}
}

function selectSectionValue(displayName, valueName, selectObj){
	if(" " +document.getElementById(valueName).value.indexOf(selectObj.value)+" "==-1){
		document.getElementById(displayName).value += " " + selectObj.getAttribute("displayText")+" ";
		document.getElementById(valueName).value += " " + selectObj.value+" ";
		selectObj.checked = true;
	}else{
		document.getElementById(displayName).value = document.getElementById(displayName).value.replace(" "+selectObj.getAttribute("displayText")+" ","");
		document.getElementById(valueName).value = document.getElementById(valueName).value.replace(" "+selectObj.value+" ","");
		selectObj.checked = false;
	}
}

function trackOrder(displayName, name1, name2, selectObj){
	document.getElementById(displayName).value = selectObj.getAttribute("displayText");
    document.getElementById(name1).value = 	selectObj.value;
    document.getElementById(name2).value = 	selectObj.getAttribute("value2");
    document.getElementById("TRACK_ORDER").value = "1"; 
	closeed('fd1');
	query("");
}

/*****************************选择框弹出层控制***************************/

function myFriend(obj){
	OpenDiv(count,"my_friend.jsp?mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),'236','470',220-document.body.clientWidth);
}

function searchFriend(){
	lightbox.init();
	lightbox.showUrl("search_friend_show.jsp?mtyefmupn"+new Date().getMilliseconds()+"="+Math.random(),"",650,350,function(){});
}


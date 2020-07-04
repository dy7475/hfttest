/**
 * 用户积分的展示
 * 调用方式：
 * 	showGrade("gradeCont",3010,1);
 * 	第一个参数：积分图标显示的html标签ID
 * 	第二个参数：用户的积分
 * 	第三个参数：是否显示tips
 */
var relativePathForScore = getRelativePath();
var scoreStartArr = new Array(0,3000,7000,12000,18000,25000);
var scoreStepArr = new Array(600,800,1000,1200,1400);
var starWidth = 16;
var diamondWidth = 16;
var greyItemHeight = 16;
function showGrade(htmlId,score,showTitleFlag){
	if(score<scoreStartArr[5]){
		var gradeInfo = getGradeInfo(score);//document.write("<br/>"+gradeInfo);
		
		var backEL = createEl("span");
		backEL.className = "star_back";
		backEL.style.cssText = "background-position: 0 -"+greyItemHeight*gradeInfo[4]+"px;";
		backEL.style.width = gradeInfo[1]+"px";
		var frontEL = createEl("span");
		frontEL.className = "star_front";
		frontEL.style.cssText = "background: url("+relativePathForScore+"grade"+gradeInfo[4]+".gif) repeat";
		frontEL.style.width = gradeInfo[2]+"px";
		backEL.appendChild(frontEL);
		
		document.getElementById(htmlId).cssText = "height:14px;line-height:14px;overflow:hidden;";
		document.getElementById(htmlId).appendChild(backEL);
		if(showTitleFlag){//判断title的显示标记			document.getElementById(htmlId).title = "您目前的积分为："+score+";距离下一次升级还差:"+gradeInfo[3];
		}
	}else{
		document.getElementById(htmlId).innerHTML = "<font style=\"font-size:12px;color:red;\">终身荣誉会员</font>";
	}
}
function getGradeInfo(score){
	/*
	 *说明：第一个值为：钻石显示的宽度，第二个值为：背景宽度，
	 *     第三个值为：前景宽度，第四个值为：距离下一次升级还差分数
	 *     第五个值为：积分所处的阶段
	 */
	var arrayObj = new Array(5);
	if(score==0){
		arrayObj=[0,16,3,scoreStepArr[0],0];
		return arrayObj;
	}
	for(i=0;i<scoreStartArr.length-1;i++){
		if(score>=scoreStartArr[i] && score<scoreStartArr[i+1]){
			arrayObj[0] = i * diamondWidth;
			otherScore = score - scoreStartArr[i];//不足一个钻的分数
			starNum = otherScore/scoreStepArr[i];//计算有多少星
			isInt = Math.floor(starNum)*scoreStepArr[i]==otherScore;
			if(otherScore==0 || isInt){
				arrayObj[1] = starNum*starWidth;
			}else{
				arrayObj[1] = Math.ceil(starNum)*starWidth;//先向上取整，再计算背景的宽度
			}
			//处理不足一个星的分数所占步长的比例很小时，显示上看起来只有背景的问题。
			var temp = starNum;
			if((starNum!=0)&&!isInt){
				if((Math.ceil(starNum)-starNum<0.1)){
					temp -= 0.2;
				}else if((starNum-Math.floor(starNum)<0.1)){
					temp += 0.2;
				}
			}
			arrayObj[2] = Math.round(temp*starWidth);//先计算实际宽度，再四舍五入到整数（为前景宽度）
			if(otherScore == 0){
				arrayObj[3] = scoreStepArr[i];
			}else{
				var t = (isInt)?starNum+1:Math.ceil(starNum);
				arrayObj[3] = (t*scoreStepArr[i] - otherScore);//距离下一次升级还差分数			}
			arrayObj[4] = i;
			return arrayObj;
		}
	}
}
function createEl(name){
	return document.createElement(name);
}
function loadjscssfile(filename, filetype) {
	var fileref;
    if (filetype == "js") {
        fileref = document.createElement('script');
        fileref.setAttribute("type", "text/javascript");
        fileref.setAttribute("src", filename)
    } else if (filetype == "css") {
        fileref = document.createElement("link");
        fileref.setAttribute("rel", "stylesheet");
        fileref.setAttribute("type", "text/css");
        fileref.setAttribute("href", filename)
    }
    if (typeof fileref != "undefined") document.getElementsByTagName("head")[0].appendChild(fileref);
}
function getRelativePath(){
	var elements = document.getElementsByTagName('script');
	for (var i = 0, len = elements.length; i < len; i++) {
		if (elements[i].src && elements[i].src.match(/score[\w\-\.]*\.js/)) {
			return elements[i].src.substring(0, elements[i].src.lastIndexOf('/') + 1);
		}
	}
	return "";	
}
loadjscssfile(relativePathForScore+"score.css","css"); 		//加载css样式
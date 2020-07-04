<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
   <!--  <title>Bootstrap 101 Template</title> -->

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">

		<%--var erpWebUrl = "${pageContext.request.getScheme()}://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.getContextPath()}"--%>
		    <%--var erpWebUrl = '${erpWeb.url}';--%>
		    // var erpWebUrl = 'http://192.168.200.169:8081/erpWeb/';
		    var adminWebUrl = '${adminWebUrl}';
		    var crmWebUrl = '${crmWebUrl}';
		    var statics = '${statics}';
		    var paramData = '${paramData}';
	 </script>
  </head>
  <body style="padding: 15px;">
 	<div class="page-header">
	  <h3>你正在签署电子委托合同</h3>
	  <p>请确认个人信息</p>
	</div>
	<form>
	  <input type="hidden" id="contractId" value="${id}">
	  <input type="hidden" id="cityId" value="${cityId}">
	  <input type="hidden" id="ownerId" value="${ownerId}">
	  <div class="form-group">
	    <label for="name">姓名</label>
	    <input type="text" class="form-control" id="name"  value="${entrustOwners.ownerName}" disabled="disabled">
	  </div>
	  <div class="form-group">
	    <label for="identity">证件号</label>
	    <input type="text" class="form-control" id="identity" value="${entrustOwners.cardNo}" disabled="disabled">
	  </div>
	   <div class="form-group">
	    <label for="mobile">手机</label>
	    <input type="text" class="form-control" id="mobile" value="${entrustOwners.ownerPhone}" disabled="disabled">
	  </div>
	  <b/>
  	  <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal" data-target="#myModal">确认</button>
	</form>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						实名认证
					</h4>
				</div>
				<form id="vcodeform" >
					<div class="modal-body">
						<div class="form-group">
							<div class="row">
						   	  <div class="col-xs-9 col-sm-6"><label for="vcode">验证码</label></div>
						    </div>
						    <div class="row">
						   	 <div class="col-xs-8 col-sm-6"><input type="text" class="form-control" id="vcode" name="vcode" ></div><!-- 获得验证码 -->
						   	 <div class="col-xs-4 col-sm-2" style="padding-left: 0px;"><button id="getvcodebtn" class="btn btn-default" type="button"  onclick="getvcode()">获取验证码</button></div>
						   	</div>
						    <input type="text" class="form-control hidden" id="personalIdentity3Key" name="personalIdentity3Key">
						 </div>
					</div>
				</form>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button> -->
					<button type="button" class="btn btn-primary" onclick="getcheckvcode()">
						确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
	
	
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    
    $(document).on('ready', function() {
    	
    });
    
    
    function getvcode()  {
       $('#getvcodebtn').attr("disabled","disabled");
	   $.ajax({
           type : "POST",
       	   url:  "${erpWebUrl}/openApi/mlEntrustApi/getIdentity3Vcode",
       	   data : {"contractId": $("#contractId").val(),"cityId": $("#cityId").val(),"ownerId": $("#ownerId").val()},
       	   dataType: "json",
           //数据，json字符串
           //data : JSON.stringify(list),
           //请求成功
           success : function(result) {
          	   //regcheck(result.account,result.taskId);
          	   if(result.errCode=="200"){
          		   $("#personalIdentity3Key").val(result.data);
          		   getRandomCode();
          	   }else{
	          	   $('#getvcodebtn').removeAttr("disabled");
          		   alert(result.errMsg);
          	   }
               console.log(result);
           },
           //请求失败，包含具体的错误信息
           error : function(e){
        	   $('#getvcodebtn').removeAttr("disabled");
               console.log(e.status);
               console.log(e.responseText);
           }
       });
    }
    
    
    var time = 60;
	//倒计时
	function getRandomCode() {
	   $('#getvcodebtn').attr("disabled","disabled")
	   if (time === 0) { 
		   $('#getvcodebtn').text("获取验证码");
	       $('#getvcodebtn').removeAttr("disabled")
	       time = 60;
	       return;
	   } else { 
	       time--;
	       $('#getvcodebtn').text(tmp="剩余"+time+"s");
	   } 
	   setTimeout(function() { 
	       getRandomCode();
	   },1000);
	}
    
    function getcheckvcode()  {
		if($("#personalIdentity3Key").val() == "" || $.trim($("#personalIdentity3Key").val()).length == 0){
			alert("请先获取验证码！");
			return;
		}
 	   $.ajax({
            type : "POST",
        	   url: "${erpWebUrl}/openApi/mlEntrustApi/identity3VcodeCheck", 
        	   data : {"contractId":$("#contractId").val(),"cityId":$("#cityId").val(),"ownerId": $("#ownerId").val(),"vcode":$("#vcode").val(),"personalIdentity3Key":$("#personalIdentity3Key").val()},
        	   dataType: "json",
            //数据，json字符串
            //data : JSON.stringify(list),
            //请求成功
            success : function(result) {
           	   //regcheck(result.account,result.taskId);
           	   if(result.errCode=="200"){
           		   $('#vcodeform').attr("action",result.data);
           		   $('#vcodeform').submit();
           	   }else{
           		   alert("验证码错误！");
           	   }
                console.log(result);
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                console.log(e.status);
                console.log(e.responseText);
            }
        });
     }
    </script>
    
</body>
</html>

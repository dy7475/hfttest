

$(function () {
    var date = new Date();
    var endYear = date.getFullYear();
  // 出生日期初始化
  new Jdate({
    el: '#date-group1-2',
    format: 'YYYY-MM-DD',
    beginYear: 1900,
    endYear: endYear
  })

  var names = {
      userOfficeph:"请输入备用电话",
      emergencyContact:"请输入紧急联系人",
      userFixedph:"请输入紧急电话",
      userAddress:"请输入家庭地址",
      userBirthday:"请输入出生日期",
      userIccode:"请输入身份证号",
      nation:"请输入民族",
      maritalStatus:"请输入婚姻",
      placeOfOrigin:"请输入籍贯",
      userSchlrecord:"请输入学历",
      userField:"请输入专业",
      workYear:"请输入房地产工作年限",
      userIccodeUrl:"请上传身份证",
      educationUrl:"请上传学历证书"

  }
  // 提交数据
  $(".g-foot-btn").on('click',function(e){
    var formobj =  $("#g-form").serializeArray();    //用 jquery获取form表单dom
    // var obj = {};
    var obj = JSON.parse(paramData);
    for(var i = 0; i < formobj.length; i++){
      if(formobj[i].value == ""){
            messageBox(names[formobj[i].name]);
            return;
        }
      // obj[formobj[i].name] = formobj[i].value;
        obj[formobj[i].name] = formobj[i].value;
    }
      $.ajax({
          url: erpWebUrl + '../../openApi/inviteRegist/finalSaveFjdUser',
          type: "POST",
          // headers: {"Content-Type": "application/json;charset=utf-8"},
          dataType: "json",
          timeout :50000,
          beforeSend:function() {
              $("#loadDiv").show();
              $(".g-foot-btn").css("background","#999999");
          },
          complete:function() {
              $(".g-foot-btn").css("background","#00A49D");
              $("#loadDiv").hide();
          },
          data: obj,
          success: function(data){
              if (data.errCode == 200) {
                  window.location.href = erpWebUrl + '../../openApi/inviteRegist/fjdSucc';return;
              }else{
                  messageBox(data.errMsg);
              }
          },
          error: function () {
              reader = null;
          }
      });
    
  });

  // 选择弹框隐藏
  $('.picker-box').on('click',function(){
    $(this).hide();
  })

  $('#file-id').change(function(){{
      messageBox("正在提交，请稍后...");
     $(".g-foot-btn").css("background","#999999");
      var files = this.files;
      if(!!files) {
          $.each(this.files, function(index, file) {
              if (index >= 2) {
                  return;
              }
              console.log(index);
              var reader = new FileReader();
              //该方法将文件读取为一段以 data: 开头的字符串，这段字符串的实质就是 Data URL，Data URL是一种将小文件直接嵌入文档的方案。这里的小文件通常是指图像与 html 等格式的文件
              reader.readAsDataURL(file);
              reader.onload = function(){
                  // 图片base64化
                  var newUrl = this.result;
                  var fd = new FormData();
                  fd.append('files', file);
                  $.ajax({
                      url: erpWebUrl + '../../openApi/inviteRegist/fileUpload',
                      data: fd,
                      type: 'POST',
                      async: false,
                      cache: false,
                      processData: false,
                      contentType: false,
                      dataType: 'json',
                      success: function (data) {
                          $(".g-foot-btn").css("background","#00A49D");
                          if (data.errCode == 200) {
                              addIdImg(data.data.domain, data.data.filePath)
                          } else {
                              messageBox("图片过大");
                          }
                      },
                      error: function () {
                          reader = null;
                      }
                  });

              };
          });
      }
  }})

   $('#file-education').change(function(){
       messageBox("正在提交，请稍后...");
       $(".g-foot-btn").css("background","#999999");
       var files = this.files;
       if(!!files) {
           $.each(this.files, function(index, file) {
               if (index >= 4) {
                   return;
               }
               var reader = new FileReader();
               //该方法将文件读取为一段以 data: 开头的字符串，这段字符串的实质就是 Data URL，Data URL是一种将小文件直接嵌入文档的方案。这里的小文件通常是指图像与 html 等格式的文件
               reader.readAsDataURL(file);
               reader.onload = function(){
                   // 图片base64化
                   var newUrl = this.result;
                   var fileName = file.name;

                   var fd = new FormData();
                   fd.append('files', file);
                   $.ajax({
                       url: erpWebUrl + '../../openApi/inviteRegist/fileUpload',
                       data: fd,
                       type: 'POST',
                       async: false,
                       cache: false,
                       processData: false,
                       contentType: false,
                       dataType: 'json',
                       success: function (data) {
                           $(".g-foot-btn").css("background","#00A49D");
                           if (data.errCode == 200) {
                               addEducation(data.data.domain, data.data.filePath);
                           } else {
                               messageBox("图片过大");
                           }
                       },
                       error: function () {
                           reader = null;
                       }
                   });
               }
           });
       }
    });


  // 选择婚姻
  $('.placeholder-marriage').on('click',function(){
    $('.marriage').show();
  })
  $('.marriage li').on('click',function(){
    $("#marriage-input").val($(this).attr('data-index'));
    $('.placeholder-marriage').text($(this).text());
    $('.placeholder-marriage').css('color','#333333');
  })
  $('.marriage').on("click",function(){
    $('.picker-box').hide();
  })
  // 选择学历
  $('.placeholder-education').on('click',function(){
    $('.education').show();
  })
  $('.education li').on('click',function(){
    $("#education-input").val($(this).attr('data-index'));
    $('.placeholder-education').text($(this).text());
    $('.placeholder-education').css('color','#333333');
  })
  $('.education').on("click",function(){
    $('.picker-box').hide();
  })
 
})


// 是否显示身份证添加图片
var idImg = '';
var idImgNum = 0;
function addIdImg(domain,filePath){
  var str = '<li><div class="li-img" style="background-image: url('+domain+filePath+')"></div></li>'
  $('#add-ID').before(str);
    idImgNum++
  if(idImgNum == 2){
    idImg += filePath
  }else{
    idImg += filePath+","
  }
  $('#userIccodeUrl').attr('value',idImg);
  // 身份证上传图片
  if($('.user-id-img li').length >= 2){

    $('.user-id-img li').eq(2).hide();
  }
}

// 是否显示学历添加图片
var educaImg = '';
var educationImgNum = 0;
function addEducation(domain,filePath){
  var str = '<li><div class="li-img" style="background-image: url('+domain+filePath+')"></div></li>'
  $('#add-Education').before(str)
    educationImgNum++
  if(educationImgNum == 4){
    educaImg += filePath
  }else{
    educaImg += filePath+","
  }
  $('#educationUrl').attr('value',educaImg);
  // 学历上传图片
  if($('.g-diploma li').length >= 4){
    $('.g-diploma li').eq(4).hide();
  }
}

// 提示弹框显示
function messageBox(val) {
  if (val == '' || val == null) return
  $('.message-box').text(val);
  $(".message-box").show().delay(3000).hide(0);
}

function workingLife(val){
    var str = val.replace(/[^\d\.]/g, '');
    var pointIndex = str.search(/\./);
    var dd = /[1-9][0-9]\.*(5|0)/;

    if(-1 !== pointIndex) {
        if(!dd.test(str)){
            var m =str.length;
            var n = str.indexOf('.');
            var j = str.substring(n+1,m);
            if(!!j && j != 5){
                str = str.substring(0,n+1);
                str = str+'5'
            }
        }
    }
    if(str.indexOf('.')>-1){
        str = str.slice(0,4);
    }else{
        str = str.slice(0,2)
    }
    return str;
}

//进入页面提示弹窗确认隐藏
$(".toast-model .cont .btn").on("click",function(){
    $(".toast-model").hide();
})
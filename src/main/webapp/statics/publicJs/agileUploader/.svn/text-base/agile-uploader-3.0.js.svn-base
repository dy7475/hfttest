(function($) {
	var opts;
	var noURI;
	var agileUploader;
	var currFirstLabelTd = null;
	var tdArr1 = new Array();
	var tdArr2 = new Array();
	/**
	 * Agile Uploader Event Handler
	 * This method is responsible for catching all of the events coming from the swf.
	 * Every event will have a type and some sort of data. Mostly this includes the entire
	 * file object that was last attached, but some events return responses from the server.
	 *
	 * @param event {object} The event object from Flash
	*/
	$.fn.agileUploaderEvent = function(event) {
		//console.info('EVENT TRIGGERED: ' + event.type);
		switch(event.type) {
			case 'attach':
				$.fn.agileUploaderAttachFile(event.file);
				break;
			case 'progress':
				$.fn.agileUploaderCurrentEncodeProgress(event.file);
				break;
			case 'preview':
				$.fn.agileUploaderPreview(event.file);
				break;
			case 'file_removed':
				$.fn.agileUploaderDetachFile(event.file);
				break;
			case 'server_response':
				// this one is different, it doesn't get the file data, it gets the server response
				$.fn.agileUploaderServerResponse(event.response);
				break;
			case 'http_status':
				// this one is also gets the server response
				$.fn.agileUploaderHttpResponse(event.response);
				break;
			case 'max_post_size_reached':
				$.fn.agileUploaderMaxPostSize(event.file);
				break;
			case 'file_limit_reached':
				$.fn.agileUploaderFileLimit(event.file);
				break;
			case 'file_already_attached':
				$.fn.agileUploaderFileAlreadyAttached(event.file);
				break;
			case 'encoding_still_in_progress':
				$.fn.agileUploaderNotReady(event.file);
				break;
		}
	}
	
	/**
	 * Serializes the form data to be submitted to the server.
	 *
	 * @return Serialized form data or false if the form is empty
	*/
	$.fn.agileUploaderSerializeFormData = function() {		
		if((typeof(opts.formId) == 'string') && ($('#'+opts.formId).length > 0)) {			
			return $('#'+opts.formId).serialize();		
		}
		return false;
	}

	/**
	 * Visually adds the thumbnail to the list of attached files when it's available.
	 * If it isn't an image file type or isn't returned in the file object, a default icon will be used.
	 *
	 * @param file {object} The file object
	 * @see $.fn.agileUploaderCurrentEncodeProgress
	 * @see $.fn.agileUploaderEvent
	*/
	$.fn.agileUploaderPreview = function(file) {
		if((typeof(file.base64Thumbnail) != 'undefined') && (noURI !== true) && (file.base64Thumbnail != null)) {			
			$('#id-'+file.uid+' .agileUploaderFilePreview').find("img").attr("src",file.base64Thumbnail);
		} else {
			$('#id-'+file.uid+' .agileUploaderFilePreview').find("img").attr("src",opts.genericFileIcon);
		}
		// adjust the file size
		var sizeKb = ((file.finalSize / 1024) * 100) / 100;
		$('#id-'+file.uid+' .agileUploaderCurrentProgress').replaceWith('<span class="filesize">压缩后：'+ sizeKb.toFixed(2) +'Kb</span>');

		//自动上传文件
		if (!$(".agileUploaderCurrentProgress").length) {
			clearTimeout();
			setTimeout(function(){
				$.fn.agileUploaderSubmit()},
					1000);
		}
	}
	
	/**
	 * Callback after the form is submitted and data is returned from the server.
	 * The data returned will vary depending on the script used, defined in the "form_action" variable.
	 * If there's a "submit_reidrect" then the user will be redirected.
	 *
	 * @param response {mixed} The server response
	*/
	$.fn.agileUploaderServerResponse = function(response) {
		if (typeof(opts.uploadComplete) == "function") {
			opts.uploadComplete(response)
		}
		// If there's a div to put the return response data into, do so
		if(typeof(opts.updateDiv) == 'string') {
			$(opts.updateDiv).empty();
			$(opts.updateDiv).append(response);
		}		
		// Re-direct or empty the list so another submission can be made
		if(typeof(opts.submitRedirect) == 'string') {
			window.location = opts.submitRedirect;
		} else {			
			//$('#agileUploaderFileList').empty();
		}
	}
	
	/**
	 * This callback is given the HTTP response code.
	 * Note the response is passed in as a string.
	 * 
	 * @param response {string} The HTTP response code
	*/
	$.fn.agileUploaderHttpResponse = function(response) {
		if(response == "200") {
			$('#agileUploaderRemoveAll').empty();
		}
	}
	
	/**
	 * This event is called when there's still an image file encoding.
	 * The form can't be sent until everything is ready, otherwise, images could
	 * pass on to the server at original size.
	 * 
	 * @param file {string} The file object that hasn't completed encoding yet
	*/
	$.fn.agileUploaderNotReady = function(file) {
		$("#agileUploaderMessages").show();
		$('#agileUploaderMessages').text(opts.notReadyMessage);
		clearTimeout();
		setTimeout('$("#agileUploaderMessages").fadeOut()', 3000);
	}
	
	/**
	 * Visually adds files to a list and shows their file name, thumbnail, progress, and delete button.
	 *
	 * @param file {object} The file object
	 * @see $.fn.agileUploaderCurrentEncodeProgress
	 * @see $.fn.agileUploaderEvent
	*/
	$.fn.agileUploaderAttachFile = function(file) {
		/*console.info('---');
		console.dir(file);
		console.info('---');*/
		// if in single file replace mode just empty the list visually, only the last attached file will be submitted by flash (rare, this shouldn't be w/ multiple uploads)
		if(opts.flashVars.file_limit == -1) { 			
			$('#agileUploaderFileList').empty();
		}
		$("#agileUploaderInfo").animate({ scrollTop: $("#agileUploaderInfo").attr("scrollHeight") }, opts.attachScrollSpeed);
		var tdArr =(file.type=="normal")?tdArr1:tdArr2;
		if(tdArr.length==0){
			document.getElementById("agileUploaderSWF").removeFile(file.uid);
			$("#agileUploaderMessages").show();
			$('#agileUploaderMessages').text(file.type=="normal"?"室内图只能上传8张":"户型图只能上传2张");
			clearTimeout();
			setTimeout('$("#agileUploaderMessages").fadeOut()', 3000);
			return;
		}
		var tdObj = tdArr.shift();
		// add the file size
		var sizeKb = ((file.finalSize / 1024) * 100) / 100;
		$(tdObj).find(".setCover").click(function(){
			$.fn.agileUploaderSetCover(tdObj);
			return false;
		});
		$(tdObj).find(".fixtop").html('<span id="ori_file'+file.uid+'" class="filesize">文件：'+ sizeKb.toFixed(2) +'Kb</span><div class="agileUploaderFileSize"><div id="'+ file.uid+ 'CurrentProgress" class="agileUploaderCurrentProgress"></div></div>');
		$(tdObj).find(".agileUploaderFileSize").width($(tdObj).width()-$("#ori_file"+file.uid).width()-20);
		$(tdObj).attr("id","id-"+ file.uid).removeClass("only").addClass("hasphoto").find(".agileUploaderRemoveFile").html('<a href="javascript:void(0)" hideFocus id="remove-' + file.uid + '" title="从上传列表中删除"></a>');
		$("#remove-" + file.uid).click(function(){
			$.fn.agileUploaderClearTd(tdObj);
			return false;
		});
		// Check for IE, change css special for IE.
		/**if(/msie/i.test(navigator.userAgent) && !/opera/i.test(navigator.userAgent) === true) {
			$('#id-'+file.uid).css('height', opts.flashVars.preview_max_height+5);
		} else {
			$('#id-'+file.uid).css('height', opts.flashVars.preview_max_height);
		}**/
		
		// If using a bar, the background gets the value of opts.progressBar, it can be '#123456' or 'url:("image.jpg")'  ... NOTE: no ending ;
		if ((typeof(opts.progressBar) == "string") && (opts.progressBar != "percent")) {
			$("#" + file.uid + "CurrentProgress").css("background", opts.progressBarColor)
		}
		
		$('#agileUploaderFileInputText').val(file.fileName);
		
		if (typeof(opts.onSubmit) == "function") {
			opts.onSubmit()
		}
	}	
	$.fn.agileUploaderClearTd = function(tdObj) {
		$(tdObj).addClass("only").removeClass("showLabel hasphoto").find(".fixtop").empty();
		var uid = $(tdObj).attr("id").replace("id-","");
		document.getElementById("agileUploaderSWF").removeFile(uid);
		if($(tdObj).attr("type")==undefined){
			$(tdObj).find("img").attr("src","images/default.jpg");
			tdArr1.unshift(tdObj);
		}else{
			$(tdObj).find("img").attr("src","images/typ.gif");
			tdArr2.unshift(tdObj);
		}
		$("#remove-"+uid).unbind('click');
	}
	/**
	 * Visually shows the percentage of each file as it's being resized and encoded.
	 * The progress bar was put onto the page from the attach method.
	 *
	 * @param file {object} The entire file object which also includes the progress.
	 * @see $.fn.agileUploaderAttachFile
	 * @see $.fn.agileUploaderEvent
	*/
	$.fn.agileUploaderCurrentEncodeProgress = function(file) {
		//console.info(parseInt(file.percentEncoded));
		if(opts.progressBar == 'percent') {				
			$('#'+file.uid+'CurrentProgress').text(parseInt(file.percentEncoded)+'%');
		} else {
			$('#'+file.uid+'CurrentProgress').css('width', parseInt(file.percentEncoded)+'%');
			$('#agileUploaderProgressBar').css('width', parseInt(file.percentEncoded)+'%');
		}
		
		if(file.percentEncoded >= 100) {
			$('.agileUploaderFileName, .agileUploaderRemoveFile, .agileUploaderFileSize, .agileUploaderFilePreview').show();
			// add remove all
			//$('#agileUploaderRemoveAll').html('<a href="#" onClick="document.getElementById(\'agileUploaderSWF\').removeAllFiles(); $(\'#agileUploaderFileList\').empty(); $(\'#agileUploaderRemoveAll\').empty(); return false;">'+opts.removeAllText+'</a>');
		}
	}
	
	/**
	 * Visually removes the file from the attached files list.
	 * This only happens when Flash fires the 'filed_removed' event, so we are certain it's gone.
	 *
	 * @param file {object} The entire file object
	 * @see $.fn.agileUploaderEvent
	*/
	$.fn.agileUploaderDetachFile = function(file) {
		$('#id-'+file.uid +"img").attr("src","images/default.jpg");
		if($('#agileUploaderFileList td').length < 1) {
			$('#agileUploaderRemoveAll').empty();
		}
	}
	
	/**
	 * Called when a duplicate file is attached.
	 * This just allows us to notify the user that they already attached the file.
	 * Purely for user experience.
	 *
	 * @param file {object} The file object of what was added twice
	*/
	$.fn.agileUploaderFileAlreadyAttached = function(file) {
		$("#agileUploaderMessages").show();
		$('#agileUploaderMessages').text(opts.duplicateFileMessage);
		clearTimeout();
		setTimeout('$("#agileUploaderMessages").fadeOut()', 3000);
	}
	
	/**
	 * Called when the maximum POST size (the combined total file size of all files) is reached.
	 * The last file trying to be attached will be returned to this method.
	 *
	 * @param file {object} The file object
	*/
	$.fn.agileUploaderMaxPostSize = function(file) {
		$('#id-'+file.uid).remove(); // in case the row was visually added because it had a progress bar (it's already removed in Flash, well, it was never added actually)
		$("#agileUploaderMessages").show();
		$('#agileUploaderMessages').text(opts.maxPostSizeMessage);
		clearTimeout();
		setTimeout('$("#agileUploaderMessages").fadeOut()', 3000);
	}
	
	/**
	 * Called when the maximum number of files has been reached.
	 * The last file trying to be attached will be returned to this method.
	 *
	 * @param file {object} The file object
	*/
	$.fn.agileUploaderFileLimit = function(file) {		
		$('#id-'+file.uid).remove(); // in case the row was visually added because it had a progress bar		
		$("#agileUploaderMessages").show();
		$('#agileUploaderMessages').text(opts.maxFileMessage);
		clearTimeout();
		setTimeout('$("#agileUploaderMessages").fadeOut()', 3000);
	}

	/**
	 * Main method that embeds the Agile Uploader to handle multiple files.
	 * (multiple file mode)
	 * 
	*/
	$.fn.agileUploader = function(options) {
		$("#agileUploaderFileList").find("td").each(function(){
			if($(this).attr("type")==undefined){
				if($(this).attr("placeholded")==undefined || $(this).attr("placeholded")=="0")tdArr1.push($(this).addClass("only").removeClass("hasphoto"));
			}else{
				if($(this).attr("placeholded")==undefined || $(this).attr("placeholded")=="0")tdArr2.push($(this).addClass("only").removeClass("hasphoto"));
			}
		});
		var photoJson = options.photoJson;
		$(photoJson).each(function(i,data){
			var tdObj,tdArr;
			if(data.PHOTO_TYPE==1){
				tdArr = tdArr2;
			}else{
				tdArr = tdArr1.length==0?tdArr2:tdArr1;
			}
			tdObj = tdArr.shift();
			$(tdObj).attr("id","id-"+ data.PHOTO_ID).removeClass("only").addClass("hasphoto").find(".agileUploaderRemoveFile").html('<a href="javascript:void(0)" hideFocus id="remove-' + data.PHOTO_ID + '" title="从上传列表中删除"></a>');
			if(data.IS_TOP == 1){
				tdObj.addClass("showLabel");
				currFirstLabelTd = tdObj.attr("id");
			}
			$(tdObj).find(".agileUploaderFilePreview").prepend("<img src='"+data.addr+"'/>");
			$("#remove-"+data.PHOTO_ID).click(function(){
				confirm("确定要删除该图片吗？", function(){
					$(this).unbind('click');
					var newData = data;
					$.get(submitUrl,{action:"remove",PHOTO_ID:newData.PHOTO_ID,IS_TOP:newData.IS_TOP,CASE_TYPE:newData.CASE_TYPE,
					CASE_NO:newData.CASE_NO,RELATE_CASE_ID:newData.RELATE_CASE_ID,RELATE_CASE_NO:newData.RELATE_CASE_NO,
					RELATE_CASE_OWNER:newData.RELATE_CASE_OWNER,RELATE_ID:newData.RELATE_ID,CASE_ID:newData.CASE_ID,
					isPublish:newData.isPublish},function(data){
						var execFlag = data.replace(/^\s*/gi,"").replace(/\s*$/gi,"");
						if(!execFlag){
							alert("删除图片出错，请与在线客服联系！");
							return false;
						}
						$("#id-"+newData.PHOTO_ID +" a").unbind("click");
						var tdObj = $('#id-'+newData.PHOTO_ID);
						$.fn.agileUploaderClearTd(tdObj);
						refreshParent();
						return false;
					});
				});
			});
			$("#id-"+data.PHOTO_ID +" .setCover").data("arr",["", data.PHOTO_ID,data.RELATE_ID]).click(function(){
				confirm("确定将房源首图换为该图片吗？", function(){
					$(this).unbind('click');
					var newData = data;
					$.get(submitUrl,{action:"setcover",PHOTO_ID:newData.PHOTO_ID,IS_TOP:newData.IS_TOP,CASE_TYPE:newData.CASE_TYPE,
					CASE_NO:newData.CASE_NO,RELATE_CASE_ID:newData.RELATE_CASE_ID,RELATE_CASE_NO:newData.RELATE_CASE_NO,
					RELATE_CASE_OWNER:newData.RELATE_CASE_OWNER,RELATE_ID:newData.RELATE_ID,CASE_ID:newData.CASE_ID},function(data){
						var execFlag = data.replace(/^\s*/gi,"").replace(/\s*$/gi,"");
						if(!execFlag){
							alert("设置首图出错，请与在线客服联系！");
							return false;
						}
						var tdObj = $('#id-'+newData.PHOTO_ID);
						$.fn.agileUploaderSetCover(tdObj);
						return false;
					});
				});
			});
		});
		$(tdArr1).each(function(){$(this).find(".agileUploaderFilePreview").prepend("<img src='images/default.jpg'/>")});
		$(tdArr2).each(function(){$(this).find(".agileUploaderFilePreview").prepend("<img src='images/typ.gif'/>")});
		
		opts = $.extend({}, $.fn.agileUploader.defaults, options);
		options.flashVars.form_action = options.flashVars.form_action.replace(/&/gi,"|");
		opts.flashVars = $.extend({}, $.fn.agileUploader.defaults.flashVars, options.flashVars);    
		opts.flashParams = $.extend({}, $.fn.agileUploader.defaults.flashParams, options.flashParams);
		opts.flashAttributes = $.extend({}, $.fn.agileUploader.defaults.flashAttributes, options.flashAttributes);
		
		return this.each(function() {
			// We know IE6 & IE7 don't have data URI support
			if ($.browser.msie && (parseInt($.browser.version) < 7)) { 
				noURI = true; 
			} else {
				// If it's another browser, test data URI support
				var data = new Image();
				data.onload = data.onerror = function(){
					if(this.width != 1 || this.height != 1) {
						noURI = true;
					}
				}
				data.src = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///ywAAAAAAQABAAACAUwAOw==";
			}
			// end data uri check
	
			$('#'+this.id).append('<div id="agileUploaderAttachArea"><span id="agileUploaderRemoveAll"></span>' +
			'<span id="btn_area"><span id="agileUploaderEMBED"></span>' +
			'<span id="agileUploaderSubmit"></span></span></div>');
			$('<div id="agileUploaderMessages"></div>').appendTo("body").hide();
			$.fn.agileUploaderEmbed(); // embed
			agileUploader = document.getElementById("agileUploaderSWF");
		});	
	}
	
	/**
	 * Main method that embeds the Agile Uploader to handle a single file.
	 * (single file mode)
	 * 
	*/
	$.fn.agileUploaderSingle = function(options) {
		if(typeof(options) == 'undefined') { 
			var options = {};
		}
		// change around defaults for this	
		delete $.fn.agileUploader.defaults.flashVars.button_up;
		delete $.fn.agileUploader.defaults.flashVars.button_over;
		delete $.fn.agileUploader.defaults.flashVars.button_down;
		$.fn.agileUploader.defaults.flashWidth = 110;
		$.fn.agileUploader.defaults.flashHeight = 25;
		$.fn.agileUploader.defaults.flashVars.show_encode_progress = true;
		// combine everything together
		opts = $.extend({}, $.fn.agileUploader.defaults, options);		
		if(typeof(options.flashVars) == 'undefined') { options.flashVars = {}; }
		opts.flashVars = $.extend({}, $.fn.agileUploader.defaults.flashVars, options.flashVars);
		if(typeof(options.flashParams) == 'undefined') { options.flashParams = {}; }
		opts.flashParams = $.extend({}, $.fn.agileUploader.defaults.flashParams, options.flashParams);
		if(typeof(options.flashAttributes) == 'undefined') { options.flashAttributes = {}; }
		opts.flashAttributes = $.extend({}, $.fn.agileUploader.defaults.flashAttributes, options.flashAttributes);
		// always set to -1 so it goes into a single replace mode
		opts.flashVars.file_limit = -1; 
		
		return this.each(function() {
			$('#'+this.id).append('<div id="agileUploaderAttachArea"><div id="agileUploaderInfoContainer"><input id="agileUploaderFileInputText" type="text" /><div id="agileUploaderProgressBar"></div></div><div id="agileUploaderEMBED"></div><div id="agileUploaderMessages" class="agileUploaderSingleMessages"></div></div>');
			$.fn.agileUploaderEmbed(); // embed
			$('#agileUploaderProgressBar').css('background', opts.progressBarColor);
		});
	}

	$.fn.agileUploaderEmbed = function() {
		// Breaks up cache. When redirecting back to the page that embeds the swf, some browsers will have a problem. Randomizing the name seems to help.
		var flashSrcCacheBust=opts.flashSrc+'?'+Math.floor(Math.random()*9999+1);
//		var flashSrcCacheBust=opts.flashSrc;
		// Embed with jQuery Flash if available
		if(typeof($().flash) == 'function') {	
			$('#agileUploaderEMBED').flash({
				// As always; all settings are entirely optional.
			    id: "agileUploaderSWF", 
			    width: opts.flashWidth,
			    height: opts.flashHeight,
			    src: flashSrcCacheBust,
			    flashvars: opts.flashVars,
			    bgcolor: '#fff',
			    quality: 'high',
			    wmode: 'transparent',
			    allowscriptaccess: 'always',
			    classid: 'clsid:D27CDB6E-AE6D-11cf-96B8-444553540000', // For IE support.
			    codebase: 'http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=', // Ditto.
			    pluginspace: 'http://get.adobe.com/flashplayer', // Download Firefox plugin if missing.
			    version: '10.0.0'		
		     });
		} else 	{		
			// Embed the swf using swfobject (if swfobject is available)
			if(typeof(swfobject) != 'undefined') {
				swfobject.embedSWF(flashSrcCacheBust, 'agileUploaderEMBED', opts.flashWidth, opts.flashHeight, "10.0.0","expressInstall.swf", opts.flashVars, opts.flashParams, opts.flashAttributes);
			} else {
				$('#agileUploaderEMBED').html('<p>You need to have either swfobject or jquery flash in order to embed.</p>');
			}
		}
	}
		
	$.fn.agileUploaderSubmit = function() {
		if($.browser.msie && $.browser.version == '6.0') {
			window.document.agileUploaderSWF.submit();
		} else {
			document.getElementById('agileUploaderSWF').submit();
			return false;
		}
	}
		
	$.fn.agileUploaderSetCover = function(tdObj) {
		if(!window.document.agileUploaderSWF || !document.getElementById('agileUploaderSWF')){
			setTimeout(function(){$.fn.agileUploaderSetCover(tdObj)},1000);
			return;
		}
		var tdid = $(tdObj).attr("id");
		var uid = tdid.replace("id-","");
		if(currFirstLabelTd!=null)$("#"+currFirstLabelTd).removeClass("showLabel");
		if($.browser.msie && $.browser.version == '6.0') {
			window.document.agileUploaderSWF.setCover(uid);
		} else {
			document.getElementById('agileUploaderSWF').setCover(uid);
		}
		currFirstLabelTd = tdid;
		$("#"+currFirstLabelTd).addClass("showLabel");
	}
	
	$.fn.agileUploader.defaults = {
		// First the Flash embed size and Flashvars (which is another object which makes it easy)
		flashSrc: 'agile-uploader.swf',
		flashWidth: 25,
		flashHeight: 22,
		flashParams: {allowscriptaccess: 'always',wmode:'transparent'},
		flashAttributes: {id: "agileUploaderSWF"},
		flashVars: {
			max_height: 500,
			max_width: 500,
			jpg_quality: 85, 
			preview_max_height: 50,
			preview_max_width: 50,
			show_encode_progress: true,
			js_get_form_data: '$.fn.agileUploaderSerializeFormData',
			js_event_handler: '$.fn.agileUploaderEvent',
			return_submit_response: true,
			file_filter: '*.jpg;*.jpeg;*.gif;*.png;*.JPG;*.JPEG;*.GIF;*.PNG;*.zip',
			file_filter_description: 'Files',
			// max post size is in bytes (note: all file size values are in bytes)
			max_post_size: (1536 * 1024),
			file_limit: -1,
			button_up:'add-file.png',
			button_over:'add-file.png',
			button_down:'add-file.png'		
		},
		progressBarColor: '#000000',
		attachScrollSpeed: 1000,		
		removeIcon: 'trash-icon.png',
		genericFileIcon: 'file-icon.png',
		maxPostSizeMessage : "文件大小超出限制.",
		maxFileMessage : "文件数量超出限制.",
		duplicateFileMessage: '该文件已经选择',
		notReadyMessage: 'The form can not be submitted yet because there are still files being resized.',
		removeAllText: '移除全部'
	}	
	
})(jQuery);
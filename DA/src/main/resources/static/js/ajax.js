var csUrl = ''; //http://127.0.0.1:8080/login?userId=1&password=1   http://192.168.1.129:8080
var ajaxPost = function(url,data,async,success,faild){
	$.ajax({
		url: url,
		type: "POST", //POST
		data: data,
		async: async,
		cache: false,
		success: function(res){
			if(res.name != ''){
				success(res);
			}else{
				faild(res.message);
			}
		},
		error: function(res){
			alert('请求失败，请稍后再试');
		},
		dataType:"json"
	});
};  

var ajaxPostLogin = function(url,data,async,success,faild){
	$.ajax({
		url: url,
		type: "POST", //POST
		data: data,
		async: async,
		cache: false,
		success: function(res){
			if(res.message == '0'){
				success(res);
			}else{
				faild(res);
			}
		},
		error: function(res){
			alert('请求失败，请稍后再试');
		},
		dataType:"json"
	});
};  

var ajaxDownExcel = function(url,params,success,faild){//表格下载
	$.ajax({
		type: "POST",
		url: url,
		data: params,
		dataType: "text",
		success: function(response, status, request) {
	          var disp = request.getResponseHeader('Content-Disposition');
	          if (disp && disp.search('attachment') != -1) {  //判断是否为文件
	              var form = $('<form method="POST" action="' + url + '">');
	              $.each(params, function(k, v) {
	                 form.append($('<input type="hidden" name="' + k +
	                         '" value="' + v + '">'));
	             });
	             $('body').append(form);
	             if(status == 'success'){
	            	 form.submit(); //自动提交
	            	 delLoading();
	             }
	         }
	     },
	     error: function(res){
	 		alert('请求失败，请稍后再试');
	 	}
	});
};	


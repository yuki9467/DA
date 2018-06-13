var fileUrl = '';//图片路径
function popShow(contract){//弹出下载图片
	var html = '<a href="javascript:;" onclick="popCancel()"><img src="images/close.png"></a><h2>确定下载图片包？</h2><a href="javascript:;" onclick="popConfirm('+contract+')">确定</a><a href="javascript:;" onclick="popCancel()">取消</a>';
	$('#popShade').show();$('.pop-img').show();
	$('.pop-img').html(html);
}
function popConfirm(contract){//确定按钮下载图片
	if(fileUrl.length == '' || fileUrl.length == 0){
		alert('没有可下载图片！');$('#popShade').hide();$('.pop-img').hide();return false;
	}else{
		$('#popShade').hide();$('.pop-img').hide();
		downLoadImg(contract);
	}
}
function popCancel(){//关闭图片
	$('#popShade').hide();$('.pop-img').hide();
}
function showImg(contract){ //图片显示
 	if(contract!=''){
		$.ajax({
			url: '/selectFileByCondition',
			type: "POST",
			data: {'contract':contract},
			async: false,    
			success: function (data) {
				fileUrl  = data;
				if(fileUrl.length == '' || fileUrl.length == 0){
					alert('没有可查看图片！');return false;
				}else{
					var j = '';
					for(var i =0;i<fileUrl.length;i++){
						j += fileUrl[i].fileUrl + ',';
					}
					var sliceStr = (j.slice(j.length-1)==',')?j.slice(0,-1):j;
					var arr = sliceStr.split(',');
					api_gallery = arr;
					$("a[rel^='prettyPhoto']").prettyPhoto();
					$.prettyPhoto.open(api_gallery);return false;
				}
			},
			error: function () {
				alert("查看失败");
			},
			dataType: 'json'
		});
 	}else{
 		alert("查看失败");
 	}
}
//var imgs = document.getElementById('imgs');
if($('#imgs').html().length < 0){
	alert('没有可下载图片!');
}
function downLoadImg(contract){//开始下载图片
	loading();
	var success = function(data){
		alert(data);
	};
	var faild = function(error){
		alert(error);
	};
	ajaxDownExcel('/downloadFile',{"contract":contract},success,faild); 
} 
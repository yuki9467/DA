var frameWorkList = [];
querySelect(); //事业部
$("#sid").change(function(){      
	document.getElementById('did').innerHTML = '<option value="">请选择</option>';
	document.getElementById('fid').innerHTML = '<option value="">请选择</option>';
	document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
	document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
	document.getElementById('sybManager').value = '';
	document.getElementById('dqManager').value = '';
	document.getElementById('fgsManager').value = '';
	document.getElementById('yybManager').value = '';
	if($(this).val() == 0 || $(this).val() == '0001' || $(this).val() == '0002'){
		document.getElementById('did').innerHTML = '<option value="">请选择</option>';
		document.getElementById('fid').innerHTML = '<option value="">请选择</option>';
		document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
		document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
		document.getElementById('sybManager').value = '';
		document.getElementById('dqManager').value = '';
		document.getElementById('fgsManager').value = '';
		document.getElementById('yybManager').value = '';
	}else{
		queryDq();
		querySybManager();
	}
});
$("#did").change(function(){
	document.getElementById('fid').innerHTML = '<option value="">请选择</option>';
	document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
	document.getElementById('dqManager').value = '';
	document.getElementById('fgsManager').value = '';
	document.getElementById('yybManager').value = '';
	if($(this).val() == 0){
		document.getElementById('fid').innerHTML = '<option value="">请选择</option>';
		document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
		document.getElementById('dqManager').value = '';
		document.getElementById('fgsManager').value = '';
		document.getElementById('yybManager').value = '';
	}else{
		queryFid();
		querydqManager();
	}
});
$("#fid").change(function(){
	document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
	document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
	document.getElementById('fgsManager').value = '';
	document.getElementById('yybManager').value = '';
	if($(this).val() == 0){
		document.getElementById('yid').innerHTML = '<option value="">请选择</option>';
		document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
		document.getElementById('fgsManager').value = '';
		document.getElementById('yybManager').value = '';
	}else{
		queryYid();
		queryFgsManager();
	}
});
$("#yid").change(function(){
	document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
	document.getElementById('yybManager').value = '';
	if($(this).val() == 0){
		document.getElementById('tManager').innerHTML = '<option value="">请选择</option>';
		document.getElementById('yybManager').value = '';
	}else{
		queryTid();
		queryYybManager();
	}
});
function querySelect(){ //查事业部	
	var success = function(data){
		frameWorkList = data;	
		createSelect();
	};
	var faild = function(error){
 		alert(error);
 	};
 	var user = JSON.parse(sessionStorage.user);
 	ajaxPost('/selectOrganizationByCondition',{'typeId':user.typeId,'sid':user.sid,'did':user.did,'fid':user.fid,'yid':user.yid},false,success,faild);
}
function createSelect(){ //创建sid
	var sid = '<option value="">请选择</option>';
	var dmanager = '';
	for(var i=0;i<frameWorkList.length;i++){
		sid += '<option value="'+frameWorkList[i].did+'">'+ frameWorkList[i].dname +'[' + frameWorkList[i].did +']</option>';
	}
	document.getElementById('sid').innerHTML = sid;
}
//queryDq();
function queryDq(){//查大区
	var sidList = $("#sid").val();
     var success = function(data){
    	 frameWorkList = data;
		 createDq();
		};
		var faild = function(error){
	 		alert(error);
	 	};
     ajaxPost('/getDqListByCondition',{'D_ID':sidList},false,success,faild);
}
function createDq(){ //创建did
	var pid = '<option value="">请选择</option>';
	for(var i=0;i<frameWorkList.length;i++){
		pid += '<option value="'+frameWorkList[i].pid+'">'+ frameWorkList[i].pname +'[' + frameWorkList[i].pid +']</option>';
	}
	document.getElementById('did').innerHTML = pid;
}
//queryFid();
function queryFid(){//查分公司
	var didList = $("#did").val();
     var success = function(data){
    	 frameWorkList = data;
    	 createFgs();
		};
		var faild = function(error){
	 		alert(error);
	 	};
     ajaxPost('/getFgsListByCondition',{'P_ID':didList},false,success,faild);
}
function createFgs(){ //创建fid
	var fid = '<option value="">请选择</option>';
	for(var i=0;i<frameWorkList.length;i++){
		fid += '<option value="'+frameWorkList[i].fid+'">'+ frameWorkList[i].fname +'[' + frameWorkList[i].fid +']</option>';
	}
	document.getElementById('fid').innerHTML = fid;
}
//queryYid();
function queryYid(){//查营业部
	var fidList = $("#fid").val();
     var success = function(data){
    	 frameWorkList = data;
    	 createYyb();
		};
		var faild = function(error){
	 		alert(error);
	 	};
     ajaxPost('/getYybListByCondition',{'F_ID':fidList},false,success,faild);
}
function createYyb(){ //创建yid
	var yid = '<option value="">请选择</option>';
	for(var i=0;i<frameWorkList.length;i++){
		yid += '<option value="'+frameWorkList[i].yid+'">'+ frameWorkList[i].yname +'[' + frameWorkList[i].yid +']</option>';
	}
	document.getElementById('yid').innerHTML = yid;
}
//queryTid();
function queryTid(){//查团队
	var YidList = $("#yid").val();
    var success = function(data){
    	 frameWorkList = data;
    	 createTid();
		};
		var faild = function(error){
	 		alert(error);
	 	};
     ajaxPost('/getTdListByCondition',{'Y_ID':YidList},false,success,faild);
}
function createTid(){ //创建tid
	var tid = '<option value="">请选择</option>';
	for(var i=0;i<frameWorkList.length;i++){
		tid += '<option value="'+frameWorkList[i].tid+'">'+ frameWorkList[i].tmanager + '</option>'; //'[' + frameWorkList[i].tid +']
	}
	document.getElementById('tManager').innerHTML = tid;
}
function querySybManager(){ //读取事业部经理
	var sid = $("#sid").val();
	var success = function(data){
   		frameWorkList = data;
   		$('#sybManager').val(frameWorkList.dmanager);
	};
	var faild = function(error){
	 	alert(error);
	};
    ajaxPost('/selectSybByCondition',{'D_ID':sid,'vlevel':0},false,success,faild);
}
function querydqManager(){ //读取大区经理
	var sid = $("#sid").val();
	var did = $("#did").val();
	var success = function(data){
   		frameWorkList = data;
   		$('#dqManager').val(frameWorkList.pmanager);
	};
	var faild = function(error){
	 	alert(error);
	};
    ajaxPost('/selectDqByCondition',{'D_ID': sid,'P_ID': did, 'vlevel':0},false,success,faild);
}
function queryFgsManager(){ //读取分公司经理
	var sid = $("#sid").val();
	var did = $("#did").val();
	var fid = $("#fid").val();
	var success = function(data){
   		frameWorkList = data;
   		$('#fgsManager').val(frameWorkList.fmanager);
	};
	var faild = function(error){
	 	alert(error);
	};
    ajaxPost('/selectFgsByCondition',{'D_ID': sid,'P_ID': did, 'F_ID': fid, 'vlevel':0},false,success,faild);
}
function queryYybManager(){ //读取营业部经理
	var sid = $("#sid").val();
	var did = $("#did").val();
	var fid = $("#fid").val();
	var yid = $("#yid").val();
	var success = function(data){
   		frameWorkList = data;
   		$('#yybManager').val(frameWorkList.ymanager);
	};
	var faild = function(error){
	 	alert(error);
	};
    ajaxPost('/selectYybByCondition',{'D_ID': sid,'P_ID': did, 'F_ID': fid, 'Y_ID': yid, 'vlevel':0},false,success,faild);
}

function move(obj,json,fn){
　　clearInterval(obj.timer);
　　obj.timer=setInterval(function(){
　　　　var onoff=true; 
　　　　for(var attr in json){
　　　　　　var icur=0;
　　　　　　if(attr=='opacity'){
　　　　　　　　icur=Math.round(parseFloat(getStyle(obj,attr))*100);
　　　　　　}else{
　　　　　　　　icur=parseInt(getStyle(obj,attr));
    　		}
　　　　　　var speed=(json[attr]-icur)/10;
　　　　　　speed=speed>0?Math.ceil(speed):Math.floor(speed);
　　　　　　//检测是否停止
　　　　　　if(icur !=json[attr]){             
　　　　　　　　onoff=false;               
　　　　　　}
　　　　　　if(attr=='opacity'){
　　　　　　　　//IE
　　　　　　　　obj.style.filter="alpha(opacity='+icur+speed+')";    
　　　　　　　　//firefox
　　　　　　　　obj.style.opacity=(icur+speed)/100;
　　　　　　}else{
　　　　　　　　obj.style[attr]= icur+speed+'px';  
　　　　　　}
　　　　}
　　　　if(onoff){clearInterval(obj.timer);
　　　　　　if(fn){　fn();}
　　	 }  
	}, 30); 
}
function getStyle(obj,attr){
　　//currentStyle针对IE浏览器 getComputedStyle针对火狐浏览器
　　if(obj.currentStyle){
    return currentStyle[attr];
　　}else{
    return  getComputedStyle(obj,false)[attr];
　　}
}
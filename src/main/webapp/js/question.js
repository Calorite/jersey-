var map = new Map();
$(document).ready(function(){
	var selectlist=document.getElementsByTagName('select');
	var source="";
	for(var i=0;i<selectlist.length;i++){
		item=selectlist[i];
		if(i%2==0){
			source="#"+item.id;
		}else{
			$(source,'#'+item.id).listswap({
				truncate:true,
				height:162,
			});
		}
	}
	$('#source_4, #destination_4').listswap({
		truncate:true,
		height:162,
	});
})
var buttoncount=1;
var testlist=[234,453,565,657];
var newquestionmap=new Map();
function SelectText()
{
	try{
		var selecter=window.getSelection().toString();
		if(selecter!=null&&selecter.trim()!=""){
			$("#tbe").append("<tr id='"+buttoncount+"'><td><div class='btn-toolbar'><div class='btn-group'><button class='btn btn-info ' onclick='dealfuc(event);'>编辑</button></div><div class='btn-group'><button  class='btn btn-danger' onclick='deletefuc(event);'>删除</button></div><div class='btn-group'><button  class='btn btn-default' onclick='shownewquestion(event);'>"+selecter+"</button></div></div></td></tr>");
			$("#tbe").append("<tr></tr>");
			buttoncount=buttoncount+1;
		}
	}catch(err){
		var selecter=document.selection.createRange();
		var s=selecter.text;
		if(s!=null&&s.trim()!=""){
			alert(s)
		}
	}
}

function deletefuc(event){
	var p=event.srcElement.parentNode.parentNode.parentNode.parentNode.id;
	$("#"+p).remove();
	$("#newquestion"+p).remove();
}



function showquestion(event){
	questionid=event.srcElement.getAttribute("questionid");
	if(questionid!=null){
		$.ajax({
			type : "POST",
			url : "/jerseyREST/webapi/myresource/question",
			data:{quesid:questionid},
			success : function (data) {
				console.log(data);
			}
		});
	}
}

function shownewquestion(event){
	newparameter=event.srcElement.innerText;
	trid=event.srcElement.parentNode.parentNode.parentNode.parentNode.id;
	if(newquestionmap[trid]){
		newquestionmap[trid]=false;
		$("#newquestion"+trid).remove();
	}else{
		$("#"+trid).after('<div id=newquestion'+trid+'>'
				+'<div class="form-group">'
				+'<label for="question">问题:</label>'
				+'<input type="text" class="form-control" id="question" >'
				+'</div>'
				+'<button class="btn btn-default" onclick="queding(event)">确定</button>'
				+'</div>');
		newquestionmap[trid]=true;
	}
}

$('#gengxin').click(function(){
	solutionid=3;
	var json = JSON.stringify(testlist);
	$.ajax({
		type : "POST",
		url : "/jerseyREST/webapi/myresource/solution",
		data:{solution:solutionid,
			parameters:json
		},
		success : function (data) {
			console.log(data);
		}
	});
});


function queding(event){
	questionid=event.srcElement.parentNode.id;
	$("#"+questionid).append('<div class="container">'
	+'<h2>question1</h2>'
    +'<hr />'
	+'<form method="post">'
            +'<select id="source" data-search="Search for options">'
                +'<option value="option_1">Option 1</option>'
                +'<option value="option_2">Why not option 2</option>'
                +'<option value="option_3">Here\'s another option 3</option>'
                +'<option value="option_4">What about option 4</option>'
                +'<option value="option_5">I\'ll go with option 5</option>'
                +'<option value="option_6">Let\'s stick to option 6</option>'
            +'</select>'
            +'<select id="destination"  data-search="Search for options">'
            +'</select>'
    +'</form>'
    +'</div>');
	$('#source, #destination').listswap({
		truncate:true,
		height:162,
	});
}

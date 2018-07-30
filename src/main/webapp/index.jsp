<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"  import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Insert title here</title>
<script src="../lib/jquery.js"></script>
<script src="../lib/jquery.cookie.js"></script>
<script src="../lib/bootstrap.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/bootstrap.css" rel="stylesheet" />
<link href="../css/myshow.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../css/listswap.css" />
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<div class="jquery-script-clear"></div>
	<div style="padding-top:10px">
		<form id="usrform" >
			<div class="leftitem form-group">
				<textarea id="textn" name="description" rows="15" cols="30"
					onClick="SelectText()"></textarea>
			</div>
		</form>
			<div class="leftitem form-group">
				<button type="button"  id="tijiao">提交</button>
			</div>	　
			<div class="leftitem form-group" id="parameterlist">
				<table id="tbe" class="table" style="border-collapse:separate; border-spacing:0px 8px;">

				</table>
			</div>
			<div class="endleft form-group">
				SolutionID:<input name="solution" type="text"></input>
				<button id="gengxin">更新</button>
			</div>
	</div>
	<script src="../js/index.js"></script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="../js/jquery.listswap.js"></script>
</body>
</html>
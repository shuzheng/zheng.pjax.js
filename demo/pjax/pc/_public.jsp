<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${title}</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<style type="text/css">
html,body{margin:0;padding:0;}
#container{min-width:800px;}
#header{width:100%;height:150px;line-height:50px;padding-top:50px;background:#080808;text-align:center;font-size:25px;color:#9d9d9d;}
#content{width:600px;margin:0 auto;min-height:400px;padding:20px;}
li{line-height:2em;}
li a{text-decoration:none;color:#333;}
li a:hover{text-decoration:underline;color:#c00;}
p{color:#888;}
</style>
</head>
<body>
<div id="container">
	<div id="header">
		HTML5 history新特性pushState、replaceState示例演示 <span id="timer">0</span><br/>
		<audio controls="controls" preload="none" style="width:600px;"><source src="http://fm.xinbaby.com/attached/media/20150717/1437128924201.mp3" type="audio/mp3">
	</div>
	<div id="content">
		<c:if test="${action==\"index\"}"><%@ include file="index.jsp"%></c:if>
		<c:if test="${action==\"list\"}"><%@ include file="list.jsp"%></c:if>
		<c:if test="${action==\"show\"}"><%@ include file="show.jsp"%></c:if>
	</div>
</div>
<!--[if !IE]><!-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/tools/nprogress/nprogress.min.css"/>
<script src="${pageContext.request.contextPath}/resource/tools/nprogress/nprogress.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/zheng.pjax.js"></script>
<script type="text/javascript">
$(function() {
	// 初始化插件
	$.pjax({
		selector: 'a',
		container: '#content'
	});
});
setInterval(function() {
	$('#timer').text(parseInt($('#timer').text()) + 1);
}, 100);
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="file" name="file" id="file" onchange="getBase64();">
<img src="" id="image" name="image" height="200px">
<input type="hidden" name="name" id="name">
<input type="button" value="上传" onclick="submit();">
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
function getBase64(){
	var file = document.getElementById("file").files[0];
    if (!/image\/\w+/.test(file.type)) {
        alert("请选择图片！");
        return false;
    }
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function(e) {
        $("#image").attr("src", this.result);
        $("#name").val(file.name);
    }
}
function submit(){
	var base64 = $("#image").attr("src");
	var name = $("#name").val();
	$.post("${pageContext.request.contextPath}/upload2",{image:base64,name:name},function(data){
		alert(data);
	});
}
</script>
</body>
</html>
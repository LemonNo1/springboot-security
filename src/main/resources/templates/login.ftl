<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>登录页面</h1>
	<form id="formData" action="/securityLogin" method="post">
		<span>用户名</span><input type="text" name="username" /> <br>
		<span>密码</span><input type="password" name="password" /> <br>
		<button onclick="submitss()">登录</button>
	</form>
<#if RequestParameters['error']??>
用户名或者密码错误
</#if>
</body>
<#--<script src="/webjars/jquery/3.0.0/jquery.js" type="text/javascript"></script>-->
<#--<script>
	function submitss() {
		$.ajax({
			url:"/securityLogin",
			data:$("#formData").serialize(),
			type:"post",
			dataType:"json",
			success:function (data) {
				debugger
				if(data.success){
					window.location.href="/index";
				}else{
					alert("cuowu");
				}
			}
		})
	}
</script>-->
</html>
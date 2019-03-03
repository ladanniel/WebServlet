<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 20px; color: blue;">
	<form action="bmi.do" method="get">
		<fieldset>
			<legend>计算bmi指数</legend>
			身高（m）：<input name="height"> 
			体重（kg）：<input name="weight">
			<input type="submit" value="提交">
		</fieldset>
	</form>
</body>
</html>
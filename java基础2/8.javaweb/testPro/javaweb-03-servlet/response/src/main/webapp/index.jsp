<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
</head>
<body>
<h2>Hello World!</h2>


<form action="${pageContext.request.getContextPath()}/login" method="get">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
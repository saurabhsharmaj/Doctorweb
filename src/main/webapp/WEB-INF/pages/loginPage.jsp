<html>
<head><title>Login</title></head>
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/main.css">
<body>
<jsp:include page="header.jsp" />
 <h1>Login</h1>
 <form name='f' action="j_spring_security_check" method='POST'>
    <table>
       <tr>
          <td>User:</td>
          <td><input type='text' name='username' value=''></td>
       </tr>
       <tr>
          <td>Password:</td>
          <td><input type='password' name='password' /></td>
       </tr>
       <tr>
          <td><input name="submit" type="submit" value="submit" /></td>
       </tr>
    </table>
</form>
<a href="registration">sign up</a>
</body>
</html>
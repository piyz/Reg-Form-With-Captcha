<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 16.01.2018
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reg page</title>
</head>
<body>
    <form method="post" action="page">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" required></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" required></td>
            </tr>
            <tr>
                <td>Captcha</td>
                <td><img src="captcha-image"></td>
                <td><input type="text" name="captcha"></td>
                ${error}
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>

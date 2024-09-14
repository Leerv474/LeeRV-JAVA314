<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>
    Регистрация пользователя
</h2>
<form action="registration" method="post">
    <table class="content">
        <tr>
            <td>Имя пользователя</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Загеристрироваться" class="submit"></td>
            <td><input type="reset" value="Сбросить" class="reset"></td>
        </tr>
    </table>

</form>
<a href="/userList">Список пользователей</a>
</body>
</html>
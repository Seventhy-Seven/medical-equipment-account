<!DOCTYPE html>
<html lang="en">
<head>
    <title>Вход</title>
    <#include "style.ftlh">

    <style>
            form{display: flex;
                     flex-flow: row nowrap;
                     justify-content: center;
                     margin-top: 250px;}
            .password_label{margin-left:10px;}
    </style>
</head>
<body>
<form action="/" method="post">
    <label> Логин: <input type="text" name="position" required/> </label>
    <label class="password_label"> Пароль: <input type="password" name="password" required/> </label>
    <button class="password_label" type="submit" value="Sign In">Войти</button>
</form>
</body>
</html>
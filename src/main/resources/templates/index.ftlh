<!DOCTYPE html>
<html lang="en">
<head>
    <title>Главная</title>
    <#include "style.ftlh">
    <style>
        body {
            background-image: url('https://img.freepik.com/premium-vector/medical-pharmaceutical-hospital-device-set-of-drawings-vector-illustration-hand-drawn_414360-3267.jpg?w=740');
            background-repeat: no-repeat;
            background-size: cover;
        }

        .btn{display: flex;
               justify-content: space-evenly;}
         .btn_blocks{    width: 650px;
                         height: 50px;
                         border-radius: 20px;
                         background-color: lightblue;
                         font-size: 18px;
                         font-weight: bold;}
    </style>
</head>
<body>
<p>
<form>
    <div class="btn">

        <a href="/equip"><button  class="btn_blocks" type="button">Оборудование</button></a>
        <a href="/equip_repair"><button  class="btn_blocks" type="button">Оборудование в ремонте</button></a>
    </div>
</form>
</body>
</html>